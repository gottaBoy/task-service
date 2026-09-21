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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCPVFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCPVFuncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCSN = "FUNCSN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCOREPRDFUNCID = "PSCOREPRDFUNCID";
    public static final String FIELD_PSCOREPRDFUNCNAME = "PSCOREPRDFUNCNAME";
    public static final String FIELD_PSCOREPRDVERID = "PSCOREPRDVERID";
    public static final String FIELD_PSCOREPRDVERNAME = "PSCOREPRDVERNAME";
    public static final String FIELD_PSCPVFUNCID = "PSCPVFUNCID";
    public static final String FIELD_PSCPVFUNCNAME = "PSCPVFUNCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FUNCSN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSCOREPRDFUNCID = 4;
    private static final int INDEX_PSCOREPRDFUNCNAME = 5;
    private static final int INDEX_PSCOREPRDVERID = 6;
    private static final int INDEX_PSCOREPRDVERNAME = 7;
    private static final int INDEX_PSCPVFUNCID = 8;
    private static final int INDEX_PSCPVFUNCNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCPVFuncBase proxyPSCPVFuncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean funcsnDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscoreprdfuncidDirtyFlag = false;
    private boolean pscoreprdfuncnameDirtyFlag = false;
    private boolean pscoreprdveridDirtyFlag = false;
    private boolean pscoreprdvernameDirtyFlag = false;
    private boolean pscpvfuncidDirtyFlag = false;
    private boolean pscpvfuncnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="funcsn")
    private Integer funcsn;
    @Column(name="memo")
    private String memo;
    @Column(name="pscoreprdfuncid")
    private String pscoreprdfuncid;
    @Column(name="pscoreprdfuncname")
    private String pscoreprdfuncname;
    @Column(name="pscoreprdverid")
    private String pscoreprdverid;
    @Column(name="pscoreprdvername")
    private String pscoreprdvername;
    @Column(name="pscpvfuncid")
    private String pscpvfuncid;
    @Column(name="pscpvfuncname")
    private String pscpvfuncname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCorePrdFuncLock = new Integer(1);
    private PSCorePrdFunc pscoreprdfunc = null;
    private Integer objPSCorePrdVerLock = new Integer(1);
    private PSCorePrdVer pscoreprdver = null;

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

    public void setFuncSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncSN(n);
            return;
        }
        this.funcsn = n;
        this.funcsnDirtyFlag = true;
    }

    public Integer getFuncSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncSN();
        }
        return this.funcsn;
    }

    public boolean isFuncSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncSNDirty();
        }
        return this.funcsnDirtyFlag;
    }

    public void resetFuncSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncSN();
            return;
        }
        this.funcsnDirtyFlag = false;
        this.funcsn = null;
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

    public void setPSCorePrdFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdfuncid = string;
        this.pscoreprdfuncidDirtyFlag = true;
    }

    public String getPSCorePrdFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFuncId();
        }
        return this.pscoreprdfuncid;
    }

    public boolean isPSCorePrdFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdFuncIdDirty();
        }
        return this.pscoreprdfuncidDirtyFlag;
    }

    public void resetPSCorePrdFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdFuncId();
            return;
        }
        this.pscoreprdfuncidDirtyFlag = false;
        this.pscoreprdfuncid = null;
    }

    public void setPSCorePrdFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdfuncname = string;
        this.pscoreprdfuncnameDirtyFlag = true;
    }

    public String getPSCorePrdFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFuncName();
        }
        return this.pscoreprdfuncname;
    }

    public boolean isPSCorePrdFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdFuncNameDirty();
        }
        return this.pscoreprdfuncnameDirtyFlag;
    }

    public void resetPSCorePrdFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdFuncName();
            return;
        }
        this.pscoreprdfuncnameDirtyFlag = false;
        this.pscoreprdfuncname = null;
    }

    public void setPSCorePrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdverid = string;
        this.pscoreprdveridDirtyFlag = true;
    }

    public String getPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerId();
        }
        return this.pscoreprdverid;
    }

    public boolean isPSCorePrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerIdDirty();
        }
        return this.pscoreprdveridDirtyFlag;
    }

    public void resetPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerId();
            return;
        }
        this.pscoreprdveridDirtyFlag = false;
        this.pscoreprdverid = null;
    }

    public void setPSCorePrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdvername = string;
        this.pscoreprdvernameDirtyFlag = true;
    }

    public String getPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerName();
        }
        return this.pscoreprdvername;
    }

    public boolean isPSCorePrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerNameDirty();
        }
        return this.pscoreprdvernameDirtyFlag;
    }

    public void resetPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerName();
            return;
        }
        this.pscoreprdvernameDirtyFlag = false;
        this.pscoreprdvername = null;
    }

    public void setPSCPVFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCPVFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscpvfuncid = string;
        this.pscpvfuncidDirtyFlag = true;
    }

    public String getPSCPVFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCPVFuncId();
        }
        return this.pscpvfuncid;
    }

    public boolean isPSCPVFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCPVFuncIdDirty();
        }
        return this.pscpvfuncidDirtyFlag;
    }

    public void resetPSCPVFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCPVFuncId();
            return;
        }
        this.pscpvfuncidDirtyFlag = false;
        this.pscpvfuncid = null;
    }

    public void setPSCPVFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCPVFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscpvfuncname = string;
        this.pscpvfuncnameDirtyFlag = true;
    }

    public String getPSCPVFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCPVFuncName();
        }
        return this.pscpvfuncname;
    }

    public boolean isPSCPVFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCPVFuncNameDirty();
        }
        return this.pscpvfuncnameDirtyFlag;
    }

    public void resetPSCPVFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCPVFuncName();
            return;
        }
        this.pscpvfuncnameDirtyFlag = false;
        this.pscpvfuncname = null;
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
        PSCPVFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCPVFuncBase pSCPVFuncBase) {
        pSCPVFuncBase.resetCreateDate();
        pSCPVFuncBase.resetCreateMan();
        pSCPVFuncBase.resetFuncSN();
        pSCPVFuncBase.resetMemo();
        pSCPVFuncBase.resetPSCorePrdFuncId();
        pSCPVFuncBase.resetPSCorePrdFuncName();
        pSCPVFuncBase.resetPSCorePrdVerId();
        pSCPVFuncBase.resetPSCorePrdVerName();
        pSCPVFuncBase.resetPSCPVFuncId();
        pSCPVFuncBase.resetPSCPVFuncName();
        pSCPVFuncBase.resetUpdateDate();
        pSCPVFuncBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFuncSNDirty()) {
            hashMap.put(FIELD_FUNCSN, this.getFuncSN());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCorePrdFuncIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDFUNCID, this.getPSCorePrdFuncId());
        }
        if (!bl || this.isPSCorePrdFuncNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDFUNCNAME, this.getPSCorePrdFuncName());
        }
        if (!bl || this.isPSCorePrdVerIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERID, this.getPSCorePrdVerId());
        }
        if (!bl || this.isPSCorePrdVerNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERNAME, this.getPSCorePrdVerName());
        }
        if (!bl || this.isPSCPVFuncIdDirty()) {
            hashMap.put(FIELD_PSCPVFUNCID, this.getPSCPVFuncId());
        }
        if (!bl || this.isPSCPVFuncNameDirty()) {
            hashMap.put(FIELD_PSCPVFUNCNAME, this.getPSCPVFuncName());
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
        return PSCPVFuncBase.get(this, n);
    }

    private static Object get(PSCPVFuncBase pSCPVFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCPVFuncBase.getCreateDate();
            }
            case 1: {
                return pSCPVFuncBase.getCreateMan();
            }
            case 2: {
                return pSCPVFuncBase.getFuncSN();
            }
            case 3: {
                return pSCPVFuncBase.getMemo();
            }
            case 4: {
                return pSCPVFuncBase.getPSCorePrdFuncId();
            }
            case 5: {
                return pSCPVFuncBase.getPSCorePrdFuncName();
            }
            case 6: {
                return pSCPVFuncBase.getPSCorePrdVerId();
            }
            case 7: {
                return pSCPVFuncBase.getPSCorePrdVerName();
            }
            case 8: {
                return pSCPVFuncBase.getPSCPVFuncId();
            }
            case 9: {
                return pSCPVFuncBase.getPSCPVFuncName();
            }
            case 10: {
                return pSCPVFuncBase.getUpdateDate();
            }
            case 11: {
                return pSCPVFuncBase.getUpdateMan();
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
        PSCPVFuncBase.set(this, n, object);
    }

    private static void set(PSCPVFuncBase pSCPVFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCPVFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCPVFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCPVFuncBase.setFuncSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSCPVFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCPVFuncBase.setPSCorePrdFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCPVFuncBase.setPSCorePrdFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCPVFuncBase.setPSCorePrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCPVFuncBase.setPSCorePrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCPVFuncBase.setPSCPVFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCPVFuncBase.setPSCPVFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCPVFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSCPVFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCPVFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSCPVFuncBase pSCPVFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCPVFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSCPVFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSCPVFuncBase.getFuncSN() == null;
            }
            case 3: {
                return pSCPVFuncBase.getMemo() == null;
            }
            case 4: {
                return pSCPVFuncBase.getPSCorePrdFuncId() == null;
            }
            case 5: {
                return pSCPVFuncBase.getPSCorePrdFuncName() == null;
            }
            case 6: {
                return pSCPVFuncBase.getPSCorePrdVerId() == null;
            }
            case 7: {
                return pSCPVFuncBase.getPSCorePrdVerName() == null;
            }
            case 8: {
                return pSCPVFuncBase.getPSCPVFuncId() == null;
            }
            case 9: {
                return pSCPVFuncBase.getPSCPVFuncName() == null;
            }
            case 10: {
                return pSCPVFuncBase.getUpdateDate() == null;
            }
            case 11: {
                return pSCPVFuncBase.getUpdateMan() == null;
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
        return PSCPVFuncBase.contains(this, n);
    }

    private static boolean contains(PSCPVFuncBase pSCPVFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCPVFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSCPVFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSCPVFuncBase.isFuncSNDirty();
            }
            case 3: {
                return pSCPVFuncBase.isMemoDirty();
            }
            case 4: {
                return pSCPVFuncBase.isPSCorePrdFuncIdDirty();
            }
            case 5: {
                return pSCPVFuncBase.isPSCorePrdFuncNameDirty();
            }
            case 6: {
                return pSCPVFuncBase.isPSCorePrdVerIdDirty();
            }
            case 7: {
                return pSCPVFuncBase.isPSCorePrdVerNameDirty();
            }
            case 8: {
                return pSCPVFuncBase.isPSCPVFuncIdDirty();
            }
            case 9: {
                return pSCPVFuncBase.isPSCPVFuncNameDirty();
            }
            case 10: {
                return pSCPVFuncBase.isUpdateDateDirty();
            }
            case 11: {
                return pSCPVFuncBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCPVFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCPVFuncBase pSCPVFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCPVFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getFuncSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcsn", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getFuncSN()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getPSCorePrdFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdfuncid", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getPSCorePrdFuncId()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getPSCorePrdFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdfuncname", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getPSCorePrdFuncName()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getPSCorePrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdverid", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getPSCorePrdVerId()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getPSCorePrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdvername", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getPSCorePrdVerName()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getPSCPVFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscpvfuncid", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getPSCPVFuncId()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getPSCPVFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscpvfuncname", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getPSCPVFuncName()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCPVFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCPVFuncBase.getJSONValue((Object)pSCPVFuncBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCPVFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCPVFuncBase pSCPVFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCPVFuncBase.getCreateDate() != null) {
            object = pSCPVFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCPVFuncBase.getCreateMan() != null) {
            object = pSCPVFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCPVFuncBase.getFuncSN() != null) {
            object = pSCPVFuncBase.getFuncSN();
            xmlNode.setAttribute(FIELD_FUNCSN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCPVFuncBase.getMemo() != null) {
            object = pSCPVFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCPVFuncBase.getPSCorePrdFuncId() != null) {
            object = pSCPVFuncBase.getPSCorePrdFuncId();
            xmlNode.setAttribute(FIELD_PSCOREPRDFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSCPVFuncBase.getPSCorePrdFuncName() != null) {
            object = pSCPVFuncBase.getPSCorePrdFuncName();
            xmlNode.setAttribute(FIELD_PSCOREPRDFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCPVFuncBase.getPSCorePrdVerId() != null) {
            object = pSCPVFuncBase.getPSCorePrdVerId();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCPVFuncBase.getPSCorePrdVerName() != null) {
            object = pSCPVFuncBase.getPSCorePrdVerName();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCPVFuncBase.getPSCPVFuncId() != null) {
            object = pSCPVFuncBase.getPSCPVFuncId();
            xmlNode.setAttribute(FIELD_PSCPVFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSCPVFuncBase.getPSCPVFuncName() != null) {
            object = pSCPVFuncBase.getPSCPVFuncName();
            xmlNode.setAttribute(FIELD_PSCPVFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCPVFuncBase.getUpdateDate() != null) {
            object = pSCPVFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCPVFuncBase.getUpdateMan() != null) {
            object = pSCPVFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCPVFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCPVFuncBase pSCPVFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCPVFuncBase.isCreateDateDirty() && (bl || pSCPVFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCPVFuncBase.getCreateDate());
        }
        if (pSCPVFuncBase.isCreateManDirty() && (bl || pSCPVFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCPVFuncBase.getCreateMan());
        }
        if (pSCPVFuncBase.isFuncSNDirty() && (bl || pSCPVFuncBase.getFuncSN() != null)) {
            iDataObject.set(FIELD_FUNCSN, (Object)pSCPVFuncBase.getFuncSN());
        }
        if (pSCPVFuncBase.isMemoDirty() && (bl || pSCPVFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCPVFuncBase.getMemo());
        }
        if (pSCPVFuncBase.isPSCorePrdFuncIdDirty() && (bl || pSCPVFuncBase.getPSCorePrdFuncId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDFUNCID, (Object)pSCPVFuncBase.getPSCorePrdFuncId());
        }
        if (pSCPVFuncBase.isPSCorePrdFuncNameDirty() && (bl || pSCPVFuncBase.getPSCorePrdFuncName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDFUNCNAME, (Object)pSCPVFuncBase.getPSCorePrdFuncName());
        }
        if (pSCPVFuncBase.isPSCorePrdVerIdDirty() && (bl || pSCPVFuncBase.getPSCorePrdVerId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERID, (Object)pSCPVFuncBase.getPSCorePrdVerId());
        }
        if (pSCPVFuncBase.isPSCorePrdVerNameDirty() && (bl || pSCPVFuncBase.getPSCorePrdVerName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERNAME, (Object)pSCPVFuncBase.getPSCorePrdVerName());
        }
        if (pSCPVFuncBase.isPSCPVFuncIdDirty() && (bl || pSCPVFuncBase.getPSCPVFuncId() != null)) {
            iDataObject.set(FIELD_PSCPVFUNCID, (Object)pSCPVFuncBase.getPSCPVFuncId());
        }
        if (pSCPVFuncBase.isPSCPVFuncNameDirty() && (bl || pSCPVFuncBase.getPSCPVFuncName() != null)) {
            iDataObject.set(FIELD_PSCPVFUNCNAME, (Object)pSCPVFuncBase.getPSCPVFuncName());
        }
        if (pSCPVFuncBase.isUpdateDateDirty() && (bl || pSCPVFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCPVFuncBase.getUpdateDate());
        }
        if (pSCPVFuncBase.isUpdateManDirty() && (bl || pSCPVFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCPVFuncBase.getUpdateMan());
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
        return PSCPVFuncBase.remove(this, n);
    }

    private static boolean remove(PSCPVFuncBase pSCPVFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCPVFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCPVFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCPVFuncBase.resetFuncSN();
                return true;
            }
            case 3: {
                pSCPVFuncBase.resetMemo();
                return true;
            }
            case 4: {
                pSCPVFuncBase.resetPSCorePrdFuncId();
                return true;
            }
            case 5: {
                pSCPVFuncBase.resetPSCorePrdFuncName();
                return true;
            }
            case 6: {
                pSCPVFuncBase.resetPSCorePrdVerId();
                return true;
            }
            case 7: {
                pSCPVFuncBase.resetPSCorePrdVerName();
                return true;
            }
            case 8: {
                pSCPVFuncBase.resetPSCPVFuncId();
                return true;
            }
            case 9: {
                pSCPVFuncBase.resetPSCPVFuncName();
                return true;
            }
            case 10: {
                pSCPVFuncBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSCPVFuncBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdFunc getPSCorePrdFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFunc();
        }
        if (this.getPSCorePrdFuncId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdFuncLock;
        synchronized (n) {
            if (this.pscoreprdfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdFuncId(), (Object)this.pscoreprdfunc.getPSCorePrdFuncId()) != 0L) {
                this.pscoreprdfunc = null;
            }
            if (this.pscoreprdfunc == null) {
                PSCorePrdFunc pSCorePrdFunc = new PSCorePrdFunc();
                pSCorePrdFunc.setPSCorePrdFuncId(this.getPSCorePrdFuncId());
                PSCorePrdFuncService pSCorePrdFuncService = (PSCorePrdFuncService)ServiceGlobal.getService(PSCorePrdFuncService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdFuncService.autoGet((IEntity)pSCorePrdFunc);
                this.pscoreprdfunc = pSCorePrdFunc;
            }
            return this.pscoreprdfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdVer getPSCorePrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVer();
        }
        if (this.getPSCorePrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdVerLock;
        synchronized (n) {
            if (this.pscoreprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdVerId(), (Object)this.pscoreprdver.getPSCorePrdVerId()) != 0L) {
                this.pscoreprdver = null;
            }
            if (this.pscoreprdver == null) {
                PSCorePrdVer pSCorePrdVer = new PSCorePrdVer();
                pSCorePrdVer.setPSCorePrdVerId(this.getPSCorePrdVerId());
                PSCorePrdVerService pSCorePrdVerService = (PSCorePrdVerService)ServiceGlobal.getService(PSCorePrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdVerService.autoGet((IEntity)pSCorePrdVer);
                this.pscoreprdver = pSCorePrdVer;
            }
            return this.pscoreprdver;
        }
    }

    private PSCPVFuncBase getProxyEntity() {
        return this.proxyPSCPVFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCPVFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSCPVFuncBase) {
            this.proxyPSCPVFuncBase = (PSCPVFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCPVFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FUNCSN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSCOREPRDFUNCID, 4);
        fieldIndexMap.put(FIELD_PSCOREPRDFUNCNAME, 5);
        fieldIndexMap.put(FIELD_PSCOREPRDVERID, 6);
        fieldIndexMap.put(FIELD_PSCOREPRDVERNAME, 7);
        fieldIndexMap.put(FIELD_PSCPVFUNCID, 8);
        fieldIndexMap.put(FIELD_PSCPVFUNCNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

