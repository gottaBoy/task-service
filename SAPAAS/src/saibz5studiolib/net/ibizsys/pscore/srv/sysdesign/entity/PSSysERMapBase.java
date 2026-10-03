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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMapNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysERMapBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysERMapBase.class);
    public static final String FIELD_ALLENTITYFLAG = "ALLENTITYFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFVIEWMODE = "DEFVIEWMODE";
    public static final String FIELD_ERMODEL = "ERMODEL";
    public static final String FIELD_INCSUBSYSFLAG = "INCSUBSYSFLAG";
    public static final String FIELD_MAPTAG = "MAPTAG";
    public static final String FIELD_MAPTAG2 = "MAPTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSERMAPID = "PSSYSERMAPID";
    public static final String FIELD_PSSYSERMAPNAME = "PSSYSERMAPNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SHAPEPARAMS = "SHAPEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ALLENTITYFLAG = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFVIEWMODE = 4;
    private static final int INDEX_ERMODEL = 5;
    private static final int INDEX_INCSUBSYSFLAG = 6;
    private static final int INDEX_MAPTAG = 7;
    private static final int INDEX_MAPTAG2 = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSMODULEID = 10;
    private static final int INDEX_PSMODULENAME = 11;
    private static final int INDEX_PSSYSAPPID = 12;
    private static final int INDEX_PSSYSAPPNAME = 13;
    private static final int INDEX_PSSYSERMAPID = 14;
    private static final int INDEX_PSSYSERMAPNAME = 15;
    private static final int INDEX_PSSYSTEMID = 16;
    private static final int INDEX_PSSYSTEMNAME = 17;
    private static final int INDEX_SHAPEPARAMS = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysERMapBase proxyPSSysERMapBase = null;
    private boolean allentityflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defviewmodeDirtyFlag = false;
    private boolean ermodelDirtyFlag = false;
    private boolean incsubsysflagDirtyFlag = false;
    private boolean maptagDirtyFlag = false;
    private boolean maptag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysermapidDirtyFlag = false;
    private boolean pssysermapnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean shapeparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="allentityflag")
    private Integer allentityflag;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defviewmode")
    private String defviewmode;
    @Column(name="ermodel")
    private String ermodel;
    @Column(name="incsubsysflag")
    private Integer incsubsysflag;
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
    @Column(name="pssysermapid")
    private String pssysermapid;
    @Column(name="pssysermapname")
    private String pssysermapname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="shapeparams")
    private String shapeparams;
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
    private Integer objPSSysERMapNodesLock = new Integer(1);
    private ArrayList<PSSysERMapNode> pssysermapnodes = null;

    public void setAllEntityFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllEntityFlag(n);
            return;
        }
        this.allentityflag = n;
        this.allentityflagDirtyFlag = true;
    }

    public Integer getAllEntityFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllEntityFlag();
        }
        return this.allentityflag;
    }

    public boolean isAllEntityFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllEntityFlagDirty();
        }
        return this.allentityflagDirtyFlag;
    }

    public void resetAllEntityFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllEntityFlag();
            return;
        }
        this.allentityflagDirtyFlag = false;
        this.allentityflag = null;
    }

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

    public void setDefViewMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefViewMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defviewmode = string;
        this.defviewmodeDirtyFlag = true;
    }

    public String getDefViewMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefViewMode();
        }
        return this.defviewmode;
    }

    public boolean isDefViewModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefViewModeDirty();
        }
        return this.defviewmodeDirtyFlag;
    }

    public void resetDefViewMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefViewMode();
            return;
        }
        this.defviewmodeDirtyFlag = false;
        this.defviewmode = null;
    }

    public void setERModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setERModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ermodel = string;
        this.ermodelDirtyFlag = true;
    }

    public String getERModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getERModel();
        }
        return this.ermodel;
    }

    public boolean isERModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isERModelDirty();
        }
        return this.ermodelDirtyFlag;
    }

    public void resetERModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetERModel();
            return;
        }
        this.ermodelDirtyFlag = false;
        this.ermodel = null;
    }

    public void setIncSubSysFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncSubSysFlag(n);
            return;
        }
        this.incsubsysflag = n;
        this.incsubsysflagDirtyFlag = true;
    }

    public Integer getIncSubSysFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncSubSysFlag();
        }
        return this.incsubsysflag;
    }

    public boolean isIncSubSysFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncSubSysFlagDirty();
        }
        return this.incsubsysflagDirtyFlag;
    }

    public void resetIncSubSysFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncSubSysFlag();
            return;
        }
        this.incsubsysflagDirtyFlag = false;
        this.incsubsysflag = null;
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

    public void setPSSysERMapId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysERMapId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysermapid = string;
        this.pssysermapidDirtyFlag = true;
    }

    public String getPSSysERMapId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMapId();
        }
        return this.pssysermapid;
    }

    public boolean isPSSysERMapIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysERMapIdDirty();
        }
        return this.pssysermapidDirtyFlag;
    }

    public void resetPSSysERMapId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysERMapId();
            return;
        }
        this.pssysermapidDirtyFlag = false;
        this.pssysermapid = null;
    }

    public void setPSSysERMapName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysERMapName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysermapname = string;
        this.pssysermapnameDirtyFlag = true;
    }

    public String getPSSysERMapName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMapName();
        }
        return this.pssysermapname;
    }

    public boolean isPSSysERMapNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysERMapNameDirty();
        }
        return this.pssysermapnameDirtyFlag;
    }

    public void resetPSSysERMapName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysERMapName();
            return;
        }
        this.pssysermapnameDirtyFlag = false;
        this.pssysermapname = null;
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

    public void setShapeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapeparams = string;
        this.shapeparamsDirtyFlag = true;
    }

    public String getShapeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeParams();
        }
        return this.shapeparams;
    }

    public boolean isShapeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeParamsDirty();
        }
        return this.shapeparamsDirtyFlag;
    }

    public void resetShapeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeParams();
            return;
        }
        this.shapeparamsDirtyFlag = false;
        this.shapeparams = null;
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
        PSSysERMapBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysERMapBase pSSysERMapBase) {
        pSSysERMapBase.resetAllEntityFlag();
        pSSysERMapBase.resetCodeName();
        pSSysERMapBase.resetCreateDate();
        pSSysERMapBase.resetCreateMan();
        pSSysERMapBase.resetDefViewMode();
        pSSysERMapBase.resetERModel();
        pSSysERMapBase.resetIncSubSysFlag();
        pSSysERMapBase.resetMapTag();
        pSSysERMapBase.resetMapTag2();
        pSSysERMapBase.resetMemo();
        pSSysERMapBase.resetPSModuleId();
        pSSysERMapBase.resetPSModuleName();
        pSSysERMapBase.resetPSSysAppId();
        pSSysERMapBase.resetPSSysAppName();
        pSSysERMapBase.resetPSSysERMapId();
        pSSysERMapBase.resetPSSysERMapName();
        pSSysERMapBase.resetPSSystemId();
        pSSysERMapBase.resetPSSystemName();
        pSSysERMapBase.resetShapeParams();
        pSSysERMapBase.resetUpdateDate();
        pSSysERMapBase.resetUpdateMan();
        pSSysERMapBase.resetUserCat();
        pSSysERMapBase.resetUserTag();
        pSSysERMapBase.resetUserTag2();
        pSSysERMapBase.resetUserTag3();
        pSSysERMapBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllEntityFlagDirty()) {
            hashMap.put(FIELD_ALLENTITYFLAG, this.getAllEntityFlag());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefViewModeDirty()) {
            hashMap.put(FIELD_DEFVIEWMODE, this.getDefViewMode());
        }
        if (!bl || this.isERModelDirty()) {
            hashMap.put(FIELD_ERMODEL, this.getERModel());
        }
        if (!bl || this.isIncSubSysFlagDirty()) {
            hashMap.put(FIELD_INCSUBSYSFLAG, this.getIncSubSysFlag());
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
        if (!bl || this.isPSSysERMapIdDirty()) {
            hashMap.put(FIELD_PSSYSERMAPID, this.getPSSysERMapId());
        }
        if (!bl || this.isPSSysERMapNameDirty()) {
            hashMap.put(FIELD_PSSYSERMAPNAME, this.getPSSysERMapName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isShapeParamsDirty()) {
            hashMap.put(FIELD_SHAPEPARAMS, this.getShapeParams());
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
        return PSSysERMapBase.get(this, n);
    }

    private static Object get(PSSysERMapBase pSSysERMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysERMapBase.getAllEntityFlag();
            }
            case 1: {
                return pSSysERMapBase.getCodeName();
            }
            case 2: {
                return pSSysERMapBase.getCreateDate();
            }
            case 3: {
                return pSSysERMapBase.getCreateMan();
            }
            case 4: {
                return pSSysERMapBase.getDefViewMode();
            }
            case 5: {
                return pSSysERMapBase.getERModel();
            }
            case 6: {
                return pSSysERMapBase.getIncSubSysFlag();
            }
            case 7: {
                return pSSysERMapBase.getMapTag();
            }
            case 8: {
                return pSSysERMapBase.getMapTag2();
            }
            case 9: {
                return pSSysERMapBase.getMemo();
            }
            case 10: {
                return pSSysERMapBase.getPSModuleId();
            }
            case 11: {
                return pSSysERMapBase.getPSModuleName();
            }
            case 12: {
                return pSSysERMapBase.getPSSysAppId();
            }
            case 13: {
                return pSSysERMapBase.getPSSysAppName();
            }
            case 14: {
                return pSSysERMapBase.getPSSysERMapId();
            }
            case 15: {
                return pSSysERMapBase.getPSSysERMapName();
            }
            case 16: {
                return pSSysERMapBase.getPSSystemId();
            }
            case 17: {
                return pSSysERMapBase.getPSSystemName();
            }
            case 18: {
                return pSSysERMapBase.getShapeParams();
            }
            case 19: {
                return pSSysERMapBase.getUpdateDate();
            }
            case 20: {
                return pSSysERMapBase.getUpdateMan();
            }
            case 21: {
                return pSSysERMapBase.getUserCat();
            }
            case 22: {
                return pSSysERMapBase.getUserTag();
            }
            case 23: {
                return pSSysERMapBase.getUserTag2();
            }
            case 24: {
                return pSSysERMapBase.getUserTag3();
            }
            case 25: {
                return pSSysERMapBase.getUserTag4();
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
        PSSysERMapBase.set(this, n, object);
    }

    private static void set(PSSysERMapBase pSSysERMapBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysERMapBase.setAllEntityFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysERMapBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysERMapBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysERMapBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysERMapBase.setDefViewMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysERMapBase.setERModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysERMapBase.setIncSubSysFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysERMapBase.setMapTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysERMapBase.setMapTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysERMapBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysERMapBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysERMapBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysERMapBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysERMapBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysERMapBase.setPSSysERMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysERMapBase.setPSSysERMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysERMapBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysERMapBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysERMapBase.setShapeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysERMapBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSysERMapBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysERMapBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysERMapBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysERMapBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysERMapBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysERMapBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysERMapBase.isNull(this, n);
    }

    private static boolean isNull(PSSysERMapBase pSSysERMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysERMapBase.getAllEntityFlag() == null;
            }
            case 1: {
                return pSSysERMapBase.getCodeName() == null;
            }
            case 2: {
                return pSSysERMapBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysERMapBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysERMapBase.getDefViewMode() == null;
            }
            case 5: {
                return pSSysERMapBase.getERModel() == null;
            }
            case 6: {
                return pSSysERMapBase.getIncSubSysFlag() == null;
            }
            case 7: {
                return pSSysERMapBase.getMapTag() == null;
            }
            case 8: {
                return pSSysERMapBase.getMapTag2() == null;
            }
            case 9: {
                return pSSysERMapBase.getMemo() == null;
            }
            case 10: {
                return pSSysERMapBase.getPSModuleId() == null;
            }
            case 11: {
                return pSSysERMapBase.getPSModuleName() == null;
            }
            case 12: {
                return pSSysERMapBase.getPSSysAppId() == null;
            }
            case 13: {
                return pSSysERMapBase.getPSSysAppName() == null;
            }
            case 14: {
                return pSSysERMapBase.getPSSysERMapId() == null;
            }
            case 15: {
                return pSSysERMapBase.getPSSysERMapName() == null;
            }
            case 16: {
                return pSSysERMapBase.getPSSystemId() == null;
            }
            case 17: {
                return pSSysERMapBase.getPSSystemName() == null;
            }
            case 18: {
                return pSSysERMapBase.getShapeParams() == null;
            }
            case 19: {
                return pSSysERMapBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSysERMapBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSysERMapBase.getUserCat() == null;
            }
            case 22: {
                return pSSysERMapBase.getUserTag() == null;
            }
            case 23: {
                return pSSysERMapBase.getUserTag2() == null;
            }
            case 24: {
                return pSSysERMapBase.getUserTag3() == null;
            }
            case 25: {
                return pSSysERMapBase.getUserTag4() == null;
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
        return PSSysERMapBase.contains(this, n);
    }

    private static boolean contains(PSSysERMapBase pSSysERMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysERMapBase.isAllEntityFlagDirty();
            }
            case 1: {
                return pSSysERMapBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysERMapBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysERMapBase.isCreateManDirty();
            }
            case 4: {
                return pSSysERMapBase.isDefViewModeDirty();
            }
            case 5: {
                return pSSysERMapBase.isERModelDirty();
            }
            case 6: {
                return pSSysERMapBase.isIncSubSysFlagDirty();
            }
            case 7: {
                return pSSysERMapBase.isMapTagDirty();
            }
            case 8: {
                return pSSysERMapBase.isMapTag2Dirty();
            }
            case 9: {
                return pSSysERMapBase.isMemoDirty();
            }
            case 10: {
                return pSSysERMapBase.isPSModuleIdDirty();
            }
            case 11: {
                return pSSysERMapBase.isPSModuleNameDirty();
            }
            case 12: {
                return pSSysERMapBase.isPSSysAppIdDirty();
            }
            case 13: {
                return pSSysERMapBase.isPSSysAppNameDirty();
            }
            case 14: {
                return pSSysERMapBase.isPSSysERMapIdDirty();
            }
            case 15: {
                return pSSysERMapBase.isPSSysERMapNameDirty();
            }
            case 16: {
                return pSSysERMapBase.isPSSystemIdDirty();
            }
            case 17: {
                return pSSysERMapBase.isPSSystemNameDirty();
            }
            case 18: {
                return pSSysERMapBase.isShapeParamsDirty();
            }
            case 19: {
                return pSSysERMapBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSysERMapBase.isUpdateManDirty();
            }
            case 21: {
                return pSSysERMapBase.isUserCatDirty();
            }
            case 22: {
                return pSSysERMapBase.isUserTagDirty();
            }
            case 23: {
                return pSSysERMapBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSysERMapBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSysERMapBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysERMapBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysERMapBase pSSysERMapBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysERMapBase.getAllEntityFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allentityflag", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getAllEntityFlag()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getDefViewMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defviewmode", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getDefViewMode()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getERModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ermodel", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getERModel()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getIncSubSysFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incsubsysflag", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getIncSubSysFlag()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getMapTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maptag", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getMapTag()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getMapTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maptag2", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getMapTag2()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getPSSysERMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysermapid", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getPSSysERMapId()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getPSSysERMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysermapname", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getPSSysERMapName()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getShapeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeparams", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getShapeParams()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysERMapBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysERMapBase.getJSONValue((Object)pSSysERMapBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysERMapBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysERMapBase pSSysERMapBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysERMapBase.getAllEntityFlag() != null) {
            object = pSSysERMapBase.getAllEntityFlag();
            xmlNode.setAttribute(FIELD_ALLENTITYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysERMapBase.getCodeName() != null) {
            object = pSSysERMapBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getCreateDate() != null) {
            object = pSSysERMapBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysERMapBase.getCreateMan() != null) {
            object = pSSysERMapBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getDefViewMode() != null) {
            object = pSSysERMapBase.getDefViewMode();
            xmlNode.setAttribute(FIELD_DEFVIEWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getERModel() != null) {
            object = pSSysERMapBase.getERModel();
            xmlNode.setAttribute(FIELD_ERMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getIncSubSysFlag() != null) {
            object = pSSysERMapBase.getIncSubSysFlag();
            xmlNode.setAttribute(FIELD_INCSUBSYSFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysERMapBase.getMapTag() != null) {
            object = pSSysERMapBase.getMapTag();
            xmlNode.setAttribute(FIELD_MAPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getMapTag2() != null) {
            object = pSSysERMapBase.getMapTag2();
            xmlNode.setAttribute(FIELD_MAPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getMemo() != null) {
            object = pSSysERMapBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getPSModuleId() != null) {
            object = pSSysERMapBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getPSModuleName() != null) {
            object = pSSysERMapBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getPSSysAppId() != null) {
            object = pSSysERMapBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getPSSysAppName() != null) {
            object = pSSysERMapBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getPSSysERMapId() != null) {
            object = pSSysERMapBase.getPSSysERMapId();
            xmlNode.setAttribute(FIELD_PSSYSERMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getPSSysERMapName() != null) {
            object = pSSysERMapBase.getPSSysERMapName();
            xmlNode.setAttribute(FIELD_PSSYSERMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getPSSystemId() != null) {
            object = pSSysERMapBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getPSSystemName() != null) {
            object = pSSysERMapBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getShapeParams() != null) {
            object = pSSysERMapBase.getShapeParams();
            xmlNode.setAttribute(FIELD_SHAPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getUpdateDate() != null) {
            object = pSSysERMapBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysERMapBase.getUpdateMan() != null) {
            object = pSSysERMapBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getUserCat() != null) {
            object = pSSysERMapBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getUserTag() != null) {
            object = pSSysERMapBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getUserTag2() != null) {
            object = pSSysERMapBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getUserTag3() != null) {
            object = pSSysERMapBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysERMapBase.getUserTag4() != null) {
            object = pSSysERMapBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysERMapBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysERMapBase pSSysERMapBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysERMapBase.isAllEntityFlagDirty() && (bl || pSSysERMapBase.getAllEntityFlag() != null)) {
            iDataObject.set(FIELD_ALLENTITYFLAG, (Object)pSSysERMapBase.getAllEntityFlag());
        }
        if (pSSysERMapBase.isCodeNameDirty() && (bl || pSSysERMapBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysERMapBase.getCodeName());
        }
        if (pSSysERMapBase.isCreateDateDirty() && (bl || pSSysERMapBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysERMapBase.getCreateDate());
        }
        if (pSSysERMapBase.isCreateManDirty() && (bl || pSSysERMapBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysERMapBase.getCreateMan());
        }
        if (pSSysERMapBase.isDefViewModeDirty() && (bl || pSSysERMapBase.getDefViewMode() != null)) {
            iDataObject.set(FIELD_DEFVIEWMODE, (Object)pSSysERMapBase.getDefViewMode());
        }
        if (pSSysERMapBase.isERModelDirty() && (bl || pSSysERMapBase.getERModel() != null)) {
            iDataObject.set(FIELD_ERMODEL, (Object)pSSysERMapBase.getERModel());
        }
        if (pSSysERMapBase.isIncSubSysFlagDirty() && (bl || pSSysERMapBase.getIncSubSysFlag() != null)) {
            iDataObject.set(FIELD_INCSUBSYSFLAG, (Object)pSSysERMapBase.getIncSubSysFlag());
        }
        if (pSSysERMapBase.isMapTagDirty() && (bl || pSSysERMapBase.getMapTag() != null)) {
            iDataObject.set(FIELD_MAPTAG, (Object)pSSysERMapBase.getMapTag());
        }
        if (pSSysERMapBase.isMapTag2Dirty() && (bl || pSSysERMapBase.getMapTag2() != null)) {
            iDataObject.set(FIELD_MAPTAG2, (Object)pSSysERMapBase.getMapTag2());
        }
        if (pSSysERMapBase.isMemoDirty() && (bl || pSSysERMapBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysERMapBase.getMemo());
        }
        if (pSSysERMapBase.isPSModuleIdDirty() && (bl || pSSysERMapBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysERMapBase.getPSModuleId());
        }
        if (pSSysERMapBase.isPSModuleNameDirty() && (bl || pSSysERMapBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysERMapBase.getPSModuleName());
        }
        if (pSSysERMapBase.isPSSysAppIdDirty() && (bl || pSSysERMapBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysERMapBase.getPSSysAppId());
        }
        if (pSSysERMapBase.isPSSysAppNameDirty() && (bl || pSSysERMapBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysERMapBase.getPSSysAppName());
        }
        if (pSSysERMapBase.isPSSysERMapIdDirty() && (bl || pSSysERMapBase.getPSSysERMapId() != null)) {
            iDataObject.set(FIELD_PSSYSERMAPID, (Object)pSSysERMapBase.getPSSysERMapId());
        }
        if (pSSysERMapBase.isPSSysERMapNameDirty() && (bl || pSSysERMapBase.getPSSysERMapName() != null)) {
            iDataObject.set(FIELD_PSSYSERMAPNAME, (Object)pSSysERMapBase.getPSSysERMapName());
        }
        if (pSSysERMapBase.isPSSystemIdDirty() && (bl || pSSysERMapBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysERMapBase.getPSSystemId());
        }
        if (pSSysERMapBase.isPSSystemNameDirty() && (bl || pSSysERMapBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysERMapBase.getPSSystemName());
        }
        if (pSSysERMapBase.isShapeParamsDirty() && (bl || pSSysERMapBase.getShapeParams() != null)) {
            iDataObject.set(FIELD_SHAPEPARAMS, (Object)pSSysERMapBase.getShapeParams());
        }
        if (pSSysERMapBase.isUpdateDateDirty() && (bl || pSSysERMapBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysERMapBase.getUpdateDate());
        }
        if (pSSysERMapBase.isUpdateManDirty() && (bl || pSSysERMapBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysERMapBase.getUpdateMan());
        }
        if (pSSysERMapBase.isUserCatDirty() && (bl || pSSysERMapBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysERMapBase.getUserCat());
        }
        if (pSSysERMapBase.isUserTagDirty() && (bl || pSSysERMapBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysERMapBase.getUserTag());
        }
        if (pSSysERMapBase.isUserTag2Dirty() && (bl || pSSysERMapBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysERMapBase.getUserTag2());
        }
        if (pSSysERMapBase.isUserTag3Dirty() && (bl || pSSysERMapBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysERMapBase.getUserTag3());
        }
        if (pSSysERMapBase.isUserTag4Dirty() && (bl || pSSysERMapBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysERMapBase.getUserTag4());
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
        return PSSysERMapBase.remove(this, n);
    }

    private static boolean remove(PSSysERMapBase pSSysERMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysERMapBase.resetAllEntityFlag();
                return true;
            }
            case 1: {
                pSSysERMapBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysERMapBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysERMapBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysERMapBase.resetDefViewMode();
                return true;
            }
            case 5: {
                pSSysERMapBase.resetERModel();
                return true;
            }
            case 6: {
                pSSysERMapBase.resetIncSubSysFlag();
                return true;
            }
            case 7: {
                pSSysERMapBase.resetMapTag();
                return true;
            }
            case 8: {
                pSSysERMapBase.resetMapTag2();
                return true;
            }
            case 9: {
                pSSysERMapBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysERMapBase.resetPSModuleId();
                return true;
            }
            case 11: {
                pSSysERMapBase.resetPSModuleName();
                return true;
            }
            case 12: {
                pSSysERMapBase.resetPSSysAppId();
                return true;
            }
            case 13: {
                pSSysERMapBase.resetPSSysAppName();
                return true;
            }
            case 14: {
                pSSysERMapBase.resetPSSysERMapId();
                return true;
            }
            case 15: {
                pSSysERMapBase.resetPSSysERMapName();
                return true;
            }
            case 16: {
                pSSysERMapBase.resetPSSystemId();
                return true;
            }
            case 17: {
                pSSysERMapBase.resetPSSystemName();
                return true;
            }
            case 18: {
                pSSysERMapBase.resetShapeParams();
                return true;
            }
            case 19: {
                pSSysERMapBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSysERMapBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSysERMapBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSysERMapBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysERMapBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSysERMapBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSysERMapBase.resetUserTag4();
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
                pSModuleService.autoGet(pSModule);
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
                pSSysAppService.autoGet(pSSysApp);
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
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysERMapNode> getPSSysERMapNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMapNodes();
        }
        if (this.getPSSysERMapId() == null) {
            return null;
        }
        PSSysERMapService pSSysERMapService = (PSSysERMapService)ServiceGlobal.getService(PSSysERMapService.class, (SessionFactory)this.getSessionFactory());
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysERMapNodesLock;
        synchronized (n) {
            if (this.pssysermapnodes == null) {
                this.pssysermapnodes = pSSysERMapService.isTempData(this) ? pSSysERMapNodeService.selectTempByPSSysERMap(this) : pSSysERMapNodeService.selectByPSSysERMap(this);
            }
            return this.pssysermapnodes;
        }
    }

    private PSSysERMapBase getProxyEntity() {
        return this.proxyPSSysERMapBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysERMapBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysERMapBase) {
            this.proxyPSSysERMapBase = (PSSysERMapBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLENTITYFLAG, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFVIEWMODE, 4);
        fieldIndexMap.put(FIELD_ERMODEL, 5);
        fieldIndexMap.put(FIELD_INCSUBSYSFLAG, 6);
        fieldIndexMap.put(FIELD_MAPTAG, 7);
        fieldIndexMap.put(FIELD_MAPTAG2, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSMODULEID, 10);
        fieldIndexMap.put(FIELD_PSMODULENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 12);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSERMAPID, 14);
        fieldIndexMap.put(FIELD_PSSYSERMAPNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 17);
        fieldIndexMap.put(FIELD_SHAPEPARAMS, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
    }
}

