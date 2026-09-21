/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWCreateDEDERBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWCreateDEDERBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DERPARAM = "DERPARAM";
    public static final String FIELD_DERPARAM2 = "DERPARAM2";
    public static final String FIELD_DERPARAM3 = "DERPARAM3";
    public static final String FIELD_DERPARAM4 = "DERPARAM4";
    public static final String FIELD_NEWPICKUPDEFNAME = "NEWPICKUPDEFNAME";
    public static final String FIELD_PICKUPDEFNAME = "PICKUPDEFNAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSUWCREATEDEDERID = "PSUWCREATEDEDERID";
    public static final String FIELD_PSUWCREATEDEDERNAME = "PSUWCREATEDEDERNAME";
    public static final String FIELD_PSUWCREATEDEID = "PSUWCREATEDEID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DERPARAM = 2;
    private static final int INDEX_DERPARAM2 = 3;
    private static final int INDEX_DERPARAM3 = 4;
    private static final int INDEX_DERPARAM4 = 5;
    private static final int INDEX_NEWPICKUPDEFNAME = 6;
    private static final int INDEX_PICKUPDEFNAME = 7;
    private static final int INDEX_PSDERID = 8;
    private static final int INDEX_PSDERNAME = 9;
    private static final int INDEX_PSDYNAINSTID = 10;
    private static final int INDEX_PSUWCREATEDEDERID = 11;
    private static final int INDEX_PSUWCREATEDEDERNAME = 12;
    private static final int INDEX_PSUWCREATEDEID = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_WIZARDMODE = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWCreateDEDERBase proxyPSUWCreateDEDERBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean derparamDirtyFlag = false;
    private boolean derparam2DirtyFlag = false;
    private boolean derparam3DirtyFlag = false;
    private boolean derparam4DirtyFlag = false;
    private boolean newpickupdefnameDirtyFlag = false;
    private boolean pickupdefnameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psuwcreatedederidDirtyFlag = false;
    private boolean psuwcreatededernameDirtyFlag = false;
    private boolean psuwcreatedeidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="derparam")
    private String derparam;
    @Column(name="derparam2")
    private String derparam2;
    @Column(name="derparam3")
    private Integer derparam3;
    @Column(name="derparam4")
    private Integer derparam4;
    @Column(name="newpickupdefname")
    private String newpickupdefname;
    @Column(name="pickupdefname")
    private String pickupdefname;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psuwcreatedederid")
    private String psuwcreatedederid;
    @Column(name="psuwcreatededername")
    private String psuwcreatededername;
    @Column(name="psuwcreatedeid")
    private String psuwcreatedeid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wizardmode")
    private String wizardmode;

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

    public void setDERParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.derparam = string;
        this.derparamDirtyFlag = true;
    }

    public String getDERParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERParam();
        }
        return this.derparam;
    }

    public boolean isDERParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERParamDirty();
        }
        return this.derparamDirtyFlag;
    }

    public void resetDERParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERParam();
            return;
        }
        this.derparamDirtyFlag = false;
        this.derparam = null;
    }

    public void setDERParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.derparam2 = string;
        this.derparam2DirtyFlag = true;
    }

    public String getDERParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERParam2();
        }
        return this.derparam2;
    }

    public boolean isDERParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERParam2Dirty();
        }
        return this.derparam2DirtyFlag;
    }

    public void resetDERParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERParam2();
            return;
        }
        this.derparam2DirtyFlag = false;
        this.derparam2 = null;
    }

    public void setDERParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERParam3(n);
            return;
        }
        this.derparam3 = n;
        this.derparam3DirtyFlag = true;
    }

    public Integer getDERParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERParam3();
        }
        return this.derparam3;
    }

    public boolean isDERParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERParam3Dirty();
        }
        return this.derparam3DirtyFlag;
    }

    public void resetDERParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERParam3();
            return;
        }
        this.derparam3DirtyFlag = false;
        this.derparam3 = null;
    }

    public void setDERParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERParam4(n);
            return;
        }
        this.derparam4 = n;
        this.derparam4DirtyFlag = true;
    }

    public Integer getDERParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERParam4();
        }
        return this.derparam4;
    }

    public boolean isDERParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERParam4Dirty();
        }
        return this.derparam4DirtyFlag;
    }

    public void resetDERParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERParam4();
            return;
        }
        this.derparam4DirtyFlag = false;
        this.derparam4 = null;
    }

    public void setNewPickupDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewPickupDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newpickupdefname = string;
        this.newpickupdefnameDirtyFlag = true;
    }

    public String getNewPickupDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewPickupDEFName();
        }
        return this.newpickupdefname;
    }

    public boolean isNewPickupDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewPickupDEFNameDirty();
        }
        return this.newpickupdefnameDirtyFlag;
    }

    public void resetNewPickupDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewPickupDEFName();
            return;
        }
        this.newpickupdefnameDirtyFlag = false;
        this.newpickupdefname = null;
    }

    public void setPickupDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPickupDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pickupdefname = string;
        this.pickupdefnameDirtyFlag = true;
    }

    public String getPickupDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupDEFName();
        }
        return this.pickupdefname;
    }

    public boolean isPickupDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPickupDEFNameDirty();
        }
        return this.pickupdefnameDirtyFlag;
    }

    public void resetPickupDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPickupDEFName();
            return;
        }
        this.pickupdefnameDirtyFlag = false;
        this.pickupdefname = null;
    }

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSUWCreateDEDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatedederid = string;
        this.psuwcreatedederidDirtyFlag = true;
    }

    public String getPSUWCreateDEDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEDERId();
        }
        return this.psuwcreatedederid;
    }

    public boolean isPSUWCreateDEDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEDERIdDirty();
        }
        return this.psuwcreatedederidDirtyFlag;
    }

    public void resetPSUWCreateDEDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEDERId();
            return;
        }
        this.psuwcreatedederidDirtyFlag = false;
        this.psuwcreatedederid = null;
    }

    public void setPSUWCreateDEDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatededername = string;
        this.psuwcreatededernameDirtyFlag = true;
    }

    public String getPSUWCreateDEDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEDERName();
        }
        return this.psuwcreatededername;
    }

    public boolean isPSUWCreateDEDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEDERNameDirty();
        }
        return this.psuwcreatededernameDirtyFlag;
    }

    public void resetPSUWCreateDEDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEDERName();
            return;
        }
        this.psuwcreatededernameDirtyFlag = false;
        this.psuwcreatededername = null;
    }

    public void setPSUWCreateDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatedeid = string;
        this.psuwcreatedeidDirtyFlag = true;
    }

    public String getPSUWCreateDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEId();
        }
        return this.psuwcreatedeid;
    }

    public boolean isPSUWCreateDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEIdDirty();
        }
        return this.psuwcreatedeidDirtyFlag;
    }

    public void resetPSUWCreateDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEId();
            return;
        }
        this.psuwcreatedeidDirtyFlag = false;
        this.psuwcreatedeid = null;
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

    public void setWizardMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardmode = string;
        this.wizardmodeDirtyFlag = true;
    }

    public String getWizardMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardMode();
        }
        return this.wizardmode;
    }

    public boolean isWizardModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardModeDirty();
        }
        return this.wizardmodeDirtyFlag;
    }

    public void resetWizardMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardMode();
            return;
        }
        this.wizardmodeDirtyFlag = false;
        this.wizardmode = null;
    }

    protected void onReset() {
        PSUWCreateDEDERBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWCreateDEDERBase pSUWCreateDEDERBase) {
        pSUWCreateDEDERBase.resetCreateDate();
        pSUWCreateDEDERBase.resetCreateMan();
        pSUWCreateDEDERBase.resetDERParam();
        pSUWCreateDEDERBase.resetDERParam2();
        pSUWCreateDEDERBase.resetDERParam3();
        pSUWCreateDEDERBase.resetDERParam4();
        pSUWCreateDEDERBase.resetNewPickupDEFName();
        pSUWCreateDEDERBase.resetPickupDEFName();
        pSUWCreateDEDERBase.resetPSDERId();
        pSUWCreateDEDERBase.resetPSDERName();
        pSUWCreateDEDERBase.resetPSDynaInstId();
        pSUWCreateDEDERBase.resetPSUWCreateDEDERId();
        pSUWCreateDEDERBase.resetPSUWCreateDEDERName();
        pSUWCreateDEDERBase.resetPSUWCreateDEId();
        pSUWCreateDEDERBase.resetUpdateDate();
        pSUWCreateDEDERBase.resetUpdateMan();
        pSUWCreateDEDERBase.resetWizardMode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDERParamDirty()) {
            hashMap.put(FIELD_DERPARAM, this.getDERParam());
        }
        if (!bl || this.isDERParam2Dirty()) {
            hashMap.put(FIELD_DERPARAM2, this.getDERParam2());
        }
        if (!bl || this.isDERParam3Dirty()) {
            hashMap.put(FIELD_DERPARAM3, this.getDERParam3());
        }
        if (!bl || this.isDERParam4Dirty()) {
            hashMap.put(FIELD_DERPARAM4, this.getDERParam4());
        }
        if (!bl || this.isNewPickupDEFNameDirty()) {
            hashMap.put(FIELD_NEWPICKUPDEFNAME, this.getNewPickupDEFName());
        }
        if (!bl || this.isPickupDEFNameDirty()) {
            hashMap.put(FIELD_PICKUPDEFNAME, this.getPickupDEFName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSUWCreateDEDERIdDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEDERID, this.getPSUWCreateDEDERId());
        }
        if (!bl || this.isPSUWCreateDEDERNameDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEDERNAME, this.getPSUWCreateDEDERName());
        }
        if (!bl || this.isPSUWCreateDEIdDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEID, this.getPSUWCreateDEId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWizardModeDirty()) {
            hashMap.put(FIELD_WIZARDMODE, this.getWizardMode());
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
        return PSUWCreateDEDERBase.get(this, n);
    }

    private static Object get(PSUWCreateDEDERBase pSUWCreateDEDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEDERBase.getCreateDate();
            }
            case 1: {
                return pSUWCreateDEDERBase.getCreateMan();
            }
            case 2: {
                return pSUWCreateDEDERBase.getDERParam();
            }
            case 3: {
                return pSUWCreateDEDERBase.getDERParam2();
            }
            case 4: {
                return pSUWCreateDEDERBase.getDERParam3();
            }
            case 5: {
                return pSUWCreateDEDERBase.getDERParam4();
            }
            case 6: {
                return pSUWCreateDEDERBase.getNewPickupDEFName();
            }
            case 7: {
                return pSUWCreateDEDERBase.getPickupDEFName();
            }
            case 8: {
                return pSUWCreateDEDERBase.getPSDERId();
            }
            case 9: {
                return pSUWCreateDEDERBase.getPSDERName();
            }
            case 10: {
                return pSUWCreateDEDERBase.getPSDynaInstId();
            }
            case 11: {
                return pSUWCreateDEDERBase.getPSUWCreateDEDERId();
            }
            case 12: {
                return pSUWCreateDEDERBase.getPSUWCreateDEDERName();
            }
            case 13: {
                return pSUWCreateDEDERBase.getPSUWCreateDEId();
            }
            case 14: {
                return pSUWCreateDEDERBase.getUpdateDate();
            }
            case 15: {
                return pSUWCreateDEDERBase.getUpdateMan();
            }
            case 16: {
                return pSUWCreateDEDERBase.getWizardMode();
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
        PSUWCreateDEDERBase.set(this, n, object);
    }

    private static void set(PSUWCreateDEDERBase pSUWCreateDEDERBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateDEDERBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUWCreateDEDERBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWCreateDEDERBase.setDERParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWCreateDEDERBase.setDERParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWCreateDEDERBase.setDERParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSUWCreateDEDERBase.setDERParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSUWCreateDEDERBase.setNewPickupDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWCreateDEDERBase.setPickupDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWCreateDEDERBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWCreateDEDERBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWCreateDEDERBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWCreateDEDERBase.setPSUWCreateDEDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWCreateDEDERBase.setPSUWCreateDEDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWCreateDEDERBase.setPSUWCreateDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWCreateDEDERBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSUWCreateDEDERBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWCreateDEDERBase.setWizardMode(DataObject.getStringValue((Object)object));
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
        return PSUWCreateDEDERBase.isNull(this, n);
    }

    private static boolean isNull(PSUWCreateDEDERBase pSUWCreateDEDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEDERBase.getCreateDate() == null;
            }
            case 1: {
                return pSUWCreateDEDERBase.getCreateMan() == null;
            }
            case 2: {
                return pSUWCreateDEDERBase.getDERParam() == null;
            }
            case 3: {
                return pSUWCreateDEDERBase.getDERParam2() == null;
            }
            case 4: {
                return pSUWCreateDEDERBase.getDERParam3() == null;
            }
            case 5: {
                return pSUWCreateDEDERBase.getDERParam4() == null;
            }
            case 6: {
                return pSUWCreateDEDERBase.getNewPickupDEFName() == null;
            }
            case 7: {
                return pSUWCreateDEDERBase.getPickupDEFName() == null;
            }
            case 8: {
                return pSUWCreateDEDERBase.getPSDERId() == null;
            }
            case 9: {
                return pSUWCreateDEDERBase.getPSDERName() == null;
            }
            case 10: {
                return pSUWCreateDEDERBase.getPSDynaInstId() == null;
            }
            case 11: {
                return pSUWCreateDEDERBase.getPSUWCreateDEDERId() == null;
            }
            case 12: {
                return pSUWCreateDEDERBase.getPSUWCreateDEDERName() == null;
            }
            case 13: {
                return pSUWCreateDEDERBase.getPSUWCreateDEId() == null;
            }
            case 14: {
                return pSUWCreateDEDERBase.getUpdateDate() == null;
            }
            case 15: {
                return pSUWCreateDEDERBase.getUpdateMan() == null;
            }
            case 16: {
                return pSUWCreateDEDERBase.getWizardMode() == null;
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
        return PSUWCreateDEDERBase.contains(this, n);
    }

    private static boolean contains(PSUWCreateDEDERBase pSUWCreateDEDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEDERBase.isCreateDateDirty();
            }
            case 1: {
                return pSUWCreateDEDERBase.isCreateManDirty();
            }
            case 2: {
                return pSUWCreateDEDERBase.isDERParamDirty();
            }
            case 3: {
                return pSUWCreateDEDERBase.isDERParam2Dirty();
            }
            case 4: {
                return pSUWCreateDEDERBase.isDERParam3Dirty();
            }
            case 5: {
                return pSUWCreateDEDERBase.isDERParam4Dirty();
            }
            case 6: {
                return pSUWCreateDEDERBase.isNewPickupDEFNameDirty();
            }
            case 7: {
                return pSUWCreateDEDERBase.isPickupDEFNameDirty();
            }
            case 8: {
                return pSUWCreateDEDERBase.isPSDERIdDirty();
            }
            case 9: {
                return pSUWCreateDEDERBase.isPSDERNameDirty();
            }
            case 10: {
                return pSUWCreateDEDERBase.isPSDynaInstIdDirty();
            }
            case 11: {
                return pSUWCreateDEDERBase.isPSUWCreateDEDERIdDirty();
            }
            case 12: {
                return pSUWCreateDEDERBase.isPSUWCreateDEDERNameDirty();
            }
            case 13: {
                return pSUWCreateDEDERBase.isPSUWCreateDEIdDirty();
            }
            case 14: {
                return pSUWCreateDEDERBase.isUpdateDateDirty();
            }
            case 15: {
                return pSUWCreateDEDERBase.isUpdateManDirty();
            }
            case 16: {
                return pSUWCreateDEDERBase.isWizardModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWCreateDEDERBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWCreateDEDERBase pSUWCreateDEDERBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWCreateDEDERBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getDERParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derparam", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getDERParam()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getDERParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derparam2", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getDERParam2()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getDERParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derparam3", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getDERParam3()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getDERParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derparam4", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getDERParam4()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getNewPickupDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newpickupdefname", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getNewPickupDEFName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getPickupDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickupdefname", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getPickupDEFName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getPSUWCreateDEDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatedederid", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getPSUWCreateDEDERId()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getPSUWCreateDEDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatededername", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getPSUWCreateDEDERName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getPSUWCreateDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatedeid", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getPSUWCreateDEId()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWCreateDEDERBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWCreateDEDERBase.getJSONValue((Object)pSUWCreateDEDERBase.getWizardMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWCreateDEDERBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWCreateDEDERBase pSUWCreateDEDERBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWCreateDEDERBase.getCreateDate() != null) {
            object = pSUWCreateDEDERBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateDEDERBase.getCreateMan() != null) {
            object = pSUWCreateDEDERBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getDERParam() != null) {
            object = pSUWCreateDEDERBase.getDERParam();
            xmlNode.setAttribute(FIELD_DERPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getDERParam2() != null) {
            object = pSUWCreateDEDERBase.getDERParam2();
            xmlNode.setAttribute(FIELD_DERPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getDERParam3() != null) {
            object = pSUWCreateDEDERBase.getDERParam3();
            xmlNode.setAttribute(FIELD_DERPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateDEDERBase.getDERParam4() != null) {
            object = pSUWCreateDEDERBase.getDERParam4();
            xmlNode.setAttribute(FIELD_DERPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateDEDERBase.getNewPickupDEFName() != null) {
            object = pSUWCreateDEDERBase.getNewPickupDEFName();
            xmlNode.setAttribute(FIELD_NEWPICKUPDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getPickupDEFName() != null) {
            object = pSUWCreateDEDERBase.getPickupDEFName();
            xmlNode.setAttribute(FIELD_PICKUPDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getPSDERId() != null) {
            object = pSUWCreateDEDERBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getPSDERName() != null) {
            object = pSUWCreateDEDERBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getPSDynaInstId() != null) {
            object = pSUWCreateDEDERBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getPSUWCreateDEDERId() != null) {
            object = pSUWCreateDEDERBase.getPSUWCreateDEDERId();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEDERID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getPSUWCreateDEDERName() != null) {
            object = pSUWCreateDEDERBase.getPSUWCreateDEDERName();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getPSUWCreateDEId() != null) {
            object = pSUWCreateDEDERBase.getPSUWCreateDEId();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getUpdateDate() != null) {
            object = pSUWCreateDEDERBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateDEDERBase.getUpdateMan() != null) {
            object = pSUWCreateDEDERBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDERBase.getWizardMode() != null) {
            object = pSUWCreateDEDERBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWCreateDEDERBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWCreateDEDERBase pSUWCreateDEDERBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWCreateDEDERBase.isCreateDateDirty() && (bl || pSUWCreateDEDERBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWCreateDEDERBase.getCreateDate());
        }
        if (pSUWCreateDEDERBase.isCreateManDirty() && (bl || pSUWCreateDEDERBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWCreateDEDERBase.getCreateMan());
        }
        if (pSUWCreateDEDERBase.isDERParamDirty() && (bl || pSUWCreateDEDERBase.getDERParam() != null)) {
            iDataObject.set(FIELD_DERPARAM, (Object)pSUWCreateDEDERBase.getDERParam());
        }
        if (pSUWCreateDEDERBase.isDERParam2Dirty() && (bl || pSUWCreateDEDERBase.getDERParam2() != null)) {
            iDataObject.set(FIELD_DERPARAM2, (Object)pSUWCreateDEDERBase.getDERParam2());
        }
        if (pSUWCreateDEDERBase.isDERParam3Dirty() && (bl || pSUWCreateDEDERBase.getDERParam3() != null)) {
            iDataObject.set(FIELD_DERPARAM3, (Object)pSUWCreateDEDERBase.getDERParam3());
        }
        if (pSUWCreateDEDERBase.isDERParam4Dirty() && (bl || pSUWCreateDEDERBase.getDERParam4() != null)) {
            iDataObject.set(FIELD_DERPARAM4, (Object)pSUWCreateDEDERBase.getDERParam4());
        }
        if (pSUWCreateDEDERBase.isNewPickupDEFNameDirty() && (bl || pSUWCreateDEDERBase.getNewPickupDEFName() != null)) {
            iDataObject.set(FIELD_NEWPICKUPDEFNAME, (Object)pSUWCreateDEDERBase.getNewPickupDEFName());
        }
        if (pSUWCreateDEDERBase.isPickupDEFNameDirty() && (bl || pSUWCreateDEDERBase.getPickupDEFName() != null)) {
            iDataObject.set(FIELD_PICKUPDEFNAME, (Object)pSUWCreateDEDERBase.getPickupDEFName());
        }
        if (pSUWCreateDEDERBase.isPSDERIdDirty() && (bl || pSUWCreateDEDERBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSUWCreateDEDERBase.getPSDERId());
        }
        if (pSUWCreateDEDERBase.isPSDERNameDirty() && (bl || pSUWCreateDEDERBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSUWCreateDEDERBase.getPSDERName());
        }
        if (pSUWCreateDEDERBase.isPSDynaInstIdDirty() && (bl || pSUWCreateDEDERBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWCreateDEDERBase.getPSDynaInstId());
        }
        if (pSUWCreateDEDERBase.isPSUWCreateDEDERIdDirty() && (bl || pSUWCreateDEDERBase.getPSUWCreateDEDERId() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEDERID, (Object)pSUWCreateDEDERBase.getPSUWCreateDEDERId());
        }
        if (pSUWCreateDEDERBase.isPSUWCreateDEDERNameDirty() && (bl || pSUWCreateDEDERBase.getPSUWCreateDEDERName() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEDERNAME, (Object)pSUWCreateDEDERBase.getPSUWCreateDEDERName());
        }
        if (pSUWCreateDEDERBase.isPSUWCreateDEIdDirty() && (bl || pSUWCreateDEDERBase.getPSUWCreateDEId() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEID, (Object)pSUWCreateDEDERBase.getPSUWCreateDEId());
        }
        if (pSUWCreateDEDERBase.isUpdateDateDirty() && (bl || pSUWCreateDEDERBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWCreateDEDERBase.getUpdateDate());
        }
        if (pSUWCreateDEDERBase.isUpdateManDirty() && (bl || pSUWCreateDEDERBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWCreateDEDERBase.getUpdateMan());
        }
        if (pSUWCreateDEDERBase.isWizardModeDirty() && (bl || pSUWCreateDEDERBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWCreateDEDERBase.getWizardMode());
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
        return PSUWCreateDEDERBase.remove(this, n);
    }

    private static boolean remove(PSUWCreateDEDERBase pSUWCreateDEDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateDEDERBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUWCreateDEDERBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUWCreateDEDERBase.resetDERParam();
                return true;
            }
            case 3: {
                pSUWCreateDEDERBase.resetDERParam2();
                return true;
            }
            case 4: {
                pSUWCreateDEDERBase.resetDERParam3();
                return true;
            }
            case 5: {
                pSUWCreateDEDERBase.resetDERParam4();
                return true;
            }
            case 6: {
                pSUWCreateDEDERBase.resetNewPickupDEFName();
                return true;
            }
            case 7: {
                pSUWCreateDEDERBase.resetPickupDEFName();
                return true;
            }
            case 8: {
                pSUWCreateDEDERBase.resetPSDERId();
                return true;
            }
            case 9: {
                pSUWCreateDEDERBase.resetPSDERName();
                return true;
            }
            case 10: {
                pSUWCreateDEDERBase.resetPSDynaInstId();
                return true;
            }
            case 11: {
                pSUWCreateDEDERBase.resetPSUWCreateDEDERId();
                return true;
            }
            case 12: {
                pSUWCreateDEDERBase.resetPSUWCreateDEDERName();
                return true;
            }
            case 13: {
                pSUWCreateDEDERBase.resetPSUWCreateDEId();
                return true;
            }
            case 14: {
                pSUWCreateDEDERBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSUWCreateDEDERBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSUWCreateDEDERBase.resetWizardMode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWCreateDEDERBase getProxyEntity() {
        return this.proxyPSUWCreateDEDERBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWCreateDEDERBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWCreateDEDERBase) {
            this.proxyPSUWCreateDEDERBase = (PSUWCreateDEDERBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEDERService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DERPARAM, 2);
        fieldIndexMap.put(FIELD_DERPARAM2, 3);
        fieldIndexMap.put(FIELD_DERPARAM3, 4);
        fieldIndexMap.put(FIELD_DERPARAM4, 5);
        fieldIndexMap.put(FIELD_NEWPICKUPDEFNAME, 6);
        fieldIndexMap.put(FIELD_PICKUPDEFNAME, 7);
        fieldIndexMap.put(FIELD_PSDERID, 8);
        fieldIndexMap.put(FIELD_PSDERNAME, 9);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 10);
        fieldIndexMap.put(FIELD_PSUWCREATEDEDERID, 11);
        fieldIndexMap.put(FIELD_PSUWCREATEDEDERNAME, 12);
        fieldIndexMap.put(FIELD_PSUWCREATEDEID, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_WIZARDMODE, 16);
    }
}

