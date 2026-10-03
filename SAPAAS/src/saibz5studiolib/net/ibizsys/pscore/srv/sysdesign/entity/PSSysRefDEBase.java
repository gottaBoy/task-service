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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRefDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysRefDEBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORIPSDEID = "ORIPSDEID";
    public static final String FIELD_PSSYSREFDEID = "PSSYSREFDEID";
    public static final String FIELD_PSSYSREFDENAME = "PSSYSREFDENAME";
    public static final String FIELD_PSSYSREFID = "PSSYSREFID";
    public static final String FIELD_PSSYSREFNAME = "PSSYSREFNAME";
    public static final String FIELD_SERVICECLS = "SERVICECLS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORIPSDEID = 4;
    private static final int INDEX_PSSYSREFDEID = 5;
    private static final int INDEX_PSSYSREFDENAME = 6;
    private static final int INDEX_PSSYSREFID = 7;
    private static final int INDEX_PSSYSREFNAME = 8;
    private static final int INDEX_SERVICECLS = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysRefDEBase proxyPSSysRefDEBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean oripsdeidDirtyFlag = false;
    private boolean pssysrefdeidDirtyFlag = false;
    private boolean pssysrefdenameDirtyFlag = false;
    private boolean pssysrefidDirtyFlag = false;
    private boolean pssysrefnameDirtyFlag = false;
    private boolean serviceclsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="oripsdeid")
    private String oripsdeid;
    @Column(name="pssysrefdeid")
    private String pssysrefdeid;
    @Column(name="pssysrefdename")
    private String pssysrefdename;
    @Column(name="pssysrefid")
    private String pssysrefid;
    @Column(name="pssysrefname")
    private String pssysrefname;
    @Column(name="servicecls")
    private String servicecls;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysRefLock = new Integer(1);
    private PSSysRef pssysref = null;
    private Integer objPSDEMapsLock = new Integer(1);
    private ArrayList<PSDEMap> psdemaps = null;

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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setOriPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOriPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.oripsdeid = string;
        this.oripsdeidDirtyFlag = true;
    }

    public String getOriPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOriPSDEId();
        }
        return this.oripsdeid;
    }

    public boolean isOriPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOriPSDEIdDirty();
        }
        return this.oripsdeidDirtyFlag;
    }

    public void resetOriPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOriPSDEId();
            return;
        }
        this.oripsdeidDirtyFlag = false;
        this.oripsdeid = null;
    }

    public void setPSSysRefDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefdeid = string;
        this.pssysrefdeidDirtyFlag = true;
    }

    public String getPSSysRefDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefDEId();
        }
        return this.pssysrefdeid;
    }

    public boolean isPSSysRefDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefDEIdDirty();
        }
        return this.pssysrefdeidDirtyFlag;
    }

    public void resetPSSysRefDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefDEId();
            return;
        }
        this.pssysrefdeidDirtyFlag = false;
        this.pssysrefdeid = null;
    }

    public void setPSSysRefDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefdename = string;
        this.pssysrefdenameDirtyFlag = true;
    }

    public String getPSSysRefDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefDEName();
        }
        return this.pssysrefdename;
    }

    public boolean isPSSysRefDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefDENameDirty();
        }
        return this.pssysrefdenameDirtyFlag;
    }

    public void resetPSSysRefDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefDEName();
            return;
        }
        this.pssysrefdenameDirtyFlag = false;
        this.pssysrefdename = null;
    }

    public void setPSSysRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefid = string;
        this.pssysrefidDirtyFlag = true;
    }

    public String getPSSysRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefId();
        }
        return this.pssysrefid;
    }

    public boolean isPSSysRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefIdDirty();
        }
        return this.pssysrefidDirtyFlag;
    }

    public void resetPSSysRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefId();
            return;
        }
        this.pssysrefidDirtyFlag = false;
        this.pssysrefid = null;
    }

    public void setPSSysRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefname = string;
        this.pssysrefnameDirtyFlag = true;
    }

    public String getPSSysRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefName();
        }
        return this.pssysrefname;
    }

    public boolean isPSSysRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefNameDirty();
        }
        return this.pssysrefnameDirtyFlag;
    }

    public void resetPSSysRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefName();
            return;
        }
        this.pssysrefnameDirtyFlag = false;
        this.pssysrefname = null;
    }

    public void setServiceCls(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCls(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecls = string;
        this.serviceclsDirtyFlag = true;
    }

    public String getServiceCls() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCls();
        }
        return this.servicecls;
    }

    public boolean isServiceClsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceClsDirty();
        }
        return this.serviceclsDirtyFlag;
    }

    public void resetServiceCls() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCls();
            return;
        }
        this.serviceclsDirtyFlag = false;
        this.servicecls = null;
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
        PSSysRefDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysRefDEBase pSSysRefDEBase) {
        pSSysRefDEBase.resetCreateDate();
        pSSysRefDEBase.resetCreateMan();
        pSSysRefDEBase.resetLogicName();
        pSSysRefDEBase.resetMemo();
        pSSysRefDEBase.resetOriPSDEId();
        pSSysRefDEBase.resetPSSysRefDEId();
        pSSysRefDEBase.resetPSSysRefDEName();
        pSSysRefDEBase.resetPSSysRefId();
        pSSysRefDEBase.resetPSSysRefName();
        pSSysRefDEBase.resetServiceCls();
        pSSysRefDEBase.resetUpdateDate();
        pSSysRefDEBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOriPSDEIdDirty()) {
            hashMap.put(FIELD_ORIPSDEID, this.getOriPSDEId());
        }
        if (!bl || this.isPSSysRefDEIdDirty()) {
            hashMap.put(FIELD_PSSYSREFDEID, this.getPSSysRefDEId());
        }
        if (!bl || this.isPSSysRefDENameDirty()) {
            hashMap.put(FIELD_PSSYSREFDENAME, this.getPSSysRefDEName());
        }
        if (!bl || this.isPSSysRefIdDirty()) {
            hashMap.put(FIELD_PSSYSREFID, this.getPSSysRefId());
        }
        if (!bl || this.isPSSysRefNameDirty()) {
            hashMap.put(FIELD_PSSYSREFNAME, this.getPSSysRefName());
        }
        if (!bl || this.isServiceClsDirty()) {
            hashMap.put(FIELD_SERVICECLS, this.getServiceCls());
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
        return PSSysRefDEBase.get(this, n);
    }

    private static Object get(PSSysRefDEBase pSSysRefDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRefDEBase.getCreateDate();
            }
            case 1: {
                return pSSysRefDEBase.getCreateMan();
            }
            case 2: {
                return pSSysRefDEBase.getLogicName();
            }
            case 3: {
                return pSSysRefDEBase.getMemo();
            }
            case 4: {
                return pSSysRefDEBase.getOriPSDEId();
            }
            case 5: {
                return pSSysRefDEBase.getPSSysRefDEId();
            }
            case 6: {
                return pSSysRefDEBase.getPSSysRefDEName();
            }
            case 7: {
                return pSSysRefDEBase.getPSSysRefId();
            }
            case 8: {
                return pSSysRefDEBase.getPSSysRefName();
            }
            case 9: {
                return pSSysRefDEBase.getServiceCls();
            }
            case 10: {
                return pSSysRefDEBase.getUpdateDate();
            }
            case 11: {
                return pSSysRefDEBase.getUpdateMan();
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
        PSSysRefDEBase.set(this, n, object);
    }

    private static void set(PSSysRefDEBase pSSysRefDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysRefDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysRefDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysRefDEBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysRefDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysRefDEBase.setOriPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysRefDEBase.setPSSysRefDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysRefDEBase.setPSSysRefDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysRefDEBase.setPSSysRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysRefDEBase.setPSSysRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysRefDEBase.setServiceCls(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysRefDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysRefDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysRefDEBase.isNull(this, n);
    }

    private static boolean isNull(PSSysRefDEBase pSSysRefDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRefDEBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysRefDEBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysRefDEBase.getLogicName() == null;
            }
            case 3: {
                return pSSysRefDEBase.getMemo() == null;
            }
            case 4: {
                return pSSysRefDEBase.getOriPSDEId() == null;
            }
            case 5: {
                return pSSysRefDEBase.getPSSysRefDEId() == null;
            }
            case 6: {
                return pSSysRefDEBase.getPSSysRefDEName() == null;
            }
            case 7: {
                return pSSysRefDEBase.getPSSysRefId() == null;
            }
            case 8: {
                return pSSysRefDEBase.getPSSysRefName() == null;
            }
            case 9: {
                return pSSysRefDEBase.getServiceCls() == null;
            }
            case 10: {
                return pSSysRefDEBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysRefDEBase.getUpdateMan() == null;
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
        return PSSysRefDEBase.contains(this, n);
    }

    private static boolean contains(PSSysRefDEBase pSSysRefDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRefDEBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysRefDEBase.isCreateManDirty();
            }
            case 2: {
                return pSSysRefDEBase.isLogicNameDirty();
            }
            case 3: {
                return pSSysRefDEBase.isMemoDirty();
            }
            case 4: {
                return pSSysRefDEBase.isOriPSDEIdDirty();
            }
            case 5: {
                return pSSysRefDEBase.isPSSysRefDEIdDirty();
            }
            case 6: {
                return pSSysRefDEBase.isPSSysRefDENameDirty();
            }
            case 7: {
                return pSSysRefDEBase.isPSSysRefIdDirty();
            }
            case 8: {
                return pSSysRefDEBase.isPSSysRefNameDirty();
            }
            case 9: {
                return pSSysRefDEBase.isServiceClsDirty();
            }
            case 10: {
                return pSSysRefDEBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysRefDEBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysRefDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysRefDEBase pSSysRefDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysRefDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getOriPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"oripsdeid", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getOriPSDEId()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getPSSysRefDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefdeid", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getPSSysRefDEId()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getPSSysRefDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefdename", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getPSSysRefDEName()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getPSSysRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefid", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getPSSysRefId()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getPSSysRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefname", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getPSSysRefName()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getServiceCls() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecls", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getServiceCls()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysRefDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysRefDEBase.getJSONValue((Object)pSSysRefDEBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysRefDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysRefDEBase pSSysRefDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysRefDEBase.getCreateDate() != null) {
            object = pSSysRefDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRefDEBase.getCreateMan() != null) {
            object = pSSysRefDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getLogicName() != null) {
            object = pSSysRefDEBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getMemo() != null) {
            object = pSSysRefDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getOriPSDEId() != null) {
            object = pSSysRefDEBase.getOriPSDEId();
            xmlNode.setAttribute(FIELD_ORIPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getPSSysRefDEId() != null) {
            object = pSSysRefDEBase.getPSSysRefDEId();
            xmlNode.setAttribute(FIELD_PSSYSREFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getPSSysRefDEName() != null) {
            object = pSSysRefDEBase.getPSSysRefDEName();
            xmlNode.setAttribute(FIELD_PSSYSREFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getPSSysRefId() != null) {
            object = pSSysRefDEBase.getPSSysRefId();
            xmlNode.setAttribute(FIELD_PSSYSREFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getPSSysRefName() != null) {
            object = pSSysRefDEBase.getPSSysRefName();
            xmlNode.setAttribute(FIELD_PSSYSREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getServiceCls() != null) {
            object = pSSysRefDEBase.getServiceCls();
            xmlNode.setAttribute(FIELD_SERVICECLS, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefDEBase.getUpdateDate() != null) {
            object = pSSysRefDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRefDEBase.getUpdateMan() != null) {
            object = pSSysRefDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysRefDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysRefDEBase pSSysRefDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysRefDEBase.isCreateDateDirty() && (bl || pSSysRefDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysRefDEBase.getCreateDate());
        }
        if (pSSysRefDEBase.isCreateManDirty() && (bl || pSSysRefDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysRefDEBase.getCreateMan());
        }
        if (pSSysRefDEBase.isLogicNameDirty() && (bl || pSSysRefDEBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysRefDEBase.getLogicName());
        }
        if (pSSysRefDEBase.isMemoDirty() && (bl || pSSysRefDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysRefDEBase.getMemo());
        }
        if (pSSysRefDEBase.isOriPSDEIdDirty() && (bl || pSSysRefDEBase.getOriPSDEId() != null)) {
            iDataObject.set(FIELD_ORIPSDEID, (Object)pSSysRefDEBase.getOriPSDEId());
        }
        if (pSSysRefDEBase.isPSSysRefDEIdDirty() && (bl || pSSysRefDEBase.getPSSysRefDEId() != null)) {
            iDataObject.set(FIELD_PSSYSREFDEID, (Object)pSSysRefDEBase.getPSSysRefDEId());
        }
        if (pSSysRefDEBase.isPSSysRefDENameDirty() && (bl || pSSysRefDEBase.getPSSysRefDEName() != null)) {
            iDataObject.set(FIELD_PSSYSREFDENAME, (Object)pSSysRefDEBase.getPSSysRefDEName());
        }
        if (pSSysRefDEBase.isPSSysRefIdDirty() && (bl || pSSysRefDEBase.getPSSysRefId() != null)) {
            iDataObject.set(FIELD_PSSYSREFID, (Object)pSSysRefDEBase.getPSSysRefId());
        }
        if (pSSysRefDEBase.isPSSysRefNameDirty() && (bl || pSSysRefDEBase.getPSSysRefName() != null)) {
            iDataObject.set(FIELD_PSSYSREFNAME, (Object)pSSysRefDEBase.getPSSysRefName());
        }
        if (pSSysRefDEBase.isServiceClsDirty() && (bl || pSSysRefDEBase.getServiceCls() != null)) {
            iDataObject.set(FIELD_SERVICECLS, (Object)pSSysRefDEBase.getServiceCls());
        }
        if (pSSysRefDEBase.isUpdateDateDirty() && (bl || pSSysRefDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysRefDEBase.getUpdateDate());
        }
        if (pSSysRefDEBase.isUpdateManDirty() && (bl || pSSysRefDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysRefDEBase.getUpdateMan());
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
        return PSSysRefDEBase.remove(this, n);
    }

    private static boolean remove(PSSysRefDEBase pSSysRefDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysRefDEBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysRefDEBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysRefDEBase.resetLogicName();
                return true;
            }
            case 3: {
                pSSysRefDEBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysRefDEBase.resetOriPSDEId();
                return true;
            }
            case 5: {
                pSSysRefDEBase.resetPSSysRefDEId();
                return true;
            }
            case 6: {
                pSSysRefDEBase.resetPSSysRefDEName();
                return true;
            }
            case 7: {
                pSSysRefDEBase.resetPSSysRefId();
                return true;
            }
            case 8: {
                pSSysRefDEBase.resetPSSysRefName();
                return true;
            }
            case 9: {
                pSSysRefDEBase.resetServiceCls();
                return true;
            }
            case 10: {
                pSSysRefDEBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysRefDEBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysRef getPSSysRef() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRef();
        }
        if (this.getPSSysRefId() == null) {
            return null;
        }
        Integer n = this.objPSSysRefLock;
        synchronized (n) {
            if (this.pssysref != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysRefId(), (Object)this.pssysref.getPSSysRefId()) != 0L) {
                this.pssysref = null;
            }
            if (this.pssysref == null) {
                PSSysRef pSSysRef = new PSSysRef();
                pSSysRef.setPSSysRefId(this.getPSSysRefId());
                PSSysRefService pSSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)this.getSessionFactory());
                pSSysRefService.autoGet(pSSysRef);
                this.pssysref = pSSysRef;
            }
            return this.pssysref;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMap> getPSDEMaps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMaps();
        }
        if (this.getPSSysRefDEId() == null) {
            return null;
        }
        PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMapsLock;
        synchronized (n) {
            if (this.psdemaps == null) {
                this.psdemaps = pSDEMapService.selectByDstPSSysRefDE(this);
            }
            return this.psdemaps;
        }
    }

    private PSSysRefDEBase getProxyEntity() {
        return this.proxyPSSysRefDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysRefDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysRefDEBase) {
            this.proxyPSSysRefDEBase = (PSSysRefDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRefDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORIPSDEID, 4);
        fieldIndexMap.put(FIELD_PSSYSREFDEID, 5);
        fieldIndexMap.put(FIELD_PSSYSREFDENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSREFID, 7);
        fieldIndexMap.put(FIELD_PSSYSREFNAME, 8);
        fieldIndexMap.put(FIELD_SERVICECLS, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

