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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBColumnBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBColumnBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_COLDESC = "COLDESC";
    public static final String FIELD_COLUMNTAG = "COLUMNTAG";
    public static final String FIELD_COLUMNTAG2 = "COLUMNTAG2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATESQL = "CREATESQL";
    public static final String FIELD_DATATYPE = "DATATYPE";
    public static final String FIELD_DATATYPES = "DATATYPES";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_DROPSQL = "DROPSQL";
    public static final String FIELD_FKEY = "FKEY";
    public static final String FIELD_IDENTITYMODE = "IDENTITYMODE";
    public static final String FIELD_LENGTH = "LENGTH";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PKEY = "PKEY";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PSSYSDBCOLUMNID = "PSSYSDBCOLUMNID";
    public static final String FIELD_PSSYSDBCOLUMNNAME = "PSSYSDBCOLUMNNAME";
    public static final String FIELD_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String FIELD_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String FIELD_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String FIELD_REFPSSYSDBCOLUMNID = "REFPSSYSDBCOLUMNID";
    public static final String FIELD_REFPSSYSDBCOLUMNNAME = "REFPSSYSDBCOLUMNNAME";
    public static final String FIELD_REFPSSYSDBTABLEID = "REFPSSYSDBTABLEID";
    public static final String FIELD_REFPSSYSDBTABLENAME = "REFPSSYSDBTABLENAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_UNSIGNEDMODE = "UNSIGNEDMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CODENAME2 = 2;
    private static final int INDEX_COLDESC = 3;
    private static final int INDEX_COLUMNTAG = 4;
    private static final int INDEX_COLUMNTAG2 = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_CREATESQL = 8;
    private static final int INDEX_DATATYPE = 9;
    private static final int INDEX_DATATYPES = 10;
    private static final int INDEX_DEFAULTVALUE = 11;
    private static final int INDEX_DROPSQL = 12;
    private static final int INDEX_FKEY = 13;
    private static final int INDEX_IDENTITYMODE = 14;
    private static final int INDEX_LENGTH = 15;
    private static final int INDEX_LOGICNAME = 16;
    private static final int INDEX_MEMO = 17;
    private static final int INDEX_ORDERVALUE = 18;
    private static final int INDEX_PKEY = 19;
    private static final int INDEX_PRECISION2 = 20;
    private static final int INDEX_PSSYSDBCOLUMNID = 21;
    private static final int INDEX_PSSYSDBCOLUMNNAME = 22;
    private static final int INDEX_PSSYSDBSCHEMEID = 23;
    private static final int INDEX_PSSYSDBTABLEID = 24;
    private static final int INDEX_PSSYSDBTABLENAME = 25;
    private static final int INDEX_REFPSSYSDBCOLUMNID = 26;
    private static final int INDEX_REFPSSYSDBCOLUMNNAME = 27;
    private static final int INDEX_REFPSSYSDBTABLEID = 28;
    private static final int INDEX_REFPSSYSDBTABLENAME = 29;
    private static final int INDEX_STDDATATYPE = 30;
    private static final int INDEX_UNSIGNEDMODE = 31;
    private static final int INDEX_UPDATEDATE = 32;
    private static final int INDEX_UPDATEMAN = 33;
    private static final int INDEX_USERCAT = 34;
    private static final int INDEX_USERTAG = 35;
    private static final int INDEX_USERTAG2 = 36;
    private static final int INDEX_USERTAG3 = 37;
    private static final int INDEX_USERTAG4 = 38;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBColumnBase proxyPSSysDBColumnBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean coldescDirtyFlag = false;
    private boolean columntagDirtyFlag = false;
    private boolean columntag2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createsqlDirtyFlag = false;
    private boolean datatypeDirtyFlag = false;
    private boolean datatypesDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean dropsqlDirtyFlag = false;
    private boolean fkeyDirtyFlag = false;
    private boolean identitymodeDirtyFlag = false;
    private boolean lengthDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pkeyDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean pssysdbcolumnidDirtyFlag = false;
    private boolean pssysdbcolumnnameDirtyFlag = false;
    private boolean pssysdbschemeidDirtyFlag = false;
    private boolean pssysdbtableidDirtyFlag = false;
    private boolean pssysdbtablenameDirtyFlag = false;
    private boolean refpssysdbcolumnidDirtyFlag = false;
    private boolean refpssysdbcolumnnameDirtyFlag = false;
    private boolean refpssysdbtableidDirtyFlag = false;
    private boolean refpssysdbtablenameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean unsignedmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="coldesc")
    private String coldesc;
    @Column(name="columntag")
    private String columntag;
    @Column(name="columntag2")
    private String columntag2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="createsql")
    private String createsql;
    @Column(name="datatype")
    private String datatype;
    @Column(name="datatypes")
    private String datatypes;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="dropsql")
    private String dropsql;
    @Column(name="fkey")
    private Integer fkey;
    @Column(name="identitymode")
    private Integer identitymode;
    @Column(name="length")
    private Integer length;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pkey")
    private Integer pkey;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="pssysdbcolumnid")
    private String pssysdbcolumnid;
    @Column(name="pssysdbcolumnname")
    private String pssysdbcolumnname;
    @Column(name="pssysdbschemeid")
    private String pssysdbschemeid;
    @Column(name="pssysdbtableid")
    private String pssysdbtableid;
    @Column(name="pssysdbtablename")
    private String pssysdbtablename;
    @Column(name="refpssysdbcolumnid")
    private String refpssysdbcolumnid;
    @Column(name="refpssysdbcolumnname")
    private String refpssysdbcolumnname;
    @Column(name="refpssysdbtableid")
    private String refpssysdbtableid;
    @Column(name="refpssysdbtablename")
    private String refpssysdbtablename;
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="unsignedmode")
    private Integer unsignedmode;
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
    private Integer objRefPSSysDBColumnLock = new Integer(1);
    private PSSysDBColumn refpssysdbcolumn = null;
    private Integer objPSSysDBTableLock = new Integer(1);
    private PSSysDBTable pssysdbtable = null;
    private Integer objRefPSSysDBTableLock = new Integer(1);
    private PSSysDBTable refpssysdbtable = null;

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

    public void setColDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.coldesc = string;
        this.coldescDirtyFlag = true;
    }

    public String getColDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColDesc();
        }
        return this.coldesc;
    }

    public boolean isColDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColDescDirty();
        }
        return this.coldescDirtyFlag;
    }

    public void resetColDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColDesc();
            return;
        }
        this.coldescDirtyFlag = false;
        this.coldesc = null;
    }

    public void setColumnTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColumnTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.columntag = string;
        this.columntagDirtyFlag = true;
    }

    public String getColumnTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColumnTag();
        }
        return this.columntag;
    }

    public boolean isColumnTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColumnTagDirty();
        }
        return this.columntagDirtyFlag;
    }

    public void resetColumnTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColumnTag();
            return;
        }
        this.columntagDirtyFlag = false;
        this.columntag = null;
    }

    public void setColumnTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColumnTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.columntag2 = string;
        this.columntag2DirtyFlag = true;
    }

    public String getColumnTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColumnTag2();
        }
        return this.columntag2;
    }

    public boolean isColumnTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColumnTag2Dirty();
        }
        return this.columntag2DirtyFlag;
    }

    public void resetColumnTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColumnTag2();
            return;
        }
        this.columntag2DirtyFlag = false;
        this.columntag2 = null;
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

    public void setCreateSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createsql = string;
        this.createsqlDirtyFlag = true;
    }

    public String getCreateSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateSql();
        }
        return this.createsql;
    }

    public boolean isCreateSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateSqlDirty();
        }
        return this.createsqlDirtyFlag;
    }

    public void resetCreateSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateSql();
            return;
        }
        this.createsqlDirtyFlag = false;
        this.createsql = null;
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

    public void setDataTypes(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataTypes(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatypes = string;
        this.datatypesDirtyFlag = true;
    }

    public String getDataTypes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataTypes();
        }
        return this.datatypes;
    }

    public boolean isDataTypesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypesDirty();
        }
        return this.datatypesDirtyFlag;
    }

    public void resetDataTypes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataTypes();
            return;
        }
        this.datatypesDirtyFlag = false;
        this.datatypes = null;
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

    public void setDropSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDropSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dropsql = string;
        this.dropsqlDirtyFlag = true;
    }

    public String getDropSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDropSql();
        }
        return this.dropsql;
    }

    public boolean isDropSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDropSqlDirty();
        }
        return this.dropsqlDirtyFlag;
    }

    public void resetDropSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDropSql();
            return;
        }
        this.dropsqlDirtyFlag = false;
        this.dropsql = null;
    }

    public void setFKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFKey(n);
            return;
        }
        this.fkey = n;
        this.fkeyDirtyFlag = true;
    }

    public Integer getFKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFKey();
        }
        return this.fkey;
    }

    public boolean isFKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFKeyDirty();
        }
        return this.fkeyDirtyFlag;
    }

    public void resetFKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFKey();
            return;
        }
        this.fkeyDirtyFlag = false;
        this.fkey = null;
    }

    public void setIdentityMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIdentityMode(n);
            return;
        }
        this.identitymode = n;
        this.identitymodeDirtyFlag = true;
    }

    public Integer getIdentityMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIdentityMode();
        }
        return this.identitymode;
    }

    public boolean isIdentityModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIdentityModeDirty();
        }
        return this.identitymodeDirtyFlag;
    }

    public void resetIdentityMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIdentityMode();
            return;
        }
        this.identitymodeDirtyFlag = false;
        this.identitymode = null;
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

    public void setPSSysDBColumnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBColumnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbcolumnid = string;
        this.pssysdbcolumnidDirtyFlag = true;
    }

    public String getPSSysDBColumnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBColumnId();
        }
        return this.pssysdbcolumnid;
    }

    public boolean isPSSysDBColumnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBColumnIdDirty();
        }
        return this.pssysdbcolumnidDirtyFlag;
    }

    public void resetPSSysDBColumnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBColumnId();
            return;
        }
        this.pssysdbcolumnidDirtyFlag = false;
        this.pssysdbcolumnid = null;
    }

    public void setPSSysDBColumnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBColumnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssysdbcolumnname = string;
        this.pssysdbcolumnnameDirtyFlag = true;
    }

    public String getPSSysDBColumnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBColumnName();
        }
        return this.pssysdbcolumnname;
    }

    public boolean isPSSysDBColumnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBColumnNameDirty();
        }
        return this.pssysdbcolumnnameDirtyFlag;
    }

    public void resetPSSysDBColumnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBColumnName();
            return;
        }
        this.pssysdbcolumnnameDirtyFlag = false;
        this.pssysdbcolumnname = null;
    }

    public void setPSSysDBSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemeid = string;
        this.pssysdbschemeidDirtyFlag = true;
    }

    public String getPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeId();
        }
        return this.pssysdbschemeid;
    }

    public boolean isPSSysDBSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeIdDirty();
        }
        return this.pssysdbschemeidDirtyFlag;
    }

    public void resetPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeId();
            return;
        }
        this.pssysdbschemeidDirtyFlag = false;
        this.pssysdbschemeid = null;
    }

    public void setPSSysDBTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtableid = string;
        this.pssysdbtableidDirtyFlag = true;
    }

    public String getPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableId();
        }
        return this.pssysdbtableid;
    }

    public boolean isPSSysDBTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableIdDirty();
        }
        return this.pssysdbtableidDirtyFlag;
    }

    public void resetPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableId();
            return;
        }
        this.pssysdbtableidDirtyFlag = false;
        this.pssysdbtableid = null;
    }

    public void setPSSysDBTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtablename = string;
        this.pssysdbtablenameDirtyFlag = true;
    }

    public String getPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableName();
        }
        return this.pssysdbtablename;
    }

    public boolean isPSSysDBTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableNameDirty();
        }
        return this.pssysdbtablenameDirtyFlag;
    }

    public void resetPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableName();
            return;
        }
        this.pssysdbtablenameDirtyFlag = false;
        this.pssysdbtablename = null;
    }

    public void setRefPSSysDBColumnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDBColumnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdbcolumnid = string;
        this.refpssysdbcolumnidDirtyFlag = true;
    }

    public String getRefPSSysDBColumnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDBColumnId();
        }
        return this.refpssysdbcolumnid;
    }

    public boolean isRefPSSysDBColumnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDBColumnIdDirty();
        }
        return this.refpssysdbcolumnidDirtyFlag;
    }

    public void resetRefPSSysDBColumnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDBColumnId();
            return;
        }
        this.refpssysdbcolumnidDirtyFlag = false;
        this.refpssysdbcolumnid = null;
    }

    public void setRefPSSysDBColumnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDBColumnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdbcolumnname = string;
        this.refpssysdbcolumnnameDirtyFlag = true;
    }

    public String getRefPSSysDBColumnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDBColumnName();
        }
        return this.refpssysdbcolumnname;
    }

    public boolean isRefPSSysDBColumnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDBColumnNameDirty();
        }
        return this.refpssysdbcolumnnameDirtyFlag;
    }

    public void resetRefPSSysDBColumnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDBColumnName();
            return;
        }
        this.refpssysdbcolumnnameDirtyFlag = false;
        this.refpssysdbcolumnname = null;
    }

    public void setRefPSSysDBTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDBTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdbtableid = string;
        this.refpssysdbtableidDirtyFlag = true;
    }

    public String getRefPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDBTableId();
        }
        return this.refpssysdbtableid;
    }

    public boolean isRefPSSysDBTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDBTableIdDirty();
        }
        return this.refpssysdbtableidDirtyFlag;
    }

    public void resetRefPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDBTableId();
            return;
        }
        this.refpssysdbtableidDirtyFlag = false;
        this.refpssysdbtableid = null;
    }

    public void setRefPSSysDBTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysDBTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysdbtablename = string;
        this.refpssysdbtablenameDirtyFlag = true;
    }

    public String getRefPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDBTableName();
        }
        return this.refpssysdbtablename;
    }

    public boolean isRefPSSysDBTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysDBTableNameDirty();
        }
        return this.refpssysdbtablenameDirtyFlag;
    }

    public void resetRefPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysDBTableName();
            return;
        }
        this.refpssysdbtablenameDirtyFlag = false;
        this.refpssysdbtablename = null;
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

    public void setUnsignedMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnsignedMode(n);
            return;
        }
        this.unsignedmode = n;
        this.unsignedmodeDirtyFlag = true;
    }

    public Integer getUnsignedMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnsignedMode();
        }
        return this.unsignedmode;
    }

    public boolean isUnsignedModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnsignedModeDirty();
        }
        return this.unsignedmodeDirtyFlag;
    }

    public void resetUnsignedMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnsignedMode();
            return;
        }
        this.unsignedmodeDirtyFlag = false;
        this.unsignedmode = null;
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

    protected void onReset() {
        PSSysDBColumnBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBColumnBase pSSysDBColumnBase) {
        pSSysDBColumnBase.resetAllowEmpty();
        pSSysDBColumnBase.resetCodeName();
        pSSysDBColumnBase.resetCodeName2();
        pSSysDBColumnBase.resetColDesc();
        pSSysDBColumnBase.resetColumnTag();
        pSSysDBColumnBase.resetColumnTag2();
        pSSysDBColumnBase.resetCreateDate();
        pSSysDBColumnBase.resetCreateMan();
        pSSysDBColumnBase.resetCreateSql();
        pSSysDBColumnBase.resetDataType();
        pSSysDBColumnBase.resetDataTypes();
        pSSysDBColumnBase.resetDefaultValue();
        pSSysDBColumnBase.resetDropSql();
        pSSysDBColumnBase.resetFKey();
        pSSysDBColumnBase.resetIdentityMode();
        pSSysDBColumnBase.resetLength();
        pSSysDBColumnBase.resetLogicName();
        pSSysDBColumnBase.resetMemo();
        pSSysDBColumnBase.resetOrderValue();
        pSSysDBColumnBase.resetPKey();
        pSSysDBColumnBase.resetPrecision2();
        pSSysDBColumnBase.resetPSSysDBColumnId();
        pSSysDBColumnBase.resetPSSysDBColumnName();
        pSSysDBColumnBase.resetPSSysDBSchemeId();
        pSSysDBColumnBase.resetPSSysDBTableId();
        pSSysDBColumnBase.resetPSSysDBTableName();
        pSSysDBColumnBase.resetRefPSSysDBColumnId();
        pSSysDBColumnBase.resetRefPSSysDBColumnName();
        pSSysDBColumnBase.resetRefPSSysDBTableId();
        pSSysDBColumnBase.resetRefPSSysDBTableName();
        pSSysDBColumnBase.resetStdDataType();
        pSSysDBColumnBase.resetUnsignedMode();
        pSSysDBColumnBase.resetUpdateDate();
        pSSysDBColumnBase.resetUpdateMan();
        pSSysDBColumnBase.resetUserCat();
        pSSysDBColumnBase.resetUserTag();
        pSSysDBColumnBase.resetUserTag2();
        pSSysDBColumnBase.resetUserTag3();
        pSSysDBColumnBase.resetUserTag4();
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
        if (!bl || this.isColDescDirty()) {
            hashMap.put(FIELD_COLDESC, this.getColDesc());
        }
        if (!bl || this.isColumnTagDirty()) {
            hashMap.put(FIELD_COLUMNTAG, this.getColumnTag());
        }
        if (!bl || this.isColumnTag2Dirty()) {
            hashMap.put(FIELD_COLUMNTAG2, this.getColumnTag2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCreateSqlDirty()) {
            hashMap.put(FIELD_CREATESQL, this.getCreateSql());
        }
        if (!bl || this.isDataTypeDirty()) {
            hashMap.put(FIELD_DATATYPE, this.getDataType());
        }
        if (!bl || this.isDataTypesDirty()) {
            hashMap.put(FIELD_DATATYPES, this.getDataTypes());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isDropSqlDirty()) {
            hashMap.put(FIELD_DROPSQL, this.getDropSql());
        }
        if (!bl || this.isFKeyDirty()) {
            hashMap.put(FIELD_FKEY, this.getFKey());
        }
        if (!bl || this.isIdentityModeDirty()) {
            hashMap.put(FIELD_IDENTITYMODE, this.getIdentityMode());
        }
        if (!bl || this.isLengthDirty()) {
            hashMap.put(FIELD_LENGTH, this.getLength());
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
        if (!bl || this.isPKeyDirty()) {
            hashMap.put(FIELD_PKEY, this.getPKey());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPSSysDBColumnIdDirty()) {
            hashMap.put(FIELD_PSSYSDBCOLUMNID, this.getPSSysDBColumnId());
        }
        if (!bl || this.isPSSysDBColumnNameDirty()) {
            hashMap.put(FIELD_PSSYSDBCOLUMNNAME, this.getPSSysDBColumnName());
        }
        if (!bl || this.isPSSysDBSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMEID, this.getPSSysDBSchemeId());
        }
        if (!bl || this.isPSSysDBTableIdDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLEID, this.getPSSysDBTableId());
        }
        if (!bl || this.isPSSysDBTableNameDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLENAME, this.getPSSysDBTableName());
        }
        if (!bl || this.isRefPSSysDBColumnIdDirty()) {
            hashMap.put(FIELD_REFPSSYSDBCOLUMNID, this.getRefPSSysDBColumnId());
        }
        if (!bl || this.isRefPSSysDBColumnNameDirty()) {
            hashMap.put(FIELD_REFPSSYSDBCOLUMNNAME, this.getRefPSSysDBColumnName());
        }
        if (!bl || this.isRefPSSysDBTableIdDirty()) {
            hashMap.put(FIELD_REFPSSYSDBTABLEID, this.getRefPSSysDBTableId());
        }
        if (!bl || this.isRefPSSysDBTableNameDirty()) {
            hashMap.put(FIELD_REFPSSYSDBTABLENAME, this.getRefPSSysDBTableName());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
        }
        if (!bl || this.isUnsignedModeDirty()) {
            hashMap.put(FIELD_UNSIGNEDMODE, this.getUnsignedMode());
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
        return PSSysDBColumnBase.get(this, n);
    }

    private static Object get(PSSysDBColumnBase pSSysDBColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBColumnBase.getAllowEmpty();
            }
            case 1: {
                return pSSysDBColumnBase.getCodeName();
            }
            case 2: {
                return pSSysDBColumnBase.getCodeName2();
            }
            case 3: {
                return pSSysDBColumnBase.getColDesc();
            }
            case 4: {
                return pSSysDBColumnBase.getColumnTag();
            }
            case 5: {
                return pSSysDBColumnBase.getColumnTag2();
            }
            case 6: {
                return pSSysDBColumnBase.getCreateDate();
            }
            case 7: {
                return pSSysDBColumnBase.getCreateMan();
            }
            case 8: {
                return pSSysDBColumnBase.getCreateSql();
            }
            case 9: {
                return pSSysDBColumnBase.getDataType();
            }
            case 10: {
                return pSSysDBColumnBase.getDataTypes();
            }
            case 11: {
                return pSSysDBColumnBase.getDefaultValue();
            }
            case 12: {
                return pSSysDBColumnBase.getDropSql();
            }
            case 13: {
                return pSSysDBColumnBase.getFKey();
            }
            case 14: {
                return pSSysDBColumnBase.getIdentityMode();
            }
            case 15: {
                return pSSysDBColumnBase.getLength();
            }
            case 16: {
                return pSSysDBColumnBase.getLogicName();
            }
            case 17: {
                return pSSysDBColumnBase.getMemo();
            }
            case 18: {
                return pSSysDBColumnBase.getOrderValue();
            }
            case 19: {
                return pSSysDBColumnBase.getPKey();
            }
            case 20: {
                return pSSysDBColumnBase.getPrecision2();
            }
            case 21: {
                return pSSysDBColumnBase.getPSSysDBColumnId();
            }
            case 22: {
                return pSSysDBColumnBase.getPSSysDBColumnName();
            }
            case 23: {
                return pSSysDBColumnBase.getPSSysDBSchemeId();
            }
            case 24: {
                return pSSysDBColumnBase.getPSSysDBTableId();
            }
            case 25: {
                return pSSysDBColumnBase.getPSSysDBTableName();
            }
            case 26: {
                return pSSysDBColumnBase.getRefPSSysDBColumnId();
            }
            case 27: {
                return pSSysDBColumnBase.getRefPSSysDBColumnName();
            }
            case 28: {
                return pSSysDBColumnBase.getRefPSSysDBTableId();
            }
            case 29: {
                return pSSysDBColumnBase.getRefPSSysDBTableName();
            }
            case 30: {
                return pSSysDBColumnBase.getStdDataType();
            }
            case 31: {
                return pSSysDBColumnBase.getUnsignedMode();
            }
            case 32: {
                return pSSysDBColumnBase.getUpdateDate();
            }
            case 33: {
                return pSSysDBColumnBase.getUpdateMan();
            }
            case 34: {
                return pSSysDBColumnBase.getUserCat();
            }
            case 35: {
                return pSSysDBColumnBase.getUserTag();
            }
            case 36: {
                return pSSysDBColumnBase.getUserTag2();
            }
            case 37: {
                return pSSysDBColumnBase.getUserTag3();
            }
            case 38: {
                return pSSysDBColumnBase.getUserTag4();
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
        PSSysDBColumnBase.set(this, n, object);
    }

    private static void set(PSSysDBColumnBase pSSysDBColumnBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBColumnBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBColumnBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBColumnBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBColumnBase.setColDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBColumnBase.setColumnTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBColumnBase.setColumnTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBColumnBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBColumnBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBColumnBase.setCreateSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBColumnBase.setDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBColumnBase.setDataTypes(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBColumnBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBColumnBase.setDropSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDBColumnBase.setFKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysDBColumnBase.setIdentityMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysDBColumnBase.setLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysDBColumnBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDBColumnBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDBColumnBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysDBColumnBase.setPKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysDBColumnBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSysDBColumnBase.setPSSysDBColumnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDBColumnBase.setPSSysDBColumnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDBColumnBase.setPSSysDBSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDBColumnBase.setPSSysDBTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDBColumnBase.setPSSysDBTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDBColumnBase.setRefPSSysDBColumnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDBColumnBase.setRefPSSysDBColumnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDBColumnBase.setRefPSSysDBTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDBColumnBase.setRefPSSysDBTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDBColumnBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysDBColumnBase.setUnsignedMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSysDBColumnBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSSysDBColumnBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysDBColumnBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysDBColumnBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysDBColumnBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDBColumnBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysDBColumnBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDBColumnBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBColumnBase pSSysDBColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBColumnBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSSysDBColumnBase.getCodeName() == null;
            }
            case 2: {
                return pSSysDBColumnBase.getCodeName2() == null;
            }
            case 3: {
                return pSSysDBColumnBase.getColDesc() == null;
            }
            case 4: {
                return pSSysDBColumnBase.getColumnTag() == null;
            }
            case 5: {
                return pSSysDBColumnBase.getColumnTag2() == null;
            }
            case 6: {
                return pSSysDBColumnBase.getCreateDate() == null;
            }
            case 7: {
                return pSSysDBColumnBase.getCreateMan() == null;
            }
            case 8: {
                return pSSysDBColumnBase.getCreateSql() == null;
            }
            case 9: {
                return pSSysDBColumnBase.getDataType() == null;
            }
            case 10: {
                return pSSysDBColumnBase.getDataTypes() == null;
            }
            case 11: {
                return pSSysDBColumnBase.getDefaultValue() == null;
            }
            case 12: {
                return pSSysDBColumnBase.getDropSql() == null;
            }
            case 13: {
                return pSSysDBColumnBase.getFKey() == null;
            }
            case 14: {
                return pSSysDBColumnBase.getIdentityMode() == null;
            }
            case 15: {
                return pSSysDBColumnBase.getLength() == null;
            }
            case 16: {
                return pSSysDBColumnBase.getLogicName() == null;
            }
            case 17: {
                return pSSysDBColumnBase.getMemo() == null;
            }
            case 18: {
                return pSSysDBColumnBase.getOrderValue() == null;
            }
            case 19: {
                return pSSysDBColumnBase.getPKey() == null;
            }
            case 20: {
                return pSSysDBColumnBase.getPrecision2() == null;
            }
            case 21: {
                return pSSysDBColumnBase.getPSSysDBColumnId() == null;
            }
            case 22: {
                return pSSysDBColumnBase.getPSSysDBColumnName() == null;
            }
            case 23: {
                return pSSysDBColumnBase.getPSSysDBSchemeId() == null;
            }
            case 24: {
                return pSSysDBColumnBase.getPSSysDBTableId() == null;
            }
            case 25: {
                return pSSysDBColumnBase.getPSSysDBTableName() == null;
            }
            case 26: {
                return pSSysDBColumnBase.getRefPSSysDBColumnId() == null;
            }
            case 27: {
                return pSSysDBColumnBase.getRefPSSysDBColumnName() == null;
            }
            case 28: {
                return pSSysDBColumnBase.getRefPSSysDBTableId() == null;
            }
            case 29: {
                return pSSysDBColumnBase.getRefPSSysDBTableName() == null;
            }
            case 30: {
                return pSSysDBColumnBase.getStdDataType() == null;
            }
            case 31: {
                return pSSysDBColumnBase.getUnsignedMode() == null;
            }
            case 32: {
                return pSSysDBColumnBase.getUpdateDate() == null;
            }
            case 33: {
                return pSSysDBColumnBase.getUpdateMan() == null;
            }
            case 34: {
                return pSSysDBColumnBase.getUserCat() == null;
            }
            case 35: {
                return pSSysDBColumnBase.getUserTag() == null;
            }
            case 36: {
                return pSSysDBColumnBase.getUserTag2() == null;
            }
            case 37: {
                return pSSysDBColumnBase.getUserTag3() == null;
            }
            case 38: {
                return pSSysDBColumnBase.getUserTag4() == null;
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
        return PSSysDBColumnBase.contains(this, n);
    }

    private static boolean contains(PSSysDBColumnBase pSSysDBColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBColumnBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSSysDBColumnBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysDBColumnBase.isCodeName2Dirty();
            }
            case 3: {
                return pSSysDBColumnBase.isColDescDirty();
            }
            case 4: {
                return pSSysDBColumnBase.isColumnTagDirty();
            }
            case 5: {
                return pSSysDBColumnBase.isColumnTag2Dirty();
            }
            case 6: {
                return pSSysDBColumnBase.isCreateDateDirty();
            }
            case 7: {
                return pSSysDBColumnBase.isCreateManDirty();
            }
            case 8: {
                return pSSysDBColumnBase.isCreateSqlDirty();
            }
            case 9: {
                return pSSysDBColumnBase.isDataTypeDirty();
            }
            case 10: {
                return pSSysDBColumnBase.isDataTypesDirty();
            }
            case 11: {
                return pSSysDBColumnBase.isDefaultValueDirty();
            }
            case 12: {
                return pSSysDBColumnBase.isDropSqlDirty();
            }
            case 13: {
                return pSSysDBColumnBase.isFKeyDirty();
            }
            case 14: {
                return pSSysDBColumnBase.isIdentityModeDirty();
            }
            case 15: {
                return pSSysDBColumnBase.isLengthDirty();
            }
            case 16: {
                return pSSysDBColumnBase.isLogicNameDirty();
            }
            case 17: {
                return pSSysDBColumnBase.isMemoDirty();
            }
            case 18: {
                return pSSysDBColumnBase.isOrderValueDirty();
            }
            case 19: {
                return pSSysDBColumnBase.isPKeyDirty();
            }
            case 20: {
                return pSSysDBColumnBase.isPrecision2Dirty();
            }
            case 21: {
                return pSSysDBColumnBase.isPSSysDBColumnIdDirty();
            }
            case 22: {
                return pSSysDBColumnBase.isPSSysDBColumnNameDirty();
            }
            case 23: {
                return pSSysDBColumnBase.isPSSysDBSchemeIdDirty();
            }
            case 24: {
                return pSSysDBColumnBase.isPSSysDBTableIdDirty();
            }
            case 25: {
                return pSSysDBColumnBase.isPSSysDBTableNameDirty();
            }
            case 26: {
                return pSSysDBColumnBase.isRefPSSysDBColumnIdDirty();
            }
            case 27: {
                return pSSysDBColumnBase.isRefPSSysDBColumnNameDirty();
            }
            case 28: {
                return pSSysDBColumnBase.isRefPSSysDBTableIdDirty();
            }
            case 29: {
                return pSSysDBColumnBase.isRefPSSysDBTableNameDirty();
            }
            case 30: {
                return pSSysDBColumnBase.isStdDataTypeDirty();
            }
            case 31: {
                return pSSysDBColumnBase.isUnsignedModeDirty();
            }
            case 32: {
                return pSSysDBColumnBase.isUpdateDateDirty();
            }
            case 33: {
                return pSSysDBColumnBase.isUpdateManDirty();
            }
            case 34: {
                return pSSysDBColumnBase.isUserCatDirty();
            }
            case 35: {
                return pSSysDBColumnBase.isUserTagDirty();
            }
            case 36: {
                return pSSysDBColumnBase.isUserTag2Dirty();
            }
            case 37: {
                return pSSysDBColumnBase.isUserTag3Dirty();
            }
            case 38: {
                return pSSysDBColumnBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBColumnBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBColumnBase pSSysDBColumnBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBColumnBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getColDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"coldesc", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getColDesc()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getColumnTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"columntag", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getColumnTag()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getColumnTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"columntag2", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getColumnTag2()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getCreateSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getCreateSql()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatype", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getDataType()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getDataTypes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatypes", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getDataTypes()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getDropSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dropsql", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getDropSql()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getFKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fkey", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getFKey()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getIdentityMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"identitymode", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getIdentityMode()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"length", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getLength()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getPKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkey", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getPKey()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBColumnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbcolumnid", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getPSSysDBColumnId()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBColumnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbcolumnname", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getPSSysDBColumnName()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemeid", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getPSSysDBSchemeId()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtableid", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getPSSysDBTableId()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtablename", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getPSSysDBTableName()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getRefPSSysDBColumnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdbcolumnid", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getRefPSSysDBColumnId()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getRefPSSysDBColumnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdbcolumnname", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getRefPSSysDBColumnName()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getRefPSSysDBTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdbtableid", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getRefPSSysDBTableId()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getRefPSSysDBTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysdbtablename", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getRefPSSysDBTableName()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getUnsignedMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unsignedmode", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getUnsignedMode()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDBColumnBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDBColumnBase.getJSONValue((Object)pSSysDBColumnBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBColumnBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBColumnBase pSSysDBColumnBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBColumnBase.getAllowEmpty() != null) {
            object = pSSysDBColumnBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getCodeName() != null) {
            object = pSSysDBColumnBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getCodeName2() != null) {
            object = pSSysDBColumnBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getColDesc() != null) {
            object = pSSysDBColumnBase.getColDesc();
            xmlNode.setAttribute(FIELD_COLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getColumnTag() != null) {
            object = pSSysDBColumnBase.getColumnTag();
            xmlNode.setAttribute(FIELD_COLUMNTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getColumnTag2() != null) {
            object = pSSysDBColumnBase.getColumnTag2();
            xmlNode.setAttribute(FIELD_COLUMNTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getCreateDate() != null) {
            object = pSSysDBColumnBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getCreateMan() != null) {
            object = pSSysDBColumnBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getCreateSql() != null) {
            object = pSSysDBColumnBase.getCreateSql();
            xmlNode.setAttribute(FIELD_CREATESQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getDataType() != null) {
            object = pSSysDBColumnBase.getDataType();
            xmlNode.setAttribute(FIELD_DATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getDataTypes() != null) {
            object = pSSysDBColumnBase.getDataTypes();
            xmlNode.setAttribute(FIELD_DATATYPES, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getDefaultValue() != null) {
            object = pSSysDBColumnBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getDropSql() != null) {
            object = pSSysDBColumnBase.getDropSql();
            xmlNode.setAttribute(FIELD_DROPSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getFKey() != null) {
            object = pSSysDBColumnBase.getFKey();
            xmlNode.setAttribute(FIELD_FKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getIdentityMode() != null) {
            object = pSSysDBColumnBase.getIdentityMode();
            xmlNode.setAttribute(FIELD_IDENTITYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getLength() != null) {
            object = pSSysDBColumnBase.getLength();
            xmlNode.setAttribute(FIELD_LENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getLogicName() != null) {
            object = pSSysDBColumnBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getMemo() != null) {
            object = pSSysDBColumnBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getOrderValue() != null) {
            object = pSSysDBColumnBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getPKey() != null) {
            object = pSSysDBColumnBase.getPKey();
            xmlNode.setAttribute(FIELD_PKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getPrecision2() != null) {
            object = pSSysDBColumnBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getPSSysDBColumnId() != null) {
            object = pSSysDBColumnBase.getPSSysDBColumnId();
            xmlNode.setAttribute(FIELD_PSSYSDBCOLUMNID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBColumnName() != null) {
            object = pSSysDBColumnBase.getPSSysDBColumnName();
            xmlNode.setAttribute(FIELD_PSSYSDBCOLUMNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBSchemeId() != null) {
            object = pSSysDBColumnBase.getPSSysDBSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBTableId() != null) {
            object = pSSysDBColumnBase.getPSSysDBTableId();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getPSSysDBTableName() != null) {
            object = pSSysDBColumnBase.getPSSysDBTableName();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getRefPSSysDBColumnId() != null) {
            object = pSSysDBColumnBase.getRefPSSysDBColumnId();
            xmlNode.setAttribute(FIELD_REFPSSYSDBCOLUMNID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getRefPSSysDBColumnName() != null) {
            object = pSSysDBColumnBase.getRefPSSysDBColumnName();
            xmlNode.setAttribute(FIELD_REFPSSYSDBCOLUMNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getRefPSSysDBTableId() != null) {
            object = pSSysDBColumnBase.getRefPSSysDBTableId();
            xmlNode.setAttribute(FIELD_REFPSSYSDBTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getRefPSSysDBTableName() != null) {
            object = pSSysDBColumnBase.getRefPSSysDBTableName();
            xmlNode.setAttribute(FIELD_REFPSSYSDBTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getStdDataType() != null) {
            object = pSSysDBColumnBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getUnsignedMode() != null) {
            object = pSSysDBColumnBase.getUnsignedMode();
            xmlNode.setAttribute(FIELD_UNSIGNEDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getUpdateDate() != null) {
            object = pSSysDBColumnBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBColumnBase.getUpdateMan() != null) {
            object = pSSysDBColumnBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getUserCat() != null) {
            object = pSSysDBColumnBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getUserTag() != null) {
            object = pSSysDBColumnBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getUserTag2() != null) {
            object = pSSysDBColumnBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getUserTag3() != null) {
            object = pSSysDBColumnBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBColumnBase.getUserTag4() != null) {
            object = pSSysDBColumnBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBColumnBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBColumnBase pSSysDBColumnBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBColumnBase.isAllowEmptyDirty() && (bl || pSSysDBColumnBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSSysDBColumnBase.getAllowEmpty());
        }
        if (pSSysDBColumnBase.isCodeNameDirty() && (bl || pSSysDBColumnBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDBColumnBase.getCodeName());
        }
        if (pSSysDBColumnBase.isCodeName2Dirty() && (bl || pSSysDBColumnBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSysDBColumnBase.getCodeName2());
        }
        if (pSSysDBColumnBase.isColDescDirty() && (bl || pSSysDBColumnBase.getColDesc() != null)) {
            iDataObject.set(FIELD_COLDESC, (Object)pSSysDBColumnBase.getColDesc());
        }
        if (pSSysDBColumnBase.isColumnTagDirty() && (bl || pSSysDBColumnBase.getColumnTag() != null)) {
            iDataObject.set(FIELD_COLUMNTAG, (Object)pSSysDBColumnBase.getColumnTag());
        }
        if (pSSysDBColumnBase.isColumnTag2Dirty() && (bl || pSSysDBColumnBase.getColumnTag2() != null)) {
            iDataObject.set(FIELD_COLUMNTAG2, (Object)pSSysDBColumnBase.getColumnTag2());
        }
        if (pSSysDBColumnBase.isCreateDateDirty() && (bl || pSSysDBColumnBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBColumnBase.getCreateDate());
        }
        if (pSSysDBColumnBase.isCreateManDirty() && (bl || pSSysDBColumnBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBColumnBase.getCreateMan());
        }
        if (pSSysDBColumnBase.isCreateSqlDirty() && (bl || pSSysDBColumnBase.getCreateSql() != null)) {
            iDataObject.set(FIELD_CREATESQL, (Object)pSSysDBColumnBase.getCreateSql());
        }
        if (pSSysDBColumnBase.isDataTypeDirty() && (bl || pSSysDBColumnBase.getDataType() != null)) {
            iDataObject.set(FIELD_DATATYPE, (Object)pSSysDBColumnBase.getDataType());
        }
        if (pSSysDBColumnBase.isDataTypesDirty() && (bl || pSSysDBColumnBase.getDataTypes() != null)) {
            iDataObject.set(FIELD_DATATYPES, (Object)pSSysDBColumnBase.getDataTypes());
        }
        if (pSSysDBColumnBase.isDefaultValueDirty() && (bl || pSSysDBColumnBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSSysDBColumnBase.getDefaultValue());
        }
        if (pSSysDBColumnBase.isDropSqlDirty() && (bl || pSSysDBColumnBase.getDropSql() != null)) {
            iDataObject.set(FIELD_DROPSQL, (Object)pSSysDBColumnBase.getDropSql());
        }
        if (pSSysDBColumnBase.isFKeyDirty() && (bl || pSSysDBColumnBase.getFKey() != null)) {
            iDataObject.set(FIELD_FKEY, (Object)pSSysDBColumnBase.getFKey());
        }
        if (pSSysDBColumnBase.isIdentityModeDirty() && (bl || pSSysDBColumnBase.getIdentityMode() != null)) {
            iDataObject.set(FIELD_IDENTITYMODE, (Object)pSSysDBColumnBase.getIdentityMode());
        }
        if (pSSysDBColumnBase.isLengthDirty() && (bl || pSSysDBColumnBase.getLength() != null)) {
            iDataObject.set(FIELD_LENGTH, (Object)pSSysDBColumnBase.getLength());
        }
        if (pSSysDBColumnBase.isLogicNameDirty() && (bl || pSSysDBColumnBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysDBColumnBase.getLogicName());
        }
        if (pSSysDBColumnBase.isMemoDirty() && (bl || pSSysDBColumnBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBColumnBase.getMemo());
        }
        if (pSSysDBColumnBase.isOrderValueDirty() && (bl || pSSysDBColumnBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDBColumnBase.getOrderValue());
        }
        if (pSSysDBColumnBase.isPKeyDirty() && (bl || pSSysDBColumnBase.getPKey() != null)) {
            iDataObject.set(FIELD_PKEY, (Object)pSSysDBColumnBase.getPKey());
        }
        if (pSSysDBColumnBase.isPrecision2Dirty() && (bl || pSSysDBColumnBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSSysDBColumnBase.getPrecision2());
        }
        if (pSSysDBColumnBase.isPSSysDBColumnIdDirty() && (bl || pSSysDBColumnBase.getPSSysDBColumnId() != null)) {
            iDataObject.set(FIELD_PSSYSDBCOLUMNID, (Object)pSSysDBColumnBase.getPSSysDBColumnId());
        }
        if (pSSysDBColumnBase.isPSSysDBColumnNameDirty() && (bl || pSSysDBColumnBase.getPSSysDBColumnName() != null)) {
            iDataObject.set(FIELD_PSSYSDBCOLUMNNAME, (Object)pSSysDBColumnBase.getPSSysDBColumnName());
        }
        if (pSSysDBColumnBase.isPSSysDBSchemeIdDirty() && (bl || pSSysDBColumnBase.getPSSysDBSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMEID, (Object)pSSysDBColumnBase.getPSSysDBSchemeId());
        }
        if (pSSysDBColumnBase.isPSSysDBTableIdDirty() && (bl || pSSysDBColumnBase.getPSSysDBTableId() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLEID, (Object)pSSysDBColumnBase.getPSSysDBTableId());
        }
        if (pSSysDBColumnBase.isPSSysDBTableNameDirty() && (bl || pSSysDBColumnBase.getPSSysDBTableName() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLENAME, (Object)pSSysDBColumnBase.getPSSysDBTableName());
        }
        if (pSSysDBColumnBase.isRefPSSysDBColumnIdDirty() && (bl || pSSysDBColumnBase.getRefPSSysDBColumnId() != null)) {
            iDataObject.set(FIELD_REFPSSYSDBCOLUMNID, (Object)pSSysDBColumnBase.getRefPSSysDBColumnId());
        }
        if (pSSysDBColumnBase.isRefPSSysDBColumnNameDirty() && (bl || pSSysDBColumnBase.getRefPSSysDBColumnName() != null)) {
            iDataObject.set(FIELD_REFPSSYSDBCOLUMNNAME, (Object)pSSysDBColumnBase.getRefPSSysDBColumnName());
        }
        if (pSSysDBColumnBase.isRefPSSysDBTableIdDirty() && (bl || pSSysDBColumnBase.getRefPSSysDBTableId() != null)) {
            iDataObject.set(FIELD_REFPSSYSDBTABLEID, (Object)pSSysDBColumnBase.getRefPSSysDBTableId());
        }
        if (pSSysDBColumnBase.isRefPSSysDBTableNameDirty() && (bl || pSSysDBColumnBase.getRefPSSysDBTableName() != null)) {
            iDataObject.set(FIELD_REFPSSYSDBTABLENAME, (Object)pSSysDBColumnBase.getRefPSSysDBTableName());
        }
        if (pSSysDBColumnBase.isStdDataTypeDirty() && (bl || pSSysDBColumnBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysDBColumnBase.getStdDataType());
        }
        if (pSSysDBColumnBase.isUnsignedModeDirty() && (bl || pSSysDBColumnBase.getUnsignedMode() != null)) {
            iDataObject.set(FIELD_UNSIGNEDMODE, (Object)pSSysDBColumnBase.getUnsignedMode());
        }
        if (pSSysDBColumnBase.isUpdateDateDirty() && (bl || pSSysDBColumnBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBColumnBase.getUpdateDate());
        }
        if (pSSysDBColumnBase.isUpdateManDirty() && (bl || pSSysDBColumnBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBColumnBase.getUpdateMan());
        }
        if (pSSysDBColumnBase.isUserCatDirty() && (bl || pSSysDBColumnBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDBColumnBase.getUserCat());
        }
        if (pSSysDBColumnBase.isUserTagDirty() && (bl || pSSysDBColumnBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDBColumnBase.getUserTag());
        }
        if (pSSysDBColumnBase.isUserTag2Dirty() && (bl || pSSysDBColumnBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDBColumnBase.getUserTag2());
        }
        if (pSSysDBColumnBase.isUserTag3Dirty() && (bl || pSSysDBColumnBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDBColumnBase.getUserTag3());
        }
        if (pSSysDBColumnBase.isUserTag4Dirty() && (bl || pSSysDBColumnBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDBColumnBase.getUserTag4());
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
        return PSSysDBColumnBase.remove(this, n);
    }

    private static boolean remove(PSSysDBColumnBase pSSysDBColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBColumnBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSSysDBColumnBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysDBColumnBase.resetCodeName2();
                return true;
            }
            case 3: {
                pSSysDBColumnBase.resetColDesc();
                return true;
            }
            case 4: {
                pSSysDBColumnBase.resetColumnTag();
                return true;
            }
            case 5: {
                pSSysDBColumnBase.resetColumnTag2();
                return true;
            }
            case 6: {
                pSSysDBColumnBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSSysDBColumnBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSysDBColumnBase.resetCreateSql();
                return true;
            }
            case 9: {
                pSSysDBColumnBase.resetDataType();
                return true;
            }
            case 10: {
                pSSysDBColumnBase.resetDataTypes();
                return true;
            }
            case 11: {
                pSSysDBColumnBase.resetDefaultValue();
                return true;
            }
            case 12: {
                pSSysDBColumnBase.resetDropSql();
                return true;
            }
            case 13: {
                pSSysDBColumnBase.resetFKey();
                return true;
            }
            case 14: {
                pSSysDBColumnBase.resetIdentityMode();
                return true;
            }
            case 15: {
                pSSysDBColumnBase.resetLength();
                return true;
            }
            case 16: {
                pSSysDBColumnBase.resetLogicName();
                return true;
            }
            case 17: {
                pSSysDBColumnBase.resetMemo();
                return true;
            }
            case 18: {
                pSSysDBColumnBase.resetOrderValue();
                return true;
            }
            case 19: {
                pSSysDBColumnBase.resetPKey();
                return true;
            }
            case 20: {
                pSSysDBColumnBase.resetPrecision2();
                return true;
            }
            case 21: {
                pSSysDBColumnBase.resetPSSysDBColumnId();
                return true;
            }
            case 22: {
                pSSysDBColumnBase.resetPSSysDBColumnName();
                return true;
            }
            case 23: {
                pSSysDBColumnBase.resetPSSysDBSchemeId();
                return true;
            }
            case 24: {
                pSSysDBColumnBase.resetPSSysDBTableId();
                return true;
            }
            case 25: {
                pSSysDBColumnBase.resetPSSysDBTableName();
                return true;
            }
            case 26: {
                pSSysDBColumnBase.resetRefPSSysDBColumnId();
                return true;
            }
            case 27: {
                pSSysDBColumnBase.resetRefPSSysDBColumnName();
                return true;
            }
            case 28: {
                pSSysDBColumnBase.resetRefPSSysDBTableId();
                return true;
            }
            case 29: {
                pSSysDBColumnBase.resetRefPSSysDBTableName();
                return true;
            }
            case 30: {
                pSSysDBColumnBase.resetStdDataType();
                return true;
            }
            case 31: {
                pSSysDBColumnBase.resetUnsignedMode();
                return true;
            }
            case 32: {
                pSSysDBColumnBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSSysDBColumnBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSSysDBColumnBase.resetUserCat();
                return true;
            }
            case 35: {
                pSSysDBColumnBase.resetUserTag();
                return true;
            }
            case 36: {
                pSSysDBColumnBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSSysDBColumnBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSSysDBColumnBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBColumn getRefPSSysDBColumn() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDBColumn();
        }
        if (this.getRefPSSysDBColumnId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysDBColumnLock;
        synchronized (n) {
            if (this.refpssysdbcolumn != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysDBColumnId(), (Object)this.refpssysdbcolumn.getPSSysDBColumnId()) != 0L) {
                this.refpssysdbcolumn = null;
            }
            if (this.refpssysdbcolumn == null) {
                PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
                pSSysDBColumn.setPSSysDBColumnId(this.getRefPSSysDBColumnId());
                PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBColumnService.autoGet(pSSysDBColumn);
                this.refpssysdbcolumn = pSSysDBColumn;
            }
            return this.refpssysdbcolumn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBTable getPSSysDBTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTable();
        }
        if (this.getPSSysDBTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBTableLock;
        synchronized (n) {
            if (this.pssysdbtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBTableId(), (Object)this.pssysdbtable.getPSSysDBTableId()) != 0L) {
                this.pssysdbtable = null;
            }
            if (this.pssysdbtable == null) {
                PSSysDBTable pSSysDBTable = new PSSysDBTable();
                pSSysDBTable.setPSSysDBTableId(this.getPSSysDBTableId());
                PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBTableService.autoGet(pSSysDBTable);
                this.pssysdbtable = pSSysDBTable;
            }
            return this.pssysdbtable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBTable getRefPSSysDBTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysDBTable();
        }
        if (this.getRefPSSysDBTableId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysDBTableLock;
        synchronized (n) {
            if (this.refpssysdbtable != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysDBTableId(), (Object)this.refpssysdbtable.getPSSysDBTableId()) != 0L) {
                this.refpssysdbtable = null;
            }
            if (this.refpssysdbtable == null) {
                PSSysDBTable pSSysDBTable = new PSSysDBTable();
                pSSysDBTable.setPSSysDBTableId(this.getRefPSSysDBTableId());
                PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBTableService.autoGet(pSSysDBTable);
                this.refpssysdbtable = pSSysDBTable;
            }
            return this.refpssysdbtable;
        }
    }

    private PSSysDBColumnBase getProxyEntity() {
        return this.proxyPSSysDBColumnBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBColumnBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBColumnBase) {
            this.proxyPSSysDBColumnBase = (PSSysDBColumnBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CODENAME2, 2);
        fieldIndexMap.put(FIELD_COLDESC, 3);
        fieldIndexMap.put(FIELD_COLUMNTAG, 4);
        fieldIndexMap.put(FIELD_COLUMNTAG2, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_CREATESQL, 8);
        fieldIndexMap.put(FIELD_DATATYPE, 9);
        fieldIndexMap.put(FIELD_DATATYPES, 10);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 11);
        fieldIndexMap.put(FIELD_DROPSQL, 12);
        fieldIndexMap.put(FIELD_FKEY, 13);
        fieldIndexMap.put(FIELD_IDENTITYMODE, 14);
        fieldIndexMap.put(FIELD_LENGTH, 15);
        fieldIndexMap.put(FIELD_LOGICNAME, 16);
        fieldIndexMap.put(FIELD_MEMO, 17);
        fieldIndexMap.put(FIELD_ORDERVALUE, 18);
        fieldIndexMap.put(FIELD_PKEY, 19);
        fieldIndexMap.put(FIELD_PRECISION2, 20);
        fieldIndexMap.put(FIELD_PSSYSDBCOLUMNID, 21);
        fieldIndexMap.put(FIELD_PSSYSDBCOLUMNNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMEID, 23);
        fieldIndexMap.put(FIELD_PSSYSDBTABLEID, 24);
        fieldIndexMap.put(FIELD_PSSYSDBTABLENAME, 25);
        fieldIndexMap.put(FIELD_REFPSSYSDBCOLUMNID, 26);
        fieldIndexMap.put(FIELD_REFPSSYSDBCOLUMNNAME, 27);
        fieldIndexMap.put(FIELD_REFPSSYSDBTABLEID, 28);
        fieldIndexMap.put(FIELD_REFPSSYSDBTABLENAME, 29);
        fieldIndexMap.put(FIELD_STDDATATYPE, 30);
        fieldIndexMap.put(FIELD_UNSIGNEDMODE, 31);
        fieldIndexMap.put(FIELD_UPDATEDATE, 32);
        fieldIndexMap.put(FIELD_UPDATEMAN, 33);
        fieldIndexMap.put(FIELD_USERCAT, 34);
        fieldIndexMap.put(FIELD_USERTAG, 35);
        fieldIndexMap.put(FIELD_USERTAG2, 36);
        fieldIndexMap.put(FIELD_USERTAG3, 37);
        fieldIndexMap.put(FIELD_USERTAG4, 38);
    }
}

