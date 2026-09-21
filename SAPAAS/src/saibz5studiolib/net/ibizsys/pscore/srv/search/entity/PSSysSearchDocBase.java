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
package net.ibizsys.pscore.srv.search.entity;

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
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchField;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchFieldService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchDocBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSearchDocBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_DOCPARAMS = "DOCPARAMS";
    public static final String FIELD_DOCTAG = "DOCTAG";
    public static final String FIELD_DOCTAG2 = "DOCTAG2";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String FIELD_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String FIELD_PSSYSSEARCHSCHEMEID = "PSSYSSEARCHSCHEMEID";
    public static final String FIELD_PSSYSSEARCHSCHEMENAME = "PSSYSSEARCHSCHEMENAME";
    public static final String FIELD_REPLICAS = "REPLICAS";
    public static final String FIELD_SHARDS = "SHARDS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTMODE = 3;
    private static final int INDEX_DOCPARAMS = 4;
    private static final int INDEX_DOCTAG = 5;
    private static final int INDEX_DOCTAG2 = 6;
    private static final int INDEX_LOGICNAME = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSSYSSEARCHDOCID = 9;
    private static final int INDEX_PSSYSSEARCHDOCNAME = 10;
    private static final int INDEX_PSSYSSEARCHSCHEMEID = 11;
    private static final int INDEX_PSSYSSEARCHSCHEMENAME = 12;
    private static final int INDEX_REPLICAS = 13;
    private static final int INDEX_SHARDS = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final int INDEX_USERTAG3 = 20;
    private static final int INDEX_USERTAG4 = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSearchDocBase proxyPSSysSearchDocBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean docparamsDirtyFlag = false;
    private boolean doctagDirtyFlag = false;
    private boolean doctag2DirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssyssearchdocidDirtyFlag = false;
    private boolean pssyssearchdocnameDirtyFlag = false;
    private boolean pssyssearchschemeidDirtyFlag = false;
    private boolean pssyssearchschemenameDirtyFlag = false;
    private boolean replicasDirtyFlag = false;
    private boolean shardsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="docparams")
    private String docparams;
    @Column(name="doctag")
    private String doctag;
    @Column(name="doctag2")
    private String doctag2;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pssyssearchdocid")
    private String pssyssearchdocid;
    @Column(name="pssyssearchdocname")
    private String pssyssearchdocname;
    @Column(name="pssyssearchschemeid")
    private String pssyssearchschemeid;
    @Column(name="pssyssearchschemename")
    private String pssyssearchschemename;
    @Column(name="replicas")
    private Integer replicas;
    @Column(name="shards")
    private Integer shards;
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
    private Integer objPSSysSearchSchemeLock = new Integer(1);
    private PSSysSearchScheme pssyssearchscheme = null;
    private Integer objPSSysSearchDEsLock = new Integer(1);
    private ArrayList<PSSysSearchDE> pssyssearchdes = null;
    private Integer objPSSysSearchFieldsLock = new Integer(1);
    private ArrayList<PSSysSearchField> pssyssearchfields = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setDefaultMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMode(n);
            return;
        }
        this.defaultmode = n;
        this.defaultmodeDirtyFlag = true;
    }

    public Integer getDefaultMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMode();
        }
        return this.defaultmode;
    }

    public boolean isDefaultModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultModeDirty();
        }
        return this.defaultmodeDirtyFlag;
    }

    public void resetDefaultMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMode();
            return;
        }
        this.defaultmodeDirtyFlag = false;
        this.defaultmode = null;
    }

    public void setDocParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.docparams = string;
        this.docparamsDirtyFlag = true;
    }

    public String getDocParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocParams();
        }
        return this.docparams;
    }

    public boolean isDocParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocParamsDirty();
        }
        return this.docparamsDirtyFlag;
    }

    public void resetDocParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocParams();
            return;
        }
        this.docparamsDirtyFlag = false;
        this.docparams = null;
    }

    public void setDocTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.doctag = string;
        this.doctagDirtyFlag = true;
    }

    public String getDocTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocTag();
        }
        return this.doctag;
    }

    public boolean isDocTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocTagDirty();
        }
        return this.doctagDirtyFlag;
    }

    public void resetDocTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocTag();
            return;
        }
        this.doctagDirtyFlag = false;
        this.doctag = null;
    }

    public void setDocTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.doctag2 = string;
        this.doctag2DirtyFlag = true;
    }

    public String getDocTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocTag2();
        }
        return this.doctag2;
    }

    public boolean isDocTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocTag2Dirty();
        }
        return this.doctag2DirtyFlag;
    }

    public void resetDocTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocTag2();
            return;
        }
        this.doctag2DirtyFlag = false;
        this.doctag2 = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSSysSearchDocId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocid = string;
        this.pssyssearchdocidDirtyFlag = true;
    }

    public String getPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocId();
        }
        return this.pssyssearchdocid;
    }

    public boolean isPSSysSearchDocIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocIdDirty();
        }
        return this.pssyssearchdocidDirtyFlag;
    }

    public void resetPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocId();
            return;
        }
        this.pssyssearchdocidDirtyFlag = false;
        this.pssyssearchdocid = null;
    }

    public void setPSSysSearchDocName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocname = string;
        this.pssyssearchdocnameDirtyFlag = true;
    }

    public String getPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocName();
        }
        return this.pssyssearchdocname;
    }

    public boolean isPSSysSearchDocNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocNameDirty();
        }
        return this.pssyssearchdocnameDirtyFlag;
    }

    public void resetPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocName();
            return;
        }
        this.pssyssearchdocnameDirtyFlag = false;
        this.pssyssearchdocname = null;
    }

    public void setPSSysSearchSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemeid = string;
        this.pssyssearchschemeidDirtyFlag = true;
    }

    public String getPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeId();
        }
        return this.pssyssearchschemeid;
    }

    public boolean isPSSysSearchSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeIdDirty();
        }
        return this.pssyssearchschemeidDirtyFlag;
    }

    public void resetPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeId();
            return;
        }
        this.pssyssearchschemeidDirtyFlag = false;
        this.pssyssearchschemeid = null;
    }

    public void setPSSysSearchSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemename = string;
        this.pssyssearchschemenameDirtyFlag = true;
    }

    public String getPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeName();
        }
        return this.pssyssearchschemename;
    }

    public boolean isPSSysSearchSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeNameDirty();
        }
        return this.pssyssearchschemenameDirtyFlag;
    }

    public void resetPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeName();
            return;
        }
        this.pssyssearchschemenameDirtyFlag = false;
        this.pssyssearchschemename = null;
    }

    public void setReplicas(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReplicas(n);
            return;
        }
        this.replicas = n;
        this.replicasDirtyFlag = true;
    }

    public Integer getReplicas() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReplicas();
        }
        return this.replicas;
    }

    public boolean isReplicasDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReplicasDirty();
        }
        return this.replicasDirtyFlag;
    }

    public void resetReplicas() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReplicas();
            return;
        }
        this.replicasDirtyFlag = false;
        this.replicas = null;
    }

    public void setShards(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShards(n);
            return;
        }
        this.shards = n;
        this.shardsDirtyFlag = true;
    }

    public Integer getShards() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShards();
        }
        return this.shards;
    }

    public boolean isShardsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShardsDirty();
        }
        return this.shardsDirtyFlag;
    }

    public void resetShards() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShards();
            return;
        }
        this.shardsDirtyFlag = false;
        this.shards = null;
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

    protected void onReset() {
        PSSysSearchDocBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSearchDocBase pSSysSearchDocBase) {
        pSSysSearchDocBase.resetCodeName();
        pSSysSearchDocBase.resetCreateDate();
        pSSysSearchDocBase.resetCreateMan();
        pSSysSearchDocBase.resetDefaultMode();
        pSSysSearchDocBase.resetDocParams();
        pSSysSearchDocBase.resetDocTag();
        pSSysSearchDocBase.resetDocTag2();
        pSSysSearchDocBase.resetLogicName();
        pSSysSearchDocBase.resetMemo();
        pSSysSearchDocBase.resetPSSysSearchDocId();
        pSSysSearchDocBase.resetPSSysSearchDocName();
        pSSysSearchDocBase.resetPSSysSearchSchemeId();
        pSSysSearchDocBase.resetPSSysSearchSchemeName();
        pSSysSearchDocBase.resetReplicas();
        pSSysSearchDocBase.resetShards();
        pSSysSearchDocBase.resetUpdateDate();
        pSSysSearchDocBase.resetUpdateMan();
        pSSysSearchDocBase.resetUserCat();
        pSSysSearchDocBase.resetUserTag();
        pSSysSearchDocBase.resetUserTag2();
        pSSysSearchDocBase.resetUserTag3();
        pSSysSearchDocBase.resetUserTag4();
        pSSysSearchDocBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isDocParamsDirty()) {
            hashMap.put(FIELD_DOCPARAMS, this.getDocParams());
        }
        if (!bl || this.isDocTagDirty()) {
            hashMap.put(FIELD_DOCTAG, this.getDocTag());
        }
        if (!bl || this.isDocTag2Dirty()) {
            hashMap.put(FIELD_DOCTAG2, this.getDocTag2());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysSearchDocIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCID, this.getPSSysSearchDocId());
        }
        if (!bl || this.isPSSysSearchDocNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCNAME, this.getPSSysSearchDocName());
        }
        if (!bl || this.isPSSysSearchSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMEID, this.getPSSysSearchSchemeId());
        }
        if (!bl || this.isPSSysSearchSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMENAME, this.getPSSysSearchSchemeName());
        }
        if (!bl || this.isReplicasDirty()) {
            hashMap.put(FIELD_REPLICAS, this.getReplicas());
        }
        if (!bl || this.isShardsDirty()) {
            hashMap.put(FIELD_SHARDS, this.getShards());
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
        return PSSysSearchDocBase.get(this, n);
    }

    private static Object get(PSSysSearchDocBase pSSysSearchDocBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDocBase.getCodeName();
            }
            case 1: {
                return pSSysSearchDocBase.getCreateDate();
            }
            case 2: {
                return pSSysSearchDocBase.getCreateMan();
            }
            case 3: {
                return pSSysSearchDocBase.getDefaultMode();
            }
            case 4: {
                return pSSysSearchDocBase.getDocParams();
            }
            case 5: {
                return pSSysSearchDocBase.getDocTag();
            }
            case 6: {
                return pSSysSearchDocBase.getDocTag2();
            }
            case 7: {
                return pSSysSearchDocBase.getLogicName();
            }
            case 8: {
                return pSSysSearchDocBase.getMemo();
            }
            case 9: {
                return pSSysSearchDocBase.getPSSysSearchDocId();
            }
            case 10: {
                return pSSysSearchDocBase.getPSSysSearchDocName();
            }
            case 11: {
                return pSSysSearchDocBase.getPSSysSearchSchemeId();
            }
            case 12: {
                return pSSysSearchDocBase.getPSSysSearchSchemeName();
            }
            case 13: {
                return pSSysSearchDocBase.getReplicas();
            }
            case 14: {
                return pSSysSearchDocBase.getShards();
            }
            case 15: {
                return pSSysSearchDocBase.getUpdateDate();
            }
            case 16: {
                return pSSysSearchDocBase.getUpdateMan();
            }
            case 17: {
                return pSSysSearchDocBase.getUserCat();
            }
            case 18: {
                return pSSysSearchDocBase.getUserTag();
            }
            case 19: {
                return pSSysSearchDocBase.getUserTag2();
            }
            case 20: {
                return pSSysSearchDocBase.getUserTag3();
            }
            case 21: {
                return pSSysSearchDocBase.getUserTag4();
            }
            case 22: {
                return pSSysSearchDocBase.getValidFlag();
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
        PSSysSearchDocBase.set(this, n, object);
    }

    private static void set(PSSysSearchDocBase pSSysSearchDocBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchDocBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSearchDocBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSearchDocBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSearchDocBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysSearchDocBase.setDocParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSearchDocBase.setDocTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSearchDocBase.setDocTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSearchDocBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSearchDocBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSearchDocBase.setPSSysSearchDocId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSearchDocBase.setPSSysSearchDocName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSearchDocBase.setPSSysSearchSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSearchDocBase.setPSSysSearchSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSearchDocBase.setReplicas(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysSearchDocBase.setShards(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysSearchDocBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSSysSearchDocBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSearchDocBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSearchDocBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSearchDocBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSearchDocBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSearchDocBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSearchDocBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysSearchDocBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSearchDocBase pSSysSearchDocBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDocBase.getCodeName() == null;
            }
            case 1: {
                return pSSysSearchDocBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSearchDocBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSearchDocBase.getDefaultMode() == null;
            }
            case 4: {
                return pSSysSearchDocBase.getDocParams() == null;
            }
            case 5: {
                return pSSysSearchDocBase.getDocTag() == null;
            }
            case 6: {
                return pSSysSearchDocBase.getDocTag2() == null;
            }
            case 7: {
                return pSSysSearchDocBase.getLogicName() == null;
            }
            case 8: {
                return pSSysSearchDocBase.getMemo() == null;
            }
            case 9: {
                return pSSysSearchDocBase.getPSSysSearchDocId() == null;
            }
            case 10: {
                return pSSysSearchDocBase.getPSSysSearchDocName() == null;
            }
            case 11: {
                return pSSysSearchDocBase.getPSSysSearchSchemeId() == null;
            }
            case 12: {
                return pSSysSearchDocBase.getPSSysSearchSchemeName() == null;
            }
            case 13: {
                return pSSysSearchDocBase.getReplicas() == null;
            }
            case 14: {
                return pSSysSearchDocBase.getShards() == null;
            }
            case 15: {
                return pSSysSearchDocBase.getUpdateDate() == null;
            }
            case 16: {
                return pSSysSearchDocBase.getUpdateMan() == null;
            }
            case 17: {
                return pSSysSearchDocBase.getUserCat() == null;
            }
            case 18: {
                return pSSysSearchDocBase.getUserTag() == null;
            }
            case 19: {
                return pSSysSearchDocBase.getUserTag2() == null;
            }
            case 20: {
                return pSSysSearchDocBase.getUserTag3() == null;
            }
            case 21: {
                return pSSysSearchDocBase.getUserTag4() == null;
            }
            case 22: {
                return pSSysSearchDocBase.getValidFlag() == null;
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
        return PSSysSearchDocBase.contains(this, n);
    }

    private static boolean contains(PSSysSearchDocBase pSSysSearchDocBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDocBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysSearchDocBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSearchDocBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSearchDocBase.isDefaultModeDirty();
            }
            case 4: {
                return pSSysSearchDocBase.isDocParamsDirty();
            }
            case 5: {
                return pSSysSearchDocBase.isDocTagDirty();
            }
            case 6: {
                return pSSysSearchDocBase.isDocTag2Dirty();
            }
            case 7: {
                return pSSysSearchDocBase.isLogicNameDirty();
            }
            case 8: {
                return pSSysSearchDocBase.isMemoDirty();
            }
            case 9: {
                return pSSysSearchDocBase.isPSSysSearchDocIdDirty();
            }
            case 10: {
                return pSSysSearchDocBase.isPSSysSearchDocNameDirty();
            }
            case 11: {
                return pSSysSearchDocBase.isPSSysSearchSchemeIdDirty();
            }
            case 12: {
                return pSSysSearchDocBase.isPSSysSearchSchemeNameDirty();
            }
            case 13: {
                return pSSysSearchDocBase.isReplicasDirty();
            }
            case 14: {
                return pSSysSearchDocBase.isShardsDirty();
            }
            case 15: {
                return pSSysSearchDocBase.isUpdateDateDirty();
            }
            case 16: {
                return pSSysSearchDocBase.isUpdateManDirty();
            }
            case 17: {
                return pSSysSearchDocBase.isUserCatDirty();
            }
            case 18: {
                return pSSysSearchDocBase.isUserTagDirty();
            }
            case 19: {
                return pSSysSearchDocBase.isUserTag2Dirty();
            }
            case 20: {
                return pSSysSearchDocBase.isUserTag3Dirty();
            }
            case 21: {
                return pSSysSearchDocBase.isUserTag4Dirty();
            }
            case 22: {
                return pSSysSearchDocBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSearchDocBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSearchDocBase pSSysSearchDocBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSearchDocBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getDocParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docparams", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getDocParams()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getDocTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"doctag", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getDocTag()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getDocTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"doctag2", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getDocTag2()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getPSSysSearchDocId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocid", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getPSSysSearchDocId()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getPSSysSearchDocName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocname", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getPSSysSearchDocName()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getPSSysSearchSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemeid", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getPSSysSearchSchemeId()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getPSSysSearchSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemename", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getPSSysSearchSchemeName()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getReplicas() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"replicas", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getReplicas()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getShards() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shards", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getShards()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSearchDocBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSearchDocBase.getJSONValue((Object)pSSysSearchDocBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSearchDocBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSearchDocBase pSSysSearchDocBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSearchDocBase.getCodeName() != null) {
            object = pSSysSearchDocBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getCreateDate() != null) {
            object = pSSysSearchDocBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchDocBase.getCreateMan() != null) {
            object = pSSysSearchDocBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getDefaultMode() != null) {
            object = pSSysSearchDocBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchDocBase.getDocParams() != null) {
            object = pSSysSearchDocBase.getDocParams();
            xmlNode.setAttribute(FIELD_DOCPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getDocTag() != null) {
            object = pSSysSearchDocBase.getDocTag();
            xmlNode.setAttribute(FIELD_DOCTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getDocTag2() != null) {
            object = pSSysSearchDocBase.getDocTag2();
            xmlNode.setAttribute(FIELD_DOCTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getLogicName() != null) {
            object = pSSysSearchDocBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getMemo() != null) {
            object = pSSysSearchDocBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getPSSysSearchDocId() != null) {
            object = pSSysSearchDocBase.getPSSysSearchDocId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getPSSysSearchDocName() != null) {
            object = pSSysSearchDocBase.getPSSysSearchDocName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getPSSysSearchSchemeId() != null) {
            object = pSSysSearchDocBase.getPSSysSearchSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getPSSysSearchSchemeName() != null) {
            object = pSSysSearchDocBase.getPSSysSearchSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getReplicas() != null) {
            object = pSSysSearchDocBase.getReplicas();
            xmlNode.setAttribute(FIELD_REPLICAS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchDocBase.getShards() != null) {
            object = pSSysSearchDocBase.getShards();
            xmlNode.setAttribute(FIELD_SHARDS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchDocBase.getUpdateDate() != null) {
            object = pSSysSearchDocBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchDocBase.getUpdateMan() != null) {
            object = pSSysSearchDocBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getUserCat() != null) {
            object = pSSysSearchDocBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getUserTag() != null) {
            object = pSSysSearchDocBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getUserTag2() != null) {
            object = pSSysSearchDocBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getUserTag3() != null) {
            object = pSSysSearchDocBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getUserTag4() != null) {
            object = pSSysSearchDocBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDocBase.getValidFlag() != null) {
            object = pSSysSearchDocBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSearchDocBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSearchDocBase pSSysSearchDocBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSearchDocBase.isCodeNameDirty() && (bl || pSSysSearchDocBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSearchDocBase.getCodeName());
        }
        if (pSSysSearchDocBase.isCreateDateDirty() && (bl || pSSysSearchDocBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSearchDocBase.getCreateDate());
        }
        if (pSSysSearchDocBase.isCreateManDirty() && (bl || pSSysSearchDocBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSearchDocBase.getCreateMan());
        }
        if (pSSysSearchDocBase.isDefaultModeDirty() && (bl || pSSysSearchDocBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSSysSearchDocBase.getDefaultMode());
        }
        if (pSSysSearchDocBase.isDocParamsDirty() && (bl || pSSysSearchDocBase.getDocParams() != null)) {
            iDataObject.set(FIELD_DOCPARAMS, (Object)pSSysSearchDocBase.getDocParams());
        }
        if (pSSysSearchDocBase.isDocTagDirty() && (bl || pSSysSearchDocBase.getDocTag() != null)) {
            iDataObject.set(FIELD_DOCTAG, (Object)pSSysSearchDocBase.getDocTag());
        }
        if (pSSysSearchDocBase.isDocTag2Dirty() && (bl || pSSysSearchDocBase.getDocTag2() != null)) {
            iDataObject.set(FIELD_DOCTAG2, (Object)pSSysSearchDocBase.getDocTag2());
        }
        if (pSSysSearchDocBase.isLogicNameDirty() && (bl || pSSysSearchDocBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysSearchDocBase.getLogicName());
        }
        if (pSSysSearchDocBase.isMemoDirty() && (bl || pSSysSearchDocBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSearchDocBase.getMemo());
        }
        if (pSSysSearchDocBase.isPSSysSearchDocIdDirty() && (bl || pSSysSearchDocBase.getPSSysSearchDocId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCID, (Object)pSSysSearchDocBase.getPSSysSearchDocId());
        }
        if (pSSysSearchDocBase.isPSSysSearchDocNameDirty() && (bl || pSSysSearchDocBase.getPSSysSearchDocName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCNAME, (Object)pSSysSearchDocBase.getPSSysSearchDocName());
        }
        if (pSSysSearchDocBase.isPSSysSearchSchemeIdDirty() && (bl || pSSysSearchDocBase.getPSSysSearchSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMEID, (Object)pSSysSearchDocBase.getPSSysSearchSchemeId());
        }
        if (pSSysSearchDocBase.isPSSysSearchSchemeNameDirty() && (bl || pSSysSearchDocBase.getPSSysSearchSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMENAME, (Object)pSSysSearchDocBase.getPSSysSearchSchemeName());
        }
        if (pSSysSearchDocBase.isReplicasDirty() && (bl || pSSysSearchDocBase.getReplicas() != null)) {
            iDataObject.set(FIELD_REPLICAS, (Object)pSSysSearchDocBase.getReplicas());
        }
        if (pSSysSearchDocBase.isShardsDirty() && (bl || pSSysSearchDocBase.getShards() != null)) {
            iDataObject.set(FIELD_SHARDS, (Object)pSSysSearchDocBase.getShards());
        }
        if (pSSysSearchDocBase.isUpdateDateDirty() && (bl || pSSysSearchDocBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSearchDocBase.getUpdateDate());
        }
        if (pSSysSearchDocBase.isUpdateManDirty() && (bl || pSSysSearchDocBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSearchDocBase.getUpdateMan());
        }
        if (pSSysSearchDocBase.isUserCatDirty() && (bl || pSSysSearchDocBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSearchDocBase.getUserCat());
        }
        if (pSSysSearchDocBase.isUserTagDirty() && (bl || pSSysSearchDocBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSearchDocBase.getUserTag());
        }
        if (pSSysSearchDocBase.isUserTag2Dirty() && (bl || pSSysSearchDocBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSearchDocBase.getUserTag2());
        }
        if (pSSysSearchDocBase.isUserTag3Dirty() && (bl || pSSysSearchDocBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSearchDocBase.getUserTag3());
        }
        if (pSSysSearchDocBase.isUserTag4Dirty() && (bl || pSSysSearchDocBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSearchDocBase.getUserTag4());
        }
        if (pSSysSearchDocBase.isValidFlagDirty() && (bl || pSSysSearchDocBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSearchDocBase.getValidFlag());
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
        return PSSysSearchDocBase.remove(this, n);
    }

    private static boolean remove(PSSysSearchDocBase pSSysSearchDocBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchDocBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysSearchDocBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSearchDocBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSearchDocBase.resetDefaultMode();
                return true;
            }
            case 4: {
                pSSysSearchDocBase.resetDocParams();
                return true;
            }
            case 5: {
                pSSysSearchDocBase.resetDocTag();
                return true;
            }
            case 6: {
                pSSysSearchDocBase.resetDocTag2();
                return true;
            }
            case 7: {
                pSSysSearchDocBase.resetLogicName();
                return true;
            }
            case 8: {
                pSSysSearchDocBase.resetMemo();
                return true;
            }
            case 9: {
                pSSysSearchDocBase.resetPSSysSearchDocId();
                return true;
            }
            case 10: {
                pSSysSearchDocBase.resetPSSysSearchDocName();
                return true;
            }
            case 11: {
                pSSysSearchDocBase.resetPSSysSearchSchemeId();
                return true;
            }
            case 12: {
                pSSysSearchDocBase.resetPSSysSearchSchemeName();
                return true;
            }
            case 13: {
                pSSysSearchDocBase.resetReplicas();
                return true;
            }
            case 14: {
                pSSysSearchDocBase.resetShards();
                return true;
            }
            case 15: {
                pSSysSearchDocBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSSysSearchDocBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSSysSearchDocBase.resetUserCat();
                return true;
            }
            case 18: {
                pSSysSearchDocBase.resetUserTag();
                return true;
            }
            case 19: {
                pSSysSearchDocBase.resetUserTag2();
                return true;
            }
            case 20: {
                pSSysSearchDocBase.resetUserTag3();
                return true;
            }
            case 21: {
                pSSysSearchDocBase.resetUserTag4();
                return true;
            }
            case 22: {
                pSSysSearchDocBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchScheme getPSSysSearchScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchScheme();
        }
        if (this.getPSSysSearchSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchSchemeLock;
        synchronized (n) {
            if (this.pssyssearchscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchSchemeId(), (Object)this.pssyssearchscheme.getPSSysSearchSchemeId()) != 0L) {
                this.pssyssearchscheme = null;
            }
            if (this.pssyssearchscheme == null) {
                PSSysSearchScheme pSSysSearchScheme = new PSSysSearchScheme();
                pSSysSearchScheme.setPSSysSearchSchemeId(this.getPSSysSearchSchemeId());
                PSSysSearchSchemeService pSSysSearchSchemeService = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchSchemeService.autoGet((IEntity)pSSysSearchScheme);
                this.pssyssearchscheme = pSSysSearchScheme;
            }
            return this.pssyssearchscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchDE> getPSSysSearchDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEs();
        }
        if (this.getPSSysSearchDocId() == null) {
            return null;
        }
        PSSysSearchDEService pSSysSearchDEService = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchDEsLock;
        synchronized (n) {
            if (this.pssyssearchdes == null) {
                this.pssyssearchdes = pSSysSearchDEService.selectByPSSysSearchDoc(this);
            }
            return this.pssyssearchdes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchField> getPSSysSearchFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchFields();
        }
        if (this.getPSSysSearchDocId() == null) {
            return null;
        }
        PSSysSearchFieldService pSSysSearchFieldService = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchFieldsLock;
        synchronized (n) {
            if (this.pssyssearchfields == null) {
                this.pssyssearchfields = pSSysSearchFieldService.selectByPSSysSearchDoc(this);
            }
            return this.pssyssearchfields;
        }
    }

    private PSSysSearchDocBase getProxyEntity() {
        return this.proxyPSSysSearchDocBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSearchDocBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSearchDocBase) {
            this.proxyPSSysSearchDocBase = (PSSysSearchDocBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchDocService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 3);
        fieldIndexMap.put(FIELD_DOCPARAMS, 4);
        fieldIndexMap.put(FIELD_DOCTAG, 5);
        fieldIndexMap.put(FIELD_DOCTAG2, 6);
        fieldIndexMap.put(FIELD_LOGICNAME, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCID, 9);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMEID, 11);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMENAME, 12);
        fieldIndexMap.put(FIELD_REPLICAS, 13);
        fieldIndexMap.put(FIELD_SHARDS, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
        fieldIndexMap.put(FIELD_USERTAG3, 20);
        fieldIndexMap.put(FIELD_USERTAG4, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

