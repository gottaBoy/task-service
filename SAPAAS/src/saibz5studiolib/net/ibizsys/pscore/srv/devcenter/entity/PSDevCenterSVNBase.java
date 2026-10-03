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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.entity.PSGitUser;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterSVNBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterSVNBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_GITBRANCH = "GITBRANCH";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_GITPRJ = "GITPRJ";
    public static final String FIELD_GITREPO = "GITREPO";
    public static final String FIELD_LOCKMODE = "LOCKMODE";
    public static final String FIELD_LOCKOBJID = "LOCKOBJID";
    public static final String FIELD_LOCKOBJTYPE = "LOCKOBJTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PSCREDENTIALID = "PSCREDENTIALID";
    public static final String FIELD_PSCREDENTIALNAME = "PSCREDENTIALNAME";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSGITUSERID = "PSGITUSERID";
    public static final String FIELD_PSGITUSERNAME = "PSGITUSERNAME";
    public static final String FIELD_PSSVNINSTREPOID = "PSSVNINSTREPOID";
    public static final String FIELD_PSSVNINSTREPONAME = "PSSVNINSTREPONAME";
    public static final String FIELD_PSSVNSERVERID = "PSSVNSERVERID";
    public static final String FIELD_REFFLAG = "REFFLAG";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_REFOBJNAME = "REFOBJNAME";
    public static final String FIELD_REFOBJTYPE = "REFOBJTYPE";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_ROPSCREDENTIALID = "ROPSCREDENTIALID";
    public static final String FIELD_ROPSCREDENTIALNAME = "ROPSCREDENTIALNAME";
    public static final String FIELD_SVNTYPE = "SVNTYPE";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGE = "USAGE";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EXPRIEDTIME = 2;
    private static final int INDEX_GITBRANCH = 3;
    private static final int INDEX_GITPATH = 4;
    private static final int INDEX_GITPRJ = 5;
    private static final int INDEX_GITREPO = 6;
    private static final int INDEX_LOCKMODE = 7;
    private static final int INDEX_LOCKOBJID = 8;
    private static final int INDEX_LOCKOBJTYPE = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PARAM = 11;
    private static final int INDEX_PARAM2 = 12;
    private static final int INDEX_PSCREDENTIALID = 13;
    private static final int INDEX_PSCREDENTIALNAME = 14;
    private static final int INDEX_PSDCCLUSTERID = 15;
    private static final int INDEX_PSDCCLUSTERNAME = 16;
    private static final int INDEX_PSDCCONTAINERSPECID = 17;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 18;
    private static final int INDEX_PSDCFILEID = 19;
    private static final int INDEX_PSDCFILENAME = 20;
    private static final int INDEX_PSDEVCENTERID = 21;
    private static final int INDEX_PSDEVCENTERNAME = 22;
    private static final int INDEX_PSDEVCENTERSVNID = 23;
    private static final int INDEX_PSDEVCENTERSVNNAME = 24;
    private static final int INDEX_PSDEVSLNID = 25;
    private static final int INDEX_PSDEVSLNNAME = 26;
    private static final int INDEX_PSGITUSERID = 27;
    private static final int INDEX_PSGITUSERNAME = 28;
    private static final int INDEX_PSSVNINSTREPOID = 29;
    private static final int INDEX_PSSVNINSTREPONAME = 30;
    private static final int INDEX_PSSVNSERVERID = 31;
    private static final int INDEX_REFFLAG = 32;
    private static final int INDEX_REFOBJID = 33;
    private static final int INDEX_REFOBJNAME = 34;
    private static final int INDEX_REFOBJTYPE = 35;
    private static final int INDEX_RESPOS = 36;
    private static final int INDEX_RESSTATE = 37;
    private static final int INDEX_RESVER = 38;
    private static final int INDEX_ROPSCREDENTIALID = 39;
    private static final int INDEX_ROPSCREDENTIALNAME = 40;
    private static final int INDEX_SVNTYPE = 41;
    private static final int INDEX_TAGS = 42;
    private static final int INDEX_UPDATEDATE = 43;
    private static final int INDEX_UPDATEMAN = 44;
    private static final int INDEX_USAGE = 45;
    private static final int INDEX_USERTAG = 46;
    private static final int INDEX_USERTAG2 = 47;
    private static final int INDEX_USERTAG3 = 48;
    private static final int INDEX_USERTAG4 = 49;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterSVNBase proxyPSDevCenterSVNBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean gitbranchDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean gitprjDirtyFlag = false;
    private boolean gitrepoDirtyFlag = false;
    private boolean lockmodeDirtyFlag = false;
    private boolean lockobjidDirtyFlag = false;
    private boolean lockobjtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean pscredentialidDirtyFlag = false;
    private boolean pscredentialnameDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psgituseridDirtyFlag = false;
    private boolean psgitusernameDirtyFlag = false;
    private boolean pssvninstrepoidDirtyFlag = false;
    private boolean pssvninstreponameDirtyFlag = false;
    private boolean pssvnserveridDirtyFlag = false;
    private boolean refflagDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean refobjnameDirtyFlag = false;
    private boolean refobjtypeDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean ropscredentialidDirtyFlag = false;
    private boolean ropscredentialnameDirtyFlag = false;
    private boolean svntypeDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usageDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="gitbranch")
    private String gitbranch;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="gitprj")
    private String gitprj;
    @Column(name="gitrepo")
    private String gitrepo;
    @Column(name="lockmode")
    private Integer lockmode;
    @Column(name="lockobjid")
    private String lockobjid;
    @Column(name="lockobjtype")
    private String lockobjtype;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="pscredentialid")
    private String pscredentialid;
    @Column(name="pscredentialname")
    private String pscredentialname;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psgituserid")
    private String psgituserid;
    @Column(name="psgitusername")
    private String psgitusername;
    @Column(name="pssvninstrepoid")
    private String pssvninstrepoid;
    @Column(name="pssvninstreponame")
    private String pssvninstreponame;
    @Column(name="pssvnserverid")
    private String pssvnserverid;
    @Column(name="refflag")
    private Integer refflag;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="refobjname")
    private String refobjname;
    @Column(name="refobjtype")
    private String refobjtype;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="ropscredentialid")
    private String ropscredentialid;
    @Column(name="ropscredentialname")
    private String ropscredentialname;
    @Column(name="svntype")
    private String svntype;
    @Column(name="tags")
    private String tags;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usage")
    private String usage;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSCredentialLock = new Integer(1);
    private PSCredential pscredential = null;
    private Integer objROPSCredentialLock = new Integer(1);
    private PSCredential ropscredential = null;
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSGitUserLock = new Integer(1);
    private PSGitUser psgituser = null;
    private Integer objPSSVNInstRepoLock = new Integer(1);
    private PSSVNInstRepo pssvninstrepo = null;

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

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setGitBranch(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitBranch(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitbranch = string;
        this.gitbranchDirtyFlag = true;
    }

    public String getGitBranch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitBranch();
        }
        return this.gitbranch;
    }

    public boolean isGitBranchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitBranchDirty();
        }
        return this.gitbranchDirtyFlag;
    }

    public void resetGitBranch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitBranch();
            return;
        }
        this.gitbranchDirtyFlag = false;
        this.gitbranch = null;
    }

    public void setGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitpath = string;
        this.gitpathDirtyFlag = true;
    }

    public String getGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitPath();
        }
        return this.gitpath;
    }

    public boolean isGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitPathDirty();
        }
        return this.gitpathDirtyFlag;
    }

    public void resetGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitPath();
            return;
        }
        this.gitpathDirtyFlag = false;
        this.gitpath = null;
    }

    public void setGitPrj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitPrj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitprj = string;
        this.gitprjDirtyFlag = true;
    }

    public String getGitPrj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitPrj();
        }
        return this.gitprj;
    }

    public boolean isGitPrjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitPrjDirty();
        }
        return this.gitprjDirtyFlag;
    }

    public void resetGitPrj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitPrj();
            return;
        }
        this.gitprjDirtyFlag = false;
        this.gitprj = null;
    }

    public void setGitRepo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitRepo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitrepo = string;
        this.gitrepoDirtyFlag = true;
    }

    public String getGitRepo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitRepo();
        }
        return this.gitrepo;
    }

    public boolean isGitRepoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitRepoDirty();
        }
        return this.gitrepoDirtyFlag;
    }

    public void resetGitRepo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitRepo();
            return;
        }
        this.gitrepoDirtyFlag = false;
        this.gitrepo = null;
    }

    public void setLockMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockMode(n);
            return;
        }
        this.lockmode = n;
        this.lockmodeDirtyFlag = true;
    }

    public Integer getLockMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockMode();
        }
        return this.lockmode;
    }

    public boolean isLockModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockModeDirty();
        }
        return this.lockmodeDirtyFlag;
    }

    public void resetLockMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockMode();
            return;
        }
        this.lockmodeDirtyFlag = false;
        this.lockmode = null;
    }

    public void setLockObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockobjid = string;
        this.lockobjidDirtyFlag = true;
    }

    public String getLockObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockObjId();
        }
        return this.lockobjid;
    }

    public boolean isLockObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockObjIdDirty();
        }
        return this.lockobjidDirtyFlag;
    }

    public void resetLockObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockObjId();
            return;
        }
        this.lockobjidDirtyFlag = false;
        this.lockobjid = null;
    }

    public void setLockObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockobjtype = string;
        this.lockobjtypeDirtyFlag = true;
    }

    public String getLockObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockObjType();
        }
        return this.lockobjtype;
    }

    public boolean isLockObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockObjTypeDirty();
        }
        return this.lockobjtypeDirtyFlag;
    }

    public void resetLockObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockObjType();
            return;
        }
        this.lockobjtypeDirtyFlag = false;
        this.lockobjtype = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setPSCredentialId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialid = string;
        this.pscredentialidDirtyFlag = true;
    }

    public String getPSCredentialId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialId();
        }
        return this.pscredentialid;
    }

    public boolean isPSCredentialIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialIdDirty();
        }
        return this.pscredentialidDirtyFlag;
    }

    public void resetPSCredentialId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialId();
            return;
        }
        this.pscredentialidDirtyFlag = false;
        this.pscredentialid = null;
    }

    public void setPSCredentialName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialname = string;
        this.pscredentialnameDirtyFlag = true;
    }

    public String getPSCredentialName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialName();
        }
        return this.pscredentialname;
    }

    public boolean isPSCredentialNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialNameDirty();
        }
        return this.pscredentialnameDirtyFlag;
    }

    public void resetPSCredentialName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialName();
            return;
        }
        this.pscredentialnameDirtyFlag = false;
        this.pscredentialname = null;
    }

    public void setPSDCClusterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclusterid = string;
        this.psdcclusteridDirtyFlag = true;
    }

    public String getPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterId();
        }
        return this.psdcclusterid;
    }

    public boolean isPSDCClusterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterIdDirty();
        }
        return this.psdcclusteridDirtyFlag;
    }

    public void resetPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterId();
            return;
        }
        this.psdcclusteridDirtyFlag = false;
        this.psdcclusterid = null;
    }

    public void setPSDCClusterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclustername = string;
        this.psdcclusternameDirtyFlag = true;
    }

    public String getPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterName();
        }
        return this.psdcclustername;
    }

    public boolean isPSDCClusterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterNameDirty();
        }
        return this.psdcclusternameDirtyFlag;
    }

    public void resetPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterName();
            return;
        }
        this.psdcclusternameDirtyFlag = false;
        this.psdcclustername = null;
    }

    public void setPSDCContainerSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecid = string;
        this.psdccontainerspecidDirtyFlag = true;
    }

    public String getPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecId();
        }
        return this.psdccontainerspecid;
    }

    public boolean isPSDCContainerSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecIdDirty();
        }
        return this.psdccontainerspecidDirtyFlag;
    }

    public void resetPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecId();
            return;
        }
        this.psdccontainerspecidDirtyFlag = false;
        this.psdccontainerspecid = null;
    }

    public void setPSDCContainerSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecname = string;
        this.psdccontainerspecnameDirtyFlag = true;
    }

    public String getPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecName();
        }
        return this.psdccontainerspecname;
    }

    public boolean isPSDCContainerSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecNameDirty();
        }
        return this.psdccontainerspecnameDirtyFlag;
    }

    public void resetPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecName();
            return;
        }
        this.psdccontainerspecnameDirtyFlag = false;
        this.psdccontainerspecname = null;
    }

    public void setPSDCFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfileid = string;
        this.psdcfileidDirtyFlag = true;
    }

    public String getPSDCFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileId();
        }
        return this.psdcfileid;
    }

    public boolean isPSDCFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileIdDirty();
        }
        return this.psdcfileidDirtyFlag;
    }

    public void resetPSDCFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileId();
            return;
        }
        this.psdcfileidDirtyFlag = false;
        this.psdcfileid = null;
    }

    public void setPSDCFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfilename = string;
        this.psdcfilenameDirtyFlag = true;
    }

    public String getPSDCFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileName();
        }
        return this.psdcfilename;
    }

    public boolean isPSDCFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileNameDirty();
        }
        return this.psdcfilenameDirtyFlag;
    }

    public void resetPSDCFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileName();
            return;
        }
        this.psdcfilenameDirtyFlag = false;
        this.psdcfilename = null;
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

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
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

    public void setPSGitUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSGitUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psgituserid = string;
        this.psgituseridDirtyFlag = true;
    }

    public String getPSGitUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSGitUserId();
        }
        return this.psgituserid;
    }

    public boolean isPSGitUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSGitUserIdDirty();
        }
        return this.psgituseridDirtyFlag;
    }

    public void resetPSGitUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSGitUserId();
            return;
        }
        this.psgituseridDirtyFlag = false;
        this.psgituserid = null;
    }

    public void setPSGitUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSGitUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psgitusername = string;
        this.psgitusernameDirtyFlag = true;
    }

    public String getPSGitUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSGitUserName();
        }
        return this.psgitusername;
    }

    public boolean isPSGitUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSGitUserNameDirty();
        }
        return this.psgitusernameDirtyFlag;
    }

    public void resetPSGitUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSGitUserName();
            return;
        }
        this.psgitusernameDirtyFlag = false;
        this.psgitusername = null;
    }

    public void setPSSVNInstRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSVNInstRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvninstrepoid = string;
        this.pssvninstrepoidDirtyFlag = true;
    }

    public String getPSSVNInstRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVNInstRepoId();
        }
        return this.pssvninstrepoid;
    }

    public boolean isPSSVNInstRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSVNInstRepoIdDirty();
        }
        return this.pssvninstrepoidDirtyFlag;
    }

    public void resetPSSVNInstRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSVNInstRepoId();
            return;
        }
        this.pssvninstrepoidDirtyFlag = false;
        this.pssvninstrepoid = null;
    }

    public void setPSSVNInstRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSVNInstRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvninstreponame = string;
        this.pssvninstreponameDirtyFlag = true;
    }

    public String getPSSVNInstRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVNInstRepoName();
        }
        return this.pssvninstreponame;
    }

    public boolean isPSSVNInstRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSVNInstRepoNameDirty();
        }
        return this.pssvninstreponameDirtyFlag;
    }

    public void resetPSSVNInstRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSVNInstRepoName();
            return;
        }
        this.pssvninstreponameDirtyFlag = false;
        this.pssvninstreponame = null;
    }

    public void setPSSVNServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSVNServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvnserverid = string;
        this.pssvnserveridDirtyFlag = true;
    }

    public String getPSSVNServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVNServerId();
        }
        return this.pssvnserverid;
    }

    public boolean isPSSVNServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSVNServerIdDirty();
        }
        return this.pssvnserveridDirtyFlag;
    }

    public void resetPSSVNServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSVNServerId();
            return;
        }
        this.pssvnserveridDirtyFlag = false;
        this.pssvnserverid = null;
    }

    public void setRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefFlag(n);
            return;
        }
        this.refflag = n;
        this.refflagDirtyFlag = true;
    }

    public Integer getRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefFlag();
        }
        return this.refflag;
    }

    public boolean isRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefFlagDirty();
        }
        return this.refflagDirtyFlag;
    }

    public void resetRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefFlag();
            return;
        }
        this.refflagDirtyFlag = false;
        this.refflag = null;
    }

    public void setRefObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjid = string;
        this.refobjidDirtyFlag = true;
    }

    public String getRefObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjId();
        }
        return this.refobjid;
    }

    public boolean isRefObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjIdDirty();
        }
        return this.refobjidDirtyFlag;
    }

    public void resetRefObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjId();
            return;
        }
        this.refobjidDirtyFlag = false;
        this.refobjid = null;
    }

    public void setRefObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjname = string;
        this.refobjnameDirtyFlag = true;
    }

    public String getRefObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjName();
        }
        return this.refobjname;
    }

    public boolean isRefObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjNameDirty();
        }
        return this.refobjnameDirtyFlag;
    }

    public void resetRefObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjName();
            return;
        }
        this.refobjnameDirtyFlag = false;
        this.refobjname = null;
    }

    public void setRefObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjtype = string;
        this.refobjtypeDirtyFlag = true;
    }

    public String getRefObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjType();
        }
        return this.refobjtype;
    }

    public boolean isRefObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjTypeDirty();
        }
        return this.refobjtypeDirtyFlag;
    }

    public void resetRefObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjType();
            return;
        }
        this.refobjtypeDirtyFlag = false;
        this.refobjtype = null;
    }

    public void setResPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResPos(n);
            return;
        }
        this.respos = n;
        this.resposDirtyFlag = true;
    }

    public Integer getResPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResPos();
        }
        return this.respos;
    }

    public boolean isResPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResPosDirty();
        }
        return this.resposDirtyFlag;
    }

    public void resetResPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResPos();
            return;
        }
        this.resposDirtyFlag = false;
        this.respos = null;
    }

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
    }

    public void setResVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResVer(n);
            return;
        }
        this.resver = n;
        this.resverDirtyFlag = true;
    }

    public Integer getResVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResVer();
        }
        return this.resver;
    }

    public boolean isResVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResVerDirty();
        }
        return this.resverDirtyFlag;
    }

    public void resetResVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResVer();
            return;
        }
        this.resverDirtyFlag = false;
        this.resver = null;
    }

    public void setROPSCredentialId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSCredentialId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropscredentialid = string;
        this.ropscredentialidDirtyFlag = true;
    }

    public String getROPSCredentialId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSCredentialId();
        }
        return this.ropscredentialid;
    }

    public boolean isROPSCredentialIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSCredentialIdDirty();
        }
        return this.ropscredentialidDirtyFlag;
    }

    public void resetROPSCredentialId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSCredentialId();
            return;
        }
        this.ropscredentialidDirtyFlag = false;
        this.ropscredentialid = null;
    }

    public void setROPSCredentialName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSCredentialName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropscredentialname = string;
        this.ropscredentialnameDirtyFlag = true;
    }

    public String getROPSCredentialName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSCredentialName();
        }
        return this.ropscredentialname;
    }

    public boolean isROPSCredentialNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSCredentialNameDirty();
        }
        return this.ropscredentialnameDirtyFlag;
    }

    public void resetROPSCredentialName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSCredentialName();
            return;
        }
        this.ropscredentialnameDirtyFlag = false;
        this.ropscredentialname = null;
    }

    public void setSVNType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSVNType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.svntype = string;
        this.svntypeDirtyFlag = true;
    }

    public String getSVNType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSVNType();
        }
        return this.svntype;
    }

    public boolean isSVNTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSVNTypeDirty();
        }
        return this.svntypeDirtyFlag;
    }

    public void resetSVNType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSVNType();
            return;
        }
        this.svntypeDirtyFlag = false;
        this.svntype = null;
    }

    public void setTags(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTags(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tags = string;
        this.tagsDirtyFlag = true;
    }

    public String getTags() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTags();
        }
        return this.tags;
    }

    public boolean isTagsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagsDirty();
        }
        return this.tagsDirtyFlag;
    }

    public void resetTags() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTags();
            return;
        }
        this.tagsDirtyFlag = false;
        this.tags = null;
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

    public void setUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usage = string;
        this.usageDirtyFlag = true;
    }

    public String getUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsage();
        }
        return this.usage;
    }

    public boolean isUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageDirty();
        }
        return this.usageDirtyFlag;
    }

    public void resetUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsage();
            return;
        }
        this.usageDirtyFlag = false;
        this.usage = null;
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
        PSDevCenterSVNBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterSVNBase pSDevCenterSVNBase) {
        pSDevCenterSVNBase.resetCreateDate();
        pSDevCenterSVNBase.resetCreateMan();
        pSDevCenterSVNBase.resetExpriedTime();
        pSDevCenterSVNBase.resetGitBranch();
        pSDevCenterSVNBase.resetGitPath();
        pSDevCenterSVNBase.resetGitPrj();
        pSDevCenterSVNBase.resetGitRepo();
        pSDevCenterSVNBase.resetLockMode();
        pSDevCenterSVNBase.resetLockObjId();
        pSDevCenterSVNBase.resetLockObjType();
        pSDevCenterSVNBase.resetMemo();
        pSDevCenterSVNBase.resetParam();
        pSDevCenterSVNBase.resetParam2();
        pSDevCenterSVNBase.resetPSCredentialId();
        pSDevCenterSVNBase.resetPSCredentialName();
        pSDevCenterSVNBase.resetPSDCClusterId();
        pSDevCenterSVNBase.resetPSDCClusterName();
        pSDevCenterSVNBase.resetPSDCContainerSpecId();
        pSDevCenterSVNBase.resetPSDCContainerSpecName();
        pSDevCenterSVNBase.resetPSDCFileId();
        pSDevCenterSVNBase.resetPSDCFileName();
        pSDevCenterSVNBase.resetPSDevCenterId();
        pSDevCenterSVNBase.resetPSDevCenterName();
        pSDevCenterSVNBase.resetPSDevCenterSVNId();
        pSDevCenterSVNBase.resetPSDevCenterSVNName();
        pSDevCenterSVNBase.resetPSDevSlnId();
        pSDevCenterSVNBase.resetPSDevSlnName();
        pSDevCenterSVNBase.resetPSGitUserId();
        pSDevCenterSVNBase.resetPSGitUserName();
        pSDevCenterSVNBase.resetPSSVNInstRepoId();
        pSDevCenterSVNBase.resetPSSVNInstRepoName();
        pSDevCenterSVNBase.resetPSSVNServerId();
        pSDevCenterSVNBase.resetRefFlag();
        pSDevCenterSVNBase.resetRefObjId();
        pSDevCenterSVNBase.resetRefObjName();
        pSDevCenterSVNBase.resetRefObjType();
        pSDevCenterSVNBase.resetResPos();
        pSDevCenterSVNBase.resetResState();
        pSDevCenterSVNBase.resetResVer();
        pSDevCenterSVNBase.resetROPSCredentialId();
        pSDevCenterSVNBase.resetROPSCredentialName();
        pSDevCenterSVNBase.resetSVNType();
        pSDevCenterSVNBase.resetTags();
        pSDevCenterSVNBase.resetUpdateDate();
        pSDevCenterSVNBase.resetUpdateMan();
        pSDevCenterSVNBase.resetUsage();
        pSDevCenterSVNBase.resetUserTag();
        pSDevCenterSVNBase.resetUserTag2();
        pSDevCenterSVNBase.resetUserTag3();
        pSDevCenterSVNBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isGitBranchDirty()) {
            hashMap.put(FIELD_GITBRANCH, this.getGitBranch());
        }
        if (!bl || this.isGitPathDirty()) {
            hashMap.put(FIELD_GITPATH, this.getGitPath());
        }
        if (!bl || this.isGitPrjDirty()) {
            hashMap.put(FIELD_GITPRJ, this.getGitPrj());
        }
        if (!bl || this.isGitRepoDirty()) {
            hashMap.put(FIELD_GITREPO, this.getGitRepo());
        }
        if (!bl || this.isLockModeDirty()) {
            hashMap.put(FIELD_LOCKMODE, this.getLockMode());
        }
        if (!bl || this.isLockObjIdDirty()) {
            hashMap.put(FIELD_LOCKOBJID, this.getLockObjId());
        }
        if (!bl || this.isLockObjTypeDirty()) {
            hashMap.put(FIELD_LOCKOBJTYPE, this.getLockObjType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isPSCredentialIdDirty()) {
            hashMap.put(FIELD_PSCREDENTIALID, this.getPSCredentialId());
        }
        if (!bl || this.isPSCredentialNameDirty()) {
            hashMap.put(FIELD_PSCREDENTIALNAME, this.getPSCredentialName());
        }
        if (!bl || this.isPSDCClusterIdDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERID, this.getPSDCClusterId());
        }
        if (!bl || this.isPSDCClusterNameDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERNAME, this.getPSDCClusterName());
        }
        if (!bl || this.isPSDCContainerSpecIdDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECID, this.getPSDCContainerSpecId());
        }
        if (!bl || this.isPSDCContainerSpecNameDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECNAME, this.getPSDCContainerSpecName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSGitUserIdDirty()) {
            hashMap.put(FIELD_PSGITUSERID, this.getPSGitUserId());
        }
        if (!bl || this.isPSGitUserNameDirty()) {
            hashMap.put(FIELD_PSGITUSERNAME, this.getPSGitUserName());
        }
        if (!bl || this.isPSSVNInstRepoIdDirty()) {
            hashMap.put(FIELD_PSSVNINSTREPOID, this.getPSSVNInstRepoId());
        }
        if (!bl || this.isPSSVNInstRepoNameDirty()) {
            hashMap.put(FIELD_PSSVNINSTREPONAME, this.getPSSVNInstRepoName());
        }
        if (!bl || this.isPSSVNServerIdDirty()) {
            hashMap.put(FIELD_PSSVNSERVERID, this.getPSSVNServerId());
        }
        if (!bl || this.isRefFlagDirty()) {
            hashMap.put(FIELD_REFFLAG, this.getRefFlag());
        }
        if (!bl || this.isRefObjIdDirty()) {
            hashMap.put(FIELD_REFOBJID, this.getRefObjId());
        }
        if (!bl || this.isRefObjNameDirty()) {
            hashMap.put(FIELD_REFOBJNAME, this.getRefObjName());
        }
        if (!bl || this.isRefObjTypeDirty()) {
            hashMap.put(FIELD_REFOBJTYPE, this.getRefObjType());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isResVerDirty()) {
            hashMap.put(FIELD_RESVER, this.getResVer());
        }
        if (!bl || this.isROPSCredentialIdDirty()) {
            hashMap.put(FIELD_ROPSCREDENTIALID, this.getROPSCredentialId());
        }
        if (!bl || this.isROPSCredentialNameDirty()) {
            hashMap.put(FIELD_ROPSCREDENTIALNAME, this.getROPSCredentialName());
        }
        if (!bl || this.isSVNTypeDirty()) {
            hashMap.put(FIELD_SVNTYPE, this.getSVNType());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageDirty()) {
            hashMap.put(FIELD_USAGE, this.getUsage());
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
        return PSDevCenterSVNBase.get(this, n);
    }

    private static Object get(PSDevCenterSVNBase pSDevCenterSVNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSVNBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterSVNBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterSVNBase.getExpriedTime();
            }
            case 3: {
                return pSDevCenterSVNBase.getGitBranch();
            }
            case 4: {
                return pSDevCenterSVNBase.getGitPath();
            }
            case 5: {
                return pSDevCenterSVNBase.getGitPrj();
            }
            case 6: {
                return pSDevCenterSVNBase.getGitRepo();
            }
            case 7: {
                return pSDevCenterSVNBase.getLockMode();
            }
            case 8: {
                return pSDevCenterSVNBase.getLockObjId();
            }
            case 9: {
                return pSDevCenterSVNBase.getLockObjType();
            }
            case 10: {
                return pSDevCenterSVNBase.getMemo();
            }
            case 11: {
                return pSDevCenterSVNBase.getParam();
            }
            case 12: {
                return pSDevCenterSVNBase.getParam2();
            }
            case 13: {
                return pSDevCenterSVNBase.getPSCredentialId();
            }
            case 14: {
                return pSDevCenterSVNBase.getPSCredentialName();
            }
            case 15: {
                return pSDevCenterSVNBase.getPSDCClusterId();
            }
            case 16: {
                return pSDevCenterSVNBase.getPSDCClusterName();
            }
            case 17: {
                return pSDevCenterSVNBase.getPSDCContainerSpecId();
            }
            case 18: {
                return pSDevCenterSVNBase.getPSDCContainerSpecName();
            }
            case 19: {
                return pSDevCenterSVNBase.getPSDCFileId();
            }
            case 20: {
                return pSDevCenterSVNBase.getPSDCFileName();
            }
            case 21: {
                return pSDevCenterSVNBase.getPSDevCenterId();
            }
            case 22: {
                return pSDevCenterSVNBase.getPSDevCenterName();
            }
            case 23: {
                return pSDevCenterSVNBase.getPSDevCenterSVNId();
            }
            case 24: {
                return pSDevCenterSVNBase.getPSDevCenterSVNName();
            }
            case 25: {
                return pSDevCenterSVNBase.getPSDevSlnId();
            }
            case 26: {
                return pSDevCenterSVNBase.getPSDevSlnName();
            }
            case 27: {
                return pSDevCenterSVNBase.getPSGitUserId();
            }
            case 28: {
                return pSDevCenterSVNBase.getPSGitUserName();
            }
            case 29: {
                return pSDevCenterSVNBase.getPSSVNInstRepoId();
            }
            case 30: {
                return pSDevCenterSVNBase.getPSSVNInstRepoName();
            }
            case 31: {
                return pSDevCenterSVNBase.getPSSVNServerId();
            }
            case 32: {
                return pSDevCenterSVNBase.getRefFlag();
            }
            case 33: {
                return pSDevCenterSVNBase.getRefObjId();
            }
            case 34: {
                return pSDevCenterSVNBase.getRefObjName();
            }
            case 35: {
                return pSDevCenterSVNBase.getRefObjType();
            }
            case 36: {
                return pSDevCenterSVNBase.getResPos();
            }
            case 37: {
                return pSDevCenterSVNBase.getResState();
            }
            case 38: {
                return pSDevCenterSVNBase.getResVer();
            }
            case 39: {
                return pSDevCenterSVNBase.getROPSCredentialId();
            }
            case 40: {
                return pSDevCenterSVNBase.getROPSCredentialName();
            }
            case 41: {
                return pSDevCenterSVNBase.getSVNType();
            }
            case 42: {
                return pSDevCenterSVNBase.getTags();
            }
            case 43: {
                return pSDevCenterSVNBase.getUpdateDate();
            }
            case 44: {
                return pSDevCenterSVNBase.getUpdateMan();
            }
            case 45: {
                return pSDevCenterSVNBase.getUsage();
            }
            case 46: {
                return pSDevCenterSVNBase.getUserTag();
            }
            case 47: {
                return pSDevCenterSVNBase.getUserTag2();
            }
            case 48: {
                return pSDevCenterSVNBase.getUserTag3();
            }
            case 49: {
                return pSDevCenterSVNBase.getUserTag4();
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
        PSDevCenterSVNBase.set(this, n, object);
    }

    private static void set(PSDevCenterSVNBase pSDevCenterSVNBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterSVNBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterSVNBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterSVNBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterSVNBase.setGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterSVNBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterSVNBase.setGitPrj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterSVNBase.setGitRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterSVNBase.setLockMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterSVNBase.setLockObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterSVNBase.setLockObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterSVNBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterSVNBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterSVNBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterSVNBase.setPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterSVNBase.setPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterSVNBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevCenterSVNBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevCenterSVNBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevCenterSVNBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevCenterSVNBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevCenterSVNBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevCenterSVNBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevCenterSVNBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevCenterSVNBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevCenterSVNBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevCenterSVNBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevCenterSVNBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevCenterSVNBase.setPSGitUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevCenterSVNBase.setPSGitUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevCenterSVNBase.setPSSVNInstRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevCenterSVNBase.setPSSVNInstRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevCenterSVNBase.setPSSVNServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevCenterSVNBase.setRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDevCenterSVNBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevCenterSVNBase.setRefObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevCenterSVNBase.setRefObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevCenterSVNBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDevCenterSVNBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDevCenterSVNBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDevCenterSVNBase.setROPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevCenterSVNBase.setROPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevCenterSVNBase.setSVNType(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevCenterSVNBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevCenterSVNBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 44: {
                pSDevCenterSVNBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDevCenterSVNBase.setUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDevCenterSVNBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDevCenterSVNBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDevCenterSVNBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDevCenterSVNBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevCenterSVNBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterSVNBase pSDevCenterSVNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSVNBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterSVNBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterSVNBase.getExpriedTime() == null;
            }
            case 3: {
                return pSDevCenterSVNBase.getGitBranch() == null;
            }
            case 4: {
                return pSDevCenterSVNBase.getGitPath() == null;
            }
            case 5: {
                return pSDevCenterSVNBase.getGitPrj() == null;
            }
            case 6: {
                return pSDevCenterSVNBase.getGitRepo() == null;
            }
            case 7: {
                return pSDevCenterSVNBase.getLockMode() == null;
            }
            case 8: {
                return pSDevCenterSVNBase.getLockObjId() == null;
            }
            case 9: {
                return pSDevCenterSVNBase.getLockObjType() == null;
            }
            case 10: {
                return pSDevCenterSVNBase.getMemo() == null;
            }
            case 11: {
                return pSDevCenterSVNBase.getParam() == null;
            }
            case 12: {
                return pSDevCenterSVNBase.getParam2() == null;
            }
            case 13: {
                return pSDevCenterSVNBase.getPSCredentialId() == null;
            }
            case 14: {
                return pSDevCenterSVNBase.getPSCredentialName() == null;
            }
            case 15: {
                return pSDevCenterSVNBase.getPSDCClusterId() == null;
            }
            case 16: {
                return pSDevCenterSVNBase.getPSDCClusterName() == null;
            }
            case 17: {
                return pSDevCenterSVNBase.getPSDCContainerSpecId() == null;
            }
            case 18: {
                return pSDevCenterSVNBase.getPSDCContainerSpecName() == null;
            }
            case 19: {
                return pSDevCenterSVNBase.getPSDCFileId() == null;
            }
            case 20: {
                return pSDevCenterSVNBase.getPSDCFileName() == null;
            }
            case 21: {
                return pSDevCenterSVNBase.getPSDevCenterId() == null;
            }
            case 22: {
                return pSDevCenterSVNBase.getPSDevCenterName() == null;
            }
            case 23: {
                return pSDevCenterSVNBase.getPSDevCenterSVNId() == null;
            }
            case 24: {
                return pSDevCenterSVNBase.getPSDevCenterSVNName() == null;
            }
            case 25: {
                return pSDevCenterSVNBase.getPSDevSlnId() == null;
            }
            case 26: {
                return pSDevCenterSVNBase.getPSDevSlnName() == null;
            }
            case 27: {
                return pSDevCenterSVNBase.getPSGitUserId() == null;
            }
            case 28: {
                return pSDevCenterSVNBase.getPSGitUserName() == null;
            }
            case 29: {
                return pSDevCenterSVNBase.getPSSVNInstRepoId() == null;
            }
            case 30: {
                return pSDevCenterSVNBase.getPSSVNInstRepoName() == null;
            }
            case 31: {
                return pSDevCenterSVNBase.getPSSVNServerId() == null;
            }
            case 32: {
                return pSDevCenterSVNBase.getRefFlag() == null;
            }
            case 33: {
                return pSDevCenterSVNBase.getRefObjId() == null;
            }
            case 34: {
                return pSDevCenterSVNBase.getRefObjName() == null;
            }
            case 35: {
                return pSDevCenterSVNBase.getRefObjType() == null;
            }
            case 36: {
                return pSDevCenterSVNBase.getResPos() == null;
            }
            case 37: {
                return pSDevCenterSVNBase.getResState() == null;
            }
            case 38: {
                return pSDevCenterSVNBase.getResVer() == null;
            }
            case 39: {
                return pSDevCenterSVNBase.getROPSCredentialId() == null;
            }
            case 40: {
                return pSDevCenterSVNBase.getROPSCredentialName() == null;
            }
            case 41: {
                return pSDevCenterSVNBase.getSVNType() == null;
            }
            case 42: {
                return pSDevCenterSVNBase.getTags() == null;
            }
            case 43: {
                return pSDevCenterSVNBase.getUpdateDate() == null;
            }
            case 44: {
                return pSDevCenterSVNBase.getUpdateMan() == null;
            }
            case 45: {
                return pSDevCenterSVNBase.getUsage() == null;
            }
            case 46: {
                return pSDevCenterSVNBase.getUserTag() == null;
            }
            case 47: {
                return pSDevCenterSVNBase.getUserTag2() == null;
            }
            case 48: {
                return pSDevCenterSVNBase.getUserTag3() == null;
            }
            case 49: {
                return pSDevCenterSVNBase.getUserTag4() == null;
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
        return PSDevCenterSVNBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterSVNBase pSDevCenterSVNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSVNBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterSVNBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterSVNBase.isExpriedTimeDirty();
            }
            case 3: {
                return pSDevCenterSVNBase.isGitBranchDirty();
            }
            case 4: {
                return pSDevCenterSVNBase.isGitPathDirty();
            }
            case 5: {
                return pSDevCenterSVNBase.isGitPrjDirty();
            }
            case 6: {
                return pSDevCenterSVNBase.isGitRepoDirty();
            }
            case 7: {
                return pSDevCenterSVNBase.isLockModeDirty();
            }
            case 8: {
                return pSDevCenterSVNBase.isLockObjIdDirty();
            }
            case 9: {
                return pSDevCenterSVNBase.isLockObjTypeDirty();
            }
            case 10: {
                return pSDevCenterSVNBase.isMemoDirty();
            }
            case 11: {
                return pSDevCenterSVNBase.isParamDirty();
            }
            case 12: {
                return pSDevCenterSVNBase.isParam2Dirty();
            }
            case 13: {
                return pSDevCenterSVNBase.isPSCredentialIdDirty();
            }
            case 14: {
                return pSDevCenterSVNBase.isPSCredentialNameDirty();
            }
            case 15: {
                return pSDevCenterSVNBase.isPSDCClusterIdDirty();
            }
            case 16: {
                return pSDevCenterSVNBase.isPSDCClusterNameDirty();
            }
            case 17: {
                return pSDevCenterSVNBase.isPSDCContainerSpecIdDirty();
            }
            case 18: {
                return pSDevCenterSVNBase.isPSDCContainerSpecNameDirty();
            }
            case 19: {
                return pSDevCenterSVNBase.isPSDCFileIdDirty();
            }
            case 20: {
                return pSDevCenterSVNBase.isPSDCFileNameDirty();
            }
            case 21: {
                return pSDevCenterSVNBase.isPSDevCenterIdDirty();
            }
            case 22: {
                return pSDevCenterSVNBase.isPSDevCenterNameDirty();
            }
            case 23: {
                return pSDevCenterSVNBase.isPSDevCenterSVNIdDirty();
            }
            case 24: {
                return pSDevCenterSVNBase.isPSDevCenterSVNNameDirty();
            }
            case 25: {
                return pSDevCenterSVNBase.isPSDevSlnIdDirty();
            }
            case 26: {
                return pSDevCenterSVNBase.isPSDevSlnNameDirty();
            }
            case 27: {
                return pSDevCenterSVNBase.isPSGitUserIdDirty();
            }
            case 28: {
                return pSDevCenterSVNBase.isPSGitUserNameDirty();
            }
            case 29: {
                return pSDevCenterSVNBase.isPSSVNInstRepoIdDirty();
            }
            case 30: {
                return pSDevCenterSVNBase.isPSSVNInstRepoNameDirty();
            }
            case 31: {
                return pSDevCenterSVNBase.isPSSVNServerIdDirty();
            }
            case 32: {
                return pSDevCenterSVNBase.isRefFlagDirty();
            }
            case 33: {
                return pSDevCenterSVNBase.isRefObjIdDirty();
            }
            case 34: {
                return pSDevCenterSVNBase.isRefObjNameDirty();
            }
            case 35: {
                return pSDevCenterSVNBase.isRefObjTypeDirty();
            }
            case 36: {
                return pSDevCenterSVNBase.isResPosDirty();
            }
            case 37: {
                return pSDevCenterSVNBase.isResStateDirty();
            }
            case 38: {
                return pSDevCenterSVNBase.isResVerDirty();
            }
            case 39: {
                return pSDevCenterSVNBase.isROPSCredentialIdDirty();
            }
            case 40: {
                return pSDevCenterSVNBase.isROPSCredentialNameDirty();
            }
            case 41: {
                return pSDevCenterSVNBase.isSVNTypeDirty();
            }
            case 42: {
                return pSDevCenterSVNBase.isTagsDirty();
            }
            case 43: {
                return pSDevCenterSVNBase.isUpdateDateDirty();
            }
            case 44: {
                return pSDevCenterSVNBase.isUpdateManDirty();
            }
            case 45: {
                return pSDevCenterSVNBase.isUsageDirty();
            }
            case 46: {
                return pSDevCenterSVNBase.isUserTagDirty();
            }
            case 47: {
                return pSDevCenterSVNBase.isUserTag2Dirty();
            }
            case 48: {
                return pSDevCenterSVNBase.isUserTag3Dirty();
            }
            case 49: {
                return pSDevCenterSVNBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterSVNBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterSVNBase pSDevCenterSVNBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterSVNBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitbranch", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getGitBranch()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getGitPath()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getGitPrj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitprj", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getGitPrj()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getGitRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitrepo", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getGitRepo()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getLockMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockmode", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getLockMode()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getLockObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getLockObjId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getLockObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjtype", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getLockObjType()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getParam()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getParam2()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSCredentialId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialname", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSCredentialName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSGitUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psgituserid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSGitUserId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSGitUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psgitusername", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSGitUserName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSSVNInstRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvninstrepoid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSSVNInstRepoId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSSVNInstRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvninstreponame", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSSVNInstRepoName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getPSSVNServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvnserverid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getPSSVNServerId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refflag", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getRefFlag()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getRefObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjname", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getRefObjName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getRefObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjtype", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getRefObjType()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getResPos()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getResState()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getResVer()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getROPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropscredentialid", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getROPSCredentialId()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getROPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropscredentialname", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getROPSCredentialName()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getSVNType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svntype", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getSVNType()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getTags()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usage", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getUsage()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevCenterSVNBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevCenterSVNBase.getJSONValue((Object)pSDevCenterSVNBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterSVNBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterSVNBase pSDevCenterSVNBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterSVNBase.getCreateDate() != null) {
            object = pSDevCenterSVNBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSVNBase.getCreateMan() != null) {
            object = pSDevCenterSVNBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getExpriedTime() != null) {
            object = pSDevCenterSVNBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSVNBase.getGitBranch() != null) {
            object = pSDevCenterSVNBase.getGitBranch();
            xmlNode.setAttribute(FIELD_GITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getGitPath() != null) {
            object = pSDevCenterSVNBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getGitPrj() != null) {
            object = pSDevCenterSVNBase.getGitPrj();
            xmlNode.setAttribute(FIELD_GITPRJ, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getGitRepo() != null) {
            object = pSDevCenterSVNBase.getGitRepo();
            xmlNode.setAttribute(FIELD_GITREPO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getLockMode() != null) {
            object = pSDevCenterSVNBase.getLockMode();
            xmlNode.setAttribute(FIELD_LOCKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterSVNBase.getLockObjId() != null) {
            object = pSDevCenterSVNBase.getLockObjId();
            xmlNode.setAttribute(FIELD_LOCKOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getLockObjType() != null) {
            object = pSDevCenterSVNBase.getLockObjType();
            xmlNode.setAttribute(FIELD_LOCKOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getMemo() != null) {
            object = pSDevCenterSVNBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getParam() != null) {
            object = pSDevCenterSVNBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getParam2() != null) {
            object = pSDevCenterSVNBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSCredentialId() != null) {
            object = pSDevCenterSVNBase.getPSCredentialId();
            xmlNode.setAttribute(FIELD_PSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSCredentialName() != null) {
            object = pSDevCenterSVNBase.getPSCredentialName();
            xmlNode.setAttribute(FIELD_PSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDCClusterId() != null) {
            object = pSDevCenterSVNBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDCClusterName() != null) {
            object = pSDevCenterSVNBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDCContainerSpecId() != null) {
            object = pSDevCenterSVNBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDCContainerSpecName() != null) {
            object = pSDevCenterSVNBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDCFileId() != null) {
            object = pSDevCenterSVNBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDCFileName() != null) {
            object = pSDevCenterSVNBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDevCenterId() != null) {
            object = pSDevCenterSVNBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDevCenterName() != null) {
            object = pSDevCenterSVNBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDevCenterSVNId() != null) {
            object = pSDevCenterSVNBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDevCenterSVNName() != null) {
            object = pSDevCenterSVNBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDevSlnId() != null) {
            object = pSDevCenterSVNBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSDevSlnName() != null) {
            object = pSDevCenterSVNBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSGitUserId() != null) {
            object = pSDevCenterSVNBase.getPSGitUserId();
            xmlNode.setAttribute(FIELD_PSGITUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSGitUserName() != null) {
            object = pSDevCenterSVNBase.getPSGitUserName();
            xmlNode.setAttribute(FIELD_PSGITUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSSVNInstRepoId() != null) {
            object = pSDevCenterSVNBase.getPSSVNInstRepoId();
            xmlNode.setAttribute(FIELD_PSSVNINSTREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSSVNInstRepoName() != null) {
            object = pSDevCenterSVNBase.getPSSVNInstRepoName();
            xmlNode.setAttribute(FIELD_PSSVNINSTREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getPSSVNServerId() != null) {
            object = pSDevCenterSVNBase.getPSSVNServerId();
            xmlNode.setAttribute(FIELD_PSSVNSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getRefFlag() != null) {
            object = pSDevCenterSVNBase.getRefFlag();
            xmlNode.setAttribute(FIELD_REFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterSVNBase.getRefObjId() != null) {
            object = pSDevCenterSVNBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getRefObjName() != null) {
            object = pSDevCenterSVNBase.getRefObjName();
            xmlNode.setAttribute(FIELD_REFOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getRefObjType() != null) {
            object = pSDevCenterSVNBase.getRefObjType();
            xmlNode.setAttribute(FIELD_REFOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getResPos() != null) {
            object = pSDevCenterSVNBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterSVNBase.getResState() != null) {
            object = pSDevCenterSVNBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterSVNBase.getResVer() != null) {
            object = pSDevCenterSVNBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterSVNBase.getROPSCredentialId() != null) {
            object = pSDevCenterSVNBase.getROPSCredentialId();
            xmlNode.setAttribute(FIELD_ROPSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getROPSCredentialName() != null) {
            object = pSDevCenterSVNBase.getROPSCredentialName();
            xmlNode.setAttribute(FIELD_ROPSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getSVNType() != null) {
            object = pSDevCenterSVNBase.getSVNType();
            xmlNode.setAttribute(FIELD_SVNTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getTags() != null) {
            object = pSDevCenterSVNBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getUpdateDate() != null) {
            object = pSDevCenterSVNBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSVNBase.getUpdateMan() != null) {
            object = pSDevCenterSVNBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getUsage() != null) {
            object = pSDevCenterSVNBase.getUsage();
            xmlNode.setAttribute(FIELD_USAGE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getUserTag() != null) {
            object = pSDevCenterSVNBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getUserTag2() != null) {
            object = pSDevCenterSVNBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getUserTag3() != null) {
            object = pSDevCenterSVNBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSVNBase.getUserTag4() != null) {
            object = pSDevCenterSVNBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterSVNBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterSVNBase pSDevCenterSVNBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterSVNBase.isCreateDateDirty() && (bl || pSDevCenterSVNBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterSVNBase.getCreateDate());
        }
        if (pSDevCenterSVNBase.isCreateManDirty() && (bl || pSDevCenterSVNBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterSVNBase.getCreateMan());
        }
        if (pSDevCenterSVNBase.isExpriedTimeDirty() && (bl || pSDevCenterSVNBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevCenterSVNBase.getExpriedTime());
        }
        if (pSDevCenterSVNBase.isGitBranchDirty() && (bl || pSDevCenterSVNBase.getGitBranch() != null)) {
            iDataObject.set(FIELD_GITBRANCH, (Object)pSDevCenterSVNBase.getGitBranch());
        }
        if (pSDevCenterSVNBase.isGitPathDirty() && (bl || pSDevCenterSVNBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSDevCenterSVNBase.getGitPath());
        }
        if (pSDevCenterSVNBase.isGitPrjDirty() && (bl || pSDevCenterSVNBase.getGitPrj() != null)) {
            iDataObject.set(FIELD_GITPRJ, (Object)pSDevCenterSVNBase.getGitPrj());
        }
        if (pSDevCenterSVNBase.isGitRepoDirty() && (bl || pSDevCenterSVNBase.getGitRepo() != null)) {
            iDataObject.set(FIELD_GITREPO, (Object)pSDevCenterSVNBase.getGitRepo());
        }
        if (pSDevCenterSVNBase.isLockModeDirty() && (bl || pSDevCenterSVNBase.getLockMode() != null)) {
            iDataObject.set(FIELD_LOCKMODE, (Object)pSDevCenterSVNBase.getLockMode());
        }
        if (pSDevCenterSVNBase.isLockObjIdDirty() && (bl || pSDevCenterSVNBase.getLockObjId() != null)) {
            iDataObject.set(FIELD_LOCKOBJID, (Object)pSDevCenterSVNBase.getLockObjId());
        }
        if (pSDevCenterSVNBase.isLockObjTypeDirty() && (bl || pSDevCenterSVNBase.getLockObjType() != null)) {
            iDataObject.set(FIELD_LOCKOBJTYPE, (Object)pSDevCenterSVNBase.getLockObjType());
        }
        if (pSDevCenterSVNBase.isMemoDirty() && (bl || pSDevCenterSVNBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterSVNBase.getMemo());
        }
        if (pSDevCenterSVNBase.isParamDirty() && (bl || pSDevCenterSVNBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDevCenterSVNBase.getParam());
        }
        if (pSDevCenterSVNBase.isParam2Dirty() && (bl || pSDevCenterSVNBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDevCenterSVNBase.getParam2());
        }
        if (pSDevCenterSVNBase.isPSCredentialIdDirty() && (bl || pSDevCenterSVNBase.getPSCredentialId() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALID, (Object)pSDevCenterSVNBase.getPSCredentialId());
        }
        if (pSDevCenterSVNBase.isPSCredentialNameDirty() && (bl || pSDevCenterSVNBase.getPSCredentialName() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALNAME, (Object)pSDevCenterSVNBase.getPSCredentialName());
        }
        if (pSDevCenterSVNBase.isPSDCClusterIdDirty() && (bl || pSDevCenterSVNBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDevCenterSVNBase.getPSDCClusterId());
        }
        if (pSDevCenterSVNBase.isPSDCClusterNameDirty() && (bl || pSDevCenterSVNBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDevCenterSVNBase.getPSDCClusterName());
        }
        if (pSDevCenterSVNBase.isPSDCContainerSpecIdDirty() && (bl || pSDevCenterSVNBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDevCenterSVNBase.getPSDCContainerSpecId());
        }
        if (pSDevCenterSVNBase.isPSDCContainerSpecNameDirty() && (bl || pSDevCenterSVNBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDevCenterSVNBase.getPSDCContainerSpecName());
        }
        if (pSDevCenterSVNBase.isPSDCFileIdDirty() && (bl || pSDevCenterSVNBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDevCenterSVNBase.getPSDCFileId());
        }
        if (pSDevCenterSVNBase.isPSDCFileNameDirty() && (bl || pSDevCenterSVNBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDevCenterSVNBase.getPSDCFileName());
        }
        if (pSDevCenterSVNBase.isPSDevCenterIdDirty() && (bl || pSDevCenterSVNBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterSVNBase.getPSDevCenterId());
        }
        if (pSDevCenterSVNBase.isPSDevCenterNameDirty() && (bl || pSDevCenterSVNBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterSVNBase.getPSDevCenterName());
        }
        if (pSDevCenterSVNBase.isPSDevCenterSVNIdDirty() && (bl || pSDevCenterSVNBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        }
        if (pSDevCenterSVNBase.isPSDevCenterSVNNameDirty() && (bl || pSDevCenterSVNBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDevCenterSVNBase.getPSDevCenterSVNName());
        }
        if (pSDevCenterSVNBase.isPSDevSlnIdDirty() && (bl || pSDevCenterSVNBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevCenterSVNBase.getPSDevSlnId());
        }
        if (pSDevCenterSVNBase.isPSDevSlnNameDirty() && (bl || pSDevCenterSVNBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevCenterSVNBase.getPSDevSlnName());
        }
        if (pSDevCenterSVNBase.isPSGitUserIdDirty() && (bl || pSDevCenterSVNBase.getPSGitUserId() != null)) {
            iDataObject.set(FIELD_PSGITUSERID, (Object)pSDevCenterSVNBase.getPSGitUserId());
        }
        if (pSDevCenterSVNBase.isPSGitUserNameDirty() && (bl || pSDevCenterSVNBase.getPSGitUserName() != null)) {
            iDataObject.set(FIELD_PSGITUSERNAME, (Object)pSDevCenterSVNBase.getPSGitUserName());
        }
        if (pSDevCenterSVNBase.isPSSVNInstRepoIdDirty() && (bl || pSDevCenterSVNBase.getPSSVNInstRepoId() != null)) {
            iDataObject.set(FIELD_PSSVNINSTREPOID, (Object)pSDevCenterSVNBase.getPSSVNInstRepoId());
        }
        if (pSDevCenterSVNBase.isPSSVNInstRepoNameDirty() && (bl || pSDevCenterSVNBase.getPSSVNInstRepoName() != null)) {
            iDataObject.set(FIELD_PSSVNINSTREPONAME, (Object)pSDevCenterSVNBase.getPSSVNInstRepoName());
        }
        if (pSDevCenterSVNBase.isPSSVNServerIdDirty() && (bl || pSDevCenterSVNBase.getPSSVNServerId() != null)) {
            iDataObject.set(FIELD_PSSVNSERVERID, (Object)pSDevCenterSVNBase.getPSSVNServerId());
        }
        if (pSDevCenterSVNBase.isRefFlagDirty() && (bl || pSDevCenterSVNBase.getRefFlag() != null)) {
            iDataObject.set(FIELD_REFFLAG, (Object)pSDevCenterSVNBase.getRefFlag());
        }
        if (pSDevCenterSVNBase.isRefObjIdDirty() && (bl || pSDevCenterSVNBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSDevCenterSVNBase.getRefObjId());
        }
        if (pSDevCenterSVNBase.isRefObjNameDirty() && (bl || pSDevCenterSVNBase.getRefObjName() != null)) {
            iDataObject.set(FIELD_REFOBJNAME, (Object)pSDevCenterSVNBase.getRefObjName());
        }
        if (pSDevCenterSVNBase.isRefObjTypeDirty() && (bl || pSDevCenterSVNBase.getRefObjType() != null)) {
            iDataObject.set(FIELD_REFOBJTYPE, (Object)pSDevCenterSVNBase.getRefObjType());
        }
        if (pSDevCenterSVNBase.isResPosDirty() && (bl || pSDevCenterSVNBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDevCenterSVNBase.getResPos());
        }
        if (pSDevCenterSVNBase.isResStateDirty() && (bl || pSDevCenterSVNBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDevCenterSVNBase.getResState());
        }
        if (pSDevCenterSVNBase.isResVerDirty() && (bl || pSDevCenterSVNBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDevCenterSVNBase.getResVer());
        }
        if (pSDevCenterSVNBase.isROPSCredentialIdDirty() && (bl || pSDevCenterSVNBase.getROPSCredentialId() != null)) {
            iDataObject.set(FIELD_ROPSCREDENTIALID, (Object)pSDevCenterSVNBase.getROPSCredentialId());
        }
        if (pSDevCenterSVNBase.isROPSCredentialNameDirty() && (bl || pSDevCenterSVNBase.getROPSCredentialName() != null)) {
            iDataObject.set(FIELD_ROPSCREDENTIALNAME, (Object)pSDevCenterSVNBase.getROPSCredentialName());
        }
        if (pSDevCenterSVNBase.isSVNTypeDirty() && (bl || pSDevCenterSVNBase.getSVNType() != null)) {
            iDataObject.set(FIELD_SVNTYPE, (Object)pSDevCenterSVNBase.getSVNType());
        }
        if (pSDevCenterSVNBase.isTagsDirty() && (bl || pSDevCenterSVNBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSDevCenterSVNBase.getTags());
        }
        if (pSDevCenterSVNBase.isUpdateDateDirty() && (bl || pSDevCenterSVNBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterSVNBase.getUpdateDate());
        }
        if (pSDevCenterSVNBase.isUpdateManDirty() && (bl || pSDevCenterSVNBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterSVNBase.getUpdateMan());
        }
        if (pSDevCenterSVNBase.isUsageDirty() && (bl || pSDevCenterSVNBase.getUsage() != null)) {
            iDataObject.set(FIELD_USAGE, (Object)pSDevCenterSVNBase.getUsage());
        }
        if (pSDevCenterSVNBase.isUserTagDirty() && (bl || pSDevCenterSVNBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevCenterSVNBase.getUserTag());
        }
        if (pSDevCenterSVNBase.isUserTag2Dirty() && (bl || pSDevCenterSVNBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevCenterSVNBase.getUserTag2());
        }
        if (pSDevCenterSVNBase.isUserTag3Dirty() && (bl || pSDevCenterSVNBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevCenterSVNBase.getUserTag3());
        }
        if (pSDevCenterSVNBase.isUserTag4Dirty() && (bl || pSDevCenterSVNBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevCenterSVNBase.getUserTag4());
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
        return PSDevCenterSVNBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterSVNBase pSDevCenterSVNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterSVNBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterSVNBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterSVNBase.resetExpriedTime();
                return true;
            }
            case 3: {
                pSDevCenterSVNBase.resetGitBranch();
                return true;
            }
            case 4: {
                pSDevCenterSVNBase.resetGitPath();
                return true;
            }
            case 5: {
                pSDevCenterSVNBase.resetGitPrj();
                return true;
            }
            case 6: {
                pSDevCenterSVNBase.resetGitRepo();
                return true;
            }
            case 7: {
                pSDevCenterSVNBase.resetLockMode();
                return true;
            }
            case 8: {
                pSDevCenterSVNBase.resetLockObjId();
                return true;
            }
            case 9: {
                pSDevCenterSVNBase.resetLockObjType();
                return true;
            }
            case 10: {
                pSDevCenterSVNBase.resetMemo();
                return true;
            }
            case 11: {
                pSDevCenterSVNBase.resetParam();
                return true;
            }
            case 12: {
                pSDevCenterSVNBase.resetParam2();
                return true;
            }
            case 13: {
                pSDevCenterSVNBase.resetPSCredentialId();
                return true;
            }
            case 14: {
                pSDevCenterSVNBase.resetPSCredentialName();
                return true;
            }
            case 15: {
                pSDevCenterSVNBase.resetPSDCClusterId();
                return true;
            }
            case 16: {
                pSDevCenterSVNBase.resetPSDCClusterName();
                return true;
            }
            case 17: {
                pSDevCenterSVNBase.resetPSDCContainerSpecId();
                return true;
            }
            case 18: {
                pSDevCenterSVNBase.resetPSDCContainerSpecName();
                return true;
            }
            case 19: {
                pSDevCenterSVNBase.resetPSDCFileId();
                return true;
            }
            case 20: {
                pSDevCenterSVNBase.resetPSDCFileName();
                return true;
            }
            case 21: {
                pSDevCenterSVNBase.resetPSDevCenterId();
                return true;
            }
            case 22: {
                pSDevCenterSVNBase.resetPSDevCenterName();
                return true;
            }
            case 23: {
                pSDevCenterSVNBase.resetPSDevCenterSVNId();
                return true;
            }
            case 24: {
                pSDevCenterSVNBase.resetPSDevCenterSVNName();
                return true;
            }
            case 25: {
                pSDevCenterSVNBase.resetPSDevSlnId();
                return true;
            }
            case 26: {
                pSDevCenterSVNBase.resetPSDevSlnName();
                return true;
            }
            case 27: {
                pSDevCenterSVNBase.resetPSGitUserId();
                return true;
            }
            case 28: {
                pSDevCenterSVNBase.resetPSGitUserName();
                return true;
            }
            case 29: {
                pSDevCenterSVNBase.resetPSSVNInstRepoId();
                return true;
            }
            case 30: {
                pSDevCenterSVNBase.resetPSSVNInstRepoName();
                return true;
            }
            case 31: {
                pSDevCenterSVNBase.resetPSSVNServerId();
                return true;
            }
            case 32: {
                pSDevCenterSVNBase.resetRefFlag();
                return true;
            }
            case 33: {
                pSDevCenterSVNBase.resetRefObjId();
                return true;
            }
            case 34: {
                pSDevCenterSVNBase.resetRefObjName();
                return true;
            }
            case 35: {
                pSDevCenterSVNBase.resetRefObjType();
                return true;
            }
            case 36: {
                pSDevCenterSVNBase.resetResPos();
                return true;
            }
            case 37: {
                pSDevCenterSVNBase.resetResState();
                return true;
            }
            case 38: {
                pSDevCenterSVNBase.resetResVer();
                return true;
            }
            case 39: {
                pSDevCenterSVNBase.resetROPSCredentialId();
                return true;
            }
            case 40: {
                pSDevCenterSVNBase.resetROPSCredentialName();
                return true;
            }
            case 41: {
                pSDevCenterSVNBase.resetSVNType();
                return true;
            }
            case 42: {
                pSDevCenterSVNBase.resetTags();
                return true;
            }
            case 43: {
                pSDevCenterSVNBase.resetUpdateDate();
                return true;
            }
            case 44: {
                pSDevCenterSVNBase.resetUpdateMan();
                return true;
            }
            case 45: {
                pSDevCenterSVNBase.resetUsage();
                return true;
            }
            case 46: {
                pSDevCenterSVNBase.resetUserTag();
                return true;
            }
            case 47: {
                pSDevCenterSVNBase.resetUserTag2();
                return true;
            }
            case 48: {
                pSDevCenterSVNBase.resetUserTag3();
                return true;
            }
            case 49: {
                pSDevCenterSVNBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCredential getPSCredential() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredential();
        }
        if (this.getPSCredentialId() == null) {
            return null;
        }
        Integer n = this.objPSCredentialLock;
        synchronized (n) {
            if (this.pscredential != null && DataTypeHelper.compare((int)25, (Object)this.getPSCredentialId(), (Object)this.pscredential.getPSCredentialId()) != 0L) {
                this.pscredential = null;
            }
            if (this.pscredential == null) {
                PSCredential pSCredential = new PSCredential();
                pSCredential.setPSCredentialId(this.getPSCredentialId());
                PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
                pSCredentialService.autoGet(pSCredential);
                this.pscredential = pSCredential;
            }
            return this.pscredential;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCredential getROPSCredential() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSCredential();
        }
        if (this.getROPSCredentialId() == null) {
            return null;
        }
        Integer n = this.objROPSCredentialLock;
        synchronized (n) {
            if (this.ropscredential != null && DataTypeHelper.compare((int)25, (Object)this.getROPSCredentialId(), (Object)this.ropscredential.getPSCredentialId()) != 0L) {
                this.ropscredential = null;
            }
            if (this.ropscredential == null) {
                PSCredential pSCredential = new PSCredential();
                pSCredential.setPSCredentialId(this.getROPSCredentialId());
                PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
                pSCredentialService.autoGet(pSCredential);
                this.ropscredential = pSCredential;
            }
            return this.ropscredential;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCluster getPSDCCluster() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCluster();
        }
        if (this.getPSDCClusterId() == null) {
            return null;
        }
        Integer n = this.objPSDCClusterLock;
        synchronized (n) {
            if (this.psdccluster != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCClusterId(), (Object)this.psdccluster.getPSDCClusterId()) != 0L) {
                this.psdccluster = null;
            }
            if (this.psdccluster == null) {
                PSDCCluster pSDCCluster = new PSDCCluster();
                pSDCCluster.setPSDCClusterId(this.getPSDCClusterId());
                PSDCClusterService pSDCClusterService = (PSDCClusterService)ServiceGlobal.getService(PSDCClusterService.class, (SessionFactory)this.getSessionFactory());
                pSDCClusterService.autoGet(pSDCCluster);
                this.psdccluster = pSDCCluster;
            }
            return this.psdccluster;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCContainerSpec getPSDCContainerSpec() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpec();
        }
        if (this.getPSDCContainerSpecId() == null) {
            return null;
        }
        Integer n = this.objPSDCContainerSpecLock;
        synchronized (n) {
            if (this.psdccontainerspec != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCContainerSpecId(), (Object)this.psdccontainerspec.getPSDCContainerSpecId()) != 0L) {
                this.psdccontainerspec = null;
            }
            if (this.psdccontainerspec == null) {
                PSDCContainerSpec pSDCContainerSpec = new PSDCContainerSpec();
                pSDCContainerSpec.setPSDCContainerSpecId(this.getPSDCContainerSpecId());
                PSDCContainerSpecService pSDCContainerSpecService = (PSDCContainerSpecService)ServiceGlobal.getService(PSDCContainerSpecService.class, (SessionFactory)this.getSessionFactory());
                pSDCContainerSpecService.autoGet(pSDCContainerSpec);
                this.psdccontainerspec = pSDCContainerSpec;
            }
            return this.psdccontainerspec;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCFile getPSDCFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFile();
        }
        if (this.getPSDCFileId() == null) {
            return null;
        }
        Integer n = this.objPSDCFileLock;
        synchronized (n) {
            if (this.psdcfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCFileId(), (Object)this.psdcfile.getPSDCFileId()) != 0L) {
                this.psdcfile = null;
            }
            if (this.psdcfile == null) {
                PSDCFile pSDCFile = new PSDCFile();
                pSDCFile.setPSDCFileId(this.getPSDCFileId());
                PSDCFileService pSDCFileService = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
                pSDCFileService.autoGet(pSDCFile);
                this.psdcfile = pSDCFile;
            }
            return this.psdcfile;
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
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
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSGitUser getPSGitUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSGitUser();
        }
        if (this.getPSGitUserId() == null) {
            return null;
        }
        Integer n = this.objPSGitUserLock;
        synchronized (n) {
            if (this.psgituser != null && DataTypeHelper.compare((int)25, (Object)this.getPSGitUserId(), (Object)this.psgituser.getPSGitUserId()) != 0L) {
                this.psgituser = null;
            }
            if (this.psgituser == null) {
                PSGitUser pSGitUser = new PSGitUser();
                pSGitUser.setPSGitUserId(this.getPSGitUserId());
                PSGitUserService pSGitUserService = (PSGitUserService)ServiceGlobal.getService(PSGitUserService.class, (SessionFactory)this.getSessionFactory());
                pSGitUserService.autoGet(pSGitUser);
                this.psgituser = pSGitUser;
            }
            return this.psgituser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSVNInstRepo getPSSVNInstRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVNInstRepo();
        }
        if (this.getPSSVNInstRepoId() == null) {
            return null;
        }
        Integer n = this.objPSSVNInstRepoLock;
        synchronized (n) {
            if (this.pssvninstrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSSVNInstRepoId(), (Object)this.pssvninstrepo.getPSSVNInstRepoId()) != 0L) {
                this.pssvninstrepo = null;
            }
            if (this.pssvninstrepo == null) {
                PSSVNInstRepo pSSVNInstRepo = new PSSVNInstRepo();
                pSSVNInstRepo.setPSSVNInstRepoId(this.getPSSVNInstRepoId());
                PSSVNInstRepoService pSSVNInstRepoService = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)this.getSessionFactory());
                pSSVNInstRepoService.autoGet(pSSVNInstRepo);
                this.pssvninstrepo = pSSVNInstRepo;
            }
            return this.pssvninstrepo;
        }
    }

    private PSDevCenterSVNBase getProxyEntity() {
        return this.proxyPSDevCenterSVNBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterSVNBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterSVNBase) {
            this.proxyPSDevCenterSVNBase = (PSDevCenterSVNBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 2);
        fieldIndexMap.put(FIELD_GITBRANCH, 3);
        fieldIndexMap.put(FIELD_GITPATH, 4);
        fieldIndexMap.put(FIELD_GITPRJ, 5);
        fieldIndexMap.put(FIELD_GITREPO, 6);
        fieldIndexMap.put(FIELD_LOCKMODE, 7);
        fieldIndexMap.put(FIELD_LOCKOBJID, 8);
        fieldIndexMap.put(FIELD_LOCKOBJTYPE, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PARAM, 11);
        fieldIndexMap.put(FIELD_PARAM2, 12);
        fieldIndexMap.put(FIELD_PSCREDENTIALID, 13);
        fieldIndexMap.put(FIELD_PSCREDENTIALNAME, 14);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 15);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 16);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 17);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 18);
        fieldIndexMap.put(FIELD_PSDCFILEID, 19);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 21);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 23);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 24);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 25);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 26);
        fieldIndexMap.put(FIELD_PSGITUSERID, 27);
        fieldIndexMap.put(FIELD_PSGITUSERNAME, 28);
        fieldIndexMap.put(FIELD_PSSVNINSTREPOID, 29);
        fieldIndexMap.put(FIELD_PSSVNINSTREPONAME, 30);
        fieldIndexMap.put(FIELD_PSSVNSERVERID, 31);
        fieldIndexMap.put(FIELD_REFFLAG, 32);
        fieldIndexMap.put(FIELD_REFOBJID, 33);
        fieldIndexMap.put(FIELD_REFOBJNAME, 34);
        fieldIndexMap.put(FIELD_REFOBJTYPE, 35);
        fieldIndexMap.put(FIELD_RESPOS, 36);
        fieldIndexMap.put(FIELD_RESSTATE, 37);
        fieldIndexMap.put(FIELD_RESVER, 38);
        fieldIndexMap.put(FIELD_ROPSCREDENTIALID, 39);
        fieldIndexMap.put(FIELD_ROPSCREDENTIALNAME, 40);
        fieldIndexMap.put(FIELD_SVNTYPE, 41);
        fieldIndexMap.put(FIELD_TAGS, 42);
        fieldIndexMap.put(FIELD_UPDATEDATE, 43);
        fieldIndexMap.put(FIELD_UPDATEMAN, 44);
        fieldIndexMap.put(FIELD_USAGE, 45);
        fieldIndexMap.put(FIELD_USERTAG, 46);
        fieldIndexMap.put(FIELD_USERTAG2, 47);
        fieldIndexMap.put(FIELD_USERTAG3, 48);
        fieldIndexMap.put(FIELD_USERTAG4, 49);
    }
}

