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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSModelAPIMethod;
import net.ibizsys.pscore.srv.config.service.PSModelAPIMethodService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelAPIRSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelAPIRSBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFUIMODEID = "PSDEFFORMITEMID";
    public static final String FIELD_PSDEFUIMODENAME = "PSDEFFORMITEMNAME";
    public static final String FIELD_PSMODELAPIINTNAME = "PSMODELAPIINTNAME";
    public static final String FIELD_PSMODELAPIMETHODID = "PSMODELAPIMETHODID";
    public static final String FIELD_PSMODELAPIMETHODNAME = "PSMODELAPIMETHODNAME";
    public static final String FIELD_PSMODELAPINAME = "PSMODELAPINAME";
    public static final String FIELD_PSMODELAPIRSID = "PSMODELAPIRSID";
    public static final String FIELD_PSMODELAPIRSNAME = "PSMODELAPIRSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEFUIMODEID = 3;
    private static final int INDEX_PSDEFUIMODENAME = 4;
    private static final int INDEX_PSMODELAPIINTNAME = 5;
    private static final int INDEX_PSMODELAPIMETHODID = 6;
    private static final int INDEX_PSMODELAPIMETHODNAME = 7;
    private static final int INDEX_PSMODELAPINAME = 8;
    private static final int INDEX_PSMODELAPIRSID = 9;
    private static final int INDEX_PSMODELAPIRSNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelAPIRSBase proxyPSModelAPIRSBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefuimodeidDirtyFlag = false;
    private boolean psdefuimodenameDirtyFlag = false;
    private boolean psmodelapiintnameDirtyFlag = false;
    private boolean psmodelapimethodidDirtyFlag = false;
    private boolean psmodelapimethodnameDirtyFlag = false;
    private boolean psmodelapinameDirtyFlag = false;
    private boolean psmodelapirsidDirtyFlag = false;
    private boolean psmodelapirsnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefuimodeid")
    private String psdefuimodeid;
    @Column(name="psdefuimodename")
    private String psdefuimodename;
    @Column(name="psmodelapiintname")
    private String psmodelapiintname;
    @Column(name="psmodelapimethodid")
    private String psmodelapimethodid;
    @Column(name="psmodelapimethodname")
    private String psmodelapimethodname;
    @Column(name="psmodelapiname")
    private String psmodelapiname;
    @Column(name="psmodelapirsid")
    private String psmodelapirsid;
    @Column(name="psmodelapirsname")
    private String psmodelapirsname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEFUIModeLock = new Integer(1);
    private PSDEFUIMode psdefuimode = null;
    private Integer objPSModelAPIMethodLock = new Integer(1);
    private PSModelAPIMethod psmodelapimethod = null;

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

    public void setPSDEFUIModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefuimodeid = string;
        this.psdefuimodeidDirtyFlag = true;
    }

    public String getPSDEFUIModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModeId();
        }
        return this.psdefuimodeid;
    }

    public boolean isPSDEFUIModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModeIdDirty();
        }
        return this.psdefuimodeidDirtyFlag;
    }

    public void resetPSDEFUIModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModeId();
            return;
        }
        this.psdefuimodeidDirtyFlag = false;
        this.psdefuimodeid = null;
    }

    public void setPSDEFUIModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefuimodename = string;
        this.psdefuimodenameDirtyFlag = true;
    }

    public String getPSDEFUIModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModeName();
        }
        return this.psdefuimodename;
    }

    public boolean isPSDEFUIModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModeNameDirty();
        }
        return this.psdefuimodenameDirtyFlag;
    }

    public void resetPSDEFUIModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModeName();
            return;
        }
        this.psdefuimodenameDirtyFlag = false;
        this.psdefuimodename = null;
    }

    public void setPSModelAPIIntName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIIntName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiintname = string;
        this.psmodelapiintnameDirtyFlag = true;
    }

    public String getPSModelAPIIntName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIIntName();
        }
        return this.psmodelapiintname;
    }

    public boolean isPSModelAPIIntNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIIntNameDirty();
        }
        return this.psmodelapiintnameDirtyFlag;
    }

    public void resetPSModelAPIIntName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIIntName();
            return;
        }
        this.psmodelapiintnameDirtyFlag = false;
        this.psmodelapiintname = null;
    }

    public void setPSModelAPIMethodId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIMethodId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapimethodid = string;
        this.psmodelapimethodidDirtyFlag = true;
    }

    public String getPSModelAPIMethodId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIMethodId();
        }
        return this.psmodelapimethodid;
    }

    public boolean isPSModelAPIMethodIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIMethodIdDirty();
        }
        return this.psmodelapimethodidDirtyFlag;
    }

    public void resetPSModelAPIMethodId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIMethodId();
            return;
        }
        this.psmodelapimethodidDirtyFlag = false;
        this.psmodelapimethodid = null;
    }

    public void setPSModelAPIMethodName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIMethodName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapimethodname = string;
        this.psmodelapimethodnameDirtyFlag = true;
    }

    public String getPSModelAPIMethodName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIMethodName();
        }
        return this.psmodelapimethodname;
    }

    public boolean isPSModelAPIMethodNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIMethodNameDirty();
        }
        return this.psmodelapimethodnameDirtyFlag;
    }

    public void resetPSModelAPIMethodName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIMethodName();
            return;
        }
        this.psmodelapimethodnameDirtyFlag = false;
        this.psmodelapimethodname = null;
    }

    public void setPSModelAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiname = string;
        this.psmodelapinameDirtyFlag = true;
    }

    public String getPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIName();
        }
        return this.psmodelapiname;
    }

    public boolean isPSModelAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPINameDirty();
        }
        return this.psmodelapinameDirtyFlag;
    }

    public void resetPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIName();
            return;
        }
        this.psmodelapinameDirtyFlag = false;
        this.psmodelapiname = null;
    }

    public void setPSModelAPIRSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIRSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapirsid = string;
        this.psmodelapirsidDirtyFlag = true;
    }

    public String getPSModelAPIRSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIRSId();
        }
        return this.psmodelapirsid;
    }

    public boolean isPSModelAPIRSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIRSIdDirty();
        }
        return this.psmodelapirsidDirtyFlag;
    }

    public void resetPSModelAPIRSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIRSId();
            return;
        }
        this.psmodelapirsidDirtyFlag = false;
        this.psmodelapirsid = null;
    }

    public void setPSModelAPIRSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIRSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapirsname = string;
        this.psmodelapirsnameDirtyFlag = true;
    }

    public String getPSModelAPIRSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIRSName();
        }
        return this.psmodelapirsname;
    }

    public boolean isPSModelAPIRSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIRSNameDirty();
        }
        return this.psmodelapirsnameDirtyFlag;
    }

    public void resetPSModelAPIRSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIRSName();
            return;
        }
        this.psmodelapirsnameDirtyFlag = false;
        this.psmodelapirsname = null;
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
        PSModelAPIRSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelAPIRSBase pSModelAPIRSBase) {
        pSModelAPIRSBase.resetCreateDate();
        pSModelAPIRSBase.resetCreateMan();
        pSModelAPIRSBase.resetMemo();
        pSModelAPIRSBase.resetPSDEFUIModeId();
        pSModelAPIRSBase.resetPSDEFUIModeName();
        pSModelAPIRSBase.resetPSModelAPIIntName();
        pSModelAPIRSBase.resetPSModelAPIMethodId();
        pSModelAPIRSBase.resetPSModelAPIMethodName();
        pSModelAPIRSBase.resetPSModelAPIName();
        pSModelAPIRSBase.resetPSModelAPIRSId();
        pSModelAPIRSBase.resetPSModelAPIRSName();
        pSModelAPIRSBase.resetUpdateDate();
        pSModelAPIRSBase.resetUpdateMan();
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
        if (!bl || this.isPSDEFUIModeIdDirty()) {
            hashMap.put(FIELD_PSDEFUIMODEID, this.getPSDEFUIModeId());
        }
        if (!bl || this.isPSDEFUIModeNameDirty()) {
            hashMap.put(FIELD_PSDEFUIMODENAME, this.getPSDEFUIModeName());
        }
        if (!bl || this.isPSModelAPIIntNameDirty()) {
            hashMap.put(FIELD_PSMODELAPIINTNAME, this.getPSModelAPIIntName());
        }
        if (!bl || this.isPSModelAPIMethodIdDirty()) {
            hashMap.put(FIELD_PSMODELAPIMETHODID, this.getPSModelAPIMethodId());
        }
        if (!bl || this.isPSModelAPIMethodNameDirty()) {
            hashMap.put(FIELD_PSMODELAPIMETHODNAME, this.getPSModelAPIMethodName());
        }
        if (!bl || this.isPSModelAPINameDirty()) {
            hashMap.put(FIELD_PSMODELAPINAME, this.getPSModelAPIName());
        }
        if (!bl || this.isPSModelAPIRSIdDirty()) {
            hashMap.put(FIELD_PSMODELAPIRSID, this.getPSModelAPIRSId());
        }
        if (!bl || this.isPSModelAPIRSNameDirty()) {
            hashMap.put(FIELD_PSMODELAPIRSNAME, this.getPSModelAPIRSName());
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
        return PSModelAPIRSBase.get(this, n);
    }

    private static Object get(PSModelAPIRSBase pSModelAPIRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIRSBase.getCreateDate();
            }
            case 1: {
                return pSModelAPIRSBase.getCreateMan();
            }
            case 2: {
                return pSModelAPIRSBase.getMemo();
            }
            case 3: {
                return pSModelAPIRSBase.getPSDEFUIModeId();
            }
            case 4: {
                return pSModelAPIRSBase.getPSDEFUIModeName();
            }
            case 5: {
                return pSModelAPIRSBase.getPSModelAPIIntName();
            }
            case 6: {
                return pSModelAPIRSBase.getPSModelAPIMethodId();
            }
            case 7: {
                return pSModelAPIRSBase.getPSModelAPIMethodName();
            }
            case 8: {
                return pSModelAPIRSBase.getPSModelAPIName();
            }
            case 9: {
                return pSModelAPIRSBase.getPSModelAPIRSId();
            }
            case 10: {
                return pSModelAPIRSBase.getPSModelAPIRSName();
            }
            case 11: {
                return pSModelAPIRSBase.getUpdateDate();
            }
            case 12: {
                return pSModelAPIRSBase.getUpdateMan();
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
        PSModelAPIRSBase.set(this, n, object);
    }

    private static void set(PSModelAPIRSBase pSModelAPIRSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelAPIRSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelAPIRSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelAPIRSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelAPIRSBase.setPSDEFUIModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelAPIRSBase.setPSDEFUIModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelAPIRSBase.setPSModelAPIIntName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelAPIRSBase.setPSModelAPIMethodId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelAPIRSBase.setPSModelAPIMethodName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelAPIRSBase.setPSModelAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelAPIRSBase.setPSModelAPIRSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelAPIRSBase.setPSModelAPIRSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelAPIRSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSModelAPIRSBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelAPIRSBase.isNull(this, n);
    }

    private static boolean isNull(PSModelAPIRSBase pSModelAPIRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIRSBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelAPIRSBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelAPIRSBase.getMemo() == null;
            }
            case 3: {
                return pSModelAPIRSBase.getPSDEFUIModeId() == null;
            }
            case 4: {
                return pSModelAPIRSBase.getPSDEFUIModeName() == null;
            }
            case 5: {
                return pSModelAPIRSBase.getPSModelAPIIntName() == null;
            }
            case 6: {
                return pSModelAPIRSBase.getPSModelAPIMethodId() == null;
            }
            case 7: {
                return pSModelAPIRSBase.getPSModelAPIMethodName() == null;
            }
            case 8: {
                return pSModelAPIRSBase.getPSModelAPIName() == null;
            }
            case 9: {
                return pSModelAPIRSBase.getPSModelAPIRSId() == null;
            }
            case 10: {
                return pSModelAPIRSBase.getPSModelAPIRSName() == null;
            }
            case 11: {
                return pSModelAPIRSBase.getUpdateDate() == null;
            }
            case 12: {
                return pSModelAPIRSBase.getUpdateMan() == null;
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
        return PSModelAPIRSBase.contains(this, n);
    }

    private static boolean contains(PSModelAPIRSBase pSModelAPIRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIRSBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelAPIRSBase.isCreateManDirty();
            }
            case 2: {
                return pSModelAPIRSBase.isMemoDirty();
            }
            case 3: {
                return pSModelAPIRSBase.isPSDEFUIModeIdDirty();
            }
            case 4: {
                return pSModelAPIRSBase.isPSDEFUIModeNameDirty();
            }
            case 5: {
                return pSModelAPIRSBase.isPSModelAPIIntNameDirty();
            }
            case 6: {
                return pSModelAPIRSBase.isPSModelAPIMethodIdDirty();
            }
            case 7: {
                return pSModelAPIRSBase.isPSModelAPIMethodNameDirty();
            }
            case 8: {
                return pSModelAPIRSBase.isPSModelAPINameDirty();
            }
            case 9: {
                return pSModelAPIRSBase.isPSModelAPIRSIdDirty();
            }
            case 10: {
                return pSModelAPIRSBase.isPSModelAPIRSNameDirty();
            }
            case 11: {
                return pSModelAPIRSBase.isUpdateDateDirty();
            }
            case 12: {
                return pSModelAPIRSBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelAPIRSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelAPIRSBase pSModelAPIRSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelAPIRSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getPSDEFUIModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefformitemid", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getPSDEFUIModeId()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getPSDEFUIModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefformitemname", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getPSDEFUIModeName()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIIntName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiintname", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getPSModelAPIIntName()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIMethodId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapimethodid", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getPSModelAPIMethodId()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIMethodName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapimethodname", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getPSModelAPIMethodName()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiname", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getPSModelAPIName()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIRSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapirsid", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getPSModelAPIRSId()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIRSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapirsname", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getPSModelAPIRSName()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelAPIRSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelAPIRSBase.getJSONValue((Object)pSModelAPIRSBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelAPIRSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelAPIRSBase pSModelAPIRSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelAPIRSBase.getCreateDate() != null) {
            object = pSModelAPIRSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelAPIRSBase.getCreateMan() != null) {
            object = pSModelAPIRSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getMemo() != null) {
            object = pSModelAPIRSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getPSDEFUIModeId() != null) {
            object = pSModelAPIRSBase.getPSDEFUIModeId();
            xmlNode.setAttribute("PSDEFUIMODEID", object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getPSDEFUIModeName() != null) {
            object = pSModelAPIRSBase.getPSDEFUIModeName();
            xmlNode.setAttribute("PSDEFUIMODENAME", object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIIntName() != null) {
            object = pSModelAPIRSBase.getPSModelAPIIntName();
            xmlNode.setAttribute(FIELD_PSMODELAPIINTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIMethodId() != null) {
            object = pSModelAPIRSBase.getPSModelAPIMethodId();
            xmlNode.setAttribute(FIELD_PSMODELAPIMETHODID, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIMethodName() != null) {
            object = pSModelAPIRSBase.getPSModelAPIMethodName();
            xmlNode.setAttribute(FIELD_PSMODELAPIMETHODNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIName() != null) {
            object = pSModelAPIRSBase.getPSModelAPIName();
            xmlNode.setAttribute(FIELD_PSMODELAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIRSId() != null) {
            object = pSModelAPIRSBase.getPSModelAPIRSId();
            xmlNode.setAttribute(FIELD_PSMODELAPIRSID, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getPSModelAPIRSName() != null) {
            object = pSModelAPIRSBase.getPSModelAPIRSName();
            xmlNode.setAttribute(FIELD_PSMODELAPIRSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIRSBase.getUpdateDate() != null) {
            object = pSModelAPIRSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelAPIRSBase.getUpdateMan() != null) {
            object = pSModelAPIRSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelAPIRSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelAPIRSBase pSModelAPIRSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelAPIRSBase.isCreateDateDirty() && (bl || pSModelAPIRSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelAPIRSBase.getCreateDate());
        }
        if (pSModelAPIRSBase.isCreateManDirty() && (bl || pSModelAPIRSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelAPIRSBase.getCreateMan());
        }
        if (pSModelAPIRSBase.isMemoDirty() && (bl || pSModelAPIRSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelAPIRSBase.getMemo());
        }
        if (pSModelAPIRSBase.isPSDEFUIModeIdDirty() && (bl || pSModelAPIRSBase.getPSDEFUIModeId() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODEID, (Object)pSModelAPIRSBase.getPSDEFUIModeId());
        }
        if (pSModelAPIRSBase.isPSDEFUIModeNameDirty() && (bl || pSModelAPIRSBase.getPSDEFUIModeName() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODENAME, (Object)pSModelAPIRSBase.getPSDEFUIModeName());
        }
        if (pSModelAPIRSBase.isPSModelAPIIntNameDirty() && (bl || pSModelAPIRSBase.getPSModelAPIIntName() != null)) {
            iDataObject.set(FIELD_PSMODELAPIINTNAME, (Object)pSModelAPIRSBase.getPSModelAPIIntName());
        }
        if (pSModelAPIRSBase.isPSModelAPIMethodIdDirty() && (bl || pSModelAPIRSBase.getPSModelAPIMethodId() != null)) {
            iDataObject.set(FIELD_PSMODELAPIMETHODID, (Object)pSModelAPIRSBase.getPSModelAPIMethodId());
        }
        if (pSModelAPIRSBase.isPSModelAPIMethodNameDirty() && (bl || pSModelAPIRSBase.getPSModelAPIMethodName() != null)) {
            iDataObject.set(FIELD_PSMODELAPIMETHODNAME, (Object)pSModelAPIRSBase.getPSModelAPIMethodName());
        }
        if (pSModelAPIRSBase.isPSModelAPINameDirty() && (bl || pSModelAPIRSBase.getPSModelAPIName() != null)) {
            iDataObject.set(FIELD_PSMODELAPINAME, (Object)pSModelAPIRSBase.getPSModelAPIName());
        }
        if (pSModelAPIRSBase.isPSModelAPIRSIdDirty() && (bl || pSModelAPIRSBase.getPSModelAPIRSId() != null)) {
            iDataObject.set(FIELD_PSMODELAPIRSID, (Object)pSModelAPIRSBase.getPSModelAPIRSId());
        }
        if (pSModelAPIRSBase.isPSModelAPIRSNameDirty() && (bl || pSModelAPIRSBase.getPSModelAPIRSName() != null)) {
            iDataObject.set(FIELD_PSMODELAPIRSNAME, (Object)pSModelAPIRSBase.getPSModelAPIRSName());
        }
        if (pSModelAPIRSBase.isUpdateDateDirty() && (bl || pSModelAPIRSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelAPIRSBase.getUpdateDate());
        }
        if (pSModelAPIRSBase.isUpdateManDirty() && (bl || pSModelAPIRSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelAPIRSBase.getUpdateMan());
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
        return PSModelAPIRSBase.remove(this, n);
    }

    private static boolean remove(PSModelAPIRSBase pSModelAPIRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelAPIRSBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelAPIRSBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelAPIRSBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelAPIRSBase.resetPSDEFUIModeId();
                return true;
            }
            case 4: {
                pSModelAPIRSBase.resetPSDEFUIModeName();
                return true;
            }
            case 5: {
                pSModelAPIRSBase.resetPSModelAPIIntName();
                return true;
            }
            case 6: {
                pSModelAPIRSBase.resetPSModelAPIMethodId();
                return true;
            }
            case 7: {
                pSModelAPIRSBase.resetPSModelAPIMethodName();
                return true;
            }
            case 8: {
                pSModelAPIRSBase.resetPSModelAPIName();
                return true;
            }
            case 9: {
                pSModelAPIRSBase.resetPSModelAPIRSId();
                return true;
            }
            case 10: {
                pSModelAPIRSBase.resetPSModelAPIRSName();
                return true;
            }
            case 11: {
                pSModelAPIRSBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSModelAPIRSBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFUIMode getPSDEFUIMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIMode();
        }
        if (this.getPSDEFUIModeId() == null) {
            return null;
        }
        Integer n = this.objPSDEFUIModeLock;
        synchronized (n) {
            if (this.psdefuimode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFUIModeId(), (Object)this.psdefuimode.getPSDEFUIModeId()) != 0L) {
                this.psdefuimode = null;
            }
            if (this.psdefuimode == null) {
                PSDEFUIMode pSDEFUIMode = new PSDEFUIMode();
                pSDEFUIMode.setPSDEFUIModeId(this.getPSDEFUIModeId());
                PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFUIModeService.autoGet(pSDEFUIMode);
                this.psdefuimode = pSDEFUIMode;
            }
            return this.psdefuimode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelAPIMethod getPSModelAPIMethod() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIMethod();
        }
        if (this.getPSModelAPIMethodId() == null) {
            return null;
        }
        Integer n = this.objPSModelAPIMethodLock;
        synchronized (n) {
            if (this.psmodelapimethod != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelAPIMethodId(), (Object)this.psmodelapimethod.getPSModelAPIMethodId()) != 0L) {
                this.psmodelapimethod = null;
            }
            if (this.psmodelapimethod == null) {
                PSModelAPIMethod pSModelAPIMethod = new PSModelAPIMethod();
                pSModelAPIMethod.setPSModelAPIMethodId(this.getPSModelAPIMethodId());
                PSModelAPIMethodService pSModelAPIMethodService = (PSModelAPIMethodService)ServiceGlobal.getService(PSModelAPIMethodService.class, (SessionFactory)this.getSessionFactory());
                pSModelAPIMethodService.autoGet(pSModelAPIMethod);
                this.psmodelapimethod = pSModelAPIMethod;
            }
            return this.psmodelapimethod;
        }
    }

    private PSModelAPIRSBase getProxyEntity() {
        return this.proxyPSModelAPIRSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelAPIRSBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelAPIRSBase) {
            this.proxyPSModelAPIRSBase = (PSModelAPIRSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSModelAPIRSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEFUIMODEID, 3);
        fieldIndexMap.put(FIELD_PSDEFUIMODENAME, 4);
        fieldIndexMap.put(FIELD_PSMODELAPIINTNAME, 5);
        fieldIndexMap.put(FIELD_PSMODELAPIMETHODID, 6);
        fieldIndexMap.put(FIELD_PSMODELAPIMETHODNAME, 7);
        fieldIndexMap.put(FIELD_PSMODELAPINAME, 8);
        fieldIndexMap.put(FIELD_PSMODELAPIRSID, 9);
        fieldIndexMap.put(FIELD_PSMODELAPIRSNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

