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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDSParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDSParamBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_JSONFORMAT = "JSONFORMAT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMDESC = "PARAMDESC";
    public static final String FIELD_PARAMTAG = "PARAMTAG";
    public static final String FIELD_PARAMTAG2 = "PARAMTAG2";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEDSPARAMID = "PSDEDSPARAMID";
    public static final String FIELD_PSDEDSPARAMNAME = "PSDEDSPARAMNAME";
    public static final String FIELD_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String FIELD_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String FIELD_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String FIELD_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
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
    private static final int INDEX_JSONFORMAT = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PARAMDESC = 8;
    private static final int INDEX_PARAMTAG = 9;
    private static final int INDEX_PARAMTAG2 = 10;
    private static final int INDEX_PSDEDSID = 11;
    private static final int INDEX_PSDEDSNAME = 12;
    private static final int INDEX_PSDEDSPARAMID = 13;
    private static final int INDEX_PSDEDSPARAMNAME = 14;
    private static final int INDEX_PSDEFSFITEMID = 15;
    private static final int INDEX_PSDEFSFITEMNAME = 16;
    private static final int INDEX_PSDEFVALUERULEID = 17;
    private static final int INDEX_PSDEFVALUERULENAME = 18;
    private static final int INDEX_PSDEID = 19;
    private static final int INDEX_PSSYSVALUERULEID = 20;
    private static final int INDEX_PSSYSVALUERULENAME = 21;
    private static final int INDEX_STDDATATYPE = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final int INDEX_VALUE = 30;
    private static final int INDEX_VALUEDESC = 31;
    private static final int INDEX_VALUETYPE = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDSParamBase proxyPSDEDSParamBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean arrayflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean jsonformatDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramdescDirtyFlag = false;
    private boolean paramtagDirtyFlag = false;
    private boolean paramtag2DirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdedsparamidDirtyFlag = false;
    private boolean psdedsparamnameDirtyFlag = false;
    private boolean psdefsfitemidDirtyFlag = false;
    private boolean psdefsfitemnameDirtyFlag = false;
    private boolean psdefvalueruleidDirtyFlag = false;
    private boolean psdefvaluerulenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
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
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdedsparamid")
    private String psdedsparamid;
    @Column(name="psdedsparamname")
    private String psdedsparamname;
    @Column(name="psdefsfitemid")
    private String psdefsfitemid;
    @Column(name="psdefsfitemname")
    private String psdefsfitemname;
    @Column(name="psdefvalueruleid")
    private String psdefvalueruleid;
    @Column(name="psdefvaluerulename")
    private String psdefvaluerulename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
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
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objPSDEFSFItemLock = new Integer(1);
    private PSDEFSFItem psdefsfitem = null;
    private Integer objPSDEFValueRuleLock = new Integer(1);
    private PSDEFValueRule psdefvaluerule = null;
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

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
    }

    public void setPSDEDSParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsparamid = string;
        this.psdedsparamidDirtyFlag = true;
    }

    public String getPSDEDSParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSParamId();
        }
        return this.psdedsparamid;
    }

    public boolean isPSDEDSParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSParamIdDirty();
        }
        return this.psdedsparamidDirtyFlag;
    }

    public void resetPSDEDSParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSParamId();
            return;
        }
        this.psdedsparamidDirtyFlag = false;
        this.psdedsparamid = null;
    }

    public void setPSDEDSParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsparamname = string;
        this.psdedsparamnameDirtyFlag = true;
    }

    public String getPSDEDSParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSParamName();
        }
        return this.psdedsparamname;
    }

    public boolean isPSDEDSParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSParamNameDirty();
        }
        return this.psdedsparamnameDirtyFlag;
    }

    public void resetPSDEDSParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSParamName();
            return;
        }
        this.psdedsparamnameDirtyFlag = false;
        this.psdedsparamname = null;
    }

    public void setPSDEFSFItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFSFItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefsfitemid = string;
        this.psdefsfitemidDirtyFlag = true;
    }

    public String getPSDEFSFItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItemId();
        }
        return this.psdefsfitemid;
    }

    public boolean isPSDEFSFItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFSFItemIdDirty();
        }
        return this.psdefsfitemidDirtyFlag;
    }

    public void resetPSDEFSFItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFSFItemId();
            return;
        }
        this.psdefsfitemidDirtyFlag = false;
        this.psdefsfitemid = null;
    }

    public void setPSDEFSFItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFSFItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefsfitemname = string;
        this.psdefsfitemnameDirtyFlag = true;
    }

    public String getPSDEFSFItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItemName();
        }
        return this.psdefsfitemname;
    }

    public boolean isPSDEFSFItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFSFItemNameDirty();
        }
        return this.psdefsfitemnameDirtyFlag;
    }

    public void resetPSDEFSFItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFSFItemName();
            return;
        }
        this.psdefsfitemnameDirtyFlag = false;
        this.psdefsfitemname = null;
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
        PSDEDSParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDSParamBase pSDEDSParamBase) {
        pSDEDSParamBase.resetAllowEmpty();
        pSDEDSParamBase.resetArrayFlag();
        pSDEDSParamBase.resetCodeName();
        pSDEDSParamBase.resetCreateDate();
        pSDEDSParamBase.resetCreateMan();
        pSDEDSParamBase.resetJsonFormat();
        pSDEDSParamBase.resetMemo();
        pSDEDSParamBase.resetOrderValue();
        pSDEDSParamBase.resetParamDesc();
        pSDEDSParamBase.resetParamTag();
        pSDEDSParamBase.resetParamTag2();
        pSDEDSParamBase.resetPSDEDSId();
        pSDEDSParamBase.resetPSDEDSName();
        pSDEDSParamBase.resetPSDEDSParamId();
        pSDEDSParamBase.resetPSDEDSParamName();
        pSDEDSParamBase.resetPSDEFSFItemId();
        pSDEDSParamBase.resetPSDEFSFItemName();
        pSDEDSParamBase.resetPSDEFValueRuleId();
        pSDEDSParamBase.resetPSDEFValueRuleName();
        pSDEDSParamBase.resetPSDEId();
        pSDEDSParamBase.resetPSSysValueRuleId();
        pSDEDSParamBase.resetPSSysValueRuleName();
        pSDEDSParamBase.resetStdDataType();
        pSDEDSParamBase.resetUpdateDate();
        pSDEDSParamBase.resetUpdateMan();
        pSDEDSParamBase.resetUserCat();
        pSDEDSParamBase.resetUserTag();
        pSDEDSParamBase.resetUserTag2();
        pSDEDSParamBase.resetUserTag3();
        pSDEDSParamBase.resetUserTag4();
        pSDEDSParamBase.resetValue();
        pSDEDSParamBase.resetValueDesc();
        pSDEDSParamBase.resetValueType();
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
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEDSParamIdDirty()) {
            hashMap.put(FIELD_PSDEDSPARAMID, this.getPSDEDSParamId());
        }
        if (!bl || this.isPSDEDSParamNameDirty()) {
            hashMap.put(FIELD_PSDEDSPARAMNAME, this.getPSDEDSParamName());
        }
        if (!bl || this.isPSDEFSFItemIdDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMID, this.getPSDEFSFItemId());
        }
        if (!bl || this.isPSDEFSFItemNameDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMNAME, this.getPSDEFSFItemName());
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
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
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
        return PSDEDSParamBase.get(this, n);
    }

    private static Object get(PSDEDSParamBase pSDEDSParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSParamBase.getAllowEmpty();
            }
            case 1: {
                return pSDEDSParamBase.getArrayFlag();
            }
            case 2: {
                return pSDEDSParamBase.getCodeName();
            }
            case 3: {
                return pSDEDSParamBase.getCreateDate();
            }
            case 4: {
                return pSDEDSParamBase.getCreateMan();
            }
            case 5: {
                return pSDEDSParamBase.getJsonFormat();
            }
            case 6: {
                return pSDEDSParamBase.getMemo();
            }
            case 7: {
                return pSDEDSParamBase.getOrderValue();
            }
            case 8: {
                return pSDEDSParamBase.getParamDesc();
            }
            case 9: {
                return pSDEDSParamBase.getParamTag();
            }
            case 10: {
                return pSDEDSParamBase.getParamTag2();
            }
            case 11: {
                return pSDEDSParamBase.getPSDEDSId();
            }
            case 12: {
                return pSDEDSParamBase.getPSDEDSName();
            }
            case 13: {
                return pSDEDSParamBase.getPSDEDSParamId();
            }
            case 14: {
                return pSDEDSParamBase.getPSDEDSParamName();
            }
            case 15: {
                return pSDEDSParamBase.getPSDEFSFItemId();
            }
            case 16: {
                return pSDEDSParamBase.getPSDEFSFItemName();
            }
            case 17: {
                return pSDEDSParamBase.getPSDEFValueRuleId();
            }
            case 18: {
                return pSDEDSParamBase.getPSDEFValueRuleName();
            }
            case 19: {
                return pSDEDSParamBase.getPSDEId();
            }
            case 20: {
                return pSDEDSParamBase.getPSSysValueRuleId();
            }
            case 21: {
                return pSDEDSParamBase.getPSSysValueRuleName();
            }
            case 22: {
                return pSDEDSParamBase.getStdDataType();
            }
            case 23: {
                return pSDEDSParamBase.getUpdateDate();
            }
            case 24: {
                return pSDEDSParamBase.getUpdateMan();
            }
            case 25: {
                return pSDEDSParamBase.getUserCat();
            }
            case 26: {
                return pSDEDSParamBase.getUserTag();
            }
            case 27: {
                return pSDEDSParamBase.getUserTag2();
            }
            case 28: {
                return pSDEDSParamBase.getUserTag3();
            }
            case 29: {
                return pSDEDSParamBase.getUserTag4();
            }
            case 30: {
                return pSDEDSParamBase.getValue();
            }
            case 31: {
                return pSDEDSParamBase.getValueDesc();
            }
            case 32: {
                return pSDEDSParamBase.getValueType();
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
        PSDEDSParamBase.set(this, n, object);
    }

    private static void set(PSDEDSParamBase pSDEDSParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDSParamBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEDSParamBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDEDSParamBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDSParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEDSParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDSParamBase.setJsonFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDSParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDSParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEDSParamBase.setParamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDSParamBase.setParamTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDSParamBase.setParamTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDSParamBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDSParamBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDSParamBase.setPSDEDSParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDSParamBase.setPSDEDSParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDSParamBase.setPSDEFSFItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDSParamBase.setPSDEFSFItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDSParamBase.setPSDEFValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDSParamBase.setPSDEFValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDSParamBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDSParamBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDSParamBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDSParamBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEDSParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDEDSParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDSParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDSParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDSParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDSParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDSParamBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDSParamBase.setValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDSParamBase.setValueDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDSParamBase.setValueType(DataObject.getStringValue((Object)object));
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
        return PSDEDSParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDSParamBase pSDEDSParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSParamBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDEDSParamBase.getArrayFlag() == null;
            }
            case 2: {
                return pSDEDSParamBase.getCodeName() == null;
            }
            case 3: {
                return pSDEDSParamBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEDSParamBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEDSParamBase.getJsonFormat() == null;
            }
            case 6: {
                return pSDEDSParamBase.getMemo() == null;
            }
            case 7: {
                return pSDEDSParamBase.getOrderValue() == null;
            }
            case 8: {
                return pSDEDSParamBase.getParamDesc() == null;
            }
            case 9: {
                return pSDEDSParamBase.getParamTag() == null;
            }
            case 10: {
                return pSDEDSParamBase.getParamTag2() == null;
            }
            case 11: {
                return pSDEDSParamBase.getPSDEDSId() == null;
            }
            case 12: {
                return pSDEDSParamBase.getPSDEDSName() == null;
            }
            case 13: {
                return pSDEDSParamBase.getPSDEDSParamId() == null;
            }
            case 14: {
                return pSDEDSParamBase.getPSDEDSParamName() == null;
            }
            case 15: {
                return pSDEDSParamBase.getPSDEFSFItemId() == null;
            }
            case 16: {
                return pSDEDSParamBase.getPSDEFSFItemName() == null;
            }
            case 17: {
                return pSDEDSParamBase.getPSDEFValueRuleId() == null;
            }
            case 18: {
                return pSDEDSParamBase.getPSDEFValueRuleName() == null;
            }
            case 19: {
                return pSDEDSParamBase.getPSDEId() == null;
            }
            case 20: {
                return pSDEDSParamBase.getPSSysValueRuleId() == null;
            }
            case 21: {
                return pSDEDSParamBase.getPSSysValueRuleName() == null;
            }
            case 22: {
                return pSDEDSParamBase.getStdDataType() == null;
            }
            case 23: {
                return pSDEDSParamBase.getUpdateDate() == null;
            }
            case 24: {
                return pSDEDSParamBase.getUpdateMan() == null;
            }
            case 25: {
                return pSDEDSParamBase.getUserCat() == null;
            }
            case 26: {
                return pSDEDSParamBase.getUserTag() == null;
            }
            case 27: {
                return pSDEDSParamBase.getUserTag2() == null;
            }
            case 28: {
                return pSDEDSParamBase.getUserTag3() == null;
            }
            case 29: {
                return pSDEDSParamBase.getUserTag4() == null;
            }
            case 30: {
                return pSDEDSParamBase.getValue() == null;
            }
            case 31: {
                return pSDEDSParamBase.getValueDesc() == null;
            }
            case 32: {
                return pSDEDSParamBase.getValueType() == null;
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
        return PSDEDSParamBase.contains(this, n);
    }

    private static boolean contains(PSDEDSParamBase pSDEDSParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSParamBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDEDSParamBase.isArrayFlagDirty();
            }
            case 2: {
                return pSDEDSParamBase.isCodeNameDirty();
            }
            case 3: {
                return pSDEDSParamBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEDSParamBase.isCreateManDirty();
            }
            case 5: {
                return pSDEDSParamBase.isJsonFormatDirty();
            }
            case 6: {
                return pSDEDSParamBase.isMemoDirty();
            }
            case 7: {
                return pSDEDSParamBase.isOrderValueDirty();
            }
            case 8: {
                return pSDEDSParamBase.isParamDescDirty();
            }
            case 9: {
                return pSDEDSParamBase.isParamTagDirty();
            }
            case 10: {
                return pSDEDSParamBase.isParamTag2Dirty();
            }
            case 11: {
                return pSDEDSParamBase.isPSDEDSIdDirty();
            }
            case 12: {
                return pSDEDSParamBase.isPSDEDSNameDirty();
            }
            case 13: {
                return pSDEDSParamBase.isPSDEDSParamIdDirty();
            }
            case 14: {
                return pSDEDSParamBase.isPSDEDSParamNameDirty();
            }
            case 15: {
                return pSDEDSParamBase.isPSDEFSFItemIdDirty();
            }
            case 16: {
                return pSDEDSParamBase.isPSDEFSFItemNameDirty();
            }
            case 17: {
                return pSDEDSParamBase.isPSDEFValueRuleIdDirty();
            }
            case 18: {
                return pSDEDSParamBase.isPSDEFValueRuleNameDirty();
            }
            case 19: {
                return pSDEDSParamBase.isPSDEIdDirty();
            }
            case 20: {
                return pSDEDSParamBase.isPSSysValueRuleIdDirty();
            }
            case 21: {
                return pSDEDSParamBase.isPSSysValueRuleNameDirty();
            }
            case 22: {
                return pSDEDSParamBase.isStdDataTypeDirty();
            }
            case 23: {
                return pSDEDSParamBase.isUpdateDateDirty();
            }
            case 24: {
                return pSDEDSParamBase.isUpdateManDirty();
            }
            case 25: {
                return pSDEDSParamBase.isUserCatDirty();
            }
            case 26: {
                return pSDEDSParamBase.isUserTagDirty();
            }
            case 27: {
                return pSDEDSParamBase.isUserTag2Dirty();
            }
            case 28: {
                return pSDEDSParamBase.isUserTag3Dirty();
            }
            case 29: {
                return pSDEDSParamBase.isUserTag4Dirty();
            }
            case 30: {
                return pSDEDSParamBase.isValueDirty();
            }
            case 31: {
                return pSDEDSParamBase.isValueDescDirty();
            }
            case 32: {
                return pSDEDSParamBase.isValueTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDSParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDSParamBase pSDEDSParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDSParamBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getJsonFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsonformat", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getJsonFormat()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getParamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramdesc", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getParamDesc()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getParamTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getParamTag()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getParamTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag2", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getParamTag2()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEDSParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsparamid", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEDSParamId()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEDSParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsparamname", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEDSParamName()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEFSFItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemid", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEFSFItemId()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEFSFItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemname", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEFSFItemName()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEFValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvalueruleid", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEFValueRuleId()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEFValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvaluerulename", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEFValueRuleName()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getValue()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getValueDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuedesc", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getValueDesc()), (boolean)false);
        }
        if (bl || pSDEDSParamBase.getValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuetype", (Object)PSDEDSParamBase.getJSONValue((Object)pSDEDSParamBase.getValueType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDSParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDSParamBase pSDEDSParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDSParamBase.getAllowEmpty() != null) {
            object = pSDEDSParamBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSParamBase.getArrayFlag() != null) {
            object = pSDEDSParamBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSParamBase.getCodeName() != null) {
            object = pSDEDSParamBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getCreateDate() != null) {
            object = pSDEDSParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDSParamBase.getCreateMan() != null) {
            object = pSDEDSParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getJsonFormat() != null) {
            object = pSDEDSParamBase.getJsonFormat();
            xmlNode.setAttribute(FIELD_JSONFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getMemo() != null) {
            object = pSDEDSParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getOrderValue() != null) {
            object = pSDEDSParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSParamBase.getParamDesc() != null) {
            object = pSDEDSParamBase.getParamDesc();
            xmlNode.setAttribute(FIELD_PARAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getParamTag() != null) {
            object = pSDEDSParamBase.getParamTag();
            xmlNode.setAttribute(FIELD_PARAMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getParamTag2() != null) {
            object = pSDEDSParamBase.getParamTag2();
            xmlNode.setAttribute(FIELD_PARAMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEDSId() != null) {
            object = pSDEDSParamBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEDSName() != null) {
            object = pSDEDSParamBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEDSParamId() != null) {
            object = pSDEDSParamBase.getPSDEDSParamId();
            xmlNode.setAttribute(FIELD_PSDEDSPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEDSParamName() != null) {
            object = pSDEDSParamBase.getPSDEDSParamName();
            xmlNode.setAttribute(FIELD_PSDEDSPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEFSFItemId() != null) {
            object = pSDEDSParamBase.getPSDEFSFItemId();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEFSFItemName() != null) {
            object = pSDEDSParamBase.getPSDEFSFItemName();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEFValueRuleId() != null) {
            object = pSDEDSParamBase.getPSDEFValueRuleId();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEFValueRuleName() != null) {
            object = pSDEDSParamBase.getPSDEFValueRuleName();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSDEId() != null) {
            object = pSDEDSParamBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSSysValueRuleId() != null) {
            object = pSDEDSParamBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getPSSysValueRuleName() != null) {
            object = pSDEDSParamBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getStdDataType() != null) {
            object = pSDEDSParamBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSParamBase.getUpdateDate() != null) {
            object = pSDEDSParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDSParamBase.getUpdateMan() != null) {
            object = pSDEDSParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getUserCat() != null) {
            object = pSDEDSParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getUserTag() != null) {
            object = pSDEDSParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getUserTag2() != null) {
            object = pSDEDSParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getUserTag3() != null) {
            object = pSDEDSParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getUserTag4() != null) {
            object = pSDEDSParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getValue() != null) {
            object = pSDEDSParamBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getValueDesc() != null) {
            object = pSDEDSParamBase.getValueDesc();
            xmlNode.setAttribute(FIELD_VALUEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSParamBase.getValueType() != null) {
            object = pSDEDSParamBase.getValueType();
            xmlNode.setAttribute(FIELD_VALUETYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDSParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDSParamBase pSDEDSParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDSParamBase.isAllowEmptyDirty() && (bl || pSDEDSParamBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDEDSParamBase.getAllowEmpty());
        }
        if (pSDEDSParamBase.isArrayFlagDirty() && (bl || pSDEDSParamBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSDEDSParamBase.getArrayFlag());
        }
        if (pSDEDSParamBase.isCodeNameDirty() && (bl || pSDEDSParamBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDSParamBase.getCodeName());
        }
        if (pSDEDSParamBase.isCreateDateDirty() && (bl || pSDEDSParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDSParamBase.getCreateDate());
        }
        if (pSDEDSParamBase.isCreateManDirty() && (bl || pSDEDSParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDSParamBase.getCreateMan());
        }
        if (pSDEDSParamBase.isJsonFormatDirty() && (bl || pSDEDSParamBase.getJsonFormat() != null)) {
            iDataObject.set(FIELD_JSONFORMAT, (Object)pSDEDSParamBase.getJsonFormat());
        }
        if (pSDEDSParamBase.isMemoDirty() && (bl || pSDEDSParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDSParamBase.getMemo());
        }
        if (pSDEDSParamBase.isOrderValueDirty() && (bl || pSDEDSParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDSParamBase.getOrderValue());
        }
        if (pSDEDSParamBase.isParamDescDirty() && (bl || pSDEDSParamBase.getParamDesc() != null)) {
            iDataObject.set(FIELD_PARAMDESC, (Object)pSDEDSParamBase.getParamDesc());
        }
        if (pSDEDSParamBase.isParamTagDirty() && (bl || pSDEDSParamBase.getParamTag() != null)) {
            iDataObject.set(FIELD_PARAMTAG, (Object)pSDEDSParamBase.getParamTag());
        }
        if (pSDEDSParamBase.isParamTag2Dirty() && (bl || pSDEDSParamBase.getParamTag2() != null)) {
            iDataObject.set(FIELD_PARAMTAG2, (Object)pSDEDSParamBase.getParamTag2());
        }
        if (pSDEDSParamBase.isPSDEDSIdDirty() && (bl || pSDEDSParamBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDEDSParamBase.getPSDEDSId());
        }
        if (pSDEDSParamBase.isPSDEDSNameDirty() && (bl || pSDEDSParamBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDEDSParamBase.getPSDEDSName());
        }
        if (pSDEDSParamBase.isPSDEDSParamIdDirty() && (bl || pSDEDSParamBase.getPSDEDSParamId() != null)) {
            iDataObject.set(FIELD_PSDEDSPARAMID, (Object)pSDEDSParamBase.getPSDEDSParamId());
        }
        if (pSDEDSParamBase.isPSDEDSParamNameDirty() && (bl || pSDEDSParamBase.getPSDEDSParamName() != null)) {
            iDataObject.set(FIELD_PSDEDSPARAMNAME, (Object)pSDEDSParamBase.getPSDEDSParamName());
        }
        if (pSDEDSParamBase.isPSDEFSFItemIdDirty() && (bl || pSDEDSParamBase.getPSDEFSFItemId() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMID, (Object)pSDEDSParamBase.getPSDEFSFItemId());
        }
        if (pSDEDSParamBase.isPSDEFSFItemNameDirty() && (bl || pSDEDSParamBase.getPSDEFSFItemName() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMNAME, (Object)pSDEDSParamBase.getPSDEFSFItemName());
        }
        if (pSDEDSParamBase.isPSDEFValueRuleIdDirty() && (bl || pSDEDSParamBase.getPSDEFValueRuleId() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULEID, (Object)pSDEDSParamBase.getPSDEFValueRuleId());
        }
        if (pSDEDSParamBase.isPSDEFValueRuleNameDirty() && (bl || pSDEDSParamBase.getPSDEFValueRuleName() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULENAME, (Object)pSDEDSParamBase.getPSDEFValueRuleName());
        }
        if (pSDEDSParamBase.isPSDEIdDirty() && (bl || pSDEDSParamBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDSParamBase.getPSDEId());
        }
        if (pSDEDSParamBase.isPSSysValueRuleIdDirty() && (bl || pSDEDSParamBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEDSParamBase.getPSSysValueRuleId());
        }
        if (pSDEDSParamBase.isPSSysValueRuleNameDirty() && (bl || pSDEDSParamBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEDSParamBase.getPSSysValueRuleName());
        }
        if (pSDEDSParamBase.isStdDataTypeDirty() && (bl || pSDEDSParamBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSDEDSParamBase.getStdDataType());
        }
        if (pSDEDSParamBase.isUpdateDateDirty() && (bl || pSDEDSParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDSParamBase.getUpdateDate());
        }
        if (pSDEDSParamBase.isUpdateManDirty() && (bl || pSDEDSParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDSParamBase.getUpdateMan());
        }
        if (pSDEDSParamBase.isUserCatDirty() && (bl || pSDEDSParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDSParamBase.getUserCat());
        }
        if (pSDEDSParamBase.isUserTagDirty() && (bl || pSDEDSParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDSParamBase.getUserTag());
        }
        if (pSDEDSParamBase.isUserTag2Dirty() && (bl || pSDEDSParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDSParamBase.getUserTag2());
        }
        if (pSDEDSParamBase.isUserTag3Dirty() && (bl || pSDEDSParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDSParamBase.getUserTag3());
        }
        if (pSDEDSParamBase.isUserTag4Dirty() && (bl || pSDEDSParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDSParamBase.getUserTag4());
        }
        if (pSDEDSParamBase.isValueDirty() && (bl || pSDEDSParamBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSDEDSParamBase.getValue());
        }
        if (pSDEDSParamBase.isValueDescDirty() && (bl || pSDEDSParamBase.getValueDesc() != null)) {
            iDataObject.set(FIELD_VALUEDESC, (Object)pSDEDSParamBase.getValueDesc());
        }
        if (pSDEDSParamBase.isValueTypeDirty() && (bl || pSDEDSParamBase.getValueType() != null)) {
            iDataObject.set(FIELD_VALUETYPE, (Object)pSDEDSParamBase.getValueType());
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
        return PSDEDSParamBase.remove(this, n);
    }

    private static boolean remove(PSDEDSParamBase pSDEDSParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDSParamBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDEDSParamBase.resetArrayFlag();
                return true;
            }
            case 2: {
                pSDEDSParamBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDEDSParamBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEDSParamBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEDSParamBase.resetJsonFormat();
                return true;
            }
            case 6: {
                pSDEDSParamBase.resetMemo();
                return true;
            }
            case 7: {
                pSDEDSParamBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSDEDSParamBase.resetParamDesc();
                return true;
            }
            case 9: {
                pSDEDSParamBase.resetParamTag();
                return true;
            }
            case 10: {
                pSDEDSParamBase.resetParamTag2();
                return true;
            }
            case 11: {
                pSDEDSParamBase.resetPSDEDSId();
                return true;
            }
            case 12: {
                pSDEDSParamBase.resetPSDEDSName();
                return true;
            }
            case 13: {
                pSDEDSParamBase.resetPSDEDSParamId();
                return true;
            }
            case 14: {
                pSDEDSParamBase.resetPSDEDSParamName();
                return true;
            }
            case 15: {
                pSDEDSParamBase.resetPSDEFSFItemId();
                return true;
            }
            case 16: {
                pSDEDSParamBase.resetPSDEFSFItemName();
                return true;
            }
            case 17: {
                pSDEDSParamBase.resetPSDEFValueRuleId();
                return true;
            }
            case 18: {
                pSDEDSParamBase.resetPSDEFValueRuleName();
                return true;
            }
            case 19: {
                pSDEDSParamBase.resetPSDEId();
                return true;
            }
            case 20: {
                pSDEDSParamBase.resetPSSysValueRuleId();
                return true;
            }
            case 21: {
                pSDEDSParamBase.resetPSSysValueRuleName();
                return true;
            }
            case 22: {
                pSDEDSParamBase.resetStdDataType();
                return true;
            }
            case 23: {
                pSDEDSParamBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSDEDSParamBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSDEDSParamBase.resetUserCat();
                return true;
            }
            case 26: {
                pSDEDSParamBase.resetUserTag();
                return true;
            }
            case 27: {
                pSDEDSParamBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSDEDSParamBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSDEDSParamBase.resetUserTag4();
                return true;
            }
            case 30: {
                pSDEDSParamBase.resetValue();
                return true;
            }
            case 31: {
                pSDEDSParamBase.resetValueDesc();
                return true;
            }
            case 32: {
                pSDEDSParamBase.resetValueType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFSFItem getPSDEFSFItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItem();
        }
        if (this.getPSDEFSFItemId() == null) {
            return null;
        }
        Integer n = this.objPSDEFSFItemLock;
        synchronized (n) {
            if (this.psdefsfitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFSFItemId(), (Object)this.psdefsfitem.getPSDEFSFItemId()) != 0L) {
                this.psdefsfitem = null;
            }
            if (this.psdefsfitem == null) {
                PSDEFSFItem pSDEFSFItem = new PSDEFSFItem();
                pSDEFSFItem.setPSDEFSFItemId(this.getPSDEFSFItemId());
                PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
                pSDEFSFItemService.autoGet((IEntity)pSDEFSFItem);
                this.psdefsfitem = pSDEFSFItem;
            }
            return this.psdefsfitem;
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

    private PSDEDSParamBase getProxyEntity() {
        return this.proxyPSDEDSParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDSParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDSParamBase) {
            this.proxyPSDEDSParamBase = (PSDEDSParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_ARRAYFLAG, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_JSONFORMAT, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORDERVALUE, 7);
        fieldIndexMap.put(FIELD_PARAMDESC, 8);
        fieldIndexMap.put(FIELD_PARAMTAG, 9);
        fieldIndexMap.put(FIELD_PARAMTAG2, 10);
        fieldIndexMap.put(FIELD_PSDEDSID, 11);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 12);
        fieldIndexMap.put(FIELD_PSDEDSPARAMID, 13);
        fieldIndexMap.put(FIELD_PSDEDSPARAMNAME, 14);
        fieldIndexMap.put(FIELD_PSDEFSFITEMID, 15);
        fieldIndexMap.put(FIELD_PSDEFSFITEMNAME, 16);
        fieldIndexMap.put(FIELD_PSDEFVALUERULEID, 17);
        fieldIndexMap.put(FIELD_PSDEFVALUERULENAME, 18);
        fieldIndexMap.put(FIELD_PSDEID, 19);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 20);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 21);
        fieldIndexMap.put(FIELD_STDDATATYPE, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
        fieldIndexMap.put(FIELD_VALUE, 30);
        fieldIndexMap.put(FIELD_VALUEDESC, 31);
        fieldIndexMap.put(FIELD_VALUETYPE, 32);
    }
}

