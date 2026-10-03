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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSGitUser;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSVNInstRepoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSVNInstRepoBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GITBRANCH = "GITBRANCH";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_GITPRJ = "GITPRJ";
    public static final String FIELD_GITREPO = "GITREPO";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSGITUSERID = "PSGITUSERID";
    public static final String FIELD_PSGITUSERNAME = "PSGITUSERNAME";
    public static final String FIELD_PSSVNINSTREPOID = "PSSVNINSTREPOID";
    public static final String FIELD_PSSVNINSTREPONAME = "PSSVNINSTREPONAME";
    public static final String FIELD_PSSVNSERVERID = "PSSVNSERVERID";
    public static final String FIELD_PSSVNSERVERNAME = "PSSVNSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_REPOSTATE = "REPOSTATE";
    public static final String FIELD_REPOTAG = "REPOTAG";
    public static final String FIELD_REPOTAG2 = "REPOTAG2";
    public static final String FIELD_SVNTYPE = "SVNTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_GITBRANCH = 3;
    private static final int INDEX_GITPATH = 4;
    private static final int INDEX_GITPRJ = 5;
    private static final int INDEX_GITREPO = 6;
    private static final int INDEX_LOCALRES = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PARAM = 9;
    private static final int INDEX_PARAM2 = 10;
    private static final int INDEX_PARAM3 = 11;
    private static final int INDEX_PARAM4 = 12;
    private static final int INDEX_PARAM5 = 13;
    private static final int INDEX_PARAM6 = 14;
    private static final int INDEX_PARAM7 = 15;
    private static final int INDEX_PARAM8 = 16;
    private static final int INDEX_PSDEVCENTERID = 17;
    private static final int INDEX_PSDEVCENTERNAME = 18;
    private static final int INDEX_PSGITUSERID = 19;
    private static final int INDEX_PSGITUSERNAME = 20;
    private static final int INDEX_PSSVNINSTREPOID = 21;
    private static final int INDEX_PSSVNINSTREPONAME = 22;
    private static final int INDEX_PSSVNSERVERID = 23;
    private static final int INDEX_PSSVNSERVERNAME = 24;
    private static final int INDEX_PSSVRDOMAINID = 25;
    private static final int INDEX_PSSVRDOMAINNAME = 26;
    private static final int INDEX_READONLYMODE = 27;
    private static final int INDEX_REFINFO = 28;
    private static final int INDEX_REPOSTATE = 29;
    private static final int INDEX_REPOTAG = 30;
    private static final int INDEX_REPOTAG2 = 31;
    private static final int INDEX_SVNTYPE = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_USERTAG = 35;
    private static final int INDEX_USERTAG2 = 36;
    private static final int INDEX_USERTAG3 = 37;
    private static final int INDEX_USERTAG4 = 38;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSVNInstRepoBase proxyPSSVNInstRepoBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean gitbranchDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean gitprjDirtyFlag = false;
    private boolean gitrepoDirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psgituseridDirtyFlag = false;
    private boolean psgitusernameDirtyFlag = false;
    private boolean pssvninstrepoidDirtyFlag = false;
    private boolean pssvninstreponameDirtyFlag = false;
    private boolean pssvnserveridDirtyFlag = false;
    private boolean pssvnservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean repostateDirtyFlag = false;
    private boolean repotagDirtyFlag = false;
    private boolean repotag2DirtyFlag = false;
    private boolean svntypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="gitbranch")
    private String gitbranch;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="gitprj")
    private String gitprj;
    @Column(name="gitrepo")
    private String gitrepo;
    @Column(name="localres")
    private Integer localres;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
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
    @Column(name="pssvnservername")
    private String pssvnservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="repostate")
    private Integer repostate;
    @Column(name="repotag")
    private String repotag;
    @Column(name="repotag2")
    private String repotag2;
    @Column(name="svntype")
    private String svntype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSGitUserLock = new Integer(1);
    private PSGitUser psgituser = null;
    private Integer objPSSVNServerLock = new Integer(1);
    private PSSVNServer pssvnserver = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setConnStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.connstr = string;
        this.connstrDirtyFlag = true;
    }

    public String getConnStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnStr();
        }
        return this.connstr;
    }

    public boolean isConnStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnStrDirty();
        }
        return this.connstrDirtyFlag;
    }

    public void resetConnStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnStr();
            return;
        }
        this.connstrDirtyFlag = false;
        this.connstr = null;
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

    public void setLocalRes(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalRes(n);
            return;
        }
        this.localres = n;
        this.localresDirtyFlag = true;
    }

    public Integer getLocalRes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalRes();
        }
        return this.localres;
    }

    public boolean isLocalResDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalResDirty();
        }
        return this.localresDirtyFlag;
    }

    public void resetLocalRes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalRes();
            return;
        }
        this.localresDirtyFlag = false;
        this.localres = null;
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

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(n);
            return;
        }
        this.param5 = n;
        this.param5DirtyFlag = true;
    }

    public Integer getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(n);
            return;
        }
        this.param6 = n;
        this.param6DirtyFlag = true;
    }

    public Integer getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
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

    public void setPSSVNServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSVNServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvnservername = string;
        this.pssvnservernameDirtyFlag = true;
    }

    public String getPSSVNServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVNServerName();
        }
        return this.pssvnservername;
    }

    public boolean isPSSVNServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSVNServerNameDirty();
        }
        return this.pssvnservernameDirtyFlag;
    }

    public void resetPSSVNServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSVNServerName();
            return;
        }
        this.pssvnservernameDirtyFlag = false;
        this.pssvnservername = null;
    }

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
    }

    public void setReadOnlyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadOnlyMode(n);
            return;
        }
        this.readonlymode = n;
        this.readonlymodeDirtyFlag = true;
    }

    public Integer getReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadOnlyMode();
        }
        return this.readonlymode;
    }

    public boolean isReadOnlyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadOnlyModeDirty();
        }
        return this.readonlymodeDirtyFlag;
    }

    public void resetReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadOnlyMode();
            return;
        }
        this.readonlymodeDirtyFlag = false;
        this.readonlymode = null;
    }

    public void setRefInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refinfo = string;
        this.refinfoDirtyFlag = true;
    }

    public String getRefInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefInfo();
        }
        return this.refinfo;
    }

    public boolean isRefInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefInfoDirty();
        }
        return this.refinfoDirtyFlag;
    }

    public void resetRefInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefInfo();
            return;
        }
        this.refinfoDirtyFlag = false;
        this.refinfo = null;
    }

    public void setRepoState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepoState(n);
            return;
        }
        this.repostate = n;
        this.repostateDirtyFlag = true;
    }

    public Integer getRepoState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepoState();
        }
        return this.repostate;
    }

    public boolean isRepoStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepoStateDirty();
        }
        return this.repostateDirtyFlag;
    }

    public void resetRepoState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepoState();
            return;
        }
        this.repostateDirtyFlag = false;
        this.repostate = null;
    }

    public void setRepoTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepoTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.repotag = string;
        this.repotagDirtyFlag = true;
    }

    public String getRepoTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepoTag();
        }
        return this.repotag;
    }

    public boolean isRepoTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepoTagDirty();
        }
        return this.repotagDirtyFlag;
    }

    public void resetRepoTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepoTag();
            return;
        }
        this.repotagDirtyFlag = false;
        this.repotag = null;
    }

    public void setRepoTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepoTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.repotag2 = string;
        this.repotag2DirtyFlag = true;
    }

    public String getRepoTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepoTag2();
        }
        return this.repotag2;
    }

    public boolean isRepoTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepoTag2Dirty();
        }
        return this.repotag2DirtyFlag;
    }

    public void resetRepoTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepoTag2();
            return;
        }
        this.repotag2DirtyFlag = false;
        this.repotag2 = null;
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
        PSSVNInstRepoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSVNInstRepoBase pSSVNInstRepoBase) {
        pSSVNInstRepoBase.resetConnStr();
        pSSVNInstRepoBase.resetCreateDate();
        pSSVNInstRepoBase.resetCreateMan();
        pSSVNInstRepoBase.resetGitBranch();
        pSSVNInstRepoBase.resetGitPath();
        pSSVNInstRepoBase.resetGitPrj();
        pSSVNInstRepoBase.resetGitRepo();
        pSSVNInstRepoBase.resetLocalRes();
        pSSVNInstRepoBase.resetMemo();
        pSSVNInstRepoBase.resetParam();
        pSSVNInstRepoBase.resetParam2();
        pSSVNInstRepoBase.resetParam3();
        pSSVNInstRepoBase.resetParam4();
        pSSVNInstRepoBase.resetParam5();
        pSSVNInstRepoBase.resetParam6();
        pSSVNInstRepoBase.resetParam7();
        pSSVNInstRepoBase.resetParam8();
        pSSVNInstRepoBase.resetPSDevCenterId();
        pSSVNInstRepoBase.resetPSDevCenterName();
        pSSVNInstRepoBase.resetPSGitUserId();
        pSSVNInstRepoBase.resetPSGitUserName();
        pSSVNInstRepoBase.resetPSSVNInstRepoId();
        pSSVNInstRepoBase.resetPSSVNInstRepoName();
        pSSVNInstRepoBase.resetPSSVNServerId();
        pSSVNInstRepoBase.resetPSSVNServerName();
        pSSVNInstRepoBase.resetPSSvrDomainId();
        pSSVNInstRepoBase.resetPSSvrDomainName();
        pSSVNInstRepoBase.resetReadOnlyMode();
        pSSVNInstRepoBase.resetRefInfo();
        pSSVNInstRepoBase.resetRepoState();
        pSSVNInstRepoBase.resetRepoTag();
        pSSVNInstRepoBase.resetRepoTag2();
        pSSVNInstRepoBase.resetSVNType();
        pSSVNInstRepoBase.resetUpdateDate();
        pSSVNInstRepoBase.resetUpdateMan();
        pSSVNInstRepoBase.resetUserTag();
        pSSVNInstRepoBase.resetUserTag2();
        pSSVNInstRepoBase.resetUserTag3();
        pSSVNInstRepoBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConnStrDirty()) {
            hashMap.put(FIELD_CONNSTR, this.getConnStr());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
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
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
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
        if (!bl || this.isPSSVNServerNameDirty()) {
            hashMap.put(FIELD_PSSVNSERVERNAME, this.getPSSVNServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isRepoStateDirty()) {
            hashMap.put(FIELD_REPOSTATE, this.getRepoState());
        }
        if (!bl || this.isRepoTagDirty()) {
            hashMap.put(FIELD_REPOTAG, this.getRepoTag());
        }
        if (!bl || this.isRepoTag2Dirty()) {
            hashMap.put(FIELD_REPOTAG2, this.getRepoTag2());
        }
        if (!bl || this.isSVNTypeDirty()) {
            hashMap.put(FIELD_SVNTYPE, this.getSVNType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSVNInstRepoBase.get(this, n);
    }

    private static Object get(PSSVNInstRepoBase pSSVNInstRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSVNInstRepoBase.getConnStr();
            }
            case 1: {
                return pSSVNInstRepoBase.getCreateDate();
            }
            case 2: {
                return pSSVNInstRepoBase.getCreateMan();
            }
            case 3: {
                return pSSVNInstRepoBase.getGitBranch();
            }
            case 4: {
                return pSSVNInstRepoBase.getGitPath();
            }
            case 5: {
                return pSSVNInstRepoBase.getGitPrj();
            }
            case 6: {
                return pSSVNInstRepoBase.getGitRepo();
            }
            case 7: {
                return pSSVNInstRepoBase.getLocalRes();
            }
            case 8: {
                return pSSVNInstRepoBase.getMemo();
            }
            case 9: {
                return pSSVNInstRepoBase.getParam();
            }
            case 10: {
                return pSSVNInstRepoBase.getParam2();
            }
            case 11: {
                return pSSVNInstRepoBase.getParam3();
            }
            case 12: {
                return pSSVNInstRepoBase.getParam4();
            }
            case 13: {
                return pSSVNInstRepoBase.getParam5();
            }
            case 14: {
                return pSSVNInstRepoBase.getParam6();
            }
            case 15: {
                return pSSVNInstRepoBase.getParam7();
            }
            case 16: {
                return pSSVNInstRepoBase.getParam8();
            }
            case 17: {
                return pSSVNInstRepoBase.getPSDevCenterId();
            }
            case 18: {
                return pSSVNInstRepoBase.getPSDevCenterName();
            }
            case 19: {
                return pSSVNInstRepoBase.getPSGitUserId();
            }
            case 20: {
                return pSSVNInstRepoBase.getPSGitUserName();
            }
            case 21: {
                return pSSVNInstRepoBase.getPSSVNInstRepoId();
            }
            case 22: {
                return pSSVNInstRepoBase.getPSSVNInstRepoName();
            }
            case 23: {
                return pSSVNInstRepoBase.getPSSVNServerId();
            }
            case 24: {
                return pSSVNInstRepoBase.getPSSVNServerName();
            }
            case 25: {
                return pSSVNInstRepoBase.getPSSvrDomainId();
            }
            case 26: {
                return pSSVNInstRepoBase.getPSSvrDomainName();
            }
            case 27: {
                return pSSVNInstRepoBase.getReadOnlyMode();
            }
            case 28: {
                return pSSVNInstRepoBase.getRefInfo();
            }
            case 29: {
                return pSSVNInstRepoBase.getRepoState();
            }
            case 30: {
                return pSSVNInstRepoBase.getRepoTag();
            }
            case 31: {
                return pSSVNInstRepoBase.getRepoTag2();
            }
            case 32: {
                return pSSVNInstRepoBase.getSVNType();
            }
            case 33: {
                return pSSVNInstRepoBase.getUpdateDate();
            }
            case 34: {
                return pSSVNInstRepoBase.getUpdateMan();
            }
            case 35: {
                return pSSVNInstRepoBase.getUserTag();
            }
            case 36: {
                return pSSVNInstRepoBase.getUserTag2();
            }
            case 37: {
                return pSSVNInstRepoBase.getUserTag3();
            }
            case 38: {
                return pSSVNInstRepoBase.getUserTag4();
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
        PSSVNInstRepoBase.set(this, n, object);
    }

    private static void set(PSSVNInstRepoBase pSSVNInstRepoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSVNInstRepoBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSVNInstRepoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSVNInstRepoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSVNInstRepoBase.setGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSVNInstRepoBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSVNInstRepoBase.setGitPrj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSVNInstRepoBase.setGitRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSVNInstRepoBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSVNInstRepoBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSVNInstRepoBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSVNInstRepoBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSVNInstRepoBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSVNInstRepoBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSVNInstRepoBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSVNInstRepoBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSVNInstRepoBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSVNInstRepoBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSVNInstRepoBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSVNInstRepoBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSVNInstRepoBase.setPSGitUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSVNInstRepoBase.setPSGitUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSVNInstRepoBase.setPSSVNInstRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSVNInstRepoBase.setPSSVNInstRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSVNInstRepoBase.setPSSVNServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSVNInstRepoBase.setPSSVNServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSVNInstRepoBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSVNInstRepoBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSVNInstRepoBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSVNInstRepoBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSVNInstRepoBase.setRepoState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSVNInstRepoBase.setRepoTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSVNInstRepoBase.setRepoTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSVNInstRepoBase.setSVNType(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSVNInstRepoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSSVNInstRepoBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSVNInstRepoBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSVNInstRepoBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSVNInstRepoBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSVNInstRepoBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSVNInstRepoBase.isNull(this, n);
    }

    private static boolean isNull(PSSVNInstRepoBase pSSVNInstRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSVNInstRepoBase.getConnStr() == null;
            }
            case 1: {
                return pSSVNInstRepoBase.getCreateDate() == null;
            }
            case 2: {
                return pSSVNInstRepoBase.getCreateMan() == null;
            }
            case 3: {
                return pSSVNInstRepoBase.getGitBranch() == null;
            }
            case 4: {
                return pSSVNInstRepoBase.getGitPath() == null;
            }
            case 5: {
                return pSSVNInstRepoBase.getGitPrj() == null;
            }
            case 6: {
                return pSSVNInstRepoBase.getGitRepo() == null;
            }
            case 7: {
                return pSSVNInstRepoBase.getLocalRes() == null;
            }
            case 8: {
                return pSSVNInstRepoBase.getMemo() == null;
            }
            case 9: {
                return pSSVNInstRepoBase.getParam() == null;
            }
            case 10: {
                return pSSVNInstRepoBase.getParam2() == null;
            }
            case 11: {
                return pSSVNInstRepoBase.getParam3() == null;
            }
            case 12: {
                return pSSVNInstRepoBase.getParam4() == null;
            }
            case 13: {
                return pSSVNInstRepoBase.getParam5() == null;
            }
            case 14: {
                return pSSVNInstRepoBase.getParam6() == null;
            }
            case 15: {
                return pSSVNInstRepoBase.getParam7() == null;
            }
            case 16: {
                return pSSVNInstRepoBase.getParam8() == null;
            }
            case 17: {
                return pSSVNInstRepoBase.getPSDevCenterId() == null;
            }
            case 18: {
                return pSSVNInstRepoBase.getPSDevCenterName() == null;
            }
            case 19: {
                return pSSVNInstRepoBase.getPSGitUserId() == null;
            }
            case 20: {
                return pSSVNInstRepoBase.getPSGitUserName() == null;
            }
            case 21: {
                return pSSVNInstRepoBase.getPSSVNInstRepoId() == null;
            }
            case 22: {
                return pSSVNInstRepoBase.getPSSVNInstRepoName() == null;
            }
            case 23: {
                return pSSVNInstRepoBase.getPSSVNServerId() == null;
            }
            case 24: {
                return pSSVNInstRepoBase.getPSSVNServerName() == null;
            }
            case 25: {
                return pSSVNInstRepoBase.getPSSvrDomainId() == null;
            }
            case 26: {
                return pSSVNInstRepoBase.getPSSvrDomainName() == null;
            }
            case 27: {
                return pSSVNInstRepoBase.getReadOnlyMode() == null;
            }
            case 28: {
                return pSSVNInstRepoBase.getRefInfo() == null;
            }
            case 29: {
                return pSSVNInstRepoBase.getRepoState() == null;
            }
            case 30: {
                return pSSVNInstRepoBase.getRepoTag() == null;
            }
            case 31: {
                return pSSVNInstRepoBase.getRepoTag2() == null;
            }
            case 32: {
                return pSSVNInstRepoBase.getSVNType() == null;
            }
            case 33: {
                return pSSVNInstRepoBase.getUpdateDate() == null;
            }
            case 34: {
                return pSSVNInstRepoBase.getUpdateMan() == null;
            }
            case 35: {
                return pSSVNInstRepoBase.getUserTag() == null;
            }
            case 36: {
                return pSSVNInstRepoBase.getUserTag2() == null;
            }
            case 37: {
                return pSSVNInstRepoBase.getUserTag3() == null;
            }
            case 38: {
                return pSSVNInstRepoBase.getUserTag4() == null;
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
        return PSSVNInstRepoBase.contains(this, n);
    }

    private static boolean contains(PSSVNInstRepoBase pSSVNInstRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSVNInstRepoBase.isConnStrDirty();
            }
            case 1: {
                return pSSVNInstRepoBase.isCreateDateDirty();
            }
            case 2: {
                return pSSVNInstRepoBase.isCreateManDirty();
            }
            case 3: {
                return pSSVNInstRepoBase.isGitBranchDirty();
            }
            case 4: {
                return pSSVNInstRepoBase.isGitPathDirty();
            }
            case 5: {
                return pSSVNInstRepoBase.isGitPrjDirty();
            }
            case 6: {
                return pSSVNInstRepoBase.isGitRepoDirty();
            }
            case 7: {
                return pSSVNInstRepoBase.isLocalResDirty();
            }
            case 8: {
                return pSSVNInstRepoBase.isMemoDirty();
            }
            case 9: {
                return pSSVNInstRepoBase.isParamDirty();
            }
            case 10: {
                return pSSVNInstRepoBase.isParam2Dirty();
            }
            case 11: {
                return pSSVNInstRepoBase.isParam3Dirty();
            }
            case 12: {
                return pSSVNInstRepoBase.isParam4Dirty();
            }
            case 13: {
                return pSSVNInstRepoBase.isParam5Dirty();
            }
            case 14: {
                return pSSVNInstRepoBase.isParam6Dirty();
            }
            case 15: {
                return pSSVNInstRepoBase.isParam7Dirty();
            }
            case 16: {
                return pSSVNInstRepoBase.isParam8Dirty();
            }
            case 17: {
                return pSSVNInstRepoBase.isPSDevCenterIdDirty();
            }
            case 18: {
                return pSSVNInstRepoBase.isPSDevCenterNameDirty();
            }
            case 19: {
                return pSSVNInstRepoBase.isPSGitUserIdDirty();
            }
            case 20: {
                return pSSVNInstRepoBase.isPSGitUserNameDirty();
            }
            case 21: {
                return pSSVNInstRepoBase.isPSSVNInstRepoIdDirty();
            }
            case 22: {
                return pSSVNInstRepoBase.isPSSVNInstRepoNameDirty();
            }
            case 23: {
                return pSSVNInstRepoBase.isPSSVNServerIdDirty();
            }
            case 24: {
                return pSSVNInstRepoBase.isPSSVNServerNameDirty();
            }
            case 25: {
                return pSSVNInstRepoBase.isPSSvrDomainIdDirty();
            }
            case 26: {
                return pSSVNInstRepoBase.isPSSvrDomainNameDirty();
            }
            case 27: {
                return pSSVNInstRepoBase.isReadOnlyModeDirty();
            }
            case 28: {
                return pSSVNInstRepoBase.isRefInfoDirty();
            }
            case 29: {
                return pSSVNInstRepoBase.isRepoStateDirty();
            }
            case 30: {
                return pSSVNInstRepoBase.isRepoTagDirty();
            }
            case 31: {
                return pSSVNInstRepoBase.isRepoTag2Dirty();
            }
            case 32: {
                return pSSVNInstRepoBase.isSVNTypeDirty();
            }
            case 33: {
                return pSSVNInstRepoBase.isUpdateDateDirty();
            }
            case 34: {
                return pSSVNInstRepoBase.isUpdateManDirty();
            }
            case 35: {
                return pSSVNInstRepoBase.isUserTagDirty();
            }
            case 36: {
                return pSSVNInstRepoBase.isUserTag2Dirty();
            }
            case 37: {
                return pSSVNInstRepoBase.isUserTag3Dirty();
            }
            case 38: {
                return pSSVNInstRepoBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSVNInstRepoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSVNInstRepoBase pSSVNInstRepoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSVNInstRepoBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getConnStr()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitbranch", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getGitBranch()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getGitPath()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getGitPrj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitprj", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getGitPrj()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getGitRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitrepo", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getGitRepo()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getMemo()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getParam()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getParam2()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getParam3()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getParam4()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getParam5()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getParam6()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getParam7()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getParam8()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSGitUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psgituserid", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSGitUserId()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSGitUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psgitusername", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSGitUserName()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSSVNInstRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvninstrepoid", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSSVNInstRepoId()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSSVNInstRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvninstreponame", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSSVNInstRepoName()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSSVNServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvnserverid", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSSVNServerId()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSSVNServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvnservername", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSSVNServerName()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getRepoState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repostate", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getRepoState()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getRepoTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repotag", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getRepoTag()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getRepoTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repotag2", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getRepoTag2()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getSVNType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svntype", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getSVNType()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSVNInstRepoBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSVNInstRepoBase.getJSONValue((Object)pSSVNInstRepoBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSVNInstRepoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSVNInstRepoBase pSSVNInstRepoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSVNInstRepoBase.getConnStr() != null) {
            object = pSSVNInstRepoBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getCreateDate() != null) {
            object = pSSVNInstRepoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getCreateMan() != null) {
            object = pSSVNInstRepoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getGitBranch() != null) {
            object = pSSVNInstRepoBase.getGitBranch();
            xmlNode.setAttribute(FIELD_GITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getGitPath() != null) {
            object = pSSVNInstRepoBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getGitPrj() != null) {
            object = pSSVNInstRepoBase.getGitPrj();
            xmlNode.setAttribute(FIELD_GITPRJ, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getGitRepo() != null) {
            object = pSSVNInstRepoBase.getGitRepo();
            xmlNode.setAttribute(FIELD_GITREPO, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getLocalRes() != null) {
            object = pSSVNInstRepoBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getMemo() != null) {
            object = pSSVNInstRepoBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getParam() != null) {
            object = pSSVNInstRepoBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getParam2() != null) {
            object = pSSVNInstRepoBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getParam3() != null) {
            object = pSSVNInstRepoBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getParam4() != null) {
            object = pSSVNInstRepoBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getParam5() != null) {
            object = pSSVNInstRepoBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getParam6() != null) {
            object = pSSVNInstRepoBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getParam7() != null) {
            object = pSSVNInstRepoBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getParam8() != null) {
            object = pSSVNInstRepoBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getPSDevCenterId() != null) {
            object = pSSVNInstRepoBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSDevCenterName() != null) {
            object = pSSVNInstRepoBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSGitUserId() != null) {
            object = pSSVNInstRepoBase.getPSGitUserId();
            xmlNode.setAttribute(FIELD_PSGITUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSGitUserName() != null) {
            object = pSSVNInstRepoBase.getPSGitUserName();
            xmlNode.setAttribute(FIELD_PSGITUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSSVNInstRepoId() != null) {
            object = pSSVNInstRepoBase.getPSSVNInstRepoId();
            xmlNode.setAttribute(FIELD_PSSVNINSTREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSSVNInstRepoName() != null) {
            object = pSSVNInstRepoBase.getPSSVNInstRepoName();
            xmlNode.setAttribute(FIELD_PSSVNINSTREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSSVNServerId() != null) {
            object = pSSVNInstRepoBase.getPSSVNServerId();
            xmlNode.setAttribute(FIELD_PSSVNSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSSVNServerName() != null) {
            object = pSSVNInstRepoBase.getPSSVNServerName();
            xmlNode.setAttribute(FIELD_PSSVNSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSSvrDomainId() != null) {
            object = pSSVNInstRepoBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getPSSvrDomainName() != null) {
            object = pSSVNInstRepoBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getReadOnlyMode() != null) {
            object = pSSVNInstRepoBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getRefInfo() != null) {
            object = pSSVNInstRepoBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getRepoState() != null) {
            object = pSSVNInstRepoBase.getRepoState();
            xmlNode.setAttribute(FIELD_REPOSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getRepoTag() != null) {
            object = pSSVNInstRepoBase.getRepoTag();
            xmlNode.setAttribute(FIELD_REPOTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getRepoTag2() != null) {
            object = pSSVNInstRepoBase.getRepoTag2();
            xmlNode.setAttribute(FIELD_REPOTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getSVNType() != null) {
            object = pSSVNInstRepoBase.getSVNType();
            xmlNode.setAttribute(FIELD_SVNTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getUpdateDate() != null) {
            object = pSSVNInstRepoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSVNInstRepoBase.getUpdateMan() != null) {
            object = pSSVNInstRepoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getUserTag() != null) {
            object = pSSVNInstRepoBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getUserTag2() != null) {
            object = pSSVNInstRepoBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getUserTag3() != null) {
            object = pSSVNInstRepoBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSVNInstRepoBase.getUserTag4() != null) {
            object = pSSVNInstRepoBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSVNInstRepoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSVNInstRepoBase pSSVNInstRepoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSVNInstRepoBase.isConnStrDirty() && (bl || pSSVNInstRepoBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSSVNInstRepoBase.getConnStr());
        }
        if (pSSVNInstRepoBase.isCreateDateDirty() && (bl || pSSVNInstRepoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSVNInstRepoBase.getCreateDate());
        }
        if (pSSVNInstRepoBase.isCreateManDirty() && (bl || pSSVNInstRepoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSVNInstRepoBase.getCreateMan());
        }
        if (pSSVNInstRepoBase.isGitBranchDirty() && (bl || pSSVNInstRepoBase.getGitBranch() != null)) {
            iDataObject.set(FIELD_GITBRANCH, (Object)pSSVNInstRepoBase.getGitBranch());
        }
        if (pSSVNInstRepoBase.isGitPathDirty() && (bl || pSSVNInstRepoBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSSVNInstRepoBase.getGitPath());
        }
        if (pSSVNInstRepoBase.isGitPrjDirty() && (bl || pSSVNInstRepoBase.getGitPrj() != null)) {
            iDataObject.set(FIELD_GITPRJ, (Object)pSSVNInstRepoBase.getGitPrj());
        }
        if (pSSVNInstRepoBase.isGitRepoDirty() && (bl || pSSVNInstRepoBase.getGitRepo() != null)) {
            iDataObject.set(FIELD_GITREPO, (Object)pSSVNInstRepoBase.getGitRepo());
        }
        if (pSSVNInstRepoBase.isLocalResDirty() && (bl || pSSVNInstRepoBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSSVNInstRepoBase.getLocalRes());
        }
        if (pSSVNInstRepoBase.isMemoDirty() && (bl || pSSVNInstRepoBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSVNInstRepoBase.getMemo());
        }
        if (pSSVNInstRepoBase.isParamDirty() && (bl || pSSVNInstRepoBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSSVNInstRepoBase.getParam());
        }
        if (pSSVNInstRepoBase.isParam2Dirty() && (bl || pSSVNInstRepoBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSSVNInstRepoBase.getParam2());
        }
        if (pSSVNInstRepoBase.isParam3Dirty() && (bl || pSSVNInstRepoBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSSVNInstRepoBase.getParam3());
        }
        if (pSSVNInstRepoBase.isParam4Dirty() && (bl || pSSVNInstRepoBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSSVNInstRepoBase.getParam4());
        }
        if (pSSVNInstRepoBase.isParam5Dirty() && (bl || pSSVNInstRepoBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSSVNInstRepoBase.getParam5());
        }
        if (pSSVNInstRepoBase.isParam6Dirty() && (bl || pSSVNInstRepoBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSSVNInstRepoBase.getParam6());
        }
        if (pSSVNInstRepoBase.isParam7Dirty() && (bl || pSSVNInstRepoBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSSVNInstRepoBase.getParam7());
        }
        if (pSSVNInstRepoBase.isParam8Dirty() && (bl || pSSVNInstRepoBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSSVNInstRepoBase.getParam8());
        }
        if (pSSVNInstRepoBase.isPSDevCenterIdDirty() && (bl || pSSVNInstRepoBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSSVNInstRepoBase.getPSDevCenterId());
        }
        if (pSSVNInstRepoBase.isPSDevCenterNameDirty() && (bl || pSSVNInstRepoBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSSVNInstRepoBase.getPSDevCenterName());
        }
        if (pSSVNInstRepoBase.isPSGitUserIdDirty() && (bl || pSSVNInstRepoBase.getPSGitUserId() != null)) {
            iDataObject.set(FIELD_PSGITUSERID, (Object)pSSVNInstRepoBase.getPSGitUserId());
        }
        if (pSSVNInstRepoBase.isPSGitUserNameDirty() && (bl || pSSVNInstRepoBase.getPSGitUserName() != null)) {
            iDataObject.set(FIELD_PSGITUSERNAME, (Object)pSSVNInstRepoBase.getPSGitUserName());
        }
        if (pSSVNInstRepoBase.isPSSVNInstRepoIdDirty() && (bl || pSSVNInstRepoBase.getPSSVNInstRepoId() != null)) {
            iDataObject.set(FIELD_PSSVNINSTREPOID, (Object)pSSVNInstRepoBase.getPSSVNInstRepoId());
        }
        if (pSSVNInstRepoBase.isPSSVNInstRepoNameDirty() && (bl || pSSVNInstRepoBase.getPSSVNInstRepoName() != null)) {
            iDataObject.set(FIELD_PSSVNINSTREPONAME, (Object)pSSVNInstRepoBase.getPSSVNInstRepoName());
        }
        if (pSSVNInstRepoBase.isPSSVNServerIdDirty() && (bl || pSSVNInstRepoBase.getPSSVNServerId() != null)) {
            iDataObject.set(FIELD_PSSVNSERVERID, (Object)pSSVNInstRepoBase.getPSSVNServerId());
        }
        if (pSSVNInstRepoBase.isPSSVNServerNameDirty() && (bl || pSSVNInstRepoBase.getPSSVNServerName() != null)) {
            iDataObject.set(FIELD_PSSVNSERVERNAME, (Object)pSSVNInstRepoBase.getPSSVNServerName());
        }
        if (pSSVNInstRepoBase.isPSSvrDomainIdDirty() && (bl || pSSVNInstRepoBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSSVNInstRepoBase.getPSSvrDomainId());
        }
        if (pSSVNInstRepoBase.isPSSvrDomainNameDirty() && (bl || pSSVNInstRepoBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSSVNInstRepoBase.getPSSvrDomainName());
        }
        if (pSSVNInstRepoBase.isReadOnlyModeDirty() && (bl || pSSVNInstRepoBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSSVNInstRepoBase.getReadOnlyMode());
        }
        if (pSSVNInstRepoBase.isRefInfoDirty() && (bl || pSSVNInstRepoBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSSVNInstRepoBase.getRefInfo());
        }
        if (pSSVNInstRepoBase.isRepoStateDirty() && (bl || pSSVNInstRepoBase.getRepoState() != null)) {
            iDataObject.set(FIELD_REPOSTATE, (Object)pSSVNInstRepoBase.getRepoState());
        }
        if (pSSVNInstRepoBase.isRepoTagDirty() && (bl || pSSVNInstRepoBase.getRepoTag() != null)) {
            iDataObject.set(FIELD_REPOTAG, (Object)pSSVNInstRepoBase.getRepoTag());
        }
        if (pSSVNInstRepoBase.isRepoTag2Dirty() && (bl || pSSVNInstRepoBase.getRepoTag2() != null)) {
            iDataObject.set(FIELD_REPOTAG2, (Object)pSSVNInstRepoBase.getRepoTag2());
        }
        if (pSSVNInstRepoBase.isSVNTypeDirty() && (bl || pSSVNInstRepoBase.getSVNType() != null)) {
            iDataObject.set(FIELD_SVNTYPE, (Object)pSSVNInstRepoBase.getSVNType());
        }
        if (pSSVNInstRepoBase.isUpdateDateDirty() && (bl || pSSVNInstRepoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSVNInstRepoBase.getUpdateDate());
        }
        if (pSSVNInstRepoBase.isUpdateManDirty() && (bl || pSSVNInstRepoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSVNInstRepoBase.getUpdateMan());
        }
        if (pSSVNInstRepoBase.isUserTagDirty() && (bl || pSSVNInstRepoBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSVNInstRepoBase.getUserTag());
        }
        if (pSSVNInstRepoBase.isUserTag2Dirty() && (bl || pSSVNInstRepoBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSVNInstRepoBase.getUserTag2());
        }
        if (pSSVNInstRepoBase.isUserTag3Dirty() && (bl || pSSVNInstRepoBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSVNInstRepoBase.getUserTag3());
        }
        if (pSSVNInstRepoBase.isUserTag4Dirty() && (bl || pSSVNInstRepoBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSVNInstRepoBase.getUserTag4());
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
        return PSSVNInstRepoBase.remove(this, n);
    }

    private static boolean remove(PSSVNInstRepoBase pSSVNInstRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSVNInstRepoBase.resetConnStr();
                return true;
            }
            case 1: {
                pSSVNInstRepoBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSVNInstRepoBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSVNInstRepoBase.resetGitBranch();
                return true;
            }
            case 4: {
                pSSVNInstRepoBase.resetGitPath();
                return true;
            }
            case 5: {
                pSSVNInstRepoBase.resetGitPrj();
                return true;
            }
            case 6: {
                pSSVNInstRepoBase.resetGitRepo();
                return true;
            }
            case 7: {
                pSSVNInstRepoBase.resetLocalRes();
                return true;
            }
            case 8: {
                pSSVNInstRepoBase.resetMemo();
                return true;
            }
            case 9: {
                pSSVNInstRepoBase.resetParam();
                return true;
            }
            case 10: {
                pSSVNInstRepoBase.resetParam2();
                return true;
            }
            case 11: {
                pSSVNInstRepoBase.resetParam3();
                return true;
            }
            case 12: {
                pSSVNInstRepoBase.resetParam4();
                return true;
            }
            case 13: {
                pSSVNInstRepoBase.resetParam5();
                return true;
            }
            case 14: {
                pSSVNInstRepoBase.resetParam6();
                return true;
            }
            case 15: {
                pSSVNInstRepoBase.resetParam7();
                return true;
            }
            case 16: {
                pSSVNInstRepoBase.resetParam8();
                return true;
            }
            case 17: {
                pSSVNInstRepoBase.resetPSDevCenterId();
                return true;
            }
            case 18: {
                pSSVNInstRepoBase.resetPSDevCenterName();
                return true;
            }
            case 19: {
                pSSVNInstRepoBase.resetPSGitUserId();
                return true;
            }
            case 20: {
                pSSVNInstRepoBase.resetPSGitUserName();
                return true;
            }
            case 21: {
                pSSVNInstRepoBase.resetPSSVNInstRepoId();
                return true;
            }
            case 22: {
                pSSVNInstRepoBase.resetPSSVNInstRepoName();
                return true;
            }
            case 23: {
                pSSVNInstRepoBase.resetPSSVNServerId();
                return true;
            }
            case 24: {
                pSSVNInstRepoBase.resetPSSVNServerName();
                return true;
            }
            case 25: {
                pSSVNInstRepoBase.resetPSSvrDomainId();
                return true;
            }
            case 26: {
                pSSVNInstRepoBase.resetPSSvrDomainName();
                return true;
            }
            case 27: {
                pSSVNInstRepoBase.resetReadOnlyMode();
                return true;
            }
            case 28: {
                pSSVNInstRepoBase.resetRefInfo();
                return true;
            }
            case 29: {
                pSSVNInstRepoBase.resetRepoState();
                return true;
            }
            case 30: {
                pSSVNInstRepoBase.resetRepoTag();
                return true;
            }
            case 31: {
                pSSVNInstRepoBase.resetRepoTag2();
                return true;
            }
            case 32: {
                pSSVNInstRepoBase.resetSVNType();
                return true;
            }
            case 33: {
                pSSVNInstRepoBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSSVNInstRepoBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSSVNInstRepoBase.resetUserTag();
                return true;
            }
            case 36: {
                pSSVNInstRepoBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSSVNInstRepoBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSSVNInstRepoBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSVNServer getPSSVNServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVNServer();
        }
        if (this.getPSSVNServerId() == null) {
            return null;
        }
        Integer n = this.objPSSVNServerLock;
        synchronized (n) {
            if (this.pssvnserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSVNServerId(), (Object)this.pssvnserver.getPSSVNServerId()) != 0L) {
                this.pssvnserver = null;
            }
            if (this.pssvnserver == null) {
                PSSVNServer pSSVNServer = new PSSVNServer();
                pSSVNServer.setPSSVNServerId(this.getPSSVNServerId());
                PSSVNServerService pSSVNServerService = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)this.getSessionFactory());
                pSSVNServerService.autoGet(pSSVNServer);
                this.pssvnserver = pSSVNServer;
            }
            return this.pssvnserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSSVNInstRepoBase getProxyEntity() {
        return this.proxyPSSVNInstRepoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSVNInstRepoBase = null;
        if (iDataObject != null && iDataObject instanceof PSSVNInstRepoBase) {
            this.proxyPSSVNInstRepoBase = (PSSVNInstRepoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_GITBRANCH, 3);
        fieldIndexMap.put(FIELD_GITPATH, 4);
        fieldIndexMap.put(FIELD_GITPRJ, 5);
        fieldIndexMap.put(FIELD_GITREPO, 6);
        fieldIndexMap.put(FIELD_LOCALRES, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PARAM, 9);
        fieldIndexMap.put(FIELD_PARAM2, 10);
        fieldIndexMap.put(FIELD_PARAM3, 11);
        fieldIndexMap.put(FIELD_PARAM4, 12);
        fieldIndexMap.put(FIELD_PARAM5, 13);
        fieldIndexMap.put(FIELD_PARAM6, 14);
        fieldIndexMap.put(FIELD_PARAM7, 15);
        fieldIndexMap.put(FIELD_PARAM8, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 18);
        fieldIndexMap.put(FIELD_PSGITUSERID, 19);
        fieldIndexMap.put(FIELD_PSGITUSERNAME, 20);
        fieldIndexMap.put(FIELD_PSSVNINSTREPOID, 21);
        fieldIndexMap.put(FIELD_PSSVNINSTREPONAME, 22);
        fieldIndexMap.put(FIELD_PSSVNSERVERID, 23);
        fieldIndexMap.put(FIELD_PSSVNSERVERNAME, 24);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 25);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 26);
        fieldIndexMap.put(FIELD_READONLYMODE, 27);
        fieldIndexMap.put(FIELD_REFINFO, 28);
        fieldIndexMap.put(FIELD_REPOSTATE, 29);
        fieldIndexMap.put(FIELD_REPOTAG, 30);
        fieldIndexMap.put(FIELD_REPOTAG2, 31);
        fieldIndexMap.put(FIELD_SVNTYPE, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_USERTAG, 35);
        fieldIndexMap.put(FIELD_USERTAG2, 36);
        fieldIndexMap.put(FIELD_USERTAG3, 37);
        fieldIndexMap.put(FIELD_USERTAG4, 38);
    }
}

