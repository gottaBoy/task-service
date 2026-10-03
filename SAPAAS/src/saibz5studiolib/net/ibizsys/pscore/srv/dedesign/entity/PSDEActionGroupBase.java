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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAGDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEActionGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GROUPTAG = "GROUPTAG";
    public static final String FIELD_GROUPTAG2 = "GROUPTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEACTIONGROUPID = "PSDEACTIONGROUPID";
    public static final String FIELD_PSDEACTIONGROUPNAME = "PSDEACTIONGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CODENAME2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_GROUPTAG = 4;
    private static final int INDEX_GROUPTAG2 = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDEACTIONGROUPID = 7;
    private static final int INDEX_PSDEACTIONGROUPNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSDENAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEActionGroupBase proxyPSDEActionGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean grouptagDirtyFlag = false;
    private boolean grouptag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeactiongroupidDirtyFlag = false;
    private boolean psdeactiongroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
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
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="grouptag")
    private String grouptag;
    @Column(name="grouptag2")
    private String grouptag2;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeactiongroupid")
    private String psdeactiongroupid;
    @Column(name="psdeactiongroupname")
    private String psdeactiongroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEAGDetailsLock = new Integer(1);
    private ArrayList<PSDEAGDetail> psdeagdetails = null;

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

    public void setGroupTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag = string;
        this.grouptagDirtyFlag = true;
    }

    public String getGroupTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag();
        }
        return this.grouptag;
    }

    public boolean isGroupTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTagDirty();
        }
        return this.grouptagDirtyFlag;
    }

    public void resetGroupTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag();
            return;
        }
        this.grouptagDirtyFlag = false;
        this.grouptag = null;
    }

    public void setGroupTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag2 = string;
        this.grouptag2DirtyFlag = true;
    }

    public String getGroupTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag2();
        }
        return this.grouptag2;
    }

    public boolean isGroupTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTag2Dirty();
        }
        return this.grouptag2DirtyFlag;
    }

    public void resetGroupTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag2();
            return;
        }
        this.grouptag2DirtyFlag = false;
        this.grouptag2 = null;
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

    public void setPSDEActionGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiongroupid = string;
        this.psdeactiongroupidDirtyFlag = true;
    }

    public String getPSDEActionGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionGroupId();
        }
        return this.psdeactiongroupid;
    }

    public boolean isPSDEActionGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionGroupIdDirty();
        }
        return this.psdeactiongroupidDirtyFlag;
    }

    public void resetPSDEActionGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionGroupId();
            return;
        }
        this.psdeactiongroupidDirtyFlag = false;
        this.psdeactiongroupid = null;
    }

    public void setPSDEActionGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiongroupname = string;
        this.psdeactiongroupnameDirtyFlag = true;
    }

    public String getPSDEActionGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionGroupName();
        }
        return this.psdeactiongroupname;
    }

    public boolean isPSDEActionGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionGroupNameDirty();
        }
        return this.psdeactiongroupnameDirtyFlag;
    }

    public void resetPSDEActionGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionGroupName();
            return;
        }
        this.psdeactiongroupnameDirtyFlag = false;
        this.psdeactiongroupname = null;
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
        PSDEActionGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEActionGroupBase pSDEActionGroupBase) {
        pSDEActionGroupBase.resetCodeName();
        pSDEActionGroupBase.resetCodeName2();
        pSDEActionGroupBase.resetCreateDate();
        pSDEActionGroupBase.resetCreateMan();
        pSDEActionGroupBase.resetGroupTag();
        pSDEActionGroupBase.resetGroupTag2();
        pSDEActionGroupBase.resetMemo();
        pSDEActionGroupBase.resetPSDEActionGroupId();
        pSDEActionGroupBase.resetPSDEActionGroupName();
        pSDEActionGroupBase.resetPSDEId();
        pSDEActionGroupBase.resetPSDEName();
        pSDEActionGroupBase.resetUpdateDate();
        pSDEActionGroupBase.resetUpdateMan();
        pSDEActionGroupBase.resetUserCat();
        pSDEActionGroupBase.resetUserTag();
        pSDEActionGroupBase.resetUserTag2();
        pSDEActionGroupBase.resetUserTag3();
        pSDEActionGroupBase.resetUserTag4();
        pSDEActionGroupBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isGroupTagDirty()) {
            hashMap.put(FIELD_GROUPTAG, this.getGroupTag());
        }
        if (!bl || this.isGroupTag2Dirty()) {
            hashMap.put(FIELD_GROUPTAG2, this.getGroupTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEActionGroupIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONGROUPID, this.getPSDEActionGroupId());
        }
        if (!bl || this.isPSDEActionGroupNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONGROUPNAME, this.getPSDEActionGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
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
        return PSDEActionGroupBase.get(this, n);
    }

    private static Object get(PSDEActionGroupBase pSDEActionGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionGroupBase.getCodeName();
            }
            case 1: {
                return pSDEActionGroupBase.getCodeName2();
            }
            case 2: {
                return pSDEActionGroupBase.getCreateDate();
            }
            case 3: {
                return pSDEActionGroupBase.getCreateMan();
            }
            case 4: {
                return pSDEActionGroupBase.getGroupTag();
            }
            case 5: {
                return pSDEActionGroupBase.getGroupTag2();
            }
            case 6: {
                return pSDEActionGroupBase.getMemo();
            }
            case 7: {
                return pSDEActionGroupBase.getPSDEActionGroupId();
            }
            case 8: {
                return pSDEActionGroupBase.getPSDEActionGroupName();
            }
            case 9: {
                return pSDEActionGroupBase.getPSDEId();
            }
            case 10: {
                return pSDEActionGroupBase.getPSDEName();
            }
            case 11: {
                return pSDEActionGroupBase.getUpdateDate();
            }
            case 12: {
                return pSDEActionGroupBase.getUpdateMan();
            }
            case 13: {
                return pSDEActionGroupBase.getUserCat();
            }
            case 14: {
                return pSDEActionGroupBase.getUserTag();
            }
            case 15: {
                return pSDEActionGroupBase.getUserTag2();
            }
            case 16: {
                return pSDEActionGroupBase.getUserTag3();
            }
            case 17: {
                return pSDEActionGroupBase.getUserTag4();
            }
            case 18: {
                return pSDEActionGroupBase.getValidFlag();
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
        PSDEActionGroupBase.set(this, n, object);
    }

    private static void set(PSDEActionGroupBase pSDEActionGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEActionGroupBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEActionGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEActionGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEActionGroupBase.setGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEActionGroupBase.setGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEActionGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEActionGroupBase.setPSDEActionGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEActionGroupBase.setPSDEActionGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEActionGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEActionGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEActionGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDEActionGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEActionGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEActionGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEActionGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEActionGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEActionGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEActionGroupBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEActionGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDEActionGroupBase pSDEActionGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSDEActionGroupBase.getCodeName2() == null;
            }
            case 2: {
                return pSDEActionGroupBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEActionGroupBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEActionGroupBase.getGroupTag() == null;
            }
            case 5: {
                return pSDEActionGroupBase.getGroupTag2() == null;
            }
            case 6: {
                return pSDEActionGroupBase.getMemo() == null;
            }
            case 7: {
                return pSDEActionGroupBase.getPSDEActionGroupId() == null;
            }
            case 8: {
                return pSDEActionGroupBase.getPSDEActionGroupName() == null;
            }
            case 9: {
                return pSDEActionGroupBase.getPSDEId() == null;
            }
            case 10: {
                return pSDEActionGroupBase.getPSDEName() == null;
            }
            case 11: {
                return pSDEActionGroupBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDEActionGroupBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDEActionGroupBase.getUserCat() == null;
            }
            case 14: {
                return pSDEActionGroupBase.getUserTag() == null;
            }
            case 15: {
                return pSDEActionGroupBase.getUserTag2() == null;
            }
            case 16: {
                return pSDEActionGroupBase.getUserTag3() == null;
            }
            case 17: {
                return pSDEActionGroupBase.getUserTag4() == null;
            }
            case 18: {
                return pSDEActionGroupBase.getValidFlag() == null;
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
        return PSDEActionGroupBase.contains(this, n);
    }

    private static boolean contains(PSDEActionGroupBase pSDEActionGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEActionGroupBase.isCodeName2Dirty();
            }
            case 2: {
                return pSDEActionGroupBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEActionGroupBase.isCreateManDirty();
            }
            case 4: {
                return pSDEActionGroupBase.isGroupTagDirty();
            }
            case 5: {
                return pSDEActionGroupBase.isGroupTag2Dirty();
            }
            case 6: {
                return pSDEActionGroupBase.isMemoDirty();
            }
            case 7: {
                return pSDEActionGroupBase.isPSDEActionGroupIdDirty();
            }
            case 8: {
                return pSDEActionGroupBase.isPSDEActionGroupNameDirty();
            }
            case 9: {
                return pSDEActionGroupBase.isPSDEIdDirty();
            }
            case 10: {
                return pSDEActionGroupBase.isPSDENameDirty();
            }
            case 11: {
                return pSDEActionGroupBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDEActionGroupBase.isUpdateManDirty();
            }
            case 13: {
                return pSDEActionGroupBase.isUserCatDirty();
            }
            case 14: {
                return pSDEActionGroupBase.isUserTagDirty();
            }
            case 15: {
                return pSDEActionGroupBase.isUserTag2Dirty();
            }
            case 16: {
                return pSDEActionGroupBase.isUserTag3Dirty();
            }
            case 17: {
                return pSDEActionGroupBase.isUserTag4Dirty();
            }
            case 18: {
                return pSDEActionGroupBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEActionGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEActionGroupBase pSDEActionGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEActionGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getGroupTag()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag2", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getGroupTag2()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getPSDEActionGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiongroupid", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getPSDEActionGroupId()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getPSDEActionGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiongroupname", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getPSDEActionGroupName()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEActionGroupBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEActionGroupBase.getJSONValue((Object)pSDEActionGroupBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEActionGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEActionGroupBase pSDEActionGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEActionGroupBase.getCodeName() != null) {
            object = pSDEActionGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionGroupBase.getCodeName2() != null) {
            object = pSDEActionGroupBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getCreateDate() != null) {
            object = pSDEActionGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionGroupBase.getCreateMan() != null) {
            object = pSDEActionGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getGroupTag() != null) {
            object = pSDEActionGroupBase.getGroupTag();
            xmlNode.setAttribute(FIELD_GROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getGroupTag2() != null) {
            object = pSDEActionGroupBase.getGroupTag2();
            xmlNode.setAttribute(FIELD_GROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getMemo() != null) {
            object = pSDEActionGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getPSDEActionGroupId() != null) {
            object = pSDEActionGroupBase.getPSDEActionGroupId();
            xmlNode.setAttribute(FIELD_PSDEACTIONGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getPSDEActionGroupName() != null) {
            object = pSDEActionGroupBase.getPSDEActionGroupName();
            xmlNode.setAttribute(FIELD_PSDEACTIONGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getPSDEId() != null) {
            object = pSDEActionGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getPSDEName() != null) {
            object = pSDEActionGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getUpdateDate() != null) {
            object = pSDEActionGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionGroupBase.getUpdateMan() != null) {
            object = pSDEActionGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getUserCat() != null) {
            object = pSDEActionGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getUserTag() != null) {
            object = pSDEActionGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getUserTag2() != null) {
            object = pSDEActionGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getUserTag3() != null) {
            object = pSDEActionGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getUserTag4() != null) {
            object = pSDEActionGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionGroupBase.getValidFlag() != null) {
            object = pSDEActionGroupBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEActionGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEActionGroupBase pSDEActionGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEActionGroupBase.isCodeNameDirty() && (bl || pSDEActionGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEActionGroupBase.getCodeName());
        }
        if (pSDEActionGroupBase.isCodeName2Dirty() && (bl || pSDEActionGroupBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDEActionGroupBase.getCodeName2());
        }
        if (pSDEActionGroupBase.isCreateDateDirty() && (bl || pSDEActionGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEActionGroupBase.getCreateDate());
        }
        if (pSDEActionGroupBase.isCreateManDirty() && (bl || pSDEActionGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEActionGroupBase.getCreateMan());
        }
        if (pSDEActionGroupBase.isGroupTagDirty() && (bl || pSDEActionGroupBase.getGroupTag() != null)) {
            iDataObject.set(FIELD_GROUPTAG, (Object)pSDEActionGroupBase.getGroupTag());
        }
        if (pSDEActionGroupBase.isGroupTag2Dirty() && (bl || pSDEActionGroupBase.getGroupTag2() != null)) {
            iDataObject.set(FIELD_GROUPTAG2, (Object)pSDEActionGroupBase.getGroupTag2());
        }
        if (pSDEActionGroupBase.isMemoDirty() && (bl || pSDEActionGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEActionGroupBase.getMemo());
        }
        if (pSDEActionGroupBase.isPSDEActionGroupIdDirty() && (bl || pSDEActionGroupBase.getPSDEActionGroupId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONGROUPID, (Object)pSDEActionGroupBase.getPSDEActionGroupId());
        }
        if (pSDEActionGroupBase.isPSDEActionGroupNameDirty() && (bl || pSDEActionGroupBase.getPSDEActionGroupName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONGROUPNAME, (Object)pSDEActionGroupBase.getPSDEActionGroupName());
        }
        if (pSDEActionGroupBase.isPSDEIdDirty() && (bl || pSDEActionGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEActionGroupBase.getPSDEId());
        }
        if (pSDEActionGroupBase.isPSDENameDirty() && (bl || pSDEActionGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEActionGroupBase.getPSDEName());
        }
        if (pSDEActionGroupBase.isUpdateDateDirty() && (bl || pSDEActionGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEActionGroupBase.getUpdateDate());
        }
        if (pSDEActionGroupBase.isUpdateManDirty() && (bl || pSDEActionGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEActionGroupBase.getUpdateMan());
        }
        if (pSDEActionGroupBase.isUserCatDirty() && (bl || pSDEActionGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEActionGroupBase.getUserCat());
        }
        if (pSDEActionGroupBase.isUserTagDirty() && (bl || pSDEActionGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEActionGroupBase.getUserTag());
        }
        if (pSDEActionGroupBase.isUserTag2Dirty() && (bl || pSDEActionGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEActionGroupBase.getUserTag2());
        }
        if (pSDEActionGroupBase.isUserTag3Dirty() && (bl || pSDEActionGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEActionGroupBase.getUserTag3());
        }
        if (pSDEActionGroupBase.isUserTag4Dirty() && (bl || pSDEActionGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEActionGroupBase.getUserTag4());
        }
        if (pSDEActionGroupBase.isValidFlagDirty() && (bl || pSDEActionGroupBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEActionGroupBase.getValidFlag());
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
        return PSDEActionGroupBase.remove(this, n);
    }

    private static boolean remove(PSDEActionGroupBase pSDEActionGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEActionGroupBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSDEActionGroupBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEActionGroupBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEActionGroupBase.resetGroupTag();
                return true;
            }
            case 5: {
                pSDEActionGroupBase.resetGroupTag2();
                return true;
            }
            case 6: {
                pSDEActionGroupBase.resetMemo();
                return true;
            }
            case 7: {
                pSDEActionGroupBase.resetPSDEActionGroupId();
                return true;
            }
            case 8: {
                pSDEActionGroupBase.resetPSDEActionGroupName();
                return true;
            }
            case 9: {
                pSDEActionGroupBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSDEActionGroupBase.resetPSDEName();
                return true;
            }
            case 11: {
                pSDEActionGroupBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDEActionGroupBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDEActionGroupBase.resetUserCat();
                return true;
            }
            case 14: {
                pSDEActionGroupBase.resetUserTag();
                return true;
            }
            case 15: {
                pSDEActionGroupBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSDEActionGroupBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSDEActionGroupBase.resetUserTag4();
                return true;
            }
            case 18: {
                pSDEActionGroupBase.resetValidFlag();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEAGDetail> getPSDEAGDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAGDetails();
        }
        if (this.getPSDEActionGroupId() == null) {
            return null;
        }
        PSDEActionGroupService pSDEActionGroupService = (PSDEActionGroupService)ServiceGlobal.getService(PSDEActionGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDEAGDetailService pSDEAGDetailService = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEAGDetailsLock;
        synchronized (n) {
            if (this.psdeagdetails == null) {
                this.psdeagdetails = pSDEActionGroupService.isTempData(this) ? pSDEAGDetailService.selectTempByPSDEActionGroup(this) : pSDEAGDetailService.selectByPSDEActionGroup(this);
            }
            return this.psdeagdetails;
        }
    }

    private PSDEActionGroupBase getProxyEntity() {
        return this.proxyPSDEActionGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEActionGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEActionGroupBase) {
            this.proxyPSDEActionGroupBase = (PSDEActionGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_GROUPTAG, 4);
        fieldIndexMap.put(FIELD_GROUPTAG2, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDEACTIONGROUPID, 7);
        fieldIndexMap.put(FIELD_PSDEACTIONGROUPNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSDENAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

