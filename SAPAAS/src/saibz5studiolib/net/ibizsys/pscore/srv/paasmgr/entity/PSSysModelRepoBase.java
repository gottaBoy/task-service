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
package net.ibizsys.pscore.srv.paasmgr.entity;

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

public abstract class PSSysModelRepoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelRepoBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GITBRANCH = "GITBRANCH";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSMODELREPOID = "PSSYSMODELREPOID";
    public static final String FIELD_PSSYSMODELREPONAME = "PSSYSMODELREPONAME";
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
    private static final int INDEX_PSSYSMODELREPOID = 5;
    private static final int INDEX_PSSYSMODELREPONAME = 6;
    private static final int INDEX_REPOTAG = 7;
    private static final int INDEX_REPOTAG2 = 8;
    private static final int INDEX_REPOTYPE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final int INDEX_USERTAG3 = 14;
    private static final int INDEX_USERTAG4 = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelRepoBase proxyPSSysModelRepoBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean gitbranchDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysmodelrepoidDirtyFlag = false;
    private boolean pssysmodelreponameDirtyFlag = false;
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
    @Column(name="pssysmodelrepoid")
    private String pssysmodelrepoid;
    @Column(name="pssysmodelreponame")
    private String pssysmodelreponame;
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

    public void setPSSysModelRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelrepoid = string;
        this.pssysmodelrepoidDirtyFlag = true;
    }

    public String getPSSysModelRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelRepoId();
        }
        return this.pssysmodelrepoid;
    }

    public boolean isPSSysModelRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelRepoIdDirty();
        }
        return this.pssysmodelrepoidDirtyFlag;
    }

    public void resetPSSysModelRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelRepoId();
            return;
        }
        this.pssysmodelrepoidDirtyFlag = false;
        this.pssysmodelrepoid = null;
    }

    public void setPSSysModelRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelreponame = string;
        this.pssysmodelreponameDirtyFlag = true;
    }

    public String getPSSysModelRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelRepoName();
        }
        return this.pssysmodelreponame;
    }

    public boolean isPSSysModelRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelRepoNameDirty();
        }
        return this.pssysmodelreponameDirtyFlag;
    }

    public void resetPSSysModelRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelRepoName();
            return;
        }
        this.pssysmodelreponameDirtyFlag = false;
        this.pssysmodelreponame = null;
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
        PSSysModelRepoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelRepoBase pSSysModelRepoBase) {
        pSSysModelRepoBase.resetCreateDate();
        pSSysModelRepoBase.resetCreateMan();
        pSSysModelRepoBase.resetGitBranch();
        pSSysModelRepoBase.resetGitPath();
        pSSysModelRepoBase.resetMemo();
        pSSysModelRepoBase.resetPSSysModelRepoId();
        pSSysModelRepoBase.resetPSSysModelRepoName();
        pSSysModelRepoBase.resetRepoTag();
        pSSysModelRepoBase.resetRepoTag2();
        pSSysModelRepoBase.resetRepoType();
        pSSysModelRepoBase.resetUpdateDate();
        pSSysModelRepoBase.resetUpdateMan();
        pSSysModelRepoBase.resetUserTag();
        pSSysModelRepoBase.resetUserTag2();
        pSSysModelRepoBase.resetUserTag3();
        pSSysModelRepoBase.resetUserTag4();
        pSSysModelRepoBase.resetValidFlag();
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
        if (!bl || this.isPSSysModelRepoIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELREPOID, this.getPSSysModelRepoId());
        }
        if (!bl || this.isPSSysModelRepoNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELREPONAME, this.getPSSysModelRepoName());
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
        return PSSysModelRepoBase.get(this, n);
    }

    private static Object get(PSSysModelRepoBase pSSysModelRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelRepoBase.getCreateDate();
            }
            case 1: {
                return pSSysModelRepoBase.getCreateMan();
            }
            case 2: {
                return pSSysModelRepoBase.getGitBranch();
            }
            case 3: {
                return pSSysModelRepoBase.getGitPath();
            }
            case 4: {
                return pSSysModelRepoBase.getMemo();
            }
            case 5: {
                return pSSysModelRepoBase.getPSSysModelRepoId();
            }
            case 6: {
                return pSSysModelRepoBase.getPSSysModelRepoName();
            }
            case 7: {
                return pSSysModelRepoBase.getRepoTag();
            }
            case 8: {
                return pSSysModelRepoBase.getRepoTag2();
            }
            case 9: {
                return pSSysModelRepoBase.getRepoType();
            }
            case 10: {
                return pSSysModelRepoBase.getUpdateDate();
            }
            case 11: {
                return pSSysModelRepoBase.getUpdateMan();
            }
            case 12: {
                return pSSysModelRepoBase.getUserTag();
            }
            case 13: {
                return pSSysModelRepoBase.getUserTag2();
            }
            case 14: {
                return pSSysModelRepoBase.getUserTag3();
            }
            case 15: {
                return pSSysModelRepoBase.getUserTag4();
            }
            case 16: {
                return pSSysModelRepoBase.getValidFlag();
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
        PSSysModelRepoBase.set(this, n, object);
    }

    private static void set(PSSysModelRepoBase pSSysModelRepoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelRepoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelRepoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelRepoBase.setGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelRepoBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelRepoBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelRepoBase.setPSSysModelRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelRepoBase.setPSSysModelRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelRepoBase.setRepoTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelRepoBase.setRepoTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelRepoBase.setRepoType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelRepoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelRepoBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelRepoBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelRepoBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelRepoBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelRepoBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelRepoBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysModelRepoBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelRepoBase pSSysModelRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelRepoBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysModelRepoBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysModelRepoBase.getGitBranch() == null;
            }
            case 3: {
                return pSSysModelRepoBase.getGitPath() == null;
            }
            case 4: {
                return pSSysModelRepoBase.getMemo() == null;
            }
            case 5: {
                return pSSysModelRepoBase.getPSSysModelRepoId() == null;
            }
            case 6: {
                return pSSysModelRepoBase.getPSSysModelRepoName() == null;
            }
            case 7: {
                return pSSysModelRepoBase.getRepoTag() == null;
            }
            case 8: {
                return pSSysModelRepoBase.getRepoTag2() == null;
            }
            case 9: {
                return pSSysModelRepoBase.getRepoType() == null;
            }
            case 10: {
                return pSSysModelRepoBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysModelRepoBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysModelRepoBase.getUserTag() == null;
            }
            case 13: {
                return pSSysModelRepoBase.getUserTag2() == null;
            }
            case 14: {
                return pSSysModelRepoBase.getUserTag3() == null;
            }
            case 15: {
                return pSSysModelRepoBase.getUserTag4() == null;
            }
            case 16: {
                return pSSysModelRepoBase.getValidFlag() == null;
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
        return PSSysModelRepoBase.contains(this, n);
    }

    private static boolean contains(PSSysModelRepoBase pSSysModelRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelRepoBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysModelRepoBase.isCreateManDirty();
            }
            case 2: {
                return pSSysModelRepoBase.isGitBranchDirty();
            }
            case 3: {
                return pSSysModelRepoBase.isGitPathDirty();
            }
            case 4: {
                return pSSysModelRepoBase.isMemoDirty();
            }
            case 5: {
                return pSSysModelRepoBase.isPSSysModelRepoIdDirty();
            }
            case 6: {
                return pSSysModelRepoBase.isPSSysModelRepoNameDirty();
            }
            case 7: {
                return pSSysModelRepoBase.isRepoTagDirty();
            }
            case 8: {
                return pSSysModelRepoBase.isRepoTag2Dirty();
            }
            case 9: {
                return pSSysModelRepoBase.isRepoTypeDirty();
            }
            case 10: {
                return pSSysModelRepoBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysModelRepoBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysModelRepoBase.isUserTagDirty();
            }
            case 13: {
                return pSSysModelRepoBase.isUserTag2Dirty();
            }
            case 14: {
                return pSSysModelRepoBase.isUserTag3Dirty();
            }
            case 15: {
                return pSSysModelRepoBase.isUserTag4Dirty();
            }
            case 16: {
                return pSSysModelRepoBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelRepoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelRepoBase pSSysModelRepoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelRepoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitbranch", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getGitBranch()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getGitPath()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getPSSysModelRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelrepoid", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getPSSysModelRepoId()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getPSSysModelRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelreponame", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getPSSysModelRepoName()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getRepoTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repotag", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getRepoTag()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getRepoTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repotag2", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getRepoTag2()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getRepoType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repotype", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getRepoType()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysModelRepoBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysModelRepoBase.getJSONValue((Object)pSSysModelRepoBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelRepoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelRepoBase pSSysModelRepoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelRepoBase.getCreateDate() != null) {
            object = pSSysModelRepoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelRepoBase.getCreateMan() != null) {
            object = pSSysModelRepoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getGitBranch() != null) {
            object = pSSysModelRepoBase.getGitBranch();
            xmlNode.setAttribute(FIELD_GITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getGitPath() != null) {
            object = pSSysModelRepoBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getMemo() != null) {
            object = pSSysModelRepoBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getPSSysModelRepoId() != null) {
            object = pSSysModelRepoBase.getPSSysModelRepoId();
            xmlNode.setAttribute(FIELD_PSSYSMODELREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getPSSysModelRepoName() != null) {
            object = pSSysModelRepoBase.getPSSysModelRepoName();
            xmlNode.setAttribute(FIELD_PSSYSMODELREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getRepoTag() != null) {
            object = pSSysModelRepoBase.getRepoTag();
            xmlNode.setAttribute(FIELD_REPOTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getRepoTag2() != null) {
            object = pSSysModelRepoBase.getRepoTag2();
            xmlNode.setAttribute(FIELD_REPOTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getRepoType() != null) {
            object = pSSysModelRepoBase.getRepoType();
            xmlNode.setAttribute(FIELD_REPOTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getUpdateDate() != null) {
            object = pSSysModelRepoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelRepoBase.getUpdateMan() != null) {
            object = pSSysModelRepoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getUserTag() != null) {
            object = pSSysModelRepoBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getUserTag2() != null) {
            object = pSSysModelRepoBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getUserTag3() != null) {
            object = pSSysModelRepoBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getUserTag4() != null) {
            object = pSSysModelRepoBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelRepoBase.getValidFlag() != null) {
            object = pSSysModelRepoBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelRepoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelRepoBase pSSysModelRepoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelRepoBase.isCreateDateDirty() && (bl || pSSysModelRepoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelRepoBase.getCreateDate());
        }
        if (pSSysModelRepoBase.isCreateManDirty() && (bl || pSSysModelRepoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelRepoBase.getCreateMan());
        }
        if (pSSysModelRepoBase.isGitBranchDirty() && (bl || pSSysModelRepoBase.getGitBranch() != null)) {
            iDataObject.set(FIELD_GITBRANCH, (Object)pSSysModelRepoBase.getGitBranch());
        }
        if (pSSysModelRepoBase.isGitPathDirty() && (bl || pSSysModelRepoBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSSysModelRepoBase.getGitPath());
        }
        if (pSSysModelRepoBase.isMemoDirty() && (bl || pSSysModelRepoBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelRepoBase.getMemo());
        }
        if (pSSysModelRepoBase.isPSSysModelRepoIdDirty() && (bl || pSSysModelRepoBase.getPSSysModelRepoId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELREPOID, (Object)pSSysModelRepoBase.getPSSysModelRepoId());
        }
        if (pSSysModelRepoBase.isPSSysModelRepoNameDirty() && (bl || pSSysModelRepoBase.getPSSysModelRepoName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELREPONAME, (Object)pSSysModelRepoBase.getPSSysModelRepoName());
        }
        if (pSSysModelRepoBase.isRepoTagDirty() && (bl || pSSysModelRepoBase.getRepoTag() != null)) {
            iDataObject.set(FIELD_REPOTAG, (Object)pSSysModelRepoBase.getRepoTag());
        }
        if (pSSysModelRepoBase.isRepoTag2Dirty() && (bl || pSSysModelRepoBase.getRepoTag2() != null)) {
            iDataObject.set(FIELD_REPOTAG2, (Object)pSSysModelRepoBase.getRepoTag2());
        }
        if (pSSysModelRepoBase.isRepoTypeDirty() && (bl || pSSysModelRepoBase.getRepoType() != null)) {
            iDataObject.set(FIELD_REPOTYPE, (Object)pSSysModelRepoBase.getRepoType());
        }
        if (pSSysModelRepoBase.isUpdateDateDirty() && (bl || pSSysModelRepoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelRepoBase.getUpdateDate());
        }
        if (pSSysModelRepoBase.isUpdateManDirty() && (bl || pSSysModelRepoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelRepoBase.getUpdateMan());
        }
        if (pSSysModelRepoBase.isUserTagDirty() && (bl || pSSysModelRepoBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysModelRepoBase.getUserTag());
        }
        if (pSSysModelRepoBase.isUserTag2Dirty() && (bl || pSSysModelRepoBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysModelRepoBase.getUserTag2());
        }
        if (pSSysModelRepoBase.isUserTag3Dirty() && (bl || pSSysModelRepoBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysModelRepoBase.getUserTag3());
        }
        if (pSSysModelRepoBase.isUserTag4Dirty() && (bl || pSSysModelRepoBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysModelRepoBase.getUserTag4());
        }
        if (pSSysModelRepoBase.isValidFlagDirty() && (bl || pSSysModelRepoBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysModelRepoBase.getValidFlag());
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
        return PSSysModelRepoBase.remove(this, n);
    }

    private static boolean remove(PSSysModelRepoBase pSSysModelRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelRepoBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysModelRepoBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysModelRepoBase.resetGitBranch();
                return true;
            }
            case 3: {
                pSSysModelRepoBase.resetGitPath();
                return true;
            }
            case 4: {
                pSSysModelRepoBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysModelRepoBase.resetPSSysModelRepoId();
                return true;
            }
            case 6: {
                pSSysModelRepoBase.resetPSSysModelRepoName();
                return true;
            }
            case 7: {
                pSSysModelRepoBase.resetRepoTag();
                return true;
            }
            case 8: {
                pSSysModelRepoBase.resetRepoTag2();
                return true;
            }
            case 9: {
                pSSysModelRepoBase.resetRepoType();
                return true;
            }
            case 10: {
                pSSysModelRepoBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysModelRepoBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysModelRepoBase.resetUserTag();
                return true;
            }
            case 13: {
                pSSysModelRepoBase.resetUserTag2();
                return true;
            }
            case 14: {
                pSSysModelRepoBase.resetUserTag3();
                return true;
            }
            case 15: {
                pSSysModelRepoBase.resetUserTag4();
                return true;
            }
            case 16: {
                pSSysModelRepoBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysModelRepoBase getProxyEntity() {
        return this.proxyPSSysModelRepoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelRepoBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelRepoBase) {
            this.proxyPSSysModelRepoBase = (PSSysModelRepoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelRepoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_GITBRANCH, 2);
        fieldIndexMap.put(FIELD_GITPATH, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSSYSMODELREPOID, 5);
        fieldIndexMap.put(FIELD_PSSYSMODELREPONAME, 6);
        fieldIndexMap.put(FIELD_REPOTAG, 7);
        fieldIndexMap.put(FIELD_REPOTAG2, 8);
        fieldIndexMap.put(FIELD_REPOTYPE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERTAG, 12);
        fieldIndexMap.put(FIELD_USERTAG2, 13);
        fieldIndexMap.put(FIELD_USERTAG3, 14);
        fieldIndexMap.put(FIELD_USERTAG4, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

