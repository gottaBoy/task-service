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
package net.ibizsys.pscore.srv.search.entity;

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
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDocService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSearchFieldBase.class);
    public static final String FIELD_ANALYZER = "ANALYZER";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATEFORMAT = "DATEFORMAT";
    public static final String FIELD_FIELDDATAFLAG = "FIELDDATAFLAG";
    public static final String FIELD_FIELDPARAMS = "FIELDPARAMS";
    public static final String FIELD_FIELDTAG = "FIELDTAG";
    public static final String FIELD_FIELDTAG2 = "FIELDTAG2";
    public static final String FIELD_FIELDTYPE = "FIELDTYPE";
    public static final String FIELD_IGNOREFIELDS = "IGNOREFIELDS";
    public static final String FIELD_INCINPARENTFLAG = "INCINPARENTFLAG";
    public static final String FIELD_INDEXFLAG = "INDEXFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PATTERN = "PATTERN";
    public static final String FIELD_PKEY = "PKEY";
    public static final String FIELD_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String FIELD_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String FIELD_PSSYSSEARCHFIELDID = "PSSYSSEARCHFIELDID";
    public static final String FIELD_PSSYSSEARCHFIELDNAME = "PSSYSSEARCHFIELDNAME";
    public static final String FIELD_SEARCHANALYZER = "SEARCHANALYZER";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_STOREFLAG = "STOREFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ANALYZER = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DATEFORMAT = 4;
    private static final int INDEX_FIELDDATAFLAG = 5;
    private static final int INDEX_FIELDPARAMS = 6;
    private static final int INDEX_FIELDTAG = 7;
    private static final int INDEX_FIELDTAG2 = 8;
    private static final int INDEX_FIELDTYPE = 9;
    private static final int INDEX_IGNOREFIELDS = 10;
    private static final int INDEX_INCINPARENTFLAG = 11;
    private static final int INDEX_INDEXFLAG = 12;
    private static final int INDEX_LOGICNAME = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_PATTERN = 16;
    private static final int INDEX_PKEY = 17;
    private static final int INDEX_PSSYSSEARCHDOCID = 18;
    private static final int INDEX_PSSYSSEARCHDOCNAME = 19;
    private static final int INDEX_PSSYSSEARCHFIELDID = 20;
    private static final int INDEX_PSSYSSEARCHFIELDNAME = 21;
    private static final int INDEX_SEARCHANALYZER = 22;
    private static final int INDEX_STDDATATYPE = 23;
    private static final int INDEX_STOREFLAG = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_USERCAT = 27;
    private static final int INDEX_USERTAG = 28;
    private static final int INDEX_USERTAG2 = 29;
    private static final int INDEX_USERTAG3 = 30;
    private static final int INDEX_USERTAG4 = 31;
    private static final int INDEX_VALIDFLAG = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSearchFieldBase proxyPSSysSearchFieldBase = null;
    private boolean analyzerDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dateformatDirtyFlag = false;
    private boolean fielddataflagDirtyFlag = false;
    private boolean fieldparamsDirtyFlag = false;
    private boolean fieldtagDirtyFlag = false;
    private boolean fieldtag2DirtyFlag = false;
    private boolean fieldtypeDirtyFlag = false;
    private boolean ignorefieldsDirtyFlag = false;
    private boolean incinparentflagDirtyFlag = false;
    private boolean indexflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean patternDirtyFlag = false;
    private boolean pkeyDirtyFlag = false;
    private boolean pssyssearchdocidDirtyFlag = false;
    private boolean pssyssearchdocnameDirtyFlag = false;
    private boolean pssyssearchfieldidDirtyFlag = false;
    private boolean pssyssearchfieldnameDirtyFlag = false;
    private boolean searchanalyzerDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean storeflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="analyzer")
    private String analyzer;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dateformat")
    private String dateformat;
    @Column(name="fielddataflag")
    private Integer fielddataflag;
    @Column(name="fieldparams")
    private String fieldparams;
    @Column(name="fieldtag")
    private String fieldtag;
    @Column(name="fieldtag2")
    private String fieldtag2;
    @Column(name="fieldtype")
    private String fieldtype;
    @Column(name="ignorefields")
    private String ignorefields;
    @Column(name="incinparentflag")
    private Integer incinparentflag;
    @Column(name="indexflag")
    private Integer indexflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pattern")
    private String pattern;
    @Column(name="pkey")
    private Integer pkey;
    @Column(name="pssyssearchdocid")
    private String pssyssearchdocid;
    @Column(name="pssyssearchdocname")
    private String pssyssearchdocname;
    @Column(name="pssyssearchfieldid")
    private String pssyssearchfieldid;
    @Column(name="pssyssearchfieldname")
    private String pssyssearchfieldname;
    @Column(name="searchanalyzer")
    private String searchanalyzer;
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="storeflag")
    private Integer storeflag;
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
    private Integer objPSSysSearchDocLock = new Integer(1);
    private PSSysSearchDoc pssyssearchdoc = null;

    public void setAnalyzer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAnalyzer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.analyzer = string;
        this.analyzerDirtyFlag = true;
    }

    public String getAnalyzer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAnalyzer();
        }
        return this.analyzer;
    }

    public boolean isAnalyzerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAnalyzerDirty();
        }
        return this.analyzerDirtyFlag;
    }

    public void resetAnalyzer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAnalyzer();
            return;
        }
        this.analyzerDirtyFlag = false;
        this.analyzer = null;
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

    public void setDateFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDateFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dateformat = string;
        this.dateformatDirtyFlag = true;
    }

    public String getDateFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDateFormat();
        }
        return this.dateformat;
    }

    public boolean isDateFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDateFormatDirty();
        }
        return this.dateformatDirtyFlag;
    }

    public void resetDateFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDateFormat();
            return;
        }
        this.dateformatDirtyFlag = false;
        this.dateformat = null;
    }

    public void setFieldDataFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldDataFlag(n);
            return;
        }
        this.fielddataflag = n;
        this.fielddataflagDirtyFlag = true;
    }

    public Integer getFieldDataFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldDataFlag();
        }
        return this.fielddataflag;
    }

    public boolean isFieldDataFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldDataFlagDirty();
        }
        return this.fielddataflagDirtyFlag;
    }

    public void resetFieldDataFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldDataFlag();
            return;
        }
        this.fielddataflagDirtyFlag = false;
        this.fielddataflag = null;
    }

    public void setFieldParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldparams = string;
        this.fieldparamsDirtyFlag = true;
    }

    public String getFieldParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldParams();
        }
        return this.fieldparams;
    }

    public boolean isFieldParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldParamsDirty();
        }
        return this.fieldparamsDirtyFlag;
    }

    public void resetFieldParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldParams();
            return;
        }
        this.fieldparamsDirtyFlag = false;
        this.fieldparams = null;
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

    public void setIgnoreFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ignorefields = string;
        this.ignorefieldsDirtyFlag = true;
    }

    public String getIgnoreFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreFields();
        }
        return this.ignorefields;
    }

    public boolean isIgnoreFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreFieldsDirty();
        }
        return this.ignorefieldsDirtyFlag;
    }

    public void resetIgnoreFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreFields();
            return;
        }
        this.ignorefieldsDirtyFlag = false;
        this.ignorefields = null;
    }

    public void setIncInParentFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncInParentFlag(n);
            return;
        }
        this.incinparentflag = n;
        this.incinparentflagDirtyFlag = true;
    }

    public Integer getIncInParentFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncInParentFlag();
        }
        return this.incinparentflag;
    }

    public boolean isIncInParentFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncInParentFlagDirty();
        }
        return this.incinparentflagDirtyFlag;
    }

    public void resetIncInParentFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncInParentFlag();
            return;
        }
        this.incinparentflagDirtyFlag = false;
        this.incinparentflag = null;
    }

    public void setIndexFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexFlag(n);
            return;
        }
        this.indexflag = n;
        this.indexflagDirtyFlag = true;
    }

    public Integer getIndexFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexFlag();
        }
        return this.indexflag;
    }

    public boolean isIndexFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexFlagDirty();
        }
        return this.indexflagDirtyFlag;
    }

    public void resetIndexFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexFlag();
            return;
        }
        this.indexflagDirtyFlag = false;
        this.indexflag = null;
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

    public void setPattern(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPattern(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pattern = string;
        this.patternDirtyFlag = true;
    }

    public String getPattern() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPattern();
        }
        return this.pattern;
    }

    public boolean isPatternDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPatternDirty();
        }
        return this.patternDirtyFlag;
    }

    public void resetPattern() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPattern();
            return;
        }
        this.patternDirtyFlag = false;
        this.pattern = null;
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

    public void setPSSysSearchDocId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocid = string;
        this.pssyssearchdocidDirtyFlag = true;
    }

    public String getPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocId();
        }
        return this.pssyssearchdocid;
    }

    public boolean isPSSysSearchDocIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocIdDirty();
        }
        return this.pssyssearchdocidDirtyFlag;
    }

    public void resetPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocId();
            return;
        }
        this.pssyssearchdocidDirtyFlag = false;
        this.pssyssearchdocid = null;
    }

    public void setPSSysSearchDocName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocname = string;
        this.pssyssearchdocnameDirtyFlag = true;
    }

    public String getPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocName();
        }
        return this.pssyssearchdocname;
    }

    public boolean isPSSysSearchDocNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocNameDirty();
        }
        return this.pssyssearchdocnameDirtyFlag;
    }

    public void resetPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocName();
            return;
        }
        this.pssyssearchdocnameDirtyFlag = false;
        this.pssyssearchdocname = null;
    }

    public void setPSSysSearchFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchfieldid = string;
        this.pssyssearchfieldidDirtyFlag = true;
    }

    public String getPSSysSearchFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchFieldId();
        }
        return this.pssyssearchfieldid;
    }

    public boolean isPSSysSearchFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchFieldIdDirty();
        }
        return this.pssyssearchfieldidDirtyFlag;
    }

    public void resetPSSysSearchFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchFieldId();
            return;
        }
        this.pssyssearchfieldidDirtyFlag = false;
        this.pssyssearchfieldid = null;
    }

    public void setPSSysSearchFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssyssearchfieldname = string;
        this.pssyssearchfieldnameDirtyFlag = true;
    }

    public String getPSSysSearchFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchFieldName();
        }
        return this.pssyssearchfieldname;
    }

    public boolean isPSSysSearchFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchFieldNameDirty();
        }
        return this.pssyssearchfieldnameDirtyFlag;
    }

    public void resetPSSysSearchFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchFieldName();
            return;
        }
        this.pssyssearchfieldnameDirtyFlag = false;
        this.pssyssearchfieldname = null;
    }

    public void setSearchAnalyzer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchAnalyzer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchanalyzer = string;
        this.searchanalyzerDirtyFlag = true;
    }

    public String getSearchAnalyzer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchAnalyzer();
        }
        return this.searchanalyzer;
    }

    public boolean isSearchAnalyzerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchAnalyzerDirty();
        }
        return this.searchanalyzerDirtyFlag;
    }

    public void resetSearchAnalyzer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchAnalyzer();
            return;
        }
        this.searchanalyzerDirtyFlag = false;
        this.searchanalyzer = null;
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

    public void setStoreFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStoreFlag(n);
            return;
        }
        this.storeflag = n;
        this.storeflagDirtyFlag = true;
    }

    public Integer getStoreFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStoreFlag();
        }
        return this.storeflag;
    }

    public boolean isStoreFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStoreFlagDirty();
        }
        return this.storeflagDirtyFlag;
    }

    public void resetStoreFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStoreFlag();
            return;
        }
        this.storeflagDirtyFlag = false;
        this.storeflag = null;
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
        PSSysSearchFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSearchFieldBase pSSysSearchFieldBase) {
        pSSysSearchFieldBase.resetAnalyzer();
        pSSysSearchFieldBase.resetCodeName();
        pSSysSearchFieldBase.resetCreateDate();
        pSSysSearchFieldBase.resetCreateMan();
        pSSysSearchFieldBase.resetDateFormat();
        pSSysSearchFieldBase.resetFieldDataFlag();
        pSSysSearchFieldBase.resetFieldParams();
        pSSysSearchFieldBase.resetFieldTag();
        pSSysSearchFieldBase.resetFieldTag2();
        pSSysSearchFieldBase.resetFieldType();
        pSSysSearchFieldBase.resetIgnoreFields();
        pSSysSearchFieldBase.resetIncInParentFlag();
        pSSysSearchFieldBase.resetIndexFlag();
        pSSysSearchFieldBase.resetLogicName();
        pSSysSearchFieldBase.resetMemo();
        pSSysSearchFieldBase.resetOrderValue();
        pSSysSearchFieldBase.resetPattern();
        pSSysSearchFieldBase.resetPKey();
        pSSysSearchFieldBase.resetPSSysSearchDocId();
        pSSysSearchFieldBase.resetPSSysSearchDocName();
        pSSysSearchFieldBase.resetPSSysSearchFieldId();
        pSSysSearchFieldBase.resetPSSysSearchFieldName();
        pSSysSearchFieldBase.resetSearchAnalyzer();
        pSSysSearchFieldBase.resetStdDataType();
        pSSysSearchFieldBase.resetStoreFlag();
        pSSysSearchFieldBase.resetUpdateDate();
        pSSysSearchFieldBase.resetUpdateMan();
        pSSysSearchFieldBase.resetUserCat();
        pSSysSearchFieldBase.resetUserTag();
        pSSysSearchFieldBase.resetUserTag2();
        pSSysSearchFieldBase.resetUserTag3();
        pSSysSearchFieldBase.resetUserTag4();
        pSSysSearchFieldBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAnalyzerDirty()) {
            hashMap.put(FIELD_ANALYZER, this.getAnalyzer());
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
        if (!bl || this.isDateFormatDirty()) {
            hashMap.put(FIELD_DATEFORMAT, this.getDateFormat());
        }
        if (!bl || this.isFieldDataFlagDirty()) {
            hashMap.put(FIELD_FIELDDATAFLAG, this.getFieldDataFlag());
        }
        if (!bl || this.isFieldParamsDirty()) {
            hashMap.put(FIELD_FIELDPARAMS, this.getFieldParams());
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
        if (!bl || this.isIgnoreFieldsDirty()) {
            hashMap.put(FIELD_IGNOREFIELDS, this.getIgnoreFields());
        }
        if (!bl || this.isIncInParentFlagDirty()) {
            hashMap.put(FIELD_INCINPARENTFLAG, this.getIncInParentFlag());
        }
        if (!bl || this.isIndexFlagDirty()) {
            hashMap.put(FIELD_INDEXFLAG, this.getIndexFlag());
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
        if (!bl || this.isPatternDirty()) {
            hashMap.put(FIELD_PATTERN, this.getPattern());
        }
        if (!bl || this.isPKeyDirty()) {
            hashMap.put(FIELD_PKEY, this.getPKey());
        }
        if (!bl || this.isPSSysSearchDocIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCID, this.getPSSysSearchDocId());
        }
        if (!bl || this.isPSSysSearchDocNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCNAME, this.getPSSysSearchDocName());
        }
        if (!bl || this.isPSSysSearchFieldIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHFIELDID, this.getPSSysSearchFieldId());
        }
        if (!bl || this.isPSSysSearchFieldNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHFIELDNAME, this.getPSSysSearchFieldName());
        }
        if (!bl || this.isSearchAnalyzerDirty()) {
            hashMap.put(FIELD_SEARCHANALYZER, this.getSearchAnalyzer());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
        }
        if (!bl || this.isStoreFlagDirty()) {
            hashMap.put(FIELD_STOREFLAG, this.getStoreFlag());
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
        return PSSysSearchFieldBase.get(this, n);
    }

    private static Object get(PSSysSearchFieldBase pSSysSearchFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchFieldBase.getAnalyzer();
            }
            case 1: {
                return pSSysSearchFieldBase.getCodeName();
            }
            case 2: {
                return pSSysSearchFieldBase.getCreateDate();
            }
            case 3: {
                return pSSysSearchFieldBase.getCreateMan();
            }
            case 4: {
                return pSSysSearchFieldBase.getDateFormat();
            }
            case 5: {
                return pSSysSearchFieldBase.getFieldDataFlag();
            }
            case 6: {
                return pSSysSearchFieldBase.getFieldParams();
            }
            case 7: {
                return pSSysSearchFieldBase.getFieldTag();
            }
            case 8: {
                return pSSysSearchFieldBase.getFieldTag2();
            }
            case 9: {
                return pSSysSearchFieldBase.getFieldType();
            }
            case 10: {
                return pSSysSearchFieldBase.getIgnoreFields();
            }
            case 11: {
                return pSSysSearchFieldBase.getIncInParentFlag();
            }
            case 12: {
                return pSSysSearchFieldBase.getIndexFlag();
            }
            case 13: {
                return pSSysSearchFieldBase.getLogicName();
            }
            case 14: {
                return pSSysSearchFieldBase.getMemo();
            }
            case 15: {
                return pSSysSearchFieldBase.getOrderValue();
            }
            case 16: {
                return pSSysSearchFieldBase.getPattern();
            }
            case 17: {
                return pSSysSearchFieldBase.getPKey();
            }
            case 18: {
                return pSSysSearchFieldBase.getPSSysSearchDocId();
            }
            case 19: {
                return pSSysSearchFieldBase.getPSSysSearchDocName();
            }
            case 20: {
                return pSSysSearchFieldBase.getPSSysSearchFieldId();
            }
            case 21: {
                return pSSysSearchFieldBase.getPSSysSearchFieldName();
            }
            case 22: {
                return pSSysSearchFieldBase.getSearchAnalyzer();
            }
            case 23: {
                return pSSysSearchFieldBase.getStdDataType();
            }
            case 24: {
                return pSSysSearchFieldBase.getStoreFlag();
            }
            case 25: {
                return pSSysSearchFieldBase.getUpdateDate();
            }
            case 26: {
                return pSSysSearchFieldBase.getUpdateMan();
            }
            case 27: {
                return pSSysSearchFieldBase.getUserCat();
            }
            case 28: {
                return pSSysSearchFieldBase.getUserTag();
            }
            case 29: {
                return pSSysSearchFieldBase.getUserTag2();
            }
            case 30: {
                return pSSysSearchFieldBase.getUserTag3();
            }
            case 31: {
                return pSSysSearchFieldBase.getUserTag4();
            }
            case 32: {
                return pSSysSearchFieldBase.getValidFlag();
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
        PSSysSearchFieldBase.set(this, n, object);
    }

    private static void set(PSSysSearchFieldBase pSSysSearchFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchFieldBase.setAnalyzer(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSearchFieldBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSearchFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysSearchFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSearchFieldBase.setDateFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSearchFieldBase.setFieldDataFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysSearchFieldBase.setFieldParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSearchFieldBase.setFieldTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSearchFieldBase.setFieldTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSearchFieldBase.setFieldType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSearchFieldBase.setIgnoreFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSearchFieldBase.setIncInParentFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysSearchFieldBase.setIndexFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysSearchFieldBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSearchFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSearchFieldBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysSearchFieldBase.setPattern(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSearchFieldBase.setPKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysSearchFieldBase.setPSSysSearchDocId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSearchFieldBase.setPSSysSearchDocName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSearchFieldBase.setPSSysSearchFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSearchFieldBase.setPSSysSearchFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSearchFieldBase.setSearchAnalyzer(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSearchFieldBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSysSearchFieldBase.setStoreFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysSearchFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSSysSearchFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSearchFieldBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSearchFieldBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSearchFieldBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSearchFieldBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysSearchFieldBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysSearchFieldBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysSearchFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSearchFieldBase pSSysSearchFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchFieldBase.getAnalyzer() == null;
            }
            case 1: {
                return pSSysSearchFieldBase.getCodeName() == null;
            }
            case 2: {
                return pSSysSearchFieldBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysSearchFieldBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysSearchFieldBase.getDateFormat() == null;
            }
            case 5: {
                return pSSysSearchFieldBase.getFieldDataFlag() == null;
            }
            case 6: {
                return pSSysSearchFieldBase.getFieldParams() == null;
            }
            case 7: {
                return pSSysSearchFieldBase.getFieldTag() == null;
            }
            case 8: {
                return pSSysSearchFieldBase.getFieldTag2() == null;
            }
            case 9: {
                return pSSysSearchFieldBase.getFieldType() == null;
            }
            case 10: {
                return pSSysSearchFieldBase.getIgnoreFields() == null;
            }
            case 11: {
                return pSSysSearchFieldBase.getIncInParentFlag() == null;
            }
            case 12: {
                return pSSysSearchFieldBase.getIndexFlag() == null;
            }
            case 13: {
                return pSSysSearchFieldBase.getLogicName() == null;
            }
            case 14: {
                return pSSysSearchFieldBase.getMemo() == null;
            }
            case 15: {
                return pSSysSearchFieldBase.getOrderValue() == null;
            }
            case 16: {
                return pSSysSearchFieldBase.getPattern() == null;
            }
            case 17: {
                return pSSysSearchFieldBase.getPKey() == null;
            }
            case 18: {
                return pSSysSearchFieldBase.getPSSysSearchDocId() == null;
            }
            case 19: {
                return pSSysSearchFieldBase.getPSSysSearchDocName() == null;
            }
            case 20: {
                return pSSysSearchFieldBase.getPSSysSearchFieldId() == null;
            }
            case 21: {
                return pSSysSearchFieldBase.getPSSysSearchFieldName() == null;
            }
            case 22: {
                return pSSysSearchFieldBase.getSearchAnalyzer() == null;
            }
            case 23: {
                return pSSysSearchFieldBase.getStdDataType() == null;
            }
            case 24: {
                return pSSysSearchFieldBase.getStoreFlag() == null;
            }
            case 25: {
                return pSSysSearchFieldBase.getUpdateDate() == null;
            }
            case 26: {
                return pSSysSearchFieldBase.getUpdateMan() == null;
            }
            case 27: {
                return pSSysSearchFieldBase.getUserCat() == null;
            }
            case 28: {
                return pSSysSearchFieldBase.getUserTag() == null;
            }
            case 29: {
                return pSSysSearchFieldBase.getUserTag2() == null;
            }
            case 30: {
                return pSSysSearchFieldBase.getUserTag3() == null;
            }
            case 31: {
                return pSSysSearchFieldBase.getUserTag4() == null;
            }
            case 32: {
                return pSSysSearchFieldBase.getValidFlag() == null;
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
        return PSSysSearchFieldBase.contains(this, n);
    }

    private static boolean contains(PSSysSearchFieldBase pSSysSearchFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchFieldBase.isAnalyzerDirty();
            }
            case 1: {
                return pSSysSearchFieldBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysSearchFieldBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysSearchFieldBase.isCreateManDirty();
            }
            case 4: {
                return pSSysSearchFieldBase.isDateFormatDirty();
            }
            case 5: {
                return pSSysSearchFieldBase.isFieldDataFlagDirty();
            }
            case 6: {
                return pSSysSearchFieldBase.isFieldParamsDirty();
            }
            case 7: {
                return pSSysSearchFieldBase.isFieldTagDirty();
            }
            case 8: {
                return pSSysSearchFieldBase.isFieldTag2Dirty();
            }
            case 9: {
                return pSSysSearchFieldBase.isFieldTypeDirty();
            }
            case 10: {
                return pSSysSearchFieldBase.isIgnoreFieldsDirty();
            }
            case 11: {
                return pSSysSearchFieldBase.isIncInParentFlagDirty();
            }
            case 12: {
                return pSSysSearchFieldBase.isIndexFlagDirty();
            }
            case 13: {
                return pSSysSearchFieldBase.isLogicNameDirty();
            }
            case 14: {
                return pSSysSearchFieldBase.isMemoDirty();
            }
            case 15: {
                return pSSysSearchFieldBase.isOrderValueDirty();
            }
            case 16: {
                return pSSysSearchFieldBase.isPatternDirty();
            }
            case 17: {
                return pSSysSearchFieldBase.isPKeyDirty();
            }
            case 18: {
                return pSSysSearchFieldBase.isPSSysSearchDocIdDirty();
            }
            case 19: {
                return pSSysSearchFieldBase.isPSSysSearchDocNameDirty();
            }
            case 20: {
                return pSSysSearchFieldBase.isPSSysSearchFieldIdDirty();
            }
            case 21: {
                return pSSysSearchFieldBase.isPSSysSearchFieldNameDirty();
            }
            case 22: {
                return pSSysSearchFieldBase.isSearchAnalyzerDirty();
            }
            case 23: {
                return pSSysSearchFieldBase.isStdDataTypeDirty();
            }
            case 24: {
                return pSSysSearchFieldBase.isStoreFlagDirty();
            }
            case 25: {
                return pSSysSearchFieldBase.isUpdateDateDirty();
            }
            case 26: {
                return pSSysSearchFieldBase.isUpdateManDirty();
            }
            case 27: {
                return pSSysSearchFieldBase.isUserCatDirty();
            }
            case 28: {
                return pSSysSearchFieldBase.isUserTagDirty();
            }
            case 29: {
                return pSSysSearchFieldBase.isUserTag2Dirty();
            }
            case 30: {
                return pSSysSearchFieldBase.isUserTag3Dirty();
            }
            case 31: {
                return pSSysSearchFieldBase.isUserTag4Dirty();
            }
            case 32: {
                return pSSysSearchFieldBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSearchFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSearchFieldBase pSSysSearchFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSearchFieldBase.getAnalyzer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"analyzer", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getAnalyzer()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getDateFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dateformat", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getDateFormat()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getFieldDataFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fielddataflag", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getFieldDataFlag()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getFieldParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldparams", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getFieldParams()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getFieldTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtag", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getFieldTag()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getFieldTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtag2", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getFieldTag2()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getFieldType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtype", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getFieldType()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getIgnoreFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignorefields", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getIgnoreFields()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getIncInParentFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incinparentflag", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getIncInParentFlag()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getIndexFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"indexflag", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getIndexFlag()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getPattern() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pattern", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getPattern()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getPKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkey", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getPKey()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getPSSysSearchDocId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocid", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getPSSysSearchDocId()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getPSSysSearchDocName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocname", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getPSSysSearchDocName()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getPSSysSearchFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchfieldid", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getPSSysSearchFieldId()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getPSSysSearchFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchfieldname", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getPSSysSearchFieldName()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getSearchAnalyzer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchanalyzer", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getSearchAnalyzer()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getStoreFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"storeflag", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getStoreFlag()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSearchFieldBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSearchFieldBase.getJSONValue((Object)pSSysSearchFieldBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSearchFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSearchFieldBase pSSysSearchFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSearchFieldBase.getAnalyzer() != null) {
            object = pSSysSearchFieldBase.getAnalyzer();
            xmlNode.setAttribute(FIELD_ANALYZER, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSearchFieldBase.getCodeName() != null) {
            object = pSSysSearchFieldBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getCreateDate() != null) {
            object = pSSysSearchFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getCreateMan() != null) {
            object = pSSysSearchFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getDateFormat() != null) {
            object = pSSysSearchFieldBase.getDateFormat();
            xmlNode.setAttribute(FIELD_DATEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getFieldDataFlag() != null) {
            object = pSSysSearchFieldBase.getFieldDataFlag();
            xmlNode.setAttribute(FIELD_FIELDDATAFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getFieldParams() != null) {
            object = pSSysSearchFieldBase.getFieldParams();
            xmlNode.setAttribute(FIELD_FIELDPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getFieldTag() != null) {
            object = pSSysSearchFieldBase.getFieldTag();
            xmlNode.setAttribute(FIELD_FIELDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getFieldTag2() != null) {
            object = pSSysSearchFieldBase.getFieldTag2();
            xmlNode.setAttribute(FIELD_FIELDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getFieldType() != null) {
            object = pSSysSearchFieldBase.getFieldType();
            xmlNode.setAttribute(FIELD_FIELDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getIgnoreFields() != null) {
            object = pSSysSearchFieldBase.getIgnoreFields();
            xmlNode.setAttribute(FIELD_IGNOREFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getIncInParentFlag() != null) {
            object = pSSysSearchFieldBase.getIncInParentFlag();
            xmlNode.setAttribute(FIELD_INCINPARENTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getIndexFlag() != null) {
            object = pSSysSearchFieldBase.getIndexFlag();
            xmlNode.setAttribute(FIELD_INDEXFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getLogicName() != null) {
            object = pSSysSearchFieldBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getMemo() != null) {
            object = pSSysSearchFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getOrderValue() != null) {
            object = pSSysSearchFieldBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getPattern() != null) {
            object = pSSysSearchFieldBase.getPattern();
            xmlNode.setAttribute(FIELD_PATTERN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getPKey() != null) {
            object = pSSysSearchFieldBase.getPKey();
            xmlNode.setAttribute(FIELD_PKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getPSSysSearchDocId() != null) {
            object = pSSysSearchFieldBase.getPSSysSearchDocId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getPSSysSearchDocName() != null) {
            object = pSSysSearchFieldBase.getPSSysSearchDocName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getPSSysSearchFieldId() != null) {
            object = pSSysSearchFieldBase.getPSSysSearchFieldId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getPSSysSearchFieldName() != null) {
            object = pSSysSearchFieldBase.getPSSysSearchFieldName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getSearchAnalyzer() != null) {
            object = pSSysSearchFieldBase.getSearchAnalyzer();
            xmlNode.setAttribute(FIELD_SEARCHANALYZER, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getStdDataType() != null) {
            object = pSSysSearchFieldBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getStoreFlag() != null) {
            object = pSSysSearchFieldBase.getStoreFlag();
            xmlNode.setAttribute(FIELD_STOREFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getUpdateDate() != null) {
            object = pSSysSearchFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchFieldBase.getUpdateMan() != null) {
            object = pSSysSearchFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getUserCat() != null) {
            object = pSSysSearchFieldBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getUserTag() != null) {
            object = pSSysSearchFieldBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getUserTag2() != null) {
            object = pSSysSearchFieldBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getUserTag3() != null) {
            object = pSSysSearchFieldBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getUserTag4() != null) {
            object = pSSysSearchFieldBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchFieldBase.getValidFlag() != null) {
            object = pSSysSearchFieldBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSearchFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSearchFieldBase pSSysSearchFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSearchFieldBase.isAnalyzerDirty() && (bl || pSSysSearchFieldBase.getAnalyzer() != null)) {
            iDataObject.set(FIELD_ANALYZER, (Object)pSSysSearchFieldBase.getAnalyzer());
        }
        if (pSSysSearchFieldBase.isCodeNameDirty() && (bl || pSSysSearchFieldBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSearchFieldBase.getCodeName());
        }
        if (pSSysSearchFieldBase.isCreateDateDirty() && (bl || pSSysSearchFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSearchFieldBase.getCreateDate());
        }
        if (pSSysSearchFieldBase.isCreateManDirty() && (bl || pSSysSearchFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSearchFieldBase.getCreateMan());
        }
        if (pSSysSearchFieldBase.isDateFormatDirty() && (bl || pSSysSearchFieldBase.getDateFormat() != null)) {
            iDataObject.set(FIELD_DATEFORMAT, (Object)pSSysSearchFieldBase.getDateFormat());
        }
        if (pSSysSearchFieldBase.isFieldDataFlagDirty() && (bl || pSSysSearchFieldBase.getFieldDataFlag() != null)) {
            iDataObject.set(FIELD_FIELDDATAFLAG, (Object)pSSysSearchFieldBase.getFieldDataFlag());
        }
        if (pSSysSearchFieldBase.isFieldParamsDirty() && (bl || pSSysSearchFieldBase.getFieldParams() != null)) {
            iDataObject.set(FIELD_FIELDPARAMS, (Object)pSSysSearchFieldBase.getFieldParams());
        }
        if (pSSysSearchFieldBase.isFieldTagDirty() && (bl || pSSysSearchFieldBase.getFieldTag() != null)) {
            iDataObject.set(FIELD_FIELDTAG, (Object)pSSysSearchFieldBase.getFieldTag());
        }
        if (pSSysSearchFieldBase.isFieldTag2Dirty() && (bl || pSSysSearchFieldBase.getFieldTag2() != null)) {
            iDataObject.set(FIELD_FIELDTAG2, (Object)pSSysSearchFieldBase.getFieldTag2());
        }
        if (pSSysSearchFieldBase.isFieldTypeDirty() && (bl || pSSysSearchFieldBase.getFieldType() != null)) {
            iDataObject.set(FIELD_FIELDTYPE, (Object)pSSysSearchFieldBase.getFieldType());
        }
        if (pSSysSearchFieldBase.isIgnoreFieldsDirty() && (bl || pSSysSearchFieldBase.getIgnoreFields() != null)) {
            iDataObject.set(FIELD_IGNOREFIELDS, (Object)pSSysSearchFieldBase.getIgnoreFields());
        }
        if (pSSysSearchFieldBase.isIncInParentFlagDirty() && (bl || pSSysSearchFieldBase.getIncInParentFlag() != null)) {
            iDataObject.set(FIELD_INCINPARENTFLAG, (Object)pSSysSearchFieldBase.getIncInParentFlag());
        }
        if (pSSysSearchFieldBase.isIndexFlagDirty() && (bl || pSSysSearchFieldBase.getIndexFlag() != null)) {
            iDataObject.set(FIELD_INDEXFLAG, (Object)pSSysSearchFieldBase.getIndexFlag());
        }
        if (pSSysSearchFieldBase.isLogicNameDirty() && (bl || pSSysSearchFieldBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysSearchFieldBase.getLogicName());
        }
        if (pSSysSearchFieldBase.isMemoDirty() && (bl || pSSysSearchFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSearchFieldBase.getMemo());
        }
        if (pSSysSearchFieldBase.isOrderValueDirty() && (bl || pSSysSearchFieldBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysSearchFieldBase.getOrderValue());
        }
        if (pSSysSearchFieldBase.isPatternDirty() && (bl || pSSysSearchFieldBase.getPattern() != null)) {
            iDataObject.set(FIELD_PATTERN, (Object)pSSysSearchFieldBase.getPattern());
        }
        if (pSSysSearchFieldBase.isPKeyDirty() && (bl || pSSysSearchFieldBase.getPKey() != null)) {
            iDataObject.set(FIELD_PKEY, (Object)pSSysSearchFieldBase.getPKey());
        }
        if (pSSysSearchFieldBase.isPSSysSearchDocIdDirty() && (bl || pSSysSearchFieldBase.getPSSysSearchDocId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCID, (Object)pSSysSearchFieldBase.getPSSysSearchDocId());
        }
        if (pSSysSearchFieldBase.isPSSysSearchDocNameDirty() && (bl || pSSysSearchFieldBase.getPSSysSearchDocName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCNAME, (Object)pSSysSearchFieldBase.getPSSysSearchDocName());
        }
        if (pSSysSearchFieldBase.isPSSysSearchFieldIdDirty() && (bl || pSSysSearchFieldBase.getPSSysSearchFieldId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHFIELDID, (Object)pSSysSearchFieldBase.getPSSysSearchFieldId());
        }
        if (pSSysSearchFieldBase.isPSSysSearchFieldNameDirty() && (bl || pSSysSearchFieldBase.getPSSysSearchFieldName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHFIELDNAME, (Object)pSSysSearchFieldBase.getPSSysSearchFieldName());
        }
        if (pSSysSearchFieldBase.isSearchAnalyzerDirty() && (bl || pSSysSearchFieldBase.getSearchAnalyzer() != null)) {
            iDataObject.set(FIELD_SEARCHANALYZER, (Object)pSSysSearchFieldBase.getSearchAnalyzer());
        }
        if (pSSysSearchFieldBase.isStdDataTypeDirty() && (bl || pSSysSearchFieldBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysSearchFieldBase.getStdDataType());
        }
        if (pSSysSearchFieldBase.isStoreFlagDirty() && (bl || pSSysSearchFieldBase.getStoreFlag() != null)) {
            iDataObject.set(FIELD_STOREFLAG, (Object)pSSysSearchFieldBase.getStoreFlag());
        }
        if (pSSysSearchFieldBase.isUpdateDateDirty() && (bl || pSSysSearchFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSearchFieldBase.getUpdateDate());
        }
        if (pSSysSearchFieldBase.isUpdateManDirty() && (bl || pSSysSearchFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSearchFieldBase.getUpdateMan());
        }
        if (pSSysSearchFieldBase.isUserCatDirty() && (bl || pSSysSearchFieldBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSearchFieldBase.getUserCat());
        }
        if (pSSysSearchFieldBase.isUserTagDirty() && (bl || pSSysSearchFieldBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSearchFieldBase.getUserTag());
        }
        if (pSSysSearchFieldBase.isUserTag2Dirty() && (bl || pSSysSearchFieldBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSearchFieldBase.getUserTag2());
        }
        if (pSSysSearchFieldBase.isUserTag3Dirty() && (bl || pSSysSearchFieldBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSearchFieldBase.getUserTag3());
        }
        if (pSSysSearchFieldBase.isUserTag4Dirty() && (bl || pSSysSearchFieldBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSearchFieldBase.getUserTag4());
        }
        if (pSSysSearchFieldBase.isValidFlagDirty() && (bl || pSSysSearchFieldBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSearchFieldBase.getValidFlag());
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
        return PSSysSearchFieldBase.remove(this, n);
    }

    private static boolean remove(PSSysSearchFieldBase pSSysSearchFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchFieldBase.resetAnalyzer();
                return true;
            }
            case 1: {
                pSSysSearchFieldBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysSearchFieldBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysSearchFieldBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysSearchFieldBase.resetDateFormat();
                return true;
            }
            case 5: {
                pSSysSearchFieldBase.resetFieldDataFlag();
                return true;
            }
            case 6: {
                pSSysSearchFieldBase.resetFieldParams();
                return true;
            }
            case 7: {
                pSSysSearchFieldBase.resetFieldTag();
                return true;
            }
            case 8: {
                pSSysSearchFieldBase.resetFieldTag2();
                return true;
            }
            case 9: {
                pSSysSearchFieldBase.resetFieldType();
                return true;
            }
            case 10: {
                pSSysSearchFieldBase.resetIgnoreFields();
                return true;
            }
            case 11: {
                pSSysSearchFieldBase.resetIncInParentFlag();
                return true;
            }
            case 12: {
                pSSysSearchFieldBase.resetIndexFlag();
                return true;
            }
            case 13: {
                pSSysSearchFieldBase.resetLogicName();
                return true;
            }
            case 14: {
                pSSysSearchFieldBase.resetMemo();
                return true;
            }
            case 15: {
                pSSysSearchFieldBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSSysSearchFieldBase.resetPattern();
                return true;
            }
            case 17: {
                pSSysSearchFieldBase.resetPKey();
                return true;
            }
            case 18: {
                pSSysSearchFieldBase.resetPSSysSearchDocId();
                return true;
            }
            case 19: {
                pSSysSearchFieldBase.resetPSSysSearchDocName();
                return true;
            }
            case 20: {
                pSSysSearchFieldBase.resetPSSysSearchFieldId();
                return true;
            }
            case 21: {
                pSSysSearchFieldBase.resetPSSysSearchFieldName();
                return true;
            }
            case 22: {
                pSSysSearchFieldBase.resetSearchAnalyzer();
                return true;
            }
            case 23: {
                pSSysSearchFieldBase.resetStdDataType();
                return true;
            }
            case 24: {
                pSSysSearchFieldBase.resetStoreFlag();
                return true;
            }
            case 25: {
                pSSysSearchFieldBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSSysSearchFieldBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSSysSearchFieldBase.resetUserCat();
                return true;
            }
            case 28: {
                pSSysSearchFieldBase.resetUserTag();
                return true;
            }
            case 29: {
                pSSysSearchFieldBase.resetUserTag2();
                return true;
            }
            case 30: {
                pSSysSearchFieldBase.resetUserTag3();
                return true;
            }
            case 31: {
                pSSysSearchFieldBase.resetUserTag4();
                return true;
            }
            case 32: {
                pSSysSearchFieldBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchDoc getPSSysSearchDoc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDoc();
        }
        if (this.getPSSysSearchDocId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchDocLock;
        synchronized (n) {
            if (this.pssyssearchdoc != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchDocId(), (Object)this.pssyssearchdoc.getPSSysSearchDocId()) != 0L) {
                this.pssyssearchdoc = null;
            }
            if (this.pssyssearchdoc == null) {
                PSSysSearchDoc pSSysSearchDoc = new PSSysSearchDoc();
                pSSysSearchDoc.setPSSysSearchDocId(this.getPSSysSearchDocId());
                PSSysSearchDocService pSSysSearchDocService = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchDocService.autoGet((IEntity)pSSysSearchDoc);
                this.pssyssearchdoc = pSSysSearchDoc;
            }
            return this.pssyssearchdoc;
        }
    }

    private PSSysSearchFieldBase getProxyEntity() {
        return this.proxyPSSysSearchFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSearchFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSearchFieldBase) {
            this.proxyPSSysSearchFieldBase = (PSSysSearchFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ANALYZER, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DATEFORMAT, 4);
        fieldIndexMap.put(FIELD_FIELDDATAFLAG, 5);
        fieldIndexMap.put(FIELD_FIELDPARAMS, 6);
        fieldIndexMap.put(FIELD_FIELDTAG, 7);
        fieldIndexMap.put(FIELD_FIELDTAG2, 8);
        fieldIndexMap.put(FIELD_FIELDTYPE, 9);
        fieldIndexMap.put(FIELD_IGNOREFIELDS, 10);
        fieldIndexMap.put(FIELD_INCINPARENTFLAG, 11);
        fieldIndexMap.put(FIELD_INDEXFLAG, 12);
        fieldIndexMap.put(FIELD_LOGICNAME, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_PATTERN, 16);
        fieldIndexMap.put(FIELD_PKEY, 17);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCID, 18);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSSEARCHFIELDID, 20);
        fieldIndexMap.put(FIELD_PSSYSSEARCHFIELDNAME, 21);
        fieldIndexMap.put(FIELD_SEARCHANALYZER, 22);
        fieldIndexMap.put(FIELD_STDDATATYPE, 23);
        fieldIndexMap.put(FIELD_STOREFLAG, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_USERCAT, 27);
        fieldIndexMap.put(FIELD_USERTAG, 28);
        fieldIndexMap.put(FIELD_USERTAG2, 29);
        fieldIndexMap.put(FIELD_USERTAG3, 30);
        fieldIndexMap.put(FIELD_USERTAG4, 31);
        fieldIndexMap.put(FIELD_VALIDFLAG, 32);
    }
}

