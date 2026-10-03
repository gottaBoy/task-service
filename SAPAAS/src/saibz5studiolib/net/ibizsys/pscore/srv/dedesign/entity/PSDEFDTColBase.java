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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFDTColBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFDTColBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMDATATYPE = "CUSTOMDATATYPE";
    public static final String FIELD_DATATYPE = "DATATYPE";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_FORMULAFIELDS = "FORMULAFIELDS";
    public static final String FIELD_FORMULAFORMAT = "FORMULAFORMAT";
    public static final String FIELD_LENGTH = "LENGTH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NULLVALORDER = "NULLVALORDER";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PSDEFDTCOLID = "PSDEFDTCOLID";
    public static final String FIELD_PSDEFDTCOLNAME = "PSDEFDTCOLNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_TABLENAME = "TABLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALUEFUNC2FIELDS = "VALUEFUNC2FIELDS";
    public static final String FIELD_VALUEFUNC2FORMAT = "VALUEFUNC2FORMAT";
    public static final String FIELD_VALUEFUNCFIELDS = "VALUEFUNCFIELDS";
    public static final String FIELD_VALUEFUNCFORMAT = "VALUEFUNCFORMAT";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CUSTOMDATATYPE = 2;
    private static final int INDEX_DATATYPE = 3;
    private static final int INDEX_DBTYPE = 4;
    private static final int INDEX_DEFAULTVALUE = 5;
    private static final int INDEX_FORMULAFIELDS = 6;
    private static final int INDEX_FORMULAFORMAT = 7;
    private static final int INDEX_LENGTH = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_NULLVALORDER = 10;
    private static final int INDEX_PRECISION2 = 11;
    private static final int INDEX_PSDEFDTCOLID = 12;
    private static final int INDEX_PSDEFDTCOLNAME = 13;
    private static final int INDEX_PSDEFID = 14;
    private static final int INDEX_PSDEFNAME = 15;
    private static final int INDEX_PSDEID = 16;
    private static final int INDEX_PSDENAME = 17;
    private static final int INDEX_TABLENAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERPARAMS = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final int INDEX_VALUEFUNC2FIELDS = 27;
    private static final int INDEX_VALUEFUNC2FORMAT = 28;
    private static final int INDEX_VALUEFUNCFIELDS = 29;
    private static final int INDEX_VALUEFUNCFORMAT = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFDTColBase proxyPSDEFDTColBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customdatatypeDirtyFlag = false;
    private boolean datatypeDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean formulafieldsDirtyFlag = false;
    private boolean formulaformatDirtyFlag = false;
    private boolean lengthDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nullvalorderDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean psdefdtcolidDirtyFlag = false;
    private boolean psdefdtcolnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean tablenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean valuefunc2fieldsDirtyFlag = false;
    private boolean valuefunc2formatDirtyFlag = false;
    private boolean valuefuncfieldsDirtyFlag = false;
    private boolean valuefuncformatDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customdatatype")
    private Integer customdatatype;
    @Column(name="datatype")
    private String datatype;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="formulafields")
    private String formulafields;
    @Column(name="formulaformat")
    private String formulaformat;
    @Column(name="length")
    private Integer length;
    @Column(name="memo")
    private String memo;
    @Column(name="nullvalorder")
    private String nullvalorder;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="psdefdtcolid")
    private String psdefdtcolid;
    @Column(name="psdefdtcolname")
    private String psdefdtcolname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="tablename")
    private String tablename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="valuefunc2fields")
    private String valuefunc2fields;
    @Column(name="valuefunc2format")
    private String valuefunc2format;
    @Column(name="valuefuncfields")
    private String valuefuncfields;
    @Column(name="valuefuncformat")
    private String valuefuncformat;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;

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

    public void setCustomDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomDataType(n);
            return;
        }
        this.customdatatype = n;
        this.customdatatypeDirtyFlag = true;
    }

    public Integer getCustomDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomDataType();
        }
        return this.customdatatype;
    }

    public boolean isCustomDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomDataTypeDirty();
        }
        return this.customdatatypeDirtyFlag;
    }

    public void resetCustomDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomDataType();
            return;
        }
        this.customdatatypeDirtyFlag = false;
        this.customdatatype = null;
    }

    public void setDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatype = string;
        this.datatypeDirtyFlag = true;
    }

    public String getDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataType();
        }
        return this.datatype;
    }

    public boolean isDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypeDirty();
        }
        return this.datatypeDirtyFlag;
    }

    public void resetDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataType();
            return;
        }
        this.datatypeDirtyFlag = false;
        this.datatype = null;
    }

    public void setDBType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtype = string;
        this.dbtypeDirtyFlag = true;
    }

    public String getDBType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBType();
        }
        return this.dbtype;
    }

    public boolean isDBTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypeDirty();
        }
        return this.dbtypeDirtyFlag;
    }

    public void resetDBType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBType();
            return;
        }
        this.dbtypeDirtyFlag = false;
        this.dbtype = null;
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

    public void setFormulaFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormulaFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formulafields = string;
        this.formulafieldsDirtyFlag = true;
    }

    public String getFormulaFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormulaFields();
        }
        return this.formulafields;
    }

    public boolean isFormulaFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormulaFieldsDirty();
        }
        return this.formulafieldsDirtyFlag;
    }

    public void resetFormulaFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormulaFields();
            return;
        }
        this.formulafieldsDirtyFlag = false;
        this.formulafields = null;
    }

    public void setFormulaFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormulaFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formulaformat = string;
        this.formulaformatDirtyFlag = true;
    }

    public String getFormulaFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormulaFormat();
        }
        return this.formulaformat;
    }

    public boolean isFormulaFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormulaFormatDirty();
        }
        return this.formulaformatDirtyFlag;
    }

    public void resetFormulaFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormulaFormat();
            return;
        }
        this.formulaformatDirtyFlag = false;
        this.formulaformat = null;
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

    public void setNullValOrder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNullValOrder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nullvalorder = string;
        this.nullvalorderDirtyFlag = true;
    }

    public String getNullValOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNullValOrder();
        }
        return this.nullvalorder;
    }

    public boolean isNullValOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNullValOrderDirty();
        }
        return this.nullvalorderDirtyFlag;
    }

    public void resetNullValOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNullValOrder();
            return;
        }
        this.nullvalorderDirtyFlag = false;
        this.nullvalorder = null;
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

    public void setPSDEFDTColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFDTColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefdtcolid = string;
        this.psdefdtcolidDirtyFlag = true;
    }

    public String getPSDEFDTColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDTColId();
        }
        return this.psdefdtcolid;
    }

    public boolean isPSDEFDTColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFDTColIdDirty();
        }
        return this.psdefdtcolidDirtyFlag;
    }

    public void resetPSDEFDTColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFDTColId();
            return;
        }
        this.psdefdtcolidDirtyFlag = false;
        this.psdefdtcolid = null;
    }

    public void setPSDEFDTColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFDTColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdefdtcolname = string;
        this.psdefdtcolnameDirtyFlag = true;
    }

    public String getPSDEFDTColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDTColName();
        }
        return this.psdefdtcolname;
    }

    public boolean isPSDEFDTColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFDTColNameDirty();
        }
        return this.psdefdtcolnameDirtyFlag;
    }

    public void resetPSDEFDTColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFDTColName();
            return;
        }
        this.psdefdtcolnameDirtyFlag = false;
        this.psdefdtcolname = null;
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

    public void setTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tablename = string;
        this.tablenameDirtyFlag = true;
    }

    public String getTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableName();
        }
        return this.tablename;
    }

    public boolean isTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableNameDirty();
        }
        return this.tablenameDirtyFlag;
    }

    public void resetTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableName();
            return;
        }
        this.tablenameDirtyFlag = false;
        this.tablename = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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

    public void setValueFunc2Fields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFunc2Fields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuefunc2fields = string;
        this.valuefunc2fieldsDirtyFlag = true;
    }

    public String getValueFunc2Fields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFunc2Fields();
        }
        return this.valuefunc2fields;
    }

    public boolean isValueFunc2FieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFunc2FieldsDirty();
        }
        return this.valuefunc2fieldsDirtyFlag;
    }

    public void resetValueFunc2Fields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFunc2Fields();
            return;
        }
        this.valuefunc2fieldsDirtyFlag = false;
        this.valuefunc2fields = null;
    }

    public void setValueFunc2Format(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFunc2Format(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuefunc2format = string;
        this.valuefunc2formatDirtyFlag = true;
    }

    public String getValueFunc2Format() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFunc2Format();
        }
        return this.valuefunc2format;
    }

    public boolean isValueFunc2FormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFunc2FormatDirty();
        }
        return this.valuefunc2formatDirtyFlag;
    }

    public void resetValueFunc2Format() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFunc2Format();
            return;
        }
        this.valuefunc2formatDirtyFlag = false;
        this.valuefunc2format = null;
    }

    public void setValueFuncFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFuncFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuefuncfields = string;
        this.valuefuncfieldsDirtyFlag = true;
    }

    public String getValueFuncFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFuncFields();
        }
        return this.valuefuncfields;
    }

    public boolean isValueFuncFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFuncFieldsDirty();
        }
        return this.valuefuncfieldsDirtyFlag;
    }

    public void resetValueFuncFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFuncFields();
            return;
        }
        this.valuefuncfieldsDirtyFlag = false;
        this.valuefuncfields = null;
    }

    public void setValueFuncFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFuncFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuefuncformat = string;
        this.valuefuncformatDirtyFlag = true;
    }

    public String getValueFuncFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFuncFormat();
        }
        return this.valuefuncformat;
    }

    public boolean isValueFuncFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFuncFormatDirty();
        }
        return this.valuefuncformatDirtyFlag;
    }

    public void resetValueFuncFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFuncFormat();
            return;
        }
        this.valuefuncformatDirtyFlag = false;
        this.valuefuncformat = null;
    }

    protected void onReset() {
        PSDEFDTColBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFDTColBase pSDEFDTColBase) {
        pSDEFDTColBase.resetCreateDate();
        pSDEFDTColBase.resetCreateMan();
        pSDEFDTColBase.resetCustomDataType();
        pSDEFDTColBase.resetDataType();
        pSDEFDTColBase.resetDBType();
        pSDEFDTColBase.resetDefaultValue();
        pSDEFDTColBase.resetFormulaFields();
        pSDEFDTColBase.resetFormulaFormat();
        pSDEFDTColBase.resetLength();
        pSDEFDTColBase.resetMemo();
        pSDEFDTColBase.resetNullValOrder();
        pSDEFDTColBase.resetPrecision2();
        pSDEFDTColBase.resetPSDEFDTColId();
        pSDEFDTColBase.resetPSDEFDTColName();
        pSDEFDTColBase.resetPSDEFId();
        pSDEFDTColBase.resetPSDEFName();
        pSDEFDTColBase.resetPSDEId();
        pSDEFDTColBase.resetPSDEName();
        pSDEFDTColBase.resetTableName();
        pSDEFDTColBase.resetUpdateDate();
        pSDEFDTColBase.resetUpdateMan();
        pSDEFDTColBase.resetUserCat();
        pSDEFDTColBase.resetUserParams();
        pSDEFDTColBase.resetUserTag();
        pSDEFDTColBase.resetUserTag2();
        pSDEFDTColBase.resetUserTag3();
        pSDEFDTColBase.resetUserTag4();
        pSDEFDTColBase.resetValueFunc2Fields();
        pSDEFDTColBase.resetValueFunc2Format();
        pSDEFDTColBase.resetValueFuncFields();
        pSDEFDTColBase.resetValueFuncFormat();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomDataTypeDirty()) {
            hashMap.put(FIELD_CUSTOMDATATYPE, this.getCustomDataType());
        }
        if (!bl || this.isDataTypeDirty()) {
            hashMap.put(FIELD_DATATYPE, this.getDataType());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isFormulaFieldsDirty()) {
            hashMap.put(FIELD_FORMULAFIELDS, this.getFormulaFields());
        }
        if (!bl || this.isFormulaFormatDirty()) {
            hashMap.put(FIELD_FORMULAFORMAT, this.getFormulaFormat());
        }
        if (!bl || this.isLengthDirty()) {
            hashMap.put(FIELD_LENGTH, this.getLength());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNullValOrderDirty()) {
            hashMap.put(FIELD_NULLVALORDER, this.getNullValOrder());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPSDEFDTColIdDirty()) {
            hashMap.put(FIELD_PSDEFDTCOLID, this.getPSDEFDTColId());
        }
        if (!bl || this.isPSDEFDTColNameDirty()) {
            hashMap.put(FIELD_PSDEFDTCOLNAME, this.getPSDEFDTColName());
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
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isTableNameDirty()) {
            hashMap.put(FIELD_TABLENAME, this.getTableName());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        if (!bl || this.isValueFunc2FieldsDirty()) {
            hashMap.put(FIELD_VALUEFUNC2FIELDS, this.getValueFunc2Fields());
        }
        if (!bl || this.isValueFunc2FormatDirty()) {
            hashMap.put(FIELD_VALUEFUNC2FORMAT, this.getValueFunc2Format());
        }
        if (!bl || this.isValueFuncFieldsDirty()) {
            hashMap.put(FIELD_VALUEFUNCFIELDS, this.getValueFuncFields());
        }
        if (!bl || this.isValueFuncFormatDirty()) {
            hashMap.put(FIELD_VALUEFUNCFORMAT, this.getValueFuncFormat());
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
        return PSDEFDTColBase.get(this, n);
    }

    private static Object get(PSDEFDTColBase pSDEFDTColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDTColBase.getCreateDate();
            }
            case 1: {
                return pSDEFDTColBase.getCreateMan();
            }
            case 2: {
                return pSDEFDTColBase.getCustomDataType();
            }
            case 3: {
                return pSDEFDTColBase.getDataType();
            }
            case 4: {
                return pSDEFDTColBase.getDBType();
            }
            case 5: {
                return pSDEFDTColBase.getDefaultValue();
            }
            case 6: {
                return pSDEFDTColBase.getFormulaFields();
            }
            case 7: {
                return pSDEFDTColBase.getFormulaFormat();
            }
            case 8: {
                return pSDEFDTColBase.getLength();
            }
            case 9: {
                return pSDEFDTColBase.getMemo();
            }
            case 10: {
                return pSDEFDTColBase.getNullValOrder();
            }
            case 11: {
                return pSDEFDTColBase.getPrecision2();
            }
            case 12: {
                return pSDEFDTColBase.getPSDEFDTColId();
            }
            case 13: {
                return pSDEFDTColBase.getPSDEFDTColName();
            }
            case 14: {
                return pSDEFDTColBase.getPSDEFId();
            }
            case 15: {
                return pSDEFDTColBase.getPSDEFName();
            }
            case 16: {
                return pSDEFDTColBase.getPSDEId();
            }
            case 17: {
                return pSDEFDTColBase.getPSDEName();
            }
            case 18: {
                return pSDEFDTColBase.getTableName();
            }
            case 19: {
                return pSDEFDTColBase.getUpdateDate();
            }
            case 20: {
                return pSDEFDTColBase.getUpdateMan();
            }
            case 21: {
                return pSDEFDTColBase.getUserCat();
            }
            case 22: {
                return pSDEFDTColBase.getUserParams();
            }
            case 23: {
                return pSDEFDTColBase.getUserTag();
            }
            case 24: {
                return pSDEFDTColBase.getUserTag2();
            }
            case 25: {
                return pSDEFDTColBase.getUserTag3();
            }
            case 26: {
                return pSDEFDTColBase.getUserTag4();
            }
            case 27: {
                return pSDEFDTColBase.getValueFunc2Fields();
            }
            case 28: {
                return pSDEFDTColBase.getValueFunc2Format();
            }
            case 29: {
                return pSDEFDTColBase.getValueFuncFields();
            }
            case 30: {
                return pSDEFDTColBase.getValueFuncFormat();
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
        PSDEFDTColBase.set(this, n, object);
    }

    private static void set(PSDEFDTColBase pSDEFDTColBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFDTColBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFDTColBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFDTColBase.setCustomDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEFDTColBase.setDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFDTColBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFDTColBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFDTColBase.setFormulaFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFDTColBase.setFormulaFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFDTColBase.setLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEFDTColBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFDTColBase.setNullValOrder(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFDTColBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEFDTColBase.setPSDEFDTColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFDTColBase.setPSDEFDTColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFDTColBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFDTColBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFDTColBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFDTColBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFDTColBase.setTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFDTColBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDEFDTColBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFDTColBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFDTColBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFDTColBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFDTColBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFDTColBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFDTColBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFDTColBase.setValueFunc2Fields(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFDTColBase.setValueFunc2Format(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFDTColBase.setValueFuncFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFDTColBase.setValueFuncFormat(DataObject.getStringValue((Object)object));
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
        return PSDEFDTColBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFDTColBase pSDEFDTColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDTColBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFDTColBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFDTColBase.getCustomDataType() == null;
            }
            case 3: {
                return pSDEFDTColBase.getDataType() == null;
            }
            case 4: {
                return pSDEFDTColBase.getDBType() == null;
            }
            case 5: {
                return pSDEFDTColBase.getDefaultValue() == null;
            }
            case 6: {
                return pSDEFDTColBase.getFormulaFields() == null;
            }
            case 7: {
                return pSDEFDTColBase.getFormulaFormat() == null;
            }
            case 8: {
                return pSDEFDTColBase.getLength() == null;
            }
            case 9: {
                return pSDEFDTColBase.getMemo() == null;
            }
            case 10: {
                return pSDEFDTColBase.getNullValOrder() == null;
            }
            case 11: {
                return pSDEFDTColBase.getPrecision2() == null;
            }
            case 12: {
                return pSDEFDTColBase.getPSDEFDTColId() == null;
            }
            case 13: {
                return pSDEFDTColBase.getPSDEFDTColName() == null;
            }
            case 14: {
                return pSDEFDTColBase.getPSDEFId() == null;
            }
            case 15: {
                return pSDEFDTColBase.getPSDEFName() == null;
            }
            case 16: {
                return pSDEFDTColBase.getPSDEId() == null;
            }
            case 17: {
                return pSDEFDTColBase.getPSDEName() == null;
            }
            case 18: {
                return pSDEFDTColBase.getTableName() == null;
            }
            case 19: {
                return pSDEFDTColBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDEFDTColBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDEFDTColBase.getUserCat() == null;
            }
            case 22: {
                return pSDEFDTColBase.getUserParams() == null;
            }
            case 23: {
                return pSDEFDTColBase.getUserTag() == null;
            }
            case 24: {
                return pSDEFDTColBase.getUserTag2() == null;
            }
            case 25: {
                return pSDEFDTColBase.getUserTag3() == null;
            }
            case 26: {
                return pSDEFDTColBase.getUserTag4() == null;
            }
            case 27: {
                return pSDEFDTColBase.getValueFunc2Fields() == null;
            }
            case 28: {
                return pSDEFDTColBase.getValueFunc2Format() == null;
            }
            case 29: {
                return pSDEFDTColBase.getValueFuncFields() == null;
            }
            case 30: {
                return pSDEFDTColBase.getValueFuncFormat() == null;
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
        return PSDEFDTColBase.contains(this, n);
    }

    private static boolean contains(PSDEFDTColBase pSDEFDTColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDTColBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFDTColBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFDTColBase.isCustomDataTypeDirty();
            }
            case 3: {
                return pSDEFDTColBase.isDataTypeDirty();
            }
            case 4: {
                return pSDEFDTColBase.isDBTypeDirty();
            }
            case 5: {
                return pSDEFDTColBase.isDefaultValueDirty();
            }
            case 6: {
                return pSDEFDTColBase.isFormulaFieldsDirty();
            }
            case 7: {
                return pSDEFDTColBase.isFormulaFormatDirty();
            }
            case 8: {
                return pSDEFDTColBase.isLengthDirty();
            }
            case 9: {
                return pSDEFDTColBase.isMemoDirty();
            }
            case 10: {
                return pSDEFDTColBase.isNullValOrderDirty();
            }
            case 11: {
                return pSDEFDTColBase.isPrecision2Dirty();
            }
            case 12: {
                return pSDEFDTColBase.isPSDEFDTColIdDirty();
            }
            case 13: {
                return pSDEFDTColBase.isPSDEFDTColNameDirty();
            }
            case 14: {
                return pSDEFDTColBase.isPSDEFIdDirty();
            }
            case 15: {
                return pSDEFDTColBase.isPSDEFNameDirty();
            }
            case 16: {
                return pSDEFDTColBase.isPSDEIdDirty();
            }
            case 17: {
                return pSDEFDTColBase.isPSDENameDirty();
            }
            case 18: {
                return pSDEFDTColBase.isTableNameDirty();
            }
            case 19: {
                return pSDEFDTColBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDEFDTColBase.isUpdateManDirty();
            }
            case 21: {
                return pSDEFDTColBase.isUserCatDirty();
            }
            case 22: {
                return pSDEFDTColBase.isUserParamsDirty();
            }
            case 23: {
                return pSDEFDTColBase.isUserTagDirty();
            }
            case 24: {
                return pSDEFDTColBase.isUserTag2Dirty();
            }
            case 25: {
                return pSDEFDTColBase.isUserTag3Dirty();
            }
            case 26: {
                return pSDEFDTColBase.isUserTag4Dirty();
            }
            case 27: {
                return pSDEFDTColBase.isValueFunc2FieldsDirty();
            }
            case 28: {
                return pSDEFDTColBase.isValueFunc2FormatDirty();
            }
            case 29: {
                return pSDEFDTColBase.isValueFuncFieldsDirty();
            }
            case 30: {
                return pSDEFDTColBase.isValueFuncFormatDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFDTColBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFDTColBase pSDEFDTColBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFDTColBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getCustomDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customdatatype", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getCustomDataType()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatype", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getDataType()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getDBType()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getFormulaFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formulafields", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getFormulaFields()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getFormulaFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formulaformat", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getFormulaFormat()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"length", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getLength()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getNullValOrder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nullvalorder", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getNullValOrder()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getPSDEFDTColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefdtcolid", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getPSDEFDTColId()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getPSDEFDTColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefdtcolname", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getPSDEFDTColName()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tablename", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getTableName()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getValueFunc2Fields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuefunc2fields", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getValueFunc2Fields()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getValueFunc2Format() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuefunc2format", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getValueFunc2Format()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getValueFuncFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuefuncfields", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getValueFuncFields()), (boolean)false);
        }
        if (bl || pSDEFDTColBase.getValueFuncFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuefuncformat", (Object)PSDEFDTColBase.getJSONValue((Object)pSDEFDTColBase.getValueFuncFormat()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFDTColBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFDTColBase pSDEFDTColBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFDTColBase.getCreateDate() != null) {
            object = pSDEFDTColBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFDTColBase.getCreateMan() != null) {
            object = pSDEFDTColBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getCustomDataType() != null) {
            object = pSDEFDTColBase.getCustomDataType();
            xmlNode.setAttribute(FIELD_CUSTOMDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDTColBase.getDataType() != null) {
            object = pSDEFDTColBase.getDataType();
            xmlNode.setAttribute(FIELD_DATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getDBType() != null) {
            object = pSDEFDTColBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getDefaultValue() != null) {
            object = pSDEFDTColBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getFormulaFields() != null) {
            object = pSDEFDTColBase.getFormulaFields();
            xmlNode.setAttribute(FIELD_FORMULAFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getFormulaFormat() != null) {
            object = pSDEFDTColBase.getFormulaFormat();
            xmlNode.setAttribute(FIELD_FORMULAFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getLength() != null) {
            object = pSDEFDTColBase.getLength();
            xmlNode.setAttribute(FIELD_LENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDTColBase.getMemo() != null) {
            object = pSDEFDTColBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getNullValOrder() != null) {
            object = pSDEFDTColBase.getNullValOrder();
            xmlNode.setAttribute(FIELD_NULLVALORDER, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getPrecision2() != null) {
            object = pSDEFDTColBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDTColBase.getPSDEFDTColId() != null) {
            object = pSDEFDTColBase.getPSDEFDTColId();
            xmlNode.setAttribute(FIELD_PSDEFDTCOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getPSDEFDTColName() != null) {
            object = pSDEFDTColBase.getPSDEFDTColName();
            xmlNode.setAttribute(FIELD_PSDEFDTCOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getPSDEFId() != null) {
            object = pSDEFDTColBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getPSDEFName() != null) {
            object = pSDEFDTColBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getPSDEId() != null) {
            object = pSDEFDTColBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getPSDEName() != null) {
            object = pSDEFDTColBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getTableName() != null) {
            object = pSDEFDTColBase.getTableName();
            xmlNode.setAttribute(FIELD_TABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getUpdateDate() != null) {
            object = pSDEFDTColBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFDTColBase.getUpdateMan() != null) {
            object = pSDEFDTColBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getUserCat() != null) {
            object = pSDEFDTColBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getUserParams() != null) {
            object = pSDEFDTColBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getUserTag() != null) {
            object = pSDEFDTColBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getUserTag2() != null) {
            object = pSDEFDTColBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getUserTag3() != null) {
            object = pSDEFDTColBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getUserTag4() != null) {
            object = pSDEFDTColBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getValueFunc2Fields() != null) {
            object = pSDEFDTColBase.getValueFunc2Fields();
            xmlNode.setAttribute(FIELD_VALUEFUNC2FIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getValueFunc2Format() != null) {
            object = pSDEFDTColBase.getValueFunc2Format();
            xmlNode.setAttribute(FIELD_VALUEFUNC2FORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getValueFuncFields() != null) {
            object = pSDEFDTColBase.getValueFuncFields();
            xmlNode.setAttribute(FIELD_VALUEFUNCFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDTColBase.getValueFuncFormat() != null) {
            object = pSDEFDTColBase.getValueFuncFormat();
            xmlNode.setAttribute(FIELD_VALUEFUNCFORMAT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFDTColBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFDTColBase pSDEFDTColBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFDTColBase.isCreateDateDirty() && (bl || pSDEFDTColBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFDTColBase.getCreateDate());
        }
        if (pSDEFDTColBase.isCreateManDirty() && (bl || pSDEFDTColBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFDTColBase.getCreateMan());
        }
        if (pSDEFDTColBase.isCustomDataTypeDirty() && (bl || pSDEFDTColBase.getCustomDataType() != null)) {
            iDataObject.set(FIELD_CUSTOMDATATYPE, (Object)pSDEFDTColBase.getCustomDataType());
        }
        if (pSDEFDTColBase.isDataTypeDirty() && (bl || pSDEFDTColBase.getDataType() != null)) {
            iDataObject.set(FIELD_DATATYPE, (Object)pSDEFDTColBase.getDataType());
        }
        if (pSDEFDTColBase.isDBTypeDirty() && (bl || pSDEFDTColBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDEFDTColBase.getDBType());
        }
        if (pSDEFDTColBase.isDefaultValueDirty() && (bl || pSDEFDTColBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSDEFDTColBase.getDefaultValue());
        }
        if (pSDEFDTColBase.isFormulaFieldsDirty() && (bl || pSDEFDTColBase.getFormulaFields() != null)) {
            iDataObject.set(FIELD_FORMULAFIELDS, (Object)pSDEFDTColBase.getFormulaFields());
        }
        if (pSDEFDTColBase.isFormulaFormatDirty() && (bl || pSDEFDTColBase.getFormulaFormat() != null)) {
            iDataObject.set(FIELD_FORMULAFORMAT, (Object)pSDEFDTColBase.getFormulaFormat());
        }
        if (pSDEFDTColBase.isLengthDirty() && (bl || pSDEFDTColBase.getLength() != null)) {
            iDataObject.set(FIELD_LENGTH, (Object)pSDEFDTColBase.getLength());
        }
        if (pSDEFDTColBase.isMemoDirty() && (bl || pSDEFDTColBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFDTColBase.getMemo());
        }
        if (pSDEFDTColBase.isNullValOrderDirty() && (bl || pSDEFDTColBase.getNullValOrder() != null)) {
            iDataObject.set(FIELD_NULLVALORDER, (Object)pSDEFDTColBase.getNullValOrder());
        }
        if (pSDEFDTColBase.isPrecision2Dirty() && (bl || pSDEFDTColBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSDEFDTColBase.getPrecision2());
        }
        if (pSDEFDTColBase.isPSDEFDTColIdDirty() && (bl || pSDEFDTColBase.getPSDEFDTColId() != null)) {
            iDataObject.set(FIELD_PSDEFDTCOLID, (Object)pSDEFDTColBase.getPSDEFDTColId());
        }
        if (pSDEFDTColBase.isPSDEFDTColNameDirty() && (bl || pSDEFDTColBase.getPSDEFDTColName() != null)) {
            iDataObject.set(FIELD_PSDEFDTCOLNAME, (Object)pSDEFDTColBase.getPSDEFDTColName());
        }
        if (pSDEFDTColBase.isPSDEFIdDirty() && (bl || pSDEFDTColBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFDTColBase.getPSDEFId());
        }
        if (pSDEFDTColBase.isPSDEFNameDirty() && (bl || pSDEFDTColBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFDTColBase.getPSDEFName());
        }
        if (pSDEFDTColBase.isPSDEIdDirty() && (bl || pSDEFDTColBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFDTColBase.getPSDEId());
        }
        if (pSDEFDTColBase.isPSDENameDirty() && (bl || pSDEFDTColBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFDTColBase.getPSDEName());
        }
        if (pSDEFDTColBase.isTableNameDirty() && (bl || pSDEFDTColBase.getTableName() != null)) {
            iDataObject.set(FIELD_TABLENAME, (Object)pSDEFDTColBase.getTableName());
        }
        if (pSDEFDTColBase.isUpdateDateDirty() && (bl || pSDEFDTColBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFDTColBase.getUpdateDate());
        }
        if (pSDEFDTColBase.isUpdateManDirty() && (bl || pSDEFDTColBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFDTColBase.getUpdateMan());
        }
        if (pSDEFDTColBase.isUserCatDirty() && (bl || pSDEFDTColBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFDTColBase.getUserCat());
        }
        if (pSDEFDTColBase.isUserParamsDirty() && (bl || pSDEFDTColBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEFDTColBase.getUserParams());
        }
        if (pSDEFDTColBase.isUserTagDirty() && (bl || pSDEFDTColBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFDTColBase.getUserTag());
        }
        if (pSDEFDTColBase.isUserTag2Dirty() && (bl || pSDEFDTColBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFDTColBase.getUserTag2());
        }
        if (pSDEFDTColBase.isUserTag3Dirty() && (bl || pSDEFDTColBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFDTColBase.getUserTag3());
        }
        if (pSDEFDTColBase.isUserTag4Dirty() && (bl || pSDEFDTColBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFDTColBase.getUserTag4());
        }
        if (pSDEFDTColBase.isValueFunc2FieldsDirty() && (bl || pSDEFDTColBase.getValueFunc2Fields() != null)) {
            iDataObject.set(FIELD_VALUEFUNC2FIELDS, (Object)pSDEFDTColBase.getValueFunc2Fields());
        }
        if (pSDEFDTColBase.isValueFunc2FormatDirty() && (bl || pSDEFDTColBase.getValueFunc2Format() != null)) {
            iDataObject.set(FIELD_VALUEFUNC2FORMAT, (Object)pSDEFDTColBase.getValueFunc2Format());
        }
        if (pSDEFDTColBase.isValueFuncFieldsDirty() && (bl || pSDEFDTColBase.getValueFuncFields() != null)) {
            iDataObject.set(FIELD_VALUEFUNCFIELDS, (Object)pSDEFDTColBase.getValueFuncFields());
        }
        if (pSDEFDTColBase.isValueFuncFormatDirty() && (bl || pSDEFDTColBase.getValueFuncFormat() != null)) {
            iDataObject.set(FIELD_VALUEFUNCFORMAT, (Object)pSDEFDTColBase.getValueFuncFormat());
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
        return PSDEFDTColBase.remove(this, n);
    }

    private static boolean remove(PSDEFDTColBase pSDEFDTColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFDTColBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFDTColBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFDTColBase.resetCustomDataType();
                return true;
            }
            case 3: {
                pSDEFDTColBase.resetDataType();
                return true;
            }
            case 4: {
                pSDEFDTColBase.resetDBType();
                return true;
            }
            case 5: {
                pSDEFDTColBase.resetDefaultValue();
                return true;
            }
            case 6: {
                pSDEFDTColBase.resetFormulaFields();
                return true;
            }
            case 7: {
                pSDEFDTColBase.resetFormulaFormat();
                return true;
            }
            case 8: {
                pSDEFDTColBase.resetLength();
                return true;
            }
            case 9: {
                pSDEFDTColBase.resetMemo();
                return true;
            }
            case 10: {
                pSDEFDTColBase.resetNullValOrder();
                return true;
            }
            case 11: {
                pSDEFDTColBase.resetPrecision2();
                return true;
            }
            case 12: {
                pSDEFDTColBase.resetPSDEFDTColId();
                return true;
            }
            case 13: {
                pSDEFDTColBase.resetPSDEFDTColName();
                return true;
            }
            case 14: {
                pSDEFDTColBase.resetPSDEFId();
                return true;
            }
            case 15: {
                pSDEFDTColBase.resetPSDEFName();
                return true;
            }
            case 16: {
                pSDEFDTColBase.resetPSDEId();
                return true;
            }
            case 17: {
                pSDEFDTColBase.resetPSDEName();
                return true;
            }
            case 18: {
                pSDEFDTColBase.resetTableName();
                return true;
            }
            case 19: {
                pSDEFDTColBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDEFDTColBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDEFDTColBase.resetUserCat();
                return true;
            }
            case 22: {
                pSDEFDTColBase.resetUserParams();
                return true;
            }
            case 23: {
                pSDEFDTColBase.resetUserTag();
                return true;
            }
            case 24: {
                pSDEFDTColBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSDEFDTColBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSDEFDTColBase.resetUserTag4();
                return true;
            }
            case 27: {
                pSDEFDTColBase.resetValueFunc2Fields();
                return true;
            }
            case 28: {
                pSDEFDTColBase.resetValueFunc2Format();
                return true;
            }
            case 29: {
                pSDEFDTColBase.resetValueFuncFields();
                return true;
            }
            case 30: {
                pSDEFDTColBase.resetValueFuncFormat();
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

    private PSDEFDTColBase getProxyEntity() {
        return this.proxyPSDEFDTColBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFDTColBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFDTColBase) {
            this.proxyPSDEFDTColBase = (PSDEFDTColBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CUSTOMDATATYPE, 2);
        fieldIndexMap.put(FIELD_DATATYPE, 3);
        fieldIndexMap.put(FIELD_DBTYPE, 4);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 5);
        fieldIndexMap.put(FIELD_FORMULAFIELDS, 6);
        fieldIndexMap.put(FIELD_FORMULAFORMAT, 7);
        fieldIndexMap.put(FIELD_LENGTH, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_NULLVALORDER, 10);
        fieldIndexMap.put(FIELD_PRECISION2, 11);
        fieldIndexMap.put(FIELD_PSDEFDTCOLID, 12);
        fieldIndexMap.put(FIELD_PSDEFDTCOLNAME, 13);
        fieldIndexMap.put(FIELD_PSDEFID, 14);
        fieldIndexMap.put(FIELD_PSDEFNAME, 15);
        fieldIndexMap.put(FIELD_PSDEID, 16);
        fieldIndexMap.put(FIELD_PSDENAME, 17);
        fieldIndexMap.put(FIELD_TABLENAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERPARAMS, 22);
        fieldIndexMap.put(FIELD_USERTAG, 23);
        fieldIndexMap.put(FIELD_USERTAG2, 24);
        fieldIndexMap.put(FIELD_USERTAG3, 25);
        fieldIndexMap.put(FIELD_USERTAG4, 26);
        fieldIndexMap.put(FIELD_VALUEFUNC2FIELDS, 27);
        fieldIndexMap.put(FIELD_VALUEFUNC2FORMAT, 28);
        fieldIndexMap.put(FIELD_VALUEFUNCFIELDS, 29);
        fieldIndexMap.put(FIELD_VALUEFUNCFORMAT, 30);
    }
}

