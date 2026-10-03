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
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPEngineInst;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPEngineInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCEngineInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPDCEngineInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSWPDCENGINEINSTID = "PSWPDCENGINEINSTID";
    public static final String FIELD_PSWPDCENGINEINSTNAME = "PSWPDCENGINEINSTNAME";
    public static final String FIELD_PSWPENGINEINSTID = "PSWPENGINEINSTID";
    public static final String FIELD_PSWPENGINEINSTNAME = "PSWPENGINEINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSWPDCENGINEINSTID = 4;
    private static final int INDEX_PSWPDCENGINEINSTNAME = 5;
    private static final int INDEX_PSWPENGINEINSTID = 6;
    private static final int INDEX_PSWPENGINEINSTNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPDCEngineInstBase proxyPSWPDCEngineInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pswpdcengineinstidDirtyFlag = false;
    private boolean pswpdcengineinstnameDirtyFlag = false;
    private boolean pswpengineinstidDirtyFlag = false;
    private boolean pswpengineinstnameDirtyFlag = false;
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
    @Column(name="pswpdcengineinstid")
    private String pswpdcengineinstid;
    @Column(name="pswpdcengineinstname")
    private String pswpdcengineinstname;
    @Column(name="pswpengineinstid")
    private String pswpengineinstid;
    @Column(name="pswpengineinstname")
    private String pswpengineinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSWPEngineInstLock = new Integer(1);
    private PSWPEngineInst pswpengineinst = null;

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

    public void setPSWPDCEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcengineinstid = string;
        this.pswpdcengineinstidDirtyFlag = true;
    }

    public String getPSWPDCEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCEngineInstId();
        }
        return this.pswpdcengineinstid;
    }

    public boolean isPSWPDCEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCEngineInstIdDirty();
        }
        return this.pswpdcengineinstidDirtyFlag;
    }

    public void resetPSWPDCEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCEngineInstId();
            return;
        }
        this.pswpdcengineinstidDirtyFlag = false;
        this.pswpdcengineinstid = null;
    }

    public void setPSWPDCEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcengineinstname = string;
        this.pswpdcengineinstnameDirtyFlag = true;
    }

    public String getPSWPDCEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCEngineInstName();
        }
        return this.pswpdcengineinstname;
    }

    public boolean isPSWPDCEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCEngineInstNameDirty();
        }
        return this.pswpdcengineinstnameDirtyFlag;
    }

    public void resetPSWPDCEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCEngineInstName();
            return;
        }
        this.pswpdcengineinstnameDirtyFlag = false;
        this.pswpdcengineinstname = null;
    }

    public void setPSWPEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpengineinstid = string;
        this.pswpengineinstidDirtyFlag = true;
    }

    public String getPSWPEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineInstId();
        }
        return this.pswpengineinstid;
    }

    public boolean isPSWPEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPEngineInstIdDirty();
        }
        return this.pswpengineinstidDirtyFlag;
    }

    public void resetPSWPEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPEngineInstId();
            return;
        }
        this.pswpengineinstidDirtyFlag = false;
        this.pswpengineinstid = null;
    }

    public void setPSWPEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpengineinstname = string;
        this.pswpengineinstnameDirtyFlag = true;
    }

    public String getPSWPEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineInstName();
        }
        return this.pswpengineinstname;
    }

    public boolean isPSWPEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPEngineInstNameDirty();
        }
        return this.pswpengineinstnameDirtyFlag;
    }

    public void resetPSWPEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPEngineInstName();
            return;
        }
        this.pswpengineinstnameDirtyFlag = false;
        this.pswpengineinstname = null;
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
        PSWPDCEngineInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPDCEngineInstBase pSWPDCEngineInstBase) {
        pSWPDCEngineInstBase.resetCreateDate();
        pSWPDCEngineInstBase.resetCreateMan();
        pSWPDCEngineInstBase.resetPSDevCenterId();
        pSWPDCEngineInstBase.resetPSDevCenterName();
        pSWPDCEngineInstBase.resetPSWPDCEngineInstId();
        pSWPDCEngineInstBase.resetPSWPDCEngineInstName();
        pSWPDCEngineInstBase.resetPSWPEngineInstId();
        pSWPDCEngineInstBase.resetPSWPEngineInstName();
        pSWPDCEngineInstBase.resetUpdateDate();
        pSWPDCEngineInstBase.resetUpdateMan();
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
        if (!bl || this.isPSWPDCEngineInstIdDirty()) {
            hashMap.put(FIELD_PSWPDCENGINEINSTID, this.getPSWPDCEngineInstId());
        }
        if (!bl || this.isPSWPDCEngineInstNameDirty()) {
            hashMap.put(FIELD_PSWPDCENGINEINSTNAME, this.getPSWPDCEngineInstName());
        }
        if (!bl || this.isPSWPEngineInstIdDirty()) {
            hashMap.put(FIELD_PSWPENGINEINSTID, this.getPSWPEngineInstId());
        }
        if (!bl || this.isPSWPEngineInstNameDirty()) {
            hashMap.put(FIELD_PSWPENGINEINSTNAME, this.getPSWPEngineInstName());
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
        return PSWPDCEngineInstBase.get(this, n);
    }

    private static Object get(PSWPDCEngineInstBase pSWPDCEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCEngineInstBase.getCreateDate();
            }
            case 1: {
                return pSWPDCEngineInstBase.getCreateMan();
            }
            case 2: {
                return pSWPDCEngineInstBase.getPSDevCenterId();
            }
            case 3: {
                return pSWPDCEngineInstBase.getPSDevCenterName();
            }
            case 4: {
                return pSWPDCEngineInstBase.getPSWPDCEngineInstId();
            }
            case 5: {
                return pSWPDCEngineInstBase.getPSWPDCEngineInstName();
            }
            case 6: {
                return pSWPDCEngineInstBase.getPSWPEngineInstId();
            }
            case 7: {
                return pSWPDCEngineInstBase.getPSWPEngineInstName();
            }
            case 8: {
                return pSWPDCEngineInstBase.getUpdateDate();
            }
            case 9: {
                return pSWPDCEngineInstBase.getUpdateMan();
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
        PSWPDCEngineInstBase.set(this, n, object);
    }

    private static void set(PSWPDCEngineInstBase pSWPDCEngineInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCEngineInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPDCEngineInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPDCEngineInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPDCEngineInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPDCEngineInstBase.setPSWPDCEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPDCEngineInstBase.setPSWPDCEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPDCEngineInstBase.setPSWPEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWPDCEngineInstBase.setPSWPEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWPDCEngineInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSWPDCEngineInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWPDCEngineInstBase.isNull(this, n);
    }

    private static boolean isNull(PSWPDCEngineInstBase pSWPDCEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCEngineInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPDCEngineInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPDCEngineInstBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSWPDCEngineInstBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSWPDCEngineInstBase.getPSWPDCEngineInstId() == null;
            }
            case 5: {
                return pSWPDCEngineInstBase.getPSWPDCEngineInstName() == null;
            }
            case 6: {
                return pSWPDCEngineInstBase.getPSWPEngineInstId() == null;
            }
            case 7: {
                return pSWPDCEngineInstBase.getPSWPEngineInstName() == null;
            }
            case 8: {
                return pSWPDCEngineInstBase.getUpdateDate() == null;
            }
            case 9: {
                return pSWPDCEngineInstBase.getUpdateMan() == null;
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
        return PSWPDCEngineInstBase.contains(this, n);
    }

    private static boolean contains(PSWPDCEngineInstBase pSWPDCEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCEngineInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPDCEngineInstBase.isCreateManDirty();
            }
            case 2: {
                return pSWPDCEngineInstBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSWPDCEngineInstBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSWPDCEngineInstBase.isPSWPDCEngineInstIdDirty();
            }
            case 5: {
                return pSWPDCEngineInstBase.isPSWPDCEngineInstNameDirty();
            }
            case 6: {
                return pSWPDCEngineInstBase.isPSWPEngineInstIdDirty();
            }
            case 7: {
                return pSWPDCEngineInstBase.isPSWPEngineInstNameDirty();
            }
            case 8: {
                return pSWPDCEngineInstBase.isUpdateDateDirty();
            }
            case 9: {
                return pSWPDCEngineInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPDCEngineInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPDCEngineInstBase pSWPDCEngineInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPDCEngineInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getPSWPDCEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcengineinstid", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getPSWPDCEngineInstId()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getPSWPDCEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcengineinstname", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getPSWPDCEngineInstName()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getPSWPEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpengineinstid", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getPSWPEngineInstId()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getPSWPEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpengineinstname", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getPSWPEngineInstName()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPDCEngineInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPDCEngineInstBase.getJSONValue((Object)pSWPDCEngineInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPDCEngineInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPDCEngineInstBase pSWPDCEngineInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPDCEngineInstBase.getCreateDate() != null) {
            object = pSWPDCEngineInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCEngineInstBase.getCreateMan() != null) {
            object = pSWPDCEngineInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCEngineInstBase.getPSDevCenterId() != null) {
            object = pSWPDCEngineInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCEngineInstBase.getPSDevCenterName() != null) {
            object = pSWPDCEngineInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCEngineInstBase.getPSWPDCEngineInstId() != null) {
            object = pSWPDCEngineInstBase.getPSWPDCEngineInstId();
            xmlNode.setAttribute(FIELD_PSWPDCENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCEngineInstBase.getPSWPDCEngineInstName() != null) {
            object = pSWPDCEngineInstBase.getPSWPDCEngineInstName();
            xmlNode.setAttribute(FIELD_PSWPDCENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCEngineInstBase.getPSWPEngineInstId() != null) {
            object = pSWPDCEngineInstBase.getPSWPEngineInstId();
            xmlNode.setAttribute(FIELD_PSWPENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCEngineInstBase.getPSWPEngineInstName() != null) {
            object = pSWPDCEngineInstBase.getPSWPEngineInstName();
            xmlNode.setAttribute(FIELD_PSWPENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCEngineInstBase.getUpdateDate() != null) {
            object = pSWPDCEngineInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCEngineInstBase.getUpdateMan() != null) {
            object = pSWPDCEngineInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPDCEngineInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPDCEngineInstBase pSWPDCEngineInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPDCEngineInstBase.isCreateDateDirty() && (bl || pSWPDCEngineInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPDCEngineInstBase.getCreateDate());
        }
        if (pSWPDCEngineInstBase.isCreateManDirty() && (bl || pSWPDCEngineInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPDCEngineInstBase.getCreateMan());
        }
        if (pSWPDCEngineInstBase.isPSDevCenterIdDirty() && (bl || pSWPDCEngineInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSWPDCEngineInstBase.getPSDevCenterId());
        }
        if (pSWPDCEngineInstBase.isPSDevCenterNameDirty() && (bl || pSWPDCEngineInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSWPDCEngineInstBase.getPSDevCenterName());
        }
        if (pSWPDCEngineInstBase.isPSWPDCEngineInstIdDirty() && (bl || pSWPDCEngineInstBase.getPSWPDCEngineInstId() != null)) {
            iDataObject.set(FIELD_PSWPDCENGINEINSTID, (Object)pSWPDCEngineInstBase.getPSWPDCEngineInstId());
        }
        if (pSWPDCEngineInstBase.isPSWPDCEngineInstNameDirty() && (bl || pSWPDCEngineInstBase.getPSWPDCEngineInstName() != null)) {
            iDataObject.set(FIELD_PSWPDCENGINEINSTNAME, (Object)pSWPDCEngineInstBase.getPSWPDCEngineInstName());
        }
        if (pSWPDCEngineInstBase.isPSWPEngineInstIdDirty() && (bl || pSWPDCEngineInstBase.getPSWPEngineInstId() != null)) {
            iDataObject.set(FIELD_PSWPENGINEINSTID, (Object)pSWPDCEngineInstBase.getPSWPEngineInstId());
        }
        if (pSWPDCEngineInstBase.isPSWPEngineInstNameDirty() && (bl || pSWPDCEngineInstBase.getPSWPEngineInstName() != null)) {
            iDataObject.set(FIELD_PSWPENGINEINSTNAME, (Object)pSWPDCEngineInstBase.getPSWPEngineInstName());
        }
        if (pSWPDCEngineInstBase.isUpdateDateDirty() && (bl || pSWPDCEngineInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPDCEngineInstBase.getUpdateDate());
        }
        if (pSWPDCEngineInstBase.isUpdateManDirty() && (bl || pSWPDCEngineInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPDCEngineInstBase.getUpdateMan());
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
        return PSWPDCEngineInstBase.remove(this, n);
    }

    private static boolean remove(PSWPDCEngineInstBase pSWPDCEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCEngineInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPDCEngineInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPDCEngineInstBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSWPDCEngineInstBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSWPDCEngineInstBase.resetPSWPDCEngineInstId();
                return true;
            }
            case 5: {
                pSWPDCEngineInstBase.resetPSWPDCEngineInstName();
                return true;
            }
            case 6: {
                pSWPDCEngineInstBase.resetPSWPEngineInstId();
                return true;
            }
            case 7: {
                pSWPDCEngineInstBase.resetPSWPEngineInstName();
                return true;
            }
            case 8: {
                pSWPDCEngineInstBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSWPDCEngineInstBase.resetUpdateMan();
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
    public PSWPEngineInst getPSWPEngineInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineInst();
        }
        if (this.getPSWPEngineInstId() == null) {
            return null;
        }
        Integer n = this.objPSWPEngineInstLock;
        synchronized (n) {
            if (this.pswpengineinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPEngineInstId(), (Object)this.pswpengineinst.getPSWPEngineInstId()) != 0L) {
                this.pswpengineinst = null;
            }
            if (this.pswpengineinst == null) {
                PSWPEngineInst pSWPEngineInst = new PSWPEngineInst();
                pSWPEngineInst.setPSWPEngineInstId(this.getPSWPEngineInstId());
                PSWPEngineInstService pSWPEngineInstService = (PSWPEngineInstService)ServiceGlobal.getService(PSWPEngineInstService.class, (SessionFactory)this.getSessionFactory());
                pSWPEngineInstService.autoGet(pSWPEngineInst);
                this.pswpengineinst = pSWPEngineInst;
            }
            return this.pswpengineinst;
        }
    }

    private PSWPDCEngineInstBase getProxyEntity() {
        return this.proxyPSWPDCEngineInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPDCEngineInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPDCEngineInstBase) {
            this.proxyPSWPDCEngineInstBase = (PSWPDCEngineInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCEngineInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSWPDCENGINEINSTID, 4);
        fieldIndexMap.put(FIELD_PSWPDCENGINEINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSWPENGINEINSTID, 6);
        fieldIndexMap.put(FIELD_PSWPENGINEINSTNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

