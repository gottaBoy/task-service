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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysDBBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSaaSSysDBBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBINSTID = "PSDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSSAASSYSDBID = "PSSAASSYSDBID";
    public static final String FIELD_PSSAASSYSDBNAME = "PSSAASSYSDBNAME";
    public static final String FIELD_PSSAASSYSVERID = "PSSAASSYSVERID";
    public static final String FIELD_PSSAASSYSVERNAME = "PSSAASSYSVERNAME";
    public static final String FIELD_SAMPLEPSDBINSTID = "SAMPLEPSDBINSTID";
    public static final String FIELD_SAMPLEPSDCDBINSTID = "SAMPLEPSDCDBINSTID";
    public static final String FIELD_SAMPLEPSDCDBINSTNAME = "SAMPLEPSDCDBINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDBINSTID = 3;
    private static final int INDEX_PSDEVCENTERDBINSTID = 4;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 5;
    private static final int INDEX_PSSAASSYSDBID = 6;
    private static final int INDEX_PSSAASSYSDBNAME = 7;
    private static final int INDEX_PSSAASSYSVERID = 8;
    private static final int INDEX_PSSAASSYSVERNAME = 9;
    private static final int INDEX_SAMPLEPSDBINSTID = 10;
    private static final int INDEX_SAMPLEPSDCDBINSTID = 11;
    private static final int INDEX_SAMPLEPSDCDBINSTNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSaaSSysDBBase proxyPSSaaSSysDBBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean pssaassysdbidDirtyFlag = false;
    private boolean pssaassysdbnameDirtyFlag = false;
    private boolean pssaassysveridDirtyFlag = false;
    private boolean pssaassysvernameDirtyFlag = false;
    private boolean samplepsdbinstidDirtyFlag = false;
    private boolean samplepsdcdbinstidDirtyFlag = false;
    private boolean samplepsdcdbinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbinstid")
    private String psdbinstid;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="pssaassysdbid")
    private String pssaassysdbid;
    @Column(name="pssaassysdbname")
    private String pssaassysdbname;
    @Column(name="pssaassysverid")
    private String pssaassysverid;
    @Column(name="pssaassysvername")
    private String pssaassysvername;
    @Column(name="samplepsdbinstid")
    private String samplepsdbinstid;
    @Column(name="samplepsdcdbinstid")
    private String samplepsdcdbinstid;
    @Column(name="samplepsdcdbinstname")
    private String samplepsdcdbinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objSamplePSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst samplepsdcdbinst = null;
    private Integer objPSSaaSSysVerLock = new Integer(1);
    private PSSaaSSysVer pssaassysver = null;

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

    public void setPSDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbinstid = string;
        this.psdbinstidDirtyFlag = true;
    }

    public String getPSDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBInstId();
        }
        return this.psdbinstid;
    }

    public boolean isPSDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBInstIdDirty();
        }
        return this.psdbinstidDirtyFlag;
    }

    public void resetPSDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBInstId();
            return;
        }
        this.psdbinstidDirtyFlag = false;
        this.psdbinstid = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
    }

    public void setPSSaaSSysDBId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysDBId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysdbid = string;
        this.pssaassysdbidDirtyFlag = true;
    }

    public String getPSSaaSSysDBId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysDBId();
        }
        return this.pssaassysdbid;
    }

    public boolean isPSSaaSSysDBIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysDBIdDirty();
        }
        return this.pssaassysdbidDirtyFlag;
    }

    public void resetPSSaaSSysDBId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysDBId();
            return;
        }
        this.pssaassysdbidDirtyFlag = false;
        this.pssaassysdbid = null;
    }

    public void setPSSaasSysDBName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaasSysDBName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysdbname = string;
        this.pssaassysdbnameDirtyFlag = true;
    }

    public String getPSSaasSysDBName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaasSysDBName();
        }
        return this.pssaassysdbname;
    }

    public boolean isPSSaasSysDBNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaasSysDBNameDirty();
        }
        return this.pssaassysdbnameDirtyFlag;
    }

    public void resetPSSaasSysDBName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaasSysDBName();
            return;
        }
        this.pssaassysdbnameDirtyFlag = false;
        this.pssaassysdbname = null;
    }

    public void setPSSaaSSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysverid = string;
        this.pssaassysveridDirtyFlag = true;
    }

    public String getPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerId();
        }
        return this.pssaassysverid;
    }

    public boolean isPSSaaSSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerIdDirty();
        }
        return this.pssaassysveridDirtyFlag;
    }

    public void resetPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerId();
            return;
        }
        this.pssaassysveridDirtyFlag = false;
        this.pssaassysverid = null;
    }

    public void setPSSaaSSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysvername = string;
        this.pssaassysvernameDirtyFlag = true;
    }

    public String getPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerName();
        }
        return this.pssaassysvername;
    }

    public boolean isPSSaaSSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerNameDirty();
        }
        return this.pssaassysvernameDirtyFlag;
    }

    public void resetPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerName();
            return;
        }
        this.pssaassysvernameDirtyFlag = false;
        this.pssaassysvername = null;
    }

    public void setSamplePSDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSamplePSDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.samplepsdbinstid = string;
        this.samplepsdbinstidDirtyFlag = true;
    }

    public String getSamplePSDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSamplePSDBInstId();
        }
        return this.samplepsdbinstid;
    }

    public boolean isSamplePSDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSamplePSDBInstIdDirty();
        }
        return this.samplepsdbinstidDirtyFlag;
    }

    public void resetSamplePSDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSamplePSDBInstId();
            return;
        }
        this.samplepsdbinstidDirtyFlag = false;
        this.samplepsdbinstid = null;
    }

    public void setSamplePSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSamplePSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.samplepsdcdbinstid = string;
        this.samplepsdcdbinstidDirtyFlag = true;
    }

    public String getSamplePSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSamplePSDCDBInstId();
        }
        return this.samplepsdcdbinstid;
    }

    public boolean isSamplePSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSamplePSDCDBInstIdDirty();
        }
        return this.samplepsdcdbinstidDirtyFlag;
    }

    public void resetSamplePSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSamplePSDCDBInstId();
            return;
        }
        this.samplepsdcdbinstidDirtyFlag = false;
        this.samplepsdcdbinstid = null;
    }

    public void setSamplePSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSamplePSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.samplepsdcdbinstname = string;
        this.samplepsdcdbinstnameDirtyFlag = true;
    }

    public String getSamplePSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSamplePSDCDBInstName();
        }
        return this.samplepsdcdbinstname;
    }

    public boolean isSamplePSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSamplePSDCDBInstNameDirty();
        }
        return this.samplepsdcdbinstnameDirtyFlag;
    }

    public void resetSamplePSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSamplePSDCDBInstName();
            return;
        }
        this.samplepsdcdbinstnameDirtyFlag = false;
        this.samplepsdcdbinstname = null;
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
        PSSaaSSysDBBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSaaSSysDBBase pSSaaSSysDBBase) {
        pSSaaSSysDBBase.resetCreateDate();
        pSSaaSSysDBBase.resetCreateMan();
        pSSaaSSysDBBase.resetMemo();
        pSSaaSSysDBBase.resetPSDBInstId();
        pSSaaSSysDBBase.resetPSDevCenterDBInstId();
        pSSaaSSysDBBase.resetPSDevCenterDBInstName();
        pSSaaSSysDBBase.resetPSSaaSSysDBId();
        pSSaaSSysDBBase.resetPSSaasSysDBName();
        pSSaaSSysDBBase.resetPSSaaSSysVerId();
        pSSaaSSysDBBase.resetPSSaaSSysVerName();
        pSSaaSSysDBBase.resetSamplePSDBInstId();
        pSSaaSSysDBBase.resetSamplePSDCDBInstId();
        pSSaaSSysDBBase.resetSamplePSDCDBInstName();
        pSSaaSSysDBBase.resetUpdateDate();
        pSSaaSSysDBBase.resetUpdateMan();
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
        if (!bl || this.isPSDBInstIdDirty()) {
            hashMap.put(FIELD_PSDBINSTID, this.getPSDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSSaaSSysDBIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSDBID, this.getPSSaaSSysDBId());
        }
        if (!bl || this.isPSSaasSysDBNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSDBNAME, this.getPSSaasSysDBName());
        }
        if (!bl || this.isPSSaaSSysVerIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERID, this.getPSSaaSSysVerId());
        }
        if (!bl || this.isPSSaaSSysVerNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERNAME, this.getPSSaaSSysVerName());
        }
        if (!bl || this.isSamplePSDBInstIdDirty()) {
            hashMap.put(FIELD_SAMPLEPSDBINSTID, this.getSamplePSDBInstId());
        }
        if (!bl || this.isSamplePSDCDBInstIdDirty()) {
            hashMap.put(FIELD_SAMPLEPSDCDBINSTID, this.getSamplePSDCDBInstId());
        }
        if (!bl || this.isSamplePSDCDBInstNameDirty()) {
            hashMap.put(FIELD_SAMPLEPSDCDBINSTNAME, this.getSamplePSDCDBInstName());
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
        return PSSaaSSysDBBase.get(this, n);
    }

    private static Object get(PSSaaSSysDBBase pSSaaSSysDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysDBBase.getCreateDate();
            }
            case 1: {
                return pSSaaSSysDBBase.getCreateMan();
            }
            case 2: {
                return pSSaaSSysDBBase.getMemo();
            }
            case 3: {
                return pSSaaSSysDBBase.getPSDBInstId();
            }
            case 4: {
                return pSSaaSSysDBBase.getPSDevCenterDBInstId();
            }
            case 5: {
                return pSSaaSSysDBBase.getPSDevCenterDBInstName();
            }
            case 6: {
                return pSSaaSSysDBBase.getPSSaaSSysDBId();
            }
            case 7: {
                return pSSaaSSysDBBase.getPSSaasSysDBName();
            }
            case 8: {
                return pSSaaSSysDBBase.getPSSaaSSysVerId();
            }
            case 9: {
                return pSSaaSSysDBBase.getPSSaaSSysVerName();
            }
            case 10: {
                return pSSaaSSysDBBase.getSamplePSDBInstId();
            }
            case 11: {
                return pSSaaSSysDBBase.getSamplePSDCDBInstId();
            }
            case 12: {
                return pSSaaSSysDBBase.getSamplePSDCDBInstName();
            }
            case 13: {
                return pSSaaSSysDBBase.getUpdateDate();
            }
            case 14: {
                return pSSaaSSysDBBase.getUpdateMan();
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
        PSSaaSSysDBBase.set(this, n, object);
    }

    private static void set(PSSaaSSysDBBase pSSaaSSysDBBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysDBBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSaaSSysDBBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSaaSSysDBBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSaaSSysDBBase.setPSDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSaaSSysDBBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSaaSSysDBBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSaaSSysDBBase.setPSSaaSSysDBId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSaaSSysDBBase.setPSSaasSysDBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSaaSSysDBBase.setPSSaaSSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSaaSSysDBBase.setPSSaaSSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSaaSSysDBBase.setSamplePSDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSaaSSysDBBase.setSamplePSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSaaSSysDBBase.setSamplePSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSaaSSysDBBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSSaaSSysDBBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSaaSSysDBBase.isNull(this, n);
    }

    private static boolean isNull(PSSaaSSysDBBase pSSaaSSysDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysDBBase.getCreateDate() == null;
            }
            case 1: {
                return pSSaaSSysDBBase.getCreateMan() == null;
            }
            case 2: {
                return pSSaaSSysDBBase.getMemo() == null;
            }
            case 3: {
                return pSSaaSSysDBBase.getPSDBInstId() == null;
            }
            case 4: {
                return pSSaaSSysDBBase.getPSDevCenterDBInstId() == null;
            }
            case 5: {
                return pSSaaSSysDBBase.getPSDevCenterDBInstName() == null;
            }
            case 6: {
                return pSSaaSSysDBBase.getPSSaaSSysDBId() == null;
            }
            case 7: {
                return pSSaaSSysDBBase.getPSSaasSysDBName() == null;
            }
            case 8: {
                return pSSaaSSysDBBase.getPSSaaSSysVerId() == null;
            }
            case 9: {
                return pSSaaSSysDBBase.getPSSaaSSysVerName() == null;
            }
            case 10: {
                return pSSaaSSysDBBase.getSamplePSDBInstId() == null;
            }
            case 11: {
                return pSSaaSSysDBBase.getSamplePSDCDBInstId() == null;
            }
            case 12: {
                return pSSaaSSysDBBase.getSamplePSDCDBInstName() == null;
            }
            case 13: {
                return pSSaaSSysDBBase.getUpdateDate() == null;
            }
            case 14: {
                return pSSaaSSysDBBase.getUpdateMan() == null;
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
        return PSSaaSSysDBBase.contains(this, n);
    }

    private static boolean contains(PSSaaSSysDBBase pSSaaSSysDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysDBBase.isCreateDateDirty();
            }
            case 1: {
                return pSSaaSSysDBBase.isCreateManDirty();
            }
            case 2: {
                return pSSaaSSysDBBase.isMemoDirty();
            }
            case 3: {
                return pSSaaSSysDBBase.isPSDBInstIdDirty();
            }
            case 4: {
                return pSSaaSSysDBBase.isPSDevCenterDBInstIdDirty();
            }
            case 5: {
                return pSSaaSSysDBBase.isPSDevCenterDBInstNameDirty();
            }
            case 6: {
                return pSSaaSSysDBBase.isPSSaaSSysDBIdDirty();
            }
            case 7: {
                return pSSaaSSysDBBase.isPSSaasSysDBNameDirty();
            }
            case 8: {
                return pSSaaSSysDBBase.isPSSaaSSysVerIdDirty();
            }
            case 9: {
                return pSSaaSSysDBBase.isPSSaaSSysVerNameDirty();
            }
            case 10: {
                return pSSaaSSysDBBase.isSamplePSDBInstIdDirty();
            }
            case 11: {
                return pSSaaSSysDBBase.isSamplePSDCDBInstIdDirty();
            }
            case 12: {
                return pSSaaSSysDBBase.isSamplePSDCDBInstNameDirty();
            }
            case 13: {
                return pSSaaSSysDBBase.isUpdateDateDirty();
            }
            case 14: {
                return pSSaaSSysDBBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSaaSSysDBBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSaaSSysDBBase pSSaaSSysDBBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSaaSSysDBBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getMemo()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getPSDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbinstid", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getPSDBInstId()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getPSSaaSSysDBId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysdbid", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getPSSaaSSysDBId()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getPSSaasSysDBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysdbname", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getPSSaasSysDBName()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getPSSaaSSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysverid", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getPSSaaSSysVerId()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getPSSaaSSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysvername", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getPSSaaSSysVerName()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getSamplePSDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"samplepsdbinstid", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getSamplePSDBInstId()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getSamplePSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"samplepsdcdbinstid", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getSamplePSDCDBInstId()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getSamplePSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"samplepsdcdbinstname", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getSamplePSDCDBInstName()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysDBBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSaaSSysDBBase.getJSONValue((Object)pSSaaSSysDBBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSaaSSysDBBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSaaSSysDBBase pSSaaSSysDBBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSaaSSysDBBase.getCreateDate() != null) {
            object = pSSaaSSysDBBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysDBBase.getCreateMan() != null) {
            object = pSSaaSSysDBBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getMemo() != null) {
            object = pSSaaSSysDBBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getPSDBInstId() != null) {
            object = pSSaaSSysDBBase.getPSDBInstId();
            xmlNode.setAttribute(FIELD_PSDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getPSDevCenterDBInstId() != null) {
            object = pSSaaSSysDBBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getPSDevCenterDBInstName() != null) {
            object = pSSaaSSysDBBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getPSSaaSSysDBId() != null) {
            object = pSSaaSSysDBBase.getPSSaaSSysDBId();
            xmlNode.setAttribute(FIELD_PSSAASSYSDBID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getPSSaasSysDBName() != null) {
            object = pSSaaSSysDBBase.getPSSaasSysDBName();
            xmlNode.setAttribute(FIELD_PSSAASSYSDBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getPSSaaSSysVerId() != null) {
            object = pSSaaSSysDBBase.getPSSaaSSysVerId();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getPSSaaSSysVerName() != null) {
            object = pSSaaSSysDBBase.getPSSaaSSysVerName();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getSamplePSDBInstId() != null) {
            object = pSSaaSSysDBBase.getSamplePSDBInstId();
            xmlNode.setAttribute(FIELD_SAMPLEPSDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getSamplePSDCDBInstId() != null) {
            object = pSSaaSSysDBBase.getSamplePSDCDBInstId();
            xmlNode.setAttribute(FIELD_SAMPLEPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getSamplePSDCDBInstName() != null) {
            object = pSSaaSSysDBBase.getSamplePSDCDBInstName();
            xmlNode.setAttribute(FIELD_SAMPLEPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysDBBase.getUpdateDate() != null) {
            object = pSSaaSSysDBBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysDBBase.getUpdateMan() != null) {
            object = pSSaaSSysDBBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSaaSSysDBBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSaaSSysDBBase pSSaaSSysDBBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSaaSSysDBBase.isCreateDateDirty() && (bl || pSSaaSSysDBBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSaaSSysDBBase.getCreateDate());
        }
        if (pSSaaSSysDBBase.isCreateManDirty() && (bl || pSSaaSSysDBBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSaaSSysDBBase.getCreateMan());
        }
        if (pSSaaSSysDBBase.isMemoDirty() && (bl || pSSaaSSysDBBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSaaSSysDBBase.getMemo());
        }
        if (pSSaaSSysDBBase.isPSDBInstIdDirty() && (bl || pSSaaSSysDBBase.getPSDBInstId() != null)) {
            iDataObject.set(FIELD_PSDBINSTID, (Object)pSSaaSSysDBBase.getPSDBInstId());
        }
        if (pSSaaSSysDBBase.isPSDevCenterDBInstIdDirty() && (bl || pSSaaSSysDBBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSSaaSSysDBBase.getPSDevCenterDBInstId());
        }
        if (pSSaaSSysDBBase.isPSDevCenterDBInstNameDirty() && (bl || pSSaaSSysDBBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSSaaSSysDBBase.getPSDevCenterDBInstName());
        }
        if (pSSaaSSysDBBase.isPSSaaSSysDBIdDirty() && (bl || pSSaaSSysDBBase.getPSSaaSSysDBId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSDBID, (Object)pSSaaSSysDBBase.getPSSaaSSysDBId());
        }
        if (pSSaaSSysDBBase.isPSSaasSysDBNameDirty() && (bl || pSSaaSSysDBBase.getPSSaasSysDBName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSDBNAME, (Object)pSSaaSSysDBBase.getPSSaasSysDBName());
        }
        if (pSSaaSSysDBBase.isPSSaaSSysVerIdDirty() && (bl || pSSaaSSysDBBase.getPSSaaSSysVerId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERID, (Object)pSSaaSSysDBBase.getPSSaaSSysVerId());
        }
        if (pSSaaSSysDBBase.isPSSaaSSysVerNameDirty() && (bl || pSSaaSSysDBBase.getPSSaaSSysVerName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERNAME, (Object)pSSaaSSysDBBase.getPSSaaSSysVerName());
        }
        if (pSSaaSSysDBBase.isSamplePSDBInstIdDirty() && (bl || pSSaaSSysDBBase.getSamplePSDBInstId() != null)) {
            iDataObject.set(FIELD_SAMPLEPSDBINSTID, (Object)pSSaaSSysDBBase.getSamplePSDBInstId());
        }
        if (pSSaaSSysDBBase.isSamplePSDCDBInstIdDirty() && (bl || pSSaaSSysDBBase.getSamplePSDCDBInstId() != null)) {
            iDataObject.set(FIELD_SAMPLEPSDCDBINSTID, (Object)pSSaaSSysDBBase.getSamplePSDCDBInstId());
        }
        if (pSSaaSSysDBBase.isSamplePSDCDBInstNameDirty() && (bl || pSSaaSSysDBBase.getSamplePSDCDBInstName() != null)) {
            iDataObject.set(FIELD_SAMPLEPSDCDBINSTNAME, (Object)pSSaaSSysDBBase.getSamplePSDCDBInstName());
        }
        if (pSSaaSSysDBBase.isUpdateDateDirty() && (bl || pSSaaSSysDBBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSaaSSysDBBase.getUpdateDate());
        }
        if (pSSaaSSysDBBase.isUpdateManDirty() && (bl || pSSaaSSysDBBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSaaSSysDBBase.getUpdateMan());
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
        return PSSaaSSysDBBase.remove(this, n);
    }

    private static boolean remove(PSSaaSSysDBBase pSSaaSSysDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysDBBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSaaSSysDBBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSaaSSysDBBase.resetMemo();
                return true;
            }
            case 3: {
                pSSaaSSysDBBase.resetPSDBInstId();
                return true;
            }
            case 4: {
                pSSaaSSysDBBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 5: {
                pSSaaSSysDBBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 6: {
                pSSaaSSysDBBase.resetPSSaaSSysDBId();
                return true;
            }
            case 7: {
                pSSaaSSysDBBase.resetPSSaasSysDBName();
                return true;
            }
            case 8: {
                pSSaaSSysDBBase.resetPSSaaSSysVerId();
                return true;
            }
            case 9: {
                pSSaaSSysDBBase.resetPSSaaSSysVerName();
                return true;
            }
            case 10: {
                pSSaaSSysDBBase.resetSamplePSDBInstId();
                return true;
            }
            case 11: {
                pSSaaSSysDBBase.resetSamplePSDCDBInstId();
                return true;
            }
            case 12: {
                pSSaaSSysDBBase.resetSamplePSDCDBInstName();
                return true;
            }
            case 13: {
                pSSaaSSysDBBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSSaaSSysDBBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getSamplePSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSamplePSDCDBInst();
        }
        if (this.getSamplePSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objSamplePSDCDBInstLock;
        synchronized (n) {
            if (this.samplepsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getSamplePSDCDBInstId(), (Object)this.samplepsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.samplepsdcdbinst = null;
            }
            if (this.samplepsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getSamplePSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.samplepsdcdbinst = pSDevCenterDBInst;
            }
            return this.samplepsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSysVer getPSSaaSSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVer();
        }
        if (this.getPSSaaSSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysVerLock;
        synchronized (n) {
            if (this.pssaassysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysVerId(), (Object)this.pssaassysver.getPSSaaSSysVerId()) != 0L) {
                this.pssaassysver = null;
            }
            if (this.pssaassysver == null) {
                PSSaaSSysVer pSSaaSSysVer = new PSSaaSSysVer();
                pSSaaSSysVer.setPSSaaSSysVerId(this.getPSSaaSSysVerId());
                PSSaaSSysVerService pSSaaSSysVerService = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysVerService.autoGet((IEntity)pSSaaSSysVer);
                this.pssaassysver = pSSaaSSysVer;
            }
            return this.pssaassysver;
        }
    }

    private PSSaaSSysDBBase getProxyEntity() {
        return this.proxyPSSaaSSysDBBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSaaSSysDBBase = null;
        if (iDataObject != null && iDataObject instanceof PSSaaSSysDBBase) {
            this.proxyPSSaaSSysDBBase = (PSSaaSSysDBBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSSaaSSysDBService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDBINSTID, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSSAASSYSDBID, 6);
        fieldIndexMap.put(FIELD_PSSAASSYSDBNAME, 7);
        fieldIndexMap.put(FIELD_PSSAASSYSVERID, 8);
        fieldIndexMap.put(FIELD_PSSAASSYSVERNAME, 9);
        fieldIndexMap.put(FIELD_SAMPLEPSDBINSTID, 10);
        fieldIndexMap.put(FIELD_SAMPLEPSDCDBINSTID, 11);
        fieldIndexMap.put(FIELD_SAMPLEPSDCDBINSTNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

