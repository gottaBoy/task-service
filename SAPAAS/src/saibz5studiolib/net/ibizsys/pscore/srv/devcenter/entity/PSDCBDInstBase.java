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
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBDDevInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSBDDevInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCBDInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCBDInstBase.class);
    public static final String FIELD_BDTYPE = "BDTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKMODE = "LOCKMODE";
    public static final String FIELD_LOCKOBJID = "LOCKOBJID";
    public static final String FIELD_LOCKOBJTYPE = "LOCKOBJTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSBDDEVINSTID = "PSBDDEVINSTID";
    public static final String FIELD_PSBDDEVINSTNAME = "PSBDDEVINSTNAME";
    public static final String FIELD_PSDCBDINSTID = "PSDCBDINSTID";
    public static final String FIELD_PSDCBDINSTNAME = "PSDCBDINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_SYSMEMO = "SYSMEMO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BDTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOCKMODE = 3;
    private static final int INDEX_LOCKOBJID = 4;
    private static final int INDEX_LOCKOBJTYPE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSBDDEVINSTID = 7;
    private static final int INDEX_PSBDDEVINSTNAME = 8;
    private static final int INDEX_PSDCBDINSTID = 9;
    private static final int INDEX_PSDCBDINSTNAME = 10;
    private static final int INDEX_PSDEVCENTERID = 11;
    private static final int INDEX_PSDEVCENTERNAME = 12;
    private static final int INDEX_PSDEVSLNID = 13;
    private static final int INDEX_PSDEVSLNNAME = 14;
    private static final int INDEX_REFCOUNT = 15;
    private static final int INDEX_REFINFO = 16;
    private static final int INDEX_SYSMEMO = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCBDInstBase proxyPSDCBDInstBase = null;
    private boolean bdtypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockmodeDirtyFlag = false;
    private boolean lockobjidDirtyFlag = false;
    private boolean lockobjtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psbddevinstidDirtyFlag = false;
    private boolean psbddevinstnameDirtyFlag = false;
    private boolean psdcbdinstidDirtyFlag = false;
    private boolean psdcbdinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean sysmemoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="bdtype")
    private String bdtype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lockmode")
    private Integer lockmode;
    @Column(name="lockobjid")
    private String lockobjid;
    @Column(name="lockobjtype")
    private String lockobjtype;
    @Column(name="memo")
    private String memo;
    @Column(name="psbddevinstid")
    private String psbddevinstid;
    @Column(name="psbddevinstname")
    private String psbddevinstname;
    @Column(name="psdcbdinstid")
    private String psdcbdinstid;
    @Column(name="psdcbdinstname")
    private String psdcbdinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="refcount")
    private Integer refcount;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="sysmemo")
    private String sysmemo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSBDDevInstLock = new Integer(1);
    private PSBDDevInst psbddevinst = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setBDType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBDType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bdtype = string;
        this.bdtypeDirtyFlag = true;
    }

    public String getBDType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBDType();
        }
        return this.bdtype;
    }

    public boolean isBDTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBDTypeDirty();
        }
        return this.bdtypeDirtyFlag;
    }

    public void resetBDType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBDType();
            return;
        }
        this.bdtypeDirtyFlag = false;
        this.bdtype = null;
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

    public void setLockMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockMode(n);
            return;
        }
        this.lockmode = n;
        this.lockmodeDirtyFlag = true;
    }

    public Integer getLockMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockMode();
        }
        return this.lockmode;
    }

    public boolean isLockModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockModeDirty();
        }
        return this.lockmodeDirtyFlag;
    }

    public void resetLockMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockMode();
            return;
        }
        this.lockmodeDirtyFlag = false;
        this.lockmode = null;
    }

    public void setLockObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockobjid = string;
        this.lockobjidDirtyFlag = true;
    }

    public String getLockObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockObjId();
        }
        return this.lockobjid;
    }

    public boolean isLockObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockObjIdDirty();
        }
        return this.lockobjidDirtyFlag;
    }

    public void resetLockObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockObjId();
            return;
        }
        this.lockobjidDirtyFlag = false;
        this.lockobjid = null;
    }

    public void setLockObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockobjtype = string;
        this.lockobjtypeDirtyFlag = true;
    }

    public String getLockObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockObjType();
        }
        return this.lockobjtype;
    }

    public boolean isLockObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockObjTypeDirty();
        }
        return this.lockobjtypeDirtyFlag;
    }

    public void resetLockObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockObjType();
            return;
        }
        this.lockobjtypeDirtyFlag = false;
        this.lockobjtype = null;
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

    public void setPSBDDevInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDDevInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbddevinstid = string;
        this.psbddevinstidDirtyFlag = true;
    }

    public String getPSBDDevInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDDevInstId();
        }
        return this.psbddevinstid;
    }

    public boolean isPSBDDevInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDDevInstIdDirty();
        }
        return this.psbddevinstidDirtyFlag;
    }

    public void resetPSBDDevInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDDevInstId();
            return;
        }
        this.psbddevinstidDirtyFlag = false;
        this.psbddevinstid = null;
    }

    public void setPSBDDevInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDDevInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbddevinstname = string;
        this.psbddevinstnameDirtyFlag = true;
    }

    public String getPSBDDevInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDDevInstName();
        }
        return this.psbddevinstname;
    }

    public boolean isPSBDDevInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDDevInstNameDirty();
        }
        return this.psbddevinstnameDirtyFlag;
    }

    public void resetPSBDDevInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDDevInstName();
            return;
        }
        this.psbddevinstnameDirtyFlag = false;
        this.psbddevinstname = null;
    }

    public void setPSDCBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbdinstid = string;
        this.psdcbdinstidDirtyFlag = true;
    }

    public String getPSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInstId();
        }
        return this.psdcbdinstid;
    }

    public boolean isPSDCBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBDInstIdDirty();
        }
        return this.psdcbdinstidDirtyFlag;
    }

    public void resetPSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBDInstId();
            return;
        }
        this.psdcbdinstidDirtyFlag = false;
        this.psdcbdinstid = null;
    }

    public void setPSDCBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbdinstname = string;
        this.psdcbdinstnameDirtyFlag = true;
    }

    public String getPSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInstName();
        }
        return this.psdcbdinstname;
    }

    public boolean isPSDCBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBDInstNameDirty();
        }
        return this.psdcbdinstnameDirtyFlag;
    }

    public void resetPSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBDInstName();
            return;
        }
        this.psdcbdinstnameDirtyFlag = false;
        this.psdcbdinstname = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setRefCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCount(n);
            return;
        }
        this.refcount = n;
        this.refcountDirtyFlag = true;
    }

    public Integer getRefCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCount();
        }
        return this.refcount;
    }

    public boolean isRefCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCountDirty();
        }
        return this.refcountDirtyFlag;
    }

    public void resetRefCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCount();
            return;
        }
        this.refcountDirtyFlag = false;
        this.refcount = null;
    }

    public void setRefInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refinfo = string;
        this.refinfoDirtyFlag = true;
    }

    public String getRefInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefInfo();
        }
        return this.refinfo;
    }

    public boolean isRefInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefInfoDirty();
        }
        return this.refinfoDirtyFlag;
    }

    public void resetRefInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefInfo();
            return;
        }
        this.refinfoDirtyFlag = false;
        this.refinfo = null;
    }

    public void setSysMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysmemo = string;
        this.sysmemoDirtyFlag = true;
    }

    public String getSysMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysMemo();
        }
        return this.sysmemo;
    }

    public boolean isSysMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysMemoDirty();
        }
        return this.sysmemoDirtyFlag;
    }

    public void resetSysMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysMemo();
            return;
        }
        this.sysmemoDirtyFlag = false;
        this.sysmemo = null;
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
        PSDCBDInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCBDInstBase pSDCBDInstBase) {
        pSDCBDInstBase.resetBDType();
        pSDCBDInstBase.resetCreateDate();
        pSDCBDInstBase.resetCreateMan();
        pSDCBDInstBase.resetLockMode();
        pSDCBDInstBase.resetLockObjId();
        pSDCBDInstBase.resetLockObjType();
        pSDCBDInstBase.resetMemo();
        pSDCBDInstBase.resetPSBDDevInstId();
        pSDCBDInstBase.resetPSBDDevInstName();
        pSDCBDInstBase.resetPSDCBDInstId();
        pSDCBDInstBase.resetPSDCBDInstName();
        pSDCBDInstBase.resetPSDevCenterId();
        pSDCBDInstBase.resetPSDevCenterName();
        pSDCBDInstBase.resetPSDevSlnId();
        pSDCBDInstBase.resetPSDevSlnName();
        pSDCBDInstBase.resetRefCount();
        pSDCBDInstBase.resetRefInfo();
        pSDCBDInstBase.resetSysMemo();
        pSDCBDInstBase.resetUpdateDate();
        pSDCBDInstBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBDTypeDirty()) {
            hashMap.put(FIELD_BDTYPE, this.getBDType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLockModeDirty()) {
            hashMap.put(FIELD_LOCKMODE, this.getLockMode());
        }
        if (!bl || this.isLockObjIdDirty()) {
            hashMap.put(FIELD_LOCKOBJID, this.getLockObjId());
        }
        if (!bl || this.isLockObjTypeDirty()) {
            hashMap.put(FIELD_LOCKOBJTYPE, this.getLockObjType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSBDDevInstIdDirty()) {
            hashMap.put(FIELD_PSBDDEVINSTID, this.getPSBDDevInstId());
        }
        if (!bl || this.isPSBDDevInstNameDirty()) {
            hashMap.put(FIELD_PSBDDEVINSTNAME, this.getPSBDDevInstName());
        }
        if (!bl || this.isPSDCBDInstIdDirty()) {
            hashMap.put(FIELD_PSDCBDINSTID, this.getPSDCBDInstId());
        }
        if (!bl || this.isPSDCBDInstNameDirty()) {
            hashMap.put(FIELD_PSDCBDINSTNAME, this.getPSDCBDInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isRefCountDirty()) {
            hashMap.put(FIELD_REFCOUNT, this.getRefCount());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isSysMemoDirty()) {
            hashMap.put(FIELD_SYSMEMO, this.getSysMemo());
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
        return PSDCBDInstBase.get(this, n);
    }

    private static Object get(PSDCBDInstBase pSDCBDInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBDInstBase.getBDType();
            }
            case 1: {
                return pSDCBDInstBase.getCreateDate();
            }
            case 2: {
                return pSDCBDInstBase.getCreateMan();
            }
            case 3: {
                return pSDCBDInstBase.getLockMode();
            }
            case 4: {
                return pSDCBDInstBase.getLockObjId();
            }
            case 5: {
                return pSDCBDInstBase.getLockObjType();
            }
            case 6: {
                return pSDCBDInstBase.getMemo();
            }
            case 7: {
                return pSDCBDInstBase.getPSBDDevInstId();
            }
            case 8: {
                return pSDCBDInstBase.getPSBDDevInstName();
            }
            case 9: {
                return pSDCBDInstBase.getPSDCBDInstId();
            }
            case 10: {
                return pSDCBDInstBase.getPSDCBDInstName();
            }
            case 11: {
                return pSDCBDInstBase.getPSDevCenterId();
            }
            case 12: {
                return pSDCBDInstBase.getPSDevCenterName();
            }
            case 13: {
                return pSDCBDInstBase.getPSDevSlnId();
            }
            case 14: {
                return pSDCBDInstBase.getPSDevSlnName();
            }
            case 15: {
                return pSDCBDInstBase.getRefCount();
            }
            case 16: {
                return pSDCBDInstBase.getRefInfo();
            }
            case 17: {
                return pSDCBDInstBase.getSysMemo();
            }
            case 18: {
                return pSDCBDInstBase.getUpdateDate();
            }
            case 19: {
                return pSDCBDInstBase.getUpdateMan();
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
        PSDCBDInstBase.set(this, n, object);
    }

    private static void set(PSDCBDInstBase pSDCBDInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCBDInstBase.setBDType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCBDInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCBDInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCBDInstBase.setLockMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCBDInstBase.setLockObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCBDInstBase.setLockObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCBDInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCBDInstBase.setPSBDDevInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCBDInstBase.setPSBDDevInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCBDInstBase.setPSDCBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCBDInstBase.setPSDCBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCBDInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCBDInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCBDInstBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCBDInstBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCBDInstBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDCBDInstBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCBDInstBase.setSysMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCBDInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDCBDInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCBDInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDCBDInstBase pSDCBDInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBDInstBase.getBDType() == null;
            }
            case 1: {
                return pSDCBDInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCBDInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCBDInstBase.getLockMode() == null;
            }
            case 4: {
                return pSDCBDInstBase.getLockObjId() == null;
            }
            case 5: {
                return pSDCBDInstBase.getLockObjType() == null;
            }
            case 6: {
                return pSDCBDInstBase.getMemo() == null;
            }
            case 7: {
                return pSDCBDInstBase.getPSBDDevInstId() == null;
            }
            case 8: {
                return pSDCBDInstBase.getPSBDDevInstName() == null;
            }
            case 9: {
                return pSDCBDInstBase.getPSDCBDInstId() == null;
            }
            case 10: {
                return pSDCBDInstBase.getPSDCBDInstName() == null;
            }
            case 11: {
                return pSDCBDInstBase.getPSDevCenterId() == null;
            }
            case 12: {
                return pSDCBDInstBase.getPSDevCenterName() == null;
            }
            case 13: {
                return pSDCBDInstBase.getPSDevSlnId() == null;
            }
            case 14: {
                return pSDCBDInstBase.getPSDevSlnName() == null;
            }
            case 15: {
                return pSDCBDInstBase.getRefCount() == null;
            }
            case 16: {
                return pSDCBDInstBase.getRefInfo() == null;
            }
            case 17: {
                return pSDCBDInstBase.getSysMemo() == null;
            }
            case 18: {
                return pSDCBDInstBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDCBDInstBase.getUpdateMan() == null;
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
        return PSDCBDInstBase.contains(this, n);
    }

    private static boolean contains(PSDCBDInstBase pSDCBDInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBDInstBase.isBDTypeDirty();
            }
            case 1: {
                return pSDCBDInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCBDInstBase.isCreateManDirty();
            }
            case 3: {
                return pSDCBDInstBase.isLockModeDirty();
            }
            case 4: {
                return pSDCBDInstBase.isLockObjIdDirty();
            }
            case 5: {
                return pSDCBDInstBase.isLockObjTypeDirty();
            }
            case 6: {
                return pSDCBDInstBase.isMemoDirty();
            }
            case 7: {
                return pSDCBDInstBase.isPSBDDevInstIdDirty();
            }
            case 8: {
                return pSDCBDInstBase.isPSBDDevInstNameDirty();
            }
            case 9: {
                return pSDCBDInstBase.isPSDCBDInstIdDirty();
            }
            case 10: {
                return pSDCBDInstBase.isPSDCBDInstNameDirty();
            }
            case 11: {
                return pSDCBDInstBase.isPSDevCenterIdDirty();
            }
            case 12: {
                return pSDCBDInstBase.isPSDevCenterNameDirty();
            }
            case 13: {
                return pSDCBDInstBase.isPSDevSlnIdDirty();
            }
            case 14: {
                return pSDCBDInstBase.isPSDevSlnNameDirty();
            }
            case 15: {
                return pSDCBDInstBase.isRefCountDirty();
            }
            case 16: {
                return pSDCBDInstBase.isRefInfoDirty();
            }
            case 17: {
                return pSDCBDInstBase.isSysMemoDirty();
            }
            case 18: {
                return pSDCBDInstBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDCBDInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCBDInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCBDInstBase pSDCBDInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCBDInstBase.getBDType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bdtype", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getBDType()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getLockMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockmode", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getLockMode()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getLockObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjid", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getLockObjId()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getLockObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjtype", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getLockObjType()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getPSBDDevInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbddevinstid", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getPSBDDevInstId()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getPSBDDevInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbddevinstname", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getPSBDDevInstName()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getPSDCBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbdinstid", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getPSDCBDInstId()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getPSDCBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbdinstname", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getPSDCBDInstName()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getSysMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmemo", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getSysMemo()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCBDInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCBDInstBase.getJSONValue((Object)pSDCBDInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCBDInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCBDInstBase pSDCBDInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCBDInstBase.getBDType() != null) {
            object = pSDCBDInstBase.getBDType();
            xmlNode.setAttribute(FIELD_BDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getCreateDate() != null) {
            object = pSDCBDInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBDInstBase.getCreateMan() != null) {
            object = pSDCBDInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getLockMode() != null) {
            object = pSDCBDInstBase.getLockMode();
            xmlNode.setAttribute(FIELD_LOCKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBDInstBase.getLockObjId() != null) {
            object = pSDCBDInstBase.getLockObjId();
            xmlNode.setAttribute(FIELD_LOCKOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getLockObjType() != null) {
            object = pSDCBDInstBase.getLockObjType();
            xmlNode.setAttribute(FIELD_LOCKOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getMemo() != null) {
            object = pSDCBDInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getPSBDDevInstId() != null) {
            object = pSDCBDInstBase.getPSBDDevInstId();
            xmlNode.setAttribute(FIELD_PSBDDEVINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getPSBDDevInstName() != null) {
            object = pSDCBDInstBase.getPSBDDevInstName();
            xmlNode.setAttribute(FIELD_PSBDDEVINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getPSDCBDInstId() != null) {
            object = pSDCBDInstBase.getPSDCBDInstId();
            xmlNode.setAttribute(FIELD_PSDCBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getPSDCBDInstName() != null) {
            object = pSDCBDInstBase.getPSDCBDInstName();
            xmlNode.setAttribute(FIELD_PSDCBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getPSDevCenterId() != null) {
            object = pSDCBDInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getPSDevCenterName() != null) {
            object = pSDCBDInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getPSDevSlnId() != null) {
            object = pSDCBDInstBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getPSDevSlnName() != null) {
            object = pSDCBDInstBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getRefCount() != null) {
            object = pSDCBDInstBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBDInstBase.getRefInfo() != null) {
            object = pSDCBDInstBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getSysMemo() != null) {
            object = pSDCBDInstBase.getSysMemo();
            xmlNode.setAttribute(FIELD_SYSMEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBDInstBase.getUpdateDate() != null) {
            object = pSDCBDInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBDInstBase.getUpdateMan() != null) {
            object = pSDCBDInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCBDInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCBDInstBase pSDCBDInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCBDInstBase.isBDTypeDirty() && (bl || pSDCBDInstBase.getBDType() != null)) {
            iDataObject.set(FIELD_BDTYPE, (Object)pSDCBDInstBase.getBDType());
        }
        if (pSDCBDInstBase.isCreateDateDirty() && (bl || pSDCBDInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCBDInstBase.getCreateDate());
        }
        if (pSDCBDInstBase.isCreateManDirty() && (bl || pSDCBDInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCBDInstBase.getCreateMan());
        }
        if (pSDCBDInstBase.isLockModeDirty() && (bl || pSDCBDInstBase.getLockMode() != null)) {
            iDataObject.set(FIELD_LOCKMODE, (Object)pSDCBDInstBase.getLockMode());
        }
        if (pSDCBDInstBase.isLockObjIdDirty() && (bl || pSDCBDInstBase.getLockObjId() != null)) {
            iDataObject.set(FIELD_LOCKOBJID, (Object)pSDCBDInstBase.getLockObjId());
        }
        if (pSDCBDInstBase.isLockObjTypeDirty() && (bl || pSDCBDInstBase.getLockObjType() != null)) {
            iDataObject.set(FIELD_LOCKOBJTYPE, (Object)pSDCBDInstBase.getLockObjType());
        }
        if (pSDCBDInstBase.isMemoDirty() && (bl || pSDCBDInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCBDInstBase.getMemo());
        }
        if (pSDCBDInstBase.isPSBDDevInstIdDirty() && (bl || pSDCBDInstBase.getPSBDDevInstId() != null)) {
            iDataObject.set(FIELD_PSBDDEVINSTID, (Object)pSDCBDInstBase.getPSBDDevInstId());
        }
        if (pSDCBDInstBase.isPSBDDevInstNameDirty() && (bl || pSDCBDInstBase.getPSBDDevInstName() != null)) {
            iDataObject.set(FIELD_PSBDDEVINSTNAME, (Object)pSDCBDInstBase.getPSBDDevInstName());
        }
        if (pSDCBDInstBase.isPSDCBDInstIdDirty() && (bl || pSDCBDInstBase.getPSDCBDInstId() != null)) {
            iDataObject.set(FIELD_PSDCBDINSTID, (Object)pSDCBDInstBase.getPSDCBDInstId());
        }
        if (pSDCBDInstBase.isPSDCBDInstNameDirty() && (bl || pSDCBDInstBase.getPSDCBDInstName() != null)) {
            iDataObject.set(FIELD_PSDCBDINSTNAME, (Object)pSDCBDInstBase.getPSDCBDInstName());
        }
        if (pSDCBDInstBase.isPSDevCenterIdDirty() && (bl || pSDCBDInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCBDInstBase.getPSDevCenterId());
        }
        if (pSDCBDInstBase.isPSDevCenterNameDirty() && (bl || pSDCBDInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCBDInstBase.getPSDevCenterName());
        }
        if (pSDCBDInstBase.isPSDevSlnIdDirty() && (bl || pSDCBDInstBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCBDInstBase.getPSDevSlnId());
        }
        if (pSDCBDInstBase.isPSDevSlnNameDirty() && (bl || pSDCBDInstBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCBDInstBase.getPSDevSlnName());
        }
        if (pSDCBDInstBase.isRefCountDirty() && (bl || pSDCBDInstBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDCBDInstBase.getRefCount());
        }
        if (pSDCBDInstBase.isRefInfoDirty() && (bl || pSDCBDInstBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSDCBDInstBase.getRefInfo());
        }
        if (pSDCBDInstBase.isSysMemoDirty() && (bl || pSDCBDInstBase.getSysMemo() != null)) {
            iDataObject.set(FIELD_SYSMEMO, (Object)pSDCBDInstBase.getSysMemo());
        }
        if (pSDCBDInstBase.isUpdateDateDirty() && (bl || pSDCBDInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCBDInstBase.getUpdateDate());
        }
        if (pSDCBDInstBase.isUpdateManDirty() && (bl || pSDCBDInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCBDInstBase.getUpdateMan());
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
        return PSDCBDInstBase.remove(this, n);
    }

    private static boolean remove(PSDCBDInstBase pSDCBDInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCBDInstBase.resetBDType();
                return true;
            }
            case 1: {
                pSDCBDInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCBDInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCBDInstBase.resetLockMode();
                return true;
            }
            case 4: {
                pSDCBDInstBase.resetLockObjId();
                return true;
            }
            case 5: {
                pSDCBDInstBase.resetLockObjType();
                return true;
            }
            case 6: {
                pSDCBDInstBase.resetMemo();
                return true;
            }
            case 7: {
                pSDCBDInstBase.resetPSBDDevInstId();
                return true;
            }
            case 8: {
                pSDCBDInstBase.resetPSBDDevInstName();
                return true;
            }
            case 9: {
                pSDCBDInstBase.resetPSDCBDInstId();
                return true;
            }
            case 10: {
                pSDCBDInstBase.resetPSDCBDInstName();
                return true;
            }
            case 11: {
                pSDCBDInstBase.resetPSDevCenterId();
                return true;
            }
            case 12: {
                pSDCBDInstBase.resetPSDevCenterName();
                return true;
            }
            case 13: {
                pSDCBDInstBase.resetPSDevSlnId();
                return true;
            }
            case 14: {
                pSDCBDInstBase.resetPSDevSlnName();
                return true;
            }
            case 15: {
                pSDCBDInstBase.resetRefCount();
                return true;
            }
            case 16: {
                pSDCBDInstBase.resetRefInfo();
                return true;
            }
            case 17: {
                pSDCBDInstBase.resetSysMemo();
                return true;
            }
            case 18: {
                pSDCBDInstBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDCBDInstBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSBDDevInst getPSBDDevInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDDevInst();
        }
        if (this.getPSBDDevInstId() == null) {
            return null;
        }
        Integer n = this.objPSBDDevInstLock;
        synchronized (n) {
            if (this.psbddevinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSBDDevInstId(), (Object)this.psbddevinst.getPSBDDevInstId()) != 0L) {
                this.psbddevinst = null;
            }
            if (this.psbddevinst == null) {
                PSBDDevInst pSBDDevInst = new PSBDDevInst();
                pSBDDevInst.setPSBDDevInstId(this.getPSBDDevInstId());
                PSBDDevInstService pSBDDevInstService = (PSBDDevInstService)ServiceGlobal.getService(PSBDDevInstService.class, (SessionFactory)this.getSessionFactory());
                pSBDDevInstService.autoGet(pSBDDevInst);
                this.psbddevinst = pSBDDevInst;
            }
            return this.psbddevinst;
        }
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDCBDInstBase getProxyEntity() {
        return this.proxyPSDCBDInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCBDInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCBDInstBase) {
            this.proxyPSDCBDInstBase = (PSDCBDInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BDTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCKMODE, 3);
        fieldIndexMap.put(FIELD_LOCKOBJID, 4);
        fieldIndexMap.put(FIELD_LOCKOBJTYPE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSBDDEVINSTID, 7);
        fieldIndexMap.put(FIELD_PSBDDEVINSTNAME, 8);
        fieldIndexMap.put(FIELD_PSDCBDINSTID, 9);
        fieldIndexMap.put(FIELD_PSDCBDINSTNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 14);
        fieldIndexMap.put(FIELD_REFCOUNT, 15);
        fieldIndexMap.put(FIELD_REFINFO, 16);
        fieldIndexMap.put(FIELD_SYSMEMO, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

