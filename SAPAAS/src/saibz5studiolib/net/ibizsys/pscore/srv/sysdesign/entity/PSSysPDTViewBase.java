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
import net.ibizsys.pscore.srv.config.entity.PSPDTView;
import net.ibizsys.pscore.srv.config.service.PSPDTViewService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPDTViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysPDTViewBase.class);
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FROMDEVIEWFLAG = "FROMDEVIEWFLAG";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBPSDEVIEWID = "MOBPSDEVIEWID";
    public static final String FIELD_MOBPSDEVIEWNAME = "MOBPSDEVIEWNAME";
    public static final String FIELD_MOBVIEWCODENAME = "MOBVIEWCODENAME";
    public static final String FIELD_MOBVIEWPSDEID = "MOBVIEWPSDEID";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSPDTVIEWID = "PSPDTVIEWID";
    public static final String FIELD_PSPDTVIEWNAME = "PSPDTVIEWNAME";
    public static final String FIELD_PSSYSPDTVIEWID = "PSSYSPDTVIEWID";
    public static final String FIELD_PSSYSPDTVIEWNAME = "PSSYSPDTVIEWNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWCODENAME = "VIEWCODENAME";
    public static final String FIELD_VIEWPSDEID = "VIEWPSDEID";
    private static final int INDEX_CAPPSLANRESID = 0;
    private static final int INDEX_CAPPSLANRESNAME = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_FROMDEVIEWFLAG = 5;
    private static final int INDEX_LOCKFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_MOBPSDEVIEWID = 8;
    private static final int INDEX_MOBPSDEVIEWNAME = 9;
    private static final int INDEX_MOBVIEWCODENAME = 10;
    private static final int INDEX_MOBVIEWPSDEID = 11;
    private static final int INDEX_PSDEVIEWBASEID = 12;
    private static final int INDEX_PSDEVIEWBASENAME = 13;
    private static final int INDEX_PSMODULEID = 14;
    private static final int INDEX_PSMODULENAME = 15;
    private static final int INDEX_PSPDTVIEWID = 16;
    private static final int INDEX_PSPDTVIEWNAME = 17;
    private static final int INDEX_PSSYSPDTVIEWID = 18;
    private static final int INDEX_PSSYSPDTVIEWNAME = 19;
    private static final int INDEX_PSSYSTEMID = 20;
    private static final int INDEX_PSSYSTEMNAME = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USERCAT = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_USERTAG3 = 27;
    private static final int INDEX_USERTAG4 = 28;
    private static final int INDEX_VIEWCODENAME = 29;
    private static final int INDEX_VIEWPSDEID = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysPDTViewBase proxyPSSysPDTViewBase = null;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fromdeviewflagDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobpsdeviewidDirtyFlag = false;
    private boolean mobpsdeviewnameDirtyFlag = false;
    private boolean mobviewcodenameDirtyFlag = false;
    private boolean mobviewpsdeidDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pspdtviewidDirtyFlag = false;
    private boolean pspdtviewnameDirtyFlag = false;
    private boolean pssyspdtviewidDirtyFlag = false;
    private boolean pssyspdtviewnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewcodenameDirtyFlag = false;
    private boolean viewpsdeidDirtyFlag = false;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fromdeviewflag")
    private Integer fromdeviewflag;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="mobpsdeviewid")
    private String mobpsdeviewid;
    @Column(name="mobpsdeviewname")
    private String mobpsdeviewname;
    @Column(name="mobviewcodename")
    private String mobviewcodename;
    @Column(name="mobviewpsdeid")
    private String mobviewpsdeid;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pspdtviewid")
    private String pspdtviewid;
    @Column(name="pspdtviewname")
    private String pspdtviewname;
    @Column(name="pssyspdtviewid")
    private String pssyspdtviewid;
    @Column(name="pssyspdtviewname")
    private String pssyspdtviewname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
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
    @Column(name="viewcodename")
    private String viewcodename;
    @Column(name="viewpsdeid")
    private String viewpsdeid;
    private Integer objMobPSDEViewLock = new Integer(1);
    private PSDEViewBase mobpsdeview = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSPDTViewLock = new Integer(1);
    private PSPDTView pspdtview = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
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

    public void setFromDEViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromDEViewFlag(n);
            return;
        }
        this.fromdeviewflag = n;
        this.fromdeviewflagDirtyFlag = true;
    }

    public Integer getFromDEViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromDEViewFlag();
        }
        return this.fromdeviewflag;
    }

    public boolean isFromDEViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromDEViewFlagDirty();
        }
        return this.fromdeviewflagDirtyFlag;
    }

    public void resetFromDEViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromDEViewFlag();
            return;
        }
        this.fromdeviewflagDirtyFlag = false;
        this.fromdeviewflag = null;
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

    public void setMobPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeviewid = string;
        this.mobpsdeviewidDirtyFlag = true;
    }

    public String getMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEViewId();
        }
        return this.mobpsdeviewid;
    }

    public boolean isMobPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEViewIdDirty();
        }
        return this.mobpsdeviewidDirtyFlag;
    }

    public void resetMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEViewId();
            return;
        }
        this.mobpsdeviewidDirtyFlag = false;
        this.mobpsdeviewid = null;
    }

    public void setMobPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeviewname = string;
        this.mobpsdeviewnameDirtyFlag = true;
    }

    public String getMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEViewName();
        }
        return this.mobpsdeviewname;
    }

    public boolean isMobPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEViewNameDirty();
        }
        return this.mobpsdeviewnameDirtyFlag;
    }

    public void resetMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEViewName();
            return;
        }
        this.mobpsdeviewnameDirtyFlag = false;
        this.mobpsdeviewname = null;
    }

    public void setMobViewCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobViewCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobviewcodename = string;
        this.mobviewcodenameDirtyFlag = true;
    }

    public String getMobViewCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobViewCodeName();
        }
        return this.mobviewcodename;
    }

    public boolean isMobViewCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobViewCodeNameDirty();
        }
        return this.mobviewcodenameDirtyFlag;
    }

    public void resetMobViewCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobViewCodeName();
            return;
        }
        this.mobviewcodenameDirtyFlag = false;
        this.mobviewcodename = null;
    }

    public void setMobViewPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobViewPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobviewpsdeid = string;
        this.mobviewpsdeidDirtyFlag = true;
    }

    public String getMobViewPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobViewPSDEId();
        }
        return this.mobviewpsdeid;
    }

    public boolean isMobViewPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobViewPSDEIdDirty();
        }
        return this.mobviewpsdeidDirtyFlag;
    }

    public void resetMobViewPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobViewPSDEId();
            return;
        }
        this.mobviewpsdeidDirtyFlag = false;
        this.mobviewpsdeid = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
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

    public void setPSPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspdtviewid = string;
        this.pspdtviewidDirtyFlag = true;
    }

    public String getPSPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTViewId();
        }
        return this.pspdtviewid;
    }

    public boolean isPSPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPDTViewIdDirty();
        }
        return this.pspdtviewidDirtyFlag;
    }

    public void resetPSPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPDTViewId();
            return;
        }
        this.pspdtviewidDirtyFlag = false;
        this.pspdtviewid = null;
    }

    public void setPSPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspdtviewname = string;
        this.pspdtviewnameDirtyFlag = true;
    }

    public String getPSPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTViewName();
        }
        return this.pspdtviewname;
    }

    public boolean isPSPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPDTViewNameDirty();
        }
        return this.pspdtviewnameDirtyFlag;
    }

    public void resetPSPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPDTViewName();
            return;
        }
        this.pspdtviewnameDirtyFlag = false;
        this.pspdtviewname = null;
    }

    public void setPSSysPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspdtviewid = string;
        this.pssyspdtviewidDirtyFlag = true;
    }

    public String getPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViewId();
        }
        return this.pssyspdtviewid;
    }

    public boolean isPSSysPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPDTViewIdDirty();
        }
        return this.pssyspdtviewidDirtyFlag;
    }

    public void resetPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPDTViewId();
            return;
        }
        this.pssyspdtviewidDirtyFlag = false;
        this.pssyspdtviewid = null;
    }

    public void setPSSysPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspdtviewname = string;
        this.pssyspdtviewnameDirtyFlag = true;
    }

    public String getPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViewName();
        }
        return this.pssyspdtviewname;
    }

    public boolean isPSSysPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPDTViewNameDirty();
        }
        return this.pssyspdtviewnameDirtyFlag;
    }

    public void resetPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPDTViewName();
            return;
        }
        this.pssyspdtviewnameDirtyFlag = false;
        this.pssyspdtviewname = null;
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

    public void setViewCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewcodename = string;
        this.viewcodenameDirtyFlag = true;
    }

    public String getViewCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewCodeName();
        }
        return this.viewcodename;
    }

    public boolean isViewCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewCodeNameDirty();
        }
        return this.viewcodenameDirtyFlag;
    }

    public void resetViewCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewCodeName();
            return;
        }
        this.viewcodenameDirtyFlag = false;
        this.viewcodename = null;
    }

    public void setViewPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewpsdeid = string;
        this.viewpsdeidDirtyFlag = true;
    }

    public String getViewPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewPSDEId();
        }
        return this.viewpsdeid;
    }

    public boolean isViewPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewPSDEIdDirty();
        }
        return this.viewpsdeidDirtyFlag;
    }

    public void resetViewPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewPSDEId();
            return;
        }
        this.viewpsdeidDirtyFlag = false;
        this.viewpsdeid = null;
    }

    protected void onReset() {
        PSSysPDTViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysPDTViewBase pSSysPDTViewBase) {
        pSSysPDTViewBase.resetCapPSLanResId();
        pSSysPDTViewBase.resetCapPSLanResName();
        pSSysPDTViewBase.resetCodeName();
        pSSysPDTViewBase.resetCreateDate();
        pSSysPDTViewBase.resetCreateMan();
        pSSysPDTViewBase.resetFromDEViewFlag();
        pSSysPDTViewBase.resetLockFlag();
        pSSysPDTViewBase.resetMemo();
        pSSysPDTViewBase.resetMobPSDEViewId();
        pSSysPDTViewBase.resetMobPSDEViewName();
        pSSysPDTViewBase.resetMobViewCodeName();
        pSSysPDTViewBase.resetMobViewPSDEId();
        pSSysPDTViewBase.resetPSDEViewBaseId();
        pSSysPDTViewBase.resetPSDEViewBaseName();
        pSSysPDTViewBase.resetPSModuleId();
        pSSysPDTViewBase.resetPSModuleName();
        pSSysPDTViewBase.resetPSPDTViewId();
        pSSysPDTViewBase.resetPSPDTViewName();
        pSSysPDTViewBase.resetPSSysPDTViewId();
        pSSysPDTViewBase.resetPSSysPDTViewName();
        pSSysPDTViewBase.resetPSSystemId();
        pSSysPDTViewBase.resetPSSystemName();
        pSSysPDTViewBase.resetUpdateDate();
        pSSysPDTViewBase.resetUpdateMan();
        pSSysPDTViewBase.resetUserCat();
        pSSysPDTViewBase.resetUserTag();
        pSSysPDTViewBase.resetUserTag2();
        pSSysPDTViewBase.resetUserTag3();
        pSSysPDTViewBase.resetUserTag4();
        pSSysPDTViewBase.resetViewCodeName();
        pSSysPDTViewBase.resetViewPSDEId();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
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
        if (!bl || this.isFromDEViewFlagDirty()) {
            hashMap.put(FIELD_FROMDEVIEWFLAG, this.getFromDEViewFlag());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobPSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBPSDEVIEWID, this.getMobPSDEViewId());
        }
        if (!bl || this.isMobPSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBPSDEVIEWNAME, this.getMobPSDEViewName());
        }
        if (!bl || this.isMobViewCodeNameDirty()) {
            hashMap.put(FIELD_MOBVIEWCODENAME, this.getMobViewCodeName());
        }
        if (!bl || this.isMobViewPSDEIdDirty()) {
            hashMap.put(FIELD_MOBVIEWPSDEID, this.getMobViewPSDEId());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSPDTViewIdDirty()) {
            hashMap.put(FIELD_PSPDTVIEWID, this.getPSPDTViewId());
        }
        if (!bl || this.isPSPDTViewNameDirty()) {
            hashMap.put(FIELD_PSPDTVIEWNAME, this.getPSPDTViewName());
        }
        if (!bl || this.isPSSysPDTViewIdDirty()) {
            hashMap.put(FIELD_PSSYSPDTVIEWID, this.getPSSysPDTViewId());
        }
        if (!bl || this.isPSSysPDTViewNameDirty()) {
            hashMap.put(FIELD_PSSYSPDTVIEWNAME, this.getPSSysPDTViewName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        if (!bl || this.isViewCodeNameDirty()) {
            hashMap.put(FIELD_VIEWCODENAME, this.getViewCodeName());
        }
        if (!bl || this.isViewPSDEIdDirty()) {
            hashMap.put(FIELD_VIEWPSDEID, this.getViewPSDEId());
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
        return PSSysPDTViewBase.get(this, n);
    }

    private static Object get(PSSysPDTViewBase pSSysPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPDTViewBase.getCapPSLanResId();
            }
            case 1: {
                return pSSysPDTViewBase.getCapPSLanResName();
            }
            case 2: {
                return pSSysPDTViewBase.getCodeName();
            }
            case 3: {
                return pSSysPDTViewBase.getCreateDate();
            }
            case 4: {
                return pSSysPDTViewBase.getCreateMan();
            }
            case 5: {
                return pSSysPDTViewBase.getFromDEViewFlag();
            }
            case 6: {
                return pSSysPDTViewBase.getLockFlag();
            }
            case 7: {
                return pSSysPDTViewBase.getMemo();
            }
            case 8: {
                return pSSysPDTViewBase.getMobPSDEViewId();
            }
            case 9: {
                return pSSysPDTViewBase.getMobPSDEViewName();
            }
            case 10: {
                return pSSysPDTViewBase.getMobViewCodeName();
            }
            case 11: {
                return pSSysPDTViewBase.getMobViewPSDEId();
            }
            case 12: {
                return pSSysPDTViewBase.getPSDEViewBaseId();
            }
            case 13: {
                return pSSysPDTViewBase.getPSDEViewBaseName();
            }
            case 14: {
                return pSSysPDTViewBase.getPSModuleId();
            }
            case 15: {
                return pSSysPDTViewBase.getPSModuleName();
            }
            case 16: {
                return pSSysPDTViewBase.getPSPDTViewId();
            }
            case 17: {
                return pSSysPDTViewBase.getPSPDTViewName();
            }
            case 18: {
                return pSSysPDTViewBase.getPSSysPDTViewId();
            }
            case 19: {
                return pSSysPDTViewBase.getPSSysPDTViewName();
            }
            case 20: {
                return pSSysPDTViewBase.getPSSystemId();
            }
            case 21: {
                return pSSysPDTViewBase.getPSSystemName();
            }
            case 22: {
                return pSSysPDTViewBase.getUpdateDate();
            }
            case 23: {
                return pSSysPDTViewBase.getUpdateMan();
            }
            case 24: {
                return pSSysPDTViewBase.getUserCat();
            }
            case 25: {
                return pSSysPDTViewBase.getUserTag();
            }
            case 26: {
                return pSSysPDTViewBase.getUserTag2();
            }
            case 27: {
                return pSSysPDTViewBase.getUserTag3();
            }
            case 28: {
                return pSSysPDTViewBase.getUserTag4();
            }
            case 29: {
                return pSSysPDTViewBase.getViewCodeName();
            }
            case 30: {
                return pSSysPDTViewBase.getViewPSDEId();
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
        PSSysPDTViewBase.set(this, n, object);
    }

    private static void set(PSSysPDTViewBase pSSysPDTViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysPDTViewBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysPDTViewBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysPDTViewBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysPDTViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysPDTViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysPDTViewBase.setFromDEViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysPDTViewBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysPDTViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysPDTViewBase.setMobPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysPDTViewBase.setMobPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysPDTViewBase.setMobViewCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysPDTViewBase.setMobViewPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysPDTViewBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysPDTViewBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysPDTViewBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysPDTViewBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysPDTViewBase.setPSPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysPDTViewBase.setPSPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysPDTViewBase.setPSSysPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysPDTViewBase.setPSSysPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysPDTViewBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysPDTViewBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysPDTViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSSysPDTViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysPDTViewBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysPDTViewBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysPDTViewBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysPDTViewBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysPDTViewBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysPDTViewBase.setViewCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysPDTViewBase.setViewPSDEId(DataObject.getStringValue((Object)object));
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
        return PSSysPDTViewBase.isNull(this, n);
    }

    private static boolean isNull(PSSysPDTViewBase pSSysPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPDTViewBase.getCapPSLanResId() == null;
            }
            case 1: {
                return pSSysPDTViewBase.getCapPSLanResName() == null;
            }
            case 2: {
                return pSSysPDTViewBase.getCodeName() == null;
            }
            case 3: {
                return pSSysPDTViewBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysPDTViewBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysPDTViewBase.getFromDEViewFlag() == null;
            }
            case 6: {
                return pSSysPDTViewBase.getLockFlag() == null;
            }
            case 7: {
                return pSSysPDTViewBase.getMemo() == null;
            }
            case 8: {
                return pSSysPDTViewBase.getMobPSDEViewId() == null;
            }
            case 9: {
                return pSSysPDTViewBase.getMobPSDEViewName() == null;
            }
            case 10: {
                return pSSysPDTViewBase.getMobViewCodeName() == null;
            }
            case 11: {
                return pSSysPDTViewBase.getMobViewPSDEId() == null;
            }
            case 12: {
                return pSSysPDTViewBase.getPSDEViewBaseId() == null;
            }
            case 13: {
                return pSSysPDTViewBase.getPSDEViewBaseName() == null;
            }
            case 14: {
                return pSSysPDTViewBase.getPSModuleId() == null;
            }
            case 15: {
                return pSSysPDTViewBase.getPSModuleName() == null;
            }
            case 16: {
                return pSSysPDTViewBase.getPSPDTViewId() == null;
            }
            case 17: {
                return pSSysPDTViewBase.getPSPDTViewName() == null;
            }
            case 18: {
                return pSSysPDTViewBase.getPSSysPDTViewId() == null;
            }
            case 19: {
                return pSSysPDTViewBase.getPSSysPDTViewName() == null;
            }
            case 20: {
                return pSSysPDTViewBase.getPSSystemId() == null;
            }
            case 21: {
                return pSSysPDTViewBase.getPSSystemName() == null;
            }
            case 22: {
                return pSSysPDTViewBase.getUpdateDate() == null;
            }
            case 23: {
                return pSSysPDTViewBase.getUpdateMan() == null;
            }
            case 24: {
                return pSSysPDTViewBase.getUserCat() == null;
            }
            case 25: {
                return pSSysPDTViewBase.getUserTag() == null;
            }
            case 26: {
                return pSSysPDTViewBase.getUserTag2() == null;
            }
            case 27: {
                return pSSysPDTViewBase.getUserTag3() == null;
            }
            case 28: {
                return pSSysPDTViewBase.getUserTag4() == null;
            }
            case 29: {
                return pSSysPDTViewBase.getViewCodeName() == null;
            }
            case 30: {
                return pSSysPDTViewBase.getViewPSDEId() == null;
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
        return PSSysPDTViewBase.contains(this, n);
    }

    private static boolean contains(PSSysPDTViewBase pSSysPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPDTViewBase.isCapPSLanResIdDirty();
            }
            case 1: {
                return pSSysPDTViewBase.isCapPSLanResNameDirty();
            }
            case 2: {
                return pSSysPDTViewBase.isCodeNameDirty();
            }
            case 3: {
                return pSSysPDTViewBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysPDTViewBase.isCreateManDirty();
            }
            case 5: {
                return pSSysPDTViewBase.isFromDEViewFlagDirty();
            }
            case 6: {
                return pSSysPDTViewBase.isLockFlagDirty();
            }
            case 7: {
                return pSSysPDTViewBase.isMemoDirty();
            }
            case 8: {
                return pSSysPDTViewBase.isMobPSDEViewIdDirty();
            }
            case 9: {
                return pSSysPDTViewBase.isMobPSDEViewNameDirty();
            }
            case 10: {
                return pSSysPDTViewBase.isMobViewCodeNameDirty();
            }
            case 11: {
                return pSSysPDTViewBase.isMobViewPSDEIdDirty();
            }
            case 12: {
                return pSSysPDTViewBase.isPSDEViewBaseIdDirty();
            }
            case 13: {
                return pSSysPDTViewBase.isPSDEViewBaseNameDirty();
            }
            case 14: {
                return pSSysPDTViewBase.isPSModuleIdDirty();
            }
            case 15: {
                return pSSysPDTViewBase.isPSModuleNameDirty();
            }
            case 16: {
                return pSSysPDTViewBase.isPSPDTViewIdDirty();
            }
            case 17: {
                return pSSysPDTViewBase.isPSPDTViewNameDirty();
            }
            case 18: {
                return pSSysPDTViewBase.isPSSysPDTViewIdDirty();
            }
            case 19: {
                return pSSysPDTViewBase.isPSSysPDTViewNameDirty();
            }
            case 20: {
                return pSSysPDTViewBase.isPSSystemIdDirty();
            }
            case 21: {
                return pSSysPDTViewBase.isPSSystemNameDirty();
            }
            case 22: {
                return pSSysPDTViewBase.isUpdateDateDirty();
            }
            case 23: {
                return pSSysPDTViewBase.isUpdateManDirty();
            }
            case 24: {
                return pSSysPDTViewBase.isUserCatDirty();
            }
            case 25: {
                return pSSysPDTViewBase.isUserTagDirty();
            }
            case 26: {
                return pSSysPDTViewBase.isUserTag2Dirty();
            }
            case 27: {
                return pSSysPDTViewBase.isUserTag3Dirty();
            }
            case 28: {
                return pSSysPDTViewBase.isUserTag4Dirty();
            }
            case 29: {
                return pSSysPDTViewBase.isViewCodeNameDirty();
            }
            case 30: {
                return pSSysPDTViewBase.isViewPSDEIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysPDTViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysPDTViewBase pSSysPDTViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysPDTViewBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getFromDEViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromdeviewflag", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getFromDEViewFlag()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getMobPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeviewid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getMobPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getMobPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeviewname", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getMobPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getMobViewCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobviewcodename", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getMobViewCodeName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getMobViewPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobviewpsdeid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getMobViewPSDEId()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtviewid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSPDTViewId()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtviewname", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSPDTViewName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSSysPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSSysPDTViewId()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSSysPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspdtviewname", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSSysPDTViewName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getViewCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewcodename", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getViewCodeName()), (boolean)false);
        }
        if (bl || pSSysPDTViewBase.getViewPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewpsdeid", (Object)PSSysPDTViewBase.getJSONValue((Object)pSSysPDTViewBase.getViewPSDEId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysPDTViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysPDTViewBase pSSysPDTViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysPDTViewBase.getCapPSLanResId() != null) {
            object = pSSysPDTViewBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysPDTViewBase.getCapPSLanResName() != null) {
            object = pSSysPDTViewBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysPDTViewBase.getCodeName() != null) {
            object = pSSysPDTViewBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getCreateDate() != null) {
            object = pSSysPDTViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPDTViewBase.getCreateMan() != null) {
            object = pSSysPDTViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getFromDEViewFlag() != null) {
            object = pSSysPDTViewBase.getFromDEViewFlag();
            xmlNode.setAttribute(FIELD_FROMDEVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPDTViewBase.getLockFlag() != null) {
            object = pSSysPDTViewBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPDTViewBase.getMemo() != null) {
            object = pSSysPDTViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getMobPSDEViewId() != null) {
            object = pSSysPDTViewBase.getMobPSDEViewId();
            xmlNode.setAttribute(FIELD_MOBPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getMobPSDEViewName() != null) {
            object = pSSysPDTViewBase.getMobPSDEViewName();
            xmlNode.setAttribute(FIELD_MOBPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getMobViewCodeName() != null) {
            object = pSSysPDTViewBase.getMobViewCodeName();
            xmlNode.setAttribute(FIELD_MOBVIEWCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getMobViewPSDEId() != null) {
            object = pSSysPDTViewBase.getMobViewPSDEId();
            xmlNode.setAttribute(FIELD_MOBVIEWPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSDEViewBaseId() != null) {
            object = pSSysPDTViewBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSDEViewBaseName() != null) {
            object = pSSysPDTViewBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSModuleId() != null) {
            object = pSSysPDTViewBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSModuleName() != null) {
            object = pSSysPDTViewBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSPDTViewId() != null) {
            object = pSSysPDTViewBase.getPSPDTViewId();
            xmlNode.setAttribute(FIELD_PSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSPDTViewName() != null) {
            object = pSSysPDTViewBase.getPSPDTViewName();
            xmlNode.setAttribute(FIELD_PSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSSysPDTViewId() != null) {
            object = pSSysPDTViewBase.getPSSysPDTViewId();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSSysPDTViewName() != null) {
            object = pSSysPDTViewBase.getPSSysPDTViewName();
            xmlNode.setAttribute(FIELD_PSSYSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSSystemId() != null) {
            object = pSSysPDTViewBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getPSSystemName() != null) {
            object = pSSysPDTViewBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getUpdateDate() != null) {
            object = pSSysPDTViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPDTViewBase.getUpdateMan() != null) {
            object = pSSysPDTViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getUserCat() != null) {
            object = pSSysPDTViewBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getUserTag() != null) {
            object = pSSysPDTViewBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getUserTag2() != null) {
            object = pSSysPDTViewBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getUserTag3() != null) {
            object = pSSysPDTViewBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getUserTag4() != null) {
            object = pSSysPDTViewBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getViewCodeName() != null) {
            object = pSSysPDTViewBase.getViewCodeName();
            xmlNode.setAttribute(FIELD_VIEWCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPDTViewBase.getViewPSDEId() != null) {
            object = pSSysPDTViewBase.getViewPSDEId();
            xmlNode.setAttribute(FIELD_VIEWPSDEID, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysPDTViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysPDTViewBase pSSysPDTViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysPDTViewBase.isCapPSLanResIdDirty() && (bl || pSSysPDTViewBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSSysPDTViewBase.getCapPSLanResId());
        }
        if (pSSysPDTViewBase.isCapPSLanResNameDirty() && (bl || pSSysPDTViewBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSSysPDTViewBase.getCapPSLanResName());
        }
        if (pSSysPDTViewBase.isCodeNameDirty() && (bl || pSSysPDTViewBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysPDTViewBase.getCodeName());
        }
        if (pSSysPDTViewBase.isCreateDateDirty() && (bl || pSSysPDTViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysPDTViewBase.getCreateDate());
        }
        if (pSSysPDTViewBase.isCreateManDirty() && (bl || pSSysPDTViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysPDTViewBase.getCreateMan());
        }
        if (pSSysPDTViewBase.isFromDEViewFlagDirty() && (bl || pSSysPDTViewBase.getFromDEViewFlag() != null)) {
            iDataObject.set(FIELD_FROMDEVIEWFLAG, (Object)pSSysPDTViewBase.getFromDEViewFlag());
        }
        if (pSSysPDTViewBase.isLockFlagDirty() && (bl || pSSysPDTViewBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysPDTViewBase.getLockFlag());
        }
        if (pSSysPDTViewBase.isMemoDirty() && (bl || pSSysPDTViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysPDTViewBase.getMemo());
        }
        if (pSSysPDTViewBase.isMobPSDEViewIdDirty() && (bl || pSSysPDTViewBase.getMobPSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBPSDEVIEWID, (Object)pSSysPDTViewBase.getMobPSDEViewId());
        }
        if (pSSysPDTViewBase.isMobPSDEViewNameDirty() && (bl || pSSysPDTViewBase.getMobPSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBPSDEVIEWNAME, (Object)pSSysPDTViewBase.getMobPSDEViewName());
        }
        if (pSSysPDTViewBase.isMobViewCodeNameDirty() && (bl || pSSysPDTViewBase.getMobViewCodeName() != null)) {
            iDataObject.set(FIELD_MOBVIEWCODENAME, (Object)pSSysPDTViewBase.getMobViewCodeName());
        }
        if (pSSysPDTViewBase.isMobViewPSDEIdDirty() && (bl || pSSysPDTViewBase.getMobViewPSDEId() != null)) {
            iDataObject.set(FIELD_MOBVIEWPSDEID, (Object)pSSysPDTViewBase.getMobViewPSDEId());
        }
        if (pSSysPDTViewBase.isPSDEViewBaseIdDirty() && (bl || pSSysPDTViewBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSSysPDTViewBase.getPSDEViewBaseId());
        }
        if (pSSysPDTViewBase.isPSDEViewBaseNameDirty() && (bl || pSSysPDTViewBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSSysPDTViewBase.getPSDEViewBaseName());
        }
        if (pSSysPDTViewBase.isPSModuleIdDirty() && (bl || pSSysPDTViewBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysPDTViewBase.getPSModuleId());
        }
        if (pSSysPDTViewBase.isPSModuleNameDirty() && (bl || pSSysPDTViewBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysPDTViewBase.getPSModuleName());
        }
        if (pSSysPDTViewBase.isPSPDTViewIdDirty() && (bl || pSSysPDTViewBase.getPSPDTViewId() != null)) {
            iDataObject.set(FIELD_PSPDTVIEWID, (Object)pSSysPDTViewBase.getPSPDTViewId());
        }
        if (pSSysPDTViewBase.isPSPDTViewNameDirty() && (bl || pSSysPDTViewBase.getPSPDTViewName() != null)) {
            iDataObject.set(FIELD_PSPDTVIEWNAME, (Object)pSSysPDTViewBase.getPSPDTViewName());
        }
        if (pSSysPDTViewBase.isPSSysPDTViewIdDirty() && (bl || pSSysPDTViewBase.getPSSysPDTViewId() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWID, (Object)pSSysPDTViewBase.getPSSysPDTViewId());
        }
        if (pSSysPDTViewBase.isPSSysPDTViewNameDirty() && (bl || pSSysPDTViewBase.getPSSysPDTViewName() != null)) {
            iDataObject.set(FIELD_PSSYSPDTVIEWNAME, (Object)pSSysPDTViewBase.getPSSysPDTViewName());
        }
        if (pSSysPDTViewBase.isPSSystemIdDirty() && (bl || pSSysPDTViewBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysPDTViewBase.getPSSystemId());
        }
        if (pSSysPDTViewBase.isPSSystemNameDirty() && (bl || pSSysPDTViewBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysPDTViewBase.getPSSystemName());
        }
        if (pSSysPDTViewBase.isUpdateDateDirty() && (bl || pSSysPDTViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysPDTViewBase.getUpdateDate());
        }
        if (pSSysPDTViewBase.isUpdateManDirty() && (bl || pSSysPDTViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysPDTViewBase.getUpdateMan());
        }
        if (pSSysPDTViewBase.isUserCatDirty() && (bl || pSSysPDTViewBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysPDTViewBase.getUserCat());
        }
        if (pSSysPDTViewBase.isUserTagDirty() && (bl || pSSysPDTViewBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysPDTViewBase.getUserTag());
        }
        if (pSSysPDTViewBase.isUserTag2Dirty() && (bl || pSSysPDTViewBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysPDTViewBase.getUserTag2());
        }
        if (pSSysPDTViewBase.isUserTag3Dirty() && (bl || pSSysPDTViewBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysPDTViewBase.getUserTag3());
        }
        if (pSSysPDTViewBase.isUserTag4Dirty() && (bl || pSSysPDTViewBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysPDTViewBase.getUserTag4());
        }
        if (pSSysPDTViewBase.isViewCodeNameDirty() && (bl || pSSysPDTViewBase.getViewCodeName() != null)) {
            iDataObject.set(FIELD_VIEWCODENAME, (Object)pSSysPDTViewBase.getViewCodeName());
        }
        if (pSSysPDTViewBase.isViewPSDEIdDirty() && (bl || pSSysPDTViewBase.getViewPSDEId() != null)) {
            iDataObject.set(FIELD_VIEWPSDEID, (Object)pSSysPDTViewBase.getViewPSDEId());
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
        return PSSysPDTViewBase.remove(this, n);
    }

    private static boolean remove(PSSysPDTViewBase pSSysPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysPDTViewBase.resetCapPSLanResId();
                return true;
            }
            case 1: {
                pSSysPDTViewBase.resetCapPSLanResName();
                return true;
            }
            case 2: {
                pSSysPDTViewBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSysPDTViewBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysPDTViewBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysPDTViewBase.resetFromDEViewFlag();
                return true;
            }
            case 6: {
                pSSysPDTViewBase.resetLockFlag();
                return true;
            }
            case 7: {
                pSSysPDTViewBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysPDTViewBase.resetMobPSDEViewId();
                return true;
            }
            case 9: {
                pSSysPDTViewBase.resetMobPSDEViewName();
                return true;
            }
            case 10: {
                pSSysPDTViewBase.resetMobViewCodeName();
                return true;
            }
            case 11: {
                pSSysPDTViewBase.resetMobViewPSDEId();
                return true;
            }
            case 12: {
                pSSysPDTViewBase.resetPSDEViewBaseId();
                return true;
            }
            case 13: {
                pSSysPDTViewBase.resetPSDEViewBaseName();
                return true;
            }
            case 14: {
                pSSysPDTViewBase.resetPSModuleId();
                return true;
            }
            case 15: {
                pSSysPDTViewBase.resetPSModuleName();
                return true;
            }
            case 16: {
                pSSysPDTViewBase.resetPSPDTViewId();
                return true;
            }
            case 17: {
                pSSysPDTViewBase.resetPSPDTViewName();
                return true;
            }
            case 18: {
                pSSysPDTViewBase.resetPSSysPDTViewId();
                return true;
            }
            case 19: {
                pSSysPDTViewBase.resetPSSysPDTViewName();
                return true;
            }
            case 20: {
                pSSysPDTViewBase.resetPSSystemId();
                return true;
            }
            case 21: {
                pSSysPDTViewBase.resetPSSystemName();
                return true;
            }
            case 22: {
                pSSysPDTViewBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSSysPDTViewBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSSysPDTViewBase.resetUserCat();
                return true;
            }
            case 25: {
                pSSysPDTViewBase.resetUserTag();
                return true;
            }
            case 26: {
                pSSysPDTViewBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSSysPDTViewBase.resetUserTag3();
                return true;
            }
            case 28: {
                pSSysPDTViewBase.resetUserTag4();
                return true;
            }
            case 29: {
                pSSysPDTViewBase.resetViewCodeName();
                return true;
            }
            case 30: {
                pSSysPDTViewBase.resetViewPSDEId();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMobPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEView();
        }
        if (this.getMobPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMobPSDEViewLock;
        synchronized (n) {
            if (this.mobpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMobPSDEViewId(), (Object)this.mobpsdeview.getPSDEViewBaseId()) != 0L) {
                this.mobpsdeview = null;
            }
            if (this.mobpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMobPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.mobpsdeview = pSDEViewBase;
            }
            return this.mobpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
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
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPDTView getPSPDTView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTView();
        }
        if (this.getPSPDTViewId() == null) {
            return null;
        }
        Integer n = this.objPSPDTViewLock;
        synchronized (n) {
            if (this.pspdtview != null && DataTypeHelper.compare((int)25, (Object)this.getPSPDTViewId(), (Object)this.pspdtview.getPSPDTViewId()) != 0L) {
                this.pspdtview = null;
            }
            if (this.pspdtview == null) {
                PSPDTView pSPDTView = new PSPDTView();
                pSPDTView.setPSPDTViewId(this.getPSPDTViewId());
                PSPDTViewService pSPDTViewService = (PSPDTViewService)ServiceGlobal.getService(PSPDTViewService.class, (SessionFactory)this.getSessionFactory());
                pSPDTViewService.autoGet(pSPDTView);
                this.pspdtview = pSPDTView;
            }
            return this.pspdtview;
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

    private PSSysPDTViewBase getProxyEntity() {
        return this.proxyPSSysPDTViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysPDTViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysPDTViewBase) {
            this.proxyPSSysPDTViewBase = (PSSysPDTViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_FROMDEVIEWFLAG, 5);
        fieldIndexMap.put(FIELD_LOCKFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_MOBPSDEVIEWID, 8);
        fieldIndexMap.put(FIELD_MOBPSDEVIEWNAME, 9);
        fieldIndexMap.put(FIELD_MOBVIEWCODENAME, 10);
        fieldIndexMap.put(FIELD_MOBVIEWPSDEID, 11);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 12);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 13);
        fieldIndexMap.put(FIELD_PSMODULEID, 14);
        fieldIndexMap.put(FIELD_PSMODULENAME, 15);
        fieldIndexMap.put(FIELD_PSPDTVIEWID, 16);
        fieldIndexMap.put(FIELD_PSPDTVIEWNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWID, 18);
        fieldIndexMap.put(FIELD_PSSYSPDTVIEWNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USERCAT, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_USERTAG3, 27);
        fieldIndexMap.put(FIELD_USERTAG4, 28);
        fieldIndexMap.put(FIELD_VIEWCODENAME, 29);
        fieldIndexMap.put(FIELD_VIEWPSDEID, 30);
    }
}

