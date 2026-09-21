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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDynaModelAttrBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDynaModelAttrBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_ATTRTAG = "ATTRTAG";
    public static final String FIELD_ATTRTAG2 = "ATTRTAG2";
    public static final String FIELD_ATTRVALUE = "ATTRVALUE";
    public static final String FIELD_ATTRVALUE10 = "ATTRVALUE10";
    public static final String FIELD_ATTRVALUE11 = "ATTRVALUE11";
    public static final String FIELD_ATTRVALUE12 = "ATTRVALUE12";
    public static final String FIELD_ATTRVALUE13 = "ATTRVALUE13";
    public static final String FIELD_ATTRVALUE14 = "ATTRVALUE14";
    public static final String FIELD_ATTRVALUE15 = "ATTRVALUE15";
    public static final String FIELD_ATTRVALUE16 = "ATTRVALUE16";
    public static final String FIELD_ATTRVALUE2 = "ATTRVALUE2";
    public static final String FIELD_ATTRVALUE20 = "ATTRVALUE20";
    public static final String FIELD_ATTRVALUE21 = "ATTRVALUE21";
    public static final String FIELD_ATTRVALUE22 = "ATTRVALUE22";
    public static final String FIELD_ATTRVALUE23 = "ATTRVALUE23";
    public static final String FIELD_ATTRVALUE24 = "ATTRVALUE24";
    public static final String FIELD_ATTRVALUE25 = "ATTRVALUE25";
    public static final String FIELD_ATTRVALUE26 = "ATTRVALUE26";
    public static final String FIELD_ATTRVALUE27 = "ATTRVALUE27";
    public static final String FIELD_ATTRVALUE28 = "ATTRVALUE28";
    public static final String FIELD_ATTRVALUE29 = "ATTRVALUE29";
    public static final String FIELD_ATTRVALUE3 = "ATTRVALUE3";
    public static final String FIELD_ATTRVALUE30 = "ATTRVALUE30";
    public static final String FIELD_ATTRVALUE4 = "ATTRVALUE4";
    public static final String FIELD_ATTRVALUE5 = "ATTRVALUE5";
    public static final String FIELD_ATTRVALUE6 = "ATTRVALUE6";
    public static final String FIELD_ATTRVALUE7 = "ATTRVALUE7";
    public static final String FIELD_ATTRVALUE8 = "ATTRVALUE8";
    public static final String FIELD_ATTRVALUE9 = "ATTRVALUE9";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELUSAGE = "DYNAMODELUSAGE";
    public static final String FIELD_JSONFORMAT = "JSONFORMAT";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSSYSDYNAMODELATTRID = "PSSYSDYNAMODELATTRID";
    public static final String FIELD_PSSYSDYNAMODELATTRNAME = "PSSYSDYNAMODELATTRNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_REFPSDEFGROUPID = "REFPSDEFGROUPID";
    public static final String FIELD_REFPSDEFGROUPNAME = "REFPSDEFGROUPNAME";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_REFPSSYSDYNAMODELID = "REFPSSYSDYNAMODELID";
    public static final String FIELD_REFPSSYSDYNAMODELNAME = "REFPSSYSDYNAMODELNAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUETYPE = "VALUETYPE";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_ARRAYFLAG = 1;
    private static final int INDEX_ATTRTAG = 2;
    private static final int INDEX_ATTRTAG2 = 3;
    private static final int INDEX_ATTRVALUE = 4;
    private static final int INDEX_ATTRVALUE10 = 5;
    private static final int INDEX_ATTRVALUE11 = 6;
    private static final int INDEX_ATTRVALUE12 = 7;
    private static final int INDEX_ATTRVALUE13 = 8;
    private static final int INDEX_ATTRVALUE14 = 9;
    private static final int INDEX_ATTRVALUE15 = 10;
    private static final int INDEX_ATTRVALUE16 = 11;
    private static final int INDEX_ATTRVALUE2 = 12;
    private static final int INDEX_ATTRVALUE20 = 13;
    private static final int INDEX_ATTRVALUE21 = 14;
    private static final int INDEX_ATTRVALUE22 = 15;
    private static final int INDEX_ATTRVALUE23 = 16;
    private static final int INDEX_ATTRVALUE24 = 17;
    private static final int INDEX_ATTRVALUE25 = 18;
    private static final int INDEX_ATTRVALUE26 = 19;
    private static final int INDEX_ATTRVALUE27 = 20;
    private static final int INDEX_ATTRVALUE28 = 21;
    private static final int INDEX_ATTRVALUE29 = 22;
    private static final int INDEX_ATTRVALUE3 = 23;
    private static final int INDEX_ATTRVALUE30 = 24;
    private static final int INDEX_ATTRVALUE4 = 25;
    private static final int INDEX_ATTRVALUE5 = 26;
    private static final int INDEX_ATTRVALUE6 = 27;
    private static final int INDEX_ATTRVALUE7 = 28;
    private static final int INDEX_ATTRVALUE8 = 29;
    private static final int INDEX_ATTRVALUE9 = 30;
    private static final int INDEX_CODENAME = 31;
    private static final int INDEX_CREATEDATE = 32;
    private static final int INDEX_CREATEMAN = 33;
    private static final int INDEX_DYNAMODELUSAGE = 34;
    private static final int INDEX_JSONFORMAT = 35;
    private static final int INDEX_LOGICNAME = 36;
    private static final int INDEX_MEMO = 37;
    private static final int INDEX_ORDERVALUE = 38;
    private static final int INDEX_PSCODELISTID = 39;
    private static final int INDEX_PSCODELISTNAME = 40;
    private static final int INDEX_PSSYSDYNAMODELATTRID = 41;
    private static final int INDEX_PSSYSDYNAMODELATTRNAME = 42;
    private static final int INDEX_PSSYSDYNAMODELID = 43;
    private static final int INDEX_PSSYSDYNAMODELNAME = 44;
    private static final int INDEX_PSSYSVALUERULEID = 45;
    private static final int INDEX_PSSYSVALUERULENAME = 46;
    private static final int INDEX_REFPSDEFGROUPID = 47;
    private static final int INDEX_REFPSDEFGROUPNAME = 48;
    private static final int INDEX_REFPSDEID = 49;
    private static final int INDEX_REFPSDENAME = 50;
    private static final int INDEX_REFPSSYSDYNAMODELID = 51;
    private static final int INDEX_REFPSSYSDYNAMODELNAME = 52;
    private static final int INDEX_STDDATATYPE = 53;
    private static final int INDEX_UPDATEDATE = 54;
    private static final int INDEX_UPDATEMAN = 55;
    private static final int INDEX_VALIDFLAG = 56;
    private static final int INDEX_VALUETYPE = 57;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDynaModelAttrBase proxyPSSysDynaModelAttrBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean arrayflagDirtyFlag = false;
    private boolean attrtagDirtyFlag = false;
    private boolean attrtag2DirtyFlag = false;
    private boolean attrvalueDirtyFlag = false;
    private boolean attrvalue10DirtyFlag = false;
    private boolean attrvalue11DirtyFlag = false;
    private boolean attrvalue12DirtyFlag = false;
    private boolean attrvalue13DirtyFlag = false;
    private boolean attrvalue14DirtyFlag = false;
    private boolean attrvalue15DirtyFlag = false;
    private boolean attrvalue16DirtyFlag = false;
    private boolean attrvalue2DirtyFlag = false;
    private boolean attrvalue20DirtyFlag = false;
    private boolean attrvalue21DirtyFlag = false;
    private boolean attrvalue22DirtyFlag = false;
    private boolean attrvalue23DirtyFlag = false;
    private boolean attrvalue24DirtyFlag = false;
    private boolean attrvalue25DirtyFlag = false;
    private boolean attrvalue26DirtyFlag = false;
    private boolean attrvalue27DirtyFlag = false;
    private boolean attrvalue28DirtyFlag = false;
    private boolean attrvalue29DirtyFlag = false;
    private boolean attrvalue3DirtyFlag = false;
    private boolean attrvalue30DirtyFlag = false;
    private boolean attrvalue4DirtyFlag = false;
    private boolean attrvalue5DirtyFlag = false;
    private boolean attrvalue6DirtyFlag = false;
    private boolean attrvalue7DirtyFlag = false;
    private boolean attrvalue8DirtyFlag = false;
    private boolean attrvalue9DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelusageDirtyFlag = false;
    private boolean jsonformatDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean pssysdynamodelattridDirtyFlag = false;
    private boolean pssysdynamodelattrnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean refpsdefgroupidDirtyFlag = false;
    private boolean refpsdefgroupnameDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean refpssysdynamodelidDirtyFlag = false;
    private boolean refpssysdynamodelnameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valuetypeDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="arrayflag")
    private Integer arrayflag;
    @Column(name="attrtag")
    private String attrtag;
    @Column(name="attrtag2")
    private String attrtag2;
    @Column(name="attrvalue")
    private String attrvalue;
    @Column(name="attrvalue10")
    private Double attrvalue10;
    @Column(name="attrvalue11")
    private Double attrvalue11;
    @Column(name="attrvalue12")
    private Double attrvalue12;
    @Column(name="attrvalue13")
    private Timestamp attrvalue13;
    @Column(name="attrvalue14")
    private Timestamp attrvalue14;
    @Column(name="attrvalue15")
    private Timestamp attrvalue15;
    @Column(name="attrvalue16")
    private Timestamp attrvalue16;
    @Column(name="attrvalue2")
    private String attrvalue2;
    @Column(name="attrvalue20")
    private String attrvalue20;
    @Column(name="attrvalue21")
    private String attrvalue21;
    @Column(name="attrvalue22")
    private String attrvalue22;
    @Column(name="attrvalue23")
    private String attrvalue23;
    @Column(name="attrvalue24")
    private String attrvalue24;
    @Column(name="attrvalue25")
    private String attrvalue25;
    @Column(name="attrvalue26")
    private String attrvalue26;
    @Column(name="attrvalue27")
    private String attrvalue27;
    @Column(name="attrvalue28")
    private String attrvalue28;
    @Column(name="attrvalue29")
    private String attrvalue29;
    @Column(name="attrvalue3")
    private String attrvalue3;
    @Column(name="attrvalue30")
    private String attrvalue30;
    @Column(name="attrvalue4")
    private String attrvalue4;
    @Column(name="attrvalue5")
    private Integer attrvalue5;
    @Column(name="attrvalue6")
    private Integer attrvalue6;
    @Column(name="attrvalue7")
    private Integer attrvalue7;
    @Column(name="attrvalue8")
    private Integer attrvalue8;
    @Column(name="attrvalue9")
    private Double attrvalue9;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelusage")
    private String dynamodelusage;
    @Column(name="jsonformat")
    private String jsonformat;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="pssysdynamodelattrid")
    private String pssysdynamodelattrid;
    @Column(name="pssysdynamodelattrname")
    private String pssysdynamodelattrname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
    @Column(name="refpsdefgroupid")
    private String refpsdefgroupid;
    @Column(name="refpsdefgroupname")
    private String refpsdefgroupname;
    @Column(name="refpsdeid")
    private String refpsdeid;
    @Column(name="refpsdename")
    private String refpsdename;
    @Column(name="refpssysdynamodelid")
    private String refpssysdynamodelid;
    @Column(name="refpssysdynamodelname")
    private String refpssysdynamodelname;
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="valuetype")
    private String valuetype;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objRefPSDEFGroupLock = new Integer(1);
    private PSDEFGroup refpsdefgroup = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objRefPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel refpssysdynamodel = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;

    public void setAllowEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowEmpty(n);
            return;
        }
        this.allowempty = n;
        this.allowemptyDirtyFlag = true;
    }

    public Integer getAllowEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowEmpty();
        }
        return this.allowempty;
    }

    public boolean isAllowEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowEmptyDirty();
        }
        return this.allowemptyDirtyFlag;
    }

    public void resetAllowEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowEmpty();
            return;
        }
        this.allowemptyDirtyFlag = false;
        this.allowempty = null;
    }

    public void setArrayFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArrayFlag(n);
            return;
        }
        this.arrayflag = n;
        this.arrayflagDirtyFlag = true;
    }

    public Integer getArrayFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArrayFlag();
        }
        return this.arrayflag;
    }

    public boolean isArrayFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArrayFlagDirty();
        }
        return this.arrayflagDirtyFlag;
    }

    public void resetArrayFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArrayFlag();
            return;
        }
        this.arrayflagDirtyFlag = false;
        this.arrayflag = null;
    }

    public void setAttrTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrtag = string;
        this.attrtagDirtyFlag = true;
    }

    public String getAttrTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrTag();
        }
        return this.attrtag;
    }

    public boolean isAttrTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrTagDirty();
        }
        return this.attrtagDirtyFlag;
    }

    public void resetAttrTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrTag();
            return;
        }
        this.attrtagDirtyFlag = false;
        this.attrtag = null;
    }

    public void setAttrTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrtag2 = string;
        this.attrtag2DirtyFlag = true;
    }

    public String getAttrTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrTag2();
        }
        return this.attrtag2;
    }

    public boolean isAttrTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrTag2Dirty();
        }
        return this.attrtag2DirtyFlag;
    }

    public void resetAttrTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrTag2();
            return;
        }
        this.attrtag2DirtyFlag = false;
        this.attrtag2 = null;
    }

    public void setAttrValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue = string;
        this.attrvalueDirtyFlag = true;
    }

    public String getAttrValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue();
        }
        return this.attrvalue;
    }

    public boolean isAttrValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValueDirty();
        }
        return this.attrvalueDirtyFlag;
    }

    public void resetAttrValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue();
            return;
        }
        this.attrvalueDirtyFlag = false;
        this.attrvalue = null;
    }

    public void setAttrValue10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue10(d);
            return;
        }
        this.attrvalue10 = d;
        this.attrvalue10DirtyFlag = true;
    }

    public Double getAttrValue10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue10();
        }
        return this.attrvalue10;
    }

    public boolean isAttrValue10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue10Dirty();
        }
        return this.attrvalue10DirtyFlag;
    }

    public void resetAttrValue10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue10();
            return;
        }
        this.attrvalue10DirtyFlag = false;
        this.attrvalue10 = null;
    }

    public void setAttrValue11(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue11(d);
            return;
        }
        this.attrvalue11 = d;
        this.attrvalue11DirtyFlag = true;
    }

    public Double getAttrValue11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue11();
        }
        return this.attrvalue11;
    }

    public boolean isAttrValue11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue11Dirty();
        }
        return this.attrvalue11DirtyFlag;
    }

    public void resetAttrValue11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue11();
            return;
        }
        this.attrvalue11DirtyFlag = false;
        this.attrvalue11 = null;
    }

    public void setAttrValue12(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue12(d);
            return;
        }
        this.attrvalue12 = d;
        this.attrvalue12DirtyFlag = true;
    }

    public Double getAttrValue12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue12();
        }
        return this.attrvalue12;
    }

    public boolean isAttrValue12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue12Dirty();
        }
        return this.attrvalue12DirtyFlag;
    }

    public void resetAttrValue12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue12();
            return;
        }
        this.attrvalue12DirtyFlag = false;
        this.attrvalue12 = null;
    }

    public void setAttrValue13(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue13(timestamp);
            return;
        }
        this.attrvalue13 = timestamp;
        this.attrvalue13DirtyFlag = true;
    }

    public Timestamp getAttrValue13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue13();
        }
        return this.attrvalue13;
    }

    public boolean isAttrValue13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue13Dirty();
        }
        return this.attrvalue13DirtyFlag;
    }

    public void resetAttrValue13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue13();
            return;
        }
        this.attrvalue13DirtyFlag = false;
        this.attrvalue13 = null;
    }

    public void setAttrValue14(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue14(timestamp);
            return;
        }
        this.attrvalue14 = timestamp;
        this.attrvalue14DirtyFlag = true;
    }

    public Timestamp getAttrValue14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue14();
        }
        return this.attrvalue14;
    }

    public boolean isAttrValue14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue14Dirty();
        }
        return this.attrvalue14DirtyFlag;
    }

    public void resetAttrValue14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue14();
            return;
        }
        this.attrvalue14DirtyFlag = false;
        this.attrvalue14 = null;
    }

    public void setAttrValue15(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue15(timestamp);
            return;
        }
        this.attrvalue15 = timestamp;
        this.attrvalue15DirtyFlag = true;
    }

    public Timestamp getAttrValue15() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue15();
        }
        return this.attrvalue15;
    }

    public boolean isAttrValue15Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue15Dirty();
        }
        return this.attrvalue15DirtyFlag;
    }

    public void resetAttrValue15() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue15();
            return;
        }
        this.attrvalue15DirtyFlag = false;
        this.attrvalue15 = null;
    }

    public void setAttrValue16(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue16(timestamp);
            return;
        }
        this.attrvalue16 = timestamp;
        this.attrvalue16DirtyFlag = true;
    }

    public Timestamp getAttrValue16() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue16();
        }
        return this.attrvalue16;
    }

    public boolean isAttrValue16Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue16Dirty();
        }
        return this.attrvalue16DirtyFlag;
    }

    public void resetAttrValue16() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue16();
            return;
        }
        this.attrvalue16DirtyFlag = false;
        this.attrvalue16 = null;
    }

    public void setAttrValue2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue2 = string;
        this.attrvalue2DirtyFlag = true;
    }

    public String getAttrValue2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue2();
        }
        return this.attrvalue2;
    }

    public boolean isAttrValue2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue2Dirty();
        }
        return this.attrvalue2DirtyFlag;
    }

    public void resetAttrValue2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue2();
            return;
        }
        this.attrvalue2DirtyFlag = false;
        this.attrvalue2 = null;
    }

    public void setAttrValue20(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue20(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue20 = string;
        this.attrvalue20DirtyFlag = true;
    }

    public String getAttrValue20() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue20();
        }
        return this.attrvalue20;
    }

    public boolean isAttrValue20Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue20Dirty();
        }
        return this.attrvalue20DirtyFlag;
    }

    public void resetAttrValue20() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue20();
            return;
        }
        this.attrvalue20DirtyFlag = false;
        this.attrvalue20 = null;
    }

    public void setAttrValue21(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue21(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue21 = string;
        this.attrvalue21DirtyFlag = true;
    }

    public String getAttrValue21() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue21();
        }
        return this.attrvalue21;
    }

    public boolean isAttrValue21Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue21Dirty();
        }
        return this.attrvalue21DirtyFlag;
    }

    public void resetAttrValue21() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue21();
            return;
        }
        this.attrvalue21DirtyFlag = false;
        this.attrvalue21 = null;
    }

    public void setAttrValue22(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue22(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue22 = string;
        this.attrvalue22DirtyFlag = true;
    }

    public String getAttrValue22() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue22();
        }
        return this.attrvalue22;
    }

    public boolean isAttrValue22Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue22Dirty();
        }
        return this.attrvalue22DirtyFlag;
    }

    public void resetAttrValue22() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue22();
            return;
        }
        this.attrvalue22DirtyFlag = false;
        this.attrvalue22 = null;
    }

    public void setAttrValue23(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue23(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue23 = string;
        this.attrvalue23DirtyFlag = true;
    }

    public String getAttrValue23() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue23();
        }
        return this.attrvalue23;
    }

    public boolean isAttrValue23Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue23Dirty();
        }
        return this.attrvalue23DirtyFlag;
    }

    public void resetAttrValue23() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue23();
            return;
        }
        this.attrvalue23DirtyFlag = false;
        this.attrvalue23 = null;
    }

    public void setAttrValue24(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue24(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue24 = string;
        this.attrvalue24DirtyFlag = true;
    }

    public String getAttrValue24() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue24();
        }
        return this.attrvalue24;
    }

    public boolean isAttrValue24Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue24Dirty();
        }
        return this.attrvalue24DirtyFlag;
    }

    public void resetAttrValue24() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue24();
            return;
        }
        this.attrvalue24DirtyFlag = false;
        this.attrvalue24 = null;
    }

    public void setAttrValue25(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue25(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue25 = string;
        this.attrvalue25DirtyFlag = true;
    }

    public String getAttrValue25() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue25();
        }
        return this.attrvalue25;
    }

    public boolean isAttrValue25Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue25Dirty();
        }
        return this.attrvalue25DirtyFlag;
    }

    public void resetAttrValue25() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue25();
            return;
        }
        this.attrvalue25DirtyFlag = false;
        this.attrvalue25 = null;
    }

    public void setAttrValue26(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue26(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue26 = string;
        this.attrvalue26DirtyFlag = true;
    }

    public String getAttrValue26() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue26();
        }
        return this.attrvalue26;
    }

    public boolean isAttrValue26Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue26Dirty();
        }
        return this.attrvalue26DirtyFlag;
    }

    public void resetAttrValue26() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue26();
            return;
        }
        this.attrvalue26DirtyFlag = false;
        this.attrvalue26 = null;
    }

    public void setAttrValue27(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue27(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue27 = string;
        this.attrvalue27DirtyFlag = true;
    }

    public String getAttrValue27() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue27();
        }
        return this.attrvalue27;
    }

    public boolean isAttrValue27Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue27Dirty();
        }
        return this.attrvalue27DirtyFlag;
    }

    public void resetAttrValue27() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue27();
            return;
        }
        this.attrvalue27DirtyFlag = false;
        this.attrvalue27 = null;
    }

    public void setAttrValue28(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue28(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue28 = string;
        this.attrvalue28DirtyFlag = true;
    }

    public String getAttrValue28() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue28();
        }
        return this.attrvalue28;
    }

    public boolean isAttrValue28Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue28Dirty();
        }
        return this.attrvalue28DirtyFlag;
    }

    public void resetAttrValue28() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue28();
            return;
        }
        this.attrvalue28DirtyFlag = false;
        this.attrvalue28 = null;
    }

    public void setAttrValue29(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue29(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue29 = string;
        this.attrvalue29DirtyFlag = true;
    }

    public String getAttrValue29() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue29();
        }
        return this.attrvalue29;
    }

    public boolean isAttrValue29Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue29Dirty();
        }
        return this.attrvalue29DirtyFlag;
    }

    public void resetAttrValue29() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue29();
            return;
        }
        this.attrvalue29DirtyFlag = false;
        this.attrvalue29 = null;
    }

    public void setAttrValue3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue3 = string;
        this.attrvalue3DirtyFlag = true;
    }

    public String getAttrValue3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue3();
        }
        return this.attrvalue3;
    }

    public boolean isAttrValue3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue3Dirty();
        }
        return this.attrvalue3DirtyFlag;
    }

    public void resetAttrValue3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue3();
            return;
        }
        this.attrvalue3DirtyFlag = false;
        this.attrvalue3 = null;
    }

    public void setAttrValue30(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue30(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue30 = string;
        this.attrvalue30DirtyFlag = true;
    }

    public String getAttrValue30() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue30();
        }
        return this.attrvalue30;
    }

    public boolean isAttrValue30Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue30Dirty();
        }
        return this.attrvalue30DirtyFlag;
    }

    public void resetAttrValue30() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue30();
            return;
        }
        this.attrvalue30DirtyFlag = false;
        this.attrvalue30 = null;
    }

    public void setAttrValue4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrvalue4 = string;
        this.attrvalue4DirtyFlag = true;
    }

    public String getAttrValue4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue4();
        }
        return this.attrvalue4;
    }

    public boolean isAttrValue4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue4Dirty();
        }
        return this.attrvalue4DirtyFlag;
    }

    public void resetAttrValue4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue4();
            return;
        }
        this.attrvalue4DirtyFlag = false;
        this.attrvalue4 = null;
    }

    public void setAttrValue5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue5(n);
            return;
        }
        this.attrvalue5 = n;
        this.attrvalue5DirtyFlag = true;
    }

    public Integer getAttrValue5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue5();
        }
        return this.attrvalue5;
    }

    public boolean isAttrValue5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue5Dirty();
        }
        return this.attrvalue5DirtyFlag;
    }

    public void resetAttrValue5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue5();
            return;
        }
        this.attrvalue5DirtyFlag = false;
        this.attrvalue5 = null;
    }

    public void setAttrValue6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue6(n);
            return;
        }
        this.attrvalue6 = n;
        this.attrvalue6DirtyFlag = true;
    }

    public Integer getAttrValue6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue6();
        }
        return this.attrvalue6;
    }

    public boolean isAttrValue6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue6Dirty();
        }
        return this.attrvalue6DirtyFlag;
    }

    public void resetAttrValue6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue6();
            return;
        }
        this.attrvalue6DirtyFlag = false;
        this.attrvalue6 = null;
    }

    public void setAttrValue7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue7(n);
            return;
        }
        this.attrvalue7 = n;
        this.attrvalue7DirtyFlag = true;
    }

    public Integer getAttrValue7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue7();
        }
        return this.attrvalue7;
    }

    public boolean isAttrValue7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue7Dirty();
        }
        return this.attrvalue7DirtyFlag;
    }

    public void resetAttrValue7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue7();
            return;
        }
        this.attrvalue7DirtyFlag = false;
        this.attrvalue7 = null;
    }

    public void setAttrValue8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue8(n);
            return;
        }
        this.attrvalue8 = n;
        this.attrvalue8DirtyFlag = true;
    }

    public Integer getAttrValue8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue8();
        }
        return this.attrvalue8;
    }

    public boolean isAttrValue8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue8Dirty();
        }
        return this.attrvalue8DirtyFlag;
    }

    public void resetAttrValue8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue8();
            return;
        }
        this.attrvalue8DirtyFlag = false;
        this.attrvalue8 = null;
    }

    public void setAttrValue9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrValue9(d);
            return;
        }
        this.attrvalue9 = d;
        this.attrvalue9DirtyFlag = true;
    }

    public Double getAttrValue9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrValue9();
        }
        return this.attrvalue9;
    }

    public boolean isAttrValue9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrValue9Dirty();
        }
        return this.attrvalue9DirtyFlag;
    }

    public void resetAttrValue9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrValue9();
            return;
        }
        this.attrvalue9DirtyFlag = false;
        this.attrvalue9 = null;
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

    public void setDynaModelUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodelusage = string;
        this.dynamodelusageDirtyFlag = true;
    }

    public String getDynaModelUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelUsage();
        }
        return this.dynamodelusage;
    }

    public boolean isDynaModelUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelUsageDirty();
        }
        return this.dynamodelusageDirtyFlag;
    }

    public void resetDynaModelUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelUsage();
            return;
        }
        this.dynamodelusageDirtyFlag = false;
        this.dynamodelusage = null;
    }

    public void setJsonFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJsonFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jsonformat = string;
        this.jsonformatDirtyFlag = true;
    }

    public String getJsonFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJsonFormat();
        }
        return this.jsonformat;
    }

    public boolean isJsonFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJsonFormatDirty();
        }
        return this.jsonformatDirtyFlag;
    }

    public void resetJsonFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJsonFormat();
            return;
        }
        this.jsonformatDirtyFlag = false;
        this.jsonformat = null;
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

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSSysDynaModelAttrId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelAttrId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelattrid = string;
        this.pssysdynamodelattridDirtyFlag = true;
    }

    public String getPSSysDynaModelAttrId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelAttrId();
        }
        return this.pssysdynamodelattrid;
    }

    public boolean isPSSysDynaModelAttrIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelAttrIdDirty();
        }
        return this.pssysdynamodelattridDirtyFlag;
    }

    public void resetPSSysDynaModelAttrId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelAttrId();
            return;
        }
        this.pssysdynamodelattridDirtyFlag = false;
        this.pssysdynamodelattrid = null;
    }

    public void setPSSysDynaModelAttrName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelAttrName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelattrname = string;
        this.pssysdynamodelattrnameDirtyFlag = true;
    }

    public String getPSSysDynaModelAttrName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelAttrName();
        }
        return this.pssysdynamodelattrname;
    }

    public boolean isPSSysDynaModelAttrNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelAttrNameDirty();
        }
        return this.pssysdynamodelattrnameDirtyFlag;
    }

    public void resetPSSysDynaModelAttrName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelAttrName();
            return;
        }
        this.pssysdynamodelattrnameDirtyFlag = false;
        this.pssysdynamodelattrname = null;
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

    public void setRefPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdefgroupid = string;
        this.refpsdefgroupidDirtyFlag = true;
    }

    public String getRefPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEFGroupId();
        }
        return this.refpsdefgroupid;
    }

    public boolean isRefPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEFGroupIdDirty();
        }
        return this.refpsdefgroupidDirtyFlag;
    }

    public void resetRefPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEFGroupId();
            return;
        }
        this.refpsdefgroupidDirtyFlag = false;
        this.refpsdefgroupid = null;
    }

    public void setRefPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdefgroupname = string;
        this.refpsdefgroupnameDirtyFlag = true;
    }

    public String getRefPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEFGroupName();
        }
        return this.refpsdefgroupname;
    }

    public boolean isRefPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEFGroupNameDirty();
        }
        return this.refpsdefgroupnameDirtyFlag;
    }

    public void resetRefPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEFGroupName();
            return;
        }
        this.refpsdefgroupnameDirtyFlag = false;
        this.refpsdefgroupname = null;
    }

    public void setRefPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeid = string;
        this.refpsdeidDirtyFlag = true;
    }

    public String getRefPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEId();
        }
        return this.refpsdeid;
    }

    public boolean isRefPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEIdDirty();
        }
        return this.refpsdeidDirtyFlag;
    }

    public void resetRefPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEId();
            return;
        }
        this.refpsdeidDirtyFlag = false;
        this.refpsdeid = null;
    }

    public void setRefPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdename = string;
        this.refpsdenameDirtyFlag = true;
    }

    public String getRefPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEName();
        }
        return this.refpsdename;
    }

    public boolean isRefPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDENameDirty();
        }
        return this.refpsdenameDirtyFlag;
    }

    public void resetRefPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEName();
            return;
        }
        this.refpsdenameDirtyFlag = false;
        this.refpsdename = null;
    }

    public void setRefPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdynamodelid = string;
        this.refpssysdynamodelidDirtyFlag = true;
    }

    public String getRefPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModelId();
        }
        return this.refpssysdynamodelid;
    }

    public boolean isRefPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDynaModelIdDirty();
        }
        return this.refpssysdynamodelidDirtyFlag;
    }

    public void resetRefPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDynaModelId();
            return;
        }
        this.refpssysdynamodelidDirtyFlag = false;
        this.refpssysdynamodelid = null;
    }

    public void setRefPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdynamodelname = string;
        this.refpssysdynamodelnameDirtyFlag = true;
    }

    public String getRefPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModelName();
        }
        return this.refpssysdynamodelname;
    }

    public boolean isRefPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDynaModelNameDirty();
        }
        return this.refpssysdynamodelnameDirtyFlag;
    }

    public void resetRefPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDynaModelName();
            return;
        }
        this.refpssysdynamodelnameDirtyFlag = false;
        this.refpssysdynamodelname = null;
    }

    public void setStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStdDataType(n);
            return;
        }
        this.stddatatype = n;
        this.stddatatypeDirtyFlag = true;
    }

    public Integer getStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStdDataType();
        }
        return this.stddatatype;
    }

    public boolean isStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStdDataTypeDirty();
        }
        return this.stddatatypeDirtyFlag;
    }

    public void resetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStdDataType();
            return;
        }
        this.stddatatypeDirtyFlag = false;
        this.stddatatype = null;
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

    public void setValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuetype = string;
        this.valuetypeDirtyFlag = true;
    }

    public String getValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueType();
        }
        return this.valuetype;
    }

    public boolean isValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueTypeDirty();
        }
        return this.valuetypeDirtyFlag;
    }

    public void resetValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueType();
            return;
        }
        this.valuetypeDirtyFlag = false;
        this.valuetype = null;
    }

    protected void onReset() {
        PSSysDynaModelAttrBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDynaModelAttrBase pSSysDynaModelAttrBase) {
        pSSysDynaModelAttrBase.resetAllowEmpty();
        pSSysDynaModelAttrBase.resetArrayFlag();
        pSSysDynaModelAttrBase.resetAttrTag();
        pSSysDynaModelAttrBase.resetAttrTag2();
        pSSysDynaModelAttrBase.resetAttrValue();
        pSSysDynaModelAttrBase.resetAttrValue10();
        pSSysDynaModelAttrBase.resetAttrValue11();
        pSSysDynaModelAttrBase.resetAttrValue12();
        pSSysDynaModelAttrBase.resetAttrValue13();
        pSSysDynaModelAttrBase.resetAttrValue14();
        pSSysDynaModelAttrBase.resetAttrValue15();
        pSSysDynaModelAttrBase.resetAttrValue16();
        pSSysDynaModelAttrBase.resetAttrValue2();
        pSSysDynaModelAttrBase.resetAttrValue20();
        pSSysDynaModelAttrBase.resetAttrValue21();
        pSSysDynaModelAttrBase.resetAttrValue22();
        pSSysDynaModelAttrBase.resetAttrValue23();
        pSSysDynaModelAttrBase.resetAttrValue24();
        pSSysDynaModelAttrBase.resetAttrValue25();
        pSSysDynaModelAttrBase.resetAttrValue26();
        pSSysDynaModelAttrBase.resetAttrValue27();
        pSSysDynaModelAttrBase.resetAttrValue28();
        pSSysDynaModelAttrBase.resetAttrValue29();
        pSSysDynaModelAttrBase.resetAttrValue3();
        pSSysDynaModelAttrBase.resetAttrValue30();
        pSSysDynaModelAttrBase.resetAttrValue4();
        pSSysDynaModelAttrBase.resetAttrValue5();
        pSSysDynaModelAttrBase.resetAttrValue6();
        pSSysDynaModelAttrBase.resetAttrValue7();
        pSSysDynaModelAttrBase.resetAttrValue8();
        pSSysDynaModelAttrBase.resetAttrValue9();
        pSSysDynaModelAttrBase.resetCodeName();
        pSSysDynaModelAttrBase.resetCreateDate();
        pSSysDynaModelAttrBase.resetCreateMan();
        pSSysDynaModelAttrBase.resetDynaModelUsage();
        pSSysDynaModelAttrBase.resetJsonFormat();
        pSSysDynaModelAttrBase.resetLogicName();
        pSSysDynaModelAttrBase.resetMemo();
        pSSysDynaModelAttrBase.resetOrderValue();
        pSSysDynaModelAttrBase.resetPSCodeListId();
        pSSysDynaModelAttrBase.resetPSCodeListName();
        pSSysDynaModelAttrBase.resetPSSysDynaModelAttrId();
        pSSysDynaModelAttrBase.resetPSSysDynaModelAttrName();
        pSSysDynaModelAttrBase.resetPSSysDynaModelId();
        pSSysDynaModelAttrBase.resetPSSysDynaModelName();
        pSSysDynaModelAttrBase.resetPSSysValueRuleId();
        pSSysDynaModelAttrBase.resetPSSysValueRuleName();
        pSSysDynaModelAttrBase.resetRefPSDEFGroupId();
        pSSysDynaModelAttrBase.resetRefPSDEFGroupName();
        pSSysDynaModelAttrBase.resetRefPSDEId();
        pSSysDynaModelAttrBase.resetRefPSDEName();
        pSSysDynaModelAttrBase.resetRefPSSysDynaModelId();
        pSSysDynaModelAttrBase.resetRefPSSysDynaModelName();
        pSSysDynaModelAttrBase.resetStdDataType();
        pSSysDynaModelAttrBase.resetUpdateDate();
        pSSysDynaModelAttrBase.resetUpdateMan();
        pSSysDynaModelAttrBase.resetValidFlag();
        pSSysDynaModelAttrBase.resetValueType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
        }
        if (!bl || this.isArrayFlagDirty()) {
            hashMap.put(FIELD_ARRAYFLAG, this.getArrayFlag());
        }
        if (!bl || this.isAttrTagDirty()) {
            hashMap.put(FIELD_ATTRTAG, this.getAttrTag());
        }
        if (!bl || this.isAttrTag2Dirty()) {
            hashMap.put(FIELD_ATTRTAG2, this.getAttrTag2());
        }
        if (!bl || this.isAttrValueDirty()) {
            hashMap.put(FIELD_ATTRVALUE, this.getAttrValue());
        }
        if (!bl || this.isAttrValue10Dirty()) {
            hashMap.put(FIELD_ATTRVALUE10, this.getAttrValue10());
        }
        if (!bl || this.isAttrValue11Dirty()) {
            hashMap.put(FIELD_ATTRVALUE11, this.getAttrValue11());
        }
        if (!bl || this.isAttrValue12Dirty()) {
            hashMap.put(FIELD_ATTRVALUE12, this.getAttrValue12());
        }
        if (!bl || this.isAttrValue13Dirty()) {
            hashMap.put(FIELD_ATTRVALUE13, this.getAttrValue13());
        }
        if (!bl || this.isAttrValue14Dirty()) {
            hashMap.put(FIELD_ATTRVALUE14, this.getAttrValue14());
        }
        if (!bl || this.isAttrValue15Dirty()) {
            hashMap.put(FIELD_ATTRVALUE15, this.getAttrValue15());
        }
        if (!bl || this.isAttrValue16Dirty()) {
            hashMap.put(FIELD_ATTRVALUE16, this.getAttrValue16());
        }
        if (!bl || this.isAttrValue2Dirty()) {
            hashMap.put(FIELD_ATTRVALUE2, this.getAttrValue2());
        }
        if (!bl || this.isAttrValue20Dirty()) {
            hashMap.put(FIELD_ATTRVALUE20, this.getAttrValue20());
        }
        if (!bl || this.isAttrValue21Dirty()) {
            hashMap.put(FIELD_ATTRVALUE21, this.getAttrValue21());
        }
        if (!bl || this.isAttrValue22Dirty()) {
            hashMap.put(FIELD_ATTRVALUE22, this.getAttrValue22());
        }
        if (!bl || this.isAttrValue23Dirty()) {
            hashMap.put(FIELD_ATTRVALUE23, this.getAttrValue23());
        }
        if (!bl || this.isAttrValue24Dirty()) {
            hashMap.put(FIELD_ATTRVALUE24, this.getAttrValue24());
        }
        if (!bl || this.isAttrValue25Dirty()) {
            hashMap.put(FIELD_ATTRVALUE25, this.getAttrValue25());
        }
        if (!bl || this.isAttrValue26Dirty()) {
            hashMap.put(FIELD_ATTRVALUE26, this.getAttrValue26());
        }
        if (!bl || this.isAttrValue27Dirty()) {
            hashMap.put(FIELD_ATTRVALUE27, this.getAttrValue27());
        }
        if (!bl || this.isAttrValue28Dirty()) {
            hashMap.put(FIELD_ATTRVALUE28, this.getAttrValue28());
        }
        if (!bl || this.isAttrValue29Dirty()) {
            hashMap.put(FIELD_ATTRVALUE29, this.getAttrValue29());
        }
        if (!bl || this.isAttrValue3Dirty()) {
            hashMap.put(FIELD_ATTRVALUE3, this.getAttrValue3());
        }
        if (!bl || this.isAttrValue30Dirty()) {
            hashMap.put(FIELD_ATTRVALUE30, this.getAttrValue30());
        }
        if (!bl || this.isAttrValue4Dirty()) {
            hashMap.put(FIELD_ATTRVALUE4, this.getAttrValue4());
        }
        if (!bl || this.isAttrValue5Dirty()) {
            hashMap.put(FIELD_ATTRVALUE5, this.getAttrValue5());
        }
        if (!bl || this.isAttrValue6Dirty()) {
            hashMap.put(FIELD_ATTRVALUE6, this.getAttrValue6());
        }
        if (!bl || this.isAttrValue7Dirty()) {
            hashMap.put(FIELD_ATTRVALUE7, this.getAttrValue7());
        }
        if (!bl || this.isAttrValue8Dirty()) {
            hashMap.put(FIELD_ATTRVALUE8, this.getAttrValue8());
        }
        if (!bl || this.isAttrValue9Dirty()) {
            hashMap.put(FIELD_ATTRVALUE9, this.getAttrValue9());
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
        if (!bl || this.isDynaModelUsageDirty()) {
            hashMap.put(FIELD_DYNAMODELUSAGE, this.getDynaModelUsage());
        }
        if (!bl || this.isJsonFormatDirty()) {
            hashMap.put(FIELD_JSONFORMAT, this.getJsonFormat());
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
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSSysDynaModelAttrIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELATTRID, this.getPSSysDynaModelAttrId());
        }
        if (!bl || this.isPSSysDynaModelAttrNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELATTRNAME, this.getPSSysDynaModelAttrName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
        }
        if (!bl || this.isRefPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_REFPSDEFGROUPID, this.getRefPSDEFGroupId());
        }
        if (!bl || this.isRefPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_REFPSDEFGROUPNAME, this.getRefPSDEFGroupName());
        }
        if (!bl || this.isRefPSDEIdDirty()) {
            hashMap.put(FIELD_REFPSDEID, this.getRefPSDEId());
        }
        if (!bl || this.isRefPSDENameDirty()) {
            hashMap.put(FIELD_REFPSDENAME, this.getRefPSDEName());
        }
        if (!bl || this.isRefPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_REFPSSYSDYNAMODELID, this.getRefPSSysDynaModelId());
        }
        if (!bl || this.isRefPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_REFPSSYSDYNAMODELNAME, this.getRefPSSysDynaModelName());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isValueTypeDirty()) {
            hashMap.put(FIELD_VALUETYPE, this.getValueType());
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
        return PSSysDynaModelAttrBase.get(this, n);
    }

    private static Object get(PSSysDynaModelAttrBase pSSysDynaModelAttrBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelAttrBase.getAllowEmpty();
            }
            case 1: {
                return pSSysDynaModelAttrBase.getArrayFlag();
            }
            case 2: {
                return pSSysDynaModelAttrBase.getAttrTag();
            }
            case 3: {
                return pSSysDynaModelAttrBase.getAttrTag2();
            }
            case 4: {
                return pSSysDynaModelAttrBase.getAttrValue();
            }
            case 5: {
                return pSSysDynaModelAttrBase.getAttrValue10();
            }
            case 6: {
                return pSSysDynaModelAttrBase.getAttrValue11();
            }
            case 7: {
                return pSSysDynaModelAttrBase.getAttrValue12();
            }
            case 8: {
                return pSSysDynaModelAttrBase.getAttrValue13();
            }
            case 9: {
                return pSSysDynaModelAttrBase.getAttrValue14();
            }
            case 10: {
                return pSSysDynaModelAttrBase.getAttrValue15();
            }
            case 11: {
                return pSSysDynaModelAttrBase.getAttrValue16();
            }
            case 12: {
                return pSSysDynaModelAttrBase.getAttrValue2();
            }
            case 13: {
                return pSSysDynaModelAttrBase.getAttrValue20();
            }
            case 14: {
                return pSSysDynaModelAttrBase.getAttrValue21();
            }
            case 15: {
                return pSSysDynaModelAttrBase.getAttrValue22();
            }
            case 16: {
                return pSSysDynaModelAttrBase.getAttrValue23();
            }
            case 17: {
                return pSSysDynaModelAttrBase.getAttrValue24();
            }
            case 18: {
                return pSSysDynaModelAttrBase.getAttrValue25();
            }
            case 19: {
                return pSSysDynaModelAttrBase.getAttrValue26();
            }
            case 20: {
                return pSSysDynaModelAttrBase.getAttrValue27();
            }
            case 21: {
                return pSSysDynaModelAttrBase.getAttrValue28();
            }
            case 22: {
                return pSSysDynaModelAttrBase.getAttrValue29();
            }
            case 23: {
                return pSSysDynaModelAttrBase.getAttrValue3();
            }
            case 24: {
                return pSSysDynaModelAttrBase.getAttrValue30();
            }
            case 25: {
                return pSSysDynaModelAttrBase.getAttrValue4();
            }
            case 26: {
                return pSSysDynaModelAttrBase.getAttrValue5();
            }
            case 27: {
                return pSSysDynaModelAttrBase.getAttrValue6();
            }
            case 28: {
                return pSSysDynaModelAttrBase.getAttrValue7();
            }
            case 29: {
                return pSSysDynaModelAttrBase.getAttrValue8();
            }
            case 30: {
                return pSSysDynaModelAttrBase.getAttrValue9();
            }
            case 31: {
                return pSSysDynaModelAttrBase.getCodeName();
            }
            case 32: {
                return pSSysDynaModelAttrBase.getCreateDate();
            }
            case 33: {
                return pSSysDynaModelAttrBase.getCreateMan();
            }
            case 34: {
                return pSSysDynaModelAttrBase.getDynaModelUsage();
            }
            case 35: {
                return pSSysDynaModelAttrBase.getJsonFormat();
            }
            case 36: {
                return pSSysDynaModelAttrBase.getLogicName();
            }
            case 37: {
                return pSSysDynaModelAttrBase.getMemo();
            }
            case 38: {
                return pSSysDynaModelAttrBase.getOrderValue();
            }
            case 39: {
                return pSSysDynaModelAttrBase.getPSCodeListId();
            }
            case 40: {
                return pSSysDynaModelAttrBase.getPSCodeListName();
            }
            case 41: {
                return pSSysDynaModelAttrBase.getPSSysDynaModelAttrId();
            }
            case 42: {
                return pSSysDynaModelAttrBase.getPSSysDynaModelAttrName();
            }
            case 43: {
                return pSSysDynaModelAttrBase.getPSSysDynaModelId();
            }
            case 44: {
                return pSSysDynaModelAttrBase.getPSSysDynaModelName();
            }
            case 45: {
                return pSSysDynaModelAttrBase.getPSSysValueRuleId();
            }
            case 46: {
                return pSSysDynaModelAttrBase.getPSSysValueRuleName();
            }
            case 47: {
                return pSSysDynaModelAttrBase.getRefPSDEFGroupId();
            }
            case 48: {
                return pSSysDynaModelAttrBase.getRefPSDEFGroupName();
            }
            case 49: {
                return pSSysDynaModelAttrBase.getRefPSDEId();
            }
            case 50: {
                return pSSysDynaModelAttrBase.getRefPSDEName();
            }
            case 51: {
                return pSSysDynaModelAttrBase.getRefPSSysDynaModelId();
            }
            case 52: {
                return pSSysDynaModelAttrBase.getRefPSSysDynaModelName();
            }
            case 53: {
                return pSSysDynaModelAttrBase.getStdDataType();
            }
            case 54: {
                return pSSysDynaModelAttrBase.getUpdateDate();
            }
            case 55: {
                return pSSysDynaModelAttrBase.getUpdateMan();
            }
            case 56: {
                return pSSysDynaModelAttrBase.getValidFlag();
            }
            case 57: {
                return pSSysDynaModelAttrBase.getValueType();
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
        PSSysDynaModelAttrBase.set(this, n, object);
    }

    private static void set(PSSysDynaModelAttrBase pSSysDynaModelAttrBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDynaModelAttrBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysDynaModelAttrBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSysDynaModelAttrBase.setAttrTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDynaModelAttrBase.setAttrTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDynaModelAttrBase.setAttrValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDynaModelAttrBase.setAttrValue10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 6: {
                pSSysDynaModelAttrBase.setAttrValue11(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 7: {
                pSSysDynaModelAttrBase.setAttrValue12(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 8: {
                pSSysDynaModelAttrBase.setAttrValue13(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSysDynaModelAttrBase.setAttrValue14(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSysDynaModelAttrBase.setAttrValue15(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysDynaModelAttrBase.setAttrValue16(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysDynaModelAttrBase.setAttrValue2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDynaModelAttrBase.setAttrValue20(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDynaModelAttrBase.setAttrValue21(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDynaModelAttrBase.setAttrValue22(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDynaModelAttrBase.setAttrValue23(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDynaModelAttrBase.setAttrValue24(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDynaModelAttrBase.setAttrValue25(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDynaModelAttrBase.setAttrValue26(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDynaModelAttrBase.setAttrValue27(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDynaModelAttrBase.setAttrValue28(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDynaModelAttrBase.setAttrValue29(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDynaModelAttrBase.setAttrValue3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDynaModelAttrBase.setAttrValue30(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDynaModelAttrBase.setAttrValue4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDynaModelAttrBase.setAttrValue5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysDynaModelAttrBase.setAttrValue6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSysDynaModelAttrBase.setAttrValue7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysDynaModelAttrBase.setAttrValue8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSysDynaModelAttrBase.setAttrValue9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 31: {
                pSSysDynaModelAttrBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDynaModelAttrBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSSysDynaModelAttrBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysDynaModelAttrBase.setDynaModelUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysDynaModelAttrBase.setJsonFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysDynaModelAttrBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDynaModelAttrBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysDynaModelAttrBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSSysDynaModelAttrBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysDynaModelAttrBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysDynaModelAttrBase.setPSSysDynaModelAttrId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysDynaModelAttrBase.setPSSysDynaModelAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysDynaModelAttrBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysDynaModelAttrBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysDynaModelAttrBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysDynaModelAttrBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysDynaModelAttrBase.setRefPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysDynaModelAttrBase.setRefPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysDynaModelAttrBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysDynaModelAttrBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysDynaModelAttrBase.setRefPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysDynaModelAttrBase.setRefPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysDynaModelAttrBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSSysDynaModelAttrBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 55: {
                pSSysDynaModelAttrBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysDynaModelAttrBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSSysDynaModelAttrBase.setValueType(DataObject.getStringValue((Object)object));
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
        return PSSysDynaModelAttrBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDynaModelAttrBase pSSysDynaModelAttrBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelAttrBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSSysDynaModelAttrBase.getArrayFlag() == null;
            }
            case 2: {
                return pSSysDynaModelAttrBase.getAttrTag() == null;
            }
            case 3: {
                return pSSysDynaModelAttrBase.getAttrTag2() == null;
            }
            case 4: {
                return pSSysDynaModelAttrBase.getAttrValue() == null;
            }
            case 5: {
                return pSSysDynaModelAttrBase.getAttrValue10() == null;
            }
            case 6: {
                return pSSysDynaModelAttrBase.getAttrValue11() == null;
            }
            case 7: {
                return pSSysDynaModelAttrBase.getAttrValue12() == null;
            }
            case 8: {
                return pSSysDynaModelAttrBase.getAttrValue13() == null;
            }
            case 9: {
                return pSSysDynaModelAttrBase.getAttrValue14() == null;
            }
            case 10: {
                return pSSysDynaModelAttrBase.getAttrValue15() == null;
            }
            case 11: {
                return pSSysDynaModelAttrBase.getAttrValue16() == null;
            }
            case 12: {
                return pSSysDynaModelAttrBase.getAttrValue2() == null;
            }
            case 13: {
                return pSSysDynaModelAttrBase.getAttrValue20() == null;
            }
            case 14: {
                return pSSysDynaModelAttrBase.getAttrValue21() == null;
            }
            case 15: {
                return pSSysDynaModelAttrBase.getAttrValue22() == null;
            }
            case 16: {
                return pSSysDynaModelAttrBase.getAttrValue23() == null;
            }
            case 17: {
                return pSSysDynaModelAttrBase.getAttrValue24() == null;
            }
            case 18: {
                return pSSysDynaModelAttrBase.getAttrValue25() == null;
            }
            case 19: {
                return pSSysDynaModelAttrBase.getAttrValue26() == null;
            }
            case 20: {
                return pSSysDynaModelAttrBase.getAttrValue27() == null;
            }
            case 21: {
                return pSSysDynaModelAttrBase.getAttrValue28() == null;
            }
            case 22: {
                return pSSysDynaModelAttrBase.getAttrValue29() == null;
            }
            case 23: {
                return pSSysDynaModelAttrBase.getAttrValue3() == null;
            }
            case 24: {
                return pSSysDynaModelAttrBase.getAttrValue30() == null;
            }
            case 25: {
                return pSSysDynaModelAttrBase.getAttrValue4() == null;
            }
            case 26: {
                return pSSysDynaModelAttrBase.getAttrValue5() == null;
            }
            case 27: {
                return pSSysDynaModelAttrBase.getAttrValue6() == null;
            }
            case 28: {
                return pSSysDynaModelAttrBase.getAttrValue7() == null;
            }
            case 29: {
                return pSSysDynaModelAttrBase.getAttrValue8() == null;
            }
            case 30: {
                return pSSysDynaModelAttrBase.getAttrValue9() == null;
            }
            case 31: {
                return pSSysDynaModelAttrBase.getCodeName() == null;
            }
            case 32: {
                return pSSysDynaModelAttrBase.getCreateDate() == null;
            }
            case 33: {
                return pSSysDynaModelAttrBase.getCreateMan() == null;
            }
            case 34: {
                return pSSysDynaModelAttrBase.getDynaModelUsage() == null;
            }
            case 35: {
                return pSSysDynaModelAttrBase.getJsonFormat() == null;
            }
            case 36: {
                return pSSysDynaModelAttrBase.getLogicName() == null;
            }
            case 37: {
                return pSSysDynaModelAttrBase.getMemo() == null;
            }
            case 38: {
                return pSSysDynaModelAttrBase.getOrderValue() == null;
            }
            case 39: {
                return pSSysDynaModelAttrBase.getPSCodeListId() == null;
            }
            case 40: {
                return pSSysDynaModelAttrBase.getPSCodeListName() == null;
            }
            case 41: {
                return pSSysDynaModelAttrBase.getPSSysDynaModelAttrId() == null;
            }
            case 42: {
                return pSSysDynaModelAttrBase.getPSSysDynaModelAttrName() == null;
            }
            case 43: {
                return pSSysDynaModelAttrBase.getPSSysDynaModelId() == null;
            }
            case 44: {
                return pSSysDynaModelAttrBase.getPSSysDynaModelName() == null;
            }
            case 45: {
                return pSSysDynaModelAttrBase.getPSSysValueRuleId() == null;
            }
            case 46: {
                return pSSysDynaModelAttrBase.getPSSysValueRuleName() == null;
            }
            case 47: {
                return pSSysDynaModelAttrBase.getRefPSDEFGroupId() == null;
            }
            case 48: {
                return pSSysDynaModelAttrBase.getRefPSDEFGroupName() == null;
            }
            case 49: {
                return pSSysDynaModelAttrBase.getRefPSDEId() == null;
            }
            case 50: {
                return pSSysDynaModelAttrBase.getRefPSDEName() == null;
            }
            case 51: {
                return pSSysDynaModelAttrBase.getRefPSSysDynaModelId() == null;
            }
            case 52: {
                return pSSysDynaModelAttrBase.getRefPSSysDynaModelName() == null;
            }
            case 53: {
                return pSSysDynaModelAttrBase.getStdDataType() == null;
            }
            case 54: {
                return pSSysDynaModelAttrBase.getUpdateDate() == null;
            }
            case 55: {
                return pSSysDynaModelAttrBase.getUpdateMan() == null;
            }
            case 56: {
                return pSSysDynaModelAttrBase.getValidFlag() == null;
            }
            case 57: {
                return pSSysDynaModelAttrBase.getValueType() == null;
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
        return PSSysDynaModelAttrBase.contains(this, n);
    }

    private static boolean contains(PSSysDynaModelAttrBase pSSysDynaModelAttrBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelAttrBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSSysDynaModelAttrBase.isArrayFlagDirty();
            }
            case 2: {
                return pSSysDynaModelAttrBase.isAttrTagDirty();
            }
            case 3: {
                return pSSysDynaModelAttrBase.isAttrTag2Dirty();
            }
            case 4: {
                return pSSysDynaModelAttrBase.isAttrValueDirty();
            }
            case 5: {
                return pSSysDynaModelAttrBase.isAttrValue10Dirty();
            }
            case 6: {
                return pSSysDynaModelAttrBase.isAttrValue11Dirty();
            }
            case 7: {
                return pSSysDynaModelAttrBase.isAttrValue12Dirty();
            }
            case 8: {
                return pSSysDynaModelAttrBase.isAttrValue13Dirty();
            }
            case 9: {
                return pSSysDynaModelAttrBase.isAttrValue14Dirty();
            }
            case 10: {
                return pSSysDynaModelAttrBase.isAttrValue15Dirty();
            }
            case 11: {
                return pSSysDynaModelAttrBase.isAttrValue16Dirty();
            }
            case 12: {
                return pSSysDynaModelAttrBase.isAttrValue2Dirty();
            }
            case 13: {
                return pSSysDynaModelAttrBase.isAttrValue20Dirty();
            }
            case 14: {
                return pSSysDynaModelAttrBase.isAttrValue21Dirty();
            }
            case 15: {
                return pSSysDynaModelAttrBase.isAttrValue22Dirty();
            }
            case 16: {
                return pSSysDynaModelAttrBase.isAttrValue23Dirty();
            }
            case 17: {
                return pSSysDynaModelAttrBase.isAttrValue24Dirty();
            }
            case 18: {
                return pSSysDynaModelAttrBase.isAttrValue25Dirty();
            }
            case 19: {
                return pSSysDynaModelAttrBase.isAttrValue26Dirty();
            }
            case 20: {
                return pSSysDynaModelAttrBase.isAttrValue27Dirty();
            }
            case 21: {
                return pSSysDynaModelAttrBase.isAttrValue28Dirty();
            }
            case 22: {
                return pSSysDynaModelAttrBase.isAttrValue29Dirty();
            }
            case 23: {
                return pSSysDynaModelAttrBase.isAttrValue3Dirty();
            }
            case 24: {
                return pSSysDynaModelAttrBase.isAttrValue30Dirty();
            }
            case 25: {
                return pSSysDynaModelAttrBase.isAttrValue4Dirty();
            }
            case 26: {
                return pSSysDynaModelAttrBase.isAttrValue5Dirty();
            }
            case 27: {
                return pSSysDynaModelAttrBase.isAttrValue6Dirty();
            }
            case 28: {
                return pSSysDynaModelAttrBase.isAttrValue7Dirty();
            }
            case 29: {
                return pSSysDynaModelAttrBase.isAttrValue8Dirty();
            }
            case 30: {
                return pSSysDynaModelAttrBase.isAttrValue9Dirty();
            }
            case 31: {
                return pSSysDynaModelAttrBase.isCodeNameDirty();
            }
            case 32: {
                return pSSysDynaModelAttrBase.isCreateDateDirty();
            }
            case 33: {
                return pSSysDynaModelAttrBase.isCreateManDirty();
            }
            case 34: {
                return pSSysDynaModelAttrBase.isDynaModelUsageDirty();
            }
            case 35: {
                return pSSysDynaModelAttrBase.isJsonFormatDirty();
            }
            case 36: {
                return pSSysDynaModelAttrBase.isLogicNameDirty();
            }
            case 37: {
                return pSSysDynaModelAttrBase.isMemoDirty();
            }
            case 38: {
                return pSSysDynaModelAttrBase.isOrderValueDirty();
            }
            case 39: {
                return pSSysDynaModelAttrBase.isPSCodeListIdDirty();
            }
            case 40: {
                return pSSysDynaModelAttrBase.isPSCodeListNameDirty();
            }
            case 41: {
                return pSSysDynaModelAttrBase.isPSSysDynaModelAttrIdDirty();
            }
            case 42: {
                return pSSysDynaModelAttrBase.isPSSysDynaModelAttrNameDirty();
            }
            case 43: {
                return pSSysDynaModelAttrBase.isPSSysDynaModelIdDirty();
            }
            case 44: {
                return pSSysDynaModelAttrBase.isPSSysDynaModelNameDirty();
            }
            case 45: {
                return pSSysDynaModelAttrBase.isPSSysValueRuleIdDirty();
            }
            case 46: {
                return pSSysDynaModelAttrBase.isPSSysValueRuleNameDirty();
            }
            case 47: {
                return pSSysDynaModelAttrBase.isRefPSDEFGroupIdDirty();
            }
            case 48: {
                return pSSysDynaModelAttrBase.isRefPSDEFGroupNameDirty();
            }
            case 49: {
                return pSSysDynaModelAttrBase.isRefPSDEIdDirty();
            }
            case 50: {
                return pSSysDynaModelAttrBase.isRefPSDENameDirty();
            }
            case 51: {
                return pSSysDynaModelAttrBase.isRefPSSysDynaModelIdDirty();
            }
            case 52: {
                return pSSysDynaModelAttrBase.isRefPSSysDynaModelNameDirty();
            }
            case 53: {
                return pSSysDynaModelAttrBase.isStdDataTypeDirty();
            }
            case 54: {
                return pSSysDynaModelAttrBase.isUpdateDateDirty();
            }
            case 55: {
                return pSSysDynaModelAttrBase.isUpdateManDirty();
            }
            case 56: {
                return pSSysDynaModelAttrBase.isValidFlagDirty();
            }
            case 57: {
                return pSSysDynaModelAttrBase.isValueTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDynaModelAttrBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDynaModelAttrBase pSSysDynaModelAttrBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDynaModelAttrBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrtag", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrTag()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrtag2", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrTag2()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue10", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue10()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue11", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue11()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue12", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue12()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue13", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue13()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue14", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue14()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue15() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue15", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue15()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue16() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue16", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue16()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue2", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue2()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue20() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue20", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue20()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue21() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue21", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue21()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue22() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue22", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue22()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue23() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue23", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue23()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue24() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue24", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue24()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue25() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue25", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue25()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue26() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue26", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue26()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue27() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue27", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue27()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue28() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue28", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue28()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue29() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue29", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue29()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue3", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue3()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue30() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue30", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue30()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue4", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue4()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue5", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue5()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue6", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue6()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue7", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue7()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue8", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue8()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrvalue9", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getAttrValue9()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getDynaModelUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelusage", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getDynaModelUsage()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getJsonFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsonformat", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getJsonFormat()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysDynaModelAttrId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelattrid", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getPSSysDynaModelAttrId()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysDynaModelAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelattrname", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getPSSysDynaModelAttrName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdefgroupid", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getRefPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdefgroupname", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getRefPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdynamodelid", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getRefPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdynamodelname", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getRefPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysDynaModelAttrBase.getValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuetype", (Object)PSSysDynaModelAttrBase.getJSONValue((Object)pSSysDynaModelAttrBase.getValueType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDynaModelAttrBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDynaModelAttrBase pSSysDynaModelAttrBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDynaModelAttrBase.getAllowEmpty() != null) {
            object = pSSysDynaModelAttrBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getArrayFlag() != null) {
            object = pSSysDynaModelAttrBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrTag() != null) {
            object = pSSysDynaModelAttrBase.getAttrTag();
            xmlNode.setAttribute(FIELD_ATTRTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrTag2() != null) {
            object = pSSysDynaModelAttrBase.getAttrTag2();
            xmlNode.setAttribute(FIELD_ATTRTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue();
            xmlNode.setAttribute(FIELD_ATTRVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue10() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue10();
            xmlNode.setAttribute(FIELD_ATTRVALUE10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue11() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue11();
            xmlNode.setAttribute(FIELD_ATTRVALUE11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue12() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue12();
            xmlNode.setAttribute(FIELD_ATTRVALUE12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue13() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue13();
            xmlNode.setAttribute(FIELD_ATTRVALUE13, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue14() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue14();
            xmlNode.setAttribute(FIELD_ATTRVALUE14, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue15() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue15();
            xmlNode.setAttribute(FIELD_ATTRVALUE15, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue16() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue16();
            xmlNode.setAttribute(FIELD_ATTRVALUE16, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue2() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue2();
            xmlNode.setAttribute(FIELD_ATTRVALUE2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue20() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue20();
            xmlNode.setAttribute(FIELD_ATTRVALUE20, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue21() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue21();
            xmlNode.setAttribute(FIELD_ATTRVALUE21, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue22() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue22();
            xmlNode.setAttribute(FIELD_ATTRVALUE22, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue23() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue23();
            xmlNode.setAttribute(FIELD_ATTRVALUE23, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue24() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue24();
            xmlNode.setAttribute(FIELD_ATTRVALUE24, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue25() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue25();
            xmlNode.setAttribute(FIELD_ATTRVALUE25, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue26() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue26();
            xmlNode.setAttribute(FIELD_ATTRVALUE26, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue27() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue27();
            xmlNode.setAttribute(FIELD_ATTRVALUE27, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue28() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue28();
            xmlNode.setAttribute(FIELD_ATTRVALUE28, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue29() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue29();
            xmlNode.setAttribute(FIELD_ATTRVALUE29, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue3() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue3();
            xmlNode.setAttribute(FIELD_ATTRVALUE3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue30() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue30();
            xmlNode.setAttribute(FIELD_ATTRVALUE30, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue4() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue4();
            xmlNode.setAttribute(FIELD_ATTRVALUE4, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue5() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue5();
            xmlNode.setAttribute(FIELD_ATTRVALUE5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue6() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue6();
            xmlNode.setAttribute(FIELD_ATTRVALUE6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue7() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue7();
            xmlNode.setAttribute(FIELD_ATTRVALUE7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue8() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue8();
            xmlNode.setAttribute(FIELD_ATTRVALUE8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getAttrValue9() != null) {
            object = pSSysDynaModelAttrBase.getAttrValue9();
            xmlNode.setAttribute(FIELD_ATTRVALUE9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getCodeName() != null) {
            object = pSSysDynaModelAttrBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getCreateDate() != null) {
            object = pSSysDynaModelAttrBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getCreateMan() != null) {
            object = pSSysDynaModelAttrBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getDynaModelUsage() != null) {
            object = pSSysDynaModelAttrBase.getDynaModelUsage();
            xmlNode.setAttribute(FIELD_DYNAMODELUSAGE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getJsonFormat() != null) {
            object = pSSysDynaModelAttrBase.getJsonFormat();
            xmlNode.setAttribute(FIELD_JSONFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getLogicName() != null) {
            object = pSSysDynaModelAttrBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getMemo() != null) {
            object = pSSysDynaModelAttrBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getOrderValue() != null) {
            object = pSSysDynaModelAttrBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getPSCodeListId() != null) {
            object = pSSysDynaModelAttrBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getPSCodeListName() != null) {
            object = pSSysDynaModelAttrBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysDynaModelAttrId() != null) {
            object = pSSysDynaModelAttrBase.getPSSysDynaModelAttrId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELATTRID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysDynaModelAttrName() != null) {
            object = pSSysDynaModelAttrBase.getPSSysDynaModelAttrName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysDynaModelId() != null) {
            object = pSSysDynaModelAttrBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysDynaModelName() != null) {
            object = pSSysDynaModelAttrBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysValueRuleId() != null) {
            object = pSSysDynaModelAttrBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getPSSysValueRuleName() != null) {
            object = pSSysDynaModelAttrBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSDEFGroupId() != null) {
            object = pSSysDynaModelAttrBase.getRefPSDEFGroupId();
            xmlNode.setAttribute(FIELD_REFPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSDEFGroupName() != null) {
            object = pSSysDynaModelAttrBase.getRefPSDEFGroupName();
            xmlNode.setAttribute(FIELD_REFPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSDEId() != null) {
            object = pSSysDynaModelAttrBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSDEName() != null) {
            object = pSSysDynaModelAttrBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSSysDynaModelId() != null) {
            object = pSSysDynaModelAttrBase.getRefPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_REFPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getRefPSSysDynaModelName() != null) {
            object = pSSysDynaModelAttrBase.getRefPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_REFPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getStdDataType() != null) {
            object = pSSysDynaModelAttrBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getUpdateDate() != null) {
            object = pSSysDynaModelAttrBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getUpdateMan() != null) {
            object = pSSysDynaModelAttrBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelAttrBase.getValidFlag() != null) {
            object = pSSysDynaModelAttrBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelAttrBase.getValueType() != null) {
            object = pSSysDynaModelAttrBase.getValueType();
            xmlNode.setAttribute(FIELD_VALUETYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDynaModelAttrBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDynaModelAttrBase pSSysDynaModelAttrBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDynaModelAttrBase.isAllowEmptyDirty() && (bl || pSSysDynaModelAttrBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSSysDynaModelAttrBase.getAllowEmpty());
        }
        if (pSSysDynaModelAttrBase.isArrayFlagDirty() && (bl || pSSysDynaModelAttrBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSSysDynaModelAttrBase.getArrayFlag());
        }
        if (pSSysDynaModelAttrBase.isAttrTagDirty() && (bl || pSSysDynaModelAttrBase.getAttrTag() != null)) {
            iDataObject.set(FIELD_ATTRTAG, (Object)pSSysDynaModelAttrBase.getAttrTag());
        }
        if (pSSysDynaModelAttrBase.isAttrTag2Dirty() && (bl || pSSysDynaModelAttrBase.getAttrTag2() != null)) {
            iDataObject.set(FIELD_ATTRTAG2, (Object)pSSysDynaModelAttrBase.getAttrTag2());
        }
        if (pSSysDynaModelAttrBase.isAttrValueDirty() && (bl || pSSysDynaModelAttrBase.getAttrValue() != null)) {
            iDataObject.set(FIELD_ATTRVALUE, (Object)pSSysDynaModelAttrBase.getAttrValue());
        }
        if (pSSysDynaModelAttrBase.isAttrValue10Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue10() != null)) {
            iDataObject.set(FIELD_ATTRVALUE10, (Object)pSSysDynaModelAttrBase.getAttrValue10());
        }
        if (pSSysDynaModelAttrBase.isAttrValue11Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue11() != null)) {
            iDataObject.set(FIELD_ATTRVALUE11, (Object)pSSysDynaModelAttrBase.getAttrValue11());
        }
        if (pSSysDynaModelAttrBase.isAttrValue12Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue12() != null)) {
            iDataObject.set(FIELD_ATTRVALUE12, (Object)pSSysDynaModelAttrBase.getAttrValue12());
        }
        if (pSSysDynaModelAttrBase.isAttrValue13Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue13() != null)) {
            iDataObject.set(FIELD_ATTRVALUE13, (Object)pSSysDynaModelAttrBase.getAttrValue13());
        }
        if (pSSysDynaModelAttrBase.isAttrValue14Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue14() != null)) {
            iDataObject.set(FIELD_ATTRVALUE14, (Object)pSSysDynaModelAttrBase.getAttrValue14());
        }
        if (pSSysDynaModelAttrBase.isAttrValue15Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue15() != null)) {
            iDataObject.set(FIELD_ATTRVALUE15, (Object)pSSysDynaModelAttrBase.getAttrValue15());
        }
        if (pSSysDynaModelAttrBase.isAttrValue16Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue16() != null)) {
            iDataObject.set(FIELD_ATTRVALUE16, (Object)pSSysDynaModelAttrBase.getAttrValue16());
        }
        if (pSSysDynaModelAttrBase.isAttrValue2Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue2() != null)) {
            iDataObject.set(FIELD_ATTRVALUE2, (Object)pSSysDynaModelAttrBase.getAttrValue2());
        }
        if (pSSysDynaModelAttrBase.isAttrValue20Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue20() != null)) {
            iDataObject.set(FIELD_ATTRVALUE20, (Object)pSSysDynaModelAttrBase.getAttrValue20());
        }
        if (pSSysDynaModelAttrBase.isAttrValue21Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue21() != null)) {
            iDataObject.set(FIELD_ATTRVALUE21, (Object)pSSysDynaModelAttrBase.getAttrValue21());
        }
        if (pSSysDynaModelAttrBase.isAttrValue22Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue22() != null)) {
            iDataObject.set(FIELD_ATTRVALUE22, (Object)pSSysDynaModelAttrBase.getAttrValue22());
        }
        if (pSSysDynaModelAttrBase.isAttrValue23Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue23() != null)) {
            iDataObject.set(FIELD_ATTRVALUE23, (Object)pSSysDynaModelAttrBase.getAttrValue23());
        }
        if (pSSysDynaModelAttrBase.isAttrValue24Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue24() != null)) {
            iDataObject.set(FIELD_ATTRVALUE24, (Object)pSSysDynaModelAttrBase.getAttrValue24());
        }
        if (pSSysDynaModelAttrBase.isAttrValue25Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue25() != null)) {
            iDataObject.set(FIELD_ATTRVALUE25, (Object)pSSysDynaModelAttrBase.getAttrValue25());
        }
        if (pSSysDynaModelAttrBase.isAttrValue26Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue26() != null)) {
            iDataObject.set(FIELD_ATTRVALUE26, (Object)pSSysDynaModelAttrBase.getAttrValue26());
        }
        if (pSSysDynaModelAttrBase.isAttrValue27Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue27() != null)) {
            iDataObject.set(FIELD_ATTRVALUE27, (Object)pSSysDynaModelAttrBase.getAttrValue27());
        }
        if (pSSysDynaModelAttrBase.isAttrValue28Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue28() != null)) {
            iDataObject.set(FIELD_ATTRVALUE28, (Object)pSSysDynaModelAttrBase.getAttrValue28());
        }
        if (pSSysDynaModelAttrBase.isAttrValue29Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue29() != null)) {
            iDataObject.set(FIELD_ATTRVALUE29, (Object)pSSysDynaModelAttrBase.getAttrValue29());
        }
        if (pSSysDynaModelAttrBase.isAttrValue3Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue3() != null)) {
            iDataObject.set(FIELD_ATTRVALUE3, (Object)pSSysDynaModelAttrBase.getAttrValue3());
        }
        if (pSSysDynaModelAttrBase.isAttrValue30Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue30() != null)) {
            iDataObject.set(FIELD_ATTRVALUE30, (Object)pSSysDynaModelAttrBase.getAttrValue30());
        }
        if (pSSysDynaModelAttrBase.isAttrValue4Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue4() != null)) {
            iDataObject.set(FIELD_ATTRVALUE4, (Object)pSSysDynaModelAttrBase.getAttrValue4());
        }
        if (pSSysDynaModelAttrBase.isAttrValue5Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue5() != null)) {
            iDataObject.set(FIELD_ATTRVALUE5, (Object)pSSysDynaModelAttrBase.getAttrValue5());
        }
        if (pSSysDynaModelAttrBase.isAttrValue6Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue6() != null)) {
            iDataObject.set(FIELD_ATTRVALUE6, (Object)pSSysDynaModelAttrBase.getAttrValue6());
        }
        if (pSSysDynaModelAttrBase.isAttrValue7Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue7() != null)) {
            iDataObject.set(FIELD_ATTRVALUE7, (Object)pSSysDynaModelAttrBase.getAttrValue7());
        }
        if (pSSysDynaModelAttrBase.isAttrValue8Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue8() != null)) {
            iDataObject.set(FIELD_ATTRVALUE8, (Object)pSSysDynaModelAttrBase.getAttrValue8());
        }
        if (pSSysDynaModelAttrBase.isAttrValue9Dirty() && (bl || pSSysDynaModelAttrBase.getAttrValue9() != null)) {
            iDataObject.set(FIELD_ATTRVALUE9, (Object)pSSysDynaModelAttrBase.getAttrValue9());
        }
        if (pSSysDynaModelAttrBase.isCodeNameDirty() && (bl || pSSysDynaModelAttrBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDynaModelAttrBase.getCodeName());
        }
        if (pSSysDynaModelAttrBase.isCreateDateDirty() && (bl || pSSysDynaModelAttrBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDynaModelAttrBase.getCreateDate());
        }
        if (pSSysDynaModelAttrBase.isCreateManDirty() && (bl || pSSysDynaModelAttrBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDynaModelAttrBase.getCreateMan());
        }
        if (pSSysDynaModelAttrBase.isDynaModelUsageDirty() && (bl || pSSysDynaModelAttrBase.getDynaModelUsage() != null)) {
            iDataObject.set(FIELD_DYNAMODELUSAGE, (Object)pSSysDynaModelAttrBase.getDynaModelUsage());
        }
        if (pSSysDynaModelAttrBase.isJsonFormatDirty() && (bl || pSSysDynaModelAttrBase.getJsonFormat() != null)) {
            iDataObject.set(FIELD_JSONFORMAT, (Object)pSSysDynaModelAttrBase.getJsonFormat());
        }
        if (pSSysDynaModelAttrBase.isLogicNameDirty() && (bl || pSSysDynaModelAttrBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysDynaModelAttrBase.getLogicName());
        }
        if (pSSysDynaModelAttrBase.isMemoDirty() && (bl || pSSysDynaModelAttrBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDynaModelAttrBase.getMemo());
        }
        if (pSSysDynaModelAttrBase.isOrderValueDirty() && (bl || pSSysDynaModelAttrBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDynaModelAttrBase.getOrderValue());
        }
        if (pSSysDynaModelAttrBase.isPSCodeListIdDirty() && (bl || pSSysDynaModelAttrBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysDynaModelAttrBase.getPSCodeListId());
        }
        if (pSSysDynaModelAttrBase.isPSCodeListNameDirty() && (bl || pSSysDynaModelAttrBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysDynaModelAttrBase.getPSCodeListName());
        }
        if (pSSysDynaModelAttrBase.isPSSysDynaModelAttrIdDirty() && (bl || pSSysDynaModelAttrBase.getPSSysDynaModelAttrId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELATTRID, (Object)pSSysDynaModelAttrBase.getPSSysDynaModelAttrId());
        }
        if (pSSysDynaModelAttrBase.isPSSysDynaModelAttrNameDirty() && (bl || pSSysDynaModelAttrBase.getPSSysDynaModelAttrName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELATTRNAME, (Object)pSSysDynaModelAttrBase.getPSSysDynaModelAttrName());
        }
        if (pSSysDynaModelAttrBase.isPSSysDynaModelIdDirty() && (bl || pSSysDynaModelAttrBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysDynaModelAttrBase.getPSSysDynaModelId());
        }
        if (pSSysDynaModelAttrBase.isPSSysDynaModelNameDirty() && (bl || pSSysDynaModelAttrBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysDynaModelAttrBase.getPSSysDynaModelName());
        }
        if (pSSysDynaModelAttrBase.isPSSysValueRuleIdDirty() && (bl || pSSysDynaModelAttrBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSSysDynaModelAttrBase.getPSSysValueRuleId());
        }
        if (pSSysDynaModelAttrBase.isPSSysValueRuleNameDirty() && (bl || pSSysDynaModelAttrBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSSysDynaModelAttrBase.getPSSysValueRuleName());
        }
        if (pSSysDynaModelAttrBase.isRefPSDEFGroupIdDirty() && (bl || pSSysDynaModelAttrBase.getRefPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_REFPSDEFGROUPID, (Object)pSSysDynaModelAttrBase.getRefPSDEFGroupId());
        }
        if (pSSysDynaModelAttrBase.isRefPSDEFGroupNameDirty() && (bl || pSSysDynaModelAttrBase.getRefPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_REFPSDEFGROUPNAME, (Object)pSSysDynaModelAttrBase.getRefPSDEFGroupName());
        }
        if (pSSysDynaModelAttrBase.isRefPSDEIdDirty() && (bl || pSSysDynaModelAttrBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSSysDynaModelAttrBase.getRefPSDEId());
        }
        if (pSSysDynaModelAttrBase.isRefPSDENameDirty() && (bl || pSSysDynaModelAttrBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSSysDynaModelAttrBase.getRefPSDEName());
        }
        if (pSSysDynaModelAttrBase.isRefPSSysDynaModelIdDirty() && (bl || pSSysDynaModelAttrBase.getRefPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_REFPSSYSDYNAMODELID, (Object)pSSysDynaModelAttrBase.getRefPSSysDynaModelId());
        }
        if (pSSysDynaModelAttrBase.isRefPSSysDynaModelNameDirty() && (bl || pSSysDynaModelAttrBase.getRefPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_REFPSSYSDYNAMODELNAME, (Object)pSSysDynaModelAttrBase.getRefPSSysDynaModelName());
        }
        if (pSSysDynaModelAttrBase.isStdDataTypeDirty() && (bl || pSSysDynaModelAttrBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysDynaModelAttrBase.getStdDataType());
        }
        if (pSSysDynaModelAttrBase.isUpdateDateDirty() && (bl || pSSysDynaModelAttrBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDynaModelAttrBase.getUpdateDate());
        }
        if (pSSysDynaModelAttrBase.isUpdateManDirty() && (bl || pSSysDynaModelAttrBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDynaModelAttrBase.getUpdateMan());
        }
        if (pSSysDynaModelAttrBase.isValidFlagDirty() && (bl || pSSysDynaModelAttrBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysDynaModelAttrBase.getValidFlag());
        }
        if (pSSysDynaModelAttrBase.isValueTypeDirty() && (bl || pSSysDynaModelAttrBase.getValueType() != null)) {
            iDataObject.set(FIELD_VALUETYPE, (Object)pSSysDynaModelAttrBase.getValueType());
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
        return PSSysDynaModelAttrBase.remove(this, n);
    }

    private static boolean remove(PSSysDynaModelAttrBase pSSysDynaModelAttrBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDynaModelAttrBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSSysDynaModelAttrBase.resetArrayFlag();
                return true;
            }
            case 2: {
                pSSysDynaModelAttrBase.resetAttrTag();
                return true;
            }
            case 3: {
                pSSysDynaModelAttrBase.resetAttrTag2();
                return true;
            }
            case 4: {
                pSSysDynaModelAttrBase.resetAttrValue();
                return true;
            }
            case 5: {
                pSSysDynaModelAttrBase.resetAttrValue10();
                return true;
            }
            case 6: {
                pSSysDynaModelAttrBase.resetAttrValue11();
                return true;
            }
            case 7: {
                pSSysDynaModelAttrBase.resetAttrValue12();
                return true;
            }
            case 8: {
                pSSysDynaModelAttrBase.resetAttrValue13();
                return true;
            }
            case 9: {
                pSSysDynaModelAttrBase.resetAttrValue14();
                return true;
            }
            case 10: {
                pSSysDynaModelAttrBase.resetAttrValue15();
                return true;
            }
            case 11: {
                pSSysDynaModelAttrBase.resetAttrValue16();
                return true;
            }
            case 12: {
                pSSysDynaModelAttrBase.resetAttrValue2();
                return true;
            }
            case 13: {
                pSSysDynaModelAttrBase.resetAttrValue20();
                return true;
            }
            case 14: {
                pSSysDynaModelAttrBase.resetAttrValue21();
                return true;
            }
            case 15: {
                pSSysDynaModelAttrBase.resetAttrValue22();
                return true;
            }
            case 16: {
                pSSysDynaModelAttrBase.resetAttrValue23();
                return true;
            }
            case 17: {
                pSSysDynaModelAttrBase.resetAttrValue24();
                return true;
            }
            case 18: {
                pSSysDynaModelAttrBase.resetAttrValue25();
                return true;
            }
            case 19: {
                pSSysDynaModelAttrBase.resetAttrValue26();
                return true;
            }
            case 20: {
                pSSysDynaModelAttrBase.resetAttrValue27();
                return true;
            }
            case 21: {
                pSSysDynaModelAttrBase.resetAttrValue28();
                return true;
            }
            case 22: {
                pSSysDynaModelAttrBase.resetAttrValue29();
                return true;
            }
            case 23: {
                pSSysDynaModelAttrBase.resetAttrValue3();
                return true;
            }
            case 24: {
                pSSysDynaModelAttrBase.resetAttrValue30();
                return true;
            }
            case 25: {
                pSSysDynaModelAttrBase.resetAttrValue4();
                return true;
            }
            case 26: {
                pSSysDynaModelAttrBase.resetAttrValue5();
                return true;
            }
            case 27: {
                pSSysDynaModelAttrBase.resetAttrValue6();
                return true;
            }
            case 28: {
                pSSysDynaModelAttrBase.resetAttrValue7();
                return true;
            }
            case 29: {
                pSSysDynaModelAttrBase.resetAttrValue8();
                return true;
            }
            case 30: {
                pSSysDynaModelAttrBase.resetAttrValue9();
                return true;
            }
            case 31: {
                pSSysDynaModelAttrBase.resetCodeName();
                return true;
            }
            case 32: {
                pSSysDynaModelAttrBase.resetCreateDate();
                return true;
            }
            case 33: {
                pSSysDynaModelAttrBase.resetCreateMan();
                return true;
            }
            case 34: {
                pSSysDynaModelAttrBase.resetDynaModelUsage();
                return true;
            }
            case 35: {
                pSSysDynaModelAttrBase.resetJsonFormat();
                return true;
            }
            case 36: {
                pSSysDynaModelAttrBase.resetLogicName();
                return true;
            }
            case 37: {
                pSSysDynaModelAttrBase.resetMemo();
                return true;
            }
            case 38: {
                pSSysDynaModelAttrBase.resetOrderValue();
                return true;
            }
            case 39: {
                pSSysDynaModelAttrBase.resetPSCodeListId();
                return true;
            }
            case 40: {
                pSSysDynaModelAttrBase.resetPSCodeListName();
                return true;
            }
            case 41: {
                pSSysDynaModelAttrBase.resetPSSysDynaModelAttrId();
                return true;
            }
            case 42: {
                pSSysDynaModelAttrBase.resetPSSysDynaModelAttrName();
                return true;
            }
            case 43: {
                pSSysDynaModelAttrBase.resetPSSysDynaModelId();
                return true;
            }
            case 44: {
                pSSysDynaModelAttrBase.resetPSSysDynaModelName();
                return true;
            }
            case 45: {
                pSSysDynaModelAttrBase.resetPSSysValueRuleId();
                return true;
            }
            case 46: {
                pSSysDynaModelAttrBase.resetPSSysValueRuleName();
                return true;
            }
            case 47: {
                pSSysDynaModelAttrBase.resetRefPSDEFGroupId();
                return true;
            }
            case 48: {
                pSSysDynaModelAttrBase.resetRefPSDEFGroupName();
                return true;
            }
            case 49: {
                pSSysDynaModelAttrBase.resetRefPSDEId();
                return true;
            }
            case 50: {
                pSSysDynaModelAttrBase.resetRefPSDEName();
                return true;
            }
            case 51: {
                pSSysDynaModelAttrBase.resetRefPSSysDynaModelId();
                return true;
            }
            case 52: {
                pSSysDynaModelAttrBase.resetRefPSSysDynaModelName();
                return true;
            }
            case 53: {
                pSSysDynaModelAttrBase.resetStdDataType();
                return true;
            }
            case 54: {
                pSSysDynaModelAttrBase.resetUpdateDate();
                return true;
            }
            case 55: {
                pSSysDynaModelAttrBase.resetUpdateMan();
                return true;
            }
            case 56: {
                pSSysDynaModelAttrBase.resetValidFlag();
                return true;
            }
            case 57: {
                pSSysDynaModelAttrBase.resetValueType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getRefPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDE();
        }
        if (this.getRefPSDEId() == null) {
            return null;
        }
        Integer n = this.objRefPSDELock;
        synchronized (n) {
            if (this.refpsde != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEId(), (Object)this.refpsde.getPSDataEntityId()) != 0L) {
                this.refpsde = null;
            }
            if (this.refpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getRefPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.refpsde = pSDataEntity;
            }
            return this.refpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getRefPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEFGroup();
        }
        if (this.getRefPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEFGroupLock;
        synchronized (n) {
            if (this.refpsdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEFGroupId(), (Object)this.refpsdefgroup.getPSDEFGroupId()) != 0L) {
                this.refpsdefgroup = null;
            }
            if (this.refpsdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getRefPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet((IEntity)pSDEFGroup);
                this.refpsdefgroup = pSDEFGroup;
            }
            return this.refpsdefgroup;
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
    public PSSysDynaModel getRefPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDynaModel();
        }
        if (this.getRefPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysDynaModelLock;
        synchronized (n) {
            if (this.refpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysDynaModelId(), (Object)this.refpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.refpssysdynamodel = null;
            }
            if (this.refpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getRefPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.refpssysdynamodel = pSSysDynaModel;
            }
            return this.refpssysdynamodel;
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
                pSSysValueRuleService.autoGet((IEntity)pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    private PSSysDynaModelAttrBase getProxyEntity() {
        return this.proxyPSSysDynaModelAttrBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDynaModelAttrBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDynaModelAttrBase) {
            this.proxyPSSysDynaModelAttrBase = (PSSysDynaModelAttrBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_ARRAYFLAG, 1);
        fieldIndexMap.put(FIELD_ATTRTAG, 2);
        fieldIndexMap.put(FIELD_ATTRTAG2, 3);
        fieldIndexMap.put(FIELD_ATTRVALUE, 4);
        fieldIndexMap.put(FIELD_ATTRVALUE10, 5);
        fieldIndexMap.put(FIELD_ATTRVALUE11, 6);
        fieldIndexMap.put(FIELD_ATTRVALUE12, 7);
        fieldIndexMap.put(FIELD_ATTRVALUE13, 8);
        fieldIndexMap.put(FIELD_ATTRVALUE14, 9);
        fieldIndexMap.put(FIELD_ATTRVALUE15, 10);
        fieldIndexMap.put(FIELD_ATTRVALUE16, 11);
        fieldIndexMap.put(FIELD_ATTRVALUE2, 12);
        fieldIndexMap.put(FIELD_ATTRVALUE20, 13);
        fieldIndexMap.put(FIELD_ATTRVALUE21, 14);
        fieldIndexMap.put(FIELD_ATTRVALUE22, 15);
        fieldIndexMap.put(FIELD_ATTRVALUE23, 16);
        fieldIndexMap.put(FIELD_ATTRVALUE24, 17);
        fieldIndexMap.put(FIELD_ATTRVALUE25, 18);
        fieldIndexMap.put(FIELD_ATTRVALUE26, 19);
        fieldIndexMap.put(FIELD_ATTRVALUE27, 20);
        fieldIndexMap.put(FIELD_ATTRVALUE28, 21);
        fieldIndexMap.put(FIELD_ATTRVALUE29, 22);
        fieldIndexMap.put(FIELD_ATTRVALUE3, 23);
        fieldIndexMap.put(FIELD_ATTRVALUE30, 24);
        fieldIndexMap.put(FIELD_ATTRVALUE4, 25);
        fieldIndexMap.put(FIELD_ATTRVALUE5, 26);
        fieldIndexMap.put(FIELD_ATTRVALUE6, 27);
        fieldIndexMap.put(FIELD_ATTRVALUE7, 28);
        fieldIndexMap.put(FIELD_ATTRVALUE8, 29);
        fieldIndexMap.put(FIELD_ATTRVALUE9, 30);
        fieldIndexMap.put(FIELD_CODENAME, 31);
        fieldIndexMap.put(FIELD_CREATEDATE, 32);
        fieldIndexMap.put(FIELD_CREATEMAN, 33);
        fieldIndexMap.put(FIELD_DYNAMODELUSAGE, 34);
        fieldIndexMap.put(FIELD_JSONFORMAT, 35);
        fieldIndexMap.put(FIELD_LOGICNAME, 36);
        fieldIndexMap.put(FIELD_MEMO, 37);
        fieldIndexMap.put(FIELD_ORDERVALUE, 38);
        fieldIndexMap.put(FIELD_PSCODELISTID, 39);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 40);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELATTRID, 41);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELATTRNAME, 42);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 43);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 44);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 45);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 46);
        fieldIndexMap.put(FIELD_REFPSDEFGROUPID, 47);
        fieldIndexMap.put(FIELD_REFPSDEFGROUPNAME, 48);
        fieldIndexMap.put(FIELD_REFPSDEID, 49);
        fieldIndexMap.put(FIELD_REFPSDENAME, 50);
        fieldIndexMap.put(FIELD_REFPSSYSDYNAMODELID, 51);
        fieldIndexMap.put(FIELD_REFPSSYSDYNAMODELNAME, 52);
        fieldIndexMap.put(FIELD_STDDATATYPE, 53);
        fieldIndexMap.put(FIELD_UPDATEDATE, 54);
        fieldIndexMap.put(FIELD_UPDATEMAN, 55);
        fieldIndexMap.put(FIELD_VALIDFLAG, 56);
        fieldIndexMap.put(FIELD_VALUETYPE, 57);
    }
}

