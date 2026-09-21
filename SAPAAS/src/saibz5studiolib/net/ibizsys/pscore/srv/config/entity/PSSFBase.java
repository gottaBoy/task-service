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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSSFPF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFPFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFBase.class);
    public static final String FIELD_CLSFCUPPERCASE = "CLSFCUPPERCASE";
    public static final String FIELD_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String FIELD_CODEFLAG = "CODEFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOCFLAG = "DOCFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELFLAG = "MODELFLAG";
    public static final String FIELD_PKGLOWERCASE = "PKGLOWERCASE";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_SLNFLAG = "SLNFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_V2FOLDER = "V2FOLDER";
    public static final String FIELD_V2GITPATH = "V2GITPATH";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CLSFCUPPERCASE = 0;
    private static final int INDEX_CLSPKGPARAMS = 1;
    private static final int INDEX_CODEFLAG = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DOCFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MODELFLAG = 7;
    private static final int INDEX_PKGLOWERCASE = 8;
    private static final int INDEX_PSSFID = 9;
    private static final int INDEX_PSSFNAME = 10;
    private static final int INDEX_SLNFLAG = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_V2FOLDER = 14;
    private static final int INDEX_V2GITPATH = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFBase proxyPSSFBase = null;
    private boolean clsfcuppercaseDirtyFlag = false;
    private boolean clspkgparamsDirtyFlag = false;
    private boolean codeflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean docflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelflagDirtyFlag = false;
    private boolean pkglowercaseDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean slnflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean v2folderDirtyFlag = false;
    private boolean v2gitpathDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="clsfcuppercase")
    private Integer clsfcuppercase;
    @Column(name="clspkgparams")
    private String clspkgparams;
    @Column(name="codeflag")
    private Integer codeflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="docflag")
    private Integer docflag;
    @Column(name="memo")
    private String memo;
    @Column(name="modelflag")
    private Integer modelflag;
    @Column(name="pkglowercase")
    private Integer pkglowercase;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="slnflag")
    private Integer slnflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="v2folder")
    private String v2folder;
    @Column(name="v2gitpath")
    private String v2gitpath;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSFPFsLock = new Integer(1);
    private ArrayList<PSSFPF> pssfpfs = null;
    private Integer objPSSFStylesLock = new Integer(1);
    private ArrayList<PSSFStyle> pssfstyles = null;

    public void setClsFCUpperCase(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsFCUpperCase(n);
            return;
        }
        this.clsfcuppercase = n;
        this.clsfcuppercaseDirtyFlag = true;
    }

    public Integer getClsFCUpperCase() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsFCUpperCase();
        }
        return this.clsfcuppercase;
    }

    public boolean isClsFCUpperCaseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsFCUpperCaseDirty();
        }
        return this.clsfcuppercaseDirtyFlag;
    }

    public void resetClsFCUpperCase() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsFCUpperCase();
            return;
        }
        this.clsfcuppercaseDirtyFlag = false;
        this.clsfcuppercase = null;
    }

    public void setClsPkgParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPkgParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspkgparams = string;
        this.clspkgparamsDirtyFlag = true;
    }

    public String getClsPkgParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPkgParams();
        }
        return this.clspkgparams;
    }

    public boolean isClsPkgParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPkgParamsDirty();
        }
        return this.clspkgparamsDirtyFlag;
    }

    public void resetClsPkgParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPkgParams();
            return;
        }
        this.clspkgparamsDirtyFlag = false;
        this.clspkgparams = null;
    }

    public void setCodeFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeFlag(n);
            return;
        }
        this.codeflag = n;
        this.codeflagDirtyFlag = true;
    }

    public Integer getCodeFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeFlag();
        }
        return this.codeflag;
    }

    public boolean isCodeFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeFlagDirty();
        }
        return this.codeflagDirtyFlag;
    }

    public void resetCodeFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeFlag();
            return;
        }
        this.codeflagDirtyFlag = false;
        this.codeflag = null;
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

    public void setDocFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocFlag(n);
            return;
        }
        this.docflag = n;
        this.docflagDirtyFlag = true;
    }

    public Integer getDocFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocFlag();
        }
        return this.docflag;
    }

    public boolean isDocFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocFlagDirty();
        }
        return this.docflagDirtyFlag;
    }

    public void resetDocFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocFlag();
            return;
        }
        this.docflagDirtyFlag = false;
        this.docflag = null;
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

    public void setModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelFlag(n);
            return;
        }
        this.modelflag = n;
        this.modelflagDirtyFlag = true;
    }

    public Integer getModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelFlag();
        }
        return this.modelflag;
    }

    public boolean isModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelFlagDirty();
        }
        return this.modelflagDirtyFlag;
    }

    public void resetModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelFlag();
            return;
        }
        this.modelflagDirtyFlag = false;
        this.modelflag = null;
    }

    public void setPkgLowerCase(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgLowerCase(n);
            return;
        }
        this.pkglowercase = n;
        this.pkglowercaseDirtyFlag = true;
    }

    public Integer getPkgLowerCase() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgLowerCase();
        }
        return this.pkglowercase;
    }

    public boolean isPkgLowerCaseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgLowerCaseDirty();
        }
        return this.pkglowercaseDirtyFlag;
    }

    public void resetPkgLowerCase() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgLowerCase();
            return;
        }
        this.pkglowercaseDirtyFlag = false;
        this.pkglowercase = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setSlnFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlnFlag(n);
            return;
        }
        this.slnflag = n;
        this.slnflagDirtyFlag = true;
    }

    public Integer getSlnFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlnFlag();
        }
        return this.slnflag;
    }

    public boolean isSlnFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlnFlagDirty();
        }
        return this.slnflagDirtyFlag;
    }

    public void resetSlnFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlnFlag();
            return;
        }
        this.slnflagDirtyFlag = false;
        this.slnflag = null;
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

    public void setV2Folder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2Folder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2folder = string;
        this.v2folderDirtyFlag = true;
    }

    public String getV2Folder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2Folder();
        }
        return this.v2folder;
    }

    public boolean isV2FolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2FolderDirty();
        }
        return this.v2folderDirtyFlag;
    }

    public void resetV2Folder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2Folder();
            return;
        }
        this.v2folderDirtyFlag = false;
        this.v2folder = null;
    }

    public void setV2GitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2GitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2gitpath = string;
        this.v2gitpathDirtyFlag = true;
    }

    public String getV2GitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2GitPath();
        }
        return this.v2gitpath;
    }

    public boolean isV2GitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2GitPathDirty();
        }
        return this.v2gitpathDirtyFlag;
    }

    public void resetV2GitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2GitPath();
            return;
        }
        this.v2gitpathDirtyFlag = false;
        this.v2gitpath = null;
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
        PSSFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFBase pSSFBase) {
        pSSFBase.resetClsFCUpperCase();
        pSSFBase.resetClsPkgParams();
        pSSFBase.resetCodeFlag();
        pSSFBase.resetCreateDate();
        pSSFBase.resetCreateMan();
        pSSFBase.resetDocFlag();
        pSSFBase.resetMemo();
        pSSFBase.resetModelFlag();
        pSSFBase.resetPkgLowerCase();
        pSSFBase.resetPSSFId();
        pSSFBase.resetPSSFName();
        pSSFBase.resetSlnFlag();
        pSSFBase.resetUpdateDate();
        pSSFBase.resetUpdateMan();
        pSSFBase.resetV2Folder();
        pSSFBase.resetV2GitPath();
        pSSFBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClsFCUpperCaseDirty()) {
            hashMap.put(FIELD_CLSFCUPPERCASE, this.getClsFCUpperCase());
        }
        if (!bl || this.isClsPkgParamsDirty()) {
            hashMap.put(FIELD_CLSPKGPARAMS, this.getClsPkgParams());
        }
        if (!bl || this.isCodeFlagDirty()) {
            hashMap.put(FIELD_CODEFLAG, this.getCodeFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDocFlagDirty()) {
            hashMap.put(FIELD_DOCFLAG, this.getDocFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelFlagDirty()) {
            hashMap.put(FIELD_MODELFLAG, this.getModelFlag());
        }
        if (!bl || this.isPkgLowerCaseDirty()) {
            hashMap.put(FIELD_PKGLOWERCASE, this.getPkgLowerCase());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isSlnFlagDirty()) {
            hashMap.put(FIELD_SLNFLAG, this.getSlnFlag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isV2FolderDirty()) {
            hashMap.put(FIELD_V2FOLDER, this.getV2Folder());
        }
        if (!bl || this.isV2GitPathDirty()) {
            hashMap.put(FIELD_V2GITPATH, this.getV2GitPath());
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
        return PSSFBase.get(this, n);
    }

    private static Object get(PSSFBase pSSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFBase.getClsFCUpperCase();
            }
            case 1: {
                return pSSFBase.getClsPkgParams();
            }
            case 2: {
                return pSSFBase.getCodeFlag();
            }
            case 3: {
                return pSSFBase.getCreateDate();
            }
            case 4: {
                return pSSFBase.getCreateMan();
            }
            case 5: {
                return pSSFBase.getDocFlag();
            }
            case 6: {
                return pSSFBase.getMemo();
            }
            case 7: {
                return pSSFBase.getModelFlag();
            }
            case 8: {
                return pSSFBase.getPkgLowerCase();
            }
            case 9: {
                return pSSFBase.getPSSFId();
            }
            case 10: {
                return pSSFBase.getPSSFName();
            }
            case 11: {
                return pSSFBase.getSlnFlag();
            }
            case 12: {
                return pSSFBase.getUpdateDate();
            }
            case 13: {
                return pSSFBase.getUpdateMan();
            }
            case 14: {
                return pSSFBase.getV2Folder();
            }
            case 15: {
                return pSSFBase.getV2GitPath();
            }
            case 16: {
                return pSSFBase.getValidFlag();
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
        PSSFBase.set(this, n, object);
    }

    private static void set(PSSFBase pSSFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFBase.setClsFCUpperCase(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSFBase.setClsPkgParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFBase.setCodeFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFBase.setDocFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFBase.setModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSFBase.setPkgLowerCase(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSFBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFBase.setSlnFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSFBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFBase.setV2Folder(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFBase.setV2GitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFBase.isNull(this, n);
    }

    private static boolean isNull(PSSFBase pSSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFBase.getClsFCUpperCase() == null;
            }
            case 1: {
                return pSSFBase.getClsPkgParams() == null;
            }
            case 2: {
                return pSSFBase.getCodeFlag() == null;
            }
            case 3: {
                return pSSFBase.getCreateDate() == null;
            }
            case 4: {
                return pSSFBase.getCreateMan() == null;
            }
            case 5: {
                return pSSFBase.getDocFlag() == null;
            }
            case 6: {
                return pSSFBase.getMemo() == null;
            }
            case 7: {
                return pSSFBase.getModelFlag() == null;
            }
            case 8: {
                return pSSFBase.getPkgLowerCase() == null;
            }
            case 9: {
                return pSSFBase.getPSSFId() == null;
            }
            case 10: {
                return pSSFBase.getPSSFName() == null;
            }
            case 11: {
                return pSSFBase.getSlnFlag() == null;
            }
            case 12: {
                return pSSFBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSFBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSFBase.getV2Folder() == null;
            }
            case 15: {
                return pSSFBase.getV2GitPath() == null;
            }
            case 16: {
                return pSSFBase.getValidFlag() == null;
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
        return PSSFBase.contains(this, n);
    }

    private static boolean contains(PSSFBase pSSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFBase.isClsFCUpperCaseDirty();
            }
            case 1: {
                return pSSFBase.isClsPkgParamsDirty();
            }
            case 2: {
                return pSSFBase.isCodeFlagDirty();
            }
            case 3: {
                return pSSFBase.isCreateDateDirty();
            }
            case 4: {
                return pSSFBase.isCreateManDirty();
            }
            case 5: {
                return pSSFBase.isDocFlagDirty();
            }
            case 6: {
                return pSSFBase.isMemoDirty();
            }
            case 7: {
                return pSSFBase.isModelFlagDirty();
            }
            case 8: {
                return pSSFBase.isPkgLowerCaseDirty();
            }
            case 9: {
                return pSSFBase.isPSSFIdDirty();
            }
            case 10: {
                return pSSFBase.isPSSFNameDirty();
            }
            case 11: {
                return pSSFBase.isSlnFlagDirty();
            }
            case 12: {
                return pSSFBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSFBase.isUpdateManDirty();
            }
            case 14: {
                return pSSFBase.isV2FolderDirty();
            }
            case 15: {
                return pSSFBase.isV2GitPathDirty();
            }
            case 16: {
                return pSSFBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFBase pSSFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFBase.getClsFCUpperCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clsfcuppercase", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getClsFCUpperCase()), (boolean)false);
        }
        if (bl || pSSFBase.getClsPkgParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspkgparams", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getClsPkgParams()), (boolean)false);
        }
        if (bl || pSSFBase.getCodeFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codeflag", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getCodeFlag()), (boolean)false);
        }
        if (bl || pSSFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFBase.getDocFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docflag", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getDocFlag()), (boolean)false);
        }
        if (bl || pSSFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFBase.getModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelflag", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getModelFlag()), (boolean)false);
        }
        if (bl || pSSFBase.getPkgLowerCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkglowercase", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getPkgLowerCase()), (boolean)false);
        }
        if (bl || pSSFBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFBase.getSlnFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slnflag", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getSlnFlag()), (boolean)false);
        }
        if (bl || pSSFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFBase.getV2Folder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2folder", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getV2Folder()), (boolean)false);
        }
        if (bl || pSSFBase.getV2GitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2gitpath", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getV2GitPath()), (boolean)false);
        }
        if (bl || pSSFBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFBase.getJSONValue((Object)pSSFBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFBase pSSFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFBase.getClsFCUpperCase() != null) {
            object = pSSFBase.getClsFCUpperCase();
            xmlNode.setAttribute(FIELD_CLSFCUPPERCASE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFBase.getClsPkgParams() != null) {
            object = pSSFBase.getClsPkgParams();
            xmlNode.setAttribute(FIELD_CLSPKGPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSFBase.getCodeFlag() != null) {
            object = pSSFBase.getCodeFlag();
            xmlNode.setAttribute(FIELD_CODEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFBase.getCreateDate() != null) {
            object = pSSFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFBase.getCreateMan() != null) {
            object = pSSFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFBase.getDocFlag() != null) {
            object = pSSFBase.getDocFlag();
            xmlNode.setAttribute(FIELD_DOCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFBase.getMemo() != null) {
            object = pSSFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFBase.getModelFlag() != null) {
            object = pSSFBase.getModelFlag();
            xmlNode.setAttribute(FIELD_MODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFBase.getPkgLowerCase() != null) {
            object = pSSFBase.getPkgLowerCase();
            xmlNode.setAttribute(FIELD_PKGLOWERCASE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFBase.getPSSFId() != null) {
            object = pSSFBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFBase.getPSSFName() != null) {
            object = pSSFBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFBase.getSlnFlag() != null) {
            object = pSSFBase.getSlnFlag();
            xmlNode.setAttribute(FIELD_SLNFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFBase.getUpdateDate() != null) {
            object = pSSFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFBase.getUpdateMan() != null) {
            object = pSSFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFBase.getV2Folder() != null) {
            object = pSSFBase.getV2Folder();
            xmlNode.setAttribute(FIELD_V2FOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSFBase.getV2GitPath() != null) {
            object = pSSFBase.getV2GitPath();
            xmlNode.setAttribute(FIELD_V2GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSFBase.getValidFlag() != null) {
            object = pSSFBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFBase pSSFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFBase.isClsFCUpperCaseDirty() && (bl || pSSFBase.getClsFCUpperCase() != null)) {
            iDataObject.set(FIELD_CLSFCUPPERCASE, (Object)pSSFBase.getClsFCUpperCase());
        }
        if (pSSFBase.isClsPkgParamsDirty() && (bl || pSSFBase.getClsPkgParams() != null)) {
            iDataObject.set(FIELD_CLSPKGPARAMS, (Object)pSSFBase.getClsPkgParams());
        }
        if (pSSFBase.isCodeFlagDirty() && (bl || pSSFBase.getCodeFlag() != null)) {
            iDataObject.set(FIELD_CODEFLAG, (Object)pSSFBase.getCodeFlag());
        }
        if (pSSFBase.isCreateDateDirty() && (bl || pSSFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFBase.getCreateDate());
        }
        if (pSSFBase.isCreateManDirty() && (bl || pSSFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFBase.getCreateMan());
        }
        if (pSSFBase.isDocFlagDirty() && (bl || pSSFBase.getDocFlag() != null)) {
            iDataObject.set(FIELD_DOCFLAG, (Object)pSSFBase.getDocFlag());
        }
        if (pSSFBase.isMemoDirty() && (bl || pSSFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFBase.getMemo());
        }
        if (pSSFBase.isModelFlagDirty() && (bl || pSSFBase.getModelFlag() != null)) {
            iDataObject.set(FIELD_MODELFLAG, (Object)pSSFBase.getModelFlag());
        }
        if (pSSFBase.isPkgLowerCaseDirty() && (bl || pSSFBase.getPkgLowerCase() != null)) {
            iDataObject.set(FIELD_PKGLOWERCASE, (Object)pSSFBase.getPkgLowerCase());
        }
        if (pSSFBase.isPSSFIdDirty() && (bl || pSSFBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFBase.getPSSFId());
        }
        if (pSSFBase.isPSSFNameDirty() && (bl || pSSFBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFBase.getPSSFName());
        }
        if (pSSFBase.isSlnFlagDirty() && (bl || pSSFBase.getSlnFlag() != null)) {
            iDataObject.set(FIELD_SLNFLAG, (Object)pSSFBase.getSlnFlag());
        }
        if (pSSFBase.isUpdateDateDirty() && (bl || pSSFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFBase.getUpdateDate());
        }
        if (pSSFBase.isUpdateManDirty() && (bl || pSSFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFBase.getUpdateMan());
        }
        if (pSSFBase.isV2FolderDirty() && (bl || pSSFBase.getV2Folder() != null)) {
            iDataObject.set(FIELD_V2FOLDER, (Object)pSSFBase.getV2Folder());
        }
        if (pSSFBase.isV2GitPathDirty() && (bl || pSSFBase.getV2GitPath() != null)) {
            iDataObject.set(FIELD_V2GITPATH, (Object)pSSFBase.getV2GitPath());
        }
        if (pSSFBase.isValidFlagDirty() && (bl || pSSFBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFBase.getValidFlag());
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
        return PSSFBase.remove(this, n);
    }

    private static boolean remove(PSSFBase pSSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFBase.resetClsFCUpperCase();
                return true;
            }
            case 1: {
                pSSFBase.resetClsPkgParams();
                return true;
            }
            case 2: {
                pSSFBase.resetCodeFlag();
                return true;
            }
            case 3: {
                pSSFBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSFBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSFBase.resetDocFlag();
                return true;
            }
            case 6: {
                pSSFBase.resetMemo();
                return true;
            }
            case 7: {
                pSSFBase.resetModelFlag();
                return true;
            }
            case 8: {
                pSSFBase.resetPkgLowerCase();
                return true;
            }
            case 9: {
                pSSFBase.resetPSSFId();
                return true;
            }
            case 10: {
                pSSFBase.resetPSSFName();
                return true;
            }
            case 11: {
                pSSFBase.resetSlnFlag();
                return true;
            }
            case 12: {
                pSSFBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSFBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSFBase.resetV2Folder();
                return true;
            }
            case 15: {
                pSSFBase.resetV2GitPath();
                return true;
            }
            case 16: {
                pSSFBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFPF> getPSSFPFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPFs();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        PSSFPFService pSSFPFService = (PSSFPFService)ServiceGlobal.getService(PSSFPFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFPFsLock;
        synchronized (n) {
            if (this.pssfpfs == null) {
                this.pssfpfs = pSSFPFService.selectByPSSF(this);
            }
            return this.pssfpfs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFStyle> getPSSFStyles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyles();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFStylesLock;
        synchronized (n) {
            if (this.pssfstyles == null) {
                this.pssfstyles = pSSFStyleService.selectByPSSF(this);
            }
            return this.pssfstyles;
        }
    }

    private PSSFBase getProxyEntity() {
        return this.proxyPSSFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFBase) {
            this.proxyPSSFBase = (PSSFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLSFCUPPERCASE, 0);
        fieldIndexMap.put(FIELD_CLSPKGPARAMS, 1);
        fieldIndexMap.put(FIELD_CODEFLAG, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DOCFLAG, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MODELFLAG, 7);
        fieldIndexMap.put(FIELD_PKGLOWERCASE, 8);
        fieldIndexMap.put(FIELD_PSSFID, 9);
        fieldIndexMap.put(FIELD_PSSFNAME, 10);
        fieldIndexMap.put(FIELD_SLNFLAG, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_V2FOLDER, 14);
        fieldIndexMap.put(FIELD_V2GITPATH, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

