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
import net.ibizsys.psrt.srv.common.entity.UniRes;
import net.ibizsys.psrt.srv.common.entity.UserRole;
import net.ibizsys.psrt.srv.common.service.UniResService;
import net.ibizsys.psrt.srv.common.service.UserRoleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserRoleResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleResBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISALLOW = "ISALLOW";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UNIRESID = "UNIRESID";
    public static final String FIELD_UNIRESNAME = "UNIRESNAME";
    public static final String FIELD_UNIRESTYPE = "UNIRESTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERROLEID = "USERROLEID";
    public static final String FIELD_USERROLENAME = "USERROLENAME";
    public static final String FIELD_USERROLERESID = "USERROLERESID";
    public static final String FIELD_USERROLERESNAME = "USERROLERESNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ISALLOW = 2;
    private static final int INDEX_RESERVER = 3;
    private static final int INDEX_RESERVER2 = 4;
    private static final int INDEX_RESERVER3 = 5;
    private static final int INDEX_RESERVER4 = 6;
    private static final int INDEX_UNIRESID = 7;
    private static final int INDEX_UNIRESNAME = 8;
    private static final int INDEX_UNIRESTYPE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERROLEID = 12;
    private static final int INDEX_USERROLENAME = 13;
    private static final int INDEX_USERROLERESID = 14;
    private static final int INDEX_USERROLERESNAME = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserRoleResBase proxyUserRoleResBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean isallowDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean uniresidDirtyFlag = false;
    private boolean uniresnameDirtyFlag = false;
    private boolean unirestypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userroleidDirtyFlag = false;
    private boolean userrolenameDirtyFlag = false;
    private boolean userroleresidDirtyFlag = false;
    private boolean userroleresnameDirtyFlag = false;
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
    @Column(name="uniresid")
    private String uniresid;
    @Column(name="uniresname")
    private String uniresname;
    @Column(name="unirestype")
    private String unirestype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userroleid")
    private String userroleid;
    @Column(name="userrolename")
    private String userrolename;
    @Column(name="userroleresid")
    private String userroleresid;
    @Column(name="userroleresname")
    private String userroleresname;
    private Integer objUniResLock = new Integer(1);
    private UniRes unires = null;
    private Integer objUserRoleLock = new Integer(1);
    private UserRole userrole = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ISALLOW, 2);
        fieldIndexMap.put(FIELD_RESERVER, 3);
        fieldIndexMap.put(FIELD_RESERVER2, 4);
        fieldIndexMap.put(FIELD_RESERVER3, 5);
        fieldIndexMap.put(FIELD_RESERVER4, 6);
        fieldIndexMap.put(FIELD_UNIRESID, 7);
        fieldIndexMap.put(FIELD_UNIRESNAME, 8);
        fieldIndexMap.put(FIELD_UNIRESTYPE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERROLEID, 12);
        fieldIndexMap.put(FIELD_USERROLENAME, 13);
        fieldIndexMap.put(FIELD_USERROLERESID, 14);
        fieldIndexMap.put(FIELD_USERROLERESNAME, 15);
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

    public void setUniResId(String uniresid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniResId(uniresid);
            return;
        }
        if (uniresid != null && (uniresid = StringHelper.trimRight(uniresid)).length() == 0) {
            uniresid = null;
        }
        this.uniresid = uniresid;
        this.uniresidDirtyFlag = true;
    }

    public String getUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniResId();
        }
        return this.uniresid;
    }

    public boolean isUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniResIdDirty();
        }
        return this.uniresidDirtyFlag;
    }

    public void resetUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniResId();
            return;
        }
        this.uniresidDirtyFlag = false;
        this.uniresid = null;
    }

    public void setUniResName(String uniresname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniResName(uniresname);
            return;
        }
        if (uniresname != null && (uniresname = StringHelper.trimRight(uniresname)).length() == 0) {
            uniresname = null;
        }
        this.uniresname = uniresname;
        this.uniresnameDirtyFlag = true;
    }

    public String getUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniResName();
        }
        return this.uniresname;
    }

    public boolean isUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniResNameDirty();
        }
        return this.uniresnameDirtyFlag;
    }

    public void resetUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniResName();
            return;
        }
        this.uniresnameDirtyFlag = false;
        this.uniresname = null;
    }

    public void setUniResType(String unirestype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniResType(unirestype);
            return;
        }
        if (unirestype != null && (unirestype = StringHelper.trimRight(unirestype)).length() == 0) {
            unirestype = null;
        }
        this.unirestype = unirestype;
        this.unirestypeDirtyFlag = true;
    }

    public String getUniResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniResType();
        }
        return this.unirestype;
    }

    public boolean isUniResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniResTypeDirty();
        }
        return this.unirestypeDirtyFlag;
    }

    public void resetUniResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniResType();
            return;
        }
        this.unirestypeDirtyFlag = false;
        this.unirestype = null;
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

    public void setUserRoleResId(String userroleresid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleResId(userroleresid);
            return;
        }
        if (userroleresid != null && (userroleresid = StringHelper.trimRight(userroleresid)).length() == 0) {
            userroleresid = null;
        }
        this.userroleresid = userroleresid;
        this.userroleresidDirtyFlag = true;
    }

    public String getUserRoleResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleResId();
        }
        return this.userroleresid;
    }

    public boolean isUserRoleResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleResIdDirty();
        }
        return this.userroleresidDirtyFlag;
    }

    public void resetUserRoleResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleResId();
            return;
        }
        this.userroleresidDirtyFlag = false;
        this.userroleresid = null;
    }

    public void setUserRoleResName(String userroleresname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleResName(userroleresname);
            return;
        }
        if (userroleresname != null && (userroleresname = StringHelper.trimRight(userroleresname)).length() == 0) {
            userroleresname = null;
        }
        this.userroleresname = userroleresname;
        this.userroleresnameDirtyFlag = true;
    }

    public String getUserRoleResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleResName();
        }
        return this.userroleresname;
    }

    public boolean isUserRoleResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleResNameDirty();
        }
        return this.userroleresnameDirtyFlag;
    }

    public void resetUserRoleResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleResName();
            return;
        }
        this.userroleresnameDirtyFlag = false;
        this.userroleresname = null;
    }

    @Override
    protected void onReset() {
        UserRoleResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserRoleResBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsAllow();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUniResId();
        et.resetUniResName();
        et.resetUniResType();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserRoleId();
        et.resetUserRoleName();
        et.resetUserRoleResId();
        et.resetUserRoleResName();
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
        if (!bDirtyOnly || this.isUniResIdDirty()) {
            params.put(FIELD_UNIRESID, this.getUniResId());
        }
        if (!bDirtyOnly || this.isUniResNameDirty()) {
            params.put(FIELD_UNIRESNAME, this.getUniResName());
        }
        if (!bDirtyOnly || this.isUniResTypeDirty()) {
            params.put(FIELD_UNIRESTYPE, this.getUniResType());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserRoleIdDirty()) {
            params.put(FIELD_USERROLEID, this.getUserRoleId());
        }
        if (!bDirtyOnly || this.isUserRoleNameDirty()) {
            params.put(FIELD_USERROLENAME, this.getUserRoleName());
        }
        if (!bDirtyOnly || this.isUserRoleResIdDirty()) {
            params.put(FIELD_USERROLERESID, this.getUserRoleResId());
        }
        if (!bDirtyOnly || this.isUserRoleResNameDirty()) {
            params.put(FIELD_USERROLERESNAME, this.getUserRoleResName());
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
        return UserRoleResBase.get(this, index);
    }

    private static Object get(UserRoleResBase et, int index) throws Exception {
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
                return et.getUniResId();
            }
            case 8: {
                return et.getUniResName();
            }
            case 9: {
                return et.getUniResType();
            }
            case 10: {
                return et.getUpdateDate();
            }
            case 11: {
                return et.getUpdateMan();
            }
            case 12: {
                return et.getUserRoleId();
            }
            case 13: {
                return et.getUserRoleName();
            }
            case 14: {
                return et.getUserRoleResId();
            }
            case 15: {
                return et.getUserRoleResName();
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
        UserRoleResBase.set(this, index, objValue);
    }

    private static void set(UserRoleResBase et, int index, Object obj) throws Exception {
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
                et.setUniResId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUniResName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUniResType(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 11: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserRoleId(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUserRoleName(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUserRoleResId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserRoleResName(DataObject.getStringValue(obj));
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
        return UserRoleResBase.isNull(this, index);
    }

    private static boolean isNull(UserRoleResBase et, int index) throws Exception {
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
                return et.getUniResId() == null;
            }
            case 8: {
                return et.getUniResName() == null;
            }
            case 9: {
                return et.getUniResType() == null;
            }
            case 10: {
                return et.getUpdateDate() == null;
            }
            case 11: {
                return et.getUpdateMan() == null;
            }
            case 12: {
                return et.getUserRoleId() == null;
            }
            case 13: {
                return et.getUserRoleName() == null;
            }
            case 14: {
                return et.getUserRoleResId() == null;
            }
            case 15: {
                return et.getUserRoleResName() == null;
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
        return UserRoleResBase.contains(this, index);
    }

    private static boolean contains(UserRoleResBase et, int index) throws Exception {
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
                return et.isUniResIdDirty();
            }
            case 8: {
                return et.isUniResNameDirty();
            }
            case 9: {
                return et.isUniResTypeDirty();
            }
            case 10: {
                return et.isUpdateDateDirty();
            }
            case 11: {
                return et.isUpdateManDirty();
            }
            case 12: {
                return et.isUserRoleIdDirty();
            }
            case 13: {
                return et.isUserRoleNameDirty();
            }
            case 14: {
                return et.isUserRoleResIdDirty();
            }
            case 15: {
                return et.isUserRoleResNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserRoleResBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserRoleResBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserRoleResBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserRoleResBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getIsAllow() != null) {
            JSONObjectHelper.put(json, "isallow", UserRoleResBase.getJSONValue(et.getIsAllow()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserRoleResBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserRoleResBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserRoleResBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UserRoleResBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUniResId() != null) {
            JSONObjectHelper.put(json, "uniresid", UserRoleResBase.getJSONValue(et.getUniResId()), false);
        }
        if (bIncEmpty || et.getUniResName() != null) {
            JSONObjectHelper.put(json, "uniresname", UserRoleResBase.getJSONValue(et.getUniResName()), false);
        }
        if (bIncEmpty || et.getUniResType() != null) {
            JSONObjectHelper.put(json, "unirestype", UserRoleResBase.getJSONValue(et.getUniResType()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserRoleResBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserRoleResBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserRoleId() != null) {
            JSONObjectHelper.put(json, "userroleid", UserRoleResBase.getJSONValue(et.getUserRoleId()), false);
        }
        if (bIncEmpty || et.getUserRoleName() != null) {
            JSONObjectHelper.put(json, "userrolename", UserRoleResBase.getJSONValue(et.getUserRoleName()), false);
        }
        if (bIncEmpty || et.getUserRoleResId() != null) {
            JSONObjectHelper.put(json, "userroleresid", UserRoleResBase.getJSONValue(et.getUserRoleResId()), false);
        }
        if (bIncEmpty || et.getUserRoleResName() != null) {
            JSONObjectHelper.put(json, "userroleresname", UserRoleResBase.getJSONValue(et.getUserRoleResName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserRoleResBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserRoleResBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getUniResId() != null) {
            obj = et.getUniResId();
            node.setAttribute(FIELD_UNIRESID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUniResName() != null) {
            obj = et.getUniResName();
            node.setAttribute(FIELD_UNIRESNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUniResType() != null) {
            obj = et.getUniResType();
            node.setAttribute(FIELD_UNIRESTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleId() != null) {
            obj = et.getUserRoleId();
            node.setAttribute(FIELD_USERROLEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleName() != null) {
            obj = et.getUserRoleName();
            node.setAttribute(FIELD_USERROLENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleResId() != null) {
            obj = et.getUserRoleResId();
            node.setAttribute(FIELD_USERROLERESID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleResName() != null) {
            obj = et.getUserRoleResName();
            node.setAttribute(FIELD_USERROLERESNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleResBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserRoleResBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
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
        if (et.isUniResIdDirty() && (bIncEmpty || et.getUniResId() != null)) {
            dst.set(FIELD_UNIRESID, et.getUniResId());
        }
        if (et.isUniResNameDirty() && (bIncEmpty || et.getUniResName() != null)) {
            dst.set(FIELD_UNIRESNAME, et.getUniResName());
        }
        if (et.isUniResTypeDirty() && (bIncEmpty || et.getUniResType() != null)) {
            dst.set(FIELD_UNIRESTYPE, et.getUniResType());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserRoleIdDirty() && (bIncEmpty || et.getUserRoleId() != null)) {
            dst.set(FIELD_USERROLEID, et.getUserRoleId());
        }
        if (et.isUserRoleNameDirty() && (bIncEmpty || et.getUserRoleName() != null)) {
            dst.set(FIELD_USERROLENAME, et.getUserRoleName());
        }
        if (et.isUserRoleResIdDirty() && (bIncEmpty || et.getUserRoleResId() != null)) {
            dst.set(FIELD_USERROLERESID, et.getUserRoleResId());
        }
        if (et.isUserRoleResNameDirty() && (bIncEmpty || et.getUserRoleResName() != null)) {
            dst.set(FIELD_USERROLERESNAME, et.getUserRoleResName());
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
        return UserRoleResBase.remove(this, index);
    }

    private static boolean remove(UserRoleResBase et, int index) throws Exception {
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
                et.resetUniResId();
                return true;
            }
            case 8: {
                et.resetUniResName();
                return true;
            }
            case 9: {
                et.resetUniResType();
                return true;
            }
            case 10: {
                et.resetUpdateDate();
                return true;
            }
            case 11: {
                et.resetUpdateMan();
                return true;
            }
            case 12: {
                et.resetUserRoleId();
                return true;
            }
            case 13: {
                et.resetUserRoleName();
                return true;
            }
            case 14: {
                et.resetUserRoleResId();
                return true;
            }
            case 15: {
                et.resetUserRoleResName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UniRes getUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniRes();
        }
        if (this.getUniResId() == null) {
            return null;
        }
        Integer n = this.objUniResLock;
        synchronized (n) {
            if (this.unires != null && DataTypeHelper.compare(25, (Object)this.getUniResId(), (Object)this.unires.getUniResId()) != 0L) {
                this.unires = null;
            }
            if (this.unires == null) {
                UniRes unires = new UniRes();
                unires.setUniResId(this.getUniResId());
                UniResService service = (UniResService)ServiceGlobal.getService(UniResService.class, this.getSessionFactory());
                service.autoGet(unires);
                this.unires = unires;
            }
            return this.unires;
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

    private UserRoleResBase getProxyEntity() {
        return this.proxyUserRoleResBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleResBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserRoleResBase) {
            this.proxyUserRoleResBase = (UserRoleResBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleResService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

