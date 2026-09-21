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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDRGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDRGroupBase.class);
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_GROUPTAG = "GROUPTAG";
    public static final String FIELD_GROUPTAG2 = "GROUPTAG2";
    public static final String FIELD_HEADERPSSYSPFPLUGINID = "HEADERPSSYSPFPLUGINID";
    public static final String FIELD_HEADERPSSYSPFPLUGINNAME = "HEADERPSSYSPFPLUGINNAME";
    public static final String FIELD_HIDDENFLAG = "HIDDENFLAG";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEDRGROUPID = "PSDEDRGROUPID";
    public static final String FIELD_PSDEDRGROUPNAME = "PSDEDRGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CAPPSLANRESID = 0;
    private static final int INDEX_CAPPSLANRESNAME = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_COUNTERID = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DYNAMODELFLAG = 6;
    private static final int INDEX_GROUPTAG = 7;
    private static final int INDEX_GROUPTAG2 = 8;
    private static final int INDEX_HEADERPSSYSPFPLUGINID = 9;
    private static final int INDEX_HEADERPSSYSPFPLUGINNAME = 10;
    private static final int INDEX_HIDDENFLAG = 11;
    private static final int INDEX_LOCKFLAG = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_ORDERVALUE = 14;
    private static final int INDEX_PSDEDRGROUPID = 15;
    private static final int INDEX_PSDEDRGROUPNAME = 16;
    private static final int INDEX_PSDEID = 17;
    private static final int INDEX_PSDENAME = 18;
    private static final int INDEX_PSDYNAINSTID = 19;
    private static final int INDEX_PSSYSCOUNTERID = 20;
    private static final int INDEX_PSSYSCOUNTERNAME = 21;
    private static final int INDEX_PSSYSIMAGEID = 22;
    private static final int INDEX_PSSYSIMAGENAME = 23;
    private static final int INDEX_SRFSYSPUB = 24;
    private static final int INDEX_TIPPSLANRESID = 25;
    private static final int INDEX_TIPPSLANRESNAME = 26;
    private static final int INDEX_TOOLTIPINFO = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERCAT = 30;
    private static final int INDEX_USERPARAMS = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDRGroupBase proxyPSDEDRGroupBase = null;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean grouptagDirtyFlag = false;
    private boolean grouptag2DirtyFlag = false;
    private boolean headerpssyspfpluginidDirtyFlag = false;
    private boolean headerpssyspfpluginnameDirtyFlag = false;
    private boolean hiddenflagDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdedrgroupidDirtyFlag = false;
    private boolean psdedrgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="codename")
    private String codename;
    @Column(name="counterid")
    private String counterid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="grouptag")
    private String grouptag;
    @Column(name="grouptag2")
    private String grouptag2;
    @Column(name="headerpssyspfpluginid")
    private String headerpssyspfpluginid;
    @Column(name="headerpssyspfpluginname")
    private String headerpssyspfpluginname;
    @Column(name="hiddenflag")
    private Integer hiddenflag;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdedrgroupid")
    private String psdedrgroupid;
    @Column(name="psdedrgroupname")
    private String psdedrgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
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
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objHeaderPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin headerpssyspfplugin = null;

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

    public void setCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.counterid = string;
        this.counteridDirtyFlag = true;
    }

    public String getCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterId();
        }
        return this.counterid;
    }

    public boolean isCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterIdDirty();
        }
        return this.counteridDirtyFlag;
    }

    public void resetCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterId();
            return;
        }
        this.counteridDirtyFlag = false;
        this.counterid = null;
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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setGroupTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag = string;
        this.grouptagDirtyFlag = true;
    }

    public String getGroupTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag();
        }
        return this.grouptag;
    }

    public boolean isGroupTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTagDirty();
        }
        return this.grouptagDirtyFlag;
    }

    public void resetGroupTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag();
            return;
        }
        this.grouptagDirtyFlag = false;
        this.grouptag = null;
    }

    public void setGroupTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag2 = string;
        this.grouptag2DirtyFlag = true;
    }

    public String getGroupTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag2();
        }
        return this.grouptag2;
    }

    public boolean isGroupTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTag2Dirty();
        }
        return this.grouptag2DirtyFlag;
    }

    public void resetGroupTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag2();
            return;
        }
        this.grouptag2DirtyFlag = false;
        this.grouptag2 = null;
    }

    public void setHeaderPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerpssyspfpluginid = string;
        this.headerpssyspfpluginidDirtyFlag = true;
    }

    public String getHeaderPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysPFPluginId();
        }
        return this.headerpssyspfpluginid;
    }

    public boolean isHeaderPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderPSSysPFPluginIdDirty();
        }
        return this.headerpssyspfpluginidDirtyFlag;
    }

    public void resetHeaderPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderPSSysPFPluginId();
            return;
        }
        this.headerpssyspfpluginidDirtyFlag = false;
        this.headerpssyspfpluginid = null;
    }

    public void setHeaderPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerpssyspfpluginname = string;
        this.headerpssyspfpluginnameDirtyFlag = true;
    }

    public String getHeaderPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysPFPluginName();
        }
        return this.headerpssyspfpluginname;
    }

    public boolean isHeaderPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderPSSysPFPluginNameDirty();
        }
        return this.headerpssyspfpluginnameDirtyFlag;
    }

    public void resetHeaderPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderPSSysPFPluginName();
            return;
        }
        this.headerpssyspfpluginnameDirtyFlag = false;
        this.headerpssyspfpluginname = null;
    }

    public void setHiddenFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHiddenFlag(n);
            return;
        }
        this.hiddenflag = n;
        this.hiddenflagDirtyFlag = true;
    }

    public Integer getHiddenFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHiddenFlag();
        }
        return this.hiddenflag;
    }

    public boolean isHiddenFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHiddenFlagDirty();
        }
        return this.hiddenflagDirtyFlag;
    }

    public void resetHiddenFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHiddenFlag();
            return;
        }
        this.hiddenflagDirtyFlag = false;
        this.hiddenflag = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSDEDRGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrgroupid = string;
        this.psdedrgroupidDirtyFlag = true;
    }

    public String getPSDEDRGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRGroupId();
        }
        return this.psdedrgroupid;
    }

    public boolean isPSDEDRGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRGroupIdDirty();
        }
        return this.psdedrgroupidDirtyFlag;
    }

    public void resetPSDEDRGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRGroupId();
            return;
        }
        this.psdedrgroupidDirtyFlag = false;
        this.psdedrgroupid = null;
    }

    public void setPSDEDRGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrgroupname = string;
        this.psdedrgroupnameDirtyFlag = true;
    }

    public String getPSDEDRGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRGroupName();
        }
        return this.psdedrgroupname;
    }

    public boolean isPSDEDRGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRGroupNameDirty();
        }
        return this.psdedrgroupnameDirtyFlag;
    }

    public void resetPSDEDRGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRGroupName();
            return;
        }
        this.psdedrgroupnameDirtyFlag = false;
        this.psdedrgroupname = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setSRFSysPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(n);
            return;
        }
        this.srfsyspub = n;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }

    public void setTipPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresid = string;
        this.tippslanresidDirtyFlag = true;
    }

    public String getTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResId();
        }
        return this.tippslanresid;
    }

    public boolean isTipPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResIdDirty();
        }
        return this.tippslanresidDirtyFlag;
    }

    public void resetTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResId();
            return;
        }
        this.tippslanresidDirtyFlag = false;
        this.tippslanresid = null;
    }

    public void setTipPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresname = string;
        this.tippslanresnameDirtyFlag = true;
    }

    public String getTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResName();
        }
        return this.tippslanresname;
    }

    public boolean isTipPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResNameDirty();
        }
        return this.tippslanresnameDirtyFlag;
    }

    public void resetTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResName();
            return;
        }
        this.tippslanresnameDirtyFlag = false;
        this.tippslanresname = null;
    }

    public void setTooltipInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTooltipInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltipinfo = string;
        this.tooltipinfoDirtyFlag = true;
    }

    public String getTooltipInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTooltipInfo();
        }
        return this.tooltipinfo;
    }

    public boolean isTooltipInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTooltipInfoDirty();
        }
        return this.tooltipinfoDirtyFlag;
    }

    public void resetTooltipInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTooltipInfo();
            return;
        }
        this.tooltipinfoDirtyFlag = false;
        this.tooltipinfo = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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
        PSDEDRGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDRGroupBase pSDEDRGroupBase) {
        pSDEDRGroupBase.resetCapPSLanResId();
        pSDEDRGroupBase.resetCapPSLanResName();
        pSDEDRGroupBase.resetCodeName();
        pSDEDRGroupBase.resetCounterId();
        pSDEDRGroupBase.resetCreateDate();
        pSDEDRGroupBase.resetCreateMan();
        pSDEDRGroupBase.resetDynaModelFlag();
        pSDEDRGroupBase.resetGroupTag();
        pSDEDRGroupBase.resetGroupTag2();
        pSDEDRGroupBase.resetHeaderPSSysPFPluginId();
        pSDEDRGroupBase.resetHeaderPSSysPFPluginName();
        pSDEDRGroupBase.resetHiddenFlag();
        pSDEDRGroupBase.resetLockFlag();
        pSDEDRGroupBase.resetMemo();
        pSDEDRGroupBase.resetOrderValue();
        pSDEDRGroupBase.resetPSDEDRGroupId();
        pSDEDRGroupBase.resetPSDEDRGroupName();
        pSDEDRGroupBase.resetPSDEId();
        pSDEDRGroupBase.resetPSDEName();
        pSDEDRGroupBase.resetPSDynaInstId();
        pSDEDRGroupBase.resetPSSysCounterId();
        pSDEDRGroupBase.resetPSSysCounterName();
        pSDEDRGroupBase.resetPSSysImageId();
        pSDEDRGroupBase.resetPSSysImageName();
        pSDEDRGroupBase.resetSRFSysPub();
        pSDEDRGroupBase.resetTipPSLanResId();
        pSDEDRGroupBase.resetTipPSLanResName();
        pSDEDRGroupBase.resetTooltipInfo();
        pSDEDRGroupBase.resetUpdateDate();
        pSDEDRGroupBase.resetUpdateMan();
        pSDEDRGroupBase.resetUserCat();
        pSDEDRGroupBase.resetUserParams();
        pSDEDRGroupBase.resetUserTag();
        pSDEDRGroupBase.resetUserTag2();
        pSDEDRGroupBase.resetUserTag3();
        pSDEDRGroupBase.resetUserTag4();
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
        if (!bl || this.isCounterIdDirty()) {
            hashMap.put(FIELD_COUNTERID, this.getCounterId());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isGroupTagDirty()) {
            hashMap.put(FIELD_GROUPTAG, this.getGroupTag());
        }
        if (!bl || this.isGroupTag2Dirty()) {
            hashMap.put(FIELD_GROUPTAG2, this.getGroupTag2());
        }
        if (!bl || this.isHeaderPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_HEADERPSSYSPFPLUGINID, this.getHeaderPSSysPFPluginId());
        }
        if (!bl || this.isHeaderPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_HEADERPSSYSPFPLUGINNAME, this.getHeaderPSSysPFPluginName());
        }
        if (!bl || this.isHiddenFlagDirty()) {
            hashMap.put(FIELD_HIDDENFLAG, this.getHiddenFlag());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEDRGroupIdDirty()) {
            hashMap.put(FIELD_PSDEDRGROUPID, this.getPSDEDRGroupId());
        }
        if (!bl || this.isPSDEDRGroupNameDirty()) {
            hashMap.put(FIELD_PSDEDRGROUPNAME, this.getPSDEDRGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDEDRGroupBase.get(this, n);
    }

    private static Object get(PSDEDRGroupBase pSDEDRGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRGroupBase.getCapPSLanResId();
            }
            case 1: {
                return pSDEDRGroupBase.getCapPSLanResName();
            }
            case 2: {
                return pSDEDRGroupBase.getCodeName();
            }
            case 3: {
                return pSDEDRGroupBase.getCounterId();
            }
            case 4: {
                return pSDEDRGroupBase.getCreateDate();
            }
            case 5: {
                return pSDEDRGroupBase.getCreateMan();
            }
            case 6: {
                return pSDEDRGroupBase.getDynaModelFlag();
            }
            case 7: {
                return pSDEDRGroupBase.getGroupTag();
            }
            case 8: {
                return pSDEDRGroupBase.getGroupTag2();
            }
            case 9: {
                return pSDEDRGroupBase.getHeaderPSSysPFPluginId();
            }
            case 10: {
                return pSDEDRGroupBase.getHeaderPSSysPFPluginName();
            }
            case 11: {
                return pSDEDRGroupBase.getHiddenFlag();
            }
            case 12: {
                return pSDEDRGroupBase.getLockFlag();
            }
            case 13: {
                return pSDEDRGroupBase.getMemo();
            }
            case 14: {
                return pSDEDRGroupBase.getOrderValue();
            }
            case 15: {
                return pSDEDRGroupBase.getPSDEDRGroupId();
            }
            case 16: {
                return pSDEDRGroupBase.getPSDEDRGroupName();
            }
            case 17: {
                return pSDEDRGroupBase.getPSDEId();
            }
            case 18: {
                return pSDEDRGroupBase.getPSDEName();
            }
            case 19: {
                return pSDEDRGroupBase.getPSDynaInstId();
            }
            case 20: {
                return pSDEDRGroupBase.getPSSysCounterId();
            }
            case 21: {
                return pSDEDRGroupBase.getPSSysCounterName();
            }
            case 22: {
                return pSDEDRGroupBase.getPSSysImageId();
            }
            case 23: {
                return pSDEDRGroupBase.getPSSysImageName();
            }
            case 24: {
                return pSDEDRGroupBase.getSRFSysPub();
            }
            case 25: {
                return pSDEDRGroupBase.getTipPSLanResId();
            }
            case 26: {
                return pSDEDRGroupBase.getTipPSLanResName();
            }
            case 27: {
                return pSDEDRGroupBase.getTooltipInfo();
            }
            case 28: {
                return pSDEDRGroupBase.getUpdateDate();
            }
            case 29: {
                return pSDEDRGroupBase.getUpdateMan();
            }
            case 30: {
                return pSDEDRGroupBase.getUserCat();
            }
            case 31: {
                return pSDEDRGroupBase.getUserParams();
            }
            case 32: {
                return pSDEDRGroupBase.getUserTag();
            }
            case 33: {
                return pSDEDRGroupBase.getUserTag2();
            }
            case 34: {
                return pSDEDRGroupBase.getUserTag3();
            }
            case 35: {
                return pSDEDRGroupBase.getUserTag4();
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
        PSDEDRGroupBase.set(this, n, object);
    }

    private static void set(PSDEDRGroupBase pSDEDRGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDRGroupBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDRGroupBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDRGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDRGroupBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDRGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEDRGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDRGroupBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEDRGroupBase.setGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDRGroupBase.setGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDRGroupBase.setHeaderPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDRGroupBase.setHeaderPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDRGroupBase.setHiddenFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDRGroupBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEDRGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDRGroupBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEDRGroupBase.setPSDEDRGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDRGroupBase.setPSDEDRGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDRGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDRGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDRGroupBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDRGroupBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDRGroupBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDRGroupBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDRGroupBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDRGroupBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEDRGroupBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDRGroupBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDRGroupBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDRGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDEDRGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDRGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDRGroupBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDRGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDRGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDRGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDRGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEDRGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDRGroupBase pSDEDRGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRGroupBase.getCapPSLanResId() == null;
            }
            case 1: {
                return pSDEDRGroupBase.getCapPSLanResName() == null;
            }
            case 2: {
                return pSDEDRGroupBase.getCodeName() == null;
            }
            case 3: {
                return pSDEDRGroupBase.getCounterId() == null;
            }
            case 4: {
                return pSDEDRGroupBase.getCreateDate() == null;
            }
            case 5: {
                return pSDEDRGroupBase.getCreateMan() == null;
            }
            case 6: {
                return pSDEDRGroupBase.getDynaModelFlag() == null;
            }
            case 7: {
                return pSDEDRGroupBase.getGroupTag() == null;
            }
            case 8: {
                return pSDEDRGroupBase.getGroupTag2() == null;
            }
            case 9: {
                return pSDEDRGroupBase.getHeaderPSSysPFPluginId() == null;
            }
            case 10: {
                return pSDEDRGroupBase.getHeaderPSSysPFPluginName() == null;
            }
            case 11: {
                return pSDEDRGroupBase.getHiddenFlag() == null;
            }
            case 12: {
                return pSDEDRGroupBase.getLockFlag() == null;
            }
            case 13: {
                return pSDEDRGroupBase.getMemo() == null;
            }
            case 14: {
                return pSDEDRGroupBase.getOrderValue() == null;
            }
            case 15: {
                return pSDEDRGroupBase.getPSDEDRGroupId() == null;
            }
            case 16: {
                return pSDEDRGroupBase.getPSDEDRGroupName() == null;
            }
            case 17: {
                return pSDEDRGroupBase.getPSDEId() == null;
            }
            case 18: {
                return pSDEDRGroupBase.getPSDEName() == null;
            }
            case 19: {
                return pSDEDRGroupBase.getPSDynaInstId() == null;
            }
            case 20: {
                return pSDEDRGroupBase.getPSSysCounterId() == null;
            }
            case 21: {
                return pSDEDRGroupBase.getPSSysCounterName() == null;
            }
            case 22: {
                return pSDEDRGroupBase.getPSSysImageId() == null;
            }
            case 23: {
                return pSDEDRGroupBase.getPSSysImageName() == null;
            }
            case 24: {
                return pSDEDRGroupBase.getSRFSysPub() == null;
            }
            case 25: {
                return pSDEDRGroupBase.getTipPSLanResId() == null;
            }
            case 26: {
                return pSDEDRGroupBase.getTipPSLanResName() == null;
            }
            case 27: {
                return pSDEDRGroupBase.getTooltipInfo() == null;
            }
            case 28: {
                return pSDEDRGroupBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDEDRGroupBase.getUpdateMan() == null;
            }
            case 30: {
                return pSDEDRGroupBase.getUserCat() == null;
            }
            case 31: {
                return pSDEDRGroupBase.getUserParams() == null;
            }
            case 32: {
                return pSDEDRGroupBase.getUserTag() == null;
            }
            case 33: {
                return pSDEDRGroupBase.getUserTag2() == null;
            }
            case 34: {
                return pSDEDRGroupBase.getUserTag3() == null;
            }
            case 35: {
                return pSDEDRGroupBase.getUserTag4() == null;
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
        return PSDEDRGroupBase.contains(this, n);
    }

    private static boolean contains(PSDEDRGroupBase pSDEDRGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDRGroupBase.isCapPSLanResIdDirty();
            }
            case 1: {
                return pSDEDRGroupBase.isCapPSLanResNameDirty();
            }
            case 2: {
                return pSDEDRGroupBase.isCodeNameDirty();
            }
            case 3: {
                return pSDEDRGroupBase.isCounterIdDirty();
            }
            case 4: {
                return pSDEDRGroupBase.isCreateDateDirty();
            }
            case 5: {
                return pSDEDRGroupBase.isCreateManDirty();
            }
            case 6: {
                return pSDEDRGroupBase.isDynaModelFlagDirty();
            }
            case 7: {
                return pSDEDRGroupBase.isGroupTagDirty();
            }
            case 8: {
                return pSDEDRGroupBase.isGroupTag2Dirty();
            }
            case 9: {
                return pSDEDRGroupBase.isHeaderPSSysPFPluginIdDirty();
            }
            case 10: {
                return pSDEDRGroupBase.isHeaderPSSysPFPluginNameDirty();
            }
            case 11: {
                return pSDEDRGroupBase.isHiddenFlagDirty();
            }
            case 12: {
                return pSDEDRGroupBase.isLockFlagDirty();
            }
            case 13: {
                return pSDEDRGroupBase.isMemoDirty();
            }
            case 14: {
                return pSDEDRGroupBase.isOrderValueDirty();
            }
            case 15: {
                return pSDEDRGroupBase.isPSDEDRGroupIdDirty();
            }
            case 16: {
                return pSDEDRGroupBase.isPSDEDRGroupNameDirty();
            }
            case 17: {
                return pSDEDRGroupBase.isPSDEIdDirty();
            }
            case 18: {
                return pSDEDRGroupBase.isPSDENameDirty();
            }
            case 19: {
                return pSDEDRGroupBase.isPSDynaInstIdDirty();
            }
            case 20: {
                return pSDEDRGroupBase.isPSSysCounterIdDirty();
            }
            case 21: {
                return pSDEDRGroupBase.isPSSysCounterNameDirty();
            }
            case 22: {
                return pSDEDRGroupBase.isPSSysImageIdDirty();
            }
            case 23: {
                return pSDEDRGroupBase.isPSSysImageNameDirty();
            }
            case 24: {
                return pSDEDRGroupBase.isSRFSysPubDirty();
            }
            case 25: {
                return pSDEDRGroupBase.isTipPSLanResIdDirty();
            }
            case 26: {
                return pSDEDRGroupBase.isTipPSLanResNameDirty();
            }
            case 27: {
                return pSDEDRGroupBase.isTooltipInfoDirty();
            }
            case 28: {
                return pSDEDRGroupBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDEDRGroupBase.isUpdateManDirty();
            }
            case 30: {
                return pSDEDRGroupBase.isUserCatDirty();
            }
            case 31: {
                return pSDEDRGroupBase.isUserParamsDirty();
            }
            case 32: {
                return pSDEDRGroupBase.isUserTagDirty();
            }
            case 33: {
                return pSDEDRGroupBase.isUserTag2Dirty();
            }
            case 34: {
                return pSDEDRGroupBase.isUserTag3Dirty();
            }
            case 35: {
                return pSDEDRGroupBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDRGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDRGroupBase pSDEDRGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDRGroupBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getCounterId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getGroupTag()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag2", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getGroupTag2()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getHeaderPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyspfpluginid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getHeaderPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getHeaderPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyspfpluginname", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getHeaderPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getHiddenFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hiddenflag", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getHiddenFlag()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSDEDRGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrgroupid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSDEDRGroupId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSDEDRGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrgroupname", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSDEDRGroupName()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDRGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDRGroupBase.getJSONValue((Object)pSDEDRGroupBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDRGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDRGroupBase pSDEDRGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDRGroupBase.getCapPSLanResId() != null) {
            object = pSDEDRGroupBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRGroupBase.getCapPSLanResName() != null) {
            object = pSDEDRGroupBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRGroupBase.getCodeName() != null) {
            object = pSDEDRGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDRGroupBase.getCounterId() != null) {
            object = pSDEDRGroupBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getCreateDate() != null) {
            object = pSDEDRGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDRGroupBase.getCreateMan() != null) {
            object = pSDEDRGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getDynaModelFlag() != null) {
            object = pSDEDRGroupBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRGroupBase.getGroupTag() != null) {
            object = pSDEDRGroupBase.getGroupTag();
            xmlNode.setAttribute(FIELD_GROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getGroupTag2() != null) {
            object = pSDEDRGroupBase.getGroupTag2();
            xmlNode.setAttribute(FIELD_GROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getHeaderPSSysPFPluginId() != null) {
            object = pSDEDRGroupBase.getHeaderPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_HEADERPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getHeaderPSSysPFPluginName() != null) {
            object = pSDEDRGroupBase.getHeaderPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_HEADERPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getHiddenFlag() != null) {
            object = pSDEDRGroupBase.getHiddenFlag();
            xmlNode.setAttribute(FIELD_HIDDENFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRGroupBase.getLockFlag() != null) {
            object = pSDEDRGroupBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRGroupBase.getMemo() != null) {
            object = pSDEDRGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getOrderValue() != null) {
            object = pSDEDRGroupBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRGroupBase.getPSDEDRGroupId() != null) {
            object = pSDEDRGroupBase.getPSDEDRGroupId();
            xmlNode.setAttribute(FIELD_PSDEDRGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getPSDEDRGroupName() != null) {
            object = pSDEDRGroupBase.getPSDEDRGroupName();
            xmlNode.setAttribute(FIELD_PSDEDRGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getPSDEId() != null) {
            object = pSDEDRGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getPSDEName() != null) {
            object = pSDEDRGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getPSDynaInstId() != null) {
            object = pSDEDRGroupBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getPSSysCounterId() != null) {
            object = pSDEDRGroupBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getPSSysCounterName() != null) {
            object = pSDEDRGroupBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getPSSysImageId() != null) {
            object = pSDEDRGroupBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getPSSysImageName() != null) {
            object = pSDEDRGroupBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getSRFSysPub() != null) {
            object = pSDEDRGroupBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDRGroupBase.getTipPSLanResId() != null) {
            object = pSDEDRGroupBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getTipPSLanResName() != null) {
            object = pSDEDRGroupBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getTooltipInfo() != null) {
            object = pSDEDRGroupBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getUpdateDate() != null) {
            object = pSDEDRGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDRGroupBase.getUpdateMan() != null) {
            object = pSDEDRGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getUserCat() != null) {
            object = pSDEDRGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getUserParams() != null) {
            object = pSDEDRGroupBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getUserTag() != null) {
            object = pSDEDRGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getUserTag2() != null) {
            object = pSDEDRGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getUserTag3() != null) {
            object = pSDEDRGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDRGroupBase.getUserTag4() != null) {
            object = pSDEDRGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDRGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDRGroupBase pSDEDRGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDRGroupBase.isCapPSLanResIdDirty() && (bl || pSDEDRGroupBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEDRGroupBase.getCapPSLanResId());
        }
        if (pSDEDRGroupBase.isCapPSLanResNameDirty() && (bl || pSDEDRGroupBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEDRGroupBase.getCapPSLanResName());
        }
        if (pSDEDRGroupBase.isCodeNameDirty() && (bl || pSDEDRGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDRGroupBase.getCodeName());
        }
        if (pSDEDRGroupBase.isCounterIdDirty() && (bl || pSDEDRGroupBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSDEDRGroupBase.getCounterId());
        }
        if (pSDEDRGroupBase.isCreateDateDirty() && (bl || pSDEDRGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDRGroupBase.getCreateDate());
        }
        if (pSDEDRGroupBase.isCreateManDirty() && (bl || pSDEDRGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDRGroupBase.getCreateMan());
        }
        if (pSDEDRGroupBase.isDynaModelFlagDirty() && (bl || pSDEDRGroupBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDRGroupBase.getDynaModelFlag());
        }
        if (pSDEDRGroupBase.isGroupTagDirty() && (bl || pSDEDRGroupBase.getGroupTag() != null)) {
            iDataObject.set(FIELD_GROUPTAG, (Object)pSDEDRGroupBase.getGroupTag());
        }
        if (pSDEDRGroupBase.isGroupTag2Dirty() && (bl || pSDEDRGroupBase.getGroupTag2() != null)) {
            iDataObject.set(FIELD_GROUPTAG2, (Object)pSDEDRGroupBase.getGroupTag2());
        }
        if (pSDEDRGroupBase.isHeaderPSSysPFPluginIdDirty() && (bl || pSDEDRGroupBase.getHeaderPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSPFPLUGINID, (Object)pSDEDRGroupBase.getHeaderPSSysPFPluginId());
        }
        if (pSDEDRGroupBase.isHeaderPSSysPFPluginNameDirty() && (bl || pSDEDRGroupBase.getHeaderPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSPFPLUGINNAME, (Object)pSDEDRGroupBase.getHeaderPSSysPFPluginName());
        }
        if (pSDEDRGroupBase.isHiddenFlagDirty() && (bl || pSDEDRGroupBase.getHiddenFlag() != null)) {
            iDataObject.set(FIELD_HIDDENFLAG, (Object)pSDEDRGroupBase.getHiddenFlag());
        }
        if (pSDEDRGroupBase.isLockFlagDirty() && (bl || pSDEDRGroupBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDRGroupBase.getLockFlag());
        }
        if (pSDEDRGroupBase.isMemoDirty() && (bl || pSDEDRGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDRGroupBase.getMemo());
        }
        if (pSDEDRGroupBase.isOrderValueDirty() && (bl || pSDEDRGroupBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDRGroupBase.getOrderValue());
        }
        if (pSDEDRGroupBase.isPSDEDRGroupIdDirty() && (bl || pSDEDRGroupBase.getPSDEDRGroupId() != null)) {
            iDataObject.set(FIELD_PSDEDRGROUPID, (Object)pSDEDRGroupBase.getPSDEDRGroupId());
        }
        if (pSDEDRGroupBase.isPSDEDRGroupNameDirty() && (bl || pSDEDRGroupBase.getPSDEDRGroupName() != null)) {
            iDataObject.set(FIELD_PSDEDRGROUPNAME, (Object)pSDEDRGroupBase.getPSDEDRGroupName());
        }
        if (pSDEDRGroupBase.isPSDEIdDirty() && (bl || pSDEDRGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDRGroupBase.getPSDEId());
        }
        if (pSDEDRGroupBase.isPSDENameDirty() && (bl || pSDEDRGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDRGroupBase.getPSDEName());
        }
        if (pSDEDRGroupBase.isPSDynaInstIdDirty() && (bl || pSDEDRGroupBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDRGroupBase.getPSDynaInstId());
        }
        if (pSDEDRGroupBase.isPSSysCounterIdDirty() && (bl || pSDEDRGroupBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDEDRGroupBase.getPSSysCounterId());
        }
        if (pSDEDRGroupBase.isPSSysCounterNameDirty() && (bl || pSDEDRGroupBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDEDRGroupBase.getPSSysCounterName());
        }
        if (pSDEDRGroupBase.isPSSysImageIdDirty() && (bl || pSDEDRGroupBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEDRGroupBase.getPSSysImageId());
        }
        if (pSDEDRGroupBase.isPSSysImageNameDirty() && (bl || pSDEDRGroupBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEDRGroupBase.getPSSysImageName());
        }
        if (pSDEDRGroupBase.isSRFSysPubDirty() && (bl || pSDEDRGroupBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEDRGroupBase.getSRFSysPub());
        }
        if (pSDEDRGroupBase.isTipPSLanResIdDirty() && (bl || pSDEDRGroupBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSDEDRGroupBase.getTipPSLanResId());
        }
        if (pSDEDRGroupBase.isTipPSLanResNameDirty() && (bl || pSDEDRGroupBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSDEDRGroupBase.getTipPSLanResName());
        }
        if (pSDEDRGroupBase.isTooltipInfoDirty() && (bl || pSDEDRGroupBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSDEDRGroupBase.getTooltipInfo());
        }
        if (pSDEDRGroupBase.isUpdateDateDirty() && (bl || pSDEDRGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDRGroupBase.getUpdateDate());
        }
        if (pSDEDRGroupBase.isUpdateManDirty() && (bl || pSDEDRGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDRGroupBase.getUpdateMan());
        }
        if (pSDEDRGroupBase.isUserCatDirty() && (bl || pSDEDRGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDRGroupBase.getUserCat());
        }
        if (pSDEDRGroupBase.isUserParamsDirty() && (bl || pSDEDRGroupBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEDRGroupBase.getUserParams());
        }
        if (pSDEDRGroupBase.isUserTagDirty() && (bl || pSDEDRGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDRGroupBase.getUserTag());
        }
        if (pSDEDRGroupBase.isUserTag2Dirty() && (bl || pSDEDRGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDRGroupBase.getUserTag2());
        }
        if (pSDEDRGroupBase.isUserTag3Dirty() && (bl || pSDEDRGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDRGroupBase.getUserTag3());
        }
        if (pSDEDRGroupBase.isUserTag4Dirty() && (bl || pSDEDRGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDRGroupBase.getUserTag4());
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
        return PSDEDRGroupBase.remove(this, n);
    }

    private static boolean remove(PSDEDRGroupBase pSDEDRGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDRGroupBase.resetCapPSLanResId();
                return true;
            }
            case 1: {
                pSDEDRGroupBase.resetCapPSLanResName();
                return true;
            }
            case 2: {
                pSDEDRGroupBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDEDRGroupBase.resetCounterId();
                return true;
            }
            case 4: {
                pSDEDRGroupBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDEDRGroupBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDEDRGroupBase.resetDynaModelFlag();
                return true;
            }
            case 7: {
                pSDEDRGroupBase.resetGroupTag();
                return true;
            }
            case 8: {
                pSDEDRGroupBase.resetGroupTag2();
                return true;
            }
            case 9: {
                pSDEDRGroupBase.resetHeaderPSSysPFPluginId();
                return true;
            }
            case 10: {
                pSDEDRGroupBase.resetHeaderPSSysPFPluginName();
                return true;
            }
            case 11: {
                pSDEDRGroupBase.resetHiddenFlag();
                return true;
            }
            case 12: {
                pSDEDRGroupBase.resetLockFlag();
                return true;
            }
            case 13: {
                pSDEDRGroupBase.resetMemo();
                return true;
            }
            case 14: {
                pSDEDRGroupBase.resetOrderValue();
                return true;
            }
            case 15: {
                pSDEDRGroupBase.resetPSDEDRGroupId();
                return true;
            }
            case 16: {
                pSDEDRGroupBase.resetPSDEDRGroupName();
                return true;
            }
            case 17: {
                pSDEDRGroupBase.resetPSDEId();
                return true;
            }
            case 18: {
                pSDEDRGroupBase.resetPSDEName();
                return true;
            }
            case 19: {
                pSDEDRGroupBase.resetPSDynaInstId();
                return true;
            }
            case 20: {
                pSDEDRGroupBase.resetPSSysCounterId();
                return true;
            }
            case 21: {
                pSDEDRGroupBase.resetPSSysCounterName();
                return true;
            }
            case 22: {
                pSDEDRGroupBase.resetPSSysImageId();
                return true;
            }
            case 23: {
                pSDEDRGroupBase.resetPSSysImageName();
                return true;
            }
            case 24: {
                pSDEDRGroupBase.resetSRFSysPub();
                return true;
            }
            case 25: {
                pSDEDRGroupBase.resetTipPSLanResId();
                return true;
            }
            case 26: {
                pSDEDRGroupBase.resetTipPSLanResName();
                return true;
            }
            case 27: {
                pSDEDRGroupBase.resetTooltipInfo();
                return true;
            }
            case 28: {
                pSDEDRGroupBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDEDRGroupBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSDEDRGroupBase.resetUserCat();
                return true;
            }
            case 31: {
                pSDEDRGroupBase.resetUserParams();
                return true;
            }
            case 32: {
                pSDEDRGroupBase.resetUserTag();
                return true;
            }
            case 33: {
                pSDEDRGroupBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSDEDRGroupBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSDEDRGroupBase.resetUserTag4();
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTipPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanRes();
        }
        if (this.getTipPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTipPSLanResLock;
        synchronized (n) {
            if (this.tippslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTipPSLanResId(), (Object)this.tippslanres.getPSLanguageResId()) != 0L) {
                this.tippslanres = null;
            }
            if (this.tippslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTipPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet((IEntity)pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet((IEntity)pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getHeaderPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysPFPlugin();
        }
        if (this.getHeaderPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objHeaderPSSysPFPluginLock;
        synchronized (n) {
            if (this.headerpssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getHeaderPSSysPFPluginId(), (Object)this.headerpssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.headerpssyspfplugin = null;
            }
            if (this.headerpssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getHeaderPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.headerpssyspfplugin = pSSysPFPlugin;
            }
            return this.headerpssyspfplugin;
        }
    }

    private PSDEDRGroupBase getProxyEntity() {
        return this.proxyPSDEDRGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDRGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDRGroupBase) {
            this.proxyPSDEDRGroupBase = (PSDEDRGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_COUNTERID, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 6);
        fieldIndexMap.put(FIELD_GROUPTAG, 7);
        fieldIndexMap.put(FIELD_GROUPTAG2, 8);
        fieldIndexMap.put(FIELD_HEADERPSSYSPFPLUGINID, 9);
        fieldIndexMap.put(FIELD_HEADERPSSYSPFPLUGINNAME, 10);
        fieldIndexMap.put(FIELD_HIDDENFLAG, 11);
        fieldIndexMap.put(FIELD_LOCKFLAG, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_ORDERVALUE, 14);
        fieldIndexMap.put(FIELD_PSDEDRGROUPID, 15);
        fieldIndexMap.put(FIELD_PSDEDRGROUPNAME, 16);
        fieldIndexMap.put(FIELD_PSDEID, 17);
        fieldIndexMap.put(FIELD_PSDENAME, 18);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 19);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 20);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 22);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 23);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 24);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 25);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 26);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERCAT, 30);
        fieldIndexMap.put(FIELD_USERPARAMS, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
    }
}

