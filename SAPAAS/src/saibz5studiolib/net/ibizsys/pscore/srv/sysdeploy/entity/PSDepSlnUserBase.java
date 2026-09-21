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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObj;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnUserBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnUserBase.class);
    public static final String FIELD_ACCMODE = "ACCMODE";
    public static final String FIELD_ALLSYSFLAG = "ALLSYSFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_PSDEPSLNUSERID = "PSDEPSLNUSERID";
    public static final String FIELD_PSDEPSLNUSERNAME = "PSDEPSLNUSERNAME";
    public static final String FIELD_PSDEVUSEROBJID = "PSDEVUSEROBJID";
    public static final String FIELD_PSDEVUSEROBJNAME = "PSDEVUSEROBJNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACCMODE = 0;
    private static final int INDEX_ALLSYSFLAG = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEPSLNID = 5;
    private static final int INDEX_PSDEPSLNNAME = 6;
    private static final int INDEX_PSDEPSLNSYSID = 7;
    private static final int INDEX_PSDEPSLNSYSNAME = 8;
    private static final int INDEX_PSDEPSLNUSERID = 9;
    private static final int INDEX_PSDEPSLNUSERNAME = 10;
    private static final int INDEX_PSDEVUSEROBJID = 11;
    private static final int INDEX_PSDEVUSEROBJNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnUserBase proxyPSDepSlnUserBase = null;
    private boolean accmodeDirtyFlag = false;
    private boolean allsysflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean psdepslnuseridDirtyFlag = false;
    private boolean psdepslnusernameDirtyFlag = false;
    private boolean psdevuserobjidDirtyFlag = false;
    private boolean psdevuserobjnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="accmode")
    private Integer accmode;
    @Column(name="allsysflag")
    private Integer allsysflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="psdepslnuserid")
    private String psdepslnuserid;
    @Column(name="psdepslnusername")
    private String psdepslnusername;
    @Column(name="psdevuserobjid")
    private String psdevuserobjid;
    @Column(name="psdevuserobjname")
    private String psdevuserobjname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;
    private Integer objPSDevUserObjLock = new Integer(1);
    private PSDevUserObj psdevuserobj = null;

    public void setAccMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccMode(n);
            return;
        }
        this.accmode = n;
        this.accmodeDirtyFlag = true;
    }

    public Integer getAccMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccMode();
        }
        return this.accmode;
    }

    public boolean isAccModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccModeDirty();
        }
        return this.accmodeDirtyFlag;
    }

    public void resetAccMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccMode();
            return;
        }
        this.accmodeDirtyFlag = false;
        this.accmode = null;
    }

    public void setAllSysFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllSysFlag(n);
            return;
        }
        this.allsysflag = n;
        this.allsysflagDirtyFlag = true;
    }

    public Integer getAllSysFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllSysFlag();
        }
        return this.allsysflag;
    }

    public boolean isAllSysFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllSysFlagDirty();
        }
        return this.allsysflagDirtyFlag;
    }

    public void resetAllSysFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllSysFlag();
            return;
        }
        this.allsysflagDirtyFlag = false;
        this.allsysflag = null;
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

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
    }

    public void setPSDepSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysid = string;
        this.psdepslnsysidDirtyFlag = true;
    }

    public String getPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysId();
        }
        return this.psdepslnsysid;
    }

    public boolean isPSDepSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysIdDirty();
        }
        return this.psdepslnsysidDirtyFlag;
    }

    public void resetPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysId();
            return;
        }
        this.psdepslnsysidDirtyFlag = false;
        this.psdepslnsysid = null;
    }

    public void setPSDepSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysname = string;
        this.psdepslnsysnameDirtyFlag = true;
    }

    public String getPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysName();
        }
        return this.psdepslnsysname;
    }

    public boolean isPSDepSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysNameDirty();
        }
        return this.psdepslnsysnameDirtyFlag;
    }

    public void resetPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysName();
            return;
        }
        this.psdepslnsysnameDirtyFlag = false;
        this.psdepslnsysname = null;
    }

    public void setPSDepSlnUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnuserid = string;
        this.psdepslnuseridDirtyFlag = true;
    }

    public String getPSDepSlnUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnUserId();
        }
        return this.psdepslnuserid;
    }

    public boolean isPSDepSlnUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnUserIdDirty();
        }
        return this.psdepslnuseridDirtyFlag;
    }

    public void resetPSDepSlnUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnUserId();
            return;
        }
        this.psdepslnuseridDirtyFlag = false;
        this.psdepslnuserid = null;
    }

    public void setPSDepSlnUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnusername = string;
        this.psdepslnusernameDirtyFlag = true;
    }

    public String getPSDepSlnUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnUserName();
        }
        return this.psdepslnusername;
    }

    public boolean isPSDepSlnUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnUserNameDirty();
        }
        return this.psdepslnusernameDirtyFlag;
    }

    public void resetPSDepSlnUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnUserName();
            return;
        }
        this.psdepslnusernameDirtyFlag = false;
        this.psdepslnusername = null;
    }

    public void setPSDevUserObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserobjid = string;
        this.psdevuserobjidDirtyFlag = true;
    }

    public String getPSDevUserObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObjId();
        }
        return this.psdevuserobjid;
    }

    public boolean isPSDevUserObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserObjIdDirty();
        }
        return this.psdevuserobjidDirtyFlag;
    }

    public void resetPSDevUserObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserObjId();
            return;
        }
        this.psdevuserobjidDirtyFlag = false;
        this.psdevuserobjid = null;
    }

    public void setPSDevUserObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserobjname = string;
        this.psdevuserobjnameDirtyFlag = true;
    }

    public String getPSDevUserObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObjName();
        }
        return this.psdevuserobjname;
    }

    public boolean isPSDevUserObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserObjNameDirty();
        }
        return this.psdevuserobjnameDirtyFlag;
    }

    public void resetPSDevUserObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserObjName();
            return;
        }
        this.psdevuserobjnameDirtyFlag = false;
        this.psdevuserobjname = null;
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
        PSDepSlnUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnUserBase pSDepSlnUserBase) {
        pSDepSlnUserBase.resetAccMode();
        pSDepSlnUserBase.resetAllSysFlag();
        pSDepSlnUserBase.resetCreateDate();
        pSDepSlnUserBase.resetCreateMan();
        pSDepSlnUserBase.resetMemo();
        pSDepSlnUserBase.resetPSDepSlnId();
        pSDepSlnUserBase.resetPSDepSlnName();
        pSDepSlnUserBase.resetPSDepSlnSysId();
        pSDepSlnUserBase.resetPSDepSlnSysName();
        pSDepSlnUserBase.resetPSDepSlnUserId();
        pSDepSlnUserBase.resetPSDepSlnUserName();
        pSDepSlnUserBase.resetPSDevUserObjId();
        pSDepSlnUserBase.resetPSDevUserObjName();
        pSDepSlnUserBase.resetUpdateDate();
        pSDepSlnUserBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccModeDirty()) {
            hashMap.put(FIELD_ACCMODE, this.getAccMode());
        }
        if (!bl || this.isAllSysFlagDirty()) {
            hashMap.put(FIELD_ALLSYSFLAG, this.getAllSysFlag());
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
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
        }
        if (!bl || this.isPSDepSlnUserIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNUSERID, this.getPSDepSlnUserId());
        }
        if (!bl || this.isPSDepSlnUserNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNUSERNAME, this.getPSDepSlnUserName());
        }
        if (!bl || this.isPSDevUserObjIdDirty()) {
            hashMap.put(FIELD_PSDEVUSEROBJID, this.getPSDevUserObjId());
        }
        if (!bl || this.isPSDevUserObjNameDirty()) {
            hashMap.put(FIELD_PSDEVUSEROBJNAME, this.getPSDevUserObjName());
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
        return PSDepSlnUserBase.get(this, n);
    }

    private static Object get(PSDepSlnUserBase pSDepSlnUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnUserBase.getAccMode();
            }
            case 1: {
                return pSDepSlnUserBase.getAllSysFlag();
            }
            case 2: {
                return pSDepSlnUserBase.getCreateDate();
            }
            case 3: {
                return pSDepSlnUserBase.getCreateMan();
            }
            case 4: {
                return pSDepSlnUserBase.getMemo();
            }
            case 5: {
                return pSDepSlnUserBase.getPSDepSlnId();
            }
            case 6: {
                return pSDepSlnUserBase.getPSDepSlnName();
            }
            case 7: {
                return pSDepSlnUserBase.getPSDepSlnSysId();
            }
            case 8: {
                return pSDepSlnUserBase.getPSDepSlnSysName();
            }
            case 9: {
                return pSDepSlnUserBase.getPSDepSlnUserId();
            }
            case 10: {
                return pSDepSlnUserBase.getPSDepSlnUserName();
            }
            case 11: {
                return pSDepSlnUserBase.getPSDevUserObjId();
            }
            case 12: {
                return pSDepSlnUserBase.getPSDevUserObjName();
            }
            case 13: {
                return pSDepSlnUserBase.getUpdateDate();
            }
            case 14: {
                return pSDepSlnUserBase.getUpdateMan();
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
        PSDepSlnUserBase.set(this, n, object);
    }

    private static void set(PSDepSlnUserBase pSDepSlnUserBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnUserBase.setAccMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnUserBase.setAllSysFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnUserBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnUserBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnUserBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnUserBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnUserBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnUserBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnUserBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnUserBase.setPSDepSlnUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnUserBase.setPSDepSlnUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnUserBase.setPSDevUserObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnUserBase.setPSDevUserObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnUserBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnUserBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnUserBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnUserBase pSDepSlnUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnUserBase.getAccMode() == null;
            }
            case 1: {
                return pSDepSlnUserBase.getAllSysFlag() == null;
            }
            case 2: {
                return pSDepSlnUserBase.getCreateDate() == null;
            }
            case 3: {
                return pSDepSlnUserBase.getCreateMan() == null;
            }
            case 4: {
                return pSDepSlnUserBase.getMemo() == null;
            }
            case 5: {
                return pSDepSlnUserBase.getPSDepSlnId() == null;
            }
            case 6: {
                return pSDepSlnUserBase.getPSDepSlnName() == null;
            }
            case 7: {
                return pSDepSlnUserBase.getPSDepSlnSysId() == null;
            }
            case 8: {
                return pSDepSlnUserBase.getPSDepSlnSysName() == null;
            }
            case 9: {
                return pSDepSlnUserBase.getPSDepSlnUserId() == null;
            }
            case 10: {
                return pSDepSlnUserBase.getPSDepSlnUserName() == null;
            }
            case 11: {
                return pSDepSlnUserBase.getPSDevUserObjId() == null;
            }
            case 12: {
                return pSDepSlnUserBase.getPSDevUserObjName() == null;
            }
            case 13: {
                return pSDepSlnUserBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDepSlnUserBase.getUpdateMan() == null;
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
        return PSDepSlnUserBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnUserBase pSDepSlnUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnUserBase.isAccModeDirty();
            }
            case 1: {
                return pSDepSlnUserBase.isAllSysFlagDirty();
            }
            case 2: {
                return pSDepSlnUserBase.isCreateDateDirty();
            }
            case 3: {
                return pSDepSlnUserBase.isCreateManDirty();
            }
            case 4: {
                return pSDepSlnUserBase.isMemoDirty();
            }
            case 5: {
                return pSDepSlnUserBase.isPSDepSlnIdDirty();
            }
            case 6: {
                return pSDepSlnUserBase.isPSDepSlnNameDirty();
            }
            case 7: {
                return pSDepSlnUserBase.isPSDepSlnSysIdDirty();
            }
            case 8: {
                return pSDepSlnUserBase.isPSDepSlnSysNameDirty();
            }
            case 9: {
                return pSDepSlnUserBase.isPSDepSlnUserIdDirty();
            }
            case 10: {
                return pSDepSlnUserBase.isPSDepSlnUserNameDirty();
            }
            case 11: {
                return pSDepSlnUserBase.isPSDevUserObjIdDirty();
            }
            case 12: {
                return pSDepSlnUserBase.isPSDevUserObjNameDirty();
            }
            case 13: {
                return pSDepSlnUserBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDepSlnUserBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnUserBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnUserBase pSDepSlnUserBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnUserBase.getAccMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accmode", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getAccMode()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getAllSysFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allsysflag", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getAllSysFlag()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnuserid", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getPSDepSlnUserId()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnusername", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getPSDepSlnUserName()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getPSDevUserObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserobjid", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getPSDevUserObjId()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getPSDevUserObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserobjname", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getPSDevUserObjName()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnUserBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnUserBase.getJSONValue((Object)pSDepSlnUserBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnUserBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnUserBase pSDepSlnUserBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnUserBase.getAccMode() != null) {
            object = pSDepSlnUserBase.getAccMode();
            xmlNode.setAttribute(FIELD_ACCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnUserBase.getAllSysFlag() != null) {
            object = pSDepSlnUserBase.getAllSysFlag();
            xmlNode.setAttribute(FIELD_ALLSYSFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnUserBase.getCreateDate() != null) {
            object = pSDepSlnUserBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnUserBase.getCreateMan() != null) {
            object = pSDepSlnUserBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getMemo() != null) {
            object = pSDepSlnUserBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnId() != null) {
            object = pSDepSlnUserBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnName() != null) {
            object = pSDepSlnUserBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnUserBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnUserBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnUserId() != null) {
            object = pSDepSlnUserBase.getPSDepSlnUserId();
            xmlNode.setAttribute(FIELD_PSDEPSLNUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getPSDepSlnUserName() != null) {
            object = pSDepSlnUserBase.getPSDepSlnUserName();
            xmlNode.setAttribute(FIELD_PSDEPSLNUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getPSDevUserObjId() != null) {
            object = pSDepSlnUserBase.getPSDevUserObjId();
            xmlNode.setAttribute(FIELD_PSDEVUSEROBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getPSDevUserObjName() != null) {
            object = pSDepSlnUserBase.getPSDevUserObjName();
            xmlNode.setAttribute(FIELD_PSDEVUSEROBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnUserBase.getUpdateDate() != null) {
            object = pSDepSlnUserBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnUserBase.getUpdateMan() != null) {
            object = pSDepSlnUserBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnUserBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnUserBase pSDepSlnUserBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnUserBase.isAccModeDirty() && (bl || pSDepSlnUserBase.getAccMode() != null)) {
            iDataObject.set(FIELD_ACCMODE, (Object)pSDepSlnUserBase.getAccMode());
        }
        if (pSDepSlnUserBase.isAllSysFlagDirty() && (bl || pSDepSlnUserBase.getAllSysFlag() != null)) {
            iDataObject.set(FIELD_ALLSYSFLAG, (Object)pSDepSlnUserBase.getAllSysFlag());
        }
        if (pSDepSlnUserBase.isCreateDateDirty() && (bl || pSDepSlnUserBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnUserBase.getCreateDate());
        }
        if (pSDepSlnUserBase.isCreateManDirty() && (bl || pSDepSlnUserBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnUserBase.getCreateMan());
        }
        if (pSDepSlnUserBase.isMemoDirty() && (bl || pSDepSlnUserBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnUserBase.getMemo());
        }
        if (pSDepSlnUserBase.isPSDepSlnIdDirty() && (bl || pSDepSlnUserBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnUserBase.getPSDepSlnId());
        }
        if (pSDepSlnUserBase.isPSDepSlnNameDirty() && (bl || pSDepSlnUserBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnUserBase.getPSDepSlnName());
        }
        if (pSDepSlnUserBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnUserBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnUserBase.getPSDepSlnSysId());
        }
        if (pSDepSlnUserBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnUserBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnUserBase.getPSDepSlnSysName());
        }
        if (pSDepSlnUserBase.isPSDepSlnUserIdDirty() && (bl || pSDepSlnUserBase.getPSDepSlnUserId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNUSERID, (Object)pSDepSlnUserBase.getPSDepSlnUserId());
        }
        if (pSDepSlnUserBase.isPSDepSlnUserNameDirty() && (bl || pSDepSlnUserBase.getPSDepSlnUserName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNUSERNAME, (Object)pSDepSlnUserBase.getPSDepSlnUserName());
        }
        if (pSDepSlnUserBase.isPSDevUserObjIdDirty() && (bl || pSDepSlnUserBase.getPSDevUserObjId() != null)) {
            iDataObject.set(FIELD_PSDEVUSEROBJID, (Object)pSDepSlnUserBase.getPSDevUserObjId());
        }
        if (pSDepSlnUserBase.isPSDevUserObjNameDirty() && (bl || pSDepSlnUserBase.getPSDevUserObjName() != null)) {
            iDataObject.set(FIELD_PSDEVUSEROBJNAME, (Object)pSDepSlnUserBase.getPSDevUserObjName());
        }
        if (pSDepSlnUserBase.isUpdateDateDirty() && (bl || pSDepSlnUserBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnUserBase.getUpdateDate());
        }
        if (pSDepSlnUserBase.isUpdateManDirty() && (bl || pSDepSlnUserBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnUserBase.getUpdateMan());
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
        return PSDepSlnUserBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnUserBase pSDepSlnUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnUserBase.resetAccMode();
                return true;
            }
            case 1: {
                pSDepSlnUserBase.resetAllSysFlag();
                return true;
            }
            case 2: {
                pSDepSlnUserBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDepSlnUserBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDepSlnUserBase.resetMemo();
                return true;
            }
            case 5: {
                pSDepSlnUserBase.resetPSDepSlnId();
                return true;
            }
            case 6: {
                pSDepSlnUserBase.resetPSDepSlnName();
                return true;
            }
            case 7: {
                pSDepSlnUserBase.resetPSDepSlnSysId();
                return true;
            }
            case 8: {
                pSDepSlnUserBase.resetPSDepSlnSysName();
                return true;
            }
            case 9: {
                pSDepSlnUserBase.resetPSDepSlnUserId();
                return true;
            }
            case 10: {
                pSDepSlnUserBase.resetPSDepSlnUserName();
                return true;
            }
            case 11: {
                pSDepSlnUserBase.resetPSDevUserObjId();
                return true;
            }
            case 12: {
                pSDepSlnUserBase.resetPSDevUserObjName();
                return true;
            }
            case 13: {
                pSDepSlnUserBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDepSlnUserBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSys getPSDepSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSys();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnSysLock;
        synchronized (n) {
            if (this.psdepslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnSysId(), (Object)this.psdepslnsys.getPSDepSlnSysId()) != 0L) {
                this.psdepslnsys = null;
            }
            if (this.psdepslnsys == null) {
                PSDepSlnSys pSDepSlnSys = new PSDepSlnSys();
                pSDepSlnSys.setPSDepSlnSysId(this.getPSDepSlnSysId());
                PSDepSlnSysService pSDepSlnSysService = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysService.autoGet((IEntity)pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet((IEntity)pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUserObj getPSDevUserObj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObj();
        }
        if (this.getPSDevUserObjId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserObjLock;
        synchronized (n) {
            if (this.psdevuserobj != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserObjId(), (Object)this.psdevuserobj.getPSDevUserObjectId()) != 0L) {
                this.psdevuserobj = null;
            }
            if (this.psdevuserobj == null) {
                PSDevUserObj pSDevUserObj = new PSDevUserObj();
                pSDevUserObj.setPSDevUserObjectId(this.getPSDevUserObjId());
                PSDevUserObjService pSDevUserObjService = (PSDevUserObjService)ServiceGlobal.getService(PSDevUserObjService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserObjService.autoGet((IEntity)pSDevUserObj);
                this.psdevuserobj = pSDevUserObj;
            }
            return this.psdevuserobj;
        }
    }

    private PSDepSlnUserBase getProxyEntity() {
        return this.proxyPSDepSlnUserBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnUserBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnUserBase) {
            this.proxyPSDepSlnUserBase = (PSDepSlnUserBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnUserService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCMODE, 0);
        fieldIndexMap.put(FIELD_ALLSYSFLAG, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNUSERID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNUSERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVUSEROBJID, 11);
        fieldIndexMap.put(FIELD_PSDEVUSEROBJNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

