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
package net.ibizsys.pscore.srv.wfplatform.entity;

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
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppInst;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCAppInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPDCAppInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSWPAPPINSTID = "PSWPAPPINSTID";
    public static final String FIELD_PSWPAPPINSTNAME = "PSWPAPPINSTNAME";
    public static final String FIELD_PSWPDCAPPINSTID = "PSWPDCAPPINSTID";
    public static final String FIELD_PSWPDCAPPINSTNAME = "PSWPDCAPPINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSWPAPPINSTID = 4;
    private static final int INDEX_PSWPAPPINSTNAME = 5;
    private static final int INDEX_PSWPDCAPPINSTID = 6;
    private static final int INDEX_PSWPDCAPPINSTNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPDCAppInstBase proxyPSWPDCAppInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pswpappinstidDirtyFlag = false;
    private boolean pswpappinstnameDirtyFlag = false;
    private boolean pswpdcappinstidDirtyFlag = false;
    private boolean pswpdcappinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pswpappinstid")
    private String pswpappinstid;
    @Column(name="pswpappinstname")
    private String pswpappinstname;
    @Column(name="pswpdcappinstid")
    private String pswpdcappinstid;
    @Column(name="pswpdcappinstname")
    private String pswpdcappinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPswpappinstLock = new Integer(1);
    private PSWPAppInst pswpappinst = null;

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

    public void setPSWPAppInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappinstid = string;
        this.pswpappinstidDirtyFlag = true;
    }

    public String getPSWPAppInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppInstId();
        }
        return this.pswpappinstid;
    }

    public boolean isPSWPAppInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppInstIdDirty();
        }
        return this.pswpappinstidDirtyFlag;
    }

    public void resetPSWPAppInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppInstId();
            return;
        }
        this.pswpappinstidDirtyFlag = false;
        this.pswpappinstid = null;
    }

    public void setPSWPAppInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappinstname = string;
        this.pswpappinstnameDirtyFlag = true;
    }

    public String getPSWPAppInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppInstName();
        }
        return this.pswpappinstname;
    }

    public boolean isPSWPAppInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppInstNameDirty();
        }
        return this.pswpappinstnameDirtyFlag;
    }

    public void resetPSWPAppInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppInstName();
            return;
        }
        this.pswpappinstnameDirtyFlag = false;
        this.pswpappinstname = null;
    }

    public void setPSWPDCAppInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCAppInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcappinstid = string;
        this.pswpdcappinstidDirtyFlag = true;
    }

    public String getPSWPDCAppInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppInstId();
        }
        return this.pswpdcappinstid;
    }

    public boolean isPSWPDCAppInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCAppInstIdDirty();
        }
        return this.pswpdcappinstidDirtyFlag;
    }

    public void resetPSWPDCAppInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCAppInstId();
            return;
        }
        this.pswpdcappinstidDirtyFlag = false;
        this.pswpdcappinstid = null;
    }

    public void setPSWPDCAppInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCAppInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcappinstname = string;
        this.pswpdcappinstnameDirtyFlag = true;
    }

    public String getPSWPDCAppInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppInstName();
        }
        return this.pswpdcappinstname;
    }

    public boolean isPSWPDCAppInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCAppInstNameDirty();
        }
        return this.pswpdcappinstnameDirtyFlag;
    }

    public void resetPSWPDCAppInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCAppInstName();
            return;
        }
        this.pswpdcappinstnameDirtyFlag = false;
        this.pswpdcappinstname = null;
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
        PSWPDCAppInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPDCAppInstBase pSWPDCAppInstBase) {
        pSWPDCAppInstBase.resetCreateDate();
        pSWPDCAppInstBase.resetCreateMan();
        pSWPDCAppInstBase.resetPSDevCenterId();
        pSWPDCAppInstBase.resetPSDevCenterName();
        pSWPDCAppInstBase.resetPSWPAppInstId();
        pSWPDCAppInstBase.resetPSWPAppInstName();
        pSWPDCAppInstBase.resetPSWPDCAppInstId();
        pSWPDCAppInstBase.resetPSWPDCAppInstName();
        pSWPDCAppInstBase.resetUpdateDate();
        pSWPDCAppInstBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSWPAppInstIdDirty()) {
            hashMap.put(FIELD_PSWPAPPINSTID, this.getPSWPAppInstId());
        }
        if (!bl || this.isPSWPAppInstNameDirty()) {
            hashMap.put(FIELD_PSWPAPPINSTNAME, this.getPSWPAppInstName());
        }
        if (!bl || this.isPSWPDCAppInstIdDirty()) {
            hashMap.put(FIELD_PSWPDCAPPINSTID, this.getPSWPDCAppInstId());
        }
        if (!bl || this.isPSWPDCAppInstNameDirty()) {
            hashMap.put(FIELD_PSWPDCAPPINSTNAME, this.getPSWPDCAppInstName());
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
        return PSWPDCAppInstBase.get(this, n);
    }

    private static Object get(PSWPDCAppInstBase pSWPDCAppInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCAppInstBase.getCreateDate();
            }
            case 1: {
                return pSWPDCAppInstBase.getCreateMan();
            }
            case 2: {
                return pSWPDCAppInstBase.getPSDevCenterId();
            }
            case 3: {
                return pSWPDCAppInstBase.getPSDevCenterName();
            }
            case 4: {
                return pSWPDCAppInstBase.getPSWPAppInstId();
            }
            case 5: {
                return pSWPDCAppInstBase.getPSWPAppInstName();
            }
            case 6: {
                return pSWPDCAppInstBase.getPSWPDCAppInstId();
            }
            case 7: {
                return pSWPDCAppInstBase.getPSWPDCAppInstName();
            }
            case 8: {
                return pSWPDCAppInstBase.getUpdateDate();
            }
            case 9: {
                return pSWPDCAppInstBase.getUpdateMan();
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
        PSWPDCAppInstBase.set(this, n, object);
    }

    private static void set(PSWPDCAppInstBase pSWPDCAppInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCAppInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPDCAppInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPDCAppInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPDCAppInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPDCAppInstBase.setPSWPAppInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPDCAppInstBase.setPSWPAppInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPDCAppInstBase.setPSWPDCAppInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWPDCAppInstBase.setPSWPDCAppInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWPDCAppInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSWPDCAppInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWPDCAppInstBase.isNull(this, n);
    }

    private static boolean isNull(PSWPDCAppInstBase pSWPDCAppInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCAppInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPDCAppInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPDCAppInstBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSWPDCAppInstBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSWPDCAppInstBase.getPSWPAppInstId() == null;
            }
            case 5: {
                return pSWPDCAppInstBase.getPSWPAppInstName() == null;
            }
            case 6: {
                return pSWPDCAppInstBase.getPSWPDCAppInstId() == null;
            }
            case 7: {
                return pSWPDCAppInstBase.getPSWPDCAppInstName() == null;
            }
            case 8: {
                return pSWPDCAppInstBase.getUpdateDate() == null;
            }
            case 9: {
                return pSWPDCAppInstBase.getUpdateMan() == null;
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
        return PSWPDCAppInstBase.contains(this, n);
    }

    private static boolean contains(PSWPDCAppInstBase pSWPDCAppInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCAppInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPDCAppInstBase.isCreateManDirty();
            }
            case 2: {
                return pSWPDCAppInstBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSWPDCAppInstBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSWPDCAppInstBase.isPSWPAppInstIdDirty();
            }
            case 5: {
                return pSWPDCAppInstBase.isPSWPAppInstNameDirty();
            }
            case 6: {
                return pSWPDCAppInstBase.isPSWPDCAppInstIdDirty();
            }
            case 7: {
                return pSWPDCAppInstBase.isPSWPDCAppInstNameDirty();
            }
            case 8: {
                return pSWPDCAppInstBase.isUpdateDateDirty();
            }
            case 9: {
                return pSWPDCAppInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPDCAppInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPDCAppInstBase pSWPDCAppInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPDCAppInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getPSWPAppInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappinstid", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getPSWPAppInstId()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getPSWPAppInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappinstname", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getPSWPAppInstName()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getPSWPDCAppInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcappinstid", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getPSWPDCAppInstId()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getPSWPDCAppInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcappinstname", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getPSWPDCAppInstName()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPDCAppInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPDCAppInstBase.getJSONValue((Object)pSWPDCAppInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPDCAppInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPDCAppInstBase pSWPDCAppInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPDCAppInstBase.getCreateDate() != null) {
            object = pSWPDCAppInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCAppInstBase.getCreateMan() != null) {
            object = pSWPDCAppInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppInstBase.getPSDevCenterId() != null) {
            object = pSWPDCAppInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppInstBase.getPSDevCenterName() != null) {
            object = pSWPDCAppInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppInstBase.getPSWPAppInstId() != null) {
            object = pSWPDCAppInstBase.getPSWPAppInstId();
            xmlNode.setAttribute(FIELD_PSWPAPPINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppInstBase.getPSWPAppInstName() != null) {
            object = pSWPDCAppInstBase.getPSWPAppInstName();
            xmlNode.setAttribute(FIELD_PSWPAPPINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppInstBase.getPSWPDCAppInstId() != null) {
            object = pSWPDCAppInstBase.getPSWPDCAppInstId();
            xmlNode.setAttribute(FIELD_PSWPDCAPPINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppInstBase.getPSWPDCAppInstName() != null) {
            object = pSWPDCAppInstBase.getPSWPDCAppInstName();
            xmlNode.setAttribute(FIELD_PSWPDCAPPINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppInstBase.getUpdateDate() != null) {
            object = pSWPDCAppInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCAppInstBase.getUpdateMan() != null) {
            object = pSWPDCAppInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPDCAppInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPDCAppInstBase pSWPDCAppInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPDCAppInstBase.isCreateDateDirty() && (bl || pSWPDCAppInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPDCAppInstBase.getCreateDate());
        }
        if (pSWPDCAppInstBase.isCreateManDirty() && (bl || pSWPDCAppInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPDCAppInstBase.getCreateMan());
        }
        if (pSWPDCAppInstBase.isPSDevCenterIdDirty() && (bl || pSWPDCAppInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSWPDCAppInstBase.getPSDevCenterId());
        }
        if (pSWPDCAppInstBase.isPSDevCenterNameDirty() && (bl || pSWPDCAppInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSWPDCAppInstBase.getPSDevCenterName());
        }
        if (pSWPDCAppInstBase.isPSWPAppInstIdDirty() && (bl || pSWPDCAppInstBase.getPSWPAppInstId() != null)) {
            iDataObject.set(FIELD_PSWPAPPINSTID, (Object)pSWPDCAppInstBase.getPSWPAppInstId());
        }
        if (pSWPDCAppInstBase.isPSWPAppInstNameDirty() && (bl || pSWPDCAppInstBase.getPSWPAppInstName() != null)) {
            iDataObject.set(FIELD_PSWPAPPINSTNAME, (Object)pSWPDCAppInstBase.getPSWPAppInstName());
        }
        if (pSWPDCAppInstBase.isPSWPDCAppInstIdDirty() && (bl || pSWPDCAppInstBase.getPSWPDCAppInstId() != null)) {
            iDataObject.set(FIELD_PSWPDCAPPINSTID, (Object)pSWPDCAppInstBase.getPSWPDCAppInstId());
        }
        if (pSWPDCAppInstBase.isPSWPDCAppInstNameDirty() && (bl || pSWPDCAppInstBase.getPSWPDCAppInstName() != null)) {
            iDataObject.set(FIELD_PSWPDCAPPINSTNAME, (Object)pSWPDCAppInstBase.getPSWPDCAppInstName());
        }
        if (pSWPDCAppInstBase.isUpdateDateDirty() && (bl || pSWPDCAppInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPDCAppInstBase.getUpdateDate());
        }
        if (pSWPDCAppInstBase.isUpdateManDirty() && (bl || pSWPDCAppInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPDCAppInstBase.getUpdateMan());
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
        return PSWPDCAppInstBase.remove(this, n);
    }

    private static boolean remove(PSWPDCAppInstBase pSWPDCAppInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCAppInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPDCAppInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPDCAppInstBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSWPDCAppInstBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSWPDCAppInstBase.resetPSWPAppInstId();
                return true;
            }
            case 5: {
                pSWPDCAppInstBase.resetPSWPAppInstName();
                return true;
            }
            case 6: {
                pSWPDCAppInstBase.resetPSWPDCAppInstId();
                return true;
            }
            case 7: {
                pSWPDCAppInstBase.resetPSWPDCAppInstName();
                return true;
            }
            case 8: {
                pSWPDCAppInstBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSWPDCAppInstBase.resetUpdateMan();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWPAppInst getPswpappinst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPswpappinst();
        }
        if (this.getPSWPAppInstId() == null) {
            return null;
        }
        Integer n = this.objPswpappinstLock;
        synchronized (n) {
            if (this.pswpappinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPAppInstId(), (Object)this.pswpappinst.getPSWPAppInstId()) != 0L) {
                this.pswpappinst = null;
            }
            if (this.pswpappinst == null) {
                PSWPAppInst pSWPAppInst = new PSWPAppInst();
                pSWPAppInst.setPSWPAppInstId(this.getPSWPAppInstId());
                PSWPAppInstService pSWPAppInstService = (PSWPAppInstService)ServiceGlobal.getService(PSWPAppInstService.class, (SessionFactory)this.getSessionFactory());
                pSWPAppInstService.autoGet(pSWPAppInst);
                this.pswpappinst = pSWPAppInst;
            }
            return this.pswpappinst;
        }
    }

    private PSWPDCAppInstBase getProxyEntity() {
        return this.proxyPSWPDCAppInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPDCAppInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPDCAppInstBase) {
            this.proxyPSWPDCAppInstBase = (PSWPDCAppInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSWPAPPINSTID, 4);
        fieldIndexMap.put(FIELD_PSWPAPPINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSWPDCAPPINSTID, 6);
        fieldIndexMap.put(FIELD_PSWPDCAPPINSTNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

