/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.ibizsys.psrt.srv.common.entity.UserRole;
import net.ibizsys.psrt.srv.common.service.UserObjectService;
import net.ibizsys.psrt.srv.common.service.UserRoleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserRoleDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_USERROLENAME = "UESRROLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USEROBJECTID = "USEROBJECTID";
    public static final String FIELD_USEROBJECTNAME = "USEROBJECTNAME";
    public static final String FIELD_USERROLEDETAILID = "USERROLEDETAILID";
    public static final String FIELD_USERROLEDETAILNAME = "USERROLEDETAILNAME";
    public static final String FIELD_USERROLEID = "USERROLEID";
    public static final String FIELD_USERTAG = "USERTAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_RESERVER = 2;
    private static final int INDEX_RESERVER2 = 3;
    private static final int INDEX_RESERVER3 = 4;
    private static final int INDEX_RESERVER4 = 5;
    private static final int INDEX_USERROLENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_USERDATA = 9;
    private static final int INDEX_USERDATA2 = 10;
    private static final int INDEX_USEROBJECTID = 11;
    private static final int INDEX_USEROBJECTNAME = 12;
    private static final int INDEX_USERROLEDETAILID = 13;
    private static final int INDEX_USERROLEDETAILNAME = 14;
    private static final int INDEX_USERROLEID = 15;
    private static final int INDEX_USERTAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserRoleDetailBase proxyUserRoleDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean userrolenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userobjectidDirtyFlag = false;
    private boolean userobjectnameDirtyFlag = false;
    private boolean userroledetailidDirtyFlag = false;
    private boolean userroledetailnameDirtyFlag = false;
    private boolean userroleidDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="userrolename")
    private String userrolename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userobjectid")
    private String userobjectid;
    @Column(name="userobjectname")
    private String userobjectname;
    @Column(name="userroledetailid")
    private String userroledetailid;
    @Column(name="userroledetailname")
    private String userroledetailname;
    @Column(name="userroleid")
    private String userroleid;
    @Column(name="usertag")
    private String usertag;
    private Integer objUserObjectLock = new Integer(1);
    private UserObject userobject = null;
    private Integer objUserRoleLock = new Integer(1);
    private UserRole userrole = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_RESERVER, 2);
        fieldIndexMap.put(FIELD_RESERVER2, 3);
        fieldIndexMap.put(FIELD_RESERVER3, 4);
        fieldIndexMap.put(FIELD_RESERVER4, 5);
        fieldIndexMap.put(FIELD_USERROLENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_USERDATA, 9);
        fieldIndexMap.put(FIELD_USERDATA2, 10);
        fieldIndexMap.put(FIELD_USEROBJECTID, 11);
        fieldIndexMap.put(FIELD_USEROBJECTNAME, 12);
        fieldIndexMap.put(FIELD_USERROLEDETAILID, 13);
        fieldIndexMap.put(FIELD_USERROLEDETAILNAME, 14);
        fieldIndexMap.put(FIELD_USERROLEID, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }

    public void setUserRoleName(String userrolename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleName(userrolename);
            return;
        }
        if (userrolename != null && (userrolename = StringHelper.trimRight(userrolename)).length() == 0) {
            userrolename = null;
        }
        this.userrolename = userrolename;
        this.userrolenameDirtyFlag = true;
    }

    public String getUserRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleName();
        }
        return this.userrolename;
    }

    public boolean isUserRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleNameDirty();
        }
        return this.userrolenameDirtyFlag;
    }

    public void resetUserRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleName();
            return;
        }
        this.userrolenameDirtyFlag = false;
        this.userrolename = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setUserData(String userdata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if (userdata != null && (userdata = StringHelper.trimRight(userdata)).length() == 0) {
            userdata = null;
        }
        this.userdata = userdata;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String userdata2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if (userdata2 != null && (userdata2 = StringHelper.trimRight(userdata2)).length() == 0) {
            userdata2 = null;
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    public void setUserObjectId(String userobjectid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserObjectId(userobjectid);
            return;
        }
        if (userobjectid != null && (userobjectid = StringHelper.trimRight(userobjectid)).length() == 0) {
            userobjectid = null;
        }
        this.userobjectid = userobjectid;
        this.userobjectidDirtyFlag = true;
    }

    public String getUserObjectId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserObjectId();
        }
        return this.userobjectid;
    }

    public boolean isUserObjectIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserObjectIdDirty();
        }
        return this.userobjectidDirtyFlag;
    }

    public void resetUserObjectId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserObjectId();
            return;
        }
        this.userobjectidDirtyFlag = false;
        this.userobjectid = null;
    }

    public void setUserObjectName(String userobjectname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserObjectName(userobjectname);
            return;
        }
        if (userobjectname != null && (userobjectname = StringHelper.trimRight(userobjectname)).length() == 0) {
            userobjectname = null;
        }
        this.userobjectname = userobjectname;
        this.userobjectnameDirtyFlag = true;
    }

    public String getUserObjectName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserObjectName();
        }
        return this.userobjectname;
    }

    public boolean isUserObjectNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserObjectNameDirty();
        }
        return this.userobjectnameDirtyFlag;
    }

    public void resetUserObjectName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserObjectName();
            return;
        }
        this.userobjectnameDirtyFlag = false;
        this.userobjectname = null;
    }

    public void setUserRoleDetailId(String userroledetailid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDetailId(userroledetailid);
            return;
        }
        if (userroledetailid != null && (userroledetailid = StringHelper.trimRight(userroledetailid)).length() == 0) {
            userroledetailid = null;
        }
        this.userroledetailid = userroledetailid;
        this.userroledetailidDirtyFlag = true;
    }

    public String getUserRoleDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDetailId();
        }
        return this.userroledetailid;
    }

    public boolean isUserRoleDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDetailIdDirty();
        }
        return this.userroledetailidDirtyFlag;
    }

    public void resetUserRoleDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDetailId();
            return;
        }
        this.userroledetailidDirtyFlag = false;
        this.userroledetailid = null;
    }

    public void setUserRoleDetailName(String userroledetailname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDetailName(userroledetailname);
            return;
        }
        if (userroledetailname != null && (userroledetailname = StringHelper.trimRight(userroledetailname)).length() == 0) {
            userroledetailname = null;
        }
        this.userroledetailname = userroledetailname;
        this.userroledetailnameDirtyFlag = true;
    }

    public String getUserRoleDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDetailName();
        }
        return this.userroledetailname;
    }

    public boolean isUserRoleDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDetailNameDirty();
        }
        return this.userroledetailnameDirtyFlag;
    }

    public void resetUserRoleDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDetailName();
            return;
        }
        this.userroledetailnameDirtyFlag = false;
        this.userroledetailname = null;
    }

    public void setUserRoleId(String userroleid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleId(userroleid);
            return;
        }
        if (userroleid != null && (userroleid = StringHelper.trimRight(userroleid)).length() == 0) {
            userroleid = null;
        }
        this.userroleid = userroleid;
        this.userroleidDirtyFlag = true;
    }

    public String getUserRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleId();
        }
        return this.userroleid;
    }

    public boolean isUserRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleIdDirty();
        }
        return this.userroleidDirtyFlag;
    }

    public void resetUserRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleId();
            return;
        }
        this.userroleidDirtyFlag = false;
        this.userroleid = null;
    }

    public void setUserTag(String usertag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(usertag);
            return;
        }
        if (usertag != null && (usertag = StringHelper.trimRight(usertag)).length() == 0) {
            usertag = null;
        }
        this.usertag = usertag;
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

    @Override
    protected void onReset() {
        UserRoleDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserRoleDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUserRoleName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserObjectId();
        et.resetUserObjectName();
        et.resetUserRoleDetailId();
        et.resetUserRoleDetailName();
        et.resetUserRoleId();
        et.resetUserTag();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isUserRoleNameDirty()) {
            params.put(FIELD_USERROLENAME, this.getUserRoleName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDataDirty()) {
            params.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bDirtyOnly || this.isUserData2Dirty()) {
            params.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bDirtyOnly || this.isUserObjectIdDirty()) {
            params.put(FIELD_USEROBJECTID, this.getUserObjectId());
        }
        if (!bDirtyOnly || this.isUserObjectNameDirty()) {
            params.put(FIELD_USEROBJECTNAME, this.getUserObjectName());
        }
        if (!bDirtyOnly || this.isUserRoleDetailIdDirty()) {
            params.put(FIELD_USERROLEDETAILID, this.getUserRoleDetailId());
        }
        if (!bDirtyOnly || this.isUserRoleDetailNameDirty()) {
            params.put(FIELD_USERROLEDETAILNAME, this.getUserRoleDetailName());
        }
        if (!bDirtyOnly || this.isUserRoleIdDirty()) {
            params.put(FIELD_USERROLEID, this.getUserRoleId());
        }
        if (!bDirtyOnly || this.isUserTagDirty()) {
            params.put(FIELD_USERTAG, this.getUserTag());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return UserRoleDetailBase.get(this, index);
    }

    private static Object get(UserRoleDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getReserver();
            }
            case 3: {
                return et.getReserver2();
            }
            case 4: {
                return et.getReserver3();
            }
            case 5: {
                return et.getReserver4();
            }
            case 6: {
                return et.getUserRoleName();
            }
            case 7: {
                return et.getUpdateDate();
            }
            case 8: {
                return et.getUpdateMan();
            }
            case 9: {
                return et.getUserData();
            }
            case 10: {
                return et.getUserData2();
            }
            case 11: {
                return et.getUserObjectId();
            }
            case 12: {
                return et.getUserObjectName();
            }
            case 13: {
                return et.getUserRoleDetailId();
            }
            case 14: {
                return et.getUserRoleDetailName();
            }
            case 15: {
                return et.getUserRoleId();
            }
            case 16: {
                return et.getUserTag();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        UserRoleDetailBase.set(this, index, objValue);
    }

    private static void set(UserRoleDetailBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setUserRoleName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 8: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserObjectId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserObjectName(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUserRoleDetailId(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUserRoleDetailName(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserRoleId(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setUserTag(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return UserRoleDetailBase.isNull(this, index);
    }

    private static boolean isNull(UserRoleDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getReserver() == null;
            }
            case 3: {
                return et.getReserver2() == null;
            }
            case 4: {
                return et.getReserver3() == null;
            }
            case 5: {
                return et.getReserver4() == null;
            }
            case 6: {
                return et.getUserRoleName() == null;
            }
            case 7: {
                return et.getUpdateDate() == null;
            }
            case 8: {
                return et.getUpdateMan() == null;
            }
            case 9: {
                return et.getUserData() == null;
            }
            case 10: {
                return et.getUserData2() == null;
            }
            case 11: {
                return et.getUserObjectId() == null;
            }
            case 12: {
                return et.getUserObjectName() == null;
            }
            case 13: {
                return et.getUserRoleDetailId() == null;
            }
            case 14: {
                return et.getUserRoleDetailName() == null;
            }
            case 15: {
                return et.getUserRoleId() == null;
            }
            case 16: {
                return et.getUserTag() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return UserRoleDetailBase.contains(this, index);
    }

    private static boolean contains(UserRoleDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isReserverDirty();
            }
            case 3: {
                return et.isReserver2Dirty();
            }
            case 4: {
                return et.isReserver3Dirty();
            }
            case 5: {
                return et.isReserver4Dirty();
            }
            case 6: {
                return et.isUserRoleNameDirty();
            }
            case 7: {
                return et.isUpdateDateDirty();
            }
            case 8: {
                return et.isUpdateManDirty();
            }
            case 9: {
                return et.isUserDataDirty();
            }
            case 10: {
                return et.isUserData2Dirty();
            }
            case 11: {
                return et.isUserObjectIdDirty();
            }
            case 12: {
                return et.isUserObjectNameDirty();
            }
            case 13: {
                return et.isUserRoleDetailIdDirty();
            }
            case 14: {
                return et.isUserRoleDetailNameDirty();
            }
            case 15: {
                return et.isUserRoleIdDirty();
            }
            case 16: {
                return et.isUserTagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserRoleDetailBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserRoleDetailBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserRoleDetailBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserRoleDetailBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserRoleDetailBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserRoleDetailBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserRoleDetailBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UserRoleDetailBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUserRoleName() != null) {
            JSONObjectHelper.put(json, "uesrrolename", UserRoleDetailBase.getJSONValue(et.getUserRoleName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserRoleDetailBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserRoleDetailBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", UserRoleDetailBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", UserRoleDetailBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserObjectId() != null) {
            JSONObjectHelper.put(json, "userobjectid", UserRoleDetailBase.getJSONValue(et.getUserObjectId()), false);
        }
        if (bIncEmpty || et.getUserObjectName() != null) {
            JSONObjectHelper.put(json, "userobjectname", UserRoleDetailBase.getJSONValue(et.getUserObjectName()), false);
        }
        if (bIncEmpty || et.getUserRoleDetailId() != null) {
            JSONObjectHelper.put(json, "userroledetailid", UserRoleDetailBase.getJSONValue(et.getUserRoleDetailId()), false);
        }
        if (bIncEmpty || et.getUserRoleDetailName() != null) {
            JSONObjectHelper.put(json, "userroledetailname", UserRoleDetailBase.getJSONValue(et.getUserRoleDetailName()), false);
        }
        if (bIncEmpty || et.getUserRoleId() != null) {
            JSONObjectHelper.put(json, "userroleid", UserRoleDetailBase.getJSONValue(et.getUserRoleId()), false);
        }
        if (bIncEmpty || et.getUserTag() != null) {
            JSONObjectHelper.put(json, "usertag", UserRoleDetailBase.getJSONValue(et.getUserTag()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserRoleDetailBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserRoleDetailBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleName() != null) {
            obj = et.getUserRoleName();
            node.setAttribute("USERROLENAME", obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData() != null) {
            obj = et.getUserData();
            node.setAttribute(FIELD_USERDATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            obj = et.getUserData2();
            node.setAttribute(FIELD_USERDATA2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserObjectId() != null) {
            obj = et.getUserObjectId();
            node.setAttribute(FIELD_USEROBJECTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserObjectName() != null) {
            obj = et.getUserObjectName();
            node.setAttribute(FIELD_USEROBJECTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDetailId() != null) {
            obj = et.getUserRoleDetailId();
            node.setAttribute(FIELD_USERROLEDETAILID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDetailName() != null) {
            obj = et.getUserRoleDetailName();
            node.setAttribute(FIELD_USERROLEDETAILNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleId() != null) {
            obj = et.getUserRoleId();
            node.setAttribute(FIELD_USERROLEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserTag() != null) {
            obj = et.getUserTag();
            node.setAttribute(FIELD_USERTAG, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleDetailBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserRoleDetailBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isUserRoleNameDirty() && (bIncEmpty || et.getUserRoleName() != null)) {
            dst.set(FIELD_USERROLENAME, et.getUserRoleName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDataDirty() && (bIncEmpty || et.getUserData() != null)) {
            dst.set(FIELD_USERDATA, et.getUserData());
        }
        if (et.isUserData2Dirty() && (bIncEmpty || et.getUserData2() != null)) {
            dst.set(FIELD_USERDATA2, et.getUserData2());
        }
        if (et.isUserObjectIdDirty() && (bIncEmpty || et.getUserObjectId() != null)) {
            dst.set(FIELD_USEROBJECTID, et.getUserObjectId());
        }
        if (et.isUserObjectNameDirty() && (bIncEmpty || et.getUserObjectName() != null)) {
            dst.set(FIELD_USEROBJECTNAME, et.getUserObjectName());
        }
        if (et.isUserRoleDetailIdDirty() && (bIncEmpty || et.getUserRoleDetailId() != null)) {
            dst.set(FIELD_USERROLEDETAILID, et.getUserRoleDetailId());
        }
        if (et.isUserRoleDetailNameDirty() && (bIncEmpty || et.getUserRoleDetailName() != null)) {
            dst.set(FIELD_USERROLEDETAILNAME, et.getUserRoleDetailName());
        }
        if (et.isUserRoleIdDirty() && (bIncEmpty || et.getUserRoleId() != null)) {
            dst.set(FIELD_USERROLEID, et.getUserRoleId());
        }
        if (et.isUserTagDirty() && (bIncEmpty || et.getUserTag() != null)) {
            dst.set(FIELD_USERTAG, et.getUserTag());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return UserRoleDetailBase.remove(this, index);
    }

    private static boolean remove(UserRoleDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetReserver();
                return true;
            }
            case 3: {
                et.resetReserver2();
                return true;
            }
            case 4: {
                et.resetReserver3();
                return true;
            }
            case 5: {
                et.resetReserver4();
                return true;
            }
            case 6: {
                et.resetUserRoleName();
                return true;
            }
            case 7: {
                et.resetUpdateDate();
                return true;
            }
            case 8: {
                et.resetUpdateMan();
                return true;
            }
            case 9: {
                et.resetUserData();
                return true;
            }
            case 10: {
                et.resetUserData2();
                return true;
            }
            case 11: {
                et.resetUserObjectId();
                return true;
            }
            case 12: {
                et.resetUserObjectName();
                return true;
            }
            case 13: {
                et.resetUserRoleDetailId();
                return true;
            }
            case 14: {
                et.resetUserRoleDetailName();
                return true;
            }
            case 15: {
                et.resetUserRoleId();
                return true;
            }
            case 16: {
                et.resetUserTag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UserObject getUserObject() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserObject();
        }
        if (this.getUserObjectId() == null) {
            return null;
        }
        Integer n = this.objUserObjectLock;
        synchronized (n) {
            if (this.userobject != null && DataTypeHelper.compare(25, (Object)this.getUserObjectId(), (Object)this.userobject.getUserObjectId()) != 0L) {
                this.userobject = null;
            }
            if (this.userobject == null) {
                UserObject userobject = new UserObject();
                userobject.setUserObjectId(this.getUserObjectId());
                UserObjectService service = (UserObjectService)ServiceGlobal.getService(UserObjectService.class, this.getSessionFactory());
                service.autoGet(userobject);
                this.userobject = userobject;
            }
            return this.userobject;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UserRole getUserRole() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRole();
        }
        if (this.getUserRoleId() == null) {
            return null;
        }
        Integer n = this.objUserRoleLock;
        synchronized (n) {
            if (this.userrole != null && DataTypeHelper.compare(25, (Object)this.getUserRoleId(), (Object)this.userrole.getUserRoleId()) != 0L) {
                this.userrole = null;
            }
            if (this.userrole == null) {
                UserRole userrole = new UserRole();
                userrole.setUserRoleId(this.getUserRoleId());
                UserRoleService service = (UserRoleService)ServiceGlobal.getService(UserRoleService.class, this.getSessionFactory());
                service.autoGet(userrole);
                this.userrole = userrole;
            }
            return this.userrole;
        }
    }

    private UserRoleDetailBase getProxyEntity() {
        return this.proxyUserRoleDetailBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleDetailBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserRoleDetailBase) {
            this.proxyUserRoleDetailBase = (UserRoleDetailBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

