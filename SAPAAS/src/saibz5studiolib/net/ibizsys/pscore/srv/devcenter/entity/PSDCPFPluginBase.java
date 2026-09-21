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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCPFPITempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCPFPITemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCPFPluginBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCPFPluginBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PLUGINTAG = "PLUGINTAG";
    public static final String FIELD_PLUGINTYPE = "PLUGINTYPE";
    public static final String FIELD_PSDCPFPLUGINID = "PSDCPFPLUGINID";
    public static final String FIELD_PSDCPFPLUGINNAME = "PSDCPFPLUGINNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PLUGINTAG = 3;
    private static final int INDEX_PLUGINTYPE = 4;
    private static final int INDEX_PSDCPFPLUGINID = 5;
    private static final int INDEX_PSDCPFPLUGINNAME = 6;
    private static final int INDEX_PSDEVCENTERID = 7;
    private static final int INDEX_PSDEVCENTERNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCPFPluginBase proxyPSDCPFPluginBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean plugintagDirtyFlag = false;
    private boolean plugintypeDirtyFlag = false;
    private boolean psdcpfpluginidDirtyFlag = false;
    private boolean psdcpfpluginnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="plugintag")
    private String plugintag;
    @Column(name="plugintype")
    private String plugintype;
    @Column(name="psdcpfpluginid")
    private String psdcpfpluginid;
    @Column(name="psdcpfpluginname")
    private String psdcpfpluginname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDCPFPITemplsLock = new Integer(1);
    private ArrayList<PSDCPFPITempl> psdcpfpitempls = null;

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

    public void setPluginTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugintag = string;
        this.plugintagDirtyFlag = true;
    }

    public String getPluginTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginTag();
        }
        return this.plugintag;
    }

    public boolean isPluginTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginTagDirty();
        }
        return this.plugintagDirtyFlag;
    }

    public void resetPluginTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginTag();
            return;
        }
        this.plugintagDirtyFlag = false;
        this.plugintag = null;
    }

    public void setPluginType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugintype = string;
        this.plugintypeDirtyFlag = true;
    }

    public String getPluginType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginType();
        }
        return this.plugintype;
    }

    public boolean isPluginTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginTypeDirty();
        }
        return this.plugintypeDirtyFlag;
    }

    public void resetPluginType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginType();
            return;
        }
        this.plugintypeDirtyFlag = false;
        this.plugintype = null;
    }

    public void setPSDCPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcpfpluginid = string;
        this.psdcpfpluginidDirtyFlag = true;
    }

    public String getPSDCPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCPFPluginId();
        }
        return this.psdcpfpluginid;
    }

    public boolean isPSDCPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCPFPluginIdDirty();
        }
        return this.psdcpfpluginidDirtyFlag;
    }

    public void resetPSDCPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCPFPluginId();
            return;
        }
        this.psdcpfpluginidDirtyFlag = false;
        this.psdcpfpluginid = null;
    }

    public void setPSDCPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcpfpluginname = string;
        this.psdcpfpluginnameDirtyFlag = true;
    }

    public String getPSDCPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCPFPluginName();
        }
        return this.psdcpfpluginname;
    }

    public boolean isPSDCPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCPFPluginNameDirty();
        }
        return this.psdcpfpluginnameDirtyFlag;
    }

    public void resetPSDCPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCPFPluginName();
            return;
        }
        this.psdcpfpluginnameDirtyFlag = false;
        this.psdcpfpluginname = null;
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

    protected void onReset() {
        PSDCPFPluginBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCPFPluginBase pSDCPFPluginBase) {
        pSDCPFPluginBase.resetCreateDate();
        pSDCPFPluginBase.resetCreateMan();
        pSDCPFPluginBase.resetMemo();
        pSDCPFPluginBase.resetPluginTag();
        pSDCPFPluginBase.resetPluginType();
        pSDCPFPluginBase.resetPSDCPFPluginId();
        pSDCPFPluginBase.resetPSDCPFPluginName();
        pSDCPFPluginBase.resetPSDevCenterId();
        pSDCPFPluginBase.resetPSDevCenterName();
        pSDCPFPluginBase.resetUpdateDate();
        pSDCPFPluginBase.resetUpdateMan();
        pSDCPFPluginBase.resetValidFlag();
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
        if (!bl || this.isPluginTagDirty()) {
            hashMap.put(FIELD_PLUGINTAG, this.getPluginTag());
        }
        if (!bl || this.isPluginTypeDirty()) {
            hashMap.put(FIELD_PLUGINTYPE, this.getPluginType());
        }
        if (!bl || this.isPSDCPFPluginIdDirty()) {
            hashMap.put(FIELD_PSDCPFPLUGINID, this.getPSDCPFPluginId());
        }
        if (!bl || this.isPSDCPFPluginNameDirty()) {
            hashMap.put(FIELD_PSDCPFPLUGINNAME, this.getPSDCPFPluginName());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDCPFPluginBase.get(this, n);
    }

    private static Object get(PSDCPFPluginBase pSDCPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCPFPluginBase.getCreateDate();
            }
            case 1: {
                return pSDCPFPluginBase.getCreateMan();
            }
            case 2: {
                return pSDCPFPluginBase.getMemo();
            }
            case 3: {
                return pSDCPFPluginBase.getPluginTag();
            }
            case 4: {
                return pSDCPFPluginBase.getPluginType();
            }
            case 5: {
                return pSDCPFPluginBase.getPSDCPFPluginId();
            }
            case 6: {
                return pSDCPFPluginBase.getPSDCPFPluginName();
            }
            case 7: {
                return pSDCPFPluginBase.getPSDevCenterId();
            }
            case 8: {
                return pSDCPFPluginBase.getPSDevCenterName();
            }
            case 9: {
                return pSDCPFPluginBase.getUpdateDate();
            }
            case 10: {
                return pSDCPFPluginBase.getUpdateMan();
            }
            case 11: {
                return pSDCPFPluginBase.getValidFlag();
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
        PSDCPFPluginBase.set(this, n, object);
    }

    private static void set(PSDCPFPluginBase pSDCPFPluginBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCPFPluginBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCPFPluginBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCPFPluginBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCPFPluginBase.setPluginTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCPFPluginBase.setPluginType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCPFPluginBase.setPSDCPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCPFPluginBase.setPSDCPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCPFPluginBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCPFPluginBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCPFPluginBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDCPFPluginBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCPFPluginBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCPFPluginBase.isNull(this, n);
    }

    private static boolean isNull(PSDCPFPluginBase pSDCPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCPFPluginBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCPFPluginBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCPFPluginBase.getMemo() == null;
            }
            case 3: {
                return pSDCPFPluginBase.getPluginTag() == null;
            }
            case 4: {
                return pSDCPFPluginBase.getPluginType() == null;
            }
            case 5: {
                return pSDCPFPluginBase.getPSDCPFPluginId() == null;
            }
            case 6: {
                return pSDCPFPluginBase.getPSDCPFPluginName() == null;
            }
            case 7: {
                return pSDCPFPluginBase.getPSDevCenterId() == null;
            }
            case 8: {
                return pSDCPFPluginBase.getPSDevCenterName() == null;
            }
            case 9: {
                return pSDCPFPluginBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDCPFPluginBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDCPFPluginBase.getValidFlag() == null;
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
        return PSDCPFPluginBase.contains(this, n);
    }

    private static boolean contains(PSDCPFPluginBase pSDCPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCPFPluginBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCPFPluginBase.isCreateManDirty();
            }
            case 2: {
                return pSDCPFPluginBase.isMemoDirty();
            }
            case 3: {
                return pSDCPFPluginBase.isPluginTagDirty();
            }
            case 4: {
                return pSDCPFPluginBase.isPluginTypeDirty();
            }
            case 5: {
                return pSDCPFPluginBase.isPSDCPFPluginIdDirty();
            }
            case 6: {
                return pSDCPFPluginBase.isPSDCPFPluginNameDirty();
            }
            case 7: {
                return pSDCPFPluginBase.isPSDevCenterIdDirty();
            }
            case 8: {
                return pSDCPFPluginBase.isPSDevCenterNameDirty();
            }
            case 9: {
                return pSDCPFPluginBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDCPFPluginBase.isUpdateManDirty();
            }
            case 11: {
                return pSDCPFPluginBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCPFPluginBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCPFPluginBase pSDCPFPluginBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCPFPluginBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getPluginTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintag", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getPluginTag()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getPluginType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintype", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getPluginType()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getPSDCPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcpfpluginid", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getPSDCPFPluginId()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getPSDCPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcpfpluginname", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getPSDCPFPluginName()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCPFPluginBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCPFPluginBase.getJSONValue((Object)pSDCPFPluginBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCPFPluginBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCPFPluginBase pSDCPFPluginBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCPFPluginBase.getCreateDate() != null) {
            object = pSDCPFPluginBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCPFPluginBase.getCreateMan() != null) {
            object = pSDCPFPluginBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getMemo() != null) {
            object = pSDCPFPluginBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getPluginTag() != null) {
            object = pSDCPFPluginBase.getPluginTag();
            xmlNode.setAttribute(FIELD_PLUGINTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getPluginType() != null) {
            object = pSDCPFPluginBase.getPluginType();
            xmlNode.setAttribute(FIELD_PLUGINTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getPSDCPFPluginId() != null) {
            object = pSDCPFPluginBase.getPSDCPFPluginId();
            xmlNode.setAttribute(FIELD_PSDCPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getPSDCPFPluginName() != null) {
            object = pSDCPFPluginBase.getPSDCPFPluginName();
            xmlNode.setAttribute(FIELD_PSDCPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getPSDevCenterId() != null) {
            object = pSDCPFPluginBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getPSDevCenterName() != null) {
            object = pSDCPFPluginBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getUpdateDate() != null) {
            object = pSDCPFPluginBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCPFPluginBase.getUpdateMan() != null) {
            object = pSDCPFPluginBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPluginBase.getValidFlag() != null) {
            object = pSDCPFPluginBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCPFPluginBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCPFPluginBase pSDCPFPluginBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCPFPluginBase.isCreateDateDirty() && (bl || pSDCPFPluginBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCPFPluginBase.getCreateDate());
        }
        if (pSDCPFPluginBase.isCreateManDirty() && (bl || pSDCPFPluginBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCPFPluginBase.getCreateMan());
        }
        if (pSDCPFPluginBase.isMemoDirty() && (bl || pSDCPFPluginBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCPFPluginBase.getMemo());
        }
        if (pSDCPFPluginBase.isPluginTagDirty() && (bl || pSDCPFPluginBase.getPluginTag() != null)) {
            iDataObject.set(FIELD_PLUGINTAG, (Object)pSDCPFPluginBase.getPluginTag());
        }
        if (pSDCPFPluginBase.isPluginTypeDirty() && (bl || pSDCPFPluginBase.getPluginType() != null)) {
            iDataObject.set(FIELD_PLUGINTYPE, (Object)pSDCPFPluginBase.getPluginType());
        }
        if (pSDCPFPluginBase.isPSDCPFPluginIdDirty() && (bl || pSDCPFPluginBase.getPSDCPFPluginId() != null)) {
            iDataObject.set(FIELD_PSDCPFPLUGINID, (Object)pSDCPFPluginBase.getPSDCPFPluginId());
        }
        if (pSDCPFPluginBase.isPSDCPFPluginNameDirty() && (bl || pSDCPFPluginBase.getPSDCPFPluginName() != null)) {
            iDataObject.set(FIELD_PSDCPFPLUGINNAME, (Object)pSDCPFPluginBase.getPSDCPFPluginName());
        }
        if (pSDCPFPluginBase.isPSDevCenterIdDirty() && (bl || pSDCPFPluginBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCPFPluginBase.getPSDevCenterId());
        }
        if (pSDCPFPluginBase.isPSDevCenterNameDirty() && (bl || pSDCPFPluginBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCPFPluginBase.getPSDevCenterName());
        }
        if (pSDCPFPluginBase.isUpdateDateDirty() && (bl || pSDCPFPluginBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCPFPluginBase.getUpdateDate());
        }
        if (pSDCPFPluginBase.isUpdateManDirty() && (bl || pSDCPFPluginBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCPFPluginBase.getUpdateMan());
        }
        if (pSDCPFPluginBase.isValidFlagDirty() && (bl || pSDCPFPluginBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCPFPluginBase.getValidFlag());
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
        return PSDCPFPluginBase.remove(this, n);
    }

    private static boolean remove(PSDCPFPluginBase pSDCPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCPFPluginBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCPFPluginBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCPFPluginBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCPFPluginBase.resetPluginTag();
                return true;
            }
            case 4: {
                pSDCPFPluginBase.resetPluginType();
                return true;
            }
            case 5: {
                pSDCPFPluginBase.resetPSDCPFPluginId();
                return true;
            }
            case 6: {
                pSDCPFPluginBase.resetPSDCPFPluginName();
                return true;
            }
            case 7: {
                pSDCPFPluginBase.resetPSDevCenterId();
                return true;
            }
            case 8: {
                pSDCPFPluginBase.resetPSDevCenterName();
                return true;
            }
            case 9: {
                pSDCPFPluginBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDCPFPluginBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDCPFPluginBase.resetValidFlag();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCPFPITempl> getPSDCPFPITempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCPFPITempls();
        }
        if (this.getPSDCPFPluginId() == null) {
            return null;
        }
        PSDCPFPITemplService pSDCPFPITemplService = (PSDCPFPITemplService)ServiceGlobal.getService(PSDCPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCPFPITemplsLock;
        synchronized (n) {
            if (this.psdcpfpitempls == null) {
                this.psdcpfpitempls = pSDCPFPITemplService.selectByPSDCPFPlugin(this);
            }
            return this.psdcpfpitempls;
        }
    }

    private PSDCPFPluginBase getProxyEntity() {
        return this.proxyPSDCPFPluginBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCPFPluginBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCPFPluginBase) {
            this.proxyPSDCPFPluginBase = (PSDCPFPluginBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCPFPluginService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PLUGINTAG, 3);
        fieldIndexMap.put(FIELD_PLUGINTYPE, 4);
        fieldIndexMap.put(FIELD_PSDCPFPLUGINID, 5);
        fieldIndexMap.put(FIELD_PSDCPFPLUGINNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

