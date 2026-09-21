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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnWFEngineInst;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnWFEngineInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysWFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysWFBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_PSDEPSLNSYSWFID = "PSDEPSLNSYSWFID";
    public static final String FIELD_PSDEPSLNSYSWFNAME = "PSDEPSLNSYSWFNAME";
    public static final String FIELD_PSDEPSLNWFENGINEINSTID = "PSDEPSLNWFENGINEINSTID";
    public static final String FIELD_PSDEPSLNWFENGINEINSTNAME = "PSDEPSLNWFENGINEINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSLNSYSID = 3;
    private static final int INDEX_PSDEPSLNSYSNAME = 4;
    private static final int INDEX_PSDEPSLNSYSWFID = 5;
    private static final int INDEX_PSDEPSLNSYSWFNAME = 6;
    private static final int INDEX_PSDEPSLNWFENGINEINSTID = 7;
    private static final int INDEX_PSDEPSLNWFENGINEINSTNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysWFBase proxyPSDepSlnSysWFBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean psdepslnsyswfidDirtyFlag = false;
    private boolean psdepslnsyswfnameDirtyFlag = false;
    private boolean psdepslnwfengineinstidDirtyFlag = false;
    private boolean psdepslnwfengineinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="psdepslnsyswfid")
    private String psdepslnsyswfid;
    @Column(name="psdepslnsyswfname")
    private String psdepslnsyswfname;
    @Column(name="psdepslnwfengineinstid")
    private String psdepslnwfengineinstid;
    @Column(name="psdepslnwfengineinstname")
    private String psdepslnwfengineinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;
    private Integer objPSDepSlnWFEngineInstLock = new Integer(1);
    private PSDepSlnWFEngineInst psdepslnwfengineinst = null;

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

    public void setPSDepSlnSysWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsyswfid = string;
        this.psdepslnsyswfidDirtyFlag = true;
    }

    public String getPSDepSlnSysWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysWFId();
        }
        return this.psdepslnsyswfid;
    }

    public boolean isPSDepSlnSysWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysWFIdDirty();
        }
        return this.psdepslnsyswfidDirtyFlag;
    }

    public void resetPSDepSlnSysWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysWFId();
            return;
        }
        this.psdepslnsyswfidDirtyFlag = false;
        this.psdepslnsyswfid = null;
    }

    public void setPSDepSlnSysWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsyswfname = string;
        this.psdepslnsyswfnameDirtyFlag = true;
    }

    public String getPSDepSlnSysWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysWFName();
        }
        return this.psdepslnsyswfname;
    }

    public boolean isPSDepSlnSysWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysWFNameDirty();
        }
        return this.psdepslnsyswfnameDirtyFlag;
    }

    public void resetPSDepSlnSysWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysWFName();
            return;
        }
        this.psdepslnsyswfnameDirtyFlag = false;
        this.psdepslnsyswfname = null;
    }

    public void setPSDepSlnWFEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnWFEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnwfengineinstid = string;
        this.psdepslnwfengineinstidDirtyFlag = true;
    }

    public String getPSDepSlnWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnWFEngineInstId();
        }
        return this.psdepslnwfengineinstid;
    }

    public boolean isPSDepSlnWFEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnWFEngineInstIdDirty();
        }
        return this.psdepslnwfengineinstidDirtyFlag;
    }

    public void resetPSDepSlnWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnWFEngineInstId();
            return;
        }
        this.psdepslnwfengineinstidDirtyFlag = false;
        this.psdepslnwfengineinstid = null;
    }

    public void setPSDepSlnWFEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnWFEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnwfengineinstname = string;
        this.psdepslnwfengineinstnameDirtyFlag = true;
    }

    public String getPSDepSlnWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnWFEngineInstName();
        }
        return this.psdepslnwfengineinstname;
    }

    public boolean isPSDepSlnWFEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnWFEngineInstNameDirty();
        }
        return this.psdepslnwfengineinstnameDirtyFlag;
    }

    public void resetPSDepSlnWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnWFEngineInstName();
            return;
        }
        this.psdepslnwfengineinstnameDirtyFlag = false;
        this.psdepslnwfengineinstname = null;
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
        PSDepSlnSysWFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysWFBase pSDepSlnSysWFBase) {
        pSDepSlnSysWFBase.resetCreateDate();
        pSDepSlnSysWFBase.resetCreateMan();
        pSDepSlnSysWFBase.resetMemo();
        pSDepSlnSysWFBase.resetPSDepSlnSysId();
        pSDepSlnSysWFBase.resetPSDepSlnSysName();
        pSDepSlnSysWFBase.resetPSDepSlnSysWFId();
        pSDepSlnSysWFBase.resetPSDepSlnSysWFName();
        pSDepSlnSysWFBase.resetPSDepSlnWFEngineInstId();
        pSDepSlnSysWFBase.resetPSDepSlnWFEngineInstName();
        pSDepSlnSysWFBase.resetUpdateDate();
        pSDepSlnSysWFBase.resetUpdateMan();
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
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
        }
        if (!bl || this.isPSDepSlnSysWFIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSWFID, this.getPSDepSlnSysWFId());
        }
        if (!bl || this.isPSDepSlnSysWFNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSWFNAME, this.getPSDepSlnSysWFName());
        }
        if (!bl || this.isPSDepSlnWFEngineInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNWFENGINEINSTID, this.getPSDepSlnWFEngineInstId());
        }
        if (!bl || this.isPSDepSlnWFEngineInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNWFENGINEINSTNAME, this.getPSDepSlnWFEngineInstName());
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
        return PSDepSlnSysWFBase.get(this, n);
    }

    private static Object get(PSDepSlnSysWFBase pSDepSlnSysWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysWFBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnSysWFBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnSysWFBase.getMemo();
            }
            case 3: {
                return pSDepSlnSysWFBase.getPSDepSlnSysId();
            }
            case 4: {
                return pSDepSlnSysWFBase.getPSDepSlnSysName();
            }
            case 5: {
                return pSDepSlnSysWFBase.getPSDepSlnSysWFId();
            }
            case 6: {
                return pSDepSlnSysWFBase.getPSDepSlnSysWFName();
            }
            case 7: {
                return pSDepSlnSysWFBase.getPSDepSlnWFEngineInstId();
            }
            case 8: {
                return pSDepSlnSysWFBase.getPSDepSlnWFEngineInstName();
            }
            case 9: {
                return pSDepSlnSysWFBase.getUpdateDate();
            }
            case 10: {
                return pSDepSlnSysWFBase.getUpdateMan();
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
        PSDepSlnSysWFBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysWFBase pSDepSlnSysWFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysWFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysWFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysWFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysWFBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysWFBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysWFBase.setPSDepSlnSysWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysWFBase.setPSDepSlnSysWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysWFBase.setPSDepSlnWFEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysWFBase.setPSDepSlnWFEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysWFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysWFBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysWFBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysWFBase pSDepSlnSysWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysWFBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnSysWFBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnSysWFBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnSysWFBase.getPSDepSlnSysId() == null;
            }
            case 4: {
                return pSDepSlnSysWFBase.getPSDepSlnSysName() == null;
            }
            case 5: {
                return pSDepSlnSysWFBase.getPSDepSlnSysWFId() == null;
            }
            case 6: {
                return pSDepSlnSysWFBase.getPSDepSlnSysWFName() == null;
            }
            case 7: {
                return pSDepSlnSysWFBase.getPSDepSlnWFEngineInstId() == null;
            }
            case 8: {
                return pSDepSlnSysWFBase.getPSDepSlnWFEngineInstName() == null;
            }
            case 9: {
                return pSDepSlnSysWFBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDepSlnSysWFBase.getUpdateMan() == null;
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
        return PSDepSlnSysWFBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysWFBase pSDepSlnSysWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysWFBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnSysWFBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnSysWFBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnSysWFBase.isPSDepSlnSysIdDirty();
            }
            case 4: {
                return pSDepSlnSysWFBase.isPSDepSlnSysNameDirty();
            }
            case 5: {
                return pSDepSlnSysWFBase.isPSDepSlnSysWFIdDirty();
            }
            case 6: {
                return pSDepSlnSysWFBase.isPSDepSlnSysWFNameDirty();
            }
            case 7: {
                return pSDepSlnSysWFBase.isPSDepSlnWFEngineInstIdDirty();
            }
            case 8: {
                return pSDepSlnSysWFBase.isPSDepSlnWFEngineInstNameDirty();
            }
            case 9: {
                return pSDepSlnSysWFBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDepSlnSysWFBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysWFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysWFBase pSDepSlnSysWFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysWFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnSysWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsyswfid", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getPSDepSlnSysWFId()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnSysWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsyswfname", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getPSDepSlnSysWFName()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnWFEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnwfengineinstid", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getPSDepSlnWFEngineInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnWFEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnwfengineinstname", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getPSDepSlnWFEngineInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysWFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysWFBase.getJSONValue((Object)pSDepSlnSysWFBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysWFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysWFBase pSDepSlnSysWFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysWFBase.getCreateDate() != null) {
            object = pSDepSlnSysWFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysWFBase.getCreateMan() != null) {
            object = pSDepSlnSysWFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysWFBase.getMemo() != null) {
            object = pSDepSlnSysWFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysWFBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysWFBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnSysWFId() != null) {
            object = pSDepSlnSysWFBase.getPSDepSlnSysWFId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnSysWFName() != null) {
            object = pSDepSlnSysWFBase.getPSDepSlnSysWFName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnWFEngineInstId() != null) {
            object = pSDepSlnSysWFBase.getPSDepSlnWFEngineInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNWFENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysWFBase.getPSDepSlnWFEngineInstName() != null) {
            object = pSDepSlnSysWFBase.getPSDepSlnWFEngineInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNWFENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysWFBase.getUpdateDate() != null) {
            object = pSDepSlnSysWFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysWFBase.getUpdateMan() != null) {
            object = pSDepSlnSysWFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysWFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysWFBase pSDepSlnSysWFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysWFBase.isCreateDateDirty() && (bl || pSDepSlnSysWFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysWFBase.getCreateDate());
        }
        if (pSDepSlnSysWFBase.isCreateManDirty() && (bl || pSDepSlnSysWFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysWFBase.getCreateMan());
        }
        if (pSDepSlnSysWFBase.isMemoDirty() && (bl || pSDepSlnSysWFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnSysWFBase.getMemo());
        }
        if (pSDepSlnSysWFBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysWFBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysWFBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysWFBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysWFBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysWFBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysWFBase.isPSDepSlnSysWFIdDirty() && (bl || pSDepSlnSysWFBase.getPSDepSlnSysWFId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSWFID, (Object)pSDepSlnSysWFBase.getPSDepSlnSysWFId());
        }
        if (pSDepSlnSysWFBase.isPSDepSlnSysWFNameDirty() && (bl || pSDepSlnSysWFBase.getPSDepSlnSysWFName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSWFNAME, (Object)pSDepSlnSysWFBase.getPSDepSlnSysWFName());
        }
        if (pSDepSlnSysWFBase.isPSDepSlnWFEngineInstIdDirty() && (bl || pSDepSlnSysWFBase.getPSDepSlnWFEngineInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNWFENGINEINSTID, (Object)pSDepSlnSysWFBase.getPSDepSlnWFEngineInstId());
        }
        if (pSDepSlnSysWFBase.isPSDepSlnWFEngineInstNameDirty() && (bl || pSDepSlnSysWFBase.getPSDepSlnWFEngineInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNWFENGINEINSTNAME, (Object)pSDepSlnSysWFBase.getPSDepSlnWFEngineInstName());
        }
        if (pSDepSlnSysWFBase.isUpdateDateDirty() && (bl || pSDepSlnSysWFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysWFBase.getUpdateDate());
        }
        if (pSDepSlnSysWFBase.isUpdateManDirty() && (bl || pSDepSlnSysWFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysWFBase.getUpdateMan());
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
        return PSDepSlnSysWFBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysWFBase pSDepSlnSysWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysWFBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnSysWFBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnSysWFBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnSysWFBase.resetPSDepSlnSysId();
                return true;
            }
            case 4: {
                pSDepSlnSysWFBase.resetPSDepSlnSysName();
                return true;
            }
            case 5: {
                pSDepSlnSysWFBase.resetPSDepSlnSysWFId();
                return true;
            }
            case 6: {
                pSDepSlnSysWFBase.resetPSDepSlnSysWFName();
                return true;
            }
            case 7: {
                pSDepSlnSysWFBase.resetPSDepSlnWFEngineInstId();
                return true;
            }
            case 8: {
                pSDepSlnSysWFBase.resetPSDepSlnWFEngineInstName();
                return true;
            }
            case 9: {
                pSDepSlnSysWFBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDepSlnSysWFBase.resetUpdateMan();
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
    public PSDepSlnWFEngineInst getPSDepSlnWFEngineInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnWFEngineInst();
        }
        if (this.getPSDepSlnWFEngineInstId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnWFEngineInstLock;
        synchronized (n) {
            if (this.psdepslnwfengineinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnWFEngineInstId(), (Object)this.psdepslnwfengineinst.getPSDepSlnWFEngineInstId()) != 0L) {
                this.psdepslnwfengineinst = null;
            }
            if (this.psdepslnwfengineinst == null) {
                PSDepSlnWFEngineInst pSDepSlnWFEngineInst = new PSDepSlnWFEngineInst();
                pSDepSlnWFEngineInst.setPSDepSlnWFEngineInstId(this.getPSDepSlnWFEngineInstId());
                PSDepSlnWFEngineInstService pSDepSlnWFEngineInstService = (PSDepSlnWFEngineInstService)ServiceGlobal.getService(PSDepSlnWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnWFEngineInstService.autoGet((IEntity)pSDepSlnWFEngineInst);
                this.psdepslnwfengineinst = pSDepSlnWFEngineInst;
            }
            return this.psdepslnwfengineinst;
        }
    }

    private PSDepSlnSysWFBase getProxyEntity() {
        return this.proxyPSDepSlnSysWFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysWFBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysWFBase) {
            this.proxyPSDepSlnSysWFBase = (PSDepSlnSysWFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysWFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSWFID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSWFNAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNWFENGINEINSTID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNWFENGINEINSTNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

