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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFGroupDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFGroupDetailBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_DETAILPARAM = "DETAILPARAM";
    public static final String FIELD_DETAILPARAM2 = "DETAILPARAM2";
    public static final String FIELD_DEFAULTVALUETYPE = "DVT";
    public static final String FIELD_ENABLEUSERINPUT = "ENABLEUSERINPUT";
    public static final String FIELD_JSONFORMAT = "JSONFORMAT";
    public static final String FIELD_LNPSLANRESID = "LNPSLANRESID";
    public static final String FIELD_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String FIELD_MAXVALUE = "MAXVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String FIELD_MINVALUE = "MINVALUE";
    public static final String FIELD_MODIFYUSERINPUT = "MODIFYUSERINPUT";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFGROUPDETAILID = "PSDEFGROUPDETAILID";
    public static final String FIELD_PSDEFGROUPDETAILNAME = "PSDEFGROUPDETAILNAME";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFUIMODEID = "PSDEFUIMODEID";
    public static final String FIELD_PSDEFUIMODENAME = "PSDEFUIMODENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_SEARCHMODES = "SEARCHMODES";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_STRLENGTH = "STRLENGTH";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CODENAME2 = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DEFAULTVALUE = 5;
    private static final int INDEX_DETAILPARAM = 6;
    private static final int INDEX_DETAILPARAM2 = 7;
    private static final int INDEX_DEFAULTVALUETYPE = 8;
    private static final int INDEX_ENABLEUSERINPUT = 9;
    private static final int INDEX_JSONFORMAT = 10;
    private static final int INDEX_LNPSLANRESID = 11;
    private static final int INDEX_LNPSLANRESNAME = 12;
    private static final int INDEX_MAXVALUE = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_MINSTRLENGTH = 15;
    private static final int INDEX_MINVALUE = 16;
    private static final int INDEX_MODIFYUSERINPUT = 17;
    private static final int INDEX_ORDERVALUE = 18;
    private static final int INDEX_PRECISION2 = 19;
    private static final int INDEX_PSCODELISTID = 20;
    private static final int INDEX_PSCODELISTNAME = 21;
    private static final int INDEX_PSDEFGROUPDETAILID = 22;
    private static final int INDEX_PSDEFGROUPDETAILNAME = 23;
    private static final int INDEX_PSDEFGROUPID = 24;
    private static final int INDEX_PSDEFGROUPNAME = 25;
    private static final int INDEX_PSDEFID = 26;
    private static final int INDEX_PSDEFNAME = 27;
    private static final int INDEX_PSDEFUIMODEID = 28;
    private static final int INDEX_PSDEFUIMODENAME = 29;
    private static final int INDEX_PSDEID = 30;
    private static final int INDEX_PSSYSVALUERULEID = 31;
    private static final int INDEX_PSSYSVALUERULENAME = 32;
    private static final int INDEX_SEARCHMODES = 33;
    private static final int INDEX_SERVICECODENAME = 34;
    private static final int INDEX_STRLENGTH = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_USERTAG3 = 41;
    private static final int INDEX_USERTAG4 = 42;
    private static final int INDEX_VALIDFLAG = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFGroupDetailBase proxyPSDEFGroupDetailBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean detailparamDirtyFlag = false;
    private boolean detailparam2DirtyFlag = false;
    private boolean defaultvaluetypeDirtyFlag = false;
    private boolean enableuserinputDirtyFlag = false;
    private boolean jsonformatDirtyFlag = false;
    private boolean lnpslanresidDirtyFlag = false;
    private boolean lnpslanresnameDirtyFlag = false;
    private boolean maxvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minstrlengthDirtyFlag = false;
    private boolean minvalueDirtyFlag = false;
    private boolean modifyuserinputDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefgroupdetailidDirtyFlag = false;
    private boolean psdefgroupdetailnameDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdefuimodeidDirtyFlag = false;
    private boolean psdefuimodenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean searchmodesDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean strlengthDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="detailparam")
    private String detailparam;
    @Column(name="detailparam2")
    private String detailparam2;
    @Column(name="defaultvaluetype")
    private String defaultvaluetype;
    @Column(name="enableuserinput")
    private Integer enableuserinput;
    @Column(name="jsonformat")
    private String jsonformat;
    @Column(name="lnpslanresid")
    private String lnpslanresid;
    @Column(name="lnpslanresname")
    private String lnpslanresname;
    @Column(name="maxvalue")
    private String maxvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="minstrlength")
    private Integer minstrlength;
    @Column(name="minvalue")
    private String minvalue;
    @Column(name="modifyuserinput")
    private Integer modifyuserinput;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdefgroupdetailid")
    private String psdefgroupdetailid;
    @Column(name="psdefgroupdetailname")
    private String psdefgroupdetailname;
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdefuimodeid")
    private String psdefuimodeid;
    @Column(name="psdefuimodename")
    private String psdefuimodename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
    @Column(name="searchmodes")
    private String searchmodes;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="strlength")
    private Integer strlength;
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
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDEFUIModeLock = new Integer(1);
    private PSDEFUIMode psdefuimode = null;
    private Integer objPSDEFGroupLock = new Integer(1);
    private PSDEFGroup psdefgroup = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objLNPSLanResLock = new Integer(1);
    private PSLanguageRes lnpslanres = null;
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

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
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

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
    }

    public void setDetailParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparam = string;
        this.detailparamDirtyFlag = true;
    }

    public String getDetailParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParam();
        }
        return this.detailparam;
    }

    public boolean isDetailParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParamDirty();
        }
        return this.detailparamDirtyFlag;
    }

    public void resetDetailParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParam();
            return;
        }
        this.detailparamDirtyFlag = false;
        this.detailparam = null;
    }

    public void setDetailParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparam2 = string;
        this.detailparam2DirtyFlag = true;
    }

    public String getDetailParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParam2();
        }
        return this.detailparam2;
    }

    public boolean isDetailParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParam2Dirty();
        }
        return this.detailparam2DirtyFlag;
    }

    public void resetDetailParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParam2();
            return;
        }
        this.detailparam2DirtyFlag = false;
        this.detailparam2 = null;
    }

    public void setDefaultValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvaluetype = string;
        this.defaultvaluetypeDirtyFlag = true;
    }

    public String getDefaultValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValueType();
        }
        return this.defaultvaluetype;
    }

    public boolean isDefaultValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueTypeDirty();
        }
        return this.defaultvaluetypeDirtyFlag;
    }

    public void resetDefaultValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValueType();
            return;
        }
        this.defaultvaluetypeDirtyFlag = false;
        this.defaultvaluetype = null;
    }

    public void setEnableUserInput(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableUserInput(n);
            return;
        }
        this.enableuserinput = n;
        this.enableuserinputDirtyFlag = true;
    }

    public Integer getEnableUserInput() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableUserInput();
        }
        return this.enableuserinput;
    }

    public boolean isEnableUserInputDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableUserInputDirty();
        }
        return this.enableuserinputDirtyFlag;
    }

    public void resetEnableUserInput() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableUserInput();
            return;
        }
        this.enableuserinputDirtyFlag = false;
        this.enableuserinput = null;
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

    public void setLNPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresid = string;
        this.lnpslanresidDirtyFlag = true;
    }

    public String getLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResId();
        }
        return this.lnpslanresid;
    }

    public boolean isLNPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResIdDirty();
        }
        return this.lnpslanresidDirtyFlag;
    }

    public void resetLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResId();
            return;
        }
        this.lnpslanresidDirtyFlag = false;
        this.lnpslanresid = null;
    }

    public void setLNPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresname = string;
        this.lnpslanresnameDirtyFlag = true;
    }

    public String getLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResName();
        }
        return this.lnpslanresname;
    }

    public boolean isLNPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResNameDirty();
        }
        return this.lnpslanresnameDirtyFlag;
    }

    public void resetLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResName();
            return;
        }
        this.lnpslanresnameDirtyFlag = false;
        this.lnpslanresname = null;
    }

    public void setMaxValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maxvalue = string;
        this.maxvalueDirtyFlag = true;
    }

    public String getMaxValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxValue();
        }
        return this.maxvalue;
    }

    public boolean isMaxValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxValueDirty();
        }
        return this.maxvalueDirtyFlag;
    }

    public void resetMaxValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxValue();
            return;
        }
        this.maxvalueDirtyFlag = false;
        this.maxvalue = null;
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

    public void setMinStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinStrLength(n);
            return;
        }
        this.minstrlength = n;
        this.minstrlengthDirtyFlag = true;
    }

    public Integer getMinStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinStrLength();
        }
        return this.minstrlength;
    }

    public boolean isMinStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinStrLengthDirty();
        }
        return this.minstrlengthDirtyFlag;
    }

    public void resetMinStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinStrLength();
            return;
        }
        this.minstrlengthDirtyFlag = false;
        this.minstrlength = null;
    }

    public void setMinValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minvalue = string;
        this.minvalueDirtyFlag = true;
    }

    public String getMinValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinValue();
        }
        return this.minvalue;
    }

    public boolean isMinValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinValueDirty();
        }
        return this.minvalueDirtyFlag;
    }

    public void resetMinValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinValue();
            return;
        }
        this.minvalueDirtyFlag = false;
        this.minvalue = null;
    }

    public void setModifyUserInput(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModifyUserInput(n);
            return;
        }
        this.modifyuserinput = n;
        this.modifyuserinputDirtyFlag = true;
    }

    public Integer getModifyUserInput() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModifyUserInput();
        }
        return this.modifyuserinput;
    }

    public boolean isModifyUserInputDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModifyUserInputDirty();
        }
        return this.modifyuserinputDirtyFlag;
    }

    public void resetModifyUserInput() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModifyUserInput();
            return;
        }
        this.modifyuserinputDirtyFlag = false;
        this.modifyuserinput = null;
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

    public void setPrecision2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrecision2(n);
            return;
        }
        this.precision2 = n;
        this.precision2DirtyFlag = true;
    }

    public Integer getPrecision2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrecision2();
        }
        return this.precision2;
    }

    public boolean isPrecision2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrecision2Dirty();
        }
        return this.precision2DirtyFlag;
    }

    public void resetPrecision2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrecision2();
            return;
        }
        this.precision2DirtyFlag = false;
        this.precision2 = null;
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

    public void setPSDEFGroupDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupdetailid = string;
        this.psdefgroupdetailidDirtyFlag = true;
    }

    public String getPSDEFGroupDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupDetailId();
        }
        return this.psdefgroupdetailid;
    }

    public boolean isPSDEFGroupDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupDetailIdDirty();
        }
        return this.psdefgroupdetailidDirtyFlag;
    }

    public void resetPSDEFGroupDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupDetailId();
            return;
        }
        this.psdefgroupdetailidDirtyFlag = false;
        this.psdefgroupdetailid = null;
    }

    public void setPSDEFGroupDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupdetailname = string;
        this.psdefgroupdetailnameDirtyFlag = true;
    }

    public String getPSDEFGroupDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupDetailName();
        }
        return this.psdefgroupdetailname;
    }

    public boolean isPSDEFGroupDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupDetailNameDirty();
        }
        return this.psdefgroupdetailnameDirtyFlag;
    }

    public void resetPSDEFGroupDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupDetailName();
            return;
        }
        this.psdefgroupdetailnameDirtyFlag = false;
        this.psdefgroupdetailname = null;
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

    public void setPSDEFUIModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefuimodeid = string;
        this.psdefuimodeidDirtyFlag = true;
    }

    public String getPSDEFUIModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModeId();
        }
        return this.psdefuimodeid;
    }

    public boolean isPSDEFUIModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModeIdDirty();
        }
        return this.psdefuimodeidDirtyFlag;
    }

    public void resetPSDEFUIModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModeId();
            return;
        }
        this.psdefuimodeidDirtyFlag = false;
        this.psdefuimodeid = null;
    }

    public void setPSDEFUIModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefuimodename = string;
        this.psdefuimodenameDirtyFlag = true;
    }

    public String getPSDEFUIModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModeName();
        }
        return this.psdefuimodename;
    }

    public boolean isPSDEFUIModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModeNameDirty();
        }
        return this.psdefuimodenameDirtyFlag;
    }

    public void resetPSDEFUIModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModeName();
            return;
        }
        this.psdefuimodenameDirtyFlag = false;
        this.psdefuimodename = null;
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

    public void setSearchModes(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchModes(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchmodes = string;
        this.searchmodesDirtyFlag = true;
    }

    public String getSearchModes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchModes();
        }
        return this.searchmodes;
    }

    public boolean isSearchModesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchModesDirty();
        }
        return this.searchmodesDirtyFlag;
    }

    public void resetSearchModes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchModes();
            return;
        }
        this.searchmodesDirtyFlag = false;
        this.searchmodes = null;
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

    public void setStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStrLength(n);
            return;
        }
        this.strlength = n;
        this.strlengthDirtyFlag = true;
    }

    public Integer getStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStrLength();
        }
        return this.strlength;
    }

    public boolean isStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStrLengthDirty();
        }
        return this.strlengthDirtyFlag;
    }

    public void resetStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStrLength();
            return;
        }
        this.strlengthDirtyFlag = false;
        this.strlength = null;
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

    protected void onReset() {
        PSDEFGroupDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFGroupDetailBase pSDEFGroupDetailBase) {
        pSDEFGroupDetailBase.resetAllowEmpty();
        pSDEFGroupDetailBase.resetCodeName();
        pSDEFGroupDetailBase.resetCodeName2();
        pSDEFGroupDetailBase.resetCreateDate();
        pSDEFGroupDetailBase.resetCreateMan();
        pSDEFGroupDetailBase.resetDefaultValue();
        pSDEFGroupDetailBase.resetDetailParam();
        pSDEFGroupDetailBase.resetDetailParam2();
        pSDEFGroupDetailBase.resetDefaultValueType();
        pSDEFGroupDetailBase.resetEnableUserInput();
        pSDEFGroupDetailBase.resetJsonFormat();
        pSDEFGroupDetailBase.resetLNPSLanResId();
        pSDEFGroupDetailBase.resetLNPSLanResName();
        pSDEFGroupDetailBase.resetMaxValue();
        pSDEFGroupDetailBase.resetMemo();
        pSDEFGroupDetailBase.resetMinStrLength();
        pSDEFGroupDetailBase.resetMinValue();
        pSDEFGroupDetailBase.resetModifyUserInput();
        pSDEFGroupDetailBase.resetOrderValue();
        pSDEFGroupDetailBase.resetPrecision2();
        pSDEFGroupDetailBase.resetPSCodeListId();
        pSDEFGroupDetailBase.resetPSCodeListName();
        pSDEFGroupDetailBase.resetPSDEFGroupDetailId();
        pSDEFGroupDetailBase.resetPSDEFGroupDetailName();
        pSDEFGroupDetailBase.resetPSDEFGroupId();
        pSDEFGroupDetailBase.resetPSDEFGroupName();
        pSDEFGroupDetailBase.resetPSDEFId();
        pSDEFGroupDetailBase.resetPSDEFName();
        pSDEFGroupDetailBase.resetPSDEFUIModeId();
        pSDEFGroupDetailBase.resetPSDEFUIModeName();
        pSDEFGroupDetailBase.resetPSDEId();
        pSDEFGroupDetailBase.resetPSSysValueRuleId();
        pSDEFGroupDetailBase.resetPSSysValueRuleName();
        pSDEFGroupDetailBase.resetSearchModes();
        pSDEFGroupDetailBase.resetServiceCodeName();
        pSDEFGroupDetailBase.resetStrLength();
        pSDEFGroupDetailBase.resetUpdateDate();
        pSDEFGroupDetailBase.resetUpdateMan();
        pSDEFGroupDetailBase.resetUserCat();
        pSDEFGroupDetailBase.resetUserTag();
        pSDEFGroupDetailBase.resetUserTag2();
        pSDEFGroupDetailBase.resetUserTag3();
        pSDEFGroupDetailBase.resetUserTag4();
        pSDEFGroupDetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isDetailParamDirty()) {
            hashMap.put(FIELD_DETAILPARAM, this.getDetailParam());
        }
        if (!bl || this.isDetailParam2Dirty()) {
            hashMap.put(FIELD_DETAILPARAM2, this.getDetailParam2());
        }
        if (!bl || this.isDefaultValueTypeDirty()) {
            hashMap.put(FIELD_DEFAULTVALUETYPE, this.getDefaultValueType());
        }
        if (!bl || this.isEnableUserInputDirty()) {
            hashMap.put(FIELD_ENABLEUSERINPUT, this.getEnableUserInput());
        }
        if (!bl || this.isJsonFormatDirty()) {
            hashMap.put(FIELD_JSONFORMAT, this.getJsonFormat());
        }
        if (!bl || this.isLNPSLanResIdDirty()) {
            hashMap.put(FIELD_LNPSLANRESID, this.getLNPSLanResId());
        }
        if (!bl || this.isLNPSLanResNameDirty()) {
            hashMap.put(FIELD_LNPSLANRESNAME, this.getLNPSLanResName());
        }
        if (!bl || this.isMaxValueDirty()) {
            hashMap.put(FIELD_MAXVALUE, this.getMaxValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinStrLengthDirty()) {
            hashMap.put(FIELD_MINSTRLENGTH, this.getMinStrLength());
        }
        if (!bl || this.isMinValueDirty()) {
            hashMap.put(FIELD_MINVALUE, this.getMinValue());
        }
        if (!bl || this.isModifyUserInputDirty()) {
            hashMap.put(FIELD_MODIFYUSERINPUT, this.getModifyUserInput());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEFGroupDetailIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPDETAILID, this.getPSDEFGroupDetailId());
        }
        if (!bl || this.isPSDEFGroupDetailNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPDETAILNAME, this.getPSDEFGroupDetailName());
        }
        if (!bl || this.isPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPID, this.getPSDEFGroupId());
        }
        if (!bl || this.isPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPNAME, this.getPSDEFGroupName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEFUIModeIdDirty()) {
            hashMap.put(FIELD_PSDEFUIMODEID, this.getPSDEFUIModeId());
        }
        if (!bl || this.isPSDEFUIModeNameDirty()) {
            hashMap.put(FIELD_PSDEFUIMODENAME, this.getPSDEFUIModeName());
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
        if (!bl || this.isSearchModesDirty()) {
            hashMap.put(FIELD_SEARCHMODES, this.getSearchModes());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isStrLengthDirty()) {
            hashMap.put(FIELD_STRLENGTH, this.getStrLength());
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
        return PSDEFGroupDetailBase.get(this, n);
    }

    private static Object get(PSDEFGroupDetailBase pSDEFGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGroupDetailBase.getAllowEmpty();
            }
            case 1: {
                return pSDEFGroupDetailBase.getCodeName();
            }
            case 2: {
                return pSDEFGroupDetailBase.getCodeName2();
            }
            case 3: {
                return pSDEFGroupDetailBase.getCreateDate();
            }
            case 4: {
                return pSDEFGroupDetailBase.getCreateMan();
            }
            case 5: {
                return pSDEFGroupDetailBase.getDefaultValue();
            }
            case 6: {
                return pSDEFGroupDetailBase.getDetailParam();
            }
            case 7: {
                return pSDEFGroupDetailBase.getDetailParam2();
            }
            case 8: {
                return pSDEFGroupDetailBase.getDefaultValueType();
            }
            case 9: {
                return pSDEFGroupDetailBase.getEnableUserInput();
            }
            case 10: {
                return pSDEFGroupDetailBase.getJsonFormat();
            }
            case 11: {
                return pSDEFGroupDetailBase.getLNPSLanResId();
            }
            case 12: {
                return pSDEFGroupDetailBase.getLNPSLanResName();
            }
            case 13: {
                return pSDEFGroupDetailBase.getMaxValue();
            }
            case 14: {
                return pSDEFGroupDetailBase.getMemo();
            }
            case 15: {
                return pSDEFGroupDetailBase.getMinStrLength();
            }
            case 16: {
                return pSDEFGroupDetailBase.getMinValue();
            }
            case 17: {
                return pSDEFGroupDetailBase.getModifyUserInput();
            }
            case 18: {
                return pSDEFGroupDetailBase.getOrderValue();
            }
            case 19: {
                return pSDEFGroupDetailBase.getPrecision2();
            }
            case 20: {
                return pSDEFGroupDetailBase.getPSCodeListId();
            }
            case 21: {
                return pSDEFGroupDetailBase.getPSCodeListName();
            }
            case 22: {
                return pSDEFGroupDetailBase.getPSDEFGroupDetailId();
            }
            case 23: {
                return pSDEFGroupDetailBase.getPSDEFGroupDetailName();
            }
            case 24: {
                return pSDEFGroupDetailBase.getPSDEFGroupId();
            }
            case 25: {
                return pSDEFGroupDetailBase.getPSDEFGroupName();
            }
            case 26: {
                return pSDEFGroupDetailBase.getPSDEFId();
            }
            case 27: {
                return pSDEFGroupDetailBase.getPSDEFName();
            }
            case 28: {
                return pSDEFGroupDetailBase.getPSDEFUIModeId();
            }
            case 29: {
                return pSDEFGroupDetailBase.getPSDEFUIModeName();
            }
            case 30: {
                return pSDEFGroupDetailBase.getPSDEId();
            }
            case 31: {
                return pSDEFGroupDetailBase.getPSSysValueRuleId();
            }
            case 32: {
                return pSDEFGroupDetailBase.getPSSysValueRuleName();
            }
            case 33: {
                return pSDEFGroupDetailBase.getSearchModes();
            }
            case 34: {
                return pSDEFGroupDetailBase.getServiceCodeName();
            }
            case 35: {
                return pSDEFGroupDetailBase.getStrLength();
            }
            case 36: {
                return pSDEFGroupDetailBase.getUpdateDate();
            }
            case 37: {
                return pSDEFGroupDetailBase.getUpdateMan();
            }
            case 38: {
                return pSDEFGroupDetailBase.getUserCat();
            }
            case 39: {
                return pSDEFGroupDetailBase.getUserTag();
            }
            case 40: {
                return pSDEFGroupDetailBase.getUserTag2();
            }
            case 41: {
                return pSDEFGroupDetailBase.getUserTag3();
            }
            case 42: {
                return pSDEFGroupDetailBase.getUserTag4();
            }
            case 43: {
                return pSDEFGroupDetailBase.getValidFlag();
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
        PSDEFGroupDetailBase.set(this, n, object);
    }

    private static void set(PSDEFGroupDetailBase pSDEFGroupDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFGroupDetailBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFGroupDetailBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFGroupDetailBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFGroupDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEFGroupDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFGroupDetailBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFGroupDetailBase.setDetailParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFGroupDetailBase.setDetailParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFGroupDetailBase.setDefaultValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFGroupDetailBase.setEnableUserInput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEFGroupDetailBase.setJsonFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFGroupDetailBase.setLNPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFGroupDetailBase.setLNPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFGroupDetailBase.setMaxValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFGroupDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFGroupDetailBase.setMinStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEFGroupDetailBase.setMinValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFGroupDetailBase.setModifyUserInput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEFGroupDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEFGroupDetailBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEFGroupDetailBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFGroupDetailBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFGroupDetailBase.setPSDEFGroupDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFGroupDetailBase.setPSDEFGroupDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFGroupDetailBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFGroupDetailBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFGroupDetailBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFGroupDetailBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFGroupDetailBase.setPSDEFUIModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFGroupDetailBase.setPSDEFUIModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFGroupDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEFGroupDetailBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFGroupDetailBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFGroupDetailBase.setSearchModes(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFGroupDetailBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFGroupDetailBase.setStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDEFGroupDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDEFGroupDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEFGroupDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEFGroupDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEFGroupDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEFGroupDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEFGroupDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEFGroupDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEFGroupDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFGroupDetailBase pSDEFGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGroupDetailBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDEFGroupDetailBase.getCodeName() == null;
            }
            case 2: {
                return pSDEFGroupDetailBase.getCodeName2() == null;
            }
            case 3: {
                return pSDEFGroupDetailBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEFGroupDetailBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEFGroupDetailBase.getDefaultValue() == null;
            }
            case 6: {
                return pSDEFGroupDetailBase.getDetailParam() == null;
            }
            case 7: {
                return pSDEFGroupDetailBase.getDetailParam2() == null;
            }
            case 8: {
                return pSDEFGroupDetailBase.getDefaultValueType() == null;
            }
            case 9: {
                return pSDEFGroupDetailBase.getEnableUserInput() == null;
            }
            case 10: {
                return pSDEFGroupDetailBase.getJsonFormat() == null;
            }
            case 11: {
                return pSDEFGroupDetailBase.getLNPSLanResId() == null;
            }
            case 12: {
                return pSDEFGroupDetailBase.getLNPSLanResName() == null;
            }
            case 13: {
                return pSDEFGroupDetailBase.getMaxValue() == null;
            }
            case 14: {
                return pSDEFGroupDetailBase.getMemo() == null;
            }
            case 15: {
                return pSDEFGroupDetailBase.getMinStrLength() == null;
            }
            case 16: {
                return pSDEFGroupDetailBase.getMinValue() == null;
            }
            case 17: {
                return pSDEFGroupDetailBase.getModifyUserInput() == null;
            }
            case 18: {
                return pSDEFGroupDetailBase.getOrderValue() == null;
            }
            case 19: {
                return pSDEFGroupDetailBase.getPrecision2() == null;
            }
            case 20: {
                return pSDEFGroupDetailBase.getPSCodeListId() == null;
            }
            case 21: {
                return pSDEFGroupDetailBase.getPSCodeListName() == null;
            }
            case 22: {
                return pSDEFGroupDetailBase.getPSDEFGroupDetailId() == null;
            }
            case 23: {
                return pSDEFGroupDetailBase.getPSDEFGroupDetailName() == null;
            }
            case 24: {
                return pSDEFGroupDetailBase.getPSDEFGroupId() == null;
            }
            case 25: {
                return pSDEFGroupDetailBase.getPSDEFGroupName() == null;
            }
            case 26: {
                return pSDEFGroupDetailBase.getPSDEFId() == null;
            }
            case 27: {
                return pSDEFGroupDetailBase.getPSDEFName() == null;
            }
            case 28: {
                return pSDEFGroupDetailBase.getPSDEFUIModeId() == null;
            }
            case 29: {
                return pSDEFGroupDetailBase.getPSDEFUIModeName() == null;
            }
            case 30: {
                return pSDEFGroupDetailBase.getPSDEId() == null;
            }
            case 31: {
                return pSDEFGroupDetailBase.getPSSysValueRuleId() == null;
            }
            case 32: {
                return pSDEFGroupDetailBase.getPSSysValueRuleName() == null;
            }
            case 33: {
                return pSDEFGroupDetailBase.getSearchModes() == null;
            }
            case 34: {
                return pSDEFGroupDetailBase.getServiceCodeName() == null;
            }
            case 35: {
                return pSDEFGroupDetailBase.getStrLength() == null;
            }
            case 36: {
                return pSDEFGroupDetailBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDEFGroupDetailBase.getUpdateMan() == null;
            }
            case 38: {
                return pSDEFGroupDetailBase.getUserCat() == null;
            }
            case 39: {
                return pSDEFGroupDetailBase.getUserTag() == null;
            }
            case 40: {
                return pSDEFGroupDetailBase.getUserTag2() == null;
            }
            case 41: {
                return pSDEFGroupDetailBase.getUserTag3() == null;
            }
            case 42: {
                return pSDEFGroupDetailBase.getUserTag4() == null;
            }
            case 43: {
                return pSDEFGroupDetailBase.getValidFlag() == null;
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
        return PSDEFGroupDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEFGroupDetailBase pSDEFGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGroupDetailBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDEFGroupDetailBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEFGroupDetailBase.isCodeName2Dirty();
            }
            case 3: {
                return pSDEFGroupDetailBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEFGroupDetailBase.isCreateManDirty();
            }
            case 5: {
                return pSDEFGroupDetailBase.isDefaultValueDirty();
            }
            case 6: {
                return pSDEFGroupDetailBase.isDetailParamDirty();
            }
            case 7: {
                return pSDEFGroupDetailBase.isDetailParam2Dirty();
            }
            case 8: {
                return pSDEFGroupDetailBase.isDefaultValueTypeDirty();
            }
            case 9: {
                return pSDEFGroupDetailBase.isEnableUserInputDirty();
            }
            case 10: {
                return pSDEFGroupDetailBase.isJsonFormatDirty();
            }
            case 11: {
                return pSDEFGroupDetailBase.isLNPSLanResIdDirty();
            }
            case 12: {
                return pSDEFGroupDetailBase.isLNPSLanResNameDirty();
            }
            case 13: {
                return pSDEFGroupDetailBase.isMaxValueDirty();
            }
            case 14: {
                return pSDEFGroupDetailBase.isMemoDirty();
            }
            case 15: {
                return pSDEFGroupDetailBase.isMinStrLengthDirty();
            }
            case 16: {
                return pSDEFGroupDetailBase.isMinValueDirty();
            }
            case 17: {
                return pSDEFGroupDetailBase.isModifyUserInputDirty();
            }
            case 18: {
                return pSDEFGroupDetailBase.isOrderValueDirty();
            }
            case 19: {
                return pSDEFGroupDetailBase.isPrecision2Dirty();
            }
            case 20: {
                return pSDEFGroupDetailBase.isPSCodeListIdDirty();
            }
            case 21: {
                return pSDEFGroupDetailBase.isPSCodeListNameDirty();
            }
            case 22: {
                return pSDEFGroupDetailBase.isPSDEFGroupDetailIdDirty();
            }
            case 23: {
                return pSDEFGroupDetailBase.isPSDEFGroupDetailNameDirty();
            }
            case 24: {
                return pSDEFGroupDetailBase.isPSDEFGroupIdDirty();
            }
            case 25: {
                return pSDEFGroupDetailBase.isPSDEFGroupNameDirty();
            }
            case 26: {
                return pSDEFGroupDetailBase.isPSDEFIdDirty();
            }
            case 27: {
                return pSDEFGroupDetailBase.isPSDEFNameDirty();
            }
            case 28: {
                return pSDEFGroupDetailBase.isPSDEFUIModeIdDirty();
            }
            case 29: {
                return pSDEFGroupDetailBase.isPSDEFUIModeNameDirty();
            }
            case 30: {
                return pSDEFGroupDetailBase.isPSDEIdDirty();
            }
            case 31: {
                return pSDEFGroupDetailBase.isPSSysValueRuleIdDirty();
            }
            case 32: {
                return pSDEFGroupDetailBase.isPSSysValueRuleNameDirty();
            }
            case 33: {
                return pSDEFGroupDetailBase.isSearchModesDirty();
            }
            case 34: {
                return pSDEFGroupDetailBase.isServiceCodeNameDirty();
            }
            case 35: {
                return pSDEFGroupDetailBase.isStrLengthDirty();
            }
            case 36: {
                return pSDEFGroupDetailBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDEFGroupDetailBase.isUpdateManDirty();
            }
            case 38: {
                return pSDEFGroupDetailBase.isUserCatDirty();
            }
            case 39: {
                return pSDEFGroupDetailBase.isUserTagDirty();
            }
            case 40: {
                return pSDEFGroupDetailBase.isUserTag2Dirty();
            }
            case 41: {
                return pSDEFGroupDetailBase.isUserTag3Dirty();
            }
            case 42: {
                return pSDEFGroupDetailBase.isUserTag4Dirty();
            }
            case 43: {
                return pSDEFGroupDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFGroupDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFGroupDetailBase pSDEFGroupDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFGroupDetailBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getDetailParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getDetailParam()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getDetailParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam2", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getDetailParam2()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getDefaultValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dvt", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getDefaultValueType()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getEnableUserInput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableuserinput", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getEnableUserInput()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getJsonFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsonformat", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getJsonFormat()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getLNPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresid", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getLNPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getLNPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresname", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getLNPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvalue", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getMaxValue()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getMinStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minstrlength", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getMinStrLength()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvalue", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getMinValue()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getModifyUserInput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modifyuserinput", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getModifyUserInput()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFGroupDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupdetailid", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEFGroupDetailId()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFGroupDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupdetailname", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEFGroupDetailName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFUIModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefuimodeid", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEFUIModeId()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFUIModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefuimodename", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEFUIModeName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getSearchModes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmodes", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getSearchModes()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"strlength", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getStrLength()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFGroupDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEFGroupDetailBase.getJSONValue((Object)pSDEFGroupDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFGroupDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFGroupDetailBase pSDEFGroupDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFGroupDetailBase.getAllowEmpty() != null) {
            object = pSDEFGroupDetailBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getCodeName() != null) {
            object = pSDEFGroupDetailBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getCodeName2() != null) {
            object = pSDEFGroupDetailBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getCreateDate() != null) {
            object = pSDEFGroupDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getCreateMan() != null) {
            object = pSDEFGroupDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getDefaultValue() != null) {
            object = pSDEFGroupDetailBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getDetailParam() != null) {
            object = pSDEFGroupDetailBase.getDetailParam();
            xmlNode.setAttribute(FIELD_DETAILPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getDetailParam2() != null) {
            object = pSDEFGroupDetailBase.getDetailParam2();
            xmlNode.setAttribute(FIELD_DETAILPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getDefaultValueType() != null) {
            object = pSDEFGroupDetailBase.getDefaultValueType();
            xmlNode.setAttribute("DEFAULTVALUETYPE", object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getEnableUserInput() != null) {
            object = pSDEFGroupDetailBase.getEnableUserInput();
            xmlNode.setAttribute(FIELD_ENABLEUSERINPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getJsonFormat() != null) {
            object = pSDEFGroupDetailBase.getJsonFormat();
            xmlNode.setAttribute(FIELD_JSONFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getLNPSLanResId() != null) {
            object = pSDEFGroupDetailBase.getLNPSLanResId();
            xmlNode.setAttribute(FIELD_LNPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getLNPSLanResName() != null) {
            object = pSDEFGroupDetailBase.getLNPSLanResName();
            xmlNode.setAttribute(FIELD_LNPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getMaxValue() != null) {
            object = pSDEFGroupDetailBase.getMaxValue();
            xmlNode.setAttribute(FIELD_MAXVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getMemo() != null) {
            object = pSDEFGroupDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getMinStrLength() != null) {
            object = pSDEFGroupDetailBase.getMinStrLength();
            xmlNode.setAttribute(FIELD_MINSTRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getMinValue() != null) {
            object = pSDEFGroupDetailBase.getMinValue();
            xmlNode.setAttribute(FIELD_MINVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getModifyUserInput() != null) {
            object = pSDEFGroupDetailBase.getModifyUserInput();
            xmlNode.setAttribute(FIELD_MODIFYUSERINPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getOrderValue() != null) {
            object = pSDEFGroupDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getPrecision2() != null) {
            object = pSDEFGroupDetailBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getPSCodeListId() != null) {
            object = pSDEFGroupDetailBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSCodeListName() != null) {
            object = pSDEFGroupDetailBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFGroupDetailId() != null) {
            object = pSDEFGroupDetailBase.getPSDEFGroupDetailId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFGroupDetailName() != null) {
            object = pSDEFGroupDetailBase.getPSDEFGroupDetailName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFGroupId() != null) {
            object = pSDEFGroupDetailBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFGroupName() != null) {
            object = pSDEFGroupDetailBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFId() != null) {
            object = pSDEFGroupDetailBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFName() != null) {
            object = pSDEFGroupDetailBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFUIModeId() != null) {
            object = pSDEFGroupDetailBase.getPSDEFUIModeId();
            xmlNode.setAttribute(FIELD_PSDEFUIMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEFUIModeName() != null) {
            object = pSDEFGroupDetailBase.getPSDEFUIModeName();
            xmlNode.setAttribute(FIELD_PSDEFUIMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSDEId() != null) {
            object = pSDEFGroupDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSSysValueRuleId() != null) {
            object = pSDEFGroupDetailBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getPSSysValueRuleName() != null) {
            object = pSDEFGroupDetailBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getSearchModes() != null) {
            object = pSDEFGroupDetailBase.getSearchModes();
            xmlNode.setAttribute(FIELD_SEARCHMODES, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getServiceCodeName() != null) {
            object = pSDEFGroupDetailBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getStrLength() != null) {
            object = pSDEFGroupDetailBase.getStrLength();
            xmlNode.setAttribute(FIELD_STRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getUpdateDate() != null) {
            object = pSDEFGroupDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFGroupDetailBase.getUpdateMan() != null) {
            object = pSDEFGroupDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getUserCat() != null) {
            object = pSDEFGroupDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getUserTag() != null) {
            object = pSDEFGroupDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getUserTag2() != null) {
            object = pSDEFGroupDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getUserTag3() != null) {
            object = pSDEFGroupDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getUserTag4() != null) {
            object = pSDEFGroupDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGroupDetailBase.getValidFlag() != null) {
            object = pSDEFGroupDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFGroupDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFGroupDetailBase pSDEFGroupDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFGroupDetailBase.isAllowEmptyDirty() && (bl || pSDEFGroupDetailBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDEFGroupDetailBase.getAllowEmpty());
        }
        if (pSDEFGroupDetailBase.isCodeNameDirty() && (bl || pSDEFGroupDetailBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFGroupDetailBase.getCodeName());
        }
        if (pSDEFGroupDetailBase.isCodeName2Dirty() && (bl || pSDEFGroupDetailBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDEFGroupDetailBase.getCodeName2());
        }
        if (pSDEFGroupDetailBase.isCreateDateDirty() && (bl || pSDEFGroupDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFGroupDetailBase.getCreateDate());
        }
        if (pSDEFGroupDetailBase.isCreateManDirty() && (bl || pSDEFGroupDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFGroupDetailBase.getCreateMan());
        }
        if (pSDEFGroupDetailBase.isDefaultValueDirty() && (bl || pSDEFGroupDetailBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSDEFGroupDetailBase.getDefaultValue());
        }
        if (pSDEFGroupDetailBase.isDetailParamDirty() && (bl || pSDEFGroupDetailBase.getDetailParam() != null)) {
            iDataObject.set(FIELD_DETAILPARAM, (Object)pSDEFGroupDetailBase.getDetailParam());
        }
        if (pSDEFGroupDetailBase.isDetailParam2Dirty() && (bl || pSDEFGroupDetailBase.getDetailParam2() != null)) {
            iDataObject.set(FIELD_DETAILPARAM2, (Object)pSDEFGroupDetailBase.getDetailParam2());
        }
        if (pSDEFGroupDetailBase.isDefaultValueTypeDirty() && (bl || pSDEFGroupDetailBase.getDefaultValueType() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUETYPE, (Object)pSDEFGroupDetailBase.getDefaultValueType());
        }
        if (pSDEFGroupDetailBase.isEnableUserInputDirty() && (bl || pSDEFGroupDetailBase.getEnableUserInput() != null)) {
            iDataObject.set(FIELD_ENABLEUSERINPUT, (Object)pSDEFGroupDetailBase.getEnableUserInput());
        }
        if (pSDEFGroupDetailBase.isJsonFormatDirty() && (bl || pSDEFGroupDetailBase.getJsonFormat() != null)) {
            iDataObject.set(FIELD_JSONFORMAT, (Object)pSDEFGroupDetailBase.getJsonFormat());
        }
        if (pSDEFGroupDetailBase.isLNPSLanResIdDirty() && (bl || pSDEFGroupDetailBase.getLNPSLanResId() != null)) {
            iDataObject.set(FIELD_LNPSLANRESID, (Object)pSDEFGroupDetailBase.getLNPSLanResId());
        }
        if (pSDEFGroupDetailBase.isLNPSLanResNameDirty() && (bl || pSDEFGroupDetailBase.getLNPSLanResName() != null)) {
            iDataObject.set(FIELD_LNPSLANRESNAME, (Object)pSDEFGroupDetailBase.getLNPSLanResName());
        }
        if (pSDEFGroupDetailBase.isMaxValueDirty() && (bl || pSDEFGroupDetailBase.getMaxValue() != null)) {
            iDataObject.set(FIELD_MAXVALUE, (Object)pSDEFGroupDetailBase.getMaxValue());
        }
        if (pSDEFGroupDetailBase.isMemoDirty() && (bl || pSDEFGroupDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFGroupDetailBase.getMemo());
        }
        if (pSDEFGroupDetailBase.isMinStrLengthDirty() && (bl || pSDEFGroupDetailBase.getMinStrLength() != null)) {
            iDataObject.set(FIELD_MINSTRLENGTH, (Object)pSDEFGroupDetailBase.getMinStrLength());
        }
        if (pSDEFGroupDetailBase.isMinValueDirty() && (bl || pSDEFGroupDetailBase.getMinValue() != null)) {
            iDataObject.set(FIELD_MINVALUE, (Object)pSDEFGroupDetailBase.getMinValue());
        }
        if (pSDEFGroupDetailBase.isModifyUserInputDirty() && (bl || pSDEFGroupDetailBase.getModifyUserInput() != null)) {
            iDataObject.set(FIELD_MODIFYUSERINPUT, (Object)pSDEFGroupDetailBase.getModifyUserInput());
        }
        if (pSDEFGroupDetailBase.isOrderValueDirty() && (bl || pSDEFGroupDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFGroupDetailBase.getOrderValue());
        }
        if (pSDEFGroupDetailBase.isPrecision2Dirty() && (bl || pSDEFGroupDetailBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSDEFGroupDetailBase.getPrecision2());
        }
        if (pSDEFGroupDetailBase.isPSCodeListIdDirty() && (bl || pSDEFGroupDetailBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEFGroupDetailBase.getPSCodeListId());
        }
        if (pSDEFGroupDetailBase.isPSCodeListNameDirty() && (bl || pSDEFGroupDetailBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEFGroupDetailBase.getPSCodeListName());
        }
        if (pSDEFGroupDetailBase.isPSDEFGroupDetailIdDirty() && (bl || pSDEFGroupDetailBase.getPSDEFGroupDetailId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPDETAILID, (Object)pSDEFGroupDetailBase.getPSDEFGroupDetailId());
        }
        if (pSDEFGroupDetailBase.isPSDEFGroupDetailNameDirty() && (bl || pSDEFGroupDetailBase.getPSDEFGroupDetailName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPDETAILNAME, (Object)pSDEFGroupDetailBase.getPSDEFGroupDetailName());
        }
        if (pSDEFGroupDetailBase.isPSDEFGroupIdDirty() && (bl || pSDEFGroupDetailBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSDEFGroupDetailBase.getPSDEFGroupId());
        }
        if (pSDEFGroupDetailBase.isPSDEFGroupNameDirty() && (bl || pSDEFGroupDetailBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSDEFGroupDetailBase.getPSDEFGroupName());
        }
        if (pSDEFGroupDetailBase.isPSDEFIdDirty() && (bl || pSDEFGroupDetailBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFGroupDetailBase.getPSDEFId());
        }
        if (pSDEFGroupDetailBase.isPSDEFNameDirty() && (bl || pSDEFGroupDetailBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFGroupDetailBase.getPSDEFName());
        }
        if (pSDEFGroupDetailBase.isPSDEFUIModeIdDirty() && (bl || pSDEFGroupDetailBase.getPSDEFUIModeId() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODEID, (Object)pSDEFGroupDetailBase.getPSDEFUIModeId());
        }
        if (pSDEFGroupDetailBase.isPSDEFUIModeNameDirty() && (bl || pSDEFGroupDetailBase.getPSDEFUIModeName() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODENAME, (Object)pSDEFGroupDetailBase.getPSDEFUIModeName());
        }
        if (pSDEFGroupDetailBase.isPSDEIdDirty() && (bl || pSDEFGroupDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFGroupDetailBase.getPSDEId());
        }
        if (pSDEFGroupDetailBase.isPSSysValueRuleIdDirty() && (bl || pSDEFGroupDetailBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEFGroupDetailBase.getPSSysValueRuleId());
        }
        if (pSDEFGroupDetailBase.isPSSysValueRuleNameDirty() && (bl || pSDEFGroupDetailBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEFGroupDetailBase.getPSSysValueRuleName());
        }
        if (pSDEFGroupDetailBase.isSearchModesDirty() && (bl || pSDEFGroupDetailBase.getSearchModes() != null)) {
            iDataObject.set(FIELD_SEARCHMODES, (Object)pSDEFGroupDetailBase.getSearchModes());
        }
        if (pSDEFGroupDetailBase.isServiceCodeNameDirty() && (bl || pSDEFGroupDetailBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDEFGroupDetailBase.getServiceCodeName());
        }
        if (pSDEFGroupDetailBase.isStrLengthDirty() && (bl || pSDEFGroupDetailBase.getStrLength() != null)) {
            iDataObject.set(FIELD_STRLENGTH, (Object)pSDEFGroupDetailBase.getStrLength());
        }
        if (pSDEFGroupDetailBase.isUpdateDateDirty() && (bl || pSDEFGroupDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFGroupDetailBase.getUpdateDate());
        }
        if (pSDEFGroupDetailBase.isUpdateManDirty() && (bl || pSDEFGroupDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFGroupDetailBase.getUpdateMan());
        }
        if (pSDEFGroupDetailBase.isUserCatDirty() && (bl || pSDEFGroupDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFGroupDetailBase.getUserCat());
        }
        if (pSDEFGroupDetailBase.isUserTagDirty() && (bl || pSDEFGroupDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFGroupDetailBase.getUserTag());
        }
        if (pSDEFGroupDetailBase.isUserTag2Dirty() && (bl || pSDEFGroupDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFGroupDetailBase.getUserTag2());
        }
        if (pSDEFGroupDetailBase.isUserTag3Dirty() && (bl || pSDEFGroupDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFGroupDetailBase.getUserTag3());
        }
        if (pSDEFGroupDetailBase.isUserTag4Dirty() && (bl || pSDEFGroupDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFGroupDetailBase.getUserTag4());
        }
        if (pSDEFGroupDetailBase.isValidFlagDirty() && (bl || pSDEFGroupDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEFGroupDetailBase.getValidFlag());
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
        return PSDEFGroupDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEFGroupDetailBase pSDEFGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFGroupDetailBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDEFGroupDetailBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEFGroupDetailBase.resetCodeName2();
                return true;
            }
            case 3: {
                pSDEFGroupDetailBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEFGroupDetailBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEFGroupDetailBase.resetDefaultValue();
                return true;
            }
            case 6: {
                pSDEFGroupDetailBase.resetDetailParam();
                return true;
            }
            case 7: {
                pSDEFGroupDetailBase.resetDetailParam2();
                return true;
            }
            case 8: {
                pSDEFGroupDetailBase.resetDefaultValueType();
                return true;
            }
            case 9: {
                pSDEFGroupDetailBase.resetEnableUserInput();
                return true;
            }
            case 10: {
                pSDEFGroupDetailBase.resetJsonFormat();
                return true;
            }
            case 11: {
                pSDEFGroupDetailBase.resetLNPSLanResId();
                return true;
            }
            case 12: {
                pSDEFGroupDetailBase.resetLNPSLanResName();
                return true;
            }
            case 13: {
                pSDEFGroupDetailBase.resetMaxValue();
                return true;
            }
            case 14: {
                pSDEFGroupDetailBase.resetMemo();
                return true;
            }
            case 15: {
                pSDEFGroupDetailBase.resetMinStrLength();
                return true;
            }
            case 16: {
                pSDEFGroupDetailBase.resetMinValue();
                return true;
            }
            case 17: {
                pSDEFGroupDetailBase.resetModifyUserInput();
                return true;
            }
            case 18: {
                pSDEFGroupDetailBase.resetOrderValue();
                return true;
            }
            case 19: {
                pSDEFGroupDetailBase.resetPrecision2();
                return true;
            }
            case 20: {
                pSDEFGroupDetailBase.resetPSCodeListId();
                return true;
            }
            case 21: {
                pSDEFGroupDetailBase.resetPSCodeListName();
                return true;
            }
            case 22: {
                pSDEFGroupDetailBase.resetPSDEFGroupDetailId();
                return true;
            }
            case 23: {
                pSDEFGroupDetailBase.resetPSDEFGroupDetailName();
                return true;
            }
            case 24: {
                pSDEFGroupDetailBase.resetPSDEFGroupId();
                return true;
            }
            case 25: {
                pSDEFGroupDetailBase.resetPSDEFGroupName();
                return true;
            }
            case 26: {
                pSDEFGroupDetailBase.resetPSDEFId();
                return true;
            }
            case 27: {
                pSDEFGroupDetailBase.resetPSDEFName();
                return true;
            }
            case 28: {
                pSDEFGroupDetailBase.resetPSDEFUIModeId();
                return true;
            }
            case 29: {
                pSDEFGroupDetailBase.resetPSDEFUIModeName();
                return true;
            }
            case 30: {
                pSDEFGroupDetailBase.resetPSDEId();
                return true;
            }
            case 31: {
                pSDEFGroupDetailBase.resetPSSysValueRuleId();
                return true;
            }
            case 32: {
                pSDEFGroupDetailBase.resetPSSysValueRuleName();
                return true;
            }
            case 33: {
                pSDEFGroupDetailBase.resetSearchModes();
                return true;
            }
            case 34: {
                pSDEFGroupDetailBase.resetServiceCodeName();
                return true;
            }
            case 35: {
                pSDEFGroupDetailBase.resetStrLength();
                return true;
            }
            case 36: {
                pSDEFGroupDetailBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDEFGroupDetailBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSDEFGroupDetailBase.resetUserCat();
                return true;
            }
            case 39: {
                pSDEFGroupDetailBase.resetUserTag();
                return true;
            }
            case 40: {
                pSDEFGroupDetailBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSDEFGroupDetailBase.resetUserTag3();
                return true;
            }
            case 42: {
                pSDEFGroupDetailBase.resetUserTag4();
                return true;
            }
            case 43: {
                pSDEFGroupDetailBase.resetValidFlag();
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
                pSCodeListService.autoGet(pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFUIMode getPSDEFUIMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIMode();
        }
        if (this.getPSDEFUIModeId() == null) {
            return null;
        }
        Integer n = this.objPSDEFUIModeLock;
        synchronized (n) {
            if (this.psdefuimode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFUIModeId(), (Object)this.psdefuimode.getPSDEFUIModeId()) != 0L) {
                this.psdefuimode = null;
            }
            if (this.psdefuimode == null) {
                PSDEFUIMode pSDEFUIMode = new PSDEFUIMode();
                pSDEFUIMode.setPSDEFUIModeId(this.getPSDEFUIModeId());
                PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFUIModeService.autoGet(pSDEFUIMode);
                this.psdefuimode = pSDEFUIMode;
            }
            return this.psdefuimode;
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
    public PSLanguageRes getLNPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanRes();
        }
        if (this.getLNPSLanResId() == null) {
            return null;
        }
        Integer n = this.objLNPSLanResLock;
        synchronized (n) {
            if (this.lnpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getLNPSLanResId(), (Object)this.lnpslanres.getPSLanguageResId()) != 0L) {
                this.lnpslanres = null;
            }
            if (this.lnpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getLNPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.lnpslanres = pSLanguageRes;
            }
            return this.lnpslanres;
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

    private PSDEFGroupDetailBase getProxyEntity() {
        return this.proxyPSDEFGroupDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFGroupDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFGroupDetailBase) {
            this.proxyPSDEFGroupDetailBase = (PSDEFGroupDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CODENAME2, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 5);
        fieldIndexMap.put(FIELD_DETAILPARAM, 6);
        fieldIndexMap.put(FIELD_DETAILPARAM2, 7);
        fieldIndexMap.put(FIELD_DEFAULTVALUETYPE, 8);
        fieldIndexMap.put(FIELD_ENABLEUSERINPUT, 9);
        fieldIndexMap.put(FIELD_JSONFORMAT, 10);
        fieldIndexMap.put(FIELD_LNPSLANRESID, 11);
        fieldIndexMap.put(FIELD_LNPSLANRESNAME, 12);
        fieldIndexMap.put(FIELD_MAXVALUE, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_MINSTRLENGTH, 15);
        fieldIndexMap.put(FIELD_MINVALUE, 16);
        fieldIndexMap.put(FIELD_MODIFYUSERINPUT, 17);
        fieldIndexMap.put(FIELD_ORDERVALUE, 18);
        fieldIndexMap.put(FIELD_PRECISION2, 19);
        fieldIndexMap.put(FIELD_PSCODELISTID, 20);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 21);
        fieldIndexMap.put(FIELD_PSDEFGROUPDETAILID, 22);
        fieldIndexMap.put(FIELD_PSDEFGROUPDETAILNAME, 23);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 24);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 25);
        fieldIndexMap.put(FIELD_PSDEFID, 26);
        fieldIndexMap.put(FIELD_PSDEFNAME, 27);
        fieldIndexMap.put(FIELD_PSDEFUIMODEID, 28);
        fieldIndexMap.put(FIELD_PSDEFUIMODENAME, 29);
        fieldIndexMap.put(FIELD_PSDEID, 30);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 31);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 32);
        fieldIndexMap.put(FIELD_SEARCHMODES, 33);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 34);
        fieldIndexMap.put(FIELD_STRLENGTH, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERCAT, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_USERTAG3, 41);
        fieldIndexMap.put(FIELD_USERTAG4, 42);
        fieldIndexMap.put(FIELD_VALIDFLAG, 43);
    }
}

