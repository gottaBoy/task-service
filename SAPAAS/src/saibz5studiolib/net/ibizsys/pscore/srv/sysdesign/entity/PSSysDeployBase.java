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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDeployBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDeployBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTDEPLOY = "DEFAULTDEPLOY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_PSSYSDEPLOYID = "PSSYSDEPLOYID";
    public static final String FIELD_PSSYSDEPLOYNAME = "PSSYSDEPLOYNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTDEPLOY = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVCENTERASID = 4;
    private static final int INDEX_PSDEVCENTERASNAME = 5;
    private static final int INDEX_PSSYSDEPLOYID = 6;
    private static final int INDEX_PSSYSDEPLOYNAME = 7;
    private static final int INDEX_PSSYSSFPUBID = 8;
    private static final int INDEX_PSSYSSFPUBNAME = 9;
    private static final int INDEX_PSSYSTEMID = 10;
    private static final int INDEX_PSSYSTEMNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERPARAMS = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDeployBase proxyPSSysDeployBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultdeployDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean pssysdeployidDirtyFlag = false;
    private boolean pssysdeploynameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultdeploy")
    private Integer defaultdeploy;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterasid")
    private String psdevcenterasid;
    @Column(name="psdevcenterasname")
    private String psdevcenterasname;
    @Column(name="pssysdeployid")
    private String pssysdeployid;
    @Column(name="pssysdeployname")
    private String pssysdeployname;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    private Integer objPsdevcenterasLock = new Integer(1);
    private PSDevCenterAS psdevcenteras = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;
    private Integer objPssystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setDefaultDeploy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultDeploy(n);
            return;
        }
        this.defaultdeploy = n;
        this.defaultdeployDirtyFlag = true;
    }

    public Integer getDefaultDeploy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultDeploy();
        }
        return this.defaultdeploy;
    }

    public boolean isDefaultDeployDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultDeployDirty();
        }
        return this.defaultdeployDirtyFlag;
    }

    public void resetDefaultDeploy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultDeploy();
            return;
        }
        this.defaultdeployDirtyFlag = false;
        this.defaultdeploy = null;
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

    public void setPSDevCenterASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasid = string;
        this.psdevcenterasidDirtyFlag = true;
    }

    public String getPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASId();
        }
        return this.psdevcenterasid;
    }

    public boolean isPSDevCenterASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASIdDirty();
        }
        return this.psdevcenterasidDirtyFlag;
    }

    public void resetPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASId();
            return;
        }
        this.psdevcenterasidDirtyFlag = false;
        this.psdevcenterasid = null;
    }

    public void setPSDevCenterASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasname = string;
        this.psdevcenterasnameDirtyFlag = true;
    }

    public String getPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASName();
        }
        return this.psdevcenterasname;
    }

    public boolean isPSDevCenterASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASNameDirty();
        }
        return this.psdevcenterasnameDirtyFlag;
    }

    public void resetPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASName();
            return;
        }
        this.psdevcenterasnameDirtyFlag = false;
        this.psdevcenterasname = null;
    }

    public void setPSSysDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployid = string;
        this.pssysdeployidDirtyFlag = true;
    }

    public String getPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployId();
        }
        return this.pssysdeployid;
    }

    public boolean isPSSysDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployIdDirty();
        }
        return this.pssysdeployidDirtyFlag;
    }

    public void resetPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployId();
            return;
        }
        this.pssysdeployidDirtyFlag = false;
        this.pssysdeployid = null;
    }

    public void setPSSysDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployname = string;
        this.pssysdeploynameDirtyFlag = true;
    }

    public String getPSSysDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployName();
        }
        return this.pssysdeployname;
    }

    public boolean isPSSysDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployNameDirty();
        }
        return this.pssysdeploynameDirtyFlag;
    }

    public void resetPSSysDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployName();
            return;
        }
        this.pssysdeploynameDirtyFlag = false;
        this.pssysdeployname = null;
    }

    public void setPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubid = string;
        this.pssyssfpubidDirtyFlag = true;
    }

    public String getPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubId();
        }
        return this.pssyssfpubid;
    }

    public boolean isPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubIdDirty();
        }
        return this.pssyssfpubidDirtyFlag;
    }

    public void resetPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubId();
            return;
        }
        this.pssyssfpubidDirtyFlag = false;
        this.pssyssfpubid = null;
    }

    public void setPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubname = string;
        this.pssyssfpubnameDirtyFlag = true;
    }

    public String getPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubName();
        }
        return this.pssyssfpubname;
    }

    public boolean isPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubNameDirty();
        }
        return this.pssyssfpubnameDirtyFlag;
    }

    public void resetPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubName();
            return;
        }
        this.pssyssfpubnameDirtyFlag = false;
        this.pssyssfpubname = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    protected void onReset() {
        PSSysDeployBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDeployBase pSSysDeployBase) {
        pSSysDeployBase.resetCreateDate();
        pSSysDeployBase.resetCreateMan();
        pSSysDeployBase.resetDefaultDeploy();
        pSSysDeployBase.resetMemo();
        pSSysDeployBase.resetPSDevCenterASId();
        pSSysDeployBase.resetPSDevCenterASName();
        pSSysDeployBase.resetPSSysDeployId();
        pSSysDeployBase.resetPSSysDeployName();
        pSSysDeployBase.resetPSSysSFPubId();
        pSSysDeployBase.resetPSSysSFPubName();
        pSSysDeployBase.resetPSSystemId();
        pSSysDeployBase.resetPSSystemName();
        pSSysDeployBase.resetUpdateDate();
        pSSysDeployBase.resetUpdateMan();
        pSSysDeployBase.resetUserParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultDeployDirty()) {
            hashMap.put(FIELD_DEFAULTDEPLOY, this.getDefaultDeploy());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterASIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID, this.getPSDevCenterASId());
        }
        if (!bl || this.isPSDevCenterASNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME, this.getPSDevCenterASName());
        }
        if (!bl || this.isPSSysDeployIdDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYID, this.getPSSysDeployId());
        }
        if (!bl || this.isPSSysDeployNameDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYNAME, this.getPSSysDeployName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSSysDeployBase.get(this, n);
    }

    private static Object get(PSSysDeployBase pSSysDeployBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployBase.getCreateDate();
            }
            case 1: {
                return pSSysDeployBase.getCreateMan();
            }
            case 2: {
                return pSSysDeployBase.getDefaultDeploy();
            }
            case 3: {
                return pSSysDeployBase.getMemo();
            }
            case 4: {
                return pSSysDeployBase.getPSDevCenterASId();
            }
            case 5: {
                return pSSysDeployBase.getPSDevCenterASName();
            }
            case 6: {
                return pSSysDeployBase.getPSSysDeployId();
            }
            case 7: {
                return pSSysDeployBase.getPSSysDeployName();
            }
            case 8: {
                return pSSysDeployBase.getPSSysSFPubId();
            }
            case 9: {
                return pSSysDeployBase.getPSSysSFPubName();
            }
            case 10: {
                return pSSysDeployBase.getPSSystemId();
            }
            case 11: {
                return pSSysDeployBase.getPSSystemName();
            }
            case 12: {
                return pSSysDeployBase.getUpdateDate();
            }
            case 13: {
                return pSSysDeployBase.getUpdateMan();
            }
            case 14: {
                return pSSysDeployBase.getUserParams();
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
        PSSysDeployBase.set(this, n, object);
    }

    private static void set(PSSysDeployBase pSSysDeployBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDeployBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDeployBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDeployBase.setDefaultDeploy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysDeployBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDeployBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDeployBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDeployBase.setPSSysDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDeployBase.setPSSysDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDeployBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDeployBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDeployBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDeployBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDeployBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysDeployBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDeployBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSSysDeployBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDeployBase pSSysDeployBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDeployBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDeployBase.getDefaultDeploy() == null;
            }
            case 3: {
                return pSSysDeployBase.getMemo() == null;
            }
            case 4: {
                return pSSysDeployBase.getPSDevCenterASId() == null;
            }
            case 5: {
                return pSSysDeployBase.getPSDevCenterASName() == null;
            }
            case 6: {
                return pSSysDeployBase.getPSSysDeployId() == null;
            }
            case 7: {
                return pSSysDeployBase.getPSSysDeployName() == null;
            }
            case 8: {
                return pSSysDeployBase.getPSSysSFPubId() == null;
            }
            case 9: {
                return pSSysDeployBase.getPSSysSFPubName() == null;
            }
            case 10: {
                return pSSysDeployBase.getPSSystemId() == null;
            }
            case 11: {
                return pSSysDeployBase.getPSSystemName() == null;
            }
            case 12: {
                return pSSysDeployBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysDeployBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSysDeployBase.getUserParams() == null;
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
        return PSSysDeployBase.contains(this, n);
    }

    private static boolean contains(PSSysDeployBase pSSysDeployBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDeployBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDeployBase.isDefaultDeployDirty();
            }
            case 3: {
                return pSSysDeployBase.isMemoDirty();
            }
            case 4: {
                return pSSysDeployBase.isPSDevCenterASIdDirty();
            }
            case 5: {
                return pSSysDeployBase.isPSDevCenterASNameDirty();
            }
            case 6: {
                return pSSysDeployBase.isPSSysDeployIdDirty();
            }
            case 7: {
                return pSSysDeployBase.isPSSysDeployNameDirty();
            }
            case 8: {
                return pSSysDeployBase.isPSSysSFPubIdDirty();
            }
            case 9: {
                return pSSysDeployBase.isPSSysSFPubNameDirty();
            }
            case 10: {
                return pSSysDeployBase.isPSSystemIdDirty();
            }
            case 11: {
                return pSSysDeployBase.isPSSystemNameDirty();
            }
            case 12: {
                return pSSysDeployBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysDeployBase.isUpdateManDirty();
            }
            case 14: {
                return pSSysDeployBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDeployBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDeployBase pSSysDeployBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDeployBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getDefaultDeploy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultdeploy", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getDefaultDeploy()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getPSSysDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployid", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getPSSysDeployId()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getPSSysDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployname", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getPSSysDeployName()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDeployBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSysDeployBase.getJSONValue((Object)pSSysDeployBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDeployBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDeployBase pSSysDeployBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDeployBase.getCreateDate() != null) {
            object = pSSysDeployBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDeployBase.getCreateMan() != null) {
            object = pSSysDeployBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getDefaultDeploy() != null) {
            object = pSSysDeployBase.getDefaultDeploy();
            xmlNode.setAttribute(FIELD_DEFAULTDEPLOY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDeployBase.getMemo() != null) {
            object = pSSysDeployBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getPSDevCenterASId() != null) {
            object = pSSysDeployBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getPSDevCenterASName() != null) {
            object = pSSysDeployBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getPSSysDeployId() != null) {
            object = pSSysDeployBase.getPSSysDeployId();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getPSSysDeployName() != null) {
            object = pSSysDeployBase.getPSSysDeployName();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getPSSysSFPubId() != null) {
            object = pSSysDeployBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getPSSysSFPubName() != null) {
            object = pSSysDeployBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getPSSystemId() != null) {
            object = pSSysDeployBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getPSSystemName() != null) {
            object = pSSysDeployBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getUpdateDate() != null) {
            object = pSSysDeployBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDeployBase.getUpdateMan() != null) {
            object = pSSysDeployBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployBase.getUserParams() != null) {
            object = pSSysDeployBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDeployBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDeployBase pSSysDeployBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDeployBase.isCreateDateDirty() && (bl || pSSysDeployBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDeployBase.getCreateDate());
        }
        if (pSSysDeployBase.isCreateManDirty() && (bl || pSSysDeployBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDeployBase.getCreateMan());
        }
        if (pSSysDeployBase.isDefaultDeployDirty() && (bl || pSSysDeployBase.getDefaultDeploy() != null)) {
            iDataObject.set(FIELD_DEFAULTDEPLOY, (Object)pSSysDeployBase.getDefaultDeploy());
        }
        if (pSSysDeployBase.isMemoDirty() && (bl || pSSysDeployBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDeployBase.getMemo());
        }
        if (pSSysDeployBase.isPSDevCenterASIdDirty() && (bl || pSSysDeployBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSSysDeployBase.getPSDevCenterASId());
        }
        if (pSSysDeployBase.isPSDevCenterASNameDirty() && (bl || pSSysDeployBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSSysDeployBase.getPSDevCenterASName());
        }
        if (pSSysDeployBase.isPSSysDeployIdDirty() && (bl || pSSysDeployBase.getPSSysDeployId() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYID, (Object)pSSysDeployBase.getPSSysDeployId());
        }
        if (pSSysDeployBase.isPSSysDeployNameDirty() && (bl || pSSysDeployBase.getPSSysDeployName() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYNAME, (Object)pSSysDeployBase.getPSSysDeployName());
        }
        if (pSSysDeployBase.isPSSysSFPubIdDirty() && (bl || pSSysDeployBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSysDeployBase.getPSSysSFPubId());
        }
        if (pSSysDeployBase.isPSSysSFPubNameDirty() && (bl || pSSysDeployBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSysDeployBase.getPSSysSFPubName());
        }
        if (pSSysDeployBase.isPSSystemIdDirty() && (bl || pSSysDeployBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDeployBase.getPSSystemId());
        }
        if (pSSysDeployBase.isPSSystemNameDirty() && (bl || pSSysDeployBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDeployBase.getPSSystemName());
        }
        if (pSSysDeployBase.isUpdateDateDirty() && (bl || pSSysDeployBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDeployBase.getUpdateDate());
        }
        if (pSSysDeployBase.isUpdateManDirty() && (bl || pSSysDeployBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDeployBase.getUpdateMan());
        }
        if (pSSysDeployBase.isUserParamsDirty() && (bl || pSSysDeployBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSysDeployBase.getUserParams());
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
        return PSSysDeployBase.remove(this, n);
    }

    private static boolean remove(PSSysDeployBase pSSysDeployBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDeployBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDeployBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDeployBase.resetDefaultDeploy();
                return true;
            }
            case 3: {
                pSSysDeployBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysDeployBase.resetPSDevCenterASId();
                return true;
            }
            case 5: {
                pSSysDeployBase.resetPSDevCenterASName();
                return true;
            }
            case 6: {
                pSSysDeployBase.resetPSSysDeployId();
                return true;
            }
            case 7: {
                pSSysDeployBase.resetPSSysDeployName();
                return true;
            }
            case 8: {
                pSSysDeployBase.resetPSSysSFPubId();
                return true;
            }
            case 9: {
                pSSysDeployBase.resetPSSysSFPubName();
                return true;
            }
            case 10: {
                pSSysDeployBase.resetPSSystemId();
                return true;
            }
            case 11: {
                pSSysDeployBase.resetPSSystemName();
                return true;
            }
            case 12: {
                pSSysDeployBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysDeployBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSysDeployBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPsdevcenteras() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdevcenteras();
        }
        if (this.getPSDevCenterASId() == null) {
            return null;
        }
        Integer n = this.objPsdevcenterasLock;
        synchronized (n) {
            if (this.psdevcenteras != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId(), (Object)this.psdevcenteras.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras = null;
            }
            if (this.psdevcenteras == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet((IEntity)pSDevCenterAS);
                this.psdevcenteras = pSDevCenterAS;
            }
            return this.psdevcenteras;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPub getPSSysSFPub() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPub();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPubLock;
        synchronized (n) {
            if (this.pssyssfpub != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPubId(), (Object)this.pssyssfpub.getPSSysSFPubId()) != 0L) {
                this.pssyssfpub = null;
            }
            if (this.pssyssfpub == null) {
                PSSysSFPub pSSysSFPub = new PSSysSFPub();
                pSSysSFPub.setPSSysSFPubId(this.getPSSysSFPubId());
                PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPubService.autoGet((IEntity)pSSysSFPub);
                this.pssyssfpub = pSSysSFPub;
            }
            return this.pssyssfpub;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPssystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPssystemLock;
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

    private PSSysDeployBase getProxyEntity() {
        return this.proxyPSSysDeployBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDeployBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDeployBase) {
            this.proxyPSSysDeployBase = (PSSysDeployBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTDEPLOY, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYID, 6);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 8);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERPARAMS, 14);
    }
}

