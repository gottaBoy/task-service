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
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVTRVBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSVTRVBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DEFVIEWTYPE = "DEFVIEWTYPE";
    public static final String FIELD_DYNADEFVIEWTYPE = "DYNADEFVIEWTYPE";
    public static final String FIELD_ENABLEDYNATOOL = "ENABLEDYNATOOL";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_PSVTRVID = "PSVTRVID";
    public static final String FIELD_PSVTRVNAME = "PSVTRVNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTFLAG = 2;
    private static final int INDEX_DEFVIEWTYPE = 3;
    private static final int INDEX_DYNADEFVIEWTYPE = 4;
    private static final int INDEX_ENABLEDYNATOOL = 5;
    private static final int INDEX_LOGICNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSVIEWTYPEID = 8;
    private static final int INDEX_PSVIEWTYPENAME = 9;
    private static final int INDEX_PSVTRVID = 10;
    private static final int INDEX_PSVTRVNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSVTRVBase proxyPSVTRVBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean defviewtypeDirtyFlag = false;
    private boolean dynadefviewtypeDirtyFlag = false;
    private boolean enabledynatoolDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean psvtrvidDirtyFlag = false;
    private boolean psvtrvnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="defviewtype")
    private String defviewtype;
    @Column(name="dynadefviewtype")
    private String dynadefviewtype;
    @Column(name="enabledynatool")
    private Integer enabledynatool;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="psvtrvid")
    private String psvtrvid;
    @Column(name="psvtrvname")
    private String psvtrvname;
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
    private Integer objPSViewTypeLock = new Integer(1);
    private PSViewType psviewtype = null;

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

    public void setDEFViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defviewtype = string;
        this.defviewtypeDirtyFlag = true;
    }

    public String getDEFViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFViewType();
        }
        return this.defviewtype;
    }

    public boolean isDEFViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFViewTypeDirty();
        }
        return this.defviewtypeDirtyFlag;
    }

    public void resetDEFViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFViewType();
            return;
        }
        this.defviewtypeDirtyFlag = false;
        this.defviewtype = null;
    }

    public void setDynaDEFViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaDEFViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynadefviewtype = string;
        this.dynadefviewtypeDirtyFlag = true;
    }

    public String getDynaDEFViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaDEFViewType();
        }
        return this.dynadefviewtype;
    }

    public boolean isDynaDEFViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaDEFViewTypeDirty();
        }
        return this.dynadefviewtypeDirtyFlag;
    }

    public void resetDynaDEFViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaDEFViewType();
            return;
        }
        this.dynadefviewtypeDirtyFlag = false;
        this.dynadefviewtype = null;
    }

    public void setEnableDynaTool(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaTool(n);
            return;
        }
        this.enabledynatool = n;
        this.enabledynatoolDirtyFlag = true;
    }

    public Integer getEnableDynaTool() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaTool();
        }
        return this.enabledynatool;
    }

    public boolean isEnableDynaToolDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaToolDirty();
        }
        return this.enabledynatoolDirtyFlag;
    }

    public void resetEnableDynaTool() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaTool();
            return;
        }
        this.enabledynatoolDirtyFlag = false;
        this.enabledynatool = null;
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

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
    }

    public void setPSVTRVId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTRVId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtrvid = string;
        this.psvtrvidDirtyFlag = true;
    }

    public String getPSVTRVId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTRVId();
        }
        return this.psvtrvid;
    }

    public boolean isPSVTRVIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTRVIdDirty();
        }
        return this.psvtrvidDirtyFlag;
    }

    public void resetPSVTRVId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTRVId();
            return;
        }
        this.psvtrvidDirtyFlag = false;
        this.psvtrvid = null;
    }

    public void setPSVTRVName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTRVName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtrvname = string;
        this.psvtrvnameDirtyFlag = true;
    }

    public String getPSVTRVName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTRVName();
        }
        return this.psvtrvname;
    }

    public boolean isPSVTRVNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTRVNameDirty();
        }
        return this.psvtrvnameDirtyFlag;
    }

    public void resetPSVTRVName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTRVName();
            return;
        }
        this.psvtrvnameDirtyFlag = false;
        this.psvtrvname = null;
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
        PSVTRVBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSVTRVBase pSVTRVBase) {
        pSVTRVBase.resetCreateDate();
        pSVTRVBase.resetCreateMan();
        pSVTRVBase.resetDefaultFlag();
        pSVTRVBase.resetDEFViewType();
        pSVTRVBase.resetDynaDEFViewType();
        pSVTRVBase.resetEnableDynaTool();
        pSVTRVBase.resetLogicName();
        pSVTRVBase.resetMemo();
        pSVTRVBase.resetPSViewTypeId();
        pSVTRVBase.resetPSViewTypeName();
        pSVTRVBase.resetPSVTRVId();
        pSVTRVBase.resetPSVTRVName();
        pSVTRVBase.resetUpdateDate();
        pSVTRVBase.resetUpdateMan();
        pSVTRVBase.resetUserCat();
        pSVTRVBase.resetUserTag();
        pSVTRVBase.resetUserTag2();
        pSVTRVBase.resetUserTag3();
        pSVTRVBase.resetUserTag4();
        pSVTRVBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDEFViewTypeDirty()) {
            hashMap.put(FIELD_DEFVIEWTYPE, this.getDEFViewType());
        }
        if (!bl || this.isDynaDEFViewTypeDirty()) {
            hashMap.put(FIELD_DYNADEFVIEWTYPE, this.getDynaDEFViewType());
        }
        if (!bl || this.isEnableDynaToolDirty()) {
            hashMap.put(FIELD_ENABLEDYNATOOL, this.getEnableDynaTool());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isPSVTRVIdDirty()) {
            hashMap.put(FIELD_PSVTRVID, this.getPSVTRVId());
        }
        if (!bl || this.isPSVTRVNameDirty()) {
            hashMap.put(FIELD_PSVTRVNAME, this.getPSVTRVName());
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
        return PSVTRVBase.get(this, n);
    }

    private static Object get(PSVTRVBase pSVTRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTRVBase.getCreateDate();
            }
            case 1: {
                return pSVTRVBase.getCreateMan();
            }
            case 2: {
                return pSVTRVBase.getDefaultFlag();
            }
            case 3: {
                return pSVTRVBase.getDEFViewType();
            }
            case 4: {
                return pSVTRVBase.getDynaDEFViewType();
            }
            case 5: {
                return pSVTRVBase.getEnableDynaTool();
            }
            case 6: {
                return pSVTRVBase.getLogicName();
            }
            case 7: {
                return pSVTRVBase.getMemo();
            }
            case 8: {
                return pSVTRVBase.getPSViewTypeId();
            }
            case 9: {
                return pSVTRVBase.getPSViewTypeName();
            }
            case 10: {
                return pSVTRVBase.getPSVTRVId();
            }
            case 11: {
                return pSVTRVBase.getPSVTRVName();
            }
            case 12: {
                return pSVTRVBase.getUpdateDate();
            }
            case 13: {
                return pSVTRVBase.getUpdateMan();
            }
            case 14: {
                return pSVTRVBase.getUserCat();
            }
            case 15: {
                return pSVTRVBase.getUserTag();
            }
            case 16: {
                return pSVTRVBase.getUserTag2();
            }
            case 17: {
                return pSVTRVBase.getUserTag3();
            }
            case 18: {
                return pSVTRVBase.getUserTag4();
            }
            case 19: {
                return pSVTRVBase.getValidFlag();
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
        PSVTRVBase.set(this, n, object);
    }

    private static void set(PSVTRVBase pSVTRVBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSVTRVBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSVTRVBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSVTRVBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSVTRVBase.setDEFViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSVTRVBase.setDynaDEFViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSVTRVBase.setEnableDynaTool(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSVTRVBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSVTRVBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSVTRVBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSVTRVBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSVTRVBase.setPSVTRVId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSVTRVBase.setPSVTRVName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSVTRVBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSVTRVBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSVTRVBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSVTRVBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSVTRVBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSVTRVBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSVTRVBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSVTRVBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSVTRVBase.isNull(this, n);
    }

    private static boolean isNull(PSVTRVBase pSVTRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTRVBase.getCreateDate() == null;
            }
            case 1: {
                return pSVTRVBase.getCreateMan() == null;
            }
            case 2: {
                return pSVTRVBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSVTRVBase.getDEFViewType() == null;
            }
            case 4: {
                return pSVTRVBase.getDynaDEFViewType() == null;
            }
            case 5: {
                return pSVTRVBase.getEnableDynaTool() == null;
            }
            case 6: {
                return pSVTRVBase.getLogicName() == null;
            }
            case 7: {
                return pSVTRVBase.getMemo() == null;
            }
            case 8: {
                return pSVTRVBase.getPSViewTypeId() == null;
            }
            case 9: {
                return pSVTRVBase.getPSViewTypeName() == null;
            }
            case 10: {
                return pSVTRVBase.getPSVTRVId() == null;
            }
            case 11: {
                return pSVTRVBase.getPSVTRVName() == null;
            }
            case 12: {
                return pSVTRVBase.getUpdateDate() == null;
            }
            case 13: {
                return pSVTRVBase.getUpdateMan() == null;
            }
            case 14: {
                return pSVTRVBase.getUserCat() == null;
            }
            case 15: {
                return pSVTRVBase.getUserTag() == null;
            }
            case 16: {
                return pSVTRVBase.getUserTag2() == null;
            }
            case 17: {
                return pSVTRVBase.getUserTag3() == null;
            }
            case 18: {
                return pSVTRVBase.getUserTag4() == null;
            }
            case 19: {
                return pSVTRVBase.getValidFlag() == null;
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
        return PSVTRVBase.contains(this, n);
    }

    private static boolean contains(PSVTRVBase pSVTRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTRVBase.isCreateDateDirty();
            }
            case 1: {
                return pSVTRVBase.isCreateManDirty();
            }
            case 2: {
                return pSVTRVBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSVTRVBase.isDEFViewTypeDirty();
            }
            case 4: {
                return pSVTRVBase.isDynaDEFViewTypeDirty();
            }
            case 5: {
                return pSVTRVBase.isEnableDynaToolDirty();
            }
            case 6: {
                return pSVTRVBase.isLogicNameDirty();
            }
            case 7: {
                return pSVTRVBase.isMemoDirty();
            }
            case 8: {
                return pSVTRVBase.isPSViewTypeIdDirty();
            }
            case 9: {
                return pSVTRVBase.isPSViewTypeNameDirty();
            }
            case 10: {
                return pSVTRVBase.isPSVTRVIdDirty();
            }
            case 11: {
                return pSVTRVBase.isPSVTRVNameDirty();
            }
            case 12: {
                return pSVTRVBase.isUpdateDateDirty();
            }
            case 13: {
                return pSVTRVBase.isUpdateManDirty();
            }
            case 14: {
                return pSVTRVBase.isUserCatDirty();
            }
            case 15: {
                return pSVTRVBase.isUserTagDirty();
            }
            case 16: {
                return pSVTRVBase.isUserTag2Dirty();
            }
            case 17: {
                return pSVTRVBase.isUserTag3Dirty();
            }
            case 18: {
                return pSVTRVBase.isUserTag4Dirty();
            }
            case 19: {
                return pSVTRVBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSVTRVBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSVTRVBase pSVTRVBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSVTRVBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSVTRVBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSVTRVBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSVTRVBase.getDEFViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defviewtype", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getDEFViewType()), (boolean)false);
        }
        if (bl || pSVTRVBase.getDynaDEFViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynadefviewtype", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getDynaDEFViewType()), (boolean)false);
        }
        if (bl || pSVTRVBase.getEnableDynaTool() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynatool", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getEnableDynaTool()), (boolean)false);
        }
        if (bl || pSVTRVBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getLogicName()), (boolean)false);
        }
        if (bl || pSVTRVBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getMemo()), (boolean)false);
        }
        if (bl || pSVTRVBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSVTRVBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSVTRVBase.getPSVTRVId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtrvid", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getPSVTRVId()), (boolean)false);
        }
        if (bl || pSVTRVBase.getPSVTRVName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtrvname", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getPSVTRVName()), (boolean)false);
        }
        if (bl || pSVTRVBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSVTRVBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSVTRVBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getUserCat()), (boolean)false);
        }
        if (bl || pSVTRVBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getUserTag()), (boolean)false);
        }
        if (bl || pSVTRVBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSVTRVBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSVTRVBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSVTRVBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSVTRVBase.getJSONValue((Object)pSVTRVBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSVTRVBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSVTRVBase pSVTRVBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSVTRVBase.getCreateDate() != null) {
            object = pSVTRVBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTRVBase.getCreateMan() != null) {
            object = pSVTRVBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getDefaultFlag() != null) {
            object = pSVTRVBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTRVBase.getDEFViewType() != null) {
            object = pSVTRVBase.getDEFViewType();
            xmlNode.setAttribute(FIELD_DEFVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getDynaDEFViewType() != null) {
            object = pSVTRVBase.getDynaDEFViewType();
            xmlNode.setAttribute(FIELD_DYNADEFVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getEnableDynaTool() != null) {
            object = pSVTRVBase.getEnableDynaTool();
            xmlNode.setAttribute(FIELD_ENABLEDYNATOOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTRVBase.getLogicName() != null) {
            object = pSVTRVBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getMemo() != null) {
            object = pSVTRVBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getPSViewTypeId() != null) {
            object = pSVTRVBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getPSViewTypeName() != null) {
            object = pSVTRVBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getPSVTRVId() != null) {
            object = pSVTRVBase.getPSVTRVId();
            xmlNode.setAttribute(FIELD_PSVTRVID, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getPSVTRVName() != null) {
            object = pSVTRVBase.getPSVTRVName();
            xmlNode.setAttribute(FIELD_PSVTRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getUpdateDate() != null) {
            object = pSVTRVBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTRVBase.getUpdateMan() != null) {
            object = pSVTRVBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getUserCat() != null) {
            object = pSVTRVBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getUserTag() != null) {
            object = pSVTRVBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getUserTag2() != null) {
            object = pSVTRVBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getUserTag3() != null) {
            object = pSVTRVBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getUserTag4() != null) {
            object = pSVTRVBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSVTRVBase.getValidFlag() != null) {
            object = pSVTRVBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSVTRVBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSVTRVBase pSVTRVBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSVTRVBase.isCreateDateDirty() && (bl || pSVTRVBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSVTRVBase.getCreateDate());
        }
        if (pSVTRVBase.isCreateManDirty() && (bl || pSVTRVBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSVTRVBase.getCreateMan());
        }
        if (pSVTRVBase.isDefaultFlagDirty() && (bl || pSVTRVBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSVTRVBase.getDefaultFlag());
        }
        if (pSVTRVBase.isDEFViewTypeDirty() && (bl || pSVTRVBase.getDEFViewType() != null)) {
            iDataObject.set(FIELD_DEFVIEWTYPE, (Object)pSVTRVBase.getDEFViewType());
        }
        if (pSVTRVBase.isDynaDEFViewTypeDirty() && (bl || pSVTRVBase.getDynaDEFViewType() != null)) {
            iDataObject.set(FIELD_DYNADEFVIEWTYPE, (Object)pSVTRVBase.getDynaDEFViewType());
        }
        if (pSVTRVBase.isEnableDynaToolDirty() && (bl || pSVTRVBase.getEnableDynaTool() != null)) {
            iDataObject.set(FIELD_ENABLEDYNATOOL, (Object)pSVTRVBase.getEnableDynaTool());
        }
        if (pSVTRVBase.isLogicNameDirty() && (bl || pSVTRVBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSVTRVBase.getLogicName());
        }
        if (pSVTRVBase.isMemoDirty() && (bl || pSVTRVBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSVTRVBase.getMemo());
        }
        if (pSVTRVBase.isPSViewTypeIdDirty() && (bl || pSVTRVBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSVTRVBase.getPSViewTypeId());
        }
        if (pSVTRVBase.isPSViewTypeNameDirty() && (bl || pSVTRVBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSVTRVBase.getPSViewTypeName());
        }
        if (pSVTRVBase.isPSVTRVIdDirty() && (bl || pSVTRVBase.getPSVTRVId() != null)) {
            iDataObject.set(FIELD_PSVTRVID, (Object)pSVTRVBase.getPSVTRVId());
        }
        if (pSVTRVBase.isPSVTRVNameDirty() && (bl || pSVTRVBase.getPSVTRVName() != null)) {
            iDataObject.set(FIELD_PSVTRVNAME, (Object)pSVTRVBase.getPSVTRVName());
        }
        if (pSVTRVBase.isUpdateDateDirty() && (bl || pSVTRVBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSVTRVBase.getUpdateDate());
        }
        if (pSVTRVBase.isUpdateManDirty() && (bl || pSVTRVBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSVTRVBase.getUpdateMan());
        }
        if (pSVTRVBase.isUserCatDirty() && (bl || pSVTRVBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSVTRVBase.getUserCat());
        }
        if (pSVTRVBase.isUserTagDirty() && (bl || pSVTRVBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSVTRVBase.getUserTag());
        }
        if (pSVTRVBase.isUserTag2Dirty() && (bl || pSVTRVBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSVTRVBase.getUserTag2());
        }
        if (pSVTRVBase.isUserTag3Dirty() && (bl || pSVTRVBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSVTRVBase.getUserTag3());
        }
        if (pSVTRVBase.isUserTag4Dirty() && (bl || pSVTRVBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSVTRVBase.getUserTag4());
        }
        if (pSVTRVBase.isValidFlagDirty() && (bl || pSVTRVBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSVTRVBase.getValidFlag());
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
        return PSVTRVBase.remove(this, n);
    }

    private static boolean remove(PSVTRVBase pSVTRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSVTRVBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSVTRVBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSVTRVBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSVTRVBase.resetDEFViewType();
                return true;
            }
            case 4: {
                pSVTRVBase.resetDynaDEFViewType();
                return true;
            }
            case 5: {
                pSVTRVBase.resetEnableDynaTool();
                return true;
            }
            case 6: {
                pSVTRVBase.resetLogicName();
                return true;
            }
            case 7: {
                pSVTRVBase.resetMemo();
                return true;
            }
            case 8: {
                pSVTRVBase.resetPSViewTypeId();
                return true;
            }
            case 9: {
                pSVTRVBase.resetPSViewTypeName();
                return true;
            }
            case 10: {
                pSVTRVBase.resetPSVTRVId();
                return true;
            }
            case 11: {
                pSVTRVBase.resetPSVTRVName();
                return true;
            }
            case 12: {
                pSVTRVBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSVTRVBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSVTRVBase.resetUserCat();
                return true;
            }
            case 15: {
                pSVTRVBase.resetUserTag();
                return true;
            }
            case 16: {
                pSVTRVBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSVTRVBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSVTRVBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSVTRVBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewType();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet(pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSVTRVBase getProxyEntity() {
        return this.proxyPSVTRVBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSVTRVBase = null;
        if (iDataObject != null && iDataObject instanceof PSVTRVBase) {
            this.proxyPSVTRVBase = (PSVTRVBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVTRVService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 2);
        fieldIndexMap.put(FIELD_DEFVIEWTYPE, 3);
        fieldIndexMap.put(FIELD_DYNADEFVIEWTYPE, 4);
        fieldIndexMap.put(FIELD_ENABLEDYNATOOL, 5);
        fieldIndexMap.put(FIELD_LOGICNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 8);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 9);
        fieldIndexMap.put(FIELD_PSVTRVID, 10);
        fieldIndexMap.put(FIELD_PSVTRVNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

