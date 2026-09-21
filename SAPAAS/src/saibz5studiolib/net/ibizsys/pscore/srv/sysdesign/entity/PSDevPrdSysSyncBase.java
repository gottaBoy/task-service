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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSysSyncItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSysSyncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdSysSyncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTPSDEVPRDSYSID = "DSTPSDEVPRDSYSID";
    public static final String FIELD_DSTPSDEVPRDSYSNAME = "DSTPSDEVPRDSYSNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVPRDID = "PSDEVPRDID";
    public static final String FIELD_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String FIELD_PSDEVPRDSYSSYNCID = "PSDEVPRDSYSSYNCID";
    public static final String FIELD_PSDEVPRDSYSSYNCNAME = "PSDEVPRDSYSSYNCNAME";
    public static final String FIELD_SRCPSDEVPRDSYSID = "SRCPSDEVPRDSYSID";
    public static final String FIELD_SRCPSDEVPRDSYSNAME = "SRCPSDEVPRDSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DSTPSDEVPRDSYSID = 2;
    private static final int INDEX_DSTPSDEVPRDSYSNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEVPRDID = 5;
    private static final int INDEX_PSDEVPRDNAME = 6;
    private static final int INDEX_PSDEVPRDSYSSYNCID = 7;
    private static final int INDEX_PSDEVPRDSYSSYNCNAME = 8;
    private static final int INDEX_SRCPSDEVPRDSYSID = 9;
    private static final int INDEX_SRCPSDEVPRDSYSNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdSysSyncBase proxyPSDevPrdSysSyncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstpsdevprdsysidDirtyFlag = false;
    private boolean dstpsdevprdsysnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevprdidDirtyFlag = false;
    private boolean psdevprdnameDirtyFlag = false;
    private boolean psdevprdsyssyncidDirtyFlag = false;
    private boolean psdevprdsyssyncnameDirtyFlag = false;
    private boolean srcpsdevprdsysidDirtyFlag = false;
    private boolean srcpsdevprdsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstpsdevprdsysid")
    private String dstpsdevprdsysid;
    @Column(name="dstpsdevprdsysname")
    private String dstpsdevprdsysname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevprdid")
    private String psdevprdid;
    @Column(name="psdevprdname")
    private String psdevprdname;
    @Column(name="psdevprdsyssyncid")
    private String psdevprdsyssyncid;
    @Column(name="psdevprdsyssyncname")
    private String psdevprdsyssyncname;
    @Column(name="srcpsdevprdsysid")
    private String srcpsdevprdsysid;
    @Column(name="srcpsdevprdsysname")
    private String srcpsdevprdsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objDstPSDevPrdSysLock = new Integer(1);
    private PSDevPrdSys dstpsdevprdsys = null;
    private Integer objSrcPSDevPrdSysLock = new Integer(1);
    private PSDevPrdSys srcpsdevprdsys = null;
    private Integer objPSDevPrdLock = new Integer(1);
    private PSDevPrd psdevprd = null;
    private Integer objPSDevPrdSysSyncItemsLock = new Integer(1);
    private ArrayList<PSDevPrdSysSyncItem> psdevprdsyssyncitems = null;

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

    public void setDstPSDevPrdSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDevPrdSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdevprdsysid = string;
        this.dstpsdevprdsysidDirtyFlag = true;
    }

    public String getDstPSDevPrdSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDevPrdSysId();
        }
        return this.dstpsdevprdsysid;
    }

    public boolean isDstPSDevPrdSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDevPrdSysIdDirty();
        }
        return this.dstpsdevprdsysidDirtyFlag;
    }

    public void resetDstPSDevPrdSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDevPrdSysId();
            return;
        }
        this.dstpsdevprdsysidDirtyFlag = false;
        this.dstpsdevprdsysid = null;
    }

    public void setDstPSDevPrdSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDevPrdSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdevprdsysname = string;
        this.dstpsdevprdsysnameDirtyFlag = true;
    }

    public String getDstPSDevPrdSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDevPrdSysName();
        }
        return this.dstpsdevprdsysname;
    }

    public boolean isDstPSDevPrdSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDevPrdSysNameDirty();
        }
        return this.dstpsdevprdsysnameDirtyFlag;
    }

    public void resetDstPSDevPrdSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDevPrdSysName();
            return;
        }
        this.dstpsdevprdsysnameDirtyFlag = false;
        this.dstpsdevprdsysname = null;
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

    public void setPSDevPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdid = string;
        this.psdevprdidDirtyFlag = true;
    }

    public String getPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdId();
        }
        return this.psdevprdid;
    }

    public boolean isPSDevPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIdDirty();
        }
        return this.psdevprdidDirtyFlag;
    }

    public void resetPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdId();
            return;
        }
        this.psdevprdidDirtyFlag = false;
        this.psdevprdid = null;
    }

    public void setPSDevPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdname = string;
        this.psdevprdnameDirtyFlag = true;
    }

    public String getPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdName();
        }
        return this.psdevprdname;
    }

    public boolean isPSDevPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdNameDirty();
        }
        return this.psdevprdnameDirtyFlag;
    }

    public void resetPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdName();
            return;
        }
        this.psdevprdnameDirtyFlag = false;
        this.psdevprdname = null;
    }

    public void setPSDevPrdSysSyncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSysSyncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsyssyncid = string;
        this.psdevprdsyssyncidDirtyFlag = true;
    }

    public String getPSDevPrdSysSyncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysSyncId();
        }
        return this.psdevprdsyssyncid;
    }

    public boolean isPSDevPrdSysSyncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSysSyncIdDirty();
        }
        return this.psdevprdsyssyncidDirtyFlag;
    }

    public void resetPSDevPrdSysSyncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSysSyncId();
            return;
        }
        this.psdevprdsyssyncidDirtyFlag = false;
        this.psdevprdsyssyncid = null;
    }

    public void setPSDevPrdSysSyncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSysSyncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsyssyncname = string;
        this.psdevprdsyssyncnameDirtyFlag = true;
    }

    public String getPSDevPrdSysSyncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysSyncName();
        }
        return this.psdevprdsyssyncname;
    }

    public boolean isPSDevPrdSysSyncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSysSyncNameDirty();
        }
        return this.psdevprdsyssyncnameDirtyFlag;
    }

    public void resetPSDevPrdSysSyncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSysSyncName();
            return;
        }
        this.psdevprdsyssyncnameDirtyFlag = false;
        this.psdevprdsyssyncname = null;
    }

    public void setSrcPSDevPrdSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDevPrdSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdevprdsysid = string;
        this.srcpsdevprdsysidDirtyFlag = true;
    }

    public String getSrcPSDevPrdSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevPrdSysId();
        }
        return this.srcpsdevprdsysid;
    }

    public boolean isSrcPSDevPrdSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDevPrdSysIdDirty();
        }
        return this.srcpsdevprdsysidDirtyFlag;
    }

    public void resetSrcPSDevPrdSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDevPrdSysId();
            return;
        }
        this.srcpsdevprdsysidDirtyFlag = false;
        this.srcpsdevprdsysid = null;
    }

    public void setSrcPSDevPrdSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDevPrdSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdevprdsysname = string;
        this.srcpsdevprdsysnameDirtyFlag = true;
    }

    public String getSrcPSDevPrdSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevPrdSysName();
        }
        return this.srcpsdevprdsysname;
    }

    public boolean isSrcPSDevPrdSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDevPrdSysNameDirty();
        }
        return this.srcpsdevprdsysnameDirtyFlag;
    }

    public void resetSrcPSDevPrdSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDevPrdSysName();
            return;
        }
        this.srcpsdevprdsysnameDirtyFlag = false;
        this.srcpsdevprdsysname = null;
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
        PSDevPrdSysSyncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdSysSyncBase pSDevPrdSysSyncBase) {
        pSDevPrdSysSyncBase.resetCreateDate();
        pSDevPrdSysSyncBase.resetCreateMan();
        pSDevPrdSysSyncBase.resetDstPSDevPrdSysId();
        pSDevPrdSysSyncBase.resetDstPSDevPrdSysName();
        pSDevPrdSysSyncBase.resetMemo();
        pSDevPrdSysSyncBase.resetPSDevPrdId();
        pSDevPrdSysSyncBase.resetPSDevPrdName();
        pSDevPrdSysSyncBase.resetPSDevPrdSysSyncId();
        pSDevPrdSysSyncBase.resetPSDevPrdSysSyncName();
        pSDevPrdSysSyncBase.resetSrcPSDevPrdSysId();
        pSDevPrdSysSyncBase.resetSrcPSDevPrdSysName();
        pSDevPrdSysSyncBase.resetUpdateDate();
        pSDevPrdSysSyncBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDstPSDevPrdSysIdDirty()) {
            hashMap.put(FIELD_DSTPSDEVPRDSYSID, this.getDstPSDevPrdSysId());
        }
        if (!bl || this.isDstPSDevPrdSysNameDirty()) {
            hashMap.put(FIELD_DSTPSDEVPRDSYSNAME, this.getDstPSDevPrdSysName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevPrdIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDID, this.getPSDevPrdId());
        }
        if (!bl || this.isPSDevPrdNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDNAME, this.getPSDevPrdName());
        }
        if (!bl || this.isPSDevPrdSysSyncIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSYSSYNCID, this.getPSDevPrdSysSyncId());
        }
        if (!bl || this.isPSDevPrdSysSyncNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSYSSYNCNAME, this.getPSDevPrdSysSyncName());
        }
        if (!bl || this.isSrcPSDevPrdSysIdDirty()) {
            hashMap.put(FIELD_SRCPSDEVPRDSYSID, this.getSrcPSDevPrdSysId());
        }
        if (!bl || this.isSrcPSDevPrdSysNameDirty()) {
            hashMap.put(FIELD_SRCPSDEVPRDSYSNAME, this.getSrcPSDevPrdSysName());
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
        return PSDevPrdSysSyncBase.get(this, n);
    }

    private static Object get(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysSyncBase.getCreateDate();
            }
            case 1: {
                return pSDevPrdSysSyncBase.getCreateMan();
            }
            case 2: {
                return pSDevPrdSysSyncBase.getDstPSDevPrdSysId();
            }
            case 3: {
                return pSDevPrdSysSyncBase.getDstPSDevPrdSysName();
            }
            case 4: {
                return pSDevPrdSysSyncBase.getMemo();
            }
            case 5: {
                return pSDevPrdSysSyncBase.getPSDevPrdId();
            }
            case 6: {
                return pSDevPrdSysSyncBase.getPSDevPrdName();
            }
            case 7: {
                return pSDevPrdSysSyncBase.getPSDevPrdSysSyncId();
            }
            case 8: {
                return pSDevPrdSysSyncBase.getPSDevPrdSysSyncName();
            }
            case 9: {
                return pSDevPrdSysSyncBase.getSrcPSDevPrdSysId();
            }
            case 10: {
                return pSDevPrdSysSyncBase.getSrcPSDevPrdSysName();
            }
            case 11: {
                return pSDevPrdSysSyncBase.getUpdateDate();
            }
            case 12: {
                return pSDevPrdSysSyncBase.getUpdateMan();
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
        PSDevPrdSysSyncBase.set(this, n, object);
    }

    private static void set(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSysSyncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdSysSyncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdSysSyncBase.setDstPSDevPrdSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdSysSyncBase.setDstPSDevPrdSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdSysSyncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdSysSyncBase.setPSDevPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdSysSyncBase.setPSDevPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdSysSyncBase.setPSDevPrdSysSyncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdSysSyncBase.setPSDevPrdSysSyncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdSysSyncBase.setSrcPSDevPrdSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdSysSyncBase.setSrcPSDevPrdSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdSysSyncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdSysSyncBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevPrdSysSyncBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysSyncBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevPrdSysSyncBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevPrdSysSyncBase.getDstPSDevPrdSysId() == null;
            }
            case 3: {
                return pSDevPrdSysSyncBase.getDstPSDevPrdSysName() == null;
            }
            case 4: {
                return pSDevPrdSysSyncBase.getMemo() == null;
            }
            case 5: {
                return pSDevPrdSysSyncBase.getPSDevPrdId() == null;
            }
            case 6: {
                return pSDevPrdSysSyncBase.getPSDevPrdName() == null;
            }
            case 7: {
                return pSDevPrdSysSyncBase.getPSDevPrdSysSyncId() == null;
            }
            case 8: {
                return pSDevPrdSysSyncBase.getPSDevPrdSysSyncName() == null;
            }
            case 9: {
                return pSDevPrdSysSyncBase.getSrcPSDevPrdSysId() == null;
            }
            case 10: {
                return pSDevPrdSysSyncBase.getSrcPSDevPrdSysName() == null;
            }
            case 11: {
                return pSDevPrdSysSyncBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDevPrdSysSyncBase.getUpdateMan() == null;
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
        return PSDevPrdSysSyncBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysSyncBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevPrdSysSyncBase.isCreateManDirty();
            }
            case 2: {
                return pSDevPrdSysSyncBase.isDstPSDevPrdSysIdDirty();
            }
            case 3: {
                return pSDevPrdSysSyncBase.isDstPSDevPrdSysNameDirty();
            }
            case 4: {
                return pSDevPrdSysSyncBase.isMemoDirty();
            }
            case 5: {
                return pSDevPrdSysSyncBase.isPSDevPrdIdDirty();
            }
            case 6: {
                return pSDevPrdSysSyncBase.isPSDevPrdNameDirty();
            }
            case 7: {
                return pSDevPrdSysSyncBase.isPSDevPrdSysSyncIdDirty();
            }
            case 8: {
                return pSDevPrdSysSyncBase.isPSDevPrdSysSyncNameDirty();
            }
            case 9: {
                return pSDevPrdSysSyncBase.isSrcPSDevPrdSysIdDirty();
            }
            case 10: {
                return pSDevPrdSysSyncBase.isSrcPSDevPrdSysNameDirty();
            }
            case 11: {
                return pSDevPrdSysSyncBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDevPrdSysSyncBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdSysSyncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdSysSyncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getDstPSDevPrdSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdevprdsysid", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getDstPSDevPrdSysId()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getDstPSDevPrdSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdevprdsysname", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getDstPSDevPrdSysName()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getPSDevPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdid", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getPSDevPrdId()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getPSDevPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdname", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getPSDevPrdName()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getPSDevPrdSysSyncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsyssyncid", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getPSDevPrdSysSyncId()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getPSDevPrdSysSyncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsyssyncname", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getPSDevPrdSysSyncName()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getSrcPSDevPrdSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdevprdsysid", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getSrcPSDevPrdSysId()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getSrcPSDevPrdSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdevprdsysname", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getSrcPSDevPrdSysName()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdSysSyncBase.getJSONValue((Object)pSDevPrdSysSyncBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdSysSyncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdSysSyncBase.getCreateDate() != null) {
            object = pSDevPrdSysSyncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSysSyncBase.getCreateMan() != null) {
            object = pSDevPrdSysSyncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getDstPSDevPrdSysId() != null) {
            object = pSDevPrdSysSyncBase.getDstPSDevPrdSysId();
            xmlNode.setAttribute(FIELD_DSTPSDEVPRDSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getDstPSDevPrdSysName() != null) {
            object = pSDevPrdSysSyncBase.getDstPSDevPrdSysName();
            xmlNode.setAttribute(FIELD_DSTPSDEVPRDSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getMemo() != null) {
            object = pSDevPrdSysSyncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getPSDevPrdId() != null) {
            object = pSDevPrdSysSyncBase.getPSDevPrdId();
            xmlNode.setAttribute(FIELD_PSDEVPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getPSDevPrdName() != null) {
            object = pSDevPrdSysSyncBase.getPSDevPrdName();
            xmlNode.setAttribute(FIELD_PSDEVPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getPSDevPrdSysSyncId() != null) {
            object = pSDevPrdSysSyncBase.getPSDevPrdSysSyncId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSYSSYNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getPSDevPrdSysSyncName() != null) {
            object = pSDevPrdSysSyncBase.getPSDevPrdSysSyncName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSYSSYNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getSrcPSDevPrdSysId() != null) {
            object = pSDevPrdSysSyncBase.getSrcPSDevPrdSysId();
            xmlNode.setAttribute(FIELD_SRCPSDEVPRDSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getSrcPSDevPrdSysName() != null) {
            object = pSDevPrdSysSyncBase.getSrcPSDevPrdSysName();
            xmlNode.setAttribute(FIELD_SRCPSDEVPRDSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncBase.getUpdateDate() != null) {
            object = pSDevPrdSysSyncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSysSyncBase.getUpdateMan() != null) {
            object = pSDevPrdSysSyncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdSysSyncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdSysSyncBase.isCreateDateDirty() && (bl || pSDevPrdSysSyncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdSysSyncBase.getCreateDate());
        }
        if (pSDevPrdSysSyncBase.isCreateManDirty() && (bl || pSDevPrdSysSyncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdSysSyncBase.getCreateMan());
        }
        if (pSDevPrdSysSyncBase.isDstPSDevPrdSysIdDirty() && (bl || pSDevPrdSysSyncBase.getDstPSDevPrdSysId() != null)) {
            iDataObject.set(FIELD_DSTPSDEVPRDSYSID, (Object)pSDevPrdSysSyncBase.getDstPSDevPrdSysId());
        }
        if (pSDevPrdSysSyncBase.isDstPSDevPrdSysNameDirty() && (bl || pSDevPrdSysSyncBase.getDstPSDevPrdSysName() != null)) {
            iDataObject.set(FIELD_DSTPSDEVPRDSYSNAME, (Object)pSDevPrdSysSyncBase.getDstPSDevPrdSysName());
        }
        if (pSDevPrdSysSyncBase.isMemoDirty() && (bl || pSDevPrdSysSyncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdSysSyncBase.getMemo());
        }
        if (pSDevPrdSysSyncBase.isPSDevPrdIdDirty() && (bl || pSDevPrdSysSyncBase.getPSDevPrdId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDID, (Object)pSDevPrdSysSyncBase.getPSDevPrdId());
        }
        if (pSDevPrdSysSyncBase.isPSDevPrdNameDirty() && (bl || pSDevPrdSysSyncBase.getPSDevPrdName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDNAME, (Object)pSDevPrdSysSyncBase.getPSDevPrdName());
        }
        if (pSDevPrdSysSyncBase.isPSDevPrdSysSyncIdDirty() && (bl || pSDevPrdSysSyncBase.getPSDevPrdSysSyncId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSYSSYNCID, (Object)pSDevPrdSysSyncBase.getPSDevPrdSysSyncId());
        }
        if (pSDevPrdSysSyncBase.isPSDevPrdSysSyncNameDirty() && (bl || pSDevPrdSysSyncBase.getPSDevPrdSysSyncName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSYSSYNCNAME, (Object)pSDevPrdSysSyncBase.getPSDevPrdSysSyncName());
        }
        if (pSDevPrdSysSyncBase.isSrcPSDevPrdSysIdDirty() && (bl || pSDevPrdSysSyncBase.getSrcPSDevPrdSysId() != null)) {
            iDataObject.set(FIELD_SRCPSDEVPRDSYSID, (Object)pSDevPrdSysSyncBase.getSrcPSDevPrdSysId());
        }
        if (pSDevPrdSysSyncBase.isSrcPSDevPrdSysNameDirty() && (bl || pSDevPrdSysSyncBase.getSrcPSDevPrdSysName() != null)) {
            iDataObject.set(FIELD_SRCPSDEVPRDSYSNAME, (Object)pSDevPrdSysSyncBase.getSrcPSDevPrdSysName());
        }
        if (pSDevPrdSysSyncBase.isUpdateDateDirty() && (bl || pSDevPrdSysSyncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdSysSyncBase.getUpdateDate());
        }
        if (pSDevPrdSysSyncBase.isUpdateManDirty() && (bl || pSDevPrdSysSyncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdSysSyncBase.getUpdateMan());
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
        return PSDevPrdSysSyncBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSysSyncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevPrdSysSyncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevPrdSysSyncBase.resetDstPSDevPrdSysId();
                return true;
            }
            case 3: {
                pSDevPrdSysSyncBase.resetDstPSDevPrdSysName();
                return true;
            }
            case 4: {
                pSDevPrdSysSyncBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevPrdSysSyncBase.resetPSDevPrdId();
                return true;
            }
            case 6: {
                pSDevPrdSysSyncBase.resetPSDevPrdName();
                return true;
            }
            case 7: {
                pSDevPrdSysSyncBase.resetPSDevPrdSysSyncId();
                return true;
            }
            case 8: {
                pSDevPrdSysSyncBase.resetPSDevPrdSysSyncName();
                return true;
            }
            case 9: {
                pSDevPrdSysSyncBase.resetSrcPSDevPrdSysId();
                return true;
            }
            case 10: {
                pSDevPrdSysSyncBase.resetSrcPSDevPrdSysName();
                return true;
            }
            case 11: {
                pSDevPrdSysSyncBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDevPrdSysSyncBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSys getDstPSDevPrdSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDevPrdSys();
        }
        if (this.getDstPSDevPrdSysId() == null) {
            return null;
        }
        Integer n = this.objDstPSDevPrdSysLock;
        synchronized (n) {
            if (this.dstpsdevprdsys != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDevPrdSysId(), (Object)this.dstpsdevprdsys.getPSDevPrdSysId()) != 0L) {
                this.dstpsdevprdsys = null;
            }
            if (this.dstpsdevprdsys == null) {
                PSDevPrdSys pSDevPrdSys = new PSDevPrdSys();
                pSDevPrdSys.setPSDevPrdSysId(this.getDstPSDevPrdSysId());
                PSDevPrdSysService pSDevPrdSysService = (PSDevPrdSysService)ServiceGlobal.getService(PSDevPrdSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSysService.autoGet((IEntity)pSDevPrdSys);
                this.dstpsdevprdsys = pSDevPrdSys;
            }
            return this.dstpsdevprdsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSys getSrcPSDevPrdSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevPrdSys();
        }
        if (this.getSrcPSDevPrdSysId() == null) {
            return null;
        }
        Integer n = this.objSrcPSDevPrdSysLock;
        synchronized (n) {
            if (this.srcpsdevprdsys != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSDevPrdSysId(), (Object)this.srcpsdevprdsys.getPSDevPrdSysId()) != 0L) {
                this.srcpsdevprdsys = null;
            }
            if (this.srcpsdevprdsys == null) {
                PSDevPrdSys pSDevPrdSys = new PSDevPrdSys();
                pSDevPrdSys.setPSDevPrdSysId(this.getSrcPSDevPrdSysId());
                PSDevPrdSysService pSDevPrdSysService = (PSDevPrdSysService)ServiceGlobal.getService(PSDevPrdSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSysService.autoGet((IEntity)pSDevPrdSys);
                this.srcpsdevprdsys = pSDevPrdSys;
            }
            return this.srcpsdevprdsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrd getPSDevPrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrd();
        }
        if (this.getPSDevPrdId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdLock;
        synchronized (n) {
            if (this.psdevprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdId(), (Object)this.psdevprd.getPSDevPrdId()) != 0L) {
                this.psdevprd = null;
            }
            if (this.psdevprd == null) {
                PSDevPrd pSDevPrd = new PSDevPrd();
                pSDevPrd.setPSDevPrdId(this.getPSDevPrdId());
                PSDevPrdService pSDevPrdService = (PSDevPrdService)ServiceGlobal.getService(PSDevPrdService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdService.autoGet((IEntity)pSDevPrd);
                this.psdevprd = pSDevPrd;
            }
            return this.psdevprd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevPrdSysSyncItem> getPSDevPrdSysSyncItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysSyncItems();
        }
        if (this.getPSDevPrdSysSyncId() == null) {
            return null;
        }
        PSDevPrdSysSyncItemService pSDevPrdSysSyncItemService = (PSDevPrdSysSyncItemService)ServiceGlobal.getService(PSDevPrdSysSyncItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevPrdSysSyncItemsLock;
        synchronized (n) {
            if (this.psdevprdsyssyncitems == null) {
                this.psdevprdsyssyncitems = pSDevPrdSysSyncItemService.selectByPSDevPrdSysSync(this);
            }
            return this.psdevprdsyssyncitems;
        }
    }

    private PSDevPrdSysSyncBase getProxyEntity() {
        return this.proxyPSDevPrdSysSyncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdSysSyncBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdSysSyncBase) {
            this.proxyPSDevPrdSysSyncBase = (PSDevPrdSysSyncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSTPSDEVPRDSYSID, 2);
        fieldIndexMap.put(FIELD_DSTPSDEVPRDSYSNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEVPRDID, 5);
        fieldIndexMap.put(FIELD_PSDEVPRDNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVPRDSYSSYNCID, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDSYSSYNCNAME, 8);
        fieldIndexMap.put(FIELD_SRCPSDEVPRDSYSID, 9);
        fieldIndexMap.put(FIELD_SRCPSDEVPRDSYSNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

