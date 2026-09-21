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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PACKSTATE = "PACKSTATE";
    public static final String FIELD_PACKSYSMODELINST = "PACKSYSMODELINST";
    public static final String FIELD_PSDCREGISTRYITEMID = "PSDCREGISTRYITEMID";
    public static final String FIELD_PSDCREGISTRYITEMNAME = "PSDCREGISTRYITEMNAME";
    public static final String FIELD_PSDCREGISTRYREPOID = "PSDCREGISTRYREPOID";
    public static final String FIELD_PSDCREGISTRYREPONAME = "PSDCREGISTRYREPONAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVCENTERFILEID = "PSDEVCENTERFILEID";
    public static final String FIELD_PSDEVCENTERFILENAME = "PSDEVCENTERFILENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSVERID = "PSDEVSLNSYSVERID";
    public static final String FIELD_PSDEVSLNSYSVERNAME = "PSDEVSLNSYSVERNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERDETAIL = "VERDETAIL";
    public static final String FIELD_VERLOG = "VERLOG";
    public static final String FIELD_VERPSDEVSLNSYSID = "VERPSDEVSLNSYSID";
    public static final String FIELD_VERPSDEVSLNSYSNAME = "VERPSDEVSLNSYSNAME";
    public static final String FIELD_VERSION = "VERSION";
    public static final String FIELD_VERTAG = "VERTAG";
    public static final String FIELD_VERTAG2 = "VERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PACKSTATE = 3;
    private static final int INDEX_PACKSYSMODELINST = 4;
    private static final int INDEX_PSDCREGISTRYITEMID = 5;
    private static final int INDEX_PSDCREGISTRYITEMNAME = 6;
    private static final int INDEX_PSDCREGISTRYREPOID = 7;
    private static final int INDEX_PSDCREGISTRYREPONAME = 8;
    private static final int INDEX_PSDEVCENTERDBINSTID = 9;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 10;
    private static final int INDEX_PSDEVCENTERFILEID = 11;
    private static final int INDEX_PSDEVCENTERFILENAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_PSDEVSLNID = 15;
    private static final int INDEX_PSDEVSLNNAME = 16;
    private static final int INDEX_PSDEVSLNSYSID = 17;
    private static final int INDEX_PSDEVSLNSYSNAME = 18;
    private static final int INDEX_PSDEVSLNSYSVERID = 19;
    private static final int INDEX_PSDEVSLNSYSVERNAME = 20;
    private static final int INDEX_PSSYSMODELINSTID = 21;
    private static final int INDEX_PSSYSMODELINSTNAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final int INDEX_VALIDFLAG = 30;
    private static final int INDEX_VERDETAIL = 31;
    private static final int INDEX_VERLOG = 32;
    private static final int INDEX_VERPSDEVSLNSYSID = 33;
    private static final int INDEX_VERPSDEVSLNSYSNAME = 34;
    private static final int INDEX_VERSION = 35;
    private static final int INDEX_VERTAG = 36;
    private static final int INDEX_VERTAG2 = 37;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysVerBase proxyPSDevSlnSysVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean packstateDirtyFlag = false;
    private boolean packsysmodelinstDirtyFlag = false;
    private boolean psdcregistryitemidDirtyFlag = false;
    private boolean psdcregistryitemnameDirtyFlag = false;
    private boolean psdcregistryrepoidDirtyFlag = false;
    private boolean psdcregistryreponameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevcenterfileidDirtyFlag = false;
    private boolean psdevcenterfilenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsysveridDirtyFlag = false;
    private boolean psdevslnsysvernameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean verdetailDirtyFlag = false;
    private boolean verlogDirtyFlag = false;
    private boolean verpsdevslnsysidDirtyFlag = false;
    private boolean verpsdevslnsysnameDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    private boolean vertagDirtyFlag = false;
    private boolean vertag2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="packstate")
    private Integer packstate;
    @Column(name="packsysmodelinst")
    private Integer packsysmodelinst;
    @Column(name="psdcregistryitemid")
    private String psdcregistryitemid;
    @Column(name="psdcregistryitemname")
    private String psdcregistryitemname;
    @Column(name="psdcregistryrepoid")
    private String psdcregistryrepoid;
    @Column(name="psdcregistryreponame")
    private String psdcregistryreponame;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevcenterfileid")
    private String psdevcenterfileid;
    @Column(name="psdevcenterfilename")
    private String psdevcenterfilename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsysverid")
    private String psdevslnsysverid;
    @Column(name="psdevslnsysvername")
    private String psdevslnsysvername;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
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
    @Column(name="verdetail")
    private String verdetail;
    @Column(name="verlog")
    private String verlog;
    @Column(name="verpsdevslnsysid")
    private String verpsdevslnsysid;
    @Column(name="verpsdevslnsysname")
    private String verpsdevslnsysname;
    @Column(name="version")
    private String version;
    @Column(name="vertag")
    private String vertag;
    @Column(name="vertag2")
    private String vertag2;
    private Integer objPSDCRegistryItemLock = new Integer(1);
    private PSDCRegistryItem psdcregistryitem = null;
    private Integer objPSDCRegistryRepoLock = new Integer(1);
    private PSDCRegistryRepo psdcregistryrepo = null;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objPSDevCenterFileLock = new Integer(1);
    private PSDevCenterFile psdevcenterfile = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objVerPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys verpsdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;

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

    public void setPackState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPackState(n);
            return;
        }
        this.packstate = n;
        this.packstateDirtyFlag = true;
    }

    public Integer getPackState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPackState();
        }
        return this.packstate;
    }

    public boolean isPackStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPackStateDirty();
        }
        return this.packstateDirtyFlag;
    }

    public void resetPackState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPackState();
            return;
        }
        this.packstateDirtyFlag = false;
        this.packstate = null;
    }

    public void setPackSysModelInst(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPackSysModelInst(n);
            return;
        }
        this.packsysmodelinst = n;
        this.packsysmodelinstDirtyFlag = true;
    }

    public Integer getPackSysModelInst() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPackSysModelInst();
        }
        return this.packsysmodelinst;
    }

    public boolean isPackSysModelInstDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPackSysModelInstDirty();
        }
        return this.packsysmodelinstDirtyFlag;
    }

    public void resetPackSysModelInst() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPackSysModelInst();
            return;
        }
        this.packsysmodelinstDirtyFlag = false;
        this.packsysmodelinst = null;
    }

    public void setPSDCRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemid = string;
        this.psdcregistryitemidDirtyFlag = true;
    }

    public String getPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemId();
        }
        return this.psdcregistryitemid;
    }

    public boolean isPSDCRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemIdDirty();
        }
        return this.psdcregistryitemidDirtyFlag;
    }

    public void resetPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemId();
            return;
        }
        this.psdcregistryitemidDirtyFlag = false;
        this.psdcregistryitemid = null;
    }

    public void setPSDCRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemname = string;
        this.psdcregistryitemnameDirtyFlag = true;
    }

    public String getPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemName();
        }
        return this.psdcregistryitemname;
    }

    public boolean isPSDCRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemNameDirty();
        }
        return this.psdcregistryitemnameDirtyFlag;
    }

    public void resetPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemName();
            return;
        }
        this.psdcregistryitemnameDirtyFlag = false;
        this.psdcregistryitemname = null;
    }

    public void setPSDCRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryrepoid = string;
        this.psdcregistryrepoidDirtyFlag = true;
    }

    public String getPSDCRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepoId();
        }
        return this.psdcregistryrepoid;
    }

    public boolean isPSDCRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryRepoIdDirty();
        }
        return this.psdcregistryrepoidDirtyFlag;
    }

    public void resetPSDCRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryRepoId();
            return;
        }
        this.psdcregistryrepoidDirtyFlag = false;
        this.psdcregistryrepoid = null;
    }

    public void setPSDCRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryreponame = string;
        this.psdcregistryreponameDirtyFlag = true;
    }

    public String getPSDCRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepoName();
        }
        return this.psdcregistryreponame;
    }

    public boolean isPSDCRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryRepoNameDirty();
        }
        return this.psdcregistryreponameDirtyFlag;
    }

    public void resetPSDCRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryRepoName();
            return;
        }
        this.psdcregistryreponameDirtyFlag = false;
        this.psdcregistryreponame = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
    }

    public void setPSDevCenterFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterfileid = string;
        this.psdevcenterfileidDirtyFlag = true;
    }

    public String getPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterFileId();
        }
        return this.psdevcenterfileid;
    }

    public boolean isPSDevCenterFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterFileIdDirty();
        }
        return this.psdevcenterfileidDirtyFlag;
    }

    public void resetPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterFileId();
            return;
        }
        this.psdevcenterfileidDirtyFlag = false;
        this.psdevcenterfileid = null;
    }

    public void setPSDevCenterFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterfilename = string;
        this.psdevcenterfilenameDirtyFlag = true;
    }

    public String getPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterFileName();
        }
        return this.psdevcenterfilename;
    }

    public boolean isPSDevCenterFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterFileNameDirty();
        }
        return this.psdevcenterfilenameDirtyFlag;
    }

    public void resetPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterFileName();
            return;
        }
        this.psdevcenterfilenameDirtyFlag = false;
        this.psdevcenterfilename = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
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

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
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

    public void setVerDetail(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerDetail(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verdetail = string;
        this.verdetailDirtyFlag = true;
    }

    public String getVerDetail() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerDetail();
        }
        return this.verdetail;
    }

    public boolean isVerDetailDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerDetailDirty();
        }
        return this.verdetailDirtyFlag;
    }

    public void resetVerDetail() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerDetail();
            return;
        }
        this.verdetailDirtyFlag = false;
        this.verdetail = null;
    }

    public void setVerLog(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerLog(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verlog = string;
        this.verlogDirtyFlag = true;
    }

    public String getVerLog() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerLog();
        }
        return this.verlog;
    }

    public boolean isVerLogDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerLogDirty();
        }
        return this.verlogDirtyFlag;
    }

    public void resetVerLog() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerLog();
            return;
        }
        this.verlogDirtyFlag = false;
        this.verlog = null;
    }

    public void setVerPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verpsdevslnsysid = string;
        this.verpsdevslnsysidDirtyFlag = true;
    }

    public String getVerPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerPSDevSlnSysId();
        }
        return this.verpsdevslnsysid;
    }

    public boolean isVerPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerPSDevSlnSysIdDirty();
        }
        return this.verpsdevslnsysidDirtyFlag;
    }

    public void resetVerPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerPSDevSlnSysId();
            return;
        }
        this.verpsdevslnsysidDirtyFlag = false;
        this.verpsdevslnsysid = null;
    }

    public void setVerPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verpsdevslnsysname = string;
        this.verpsdevslnsysnameDirtyFlag = true;
    }

    public String getVerPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerPSDevSlnSysName();
        }
        return this.verpsdevslnsysname;
    }

    public boolean isVerPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerPSDevSlnSysNameDirty();
        }
        return this.verpsdevslnsysnameDirtyFlag;
    }

    public void resetVerPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerPSDevSlnSysName();
            return;
        }
        this.verpsdevslnsysnameDirtyFlag = false;
        this.verpsdevslnsysname = null;
    }

    public void setVersion(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.version = string;
        this.versionDirtyFlag = true;
    }

    public String getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
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
        PSDevSlnSysVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysVerBase pSDevSlnSysVerBase) {
        pSDevSlnSysVerBase.resetCreateDate();
        pSDevSlnSysVerBase.resetCreateMan();
        pSDevSlnSysVerBase.resetMemo();
        pSDevSlnSysVerBase.resetPackState();
        pSDevSlnSysVerBase.resetPackSysModelInst();
        pSDevSlnSysVerBase.resetPSDCRegistryItemId();
        pSDevSlnSysVerBase.resetPSDCRegistryItemName();
        pSDevSlnSysVerBase.resetPSDCRegistryRepoId();
        pSDevSlnSysVerBase.resetPSDCRegistryRepoName();
        pSDevSlnSysVerBase.resetPSDevCenterDBInstId();
        pSDevSlnSysVerBase.resetPSDevCenterDBInstName();
        pSDevSlnSysVerBase.resetPSDevCenterFileId();
        pSDevSlnSysVerBase.resetPSDevCenterFileName();
        pSDevSlnSysVerBase.resetPSDevCenterId();
        pSDevSlnSysVerBase.resetPSDevCenterName();
        pSDevSlnSysVerBase.resetPSDevSlnId();
        pSDevSlnSysVerBase.resetPSDevSlnName();
        pSDevSlnSysVerBase.resetPSDevSlnSysId();
        pSDevSlnSysVerBase.resetPSDevSlnSysName();
        pSDevSlnSysVerBase.resetPSDevSlnSysVerId();
        pSDevSlnSysVerBase.resetPSDevSlnSysVerName();
        pSDevSlnSysVerBase.resetPSSysModelInstId();
        pSDevSlnSysVerBase.resetPSSysModelInstName();
        pSDevSlnSysVerBase.resetUpdateDate();
        pSDevSlnSysVerBase.resetUpdateMan();
        pSDevSlnSysVerBase.resetUserCat();
        pSDevSlnSysVerBase.resetUserTag();
        pSDevSlnSysVerBase.resetUserTag2();
        pSDevSlnSysVerBase.resetUserTag3();
        pSDevSlnSysVerBase.resetUserTag4();
        pSDevSlnSysVerBase.resetValidFlag();
        pSDevSlnSysVerBase.resetVerDetail();
        pSDevSlnSysVerBase.resetVerLog();
        pSDevSlnSysVerBase.resetVerPSDevSlnSysId();
        pSDevSlnSysVerBase.resetVerPSDevSlnSysName();
        pSDevSlnSysVerBase.resetVersion();
        pSDevSlnSysVerBase.resetVerTag();
        pSDevSlnSysVerBase.resetVerTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPackStateDirty()) {
            hashMap.put(FIELD_PACKSTATE, this.getPackState());
        }
        if (!bl || this.isPackSysModelInstDirty()) {
            hashMap.put(FIELD_PACKSYSMODELINST, this.getPackSysModelInst());
        }
        if (!bl || this.isPSDCRegistryItemIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMID, this.getPSDCRegistryItemId());
        }
        if (!bl || this.isPSDCRegistryItemNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMNAME, this.getPSDCRegistryItemName());
        }
        if (!bl || this.isPSDCRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPOID, this.getPSDCRegistryRepoId());
        }
        if (!bl || this.isPSDCRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPONAME, this.getPSDCRegistryRepoName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevCenterFileIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERFILEID, this.getPSDevCenterFileId());
        }
        if (!bl || this.isPSDevCenterFileNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERFILENAME, this.getPSDevCenterFileName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
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
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
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
        if (!bl || this.isVerDetailDirty()) {
            hashMap.put(FIELD_VERDETAIL, this.getVerDetail());
        }
        if (!bl || this.isVerLogDirty()) {
            hashMap.put(FIELD_VERLOG, this.getVerLog());
        }
        if (!bl || this.isVerPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_VERPSDEVSLNSYSID, this.getVerPSDevSlnSysId());
        }
        if (!bl || this.isVerPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_VERPSDEVSLNSYSNAME, this.getVerPSDevSlnSysName());
        }
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
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
        return PSDevSlnSysVerBase.get(this, n);
    }

    private static Object get(PSDevSlnSysVerBase pSDevSlnSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysVerBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysVerBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysVerBase.getMemo();
            }
            case 3: {
                return pSDevSlnSysVerBase.getPackState();
            }
            case 4: {
                return pSDevSlnSysVerBase.getPackSysModelInst();
            }
            case 5: {
                return pSDevSlnSysVerBase.getPSDCRegistryItemId();
            }
            case 6: {
                return pSDevSlnSysVerBase.getPSDCRegistryItemName();
            }
            case 7: {
                return pSDevSlnSysVerBase.getPSDCRegistryRepoId();
            }
            case 8: {
                return pSDevSlnSysVerBase.getPSDCRegistryRepoName();
            }
            case 9: {
                return pSDevSlnSysVerBase.getPSDevCenterDBInstId();
            }
            case 10: {
                return pSDevSlnSysVerBase.getPSDevCenterDBInstName();
            }
            case 11: {
                return pSDevSlnSysVerBase.getPSDevCenterFileId();
            }
            case 12: {
                return pSDevSlnSysVerBase.getPSDevCenterFileName();
            }
            case 13: {
                return pSDevSlnSysVerBase.getPSDevCenterId();
            }
            case 14: {
                return pSDevSlnSysVerBase.getPSDevCenterName();
            }
            case 15: {
                return pSDevSlnSysVerBase.getPSDevSlnId();
            }
            case 16: {
                return pSDevSlnSysVerBase.getPSDevSlnName();
            }
            case 17: {
                return pSDevSlnSysVerBase.getPSDevSlnSysId();
            }
            case 18: {
                return pSDevSlnSysVerBase.getPSDevSlnSysName();
            }
            case 19: {
                return pSDevSlnSysVerBase.getPSDevSlnSysVerId();
            }
            case 20: {
                return pSDevSlnSysVerBase.getPSDevSlnSysVerName();
            }
            case 21: {
                return pSDevSlnSysVerBase.getPSSysModelInstId();
            }
            case 22: {
                return pSDevSlnSysVerBase.getPSSysModelInstName();
            }
            case 23: {
                return pSDevSlnSysVerBase.getUpdateDate();
            }
            case 24: {
                return pSDevSlnSysVerBase.getUpdateMan();
            }
            case 25: {
                return pSDevSlnSysVerBase.getUserCat();
            }
            case 26: {
                return pSDevSlnSysVerBase.getUserTag();
            }
            case 27: {
                return pSDevSlnSysVerBase.getUserTag2();
            }
            case 28: {
                return pSDevSlnSysVerBase.getUserTag3();
            }
            case 29: {
                return pSDevSlnSysVerBase.getUserTag4();
            }
            case 30: {
                return pSDevSlnSysVerBase.getValidFlag();
            }
            case 31: {
                return pSDevSlnSysVerBase.getVerDetail();
            }
            case 32: {
                return pSDevSlnSysVerBase.getVerLog();
            }
            case 33: {
                return pSDevSlnSysVerBase.getVerPSDevSlnSysId();
            }
            case 34: {
                return pSDevSlnSysVerBase.getVerPSDevSlnSysName();
            }
            case 35: {
                return pSDevSlnSysVerBase.getVersion();
            }
            case 36: {
                return pSDevSlnSysVerBase.getVerTag();
            }
            case 37: {
                return pSDevSlnSysVerBase.getVerTag2();
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
        PSDevSlnSysVerBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysVerBase pSDevSlnSysVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysVerBase.setPackState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysVerBase.setPackSysModelInst(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysVerBase.setPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysVerBase.setPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysVerBase.setPSDCRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysVerBase.setPSDCRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysVerBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysVerBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysVerBase.setPSDevCenterFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysVerBase.setPSDevCenterFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysVerBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysVerBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysVerBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysVerBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysVerBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysVerBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysVerBase.setPSDevSlnSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysVerBase.setPSDevSlnSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysVerBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysVerBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysVerBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysVerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysVerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnSysVerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnSysVerBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnSysVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnSysVerBase.setVerDetail(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnSysVerBase.setVerLog(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnSysVerBase.setVerPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnSysVerBase.setVerPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnSysVerBase.setVersion(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnSysVerBase.setVerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnSysVerBase.setVerTag2(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysVerBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysVerBase pSDevSlnSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysVerBase.getMemo() == null;
            }
            case 3: {
                return pSDevSlnSysVerBase.getPackState() == null;
            }
            case 4: {
                return pSDevSlnSysVerBase.getPackSysModelInst() == null;
            }
            case 5: {
                return pSDevSlnSysVerBase.getPSDCRegistryItemId() == null;
            }
            case 6: {
                return pSDevSlnSysVerBase.getPSDCRegistryItemName() == null;
            }
            case 7: {
                return pSDevSlnSysVerBase.getPSDCRegistryRepoId() == null;
            }
            case 8: {
                return pSDevSlnSysVerBase.getPSDCRegistryRepoName() == null;
            }
            case 9: {
                return pSDevSlnSysVerBase.getPSDevCenterDBInstId() == null;
            }
            case 10: {
                return pSDevSlnSysVerBase.getPSDevCenterDBInstName() == null;
            }
            case 11: {
                return pSDevSlnSysVerBase.getPSDevCenterFileId() == null;
            }
            case 12: {
                return pSDevSlnSysVerBase.getPSDevCenterFileName() == null;
            }
            case 13: {
                return pSDevSlnSysVerBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSDevSlnSysVerBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSDevSlnSysVerBase.getPSDevSlnId() == null;
            }
            case 16: {
                return pSDevSlnSysVerBase.getPSDevSlnName() == null;
            }
            case 17: {
                return pSDevSlnSysVerBase.getPSDevSlnSysId() == null;
            }
            case 18: {
                return pSDevSlnSysVerBase.getPSDevSlnSysName() == null;
            }
            case 19: {
                return pSDevSlnSysVerBase.getPSDevSlnSysVerId() == null;
            }
            case 20: {
                return pSDevSlnSysVerBase.getPSDevSlnSysVerName() == null;
            }
            case 21: {
                return pSDevSlnSysVerBase.getPSSysModelInstId() == null;
            }
            case 22: {
                return pSDevSlnSysVerBase.getPSSysModelInstName() == null;
            }
            case 23: {
                return pSDevSlnSysVerBase.getUpdateDate() == null;
            }
            case 24: {
                return pSDevSlnSysVerBase.getUpdateMan() == null;
            }
            case 25: {
                return pSDevSlnSysVerBase.getUserCat() == null;
            }
            case 26: {
                return pSDevSlnSysVerBase.getUserTag() == null;
            }
            case 27: {
                return pSDevSlnSysVerBase.getUserTag2() == null;
            }
            case 28: {
                return pSDevSlnSysVerBase.getUserTag3() == null;
            }
            case 29: {
                return pSDevSlnSysVerBase.getUserTag4() == null;
            }
            case 30: {
                return pSDevSlnSysVerBase.getValidFlag() == null;
            }
            case 31: {
                return pSDevSlnSysVerBase.getVerDetail() == null;
            }
            case 32: {
                return pSDevSlnSysVerBase.getVerLog() == null;
            }
            case 33: {
                return pSDevSlnSysVerBase.getVerPSDevSlnSysId() == null;
            }
            case 34: {
                return pSDevSlnSysVerBase.getVerPSDevSlnSysName() == null;
            }
            case 35: {
                return pSDevSlnSysVerBase.getVersion() == null;
            }
            case 36: {
                return pSDevSlnSysVerBase.getVerTag() == null;
            }
            case 37: {
                return pSDevSlnSysVerBase.getVerTag2() == null;
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
        return PSDevSlnSysVerBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysVerBase pSDevSlnSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysVerBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysVerBase.isMemoDirty();
            }
            case 3: {
                return pSDevSlnSysVerBase.isPackStateDirty();
            }
            case 4: {
                return pSDevSlnSysVerBase.isPackSysModelInstDirty();
            }
            case 5: {
                return pSDevSlnSysVerBase.isPSDCRegistryItemIdDirty();
            }
            case 6: {
                return pSDevSlnSysVerBase.isPSDCRegistryItemNameDirty();
            }
            case 7: {
                return pSDevSlnSysVerBase.isPSDCRegistryRepoIdDirty();
            }
            case 8: {
                return pSDevSlnSysVerBase.isPSDCRegistryRepoNameDirty();
            }
            case 9: {
                return pSDevSlnSysVerBase.isPSDevCenterDBInstIdDirty();
            }
            case 10: {
                return pSDevSlnSysVerBase.isPSDevCenterDBInstNameDirty();
            }
            case 11: {
                return pSDevSlnSysVerBase.isPSDevCenterFileIdDirty();
            }
            case 12: {
                return pSDevSlnSysVerBase.isPSDevCenterFileNameDirty();
            }
            case 13: {
                return pSDevSlnSysVerBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSDevSlnSysVerBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSDevSlnSysVerBase.isPSDevSlnIdDirty();
            }
            case 16: {
                return pSDevSlnSysVerBase.isPSDevSlnNameDirty();
            }
            case 17: {
                return pSDevSlnSysVerBase.isPSDevSlnSysIdDirty();
            }
            case 18: {
                return pSDevSlnSysVerBase.isPSDevSlnSysNameDirty();
            }
            case 19: {
                return pSDevSlnSysVerBase.isPSDevSlnSysVerIdDirty();
            }
            case 20: {
                return pSDevSlnSysVerBase.isPSDevSlnSysVerNameDirty();
            }
            case 21: {
                return pSDevSlnSysVerBase.isPSSysModelInstIdDirty();
            }
            case 22: {
                return pSDevSlnSysVerBase.isPSSysModelInstNameDirty();
            }
            case 23: {
                return pSDevSlnSysVerBase.isUpdateDateDirty();
            }
            case 24: {
                return pSDevSlnSysVerBase.isUpdateManDirty();
            }
            case 25: {
                return pSDevSlnSysVerBase.isUserCatDirty();
            }
            case 26: {
                return pSDevSlnSysVerBase.isUserTagDirty();
            }
            case 27: {
                return pSDevSlnSysVerBase.isUserTag2Dirty();
            }
            case 28: {
                return pSDevSlnSysVerBase.isUserTag3Dirty();
            }
            case 29: {
                return pSDevSlnSysVerBase.isUserTag4Dirty();
            }
            case 30: {
                return pSDevSlnSysVerBase.isValidFlagDirty();
            }
            case 31: {
                return pSDevSlnSysVerBase.isVerDetailDirty();
            }
            case 32: {
                return pSDevSlnSysVerBase.isVerLogDirty();
            }
            case 33: {
                return pSDevSlnSysVerBase.isVerPSDevSlnSysIdDirty();
            }
            case 34: {
                return pSDevSlnSysVerBase.isVerPSDevSlnSysNameDirty();
            }
            case 35: {
                return pSDevSlnSysVerBase.isVersionDirty();
            }
            case 36: {
                return pSDevSlnSysVerBase.isVerTagDirty();
            }
            case 37: {
                return pSDevSlnSysVerBase.isVerTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysVerBase pSDevSlnSysVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPackState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"packstate", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPackState()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPackSysModelInst() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"packsysmodelinst", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPackSysModelInst()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemname", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDCRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryrepoid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDCRegistryRepoId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDCRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryreponame", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDCRegistryRepoName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterfileid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevCenterFileId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterfilename", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevCenterFileName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysverid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevSlnSysVerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysvername", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSDevSlnSysVerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getVerDetail() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verdetail", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getVerDetail()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getVerLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verlog", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getVerLog()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getVerPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verpsdevslnsysid", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getVerPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getVerPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verpsdevslnsysname", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getVerPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getVersion()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getVerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getVerTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysVerBase.getVerTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag2", (Object)PSDevSlnSysVerBase.getJSONValue((Object)pSDevSlnSysVerBase.getVerTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysVerBase pSDevSlnSysVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysVerBase.getCreateDate() != null) {
            object = pSDevSlnSysVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysVerBase.getCreateMan() != null) {
            object = pSDevSlnSysVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getMemo() != null) {
            object = pSDevSlnSysVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPackState() != null) {
            object = pSDevSlnSysVerBase.getPackState();
            xmlNode.setAttribute(FIELD_PACKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysVerBase.getPackSysModelInst() != null) {
            object = pSDevSlnSysVerBase.getPackSysModelInst();
            xmlNode.setAttribute(FIELD_PACKSYSMODELINST, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysVerBase.getPSDCRegistryItemId() != null) {
            object = pSDevSlnSysVerBase.getPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDCRegistryItemName() != null) {
            object = pSDevSlnSysVerBase.getPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDCRegistryRepoId() != null) {
            object = pSDevSlnSysVerBase.getPSDCRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDCRegistryRepoName() != null) {
            object = pSDevSlnSysVerBase.getPSDCRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterDBInstId() != null) {
            object = pSDevSlnSysVerBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterDBInstName() != null) {
            object = pSDevSlnSysVerBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterFileId() != null) {
            object = pSDevSlnSysVerBase.getPSDevCenterFileId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterFileName() != null) {
            object = pSDevSlnSysVerBase.getPSDevCenterFileName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterId() != null) {
            object = pSDevSlnSysVerBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevCenterName() != null) {
            object = pSDevSlnSysVerBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysVerBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnName() != null) {
            object = pSDevSlnSysVerBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysVerBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysVerBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnSysVerId() != null) {
            object = pSDevSlnSysVerBase.getPSDevSlnSysVerId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSDevSlnSysVerName() != null) {
            object = pSDevSlnSysVerBase.getPSDevSlnSysVerName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSSysModelInstId() != null) {
            object = pSDevSlnSysVerBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getPSSysModelInstName() != null) {
            object = pSDevSlnSysVerBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getUpdateDate() != null) {
            object = pSDevSlnSysVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysVerBase.getUpdateMan() != null) {
            object = pSDevSlnSysVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getUserCat() != null) {
            object = pSDevSlnSysVerBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getUserTag() != null) {
            object = pSDevSlnSysVerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getUserTag2() != null) {
            object = pSDevSlnSysVerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getUserTag3() != null) {
            object = pSDevSlnSysVerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getUserTag4() != null) {
            object = pSDevSlnSysVerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getValidFlag() != null) {
            object = pSDevSlnSysVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysVerBase.getVerDetail() != null) {
            object = pSDevSlnSysVerBase.getVerDetail();
            xmlNode.setAttribute(FIELD_VERDETAIL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getVerLog() != null) {
            object = pSDevSlnSysVerBase.getVerLog();
            xmlNode.setAttribute(FIELD_VERLOG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getVerPSDevSlnSysId() != null) {
            object = pSDevSlnSysVerBase.getVerPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_VERPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getVerPSDevSlnSysName() != null) {
            object = pSDevSlnSysVerBase.getVerPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_VERPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getVersion() != null) {
            object = pSDevSlnSysVerBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getVerTag() != null) {
            object = pSDevSlnSysVerBase.getVerTag();
            xmlNode.setAttribute(FIELD_VERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysVerBase.getVerTag2() != null) {
            object = pSDevSlnSysVerBase.getVerTag2();
            xmlNode.setAttribute(FIELD_VERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysVerBase pSDevSlnSysVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysVerBase.isCreateDateDirty() && (bl || pSDevSlnSysVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysVerBase.getCreateDate());
        }
        if (pSDevSlnSysVerBase.isCreateManDirty() && (bl || pSDevSlnSysVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysVerBase.getCreateMan());
        }
        if (pSDevSlnSysVerBase.isMemoDirty() && (bl || pSDevSlnSysVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysVerBase.getMemo());
        }
        if (pSDevSlnSysVerBase.isPackStateDirty() && (bl || pSDevSlnSysVerBase.getPackState() != null)) {
            iDataObject.set(FIELD_PACKSTATE, (Object)pSDevSlnSysVerBase.getPackState());
        }
        if (pSDevSlnSysVerBase.isPackSysModelInstDirty() && (bl || pSDevSlnSysVerBase.getPackSysModelInst() != null)) {
            iDataObject.set(FIELD_PACKSYSMODELINST, (Object)pSDevSlnSysVerBase.getPackSysModelInst());
        }
        if (pSDevSlnSysVerBase.isPSDCRegistryItemIdDirty() && (bl || pSDevSlnSysVerBase.getPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMID, (Object)pSDevSlnSysVerBase.getPSDCRegistryItemId());
        }
        if (pSDevSlnSysVerBase.isPSDCRegistryItemNameDirty() && (bl || pSDevSlnSysVerBase.getPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMNAME, (Object)pSDevSlnSysVerBase.getPSDCRegistryItemName());
        }
        if (pSDevSlnSysVerBase.isPSDCRegistryRepoIdDirty() && (bl || pSDevSlnSysVerBase.getPSDCRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPOID, (Object)pSDevSlnSysVerBase.getPSDCRegistryRepoId());
        }
        if (pSDevSlnSysVerBase.isPSDCRegistryRepoNameDirty() && (bl || pSDevSlnSysVerBase.getPSDCRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPONAME, (Object)pSDevSlnSysVerBase.getPSDCRegistryRepoName());
        }
        if (pSDevSlnSysVerBase.isPSDevCenterDBInstIdDirty() && (bl || pSDevSlnSysVerBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDevSlnSysVerBase.getPSDevCenterDBInstId());
        }
        if (pSDevSlnSysVerBase.isPSDevCenterDBInstNameDirty() && (bl || pSDevSlnSysVerBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDevSlnSysVerBase.getPSDevCenterDBInstName());
        }
        if (pSDevSlnSysVerBase.isPSDevCenterFileIdDirty() && (bl || pSDevSlnSysVerBase.getPSDevCenterFileId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERFILEID, (Object)pSDevSlnSysVerBase.getPSDevCenterFileId());
        }
        if (pSDevSlnSysVerBase.isPSDevCenterFileNameDirty() && (bl || pSDevSlnSysVerBase.getPSDevCenterFileName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERFILENAME, (Object)pSDevSlnSysVerBase.getPSDevCenterFileName());
        }
        if (pSDevSlnSysVerBase.isPSDevCenterIdDirty() && (bl || pSDevSlnSysVerBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnSysVerBase.getPSDevCenterId());
        }
        if (pSDevSlnSysVerBase.isPSDevCenterNameDirty() && (bl || pSDevSlnSysVerBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnSysVerBase.getPSDevCenterName());
        }
        if (pSDevSlnSysVerBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysVerBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysVerBase.getPSDevSlnId());
        }
        if (pSDevSlnSysVerBase.isPSDevSlnNameDirty() && (bl || pSDevSlnSysVerBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnSysVerBase.getPSDevSlnName());
        }
        if (pSDevSlnSysVerBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysVerBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysVerBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysVerBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysVerBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysVerBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysVerBase.isPSDevSlnSysVerIdDirty() && (bl || pSDevSlnSysVerBase.getPSDevSlnSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERID, (Object)pSDevSlnSysVerBase.getPSDevSlnSysVerId());
        }
        if (pSDevSlnSysVerBase.isPSDevSlnSysVerNameDirty() && (bl || pSDevSlnSysVerBase.getPSDevSlnSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERNAME, (Object)pSDevSlnSysVerBase.getPSDevSlnSysVerName());
        }
        if (pSDevSlnSysVerBase.isPSSysModelInstIdDirty() && (bl || pSDevSlnSysVerBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSDevSlnSysVerBase.getPSSysModelInstId());
        }
        if (pSDevSlnSysVerBase.isPSSysModelInstNameDirty() && (bl || pSDevSlnSysVerBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSDevSlnSysVerBase.getPSSysModelInstName());
        }
        if (pSDevSlnSysVerBase.isUpdateDateDirty() && (bl || pSDevSlnSysVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysVerBase.getUpdateDate());
        }
        if (pSDevSlnSysVerBase.isUpdateManDirty() && (bl || pSDevSlnSysVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysVerBase.getUpdateMan());
        }
        if (pSDevSlnSysVerBase.isUserCatDirty() && (bl || pSDevSlnSysVerBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnSysVerBase.getUserCat());
        }
        if (pSDevSlnSysVerBase.isUserTagDirty() && (bl || pSDevSlnSysVerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnSysVerBase.getUserTag());
        }
        if (pSDevSlnSysVerBase.isUserTag2Dirty() && (bl || pSDevSlnSysVerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnSysVerBase.getUserTag2());
        }
        if (pSDevSlnSysVerBase.isUserTag3Dirty() && (bl || pSDevSlnSysVerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnSysVerBase.getUserTag3());
        }
        if (pSDevSlnSysVerBase.isUserTag4Dirty() && (bl || pSDevSlnSysVerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnSysVerBase.getUserTag4());
        }
        if (pSDevSlnSysVerBase.isValidFlagDirty() && (bl || pSDevSlnSysVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysVerBase.getValidFlag());
        }
        if (pSDevSlnSysVerBase.isVerDetailDirty() && (bl || pSDevSlnSysVerBase.getVerDetail() != null)) {
            iDataObject.set(FIELD_VERDETAIL, (Object)pSDevSlnSysVerBase.getVerDetail());
        }
        if (pSDevSlnSysVerBase.isVerLogDirty() && (bl || pSDevSlnSysVerBase.getVerLog() != null)) {
            iDataObject.set(FIELD_VERLOG, (Object)pSDevSlnSysVerBase.getVerLog());
        }
        if (pSDevSlnSysVerBase.isVerPSDevSlnSysIdDirty() && (bl || pSDevSlnSysVerBase.getVerPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_VERPSDEVSLNSYSID, (Object)pSDevSlnSysVerBase.getVerPSDevSlnSysId());
        }
        if (pSDevSlnSysVerBase.isVerPSDevSlnSysNameDirty() && (bl || pSDevSlnSysVerBase.getVerPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_VERPSDEVSLNSYSNAME, (Object)pSDevSlnSysVerBase.getVerPSDevSlnSysName());
        }
        if (pSDevSlnSysVerBase.isVersionDirty() && (bl || pSDevSlnSysVerBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSDevSlnSysVerBase.getVersion());
        }
        if (pSDevSlnSysVerBase.isVerTagDirty() && (bl || pSDevSlnSysVerBase.getVerTag() != null)) {
            iDataObject.set(FIELD_VERTAG, (Object)pSDevSlnSysVerBase.getVerTag());
        }
        if (pSDevSlnSysVerBase.isVerTag2Dirty() && (bl || pSDevSlnSysVerBase.getVerTag2() != null)) {
            iDataObject.set(FIELD_VERTAG2, (Object)pSDevSlnSysVerBase.getVerTag2());
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
        return PSDevSlnSysVerBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysVerBase pSDevSlnSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevSlnSysVerBase.resetPackState();
                return true;
            }
            case 4: {
                pSDevSlnSysVerBase.resetPackSysModelInst();
                return true;
            }
            case 5: {
                pSDevSlnSysVerBase.resetPSDCRegistryItemId();
                return true;
            }
            case 6: {
                pSDevSlnSysVerBase.resetPSDCRegistryItemName();
                return true;
            }
            case 7: {
                pSDevSlnSysVerBase.resetPSDCRegistryRepoId();
                return true;
            }
            case 8: {
                pSDevSlnSysVerBase.resetPSDCRegistryRepoName();
                return true;
            }
            case 9: {
                pSDevSlnSysVerBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 10: {
                pSDevSlnSysVerBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 11: {
                pSDevSlnSysVerBase.resetPSDevCenterFileId();
                return true;
            }
            case 12: {
                pSDevSlnSysVerBase.resetPSDevCenterFileName();
                return true;
            }
            case 13: {
                pSDevSlnSysVerBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSDevSlnSysVerBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSDevSlnSysVerBase.resetPSDevSlnId();
                return true;
            }
            case 16: {
                pSDevSlnSysVerBase.resetPSDevSlnName();
                return true;
            }
            case 17: {
                pSDevSlnSysVerBase.resetPSDevSlnSysId();
                return true;
            }
            case 18: {
                pSDevSlnSysVerBase.resetPSDevSlnSysName();
                return true;
            }
            case 19: {
                pSDevSlnSysVerBase.resetPSDevSlnSysVerId();
                return true;
            }
            case 20: {
                pSDevSlnSysVerBase.resetPSDevSlnSysVerName();
                return true;
            }
            case 21: {
                pSDevSlnSysVerBase.resetPSSysModelInstId();
                return true;
            }
            case 22: {
                pSDevSlnSysVerBase.resetPSSysModelInstName();
                return true;
            }
            case 23: {
                pSDevSlnSysVerBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSDevSlnSysVerBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSDevSlnSysVerBase.resetUserCat();
                return true;
            }
            case 26: {
                pSDevSlnSysVerBase.resetUserTag();
                return true;
            }
            case 27: {
                pSDevSlnSysVerBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSDevSlnSysVerBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSDevSlnSysVerBase.resetUserTag4();
                return true;
            }
            case 30: {
                pSDevSlnSysVerBase.resetValidFlag();
                return true;
            }
            case 31: {
                pSDevSlnSysVerBase.resetVerDetail();
                return true;
            }
            case 32: {
                pSDevSlnSysVerBase.resetVerLog();
                return true;
            }
            case 33: {
                pSDevSlnSysVerBase.resetVerPSDevSlnSysId();
                return true;
            }
            case 34: {
                pSDevSlnSysVerBase.resetVerPSDevSlnSysName();
                return true;
            }
            case 35: {
                pSDevSlnSysVerBase.resetVersion();
                return true;
            }
            case 36: {
                pSDevSlnSysVerBase.resetVerTag();
                return true;
            }
            case 37: {
                pSDevSlnSysVerBase.resetVerTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryItem getPSDCRegistryItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItem();
        }
        if (this.getPSDCRegistryItemId() == null) {
            return null;
        }
        Integer n = this.objPSDCRegistryItemLock;
        synchronized (n) {
            if (this.psdcregistryitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRegistryItemId(), (Object)this.psdcregistryitem.getPSDCRegistryItemId()) != 0L) {
                this.psdcregistryitem = null;
            }
            if (this.psdcregistryitem == null) {
                PSDCRegistryItem pSDCRegistryItem = new PSDCRegistryItem();
                pSDCRegistryItem.setPSDCRegistryItemId(this.getPSDCRegistryItemId());
                PSDCRegistryItemService pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryItemService.autoGet((IEntity)pSDCRegistryItem);
                this.psdcregistryitem = pSDCRegistryItem;
            }
            return this.psdcregistryitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryRepo getPSDCRegistryRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepo();
        }
        if (this.getPSDCRegistryRepoId() == null) {
            return null;
        }
        Integer n = this.objPSDCRegistryRepoLock;
        synchronized (n) {
            if (this.psdcregistryrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRegistryRepoId(), (Object)this.psdcregistryrepo.getPSDCRegistryRepoId()) != 0L) {
                this.psdcregistryrepo = null;
            }
            if (this.psdcregistryrepo == null) {
                PSDCRegistryRepo pSDCRegistryRepo = new PSDCRegistryRepo();
                pSDCRegistryRepo.setPSDCRegistryRepoId(this.getPSDCRegistryRepoId());
                PSDCRegistryRepoService pSDCRegistryRepoService = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryRepoService.autoGet((IEntity)pSDCRegistryRepo);
                this.psdcregistryrepo = pSDCRegistryRepo;
            }
            return this.psdcregistryrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterFile getPSDevCenterFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterFile();
        }
        if (this.getPSDevCenterFileId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterFileLock;
        synchronized (n) {
            if (this.psdevcenterfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterFileId(), (Object)this.psdevcenterfile.getPSDevCenterFileId()) != 0L) {
                this.psdevcenterfile = null;
            }
            if (this.psdevcenterfile == null) {
                PSDevCenterFile pSDevCenterFile = new PSDevCenterFile();
                pSDevCenterFile.setPSDevCenterFileId(this.getPSDevCenterFileId());
                PSDevCenterFileService pSDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterFileService.autoGet((IEntity)pSDevCenterFile);
                this.psdevcenterfile = pSDevCenterFile;
            }
            return this.psdevcenterfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
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
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getVerPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerPSDevSlnSys();
        }
        if (this.getVerPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objVerPSDevSlnSysLock;
        synchronized (n) {
            if (this.verpsdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getVerPSDevSlnSysId(), (Object)this.verpsdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.verpsdevslnsys = null;
            }
            if (this.verpsdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getVerPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.verpsdevslnsys = pSDevSlnSys;
            }
            return this.verpsdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    private PSDevSlnSysVerBase getProxyEntity() {
        return this.proxyPSDevSlnSysVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysVerBase) {
            this.proxyPSDevSlnSysVerBase = (PSDevSlnSysVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PACKSTATE, 3);
        fieldIndexMap.put(FIELD_PACKSYSMODELINST, 4);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMID, 5);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMNAME, 6);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPOID, 7);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPONAME, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERFILEID, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERFILENAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERID, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 21);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
        fieldIndexMap.put(FIELD_VALIDFLAG, 30);
        fieldIndexMap.put(FIELD_VERDETAIL, 31);
        fieldIndexMap.put(FIELD_VERLOG, 32);
        fieldIndexMap.put(FIELD_VERPSDEVSLNSYSID, 33);
        fieldIndexMap.put(FIELD_VERPSDEVSLNSYSNAME, 34);
        fieldIndexMap.put(FIELD_VERSION, 35);
        fieldIndexMap.put(FIELD_VERTAG, 36);
        fieldIndexMap.put(FIELD_VERTAG2, 37);
    }
}

