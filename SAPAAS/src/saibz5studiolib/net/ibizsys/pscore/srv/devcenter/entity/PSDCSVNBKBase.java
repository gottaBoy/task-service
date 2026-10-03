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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSVNBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSVNBKService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSVNBKBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSVNBKBase.class);
    public static final String FIELD_BACKUPSIZE = "BACKUPSIZE";
    public static final String FIELD_BACKUPMODE = "BKMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSDCSVNBKID = "PPSDCSVNBKID";
    public static final String FIELD_PPSDCSVNBKNAME = "PPSDCSVNBKNAME";
    public static final String FIELD_PSDCSVNBKID = "PSDCSVNBKID";
    public static final String FIELD_PSDCSVNBKNAME = "PSDCSVNBKNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BACKUPSIZE = 0;
    private static final int INDEX_BACKUPMODE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PPSDCSVNBKID = 5;
    private static final int INDEX_PPSDCSVNBKNAME = 6;
    private static final int INDEX_PSDCSVNBKID = 7;
    private static final int INDEX_PSDCSVNBKNAME = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_PSDEVCENTERSVNID = 11;
    private static final int INDEX_PSDEVCENTERSVNNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSVNBKBase proxyPSDCSVNBKBase = null;
    private boolean backupsizeDirtyFlag = false;
    private boolean backupmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsdcsvnbkidDirtyFlag = false;
    private boolean ppsdcsvnbknameDirtyFlag = false;
    private boolean psdcsvnbkidDirtyFlag = false;
    private boolean psdcsvnbknameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="backupsize")
    private Integer backupsize;
    @Column(name="backupmode")
    private Integer backupmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsdcsvnbkid")
    private String ppsdcsvnbkid;
    @Column(name="ppsdcsvnbkname")
    private String ppsdcsvnbkname;
    @Column(name="psdcsvnbkid")
    private String psdcsvnbkid;
    @Column(name="psdcsvnbkname")
    private String psdcsvnbkname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSDCSVNBKLock = new Integer(1);
    private PSDCSVNBK ppsdcsvnbk = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDCSVNBKsLock = new Integer(1);
    private ArrayList<PSDCSVNBK> psdcsvnbks = null;

    public void setBackupSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupSize(n);
            return;
        }
        this.backupsize = n;
        this.backupsizeDirtyFlag = true;
    }

    public Integer getBackupSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupSize();
        }
        return this.backupsize;
    }

    public boolean isBackupSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupSizeDirty();
        }
        return this.backupsizeDirtyFlag;
    }

    public void resetBackupSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupSize();
            return;
        }
        this.backupsizeDirtyFlag = false;
        this.backupsize = null;
    }

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

    public void setPPSDCSVNBKId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDCSVNBKId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdcsvnbkid = string;
        this.ppsdcsvnbkidDirtyFlag = true;
    }

    public String getPPSDCSVNBKId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDCSVNBKId();
        }
        return this.ppsdcsvnbkid;
    }

    public boolean isPPSDCSVNBKIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDCSVNBKIdDirty();
        }
        return this.ppsdcsvnbkidDirtyFlag;
    }

    public void resetPPSDCSVNBKId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDCSVNBKId();
            return;
        }
        this.ppsdcsvnbkidDirtyFlag = false;
        this.ppsdcsvnbkid = null;
    }

    public void setPPSDCSVNBKName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDCSVNBKName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdcsvnbkname = string;
        this.ppsdcsvnbknameDirtyFlag = true;
    }

    public String getPPSDCSVNBKName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDCSVNBKName();
        }
        return this.ppsdcsvnbkname;
    }

    public boolean isPPSDCSVNBKNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDCSVNBKNameDirty();
        }
        return this.ppsdcsvnbknameDirtyFlag;
    }

    public void resetPPSDCSVNBKName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDCSVNBKName();
            return;
        }
        this.ppsdcsvnbknameDirtyFlag = false;
        this.ppsdcsvnbkname = null;
    }

    public void setPSDCSVNBKId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSVNBKId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsvnbkid = string;
        this.psdcsvnbkidDirtyFlag = true;
    }

    public String getPSDCSVNBKId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSVNBKId();
        }
        return this.psdcsvnbkid;
    }

    public boolean isPSDCSVNBKIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSVNBKIdDirty();
        }
        return this.psdcsvnbkidDirtyFlag;
    }

    public void resetPSDCSVNBKId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSVNBKId();
            return;
        }
        this.psdcsvnbkidDirtyFlag = false;
        this.psdcsvnbkid = null;
    }

    public void setPSDCSVNBKName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSVNBKName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsvnbkname = string;
        this.psdcsvnbknameDirtyFlag = true;
    }

    public String getPSDCSVNBKName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSVNBKName();
        }
        return this.psdcsvnbkname;
    }

    public boolean isPSDCSVNBKNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSVNBKNameDirty();
        }
        return this.psdcsvnbknameDirtyFlag;
    }

    public void resetPSDCSVNBKName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSVNBKName();
            return;
        }
        this.psdcsvnbknameDirtyFlag = false;
        this.psdcsvnbkname = null;
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

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
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
        PSDCSVNBKBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSVNBKBase pSDCSVNBKBase) {
        pSDCSVNBKBase.resetBackupSize();
        pSDCSVNBKBase.resetBackupMode();
        pSDCSVNBKBase.resetCreateDate();
        pSDCSVNBKBase.resetCreateMan();
        pSDCSVNBKBase.resetMemo();
        pSDCSVNBKBase.resetPPSDCSVNBKId();
        pSDCSVNBKBase.resetPPSDCSVNBKName();
        pSDCSVNBKBase.resetPSDCSVNBKId();
        pSDCSVNBKBase.resetPSDCSVNBKName();
        pSDCSVNBKBase.resetPSDevCenterId();
        pSDCSVNBKBase.resetPSDevCenterName();
        pSDCSVNBKBase.resetPSDevCenterSVNId();
        pSDCSVNBKBase.resetPSDevCenterSVNName();
        pSDCSVNBKBase.resetUpdateDate();
        pSDCSVNBKBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBackupSizeDirty()) {
            hashMap.put(FIELD_BACKUPSIZE, this.getBackupSize());
        }
        if (!bl || this.isBackupModeDirty()) {
            hashMap.put(FIELD_BACKUPMODE, this.getBackupMode());
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
        if (!bl || this.isPPSDCSVNBKIdDirty()) {
            hashMap.put(FIELD_PPSDCSVNBKID, this.getPPSDCSVNBKId());
        }
        if (!bl || this.isPPSDCSVNBKNameDirty()) {
            hashMap.put(FIELD_PPSDCSVNBKNAME, this.getPPSDCSVNBKName());
        }
        if (!bl || this.isPSDCSVNBKIdDirty()) {
            hashMap.put(FIELD_PSDCSVNBKID, this.getPSDCSVNBKId());
        }
        if (!bl || this.isPSDCSVNBKNameDirty()) {
            hashMap.put(FIELD_PSDCSVNBKNAME, this.getPSDCSVNBKName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
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
        return PSDCSVNBKBase.get(this, n);
    }

    private static Object get(PSDCSVNBKBase pSDCSVNBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSVNBKBase.getBackupSize();
            }
            case 1: {
                return pSDCSVNBKBase.getBackupMode();
            }
            case 2: {
                return pSDCSVNBKBase.getCreateDate();
            }
            case 3: {
                return pSDCSVNBKBase.getCreateMan();
            }
            case 4: {
                return pSDCSVNBKBase.getMemo();
            }
            case 5: {
                return pSDCSVNBKBase.getPPSDCSVNBKId();
            }
            case 6: {
                return pSDCSVNBKBase.getPPSDCSVNBKName();
            }
            case 7: {
                return pSDCSVNBKBase.getPSDCSVNBKId();
            }
            case 8: {
                return pSDCSVNBKBase.getPSDCSVNBKName();
            }
            case 9: {
                return pSDCSVNBKBase.getPSDevCenterId();
            }
            case 10: {
                return pSDCSVNBKBase.getPSDevCenterName();
            }
            case 11: {
                return pSDCSVNBKBase.getPSDevCenterSVNId();
            }
            case 12: {
                return pSDCSVNBKBase.getPSDevCenterSVNName();
            }
            case 13: {
                return pSDCSVNBKBase.getUpdateDate();
            }
            case 14: {
                return pSDCSVNBKBase.getUpdateMan();
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
        PSDCSVNBKBase.set(this, n, object);
    }

    private static void set(PSDCSVNBKBase pSDCSVNBKBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSVNBKBase.setBackupSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDCSVNBKBase.setBackupMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDCSVNBKBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCSVNBKBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSVNBKBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSVNBKBase.setPPSDCSVNBKId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSVNBKBase.setPPSDCSVNBKName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSVNBKBase.setPSDCSVNBKId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSVNBKBase.setPSDCSVNBKName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSVNBKBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSVNBKBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSVNBKBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCSVNBKBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCSVNBKBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDCSVNBKBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCSVNBKBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSVNBKBase pSDCSVNBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSVNBKBase.getBackupSize() == null;
            }
            case 1: {
                return pSDCSVNBKBase.getBackupMode() == null;
            }
            case 2: {
                return pSDCSVNBKBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCSVNBKBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCSVNBKBase.getMemo() == null;
            }
            case 5: {
                return pSDCSVNBKBase.getPPSDCSVNBKId() == null;
            }
            case 6: {
                return pSDCSVNBKBase.getPPSDCSVNBKName() == null;
            }
            case 7: {
                return pSDCSVNBKBase.getPSDCSVNBKId() == null;
            }
            case 8: {
                return pSDCSVNBKBase.getPSDCSVNBKName() == null;
            }
            case 9: {
                return pSDCSVNBKBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSDCSVNBKBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDCSVNBKBase.getPSDevCenterSVNId() == null;
            }
            case 12: {
                return pSDCSVNBKBase.getPSDevCenterSVNName() == null;
            }
            case 13: {
                return pSDCSVNBKBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDCSVNBKBase.getUpdateMan() == null;
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
        return PSDCSVNBKBase.contains(this, n);
    }

    private static boolean contains(PSDCSVNBKBase pSDCSVNBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSVNBKBase.isBackupSizeDirty();
            }
            case 1: {
                return pSDCSVNBKBase.isBackupModeDirty();
            }
            case 2: {
                return pSDCSVNBKBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCSVNBKBase.isCreateManDirty();
            }
            case 4: {
                return pSDCSVNBKBase.isMemoDirty();
            }
            case 5: {
                return pSDCSVNBKBase.isPPSDCSVNBKIdDirty();
            }
            case 6: {
                return pSDCSVNBKBase.isPPSDCSVNBKNameDirty();
            }
            case 7: {
                return pSDCSVNBKBase.isPSDCSVNBKIdDirty();
            }
            case 8: {
                return pSDCSVNBKBase.isPSDCSVNBKNameDirty();
            }
            case 9: {
                return pSDCSVNBKBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSDCSVNBKBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDCSVNBKBase.isPSDevCenterSVNIdDirty();
            }
            case 12: {
                return pSDCSVNBKBase.isPSDevCenterSVNNameDirty();
            }
            case 13: {
                return pSDCSVNBKBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDCSVNBKBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSVNBKBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSVNBKBase pSDCSVNBKBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSVNBKBase.getBackupSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupsize", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getBackupSize()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getBackupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkmode", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getBackupMode()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getPPSDCSVNBKId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdcsvnbkid", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getPPSDCSVNBKId()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getPPSDCSVNBKName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdcsvnbkname", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getPPSDCSVNBKName()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getPSDCSVNBKId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsvnbkid", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getPSDCSVNBKId()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getPSDCSVNBKName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsvnbkname", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getPSDCSVNBKName()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSVNBKBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSVNBKBase.getJSONValue((Object)pSDCSVNBKBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSVNBKBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSVNBKBase pSDCSVNBKBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSVNBKBase.getBackupSize() != null) {
            object = pSDCSVNBKBase.getBackupSize();
            xmlNode.setAttribute(FIELD_BACKUPSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSVNBKBase.getBackupMode() != null) {
            object = pSDCSVNBKBase.getBackupMode();
            xmlNode.setAttribute("BACKUPMODE", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSVNBKBase.getCreateDate() != null) {
            object = pSDCSVNBKBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSVNBKBase.getCreateMan() != null) {
            object = pSDCSVNBKBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getMemo() != null) {
            object = pSDCSVNBKBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getPPSDCSVNBKId() != null) {
            object = pSDCSVNBKBase.getPPSDCSVNBKId();
            xmlNode.setAttribute(FIELD_PPSDCSVNBKID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getPPSDCSVNBKName() != null) {
            object = pSDCSVNBKBase.getPPSDCSVNBKName();
            xmlNode.setAttribute(FIELD_PPSDCSVNBKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getPSDCSVNBKId() != null) {
            object = pSDCSVNBKBase.getPSDCSVNBKId();
            xmlNode.setAttribute(FIELD_PSDCSVNBKID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getPSDCSVNBKName() != null) {
            object = pSDCSVNBKBase.getPSDCSVNBKName();
            xmlNode.setAttribute(FIELD_PSDCSVNBKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getPSDevCenterId() != null) {
            object = pSDCSVNBKBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getPSDevCenterName() != null) {
            object = pSDCSVNBKBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getPSDevCenterSVNId() != null) {
            object = pSDCSVNBKBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getPSDevCenterSVNName() != null) {
            object = pSDCSVNBKBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSVNBKBase.getUpdateDate() != null) {
            object = pSDCSVNBKBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSVNBKBase.getUpdateMan() != null) {
            object = pSDCSVNBKBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSVNBKBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSVNBKBase pSDCSVNBKBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSVNBKBase.isBackupSizeDirty() && (bl || pSDCSVNBKBase.getBackupSize() != null)) {
            iDataObject.set(FIELD_BACKUPSIZE, (Object)pSDCSVNBKBase.getBackupSize());
        }
        if (pSDCSVNBKBase.isBackupModeDirty() && (bl || pSDCSVNBKBase.getBackupMode() != null)) {
            iDataObject.set(FIELD_BACKUPMODE, (Object)pSDCSVNBKBase.getBackupMode());
        }
        if (pSDCSVNBKBase.isCreateDateDirty() && (bl || pSDCSVNBKBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSVNBKBase.getCreateDate());
        }
        if (pSDCSVNBKBase.isCreateManDirty() && (bl || pSDCSVNBKBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSVNBKBase.getCreateMan());
        }
        if (pSDCSVNBKBase.isMemoDirty() && (bl || pSDCSVNBKBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSVNBKBase.getMemo());
        }
        if (pSDCSVNBKBase.isPPSDCSVNBKIdDirty() && (bl || pSDCSVNBKBase.getPPSDCSVNBKId() != null)) {
            iDataObject.set(FIELD_PPSDCSVNBKID, (Object)pSDCSVNBKBase.getPPSDCSVNBKId());
        }
        if (pSDCSVNBKBase.isPPSDCSVNBKNameDirty() && (bl || pSDCSVNBKBase.getPPSDCSVNBKName() != null)) {
            iDataObject.set(FIELD_PPSDCSVNBKNAME, (Object)pSDCSVNBKBase.getPPSDCSVNBKName());
        }
        if (pSDCSVNBKBase.isPSDCSVNBKIdDirty() && (bl || pSDCSVNBKBase.getPSDCSVNBKId() != null)) {
            iDataObject.set(FIELD_PSDCSVNBKID, (Object)pSDCSVNBKBase.getPSDCSVNBKId());
        }
        if (pSDCSVNBKBase.isPSDCSVNBKNameDirty() && (bl || pSDCSVNBKBase.getPSDCSVNBKName() != null)) {
            iDataObject.set(FIELD_PSDCSVNBKNAME, (Object)pSDCSVNBKBase.getPSDCSVNBKName());
        }
        if (pSDCSVNBKBase.isPSDevCenterIdDirty() && (bl || pSDCSVNBKBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSVNBKBase.getPSDevCenterId());
        }
        if (pSDCSVNBKBase.isPSDevCenterNameDirty() && (bl || pSDCSVNBKBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSVNBKBase.getPSDevCenterName());
        }
        if (pSDCSVNBKBase.isPSDevCenterSVNIdDirty() && (bl || pSDCSVNBKBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDCSVNBKBase.getPSDevCenterSVNId());
        }
        if (pSDCSVNBKBase.isPSDevCenterSVNNameDirty() && (bl || pSDCSVNBKBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDCSVNBKBase.getPSDevCenterSVNName());
        }
        if (pSDCSVNBKBase.isUpdateDateDirty() && (bl || pSDCSVNBKBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSVNBKBase.getUpdateDate());
        }
        if (pSDCSVNBKBase.isUpdateManDirty() && (bl || pSDCSVNBKBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSVNBKBase.getUpdateMan());
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
        return PSDCSVNBKBase.remove(this, n);
    }

    private static boolean remove(PSDCSVNBKBase pSDCSVNBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSVNBKBase.resetBackupSize();
                return true;
            }
            case 1: {
                pSDCSVNBKBase.resetBackupMode();
                return true;
            }
            case 2: {
                pSDCSVNBKBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCSVNBKBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCSVNBKBase.resetMemo();
                return true;
            }
            case 5: {
                pSDCSVNBKBase.resetPPSDCSVNBKId();
                return true;
            }
            case 6: {
                pSDCSVNBKBase.resetPPSDCSVNBKName();
                return true;
            }
            case 7: {
                pSDCSVNBKBase.resetPSDCSVNBKId();
                return true;
            }
            case 8: {
                pSDCSVNBKBase.resetPSDCSVNBKName();
                return true;
            }
            case 9: {
                pSDCSVNBKBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSDCSVNBKBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDCSVNBKBase.resetPSDevCenterSVNId();
                return true;
            }
            case 12: {
                pSDCSVNBKBase.resetPSDevCenterSVNName();
                return true;
            }
            case 13: {
                pSDCSVNBKBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDCSVNBKBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCSVNBK getPPSDCSVNBK() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDCSVNBK();
        }
        if (this.getPPSDCSVNBKId() == null) {
            return null;
        }
        Integer n = this.objPPSDCSVNBKLock;
        synchronized (n) {
            if (this.ppsdcsvnbk != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDCSVNBKId(), (Object)this.ppsdcsvnbk.getPSDCSVNBKId()) != 0L) {
                this.ppsdcsvnbk = null;
            }
            if (this.ppsdcsvnbk == null) {
                PSDCSVNBK pSDCSVNBK = new PSDCSVNBK();
                pSDCSVNBK.setPSDCSVNBKId(this.getPPSDCSVNBKId());
                PSDCSVNBKService pSDCSVNBKService = (PSDCSVNBKService)ServiceGlobal.getService(PSDCSVNBKService.class, (SessionFactory)this.getSessionFactory());
                pSDCSVNBKService.autoGet(pSDCSVNBK);
                this.ppsdcsvnbk = pSDCSVNBK;
            }
            return this.ppsdcsvnbk;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVN();
        }
        if (this.getPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterSVNLock;
        synchronized (n) {
            if (this.psdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterSVNId(), (Object)this.psdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.psdevcentersvn = null;
            }
            if (this.psdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.psdevcentersvn = pSDevCenterSVN;
            }
            return this.psdevcentersvn;
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
    public ArrayList<PSDCSVNBK> getPSDCSVNBKs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSVNBKs();
        }
        if (this.getPSDCSVNBKId() == null) {
            return null;
        }
        PSDCSVNBKService pSDCSVNBKService = (PSDCSVNBKService)ServiceGlobal.getService(PSDCSVNBKService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCSVNBKsLock;
        synchronized (n) {
            if (this.psdcsvnbks == null) {
                this.psdcsvnbks = pSDCSVNBKService.selectByPPSDCSVNBK(this);
            }
            return this.psdcsvnbks;
        }
    }

    private PSDCSVNBKBase getProxyEntity() {
        return this.proxyPSDCSVNBKBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSVNBKBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSVNBKBase) {
            this.proxyPSDCSVNBKBase = (PSDCSVNBKBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSVNBKService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BACKUPSIZE, 0);
        fieldIndexMap.put(FIELD_BACKUPMODE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PPSDCSVNBKID, 5);
        fieldIndexMap.put(FIELD_PPSDCSVNBKNAME, 6);
        fieldIndexMap.put(FIELD_PSDCSVNBKID, 7);
        fieldIndexMap.put(FIELD_PSDCSVNBKNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

