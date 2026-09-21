/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEInitCfgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEInitCfgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IGNOREDBMODEL = "IGNOREDBMODEL";
    public static final String FIELD_IGNOREEXTMODEL = "IGNOREEXTMODEL";
    public static final String FIELD_IGNOREMGRMODEL = "IGNOREMGRMODEL";
    public static final String FIELD_IGNOREUIMODEL = "IGNOREUIMODEL";
    public static final String FIELD_INITUIFLAG = "INITUIFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEINITCFGID = "PSDEINITCFGID";
    public static final String FIELD_PSDEINITCFGNAME = "PSDEINITCFGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_IGNOREDBMODEL = 2;
    private static final int INDEX_IGNOREEXTMODEL = 3;
    private static final int INDEX_IGNOREMGRMODEL = 4;
    private static final int INDEX_IGNOREUIMODEL = 5;
    private static final int INDEX_INITUIFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEINITCFGID = 8;
    private static final int INDEX_PSDEINITCFGNAME = 9;
    private static final int INDEX_PSSYSTEMID = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEInitCfgBase proxyPSDEInitCfgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ignoredbmodelDirtyFlag = false;
    private boolean ignoreextmodelDirtyFlag = false;
    private boolean ignoremgrmodelDirtyFlag = false;
    private boolean ignoreuimodelDirtyFlag = false;
    private boolean inituiflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeinitcfgidDirtyFlag = false;
    private boolean psdeinitcfgnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ignoredbmodel")
    private Integer ignoredbmodel;
    @Column(name="ignoreextmodel")
    private Integer ignoreextmodel;
    @Column(name="ignoremgrmodel")
    private Integer ignoremgrmodel;
    @Column(name="ignoreuimodel")
    private Integer ignoreuimodel;
    @Column(name="inituiflag")
    private Integer inituiflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeinitcfgid")
    private String psdeinitcfgid;
    @Column(name="psdeinitcfgname")
    private String psdeinitcfgname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setIgnoreDBModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreDBModel(n);
            return;
        }
        this.ignoredbmodel = n;
        this.ignoredbmodelDirtyFlag = true;
    }

    public Integer getIgnoreDBModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreDBModel();
        }
        return this.ignoredbmodel;
    }

    public boolean isIgnoreDBModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreDBModelDirty();
        }
        return this.ignoredbmodelDirtyFlag;
    }

    public void resetIgnoreDBModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreDBModel();
            return;
        }
        this.ignoredbmodelDirtyFlag = false;
        this.ignoredbmodel = null;
    }

    public void setIgnoreExtModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreExtModel(n);
            return;
        }
        this.ignoreextmodel = n;
        this.ignoreextmodelDirtyFlag = true;
    }

    public Integer getIgnoreExtModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreExtModel();
        }
        return this.ignoreextmodel;
    }

    public boolean isIgnoreExtModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreExtModelDirty();
        }
        return this.ignoreextmodelDirtyFlag;
    }

    public void resetIgnoreExtModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreExtModel();
            return;
        }
        this.ignoreextmodelDirtyFlag = false;
        this.ignoreextmodel = null;
    }

    public void setIgnoreMgrModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreMgrModel(n);
            return;
        }
        this.ignoremgrmodel = n;
        this.ignoremgrmodelDirtyFlag = true;
    }

    public Integer getIgnoreMgrModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreMgrModel();
        }
        return this.ignoremgrmodel;
    }

    public boolean isIgnoreMgrModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreMgrModelDirty();
        }
        return this.ignoremgrmodelDirtyFlag;
    }

    public void resetIgnoreMgrModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreMgrModel();
            return;
        }
        this.ignoremgrmodelDirtyFlag = false;
        this.ignoremgrmodel = null;
    }

    public void setIgnoreUIModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreUIModel(n);
            return;
        }
        this.ignoreuimodel = n;
        this.ignoreuimodelDirtyFlag = true;
    }

    public Integer getIgnoreUIModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreUIModel();
        }
        return this.ignoreuimodel;
    }

    public boolean isIgnoreUIModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreUIModelDirty();
        }
        return this.ignoreuimodelDirtyFlag;
    }

    public void resetIgnoreUIModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreUIModel();
            return;
        }
        this.ignoreuimodelDirtyFlag = false;
        this.ignoreuimodel = null;
    }

    public void setInitUIFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitUIFlag(n);
            return;
        }
        this.inituiflag = n;
        this.inituiflagDirtyFlag = true;
    }

    public Integer getInitUIFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitUIFlag();
        }
        return this.inituiflag;
    }

    public boolean isInitUIFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitUIFlagDirty();
        }
        return this.inituiflagDirtyFlag;
    }

    public void resetInitUIFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitUIFlag();
            return;
        }
        this.inituiflagDirtyFlag = false;
        this.inituiflag = null;
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

    public void setPSDEInitCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEInitCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeinitcfgid = string;
        this.psdeinitcfgidDirtyFlag = true;
    }

    public String getPSDEInitCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEInitCfgId();
        }
        return this.psdeinitcfgid;
    }

    public boolean isPSDEInitCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEInitCfgIdDirty();
        }
        return this.psdeinitcfgidDirtyFlag;
    }

    public void resetPSDEInitCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEInitCfgId();
            return;
        }
        this.psdeinitcfgidDirtyFlag = false;
        this.psdeinitcfgid = null;
    }

    public void setPSDEInitCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEInitCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeinitcfgname = string;
        this.psdeinitcfgnameDirtyFlag = true;
    }

    public String getPSDEInitCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEInitCfgName();
        }
        return this.psdeinitcfgname;
    }

    public boolean isPSDEInitCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEInitCfgNameDirty();
        }
        return this.psdeinitcfgnameDirtyFlag;
    }

    public void resetPSDEInitCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEInitCfgName();
            return;
        }
        this.psdeinitcfgnameDirtyFlag = false;
        this.psdeinitcfgname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
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
        PSDEInitCfgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEInitCfgBase pSDEInitCfgBase) {
        pSDEInitCfgBase.resetCreateDate();
        pSDEInitCfgBase.resetCreateMan();
        pSDEInitCfgBase.resetIgnoreDBModel();
        pSDEInitCfgBase.resetIgnoreExtModel();
        pSDEInitCfgBase.resetIgnoreMgrModel();
        pSDEInitCfgBase.resetIgnoreUIModel();
        pSDEInitCfgBase.resetInitUIFlag();
        pSDEInitCfgBase.resetMemo();
        pSDEInitCfgBase.resetPSDEInitCfgId();
        pSDEInitCfgBase.resetPSDEInitCfgName();
        pSDEInitCfgBase.resetPSSystemId();
        pSDEInitCfgBase.resetUpdateDate();
        pSDEInitCfgBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIgnoreDBModelDirty()) {
            hashMap.put(FIELD_IGNOREDBMODEL, this.getIgnoreDBModel());
        }
        if (!bl || this.isIgnoreExtModelDirty()) {
            hashMap.put(FIELD_IGNOREEXTMODEL, this.getIgnoreExtModel());
        }
        if (!bl || this.isIgnoreMgrModelDirty()) {
            hashMap.put(FIELD_IGNOREMGRMODEL, this.getIgnoreMgrModel());
        }
        if (!bl || this.isIgnoreUIModelDirty()) {
            hashMap.put(FIELD_IGNOREUIMODEL, this.getIgnoreUIModel());
        }
        if (!bl || this.isInitUIFlagDirty()) {
            hashMap.put(FIELD_INITUIFLAG, this.getInitUIFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEInitCfgIdDirty()) {
            hashMap.put(FIELD_PSDEINITCFGID, this.getPSDEInitCfgId());
        }
        if (!bl || this.isPSDEInitCfgNameDirty()) {
            hashMap.put(FIELD_PSDEINITCFGNAME, this.getPSDEInitCfgName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
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
        return PSDEInitCfgBase.get(this, n);
    }

    private static Object get(PSDEInitCfgBase pSDEInitCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEInitCfgBase.getCreateDate();
            }
            case 1: {
                return pSDEInitCfgBase.getCreateMan();
            }
            case 2: {
                return pSDEInitCfgBase.getIgnoreDBModel();
            }
            case 3: {
                return pSDEInitCfgBase.getIgnoreExtModel();
            }
            case 4: {
                return pSDEInitCfgBase.getIgnoreMgrModel();
            }
            case 5: {
                return pSDEInitCfgBase.getIgnoreUIModel();
            }
            case 6: {
                return pSDEInitCfgBase.getInitUIFlag();
            }
            case 7: {
                return pSDEInitCfgBase.getMemo();
            }
            case 8: {
                return pSDEInitCfgBase.getPSDEInitCfgId();
            }
            case 9: {
                return pSDEInitCfgBase.getPSDEInitCfgName();
            }
            case 10: {
                return pSDEInitCfgBase.getPSSystemId();
            }
            case 11: {
                return pSDEInitCfgBase.getUpdateDate();
            }
            case 12: {
                return pSDEInitCfgBase.getUpdateMan();
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
        PSDEInitCfgBase.set(this, n, object);
    }

    private static void set(PSDEInitCfgBase pSDEInitCfgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEInitCfgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEInitCfgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEInitCfgBase.setIgnoreDBModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEInitCfgBase.setIgnoreExtModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEInitCfgBase.setIgnoreMgrModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEInitCfgBase.setIgnoreUIModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEInitCfgBase.setInitUIFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEInitCfgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEInitCfgBase.setPSDEInitCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEInitCfgBase.setPSDEInitCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEInitCfgBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEInitCfgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDEInitCfgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEInitCfgBase.isNull(this, n);
    }

    private static boolean isNull(PSDEInitCfgBase pSDEInitCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEInitCfgBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEInitCfgBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEInitCfgBase.getIgnoreDBModel() == null;
            }
            case 3: {
                return pSDEInitCfgBase.getIgnoreExtModel() == null;
            }
            case 4: {
                return pSDEInitCfgBase.getIgnoreMgrModel() == null;
            }
            case 5: {
                return pSDEInitCfgBase.getIgnoreUIModel() == null;
            }
            case 6: {
                return pSDEInitCfgBase.getInitUIFlag() == null;
            }
            case 7: {
                return pSDEInitCfgBase.getMemo() == null;
            }
            case 8: {
                return pSDEInitCfgBase.getPSDEInitCfgId() == null;
            }
            case 9: {
                return pSDEInitCfgBase.getPSDEInitCfgName() == null;
            }
            case 10: {
                return pSDEInitCfgBase.getPSSystemId() == null;
            }
            case 11: {
                return pSDEInitCfgBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDEInitCfgBase.getUpdateMan() == null;
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
        return PSDEInitCfgBase.contains(this, n);
    }

    private static boolean contains(PSDEInitCfgBase pSDEInitCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEInitCfgBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEInitCfgBase.isCreateManDirty();
            }
            case 2: {
                return pSDEInitCfgBase.isIgnoreDBModelDirty();
            }
            case 3: {
                return pSDEInitCfgBase.isIgnoreExtModelDirty();
            }
            case 4: {
                return pSDEInitCfgBase.isIgnoreMgrModelDirty();
            }
            case 5: {
                return pSDEInitCfgBase.isIgnoreUIModelDirty();
            }
            case 6: {
                return pSDEInitCfgBase.isInitUIFlagDirty();
            }
            case 7: {
                return pSDEInitCfgBase.isMemoDirty();
            }
            case 8: {
                return pSDEInitCfgBase.isPSDEInitCfgIdDirty();
            }
            case 9: {
                return pSDEInitCfgBase.isPSDEInitCfgNameDirty();
            }
            case 10: {
                return pSDEInitCfgBase.isPSSystemIdDirty();
            }
            case 11: {
                return pSDEInitCfgBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDEInitCfgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEInitCfgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEInitCfgBase pSDEInitCfgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEInitCfgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getIgnoreDBModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoredbmodel", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getIgnoreDBModel()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getIgnoreExtModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreextmodel", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getIgnoreExtModel()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getIgnoreMgrModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoremgrmodel", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getIgnoreMgrModel()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getIgnoreUIModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreuimodel", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getIgnoreUIModel()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getInitUIFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inituiflag", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getInitUIFlag()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getPSDEInitCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeinitcfgid", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getPSDEInitCfgId()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getPSDEInitCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeinitcfgname", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getPSDEInitCfgName()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEInitCfgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEInitCfgBase.getJSONValue((Object)pSDEInitCfgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEInitCfgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEInitCfgBase pSDEInitCfgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEInitCfgBase.getCreateDate() != null) {
            object = pSDEInitCfgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEInitCfgBase.getCreateMan() != null) {
            object = pSDEInitCfgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEInitCfgBase.getIgnoreDBModel() != null) {
            object = pSDEInitCfgBase.getIgnoreDBModel();
            xmlNode.setAttribute(FIELD_IGNOREDBMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEInitCfgBase.getIgnoreExtModel() != null) {
            object = pSDEInitCfgBase.getIgnoreExtModel();
            xmlNode.setAttribute(FIELD_IGNOREEXTMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEInitCfgBase.getIgnoreMgrModel() != null) {
            object = pSDEInitCfgBase.getIgnoreMgrModel();
            xmlNode.setAttribute(FIELD_IGNOREMGRMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEInitCfgBase.getIgnoreUIModel() != null) {
            object = pSDEInitCfgBase.getIgnoreUIModel();
            xmlNode.setAttribute(FIELD_IGNOREUIMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEInitCfgBase.getInitUIFlag() != null) {
            object = pSDEInitCfgBase.getInitUIFlag();
            xmlNode.setAttribute(FIELD_INITUIFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEInitCfgBase.getMemo() != null) {
            object = pSDEInitCfgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEInitCfgBase.getPSDEInitCfgId() != null) {
            object = pSDEInitCfgBase.getPSDEInitCfgId();
            xmlNode.setAttribute(FIELD_PSDEINITCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEInitCfgBase.getPSDEInitCfgName() != null) {
            object = pSDEInitCfgBase.getPSDEInitCfgName();
            xmlNode.setAttribute(FIELD_PSDEINITCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEInitCfgBase.getPSSystemId() != null) {
            object = pSDEInitCfgBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEInitCfgBase.getUpdateDate() != null) {
            object = pSDEInitCfgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEInitCfgBase.getUpdateMan() != null) {
            object = pSDEInitCfgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEInitCfgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEInitCfgBase pSDEInitCfgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEInitCfgBase.isCreateDateDirty() && (bl || pSDEInitCfgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEInitCfgBase.getCreateDate());
        }
        if (pSDEInitCfgBase.isCreateManDirty() && (bl || pSDEInitCfgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEInitCfgBase.getCreateMan());
        }
        if (pSDEInitCfgBase.isIgnoreDBModelDirty() && (bl || pSDEInitCfgBase.getIgnoreDBModel() != null)) {
            iDataObject.set(FIELD_IGNOREDBMODEL, (Object)pSDEInitCfgBase.getIgnoreDBModel());
        }
        if (pSDEInitCfgBase.isIgnoreExtModelDirty() && (bl || pSDEInitCfgBase.getIgnoreExtModel() != null)) {
            iDataObject.set(FIELD_IGNOREEXTMODEL, (Object)pSDEInitCfgBase.getIgnoreExtModel());
        }
        if (pSDEInitCfgBase.isIgnoreMgrModelDirty() && (bl || pSDEInitCfgBase.getIgnoreMgrModel() != null)) {
            iDataObject.set(FIELD_IGNOREMGRMODEL, (Object)pSDEInitCfgBase.getIgnoreMgrModel());
        }
        if (pSDEInitCfgBase.isIgnoreUIModelDirty() && (bl || pSDEInitCfgBase.getIgnoreUIModel() != null)) {
            iDataObject.set(FIELD_IGNOREUIMODEL, (Object)pSDEInitCfgBase.getIgnoreUIModel());
        }
        if (pSDEInitCfgBase.isInitUIFlagDirty() && (bl || pSDEInitCfgBase.getInitUIFlag() != null)) {
            iDataObject.set(FIELD_INITUIFLAG, (Object)pSDEInitCfgBase.getInitUIFlag());
        }
        if (pSDEInitCfgBase.isMemoDirty() && (bl || pSDEInitCfgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEInitCfgBase.getMemo());
        }
        if (pSDEInitCfgBase.isPSDEInitCfgIdDirty() && (bl || pSDEInitCfgBase.getPSDEInitCfgId() != null)) {
            iDataObject.set(FIELD_PSDEINITCFGID, (Object)pSDEInitCfgBase.getPSDEInitCfgId());
        }
        if (pSDEInitCfgBase.isPSDEInitCfgNameDirty() && (bl || pSDEInitCfgBase.getPSDEInitCfgName() != null)) {
            iDataObject.set(FIELD_PSDEINITCFGNAME, (Object)pSDEInitCfgBase.getPSDEInitCfgName());
        }
        if (pSDEInitCfgBase.isPSSystemIdDirty() && (bl || pSDEInitCfgBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEInitCfgBase.getPSSystemId());
        }
        if (pSDEInitCfgBase.isUpdateDateDirty() && (bl || pSDEInitCfgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEInitCfgBase.getUpdateDate());
        }
        if (pSDEInitCfgBase.isUpdateManDirty() && (bl || pSDEInitCfgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEInitCfgBase.getUpdateMan());
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
        return PSDEInitCfgBase.remove(this, n);
    }

    private static boolean remove(PSDEInitCfgBase pSDEInitCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEInitCfgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEInitCfgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEInitCfgBase.resetIgnoreDBModel();
                return true;
            }
            case 3: {
                pSDEInitCfgBase.resetIgnoreExtModel();
                return true;
            }
            case 4: {
                pSDEInitCfgBase.resetIgnoreMgrModel();
                return true;
            }
            case 5: {
                pSDEInitCfgBase.resetIgnoreUIModel();
                return true;
            }
            case 6: {
                pSDEInitCfgBase.resetInitUIFlag();
                return true;
            }
            case 7: {
                pSDEInitCfgBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEInitCfgBase.resetPSDEInitCfgId();
                return true;
            }
            case 9: {
                pSDEInitCfgBase.resetPSDEInitCfgName();
                return true;
            }
            case 10: {
                pSDEInitCfgBase.resetPSSystemId();
                return true;
            }
            case 11: {
                pSDEInitCfgBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDEInitCfgBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEInitCfgBase getProxyEntity() {
        return this.proxyPSDEInitCfgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEInitCfgBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEInitCfgBase) {
            this.proxyPSDEInitCfgBase = (PSDEInitCfgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDEInitCfgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_IGNOREDBMODEL, 2);
        fieldIndexMap.put(FIELD_IGNOREEXTMODEL, 3);
        fieldIndexMap.put(FIELD_IGNOREMGRMODEL, 4);
        fieldIndexMap.put(FIELD_IGNOREUIMODEL, 5);
        fieldIndexMap.put(FIELD_INITUIFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEINITCFGID, 8);
        fieldIndexMap.put(FIELD_PSDEINITCFGNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

