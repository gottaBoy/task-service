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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelMemo;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelMemoService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelMemoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelMemoBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSMODELMEMOID = "PPSMODELMEMOID";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSMODELMEMOID = "PSMODELMEMOID";
    public static final String FIELD_PSMODELMEMONAME = "PSMODELMEMONAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSOBJTYPENAME = "PSOBJTYPENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PPSMODELMEMOID = 3;
    private static final int INDEX_PSDEFID = 4;
    private static final int INDEX_PSDEFNAME = 5;
    private static final int INDEX_PSMODELMEMOID = 6;
    private static final int INDEX_PSMODELMEMONAME = 7;
    private static final int INDEX_PSOBJID = 8;
    private static final int INDEX_PSOBJNAME = 9;
    private static final int INDEX_PSOBJTYPE = 10;
    private static final int INDEX_PSOBJTYPENAME = 11;
    private static final int INDEX_PSSYSTEMID = 12;
    private static final int INDEX_PSSYSTEMNAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelMemoBase proxyPSModelMemoBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsmodelmemoidDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psmodelmemoidDirtyFlag = false;
    private boolean psmodelmemonameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean psobjtypenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsmodelmemoid")
    private String ppsmodelmemoid;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psmodelmemoid")
    private String psmodelmemoid;
    @Column(name="psmodelmemoname")
    private String psmodelmemoname;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="psobjtypename")
    private String psobjtypename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSModelMemoLock = new Integer(1);
    private PSModelMemo ppsmodelmemo = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSModelMemosLock = new Integer(1);
    private ArrayList<PSModelMemo> psmodelmemos = null;

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

    public void setPPSModelMemoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelMemoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelmemoid = string;
        this.ppsmodelmemoidDirtyFlag = true;
    }

    public String getPPSModelMemoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelMemoId();
        }
        return this.ppsmodelmemoid;
    }

    public boolean isPPSModelMemoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelMemoIdDirty();
        }
        return this.ppsmodelmemoidDirtyFlag;
    }

    public void resetPPSModelMemoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelMemoId();
            return;
        }
        this.ppsmodelmemoidDirtyFlag = false;
        this.ppsmodelmemoid = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
    }

    public void setPSModelMemoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelMemoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelmemoid = string;
        this.psmodelmemoidDirtyFlag = true;
    }

    public String getPSModelMemoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelMemoId();
        }
        return this.psmodelmemoid;
    }

    public boolean isPSModelMemoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelMemoIdDirty();
        }
        return this.psmodelmemoidDirtyFlag;
    }

    public void resetPSModelMemoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelMemoId();
            return;
        }
        this.psmodelmemoidDirtyFlag = false;
        this.psmodelmemoid = null;
    }

    public void setPSModelMemoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelMemoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelmemoname = string;
        this.psmodelmemonameDirtyFlag = true;
    }

    public String getPSModelMemoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelMemoName();
        }
        return this.psmodelmemoname;
    }

    public boolean isPSModelMemoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelMemoNameDirty();
        }
        return this.psmodelmemonameDirtyFlag;
    }

    public void resetPSModelMemoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelMemoName();
            return;
        }
        this.psmodelmemonameDirtyFlag = false;
        this.psmodelmemoname = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSObjTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtypename = string;
        this.psobjtypenameDirtyFlag = true;
    }

    public String getPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjTypeName();
        }
        return this.psobjtypename;
    }

    public boolean isPSObjTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeNameDirty();
        }
        return this.psobjtypenameDirtyFlag;
    }

    public void resetPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjTypeName();
            return;
        }
        this.psobjtypenameDirtyFlag = false;
        this.psobjtypename = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSModelMemoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelMemoBase pSModelMemoBase) {
        pSModelMemoBase.resetCreateDate();
        pSModelMemoBase.resetCreateMan();
        pSModelMemoBase.resetMemo();
        pSModelMemoBase.resetPPSModelMemoId();
        pSModelMemoBase.resetPSDEFId();
        pSModelMemoBase.resetPSDEFName();
        pSModelMemoBase.resetPSModelMemoId();
        pSModelMemoBase.resetPSModelMemoName();
        pSModelMemoBase.resetPSObjId();
        pSModelMemoBase.resetPSObjName();
        pSModelMemoBase.resetPSObjType();
        pSModelMemoBase.resetPSObjTypeName();
        pSModelMemoBase.resetPSSystemId();
        pSModelMemoBase.resetPSSystemName();
        pSModelMemoBase.resetUpdateDate();
        pSModelMemoBase.resetUpdateMan();
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
        if (!bl || this.isPPSModelMemoIdDirty()) {
            hashMap.put(FIELD_PPSMODELMEMOID, this.getPPSModelMemoId());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSModelMemoIdDirty()) {
            hashMap.put(FIELD_PSMODELMEMOID, this.getPSModelMemoId());
        }
        if (!bl || this.isPSModelMemoNameDirty()) {
            hashMap.put(FIELD_PSMODELMEMONAME, this.getPSModelMemoName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSObjTypeNameDirty()) {
            hashMap.put(FIELD_PSOBJTYPENAME, this.getPSObjTypeName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSModelMemoBase.get(this, n);
    }

    private static Object get(PSModelMemoBase pSModelMemoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelMemoBase.getCreateDate();
            }
            case 1: {
                return pSModelMemoBase.getCreateMan();
            }
            case 2: {
                return pSModelMemoBase.getMemo();
            }
            case 3: {
                return pSModelMemoBase.getPPSModelMemoId();
            }
            case 4: {
                return pSModelMemoBase.getPSDEFId();
            }
            case 5: {
                return pSModelMemoBase.getPSDEFName();
            }
            case 6: {
                return pSModelMemoBase.getPSModelMemoId();
            }
            case 7: {
                return pSModelMemoBase.getPSModelMemoName();
            }
            case 8: {
                return pSModelMemoBase.getPSObjId();
            }
            case 9: {
                return pSModelMemoBase.getPSObjName();
            }
            case 10: {
                return pSModelMemoBase.getPSObjType();
            }
            case 11: {
                return pSModelMemoBase.getPSObjTypeName();
            }
            case 12: {
                return pSModelMemoBase.getPSSystemId();
            }
            case 13: {
                return pSModelMemoBase.getPSSystemName();
            }
            case 14: {
                return pSModelMemoBase.getUpdateDate();
            }
            case 15: {
                return pSModelMemoBase.getUpdateMan();
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
        PSModelMemoBase.set(this, n, object);
    }

    private static void set(PSModelMemoBase pSModelMemoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelMemoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelMemoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelMemoBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelMemoBase.setPPSModelMemoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelMemoBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelMemoBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelMemoBase.setPSModelMemoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelMemoBase.setPSModelMemoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelMemoBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelMemoBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelMemoBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelMemoBase.setPSObjTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelMemoBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelMemoBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelMemoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSModelMemoBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelMemoBase.isNull(this, n);
    }

    private static boolean isNull(PSModelMemoBase pSModelMemoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelMemoBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelMemoBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelMemoBase.getMemo() == null;
            }
            case 3: {
                return pSModelMemoBase.getPPSModelMemoId() == null;
            }
            case 4: {
                return pSModelMemoBase.getPSDEFId() == null;
            }
            case 5: {
                return pSModelMemoBase.getPSDEFName() == null;
            }
            case 6: {
                return pSModelMemoBase.getPSModelMemoId() == null;
            }
            case 7: {
                return pSModelMemoBase.getPSModelMemoName() == null;
            }
            case 8: {
                return pSModelMemoBase.getPSObjId() == null;
            }
            case 9: {
                return pSModelMemoBase.getPSObjName() == null;
            }
            case 10: {
                return pSModelMemoBase.getPSObjType() == null;
            }
            case 11: {
                return pSModelMemoBase.getPSObjTypeName() == null;
            }
            case 12: {
                return pSModelMemoBase.getPSSystemId() == null;
            }
            case 13: {
                return pSModelMemoBase.getPSSystemName() == null;
            }
            case 14: {
                return pSModelMemoBase.getUpdateDate() == null;
            }
            case 15: {
                return pSModelMemoBase.getUpdateMan() == null;
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
        return PSModelMemoBase.contains(this, n);
    }

    private static boolean contains(PSModelMemoBase pSModelMemoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelMemoBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelMemoBase.isCreateManDirty();
            }
            case 2: {
                return pSModelMemoBase.isMemoDirty();
            }
            case 3: {
                return pSModelMemoBase.isPPSModelMemoIdDirty();
            }
            case 4: {
                return pSModelMemoBase.isPSDEFIdDirty();
            }
            case 5: {
                return pSModelMemoBase.isPSDEFNameDirty();
            }
            case 6: {
                return pSModelMemoBase.isPSModelMemoIdDirty();
            }
            case 7: {
                return pSModelMemoBase.isPSModelMemoNameDirty();
            }
            case 8: {
                return pSModelMemoBase.isPSObjIdDirty();
            }
            case 9: {
                return pSModelMemoBase.isPSObjNameDirty();
            }
            case 10: {
                return pSModelMemoBase.isPSObjTypeDirty();
            }
            case 11: {
                return pSModelMemoBase.isPSObjTypeNameDirty();
            }
            case 12: {
                return pSModelMemoBase.isPSSystemIdDirty();
            }
            case 13: {
                return pSModelMemoBase.isPSSystemNameDirty();
            }
            case 14: {
                return pSModelMemoBase.isUpdateDateDirty();
            }
            case 15: {
                return pSModelMemoBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelMemoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelMemoBase pSModelMemoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelMemoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPPSModelMemoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelmemoid", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPPSModelMemoId()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSModelMemoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelmemoid", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSModelMemoId()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSModelMemoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelmemoname", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSModelMemoName()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSObjTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtypename", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSObjTypeName()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelMemoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelMemoBase.getJSONValue((Object)pSModelMemoBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelMemoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelMemoBase pSModelMemoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelMemoBase.getCreateDate() != null) {
            object = pSModelMemoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelMemoBase.getCreateMan() != null) {
            object = pSModelMemoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getMemo() != null) {
            object = pSModelMemoBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPPSModelMemoId() != null) {
            object = pSModelMemoBase.getPPSModelMemoId();
            xmlNode.setAttribute(FIELD_PPSMODELMEMOID, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSDEFId() != null) {
            object = pSModelMemoBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSDEFName() != null) {
            object = pSModelMemoBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSModelMemoId() != null) {
            object = pSModelMemoBase.getPSModelMemoId();
            xmlNode.setAttribute(FIELD_PSMODELMEMOID, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSModelMemoName() != null) {
            object = pSModelMemoBase.getPSModelMemoName();
            xmlNode.setAttribute(FIELD_PSMODELMEMONAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSObjId() != null) {
            object = pSModelMemoBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSObjName() != null) {
            object = pSModelMemoBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSObjType() != null) {
            object = pSModelMemoBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSObjTypeName() != null) {
            object = pSModelMemoBase.getPSObjTypeName();
            xmlNode.setAttribute(FIELD_PSOBJTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSSystemId() != null) {
            object = pSModelMemoBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getPSSystemName() != null) {
            object = pSModelMemoBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelMemoBase.getUpdateDate() != null) {
            object = pSModelMemoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelMemoBase.getUpdateMan() != null) {
            object = pSModelMemoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelMemoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelMemoBase pSModelMemoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelMemoBase.isCreateDateDirty() && (bl || pSModelMemoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelMemoBase.getCreateDate());
        }
        if (pSModelMemoBase.isCreateManDirty() && (bl || pSModelMemoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelMemoBase.getCreateMan());
        }
        if (pSModelMemoBase.isMemoDirty() && (bl || pSModelMemoBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelMemoBase.getMemo());
        }
        if (pSModelMemoBase.isPPSModelMemoIdDirty() && (bl || pSModelMemoBase.getPPSModelMemoId() != null)) {
            iDataObject.set(FIELD_PPSMODELMEMOID, (Object)pSModelMemoBase.getPPSModelMemoId());
        }
        if (pSModelMemoBase.isPSDEFIdDirty() && (bl || pSModelMemoBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSModelMemoBase.getPSDEFId());
        }
        if (pSModelMemoBase.isPSDEFNameDirty() && (bl || pSModelMemoBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSModelMemoBase.getPSDEFName());
        }
        if (pSModelMemoBase.isPSModelMemoIdDirty() && (bl || pSModelMemoBase.getPSModelMemoId() != null)) {
            iDataObject.set(FIELD_PSMODELMEMOID, (Object)pSModelMemoBase.getPSModelMemoId());
        }
        if (pSModelMemoBase.isPSModelMemoNameDirty() && (bl || pSModelMemoBase.getPSModelMemoName() != null)) {
            iDataObject.set(FIELD_PSMODELMEMONAME, (Object)pSModelMemoBase.getPSModelMemoName());
        }
        if (pSModelMemoBase.isPSObjIdDirty() && (bl || pSModelMemoBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSModelMemoBase.getPSObjId());
        }
        if (pSModelMemoBase.isPSObjNameDirty() && (bl || pSModelMemoBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSModelMemoBase.getPSObjName());
        }
        if (pSModelMemoBase.isPSObjTypeDirty() && (bl || pSModelMemoBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSModelMemoBase.getPSObjType());
        }
        if (pSModelMemoBase.isPSObjTypeNameDirty() && (bl || pSModelMemoBase.getPSObjTypeName() != null)) {
            iDataObject.set(FIELD_PSOBJTYPENAME, (Object)pSModelMemoBase.getPSObjTypeName());
        }
        if (pSModelMemoBase.isPSSystemIdDirty() && (bl || pSModelMemoBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSModelMemoBase.getPSSystemId());
        }
        if (pSModelMemoBase.isPSSystemNameDirty() && (bl || pSModelMemoBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSModelMemoBase.getPSSystemName());
        }
        if (pSModelMemoBase.isUpdateDateDirty() && (bl || pSModelMemoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelMemoBase.getUpdateDate());
        }
        if (pSModelMemoBase.isUpdateManDirty() && (bl || pSModelMemoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelMemoBase.getUpdateMan());
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
        return PSModelMemoBase.remove(this, n);
    }

    private static boolean remove(PSModelMemoBase pSModelMemoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelMemoBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelMemoBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelMemoBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelMemoBase.resetPPSModelMemoId();
                return true;
            }
            case 4: {
                pSModelMemoBase.resetPSDEFId();
                return true;
            }
            case 5: {
                pSModelMemoBase.resetPSDEFName();
                return true;
            }
            case 6: {
                pSModelMemoBase.resetPSModelMemoId();
                return true;
            }
            case 7: {
                pSModelMemoBase.resetPSModelMemoName();
                return true;
            }
            case 8: {
                pSModelMemoBase.resetPSObjId();
                return true;
            }
            case 9: {
                pSModelMemoBase.resetPSObjName();
                return true;
            }
            case 10: {
                pSModelMemoBase.resetPSObjType();
                return true;
            }
            case 11: {
                pSModelMemoBase.resetPSObjTypeName();
                return true;
            }
            case 12: {
                pSModelMemoBase.resetPSSystemId();
                return true;
            }
            case 13: {
                pSModelMemoBase.resetPSSystemName();
                return true;
            }
            case 14: {
                pSModelMemoBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSModelMemoBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelMemo getPPSModelMemo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelMemo();
        }
        if (this.getPPSModelMemoId() == null) {
            return null;
        }
        Integer n = this.objPPSModelMemoLock;
        synchronized (n) {
            if (this.ppsmodelmemo != null && DataTypeHelper.compare((int)25, (Object)this.getPPSModelMemoId(), (Object)this.ppsmodelmemo.getPSModelMemoId()) != 0L) {
                this.ppsmodelmemo = null;
            }
            if (this.ppsmodelmemo == null) {
                PSModelMemo pSModelMemo = new PSModelMemo();
                pSModelMemo.setPSModelMemoId(this.getPPSModelMemoId());
                PSModelMemoService pSModelMemoService = (PSModelMemoService)ServiceGlobal.getService(PSModelMemoService.class, (SessionFactory)this.getSessionFactory());
                pSModelMemoService.autoGet((IEntity)pSModelMemo);
                this.ppsmodelmemo = pSModelMemo;
            }
            return this.ppsmodelmemo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSModelMemo> getPSModelMemos() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelMemos();
        }
        if (this.getPSModelMemoId() == null) {
            return null;
        }
        PSModelMemoService pSModelMemoService = (PSModelMemoService)ServiceGlobal.getService(PSModelMemoService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModelMemosLock;
        synchronized (n) {
            if (this.psmodelmemos == null) {
                this.psmodelmemos = pSModelMemoService.selectByPPSModelMemo(this);
            }
            return this.psmodelmemos;
        }
    }

    private PSModelMemoBase getProxyEntity() {
        return this.proxyPSModelMemoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelMemoBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelMemoBase) {
            this.proxyPSModelMemoBase = (PSModelMemoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelMemoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PPSMODELMEMOID, 3);
        fieldIndexMap.put(FIELD_PSDEFID, 4);
        fieldIndexMap.put(FIELD_PSDEFNAME, 5);
        fieldIndexMap.put(FIELD_PSMODELMEMOID, 6);
        fieldIndexMap.put(FIELD_PSMODELMEMONAME, 7);
        fieldIndexMap.put(FIELD_PSOBJID, 8);
        fieldIndexMap.put(FIELD_PSOBJNAME, 9);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 10);
        fieldIndexMap.put(FIELD_PSOBJTYPENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

