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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCServerStateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCServerStateBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DISKUSAGE = "DISKUSAGE";
    public static final String FIELD_MEMUSAGE = "MEMUSAGE";
    public static final String FIELD_PSDCSERVERSTATEID = "PSDCSERVERSTATEID";
    public static final String FIELD_PSDCSERVERSTATENAME = "PSDCSERVERSTATENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DISKUSAGE = 2;
    private static final int INDEX_MEMUSAGE = 3;
    private static final int INDEX_PSDCSERVERSTATEID = 4;
    private static final int INDEX_PSDCSERVERSTATENAME = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVCENTERNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCServerStateBase proxyPSDCServerStateBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean diskusageDirtyFlag = false;
    private boolean memusageDirtyFlag = false;
    private boolean psdcserverstateidDirtyFlag = false;
    private boolean psdcserverstatenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="diskusage")
    private Double diskusage;
    @Column(name="memusage")
    private Double memusage;
    @Column(name="psdcserverstateid")
    private String psdcserverstateid;
    @Column(name="psdcserverstatename")
    private String psdcserverstatename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setDiskUsage(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDiskUsage(d);
            return;
        }
        this.diskusage = d;
        this.diskusageDirtyFlag = true;
    }

    public Double getDiskUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDiskUsage();
        }
        return this.diskusage;
    }

    public boolean isDiskUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDiskUsageDirty();
        }
        return this.diskusageDirtyFlag;
    }

    public void resetDiskUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDiskUsage();
            return;
        }
        this.diskusageDirtyFlag = false;
        this.diskusage = null;
    }

    public void setMemUsage(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemUsage(d);
            return;
        }
        this.memusage = d;
        this.memusageDirtyFlag = true;
    }

    public Double getMemUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemUsage();
        }
        return this.memusage;
    }

    public boolean isMemUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemUsageDirty();
        }
        return this.memusageDirtyFlag;
    }

    public void resetMemUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemUsage();
            return;
        }
        this.memusageDirtyFlag = false;
        this.memusage = null;
    }

    public void setPSDCServerStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCServerStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcserverstateid = string;
        this.psdcserverstateidDirtyFlag = true;
    }

    public String getPSDCServerStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCServerStateId();
        }
        return this.psdcserverstateid;
    }

    public boolean isPSDCServerStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCServerStateIdDirty();
        }
        return this.psdcserverstateidDirtyFlag;
    }

    public void resetPSDCServerStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCServerStateId();
            return;
        }
        this.psdcserverstateidDirtyFlag = false;
        this.psdcserverstateid = null;
    }

    public void setPSDCServerStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCServerStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcserverstatename = string;
        this.psdcserverstatenameDirtyFlag = true;
    }

    public String getPSDCServerStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCServerStateName();
        }
        return this.psdcserverstatename;
    }

    public boolean isPSDCServerStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCServerStateNameDirty();
        }
        return this.psdcserverstatenameDirtyFlag;
    }

    public void resetPSDCServerStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCServerStateName();
            return;
        }
        this.psdcserverstatenameDirtyFlag = false;
        this.psdcserverstatename = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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
        PSDCServerStateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCServerStateBase pSDCServerStateBase) {
        pSDCServerStateBase.resetCreateDate();
        pSDCServerStateBase.resetCreateMan();
        pSDCServerStateBase.resetDiskUsage();
        pSDCServerStateBase.resetMemUsage();
        pSDCServerStateBase.resetPSDCServerStateId();
        pSDCServerStateBase.resetPSDCServerStateName();
        pSDCServerStateBase.resetPSDevCenterId();
        pSDCServerStateBase.resetPSDevCenterName();
        pSDCServerStateBase.resetUpdateDate();
        pSDCServerStateBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDiskUsageDirty()) {
            hashMap.put(FIELD_DISKUSAGE, this.getDiskUsage());
        }
        if (!bl || this.isMemUsageDirty()) {
            hashMap.put(FIELD_MEMUSAGE, this.getMemUsage());
        }
        if (!bl || this.isPSDCServerStateIdDirty()) {
            hashMap.put(FIELD_PSDCSERVERSTATEID, this.getPSDCServerStateId());
        }
        if (!bl || this.isPSDCServerStateNameDirty()) {
            hashMap.put(FIELD_PSDCSERVERSTATENAME, this.getPSDCServerStateName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
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
        return PSDCServerStateBase.get(this, n);
    }

    private static Object get(PSDCServerStateBase pSDCServerStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCServerStateBase.getCreateDate();
            }
            case 1: {
                return pSDCServerStateBase.getCreateMan();
            }
            case 2: {
                return pSDCServerStateBase.getDiskUsage();
            }
            case 3: {
                return pSDCServerStateBase.getMemUsage();
            }
            case 4: {
                return pSDCServerStateBase.getPSDCServerStateId();
            }
            case 5: {
                return pSDCServerStateBase.getPSDCServerStateName();
            }
            case 6: {
                return pSDCServerStateBase.getPSDevCenterId();
            }
            case 7: {
                return pSDCServerStateBase.getPSDevCenterName();
            }
            case 8: {
                return pSDCServerStateBase.getUpdateDate();
            }
            case 9: {
                return pSDCServerStateBase.getUpdateMan();
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
        PSDCServerStateBase.set(this, n, object);
    }

    private static void set(PSDCServerStateBase pSDCServerStateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCServerStateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCServerStateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCServerStateBase.setDiskUsage(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 3: {
                pSDCServerStateBase.setMemUsage(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSDCServerStateBase.setPSDCServerStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCServerStateBase.setPSDCServerStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCServerStateBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCServerStateBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCServerStateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDCServerStateBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCServerStateBase.isNull(this, n);
    }

    private static boolean isNull(PSDCServerStateBase pSDCServerStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCServerStateBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCServerStateBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCServerStateBase.getDiskUsage() == null;
            }
            case 3: {
                return pSDCServerStateBase.getMemUsage() == null;
            }
            case 4: {
                return pSDCServerStateBase.getPSDCServerStateId() == null;
            }
            case 5: {
                return pSDCServerStateBase.getPSDCServerStateName() == null;
            }
            case 6: {
                return pSDCServerStateBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSDCServerStateBase.getPSDevCenterName() == null;
            }
            case 8: {
                return pSDCServerStateBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDCServerStateBase.getUpdateMan() == null;
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
        return PSDCServerStateBase.contains(this, n);
    }

    private static boolean contains(PSDCServerStateBase pSDCServerStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCServerStateBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCServerStateBase.isCreateManDirty();
            }
            case 2: {
                return pSDCServerStateBase.isDiskUsageDirty();
            }
            case 3: {
                return pSDCServerStateBase.isMemUsageDirty();
            }
            case 4: {
                return pSDCServerStateBase.isPSDCServerStateIdDirty();
            }
            case 5: {
                return pSDCServerStateBase.isPSDCServerStateNameDirty();
            }
            case 6: {
                return pSDCServerStateBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSDCServerStateBase.isPSDevCenterNameDirty();
            }
            case 8: {
                return pSDCServerStateBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDCServerStateBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCServerStateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCServerStateBase pSDCServerStateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCServerStateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getDiskUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"diskusage", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getDiskUsage()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getMemUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memusage", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getMemUsage()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getPSDCServerStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcserverstateid", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getPSDCServerStateId()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getPSDCServerStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcserverstatename", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getPSDCServerStateName()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCServerStateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCServerStateBase.getJSONValue((Object)pSDCServerStateBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCServerStateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCServerStateBase pSDCServerStateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCServerStateBase.getCreateDate() != null) {
            object = pSDCServerStateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCServerStateBase.getCreateMan() != null) {
            object = pSDCServerStateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerStateBase.getDiskUsage() != null) {
            object = pSDCServerStateBase.getDiskUsage();
            xmlNode.setAttribute(FIELD_DISKUSAGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCServerStateBase.getMemUsage() != null) {
            object = pSDCServerStateBase.getMemUsage();
            xmlNode.setAttribute(FIELD_MEMUSAGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCServerStateBase.getPSDCServerStateId() != null) {
            object = pSDCServerStateBase.getPSDCServerStateId();
            xmlNode.setAttribute(FIELD_PSDCSERVERSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerStateBase.getPSDCServerStateName() != null) {
            object = pSDCServerStateBase.getPSDCServerStateName();
            xmlNode.setAttribute(FIELD_PSDCSERVERSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerStateBase.getPSDevCenterId() != null) {
            object = pSDCServerStateBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerStateBase.getPSDevCenterName() != null) {
            object = pSDCServerStateBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerStateBase.getUpdateDate() != null) {
            object = pSDCServerStateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCServerStateBase.getUpdateMan() != null) {
            object = pSDCServerStateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCServerStateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCServerStateBase pSDCServerStateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCServerStateBase.isCreateDateDirty() && (bl || pSDCServerStateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCServerStateBase.getCreateDate());
        }
        if (pSDCServerStateBase.isCreateManDirty() && (bl || pSDCServerStateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCServerStateBase.getCreateMan());
        }
        if (pSDCServerStateBase.isDiskUsageDirty() && (bl || pSDCServerStateBase.getDiskUsage() != null)) {
            iDataObject.set(FIELD_DISKUSAGE, (Object)pSDCServerStateBase.getDiskUsage());
        }
        if (pSDCServerStateBase.isMemUsageDirty() && (bl || pSDCServerStateBase.getMemUsage() != null)) {
            iDataObject.set(FIELD_MEMUSAGE, (Object)pSDCServerStateBase.getMemUsage());
        }
        if (pSDCServerStateBase.isPSDCServerStateIdDirty() && (bl || pSDCServerStateBase.getPSDCServerStateId() != null)) {
            iDataObject.set(FIELD_PSDCSERVERSTATEID, (Object)pSDCServerStateBase.getPSDCServerStateId());
        }
        if (pSDCServerStateBase.isPSDCServerStateNameDirty() && (bl || pSDCServerStateBase.getPSDCServerStateName() != null)) {
            iDataObject.set(FIELD_PSDCSERVERSTATENAME, (Object)pSDCServerStateBase.getPSDCServerStateName());
        }
        if (pSDCServerStateBase.isPSDevCenterIdDirty() && (bl || pSDCServerStateBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCServerStateBase.getPSDevCenterId());
        }
        if (pSDCServerStateBase.isPSDevCenterNameDirty() && (bl || pSDCServerStateBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCServerStateBase.getPSDevCenterName());
        }
        if (pSDCServerStateBase.isUpdateDateDirty() && (bl || pSDCServerStateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCServerStateBase.getUpdateDate());
        }
        if (pSDCServerStateBase.isUpdateManDirty() && (bl || pSDCServerStateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCServerStateBase.getUpdateMan());
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
        return PSDCServerStateBase.remove(this, n);
    }

    private static boolean remove(PSDCServerStateBase pSDCServerStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCServerStateBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCServerStateBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCServerStateBase.resetDiskUsage();
                return true;
            }
            case 3: {
                pSDCServerStateBase.resetMemUsage();
                return true;
            }
            case 4: {
                pSDCServerStateBase.resetPSDCServerStateId();
                return true;
            }
            case 5: {
                pSDCServerStateBase.resetPSDCServerStateName();
                return true;
            }
            case 6: {
                pSDCServerStateBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSDCServerStateBase.resetPSDevCenterName();
                return true;
            }
            case 8: {
                pSDCServerStateBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDCServerStateBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCServerStateBase getProxyEntity() {
        return this.proxyPSDCServerStateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCServerStateBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCServerStateBase) {
            this.proxyPSDCServerStateBase = (PSDCServerStateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSDCServerStateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DISKUSAGE, 2);
        fieldIndexMap.put(FIELD_MEMUSAGE, 3);
        fieldIndexMap.put(FIELD_PSDCSERVERSTATEID, 4);
        fieldIndexMap.put(FIELD_PSDCSERVERSTATENAME, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

