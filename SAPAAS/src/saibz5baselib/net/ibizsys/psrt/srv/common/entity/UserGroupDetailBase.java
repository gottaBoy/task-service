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
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.ibizsys.psrt.srv.common.service.UserGroupService;
import net.ibizsys.psrt.srv.common.service.UserObjectService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserGroupDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserGroupDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERGROUPDETAILID = "USERGROUPDETAILID";
    public static final String FIELD_USERGROUPDETAILNAME = "USERGROUPDETAILNAME";
    public static final String FIELD_USERGROUPID = "USERGROUPID";
    public static final String FIELD_USERGROUPNAME = "USERGROUPNAME";
    public static final String FIELD_USEROBJECTID = "USEROBJECTID";
    public static final String FIELD_USEROBJECTNAME = "USEROBJECTNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_UPDATEDATE = 2;
    private static final int INDEX_UPDATEMAN = 3;
    private static final int INDEX_USERDATA = 4;
    private static final int INDEX_USERDATA2 = 5;
    private static final int INDEX_USERGROUPDETAILID = 6;
    private static final int INDEX_USERGROUPDETAILNAME = 7;
    private static final int INDEX_USERGROUPID = 8;
    private static final int INDEX_USERGROUPNAME = 9;
    private static final int INDEX_USEROBJECTID = 10;
    private static final int INDEX_USEROBJECTNAME = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserGroupDetailBase proxyUserGroupDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usergroupdetailidDirtyFlag = false;
    private boolean usergroupdetailnameDirtyFlag = false;
    private boolean usergroupidDirtyFlag = false;
    private boolean usergroupnameDirtyFlag = false;
    private boolean userobjectidDirtyFlag = false;
    private boolean userobjectnameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usergroupdetailid")
    private String usergroupdetailid;
    @Column(name="usergroupdetailname")
    private String usergroupdetailname;
    @Column(name="usergroupid")
    private String usergroupid;
    @Column(name="usergroupname")
    private String usergroupname;
    @Column(name="userobjectid")
    private String userobjectid;
    @Column(name="userobjectname")
    private String userobjectname;
    private Integer objUserGroupLock = new Integer(1);
    private UserGroup usergroup = null;
    private Integer objUserObjectLock = new Integer(1);
    private UserObject userobject = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_UPDATEDATE, 2);
        fieldIndexMap.put(FIELD_UPDATEMAN, 3);
        fieldIndexMap.put(FIELD_USERDATA, 4);
        fieldIndexMap.put(FIELD_USERDATA2, 5);
        fieldIndexMap.put(FIELD_USERGROUPDETAILID, 6);
        fieldIndexMap.put(FIELD_USERGROUPDETAILNAME, 7);
        fieldIndexMap.put(FIELD_USERGROUPID, 8);
        fieldIndexMap.put(FIELD_USERGROUPNAME, 9);
        fieldIndexMap.put(FIELD_USEROBJECTID, 10);
        fieldIndexMap.put(FIELD_USEROBJECTNAME, 11);
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

    public void setUserGroupDetailId(String usergroupdetailid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserGroupDetailId(usergroupdetailid);
            return;
        }
        if (usergroupdetailid != null && (usergroupdetailid = StringHelper.trimRight(usergroupdetailid)).length() == 0) {
            usergroupdetailid = null;
        }
        this.usergroupdetailid = usergroupdetailid;
        this.usergroupdetailidDirtyFlag = true;
    }

    public String getUserGroupDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserGroupDetailId();
        }
        return this.usergroupdetailid;
    }

    public boolean isUserGroupDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserGroupDetailIdDirty();
        }
        return this.usergroupdetailidDirtyFlag;
    }

    public void resetUserGroupDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserGroupDetailId();
            return;
        }
        this.usergroupdetailidDirtyFlag = false;
        this.usergroupdetailid = null;
    }

    public void setUserGroupDetailName(String usergroupdetailname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserGroupDetailName(usergroupdetailname);
            return;
        }
        if (usergroupdetailname != null && (usergroupdetailname = StringHelper.trimRight(usergroupdetailname)).length() == 0) {
            usergroupdetailname = null;
        }
        this.usergroupdetailname = usergroupdetailname;
        this.usergroupdetailnameDirtyFlag = true;
    }

    public String getUserGroupDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserGroupDetailName();
        }
        return this.usergroupdetailname;
    }

    public boolean isUserGroupDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserGroupDetailNameDirty();
        }
        return this.usergroupdetailnameDirtyFlag;
    }

    public void resetUserGroupDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserGroupDetailName();
            return;
        }
        this.usergroupdetailnameDirtyFlag = false;
        this.usergroupdetailname = null;
    }

    public void setUserGroupId(String usergroupid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserGroupId(usergroupid);
            return;
        }
        if (usergroupid != null && (usergroupid = StringHelper.trimRight(usergroupid)).length() == 0) {
            usergroupid = null;
        }
        this.usergroupid = usergroupid;
        this.usergroupidDirtyFlag = true;
    }

    public String getUserGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserGroupId();
        }
        return this.usergroupid;
    }

    public boolean isUserGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserGroupIdDirty();
        }
        return this.usergroupidDirtyFlag;
    }

    public void resetUserGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserGroupId();
            return;
        }
        this.usergroupidDirtyFlag = false;
        this.usergroupid = null;
    }

    public void setUserGroupName(String usergroupname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserGroupName(usergroupname);
            return;
        }
        if (usergroupname != null && (usergroupname = StringHelper.trimRight(usergroupname)).length() == 0) {
            usergroupname = null;
        }
        this.usergroupname = usergroupname;
        this.usergroupnameDirtyFlag = true;
    }

    public String getUserGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserGroupName();
        }
        return this.usergroupname;
    }

    public boolean isUserGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserGroupNameDirty();
        }
        return this.usergroupnameDirtyFlag;
    }

    public void resetUserGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserGroupName();
            return;
        }
        this.usergroupnameDirtyFlag = false;
        this.usergroupname = null;
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

    @Override
    protected void onReset() {
        UserGroupDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserGroupDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserGroupDetailId();
        et.resetUserGroupDetailName();
        et.resetUserGroupId();
        et.resetUserGroupName();
        et.resetUserObjectId();
        et.resetUserObjectName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bDirtyOnly || this.isUserGroupDetailIdDirty()) {
            params.put(FIELD_USERGROUPDETAILID, this.getUserGroupDetailId());
        }
        if (!bDirtyOnly || this.isUserGroupDetailNameDirty()) {
            params.put(FIELD_USERGROUPDETAILNAME, this.getUserGroupDetailName());
        }
        if (!bDirtyOnly || this.isUserGroupIdDirty()) {
            params.put(FIELD_USERGROUPID, this.getUserGroupId());
        }
        if (!bDirtyOnly || this.isUserGroupNameDirty()) {
            params.put(FIELD_USERGROUPNAME, this.getUserGroupName());
        }
        if (!bDirtyOnly || this.isUserObjectIdDirty()) {
            params.put(FIELD_USEROBJECTID, this.getUserObjectId());
        }
        if (!bDirtyOnly || this.isUserObjectNameDirty()) {
            params.put(FIELD_USEROBJECTNAME, this.getUserObjectName());
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
        return UserGroupDetailBase.get(this, index);
    }

    private static Object get(UserGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getUpdateDate();
            }
            case 3: {
                return et.getUpdateMan();
            }
            case 4: {
                return et.getUserData();
            }
            case 5: {
                return et.getUserData2();
            }
            case 6: {
                return et.getUserGroupDetailId();
            }
            case 7: {
                return et.getUserGroupDetailName();
            }
            case 8: {
                return et.getUserGroupId();
            }
            case 9: {
                return et.getUserGroupName();
            }
            case 10: {
                return et.getUserObjectId();
            }
            case 11: {
                return et.getUserObjectName();
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
        UserGroupDetailBase.set(this, index, objValue);
    }

    private static void set(UserGroupDetailBase et, int index, Object obj) throws Exception {
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
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setUserGroupDetailId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setUserGroupDetailName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUserGroupId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUserGroupName(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUserObjectId(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserObjectName(DataObject.getStringValue(obj));
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
        return UserGroupDetailBase.isNull(this, index);
    }

    private static boolean isNull(UserGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getUpdateDate() == null;
            }
            case 3: {
                return et.getUpdateMan() == null;
            }
            case 4: {
                return et.getUserData() == null;
            }
            case 5: {
                return et.getUserData2() == null;
            }
            case 6: {
                return et.getUserGroupDetailId() == null;
            }
            case 7: {
                return et.getUserGroupDetailName() == null;
            }
            case 8: {
                return et.getUserGroupId() == null;
            }
            case 9: {
                return et.getUserGroupName() == null;
            }
            case 10: {
                return et.getUserObjectId() == null;
            }
            case 11: {
                return et.getUserObjectName() == null;
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
        return UserGroupDetailBase.contains(this, index);
    }

    private static boolean contains(UserGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isUpdateDateDirty();
            }
            case 3: {
                return et.isUpdateManDirty();
            }
            case 4: {
                return et.isUserDataDirty();
            }
            case 5: {
                return et.isUserData2Dirty();
            }
            case 6: {
                return et.isUserGroupDetailIdDirty();
            }
            case 7: {
                return et.isUserGroupDetailNameDirty();
            }
            case 8: {
                return et.isUserGroupIdDirty();
            }
            case 9: {
                return et.isUserGroupNameDirty();
            }
            case 10: {
                return et.isUserObjectIdDirty();
            }
            case 11: {
                return et.isUserObjectNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserGroupDetailBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserGroupDetailBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserGroupDetailBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserGroupDetailBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserGroupDetailBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserGroupDetailBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", UserGroupDetailBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", UserGroupDetailBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserGroupDetailId() != null) {
            JSONObjectHelper.put(json, "usergroupdetailid", UserGroupDetailBase.getJSONValue(et.getUserGroupDetailId()), false);
        }
        if (bIncEmpty || et.getUserGroupDetailName() != null) {
            JSONObjectHelper.put(json, "usergroupdetailname", UserGroupDetailBase.getJSONValue(et.getUserGroupDetailName()), false);
        }
        if (bIncEmpty || et.getUserGroupId() != null) {
            JSONObjectHelper.put(json, "usergroupid", UserGroupDetailBase.getJSONValue(et.getUserGroupId()), false);
        }
        if (bIncEmpty || et.getUserGroupName() != null) {
            JSONObjectHelper.put(json, "usergroupname", UserGroupDetailBase.getJSONValue(et.getUserGroupName()), false);
        }
        if (bIncEmpty || et.getUserObjectId() != null) {
            JSONObjectHelper.put(json, "userobjectid", UserGroupDetailBase.getJSONValue(et.getUserObjectId()), false);
        }
        if (bIncEmpty || et.getUserObjectName() != null) {
            JSONObjectHelper.put(json, "userobjectname", UserGroupDetailBase.getJSONValue(et.getUserObjectName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserGroupDetailBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserGroupDetailBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getUserGroupDetailId() != null) {
            obj = et.getUserGroupDetailId();
            node.setAttribute(FIELD_USERGROUPDETAILID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserGroupDetailName() != null) {
            obj = et.getUserGroupDetailName();
            node.setAttribute(FIELD_USERGROUPDETAILNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserGroupId() != null) {
            obj = et.getUserGroupId();
            node.setAttribute(FIELD_USERGROUPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserGroupName() != null) {
            obj = et.getUserGroupName();
            node.setAttribute(FIELD_USERGROUPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserObjectId() != null) {
            obj = et.getUserObjectId();
            node.setAttribute(FIELD_USEROBJECTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserObjectName() != null) {
            obj = et.getUserObjectName();
            node.setAttribute(FIELD_USEROBJECTNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserGroupDetailBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserGroupDetailBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
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
        if (et.isUserGroupDetailIdDirty() && (bIncEmpty || et.getUserGroupDetailId() != null)) {
            dst.set(FIELD_USERGROUPDETAILID, et.getUserGroupDetailId());
        }
        if (et.isUserGroupDetailNameDirty() && (bIncEmpty || et.getUserGroupDetailName() != null)) {
            dst.set(FIELD_USERGROUPDETAILNAME, et.getUserGroupDetailName());
        }
        if (et.isUserGroupIdDirty() && (bIncEmpty || et.getUserGroupId() != null)) {
            dst.set(FIELD_USERGROUPID, et.getUserGroupId());
        }
        if (et.isUserGroupNameDirty() && (bIncEmpty || et.getUserGroupName() != null)) {
            dst.set(FIELD_USERGROUPNAME, et.getUserGroupName());
        }
        if (et.isUserObjectIdDirty() && (bIncEmpty || et.getUserObjectId() != null)) {
            dst.set(FIELD_USEROBJECTID, et.getUserObjectId());
        }
        if (et.isUserObjectNameDirty() && (bIncEmpty || et.getUserObjectName() != null)) {
            dst.set(FIELD_USEROBJECTNAME, et.getUserObjectName());
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
        return UserGroupDetailBase.remove(this, index);
    }

    private static boolean remove(UserGroupDetailBase et, int index) throws Exception {
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
                et.resetUpdateDate();
                return true;
            }
            case 3: {
                et.resetUpdateMan();
                return true;
            }
            case 4: {
                et.resetUserData();
                return true;
            }
            case 5: {
                et.resetUserData2();
                return true;
            }
            case 6: {
                et.resetUserGroupDetailId();
                return true;
            }
            case 7: {
                et.resetUserGroupDetailName();
                return true;
            }
            case 8: {
                et.resetUserGroupId();
                return true;
            }
            case 9: {
                et.resetUserGroupName();
                return true;
            }
            case 10: {
                et.resetUserObjectId();
                return true;
            }
            case 11: {
                et.resetUserObjectName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UserGroup getUserGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserGroup();
        }
        if (this.getUserGroupId() == null) {
            return null;
        }
        Integer n = this.objUserGroupLock;
        synchronized (n) {
            if (this.usergroup != null && DataTypeHelper.compare(25, (Object)this.getUserGroupId(), (Object)this.usergroup.getUserGroupId()) != 0L) {
                this.usergroup = null;
            }
            if (this.usergroup == null) {
                UserGroup usergroup = new UserGroup();
                usergroup.setUserGroupId(this.getUserGroupId());
                UserGroupService service = (UserGroupService)ServiceGlobal.getService(UserGroupService.class, this.getSessionFactory());
                service.autoGet(usergroup);
                this.usergroup = usergroup;
            }
            return this.usergroup;
        }
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

    private UserGroupDetailBase getProxyEntity() {
        return this.proxyUserGroupDetailBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserGroupDetailBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserGroupDetailBase) {
            this.proxyUserGroupDetailBase = (UserGroupDetailBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserGroupDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

