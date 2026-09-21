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
package net.ibizsys.pscore.srv.bdscheme.entity;

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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDTableRSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBDTableRSBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAJORPSSYSBDTABLEID = "MAJORPSSYSBDTABLEID";
    public static final String FIELD_MAJORPSSYSBDTABLENAME = "MAJORPSSYSBDTABLENAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORCODENAME = "MINORCODENAME";
    public static final String FIELD_MINORPSSYSBDTABLEID = "MINORPSSYSBDTABLEID";
    public static final String FIELD_MINORPSSYSBDTABLENAME = "MINORPSSYSBDTABLENAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String FIELD_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String FIELD_PSSYSBDTABLERSID = "PSSYSBDTABLERSID";
    public static final String FIELD_PSSYSBDTABLERSNAME = "PSSYSBDTABLERSNAME";
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
    private static final int INDEX_MAJORPSSYSBDTABLEID = 3;
    private static final int INDEX_MAJORPSSYSBDTABLENAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MINORCODENAME = 6;
    private static final int INDEX_MINORPSSYSBDTABLEID = 7;
    private static final int INDEX_MINORPSSYSBDTABLENAME = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PSDERID = 10;
    private static final int INDEX_PSDERNAME = 11;
    private static final int INDEX_PSSYSBDSCHEMEID = 12;
    private static final int INDEX_PSSYSBDSCHEMENAME = 13;
    private static final int INDEX_PSSYSBDTABLERSID = 14;
    private static final int INDEX_PSSYSBDTABLERSNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final int INDEX_VALIDFLAG = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBDTableRSBase proxyPSSysBDTableRSBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean majorpssysbdtableidDirtyFlag = false;
    private boolean majorpssysbdtablenameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorcodenameDirtyFlag = false;
    private boolean minorpssysbdtableidDirtyFlag = false;
    private boolean minorpssysbdtablenameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean pssysbdschemeidDirtyFlag = false;
    private boolean pssysbdschemenameDirtyFlag = false;
    private boolean pssysbdtablersidDirtyFlag = false;
    private boolean pssysbdtablersnameDirtyFlag = false;
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
    @Column(name="majorpssysbdtableid")
    private String majorpssysbdtableid;
    @Column(name="majorpssysbdtablename")
    private String majorpssysbdtablename;
    @Column(name="memo")
    private String memo;
    @Column(name="minorcodename")
    private String minorcodename;
    @Column(name="minorpssysbdtableid")
    private String minorpssysbdtableid;
    @Column(name="minorpssysbdtablename")
    private String minorpssysbdtablename;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="pssysbdschemeid")
    private String pssysbdschemeid;
    @Column(name="pssysbdschemename")
    private String pssysbdschemename;
    @Column(name="pssysbdtablersid")
    private String pssysbdtablersid;
    @Column(name="pssysbdtablersname")
    private String pssysbdtablersname;
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
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSSysBDSchemeLock = new Integer(1);
    private PSSysBDScheme pssysbdscheme = null;
    private Integer objMajorPSSysBDTableLock = new Integer(1);
    private PSSysBDTable majorpssysbdtable = null;
    private Integer objMinorPSSysBDTableLock = new Integer(1);
    private PSSysBDTable minorpssysbdtable = null;

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

    public void setMajorPSSysBDTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSSysBDTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpssysbdtableid = string;
        this.majorpssysbdtableidDirtyFlag = true;
    }

    public String getMajorPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSSysBDTableId();
        }
        return this.majorpssysbdtableid;
    }

    public boolean isMajorPSSysBDTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSSysBDTableIdDirty();
        }
        return this.majorpssysbdtableidDirtyFlag;
    }

    public void resetMajorPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSSysBDTableId();
            return;
        }
        this.majorpssysbdtableidDirtyFlag = false;
        this.majorpssysbdtableid = null;
    }

    public void setMajorPSSysBDTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSSysBDTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpssysbdtablename = string;
        this.majorpssysbdtablenameDirtyFlag = true;
    }

    public String getMajorPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSSysBDTableName();
        }
        return this.majorpssysbdtablename;
    }

    public boolean isMajorPSSysBDTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSSysBDTableNameDirty();
        }
        return this.majorpssysbdtablenameDirtyFlag;
    }

    public void resetMajorPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSSysBDTableName();
            return;
        }
        this.majorpssysbdtablenameDirtyFlag = false;
        this.majorpssysbdtablename = null;
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

    public void setMinorCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorcodename = string;
        this.minorcodenameDirtyFlag = true;
    }

    public String getMinorCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorCodeName();
        }
        return this.minorcodename;
    }

    public boolean isMinorCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorCodeNameDirty();
        }
        return this.minorcodenameDirtyFlag;
    }

    public void resetMinorCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorCodeName();
            return;
        }
        this.minorcodenameDirtyFlag = false;
        this.minorcodename = null;
    }

    public void setMinorPSSysBDTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSSysBDTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpssysbdtableid = string;
        this.minorpssysbdtableidDirtyFlag = true;
    }

    public String getMinorPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSSysBDTableId();
        }
        return this.minorpssysbdtableid;
    }

    public boolean isMinorPSSysBDTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSSysBDTableIdDirty();
        }
        return this.minorpssysbdtableidDirtyFlag;
    }

    public void resetMinorPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSSysBDTableId();
            return;
        }
        this.minorpssysbdtableidDirtyFlag = false;
        this.minorpssysbdtableid = null;
    }

    public void setMinorPSSysBDTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSSysBDTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpssysbdtablename = string;
        this.minorpssysbdtablenameDirtyFlag = true;
    }

    public String getMinorPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSSysBDTableName();
        }
        return this.minorpssysbdtablename;
    }

    public boolean isMinorPSSysBDTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSSysBDTableNameDirty();
        }
        return this.minorpssysbdtablenameDirtyFlag;
    }

    public void resetMinorPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSSysBDTableName();
            return;
        }
        this.minorpssysbdtablenameDirtyFlag = false;
        this.minorpssysbdtablename = null;
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

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
    }

    public void setPSSysBDSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemeid = string;
        this.pssysbdschemeidDirtyFlag = true;
    }

    public String getPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeId();
        }
        return this.pssysbdschemeid;
    }

    public boolean isPSSysBDSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeIdDirty();
        }
        return this.pssysbdschemeidDirtyFlag;
    }

    public void resetPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeId();
            return;
        }
        this.pssysbdschemeidDirtyFlag = false;
        this.pssysbdschemeid = null;
    }

    public void setPSSysBDSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemename = string;
        this.pssysbdschemenameDirtyFlag = true;
    }

    public String getPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeName();
        }
        return this.pssysbdschemename;
    }

    public boolean isPSSysBDSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeNameDirty();
        }
        return this.pssysbdschemenameDirtyFlag;
    }

    public void resetPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeName();
            return;
        }
        this.pssysbdschemenameDirtyFlag = false;
        this.pssysbdschemename = null;
    }

    public void setPSSysBDTableRSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableRSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtablersid = string;
        this.pssysbdtablersidDirtyFlag = true;
    }

    public String getPSSysBDTableRSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableRSId();
        }
        return this.pssysbdtablersid;
    }

    public boolean isPSSysBDTableRSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableRSIdDirty();
        }
        return this.pssysbdtablersidDirtyFlag;
    }

    public void resetPSSysBDTableRSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableRSId();
            return;
        }
        this.pssysbdtablersidDirtyFlag = false;
        this.pssysbdtablersid = null;
    }

    public void setPSSysBDTableRSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableRSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtablersname = string;
        this.pssysbdtablersnameDirtyFlag = true;
    }

    public String getPSSysBDTableRSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableRSName();
        }
        return this.pssysbdtablersname;
    }

    public boolean isPSSysBDTableRSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableRSNameDirty();
        }
        return this.pssysbdtablersnameDirtyFlag;
    }

    public void resetPSSysBDTableRSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableRSName();
            return;
        }
        this.pssysbdtablersnameDirtyFlag = false;
        this.pssysbdtablersname = null;
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
        PSSysBDTableRSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBDTableRSBase pSSysBDTableRSBase) {
        pSSysBDTableRSBase.resetCodeName();
        pSSysBDTableRSBase.resetCreateDate();
        pSSysBDTableRSBase.resetCreateMan();
        pSSysBDTableRSBase.resetMajorPSSysBDTableId();
        pSSysBDTableRSBase.resetMajorPSSysBDTableName();
        pSSysBDTableRSBase.resetMemo();
        pSSysBDTableRSBase.resetMinorCodeName();
        pSSysBDTableRSBase.resetMinorPSSysBDTableId();
        pSSysBDTableRSBase.resetMinorPSSysBDTableName();
        pSSysBDTableRSBase.resetOrderValue();
        pSSysBDTableRSBase.resetPSDERId();
        pSSysBDTableRSBase.resetPSDERName();
        pSSysBDTableRSBase.resetPSSysBDSchemeId();
        pSSysBDTableRSBase.resetPSSysBDSchemeName();
        pSSysBDTableRSBase.resetPSSysBDTableRSId();
        pSSysBDTableRSBase.resetPSSysBDTableRSName();
        pSSysBDTableRSBase.resetUpdateDate();
        pSSysBDTableRSBase.resetUpdateMan();
        pSSysBDTableRSBase.resetUserCat();
        pSSysBDTableRSBase.resetUserTag();
        pSSysBDTableRSBase.resetUserTag2();
        pSSysBDTableRSBase.resetUserTag3();
        pSSysBDTableRSBase.resetUserTag4();
        pSSysBDTableRSBase.resetValidFlag();
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
        if (!bl || this.isMajorPSSysBDTableIdDirty()) {
            hashMap.put(FIELD_MAJORPSSYSBDTABLEID, this.getMajorPSSysBDTableId());
        }
        if (!bl || this.isMajorPSSysBDTableNameDirty()) {
            hashMap.put(FIELD_MAJORPSSYSBDTABLENAME, this.getMajorPSSysBDTableName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorCodeNameDirty()) {
            hashMap.put(FIELD_MINORCODENAME, this.getMinorCodeName());
        }
        if (!bl || this.isMinorPSSysBDTableIdDirty()) {
            hashMap.put(FIELD_MINORPSSYSBDTABLEID, this.getMinorPSSysBDTableId());
        }
        if (!bl || this.isMinorPSSysBDTableNameDirty()) {
            hashMap.put(FIELD_MINORPSSYSBDTABLENAME, this.getMinorPSSysBDTableName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSSysBDSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMEID, this.getPSSysBDSchemeId());
        }
        if (!bl || this.isPSSysBDSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMENAME, this.getPSSysBDSchemeName());
        }
        if (!bl || this.isPSSysBDTableRSIdDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLERSID, this.getPSSysBDTableRSId());
        }
        if (!bl || this.isPSSysBDTableRSNameDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLERSNAME, this.getPSSysBDTableRSName());
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
        return PSSysBDTableRSBase.get(this, n);
    }

    private static Object get(PSSysBDTableRSBase pSSysBDTableRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableRSBase.getCodeName();
            }
            case 1: {
                return pSSysBDTableRSBase.getCreateDate();
            }
            case 2: {
                return pSSysBDTableRSBase.getCreateMan();
            }
            case 3: {
                return pSSysBDTableRSBase.getMajorPSSysBDTableId();
            }
            case 4: {
                return pSSysBDTableRSBase.getMajorPSSysBDTableName();
            }
            case 5: {
                return pSSysBDTableRSBase.getMemo();
            }
            case 6: {
                return pSSysBDTableRSBase.getMinorCodeName();
            }
            case 7: {
                return pSSysBDTableRSBase.getMinorPSSysBDTableId();
            }
            case 8: {
                return pSSysBDTableRSBase.getMinorPSSysBDTableName();
            }
            case 9: {
                return pSSysBDTableRSBase.getOrderValue();
            }
            case 10: {
                return pSSysBDTableRSBase.getPSDERId();
            }
            case 11: {
                return pSSysBDTableRSBase.getPSDERName();
            }
            case 12: {
                return pSSysBDTableRSBase.getPSSysBDSchemeId();
            }
            case 13: {
                return pSSysBDTableRSBase.getPSSysBDSchemeName();
            }
            case 14: {
                return pSSysBDTableRSBase.getPSSysBDTableRSId();
            }
            case 15: {
                return pSSysBDTableRSBase.getPSSysBDTableRSName();
            }
            case 16: {
                return pSSysBDTableRSBase.getUpdateDate();
            }
            case 17: {
                return pSSysBDTableRSBase.getUpdateMan();
            }
            case 18: {
                return pSSysBDTableRSBase.getUserCat();
            }
            case 19: {
                return pSSysBDTableRSBase.getUserTag();
            }
            case 20: {
                return pSSysBDTableRSBase.getUserTag2();
            }
            case 21: {
                return pSSysBDTableRSBase.getUserTag3();
            }
            case 22: {
                return pSSysBDTableRSBase.getUserTag4();
            }
            case 23: {
                return pSSysBDTableRSBase.getValidFlag();
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
        PSSysBDTableRSBase.set(this, n, object);
    }

    private static void set(PSSysBDTableRSBase pSSysBDTableRSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDTableRSBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBDTableRSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysBDTableRSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBDTableRSBase.setMajorPSSysBDTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBDTableRSBase.setMajorPSSysBDTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBDTableRSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBDTableRSBase.setMinorCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBDTableRSBase.setMinorPSSysBDTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBDTableRSBase.setMinorPSSysBDTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBDTableRSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysBDTableRSBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBDTableRSBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBDTableRSBase.setPSSysBDSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBDTableRSBase.setPSSysBDSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBDTableRSBase.setPSSysBDTableRSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBDTableRSBase.setPSSysBDTableRSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBDTableRSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysBDTableRSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBDTableRSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBDTableRSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBDTableRSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBDTableRSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBDTableRSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBDTableRSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBDTableRSBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBDTableRSBase pSSysBDTableRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableRSBase.getCodeName() == null;
            }
            case 1: {
                return pSSysBDTableRSBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysBDTableRSBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysBDTableRSBase.getMajorPSSysBDTableId() == null;
            }
            case 4: {
                return pSSysBDTableRSBase.getMajorPSSysBDTableName() == null;
            }
            case 5: {
                return pSSysBDTableRSBase.getMemo() == null;
            }
            case 6: {
                return pSSysBDTableRSBase.getMinorCodeName() == null;
            }
            case 7: {
                return pSSysBDTableRSBase.getMinorPSSysBDTableId() == null;
            }
            case 8: {
                return pSSysBDTableRSBase.getMinorPSSysBDTableName() == null;
            }
            case 9: {
                return pSSysBDTableRSBase.getOrderValue() == null;
            }
            case 10: {
                return pSSysBDTableRSBase.getPSDERId() == null;
            }
            case 11: {
                return pSSysBDTableRSBase.getPSDERName() == null;
            }
            case 12: {
                return pSSysBDTableRSBase.getPSSysBDSchemeId() == null;
            }
            case 13: {
                return pSSysBDTableRSBase.getPSSysBDSchemeName() == null;
            }
            case 14: {
                return pSSysBDTableRSBase.getPSSysBDTableRSId() == null;
            }
            case 15: {
                return pSSysBDTableRSBase.getPSSysBDTableRSName() == null;
            }
            case 16: {
                return pSSysBDTableRSBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysBDTableRSBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysBDTableRSBase.getUserCat() == null;
            }
            case 19: {
                return pSSysBDTableRSBase.getUserTag() == null;
            }
            case 20: {
                return pSSysBDTableRSBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysBDTableRSBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysBDTableRSBase.getUserTag4() == null;
            }
            case 23: {
                return pSSysBDTableRSBase.getValidFlag() == null;
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
        return PSSysBDTableRSBase.contains(this, n);
    }

    private static boolean contains(PSSysBDTableRSBase pSSysBDTableRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableRSBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysBDTableRSBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysBDTableRSBase.isCreateManDirty();
            }
            case 3: {
                return pSSysBDTableRSBase.isMajorPSSysBDTableIdDirty();
            }
            case 4: {
                return pSSysBDTableRSBase.isMajorPSSysBDTableNameDirty();
            }
            case 5: {
                return pSSysBDTableRSBase.isMemoDirty();
            }
            case 6: {
                return pSSysBDTableRSBase.isMinorCodeNameDirty();
            }
            case 7: {
                return pSSysBDTableRSBase.isMinorPSSysBDTableIdDirty();
            }
            case 8: {
                return pSSysBDTableRSBase.isMinorPSSysBDTableNameDirty();
            }
            case 9: {
                return pSSysBDTableRSBase.isOrderValueDirty();
            }
            case 10: {
                return pSSysBDTableRSBase.isPSDERIdDirty();
            }
            case 11: {
                return pSSysBDTableRSBase.isPSDERNameDirty();
            }
            case 12: {
                return pSSysBDTableRSBase.isPSSysBDSchemeIdDirty();
            }
            case 13: {
                return pSSysBDTableRSBase.isPSSysBDSchemeNameDirty();
            }
            case 14: {
                return pSSysBDTableRSBase.isPSSysBDTableRSIdDirty();
            }
            case 15: {
                return pSSysBDTableRSBase.isPSSysBDTableRSNameDirty();
            }
            case 16: {
                return pSSysBDTableRSBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysBDTableRSBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysBDTableRSBase.isUserCatDirty();
            }
            case 19: {
                return pSSysBDTableRSBase.isUserTagDirty();
            }
            case 20: {
                return pSSysBDTableRSBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysBDTableRSBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysBDTableRSBase.isUserTag4Dirty();
            }
            case 23: {
                return pSSysBDTableRSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBDTableRSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBDTableRSBase pSSysBDTableRSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBDTableRSBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getMajorPSSysBDTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpssysbdtableid", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getMajorPSSysBDTableId()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getMajorPSSysBDTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpssysbdtablename", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getMajorPSSysBDTableName()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getMinorCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorcodename", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getMinorCodeName()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getMinorPSSysBDTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpssysbdtableid", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getMinorPSSysBDTableId()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getMinorPSSysBDTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpssysbdtablename", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getMinorPSSysBDTableName()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getPSSysBDSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemeid", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getPSSysBDSchemeId()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getPSSysBDSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemename", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getPSSysBDSchemeName()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getPSSysBDTableRSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablersid", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getPSSysBDTableRSId()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getPSSysBDTableRSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablersname", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getPSSysBDTableRSName()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBDTableRSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBDTableRSBase.getJSONValue((Object)pSSysBDTableRSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBDTableRSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBDTableRSBase pSSysBDTableRSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBDTableRSBase.getCodeName() != null) {
            object = pSSysBDTableRSBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getCreateDate() != null) {
            object = pSSysBDTableRSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDTableRSBase.getCreateMan() != null) {
            object = pSSysBDTableRSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getMajorPSSysBDTableId() != null) {
            object = pSSysBDTableRSBase.getMajorPSSysBDTableId();
            xmlNode.setAttribute(FIELD_MAJORPSSYSBDTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getMajorPSSysBDTableName() != null) {
            object = pSSysBDTableRSBase.getMajorPSSysBDTableName();
            xmlNode.setAttribute(FIELD_MAJORPSSYSBDTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getMemo() != null) {
            object = pSSysBDTableRSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getMinorCodeName() != null) {
            object = pSSysBDTableRSBase.getMinorCodeName();
            xmlNode.setAttribute(FIELD_MINORCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getMinorPSSysBDTableId() != null) {
            object = pSSysBDTableRSBase.getMinorPSSysBDTableId();
            xmlNode.setAttribute(FIELD_MINORPSSYSBDTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getMinorPSSysBDTableName() != null) {
            object = pSSysBDTableRSBase.getMinorPSSysBDTableName();
            xmlNode.setAttribute(FIELD_MINORPSSYSBDTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getOrderValue() != null) {
            object = pSSysBDTableRSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableRSBase.getPSDERId() != null) {
            object = pSSysBDTableRSBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getPSDERName() != null) {
            object = pSSysBDTableRSBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getPSSysBDSchemeId() != null) {
            object = pSSysBDTableRSBase.getPSSysBDSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getPSSysBDSchemeName() != null) {
            object = pSSysBDTableRSBase.getPSSysBDSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getPSSysBDTableRSId() != null) {
            object = pSSysBDTableRSBase.getPSSysBDTableRSId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLERSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getPSSysBDTableRSName() != null) {
            object = pSSysBDTableRSBase.getPSSysBDTableRSName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLERSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getUpdateDate() != null) {
            object = pSSysBDTableRSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDTableRSBase.getUpdateMan() != null) {
            object = pSSysBDTableRSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getUserCat() != null) {
            object = pSSysBDTableRSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getUserTag() != null) {
            object = pSSysBDTableRSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getUserTag2() != null) {
            object = pSSysBDTableRSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getUserTag3() != null) {
            object = pSSysBDTableRSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getUserTag4() != null) {
            object = pSSysBDTableRSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableRSBase.getValidFlag() != null) {
            object = pSSysBDTableRSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBDTableRSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBDTableRSBase pSSysBDTableRSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBDTableRSBase.isCodeNameDirty() && (bl || pSSysBDTableRSBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBDTableRSBase.getCodeName());
        }
        if (pSSysBDTableRSBase.isCreateDateDirty() && (bl || pSSysBDTableRSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBDTableRSBase.getCreateDate());
        }
        if (pSSysBDTableRSBase.isCreateManDirty() && (bl || pSSysBDTableRSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBDTableRSBase.getCreateMan());
        }
        if (pSSysBDTableRSBase.isMajorPSSysBDTableIdDirty() && (bl || pSSysBDTableRSBase.getMajorPSSysBDTableId() != null)) {
            iDataObject.set(FIELD_MAJORPSSYSBDTABLEID, (Object)pSSysBDTableRSBase.getMajorPSSysBDTableId());
        }
        if (pSSysBDTableRSBase.isMajorPSSysBDTableNameDirty() && (bl || pSSysBDTableRSBase.getMajorPSSysBDTableName() != null)) {
            iDataObject.set(FIELD_MAJORPSSYSBDTABLENAME, (Object)pSSysBDTableRSBase.getMajorPSSysBDTableName());
        }
        if (pSSysBDTableRSBase.isMemoDirty() && (bl || pSSysBDTableRSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBDTableRSBase.getMemo());
        }
        if (pSSysBDTableRSBase.isMinorCodeNameDirty() && (bl || pSSysBDTableRSBase.getMinorCodeName() != null)) {
            iDataObject.set(FIELD_MINORCODENAME, (Object)pSSysBDTableRSBase.getMinorCodeName());
        }
        if (pSSysBDTableRSBase.isMinorPSSysBDTableIdDirty() && (bl || pSSysBDTableRSBase.getMinorPSSysBDTableId() != null)) {
            iDataObject.set(FIELD_MINORPSSYSBDTABLEID, (Object)pSSysBDTableRSBase.getMinorPSSysBDTableId());
        }
        if (pSSysBDTableRSBase.isMinorPSSysBDTableNameDirty() && (bl || pSSysBDTableRSBase.getMinorPSSysBDTableName() != null)) {
            iDataObject.set(FIELD_MINORPSSYSBDTABLENAME, (Object)pSSysBDTableRSBase.getMinorPSSysBDTableName());
        }
        if (pSSysBDTableRSBase.isOrderValueDirty() && (bl || pSSysBDTableRSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBDTableRSBase.getOrderValue());
        }
        if (pSSysBDTableRSBase.isPSDERIdDirty() && (bl || pSSysBDTableRSBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSSysBDTableRSBase.getPSDERId());
        }
        if (pSSysBDTableRSBase.isPSDERNameDirty() && (bl || pSSysBDTableRSBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSSysBDTableRSBase.getPSDERName());
        }
        if (pSSysBDTableRSBase.isPSSysBDSchemeIdDirty() && (bl || pSSysBDTableRSBase.getPSSysBDSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMEID, (Object)pSSysBDTableRSBase.getPSSysBDSchemeId());
        }
        if (pSSysBDTableRSBase.isPSSysBDSchemeNameDirty() && (bl || pSSysBDTableRSBase.getPSSysBDSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMENAME, (Object)pSSysBDTableRSBase.getPSSysBDSchemeName());
        }
        if (pSSysBDTableRSBase.isPSSysBDTableRSIdDirty() && (bl || pSSysBDTableRSBase.getPSSysBDTableRSId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLERSID, (Object)pSSysBDTableRSBase.getPSSysBDTableRSId());
        }
        if (pSSysBDTableRSBase.isPSSysBDTableRSNameDirty() && (bl || pSSysBDTableRSBase.getPSSysBDTableRSName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLERSNAME, (Object)pSSysBDTableRSBase.getPSSysBDTableRSName());
        }
        if (pSSysBDTableRSBase.isUpdateDateDirty() && (bl || pSSysBDTableRSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBDTableRSBase.getUpdateDate());
        }
        if (pSSysBDTableRSBase.isUpdateManDirty() && (bl || pSSysBDTableRSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBDTableRSBase.getUpdateMan());
        }
        if (pSSysBDTableRSBase.isUserCatDirty() && (bl || pSSysBDTableRSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBDTableRSBase.getUserCat());
        }
        if (pSSysBDTableRSBase.isUserTagDirty() && (bl || pSSysBDTableRSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBDTableRSBase.getUserTag());
        }
        if (pSSysBDTableRSBase.isUserTag2Dirty() && (bl || pSSysBDTableRSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBDTableRSBase.getUserTag2());
        }
        if (pSSysBDTableRSBase.isUserTag3Dirty() && (bl || pSSysBDTableRSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBDTableRSBase.getUserTag3());
        }
        if (pSSysBDTableRSBase.isUserTag4Dirty() && (bl || pSSysBDTableRSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBDTableRSBase.getUserTag4());
        }
        if (pSSysBDTableRSBase.isValidFlagDirty() && (bl || pSSysBDTableRSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBDTableRSBase.getValidFlag());
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
        return PSSysBDTableRSBase.remove(this, n);
    }

    private static boolean remove(PSSysBDTableRSBase pSSysBDTableRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDTableRSBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysBDTableRSBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysBDTableRSBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysBDTableRSBase.resetMajorPSSysBDTableId();
                return true;
            }
            case 4: {
                pSSysBDTableRSBase.resetMajorPSSysBDTableName();
                return true;
            }
            case 5: {
                pSSysBDTableRSBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysBDTableRSBase.resetMinorCodeName();
                return true;
            }
            case 7: {
                pSSysBDTableRSBase.resetMinorPSSysBDTableId();
                return true;
            }
            case 8: {
                pSSysBDTableRSBase.resetMinorPSSysBDTableName();
                return true;
            }
            case 9: {
                pSSysBDTableRSBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSSysBDTableRSBase.resetPSDERId();
                return true;
            }
            case 11: {
                pSSysBDTableRSBase.resetPSDERName();
                return true;
            }
            case 12: {
                pSSysBDTableRSBase.resetPSSysBDSchemeId();
                return true;
            }
            case 13: {
                pSSysBDTableRSBase.resetPSSysBDSchemeName();
                return true;
            }
            case 14: {
                pSSysBDTableRSBase.resetPSSysBDTableRSId();
                return true;
            }
            case 15: {
                pSSysBDTableRSBase.resetPSSysBDTableRSName();
                return true;
            }
            case 16: {
                pSSysBDTableRSBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysBDTableRSBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysBDTableRSBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysBDTableRSBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysBDTableRSBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysBDTableRSBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysBDTableRSBase.resetUserTag4();
                return true;
            }
            case 23: {
                pSSysBDTableRSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDScheme getPSSysBDScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDScheme();
        }
        if (this.getPSSysBDSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDSchemeLock;
        synchronized (n) {
            if (this.pssysbdscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDSchemeId(), (Object)this.pssysbdscheme.getPSSysBDSchemeId()) != 0L) {
                this.pssysbdscheme = null;
            }
            if (this.pssysbdscheme == null) {
                PSSysBDScheme pSSysBDScheme = new PSSysBDScheme();
                pSSysBDScheme.setPSSysBDSchemeId(this.getPSSysBDSchemeId());
                PSSysBDSchemeService pSSysBDSchemeService = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDSchemeService.autoGet((IEntity)pSSysBDScheme);
                this.pssysbdscheme = pSSysBDScheme;
            }
            return this.pssysbdscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDTable getMajorPSSysBDTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSSysBDTable();
        }
        if (this.getMajorPSSysBDTableId() == null) {
            return null;
        }
        Integer n = this.objMajorPSSysBDTableLock;
        synchronized (n) {
            if (this.majorpssysbdtable != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSSysBDTableId(), (Object)this.majorpssysbdtable.getPSSysBDTableId()) != 0L) {
                this.majorpssysbdtable = null;
            }
            if (this.majorpssysbdtable == null) {
                PSSysBDTable pSSysBDTable = new PSSysBDTable();
                pSSysBDTable.setPSSysBDTableId(this.getMajorPSSysBDTableId());
                PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDTableService.autoGet((IEntity)pSSysBDTable);
                this.majorpssysbdtable = pSSysBDTable;
            }
            return this.majorpssysbdtable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDTable getMinorPSSysBDTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSSysBDTable();
        }
        if (this.getMinorPSSysBDTableId() == null) {
            return null;
        }
        Integer n = this.objMinorPSSysBDTableLock;
        synchronized (n) {
            if (this.minorpssysbdtable != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSSysBDTableId(), (Object)this.minorpssysbdtable.getPSSysBDTableId()) != 0L) {
                this.minorpssysbdtable = null;
            }
            if (this.minorpssysbdtable == null) {
                PSSysBDTable pSSysBDTable = new PSSysBDTable();
                pSSysBDTable.setPSSysBDTableId(this.getMinorPSSysBDTableId());
                PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDTableService.autoGet((IEntity)pSSysBDTable);
                this.minorpssysbdtable = pSSysBDTable;
            }
            return this.minorpssysbdtable;
        }
    }

    private PSSysBDTableRSBase getProxyEntity() {
        return this.proxyPSSysBDTableRSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBDTableRSBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBDTableRSBase) {
            this.proxyPSSysBDTableRSBase = (PSSysBDTableRSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MAJORPSSYSBDTABLEID, 3);
        fieldIndexMap.put(FIELD_MAJORPSSYSBDTABLENAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MINORCODENAME, 6);
        fieldIndexMap.put(FIELD_MINORPSSYSBDTABLEID, 7);
        fieldIndexMap.put(FIELD_MINORPSSYSBDTABLENAME, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PSDERID, 10);
        fieldIndexMap.put(FIELD_PSDERNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMEID, 12);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSBDTABLERSID, 14);
        fieldIndexMap.put(FIELD_PSSYSBDTABLERSNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
        fieldIndexMap.put(FIELD_VALIDFLAG, 23);
    }
}

