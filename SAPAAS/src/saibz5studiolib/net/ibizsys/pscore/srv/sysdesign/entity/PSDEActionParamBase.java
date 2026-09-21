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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEActionParamBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_JSONFORMAT = "JSONFORMAT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMDESC = "PARAMDESC";
    public static final String FIELD_PARAMTAG = "PARAMTAG";
    public static final String FIELD_PARAMTAG2 = "PARAMTAG2";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEACTIONPARAMID = "PSDEACTIONPARAMID";
    public static final String FIELD_PSDEACTIONPARAMNAME = "PSDEACTIONPARAMNAME";
    public static final String FIELD_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String FIELD_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
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
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALUE = "VALUE";
    public static final String FIELD_VALUEDESC = "VALUEDESC";
    public static final String FIELD_VALUETYPE = "VALUETYPE";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_ARRAYFLAG = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DYNAMODELFLAG = 5;
    private static final int INDEX_JSONFORMAT = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PARAMDESC = 9;
    private static final int INDEX_PARAMTAG = 10;
    private static final int INDEX_PARAMTAG2 = 11;
    private static final int INDEX_PSDEACTIONID = 12;
    private static final int INDEX_PSDEACTIONNAME = 13;
    private static final int INDEX_PSDEACTIONPARAMID = 14;
    private static final int INDEX_PSDEACTIONPARAMNAME = 15;
    private static final int INDEX_PSDEFVALUERULEID = 16;
    private static final int INDEX_PSDEFVALUERULENAME = 17;
    private static final int INDEX_PSDEID = 18;
    private static final int INDEX_PSDYNAINSTID = 19;
    private static final int INDEX_PSSYSVALUERULEID = 20;
    private static final int INDEX_PSSYSVALUERULENAME = 21;
    private static final int INDEX_REFPSDEFGROUPID = 22;
    private static final int INDEX_REFPSDEFGROUPNAME = 23;
    private static final int INDEX_REFPSDEID = 24;
    private static final int INDEX_REFPSDENAME = 25;
    private static final int INDEX_REFPSSYSDYNAMODELID = 26;
    private static final int INDEX_REFPSSYSDYNAMODELNAME = 27;
    private static final int INDEX_STDDATATYPE = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USERCAT = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final int INDEX_VALUE = 36;
    private static final int INDEX_VALUEDESC = 37;
    private static final int INDEX_VALUETYPE = 38;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEActionParamBase proxyPSDEActionParamBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean arrayflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean jsonformatDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramdescDirtyFlag = false;
    private boolean paramtagDirtyFlag = false;
    private boolean paramtag2DirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeactionparamidDirtyFlag = false;
    private boolean psdeactionparamnameDirtyFlag = false;
    private boolean psdefvalueruleidDirtyFlag = false;
    private boolean psdefvaluerulenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
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
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean valueDirtyFlag = false;
    private boolean valuedescDirtyFlag = false;
    private boolean valuetypeDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="arrayflag")
    private Integer arrayflag;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="jsonformat")
    private String jsonformat;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramdesc")
    private String paramdesc;
    @Column(name="paramtag")
    private String paramtag;
    @Column(name="paramtag2")
    private String paramtag2;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeactionparamid")
    private String psdeactionparamid;
    @Column(name="psdeactionparamname")
    private String psdeactionparamname;
    @Column(name="psdefvalueruleid")
    private String psdefvalueruleid;
    @Column(name="psdefvaluerulename")
    private String psdefvaluerulename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdynainstid")
    private String psdynainstid;
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
    @Column(name="value")
    private String value;
    @Column(name="valuedesc")
    private String valuedesc;
    @Column(name="valuetype")
    private String valuetype;
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objRefPSDEFGroupLock = new Integer(1);
    private PSDEFGroup refpsdefgroup = null;
    private Integer objPSDEFValueRuleLock = new Integer(1);
    private PSDEFValueRule psdefvaluerule = null;
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

    public void setParamDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramdesc = string;
        this.paramdescDirtyFlag = true;
    }

    public String getParamDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamDesc();
        }
        return this.paramdesc;
    }

    public boolean isParamDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDescDirty();
        }
        return this.paramdescDirtyFlag;
    }

    public void resetParamDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamDesc();
            return;
        }
        this.paramdescDirtyFlag = false;
        this.paramdesc = null;
    }

    public void setParamTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtag = string;
        this.paramtagDirtyFlag = true;
    }

    public String getParamTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTag();
        }
        return this.paramtag;
    }

    public boolean isParamTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTagDirty();
        }
        return this.paramtagDirtyFlag;
    }

    public void resetParamTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTag();
            return;
        }
        this.paramtagDirtyFlag = false;
        this.paramtag = null;
    }

    public void setParamTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtag2 = string;
        this.paramtag2DirtyFlag = true;
    }

    public String getParamTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTag2();
        }
        return this.paramtag2;
    }

    public boolean isParamTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTag2Dirty();
        }
        return this.paramtag2DirtyFlag;
    }

    public void resetParamTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTag2();
            return;
        }
        this.paramtag2DirtyFlag = false;
        this.paramtag2 = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEActionParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionparamid = string;
        this.psdeactionparamidDirtyFlag = true;
    }

    public String getPSDEActionParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionParamId();
        }
        return this.psdeactionparamid;
    }

    public boolean isPSDEActionParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionParamIdDirty();
        }
        return this.psdeactionparamidDirtyFlag;
    }

    public void resetPSDEActionParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionParamId();
            return;
        }
        this.psdeactionparamidDirtyFlag = false;
        this.psdeactionparamid = null;
    }

    public void setPSDEActionParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionparamname = string;
        this.psdeactionparamnameDirtyFlag = true;
    }

    public String getPSDEActionParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionParamName();
        }
        return this.psdeactionparamname;
    }

    public boolean isPSDEActionParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionParamNameDirty();
        }
        return this.psdeactionparamnameDirtyFlag;
    }

    public void resetPSDEActionParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionParamName();
            return;
        }
        this.psdeactionparamnameDirtyFlag = false;
        this.psdeactionparamname = null;
    }

    public void setPSDEFValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvalueruleid = string;
        this.psdefvalueruleidDirtyFlag = true;
    }

    public String getPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleId();
        }
        return this.psdefvalueruleid;
    }

    public boolean isPSDEFValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleIdDirty();
        }
        return this.psdefvalueruleidDirtyFlag;
    }

    public void resetPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleId();
            return;
        }
        this.psdefvalueruleidDirtyFlag = false;
        this.psdefvalueruleid = null;
    }

    public void setPSDEFValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvaluerulename = string;
        this.psdefvaluerulenameDirtyFlag = true;
    }

    public String getPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleName();
        }
        return this.psdefvaluerulename;
    }

    public boolean isPSDEFValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleNameDirty();
        }
        return this.psdefvaluerulenameDirtyFlag;
    }

    public void resetPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleName();
            return;
        }
        this.psdefvaluerulenameDirtyFlag = false;
        this.psdefvaluerulename = null;
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

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    public void setValueDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuedesc = string;
        this.valuedescDirtyFlag = true;
    }

    public String getValueDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueDesc();
        }
        return this.valuedesc;
    }

    public boolean isValueDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDescDirty();
        }
        return this.valuedescDirtyFlag;
    }

    public void resetValueDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueDesc();
            return;
        }
        this.valuedescDirtyFlag = false;
        this.valuedesc = null;
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
        PSDEActionParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEActionParamBase pSDEActionParamBase) {
        pSDEActionParamBase.resetAllowEmpty();
        pSDEActionParamBase.resetArrayFlag();
        pSDEActionParamBase.resetCodeName();
        pSDEActionParamBase.resetCreateDate();
        pSDEActionParamBase.resetCreateMan();
        pSDEActionParamBase.resetDynaModelFlag();
        pSDEActionParamBase.resetJsonFormat();
        pSDEActionParamBase.resetMemo();
        pSDEActionParamBase.resetOrderValue();
        pSDEActionParamBase.resetParamDesc();
        pSDEActionParamBase.resetParamTag();
        pSDEActionParamBase.resetParamTag2();
        pSDEActionParamBase.resetPSDEActionId();
        pSDEActionParamBase.resetPSDEActionName();
        pSDEActionParamBase.resetPSDEActionParamId();
        pSDEActionParamBase.resetPSDEActionParamName();
        pSDEActionParamBase.resetPSDEFValueRuleId();
        pSDEActionParamBase.resetPSDEFValueRuleName();
        pSDEActionParamBase.resetPSDEId();
        pSDEActionParamBase.resetPSDynaInstId();
        pSDEActionParamBase.resetPSSysValueRuleId();
        pSDEActionParamBase.resetPSSysValueRuleName();
        pSDEActionParamBase.resetRefPSDEFGroupId();
        pSDEActionParamBase.resetRefPSDEFGroupName();
        pSDEActionParamBase.resetRefPSDEId();
        pSDEActionParamBase.resetRefPSDEName();
        pSDEActionParamBase.resetRefPSSysDynaModelId();
        pSDEActionParamBase.resetRefPSSysDynaModelName();
        pSDEActionParamBase.resetStdDataType();
        pSDEActionParamBase.resetUpdateDate();
        pSDEActionParamBase.resetUpdateMan();
        pSDEActionParamBase.resetUserCat();
        pSDEActionParamBase.resetUserTag();
        pSDEActionParamBase.resetUserTag2();
        pSDEActionParamBase.resetUserTag3();
        pSDEActionParamBase.resetUserTag4();
        pSDEActionParamBase.resetValue();
        pSDEActionParamBase.resetValueDesc();
        pSDEActionParamBase.resetValueType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
        }
        if (!bl || this.isArrayFlagDirty()) {
            hashMap.put(FIELD_ARRAYFLAG, this.getArrayFlag());
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isJsonFormatDirty()) {
            hashMap.put(FIELD_JSONFORMAT, this.getJsonFormat());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamDescDirty()) {
            hashMap.put(FIELD_PARAMDESC, this.getParamDesc());
        }
        if (!bl || this.isParamTagDirty()) {
            hashMap.put(FIELD_PARAMTAG, this.getParamTag());
        }
        if (!bl || this.isParamTag2Dirty()) {
            hashMap.put(FIELD_PARAMTAG2, this.getParamTag2());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEActionParamIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONPARAMID, this.getPSDEActionParamId());
        }
        if (!bl || this.isPSDEActionParamNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONPARAMNAME, this.getPSDEActionParamName());
        }
        if (!bl || this.isPSDEFValueRuleIdDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULEID, this.getPSDEFValueRuleId());
        }
        if (!bl || this.isPSDEFValueRuleNameDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULENAME, this.getPSDEFValueRuleName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
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
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
        }
        if (!bl || this.isValueDescDirty()) {
            hashMap.put(FIELD_VALUEDESC, this.getValueDesc());
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
        return PSDEActionParamBase.get(this, n);
    }

    private static Object get(PSDEActionParamBase pSDEActionParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionParamBase.getAllowEmpty();
            }
            case 1: {
                return pSDEActionParamBase.getArrayFlag();
            }
            case 2: {
                return pSDEActionParamBase.getCodeName();
            }
            case 3: {
                return pSDEActionParamBase.getCreateDate();
            }
            case 4: {
                return pSDEActionParamBase.getCreateMan();
            }
            case 5: {
                return pSDEActionParamBase.getDynaModelFlag();
            }
            case 6: {
                return pSDEActionParamBase.getJsonFormat();
            }
            case 7: {
                return pSDEActionParamBase.getMemo();
            }
            case 8: {
                return pSDEActionParamBase.getOrderValue();
            }
            case 9: {
                return pSDEActionParamBase.getParamDesc();
            }
            case 10: {
                return pSDEActionParamBase.getParamTag();
            }
            case 11: {
                return pSDEActionParamBase.getParamTag2();
            }
            case 12: {
                return pSDEActionParamBase.getPSDEActionId();
            }
            case 13: {
                return pSDEActionParamBase.getPSDEActionName();
            }
            case 14: {
                return pSDEActionParamBase.getPSDEActionParamId();
            }
            case 15: {
                return pSDEActionParamBase.getPSDEActionParamName();
            }
            case 16: {
                return pSDEActionParamBase.getPSDEFValueRuleId();
            }
            case 17: {
                return pSDEActionParamBase.getPSDEFValueRuleName();
            }
            case 18: {
                return pSDEActionParamBase.getPSDEId();
            }
            case 19: {
                return pSDEActionParamBase.getPSDynaInstId();
            }
            case 20: {
                return pSDEActionParamBase.getPSSysValueRuleId();
            }
            case 21: {
                return pSDEActionParamBase.getPSSysValueRuleName();
            }
            case 22: {
                return pSDEActionParamBase.getRefPSDEFGroupId();
            }
            case 23: {
                return pSDEActionParamBase.getRefPSDEFGroupName();
            }
            case 24: {
                return pSDEActionParamBase.getRefPSDEId();
            }
            case 25: {
                return pSDEActionParamBase.getRefPSDEName();
            }
            case 26: {
                return pSDEActionParamBase.getRefPSSysDynaModelId();
            }
            case 27: {
                return pSDEActionParamBase.getRefPSSysDynaModelName();
            }
            case 28: {
                return pSDEActionParamBase.getStdDataType();
            }
            case 29: {
                return pSDEActionParamBase.getUpdateDate();
            }
            case 30: {
                return pSDEActionParamBase.getUpdateMan();
            }
            case 31: {
                return pSDEActionParamBase.getUserCat();
            }
            case 32: {
                return pSDEActionParamBase.getUserTag();
            }
            case 33: {
                return pSDEActionParamBase.getUserTag2();
            }
            case 34: {
                return pSDEActionParamBase.getUserTag3();
            }
            case 35: {
                return pSDEActionParamBase.getUserTag4();
            }
            case 36: {
                return pSDEActionParamBase.getValue();
            }
            case 37: {
                return pSDEActionParamBase.getValueDesc();
            }
            case 38: {
                return pSDEActionParamBase.getValueType();
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
        PSDEActionParamBase.set(this, n, object);
    }

    private static void set(PSDEActionParamBase pSDEActionParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionParamBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEActionParamBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDEActionParamBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEActionParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEActionParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEActionParamBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEActionParamBase.setJsonFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEActionParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEActionParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEActionParamBase.setParamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEActionParamBase.setParamTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEActionParamBase.setParamTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEActionParamBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEActionParamBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEActionParamBase.setPSDEActionParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEActionParamBase.setPSDEActionParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEActionParamBase.setPSDEFValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEActionParamBase.setPSDEFValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEActionParamBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEActionParamBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEActionParamBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEActionParamBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEActionParamBase.setRefPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEActionParamBase.setRefPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEActionParamBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEActionParamBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEActionParamBase.setRefPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEActionParamBase.setRefPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEActionParamBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEActionParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSDEActionParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEActionParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEActionParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEActionParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEActionParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEActionParamBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEActionParamBase.setValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEActionParamBase.setValueDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEActionParamBase.setValueType(DataObject.getStringValue((Object)object));
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
        return PSDEActionParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDEActionParamBase pSDEActionParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionParamBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDEActionParamBase.getArrayFlag() == null;
            }
            case 2: {
                return pSDEActionParamBase.getCodeName() == null;
            }
            case 3: {
                return pSDEActionParamBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEActionParamBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEActionParamBase.getDynaModelFlag() == null;
            }
            case 6: {
                return pSDEActionParamBase.getJsonFormat() == null;
            }
            case 7: {
                return pSDEActionParamBase.getMemo() == null;
            }
            case 8: {
                return pSDEActionParamBase.getOrderValue() == null;
            }
            case 9: {
                return pSDEActionParamBase.getParamDesc() == null;
            }
            case 10: {
                return pSDEActionParamBase.getParamTag() == null;
            }
            case 11: {
                return pSDEActionParamBase.getParamTag2() == null;
            }
            case 12: {
                return pSDEActionParamBase.getPSDEActionId() == null;
            }
            case 13: {
                return pSDEActionParamBase.getPSDEActionName() == null;
            }
            case 14: {
                return pSDEActionParamBase.getPSDEActionParamId() == null;
            }
            case 15: {
                return pSDEActionParamBase.getPSDEActionParamName() == null;
            }
            case 16: {
                return pSDEActionParamBase.getPSDEFValueRuleId() == null;
            }
            case 17: {
                return pSDEActionParamBase.getPSDEFValueRuleName() == null;
            }
            case 18: {
                return pSDEActionParamBase.getPSDEId() == null;
            }
            case 19: {
                return pSDEActionParamBase.getPSDynaInstId() == null;
            }
            case 20: {
                return pSDEActionParamBase.getPSSysValueRuleId() == null;
            }
            case 21: {
                return pSDEActionParamBase.getPSSysValueRuleName() == null;
            }
            case 22: {
                return pSDEActionParamBase.getRefPSDEFGroupId() == null;
            }
            case 23: {
                return pSDEActionParamBase.getRefPSDEFGroupName() == null;
            }
            case 24: {
                return pSDEActionParamBase.getRefPSDEId() == null;
            }
            case 25: {
                return pSDEActionParamBase.getRefPSDEName() == null;
            }
            case 26: {
                return pSDEActionParamBase.getRefPSSysDynaModelId() == null;
            }
            case 27: {
                return pSDEActionParamBase.getRefPSSysDynaModelName() == null;
            }
            case 28: {
                return pSDEActionParamBase.getStdDataType() == null;
            }
            case 29: {
                return pSDEActionParamBase.getUpdateDate() == null;
            }
            case 30: {
                return pSDEActionParamBase.getUpdateMan() == null;
            }
            case 31: {
                return pSDEActionParamBase.getUserCat() == null;
            }
            case 32: {
                return pSDEActionParamBase.getUserTag() == null;
            }
            case 33: {
                return pSDEActionParamBase.getUserTag2() == null;
            }
            case 34: {
                return pSDEActionParamBase.getUserTag3() == null;
            }
            case 35: {
                return pSDEActionParamBase.getUserTag4() == null;
            }
            case 36: {
                return pSDEActionParamBase.getValue() == null;
            }
            case 37: {
                return pSDEActionParamBase.getValueDesc() == null;
            }
            case 38: {
                return pSDEActionParamBase.getValueType() == null;
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
        return PSDEActionParamBase.contains(this, n);
    }

    private static boolean contains(PSDEActionParamBase pSDEActionParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionParamBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDEActionParamBase.isArrayFlagDirty();
            }
            case 2: {
                return pSDEActionParamBase.isCodeNameDirty();
            }
            case 3: {
                return pSDEActionParamBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEActionParamBase.isCreateManDirty();
            }
            case 5: {
                return pSDEActionParamBase.isDynaModelFlagDirty();
            }
            case 6: {
                return pSDEActionParamBase.isJsonFormatDirty();
            }
            case 7: {
                return pSDEActionParamBase.isMemoDirty();
            }
            case 8: {
                return pSDEActionParamBase.isOrderValueDirty();
            }
            case 9: {
                return pSDEActionParamBase.isParamDescDirty();
            }
            case 10: {
                return pSDEActionParamBase.isParamTagDirty();
            }
            case 11: {
                return pSDEActionParamBase.isParamTag2Dirty();
            }
            case 12: {
                return pSDEActionParamBase.isPSDEActionIdDirty();
            }
            case 13: {
                return pSDEActionParamBase.isPSDEActionNameDirty();
            }
            case 14: {
                return pSDEActionParamBase.isPSDEActionParamIdDirty();
            }
            case 15: {
                return pSDEActionParamBase.isPSDEActionParamNameDirty();
            }
            case 16: {
                return pSDEActionParamBase.isPSDEFValueRuleIdDirty();
            }
            case 17: {
                return pSDEActionParamBase.isPSDEFValueRuleNameDirty();
            }
            case 18: {
                return pSDEActionParamBase.isPSDEIdDirty();
            }
            case 19: {
                return pSDEActionParamBase.isPSDynaInstIdDirty();
            }
            case 20: {
                return pSDEActionParamBase.isPSSysValueRuleIdDirty();
            }
            case 21: {
                return pSDEActionParamBase.isPSSysValueRuleNameDirty();
            }
            case 22: {
                return pSDEActionParamBase.isRefPSDEFGroupIdDirty();
            }
            case 23: {
                return pSDEActionParamBase.isRefPSDEFGroupNameDirty();
            }
            case 24: {
                return pSDEActionParamBase.isRefPSDEIdDirty();
            }
            case 25: {
                return pSDEActionParamBase.isRefPSDENameDirty();
            }
            case 26: {
                return pSDEActionParamBase.isRefPSSysDynaModelIdDirty();
            }
            case 27: {
                return pSDEActionParamBase.isRefPSSysDynaModelNameDirty();
            }
            case 28: {
                return pSDEActionParamBase.isStdDataTypeDirty();
            }
            case 29: {
                return pSDEActionParamBase.isUpdateDateDirty();
            }
            case 30: {
                return pSDEActionParamBase.isUpdateManDirty();
            }
            case 31: {
                return pSDEActionParamBase.isUserCatDirty();
            }
            case 32: {
                return pSDEActionParamBase.isUserTagDirty();
            }
            case 33: {
                return pSDEActionParamBase.isUserTag2Dirty();
            }
            case 34: {
                return pSDEActionParamBase.isUserTag3Dirty();
            }
            case 35: {
                return pSDEActionParamBase.isUserTag4Dirty();
            }
            case 36: {
                return pSDEActionParamBase.isValueDirty();
            }
            case 37: {
                return pSDEActionParamBase.isValueDescDirty();
            }
            case 38: {
                return pSDEActionParamBase.isValueTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEActionParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEActionParamBase pSDEActionParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEActionParamBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getJsonFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsonformat", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getJsonFormat()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getParamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramdesc", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getParamDesc()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getParamTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getParamTag()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getParamTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag2", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getParamTag2()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSDEActionParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionparamid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSDEActionParamId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSDEActionParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionparamname", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSDEActionParamName()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSDEFValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvalueruleid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSDEFValueRuleId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSDEFValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvaluerulename", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSDEFValueRuleName()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getRefPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdefgroupid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getRefPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getRefPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdefgroupname", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getRefPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getRefPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdynamodelid", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getRefPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getRefPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdynamodelname", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getRefPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getValue()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getValueDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuedesc", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getValueDesc()), (boolean)false);
        }
        if (bl || pSDEActionParamBase.getValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuetype", (Object)PSDEActionParamBase.getJSONValue((Object)pSDEActionParamBase.getValueType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEActionParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEActionParamBase pSDEActionParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEActionParamBase.getAllowEmpty() != null) {
            object = pSDEActionParamBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionParamBase.getArrayFlag() != null) {
            object = pSDEActionParamBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionParamBase.getCodeName() != null) {
            object = pSDEActionParamBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getCreateDate() != null) {
            object = pSDEActionParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionParamBase.getCreateMan() != null) {
            object = pSDEActionParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getDynaModelFlag() != null) {
            object = pSDEActionParamBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionParamBase.getJsonFormat() != null) {
            object = pSDEActionParamBase.getJsonFormat();
            xmlNode.setAttribute(FIELD_JSONFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getMemo() != null) {
            object = pSDEActionParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getOrderValue() != null) {
            object = pSDEActionParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionParamBase.getParamDesc() != null) {
            object = pSDEActionParamBase.getParamDesc();
            xmlNode.setAttribute(FIELD_PARAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getParamTag() != null) {
            object = pSDEActionParamBase.getParamTag();
            xmlNode.setAttribute(FIELD_PARAMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getParamTag2() != null) {
            object = pSDEActionParamBase.getParamTag2();
            xmlNode.setAttribute(FIELD_PARAMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSDEActionId() != null) {
            object = pSDEActionParamBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSDEActionName() != null) {
            object = pSDEActionParamBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSDEActionParamId() != null) {
            object = pSDEActionParamBase.getPSDEActionParamId();
            xmlNode.setAttribute(FIELD_PSDEACTIONPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSDEActionParamName() != null) {
            object = pSDEActionParamBase.getPSDEActionParamName();
            xmlNode.setAttribute(FIELD_PSDEACTIONPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSDEFValueRuleId() != null) {
            object = pSDEActionParamBase.getPSDEFValueRuleId();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSDEFValueRuleName() != null) {
            object = pSDEActionParamBase.getPSDEFValueRuleName();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSDEId() != null) {
            object = pSDEActionParamBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSDynaInstId() != null) {
            object = pSDEActionParamBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSSysValueRuleId() != null) {
            object = pSDEActionParamBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getPSSysValueRuleName() != null) {
            object = pSDEActionParamBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getRefPSDEFGroupId() != null) {
            object = pSDEActionParamBase.getRefPSDEFGroupId();
            xmlNode.setAttribute(FIELD_REFPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getRefPSDEFGroupName() != null) {
            object = pSDEActionParamBase.getRefPSDEFGroupName();
            xmlNode.setAttribute(FIELD_REFPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getRefPSDEId() != null) {
            object = pSDEActionParamBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getRefPSDEName() != null) {
            object = pSDEActionParamBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getRefPSSysDynaModelId() != null) {
            object = pSDEActionParamBase.getRefPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_REFPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getRefPSSysDynaModelName() != null) {
            object = pSDEActionParamBase.getRefPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_REFPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getStdDataType() != null) {
            object = pSDEActionParamBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionParamBase.getUpdateDate() != null) {
            object = pSDEActionParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionParamBase.getUpdateMan() != null) {
            object = pSDEActionParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getUserCat() != null) {
            object = pSDEActionParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getUserTag() != null) {
            object = pSDEActionParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getUserTag2() != null) {
            object = pSDEActionParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getUserTag3() != null) {
            object = pSDEActionParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getUserTag4() != null) {
            object = pSDEActionParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getValue() != null) {
            object = pSDEActionParamBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getValueDesc() != null) {
            object = pSDEActionParamBase.getValueDesc();
            xmlNode.setAttribute(FIELD_VALUEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionParamBase.getValueType() != null) {
            object = pSDEActionParamBase.getValueType();
            xmlNode.setAttribute(FIELD_VALUETYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEActionParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEActionParamBase pSDEActionParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEActionParamBase.isAllowEmptyDirty() && (bl || pSDEActionParamBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDEActionParamBase.getAllowEmpty());
        }
        if (pSDEActionParamBase.isArrayFlagDirty() && (bl || pSDEActionParamBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSDEActionParamBase.getArrayFlag());
        }
        if (pSDEActionParamBase.isCodeNameDirty() && (bl || pSDEActionParamBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEActionParamBase.getCodeName());
        }
        if (pSDEActionParamBase.isCreateDateDirty() && (bl || pSDEActionParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEActionParamBase.getCreateDate());
        }
        if (pSDEActionParamBase.isCreateManDirty() && (bl || pSDEActionParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEActionParamBase.getCreateMan());
        }
        if (pSDEActionParamBase.isDynaModelFlagDirty() && (bl || pSDEActionParamBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEActionParamBase.getDynaModelFlag());
        }
        if (pSDEActionParamBase.isJsonFormatDirty() && (bl || pSDEActionParamBase.getJsonFormat() != null)) {
            iDataObject.set(FIELD_JSONFORMAT, (Object)pSDEActionParamBase.getJsonFormat());
        }
        if (pSDEActionParamBase.isMemoDirty() && (bl || pSDEActionParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEActionParamBase.getMemo());
        }
        if (pSDEActionParamBase.isOrderValueDirty() && (bl || pSDEActionParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEActionParamBase.getOrderValue());
        }
        if (pSDEActionParamBase.isParamDescDirty() && (bl || pSDEActionParamBase.getParamDesc() != null)) {
            iDataObject.set(FIELD_PARAMDESC, (Object)pSDEActionParamBase.getParamDesc());
        }
        if (pSDEActionParamBase.isParamTagDirty() && (bl || pSDEActionParamBase.getParamTag() != null)) {
            iDataObject.set(FIELD_PARAMTAG, (Object)pSDEActionParamBase.getParamTag());
        }
        if (pSDEActionParamBase.isParamTag2Dirty() && (bl || pSDEActionParamBase.getParamTag2() != null)) {
            iDataObject.set(FIELD_PARAMTAG2, (Object)pSDEActionParamBase.getParamTag2());
        }
        if (pSDEActionParamBase.isPSDEActionIdDirty() && (bl || pSDEActionParamBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEActionParamBase.getPSDEActionId());
        }
        if (pSDEActionParamBase.isPSDEActionNameDirty() && (bl || pSDEActionParamBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEActionParamBase.getPSDEActionName());
        }
        if (pSDEActionParamBase.isPSDEActionParamIdDirty() && (bl || pSDEActionParamBase.getPSDEActionParamId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONPARAMID, (Object)pSDEActionParamBase.getPSDEActionParamId());
        }
        if (pSDEActionParamBase.isPSDEActionParamNameDirty() && (bl || pSDEActionParamBase.getPSDEActionParamName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONPARAMNAME, (Object)pSDEActionParamBase.getPSDEActionParamName());
        }
        if (pSDEActionParamBase.isPSDEFValueRuleIdDirty() && (bl || pSDEActionParamBase.getPSDEFValueRuleId() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULEID, (Object)pSDEActionParamBase.getPSDEFValueRuleId());
        }
        if (pSDEActionParamBase.isPSDEFValueRuleNameDirty() && (bl || pSDEActionParamBase.getPSDEFValueRuleName() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULENAME, (Object)pSDEActionParamBase.getPSDEFValueRuleName());
        }
        if (pSDEActionParamBase.isPSDEIdDirty() && (bl || pSDEActionParamBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEActionParamBase.getPSDEId());
        }
        if (pSDEActionParamBase.isPSDynaInstIdDirty() && (bl || pSDEActionParamBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEActionParamBase.getPSDynaInstId());
        }
        if (pSDEActionParamBase.isPSSysValueRuleIdDirty() && (bl || pSDEActionParamBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEActionParamBase.getPSSysValueRuleId());
        }
        if (pSDEActionParamBase.isPSSysValueRuleNameDirty() && (bl || pSDEActionParamBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEActionParamBase.getPSSysValueRuleName());
        }
        if (pSDEActionParamBase.isRefPSDEFGroupIdDirty() && (bl || pSDEActionParamBase.getRefPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_REFPSDEFGROUPID, (Object)pSDEActionParamBase.getRefPSDEFGroupId());
        }
        if (pSDEActionParamBase.isRefPSDEFGroupNameDirty() && (bl || pSDEActionParamBase.getRefPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_REFPSDEFGROUPNAME, (Object)pSDEActionParamBase.getRefPSDEFGroupName());
        }
        if (pSDEActionParamBase.isRefPSDEIdDirty() && (bl || pSDEActionParamBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSDEActionParamBase.getRefPSDEId());
        }
        if (pSDEActionParamBase.isRefPSDENameDirty() && (bl || pSDEActionParamBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSDEActionParamBase.getRefPSDEName());
        }
        if (pSDEActionParamBase.isRefPSSysDynaModelIdDirty() && (bl || pSDEActionParamBase.getRefPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_REFPSSYSDYNAMODELID, (Object)pSDEActionParamBase.getRefPSSysDynaModelId());
        }
        if (pSDEActionParamBase.isRefPSSysDynaModelNameDirty() && (bl || pSDEActionParamBase.getRefPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_REFPSSYSDYNAMODELNAME, (Object)pSDEActionParamBase.getRefPSSysDynaModelName());
        }
        if (pSDEActionParamBase.isStdDataTypeDirty() && (bl || pSDEActionParamBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSDEActionParamBase.getStdDataType());
        }
        if (pSDEActionParamBase.isUpdateDateDirty() && (bl || pSDEActionParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEActionParamBase.getUpdateDate());
        }
        if (pSDEActionParamBase.isUpdateManDirty() && (bl || pSDEActionParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEActionParamBase.getUpdateMan());
        }
        if (pSDEActionParamBase.isUserCatDirty() && (bl || pSDEActionParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEActionParamBase.getUserCat());
        }
        if (pSDEActionParamBase.isUserTagDirty() && (bl || pSDEActionParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEActionParamBase.getUserTag());
        }
        if (pSDEActionParamBase.isUserTag2Dirty() && (bl || pSDEActionParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEActionParamBase.getUserTag2());
        }
        if (pSDEActionParamBase.isUserTag3Dirty() && (bl || pSDEActionParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEActionParamBase.getUserTag3());
        }
        if (pSDEActionParamBase.isUserTag4Dirty() && (bl || pSDEActionParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEActionParamBase.getUserTag4());
        }
        if (pSDEActionParamBase.isValueDirty() && (bl || pSDEActionParamBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSDEActionParamBase.getValue());
        }
        if (pSDEActionParamBase.isValueDescDirty() && (bl || pSDEActionParamBase.getValueDesc() != null)) {
            iDataObject.set(FIELD_VALUEDESC, (Object)pSDEActionParamBase.getValueDesc());
        }
        if (pSDEActionParamBase.isValueTypeDirty() && (bl || pSDEActionParamBase.getValueType() != null)) {
            iDataObject.set(FIELD_VALUETYPE, (Object)pSDEActionParamBase.getValueType());
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
        return PSDEActionParamBase.remove(this, n);
    }

    private static boolean remove(PSDEActionParamBase pSDEActionParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionParamBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDEActionParamBase.resetArrayFlag();
                return true;
            }
            case 2: {
                pSDEActionParamBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDEActionParamBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEActionParamBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEActionParamBase.resetDynaModelFlag();
                return true;
            }
            case 6: {
                pSDEActionParamBase.resetJsonFormat();
                return true;
            }
            case 7: {
                pSDEActionParamBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEActionParamBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSDEActionParamBase.resetParamDesc();
                return true;
            }
            case 10: {
                pSDEActionParamBase.resetParamTag();
                return true;
            }
            case 11: {
                pSDEActionParamBase.resetParamTag2();
                return true;
            }
            case 12: {
                pSDEActionParamBase.resetPSDEActionId();
                return true;
            }
            case 13: {
                pSDEActionParamBase.resetPSDEActionName();
                return true;
            }
            case 14: {
                pSDEActionParamBase.resetPSDEActionParamId();
                return true;
            }
            case 15: {
                pSDEActionParamBase.resetPSDEActionParamName();
                return true;
            }
            case 16: {
                pSDEActionParamBase.resetPSDEFValueRuleId();
                return true;
            }
            case 17: {
                pSDEActionParamBase.resetPSDEFValueRuleName();
                return true;
            }
            case 18: {
                pSDEActionParamBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSDEActionParamBase.resetPSDynaInstId();
                return true;
            }
            case 20: {
                pSDEActionParamBase.resetPSSysValueRuleId();
                return true;
            }
            case 21: {
                pSDEActionParamBase.resetPSSysValueRuleName();
                return true;
            }
            case 22: {
                pSDEActionParamBase.resetRefPSDEFGroupId();
                return true;
            }
            case 23: {
                pSDEActionParamBase.resetRefPSDEFGroupName();
                return true;
            }
            case 24: {
                pSDEActionParamBase.resetRefPSDEId();
                return true;
            }
            case 25: {
                pSDEActionParamBase.resetRefPSDEName();
                return true;
            }
            case 26: {
                pSDEActionParamBase.resetRefPSSysDynaModelId();
                return true;
            }
            case 27: {
                pSDEActionParamBase.resetRefPSSysDynaModelName();
                return true;
            }
            case 28: {
                pSDEActionParamBase.resetStdDataType();
                return true;
            }
            case 29: {
                pSDEActionParamBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSDEActionParamBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSDEActionParamBase.resetUserCat();
                return true;
            }
            case 32: {
                pSDEActionParamBase.resetUserTag();
                return true;
            }
            case 33: {
                pSDEActionParamBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSDEActionParamBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSDEActionParamBase.resetUserTag4();
                return true;
            }
            case 36: {
                pSDEActionParamBase.resetValue();
                return true;
            }
            case 37: {
                pSDEActionParamBase.resetValueDesc();
                return true;
            }
            case 38: {
                pSDEActionParamBase.resetValueType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
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
    public PSDEFValueRule getPSDEFValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRule();
        }
        if (this.getPSDEFValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSDEFValueRuleLock;
        synchronized (n) {
            if (this.psdefvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFValueRuleId(), (Object)this.psdefvaluerule.getPSDEFValueRuleId()) != 0L) {
                this.psdefvaluerule = null;
            }
            if (this.psdefvaluerule == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFValueRuleId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet((IEntity)pSDEFValueRule);
                this.psdefvaluerule = pSDEFValueRule;
            }
            return this.psdefvaluerule;
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

    private PSDEActionParamBase getProxyEntity() {
        return this.proxyPSDEActionParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEActionParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEActionParamBase) {
            this.proxyPSDEActionParamBase = (PSDEActionParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_ARRAYFLAG, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 5);
        fieldIndexMap.put(FIELD_JSONFORMAT, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PARAMDESC, 9);
        fieldIndexMap.put(FIELD_PARAMTAG, 10);
        fieldIndexMap.put(FIELD_PARAMTAG2, 11);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 12);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 13);
        fieldIndexMap.put(FIELD_PSDEACTIONPARAMID, 14);
        fieldIndexMap.put(FIELD_PSDEACTIONPARAMNAME, 15);
        fieldIndexMap.put(FIELD_PSDEFVALUERULEID, 16);
        fieldIndexMap.put(FIELD_PSDEFVALUERULENAME, 17);
        fieldIndexMap.put(FIELD_PSDEID, 18);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 19);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 20);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 21);
        fieldIndexMap.put(FIELD_REFPSDEFGROUPID, 22);
        fieldIndexMap.put(FIELD_REFPSDEFGROUPNAME, 23);
        fieldIndexMap.put(FIELD_REFPSDEID, 24);
        fieldIndexMap.put(FIELD_REFPSDENAME, 25);
        fieldIndexMap.put(FIELD_REFPSSYSDYNAMODELID, 26);
        fieldIndexMap.put(FIELD_REFPSSYSDYNAMODELNAME, 27);
        fieldIndexMap.put(FIELD_STDDATATYPE, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USERCAT, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
        fieldIndexMap.put(FIELD_VALUE, 36);
        fieldIndexMap.put(FIELD_VALUEDESC, 37);
        fieldIndexMap.put(FIELD_VALUETYPE, 38);
    }
}

