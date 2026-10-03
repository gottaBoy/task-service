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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPriv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserRoleResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUserRoleResBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String FIELD_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PSSYSUSERROLERESID = "PSSYSUSERROLERESID";
    public static final String FIELD_PSSYSUSERROLERESNAME = "PSSYSUSERROLERESNAME";
    public static final String FIELD_RESMODEL = "RESMODEL";
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
    private static final int INDEX_PSSYSOPPRIVID = 3;
    private static final int INDEX_PSSYSOPPRIVNAME = 4;
    private static final int INDEX_PSSYSUNIRESID = 5;
    private static final int INDEX_PSSYSUNIRESNAME = 6;
    private static final int INDEX_PSSYSUSERROLERESID = 7;
    private static final int INDEX_PSSYSUSERROLERESNAME = 8;
    private static final int INDEX_RESMODEL = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUserRoleResBase proxyPSSysUserRoleResBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysopprividDirtyFlag = false;
    private boolean pssysopprivnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pssysuserroleresidDirtyFlag = false;
    private boolean pssysuserroleresnameDirtyFlag = false;
    private boolean resmodelDirtyFlag = false;
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
    @Column(name="pssysopprivid")
    private String pssysopprivid;
    @Column(name="pssysopprivname")
    private String pssysopprivname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="pssysuserroleresid")
    private String pssysuserroleresid;
    @Column(name="pssysuserroleresname")
    private String pssysuserroleresname;
    @Column(name="resmodel")
    private String resmodel;
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
    private Integer objPSSysOPPrivLock = new Integer(1);
    private PSSysOPPriv pssysoppriv = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;

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

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
    }

    public void setPSSysUserRoleResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserRoleResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserroleresid = string;
        this.pssysuserroleresidDirtyFlag = true;
    }

    public String getPSSysUserRoleResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserRoleResId();
        }
        return this.pssysuserroleresid;
    }

    public boolean isPSSysUserRoleResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserRoleResIdDirty();
        }
        return this.pssysuserroleresidDirtyFlag;
    }

    public void resetPSSysUserRoleResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserRoleResId();
            return;
        }
        this.pssysuserroleresidDirtyFlag = false;
        this.pssysuserroleresid = null;
    }

    public void setPSSysUserRoleResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserRoleResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserroleresname = string;
        this.pssysuserroleresnameDirtyFlag = true;
    }

    public String getPSSysUserRoleResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserRoleResName();
        }
        return this.pssysuserroleresname;
    }

    public boolean isPSSysUserRoleResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserRoleResNameDirty();
        }
        return this.pssysuserroleresnameDirtyFlag;
    }

    public void resetPSSysUserRoleResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserRoleResName();
            return;
        }
        this.pssysuserroleresnameDirtyFlag = false;
        this.pssysuserroleresname = null;
    }

    public void setResModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resmodel = string;
        this.resmodelDirtyFlag = true;
    }

    public String getResModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResModel();
        }
        return this.resmodel;
    }

    public boolean isResModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResModelDirty();
        }
        return this.resmodelDirtyFlag;
    }

    public void resetResModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResModel();
            return;
        }
        this.resmodelDirtyFlag = false;
        this.resmodel = null;
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
        PSSysUserRoleResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUserRoleResBase pSSysUserRoleResBase) {
        pSSysUserRoleResBase.resetCreateDate();
        pSSysUserRoleResBase.resetCreateMan();
        pSSysUserRoleResBase.resetMemo();
        pSSysUserRoleResBase.resetPSSysOPPrivId();
        pSSysUserRoleResBase.resetPSSysOPPrivName();
        pSSysUserRoleResBase.resetPSSysUniResId();
        pSSysUserRoleResBase.resetPSSysUniResName();
        pSSysUserRoleResBase.resetPSSysUserRoleResId();
        pSSysUserRoleResBase.resetPSSysUserRoleResName();
        pSSysUserRoleResBase.resetResModel();
        pSSysUserRoleResBase.resetUpdateDate();
        pSSysUserRoleResBase.resetUpdateMan();
        pSSysUserRoleResBase.resetUserCat();
        pSSysUserRoleResBase.resetUserTag();
        pSSysUserRoleResBase.resetUserTag2();
        pSSysUserRoleResBase.resetUserTag3();
        pSSysUserRoleResBase.resetUserTag4();
        pSSysUserRoleResBase.resetValidFlag();
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
        if (!bl || this.isPSSysOPPrivIdDirty()) {
            hashMap.put(FIELD_PSSYSOPPRIVID, this.getPSSysOPPrivId());
        }
        if (!bl || this.isPSSysOPPrivNameDirty()) {
            hashMap.put(FIELD_PSSYSOPPRIVNAME, this.getPSSysOPPrivName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isPSSysUserRoleResIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERROLERESID, this.getPSSysUserRoleResId());
        }
        if (!bl || this.isPSSysUserRoleResNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERROLERESNAME, this.getPSSysUserRoleResName());
        }
        if (!bl || this.isResModelDirty()) {
            hashMap.put(FIELD_RESMODEL, this.getResModel());
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
        return PSSysUserRoleResBase.get(this, n);
    }

    private static Object get(PSSysUserRoleResBase pSSysUserRoleResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserRoleResBase.getCreateDate();
            }
            case 1: {
                return pSSysUserRoleResBase.getCreateMan();
            }
            case 2: {
                return pSSysUserRoleResBase.getMemo();
            }
            case 3: {
                return pSSysUserRoleResBase.getPSSysOPPrivId();
            }
            case 4: {
                return pSSysUserRoleResBase.getPSSysOPPrivName();
            }
            case 5: {
                return pSSysUserRoleResBase.getPSSysUniResId();
            }
            case 6: {
                return pSSysUserRoleResBase.getPSSysUniResName();
            }
            case 7: {
                return pSSysUserRoleResBase.getPSSysUserRoleResId();
            }
            case 8: {
                return pSSysUserRoleResBase.getPSSysUserRoleResName();
            }
            case 9: {
                return pSSysUserRoleResBase.getResModel();
            }
            case 10: {
                return pSSysUserRoleResBase.getUpdateDate();
            }
            case 11: {
                return pSSysUserRoleResBase.getUpdateMan();
            }
            case 12: {
                return pSSysUserRoleResBase.getUserCat();
            }
            case 13: {
                return pSSysUserRoleResBase.getUserTag();
            }
            case 14: {
                return pSSysUserRoleResBase.getUserTag2();
            }
            case 15: {
                return pSSysUserRoleResBase.getUserTag3();
            }
            case 16: {
                return pSSysUserRoleResBase.getUserTag4();
            }
            case 17: {
                return pSSysUserRoleResBase.getValidFlag();
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
        PSSysUserRoleResBase.set(this, n, object);
    }

    private static void set(PSSysUserRoleResBase pSSysUserRoleResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserRoleResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysUserRoleResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUserRoleResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUserRoleResBase.setPSSysOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUserRoleResBase.setPSSysOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUserRoleResBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUserRoleResBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUserRoleResBase.setPSSysUserRoleResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUserRoleResBase.setPSSysUserRoleResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUserRoleResBase.setResModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUserRoleResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysUserRoleResBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUserRoleResBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUserRoleResBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUserRoleResBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUserRoleResBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUserRoleResBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUserRoleResBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysUserRoleResBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUserRoleResBase pSSysUserRoleResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserRoleResBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysUserRoleResBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysUserRoleResBase.getMemo() == null;
            }
            case 3: {
                return pSSysUserRoleResBase.getPSSysOPPrivId() == null;
            }
            case 4: {
                return pSSysUserRoleResBase.getPSSysOPPrivName() == null;
            }
            case 5: {
                return pSSysUserRoleResBase.getPSSysUniResId() == null;
            }
            case 6: {
                return pSSysUserRoleResBase.getPSSysUniResName() == null;
            }
            case 7: {
                return pSSysUserRoleResBase.getPSSysUserRoleResId() == null;
            }
            case 8: {
                return pSSysUserRoleResBase.getPSSysUserRoleResName() == null;
            }
            case 9: {
                return pSSysUserRoleResBase.getResModel() == null;
            }
            case 10: {
                return pSSysUserRoleResBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysUserRoleResBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysUserRoleResBase.getUserCat() == null;
            }
            case 13: {
                return pSSysUserRoleResBase.getUserTag() == null;
            }
            case 14: {
                return pSSysUserRoleResBase.getUserTag2() == null;
            }
            case 15: {
                return pSSysUserRoleResBase.getUserTag3() == null;
            }
            case 16: {
                return pSSysUserRoleResBase.getUserTag4() == null;
            }
            case 17: {
                return pSSysUserRoleResBase.getValidFlag() == null;
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
        return PSSysUserRoleResBase.contains(this, n);
    }

    private static boolean contains(PSSysUserRoleResBase pSSysUserRoleResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserRoleResBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysUserRoleResBase.isCreateManDirty();
            }
            case 2: {
                return pSSysUserRoleResBase.isMemoDirty();
            }
            case 3: {
                return pSSysUserRoleResBase.isPSSysOPPrivIdDirty();
            }
            case 4: {
                return pSSysUserRoleResBase.isPSSysOPPrivNameDirty();
            }
            case 5: {
                return pSSysUserRoleResBase.isPSSysUniResIdDirty();
            }
            case 6: {
                return pSSysUserRoleResBase.isPSSysUniResNameDirty();
            }
            case 7: {
                return pSSysUserRoleResBase.isPSSysUserRoleResIdDirty();
            }
            case 8: {
                return pSSysUserRoleResBase.isPSSysUserRoleResNameDirty();
            }
            case 9: {
                return pSSysUserRoleResBase.isResModelDirty();
            }
            case 10: {
                return pSSysUserRoleResBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysUserRoleResBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysUserRoleResBase.isUserCatDirty();
            }
            case 13: {
                return pSSysUserRoleResBase.isUserTagDirty();
            }
            case 14: {
                return pSSysUserRoleResBase.isUserTag2Dirty();
            }
            case 15: {
                return pSSysUserRoleResBase.isUserTag3Dirty();
            }
            case 16: {
                return pSSysUserRoleResBase.isUserTag4Dirty();
            }
            case 17: {
                return pSSysUserRoleResBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUserRoleResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUserRoleResBase pSSysUserRoleResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUserRoleResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getPSSysOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysopprivid", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getPSSysOPPrivId()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getPSSysOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysopprivname", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getPSSysOPPrivName()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getPSSysUserRoleResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserroleresid", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getPSSysUserRoleResId()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getPSSysUserRoleResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserroleresname", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getPSSysUserRoleResName()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getResModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resmodel", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getResModel()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysUserRoleResBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysUserRoleResBase.getJSONValue((Object)pSSysUserRoleResBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUserRoleResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUserRoleResBase pSSysUserRoleResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUserRoleResBase.getCreateDate() != null) {
            object = pSSysUserRoleResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserRoleResBase.getCreateMan() != null) {
            object = pSSysUserRoleResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getMemo() != null) {
            object = pSSysUserRoleResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getPSSysOPPrivId() != null) {
            object = pSSysUserRoleResBase.getPSSysOPPrivId();
            xmlNode.setAttribute(FIELD_PSSYSOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getPSSysOPPrivName() != null) {
            object = pSSysUserRoleResBase.getPSSysOPPrivName();
            xmlNode.setAttribute(FIELD_PSSYSOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getPSSysUniResId() != null) {
            object = pSSysUserRoleResBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getPSSysUniResName() != null) {
            object = pSSysUserRoleResBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getPSSysUserRoleResId() != null) {
            object = pSSysUserRoleResBase.getPSSysUserRoleResId();
            xmlNode.setAttribute(FIELD_PSSYSUSERROLERESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getPSSysUserRoleResName() != null) {
            object = pSSysUserRoleResBase.getPSSysUserRoleResName();
            xmlNode.setAttribute(FIELD_PSSYSUSERROLERESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getResModel() != null) {
            object = pSSysUserRoleResBase.getResModel();
            xmlNode.setAttribute(FIELD_RESMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getUpdateDate() != null) {
            object = pSSysUserRoleResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserRoleResBase.getUpdateMan() != null) {
            object = pSSysUserRoleResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getUserCat() != null) {
            object = pSSysUserRoleResBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getUserTag() != null) {
            object = pSSysUserRoleResBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getUserTag2() != null) {
            object = pSSysUserRoleResBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getUserTag3() != null) {
            object = pSSysUserRoleResBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getUserTag4() != null) {
            object = pSSysUserRoleResBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserRoleResBase.getValidFlag() != null) {
            object = pSSysUserRoleResBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUserRoleResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUserRoleResBase pSSysUserRoleResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUserRoleResBase.isCreateDateDirty() && (bl || pSSysUserRoleResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUserRoleResBase.getCreateDate());
        }
        if (pSSysUserRoleResBase.isCreateManDirty() && (bl || pSSysUserRoleResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUserRoleResBase.getCreateMan());
        }
        if (pSSysUserRoleResBase.isMemoDirty() && (bl || pSSysUserRoleResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUserRoleResBase.getMemo());
        }
        if (pSSysUserRoleResBase.isPSSysOPPrivIdDirty() && (bl || pSSysUserRoleResBase.getPSSysOPPrivId() != null)) {
            iDataObject.set(FIELD_PSSYSOPPRIVID, (Object)pSSysUserRoleResBase.getPSSysOPPrivId());
        }
        if (pSSysUserRoleResBase.isPSSysOPPrivNameDirty() && (bl || pSSysUserRoleResBase.getPSSysOPPrivName() != null)) {
            iDataObject.set(FIELD_PSSYSOPPRIVNAME, (Object)pSSysUserRoleResBase.getPSSysOPPrivName());
        }
        if (pSSysUserRoleResBase.isPSSysUniResIdDirty() && (bl || pSSysUserRoleResBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSSysUserRoleResBase.getPSSysUniResId());
        }
        if (pSSysUserRoleResBase.isPSSysUniResNameDirty() && (bl || pSSysUserRoleResBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSSysUserRoleResBase.getPSSysUniResName());
        }
        if (pSSysUserRoleResBase.isPSSysUserRoleResIdDirty() && (bl || pSSysUserRoleResBase.getPSSysUserRoleResId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERROLERESID, (Object)pSSysUserRoleResBase.getPSSysUserRoleResId());
        }
        if (pSSysUserRoleResBase.isPSSysUserRoleResNameDirty() && (bl || pSSysUserRoleResBase.getPSSysUserRoleResName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERROLERESNAME, (Object)pSSysUserRoleResBase.getPSSysUserRoleResName());
        }
        if (pSSysUserRoleResBase.isResModelDirty() && (bl || pSSysUserRoleResBase.getResModel() != null)) {
            iDataObject.set(FIELD_RESMODEL, (Object)pSSysUserRoleResBase.getResModel());
        }
        if (pSSysUserRoleResBase.isUpdateDateDirty() && (bl || pSSysUserRoleResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUserRoleResBase.getUpdateDate());
        }
        if (pSSysUserRoleResBase.isUpdateManDirty() && (bl || pSSysUserRoleResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUserRoleResBase.getUpdateMan());
        }
        if (pSSysUserRoleResBase.isUserCatDirty() && (bl || pSSysUserRoleResBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUserRoleResBase.getUserCat());
        }
        if (pSSysUserRoleResBase.isUserTagDirty() && (bl || pSSysUserRoleResBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUserRoleResBase.getUserTag());
        }
        if (pSSysUserRoleResBase.isUserTag2Dirty() && (bl || pSSysUserRoleResBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUserRoleResBase.getUserTag2());
        }
        if (pSSysUserRoleResBase.isUserTag3Dirty() && (bl || pSSysUserRoleResBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUserRoleResBase.getUserTag3());
        }
        if (pSSysUserRoleResBase.isUserTag4Dirty() && (bl || pSSysUserRoleResBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUserRoleResBase.getUserTag4());
        }
        if (pSSysUserRoleResBase.isValidFlagDirty() && (bl || pSSysUserRoleResBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysUserRoleResBase.getValidFlag());
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
        return PSSysUserRoleResBase.remove(this, n);
    }

    private static boolean remove(PSSysUserRoleResBase pSSysUserRoleResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserRoleResBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysUserRoleResBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysUserRoleResBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysUserRoleResBase.resetPSSysOPPrivId();
                return true;
            }
            case 4: {
                pSSysUserRoleResBase.resetPSSysOPPrivName();
                return true;
            }
            case 5: {
                pSSysUserRoleResBase.resetPSSysUniResId();
                return true;
            }
            case 6: {
                pSSysUserRoleResBase.resetPSSysUniResName();
                return true;
            }
            case 7: {
                pSSysUserRoleResBase.resetPSSysUserRoleResId();
                return true;
            }
            case 8: {
                pSSysUserRoleResBase.resetPSSysUserRoleResName();
                return true;
            }
            case 9: {
                pSSysUserRoleResBase.resetResModel();
                return true;
            }
            case 10: {
                pSSysUserRoleResBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysUserRoleResBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysUserRoleResBase.resetUserCat();
                return true;
            }
            case 13: {
                pSSysUserRoleResBase.resetUserTag();
                return true;
            }
            case 14: {
                pSSysUserRoleResBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSSysUserRoleResBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSSysUserRoleResBase.resetUserTag4();
                return true;
            }
            case 17: {
                pSSysUserRoleResBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet(pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    private PSSysUserRoleResBase getProxyEntity() {
        return this.proxyPSSysUserRoleResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUserRoleResBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUserRoleResBase) {
            this.proxyPSSysUserRoleResBase = (PSSysUserRoleResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSOPPRIVID, 3);
        fieldIndexMap.put(FIELD_PSSYSOPPRIVNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 5);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSUSERROLERESID, 7);
        fieldIndexMap.put(FIELD_PSSYSUSERROLERESNAME, 8);
        fieldIndexMap.put(FIELD_RESMODEL, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

