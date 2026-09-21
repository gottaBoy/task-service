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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWFEngineInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnWFEngineInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnWFEngineInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCWFENGINEINSTID = "PSDCWFENGINEINSTID";
    public static final String FIELD_PSDCWFENGINEINSTNAME = "PSDCWFENGINEINSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNWFENGINEINSTID = "PSDEPSLNWFENGINEINSTID";
    public static final String FIELD_PSDEPSLNWFENGINEINSTNAME = "PSDEPSLNWFENGINEINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDCWFENGINEINSTID = 4;
    private static final int INDEX_PSDCWFENGINEINSTNAME = 5;
    private static final int INDEX_PSDEPSLNID = 6;
    private static final int INDEX_PSDEPSLNNAME = 7;
    private static final int INDEX_PSDEPSLNWFENGINEINSTID = 8;
    private static final int INDEX_PSDEPSLNWFENGINEINSTNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnWFEngineInstBase proxyPSDepSlnWFEngineInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcwfengineinstidDirtyFlag = false;
    private boolean psdcwfengineinstnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnwfengineinstidDirtyFlag = false;
    private boolean psdepslnwfengineinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcwfengineinstid")
    private String psdcwfengineinstid;
    @Column(name="psdcwfengineinstname")
    private String psdcwfengineinstname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnwfengineinstid")
    private String psdepslnwfengineinstid;
    @Column(name="psdepslnwfengineinstname")
    private String psdepslnwfengineinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCWFEngineInstLock = new Integer(1);
    private PSDCWFEngineInst psdcwfengineinst = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setPSDCWFEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWFEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcwfengineinstid = string;
        this.psdcwfengineinstidDirtyFlag = true;
    }

    public String getPSDCWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWFEngineInstId();
        }
        return this.psdcwfengineinstid;
    }

    public boolean isPSDCWFEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWFEngineInstIdDirty();
        }
        return this.psdcwfengineinstidDirtyFlag;
    }

    public void resetPSDCWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWFEngineInstId();
            return;
        }
        this.psdcwfengineinstidDirtyFlag = false;
        this.psdcwfengineinstid = null;
    }

    public void setPSDCWFEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWFEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcwfengineinstname = string;
        this.psdcwfengineinstnameDirtyFlag = true;
    }

    public String getPSDCWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWFEngineInstName();
        }
        return this.psdcwfengineinstname;
    }

    public boolean isPSDCWFEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWFEngineInstNameDirty();
        }
        return this.psdcwfengineinstnameDirtyFlag;
    }

    public void resetPSDCWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWFEngineInstName();
            return;
        }
        this.psdcwfengineinstnameDirtyFlag = false;
        this.psdcwfengineinstname = null;
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
        PSDepSlnWFEngineInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase) {
        pSDepSlnWFEngineInstBase.resetCreateDate();
        pSDepSlnWFEngineInstBase.resetCreateMan();
        pSDepSlnWFEngineInstBase.resetDefaultFlag();
        pSDepSlnWFEngineInstBase.resetMemo();
        pSDepSlnWFEngineInstBase.resetPSDCWFEngineInstId();
        pSDepSlnWFEngineInstBase.resetPSDCWFEngineInstName();
        pSDepSlnWFEngineInstBase.resetPSDepSlnId();
        pSDepSlnWFEngineInstBase.resetPSDepSlnName();
        pSDepSlnWFEngineInstBase.resetPSDepSlnWFEngineInstId();
        pSDepSlnWFEngineInstBase.resetPSDepSlnWFEngineInstName();
        pSDepSlnWFEngineInstBase.resetUpdateDate();
        pSDepSlnWFEngineInstBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCWFEngineInstIdDirty()) {
            hashMap.put(FIELD_PSDCWFENGINEINSTID, this.getPSDCWFEngineInstId());
        }
        if (!bl || this.isPSDCWFEngineInstNameDirty()) {
            hashMap.put(FIELD_PSDCWFENGINEINSTNAME, this.getPSDCWFEngineInstName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
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
        return PSDepSlnWFEngineInstBase.get(this, n);
    }

    private static Object get(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnWFEngineInstBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnWFEngineInstBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnWFEngineInstBase.getDefaultFlag();
            }
            case 3: {
                return pSDepSlnWFEngineInstBase.getMemo();
            }
            case 4: {
                return pSDepSlnWFEngineInstBase.getPSDCWFEngineInstId();
            }
            case 5: {
                return pSDepSlnWFEngineInstBase.getPSDCWFEngineInstName();
            }
            case 6: {
                return pSDepSlnWFEngineInstBase.getPSDepSlnId();
            }
            case 7: {
                return pSDepSlnWFEngineInstBase.getPSDepSlnName();
            }
            case 8: {
                return pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId();
            }
            case 9: {
                return pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstName();
            }
            case 10: {
                return pSDepSlnWFEngineInstBase.getUpdateDate();
            }
            case 11: {
                return pSDepSlnWFEngineInstBase.getUpdateMan();
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
        PSDepSlnWFEngineInstBase.set(this, n, object);
    }

    private static void set(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnWFEngineInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnWFEngineInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnWFEngineInstBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnWFEngineInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnWFEngineInstBase.setPSDCWFEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnWFEngineInstBase.setPSDCWFEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnWFEngineInstBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnWFEngineInstBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnWFEngineInstBase.setPSDepSlnWFEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnWFEngineInstBase.setPSDepSlnWFEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnWFEngineInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnWFEngineInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnWFEngineInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnWFEngineInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnWFEngineInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnWFEngineInstBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSDepSlnWFEngineInstBase.getMemo() == null;
            }
            case 4: {
                return pSDepSlnWFEngineInstBase.getPSDCWFEngineInstId() == null;
            }
            case 5: {
                return pSDepSlnWFEngineInstBase.getPSDCWFEngineInstName() == null;
            }
            case 6: {
                return pSDepSlnWFEngineInstBase.getPSDepSlnId() == null;
            }
            case 7: {
                return pSDepSlnWFEngineInstBase.getPSDepSlnName() == null;
            }
            case 8: {
                return pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId() == null;
            }
            case 9: {
                return pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstName() == null;
            }
            case 10: {
                return pSDepSlnWFEngineInstBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDepSlnWFEngineInstBase.getUpdateMan() == null;
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
        return PSDepSlnWFEngineInstBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnWFEngineInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnWFEngineInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnWFEngineInstBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSDepSlnWFEngineInstBase.isMemoDirty();
            }
            case 4: {
                return pSDepSlnWFEngineInstBase.isPSDCWFEngineInstIdDirty();
            }
            case 5: {
                return pSDepSlnWFEngineInstBase.isPSDCWFEngineInstNameDirty();
            }
            case 6: {
                return pSDepSlnWFEngineInstBase.isPSDepSlnIdDirty();
            }
            case 7: {
                return pSDepSlnWFEngineInstBase.isPSDepSlnNameDirty();
            }
            case 8: {
                return pSDepSlnWFEngineInstBase.isPSDepSlnWFEngineInstIdDirty();
            }
            case 9: {
                return pSDepSlnWFEngineInstBase.isPSDepSlnWFEngineInstNameDirty();
            }
            case 10: {
                return pSDepSlnWFEngineInstBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDepSlnWFEngineInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnWFEngineInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnWFEngineInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDCWFEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcwfengineinstid", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getPSDCWFEngineInstId()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDCWFEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcwfengineinstname", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getPSDCWFEngineInstName()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnwfengineinstid", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnwfengineinstname", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstName()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnWFEngineInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnWFEngineInstBase.getJSONValue((Object)pSDepSlnWFEngineInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnWFEngineInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnWFEngineInstBase.getCreateDate() != null) {
            object = pSDepSlnWFEngineInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnWFEngineInstBase.getCreateMan() != null) {
            object = pSDepSlnWFEngineInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnWFEngineInstBase.getDefaultFlag() != null) {
            object = pSDepSlnWFEngineInstBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnWFEngineInstBase.getMemo() != null) {
            object = pSDepSlnWFEngineInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDCWFEngineInstId() != null) {
            object = pSDepSlnWFEngineInstBase.getPSDCWFEngineInstId();
            xmlNode.setAttribute(FIELD_PSDCWFENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDCWFEngineInstName() != null) {
            object = pSDepSlnWFEngineInstBase.getPSDCWFEngineInstName();
            xmlNode.setAttribute(FIELD_PSDCWFENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDepSlnId() != null) {
            object = pSDepSlnWFEngineInstBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDepSlnName() != null) {
            object = pSDepSlnWFEngineInstBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId() != null) {
            object = pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNWFENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstName() != null) {
            object = pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNWFENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnWFEngineInstBase.getUpdateDate() != null) {
            object = pSDepSlnWFEngineInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnWFEngineInstBase.getUpdateMan() != null) {
            object = pSDepSlnWFEngineInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnWFEngineInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnWFEngineInstBase.isCreateDateDirty() && (bl || pSDepSlnWFEngineInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnWFEngineInstBase.getCreateDate());
        }
        if (pSDepSlnWFEngineInstBase.isCreateManDirty() && (bl || pSDepSlnWFEngineInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnWFEngineInstBase.getCreateMan());
        }
        if (pSDepSlnWFEngineInstBase.isDefaultFlagDirty() && (bl || pSDepSlnWFEngineInstBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDepSlnWFEngineInstBase.getDefaultFlag());
        }
        if (pSDepSlnWFEngineInstBase.isMemoDirty() && (bl || pSDepSlnWFEngineInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnWFEngineInstBase.getMemo());
        }
        if (pSDepSlnWFEngineInstBase.isPSDCWFEngineInstIdDirty() && (bl || pSDepSlnWFEngineInstBase.getPSDCWFEngineInstId() != null)) {
            iDataObject.set(FIELD_PSDCWFENGINEINSTID, (Object)pSDepSlnWFEngineInstBase.getPSDCWFEngineInstId());
        }
        if (pSDepSlnWFEngineInstBase.isPSDCWFEngineInstNameDirty() && (bl || pSDepSlnWFEngineInstBase.getPSDCWFEngineInstName() != null)) {
            iDataObject.set(FIELD_PSDCWFENGINEINSTNAME, (Object)pSDepSlnWFEngineInstBase.getPSDCWFEngineInstName());
        }
        if (pSDepSlnWFEngineInstBase.isPSDepSlnIdDirty() && (bl || pSDepSlnWFEngineInstBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnWFEngineInstBase.getPSDepSlnId());
        }
        if (pSDepSlnWFEngineInstBase.isPSDepSlnNameDirty() && (bl || pSDepSlnWFEngineInstBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnWFEngineInstBase.getPSDepSlnName());
        }
        if (pSDepSlnWFEngineInstBase.isPSDepSlnWFEngineInstIdDirty() && (bl || pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNWFENGINEINSTID, (Object)pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId());
        }
        if (pSDepSlnWFEngineInstBase.isPSDepSlnWFEngineInstNameDirty() && (bl || pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNWFENGINEINSTNAME, (Object)pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstName());
        }
        if (pSDepSlnWFEngineInstBase.isUpdateDateDirty() && (bl || pSDepSlnWFEngineInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnWFEngineInstBase.getUpdateDate());
        }
        if (pSDepSlnWFEngineInstBase.isUpdateManDirty() && (bl || pSDepSlnWFEngineInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnWFEngineInstBase.getUpdateMan());
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
        return PSDepSlnWFEngineInstBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnWFEngineInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnWFEngineInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnWFEngineInstBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSDepSlnWFEngineInstBase.resetMemo();
                return true;
            }
            case 4: {
                pSDepSlnWFEngineInstBase.resetPSDCWFEngineInstId();
                return true;
            }
            case 5: {
                pSDepSlnWFEngineInstBase.resetPSDCWFEngineInstName();
                return true;
            }
            case 6: {
                pSDepSlnWFEngineInstBase.resetPSDepSlnId();
                return true;
            }
            case 7: {
                pSDepSlnWFEngineInstBase.resetPSDepSlnName();
                return true;
            }
            case 8: {
                pSDepSlnWFEngineInstBase.resetPSDepSlnWFEngineInstId();
                return true;
            }
            case 9: {
                pSDepSlnWFEngineInstBase.resetPSDepSlnWFEngineInstName();
                return true;
            }
            case 10: {
                pSDepSlnWFEngineInstBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDepSlnWFEngineInstBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCWFEngineInst getPSDCWFEngineInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWFEngineInst();
        }
        if (this.getPSDCWFEngineInstId() == null) {
            return null;
        }
        Integer n = this.objPSDCWFEngineInstLock;
        synchronized (n) {
            if (this.psdcwfengineinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCWFEngineInstId(), (Object)this.psdcwfengineinst.getPSDCWFEngineInstId()) != 0L) {
                this.psdcwfengineinst = null;
            }
            if (this.psdcwfengineinst == null) {
                PSDCWFEngineInst pSDCWFEngineInst = new PSDCWFEngineInst();
                pSDCWFEngineInst.setPSDCWFEngineInstId(this.getPSDCWFEngineInstId());
                PSDCWFEngineInstService pSDCWFEngineInstService = (PSDCWFEngineInstService)ServiceGlobal.getService(PSDCWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
                pSDCWFEngineInstService.autoGet((IEntity)pSDCWFEngineInst);
                this.psdcwfengineinst = pSDCWFEngineInst;
            }
            return this.psdcwfengineinst;
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

    private PSDepSlnWFEngineInstBase getProxyEntity() {
        return this.proxyPSDepSlnWFEngineInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnWFEngineInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnWFEngineInstBase) {
            this.proxyPSDepSlnWFEngineInstBase = (PSDepSlnWFEngineInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnWFEngineInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDCWFENGINEINSTID, 4);
        fieldIndexMap.put(FIELD_PSDCWFENGINEINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNWFENGINEINSTID, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNWFENGINEINSTNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

