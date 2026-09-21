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
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.common.service.UserRoleDataService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserRoleDataActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleDataActionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISALLOW = "ISALLOW";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERROLEDATAACTIONID = "USERROLEDATAACTIONID";
    public static final String FIELD_USERROLEDATAACTIONNAME = "USERROLEDATAACTIONNAME";
    public static final String FIELD_USERROLEDATAID = "USERROLEDATAID";
    public static final String FIELD_USERROLEDATANAME = "USERROLEDATANAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ISALLOW = 2;
    private static final int INDEX_RESERVER = 3;
    private static final int INDEX_RESERVER2 = 4;
    private static final int INDEX_RESERVER3 = 5;
    private static final int INDEX_RESERVER4 = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_USERROLEDATAACTIONID = 9;
    private static final int INDEX_USERROLEDATAACTIONNAME = 10;
    private static final int INDEX_USERROLEDATAID = 11;
    private static final int INDEX_USERROLEDATANAME = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserRoleDataActionBase proxyUserRoleDataActionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean isallowDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userroledataactionidDirtyFlag = false;
    private boolean userroledataactionnameDirtyFlag = false;
    private boolean userroledataidDirtyFlag = false;
    private boolean userroledatanameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="isallow")
    private Integer isallow;
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
    @Column(name="userroledataactionid")
    private String userroledataactionid;
    @Column(name="userroledataactionname")
    private String userroledataactionname;
    @Column(name="userroledataid")
    private String userroledataid;
    @Column(name="userroledataname")
    private String userroledataname;
    private Integer objUserRoleDataLock = new Integer(1);
    private UserRoleData userroledata = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ISALLOW, 2);
        fieldIndexMap.put(FIELD_RESERVER, 3);
        fieldIndexMap.put(FIELD_RESERVER2, 4);
        fieldIndexMap.put(FIELD_RESERVER3, 5);
        fieldIndexMap.put(FIELD_RESERVER4, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_USERROLEDATAACTIONID, 9);
        fieldIndexMap.put(FIELD_USERROLEDATAACTIONNAME, 10);
        fieldIndexMap.put(FIELD_USERROLEDATAID, 11);
        fieldIndexMap.put(FIELD_USERROLEDATANAME, 12);
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

    public void setIsAllow(Integer isallow) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsAllow(isallow);
            return;
        }
        this.isallow = isallow;
        this.isallowDirtyFlag = true;
    }

    public Integer getIsAllow() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsAllow();
        }
        return this.isallow;
    }

    public boolean isIsAllowDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsAllowDirty();
        }
        return this.isallowDirtyFlag;
    }

    public void resetIsAllow() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsAllow();
            return;
        }
        this.isallowDirtyFlag = false;
        this.isallow = null;
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

    public void setUserRoleDataActionId(String userroledataactionid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDataActionId(userroledataactionid);
            return;
        }
        if (userroledataactionid != null && (userroledataactionid = StringHelper.trimRight(userroledataactionid)).length() == 0) {
            userroledataactionid = null;
        }
        this.userroledataactionid = userroledataactionid;
        this.userroledataactionidDirtyFlag = true;
    }

    public String getUserRoleDataActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDataActionId();
        }
        return this.userroledataactionid;
    }

    public boolean isUserRoleDataActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDataActionIdDirty();
        }
        return this.userroledataactionidDirtyFlag;
    }

    public void resetUserRoleDataActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDataActionId();
            return;
        }
        this.userroledataactionidDirtyFlag = false;
        this.userroledataactionid = null;
    }

    public void setUserRoleDataActionName(String userroledataactionname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDataActionName(userroledataactionname);
            return;
        }
        if (userroledataactionname != null && (userroledataactionname = StringHelper.trimRight(userroledataactionname)).length() == 0) {
            userroledataactionname = null;
        }
        this.userroledataactionname = userroledataactionname;
        this.userroledataactionnameDirtyFlag = true;
    }

    public String getUserRoleDataActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDataActionName();
        }
        return this.userroledataactionname;
    }

    public boolean isUserRoleDataActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDataActionNameDirty();
        }
        return this.userroledataactionnameDirtyFlag;
    }

    public void resetUserRoleDataActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDataActionName();
            return;
        }
        this.userroledataactionnameDirtyFlag = false;
        this.userroledataactionname = null;
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

    @Override
    protected void onReset() {
        UserRoleDataActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserRoleDataActionBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsAllow();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserRoleDataActionId();
        et.resetUserRoleDataActionName();
        et.resetUserRoleDataId();
        et.resetUserRoleDataName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isIsAllowDirty()) {
            params.put(FIELD_ISALLOW, this.getIsAllow());
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
        if (!bDirtyOnly || this.isUserRoleDataActionIdDirty()) {
            params.put(FIELD_USERROLEDATAACTIONID, this.getUserRoleDataActionId());
        }
        if (!bDirtyOnly || this.isUserRoleDataActionNameDirty()) {
            params.put(FIELD_USERROLEDATAACTIONNAME, this.getUserRoleDataActionName());
        }
        if (!bDirtyOnly || this.isUserRoleDataIdDirty()) {
            params.put(FIELD_USERROLEDATAID, this.getUserRoleDataId());
        }
        if (!bDirtyOnly || this.isUserRoleDataNameDirty()) {
            params.put(FIELD_USERROLEDATANAME, this.getUserRoleDataName());
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
        return UserRoleDataActionBase.get(this, index);
    }

    private static Object get(UserRoleDataActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getIsAllow();
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
                return et.getUserRoleDataActionId();
            }
            case 10: {
                return et.getUserRoleDataActionName();
            }
            case 11: {
                return et.getUserRoleDataId();
            }
            case 12: {
                return et.getUserRoleDataName();
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
        UserRoleDataActionBase.set(this, index, objValue);
    }

    private static void set(UserRoleDataActionBase et, int index, Object obj) throws Exception {
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
                et.setIsAllow(DataObject.getIntegerValue(obj));
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
                et.setUserRoleDataActionId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUserRoleDataActionName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserRoleDataId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserRoleDataName(DataObject.getStringValue(obj));
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
        return UserRoleDataActionBase.isNull(this, index);
    }

    private static boolean isNull(UserRoleDataActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getIsAllow() == null;
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
                return et.getUserRoleDataActionId() == null;
            }
            case 10: {
                return et.getUserRoleDataActionName() == null;
            }
            case 11: {
                return et.getUserRoleDataId() == null;
            }
            case 12: {
                return et.getUserRoleDataName() == null;
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
        return UserRoleDataActionBase.contains(this, index);
    }

    private static boolean contains(UserRoleDataActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isIsAllowDirty();
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
                return et.isUserRoleDataActionIdDirty();
            }
            case 10: {
                return et.isUserRoleDataActionNameDirty();
            }
            case 11: {
                return et.isUserRoleDataIdDirty();
            }
            case 12: {
                return et.isUserRoleDataNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserRoleDataActionBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserRoleDataActionBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserRoleDataActionBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserRoleDataActionBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getIsAllow() != null) {
            JSONObjectHelper.put(json, "isallow", UserRoleDataActionBase.getJSONValue(et.getIsAllow()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserRoleDataActionBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserRoleDataActionBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserRoleDataActionBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UserRoleDataActionBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserRoleDataActionBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserRoleDataActionBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserRoleDataActionId() != null) {
            JSONObjectHelper.put(json, "userroledataactionid", UserRoleDataActionBase.getJSONValue(et.getUserRoleDataActionId()), false);
        }
        if (bIncEmpty || et.getUserRoleDataActionName() != null) {
            JSONObjectHelper.put(json, "userroledataactionname", UserRoleDataActionBase.getJSONValue(et.getUserRoleDataActionName()), false);
        }
        if (bIncEmpty || et.getUserRoleDataId() != null) {
            JSONObjectHelper.put(json, "userroledataid", UserRoleDataActionBase.getJSONValue(et.getUserRoleDataId()), false);
        }
        if (bIncEmpty || et.getUserRoleDataName() != null) {
            JSONObjectHelper.put(json, "userroledataname", UserRoleDataActionBase.getJSONValue(et.getUserRoleDataName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserRoleDataActionBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserRoleDataActionBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsAllow() != null) {
            obj = et.getIsAllow();
            node.setAttribute(FIELD_ISALLOW, obj == null ? "" : StringHelper.format("%1$s", obj));
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
        if (bIncEmpty || et.getUserRoleDataActionId() != null) {
            obj = et.getUserRoleDataActionId();
            node.setAttribute(FIELD_USERROLEDATAACTIONID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDataActionName() != null) {
            obj = et.getUserRoleDataActionName();
            node.setAttribute(FIELD_USERROLEDATAACTIONNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDataId() != null) {
            obj = et.getUserRoleDataId();
            node.setAttribute(FIELD_USERROLEDATAID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDataName() != null) {
            obj = et.getUserRoleDataName();
            node.setAttribute(FIELD_USERROLEDATANAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleDataActionBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserRoleDataActionBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isIsAllowDirty() && (bIncEmpty || et.getIsAllow() != null)) {
            dst.set(FIELD_ISALLOW, et.getIsAllow());
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
        if (et.isUserRoleDataActionIdDirty() && (bIncEmpty || et.getUserRoleDataActionId() != null)) {
            dst.set(FIELD_USERROLEDATAACTIONID, et.getUserRoleDataActionId());
        }
        if (et.isUserRoleDataActionNameDirty() && (bIncEmpty || et.getUserRoleDataActionName() != null)) {
            dst.set(FIELD_USERROLEDATAACTIONNAME, et.getUserRoleDataActionName());
        }
        if (et.isUserRoleDataIdDirty() && (bIncEmpty || et.getUserRoleDataId() != null)) {
            dst.set(FIELD_USERROLEDATAID, et.getUserRoleDataId());
        }
        if (et.isUserRoleDataNameDirty() && (bIncEmpty || et.getUserRoleDataName() != null)) {
            dst.set(FIELD_USERROLEDATANAME, et.getUserRoleDataName());
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
        return UserRoleDataActionBase.remove(this, index);
    }

    private static boolean remove(UserRoleDataActionBase et, int index) throws Exception {
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
                et.resetIsAllow();
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
                et.resetUserRoleDataActionId();
                return true;
            }
            case 10: {
                et.resetUserRoleDataActionName();
                return true;
            }
            case 11: {
                et.resetUserRoleDataId();
                return true;
            }
            case 12: {
                et.resetUserRoleDataName();
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

    private UserRoleDataActionBase getProxyEntity() {
        return this.proxyUserRoleDataActionBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleDataActionBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserRoleDataActionBase) {
            this.proxyUserRoleDataActionBase = (UserRoleDataActionBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDataActionService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

