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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDBCfgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDBCfgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXTABLENAME = "EXTABLENAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJNAMECASE = "OBJNAMECASE";
    public static final String FIELD_PSDEDBCFGID = "PSDEDBCFGID";
    public static final String FIELD_PSDEDBCFGNAME = "PSDEDBCFGNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PUBMODEL = "PUBMODEL";
    public static final String FIELD_TABLENAME = "TABLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWNAME = "VIEWNAME";
    public static final String FIELD_VIEWNAME2 = "VIEWNAME2";
    public static final String FIELD_VIEWNAME3 = "VIEWNAME3";
    public static final String FIELD_VIEWNAME4 = "VIEWNAME4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EXTABLENAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_OBJNAMECASE = 4;
    private static final int INDEX_PSDEDBCFGID = 5;
    private static final int INDEX_PSDEDBCFGNAME = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDENAME = 8;
    private static final int INDEX_PUBMODEL = 9;
    private static final int INDEX_TABLENAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERPARAMS = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final int INDEX_VIEWNAME = 20;
    private static final int INDEX_VIEWNAME2 = 21;
    private static final int INDEX_VIEWNAME3 = 22;
    private static final int INDEX_VIEWNAME4 = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDBCfgBase proxyPSDEDBCfgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean extablenameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objnamecaseDirtyFlag = false;
    private boolean psdedbcfgidDirtyFlag = false;
    private boolean psdedbcfgnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pubmodelDirtyFlag = false;
    private boolean tablenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewnameDirtyFlag = false;
    private boolean viewname2DirtyFlag = false;
    private boolean viewname3DirtyFlag = false;
    private boolean viewname4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="extablename")
    private String extablename;
    @Column(name="memo")
    private String memo;
    @Column(name="objnamecase")
    private String objnamecase;
    @Column(name="psdedbcfgid")
    private String psdedbcfgid;
    @Column(name="psdedbcfgname")
    private String psdedbcfgname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pubmodel")
    private Integer pubmodel;
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
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="viewname")
    private String viewname;
    @Column(name="viewname2")
    private String viewname2;
    @Column(name="viewname3")
    private String viewname3;
    @Column(name="viewname4")
    private String viewname4;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;

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

    public void setExTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extablename = string;
        this.extablenameDirtyFlag = true;
    }

    public String getExTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExTableName();
        }
        return this.extablename;
    }

    public boolean isExTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExTableNameDirty();
        }
        return this.extablenameDirtyFlag;
    }

    public void resetExTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExTableName();
            return;
        }
        this.extablenameDirtyFlag = false;
        this.extablename = null;
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

    public void setPSDEDBCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbcfgid = string;
        this.psdedbcfgidDirtyFlag = true;
    }

    public String getPSDEDBCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBCfgId();
        }
        return this.psdedbcfgid;
    }

    public boolean isPSDEDBCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBCfgIdDirty();
        }
        return this.psdedbcfgidDirtyFlag;
    }

    public void resetPSDEDBCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBCfgId();
            return;
        }
        this.psdedbcfgidDirtyFlag = false;
        this.psdedbcfgid = null;
    }

    public void setPSDEDBCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbcfgname = string;
        this.psdedbcfgnameDirtyFlag = true;
    }

    public String getPSDEDBCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBCfgName();
        }
        return this.psdedbcfgname;
    }

    public boolean isPSDEDBCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBCfgNameDirty();
        }
        return this.psdedbcfgnameDirtyFlag;
    }

    public void resetPSDEDBCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBCfgName();
            return;
        }
        this.psdedbcfgnameDirtyFlag = false;
        this.psdedbcfgname = null;
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

    public void setPubModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubModel(n);
            return;
        }
        this.pubmodel = n;
        this.pubmodelDirtyFlag = true;
    }

    public Integer getPubModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubModel();
        }
        return this.pubmodel;
    }

    public boolean isPubModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModelDirty();
        }
        return this.pubmodelDirtyFlag;
    }

    public void resetPubModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubModel();
            return;
        }
        this.pubmodelDirtyFlag = false;
        this.pubmodel = null;
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

    public void setViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewname = string;
        this.viewnameDirtyFlag = true;
    }

    public String getViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName();
        }
        return this.viewname;
    }

    public boolean isViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewNameDirty();
        }
        return this.viewnameDirtyFlag;
    }

    public void resetViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName();
            return;
        }
        this.viewnameDirtyFlag = false;
        this.viewname = null;
    }

    public void setViewName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewname2 = string;
        this.viewname2DirtyFlag = true;
    }

    public String getViewName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName2();
        }
        return this.viewname2;
    }

    public boolean isViewName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewName2Dirty();
        }
        return this.viewname2DirtyFlag;
    }

    public void resetViewName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName2();
            return;
        }
        this.viewname2DirtyFlag = false;
        this.viewname2 = null;
    }

    public void setViewName3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewname3 = string;
        this.viewname3DirtyFlag = true;
    }

    public String getViewName3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName3();
        }
        return this.viewname3;
    }

    public boolean isViewName3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewName3Dirty();
        }
        return this.viewname3DirtyFlag;
    }

    public void resetViewName3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName3();
            return;
        }
        this.viewname3DirtyFlag = false;
        this.viewname3 = null;
    }

    public void setViewName4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewName4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewname4 = string;
        this.viewname4DirtyFlag = true;
    }

    public String getViewName4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewName4();
        }
        return this.viewname4;
    }

    public boolean isViewName4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewName4Dirty();
        }
        return this.viewname4DirtyFlag;
    }

    public void resetViewName4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewName4();
            return;
        }
        this.viewname4DirtyFlag = false;
        this.viewname4 = null;
    }

    protected void onReset() {
        PSDEDBCfgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDBCfgBase pSDEDBCfgBase) {
        pSDEDBCfgBase.resetCreateDate();
        pSDEDBCfgBase.resetCreateMan();
        pSDEDBCfgBase.resetExTableName();
        pSDEDBCfgBase.resetMemo();
        pSDEDBCfgBase.resetObjNameCase();
        pSDEDBCfgBase.resetPSDEDBCfgId();
        pSDEDBCfgBase.resetPSDEDBCfgName();
        pSDEDBCfgBase.resetPSDEId();
        pSDEDBCfgBase.resetPSDEName();
        pSDEDBCfgBase.resetPubModel();
        pSDEDBCfgBase.resetTableName();
        pSDEDBCfgBase.resetUpdateDate();
        pSDEDBCfgBase.resetUpdateMan();
        pSDEDBCfgBase.resetUserCat();
        pSDEDBCfgBase.resetUserParams();
        pSDEDBCfgBase.resetUserTag();
        pSDEDBCfgBase.resetUserTag2();
        pSDEDBCfgBase.resetUserTag3();
        pSDEDBCfgBase.resetUserTag4();
        pSDEDBCfgBase.resetValidFlag();
        pSDEDBCfgBase.resetViewName();
        pSDEDBCfgBase.resetViewName2();
        pSDEDBCfgBase.resetViewName3();
        pSDEDBCfgBase.resetViewName4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExTableNameDirty()) {
            hashMap.put(FIELD_EXTABLENAME, this.getExTableName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isObjNameCaseDirty()) {
            hashMap.put(FIELD_OBJNAMECASE, this.getObjNameCase());
        }
        if (!bl || this.isPSDEDBCfgIdDirty()) {
            hashMap.put(FIELD_PSDEDBCFGID, this.getPSDEDBCfgId());
        }
        if (!bl || this.isPSDEDBCfgNameDirty()) {
            hashMap.put(FIELD_PSDEDBCFGNAME, this.getPSDEDBCfgName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPubModelDirty()) {
            hashMap.put(FIELD_PUBMODEL, this.getPubModel());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isViewNameDirty()) {
            hashMap.put(FIELD_VIEWNAME, this.getViewName());
        }
        if (!bl || this.isViewName2Dirty()) {
            hashMap.put(FIELD_VIEWNAME2, this.getViewName2());
        }
        if (!bl || this.isViewName3Dirty()) {
            hashMap.put(FIELD_VIEWNAME3, this.getViewName3());
        }
        if (!bl || this.isViewName4Dirty()) {
            hashMap.put(FIELD_VIEWNAME4, this.getViewName4());
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
        return PSDEDBCfgBase.get(this, n);
    }

    private static Object get(PSDEDBCfgBase pSDEDBCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBCfgBase.getCreateDate();
            }
            case 1: {
                return pSDEDBCfgBase.getCreateMan();
            }
            case 2: {
                return pSDEDBCfgBase.getExTableName();
            }
            case 3: {
                return pSDEDBCfgBase.getMemo();
            }
            case 4: {
                return pSDEDBCfgBase.getObjNameCase();
            }
            case 5: {
                return pSDEDBCfgBase.getPSDEDBCfgId();
            }
            case 6: {
                return pSDEDBCfgBase.getPSDEDBCfgName();
            }
            case 7: {
                return pSDEDBCfgBase.getPSDEId();
            }
            case 8: {
                return pSDEDBCfgBase.getPSDEName();
            }
            case 9: {
                return pSDEDBCfgBase.getPubModel();
            }
            case 10: {
                return pSDEDBCfgBase.getTableName();
            }
            case 11: {
                return pSDEDBCfgBase.getUpdateDate();
            }
            case 12: {
                return pSDEDBCfgBase.getUpdateMan();
            }
            case 13: {
                return pSDEDBCfgBase.getUserCat();
            }
            case 14: {
                return pSDEDBCfgBase.getUserParams();
            }
            case 15: {
                return pSDEDBCfgBase.getUserTag();
            }
            case 16: {
                return pSDEDBCfgBase.getUserTag2();
            }
            case 17: {
                return pSDEDBCfgBase.getUserTag3();
            }
            case 18: {
                return pSDEDBCfgBase.getUserTag4();
            }
            case 19: {
                return pSDEDBCfgBase.getValidFlag();
            }
            case 20: {
                return pSDEDBCfgBase.getViewName();
            }
            case 21: {
                return pSDEDBCfgBase.getViewName2();
            }
            case 22: {
                return pSDEDBCfgBase.getViewName3();
            }
            case 23: {
                return pSDEDBCfgBase.getViewName4();
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
        PSDEDBCfgBase.set(this, n, object);
    }

    private static void set(PSDEDBCfgBase pSDEDBCfgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDBCfgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDBCfgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDBCfgBase.setExTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDBCfgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDBCfgBase.setObjNameCase(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDBCfgBase.setPSDEDBCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDBCfgBase.setPSDEDBCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDBCfgBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDBCfgBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDBCfgBase.setPubModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEDBCfgBase.setTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDBCfgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDEDBCfgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDBCfgBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDBCfgBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDBCfgBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDBCfgBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDBCfgBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDBCfgBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDBCfgBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEDBCfgBase.setViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDBCfgBase.setViewName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDBCfgBase.setViewName3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDBCfgBase.setViewName4(DataObject.getStringValue((Object)object));
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
        return PSDEDBCfgBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDBCfgBase pSDEDBCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBCfgBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDBCfgBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDBCfgBase.getExTableName() == null;
            }
            case 3: {
                return pSDEDBCfgBase.getMemo() == null;
            }
            case 4: {
                return pSDEDBCfgBase.getObjNameCase() == null;
            }
            case 5: {
                return pSDEDBCfgBase.getPSDEDBCfgId() == null;
            }
            case 6: {
                return pSDEDBCfgBase.getPSDEDBCfgName() == null;
            }
            case 7: {
                return pSDEDBCfgBase.getPSDEId() == null;
            }
            case 8: {
                return pSDEDBCfgBase.getPSDEName() == null;
            }
            case 9: {
                return pSDEDBCfgBase.getPubModel() == null;
            }
            case 10: {
                return pSDEDBCfgBase.getTableName() == null;
            }
            case 11: {
                return pSDEDBCfgBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDEDBCfgBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDEDBCfgBase.getUserCat() == null;
            }
            case 14: {
                return pSDEDBCfgBase.getUserParams() == null;
            }
            case 15: {
                return pSDEDBCfgBase.getUserTag() == null;
            }
            case 16: {
                return pSDEDBCfgBase.getUserTag2() == null;
            }
            case 17: {
                return pSDEDBCfgBase.getUserTag3() == null;
            }
            case 18: {
                return pSDEDBCfgBase.getUserTag4() == null;
            }
            case 19: {
                return pSDEDBCfgBase.getValidFlag() == null;
            }
            case 20: {
                return pSDEDBCfgBase.getViewName() == null;
            }
            case 21: {
                return pSDEDBCfgBase.getViewName2() == null;
            }
            case 22: {
                return pSDEDBCfgBase.getViewName3() == null;
            }
            case 23: {
                return pSDEDBCfgBase.getViewName4() == null;
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
        return PSDEDBCfgBase.contains(this, n);
    }

    private static boolean contains(PSDEDBCfgBase pSDEDBCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBCfgBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDBCfgBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDBCfgBase.isExTableNameDirty();
            }
            case 3: {
                return pSDEDBCfgBase.isMemoDirty();
            }
            case 4: {
                return pSDEDBCfgBase.isObjNameCaseDirty();
            }
            case 5: {
                return pSDEDBCfgBase.isPSDEDBCfgIdDirty();
            }
            case 6: {
                return pSDEDBCfgBase.isPSDEDBCfgNameDirty();
            }
            case 7: {
                return pSDEDBCfgBase.isPSDEIdDirty();
            }
            case 8: {
                return pSDEDBCfgBase.isPSDENameDirty();
            }
            case 9: {
                return pSDEDBCfgBase.isPubModelDirty();
            }
            case 10: {
                return pSDEDBCfgBase.isTableNameDirty();
            }
            case 11: {
                return pSDEDBCfgBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDEDBCfgBase.isUpdateManDirty();
            }
            case 13: {
                return pSDEDBCfgBase.isUserCatDirty();
            }
            case 14: {
                return pSDEDBCfgBase.isUserParamsDirty();
            }
            case 15: {
                return pSDEDBCfgBase.isUserTagDirty();
            }
            case 16: {
                return pSDEDBCfgBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDEDBCfgBase.isUserTag3Dirty();
            }
            case 18: {
                return pSDEDBCfgBase.isUserTag4Dirty();
            }
            case 19: {
                return pSDEDBCfgBase.isValidFlagDirty();
            }
            case 20: {
                return pSDEDBCfgBase.isViewNameDirty();
            }
            case 21: {
                return pSDEDBCfgBase.isViewName2Dirty();
            }
            case 22: {
                return pSDEDBCfgBase.isViewName3Dirty();
            }
            case 23: {
                return pSDEDBCfgBase.isViewName4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDBCfgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDBCfgBase pSDEDBCfgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDBCfgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getExTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extablename", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getExTableName()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getObjNameCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objnamecase", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getObjNameCase()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getPSDEDBCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbcfgid", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getPSDEDBCfgId()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getPSDEDBCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbcfgname", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getPSDEDBCfgName()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getPubModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmodel", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getPubModel()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tablename", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getTableName()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewname", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getViewName()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getViewName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewname2", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getViewName2()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getViewName3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewname3", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getViewName3()), (boolean)false);
        }
        if (bl || pSDEDBCfgBase.getViewName4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewname4", (Object)PSDEDBCfgBase.getJSONValue((Object)pSDEDBCfgBase.getViewName4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDBCfgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDBCfgBase pSDEDBCfgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDBCfgBase.getCreateDate() != null) {
            object = pSDEDBCfgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDBCfgBase.getCreateMan() != null) {
            object = pSDEDBCfgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getExTableName() != null) {
            object = pSDEDBCfgBase.getExTableName();
            xmlNode.setAttribute(FIELD_EXTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getMemo() != null) {
            object = pSDEDBCfgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getObjNameCase() != null) {
            object = pSDEDBCfgBase.getObjNameCase();
            xmlNode.setAttribute(FIELD_OBJNAMECASE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getPSDEDBCfgId() != null) {
            object = pSDEDBCfgBase.getPSDEDBCfgId();
            xmlNode.setAttribute(FIELD_PSDEDBCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getPSDEDBCfgName() != null) {
            object = pSDEDBCfgBase.getPSDEDBCfgName();
            xmlNode.setAttribute(FIELD_PSDEDBCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getPSDEId() != null) {
            object = pSDEDBCfgBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getPSDEName() != null) {
            object = pSDEDBCfgBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getPubModel() != null) {
            object = pSDEDBCfgBase.getPubModel();
            xmlNode.setAttribute(FIELD_PUBMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDBCfgBase.getTableName() != null) {
            object = pSDEDBCfgBase.getTableName();
            xmlNode.setAttribute(FIELD_TABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getUpdateDate() != null) {
            object = pSDEDBCfgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDBCfgBase.getUpdateMan() != null) {
            object = pSDEDBCfgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getUserCat() != null) {
            object = pSDEDBCfgBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getUserParams() != null) {
            object = pSDEDBCfgBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getUserTag() != null) {
            object = pSDEDBCfgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getUserTag2() != null) {
            object = pSDEDBCfgBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getUserTag3() != null) {
            object = pSDEDBCfgBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getUserTag4() != null) {
            object = pSDEDBCfgBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getValidFlag() != null) {
            object = pSDEDBCfgBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDBCfgBase.getViewName() != null) {
            object = pSDEDBCfgBase.getViewName();
            xmlNode.setAttribute(FIELD_VIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getViewName2() != null) {
            object = pSDEDBCfgBase.getViewName2();
            xmlNode.setAttribute(FIELD_VIEWNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getViewName3() != null) {
            object = pSDEDBCfgBase.getViewName3();
            xmlNode.setAttribute(FIELD_VIEWNAME3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBCfgBase.getViewName4() != null) {
            object = pSDEDBCfgBase.getViewName4();
            xmlNode.setAttribute(FIELD_VIEWNAME4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDBCfgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDBCfgBase pSDEDBCfgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDBCfgBase.isCreateDateDirty() && (bl || pSDEDBCfgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDBCfgBase.getCreateDate());
        }
        if (pSDEDBCfgBase.isCreateManDirty() && (bl || pSDEDBCfgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDBCfgBase.getCreateMan());
        }
        if (pSDEDBCfgBase.isExTableNameDirty() && (bl || pSDEDBCfgBase.getExTableName() != null)) {
            iDataObject.set(FIELD_EXTABLENAME, (Object)pSDEDBCfgBase.getExTableName());
        }
        if (pSDEDBCfgBase.isMemoDirty() && (bl || pSDEDBCfgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDBCfgBase.getMemo());
        }
        if (pSDEDBCfgBase.isObjNameCaseDirty() && (bl || pSDEDBCfgBase.getObjNameCase() != null)) {
            iDataObject.set(FIELD_OBJNAMECASE, (Object)pSDEDBCfgBase.getObjNameCase());
        }
        if (pSDEDBCfgBase.isPSDEDBCfgIdDirty() && (bl || pSDEDBCfgBase.getPSDEDBCfgId() != null)) {
            iDataObject.set(FIELD_PSDEDBCFGID, (Object)pSDEDBCfgBase.getPSDEDBCfgId());
        }
        if (pSDEDBCfgBase.isPSDEDBCfgNameDirty() && (bl || pSDEDBCfgBase.getPSDEDBCfgName() != null)) {
            iDataObject.set(FIELD_PSDEDBCFGNAME, (Object)pSDEDBCfgBase.getPSDEDBCfgName());
        }
        if (pSDEDBCfgBase.isPSDEIdDirty() && (bl || pSDEDBCfgBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDBCfgBase.getPSDEId());
        }
        if (pSDEDBCfgBase.isPSDENameDirty() && (bl || pSDEDBCfgBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDBCfgBase.getPSDEName());
        }
        if (pSDEDBCfgBase.isPubModelDirty() && (bl || pSDEDBCfgBase.getPubModel() != null)) {
            iDataObject.set(FIELD_PUBMODEL, (Object)pSDEDBCfgBase.getPubModel());
        }
        if (pSDEDBCfgBase.isTableNameDirty() && (bl || pSDEDBCfgBase.getTableName() != null)) {
            iDataObject.set(FIELD_TABLENAME, (Object)pSDEDBCfgBase.getTableName());
        }
        if (pSDEDBCfgBase.isUpdateDateDirty() && (bl || pSDEDBCfgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDBCfgBase.getUpdateDate());
        }
        if (pSDEDBCfgBase.isUpdateManDirty() && (bl || pSDEDBCfgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDBCfgBase.getUpdateMan());
        }
        if (pSDEDBCfgBase.isUserCatDirty() && (bl || pSDEDBCfgBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDBCfgBase.getUserCat());
        }
        if (pSDEDBCfgBase.isUserParamsDirty() && (bl || pSDEDBCfgBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEDBCfgBase.getUserParams());
        }
        if (pSDEDBCfgBase.isUserTagDirty() && (bl || pSDEDBCfgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDBCfgBase.getUserTag());
        }
        if (pSDEDBCfgBase.isUserTag2Dirty() && (bl || pSDEDBCfgBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDBCfgBase.getUserTag2());
        }
        if (pSDEDBCfgBase.isUserTag3Dirty() && (bl || pSDEDBCfgBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDBCfgBase.getUserTag3());
        }
        if (pSDEDBCfgBase.isUserTag4Dirty() && (bl || pSDEDBCfgBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDBCfgBase.getUserTag4());
        }
        if (pSDEDBCfgBase.isValidFlagDirty() && (bl || pSDEDBCfgBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDBCfgBase.getValidFlag());
        }
        if (pSDEDBCfgBase.isViewNameDirty() && (bl || pSDEDBCfgBase.getViewName() != null)) {
            iDataObject.set(FIELD_VIEWNAME, (Object)pSDEDBCfgBase.getViewName());
        }
        if (pSDEDBCfgBase.isViewName2Dirty() && (bl || pSDEDBCfgBase.getViewName2() != null)) {
            iDataObject.set(FIELD_VIEWNAME2, (Object)pSDEDBCfgBase.getViewName2());
        }
        if (pSDEDBCfgBase.isViewName3Dirty() && (bl || pSDEDBCfgBase.getViewName3() != null)) {
            iDataObject.set(FIELD_VIEWNAME3, (Object)pSDEDBCfgBase.getViewName3());
        }
        if (pSDEDBCfgBase.isViewName4Dirty() && (bl || pSDEDBCfgBase.getViewName4() != null)) {
            iDataObject.set(FIELD_VIEWNAME4, (Object)pSDEDBCfgBase.getViewName4());
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
        return PSDEDBCfgBase.remove(this, n);
    }

    private static boolean remove(PSDEDBCfgBase pSDEDBCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDBCfgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDBCfgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDBCfgBase.resetExTableName();
                return true;
            }
            case 3: {
                pSDEDBCfgBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEDBCfgBase.resetObjNameCase();
                return true;
            }
            case 5: {
                pSDEDBCfgBase.resetPSDEDBCfgId();
                return true;
            }
            case 6: {
                pSDEDBCfgBase.resetPSDEDBCfgName();
                return true;
            }
            case 7: {
                pSDEDBCfgBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSDEDBCfgBase.resetPSDEName();
                return true;
            }
            case 9: {
                pSDEDBCfgBase.resetPubModel();
                return true;
            }
            case 10: {
                pSDEDBCfgBase.resetTableName();
                return true;
            }
            case 11: {
                pSDEDBCfgBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDEDBCfgBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDEDBCfgBase.resetUserCat();
                return true;
            }
            case 14: {
                pSDEDBCfgBase.resetUserParams();
                return true;
            }
            case 15: {
                pSDEDBCfgBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDEDBCfgBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDEDBCfgBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSDEDBCfgBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSDEDBCfgBase.resetValidFlag();
                return true;
            }
            case 20: {
                pSDEDBCfgBase.resetViewName();
                return true;
            }
            case 21: {
                pSDEDBCfgBase.resetViewName2();
                return true;
            }
            case 22: {
                pSDEDBCfgBase.resetViewName3();
                return true;
            }
            case 23: {
                pSDEDBCfgBase.resetViewName4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    private PSDEDBCfgBase getProxyEntity() {
        return this.proxyPSDEDBCfgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDBCfgBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDBCfgBase) {
            this.proxyPSDEDBCfgBase = (PSDEDBCfgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDBCfgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EXTABLENAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_OBJNAMECASE, 4);
        fieldIndexMap.put(FIELD_PSDEDBCFGID, 5);
        fieldIndexMap.put(FIELD_PSDEDBCFGNAME, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDENAME, 8);
        fieldIndexMap.put(FIELD_PUBMODEL, 9);
        fieldIndexMap.put(FIELD_TABLENAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERPARAMS, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
        fieldIndexMap.put(FIELD_VIEWNAME, 20);
        fieldIndexMap.put(FIELD_VIEWNAME2, 21);
        fieldIndexMap.put(FIELD_VIEWNAME3, 22);
        fieldIndexMap.put(FIELD_VIEWNAME4, 23);
    }
}

