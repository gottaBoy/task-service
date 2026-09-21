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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysModelRepoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSysModelRepoBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GITBRANCH = "GITBRANCH";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSYSMODELREPOID = "PSDCSYSMODELREPOID";
    public static final String FIELD_PSDCSYSMODELREPONAME = "PSDCSYSMODELREPONAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_REPOTAG = "REPOTAG";
    public static final String FIELD_REPOTAG2 = "REPOTAG2";
    public static final String FIELD_REPOTYPE = "REPOTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_GITBRANCH = 2;
    private static final int INDEX_GITPATH = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDCSYSMODELREPOID = 5;
    private static final int INDEX_PSDCSYSMODELREPONAME = 6;
    private static final int INDEX_PSDEVCENTERID = 7;
    private static final int INDEX_PSDEVCENTERNAME = 8;
    private static final int INDEX_PSDEVSLNID = 9;
    private static final int INDEX_PSDEVSLNNAME = 10;
    private static final int INDEX_REPOTAG = 11;
    private static final int INDEX_REPOTAG2 = 12;
    private static final int INDEX_REPOTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSysModelRepoBase proxyPSDCSysModelRepoBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean gitbranchDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsysmodelrepoidDirtyFlag = false;
    private boolean psdcsysmodelreponameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean repotagDirtyFlag = false;
    private boolean repotag2DirtyFlag = false;
    private boolean repotypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="gitbranch")
    private String gitbranch;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcsysmodelrepoid")
    private String psdcsysmodelrepoid;
    @Column(name="psdcsysmodelreponame")
    private String psdcsysmodelreponame;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="repotag")
    private String repotag;
    @Column(name="repotag2")
    private String repotag2;
    @Column(name="repotype")
    private String repotype;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

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

    public void setPSDCSysModelRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysModelRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysmodelrepoid = string;
        this.psdcsysmodelrepoidDirtyFlag = true;
    }

    public String getPSDCSysModelRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysModelRepoId();
        }
        return this.psdcsysmodelrepoid;
    }

    public boolean isPSDCSysModelRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysModelRepoIdDirty();
        }
        return this.psdcsysmodelrepoidDirtyFlag;
    }

    public void resetPSDCSysModelRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysModelRepoId();
            return;
        }
        this.psdcsysmodelrepoidDirtyFlag = false;
        this.psdcsysmodelrepoid = null;
    }

    public void setPSDCSysModelRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysModelRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysmodelreponame = string;
        this.psdcsysmodelreponameDirtyFlag = true;
    }

    public String getPSDCSysModelRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysModelRepoName();
        }
        return this.psdcsysmodelreponame;
    }

    public boolean isPSDCSysModelRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysModelRepoNameDirty();
        }
        return this.psdcsysmodelreponameDirtyFlag;
    }

    public void resetPSDCSysModelRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysModelRepoName();
            return;
        }
        this.psdcsysmodelreponameDirtyFlag = false;
        this.psdcsysmodelreponame = null;
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

    public void setRepoType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepoType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.repotype = string;
        this.repotypeDirtyFlag = true;
    }

    public String getRepoType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepoType();
        }
        return this.repotype;
    }

    public boolean isRepoTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepoTypeDirty();
        }
        return this.repotypeDirtyFlag;
    }

    public void resetRepoType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepoType();
            return;
        }
        this.repotypeDirtyFlag = false;
        this.repotype = null;
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
        PSDCSysModelRepoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSysModelRepoBase pSDCSysModelRepoBase) {
        pSDCSysModelRepoBase.resetCreateDate();
        pSDCSysModelRepoBase.resetCreateMan();
        pSDCSysModelRepoBase.resetGitBranch();
        pSDCSysModelRepoBase.resetGitPath();
        pSDCSysModelRepoBase.resetMemo();
        pSDCSysModelRepoBase.resetPSDCSysModelRepoId();
        pSDCSysModelRepoBase.resetPSDCSysModelRepoName();
        pSDCSysModelRepoBase.resetPSDevCenterId();
        pSDCSysModelRepoBase.resetPSDevCenterName();
        pSDCSysModelRepoBase.resetPSDevSlnId();
        pSDCSysModelRepoBase.resetPSDevSlnName();
        pSDCSysModelRepoBase.resetRepoTag();
        pSDCSysModelRepoBase.resetRepoTag2();
        pSDCSysModelRepoBase.resetRepoType();
        pSDCSysModelRepoBase.resetUpdateDate();
        pSDCSysModelRepoBase.resetUpdateMan();
        pSDCSysModelRepoBase.resetUserTag();
        pSDCSysModelRepoBase.resetUserTag2();
        pSDCSysModelRepoBase.resetUserTag3();
        pSDCSysModelRepoBase.resetUserTag4();
        pSDCSysModelRepoBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCSysModelRepoIdDirty()) {
            hashMap.put(FIELD_PSDCSYSMODELREPOID, this.getPSDCSysModelRepoId());
        }
        if (!bl || this.isPSDCSysModelRepoNameDirty()) {
            hashMap.put(FIELD_PSDCSYSMODELREPONAME, this.getPSDCSysModelRepoName());
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
        if (!bl || this.isRepoTagDirty()) {
            hashMap.put(FIELD_REPOTAG, this.getRepoTag());
        }
        if (!bl || this.isRepoTag2Dirty()) {
            hashMap.put(FIELD_REPOTAG2, this.getRepoTag2());
        }
        if (!bl || this.isRepoTypeDirty()) {
            hashMap.put(FIELD_REPOTYPE, this.getRepoType());
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
        return PSDCSysModelRepoBase.get(this, n);
    }

    private static Object get(PSDCSysModelRepoBase pSDCSysModelRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysModelRepoBase.getCreateDate();
            }
            case 1: {
                return pSDCSysModelRepoBase.getCreateMan();
            }
            case 2: {
                return pSDCSysModelRepoBase.getGitBranch();
            }
            case 3: {
                return pSDCSysModelRepoBase.getGitPath();
            }
            case 4: {
                return pSDCSysModelRepoBase.getMemo();
            }
            case 5: {
                return pSDCSysModelRepoBase.getPSDCSysModelRepoId();
            }
            case 6: {
                return pSDCSysModelRepoBase.getPSDCSysModelRepoName();
            }
            case 7: {
                return pSDCSysModelRepoBase.getPSDevCenterId();
            }
            case 8: {
                return pSDCSysModelRepoBase.getPSDevCenterName();
            }
            case 9: {
                return pSDCSysModelRepoBase.getPSDevSlnId();
            }
            case 10: {
                return pSDCSysModelRepoBase.getPSDevSlnName();
            }
            case 11: {
                return pSDCSysModelRepoBase.getRepoTag();
            }
            case 12: {
                return pSDCSysModelRepoBase.getRepoTag2();
            }
            case 13: {
                return pSDCSysModelRepoBase.getRepoType();
            }
            case 14: {
                return pSDCSysModelRepoBase.getUpdateDate();
            }
            case 15: {
                return pSDCSysModelRepoBase.getUpdateMan();
            }
            case 16: {
                return pSDCSysModelRepoBase.getUserTag();
            }
            case 17: {
                return pSDCSysModelRepoBase.getUserTag2();
            }
            case 18: {
                return pSDCSysModelRepoBase.getUserTag3();
            }
            case 19: {
                return pSDCSysModelRepoBase.getUserTag4();
            }
            case 20: {
                return pSDCSysModelRepoBase.getValidFlag();
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
        PSDCSysModelRepoBase.set(this, n, object);
    }

    private static void set(PSDCSysModelRepoBase pSDCSysModelRepoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysModelRepoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSysModelRepoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSysModelRepoBase.setGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSysModelRepoBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSysModelRepoBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSysModelRepoBase.setPSDCSysModelRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSysModelRepoBase.setPSDCSysModelRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSysModelRepoBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSysModelRepoBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSysModelRepoBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSysModelRepoBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSysModelRepoBase.setRepoTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCSysModelRepoBase.setRepoTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCSysModelRepoBase.setRepoType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCSysModelRepoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDCSysModelRepoBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCSysModelRepoBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCSysModelRepoBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCSysModelRepoBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCSysModelRepoBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCSysModelRepoBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCSysModelRepoBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSysModelRepoBase pSDCSysModelRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysModelRepoBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSysModelRepoBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCSysModelRepoBase.getGitBranch() == null;
            }
            case 3: {
                return pSDCSysModelRepoBase.getGitPath() == null;
            }
            case 4: {
                return pSDCSysModelRepoBase.getMemo() == null;
            }
            case 5: {
                return pSDCSysModelRepoBase.getPSDCSysModelRepoId() == null;
            }
            case 6: {
                return pSDCSysModelRepoBase.getPSDCSysModelRepoName() == null;
            }
            case 7: {
                return pSDCSysModelRepoBase.getPSDevCenterId() == null;
            }
            case 8: {
                return pSDCSysModelRepoBase.getPSDevCenterName() == null;
            }
            case 9: {
                return pSDCSysModelRepoBase.getPSDevSlnId() == null;
            }
            case 10: {
                return pSDCSysModelRepoBase.getPSDevSlnName() == null;
            }
            case 11: {
                return pSDCSysModelRepoBase.getRepoTag() == null;
            }
            case 12: {
                return pSDCSysModelRepoBase.getRepoTag2() == null;
            }
            case 13: {
                return pSDCSysModelRepoBase.getRepoType() == null;
            }
            case 14: {
                return pSDCSysModelRepoBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDCSysModelRepoBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDCSysModelRepoBase.getUserTag() == null;
            }
            case 17: {
                return pSDCSysModelRepoBase.getUserTag2() == null;
            }
            case 18: {
                return pSDCSysModelRepoBase.getUserTag3() == null;
            }
            case 19: {
                return pSDCSysModelRepoBase.getUserTag4() == null;
            }
            case 20: {
                return pSDCSysModelRepoBase.getValidFlag() == null;
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
        return PSDCSysModelRepoBase.contains(this, n);
    }

    private static boolean contains(PSDCSysModelRepoBase pSDCSysModelRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysModelRepoBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSysModelRepoBase.isCreateManDirty();
            }
            case 2: {
                return pSDCSysModelRepoBase.isGitBranchDirty();
            }
            case 3: {
                return pSDCSysModelRepoBase.isGitPathDirty();
            }
            case 4: {
                return pSDCSysModelRepoBase.isMemoDirty();
            }
            case 5: {
                return pSDCSysModelRepoBase.isPSDCSysModelRepoIdDirty();
            }
            case 6: {
                return pSDCSysModelRepoBase.isPSDCSysModelRepoNameDirty();
            }
            case 7: {
                return pSDCSysModelRepoBase.isPSDevCenterIdDirty();
            }
            case 8: {
                return pSDCSysModelRepoBase.isPSDevCenterNameDirty();
            }
            case 9: {
                return pSDCSysModelRepoBase.isPSDevSlnIdDirty();
            }
            case 10: {
                return pSDCSysModelRepoBase.isPSDevSlnNameDirty();
            }
            case 11: {
                return pSDCSysModelRepoBase.isRepoTagDirty();
            }
            case 12: {
                return pSDCSysModelRepoBase.isRepoTag2Dirty();
            }
            case 13: {
                return pSDCSysModelRepoBase.isRepoTypeDirty();
            }
            case 14: {
                return pSDCSysModelRepoBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDCSysModelRepoBase.isUpdateManDirty();
            }
            case 16: {
                return pSDCSysModelRepoBase.isUserTagDirty();
            }
            case 17: {
                return pSDCSysModelRepoBase.isUserTag2Dirty();
            }
            case 18: {
                return pSDCSysModelRepoBase.isUserTag3Dirty();
            }
            case 19: {
                return pSDCSysModelRepoBase.isUserTag4Dirty();
            }
            case 20: {
                return pSDCSysModelRepoBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSysModelRepoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSysModelRepoBase pSDCSysModelRepoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSysModelRepoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitbranch", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getGitBranch()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getGitPath()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getPSDCSysModelRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysmodelrepoid", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getPSDCSysModelRepoId()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getPSDCSysModelRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysmodelreponame", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getPSDCSysModelRepoName()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getRepoTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repotag", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getRepoTag()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getRepoTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repotag2", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getRepoTag2()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getRepoType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repotype", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getRepoType()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDCSysModelRepoBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCSysModelRepoBase.getJSONValue((Object)pSDCSysModelRepoBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSysModelRepoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSysModelRepoBase pSDCSysModelRepoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSysModelRepoBase.getCreateDate() != null) {
            object = pSDCSysModelRepoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysModelRepoBase.getCreateMan() != null) {
            object = pSDCSysModelRepoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getGitBranch() != null) {
            object = pSDCSysModelRepoBase.getGitBranch();
            xmlNode.setAttribute(FIELD_GITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getGitPath() != null) {
            object = pSDCSysModelRepoBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getMemo() != null) {
            object = pSDCSysModelRepoBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getPSDCSysModelRepoId() != null) {
            object = pSDCSysModelRepoBase.getPSDCSysModelRepoId();
            xmlNode.setAttribute(FIELD_PSDCSYSMODELREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getPSDCSysModelRepoName() != null) {
            object = pSDCSysModelRepoBase.getPSDCSysModelRepoName();
            xmlNode.setAttribute(FIELD_PSDCSYSMODELREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getPSDevCenterId() != null) {
            object = pSDCSysModelRepoBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getPSDevCenterName() != null) {
            object = pSDCSysModelRepoBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getPSDevSlnId() != null) {
            object = pSDCSysModelRepoBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getPSDevSlnName() != null) {
            object = pSDCSysModelRepoBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getRepoTag() != null) {
            object = pSDCSysModelRepoBase.getRepoTag();
            xmlNode.setAttribute(FIELD_REPOTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getRepoTag2() != null) {
            object = pSDCSysModelRepoBase.getRepoTag2();
            xmlNode.setAttribute(FIELD_REPOTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getRepoType() != null) {
            object = pSDCSysModelRepoBase.getRepoType();
            xmlNode.setAttribute(FIELD_REPOTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getUpdateDate() != null) {
            object = pSDCSysModelRepoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysModelRepoBase.getUpdateMan() != null) {
            object = pSDCSysModelRepoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getUserTag() != null) {
            object = pSDCSysModelRepoBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getUserTag2() != null) {
            object = pSDCSysModelRepoBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getUserTag3() != null) {
            object = pSDCSysModelRepoBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getUserTag4() != null) {
            object = pSDCSysModelRepoBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysModelRepoBase.getValidFlag() != null) {
            object = pSDCSysModelRepoBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSysModelRepoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSysModelRepoBase pSDCSysModelRepoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSysModelRepoBase.isCreateDateDirty() && (bl || pSDCSysModelRepoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSysModelRepoBase.getCreateDate());
        }
        if (pSDCSysModelRepoBase.isCreateManDirty() && (bl || pSDCSysModelRepoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSysModelRepoBase.getCreateMan());
        }
        if (pSDCSysModelRepoBase.isGitBranchDirty() && (bl || pSDCSysModelRepoBase.getGitBranch() != null)) {
            iDataObject.set(FIELD_GITBRANCH, (Object)pSDCSysModelRepoBase.getGitBranch());
        }
        if (pSDCSysModelRepoBase.isGitPathDirty() && (bl || pSDCSysModelRepoBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSDCSysModelRepoBase.getGitPath());
        }
        if (pSDCSysModelRepoBase.isMemoDirty() && (bl || pSDCSysModelRepoBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSysModelRepoBase.getMemo());
        }
        if (pSDCSysModelRepoBase.isPSDCSysModelRepoIdDirty() && (bl || pSDCSysModelRepoBase.getPSDCSysModelRepoId() != null)) {
            iDataObject.set(FIELD_PSDCSYSMODELREPOID, (Object)pSDCSysModelRepoBase.getPSDCSysModelRepoId());
        }
        if (pSDCSysModelRepoBase.isPSDCSysModelRepoNameDirty() && (bl || pSDCSysModelRepoBase.getPSDCSysModelRepoName() != null)) {
            iDataObject.set(FIELD_PSDCSYSMODELREPONAME, (Object)pSDCSysModelRepoBase.getPSDCSysModelRepoName());
        }
        if (pSDCSysModelRepoBase.isPSDevCenterIdDirty() && (bl || pSDCSysModelRepoBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSysModelRepoBase.getPSDevCenterId());
        }
        if (pSDCSysModelRepoBase.isPSDevCenterNameDirty() && (bl || pSDCSysModelRepoBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSysModelRepoBase.getPSDevCenterName());
        }
        if (pSDCSysModelRepoBase.isPSDevSlnIdDirty() && (bl || pSDCSysModelRepoBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCSysModelRepoBase.getPSDevSlnId());
        }
        if (pSDCSysModelRepoBase.isPSDevSlnNameDirty() && (bl || pSDCSysModelRepoBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCSysModelRepoBase.getPSDevSlnName());
        }
        if (pSDCSysModelRepoBase.isRepoTagDirty() && (bl || pSDCSysModelRepoBase.getRepoTag() != null)) {
            iDataObject.set(FIELD_REPOTAG, (Object)pSDCSysModelRepoBase.getRepoTag());
        }
        if (pSDCSysModelRepoBase.isRepoTag2Dirty() && (bl || pSDCSysModelRepoBase.getRepoTag2() != null)) {
            iDataObject.set(FIELD_REPOTAG2, (Object)pSDCSysModelRepoBase.getRepoTag2());
        }
        if (pSDCSysModelRepoBase.isRepoTypeDirty() && (bl || pSDCSysModelRepoBase.getRepoType() != null)) {
            iDataObject.set(FIELD_REPOTYPE, (Object)pSDCSysModelRepoBase.getRepoType());
        }
        if (pSDCSysModelRepoBase.isUpdateDateDirty() && (bl || pSDCSysModelRepoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSysModelRepoBase.getUpdateDate());
        }
        if (pSDCSysModelRepoBase.isUpdateManDirty() && (bl || pSDCSysModelRepoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSysModelRepoBase.getUpdateMan());
        }
        if (pSDCSysModelRepoBase.isUserTagDirty() && (bl || pSDCSysModelRepoBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCSysModelRepoBase.getUserTag());
        }
        if (pSDCSysModelRepoBase.isUserTag2Dirty() && (bl || pSDCSysModelRepoBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCSysModelRepoBase.getUserTag2());
        }
        if (pSDCSysModelRepoBase.isUserTag3Dirty() && (bl || pSDCSysModelRepoBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCSysModelRepoBase.getUserTag3());
        }
        if (pSDCSysModelRepoBase.isUserTag4Dirty() && (bl || pSDCSysModelRepoBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCSysModelRepoBase.getUserTag4());
        }
        if (pSDCSysModelRepoBase.isValidFlagDirty() && (bl || pSDCSysModelRepoBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCSysModelRepoBase.getValidFlag());
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
        return PSDCSysModelRepoBase.remove(this, n);
    }

    private static boolean remove(PSDCSysModelRepoBase pSDCSysModelRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysModelRepoBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSysModelRepoBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSysModelRepoBase.resetGitBranch();
                return true;
            }
            case 3: {
                pSDCSysModelRepoBase.resetGitPath();
                return true;
            }
            case 4: {
                pSDCSysModelRepoBase.resetMemo();
                return true;
            }
            case 5: {
                pSDCSysModelRepoBase.resetPSDCSysModelRepoId();
                return true;
            }
            case 6: {
                pSDCSysModelRepoBase.resetPSDCSysModelRepoName();
                return true;
            }
            case 7: {
                pSDCSysModelRepoBase.resetPSDevCenterId();
                return true;
            }
            case 8: {
                pSDCSysModelRepoBase.resetPSDevCenterName();
                return true;
            }
            case 9: {
                pSDCSysModelRepoBase.resetPSDevSlnId();
                return true;
            }
            case 10: {
                pSDCSysModelRepoBase.resetPSDevSlnName();
                return true;
            }
            case 11: {
                pSDCSysModelRepoBase.resetRepoTag();
                return true;
            }
            case 12: {
                pSDCSysModelRepoBase.resetRepoTag2();
                return true;
            }
            case 13: {
                pSDCSysModelRepoBase.resetRepoType();
                return true;
            }
            case 14: {
                pSDCSysModelRepoBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDCSysModelRepoBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDCSysModelRepoBase.resetUserTag();
                return true;
            }
            case 17: {
                pSDCSysModelRepoBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSDCSysModelRepoBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSDCSysModelRepoBase.resetUserTag4();
                return true;
            }
            case 20: {
                pSDCSysModelRepoBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSDCSysModelRepoBase getProxyEntity() {
        return this.proxyPSDCSysModelRepoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSysModelRepoBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSysModelRepoBase) {
            this.proxyPSDCSysModelRepoBase = (PSDCSysModelRepoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelRepoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_GITBRANCH, 2);
        fieldIndexMap.put(FIELD_GITPATH, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDCSYSMODELREPOID, 5);
        fieldIndexMap.put(FIELD_PSDCSYSMODELREPONAME, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 10);
        fieldIndexMap.put(FIELD_REPOTAG, 11);
        fieldIndexMap.put(FIELD_REPOTAG2, 12);
        fieldIndexMap.put(FIELD_REPOTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

