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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemDBCfgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSystemDBCfgBase.class);
    public static final String FIELD_APPENDSCHEMA = "APPENDSCHEMA";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBSCHEMANAME = "DBSCHEMANAME";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ENABLEWEBTOOL = "ENABLEWEBTOOL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NO2PSDBDEVINSTID = "NO2PSDBDEVINSTID";
    public static final String FIELD_NO2PSDBDEVINSTNAME = "NO2PSDBDEVINSTNAME";
    public static final String FIELD_NO2PSDCDBINSTID = "NO2PSDCDBINSTID";
    public static final String FIELD_NO2PSDCDBINSTNAME = "NO2PSDCDBINSTNAME";
    public static final String FIELD_NODBINSTMODE = "NODBINSTMODE";
    public static final String FIELD_NULLVALORDER = "NULLVALORDER";
    public static final String FIELD_OBJNAMECASE = "OBJNAMECASE";
    public static final String FIELD_PSDBDEVINSTID = "PSDBDEVINSTID";
    public static final String FIELD_PSDBDEVINSTNAME = "PSDBDEVINSTNAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PUBCOMMENTFLAG = "PUBCOMMENTFLAG";
    public static final String FIELD_PUBDBMODELFLAG = "PUBDBMODELFLAG";
    public static final String FIELD_PUBFKEYFLAG = "PUBFKEYFLAG";
    public static final String FIELD_PUBINDEXFLAG = "PUBINDEXFLAG";
    public static final String FIELD_PUBVIEWFLAG = "PUBVIEWFLAG";
    public static final String FIELD_RESINFO = "RESINFO";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_TABSPACE = "TABSPACE";
    public static final String FIELD_TABSPACE2 = "TABSPACE2";
    public static final String FIELD_TABSPACE3 = "TABSPACE3";
    public static final String FIELD_TABSPACE4 = "TABSPACE4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_APPENDSCHEMA = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DBSCHEMANAME = 3;
    private static final int INDEX_DEFAULTFLAG = 4;
    private static final int INDEX_ENABLEWEBTOOL = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_NO2PSDBDEVINSTID = 7;
    private static final int INDEX_NO2PSDBDEVINSTNAME = 8;
    private static final int INDEX_NO2PSDCDBINSTID = 9;
    private static final int INDEX_NO2PSDCDBINSTNAME = 10;
    private static final int INDEX_NODBINSTMODE = 11;
    private static final int INDEX_NULLVALORDER = 12;
    private static final int INDEX_OBJNAMECASE = 13;
    private static final int INDEX_PSDBDEVINSTID = 14;
    private static final int INDEX_PSDBDEVINSTNAME = 15;
    private static final int INDEX_PSDEVCENTERDBINSTID = 16;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 17;
    private static final int INDEX_PSSYSTEMDBCFGID = 18;
    private static final int INDEX_PSSYSTEMDBCFGNAME = 19;
    private static final int INDEX_PSSYSTEMID = 20;
    private static final int INDEX_PSSYSTEMNAME = 21;
    private static final int INDEX_PUBCOMMENTFLAG = 22;
    private static final int INDEX_PUBDBMODELFLAG = 23;
    private static final int INDEX_PUBFKEYFLAG = 24;
    private static final int INDEX_PUBINDEXFLAG = 25;
    private static final int INDEX_PUBVIEWFLAG = 26;
    private static final int INDEX_RESINFO = 27;
    private static final int INDEX_RESREADYTIME = 28;
    private static final int INDEX_RESSTATE = 29;
    private static final int INDEX_TABSPACE = 30;
    private static final int INDEX_TABSPACE2 = 31;
    private static final int INDEX_TABSPACE3 = 32;
    private static final int INDEX_TABSPACE4 = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_USERCAT = 36;
    private static final int INDEX_USERPARAMS = 37;
    private static final int INDEX_USERTAG = 38;
    private static final int INDEX_USERTAG2 = 39;
    private static final int INDEX_USERTAG3 = 40;
    private static final int INDEX_USERTAG4 = 41;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSystemDBCfgBase proxyPSSystemDBCfgBase = null;
    private boolean appendschemaDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbschemanameDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean enablewebtoolDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean no2psdbdevinstidDirtyFlag = false;
    private boolean no2psdbdevinstnameDirtyFlag = false;
    private boolean no2psdcdbinstidDirtyFlag = false;
    private boolean no2psdcdbinstnameDirtyFlag = false;
    private boolean nodbinstmodeDirtyFlag = false;
    private boolean nullvalorderDirtyFlag = false;
    private boolean objnamecaseDirtyFlag = false;
    private boolean psdbdevinstidDirtyFlag = false;
    private boolean psdbdevinstnameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean pssystemdbcfgidDirtyFlag = false;
    private boolean pssystemdbcfgnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pubcommentflagDirtyFlag = false;
    private boolean pubdbmodelflagDirtyFlag = false;
    private boolean pubfkeyflagDirtyFlag = false;
    private boolean pubindexflagDirtyFlag = false;
    private boolean pubviewflagDirtyFlag = false;
    private boolean resinfoDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean tabspaceDirtyFlag = false;
    private boolean tabspace2DirtyFlag = false;
    private boolean tabspace3DirtyFlag = false;
    private boolean tabspace4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="appendschema")
    private Integer appendschema;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbschemaname")
    private String dbschemaname;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="enablewebtool")
    private Integer enablewebtool;
    @Column(name="memo")
    private String memo;
    @Column(name="no2psdbdevinstid")
    private String no2psdbdevinstid;
    @Column(name="no2psdbdevinstname")
    private String no2psdbdevinstname;
    @Column(name="no2psdcdbinstid")
    private String no2psdcdbinstid;
    @Column(name="no2psdcdbinstname")
    private String no2psdcdbinstname;
    @Column(name="nodbinstmode")
    private Integer nodbinstmode;
    @Column(name="nullvalorder")
    private String nullvalorder;
    @Column(name="objnamecase")
    private String objnamecase;
    @Column(name="psdbdevinstid")
    private String psdbdevinstid;
    @Column(name="psdbdevinstname")
    private String psdbdevinstname;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="pssystemdbcfgid")
    private String pssystemdbcfgid;
    @Column(name="pssystemdbcfgname")
    private String pssystemdbcfgname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pubcommentflag")
    private Integer pubcommentflag;
    @Column(name="pubdbmodelflag")
    private Integer pubdbmodelflag;
    @Column(name="pubfkeyflag")
    private Integer pubfkeyflag;
    @Column(name="pubindexflag")
    private Integer pubindexflag;
    @Column(name="pubviewflag")
    private Integer pubviewflag;
    @Column(name="resinfo")
    private String resinfo;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="tabspace")
    private String tabspace;
    @Column(name="tabspace2")
    private String tabspace2;
    @Column(name="tabspace3")
    private String tabspace3;
    @Column(name="tabspace4")
    private String tabspace4;
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
    private Integer objNo2PSDBDevInstLock = new Integer(1);
    private PSDBDevInst no2psdbdevinst = null;
    private Integer objPSDBDevInstLock = new Integer(1);
    private PSDBDevInst psdbdevinst = null;
    private Integer objNo2PSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst no2psdcdbinst = null;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setAppendSchema(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppendSchema(n);
            return;
        }
        this.appendschema = n;
        this.appendschemaDirtyFlag = true;
    }

    public Integer getAppendSchema() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppendSchema();
        }
        return this.appendschema;
    }

    public boolean isAppendSchemaDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppendSchemaDirty();
        }
        return this.appendschemaDirtyFlag;
    }

    public void resetAppendSchema() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppendSchema();
            return;
        }
        this.appendschemaDirtyFlag = false;
        this.appendschema = null;
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

    public void setDBSchemaName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBSchemaName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbschemaname = string;
        this.dbschemanameDirtyFlag = true;
    }

    public String getDBSchemaName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBSchemaName();
        }
        return this.dbschemaname;
    }

    public boolean isDBSchemaNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBSchemaNameDirty();
        }
        return this.dbschemanameDirtyFlag;
    }

    public void resetDBSchemaName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBSchemaName();
            return;
        }
        this.dbschemanameDirtyFlag = false;
        this.dbschemaname = null;
    }

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setEnableWebTool(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableWebTool(n);
            return;
        }
        this.enablewebtool = n;
        this.enablewebtoolDirtyFlag = true;
    }

    public Integer getEnableWebTool() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableWebTool();
        }
        return this.enablewebtool;
    }

    public boolean isEnableWebToolDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableWebToolDirty();
        }
        return this.enablewebtoolDirtyFlag;
    }

    public void resetEnableWebTool() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableWebTool();
            return;
        }
        this.enablewebtoolDirtyFlag = false;
        this.enablewebtool = null;
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

    public void setNo2PSDBDevInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDBDevInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdbdevinstid = string;
        this.no2psdbdevinstidDirtyFlag = true;
    }

    public String getNo2PSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDBDevInstId();
        }
        return this.no2psdbdevinstid;
    }

    public boolean isNo2PSDBDevInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDBDevInstIdDirty();
        }
        return this.no2psdbdevinstidDirtyFlag;
    }

    public void resetNo2PSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDBDevInstId();
            return;
        }
        this.no2psdbdevinstidDirtyFlag = false;
        this.no2psdbdevinstid = null;
    }

    public void setNo2PSDBDevInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDBDevInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdbdevinstname = string;
        this.no2psdbdevinstnameDirtyFlag = true;
    }

    public String getNo2PSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDBDevInstName();
        }
        return this.no2psdbdevinstname;
    }

    public boolean isNo2PSDBDevInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDBDevInstNameDirty();
        }
        return this.no2psdbdevinstnameDirtyFlag;
    }

    public void resetNo2PSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDBDevInstName();
            return;
        }
        this.no2psdbdevinstnameDirtyFlag = false;
        this.no2psdbdevinstname = null;
    }

    public void setNo2PSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdcdbinstid = string;
        this.no2psdcdbinstidDirtyFlag = true;
    }

    public String getNo2PSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDCDBInstId();
        }
        return this.no2psdcdbinstid;
    }

    public boolean isNo2PSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDCDBInstIdDirty();
        }
        return this.no2psdcdbinstidDirtyFlag;
    }

    public void resetNo2PSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDCDBInstId();
            return;
        }
        this.no2psdcdbinstidDirtyFlag = false;
        this.no2psdcdbinstid = null;
    }

    public void setNo2PSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdcdbinstname = string;
        this.no2psdcdbinstnameDirtyFlag = true;
    }

    public String getNo2PSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDCDBInstName();
        }
        return this.no2psdcdbinstname;
    }

    public boolean isNo2PSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDCDBInstNameDirty();
        }
        return this.no2psdcdbinstnameDirtyFlag;
    }

    public void resetNo2PSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDCDBInstName();
            return;
        }
        this.no2psdcdbinstnameDirtyFlag = false;
        this.no2psdcdbinstname = null;
    }

    public void setNoDBInstMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoDBInstMode(n);
            return;
        }
        this.nodbinstmode = n;
        this.nodbinstmodeDirtyFlag = true;
    }

    public Integer getNoDBInstMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoDBInstMode();
        }
        return this.nodbinstmode;
    }

    public boolean isNoDBInstModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoDBInstModeDirty();
        }
        return this.nodbinstmodeDirtyFlag;
    }

    public void resetNoDBInstMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoDBInstMode();
            return;
        }
        this.nodbinstmodeDirtyFlag = false;
        this.nodbinstmode = null;
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

    public void setObjNameCase(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjNameCase(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objnamecase = string;
        this.objnamecaseDirtyFlag = true;
    }

    public String getObjNameCase() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjNameCase();
        }
        return this.objnamecase;
    }

    public boolean isObjNameCaseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjNameCaseDirty();
        }
        return this.objnamecaseDirtyFlag;
    }

    public void resetObjNameCase() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjNameCase();
            return;
        }
        this.objnamecaseDirtyFlag = false;
        this.objnamecase = null;
    }

    public void setPSDBDevInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstid = string;
        this.psdbdevinstidDirtyFlag = true;
    }

    public String getPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstId();
        }
        return this.psdbdevinstid;
    }

    public boolean isPSDBDevInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstIdDirty();
        }
        return this.psdbdevinstidDirtyFlag;
    }

    public void resetPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstId();
            return;
        }
        this.psdbdevinstidDirtyFlag = false;
        this.psdbdevinstid = null;
    }

    public void setPSDBDevInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstname = string;
        this.psdbdevinstnameDirtyFlag = true;
    }

    public String getPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstName();
        }
        return this.psdbdevinstname;
    }

    public boolean isPSDBDevInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstNameDirty();
        }
        return this.psdbdevinstnameDirtyFlag;
    }

    public void resetPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstName();
            return;
        }
        this.psdbdevinstnameDirtyFlag = false;
        this.psdbdevinstname = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
    }

    public void setPSSystemDBCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgid = string;
        this.pssystemdbcfgidDirtyFlag = true;
    }

    public String getPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgId();
        }
        return this.pssystemdbcfgid;
    }

    public boolean isPSSystemDBCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgIdDirty();
        }
        return this.pssystemdbcfgidDirtyFlag;
    }

    public void resetPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgId();
            return;
        }
        this.pssystemdbcfgidDirtyFlag = false;
        this.pssystemdbcfgid = null;
    }

    public void setPSSystemDBCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgname = string;
        this.pssystemdbcfgnameDirtyFlag = true;
    }

    public String getPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgName();
        }
        return this.pssystemdbcfgname;
    }

    public boolean isPSSystemDBCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgNameDirty();
        }
        return this.pssystemdbcfgnameDirtyFlag;
    }

    public void resetPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgName();
            return;
        }
        this.pssystemdbcfgnameDirtyFlag = false;
        this.pssystemdbcfgname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPubCommentFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubCommentFlag(n);
            return;
        }
        this.pubcommentflag = n;
        this.pubcommentflagDirtyFlag = true;
    }

    public Integer getPubCommentFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubCommentFlag();
        }
        return this.pubcommentflag;
    }

    public boolean isPubCommentFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubCommentFlagDirty();
        }
        return this.pubcommentflagDirtyFlag;
    }

    public void resetPubCommentFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubCommentFlag();
            return;
        }
        this.pubcommentflagDirtyFlag = false;
        this.pubcommentflag = null;
    }

    public void setPubDBModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubDBModelFlag(n);
            return;
        }
        this.pubdbmodelflag = n;
        this.pubdbmodelflagDirtyFlag = true;
    }

    public Integer getPubDBModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubDBModelFlag();
        }
        return this.pubdbmodelflag;
    }

    public boolean isPubDBModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubDBModelFlagDirty();
        }
        return this.pubdbmodelflagDirtyFlag;
    }

    public void resetPubDBModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubDBModelFlag();
            return;
        }
        this.pubdbmodelflagDirtyFlag = false;
        this.pubdbmodelflag = null;
    }

    public void setPubFKeyFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubFKeyFlag(n);
            return;
        }
        this.pubfkeyflag = n;
        this.pubfkeyflagDirtyFlag = true;
    }

    public Integer getPubFKeyFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubFKeyFlag();
        }
        return this.pubfkeyflag;
    }

    public boolean isPubFKeyFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubFKeyFlagDirty();
        }
        return this.pubfkeyflagDirtyFlag;
    }

    public void resetPubFKeyFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubFKeyFlag();
            return;
        }
        this.pubfkeyflagDirtyFlag = false;
        this.pubfkeyflag = null;
    }

    public void setPubIndexFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubIndexFlag(n);
            return;
        }
        this.pubindexflag = n;
        this.pubindexflagDirtyFlag = true;
    }

    public Integer getPubIndexFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubIndexFlag();
        }
        return this.pubindexflag;
    }

    public boolean isPubIndexFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubIndexFlagDirty();
        }
        return this.pubindexflagDirtyFlag;
    }

    public void resetPubIndexFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubIndexFlag();
            return;
        }
        this.pubindexflagDirtyFlag = false;
        this.pubindexflag = null;
    }

    public void setPubViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubViewFlag(n);
            return;
        }
        this.pubviewflag = n;
        this.pubviewflagDirtyFlag = true;
    }

    public Integer getPubViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubViewFlag();
        }
        return this.pubviewflag;
    }

    public boolean isPubViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubViewFlagDirty();
        }
        return this.pubviewflagDirtyFlag;
    }

    public void resetPubViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubViewFlag();
            return;
        }
        this.pubviewflagDirtyFlag = false;
        this.pubviewflag = null;
    }

    public void setResInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resinfo = string;
        this.resinfoDirtyFlag = true;
    }

    public String getResInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResInfo();
        }
        return this.resinfo;
    }

    public boolean isResInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResInfoDirty();
        }
        return this.resinfoDirtyFlag;
    }

    public void resetResInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResInfo();
            return;
        }
        this.resinfoDirtyFlag = false;
        this.resinfo = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
    }

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
    }

    public void setTabSpace(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTabSpace(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabspace = string;
        this.tabspaceDirtyFlag = true;
    }

    public String getTabSpace() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTabSpace();
        }
        return this.tabspace;
    }

    public boolean isTabSpaceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTabSpaceDirty();
        }
        return this.tabspaceDirtyFlag;
    }

    public void resetTabSpace() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTabSpace();
            return;
        }
        this.tabspaceDirtyFlag = false;
        this.tabspace = null;
    }

    public void setTabSpace2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTabSpace2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabspace2 = string;
        this.tabspace2DirtyFlag = true;
    }

    public String getTabSpace2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTabSpace2();
        }
        return this.tabspace2;
    }

    public boolean isTabSpace2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTabSpace2Dirty();
        }
        return this.tabspace2DirtyFlag;
    }

    public void resetTabSpace2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTabSpace2();
            return;
        }
        this.tabspace2DirtyFlag = false;
        this.tabspace2 = null;
    }

    public void setTabSpace3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTabSpace3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabspace3 = string;
        this.tabspace3DirtyFlag = true;
    }

    public String getTabSpace3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTabSpace3();
        }
        return this.tabspace3;
    }

    public boolean isTabSpace3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTabSpace3Dirty();
        }
        return this.tabspace3DirtyFlag;
    }

    public void resetTabSpace3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTabSpace3();
            return;
        }
        this.tabspace3DirtyFlag = false;
        this.tabspace3 = null;
    }

    public void setTabSpace4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTabSpace4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabspace4 = string;
        this.tabspace4DirtyFlag = true;
    }

    public String getTabSpace4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTabSpace4();
        }
        return this.tabspace4;
    }

    public boolean isTabSpace4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTabSpace4Dirty();
        }
        return this.tabspace4DirtyFlag;
    }

    public void resetTabSpace4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTabSpace4();
            return;
        }
        this.tabspace4DirtyFlag = false;
        this.tabspace4 = null;
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

    protected void onReset() {
        PSSystemDBCfgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSystemDBCfgBase pSSystemDBCfgBase) {
        pSSystemDBCfgBase.resetAppendSchema();
        pSSystemDBCfgBase.resetCreateDate();
        pSSystemDBCfgBase.resetCreateMan();
        pSSystemDBCfgBase.resetDBSchemaName();
        pSSystemDBCfgBase.resetDefaultFlag();
        pSSystemDBCfgBase.resetEnableWebTool();
        pSSystemDBCfgBase.resetMemo();
        pSSystemDBCfgBase.resetNo2PSDBDevInstId();
        pSSystemDBCfgBase.resetNo2PSDBDevInstName();
        pSSystemDBCfgBase.resetNo2PSDCDBInstId();
        pSSystemDBCfgBase.resetNo2PSDCDBInstName();
        pSSystemDBCfgBase.resetNoDBInstMode();
        pSSystemDBCfgBase.resetNullValOrder();
        pSSystemDBCfgBase.resetObjNameCase();
        pSSystemDBCfgBase.resetPSDBDevInstId();
        pSSystemDBCfgBase.resetPSDBDevInstName();
        pSSystemDBCfgBase.resetPSDevCenterDBInstId();
        pSSystemDBCfgBase.resetPSDevCenterDBInstName();
        pSSystemDBCfgBase.resetPSSystemDBCfgId();
        pSSystemDBCfgBase.resetPSSystemDBCfgName();
        pSSystemDBCfgBase.resetPSSystemId();
        pSSystemDBCfgBase.resetPSSystemName();
        pSSystemDBCfgBase.resetPubCommentFlag();
        pSSystemDBCfgBase.resetPubDBModelFlag();
        pSSystemDBCfgBase.resetPubFKeyFlag();
        pSSystemDBCfgBase.resetPubIndexFlag();
        pSSystemDBCfgBase.resetPubViewFlag();
        pSSystemDBCfgBase.resetResInfo();
        pSSystemDBCfgBase.resetResReadyTime();
        pSSystemDBCfgBase.resetResState();
        pSSystemDBCfgBase.resetTabSpace();
        pSSystemDBCfgBase.resetTabSpace2();
        pSSystemDBCfgBase.resetTabSpace3();
        pSSystemDBCfgBase.resetTabSpace4();
        pSSystemDBCfgBase.resetUpdateDate();
        pSSystemDBCfgBase.resetUpdateMan();
        pSSystemDBCfgBase.resetUserCat();
        pSSystemDBCfgBase.resetUserParams();
        pSSystemDBCfgBase.resetUserTag();
        pSSystemDBCfgBase.resetUserTag2();
        pSSystemDBCfgBase.resetUserTag3();
        pSSystemDBCfgBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppendSchemaDirty()) {
            hashMap.put(FIELD_APPENDSCHEMA, this.getAppendSchema());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBSchemaNameDirty()) {
            hashMap.put(FIELD_DBSCHEMANAME, this.getDBSchemaName());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isEnableWebToolDirty()) {
            hashMap.put(FIELD_ENABLEWEBTOOL, this.getEnableWebTool());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNo2PSDBDevInstIdDirty()) {
            hashMap.put(FIELD_NO2PSDBDEVINSTID, this.getNo2PSDBDevInstId());
        }
        if (!bl || this.isNo2PSDBDevInstNameDirty()) {
            hashMap.put(FIELD_NO2PSDBDEVINSTNAME, this.getNo2PSDBDevInstName());
        }
        if (!bl || this.isNo2PSDCDBInstIdDirty()) {
            hashMap.put(FIELD_NO2PSDCDBINSTID, this.getNo2PSDCDBInstId());
        }
        if (!bl || this.isNo2PSDCDBInstNameDirty()) {
            hashMap.put(FIELD_NO2PSDCDBINSTNAME, this.getNo2PSDCDBInstName());
        }
        if (!bl || this.isNoDBInstModeDirty()) {
            hashMap.put(FIELD_NODBINSTMODE, this.getNoDBInstMode());
        }
        if (!bl || this.isNullValOrderDirty()) {
            hashMap.put(FIELD_NULLVALORDER, this.getNullValOrder());
        }
        if (!bl || this.isObjNameCaseDirty()) {
            hashMap.put(FIELD_OBJNAMECASE, this.getObjNameCase());
        }
        if (!bl || this.isPSDBDevInstIdDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTID, this.getPSDBDevInstId());
        }
        if (!bl || this.isPSDBDevInstNameDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTNAME, this.getPSDBDevInstName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSSystemDBCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGID, this.getPSSystemDBCfgId());
        }
        if (!bl || this.isPSSystemDBCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGNAME, this.getPSSystemDBCfgName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPubCommentFlagDirty()) {
            hashMap.put(FIELD_PUBCOMMENTFLAG, this.getPubCommentFlag());
        }
        if (!bl || this.isPubDBModelFlagDirty()) {
            hashMap.put(FIELD_PUBDBMODELFLAG, this.getPubDBModelFlag());
        }
        if (!bl || this.isPubFKeyFlagDirty()) {
            hashMap.put(FIELD_PUBFKEYFLAG, this.getPubFKeyFlag());
        }
        if (!bl || this.isPubIndexFlagDirty()) {
            hashMap.put(FIELD_PUBINDEXFLAG, this.getPubIndexFlag());
        }
        if (!bl || this.isPubViewFlagDirty()) {
            hashMap.put(FIELD_PUBVIEWFLAG, this.getPubViewFlag());
        }
        if (!bl || this.isResInfoDirty()) {
            hashMap.put(FIELD_RESINFO, this.getResInfo());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isTabSpaceDirty()) {
            hashMap.put(FIELD_TABSPACE, this.getTabSpace());
        }
        if (!bl || this.isTabSpace2Dirty()) {
            hashMap.put(FIELD_TABSPACE2, this.getTabSpace2());
        }
        if (!bl || this.isTabSpace3Dirty()) {
            hashMap.put(FIELD_TABSPACE3, this.getTabSpace3());
        }
        if (!bl || this.isTabSpace4Dirty()) {
            hashMap.put(FIELD_TABSPACE4, this.getTabSpace4());
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
        return PSSystemDBCfgBase.get(this, n);
    }

    private static Object get(PSSystemDBCfgBase pSSystemDBCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemDBCfgBase.getAppendSchema();
            }
            case 1: {
                return pSSystemDBCfgBase.getCreateDate();
            }
            case 2: {
                return pSSystemDBCfgBase.getCreateMan();
            }
            case 3: {
                return pSSystemDBCfgBase.getDBSchemaName();
            }
            case 4: {
                return pSSystemDBCfgBase.getDefaultFlag();
            }
            case 5: {
                return pSSystemDBCfgBase.getEnableWebTool();
            }
            case 6: {
                return pSSystemDBCfgBase.getMemo();
            }
            case 7: {
                return pSSystemDBCfgBase.getNo2PSDBDevInstId();
            }
            case 8: {
                return pSSystemDBCfgBase.getNo2PSDBDevInstName();
            }
            case 9: {
                return pSSystemDBCfgBase.getNo2PSDCDBInstId();
            }
            case 10: {
                return pSSystemDBCfgBase.getNo2PSDCDBInstName();
            }
            case 11: {
                return pSSystemDBCfgBase.getNoDBInstMode();
            }
            case 12: {
                return pSSystemDBCfgBase.getNullValOrder();
            }
            case 13: {
                return pSSystemDBCfgBase.getObjNameCase();
            }
            case 14: {
                return pSSystemDBCfgBase.getPSDBDevInstId();
            }
            case 15: {
                return pSSystemDBCfgBase.getPSDBDevInstName();
            }
            case 16: {
                return pSSystemDBCfgBase.getPSDevCenterDBInstId();
            }
            case 17: {
                return pSSystemDBCfgBase.getPSDevCenterDBInstName();
            }
            case 18: {
                return pSSystemDBCfgBase.getPSSystemDBCfgId();
            }
            case 19: {
                return pSSystemDBCfgBase.getPSSystemDBCfgName();
            }
            case 20: {
                return pSSystemDBCfgBase.getPSSystemId();
            }
            case 21: {
                return pSSystemDBCfgBase.getPSSystemName();
            }
            case 22: {
                return pSSystemDBCfgBase.getPubCommentFlag();
            }
            case 23: {
                return pSSystemDBCfgBase.getPubDBModelFlag();
            }
            case 24: {
                return pSSystemDBCfgBase.getPubFKeyFlag();
            }
            case 25: {
                return pSSystemDBCfgBase.getPubIndexFlag();
            }
            case 26: {
                return pSSystemDBCfgBase.getPubViewFlag();
            }
            case 27: {
                return pSSystemDBCfgBase.getResInfo();
            }
            case 28: {
                return pSSystemDBCfgBase.getResReadyTime();
            }
            case 29: {
                return pSSystemDBCfgBase.getResState();
            }
            case 30: {
                return pSSystemDBCfgBase.getTabSpace();
            }
            case 31: {
                return pSSystemDBCfgBase.getTabSpace2();
            }
            case 32: {
                return pSSystemDBCfgBase.getTabSpace3();
            }
            case 33: {
                return pSSystemDBCfgBase.getTabSpace4();
            }
            case 34: {
                return pSSystemDBCfgBase.getUpdateDate();
            }
            case 35: {
                return pSSystemDBCfgBase.getUpdateMan();
            }
            case 36: {
                return pSSystemDBCfgBase.getUserCat();
            }
            case 37: {
                return pSSystemDBCfgBase.getUserParams();
            }
            case 38: {
                return pSSystemDBCfgBase.getUserTag();
            }
            case 39: {
                return pSSystemDBCfgBase.getUserTag2();
            }
            case 40: {
                return pSSystemDBCfgBase.getUserTag3();
            }
            case 41: {
                return pSSystemDBCfgBase.getUserTag4();
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
        PSSystemDBCfgBase.set(this, n, object);
    }

    private static void set(PSSystemDBCfgBase pSSystemDBCfgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSystemDBCfgBase.setAppendSchema(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSystemDBCfgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSystemDBCfgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSystemDBCfgBase.setDBSchemaName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSystemDBCfgBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSystemDBCfgBase.setEnableWebTool(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSystemDBCfgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSystemDBCfgBase.setNo2PSDBDevInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSystemDBCfgBase.setNo2PSDBDevInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSystemDBCfgBase.setNo2PSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSystemDBCfgBase.setNo2PSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSystemDBCfgBase.setNoDBInstMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSystemDBCfgBase.setNullValOrder(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSystemDBCfgBase.setObjNameCase(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSystemDBCfgBase.setPSDBDevInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSystemDBCfgBase.setPSDBDevInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSystemDBCfgBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSystemDBCfgBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSystemDBCfgBase.setPSSystemDBCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSystemDBCfgBase.setPSSystemDBCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSystemDBCfgBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSystemDBCfgBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSystemDBCfgBase.setPubCommentFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSystemDBCfgBase.setPubDBModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSystemDBCfgBase.setPubFKeyFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSystemDBCfgBase.setPubIndexFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSystemDBCfgBase.setPubViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSystemDBCfgBase.setResInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSystemDBCfgBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSSystemDBCfgBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSystemDBCfgBase.setTabSpace(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSystemDBCfgBase.setTabSpace2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSystemDBCfgBase.setTabSpace3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSystemDBCfgBase.setTabSpace4(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSystemDBCfgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSSystemDBCfgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSystemDBCfgBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSystemDBCfgBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSystemDBCfgBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSystemDBCfgBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSystemDBCfgBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSystemDBCfgBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSystemDBCfgBase.isNull(this, n);
    }

    private static boolean isNull(PSSystemDBCfgBase pSSystemDBCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemDBCfgBase.getAppendSchema() == null;
            }
            case 1: {
                return pSSystemDBCfgBase.getCreateDate() == null;
            }
            case 2: {
                return pSSystemDBCfgBase.getCreateMan() == null;
            }
            case 3: {
                return pSSystemDBCfgBase.getDBSchemaName() == null;
            }
            case 4: {
                return pSSystemDBCfgBase.getDefaultFlag() == null;
            }
            case 5: {
                return pSSystemDBCfgBase.getEnableWebTool() == null;
            }
            case 6: {
                return pSSystemDBCfgBase.getMemo() == null;
            }
            case 7: {
                return pSSystemDBCfgBase.getNo2PSDBDevInstId() == null;
            }
            case 8: {
                return pSSystemDBCfgBase.getNo2PSDBDevInstName() == null;
            }
            case 9: {
                return pSSystemDBCfgBase.getNo2PSDCDBInstId() == null;
            }
            case 10: {
                return pSSystemDBCfgBase.getNo2PSDCDBInstName() == null;
            }
            case 11: {
                return pSSystemDBCfgBase.getNoDBInstMode() == null;
            }
            case 12: {
                return pSSystemDBCfgBase.getNullValOrder() == null;
            }
            case 13: {
                return pSSystemDBCfgBase.getObjNameCase() == null;
            }
            case 14: {
                return pSSystemDBCfgBase.getPSDBDevInstId() == null;
            }
            case 15: {
                return pSSystemDBCfgBase.getPSDBDevInstName() == null;
            }
            case 16: {
                return pSSystemDBCfgBase.getPSDevCenterDBInstId() == null;
            }
            case 17: {
                return pSSystemDBCfgBase.getPSDevCenterDBInstName() == null;
            }
            case 18: {
                return pSSystemDBCfgBase.getPSSystemDBCfgId() == null;
            }
            case 19: {
                return pSSystemDBCfgBase.getPSSystemDBCfgName() == null;
            }
            case 20: {
                return pSSystemDBCfgBase.getPSSystemId() == null;
            }
            case 21: {
                return pSSystemDBCfgBase.getPSSystemName() == null;
            }
            case 22: {
                return pSSystemDBCfgBase.getPubCommentFlag() == null;
            }
            case 23: {
                return pSSystemDBCfgBase.getPubDBModelFlag() == null;
            }
            case 24: {
                return pSSystemDBCfgBase.getPubFKeyFlag() == null;
            }
            case 25: {
                return pSSystemDBCfgBase.getPubIndexFlag() == null;
            }
            case 26: {
                return pSSystemDBCfgBase.getPubViewFlag() == null;
            }
            case 27: {
                return pSSystemDBCfgBase.getResInfo() == null;
            }
            case 28: {
                return pSSystemDBCfgBase.getResReadyTime() == null;
            }
            case 29: {
                return pSSystemDBCfgBase.getResState() == null;
            }
            case 30: {
                return pSSystemDBCfgBase.getTabSpace() == null;
            }
            case 31: {
                return pSSystemDBCfgBase.getTabSpace2() == null;
            }
            case 32: {
                return pSSystemDBCfgBase.getTabSpace3() == null;
            }
            case 33: {
                return pSSystemDBCfgBase.getTabSpace4() == null;
            }
            case 34: {
                return pSSystemDBCfgBase.getUpdateDate() == null;
            }
            case 35: {
                return pSSystemDBCfgBase.getUpdateMan() == null;
            }
            case 36: {
                return pSSystemDBCfgBase.getUserCat() == null;
            }
            case 37: {
                return pSSystemDBCfgBase.getUserParams() == null;
            }
            case 38: {
                return pSSystemDBCfgBase.getUserTag() == null;
            }
            case 39: {
                return pSSystemDBCfgBase.getUserTag2() == null;
            }
            case 40: {
                return pSSystemDBCfgBase.getUserTag3() == null;
            }
            case 41: {
                return pSSystemDBCfgBase.getUserTag4() == null;
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
        return PSSystemDBCfgBase.contains(this, n);
    }

    private static boolean contains(PSSystemDBCfgBase pSSystemDBCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemDBCfgBase.isAppendSchemaDirty();
            }
            case 1: {
                return pSSystemDBCfgBase.isCreateDateDirty();
            }
            case 2: {
                return pSSystemDBCfgBase.isCreateManDirty();
            }
            case 3: {
                return pSSystemDBCfgBase.isDBSchemaNameDirty();
            }
            case 4: {
                return pSSystemDBCfgBase.isDefaultFlagDirty();
            }
            case 5: {
                return pSSystemDBCfgBase.isEnableWebToolDirty();
            }
            case 6: {
                return pSSystemDBCfgBase.isMemoDirty();
            }
            case 7: {
                return pSSystemDBCfgBase.isNo2PSDBDevInstIdDirty();
            }
            case 8: {
                return pSSystemDBCfgBase.isNo2PSDBDevInstNameDirty();
            }
            case 9: {
                return pSSystemDBCfgBase.isNo2PSDCDBInstIdDirty();
            }
            case 10: {
                return pSSystemDBCfgBase.isNo2PSDCDBInstNameDirty();
            }
            case 11: {
                return pSSystemDBCfgBase.isNoDBInstModeDirty();
            }
            case 12: {
                return pSSystemDBCfgBase.isNullValOrderDirty();
            }
            case 13: {
                return pSSystemDBCfgBase.isObjNameCaseDirty();
            }
            case 14: {
                return pSSystemDBCfgBase.isPSDBDevInstIdDirty();
            }
            case 15: {
                return pSSystemDBCfgBase.isPSDBDevInstNameDirty();
            }
            case 16: {
                return pSSystemDBCfgBase.isPSDevCenterDBInstIdDirty();
            }
            case 17: {
                return pSSystemDBCfgBase.isPSDevCenterDBInstNameDirty();
            }
            case 18: {
                return pSSystemDBCfgBase.isPSSystemDBCfgIdDirty();
            }
            case 19: {
                return pSSystemDBCfgBase.isPSSystemDBCfgNameDirty();
            }
            case 20: {
                return pSSystemDBCfgBase.isPSSystemIdDirty();
            }
            case 21: {
                return pSSystemDBCfgBase.isPSSystemNameDirty();
            }
            case 22: {
                return pSSystemDBCfgBase.isPubCommentFlagDirty();
            }
            case 23: {
                return pSSystemDBCfgBase.isPubDBModelFlagDirty();
            }
            case 24: {
                return pSSystemDBCfgBase.isPubFKeyFlagDirty();
            }
            case 25: {
                return pSSystemDBCfgBase.isPubIndexFlagDirty();
            }
            case 26: {
                return pSSystemDBCfgBase.isPubViewFlagDirty();
            }
            case 27: {
                return pSSystemDBCfgBase.isResInfoDirty();
            }
            case 28: {
                return pSSystemDBCfgBase.isResReadyTimeDirty();
            }
            case 29: {
                return pSSystemDBCfgBase.isResStateDirty();
            }
            case 30: {
                return pSSystemDBCfgBase.isTabSpaceDirty();
            }
            case 31: {
                return pSSystemDBCfgBase.isTabSpace2Dirty();
            }
            case 32: {
                return pSSystemDBCfgBase.isTabSpace3Dirty();
            }
            case 33: {
                return pSSystemDBCfgBase.isTabSpace4Dirty();
            }
            case 34: {
                return pSSystemDBCfgBase.isUpdateDateDirty();
            }
            case 35: {
                return pSSystemDBCfgBase.isUpdateManDirty();
            }
            case 36: {
                return pSSystemDBCfgBase.isUserCatDirty();
            }
            case 37: {
                return pSSystemDBCfgBase.isUserParamsDirty();
            }
            case 38: {
                return pSSystemDBCfgBase.isUserTagDirty();
            }
            case 39: {
                return pSSystemDBCfgBase.isUserTag2Dirty();
            }
            case 40: {
                return pSSystemDBCfgBase.isUserTag3Dirty();
            }
            case 41: {
                return pSSystemDBCfgBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSystemDBCfgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSystemDBCfgBase pSSystemDBCfgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSystemDBCfgBase.getAppendSchema() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appendschema", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getAppendSchema()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getDBSchemaName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbschemaname", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getDBSchemaName()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getEnableWebTool() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablewebtool", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getEnableWebTool()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getMemo()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getNo2PSDBDevInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdbdevinstid", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getNo2PSDBDevInstId()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getNo2PSDBDevInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdbdevinstname", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getNo2PSDBDevInstName()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getNo2PSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdcdbinstid", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getNo2PSDCDBInstId()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getNo2PSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdcdbinstname", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getNo2PSDCDBInstName()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getNoDBInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodbinstmode", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getNoDBInstMode()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getNullValOrder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nullvalorder", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getNullValOrder()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getObjNameCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objnamecase", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getObjNameCase()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPSDBDevInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstid", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPSDBDevInstId()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPSDBDevInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstname", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPSDBDevInstName()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPSSystemDBCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgid", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPSSystemDBCfgId()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPSSystemDBCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgname", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPSSystemDBCfgName()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPubCommentFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubcommentflag", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPubCommentFlag()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPubDBModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubdbmodelflag", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPubDBModelFlag()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPubFKeyFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubfkeyflag", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPubFKeyFlag()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPubIndexFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubindexflag", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPubIndexFlag()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getPubViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubviewflag", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getPubViewFlag()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getResInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resinfo", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getResInfo()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getResState()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getTabSpace() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabspace", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getTabSpace()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getTabSpace2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabspace2", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getTabSpace2()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getTabSpace3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabspace3", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getTabSpace3()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getTabSpace4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabspace4", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getTabSpace4()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getUserParams()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSystemDBCfgBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSystemDBCfgBase.getJSONValue((Object)pSSystemDBCfgBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSystemDBCfgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSystemDBCfgBase pSSystemDBCfgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSystemDBCfgBase.getAppendSchema() != null) {
            object = pSSystemDBCfgBase.getAppendSchema();
            xmlNode.setAttribute(FIELD_APPENDSCHEMA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getCreateDate() != null) {
            object = pSSystemDBCfgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getCreateMan() != null) {
            object = pSSystemDBCfgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getDBSchemaName() != null) {
            object = pSSystemDBCfgBase.getDBSchemaName();
            xmlNode.setAttribute(FIELD_DBSCHEMANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getDefaultFlag() != null) {
            object = pSSystemDBCfgBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getEnableWebTool() != null) {
            object = pSSystemDBCfgBase.getEnableWebTool();
            xmlNode.setAttribute(FIELD_ENABLEWEBTOOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getMemo() != null) {
            object = pSSystemDBCfgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getNo2PSDBDevInstId() != null) {
            object = pSSystemDBCfgBase.getNo2PSDBDevInstId();
            xmlNode.setAttribute(FIELD_NO2PSDBDEVINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getNo2PSDBDevInstName() != null) {
            object = pSSystemDBCfgBase.getNo2PSDBDevInstName();
            xmlNode.setAttribute(FIELD_NO2PSDBDEVINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getNo2PSDCDBInstId() != null) {
            object = pSSystemDBCfgBase.getNo2PSDCDBInstId();
            xmlNode.setAttribute(FIELD_NO2PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getNo2PSDCDBInstName() != null) {
            object = pSSystemDBCfgBase.getNo2PSDCDBInstName();
            xmlNode.setAttribute(FIELD_NO2PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getNoDBInstMode() != null) {
            object = pSSystemDBCfgBase.getNoDBInstMode();
            xmlNode.setAttribute(FIELD_NODBINSTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getNullValOrder() != null) {
            object = pSSystemDBCfgBase.getNullValOrder();
            xmlNode.setAttribute(FIELD_NULLVALORDER, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getObjNameCase() != null) {
            object = pSSystemDBCfgBase.getObjNameCase();
            xmlNode.setAttribute(FIELD_OBJNAMECASE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPSDBDevInstId() != null) {
            object = pSSystemDBCfgBase.getPSDBDevInstId();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPSDBDevInstName() != null) {
            object = pSSystemDBCfgBase.getPSDBDevInstName();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPSDevCenterDBInstId() != null) {
            object = pSSystemDBCfgBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPSDevCenterDBInstName() != null) {
            object = pSSystemDBCfgBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPSSystemDBCfgId() != null) {
            object = pSSystemDBCfgBase.getPSSystemDBCfgId();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPSSystemDBCfgName() != null) {
            object = pSSystemDBCfgBase.getPSSystemDBCfgName();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPSSystemId() != null) {
            object = pSSystemDBCfgBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPSSystemName() != null) {
            object = pSSystemDBCfgBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getPubCommentFlag() != null) {
            object = pSSystemDBCfgBase.getPubCommentFlag();
            xmlNode.setAttribute(FIELD_PUBCOMMENTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getPubDBModelFlag() != null) {
            object = pSSystemDBCfgBase.getPubDBModelFlag();
            xmlNode.setAttribute(FIELD_PUBDBMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getPubFKeyFlag() != null) {
            object = pSSystemDBCfgBase.getPubFKeyFlag();
            xmlNode.setAttribute(FIELD_PUBFKEYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getPubIndexFlag() != null) {
            object = pSSystemDBCfgBase.getPubIndexFlag();
            xmlNode.setAttribute(FIELD_PUBINDEXFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getPubViewFlag() != null) {
            object = pSSystemDBCfgBase.getPubViewFlag();
            xmlNode.setAttribute(FIELD_PUBVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getResInfo() != null) {
            object = pSSystemDBCfgBase.getResInfo();
            xmlNode.setAttribute(FIELD_RESINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getResReadyTime() != null) {
            object = pSSystemDBCfgBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getResState() != null) {
            object = pSSystemDBCfgBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getTabSpace() != null) {
            object = pSSystemDBCfgBase.getTabSpace();
            xmlNode.setAttribute(FIELD_TABSPACE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getTabSpace2() != null) {
            object = pSSystemDBCfgBase.getTabSpace2();
            xmlNode.setAttribute(FIELD_TABSPACE2, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getTabSpace3() != null) {
            object = pSSystemDBCfgBase.getTabSpace3();
            xmlNode.setAttribute(FIELD_TABSPACE3, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getTabSpace4() != null) {
            object = pSSystemDBCfgBase.getTabSpace4();
            xmlNode.setAttribute(FIELD_TABSPACE4, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getUpdateDate() != null) {
            object = pSSystemDBCfgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemDBCfgBase.getUpdateMan() != null) {
            object = pSSystemDBCfgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getUserCat() != null) {
            object = pSSystemDBCfgBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getUserParams() != null) {
            object = pSSystemDBCfgBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getUserTag() != null) {
            object = pSSystemDBCfgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getUserTag2() != null) {
            object = pSSystemDBCfgBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getUserTag3() != null) {
            object = pSSystemDBCfgBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSystemDBCfgBase.getUserTag4() != null) {
            object = pSSystemDBCfgBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSystemDBCfgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSystemDBCfgBase pSSystemDBCfgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSystemDBCfgBase.isAppendSchemaDirty() && (bl || pSSystemDBCfgBase.getAppendSchema() != null)) {
            iDataObject.set(FIELD_APPENDSCHEMA, (Object)pSSystemDBCfgBase.getAppendSchema());
        }
        if (pSSystemDBCfgBase.isCreateDateDirty() && (bl || pSSystemDBCfgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSystemDBCfgBase.getCreateDate());
        }
        if (pSSystemDBCfgBase.isCreateManDirty() && (bl || pSSystemDBCfgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSystemDBCfgBase.getCreateMan());
        }
        if (pSSystemDBCfgBase.isDBSchemaNameDirty() && (bl || pSSystemDBCfgBase.getDBSchemaName() != null)) {
            iDataObject.set(FIELD_DBSCHEMANAME, (Object)pSSystemDBCfgBase.getDBSchemaName());
        }
        if (pSSystemDBCfgBase.isDefaultFlagDirty() && (bl || pSSystemDBCfgBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSystemDBCfgBase.getDefaultFlag());
        }
        if (pSSystemDBCfgBase.isEnableWebToolDirty() && (bl || pSSystemDBCfgBase.getEnableWebTool() != null)) {
            iDataObject.set(FIELD_ENABLEWEBTOOL, (Object)pSSystemDBCfgBase.getEnableWebTool());
        }
        if (pSSystemDBCfgBase.isMemoDirty() && (bl || pSSystemDBCfgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSystemDBCfgBase.getMemo());
        }
        if (pSSystemDBCfgBase.isNo2PSDBDevInstIdDirty() && (bl || pSSystemDBCfgBase.getNo2PSDBDevInstId() != null)) {
            iDataObject.set(FIELD_NO2PSDBDEVINSTID, (Object)pSSystemDBCfgBase.getNo2PSDBDevInstId());
        }
        if (pSSystemDBCfgBase.isNo2PSDBDevInstNameDirty() && (bl || pSSystemDBCfgBase.getNo2PSDBDevInstName() != null)) {
            iDataObject.set(FIELD_NO2PSDBDEVINSTNAME, (Object)pSSystemDBCfgBase.getNo2PSDBDevInstName());
        }
        if (pSSystemDBCfgBase.isNo2PSDCDBInstIdDirty() && (bl || pSSystemDBCfgBase.getNo2PSDCDBInstId() != null)) {
            iDataObject.set(FIELD_NO2PSDCDBINSTID, (Object)pSSystemDBCfgBase.getNo2PSDCDBInstId());
        }
        if (pSSystemDBCfgBase.isNo2PSDCDBInstNameDirty() && (bl || pSSystemDBCfgBase.getNo2PSDCDBInstName() != null)) {
            iDataObject.set(FIELD_NO2PSDCDBINSTNAME, (Object)pSSystemDBCfgBase.getNo2PSDCDBInstName());
        }
        if (pSSystemDBCfgBase.isNoDBInstModeDirty() && (bl || pSSystemDBCfgBase.getNoDBInstMode() != null)) {
            iDataObject.set(FIELD_NODBINSTMODE, (Object)pSSystemDBCfgBase.getNoDBInstMode());
        }
        if (pSSystemDBCfgBase.isNullValOrderDirty() && (bl || pSSystemDBCfgBase.getNullValOrder() != null)) {
            iDataObject.set(FIELD_NULLVALORDER, (Object)pSSystemDBCfgBase.getNullValOrder());
        }
        if (pSSystemDBCfgBase.isObjNameCaseDirty() && (bl || pSSystemDBCfgBase.getObjNameCase() != null)) {
            iDataObject.set(FIELD_OBJNAMECASE, (Object)pSSystemDBCfgBase.getObjNameCase());
        }
        if (pSSystemDBCfgBase.isPSDBDevInstIdDirty() && (bl || pSSystemDBCfgBase.getPSDBDevInstId() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTID, (Object)pSSystemDBCfgBase.getPSDBDevInstId());
        }
        if (pSSystemDBCfgBase.isPSDBDevInstNameDirty() && (bl || pSSystemDBCfgBase.getPSDBDevInstName() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTNAME, (Object)pSSystemDBCfgBase.getPSDBDevInstName());
        }
        if (pSSystemDBCfgBase.isPSDevCenterDBInstIdDirty() && (bl || pSSystemDBCfgBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSSystemDBCfgBase.getPSDevCenterDBInstId());
        }
        if (pSSystemDBCfgBase.isPSDevCenterDBInstNameDirty() && (bl || pSSystemDBCfgBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSSystemDBCfgBase.getPSDevCenterDBInstName());
        }
        if (pSSystemDBCfgBase.isPSSystemDBCfgIdDirty() && (bl || pSSystemDBCfgBase.getPSSystemDBCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGID, (Object)pSSystemDBCfgBase.getPSSystemDBCfgId());
        }
        if (pSSystemDBCfgBase.isPSSystemDBCfgNameDirty() && (bl || pSSystemDBCfgBase.getPSSystemDBCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGNAME, (Object)pSSystemDBCfgBase.getPSSystemDBCfgName());
        }
        if (pSSystemDBCfgBase.isPSSystemIdDirty() && (bl || pSSystemDBCfgBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSystemDBCfgBase.getPSSystemId());
        }
        if (pSSystemDBCfgBase.isPSSystemNameDirty() && (bl || pSSystemDBCfgBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSystemDBCfgBase.getPSSystemName());
        }
        if (pSSystemDBCfgBase.isPubCommentFlagDirty() && (bl || pSSystemDBCfgBase.getPubCommentFlag() != null)) {
            iDataObject.set(FIELD_PUBCOMMENTFLAG, (Object)pSSystemDBCfgBase.getPubCommentFlag());
        }
        if (pSSystemDBCfgBase.isPubDBModelFlagDirty() && (bl || pSSystemDBCfgBase.getPubDBModelFlag() != null)) {
            iDataObject.set(FIELD_PUBDBMODELFLAG, (Object)pSSystemDBCfgBase.getPubDBModelFlag());
        }
        if (pSSystemDBCfgBase.isPubFKeyFlagDirty() && (bl || pSSystemDBCfgBase.getPubFKeyFlag() != null)) {
            iDataObject.set(FIELD_PUBFKEYFLAG, (Object)pSSystemDBCfgBase.getPubFKeyFlag());
        }
        if (pSSystemDBCfgBase.isPubIndexFlagDirty() && (bl || pSSystemDBCfgBase.getPubIndexFlag() != null)) {
            iDataObject.set(FIELD_PUBINDEXFLAG, (Object)pSSystemDBCfgBase.getPubIndexFlag());
        }
        if (pSSystemDBCfgBase.isPubViewFlagDirty() && (bl || pSSystemDBCfgBase.getPubViewFlag() != null)) {
            iDataObject.set(FIELD_PUBVIEWFLAG, (Object)pSSystemDBCfgBase.getPubViewFlag());
        }
        if (pSSystemDBCfgBase.isResInfoDirty() && (bl || pSSystemDBCfgBase.getResInfo() != null)) {
            iDataObject.set(FIELD_RESINFO, (Object)pSSystemDBCfgBase.getResInfo());
        }
        if (pSSystemDBCfgBase.isResReadyTimeDirty() && (bl || pSSystemDBCfgBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSSystemDBCfgBase.getResReadyTime());
        }
        if (pSSystemDBCfgBase.isResStateDirty() && (bl || pSSystemDBCfgBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSSystemDBCfgBase.getResState());
        }
        if (pSSystemDBCfgBase.isTabSpaceDirty() && (bl || pSSystemDBCfgBase.getTabSpace() != null)) {
            iDataObject.set(FIELD_TABSPACE, (Object)pSSystemDBCfgBase.getTabSpace());
        }
        if (pSSystemDBCfgBase.isTabSpace2Dirty() && (bl || pSSystemDBCfgBase.getTabSpace2() != null)) {
            iDataObject.set(FIELD_TABSPACE2, (Object)pSSystemDBCfgBase.getTabSpace2());
        }
        if (pSSystemDBCfgBase.isTabSpace3Dirty() && (bl || pSSystemDBCfgBase.getTabSpace3() != null)) {
            iDataObject.set(FIELD_TABSPACE3, (Object)pSSystemDBCfgBase.getTabSpace3());
        }
        if (pSSystemDBCfgBase.isTabSpace4Dirty() && (bl || pSSystemDBCfgBase.getTabSpace4() != null)) {
            iDataObject.set(FIELD_TABSPACE4, (Object)pSSystemDBCfgBase.getTabSpace4());
        }
        if (pSSystemDBCfgBase.isUpdateDateDirty() && (bl || pSSystemDBCfgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSystemDBCfgBase.getUpdateDate());
        }
        if (pSSystemDBCfgBase.isUpdateManDirty() && (bl || pSSystemDBCfgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSystemDBCfgBase.getUpdateMan());
        }
        if (pSSystemDBCfgBase.isUserCatDirty() && (bl || pSSystemDBCfgBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSystemDBCfgBase.getUserCat());
        }
        if (pSSystemDBCfgBase.isUserParamsDirty() && (bl || pSSystemDBCfgBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSystemDBCfgBase.getUserParams());
        }
        if (pSSystemDBCfgBase.isUserTagDirty() && (bl || pSSystemDBCfgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSystemDBCfgBase.getUserTag());
        }
        if (pSSystemDBCfgBase.isUserTag2Dirty() && (bl || pSSystemDBCfgBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSystemDBCfgBase.getUserTag2());
        }
        if (pSSystemDBCfgBase.isUserTag3Dirty() && (bl || pSSystemDBCfgBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSystemDBCfgBase.getUserTag3());
        }
        if (pSSystemDBCfgBase.isUserTag4Dirty() && (bl || pSSystemDBCfgBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSystemDBCfgBase.getUserTag4());
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
        return PSSystemDBCfgBase.remove(this, n);
    }

    private static boolean remove(PSSystemDBCfgBase pSSystemDBCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSystemDBCfgBase.resetAppendSchema();
                return true;
            }
            case 1: {
                pSSystemDBCfgBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSystemDBCfgBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSystemDBCfgBase.resetDBSchemaName();
                return true;
            }
            case 4: {
                pSSystemDBCfgBase.resetDefaultFlag();
                return true;
            }
            case 5: {
                pSSystemDBCfgBase.resetEnableWebTool();
                return true;
            }
            case 6: {
                pSSystemDBCfgBase.resetMemo();
                return true;
            }
            case 7: {
                pSSystemDBCfgBase.resetNo2PSDBDevInstId();
                return true;
            }
            case 8: {
                pSSystemDBCfgBase.resetNo2PSDBDevInstName();
                return true;
            }
            case 9: {
                pSSystemDBCfgBase.resetNo2PSDCDBInstId();
                return true;
            }
            case 10: {
                pSSystemDBCfgBase.resetNo2PSDCDBInstName();
                return true;
            }
            case 11: {
                pSSystemDBCfgBase.resetNoDBInstMode();
                return true;
            }
            case 12: {
                pSSystemDBCfgBase.resetNullValOrder();
                return true;
            }
            case 13: {
                pSSystemDBCfgBase.resetObjNameCase();
                return true;
            }
            case 14: {
                pSSystemDBCfgBase.resetPSDBDevInstId();
                return true;
            }
            case 15: {
                pSSystemDBCfgBase.resetPSDBDevInstName();
                return true;
            }
            case 16: {
                pSSystemDBCfgBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 17: {
                pSSystemDBCfgBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 18: {
                pSSystemDBCfgBase.resetPSSystemDBCfgId();
                return true;
            }
            case 19: {
                pSSystemDBCfgBase.resetPSSystemDBCfgName();
                return true;
            }
            case 20: {
                pSSystemDBCfgBase.resetPSSystemId();
                return true;
            }
            case 21: {
                pSSystemDBCfgBase.resetPSSystemName();
                return true;
            }
            case 22: {
                pSSystemDBCfgBase.resetPubCommentFlag();
                return true;
            }
            case 23: {
                pSSystemDBCfgBase.resetPubDBModelFlag();
                return true;
            }
            case 24: {
                pSSystemDBCfgBase.resetPubFKeyFlag();
                return true;
            }
            case 25: {
                pSSystemDBCfgBase.resetPubIndexFlag();
                return true;
            }
            case 26: {
                pSSystemDBCfgBase.resetPubViewFlag();
                return true;
            }
            case 27: {
                pSSystemDBCfgBase.resetResInfo();
                return true;
            }
            case 28: {
                pSSystemDBCfgBase.resetResReadyTime();
                return true;
            }
            case 29: {
                pSSystemDBCfgBase.resetResState();
                return true;
            }
            case 30: {
                pSSystemDBCfgBase.resetTabSpace();
                return true;
            }
            case 31: {
                pSSystemDBCfgBase.resetTabSpace2();
                return true;
            }
            case 32: {
                pSSystemDBCfgBase.resetTabSpace3();
                return true;
            }
            case 33: {
                pSSystemDBCfgBase.resetTabSpace4();
                return true;
            }
            case 34: {
                pSSystemDBCfgBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSSystemDBCfgBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSSystemDBCfgBase.resetUserCat();
                return true;
            }
            case 37: {
                pSSystemDBCfgBase.resetUserParams();
                return true;
            }
            case 38: {
                pSSystemDBCfgBase.resetUserTag();
                return true;
            }
            case 39: {
                pSSystemDBCfgBase.resetUserTag2();
                return true;
            }
            case 40: {
                pSSystemDBCfgBase.resetUserTag3();
                return true;
            }
            case 41: {
                pSSystemDBCfgBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBDevInst getNo2PSDBDevInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDBDevInst();
        }
        if (this.getNo2PSDBDevInstId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDBDevInstLock;
        synchronized (n) {
            if (this.no2psdbdevinst != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDBDevInstId(), (Object)this.no2psdbdevinst.getPSDBDevInstId()) != 0L) {
                this.no2psdbdevinst = null;
            }
            if (this.no2psdbdevinst == null) {
                PSDBDevInst pSDBDevInst = new PSDBDevInst();
                pSDBDevInst.setPSDBDevInstId(this.getNo2PSDBDevInstId());
                PSDBDevInstService pSDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)this.getSessionFactory());
                pSDBDevInstService.autoGet(pSDBDevInst);
                this.no2psdbdevinst = pSDBDevInst;
            }
            return this.no2psdbdevinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBDevInst getPSDBDevInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInst();
        }
        if (this.getPSDBDevInstId() == null) {
            return null;
        }
        Integer n = this.objPSDBDevInstLock;
        synchronized (n) {
            if (this.psdbdevinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBDevInstId(), (Object)this.psdbdevinst.getPSDBDevInstId()) != 0L) {
                this.psdbdevinst = null;
            }
            if (this.psdbdevinst == null) {
                PSDBDevInst pSDBDevInst = new PSDBDevInst();
                pSDBDevInst.setPSDBDevInstId(this.getPSDBDevInstId());
                PSDBDevInstService pSDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)this.getSessionFactory());
                pSDBDevInstService.autoGet(pSDBDevInst);
                this.psdbdevinst = pSDBDevInst;
            }
            return this.psdbdevinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getNo2PSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDCDBInst();
        }
        if (this.getNo2PSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDCDBInstLock;
        synchronized (n) {
            if (this.no2psdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDCDBInstId(), (Object)this.no2psdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.no2psdcdbinst = null;
            }
            if (this.no2psdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getNo2PSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.no2psdcdbinst = pSDevCenterDBInst;
            }
            return this.no2psdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSystemDBCfgBase getProxyEntity() {
        return this.proxyPSSystemDBCfgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSystemDBCfgBase = null;
        if (iDataObject != null && iDataObject instanceof PSSystemDBCfgBase) {
            this.proxyPSSystemDBCfgBase = (PSSystemDBCfgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPENDSCHEMA, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DBSCHEMANAME, 3);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 4);
        fieldIndexMap.put(FIELD_ENABLEWEBTOOL, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_NO2PSDBDEVINSTID, 7);
        fieldIndexMap.put(FIELD_NO2PSDBDEVINSTNAME, 8);
        fieldIndexMap.put(FIELD_NO2PSDCDBINSTID, 9);
        fieldIndexMap.put(FIELD_NO2PSDCDBINSTNAME, 10);
        fieldIndexMap.put(FIELD_NODBINSTMODE, 11);
        fieldIndexMap.put(FIELD_NULLVALORDER, 12);
        fieldIndexMap.put(FIELD_OBJNAMECASE, 13);
        fieldIndexMap.put(FIELD_PSDBDEVINSTID, 14);
        fieldIndexMap.put(FIELD_PSDBDEVINSTNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGID, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 21);
        fieldIndexMap.put(FIELD_PUBCOMMENTFLAG, 22);
        fieldIndexMap.put(FIELD_PUBDBMODELFLAG, 23);
        fieldIndexMap.put(FIELD_PUBFKEYFLAG, 24);
        fieldIndexMap.put(FIELD_PUBINDEXFLAG, 25);
        fieldIndexMap.put(FIELD_PUBVIEWFLAG, 26);
        fieldIndexMap.put(FIELD_RESINFO, 27);
        fieldIndexMap.put(FIELD_RESREADYTIME, 28);
        fieldIndexMap.put(FIELD_RESSTATE, 29);
        fieldIndexMap.put(FIELD_TABSPACE, 30);
        fieldIndexMap.put(FIELD_TABSPACE2, 31);
        fieldIndexMap.put(FIELD_TABSPACE3, 32);
        fieldIndexMap.put(FIELD_TABSPACE4, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_USERCAT, 36);
        fieldIndexMap.put(FIELD_USERPARAMS, 37);
        fieldIndexMap.put(FIELD_USERTAG, 38);
        fieldIndexMap.put(FIELD_USERTAG2, 39);
        fieldIndexMap.put(FIELD_USERTAG3, 40);
        fieldIndexMap.put(FIELD_USERTAG4, 41);
    }
}

