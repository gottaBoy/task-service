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

public abstract class PSUWDEMainStateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWDEMainStateBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSUWDEMAINSTATEID = "PSUWDEMAINSTATEID";
    public static final String FIELD_PSUWDEMAINSTATENAME = "PSUWDEMAINSTATENAME";
    public static final String FIELD_STATE2PSDEFID = "STATE2PSDEFID";
    public static final String FIELD_STATE2PSDEFNAME = "STATE2PSDEFNAME";
    public static final String FIELD_STATE3PSDEFID = "STATE3PSDEFID";
    public static final String FIELD_STATE3PSDEFNAME = "STATE3PSDEFNAME";
    public static final String FIELD_STATEPSDEFID = "STATEPSDEFID";
    public static final String FIELD_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEID = 2;
    private static final int INDEX_PSDYNAINSTID = 3;
    private static final int INDEX_PSUWDEMAINSTATEID = 4;
    private static final int INDEX_PSUWDEMAINSTATENAME = 5;
    private static final int INDEX_STATE2PSDEFID = 6;
    private static final int INDEX_STATE2PSDEFNAME = 7;
    private static final int INDEX_STATE3PSDEFID = 8;
    private static final int INDEX_STATE3PSDEFNAME = 9;
    private static final int INDEX_STATEPSDEFID = 10;
    private static final int INDEX_STATEPSDEFNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWDEMainStateBase proxyPSUWDEMainStateBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psuwdemainstateidDirtyFlag = false;
    private boolean psuwdemainstatenameDirtyFlag = false;
    private boolean state2psdefidDirtyFlag = false;
    private boolean state2psdefnameDirtyFlag = false;
    private boolean state3psdefidDirtyFlag = false;
    private boolean state3psdefnameDirtyFlag = false;
    private boolean statepsdefidDirtyFlag = false;
    private boolean statepsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psuwdemainstateid")
    private String psuwdemainstateid;
    @Column(name="psuwdemainstatename")
    private String psuwdemainstatename;
    @Column(name="state2psdefid")
    private String state2psdefid;
    @Column(name="state2psdefname")
    private String state2psdefname;
    @Column(name="state3psdefid")
    private String state3psdefid;
    @Column(name="state3psdefname")
    private String state3psdefname;
    @Column(name="statepsdefid")
    private String statepsdefid;
    @Column(name="statepsdefname")
    private String statepsdefname;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
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

    public void setPSUWDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwdemainstateid = string;
        this.psuwdemainstateidDirtyFlag = true;
    }

    public String getPSUWDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWDEMainStateId();
        }
        return this.psuwdemainstateid;
    }

    public boolean isPSUWDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWDEMainStateIdDirty();
        }
        return this.psuwdemainstateidDirtyFlag;
    }

    public void resetPSUWDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWDEMainStateId();
            return;
        }
        this.psuwdemainstateidDirtyFlag = false;
        this.psuwdemainstateid = null;
    }

    public void setPSUWDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwdemainstatename = string;
        this.psuwdemainstatenameDirtyFlag = true;
    }

    public String getPSUWDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWDEMainStateName();
        }
        return this.psuwdemainstatename;
    }

    public boolean isPSUWDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWDEMainStateNameDirty();
        }
        return this.psuwdemainstatenameDirtyFlag;
    }

    public void resetPSUWDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWDEMainStateName();
            return;
        }
        this.psuwdemainstatenameDirtyFlag = false;
        this.psuwdemainstatename = null;
    }

    public void setState2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state2psdefid = string;
        this.state2psdefidDirtyFlag = true;
    }

    public String getState2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState2PSDEFId();
        }
        return this.state2psdefid;
    }

    public boolean isState2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState2PSDEFIdDirty();
        }
        return this.state2psdefidDirtyFlag;
    }

    public void resetState2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState2PSDEFId();
            return;
        }
        this.state2psdefidDirtyFlag = false;
        this.state2psdefid = null;
    }

    public void setState2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state2psdefname = string;
        this.state2psdefnameDirtyFlag = true;
    }

    public String getState2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState2PSDEFName();
        }
        return this.state2psdefname;
    }

    public boolean isState2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState2PSDEFNameDirty();
        }
        return this.state2psdefnameDirtyFlag;
    }

    public void resetState2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState2PSDEFName();
            return;
        }
        this.state2psdefnameDirtyFlag = false;
        this.state2psdefname = null;
    }

    public void setState3PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState3PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state3psdefid = string;
        this.state3psdefidDirtyFlag = true;
    }

    public String getState3PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState3PSDEFId();
        }
        return this.state3psdefid;
    }

    public boolean isState3PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState3PSDEFIdDirty();
        }
        return this.state3psdefidDirtyFlag;
    }

    public void resetState3PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState3PSDEFId();
            return;
        }
        this.state3psdefidDirtyFlag = false;
        this.state3psdefid = null;
    }

    public void setState3PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setState3PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.state3psdefname = string;
        this.state3psdefnameDirtyFlag = true;
    }

    public String getState3PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getState3PSDEFName();
        }
        return this.state3psdefname;
    }

    public boolean isState3PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isState3PSDEFNameDirty();
        }
        return this.state3psdefnameDirtyFlag;
    }

    public void resetState3PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetState3PSDEFName();
            return;
        }
        this.state3psdefnameDirtyFlag = false;
        this.state3psdefname = null;
    }

    public void setStatePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStatePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statepsdefid = string;
        this.statepsdefidDirtyFlag = true;
    }

    public String getStatePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStatePSDEFId();
        }
        return this.statepsdefid;
    }

    public boolean isStatePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStatePSDEFIdDirty();
        }
        return this.statepsdefidDirtyFlag;
    }

    public void resetStatePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStatePSDEFId();
            return;
        }
        this.statepsdefidDirtyFlag = false;
        this.statepsdefid = null;
    }

    public void setStatePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStatePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statepsdefname = string;
        this.statepsdefnameDirtyFlag = true;
    }

    public String getStatePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStatePSDEFName();
        }
        return this.statepsdefname;
    }

    public boolean isStatePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStatePSDEFNameDirty();
        }
        return this.statepsdefnameDirtyFlag;
    }

    public void resetStatePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStatePSDEFName();
            return;
        }
        this.statepsdefnameDirtyFlag = false;
        this.statepsdefname = null;
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
        PSUWDEMainStateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWDEMainStateBase pSUWDEMainStateBase) {
        pSUWDEMainStateBase.resetCreateDate();
        pSUWDEMainStateBase.resetCreateMan();
        pSUWDEMainStateBase.resetPSDEId();
        pSUWDEMainStateBase.resetPSDynaInstId();
        pSUWDEMainStateBase.resetPSUWDEMainStateId();
        pSUWDEMainStateBase.resetPSUWDEMainStateName();
        pSUWDEMainStateBase.resetState2PSDEFId();
        pSUWDEMainStateBase.resetState2PSDEFName();
        pSUWDEMainStateBase.resetState3PSDEFId();
        pSUWDEMainStateBase.resetState3PSDEFName();
        pSUWDEMainStateBase.resetStatePSDEFId();
        pSUWDEMainStateBase.resetStatePSDEFName();
        pSUWDEMainStateBase.resetUpdateDate();
        pSUWDEMainStateBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSUWDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSUWDEMAINSTATEID, this.getPSUWDEMainStateId());
        }
        if (!bl || this.isPSUWDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSUWDEMAINSTATENAME, this.getPSUWDEMainStateName());
        }
        if (!bl || this.isState2PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE2PSDEFID, this.getState2PSDEFId());
        }
        if (!bl || this.isState2PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE2PSDEFNAME, this.getState2PSDEFName());
        }
        if (!bl || this.isState3PSDEFIdDirty()) {
            hashMap.put(FIELD_STATE3PSDEFID, this.getState3PSDEFId());
        }
        if (!bl || this.isState3PSDEFNameDirty()) {
            hashMap.put(FIELD_STATE3PSDEFNAME, this.getState3PSDEFName());
        }
        if (!bl || this.isStatePSDEFIdDirty()) {
            hashMap.put(FIELD_STATEPSDEFID, this.getStatePSDEFId());
        }
        if (!bl || this.isStatePSDEFNameDirty()) {
            hashMap.put(FIELD_STATEPSDEFNAME, this.getStatePSDEFName());
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
        return PSUWDEMainStateBase.get(this, n);
    }

    private static Object get(PSUWDEMainStateBase pSUWDEMainStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEMainStateBase.getCreateDate();
            }
            case 1: {
                return pSUWDEMainStateBase.getCreateMan();
            }
            case 2: {
                return pSUWDEMainStateBase.getPSDEId();
            }
            case 3: {
                return pSUWDEMainStateBase.getPSDynaInstId();
            }
            case 4: {
                return pSUWDEMainStateBase.getPSUWDEMainStateId();
            }
            case 5: {
                return pSUWDEMainStateBase.getPSUWDEMainStateName();
            }
            case 6: {
                return pSUWDEMainStateBase.getState2PSDEFId();
            }
            case 7: {
                return pSUWDEMainStateBase.getState2PSDEFName();
            }
            case 8: {
                return pSUWDEMainStateBase.getState3PSDEFId();
            }
            case 9: {
                return pSUWDEMainStateBase.getState3PSDEFName();
            }
            case 10: {
                return pSUWDEMainStateBase.getStatePSDEFId();
            }
            case 11: {
                return pSUWDEMainStateBase.getStatePSDEFName();
            }
            case 12: {
                return pSUWDEMainStateBase.getUpdateDate();
            }
            case 13: {
                return pSUWDEMainStateBase.getUpdateMan();
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
        PSUWDEMainStateBase.set(this, n, object);
    }

    private static void set(PSUWDEMainStateBase pSUWDEMainStateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWDEMainStateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUWDEMainStateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWDEMainStateBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWDEMainStateBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWDEMainStateBase.setPSUWDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWDEMainStateBase.setPSUWDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWDEMainStateBase.setState2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWDEMainStateBase.setState2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWDEMainStateBase.setState3PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWDEMainStateBase.setState3PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWDEMainStateBase.setStatePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWDEMainStateBase.setStatePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWDEMainStateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSUWDEMainStateBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUWDEMainStateBase.isNull(this, n);
    }

    private static boolean isNull(PSUWDEMainStateBase pSUWDEMainStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEMainStateBase.getCreateDate() == null;
            }
            case 1: {
                return pSUWDEMainStateBase.getCreateMan() == null;
            }
            case 2: {
                return pSUWDEMainStateBase.getPSDEId() == null;
            }
            case 3: {
                return pSUWDEMainStateBase.getPSDynaInstId() == null;
            }
            case 4: {
                return pSUWDEMainStateBase.getPSUWDEMainStateId() == null;
            }
            case 5: {
                return pSUWDEMainStateBase.getPSUWDEMainStateName() == null;
            }
            case 6: {
                return pSUWDEMainStateBase.getState2PSDEFId() == null;
            }
            case 7: {
                return pSUWDEMainStateBase.getState2PSDEFName() == null;
            }
            case 8: {
                return pSUWDEMainStateBase.getState3PSDEFId() == null;
            }
            case 9: {
                return pSUWDEMainStateBase.getState3PSDEFName() == null;
            }
            case 10: {
                return pSUWDEMainStateBase.getStatePSDEFId() == null;
            }
            case 11: {
                return pSUWDEMainStateBase.getStatePSDEFName() == null;
            }
            case 12: {
                return pSUWDEMainStateBase.getUpdateDate() == null;
            }
            case 13: {
                return pSUWDEMainStateBase.getUpdateMan() == null;
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
        return PSUWDEMainStateBase.contains(this, n);
    }

    private static boolean contains(PSUWDEMainStateBase pSUWDEMainStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEMainStateBase.isCreateDateDirty();
            }
            case 1: {
                return pSUWDEMainStateBase.isCreateManDirty();
            }
            case 2: {
                return pSUWDEMainStateBase.isPSDEIdDirty();
            }
            case 3: {
                return pSUWDEMainStateBase.isPSDynaInstIdDirty();
            }
            case 4: {
                return pSUWDEMainStateBase.isPSUWDEMainStateIdDirty();
            }
            case 5: {
                return pSUWDEMainStateBase.isPSUWDEMainStateNameDirty();
            }
            case 6: {
                return pSUWDEMainStateBase.isState2PSDEFIdDirty();
            }
            case 7: {
                return pSUWDEMainStateBase.isState2PSDEFNameDirty();
            }
            case 8: {
                return pSUWDEMainStateBase.isState3PSDEFIdDirty();
            }
            case 9: {
                return pSUWDEMainStateBase.isState3PSDEFNameDirty();
            }
            case 10: {
                return pSUWDEMainStateBase.isStatePSDEFIdDirty();
            }
            case 11: {
                return pSUWDEMainStateBase.isStatePSDEFNameDirty();
            }
            case 12: {
                return pSUWDEMainStateBase.isUpdateDateDirty();
            }
            case 13: {
                return pSUWDEMainStateBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWDEMainStateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWDEMainStateBase pSUWDEMainStateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWDEMainStateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getPSUWDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwdemainstateid", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getPSUWDEMainStateId()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getPSUWDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwdemainstatename", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getPSUWDEMainStateName()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getState2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state2psdefid", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getState2PSDEFId()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getState2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state2psdefname", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getState2PSDEFName()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getState3PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state3psdefid", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getState3PSDEFId()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getState3PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"state3psdefname", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getState3PSDEFName()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getStatePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefid", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getStatePSDEFId()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getStatePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefname", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getStatePSDEFName()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWDEMainStateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWDEMainStateBase.getJSONValue((Object)pSUWDEMainStateBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWDEMainStateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWDEMainStateBase pSUWDEMainStateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWDEMainStateBase.getCreateDate() != null) {
            object = pSUWDEMainStateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWDEMainStateBase.getCreateMan() != null) {
            object = pSUWDEMainStateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getPSDEId() != null) {
            object = pSUWDEMainStateBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getPSDynaInstId() != null) {
            object = pSUWDEMainStateBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getPSUWDEMainStateId() != null) {
            object = pSUWDEMainStateBase.getPSUWDEMainStateId();
            xmlNode.setAttribute(FIELD_PSUWDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getPSUWDEMainStateName() != null) {
            object = pSUWDEMainStateBase.getPSUWDEMainStateName();
            xmlNode.setAttribute(FIELD_PSUWDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getState2PSDEFId() != null) {
            object = pSUWDEMainStateBase.getState2PSDEFId();
            xmlNode.setAttribute(FIELD_STATE2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getState2PSDEFName() != null) {
            object = pSUWDEMainStateBase.getState2PSDEFName();
            xmlNode.setAttribute(FIELD_STATE2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getState3PSDEFId() != null) {
            object = pSUWDEMainStateBase.getState3PSDEFId();
            xmlNode.setAttribute(FIELD_STATE3PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getState3PSDEFName() != null) {
            object = pSUWDEMainStateBase.getState3PSDEFName();
            xmlNode.setAttribute(FIELD_STATE3PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getStatePSDEFId() != null) {
            object = pSUWDEMainStateBase.getStatePSDEFId();
            xmlNode.setAttribute(FIELD_STATEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getStatePSDEFName() != null) {
            object = pSUWDEMainStateBase.getStatePSDEFName();
            xmlNode.setAttribute(FIELD_STATEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEMainStateBase.getUpdateDate() != null) {
            object = pSUWDEMainStateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWDEMainStateBase.getUpdateMan() != null) {
            object = pSUWDEMainStateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWDEMainStateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWDEMainStateBase pSUWDEMainStateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWDEMainStateBase.isCreateDateDirty() && (bl || pSUWDEMainStateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWDEMainStateBase.getCreateDate());
        }
        if (pSUWDEMainStateBase.isCreateManDirty() && (bl || pSUWDEMainStateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWDEMainStateBase.getCreateMan());
        }
        if (pSUWDEMainStateBase.isPSDEIdDirty() && (bl || pSUWDEMainStateBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWDEMainStateBase.getPSDEId());
        }
        if (pSUWDEMainStateBase.isPSDynaInstIdDirty() && (bl || pSUWDEMainStateBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWDEMainStateBase.getPSDynaInstId());
        }
        if (pSUWDEMainStateBase.isPSUWDEMainStateIdDirty() && (bl || pSUWDEMainStateBase.getPSUWDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSUWDEMAINSTATEID, (Object)pSUWDEMainStateBase.getPSUWDEMainStateId());
        }
        if (pSUWDEMainStateBase.isPSUWDEMainStateNameDirty() && (bl || pSUWDEMainStateBase.getPSUWDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSUWDEMAINSTATENAME, (Object)pSUWDEMainStateBase.getPSUWDEMainStateName());
        }
        if (pSUWDEMainStateBase.isState2PSDEFIdDirty() && (bl || pSUWDEMainStateBase.getState2PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE2PSDEFID, (Object)pSUWDEMainStateBase.getState2PSDEFId());
        }
        if (pSUWDEMainStateBase.isState2PSDEFNameDirty() && (bl || pSUWDEMainStateBase.getState2PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE2PSDEFNAME, (Object)pSUWDEMainStateBase.getState2PSDEFName());
        }
        if (pSUWDEMainStateBase.isState3PSDEFIdDirty() && (bl || pSUWDEMainStateBase.getState3PSDEFId() != null)) {
            iDataObject.set(FIELD_STATE3PSDEFID, (Object)pSUWDEMainStateBase.getState3PSDEFId());
        }
        if (pSUWDEMainStateBase.isState3PSDEFNameDirty() && (bl || pSUWDEMainStateBase.getState3PSDEFName() != null)) {
            iDataObject.set(FIELD_STATE3PSDEFNAME, (Object)pSUWDEMainStateBase.getState3PSDEFName());
        }
        if (pSUWDEMainStateBase.isStatePSDEFIdDirty() && (bl || pSUWDEMainStateBase.getStatePSDEFId() != null)) {
            iDataObject.set(FIELD_STATEPSDEFID, (Object)pSUWDEMainStateBase.getStatePSDEFId());
        }
        if (pSUWDEMainStateBase.isStatePSDEFNameDirty() && (bl || pSUWDEMainStateBase.getStatePSDEFName() != null)) {
            iDataObject.set(FIELD_STATEPSDEFNAME, (Object)pSUWDEMainStateBase.getStatePSDEFName());
        }
        if (pSUWDEMainStateBase.isUpdateDateDirty() && (bl || pSUWDEMainStateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWDEMainStateBase.getUpdateDate());
        }
        if (pSUWDEMainStateBase.isUpdateManDirty() && (bl || pSUWDEMainStateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWDEMainStateBase.getUpdateMan());
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
        return PSUWDEMainStateBase.remove(this, n);
    }

    private static boolean remove(PSUWDEMainStateBase pSUWDEMainStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWDEMainStateBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUWDEMainStateBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUWDEMainStateBase.resetPSDEId();
                return true;
            }
            case 3: {
                pSUWDEMainStateBase.resetPSDynaInstId();
                return true;
            }
            case 4: {
                pSUWDEMainStateBase.resetPSUWDEMainStateId();
                return true;
            }
            case 5: {
                pSUWDEMainStateBase.resetPSUWDEMainStateName();
                return true;
            }
            case 6: {
                pSUWDEMainStateBase.resetState2PSDEFId();
                return true;
            }
            case 7: {
                pSUWDEMainStateBase.resetState2PSDEFName();
                return true;
            }
            case 8: {
                pSUWDEMainStateBase.resetState3PSDEFId();
                return true;
            }
            case 9: {
                pSUWDEMainStateBase.resetState3PSDEFName();
                return true;
            }
            case 10: {
                pSUWDEMainStateBase.resetStatePSDEFId();
                return true;
            }
            case 11: {
                pSUWDEMainStateBase.resetStatePSDEFName();
                return true;
            }
            case 12: {
                pSUWDEMainStateBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSUWDEMainStateBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWDEMainStateBase getProxyEntity() {
        return this.proxyPSUWDEMainStateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWDEMainStateBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWDEMainStateBase) {
            this.proxyPSUWDEMainStateBase = (PSUWDEMainStateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWDEMainStateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEID, 2);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 3);
        fieldIndexMap.put(FIELD_PSUWDEMAINSTATEID, 4);
        fieldIndexMap.put(FIELD_PSUWDEMAINSTATENAME, 5);
        fieldIndexMap.put(FIELD_STATE2PSDEFID, 6);
        fieldIndexMap.put(FIELD_STATE2PSDEFNAME, 7);
        fieldIndexMap.put(FIELD_STATE3PSDEFID, 8);
        fieldIndexMap.put(FIELD_STATE3PSDEFNAME, 9);
        fieldIndexMap.put(FIELD_STATEPSDEFID, 10);
        fieldIndexMap.put(FIELD_STATEPSDEFNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

