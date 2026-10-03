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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataQueryBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataQueryBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_DQJOINMODEL = "DQJOINMODEL";
    public static final String FIELD_DQOPTION = "DQOPTION";
    public static final String FIELD_DQSN = "DQSN";
    public static final String FIELD_DQTAG = "DQTAG";
    public static final String FIELD_DQTAG2 = "DQTAG2";
    public static final String FIELD_DQTAG3 = "DQTAG3";
    public static final String FIELD_DQTAG4 = "DQTAG4";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEPQL = "ENABLEPQL";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_FILTERMODEL = "FILTERMODEL";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PRIVMODE = "PRIVMODE";
    public static final String FIELD_PSDEDATAQUERYID = "PSDEDATAQUERYID";
    public static final String FIELD_PSDEDATAQUERYNAME = "PSDEDATAQUERYNAME";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String FIELD_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_QUERYVIEWFLAG = "QUERYVIEWFLAG";
    public static final String FIELD_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String FIELD_REQUESTPATH = "REQUESTPATH";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SUBSYSSADETAILMODE = "SUBSYSSADETAILMODE";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWCOLLEVEL = "VIEWCOLLEVEL";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_CUSTOMMODE = 4;
    private static final int INDEX_DEFAULTMODE = 5;
    private static final int INDEX_DQJOINMODEL = 6;
    private static final int INDEX_DQOPTION = 7;
    private static final int INDEX_DQSN = 8;
    private static final int INDEX_DQTAG = 9;
    private static final int INDEX_DQTAG2 = 10;
    private static final int INDEX_DQTAG3 = 11;
    private static final int INDEX_DQTAG4 = 12;
    private static final int INDEX_DYNAMODELFLAG = 13;
    private static final int INDEX_ENABLEPQL = 14;
    private static final int INDEX_EXTENDMODE = 15;
    private static final int INDEX_FILTERMODEL = 16;
    private static final int INDEX_LOCKFLAG = 17;
    private static final int INDEX_LOGICNAME = 18;
    private static final int INDEX_MEMO = 19;
    private static final int INDEX_ORDERVALUE = 20;
    private static final int INDEX_PRIVMODE = 21;
    private static final int INDEX_PSDEDATAQUERYID = 22;
    private static final int INDEX_PSDEDATAQUERYNAME = 23;
    private static final int INDEX_PSDEFGROUPID = 24;
    private static final int INDEX_PSDEFGROUPNAME = 25;
    private static final int INDEX_PSDEID = 26;
    private static final int INDEX_PSDEMAINSTATEID = 27;
    private static final int INDEX_PSDEMAINSTATENAME = 28;
    private static final int INDEX_PSDENAME = 29;
    private static final int INDEX_PSDYNAINSTID = 30;
    private static final int INDEX_PUBMODE = 31;
    private static final int INDEX_QUERYVIEWFLAG = 32;
    private static final int INDEX_REQUESTMETHOD = 33;
    private static final int INDEX_REQUESTPATH = 34;
    private static final int INDEX_SERVICECODENAME = 35;
    private static final int INDEX_SUBSYSSADETAILMODE = 36;
    private static final int INDEX_TODOTASK = 37;
    private static final int INDEX_UPDATEDATE = 38;
    private static final int INDEX_UPDATEMAN = 39;
    private static final int INDEX_USERCAT = 40;
    private static final int INDEX_USERTAG = 41;
    private static final int INDEX_USERTAG2 = 42;
    private static final int INDEX_USERTAG3 = 43;
    private static final int INDEX_USERTAG4 = 44;
    private static final int INDEX_VALIDFLAG = 45;
    private static final int INDEX_VIEWCOLLEVEL = 46;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataQueryBase proxyPSDEDataQueryBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean dqjoinmodelDirtyFlag = false;
    private boolean dqoptionDirtyFlag = false;
    private boolean dqsnDirtyFlag = false;
    private boolean dqtagDirtyFlag = false;
    private boolean dqtag2DirtyFlag = false;
    private boolean dqtag3DirtyFlag = false;
    private boolean dqtag4DirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablepqlDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean filtermodelDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean privmodeDirtyFlag = false;
    private boolean psdedataqueryidDirtyFlag = false;
    private boolean psdedataquerynameDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemainstateidDirtyFlag = false;
    private boolean psdemainstatenameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean queryviewflagDirtyFlag = false;
    private boolean requestmethodDirtyFlag = false;
    private boolean requestpathDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean subsyssadetailmodeDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewcollevelDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="dqjoinmodel")
    private String dqjoinmodel;
    @Column(name="dqoption")
    private Integer dqoption;
    @Column(name="dqsn")
    private String dqsn;
    @Column(name="dqtag")
    private String dqtag;
    @Column(name="dqtag2")
    private String dqtag2;
    @Column(name="dqtag3")
    private String dqtag3;
    @Column(name="dqtag4")
    private String dqtag4;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablepql")
    private Integer enablepql;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="filtermodel")
    private String filtermodel;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="privmode")
    private Integer privmode;
    @Column(name="psdedataqueryid")
    private String psdedataqueryid;
    @Column(name="psdedataqueryname")
    private String psdedataqueryname;
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemainstateid")
    private String psdemainstateid;
    @Column(name="psdemainstatename")
    private String psdemainstatename;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="queryviewflag")
    private Integer queryviewflag;
    @Column(name="requestmethod")
    private String requestmethod;
    @Column(name="requestpath")
    private String requestpath;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="subsyssadetailmode")
    private Integer subsyssadetailmode;
    @Column(name="todotask")
    private String todotask;
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
    @Column(name="viewcollevel")
    private Integer viewcollevel;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEFGroupLock = new Integer(1);
    private PSDEFGroup psdefgroup = null;
    private Integer objPSDEMainStateLock = new Integer(1);
    private PSDEMainState psdemainstate = null;
    private Integer objPSDEDQCondsLock = new Integer(1);
    private ArrayList<PSDEDQCond> psdedqconds = null;
    private Integer objPSDEDSDQsLock = new Integer(1);
    private ArrayList<PSDEDSDQ> psdedsdqs = null;

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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
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

    public void setDQJoinModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDQJoinModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dqjoinmodel = string;
        this.dqjoinmodelDirtyFlag = true;
    }

    public String getDQJoinModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDQJoinModel();
        }
        return this.dqjoinmodel;
    }

    public boolean isDQJoinModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDQJoinModelDirty();
        }
        return this.dqjoinmodelDirtyFlag;
    }

    public void resetDQJoinModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDQJoinModel();
            return;
        }
        this.dqjoinmodelDirtyFlag = false;
        this.dqjoinmodel = null;
    }

    public void setDQOption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDQOption(n);
            return;
        }
        this.dqoption = n;
        this.dqoptionDirtyFlag = true;
    }

    public Integer getDQOption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDQOption();
        }
        return this.dqoption;
    }

    public boolean isDQOptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDQOptionDirty();
        }
        return this.dqoptionDirtyFlag;
    }

    public void resetDQOption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDQOption();
            return;
        }
        this.dqoptionDirtyFlag = false;
        this.dqoption = null;
    }

    public void setDQSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDQSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dqsn = string;
        this.dqsnDirtyFlag = true;
    }

    public String getDQSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDQSN();
        }
        return this.dqsn;
    }

    public boolean isDQSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDQSNDirty();
        }
        return this.dqsnDirtyFlag;
    }

    public void resetDQSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDQSN();
            return;
        }
        this.dqsnDirtyFlag = false;
        this.dqsn = null;
    }

    public void setDQTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDQTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dqtag = string;
        this.dqtagDirtyFlag = true;
    }

    public String getDQTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDQTag();
        }
        return this.dqtag;
    }

    public boolean isDQTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDQTagDirty();
        }
        return this.dqtagDirtyFlag;
    }

    public void resetDQTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDQTag();
            return;
        }
        this.dqtagDirtyFlag = false;
        this.dqtag = null;
    }

    public void setDQTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDQTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dqtag2 = string;
        this.dqtag2DirtyFlag = true;
    }

    public String getDQTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDQTag2();
        }
        return this.dqtag2;
    }

    public boolean isDQTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDQTag2Dirty();
        }
        return this.dqtag2DirtyFlag;
    }

    public void resetDQTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDQTag2();
            return;
        }
        this.dqtag2DirtyFlag = false;
        this.dqtag2 = null;
    }

    public void setDQTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDQTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dqtag3 = string;
        this.dqtag3DirtyFlag = true;
    }

    public String getDQTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDQTag3();
        }
        return this.dqtag3;
    }

    public boolean isDQTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDQTag3Dirty();
        }
        return this.dqtag3DirtyFlag;
    }

    public void resetDQTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDQTag3();
            return;
        }
        this.dqtag3DirtyFlag = false;
        this.dqtag3 = null;
    }

    public void setDQTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDQTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dqtag4 = string;
        this.dqtag4DirtyFlag = true;
    }

    public String getDQTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDQTag4();
        }
        return this.dqtag4;
    }

    public boolean isDQTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDQTag4Dirty();
        }
        return this.dqtag4DirtyFlag;
    }

    public void resetDQTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDQTag4();
            return;
        }
        this.dqtag4DirtyFlag = false;
        this.dqtag4 = null;
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

    public void setEnablePQL(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePQL(n);
            return;
        }
        this.enablepql = n;
        this.enablepqlDirtyFlag = true;
    }

    public Integer getEnablePQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePQL();
        }
        return this.enablepql;
    }

    public boolean isEnablePQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePQLDirty();
        }
        return this.enablepqlDirtyFlag;
    }

    public void resetEnablePQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePQL();
            return;
        }
        this.enablepqlDirtyFlag = false;
        this.enablepql = null;
    }

    public void setExtendMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendMode(n);
            return;
        }
        this.extendmode = n;
        this.extendmodeDirtyFlag = true;
    }

    public Integer getExtendMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendMode();
        }
        return this.extendmode;
    }

    public boolean isExtendModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendModeDirty();
        }
        return this.extendmodeDirtyFlag;
    }

    public void resetExtendMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendMode();
            return;
        }
        this.extendmodeDirtyFlag = false;
        this.extendmode = null;
    }

    public void setFilterModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filtermodel = string;
        this.filtermodelDirtyFlag = true;
    }

    public String getFilterModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterModel();
        }
        return this.filtermodel;
    }

    public boolean isFilterModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterModelDirty();
        }
        return this.filtermodelDirtyFlag;
    }

    public void resetFilterModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterModel();
            return;
        }
        this.filtermodelDirtyFlag = false;
        this.filtermodel = null;
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

    public void setPrivMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrivMode(n);
            return;
        }
        this.privmode = n;
        this.privmodeDirtyFlag = true;
    }

    public Integer getPrivMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrivMode();
        }
        return this.privmode;
    }

    public boolean isPrivModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrivModeDirty();
        }
        return this.privmodeDirtyFlag;
    }

    public void resetPrivMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrivMode();
            return;
        }
        this.privmodeDirtyFlag = false;
        this.privmode = null;
    }

    public void setPSDEDataQueryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQueryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataqueryid = string;
        this.psdedataqueryidDirtyFlag = true;
    }

    public String getPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueryId();
        }
        return this.psdedataqueryid;
    }

    public boolean isPSDEDataQueryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQueryIdDirty();
        }
        return this.psdedataqueryidDirtyFlag;
    }

    public void resetPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQueryId();
            return;
        }
        this.psdedataqueryidDirtyFlag = false;
        this.psdedataqueryid = null;
    }

    public void setPSDEDataQueryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQueryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataqueryname = string;
        this.psdedataquerynameDirtyFlag = true;
    }

    public String getPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueryName();
        }
        return this.psdedataqueryname;
    }

    public boolean isPSDEDataQueryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQueryNameDirty();
        }
        return this.psdedataquerynameDirtyFlag;
    }

    public void resetPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQueryName();
            return;
        }
        this.psdedataquerynameDirtyFlag = false;
        this.psdedataqueryname = null;
    }

    public void setPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupid = string;
        this.psdefgroupidDirtyFlag = true;
    }

    public String getPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupId();
        }
        return this.psdefgroupid;
    }

    public boolean isPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupIdDirty();
        }
        return this.psdefgroupidDirtyFlag;
    }

    public void resetPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupId();
            return;
        }
        this.psdefgroupidDirtyFlag = false;
        this.psdefgroupid = null;
    }

    public void setPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupname = string;
        this.psdefgroupnameDirtyFlag = true;
    }

    public String getPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupName();
        }
        return this.psdefgroupname;
    }

    public boolean isPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupNameDirty();
        }
        return this.psdefgroupnameDirtyFlag;
    }

    public void resetPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupName();
            return;
        }
        this.psdefgroupnameDirtyFlag = false;
        this.psdefgroupname = null;
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

    public void setPSDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstateid = string;
        this.psdemainstateidDirtyFlag = true;
    }

    public String getPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateId();
        }
        return this.psdemainstateid;
    }

    public boolean isPSDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateIdDirty();
        }
        return this.psdemainstateidDirtyFlag;
    }

    public void resetPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateId();
            return;
        }
        this.psdemainstateidDirtyFlag = false;
        this.psdemainstateid = null;
    }

    public void setPSDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatename = string;
        this.psdemainstatenameDirtyFlag = true;
    }

    public String getPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateName();
        }
        return this.psdemainstatename;
    }

    public boolean isPSDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateNameDirty();
        }
        return this.psdemainstatenameDirtyFlag;
    }

    public void resetPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateName();
            return;
        }
        this.psdemainstatenameDirtyFlag = false;
        this.psdemainstatename = null;
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

    public void setPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubMode(n);
            return;
        }
        this.pubmode = n;
        this.pubmodeDirtyFlag = true;
    }

    public Integer getPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubMode();
        }
        return this.pubmode;
    }

    public boolean isPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModeDirty();
        }
        return this.pubmodeDirtyFlag;
    }

    public void resetPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubMode();
            return;
        }
        this.pubmodeDirtyFlag = false;
        this.pubmode = null;
    }

    public void setQueryViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryViewFlag(n);
            return;
        }
        this.queryviewflag = n;
        this.queryviewflagDirtyFlag = true;
    }

    public Integer getQueryViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryViewFlag();
        }
        return this.queryviewflag;
    }

    public boolean isQueryViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryViewFlagDirty();
        }
        return this.queryviewflagDirtyFlag;
    }

    public void resetQueryViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryViewFlag();
            return;
        }
        this.queryviewflagDirtyFlag = false;
        this.queryviewflag = null;
    }

    public void setRequestMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestmethod = string;
        this.requestmethodDirtyFlag = true;
    }

    public String getRequestMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestMethod();
        }
        return this.requestmethod;
    }

    public boolean isRequestMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestMethodDirty();
        }
        return this.requestmethodDirtyFlag;
    }

    public void resetRequestMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestMethod();
            return;
        }
        this.requestmethodDirtyFlag = false;
        this.requestmethod = null;
    }

    public void setRequestPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestpath = string;
        this.requestpathDirtyFlag = true;
    }

    public String getRequestPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestPath();
        }
        return this.requestpath;
    }

    public boolean isRequestPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestPathDirty();
        }
        return this.requestpathDirtyFlag;
    }

    public void resetRequestPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestPath();
            return;
        }
        this.requestpathDirtyFlag = false;
        this.requestpath = null;
    }

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
    }

    public void setSubSysSADetailMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysSADetailMode(n);
            return;
        }
        this.subsyssadetailmode = n;
        this.subsyssadetailmodeDirtyFlag = true;
    }

    public Integer getSubSysSADetailMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysSADetailMode();
        }
        return this.subsyssadetailmode;
    }

    public boolean isSubSysSADetailModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysSADetailModeDirty();
        }
        return this.subsyssadetailmodeDirtyFlag;
    }

    public void resetSubSysSADetailMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysSADetailMode();
            return;
        }
        this.subsyssadetailmodeDirtyFlag = false;
        this.subsyssadetailmode = null;
    }

    public void setToDoTask(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTask(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotask = string;
        this.todotaskDirtyFlag = true;
    }

    public String getToDoTask() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTask();
        }
        return this.todotask;
    }

    public boolean isToDoTaskDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskDirty();
        }
        return this.todotaskDirtyFlag;
    }

    public void resetToDoTask() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTask();
            return;
        }
        this.todotaskDirtyFlag = false;
        this.todotask = null;
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

    public void setViewColLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewColLevel(n);
            return;
        }
        this.viewcollevel = n;
        this.viewcollevelDirtyFlag = true;
    }

    public Integer getViewColLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewColLevel();
        }
        return this.viewcollevel;
    }

    public boolean isViewColLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewColLevelDirty();
        }
        return this.viewcollevelDirtyFlag;
    }

    public void resetViewColLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewColLevel();
            return;
        }
        this.viewcollevelDirtyFlag = false;
        this.viewcollevel = null;
    }

    protected void onReset() {
        PSDEDataQueryBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataQueryBase pSDEDataQueryBase) {
        pSDEDataQueryBase.resetCodeName();
        pSDEDataQueryBase.resetCreateDate();
        pSDEDataQueryBase.resetCreateMan();
        pSDEDataQueryBase.resetCustomCode();
        pSDEDataQueryBase.resetCustomMode();
        pSDEDataQueryBase.resetDefaultMode();
        pSDEDataQueryBase.resetDQJoinModel();
        pSDEDataQueryBase.resetDQOption();
        pSDEDataQueryBase.resetDQSN();
        pSDEDataQueryBase.resetDQTag();
        pSDEDataQueryBase.resetDQTag2();
        pSDEDataQueryBase.resetDQTag3();
        pSDEDataQueryBase.resetDQTag4();
        pSDEDataQueryBase.resetDynaModelFlag();
        pSDEDataQueryBase.resetEnablePQL();
        pSDEDataQueryBase.resetExtendMode();
        pSDEDataQueryBase.resetFilterModel();
        pSDEDataQueryBase.resetLockFlag();
        pSDEDataQueryBase.resetLogicName();
        pSDEDataQueryBase.resetMemo();
        pSDEDataQueryBase.resetOrderValue();
        pSDEDataQueryBase.resetPrivMode();
        pSDEDataQueryBase.resetPSDEDataQueryId();
        pSDEDataQueryBase.resetPSDEDataQueryName();
        pSDEDataQueryBase.resetPSDEFGroupId();
        pSDEDataQueryBase.resetPSDEFGroupName();
        pSDEDataQueryBase.resetPSDEId();
        pSDEDataQueryBase.resetPSDEMainStateId();
        pSDEDataQueryBase.resetPSDEMainStateName();
        pSDEDataQueryBase.resetPSDEName();
        pSDEDataQueryBase.resetPSDynaInstId();
        pSDEDataQueryBase.resetPubMode();
        pSDEDataQueryBase.resetQueryViewFlag();
        pSDEDataQueryBase.resetRequestMethod();
        pSDEDataQueryBase.resetRequestPath();
        pSDEDataQueryBase.resetServiceCodeName();
        pSDEDataQueryBase.resetSubSysSADetailMode();
        pSDEDataQueryBase.resetToDoTask();
        pSDEDataQueryBase.resetUpdateDate();
        pSDEDataQueryBase.resetUpdateMan();
        pSDEDataQueryBase.resetUserCat();
        pSDEDataQueryBase.resetUserTag();
        pSDEDataQueryBase.resetUserTag2();
        pSDEDataQueryBase.resetUserTag3();
        pSDEDataQueryBase.resetUserTag4();
        pSDEDataQueryBase.resetValidFlag();
        pSDEDataQueryBase.resetViewColLevel();
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isDQJoinModelDirty()) {
            hashMap.put(FIELD_DQJOINMODEL, this.getDQJoinModel());
        }
        if (!bl || this.isDQOptionDirty()) {
            hashMap.put(FIELD_DQOPTION, this.getDQOption());
        }
        if (!bl || this.isDQSNDirty()) {
            hashMap.put(FIELD_DQSN, this.getDQSN());
        }
        if (!bl || this.isDQTagDirty()) {
            hashMap.put(FIELD_DQTAG, this.getDQTag());
        }
        if (!bl || this.isDQTag2Dirty()) {
            hashMap.put(FIELD_DQTAG2, this.getDQTag2());
        }
        if (!bl || this.isDQTag3Dirty()) {
            hashMap.put(FIELD_DQTAG3, this.getDQTag3());
        }
        if (!bl || this.isDQTag4Dirty()) {
            hashMap.put(FIELD_DQTAG4, this.getDQTag4());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnablePQLDirty()) {
            hashMap.put(FIELD_ENABLEPQL, this.getEnablePQL());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isFilterModelDirty()) {
            hashMap.put(FIELD_FILTERMODEL, this.getFilterModel());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPrivModeDirty()) {
            hashMap.put(FIELD_PRIVMODE, this.getPrivMode());
        }
        if (!bl || this.isPSDEDataQueryIdDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYID, this.getPSDEDataQueryId());
        }
        if (!bl || this.isPSDEDataQueryNameDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYNAME, this.getPSDEDataQueryName());
        }
        if (!bl || this.isPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPID, this.getPSDEFGroupId());
        }
        if (!bl || this.isPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPNAME, this.getPSDEFGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATEID, this.getPSDEMainStateId());
        }
        if (!bl || this.isPSDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATENAME, this.getPSDEMainStateName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isQueryViewFlagDirty()) {
            hashMap.put(FIELD_QUERYVIEWFLAG, this.getQueryViewFlag());
        }
        if (!bl || this.isRequestMethodDirty()) {
            hashMap.put(FIELD_REQUESTMETHOD, this.getRequestMethod());
        }
        if (!bl || this.isRequestPathDirty()) {
            hashMap.put(FIELD_REQUESTPATH, this.getRequestPath());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isSubSysSADetailModeDirty()) {
            hashMap.put(FIELD_SUBSYSSADETAILMODE, this.getSubSysSADetailMode());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
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
        if (!bl || this.isViewColLevelDirty()) {
            hashMap.put(FIELD_VIEWCOLLEVEL, this.getViewColLevel());
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
        return PSDEDataQueryBase.get(this, n);
    }

    private static Object get(PSDEDataQueryBase pSDEDataQueryBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataQueryBase.getCodeName();
            }
            case 1: {
                return pSDEDataQueryBase.getCreateDate();
            }
            case 2: {
                return pSDEDataQueryBase.getCreateMan();
            }
            case 3: {
                return pSDEDataQueryBase.getCustomCode();
            }
            case 4: {
                return pSDEDataQueryBase.getCustomMode();
            }
            case 5: {
                return pSDEDataQueryBase.getDefaultMode();
            }
            case 6: {
                return pSDEDataQueryBase.getDQJoinModel();
            }
            case 7: {
                return pSDEDataQueryBase.getDQOption();
            }
            case 8: {
                return pSDEDataQueryBase.getDQSN();
            }
            case 9: {
                return pSDEDataQueryBase.getDQTag();
            }
            case 10: {
                return pSDEDataQueryBase.getDQTag2();
            }
            case 11: {
                return pSDEDataQueryBase.getDQTag3();
            }
            case 12: {
                return pSDEDataQueryBase.getDQTag4();
            }
            case 13: {
                return pSDEDataQueryBase.getDynaModelFlag();
            }
            case 14: {
                return pSDEDataQueryBase.getEnablePQL();
            }
            case 15: {
                return pSDEDataQueryBase.getExtendMode();
            }
            case 16: {
                return pSDEDataQueryBase.getFilterModel();
            }
            case 17: {
                return pSDEDataQueryBase.getLockFlag();
            }
            case 18: {
                return pSDEDataQueryBase.getLogicName();
            }
            case 19: {
                return pSDEDataQueryBase.getMemo();
            }
            case 20: {
                return pSDEDataQueryBase.getOrderValue();
            }
            case 21: {
                return pSDEDataQueryBase.getPrivMode();
            }
            case 22: {
                return pSDEDataQueryBase.getPSDEDataQueryId();
            }
            case 23: {
                return pSDEDataQueryBase.getPSDEDataQueryName();
            }
            case 24: {
                return pSDEDataQueryBase.getPSDEFGroupId();
            }
            case 25: {
                return pSDEDataQueryBase.getPSDEFGroupName();
            }
            case 26: {
                return pSDEDataQueryBase.getPSDEId();
            }
            case 27: {
                return pSDEDataQueryBase.getPSDEMainStateId();
            }
            case 28: {
                return pSDEDataQueryBase.getPSDEMainStateName();
            }
            case 29: {
                return pSDEDataQueryBase.getPSDEName();
            }
            case 30: {
                return pSDEDataQueryBase.getPSDynaInstId();
            }
            case 31: {
                return pSDEDataQueryBase.getPubMode();
            }
            case 32: {
                return pSDEDataQueryBase.getQueryViewFlag();
            }
            case 33: {
                return pSDEDataQueryBase.getRequestMethod();
            }
            case 34: {
                return pSDEDataQueryBase.getRequestPath();
            }
            case 35: {
                return pSDEDataQueryBase.getServiceCodeName();
            }
            case 36: {
                return pSDEDataQueryBase.getSubSysSADetailMode();
            }
            case 37: {
                return pSDEDataQueryBase.getToDoTask();
            }
            case 38: {
                return pSDEDataQueryBase.getUpdateDate();
            }
            case 39: {
                return pSDEDataQueryBase.getUpdateMan();
            }
            case 40: {
                return pSDEDataQueryBase.getUserCat();
            }
            case 41: {
                return pSDEDataQueryBase.getUserTag();
            }
            case 42: {
                return pSDEDataQueryBase.getUserTag2();
            }
            case 43: {
                return pSDEDataQueryBase.getUserTag3();
            }
            case 44: {
                return pSDEDataQueryBase.getUserTag4();
            }
            case 45: {
                return pSDEDataQueryBase.getValidFlag();
            }
            case 46: {
                return pSDEDataQueryBase.getViewColLevel();
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
        PSDEDataQueryBase.set(this, n, object);
    }

    private static void set(PSDEDataQueryBase pSDEDataQueryBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataQueryBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataQueryBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataQueryBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataQueryBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataQueryBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataQueryBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataQueryBase.setDQJoinModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataQueryBase.setDQOption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataQueryBase.setDQSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataQueryBase.setDQTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataQueryBase.setDQTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataQueryBase.setDQTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataQueryBase.setDQTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataQueryBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataQueryBase.setEnablePQL(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataQueryBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataQueryBase.setFilterModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataQueryBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataQueryBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataQueryBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataQueryBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataQueryBase.setPrivMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataQueryBase.setPSDEDataQueryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataQueryBase.setPSDEDataQueryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataQueryBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataQueryBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataQueryBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataQueryBase.setPSDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataQueryBase.setPSDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataQueryBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataQueryBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataQueryBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataQueryBase.setQueryViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataQueryBase.setRequestMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDataQueryBase.setRequestPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDataQueryBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDataQueryBase.setSubSysSADetailMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEDataQueryBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDataQueryBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 39: {
                pSDEDataQueryBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDataQueryBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDataQueryBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEDataQueryBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEDataQueryBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEDataQueryBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEDataQueryBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDEDataQueryBase.setViewColLevel(DataObject.getIntegerValue((Object)object));
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
        return PSDEDataQueryBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataQueryBase pSDEDataQueryBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataQueryBase.getCodeName() == null;
            }
            case 1: {
                return pSDEDataQueryBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEDataQueryBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEDataQueryBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEDataQueryBase.getCustomMode() == null;
            }
            case 5: {
                return pSDEDataQueryBase.getDefaultMode() == null;
            }
            case 6: {
                return pSDEDataQueryBase.getDQJoinModel() == null;
            }
            case 7: {
                return pSDEDataQueryBase.getDQOption() == null;
            }
            case 8: {
                return pSDEDataQueryBase.getDQSN() == null;
            }
            case 9: {
                return pSDEDataQueryBase.getDQTag() == null;
            }
            case 10: {
                return pSDEDataQueryBase.getDQTag2() == null;
            }
            case 11: {
                return pSDEDataQueryBase.getDQTag3() == null;
            }
            case 12: {
                return pSDEDataQueryBase.getDQTag4() == null;
            }
            case 13: {
                return pSDEDataQueryBase.getDynaModelFlag() == null;
            }
            case 14: {
                return pSDEDataQueryBase.getEnablePQL() == null;
            }
            case 15: {
                return pSDEDataQueryBase.getExtendMode() == null;
            }
            case 16: {
                return pSDEDataQueryBase.getFilterModel() == null;
            }
            case 17: {
                return pSDEDataQueryBase.getLockFlag() == null;
            }
            case 18: {
                return pSDEDataQueryBase.getLogicName() == null;
            }
            case 19: {
                return pSDEDataQueryBase.getMemo() == null;
            }
            case 20: {
                return pSDEDataQueryBase.getOrderValue() == null;
            }
            case 21: {
                return pSDEDataQueryBase.getPrivMode() == null;
            }
            case 22: {
                return pSDEDataQueryBase.getPSDEDataQueryId() == null;
            }
            case 23: {
                return pSDEDataQueryBase.getPSDEDataQueryName() == null;
            }
            case 24: {
                return pSDEDataQueryBase.getPSDEFGroupId() == null;
            }
            case 25: {
                return pSDEDataQueryBase.getPSDEFGroupName() == null;
            }
            case 26: {
                return pSDEDataQueryBase.getPSDEId() == null;
            }
            case 27: {
                return pSDEDataQueryBase.getPSDEMainStateId() == null;
            }
            case 28: {
                return pSDEDataQueryBase.getPSDEMainStateName() == null;
            }
            case 29: {
                return pSDEDataQueryBase.getPSDEName() == null;
            }
            case 30: {
                return pSDEDataQueryBase.getPSDynaInstId() == null;
            }
            case 31: {
                return pSDEDataQueryBase.getPubMode() == null;
            }
            case 32: {
                return pSDEDataQueryBase.getQueryViewFlag() == null;
            }
            case 33: {
                return pSDEDataQueryBase.getRequestMethod() == null;
            }
            case 34: {
                return pSDEDataQueryBase.getRequestPath() == null;
            }
            case 35: {
                return pSDEDataQueryBase.getServiceCodeName() == null;
            }
            case 36: {
                return pSDEDataQueryBase.getSubSysSADetailMode() == null;
            }
            case 37: {
                return pSDEDataQueryBase.getToDoTask() == null;
            }
            case 38: {
                return pSDEDataQueryBase.getUpdateDate() == null;
            }
            case 39: {
                return pSDEDataQueryBase.getUpdateMan() == null;
            }
            case 40: {
                return pSDEDataQueryBase.getUserCat() == null;
            }
            case 41: {
                return pSDEDataQueryBase.getUserTag() == null;
            }
            case 42: {
                return pSDEDataQueryBase.getUserTag2() == null;
            }
            case 43: {
                return pSDEDataQueryBase.getUserTag3() == null;
            }
            case 44: {
                return pSDEDataQueryBase.getUserTag4() == null;
            }
            case 45: {
                return pSDEDataQueryBase.getValidFlag() == null;
            }
            case 46: {
                return pSDEDataQueryBase.getViewColLevel() == null;
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
        return PSDEDataQueryBase.contains(this, n);
    }

    private static boolean contains(PSDEDataQueryBase pSDEDataQueryBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataQueryBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEDataQueryBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEDataQueryBase.isCreateManDirty();
            }
            case 3: {
                return pSDEDataQueryBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEDataQueryBase.isCustomModeDirty();
            }
            case 5: {
                return pSDEDataQueryBase.isDefaultModeDirty();
            }
            case 6: {
                return pSDEDataQueryBase.isDQJoinModelDirty();
            }
            case 7: {
                return pSDEDataQueryBase.isDQOptionDirty();
            }
            case 8: {
                return pSDEDataQueryBase.isDQSNDirty();
            }
            case 9: {
                return pSDEDataQueryBase.isDQTagDirty();
            }
            case 10: {
                return pSDEDataQueryBase.isDQTag2Dirty();
            }
            case 11: {
                return pSDEDataQueryBase.isDQTag3Dirty();
            }
            case 12: {
                return pSDEDataQueryBase.isDQTag4Dirty();
            }
            case 13: {
                return pSDEDataQueryBase.isDynaModelFlagDirty();
            }
            case 14: {
                return pSDEDataQueryBase.isEnablePQLDirty();
            }
            case 15: {
                return pSDEDataQueryBase.isExtendModeDirty();
            }
            case 16: {
                return pSDEDataQueryBase.isFilterModelDirty();
            }
            case 17: {
                return pSDEDataQueryBase.isLockFlagDirty();
            }
            case 18: {
                return pSDEDataQueryBase.isLogicNameDirty();
            }
            case 19: {
                return pSDEDataQueryBase.isMemoDirty();
            }
            case 20: {
                return pSDEDataQueryBase.isOrderValueDirty();
            }
            case 21: {
                return pSDEDataQueryBase.isPrivModeDirty();
            }
            case 22: {
                return pSDEDataQueryBase.isPSDEDataQueryIdDirty();
            }
            case 23: {
                return pSDEDataQueryBase.isPSDEDataQueryNameDirty();
            }
            case 24: {
                return pSDEDataQueryBase.isPSDEFGroupIdDirty();
            }
            case 25: {
                return pSDEDataQueryBase.isPSDEFGroupNameDirty();
            }
            case 26: {
                return pSDEDataQueryBase.isPSDEIdDirty();
            }
            case 27: {
                return pSDEDataQueryBase.isPSDEMainStateIdDirty();
            }
            case 28: {
                return pSDEDataQueryBase.isPSDEMainStateNameDirty();
            }
            case 29: {
                return pSDEDataQueryBase.isPSDENameDirty();
            }
            case 30: {
                return pSDEDataQueryBase.isPSDynaInstIdDirty();
            }
            case 31: {
                return pSDEDataQueryBase.isPubModeDirty();
            }
            case 32: {
                return pSDEDataQueryBase.isQueryViewFlagDirty();
            }
            case 33: {
                return pSDEDataQueryBase.isRequestMethodDirty();
            }
            case 34: {
                return pSDEDataQueryBase.isRequestPathDirty();
            }
            case 35: {
                return pSDEDataQueryBase.isServiceCodeNameDirty();
            }
            case 36: {
                return pSDEDataQueryBase.isSubSysSADetailModeDirty();
            }
            case 37: {
                return pSDEDataQueryBase.isToDoTaskDirty();
            }
            case 38: {
                return pSDEDataQueryBase.isUpdateDateDirty();
            }
            case 39: {
                return pSDEDataQueryBase.isUpdateManDirty();
            }
            case 40: {
                return pSDEDataQueryBase.isUserCatDirty();
            }
            case 41: {
                return pSDEDataQueryBase.isUserTagDirty();
            }
            case 42: {
                return pSDEDataQueryBase.isUserTag2Dirty();
            }
            case 43: {
                return pSDEDataQueryBase.isUserTag3Dirty();
            }
            case 44: {
                return pSDEDataQueryBase.isUserTag4Dirty();
            }
            case 45: {
                return pSDEDataQueryBase.isValidFlagDirty();
            }
            case 46: {
                return pSDEDataQueryBase.isViewColLevelDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataQueryBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataQueryBase pSDEDataQueryBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataQueryBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDQJoinModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dqjoinmodel", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDQJoinModel()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDQOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dqoption", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDQOption()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDQSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dqsn", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDQSN()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDQTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dqtag", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDQTag()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDQTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dqtag2", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDQTag2()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDQTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dqtag3", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDQTag3()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDQTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dqtag4", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDQTag4()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getEnablePQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepql", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getEnablePQL()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getFilterModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filtermodel", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getFilterModel()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPrivMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"privmode", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPrivMode()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDEDataQueryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryid", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDEDataQueryId()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDEDataQueryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryname", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDEDataQueryName()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstateid", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDEMainStateId()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatename", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDEMainStateName()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getPubMode()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getQueryViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"queryviewflag", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getQueryViewFlag()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getRequestMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestmethod", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getRequestMethod()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getRequestPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestpath", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getRequestPath()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getSubSysSADetailMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsyssadetailmode", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getSubSysSADetailMode()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEDataQueryBase.getViewColLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewcollevel", (Object)PSDEDataQueryBase.getJSONValue((Object)pSDEDataQueryBase.getViewColLevel()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataQueryBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataQueryBase pSDEDataQueryBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataQueryBase.getCodeName() != null) {
            object = pSDEDataQueryBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getCreateDate() != null) {
            object = pSDEDataQueryBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getCreateMan() != null) {
            object = pSDEDataQueryBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getCustomCode() != null) {
            object = pSDEDataQueryBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getCustomMode() != null) {
            object = pSDEDataQueryBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getDefaultMode() != null) {
            object = pSDEDataQueryBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getDQJoinModel() != null) {
            object = pSDEDataQueryBase.getDQJoinModel();
            xmlNode.setAttribute(FIELD_DQJOINMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getDQOption() != null) {
            object = pSDEDataQueryBase.getDQOption();
            xmlNode.setAttribute(FIELD_DQOPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getDQSN() != null) {
            object = pSDEDataQueryBase.getDQSN();
            xmlNode.setAttribute(FIELD_DQSN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getDQTag() != null) {
            object = pSDEDataQueryBase.getDQTag();
            xmlNode.setAttribute(FIELD_DQTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getDQTag2() != null) {
            object = pSDEDataQueryBase.getDQTag2();
            xmlNode.setAttribute(FIELD_DQTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getDQTag3() != null) {
            object = pSDEDataQueryBase.getDQTag3();
            xmlNode.setAttribute(FIELD_DQTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getDQTag4() != null) {
            object = pSDEDataQueryBase.getDQTag4();
            xmlNode.setAttribute(FIELD_DQTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getDynaModelFlag() != null) {
            object = pSDEDataQueryBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getEnablePQL() != null) {
            object = pSDEDataQueryBase.getEnablePQL();
            xmlNode.setAttribute(FIELD_ENABLEPQL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getExtendMode() != null) {
            object = pSDEDataQueryBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getFilterModel() != null) {
            object = pSDEDataQueryBase.getFilterModel();
            xmlNode.setAttribute(FIELD_FILTERMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getLockFlag() != null) {
            object = pSDEDataQueryBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getLogicName() != null) {
            object = pSDEDataQueryBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getMemo() != null) {
            object = pSDEDataQueryBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getOrderValue() != null) {
            object = pSDEDataQueryBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getPrivMode() != null) {
            object = pSDEDataQueryBase.getPrivMode();
            xmlNode.setAttribute(FIELD_PRIVMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getPSDEDataQueryId() != null) {
            object = pSDEDataQueryBase.getPSDEDataQueryId();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPSDEDataQueryName() != null) {
            object = pSDEDataQueryBase.getPSDEDataQueryName();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPSDEFGroupId() != null) {
            object = pSDEDataQueryBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPSDEFGroupName() != null) {
            object = pSDEDataQueryBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPSDEId() != null) {
            object = pSDEDataQueryBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPSDEMainStateId() != null) {
            object = pSDEDataQueryBase.getPSDEMainStateId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPSDEMainStateName() != null) {
            object = pSDEDataQueryBase.getPSDEMainStateName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPSDEName() != null) {
            object = pSDEDataQueryBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPSDynaInstId() != null) {
            object = pSDEDataQueryBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getPubMode() != null) {
            object = pSDEDataQueryBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getQueryViewFlag() != null) {
            object = pSDEDataQueryBase.getQueryViewFlag();
            xmlNode.setAttribute(FIELD_QUERYVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getRequestMethod() != null) {
            object = pSDEDataQueryBase.getRequestMethod();
            xmlNode.setAttribute(FIELD_REQUESTMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getRequestPath() != null) {
            object = pSDEDataQueryBase.getRequestPath();
            xmlNode.setAttribute(FIELD_REQUESTPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getServiceCodeName() != null) {
            object = pSDEDataQueryBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getSubSysSADetailMode() != null) {
            object = pSDEDataQueryBase.getSubSysSADetailMode();
            xmlNode.setAttribute(FIELD_SUBSYSSADETAILMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getToDoTask() != null) {
            object = pSDEDataQueryBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getUpdateDate() != null) {
            object = pSDEDataQueryBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getUpdateMan() != null) {
            object = pSDEDataQueryBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getUserCat() != null) {
            object = pSDEDataQueryBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getUserTag() != null) {
            object = pSDEDataQueryBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getUserTag2() != null) {
            object = pSDEDataQueryBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getUserTag3() != null) {
            object = pSDEDataQueryBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getUserTag4() != null) {
            object = pSDEDataQueryBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataQueryBase.getValidFlag() != null) {
            object = pSDEDataQueryBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataQueryBase.getViewColLevel() != null) {
            object = pSDEDataQueryBase.getViewColLevel();
            xmlNode.setAttribute(FIELD_VIEWCOLLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataQueryBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataQueryBase pSDEDataQueryBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataQueryBase.isCodeNameDirty() && (bl || pSDEDataQueryBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDataQueryBase.getCodeName());
        }
        if (pSDEDataQueryBase.isCreateDateDirty() && (bl || pSDEDataQueryBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataQueryBase.getCreateDate());
        }
        if (pSDEDataQueryBase.isCreateManDirty() && (bl || pSDEDataQueryBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataQueryBase.getCreateMan());
        }
        if (pSDEDataQueryBase.isCustomCodeDirty() && (bl || pSDEDataQueryBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEDataQueryBase.getCustomCode());
        }
        if (pSDEDataQueryBase.isCustomModeDirty() && (bl || pSDEDataQueryBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEDataQueryBase.getCustomMode());
        }
        if (pSDEDataQueryBase.isDefaultModeDirty() && (bl || pSDEDataQueryBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSDEDataQueryBase.getDefaultMode());
        }
        if (pSDEDataQueryBase.isDQJoinModelDirty() && (bl || pSDEDataQueryBase.getDQJoinModel() != null)) {
            iDataObject.set(FIELD_DQJOINMODEL, (Object)pSDEDataQueryBase.getDQJoinModel());
        }
        if (pSDEDataQueryBase.isDQOptionDirty() && (bl || pSDEDataQueryBase.getDQOption() != null)) {
            iDataObject.set(FIELD_DQOPTION, (Object)pSDEDataQueryBase.getDQOption());
        }
        if (pSDEDataQueryBase.isDQSNDirty() && (bl || pSDEDataQueryBase.getDQSN() != null)) {
            iDataObject.set(FIELD_DQSN, (Object)pSDEDataQueryBase.getDQSN());
        }
        if (pSDEDataQueryBase.isDQTagDirty() && (bl || pSDEDataQueryBase.getDQTag() != null)) {
            iDataObject.set(FIELD_DQTAG, (Object)pSDEDataQueryBase.getDQTag());
        }
        if (pSDEDataQueryBase.isDQTag2Dirty() && (bl || pSDEDataQueryBase.getDQTag2() != null)) {
            iDataObject.set(FIELD_DQTAG2, (Object)pSDEDataQueryBase.getDQTag2());
        }
        if (pSDEDataQueryBase.isDQTag3Dirty() && (bl || pSDEDataQueryBase.getDQTag3() != null)) {
            iDataObject.set(FIELD_DQTAG3, (Object)pSDEDataQueryBase.getDQTag3());
        }
        if (pSDEDataQueryBase.isDQTag4Dirty() && (bl || pSDEDataQueryBase.getDQTag4() != null)) {
            iDataObject.set(FIELD_DQTAG4, (Object)pSDEDataQueryBase.getDQTag4());
        }
        if (pSDEDataQueryBase.isDynaModelFlagDirty() && (bl || pSDEDataQueryBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDataQueryBase.getDynaModelFlag());
        }
        if (pSDEDataQueryBase.isEnablePQLDirty() && (bl || pSDEDataQueryBase.getEnablePQL() != null)) {
            iDataObject.set(FIELD_ENABLEPQL, (Object)pSDEDataQueryBase.getEnablePQL());
        }
        if (pSDEDataQueryBase.isExtendModeDirty() && (bl || pSDEDataQueryBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEDataQueryBase.getExtendMode());
        }
        if (pSDEDataQueryBase.isFilterModelDirty() && (bl || pSDEDataQueryBase.getFilterModel() != null)) {
            iDataObject.set(FIELD_FILTERMODEL, (Object)pSDEDataQueryBase.getFilterModel());
        }
        if (pSDEDataQueryBase.isLockFlagDirty() && (bl || pSDEDataQueryBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDataQueryBase.getLockFlag());
        }
        if (pSDEDataQueryBase.isLogicNameDirty() && (bl || pSDEDataQueryBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEDataQueryBase.getLogicName());
        }
        if (pSDEDataQueryBase.isMemoDirty() && (bl || pSDEDataQueryBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataQueryBase.getMemo());
        }
        if (pSDEDataQueryBase.isOrderValueDirty() && (bl || pSDEDataQueryBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDataQueryBase.getOrderValue());
        }
        if (pSDEDataQueryBase.isPrivModeDirty() && (bl || pSDEDataQueryBase.getPrivMode() != null)) {
            iDataObject.set(FIELD_PRIVMODE, (Object)pSDEDataQueryBase.getPrivMode());
        }
        if (pSDEDataQueryBase.isPSDEDataQueryIdDirty() && (bl || pSDEDataQueryBase.getPSDEDataQueryId() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYID, (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        }
        if (pSDEDataQueryBase.isPSDEDataQueryNameDirty() && (bl || pSDEDataQueryBase.getPSDEDataQueryName() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYNAME, (Object)pSDEDataQueryBase.getPSDEDataQueryName());
        }
        if (pSDEDataQueryBase.isPSDEFGroupIdDirty() && (bl || pSDEDataQueryBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSDEDataQueryBase.getPSDEFGroupId());
        }
        if (pSDEDataQueryBase.isPSDEFGroupNameDirty() && (bl || pSDEDataQueryBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSDEDataQueryBase.getPSDEFGroupName());
        }
        if (pSDEDataQueryBase.isPSDEIdDirty() && (bl || pSDEDataQueryBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataQueryBase.getPSDEId());
        }
        if (pSDEDataQueryBase.isPSDEMainStateIdDirty() && (bl || pSDEDataQueryBase.getPSDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATEID, (Object)pSDEDataQueryBase.getPSDEMainStateId());
        }
        if (pSDEDataQueryBase.isPSDEMainStateNameDirty() && (bl || pSDEDataQueryBase.getPSDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATENAME, (Object)pSDEDataQueryBase.getPSDEMainStateName());
        }
        if (pSDEDataQueryBase.isPSDENameDirty() && (bl || pSDEDataQueryBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDataQueryBase.getPSDEName());
        }
        if (pSDEDataQueryBase.isPSDynaInstIdDirty() && (bl || pSDEDataQueryBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDataQueryBase.getPSDynaInstId());
        }
        if (pSDEDataQueryBase.isPubModeDirty() && (bl || pSDEDataQueryBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSDEDataQueryBase.getPubMode());
        }
        if (pSDEDataQueryBase.isQueryViewFlagDirty() && (bl || pSDEDataQueryBase.getQueryViewFlag() != null)) {
            iDataObject.set(FIELD_QUERYVIEWFLAG, (Object)pSDEDataQueryBase.getQueryViewFlag());
        }
        if (pSDEDataQueryBase.isRequestMethodDirty() && (bl || pSDEDataQueryBase.getRequestMethod() != null)) {
            iDataObject.set(FIELD_REQUESTMETHOD, (Object)pSDEDataQueryBase.getRequestMethod());
        }
        if (pSDEDataQueryBase.isRequestPathDirty() && (bl || pSDEDataQueryBase.getRequestPath() != null)) {
            iDataObject.set(FIELD_REQUESTPATH, (Object)pSDEDataQueryBase.getRequestPath());
        }
        if (pSDEDataQueryBase.isServiceCodeNameDirty() && (bl || pSDEDataQueryBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDEDataQueryBase.getServiceCodeName());
        }
        if (pSDEDataQueryBase.isSubSysSADetailModeDirty() && (bl || pSDEDataQueryBase.getSubSysSADetailMode() != null)) {
            iDataObject.set(FIELD_SUBSYSSADETAILMODE, (Object)pSDEDataQueryBase.getSubSysSADetailMode());
        }
        if (pSDEDataQueryBase.isToDoTaskDirty() && (bl || pSDEDataQueryBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEDataQueryBase.getToDoTask());
        }
        if (pSDEDataQueryBase.isUpdateDateDirty() && (bl || pSDEDataQueryBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataQueryBase.getUpdateDate());
        }
        if (pSDEDataQueryBase.isUpdateManDirty() && (bl || pSDEDataQueryBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataQueryBase.getUpdateMan());
        }
        if (pSDEDataQueryBase.isUserCatDirty() && (bl || pSDEDataQueryBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDataQueryBase.getUserCat());
        }
        if (pSDEDataQueryBase.isUserTagDirty() && (bl || pSDEDataQueryBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDataQueryBase.getUserTag());
        }
        if (pSDEDataQueryBase.isUserTag2Dirty() && (bl || pSDEDataQueryBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDataQueryBase.getUserTag2());
        }
        if (pSDEDataQueryBase.isUserTag3Dirty() && (bl || pSDEDataQueryBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDataQueryBase.getUserTag3());
        }
        if (pSDEDataQueryBase.isUserTag4Dirty() && (bl || pSDEDataQueryBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDataQueryBase.getUserTag4());
        }
        if (pSDEDataQueryBase.isValidFlagDirty() && (bl || pSDEDataQueryBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDataQueryBase.getValidFlag());
        }
        if (pSDEDataQueryBase.isViewColLevelDirty() && (bl || pSDEDataQueryBase.getViewColLevel() != null)) {
            iDataObject.set(FIELD_VIEWCOLLEVEL, (Object)pSDEDataQueryBase.getViewColLevel());
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
        return PSDEDataQueryBase.remove(this, n);
    }

    private static boolean remove(PSDEDataQueryBase pSDEDataQueryBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataQueryBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEDataQueryBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEDataQueryBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEDataQueryBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEDataQueryBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSDEDataQueryBase.resetDefaultMode();
                return true;
            }
            case 6: {
                pSDEDataQueryBase.resetDQJoinModel();
                return true;
            }
            case 7: {
                pSDEDataQueryBase.resetDQOption();
                return true;
            }
            case 8: {
                pSDEDataQueryBase.resetDQSN();
                return true;
            }
            case 9: {
                pSDEDataQueryBase.resetDQTag();
                return true;
            }
            case 10: {
                pSDEDataQueryBase.resetDQTag2();
                return true;
            }
            case 11: {
                pSDEDataQueryBase.resetDQTag3();
                return true;
            }
            case 12: {
                pSDEDataQueryBase.resetDQTag4();
                return true;
            }
            case 13: {
                pSDEDataQueryBase.resetDynaModelFlag();
                return true;
            }
            case 14: {
                pSDEDataQueryBase.resetEnablePQL();
                return true;
            }
            case 15: {
                pSDEDataQueryBase.resetExtendMode();
                return true;
            }
            case 16: {
                pSDEDataQueryBase.resetFilterModel();
                return true;
            }
            case 17: {
                pSDEDataQueryBase.resetLockFlag();
                return true;
            }
            case 18: {
                pSDEDataQueryBase.resetLogicName();
                return true;
            }
            case 19: {
                pSDEDataQueryBase.resetMemo();
                return true;
            }
            case 20: {
                pSDEDataQueryBase.resetOrderValue();
                return true;
            }
            case 21: {
                pSDEDataQueryBase.resetPrivMode();
                return true;
            }
            case 22: {
                pSDEDataQueryBase.resetPSDEDataQueryId();
                return true;
            }
            case 23: {
                pSDEDataQueryBase.resetPSDEDataQueryName();
                return true;
            }
            case 24: {
                pSDEDataQueryBase.resetPSDEFGroupId();
                return true;
            }
            case 25: {
                pSDEDataQueryBase.resetPSDEFGroupName();
                return true;
            }
            case 26: {
                pSDEDataQueryBase.resetPSDEId();
                return true;
            }
            case 27: {
                pSDEDataQueryBase.resetPSDEMainStateId();
                return true;
            }
            case 28: {
                pSDEDataQueryBase.resetPSDEMainStateName();
                return true;
            }
            case 29: {
                pSDEDataQueryBase.resetPSDEName();
                return true;
            }
            case 30: {
                pSDEDataQueryBase.resetPSDynaInstId();
                return true;
            }
            case 31: {
                pSDEDataQueryBase.resetPubMode();
                return true;
            }
            case 32: {
                pSDEDataQueryBase.resetQueryViewFlag();
                return true;
            }
            case 33: {
                pSDEDataQueryBase.resetRequestMethod();
                return true;
            }
            case 34: {
                pSDEDataQueryBase.resetRequestPath();
                return true;
            }
            case 35: {
                pSDEDataQueryBase.resetServiceCodeName();
                return true;
            }
            case 36: {
                pSDEDataQueryBase.resetSubSysSADetailMode();
                return true;
            }
            case 37: {
                pSDEDataQueryBase.resetToDoTask();
                return true;
            }
            case 38: {
                pSDEDataQueryBase.resetUpdateDate();
                return true;
            }
            case 39: {
                pSDEDataQueryBase.resetUpdateMan();
                return true;
            }
            case 40: {
                pSDEDataQueryBase.resetUserCat();
                return true;
            }
            case 41: {
                pSDEDataQueryBase.resetUserTag();
                return true;
            }
            case 42: {
                pSDEDataQueryBase.resetUserTag2();
                return true;
            }
            case 43: {
                pSDEDataQueryBase.resetUserTag3();
                return true;
            }
            case 44: {
                pSDEDataQueryBase.resetUserTag4();
                return true;
            }
            case 45: {
                pSDEDataQueryBase.resetValidFlag();
                return true;
            }
            case 46: {
                pSDEDataQueryBase.resetViewColLevel();
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroup();
        }
        if (this.getPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEFGroupLock;
        synchronized (n) {
            if (this.psdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFGroupId(), (Object)this.psdefgroup.getPSDEFGroupId()) != 0L) {
                this.psdefgroup = null;
            }
            if (this.psdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet(pSDEFGroup);
                this.psdefgroup = pSDEFGroup;
            }
            return this.psdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPSDEMainState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainState();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        Integer n = this.objPSDEMainStateLock;
        synchronized (n) {
            if (this.psdemainstate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMainStateId(), (Object)this.psdemainstate.getPSDEMainStateId()) != 0L) {
                this.psdemainstate = null;
            }
            if (this.psdemainstate == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMainStateId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet(pSDEMainState);
                this.psdemainstate = pSDEMainState;
            }
            return this.psdemainstate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDQCond> getPSDEDQConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQConds();
        }
        if (this.getPSDEDataQueryId() == null) {
            return null;
        }
        PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDQCondsLock;
        synchronized (n) {
            if (this.psdedqconds == null) {
                this.psdedqconds = pSDEDataQueryService.isTempData(this) ? pSDEDQCondService.selectTempByPSDEDQ(this) : pSDEDQCondService.selectByPSDEDQ(this);
            }
            return this.psdedqconds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDSDQ> getPSDEDSDQs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSDQs();
        }
        if (this.getPSDEDataQueryId() == null) {
            return null;
        }
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDSDQsLock;
        synchronized (n) {
            if (this.psdedsdqs == null) {
                this.psdedsdqs = pSDEDSDQService.selectByPSDEDQ(this);
            }
            return this.psdedsdqs;
        }
    }

    private PSDEDataQueryBase getProxyEntity() {
        return this.proxyPSDEDataQueryBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataQueryBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataQueryBase) {
            this.proxyPSDEDataQueryBase = (PSDEDataQueryBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 5);
        fieldIndexMap.put(FIELD_DQJOINMODEL, 6);
        fieldIndexMap.put(FIELD_DQOPTION, 7);
        fieldIndexMap.put(FIELD_DQSN, 8);
        fieldIndexMap.put(FIELD_DQTAG, 9);
        fieldIndexMap.put(FIELD_DQTAG2, 10);
        fieldIndexMap.put(FIELD_DQTAG3, 11);
        fieldIndexMap.put(FIELD_DQTAG4, 12);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 13);
        fieldIndexMap.put(FIELD_ENABLEPQL, 14);
        fieldIndexMap.put(FIELD_EXTENDMODE, 15);
        fieldIndexMap.put(FIELD_FILTERMODEL, 16);
        fieldIndexMap.put(FIELD_LOCKFLAG, 17);
        fieldIndexMap.put(FIELD_LOGICNAME, 18);
        fieldIndexMap.put(FIELD_MEMO, 19);
        fieldIndexMap.put(FIELD_ORDERVALUE, 20);
        fieldIndexMap.put(FIELD_PRIVMODE, 21);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYID, 22);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYNAME, 23);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 24);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 25);
        fieldIndexMap.put(FIELD_PSDEID, 26);
        fieldIndexMap.put(FIELD_PSDEMAINSTATEID, 27);
        fieldIndexMap.put(FIELD_PSDEMAINSTATENAME, 28);
        fieldIndexMap.put(FIELD_PSDENAME, 29);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 30);
        fieldIndexMap.put(FIELD_PUBMODE, 31);
        fieldIndexMap.put(FIELD_QUERYVIEWFLAG, 32);
        fieldIndexMap.put(FIELD_REQUESTMETHOD, 33);
        fieldIndexMap.put(FIELD_REQUESTPATH, 34);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 35);
        fieldIndexMap.put(FIELD_SUBSYSSADETAILMODE, 36);
        fieldIndexMap.put(FIELD_TODOTASK, 37);
        fieldIndexMap.put(FIELD_UPDATEDATE, 38);
        fieldIndexMap.put(FIELD_UPDATEMAN, 39);
        fieldIndexMap.put(FIELD_USERCAT, 40);
        fieldIndexMap.put(FIELD_USERTAG, 41);
        fieldIndexMap.put(FIELD_USERTAG2, 42);
        fieldIndexMap.put(FIELD_USERTAG3, 43);
        fieldIndexMap.put(FIELD_USERTAG4, 44);
        fieldIndexMap.put(FIELD_VALIDFLAG, 45);
        fieldIndexMap.put(FIELD_VIEWCOLLEVEL, 46);
    }
}

