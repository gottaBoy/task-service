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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserRecentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevUserRecentBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_OBJID = "OBJID";
    public static final String FIELD_OBJNAME = "OBJNAME";
    public static final String FIELD_OBJTYPE = "OBJTYPE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_PSDEVUSERRECENTID = "PSDEVUSERRECENTID";
    public static final String FIELD_PSDEVUSERRECENTNAME = "PSDEVUSERRECENTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_OBJID = 2;
    private static final int INDEX_OBJNAME = 3;
    private static final int INDEX_OBJTYPE = 4;
    private static final int INDEX_PSDEVCENTERID = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSDEVUSERID = 7;
    private static final int INDEX_PSDEVUSERNAME = 8;
    private static final int INDEX_PSDEVUSERRECENTID = 9;
    private static final int INDEX_PSDEVUSERRECENTNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevUserRecentBase proxyPSDevUserRecentBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean objidDirtyFlag = false;
    private boolean objnameDirtyFlag = false;
    private boolean objtypeDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean psdevuserrecentidDirtyFlag = false;
    private boolean psdevuserrecentnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="objid")
    private String objid;
    @Column(name="objname")
    private String objname;
    @Column(name="objtype")
    private String objtype;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="psdevuserrecentid")
    private String psdevuserrecentid;
    @Column(name="psdevuserrecentname")
    private String psdevuserrecentname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevUserLock = new Integer(1);
    private PSDevUser psdevuser = null;

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

    public void setObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objid = string;
        this.objidDirtyFlag = true;
    }

    public String getObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjId();
        }
        return this.objid;
    }

    public boolean isObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjIdDirty();
        }
        return this.objidDirtyFlag;
    }

    public void resetObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjId();
            return;
        }
        this.objidDirtyFlag = false;
        this.objid = null;
    }

    public void setObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objname = string;
        this.objnameDirtyFlag = true;
    }

    public String getObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjName();
        }
        return this.objname;
    }

    public boolean isObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjNameDirty();
        }
        return this.objnameDirtyFlag;
    }

    public void resetObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjName();
            return;
        }
        this.objnameDirtyFlag = false;
        this.objname = null;
    }

    public void setObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objtype = string;
        this.objtypeDirtyFlag = true;
    }

    public String getObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjType();
        }
        return this.objtype;
    }

    public boolean isObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjTypeDirty();
        }
        return this.objtypeDirtyFlag;
    }

    public void resetObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjType();
            return;
        }
        this.objtypeDirtyFlag = false;
        this.objtype = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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

    public void setPSDevUserRecentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserRecentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserrecentid = string;
        this.psdevuserrecentidDirtyFlag = true;
    }

    public String getPSDevUserRecentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserRecentId();
        }
        return this.psdevuserrecentid;
    }

    public boolean isPSDevUserRecentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserRecentIdDirty();
        }
        return this.psdevuserrecentidDirtyFlag;
    }

    public void resetPSDevUserRecentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserRecentId();
            return;
        }
        this.psdevuserrecentidDirtyFlag = false;
        this.psdevuserrecentid = null;
    }

    public void setPSDevUserRecentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserRecentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserrecentname = string;
        this.psdevuserrecentnameDirtyFlag = true;
    }

    public String getPSDevUserRecentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserRecentName();
        }
        return this.psdevuserrecentname;
    }

    public boolean isPSDevUserRecentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserRecentNameDirty();
        }
        return this.psdevuserrecentnameDirtyFlag;
    }

    public void resetPSDevUserRecentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserRecentName();
            return;
        }
        this.psdevuserrecentnameDirtyFlag = false;
        this.psdevuserrecentname = null;
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

    protected void onReset() {
        PSDevUserRecentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevUserRecentBase pSDevUserRecentBase) {
        pSDevUserRecentBase.resetCreateDate();
        pSDevUserRecentBase.resetCreateMan();
        pSDevUserRecentBase.resetObjId();
        pSDevUserRecentBase.resetObjName();
        pSDevUserRecentBase.resetObjType();
        pSDevUserRecentBase.resetPSDevCenterId();
        pSDevUserRecentBase.resetPSDevCenterName();
        pSDevUserRecentBase.resetPSDevUserId();
        pSDevUserRecentBase.resetPSDevUserName();
        pSDevUserRecentBase.resetPSDevUserRecentId();
        pSDevUserRecentBase.resetPSDevUserRecentName();
        pSDevUserRecentBase.resetUpdateDate();
        pSDevUserRecentBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isObjIdDirty()) {
            hashMap.put(FIELD_OBJID, this.getObjId());
        }
        if (!bl || this.isObjNameDirty()) {
            hashMap.put(FIELD_OBJNAME, this.getObjName());
        }
        if (!bl || this.isObjTypeDirty()) {
            hashMap.put(FIELD_OBJTYPE, this.getObjType());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isPSDevUserRecentIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERRECENTID, this.getPSDevUserRecentId());
        }
        if (!bl || this.isPSDevUserRecentNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERRECENTNAME, this.getPSDevUserRecentName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDevUserRecentBase.get(this, n);
    }

    private static Object get(PSDevUserRecentBase pSDevUserRecentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserRecentBase.getCreateDate();
            }
            case 1: {
                return pSDevUserRecentBase.getCreateMan();
            }
            case 2: {
                return pSDevUserRecentBase.getObjId();
            }
            case 3: {
                return pSDevUserRecentBase.getObjName();
            }
            case 4: {
                return pSDevUserRecentBase.getObjType();
            }
            case 5: {
                return pSDevUserRecentBase.getPSDevCenterId();
            }
            case 6: {
                return pSDevUserRecentBase.getPSDevCenterName();
            }
            case 7: {
                return pSDevUserRecentBase.getPSDevUserId();
            }
            case 8: {
                return pSDevUserRecentBase.getPSDevUserName();
            }
            case 9: {
                return pSDevUserRecentBase.getPSDevUserRecentId();
            }
            case 10: {
                return pSDevUserRecentBase.getPSDevUserRecentName();
            }
            case 11: {
                return pSDevUserRecentBase.getUpdateDate();
            }
            case 12: {
                return pSDevUserRecentBase.getUpdateMan();
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
        PSDevUserRecentBase.set(this, n, object);
    }

    private static void set(PSDevUserRecentBase pSDevUserRecentBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserRecentBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevUserRecentBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevUserRecentBase.setObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevUserRecentBase.setObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevUserRecentBase.setObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevUserRecentBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevUserRecentBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevUserRecentBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevUserRecentBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevUserRecentBase.setPSDevUserRecentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevUserRecentBase.setPSDevUserRecentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevUserRecentBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDevUserRecentBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevUserRecentBase.isNull(this, n);
    }

    private static boolean isNull(PSDevUserRecentBase pSDevUserRecentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserRecentBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevUserRecentBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevUserRecentBase.getObjId() == null;
            }
            case 3: {
                return pSDevUserRecentBase.getObjName() == null;
            }
            case 4: {
                return pSDevUserRecentBase.getObjType() == null;
            }
            case 5: {
                return pSDevUserRecentBase.getPSDevCenterId() == null;
            }
            case 6: {
                return pSDevUserRecentBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSDevUserRecentBase.getPSDevUserId() == null;
            }
            case 8: {
                return pSDevUserRecentBase.getPSDevUserName() == null;
            }
            case 9: {
                return pSDevUserRecentBase.getPSDevUserRecentId() == null;
            }
            case 10: {
                return pSDevUserRecentBase.getPSDevUserRecentName() == null;
            }
            case 11: {
                return pSDevUserRecentBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDevUserRecentBase.getUpdateMan() == null;
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
        return PSDevUserRecentBase.contains(this, n);
    }

    private static boolean contains(PSDevUserRecentBase pSDevUserRecentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserRecentBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevUserRecentBase.isCreateManDirty();
            }
            case 2: {
                return pSDevUserRecentBase.isObjIdDirty();
            }
            case 3: {
                return pSDevUserRecentBase.isObjNameDirty();
            }
            case 4: {
                return pSDevUserRecentBase.isObjTypeDirty();
            }
            case 5: {
                return pSDevUserRecentBase.isPSDevCenterIdDirty();
            }
            case 6: {
                return pSDevUserRecentBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSDevUserRecentBase.isPSDevUserIdDirty();
            }
            case 8: {
                return pSDevUserRecentBase.isPSDevUserNameDirty();
            }
            case 9: {
                return pSDevUserRecentBase.isPSDevUserRecentIdDirty();
            }
            case 10: {
                return pSDevUserRecentBase.isPSDevUserRecentNameDirty();
            }
            case 11: {
                return pSDevUserRecentBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDevUserRecentBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevUserRecentBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevUserRecentBase pSDevUserRecentBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevUserRecentBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objid", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getObjId()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objname", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getObjName()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objtype", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getObjType()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getPSDevUserRecentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserrecentid", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getPSDevUserRecentId()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getPSDevUserRecentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserrecentname", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getPSDevUserRecentName()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevUserRecentBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevUserRecentBase.getJSONValue((Object)pSDevUserRecentBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevUserRecentBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevUserRecentBase pSDevUserRecentBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevUserRecentBase.getCreateDate() != null) {
            object = pSDevUserRecentBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserRecentBase.getCreateMan() != null) {
            object = pSDevUserRecentBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getObjId() != null) {
            object = pSDevUserRecentBase.getObjId();
            xmlNode.setAttribute(FIELD_OBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getObjName() != null) {
            object = pSDevUserRecentBase.getObjName();
            xmlNode.setAttribute(FIELD_OBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getObjType() != null) {
            object = pSDevUserRecentBase.getObjType();
            xmlNode.setAttribute(FIELD_OBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getPSDevCenterId() != null) {
            object = pSDevUserRecentBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getPSDevCenterName() != null) {
            object = pSDevUserRecentBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getPSDevUserId() != null) {
            object = pSDevUserRecentBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getPSDevUserName() != null) {
            object = pSDevUserRecentBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getPSDevUserRecentId() != null) {
            object = pSDevUserRecentBase.getPSDevUserRecentId();
            xmlNode.setAttribute(FIELD_PSDEVUSERRECENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getPSDevUserRecentName() != null) {
            object = pSDevUserRecentBase.getPSDevUserRecentName();
            xmlNode.setAttribute(FIELD_PSDEVUSERRECENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentBase.getUpdateDate() != null) {
            object = pSDevUserRecentBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserRecentBase.getUpdateMan() != null) {
            object = pSDevUserRecentBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevUserRecentBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevUserRecentBase pSDevUserRecentBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevUserRecentBase.isCreateDateDirty() && (bl || pSDevUserRecentBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevUserRecentBase.getCreateDate());
        }
        if (pSDevUserRecentBase.isCreateManDirty() && (bl || pSDevUserRecentBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevUserRecentBase.getCreateMan());
        }
        if (pSDevUserRecentBase.isObjIdDirty() && (bl || pSDevUserRecentBase.getObjId() != null)) {
            iDataObject.set(FIELD_OBJID, (Object)pSDevUserRecentBase.getObjId());
        }
        if (pSDevUserRecentBase.isObjNameDirty() && (bl || pSDevUserRecentBase.getObjName() != null)) {
            iDataObject.set(FIELD_OBJNAME, (Object)pSDevUserRecentBase.getObjName());
        }
        if (pSDevUserRecentBase.isObjTypeDirty() && (bl || pSDevUserRecentBase.getObjType() != null)) {
            iDataObject.set(FIELD_OBJTYPE, (Object)pSDevUserRecentBase.getObjType());
        }
        if (pSDevUserRecentBase.isPSDevCenterIdDirty() && (bl || pSDevUserRecentBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevUserRecentBase.getPSDevCenterId());
        }
        if (pSDevUserRecentBase.isPSDevCenterNameDirty() && (bl || pSDevUserRecentBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevUserRecentBase.getPSDevCenterName());
        }
        if (pSDevUserRecentBase.isPSDevUserIdDirty() && (bl || pSDevUserRecentBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDevUserRecentBase.getPSDevUserId());
        }
        if (pSDevUserRecentBase.isPSDevUserNameDirty() && (bl || pSDevUserRecentBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSDevUserRecentBase.getPSDevUserName());
        }
        if (pSDevUserRecentBase.isPSDevUserRecentIdDirty() && (bl || pSDevUserRecentBase.getPSDevUserRecentId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERRECENTID, (Object)pSDevUserRecentBase.getPSDevUserRecentId());
        }
        if (pSDevUserRecentBase.isPSDevUserRecentNameDirty() && (bl || pSDevUserRecentBase.getPSDevUserRecentName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERRECENTNAME, (Object)pSDevUserRecentBase.getPSDevUserRecentName());
        }
        if (pSDevUserRecentBase.isUpdateDateDirty() && (bl || pSDevUserRecentBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevUserRecentBase.getUpdateDate());
        }
        if (pSDevUserRecentBase.isUpdateManDirty() && (bl || pSDevUserRecentBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevUserRecentBase.getUpdateMan());
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
        return PSDevUserRecentBase.remove(this, n);
    }

    private static boolean remove(PSDevUserRecentBase pSDevUserRecentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserRecentBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevUserRecentBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevUserRecentBase.resetObjId();
                return true;
            }
            case 3: {
                pSDevUserRecentBase.resetObjName();
                return true;
            }
            case 4: {
                pSDevUserRecentBase.resetObjType();
                return true;
            }
            case 5: {
                pSDevUserRecentBase.resetPSDevCenterId();
                return true;
            }
            case 6: {
                pSDevUserRecentBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSDevUserRecentBase.resetPSDevUserId();
                return true;
            }
            case 8: {
                pSDevUserRecentBase.resetPSDevUserName();
                return true;
            }
            case 9: {
                pSDevUserRecentBase.resetPSDevUserRecentId();
                return true;
            }
            case 10: {
                pSDevUserRecentBase.resetPSDevUserRecentName();
                return true;
            }
            case 11: {
                pSDevUserRecentBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDevUserRecentBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
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
                pSDevUserService.autoGet((IEntity)pSDevUser);
                this.psdevuser = pSDevUser;
            }
            return this.psdevuser;
        }
    }

    private PSDevUserRecentBase getProxyEntity() {
        return this.proxyPSDevUserRecentBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevUserRecentBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevUserRecentBase) {
            this.proxyPSDevUserRecentBase = (PSDevUserRecentBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserRecentService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_OBJID, 2);
        fieldIndexMap.put(FIELD_OBJNAME, 3);
        fieldIndexMap.put(FIELD_OBJTYPE, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 7);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVUSERRECENTID, 9);
        fieldIndexMap.put(FIELD_PSDEVUSERRECENTNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

