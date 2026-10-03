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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSUnit;
import net.ibizsys.pscore.srv.config.entity.PSValueRule;
import net.ibizsys.pscore.srv.config.service.PSUnitService;
import net.ibizsys.pscore.srv.config.service.PSValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFDataTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFDataTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DB2DATATYPE = "DB2DATATYPE";
    public static final String FIELD_ENABLEUSERCREATE = "ENABLEUSERCREATE";
    public static final String FIELD_EXPHYFLAG = "EXPHYFLAG";
    public static final String FIELD_FORMULARFLAG = "FORMULAFLAG";
    public static final String FIELD_INTDATATYPE = "INTDATATYPE";
    public static final String FIELD_INTDATATYPE2 = "INTDATATYPE2";
    public static final String FIELD_LENGTH = "LENGTH";
    public static final String FIELD_LINKFLAG = "LINKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSSQLDATATYPE = "MSSQLDATATYPE";
    public static final String FIELD_MYSQLDATATYPE = "MYSQLDATATYPE";
    public static final String FIELD_ORACLEDATATYPE = "ORACLEDATATYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PHYSICALFLAG = "PHYSICALFLAG";
    public static final String FIELD_POSTGRESQLTYPE = "POSTGRESQLTYPE";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PSDEFDATATYPEID = "PSDEFDATATYPEID";
    public static final String FIELD_PSDEFDATATYPENAME = "PSDEFDATATYPENAME";
    public static final String FIELD_PSUNITID = "PSUNITID";
    public static final String FIELD_PSUNITNAME = "PSUNITNAME";
    public static final String FIELD_PSVALUERULEID = "PSVALUERULEID";
    public static final String FIELD_PSVALUERULENAME = "PSVALUERULENAME";
    public static final String FIELD_SADEFIELDTYPE = "SADEFIELDTYPE";
    public static final String FIELD_SADEFIELDTYPE2 = "SADEFIELDTYPE2";
    public static final String FIELD_TYPEDESC = "TYPEDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DB2DATATYPE = 2;
    private static final int INDEX_ENABLEUSERCREATE = 3;
    private static final int INDEX_EXPHYFLAG = 4;
    private static final int INDEX_FORMULARFLAG = 5;
    private static final int INDEX_INTDATATYPE = 6;
    private static final int INDEX_INTDATATYPE2 = 7;
    private static final int INDEX_LENGTH = 8;
    private static final int INDEX_LINKFLAG = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_MSSQLDATATYPE = 11;
    private static final int INDEX_MYSQLDATATYPE = 12;
    private static final int INDEX_ORACLEDATATYPE = 13;
    private static final int INDEX_ORDERVALUE = 14;
    private static final int INDEX_PHYSICALFLAG = 15;
    private static final int INDEX_POSTGRESQLTYPE = 16;
    private static final int INDEX_PRECISION2 = 17;
    private static final int INDEX_PSDEFDATATYPEID = 18;
    private static final int INDEX_PSDEFDATATYPENAME = 19;
    private static final int INDEX_PSUNITID = 20;
    private static final int INDEX_PSUNITNAME = 21;
    private static final int INDEX_PSVALUERULEID = 22;
    private static final int INDEX_PSVALUERULENAME = 23;
    private static final int INDEX_SADEFIELDTYPE = 24;
    private static final int INDEX_SADEFIELDTYPE2 = 25;
    private static final int INDEX_TYPEDESC = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_VALIDFLAG = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFDataTypeBase proxyPSDEFDataTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean db2datatypeDirtyFlag = false;
    private boolean enableusercreateDirtyFlag = false;
    private boolean exphyflagDirtyFlag = false;
    private boolean formularflagDirtyFlag = false;
    private boolean intdatatypeDirtyFlag = false;
    private boolean intdatatype2DirtyFlag = false;
    private boolean lengthDirtyFlag = false;
    private boolean linkflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mssqldatatypeDirtyFlag = false;
    private boolean mysqldatatypeDirtyFlag = false;
    private boolean oracledatatypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean physicalflagDirtyFlag = false;
    private boolean postgresqltypeDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean psdefdatatypeidDirtyFlag = false;
    private boolean psdefdatatypenameDirtyFlag = false;
    private boolean psunitidDirtyFlag = false;
    private boolean psunitnameDirtyFlag = false;
    private boolean psvalueruleidDirtyFlag = false;
    private boolean psvaluerulenameDirtyFlag = false;
    private boolean sadefieldtypeDirtyFlag = false;
    private boolean sadefieldtype2DirtyFlag = false;
    private boolean typedescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="db2datatype")
    private String db2datatype;
    @Column(name="enableusercreate")
    private Integer enableusercreate;
    @Column(name="exphyflag")
    private Integer exphyflag;
    @Column(name="formularflag")
    private Integer formularflag;
    @Column(name="intdatatype")
    private String intdatatype;
    @Column(name="intdatatype2")
    private String intdatatype2;
    @Column(name="length")
    private Integer length;
    @Column(name="linkflag")
    private Integer linkflag;
    @Column(name="memo")
    private String memo;
    @Column(name="mssqldatatype")
    private String mssqldatatype;
    @Column(name="mysqldatatype")
    private String mysqldatatype;
    @Column(name="oracledatatype")
    private String oracledatatype;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="physicalflag")
    private Integer physicalflag;
    @Column(name="postgresqltype")
    private String postgresqltype;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="psdefdatatypeid")
    private String psdefdatatypeid;
    @Column(name="psdefdatatypename")
    private String psdefdatatypename;
    @Column(name="psunitid")
    private String psunitid;
    @Column(name="psunitname")
    private String psunitname;
    @Column(name="psvalueruleid")
    private String psvalueruleid;
    @Column(name="psvaluerulename")
    private String psvaluerulename;
    @Column(name="sadefieldtype")
    private Integer sadefieldtype;
    @Column(name="sadefieldtype2")
    private Integer sadefieldtype2;
    @Column(name="typedesc")
    private String typedesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSUnitLock = new Integer(1);
    private PSUnit psunit = null;
    private Integer objPSValueRuleLock = new Integer(1);
    private PSValueRule psvaluerule = null;

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

    public void setDB2DataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDB2DataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.db2datatype = string;
        this.db2datatypeDirtyFlag = true;
    }

    public String getDB2DataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDB2DataType();
        }
        return this.db2datatype;
    }

    public boolean isDB2DataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDB2DataTypeDirty();
        }
        return this.db2datatypeDirtyFlag;
    }

    public void resetDB2DataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDB2DataType();
            return;
        }
        this.db2datatypeDirtyFlag = false;
        this.db2datatype = null;
    }

    public void setEnableUserCreate(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableUserCreate(n);
            return;
        }
        this.enableusercreate = n;
        this.enableusercreateDirtyFlag = true;
    }

    public Integer getEnableUserCreate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableUserCreate();
        }
        return this.enableusercreate;
    }

    public boolean isEnableUserCreateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableUserCreateDirty();
        }
        return this.enableusercreateDirtyFlag;
    }

    public void resetEnableUserCreate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableUserCreate();
            return;
        }
        this.enableusercreateDirtyFlag = false;
        this.enableusercreate = null;
    }

    public void setExPhyFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExPhyFlag(n);
            return;
        }
        this.exphyflag = n;
        this.exphyflagDirtyFlag = true;
    }

    public Integer getExPhyFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExPhyFlag();
        }
        return this.exphyflag;
    }

    public boolean isExPhyFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExPhyFlagDirty();
        }
        return this.exphyflagDirtyFlag;
    }

    public void resetExPhyFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExPhyFlag();
            return;
        }
        this.exphyflagDirtyFlag = false;
        this.exphyflag = null;
    }

    public void setFormularFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormularFlag(n);
            return;
        }
        this.formularflag = n;
        this.formularflagDirtyFlag = true;
    }

    public Integer getFormularFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormularFlag();
        }
        return this.formularflag;
    }

    public boolean isFormularFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormularFlagDirty();
        }
        return this.formularflagDirtyFlag;
    }

    public void resetFormularFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormularFlag();
            return;
        }
        this.formularflagDirtyFlag = false;
        this.formularflag = null;
    }

    public void setIntDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIntDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.intdatatype = string;
        this.intdatatypeDirtyFlag = true;
    }

    public String getIntDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIntDataType();
        }
        return this.intdatatype;
    }

    public boolean isIntDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIntDataTypeDirty();
        }
        return this.intdatatypeDirtyFlag;
    }

    public void resetIntDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIntDataType();
            return;
        }
        this.intdatatypeDirtyFlag = false;
        this.intdatatype = null;
    }

    public void setIntDataType2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIntDataType2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.intdatatype2 = string;
        this.intdatatype2DirtyFlag = true;
    }

    public String getIntDataType2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIntDataType2();
        }
        return this.intdatatype2;
    }

    public boolean isIntDataType2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIntDataType2Dirty();
        }
        return this.intdatatype2DirtyFlag;
    }

    public void resetIntDataType2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIntDataType2();
            return;
        }
        this.intdatatype2DirtyFlag = false;
        this.intdatatype2 = null;
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

    public void setLinkFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkFlag(n);
            return;
        }
        this.linkflag = n;
        this.linkflagDirtyFlag = true;
    }

    public Integer getLinkFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkFlag();
        }
        return this.linkflag;
    }

    public boolean isLinkFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkFlagDirty();
        }
        return this.linkflagDirtyFlag;
    }

    public void resetLinkFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkFlag();
            return;
        }
        this.linkflagDirtyFlag = false;
        this.linkflag = null;
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

    public void setMSSQLDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSSQLDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mssqldatatype = string;
        this.mssqldatatypeDirtyFlag = true;
    }

    public String getMSSQLDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSSQLDataType();
        }
        return this.mssqldatatype;
    }

    public boolean isMSSQLDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSSQLDataTypeDirty();
        }
        return this.mssqldatatypeDirtyFlag;
    }

    public void resetMSSQLDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSSQLDataType();
            return;
        }
        this.mssqldatatypeDirtyFlag = false;
        this.mssqldatatype = null;
    }

    public void setMySQLDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMySQLDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mysqldatatype = string;
        this.mysqldatatypeDirtyFlag = true;
    }

    public String getMySQLDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMySQLDataType();
        }
        return this.mysqldatatype;
    }

    public boolean isMySQLDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMySQLDataTypeDirty();
        }
        return this.mysqldatatypeDirtyFlag;
    }

    public void resetMySQLDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMySQLDataType();
            return;
        }
        this.mysqldatatypeDirtyFlag = false;
        this.mysqldatatype = null;
    }

    public void setOracleDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOracleDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.oracledatatype = string;
        this.oracledatatypeDirtyFlag = true;
    }

    public String getOracleDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOracleDataType();
        }
        return this.oracledatatype;
    }

    public boolean isOracleDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOracleDataTypeDirty();
        }
        return this.oracledatatypeDirtyFlag;
    }

    public void resetOracleDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOracleDataType();
            return;
        }
        this.oracledatatypeDirtyFlag = false;
        this.oracledatatype = null;
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

    public void setPhysicalFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPhysicalFlag(n);
            return;
        }
        this.physicalflag = n;
        this.physicalflagDirtyFlag = true;
    }

    public Integer getPhysicalFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPhysicalFlag();
        }
        return this.physicalflag;
    }

    public boolean isPhysicalFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPhysicalFlagDirty();
        }
        return this.physicalflagDirtyFlag;
    }

    public void resetPhysicalFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPhysicalFlag();
            return;
        }
        this.physicalflagDirtyFlag = false;
        this.physicalflag = null;
    }

    public void setPostgreSQLType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPostgreSQLType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.postgresqltype = string;
        this.postgresqltypeDirtyFlag = true;
    }

    public String getPostgreSQLType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPostgreSQLType();
        }
        return this.postgresqltype;
    }

    public boolean isPostgreSQLTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPostgreSQLTypeDirty();
        }
        return this.postgresqltypeDirtyFlag;
    }

    public void resetPostgreSQLType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPostgreSQLType();
            return;
        }
        this.postgresqltypeDirtyFlag = false;
        this.postgresqltype = null;
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

    public void setPSDEFDataTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFDataTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefdatatypeid = string;
        this.psdefdatatypeidDirtyFlag = true;
    }

    public String getPSDEFDataTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDataTypeId();
        }
        return this.psdefdatatypeid;
    }

    public boolean isPSDEFDataTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFDataTypeIdDirty();
        }
        return this.psdefdatatypeidDirtyFlag;
    }

    public void resetPSDEFDataTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFDataTypeId();
            return;
        }
        this.psdefdatatypeidDirtyFlag = false;
        this.psdefdatatypeid = null;
    }

    public void setPSDEFDataTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFDataTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefdatatypename = string;
        this.psdefdatatypenameDirtyFlag = true;
    }

    public String getPSDEFDataTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDataTypeName();
        }
        return this.psdefdatatypename;
    }

    public boolean isPSDEFDataTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFDataTypeNameDirty();
        }
        return this.psdefdatatypenameDirtyFlag;
    }

    public void resetPSDEFDataTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFDataTypeName();
            return;
        }
        this.psdefdatatypenameDirtyFlag = false;
        this.psdefdatatypename = null;
    }

    public void setPSUnitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUnitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psunitid = string;
        this.psunitidDirtyFlag = true;
    }

    public String getPSUnitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnitId();
        }
        return this.psunitid;
    }

    public boolean isPSUnitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUnitIdDirty();
        }
        return this.psunitidDirtyFlag;
    }

    public void resetPSUnitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUnitId();
            return;
        }
        this.psunitidDirtyFlag = false;
        this.psunitid = null;
    }

    public void setPSUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psunitname = string;
        this.psunitnameDirtyFlag = true;
    }

    public String getPSUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnitName();
        }
        return this.psunitname;
    }

    public boolean isPSUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUnitNameDirty();
        }
        return this.psunitnameDirtyFlag;
    }

    public void resetPSUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUnitName();
            return;
        }
        this.psunitnameDirtyFlag = false;
        this.psunitname = null;
    }

    public void setPSValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvalueruleid = string;
        this.psvalueruleidDirtyFlag = true;
    }

    public String getPSValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRuleId();
        }
        return this.psvalueruleid;
    }

    public boolean isPSValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSValueRuleIdDirty();
        }
        return this.psvalueruleidDirtyFlag;
    }

    public void resetPSValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSValueRuleId();
            return;
        }
        this.psvalueruleidDirtyFlag = false;
        this.psvalueruleid = null;
    }

    public void setPSValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvaluerulename = string;
        this.psvaluerulenameDirtyFlag = true;
    }

    public String getPSValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRuleName();
        }
        return this.psvaluerulename;
    }

    public boolean isPSValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSValueRuleNameDirty();
        }
        return this.psvaluerulenameDirtyFlag;
    }

    public void resetPSValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSValueRuleName();
            return;
        }
        this.psvaluerulenameDirtyFlag = false;
        this.psvaluerulename = null;
    }

    public void setSADEFieldType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSADEFieldType(n);
            return;
        }
        this.sadefieldtype = n;
        this.sadefieldtypeDirtyFlag = true;
    }

    public Integer getSADEFieldType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSADEFieldType();
        }
        return this.sadefieldtype;
    }

    public boolean isSADEFieldTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSADEFieldTypeDirty();
        }
        return this.sadefieldtypeDirtyFlag;
    }

    public void resetSADEFieldType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSADEFieldType();
            return;
        }
        this.sadefieldtypeDirtyFlag = false;
        this.sadefieldtype = null;
    }

    public void setSADEFieldType2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSADEFieldType2(n);
            return;
        }
        this.sadefieldtype2 = n;
        this.sadefieldtype2DirtyFlag = true;
    }

    public Integer getSADEFieldType2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSADEFieldType2();
        }
        return this.sadefieldtype2;
    }

    public boolean isSADEFieldType2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSADEFieldType2Dirty();
        }
        return this.sadefieldtype2DirtyFlag;
    }

    public void resetSADEFieldType2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSADEFieldType2();
            return;
        }
        this.sadefieldtype2DirtyFlag = false;
        this.sadefieldtype2 = null;
    }

    public void setTypeDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typedesc = string;
        this.typedescDirtyFlag = true;
    }

    public String getTypeDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeDesc();
        }
        return this.typedesc;
    }

    public boolean isTypeDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeDescDirty();
        }
        return this.typedescDirtyFlag;
    }

    public void resetTypeDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeDesc();
            return;
        }
        this.typedescDirtyFlag = false;
        this.typedesc = null;
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

    protected void onReset() {
        PSDEFDataTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFDataTypeBase pSDEFDataTypeBase) {
        pSDEFDataTypeBase.resetCreateDate();
        pSDEFDataTypeBase.resetCreateMan();
        pSDEFDataTypeBase.resetDB2DataType();
        pSDEFDataTypeBase.resetEnableUserCreate();
        pSDEFDataTypeBase.resetExPhyFlag();
        pSDEFDataTypeBase.resetFormularFlag();
        pSDEFDataTypeBase.resetIntDataType();
        pSDEFDataTypeBase.resetIntDataType2();
        pSDEFDataTypeBase.resetLength();
        pSDEFDataTypeBase.resetLinkFlag();
        pSDEFDataTypeBase.resetMemo();
        pSDEFDataTypeBase.resetMSSQLDataType();
        pSDEFDataTypeBase.resetMySQLDataType();
        pSDEFDataTypeBase.resetOracleDataType();
        pSDEFDataTypeBase.resetOrderValue();
        pSDEFDataTypeBase.resetPhysicalFlag();
        pSDEFDataTypeBase.resetPostgreSQLType();
        pSDEFDataTypeBase.resetPrecision2();
        pSDEFDataTypeBase.resetPSDEFDataTypeId();
        pSDEFDataTypeBase.resetPSDEFDataTypeName();
        pSDEFDataTypeBase.resetPSUnitId();
        pSDEFDataTypeBase.resetPSUnitName();
        pSDEFDataTypeBase.resetPSValueRuleId();
        pSDEFDataTypeBase.resetPSValueRuleName();
        pSDEFDataTypeBase.resetSADEFieldType();
        pSDEFDataTypeBase.resetSADEFieldType2();
        pSDEFDataTypeBase.resetTypeDesc();
        pSDEFDataTypeBase.resetUpdateDate();
        pSDEFDataTypeBase.resetUpdateMan();
        pSDEFDataTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDB2DataTypeDirty()) {
            hashMap.put(FIELD_DB2DATATYPE, this.getDB2DataType());
        }
        if (!bl || this.isEnableUserCreateDirty()) {
            hashMap.put(FIELD_ENABLEUSERCREATE, this.getEnableUserCreate());
        }
        if (!bl || this.isExPhyFlagDirty()) {
            hashMap.put(FIELD_EXPHYFLAG, this.getExPhyFlag());
        }
        if (!bl || this.isFormularFlagDirty()) {
            hashMap.put(FIELD_FORMULARFLAG, this.getFormularFlag());
        }
        if (!bl || this.isIntDataTypeDirty()) {
            hashMap.put(FIELD_INTDATATYPE, this.getIntDataType());
        }
        if (!bl || this.isIntDataType2Dirty()) {
            hashMap.put(FIELD_INTDATATYPE2, this.getIntDataType2());
        }
        if (!bl || this.isLengthDirty()) {
            hashMap.put(FIELD_LENGTH, this.getLength());
        }
        if (!bl || this.isLinkFlagDirty()) {
            hashMap.put(FIELD_LINKFLAG, this.getLinkFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMSSQLDataTypeDirty()) {
            hashMap.put(FIELD_MSSQLDATATYPE, this.getMSSQLDataType());
        }
        if (!bl || this.isMySQLDataTypeDirty()) {
            hashMap.put(FIELD_MYSQLDATATYPE, this.getMySQLDataType());
        }
        if (!bl || this.isOracleDataTypeDirty()) {
            hashMap.put(FIELD_ORACLEDATATYPE, this.getOracleDataType());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPhysicalFlagDirty()) {
            hashMap.put(FIELD_PHYSICALFLAG, this.getPhysicalFlag());
        }
        if (!bl || this.isPostgreSQLTypeDirty()) {
            hashMap.put(FIELD_POSTGRESQLTYPE, this.getPostgreSQLType());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPSDEFDataTypeIdDirty()) {
            hashMap.put(FIELD_PSDEFDATATYPEID, this.getPSDEFDataTypeId());
        }
        if (!bl || this.isPSDEFDataTypeNameDirty()) {
            hashMap.put(FIELD_PSDEFDATATYPENAME, this.getPSDEFDataTypeName());
        }
        if (!bl || this.isPSUnitIdDirty()) {
            hashMap.put(FIELD_PSUNITID, this.getPSUnitId());
        }
        if (!bl || this.isPSUnitNameDirty()) {
            hashMap.put(FIELD_PSUNITNAME, this.getPSUnitName());
        }
        if (!bl || this.isPSValueRuleIdDirty()) {
            hashMap.put(FIELD_PSVALUERULEID, this.getPSValueRuleId());
        }
        if (!bl || this.isPSValueRuleNameDirty()) {
            hashMap.put(FIELD_PSVALUERULENAME, this.getPSValueRuleName());
        }
        if (!bl || this.isSADEFieldTypeDirty()) {
            hashMap.put(FIELD_SADEFIELDTYPE, this.getSADEFieldType());
        }
        if (!bl || this.isSADEFieldType2Dirty()) {
            hashMap.put(FIELD_SADEFIELDTYPE2, this.getSADEFieldType2());
        }
        if (!bl || this.isTypeDescDirty()) {
            hashMap.put(FIELD_TYPEDESC, this.getTypeDesc());
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
        return PSDEFDataTypeBase.get(this, n);
    }

    private static Object get(PSDEFDataTypeBase pSDEFDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDataTypeBase.getCreateDate();
            }
            case 1: {
                return pSDEFDataTypeBase.getCreateMan();
            }
            case 2: {
                return pSDEFDataTypeBase.getDB2DataType();
            }
            case 3: {
                return pSDEFDataTypeBase.getEnableUserCreate();
            }
            case 4: {
                return pSDEFDataTypeBase.getExPhyFlag();
            }
            case 5: {
                return pSDEFDataTypeBase.getFormularFlag();
            }
            case 6: {
                return pSDEFDataTypeBase.getIntDataType();
            }
            case 7: {
                return pSDEFDataTypeBase.getIntDataType2();
            }
            case 8: {
                return pSDEFDataTypeBase.getLength();
            }
            case 9: {
                return pSDEFDataTypeBase.getLinkFlag();
            }
            case 10: {
                return pSDEFDataTypeBase.getMemo();
            }
            case 11: {
                return pSDEFDataTypeBase.getMSSQLDataType();
            }
            case 12: {
                return pSDEFDataTypeBase.getMySQLDataType();
            }
            case 13: {
                return pSDEFDataTypeBase.getOracleDataType();
            }
            case 14: {
                return pSDEFDataTypeBase.getOrderValue();
            }
            case 15: {
                return pSDEFDataTypeBase.getPhysicalFlag();
            }
            case 16: {
                return pSDEFDataTypeBase.getPostgreSQLType();
            }
            case 17: {
                return pSDEFDataTypeBase.getPrecision2();
            }
            case 18: {
                return pSDEFDataTypeBase.getPSDEFDataTypeId();
            }
            case 19: {
                return pSDEFDataTypeBase.getPSDEFDataTypeName();
            }
            case 20: {
                return pSDEFDataTypeBase.getPSUnitId();
            }
            case 21: {
                return pSDEFDataTypeBase.getPSUnitName();
            }
            case 22: {
                return pSDEFDataTypeBase.getPSValueRuleId();
            }
            case 23: {
                return pSDEFDataTypeBase.getPSValueRuleName();
            }
            case 24: {
                return pSDEFDataTypeBase.getSADEFieldType();
            }
            case 25: {
                return pSDEFDataTypeBase.getSADEFieldType2();
            }
            case 26: {
                return pSDEFDataTypeBase.getTypeDesc();
            }
            case 27: {
                return pSDEFDataTypeBase.getUpdateDate();
            }
            case 28: {
                return pSDEFDataTypeBase.getUpdateMan();
            }
            case 29: {
                return pSDEFDataTypeBase.getValidFlag();
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
        PSDEFDataTypeBase.set(this, n, object);
    }

    private static void set(PSDEFDataTypeBase pSDEFDataTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFDataTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFDataTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFDataTypeBase.setDB2DataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFDataTypeBase.setEnableUserCreate(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEFDataTypeBase.setExPhyFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEFDataTypeBase.setFormularFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEFDataTypeBase.setIntDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFDataTypeBase.setIntDataType2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFDataTypeBase.setLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEFDataTypeBase.setLinkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEFDataTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFDataTypeBase.setMSSQLDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFDataTypeBase.setMySQLDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFDataTypeBase.setOracleDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFDataTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEFDataTypeBase.setPhysicalFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEFDataTypeBase.setPostgreSQLType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFDataTypeBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEFDataTypeBase.setPSDEFDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFDataTypeBase.setPSDEFDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFDataTypeBase.setPSUnitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFDataTypeBase.setPSUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFDataTypeBase.setPSValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFDataTypeBase.setPSValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFDataTypeBase.setSADEFieldType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEFDataTypeBase.setSADEFieldType2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEFDataTypeBase.setTypeDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFDataTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDEFDataTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFDataTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEFDataTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFDataTypeBase pSDEFDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDataTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFDataTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFDataTypeBase.getDB2DataType() == null;
            }
            case 3: {
                return pSDEFDataTypeBase.getEnableUserCreate() == null;
            }
            case 4: {
                return pSDEFDataTypeBase.getExPhyFlag() == null;
            }
            case 5: {
                return pSDEFDataTypeBase.getFormularFlag() == null;
            }
            case 6: {
                return pSDEFDataTypeBase.getIntDataType() == null;
            }
            case 7: {
                return pSDEFDataTypeBase.getIntDataType2() == null;
            }
            case 8: {
                return pSDEFDataTypeBase.getLength() == null;
            }
            case 9: {
                return pSDEFDataTypeBase.getLinkFlag() == null;
            }
            case 10: {
                return pSDEFDataTypeBase.getMemo() == null;
            }
            case 11: {
                return pSDEFDataTypeBase.getMSSQLDataType() == null;
            }
            case 12: {
                return pSDEFDataTypeBase.getMySQLDataType() == null;
            }
            case 13: {
                return pSDEFDataTypeBase.getOracleDataType() == null;
            }
            case 14: {
                return pSDEFDataTypeBase.getOrderValue() == null;
            }
            case 15: {
                return pSDEFDataTypeBase.getPhysicalFlag() == null;
            }
            case 16: {
                return pSDEFDataTypeBase.getPostgreSQLType() == null;
            }
            case 17: {
                return pSDEFDataTypeBase.getPrecision2() == null;
            }
            case 18: {
                return pSDEFDataTypeBase.getPSDEFDataTypeId() == null;
            }
            case 19: {
                return pSDEFDataTypeBase.getPSDEFDataTypeName() == null;
            }
            case 20: {
                return pSDEFDataTypeBase.getPSUnitId() == null;
            }
            case 21: {
                return pSDEFDataTypeBase.getPSUnitName() == null;
            }
            case 22: {
                return pSDEFDataTypeBase.getPSValueRuleId() == null;
            }
            case 23: {
                return pSDEFDataTypeBase.getPSValueRuleName() == null;
            }
            case 24: {
                return pSDEFDataTypeBase.getSADEFieldType() == null;
            }
            case 25: {
                return pSDEFDataTypeBase.getSADEFieldType2() == null;
            }
            case 26: {
                return pSDEFDataTypeBase.getTypeDesc() == null;
            }
            case 27: {
                return pSDEFDataTypeBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDEFDataTypeBase.getUpdateMan() == null;
            }
            case 29: {
                return pSDEFDataTypeBase.getValidFlag() == null;
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
        return PSDEFDataTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEFDataTypeBase pSDEFDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDataTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFDataTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFDataTypeBase.isDB2DataTypeDirty();
            }
            case 3: {
                return pSDEFDataTypeBase.isEnableUserCreateDirty();
            }
            case 4: {
                return pSDEFDataTypeBase.isExPhyFlagDirty();
            }
            case 5: {
                return pSDEFDataTypeBase.isFormularFlagDirty();
            }
            case 6: {
                return pSDEFDataTypeBase.isIntDataTypeDirty();
            }
            case 7: {
                return pSDEFDataTypeBase.isIntDataType2Dirty();
            }
            case 8: {
                return pSDEFDataTypeBase.isLengthDirty();
            }
            case 9: {
                return pSDEFDataTypeBase.isLinkFlagDirty();
            }
            case 10: {
                return pSDEFDataTypeBase.isMemoDirty();
            }
            case 11: {
                return pSDEFDataTypeBase.isMSSQLDataTypeDirty();
            }
            case 12: {
                return pSDEFDataTypeBase.isMySQLDataTypeDirty();
            }
            case 13: {
                return pSDEFDataTypeBase.isOracleDataTypeDirty();
            }
            case 14: {
                return pSDEFDataTypeBase.isOrderValueDirty();
            }
            case 15: {
                return pSDEFDataTypeBase.isPhysicalFlagDirty();
            }
            case 16: {
                return pSDEFDataTypeBase.isPostgreSQLTypeDirty();
            }
            case 17: {
                return pSDEFDataTypeBase.isPrecision2Dirty();
            }
            case 18: {
                return pSDEFDataTypeBase.isPSDEFDataTypeIdDirty();
            }
            case 19: {
                return pSDEFDataTypeBase.isPSDEFDataTypeNameDirty();
            }
            case 20: {
                return pSDEFDataTypeBase.isPSUnitIdDirty();
            }
            case 21: {
                return pSDEFDataTypeBase.isPSUnitNameDirty();
            }
            case 22: {
                return pSDEFDataTypeBase.isPSValueRuleIdDirty();
            }
            case 23: {
                return pSDEFDataTypeBase.isPSValueRuleNameDirty();
            }
            case 24: {
                return pSDEFDataTypeBase.isSADEFieldTypeDirty();
            }
            case 25: {
                return pSDEFDataTypeBase.isSADEFieldType2Dirty();
            }
            case 26: {
                return pSDEFDataTypeBase.isTypeDescDirty();
            }
            case 27: {
                return pSDEFDataTypeBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDEFDataTypeBase.isUpdateManDirty();
            }
            case 29: {
                return pSDEFDataTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFDataTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFDataTypeBase pSDEFDataTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFDataTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getDB2DataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"db2datatype", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getDB2DataType()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getEnableUserCreate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableusercreate", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getEnableUserCreate()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getExPhyFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exphyflag", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getExPhyFlag()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getFormularFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formulaflag", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getFormularFlag()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getIntDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"intdatatype", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getIntDataType()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getIntDataType2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"intdatatype2", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getIntDataType2()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"length", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getLength()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getLinkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkflag", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getLinkFlag()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getMSSQLDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mssqldatatype", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getMSSQLDataType()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getMySQLDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mysqldatatype", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getMySQLDataType()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getOracleDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"oracledatatype", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getOracleDataType()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPhysicalFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"physicalflag", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPhysicalFlag()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPostgreSQLType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"postgresqltype", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPostgreSQLType()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPSDEFDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefdatatypeid", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPSDEFDataTypeId()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPSDEFDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefdatatypename", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPSDEFDataTypeName()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPSUnitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psunitid", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPSUnitId()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPSUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psunitname", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPSUnitName()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPSValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvalueruleid", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPSValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getPSValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvaluerulename", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getPSValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getSADEFieldType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sadefieldtype", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getSADEFieldType()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getSADEFieldType2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sadefieldtype2", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getSADEFieldType2()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getTypeDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typedesc", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getTypeDesc()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFDataTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEFDataTypeBase.getJSONValue((Object)pSDEFDataTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFDataTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFDataTypeBase pSDEFDataTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFDataTypeBase.getCreateDate() != null) {
            object = pSDEFDataTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getCreateMan() != null) {
            object = pSDEFDataTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getDB2DataType() != null) {
            object = pSDEFDataTypeBase.getDB2DataType();
            xmlNode.setAttribute(FIELD_DB2DATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getEnableUserCreate() != null) {
            object = pSDEFDataTypeBase.getEnableUserCreate();
            xmlNode.setAttribute(FIELD_ENABLEUSERCREATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getExPhyFlag() != null) {
            object = pSDEFDataTypeBase.getExPhyFlag();
            xmlNode.setAttribute(FIELD_EXPHYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getFormularFlag() != null) {
            object = pSDEFDataTypeBase.getFormularFlag();
            xmlNode.setAttribute("FORMULARFLAG", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getIntDataType() != null) {
            object = pSDEFDataTypeBase.getIntDataType();
            xmlNode.setAttribute(FIELD_INTDATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getIntDataType2() != null) {
            object = pSDEFDataTypeBase.getIntDataType2();
            xmlNode.setAttribute(FIELD_INTDATATYPE2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getLength() != null) {
            object = pSDEFDataTypeBase.getLength();
            xmlNode.setAttribute(FIELD_LENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getLinkFlag() != null) {
            object = pSDEFDataTypeBase.getLinkFlag();
            xmlNode.setAttribute(FIELD_LINKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getMemo() != null) {
            object = pSDEFDataTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getMSSQLDataType() != null) {
            object = pSDEFDataTypeBase.getMSSQLDataType();
            xmlNode.setAttribute(FIELD_MSSQLDATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getMySQLDataType() != null) {
            object = pSDEFDataTypeBase.getMySQLDataType();
            xmlNode.setAttribute(FIELD_MYSQLDATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getOracleDataType() != null) {
            object = pSDEFDataTypeBase.getOracleDataType();
            xmlNode.setAttribute(FIELD_ORACLEDATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getOrderValue() != null) {
            object = pSDEFDataTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getPhysicalFlag() != null) {
            object = pSDEFDataTypeBase.getPhysicalFlag();
            xmlNode.setAttribute(FIELD_PHYSICALFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getPostgreSQLType() != null) {
            object = pSDEFDataTypeBase.getPostgreSQLType();
            xmlNode.setAttribute(FIELD_POSTGRESQLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getPrecision2() != null) {
            object = pSDEFDataTypeBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getPSDEFDataTypeId() != null) {
            object = pSDEFDataTypeBase.getPSDEFDataTypeId();
            xmlNode.setAttribute(FIELD_PSDEFDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getPSDEFDataTypeName() != null) {
            object = pSDEFDataTypeBase.getPSDEFDataTypeName();
            xmlNode.setAttribute(FIELD_PSDEFDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getPSUnitId() != null) {
            object = pSDEFDataTypeBase.getPSUnitId();
            xmlNode.setAttribute(FIELD_PSUNITID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getPSUnitName() != null) {
            object = pSDEFDataTypeBase.getPSUnitName();
            xmlNode.setAttribute(FIELD_PSUNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getPSValueRuleId() != null) {
            object = pSDEFDataTypeBase.getPSValueRuleId();
            xmlNode.setAttribute(FIELD_PSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getPSValueRuleName() != null) {
            object = pSDEFDataTypeBase.getPSValueRuleName();
            xmlNode.setAttribute(FIELD_PSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getSADEFieldType() != null) {
            object = pSDEFDataTypeBase.getSADEFieldType();
            xmlNode.setAttribute(FIELD_SADEFIELDTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getSADEFieldType2() != null) {
            object = pSDEFDataTypeBase.getSADEFieldType2();
            xmlNode.setAttribute(FIELD_SADEFIELDTYPE2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getTypeDesc() != null) {
            object = pSDEFDataTypeBase.getTypeDesc();
            xmlNode.setAttribute(FIELD_TYPEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getUpdateDate() != null) {
            object = pSDEFDataTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFDataTypeBase.getUpdateMan() != null) {
            object = pSDEFDataTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDataTypeBase.getValidFlag() != null) {
            object = pSDEFDataTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFDataTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFDataTypeBase pSDEFDataTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFDataTypeBase.isCreateDateDirty() && (bl || pSDEFDataTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFDataTypeBase.getCreateDate());
        }
        if (pSDEFDataTypeBase.isCreateManDirty() && (bl || pSDEFDataTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFDataTypeBase.getCreateMan());
        }
        if (pSDEFDataTypeBase.isDB2DataTypeDirty() && (bl || pSDEFDataTypeBase.getDB2DataType() != null)) {
            iDataObject.set(FIELD_DB2DATATYPE, (Object)pSDEFDataTypeBase.getDB2DataType());
        }
        if (pSDEFDataTypeBase.isEnableUserCreateDirty() && (bl || pSDEFDataTypeBase.getEnableUserCreate() != null)) {
            iDataObject.set(FIELD_ENABLEUSERCREATE, (Object)pSDEFDataTypeBase.getEnableUserCreate());
        }
        if (pSDEFDataTypeBase.isExPhyFlagDirty() && (bl || pSDEFDataTypeBase.getExPhyFlag() != null)) {
            iDataObject.set(FIELD_EXPHYFLAG, (Object)pSDEFDataTypeBase.getExPhyFlag());
        }
        if (pSDEFDataTypeBase.isFormularFlagDirty() && (bl || pSDEFDataTypeBase.getFormularFlag() != null)) {
            iDataObject.set(FIELD_FORMULARFLAG, (Object)pSDEFDataTypeBase.getFormularFlag());
        }
        if (pSDEFDataTypeBase.isIntDataTypeDirty() && (bl || pSDEFDataTypeBase.getIntDataType() != null)) {
            iDataObject.set(FIELD_INTDATATYPE, (Object)pSDEFDataTypeBase.getIntDataType());
        }
        if (pSDEFDataTypeBase.isIntDataType2Dirty() && (bl || pSDEFDataTypeBase.getIntDataType2() != null)) {
            iDataObject.set(FIELD_INTDATATYPE2, (Object)pSDEFDataTypeBase.getIntDataType2());
        }
        if (pSDEFDataTypeBase.isLengthDirty() && (bl || pSDEFDataTypeBase.getLength() != null)) {
            iDataObject.set(FIELD_LENGTH, (Object)pSDEFDataTypeBase.getLength());
        }
        if (pSDEFDataTypeBase.isLinkFlagDirty() && (bl || pSDEFDataTypeBase.getLinkFlag() != null)) {
            iDataObject.set(FIELD_LINKFLAG, (Object)pSDEFDataTypeBase.getLinkFlag());
        }
        if (pSDEFDataTypeBase.isMemoDirty() && (bl || pSDEFDataTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFDataTypeBase.getMemo());
        }
        if (pSDEFDataTypeBase.isMSSQLDataTypeDirty() && (bl || pSDEFDataTypeBase.getMSSQLDataType() != null)) {
            iDataObject.set(FIELD_MSSQLDATATYPE, (Object)pSDEFDataTypeBase.getMSSQLDataType());
        }
        if (pSDEFDataTypeBase.isMySQLDataTypeDirty() && (bl || pSDEFDataTypeBase.getMySQLDataType() != null)) {
            iDataObject.set(FIELD_MYSQLDATATYPE, (Object)pSDEFDataTypeBase.getMySQLDataType());
        }
        if (pSDEFDataTypeBase.isOracleDataTypeDirty() && (bl || pSDEFDataTypeBase.getOracleDataType() != null)) {
            iDataObject.set(FIELD_ORACLEDATATYPE, (Object)pSDEFDataTypeBase.getOracleDataType());
        }
        if (pSDEFDataTypeBase.isOrderValueDirty() && (bl || pSDEFDataTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFDataTypeBase.getOrderValue());
        }
        if (pSDEFDataTypeBase.isPhysicalFlagDirty() && (bl || pSDEFDataTypeBase.getPhysicalFlag() != null)) {
            iDataObject.set(FIELD_PHYSICALFLAG, (Object)pSDEFDataTypeBase.getPhysicalFlag());
        }
        if (pSDEFDataTypeBase.isPostgreSQLTypeDirty() && (bl || pSDEFDataTypeBase.getPostgreSQLType() != null)) {
            iDataObject.set(FIELD_POSTGRESQLTYPE, (Object)pSDEFDataTypeBase.getPostgreSQLType());
        }
        if (pSDEFDataTypeBase.isPrecision2Dirty() && (bl || pSDEFDataTypeBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSDEFDataTypeBase.getPrecision2());
        }
        if (pSDEFDataTypeBase.isPSDEFDataTypeIdDirty() && (bl || pSDEFDataTypeBase.getPSDEFDataTypeId() != null)) {
            iDataObject.set(FIELD_PSDEFDATATYPEID, (Object)pSDEFDataTypeBase.getPSDEFDataTypeId());
        }
        if (pSDEFDataTypeBase.isPSDEFDataTypeNameDirty() && (bl || pSDEFDataTypeBase.getPSDEFDataTypeName() != null)) {
            iDataObject.set(FIELD_PSDEFDATATYPENAME, (Object)pSDEFDataTypeBase.getPSDEFDataTypeName());
        }
        if (pSDEFDataTypeBase.isPSUnitIdDirty() && (bl || pSDEFDataTypeBase.getPSUnitId() != null)) {
            iDataObject.set(FIELD_PSUNITID, (Object)pSDEFDataTypeBase.getPSUnitId());
        }
        if (pSDEFDataTypeBase.isPSUnitNameDirty() && (bl || pSDEFDataTypeBase.getPSUnitName() != null)) {
            iDataObject.set(FIELD_PSUNITNAME, (Object)pSDEFDataTypeBase.getPSUnitName());
        }
        if (pSDEFDataTypeBase.isPSValueRuleIdDirty() && (bl || pSDEFDataTypeBase.getPSValueRuleId() != null)) {
            iDataObject.set(FIELD_PSVALUERULEID, (Object)pSDEFDataTypeBase.getPSValueRuleId());
        }
        if (pSDEFDataTypeBase.isPSValueRuleNameDirty() && (bl || pSDEFDataTypeBase.getPSValueRuleName() != null)) {
            iDataObject.set(FIELD_PSVALUERULENAME, (Object)pSDEFDataTypeBase.getPSValueRuleName());
        }
        if (pSDEFDataTypeBase.isSADEFieldTypeDirty() && (bl || pSDEFDataTypeBase.getSADEFieldType() != null)) {
            iDataObject.set(FIELD_SADEFIELDTYPE, (Object)pSDEFDataTypeBase.getSADEFieldType());
        }
        if (pSDEFDataTypeBase.isSADEFieldType2Dirty() && (bl || pSDEFDataTypeBase.getSADEFieldType2() != null)) {
            iDataObject.set(FIELD_SADEFIELDTYPE2, (Object)pSDEFDataTypeBase.getSADEFieldType2());
        }
        if (pSDEFDataTypeBase.isTypeDescDirty() && (bl || pSDEFDataTypeBase.getTypeDesc() != null)) {
            iDataObject.set(FIELD_TYPEDESC, (Object)pSDEFDataTypeBase.getTypeDesc());
        }
        if (pSDEFDataTypeBase.isUpdateDateDirty() && (bl || pSDEFDataTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFDataTypeBase.getUpdateDate());
        }
        if (pSDEFDataTypeBase.isUpdateManDirty() && (bl || pSDEFDataTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFDataTypeBase.getUpdateMan());
        }
        if (pSDEFDataTypeBase.isValidFlagDirty() && (bl || pSDEFDataTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEFDataTypeBase.getValidFlag());
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
        return PSDEFDataTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEFDataTypeBase pSDEFDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFDataTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFDataTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFDataTypeBase.resetDB2DataType();
                return true;
            }
            case 3: {
                pSDEFDataTypeBase.resetEnableUserCreate();
                return true;
            }
            case 4: {
                pSDEFDataTypeBase.resetExPhyFlag();
                return true;
            }
            case 5: {
                pSDEFDataTypeBase.resetFormularFlag();
                return true;
            }
            case 6: {
                pSDEFDataTypeBase.resetIntDataType();
                return true;
            }
            case 7: {
                pSDEFDataTypeBase.resetIntDataType2();
                return true;
            }
            case 8: {
                pSDEFDataTypeBase.resetLength();
                return true;
            }
            case 9: {
                pSDEFDataTypeBase.resetLinkFlag();
                return true;
            }
            case 10: {
                pSDEFDataTypeBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEFDataTypeBase.resetMSSQLDataType();
                return true;
            }
            case 12: {
                pSDEFDataTypeBase.resetMySQLDataType();
                return true;
            }
            case 13: {
                pSDEFDataTypeBase.resetOracleDataType();
                return true;
            }
            case 14: {
                pSDEFDataTypeBase.resetOrderValue();
                return true;
            }
            case 15: {
                pSDEFDataTypeBase.resetPhysicalFlag();
                return true;
            }
            case 16: {
                pSDEFDataTypeBase.resetPostgreSQLType();
                return true;
            }
            case 17: {
                pSDEFDataTypeBase.resetPrecision2();
                return true;
            }
            case 18: {
                pSDEFDataTypeBase.resetPSDEFDataTypeId();
                return true;
            }
            case 19: {
                pSDEFDataTypeBase.resetPSDEFDataTypeName();
                return true;
            }
            case 20: {
                pSDEFDataTypeBase.resetPSUnitId();
                return true;
            }
            case 21: {
                pSDEFDataTypeBase.resetPSUnitName();
                return true;
            }
            case 22: {
                pSDEFDataTypeBase.resetPSValueRuleId();
                return true;
            }
            case 23: {
                pSDEFDataTypeBase.resetPSValueRuleName();
                return true;
            }
            case 24: {
                pSDEFDataTypeBase.resetSADEFieldType();
                return true;
            }
            case 25: {
                pSDEFDataTypeBase.resetSADEFieldType2();
                return true;
            }
            case 26: {
                pSDEFDataTypeBase.resetTypeDesc();
                return true;
            }
            case 27: {
                pSDEFDataTypeBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDEFDataTypeBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSDEFDataTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUnit getPSUnit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnit();
        }
        if (this.getPSUnitId() == null) {
            return null;
        }
        Integer n = this.objPSUnitLock;
        synchronized (n) {
            if (this.psunit != null && DataTypeHelper.compare((int)25, (Object)this.getPSUnitId(), (Object)this.psunit.getPSUnitId()) != 0L) {
                this.psunit = null;
            }
            if (this.psunit == null) {
                PSUnit pSUnit = new PSUnit();
                pSUnit.setPSUnitId(this.getPSUnitId());
                PSUnitService pSUnitService = (PSUnitService)ServiceGlobal.getService(PSUnitService.class, (SessionFactory)this.getSessionFactory());
                pSUnitService.autoGet(pSUnit);
                this.psunit = pSUnit;
            }
            return this.psunit;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSValueRule getPSValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRule();
        }
        if (this.getPSValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSValueRuleLock;
        synchronized (n) {
            if (this.psvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSValueRuleId(), (Object)this.psvaluerule.getPSValueRuleId()) != 0L) {
                this.psvaluerule = null;
            }
            if (this.psvaluerule == null) {
                PSValueRule pSValueRule = new PSValueRule();
                pSValueRule.setPSValueRuleId(this.getPSValueRuleId());
                PSValueRuleService pSValueRuleService = (PSValueRuleService)ServiceGlobal.getService(PSValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSValueRuleService.autoGet(pSValueRule);
                this.psvaluerule = pSValueRule;
            }
            return this.psvaluerule;
        }
    }

    private PSDEFDataTypeBase getProxyEntity() {
        return this.proxyPSDEFDataTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFDataTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFDataTypeBase) {
            this.proxyPSDEFDataTypeBase = (PSDEFDataTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DB2DATATYPE, 2);
        fieldIndexMap.put(FIELD_ENABLEUSERCREATE, 3);
        fieldIndexMap.put(FIELD_EXPHYFLAG, 4);
        fieldIndexMap.put(FIELD_FORMULARFLAG, 5);
        fieldIndexMap.put(FIELD_INTDATATYPE, 6);
        fieldIndexMap.put(FIELD_INTDATATYPE2, 7);
        fieldIndexMap.put(FIELD_LENGTH, 8);
        fieldIndexMap.put(FIELD_LINKFLAG, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_MSSQLDATATYPE, 11);
        fieldIndexMap.put(FIELD_MYSQLDATATYPE, 12);
        fieldIndexMap.put(FIELD_ORACLEDATATYPE, 13);
        fieldIndexMap.put(FIELD_ORDERVALUE, 14);
        fieldIndexMap.put(FIELD_PHYSICALFLAG, 15);
        fieldIndexMap.put(FIELD_POSTGRESQLTYPE, 16);
        fieldIndexMap.put(FIELD_PRECISION2, 17);
        fieldIndexMap.put(FIELD_PSDEFDATATYPEID, 18);
        fieldIndexMap.put(FIELD_PSDEFDATATYPENAME, 19);
        fieldIndexMap.put(FIELD_PSUNITID, 20);
        fieldIndexMap.put(FIELD_PSUNITNAME, 21);
        fieldIndexMap.put(FIELD_PSVALUERULEID, 22);
        fieldIndexMap.put(FIELD_PSVALUERULENAME, 23);
        fieldIndexMap.put(FIELD_SADEFIELDTYPE, 24);
        fieldIndexMap.put(FIELD_SADEFIELDTYPE2, 25);
        fieldIndexMap.put(FIELD_TYPEDESC, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_VALIDFLAG, 29);
    }
}

