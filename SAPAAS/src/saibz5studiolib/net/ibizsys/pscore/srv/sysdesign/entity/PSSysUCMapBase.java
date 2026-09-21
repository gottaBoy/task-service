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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMapNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUCMapBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUCMapBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAPTAG = "MAPTAG";
    public static final String FIELD_MAPTAG2 = "MAPTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUCMAPID = "PSSYSUCMAPID";
    public static final String FIELD_PSSYSUCMAPNAME = "PSSYSUCMAPNAME";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UCMODEL = "UCMODEL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MAPTAG = 3;
    private static final int INDEX_MAPTAG2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSMODULEID = 6;
    private static final int INDEX_PSMODULENAME = 7;
    private static final int INDEX_PSSYSAPPID = 8;
    private static final int INDEX_PSSYSAPPNAME = 9;
    private static final int INDEX_PSSYSTEMID = 10;
    private static final int INDEX_PSSYSTEMNAME = 11;
    private static final int INDEX_PSSYSUCMAPID = 12;
    private static final int INDEX_PSSYSUCMAPNAME = 13;
    private static final int INDEX_TAGS = 14;
    private static final int INDEX_UCMODEL = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUCMapBase proxyPSSysUCMapBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean maptagDirtyFlag = false;
    private boolean maptag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysucmapidDirtyFlag = false;
    private boolean pssysucmapnameDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean ucmodelDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="maptag")
    private String maptag;
    @Column(name="maptag2")
    private String maptag2;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysucmapid")
    private String pssysucmapid;
    @Column(name="pssysucmapname")
    private String pssysucmapname;
    @Column(name="tags")
    private String tags;
    @Column(name="ucmodel")
    private String ucmodel;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUCMapNodesLock = new Integer(1);
    private ArrayList<PSSysUCMapNode> pssysucmapnodes = null;

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

    public void setMapTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maptag = string;
        this.maptagDirtyFlag = true;
    }

    public String getMapTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapTag();
        }
        return this.maptag;
    }

    public boolean isMapTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapTagDirty();
        }
        return this.maptagDirtyFlag;
    }

    public void resetMapTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapTag();
            return;
        }
        this.maptagDirtyFlag = false;
        this.maptag = null;
    }

    public void setMapTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maptag2 = string;
        this.maptag2DirtyFlag = true;
    }

    public String getMapTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapTag2();
        }
        return this.maptag2;
    }

    public boolean isMapTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapTag2Dirty();
        }
        return this.maptag2DirtyFlag;
    }

    public void resetMapTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapTag2();
            return;
        }
        this.maptag2DirtyFlag = false;
        this.maptag2 = null;
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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSSysUCMapId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUCMapId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysucmapid = string;
        this.pssysucmapidDirtyFlag = true;
    }

    public String getPSSysUCMapId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMapId();
        }
        return this.pssysucmapid;
    }

    public boolean isPSSysUCMapIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUCMapIdDirty();
        }
        return this.pssysucmapidDirtyFlag;
    }

    public void resetPSSysUCMapId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUCMapId();
            return;
        }
        this.pssysucmapidDirtyFlag = false;
        this.pssysucmapid = null;
    }

    public void setPSSysUCMapName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUCMapName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysucmapname = string;
        this.pssysucmapnameDirtyFlag = true;
    }

    public String getPSSysUCMapName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMapName();
        }
        return this.pssysucmapname;
    }

    public boolean isPSSysUCMapNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUCMapNameDirty();
        }
        return this.pssysucmapnameDirtyFlag;
    }

    public void resetPSSysUCMapName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUCMapName();
            return;
        }
        this.pssysucmapnameDirtyFlag = false;
        this.pssysucmapname = null;
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

    public void setUCModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUCModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ucmodel = string;
        this.ucmodelDirtyFlag = true;
    }

    public String getUCModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUCModel();
        }
        return this.ucmodel;
    }

    public boolean isUCModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUCModelDirty();
        }
        return this.ucmodelDirtyFlag;
    }

    public void resetUCModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUCModel();
            return;
        }
        this.ucmodelDirtyFlag = false;
        this.ucmodel = null;
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

    protected void onReset() {
        PSSysUCMapBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUCMapBase pSSysUCMapBase) {
        pSSysUCMapBase.resetCodeName();
        pSSysUCMapBase.resetCreateDate();
        pSSysUCMapBase.resetCreateMan();
        pSSysUCMapBase.resetMapTag();
        pSSysUCMapBase.resetMapTag2();
        pSSysUCMapBase.resetMemo();
        pSSysUCMapBase.resetPSModuleId();
        pSSysUCMapBase.resetPSModuleName();
        pSSysUCMapBase.resetPSSysAppId();
        pSSysUCMapBase.resetPSSysAppName();
        pSSysUCMapBase.resetPSSystemId();
        pSSysUCMapBase.resetPSSystemName();
        pSSysUCMapBase.resetPSSysUCMapId();
        pSSysUCMapBase.resetPSSysUCMapName();
        pSSysUCMapBase.resetTags();
        pSSysUCMapBase.resetUCModel();
        pSSysUCMapBase.resetUpdateDate();
        pSSysUCMapBase.resetUpdateMan();
        pSSysUCMapBase.resetUserCat();
        pSSysUCMapBase.resetUserTag();
        pSSysUCMapBase.resetUserTag2();
        pSSysUCMapBase.resetUserTag3();
        pSSysUCMapBase.resetUserTag4();
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
        if (!bl || this.isMapTagDirty()) {
            hashMap.put(FIELD_MAPTAG, this.getMapTag());
        }
        if (!bl || this.isMapTag2Dirty()) {
            hashMap.put(FIELD_MAPTAG2, this.getMapTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUCMapIdDirty()) {
            hashMap.put(FIELD_PSSYSUCMAPID, this.getPSSysUCMapId());
        }
        if (!bl || this.isPSSysUCMapNameDirty()) {
            hashMap.put(FIELD_PSSYSUCMAPNAME, this.getPSSysUCMapName());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
        }
        if (!bl || this.isUCModelDirty()) {
            hashMap.put(FIELD_UCMODEL, this.getUCModel());
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
        return PSSysUCMapBase.get(this, n);
    }

    private static Object get(PSSysUCMapBase pSSysUCMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUCMapBase.getCodeName();
            }
            case 1: {
                return pSSysUCMapBase.getCreateDate();
            }
            case 2: {
                return pSSysUCMapBase.getCreateMan();
            }
            case 3: {
                return pSSysUCMapBase.getMapTag();
            }
            case 4: {
                return pSSysUCMapBase.getMapTag2();
            }
            case 5: {
                return pSSysUCMapBase.getMemo();
            }
            case 6: {
                return pSSysUCMapBase.getPSModuleId();
            }
            case 7: {
                return pSSysUCMapBase.getPSModuleName();
            }
            case 8: {
                return pSSysUCMapBase.getPSSysAppId();
            }
            case 9: {
                return pSSysUCMapBase.getPSSysAppName();
            }
            case 10: {
                return pSSysUCMapBase.getPSSystemId();
            }
            case 11: {
                return pSSysUCMapBase.getPSSystemName();
            }
            case 12: {
                return pSSysUCMapBase.getPSSysUCMapId();
            }
            case 13: {
                return pSSysUCMapBase.getPSSysUCMapName();
            }
            case 14: {
                return pSSysUCMapBase.getTags();
            }
            case 15: {
                return pSSysUCMapBase.getUCModel();
            }
            case 16: {
                return pSSysUCMapBase.getUpdateDate();
            }
            case 17: {
                return pSSysUCMapBase.getUpdateMan();
            }
            case 18: {
                return pSSysUCMapBase.getUserCat();
            }
            case 19: {
                return pSSysUCMapBase.getUserTag();
            }
            case 20: {
                return pSSysUCMapBase.getUserTag2();
            }
            case 21: {
                return pSSysUCMapBase.getUserTag3();
            }
            case 22: {
                return pSSysUCMapBase.getUserTag4();
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
        PSSysUCMapBase.set(this, n, object);
    }

    private static void set(PSSysUCMapBase pSSysUCMapBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUCMapBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysUCMapBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysUCMapBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUCMapBase.setMapTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUCMapBase.setMapTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUCMapBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUCMapBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUCMapBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUCMapBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUCMapBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUCMapBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUCMapBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUCMapBase.setPSSysUCMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUCMapBase.setPSSysUCMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUCMapBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUCMapBase.setUCModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUCMapBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysUCMapBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUCMapBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUCMapBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUCMapBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUCMapBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUCMapBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysUCMapBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUCMapBase pSSysUCMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUCMapBase.getCodeName() == null;
            }
            case 1: {
                return pSSysUCMapBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysUCMapBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysUCMapBase.getMapTag() == null;
            }
            case 4: {
                return pSSysUCMapBase.getMapTag2() == null;
            }
            case 5: {
                return pSSysUCMapBase.getMemo() == null;
            }
            case 6: {
                return pSSysUCMapBase.getPSModuleId() == null;
            }
            case 7: {
                return pSSysUCMapBase.getPSModuleName() == null;
            }
            case 8: {
                return pSSysUCMapBase.getPSSysAppId() == null;
            }
            case 9: {
                return pSSysUCMapBase.getPSSysAppName() == null;
            }
            case 10: {
                return pSSysUCMapBase.getPSSystemId() == null;
            }
            case 11: {
                return pSSysUCMapBase.getPSSystemName() == null;
            }
            case 12: {
                return pSSysUCMapBase.getPSSysUCMapId() == null;
            }
            case 13: {
                return pSSysUCMapBase.getPSSysUCMapName() == null;
            }
            case 14: {
                return pSSysUCMapBase.getTags() == null;
            }
            case 15: {
                return pSSysUCMapBase.getUCModel() == null;
            }
            case 16: {
                return pSSysUCMapBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysUCMapBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysUCMapBase.getUserCat() == null;
            }
            case 19: {
                return pSSysUCMapBase.getUserTag() == null;
            }
            case 20: {
                return pSSysUCMapBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysUCMapBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysUCMapBase.getUserTag4() == null;
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
        return PSSysUCMapBase.contains(this, n);
    }

    private static boolean contains(PSSysUCMapBase pSSysUCMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUCMapBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysUCMapBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysUCMapBase.isCreateManDirty();
            }
            case 3: {
                return pSSysUCMapBase.isMapTagDirty();
            }
            case 4: {
                return pSSysUCMapBase.isMapTag2Dirty();
            }
            case 5: {
                return pSSysUCMapBase.isMemoDirty();
            }
            case 6: {
                return pSSysUCMapBase.isPSModuleIdDirty();
            }
            case 7: {
                return pSSysUCMapBase.isPSModuleNameDirty();
            }
            case 8: {
                return pSSysUCMapBase.isPSSysAppIdDirty();
            }
            case 9: {
                return pSSysUCMapBase.isPSSysAppNameDirty();
            }
            case 10: {
                return pSSysUCMapBase.isPSSystemIdDirty();
            }
            case 11: {
                return pSSysUCMapBase.isPSSystemNameDirty();
            }
            case 12: {
                return pSSysUCMapBase.isPSSysUCMapIdDirty();
            }
            case 13: {
                return pSSysUCMapBase.isPSSysUCMapNameDirty();
            }
            case 14: {
                return pSSysUCMapBase.isTagsDirty();
            }
            case 15: {
                return pSSysUCMapBase.isUCModelDirty();
            }
            case 16: {
                return pSSysUCMapBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysUCMapBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysUCMapBase.isUserCatDirty();
            }
            case 19: {
                return pSSysUCMapBase.isUserTagDirty();
            }
            case 20: {
                return pSSysUCMapBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysUCMapBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysUCMapBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUCMapBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUCMapBase pSSysUCMapBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUCMapBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getMapTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maptag", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getMapTag()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getMapTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maptag2", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getMapTag2()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getPSSysUCMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysucmapid", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getPSSysUCMapId()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getPSSysUCMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysucmapname", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getPSSysUCMapName()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getTags()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getUCModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ucmodel", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getUCModel()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUCMapBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUCMapBase.getJSONValue((Object)pSSysUCMapBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUCMapBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUCMapBase pSSysUCMapBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUCMapBase.getCodeName() != null) {
            object = pSSysUCMapBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getCreateDate() != null) {
            object = pSSysUCMapBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUCMapBase.getCreateMan() != null) {
            object = pSSysUCMapBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getMapTag() != null) {
            object = pSSysUCMapBase.getMapTag();
            xmlNode.setAttribute(FIELD_MAPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getMapTag2() != null) {
            object = pSSysUCMapBase.getMapTag2();
            xmlNode.setAttribute(FIELD_MAPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getMemo() != null) {
            object = pSSysUCMapBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getPSModuleId() != null) {
            object = pSSysUCMapBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getPSModuleName() != null) {
            object = pSSysUCMapBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getPSSysAppId() != null) {
            object = pSSysUCMapBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getPSSysAppName() != null) {
            object = pSSysUCMapBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getPSSystemId() != null) {
            object = pSSysUCMapBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getPSSystemName() != null) {
            object = pSSysUCMapBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getPSSysUCMapId() != null) {
            object = pSSysUCMapBase.getPSSysUCMapId();
            xmlNode.setAttribute(FIELD_PSSYSUCMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getPSSysUCMapName() != null) {
            object = pSSysUCMapBase.getPSSysUCMapName();
            xmlNode.setAttribute(FIELD_PSSYSUCMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getTags() != null) {
            object = pSSysUCMapBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getUCModel() != null) {
            object = pSSysUCMapBase.getUCModel();
            xmlNode.setAttribute(FIELD_UCMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getUpdateDate() != null) {
            object = pSSysUCMapBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUCMapBase.getUpdateMan() != null) {
            object = pSSysUCMapBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getUserCat() != null) {
            object = pSSysUCMapBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getUserTag() != null) {
            object = pSSysUCMapBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getUserTag2() != null) {
            object = pSSysUCMapBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getUserTag3() != null) {
            object = pSSysUCMapBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapBase.getUserTag4() != null) {
            object = pSSysUCMapBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUCMapBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUCMapBase pSSysUCMapBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUCMapBase.isCodeNameDirty() && (bl || pSSysUCMapBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysUCMapBase.getCodeName());
        }
        if (pSSysUCMapBase.isCreateDateDirty() && (bl || pSSysUCMapBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUCMapBase.getCreateDate());
        }
        if (pSSysUCMapBase.isCreateManDirty() && (bl || pSSysUCMapBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUCMapBase.getCreateMan());
        }
        if (pSSysUCMapBase.isMapTagDirty() && (bl || pSSysUCMapBase.getMapTag() != null)) {
            iDataObject.set(FIELD_MAPTAG, (Object)pSSysUCMapBase.getMapTag());
        }
        if (pSSysUCMapBase.isMapTag2Dirty() && (bl || pSSysUCMapBase.getMapTag2() != null)) {
            iDataObject.set(FIELD_MAPTAG2, (Object)pSSysUCMapBase.getMapTag2());
        }
        if (pSSysUCMapBase.isMemoDirty() && (bl || pSSysUCMapBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUCMapBase.getMemo());
        }
        if (pSSysUCMapBase.isPSModuleIdDirty() && (bl || pSSysUCMapBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUCMapBase.getPSModuleId());
        }
        if (pSSysUCMapBase.isPSModuleNameDirty() && (bl || pSSysUCMapBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUCMapBase.getPSModuleName());
        }
        if (pSSysUCMapBase.isPSSysAppIdDirty() && (bl || pSSysUCMapBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysUCMapBase.getPSSysAppId());
        }
        if (pSSysUCMapBase.isPSSysAppNameDirty() && (bl || pSSysUCMapBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysUCMapBase.getPSSysAppName());
        }
        if (pSSysUCMapBase.isPSSystemIdDirty() && (bl || pSSysUCMapBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUCMapBase.getPSSystemId());
        }
        if (pSSysUCMapBase.isPSSystemNameDirty() && (bl || pSSysUCMapBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUCMapBase.getPSSystemName());
        }
        if (pSSysUCMapBase.isPSSysUCMapIdDirty() && (bl || pSSysUCMapBase.getPSSysUCMapId() != null)) {
            iDataObject.set(FIELD_PSSYSUCMAPID, (Object)pSSysUCMapBase.getPSSysUCMapId());
        }
        if (pSSysUCMapBase.isPSSysUCMapNameDirty() && (bl || pSSysUCMapBase.getPSSysUCMapName() != null)) {
            iDataObject.set(FIELD_PSSYSUCMAPNAME, (Object)pSSysUCMapBase.getPSSysUCMapName());
        }
        if (pSSysUCMapBase.isTagsDirty() && (bl || pSSysUCMapBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysUCMapBase.getTags());
        }
        if (pSSysUCMapBase.isUCModelDirty() && (bl || pSSysUCMapBase.getUCModel() != null)) {
            iDataObject.set(FIELD_UCMODEL, (Object)pSSysUCMapBase.getUCModel());
        }
        if (pSSysUCMapBase.isUpdateDateDirty() && (bl || pSSysUCMapBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUCMapBase.getUpdateDate());
        }
        if (pSSysUCMapBase.isUpdateManDirty() && (bl || pSSysUCMapBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUCMapBase.getUpdateMan());
        }
        if (pSSysUCMapBase.isUserCatDirty() && (bl || pSSysUCMapBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUCMapBase.getUserCat());
        }
        if (pSSysUCMapBase.isUserTagDirty() && (bl || pSSysUCMapBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUCMapBase.getUserTag());
        }
        if (pSSysUCMapBase.isUserTag2Dirty() && (bl || pSSysUCMapBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUCMapBase.getUserTag2());
        }
        if (pSSysUCMapBase.isUserTag3Dirty() && (bl || pSSysUCMapBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUCMapBase.getUserTag3());
        }
        if (pSSysUCMapBase.isUserTag4Dirty() && (bl || pSSysUCMapBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUCMapBase.getUserTag4());
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
        return PSSysUCMapBase.remove(this, n);
    }

    private static boolean remove(PSSysUCMapBase pSSysUCMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUCMapBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysUCMapBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysUCMapBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysUCMapBase.resetMapTag();
                return true;
            }
            case 4: {
                pSSysUCMapBase.resetMapTag2();
                return true;
            }
            case 5: {
                pSSysUCMapBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysUCMapBase.resetPSModuleId();
                return true;
            }
            case 7: {
                pSSysUCMapBase.resetPSModuleName();
                return true;
            }
            case 8: {
                pSSysUCMapBase.resetPSSysAppId();
                return true;
            }
            case 9: {
                pSSysUCMapBase.resetPSSysAppName();
                return true;
            }
            case 10: {
                pSSysUCMapBase.resetPSSystemId();
                return true;
            }
            case 11: {
                pSSysUCMapBase.resetPSSystemName();
                return true;
            }
            case 12: {
                pSSysUCMapBase.resetPSSysUCMapId();
                return true;
            }
            case 13: {
                pSSysUCMapBase.resetPSSysUCMapName();
                return true;
            }
            case 14: {
                pSSysUCMapBase.resetTags();
                return true;
            }
            case 15: {
                pSSysUCMapBase.resetUCModel();
                return true;
            }
            case 16: {
                pSSysUCMapBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysUCMapBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysUCMapBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysUCMapBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysUCMapBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysUCMapBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysUCMapBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUCMapNode> getPSSysUCMapNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMapNodes();
        }
        if (this.getPSSysUCMapId() == null) {
            return null;
        }
        PSSysUCMapService pSSysUCMapService = (PSSysUCMapService)ServiceGlobal.getService(PSSysUCMapService.class, (SessionFactory)this.getSessionFactory());
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUCMapNodesLock;
        synchronized (n) {
            if (this.pssysucmapnodes == null) {
                this.pssysucmapnodes = pSSysUCMapService.isTempData((IEntity)this) ? pSSysUCMapNodeService.selectTempByPSSysUCMap(this) : pSSysUCMapNodeService.selectByPSSysUCMap(this);
            }
            return this.pssysucmapnodes;
        }
    }

    private PSSysUCMapBase getProxyEntity() {
        return this.proxyPSSysUCMapBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUCMapBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUCMapBase) {
            this.proxyPSSysUCMapBase = (PSSysUCMapBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MAPTAG, 3);
        fieldIndexMap.put(FIELD_MAPTAG2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSMODULEID, 6);
        fieldIndexMap.put(FIELD_PSMODULENAME, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 8);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSUCMAPID, 12);
        fieldIndexMap.put(FIELD_PSSYSUCMAPNAME, 13);
        fieldIndexMap.put(FIELD_TAGS, 14);
        fieldIndexMap.put(FIELD_UCMODEL, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

