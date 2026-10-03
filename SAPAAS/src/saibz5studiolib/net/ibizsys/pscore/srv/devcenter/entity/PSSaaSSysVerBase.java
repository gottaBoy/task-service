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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysAPI;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysApp;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAPIService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryItem;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepo;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryItemService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSSaaSSysDB;
import net.ibizsys.pscore.srv.sysdeploy.service.PSSaaSSysDBService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSaaSSysVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBTYPES = "DBTYPES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSVERID = "PSDEVSLNSYSVERID";
    public static final String FIELD_PSDEVSLNSYSVERNAME = "PSDEVSLNSYSVERNAME";
    public static final String FIELD_PSREGISTRYITEMID = "PSREGISTRYITEMID";
    public static final String FIELD_PSREGISTRYITEMNAME = "PSREGISTRYITEMNAME";
    public static final String FIELD_PSREGISTRYREPOID = "PSREGISTRYREPOID";
    public static final String FIELD_PSREGISTRYREPONAME = "PSREGISTRYREPONAME";
    public static final String FIELD_PSSAASSYSID = "PSSAASSYSID";
    public static final String FIELD_PSSAASSYSNAME = "PSSAASSYSNAME";
    public static final String FIELD_PSSAASSYSVERID = "PSSAASSYSVERID";
    public static final String FIELD_PSSAASSYSVERNAME = "PSSAASSYSVERNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERTAG = "VERTAG";
    public static final String FIELD_VERTAG2 = "VERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DBTYPES = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVSLNSYSID = 4;
    private static final int INDEX_PSDEVSLNSYSNAME = 5;
    private static final int INDEX_PSDEVSLNSYSVERID = 6;
    private static final int INDEX_PSDEVSLNSYSVERNAME = 7;
    private static final int INDEX_PSREGISTRYITEMID = 8;
    private static final int INDEX_PSREGISTRYITEMNAME = 9;
    private static final int INDEX_PSREGISTRYREPOID = 10;
    private static final int INDEX_PSREGISTRYREPONAME = 11;
    private static final int INDEX_PSSAASSYSID = 12;
    private static final int INDEX_PSSAASSYSNAME = 13;
    private static final int INDEX_PSSAASSYSVERID = 14;
    private static final int INDEX_PSSAASSYSVERNAME = 15;
    private static final int INDEX_PSSYSMODELINSTID = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final int INDEX_VALIDFLAG = 24;
    private static final int INDEX_VERTAG = 25;
    private static final int INDEX_VERTAG2 = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSaaSSysVerBase proxyPSSaaSSysVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbtypesDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsysveridDirtyFlag = false;
    private boolean psdevslnsysvernameDirtyFlag = false;
    private boolean psregistryitemidDirtyFlag = false;
    private boolean psregistryitemnameDirtyFlag = false;
    private boolean psregistryrepoidDirtyFlag = false;
    private boolean psregistryreponameDirtyFlag = false;
    private boolean pssaassysidDirtyFlag = false;
    private boolean pssaassysnameDirtyFlag = false;
    private boolean pssaassysveridDirtyFlag = false;
    private boolean pssaassysvernameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean vertagDirtyFlag = false;
    private boolean vertag2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbtypes")
    private String dbtypes;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsysverid")
    private String psdevslnsysverid;
    @Column(name="psdevslnsysvername")
    private String psdevslnsysvername;
    @Column(name="psregistryitemid")
    private String psregistryitemid;
    @Column(name="psregistryitemname")
    private String psregistryitemname;
    @Column(name="psregistryrepoid")
    private String psregistryrepoid;
    @Column(name="psregistryreponame")
    private String psregistryreponame;
    @Column(name="pssaassysid")
    private String pssaassysid;
    @Column(name="pssaassysname")
    private String pssaassysname;
    @Column(name="pssaassysverid")
    private String pssaassysverid;
    @Column(name="pssaassysvername")
    private String pssaassysvername;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
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
    @Column(name="vertag")
    private String vertag;
    @Column(name="vertag2")
    private String vertag2;
    private Integer objPSDevSlnSysVerLock = new Integer(1);
    private PSDevSlnSysVer psdevslnsysver = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSRegistryItemLock = new Integer(1);
    private PSRegistryItem psregistryitem = null;
    private Integer objPSRegistryRepoLock = new Integer(1);
    private PSRegistryRepo psregistryrepo = null;
    private Integer objPSSaaSSysLock = new Integer(1);
    private PSSaaSSys pssaassys = null;
    private Integer objPSSaaSSysAPIsLock = new Integer(1);
    private ArrayList<PSSaaSSysAPI> pssaassysapis = null;
    private Integer objPSSaaSSysAppsLock = new Integer(1);
    private ArrayList<PSSaaSSysApp> pssaassysapps = null;
    private Integer objPSSaaSSysDBsLock = new Integer(1);
    private ArrayList<PSSaaSSysDB> pssaassysdbs = null;

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

    public void setDBTypes(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBTypes(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtypes = string;
        this.dbtypesDirtyFlag = true;
    }

    public String getDBTypes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBTypes();
        }
        return this.dbtypes;
    }

    public boolean isDBTypesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypesDirty();
        }
        return this.dbtypesDirtyFlag;
    }

    public void resetDBTypes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBTypes();
            return;
        }
        this.dbtypesDirtyFlag = false;
        this.dbtypes = null;
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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSlnSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysverid = string;
        this.psdevslnsysveridDirtyFlag = true;
    }

    public String getPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerId();
        }
        return this.psdevslnsysverid;
    }

    public boolean isPSDevSlnSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerIdDirty();
        }
        return this.psdevslnsysveridDirtyFlag;
    }

    public void resetPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerId();
            return;
        }
        this.psdevslnsysveridDirtyFlag = false;
        this.psdevslnsysverid = null;
    }

    public void setPSDevSlnSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysvername = string;
        this.psdevslnsysvernameDirtyFlag = true;
    }

    public String getPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerName();
        }
        return this.psdevslnsysvername;
    }

    public boolean isPSDevSlnSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerNameDirty();
        }
        return this.psdevslnsysvernameDirtyFlag;
    }

    public void resetPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerName();
            return;
        }
        this.psdevslnsysvernameDirtyFlag = false;
        this.psdevslnsysvername = null;
    }

    public void setPSRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryitemid = string;
        this.psregistryitemidDirtyFlag = true;
    }

    public String getPSRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryItemId();
        }
        return this.psregistryitemid;
    }

    public boolean isPSRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryItemIdDirty();
        }
        return this.psregistryitemidDirtyFlag;
    }

    public void resetPSRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryItemId();
            return;
        }
        this.psregistryitemidDirtyFlag = false;
        this.psregistryitemid = null;
    }

    public void setPSRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryitemname = string;
        this.psregistryitemnameDirtyFlag = true;
    }

    public String getPSRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryItemName();
        }
        return this.psregistryitemname;
    }

    public boolean isPSRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryItemNameDirty();
        }
        return this.psregistryitemnameDirtyFlag;
    }

    public void resetPSRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryItemName();
            return;
        }
        this.psregistryitemnameDirtyFlag = false;
        this.psregistryitemname = null;
    }

    public void setPSRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryrepoid = string;
        this.psregistryrepoidDirtyFlag = true;
    }

    public String getPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoId();
        }
        return this.psregistryrepoid;
    }

    public boolean isPSRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoIdDirty();
        }
        return this.psregistryrepoidDirtyFlag;
    }

    public void resetPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoId();
            return;
        }
        this.psregistryrepoidDirtyFlag = false;
        this.psregistryrepoid = null;
    }

    public void setPSRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryreponame = string;
        this.psregistryreponameDirtyFlag = true;
    }

    public String getPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoName();
        }
        return this.psregistryreponame;
    }

    public boolean isPSRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoNameDirty();
        }
        return this.psregistryreponameDirtyFlag;
    }

    public void resetPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoName();
            return;
        }
        this.psregistryreponameDirtyFlag = false;
        this.psregistryreponame = null;
    }

    public void setPSSaaSSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysid = string;
        this.pssaassysidDirtyFlag = true;
    }

    public String getPSSaaSSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysId();
        }
        return this.pssaassysid;
    }

    public boolean isPSSaaSSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysIdDirty();
        }
        return this.pssaassysidDirtyFlag;
    }

    public void resetPSSaaSSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysId();
            return;
        }
        this.pssaassysidDirtyFlag = false;
        this.pssaassysid = null;
    }

    public void setPSSaaSSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysname = string;
        this.pssaassysnameDirtyFlag = true;
    }

    public String getPSSaaSSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysName();
        }
        return this.pssaassysname;
    }

    public boolean isPSSaaSSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysNameDirty();
        }
        return this.pssaassysnameDirtyFlag;
    }

    public void resetPSSaaSSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysName();
            return;
        }
        this.pssaassysnameDirtyFlag = false;
        this.pssaassysname = null;
    }

    public void setPSSaaSSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysverid = string;
        this.pssaassysveridDirtyFlag = true;
    }

    public String getPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerId();
        }
        return this.pssaassysverid;
    }

    public boolean isPSSaaSSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerIdDirty();
        }
        return this.pssaassysveridDirtyFlag;
    }

    public void resetPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerId();
            return;
        }
        this.pssaassysveridDirtyFlag = false;
        this.pssaassysverid = null;
    }

    public void setPSSaaSSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysvername = string;
        this.pssaassysvernameDirtyFlag = true;
    }

    public String getPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerName();
        }
        return this.pssaassysvername;
    }

    public boolean isPSSaaSSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerNameDirty();
        }
        return this.pssaassysvernameDirtyFlag;
    }

    public void resetPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerName();
            return;
        }
        this.pssaassysvernameDirtyFlag = false;
        this.pssaassysvername = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
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

    public void setVerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag = string;
        this.vertagDirtyFlag = true;
    }

    public String getVerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag();
        }
        return this.vertag;
    }

    public boolean isVerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTagDirty();
        }
        return this.vertagDirtyFlag;
    }

    public void resetVerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag();
            return;
        }
        this.vertagDirtyFlag = false;
        this.vertag = null;
    }

    public void setVerTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag2 = string;
        this.vertag2DirtyFlag = true;
    }

    public String getVerTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag2();
        }
        return this.vertag2;
    }

    public boolean isVerTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTag2Dirty();
        }
        return this.vertag2DirtyFlag;
    }

    public void resetVerTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag2();
            return;
        }
        this.vertag2DirtyFlag = false;
        this.vertag2 = null;
    }

    protected void onReset() {
        PSSaaSSysVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSaaSSysVerBase pSSaaSSysVerBase) {
        pSSaaSSysVerBase.resetCreateDate();
        pSSaaSSysVerBase.resetCreateMan();
        pSSaaSSysVerBase.resetDBTypes();
        pSSaaSSysVerBase.resetMemo();
        pSSaaSSysVerBase.resetPSDevSlnSysId();
        pSSaaSSysVerBase.resetPSDevSlnSysName();
        pSSaaSSysVerBase.resetPSDevSlnSysVerId();
        pSSaaSSysVerBase.resetPSDevSlnSysVerName();
        pSSaaSSysVerBase.resetPSRegistryItemId();
        pSSaaSSysVerBase.resetPSRegistryItemName();
        pSSaaSSysVerBase.resetPSRegistryRepoId();
        pSSaaSSysVerBase.resetPSRegistryRepoName();
        pSSaaSSysVerBase.resetPSSaaSSysId();
        pSSaaSSysVerBase.resetPSSaaSSysName();
        pSSaaSSysVerBase.resetPSSaaSSysVerId();
        pSSaaSSysVerBase.resetPSSaaSSysVerName();
        pSSaaSSysVerBase.resetPSSysModelInstId();
        pSSaaSSysVerBase.resetUpdateDate();
        pSSaaSSysVerBase.resetUpdateMan();
        pSSaaSSysVerBase.resetUserCat();
        pSSaaSSysVerBase.resetUserTag();
        pSSaaSSysVerBase.resetUserTag2();
        pSSaaSSysVerBase.resetUserTag3();
        pSSaaSSysVerBase.resetUserTag4();
        pSSaaSSysVerBase.resetValidFlag();
        pSSaaSSysVerBase.resetVerTag();
        pSSaaSSysVerBase.resetVerTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBTypesDirty()) {
            hashMap.put(FIELD_DBTYPES, this.getDBTypes());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERID, this.getPSDevSlnSysVerId());
        }
        if (!bl || this.isPSDevSlnSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERNAME, this.getPSDevSlnSysVerName());
        }
        if (!bl || this.isPSRegistryItemIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYITEMID, this.getPSRegistryItemId());
        }
        if (!bl || this.isPSRegistryItemNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYITEMNAME, this.getPSRegistryItemName());
        }
        if (!bl || this.isPSRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPOID, this.getPSRegistryRepoId());
        }
        if (!bl || this.isPSRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPONAME, this.getPSRegistryRepoName());
        }
        if (!bl || this.isPSSaaSSysIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSID, this.getPSSaaSSysId());
        }
        if (!bl || this.isPSSaaSSysNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSNAME, this.getPSSaaSSysName());
        }
        if (!bl || this.isPSSaaSSysVerIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERID, this.getPSSaaSSysVerId());
        }
        if (!bl || this.isPSSaaSSysVerNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERNAME, this.getPSSaaSSysVerName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
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
        if (!bl || this.isVerTagDirty()) {
            hashMap.put(FIELD_VERTAG, this.getVerTag());
        }
        if (!bl || this.isVerTag2Dirty()) {
            hashMap.put(FIELD_VERTAG2, this.getVerTag2());
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
        return PSSaaSSysVerBase.get(this, n);
    }

    private static Object get(PSSaaSSysVerBase pSSaaSSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysVerBase.getCreateDate();
            }
            case 1: {
                return pSSaaSSysVerBase.getCreateMan();
            }
            case 2: {
                return pSSaaSSysVerBase.getDBTypes();
            }
            case 3: {
                return pSSaaSSysVerBase.getMemo();
            }
            case 4: {
                return pSSaaSSysVerBase.getPSDevSlnSysId();
            }
            case 5: {
                return pSSaaSSysVerBase.getPSDevSlnSysName();
            }
            case 6: {
                return pSSaaSSysVerBase.getPSDevSlnSysVerId();
            }
            case 7: {
                return pSSaaSSysVerBase.getPSDevSlnSysVerName();
            }
            case 8: {
                return pSSaaSSysVerBase.getPSRegistryItemId();
            }
            case 9: {
                return pSSaaSSysVerBase.getPSRegistryItemName();
            }
            case 10: {
                return pSSaaSSysVerBase.getPSRegistryRepoId();
            }
            case 11: {
                return pSSaaSSysVerBase.getPSRegistryRepoName();
            }
            case 12: {
                return pSSaaSSysVerBase.getPSSaaSSysId();
            }
            case 13: {
                return pSSaaSSysVerBase.getPSSaaSSysName();
            }
            case 14: {
                return pSSaaSSysVerBase.getPSSaaSSysVerId();
            }
            case 15: {
                return pSSaaSSysVerBase.getPSSaaSSysVerName();
            }
            case 16: {
                return pSSaaSSysVerBase.getPSSysModelInstId();
            }
            case 17: {
                return pSSaaSSysVerBase.getUpdateDate();
            }
            case 18: {
                return pSSaaSSysVerBase.getUpdateMan();
            }
            case 19: {
                return pSSaaSSysVerBase.getUserCat();
            }
            case 20: {
                return pSSaaSSysVerBase.getUserTag();
            }
            case 21: {
                return pSSaaSSysVerBase.getUserTag2();
            }
            case 22: {
                return pSSaaSSysVerBase.getUserTag3();
            }
            case 23: {
                return pSSaaSSysVerBase.getUserTag4();
            }
            case 24: {
                return pSSaaSSysVerBase.getValidFlag();
            }
            case 25: {
                return pSSaaSSysVerBase.getVerTag();
            }
            case 26: {
                return pSSaaSSysVerBase.getVerTag2();
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
        PSSaaSSysVerBase.set(this, n, object);
    }

    private static void set(PSSaaSSysVerBase pSSaaSSysVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSaaSSysVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSaaSSysVerBase.setDBTypes(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSaaSSysVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSaaSSysVerBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSaaSSysVerBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSaaSSysVerBase.setPSDevSlnSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSaaSSysVerBase.setPSDevSlnSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSaaSSysVerBase.setPSRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSaaSSysVerBase.setPSRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSaaSSysVerBase.setPSRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSaaSSysVerBase.setPSRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSaaSSysVerBase.setPSSaaSSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSaaSSysVerBase.setPSSaaSSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSaaSSysVerBase.setPSSaaSSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSaaSSysVerBase.setPSSaaSSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSaaSSysVerBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSaaSSysVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSSaaSSysVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSaaSSysVerBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSaaSSysVerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSaaSSysVerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSaaSSysVerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSaaSSysVerBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSaaSSysVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSaaSSysVerBase.setVerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSaaSSysVerBase.setVerTag2(DataObject.getStringValue((Object)object));
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
        return PSSaaSSysVerBase.isNull(this, n);
    }

    private static boolean isNull(PSSaaSSysVerBase pSSaaSSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSaaSSysVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSaaSSysVerBase.getDBTypes() == null;
            }
            case 3: {
                return pSSaaSSysVerBase.getMemo() == null;
            }
            case 4: {
                return pSSaaSSysVerBase.getPSDevSlnSysId() == null;
            }
            case 5: {
                return pSSaaSSysVerBase.getPSDevSlnSysName() == null;
            }
            case 6: {
                return pSSaaSSysVerBase.getPSDevSlnSysVerId() == null;
            }
            case 7: {
                return pSSaaSSysVerBase.getPSDevSlnSysVerName() == null;
            }
            case 8: {
                return pSSaaSSysVerBase.getPSRegistryItemId() == null;
            }
            case 9: {
                return pSSaaSSysVerBase.getPSRegistryItemName() == null;
            }
            case 10: {
                return pSSaaSSysVerBase.getPSRegistryRepoId() == null;
            }
            case 11: {
                return pSSaaSSysVerBase.getPSRegistryRepoName() == null;
            }
            case 12: {
                return pSSaaSSysVerBase.getPSSaaSSysId() == null;
            }
            case 13: {
                return pSSaaSSysVerBase.getPSSaaSSysName() == null;
            }
            case 14: {
                return pSSaaSSysVerBase.getPSSaaSSysVerId() == null;
            }
            case 15: {
                return pSSaaSSysVerBase.getPSSaaSSysVerName() == null;
            }
            case 16: {
                return pSSaaSSysVerBase.getPSSysModelInstId() == null;
            }
            case 17: {
                return pSSaaSSysVerBase.getUpdateDate() == null;
            }
            case 18: {
                return pSSaaSSysVerBase.getUpdateMan() == null;
            }
            case 19: {
                return pSSaaSSysVerBase.getUserCat() == null;
            }
            case 20: {
                return pSSaaSSysVerBase.getUserTag() == null;
            }
            case 21: {
                return pSSaaSSysVerBase.getUserTag2() == null;
            }
            case 22: {
                return pSSaaSSysVerBase.getUserTag3() == null;
            }
            case 23: {
                return pSSaaSSysVerBase.getUserTag4() == null;
            }
            case 24: {
                return pSSaaSSysVerBase.getValidFlag() == null;
            }
            case 25: {
                return pSSaaSSysVerBase.getVerTag() == null;
            }
            case 26: {
                return pSSaaSSysVerBase.getVerTag2() == null;
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
        return PSSaaSSysVerBase.contains(this, n);
    }

    private static boolean contains(PSSaaSSysVerBase pSSaaSSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSaaSSysVerBase.isCreateManDirty();
            }
            case 2: {
                return pSSaaSSysVerBase.isDBTypesDirty();
            }
            case 3: {
                return pSSaaSSysVerBase.isMemoDirty();
            }
            case 4: {
                return pSSaaSSysVerBase.isPSDevSlnSysIdDirty();
            }
            case 5: {
                return pSSaaSSysVerBase.isPSDevSlnSysNameDirty();
            }
            case 6: {
                return pSSaaSSysVerBase.isPSDevSlnSysVerIdDirty();
            }
            case 7: {
                return pSSaaSSysVerBase.isPSDevSlnSysVerNameDirty();
            }
            case 8: {
                return pSSaaSSysVerBase.isPSRegistryItemIdDirty();
            }
            case 9: {
                return pSSaaSSysVerBase.isPSRegistryItemNameDirty();
            }
            case 10: {
                return pSSaaSSysVerBase.isPSRegistryRepoIdDirty();
            }
            case 11: {
                return pSSaaSSysVerBase.isPSRegistryRepoNameDirty();
            }
            case 12: {
                return pSSaaSSysVerBase.isPSSaaSSysIdDirty();
            }
            case 13: {
                return pSSaaSSysVerBase.isPSSaaSSysNameDirty();
            }
            case 14: {
                return pSSaaSSysVerBase.isPSSaaSSysVerIdDirty();
            }
            case 15: {
                return pSSaaSSysVerBase.isPSSaaSSysVerNameDirty();
            }
            case 16: {
                return pSSaaSSysVerBase.isPSSysModelInstIdDirty();
            }
            case 17: {
                return pSSaaSSysVerBase.isUpdateDateDirty();
            }
            case 18: {
                return pSSaaSSysVerBase.isUpdateManDirty();
            }
            case 19: {
                return pSSaaSSysVerBase.isUserCatDirty();
            }
            case 20: {
                return pSSaaSSysVerBase.isUserTagDirty();
            }
            case 21: {
                return pSSaaSSysVerBase.isUserTag2Dirty();
            }
            case 22: {
                return pSSaaSSysVerBase.isUserTag3Dirty();
            }
            case 23: {
                return pSSaaSSysVerBase.isUserTag4Dirty();
            }
            case 24: {
                return pSSaaSSysVerBase.isValidFlagDirty();
            }
            case 25: {
                return pSSaaSSysVerBase.isVerTagDirty();
            }
            case 26: {
                return pSSaaSSysVerBase.isVerTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSaaSSysVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSaaSSysVerBase pSSaaSSysVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSaaSSysVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getDBTypes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtypes", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getDBTypes()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSDevSlnSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysverid", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSDevSlnSysVerId()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSDevSlnSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysvername", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSDevSlnSysVerName()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryitemid", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSRegistryItemId()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryitemname", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSRegistryItemName()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryrepoid", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSRegistryRepoId()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryreponame", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSRegistryRepoName()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSSaaSSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysid", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSSaaSSysId()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSSaaSSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysname", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSSaaSSysName()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSSaaSSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysverid", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSSaaSSysVerId()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSSaaSSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysvername", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSSaaSSysVerName()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getVerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getVerTag()), (boolean)false);
        }
        if (bl || pSSaaSSysVerBase.getVerTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag2", (Object)PSSaaSSysVerBase.getJSONValue((Object)pSSaaSSysVerBase.getVerTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSaaSSysVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSaaSSysVerBase pSSaaSSysVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSaaSSysVerBase.getCreateDate() != null) {
            object = pSSaaSSysVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysVerBase.getCreateMan() != null) {
            object = pSSaaSSysVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getDBTypes() != null) {
            object = pSSaaSSysVerBase.getDBTypes();
            xmlNode.setAttribute(FIELD_DBTYPES, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getMemo() != null) {
            object = pSSaaSSysVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSDevSlnSysId() != null) {
            object = pSSaaSSysVerBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSDevSlnSysName() != null) {
            object = pSSaaSSysVerBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSDevSlnSysVerId() != null) {
            object = pSSaaSSysVerBase.getPSDevSlnSysVerId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSDevSlnSysVerName() != null) {
            object = pSSaaSSysVerBase.getPSDevSlnSysVerName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSRegistryItemId() != null) {
            object = pSSaaSSysVerBase.getPSRegistryItemId();
            xmlNode.setAttribute(FIELD_PSREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSRegistryItemName() != null) {
            object = pSSaaSSysVerBase.getPSRegistryItemName();
            xmlNode.setAttribute(FIELD_PSREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSRegistryRepoId() != null) {
            object = pSSaaSSysVerBase.getPSRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSRegistryRepoName() != null) {
            object = pSSaaSSysVerBase.getPSRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSSaaSSysId() != null) {
            object = pSSaaSSysVerBase.getPSSaaSSysId();
            xmlNode.setAttribute(FIELD_PSSAASSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSSaaSSysName() != null) {
            object = pSSaaSSysVerBase.getPSSaaSSysName();
            xmlNode.setAttribute(FIELD_PSSAASSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSSaaSSysVerId() != null) {
            object = pSSaaSSysVerBase.getPSSaaSSysVerId();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSSaaSSysVerName() != null) {
            object = pSSaaSSysVerBase.getPSSaaSSysVerName();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getPSSysModelInstId() != null) {
            object = pSSaaSSysVerBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getUpdateDate() != null) {
            object = pSSaaSSysVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysVerBase.getUpdateMan() != null) {
            object = pSSaaSSysVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getUserCat() != null) {
            object = pSSaaSSysVerBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getUserTag() != null) {
            object = pSSaaSSysVerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getUserTag2() != null) {
            object = pSSaaSSysVerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getUserTag3() != null) {
            object = pSSaaSSysVerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getUserTag4() != null) {
            object = pSSaaSSysVerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getValidFlag() != null) {
            object = pSSaaSSysVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSaaSSysVerBase.getVerTag() != null) {
            object = pSSaaSSysVerBase.getVerTag();
            xmlNode.setAttribute(FIELD_VERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysVerBase.getVerTag2() != null) {
            object = pSSaaSSysVerBase.getVerTag2();
            xmlNode.setAttribute(FIELD_VERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSaaSSysVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSaaSSysVerBase pSSaaSSysVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSaaSSysVerBase.isCreateDateDirty() && (bl || pSSaaSSysVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSaaSSysVerBase.getCreateDate());
        }
        if (pSSaaSSysVerBase.isCreateManDirty() && (bl || pSSaaSSysVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSaaSSysVerBase.getCreateMan());
        }
        if (pSSaaSSysVerBase.isDBTypesDirty() && (bl || pSSaaSSysVerBase.getDBTypes() != null)) {
            iDataObject.set(FIELD_DBTYPES, (Object)pSSaaSSysVerBase.getDBTypes());
        }
        if (pSSaaSSysVerBase.isMemoDirty() && (bl || pSSaaSSysVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSaaSSysVerBase.getMemo());
        }
        if (pSSaaSSysVerBase.isPSDevSlnSysIdDirty() && (bl || pSSaaSSysVerBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSSaaSSysVerBase.getPSDevSlnSysId());
        }
        if (pSSaaSSysVerBase.isPSDevSlnSysNameDirty() && (bl || pSSaaSSysVerBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSSaaSSysVerBase.getPSDevSlnSysName());
        }
        if (pSSaaSSysVerBase.isPSDevSlnSysVerIdDirty() && (bl || pSSaaSSysVerBase.getPSDevSlnSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERID, (Object)pSSaaSSysVerBase.getPSDevSlnSysVerId());
        }
        if (pSSaaSSysVerBase.isPSDevSlnSysVerNameDirty() && (bl || pSSaaSSysVerBase.getPSDevSlnSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERNAME, (Object)pSSaaSSysVerBase.getPSDevSlnSysVerName());
        }
        if (pSSaaSSysVerBase.isPSRegistryItemIdDirty() && (bl || pSSaaSSysVerBase.getPSRegistryItemId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYITEMID, (Object)pSSaaSSysVerBase.getPSRegistryItemId());
        }
        if (pSSaaSSysVerBase.isPSRegistryItemNameDirty() && (bl || pSSaaSSysVerBase.getPSRegistryItemName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYITEMNAME, (Object)pSSaaSSysVerBase.getPSRegistryItemName());
        }
        if (pSSaaSSysVerBase.isPSRegistryRepoIdDirty() && (bl || pSSaaSSysVerBase.getPSRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPOID, (Object)pSSaaSSysVerBase.getPSRegistryRepoId());
        }
        if (pSSaaSSysVerBase.isPSRegistryRepoNameDirty() && (bl || pSSaaSSysVerBase.getPSRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPONAME, (Object)pSSaaSSysVerBase.getPSRegistryRepoName());
        }
        if (pSSaaSSysVerBase.isPSSaaSSysIdDirty() && (bl || pSSaaSSysVerBase.getPSSaaSSysId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSID, (Object)pSSaaSSysVerBase.getPSSaaSSysId());
        }
        if (pSSaaSSysVerBase.isPSSaaSSysNameDirty() && (bl || pSSaaSSysVerBase.getPSSaaSSysName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSNAME, (Object)pSSaaSSysVerBase.getPSSaaSSysName());
        }
        if (pSSaaSSysVerBase.isPSSaaSSysVerIdDirty() && (bl || pSSaaSSysVerBase.getPSSaaSSysVerId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERID, (Object)pSSaaSSysVerBase.getPSSaaSSysVerId());
        }
        if (pSSaaSSysVerBase.isPSSaaSSysVerNameDirty() && (bl || pSSaaSSysVerBase.getPSSaaSSysVerName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERNAME, (Object)pSSaaSSysVerBase.getPSSaaSSysVerName());
        }
        if (pSSaaSSysVerBase.isPSSysModelInstIdDirty() && (bl || pSSaaSSysVerBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSaaSSysVerBase.getPSSysModelInstId());
        }
        if (pSSaaSSysVerBase.isUpdateDateDirty() && (bl || pSSaaSSysVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSaaSSysVerBase.getUpdateDate());
        }
        if (pSSaaSSysVerBase.isUpdateManDirty() && (bl || pSSaaSSysVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSaaSSysVerBase.getUpdateMan());
        }
        if (pSSaaSSysVerBase.isUserCatDirty() && (bl || pSSaaSSysVerBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSaaSSysVerBase.getUserCat());
        }
        if (pSSaaSSysVerBase.isUserTagDirty() && (bl || pSSaaSSysVerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSaaSSysVerBase.getUserTag());
        }
        if (pSSaaSSysVerBase.isUserTag2Dirty() && (bl || pSSaaSSysVerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSaaSSysVerBase.getUserTag2());
        }
        if (pSSaaSSysVerBase.isUserTag3Dirty() && (bl || pSSaaSSysVerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSaaSSysVerBase.getUserTag3());
        }
        if (pSSaaSSysVerBase.isUserTag4Dirty() && (bl || pSSaaSSysVerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSaaSSysVerBase.getUserTag4());
        }
        if (pSSaaSSysVerBase.isValidFlagDirty() && (bl || pSSaaSSysVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSaaSSysVerBase.getValidFlag());
        }
        if (pSSaaSSysVerBase.isVerTagDirty() && (bl || pSSaaSSysVerBase.getVerTag() != null)) {
            iDataObject.set(FIELD_VERTAG, (Object)pSSaaSSysVerBase.getVerTag());
        }
        if (pSSaaSSysVerBase.isVerTag2Dirty() && (bl || pSSaaSSysVerBase.getVerTag2() != null)) {
            iDataObject.set(FIELD_VERTAG2, (Object)pSSaaSSysVerBase.getVerTag2());
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
        return PSSaaSSysVerBase.remove(this, n);
    }

    private static boolean remove(PSSaaSSysVerBase pSSaaSSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSaaSSysVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSaaSSysVerBase.resetDBTypes();
                return true;
            }
            case 3: {
                pSSaaSSysVerBase.resetMemo();
                return true;
            }
            case 4: {
                pSSaaSSysVerBase.resetPSDevSlnSysId();
                return true;
            }
            case 5: {
                pSSaaSSysVerBase.resetPSDevSlnSysName();
                return true;
            }
            case 6: {
                pSSaaSSysVerBase.resetPSDevSlnSysVerId();
                return true;
            }
            case 7: {
                pSSaaSSysVerBase.resetPSDevSlnSysVerName();
                return true;
            }
            case 8: {
                pSSaaSSysVerBase.resetPSRegistryItemId();
                return true;
            }
            case 9: {
                pSSaaSSysVerBase.resetPSRegistryItemName();
                return true;
            }
            case 10: {
                pSSaaSSysVerBase.resetPSRegistryRepoId();
                return true;
            }
            case 11: {
                pSSaaSSysVerBase.resetPSRegistryRepoName();
                return true;
            }
            case 12: {
                pSSaaSSysVerBase.resetPSSaaSSysId();
                return true;
            }
            case 13: {
                pSSaaSSysVerBase.resetPSSaaSSysName();
                return true;
            }
            case 14: {
                pSSaaSSysVerBase.resetPSSaaSSysVerId();
                return true;
            }
            case 15: {
                pSSaaSSysVerBase.resetPSSaaSSysVerName();
                return true;
            }
            case 16: {
                pSSaaSSysVerBase.resetPSSysModelInstId();
                return true;
            }
            case 17: {
                pSSaaSSysVerBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSSaaSSysVerBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSSaaSSysVerBase.resetUserCat();
                return true;
            }
            case 20: {
                pSSaaSSysVerBase.resetUserTag();
                return true;
            }
            case 21: {
                pSSaaSSysVerBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSSaaSSysVerBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSSaaSSysVerBase.resetUserTag4();
                return true;
            }
            case 24: {
                pSSaaSSysVerBase.resetValidFlag();
                return true;
            }
            case 25: {
                pSSaaSSysVerBase.resetVerTag();
                return true;
            }
            case 26: {
                pSSaaSSysVerBase.resetVerTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysVer getPSDevSlnSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVer();
        }
        if (this.getPSDevSlnSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysVerLock;
        synchronized (n) {
            if (this.psdevslnsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysVerId(), (Object)this.psdevslnsysver.getPSDevSlnSysVerId()) != 0L) {
                this.psdevslnsysver = null;
            }
            if (this.psdevslnsysver == null) {
                PSDevSlnSysVer pSDevSlnSysVer = new PSDevSlnSysVer();
                pSDevSlnSysVer.setPSDevSlnSysVerId(this.getPSDevSlnSysVerId());
                PSDevSlnSysVerService pSDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysVerService.autoGet(pSDevSlnSysVer);
                this.psdevslnsysver = pSDevSlnSysVer;
            }
            return this.psdevslnsysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRegistryItem getPSRegistryItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryItem();
        }
        if (this.getPSRegistryItemId() == null) {
            return null;
        }
        Integer n = this.objPSRegistryItemLock;
        synchronized (n) {
            if (this.psregistryitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSRegistryItemId(), (Object)this.psregistryitem.getPSRegistryItemId()) != 0L) {
                this.psregistryitem = null;
            }
            if (this.psregistryitem == null) {
                PSRegistryItem pSRegistryItem = new PSRegistryItem();
                pSRegistryItem.setPSRegistryItemId(this.getPSRegistryItemId());
                PSRegistryItemService pSRegistryItemService = (PSRegistryItemService)ServiceGlobal.getService(PSRegistryItemService.class, (SessionFactory)this.getSessionFactory());
                pSRegistryItemService.autoGet(pSRegistryItem);
                this.psregistryitem = pSRegistryItem;
            }
            return this.psregistryitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRegistryRepo getPSRegistryRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepo();
        }
        if (this.getPSRegistryRepoId() == null) {
            return null;
        }
        Integer n = this.objPSRegistryRepoLock;
        synchronized (n) {
            if (this.psregistryrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSRegistryRepoId(), (Object)this.psregistryrepo.getPSRegistryRepoId()) != 0L) {
                this.psregistryrepo = null;
            }
            if (this.psregistryrepo == null) {
                PSRegistryRepo pSRegistryRepo = new PSRegistryRepo();
                pSRegistryRepo.setPSRegistryRepoId(this.getPSRegistryRepoId());
                PSRegistryRepoService pSRegistryRepoService = (PSRegistryRepoService)ServiceGlobal.getService(PSRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
                pSRegistryRepoService.autoGet(pSRegistryRepo);
                this.psregistryrepo = pSRegistryRepo;
            }
            return this.psregistryrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSys getPSSaaSSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSys();
        }
        if (this.getPSSaaSSysId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysLock;
        synchronized (n) {
            if (this.pssaassys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysId(), (Object)this.pssaassys.getPSSaaSSysId()) != 0L) {
                this.pssaassys = null;
            }
            if (this.pssaassys == null) {
                PSSaaSSys pSSaaSSys = new PSSaaSSys();
                pSSaaSSys.setPSSaaSSysId(this.getPSSaaSSysId());
                PSSaaSSysService pSSaaSSysService = (PSSaaSSysService)ServiceGlobal.getService(PSSaaSSysService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysService.autoGet(pSSaaSSys);
                this.pssaassys = pSSaaSSys;
            }
            return this.pssaassys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSaaSSysAPI> getPSSaaSSysAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAPIs();
        }
        if (this.getPSSaaSSysVerId() == null) {
            return null;
        }
        PSSaaSSysAPIService pSSaaSSysAPIService = (PSSaaSSysAPIService)ServiceGlobal.getService(PSSaaSSysAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSaaSSysAPIsLock;
        synchronized (n) {
            if (this.pssaassysapis == null) {
                this.pssaassysapis = pSSaaSSysAPIService.selectByPSSaaSSysVer(this);
            }
            return this.pssaassysapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSaaSSysApp> getPSSaaSSysApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysApps();
        }
        if (this.getPSSaaSSysVerId() == null) {
            return null;
        }
        PSSaaSSysAppService pSSaaSSysAppService = (PSSaaSSysAppService)ServiceGlobal.getService(PSSaaSSysAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSaaSSysAppsLock;
        synchronized (n) {
            if (this.pssaassysapps == null) {
                this.pssaassysapps = pSSaaSSysAppService.selectByPSSaaSSysVer(this);
            }
            return this.pssaassysapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSaaSSysDB> getPSSaaSSysDBs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysDBs();
        }
        if (this.getPSSaaSSysVerId() == null) {
            return null;
        }
        PSSaaSSysDBService pSSaaSSysDBService = (PSSaaSSysDBService)ServiceGlobal.getService(PSSaaSSysDBService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSaaSSysDBsLock;
        synchronized (n) {
            if (this.pssaassysdbs == null) {
                this.pssaassysdbs = pSSaaSSysDBService.selectByPSSaaSSysVer(this);
            }
            return this.pssaassysdbs;
        }
    }

    private PSSaaSSysVerBase getProxyEntity() {
        return this.proxyPSSaaSSysVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSaaSSysVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSaaSSysVerBase) {
            this.proxyPSSaaSSysVerBase = (PSSaaSSysVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DBTYPES, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERNAME, 7);
        fieldIndexMap.put(FIELD_PSREGISTRYITEMID, 8);
        fieldIndexMap.put(FIELD_PSREGISTRYITEMNAME, 9);
        fieldIndexMap.put(FIELD_PSREGISTRYREPOID, 10);
        fieldIndexMap.put(FIELD_PSREGISTRYREPONAME, 11);
        fieldIndexMap.put(FIELD_PSSAASSYSID, 12);
        fieldIndexMap.put(FIELD_PSSAASSYSNAME, 13);
        fieldIndexMap.put(FIELD_PSSAASSYSVERID, 14);
        fieldIndexMap.put(FIELD_PSSAASSYSVERNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
        fieldIndexMap.put(FIELD_VALIDFLAG, 24);
        fieldIndexMap.put(FIELD_VERTAG, 25);
        fieldIndexMap.put(FIELD_VERTAG2, 26);
    }
}

