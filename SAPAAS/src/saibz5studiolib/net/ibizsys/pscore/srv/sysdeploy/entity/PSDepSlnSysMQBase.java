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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMQInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnMQInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysMQBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysMQBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNMQINSTID = "PSDEPSLNMQINSTID";
    public static final String FIELD_PSDEPSLNMQINSTNAME = "PSDEPSLNMQINSTNAME";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSMQID = "PSDEPSLNSYSMQID";
    public static final String FIELD_PSDEPSLNSYSMQNAME = "PSDEPSLNSYSMQNAME";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSLNID = 3;
    private static final int INDEX_PSDEPSLNMQINSTID = 4;
    private static final int INDEX_PSDEPSLNMQINSTNAME = 5;
    private static final int INDEX_PSDEPSLNNAME = 6;
    private static final int INDEX_PSDEPSLNSYSID = 7;
    private static final int INDEX_PSDEPSLNSYSMQID = 8;
    private static final int INDEX_PSDEPSLNSYSMQNAME = 9;
    private static final int INDEX_PSDEPSLNSYSNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysMQBase proxyPSDepSlnSysMQBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnmqinstidDirtyFlag = false;
    private boolean psdepslnmqinstnameDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysmqidDirtyFlag = false;
    private boolean psdepslnsysmqnameDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnmqinstid")
    private String psdepslnmqinstid;
    @Column(name="psdepslnmqinstname")
    private String psdepslnmqinstname;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysmqid")
    private String psdepslnsysmqid;
    @Column(name="psdepslnsysmqname")
    private String psdepslnsysmqname;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnMQInstLock = new Integer(1);
    private PSDepSlnMQInst psdepslnmqinst = null;
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

    public void setPSDepSlnMQInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnMQInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmqinstid = string;
        this.psdepslnmqinstidDirtyFlag = true;
    }

    public String getPSDepSlnMQInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnMQInstId();
        }
        return this.psdepslnmqinstid;
    }

    public boolean isPSDepSlnMQInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnMQInstIdDirty();
        }
        return this.psdepslnmqinstidDirtyFlag;
    }

    public void resetPSDepSlnMQInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnMQInstId();
            return;
        }
        this.psdepslnmqinstidDirtyFlag = false;
        this.psdepslnmqinstid = null;
    }

    public void setPSDepSlnMQInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnMQInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmqinstname = string;
        this.psdepslnmqinstnameDirtyFlag = true;
    }

    public String getPSDepSlnMQInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnMQInstName();
        }
        return this.psdepslnmqinstname;
    }

    public boolean isPSDepSlnMQInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnMQInstNameDirty();
        }
        return this.psdepslnmqinstnameDirtyFlag;
    }

    public void resetPSDepSlnMQInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnMQInstName();
            return;
        }
        this.psdepslnmqinstnameDirtyFlag = false;
        this.psdepslnmqinstname = null;
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

    public void setPSDepSlnSysMQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysMQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysmqid = string;
        this.psdepslnsysmqidDirtyFlag = true;
    }

    public String getPSDepSlnSysMQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysMQId();
        }
        return this.psdepslnsysmqid;
    }

    public boolean isPSDepSlnSysMQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysMQIdDirty();
        }
        return this.psdepslnsysmqidDirtyFlag;
    }

    public void resetPSDepSlnSysMQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysMQId();
            return;
        }
        this.psdepslnsysmqidDirtyFlag = false;
        this.psdepslnsysmqid = null;
    }

    public void setPSDepSlnSysMQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysMQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysmqname = string;
        this.psdepslnsysmqnameDirtyFlag = true;
    }

    public String getPSDepSlnSysMQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysMQName();
        }
        return this.psdepslnsysmqname;
    }

    public boolean isPSDepSlnSysMQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysMQNameDirty();
        }
        return this.psdepslnsysmqnameDirtyFlag;
    }

    public void resetPSDepSlnSysMQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysMQName();
            return;
        }
        this.psdepslnsysmqnameDirtyFlag = false;
        this.psdepslnsysmqname = null;
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
        PSDepSlnSysMQBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysMQBase pSDepSlnSysMQBase) {
        pSDepSlnSysMQBase.resetCreateDate();
        pSDepSlnSysMQBase.resetCreateMan();
        pSDepSlnSysMQBase.resetMemo();
        pSDepSlnSysMQBase.resetPSDepSlnId();
        pSDepSlnSysMQBase.resetPSDepSlnMQInstId();
        pSDepSlnSysMQBase.resetPSDepSlnMQInstName();
        pSDepSlnSysMQBase.resetPSDepSlnName();
        pSDepSlnSysMQBase.resetPSDepSlnSysId();
        pSDepSlnSysMQBase.resetPSDepSlnSysMQId();
        pSDepSlnSysMQBase.resetPSDepSlnSysMQName();
        pSDepSlnSysMQBase.resetPSDepSlnSysName();
        pSDepSlnSysMQBase.resetUpdateDate();
        pSDepSlnSysMQBase.resetUpdateMan();
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
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnMQInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNMQINSTID, this.getPSDepSlnMQInstId());
        }
        if (!bl || this.isPSDepSlnMQInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNMQINSTNAME, this.getPSDepSlnMQInstName());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysMQIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSMQID, this.getPSDepSlnSysMQId());
        }
        if (!bl || this.isPSDepSlnSysMQNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSMQNAME, this.getPSDepSlnSysMQName());
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
        return PSDepSlnSysMQBase.get(this, n);
    }

    private static Object get(PSDepSlnSysMQBase pSDepSlnSysMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysMQBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnSysMQBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnSysMQBase.getMemo();
            }
            case 3: {
                return pSDepSlnSysMQBase.getPSDepSlnId();
            }
            case 4: {
                return pSDepSlnSysMQBase.getPSDepSlnMQInstId();
            }
            case 5: {
                return pSDepSlnSysMQBase.getPSDepSlnMQInstName();
            }
            case 6: {
                return pSDepSlnSysMQBase.getPSDepSlnName();
            }
            case 7: {
                return pSDepSlnSysMQBase.getPSDepSlnSysId();
            }
            case 8: {
                return pSDepSlnSysMQBase.getPSDepSlnSysMQId();
            }
            case 9: {
                return pSDepSlnSysMQBase.getPSDepSlnSysMQName();
            }
            case 10: {
                return pSDepSlnSysMQBase.getPSDepSlnSysName();
            }
            case 11: {
                return pSDepSlnSysMQBase.getUpdateDate();
            }
            case 12: {
                return pSDepSlnSysMQBase.getUpdateMan();
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
        PSDepSlnSysMQBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysMQBase pSDepSlnSysMQBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysMQBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysMQBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysMQBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysMQBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysMQBase.setPSDepSlnMQInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysMQBase.setPSDepSlnMQInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysMQBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysMQBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysMQBase.setPSDepSlnSysMQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysMQBase.setPSDepSlnSysMQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysMQBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnSysMQBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnSysMQBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysMQBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysMQBase pSDepSlnSysMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysMQBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnSysMQBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnSysMQBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnSysMQBase.getPSDepSlnId() == null;
            }
            case 4: {
                return pSDepSlnSysMQBase.getPSDepSlnMQInstId() == null;
            }
            case 5: {
                return pSDepSlnSysMQBase.getPSDepSlnMQInstName() == null;
            }
            case 6: {
                return pSDepSlnSysMQBase.getPSDepSlnName() == null;
            }
            case 7: {
                return pSDepSlnSysMQBase.getPSDepSlnSysId() == null;
            }
            case 8: {
                return pSDepSlnSysMQBase.getPSDepSlnSysMQId() == null;
            }
            case 9: {
                return pSDepSlnSysMQBase.getPSDepSlnSysMQName() == null;
            }
            case 10: {
                return pSDepSlnSysMQBase.getPSDepSlnSysName() == null;
            }
            case 11: {
                return pSDepSlnSysMQBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDepSlnSysMQBase.getUpdateMan() == null;
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
        return PSDepSlnSysMQBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysMQBase pSDepSlnSysMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysMQBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnSysMQBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnSysMQBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnSysMQBase.isPSDepSlnIdDirty();
            }
            case 4: {
                return pSDepSlnSysMQBase.isPSDepSlnMQInstIdDirty();
            }
            case 5: {
                return pSDepSlnSysMQBase.isPSDepSlnMQInstNameDirty();
            }
            case 6: {
                return pSDepSlnSysMQBase.isPSDepSlnNameDirty();
            }
            case 7: {
                return pSDepSlnSysMQBase.isPSDepSlnSysIdDirty();
            }
            case 8: {
                return pSDepSlnSysMQBase.isPSDepSlnSysMQIdDirty();
            }
            case 9: {
                return pSDepSlnSysMQBase.isPSDepSlnSysMQNameDirty();
            }
            case 10: {
                return pSDepSlnSysMQBase.isPSDepSlnSysNameDirty();
            }
            case 11: {
                return pSDepSlnSysMQBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDepSlnSysMQBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysMQBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysMQBase pSDepSlnSysMQBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysMQBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnMQInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmqinstid", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getPSDepSlnMQInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnMQInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmqinstname", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getPSDepSlnMQInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnSysMQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysmqid", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getPSDepSlnSysMQId()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnSysMQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysmqname", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getPSDepSlnSysMQName()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysMQBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysMQBase.getJSONValue((Object)pSDepSlnSysMQBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysMQBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysMQBase pSDepSlnSysMQBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysMQBase.getCreateDate() != null) {
            object = pSDepSlnSysMQBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysMQBase.getCreateMan() != null) {
            object = pSDepSlnSysMQBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getMemo() != null) {
            object = pSDepSlnSysMQBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnId() != null) {
            object = pSDepSlnSysMQBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnMQInstId() != null) {
            object = pSDepSlnSysMQBase.getPSDepSlnMQInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNMQINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnMQInstName() != null) {
            object = pSDepSlnSysMQBase.getPSDepSlnMQInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNMQINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnName() != null) {
            object = pSDepSlnSysMQBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysMQBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnSysMQId() != null) {
            object = pSDepSlnSysMQBase.getPSDepSlnSysMQId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSMQID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnSysMQName() != null) {
            object = pSDepSlnSysMQBase.getPSDepSlnSysMQName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSMQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysMQBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysMQBase.getUpdateDate() != null) {
            object = pSDepSlnSysMQBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysMQBase.getUpdateMan() != null) {
            object = pSDepSlnSysMQBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysMQBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysMQBase pSDepSlnSysMQBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysMQBase.isCreateDateDirty() && (bl || pSDepSlnSysMQBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysMQBase.getCreateDate());
        }
        if (pSDepSlnSysMQBase.isCreateManDirty() && (bl || pSDepSlnSysMQBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysMQBase.getCreateMan());
        }
        if (pSDepSlnSysMQBase.isMemoDirty() && (bl || pSDepSlnSysMQBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnSysMQBase.getMemo());
        }
        if (pSDepSlnSysMQBase.isPSDepSlnIdDirty() && (bl || pSDepSlnSysMQBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnSysMQBase.getPSDepSlnId());
        }
        if (pSDepSlnSysMQBase.isPSDepSlnMQInstIdDirty() && (bl || pSDepSlnSysMQBase.getPSDepSlnMQInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMQINSTID, (Object)pSDepSlnSysMQBase.getPSDepSlnMQInstId());
        }
        if (pSDepSlnSysMQBase.isPSDepSlnMQInstNameDirty() && (bl || pSDepSlnSysMQBase.getPSDepSlnMQInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMQINSTNAME, (Object)pSDepSlnSysMQBase.getPSDepSlnMQInstName());
        }
        if (pSDepSlnSysMQBase.isPSDepSlnNameDirty() && (bl || pSDepSlnSysMQBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnSysMQBase.getPSDepSlnName());
        }
        if (pSDepSlnSysMQBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysMQBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysMQBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysMQBase.isPSDepSlnSysMQIdDirty() && (bl || pSDepSlnSysMQBase.getPSDepSlnSysMQId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSMQID, (Object)pSDepSlnSysMQBase.getPSDepSlnSysMQId());
        }
        if (pSDepSlnSysMQBase.isPSDepSlnSysMQNameDirty() && (bl || pSDepSlnSysMQBase.getPSDepSlnSysMQName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSMQNAME, (Object)pSDepSlnSysMQBase.getPSDepSlnSysMQName());
        }
        if (pSDepSlnSysMQBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysMQBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysMQBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysMQBase.isUpdateDateDirty() && (bl || pSDepSlnSysMQBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysMQBase.getUpdateDate());
        }
        if (pSDepSlnSysMQBase.isUpdateManDirty() && (bl || pSDepSlnSysMQBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysMQBase.getUpdateMan());
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
        return PSDepSlnSysMQBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysMQBase pSDepSlnSysMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysMQBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnSysMQBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnSysMQBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnSysMQBase.resetPSDepSlnId();
                return true;
            }
            case 4: {
                pSDepSlnSysMQBase.resetPSDepSlnMQInstId();
                return true;
            }
            case 5: {
                pSDepSlnSysMQBase.resetPSDepSlnMQInstName();
                return true;
            }
            case 6: {
                pSDepSlnSysMQBase.resetPSDepSlnName();
                return true;
            }
            case 7: {
                pSDepSlnSysMQBase.resetPSDepSlnSysId();
                return true;
            }
            case 8: {
                pSDepSlnSysMQBase.resetPSDepSlnSysMQId();
                return true;
            }
            case 9: {
                pSDepSlnSysMQBase.resetPSDepSlnSysMQName();
                return true;
            }
            case 10: {
                pSDepSlnSysMQBase.resetPSDepSlnSysName();
                return true;
            }
            case 11: {
                pSDepSlnSysMQBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDepSlnSysMQBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnMQInst getPSDepSlnMQInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnMQInst();
        }
        if (this.getPSDepSlnMQInstId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnMQInstLock;
        synchronized (n) {
            if (this.psdepslnmqinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnMQInstId(), (Object)this.psdepslnmqinst.getPSDepSlnMQInstId()) != 0L) {
                this.psdepslnmqinst = null;
            }
            if (this.psdepslnmqinst == null) {
                PSDepSlnMQInst pSDepSlnMQInst = new PSDepSlnMQInst();
                pSDepSlnMQInst.setPSDepSlnMQInstId(this.getPSDepSlnMQInstId());
                PSDepSlnMQInstService pSDepSlnMQInstService = (PSDepSlnMQInstService)ServiceGlobal.getService(PSDepSlnMQInstService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnMQInstService.autoGet((IEntity)pSDepSlnMQInst);
                this.psdepslnmqinst = pSDepSlnMQInst;
            }
            return this.psdepslnmqinst;
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

    private PSDepSlnSysMQBase getProxyEntity() {
        return this.proxyPSDepSlnSysMQBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysMQBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysMQBase) {
            this.proxyPSDepSlnSysMQBase = (PSDepSlnSysMQBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysMQService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNMQINSTID, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNMQINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSMQID, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSMQNAME, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

