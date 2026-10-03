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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnDBInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnDBInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysDBBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysDBBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNDBINSTID = "PSDEPSLNDBINSTID";
    public static final String FIELD_PSDEPSLNDBINSTNAME = "PSDEPSLNDBINSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNSYSDBID = "PSDEPSLNSYSDBID";
    public static final String FIELD_PSDEPSLNSYSDBNAME = "PSDEPSLNSYSDBNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSLNDBINSTID = 3;
    private static final int INDEX_PSDEPSLNDBINSTNAME = 4;
    private static final int INDEX_PSDEPSLNID = 5;
    private static final int INDEX_PSDEPSLNNAME = 6;
    private static final int INDEX_PSDEPSLNSYSDBID = 7;
    private static final int INDEX_PSDEPSLNSYSDBNAME = 8;
    private static final int INDEX_PSDEPSLNSYSID = 9;
    private static final int INDEX_PSDEPSLNSYSNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysDBBase proxyPSDepSlnSysDBBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslndbinstidDirtyFlag = false;
    private boolean psdepslndbinstnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnsysdbidDirtyFlag = false;
    private boolean psdepslnsysdbnameDirtyFlag = false;
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
    @Column(name="psdepslndbinstid")
    private String psdepslndbinstid;
    @Column(name="psdepslndbinstname")
    private String psdepslndbinstname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnsysdbid")
    private String psdepslnsysdbid;
    @Column(name="psdepslnsysdbname")
    private String psdepslnsysdbname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnDBInstLock = new Integer(1);
    private PSDepSlnDBInst psdepslndbinst = null;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;
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

    public void setPSDepSlnDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslndbinstid = string;
        this.psdepslndbinstidDirtyFlag = true;
    }

    public String getPSDepSlnDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnDBInstId();
        }
        return this.psdepslndbinstid;
    }

    public boolean isPSDepSlnDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnDBInstIdDirty();
        }
        return this.psdepslndbinstidDirtyFlag;
    }

    public void resetPSDepSlnDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnDBInstId();
            return;
        }
        this.psdepslndbinstidDirtyFlag = false;
        this.psdepslndbinstid = null;
    }

    public void setPSDepSlnDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslndbinstname = string;
        this.psdepslndbinstnameDirtyFlag = true;
    }

    public String getPSDepSlnDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnDBInstName();
        }
        return this.psdepslndbinstname;
    }

    public boolean isPSDepSlnDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnDBInstNameDirty();
        }
        return this.psdepslndbinstnameDirtyFlag;
    }

    public void resetPSDepSlnDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnDBInstName();
            return;
        }
        this.psdepslndbinstnameDirtyFlag = false;
        this.psdepslndbinstname = null;
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

    public void setPSDepSlnSysDBId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysDBId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysdbid = string;
        this.psdepslnsysdbidDirtyFlag = true;
    }

    public String getPSDepSlnSysDBId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysDBId();
        }
        return this.psdepslnsysdbid;
    }

    public boolean isPSDepSlnSysDBIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysDBIdDirty();
        }
        return this.psdepslnsysdbidDirtyFlag;
    }

    public void resetPSDepSlnSysDBId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysDBId();
            return;
        }
        this.psdepslnsysdbidDirtyFlag = false;
        this.psdepslnsysdbid = null;
    }

    public void setPSDepSlnSysDBName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysDBName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysdbname = string;
        this.psdepslnsysdbnameDirtyFlag = true;
    }

    public String getPSDepSlnSysDBName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysDBName();
        }
        return this.psdepslnsysdbname;
    }

    public boolean isPSDepSlnSysDBNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysDBNameDirty();
        }
        return this.psdepslnsysdbnameDirtyFlag;
    }

    public void resetPSDepSlnSysDBName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysDBName();
            return;
        }
        this.psdepslnsysdbnameDirtyFlag = false;
        this.psdepslnsysdbname = null;
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
        PSDepSlnSysDBBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysDBBase pSDepSlnSysDBBase) {
        pSDepSlnSysDBBase.resetCreateDate();
        pSDepSlnSysDBBase.resetCreateMan();
        pSDepSlnSysDBBase.resetMemo();
        pSDepSlnSysDBBase.resetPSDepSlnDBInstId();
        pSDepSlnSysDBBase.resetPSDepSlnDBInstName();
        pSDepSlnSysDBBase.resetPSDepSlnId();
        pSDepSlnSysDBBase.resetPSDepSlnName();
        pSDepSlnSysDBBase.resetPSDepSlnSysDBId();
        pSDepSlnSysDBBase.resetPSDepSlnSysDBName();
        pSDepSlnSysDBBase.resetPSDepSlnSysId();
        pSDepSlnSysDBBase.resetPSDepSlnSysName();
        pSDepSlnSysDBBase.resetUpdateDate();
        pSDepSlnSysDBBase.resetUpdateMan();
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
        if (!bl || this.isPSDepSlnDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNDBINSTID, this.getPSDepSlnDBInstId());
        }
        if (!bl || this.isPSDepSlnDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNDBINSTNAME, this.getPSDepSlnDBInstName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnSysDBIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSDBID, this.getPSDepSlnSysDBId());
        }
        if (!bl || this.isPSDepSlnSysDBNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSDBNAME, this.getPSDepSlnSysDBName());
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
        return PSDepSlnSysDBBase.get(this, n);
    }

    private static Object get(PSDepSlnSysDBBase pSDepSlnSysDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysDBBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnSysDBBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnSysDBBase.getMemo();
            }
            case 3: {
                return pSDepSlnSysDBBase.getPSDepSlnDBInstId();
            }
            case 4: {
                return pSDepSlnSysDBBase.getPSDepSlnDBInstName();
            }
            case 5: {
                return pSDepSlnSysDBBase.getPSDepSlnId();
            }
            case 6: {
                return pSDepSlnSysDBBase.getPSDepSlnName();
            }
            case 7: {
                return pSDepSlnSysDBBase.getPSDepSlnSysDBId();
            }
            case 8: {
                return pSDepSlnSysDBBase.getPSDepSlnSysDBName();
            }
            case 9: {
                return pSDepSlnSysDBBase.getPSDepSlnSysId();
            }
            case 10: {
                return pSDepSlnSysDBBase.getPSDepSlnSysName();
            }
            case 11: {
                return pSDepSlnSysDBBase.getUpdateDate();
            }
            case 12: {
                return pSDepSlnSysDBBase.getUpdateMan();
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
        PSDepSlnSysDBBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysDBBase pSDepSlnSysDBBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysDBBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysDBBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysDBBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysDBBase.setPSDepSlnDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysDBBase.setPSDepSlnDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysDBBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysDBBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysDBBase.setPSDepSlnSysDBId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysDBBase.setPSDepSlnSysDBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysDBBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysDBBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnSysDBBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnSysDBBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysDBBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysDBBase pSDepSlnSysDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysDBBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnSysDBBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnSysDBBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnSysDBBase.getPSDepSlnDBInstId() == null;
            }
            case 4: {
                return pSDepSlnSysDBBase.getPSDepSlnDBInstName() == null;
            }
            case 5: {
                return pSDepSlnSysDBBase.getPSDepSlnId() == null;
            }
            case 6: {
                return pSDepSlnSysDBBase.getPSDepSlnName() == null;
            }
            case 7: {
                return pSDepSlnSysDBBase.getPSDepSlnSysDBId() == null;
            }
            case 8: {
                return pSDepSlnSysDBBase.getPSDepSlnSysDBName() == null;
            }
            case 9: {
                return pSDepSlnSysDBBase.getPSDepSlnSysId() == null;
            }
            case 10: {
                return pSDepSlnSysDBBase.getPSDepSlnSysName() == null;
            }
            case 11: {
                return pSDepSlnSysDBBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDepSlnSysDBBase.getUpdateMan() == null;
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
        return PSDepSlnSysDBBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysDBBase pSDepSlnSysDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysDBBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnSysDBBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnSysDBBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnSysDBBase.isPSDepSlnDBInstIdDirty();
            }
            case 4: {
                return pSDepSlnSysDBBase.isPSDepSlnDBInstNameDirty();
            }
            case 5: {
                return pSDepSlnSysDBBase.isPSDepSlnIdDirty();
            }
            case 6: {
                return pSDepSlnSysDBBase.isPSDepSlnNameDirty();
            }
            case 7: {
                return pSDepSlnSysDBBase.isPSDepSlnSysDBIdDirty();
            }
            case 8: {
                return pSDepSlnSysDBBase.isPSDepSlnSysDBNameDirty();
            }
            case 9: {
                return pSDepSlnSysDBBase.isPSDepSlnSysIdDirty();
            }
            case 10: {
                return pSDepSlnSysDBBase.isPSDepSlnSysNameDirty();
            }
            case 11: {
                return pSDepSlnSysDBBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDepSlnSysDBBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysDBBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysDBBase pSDepSlnSysDBBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysDBBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslndbinstid", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getPSDepSlnDBInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslndbinstname", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getPSDepSlnDBInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnSysDBId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysdbid", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getPSDepSlnSysDBId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnSysDBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysdbname", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getPSDepSlnSysDBName()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysDBBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysDBBase.getJSONValue((Object)pSDepSlnSysDBBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysDBBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysDBBase pSDepSlnSysDBBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysDBBase.getCreateDate() != null) {
            object = pSDepSlnSysDBBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysDBBase.getCreateMan() != null) {
            object = pSDepSlnSysDBBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getMemo() != null) {
            object = pSDepSlnSysDBBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnDBInstId() != null) {
            object = pSDepSlnSysDBBase.getPSDepSlnDBInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnDBInstName() != null) {
            object = pSDepSlnSysDBBase.getPSDepSlnDBInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnId() != null) {
            object = pSDepSlnSysDBBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnName() != null) {
            object = pSDepSlnSysDBBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnSysDBId() != null) {
            object = pSDepSlnSysDBBase.getPSDepSlnSysDBId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSDBID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnSysDBName() != null) {
            object = pSDepSlnSysDBBase.getPSDepSlnSysDBName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSDBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysDBBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysDBBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDBBase.getUpdateDate() != null) {
            object = pSDepSlnSysDBBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysDBBase.getUpdateMan() != null) {
            object = pSDepSlnSysDBBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysDBBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysDBBase pSDepSlnSysDBBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysDBBase.isCreateDateDirty() && (bl || pSDepSlnSysDBBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysDBBase.getCreateDate());
        }
        if (pSDepSlnSysDBBase.isCreateManDirty() && (bl || pSDepSlnSysDBBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysDBBase.getCreateMan());
        }
        if (pSDepSlnSysDBBase.isMemoDirty() && (bl || pSDepSlnSysDBBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnSysDBBase.getMemo());
        }
        if (pSDepSlnSysDBBase.isPSDepSlnDBInstIdDirty() && (bl || pSDepSlnSysDBBase.getPSDepSlnDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNDBINSTID, (Object)pSDepSlnSysDBBase.getPSDepSlnDBInstId());
        }
        if (pSDepSlnSysDBBase.isPSDepSlnDBInstNameDirty() && (bl || pSDepSlnSysDBBase.getPSDepSlnDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNDBINSTNAME, (Object)pSDepSlnSysDBBase.getPSDepSlnDBInstName());
        }
        if (pSDepSlnSysDBBase.isPSDepSlnIdDirty() && (bl || pSDepSlnSysDBBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnSysDBBase.getPSDepSlnId());
        }
        if (pSDepSlnSysDBBase.isPSDepSlnNameDirty() && (bl || pSDepSlnSysDBBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnSysDBBase.getPSDepSlnName());
        }
        if (pSDepSlnSysDBBase.isPSDepSlnSysDBIdDirty() && (bl || pSDepSlnSysDBBase.getPSDepSlnSysDBId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSDBID, (Object)pSDepSlnSysDBBase.getPSDepSlnSysDBId());
        }
        if (pSDepSlnSysDBBase.isPSDepSlnSysDBNameDirty() && (bl || pSDepSlnSysDBBase.getPSDepSlnSysDBName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSDBNAME, (Object)pSDepSlnSysDBBase.getPSDepSlnSysDBName());
        }
        if (pSDepSlnSysDBBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysDBBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysDBBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysDBBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysDBBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysDBBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysDBBase.isUpdateDateDirty() && (bl || pSDepSlnSysDBBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysDBBase.getUpdateDate());
        }
        if (pSDepSlnSysDBBase.isUpdateManDirty() && (bl || pSDepSlnSysDBBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysDBBase.getUpdateMan());
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
        return PSDepSlnSysDBBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysDBBase pSDepSlnSysDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysDBBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnSysDBBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnSysDBBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnSysDBBase.resetPSDepSlnDBInstId();
                return true;
            }
            case 4: {
                pSDepSlnSysDBBase.resetPSDepSlnDBInstName();
                return true;
            }
            case 5: {
                pSDepSlnSysDBBase.resetPSDepSlnId();
                return true;
            }
            case 6: {
                pSDepSlnSysDBBase.resetPSDepSlnName();
                return true;
            }
            case 7: {
                pSDepSlnSysDBBase.resetPSDepSlnSysDBId();
                return true;
            }
            case 8: {
                pSDepSlnSysDBBase.resetPSDepSlnSysDBName();
                return true;
            }
            case 9: {
                pSDepSlnSysDBBase.resetPSDepSlnSysId();
                return true;
            }
            case 10: {
                pSDepSlnSysDBBase.resetPSDepSlnSysName();
                return true;
            }
            case 11: {
                pSDepSlnSysDBBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDepSlnSysDBBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnDBInst getPSDepSlnDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnDBInst();
        }
        if (this.getPSDepSlnDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnDBInstLock;
        synchronized (n) {
            if (this.psdepslndbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnDBInstId(), (Object)this.psdepslndbinst.getPSDepSlnDBInstId()) != 0L) {
                this.psdepslndbinst = null;
            }
            if (this.psdepslndbinst == null) {
                PSDepSlnDBInst pSDepSlnDBInst = new PSDepSlnDBInst();
                pSDepSlnDBInst.setPSDepSlnDBInstId(this.getPSDepSlnDBInstId());
                PSDepSlnDBInstService pSDepSlnDBInstService = (PSDepSlnDBInstService)ServiceGlobal.getService(PSDepSlnDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnDBInstService.autoGet(pSDepSlnDBInst);
                this.psdepslndbinst = pSDepSlnDBInst;
            }
            return this.psdepslndbinst;
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
                pSDepSlnService.autoGet(pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSDepSlnSysDBBase getProxyEntity() {
        return this.proxyPSDepSlnSysDBBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysDBBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysDBBase) {
            this.proxyPSDepSlnSysDBBase = (PSDepSlnSysDBBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDBService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNDBINSTID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNDBINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSDBID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSDBNAME, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

