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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDE;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWF;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaSysBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaSysBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNASYSID = "PSDYNASYSID";
    public static final String FIELD_PSDYNASYSNAME = "PSDYNASYSNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDYNASYSID = 4;
    private static final int INDEX_PSDYNASYSNAME = 5;
    private static final int INDEX_PSSYSTEMID = 6;
    private static final int INDEX_PSSYSTEMNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaSysBase proxyPSDynaSysBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynasysidDirtyFlag = false;
    private boolean psdynasysnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
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
    @Column(name="psdynasysid")
    private String psdynasysid;
    @Column(name="psdynasysname")
    private String psdynasysname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSDynaAppsLock = new Integer(1);
    private ArrayList<PSDynaApp> psdynaapps = null;
    private Integer objPSDynaCodeListsLock = new Integer(1);
    private ArrayList<PSDynaCodeList> psdynacodelists = null;
    private Integer objPSDynaDEsLock = new Integer(1);
    private ArrayList<PSDynaDE> psdynades = null;
    private Integer objPSDynaInstsLock = new Integer(1);
    private ArrayList<PSDynaInst> psdynainsts = null;
    private Integer objPSDynaWFVersLock = new Integer(1);
    private ArrayList<PSDynaWFVer> psdynawfvers = null;
    private Integer objPSDynaWFsLock = new Integer(1);
    private ArrayList<PSDynaWF> psdynawfs = null;

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

    public void setPSDynaSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysid = string;
        this.psdynasysidDirtyFlag = true;
    }

    public String getPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysId();
        }
        return this.psdynasysid;
    }

    public boolean isPSDynaSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysIdDirty();
        }
        return this.psdynasysidDirtyFlag;
    }

    public void resetPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysId();
            return;
        }
        this.psdynasysidDirtyFlag = false;
        this.psdynasysid = null;
    }

    public void setPSDynaSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysname = string;
        this.psdynasysnameDirtyFlag = true;
    }

    public String getPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysName();
        }
        return this.psdynasysname;
    }

    public boolean isPSDynaSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysNameDirty();
        }
        return this.psdynasysnameDirtyFlag;
    }

    public void resetPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysName();
            return;
        }
        this.psdynasysnameDirtyFlag = false;
        this.psdynasysname = null;
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
        PSDynaSysBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaSysBase pSDynaSysBase) {
        pSDynaSysBase.resetCreateDate();
        pSDynaSysBase.resetCreateMan();
        pSDynaSysBase.resetLogicName();
        pSDynaSysBase.resetMemo();
        pSDynaSysBase.resetPSDynaSysId();
        pSDynaSysBase.resetPSDynaSysName();
        pSDynaSysBase.resetPSSystemId();
        pSDynaSysBase.resetPSSystemName();
        pSDynaSysBase.resetUpdateDate();
        pSDynaSysBase.resetUpdateMan();
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
        if (!bl || this.isPSDynaSysIdDirty()) {
            hashMap.put(FIELD_PSDYNASYSID, this.getPSDynaSysId());
        }
        if (!bl || this.isPSDynaSysNameDirty()) {
            hashMap.put(FIELD_PSDYNASYSNAME, this.getPSDynaSysName());
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
        return PSDynaSysBase.get(this, n);
    }

    private static Object get(PSDynaSysBase pSDynaSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaSysBase.getCreateDate();
            }
            case 1: {
                return pSDynaSysBase.getCreateMan();
            }
            case 2: {
                return pSDynaSysBase.getLogicName();
            }
            case 3: {
                return pSDynaSysBase.getMemo();
            }
            case 4: {
                return pSDynaSysBase.getPSDynaSysId();
            }
            case 5: {
                return pSDynaSysBase.getPSDynaSysName();
            }
            case 6: {
                return pSDynaSysBase.getPSSystemId();
            }
            case 7: {
                return pSDynaSysBase.getPSSystemName();
            }
            case 8: {
                return pSDynaSysBase.getUpdateDate();
            }
            case 9: {
                return pSDynaSysBase.getUpdateMan();
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
        PSDynaSysBase.set(this, n, object);
    }

    private static void set(PSDynaSysBase pSDynaSysBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaSysBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaSysBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaSysBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaSysBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaSysBase.setPSDynaSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaSysBase.setPSDynaSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaSysBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaSysBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaSysBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDynaSysBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaSysBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaSysBase pSDynaSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaSysBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaSysBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaSysBase.getLogicName() == null;
            }
            case 3: {
                return pSDynaSysBase.getMemo() == null;
            }
            case 4: {
                return pSDynaSysBase.getPSDynaSysId() == null;
            }
            case 5: {
                return pSDynaSysBase.getPSDynaSysName() == null;
            }
            case 6: {
                return pSDynaSysBase.getPSSystemId() == null;
            }
            case 7: {
                return pSDynaSysBase.getPSSystemName() == null;
            }
            case 8: {
                return pSDynaSysBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDynaSysBase.getUpdateMan() == null;
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
        return PSDynaSysBase.contains(this, n);
    }

    private static boolean contains(PSDynaSysBase pSDynaSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaSysBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaSysBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaSysBase.isLogicNameDirty();
            }
            case 3: {
                return pSDynaSysBase.isMemoDirty();
            }
            case 4: {
                return pSDynaSysBase.isPSDynaSysIdDirty();
            }
            case 5: {
                return pSDynaSysBase.isPSDynaSysNameDirty();
            }
            case 6: {
                return pSDynaSysBase.isPSSystemIdDirty();
            }
            case 7: {
                return pSDynaSysBase.isPSSystemNameDirty();
            }
            case 8: {
                return pSDynaSysBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDynaSysBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaSysBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaSysBase pSDynaSysBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaSysBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getPSDynaSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysid", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getPSDynaSysId()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getPSDynaSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysname", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getPSDynaSysName()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaSysBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaSysBase.getJSONValue((Object)pSDynaSysBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaSysBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaSysBase pSDynaSysBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaSysBase.getCreateDate() != null) {
            object = pSDynaSysBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaSysBase.getCreateMan() != null) {
            object = pSDynaSysBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaSysBase.getLogicName() != null) {
            object = pSDynaSysBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaSysBase.getMemo() != null) {
            object = pSDynaSysBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaSysBase.getPSDynaSysId() != null) {
            object = pSDynaSysBase.getPSDynaSysId();
            xmlNode.setAttribute(FIELD_PSDYNASYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaSysBase.getPSDynaSysName() != null) {
            object = pSDynaSysBase.getPSDynaSysName();
            xmlNode.setAttribute(FIELD_PSDYNASYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaSysBase.getPSSystemId() != null) {
            object = pSDynaSysBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaSysBase.getPSSystemName() != null) {
            object = pSDynaSysBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaSysBase.getUpdateDate() != null) {
            object = pSDynaSysBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaSysBase.getUpdateMan() != null) {
            object = pSDynaSysBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaSysBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaSysBase pSDynaSysBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaSysBase.isCreateDateDirty() && (bl || pSDynaSysBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaSysBase.getCreateDate());
        }
        if (pSDynaSysBase.isCreateManDirty() && (bl || pSDynaSysBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaSysBase.getCreateMan());
        }
        if (pSDynaSysBase.isLogicNameDirty() && (bl || pSDynaSysBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDynaSysBase.getLogicName());
        }
        if (pSDynaSysBase.isMemoDirty() && (bl || pSDynaSysBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaSysBase.getMemo());
        }
        if (pSDynaSysBase.isPSDynaSysIdDirty() && (bl || pSDynaSysBase.getPSDynaSysId() != null)) {
            iDataObject.set(FIELD_PSDYNASYSID, (Object)pSDynaSysBase.getPSDynaSysId());
        }
        if (pSDynaSysBase.isPSDynaSysNameDirty() && (bl || pSDynaSysBase.getPSDynaSysName() != null)) {
            iDataObject.set(FIELD_PSDYNASYSNAME, (Object)pSDynaSysBase.getPSDynaSysName());
        }
        if (pSDynaSysBase.isPSSystemIdDirty() && (bl || pSDynaSysBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDynaSysBase.getPSSystemId());
        }
        if (pSDynaSysBase.isPSSystemNameDirty() && (bl || pSDynaSysBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDynaSysBase.getPSSystemName());
        }
        if (pSDynaSysBase.isUpdateDateDirty() && (bl || pSDynaSysBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaSysBase.getUpdateDate());
        }
        if (pSDynaSysBase.isUpdateManDirty() && (bl || pSDynaSysBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaSysBase.getUpdateMan());
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
        return PSDynaSysBase.remove(this, n);
    }

    private static boolean remove(PSDynaSysBase pSDynaSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaSysBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaSysBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaSysBase.resetLogicName();
                return true;
            }
            case 3: {
                pSDynaSysBase.resetMemo();
                return true;
            }
            case 4: {
                pSDynaSysBase.resetPSDynaSysId();
                return true;
            }
            case 5: {
                pSDynaSysBase.resetPSDynaSysName();
                return true;
            }
            case 6: {
                pSDynaSysBase.resetPSSystemId();
                return true;
            }
            case 7: {
                pSDynaSysBase.resetPSSystemName();
                return true;
            }
            case 8: {
                pSDynaSysBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDynaSysBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public ArrayList<PSDynaApp> getPSDynaApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaApps();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        PSDynaAppService pSDynaAppService = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaAppsLock;
        synchronized (n) {
            if (this.psdynaapps == null) {
                this.psdynaapps = pSDynaAppService.selectByPSDynaSys(this);
            }
            return this.psdynaapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaCodeList> getPSDynaCodeLists() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeLists();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        PSDynaCodeListService pSDynaCodeListService = (PSDynaCodeListService)ServiceGlobal.getService(PSDynaCodeListService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaCodeListsLock;
        synchronized (n) {
            if (this.psdynacodelists == null) {
                this.psdynacodelists = pSDynaCodeListService.selectByPSDynaSys(this);
            }
            return this.psdynacodelists;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaDE> getPSDynaDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEs();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        PSDynaDEService pSDynaDEService = (PSDynaDEService)ServiceGlobal.getService(PSDynaDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaDEsLock;
        synchronized (n) {
            if (this.psdynades == null) {
                this.psdynades = pSDynaDEService.selectByPSDynaSys(this);
            }
            return this.psdynades;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaInst> getPSDynaInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInsts();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaInstsLock;
        synchronized (n) {
            if (this.psdynainsts == null) {
                this.psdynainsts = pSDynaInstService.selectByPSDynaSys(this);
            }
            return this.psdynainsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaWFVer> getPSDynaWFVers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVers();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        PSDynaWFVerService pSDynaWFVerService = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaWFVersLock;
        synchronized (n) {
            if (this.psdynawfvers == null) {
                this.psdynawfvers = pSDynaWFVerService.selectByPSDynaSys(this);
            }
            return this.psdynawfvers;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaWF> getPSDynaWFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFs();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        PSDynaWFService pSDynaWFService = (PSDynaWFService)ServiceGlobal.getService(PSDynaWFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaWFsLock;
        synchronized (n) {
            if (this.psdynawfs == null) {
                this.psdynawfs = pSDynaWFService.selectByPSDynaSys(this);
            }
            return this.psdynawfs;
        }
    }

    private PSDynaSysBase getProxyEntity() {
        return this.proxyPSDynaSysBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaSysBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaSysBase) {
            this.proxyPSDynaSysBase = (PSDynaSysBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDYNASYSID, 4);
        fieldIndexMap.put(FIELD_PSDYNASYSNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

