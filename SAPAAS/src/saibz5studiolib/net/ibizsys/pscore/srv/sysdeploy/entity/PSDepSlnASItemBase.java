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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroup;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnASItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnASItemBase.class);
    public static final String FIELD_BACKUPMODE = "BACKUPMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FAILTIMEOUT = "FAILTIMEOUT";
    public static final String FIELD_MAXFAILS = "MAXFAILS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNASGROUPID = "PSDEPSLNASGRPID";
    public static final String FIELD_PSDEPSLNASGROUPNAME = "PSDEPSLNASGRPNAME";
    public static final String FIELD_PSDEPSLNASID = "PSDEPSLNASID";
    public static final String FIELD_PSDEPSLNASITEMID = "PSDEPSLNASITEMID";
    public static final String FIELD_PSDEPSLNASITEMNAME = "PSDEPSLNASITEMNAME";
    public static final String FIELD_PSDEPSLNASNAME = "PSDEPSLNASNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WEIGHT = "WEIGHT";
    private static final int INDEX_BACKUPMODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FAILTIMEOUT = 3;
    private static final int INDEX_MAXFAILS = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEPSLNASGROUPID = 6;
    private static final int INDEX_PSDEPSLNASGROUPNAME = 7;
    private static final int INDEX_PSDEPSLNASID = 8;
    private static final int INDEX_PSDEPSLNASITEMID = 9;
    private static final int INDEX_PSDEPSLNASITEMNAME = 10;
    private static final int INDEX_PSDEPSLNASNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_WEIGHT = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnASItemBase proxyPSDepSlnASItemBase = null;
    private boolean backupmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean failtimeoutDirtyFlag = false;
    private boolean maxfailsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnasgroupidDirtyFlag = false;
    private boolean psdepslnasgroupnameDirtyFlag = false;
    private boolean psdepslnasidDirtyFlag = false;
    private boolean psdepslnasitemidDirtyFlag = false;
    private boolean psdepslnasitemnameDirtyFlag = false;
    private boolean psdepslnasnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean weightDirtyFlag = false;
    @Column(name="backupmode")
    private Integer backupmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="failtimeout")
    private Integer failtimeout;
    @Column(name="maxfails")
    private Integer maxfails;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnasgroupid")
    private String psdepslnasgroupid;
    @Column(name="psdepslnasgroupname")
    private String psdepslnasgroupname;
    @Column(name="psdepslnasid")
    private String psdepslnasid;
    @Column(name="psdepslnasitemid")
    private String psdepslnasitemid;
    @Column(name="psdepslnasitemname")
    private String psdepslnasitemname;
    @Column(name="psdepslnasname")
    private String psdepslnasname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="weight")
    private Integer weight;
    private Integer objPSDepSlnASGroupLock = new Integer(1);
    private PSDepSlnASGroup psdepslnasgroup = null;
    private Integer objPSDepSlnASLock = new Integer(1);
    private PSDepSlnAS psdepslnas = null;

    public void setBackupMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupMode(n);
            return;
        }
        this.backupmode = n;
        this.backupmodeDirtyFlag = true;
    }

    public Integer getBackupMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupMode();
        }
        return this.backupmode;
    }

    public boolean isBackupModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupModeDirty();
        }
        return this.backupmodeDirtyFlag;
    }

    public void resetBackupMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupMode();
            return;
        }
        this.backupmodeDirtyFlag = false;
        this.backupmode = null;
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

    public void setFailTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFailTimeout(n);
            return;
        }
        this.failtimeout = n;
        this.failtimeoutDirtyFlag = true;
    }

    public Integer getFailTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFailTimeout();
        }
        return this.failtimeout;
    }

    public boolean isFailTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFailTimeoutDirty();
        }
        return this.failtimeoutDirtyFlag;
    }

    public void resetFailTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFailTimeout();
            return;
        }
        this.failtimeoutDirtyFlag = false;
        this.failtimeout = null;
    }

    public void setMaxFails(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxFails(n);
            return;
        }
        this.maxfails = n;
        this.maxfailsDirtyFlag = true;
    }

    public Integer getMaxFails() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxFails();
        }
        return this.maxfails;
    }

    public boolean isMaxFailsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxFailsDirty();
        }
        return this.maxfailsDirtyFlag;
    }

    public void resetMaxFails() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxFails();
            return;
        }
        this.maxfailsDirtyFlag = false;
        this.maxfails = null;
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

    public void setPSDepSlnASGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasgroupid = string;
        this.psdepslnasgroupidDirtyFlag = true;
    }

    public String getPSDepSlnASGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGroupId();
        }
        return this.psdepslnasgroupid;
    }

    public boolean isPSDepSlnASGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASGroupIdDirty();
        }
        return this.psdepslnasgroupidDirtyFlag;
    }

    public void resetPSDepSlnASGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASGroupId();
            return;
        }
        this.psdepslnasgroupidDirtyFlag = false;
        this.psdepslnasgroupid = null;
    }

    public void setPSDepSlnASGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasgroupname = string;
        this.psdepslnasgroupnameDirtyFlag = true;
    }

    public String getPSDepSlnASGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGroupName();
        }
        return this.psdepslnasgroupname;
    }

    public boolean isPSDepSlnASGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASGroupNameDirty();
        }
        return this.psdepslnasgroupnameDirtyFlag;
    }

    public void resetPSDepSlnASGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASGroupName();
            return;
        }
        this.psdepslnasgroupnameDirtyFlag = false;
        this.psdepslnasgroupname = null;
    }

    public void setPSDepSlnASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasid = string;
        this.psdepslnasidDirtyFlag = true;
    }

    public String getPSDepSlnASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASId();
        }
        return this.psdepslnasid;
    }

    public boolean isPSDepSlnASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASIdDirty();
        }
        return this.psdepslnasidDirtyFlag;
    }

    public void resetPSDepSlnASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASId();
            return;
        }
        this.psdepslnasidDirtyFlag = false;
        this.psdepslnasid = null;
    }

    public void setPSDepSlnASItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasitemid = string;
        this.psdepslnasitemidDirtyFlag = true;
    }

    public String getPSDepSlnASItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASItemId();
        }
        return this.psdepslnasitemid;
    }

    public boolean isPSDepSlnASItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASItemIdDirty();
        }
        return this.psdepslnasitemidDirtyFlag;
    }

    public void resetPSDepSlnASItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASItemId();
            return;
        }
        this.psdepslnasitemidDirtyFlag = false;
        this.psdepslnasitemid = null;
    }

    public void setPSDepSlnASItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasitemname = string;
        this.psdepslnasitemnameDirtyFlag = true;
    }

    public String getPSDepSlnASItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASItemName();
        }
        return this.psdepslnasitemname;
    }

    public boolean isPSDepSlnASItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASItemNameDirty();
        }
        return this.psdepslnasitemnameDirtyFlag;
    }

    public void resetPSDepSlnASItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASItemName();
            return;
        }
        this.psdepslnasitemnameDirtyFlag = false;
        this.psdepslnasitemname = null;
    }

    public void setPSDepSlnASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasname = string;
        this.psdepslnasnameDirtyFlag = true;
    }

    public String getPSDepSlnASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASName();
        }
        return this.psdepslnasname;
    }

    public boolean isPSDepSlnASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASNameDirty();
        }
        return this.psdepslnasnameDirtyFlag;
    }

    public void resetPSDepSlnASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASName();
            return;
        }
        this.psdepslnasnameDirtyFlag = false;
        this.psdepslnasname = null;
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

    public void setWeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWeight(n);
            return;
        }
        this.weight = n;
        this.weightDirtyFlag = true;
    }

    public Integer getWeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWeight();
        }
        return this.weight;
    }

    public boolean isWeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWeightDirty();
        }
        return this.weightDirtyFlag;
    }

    public void resetWeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWeight();
            return;
        }
        this.weightDirtyFlag = false;
        this.weight = null;
    }

    protected void onReset() {
        PSDepSlnASItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnASItemBase pSDepSlnASItemBase) {
        pSDepSlnASItemBase.resetBackupMode();
        pSDepSlnASItemBase.resetCreateDate();
        pSDepSlnASItemBase.resetCreateMan();
        pSDepSlnASItemBase.resetFailTimeout();
        pSDepSlnASItemBase.resetMaxFails();
        pSDepSlnASItemBase.resetMemo();
        pSDepSlnASItemBase.resetPSDepSlnASGroupId();
        pSDepSlnASItemBase.resetPSDepSlnASGroupName();
        pSDepSlnASItemBase.resetPSDepSlnASId();
        pSDepSlnASItemBase.resetPSDepSlnASItemId();
        pSDepSlnASItemBase.resetPSDepSlnASItemName();
        pSDepSlnASItemBase.resetPSDepSlnASName();
        pSDepSlnASItemBase.resetUpdateDate();
        pSDepSlnASItemBase.resetUpdateMan();
        pSDepSlnASItemBase.resetWeight();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBackupModeDirty()) {
            hashMap.put(FIELD_BACKUPMODE, this.getBackupMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFailTimeoutDirty()) {
            hashMap.put(FIELD_FAILTIMEOUT, this.getFailTimeout());
        }
        if (!bl || this.isMaxFailsDirty()) {
            hashMap.put(FIELD_MAXFAILS, this.getMaxFails());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSlnASGroupIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNASGROUPID, this.getPSDepSlnASGroupId());
        }
        if (!bl || this.isPSDepSlnASGroupNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASGROUPNAME, this.getPSDepSlnASGroupName());
        }
        if (!bl || this.isPSDepSlnASIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNASID, this.getPSDepSlnASId());
        }
        if (!bl || this.isPSDepSlnASItemIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNASITEMID, this.getPSDepSlnASItemId());
        }
        if (!bl || this.isPSDepSlnASItemNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASITEMNAME, this.getPSDepSlnASItemName());
        }
        if (!bl || this.isPSDepSlnASNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASNAME, this.getPSDepSlnASName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWeightDirty()) {
            hashMap.put(FIELD_WEIGHT, this.getWeight());
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
        return PSDepSlnASItemBase.get(this, n);
    }

    private static Object get(PSDepSlnASItemBase pSDepSlnASItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASItemBase.getBackupMode();
            }
            case 1: {
                return pSDepSlnASItemBase.getCreateDate();
            }
            case 2: {
                return pSDepSlnASItemBase.getCreateMan();
            }
            case 3: {
                return pSDepSlnASItemBase.getFailTimeout();
            }
            case 4: {
                return pSDepSlnASItemBase.getMaxFails();
            }
            case 5: {
                return pSDepSlnASItemBase.getMemo();
            }
            case 6: {
                return pSDepSlnASItemBase.getPSDepSlnASGroupId();
            }
            case 7: {
                return pSDepSlnASItemBase.getPSDepSlnASGroupName();
            }
            case 8: {
                return pSDepSlnASItemBase.getPSDepSlnASId();
            }
            case 9: {
                return pSDepSlnASItemBase.getPSDepSlnASItemId();
            }
            case 10: {
                return pSDepSlnASItemBase.getPSDepSlnASItemName();
            }
            case 11: {
                return pSDepSlnASItemBase.getPSDepSlnASName();
            }
            case 12: {
                return pSDepSlnASItemBase.getUpdateDate();
            }
            case 13: {
                return pSDepSlnASItemBase.getUpdateMan();
            }
            case 14: {
                return pSDepSlnASItemBase.getWeight();
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
        PSDepSlnASItemBase.set(this, n, object);
    }

    private static void set(PSDepSlnASItemBase pSDepSlnASItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnASItemBase.setBackupMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnASItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnASItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnASItemBase.setFailTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnASItemBase.setMaxFails(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnASItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnASItemBase.setPSDepSlnASGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnASItemBase.setPSDepSlnASGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnASItemBase.setPSDepSlnASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnASItemBase.setPSDepSlnASItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnASItemBase.setPSDepSlnASItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnASItemBase.setPSDepSlnASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnASItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnASItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnASItemBase.setWeight(DataObject.getIntegerValue((Object)object));
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
        return PSDepSlnASItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnASItemBase pSDepSlnASItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASItemBase.getBackupMode() == null;
            }
            case 1: {
                return pSDepSlnASItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSDepSlnASItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSDepSlnASItemBase.getFailTimeout() == null;
            }
            case 4: {
                return pSDepSlnASItemBase.getMaxFails() == null;
            }
            case 5: {
                return pSDepSlnASItemBase.getMemo() == null;
            }
            case 6: {
                return pSDepSlnASItemBase.getPSDepSlnASGroupId() == null;
            }
            case 7: {
                return pSDepSlnASItemBase.getPSDepSlnASGroupName() == null;
            }
            case 8: {
                return pSDepSlnASItemBase.getPSDepSlnASId() == null;
            }
            case 9: {
                return pSDepSlnASItemBase.getPSDepSlnASItemId() == null;
            }
            case 10: {
                return pSDepSlnASItemBase.getPSDepSlnASItemName() == null;
            }
            case 11: {
                return pSDepSlnASItemBase.getPSDepSlnASName() == null;
            }
            case 12: {
                return pSDepSlnASItemBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDepSlnASItemBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDepSlnASItemBase.getWeight() == null;
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
        return PSDepSlnASItemBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnASItemBase pSDepSlnASItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASItemBase.isBackupModeDirty();
            }
            case 1: {
                return pSDepSlnASItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSDepSlnASItemBase.isCreateManDirty();
            }
            case 3: {
                return pSDepSlnASItemBase.isFailTimeoutDirty();
            }
            case 4: {
                return pSDepSlnASItemBase.isMaxFailsDirty();
            }
            case 5: {
                return pSDepSlnASItemBase.isMemoDirty();
            }
            case 6: {
                return pSDepSlnASItemBase.isPSDepSlnASGroupIdDirty();
            }
            case 7: {
                return pSDepSlnASItemBase.isPSDepSlnASGroupNameDirty();
            }
            case 8: {
                return pSDepSlnASItemBase.isPSDepSlnASIdDirty();
            }
            case 9: {
                return pSDepSlnASItemBase.isPSDepSlnASItemIdDirty();
            }
            case 10: {
                return pSDepSlnASItemBase.isPSDepSlnASItemNameDirty();
            }
            case 11: {
                return pSDepSlnASItemBase.isPSDepSlnASNameDirty();
            }
            case 12: {
                return pSDepSlnASItemBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDepSlnASItemBase.isUpdateManDirty();
            }
            case 14: {
                return pSDepSlnASItemBase.isWeightDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnASItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnASItemBase pSDepSlnASItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnASItemBase.getBackupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupmode", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getBackupMode()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getFailTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"failtimeout", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getFailTimeout()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getMaxFails() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxfails", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getMaxFails()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasgrpid", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getPSDepSlnASGroupId()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasgrpname", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getPSDepSlnASGroupName()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasid", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getPSDepSlnASId()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasitemid", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getPSDepSlnASItemId()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasitemname", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getPSDepSlnASItemName()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasname", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getPSDepSlnASName()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnASItemBase.getWeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"weight", (Object)PSDepSlnASItemBase.getJSONValue((Object)pSDepSlnASItemBase.getWeight()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnASItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnASItemBase pSDepSlnASItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnASItemBase.getBackupMode() != null) {
            object = pSDepSlnASItemBase.getBackupMode();
            xmlNode.setAttribute(FIELD_BACKUPMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASItemBase.getCreateDate() != null) {
            object = pSDepSlnASItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnASItemBase.getCreateMan() != null) {
            object = pSDepSlnASItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getFailTimeout() != null) {
            object = pSDepSlnASItemBase.getFailTimeout();
            xmlNode.setAttribute(FIELD_FAILTIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASItemBase.getMaxFails() != null) {
            object = pSDepSlnASItemBase.getMaxFails();
            xmlNode.setAttribute(FIELD_MAXFAILS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASItemBase.getMemo() != null) {
            object = pSDepSlnASItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASGroupId() != null) {
            object = pSDepSlnASItemBase.getPSDepSlnASGroupId();
            xmlNode.setAttribute("PSDEPSLNASGROUPID", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASGroupName() != null) {
            object = pSDepSlnASItemBase.getPSDepSlnASGroupName();
            xmlNode.setAttribute("PSDEPSLNASGROUPNAME", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASId() != null) {
            object = pSDepSlnASItemBase.getPSDepSlnASId();
            xmlNode.setAttribute(FIELD_PSDEPSLNASID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASItemId() != null) {
            object = pSDepSlnASItemBase.getPSDepSlnASItemId();
            xmlNode.setAttribute(FIELD_PSDEPSLNASITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASItemName() != null) {
            object = pSDepSlnASItemBase.getPSDepSlnASItemName();
            xmlNode.setAttribute(FIELD_PSDEPSLNASITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getPSDepSlnASName() != null) {
            object = pSDepSlnASItemBase.getPSDepSlnASName();
            xmlNode.setAttribute(FIELD_PSDEPSLNASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getUpdateDate() != null) {
            object = pSDepSlnASItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnASItemBase.getUpdateMan() != null) {
            object = pSDepSlnASItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASItemBase.getWeight() != null) {
            object = pSDepSlnASItemBase.getWeight();
            xmlNode.setAttribute(FIELD_WEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnASItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnASItemBase pSDepSlnASItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnASItemBase.isBackupModeDirty() && (bl || pSDepSlnASItemBase.getBackupMode() != null)) {
            iDataObject.set(FIELD_BACKUPMODE, (Object)pSDepSlnASItemBase.getBackupMode());
        }
        if (pSDepSlnASItemBase.isCreateDateDirty() && (bl || pSDepSlnASItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnASItemBase.getCreateDate());
        }
        if (pSDepSlnASItemBase.isCreateManDirty() && (bl || pSDepSlnASItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnASItemBase.getCreateMan());
        }
        if (pSDepSlnASItemBase.isFailTimeoutDirty() && (bl || pSDepSlnASItemBase.getFailTimeout() != null)) {
            iDataObject.set(FIELD_FAILTIMEOUT, (Object)pSDepSlnASItemBase.getFailTimeout());
        }
        if (pSDepSlnASItemBase.isMaxFailsDirty() && (bl || pSDepSlnASItemBase.getMaxFails() != null)) {
            iDataObject.set(FIELD_MAXFAILS, (Object)pSDepSlnASItemBase.getMaxFails());
        }
        if (pSDepSlnASItemBase.isMemoDirty() && (bl || pSDepSlnASItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnASItemBase.getMemo());
        }
        if (pSDepSlnASItemBase.isPSDepSlnASGroupIdDirty() && (bl || pSDepSlnASItemBase.getPSDepSlnASGroupId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASGROUPID, (Object)pSDepSlnASItemBase.getPSDepSlnASGroupId());
        }
        if (pSDepSlnASItemBase.isPSDepSlnASGroupNameDirty() && (bl || pSDepSlnASItemBase.getPSDepSlnASGroupName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASGROUPNAME, (Object)pSDepSlnASItemBase.getPSDepSlnASGroupName());
        }
        if (pSDepSlnASItemBase.isPSDepSlnASIdDirty() && (bl || pSDepSlnASItemBase.getPSDepSlnASId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASID, (Object)pSDepSlnASItemBase.getPSDepSlnASId());
        }
        if (pSDepSlnASItemBase.isPSDepSlnASItemIdDirty() && (bl || pSDepSlnASItemBase.getPSDepSlnASItemId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASITEMID, (Object)pSDepSlnASItemBase.getPSDepSlnASItemId());
        }
        if (pSDepSlnASItemBase.isPSDepSlnASItemNameDirty() && (bl || pSDepSlnASItemBase.getPSDepSlnASItemName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASITEMNAME, (Object)pSDepSlnASItemBase.getPSDepSlnASItemName());
        }
        if (pSDepSlnASItemBase.isPSDepSlnASNameDirty() && (bl || pSDepSlnASItemBase.getPSDepSlnASName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASNAME, (Object)pSDepSlnASItemBase.getPSDepSlnASName());
        }
        if (pSDepSlnASItemBase.isUpdateDateDirty() && (bl || pSDepSlnASItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnASItemBase.getUpdateDate());
        }
        if (pSDepSlnASItemBase.isUpdateManDirty() && (bl || pSDepSlnASItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnASItemBase.getUpdateMan());
        }
        if (pSDepSlnASItemBase.isWeightDirty() && (bl || pSDepSlnASItemBase.getWeight() != null)) {
            iDataObject.set(FIELD_WEIGHT, (Object)pSDepSlnASItemBase.getWeight());
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
        return PSDepSlnASItemBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnASItemBase pSDepSlnASItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnASItemBase.resetBackupMode();
                return true;
            }
            case 1: {
                pSDepSlnASItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDepSlnASItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDepSlnASItemBase.resetFailTimeout();
                return true;
            }
            case 4: {
                pSDepSlnASItemBase.resetMaxFails();
                return true;
            }
            case 5: {
                pSDepSlnASItemBase.resetMemo();
                return true;
            }
            case 6: {
                pSDepSlnASItemBase.resetPSDepSlnASGroupId();
                return true;
            }
            case 7: {
                pSDepSlnASItemBase.resetPSDepSlnASGroupName();
                return true;
            }
            case 8: {
                pSDepSlnASItemBase.resetPSDepSlnASId();
                return true;
            }
            case 9: {
                pSDepSlnASItemBase.resetPSDepSlnASItemId();
                return true;
            }
            case 10: {
                pSDepSlnASItemBase.resetPSDepSlnASItemName();
                return true;
            }
            case 11: {
                pSDepSlnASItemBase.resetPSDepSlnASName();
                return true;
            }
            case 12: {
                pSDepSlnASItemBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDepSlnASItemBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDepSlnASItemBase.resetWeight();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnASGroup getPSDepSlnASGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGroup();
        }
        if (this.getPSDepSlnASGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnASGroupLock;
        synchronized (n) {
            if (this.psdepslnasgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnASGroupId(), (Object)this.psdepslnasgroup.getPSDepSlnASGroupId()) != 0L) {
                this.psdepslnasgroup = null;
            }
            if (this.psdepslnasgroup == null) {
                PSDepSlnASGroup pSDepSlnASGroup = new PSDepSlnASGroup();
                pSDepSlnASGroup.setPSDepSlnASGroupId(this.getPSDepSlnASGroupId());
                PSDepSlnASGroupService pSDepSlnASGroupService = (PSDepSlnASGroupService)ServiceGlobal.getService(PSDepSlnASGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnASGroupService.autoGet(pSDepSlnASGroup);
                this.psdepslnasgroup = pSDepSlnASGroup;
            }
            return this.psdepslnasgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnAS getPSDepSlnAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnAS();
        }
        if (this.getPSDepSlnASId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnASLock;
        synchronized (n) {
            if (this.psdepslnas != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnASId(), (Object)this.psdepslnas.getPSDepSlnASId()) != 0L) {
                this.psdepslnas = null;
            }
            if (this.psdepslnas == null) {
                PSDepSlnAS pSDepSlnAS = new PSDepSlnAS();
                pSDepSlnAS.setPSDepSlnASId(this.getPSDepSlnASId());
                PSDepSlnASService pSDepSlnASService = (PSDepSlnASService)ServiceGlobal.getService(PSDepSlnASService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnASService.autoGet(pSDepSlnAS);
                this.psdepslnas = pSDepSlnAS;
            }
            return this.psdepslnas;
        }
    }

    private PSDepSlnASItemBase getProxyEntity() {
        return this.proxyPSDepSlnASItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnASItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnASItemBase) {
            this.proxyPSDepSlnASItemBase = (PSDepSlnASItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BACKUPMODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FAILTIMEOUT, 3);
        fieldIndexMap.put(FIELD_MAXFAILS, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNASGROUPID, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNASGROUPNAME, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNASID, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNASITEMID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNASITEMNAME, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNASNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_WEIGHT, 14);
    }
}

