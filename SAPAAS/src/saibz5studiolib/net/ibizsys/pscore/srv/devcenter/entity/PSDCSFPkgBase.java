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
import net.ibizsys.pscore.srv.config.entity.PSSFPkg;
import net.ibizsys.pscore.srv.config.service.PSSFPkgService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSFPkgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSFPkgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSFPKGID = "PSDCSFPKGID";
    public static final String FIELD_PSDCSFPKGNAME = "PSDCSFPKGNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSFPKGID = "PSSFPKGID";
    public static final String FIELD_PSSFPKGNAME = "PSSFPKGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCSFPKGID = 3;
    private static final int INDEX_PSDCSFPKGNAME = 4;
    private static final int INDEX_PSDEVCENTERID = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSSFPKGID = 7;
    private static final int INDEX_PSSFPKGNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSFPkgBase proxyPSDCSFPkgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsfpkgidDirtyFlag = false;
    private boolean psdcsfpkgnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssfpkgidDirtyFlag = false;
    private boolean pssfpkgnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcsfpkgid")
    private String psdcsfpkgid;
    @Column(name="psdcsfpkgname")
    private String psdcsfpkgname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssfpkgid")
    private String pssfpkgid;
    @Column(name="pssfpkgname")
    private String pssfpkgname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSFPkgLock = new Integer(1);
    private PSSFPkg pssfpkg = null;

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

    public void setPSDCSFPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSFPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsfpkgid = string;
        this.psdcsfpkgidDirtyFlag = true;
    }

    public String getPSDCSFPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSFPkgId();
        }
        return this.psdcsfpkgid;
    }

    public boolean isPSDCSFPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSFPkgIdDirty();
        }
        return this.psdcsfpkgidDirtyFlag;
    }

    public void resetPSDCSFPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSFPkgId();
            return;
        }
        this.psdcsfpkgidDirtyFlag = false;
        this.psdcsfpkgid = null;
    }

    public void setPSDCSFPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSFPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsfpkgname = string;
        this.psdcsfpkgnameDirtyFlag = true;
    }

    public String getPSDCSFPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSFPkgName();
        }
        return this.psdcsfpkgname;
    }

    public boolean isPSDCSFPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSFPkgNameDirty();
        }
        return this.psdcsfpkgnameDirtyFlag;
    }

    public void resetPSDCSFPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSFPkgName();
            return;
        }
        this.psdcsfpkgnameDirtyFlag = false;
        this.psdcsfpkgname = null;
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

    public void setPSSFPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgid = string;
        this.pssfpkgidDirtyFlag = true;
    }

    public String getPSSFPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgId();
        }
        return this.pssfpkgid;
    }

    public boolean isPSSFPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgIdDirty();
        }
        return this.pssfpkgidDirtyFlag;
    }

    public void resetPSSFPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgId();
            return;
        }
        this.pssfpkgidDirtyFlag = false;
        this.pssfpkgid = null;
    }

    public void setPSSFPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgname = string;
        this.pssfpkgnameDirtyFlag = true;
    }

    public String getPSSFPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgName();
        }
        return this.pssfpkgname;
    }

    public boolean isPSSFPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgNameDirty();
        }
        return this.pssfpkgnameDirtyFlag;
    }

    public void resetPSSFPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgName();
            return;
        }
        this.pssfpkgnameDirtyFlag = false;
        this.pssfpkgname = null;
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
        PSDCSFPkgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSFPkgBase pSDCSFPkgBase) {
        pSDCSFPkgBase.resetCreateDate();
        pSDCSFPkgBase.resetCreateMan();
        pSDCSFPkgBase.resetMemo();
        pSDCSFPkgBase.resetPSDCSFPkgId();
        pSDCSFPkgBase.resetPSDCSFPkgName();
        pSDCSFPkgBase.resetPSDevCenterId();
        pSDCSFPkgBase.resetPSDevCenterName();
        pSDCSFPkgBase.resetPSSFPkgId();
        pSDCSFPkgBase.resetPSSFPkgName();
        pSDCSFPkgBase.resetUpdateDate();
        pSDCSFPkgBase.resetUpdateMan();
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
        if (!bl || this.isPSDCSFPkgIdDirty()) {
            hashMap.put(FIELD_PSDCSFPKGID, this.getPSDCSFPkgId());
        }
        if (!bl || this.isPSDCSFPkgNameDirty()) {
            hashMap.put(FIELD_PSDCSFPKGNAME, this.getPSDCSFPkgName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSFPkgIdDirty()) {
            hashMap.put(FIELD_PSSFPKGID, this.getPSSFPkgId());
        }
        if (!bl || this.isPSSFPkgNameDirty()) {
            hashMap.put(FIELD_PSSFPKGNAME, this.getPSSFPkgName());
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
        return PSDCSFPkgBase.get(this, n);
    }

    private static Object get(PSDCSFPkgBase pSDCSFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSFPkgBase.getCreateDate();
            }
            case 1: {
                return pSDCSFPkgBase.getCreateMan();
            }
            case 2: {
                return pSDCSFPkgBase.getMemo();
            }
            case 3: {
                return pSDCSFPkgBase.getPSDCSFPkgId();
            }
            case 4: {
                return pSDCSFPkgBase.getPSDCSFPkgName();
            }
            case 5: {
                return pSDCSFPkgBase.getPSDevCenterId();
            }
            case 6: {
                return pSDCSFPkgBase.getPSDevCenterName();
            }
            case 7: {
                return pSDCSFPkgBase.getPSSFPkgId();
            }
            case 8: {
                return pSDCSFPkgBase.getPSSFPkgName();
            }
            case 9: {
                return pSDCSFPkgBase.getUpdateDate();
            }
            case 10: {
                return pSDCSFPkgBase.getUpdateMan();
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
        PSDCSFPkgBase.set(this, n, object);
    }

    private static void set(PSDCSFPkgBase pSDCSFPkgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSFPkgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSFPkgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSFPkgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSFPkgBase.setPSDCSFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSFPkgBase.setPSDCSFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSFPkgBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSFPkgBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSFPkgBase.setPSSFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSFPkgBase.setPSSFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSFPkgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDCSFPkgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCSFPkgBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSFPkgBase pSDCSFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSFPkgBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSFPkgBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCSFPkgBase.getMemo() == null;
            }
            case 3: {
                return pSDCSFPkgBase.getPSDCSFPkgId() == null;
            }
            case 4: {
                return pSDCSFPkgBase.getPSDCSFPkgName() == null;
            }
            case 5: {
                return pSDCSFPkgBase.getPSDevCenterId() == null;
            }
            case 6: {
                return pSDCSFPkgBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSDCSFPkgBase.getPSSFPkgId() == null;
            }
            case 8: {
                return pSDCSFPkgBase.getPSSFPkgName() == null;
            }
            case 9: {
                return pSDCSFPkgBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDCSFPkgBase.getUpdateMan() == null;
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
        return PSDCSFPkgBase.contains(this, n);
    }

    private static boolean contains(PSDCSFPkgBase pSDCSFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSFPkgBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSFPkgBase.isCreateManDirty();
            }
            case 2: {
                return pSDCSFPkgBase.isMemoDirty();
            }
            case 3: {
                return pSDCSFPkgBase.isPSDCSFPkgIdDirty();
            }
            case 4: {
                return pSDCSFPkgBase.isPSDCSFPkgNameDirty();
            }
            case 5: {
                return pSDCSFPkgBase.isPSDevCenterIdDirty();
            }
            case 6: {
                return pSDCSFPkgBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSDCSFPkgBase.isPSSFPkgIdDirty();
            }
            case 8: {
                return pSDCSFPkgBase.isPSSFPkgNameDirty();
            }
            case 9: {
                return pSDCSFPkgBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDCSFPkgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSFPkgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSFPkgBase pSDCSFPkgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSFPkgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getPSDCSFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsfpkgid", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getPSDCSFPkgId()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getPSDCSFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsfpkgname", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getPSDCSFPkgName()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getPSSFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgid", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getPSSFPkgId()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getPSSFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgname", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getPSSFPkgName()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSFPkgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSFPkgBase.getJSONValue((Object)pSDCSFPkgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSFPkgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSFPkgBase pSDCSFPkgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSFPkgBase.getCreateDate() != null) {
            object = pSDCSFPkgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSFPkgBase.getCreateMan() != null) {
            object = pSDCSFPkgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgBase.getMemo() != null) {
            object = pSDCSFPkgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgBase.getPSDCSFPkgId() != null) {
            object = pSDCSFPkgBase.getPSDCSFPkgId();
            xmlNode.setAttribute(FIELD_PSDCSFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgBase.getPSDCSFPkgName() != null) {
            object = pSDCSFPkgBase.getPSDCSFPkgName();
            xmlNode.setAttribute(FIELD_PSDCSFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgBase.getPSDevCenterId() != null) {
            object = pSDCSFPkgBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgBase.getPSDevCenterName() != null) {
            object = pSDCSFPkgBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgBase.getPSSFPkgId() != null) {
            object = pSDCSFPkgBase.getPSSFPkgId();
            xmlNode.setAttribute(FIELD_PSSFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgBase.getPSSFPkgName() != null) {
            object = pSDCSFPkgBase.getPSSFPkgName();
            xmlNode.setAttribute(FIELD_PSSFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgBase.getUpdateDate() != null) {
            object = pSDCSFPkgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSFPkgBase.getUpdateMan() != null) {
            object = pSDCSFPkgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSFPkgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSFPkgBase pSDCSFPkgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSFPkgBase.isCreateDateDirty() && (bl || pSDCSFPkgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSFPkgBase.getCreateDate());
        }
        if (pSDCSFPkgBase.isCreateManDirty() && (bl || pSDCSFPkgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSFPkgBase.getCreateMan());
        }
        if (pSDCSFPkgBase.isMemoDirty() && (bl || pSDCSFPkgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSFPkgBase.getMemo());
        }
        if (pSDCSFPkgBase.isPSDCSFPkgIdDirty() && (bl || pSDCSFPkgBase.getPSDCSFPkgId() != null)) {
            iDataObject.set(FIELD_PSDCSFPKGID, (Object)pSDCSFPkgBase.getPSDCSFPkgId());
        }
        if (pSDCSFPkgBase.isPSDCSFPkgNameDirty() && (bl || pSDCSFPkgBase.getPSDCSFPkgName() != null)) {
            iDataObject.set(FIELD_PSDCSFPKGNAME, (Object)pSDCSFPkgBase.getPSDCSFPkgName());
        }
        if (pSDCSFPkgBase.isPSDevCenterIdDirty() && (bl || pSDCSFPkgBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSFPkgBase.getPSDevCenterId());
        }
        if (pSDCSFPkgBase.isPSDevCenterNameDirty() && (bl || pSDCSFPkgBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSFPkgBase.getPSDevCenterName());
        }
        if (pSDCSFPkgBase.isPSSFPkgIdDirty() && (bl || pSDCSFPkgBase.getPSSFPkgId() != null)) {
            iDataObject.set(FIELD_PSSFPKGID, (Object)pSDCSFPkgBase.getPSSFPkgId());
        }
        if (pSDCSFPkgBase.isPSSFPkgNameDirty() && (bl || pSDCSFPkgBase.getPSSFPkgName() != null)) {
            iDataObject.set(FIELD_PSSFPKGNAME, (Object)pSDCSFPkgBase.getPSSFPkgName());
        }
        if (pSDCSFPkgBase.isUpdateDateDirty() && (bl || pSDCSFPkgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSFPkgBase.getUpdateDate());
        }
        if (pSDCSFPkgBase.isUpdateManDirty() && (bl || pSDCSFPkgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSFPkgBase.getUpdateMan());
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
        return PSDCSFPkgBase.remove(this, n);
    }

    private static boolean remove(PSDCSFPkgBase pSDCSFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSFPkgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSFPkgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSFPkgBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCSFPkgBase.resetPSDCSFPkgId();
                return true;
            }
            case 4: {
                pSDCSFPkgBase.resetPSDCSFPkgName();
                return true;
            }
            case 5: {
                pSDCSFPkgBase.resetPSDevCenterId();
                return true;
            }
            case 6: {
                pSDCSFPkgBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSDCSFPkgBase.resetPSSFPkgId();
                return true;
            }
            case 8: {
                pSDCSFPkgBase.resetPSSFPkgName();
                return true;
            }
            case 9: {
                pSDCSFPkgBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDCSFPkgBase.resetUpdateMan();
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
    public PSSFPkg getPSSFPkg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkg();
        }
        if (this.getPSSFPkgId() == null) {
            return null;
        }
        Integer n = this.objPSSFPkgLock;
        synchronized (n) {
            if (this.pssfpkg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPkgId(), (Object)this.pssfpkg.getPSSFPkgId()) != 0L) {
                this.pssfpkg = null;
            }
            if (this.pssfpkg == null) {
                PSSFPkg pSSFPkg = new PSSFPkg();
                pSSFPkg.setPSSFPkgId(this.getPSSFPkgId());
                PSSFPkgService pSSFPkgService = (PSSFPkgService)ServiceGlobal.getService(PSSFPkgService.class, (SessionFactory)this.getSessionFactory());
                pSSFPkgService.autoGet((IEntity)pSSFPkg);
                this.pssfpkg = pSSFPkg;
            }
            return this.pssfpkg;
        }
    }

    private PSDCSFPkgBase getProxyEntity() {
        return this.proxyPSDCSFPkgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSFPkgBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSFPkgBase) {
            this.proxyPSDCSFPkgBase = (PSDCSFPkgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCSFPKGID, 3);
        fieldIndexMap.put(FIELD_PSDCSFPKGNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSSFPKGID, 7);
        fieldIndexMap.put(FIELD_PSSFPKGNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

