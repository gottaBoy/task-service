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

public abstract class PSUWCreateDEDEFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWCreateDEDEFBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFPARAM = "DEFPARAM";
    public static final String FIELD_DEFPARAM2 = "DEFPARAM2";
    public static final String FIELD_DEFPARAM3 = "DEFPARAM3";
    public static final String FIELD_DEFPARAM4 = "DEFPARAM4";
    public static final String FIELD_NEWCODENAME = "NEWCODENAME";
    public static final String FIELD_NEWDEFLOGICNAME = "NEWDEFLOGICNAME";
    public static final String FIELD_NEWDEFNAME = "NEWDEFNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSUWCREATEDEDEFID = "PSUWCREATEDEDEFID";
    public static final String FIELD_PSUWCREATEDEDEFNAME = "PSUWCREATEDEDEFNAME";
    public static final String FIELD_PSUWCREATEDEID = "PSUWCREATEDEID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFPARAM = 3;
    private static final int INDEX_DEFPARAM2 = 4;
    private static final int INDEX_DEFPARAM3 = 5;
    private static final int INDEX_DEFPARAM4 = 6;
    private static final int INDEX_NEWCODENAME = 7;
    private static final int INDEX_NEWDEFLOGICNAME = 8;
    private static final int INDEX_NEWDEFNAME = 9;
    private static final int INDEX_PSDEFID = 10;
    private static final int INDEX_PSDEFNAME = 11;
    private static final int INDEX_PSDYNAINSTID = 12;
    private static final int INDEX_PSUWCREATEDEDEFID = 13;
    private static final int INDEX_PSUWCREATEDEDEFNAME = 14;
    private static final int INDEX_PSUWCREATEDEID = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_WIZARDMODE = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWCreateDEDEFBase proxyPSUWCreateDEDEFBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defparamDirtyFlag = false;
    private boolean defparam2DirtyFlag = false;
    private boolean defparam3DirtyFlag = false;
    private boolean defparam4DirtyFlag = false;
    private boolean newcodenameDirtyFlag = false;
    private boolean newdeflogicnameDirtyFlag = false;
    private boolean newdefnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psuwcreatededefidDirtyFlag = false;
    private boolean psuwcreatededefnameDirtyFlag = false;
    private boolean psuwcreatedeidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defparam")
    private String defparam;
    @Column(name="defparam2")
    private String defparam2;
    @Column(name="defparam3")
    private Integer defparam3;
    @Column(name="defparam4")
    private Integer defparam4;
    @Column(name="newcodename")
    private String newcodename;
    @Column(name="newdeflogicname")
    private String newdeflogicname;
    @Column(name="newdefname")
    private String newdefname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psuwcreatededefid")
    private String psuwcreatededefid;
    @Column(name="psuwcreatededefname")
    private String psuwcreatededefname;
    @Column(name="psuwcreatedeid")
    private String psuwcreatedeid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wizardmode")
    private String wizardmode;

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

    public void setDEFParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defparam = string;
        this.defparamDirtyFlag = true;
    }

    public String getDEFParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFParam();
        }
        return this.defparam;
    }

    public boolean isDEFParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFParamDirty();
        }
        return this.defparamDirtyFlag;
    }

    public void resetDEFParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFParam();
            return;
        }
        this.defparamDirtyFlag = false;
        this.defparam = null;
    }

    public void setDEFParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defparam2 = string;
        this.defparam2DirtyFlag = true;
    }

    public String getDEFParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFParam2();
        }
        return this.defparam2;
    }

    public boolean isDEFParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFParam2Dirty();
        }
        return this.defparam2DirtyFlag;
    }

    public void resetDEFParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFParam2();
            return;
        }
        this.defparam2DirtyFlag = false;
        this.defparam2 = null;
    }

    public void setDEFParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFParam3(n);
            return;
        }
        this.defparam3 = n;
        this.defparam3DirtyFlag = true;
    }

    public Integer getDEFParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFParam3();
        }
        return this.defparam3;
    }

    public boolean isDEFParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFParam3Dirty();
        }
        return this.defparam3DirtyFlag;
    }

    public void resetDEFParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFParam3();
            return;
        }
        this.defparam3DirtyFlag = false;
        this.defparam3 = null;
    }

    public void setDEFParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFParam4(n);
            return;
        }
        this.defparam4 = n;
        this.defparam4DirtyFlag = true;
    }

    public Integer getDEFParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFParam4();
        }
        return this.defparam4;
    }

    public boolean isDEFParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFParam4Dirty();
        }
        return this.defparam4DirtyFlag;
    }

    public void resetDEFParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFParam4();
            return;
        }
        this.defparam4DirtyFlag = false;
        this.defparam4 = null;
    }

    public void setNewCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newcodename = string;
        this.newcodenameDirtyFlag = true;
    }

    public String getNewCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewCodeName();
        }
        return this.newcodename;
    }

    public boolean isNewCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewCodeNameDirty();
        }
        return this.newcodenameDirtyFlag;
    }

    public void resetNewCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewCodeName();
            return;
        }
        this.newcodenameDirtyFlag = false;
        this.newcodename = null;
    }

    public void setNewDEFLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewDEFLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newdeflogicname = string;
        this.newdeflogicnameDirtyFlag = true;
    }

    public String getNewDEFLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewDEFLogicName();
        }
        return this.newdeflogicname;
    }

    public boolean isNewDEFLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewDEFLogicNameDirty();
        }
        return this.newdeflogicnameDirtyFlag;
    }

    public void resetNewDEFLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewDEFLogicName();
            return;
        }
        this.newdeflogicnameDirtyFlag = false;
        this.newdeflogicname = null;
    }

    public void setNewDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newdefname = string;
        this.newdefnameDirtyFlag = true;
    }

    public String getNewDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewDEFName();
        }
        return this.newdefname;
    }

    public boolean isNewDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewDEFNameDirty();
        }
        return this.newdefnameDirtyFlag;
    }

    public void resetNewDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewDEFName();
            return;
        }
        this.newdefnameDirtyFlag = false;
        this.newdefname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSUWCreateDEDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatededefid = string;
        this.psuwcreatededefidDirtyFlag = true;
    }

    public String getPSUWCreateDEDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEDEFId();
        }
        return this.psuwcreatededefid;
    }

    public boolean isPSUWCreateDEDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEDEFIdDirty();
        }
        return this.psuwcreatededefidDirtyFlag;
    }

    public void resetPSUWCreateDEDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEDEFId();
            return;
        }
        this.psuwcreatededefidDirtyFlag = false;
        this.psuwcreatededefid = null;
    }

    public void setPSUWCreateDEDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatededefname = string;
        this.psuwcreatededefnameDirtyFlag = true;
    }

    public String getPSUWCreateDEDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEDEFName();
        }
        return this.psuwcreatededefname;
    }

    public boolean isPSUWCreateDEDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEDEFNameDirty();
        }
        return this.psuwcreatededefnameDirtyFlag;
    }

    public void resetPSUWCreateDEDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEDEFName();
            return;
        }
        this.psuwcreatededefnameDirtyFlag = false;
        this.psuwcreatededefname = null;
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
        PSUWCreateDEDEFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWCreateDEDEFBase pSUWCreateDEDEFBase) {
        pSUWCreateDEDEFBase.resetCodeName();
        pSUWCreateDEDEFBase.resetCreateDate();
        pSUWCreateDEDEFBase.resetCreateMan();
        pSUWCreateDEDEFBase.resetDEFParam();
        pSUWCreateDEDEFBase.resetDEFParam2();
        pSUWCreateDEDEFBase.resetDEFParam3();
        pSUWCreateDEDEFBase.resetDEFParam4();
        pSUWCreateDEDEFBase.resetNewCodeName();
        pSUWCreateDEDEFBase.resetNewDEFLogicName();
        pSUWCreateDEDEFBase.resetNewDEFName();
        pSUWCreateDEDEFBase.resetPSDEFId();
        pSUWCreateDEDEFBase.resetPSDEFName();
        pSUWCreateDEDEFBase.resetPSDynaInstId();
        pSUWCreateDEDEFBase.resetPSUWCreateDEDEFId();
        pSUWCreateDEDEFBase.resetPSUWCreateDEDEFName();
        pSUWCreateDEDEFBase.resetPSUWCreateDEId();
        pSUWCreateDEDEFBase.resetUpdateDate();
        pSUWCreateDEDEFBase.resetUpdateMan();
        pSUWCreateDEDEFBase.resetWizardMode();
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
        if (!bl || this.isDEFParamDirty()) {
            hashMap.put(FIELD_DEFPARAM, this.getDEFParam());
        }
        if (!bl || this.isDEFParam2Dirty()) {
            hashMap.put(FIELD_DEFPARAM2, this.getDEFParam2());
        }
        if (!bl || this.isDEFParam3Dirty()) {
            hashMap.put(FIELD_DEFPARAM3, this.getDEFParam3());
        }
        if (!bl || this.isDEFParam4Dirty()) {
            hashMap.put(FIELD_DEFPARAM4, this.getDEFParam4());
        }
        if (!bl || this.isNewCodeNameDirty()) {
            hashMap.put(FIELD_NEWCODENAME, this.getNewCodeName());
        }
        if (!bl || this.isNewDEFLogicNameDirty()) {
            hashMap.put(FIELD_NEWDEFLOGICNAME, this.getNewDEFLogicName());
        }
        if (!bl || this.isNewDEFNameDirty()) {
            hashMap.put(FIELD_NEWDEFNAME, this.getNewDEFName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSUWCreateDEDEFIdDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEDEFID, this.getPSUWCreateDEDEFId());
        }
        if (!bl || this.isPSUWCreateDEDEFNameDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEDEFNAME, this.getPSUWCreateDEDEFName());
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
        return PSUWCreateDEDEFBase.get(this, n);
    }

    private static Object get(PSUWCreateDEDEFBase pSUWCreateDEDEFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEDEFBase.getCodeName();
            }
            case 1: {
                return pSUWCreateDEDEFBase.getCreateDate();
            }
            case 2: {
                return pSUWCreateDEDEFBase.getCreateMan();
            }
            case 3: {
                return pSUWCreateDEDEFBase.getDEFParam();
            }
            case 4: {
                return pSUWCreateDEDEFBase.getDEFParam2();
            }
            case 5: {
                return pSUWCreateDEDEFBase.getDEFParam3();
            }
            case 6: {
                return pSUWCreateDEDEFBase.getDEFParam4();
            }
            case 7: {
                return pSUWCreateDEDEFBase.getNewCodeName();
            }
            case 8: {
                return pSUWCreateDEDEFBase.getNewDEFLogicName();
            }
            case 9: {
                return pSUWCreateDEDEFBase.getNewDEFName();
            }
            case 10: {
                return pSUWCreateDEDEFBase.getPSDEFId();
            }
            case 11: {
                return pSUWCreateDEDEFBase.getPSDEFName();
            }
            case 12: {
                return pSUWCreateDEDEFBase.getPSDynaInstId();
            }
            case 13: {
                return pSUWCreateDEDEFBase.getPSUWCreateDEDEFId();
            }
            case 14: {
                return pSUWCreateDEDEFBase.getPSUWCreateDEDEFName();
            }
            case 15: {
                return pSUWCreateDEDEFBase.getPSUWCreateDEId();
            }
            case 16: {
                return pSUWCreateDEDEFBase.getUpdateDate();
            }
            case 17: {
                return pSUWCreateDEDEFBase.getUpdateMan();
            }
            case 18: {
                return pSUWCreateDEDEFBase.getWizardMode();
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
        PSUWCreateDEDEFBase.set(this, n, object);
    }

    private static void set(PSUWCreateDEDEFBase pSUWCreateDEDEFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateDEDEFBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWCreateDEDEFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSUWCreateDEDEFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWCreateDEDEFBase.setDEFParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWCreateDEDEFBase.setDEFParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWCreateDEDEFBase.setDEFParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSUWCreateDEDEFBase.setDEFParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSUWCreateDEDEFBase.setNewCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWCreateDEDEFBase.setNewDEFLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWCreateDEDEFBase.setNewDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWCreateDEDEFBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWCreateDEDEFBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWCreateDEDEFBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWCreateDEDEFBase.setPSUWCreateDEDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWCreateDEDEFBase.setPSUWCreateDEDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWCreateDEDEFBase.setPSUWCreateDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWCreateDEDEFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSUWCreateDEDEFBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWCreateDEDEFBase.setWizardMode(DataObject.getStringValue((Object)object));
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
        return PSUWCreateDEDEFBase.isNull(this, n);
    }

    private static boolean isNull(PSUWCreateDEDEFBase pSUWCreateDEDEFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEDEFBase.getCodeName() == null;
            }
            case 1: {
                return pSUWCreateDEDEFBase.getCreateDate() == null;
            }
            case 2: {
                return pSUWCreateDEDEFBase.getCreateMan() == null;
            }
            case 3: {
                return pSUWCreateDEDEFBase.getDEFParam() == null;
            }
            case 4: {
                return pSUWCreateDEDEFBase.getDEFParam2() == null;
            }
            case 5: {
                return pSUWCreateDEDEFBase.getDEFParam3() == null;
            }
            case 6: {
                return pSUWCreateDEDEFBase.getDEFParam4() == null;
            }
            case 7: {
                return pSUWCreateDEDEFBase.getNewCodeName() == null;
            }
            case 8: {
                return pSUWCreateDEDEFBase.getNewDEFLogicName() == null;
            }
            case 9: {
                return pSUWCreateDEDEFBase.getNewDEFName() == null;
            }
            case 10: {
                return pSUWCreateDEDEFBase.getPSDEFId() == null;
            }
            case 11: {
                return pSUWCreateDEDEFBase.getPSDEFName() == null;
            }
            case 12: {
                return pSUWCreateDEDEFBase.getPSDynaInstId() == null;
            }
            case 13: {
                return pSUWCreateDEDEFBase.getPSUWCreateDEDEFId() == null;
            }
            case 14: {
                return pSUWCreateDEDEFBase.getPSUWCreateDEDEFName() == null;
            }
            case 15: {
                return pSUWCreateDEDEFBase.getPSUWCreateDEId() == null;
            }
            case 16: {
                return pSUWCreateDEDEFBase.getUpdateDate() == null;
            }
            case 17: {
                return pSUWCreateDEDEFBase.getUpdateMan() == null;
            }
            case 18: {
                return pSUWCreateDEDEFBase.getWizardMode() == null;
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
        return PSUWCreateDEDEFBase.contains(this, n);
    }

    private static boolean contains(PSUWCreateDEDEFBase pSUWCreateDEDEFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEDEFBase.isCodeNameDirty();
            }
            case 1: {
                return pSUWCreateDEDEFBase.isCreateDateDirty();
            }
            case 2: {
                return pSUWCreateDEDEFBase.isCreateManDirty();
            }
            case 3: {
                return pSUWCreateDEDEFBase.isDEFParamDirty();
            }
            case 4: {
                return pSUWCreateDEDEFBase.isDEFParam2Dirty();
            }
            case 5: {
                return pSUWCreateDEDEFBase.isDEFParam3Dirty();
            }
            case 6: {
                return pSUWCreateDEDEFBase.isDEFParam4Dirty();
            }
            case 7: {
                return pSUWCreateDEDEFBase.isNewCodeNameDirty();
            }
            case 8: {
                return pSUWCreateDEDEFBase.isNewDEFLogicNameDirty();
            }
            case 9: {
                return pSUWCreateDEDEFBase.isNewDEFNameDirty();
            }
            case 10: {
                return pSUWCreateDEDEFBase.isPSDEFIdDirty();
            }
            case 11: {
                return pSUWCreateDEDEFBase.isPSDEFNameDirty();
            }
            case 12: {
                return pSUWCreateDEDEFBase.isPSDynaInstIdDirty();
            }
            case 13: {
                return pSUWCreateDEDEFBase.isPSUWCreateDEDEFIdDirty();
            }
            case 14: {
                return pSUWCreateDEDEFBase.isPSUWCreateDEDEFNameDirty();
            }
            case 15: {
                return pSUWCreateDEDEFBase.isPSUWCreateDEIdDirty();
            }
            case 16: {
                return pSUWCreateDEDEFBase.isUpdateDateDirty();
            }
            case 17: {
                return pSUWCreateDEDEFBase.isUpdateManDirty();
            }
            case 18: {
                return pSUWCreateDEDEFBase.isWizardModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWCreateDEDEFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWCreateDEDEFBase pSUWCreateDEDEFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWCreateDEDEFBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getCodeName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getDEFParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defparam", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getDEFParam()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getDEFParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defparam2", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getDEFParam2()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getDEFParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defparam3", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getDEFParam3()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getDEFParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defparam4", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getDEFParam4()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getNewCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newcodename", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getNewCodeName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getNewDEFLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newdeflogicname", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getNewDEFLogicName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getNewDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newdefname", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getNewDEFName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getPSUWCreateDEDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatededefid", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getPSUWCreateDEDEFId()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getPSUWCreateDEDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatededefname", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getPSUWCreateDEDEFName()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getPSUWCreateDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatedeid", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getPSUWCreateDEId()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWCreateDEDEFBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWCreateDEDEFBase.getJSONValue((Object)pSUWCreateDEDEFBase.getWizardMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWCreateDEDEFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWCreateDEDEFBase pSUWCreateDEDEFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWCreateDEDEFBase.getCodeName() != null) {
            object = pSUWCreateDEDEFBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getCreateDate() != null) {
            object = pSUWCreateDEDEFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateDEDEFBase.getCreateMan() != null) {
            object = pSUWCreateDEDEFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getDEFParam() != null) {
            object = pSUWCreateDEDEFBase.getDEFParam();
            xmlNode.setAttribute(FIELD_DEFPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getDEFParam2() != null) {
            object = pSUWCreateDEDEFBase.getDEFParam2();
            xmlNode.setAttribute(FIELD_DEFPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getDEFParam3() != null) {
            object = pSUWCreateDEDEFBase.getDEFParam3();
            xmlNode.setAttribute(FIELD_DEFPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateDEDEFBase.getDEFParam4() != null) {
            object = pSUWCreateDEDEFBase.getDEFParam4();
            xmlNode.setAttribute(FIELD_DEFPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateDEDEFBase.getNewCodeName() != null) {
            object = pSUWCreateDEDEFBase.getNewCodeName();
            xmlNode.setAttribute(FIELD_NEWCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getNewDEFLogicName() != null) {
            object = pSUWCreateDEDEFBase.getNewDEFLogicName();
            xmlNode.setAttribute(FIELD_NEWDEFLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getNewDEFName() != null) {
            object = pSUWCreateDEDEFBase.getNewDEFName();
            xmlNode.setAttribute(FIELD_NEWDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getPSDEFId() != null) {
            object = pSUWCreateDEDEFBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getPSDEFName() != null) {
            object = pSUWCreateDEDEFBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getPSDynaInstId() != null) {
            object = pSUWCreateDEDEFBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getPSUWCreateDEDEFId() != null) {
            object = pSUWCreateDEDEFBase.getPSUWCreateDEDEFId();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getPSUWCreateDEDEFName() != null) {
            object = pSUWCreateDEDEFBase.getPSUWCreateDEDEFName();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getPSUWCreateDEId() != null) {
            object = pSUWCreateDEDEFBase.getPSUWCreateDEId();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getUpdateDate() != null) {
            object = pSUWCreateDEDEFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateDEDEFBase.getUpdateMan() != null) {
            object = pSUWCreateDEDEFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEDEFBase.getWizardMode() != null) {
            object = pSUWCreateDEDEFBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWCreateDEDEFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWCreateDEDEFBase pSUWCreateDEDEFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWCreateDEDEFBase.isCodeNameDirty() && (bl || pSUWCreateDEDEFBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSUWCreateDEDEFBase.getCodeName());
        }
        if (pSUWCreateDEDEFBase.isCreateDateDirty() && (bl || pSUWCreateDEDEFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWCreateDEDEFBase.getCreateDate());
        }
        if (pSUWCreateDEDEFBase.isCreateManDirty() && (bl || pSUWCreateDEDEFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWCreateDEDEFBase.getCreateMan());
        }
        if (pSUWCreateDEDEFBase.isDEFParamDirty() && (bl || pSUWCreateDEDEFBase.getDEFParam() != null)) {
            iDataObject.set(FIELD_DEFPARAM, (Object)pSUWCreateDEDEFBase.getDEFParam());
        }
        if (pSUWCreateDEDEFBase.isDEFParam2Dirty() && (bl || pSUWCreateDEDEFBase.getDEFParam2() != null)) {
            iDataObject.set(FIELD_DEFPARAM2, (Object)pSUWCreateDEDEFBase.getDEFParam2());
        }
        if (pSUWCreateDEDEFBase.isDEFParam3Dirty() && (bl || pSUWCreateDEDEFBase.getDEFParam3() != null)) {
            iDataObject.set(FIELD_DEFPARAM3, (Object)pSUWCreateDEDEFBase.getDEFParam3());
        }
        if (pSUWCreateDEDEFBase.isDEFParam4Dirty() && (bl || pSUWCreateDEDEFBase.getDEFParam4() != null)) {
            iDataObject.set(FIELD_DEFPARAM4, (Object)pSUWCreateDEDEFBase.getDEFParam4());
        }
        if (pSUWCreateDEDEFBase.isNewCodeNameDirty() && (bl || pSUWCreateDEDEFBase.getNewCodeName() != null)) {
            iDataObject.set(FIELD_NEWCODENAME, (Object)pSUWCreateDEDEFBase.getNewCodeName());
        }
        if (pSUWCreateDEDEFBase.isNewDEFLogicNameDirty() && (bl || pSUWCreateDEDEFBase.getNewDEFLogicName() != null)) {
            iDataObject.set(FIELD_NEWDEFLOGICNAME, (Object)pSUWCreateDEDEFBase.getNewDEFLogicName());
        }
        if (pSUWCreateDEDEFBase.isNewDEFNameDirty() && (bl || pSUWCreateDEDEFBase.getNewDEFName() != null)) {
            iDataObject.set(FIELD_NEWDEFNAME, (Object)pSUWCreateDEDEFBase.getNewDEFName());
        }
        if (pSUWCreateDEDEFBase.isPSDEFIdDirty() && (bl || pSUWCreateDEDEFBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSUWCreateDEDEFBase.getPSDEFId());
        }
        if (pSUWCreateDEDEFBase.isPSDEFNameDirty() && (bl || pSUWCreateDEDEFBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSUWCreateDEDEFBase.getPSDEFName());
        }
        if (pSUWCreateDEDEFBase.isPSDynaInstIdDirty() && (bl || pSUWCreateDEDEFBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWCreateDEDEFBase.getPSDynaInstId());
        }
        if (pSUWCreateDEDEFBase.isPSUWCreateDEDEFIdDirty() && (bl || pSUWCreateDEDEFBase.getPSUWCreateDEDEFId() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEDEFID, (Object)pSUWCreateDEDEFBase.getPSUWCreateDEDEFId());
        }
        if (pSUWCreateDEDEFBase.isPSUWCreateDEDEFNameDirty() && (bl || pSUWCreateDEDEFBase.getPSUWCreateDEDEFName() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEDEFNAME, (Object)pSUWCreateDEDEFBase.getPSUWCreateDEDEFName());
        }
        if (pSUWCreateDEDEFBase.isPSUWCreateDEIdDirty() && (bl || pSUWCreateDEDEFBase.getPSUWCreateDEId() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEID, (Object)pSUWCreateDEDEFBase.getPSUWCreateDEId());
        }
        if (pSUWCreateDEDEFBase.isUpdateDateDirty() && (bl || pSUWCreateDEDEFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWCreateDEDEFBase.getUpdateDate());
        }
        if (pSUWCreateDEDEFBase.isUpdateManDirty() && (bl || pSUWCreateDEDEFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWCreateDEDEFBase.getUpdateMan());
        }
        if (pSUWCreateDEDEFBase.isWizardModeDirty() && (bl || pSUWCreateDEDEFBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWCreateDEDEFBase.getWizardMode());
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
        return PSUWCreateDEDEFBase.remove(this, n);
    }

    private static boolean remove(PSUWCreateDEDEFBase pSUWCreateDEDEFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateDEDEFBase.resetCodeName();
                return true;
            }
            case 1: {
                pSUWCreateDEDEFBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSUWCreateDEDEFBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSUWCreateDEDEFBase.resetDEFParam();
                return true;
            }
            case 4: {
                pSUWCreateDEDEFBase.resetDEFParam2();
                return true;
            }
            case 5: {
                pSUWCreateDEDEFBase.resetDEFParam3();
                return true;
            }
            case 6: {
                pSUWCreateDEDEFBase.resetDEFParam4();
                return true;
            }
            case 7: {
                pSUWCreateDEDEFBase.resetNewCodeName();
                return true;
            }
            case 8: {
                pSUWCreateDEDEFBase.resetNewDEFLogicName();
                return true;
            }
            case 9: {
                pSUWCreateDEDEFBase.resetNewDEFName();
                return true;
            }
            case 10: {
                pSUWCreateDEDEFBase.resetPSDEFId();
                return true;
            }
            case 11: {
                pSUWCreateDEDEFBase.resetPSDEFName();
                return true;
            }
            case 12: {
                pSUWCreateDEDEFBase.resetPSDynaInstId();
                return true;
            }
            case 13: {
                pSUWCreateDEDEFBase.resetPSUWCreateDEDEFId();
                return true;
            }
            case 14: {
                pSUWCreateDEDEFBase.resetPSUWCreateDEDEFName();
                return true;
            }
            case 15: {
                pSUWCreateDEDEFBase.resetPSUWCreateDEId();
                return true;
            }
            case 16: {
                pSUWCreateDEDEFBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSUWCreateDEDEFBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSUWCreateDEDEFBase.resetWizardMode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWCreateDEDEFBase getProxyEntity() {
        return this.proxyPSUWCreateDEDEFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWCreateDEDEFBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWCreateDEDEFBase) {
            this.proxyPSUWCreateDEDEFBase = (PSUWCreateDEDEFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEDEFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFPARAM, 3);
        fieldIndexMap.put(FIELD_DEFPARAM2, 4);
        fieldIndexMap.put(FIELD_DEFPARAM3, 5);
        fieldIndexMap.put(FIELD_DEFPARAM4, 6);
        fieldIndexMap.put(FIELD_NEWCODENAME, 7);
        fieldIndexMap.put(FIELD_NEWDEFLOGICNAME, 8);
        fieldIndexMap.put(FIELD_NEWDEFNAME, 9);
        fieldIndexMap.put(FIELD_PSDEFID, 10);
        fieldIndexMap.put(FIELD_PSDEFNAME, 11);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 12);
        fieldIndexMap.put(FIELD_PSUWCREATEDEDEFID, 13);
        fieldIndexMap.put(FIELD_PSUWCREATEDEDEFNAME, 14);
        fieldIndexMap.put(FIELD_PSUWCREATEDEID, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_WIZARDMODE, 18);
    }
}

