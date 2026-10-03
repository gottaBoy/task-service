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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmd;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSQLCmdSQLBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSQLCmdSQLBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSSQLCMDID = "PSSYSSQLCMDID";
    public static final String FIELD_PSSYSSQLCMDNAME = "PSSYSSQLCMDNAME";
    public static final String FIELD_PSSYSSQLCMDSQLID = "PSSYSSQLCMDSQLID";
    public static final String FIELD_PSSYSSQLCMDSQLNAME = "PSSYSSQLCMDSQLNAME";
    public static final String FIELD_SQLCODE = "SQLCODE";
    public static final String FIELD_SQLCODE2 = "SQLCODE2";
    public static final String FIELD_SQLPARAMS = "SQLPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSSQLCMDID = 3;
    private static final int INDEX_PSSYSSQLCMDNAME = 4;
    private static final int INDEX_PSSYSSQLCMDSQLID = 5;
    private static final int INDEX_PSSYSSQLCMDSQLNAME = 6;
    private static final int INDEX_SQLCODE = 7;
    private static final int INDEX_SQLCODE2 = 8;
    private static final int INDEX_SQLPARAMS = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSQLCmdSQLBase proxyPSSysSQLCmdSQLBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssyssqlcmdidDirtyFlag = false;
    private boolean pssyssqlcmdnameDirtyFlag = false;
    private boolean pssyssqlcmdsqlidDirtyFlag = false;
    private boolean pssyssqlcmdsqlnameDirtyFlag = false;
    private boolean sqlcodeDirtyFlag = false;
    private boolean sqlcode2DirtyFlag = false;
    private boolean sqlparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssyssqlcmdid")
    private String pssyssqlcmdid;
    @Column(name="pssyssqlcmdname")
    private String pssyssqlcmdname;
    @Column(name="pssyssqlcmdsqlid")
    private String pssyssqlcmdsqlid;
    @Column(name="pssyssqlcmdsqlname")
    private String pssyssqlcmdsqlname;
    @Column(name="sqlcode")
    private String sqlcode;
    @Column(name="sqlcode2")
    private String sqlcode2;
    @Column(name="sqlparams")
    private String sqlparams;
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
    private Integer objPSSysSqlCmdLock = new Integer(1);
    private PSSysSQLCmd pssyssqlcmd = null;

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

    public void setPSSysSQLCmdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSQLCmdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssqlcmdid = string;
        this.pssyssqlcmdidDirtyFlag = true;
    }

    public String getPSSysSQLCmdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSQLCmdId();
        }
        return this.pssyssqlcmdid;
    }

    public boolean isPSSysSQLCmdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSQLCmdIdDirty();
        }
        return this.pssyssqlcmdidDirtyFlag;
    }

    public void resetPSSysSQLCmdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSQLCmdId();
            return;
        }
        this.pssyssqlcmdidDirtyFlag = false;
        this.pssyssqlcmdid = null;
    }

    public void setPSSysSQLCmdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSQLCmdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssqlcmdname = string;
        this.pssyssqlcmdnameDirtyFlag = true;
    }

    public String getPSSysSQLCmdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSQLCmdName();
        }
        return this.pssyssqlcmdname;
    }

    public boolean isPSSysSQLCmdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSQLCmdNameDirty();
        }
        return this.pssyssqlcmdnameDirtyFlag;
    }

    public void resetPSSysSQLCmdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSQLCmdName();
            return;
        }
        this.pssyssqlcmdnameDirtyFlag = false;
        this.pssyssqlcmdname = null;
    }

    public void setPSSysSQLCmdSQLId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSQLCmdSQLId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssqlcmdsqlid = string;
        this.pssyssqlcmdsqlidDirtyFlag = true;
    }

    public String getPSSysSQLCmdSQLId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSQLCmdSQLId();
        }
        return this.pssyssqlcmdsqlid;
    }

    public boolean isPSSysSQLCmdSQLIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSQLCmdSQLIdDirty();
        }
        return this.pssyssqlcmdsqlidDirtyFlag;
    }

    public void resetPSSysSQLCmdSQLId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSQLCmdSQLId();
            return;
        }
        this.pssyssqlcmdsqlidDirtyFlag = false;
        this.pssyssqlcmdsqlid = null;
    }

    public void setPSSysSQLCmdSQLName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSQLCmdSQLName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssqlcmdsqlname = string;
        this.pssyssqlcmdsqlnameDirtyFlag = true;
    }

    public String getPSSysSQLCmdSQLName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSQLCmdSQLName();
        }
        return this.pssyssqlcmdsqlname;
    }

    public boolean isPSSysSQLCmdSQLNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSQLCmdSQLNameDirty();
        }
        return this.pssyssqlcmdsqlnameDirtyFlag;
    }

    public void resetPSSysSQLCmdSQLName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSQLCmdSQLName();
            return;
        }
        this.pssyssqlcmdsqlnameDirtyFlag = false;
        this.pssyssqlcmdsqlname = null;
    }

    public void setSQLCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSQLCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sqlcode = string;
        this.sqlcodeDirtyFlag = true;
    }

    public String getSQLCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSQLCode();
        }
        return this.sqlcode;
    }

    public boolean isSQLCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSQLCodeDirty();
        }
        return this.sqlcodeDirtyFlag;
    }

    public void resetSQLCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSQLCode();
            return;
        }
        this.sqlcodeDirtyFlag = false;
        this.sqlcode = null;
    }

    public void setSqlCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSqlCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sqlcode2 = string;
        this.sqlcode2DirtyFlag = true;
    }

    public String getSqlCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSqlCode2();
        }
        return this.sqlcode2;
    }

    public boolean isSqlCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSqlCode2Dirty();
        }
        return this.sqlcode2DirtyFlag;
    }

    public void resetSqlCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSqlCode2();
            return;
        }
        this.sqlcode2DirtyFlag = false;
        this.sqlcode2 = null;
    }

    public void setSQLParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSQLParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sqlparams = string;
        this.sqlparamsDirtyFlag = true;
    }

    public String getSQLParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSQLParams();
        }
        return this.sqlparams;
    }

    public boolean isSQLParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSQLParamsDirty();
        }
        return this.sqlparamsDirtyFlag;
    }

    public void resetSQLParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSQLParams();
            return;
        }
        this.sqlparamsDirtyFlag = false;
        this.sqlparams = null;
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
        PSSysSQLCmdSQLBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase) {
        pSSysSQLCmdSQLBase.resetCreateDate();
        pSSysSQLCmdSQLBase.resetCreateMan();
        pSSysSQLCmdSQLBase.resetMemo();
        pSSysSQLCmdSQLBase.resetPSSysSQLCmdId();
        pSSysSQLCmdSQLBase.resetPSSysSQLCmdName();
        pSSysSQLCmdSQLBase.resetPSSysSQLCmdSQLId();
        pSSysSQLCmdSQLBase.resetPSSysSQLCmdSQLName();
        pSSysSQLCmdSQLBase.resetSQLCode();
        pSSysSQLCmdSQLBase.resetSqlCode2();
        pSSysSQLCmdSQLBase.resetSQLParams();
        pSSysSQLCmdSQLBase.resetUpdateDate();
        pSSysSQLCmdSQLBase.resetUpdateMan();
        pSSysSQLCmdSQLBase.resetUserCat();
        pSSysSQLCmdSQLBase.resetUserTag();
        pSSysSQLCmdSQLBase.resetUserTag2();
        pSSysSQLCmdSQLBase.resetUserTag3();
        pSSysSQLCmdSQLBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysSQLCmdIdDirty()) {
            hashMap.put(FIELD_PSSYSSQLCMDID, this.getPSSysSQLCmdId());
        }
        if (!bl || this.isPSSysSQLCmdNameDirty()) {
            hashMap.put(FIELD_PSSYSSQLCMDNAME, this.getPSSysSQLCmdName());
        }
        if (!bl || this.isPSSysSQLCmdSQLIdDirty()) {
            hashMap.put(FIELD_PSSYSSQLCMDSQLID, this.getPSSysSQLCmdSQLId());
        }
        if (!bl || this.isPSSysSQLCmdSQLNameDirty()) {
            hashMap.put(FIELD_PSSYSSQLCMDSQLNAME, this.getPSSysSQLCmdSQLName());
        }
        if (!bl || this.isSQLCodeDirty()) {
            hashMap.put(FIELD_SQLCODE, this.getSQLCode());
        }
        if (!bl || this.isSqlCode2Dirty()) {
            hashMap.put(FIELD_SQLCODE2, this.getSqlCode2());
        }
        if (!bl || this.isSQLParamsDirty()) {
            hashMap.put(FIELD_SQLPARAMS, this.getSQLParams());
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
        return PSSysSQLCmdSQLBase.get(this, n);
    }

    private static Object get(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSQLCmdSQLBase.getCreateDate();
            }
            case 1: {
                return pSSysSQLCmdSQLBase.getCreateMan();
            }
            case 2: {
                return pSSysSQLCmdSQLBase.getMemo();
            }
            case 3: {
                return pSSysSQLCmdSQLBase.getPSSysSQLCmdId();
            }
            case 4: {
                return pSSysSQLCmdSQLBase.getPSSysSQLCmdName();
            }
            case 5: {
                return pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLId();
            }
            case 6: {
                return pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLName();
            }
            case 7: {
                return pSSysSQLCmdSQLBase.getSQLCode();
            }
            case 8: {
                return pSSysSQLCmdSQLBase.getSqlCode2();
            }
            case 9: {
                return pSSysSQLCmdSQLBase.getSQLParams();
            }
            case 10: {
                return pSSysSQLCmdSQLBase.getUpdateDate();
            }
            case 11: {
                return pSSysSQLCmdSQLBase.getUpdateMan();
            }
            case 12: {
                return pSSysSQLCmdSQLBase.getUserCat();
            }
            case 13: {
                return pSSysSQLCmdSQLBase.getUserTag();
            }
            case 14: {
                return pSSysSQLCmdSQLBase.getUserTag2();
            }
            case 15: {
                return pSSysSQLCmdSQLBase.getUserTag3();
            }
            case 16: {
                return pSSysSQLCmdSQLBase.getUserTag4();
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
        PSSysSQLCmdSQLBase.set(this, n, object);
    }

    private static void set(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSQLCmdSQLBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysSQLCmdSQLBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSQLCmdSQLBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSQLCmdSQLBase.setPSSysSQLCmdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSQLCmdSQLBase.setPSSysSQLCmdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSQLCmdSQLBase.setPSSysSQLCmdSQLId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSQLCmdSQLBase.setPSSysSQLCmdSQLName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSQLCmdSQLBase.setSQLCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSQLCmdSQLBase.setSqlCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSQLCmdSQLBase.setSQLParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSQLCmdSQLBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysSQLCmdSQLBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSQLCmdSQLBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSQLCmdSQLBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSQLCmdSQLBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSQLCmdSQLBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSQLCmdSQLBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysSQLCmdSQLBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSQLCmdSQLBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysSQLCmdSQLBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysSQLCmdSQLBase.getMemo() == null;
            }
            case 3: {
                return pSSysSQLCmdSQLBase.getPSSysSQLCmdId() == null;
            }
            case 4: {
                return pSSysSQLCmdSQLBase.getPSSysSQLCmdName() == null;
            }
            case 5: {
                return pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLId() == null;
            }
            case 6: {
                return pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLName() == null;
            }
            case 7: {
                return pSSysSQLCmdSQLBase.getSQLCode() == null;
            }
            case 8: {
                return pSSysSQLCmdSQLBase.getSqlCode2() == null;
            }
            case 9: {
                return pSSysSQLCmdSQLBase.getSQLParams() == null;
            }
            case 10: {
                return pSSysSQLCmdSQLBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysSQLCmdSQLBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysSQLCmdSQLBase.getUserCat() == null;
            }
            case 13: {
                return pSSysSQLCmdSQLBase.getUserTag() == null;
            }
            case 14: {
                return pSSysSQLCmdSQLBase.getUserTag2() == null;
            }
            case 15: {
                return pSSysSQLCmdSQLBase.getUserTag3() == null;
            }
            case 16: {
                return pSSysSQLCmdSQLBase.getUserTag4() == null;
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
        return PSSysSQLCmdSQLBase.contains(this, n);
    }

    private static boolean contains(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSQLCmdSQLBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysSQLCmdSQLBase.isCreateManDirty();
            }
            case 2: {
                return pSSysSQLCmdSQLBase.isMemoDirty();
            }
            case 3: {
                return pSSysSQLCmdSQLBase.isPSSysSQLCmdIdDirty();
            }
            case 4: {
                return pSSysSQLCmdSQLBase.isPSSysSQLCmdNameDirty();
            }
            case 5: {
                return pSSysSQLCmdSQLBase.isPSSysSQLCmdSQLIdDirty();
            }
            case 6: {
                return pSSysSQLCmdSQLBase.isPSSysSQLCmdSQLNameDirty();
            }
            case 7: {
                return pSSysSQLCmdSQLBase.isSQLCodeDirty();
            }
            case 8: {
                return pSSysSQLCmdSQLBase.isSqlCode2Dirty();
            }
            case 9: {
                return pSSysSQLCmdSQLBase.isSQLParamsDirty();
            }
            case 10: {
                return pSSysSQLCmdSQLBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysSQLCmdSQLBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysSQLCmdSQLBase.isUserCatDirty();
            }
            case 13: {
                return pSSysSQLCmdSQLBase.isUserTagDirty();
            }
            case 14: {
                return pSSysSQLCmdSQLBase.isUserTag2Dirty();
            }
            case 15: {
                return pSSysSQLCmdSQLBase.isUserTag3Dirty();
            }
            case 16: {
                return pSSysSQLCmdSQLBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSQLCmdSQLBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSQLCmdSQLBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssqlcmdid", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getPSSysSQLCmdId()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssqlcmdname", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getPSSysSQLCmdName()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssqlcmdsqlid", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLId()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssqlcmdsqlname", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLName()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getSQLCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sqlcode", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getSQLCode()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getSqlCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sqlcode2", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getSqlCode2()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getSQLParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sqlparams", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getSQLParams()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSQLCmdSQLBase.getJSONValue((Object)pSSysSQLCmdSQLBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSQLCmdSQLBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSQLCmdSQLBase.getCreateDate() != null) {
            object = pSSysSQLCmdSQLBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSQLCmdSQLBase.getCreateMan() != null) {
            object = pSSysSQLCmdSQLBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getMemo() != null) {
            object = pSSysSQLCmdSQLBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdId() != null) {
            object = pSSysSQLCmdSQLBase.getPSSysSQLCmdId();
            xmlNode.setAttribute(FIELD_PSSYSSQLCMDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdName() != null) {
            object = pSSysSQLCmdSQLBase.getPSSysSQLCmdName();
            xmlNode.setAttribute(FIELD_PSSYSSQLCMDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLId() != null) {
            object = pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLId();
            xmlNode.setAttribute(FIELD_PSSYSSQLCMDSQLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLName() != null) {
            object = pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLName();
            xmlNode.setAttribute(FIELD_PSSYSSQLCMDSQLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getSQLCode() != null) {
            object = pSSysSQLCmdSQLBase.getSQLCode();
            xmlNode.setAttribute(FIELD_SQLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getSqlCode2() != null) {
            object = pSSysSQLCmdSQLBase.getSqlCode2();
            xmlNode.setAttribute(FIELD_SQLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getSQLParams() != null) {
            object = pSSysSQLCmdSQLBase.getSQLParams();
            xmlNode.setAttribute(FIELD_SQLPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getUpdateDate() != null) {
            object = pSSysSQLCmdSQLBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSQLCmdSQLBase.getUpdateMan() != null) {
            object = pSSysSQLCmdSQLBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserCat() != null) {
            object = pSSysSQLCmdSQLBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserTag() != null) {
            object = pSSysSQLCmdSQLBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserTag2() != null) {
            object = pSSysSQLCmdSQLBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserTag3() != null) {
            object = pSSysSQLCmdSQLBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdSQLBase.getUserTag4() != null) {
            object = pSSysSQLCmdSQLBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSQLCmdSQLBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSQLCmdSQLBase.isCreateDateDirty() && (bl || pSSysSQLCmdSQLBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSQLCmdSQLBase.getCreateDate());
        }
        if (pSSysSQLCmdSQLBase.isCreateManDirty() && (bl || pSSysSQLCmdSQLBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSQLCmdSQLBase.getCreateMan());
        }
        if (pSSysSQLCmdSQLBase.isMemoDirty() && (bl || pSSysSQLCmdSQLBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSQLCmdSQLBase.getMemo());
        }
        if (pSSysSQLCmdSQLBase.isPSSysSQLCmdIdDirty() && (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdId() != null)) {
            iDataObject.set(FIELD_PSSYSSQLCMDID, (Object)pSSysSQLCmdSQLBase.getPSSysSQLCmdId());
        }
        if (pSSysSQLCmdSQLBase.isPSSysSQLCmdNameDirty() && (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdName() != null)) {
            iDataObject.set(FIELD_PSSYSSQLCMDNAME, (Object)pSSysSQLCmdSQLBase.getPSSysSQLCmdName());
        }
        if (pSSysSQLCmdSQLBase.isPSSysSQLCmdSQLIdDirty() && (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLId() != null)) {
            iDataObject.set(FIELD_PSSYSSQLCMDSQLID, (Object)pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLId());
        }
        if (pSSysSQLCmdSQLBase.isPSSysSQLCmdSQLNameDirty() && (bl || pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLName() != null)) {
            iDataObject.set(FIELD_PSSYSSQLCMDSQLNAME, (Object)pSSysSQLCmdSQLBase.getPSSysSQLCmdSQLName());
        }
        if (pSSysSQLCmdSQLBase.isSQLCodeDirty() && (bl || pSSysSQLCmdSQLBase.getSQLCode() != null)) {
            iDataObject.set(FIELD_SQLCODE, (Object)pSSysSQLCmdSQLBase.getSQLCode());
        }
        if (pSSysSQLCmdSQLBase.isSqlCode2Dirty() && (bl || pSSysSQLCmdSQLBase.getSqlCode2() != null)) {
            iDataObject.set(FIELD_SQLCODE2, (Object)pSSysSQLCmdSQLBase.getSqlCode2());
        }
        if (pSSysSQLCmdSQLBase.isSQLParamsDirty() && (bl || pSSysSQLCmdSQLBase.getSQLParams() != null)) {
            iDataObject.set(FIELD_SQLPARAMS, (Object)pSSysSQLCmdSQLBase.getSQLParams());
        }
        if (pSSysSQLCmdSQLBase.isUpdateDateDirty() && (bl || pSSysSQLCmdSQLBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSQLCmdSQLBase.getUpdateDate());
        }
        if (pSSysSQLCmdSQLBase.isUpdateManDirty() && (bl || pSSysSQLCmdSQLBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSQLCmdSQLBase.getUpdateMan());
        }
        if (pSSysSQLCmdSQLBase.isUserCatDirty() && (bl || pSSysSQLCmdSQLBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSQLCmdSQLBase.getUserCat());
        }
        if (pSSysSQLCmdSQLBase.isUserTagDirty() && (bl || pSSysSQLCmdSQLBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSQLCmdSQLBase.getUserTag());
        }
        if (pSSysSQLCmdSQLBase.isUserTag2Dirty() && (bl || pSSysSQLCmdSQLBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSQLCmdSQLBase.getUserTag2());
        }
        if (pSSysSQLCmdSQLBase.isUserTag3Dirty() && (bl || pSSysSQLCmdSQLBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSQLCmdSQLBase.getUserTag3());
        }
        if (pSSysSQLCmdSQLBase.isUserTag4Dirty() && (bl || pSSysSQLCmdSQLBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSQLCmdSQLBase.getUserTag4());
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
        return PSSysSQLCmdSQLBase.remove(this, n);
    }

    private static boolean remove(PSSysSQLCmdSQLBase pSSysSQLCmdSQLBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSQLCmdSQLBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysSQLCmdSQLBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysSQLCmdSQLBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysSQLCmdSQLBase.resetPSSysSQLCmdId();
                return true;
            }
            case 4: {
                pSSysSQLCmdSQLBase.resetPSSysSQLCmdName();
                return true;
            }
            case 5: {
                pSSysSQLCmdSQLBase.resetPSSysSQLCmdSQLId();
                return true;
            }
            case 6: {
                pSSysSQLCmdSQLBase.resetPSSysSQLCmdSQLName();
                return true;
            }
            case 7: {
                pSSysSQLCmdSQLBase.resetSQLCode();
                return true;
            }
            case 8: {
                pSSysSQLCmdSQLBase.resetSqlCode2();
                return true;
            }
            case 9: {
                pSSysSQLCmdSQLBase.resetSQLParams();
                return true;
            }
            case 10: {
                pSSysSQLCmdSQLBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysSQLCmdSQLBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysSQLCmdSQLBase.resetUserCat();
                return true;
            }
            case 13: {
                pSSysSQLCmdSQLBase.resetUserTag();
                return true;
            }
            case 14: {
                pSSysSQLCmdSQLBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSSysSQLCmdSQLBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSSysSQLCmdSQLBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSQLCmd getPSSysSqlCmd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSqlCmd();
        }
        if (this.getPSSysSQLCmdId() == null) {
            return null;
        }
        Integer n = this.objPSSysSqlCmdLock;
        synchronized (n) {
            if (this.pssyssqlcmd != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSQLCmdId(), (Object)this.pssyssqlcmd.getPSSysSQLCmdId()) != 0L) {
                this.pssyssqlcmd = null;
            }
            if (this.pssyssqlcmd == null) {
                PSSysSQLCmd pSSysSQLCmd = new PSSysSQLCmd();
                pSSysSQLCmd.setPSSysSQLCmdId(this.getPSSysSQLCmdId());
                PSSysSQLCmdService pSSysSQLCmdService = (PSSysSQLCmdService)ServiceGlobal.getService(PSSysSQLCmdService.class, (SessionFactory)this.getSessionFactory());
                pSSysSQLCmdService.autoGet(pSSysSQLCmd);
                this.pssyssqlcmd = pSSysSQLCmd;
            }
            return this.pssyssqlcmd;
        }
    }

    private PSSysSQLCmdSQLBase getProxyEntity() {
        return this.proxyPSSysSQLCmdSQLBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSQLCmdSQLBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSQLCmdSQLBase) {
            this.proxyPSSysSQLCmdSQLBase = (PSSysSQLCmdSQLBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdSQLService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSSQLCMDID, 3);
        fieldIndexMap.put(FIELD_PSSYSSQLCMDNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSSQLCMDSQLID, 5);
        fieldIndexMap.put(FIELD_PSSYSSQLCMDSQLNAME, 6);
        fieldIndexMap.put(FIELD_SQLCODE, 7);
        fieldIndexMap.put(FIELD_SQLCODE2, 8);
        fieldIndexMap.put(FIELD_SQLPARAMS, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
    }
}

