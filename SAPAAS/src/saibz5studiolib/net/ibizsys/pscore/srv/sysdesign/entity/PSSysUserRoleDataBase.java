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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPriv;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserRoleDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUserRoleDataBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUSERROLEID = "PSDEUSERROLEID";
    public static final String FIELD_PSDEUSERROLENAME = "PSDEUSERROLENAME";
    public static final String FIELD_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String FIELD_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String FIELD_PSSYSUSERROLEDATAID = "PSSYSUSERROLEDATAID";
    public static final String FIELD_PSSYSUSERROLEDATANAME = "PSSYSUSERROLEDATANAME";
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
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEID = 3;
    private static final int INDEX_PSDENAME = 4;
    private static final int INDEX_PSDEUSERROLEID = 5;
    private static final int INDEX_PSDEUSERROLENAME = 6;
    private static final int INDEX_PSSYSOPPRIVID = 7;
    private static final int INDEX_PSSYSOPPRIVNAME = 8;
    private static final int INDEX_PSSYSUSERROLEDATAID = 9;
    private static final int INDEX_PSSYSUSERROLEDATANAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUserRoleDataBase proxyPSSysUserRoleDataBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuserroleidDirtyFlag = false;
    private boolean psdeuserrolenameDirtyFlag = false;
    private boolean pssysopprividDirtyFlag = false;
    private boolean pssysopprivnameDirtyFlag = false;
    private boolean pssysuserroledataidDirtyFlag = false;
    private boolean pssysuserroledatanameDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeuserroleid")
    private String psdeuserroleid;
    @Column(name="psdeuserrolename")
    private String psdeuserrolename;
    @Column(name="pssysopprivid")
    private String pssysopprivid;
    @Column(name="pssysopprivname")
    private String pssysopprivname;
    @Column(name="pssysuserroledataid")
    private String pssysuserroledataid;
    @Column(name="pssysuserroledataname")
    private String pssysuserroledataname;
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
    private Integer objPSDEUserRoleLock = new Integer(1);
    private PSDEUserRole psdeuserrole = null;
    private Integer objPSSysOPPrivLock = new Integer(1);
    private PSSysOPPriv pssysoppriv = null;

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

    public void setPSDEUserRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUserRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuserroleid = string;
        this.psdeuserroleidDirtyFlag = true;
    }

    public String getPSDEUserRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRoleId();
        }
        return this.psdeuserroleid;
    }

    public boolean isPSDEUserRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUserRoleIdDirty();
        }
        return this.psdeuserroleidDirtyFlag;
    }

    public void resetPSDEUserRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUserRoleId();
            return;
        }
        this.psdeuserroleidDirtyFlag = false;
        this.psdeuserroleid = null;
    }

    public void setPSDEUserRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUserRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuserrolename = string;
        this.psdeuserrolenameDirtyFlag = true;
    }

    public String getPSDEUserRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRoleName();
        }
        return this.psdeuserrolename;
    }

    public boolean isPSDEUserRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUserRoleNameDirty();
        }
        return this.psdeuserrolenameDirtyFlag;
    }

    public void resetPSDEUserRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUserRoleName();
            return;
        }
        this.psdeuserrolenameDirtyFlag = false;
        this.psdeuserrolename = null;
    }

    public void setPSSysOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysopprivid = string;
        this.pssysopprividDirtyFlag = true;
    }

    public String getPSSysOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPrivId();
        }
        return this.pssysopprivid;
    }

    public boolean isPSSysOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOPPrivIdDirty();
        }
        return this.pssysopprividDirtyFlag;
    }

    public void resetPSSysOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOPPrivId();
            return;
        }
        this.pssysopprividDirtyFlag = false;
        this.pssysopprivid = null;
    }

    public void setPSSysOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysopprivname = string;
        this.pssysopprivnameDirtyFlag = true;
    }

    public String getPSSysOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPrivName();
        }
        return this.pssysopprivname;
    }

    public boolean isPSSysOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOPPrivNameDirty();
        }
        return this.pssysopprivnameDirtyFlag;
    }

    public void resetPSSysOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOPPrivName();
            return;
        }
        this.pssysopprivnameDirtyFlag = false;
        this.pssysopprivname = null;
    }

    public void setPSSysUserRoleDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserRoleDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserroledataid = string;
        this.pssysuserroledataidDirtyFlag = true;
    }

    public String getPSSysUserRoleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserRoleDataId();
        }
        return this.pssysuserroledataid;
    }

    public boolean isPSSysUserRoleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserRoleDataIdDirty();
        }
        return this.pssysuserroledataidDirtyFlag;
    }

    public void resetPSSysUserRoleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserRoleDataId();
            return;
        }
        this.pssysuserroledataidDirtyFlag = false;
        this.pssysuserroledataid = null;
    }

    public void setPSSysUserRoleDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserRoleDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserroledataname = string;
        this.pssysuserroledatanameDirtyFlag = true;
    }

    public String getPSSysUserRoleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserRoleDataName();
        }
        return this.pssysuserroledataname;
    }

    public boolean isPSSysUserRoleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserRoleDataNameDirty();
        }
        return this.pssysuserroledatanameDirtyFlag;
    }

    public void resetPSSysUserRoleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserRoleDataName();
            return;
        }
        this.pssysuserroledatanameDirtyFlag = false;
        this.pssysuserroledataname = null;
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
        PSSysUserRoleDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUserRoleDataBase pSSysUserRoleDataBase) {
        pSSysUserRoleDataBase.resetCreateDate();
        pSSysUserRoleDataBase.resetCreateMan();
        pSSysUserRoleDataBase.resetMemo();
        pSSysUserRoleDataBase.resetPSDEId();
        pSSysUserRoleDataBase.resetPSDEName();
        pSSysUserRoleDataBase.resetPSDEUserRoleId();
        pSSysUserRoleDataBase.resetPSDEUserRoleName();
        pSSysUserRoleDataBase.resetPSSysOPPrivId();
        pSSysUserRoleDataBase.resetPSSysOPPrivName();
        pSSysUserRoleDataBase.resetPSSysUserRoleDataId();
        pSSysUserRoleDataBase.resetPSSysUserRoleDataName();
        pSSysUserRoleDataBase.resetUpdateDate();
        pSSysUserRoleDataBase.resetUpdateMan();
        pSSysUserRoleDataBase.resetUserCat();
        pSSysUserRoleDataBase.resetUserTag();
        pSSysUserRoleDataBase.resetUserTag2();
        pSSysUserRoleDataBase.resetUserTag3();
        pSSysUserRoleDataBase.resetUserTag4();
        pSSysUserRoleDataBase.resetValidFlag();
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
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEUserRoleIdDirty()) {
            hashMap.put(FIELD_PSDEUSERROLEID, this.getPSDEUserRoleId());
        }
        if (!bl || this.isPSDEUserRoleNameDirty()) {
            hashMap.put(FIELD_PSDEUSERROLENAME, this.getPSDEUserRoleName());
        }
        if (!bl || this.isPSSysOPPrivIdDirty()) {
            hashMap.put(FIELD_PSSYSOPPRIVID, this.getPSSysOPPrivId());
        }
        if (!bl || this.isPSSysOPPrivNameDirty()) {
            hashMap.put(FIELD_PSSYSOPPRIVNAME, this.getPSSysOPPrivName());
        }
        if (!bl || this.isPSSysUserRoleDataIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERROLEDATAID, this.getPSSysUserRoleDataId());
        }
        if (!bl || this.isPSSysUserRoleDataNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERROLEDATANAME, this.getPSSysUserRoleDataName());
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
        return PSSysUserRoleDataBase.get(this, n);
    }

    private static Object get(PSSysUserRoleDataBase pSSysUserRoleDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserRoleDataBase.getCreateDate();
            }
            case 1: {
                return pSSysUserRoleDataBase.getCreateMan();
            }
            case 2: {
                return pSSysUserRoleDataBase.getMemo();
            }
            case 3: {
                return pSSysUserRoleDataBase.getPSDEId();
            }
            case 4: {
                return pSSysUserRoleDataBase.getPSDEName();
            }
            case 5: {
                return pSSysUserRoleDataBase.getPSDEUserRoleId();
            }
            case 6: {
                return pSSysUserRoleDataBase.getPSDEUserRoleName();
            }
            case 7: {
                return pSSysUserRoleDataBase.getPSSysOPPrivId();
            }
            case 8: {
                return pSSysUserRoleDataBase.getPSSysOPPrivName();
            }
            case 9: {
                return pSSysUserRoleDataBase.getPSSysUserRoleDataId();
            }
            case 10: {
                return pSSysUserRoleDataBase.getPSSysUserRoleDataName();
            }
            case 11: {
                return pSSysUserRoleDataBase.getUpdateDate();
            }
            case 12: {
                return pSSysUserRoleDataBase.getUpdateMan();
            }
            case 13: {
                return pSSysUserRoleDataBase.getUserCat();
            }
            case 14: {
                return pSSysUserRoleDataBase.getUserTag();
            }
            case 15: {
                return pSSysUserRoleDataBase.getUserTag2();
            }
            case 16: {
                return pSSysUserRoleDataBase.getUserTag3();
            }
            case 17: {
                return pSSysUserRoleDataBase.getUserTag4();
            }
            case 18: {
                return pSSysUserRoleDataBase.getValidFlag();
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
        PSSysUserRoleDataBase.set(this, n, object);
    }

    private static void set(PSSysUserRoleDataBase pSSysUserRoleDataBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserRoleDataBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysUserRoleDataBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUserRoleDataBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUserRoleDataBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUserRoleDataBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUserRoleDataBase.setPSDEUserRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUserRoleDataBase.setPSDEUserRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUserRoleDataBase.setPSSysOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUserRoleDataBase.setPSSysOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUserRoleDataBase.setPSSysUserRoleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUserRoleDataBase.setPSSysUserRoleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUserRoleDataBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysUserRoleDataBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUserRoleDataBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUserRoleDataBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUserRoleDataBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUserRoleDataBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUserRoleDataBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUserRoleDataBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysUserRoleDataBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUserRoleDataBase pSSysUserRoleDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserRoleDataBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysUserRoleDataBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysUserRoleDataBase.getMemo() == null;
            }
            case 3: {
                return pSSysUserRoleDataBase.getPSDEId() == null;
            }
            case 4: {
                return pSSysUserRoleDataBase.getPSDEName() == null;
            }
            case 5: {
                return pSSysUserRoleDataBase.getPSDEUserRoleId() == null;
            }
            case 6: {
                return pSSysUserRoleDataBase.getPSDEUserRoleName() == null;
            }
            case 7: {
                return pSSysUserRoleDataBase.getPSSysOPPrivId() == null;
            }
            case 8: {
                return pSSysUserRoleDataBase.getPSSysOPPrivName() == null;
            }
            case 9: {
                return pSSysUserRoleDataBase.getPSSysUserRoleDataId() == null;
            }
            case 10: {
                return pSSysUserRoleDataBase.getPSSysUserRoleDataName() == null;
            }
            case 11: {
                return pSSysUserRoleDataBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSysUserRoleDataBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSysUserRoleDataBase.getUserCat() == null;
            }
            case 14: {
                return pSSysUserRoleDataBase.getUserTag() == null;
            }
            case 15: {
                return pSSysUserRoleDataBase.getUserTag2() == null;
            }
            case 16: {
                return pSSysUserRoleDataBase.getUserTag3() == null;
            }
            case 17: {
                return pSSysUserRoleDataBase.getUserTag4() == null;
            }
            case 18: {
                return pSSysUserRoleDataBase.getValidFlag() == null;
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
        return PSSysUserRoleDataBase.contains(this, n);
    }

    private static boolean contains(PSSysUserRoleDataBase pSSysUserRoleDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserRoleDataBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysUserRoleDataBase.isCreateManDirty();
            }
            case 2: {
                return pSSysUserRoleDataBase.isMemoDirty();
            }
            case 3: {
                return pSSysUserRoleDataBase.isPSDEIdDirty();
            }
            case 4: {
                return pSSysUserRoleDataBase.isPSDENameDirty();
            }
            case 5: {
                return pSSysUserRoleDataBase.isPSDEUserRoleIdDirty();
            }
            case 6: {
                return pSSysUserRoleDataBase.isPSDEUserRoleNameDirty();
            }
            case 7: {
                return pSSysUserRoleDataBase.isPSSysOPPrivIdDirty();
            }
            case 8: {
                return pSSysUserRoleDataBase.isPSSysOPPrivNameDirty();
            }
            case 9: {
                return pSSysUserRoleDataBase.isPSSysUserRoleDataIdDirty();
            }
            case 10: {
                return pSSysUserRoleDataBase.isPSSysUserRoleDataNameDirty();
            }
            case 11: {
                return pSSysUserRoleDataBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSysUserRoleDataBase.isUpdateManDirty();
            }
            case 13: {
                return pSSysUserRoleDataBase.isUserCatDirty();
            }
            case 14: {
                return pSSysUserRoleDataBase.isUserTagDirty();
            }
            case 15: {
                return pSSysUserRoleDataBase.isUserTag2Dirty();
            }
            case 16: {
                return pSSysUserRoleDataBase.isUserTag3Dirty();
            }
            case 17: {
                return pSSysUserRoleDataBase.isUserTag4Dirty();
            }
            case 18: {
                return pSSysUserRoleDataBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUserRoleDataBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUserRoleDataBase pSSysUserRoleDataBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUserRoleDataBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getPSDEUserRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuserroleid", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getPSDEUserRoleId()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getPSDEUserRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuserrolename", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getPSDEUserRoleName()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getPSSysOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysopprivid", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getPSSysOPPrivId()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getPSSysOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysopprivname", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getPSSysOPPrivName()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getPSSysUserRoleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserroledataid", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getPSSysUserRoleDataId()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getPSSysUserRoleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserroledataname", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getPSSysUserRoleDataName()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysUserRoleDataBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysUserRoleDataBase.getJSONValue((Object)pSSysUserRoleDataBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUserRoleDataBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUserRoleDataBase pSSysUserRoleDataBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUserRoleDataBase.getCreateDate() != null) {
            object = pSSysUserRoleDataBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserRoleDataBase.getCreateMan() != null) {
            object = pSSysUserRoleDataBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getMemo() != null) {
            object = pSSysUserRoleDataBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getPSDEId() != null) {
            object = pSSysUserRoleDataBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getPSDEName() != null) {
            object = pSSysUserRoleDataBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getPSDEUserRoleId() != null) {
            object = pSSysUserRoleDataBase.getPSDEUserRoleId();
            xmlNode.setAttribute(FIELD_PSDEUSERROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getPSDEUserRoleName() != null) {
            object = pSSysUserRoleDataBase.getPSDEUserRoleName();
            xmlNode.setAttribute(FIELD_PSDEUSERROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getPSSysOPPrivId() != null) {
            object = pSSysUserRoleDataBase.getPSSysOPPrivId();
            xmlNode.setAttribute(FIELD_PSSYSOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getPSSysOPPrivName() != null) {
            object = pSSysUserRoleDataBase.getPSSysOPPrivName();
            xmlNode.setAttribute(FIELD_PSSYSOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getPSSysUserRoleDataId() != null) {
            object = pSSysUserRoleDataBase.getPSSysUserRoleDataId();
            xmlNode.setAttribute(FIELD_PSSYSUSERROLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getPSSysUserRoleDataName() != null) {
            object = pSSysUserRoleDataBase.getPSSysUserRoleDataName();
            xmlNode.setAttribute(FIELD_PSSYSUSERROLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getUpdateDate() != null) {
            object = pSSysUserRoleDataBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserRoleDataBase.getUpdateMan() != null) {
            object = pSSysUserRoleDataBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getUserCat() != null) {
            object = pSSysUserRoleDataBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getUserTag() != null) {
            object = pSSysUserRoleDataBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getUserTag2() != null) {
            object = pSSysUserRoleDataBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getUserTag3() != null) {
            object = pSSysUserRoleDataBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getUserTag4() != null) {
            object = pSSysUserRoleDataBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleDataBase.getValidFlag() != null) {
            object = pSSysUserRoleDataBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUserRoleDataBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUserRoleDataBase pSSysUserRoleDataBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUserRoleDataBase.isCreateDateDirty() && (bl || pSSysUserRoleDataBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUserRoleDataBase.getCreateDate());
        }
        if (pSSysUserRoleDataBase.isCreateManDirty() && (bl || pSSysUserRoleDataBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUserRoleDataBase.getCreateMan());
        }
        if (pSSysUserRoleDataBase.isMemoDirty() && (bl || pSSysUserRoleDataBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUserRoleDataBase.getMemo());
        }
        if (pSSysUserRoleDataBase.isPSDEIdDirty() && (bl || pSSysUserRoleDataBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysUserRoleDataBase.getPSDEId());
        }
        if (pSSysUserRoleDataBase.isPSDENameDirty() && (bl || pSSysUserRoleDataBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysUserRoleDataBase.getPSDEName());
        }
        if (pSSysUserRoleDataBase.isPSDEUserRoleIdDirty() && (bl || pSSysUserRoleDataBase.getPSDEUserRoleId() != null)) {
            iDataObject.set(FIELD_PSDEUSERROLEID, (Object)pSSysUserRoleDataBase.getPSDEUserRoleId());
        }
        if (pSSysUserRoleDataBase.isPSDEUserRoleNameDirty() && (bl || pSSysUserRoleDataBase.getPSDEUserRoleName() != null)) {
            iDataObject.set(FIELD_PSDEUSERROLENAME, (Object)pSSysUserRoleDataBase.getPSDEUserRoleName());
        }
        if (pSSysUserRoleDataBase.isPSSysOPPrivIdDirty() && (bl || pSSysUserRoleDataBase.getPSSysOPPrivId() != null)) {
            iDataObject.set(FIELD_PSSYSOPPRIVID, (Object)pSSysUserRoleDataBase.getPSSysOPPrivId());
        }
        if (pSSysUserRoleDataBase.isPSSysOPPrivNameDirty() && (bl || pSSysUserRoleDataBase.getPSSysOPPrivName() != null)) {
            iDataObject.set(FIELD_PSSYSOPPRIVNAME, (Object)pSSysUserRoleDataBase.getPSSysOPPrivName());
        }
        if (pSSysUserRoleDataBase.isPSSysUserRoleDataIdDirty() && (bl || pSSysUserRoleDataBase.getPSSysUserRoleDataId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERROLEDATAID, (Object)pSSysUserRoleDataBase.getPSSysUserRoleDataId());
        }
        if (pSSysUserRoleDataBase.isPSSysUserRoleDataNameDirty() && (bl || pSSysUserRoleDataBase.getPSSysUserRoleDataName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERROLEDATANAME, (Object)pSSysUserRoleDataBase.getPSSysUserRoleDataName());
        }
        if (pSSysUserRoleDataBase.isUpdateDateDirty() && (bl || pSSysUserRoleDataBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUserRoleDataBase.getUpdateDate());
        }
        if (pSSysUserRoleDataBase.isUpdateManDirty() && (bl || pSSysUserRoleDataBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUserRoleDataBase.getUpdateMan());
        }
        if (pSSysUserRoleDataBase.isUserCatDirty() && (bl || pSSysUserRoleDataBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUserRoleDataBase.getUserCat());
        }
        if (pSSysUserRoleDataBase.isUserTagDirty() && (bl || pSSysUserRoleDataBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUserRoleDataBase.getUserTag());
        }
        if (pSSysUserRoleDataBase.isUserTag2Dirty() && (bl || pSSysUserRoleDataBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUserRoleDataBase.getUserTag2());
        }
        if (pSSysUserRoleDataBase.isUserTag3Dirty() && (bl || pSSysUserRoleDataBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUserRoleDataBase.getUserTag3());
        }
        if (pSSysUserRoleDataBase.isUserTag4Dirty() && (bl || pSSysUserRoleDataBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUserRoleDataBase.getUserTag4());
        }
        if (pSSysUserRoleDataBase.isValidFlagDirty() && (bl || pSSysUserRoleDataBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysUserRoleDataBase.getValidFlag());
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
        return PSSysUserRoleDataBase.remove(this, n);
    }

    private static boolean remove(PSSysUserRoleDataBase pSSysUserRoleDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserRoleDataBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysUserRoleDataBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysUserRoleDataBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysUserRoleDataBase.resetPSDEId();
                return true;
            }
            case 4: {
                pSSysUserRoleDataBase.resetPSDEName();
                return true;
            }
            case 5: {
                pSSysUserRoleDataBase.resetPSDEUserRoleId();
                return true;
            }
            case 6: {
                pSSysUserRoleDataBase.resetPSDEUserRoleName();
                return true;
            }
            case 7: {
                pSSysUserRoleDataBase.resetPSSysOPPrivId();
                return true;
            }
            case 8: {
                pSSysUserRoleDataBase.resetPSSysOPPrivName();
                return true;
            }
            case 9: {
                pSSysUserRoleDataBase.resetPSSysUserRoleDataId();
                return true;
            }
            case 10: {
                pSSysUserRoleDataBase.resetPSSysUserRoleDataName();
                return true;
            }
            case 11: {
                pSSysUserRoleDataBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSysUserRoleDataBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSysUserRoleDataBase.resetUserCat();
                return true;
            }
            case 14: {
                pSSysUserRoleDataBase.resetUserTag();
                return true;
            }
            case 15: {
                pSSysUserRoleDataBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSSysUserRoleDataBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSSysUserRoleDataBase.resetUserTag4();
                return true;
            }
            case 18: {
                pSSysUserRoleDataBase.resetValidFlag();
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
    public PSDEUserRole getPSDEUserRole() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRole();
        }
        if (this.getPSDEUserRoleId() == null) {
            return null;
        }
        Integer n = this.objPSDEUserRoleLock;
        synchronized (n) {
            if (this.psdeuserrole != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUserRoleId(), (Object)this.psdeuserrole.getPSDEUserRoleId()) != 0L) {
                this.psdeuserrole = null;
            }
            if (this.psdeuserrole == null) {
                PSDEUserRole pSDEUserRole = new PSDEUserRole();
                pSDEUserRole.setPSDEUserRoleId(this.getPSDEUserRoleId());
                PSDEUserRoleService pSDEUserRoleService = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, (SessionFactory)this.getSessionFactory());
                pSDEUserRoleService.autoGet(pSDEUserRole);
                this.psdeuserrole = pSDEUserRole;
            }
            return this.psdeuserrole;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysOPPriv getPSSysOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPriv();
        }
        if (this.getPSSysOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSSysOPPrivLock;
        synchronized (n) {
            if (this.pssysoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysOPPrivId(), (Object)this.pssysoppriv.getPSSysOPPrivId()) != 0L) {
                this.pssysoppriv = null;
            }
            if (this.pssysoppriv == null) {
                PSSysOPPriv pSSysOPPriv = new PSSysOPPriv();
                pSSysOPPriv.setPSSysOPPrivId(this.getPSSysOPPrivId());
                PSSysOPPrivService pSSysOPPrivService = (PSSysOPPrivService)ServiceGlobal.getService(PSSysOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSSysOPPrivService.autoGet(pSSysOPPriv);
                this.pssysoppriv = pSSysOPPriv;
            }
            return this.pssysoppriv;
        }
    }

    private PSSysUserRoleDataBase getProxyEntity() {
        return this.proxyPSSysUserRoleDataBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUserRoleDataBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUserRoleDataBase) {
            this.proxyPSSysUserRoleDataBase = (PSSysUserRoleDataBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleDataService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEID, 3);
        fieldIndexMap.put(FIELD_PSDENAME, 4);
        fieldIndexMap.put(FIELD_PSDEUSERROLEID, 5);
        fieldIndexMap.put(FIELD_PSDEUSERROLENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSOPPRIVID, 7);
        fieldIndexMap.put(FIELD_PSSYSOPPRIVNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSUSERROLEDATAID, 9);
        fieldIndexMap.put(FIELD_PSSYSUSERROLEDATANAME, 10);
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

