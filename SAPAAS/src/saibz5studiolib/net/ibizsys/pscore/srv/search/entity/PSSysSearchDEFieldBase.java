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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchField;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchFieldService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchDEFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSearchDEFieldBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_DEFAULTVALUETYPE = "DEFAULTVALUETYPE";
    public static final String FIELD_FIELDPARAMS = "FIELDPARAMS";
    public static final String FIELD_FIELDS = "FIELDS";
    public static final String FIELD_FIELDTAG = "FIELDTAG";
    public static final String FIELD_FIELDTAG2 = "FIELDTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSSEARCHDEFIELDID = "PSSYSSEARCHDEFIELDID";
    public static final String FIELD_PSSYSSEARCHDEFIELDNAME = "PSSYSSEARCHDEFIELDNAME";
    public static final String FIELD_PSSYSSEARCHDEID = "PSSYSSEARCHDEID";
    public static final String FIELD_PSSYSSEARCHDENAME = "PSSYSSEARCHDENAME";
    public static final String FIELD_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String FIELD_PSSYSSEARCHFIELDID = "PSSYSSEARCHFIELDID";
    public static final String FIELD_PSSYSSEARCHFIELDNAME = "PSSYSSEARCHFIELDNAME";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTVALUE = 3;
    private static final int INDEX_DEFAULTVALUETYPE = 4;
    private static final int INDEX_FIELDPARAMS = 5;
    private static final int INDEX_FIELDS = 6;
    private static final int INDEX_FIELDTAG = 7;
    private static final int INDEX_FIELDTAG2 = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_ORDERVALUE = 10;
    private static final int INDEX_PSDEFID = 11;
    private static final int INDEX_PSDEFNAME = 12;
    private static final int INDEX_PSDEID = 13;
    private static final int INDEX_PSSYSSEARCHDEFIELDID = 14;
    private static final int INDEX_PSSYSSEARCHDEFIELDNAME = 15;
    private static final int INDEX_PSSYSSEARCHDEID = 16;
    private static final int INDEX_PSSYSSEARCHDENAME = 17;
    private static final int INDEX_PSSYSSEARCHDOCID = 18;
    private static final int INDEX_PSSYSSEARCHFIELDID = 19;
    private static final int INDEX_PSSYSSEARCHFIELDNAME = 20;
    private static final int INDEX_PSSYSTRANSLATORID = 21;
    private static final int INDEX_PSSYSTRANSLATORNAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final int INDEX_VALIDFLAG = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSearchDEFieldBase proxyPSSysSearchDEFieldBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean defaultvaluetypeDirtyFlag = false;
    private boolean fieldparamsDirtyFlag = false;
    private boolean fieldsDirtyFlag = false;
    private boolean fieldtagDirtyFlag = false;
    private boolean fieldtag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssyssearchdefieldidDirtyFlag = false;
    private boolean pssyssearchdefieldnameDirtyFlag = false;
    private boolean pssyssearchdeidDirtyFlag = false;
    private boolean pssyssearchdenameDirtyFlag = false;
    private boolean pssyssearchdocidDirtyFlag = false;
    private boolean pssyssearchfieldidDirtyFlag = false;
    private boolean pssyssearchfieldnameDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="defaultvaluetype")
    private String defaultvaluetype;
    @Column(name="fieldparams")
    private String fieldparams;
    @Column(name="fields")
    private String fields;
    @Column(name="fieldtag")
    private String fieldtag;
    @Column(name="fieldtag2")
    private String fieldtag2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssyssearchdefieldid")
    private String pssyssearchdefieldid;
    @Column(name="pssyssearchdefieldname")
    private String pssyssearchdefieldname;
    @Column(name="pssyssearchdeid")
    private String pssyssearchdeid;
    @Column(name="pssyssearchdename")
    private String pssyssearchdename;
    @Column(name="pssyssearchdocid")
    private String pssyssearchdocid;
    @Column(name="pssyssearchfieldid")
    private String pssyssearchfieldid;
    @Column(name="pssyssearchfieldname")
    private String pssyssearchfieldname;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
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
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSSysSearchDELock = new Integer(1);
    private PSSysSearchDE pssyssearchde = null;
    private Integer objPSSysSearchFieldLock = new Integer(1);
    private PSSysSearchField pssyssearchfield = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;

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

    public void setFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fields = string;
        this.fieldsDirtyFlag = true;
    }

    public String getFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFields();
        }
        return this.fields;
    }

    public boolean isFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldsDirty();
        }
        return this.fieldsDirtyFlag;
    }

    public void resetFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFields();
            return;
        }
        this.fieldsDirtyFlag = false;
        this.fields = null;
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

    public void setPSSysSearchDEFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDEFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdefieldid = string;
        this.pssyssearchdefieldidDirtyFlag = true;
    }

    public String getPSSysSearchDEFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEFieldId();
        }
        return this.pssyssearchdefieldid;
    }

    public boolean isPSSysSearchDEFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDEFieldIdDirty();
        }
        return this.pssyssearchdefieldidDirtyFlag;
    }

    public void resetPSSysSearchDEFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDEFieldId();
            return;
        }
        this.pssyssearchdefieldidDirtyFlag = false;
        this.pssyssearchdefieldid = null;
    }

    public void setPSSysSearchDEFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDEFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdefieldname = string;
        this.pssyssearchdefieldnameDirtyFlag = true;
    }

    public String getPSSysSearchDEFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEFieldName();
        }
        return this.pssyssearchdefieldname;
    }

    public boolean isPSSysSearchDEFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDEFieldNameDirty();
        }
        return this.pssyssearchdefieldnameDirtyFlag;
    }

    public void resetPSSysSearchDEFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDEFieldName();
            return;
        }
        this.pssyssearchdefieldnameDirtyFlag = false;
        this.pssyssearchdefieldname = null;
    }

    public void setPSSysSearchDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdeid = string;
        this.pssyssearchdeidDirtyFlag = true;
    }

    public String getPSSysSearchDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEId();
        }
        return this.pssyssearchdeid;
    }

    public boolean isPSSysSearchDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDEIdDirty();
        }
        return this.pssyssearchdeidDirtyFlag;
    }

    public void resetPSSysSearchDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDEId();
            return;
        }
        this.pssyssearchdeidDirtyFlag = false;
        this.pssyssearchdeid = null;
    }

    public void setPSSysSearchDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdename = string;
        this.pssyssearchdenameDirtyFlag = true;
    }

    public String getPSSysSearchDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEName();
        }
        return this.pssyssearchdename;
    }

    public boolean isPSSysSearchDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDENameDirty();
        }
        return this.pssyssearchdenameDirtyFlag;
    }

    public void resetPSSysSearchDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDEName();
            return;
        }
        this.pssyssearchdenameDirtyFlag = false;
        this.pssyssearchdename = null;
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

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
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
        PSSysSearchDEFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSearchDEFieldBase pSSysSearchDEFieldBase) {
        pSSysSearchDEFieldBase.resetCodeName();
        pSSysSearchDEFieldBase.resetCreateDate();
        pSSysSearchDEFieldBase.resetCreateMan();
        pSSysSearchDEFieldBase.resetDefaultValue();
        pSSysSearchDEFieldBase.resetDefaultValueType();
        pSSysSearchDEFieldBase.resetFieldParams();
        pSSysSearchDEFieldBase.resetFields();
        pSSysSearchDEFieldBase.resetFieldTag();
        pSSysSearchDEFieldBase.resetFieldTag2();
        pSSysSearchDEFieldBase.resetMemo();
        pSSysSearchDEFieldBase.resetOrderValue();
        pSSysSearchDEFieldBase.resetPSDEFId();
        pSSysSearchDEFieldBase.resetPSDEFName();
        pSSysSearchDEFieldBase.resetPSDEId();
        pSSysSearchDEFieldBase.resetPSSysSearchDEFieldId();
        pSSysSearchDEFieldBase.resetPSSysSearchDEFieldName();
        pSSysSearchDEFieldBase.resetPSSysSearchDEId();
        pSSysSearchDEFieldBase.resetPSSysSearchDEName();
        pSSysSearchDEFieldBase.resetPSSysSearchDocId();
        pSSysSearchDEFieldBase.resetPSSysSearchFieldId();
        pSSysSearchDEFieldBase.resetPSSysSearchFieldName();
        pSSysSearchDEFieldBase.resetPSSysTranslatorId();
        pSSysSearchDEFieldBase.resetPSSysTranslatorName();
        pSSysSearchDEFieldBase.resetUpdateDate();
        pSSysSearchDEFieldBase.resetUpdateMan();
        pSSysSearchDEFieldBase.resetUserCat();
        pSSysSearchDEFieldBase.resetUserTag();
        pSSysSearchDEFieldBase.resetUserTag2();
        pSSysSearchDEFieldBase.resetUserTag3();
        pSSysSearchDEFieldBase.resetUserTag4();
        pSSysSearchDEFieldBase.resetValidFlag();
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
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isDefaultValueTypeDirty()) {
            hashMap.put(FIELD_DEFAULTVALUETYPE, this.getDefaultValueType());
        }
        if (!bl || this.isFieldParamsDirty()) {
            hashMap.put(FIELD_FIELDPARAMS, this.getFieldParams());
        }
        if (!bl || this.isFieldsDirty()) {
            hashMap.put(FIELD_FIELDS, this.getFields());
        }
        if (!bl || this.isFieldTagDirty()) {
            hashMap.put(FIELD_FIELDTAG, this.getFieldTag());
        }
        if (!bl || this.isFieldTag2Dirty()) {
            hashMap.put(FIELD_FIELDTAG2, this.getFieldTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysSearchDEFieldIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDEFIELDID, this.getPSSysSearchDEFieldId());
        }
        if (!bl || this.isPSSysSearchDEFieldNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDEFIELDNAME, this.getPSSysSearchDEFieldName());
        }
        if (!bl || this.isPSSysSearchDEIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDEID, this.getPSSysSearchDEId());
        }
        if (!bl || this.isPSSysSearchDENameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDENAME, this.getPSSysSearchDEName());
        }
        if (!bl || this.isPSSysSearchDocIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCID, this.getPSSysSearchDocId());
        }
        if (!bl || this.isPSSysSearchFieldIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHFIELDID, this.getPSSysSearchFieldId());
        }
        if (!bl || this.isPSSysSearchFieldNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHFIELDNAME, this.getPSSysSearchFieldName());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
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
        return PSSysSearchDEFieldBase.get(this, n);
    }

    private static Object get(PSSysSearchDEFieldBase pSSysSearchDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDEFieldBase.getCodeName();
            }
            case 1: {
                return pSSysSearchDEFieldBase.getCreateDate();
            }
            case 2: {
                return pSSysSearchDEFieldBase.getCreateMan();
            }
            case 3: {
                return pSSysSearchDEFieldBase.getDefaultValue();
            }
            case 4: {
                return pSSysSearchDEFieldBase.getDefaultValueType();
            }
            case 5: {
                return pSSysSearchDEFieldBase.getFieldParams();
            }
            case 6: {
                return pSSysSearchDEFieldBase.getFields();
            }
            case 7: {
                return pSSysSearchDEFieldBase.getFieldTag();
            }
            case 8: {
                return pSSysSearchDEFieldBase.getFieldTag2();
            }
            case 9: {
                return pSSysSearchDEFieldBase.getMemo();
            }
            case 10: {
                return pSSysSearchDEFieldBase.getOrderValue();
            }
            case 11: {
                return pSSysSearchDEFieldBase.getPSDEFId();
            }
            case 12: {
                return pSSysSearchDEFieldBase.getPSDEFName();
            }
            case 13: {
                return pSSysSearchDEFieldBase.getPSDEId();
            }
            case 14: {
                return pSSysSearchDEFieldBase.getPSSysSearchDEFieldId();
            }
            case 15: {
                return pSSysSearchDEFieldBase.getPSSysSearchDEFieldName();
            }
            case 16: {
                return pSSysSearchDEFieldBase.getPSSysSearchDEId();
            }
            case 17: {
                return pSSysSearchDEFieldBase.getPSSysSearchDEName();
            }
            case 18: {
                return pSSysSearchDEFieldBase.getPSSysSearchDocId();
            }
            case 19: {
                return pSSysSearchDEFieldBase.getPSSysSearchFieldId();
            }
            case 20: {
                return pSSysSearchDEFieldBase.getPSSysSearchFieldName();
            }
            case 21: {
                return pSSysSearchDEFieldBase.getPSSysTranslatorId();
            }
            case 22: {
                return pSSysSearchDEFieldBase.getPSSysTranslatorName();
            }
            case 23: {
                return pSSysSearchDEFieldBase.getUpdateDate();
            }
            case 24: {
                return pSSysSearchDEFieldBase.getUpdateMan();
            }
            case 25: {
                return pSSysSearchDEFieldBase.getUserCat();
            }
            case 26: {
                return pSSysSearchDEFieldBase.getUserTag();
            }
            case 27: {
                return pSSysSearchDEFieldBase.getUserTag2();
            }
            case 28: {
                return pSSysSearchDEFieldBase.getUserTag3();
            }
            case 29: {
                return pSSysSearchDEFieldBase.getUserTag4();
            }
            case 30: {
                return pSSysSearchDEFieldBase.getValidFlag();
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
        PSSysSearchDEFieldBase.set(this, n, object);
    }

    private static void set(PSSysSearchDEFieldBase pSSysSearchDEFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchDEFieldBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSearchDEFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSearchDEFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSearchDEFieldBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSearchDEFieldBase.setDefaultValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSearchDEFieldBase.setFieldParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSearchDEFieldBase.setFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSearchDEFieldBase.setFieldTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSearchDEFieldBase.setFieldTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSearchDEFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSearchDEFieldBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysSearchDEFieldBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSearchDEFieldBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSearchDEFieldBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSearchDEFieldBase.setPSSysSearchDEFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSearchDEFieldBase.setPSSysSearchDEFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSearchDEFieldBase.setPSSysSearchDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSearchDEFieldBase.setPSSysSearchDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSearchDEFieldBase.setPSSysSearchDocId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSearchDEFieldBase.setPSSysSearchFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSearchDEFieldBase.setPSSysSearchFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSearchDEFieldBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSearchDEFieldBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSearchDEFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysSearchDEFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSearchDEFieldBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSearchDEFieldBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSearchDEFieldBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSearchDEFieldBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSearchDEFieldBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSearchDEFieldBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysSearchDEFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSearchDEFieldBase pSSysSearchDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDEFieldBase.getCodeName() == null;
            }
            case 1: {
                return pSSysSearchDEFieldBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSearchDEFieldBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSearchDEFieldBase.getDefaultValue() == null;
            }
            case 4: {
                return pSSysSearchDEFieldBase.getDefaultValueType() == null;
            }
            case 5: {
                return pSSysSearchDEFieldBase.getFieldParams() == null;
            }
            case 6: {
                return pSSysSearchDEFieldBase.getFields() == null;
            }
            case 7: {
                return pSSysSearchDEFieldBase.getFieldTag() == null;
            }
            case 8: {
                return pSSysSearchDEFieldBase.getFieldTag2() == null;
            }
            case 9: {
                return pSSysSearchDEFieldBase.getMemo() == null;
            }
            case 10: {
                return pSSysSearchDEFieldBase.getOrderValue() == null;
            }
            case 11: {
                return pSSysSearchDEFieldBase.getPSDEFId() == null;
            }
            case 12: {
                return pSSysSearchDEFieldBase.getPSDEFName() == null;
            }
            case 13: {
                return pSSysSearchDEFieldBase.getPSDEId() == null;
            }
            case 14: {
                return pSSysSearchDEFieldBase.getPSSysSearchDEFieldId() == null;
            }
            case 15: {
                return pSSysSearchDEFieldBase.getPSSysSearchDEFieldName() == null;
            }
            case 16: {
                return pSSysSearchDEFieldBase.getPSSysSearchDEId() == null;
            }
            case 17: {
                return pSSysSearchDEFieldBase.getPSSysSearchDEName() == null;
            }
            case 18: {
                return pSSysSearchDEFieldBase.getPSSysSearchDocId() == null;
            }
            case 19: {
                return pSSysSearchDEFieldBase.getPSSysSearchFieldId() == null;
            }
            case 20: {
                return pSSysSearchDEFieldBase.getPSSysSearchFieldName() == null;
            }
            case 21: {
                return pSSysSearchDEFieldBase.getPSSysTranslatorId() == null;
            }
            case 22: {
                return pSSysSearchDEFieldBase.getPSSysTranslatorName() == null;
            }
            case 23: {
                return pSSysSearchDEFieldBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysSearchDEFieldBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSysSearchDEFieldBase.getUserCat() == null;
            }
            case 26: {
                return pSSysSearchDEFieldBase.getUserTag() == null;
            }
            case 27: {
                return pSSysSearchDEFieldBase.getUserTag2() == null;
            }
            case 28: {
                return pSSysSearchDEFieldBase.getUserTag3() == null;
            }
            case 29: {
                return pSSysSearchDEFieldBase.getUserTag4() == null;
            }
            case 30: {
                return pSSysSearchDEFieldBase.getValidFlag() == null;
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
        return PSSysSearchDEFieldBase.contains(this, n);
    }

    private static boolean contains(PSSysSearchDEFieldBase pSSysSearchDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDEFieldBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysSearchDEFieldBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSearchDEFieldBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSearchDEFieldBase.isDefaultValueDirty();
            }
            case 4: {
                return pSSysSearchDEFieldBase.isDefaultValueTypeDirty();
            }
            case 5: {
                return pSSysSearchDEFieldBase.isFieldParamsDirty();
            }
            case 6: {
                return pSSysSearchDEFieldBase.isFieldsDirty();
            }
            case 7: {
                return pSSysSearchDEFieldBase.isFieldTagDirty();
            }
            case 8: {
                return pSSysSearchDEFieldBase.isFieldTag2Dirty();
            }
            case 9: {
                return pSSysSearchDEFieldBase.isMemoDirty();
            }
            case 10: {
                return pSSysSearchDEFieldBase.isOrderValueDirty();
            }
            case 11: {
                return pSSysSearchDEFieldBase.isPSDEFIdDirty();
            }
            case 12: {
                return pSSysSearchDEFieldBase.isPSDEFNameDirty();
            }
            case 13: {
                return pSSysSearchDEFieldBase.isPSDEIdDirty();
            }
            case 14: {
                return pSSysSearchDEFieldBase.isPSSysSearchDEFieldIdDirty();
            }
            case 15: {
                return pSSysSearchDEFieldBase.isPSSysSearchDEFieldNameDirty();
            }
            case 16: {
                return pSSysSearchDEFieldBase.isPSSysSearchDEIdDirty();
            }
            case 17: {
                return pSSysSearchDEFieldBase.isPSSysSearchDENameDirty();
            }
            case 18: {
                return pSSysSearchDEFieldBase.isPSSysSearchDocIdDirty();
            }
            case 19: {
                return pSSysSearchDEFieldBase.isPSSysSearchFieldIdDirty();
            }
            case 20: {
                return pSSysSearchDEFieldBase.isPSSysSearchFieldNameDirty();
            }
            case 21: {
                return pSSysSearchDEFieldBase.isPSSysTranslatorIdDirty();
            }
            case 22: {
                return pSSysSearchDEFieldBase.isPSSysTranslatorNameDirty();
            }
            case 23: {
                return pSSysSearchDEFieldBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysSearchDEFieldBase.isUpdateManDirty();
            }
            case 25: {
                return pSSysSearchDEFieldBase.isUserCatDirty();
            }
            case 26: {
                return pSSysSearchDEFieldBase.isUserTagDirty();
            }
            case 27: {
                return pSSysSearchDEFieldBase.isUserTag2Dirty();
            }
            case 28: {
                return pSSysSearchDEFieldBase.isUserTag3Dirty();
            }
            case 29: {
                return pSSysSearchDEFieldBase.isUserTag4Dirty();
            }
            case 30: {
                return pSSysSearchDEFieldBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSearchDEFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSearchDEFieldBase pSSysSearchDEFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSearchDEFieldBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getDefaultValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvaluetype", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getDefaultValueType()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getFieldParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldparams", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getFieldParams()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fields", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getFields()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getFieldTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtag", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getFieldTag()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getFieldTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldtag2", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getFieldTag2()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDEFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdefieldid", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysSearchDEFieldId()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDEFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdefieldname", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysSearchDEFieldName()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdeid", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysSearchDEId()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdename", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysSearchDEName()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDocId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocid", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysSearchDocId()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchfieldid", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysSearchFieldId()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchfieldname", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysSearchFieldName()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSearchDEFieldBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSearchDEFieldBase.getJSONValue((Object)pSSysSearchDEFieldBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSearchDEFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSearchDEFieldBase pSSysSearchDEFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSearchDEFieldBase.getCodeName() != null) {
            object = pSSysSearchDEFieldBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getCreateDate() != null) {
            object = pSSysSearchDEFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchDEFieldBase.getCreateMan() != null) {
            object = pSSysSearchDEFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getDefaultValue() != null) {
            object = pSSysSearchDEFieldBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getDefaultValueType() != null) {
            object = pSSysSearchDEFieldBase.getDefaultValueType();
            xmlNode.setAttribute(FIELD_DEFAULTVALUETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getFieldParams() != null) {
            object = pSSysSearchDEFieldBase.getFieldParams();
            xmlNode.setAttribute(FIELD_FIELDPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getFields() != null) {
            object = pSSysSearchDEFieldBase.getFields();
            xmlNode.setAttribute(FIELD_FIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getFieldTag() != null) {
            object = pSSysSearchDEFieldBase.getFieldTag();
            xmlNode.setAttribute(FIELD_FIELDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getFieldTag2() != null) {
            object = pSSysSearchDEFieldBase.getFieldTag2();
            xmlNode.setAttribute(FIELD_FIELDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getMemo() != null) {
            object = pSSysSearchDEFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getOrderValue() != null) {
            object = pSSysSearchDEFieldBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchDEFieldBase.getPSDEFId() != null) {
            object = pSSysSearchDEFieldBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSDEFName() != null) {
            object = pSSysSearchDEFieldBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSDEId() != null) {
            object = pSSysSearchDEFieldBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDEFieldId() != null) {
            object = pSSysSearchDEFieldBase.getPSSysSearchDEFieldId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDEFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDEFieldName() != null) {
            object = pSSysSearchDEFieldBase.getPSSysSearchDEFieldName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDEFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDEId() != null) {
            object = pSSysSearchDEFieldBase.getPSSysSearchDEId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDEName() != null) {
            object = pSSysSearchDEFieldBase.getPSSysSearchDEName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchDocId() != null) {
            object = pSSysSearchDEFieldBase.getPSSysSearchDocId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchFieldId() != null) {
            object = pSSysSearchDEFieldBase.getPSSysSearchFieldId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysSearchFieldName() != null) {
            object = pSSysSearchDEFieldBase.getPSSysSearchFieldName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysTranslatorId() != null) {
            object = pSSysSearchDEFieldBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getPSSysTranslatorName() != null) {
            object = pSSysSearchDEFieldBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getUpdateDate() != null) {
            object = pSSysSearchDEFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchDEFieldBase.getUpdateMan() != null) {
            object = pSSysSearchDEFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getUserCat() != null) {
            object = pSSysSearchDEFieldBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getUserTag() != null) {
            object = pSSysSearchDEFieldBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getUserTag2() != null) {
            object = pSSysSearchDEFieldBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getUserTag3() != null) {
            object = pSSysSearchDEFieldBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getUserTag4() != null) {
            object = pSSysSearchDEFieldBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEFieldBase.getValidFlag() != null) {
            object = pSSysSearchDEFieldBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSearchDEFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSearchDEFieldBase pSSysSearchDEFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSearchDEFieldBase.isCodeNameDirty() && (bl || pSSysSearchDEFieldBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSearchDEFieldBase.getCodeName());
        }
        if (pSSysSearchDEFieldBase.isCreateDateDirty() && (bl || pSSysSearchDEFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSearchDEFieldBase.getCreateDate());
        }
        if (pSSysSearchDEFieldBase.isCreateManDirty() && (bl || pSSysSearchDEFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSearchDEFieldBase.getCreateMan());
        }
        if (pSSysSearchDEFieldBase.isDefaultValueDirty() && (bl || pSSysSearchDEFieldBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSSysSearchDEFieldBase.getDefaultValue());
        }
        if (pSSysSearchDEFieldBase.isDefaultValueTypeDirty() && (bl || pSSysSearchDEFieldBase.getDefaultValueType() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUETYPE, (Object)pSSysSearchDEFieldBase.getDefaultValueType());
        }
        if (pSSysSearchDEFieldBase.isFieldParamsDirty() && (bl || pSSysSearchDEFieldBase.getFieldParams() != null)) {
            iDataObject.set(FIELD_FIELDPARAMS, (Object)pSSysSearchDEFieldBase.getFieldParams());
        }
        if (pSSysSearchDEFieldBase.isFieldsDirty() && (bl || pSSysSearchDEFieldBase.getFields() != null)) {
            iDataObject.set(FIELD_FIELDS, (Object)pSSysSearchDEFieldBase.getFields());
        }
        if (pSSysSearchDEFieldBase.isFieldTagDirty() && (bl || pSSysSearchDEFieldBase.getFieldTag() != null)) {
            iDataObject.set(FIELD_FIELDTAG, (Object)pSSysSearchDEFieldBase.getFieldTag());
        }
        if (pSSysSearchDEFieldBase.isFieldTag2Dirty() && (bl || pSSysSearchDEFieldBase.getFieldTag2() != null)) {
            iDataObject.set(FIELD_FIELDTAG2, (Object)pSSysSearchDEFieldBase.getFieldTag2());
        }
        if (pSSysSearchDEFieldBase.isMemoDirty() && (bl || pSSysSearchDEFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSearchDEFieldBase.getMemo());
        }
        if (pSSysSearchDEFieldBase.isOrderValueDirty() && (bl || pSSysSearchDEFieldBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysSearchDEFieldBase.getOrderValue());
        }
        if (pSSysSearchDEFieldBase.isPSDEFIdDirty() && (bl || pSSysSearchDEFieldBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysSearchDEFieldBase.getPSDEFId());
        }
        if (pSSysSearchDEFieldBase.isPSDEFNameDirty() && (bl || pSSysSearchDEFieldBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysSearchDEFieldBase.getPSDEFName());
        }
        if (pSSysSearchDEFieldBase.isPSDEIdDirty() && (bl || pSSysSearchDEFieldBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysSearchDEFieldBase.getPSDEId());
        }
        if (pSSysSearchDEFieldBase.isPSSysSearchDEFieldIdDirty() && (bl || pSSysSearchDEFieldBase.getPSSysSearchDEFieldId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDEFIELDID, (Object)pSSysSearchDEFieldBase.getPSSysSearchDEFieldId());
        }
        if (pSSysSearchDEFieldBase.isPSSysSearchDEFieldNameDirty() && (bl || pSSysSearchDEFieldBase.getPSSysSearchDEFieldName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDEFIELDNAME, (Object)pSSysSearchDEFieldBase.getPSSysSearchDEFieldName());
        }
        if (pSSysSearchDEFieldBase.isPSSysSearchDEIdDirty() && (bl || pSSysSearchDEFieldBase.getPSSysSearchDEId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDEID, (Object)pSSysSearchDEFieldBase.getPSSysSearchDEId());
        }
        if (pSSysSearchDEFieldBase.isPSSysSearchDENameDirty() && (bl || pSSysSearchDEFieldBase.getPSSysSearchDEName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDENAME, (Object)pSSysSearchDEFieldBase.getPSSysSearchDEName());
        }
        if (pSSysSearchDEFieldBase.isPSSysSearchDocIdDirty() && (bl || pSSysSearchDEFieldBase.getPSSysSearchDocId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCID, (Object)pSSysSearchDEFieldBase.getPSSysSearchDocId());
        }
        if (pSSysSearchDEFieldBase.isPSSysSearchFieldIdDirty() && (bl || pSSysSearchDEFieldBase.getPSSysSearchFieldId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHFIELDID, (Object)pSSysSearchDEFieldBase.getPSSysSearchFieldId());
        }
        if (pSSysSearchDEFieldBase.isPSSysSearchFieldNameDirty() && (bl || pSSysSearchDEFieldBase.getPSSysSearchFieldName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHFIELDNAME, (Object)pSSysSearchDEFieldBase.getPSSysSearchFieldName());
        }
        if (pSSysSearchDEFieldBase.isPSSysTranslatorIdDirty() && (bl || pSSysSearchDEFieldBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSSysSearchDEFieldBase.getPSSysTranslatorId());
        }
        if (pSSysSearchDEFieldBase.isPSSysTranslatorNameDirty() && (bl || pSSysSearchDEFieldBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSSysSearchDEFieldBase.getPSSysTranslatorName());
        }
        if (pSSysSearchDEFieldBase.isUpdateDateDirty() && (bl || pSSysSearchDEFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSearchDEFieldBase.getUpdateDate());
        }
        if (pSSysSearchDEFieldBase.isUpdateManDirty() && (bl || pSSysSearchDEFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSearchDEFieldBase.getUpdateMan());
        }
        if (pSSysSearchDEFieldBase.isUserCatDirty() && (bl || pSSysSearchDEFieldBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSearchDEFieldBase.getUserCat());
        }
        if (pSSysSearchDEFieldBase.isUserTagDirty() && (bl || pSSysSearchDEFieldBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSearchDEFieldBase.getUserTag());
        }
        if (pSSysSearchDEFieldBase.isUserTag2Dirty() && (bl || pSSysSearchDEFieldBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSearchDEFieldBase.getUserTag2());
        }
        if (pSSysSearchDEFieldBase.isUserTag3Dirty() && (bl || pSSysSearchDEFieldBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSearchDEFieldBase.getUserTag3());
        }
        if (pSSysSearchDEFieldBase.isUserTag4Dirty() && (bl || pSSysSearchDEFieldBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSearchDEFieldBase.getUserTag4());
        }
        if (pSSysSearchDEFieldBase.isValidFlagDirty() && (bl || pSSysSearchDEFieldBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSearchDEFieldBase.getValidFlag());
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
        return PSSysSearchDEFieldBase.remove(this, n);
    }

    private static boolean remove(PSSysSearchDEFieldBase pSSysSearchDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchDEFieldBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysSearchDEFieldBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSearchDEFieldBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSearchDEFieldBase.resetDefaultValue();
                return true;
            }
            case 4: {
                pSSysSearchDEFieldBase.resetDefaultValueType();
                return true;
            }
            case 5: {
                pSSysSearchDEFieldBase.resetFieldParams();
                return true;
            }
            case 6: {
                pSSysSearchDEFieldBase.resetFields();
                return true;
            }
            case 7: {
                pSSysSearchDEFieldBase.resetFieldTag();
                return true;
            }
            case 8: {
                pSSysSearchDEFieldBase.resetFieldTag2();
                return true;
            }
            case 9: {
                pSSysSearchDEFieldBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysSearchDEFieldBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSSysSearchDEFieldBase.resetPSDEFId();
                return true;
            }
            case 12: {
                pSSysSearchDEFieldBase.resetPSDEFName();
                return true;
            }
            case 13: {
                pSSysSearchDEFieldBase.resetPSDEId();
                return true;
            }
            case 14: {
                pSSysSearchDEFieldBase.resetPSSysSearchDEFieldId();
                return true;
            }
            case 15: {
                pSSysSearchDEFieldBase.resetPSSysSearchDEFieldName();
                return true;
            }
            case 16: {
                pSSysSearchDEFieldBase.resetPSSysSearchDEId();
                return true;
            }
            case 17: {
                pSSysSearchDEFieldBase.resetPSSysSearchDEName();
                return true;
            }
            case 18: {
                pSSysSearchDEFieldBase.resetPSSysSearchDocId();
                return true;
            }
            case 19: {
                pSSysSearchDEFieldBase.resetPSSysSearchFieldId();
                return true;
            }
            case 20: {
                pSSysSearchDEFieldBase.resetPSSysSearchFieldName();
                return true;
            }
            case 21: {
                pSSysSearchDEFieldBase.resetPSSysTranslatorId();
                return true;
            }
            case 22: {
                pSSysSearchDEFieldBase.resetPSSysTranslatorName();
                return true;
            }
            case 23: {
                pSSysSearchDEFieldBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysSearchDEFieldBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSysSearchDEFieldBase.resetUserCat();
                return true;
            }
            case 26: {
                pSSysSearchDEFieldBase.resetUserTag();
                return true;
            }
            case 27: {
                pSSysSearchDEFieldBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSSysSearchDEFieldBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSSysSearchDEFieldBase.resetUserTag4();
                return true;
            }
            case 30: {
                pSSysSearchDEFieldBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSysSearchDE getPSSysSearchDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDE();
        }
        if (this.getPSSysSearchDEId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchDELock;
        synchronized (n) {
            if (this.pssyssearchde != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchDEId(), (Object)this.pssyssearchde.getPSSysSearchDEId()) != 0L) {
                this.pssyssearchde = null;
            }
            if (this.pssyssearchde == null) {
                PSSysSearchDE pSSysSearchDE = new PSSysSearchDE();
                pSSysSearchDE.setPSSysSearchDEId(this.getPSSysSearchDEId());
                PSSysSearchDEService pSSysSearchDEService = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchDEService.autoGet(pSSysSearchDE);
                this.pssyssearchde = pSSysSearchDE;
            }
            return this.pssyssearchde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchField getPSSysSearchField() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchField();
        }
        if (this.getPSSysSearchFieldId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchFieldLock;
        synchronized (n) {
            if (this.pssyssearchfield != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchFieldId(), (Object)this.pssyssearchfield.getPSSysSearchFieldId()) != 0L) {
                this.pssyssearchfield = null;
            }
            if (this.pssyssearchfield == null) {
                PSSysSearchField pSSysSearchField = new PSSysSearchField();
                pSSysSearchField.setPSSysSearchFieldId(this.getPSSysSearchFieldId());
                PSSysSearchFieldService pSSysSearchFieldService = (PSSysSearchFieldService)ServiceGlobal.getService(PSSysSearchFieldService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchFieldService.autoGet(pSSysSearchField);
                this.pssyssearchfield = pSSysSearchField;
            }
            return this.pssyssearchfield;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslator();
        }
        if (this.getPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objPSSysTranslatorLock;
        synchronized (n) {
            if (this.pssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTranslatorId(), (Object)this.pssystranslator.getPSSysTranslatorId()) != 0L) {
                this.pssystranslator = null;
            }
            if (this.pssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet(pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    private PSSysSearchDEFieldBase getProxyEntity() {
        return this.proxyPSSysSearchDEFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSearchDEFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSearchDEFieldBase) {
            this.proxyPSSysSearchDEFieldBase = (PSSysSearchDEFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 3);
        fieldIndexMap.put(FIELD_DEFAULTVALUETYPE, 4);
        fieldIndexMap.put(FIELD_FIELDPARAMS, 5);
        fieldIndexMap.put(FIELD_FIELDS, 6);
        fieldIndexMap.put(FIELD_FIELDTAG, 7);
        fieldIndexMap.put(FIELD_FIELDTAG2, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_ORDERVALUE, 10);
        fieldIndexMap.put(FIELD_PSDEFID, 11);
        fieldIndexMap.put(FIELD_PSDEFNAME, 12);
        fieldIndexMap.put(FIELD_PSDEID, 13);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDEFIELDID, 14);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDEFIELDNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDEID, 16);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDENAME, 17);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCID, 18);
        fieldIndexMap.put(FIELD_PSSYSSEARCHFIELDID, 19);
        fieldIndexMap.put(FIELD_PSSYSSEARCHFIELDNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 21);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
        fieldIndexMap.put(FIELD_VALIDFLAG, 30);
    }
}

