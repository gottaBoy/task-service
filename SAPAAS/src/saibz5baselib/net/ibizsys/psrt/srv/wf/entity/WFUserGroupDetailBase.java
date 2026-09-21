/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

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
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroup;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFUserGroupDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUserGroupDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFUSERGROUPDETAILID = "WFUSERGROUPDETAILID";
    public static final String FIELD_WFUSERGROUPDETAILNAME = "WFUSERGROUPDETAILNAME";
    public static final String FIELD_WFUSERGROUPID = "WFUSERGROUPID";
    public static final String FIELD_WFUSERGROUPNAME = "WFUSERGROUPNAME";
    public static final String FIELD_WFUSERID = "WFUSERID";
    public static final String FIELD_WFUSERNAME = "WFUSERNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_UPDATEDATE = 3;
    private static final int INDEX_UPDATEMAN = 4;
    private static final int INDEX_WFUSERGROUPDETAILID = 5;
    private static final int INDEX_WFUSERGROUPDETAILNAME = 6;
    private static final int INDEX_WFUSERGROUPID = 7;
    private static final int INDEX_WFUSERGROUPNAME = 8;
    private static final int INDEX_WFUSERID = 9;
    private static final int INDEX_WFUSERNAME = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFUserGroupDetailBase proxyWFUserGroupDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfusergroupdetailidDirtyFlag = false;
    private boolean wfusergroupdetailnameDirtyFlag = false;
    private boolean wfusergroupidDirtyFlag = false;
    private boolean wfusergroupnameDirtyFlag = false;
    private boolean wfuseridDirtyFlag = false;
    private boolean wfusernameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfusergroupdetailid")
    private String wfusergroupdetailid;
    @Column(name="wfusergroupdetailname")
    private String wfusergroupdetailname;
    @Column(name="wfusergroupid")
    private String wfusergroupid;
    @Column(name="wfusergroupname")
    private String wfusergroupname;
    @Column(name="wfuserid")
    private String wfuserid;
    @Column(name="wfusername")
    private String wfusername;
    private Integer objWFUserGroupLock = new Integer(1);
    private WFUserGroup wfusergroup = null;
    private Integer objWFUserLock = new Integer(1);
    private WFUser wfuser = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_UPDATEDATE, 3);
        fieldIndexMap.put(FIELD_UPDATEMAN, 4);
        fieldIndexMap.put(FIELD_WFUSERGROUPDETAILID, 5);
        fieldIndexMap.put(FIELD_WFUSERGROUPDETAILNAME, 6);
        fieldIndexMap.put(FIELD_WFUSERGROUPID, 7);
        fieldIndexMap.put(FIELD_WFUSERGROUPNAME, 8);
        fieldIndexMap.put(FIELD_WFUSERID, 9);
        fieldIndexMap.put(FIELD_WFUSERNAME, 10);
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

    public void setWFUserGroupDetailId(String wfusergroupdetailid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserGroupDetailId(wfusergroupdetailid);
            return;
        }
        if (wfusergroupdetailid != null && (wfusergroupdetailid = StringHelper.trimRight(wfusergroupdetailid)).length() == 0) {
            wfusergroupdetailid = null;
        }
        this.wfusergroupdetailid = wfusergroupdetailid;
        this.wfusergroupdetailidDirtyFlag = true;
    }

    public String getWFUserGroupDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserGroupDetailId();
        }
        return this.wfusergroupdetailid;
    }

    public boolean isWFUserGroupDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserGroupDetailIdDirty();
        }
        return this.wfusergroupdetailidDirtyFlag;
    }

    public void resetWFUserGroupDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserGroupDetailId();
            return;
        }
        this.wfusergroupdetailidDirtyFlag = false;
        this.wfusergroupdetailid = null;
    }

    public void setWFUserGroupDetailName(String wfusergroupdetailname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserGroupDetailName(wfusergroupdetailname);
            return;
        }
        if (wfusergroupdetailname != null && (wfusergroupdetailname = StringHelper.trimRight(wfusergroupdetailname)).length() == 0) {
            wfusergroupdetailname = null;
        }
        this.wfusergroupdetailname = wfusergroupdetailname;
        this.wfusergroupdetailnameDirtyFlag = true;
    }

    public String getWFUserGroupDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserGroupDetailName();
        }
        return this.wfusergroupdetailname;
    }

    public boolean isWFUserGroupDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserGroupDetailNameDirty();
        }
        return this.wfusergroupdetailnameDirtyFlag;
    }

    public void resetWFUserGroupDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserGroupDetailName();
            return;
        }
        this.wfusergroupdetailnameDirtyFlag = false;
        this.wfusergroupdetailname = null;
    }

    public void setWFUserGroupId(String wfusergroupid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserGroupId(wfusergroupid);
            return;
        }
        if (wfusergroupid != null && (wfusergroupid = StringHelper.trimRight(wfusergroupid)).length() == 0) {
            wfusergroupid = null;
        }
        this.wfusergroupid = wfusergroupid;
        this.wfusergroupidDirtyFlag = true;
    }

    public String getWFUserGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserGroupId();
        }
        return this.wfusergroupid;
    }

    public boolean isWFUserGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserGroupIdDirty();
        }
        return this.wfusergroupidDirtyFlag;
    }

    public void resetWFUserGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserGroupId();
            return;
        }
        this.wfusergroupidDirtyFlag = false;
        this.wfusergroupid = null;
    }

    public void setWFUserGroupName(String wfusergroupname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserGroupName(wfusergroupname);
            return;
        }
        if (wfusergroupname != null && (wfusergroupname = StringHelper.trimRight(wfusergroupname)).length() == 0) {
            wfusergroupname = null;
        }
        this.wfusergroupname = wfusergroupname;
        this.wfusergroupnameDirtyFlag = true;
    }

    public String getWFUserGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserGroupName();
        }
        return this.wfusergroupname;
    }

    public boolean isWFUserGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserGroupNameDirty();
        }
        return this.wfusergroupnameDirtyFlag;
    }

    public void resetWFUserGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserGroupName();
            return;
        }
        this.wfusergroupnameDirtyFlag = false;
        this.wfusergroupname = null;
    }

    public void setWFUserId(String wfuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserId(wfuserid);
            return;
        }
        if (wfuserid != null && (wfuserid = StringHelper.trimRight(wfuserid)).length() == 0) {
            wfuserid = null;
        }
        this.wfuserid = wfuserid;
        this.wfuseridDirtyFlag = true;
    }

    public String getWFUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserId();
        }
        return this.wfuserid;
    }

    public boolean isWFUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserIdDirty();
        }
        return this.wfuseridDirtyFlag;
    }

    public void resetWFUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserId();
            return;
        }
        this.wfuseridDirtyFlag = false;
        this.wfuserid = null;
    }

    public void setWFUserName(String wfusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserName(wfusername);
            return;
        }
        if (wfusername != null && (wfusername = StringHelper.trimRight(wfusername)).length() == 0) {
            wfusername = null;
        }
        this.wfusername = wfusername;
        this.wfusernameDirtyFlag = true;
    }

    public String getWFUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserName();
        }
        return this.wfusername;
    }

    public boolean isWFUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserNameDirty();
        }
        return this.wfusernameDirtyFlag;
    }

    public void resetWFUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserName();
            return;
        }
        this.wfusernameDirtyFlag = false;
        this.wfusername = null;
    }

    @Override
    protected void onReset() {
        WFUserGroupDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFUserGroupDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFUserGroupDetailId();
        et.resetWFUserGroupDetailName();
        et.resetWFUserGroupId();
        et.resetWFUserGroupName();
        et.resetWFUserId();
        et.resetWFUserName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFUserGroupDetailIdDirty()) {
            params.put(FIELD_WFUSERGROUPDETAILID, this.getWFUserGroupDetailId());
        }
        if (!bDirtyOnly || this.isWFUserGroupDetailNameDirty()) {
            params.put(FIELD_WFUSERGROUPDETAILNAME, this.getWFUserGroupDetailName());
        }
        if (!bDirtyOnly || this.isWFUserGroupIdDirty()) {
            params.put(FIELD_WFUSERGROUPID, this.getWFUserGroupId());
        }
        if (!bDirtyOnly || this.isWFUserGroupNameDirty()) {
            params.put(FIELD_WFUSERGROUPNAME, this.getWFUserGroupName());
        }
        if (!bDirtyOnly || this.isWFUserIdDirty()) {
            params.put(FIELD_WFUSERID, this.getWFUserId());
        }
        if (!bDirtyOnly || this.isWFUserNameDirty()) {
            params.put(FIELD_WFUSERNAME, this.getWFUserName());
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
        return WFUserGroupDetailBase.get(this, index);
    }

    private static Object get(WFUserGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getMemo();
            }
            case 3: {
                return et.getUpdateDate();
            }
            case 4: {
                return et.getUpdateMan();
            }
            case 5: {
                return et.getWFUserGroupDetailId();
            }
            case 6: {
                return et.getWFUserGroupDetailName();
            }
            case 7: {
                return et.getWFUserGroupId();
            }
            case 8: {
                return et.getWFUserGroupName();
            }
            case 9: {
                return et.getWFUserId();
            }
            case 10: {
                return et.getWFUserName();
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
        WFUserGroupDetailBase.set(this, index, objValue);
    }

    private static void set(WFUserGroupDetailBase et, int index, Object obj) throws Exception {
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
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setWFUserGroupDetailId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setWFUserGroupDetailName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFUserGroupId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFUserGroupName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFUserId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFUserName(DataObject.getStringValue(obj));
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
        return WFUserGroupDetailBase.isNull(this, index);
    }

    private static boolean isNull(WFUserGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getMemo() == null;
            }
            case 3: {
                return et.getUpdateDate() == null;
            }
            case 4: {
                return et.getUpdateMan() == null;
            }
            case 5: {
                return et.getWFUserGroupDetailId() == null;
            }
            case 6: {
                return et.getWFUserGroupDetailName() == null;
            }
            case 7: {
                return et.getWFUserGroupId() == null;
            }
            case 8: {
                return et.getWFUserGroupName() == null;
            }
            case 9: {
                return et.getWFUserId() == null;
            }
            case 10: {
                return et.getWFUserName() == null;
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
        return WFUserGroupDetailBase.contains(this, index);
    }

    private static boolean contains(WFUserGroupDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isMemoDirty();
            }
            case 3: {
                return et.isUpdateDateDirty();
            }
            case 4: {
                return et.isUpdateManDirty();
            }
            case 5: {
                return et.isWFUserGroupDetailIdDirty();
            }
            case 6: {
                return et.isWFUserGroupDetailNameDirty();
            }
            case 7: {
                return et.isWFUserGroupIdDirty();
            }
            case 8: {
                return et.isWFUserGroupNameDirty();
            }
            case 9: {
                return et.isWFUserIdDirty();
            }
            case 10: {
                return et.isWFUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFUserGroupDetailBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFUserGroupDetailBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFUserGroupDetailBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFUserGroupDetailBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFUserGroupDetailBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFUserGroupDetailBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFUserGroupDetailBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFUserGroupDetailId() != null) {
            JSONObjectHelper.put(json, "wfusergroupdetailid", WFUserGroupDetailBase.getJSONValue(et.getWFUserGroupDetailId()), false);
        }
        if (bIncEmpty || et.getWFUserGroupDetailName() != null) {
            JSONObjectHelper.put(json, "wfusergroupdetailname", WFUserGroupDetailBase.getJSONValue(et.getWFUserGroupDetailName()), false);
        }
        if (bIncEmpty || et.getWFUserGroupId() != null) {
            JSONObjectHelper.put(json, "wfusergroupid", WFUserGroupDetailBase.getJSONValue(et.getWFUserGroupId()), false);
        }
        if (bIncEmpty || et.getWFUserGroupName() != null) {
            JSONObjectHelper.put(json, "wfusergroupname", WFUserGroupDetailBase.getJSONValue(et.getWFUserGroupName()), false);
        }
        if (bIncEmpty || et.getWFUserId() != null) {
            JSONObjectHelper.put(json, "wfuserid", WFUserGroupDetailBase.getJSONValue(et.getWFUserId()), false);
        }
        if (bIncEmpty || et.getWFUserName() != null) {
            JSONObjectHelper.put(json, "wfusername", WFUserGroupDetailBase.getJSONValue(et.getWFUserName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFUserGroupDetailBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFUserGroupDetailBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserGroupDetailId() != null) {
            obj = et.getWFUserGroupDetailId();
            node.setAttribute(FIELD_WFUSERGROUPDETAILID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserGroupDetailName() != null) {
            obj = et.getWFUserGroupDetailName();
            node.setAttribute(FIELD_WFUSERGROUPDETAILNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserGroupId() != null) {
            obj = et.getWFUserGroupId();
            node.setAttribute(FIELD_WFUSERGROUPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserGroupName() != null) {
            obj = et.getWFUserGroupName();
            node.setAttribute(FIELD_WFUSERGROUPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserId() != null) {
            obj = et.getWFUserId();
            node.setAttribute(FIELD_WFUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserName() != null) {
            obj = et.getWFUserName();
            node.setAttribute(FIELD_WFUSERNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUserGroupDetailBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFUserGroupDetailBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFUserGroupDetailIdDirty() && (bIncEmpty || et.getWFUserGroupDetailId() != null)) {
            dst.set(FIELD_WFUSERGROUPDETAILID, et.getWFUserGroupDetailId());
        }
        if (et.isWFUserGroupDetailNameDirty() && (bIncEmpty || et.getWFUserGroupDetailName() != null)) {
            dst.set(FIELD_WFUSERGROUPDETAILNAME, et.getWFUserGroupDetailName());
        }
        if (et.isWFUserGroupIdDirty() && (bIncEmpty || et.getWFUserGroupId() != null)) {
            dst.set(FIELD_WFUSERGROUPID, et.getWFUserGroupId());
        }
        if (et.isWFUserGroupNameDirty() && (bIncEmpty || et.getWFUserGroupName() != null)) {
            dst.set(FIELD_WFUSERGROUPNAME, et.getWFUserGroupName());
        }
        if (et.isWFUserIdDirty() && (bIncEmpty || et.getWFUserId() != null)) {
            dst.set(FIELD_WFUSERID, et.getWFUserId());
        }
        if (et.isWFUserNameDirty() && (bIncEmpty || et.getWFUserName() != null)) {
            dst.set(FIELD_WFUSERNAME, et.getWFUserName());
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
        return WFUserGroupDetailBase.remove(this, index);
    }

    private static boolean remove(WFUserGroupDetailBase et, int index) throws Exception {
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
                et.resetMemo();
                return true;
            }
            case 3: {
                et.resetUpdateDate();
                return true;
            }
            case 4: {
                et.resetUpdateMan();
                return true;
            }
            case 5: {
                et.resetWFUserGroupDetailId();
                return true;
            }
            case 6: {
                et.resetWFUserGroupDetailName();
                return true;
            }
            case 7: {
                et.resetWFUserGroupId();
                return true;
            }
            case 8: {
                et.resetWFUserGroupName();
                return true;
            }
            case 9: {
                et.resetWFUserId();
                return true;
            }
            case 10: {
                et.resetWFUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUserGroup getWFUserGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserGroup();
        }
        if (this.getWFUserGroupId() == null) {
            return null;
        }
        Integer n = this.objWFUserGroupLock;
        synchronized (n) {
            if (this.wfusergroup != null && DataTypeHelper.compare(25, (Object)this.getWFUserGroupId(), (Object)this.wfusergroup.getWFUserGroupId()) != 0L) {
                this.wfusergroup = null;
            }
            if (this.wfusergroup == null) {
                WFUserGroup wfusergroup = new WFUserGroup();
                wfusergroup.setWFUserGroupId(this.getWFUserGroupId());
                WFUserGroupService service = (WFUserGroupService)ServiceGlobal.getService(WFUserGroupService.class, this.getSessionFactory());
                service.autoGet(wfusergroup);
                this.wfusergroup = wfusergroup;
            }
            return this.wfusergroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getWFUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUser();
        }
        if (this.getWFUserId() == null) {
            return null;
        }
        Integer n = this.objWFUserLock;
        synchronized (n) {
            if (this.wfuser != null && DataTypeHelper.compare(25, (Object)this.getWFUserId(), (Object)this.wfuser.getWFUserId()) != 0L) {
                this.wfuser = null;
            }
            if (this.wfuser == null) {
                WFUser wfuser = new WFUser();
                wfuser.setWFUserId(this.getWFUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(wfuser);
                this.wfuser = wfuser;
            }
            return this.wfuser;
        }
    }

    private WFUserGroupDetailBase getProxyEntity() {
        return this.proxyWFUserGroupDetailBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUserGroupDetailBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFUserGroupDetailBase) {
            this.proxyWFUserGroupDetailBase = (WFUserGroupDetailBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

