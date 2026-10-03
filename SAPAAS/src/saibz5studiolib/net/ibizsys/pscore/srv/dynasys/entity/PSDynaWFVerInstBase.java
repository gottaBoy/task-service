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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaWFVerInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaWFVerInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String FIELD_PSDYNAWFVERID = "PSDYNAWFVERID";
    public static final String FIELD_PSDYNAWFVERINSTID = "PSDYNAWFVERINSTID";
    public static final String FIELD_PSDYNAWFVERINSTNAME = "PSDYNAWFVERINSTNAME";
    public static final String FIELD_PSDYNAWFVERNAME = "PSDYNAWFVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WFVERSION = "WFVERSION";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODEL = 2;
    private static final int INDEX_INSTVER = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDYNAINSTID = 5;
    private static final int INDEX_PSDYNAINSTNAME = 6;
    private static final int INDEX_PSDYNAWFVERID = 7;
    private static final int INDEX_PSDYNAWFVERINSTID = 8;
    private static final int INDEX_PSDYNAWFVERINSTNAME = 9;
    private static final int INDEX_PSDYNAWFVERNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final int INDEX_WFVERSION = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaWFVerInstBase proxyPSDynaWFVerInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynainstnameDirtyFlag = false;
    private boolean psdynawfveridDirtyFlag = false;
    private boolean psdynawfverinstidDirtyFlag = false;
    private boolean psdynawfverinstnameDirtyFlag = false;
    private boolean psdynawfvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="instver")
    private Integer instver;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynainstname")
    private String psdynainstname;
    @Column(name="psdynawfverid")
    private String psdynawfverid;
    @Column(name="psdynawfverinstid")
    private String psdynawfverinstid;
    @Column(name="psdynawfverinstname")
    private String psdynawfverinstname;
    @Column(name="psdynawfvername")
    private String psdynawfvername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="wfversion")
    private Integer wfversion;
    private Integer objPSDynaInstLock = new Integer(1);
    private PSDynaInst psdynainst = null;
    private Integer objPSDynaWFVerLock = new Integer(1);
    private PSDynaWFVer psdynawfver = null;

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

    public void setDynaModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodel = string;
        this.dynamodelDirtyFlag = true;
    }

    public String getDynaModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    public boolean isDynaModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    public void resetDynaModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }

    public void setInstVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(n);
            return;
        }
        this.instver = n;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstname = string;
        this.psdynainstnameDirtyFlag = true;
    }

    public String getPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstName();
        }
        return this.psdynainstname;
    }

    public boolean isPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstNameDirty();
        }
        return this.psdynainstnameDirtyFlag;
    }

    public void resetPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstName();
            return;
        }
        this.psdynainstnameDirtyFlag = false;
        this.psdynainstname = null;
    }

    public void setPSDynaWFVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverid = string;
        this.psdynawfveridDirtyFlag = true;
    }

    public String getPSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerId();
        }
        return this.psdynawfverid;
    }

    public boolean isPSDynaWFVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerIdDirty();
        }
        return this.psdynawfveridDirtyFlag;
    }

    public void resetPSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerId();
            return;
        }
        this.psdynawfveridDirtyFlag = false;
        this.psdynawfverid = null;
    }

    public void setPSDynaWFVerInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverinstid = string;
        this.psdynawfverinstidDirtyFlag = true;
    }

    public String getPSDynaWFVerInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInstId();
        }
        return this.psdynawfverinstid;
    }

    public boolean isPSDynaWFVerInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerInstIdDirty();
        }
        return this.psdynawfverinstidDirtyFlag;
    }

    public void resetPSDynaWFVerInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerInstId();
            return;
        }
        this.psdynawfverinstidDirtyFlag = false;
        this.psdynawfverinstid = null;
    }

    public void setPSDynaWFVerInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverinstname = string;
        this.psdynawfverinstnameDirtyFlag = true;
    }

    public String getPSDynaWFVerInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInstName();
        }
        return this.psdynawfverinstname;
    }

    public boolean isPSDynaWFVerInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerInstNameDirty();
        }
        return this.psdynawfverinstnameDirtyFlag;
    }

    public void resetPSDynaWFVerInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerInstName();
            return;
        }
        this.psdynawfverinstnameDirtyFlag = false;
        this.psdynawfverinstname = null;
    }

    public void setPSDynaWFVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfvername = string;
        this.psdynawfvernameDirtyFlag = true;
    }

    public String getPSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerName();
        }
        return this.psdynawfvername;
    }

    public boolean isPSDynaWFVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerNameDirty();
        }
        return this.psdynawfvernameDirtyFlag;
    }

    public void resetPSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerName();
            return;
        }
        this.psdynawfvernameDirtyFlag = false;
        this.psdynawfvername = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setWFVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersion(n);
            return;
        }
        this.wfversion = n;
        this.wfversionDirtyFlag = true;
    }

    public Integer getWFVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    public boolean isWFVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    public void resetWFVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }
        this.wfversionDirtyFlag = false;
        this.wfversion = null;
    }

    protected void onReset() {
        PSDynaWFVerInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaWFVerInstBase pSDynaWFVerInstBase) {
        pSDynaWFVerInstBase.resetCreateDate();
        pSDynaWFVerInstBase.resetCreateMan();
        pSDynaWFVerInstBase.resetDynaModel();
        pSDynaWFVerInstBase.resetInstVer();
        pSDynaWFVerInstBase.resetMemo();
        pSDynaWFVerInstBase.resetPSDynaInstId();
        pSDynaWFVerInstBase.resetPSDynaInstName();
        pSDynaWFVerInstBase.resetPSDynaWFVerId();
        pSDynaWFVerInstBase.resetPSDynaWFVerInstId();
        pSDynaWFVerInstBase.resetPSDynaWFVerInstName();
        pSDynaWFVerInstBase.resetPSDynaWFVerName();
        pSDynaWFVerInstBase.resetUpdateDate();
        pSDynaWFVerInstBase.resetUpdateMan();
        pSDynaWFVerInstBase.resetValidFlag();
        pSDynaWFVerInstBase.resetWFVersion();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelDirty()) {
            hashMap.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bl || this.isInstVerDirty()) {
            hashMap.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAINSTNAME, this.getPSDynaInstName());
        }
        if (!bl || this.isPSDynaWFVerIdDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERID, this.getPSDynaWFVerId());
        }
        if (!bl || this.isPSDynaWFVerInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERINSTID, this.getPSDynaWFVerInstId());
        }
        if (!bl || this.isPSDynaWFVerInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERINSTNAME, this.getPSDynaWFVerInstName());
        }
        if (!bl || this.isPSDynaWFVerNameDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERNAME, this.getPSDynaWFVerName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWFVersionDirty()) {
            hashMap.put(FIELD_WFVERSION, this.getWFVersion());
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
        return PSDynaWFVerInstBase.get(this, n);
    }

    private static Object get(PSDynaWFVerInstBase pSDynaWFVerInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFVerInstBase.getCreateDate();
            }
            case 1: {
                return pSDynaWFVerInstBase.getCreateMan();
            }
            case 2: {
                return pSDynaWFVerInstBase.getDynaModel();
            }
            case 3: {
                return pSDynaWFVerInstBase.getInstVer();
            }
            case 4: {
                return pSDynaWFVerInstBase.getMemo();
            }
            case 5: {
                return pSDynaWFVerInstBase.getPSDynaInstId();
            }
            case 6: {
                return pSDynaWFVerInstBase.getPSDynaInstName();
            }
            case 7: {
                return pSDynaWFVerInstBase.getPSDynaWFVerId();
            }
            case 8: {
                return pSDynaWFVerInstBase.getPSDynaWFVerInstId();
            }
            case 9: {
                return pSDynaWFVerInstBase.getPSDynaWFVerInstName();
            }
            case 10: {
                return pSDynaWFVerInstBase.getPSDynaWFVerName();
            }
            case 11: {
                return pSDynaWFVerInstBase.getUpdateDate();
            }
            case 12: {
                return pSDynaWFVerInstBase.getUpdateMan();
            }
            case 13: {
                return pSDynaWFVerInstBase.getValidFlag();
            }
            case 14: {
                return pSDynaWFVerInstBase.getWFVersion();
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
        PSDynaWFVerInstBase.set(this, n, object);
    }

    private static void set(PSDynaWFVerInstBase pSDynaWFVerInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaWFVerInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaWFVerInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaWFVerInstBase.setDynaModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaWFVerInstBase.setInstVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDynaWFVerInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaWFVerInstBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaWFVerInstBase.setPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaWFVerInstBase.setPSDynaWFVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaWFVerInstBase.setPSDynaWFVerInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaWFVerInstBase.setPSDynaWFVerInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaWFVerInstBase.setPSDynaWFVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaWFVerInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDynaWFVerInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDynaWFVerInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDynaWFVerInstBase.setWFVersion(DataObject.getIntegerValue((Object)object));
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
        return PSDynaWFVerInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaWFVerInstBase pSDynaWFVerInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFVerInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaWFVerInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaWFVerInstBase.getDynaModel() == null;
            }
            case 3: {
                return pSDynaWFVerInstBase.getInstVer() == null;
            }
            case 4: {
                return pSDynaWFVerInstBase.getMemo() == null;
            }
            case 5: {
                return pSDynaWFVerInstBase.getPSDynaInstId() == null;
            }
            case 6: {
                return pSDynaWFVerInstBase.getPSDynaInstName() == null;
            }
            case 7: {
                return pSDynaWFVerInstBase.getPSDynaWFVerId() == null;
            }
            case 8: {
                return pSDynaWFVerInstBase.getPSDynaWFVerInstId() == null;
            }
            case 9: {
                return pSDynaWFVerInstBase.getPSDynaWFVerInstName() == null;
            }
            case 10: {
                return pSDynaWFVerInstBase.getPSDynaWFVerName() == null;
            }
            case 11: {
                return pSDynaWFVerInstBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDynaWFVerInstBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDynaWFVerInstBase.getValidFlag() == null;
            }
            case 14: {
                return pSDynaWFVerInstBase.getWFVersion() == null;
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
        return PSDynaWFVerInstBase.contains(this, n);
    }

    private static boolean contains(PSDynaWFVerInstBase pSDynaWFVerInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFVerInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaWFVerInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaWFVerInstBase.isDynaModelDirty();
            }
            case 3: {
                return pSDynaWFVerInstBase.isInstVerDirty();
            }
            case 4: {
                return pSDynaWFVerInstBase.isMemoDirty();
            }
            case 5: {
                return pSDynaWFVerInstBase.isPSDynaInstIdDirty();
            }
            case 6: {
                return pSDynaWFVerInstBase.isPSDynaInstNameDirty();
            }
            case 7: {
                return pSDynaWFVerInstBase.isPSDynaWFVerIdDirty();
            }
            case 8: {
                return pSDynaWFVerInstBase.isPSDynaWFVerInstIdDirty();
            }
            case 9: {
                return pSDynaWFVerInstBase.isPSDynaWFVerInstNameDirty();
            }
            case 10: {
                return pSDynaWFVerInstBase.isPSDynaWFVerNameDirty();
            }
            case 11: {
                return pSDynaWFVerInstBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDynaWFVerInstBase.isUpdateManDirty();
            }
            case 13: {
                return pSDynaWFVerInstBase.isValidFlagDirty();
            }
            case 14: {
                return pSDynaWFVerInstBase.isWFVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaWFVerInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaWFVerInstBase pSDynaWFVerInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaWFVerInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getDynaModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodel", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getDynaModel()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instver", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getInstVer()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstname", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getPSDynaInstName()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaWFVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverid", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getPSDynaWFVerId()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaWFVerInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverinstid", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getPSDynaWFVerInstId()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaWFVerInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverinstname", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getPSDynaWFVerInstName()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaWFVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfvername", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getPSDynaWFVerName()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDynaWFVerInstBase.getWFVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfversion", (Object)PSDynaWFVerInstBase.getJSONValue((Object)pSDynaWFVerInstBase.getWFVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaWFVerInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaWFVerInstBase pSDynaWFVerInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaWFVerInstBase.getCreateDate() != null) {
            object = pSDynaWFVerInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaWFVerInstBase.getCreateMan() != null) {
            object = pSDynaWFVerInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getDynaModel() != null) {
            object = pSDynaWFVerInstBase.getDynaModel();
            xmlNode.setAttribute(FIELD_DYNAMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getInstVer() != null) {
            object = pSDynaWFVerInstBase.getInstVer();
            xmlNode.setAttribute(FIELD_INSTVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaWFVerInstBase.getMemo() != null) {
            object = pSDynaWFVerInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaInstId() != null) {
            object = pSDynaWFVerInstBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaInstName() != null) {
            object = pSDynaWFVerInstBase.getPSDynaInstName();
            xmlNode.setAttribute(FIELD_PSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaWFVerId() != null) {
            object = pSDynaWFVerInstBase.getPSDynaWFVerId();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaWFVerInstId() != null) {
            object = pSDynaWFVerInstBase.getPSDynaWFVerInstId();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaWFVerInstName() != null) {
            object = pSDynaWFVerInstBase.getPSDynaWFVerInstName();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getPSDynaWFVerName() != null) {
            object = pSDynaWFVerInstBase.getPSDynaWFVerName();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getUpdateDate() != null) {
            object = pSDynaWFVerInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaWFVerInstBase.getUpdateMan() != null) {
            object = pSDynaWFVerInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFVerInstBase.getValidFlag() != null) {
            object = pSDynaWFVerInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaWFVerInstBase.getWFVersion() != null) {
            object = pSDynaWFVerInstBase.getWFVersion();
            xmlNode.setAttribute(FIELD_WFVERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaWFVerInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaWFVerInstBase pSDynaWFVerInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaWFVerInstBase.isCreateDateDirty() && (bl || pSDynaWFVerInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaWFVerInstBase.getCreateDate());
        }
        if (pSDynaWFVerInstBase.isCreateManDirty() && (bl || pSDynaWFVerInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaWFVerInstBase.getCreateMan());
        }
        if (pSDynaWFVerInstBase.isDynaModelDirty() && (bl || pSDynaWFVerInstBase.getDynaModel() != null)) {
            iDataObject.set(FIELD_DYNAMODEL, (Object)pSDynaWFVerInstBase.getDynaModel());
        }
        if (pSDynaWFVerInstBase.isInstVerDirty() && (bl || pSDynaWFVerInstBase.getInstVer() != null)) {
            iDataObject.set(FIELD_INSTVER, (Object)pSDynaWFVerInstBase.getInstVer());
        }
        if (pSDynaWFVerInstBase.isMemoDirty() && (bl || pSDynaWFVerInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaWFVerInstBase.getMemo());
        }
        if (pSDynaWFVerInstBase.isPSDynaInstIdDirty() && (bl || pSDynaWFVerInstBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDynaWFVerInstBase.getPSDynaInstId());
        }
        if (pSDynaWFVerInstBase.isPSDynaInstNameDirty() && (bl || pSDynaWFVerInstBase.getPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTNAME, (Object)pSDynaWFVerInstBase.getPSDynaInstName());
        }
        if (pSDynaWFVerInstBase.isPSDynaWFVerIdDirty() && (bl || pSDynaWFVerInstBase.getPSDynaWFVerId() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERID, (Object)pSDynaWFVerInstBase.getPSDynaWFVerId());
        }
        if (pSDynaWFVerInstBase.isPSDynaWFVerInstIdDirty() && (bl || pSDynaWFVerInstBase.getPSDynaWFVerInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERINSTID, (Object)pSDynaWFVerInstBase.getPSDynaWFVerInstId());
        }
        if (pSDynaWFVerInstBase.isPSDynaWFVerInstNameDirty() && (bl || pSDynaWFVerInstBase.getPSDynaWFVerInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERINSTNAME, (Object)pSDynaWFVerInstBase.getPSDynaWFVerInstName());
        }
        if (pSDynaWFVerInstBase.isPSDynaWFVerNameDirty() && (bl || pSDynaWFVerInstBase.getPSDynaWFVerName() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERNAME, (Object)pSDynaWFVerInstBase.getPSDynaWFVerName());
        }
        if (pSDynaWFVerInstBase.isUpdateDateDirty() && (bl || pSDynaWFVerInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaWFVerInstBase.getUpdateDate());
        }
        if (pSDynaWFVerInstBase.isUpdateManDirty() && (bl || pSDynaWFVerInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaWFVerInstBase.getUpdateMan());
        }
        if (pSDynaWFVerInstBase.isValidFlagDirty() && (bl || pSDynaWFVerInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDynaWFVerInstBase.getValidFlag());
        }
        if (pSDynaWFVerInstBase.isWFVersionDirty() && (bl || pSDynaWFVerInstBase.getWFVersion() != null)) {
            iDataObject.set(FIELD_WFVERSION, (Object)pSDynaWFVerInstBase.getWFVersion());
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
        return PSDynaWFVerInstBase.remove(this, n);
    }

    private static boolean remove(PSDynaWFVerInstBase pSDynaWFVerInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaWFVerInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaWFVerInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaWFVerInstBase.resetDynaModel();
                return true;
            }
            case 3: {
                pSDynaWFVerInstBase.resetInstVer();
                return true;
            }
            case 4: {
                pSDynaWFVerInstBase.resetMemo();
                return true;
            }
            case 5: {
                pSDynaWFVerInstBase.resetPSDynaInstId();
                return true;
            }
            case 6: {
                pSDynaWFVerInstBase.resetPSDynaInstName();
                return true;
            }
            case 7: {
                pSDynaWFVerInstBase.resetPSDynaWFVerId();
                return true;
            }
            case 8: {
                pSDynaWFVerInstBase.resetPSDynaWFVerInstId();
                return true;
            }
            case 9: {
                pSDynaWFVerInstBase.resetPSDynaWFVerInstName();
                return true;
            }
            case 10: {
                pSDynaWFVerInstBase.resetPSDynaWFVerName();
                return true;
            }
            case 11: {
                pSDynaWFVerInstBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDynaWFVerInstBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDynaWFVerInstBase.resetValidFlag();
                return true;
            }
            case 14: {
                pSDynaWFVerInstBase.resetWFVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaInst getPSDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInst();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaInstLock;
        synchronized (n) {
            if (this.psdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaInstId(), (Object)this.psdynainst.getPSDynaInstId()) != 0L) {
                this.psdynainst = null;
            }
            if (this.psdynainst == null) {
                PSDynaInst pSDynaInst = new PSDynaInst();
                pSDynaInst.setPSDynaInstId(this.getPSDynaInstId());
                PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaInstService.autoGet(pSDynaInst);
                this.psdynainst = pSDynaInst;
            }
            return this.psdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaWFVer getPSDynaWFVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVer();
        }
        if (this.getPSDynaWFVerId() == null) {
            return null;
        }
        Integer n = this.objPSDynaWFVerLock;
        synchronized (n) {
            if (this.psdynawfver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaWFVerId(), (Object)this.psdynawfver.getPSDynaWFVerId()) != 0L) {
                this.psdynawfver = null;
            }
            if (this.psdynawfver == null) {
                PSDynaWFVer pSDynaWFVer = new PSDynaWFVer();
                pSDynaWFVer.setPSDynaWFVerId(this.getPSDynaWFVerId());
                PSDynaWFVerService pSDynaWFVerService = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
                pSDynaWFVerService.autoGet(pSDynaWFVer);
                this.psdynawfver = pSDynaWFVer;
            }
            return this.psdynawfver;
        }
    }

    private PSDynaWFVerInstBase getProxyEntity() {
        return this.proxyPSDynaWFVerInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaWFVerInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaWFVerInstBase) {
            this.proxyPSDynaWFVerInstBase = (PSDynaWFVerInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODEL, 2);
        fieldIndexMap.put(FIELD_INSTVER, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 5);
        fieldIndexMap.put(FIELD_PSDYNAINSTNAME, 6);
        fieldIndexMap.put(FIELD_PSDYNAWFVERID, 7);
        fieldIndexMap.put(FIELD_PSDYNAWFVERINSTID, 8);
        fieldIndexMap.put(FIELD_PSDYNAWFVERINSTNAME, 9);
        fieldIndexMap.put(FIELD_PSDYNAWFVERNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
        fieldIndexMap.put(FIELD_WFVERSION, 14);
    }
}

