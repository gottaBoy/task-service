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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFInputTipSetBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFInputTipSetBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String FIELD_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ECPSDEFID = "ECPSDEFID";
    public static final String FIELD_ECPSDEFNAME = "ECPSDEFNAME";
    public static final String FIELD_LINKPSDEFID = "LINKPSDEFID";
    public static final String FIELD_LINKPSDEFNAME = "LINKPSDEFNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String FIELD_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UNIQUETAGPSDEFID = "UNIQUETAGPSDEFID";
    public static final String FIELD_UNIQUETAGPSDEFNAME = "UNIQUETAGPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CONTENTPSDEFID = 1;
    private static final int INDEX_CONTENTPSDEFNAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_ECPSDEFID = 5;
    private static final int INDEX_ECPSDEFNAME = 6;
    private static final int INDEX_LINKPSDEFID = 7;
    private static final int INDEX_LINKPSDEFNAME = 8;
    private static final int INDEX_LOCKFLAG = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PSDEDATASETID = 11;
    private static final int INDEX_PSDEDATASETNAME = 12;
    private static final int INDEX_PSDEFINPUTTIPSETID = 13;
    private static final int INDEX_PSDEFINPUTTIPSETNAME = 14;
    private static final int INDEX_PSDEID = 15;
    private static final int INDEX_PSDENAME = 16;
    private static final int INDEX_PSMODULEID = 17;
    private static final int INDEX_PSMODULENAME = 18;
    private static final int INDEX_PSSYSPFPLUGINID = 19;
    private static final int INDEX_PSSYSPFPLUGINNAME = 20;
    private static final int INDEX_PSSYSSFPLUGINID = 21;
    private static final int INDEX_PSSYSSFPLUGINNAME = 22;
    private static final int INDEX_PSSYSTEMID = 23;
    private static final int INDEX_PSSYSTEMNAME = 24;
    private static final int INDEX_UNIQUETAGPSDEFID = 25;
    private static final int INDEX_UNIQUETAGPSDEFNAME = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFInputTipSetBase proxyPSDEFInputTipSetBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean contentpsdefidDirtyFlag = false;
    private boolean contentpsdefnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ecpsdefidDirtyFlag = false;
    private boolean ecpsdefnameDirtyFlag = false;
    private boolean linkpsdefidDirtyFlag = false;
    private boolean linkpsdefnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdefinputtipsetidDirtyFlag = false;
    private boolean psdefinputtipsetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean uniquetagpsdefidDirtyFlag = false;
    private boolean uniquetagpsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="contentpsdefid")
    private String contentpsdefid;
    @Column(name="contentpsdefname")
    private String contentpsdefname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ecpsdefid")
    private String ecpsdefid;
    @Column(name="ecpsdefname")
    private String ecpsdefname;
    @Column(name="linkpsdefid")
    private String linkpsdefid;
    @Column(name="linkpsdefname")
    private String linkpsdefname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdefinputtipsetid")
    private String psdefinputtipsetid;
    @Column(name="psdefinputtipsetname")
    private String psdefinputtipsetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="uniquetagpsdefid")
    private String uniquetagpsdefid;
    @Column(name="uniquetagpsdefname")
    private String uniquetagpsdefname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objContentPSDEFLock = new Integer(1);
    private PSDEField contentpsdef = null;
    private Integer objECPSDEFLock = new Integer(1);
    private PSDEField ecpsdef = null;
    private Integer objLinkPSDEFLock = new Integer(1);
    private PSDEField linkpsdef = null;
    private Integer objUniqueTagPSDEFLock = new Integer(1);
    private PSDEField uniquetagpsdef = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefid = string;
        this.contentpsdefidDirtyFlag = true;
    }

    public String getContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFId();
        }
        return this.contentpsdefid;
    }

    public boolean isContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFIdDirty();
        }
        return this.contentpsdefidDirtyFlag;
    }

    public void resetContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFId();
            return;
        }
        this.contentpsdefidDirtyFlag = false;
        this.contentpsdefid = null;
    }

    public void setContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefname = string;
        this.contentpsdefnameDirtyFlag = true;
    }

    public String getContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFName();
        }
        return this.contentpsdefname;
    }

    public boolean isContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFNameDirty();
        }
        return this.contentpsdefnameDirtyFlag;
    }

    public void resetContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFName();
            return;
        }
        this.contentpsdefnameDirtyFlag = false;
        this.contentpsdefname = null;
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

    public void setECPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setECPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ecpsdefid = string;
        this.ecpsdefidDirtyFlag = true;
    }

    public String getECPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getECPSDEFId();
        }
        return this.ecpsdefid;
    }

    public boolean isECPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isECPSDEFIdDirty();
        }
        return this.ecpsdefidDirtyFlag;
    }

    public void resetECPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetECPSDEFId();
            return;
        }
        this.ecpsdefidDirtyFlag = false;
        this.ecpsdefid = null;
    }

    public void setECPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setECPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ecpsdefname = string;
        this.ecpsdefnameDirtyFlag = true;
    }

    public String getECPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getECPSDEFName();
        }
        return this.ecpsdefname;
    }

    public boolean isECPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isECPSDEFNameDirty();
        }
        return this.ecpsdefnameDirtyFlag;
    }

    public void resetECPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetECPSDEFName();
            return;
        }
        this.ecpsdefnameDirtyFlag = false;
        this.ecpsdefname = null;
    }

    public void setLinkPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdefid = string;
        this.linkpsdefidDirtyFlag = true;
    }

    public String getLinkPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEFId();
        }
        return this.linkpsdefid;
    }

    public boolean isLinkPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEFIdDirty();
        }
        return this.linkpsdefidDirtyFlag;
    }

    public void resetLinkPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEFId();
            return;
        }
        this.linkpsdefidDirtyFlag = false;
        this.linkpsdefid = null;
    }

    public void setLinkPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdefname = string;
        this.linkpsdefnameDirtyFlag = true;
    }

    public String getLinkPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEFName();
        }
        return this.linkpsdefname;
    }

    public boolean isLinkPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEFNameDirty();
        }
        return this.linkpsdefnameDirtyFlag;
    }

    public void resetLinkPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEFName();
            return;
        }
        this.linkpsdefnameDirtyFlag = false;
        this.linkpsdefname = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
    }

    public void setPSDEFInputTipSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipsetid = string;
        this.psdefinputtipsetidDirtyFlag = true;
    }

    public String getPSDEFInputTipSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSetId();
        }
        return this.psdefinputtipsetid;
    }

    public boolean isPSDEFInputTipSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipSetIdDirty();
        }
        return this.psdefinputtipsetidDirtyFlag;
    }

    public void resetPSDEFInputTipSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipSetId();
            return;
        }
        this.psdefinputtipsetidDirtyFlag = false;
        this.psdefinputtipsetid = null;
    }

    public void setPSDEFInputTipSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipsetname = string;
        this.psdefinputtipsetnameDirtyFlag = true;
    }

    public String getPSDEFInputTipSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSetName();
        }
        return this.psdefinputtipsetname;
    }

    public boolean isPSDEFInputTipSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipSetNameDirty();
        }
        return this.psdefinputtipsetnameDirtyFlag;
    }

    public void resetPSDEFInputTipSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipSetName();
            return;
        }
        this.psdefinputtipsetnameDirtyFlag = false;
        this.psdefinputtipsetname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setUniqueTagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueTagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uniquetagpsdefid = string;
        this.uniquetagpsdefidDirtyFlag = true;
    }

    public String getUniqueTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTagPSDEFId();
        }
        return this.uniquetagpsdefid;
    }

    public boolean isUniqueTagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueTagPSDEFIdDirty();
        }
        return this.uniquetagpsdefidDirtyFlag;
    }

    public void resetUniqueTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueTagPSDEFId();
            return;
        }
        this.uniquetagpsdefidDirtyFlag = false;
        this.uniquetagpsdefid = null;
    }

    public void setUniqueTagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueTagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uniquetagpsdefname = string;
        this.uniquetagpsdefnameDirtyFlag = true;
    }

    public String getUniqueTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTagPSDEFName();
        }
        return this.uniquetagpsdefname;
    }

    public boolean isUniqueTagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueTagPSDEFNameDirty();
        }
        return this.uniquetagpsdefnameDirtyFlag;
    }

    public void resetUniqueTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueTagPSDEFName();
            return;
        }
        this.uniquetagpsdefnameDirtyFlag = false;
        this.uniquetagpsdefname = null;
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
        PSDEFInputTipSetBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFInputTipSetBase pSDEFInputTipSetBase) {
        pSDEFInputTipSetBase.resetCodeName();
        pSDEFInputTipSetBase.resetContentPSDEFId();
        pSDEFInputTipSetBase.resetContentPSDEFName();
        pSDEFInputTipSetBase.resetCreateDate();
        pSDEFInputTipSetBase.resetCreateMan();
        pSDEFInputTipSetBase.resetECPSDEFId();
        pSDEFInputTipSetBase.resetECPSDEFName();
        pSDEFInputTipSetBase.resetLinkPSDEFId();
        pSDEFInputTipSetBase.resetLinkPSDEFName();
        pSDEFInputTipSetBase.resetLockFlag();
        pSDEFInputTipSetBase.resetMemo();
        pSDEFInputTipSetBase.resetPSDEDataSetId();
        pSDEFInputTipSetBase.resetPSDEDataSetName();
        pSDEFInputTipSetBase.resetPSDEFInputTipSetId();
        pSDEFInputTipSetBase.resetPSDEFInputTipSetName();
        pSDEFInputTipSetBase.resetPSDEId();
        pSDEFInputTipSetBase.resetPSDEName();
        pSDEFInputTipSetBase.resetPSModuleId();
        pSDEFInputTipSetBase.resetPSModuleName();
        pSDEFInputTipSetBase.resetPSSysPFPluginId();
        pSDEFInputTipSetBase.resetPSSysPFPluginName();
        pSDEFInputTipSetBase.resetPSSysSFPluginId();
        pSDEFInputTipSetBase.resetPSSysSFPluginName();
        pSDEFInputTipSetBase.resetPSSystemId();
        pSDEFInputTipSetBase.resetPSSystemName();
        pSDEFInputTipSetBase.resetUniqueTagPSDEFId();
        pSDEFInputTipSetBase.resetUniqueTagPSDEFName();
        pSDEFInputTipSetBase.resetUpdateDate();
        pSDEFInputTipSetBase.resetUpdateMan();
        pSDEFInputTipSetBase.resetUserCat();
        pSDEFInputTipSetBase.resetUserTag();
        pSDEFInputTipSetBase.resetUserTag2();
        pSDEFInputTipSetBase.resetUserTag3();
        pSDEFInputTipSetBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentPSDEFIdDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFID, this.getContentPSDEFId());
        }
        if (!bl || this.isContentPSDEFNameDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFNAME, this.getContentPSDEFName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isECPSDEFIdDirty()) {
            hashMap.put(FIELD_ECPSDEFID, this.getECPSDEFId());
        }
        if (!bl || this.isECPSDEFNameDirty()) {
            hashMap.put(FIELD_ECPSDEFNAME, this.getECPSDEFName());
        }
        if (!bl || this.isLinkPSDEFIdDirty()) {
            hashMap.put(FIELD_LINKPSDEFID, this.getLinkPSDEFId());
        }
        if (!bl || this.isLinkPSDEFNameDirty()) {
            hashMap.put(FIELD_LINKPSDEFNAME, this.getLinkPSDEFName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEFInputTipSetIdDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETID, this.getPSDEFInputTipSetId());
        }
        if (!bl || this.isPSDEFInputTipSetNameDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETNAME, this.getPSDEFInputTipSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isUniqueTagPSDEFIdDirty()) {
            hashMap.put(FIELD_UNIQUETAGPSDEFID, this.getUniqueTagPSDEFId());
        }
        if (!bl || this.isUniqueTagPSDEFNameDirty()) {
            hashMap.put(FIELD_UNIQUETAGPSDEFNAME, this.getUniqueTagPSDEFName());
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
        return PSDEFInputTipSetBase.get(this, n);
    }

    private static Object get(PSDEFInputTipSetBase pSDEFInputTipSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFInputTipSetBase.getCodeName();
            }
            case 1: {
                return pSDEFInputTipSetBase.getContentPSDEFId();
            }
            case 2: {
                return pSDEFInputTipSetBase.getContentPSDEFName();
            }
            case 3: {
                return pSDEFInputTipSetBase.getCreateDate();
            }
            case 4: {
                return pSDEFInputTipSetBase.getCreateMan();
            }
            case 5: {
                return pSDEFInputTipSetBase.getECPSDEFId();
            }
            case 6: {
                return pSDEFInputTipSetBase.getECPSDEFName();
            }
            case 7: {
                return pSDEFInputTipSetBase.getLinkPSDEFId();
            }
            case 8: {
                return pSDEFInputTipSetBase.getLinkPSDEFName();
            }
            case 9: {
                return pSDEFInputTipSetBase.getLockFlag();
            }
            case 10: {
                return pSDEFInputTipSetBase.getMemo();
            }
            case 11: {
                return pSDEFInputTipSetBase.getPSDEDataSetId();
            }
            case 12: {
                return pSDEFInputTipSetBase.getPSDEDataSetName();
            }
            case 13: {
                return pSDEFInputTipSetBase.getPSDEFInputTipSetId();
            }
            case 14: {
                return pSDEFInputTipSetBase.getPSDEFInputTipSetName();
            }
            case 15: {
                return pSDEFInputTipSetBase.getPSDEId();
            }
            case 16: {
                return pSDEFInputTipSetBase.getPSDEName();
            }
            case 17: {
                return pSDEFInputTipSetBase.getPSModuleId();
            }
            case 18: {
                return pSDEFInputTipSetBase.getPSModuleName();
            }
            case 19: {
                return pSDEFInputTipSetBase.getPSSysPFPluginId();
            }
            case 20: {
                return pSDEFInputTipSetBase.getPSSysPFPluginName();
            }
            case 21: {
                return pSDEFInputTipSetBase.getPSSysSFPluginId();
            }
            case 22: {
                return pSDEFInputTipSetBase.getPSSysSFPluginName();
            }
            case 23: {
                return pSDEFInputTipSetBase.getPSSystemId();
            }
            case 24: {
                return pSDEFInputTipSetBase.getPSSystemName();
            }
            case 25: {
                return pSDEFInputTipSetBase.getUniqueTagPSDEFId();
            }
            case 26: {
                return pSDEFInputTipSetBase.getUniqueTagPSDEFName();
            }
            case 27: {
                return pSDEFInputTipSetBase.getUpdateDate();
            }
            case 28: {
                return pSDEFInputTipSetBase.getUpdateMan();
            }
            case 29: {
                return pSDEFInputTipSetBase.getUserCat();
            }
            case 30: {
                return pSDEFInputTipSetBase.getUserTag();
            }
            case 31: {
                return pSDEFInputTipSetBase.getUserTag2();
            }
            case 32: {
                return pSDEFInputTipSetBase.getUserTag3();
            }
            case 33: {
                return pSDEFInputTipSetBase.getUserTag4();
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
        PSDEFInputTipSetBase.set(this, n, object);
    }

    private static void set(PSDEFInputTipSetBase pSDEFInputTipSetBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFInputTipSetBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEFInputTipSetBase.setContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFInputTipSetBase.setContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFInputTipSetBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEFInputTipSetBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFInputTipSetBase.setECPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFInputTipSetBase.setECPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFInputTipSetBase.setLinkPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFInputTipSetBase.setLinkPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFInputTipSetBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEFInputTipSetBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFInputTipSetBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFInputTipSetBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFInputTipSetBase.setPSDEFInputTipSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFInputTipSetBase.setPSDEFInputTipSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFInputTipSetBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFInputTipSetBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFInputTipSetBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFInputTipSetBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFInputTipSetBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFInputTipSetBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFInputTipSetBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFInputTipSetBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFInputTipSetBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFInputTipSetBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFInputTipSetBase.setUniqueTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFInputTipSetBase.setUniqueTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFInputTipSetBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDEFInputTipSetBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFInputTipSetBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFInputTipSetBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEFInputTipSetBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFInputTipSetBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFInputTipSetBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEFInputTipSetBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFInputTipSetBase pSDEFInputTipSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFInputTipSetBase.getCodeName() == null;
            }
            case 1: {
                return pSDEFInputTipSetBase.getContentPSDEFId() == null;
            }
            case 2: {
                return pSDEFInputTipSetBase.getContentPSDEFName() == null;
            }
            case 3: {
                return pSDEFInputTipSetBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEFInputTipSetBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEFInputTipSetBase.getECPSDEFId() == null;
            }
            case 6: {
                return pSDEFInputTipSetBase.getECPSDEFName() == null;
            }
            case 7: {
                return pSDEFInputTipSetBase.getLinkPSDEFId() == null;
            }
            case 8: {
                return pSDEFInputTipSetBase.getLinkPSDEFName() == null;
            }
            case 9: {
                return pSDEFInputTipSetBase.getLockFlag() == null;
            }
            case 10: {
                return pSDEFInputTipSetBase.getMemo() == null;
            }
            case 11: {
                return pSDEFInputTipSetBase.getPSDEDataSetId() == null;
            }
            case 12: {
                return pSDEFInputTipSetBase.getPSDEDataSetName() == null;
            }
            case 13: {
                return pSDEFInputTipSetBase.getPSDEFInputTipSetId() == null;
            }
            case 14: {
                return pSDEFInputTipSetBase.getPSDEFInputTipSetName() == null;
            }
            case 15: {
                return pSDEFInputTipSetBase.getPSDEId() == null;
            }
            case 16: {
                return pSDEFInputTipSetBase.getPSDEName() == null;
            }
            case 17: {
                return pSDEFInputTipSetBase.getPSModuleId() == null;
            }
            case 18: {
                return pSDEFInputTipSetBase.getPSModuleName() == null;
            }
            case 19: {
                return pSDEFInputTipSetBase.getPSSysPFPluginId() == null;
            }
            case 20: {
                return pSDEFInputTipSetBase.getPSSysPFPluginName() == null;
            }
            case 21: {
                return pSDEFInputTipSetBase.getPSSysSFPluginId() == null;
            }
            case 22: {
                return pSDEFInputTipSetBase.getPSSysSFPluginName() == null;
            }
            case 23: {
                return pSDEFInputTipSetBase.getPSSystemId() == null;
            }
            case 24: {
                return pSDEFInputTipSetBase.getPSSystemName() == null;
            }
            case 25: {
                return pSDEFInputTipSetBase.getUniqueTagPSDEFId() == null;
            }
            case 26: {
                return pSDEFInputTipSetBase.getUniqueTagPSDEFName() == null;
            }
            case 27: {
                return pSDEFInputTipSetBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDEFInputTipSetBase.getUpdateMan() == null;
            }
            case 29: {
                return pSDEFInputTipSetBase.getUserCat() == null;
            }
            case 30: {
                return pSDEFInputTipSetBase.getUserTag() == null;
            }
            case 31: {
                return pSDEFInputTipSetBase.getUserTag2() == null;
            }
            case 32: {
                return pSDEFInputTipSetBase.getUserTag3() == null;
            }
            case 33: {
                return pSDEFInputTipSetBase.getUserTag4() == null;
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
        return PSDEFInputTipSetBase.contains(this, n);
    }

    private static boolean contains(PSDEFInputTipSetBase pSDEFInputTipSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFInputTipSetBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEFInputTipSetBase.isContentPSDEFIdDirty();
            }
            case 2: {
                return pSDEFInputTipSetBase.isContentPSDEFNameDirty();
            }
            case 3: {
                return pSDEFInputTipSetBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEFInputTipSetBase.isCreateManDirty();
            }
            case 5: {
                return pSDEFInputTipSetBase.isECPSDEFIdDirty();
            }
            case 6: {
                return pSDEFInputTipSetBase.isECPSDEFNameDirty();
            }
            case 7: {
                return pSDEFInputTipSetBase.isLinkPSDEFIdDirty();
            }
            case 8: {
                return pSDEFInputTipSetBase.isLinkPSDEFNameDirty();
            }
            case 9: {
                return pSDEFInputTipSetBase.isLockFlagDirty();
            }
            case 10: {
                return pSDEFInputTipSetBase.isMemoDirty();
            }
            case 11: {
                return pSDEFInputTipSetBase.isPSDEDataSetIdDirty();
            }
            case 12: {
                return pSDEFInputTipSetBase.isPSDEDataSetNameDirty();
            }
            case 13: {
                return pSDEFInputTipSetBase.isPSDEFInputTipSetIdDirty();
            }
            case 14: {
                return pSDEFInputTipSetBase.isPSDEFInputTipSetNameDirty();
            }
            case 15: {
                return pSDEFInputTipSetBase.isPSDEIdDirty();
            }
            case 16: {
                return pSDEFInputTipSetBase.isPSDENameDirty();
            }
            case 17: {
                return pSDEFInputTipSetBase.isPSModuleIdDirty();
            }
            case 18: {
                return pSDEFInputTipSetBase.isPSModuleNameDirty();
            }
            case 19: {
                return pSDEFInputTipSetBase.isPSSysPFPluginIdDirty();
            }
            case 20: {
                return pSDEFInputTipSetBase.isPSSysPFPluginNameDirty();
            }
            case 21: {
                return pSDEFInputTipSetBase.isPSSysSFPluginIdDirty();
            }
            case 22: {
                return pSDEFInputTipSetBase.isPSSysSFPluginNameDirty();
            }
            case 23: {
                return pSDEFInputTipSetBase.isPSSystemIdDirty();
            }
            case 24: {
                return pSDEFInputTipSetBase.isPSSystemNameDirty();
            }
            case 25: {
                return pSDEFInputTipSetBase.isUniqueTagPSDEFIdDirty();
            }
            case 26: {
                return pSDEFInputTipSetBase.isUniqueTagPSDEFNameDirty();
            }
            case 27: {
                return pSDEFInputTipSetBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDEFInputTipSetBase.isUpdateManDirty();
            }
            case 29: {
                return pSDEFInputTipSetBase.isUserCatDirty();
            }
            case 30: {
                return pSDEFInputTipSetBase.isUserTagDirty();
            }
            case 31: {
                return pSDEFInputTipSetBase.isUserTag2Dirty();
            }
            case 32: {
                return pSDEFInputTipSetBase.isUserTag3Dirty();
            }
            case 33: {
                return pSDEFInputTipSetBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFInputTipSetBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFInputTipSetBase pSDEFInputTipSetBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFInputTipSetBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getContentPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getContentPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getECPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ecpsdefid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getECPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getECPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ecpsdefname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getECPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getLinkPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdefid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getLinkPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getLinkPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdefname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getLinkPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEFInputTipSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSDEFInputTipSetId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEFInputTipSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSDEFInputTipSetName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUniqueTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetagpsdefid", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUniqueTagPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUniqueTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetagpsdefname", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUniqueTagPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFInputTipSetBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFInputTipSetBase.getJSONValue((Object)pSDEFInputTipSetBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFInputTipSetBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFInputTipSetBase pSDEFInputTipSetBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFInputTipSetBase.getCodeName() != null) {
            object = pSDEFInputTipSetBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFInputTipSetBase.getContentPSDEFId() != null) {
            object = pSDEFInputTipSetBase.getContentPSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFInputTipSetBase.getContentPSDEFName() != null) {
            object = pSDEFInputTipSetBase.getContentPSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getCreateDate() != null) {
            object = pSDEFInputTipSetBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFInputTipSetBase.getCreateMan() != null) {
            object = pSDEFInputTipSetBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getECPSDEFId() != null) {
            object = pSDEFInputTipSetBase.getECPSDEFId();
            xmlNode.setAttribute(FIELD_ECPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getECPSDEFName() != null) {
            object = pSDEFInputTipSetBase.getECPSDEFName();
            xmlNode.setAttribute(FIELD_ECPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getLinkPSDEFId() != null) {
            object = pSDEFInputTipSetBase.getLinkPSDEFId();
            xmlNode.setAttribute(FIELD_LINKPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getLinkPSDEFName() != null) {
            object = pSDEFInputTipSetBase.getLinkPSDEFName();
            xmlNode.setAttribute(FIELD_LINKPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getLockFlag() != null) {
            object = pSDEFInputTipSetBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFInputTipSetBase.getMemo() != null) {
            object = pSDEFInputTipSetBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEDataSetId() != null) {
            object = pSDEFInputTipSetBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEDataSetName() != null) {
            object = pSDEFInputTipSetBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEFInputTipSetId() != null) {
            object = pSDEFInputTipSetBase.getPSDEFInputTipSetId();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEFInputTipSetName() != null) {
            object = pSDEFInputTipSetBase.getPSDEFInputTipSetName();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEId() != null) {
            object = pSDEFInputTipSetBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSDEName() != null) {
            object = pSDEFInputTipSetBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSModuleId() != null) {
            object = pSDEFInputTipSetBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSModuleName() != null) {
            object = pSDEFInputTipSetBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSSysPFPluginId() != null) {
            object = pSDEFInputTipSetBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSSysPFPluginName() != null) {
            object = pSDEFInputTipSetBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSSysSFPluginId() != null) {
            object = pSDEFInputTipSetBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSSysSFPluginName() != null) {
            object = pSDEFInputTipSetBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSSystemId() != null) {
            object = pSDEFInputTipSetBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getPSSystemName() != null) {
            object = pSDEFInputTipSetBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getUniqueTagPSDEFId() != null) {
            object = pSDEFInputTipSetBase.getUniqueTagPSDEFId();
            xmlNode.setAttribute(FIELD_UNIQUETAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getUniqueTagPSDEFName() != null) {
            object = pSDEFInputTipSetBase.getUniqueTagPSDEFName();
            xmlNode.setAttribute(FIELD_UNIQUETAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getUpdateDate() != null) {
            object = pSDEFInputTipSetBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFInputTipSetBase.getUpdateMan() != null) {
            object = pSDEFInputTipSetBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getUserCat() != null) {
            object = pSDEFInputTipSetBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getUserTag() != null) {
            object = pSDEFInputTipSetBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getUserTag2() != null) {
            object = pSDEFInputTipSetBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getUserTag3() != null) {
            object = pSDEFInputTipSetBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipSetBase.getUserTag4() != null) {
            object = pSDEFInputTipSetBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFInputTipSetBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFInputTipSetBase pSDEFInputTipSetBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFInputTipSetBase.isCodeNameDirty() && (bl || pSDEFInputTipSetBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFInputTipSetBase.getCodeName());
        }
        if (pSDEFInputTipSetBase.isContentPSDEFIdDirty() && (bl || pSDEFInputTipSetBase.getContentPSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFID, (Object)pSDEFInputTipSetBase.getContentPSDEFId());
        }
        if (pSDEFInputTipSetBase.isContentPSDEFNameDirty() && (bl || pSDEFInputTipSetBase.getContentPSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFNAME, (Object)pSDEFInputTipSetBase.getContentPSDEFName());
        }
        if (pSDEFInputTipSetBase.isCreateDateDirty() && (bl || pSDEFInputTipSetBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFInputTipSetBase.getCreateDate());
        }
        if (pSDEFInputTipSetBase.isCreateManDirty() && (bl || pSDEFInputTipSetBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFInputTipSetBase.getCreateMan());
        }
        if (pSDEFInputTipSetBase.isECPSDEFIdDirty() && (bl || pSDEFInputTipSetBase.getECPSDEFId() != null)) {
            iDataObject.set(FIELD_ECPSDEFID, (Object)pSDEFInputTipSetBase.getECPSDEFId());
        }
        if (pSDEFInputTipSetBase.isECPSDEFNameDirty() && (bl || pSDEFInputTipSetBase.getECPSDEFName() != null)) {
            iDataObject.set(FIELD_ECPSDEFNAME, (Object)pSDEFInputTipSetBase.getECPSDEFName());
        }
        if (pSDEFInputTipSetBase.isLinkPSDEFIdDirty() && (bl || pSDEFInputTipSetBase.getLinkPSDEFId() != null)) {
            iDataObject.set(FIELD_LINKPSDEFID, (Object)pSDEFInputTipSetBase.getLinkPSDEFId());
        }
        if (pSDEFInputTipSetBase.isLinkPSDEFNameDirty() && (bl || pSDEFInputTipSetBase.getLinkPSDEFName() != null)) {
            iDataObject.set(FIELD_LINKPSDEFNAME, (Object)pSDEFInputTipSetBase.getLinkPSDEFName());
        }
        if (pSDEFInputTipSetBase.isLockFlagDirty() && (bl || pSDEFInputTipSetBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEFInputTipSetBase.getLockFlag());
        }
        if (pSDEFInputTipSetBase.isMemoDirty() && (bl || pSDEFInputTipSetBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFInputTipSetBase.getMemo());
        }
        if (pSDEFInputTipSetBase.isPSDEDataSetIdDirty() && (bl || pSDEFInputTipSetBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEFInputTipSetBase.getPSDEDataSetId());
        }
        if (pSDEFInputTipSetBase.isPSDEDataSetNameDirty() && (bl || pSDEFInputTipSetBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEFInputTipSetBase.getPSDEDataSetName());
        }
        if (pSDEFInputTipSetBase.isPSDEFInputTipSetIdDirty() && (bl || pSDEFInputTipSetBase.getPSDEFInputTipSetId() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETID, (Object)pSDEFInputTipSetBase.getPSDEFInputTipSetId());
        }
        if (pSDEFInputTipSetBase.isPSDEFInputTipSetNameDirty() && (bl || pSDEFInputTipSetBase.getPSDEFInputTipSetName() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETNAME, (Object)pSDEFInputTipSetBase.getPSDEFInputTipSetName());
        }
        if (pSDEFInputTipSetBase.isPSDEIdDirty() && (bl || pSDEFInputTipSetBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFInputTipSetBase.getPSDEId());
        }
        if (pSDEFInputTipSetBase.isPSDENameDirty() && (bl || pSDEFInputTipSetBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFInputTipSetBase.getPSDEName());
        }
        if (pSDEFInputTipSetBase.isPSModuleIdDirty() && (bl || pSDEFInputTipSetBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDEFInputTipSetBase.getPSModuleId());
        }
        if (pSDEFInputTipSetBase.isPSModuleNameDirty() && (bl || pSDEFInputTipSetBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEFInputTipSetBase.getPSModuleName());
        }
        if (pSDEFInputTipSetBase.isPSSysPFPluginIdDirty() && (bl || pSDEFInputTipSetBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEFInputTipSetBase.getPSSysPFPluginId());
        }
        if (pSDEFInputTipSetBase.isPSSysPFPluginNameDirty() && (bl || pSDEFInputTipSetBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEFInputTipSetBase.getPSSysPFPluginName());
        }
        if (pSDEFInputTipSetBase.isPSSysSFPluginIdDirty() && (bl || pSDEFInputTipSetBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEFInputTipSetBase.getPSSysSFPluginId());
        }
        if (pSDEFInputTipSetBase.isPSSysSFPluginNameDirty() && (bl || pSDEFInputTipSetBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEFInputTipSetBase.getPSSysSFPluginName());
        }
        if (pSDEFInputTipSetBase.isPSSystemIdDirty() && (bl || pSDEFInputTipSetBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEFInputTipSetBase.getPSSystemId());
        }
        if (pSDEFInputTipSetBase.isPSSystemNameDirty() && (bl || pSDEFInputTipSetBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEFInputTipSetBase.getPSSystemName());
        }
        if (pSDEFInputTipSetBase.isUniqueTagPSDEFIdDirty() && (bl || pSDEFInputTipSetBase.getUniqueTagPSDEFId() != null)) {
            iDataObject.set(FIELD_UNIQUETAGPSDEFID, (Object)pSDEFInputTipSetBase.getUniqueTagPSDEFId());
        }
        if (pSDEFInputTipSetBase.isUniqueTagPSDEFNameDirty() && (bl || pSDEFInputTipSetBase.getUniqueTagPSDEFName() != null)) {
            iDataObject.set(FIELD_UNIQUETAGPSDEFNAME, (Object)pSDEFInputTipSetBase.getUniqueTagPSDEFName());
        }
        if (pSDEFInputTipSetBase.isUpdateDateDirty() && (bl || pSDEFInputTipSetBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFInputTipSetBase.getUpdateDate());
        }
        if (pSDEFInputTipSetBase.isUpdateManDirty() && (bl || pSDEFInputTipSetBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFInputTipSetBase.getUpdateMan());
        }
        if (pSDEFInputTipSetBase.isUserCatDirty() && (bl || pSDEFInputTipSetBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFInputTipSetBase.getUserCat());
        }
        if (pSDEFInputTipSetBase.isUserTagDirty() && (bl || pSDEFInputTipSetBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFInputTipSetBase.getUserTag());
        }
        if (pSDEFInputTipSetBase.isUserTag2Dirty() && (bl || pSDEFInputTipSetBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFInputTipSetBase.getUserTag2());
        }
        if (pSDEFInputTipSetBase.isUserTag3Dirty() && (bl || pSDEFInputTipSetBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFInputTipSetBase.getUserTag3());
        }
        if (pSDEFInputTipSetBase.isUserTag4Dirty() && (bl || pSDEFInputTipSetBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFInputTipSetBase.getUserTag4());
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
        return PSDEFInputTipSetBase.remove(this, n);
    }

    private static boolean remove(PSDEFInputTipSetBase pSDEFInputTipSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFInputTipSetBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEFInputTipSetBase.resetContentPSDEFId();
                return true;
            }
            case 2: {
                pSDEFInputTipSetBase.resetContentPSDEFName();
                return true;
            }
            case 3: {
                pSDEFInputTipSetBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEFInputTipSetBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEFInputTipSetBase.resetECPSDEFId();
                return true;
            }
            case 6: {
                pSDEFInputTipSetBase.resetECPSDEFName();
                return true;
            }
            case 7: {
                pSDEFInputTipSetBase.resetLinkPSDEFId();
                return true;
            }
            case 8: {
                pSDEFInputTipSetBase.resetLinkPSDEFName();
                return true;
            }
            case 9: {
                pSDEFInputTipSetBase.resetLockFlag();
                return true;
            }
            case 10: {
                pSDEFInputTipSetBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEFInputTipSetBase.resetPSDEDataSetId();
                return true;
            }
            case 12: {
                pSDEFInputTipSetBase.resetPSDEDataSetName();
                return true;
            }
            case 13: {
                pSDEFInputTipSetBase.resetPSDEFInputTipSetId();
                return true;
            }
            case 14: {
                pSDEFInputTipSetBase.resetPSDEFInputTipSetName();
                return true;
            }
            case 15: {
                pSDEFInputTipSetBase.resetPSDEId();
                return true;
            }
            case 16: {
                pSDEFInputTipSetBase.resetPSDEName();
                return true;
            }
            case 17: {
                pSDEFInputTipSetBase.resetPSModuleId();
                return true;
            }
            case 18: {
                pSDEFInputTipSetBase.resetPSModuleName();
                return true;
            }
            case 19: {
                pSDEFInputTipSetBase.resetPSSysPFPluginId();
                return true;
            }
            case 20: {
                pSDEFInputTipSetBase.resetPSSysPFPluginName();
                return true;
            }
            case 21: {
                pSDEFInputTipSetBase.resetPSSysSFPluginId();
                return true;
            }
            case 22: {
                pSDEFInputTipSetBase.resetPSSysSFPluginName();
                return true;
            }
            case 23: {
                pSDEFInputTipSetBase.resetPSSystemId();
                return true;
            }
            case 24: {
                pSDEFInputTipSetBase.resetPSSystemName();
                return true;
            }
            case 25: {
                pSDEFInputTipSetBase.resetUniqueTagPSDEFId();
                return true;
            }
            case 26: {
                pSDEFInputTipSetBase.resetUniqueTagPSDEFName();
                return true;
            }
            case 27: {
                pSDEFInputTipSetBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDEFInputTipSetBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSDEFInputTipSetBase.resetUserCat();
                return true;
            }
            case 30: {
                pSDEFInputTipSetBase.resetUserTag();
                return true;
            }
            case 31: {
                pSDEFInputTipSetBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSDEFInputTipSetBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSDEFInputTipSetBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEF();
        }
        if (this.getContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objContentPSDEFLock;
        synchronized (n) {
            if (this.contentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSDEFId(), (Object)this.contentpsdef.getPSDEFieldId()) != 0L) {
                this.contentpsdef = null;
            }
            if (this.contentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.contentpsdef = pSDEField;
            }
            return this.contentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getECPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getECPSDEF();
        }
        if (this.getECPSDEFId() == null) {
            return null;
        }
        Integer n = this.objECPSDEFLock;
        synchronized (n) {
            if (this.ecpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getECPSDEFId(), (Object)this.ecpsdef.getPSDEFieldId()) != 0L) {
                this.ecpsdef = null;
            }
            if (this.ecpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getECPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.ecpsdef = pSDEField;
            }
            return this.ecpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getLinkPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEF();
        }
        if (this.getLinkPSDEFId() == null) {
            return null;
        }
        Integer n = this.objLinkPSDEFLock;
        synchronized (n) {
            if (this.linkpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getLinkPSDEFId(), (Object)this.linkpsdef.getPSDEFieldId()) != 0L) {
                this.linkpsdef = null;
            }
            if (this.linkpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getLinkPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.linkpsdef = pSDEField;
            }
            return this.linkpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUniqueTagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTagPSDEF();
        }
        if (this.getUniqueTagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objUniqueTagPSDEFLock;
        synchronized (n) {
            if (this.uniquetagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getUniqueTagPSDEFId(), (Object)this.uniquetagpsdef.getPSDEFieldId()) != 0L) {
                this.uniquetagpsdef = null;
            }
            if (this.uniquetagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUniqueTagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.uniquetagpsdef = pSDEField;
            }
            return this.uniquetagpsdef;
        }
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
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
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

    private PSDEFInputTipSetBase getProxyEntity() {
        return this.proxyPSDEFInputTipSetBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFInputTipSetBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFInputTipSetBase) {
            this.proxyPSDEFInputTipSetBase = (PSDEFInputTipSetBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CONTENTPSDEFID, 1);
        fieldIndexMap.put(FIELD_CONTENTPSDEFNAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_ECPSDEFID, 5);
        fieldIndexMap.put(FIELD_ECPSDEFNAME, 6);
        fieldIndexMap.put(FIELD_LINKPSDEFID, 7);
        fieldIndexMap.put(FIELD_LINKPSDEFNAME, 8);
        fieldIndexMap.put(FIELD_LOCKFLAG, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 11);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 12);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETID, 13);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETNAME, 14);
        fieldIndexMap.put(FIELD_PSDEID, 15);
        fieldIndexMap.put(FIELD_PSDENAME, 16);
        fieldIndexMap.put(FIELD_PSMODULEID, 17);
        fieldIndexMap.put(FIELD_PSMODULENAME, 18);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 21);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 23);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 24);
        fieldIndexMap.put(FIELD_UNIQUETAGPSDEFID, 25);
        fieldIndexMap.put(FIELD_UNIQUETAGPSDEFNAME, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
    }
}

