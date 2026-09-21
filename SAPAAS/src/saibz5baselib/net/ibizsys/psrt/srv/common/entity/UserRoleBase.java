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
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.UserRoleDetail;
import net.ibizsys.psrt.srv.common.service.UserRoleDetailService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserRoleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISSYSTEM = "ISSYSTEM";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MENUMODE = "MENUMODE";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERROLEID = "USERROLEID";
    public static final String FIELD_USERROLENAME = "USERROLENAME";
    public static final String FIELD_USERROLETYPE = "USERROLETYPE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ISSYSTEM = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_MENUMODE = 4;
    private static final int INDEX_RESERVER = 5;
    private static final int INDEX_RESERVER2 = 6;
    private static final int INDEX_RESERVER3 = 7;
    private static final int INDEX_RESERVER4 = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERDATA = 11;
    private static final int INDEX_USERDATA2 = 12;
    private static final int INDEX_USERROLEID = 13;
    private static final int INDEX_USERROLENAME = 14;
    private static final int INDEX_USERROLETYPE = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserRoleBase proxyUserRoleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean issystemDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean menumodeDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userroleidDirtyFlag = false;
    private boolean userrolenameDirtyFlag = false;
    private boolean userroletypeDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="issystem")
    private Integer issystem;
    @Column(name="memo")
    private String memo;
    @Column(name="menumode")
    private String menumode;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userroleid")
    private String userroleid;
    @Column(name="userrolename")
    private String userrolename;
    @Column(name="userroletype")
    private String userroletype;
    private Integer objUserRoleDetailsLock = new Integer(1);
    private ArrayList<UserRoleDetail> userroledetails = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ISSYSTEM, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_MENUMODE, 4);
        fieldIndexMap.put(FIELD_RESERVER, 5);
        fieldIndexMap.put(FIELD_RESERVER2, 6);
        fieldIndexMap.put(FIELD_RESERVER3, 7);
        fieldIndexMap.put(FIELD_RESERVER4, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERDATA, 11);
        fieldIndexMap.put(FIELD_USERDATA2, 12);
        fieldIndexMap.put(FIELD_USERROLEID, 13);
        fieldIndexMap.put(FIELD_USERROLENAME, 14);
        fieldIndexMap.put(FIELD_USERROLETYPE, 15);
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

    public void setIsSystem(Integer issystem) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag = true;
    }

    public Integer getIsSystem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    public boolean isIsSystemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    public void resetIsSystem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }
        this.issystemDirtyFlag = false;
        this.issystem = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setMenuMode(String menumode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMenuMode(menumode);
            return;
        }
        if (menumode != null && (menumode = StringHelper.trimRight(menumode)).length() == 0) {
            menumode = null;
        }
        this.menumode = menumode;
        this.menumodeDirtyFlag = true;
    }

    public String getMenuMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuMode();
        }
        return this.menumode;
    }

    public boolean isMenuModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMenuModeDirty();
        }
        return this.menumodeDirtyFlag;
    }

    public void resetMenuMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMenuMode();
            return;
        }
        this.menumodeDirtyFlag = false;
        this.menumode = null;
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

    public void setUserRoleType(String userroletype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleType(userroletype);
            return;
        }
        if (userroletype != null && (userroletype = StringHelper.trimRight(userroletype)).length() == 0) {
            userroletype = null;
        }
        this.userroletype = userroletype;
        this.userroletypeDirtyFlag = true;
    }

    public String getUserRoleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleType();
        }
        return this.userroletype;
    }

    public boolean isUserRoleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleTypeDirty();
        }
        return this.userroletypeDirtyFlag;
    }

    public void resetUserRoleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleType();
            return;
        }
        this.userroletypeDirtyFlag = false;
        this.userroletype = null;
    }

    @Override
    protected void onReset() {
        UserRoleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserRoleBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsSystem();
        et.resetMemo();
        et.resetMenuMode();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserRoleId();
        et.resetUserRoleName();
        et.resetUserRoleType();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM, this.getIsSystem());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isMenuModeDirty()) {
            params.put(FIELD_MENUMODE, this.getMenuMode());
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
        if (!bDirtyOnly || this.isUserRoleIdDirty()) {
            params.put(FIELD_USERROLEID, this.getUserRoleId());
        }
        if (!bDirtyOnly || this.isUserRoleNameDirty()) {
            params.put(FIELD_USERROLENAME, this.getUserRoleName());
        }
        if (!bDirtyOnly || this.isUserRoleTypeDirty()) {
            params.put(FIELD_USERROLETYPE, this.getUserRoleType());
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
        return UserRoleBase.get(this, index);
    }

    private static Object get(UserRoleBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getIsSystem();
            }
            case 3: {
                return et.getMemo();
            }
            case 4: {
                return et.getMenuMode();
            }
            case 5: {
                return et.getReserver();
            }
            case 6: {
                return et.getReserver2();
            }
            case 7: {
                return et.getReserver3();
            }
            case 8: {
                return et.getReserver4();
            }
            case 9: {
                return et.getUpdateDate();
            }
            case 10: {
                return et.getUpdateMan();
            }
            case 11: {
                return et.getUserData();
            }
            case 12: {
                return et.getUserData2();
            }
            case 13: {
                return et.getUserRoleId();
            }
            case 14: {
                return et.getUserRoleName();
            }
            case 15: {
                return et.getUserRoleType();
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
        UserRoleBase.set(this, index, objValue);
    }

    private static void set(UserRoleBase et, int index, Object obj) throws Exception {
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
                et.setIsSystem(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setMenuMode(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 10: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUserRoleId(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUserRoleName(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserRoleType(DataObject.getStringValue(obj));
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
        return UserRoleBase.isNull(this, index);
    }

    private static boolean isNull(UserRoleBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getIsSystem() == null;
            }
            case 3: {
                return et.getMemo() == null;
            }
            case 4: {
                return et.getMenuMode() == null;
            }
            case 5: {
                return et.getReserver() == null;
            }
            case 6: {
                return et.getReserver2() == null;
            }
            case 7: {
                return et.getReserver3() == null;
            }
            case 8: {
                return et.getReserver4() == null;
            }
            case 9: {
                return et.getUpdateDate() == null;
            }
            case 10: {
                return et.getUpdateMan() == null;
            }
            case 11: {
                return et.getUserData() == null;
            }
            case 12: {
                return et.getUserData2() == null;
            }
            case 13: {
                return et.getUserRoleId() == null;
            }
            case 14: {
                return et.getUserRoleName() == null;
            }
            case 15: {
                return et.getUserRoleType() == null;
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
        return UserRoleBase.contains(this, index);
    }

    private static boolean contains(UserRoleBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isIsSystemDirty();
            }
            case 3: {
                return et.isMemoDirty();
            }
            case 4: {
                return et.isMenuModeDirty();
            }
            case 5: {
                return et.isReserverDirty();
            }
            case 6: {
                return et.isReserver2Dirty();
            }
            case 7: {
                return et.isReserver3Dirty();
            }
            case 8: {
                return et.isReserver4Dirty();
            }
            case 9: {
                return et.isUpdateDateDirty();
            }
            case 10: {
                return et.isUpdateManDirty();
            }
            case 11: {
                return et.isUserDataDirty();
            }
            case 12: {
                return et.isUserData2Dirty();
            }
            case 13: {
                return et.isUserRoleIdDirty();
            }
            case 14: {
                return et.isUserRoleNameDirty();
            }
            case 15: {
                return et.isUserRoleTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserRoleBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserRoleBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserRoleBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserRoleBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            JSONObjectHelper.put(json, "issystem", UserRoleBase.getJSONValue(et.getIsSystem()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", UserRoleBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getMenuMode() != null) {
            JSONObjectHelper.put(json, "menumode", UserRoleBase.getJSONValue(et.getMenuMode()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserRoleBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserRoleBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserRoleBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UserRoleBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserRoleBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserRoleBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", UserRoleBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", UserRoleBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserRoleId() != null) {
            JSONObjectHelper.put(json, "userroleid", UserRoleBase.getJSONValue(et.getUserRoleId()), false);
        }
        if (bIncEmpty || et.getUserRoleName() != null) {
            JSONObjectHelper.put(json, "userrolename", UserRoleBase.getJSONValue(et.getUserRoleName()), false);
        }
        if (bIncEmpty || et.getUserRoleType() != null) {
            JSONObjectHelper.put(json, "userroletype", UserRoleBase.getJSONValue(et.getUserRoleType()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserRoleBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserRoleBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            obj = et.getIsSystem();
            node.setAttribute(FIELD_ISSYSTEM, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMenuMode() != null) {
            obj = et.getMenuMode();
            node.setAttribute(FIELD_MENUMODE, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getUserRoleId() != null) {
            obj = et.getUserRoleId();
            node.setAttribute(FIELD_USERROLEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleName() != null) {
            obj = et.getUserRoleName();
            node.setAttribute(FIELD_USERROLENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleType() != null) {
            obj = et.getUserRoleType();
            node.setAttribute(FIELD_USERROLETYPE, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserRoleBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isIsSystemDirty() && (bIncEmpty || et.getIsSystem() != null)) {
            dst.set(FIELD_ISSYSTEM, et.getIsSystem());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isMenuModeDirty() && (bIncEmpty || et.getMenuMode() != null)) {
            dst.set(FIELD_MENUMODE, et.getMenuMode());
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
        if (et.isUserRoleIdDirty() && (bIncEmpty || et.getUserRoleId() != null)) {
            dst.set(FIELD_USERROLEID, et.getUserRoleId());
        }
        if (et.isUserRoleNameDirty() && (bIncEmpty || et.getUserRoleName() != null)) {
            dst.set(FIELD_USERROLENAME, et.getUserRoleName());
        }
        if (et.isUserRoleTypeDirty() && (bIncEmpty || et.getUserRoleType() != null)) {
            dst.set(FIELD_USERROLETYPE, et.getUserRoleType());
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
        return UserRoleBase.remove(this, index);
    }

    private static boolean remove(UserRoleBase et, int index) throws Exception {
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
                et.resetIsSystem();
                return true;
            }
            case 3: {
                et.resetMemo();
                return true;
            }
            case 4: {
                et.resetMenuMode();
                return true;
            }
            case 5: {
                et.resetReserver();
                return true;
            }
            case 6: {
                et.resetReserver2();
                return true;
            }
            case 7: {
                et.resetReserver3();
                return true;
            }
            case 8: {
                et.resetReserver4();
                return true;
            }
            case 9: {
                et.resetUpdateDate();
                return true;
            }
            case 10: {
                et.resetUpdateMan();
                return true;
            }
            case 11: {
                et.resetUserData();
                return true;
            }
            case 12: {
                et.resetUserData2();
                return true;
            }
            case 13: {
                et.resetUserRoleId();
                return true;
            }
            case 14: {
                et.resetUserRoleName();
                return true;
            }
            case 15: {
                et.resetUserRoleType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<UserRoleDetail> getUserRoleDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDetails();
        }
        if (this.getUserRoleId() == null) {
            return null;
        }
        UserRoleDetailService service = (UserRoleDetailService)ServiceGlobal.getService(UserRoleDetailService.class, this.getSessionFactory());
        Integer n = this.objUserRoleDetailsLock;
        synchronized (n) {
            if (this.userroledetails == null) {
                this.userroledetails = service.selectByUserRole(this);
            }
            return this.userroledetails;
        }
    }

    private UserRoleBase getProxyEntity() {
        return this.proxyUserRoleBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserRoleBase) {
            this.proxyUserRoleBase = (UserRoleBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

