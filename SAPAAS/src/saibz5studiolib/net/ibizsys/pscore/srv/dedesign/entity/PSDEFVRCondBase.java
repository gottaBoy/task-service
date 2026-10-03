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
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFVRCondBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFVRCondBase.class);
    public static final String FIELD_CONDTAG = "CONDTAG";
    public static final String FIELD_CONDTAG2 = "CONDTAG2";
    public static final String FIELD_CONDTYPE = "CONDTYPE";
    public static final String FIELD_CONDVALUE = "CONDVALUE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMDEFNAME = "CUSTOMDEFNAME";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EXTMAJORPSDEFID = "EXTMAJORPSDEFID";
    public static final String FIELD_EXTMAJORPSDEFNAME = "EXTMAJORPSDEFNAME";
    public static final String FIELD_EXTMINORPSDEFID = "EXTMINORPSDEFID";
    public static final String FIELD_EXTMINORPSDEFNAME = "EXTMINORPSDEFNAME";
    public static final String FIELD_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String FIELD_GROUPOP = "GROUPOP";
    public static final String FIELD_KEYCONDFLAG = "KEYCONDFLAG";
    public static final String FIELD_LEVELTAG = "LEVELTAG";
    public static final String FIELD_LEVELVALUE = "LEVELVALUE";
    public static final String FIELD_MAJORPSDEDSID = "MAJORPSDEDSTID";
    public static final String FIELD_MAJORPSDEDSNAME = "MAJORPSDEDSTNAME";
    public static final String FIELD_MAJORPSDEID = "MAJORPSDEID";
    public static final String FIELD_MAJORPSDENAME = "MAJORPSDENAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM10 = "PARAM10";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PARAM9 = "PARAM9";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PPSDEFVRCONDID = "PPSDEFVRCONDID";
    public static final String FIELD_PPSDEFVRCONDNAME = "PPSDEFVRCONDNAME";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFVRCONDID = "PSDEFVRCONDID";
    public static final String FIELD_PSDEFVRCONDNAME = "PSDEFVRCONDNAME";
    public static final String FIELD_PSDEFVRID = "PSDEFVRID";
    public static final String FIELD_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_RIPSLANRESID = "RIPSLANRESID";
    public static final String FIELD_RIPSLANRESNAME = "RIPSLANRESNAME";
    public static final String FIELD_RULEINFO = "RULEINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CONDTAG = 0;
    private static final int INDEX_CONDTAG2 = 1;
    private static final int INDEX_CONDTYPE = 2;
    private static final int INDEX_CONDVALUE = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_CUSTOMDEFNAME = 6;
    private static final int INDEX_DYNAMODELFLAG = 7;
    private static final int INDEX_EXTMAJORPSDEFID = 8;
    private static final int INDEX_EXTMAJORPSDEFNAME = 9;
    private static final int INDEX_EXTMINORPSDEFID = 10;
    private static final int INDEX_EXTMINORPSDEFNAME = 11;
    private static final int INDEX_GROUPNOTFLAG = 12;
    private static final int INDEX_GROUPOP = 13;
    private static final int INDEX_KEYCONDFLAG = 14;
    private static final int INDEX_LEVELTAG = 15;
    private static final int INDEX_LEVELVALUE = 16;
    private static final int INDEX_MAJORPSDEDSID = 17;
    private static final int INDEX_MAJORPSDEDSNAME = 18;
    private static final int INDEX_MAJORPSDEID = 19;
    private static final int INDEX_MAJORPSDENAME = 20;
    private static final int INDEX_MEMO = 21;
    private static final int INDEX_ORDERVALUE = 22;
    private static final int INDEX_PARAM = 23;
    private static final int INDEX_PARAM10 = 24;
    private static final int INDEX_PARAM2 = 25;
    private static final int INDEX_PARAM3 = 26;
    private static final int INDEX_PARAM4 = 27;
    private static final int INDEX_PARAM5 = 28;
    private static final int INDEX_PARAM6 = 29;
    private static final int INDEX_PARAM7 = 30;
    private static final int INDEX_PARAM8 = 31;
    private static final int INDEX_PARAM9 = 32;
    private static final int INDEX_PARAMTYPE = 33;
    private static final int INDEX_PPSDEFVRCONDID = 34;
    private static final int INDEX_PPSDEFVRCONDNAME = 35;
    private static final int INDEX_PSDBVALUEOPID = 36;
    private static final int INDEX_PSDBVALUEOPNAME = 37;
    private static final int INDEX_PSDEDQID = 38;
    private static final int INDEX_PSDEDQNAME = 39;
    private static final int INDEX_PSDEFID = 40;
    private static final int INDEX_PSDEFNAME = 41;
    private static final int INDEX_PSDEFVRCONDID = 42;
    private static final int INDEX_PSDEFVRCONDNAME = 43;
    private static final int INDEX_PSDEFVRID = 44;
    private static final int INDEX_PSDEFVRNAME = 45;
    private static final int INDEX_PSDYNAINSTID = 46;
    private static final int INDEX_PSSYSVALUERULEID = 47;
    private static final int INDEX_PSSYSVALUERULENAME = 48;
    private static final int INDEX_RIPSLANRESID = 49;
    private static final int INDEX_RIPSLANRESNAME = 50;
    private static final int INDEX_RULEINFO = 51;
    private static final int INDEX_UPDATEDATE = 52;
    private static final int INDEX_UPDATEMAN = 53;
    private static final int INDEX_USERTAG = 54;
    private static final int INDEX_USERTAG2 = 55;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFVRCondBase proxyPSDEFVRCondBase = null;
    private boolean condtagDirtyFlag = false;
    private boolean condtag2DirtyFlag = false;
    private boolean condtypeDirtyFlag = false;
    private boolean condvalueDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customdefnameDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean extmajorpsdefidDirtyFlag = false;
    private boolean extmajorpsdefnameDirtyFlag = false;
    private boolean extminorpsdefidDirtyFlag = false;
    private boolean extminorpsdefnameDirtyFlag = false;
    private boolean groupnotflagDirtyFlag = false;
    private boolean groupopDirtyFlag = false;
    private boolean keycondflagDirtyFlag = false;
    private boolean leveltagDirtyFlag = false;
    private boolean levelvalueDirtyFlag = false;
    private boolean majorpsdedsidDirtyFlag = false;
    private boolean majorpsdedsnameDirtyFlag = false;
    private boolean majorpsdeidDirtyFlag = false;
    private boolean majorpsdenameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param10DirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean param9DirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean ppsdefvrcondidDirtyFlag = false;
    private boolean ppsdefvrcondnameDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdefvrcondidDirtyFlag = false;
    private boolean psdefvrcondnameDirtyFlag = false;
    private boolean psdefvridDirtyFlag = false;
    private boolean psdefvrnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean ripslanresidDirtyFlag = false;
    private boolean ripslanresnameDirtyFlag = false;
    private boolean ruleinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="condtag")
    private String condtag;
    @Column(name="condtag2")
    private String condtag2;
    @Column(name="condtype")
    private String condtype;
    @Column(name="condvalue")
    private String condvalue;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customdefname")
    private String customdefname;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="extmajorpsdefid")
    private String extmajorpsdefid;
    @Column(name="extmajorpsdefname")
    private String extmajorpsdefname;
    @Column(name="extminorpsdefid")
    private String extminorpsdefid;
    @Column(name="extminorpsdefname")
    private String extminorpsdefname;
    @Column(name="groupnotflag")
    private Integer groupnotflag;
    @Column(name="groupop")
    private String groupop;
    @Column(name="keycondflag")
    private Integer keycondflag;
    @Column(name="leveltag")
    private String leveltag;
    @Column(name="levelvalue")
    private Integer levelvalue;
    @Column(name="majorpsdedsid")
    private String majorpsdedsid;
    @Column(name="majorpsdedsname")
    private String majorpsdedsname;
    @Column(name="majorpsdeid")
    private String majorpsdeid;
    @Column(name="majorpsdename")
    private String majorpsdename;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="param")
    private String param;
    @Column(name="param10")
    private Integer param10;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private Integer param3;
    @Column(name="param4")
    private Integer param4;
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Double param7;
    @Column(name="param8")
    private Double param8;
    @Column(name="param9")
    private Integer param9;
    @Column(name="paramtype")
    private String paramtype;
    @Column(name="ppsdefvrcondid")
    private String ppsdefvrcondid;
    @Column(name="ppsdefvrcondname")
    private String ppsdefvrcondname;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdefvrcondid")
    private String psdefvrcondid;
    @Column(name="psdefvrcondname")
    private String psdefvrcondname;
    @Column(name="psdefvrid")
    private String psdefvrid;
    @Column(name="psdefvrname")
    private String psdefvrname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
    @Column(name="ripslanresid")
    private String ripslanresid;
    @Column(name="ripslanresname")
    private String ripslanresname;
    @Column(name="ruleinfo")
    private String ruleinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objMajorPSDELock = new Integer(1);
    private PSDataEntity majorpsde = null;
    private Integer objPSDBValueOPLock = new Integer(1);
    private PSDBValueOP psdbvalueop = null;
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objMajorPSDEDSLock = new Integer(1);
    private PSDEDataSet majorpsdeds = null;
    private Integer objExtMajorPSDEFLock = new Integer(1);
    private PSDEField extmajorpsdef = null;
    private Integer objExtMinorPSDEFLock = new Integer(1);
    private PSDEField extminorpsdef = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEFVRLock = new Integer(1);
    private PSDEFValueRule psdefvr = null;
    private Integer objPPSDEFVRCondLock = new Integer(1);
    private PSDEFVRCond ppsdefvrcond = null;
    private Integer objRIPSLanResLock = new Integer(1);
    private PSLanguageRes ripslanres = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;
    private Integer objPSDEFVRCondsLock = new Integer(1);
    private ArrayList<PSDEFVRCond> psdefvrconds = null;

    public void setCondTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtag = string;
        this.condtagDirtyFlag = true;
    }

    public String getCondTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondTag();
        }
        return this.condtag;
    }

    public boolean isCondTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTagDirty();
        }
        return this.condtagDirtyFlag;
    }

    public void resetCondTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondTag();
            return;
        }
        this.condtagDirtyFlag = false;
        this.condtag = null;
    }

    public void setCondTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtag2 = string;
        this.condtag2DirtyFlag = true;
    }

    public String getCondTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondTag2();
        }
        return this.condtag2;
    }

    public boolean isCondTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTag2Dirty();
        }
        return this.condtag2DirtyFlag;
    }

    public void resetCondTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondTag2();
            return;
        }
        this.condtag2DirtyFlag = false;
        this.condtag2 = null;
    }

    public void setCondType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtype = string;
        this.condtypeDirtyFlag = true;
    }

    public String getCondType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondType();
        }
        return this.condtype;
    }

    public boolean isCondTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTypeDirty();
        }
        return this.condtypeDirtyFlag;
    }

    public void resetCondType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondType();
            return;
        }
        this.condtypeDirtyFlag = false;
        this.condtype = null;
    }

    public void setCondValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condvalue = string;
        this.condvalueDirtyFlag = true;
    }

    public String getCondValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondValue();
        }
        return this.condvalue;
    }

    public boolean isCondValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondValueDirty();
        }
        return this.condvalueDirtyFlag;
    }

    public void resetCondValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondValue();
            return;
        }
        this.condvalueDirtyFlag = false;
        this.condvalue = null;
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

    public void setCustomDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customdefname = string;
        this.customdefnameDirtyFlag = true;
    }

    public String getCustomDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomDEFName();
        }
        return this.customdefname;
    }

    public boolean isCustomDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomDEFNameDirty();
        }
        return this.customdefnameDirtyFlag;
    }

    public void resetCustomDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomDEFName();
            return;
        }
        this.customdefnameDirtyFlag = false;
        this.customdefname = null;
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

    public void setExtMajorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtMajorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extmajorpsdefid = string;
        this.extmajorpsdefidDirtyFlag = true;
    }

    public String getExtMajorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtMajorPSDEFId();
        }
        return this.extmajorpsdefid;
    }

    public boolean isExtMajorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtMajorPSDEFIdDirty();
        }
        return this.extmajorpsdefidDirtyFlag;
    }

    public void resetExtMajorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtMajorPSDEFId();
            return;
        }
        this.extmajorpsdefidDirtyFlag = false;
        this.extmajorpsdefid = null;
    }

    public void setExtMajorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtMajorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extmajorpsdefname = string;
        this.extmajorpsdefnameDirtyFlag = true;
    }

    public String getExtMajorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtMajorPSDEFName();
        }
        return this.extmajorpsdefname;
    }

    public boolean isExtMajorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtMajorPSDEFNameDirty();
        }
        return this.extmajorpsdefnameDirtyFlag;
    }

    public void resetExtMajorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtMajorPSDEFName();
            return;
        }
        this.extmajorpsdefnameDirtyFlag = false;
        this.extmajorpsdefname = null;
    }

    public void setExtMinorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtMinorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extminorpsdefid = string;
        this.extminorpsdefidDirtyFlag = true;
    }

    public String getExtMinorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtMinorPSDEFId();
        }
        return this.extminorpsdefid;
    }

    public boolean isExtMinorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtMinorPSDEFIdDirty();
        }
        return this.extminorpsdefidDirtyFlag;
    }

    public void resetExtMinorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtMinorPSDEFId();
            return;
        }
        this.extminorpsdefidDirtyFlag = false;
        this.extminorpsdefid = null;
    }

    public void setExtMinorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtMinorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extminorpsdefname = string;
        this.extminorpsdefnameDirtyFlag = true;
    }

    public String getExtMinorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtMinorPSDEFName();
        }
        return this.extminorpsdefname;
    }

    public boolean isExtMinorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtMinorPSDEFNameDirty();
        }
        return this.extminorpsdefnameDirtyFlag;
    }

    public void resetExtMinorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtMinorPSDEFName();
            return;
        }
        this.extminorpsdefnameDirtyFlag = false;
        this.extminorpsdefname = null;
    }

    public void setGroupNotFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupNotFlag(n);
            return;
        }
        this.groupnotflag = n;
        this.groupnotflagDirtyFlag = true;
    }

    public Integer getGroupNotFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupNotFlag();
        }
        return this.groupnotflag;
    }

    public boolean isGroupNotFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupNotFlagDirty();
        }
        return this.groupnotflagDirtyFlag;
    }

    public void resetGroupNotFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupNotFlag();
            return;
        }
        this.groupnotflagDirtyFlag = false;
        this.groupnotflag = null;
    }

    public void setGroupOP(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupOP(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupop = string;
        this.groupopDirtyFlag = true;
    }

    public String getGroupOP() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupOP();
        }
        return this.groupop;
    }

    public boolean isGroupOPDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupOPDirty();
        }
        return this.groupopDirtyFlag;
    }

    public void resetGroupOP() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupOP();
            return;
        }
        this.groupopDirtyFlag = false;
        this.groupop = null;
    }

    public void setKeyCondFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyCondFlag(n);
            return;
        }
        this.keycondflag = n;
        this.keycondflagDirtyFlag = true;
    }

    public Integer getKeyCondFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyCondFlag();
        }
        return this.keycondflag;
    }

    public boolean isKeyCondFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyCondFlagDirty();
        }
        return this.keycondflagDirtyFlag;
    }

    public void resetKeyCondFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyCondFlag();
            return;
        }
        this.keycondflagDirtyFlag = false;
        this.keycondflag = null;
    }

    public void setLevelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leveltag = string;
        this.leveltagDirtyFlag = true;
    }

    public String getLevelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelTag();
        }
        return this.leveltag;
    }

    public boolean isLevelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelTagDirty();
        }
        return this.leveltagDirtyFlag;
    }

    public void resetLevelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelTag();
            return;
        }
        this.leveltagDirtyFlag = false;
        this.leveltag = null;
    }

    public void setLevelValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelValue(n);
            return;
        }
        this.levelvalue = n;
        this.levelvalueDirtyFlag = true;
    }

    public Integer getLevelValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelValue();
        }
        return this.levelvalue;
    }

    public boolean isLevelValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelValueDirty();
        }
        return this.levelvalueDirtyFlag;
    }

    public void resetLevelValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelValue();
            return;
        }
        this.levelvalueDirtyFlag = false;
        this.levelvalue = null;
    }

    public void setMajorPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdedsid = string;
        this.majorpsdedsidDirtyFlag = true;
    }

    public String getMajorPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEDSId();
        }
        return this.majorpsdedsid;
    }

    public boolean isMajorPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEDSIdDirty();
        }
        return this.majorpsdedsidDirtyFlag;
    }

    public void resetMajorPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEDSId();
            return;
        }
        this.majorpsdedsidDirtyFlag = false;
        this.majorpsdedsid = null;
    }

    public void setMajorPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdedsname = string;
        this.majorpsdedsnameDirtyFlag = true;
    }

    public String getMajorPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEDSName();
        }
        return this.majorpsdedsname;
    }

    public boolean isMajorPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEDSNameDirty();
        }
        return this.majorpsdedsnameDirtyFlag;
    }

    public void resetMajorPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEDSName();
            return;
        }
        this.majorpsdedsnameDirtyFlag = false;
        this.majorpsdedsname = null;
    }

    public void setMajorPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdeid = string;
        this.majorpsdeidDirtyFlag = true;
    }

    public String getMajorPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEId();
        }
        return this.majorpsdeid;
    }

    public boolean isMajorPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEIdDirty();
        }
        return this.majorpsdeidDirtyFlag;
    }

    public void resetMajorPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEId();
            return;
        }
        this.majorpsdeidDirtyFlag = false;
        this.majorpsdeid = null;
    }

    public void setMajorPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdename = string;
        this.majorpsdenameDirtyFlag = true;
    }

    public String getMajorPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEName();
        }
        return this.majorpsdename;
    }

    public boolean isMajorPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDENameDirty();
        }
        return this.majorpsdenameDirtyFlag;
    }

    public void resetMajorPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEName();
            return;
        }
        this.majorpsdenameDirtyFlag = false;
        this.majorpsdename = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam10(n);
            return;
        }
        this.param10 = n;
        this.param10DirtyFlag = true;
    }

    public Integer getParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam10();
        }
        return this.param10;
    }

    public boolean isParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam10Dirty();
        }
        return this.param10DirtyFlag;
    }

    public void resetParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam10();
            return;
        }
        this.param10DirtyFlag = false;
        this.param10 = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(n);
            return;
        }
        this.param3 = n;
        this.param3DirtyFlag = true;
    }

    public Integer getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(n);
            return;
        }
        this.param4 = n;
        this.param4DirtyFlag = true;
    }

    public Integer getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(n);
            return;
        }
        this.param5 = n;
        this.param5DirtyFlag = true;
    }

    public Integer getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(n);
            return;
        }
        this.param6 = n;
        this.param6DirtyFlag = true;
    }

    public Integer getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(d);
            return;
        }
        this.param7 = d;
        this.param7DirtyFlag = true;
    }

    public Double getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(d);
            return;
        }
        this.param8 = d;
        this.param8DirtyFlag = true;
    }

    public Double getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam9(n);
            return;
        }
        this.param9 = n;
        this.param9DirtyFlag = true;
    }

    public Integer getParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam9();
        }
        return this.param9;
    }

    public boolean isParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam9Dirty();
        }
        return this.param9DirtyFlag;
    }

    public void resetParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam9();
            return;
        }
        this.param9DirtyFlag = false;
        this.param9 = null;
    }

    public void setParamType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtype = string;
        this.paramtypeDirtyFlag = true;
    }

    public String getParamType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamType();
        }
        return this.paramtype;
    }

    public boolean isParamTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTypeDirty();
        }
        return this.paramtypeDirtyFlag;
    }

    public void resetParamType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamType();
            return;
        }
        this.paramtypeDirtyFlag = false;
        this.paramtype = null;
    }

    public void setPPSDEFVRCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEFVRCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdefvrcondid = string;
        this.ppsdefvrcondidDirtyFlag = true;
    }

    public String getPPSDEFVRCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFVRCondId();
        }
        return this.ppsdefvrcondid;
    }

    public boolean isPPSDEFVRCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEFVRCondIdDirty();
        }
        return this.ppsdefvrcondidDirtyFlag;
    }

    public void resetPPSDEFVRCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEFVRCondId();
            return;
        }
        this.ppsdefvrcondidDirtyFlag = false;
        this.ppsdefvrcondid = null;
    }

    public void setPPSDEFVRCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEFVRCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdefvrcondname = string;
        this.ppsdefvrcondnameDirtyFlag = true;
    }

    public String getPPSDEFVRCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFVRCondName();
        }
        return this.ppsdefvrcondname;
    }

    public boolean isPPSDEFVRCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEFVRCondNameDirty();
        }
        return this.ppsdefvrcondnameDirtyFlag;
    }

    public void resetPPSDEFVRCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEFVRCondName();
            return;
        }
        this.ppsdefvrcondnameDirtyFlag = false;
        this.ppsdefvrcondname = null;
    }

    public void setPSDBValueOPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopid = string;
        this.psdbvalueopidDirtyFlag = true;
    }

    public String getPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPId();
        }
        return this.psdbvalueopid;
    }

    public boolean isPSDBValueOPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPIdDirty();
        }
        return this.psdbvalueopidDirtyFlag;
    }

    public void resetPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPId();
            return;
        }
        this.psdbvalueopidDirtyFlag = false;
        this.psdbvalueopid = null;
    }

    public void setPSDBValueOPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopname = string;
        this.psdbvalueopnameDirtyFlag = true;
    }

    public String getPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPName();
        }
        return this.psdbvalueopname;
    }

    public boolean isPSDBValueOPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPNameDirty();
        }
        return this.psdbvalueopnameDirtyFlag;
    }

    public void resetPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPName();
            return;
        }
        this.psdbvalueopnameDirtyFlag = false;
        this.psdbvalueopname = null;
    }

    public void setPSDEDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqid = string;
        this.psdedqidDirtyFlag = true;
    }

    public String getPSDEDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQId();
        }
        return this.psdedqid;
    }

    public boolean isPSDEDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQIdDirty();
        }
        return this.psdedqidDirtyFlag;
    }

    public void resetPSDEDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQId();
            return;
        }
        this.psdedqidDirtyFlag = false;
        this.psdedqid = null;
    }

    public void setPSDEDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqname = string;
        this.psdedqnameDirtyFlag = true;
    }

    public String getPSDEDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQName();
        }
        return this.psdedqname;
    }

    public boolean isPSDEDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQNameDirty();
        }
        return this.psdedqnameDirtyFlag;
    }

    public void resetPSDEDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQName();
            return;
        }
        this.psdedqnameDirtyFlag = false;
        this.psdedqname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
    }

    public void setPSDEFVRCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrcondid = string;
        this.psdefvrcondidDirtyFlag = true;
    }

    public String getPSDEFVRCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRCondId();
        }
        return this.psdefvrcondid;
    }

    public boolean isPSDEFVRCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRCondIdDirty();
        }
        return this.psdefvrcondidDirtyFlag;
    }

    public void resetPSDEFVRCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRCondId();
            return;
        }
        this.psdefvrcondidDirtyFlag = false;
        this.psdefvrcondid = null;
    }

    public void setPSDEFVRCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrcondname = string;
        this.psdefvrcondnameDirtyFlag = true;
    }

    public String getPSDEFVRCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRCondName();
        }
        return this.psdefvrcondname;
    }

    public boolean isPSDEFVRCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRCondNameDirty();
        }
        return this.psdefvrcondnameDirtyFlag;
    }

    public void resetPSDEFVRCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRCondName();
            return;
        }
        this.psdefvrcondnameDirtyFlag = false;
        this.psdefvrcondname = null;
    }

    public void setPSDEFVRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrid = string;
        this.psdefvridDirtyFlag = true;
    }

    public String getPSDEFVRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRId();
        }
        return this.psdefvrid;
    }

    public boolean isPSDEFVRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRIdDirty();
        }
        return this.psdefvridDirtyFlag;
    }

    public void resetPSDEFVRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRId();
            return;
        }
        this.psdefvridDirtyFlag = false;
        this.psdefvrid = null;
    }

    public void setPSDEFVRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrname = string;
        this.psdefvrnameDirtyFlag = true;
    }

    public String getPSDEFVRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRName();
        }
        return this.psdefvrname;
    }

    public boolean isPSDEFVRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRNameDirty();
        }
        return this.psdefvrnameDirtyFlag;
    }

    public void resetPSDEFVRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRName();
            return;
        }
        this.psdefvrnameDirtyFlag = false;
        this.psdefvrname = null;
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

    protected void onReset() {
        PSDEFVRCondBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFVRCondBase pSDEFVRCondBase) {
        pSDEFVRCondBase.resetCondTag();
        pSDEFVRCondBase.resetCondTag2();
        pSDEFVRCondBase.resetCondType();
        pSDEFVRCondBase.resetCondValue();
        pSDEFVRCondBase.resetCreateDate();
        pSDEFVRCondBase.resetCreateMan();
        pSDEFVRCondBase.resetCustomDEFName();
        pSDEFVRCondBase.resetDynaModelFlag();
        pSDEFVRCondBase.resetExtMajorPSDEFId();
        pSDEFVRCondBase.resetExtMajorPSDEFName();
        pSDEFVRCondBase.resetExtMinorPSDEFId();
        pSDEFVRCondBase.resetExtMinorPSDEFName();
        pSDEFVRCondBase.resetGroupNotFlag();
        pSDEFVRCondBase.resetGroupOP();
        pSDEFVRCondBase.resetKeyCondFlag();
        pSDEFVRCondBase.resetLevelTag();
        pSDEFVRCondBase.resetLevelValue();
        pSDEFVRCondBase.resetMajorPSDEDSId();
        pSDEFVRCondBase.resetMajorPSDEDSName();
        pSDEFVRCondBase.resetMajorPSDEId();
        pSDEFVRCondBase.resetMajorPSDEName();
        pSDEFVRCondBase.resetMemo();
        pSDEFVRCondBase.resetOrderValue();
        pSDEFVRCondBase.resetParam();
        pSDEFVRCondBase.resetParam10();
        pSDEFVRCondBase.resetParam2();
        pSDEFVRCondBase.resetParam3();
        pSDEFVRCondBase.resetParam4();
        pSDEFVRCondBase.resetParam5();
        pSDEFVRCondBase.resetParam6();
        pSDEFVRCondBase.resetParam7();
        pSDEFVRCondBase.resetParam8();
        pSDEFVRCondBase.resetParam9();
        pSDEFVRCondBase.resetParamType();
        pSDEFVRCondBase.resetPPSDEFVRCondId();
        pSDEFVRCondBase.resetPPSDEFVRCondName();
        pSDEFVRCondBase.resetPSDBValueOPId();
        pSDEFVRCondBase.resetPSDBValueOPName();
        pSDEFVRCondBase.resetPSDEDQId();
        pSDEFVRCondBase.resetPSDEDQName();
        pSDEFVRCondBase.resetPSDEFId();
        pSDEFVRCondBase.resetPSDEFName();
        pSDEFVRCondBase.resetPSDEFVRCondId();
        pSDEFVRCondBase.resetPSDEFVRCondName();
        pSDEFVRCondBase.resetPSDEFVRId();
        pSDEFVRCondBase.resetPSDEFVRName();
        pSDEFVRCondBase.resetPSDynaInstId();
        pSDEFVRCondBase.resetPSSysValueRuleId();
        pSDEFVRCondBase.resetPSSysValueRuleName();
        pSDEFVRCondBase.resetRIPSLanResId();
        pSDEFVRCondBase.resetRIPSLanResName();
        pSDEFVRCondBase.resetRuleInfo();
        pSDEFVRCondBase.resetUpdateDate();
        pSDEFVRCondBase.resetUpdateMan();
        pSDEFVRCondBase.resetUserTag();
        pSDEFVRCondBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondTagDirty()) {
            hashMap.put(FIELD_CONDTAG, this.getCondTag());
        }
        if (!bl || this.isCondTag2Dirty()) {
            hashMap.put(FIELD_CONDTAG2, this.getCondTag2());
        }
        if (!bl || this.isCondTypeDirty()) {
            hashMap.put(FIELD_CONDTYPE, this.getCondType());
        }
        if (!bl || this.isCondValueDirty()) {
            hashMap.put(FIELD_CONDVALUE, this.getCondValue());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomDEFNameDirty()) {
            hashMap.put(FIELD_CUSTOMDEFNAME, this.getCustomDEFName());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isExtMajorPSDEFIdDirty()) {
            hashMap.put(FIELD_EXTMAJORPSDEFID, this.getExtMajorPSDEFId());
        }
        if (!bl || this.isExtMajorPSDEFNameDirty()) {
            hashMap.put(FIELD_EXTMAJORPSDEFNAME, this.getExtMajorPSDEFName());
        }
        if (!bl || this.isExtMinorPSDEFIdDirty()) {
            hashMap.put(FIELD_EXTMINORPSDEFID, this.getExtMinorPSDEFId());
        }
        if (!bl || this.isExtMinorPSDEFNameDirty()) {
            hashMap.put(FIELD_EXTMINORPSDEFNAME, this.getExtMinorPSDEFName());
        }
        if (!bl || this.isGroupNotFlagDirty()) {
            hashMap.put(FIELD_GROUPNOTFLAG, this.getGroupNotFlag());
        }
        if (!bl || this.isGroupOPDirty()) {
            hashMap.put(FIELD_GROUPOP, this.getGroupOP());
        }
        if (!bl || this.isKeyCondFlagDirty()) {
            hashMap.put(FIELD_KEYCONDFLAG, this.getKeyCondFlag());
        }
        if (!bl || this.isLevelTagDirty()) {
            hashMap.put(FIELD_LEVELTAG, this.getLevelTag());
        }
        if (!bl || this.isLevelValueDirty()) {
            hashMap.put(FIELD_LEVELVALUE, this.getLevelValue());
        }
        if (!bl || this.isMajorPSDEDSIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEDSID, this.getMajorPSDEDSId());
        }
        if (!bl || this.isMajorPSDEDSNameDirty()) {
            hashMap.put(FIELD_MAJORPSDEDSNAME, this.getMajorPSDEDSName());
        }
        if (!bl || this.isMajorPSDEIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEID, this.getMajorPSDEId());
        }
        if (!bl || this.isMajorPSDENameDirty()) {
            hashMap.put(FIELD_MAJORPSDENAME, this.getMajorPSDEName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam10Dirty()) {
            hashMap.put(FIELD_PARAM10, this.getParam10());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isParam9Dirty()) {
            hashMap.put(FIELD_PARAM9, this.getParam9());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isPPSDEFVRCondIdDirty()) {
            hashMap.put(FIELD_PPSDEFVRCONDID, this.getPPSDEFVRCondId());
        }
        if (!bl || this.isPPSDEFVRCondNameDirty()) {
            hashMap.put(FIELD_PPSDEFVRCONDNAME, this.getPPSDEFVRCondName());
        }
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
        }
        if (!bl || this.isPSDEDQIdDirty()) {
            hashMap.put(FIELD_PSDEDQID, this.getPSDEDQId());
        }
        if (!bl || this.isPSDEDQNameDirty()) {
            hashMap.put(FIELD_PSDEDQNAME, this.getPSDEDQName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEFVRCondIdDirty()) {
            hashMap.put(FIELD_PSDEFVRCONDID, this.getPSDEFVRCondId());
        }
        if (!bl || this.isPSDEFVRCondNameDirty()) {
            hashMap.put(FIELD_PSDEFVRCONDNAME, this.getPSDEFVRCondName());
        }
        if (!bl || this.isPSDEFVRIdDirty()) {
            hashMap.put(FIELD_PSDEFVRID, this.getPSDEFVRId());
        }
        if (!bl || this.isPSDEFVRNameDirty()) {
            hashMap.put(FIELD_PSDEFVRNAME, this.getPSDEFVRName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
        }
        if (!bl || this.isRIPSLanResIdDirty()) {
            hashMap.put(FIELD_RIPSLANRESID, this.getRIPSLanResId());
        }
        if (!bl || this.isRIPSLanResNameDirty()) {
            hashMap.put(FIELD_RIPSLANRESNAME, this.getRIPSLanResName());
        }
        if (!bl || this.isRuleInfoDirty()) {
            hashMap.put(FIELD_RULEINFO, this.getRuleInfo());
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
        return PSDEFVRCondBase.get(this, n);
    }

    private static Object get(PSDEFVRCondBase pSDEFVRCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRCondBase.getCondTag();
            }
            case 1: {
                return pSDEFVRCondBase.getCondTag2();
            }
            case 2: {
                return pSDEFVRCondBase.getCondType();
            }
            case 3: {
                return pSDEFVRCondBase.getCondValue();
            }
            case 4: {
                return pSDEFVRCondBase.getCreateDate();
            }
            case 5: {
                return pSDEFVRCondBase.getCreateMan();
            }
            case 6: {
                return pSDEFVRCondBase.getCustomDEFName();
            }
            case 7: {
                return pSDEFVRCondBase.getDynaModelFlag();
            }
            case 8: {
                return pSDEFVRCondBase.getExtMajorPSDEFId();
            }
            case 9: {
                return pSDEFVRCondBase.getExtMajorPSDEFName();
            }
            case 10: {
                return pSDEFVRCondBase.getExtMinorPSDEFId();
            }
            case 11: {
                return pSDEFVRCondBase.getExtMinorPSDEFName();
            }
            case 12: {
                return pSDEFVRCondBase.getGroupNotFlag();
            }
            case 13: {
                return pSDEFVRCondBase.getGroupOP();
            }
            case 14: {
                return pSDEFVRCondBase.getKeyCondFlag();
            }
            case 15: {
                return pSDEFVRCondBase.getLevelTag();
            }
            case 16: {
                return pSDEFVRCondBase.getLevelValue();
            }
            case 17: {
                return pSDEFVRCondBase.getMajorPSDEDSId();
            }
            case 18: {
                return pSDEFVRCondBase.getMajorPSDEDSName();
            }
            case 19: {
                return pSDEFVRCondBase.getMajorPSDEId();
            }
            case 20: {
                return pSDEFVRCondBase.getMajorPSDEName();
            }
            case 21: {
                return pSDEFVRCondBase.getMemo();
            }
            case 22: {
                return pSDEFVRCondBase.getOrderValue();
            }
            case 23: {
                return pSDEFVRCondBase.getParam();
            }
            case 24: {
                return pSDEFVRCondBase.getParam10();
            }
            case 25: {
                return pSDEFVRCondBase.getParam2();
            }
            case 26: {
                return pSDEFVRCondBase.getParam3();
            }
            case 27: {
                return pSDEFVRCondBase.getParam4();
            }
            case 28: {
                return pSDEFVRCondBase.getParam5();
            }
            case 29: {
                return pSDEFVRCondBase.getParam6();
            }
            case 30: {
                return pSDEFVRCondBase.getParam7();
            }
            case 31: {
                return pSDEFVRCondBase.getParam8();
            }
            case 32: {
                return pSDEFVRCondBase.getParam9();
            }
            case 33: {
                return pSDEFVRCondBase.getParamType();
            }
            case 34: {
                return pSDEFVRCondBase.getPPSDEFVRCondId();
            }
            case 35: {
                return pSDEFVRCondBase.getPPSDEFVRCondName();
            }
            case 36: {
                return pSDEFVRCondBase.getPSDBValueOPId();
            }
            case 37: {
                return pSDEFVRCondBase.getPSDBValueOPName();
            }
            case 38: {
                return pSDEFVRCondBase.getPSDEDQId();
            }
            case 39: {
                return pSDEFVRCondBase.getPSDEDQName();
            }
            case 40: {
                return pSDEFVRCondBase.getPSDEFId();
            }
            case 41: {
                return pSDEFVRCondBase.getPSDEFName();
            }
            case 42: {
                return pSDEFVRCondBase.getPSDEFVRCondId();
            }
            case 43: {
                return pSDEFVRCondBase.getPSDEFVRCondName();
            }
            case 44: {
                return pSDEFVRCondBase.getPSDEFVRId();
            }
            case 45: {
                return pSDEFVRCondBase.getPSDEFVRName();
            }
            case 46: {
                return pSDEFVRCondBase.getPSDynaInstId();
            }
            case 47: {
                return pSDEFVRCondBase.getPSSysValueRuleId();
            }
            case 48: {
                return pSDEFVRCondBase.getPSSysValueRuleName();
            }
            case 49: {
                return pSDEFVRCondBase.getRIPSLanResId();
            }
            case 50: {
                return pSDEFVRCondBase.getRIPSLanResName();
            }
            case 51: {
                return pSDEFVRCondBase.getRuleInfo();
            }
            case 52: {
                return pSDEFVRCondBase.getUpdateDate();
            }
            case 53: {
                return pSDEFVRCondBase.getUpdateMan();
            }
            case 54: {
                return pSDEFVRCondBase.getUserTag();
            }
            case 55: {
                return pSDEFVRCondBase.getUserTag2();
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
        PSDEFVRCondBase.set(this, n, object);
    }

    private static void set(PSDEFVRCondBase pSDEFVRCondBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRCondBase.setCondTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEFVRCondBase.setCondTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFVRCondBase.setCondType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFVRCondBase.setCondValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFVRCondBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEFVRCondBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFVRCondBase.setCustomDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFVRCondBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEFVRCondBase.setExtMajorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFVRCondBase.setExtMajorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFVRCondBase.setExtMinorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFVRCondBase.setExtMinorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFVRCondBase.setGroupNotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEFVRCondBase.setGroupOP(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFVRCondBase.setKeyCondFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEFVRCondBase.setLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFVRCondBase.setLevelValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEFVRCondBase.setMajorPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFVRCondBase.setMajorPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFVRCondBase.setMajorPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFVRCondBase.setMajorPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFVRCondBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFVRCondBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEFVRCondBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFVRCondBase.setParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEFVRCondBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFVRCondBase.setParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEFVRCondBase.setParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEFVRCondBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEFVRCondBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEFVRCondBase.setParam7(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 31: {
                pSDEFVRCondBase.setParam8(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 32: {
                pSDEFVRCondBase.setParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEFVRCondBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFVRCondBase.setPPSDEFVRCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFVRCondBase.setPPSDEFVRCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEFVRCondBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEFVRCondBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEFVRCondBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEFVRCondBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEFVRCondBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEFVRCondBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEFVRCondBase.setPSDEFVRCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEFVRCondBase.setPSDEFVRCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEFVRCondBase.setPSDEFVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEFVRCondBase.setPSDEFVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEFVRCondBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEFVRCondBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEFVRCondBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEFVRCondBase.setRIPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEFVRCondBase.setRIPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEFVRCondBase.setRuleInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEFVRCondBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 53: {
                pSDEFVRCondBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEFVRCondBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEFVRCondBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDEFVRCondBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFVRCondBase pSDEFVRCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRCondBase.getCondTag() == null;
            }
            case 1: {
                return pSDEFVRCondBase.getCondTag2() == null;
            }
            case 2: {
                return pSDEFVRCondBase.getCondType() == null;
            }
            case 3: {
                return pSDEFVRCondBase.getCondValue() == null;
            }
            case 4: {
                return pSDEFVRCondBase.getCreateDate() == null;
            }
            case 5: {
                return pSDEFVRCondBase.getCreateMan() == null;
            }
            case 6: {
                return pSDEFVRCondBase.getCustomDEFName() == null;
            }
            case 7: {
                return pSDEFVRCondBase.getDynaModelFlag() == null;
            }
            case 8: {
                return pSDEFVRCondBase.getExtMajorPSDEFId() == null;
            }
            case 9: {
                return pSDEFVRCondBase.getExtMajorPSDEFName() == null;
            }
            case 10: {
                return pSDEFVRCondBase.getExtMinorPSDEFId() == null;
            }
            case 11: {
                return pSDEFVRCondBase.getExtMinorPSDEFName() == null;
            }
            case 12: {
                return pSDEFVRCondBase.getGroupNotFlag() == null;
            }
            case 13: {
                return pSDEFVRCondBase.getGroupOP() == null;
            }
            case 14: {
                return pSDEFVRCondBase.getKeyCondFlag() == null;
            }
            case 15: {
                return pSDEFVRCondBase.getLevelTag() == null;
            }
            case 16: {
                return pSDEFVRCondBase.getLevelValue() == null;
            }
            case 17: {
                return pSDEFVRCondBase.getMajorPSDEDSId() == null;
            }
            case 18: {
                return pSDEFVRCondBase.getMajorPSDEDSName() == null;
            }
            case 19: {
                return pSDEFVRCondBase.getMajorPSDEId() == null;
            }
            case 20: {
                return pSDEFVRCondBase.getMajorPSDEName() == null;
            }
            case 21: {
                return pSDEFVRCondBase.getMemo() == null;
            }
            case 22: {
                return pSDEFVRCondBase.getOrderValue() == null;
            }
            case 23: {
                return pSDEFVRCondBase.getParam() == null;
            }
            case 24: {
                return pSDEFVRCondBase.getParam10() == null;
            }
            case 25: {
                return pSDEFVRCondBase.getParam2() == null;
            }
            case 26: {
                return pSDEFVRCondBase.getParam3() == null;
            }
            case 27: {
                return pSDEFVRCondBase.getParam4() == null;
            }
            case 28: {
                return pSDEFVRCondBase.getParam5() == null;
            }
            case 29: {
                return pSDEFVRCondBase.getParam6() == null;
            }
            case 30: {
                return pSDEFVRCondBase.getParam7() == null;
            }
            case 31: {
                return pSDEFVRCondBase.getParam8() == null;
            }
            case 32: {
                return pSDEFVRCondBase.getParam9() == null;
            }
            case 33: {
                return pSDEFVRCondBase.getParamType() == null;
            }
            case 34: {
                return pSDEFVRCondBase.getPPSDEFVRCondId() == null;
            }
            case 35: {
                return pSDEFVRCondBase.getPPSDEFVRCondName() == null;
            }
            case 36: {
                return pSDEFVRCondBase.getPSDBValueOPId() == null;
            }
            case 37: {
                return pSDEFVRCondBase.getPSDBValueOPName() == null;
            }
            case 38: {
                return pSDEFVRCondBase.getPSDEDQId() == null;
            }
            case 39: {
                return pSDEFVRCondBase.getPSDEDQName() == null;
            }
            case 40: {
                return pSDEFVRCondBase.getPSDEFId() == null;
            }
            case 41: {
                return pSDEFVRCondBase.getPSDEFName() == null;
            }
            case 42: {
                return pSDEFVRCondBase.getPSDEFVRCondId() == null;
            }
            case 43: {
                return pSDEFVRCondBase.getPSDEFVRCondName() == null;
            }
            case 44: {
                return pSDEFVRCondBase.getPSDEFVRId() == null;
            }
            case 45: {
                return pSDEFVRCondBase.getPSDEFVRName() == null;
            }
            case 46: {
                return pSDEFVRCondBase.getPSDynaInstId() == null;
            }
            case 47: {
                return pSDEFVRCondBase.getPSSysValueRuleId() == null;
            }
            case 48: {
                return pSDEFVRCondBase.getPSSysValueRuleName() == null;
            }
            case 49: {
                return pSDEFVRCondBase.getRIPSLanResId() == null;
            }
            case 50: {
                return pSDEFVRCondBase.getRIPSLanResName() == null;
            }
            case 51: {
                return pSDEFVRCondBase.getRuleInfo() == null;
            }
            case 52: {
                return pSDEFVRCondBase.getUpdateDate() == null;
            }
            case 53: {
                return pSDEFVRCondBase.getUpdateMan() == null;
            }
            case 54: {
                return pSDEFVRCondBase.getUserTag() == null;
            }
            case 55: {
                return pSDEFVRCondBase.getUserTag2() == null;
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
        return PSDEFVRCondBase.contains(this, n);
    }

    private static boolean contains(PSDEFVRCondBase pSDEFVRCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRCondBase.isCondTagDirty();
            }
            case 1: {
                return pSDEFVRCondBase.isCondTag2Dirty();
            }
            case 2: {
                return pSDEFVRCondBase.isCondTypeDirty();
            }
            case 3: {
                return pSDEFVRCondBase.isCondValueDirty();
            }
            case 4: {
                return pSDEFVRCondBase.isCreateDateDirty();
            }
            case 5: {
                return pSDEFVRCondBase.isCreateManDirty();
            }
            case 6: {
                return pSDEFVRCondBase.isCustomDEFNameDirty();
            }
            case 7: {
                return pSDEFVRCondBase.isDynaModelFlagDirty();
            }
            case 8: {
                return pSDEFVRCondBase.isExtMajorPSDEFIdDirty();
            }
            case 9: {
                return pSDEFVRCondBase.isExtMajorPSDEFNameDirty();
            }
            case 10: {
                return pSDEFVRCondBase.isExtMinorPSDEFIdDirty();
            }
            case 11: {
                return pSDEFVRCondBase.isExtMinorPSDEFNameDirty();
            }
            case 12: {
                return pSDEFVRCondBase.isGroupNotFlagDirty();
            }
            case 13: {
                return pSDEFVRCondBase.isGroupOPDirty();
            }
            case 14: {
                return pSDEFVRCondBase.isKeyCondFlagDirty();
            }
            case 15: {
                return pSDEFVRCondBase.isLevelTagDirty();
            }
            case 16: {
                return pSDEFVRCondBase.isLevelValueDirty();
            }
            case 17: {
                return pSDEFVRCondBase.isMajorPSDEDSIdDirty();
            }
            case 18: {
                return pSDEFVRCondBase.isMajorPSDEDSNameDirty();
            }
            case 19: {
                return pSDEFVRCondBase.isMajorPSDEIdDirty();
            }
            case 20: {
                return pSDEFVRCondBase.isMajorPSDENameDirty();
            }
            case 21: {
                return pSDEFVRCondBase.isMemoDirty();
            }
            case 22: {
                return pSDEFVRCondBase.isOrderValueDirty();
            }
            case 23: {
                return pSDEFVRCondBase.isParamDirty();
            }
            case 24: {
                return pSDEFVRCondBase.isParam10Dirty();
            }
            case 25: {
                return pSDEFVRCondBase.isParam2Dirty();
            }
            case 26: {
                return pSDEFVRCondBase.isParam3Dirty();
            }
            case 27: {
                return pSDEFVRCondBase.isParam4Dirty();
            }
            case 28: {
                return pSDEFVRCondBase.isParam5Dirty();
            }
            case 29: {
                return pSDEFVRCondBase.isParam6Dirty();
            }
            case 30: {
                return pSDEFVRCondBase.isParam7Dirty();
            }
            case 31: {
                return pSDEFVRCondBase.isParam8Dirty();
            }
            case 32: {
                return pSDEFVRCondBase.isParam9Dirty();
            }
            case 33: {
                return pSDEFVRCondBase.isParamTypeDirty();
            }
            case 34: {
                return pSDEFVRCondBase.isPPSDEFVRCondIdDirty();
            }
            case 35: {
                return pSDEFVRCondBase.isPPSDEFVRCondNameDirty();
            }
            case 36: {
                return pSDEFVRCondBase.isPSDBValueOPIdDirty();
            }
            case 37: {
                return pSDEFVRCondBase.isPSDBValueOPNameDirty();
            }
            case 38: {
                return pSDEFVRCondBase.isPSDEDQIdDirty();
            }
            case 39: {
                return pSDEFVRCondBase.isPSDEDQNameDirty();
            }
            case 40: {
                return pSDEFVRCondBase.isPSDEFIdDirty();
            }
            case 41: {
                return pSDEFVRCondBase.isPSDEFNameDirty();
            }
            case 42: {
                return pSDEFVRCondBase.isPSDEFVRCondIdDirty();
            }
            case 43: {
                return pSDEFVRCondBase.isPSDEFVRCondNameDirty();
            }
            case 44: {
                return pSDEFVRCondBase.isPSDEFVRIdDirty();
            }
            case 45: {
                return pSDEFVRCondBase.isPSDEFVRNameDirty();
            }
            case 46: {
                return pSDEFVRCondBase.isPSDynaInstIdDirty();
            }
            case 47: {
                return pSDEFVRCondBase.isPSSysValueRuleIdDirty();
            }
            case 48: {
                return pSDEFVRCondBase.isPSSysValueRuleNameDirty();
            }
            case 49: {
                return pSDEFVRCondBase.isRIPSLanResIdDirty();
            }
            case 50: {
                return pSDEFVRCondBase.isRIPSLanResNameDirty();
            }
            case 51: {
                return pSDEFVRCondBase.isRuleInfoDirty();
            }
            case 52: {
                return pSDEFVRCondBase.isUpdateDateDirty();
            }
            case 53: {
                return pSDEFVRCondBase.isUpdateManDirty();
            }
            case 54: {
                return pSDEFVRCondBase.isUserTagDirty();
            }
            case 55: {
                return pSDEFVRCondBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFVRCondBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFVRCondBase pSDEFVRCondBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFVRCondBase.getCondTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtag", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getCondTag()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getCondTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtag2", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getCondTag2()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getCondType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtype", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getCondType()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getCondValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvalue", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getCondValue()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getCustomDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customdefname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getCustomDEFName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getExtMajorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extmajorpsdefid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getExtMajorPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getExtMajorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extmajorpsdefname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getExtMajorPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getExtMinorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extminorpsdefid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getExtMinorPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getExtMinorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extminorpsdefname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getExtMinorPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getGroupNotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupnotflag", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getGroupNotFlag()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getGroupOP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupop", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getGroupOP()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getKeyCondFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keycondflag", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getKeyCondFlag()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leveltag", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getLevelTag()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getLevelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelvalue", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getLevelValue()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getMajorPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdedstid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getMajorPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getMajorPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdedstname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getMajorPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getMajorPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdeid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getMajorPSDEId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getMajorPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdename", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getMajorPSDEName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param10", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam10()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam2()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam3()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam4()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam5()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam6()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam7()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam8()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param9", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParam9()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getParamType()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPPSDEFVRCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdefvrcondid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPPSDEFVRCondId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPPSDEFVRCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdefvrcondname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPPSDEFVRCondName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDEFVRCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrcondid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDEFVRCondId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDEFVRCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrcondname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDEFVRCondName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDEFVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDEFVRId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDEFVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDEFVRName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getRIPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ripslanresid", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getRIPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getRIPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ripslanresname", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getRIPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getRuleInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruleinfo", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getRuleInfo()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFVRCondBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFVRCondBase.getJSONValue((Object)pSDEFVRCondBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFVRCondBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFVRCondBase pSDEFVRCondBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFVRCondBase.getCondTag() != null) {
            object = pSDEFVRCondBase.getCondTag();
            xmlNode.setAttribute(FIELD_CONDTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFVRCondBase.getCondTag2() != null) {
            object = pSDEFVRCondBase.getCondTag2();
            xmlNode.setAttribute(FIELD_CONDTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFVRCondBase.getCondType() != null) {
            object = pSDEFVRCondBase.getCondType();
            xmlNode.setAttribute(FIELD_CONDTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFVRCondBase.getCondValue() != null) {
            object = pSDEFVRCondBase.getCondValue();
            xmlNode.setAttribute(FIELD_CONDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getCreateDate() != null) {
            object = pSDEFVRCondBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getCreateMan() != null) {
            object = pSDEFVRCondBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getCustomDEFName() != null) {
            object = pSDEFVRCondBase.getCustomDEFName();
            xmlNode.setAttribute(FIELD_CUSTOMDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getDynaModelFlag() != null) {
            object = pSDEFVRCondBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getExtMajorPSDEFId() != null) {
            object = pSDEFVRCondBase.getExtMajorPSDEFId();
            xmlNode.setAttribute(FIELD_EXTMAJORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getExtMajorPSDEFName() != null) {
            object = pSDEFVRCondBase.getExtMajorPSDEFName();
            xmlNode.setAttribute(FIELD_EXTMAJORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getExtMinorPSDEFId() != null) {
            object = pSDEFVRCondBase.getExtMinorPSDEFId();
            xmlNode.setAttribute(FIELD_EXTMINORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getExtMinorPSDEFName() != null) {
            object = pSDEFVRCondBase.getExtMinorPSDEFName();
            xmlNode.setAttribute(FIELD_EXTMINORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getGroupNotFlag() != null) {
            object = pSDEFVRCondBase.getGroupNotFlag();
            xmlNode.setAttribute(FIELD_GROUPNOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getGroupOP() != null) {
            object = pSDEFVRCondBase.getGroupOP();
            xmlNode.setAttribute(FIELD_GROUPOP, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getKeyCondFlag() != null) {
            object = pSDEFVRCondBase.getKeyCondFlag();
            xmlNode.setAttribute(FIELD_KEYCONDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getLevelTag() != null) {
            object = pSDEFVRCondBase.getLevelTag();
            xmlNode.setAttribute(FIELD_LEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getLevelValue() != null) {
            object = pSDEFVRCondBase.getLevelValue();
            xmlNode.setAttribute(FIELD_LEVELVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getMajorPSDEDSId() != null) {
            object = pSDEFVRCondBase.getMajorPSDEDSId();
            xmlNode.setAttribute("MAJORPSDEDSID", object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getMajorPSDEDSName() != null) {
            object = pSDEFVRCondBase.getMajorPSDEDSName();
            xmlNode.setAttribute("MAJORPSDEDSNAME", object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getMajorPSDEId() != null) {
            object = pSDEFVRCondBase.getMajorPSDEId();
            xmlNode.setAttribute(FIELD_MAJORPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getMajorPSDEName() != null) {
            object = pSDEFVRCondBase.getMajorPSDEName();
            xmlNode.setAttribute(FIELD_MAJORPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getMemo() != null) {
            object = pSDEFVRCondBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getOrderValue() != null) {
            object = pSDEFVRCondBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParam() != null) {
            object = pSDEFVRCondBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getParam10() != null) {
            object = pSDEFVRCondBase.getParam10();
            xmlNode.setAttribute(FIELD_PARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParam2() != null) {
            object = pSDEFVRCondBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getParam3() != null) {
            object = pSDEFVRCondBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParam4() != null) {
            object = pSDEFVRCondBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParam5() != null) {
            object = pSDEFVRCondBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParam6() != null) {
            object = pSDEFVRCondBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParam7() != null) {
            object = pSDEFVRCondBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParam8() != null) {
            object = pSDEFVRCondBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParam9() != null) {
            object = pSDEFVRCondBase.getParam9();
            xmlNode.setAttribute(FIELD_PARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getParamType() != null) {
            object = pSDEFVRCondBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPPSDEFVRCondId() != null) {
            object = pSDEFVRCondBase.getPPSDEFVRCondId();
            xmlNode.setAttribute(FIELD_PPSDEFVRCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPPSDEFVRCondName() != null) {
            object = pSDEFVRCondBase.getPPSDEFVRCondName();
            xmlNode.setAttribute(FIELD_PPSDEFVRCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDBValueOPId() != null) {
            object = pSDEFVRCondBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDBValueOPName() != null) {
            object = pSDEFVRCondBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDEDQId() != null) {
            object = pSDEFVRCondBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDEDQName() != null) {
            object = pSDEFVRCondBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDEFId() != null) {
            object = pSDEFVRCondBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDEFName() != null) {
            object = pSDEFVRCondBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDEFVRCondId() != null) {
            object = pSDEFVRCondBase.getPSDEFVRCondId();
            xmlNode.setAttribute(FIELD_PSDEFVRCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDEFVRCondName() != null) {
            object = pSDEFVRCondBase.getPSDEFVRCondName();
            xmlNode.setAttribute(FIELD_PSDEFVRCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDEFVRId() != null) {
            object = pSDEFVRCondBase.getPSDEFVRId();
            xmlNode.setAttribute(FIELD_PSDEFVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDEFVRName() != null) {
            object = pSDEFVRCondBase.getPSDEFVRName();
            xmlNode.setAttribute(FIELD_PSDEFVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSDynaInstId() != null) {
            object = pSDEFVRCondBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSSysValueRuleId() != null) {
            object = pSDEFVRCondBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getPSSysValueRuleName() != null) {
            object = pSDEFVRCondBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getRIPSLanResId() != null) {
            object = pSDEFVRCondBase.getRIPSLanResId();
            xmlNode.setAttribute(FIELD_RIPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getRIPSLanResName() != null) {
            object = pSDEFVRCondBase.getRIPSLanResName();
            xmlNode.setAttribute(FIELD_RIPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getRuleInfo() != null) {
            object = pSDEFVRCondBase.getRuleInfo();
            xmlNode.setAttribute(FIELD_RULEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getUpdateDate() != null) {
            object = pSDEFVRCondBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRCondBase.getUpdateMan() != null) {
            object = pSDEFVRCondBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getUserTag() != null) {
            object = pSDEFVRCondBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCondBase.getUserTag2() != null) {
            object = pSDEFVRCondBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFVRCondBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFVRCondBase pSDEFVRCondBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFVRCondBase.isCondTagDirty() && (bl || pSDEFVRCondBase.getCondTag() != null)) {
            iDataObject.set(FIELD_CONDTAG, (Object)pSDEFVRCondBase.getCondTag());
        }
        if (pSDEFVRCondBase.isCondTag2Dirty() && (bl || pSDEFVRCondBase.getCondTag2() != null)) {
            iDataObject.set(FIELD_CONDTAG2, (Object)pSDEFVRCondBase.getCondTag2());
        }
        if (pSDEFVRCondBase.isCondTypeDirty() && (bl || pSDEFVRCondBase.getCondType() != null)) {
            iDataObject.set(FIELD_CONDTYPE, (Object)pSDEFVRCondBase.getCondType());
        }
        if (pSDEFVRCondBase.isCondValueDirty() && (bl || pSDEFVRCondBase.getCondValue() != null)) {
            iDataObject.set(FIELD_CONDVALUE, (Object)pSDEFVRCondBase.getCondValue());
        }
        if (pSDEFVRCondBase.isCreateDateDirty() && (bl || pSDEFVRCondBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFVRCondBase.getCreateDate());
        }
        if (pSDEFVRCondBase.isCreateManDirty() && (bl || pSDEFVRCondBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFVRCondBase.getCreateMan());
        }
        if (pSDEFVRCondBase.isCustomDEFNameDirty() && (bl || pSDEFVRCondBase.getCustomDEFName() != null)) {
            iDataObject.set(FIELD_CUSTOMDEFNAME, (Object)pSDEFVRCondBase.getCustomDEFName());
        }
        if (pSDEFVRCondBase.isDynaModelFlagDirty() && (bl || pSDEFVRCondBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFVRCondBase.getDynaModelFlag());
        }
        if (pSDEFVRCondBase.isExtMajorPSDEFIdDirty() && (bl || pSDEFVRCondBase.getExtMajorPSDEFId() != null)) {
            iDataObject.set(FIELD_EXTMAJORPSDEFID, (Object)pSDEFVRCondBase.getExtMajorPSDEFId());
        }
        if (pSDEFVRCondBase.isExtMajorPSDEFNameDirty() && (bl || pSDEFVRCondBase.getExtMajorPSDEFName() != null)) {
            iDataObject.set(FIELD_EXTMAJORPSDEFNAME, (Object)pSDEFVRCondBase.getExtMajorPSDEFName());
        }
        if (pSDEFVRCondBase.isExtMinorPSDEFIdDirty() && (bl || pSDEFVRCondBase.getExtMinorPSDEFId() != null)) {
            iDataObject.set(FIELD_EXTMINORPSDEFID, (Object)pSDEFVRCondBase.getExtMinorPSDEFId());
        }
        if (pSDEFVRCondBase.isExtMinorPSDEFNameDirty() && (bl || pSDEFVRCondBase.getExtMinorPSDEFName() != null)) {
            iDataObject.set(FIELD_EXTMINORPSDEFNAME, (Object)pSDEFVRCondBase.getExtMinorPSDEFName());
        }
        if (pSDEFVRCondBase.isGroupNotFlagDirty() && (bl || pSDEFVRCondBase.getGroupNotFlag() != null)) {
            iDataObject.set(FIELD_GROUPNOTFLAG, (Object)pSDEFVRCondBase.getGroupNotFlag());
        }
        if (pSDEFVRCondBase.isGroupOPDirty() && (bl || pSDEFVRCondBase.getGroupOP() != null)) {
            iDataObject.set(FIELD_GROUPOP, (Object)pSDEFVRCondBase.getGroupOP());
        }
        if (pSDEFVRCondBase.isKeyCondFlagDirty() && (bl || pSDEFVRCondBase.getKeyCondFlag() != null)) {
            iDataObject.set(FIELD_KEYCONDFLAG, (Object)pSDEFVRCondBase.getKeyCondFlag());
        }
        if (pSDEFVRCondBase.isLevelTagDirty() && (bl || pSDEFVRCondBase.getLevelTag() != null)) {
            iDataObject.set(FIELD_LEVELTAG, (Object)pSDEFVRCondBase.getLevelTag());
        }
        if (pSDEFVRCondBase.isLevelValueDirty() && (bl || pSDEFVRCondBase.getLevelValue() != null)) {
            iDataObject.set(FIELD_LEVELVALUE, (Object)pSDEFVRCondBase.getLevelValue());
        }
        if (pSDEFVRCondBase.isMajorPSDEDSIdDirty() && (bl || pSDEFVRCondBase.getMajorPSDEDSId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEDSID, (Object)pSDEFVRCondBase.getMajorPSDEDSId());
        }
        if (pSDEFVRCondBase.isMajorPSDEDSNameDirty() && (bl || pSDEFVRCondBase.getMajorPSDEDSName() != null)) {
            iDataObject.set(FIELD_MAJORPSDEDSNAME, (Object)pSDEFVRCondBase.getMajorPSDEDSName());
        }
        if (pSDEFVRCondBase.isMajorPSDEIdDirty() && (bl || pSDEFVRCondBase.getMajorPSDEId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEID, (Object)pSDEFVRCondBase.getMajorPSDEId());
        }
        if (pSDEFVRCondBase.isMajorPSDENameDirty() && (bl || pSDEFVRCondBase.getMajorPSDEName() != null)) {
            iDataObject.set(FIELD_MAJORPSDENAME, (Object)pSDEFVRCondBase.getMajorPSDEName());
        }
        if (pSDEFVRCondBase.isMemoDirty() && (bl || pSDEFVRCondBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFVRCondBase.getMemo());
        }
        if (pSDEFVRCondBase.isOrderValueDirty() && (bl || pSDEFVRCondBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFVRCondBase.getOrderValue());
        }
        if (pSDEFVRCondBase.isParamDirty() && (bl || pSDEFVRCondBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDEFVRCondBase.getParam());
        }
        if (pSDEFVRCondBase.isParam10Dirty() && (bl || pSDEFVRCondBase.getParam10() != null)) {
            iDataObject.set(FIELD_PARAM10, (Object)pSDEFVRCondBase.getParam10());
        }
        if (pSDEFVRCondBase.isParam2Dirty() && (bl || pSDEFVRCondBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDEFVRCondBase.getParam2());
        }
        if (pSDEFVRCondBase.isParam3Dirty() && (bl || pSDEFVRCondBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSDEFVRCondBase.getParam3());
        }
        if (pSDEFVRCondBase.isParam4Dirty() && (bl || pSDEFVRCondBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSDEFVRCondBase.getParam4());
        }
        if (pSDEFVRCondBase.isParam5Dirty() && (bl || pSDEFVRCondBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSDEFVRCondBase.getParam5());
        }
        if (pSDEFVRCondBase.isParam6Dirty() && (bl || pSDEFVRCondBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSDEFVRCondBase.getParam6());
        }
        if (pSDEFVRCondBase.isParam7Dirty() && (bl || pSDEFVRCondBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSDEFVRCondBase.getParam7());
        }
        if (pSDEFVRCondBase.isParam8Dirty() && (bl || pSDEFVRCondBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSDEFVRCondBase.getParam8());
        }
        if (pSDEFVRCondBase.isParam9Dirty() && (bl || pSDEFVRCondBase.getParam9() != null)) {
            iDataObject.set(FIELD_PARAM9, (Object)pSDEFVRCondBase.getParam9());
        }
        if (pSDEFVRCondBase.isParamTypeDirty() && (bl || pSDEFVRCondBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSDEFVRCondBase.getParamType());
        }
        if (pSDEFVRCondBase.isPPSDEFVRCondIdDirty() && (bl || pSDEFVRCondBase.getPPSDEFVRCondId() != null)) {
            iDataObject.set(FIELD_PPSDEFVRCONDID, (Object)pSDEFVRCondBase.getPPSDEFVRCondId());
        }
        if (pSDEFVRCondBase.isPPSDEFVRCondNameDirty() && (bl || pSDEFVRCondBase.getPPSDEFVRCondName() != null)) {
            iDataObject.set(FIELD_PPSDEFVRCONDNAME, (Object)pSDEFVRCondBase.getPPSDEFVRCondName());
        }
        if (pSDEFVRCondBase.isPSDBValueOPIdDirty() && (bl || pSDEFVRCondBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSDEFVRCondBase.getPSDBValueOPId());
        }
        if (pSDEFVRCondBase.isPSDBValueOPNameDirty() && (bl || pSDEFVRCondBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSDEFVRCondBase.getPSDBValueOPName());
        }
        if (pSDEFVRCondBase.isPSDEDQIdDirty() && (bl || pSDEFVRCondBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDEFVRCondBase.getPSDEDQId());
        }
        if (pSDEFVRCondBase.isPSDEDQNameDirty() && (bl || pSDEFVRCondBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDEFVRCondBase.getPSDEDQName());
        }
        if (pSDEFVRCondBase.isPSDEFIdDirty() && (bl || pSDEFVRCondBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFVRCondBase.getPSDEFId());
        }
        if (pSDEFVRCondBase.isPSDEFNameDirty() && (bl || pSDEFVRCondBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFVRCondBase.getPSDEFName());
        }
        if (pSDEFVRCondBase.isPSDEFVRCondIdDirty() && (bl || pSDEFVRCondBase.getPSDEFVRCondId() != null)) {
            iDataObject.set(FIELD_PSDEFVRCONDID, (Object)pSDEFVRCondBase.getPSDEFVRCondId());
        }
        if (pSDEFVRCondBase.isPSDEFVRCondNameDirty() && (bl || pSDEFVRCondBase.getPSDEFVRCondName() != null)) {
            iDataObject.set(FIELD_PSDEFVRCONDNAME, (Object)pSDEFVRCondBase.getPSDEFVRCondName());
        }
        if (pSDEFVRCondBase.isPSDEFVRIdDirty() && (bl || pSDEFVRCondBase.getPSDEFVRId() != null)) {
            iDataObject.set(FIELD_PSDEFVRID, (Object)pSDEFVRCondBase.getPSDEFVRId());
        }
        if (pSDEFVRCondBase.isPSDEFVRNameDirty() && (bl || pSDEFVRCondBase.getPSDEFVRName() != null)) {
            iDataObject.set(FIELD_PSDEFVRNAME, (Object)pSDEFVRCondBase.getPSDEFVRName());
        }
        if (pSDEFVRCondBase.isPSDynaInstIdDirty() && (bl || pSDEFVRCondBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFVRCondBase.getPSDynaInstId());
        }
        if (pSDEFVRCondBase.isPSSysValueRuleIdDirty() && (bl || pSDEFVRCondBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEFVRCondBase.getPSSysValueRuleId());
        }
        if (pSDEFVRCondBase.isPSSysValueRuleNameDirty() && (bl || pSDEFVRCondBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEFVRCondBase.getPSSysValueRuleName());
        }
        if (pSDEFVRCondBase.isRIPSLanResIdDirty() && (bl || pSDEFVRCondBase.getRIPSLanResId() != null)) {
            iDataObject.set(FIELD_RIPSLANRESID, (Object)pSDEFVRCondBase.getRIPSLanResId());
        }
        if (pSDEFVRCondBase.isRIPSLanResNameDirty() && (bl || pSDEFVRCondBase.getRIPSLanResName() != null)) {
            iDataObject.set(FIELD_RIPSLANRESNAME, (Object)pSDEFVRCondBase.getRIPSLanResName());
        }
        if (pSDEFVRCondBase.isRuleInfoDirty() && (bl || pSDEFVRCondBase.getRuleInfo() != null)) {
            iDataObject.set(FIELD_RULEINFO, (Object)pSDEFVRCondBase.getRuleInfo());
        }
        if (pSDEFVRCondBase.isUpdateDateDirty() && (bl || pSDEFVRCondBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFVRCondBase.getUpdateDate());
        }
        if (pSDEFVRCondBase.isUpdateManDirty() && (bl || pSDEFVRCondBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFVRCondBase.getUpdateMan());
        }
        if (pSDEFVRCondBase.isUserTagDirty() && (bl || pSDEFVRCondBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFVRCondBase.getUserTag());
        }
        if (pSDEFVRCondBase.isUserTag2Dirty() && (bl || pSDEFVRCondBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFVRCondBase.getUserTag2());
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
        return PSDEFVRCondBase.remove(this, n);
    }

    private static boolean remove(PSDEFVRCondBase pSDEFVRCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRCondBase.resetCondTag();
                return true;
            }
            case 1: {
                pSDEFVRCondBase.resetCondTag2();
                return true;
            }
            case 2: {
                pSDEFVRCondBase.resetCondType();
                return true;
            }
            case 3: {
                pSDEFVRCondBase.resetCondValue();
                return true;
            }
            case 4: {
                pSDEFVRCondBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDEFVRCondBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDEFVRCondBase.resetCustomDEFName();
                return true;
            }
            case 7: {
                pSDEFVRCondBase.resetDynaModelFlag();
                return true;
            }
            case 8: {
                pSDEFVRCondBase.resetExtMajorPSDEFId();
                return true;
            }
            case 9: {
                pSDEFVRCondBase.resetExtMajorPSDEFName();
                return true;
            }
            case 10: {
                pSDEFVRCondBase.resetExtMinorPSDEFId();
                return true;
            }
            case 11: {
                pSDEFVRCondBase.resetExtMinorPSDEFName();
                return true;
            }
            case 12: {
                pSDEFVRCondBase.resetGroupNotFlag();
                return true;
            }
            case 13: {
                pSDEFVRCondBase.resetGroupOP();
                return true;
            }
            case 14: {
                pSDEFVRCondBase.resetKeyCondFlag();
                return true;
            }
            case 15: {
                pSDEFVRCondBase.resetLevelTag();
                return true;
            }
            case 16: {
                pSDEFVRCondBase.resetLevelValue();
                return true;
            }
            case 17: {
                pSDEFVRCondBase.resetMajorPSDEDSId();
                return true;
            }
            case 18: {
                pSDEFVRCondBase.resetMajorPSDEDSName();
                return true;
            }
            case 19: {
                pSDEFVRCondBase.resetMajorPSDEId();
                return true;
            }
            case 20: {
                pSDEFVRCondBase.resetMajorPSDEName();
                return true;
            }
            case 21: {
                pSDEFVRCondBase.resetMemo();
                return true;
            }
            case 22: {
                pSDEFVRCondBase.resetOrderValue();
                return true;
            }
            case 23: {
                pSDEFVRCondBase.resetParam();
                return true;
            }
            case 24: {
                pSDEFVRCondBase.resetParam10();
                return true;
            }
            case 25: {
                pSDEFVRCondBase.resetParam2();
                return true;
            }
            case 26: {
                pSDEFVRCondBase.resetParam3();
                return true;
            }
            case 27: {
                pSDEFVRCondBase.resetParam4();
                return true;
            }
            case 28: {
                pSDEFVRCondBase.resetParam5();
                return true;
            }
            case 29: {
                pSDEFVRCondBase.resetParam6();
                return true;
            }
            case 30: {
                pSDEFVRCondBase.resetParam7();
                return true;
            }
            case 31: {
                pSDEFVRCondBase.resetParam8();
                return true;
            }
            case 32: {
                pSDEFVRCondBase.resetParam9();
                return true;
            }
            case 33: {
                pSDEFVRCondBase.resetParamType();
                return true;
            }
            case 34: {
                pSDEFVRCondBase.resetPPSDEFVRCondId();
                return true;
            }
            case 35: {
                pSDEFVRCondBase.resetPPSDEFVRCondName();
                return true;
            }
            case 36: {
                pSDEFVRCondBase.resetPSDBValueOPId();
                return true;
            }
            case 37: {
                pSDEFVRCondBase.resetPSDBValueOPName();
                return true;
            }
            case 38: {
                pSDEFVRCondBase.resetPSDEDQId();
                return true;
            }
            case 39: {
                pSDEFVRCondBase.resetPSDEDQName();
                return true;
            }
            case 40: {
                pSDEFVRCondBase.resetPSDEFId();
                return true;
            }
            case 41: {
                pSDEFVRCondBase.resetPSDEFName();
                return true;
            }
            case 42: {
                pSDEFVRCondBase.resetPSDEFVRCondId();
                return true;
            }
            case 43: {
                pSDEFVRCondBase.resetPSDEFVRCondName();
                return true;
            }
            case 44: {
                pSDEFVRCondBase.resetPSDEFVRId();
                return true;
            }
            case 45: {
                pSDEFVRCondBase.resetPSDEFVRName();
                return true;
            }
            case 46: {
                pSDEFVRCondBase.resetPSDynaInstId();
                return true;
            }
            case 47: {
                pSDEFVRCondBase.resetPSSysValueRuleId();
                return true;
            }
            case 48: {
                pSDEFVRCondBase.resetPSSysValueRuleName();
                return true;
            }
            case 49: {
                pSDEFVRCondBase.resetRIPSLanResId();
                return true;
            }
            case 50: {
                pSDEFVRCondBase.resetRIPSLanResName();
                return true;
            }
            case 51: {
                pSDEFVRCondBase.resetRuleInfo();
                return true;
            }
            case 52: {
                pSDEFVRCondBase.resetUpdateDate();
                return true;
            }
            case 53: {
                pSDEFVRCondBase.resetUpdateMan();
                return true;
            }
            case 54: {
                pSDEFVRCondBase.resetUserTag();
                return true;
            }
            case 55: {
                pSDEFVRCondBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getMajorPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDE();
        }
        if (this.getMajorPSDEId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDELock;
        synchronized (n) {
            if (this.majorpsde != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDEId(), (Object)this.majorpsde.getPSDataEntityId()) != 0L) {
                this.majorpsde = null;
            }
            if (this.majorpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getMajorPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.majorpsde = pSDataEntity;
            }
            return this.majorpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueOP getPSDBValueOP() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOP();
        }
        if (this.getPSDBValueOPId() == null) {
            return null;
        }
        Integer n = this.objPSDBValueOPLock;
        synchronized (n) {
            if (this.psdbvalueop != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBValueOPId(), (Object)this.psdbvalueop.getPSDBValueOPId()) != 0L) {
                this.psdbvalueop = null;
            }
            if (this.psdbvalueop == null) {
                PSDBValueOP pSDBValueOP = new PSDBValueOP();
                pSDBValueOP.setPSDBValueOPId(this.getPSDBValueOPId());
                PSDBValueOPService pSDBValueOPService = (PSDBValueOPService)ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)this.getSessionFactory());
                pSDBValueOPService.autoGet(pSDBValueOP);
                this.psdbvalueop = pSDBValueOP;
            }
            return this.psdbvalueop;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getPSDEDQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQ();
        }
        if (this.getPSDEDQId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQLock;
        synchronized (n) {
            if (this.psdedq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQId(), (Object)this.psdedq.getPSDEDataQueryId()) != 0L) {
                this.psdedq = null;
            }
            if (this.psdedq == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDQId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet(pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getMajorPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEDS();
        }
        if (this.getMajorPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDEDSLock;
        synchronized (n) {
            if (this.majorpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDEDSId(), (Object)this.majorpsdeds.getPSDEDataSetId()) != 0L) {
                this.majorpsdeds = null;
            }
            if (this.majorpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getMajorPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.majorpsdeds = pSDEDataSet;
            }
            return this.majorpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getExtMajorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtMajorPSDEF();
        }
        if (this.getExtMajorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objExtMajorPSDEFLock;
        synchronized (n) {
            if (this.extmajorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getExtMajorPSDEFId(), (Object)this.extmajorpsdef.getPSDEFieldId()) != 0L) {
                this.extmajorpsdef = null;
            }
            if (this.extmajorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getExtMajorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.extmajorpsdef = pSDEField;
            }
            return this.extmajorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getExtMinorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtMinorPSDEF();
        }
        if (this.getExtMinorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objExtMinorPSDEFLock;
        synchronized (n) {
            if (this.extminorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getExtMinorPSDEFId(), (Object)this.extminorpsdef.getPSDEFieldId()) != 0L) {
                this.extminorpsdef = null;
            }
            if (this.extminorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getExtMinorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.extminorpsdef = pSDEField;
            }
            return this.extminorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFValueRule getPSDEFVR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVR();
        }
        if (this.getPSDEFVRId() == null) {
            return null;
        }
        Integer n = this.objPSDEFVRLock;
        synchronized (n) {
            if (this.psdefvr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFVRId(), (Object)this.psdefvr.getPSDEFValueRuleId()) != 0L) {
                this.psdefvr = null;
            }
            if (this.psdefvr == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFVRId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet(pSDEFValueRule);
                this.psdefvr = pSDEFValueRule;
            }
            return this.psdefvr;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFVRCond getPPSDEFVRCond() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFVRCond();
        }
        if (this.getPPSDEFVRCondId() == null) {
            return null;
        }
        Integer n = this.objPPSDEFVRCondLock;
        synchronized (n) {
            if (this.ppsdefvrcond != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDEFVRCondId(), (Object)this.ppsdefvrcond.getPSDEFVRCondId()) != 0L) {
                this.ppsdefvrcond = null;
            }
            if (this.ppsdefvrcond == null) {
                PSDEFVRCond pSDEFVRCond = new PSDEFVRCond();
                pSDEFVRCond.setPSDEFVRCondId(this.getPPSDEFVRCondId());
                PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
                pSDEFVRCondService.autoGet(pSDEFVRCond);
                this.ppsdefvrcond = pSDEFVRCond;
            }
            return this.ppsdefvrcond;
        }
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.ripslanres = pSLanguageRes;
            }
            return this.ripslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysValueRule getPSSysValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRule();
        }
        if (this.getPSSysValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysValueRuleLock;
        synchronized (n) {
            if (this.pssysvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysValueRuleId(), (Object)this.pssysvaluerule.getPSSysValueRuleId()) != 0L) {
                this.pssysvaluerule = null;
            }
            if (this.pssysvaluerule == null) {
                PSSysValueRule pSSysValueRule = new PSSysValueRule();
                pSSysValueRule.setPSSysValueRuleId(this.getPSSysValueRuleId());
                PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysValueRuleService.autoGet(pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFVRCond> getPSDEFVRConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRConds();
        }
        if (this.getPSDEFVRCondId() == null) {
            return null;
        }
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFVRCondsLock;
        synchronized (n) {
            if (this.psdefvrconds == null) {
                this.psdefvrconds = pSDEFVRCondService.selectByPPSDEFVRCond(this);
            }
            return this.psdefvrconds;
        }
    }

    private PSDEFVRCondBase getProxyEntity() {
        return this.proxyPSDEFVRCondBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFVRCondBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFVRCondBase) {
            this.proxyPSDEFVRCondBase = (PSDEFVRCondBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDTAG, 0);
        fieldIndexMap.put(FIELD_CONDTAG2, 1);
        fieldIndexMap.put(FIELD_CONDTYPE, 2);
        fieldIndexMap.put(FIELD_CONDVALUE, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_CUSTOMDEFNAME, 6);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 7);
        fieldIndexMap.put(FIELD_EXTMAJORPSDEFID, 8);
        fieldIndexMap.put(FIELD_EXTMAJORPSDEFNAME, 9);
        fieldIndexMap.put(FIELD_EXTMINORPSDEFID, 10);
        fieldIndexMap.put(FIELD_EXTMINORPSDEFNAME, 11);
        fieldIndexMap.put(FIELD_GROUPNOTFLAG, 12);
        fieldIndexMap.put(FIELD_GROUPOP, 13);
        fieldIndexMap.put(FIELD_KEYCONDFLAG, 14);
        fieldIndexMap.put(FIELD_LEVELTAG, 15);
        fieldIndexMap.put(FIELD_LEVELVALUE, 16);
        fieldIndexMap.put(FIELD_MAJORPSDEDSID, 17);
        fieldIndexMap.put(FIELD_MAJORPSDEDSNAME, 18);
        fieldIndexMap.put(FIELD_MAJORPSDEID, 19);
        fieldIndexMap.put(FIELD_MAJORPSDENAME, 20);
        fieldIndexMap.put(FIELD_MEMO, 21);
        fieldIndexMap.put(FIELD_ORDERVALUE, 22);
        fieldIndexMap.put(FIELD_PARAM, 23);
        fieldIndexMap.put(FIELD_PARAM10, 24);
        fieldIndexMap.put(FIELD_PARAM2, 25);
        fieldIndexMap.put(FIELD_PARAM3, 26);
        fieldIndexMap.put(FIELD_PARAM4, 27);
        fieldIndexMap.put(FIELD_PARAM5, 28);
        fieldIndexMap.put(FIELD_PARAM6, 29);
        fieldIndexMap.put(FIELD_PARAM7, 30);
        fieldIndexMap.put(FIELD_PARAM8, 31);
        fieldIndexMap.put(FIELD_PARAM9, 32);
        fieldIndexMap.put(FIELD_PARAMTYPE, 33);
        fieldIndexMap.put(FIELD_PPSDEFVRCONDID, 34);
        fieldIndexMap.put(FIELD_PPSDEFVRCONDNAME, 35);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 36);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 37);
        fieldIndexMap.put(FIELD_PSDEDQID, 38);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 39);
        fieldIndexMap.put(FIELD_PSDEFID, 40);
        fieldIndexMap.put(FIELD_PSDEFNAME, 41);
        fieldIndexMap.put(FIELD_PSDEFVRCONDID, 42);
        fieldIndexMap.put(FIELD_PSDEFVRCONDNAME, 43);
        fieldIndexMap.put(FIELD_PSDEFVRID, 44);
        fieldIndexMap.put(FIELD_PSDEFVRNAME, 45);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 46);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 47);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 48);
        fieldIndexMap.put(FIELD_RIPSLANRESID, 49);
        fieldIndexMap.put(FIELD_RIPSLANRESNAME, 50);
        fieldIndexMap.put(FIELD_RULEINFO, 51);
        fieldIndexMap.put(FIELD_UPDATEDATE, 52);
        fieldIndexMap.put(FIELD_UPDATEMAN, 53);
        fieldIndexMap.put(FIELD_USERTAG, 54);
        fieldIndexMap.put(FIELD_USERTAG2, 55);
    }
}

