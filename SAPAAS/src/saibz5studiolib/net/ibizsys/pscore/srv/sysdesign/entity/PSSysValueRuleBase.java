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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSValueRule;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSValueRuleService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysValueRuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysValueRuleBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_BEGINVALUE = "BEGINVALUE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMOBJ = "CUSTOMOBJ";
    public static final String FIELD_CUSTOMPARAMS = "CUSTOMPARAMS";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_ENDVALUE = "ENDVALUE";
    public static final String FIELD_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String FIELD_INCENDVALUE = "INCENDVALUE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_PSVALUERULEID = "PSVALUERULEID";
    public static final String FIELD_PSVALUERULENAME = "PSVALUERULENAME";
    public static final String FIELD_REGEXPCODE = "REGEXPCODE";
    public static final String FIELD_REGEXPCODE2 = "REGEXPCODE2";
    public static final String FIELD_REGEXPCODE3 = "REGEXPCODE3";
    public static final String FIELD_REGEXPCODE4 = "REGEXPCODE4";
    public static final String FIELD_RIPSLANRESID = "RIPSLANRESID";
    public static final String FIELD_RIPSLANRESNAME = "RIPSLANRESNAME";
    public static final String FIELD_RULEHOLDER = "RULEHOLDER";
    public static final String FIELD_RULEINFO = "RULEINFO";
    public static final String FIELD_RULETAG = "RULETAG";
    public static final String FIELD_RULETAG2 = "RULETAG2";
    public static final String FIELD_RULETYPE = "RULETYPE";
    public static final String FIELD_SCRIPT = "SCRIPT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_BEGINVALUE = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CUSTOMOBJ = 5;
    private static final int INDEX_CUSTOMPARAMS = 6;
    private static final int INDEX_DYNAMODELFLAG = 7;
    private static final int INDEX_ENDTIME = 8;
    private static final int INDEX_ENDVALUE = 9;
    private static final int INDEX_INCBEGINVALUE = 10;
    private static final int INDEX_INCENDVALUE = 11;
    private static final int INDEX_LOCKFLAG = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_PSDYNAINSTID = 14;
    private static final int INDEX_PSMODULEID = 15;
    private static final int INDEX_PSMODULENAME = 16;
    private static final int INDEX_PSSYSDYNAMODELID = 17;
    private static final int INDEX_PSSYSDYNAMODELNAME = 18;
    private static final int INDEX_PSSYSPFPLUGINID = 19;
    private static final int INDEX_PSSYSPFPLUGINNAME = 20;
    private static final int INDEX_PSSYSSFPLUGINID = 21;
    private static final int INDEX_PSSYSSFPLUGINNAME = 22;
    private static final int INDEX_PSSYSTEMID = 23;
    private static final int INDEX_PSSYSTEMNAME = 24;
    private static final int INDEX_PSSYSVALUERULEID = 25;
    private static final int INDEX_PSSYSVALUERULENAME = 26;
    private static final int INDEX_PSVALUERULEID = 27;
    private static final int INDEX_PSVALUERULENAME = 28;
    private static final int INDEX_REGEXPCODE = 29;
    private static final int INDEX_REGEXPCODE2 = 30;
    private static final int INDEX_REGEXPCODE3 = 31;
    private static final int INDEX_REGEXPCODE4 = 32;
    private static final int INDEX_RIPSLANRESID = 33;
    private static final int INDEX_RIPSLANRESNAME = 34;
    private static final int INDEX_RULEHOLDER = 35;
    private static final int INDEX_RULEINFO = 36;
    private static final int INDEX_RULETAG = 37;
    private static final int INDEX_RULETAG2 = 38;
    private static final int INDEX_RULETYPE = 39;
    private static final int INDEX_SCRIPT = 40;
    private static final int INDEX_UPDATEDATE = 41;
    private static final int INDEX_UPDATEMAN = 42;
    private static final int INDEX_USERCAT = 43;
    private static final int INDEX_USERTAG = 44;
    private static final int INDEX_USERTAG2 = 45;
    private static final int INDEX_USERTAG3 = 46;
    private static final int INDEX_USERTAG4 = 47;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysValueRuleBase proxyPSSysValueRuleBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean beginvalueDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customobjDirtyFlag = false;
    private boolean customparamsDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean endvalueDirtyFlag = false;
    private boolean incbeginvalueDirtyFlag = false;
    private boolean incendvalueDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean psvalueruleidDirtyFlag = false;
    private boolean psvaluerulenameDirtyFlag = false;
    private boolean regexpcodeDirtyFlag = false;
    private boolean regexpcode2DirtyFlag = false;
    private boolean regexpcode3DirtyFlag = false;
    private boolean regexpcode4DirtyFlag = false;
    private boolean ripslanresidDirtyFlag = false;
    private boolean ripslanresnameDirtyFlag = false;
    private boolean ruleholderDirtyFlag = false;
    private boolean ruleinfoDirtyFlag = false;
    private boolean ruletagDirtyFlag = false;
    private boolean ruletag2DirtyFlag = false;
    private boolean ruletypeDirtyFlag = false;
    private boolean scriptDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="beginvalue")
    private Double beginvalue;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customobj")
    private String customobj;
    @Column(name="customparams")
    private String customparams;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="endvalue")
    private Double endvalue;
    @Column(name="incbeginvalue")
    private Integer incbeginvalue;
    @Column(name="incendvalue")
    private Integer incendvalue;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
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
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
    @Column(name="psvalueruleid")
    private String psvalueruleid;
    @Column(name="psvaluerulename")
    private String psvaluerulename;
    @Column(name="regexpcode")
    private String regexpcode;
    @Column(name="regexpcode2")
    private String regexpcode2;
    @Column(name="regexpcode3")
    private String regexpcode3;
    @Column(name="regexpcode4")
    private String regexpcode4;
    @Column(name="ripslanresid")
    private String ripslanresid;
    @Column(name="ripslanresname")
    private String ripslanresname;
    @Column(name="ruleholder")
    private Integer ruleholder;
    @Column(name="ruleinfo")
    private String ruleinfo;
    @Column(name="ruletag")
    private String ruletag;
    @Column(name="ruletag2")
    private String ruletag2;
    @Column(name="ruletype")
    private String ruletype;
    @Column(name="script")
    private String script;
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
    private Integer objRIPSLanResLock = new Integer(1);
    private PSLanguageRes ripslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSValueRuleLock = new Integer(1);
    private PSValueRule psvaluerule = null;

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
    }

    public void setBeginValue(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginValue(d);
            return;
        }
        this.beginvalue = d;
        this.beginvalueDirtyFlag = true;
    }

    public Double getBeginValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValue();
        }
        return this.beginvalue;
    }

    public boolean isBeginValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginValueDirty();
        }
        return this.beginvalueDirtyFlag;
    }

    public void resetBeginValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginValue();
            return;
        }
        this.beginvalueDirtyFlag = false;
        this.beginvalue = null;
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

    public void setCustomObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customobj = string;
        this.customobjDirtyFlag = true;
    }

    public String getCustomObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomObj();
        }
        return this.customobj;
    }

    public boolean isCustomObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomObjDirty();
        }
        return this.customobjDirtyFlag;
    }

    public void resetCustomObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomObj();
            return;
        }
        this.customobjDirtyFlag = false;
        this.customobj = null;
    }

    public void setCustomParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customparams = string;
        this.customparamsDirtyFlag = true;
    }

    public String getCustomParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomParams();
        }
        return this.customparams;
    }

    public boolean isCustomParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomParamsDirty();
        }
        return this.customparamsDirtyFlag;
    }

    public void resetCustomParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomParams();
            return;
        }
        this.customparamsDirtyFlag = false;
        this.customparams = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setEndValue(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndValue(d);
            return;
        }
        this.endvalue = d;
        this.endvalueDirtyFlag = true;
    }

    public Double getEndValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValue();
        }
        return this.endvalue;
    }

    public boolean isEndValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndValueDirty();
        }
        return this.endvalueDirtyFlag;
    }

    public void resetEndValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndValue();
            return;
        }
        this.endvalueDirtyFlag = false;
        this.endvalue = null;
    }

    public void setIncBeginValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncBeginValue(n);
            return;
        }
        this.incbeginvalue = n;
        this.incbeginvalueDirtyFlag = true;
    }

    public Integer getIncBeginValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncBeginValue();
        }
        return this.incbeginvalue;
    }

    public boolean isIncBeginValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncBeginValueDirty();
        }
        return this.incbeginvalueDirtyFlag;
    }

    public void resetIncBeginValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncBeginValue();
            return;
        }
        this.incbeginvalueDirtyFlag = false;
        this.incbeginvalue = null;
    }

    public void setIncEndValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncEndValue(n);
            return;
        }
        this.incendvalue = n;
        this.incendvalueDirtyFlag = true;
    }

    public Integer getIncEndValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncEndValue();
        }
        return this.incendvalue;
    }

    public boolean isIncEndValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncEndValueDirty();
        }
        return this.incendvalueDirtyFlag;
    }

    public void resetIncEndValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncEndValue();
            return;
        }
        this.incendvalueDirtyFlag = false;
        this.incendvalue = null;
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

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
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

    public void setPSSysValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvalueruleid = string;
        this.pssysvalueruleidDirtyFlag = true;
    }

    public String getPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleId();
        }
        return this.pssysvalueruleid;
    }

    public boolean isPSSysValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleIdDirty();
        }
        return this.pssysvalueruleidDirtyFlag;
    }

    public void resetPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleId();
            return;
        }
        this.pssysvalueruleidDirtyFlag = false;
        this.pssysvalueruleid = null;
    }

    public void setPSSysValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvaluerulename = string;
        this.pssysvaluerulenameDirtyFlag = true;
    }

    public String getPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleName();
        }
        return this.pssysvaluerulename;
    }

    public boolean isPSSysValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleNameDirty();
        }
        return this.pssysvaluerulenameDirtyFlag;
    }

    public void resetPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleName();
            return;
        }
        this.pssysvaluerulenameDirtyFlag = false;
        this.pssysvaluerulename = null;
    }

    public void setPSValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvalueruleid = string;
        this.psvalueruleidDirtyFlag = true;
    }

    public String getPSValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRuleId();
        }
        return this.psvalueruleid;
    }

    public boolean isPSValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSValueRuleIdDirty();
        }
        return this.psvalueruleidDirtyFlag;
    }

    public void resetPSValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSValueRuleId();
            return;
        }
        this.psvalueruleidDirtyFlag = false;
        this.psvalueruleid = null;
    }

    public void setPSValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvaluerulename = string;
        this.psvaluerulenameDirtyFlag = true;
    }

    public String getPSValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRuleName();
        }
        return this.psvaluerulename;
    }

    public boolean isPSValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSValueRuleNameDirty();
        }
        return this.psvaluerulenameDirtyFlag;
    }

    public void resetPSValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSValueRuleName();
            return;
        }
        this.psvaluerulenameDirtyFlag = false;
        this.psvaluerulename = null;
    }

    public void setRegExpCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegExpCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.regexpcode = string;
        this.regexpcodeDirtyFlag = true;
    }

    public String getRegExpCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegExpCode();
        }
        return this.regexpcode;
    }

    public boolean isRegExpCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegExpCodeDirty();
        }
        return this.regexpcodeDirtyFlag;
    }

    public void resetRegExpCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegExpCode();
            return;
        }
        this.regexpcodeDirtyFlag = false;
        this.regexpcode = null;
    }

    public void setRegExpCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegExpCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.regexpcode2 = string;
        this.regexpcode2DirtyFlag = true;
    }

    public String getRegExpCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegExpCode2();
        }
        return this.regexpcode2;
    }

    public boolean isRegExpCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegExpCode2Dirty();
        }
        return this.regexpcode2DirtyFlag;
    }

    public void resetRegExpCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegExpCode2();
            return;
        }
        this.regexpcode2DirtyFlag = false;
        this.regexpcode2 = null;
    }

    public void setRegExpCode3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegExpCode3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.regexpcode3 = string;
        this.regexpcode3DirtyFlag = true;
    }

    public String getRegExpCode3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegExpCode3();
        }
        return this.regexpcode3;
    }

    public boolean isRegExpCode3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegExpCode3Dirty();
        }
        return this.regexpcode3DirtyFlag;
    }

    public void resetRegExpCode3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegExpCode3();
            return;
        }
        this.regexpcode3DirtyFlag = false;
        this.regexpcode3 = null;
    }

    public void setRegExpCode4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegExpCode4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.regexpcode4 = string;
        this.regexpcode4DirtyFlag = true;
    }

    public String getRegExpCode4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegExpCode4();
        }
        return this.regexpcode4;
    }

    public boolean isRegExpCode4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegExpCode4Dirty();
        }
        return this.regexpcode4DirtyFlag;
    }

    public void resetRegExpCode4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegExpCode4();
            return;
        }
        this.regexpcode4DirtyFlag = false;
        this.regexpcode4 = null;
    }

    public void setRIPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRIPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ripslanresid = string;
        this.ripslanresidDirtyFlag = true;
    }

    public String getRIPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRIPSLanResId();
        }
        return this.ripslanresid;
    }

    public boolean isRIPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRIPSLanResIdDirty();
        }
        return this.ripslanresidDirtyFlag;
    }

    public void resetRIPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRIPSLanResId();
            return;
        }
        this.ripslanresidDirtyFlag = false;
        this.ripslanresid = null;
    }

    public void setRIPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRIPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ripslanresname = string;
        this.ripslanresnameDirtyFlag = true;
    }

    public String getRIPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRIPSLanResName();
        }
        return this.ripslanresname;
    }

    public boolean isRIPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRIPSLanResNameDirty();
        }
        return this.ripslanresnameDirtyFlag;
    }

    public void resetRIPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRIPSLanResName();
            return;
        }
        this.ripslanresnameDirtyFlag = false;
        this.ripslanresname = null;
    }

    public void setRuleHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleHolder(n);
            return;
        }
        this.ruleholder = n;
        this.ruleholderDirtyFlag = true;
    }

    public Integer getRuleHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleHolder();
        }
        return this.ruleholder;
    }

    public boolean isRuleHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleHolderDirty();
        }
        return this.ruleholderDirtyFlag;
    }

    public void resetRuleHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleHolder();
            return;
        }
        this.ruleholderDirtyFlag = false;
        this.ruleholder = null;
    }

    public void setRuleInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruleinfo = string;
        this.ruleinfoDirtyFlag = true;
    }

    public String getRuleInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleInfo();
        }
        return this.ruleinfo;
    }

    public boolean isRuleInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleInfoDirty();
        }
        return this.ruleinfoDirtyFlag;
    }

    public void resetRuleInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleInfo();
            return;
        }
        this.ruleinfoDirtyFlag = false;
        this.ruleinfo = null;
    }

    public void setRuleTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruletag = string;
        this.ruletagDirtyFlag = true;
    }

    public String getRuleTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleTag();
        }
        return this.ruletag;
    }

    public boolean isRuleTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleTagDirty();
        }
        return this.ruletagDirtyFlag;
    }

    public void resetRuleTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleTag();
            return;
        }
        this.ruletagDirtyFlag = false;
        this.ruletag = null;
    }

    public void setRuleTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruletag2 = string;
        this.ruletag2DirtyFlag = true;
    }

    public String getRuleTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleTag2();
        }
        return this.ruletag2;
    }

    public boolean isRuleTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleTag2Dirty();
        }
        return this.ruletag2DirtyFlag;
    }

    public void resetRuleTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleTag2();
            return;
        }
        this.ruletag2DirtyFlag = false;
        this.ruletag2 = null;
    }

    public void setRuleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruletype = string;
        this.ruletypeDirtyFlag = true;
    }

    public String getRuleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleType();
        }
        return this.ruletype;
    }

    public boolean isRuleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleTypeDirty();
        }
        return this.ruletypeDirtyFlag;
    }

    public void resetRuleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleType();
            return;
        }
        this.ruletypeDirtyFlag = false;
        this.ruletype = null;
    }

    public void setScript(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScript(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.script = string;
        this.scriptDirtyFlag = true;
    }

    public String getScript() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScript();
        }
        return this.script;
    }

    public boolean isScriptDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScriptDirty();
        }
        return this.scriptDirtyFlag;
    }

    public void resetScript() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScript();
            return;
        }
        this.scriptDirtyFlag = false;
        this.script = null;
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
        PSSysValueRuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysValueRuleBase pSSysValueRuleBase) {
        pSSysValueRuleBase.resetBeginTime();
        pSSysValueRuleBase.resetBeginValue();
        pSSysValueRuleBase.resetCodeName();
        pSSysValueRuleBase.resetCreateDate();
        pSSysValueRuleBase.resetCreateMan();
        pSSysValueRuleBase.resetCustomObj();
        pSSysValueRuleBase.resetCustomParams();
        pSSysValueRuleBase.resetDynaModelFlag();
        pSSysValueRuleBase.resetEndTime();
        pSSysValueRuleBase.resetEndValue();
        pSSysValueRuleBase.resetIncBeginValue();
        pSSysValueRuleBase.resetIncEndValue();
        pSSysValueRuleBase.resetLockFlag();
        pSSysValueRuleBase.resetMemo();
        pSSysValueRuleBase.resetPSDynaInstId();
        pSSysValueRuleBase.resetPSModuleId();
        pSSysValueRuleBase.resetPSModuleName();
        pSSysValueRuleBase.resetPSSysDynaModelId();
        pSSysValueRuleBase.resetPSSysDynaModelName();
        pSSysValueRuleBase.resetPSSysPFPluginId();
        pSSysValueRuleBase.resetPSSysPFPluginName();
        pSSysValueRuleBase.resetPSSysSFPluginId();
        pSSysValueRuleBase.resetPSSysSFPluginName();
        pSSysValueRuleBase.resetPSSystemId();
        pSSysValueRuleBase.resetPSSystemName();
        pSSysValueRuleBase.resetPSSysValueRuleId();
        pSSysValueRuleBase.resetPSSysValueRuleName();
        pSSysValueRuleBase.resetPSValueRuleId();
        pSSysValueRuleBase.resetPSValueRuleName();
        pSSysValueRuleBase.resetRegExpCode();
        pSSysValueRuleBase.resetRegExpCode2();
        pSSysValueRuleBase.resetRegExpCode3();
        pSSysValueRuleBase.resetRegExpCode4();
        pSSysValueRuleBase.resetRIPSLanResId();
        pSSysValueRuleBase.resetRIPSLanResName();
        pSSysValueRuleBase.resetRuleHolder();
        pSSysValueRuleBase.resetRuleInfo();
        pSSysValueRuleBase.resetRuleTag();
        pSSysValueRuleBase.resetRuleTag2();
        pSSysValueRuleBase.resetRuleType();
        pSSysValueRuleBase.resetScript();
        pSSysValueRuleBase.resetUpdateDate();
        pSSysValueRuleBase.resetUpdateMan();
        pSSysValueRuleBase.resetUserCat();
        pSSysValueRuleBase.resetUserTag();
        pSSysValueRuleBase.resetUserTag2();
        pSSysValueRuleBase.resetUserTag3();
        pSSysValueRuleBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isBeginValueDirty()) {
            hashMap.put(FIELD_BEGINVALUE, this.getBeginValue());
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
        if (!bl || this.isCustomObjDirty()) {
            hashMap.put(FIELD_CUSTOMOBJ, this.getCustomObj());
        }
        if (!bl || this.isCustomParamsDirty()) {
            hashMap.put(FIELD_CUSTOMPARAMS, this.getCustomParams());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isEndValueDirty()) {
            hashMap.put(FIELD_ENDVALUE, this.getEndValue());
        }
        if (!bl || this.isIncBeginValueDirty()) {
            hashMap.put(FIELD_INCBEGINVALUE, this.getIncBeginValue());
        }
        if (!bl || this.isIncEndValueDirty()) {
            hashMap.put(FIELD_INCENDVALUE, this.getIncEndValue());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
        }
        if (!bl || this.isPSValueRuleIdDirty()) {
            hashMap.put(FIELD_PSVALUERULEID, this.getPSValueRuleId());
        }
        if (!bl || this.isPSValueRuleNameDirty()) {
            hashMap.put(FIELD_PSVALUERULENAME, this.getPSValueRuleName());
        }
        if (!bl || this.isRegExpCodeDirty()) {
            hashMap.put(FIELD_REGEXPCODE, this.getRegExpCode());
        }
        if (!bl || this.isRegExpCode2Dirty()) {
            hashMap.put(FIELD_REGEXPCODE2, this.getRegExpCode2());
        }
        if (!bl || this.isRegExpCode3Dirty()) {
            hashMap.put(FIELD_REGEXPCODE3, this.getRegExpCode3());
        }
        if (!bl || this.isRegExpCode4Dirty()) {
            hashMap.put(FIELD_REGEXPCODE4, this.getRegExpCode4());
        }
        if (!bl || this.isRIPSLanResIdDirty()) {
            hashMap.put(FIELD_RIPSLANRESID, this.getRIPSLanResId());
        }
        if (!bl || this.isRIPSLanResNameDirty()) {
            hashMap.put(FIELD_RIPSLANRESNAME, this.getRIPSLanResName());
        }
        if (!bl || this.isRuleHolderDirty()) {
            hashMap.put(FIELD_RULEHOLDER, this.getRuleHolder());
        }
        if (!bl || this.isRuleInfoDirty()) {
            hashMap.put(FIELD_RULEINFO, this.getRuleInfo());
        }
        if (!bl || this.isRuleTagDirty()) {
            hashMap.put(FIELD_RULETAG, this.getRuleTag());
        }
        if (!bl || this.isRuleTag2Dirty()) {
            hashMap.put(FIELD_RULETAG2, this.getRuleTag2());
        }
        if (!bl || this.isRuleTypeDirty()) {
            hashMap.put(FIELD_RULETYPE, this.getRuleType());
        }
        if (!bl || this.isScriptDirty()) {
            hashMap.put(FIELD_SCRIPT, this.getScript());
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
        return PSSysValueRuleBase.get(this, n);
    }

    private static Object get(PSSysValueRuleBase pSSysValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysValueRuleBase.getBeginTime();
            }
            case 1: {
                return pSSysValueRuleBase.getBeginValue();
            }
            case 2: {
                return pSSysValueRuleBase.getCodeName();
            }
            case 3: {
                return pSSysValueRuleBase.getCreateDate();
            }
            case 4: {
                return pSSysValueRuleBase.getCreateMan();
            }
            case 5: {
                return pSSysValueRuleBase.getCustomObj();
            }
            case 6: {
                return pSSysValueRuleBase.getCustomParams();
            }
            case 7: {
                return pSSysValueRuleBase.getDynaModelFlag();
            }
            case 8: {
                return pSSysValueRuleBase.getEndTime();
            }
            case 9: {
                return pSSysValueRuleBase.getEndValue();
            }
            case 10: {
                return pSSysValueRuleBase.getIncBeginValue();
            }
            case 11: {
                return pSSysValueRuleBase.getIncEndValue();
            }
            case 12: {
                return pSSysValueRuleBase.getLockFlag();
            }
            case 13: {
                return pSSysValueRuleBase.getMemo();
            }
            case 14: {
                return pSSysValueRuleBase.getPSDynaInstId();
            }
            case 15: {
                return pSSysValueRuleBase.getPSModuleId();
            }
            case 16: {
                return pSSysValueRuleBase.getPSModuleName();
            }
            case 17: {
                return pSSysValueRuleBase.getPSSysDynaModelId();
            }
            case 18: {
                return pSSysValueRuleBase.getPSSysDynaModelName();
            }
            case 19: {
                return pSSysValueRuleBase.getPSSysPFPluginId();
            }
            case 20: {
                return pSSysValueRuleBase.getPSSysPFPluginName();
            }
            case 21: {
                return pSSysValueRuleBase.getPSSysSFPluginId();
            }
            case 22: {
                return pSSysValueRuleBase.getPSSysSFPluginName();
            }
            case 23: {
                return pSSysValueRuleBase.getPSSystemId();
            }
            case 24: {
                return pSSysValueRuleBase.getPSSystemName();
            }
            case 25: {
                return pSSysValueRuleBase.getPSSysValueRuleId();
            }
            case 26: {
                return pSSysValueRuleBase.getPSSysValueRuleName();
            }
            case 27: {
                return pSSysValueRuleBase.getPSValueRuleId();
            }
            case 28: {
                return pSSysValueRuleBase.getPSValueRuleName();
            }
            case 29: {
                return pSSysValueRuleBase.getRegExpCode();
            }
            case 30: {
                return pSSysValueRuleBase.getRegExpCode2();
            }
            case 31: {
                return pSSysValueRuleBase.getRegExpCode3();
            }
            case 32: {
                return pSSysValueRuleBase.getRegExpCode4();
            }
            case 33: {
                return pSSysValueRuleBase.getRIPSLanResId();
            }
            case 34: {
                return pSSysValueRuleBase.getRIPSLanResName();
            }
            case 35: {
                return pSSysValueRuleBase.getRuleHolder();
            }
            case 36: {
                return pSSysValueRuleBase.getRuleInfo();
            }
            case 37: {
                return pSSysValueRuleBase.getRuleTag();
            }
            case 38: {
                return pSSysValueRuleBase.getRuleTag2();
            }
            case 39: {
                return pSSysValueRuleBase.getRuleType();
            }
            case 40: {
                return pSSysValueRuleBase.getScript();
            }
            case 41: {
                return pSSysValueRuleBase.getUpdateDate();
            }
            case 42: {
                return pSSysValueRuleBase.getUpdateMan();
            }
            case 43: {
                return pSSysValueRuleBase.getUserCat();
            }
            case 44: {
                return pSSysValueRuleBase.getUserTag();
            }
            case 45: {
                return pSSysValueRuleBase.getUserTag2();
            }
            case 46: {
                return pSSysValueRuleBase.getUserTag3();
            }
            case 47: {
                return pSSysValueRuleBase.getUserTag4();
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
        PSSysValueRuleBase.set(this, n, object);
    }

    private static void set(PSSysValueRuleBase pSSysValueRuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysValueRuleBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysValueRuleBase.setBeginValue(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 2: {
                pSSysValueRuleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysValueRuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysValueRuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysValueRuleBase.setCustomObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysValueRuleBase.setCustomParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysValueRuleBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysValueRuleBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSysValueRuleBase.setEndValue(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 10: {
                pSSysValueRuleBase.setIncBeginValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysValueRuleBase.setIncEndValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysValueRuleBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysValueRuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysValueRuleBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysValueRuleBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysValueRuleBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysValueRuleBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysValueRuleBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysValueRuleBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysValueRuleBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysValueRuleBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysValueRuleBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysValueRuleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysValueRuleBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysValueRuleBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysValueRuleBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysValueRuleBase.setPSValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysValueRuleBase.setPSValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysValueRuleBase.setRegExpCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysValueRuleBase.setRegExpCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysValueRuleBase.setRegExpCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysValueRuleBase.setRegExpCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysValueRuleBase.setRIPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysValueRuleBase.setRIPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysValueRuleBase.setRuleHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSysValueRuleBase.setRuleInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysValueRuleBase.setRuleTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysValueRuleBase.setRuleTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysValueRuleBase.setRuleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysValueRuleBase.setScript(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysValueRuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSSysValueRuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysValueRuleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysValueRuleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysValueRuleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysValueRuleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysValueRuleBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysValueRuleBase.isNull(this, n);
    }

    private static boolean isNull(PSSysValueRuleBase pSSysValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysValueRuleBase.getBeginTime() == null;
            }
            case 1: {
                return pSSysValueRuleBase.getBeginValue() == null;
            }
            case 2: {
                return pSSysValueRuleBase.getCodeName() == null;
            }
            case 3: {
                return pSSysValueRuleBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysValueRuleBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysValueRuleBase.getCustomObj() == null;
            }
            case 6: {
                return pSSysValueRuleBase.getCustomParams() == null;
            }
            case 7: {
                return pSSysValueRuleBase.getDynaModelFlag() == null;
            }
            case 8: {
                return pSSysValueRuleBase.getEndTime() == null;
            }
            case 9: {
                return pSSysValueRuleBase.getEndValue() == null;
            }
            case 10: {
                return pSSysValueRuleBase.getIncBeginValue() == null;
            }
            case 11: {
                return pSSysValueRuleBase.getIncEndValue() == null;
            }
            case 12: {
                return pSSysValueRuleBase.getLockFlag() == null;
            }
            case 13: {
                return pSSysValueRuleBase.getMemo() == null;
            }
            case 14: {
                return pSSysValueRuleBase.getPSDynaInstId() == null;
            }
            case 15: {
                return pSSysValueRuleBase.getPSModuleId() == null;
            }
            case 16: {
                return pSSysValueRuleBase.getPSModuleName() == null;
            }
            case 17: {
                return pSSysValueRuleBase.getPSSysDynaModelId() == null;
            }
            case 18: {
                return pSSysValueRuleBase.getPSSysDynaModelName() == null;
            }
            case 19: {
                return pSSysValueRuleBase.getPSSysPFPluginId() == null;
            }
            case 20: {
                return pSSysValueRuleBase.getPSSysPFPluginName() == null;
            }
            case 21: {
                return pSSysValueRuleBase.getPSSysSFPluginId() == null;
            }
            case 22: {
                return pSSysValueRuleBase.getPSSysSFPluginName() == null;
            }
            case 23: {
                return pSSysValueRuleBase.getPSSystemId() == null;
            }
            case 24: {
                return pSSysValueRuleBase.getPSSystemName() == null;
            }
            case 25: {
                return pSSysValueRuleBase.getPSSysValueRuleId() == null;
            }
            case 26: {
                return pSSysValueRuleBase.getPSSysValueRuleName() == null;
            }
            case 27: {
                return pSSysValueRuleBase.getPSValueRuleId() == null;
            }
            case 28: {
                return pSSysValueRuleBase.getPSValueRuleName() == null;
            }
            case 29: {
                return pSSysValueRuleBase.getRegExpCode() == null;
            }
            case 30: {
                return pSSysValueRuleBase.getRegExpCode2() == null;
            }
            case 31: {
                return pSSysValueRuleBase.getRegExpCode3() == null;
            }
            case 32: {
                return pSSysValueRuleBase.getRegExpCode4() == null;
            }
            case 33: {
                return pSSysValueRuleBase.getRIPSLanResId() == null;
            }
            case 34: {
                return pSSysValueRuleBase.getRIPSLanResName() == null;
            }
            case 35: {
                return pSSysValueRuleBase.getRuleHolder() == null;
            }
            case 36: {
                return pSSysValueRuleBase.getRuleInfo() == null;
            }
            case 37: {
                return pSSysValueRuleBase.getRuleTag() == null;
            }
            case 38: {
                return pSSysValueRuleBase.getRuleTag2() == null;
            }
            case 39: {
                return pSSysValueRuleBase.getRuleType() == null;
            }
            case 40: {
                return pSSysValueRuleBase.getScript() == null;
            }
            case 41: {
                return pSSysValueRuleBase.getUpdateDate() == null;
            }
            case 42: {
                return pSSysValueRuleBase.getUpdateMan() == null;
            }
            case 43: {
                return pSSysValueRuleBase.getUserCat() == null;
            }
            case 44: {
                return pSSysValueRuleBase.getUserTag() == null;
            }
            case 45: {
                return pSSysValueRuleBase.getUserTag2() == null;
            }
            case 46: {
                return pSSysValueRuleBase.getUserTag3() == null;
            }
            case 47: {
                return pSSysValueRuleBase.getUserTag4() == null;
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
        return PSSysValueRuleBase.contains(this, n);
    }

    private static boolean contains(PSSysValueRuleBase pSSysValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysValueRuleBase.isBeginTimeDirty();
            }
            case 1: {
                return pSSysValueRuleBase.isBeginValueDirty();
            }
            case 2: {
                return pSSysValueRuleBase.isCodeNameDirty();
            }
            case 3: {
                return pSSysValueRuleBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysValueRuleBase.isCreateManDirty();
            }
            case 5: {
                return pSSysValueRuleBase.isCustomObjDirty();
            }
            case 6: {
                return pSSysValueRuleBase.isCustomParamsDirty();
            }
            case 7: {
                return pSSysValueRuleBase.isDynaModelFlagDirty();
            }
            case 8: {
                return pSSysValueRuleBase.isEndTimeDirty();
            }
            case 9: {
                return pSSysValueRuleBase.isEndValueDirty();
            }
            case 10: {
                return pSSysValueRuleBase.isIncBeginValueDirty();
            }
            case 11: {
                return pSSysValueRuleBase.isIncEndValueDirty();
            }
            case 12: {
                return pSSysValueRuleBase.isLockFlagDirty();
            }
            case 13: {
                return pSSysValueRuleBase.isMemoDirty();
            }
            case 14: {
                return pSSysValueRuleBase.isPSDynaInstIdDirty();
            }
            case 15: {
                return pSSysValueRuleBase.isPSModuleIdDirty();
            }
            case 16: {
                return pSSysValueRuleBase.isPSModuleNameDirty();
            }
            case 17: {
                return pSSysValueRuleBase.isPSSysDynaModelIdDirty();
            }
            case 18: {
                return pSSysValueRuleBase.isPSSysDynaModelNameDirty();
            }
            case 19: {
                return pSSysValueRuleBase.isPSSysPFPluginIdDirty();
            }
            case 20: {
                return pSSysValueRuleBase.isPSSysPFPluginNameDirty();
            }
            case 21: {
                return pSSysValueRuleBase.isPSSysSFPluginIdDirty();
            }
            case 22: {
                return pSSysValueRuleBase.isPSSysSFPluginNameDirty();
            }
            case 23: {
                return pSSysValueRuleBase.isPSSystemIdDirty();
            }
            case 24: {
                return pSSysValueRuleBase.isPSSystemNameDirty();
            }
            case 25: {
                return pSSysValueRuleBase.isPSSysValueRuleIdDirty();
            }
            case 26: {
                return pSSysValueRuleBase.isPSSysValueRuleNameDirty();
            }
            case 27: {
                return pSSysValueRuleBase.isPSValueRuleIdDirty();
            }
            case 28: {
                return pSSysValueRuleBase.isPSValueRuleNameDirty();
            }
            case 29: {
                return pSSysValueRuleBase.isRegExpCodeDirty();
            }
            case 30: {
                return pSSysValueRuleBase.isRegExpCode2Dirty();
            }
            case 31: {
                return pSSysValueRuleBase.isRegExpCode3Dirty();
            }
            case 32: {
                return pSSysValueRuleBase.isRegExpCode4Dirty();
            }
            case 33: {
                return pSSysValueRuleBase.isRIPSLanResIdDirty();
            }
            case 34: {
                return pSSysValueRuleBase.isRIPSLanResNameDirty();
            }
            case 35: {
                return pSSysValueRuleBase.isRuleHolderDirty();
            }
            case 36: {
                return pSSysValueRuleBase.isRuleInfoDirty();
            }
            case 37: {
                return pSSysValueRuleBase.isRuleTagDirty();
            }
            case 38: {
                return pSSysValueRuleBase.isRuleTag2Dirty();
            }
            case 39: {
                return pSSysValueRuleBase.isRuleTypeDirty();
            }
            case 40: {
                return pSSysValueRuleBase.isScriptDirty();
            }
            case 41: {
                return pSSysValueRuleBase.isUpdateDateDirty();
            }
            case 42: {
                return pSSysValueRuleBase.isUpdateManDirty();
            }
            case 43: {
                return pSSysValueRuleBase.isUserCatDirty();
            }
            case 44: {
                return pSSysValueRuleBase.isUserTagDirty();
            }
            case 45: {
                return pSSysValueRuleBase.isUserTag2Dirty();
            }
            case 46: {
                return pSSysValueRuleBase.isUserTag3Dirty();
            }
            case 47: {
                return pSSysValueRuleBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysValueRuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysValueRuleBase pSSysValueRuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysValueRuleBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getBeginValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginvalue", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getBeginValue()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getCustomObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customobj", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getCustomObj()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getCustomParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customparams", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getCustomParams()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getEndTime()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getEndValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endvalue", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getEndValue()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getIncBeginValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incbeginvalue", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getIncBeginValue()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getIncEndValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incendvalue", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getIncEndValue()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvalueruleid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSValueRuleId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getPSValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvaluerulename", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getPSValueRuleName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRegExpCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"regexpcode", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRegExpCode()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRegExpCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"regexpcode2", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRegExpCode2()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRegExpCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"regexpcode3", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRegExpCode3()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRegExpCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"regexpcode4", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRegExpCode4()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRIPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ripslanresid", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRIPSLanResId()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRIPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ripslanresname", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRIPSLanResName()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRuleHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruleholder", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRuleHolder()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRuleInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruleinfo", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRuleInfo()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRuleTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruletag", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRuleTag()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRuleTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruletag2", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRuleTag2()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getRuleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruletype", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getRuleType()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getScript() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"script", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getScript()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysValueRuleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysValueRuleBase.getJSONValue((Object)pSSysValueRuleBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysValueRuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysValueRuleBase pSSysValueRuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysValueRuleBase.getBeginTime() != null) {
            object = pSSysValueRuleBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getBeginValue() != null) {
            object = pSSysValueRuleBase.getBeginValue();
            xmlNode.setAttribute(FIELD_BEGINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getCodeName() != null) {
            object = pSSysValueRuleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getCreateDate() != null) {
            object = pSSysValueRuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getCreateMan() != null) {
            object = pSSysValueRuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getCustomObj() != null) {
            object = pSSysValueRuleBase.getCustomObj();
            xmlNode.setAttribute(FIELD_CUSTOMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getCustomParams() != null) {
            object = pSSysValueRuleBase.getCustomParams();
            xmlNode.setAttribute(FIELD_CUSTOMPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getDynaModelFlag() != null) {
            object = pSSysValueRuleBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getEndTime() != null) {
            object = pSSysValueRuleBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getEndValue() != null) {
            object = pSSysValueRuleBase.getEndValue();
            xmlNode.setAttribute(FIELD_ENDVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getIncBeginValue() != null) {
            object = pSSysValueRuleBase.getIncBeginValue();
            xmlNode.setAttribute(FIELD_INCBEGINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getIncEndValue() != null) {
            object = pSSysValueRuleBase.getIncEndValue();
            xmlNode.setAttribute(FIELD_INCENDVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getLockFlag() != null) {
            object = pSSysValueRuleBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getMemo() != null) {
            object = pSSysValueRuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSDynaInstId() != null) {
            object = pSSysValueRuleBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSModuleId() != null) {
            object = pSSysValueRuleBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSModuleName() != null) {
            object = pSSysValueRuleBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSysDynaModelId() != null) {
            object = pSSysValueRuleBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSysDynaModelName() != null) {
            object = pSSysValueRuleBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSysPFPluginId() != null) {
            object = pSSysValueRuleBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSysPFPluginName() != null) {
            object = pSSysValueRuleBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSysSFPluginId() != null) {
            object = pSSysValueRuleBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSysSFPluginName() != null) {
            object = pSSysValueRuleBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSystemId() != null) {
            object = pSSysValueRuleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSystemName() != null) {
            object = pSSysValueRuleBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSysValueRuleId() != null) {
            object = pSSysValueRuleBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSSysValueRuleName() != null) {
            object = pSSysValueRuleBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSValueRuleId() != null) {
            object = pSSysValueRuleBase.getPSValueRuleId();
            xmlNode.setAttribute(FIELD_PSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getPSValueRuleName() != null) {
            object = pSSysValueRuleBase.getPSValueRuleName();
            xmlNode.setAttribute(FIELD_PSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRegExpCode() != null) {
            object = pSSysValueRuleBase.getRegExpCode();
            xmlNode.setAttribute(FIELD_REGEXPCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRegExpCode2() != null) {
            object = pSSysValueRuleBase.getRegExpCode2();
            xmlNode.setAttribute(FIELD_REGEXPCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRegExpCode3() != null) {
            object = pSSysValueRuleBase.getRegExpCode3();
            xmlNode.setAttribute(FIELD_REGEXPCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRegExpCode4() != null) {
            object = pSSysValueRuleBase.getRegExpCode4();
            xmlNode.setAttribute(FIELD_REGEXPCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRIPSLanResId() != null) {
            object = pSSysValueRuleBase.getRIPSLanResId();
            xmlNode.setAttribute(FIELD_RIPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRIPSLanResName() != null) {
            object = pSSysValueRuleBase.getRIPSLanResName();
            xmlNode.setAttribute(FIELD_RIPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRuleHolder() != null) {
            object = pSSysValueRuleBase.getRuleHolder();
            xmlNode.setAttribute(FIELD_RULEHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getRuleInfo() != null) {
            object = pSSysValueRuleBase.getRuleInfo();
            xmlNode.setAttribute(FIELD_RULEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRuleTag() != null) {
            object = pSSysValueRuleBase.getRuleTag();
            xmlNode.setAttribute(FIELD_RULETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRuleTag2() != null) {
            object = pSSysValueRuleBase.getRuleTag2();
            xmlNode.setAttribute(FIELD_RULETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getRuleType() != null) {
            object = pSSysValueRuleBase.getRuleType();
            xmlNode.setAttribute(FIELD_RULETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getScript() != null) {
            object = pSSysValueRuleBase.getScript();
            xmlNode.setAttribute(FIELD_SCRIPT, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getUpdateDate() != null) {
            object = pSSysValueRuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysValueRuleBase.getUpdateMan() != null) {
            object = pSSysValueRuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getUserCat() != null) {
            object = pSSysValueRuleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getUserTag() != null) {
            object = pSSysValueRuleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getUserTag2() != null) {
            object = pSSysValueRuleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getUserTag3() != null) {
            object = pSSysValueRuleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysValueRuleBase.getUserTag4() != null) {
            object = pSSysValueRuleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysValueRuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysValueRuleBase pSSysValueRuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysValueRuleBase.isBeginTimeDirty() && (bl || pSSysValueRuleBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSSysValueRuleBase.getBeginTime());
        }
        if (pSSysValueRuleBase.isBeginValueDirty() && (bl || pSSysValueRuleBase.getBeginValue() != null)) {
            iDataObject.set(FIELD_BEGINVALUE, (Object)pSSysValueRuleBase.getBeginValue());
        }
        if (pSSysValueRuleBase.isCodeNameDirty() && (bl || pSSysValueRuleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysValueRuleBase.getCodeName());
        }
        if (pSSysValueRuleBase.isCreateDateDirty() && (bl || pSSysValueRuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysValueRuleBase.getCreateDate());
        }
        if (pSSysValueRuleBase.isCreateManDirty() && (bl || pSSysValueRuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysValueRuleBase.getCreateMan());
        }
        if (pSSysValueRuleBase.isCustomObjDirty() && (bl || pSSysValueRuleBase.getCustomObj() != null)) {
            iDataObject.set(FIELD_CUSTOMOBJ, (Object)pSSysValueRuleBase.getCustomObj());
        }
        if (pSSysValueRuleBase.isCustomParamsDirty() && (bl || pSSysValueRuleBase.getCustomParams() != null)) {
            iDataObject.set(FIELD_CUSTOMPARAMS, (Object)pSSysValueRuleBase.getCustomParams());
        }
        if (pSSysValueRuleBase.isDynaModelFlagDirty() && (bl || pSSysValueRuleBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSSysValueRuleBase.getDynaModelFlag());
        }
        if (pSSysValueRuleBase.isEndTimeDirty() && (bl || pSSysValueRuleBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSSysValueRuleBase.getEndTime());
        }
        if (pSSysValueRuleBase.isEndValueDirty() && (bl || pSSysValueRuleBase.getEndValue() != null)) {
            iDataObject.set(FIELD_ENDVALUE, (Object)pSSysValueRuleBase.getEndValue());
        }
        if (pSSysValueRuleBase.isIncBeginValueDirty() && (bl || pSSysValueRuleBase.getIncBeginValue() != null)) {
            iDataObject.set(FIELD_INCBEGINVALUE, (Object)pSSysValueRuleBase.getIncBeginValue());
        }
        if (pSSysValueRuleBase.isIncEndValueDirty() && (bl || pSSysValueRuleBase.getIncEndValue() != null)) {
            iDataObject.set(FIELD_INCENDVALUE, (Object)pSSysValueRuleBase.getIncEndValue());
        }
        if (pSSysValueRuleBase.isLockFlagDirty() && (bl || pSSysValueRuleBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysValueRuleBase.getLockFlag());
        }
        if (pSSysValueRuleBase.isMemoDirty() && (bl || pSSysValueRuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysValueRuleBase.getMemo());
        }
        if (pSSysValueRuleBase.isPSDynaInstIdDirty() && (bl || pSSysValueRuleBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysValueRuleBase.getPSDynaInstId());
        }
        if (pSSysValueRuleBase.isPSModuleIdDirty() && (bl || pSSysValueRuleBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysValueRuleBase.getPSModuleId());
        }
        if (pSSysValueRuleBase.isPSModuleNameDirty() && (bl || pSSysValueRuleBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysValueRuleBase.getPSModuleName());
        }
        if (pSSysValueRuleBase.isPSSysDynaModelIdDirty() && (bl || pSSysValueRuleBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysValueRuleBase.getPSSysDynaModelId());
        }
        if (pSSysValueRuleBase.isPSSysDynaModelNameDirty() && (bl || pSSysValueRuleBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysValueRuleBase.getPSSysDynaModelName());
        }
        if (pSSysValueRuleBase.isPSSysPFPluginIdDirty() && (bl || pSSysValueRuleBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysValueRuleBase.getPSSysPFPluginId());
        }
        if (pSSysValueRuleBase.isPSSysPFPluginNameDirty() && (bl || pSSysValueRuleBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysValueRuleBase.getPSSysPFPluginName());
        }
        if (pSSysValueRuleBase.isPSSysSFPluginIdDirty() && (bl || pSSysValueRuleBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysValueRuleBase.getPSSysSFPluginId());
        }
        if (pSSysValueRuleBase.isPSSysSFPluginNameDirty() && (bl || pSSysValueRuleBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysValueRuleBase.getPSSysSFPluginName());
        }
        if (pSSysValueRuleBase.isPSSystemIdDirty() && (bl || pSSysValueRuleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysValueRuleBase.getPSSystemId());
        }
        if (pSSysValueRuleBase.isPSSystemNameDirty() && (bl || pSSysValueRuleBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysValueRuleBase.getPSSystemName());
        }
        if (pSSysValueRuleBase.isPSSysValueRuleIdDirty() && (bl || pSSysValueRuleBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        }
        if (pSSysValueRuleBase.isPSSysValueRuleNameDirty() && (bl || pSSysValueRuleBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSSysValueRuleBase.getPSSysValueRuleName());
        }
        if (pSSysValueRuleBase.isPSValueRuleIdDirty() && (bl || pSSysValueRuleBase.getPSValueRuleId() != null)) {
            iDataObject.set(FIELD_PSVALUERULEID, (Object)pSSysValueRuleBase.getPSValueRuleId());
        }
        if (pSSysValueRuleBase.isPSValueRuleNameDirty() && (bl || pSSysValueRuleBase.getPSValueRuleName() != null)) {
            iDataObject.set(FIELD_PSVALUERULENAME, (Object)pSSysValueRuleBase.getPSValueRuleName());
        }
        if (pSSysValueRuleBase.isRegExpCodeDirty() && (bl || pSSysValueRuleBase.getRegExpCode() != null)) {
            iDataObject.set(FIELD_REGEXPCODE, (Object)pSSysValueRuleBase.getRegExpCode());
        }
        if (pSSysValueRuleBase.isRegExpCode2Dirty() && (bl || pSSysValueRuleBase.getRegExpCode2() != null)) {
            iDataObject.set(FIELD_REGEXPCODE2, (Object)pSSysValueRuleBase.getRegExpCode2());
        }
        if (pSSysValueRuleBase.isRegExpCode3Dirty() && (bl || pSSysValueRuleBase.getRegExpCode3() != null)) {
            iDataObject.set(FIELD_REGEXPCODE3, (Object)pSSysValueRuleBase.getRegExpCode3());
        }
        if (pSSysValueRuleBase.isRegExpCode4Dirty() && (bl || pSSysValueRuleBase.getRegExpCode4() != null)) {
            iDataObject.set(FIELD_REGEXPCODE4, (Object)pSSysValueRuleBase.getRegExpCode4());
        }
        if (pSSysValueRuleBase.isRIPSLanResIdDirty() && (bl || pSSysValueRuleBase.getRIPSLanResId() != null)) {
            iDataObject.set(FIELD_RIPSLANRESID, (Object)pSSysValueRuleBase.getRIPSLanResId());
        }
        if (pSSysValueRuleBase.isRIPSLanResNameDirty() && (bl || pSSysValueRuleBase.getRIPSLanResName() != null)) {
            iDataObject.set(FIELD_RIPSLANRESNAME, (Object)pSSysValueRuleBase.getRIPSLanResName());
        }
        if (pSSysValueRuleBase.isRuleHolderDirty() && (bl || pSSysValueRuleBase.getRuleHolder() != null)) {
            iDataObject.set(FIELD_RULEHOLDER, (Object)pSSysValueRuleBase.getRuleHolder());
        }
        if (pSSysValueRuleBase.isRuleInfoDirty() && (bl || pSSysValueRuleBase.getRuleInfo() != null)) {
            iDataObject.set(FIELD_RULEINFO, (Object)pSSysValueRuleBase.getRuleInfo());
        }
        if (pSSysValueRuleBase.isRuleTagDirty() && (bl || pSSysValueRuleBase.getRuleTag() != null)) {
            iDataObject.set(FIELD_RULETAG, (Object)pSSysValueRuleBase.getRuleTag());
        }
        if (pSSysValueRuleBase.isRuleTag2Dirty() && (bl || pSSysValueRuleBase.getRuleTag2() != null)) {
            iDataObject.set(FIELD_RULETAG2, (Object)pSSysValueRuleBase.getRuleTag2());
        }
        if (pSSysValueRuleBase.isRuleTypeDirty() && (bl || pSSysValueRuleBase.getRuleType() != null)) {
            iDataObject.set(FIELD_RULETYPE, (Object)pSSysValueRuleBase.getRuleType());
        }
        if (pSSysValueRuleBase.isScriptDirty() && (bl || pSSysValueRuleBase.getScript() != null)) {
            iDataObject.set(FIELD_SCRIPT, (Object)pSSysValueRuleBase.getScript());
        }
        if (pSSysValueRuleBase.isUpdateDateDirty() && (bl || pSSysValueRuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysValueRuleBase.getUpdateDate());
        }
        if (pSSysValueRuleBase.isUpdateManDirty() && (bl || pSSysValueRuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysValueRuleBase.getUpdateMan());
        }
        if (pSSysValueRuleBase.isUserCatDirty() && (bl || pSSysValueRuleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysValueRuleBase.getUserCat());
        }
        if (pSSysValueRuleBase.isUserTagDirty() && (bl || pSSysValueRuleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysValueRuleBase.getUserTag());
        }
        if (pSSysValueRuleBase.isUserTag2Dirty() && (bl || pSSysValueRuleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysValueRuleBase.getUserTag2());
        }
        if (pSSysValueRuleBase.isUserTag3Dirty() && (bl || pSSysValueRuleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysValueRuleBase.getUserTag3());
        }
        if (pSSysValueRuleBase.isUserTag4Dirty() && (bl || pSSysValueRuleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysValueRuleBase.getUserTag4());
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
        return PSSysValueRuleBase.remove(this, n);
    }

    private static boolean remove(PSSysValueRuleBase pSSysValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysValueRuleBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSSysValueRuleBase.resetBeginValue();
                return true;
            }
            case 2: {
                pSSysValueRuleBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSysValueRuleBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysValueRuleBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysValueRuleBase.resetCustomObj();
                return true;
            }
            case 6: {
                pSSysValueRuleBase.resetCustomParams();
                return true;
            }
            case 7: {
                pSSysValueRuleBase.resetDynaModelFlag();
                return true;
            }
            case 8: {
                pSSysValueRuleBase.resetEndTime();
                return true;
            }
            case 9: {
                pSSysValueRuleBase.resetEndValue();
                return true;
            }
            case 10: {
                pSSysValueRuleBase.resetIncBeginValue();
                return true;
            }
            case 11: {
                pSSysValueRuleBase.resetIncEndValue();
                return true;
            }
            case 12: {
                pSSysValueRuleBase.resetLockFlag();
                return true;
            }
            case 13: {
                pSSysValueRuleBase.resetMemo();
                return true;
            }
            case 14: {
                pSSysValueRuleBase.resetPSDynaInstId();
                return true;
            }
            case 15: {
                pSSysValueRuleBase.resetPSModuleId();
                return true;
            }
            case 16: {
                pSSysValueRuleBase.resetPSModuleName();
                return true;
            }
            case 17: {
                pSSysValueRuleBase.resetPSSysDynaModelId();
                return true;
            }
            case 18: {
                pSSysValueRuleBase.resetPSSysDynaModelName();
                return true;
            }
            case 19: {
                pSSysValueRuleBase.resetPSSysPFPluginId();
                return true;
            }
            case 20: {
                pSSysValueRuleBase.resetPSSysPFPluginName();
                return true;
            }
            case 21: {
                pSSysValueRuleBase.resetPSSysSFPluginId();
                return true;
            }
            case 22: {
                pSSysValueRuleBase.resetPSSysSFPluginName();
                return true;
            }
            case 23: {
                pSSysValueRuleBase.resetPSSystemId();
                return true;
            }
            case 24: {
                pSSysValueRuleBase.resetPSSystemName();
                return true;
            }
            case 25: {
                pSSysValueRuleBase.resetPSSysValueRuleId();
                return true;
            }
            case 26: {
                pSSysValueRuleBase.resetPSSysValueRuleName();
                return true;
            }
            case 27: {
                pSSysValueRuleBase.resetPSValueRuleId();
                return true;
            }
            case 28: {
                pSSysValueRuleBase.resetPSValueRuleName();
                return true;
            }
            case 29: {
                pSSysValueRuleBase.resetRegExpCode();
                return true;
            }
            case 30: {
                pSSysValueRuleBase.resetRegExpCode2();
                return true;
            }
            case 31: {
                pSSysValueRuleBase.resetRegExpCode3();
                return true;
            }
            case 32: {
                pSSysValueRuleBase.resetRegExpCode4();
                return true;
            }
            case 33: {
                pSSysValueRuleBase.resetRIPSLanResId();
                return true;
            }
            case 34: {
                pSSysValueRuleBase.resetRIPSLanResName();
                return true;
            }
            case 35: {
                pSSysValueRuleBase.resetRuleHolder();
                return true;
            }
            case 36: {
                pSSysValueRuleBase.resetRuleInfo();
                return true;
            }
            case 37: {
                pSSysValueRuleBase.resetRuleTag();
                return true;
            }
            case 38: {
                pSSysValueRuleBase.resetRuleTag2();
                return true;
            }
            case 39: {
                pSSysValueRuleBase.resetRuleType();
                return true;
            }
            case 40: {
                pSSysValueRuleBase.resetScript();
                return true;
            }
            case 41: {
                pSSysValueRuleBase.resetUpdateDate();
                return true;
            }
            case 42: {
                pSSysValueRuleBase.resetUpdateMan();
                return true;
            }
            case 43: {
                pSSysValueRuleBase.resetUserCat();
                return true;
            }
            case 44: {
                pSSysValueRuleBase.resetUserTag();
                return true;
            }
            case 45: {
                pSSysValueRuleBase.resetUserTag2();
                return true;
            }
            case 46: {
                pSSysValueRuleBase.resetUserTag3();
                return true;
            }
            case 47: {
                pSSysValueRuleBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getRIPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRIPSLanRes();
        }
        if (this.getRIPSLanResId() == null) {
            return null;
        }
        Integer n = this.objRIPSLanResLock;
        synchronized (n) {
            if (this.ripslanres != null && DataTypeHelper.compare((int)25, (Object)this.getRIPSLanResId(), (Object)this.ripslanres.getPSLanguageResId()) != 0L) {
                this.ripslanres = null;
            }
            if (this.ripslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getRIPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.ripslanres = pSLanguageRes;
            }
            return this.ripslanres;
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
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSValueRule getPSValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRule();
        }
        if (this.getPSValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSValueRuleLock;
        synchronized (n) {
            if (this.psvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSValueRuleId(), (Object)this.psvaluerule.getPSValueRuleId()) != 0L) {
                this.psvaluerule = null;
            }
            if (this.psvaluerule == null) {
                PSValueRule pSValueRule = new PSValueRule();
                pSValueRule.setPSValueRuleId(this.getPSValueRuleId());
                PSValueRuleService pSValueRuleService = (PSValueRuleService)ServiceGlobal.getService(PSValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSValueRuleService.autoGet((IEntity)pSValueRule);
                this.psvaluerule = pSValueRule;
            }
            return this.psvaluerule;
        }
    }

    private PSSysValueRuleBase getProxyEntity() {
        return this.proxyPSSysValueRuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysValueRuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysValueRuleBase) {
            this.proxyPSSysValueRuleBase = (PSSysValueRuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_BEGINVALUE, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CUSTOMOBJ, 5);
        fieldIndexMap.put(FIELD_CUSTOMPARAMS, 6);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 7);
        fieldIndexMap.put(FIELD_ENDTIME, 8);
        fieldIndexMap.put(FIELD_ENDVALUE, 9);
        fieldIndexMap.put(FIELD_INCBEGINVALUE, 10);
        fieldIndexMap.put(FIELD_INCENDVALUE, 11);
        fieldIndexMap.put(FIELD_LOCKFLAG, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 14);
        fieldIndexMap.put(FIELD_PSMODULEID, 15);
        fieldIndexMap.put(FIELD_PSMODULENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 17);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 21);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 23);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 25);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 26);
        fieldIndexMap.put(FIELD_PSVALUERULEID, 27);
        fieldIndexMap.put(FIELD_PSVALUERULENAME, 28);
        fieldIndexMap.put(FIELD_REGEXPCODE, 29);
        fieldIndexMap.put(FIELD_REGEXPCODE2, 30);
        fieldIndexMap.put(FIELD_REGEXPCODE3, 31);
        fieldIndexMap.put(FIELD_REGEXPCODE4, 32);
        fieldIndexMap.put(FIELD_RIPSLANRESID, 33);
        fieldIndexMap.put(FIELD_RIPSLANRESNAME, 34);
        fieldIndexMap.put(FIELD_RULEHOLDER, 35);
        fieldIndexMap.put(FIELD_RULEINFO, 36);
        fieldIndexMap.put(FIELD_RULETAG, 37);
        fieldIndexMap.put(FIELD_RULETAG2, 38);
        fieldIndexMap.put(FIELD_RULETYPE, 39);
        fieldIndexMap.put(FIELD_SCRIPT, 40);
        fieldIndexMap.put(FIELD_UPDATEDATE, 41);
        fieldIndexMap.put(FIELD_UPDATEMAN, 42);
        fieldIndexMap.put(FIELD_USERCAT, 43);
        fieldIndexMap.put(FIELD_USERTAG, 44);
        fieldIndexMap.put(FIELD_USERTAG2, 45);
        fieldIndexMap.put(FIELD_USERTAG3, 46);
        fieldIndexMap.put(FIELD_USERTAG4, 47);
    }
}

