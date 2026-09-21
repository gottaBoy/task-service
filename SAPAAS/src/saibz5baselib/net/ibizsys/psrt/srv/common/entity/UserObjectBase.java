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
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserObjectBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserObjectBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_OWNERTYPE = "OWNERTYPE";
    public static final String FIELD_SUBTYPE = "SUBTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USEROBJECTID = "USEROBJECTID";
    public static final String FIELD_USEROBJECTLEVEL = "USEROBJECTLEVEL";
    public static final String FIELD_USEROBJECTNAME = "USEROBJECTNAME";
    public static final String FIELD_USEROBJECTTYPE = "USEROBJECTTYPE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_OWNERID = 4;
    private static final int INDEX_OWNERTYPE = 5;
    private static final int INDEX_SUBTYPE = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_USERDATA = 9;
    private static final int INDEX_USERDATA2 = 10;
    private static final int INDEX_USEROBJECTID = 11;
    private static final int INDEX_USEROBJECTLEVEL = 12;
    private static final int INDEX_USEROBJECTNAME = 13;
    private static final int INDEX_USEROBJECTTYPE = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserObjectBase proxyUserObjectBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean subtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userobjectidDirtyFlag = false;
    private boolean userobjectlevelDirtyFlag = false;
    private boolean userobjectnameDirtyFlag = false;
    private boolean userobjecttypeDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="subtype")
    private String subtype;
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
    @Column(name="userobjectlevel")
    private Integer userobjectlevel;
    @Column(name="userobjectname")
    private String userobjectname;
    @Column(name="userobjecttype")
    private String userobjecttype;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_OWNERID, 4);
        fieldIndexMap.put(FIELD_OWNERTYPE, 5);
        fieldIndexMap.put(FIELD_SUBTYPE, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_USERDATA, 9);
        fieldIndexMap.put(FIELD_USERDATA2, 10);
        fieldIndexMap.put(FIELD_USEROBJECTID, 11);
        fieldIndexMap.put(FIELD_USEROBJECTLEVEL, 12);
        fieldIndexMap.put(FIELD_USEROBJECTNAME, 13);
        fieldIndexMap.put(FIELD_USEROBJECTTYPE, 14);
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

    public void setEnable(Integer enable) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setOwnerId(String ownerid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(ownerid);
            return;
        }
        if (ownerid != null && (ownerid = StringHelper.trimRight(ownerid)).length() == 0) {
            ownerid = null;
        }
        this.ownerid = ownerid;
        this.owneridDirtyFlag = true;
    }

    public String getOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    public boolean isOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    public void resetOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }
        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }

    public void setOwnerType(String ownertype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerType(ownertype);
            return;
        }
        if (ownertype != null && (ownertype = StringHelper.trimRight(ownertype)).length() == 0) {
            ownertype = null;
        }
        this.ownertype = ownertype;
        this.ownertypeDirtyFlag = true;
    }

    public String getOwnerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerType();
        }
        return this.ownertype;
    }

    public boolean isOwnerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTypeDirty();
        }
        return this.ownertypeDirtyFlag;
    }

    public void resetOwnerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerType();
            return;
        }
        this.ownertypeDirtyFlag = false;
        this.ownertype = null;
    }

    public void setSubType(String subtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubType(subtype);
            return;
        }
        if (subtype != null && (subtype = StringHelper.trimRight(subtype)).length() == 0) {
            subtype = null;
        }
        this.subtype = subtype;
        this.subtypeDirtyFlag = true;
    }

    public String getSubType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubType();
        }
        return this.subtype;
    }

    public boolean isSubTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubTypeDirty();
        }
        return this.subtypeDirtyFlag;
    }

    public void resetSubType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubType();
            return;
        }
        this.subtypeDirtyFlag = false;
        this.subtype = null;
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

    public void setUserObjectLevel(Integer userobjectlevel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserObjectLevel(userobjectlevel);
            return;
        }
        this.userobjectlevel = userobjectlevel;
        this.userobjectlevelDirtyFlag = true;
    }

    public Integer getUserObjectLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserObjectLevel();
        }
        return this.userobjectlevel;
    }

    public boolean isUserObjectLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserObjectLevelDirty();
        }
        return this.userobjectlevelDirtyFlag;
    }

    public void resetUserObjectLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserObjectLevel();
            return;
        }
        this.userobjectlevelDirtyFlag = false;
        this.userobjectlevel = null;
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

    public void setUserObjectType(String userobjecttype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserObjectType(userobjecttype);
            return;
        }
        if (userobjecttype != null && (userobjecttype = StringHelper.trimRight(userobjecttype)).length() == 0) {
            userobjecttype = null;
        }
        this.userobjecttype = userobjecttype;
        this.userobjecttypeDirtyFlag = true;
    }

    public String getUserObjectType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserObjectType();
        }
        return this.userobjecttype;
    }

    public boolean isUserObjectTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserObjectTypeDirty();
        }
        return this.userobjecttypeDirtyFlag;
    }

    public void resetUserObjectType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserObjectType();
            return;
        }
        this.userobjecttypeDirtyFlag = false;
        this.userobjecttype = null;
    }

    @Override
    protected void onReset() {
        UserObjectBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserObjectBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnable();
        et.resetMemo();
        et.resetOwnerId();
        et.resetOwnerType();
        et.resetSubType();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserObjectId();
        et.resetUserObjectLevel();
        et.resetUserObjectName();
        et.resetUserObjectType();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEnableDirty()) {
            params.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isOwnerIdDirty()) {
            params.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bDirtyOnly || this.isOwnerTypeDirty()) {
            params.put(FIELD_OWNERTYPE, this.getOwnerType());
        }
        if (!bDirtyOnly || this.isSubTypeDirty()) {
            params.put(FIELD_SUBTYPE, this.getSubType());
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
        if (!bDirtyOnly || this.isUserObjectLevelDirty()) {
            params.put(FIELD_USEROBJECTLEVEL, this.getUserObjectLevel());
        }
        if (!bDirtyOnly || this.isUserObjectNameDirty()) {
            params.put(FIELD_USEROBJECTNAME, this.getUserObjectName());
        }
        if (!bDirtyOnly || this.isUserObjectTypeDirty()) {
            params.put(FIELD_USEROBJECTTYPE, this.getUserObjectType());
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
        return UserObjectBase.get(this, index);
    }

    private static Object get(UserObjectBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getEnable();
            }
            case 3: {
                return et.getMemo();
            }
            case 4: {
                return et.getOwnerId();
            }
            case 5: {
                return et.getOwnerType();
            }
            case 6: {
                return et.getSubType();
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
                return et.getUserObjectLevel();
            }
            case 13: {
                return et.getUserObjectName();
            }
            case 14: {
                return et.getUserObjectType();
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
        UserObjectBase.set(this, index, objValue);
    }

    private static void set(UserObjectBase et, int index, Object obj) throws Exception {
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
                et.setEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setOwnerId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setOwnerType(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setSubType(DataObject.getStringValue(obj));
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
                et.setUserObjectLevel(DataObject.getIntegerValue(obj));
                return;
            }
            case 13: {
                et.setUserObjectName(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUserObjectType(DataObject.getStringValue(obj));
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
        return UserObjectBase.isNull(this, index);
    }

    private static boolean isNull(UserObjectBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getEnable() == null;
            }
            case 3: {
                return et.getMemo() == null;
            }
            case 4: {
                return et.getOwnerId() == null;
            }
            case 5: {
                return et.getOwnerType() == null;
            }
            case 6: {
                return et.getSubType() == null;
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
                return et.getUserObjectLevel() == null;
            }
            case 13: {
                return et.getUserObjectName() == null;
            }
            case 14: {
                return et.getUserObjectType() == null;
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
        return UserObjectBase.contains(this, index);
    }

    private static boolean contains(UserObjectBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isEnableDirty();
            }
            case 3: {
                return et.isMemoDirty();
            }
            case 4: {
                return et.isOwnerIdDirty();
            }
            case 5: {
                return et.isOwnerTypeDirty();
            }
            case 6: {
                return et.isSubTypeDirty();
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
                return et.isUserObjectLevelDirty();
            }
            case 13: {
                return et.isUserObjectNameDirty();
            }
            case 14: {
                return et.isUserObjectTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserObjectBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserObjectBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserObjectBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserObjectBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEnable() != null) {
            JSONObjectHelper.put(json, "enable", UserObjectBase.getJSONValue(et.getEnable()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", UserObjectBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOwnerId() != null) {
            JSONObjectHelper.put(json, "ownerid", UserObjectBase.getJSONValue(et.getOwnerId()), false);
        }
        if (bIncEmpty || et.getOwnerType() != null) {
            JSONObjectHelper.put(json, "ownertype", UserObjectBase.getJSONValue(et.getOwnerType()), false);
        }
        if (bIncEmpty || et.getSubType() != null) {
            JSONObjectHelper.put(json, "subtype", UserObjectBase.getJSONValue(et.getSubType()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserObjectBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserObjectBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", UserObjectBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", UserObjectBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserObjectId() != null) {
            JSONObjectHelper.put(json, "userobjectid", UserObjectBase.getJSONValue(et.getUserObjectId()), false);
        }
        if (bIncEmpty || et.getUserObjectLevel() != null) {
            JSONObjectHelper.put(json, "userobjectlevel", UserObjectBase.getJSONValue(et.getUserObjectLevel()), false);
        }
        if (bIncEmpty || et.getUserObjectName() != null) {
            JSONObjectHelper.put(json, "userobjectname", UserObjectBase.getJSONValue(et.getUserObjectName()), false);
        }
        if (bIncEmpty || et.getUserObjectType() != null) {
            JSONObjectHelper.put(json, "userobjecttype", UserObjectBase.getJSONValue(et.getUserObjectType()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserObjectBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserObjectBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnable() != null) {
            obj = et.getEnable();
            node.setAttribute(FIELD_ENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOwnerId() != null) {
            obj = et.getOwnerId();
            node.setAttribute(FIELD_OWNERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOwnerType() != null) {
            obj = et.getOwnerType();
            node.setAttribute(FIELD_OWNERTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSubType() != null) {
            obj = et.getSubType();
            node.setAttribute(FIELD_SUBTYPE, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getUserObjectLevel() != null) {
            obj = et.getUserObjectLevel();
            node.setAttribute(FIELD_USEROBJECTLEVEL, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUserObjectName() != null) {
            obj = et.getUserObjectName();
            node.setAttribute(FIELD_USEROBJECTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserObjectType() != null) {
            obj = et.getUserObjectType();
            node.setAttribute(FIELD_USEROBJECTTYPE, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserObjectBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserObjectBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEnableDirty() && (bIncEmpty || et.getEnable() != null)) {
            dst.set(FIELD_ENABLE, et.getEnable());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOwnerIdDirty() && (bIncEmpty || et.getOwnerId() != null)) {
            dst.set(FIELD_OWNERID, et.getOwnerId());
        }
        if (et.isOwnerTypeDirty() && (bIncEmpty || et.getOwnerType() != null)) {
            dst.set(FIELD_OWNERTYPE, et.getOwnerType());
        }
        if (et.isSubTypeDirty() && (bIncEmpty || et.getSubType() != null)) {
            dst.set(FIELD_SUBTYPE, et.getSubType());
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
        if (et.isUserObjectLevelDirty() && (bIncEmpty || et.getUserObjectLevel() != null)) {
            dst.set(FIELD_USEROBJECTLEVEL, et.getUserObjectLevel());
        }
        if (et.isUserObjectNameDirty() && (bIncEmpty || et.getUserObjectName() != null)) {
            dst.set(FIELD_USEROBJECTNAME, et.getUserObjectName());
        }
        if (et.isUserObjectTypeDirty() && (bIncEmpty || et.getUserObjectType() != null)) {
            dst.set(FIELD_USEROBJECTTYPE, et.getUserObjectType());
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
        return UserObjectBase.remove(this, index);
    }

    private static boolean remove(UserObjectBase et, int index) throws Exception {
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
                et.resetEnable();
                return true;
            }
            case 3: {
                et.resetMemo();
                return true;
            }
            case 4: {
                et.resetOwnerId();
                return true;
            }
            case 5: {
                et.resetOwnerType();
                return true;
            }
            case 6: {
                et.resetSubType();
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
                et.resetUserObjectLevel();
                return true;
            }
            case 13: {
                et.resetUserObjectName();
                return true;
            }
            case 14: {
                et.resetUserObjectType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private UserObjectBase getProxyEntity() {
        return this.proxyUserObjectBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserObjectBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserObjectBase) {
            this.proxyUserObjectBase = (UserObjectBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserObjectService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

