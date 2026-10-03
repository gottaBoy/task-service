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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBDInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysBDBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysBDBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNBDINSTID = "PSDEPSLNBDINSTID";
    public static final String FIELD_PSDEPSLNBDINSTNAME = "PSDEPSLNBDINSTNAME";
    public static final String FIELD_PSDEPSLNSYSBDID = "PSDEPSLNSYSBDID";
    public static final String FIELD_PSDEPSLNSYSBDNAME = "PSDEPSLNSYSBDNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSLNBDINSTID = 3;
    private static final int INDEX_PSDEPSLNBDINSTNAME = 4;
    private static final int INDEX_PSDEPSLNSYSBDID = 5;
    private static final int INDEX_PSDEPSLNSYSBDNAME = 6;
    private static final int INDEX_PSDEPSLNSYSID = 7;
    private static final int INDEX_PSDEPSLNSYSNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysBDBase proxyPSDepSlnSysBDBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnbdinstidDirtyFlag = false;
    private boolean psdepslnbdinstnameDirtyFlag = false;
    private boolean psdepslnsysbdidDirtyFlag = false;
    private boolean psdepslnsysbdnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnbdinstid")
    private String psdepslnbdinstid;
    @Column(name="psdepslnbdinstname")
    private String psdepslnbdinstname;
    @Column(name="psdepslnsysbdid")
    private String psdepslnsysbdid;
    @Column(name="psdepslnsysbdname")
    private String psdepslnsysbdname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnBDInstLock = new Integer(1);
    private PSDepSlnBDInst psdepslnbdinst = null;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;

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

    public void setPSDepSlnBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnbdinstid = string;
        this.psdepslnbdinstidDirtyFlag = true;
    }

    public String getPSDepSlnBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnBDInstId();
        }
        return this.psdepslnbdinstid;
    }

    public boolean isPSDepSlnBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnBDInstIdDirty();
        }
        return this.psdepslnbdinstidDirtyFlag;
    }

    public void resetPSDepSlnBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnBDInstId();
            return;
        }
        this.psdepslnbdinstidDirtyFlag = false;
        this.psdepslnbdinstid = null;
    }

    public void setPSDepSlnBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnbdinstname = string;
        this.psdepslnbdinstnameDirtyFlag = true;
    }

    public String getPSDepSlnBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnBDInstName();
        }
        return this.psdepslnbdinstname;
    }

    public boolean isPSDepSlnBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnBDInstNameDirty();
        }
        return this.psdepslnbdinstnameDirtyFlag;
    }

    public void resetPSDepSlnBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnBDInstName();
            return;
        }
        this.psdepslnbdinstnameDirtyFlag = false;
        this.psdepslnbdinstname = null;
    }

    public void setPSDepSlnSysBDId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysBDId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysbdid = string;
        this.psdepslnsysbdidDirtyFlag = true;
    }

    public String getPSDepSlnSysBDId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysBDId();
        }
        return this.psdepslnsysbdid;
    }

    public boolean isPSDepSlnSysBDIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysBDIdDirty();
        }
        return this.psdepslnsysbdidDirtyFlag;
    }

    public void resetPSDepSlnSysBDId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysBDId();
            return;
        }
        this.psdepslnsysbdidDirtyFlag = false;
        this.psdepslnsysbdid = null;
    }

    public void setPSDepSlnSysBDName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysBDName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysbdname = string;
        this.psdepslnsysbdnameDirtyFlag = true;
    }

    public String getPSDepSlnSysBDName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysBDName();
        }
        return this.psdepslnsysbdname;
    }

    public boolean isPSDepSlnSysBDNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysBDNameDirty();
        }
        return this.psdepslnsysbdnameDirtyFlag;
    }

    public void resetPSDepSlnSysBDName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysBDName();
            return;
        }
        this.psdepslnsysbdnameDirtyFlag = false;
        this.psdepslnsysbdname = null;
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
        PSDepSlnSysBDBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysBDBase pSDepSlnSysBDBase) {
        pSDepSlnSysBDBase.resetCreateDate();
        pSDepSlnSysBDBase.resetCreateMan();
        pSDepSlnSysBDBase.resetMemo();
        pSDepSlnSysBDBase.resetPSDepSlnBDInstId();
        pSDepSlnSysBDBase.resetPSDepSlnBDInstName();
        pSDepSlnSysBDBase.resetPSDepSlnSysBDId();
        pSDepSlnSysBDBase.resetPSDepSlnSysBDName();
        pSDepSlnSysBDBase.resetPSDepSlnSysId();
        pSDepSlnSysBDBase.resetPSDepSlnSysName();
        pSDepSlnSysBDBase.resetUpdateDate();
        pSDepSlnSysBDBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSlnBDInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNBDINSTID, this.getPSDepSlnBDInstId());
        }
        if (!bl || this.isPSDepSlnBDInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNBDINSTNAME, this.getPSDepSlnBDInstName());
        }
        if (!bl || this.isPSDepSlnSysBDIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSBDID, this.getPSDepSlnSysBDId());
        }
        if (!bl || this.isPSDepSlnSysBDNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSBDNAME, this.getPSDepSlnSysBDName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
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
        return PSDepSlnSysBDBase.get(this, n);
    }

    private static Object get(PSDepSlnSysBDBase pSDepSlnSysBDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysBDBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnSysBDBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnSysBDBase.getMemo();
            }
            case 3: {
                return pSDepSlnSysBDBase.getPSDepSlnBDInstId();
            }
            case 4: {
                return pSDepSlnSysBDBase.getPSDepSlnBDInstName();
            }
            case 5: {
                return pSDepSlnSysBDBase.getPSDepSlnSysBDId();
            }
            case 6: {
                return pSDepSlnSysBDBase.getPSDepSlnSysBDName();
            }
            case 7: {
                return pSDepSlnSysBDBase.getPSDepSlnSysId();
            }
            case 8: {
                return pSDepSlnSysBDBase.getPSDepSlnSysName();
            }
            case 9: {
                return pSDepSlnSysBDBase.getUpdateDate();
            }
            case 10: {
                return pSDepSlnSysBDBase.getUpdateMan();
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
        PSDepSlnSysBDBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysBDBase pSDepSlnSysBDBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysBDBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysBDBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysBDBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysBDBase.setPSDepSlnBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysBDBase.setPSDepSlnBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysBDBase.setPSDepSlnSysBDId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysBDBase.setPSDepSlnSysBDName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysBDBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysBDBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysBDBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysBDBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysBDBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysBDBase pSDepSlnSysBDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysBDBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnSysBDBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnSysBDBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnSysBDBase.getPSDepSlnBDInstId() == null;
            }
            case 4: {
                return pSDepSlnSysBDBase.getPSDepSlnBDInstName() == null;
            }
            case 5: {
                return pSDepSlnSysBDBase.getPSDepSlnSysBDId() == null;
            }
            case 6: {
                return pSDepSlnSysBDBase.getPSDepSlnSysBDName() == null;
            }
            case 7: {
                return pSDepSlnSysBDBase.getPSDepSlnSysId() == null;
            }
            case 8: {
                return pSDepSlnSysBDBase.getPSDepSlnSysName() == null;
            }
            case 9: {
                return pSDepSlnSysBDBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDepSlnSysBDBase.getUpdateMan() == null;
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
        return PSDepSlnSysBDBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysBDBase pSDepSlnSysBDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysBDBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnSysBDBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnSysBDBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnSysBDBase.isPSDepSlnBDInstIdDirty();
            }
            case 4: {
                return pSDepSlnSysBDBase.isPSDepSlnBDInstNameDirty();
            }
            case 5: {
                return pSDepSlnSysBDBase.isPSDepSlnSysBDIdDirty();
            }
            case 6: {
                return pSDepSlnSysBDBase.isPSDepSlnSysBDNameDirty();
            }
            case 7: {
                return pSDepSlnSysBDBase.isPSDepSlnSysIdDirty();
            }
            case 8: {
                return pSDepSlnSysBDBase.isPSDepSlnSysNameDirty();
            }
            case 9: {
                return pSDepSlnSysBDBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDepSlnSysBDBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysBDBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysBDBase pSDepSlnSysBDBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysBDBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnbdinstid", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getPSDepSlnBDInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnbdinstname", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getPSDepSlnBDInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnSysBDId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysbdid", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getPSDepSlnSysBDId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnSysBDName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysbdname", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getPSDepSlnSysBDName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysBDBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysBDBase.getJSONValue((Object)pSDepSlnSysBDBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysBDBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysBDBase pSDepSlnSysBDBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysBDBase.getCreateDate() != null) {
            object = pSDepSlnSysBDBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysBDBase.getCreateMan() != null) {
            object = pSDepSlnSysBDBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBDBase.getMemo() != null) {
            object = pSDepSlnSysBDBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnBDInstId() != null) {
            object = pSDepSlnSysBDBase.getPSDepSlnBDInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnBDInstName() != null) {
            object = pSDepSlnSysBDBase.getPSDepSlnBDInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnSysBDId() != null) {
            object = pSDepSlnSysBDBase.getPSDepSlnSysBDId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSBDID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnSysBDName() != null) {
            object = pSDepSlnSysBDBase.getPSDepSlnSysBDName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSBDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysBDBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBDBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysBDBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBDBase.getUpdateDate() != null) {
            object = pSDepSlnSysBDBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysBDBase.getUpdateMan() != null) {
            object = pSDepSlnSysBDBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysBDBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysBDBase pSDepSlnSysBDBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysBDBase.isCreateDateDirty() && (bl || pSDepSlnSysBDBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysBDBase.getCreateDate());
        }
        if (pSDepSlnSysBDBase.isCreateManDirty() && (bl || pSDepSlnSysBDBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysBDBase.getCreateMan());
        }
        if (pSDepSlnSysBDBase.isMemoDirty() && (bl || pSDepSlnSysBDBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnSysBDBase.getMemo());
        }
        if (pSDepSlnSysBDBase.isPSDepSlnBDInstIdDirty() && (bl || pSDepSlnSysBDBase.getPSDepSlnBDInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNBDINSTID, (Object)pSDepSlnSysBDBase.getPSDepSlnBDInstId());
        }
        if (pSDepSlnSysBDBase.isPSDepSlnBDInstNameDirty() && (bl || pSDepSlnSysBDBase.getPSDepSlnBDInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNBDINSTNAME, (Object)pSDepSlnSysBDBase.getPSDepSlnBDInstName());
        }
        if (pSDepSlnSysBDBase.isPSDepSlnSysBDIdDirty() && (bl || pSDepSlnSysBDBase.getPSDepSlnSysBDId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSBDID, (Object)pSDepSlnSysBDBase.getPSDepSlnSysBDId());
        }
        if (pSDepSlnSysBDBase.isPSDepSlnSysBDNameDirty() && (bl || pSDepSlnSysBDBase.getPSDepSlnSysBDName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSBDNAME, (Object)pSDepSlnSysBDBase.getPSDepSlnSysBDName());
        }
        if (pSDepSlnSysBDBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysBDBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysBDBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysBDBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysBDBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysBDBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysBDBase.isUpdateDateDirty() && (bl || pSDepSlnSysBDBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysBDBase.getUpdateDate());
        }
        if (pSDepSlnSysBDBase.isUpdateManDirty() && (bl || pSDepSlnSysBDBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysBDBase.getUpdateMan());
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
        return PSDepSlnSysBDBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysBDBase pSDepSlnSysBDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysBDBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnSysBDBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnSysBDBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnSysBDBase.resetPSDepSlnBDInstId();
                return true;
            }
            case 4: {
                pSDepSlnSysBDBase.resetPSDepSlnBDInstName();
                return true;
            }
            case 5: {
                pSDepSlnSysBDBase.resetPSDepSlnSysBDId();
                return true;
            }
            case 6: {
                pSDepSlnSysBDBase.resetPSDepSlnSysBDName();
                return true;
            }
            case 7: {
                pSDepSlnSysBDBase.resetPSDepSlnSysId();
                return true;
            }
            case 8: {
                pSDepSlnSysBDBase.resetPSDepSlnSysName();
                return true;
            }
            case 9: {
                pSDepSlnSysBDBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDepSlnSysBDBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnBDInst getPSDepSlnBDInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnBDInst();
        }
        if (this.getPSDepSlnBDInstId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnBDInstLock;
        synchronized (n) {
            if (this.psdepslnbdinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnBDInstId(), (Object)this.psdepslnbdinst.getPSDepSlnBDInstId()) != 0L) {
                this.psdepslnbdinst = null;
            }
            if (this.psdepslnbdinst == null) {
                PSDepSlnBDInst pSDepSlnBDInst = new PSDepSlnBDInst();
                pSDepSlnBDInst.setPSDepSlnBDInstId(this.getPSDepSlnBDInstId());
                PSDepSlnBDInstService pSDepSlnBDInstService = (PSDepSlnBDInstService)ServiceGlobal.getService(PSDepSlnBDInstService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnBDInstService.autoGet(pSDepSlnBDInst);
                this.psdepslnbdinst = pSDepSlnBDInst;
            }
            return this.psdepslnbdinst;
        }
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
                pSDepSlnSysService.autoGet(pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
        }
    }

    private PSDepSlnSysBDBase getProxyEntity() {
        return this.proxyPSDepSlnSysBDBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysBDBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysBDBase) {
            this.proxyPSDepSlnSysBDBase = (PSDepSlnSysBDBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysBDService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNBDINSTID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNBDINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSBDID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSBDNAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

