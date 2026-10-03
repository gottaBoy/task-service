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
import net.ibizsys.pscore.srv.appdesign.entity.PSDCMobPackCert;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertService;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDevice;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMobAppPackTDBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMobAppPackTDBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCMOBAPPTESTDEVICEID = "PSDCMOBAPPTESTDEVICEID";
    public static final String FIELD_PSDCMOBAPPTESTDEVICENAME = "PSDCMOBAPPTESTDEVICENAME";
    public static final String FIELD_PSDCMOBPACKCERTID = "PSDCMOBPACKCERTID";
    public static final String FIELD_PSDCMOBPACKCERTNAME = "PSDCMOBPACKCERTNAME";
    public static final String FIELD_PSMOBAPPPACKID = "PSMOBAPPPACKID";
    public static final String FIELD_PSMOBAPPPACKNAME = "PSMOBAPPPACKNAME";
    public static final String FIELD_PSMOBAPPPACKTDID = "PSMOBAPPPACKTDID";
    public static final String FIELD_PSMOBAPPPACKTDNAME = "PSMOBAPPPACKTDNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDCMOBAPPTESTDEVICEID = 4;
    private static final int INDEX_PSDCMOBAPPTESTDEVICENAME = 5;
    private static final int INDEX_PSDCMOBPACKCERTID = 6;
    private static final int INDEX_PSDCMOBPACKCERTNAME = 7;
    private static final int INDEX_PSMOBAPPPACKID = 8;
    private static final int INDEX_PSMOBAPPPACKNAME = 9;
    private static final int INDEX_PSMOBAPPPACKTDID = 10;
    private static final int INDEX_PSMOBAPPPACKTDNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMobAppPackTDBase proxyPSMobAppPackTDBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcmobapptestdeviceidDirtyFlag = false;
    private boolean psdcmobapptestdevicenameDirtyFlag = false;
    private boolean psdcmobpackcertidDirtyFlag = false;
    private boolean psdcmobpackcertnameDirtyFlag = false;
    private boolean psmobapppackidDirtyFlag = false;
    private boolean psmobapppacknameDirtyFlag = false;
    private boolean psmobapppacktdidDirtyFlag = false;
    private boolean psmobapppacktdnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcmobapptestdeviceid")
    private String psdcmobapptestdeviceid;
    @Column(name="psdcmobapptestdevicename")
    private String psdcmobapptestdevicename;
    @Column(name="psdcmobpackcertid")
    private String psdcmobpackcertid;
    @Column(name="psdcmobpackcertname")
    private String psdcmobpackcertname;
    @Column(name="psmobapppackid")
    private String psmobapppackid;
    @Column(name="psmobapppackname")
    private String psmobapppackname;
    @Column(name="psmobapppacktdid")
    private String psmobapppacktdid;
    @Column(name="psmobapppacktdname")
    private String psmobapppacktdname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCMobAppTestDeviceLock = new Integer(1);
    private PSDCMobAppTestDevice psdcmobapptestdevice = null;
    private Integer objPSDCMobPackCertLock = new Integer(1);
    private PSDCMobPackCert psdcmobpackcert = null;
    private Integer objPSMobAppPackLock = new Integer(1);
    private PSMobAppPack psmobapppack = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

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

    public void setPSDCMobAppTestDeviceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobAppTestDeviceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobapptestdeviceid = string;
        this.psdcmobapptestdeviceidDirtyFlag = true;
    }

    public String getPSDCMobAppTestDeviceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTestDeviceId();
        }
        return this.psdcmobapptestdeviceid;
    }

    public boolean isPSDCMobAppTestDeviceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobAppTestDeviceIdDirty();
        }
        return this.psdcmobapptestdeviceidDirtyFlag;
    }

    public void resetPSDCMobAppTestDeviceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobAppTestDeviceId();
            return;
        }
        this.psdcmobapptestdeviceidDirtyFlag = false;
        this.psdcmobapptestdeviceid = null;
    }

    public void setPSDCMobAppTestDeviceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobAppTestDeviceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobapptestdevicename = string;
        this.psdcmobapptestdevicenameDirtyFlag = true;
    }

    public String getPSDCMobAppTestDeviceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTestDeviceName();
        }
        return this.psdcmobapptestdevicename;
    }

    public boolean isPSDCMobAppTestDeviceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobAppTestDeviceNameDirty();
        }
        return this.psdcmobapptestdevicenameDirtyFlag;
    }

    public void resetPSDCMobAppTestDeviceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobAppTestDeviceName();
            return;
        }
        this.psdcmobapptestdevicenameDirtyFlag = false;
        this.psdcmobapptestdevicename = null;
    }

    public void setPSDCMobPackCertId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobPackCertId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobpackcertid = string;
        this.psdcmobpackcertidDirtyFlag = true;
    }

    public String getPSDCMobPackCertId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobPackCertId();
        }
        return this.psdcmobpackcertid;
    }

    public boolean isPSDCMobPackCertIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobPackCertIdDirty();
        }
        return this.psdcmobpackcertidDirtyFlag;
    }

    public void resetPSDCMobPackCertId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobPackCertId();
            return;
        }
        this.psdcmobpackcertidDirtyFlag = false;
        this.psdcmobpackcertid = null;
    }

    public void setPSDCMobPackCertName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobPackCertName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobpackcertname = string;
        this.psdcmobpackcertnameDirtyFlag = true;
    }

    public String getPSDCMobPackCertName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobPackCertName();
        }
        return this.psdcmobpackcertname;
    }

    public boolean isPSDCMobPackCertNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobPackCertNameDirty();
        }
        return this.psdcmobpackcertnameDirtyFlag;
    }

    public void resetPSDCMobPackCertName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobPackCertName();
            return;
        }
        this.psdcmobpackcertnameDirtyFlag = false;
        this.psdcmobpackcertname = null;
    }

    public void setPSMobAppPackId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackid = string;
        this.psmobapppackidDirtyFlag = true;
    }

    public String getPSMobAppPackId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackId();
        }
        return this.psmobapppackid;
    }

    public boolean isPSMobAppPackIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackIdDirty();
        }
        return this.psmobapppackidDirtyFlag;
    }

    public void resetPSMobAppPackId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackId();
            return;
        }
        this.psmobapppackidDirtyFlag = false;
        this.psmobapppackid = null;
    }

    public void setPSMobAppPackName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackname = string;
        this.psmobapppacknameDirtyFlag = true;
    }

    public String getPSMobAppPackName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackName();
        }
        return this.psmobapppackname;
    }

    public boolean isPSMobAppPackNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackNameDirty();
        }
        return this.psmobapppacknameDirtyFlag;
    }

    public void resetPSMobAppPackName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackName();
            return;
        }
        this.psmobapppacknameDirtyFlag = false;
        this.psmobapppackname = null;
    }

    public void setPSMobAppPackTDId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackTDId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppacktdid = string;
        this.psmobapppacktdidDirtyFlag = true;
    }

    public String getPSMobAppPackTDId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackTDId();
        }
        return this.psmobapppacktdid;
    }

    public boolean isPSMobAppPackTDIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackTDIdDirty();
        }
        return this.psmobapppacktdidDirtyFlag;
    }

    public void resetPSMobAppPackTDId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackTDId();
            return;
        }
        this.psmobapppacktdidDirtyFlag = false;
        this.psmobapppacktdid = null;
    }

    public void setPSMobAppPackTDName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackTDName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppacktdname = string;
        this.psmobapppacktdnameDirtyFlag = true;
    }

    public String getPSMobAppPackTDName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackTDName();
        }
        return this.psmobapppacktdname;
    }

    public boolean isPSMobAppPackTDNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackTDNameDirty();
        }
        return this.psmobapppacktdnameDirtyFlag;
    }

    public void resetPSMobAppPackTDName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackTDName();
            return;
        }
        this.psmobapppacktdnameDirtyFlag = false;
        this.psmobapppacktdname = null;
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
        PSMobAppPackTDBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMobAppPackTDBase pSMobAppPackTDBase) {
        pSMobAppPackTDBase.resetCodeName();
        pSMobAppPackTDBase.resetCreateDate();
        pSMobAppPackTDBase.resetCreateMan();
        pSMobAppPackTDBase.resetMemo();
        pSMobAppPackTDBase.resetPSDCMobAppTestDeviceId();
        pSMobAppPackTDBase.resetPSDCMobAppTestDeviceName();
        pSMobAppPackTDBase.resetPSDCMobPackCertId();
        pSMobAppPackTDBase.resetPSDCMobPackCertName();
        pSMobAppPackTDBase.resetPSMobAppPackId();
        pSMobAppPackTDBase.resetPSMobAppPackName();
        pSMobAppPackTDBase.resetPSMobAppPackTDId();
        pSMobAppPackTDBase.resetPSMobAppPackTDName();
        pSMobAppPackTDBase.resetUpdateDate();
        pSMobAppPackTDBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCMobAppTestDeviceIdDirty()) {
            hashMap.put(FIELD_PSDCMOBAPPTESTDEVICEID, this.getPSDCMobAppTestDeviceId());
        }
        if (!bl || this.isPSDCMobAppTestDeviceNameDirty()) {
            hashMap.put(FIELD_PSDCMOBAPPTESTDEVICENAME, this.getPSDCMobAppTestDeviceName());
        }
        if (!bl || this.isPSDCMobPackCertIdDirty()) {
            hashMap.put(FIELD_PSDCMOBPACKCERTID, this.getPSDCMobPackCertId());
        }
        if (!bl || this.isPSDCMobPackCertNameDirty()) {
            hashMap.put(FIELD_PSDCMOBPACKCERTNAME, this.getPSDCMobPackCertName());
        }
        if (!bl || this.isPSMobAppPackIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKID, this.getPSMobAppPackId());
        }
        if (!bl || this.isPSMobAppPackNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKNAME, this.getPSMobAppPackName());
        }
        if (!bl || this.isPSMobAppPackTDIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKTDID, this.getPSMobAppPackTDId());
        }
        if (!bl || this.isPSMobAppPackTDNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKTDNAME, this.getPSMobAppPackTDName());
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
        return PSMobAppPackTDBase.get(this, n);
    }

    private static Object get(PSMobAppPackTDBase pSMobAppPackTDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackTDBase.getCodeName();
            }
            case 1: {
                return pSMobAppPackTDBase.getCreateDate();
            }
            case 2: {
                return pSMobAppPackTDBase.getCreateMan();
            }
            case 3: {
                return pSMobAppPackTDBase.getMemo();
            }
            case 4: {
                return pSMobAppPackTDBase.getPSDCMobAppTestDeviceId();
            }
            case 5: {
                return pSMobAppPackTDBase.getPSDCMobAppTestDeviceName();
            }
            case 6: {
                return pSMobAppPackTDBase.getPSDCMobPackCertId();
            }
            case 7: {
                return pSMobAppPackTDBase.getPSDCMobPackCertName();
            }
            case 8: {
                return pSMobAppPackTDBase.getPSMobAppPackId();
            }
            case 9: {
                return pSMobAppPackTDBase.getPSMobAppPackName();
            }
            case 10: {
                return pSMobAppPackTDBase.getPSMobAppPackTDId();
            }
            case 11: {
                return pSMobAppPackTDBase.getPSMobAppPackTDName();
            }
            case 12: {
                return pSMobAppPackTDBase.getUpdateDate();
            }
            case 13: {
                return pSMobAppPackTDBase.getUpdateMan();
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
        PSMobAppPackTDBase.set(this, n, object);
    }

    private static void set(PSMobAppPackTDBase pSMobAppPackTDBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppPackTDBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSMobAppPackTDBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSMobAppPackTDBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMobAppPackTDBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMobAppPackTDBase.setPSDCMobAppTestDeviceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMobAppPackTDBase.setPSDCMobAppTestDeviceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMobAppPackTDBase.setPSDCMobPackCertId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMobAppPackTDBase.setPSDCMobPackCertName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMobAppPackTDBase.setPSMobAppPackId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMobAppPackTDBase.setPSMobAppPackName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMobAppPackTDBase.setPSMobAppPackTDId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSMobAppPackTDBase.setPSMobAppPackTDName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMobAppPackTDBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSMobAppPackTDBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSMobAppPackTDBase.isNull(this, n);
    }

    private static boolean isNull(PSMobAppPackTDBase pSMobAppPackTDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackTDBase.getCodeName() == null;
            }
            case 1: {
                return pSMobAppPackTDBase.getCreateDate() == null;
            }
            case 2: {
                return pSMobAppPackTDBase.getCreateMan() == null;
            }
            case 3: {
                return pSMobAppPackTDBase.getMemo() == null;
            }
            case 4: {
                return pSMobAppPackTDBase.getPSDCMobAppTestDeviceId() == null;
            }
            case 5: {
                return pSMobAppPackTDBase.getPSDCMobAppTestDeviceName() == null;
            }
            case 6: {
                return pSMobAppPackTDBase.getPSDCMobPackCertId() == null;
            }
            case 7: {
                return pSMobAppPackTDBase.getPSDCMobPackCertName() == null;
            }
            case 8: {
                return pSMobAppPackTDBase.getPSMobAppPackId() == null;
            }
            case 9: {
                return pSMobAppPackTDBase.getPSMobAppPackName() == null;
            }
            case 10: {
                return pSMobAppPackTDBase.getPSMobAppPackTDId() == null;
            }
            case 11: {
                return pSMobAppPackTDBase.getPSMobAppPackTDName() == null;
            }
            case 12: {
                return pSMobAppPackTDBase.getUpdateDate() == null;
            }
            case 13: {
                return pSMobAppPackTDBase.getUpdateMan() == null;
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
        return PSMobAppPackTDBase.contains(this, n);
    }

    private static boolean contains(PSMobAppPackTDBase pSMobAppPackTDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackTDBase.isCodeNameDirty();
            }
            case 1: {
                return pSMobAppPackTDBase.isCreateDateDirty();
            }
            case 2: {
                return pSMobAppPackTDBase.isCreateManDirty();
            }
            case 3: {
                return pSMobAppPackTDBase.isMemoDirty();
            }
            case 4: {
                return pSMobAppPackTDBase.isPSDCMobAppTestDeviceIdDirty();
            }
            case 5: {
                return pSMobAppPackTDBase.isPSDCMobAppTestDeviceNameDirty();
            }
            case 6: {
                return pSMobAppPackTDBase.isPSDCMobPackCertIdDirty();
            }
            case 7: {
                return pSMobAppPackTDBase.isPSDCMobPackCertNameDirty();
            }
            case 8: {
                return pSMobAppPackTDBase.isPSMobAppPackIdDirty();
            }
            case 9: {
                return pSMobAppPackTDBase.isPSMobAppPackNameDirty();
            }
            case 10: {
                return pSMobAppPackTDBase.isPSMobAppPackTDIdDirty();
            }
            case 11: {
                return pSMobAppPackTDBase.isPSMobAppPackTDNameDirty();
            }
            case 12: {
                return pSMobAppPackTDBase.isUpdateDateDirty();
            }
            case 13: {
                return pSMobAppPackTDBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMobAppPackTDBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMobAppPackTDBase pSMobAppPackTDBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMobAppPackTDBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getCodeName()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getMemo()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getPSDCMobAppTestDeviceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobapptestdeviceid", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getPSDCMobAppTestDeviceId()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getPSDCMobAppTestDeviceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobapptestdevicename", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getPSDCMobAppTestDeviceName()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getPSDCMobPackCertId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobpackcertid", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getPSDCMobPackCertId()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getPSDCMobPackCertName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobpackcertname", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getPSDCMobPackCertName()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getPSMobAppPackId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackid", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getPSMobAppPackId()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getPSMobAppPackName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackname", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getPSMobAppPackName()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getPSMobAppPackTDId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppacktdid", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getPSMobAppPackTDId()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getPSMobAppPackTDName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppacktdname", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getPSMobAppPackTDName()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMobAppPackTDBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMobAppPackTDBase.getJSONValue((Object)pSMobAppPackTDBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMobAppPackTDBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMobAppPackTDBase pSMobAppPackTDBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMobAppPackTDBase.getCodeName() != null) {
            object = pSMobAppPackTDBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getCreateDate() != null) {
            object = pSMobAppPackTDBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppPackTDBase.getCreateMan() != null) {
            object = pSMobAppPackTDBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getMemo() != null) {
            object = pSMobAppPackTDBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getPSDCMobAppTestDeviceId() != null) {
            object = pSMobAppPackTDBase.getPSDCMobAppTestDeviceId();
            xmlNode.setAttribute(FIELD_PSDCMOBAPPTESTDEVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getPSDCMobAppTestDeviceName() != null) {
            object = pSMobAppPackTDBase.getPSDCMobAppTestDeviceName();
            xmlNode.setAttribute(FIELD_PSDCMOBAPPTESTDEVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getPSDCMobPackCertId() != null) {
            object = pSMobAppPackTDBase.getPSDCMobPackCertId();
            xmlNode.setAttribute(FIELD_PSDCMOBPACKCERTID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getPSDCMobPackCertName() != null) {
            object = pSMobAppPackTDBase.getPSDCMobPackCertName();
            xmlNode.setAttribute(FIELD_PSDCMOBPACKCERTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getPSMobAppPackId() != null) {
            object = pSMobAppPackTDBase.getPSMobAppPackId();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getPSMobAppPackName() != null) {
            object = pSMobAppPackTDBase.getPSMobAppPackName();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getPSMobAppPackTDId() != null) {
            object = pSMobAppPackTDBase.getPSMobAppPackTDId();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKTDID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getPSMobAppPackTDName() != null) {
            object = pSMobAppPackTDBase.getPSMobAppPackTDName();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKTDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackTDBase.getUpdateDate() != null) {
            object = pSMobAppPackTDBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppPackTDBase.getUpdateMan() != null) {
            object = pSMobAppPackTDBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMobAppPackTDBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMobAppPackTDBase pSMobAppPackTDBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMobAppPackTDBase.isCodeNameDirty() && (bl || pSMobAppPackTDBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSMobAppPackTDBase.getCodeName());
        }
        if (pSMobAppPackTDBase.isCreateDateDirty() && (bl || pSMobAppPackTDBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMobAppPackTDBase.getCreateDate());
        }
        if (pSMobAppPackTDBase.isCreateManDirty() && (bl || pSMobAppPackTDBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMobAppPackTDBase.getCreateMan());
        }
        if (pSMobAppPackTDBase.isMemoDirty() && (bl || pSMobAppPackTDBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMobAppPackTDBase.getMemo());
        }
        if (pSMobAppPackTDBase.isPSDCMobAppTestDeviceIdDirty() && (bl || pSMobAppPackTDBase.getPSDCMobAppTestDeviceId() != null)) {
            iDataObject.set(FIELD_PSDCMOBAPPTESTDEVICEID, (Object)pSMobAppPackTDBase.getPSDCMobAppTestDeviceId());
        }
        if (pSMobAppPackTDBase.isPSDCMobAppTestDeviceNameDirty() && (bl || pSMobAppPackTDBase.getPSDCMobAppTestDeviceName() != null)) {
            iDataObject.set(FIELD_PSDCMOBAPPTESTDEVICENAME, (Object)pSMobAppPackTDBase.getPSDCMobAppTestDeviceName());
        }
        if (pSMobAppPackTDBase.isPSDCMobPackCertIdDirty() && (bl || pSMobAppPackTDBase.getPSDCMobPackCertId() != null)) {
            iDataObject.set(FIELD_PSDCMOBPACKCERTID, (Object)pSMobAppPackTDBase.getPSDCMobPackCertId());
        }
        if (pSMobAppPackTDBase.isPSDCMobPackCertNameDirty() && (bl || pSMobAppPackTDBase.getPSDCMobPackCertName() != null)) {
            iDataObject.set(FIELD_PSDCMOBPACKCERTNAME, (Object)pSMobAppPackTDBase.getPSDCMobPackCertName());
        }
        if (pSMobAppPackTDBase.isPSMobAppPackIdDirty() && (bl || pSMobAppPackTDBase.getPSMobAppPackId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKID, (Object)pSMobAppPackTDBase.getPSMobAppPackId());
        }
        if (pSMobAppPackTDBase.isPSMobAppPackNameDirty() && (bl || pSMobAppPackTDBase.getPSMobAppPackName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKNAME, (Object)pSMobAppPackTDBase.getPSMobAppPackName());
        }
        if (pSMobAppPackTDBase.isPSMobAppPackTDIdDirty() && (bl || pSMobAppPackTDBase.getPSMobAppPackTDId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKTDID, (Object)pSMobAppPackTDBase.getPSMobAppPackTDId());
        }
        if (pSMobAppPackTDBase.isPSMobAppPackTDNameDirty() && (bl || pSMobAppPackTDBase.getPSMobAppPackTDName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKTDNAME, (Object)pSMobAppPackTDBase.getPSMobAppPackTDName());
        }
        if (pSMobAppPackTDBase.isUpdateDateDirty() && (bl || pSMobAppPackTDBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMobAppPackTDBase.getUpdateDate());
        }
        if (pSMobAppPackTDBase.isUpdateManDirty() && (bl || pSMobAppPackTDBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMobAppPackTDBase.getUpdateMan());
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
        return PSMobAppPackTDBase.remove(this, n);
    }

    private static boolean remove(PSMobAppPackTDBase pSMobAppPackTDBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppPackTDBase.resetCodeName();
                return true;
            }
            case 1: {
                pSMobAppPackTDBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSMobAppPackTDBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSMobAppPackTDBase.resetMemo();
                return true;
            }
            case 4: {
                pSMobAppPackTDBase.resetPSDCMobAppTestDeviceId();
                return true;
            }
            case 5: {
                pSMobAppPackTDBase.resetPSDCMobAppTestDeviceName();
                return true;
            }
            case 6: {
                pSMobAppPackTDBase.resetPSDCMobPackCertId();
                return true;
            }
            case 7: {
                pSMobAppPackTDBase.resetPSDCMobPackCertName();
                return true;
            }
            case 8: {
                pSMobAppPackTDBase.resetPSMobAppPackId();
                return true;
            }
            case 9: {
                pSMobAppPackTDBase.resetPSMobAppPackName();
                return true;
            }
            case 10: {
                pSMobAppPackTDBase.resetPSMobAppPackTDId();
                return true;
            }
            case 11: {
                pSMobAppPackTDBase.resetPSMobAppPackTDName();
                return true;
            }
            case 12: {
                pSMobAppPackTDBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSMobAppPackTDBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMobAppTestDevice getPSDCMobAppTestDevice() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTestDevice();
        }
        if (this.getPSDCMobAppTestDeviceId() == null) {
            return null;
        }
        Integer n = this.objPSDCMobAppTestDeviceLock;
        synchronized (n) {
            if (this.psdcmobapptestdevice != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMobAppTestDeviceId(), (Object)this.psdcmobapptestdevice.getPSDCMobAppTestDeviceId()) != 0L) {
                this.psdcmobapptestdevice = null;
            }
            if (this.psdcmobapptestdevice == null) {
                PSDCMobAppTestDevice pSDCMobAppTestDevice = new PSDCMobAppTestDevice();
                pSDCMobAppTestDevice.setPSDCMobAppTestDeviceId(this.getPSDCMobAppTestDeviceId());
                PSDCMobAppTestDeviceService pSDCMobAppTestDeviceService = (PSDCMobAppTestDeviceService)ServiceGlobal.getService(PSDCMobAppTestDeviceService.class, (SessionFactory)this.getSessionFactory());
                pSDCMobAppTestDeviceService.autoGet(pSDCMobAppTestDevice);
                this.psdcmobapptestdevice = pSDCMobAppTestDevice;
            }
            return this.psdcmobapptestdevice;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMobPackCert getPSDCMobPackCert() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobPackCert();
        }
        if (this.getPSDCMobPackCertId() == null) {
            return null;
        }
        Integer n = this.objPSDCMobPackCertLock;
        synchronized (n) {
            if (this.psdcmobpackcert != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMobPackCertId(), (Object)this.psdcmobpackcert.getPSDCMobPackCertId()) != 0L) {
                this.psdcmobpackcert = null;
            }
            if (this.psdcmobpackcert == null) {
                PSDCMobPackCert pSDCMobPackCert = new PSDCMobPackCert();
                pSDCMobPackCert.setPSDCMobPackCertId(this.getPSDCMobPackCertId());
                PSDCMobPackCertService pSDCMobPackCertService = (PSDCMobPackCertService)ServiceGlobal.getService(PSDCMobPackCertService.class, (SessionFactory)this.getSessionFactory());
                pSDCMobPackCertService.autoGet(pSDCMobPackCert);
                this.psdcmobpackcert = pSDCMobPackCert;
            }
            return this.psdcmobpackcert;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMobAppPack getPSMobAppPack() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPack();
        }
        if (this.getPSMobAppPackId() == null) {
            return null;
        }
        Integer n = this.objPSMobAppPackLock;
        synchronized (n) {
            if (this.psmobapppack != null && DataTypeHelper.compare((int)25, (Object)this.getPSMobAppPackId(), (Object)this.psmobapppack.getPSMobAppPackId()) != 0L) {
                this.psmobapppack = null;
            }
            if (this.psmobapppack == null) {
                PSMobAppPack pSMobAppPack = new PSMobAppPack();
                pSMobAppPack.setPSMobAppPackId(this.getPSMobAppPackId());
                PSMobAppPackService pSMobAppPackService = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
                pSMobAppPackService.autoGet(pSMobAppPack);
                this.psmobapppack = pSMobAppPack;
            }
            return this.psmobapppack;
        }
    }

    private PSMobAppPackTDBase getProxyEntity() {
        return this.proxyPSMobAppPackTDBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMobAppPackTDBase = null;
        if (iDataObject != null && iDataObject instanceof PSMobAppPackTDBase) {
            this.proxyPSMobAppPackTDBase = (PSMobAppPackTDBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackTDService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDCMOBAPPTESTDEVICEID, 4);
        fieldIndexMap.put(FIELD_PSDCMOBAPPTESTDEVICENAME, 5);
        fieldIndexMap.put(FIELD_PSDCMOBPACKCERTID, 6);
        fieldIndexMap.put(FIELD_PSDCMOBPACKCERTNAME, 7);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKID, 8);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKNAME, 9);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKTDID, 10);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKTDNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

