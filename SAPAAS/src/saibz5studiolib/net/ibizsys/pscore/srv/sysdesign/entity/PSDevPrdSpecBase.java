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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpecPlan;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSpecBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdSpecBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVPRDID = "PSDEVPRDID";
    public static final String FIELD_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String FIELD_PSDEVPRDSPECID = "PSDEVPRDSPECID";
    public static final String FIELD_PSDEVPRDSPECNAME = "PSDEVPRDSPECNAME";
    public static final String FIELD_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String FIELD_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String FIELD_SPECSN = "SPECSN";
    public static final String FIELD_SPECSTATE = "SPECSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVPRDID = 4;
    private static final int INDEX_PSDEVPRDNAME = 5;
    private static final int INDEX_PSDEVPRDSPECID = 6;
    private static final int INDEX_PSDEVPRDSPECNAME = 7;
    private static final int INDEX_PSDEVPRDVERID = 8;
    private static final int INDEX_PSDEVPRDVERNAME = 9;
    private static final int INDEX_SPECSN = 10;
    private static final int INDEX_SPECSTATE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdSpecBase proxyPSDevPrdSpecBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevprdidDirtyFlag = false;
    private boolean psdevprdnameDirtyFlag = false;
    private boolean psdevprdspecidDirtyFlag = false;
    private boolean psdevprdspecnameDirtyFlag = false;
    private boolean psdevprdveridDirtyFlag = false;
    private boolean psdevprdvernameDirtyFlag = false;
    private boolean specsnDirtyFlag = false;
    private boolean specstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevprdid")
    private String psdevprdid;
    @Column(name="psdevprdname")
    private String psdevprdname;
    @Column(name="psdevprdspecid")
    private String psdevprdspecid;
    @Column(name="psdevprdspecname")
    private String psdevprdspecname;
    @Column(name="psdevprdverid")
    private String psdevprdverid;
    @Column(name="psdevprdvername")
    private String psdevprdvername;
    @Column(name="specsn")
    private String specsn;
    @Column(name="specstate")
    private Integer specstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevPrdVerLock = new Integer(1);
    private PSDevPrdVer psdevprdver = null;
    private Integer objPSDevPrdLock = new Integer(1);
    private PSDevPrd psdevprd = null;
    private Integer objPSDevPrdSpecPlansLock = new Integer(1);
    private ArrayList<PSDevPrdSpecPlan> psdevprdspecplans = null;

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setPSDevPrdSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdspecid = string;
        this.psdevprdspecidDirtyFlag = true;
    }

    public String getPSDevPrdSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecId();
        }
        return this.psdevprdspecid;
    }

    public boolean isPSDevPrdSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSpecIdDirty();
        }
        return this.psdevprdspecidDirtyFlag;
    }

    public void resetPSDevPrdSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSpecId();
            return;
        }
        this.psdevprdspecidDirtyFlag = false;
        this.psdevprdspecid = null;
    }

    public void setPSDevPrdSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdspecname = string;
        this.psdevprdspecnameDirtyFlag = true;
    }

    public String getPSDevPrdSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecName();
        }
        return this.psdevprdspecname;
    }

    public boolean isPSDevPrdSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSpecNameDirty();
        }
        return this.psdevprdspecnameDirtyFlag;
    }

    public void resetPSDevPrdSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSpecName();
            return;
        }
        this.psdevprdspecnameDirtyFlag = false;
        this.psdevprdspecname = null;
    }

    public void setPSDevPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdverid = string;
        this.psdevprdveridDirtyFlag = true;
    }

    public String getPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerId();
        }
        return this.psdevprdverid;
    }

    public boolean isPSDevPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerIdDirty();
        }
        return this.psdevprdveridDirtyFlag;
    }

    public void resetPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerId();
            return;
        }
        this.psdevprdveridDirtyFlag = false;
        this.psdevprdverid = null;
    }

    public void setPSDevPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdvername = string;
        this.psdevprdvernameDirtyFlag = true;
    }

    public String getPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerName();
        }
        return this.psdevprdvername;
    }

    public boolean isPSDevPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerNameDirty();
        }
        return this.psdevprdvernameDirtyFlag;
    }

    public void resetPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerName();
            return;
        }
        this.psdevprdvernameDirtyFlag = false;
        this.psdevprdvername = null;
    }

    public void setSpecSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpecSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.specsn = string;
        this.specsnDirtyFlag = true;
    }

    public String getSpecSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpecSN();
        }
        return this.specsn;
    }

    public boolean isSpecSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpecSNDirty();
        }
        return this.specsnDirtyFlag;
    }

    public void resetSpecSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpecSN();
            return;
        }
        this.specsnDirtyFlag = false;
        this.specsn = null;
    }

    public void setSpecState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpecState(n);
            return;
        }
        this.specstate = n;
        this.specstateDirtyFlag = true;
    }

    public Integer getSpecState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpecState();
        }
        return this.specstate;
    }

    public boolean isSpecStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpecStateDirty();
        }
        return this.specstateDirtyFlag;
    }

    public void resetSpecState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpecState();
            return;
        }
        this.specstateDirtyFlag = false;
        this.specstate = null;
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
        PSDevPrdSpecBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdSpecBase pSDevPrdSpecBase) {
        pSDevPrdSpecBase.resetContent();
        pSDevPrdSpecBase.resetCreateDate();
        pSDevPrdSpecBase.resetCreateMan();
        pSDevPrdSpecBase.resetMemo();
        pSDevPrdSpecBase.resetPSDevPrdId();
        pSDevPrdSpecBase.resetPSDevPrdName();
        pSDevPrdSpecBase.resetPSDevPrdSpecId();
        pSDevPrdSpecBase.resetPSDevPrdSpecName();
        pSDevPrdSpecBase.resetPSDevPrdVerId();
        pSDevPrdSpecBase.resetPSDevPrdVerName();
        pSDevPrdSpecBase.resetSpecSN();
        pSDevPrdSpecBase.resetSpecState();
        pSDevPrdSpecBase.resetUpdateDate();
        pSDevPrdSpecBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
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
        if (!bl || this.isPSDevPrdIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDID, this.getPSDevPrdId());
        }
        if (!bl || this.isPSDevPrdNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDNAME, this.getPSDevPrdName());
        }
        if (!bl || this.isPSDevPrdSpecIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSPECID, this.getPSDevPrdSpecId());
        }
        if (!bl || this.isPSDevPrdSpecNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSPECNAME, this.getPSDevPrdSpecName());
        }
        if (!bl || this.isPSDevPrdVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERID, this.getPSDevPrdVerId());
        }
        if (!bl || this.isPSDevPrdVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERNAME, this.getPSDevPrdVerName());
        }
        if (!bl || this.isSpecSNDirty()) {
            hashMap.put(FIELD_SPECSN, this.getSpecSN());
        }
        if (!bl || this.isSpecStateDirty()) {
            hashMap.put(FIELD_SPECSTATE, this.getSpecState());
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
        return PSDevPrdSpecBase.get(this, n);
    }

    private static Object get(PSDevPrdSpecBase pSDevPrdSpecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSpecBase.getContent();
            }
            case 1: {
                return pSDevPrdSpecBase.getCreateDate();
            }
            case 2: {
                return pSDevPrdSpecBase.getCreateMan();
            }
            case 3: {
                return pSDevPrdSpecBase.getMemo();
            }
            case 4: {
                return pSDevPrdSpecBase.getPSDevPrdId();
            }
            case 5: {
                return pSDevPrdSpecBase.getPSDevPrdName();
            }
            case 6: {
                return pSDevPrdSpecBase.getPSDevPrdSpecId();
            }
            case 7: {
                return pSDevPrdSpecBase.getPSDevPrdSpecName();
            }
            case 8: {
                return pSDevPrdSpecBase.getPSDevPrdVerId();
            }
            case 9: {
                return pSDevPrdSpecBase.getPSDevPrdVerName();
            }
            case 10: {
                return pSDevPrdSpecBase.getSpecSN();
            }
            case 11: {
                return pSDevPrdSpecBase.getSpecState();
            }
            case 12: {
                return pSDevPrdSpecBase.getUpdateDate();
            }
            case 13: {
                return pSDevPrdSpecBase.getUpdateMan();
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
        PSDevPrdSpecBase.set(this, n, object);
    }

    private static void set(PSDevPrdSpecBase pSDevPrdSpecBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSpecBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdSpecBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdSpecBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdSpecBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdSpecBase.setPSDevPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdSpecBase.setPSDevPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdSpecBase.setPSDevPrdSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdSpecBase.setPSDevPrdSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdSpecBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdSpecBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdSpecBase.setSpecSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdSpecBase.setSpecState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdSpecBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdSpecBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevPrdSpecBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdSpecBase pSDevPrdSpecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSpecBase.getContent() == null;
            }
            case 1: {
                return pSDevPrdSpecBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevPrdSpecBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevPrdSpecBase.getMemo() == null;
            }
            case 4: {
                return pSDevPrdSpecBase.getPSDevPrdId() == null;
            }
            case 5: {
                return pSDevPrdSpecBase.getPSDevPrdName() == null;
            }
            case 6: {
                return pSDevPrdSpecBase.getPSDevPrdSpecId() == null;
            }
            case 7: {
                return pSDevPrdSpecBase.getPSDevPrdSpecName() == null;
            }
            case 8: {
                return pSDevPrdSpecBase.getPSDevPrdVerId() == null;
            }
            case 9: {
                return pSDevPrdSpecBase.getPSDevPrdVerName() == null;
            }
            case 10: {
                return pSDevPrdSpecBase.getSpecSN() == null;
            }
            case 11: {
                return pSDevPrdSpecBase.getSpecState() == null;
            }
            case 12: {
                return pSDevPrdSpecBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDevPrdSpecBase.getUpdateMan() == null;
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
        return PSDevPrdSpecBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdSpecBase pSDevPrdSpecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSpecBase.isContentDirty();
            }
            case 1: {
                return pSDevPrdSpecBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevPrdSpecBase.isCreateManDirty();
            }
            case 3: {
                return pSDevPrdSpecBase.isMemoDirty();
            }
            case 4: {
                return pSDevPrdSpecBase.isPSDevPrdIdDirty();
            }
            case 5: {
                return pSDevPrdSpecBase.isPSDevPrdNameDirty();
            }
            case 6: {
                return pSDevPrdSpecBase.isPSDevPrdSpecIdDirty();
            }
            case 7: {
                return pSDevPrdSpecBase.isPSDevPrdSpecNameDirty();
            }
            case 8: {
                return pSDevPrdSpecBase.isPSDevPrdVerIdDirty();
            }
            case 9: {
                return pSDevPrdSpecBase.isPSDevPrdVerNameDirty();
            }
            case 10: {
                return pSDevPrdSpecBase.isSpecSNDirty();
            }
            case 11: {
                return pSDevPrdSpecBase.isSpecStateDirty();
            }
            case 12: {
                return pSDevPrdSpecBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDevPrdSpecBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdSpecBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdSpecBase pSDevPrdSpecBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdSpecBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getContent()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdid", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getPSDevPrdId()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdname", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getPSDevPrdName()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdspecid", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getPSDevPrdSpecId()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdspecname", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getPSDevPrdSpecName()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getSpecSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"specsn", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getSpecSN()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getSpecState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"specstate", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getSpecState()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSpecBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdSpecBase.getJSONValue((Object)pSDevPrdSpecBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdSpecBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdSpecBase pSDevPrdSpecBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdSpecBase.getContent() != null) {
            object = pSDevPrdSpecBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getCreateDate() != null) {
            object = pSDevPrdSpecBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSpecBase.getCreateMan() != null) {
            object = pSDevPrdSpecBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getMemo() != null) {
            object = pSDevPrdSpecBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdId() != null) {
            object = pSDevPrdSpecBase.getPSDevPrdId();
            xmlNode.setAttribute(FIELD_PSDEVPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdName() != null) {
            object = pSDevPrdSpecBase.getPSDevPrdName();
            xmlNode.setAttribute(FIELD_PSDEVPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdSpecId() != null) {
            object = pSDevPrdSpecBase.getPSDevPrdSpecId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdSpecName() != null) {
            object = pSDevPrdSpecBase.getPSDevPrdSpecName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdVerId() != null) {
            object = pSDevPrdSpecBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getPSDevPrdVerName() != null) {
            object = pSDevPrdSpecBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getSpecSN() != null) {
            object = pSDevPrdSpecBase.getSpecSN();
            xmlNode.setAttribute(FIELD_SPECSN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecBase.getSpecState() != null) {
            object = pSDevPrdSpecBase.getSpecState();
            xmlNode.setAttribute(FIELD_SPECSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSpecBase.getUpdateDate() != null) {
            object = pSDevPrdSpecBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSpecBase.getUpdateMan() != null) {
            object = pSDevPrdSpecBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdSpecBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdSpecBase pSDevPrdSpecBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdSpecBase.isContentDirty() && (bl || pSDevPrdSpecBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDevPrdSpecBase.getContent());
        }
        if (pSDevPrdSpecBase.isCreateDateDirty() && (bl || pSDevPrdSpecBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdSpecBase.getCreateDate());
        }
        if (pSDevPrdSpecBase.isCreateManDirty() && (bl || pSDevPrdSpecBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdSpecBase.getCreateMan());
        }
        if (pSDevPrdSpecBase.isMemoDirty() && (bl || pSDevPrdSpecBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdSpecBase.getMemo());
        }
        if (pSDevPrdSpecBase.isPSDevPrdIdDirty() && (bl || pSDevPrdSpecBase.getPSDevPrdId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDID, (Object)pSDevPrdSpecBase.getPSDevPrdId());
        }
        if (pSDevPrdSpecBase.isPSDevPrdNameDirty() && (bl || pSDevPrdSpecBase.getPSDevPrdName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDNAME, (Object)pSDevPrdSpecBase.getPSDevPrdName());
        }
        if (pSDevPrdSpecBase.isPSDevPrdSpecIdDirty() && (bl || pSDevPrdSpecBase.getPSDevPrdSpecId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSPECID, (Object)pSDevPrdSpecBase.getPSDevPrdSpecId());
        }
        if (pSDevPrdSpecBase.isPSDevPrdSpecNameDirty() && (bl || pSDevPrdSpecBase.getPSDevPrdSpecName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSPECNAME, (Object)pSDevPrdSpecBase.getPSDevPrdSpecName());
        }
        if (pSDevPrdSpecBase.isPSDevPrdVerIdDirty() && (bl || pSDevPrdSpecBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSDevPrdSpecBase.getPSDevPrdVerId());
        }
        if (pSDevPrdSpecBase.isPSDevPrdVerNameDirty() && (bl || pSDevPrdSpecBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSDevPrdSpecBase.getPSDevPrdVerName());
        }
        if (pSDevPrdSpecBase.isSpecSNDirty() && (bl || pSDevPrdSpecBase.getSpecSN() != null)) {
            iDataObject.set(FIELD_SPECSN, (Object)pSDevPrdSpecBase.getSpecSN());
        }
        if (pSDevPrdSpecBase.isSpecStateDirty() && (bl || pSDevPrdSpecBase.getSpecState() != null)) {
            iDataObject.set(FIELD_SPECSTATE, (Object)pSDevPrdSpecBase.getSpecState());
        }
        if (pSDevPrdSpecBase.isUpdateDateDirty() && (bl || pSDevPrdSpecBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdSpecBase.getUpdateDate());
        }
        if (pSDevPrdSpecBase.isUpdateManDirty() && (bl || pSDevPrdSpecBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdSpecBase.getUpdateMan());
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
        return PSDevPrdSpecBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdSpecBase pSDevPrdSpecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSpecBase.resetContent();
                return true;
            }
            case 1: {
                pSDevPrdSpecBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevPrdSpecBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevPrdSpecBase.resetMemo();
                return true;
            }
            case 4: {
                pSDevPrdSpecBase.resetPSDevPrdId();
                return true;
            }
            case 5: {
                pSDevPrdSpecBase.resetPSDevPrdName();
                return true;
            }
            case 6: {
                pSDevPrdSpecBase.resetPSDevPrdSpecId();
                return true;
            }
            case 7: {
                pSDevPrdSpecBase.resetPSDevPrdSpecName();
                return true;
            }
            case 8: {
                pSDevPrdSpecBase.resetPSDevPrdVerId();
                return true;
            }
            case 9: {
                pSDevPrdSpecBase.resetPSDevPrdVerName();
                return true;
            }
            case 10: {
                pSDevPrdSpecBase.resetSpecSN();
                return true;
            }
            case 11: {
                pSDevPrdSpecBase.resetSpecState();
                return true;
            }
            case 12: {
                pSDevPrdSpecBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDevPrdSpecBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdVer getPSDevPrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVer();
        }
        if (this.getPSDevPrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdVerLock;
        synchronized (n) {
            if (this.psdevprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdVerId(), (Object)this.psdevprdver.getPSDevPrdVerId()) != 0L) {
                this.psdevprdver = null;
            }
            if (this.psdevprdver == null) {
                PSDevPrdVer pSDevPrdVer = new PSDevPrdVer();
                pSDevPrdVer.setPSDevPrdVerId(this.getPSDevPrdVerId());
                PSDevPrdVerService pSDevPrdVerService = (PSDevPrdVerService)ServiceGlobal.getService(PSDevPrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdVerService.autoGet(pSDevPrdVer);
                this.psdevprdver = pSDevPrdVer;
            }
            return this.psdevprdver;
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
                pSDevPrdService.autoGet(pSDevPrd);
                this.psdevprd = pSDevPrd;
            }
            return this.psdevprd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevPrdSpecPlan> getPSDevPrdSpecPlans() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecPlans();
        }
        if (this.getPSDevPrdSpecId() == null) {
            return null;
        }
        PSDevPrdSpecPlanService pSDevPrdSpecPlanService = (PSDevPrdSpecPlanService)ServiceGlobal.getService(PSDevPrdSpecPlanService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevPrdSpecPlansLock;
        synchronized (n) {
            if (this.psdevprdspecplans == null) {
                this.psdevprdspecplans = pSDevPrdSpecPlanService.selectByPSDevPrdSpec(this);
            }
            return this.psdevprdspecplans;
        }
    }

    private PSDevPrdSpecBase getProxyEntity() {
        return this.proxyPSDevPrdSpecBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdSpecBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdSpecBase) {
            this.proxyPSDevPrdSpecBase = (PSDevPrdSpecBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVPRDID, 4);
        fieldIndexMap.put(FIELD_PSDEVPRDNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVPRDSPECID, 6);
        fieldIndexMap.put(FIELD_PSDEVPRDSPECNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 8);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 9);
        fieldIndexMap.put(FIELD_SPECSN, 10);
        fieldIndexMap.put(FIELD_SPECSTATE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

