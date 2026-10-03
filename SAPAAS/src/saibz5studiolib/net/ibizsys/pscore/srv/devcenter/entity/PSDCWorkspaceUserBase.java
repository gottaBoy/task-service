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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCWorkspaceUserBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCWorkspaceUserBase.class);
    public static final String FIELD_ACCESSTIME = "ACCESSTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String FIELD_PSDCWORKSPACEUSERID = "PSDCWORKSPACEUSERID";
    public static final String FIELD_PSDCWORKSPACEUSERNAME = "PSDCWORKSPACEUSERNAME";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_ACCESSTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDCWORKSPACEID = 4;
    private static final int INDEX_PSDCWORKSPACENAME = 5;
    private static final int INDEX_PSDCWORKSPACEUSERID = 6;
    private static final int INDEX_PSDCWORKSPACEUSERNAME = 7;
    private static final int INDEX_PSDEVUSERID = 8;
    private static final int INDEX_PSDEVUSERNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCWorkspaceUserBase proxyPSDCWorkspaceUserBase = null;
    private boolean accesstimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psdcworkspacenameDirtyFlag = false;
    private boolean psdcworkspaceuseridDirtyFlag = false;
    private boolean psdcworkspaceusernameDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="accesstime")
    private Timestamp accesstime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psdcworkspacename")
    private String psdcworkspacename;
    @Column(name="psdcworkspaceuserid")
    private String psdcworkspaceuserid;
    @Column(name="psdcworkspaceusername")
    private String psdcworkspaceusername;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSDCWorkspaceLock = new Integer(1);
    private PSDCWorkspace psdcworkspace = null;
    private Integer objPSDevUserLock = new Integer(1);
    private PSDevUser psdevuser = null;

    public void setAccessTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccessTime(timestamp);
            return;
        }
        this.accesstime = timestamp;
        this.accesstimeDirtyFlag = true;
    }

    public Timestamp getAccessTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccessTime();
        }
        return this.accesstime;
    }

    public boolean isAccessTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccessTimeDirty();
        }
        return this.accesstimeDirtyFlag;
    }

    public void resetAccessTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccessTime();
            return;
        }
        this.accesstimeDirtyFlag = false;
        this.accesstime = null;
    }

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

    public void setPSDCWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceid = string;
        this.psdcworkspaceidDirtyFlag = true;
    }

    public String getPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceId();
        }
        return this.psdcworkspaceid;
    }

    public boolean isPSDCWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceIdDirty();
        }
        return this.psdcworkspaceidDirtyFlag;
    }

    public void resetPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceId();
            return;
        }
        this.psdcworkspaceidDirtyFlag = false;
        this.psdcworkspaceid = null;
    }

    public void setPSDCWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspacename = string;
        this.psdcworkspacenameDirtyFlag = true;
    }

    public String getPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceName();
        }
        return this.psdcworkspacename;
    }

    public boolean isPSDCWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceNameDirty();
        }
        return this.psdcworkspacenameDirtyFlag;
    }

    public void resetPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceName();
            return;
        }
        this.psdcworkspacenameDirtyFlag = false;
        this.psdcworkspacename = null;
    }

    public void setPSDCWorkspaceUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceuserid = string;
        this.psdcworkspaceuseridDirtyFlag = true;
    }

    public String getPSDCWorkspaceUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceUserId();
        }
        return this.psdcworkspaceuserid;
    }

    public boolean isPSDCWorkspaceUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceUserIdDirty();
        }
        return this.psdcworkspaceuseridDirtyFlag;
    }

    public void resetPSDCWorkspaceUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceUserId();
            return;
        }
        this.psdcworkspaceuseridDirtyFlag = false;
        this.psdcworkspaceuserid = null;
    }

    public void setPSDCWorkspaceUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceusername = string;
        this.psdcworkspaceusernameDirtyFlag = true;
    }

    public String getPSDCWorkspaceUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceUserName();
        }
        return this.psdcworkspaceusername;
    }

    public boolean isPSDCWorkspaceUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceUserNameDirty();
        }
        return this.psdcworkspaceusernameDirtyFlag;
    }

    public void resetPSDCWorkspaceUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceUserName();
            return;
        }
        this.psdcworkspaceusernameDirtyFlag = false;
        this.psdcworkspaceusername = null;
    }

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusername = string;
        this.psdevusernameDirtyFlag = true;
    }

    public String getPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserName();
        }
        return this.psdevusername;
    }

    public boolean isPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserNameDirty();
        }
        return this.psdevusernameDirtyFlag;
    }

    public void resetPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserName();
            return;
        }
        this.psdevusernameDirtyFlag = false;
        this.psdevusername = null;
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

    protected void onReset() {
        PSDCWorkspaceUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCWorkspaceUserBase pSDCWorkspaceUserBase) {
        pSDCWorkspaceUserBase.resetAccessTime();
        pSDCWorkspaceUserBase.resetCreateDate();
        pSDCWorkspaceUserBase.resetCreateMan();
        pSDCWorkspaceUserBase.resetMemo();
        pSDCWorkspaceUserBase.resetPSDCWorkspaceId();
        pSDCWorkspaceUserBase.resetPSDCWorkspaceName();
        pSDCWorkspaceUserBase.resetPSDCWorkspaceUserId();
        pSDCWorkspaceUserBase.resetPSDCWorkspaceUserName();
        pSDCWorkspaceUserBase.resetPSDevUserId();
        pSDCWorkspaceUserBase.resetPSDevUserName();
        pSDCWorkspaceUserBase.resetUpdateDate();
        pSDCWorkspaceUserBase.resetUpdateMan();
        pSDCWorkspaceUserBase.resetUserTag();
        pSDCWorkspaceUserBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccessTimeDirty()) {
            hashMap.put(FIELD_ACCESSTIME, this.getAccessTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSDCWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACENAME, this.getPSDCWorkspaceName());
        }
        if (!bl || this.isPSDCWorkspaceUserIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEUSERID, this.getPSDCWorkspaceUserId());
        }
        if (!bl || this.isPSDCWorkspaceUserNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEUSERNAME, this.getPSDCWorkspaceUserName());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDCWorkspaceUserBase.get(this, n);
    }

    private static Object get(PSDCWorkspaceUserBase pSDCWorkspaceUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceUserBase.getAccessTime();
            }
            case 1: {
                return pSDCWorkspaceUserBase.getCreateDate();
            }
            case 2: {
                return pSDCWorkspaceUserBase.getCreateMan();
            }
            case 3: {
                return pSDCWorkspaceUserBase.getMemo();
            }
            case 4: {
                return pSDCWorkspaceUserBase.getPSDCWorkspaceId();
            }
            case 5: {
                return pSDCWorkspaceUserBase.getPSDCWorkspaceName();
            }
            case 6: {
                return pSDCWorkspaceUserBase.getPSDCWorkspaceUserId();
            }
            case 7: {
                return pSDCWorkspaceUserBase.getPSDCWorkspaceUserName();
            }
            case 8: {
                return pSDCWorkspaceUserBase.getPSDevUserId();
            }
            case 9: {
                return pSDCWorkspaceUserBase.getPSDevUserName();
            }
            case 10: {
                return pSDCWorkspaceUserBase.getUpdateDate();
            }
            case 11: {
                return pSDCWorkspaceUserBase.getUpdateMan();
            }
            case 12: {
                return pSDCWorkspaceUserBase.getUserTag();
            }
            case 13: {
                return pSDCWorkspaceUserBase.getUserTag2();
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
        PSDCWorkspaceUserBase.set(this, n, object);
    }

    private static void set(PSDCWorkspaceUserBase pSDCWorkspaceUserBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkspaceUserBase.setAccessTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCWorkspaceUserBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCWorkspaceUserBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCWorkspaceUserBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCWorkspaceUserBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCWorkspaceUserBase.setPSDCWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCWorkspaceUserBase.setPSDCWorkspaceUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCWorkspaceUserBase.setPSDCWorkspaceUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCWorkspaceUserBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCWorkspaceUserBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCWorkspaceUserBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDCWorkspaceUserBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCWorkspaceUserBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCWorkspaceUserBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDCWorkspaceUserBase.isNull(this, n);
    }

    private static boolean isNull(PSDCWorkspaceUserBase pSDCWorkspaceUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceUserBase.getAccessTime() == null;
            }
            case 1: {
                return pSDCWorkspaceUserBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCWorkspaceUserBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCWorkspaceUserBase.getMemo() == null;
            }
            case 4: {
                return pSDCWorkspaceUserBase.getPSDCWorkspaceId() == null;
            }
            case 5: {
                return pSDCWorkspaceUserBase.getPSDCWorkspaceName() == null;
            }
            case 6: {
                return pSDCWorkspaceUserBase.getPSDCWorkspaceUserId() == null;
            }
            case 7: {
                return pSDCWorkspaceUserBase.getPSDCWorkspaceUserName() == null;
            }
            case 8: {
                return pSDCWorkspaceUserBase.getPSDevUserId() == null;
            }
            case 9: {
                return pSDCWorkspaceUserBase.getPSDevUserName() == null;
            }
            case 10: {
                return pSDCWorkspaceUserBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDCWorkspaceUserBase.getUpdateMan() == null;
            }
            case 12: {
                return pSDCWorkspaceUserBase.getUserTag() == null;
            }
            case 13: {
                return pSDCWorkspaceUserBase.getUserTag2() == null;
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
        return PSDCWorkspaceUserBase.contains(this, n);
    }

    private static boolean contains(PSDCWorkspaceUserBase pSDCWorkspaceUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceUserBase.isAccessTimeDirty();
            }
            case 1: {
                return pSDCWorkspaceUserBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCWorkspaceUserBase.isCreateManDirty();
            }
            case 3: {
                return pSDCWorkspaceUserBase.isMemoDirty();
            }
            case 4: {
                return pSDCWorkspaceUserBase.isPSDCWorkspaceIdDirty();
            }
            case 5: {
                return pSDCWorkspaceUserBase.isPSDCWorkspaceNameDirty();
            }
            case 6: {
                return pSDCWorkspaceUserBase.isPSDCWorkspaceUserIdDirty();
            }
            case 7: {
                return pSDCWorkspaceUserBase.isPSDCWorkspaceUserNameDirty();
            }
            case 8: {
                return pSDCWorkspaceUserBase.isPSDevUserIdDirty();
            }
            case 9: {
                return pSDCWorkspaceUserBase.isPSDevUserNameDirty();
            }
            case 10: {
                return pSDCWorkspaceUserBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDCWorkspaceUserBase.isUpdateManDirty();
            }
            case 12: {
                return pSDCWorkspaceUserBase.isUserTagDirty();
            }
            case 13: {
                return pSDCWorkspaceUserBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCWorkspaceUserBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCWorkspaceUserBase pSDCWorkspaceUserBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCWorkspaceUserBase.getAccessTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accesstime", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getAccessTime()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacename", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getPSDCWorkspaceName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceuserid", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getPSDCWorkspaceUserId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceusername", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getPSDCWorkspaceUserName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCWorkspaceUserBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCWorkspaceUserBase.getJSONValue((Object)pSDCWorkspaceUserBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCWorkspaceUserBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCWorkspaceUserBase pSDCWorkspaceUserBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCWorkspaceUserBase.getAccessTime() != null) {
            object = pSDCWorkspaceUserBase.getAccessTime();
            xmlNode.setAttribute(FIELD_ACCESSTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceUserBase.getCreateDate() != null) {
            object = pSDCWorkspaceUserBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceUserBase.getCreateMan() != null) {
            object = pSDCWorkspaceUserBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getMemo() != null) {
            object = pSDCWorkspaceUserBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceId() != null) {
            object = pSDCWorkspaceUserBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceName() != null) {
            object = pSDCWorkspaceUserBase.getPSDCWorkspaceName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceUserId() != null) {
            object = pSDCWorkspaceUserBase.getPSDCWorkspaceUserId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceUserName() != null) {
            object = pSDCWorkspaceUserBase.getPSDCWorkspaceUserName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDevUserId() != null) {
            object = pSDCWorkspaceUserBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getPSDevUserName() != null) {
            object = pSDCWorkspaceUserBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getUpdateDate() != null) {
            object = pSDCWorkspaceUserBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceUserBase.getUpdateMan() != null) {
            object = pSDCWorkspaceUserBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getUserTag() != null) {
            object = pSDCWorkspaceUserBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceUserBase.getUserTag2() != null) {
            object = pSDCWorkspaceUserBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCWorkspaceUserBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCWorkspaceUserBase pSDCWorkspaceUserBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCWorkspaceUserBase.isAccessTimeDirty() && (bl || pSDCWorkspaceUserBase.getAccessTime() != null)) {
            iDataObject.set(FIELD_ACCESSTIME, (Object)pSDCWorkspaceUserBase.getAccessTime());
        }
        if (pSDCWorkspaceUserBase.isCreateDateDirty() && (bl || pSDCWorkspaceUserBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCWorkspaceUserBase.getCreateDate());
        }
        if (pSDCWorkspaceUserBase.isCreateManDirty() && (bl || pSDCWorkspaceUserBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCWorkspaceUserBase.getCreateMan());
        }
        if (pSDCWorkspaceUserBase.isMemoDirty() && (bl || pSDCWorkspaceUserBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCWorkspaceUserBase.getMemo());
        }
        if (pSDCWorkspaceUserBase.isPSDCWorkspaceIdDirty() && (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSDCWorkspaceUserBase.getPSDCWorkspaceId());
        }
        if (pSDCWorkspaceUserBase.isPSDCWorkspaceNameDirty() && (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACENAME, (Object)pSDCWorkspaceUserBase.getPSDCWorkspaceName());
        }
        if (pSDCWorkspaceUserBase.isPSDCWorkspaceUserIdDirty() && (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceUserId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEUSERID, (Object)pSDCWorkspaceUserBase.getPSDCWorkspaceUserId());
        }
        if (pSDCWorkspaceUserBase.isPSDCWorkspaceUserNameDirty() && (bl || pSDCWorkspaceUserBase.getPSDCWorkspaceUserName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEUSERNAME, (Object)pSDCWorkspaceUserBase.getPSDCWorkspaceUserName());
        }
        if (pSDCWorkspaceUserBase.isPSDevUserIdDirty() && (bl || pSDCWorkspaceUserBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDCWorkspaceUserBase.getPSDevUserId());
        }
        if (pSDCWorkspaceUserBase.isPSDevUserNameDirty() && (bl || pSDCWorkspaceUserBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSDCWorkspaceUserBase.getPSDevUserName());
        }
        if (pSDCWorkspaceUserBase.isUpdateDateDirty() && (bl || pSDCWorkspaceUserBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCWorkspaceUserBase.getUpdateDate());
        }
        if (pSDCWorkspaceUserBase.isUpdateManDirty() && (bl || pSDCWorkspaceUserBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCWorkspaceUserBase.getUpdateMan());
        }
        if (pSDCWorkspaceUserBase.isUserTagDirty() && (bl || pSDCWorkspaceUserBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCWorkspaceUserBase.getUserTag());
        }
        if (pSDCWorkspaceUserBase.isUserTag2Dirty() && (bl || pSDCWorkspaceUserBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCWorkspaceUserBase.getUserTag2());
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
        return PSDCWorkspaceUserBase.remove(this, n);
    }

    private static boolean remove(PSDCWorkspaceUserBase pSDCWorkspaceUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkspaceUserBase.resetAccessTime();
                return true;
            }
            case 1: {
                pSDCWorkspaceUserBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCWorkspaceUserBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCWorkspaceUserBase.resetMemo();
                return true;
            }
            case 4: {
                pSDCWorkspaceUserBase.resetPSDCWorkspaceId();
                return true;
            }
            case 5: {
                pSDCWorkspaceUserBase.resetPSDCWorkspaceName();
                return true;
            }
            case 6: {
                pSDCWorkspaceUserBase.resetPSDCWorkspaceUserId();
                return true;
            }
            case 7: {
                pSDCWorkspaceUserBase.resetPSDCWorkspaceUserName();
                return true;
            }
            case 8: {
                pSDCWorkspaceUserBase.resetPSDevUserId();
                return true;
            }
            case 9: {
                pSDCWorkspaceUserBase.resetPSDevUserName();
                return true;
            }
            case 10: {
                pSDCWorkspaceUserBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDCWorkspaceUserBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSDCWorkspaceUserBase.resetUserTag();
                return true;
            }
            case 13: {
                pSDCWorkspaceUserBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCWorkspace getPSDCWorkspace() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspace();
        }
        if (this.getPSDCWorkspaceId() == null) {
            return null;
        }
        Integer n = this.objPSDCWorkspaceLock;
        synchronized (n) {
            if (this.psdcworkspace != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCWorkspaceId(), (Object)this.psdcworkspace.getPSDCWorkspaceId()) != 0L) {
                this.psdcworkspace = null;
            }
            if (this.psdcworkspace == null) {
                PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
                pSDCWorkspace.setPSDCWorkspaceId(this.getPSDCWorkspaceId());
                PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                pSDCWorkspaceService.autoGet(pSDCWorkspace);
                this.psdcworkspace = pSDCWorkspace;
            }
            return this.psdcworkspace;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUser getPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUser();
        }
        if (this.getPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserLock;
        synchronized (n) {
            if (this.psdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserId(), (Object)this.psdevuser.getPSDevUserId()) != 0L) {
                this.psdevuser = null;
            }
            if (this.psdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet(pSDevUser);
                this.psdevuser = pSDevUser;
            }
            return this.psdevuser;
        }
    }

    private PSDCWorkspaceUserBase getProxyEntity() {
        return this.proxyPSDCWorkspaceUserBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCWorkspaceUserBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCWorkspaceUserBase) {
            this.proxyPSDCWorkspaceUserBase = (PSDCWorkspaceUserBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceUserService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCESSTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 4);
        fieldIndexMap.put(FIELD_PSDCWORKSPACENAME, 5);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEUSERID, 6);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEUSERNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 8);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERTAG, 12);
        fieldIndexMap.put(FIELD_USERTAG2, 13);
    }
}

