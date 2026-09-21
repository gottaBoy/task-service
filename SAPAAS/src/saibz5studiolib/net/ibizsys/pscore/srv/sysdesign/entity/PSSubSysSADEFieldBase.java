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
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADEFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysSADEFieldBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_EXAMPLEVALUE = "EXAMPLEVALUE";
    public static final String FIELD_FIELDTAG = "FIELDTAG";
    public static final String FIELD_FIELDTAG2 = "FIELDTAG2";
    public static final String FIELD_FIELDTYPE = "FIELDTYPE";
    public static final String FIELD_LENGTH = "LENGTH";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORFIELD = "MAJORFIELD";
    public static final String FIELD_MAXVALUE = "MAXVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String FIELD_MINVALUE = "MINVALUE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PKEY = "PKEY";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDATATYPEID = "PSDATATYPEID";
    public static final String FIELD_PSDATATYPENAME = "PSDATATYPENAME";
    public static final String FIELD_PSSUBSYSSADEFIELDID = "PSSUBSYSSADEFIELDID";
    public static final String FIELD_PSSUBSYSSADEFIELDNAME = "PSSUBSYSSADEFIELDNAME";
    public static final String FIELD_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String FIELD_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_REFPSSUBSYSSADEID = "REFPSSUBSYSSADEID";
    public static final String FIELD_REFPSSUBSYSSADENAME = "REFPSSUBSYSSADENAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_ARRAYFLAG = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CODENAME2 = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DEFAULTVALUE = 6;
    private static final int INDEX_EXAMPLEVALUE = 7;
    private static final int INDEX_FIELDTAG = 8;
    private static final int INDEX_FIELDTAG2 = 9;
    private static final int INDEX_FIELDTYPE = 10;
    private static final int INDEX_LENGTH = 11;
    private static final int INDEX_LOGICNAME = 12;
    private static final int INDEX_MAJORFIELD = 13;
    private static final int INDEX_MAXVALUE = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_MINSTRLENGTH = 16;
    private static final int INDEX_MINVALUE = 17;
    private static final int INDEX_ORDERVALUE = 18;
    private static final int INDEX_PKEY = 19;
    private static final int INDEX_PRECISION2 = 20;
    private static final int INDEX_PREDEFINEDTYPE = 21;
    private static final int INDEX_PSCODELISTID = 22;
    private static final int INDEX_PSCODELISTNAME = 23;
    private static final int INDEX_PSDATATYPEID = 24;
    private static final int INDEX_PSDATATYPENAME = 25;
    private static final int INDEX_PSSUBSYSSADEFIELDID = 26;
    private static final int INDEX_PSSUBSYSSADEFIELDNAME = 27;
    private static final int INDEX_PSSUBSYSSADEID = 28;
    private static final int INDEX_PSSUBSYSSADENAME = 29;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 30;
    private static final int INDEX_PSSYSVALUERULEID = 31;
    private static final int INDEX_PSSYSVALUERULENAME = 32;
    private static final int INDEX_REFPSSUBSYSSADEID = 33;
    private static final int INDEX_REFPSSUBSYSSADENAME = 34;
    private static final int INDEX_STDDATATYPE = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_USERTAG3 = 41;
    private static final int INDEX_USERTAG4 = 42;
    private static final int INDEX_VALIDFLAG = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysSADEFieldBase proxyPSSubSysSADEFieldBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean arrayflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean examplevalueDirtyFlag = false;
    private boolean fieldtagDirtyFlag = false;
    private boolean fieldtag2DirtyFlag = false;
    private boolean fieldtypeDirtyFlag = false;
    private boolean lengthDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorfieldDirtyFlag = false;
    private boolean maxvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minstrlengthDirtyFlag = false;
    private boolean minvalueDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pkeyDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdatatypeidDirtyFlag = false;
    private boolean psdatatypenameDirtyFlag = false;
    private boolean pssubsyssadefieldidDirtyFlag = false;
    private boolean pssubsyssadefieldnameDirtyFlag = false;
    private boolean pssubsyssadeidDirtyFlag = false;
    private boolean pssubsyssadenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean refpssubsyssadeidDirtyFlag = false;
    private boolean refpssubsyssadenameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
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
    @Column(name="arrayflag")
    private Integer arrayflag;
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
    @Column(name="examplevalue")
    private String examplevalue;
    @Column(name="fieldtag")
    private String fieldtag;
    @Column(name="fieldtag2")
    private String fieldtag2;
    @Column(name="fieldtype")
    private String fieldtype;
    @Column(name="length")
    private Integer length;
    @Column(name="logicname")
    private String logicname;
    @Column(name="majorfield")
    private Integer majorfield;
    @Column(name="maxvalue")
    private String maxvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="minstrlength")
    private Integer minstrlength;
    @Column(name="minvalue")
    private String minvalue;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pkey")
    private Integer pkey;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdatatypeid")
    private String psdatatypeid;
    @Column(name="psdatatypename")
    private String psdatatypename;
    @Column(name="pssubsyssadefieldid")
    private String pssubsyssadefieldid;
    @Column(name="pssubsyssadefieldname")
    private String pssubsyssadefieldname;
    @Column(name="pssubsyssadeid")
    private String pssubsyssadeid;
    @Column(name="pssubsyssadename")
    private String pssubsyssadename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
    @Column(name="refpssubsyssadeid")
    private String refpssubsyssadeid;
    @Column(name="refpssubsyssadename")
    private String refpssubsyssadename;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDataTypeLock = new Integer(1);
    private PSDEFDataType psdatatype = null;
    private Integer objPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE pssubsyssade = null;
    private Integer objRefPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE refpssubsyssade = null;
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

    public void setExampleValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExampleValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.examplevalue = string;
        this.examplevalueDirtyFlag = true;
    }

    public String getExampleValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExampleValue();
        }
        return this.examplevalue;
    }

    public boolean isExampleValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExampleValueDirty();
        }
        return this.examplevalueDirtyFlag;
    }

    public void resetExampleValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExampleValue();
            return;
        }
        this.examplevalueDirtyFlag = false;
        this.examplevalue = null;
    }

    public void setFieldTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldtag = string;
        this.fieldtagDirtyFlag = true;
    }

    public String getFieldTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldTag();
        }
        return this.fieldtag;
    }

    public boolean isFieldTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldTagDirty();
        }
        return this.fieldtagDirtyFlag;
    }

    public void resetFieldTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldTag();
            return;
        }
        this.fieldtagDirtyFlag = false;
        this.fieldtag = null;
    }

    public void setFieldTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldtag2 = string;
        this.fieldtag2DirtyFlag = true;
    }

    public String getFieldTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldTag2();
        }
        return this.fieldtag2;
    }

    public boolean isFieldTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldTag2Dirty();
        }
        return this.fieldtag2DirtyFlag;
    }

    public void resetFieldTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldTag2();
            return;
        }
        this.fieldtag2DirtyFlag = false;
        this.fieldtag2 = null;
    }

    public void setFieldType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldtype = string;
        this.fieldtypeDirtyFlag = true;
    }

    public String getFieldType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldType();
        }
        return this.fieldtype;
    }

    public boolean isFieldTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldTypeDirty();
        }
        return this.fieldtypeDirtyFlag;
    }

    public void resetFieldType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldType();
            return;
        }
        this.fieldtypeDirtyFlag = false;
        this.fieldtype = null;
    }

    public void setLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLength(n);
            return;
        }
        this.length = n;
        this.lengthDirtyFlag = true;
    }

    public Integer getLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLength();
        }
        return this.length;
    }

    public boolean isLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLengthDirty();
        }
        return this.lengthDirtyFlag;
    }

    public void resetLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLength();
            return;
        }
        this.lengthDirtyFlag = false;
        this.length = null;
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

    public void setMajorField(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorField(n);
            return;
        }
        this.majorfield = n;
        this.majorfieldDirtyFlag = true;
    }

    public Integer getMajorField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorField();
        }
        return this.majorfield;
    }

    public boolean isMajorFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorFieldDirty();
        }
        return this.majorfieldDirtyFlag;
    }

    public void resetMajorField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorField();
            return;
        }
        this.majorfieldDirtyFlag = false;
        this.majorfield = null;
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

    public void setPKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKey(n);
            return;
        }
        this.pkey = n;
        this.pkeyDirtyFlag = true;
    }

    public Integer getPKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKey();
        }
        return this.pkey;
    }

    public boolean isPKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKeyDirty();
        }
        return this.pkeyDirtyFlag;
    }

    public void resetPKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKey();
            return;
        }
        this.pkeyDirtyFlag = false;
        this.pkey = null;
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

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
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

    public void setPSDataTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatatypeid = string;
        this.psdatatypeidDirtyFlag = true;
    }

    public String getPSDataTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataTypeId();
        }
        return this.psdatatypeid;
    }

    public boolean isPSDataTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataTypeIdDirty();
        }
        return this.psdatatypeidDirtyFlag;
    }

    public void resetPSDataTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataTypeId();
            return;
        }
        this.psdatatypeidDirtyFlag = false;
        this.psdatatypeid = null;
    }

    public void setPSDataTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatatypename = string;
        this.psdatatypenameDirtyFlag = true;
    }

    public String getPSDataTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataTypeName();
        }
        return this.psdatatypename;
    }

    public boolean isPSDataTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataTypeNameDirty();
        }
        return this.psdatatypenameDirtyFlag;
    }

    public void resetPSDataTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataTypeName();
            return;
        }
        this.psdatatypenameDirtyFlag = false;
        this.psdatatypename = null;
    }

    public void setPSSubSysSADEFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadefieldid = string;
        this.pssubsyssadefieldidDirtyFlag = true;
    }

    public String getPSSubSysSADEFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEFieldId();
        }
        return this.pssubsyssadefieldid;
    }

    public boolean isPSSubSysSADEFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEFieldIdDirty();
        }
        return this.pssubsyssadefieldidDirtyFlag;
    }

    public void resetPSSubSysSADEFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEFieldId();
            return;
        }
        this.pssubsyssadefieldidDirtyFlag = false;
        this.pssubsyssadefieldid = null;
    }

    public void setPSSubSysSADEFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssubsyssadefieldname = string;
        this.pssubsyssadefieldnameDirtyFlag = true;
    }

    public String getPSSubSysSADEFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEFieldName();
        }
        return this.pssubsyssadefieldname;
    }

    public boolean isPSSubSysSADEFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEFieldNameDirty();
        }
        return this.pssubsyssadefieldnameDirtyFlag;
    }

    public void resetPSSubSysSADEFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEFieldName();
            return;
        }
        this.pssubsyssadefieldnameDirtyFlag = false;
        this.pssubsyssadefieldname = null;
    }

    public void setPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadeid = string;
        this.pssubsyssadeidDirtyFlag = true;
    }

    public String getPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEId();
        }
        return this.pssubsyssadeid;
    }

    public boolean isPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEIdDirty();
        }
        return this.pssubsyssadeidDirtyFlag;
    }

    public void resetPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEId();
            return;
        }
        this.pssubsyssadeidDirtyFlag = false;
        this.pssubsyssadeid = null;
    }

    public void setPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadename = string;
        this.pssubsyssadenameDirtyFlag = true;
    }

    public String getPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEName();
        }
        return this.pssubsyssadename;
    }

    public boolean isPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADENameDirty();
        }
        return this.pssubsyssadenameDirtyFlag;
    }

    public void resetPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEName();
            return;
        }
        this.pssubsyssadenameDirtyFlag = false;
        this.pssubsyssadename = null;
    }

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
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

    public void setRefPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssubsyssadeid = string;
        this.refpssubsyssadeidDirtyFlag = true;
    }

    public String getRefPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSubSysSADEId();
        }
        return this.refpssubsyssadeid;
    }

    public boolean isRefPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSubSysSADEIdDirty();
        }
        return this.refpssubsyssadeidDirtyFlag;
    }

    public void resetRefPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSubSysSADEId();
            return;
        }
        this.refpssubsyssadeidDirtyFlag = false;
        this.refpssubsyssadeid = null;
    }

    public void setRefPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssubsyssadename = string;
        this.refpssubsyssadenameDirtyFlag = true;
    }

    public String getRefPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSubSysSADEName();
        }
        return this.refpssubsyssadename;
    }

    public boolean isRefPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSubSysSADENameDirty();
        }
        return this.refpssubsyssadenameDirtyFlag;
    }

    public void resetRefPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSubSysSADEName();
            return;
        }
        this.refpssubsyssadenameDirtyFlag = false;
        this.refpssubsyssadename = null;
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
        PSSubSysSADEFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysSADEFieldBase pSSubSysSADEFieldBase) {
        pSSubSysSADEFieldBase.resetAllowEmpty();
        pSSubSysSADEFieldBase.resetArrayFlag();
        pSSubSysSADEFieldBase.resetCodeName();
        pSSubSysSADEFieldBase.resetCodeName2();
        pSSubSysSADEFieldBase.resetCreateDate();
        pSSubSysSADEFieldBase.resetCreateMan();
        pSSubSysSADEFieldBase.resetDefaultValue();
        pSSubSysSADEFieldBase.resetExampleValue();
        pSSubSysSADEFieldBase.resetFieldTag();
        pSSubSysSADEFieldBase.resetFieldTag2();
        pSSubSysSADEFieldBase.resetFieldType();
        pSSubSysSADEFieldBase.resetLength();
        pSSubSysSADEFieldBase.resetLogicName();
        pSSubSysSADEFieldBase.resetMajorField();
        pSSubSysSADEFieldBase.resetMaxValue();
        pSSubSysSADEFieldBase.resetMemo();
        pSSubSysSADEFieldBase.resetMinStrLength();
        pSSubSysSADEFieldBase.resetMinValue();
        pSSubSysSADEFieldBase.resetOrderValue();
        pSSubSysSADEFieldBase.resetPKey();
        pSSubSysSADEFieldBase.resetPrecision2();
        pSSubSysSADEFieldBase.resetPredefinedType();
        pSSubSysSADEFieldBase.resetPSCodeListId();
        pSSubSysSADEFieldBase.resetPSCodeListName();
        pSSubSysSADEFieldBase.resetPSDataTypeId();
        pSSubSysSADEFieldBase.resetPSDataTypeName();
        pSSubSysSADEFieldBase.resetPSSubSysSADEFieldId();
        pSSubSysSADEFieldBase.resetPSSubSysSADEFieldName();
        pSSubSysSADEFieldBase.resetPSSubSysSADEId();
        pSSubSysSADEFieldBase.resetPSSubSysSADEName();
        pSSubSysSADEFieldBase.resetPSSubSysServiceAPIId();
        pSSubSysSADEFieldBase.resetPSSysValueRuleId();
        pSSubSysSADEFieldBase.resetPSSysValueRuleName();
        pSSubSysSADEFieldBase.resetRefPSSubSysSADEId();
        pSSubSysSADEFieldBase.resetRefPSSubSysSADEName();
        pSSubSysSADEFieldBase.resetStdDataType();
        pSSubSysSADEFieldBase.resetUpdateDate();
        pSSubSysSADEFieldBase.resetUpdateMan();
        pSSubSysSADEFieldBase.resetUserCat();
        pSSubSysSADEFieldBase.resetUserTag();
        pSSubSysSADEFieldBase.resetUserTag2();
        pSSubSysSADEFieldBase.resetUserTag3();
        pSSubSysSADEFieldBase.resetUserTag4();
        pSSubSysSADEFieldBase.resetValidFlag();
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
        if (!bl || this.isExampleValueDirty()) {
            hashMap.put(FIELD_EXAMPLEVALUE, this.getExampleValue());
        }
        if (!bl || this.isFieldTagDirty()) {
            hashMap.put(FIELD_FIELDTAG, this.getFieldTag());
        }
        if (!bl || this.isFieldTag2Dirty()) {
            hashMap.put(FIELD_FIELDTAG2, this.getFieldTag2());
        }
        if (!bl || this.isFieldTypeDirty()) {
            hashMap.put(FIELD_FIELDTYPE, this.getFieldType());
        }
        if (!bl || this.isLengthDirty()) {
            hashMap.put(FIELD_LENGTH, this.getLength());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMajorFieldDirty()) {
            hashMap.put(FIELD_MAJORFIELD, this.getMajorField());
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPKeyDirty()) {
            hashMap.put(FIELD_PKEY, this.getPKey());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDataTypeIdDirty()) {
            hashMap.put(FIELD_PSDATATYPEID, this.getPSDataTypeId());
        }
        if (!bl || this.isPSDataTypeNameDirty()) {
            hashMap.put(FIELD_PSDATATYPENAME, this.getPSDataTypeName());
        }
        if (!bl || this.isPSSubSysSADEFieldIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEFIELDID, this.getPSSubSysSADEFieldId());
        }
        if (!bl || this.isPSSubSysSADEFieldNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEFIELDNAME, this.getPSSubSysSADEFieldName());
        }
        if (!bl || this.isPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEID, this.getPSSubSysSADEId());
        }
        if (!bl || this.isPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADENAME, this.getPSSubSysSADEName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
        }
        if (!bl || this.isRefPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_REFPSSUBSYSSADEID, this.getRefPSSubSysSADEId());
        }
        if (!bl || this.isRefPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_REFPSSUBSYSSADENAME, this.getRefPSSubSysSADEName());
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
        return PSSubSysSADEFieldBase.get(this, n);
    }

    private static Object get(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADEFieldBase.getAllowEmpty();
            }
            case 1: {
                return pSSubSysSADEFieldBase.getArrayFlag();
            }
            case 2: {
                return pSSubSysSADEFieldBase.getCodeName();
            }
            case 3: {
                return pSSubSysSADEFieldBase.getCodeName2();
            }
            case 4: {
                return pSSubSysSADEFieldBase.getCreateDate();
            }
            case 5: {
                return pSSubSysSADEFieldBase.getCreateMan();
            }
            case 6: {
                return pSSubSysSADEFieldBase.getDefaultValue();
            }
            case 7: {
                return pSSubSysSADEFieldBase.getExampleValue();
            }
            case 8: {
                return pSSubSysSADEFieldBase.getFieldTag();
            }
            case 9: {
                return pSSubSysSADEFieldBase.getFieldTag2();
            }
            case 10: {
                return pSSubSysSADEFieldBase.getFieldType();
            }
            case 11: {
                return pSSubSysSADEFieldBase.getLength();
            }
            case 12: {
                return pSSubSysSADEFieldBase.getLogicName();
            }
            case 13: {
                return pSSubSysSADEFieldBase.getMajorField();
            }
            case 14: {
                return pSSubSysSADEFieldBase.getMaxValue();
            }
            case 15: {
                return pSSubSysSADEFieldBase.getMemo();
            }
            case 16: {
                return pSSubSysSADEFieldBase.getMinStrLength();
            }
            case 17: {
                return pSSubSysSADEFieldBase.getMinValue();
            }
            case 18: {
                return pSSubSysSADEFieldBase.getOrderValue();
            }
            case 19: {
                return pSSubSysSADEFieldBase.getPKey();
            }
            case 20: {
                return pSSubSysSADEFieldBase.getPrecision2();
            }
            case 21: {
                return pSSubSysSADEFieldBase.getPredefinedType();
            }
            case 22: {
                return pSSubSysSADEFieldBase.getPSCodeListId();
            }
            case 23: {
                return pSSubSysSADEFieldBase.getPSCodeListName();
            }
            case 24: {
                return pSSubSysSADEFieldBase.getPSDataTypeId();
            }
            case 25: {
                return pSSubSysSADEFieldBase.getPSDataTypeName();
            }
            case 26: {
                return pSSubSysSADEFieldBase.getPSSubSysSADEFieldId();
            }
            case 27: {
                return pSSubSysSADEFieldBase.getPSSubSysSADEFieldName();
            }
            case 28: {
                return pSSubSysSADEFieldBase.getPSSubSysSADEId();
            }
            case 29: {
                return pSSubSysSADEFieldBase.getPSSubSysSADEName();
            }
            case 30: {
                return pSSubSysSADEFieldBase.getPSSubSysServiceAPIId();
            }
            case 31: {
                return pSSubSysSADEFieldBase.getPSSysValueRuleId();
            }
            case 32: {
                return pSSubSysSADEFieldBase.getPSSysValueRuleName();
            }
            case 33: {
                return pSSubSysSADEFieldBase.getRefPSSubSysSADEId();
            }
            case 34: {
                return pSSubSysSADEFieldBase.getRefPSSubSysSADEName();
            }
            case 35: {
                return pSSubSysSADEFieldBase.getStdDataType();
            }
            case 36: {
                return pSSubSysSADEFieldBase.getUpdateDate();
            }
            case 37: {
                return pSSubSysSADEFieldBase.getUpdateMan();
            }
            case 38: {
                return pSSubSysSADEFieldBase.getUserCat();
            }
            case 39: {
                return pSSubSysSADEFieldBase.getUserTag();
            }
            case 40: {
                return pSSubSysSADEFieldBase.getUserTag2();
            }
            case 41: {
                return pSSubSysSADEFieldBase.getUserTag3();
            }
            case 42: {
                return pSSubSysSADEFieldBase.getUserTag4();
            }
            case 43: {
                return pSSubSysSADEFieldBase.getValidFlag();
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
        PSSubSysSADEFieldBase.set(this, n, object);
    }

    private static void set(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADEFieldBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysSADEFieldBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysSADEFieldBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysSADEFieldBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysSADEFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysSADEFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysSADEFieldBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysSADEFieldBase.setExampleValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysSADEFieldBase.setFieldTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysSADEFieldBase.setFieldTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysSADEFieldBase.setFieldType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysSADEFieldBase.setLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysSADEFieldBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysSADEFieldBase.setMajorField(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysSADEFieldBase.setMaxValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubSysSADEFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSubSysSADEFieldBase.setMinStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSubSysSADEFieldBase.setMinValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSubSysSADEFieldBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSubSysSADEFieldBase.setPKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSubSysSADEFieldBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSubSysSADEFieldBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSubSysSADEFieldBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSubSysSADEFieldBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSubSysSADEFieldBase.setPSDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSubSysSADEFieldBase.setPSDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSubSysSADEFieldBase.setPSSubSysSADEFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSubSysSADEFieldBase.setPSSubSysSADEFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSubSysSADEFieldBase.setPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSubSysSADEFieldBase.setPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSubSysSADEFieldBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSubSysSADEFieldBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSubSysSADEFieldBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSubSysSADEFieldBase.setRefPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSubSysSADEFieldBase.setRefPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSubSysSADEFieldBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSubSysSADEFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSSubSysSADEFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSubSysSADEFieldBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSubSysSADEFieldBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSubSysSADEFieldBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSubSysSADEFieldBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSubSysSADEFieldBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSubSysSADEFieldBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSubSysSADEFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADEFieldBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSSubSysSADEFieldBase.getArrayFlag() == null;
            }
            case 2: {
                return pSSubSysSADEFieldBase.getCodeName() == null;
            }
            case 3: {
                return pSSubSysSADEFieldBase.getCodeName2() == null;
            }
            case 4: {
                return pSSubSysSADEFieldBase.getCreateDate() == null;
            }
            case 5: {
                return pSSubSysSADEFieldBase.getCreateMan() == null;
            }
            case 6: {
                return pSSubSysSADEFieldBase.getDefaultValue() == null;
            }
            case 7: {
                return pSSubSysSADEFieldBase.getExampleValue() == null;
            }
            case 8: {
                return pSSubSysSADEFieldBase.getFieldTag() == null;
            }
            case 9: {
                return pSSubSysSADEFieldBase.getFieldTag2() == null;
            }
            case 10: {
                return pSSubSysSADEFieldBase.getFieldType() == null;
            }
            case 11: {
                return pSSubSysSADEFieldBase.getLength() == null;
            }
            case 12: {
                return pSSubSysSADEFieldBase.getLogicName() == null;
            }
            case 13: {
                return pSSubSysSADEFieldBase.getMajorField() == null;
            }
            case 14: {
                return pSSubSysSADEFieldBase.getMaxValue() == null;
            }
            case 15: {
                return pSSubSysSADEFieldBase.getMemo() == null;
            }
            case 16: {
                return pSSubSysSADEFieldBase.getMinStrLength() == null;
            }
            case 17: {
                return pSSubSysSADEFieldBase.getMinValue() == null;
            }
            case 18: {
                return pSSubSysSADEFieldBase.getOrderValue() == null;
            }
            case 19: {
                return pSSubSysSADEFieldBase.getPKey() == null;
            }
            case 20: {
                return pSSubSysSADEFieldBase.getPrecision2() == null;
            }
            case 21: {
                return pSSubSysSADEFieldBase.getPredefinedType() == null;
            }
            case 22: {
                return pSSubSysSADEFieldBase.getPSCodeListId() == null;
            }
            case 23: {
                return pSSubSysSADEFieldBase.getPSCodeListName() == null;
            }
            case 24: {
                return pSSubSysSADEFieldBase.getPSDataTypeId() == null;
            }
            case 25: {
                return pSSubSysSADEFieldBase.getPSDataTypeName() == null;
            }
            case 26: {
                return pSSubSysSADEFieldBase.getPSSubSysSADEFieldId() == null;
            }
            case 27: {
                return pSSubSysSADEFieldBase.getPSSubSysSADEFieldName() == null;
            }
            case 28: {
                return pSSubSysSADEFieldBase.getPSSubSysSADEId() == null;
            }
            case 29: {
                return pSSubSysSADEFieldBase.getPSSubSysSADEName() == null;
            }
            case 30: {
                return pSSubSysSADEFieldBase.getPSSubSysServiceAPIId() == null;
            }
            case 31: {
                return pSSubSysSADEFieldBase.getPSSysValueRuleId() == null;
            }
            case 32: {
                return pSSubSysSADEFieldBase.getPSSysValueRuleName() == null;
            }
            case 33: {
                return pSSubSysSADEFieldBase.getRefPSSubSysSADEId() == null;
            }
            case 34: {
                return pSSubSysSADEFieldBase.getRefPSSubSysSADEName() == null;
            }
            case 35: {
                return pSSubSysSADEFieldBase.getStdDataType() == null;
            }
            case 36: {
                return pSSubSysSADEFieldBase.getUpdateDate() == null;
            }
            case 37: {
                return pSSubSysSADEFieldBase.getUpdateMan() == null;
            }
            case 38: {
                return pSSubSysSADEFieldBase.getUserCat() == null;
            }
            case 39: {
                return pSSubSysSADEFieldBase.getUserTag() == null;
            }
            case 40: {
                return pSSubSysSADEFieldBase.getUserTag2() == null;
            }
            case 41: {
                return pSSubSysSADEFieldBase.getUserTag3() == null;
            }
            case 42: {
                return pSSubSysSADEFieldBase.getUserTag4() == null;
            }
            case 43: {
                return pSSubSysSADEFieldBase.getValidFlag() == null;
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
        return PSSubSysSADEFieldBase.contains(this, n);
    }

    private static boolean contains(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADEFieldBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSSubSysSADEFieldBase.isArrayFlagDirty();
            }
            case 2: {
                return pSSubSysSADEFieldBase.isCodeNameDirty();
            }
            case 3: {
                return pSSubSysSADEFieldBase.isCodeName2Dirty();
            }
            case 4: {
                return pSSubSysSADEFieldBase.isCreateDateDirty();
            }
            case 5: {
                return pSSubSysSADEFieldBase.isCreateManDirty();
            }
            case 6: {
                return pSSubSysSADEFieldBase.isDefaultValueDirty();
            }
            case 7: {
                return pSSubSysSADEFieldBase.isExampleValueDirty();
            }
            case 8: {
                return pSSubSysSADEFieldBase.isFieldTagDirty();
            }
            case 9: {
                return pSSubSysSADEFieldBase.isFieldTag2Dirty();
            }
            case 10: {
                return pSSubSysSADEFieldBase.isFieldTypeDirty();
            }
            case 11: {
                return pSSubSysSADEFieldBase.isLengthDirty();
            }
            case 12: {
                return pSSubSysSADEFieldBase.isLogicNameDirty();
            }
            case 13: {
                return pSSubSysSADEFieldBase.isMajorFieldDirty();
            }
            case 14: {
                return pSSubSysSADEFieldBase.isMaxValueDirty();
            }
            case 15: {
                return pSSubSysSADEFieldBase.isMemoDirty();
            }
            case 16: {
                return pSSubSysSADEFieldBase.isMinStrLengthDirty();
            }
            case 17: {
                return pSSubSysSADEFieldBase.isMinValueDirty();
            }
            case 18: {
                return pSSubSysSADEFieldBase.isOrderValueDirty();
            }
            case 19: {
                return pSSubSysSADEFieldBase.isPKeyDirty();
            }
            case 20: {
                return pSSubSysSADEFieldBase.isPrecision2Dirty();
            }
            case 21: {
                return pSSubSysSADEFieldBase.isPredefinedTypeDirty();
            }
            case 22: {
                return pSSubSysSADEFieldBase.isPSCodeListIdDirty();
            }
            case 23: {
                return pSSubSysSADEFieldBase.isPSCodeListNameDirty();
            }
            case 24: {
                return pSSubSysSADEFieldBase.isPSDataTypeIdDirty();
            }
            case 25: {
                return pSSubSysSADEFieldBase.isPSDataTypeNameDirty();
            }
            case 26: {
                return pSSubSysSADEFieldBase.isPSSubSysSADEFieldIdDirty();
            }
            case 27: {
                return pSSubSysSADEFieldBase.isPSSubSysSADEFieldNameDirty();
            }
            case 28: {
                return pSSubSysSADEFieldBase.isPSSubSysSADEIdDirty();
            }
            case 29: {
                return pSSubSysSADEFieldBase.isPSSubSysSADENameDirty();
            }
            case 30: {
                return pSSubSysSADEFieldBase.isPSSubSysServiceAPIIdDirty();
            }
            case 31: {
                return pSSubSysSADEFieldBase.isPSSysValueRuleIdDirty();
            }
            case 32: {
                return pSSubSysSADEFieldBase.isPSSysValueRuleNameDirty();
            }
            case 33: {
                return pSSubSysSADEFieldBase.isRefPSSubSysSADEIdDirty();
            }
            case 34: {
                return pSSubSysSADEFieldBase.isRefPSSubSysSADENameDirty();
            }
            case 35: {
                return pSSubSysSADEFieldBase.isStdDataTypeDirty();
            }
            case 36: {
                return pSSubSysSADEFieldBase.isUpdateDateDirty();
            }
            case 37: {
                return pSSubSysSADEFieldBase.isUpdateManDirty();
            }
            case 38: {
                return pSSubSysSADEFieldBase.isUserCatDirty();
            }
            case 39: {
                return pSSubSysSADEFieldBase.isUserTagDirty();
            }
            case 40: {
                return pSSubSysSADEFieldBase.isUserTag2Dirty();
            }
            case 41: {
                return pSSubSysSADEFieldBase.isUserTag3Dirty();
            }
            case 42: {
                return pSSubSysSADEFieldBase.isUserTag4Dirty();
            }
            case 43: {
                return pSSubSysSADEFieldBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysSADEFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysSADEFieldBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getExampleValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"examplevalue", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getExampleValue()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getFieldTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtag", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getFieldTag()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getFieldTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtag2", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getFieldTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getFieldType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtype", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getFieldType()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"length", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getLength()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getMajorField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorfield", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getMajorField()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvalue", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getMaxValue()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getMinStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minstrlength", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getMinStrLength()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvalue", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getMinValue()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkey", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPKey()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatatypeid", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSDataTypeId()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatatypename", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSDataTypeName()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysSADEFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadefieldid", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSSubSysSADEFieldId()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysSADEFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadefieldname", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSSubSysSADEFieldName()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadeid", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadename", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getRefPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssubsyssadeid", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getRefPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getRefPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssubsyssadename", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getRefPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSubSysSADEFieldBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSubSysSADEFieldBase.getJSONValue((Object)pSSubSysSADEFieldBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysSADEFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysSADEFieldBase.getAllowEmpty() != null) {
            object = pSSubSysSADEFieldBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getArrayFlag() != null) {
            object = pSSubSysSADEFieldBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getCodeName() != null) {
            object = pSSubSysSADEFieldBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getCodeName2() != null) {
            object = pSSubSysSADEFieldBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getCreateDate() != null) {
            object = pSSubSysSADEFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getCreateMan() != null) {
            object = pSSubSysSADEFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getDefaultValue() != null) {
            object = pSSubSysSADEFieldBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getExampleValue() != null) {
            object = pSSubSysSADEFieldBase.getExampleValue();
            xmlNode.setAttribute(FIELD_EXAMPLEVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getFieldTag() != null) {
            object = pSSubSysSADEFieldBase.getFieldTag();
            xmlNode.setAttribute(FIELD_FIELDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getFieldTag2() != null) {
            object = pSSubSysSADEFieldBase.getFieldTag2();
            xmlNode.setAttribute(FIELD_FIELDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getFieldType() != null) {
            object = pSSubSysSADEFieldBase.getFieldType();
            xmlNode.setAttribute(FIELD_FIELDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getLength() != null) {
            object = pSSubSysSADEFieldBase.getLength();
            xmlNode.setAttribute(FIELD_LENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getLogicName() != null) {
            object = pSSubSysSADEFieldBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getMajorField() != null) {
            object = pSSubSysSADEFieldBase.getMajorField();
            xmlNode.setAttribute(FIELD_MAJORFIELD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getMaxValue() != null) {
            object = pSSubSysSADEFieldBase.getMaxValue();
            xmlNode.setAttribute(FIELD_MAXVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getMemo() != null) {
            object = pSSubSysSADEFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getMinStrLength() != null) {
            object = pSSubSysSADEFieldBase.getMinStrLength();
            xmlNode.setAttribute(FIELD_MINSTRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getMinValue() != null) {
            object = pSSubSysSADEFieldBase.getMinValue();
            xmlNode.setAttribute(FIELD_MINVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getOrderValue() != null) {
            object = pSSubSysSADEFieldBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getPKey() != null) {
            object = pSSubSysSADEFieldBase.getPKey();
            xmlNode.setAttribute(FIELD_PKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getPrecision2() != null) {
            object = pSSubSysSADEFieldBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getPredefinedType() != null) {
            object = pSSubSysSADEFieldBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSCodeListId() != null) {
            object = pSSubSysSADEFieldBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSCodeListName() != null) {
            object = pSSubSysSADEFieldBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSDataTypeId() != null) {
            object = pSSubSysSADEFieldBase.getPSDataTypeId();
            xmlNode.setAttribute(FIELD_PSDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSDataTypeName() != null) {
            object = pSSubSysSADEFieldBase.getPSDataTypeName();
            xmlNode.setAttribute(FIELD_PSDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysSADEFieldId() != null) {
            object = pSSubSysSADEFieldBase.getPSSubSysSADEFieldId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysSADEFieldName() != null) {
            object = pSSubSysSADEFieldBase.getPSSubSysSADEFieldName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysSADEId() != null) {
            object = pSSubSysSADEFieldBase.getPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysSADEName() != null) {
            object = pSSubSysSADEFieldBase.getPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSubSysServiceAPIId() != null) {
            object = pSSubSysSADEFieldBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSysValueRuleId() != null) {
            object = pSSubSysSADEFieldBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getPSSysValueRuleName() != null) {
            object = pSSubSysSADEFieldBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getRefPSSubSysSADEId() != null) {
            object = pSSubSysSADEFieldBase.getRefPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_REFPSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getRefPSSubSysSADEName() != null) {
            object = pSSubSysSADEFieldBase.getRefPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_REFPSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getStdDataType() != null) {
            object = pSSubSysSADEFieldBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getUpdateDate() != null) {
            object = pSSubSysSADEFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADEFieldBase.getUpdateMan() != null) {
            object = pSSubSysSADEFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getUserCat() != null) {
            object = pSSubSysSADEFieldBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getUserTag() != null) {
            object = pSSubSysSADEFieldBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getUserTag2() != null) {
            object = pSSubSysSADEFieldBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getUserTag3() != null) {
            object = pSSubSysSADEFieldBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getUserTag4() != null) {
            object = pSSubSysSADEFieldBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADEFieldBase.getValidFlag() != null) {
            object = pSSubSysSADEFieldBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysSADEFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysSADEFieldBase.isAllowEmptyDirty() && (bl || pSSubSysSADEFieldBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSSubSysSADEFieldBase.getAllowEmpty());
        }
        if (pSSubSysSADEFieldBase.isArrayFlagDirty() && (bl || pSSubSysSADEFieldBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSSubSysSADEFieldBase.getArrayFlag());
        }
        if (pSSubSysSADEFieldBase.isCodeNameDirty() && (bl || pSSubSysSADEFieldBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubSysSADEFieldBase.getCodeName());
        }
        if (pSSubSysSADEFieldBase.isCodeName2Dirty() && (bl || pSSubSysSADEFieldBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSubSysSADEFieldBase.getCodeName2());
        }
        if (pSSubSysSADEFieldBase.isCreateDateDirty() && (bl || pSSubSysSADEFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysSADEFieldBase.getCreateDate());
        }
        if (pSSubSysSADEFieldBase.isCreateManDirty() && (bl || pSSubSysSADEFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysSADEFieldBase.getCreateMan());
        }
        if (pSSubSysSADEFieldBase.isDefaultValueDirty() && (bl || pSSubSysSADEFieldBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSSubSysSADEFieldBase.getDefaultValue());
        }
        if (pSSubSysSADEFieldBase.isExampleValueDirty() && (bl || pSSubSysSADEFieldBase.getExampleValue() != null)) {
            iDataObject.set(FIELD_EXAMPLEVALUE, (Object)pSSubSysSADEFieldBase.getExampleValue());
        }
        if (pSSubSysSADEFieldBase.isFieldTagDirty() && (bl || pSSubSysSADEFieldBase.getFieldTag() != null)) {
            iDataObject.set(FIELD_FIELDTAG, (Object)pSSubSysSADEFieldBase.getFieldTag());
        }
        if (pSSubSysSADEFieldBase.isFieldTag2Dirty() && (bl || pSSubSysSADEFieldBase.getFieldTag2() != null)) {
            iDataObject.set(FIELD_FIELDTAG2, (Object)pSSubSysSADEFieldBase.getFieldTag2());
        }
        if (pSSubSysSADEFieldBase.isFieldTypeDirty() && (bl || pSSubSysSADEFieldBase.getFieldType() != null)) {
            iDataObject.set(FIELD_FIELDTYPE, (Object)pSSubSysSADEFieldBase.getFieldType());
        }
        if (pSSubSysSADEFieldBase.isLengthDirty() && (bl || pSSubSysSADEFieldBase.getLength() != null)) {
            iDataObject.set(FIELD_LENGTH, (Object)pSSubSysSADEFieldBase.getLength());
        }
        if (pSSubSysSADEFieldBase.isLogicNameDirty() && (bl || pSSubSysSADEFieldBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSubSysSADEFieldBase.getLogicName());
        }
        if (pSSubSysSADEFieldBase.isMajorFieldDirty() && (bl || pSSubSysSADEFieldBase.getMajorField() != null)) {
            iDataObject.set(FIELD_MAJORFIELD, (Object)pSSubSysSADEFieldBase.getMajorField());
        }
        if (pSSubSysSADEFieldBase.isMaxValueDirty() && (bl || pSSubSysSADEFieldBase.getMaxValue() != null)) {
            iDataObject.set(FIELD_MAXVALUE, (Object)pSSubSysSADEFieldBase.getMaxValue());
        }
        if (pSSubSysSADEFieldBase.isMemoDirty() && (bl || pSSubSysSADEFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysSADEFieldBase.getMemo());
        }
        if (pSSubSysSADEFieldBase.isMinStrLengthDirty() && (bl || pSSubSysSADEFieldBase.getMinStrLength() != null)) {
            iDataObject.set(FIELD_MINSTRLENGTH, (Object)pSSubSysSADEFieldBase.getMinStrLength());
        }
        if (pSSubSysSADEFieldBase.isMinValueDirty() && (bl || pSSubSysSADEFieldBase.getMinValue() != null)) {
            iDataObject.set(FIELD_MINVALUE, (Object)pSSubSysSADEFieldBase.getMinValue());
        }
        if (pSSubSysSADEFieldBase.isOrderValueDirty() && (bl || pSSubSysSADEFieldBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSubSysSADEFieldBase.getOrderValue());
        }
        if (pSSubSysSADEFieldBase.isPKeyDirty() && (bl || pSSubSysSADEFieldBase.getPKey() != null)) {
            iDataObject.set(FIELD_PKEY, (Object)pSSubSysSADEFieldBase.getPKey());
        }
        if (pSSubSysSADEFieldBase.isPrecision2Dirty() && (bl || pSSubSysSADEFieldBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSSubSysSADEFieldBase.getPrecision2());
        }
        if (pSSubSysSADEFieldBase.isPredefinedTypeDirty() && (bl || pSSubSysSADEFieldBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSSubSysSADEFieldBase.getPredefinedType());
        }
        if (pSSubSysSADEFieldBase.isPSCodeListIdDirty() && (bl || pSSubSysSADEFieldBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSubSysSADEFieldBase.getPSCodeListId());
        }
        if (pSSubSysSADEFieldBase.isPSCodeListNameDirty() && (bl || pSSubSysSADEFieldBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSubSysSADEFieldBase.getPSCodeListName());
        }
        if (pSSubSysSADEFieldBase.isPSDataTypeIdDirty() && (bl || pSSubSysSADEFieldBase.getPSDataTypeId() != null)) {
            iDataObject.set(FIELD_PSDATATYPEID, (Object)pSSubSysSADEFieldBase.getPSDataTypeId());
        }
        if (pSSubSysSADEFieldBase.isPSDataTypeNameDirty() && (bl || pSSubSysSADEFieldBase.getPSDataTypeName() != null)) {
            iDataObject.set(FIELD_PSDATATYPENAME, (Object)pSSubSysSADEFieldBase.getPSDataTypeName());
        }
        if (pSSubSysSADEFieldBase.isPSSubSysSADEFieldIdDirty() && (bl || pSSubSysSADEFieldBase.getPSSubSysSADEFieldId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEFIELDID, (Object)pSSubSysSADEFieldBase.getPSSubSysSADEFieldId());
        }
        if (pSSubSysSADEFieldBase.isPSSubSysSADEFieldNameDirty() && (bl || pSSubSysSADEFieldBase.getPSSubSysSADEFieldName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEFIELDNAME, (Object)pSSubSysSADEFieldBase.getPSSubSysSADEFieldName());
        }
        if (pSSubSysSADEFieldBase.isPSSubSysSADEIdDirty() && (bl || pSSubSysSADEFieldBase.getPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEID, (Object)pSSubSysSADEFieldBase.getPSSubSysSADEId());
        }
        if (pSSubSysSADEFieldBase.isPSSubSysSADENameDirty() && (bl || pSSubSysSADEFieldBase.getPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADENAME, (Object)pSSubSysSADEFieldBase.getPSSubSysSADEName());
        }
        if (pSSubSysSADEFieldBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSubSysSADEFieldBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSubSysSADEFieldBase.getPSSubSysServiceAPIId());
        }
        if (pSSubSysSADEFieldBase.isPSSysValueRuleIdDirty() && (bl || pSSubSysSADEFieldBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSSubSysSADEFieldBase.getPSSysValueRuleId());
        }
        if (pSSubSysSADEFieldBase.isPSSysValueRuleNameDirty() && (bl || pSSubSysSADEFieldBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSSubSysSADEFieldBase.getPSSysValueRuleName());
        }
        if (pSSubSysSADEFieldBase.isRefPSSubSysSADEIdDirty() && (bl || pSSubSysSADEFieldBase.getRefPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_REFPSSUBSYSSADEID, (Object)pSSubSysSADEFieldBase.getRefPSSubSysSADEId());
        }
        if (pSSubSysSADEFieldBase.isRefPSSubSysSADENameDirty() && (bl || pSSubSysSADEFieldBase.getRefPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_REFPSSUBSYSSADENAME, (Object)pSSubSysSADEFieldBase.getRefPSSubSysSADEName());
        }
        if (pSSubSysSADEFieldBase.isStdDataTypeDirty() && (bl || pSSubSysSADEFieldBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSubSysSADEFieldBase.getStdDataType());
        }
        if (pSSubSysSADEFieldBase.isUpdateDateDirty() && (bl || pSSubSysSADEFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysSADEFieldBase.getUpdateDate());
        }
        if (pSSubSysSADEFieldBase.isUpdateManDirty() && (bl || pSSubSysSADEFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysSADEFieldBase.getUpdateMan());
        }
        if (pSSubSysSADEFieldBase.isUserCatDirty() && (bl || pSSubSysSADEFieldBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSubSysSADEFieldBase.getUserCat());
        }
        if (pSSubSysSADEFieldBase.isUserTagDirty() && (bl || pSSubSysSADEFieldBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSubSysSADEFieldBase.getUserTag());
        }
        if (pSSubSysSADEFieldBase.isUserTag2Dirty() && (bl || pSSubSysSADEFieldBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSubSysSADEFieldBase.getUserTag2());
        }
        if (pSSubSysSADEFieldBase.isUserTag3Dirty() && (bl || pSSubSysSADEFieldBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSubSysSADEFieldBase.getUserTag3());
        }
        if (pSSubSysSADEFieldBase.isUserTag4Dirty() && (bl || pSSubSysSADEFieldBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSubSysSADEFieldBase.getUserTag4());
        }
        if (pSSubSysSADEFieldBase.isValidFlagDirty() && (bl || pSSubSysSADEFieldBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSubSysSADEFieldBase.getValidFlag());
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
        return PSSubSysSADEFieldBase.remove(this, n);
    }

    private static boolean remove(PSSubSysSADEFieldBase pSSubSysSADEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADEFieldBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSSubSysSADEFieldBase.resetArrayFlag();
                return true;
            }
            case 2: {
                pSSubSysSADEFieldBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSubSysSADEFieldBase.resetCodeName2();
                return true;
            }
            case 4: {
                pSSubSysSADEFieldBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSubSysSADEFieldBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSubSysSADEFieldBase.resetDefaultValue();
                return true;
            }
            case 7: {
                pSSubSysSADEFieldBase.resetExampleValue();
                return true;
            }
            case 8: {
                pSSubSysSADEFieldBase.resetFieldTag();
                return true;
            }
            case 9: {
                pSSubSysSADEFieldBase.resetFieldTag2();
                return true;
            }
            case 10: {
                pSSubSysSADEFieldBase.resetFieldType();
                return true;
            }
            case 11: {
                pSSubSysSADEFieldBase.resetLength();
                return true;
            }
            case 12: {
                pSSubSysSADEFieldBase.resetLogicName();
                return true;
            }
            case 13: {
                pSSubSysSADEFieldBase.resetMajorField();
                return true;
            }
            case 14: {
                pSSubSysSADEFieldBase.resetMaxValue();
                return true;
            }
            case 15: {
                pSSubSysSADEFieldBase.resetMemo();
                return true;
            }
            case 16: {
                pSSubSysSADEFieldBase.resetMinStrLength();
                return true;
            }
            case 17: {
                pSSubSysSADEFieldBase.resetMinValue();
                return true;
            }
            case 18: {
                pSSubSysSADEFieldBase.resetOrderValue();
                return true;
            }
            case 19: {
                pSSubSysSADEFieldBase.resetPKey();
                return true;
            }
            case 20: {
                pSSubSysSADEFieldBase.resetPrecision2();
                return true;
            }
            case 21: {
                pSSubSysSADEFieldBase.resetPredefinedType();
                return true;
            }
            case 22: {
                pSSubSysSADEFieldBase.resetPSCodeListId();
                return true;
            }
            case 23: {
                pSSubSysSADEFieldBase.resetPSCodeListName();
                return true;
            }
            case 24: {
                pSSubSysSADEFieldBase.resetPSDataTypeId();
                return true;
            }
            case 25: {
                pSSubSysSADEFieldBase.resetPSDataTypeName();
                return true;
            }
            case 26: {
                pSSubSysSADEFieldBase.resetPSSubSysSADEFieldId();
                return true;
            }
            case 27: {
                pSSubSysSADEFieldBase.resetPSSubSysSADEFieldName();
                return true;
            }
            case 28: {
                pSSubSysSADEFieldBase.resetPSSubSysSADEId();
                return true;
            }
            case 29: {
                pSSubSysSADEFieldBase.resetPSSubSysSADEName();
                return true;
            }
            case 30: {
                pSSubSysSADEFieldBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 31: {
                pSSubSysSADEFieldBase.resetPSSysValueRuleId();
                return true;
            }
            case 32: {
                pSSubSysSADEFieldBase.resetPSSysValueRuleName();
                return true;
            }
            case 33: {
                pSSubSysSADEFieldBase.resetRefPSSubSysSADEId();
                return true;
            }
            case 34: {
                pSSubSysSADEFieldBase.resetRefPSSubSysSADEName();
                return true;
            }
            case 35: {
                pSSubSysSADEFieldBase.resetStdDataType();
                return true;
            }
            case 36: {
                pSSubSysSADEFieldBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSSubSysSADEFieldBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSSubSysSADEFieldBase.resetUserCat();
                return true;
            }
            case 39: {
                pSSubSysSADEFieldBase.resetUserTag();
                return true;
            }
            case 40: {
                pSSubSysSADEFieldBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSSubSysSADEFieldBase.resetUserTag3();
                return true;
            }
            case 42: {
                pSSubSysSADEFieldBase.resetUserTag4();
                return true;
            }
            case 43: {
                pSSubSysSADEFieldBase.resetValidFlag();
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
    public PSDEFDataType getPSDataType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataType();
        }
        if (this.getPSDataTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDataTypeLock;
        synchronized (n) {
            if (this.psdatatype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDataTypeId(), (Object)this.psdatatype.getPSDEFDataTypeId()) != 0L) {
                this.psdatatype = null;
            }
            if (this.psdatatype == null) {
                PSDEFDataType pSDEFDataType = new PSDEFDataType();
                pSDEFDataType.setPSDEFDataTypeId(this.getPSDataTypeId());
                PSDEFDataTypeService pSDEFDataTypeService = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFDataTypeService.autoGet((IEntity)pSDEFDataType);
                this.psdatatype = pSDEFDataType;
            }
            return this.psdatatype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADE();
        }
        if (this.getPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysSADELock;
        synchronized (n) {
            if (this.pssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysSADEId(), (Object)this.pssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.pssubsyssade = null;
            }
            if (this.pssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet((IEntity)pSSubSysSADE);
                this.pssubsyssade = pSSubSysSADE;
            }
            return this.pssubsyssade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getRefPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSubSysSADE();
        }
        if (this.getRefPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objRefPSSubSysSADELock;
        synchronized (n) {
            if (this.refpssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSubSysSADEId(), (Object)this.refpssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.refpssubsyssade = null;
            }
            if (this.refpssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getRefPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet((IEntity)pSSubSysSADE);
                this.refpssubsyssade = pSSubSysSADE;
            }
            return this.refpssubsyssade;
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

    private PSSubSysSADEFieldBase getProxyEntity() {
        return this.proxyPSSubSysSADEFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysSADEFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysSADEFieldBase) {
            this.proxyPSSubSysSADEFieldBase = (PSSubSysSADEFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_ARRAYFLAG, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CODENAME2, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 6);
        fieldIndexMap.put(FIELD_EXAMPLEVALUE, 7);
        fieldIndexMap.put(FIELD_FIELDTAG, 8);
        fieldIndexMap.put(FIELD_FIELDTAG2, 9);
        fieldIndexMap.put(FIELD_FIELDTYPE, 10);
        fieldIndexMap.put(FIELD_LENGTH, 11);
        fieldIndexMap.put(FIELD_LOGICNAME, 12);
        fieldIndexMap.put(FIELD_MAJORFIELD, 13);
        fieldIndexMap.put(FIELD_MAXVALUE, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_MINSTRLENGTH, 16);
        fieldIndexMap.put(FIELD_MINVALUE, 17);
        fieldIndexMap.put(FIELD_ORDERVALUE, 18);
        fieldIndexMap.put(FIELD_PKEY, 19);
        fieldIndexMap.put(FIELD_PRECISION2, 20);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 21);
        fieldIndexMap.put(FIELD_PSCODELISTID, 22);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 23);
        fieldIndexMap.put(FIELD_PSDATATYPEID, 24);
        fieldIndexMap.put(FIELD_PSDATATYPENAME, 25);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEFIELDID, 26);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEFIELDNAME, 27);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEID, 28);
        fieldIndexMap.put(FIELD_PSSUBSYSSADENAME, 29);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 30);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 31);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 32);
        fieldIndexMap.put(FIELD_REFPSSUBSYSSADEID, 33);
        fieldIndexMap.put(FIELD_REFPSSUBSYSSADENAME, 34);
        fieldIndexMap.put(FIELD_STDDATATYPE, 35);
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

