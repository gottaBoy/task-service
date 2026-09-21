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
import net.ibizsys.psrt.srv.common.entity.UserRole;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.common.service.UserRoleDataService;
import net.ibizsys.psrt.srv.common.service.UserRoleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserRoleDatasBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleDatasBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERROLEDATAID = "USERROLEDATAID";
    public static final String FIELD_USERROLEDATANAME = "USERROLEDATANAME";
    public static final String FIELD_USERROLEDATASID = "USERROLEDATASID";
    public static final String FIELD_USERROLEDATASNAME = "USERROLEDATASNAME";
    public static final String FIELD_USERROLEID = "USERROLEID";
    public static final String FIELD_USERROLENAME = "USERROLENAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DENAME = 2;
    private static final int INDEX_RESERVER = 3;
    private static final int INDEX_RESERVER2 = 4;
    private static final int INDEX_RESERVER3 = 5;
    private static final int INDEX_RESERVER4 = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_USERROLEDATAID = 9;
    private static final int INDEX_USERROLEDATANAME = 10;
    private static final int INDEX_USERROLEDATASID = 11;
    private static final int INDEX_USERROLEDATASNAME = 12;
    private static final int INDEX_USERROLEID = 13;
    private static final int INDEX_USERROLENAME = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserRoleDatasBase proxyUserRoleDatasBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userroledataidDirtyFlag = false;
    private boolean userroledatanameDirtyFlag = false;
    private boolean userroledatasidDirtyFlag = false;
    private boolean userroledatasnameDirtyFlag = false;
    private boolean userroleidDirtyFlag = false;
    private boolean userrolenameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dename")
    private String dename;
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
    @Column(name="userroledataid")
    private String userroledataid;
    @Column(name="userroledataname")
    private String userroledataname;
    @Column(name="userroledatasid")
    private String userroledatasid;
    @Column(name="userroledatasname")
    private String userroledatasname;
    @Column(name="userroleid")
    private String userroleid;
    @Column(name="userrolename")
    private String userrolename;
    private Integer objUserRoleDataLock = new Integer(1);
    private UserRoleData userroledata = null;
    private Integer objUserRoleLock = new Integer(1);
    private UserRole userrole = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DENAME, 2);
        fieldIndexMap.put(FIELD_RESERVER, 3);
        fieldIndexMap.put(FIELD_RESERVER2, 4);
        fieldIndexMap.put(FIELD_RESERVER3, 5);
        fieldIndexMap.put(FIELD_RESERVER4, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_USERROLEDATAID, 9);
        fieldIndexMap.put(FIELD_USERROLEDATANAME, 10);
        fieldIndexMap.put(FIELD_USERROLEDATASID, 11);
        fieldIndexMap.put(FIELD_USERROLEDATASNAME, 12);
        fieldIndexMap.put(FIELD_USERROLEID, 13);
        fieldIndexMap.put(FIELD_USERROLENAME, 14);
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

    public void setDEName(String dename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if (dename != null && (dename = StringHelper.trimRight(dename)).length() == 0) {
            dename = null;
        }
        this.dename = dename;
        this.denameDirtyFlag = true;
    }

    public String getDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    public boolean isDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    public void resetDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEName();
            return;
        }
        this.denameDirtyFlag = false;
        this.dename = null;
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

    public void setUserRoleDataId(String userroledataid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDataId(userroledataid);
            return;
        }
        if (userroledataid != null && (userroledataid = StringHelper.trimRight(userroledataid)).length() == 0) {
            userroledataid = null;
        }
        this.userroledataid = userroledataid;
        this.userroledataidDirtyFlag = true;
    }

    public String getUserRoleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDataId();
        }
        return this.userroledataid;
    }

    public boolean isUserRoleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDataIdDirty();
        }
        return this.userroledataidDirtyFlag;
    }

    public void resetUserRoleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDataId();
            return;
        }
        this.userroledataidDirtyFlag = false;
        this.userroledataid = null;
    }

    public void setUserRoleDataName(String userroledataname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDataName(userroledataname);
            return;
        }
        if (userroledataname != null && (userroledataname = StringHelper.trimRight(userroledataname)).length() == 0) {
            userroledataname = null;
        }
        this.userroledataname = userroledataname;
        this.userroledatanameDirtyFlag = true;
    }

    public String getUserRoleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDataName();
        }
        return this.userroledataname;
    }

    public boolean isUserRoleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDataNameDirty();
        }
        return this.userroledatanameDirtyFlag;
    }

    public void resetUserRoleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDataName();
            return;
        }
        this.userroledatanameDirtyFlag = false;
        this.userroledataname = null;
    }

    public void setUserRoleDatasId(String userroledatasid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDatasId(userroledatasid);
            return;
        }
        if (userroledatasid != null && (userroledatasid = StringHelper.trimRight(userroledatasid)).length() == 0) {
            userroledatasid = null;
        }
        this.userroledatasid = userroledatasid;
        this.userroledatasidDirtyFlag = true;
    }

    public String getUserRoleDatasId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDatasId();
        }
        return this.userroledatasid;
    }

    public boolean isUserRoleDatasIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDatasIdDirty();
        }
        return this.userroledatasidDirtyFlag;
    }

    public void resetUserRoleDatasId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDatasId();
            return;
        }
        this.userroledatasidDirtyFlag = false;
        this.userroledatasid = null;
    }

    public void setUserRoleDatasName(String userroledatasname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDatasName(userroledatasname);
            return;
        }
        if (userroledatasname != null && (userroledatasname = StringHelper.trimRight(userroledatasname)).length() == 0) {
            userroledatasname = null;
        }
        this.userroledatasname = userroledatasname;
        this.userroledatasnameDirtyFlag = true;
    }

    public String getUserRoleDatasName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDatasName();
        }
        return this.userroledatasname;
    }

    public boolean isUserRoleDatasNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDatasNameDirty();
        }
        return this.userroledatasnameDirtyFlag;
    }

    public void resetUserRoleDatasName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDatasName();
            return;
        }
        this.userroledatasnameDirtyFlag = false;
        this.userroledatasname = null;
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

    @Override
    protected void onReset() {
        UserRoleDatasBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserRoleDatasBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEName();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserRoleDataId();
        et.resetUserRoleDataName();
        et.resetUserRoleDatasId();
        et.resetUserRoleDatasName();
        et.resetUserRoleId();
        et.resetUserRoleName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
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
        if (!bDirtyOnly || this.isUserRoleDataIdDirty()) {
            params.put(FIELD_USERROLEDATAID, this.getUserRoleDataId());
        }
        if (!bDirtyOnly || this.isUserRoleDataNameDirty()) {
            params.put(FIELD_USERROLEDATANAME, this.getUserRoleDataName());
        }
        if (!bDirtyOnly || this.isUserRoleDatasIdDirty()) {
            params.put(FIELD_USERROLEDATASID, this.getUserRoleDatasId());
        }
        if (!bDirtyOnly || this.isUserRoleDatasNameDirty()) {
            params.put(FIELD_USERROLEDATASNAME, this.getUserRoleDatasName());
        }
        if (!bDirtyOnly || this.isUserRoleIdDirty()) {
            params.put(FIELD_USERROLEID, this.getUserRoleId());
        }
        if (!bDirtyOnly || this.isUserRoleNameDirty()) {
            params.put(FIELD_USERROLENAME, this.getUserRoleName());
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
        return UserRoleDatasBase.get(this, index);
    }

    private static Object get(UserRoleDatasBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDEName();
            }
            case 3: {
                return et.getReserver();
            }
            case 4: {
                return et.getReserver2();
            }
            case 5: {
                return et.getReserver3();
            }
            case 6: {
                return et.getReserver4();
            }
            case 7: {
                return et.getUpdateDate();
            }
            case 8: {
                return et.getUpdateMan();
            }
            case 9: {
                return et.getUserRoleDataId();
            }
            case 10: {
                return et.getUserRoleDataName();
            }
            case 11: {
                return et.getUserRoleDatasId();
            }
            case 12: {
                return et.getUserRoleDatasName();
            }
            case 13: {
                return et.getUserRoleId();
            }
            case 14: {
                return et.getUserRoleName();
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
        UserRoleDatasBase.set(this, index, objValue);
    }

    private static void set(UserRoleDatasBase et, int index, Object obj) throws Exception {
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
                et.setDEName(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver4(DataObject.getStringValue(obj));
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
                et.setUserRoleDataId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUserRoleDataName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserRoleDatasId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserRoleDatasName(DataObject.getStringValue(obj));
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
        return UserRoleDatasBase.isNull(this, index);
    }

    private static boolean isNull(UserRoleDatasBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDEName() == null;
            }
            case 3: {
                return et.getReserver() == null;
            }
            case 4: {
                return et.getReserver2() == null;
            }
            case 5: {
                return et.getReserver3() == null;
            }
            case 6: {
                return et.getReserver4() == null;
            }
            case 7: {
                return et.getUpdateDate() == null;
            }
            case 8: {
                return et.getUpdateMan() == null;
            }
            case 9: {
                return et.getUserRoleDataId() == null;
            }
            case 10: {
                return et.getUserRoleDataName() == null;
            }
            case 11: {
                return et.getUserRoleDatasId() == null;
            }
            case 12: {
                return et.getUserRoleDatasName() == null;
            }
            case 13: {
                return et.getUserRoleId() == null;
            }
            case 14: {
                return et.getUserRoleName() == null;
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
        return UserRoleDatasBase.contains(this, index);
    }

    private static boolean contains(UserRoleDatasBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDENameDirty();
            }
            case 3: {
                return et.isReserverDirty();
            }
            case 4: {
                return et.isReserver2Dirty();
            }
            case 5: {
                return et.isReserver3Dirty();
            }
            case 6: {
                return et.isReserver4Dirty();
            }
            case 7: {
                return et.isUpdateDateDirty();
            }
            case 8: {
                return et.isUpdateManDirty();
            }
            case 9: {
                return et.isUserRoleDataIdDirty();
            }
            case 10: {
                return et.isUserRoleDataNameDirty();
            }
            case 11: {
                return et.isUserRoleDatasIdDirty();
            }
            case 12: {
                return et.isUserRoleDatasNameDirty();
            }
            case 13: {
                return et.isUserRoleIdDirty();
            }
            case 14: {
                return et.isUserRoleNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserRoleDatasBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserRoleDatasBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserRoleDatasBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserRoleDatasBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", UserRoleDatasBase.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserRoleDatasBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserRoleDatasBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserRoleDatasBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UserRoleDatasBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserRoleDatasBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserRoleDatasBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserRoleDataId() != null) {
            JSONObjectHelper.put(json, "userroledataid", UserRoleDatasBase.getJSONValue(et.getUserRoleDataId()), false);
        }
        if (bIncEmpty || et.getUserRoleDataName() != null) {
            JSONObjectHelper.put(json, "userroledataname", UserRoleDatasBase.getJSONValue(et.getUserRoleDataName()), false);
        }
        if (bIncEmpty || et.getUserRoleDatasId() != null) {
            JSONObjectHelper.put(json, "userroledatasid", UserRoleDatasBase.getJSONValue(et.getUserRoleDatasId()), false);
        }
        if (bIncEmpty || et.getUserRoleDatasName() != null) {
            JSONObjectHelper.put(json, "userroledatasname", UserRoleDatasBase.getJSONValue(et.getUserRoleDatasName()), false);
        }
        if (bIncEmpty || et.getUserRoleId() != null) {
            JSONObjectHelper.put(json, "userroleid", UserRoleDatasBase.getJSONValue(et.getUserRoleId()), false);
        }
        if (bIncEmpty || et.getUserRoleName() != null) {
            JSONObjectHelper.put(json, "userrolename", UserRoleDatasBase.getJSONValue(et.getUserRoleName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserRoleDatasBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserRoleDatasBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getUserRoleDataId() != null) {
            obj = et.getUserRoleDataId();
            node.setAttribute(FIELD_USERROLEDATAID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDataName() != null) {
            obj = et.getUserRoleDataName();
            node.setAttribute(FIELD_USERROLEDATANAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDatasId() != null) {
            obj = et.getUserRoleDatasId();
            node.setAttribute(FIELD_USERROLEDATASID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDatasName() != null) {
            obj = et.getUserRoleDatasName();
            node.setAttribute(FIELD_USERROLEDATASNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleId() != null) {
            obj = et.getUserRoleId();
            node.setAttribute(FIELD_USERROLEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleName() != null) {
            obj = et.getUserRoleName();
            node.setAttribute(FIELD_USERROLENAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleDatasBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserRoleDatasBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
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
        if (et.isUserRoleDataIdDirty() && (bIncEmpty || et.getUserRoleDataId() != null)) {
            dst.set(FIELD_USERROLEDATAID, et.getUserRoleDataId());
        }
        if (et.isUserRoleDataNameDirty() && (bIncEmpty || et.getUserRoleDataName() != null)) {
            dst.set(FIELD_USERROLEDATANAME, et.getUserRoleDataName());
        }
        if (et.isUserRoleDatasIdDirty() && (bIncEmpty || et.getUserRoleDatasId() != null)) {
            dst.set(FIELD_USERROLEDATASID, et.getUserRoleDatasId());
        }
        if (et.isUserRoleDatasNameDirty() && (bIncEmpty || et.getUserRoleDatasName() != null)) {
            dst.set(FIELD_USERROLEDATASNAME, et.getUserRoleDatasName());
        }
        if (et.isUserRoleIdDirty() && (bIncEmpty || et.getUserRoleId() != null)) {
            dst.set(FIELD_USERROLEID, et.getUserRoleId());
        }
        if (et.isUserRoleNameDirty() && (bIncEmpty || et.getUserRoleName() != null)) {
            dst.set(FIELD_USERROLENAME, et.getUserRoleName());
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
        return UserRoleDatasBase.remove(this, index);
    }

    private static boolean remove(UserRoleDatasBase et, int index) throws Exception {
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
                et.resetDEName();
                return true;
            }
            case 3: {
                et.resetReserver();
                return true;
            }
            case 4: {
                et.resetReserver2();
                return true;
            }
            case 5: {
                et.resetReserver3();
                return true;
            }
            case 6: {
                et.resetReserver4();
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
                et.resetUserRoleDataId();
                return true;
            }
            case 10: {
                et.resetUserRoleDataName();
                return true;
            }
            case 11: {
                et.resetUserRoleDatasId();
                return true;
            }
            case 12: {
                et.resetUserRoleDatasName();
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
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UserRoleData getUserRoleData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleData();
        }
        if (this.getUserRoleDataId() == null) {
            return null;
        }
        Integer n = this.objUserRoleDataLock;
        synchronized (n) {
            if (this.userroledata != null && DataTypeHelper.compare(25, (Object)this.getUserRoleDataId(), (Object)this.userroledata.getUserRoleDataId()) != 0L) {
                this.userroledata = null;
            }
            if (this.userroledata == null) {
                UserRoleData userroledata = new UserRoleData();
                userroledata.setUserRoleDataId(this.getUserRoleDataId());
                UserRoleDataService service = (UserRoleDataService)ServiceGlobal.getService(UserRoleDataService.class, this.getSessionFactory());
                service.autoGet(userroledata);
                this.userroledata = userroledata;
            }
            return this.userroledata;
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

    private UserRoleDatasBase getProxyEntity() {
        return this.proxyUserRoleDatasBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleDatasBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserRoleDatasBase) {
            this.proxyUserRoleDatasBase = (UserRoleDatasBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDatasService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

