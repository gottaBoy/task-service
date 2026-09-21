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

public abstract class PSUAWizard2Base
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUAWizard2Base.class);
    public static final String FIELD_ACTIONDATA = "ACTIONDATA";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSUAWIZARD2ID = "PSUAWIZARD2ID";
    public static final String FIELD_PSUAWIZARD2NAME = "PSUAWIZARD2NAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    public static final String FIELD_WIZARDPARAM = "WIZARDPARAM";
    public static final String FIELD_WIZARDPARAM10 = "WIZARDPARAM10";
    public static final String FIELD_WIZARDPARAM11 = "WIZARDPARAM11";
    public static final String FIELD_WIZARDPARAM12 = "WIZARDPARAM12";
    public static final String FIELD_WIZARDPARAM13 = "WIZARDPARAM13";
    public static final String FIELD_WIZARDPARAM14 = "WIZARDPARAM14";
    public static final String FIELD_WIZARDPARAM15 = "WIZARDPARAM15";
    public static final String FIELD_WIZARDPARAM16 = "WIZARDPARAM16";
    public static final String FIELD_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String FIELD_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String FIELD_WIZARDPARAM4 = "WIZARDPARAM4";
    private static final int INDEX_ACTIONDATA = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_PARAM5 = 3;
    private static final int INDEX_PARAM6 = 4;
    private static final int INDEX_PARAM7 = 5;
    private static final int INDEX_PARAM8 = 6;
    private static final int INDEX_PSDSCONSOLEID = 7;
    private static final int INDEX_PSUAWIZARD2ID = 8;
    private static final int INDEX_PSUAWIZARD2NAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_WIZARDMODE = 12;
    private static final int INDEX_WIZARDPARAM = 13;
    private static final int INDEX_WIZARDPARAM10 = 14;
    private static final int INDEX_WIZARDPARAM11 = 15;
    private static final int INDEX_WIZARDPARAM12 = 16;
    private static final int INDEX_WIZARDPARAM13 = 17;
    private static final int INDEX_WIZARDPARAM14 = 18;
    private static final int INDEX_WIZARDPARAM15 = 19;
    private static final int INDEX_WIZARDPARAM16 = 20;
    private static final int INDEX_WIZARDPARAM2 = 21;
    private static final int INDEX_WIZARDPARAM3 = 22;
    private static final int INDEX_WIZARDPARAM4 = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUAWizard2Base proxyPSUAWizard2Base = null;
    private boolean actiondataDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psuawizard2idDirtyFlag = false;
    private boolean psuawizard2nameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    private boolean wizardparamDirtyFlag = false;
    private boolean wizardparam10DirtyFlag = false;
    private boolean wizardparam11DirtyFlag = false;
    private boolean wizardparam12DirtyFlag = false;
    private boolean wizardparam13DirtyFlag = false;
    private boolean wizardparam14DirtyFlag = false;
    private boolean wizardparam15DirtyFlag = false;
    private boolean wizardparam16DirtyFlag = false;
    private boolean wizardparam2DirtyFlag = false;
    private boolean wizardparam3DirtyFlag = false;
    private boolean wizardparam4DirtyFlag = false;
    @Column(name="actiondata")
    private String actiondata;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="param5")
    private String param5;
    @Column(name="param6")
    private String param6;
    @Column(name="param7")
    private String param7;
    @Column(name="param8")
    private String param8;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psuawizard2id")
    private String psuawizard2id;
    @Column(name="psuawizard2name")
    private String psuawizard2name;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wizardmode")
    private String wizardmode;
    @Column(name="wizardparam")
    private String wizardparam;
    @Column(name="wizardparam10")
    private Integer wizardparam10;
    @Column(name="wizardparam11")
    private Integer wizardparam11;
    @Column(name="wizardparam12")
    private Integer wizardparam12;
    @Column(name="wizardparam13")
    private Integer wizardparam13;
    @Column(name="wizardparam14")
    private Integer wizardparam14;
    @Column(name="wizardparam15")
    private Timestamp wizardparam15;
    @Column(name="wizardparam16")
    private Timestamp wizardparam16;
    @Column(name="wizardparam2")
    private String wizardparam2;
    @Column(name="wizardparam3")
    private String wizardparam3;
    @Column(name="wizardparam4")
    private String wizardparam4;

    public void setActionData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiondata = string;
        this.actiondataDirtyFlag = true;
    }

    public String getActionData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionData();
        }
        return this.actiondata;
    }

    public boolean isActionDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionDataDirty();
        }
        return this.actiondataDirtyFlag;
    }

    public void resetActionData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionData();
            return;
        }
        this.actiondataDirtyFlag = false;
        this.actiondata = null;
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

    public void setParam5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param5 = string;
        this.param5DirtyFlag = true;
    }

    public String getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param6 = string;
        this.param6DirtyFlag = true;
    }

    public String getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param7 = string;
        this.param7DirtyFlag = true;
    }

    public String getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param8 = string;
        this.param8DirtyFlag = true;
    }

    public String getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setPSDSConsoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSConsoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsconsoleid = string;
        this.psdsconsoleidDirtyFlag = true;
    }

    public String getPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSConsoleId();
        }
        return this.psdsconsoleid;
    }

    public boolean isPSDSConsoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSConsoleIdDirty();
        }
        return this.psdsconsoleidDirtyFlag;
    }

    public void resetPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSConsoleId();
            return;
        }
        this.psdsconsoleidDirtyFlag = false;
        this.psdsconsoleid = null;
    }

    public void setPSUAWizard2Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUAWizard2Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuawizard2id = string;
        this.psuawizard2idDirtyFlag = true;
    }

    public String getPSUAWizard2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUAWizard2Id();
        }
        return this.psuawizard2id;
    }

    public boolean isPSUAWizard2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUAWizard2IdDirty();
        }
        return this.psuawizard2idDirtyFlag;
    }

    public void resetPSUAWizard2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUAWizard2Id();
            return;
        }
        this.psuawizard2idDirtyFlag = false;
        this.psuawizard2id = null;
    }

    public void setPSUAWizard2Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUAWizard2Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuawizard2name = string;
        this.psuawizard2nameDirtyFlag = true;
    }

    public String getPSUAWizard2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUAWizard2Name();
        }
        return this.psuawizard2name;
    }

    public boolean isPSUAWizard2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUAWizard2NameDirty();
        }
        return this.psuawizard2nameDirtyFlag;
    }

    public void resetPSUAWizard2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUAWizard2Name();
            return;
        }
        this.psuawizard2nameDirtyFlag = false;
        this.psuawizard2name = null;
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

    public void setWizardParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam = string;
        this.wizardparamDirtyFlag = true;
    }

    public String getWizardParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam();
        }
        return this.wizardparam;
    }

    public boolean isWizardParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParamDirty();
        }
        return this.wizardparamDirtyFlag;
    }

    public void resetWizardParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam();
            return;
        }
        this.wizardparamDirtyFlag = false;
        this.wizardparam = null;
    }

    public void setWizardParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam10(n);
            return;
        }
        this.wizardparam10 = n;
        this.wizardparam10DirtyFlag = true;
    }

    public Integer getWizardParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam10();
        }
        return this.wizardparam10;
    }

    public boolean isWizardParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam10Dirty();
        }
        return this.wizardparam10DirtyFlag;
    }

    public void resetWizardParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam10();
            return;
        }
        this.wizardparam10DirtyFlag = false;
        this.wizardparam10 = null;
    }

    public void setWizardParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam11(n);
            return;
        }
        this.wizardparam11 = n;
        this.wizardparam11DirtyFlag = true;
    }

    public Integer getWizardParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam11();
        }
        return this.wizardparam11;
    }

    public boolean isWizardParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam11Dirty();
        }
        return this.wizardparam11DirtyFlag;
    }

    public void resetWizardParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam11();
            return;
        }
        this.wizardparam11DirtyFlag = false;
        this.wizardparam11 = null;
    }

    public void setWizardParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam12(n);
            return;
        }
        this.wizardparam12 = n;
        this.wizardparam12DirtyFlag = true;
    }

    public Integer getWizardParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam12();
        }
        return this.wizardparam12;
    }

    public boolean isWizardParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam12Dirty();
        }
        return this.wizardparam12DirtyFlag;
    }

    public void resetWizardParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam12();
            return;
        }
        this.wizardparam12DirtyFlag = false;
        this.wizardparam12 = null;
    }

    public void setWizardParam13(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam13(n);
            return;
        }
        this.wizardparam13 = n;
        this.wizardparam13DirtyFlag = true;
    }

    public Integer getWizardParam13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam13();
        }
        return this.wizardparam13;
    }

    public boolean isWizardParam13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam13Dirty();
        }
        return this.wizardparam13DirtyFlag;
    }

    public void resetWizardParam13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam13();
            return;
        }
        this.wizardparam13DirtyFlag = false;
        this.wizardparam13 = null;
    }

    public void setWizardParam14(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam14(n);
            return;
        }
        this.wizardparam14 = n;
        this.wizardparam14DirtyFlag = true;
    }

    public Integer getWizardParam14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam14();
        }
        return this.wizardparam14;
    }

    public boolean isWizardParam14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam14Dirty();
        }
        return this.wizardparam14DirtyFlag;
    }

    public void resetWizardParam14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam14();
            return;
        }
        this.wizardparam14DirtyFlag = false;
        this.wizardparam14 = null;
    }

    public void setWizardParam15(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam15(timestamp);
            return;
        }
        this.wizardparam15 = timestamp;
        this.wizardparam15DirtyFlag = true;
    }

    public Timestamp getWizardParam15() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam15();
        }
        return this.wizardparam15;
    }

    public boolean isWizardParam15Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam15Dirty();
        }
        return this.wizardparam15DirtyFlag;
    }

    public void resetWizardParam15() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam15();
            return;
        }
        this.wizardparam15DirtyFlag = false;
        this.wizardparam15 = null;
    }

    public void setWizardParam16(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam16(timestamp);
            return;
        }
        this.wizardparam16 = timestamp;
        this.wizardparam16DirtyFlag = true;
    }

    public Timestamp getWizardParam16() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam16();
        }
        return this.wizardparam16;
    }

    public boolean isWizardParam16Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam16Dirty();
        }
        return this.wizardparam16DirtyFlag;
    }

    public void resetWizardParam16() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam16();
            return;
        }
        this.wizardparam16DirtyFlag = false;
        this.wizardparam16 = null;
    }

    public void setWizardParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam2 = string;
        this.wizardparam2DirtyFlag = true;
    }

    public String getWizardParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam2();
        }
        return this.wizardparam2;
    }

    public boolean isWizardParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam2Dirty();
        }
        return this.wizardparam2DirtyFlag;
    }

    public void resetWizardParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam2();
            return;
        }
        this.wizardparam2DirtyFlag = false;
        this.wizardparam2 = null;
    }

    public void setWizardParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam3 = string;
        this.wizardparam3DirtyFlag = true;
    }

    public String getWizardParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam3();
        }
        return this.wizardparam3;
    }

    public boolean isWizardParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam3Dirty();
        }
        return this.wizardparam3DirtyFlag;
    }

    public void resetWizardParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam3();
            return;
        }
        this.wizardparam3DirtyFlag = false;
        this.wizardparam3 = null;
    }

    public void setWizardParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam4 = string;
        this.wizardparam4DirtyFlag = true;
    }

    public String getWizardParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam4();
        }
        return this.wizardparam4;
    }

    public boolean isWizardParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam4Dirty();
        }
        return this.wizardparam4DirtyFlag;
    }

    public void resetWizardParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam4();
            return;
        }
        this.wizardparam4DirtyFlag = false;
        this.wizardparam4 = null;
    }

    protected void onReset() {
        PSUAWizard2Base.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUAWizard2Base pSUAWizard2Base) {
        pSUAWizard2Base.resetActionData();
        pSUAWizard2Base.resetCreateDate();
        pSUAWizard2Base.resetCreateMan();
        pSUAWizard2Base.resetParam5();
        pSUAWizard2Base.resetParam6();
        pSUAWizard2Base.resetParam7();
        pSUAWizard2Base.resetParam8();
        pSUAWizard2Base.resetPSDSConsoleId();
        pSUAWizard2Base.resetPSUAWizard2Id();
        pSUAWizard2Base.resetPSUAWizard2Name();
        pSUAWizard2Base.resetUpdateDate();
        pSUAWizard2Base.resetUpdateMan();
        pSUAWizard2Base.resetWizardMode();
        pSUAWizard2Base.resetWizardParam();
        pSUAWizard2Base.resetWizardParam10();
        pSUAWizard2Base.resetWizardParam11();
        pSUAWizard2Base.resetWizardParam12();
        pSUAWizard2Base.resetWizardParam13();
        pSUAWizard2Base.resetWizardParam14();
        pSUAWizard2Base.resetWizardParam15();
        pSUAWizard2Base.resetWizardParam16();
        pSUAWizard2Base.resetWizardParam2();
        pSUAWizard2Base.resetWizardParam3();
        pSUAWizard2Base.resetWizardParam4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionDataDirty()) {
            hashMap.put(FIELD_ACTIONDATA, this.getActionData());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSUAWizard2IdDirty()) {
            hashMap.put(FIELD_PSUAWIZARD2ID, this.getPSUAWizard2Id());
        }
        if (!bl || this.isPSUAWizard2NameDirty()) {
            hashMap.put(FIELD_PSUAWIZARD2NAME, this.getPSUAWizard2Name());
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
        if (!bl || this.isWizardParamDirty()) {
            hashMap.put(FIELD_WIZARDPARAM, this.getWizardParam());
        }
        if (!bl || this.isWizardParam10Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM10, this.getWizardParam10());
        }
        if (!bl || this.isWizardParam11Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM11, this.getWizardParam11());
        }
        if (!bl || this.isWizardParam12Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM12, this.getWizardParam12());
        }
        if (!bl || this.isWizardParam13Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM13, this.getWizardParam13());
        }
        if (!bl || this.isWizardParam14Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM14, this.getWizardParam14());
        }
        if (!bl || this.isWizardParam15Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM15, this.getWizardParam15());
        }
        if (!bl || this.isWizardParam16Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM16, this.getWizardParam16());
        }
        if (!bl || this.isWizardParam2Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM2, this.getWizardParam2());
        }
        if (!bl || this.isWizardParam3Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM3, this.getWizardParam3());
        }
        if (!bl || this.isWizardParam4Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM4, this.getWizardParam4());
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
        return PSUAWizard2Base.get(this, n);
    }

    private static Object get(PSUAWizard2Base pSUAWizard2Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAWizard2Base.getActionData();
            }
            case 1: {
                return pSUAWizard2Base.getCreateDate();
            }
            case 2: {
                return pSUAWizard2Base.getCreateMan();
            }
            case 3: {
                return pSUAWizard2Base.getParam5();
            }
            case 4: {
                return pSUAWizard2Base.getParam6();
            }
            case 5: {
                return pSUAWizard2Base.getParam7();
            }
            case 6: {
                return pSUAWizard2Base.getParam8();
            }
            case 7: {
                return pSUAWizard2Base.getPSDSConsoleId();
            }
            case 8: {
                return pSUAWizard2Base.getPSUAWizard2Id();
            }
            case 9: {
                return pSUAWizard2Base.getPSUAWizard2Name();
            }
            case 10: {
                return pSUAWizard2Base.getUpdateDate();
            }
            case 11: {
                return pSUAWizard2Base.getUpdateMan();
            }
            case 12: {
                return pSUAWizard2Base.getWizardMode();
            }
            case 13: {
                return pSUAWizard2Base.getWizardParam();
            }
            case 14: {
                return pSUAWizard2Base.getWizardParam10();
            }
            case 15: {
                return pSUAWizard2Base.getWizardParam11();
            }
            case 16: {
                return pSUAWizard2Base.getWizardParam12();
            }
            case 17: {
                return pSUAWizard2Base.getWizardParam13();
            }
            case 18: {
                return pSUAWizard2Base.getWizardParam14();
            }
            case 19: {
                return pSUAWizard2Base.getWizardParam15();
            }
            case 20: {
                return pSUAWizard2Base.getWizardParam16();
            }
            case 21: {
                return pSUAWizard2Base.getWizardParam2();
            }
            case 22: {
                return pSUAWizard2Base.getWizardParam3();
            }
            case 23: {
                return pSUAWizard2Base.getWizardParam4();
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
        PSUAWizard2Base.set(this, n, object);
    }

    private static void set(PSUAWizard2Base pSUAWizard2Base, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUAWizard2Base.setActionData(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUAWizard2Base.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSUAWizard2Base.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUAWizard2Base.setParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUAWizard2Base.setParam6(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUAWizard2Base.setParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUAWizard2Base.setParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUAWizard2Base.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUAWizard2Base.setPSUAWizard2Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUAWizard2Base.setPSUAWizard2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUAWizard2Base.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSUAWizard2Base.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUAWizard2Base.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUAWizard2Base.setWizardParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUAWizard2Base.setWizardParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSUAWizard2Base.setWizardParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSUAWizard2Base.setWizardParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSUAWizard2Base.setWizardParam13(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSUAWizard2Base.setWizardParam14(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSUAWizard2Base.setWizardParam15(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSUAWizard2Base.setWizardParam16(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSUAWizard2Base.setWizardParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUAWizard2Base.setWizardParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSUAWizard2Base.setWizardParam4(DataObject.getStringValue((Object)object));
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
        return PSUAWizard2Base.isNull(this, n);
    }

    private static boolean isNull(PSUAWizard2Base pSUAWizard2Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAWizard2Base.getActionData() == null;
            }
            case 1: {
                return pSUAWizard2Base.getCreateDate() == null;
            }
            case 2: {
                return pSUAWizard2Base.getCreateMan() == null;
            }
            case 3: {
                return pSUAWizard2Base.getParam5() == null;
            }
            case 4: {
                return pSUAWizard2Base.getParam6() == null;
            }
            case 5: {
                return pSUAWizard2Base.getParam7() == null;
            }
            case 6: {
                return pSUAWizard2Base.getParam8() == null;
            }
            case 7: {
                return pSUAWizard2Base.getPSDSConsoleId() == null;
            }
            case 8: {
                return pSUAWizard2Base.getPSUAWizard2Id() == null;
            }
            case 9: {
                return pSUAWizard2Base.getPSUAWizard2Name() == null;
            }
            case 10: {
                return pSUAWizard2Base.getUpdateDate() == null;
            }
            case 11: {
                return pSUAWizard2Base.getUpdateMan() == null;
            }
            case 12: {
                return pSUAWizard2Base.getWizardMode() == null;
            }
            case 13: {
                return pSUAWizard2Base.getWizardParam() == null;
            }
            case 14: {
                return pSUAWizard2Base.getWizardParam10() == null;
            }
            case 15: {
                return pSUAWizard2Base.getWizardParam11() == null;
            }
            case 16: {
                return pSUAWizard2Base.getWizardParam12() == null;
            }
            case 17: {
                return pSUAWizard2Base.getWizardParam13() == null;
            }
            case 18: {
                return pSUAWizard2Base.getWizardParam14() == null;
            }
            case 19: {
                return pSUAWizard2Base.getWizardParam15() == null;
            }
            case 20: {
                return pSUAWizard2Base.getWizardParam16() == null;
            }
            case 21: {
                return pSUAWizard2Base.getWizardParam2() == null;
            }
            case 22: {
                return pSUAWizard2Base.getWizardParam3() == null;
            }
            case 23: {
                return pSUAWizard2Base.getWizardParam4() == null;
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
        return PSUAWizard2Base.contains(this, n);
    }

    private static boolean contains(PSUAWizard2Base pSUAWizard2Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAWizard2Base.isActionDataDirty();
            }
            case 1: {
                return pSUAWizard2Base.isCreateDateDirty();
            }
            case 2: {
                return pSUAWizard2Base.isCreateManDirty();
            }
            case 3: {
                return pSUAWizard2Base.isParam5Dirty();
            }
            case 4: {
                return pSUAWizard2Base.isParam6Dirty();
            }
            case 5: {
                return pSUAWizard2Base.isParam7Dirty();
            }
            case 6: {
                return pSUAWizard2Base.isParam8Dirty();
            }
            case 7: {
                return pSUAWizard2Base.isPSDSConsoleIdDirty();
            }
            case 8: {
                return pSUAWizard2Base.isPSUAWizard2IdDirty();
            }
            case 9: {
                return pSUAWizard2Base.isPSUAWizard2NameDirty();
            }
            case 10: {
                return pSUAWizard2Base.isUpdateDateDirty();
            }
            case 11: {
                return pSUAWizard2Base.isUpdateManDirty();
            }
            case 12: {
                return pSUAWizard2Base.isWizardModeDirty();
            }
            case 13: {
                return pSUAWizard2Base.isWizardParamDirty();
            }
            case 14: {
                return pSUAWizard2Base.isWizardParam10Dirty();
            }
            case 15: {
                return pSUAWizard2Base.isWizardParam11Dirty();
            }
            case 16: {
                return pSUAWizard2Base.isWizardParam12Dirty();
            }
            case 17: {
                return pSUAWizard2Base.isWizardParam13Dirty();
            }
            case 18: {
                return pSUAWizard2Base.isWizardParam14Dirty();
            }
            case 19: {
                return pSUAWizard2Base.isWizardParam15Dirty();
            }
            case 20: {
                return pSUAWizard2Base.isWizardParam16Dirty();
            }
            case 21: {
                return pSUAWizard2Base.isWizardParam2Dirty();
            }
            case 22: {
                return pSUAWizard2Base.isWizardParam3Dirty();
            }
            case 23: {
                return pSUAWizard2Base.isWizardParam4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUAWizard2Base.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUAWizard2Base pSUAWizard2Base, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUAWizard2Base.getActionData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiondata", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getActionData()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getCreateDate()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getCreateMan()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getParam5()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getParam6()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getParam7()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getParam8()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getPSUAWizard2Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuawizard2id", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getPSUAWizard2Id()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getPSUAWizard2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuawizard2name", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getPSUAWizard2Name()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardMode()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam10", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam10()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam11", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam11()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam12", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam12()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam13", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam13()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam14", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam14()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam15() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam15", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam15()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam16() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam16", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam16()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam2()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam3()), (boolean)false);
        }
        if (bl || pSUAWizard2Base.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSUAWizard2Base.getJSONValue((Object)pSUAWizard2Base.getWizardParam4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUAWizard2Base.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUAWizard2Base pSUAWizard2Base, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUAWizard2Base.getActionData() != null) {
            object = pSUAWizard2Base.getActionData();
            xmlNode.setAttribute(FIELD_ACTIONDATA, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getCreateDate() != null) {
            object = pSUAWizard2Base.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUAWizard2Base.getCreateMan() != null) {
            object = pSUAWizard2Base.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getParam5() != null) {
            object = pSUAWizard2Base.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getParam6() != null) {
            object = pSUAWizard2Base.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getParam7() != null) {
            object = pSUAWizard2Base.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getParam8() != null) {
            object = pSUAWizard2Base.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getPSDSConsoleId() != null) {
            object = pSUAWizard2Base.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getPSUAWizard2Id() != null) {
            object = pSUAWizard2Base.getPSUAWizard2Id();
            xmlNode.setAttribute(FIELD_PSUAWIZARD2ID, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getPSUAWizard2Name() != null) {
            object = pSUAWizard2Base.getPSUAWizard2Name();
            xmlNode.setAttribute(FIELD_PSUAWIZARD2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getUpdateDate() != null) {
            object = pSUAWizard2Base.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUAWizard2Base.getUpdateMan() != null) {
            object = pSUAWizard2Base.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getWizardMode() != null) {
            object = pSUAWizard2Base.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getWizardParam() != null) {
            object = pSUAWizard2Base.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getWizardParam10() != null) {
            object = pSUAWizard2Base.getWizardParam10();
            xmlNode.setAttribute(FIELD_WIZARDPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard2Base.getWizardParam11() != null) {
            object = pSUAWizard2Base.getWizardParam11();
            xmlNode.setAttribute(FIELD_WIZARDPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard2Base.getWizardParam12() != null) {
            object = pSUAWizard2Base.getWizardParam12();
            xmlNode.setAttribute(FIELD_WIZARDPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard2Base.getWizardParam13() != null) {
            object = pSUAWizard2Base.getWizardParam13();
            xmlNode.setAttribute(FIELD_WIZARDPARAM13, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard2Base.getWizardParam14() != null) {
            object = pSUAWizard2Base.getWizardParam14();
            xmlNode.setAttribute(FIELD_WIZARDPARAM14, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard2Base.getWizardParam15() != null) {
            object = pSUAWizard2Base.getWizardParam15();
            xmlNode.setAttribute(FIELD_WIZARDPARAM15, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUAWizard2Base.getWizardParam16() != null) {
            object = pSUAWizard2Base.getWizardParam16();
            xmlNode.setAttribute(FIELD_WIZARDPARAM16, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUAWizard2Base.getWizardParam2() != null) {
            object = pSUAWizard2Base.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getWizardParam3() != null) {
            object = pSUAWizard2Base.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard2Base.getWizardParam4() != null) {
            object = pSUAWizard2Base.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUAWizard2Base.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUAWizard2Base pSUAWizard2Base, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUAWizard2Base.isActionDataDirty() && (bl || pSUAWizard2Base.getActionData() != null)) {
            iDataObject.set(FIELD_ACTIONDATA, (Object)pSUAWizard2Base.getActionData());
        }
        if (pSUAWizard2Base.isCreateDateDirty() && (bl || pSUAWizard2Base.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUAWizard2Base.getCreateDate());
        }
        if (pSUAWizard2Base.isCreateManDirty() && (bl || pSUAWizard2Base.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUAWizard2Base.getCreateMan());
        }
        if (pSUAWizard2Base.isParam5Dirty() && (bl || pSUAWizard2Base.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSUAWizard2Base.getParam5());
        }
        if (pSUAWizard2Base.isParam6Dirty() && (bl || pSUAWizard2Base.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSUAWizard2Base.getParam6());
        }
        if (pSUAWizard2Base.isParam7Dirty() && (bl || pSUAWizard2Base.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSUAWizard2Base.getParam7());
        }
        if (pSUAWizard2Base.isParam8Dirty() && (bl || pSUAWizard2Base.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSUAWizard2Base.getParam8());
        }
        if (pSUAWizard2Base.isPSDSConsoleIdDirty() && (bl || pSUAWizard2Base.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSUAWizard2Base.getPSDSConsoleId());
        }
        if (pSUAWizard2Base.isPSUAWizard2IdDirty() && (bl || pSUAWizard2Base.getPSUAWizard2Id() != null)) {
            iDataObject.set(FIELD_PSUAWIZARD2ID, (Object)pSUAWizard2Base.getPSUAWizard2Id());
        }
        if (pSUAWizard2Base.isPSUAWizard2NameDirty() && (bl || pSUAWizard2Base.getPSUAWizard2Name() != null)) {
            iDataObject.set(FIELD_PSUAWIZARD2NAME, (Object)pSUAWizard2Base.getPSUAWizard2Name());
        }
        if (pSUAWizard2Base.isUpdateDateDirty() && (bl || pSUAWizard2Base.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUAWizard2Base.getUpdateDate());
        }
        if (pSUAWizard2Base.isUpdateManDirty() && (bl || pSUAWizard2Base.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUAWizard2Base.getUpdateMan());
        }
        if (pSUAWizard2Base.isWizardModeDirty() && (bl || pSUAWizard2Base.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUAWizard2Base.getWizardMode());
        }
        if (pSUAWizard2Base.isWizardParamDirty() && (bl || pSUAWizard2Base.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSUAWizard2Base.getWizardParam());
        }
        if (pSUAWizard2Base.isWizardParam10Dirty() && (bl || pSUAWizard2Base.getWizardParam10() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM10, (Object)pSUAWizard2Base.getWizardParam10());
        }
        if (pSUAWizard2Base.isWizardParam11Dirty() && (bl || pSUAWizard2Base.getWizardParam11() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM11, (Object)pSUAWizard2Base.getWizardParam11());
        }
        if (pSUAWizard2Base.isWizardParam12Dirty() && (bl || pSUAWizard2Base.getWizardParam12() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM12, (Object)pSUAWizard2Base.getWizardParam12());
        }
        if (pSUAWizard2Base.isWizardParam13Dirty() && (bl || pSUAWizard2Base.getWizardParam13() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM13, (Object)pSUAWizard2Base.getWizardParam13());
        }
        if (pSUAWizard2Base.isWizardParam14Dirty() && (bl || pSUAWizard2Base.getWizardParam14() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM14, (Object)pSUAWizard2Base.getWizardParam14());
        }
        if (pSUAWizard2Base.isWizardParam15Dirty() && (bl || pSUAWizard2Base.getWizardParam15() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM15, (Object)pSUAWizard2Base.getWizardParam15());
        }
        if (pSUAWizard2Base.isWizardParam16Dirty() && (bl || pSUAWizard2Base.getWizardParam16() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM16, (Object)pSUAWizard2Base.getWizardParam16());
        }
        if (pSUAWizard2Base.isWizardParam2Dirty() && (bl || pSUAWizard2Base.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSUAWizard2Base.getWizardParam2());
        }
        if (pSUAWizard2Base.isWizardParam3Dirty() && (bl || pSUAWizard2Base.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSUAWizard2Base.getWizardParam3());
        }
        if (pSUAWizard2Base.isWizardParam4Dirty() && (bl || pSUAWizard2Base.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSUAWizard2Base.getWizardParam4());
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
        return PSUAWizard2Base.remove(this, n);
    }

    private static boolean remove(PSUAWizard2Base pSUAWizard2Base, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUAWizard2Base.resetActionData();
                return true;
            }
            case 1: {
                pSUAWizard2Base.resetCreateDate();
                return true;
            }
            case 2: {
                pSUAWizard2Base.resetCreateMan();
                return true;
            }
            case 3: {
                pSUAWizard2Base.resetParam5();
                return true;
            }
            case 4: {
                pSUAWizard2Base.resetParam6();
                return true;
            }
            case 5: {
                pSUAWizard2Base.resetParam7();
                return true;
            }
            case 6: {
                pSUAWizard2Base.resetParam8();
                return true;
            }
            case 7: {
                pSUAWizard2Base.resetPSDSConsoleId();
                return true;
            }
            case 8: {
                pSUAWizard2Base.resetPSUAWizard2Id();
                return true;
            }
            case 9: {
                pSUAWizard2Base.resetPSUAWizard2Name();
                return true;
            }
            case 10: {
                pSUAWizard2Base.resetUpdateDate();
                return true;
            }
            case 11: {
                pSUAWizard2Base.resetUpdateMan();
                return true;
            }
            case 12: {
                pSUAWizard2Base.resetWizardMode();
                return true;
            }
            case 13: {
                pSUAWizard2Base.resetWizardParam();
                return true;
            }
            case 14: {
                pSUAWizard2Base.resetWizardParam10();
                return true;
            }
            case 15: {
                pSUAWizard2Base.resetWizardParam11();
                return true;
            }
            case 16: {
                pSUAWizard2Base.resetWizardParam12();
                return true;
            }
            case 17: {
                pSUAWizard2Base.resetWizardParam13();
                return true;
            }
            case 18: {
                pSUAWizard2Base.resetWizardParam14();
                return true;
            }
            case 19: {
                pSUAWizard2Base.resetWizardParam15();
                return true;
            }
            case 20: {
                pSUAWizard2Base.resetWizardParam16();
                return true;
            }
            case 21: {
                pSUAWizard2Base.resetWizardParam2();
                return true;
            }
            case 22: {
                pSUAWizard2Base.resetWizardParam3();
                return true;
            }
            case 23: {
                pSUAWizard2Base.resetWizardParam4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUAWizard2Base getProxyEntity() {
        return this.proxyPSUAWizard2Base;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUAWizard2Base = null;
        if (iDataObject != null && iDataObject instanceof PSUAWizard2Base) {
            this.proxyPSUAWizard2Base = (PSUAWizard2Base)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUAWizard2Service", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONDATA, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_PARAM5, 3);
        fieldIndexMap.put(FIELD_PARAM6, 4);
        fieldIndexMap.put(FIELD_PARAM7, 5);
        fieldIndexMap.put(FIELD_PARAM8, 6);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 7);
        fieldIndexMap.put(FIELD_PSUAWIZARD2ID, 8);
        fieldIndexMap.put(FIELD_PSUAWIZARD2NAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_WIZARDMODE, 12);
        fieldIndexMap.put(FIELD_WIZARDPARAM, 13);
        fieldIndexMap.put(FIELD_WIZARDPARAM10, 14);
        fieldIndexMap.put(FIELD_WIZARDPARAM11, 15);
        fieldIndexMap.put(FIELD_WIZARDPARAM12, 16);
        fieldIndexMap.put(FIELD_WIZARDPARAM13, 17);
        fieldIndexMap.put(FIELD_WIZARDPARAM14, 18);
        fieldIndexMap.put(FIELD_WIZARDPARAM15, 19);
        fieldIndexMap.put(FIELD_WIZARDPARAM16, 20);
        fieldIndexMap.put(FIELD_WIZARDPARAM2, 21);
        fieldIndexMap.put(FIELD_WIZARDPARAM3, 22);
        fieldIndexMap.put(FIELD_WIZARDPARAM4, 23);
    }
}

