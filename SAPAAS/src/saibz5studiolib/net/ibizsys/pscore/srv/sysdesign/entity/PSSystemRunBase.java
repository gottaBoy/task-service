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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfg;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemRunBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSystemRunBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPID2 = "PSSYSAPPID2";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSAPPNAME2 = "PSSYSAPPNAME2";
    public static final String FIELD_PSSYSBDINSTCFGID = "PSSYSBDINSTCFGID";
    public static final String FIELD_PSSYSBDINSTCFGNAME = "PSSYSBDINSTCFGNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSTEMASID = "PSSYSTEMASID";
    public static final String FIELD_PSSYSTEMASNAME = "PSSYSTEMASNAME";
    public static final String FIELD_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTEMRUNID = "PSSYSTEMRUNID";
    public static final String FIELD_PSSYSTEMRUNNAME = "PSSYSTEMRUNNAME";
    public static final String FIELD_RUNPSSYSDYNAMODELID = "RUNPSSYSDYNAMODELID";
    public static final String FIELD_RUNPSSYSDYNAMODELNAME = "RUNPSSYSDYNAMODELNAME";
    public static final String FIELD_STOPWHENTEMPLERROR = "STOPWHENTEMPLERROR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSSYSAPPID = 4;
    private static final int INDEX_PSSYSAPPID2 = 5;
    private static final int INDEX_PSSYSAPPNAME = 6;
    private static final int INDEX_PSSYSAPPNAME2 = 7;
    private static final int INDEX_PSSYSBDINSTCFGID = 8;
    private static final int INDEX_PSSYSBDINSTCFGNAME = 9;
    private static final int INDEX_PSSYSSFPUBID = 10;
    private static final int INDEX_PSSYSSFPUBNAME = 11;
    private static final int INDEX_PSSYSTEMASID = 12;
    private static final int INDEX_PSSYSTEMASNAME = 13;
    private static final int INDEX_PSSYSTEMDBCFGID = 14;
    private static final int INDEX_PSSYSTEMDBCFGNAME = 15;
    private static final int INDEX_PSSYSTEMID = 16;
    private static final int INDEX_PSSYSTEMNAME = 17;
    private static final int INDEX_PSSYSTEMRUNID = 18;
    private static final int INDEX_PSSYSTEMRUNNAME = 19;
    private static final int INDEX_RUNPSSYSDYNAMODELID = 20;
    private static final int INDEX_RUNPSSYSDYNAMODELNAME = 21;
    private static final int INDEX_STOPWHENTEMPLERROR = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSystemRunBase proxyPSSystemRunBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappid2DirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysappname2DirtyFlag = false;
    private boolean pssysbdinstcfgidDirtyFlag = false;
    private boolean pssysbdinstcfgnameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssystemasidDirtyFlag = false;
    private boolean pssystemasnameDirtyFlag = false;
    private boolean pssystemdbcfgidDirtyFlag = false;
    private boolean pssystemdbcfgnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystemrunidDirtyFlag = false;
    private boolean pssystemrunnameDirtyFlag = false;
    private boolean runpssysdynamodelidDirtyFlag = false;
    private boolean runpssysdynamodelnameDirtyFlag = false;
    private boolean stopwhentemplerrorDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappid2")
    private String pssysappid2;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysappname2")
    private String pssysappname2;
    @Column(name="pssysbdinstcfgid")
    private String pssysbdinstcfgid;
    @Column(name="pssysbdinstcfgname")
    private String pssysbdinstcfgname;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssystemasid")
    private String pssystemasid;
    @Column(name="pssystemasname")
    private String pssystemasname;
    @Column(name="pssystemdbcfgid")
    private String pssystemdbcfgid;
    @Column(name="pssystemdbcfgname")
    private String pssystemdbcfgname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystemrunid")
    private String pssystemrunid;
    @Column(name="pssystemrunname")
    private String pssystemrunname;
    @Column(name="runpssysdynamodelid")
    private String runpssysdynamodelid;
    @Column(name="runpssysdynamodelname")
    private String runpssysdynamodelname;
    @Column(name="stopwhentemplerror")
    private Integer stopwhentemplerror;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysApp2Lock = new Integer(1);
    private PSSysApp pssysapp2 = null;
    private Integer objPSSysBDInstCfgLock = new Integer(1);
    private PSSysBDInstCfg pssysbdinstcfg = null;
    private Integer objRunPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel runpssysdynamodel = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;
    private Integer objPSSystemASLock = new Integer(1);
    private PSSystemAS pssystemas = null;
    private Integer objPSSystemDBCfgLock = new Integer(1);
    private PSSystemDBCfg pssystemdbcfg = null;
    private Integer objPSSystemLock = new Integer(1);
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid2 = string;
        this.pssysappid2DirtyFlag = true;
    }

    public String getPSSysAppId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId2();
        }
        return this.pssysappid2;
    }

    public boolean isPSSysAppId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppId2Dirty();
        }
        return this.pssysappid2DirtyFlag;
    }

    public void resetPSSysAppId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId2();
            return;
        }
        this.pssysappid2DirtyFlag = false;
        this.pssysappid2 = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSysAppName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname2 = string;
        this.pssysappname2DirtyFlag = true;
    }

    public String getPSSysAppName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName2();
        }
        return this.pssysappname2;
    }

    public boolean isPSSysAppName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppName2Dirty();
        }
        return this.pssysappname2DirtyFlag;
    }

    public void resetPSSysAppName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName2();
            return;
        }
        this.pssysappname2DirtyFlag = false;
        this.pssysappname2 = null;
    }

    public void setPSSysBDInstCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDInstCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdinstcfgid = string;
        this.pssysbdinstcfgidDirtyFlag = true;
    }

    public String getPSSysBDInstCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDInstCfgId();
        }
        return this.pssysbdinstcfgid;
    }

    public boolean isPSSysBDInstCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDInstCfgIdDirty();
        }
        return this.pssysbdinstcfgidDirtyFlag;
    }

    public void resetPSSysBDInstCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDInstCfgId();
            return;
        }
        this.pssysbdinstcfgidDirtyFlag = false;
        this.pssysbdinstcfgid = null;
    }

    public void setPSSysBDInstCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDInstCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdinstcfgname = string;
        this.pssysbdinstcfgnameDirtyFlag = true;
    }

    public String getPSSysBDInstCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDInstCfgName();
        }
        return this.pssysbdinstcfgname;
    }

    public boolean isPSSysBDInstCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDInstCfgNameDirty();
        }
        return this.pssysbdinstcfgnameDirtyFlag;
    }

    public void resetPSSysBDInstCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDInstCfgName();
            return;
        }
        this.pssysbdinstcfgnameDirtyFlag = false;
        this.pssysbdinstcfgname = null;
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

    public void setPSSystemASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemasid = string;
        this.pssystemasidDirtyFlag = true;
    }

    public String getPSSystemASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemASId();
        }
        return this.pssystemasid;
    }

    public boolean isPSSystemASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemASIdDirty();
        }
        return this.pssystemasidDirtyFlag;
    }

    public void resetPSSystemASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemASId();
            return;
        }
        this.pssystemasidDirtyFlag = false;
        this.pssystemasid = null;
    }

    public void setPSSystemASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemasname = string;
        this.pssystemasnameDirtyFlag = true;
    }

    public String getPSSystemASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemASName();
        }
        return this.pssystemasname;
    }

    public boolean isPSSystemASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemASNameDirty();
        }
        return this.pssystemasnameDirtyFlag;
    }

    public void resetPSSystemASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemASName();
            return;
        }
        this.pssystemasnameDirtyFlag = false;
        this.pssystemasname = null;
    }

    public void setPSSystemDBCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgid = string;
        this.pssystemdbcfgidDirtyFlag = true;
    }

    public String getPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgId();
        }
        return this.pssystemdbcfgid;
    }

    public boolean isPSSystemDBCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgIdDirty();
        }
        return this.pssystemdbcfgidDirtyFlag;
    }

    public void resetPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgId();
            return;
        }
        this.pssystemdbcfgidDirtyFlag = false;
        this.pssystemdbcfgid = null;
    }

    public void setPSSystemDBCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgname = string;
        this.pssystemdbcfgnameDirtyFlag = true;
    }

    public String getPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgName();
        }
        return this.pssystemdbcfgname;
    }

    public boolean isPSSystemDBCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgNameDirty();
        }
        return this.pssystemdbcfgnameDirtyFlag;
    }

    public void resetPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgName();
            return;
        }
        this.pssystemdbcfgnameDirtyFlag = false;
        this.pssystemdbcfgname = null;
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

    public void setPSSystemRunId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemRunId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemrunid = string;
        this.pssystemrunidDirtyFlag = true;
    }

    public String getPSSystemRunId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemRunId();
        }
        return this.pssystemrunid;
    }

    public boolean isPSSystemRunIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemRunIdDirty();
        }
        return this.pssystemrunidDirtyFlag;
    }

    public void resetPSSystemRunId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemRunId();
            return;
        }
        this.pssystemrunidDirtyFlag = false;
        this.pssystemrunid = null;
    }

    public void setPSSystemRunName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemRunName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemrunname = string;
        this.pssystemrunnameDirtyFlag = true;
    }

    public String getPSSystemRunName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemRunName();
        }
        return this.pssystemrunname;
    }

    public boolean isPSSystemRunNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemRunNameDirty();
        }
        return this.pssystemrunnameDirtyFlag;
    }

    public void resetPSSystemRunName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemRunName();
            return;
        }
        this.pssystemrunnameDirtyFlag = false;
        this.pssystemrunname = null;
    }

    public void setRunPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runpssysdynamodelid = string;
        this.runpssysdynamodelidDirtyFlag = true;
    }

    public String getRunPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunPSSysDynaModelId();
        }
        return this.runpssysdynamodelid;
    }

    public boolean isRunPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunPSSysDynaModelIdDirty();
        }
        return this.runpssysdynamodelidDirtyFlag;
    }

    public void resetRunPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunPSSysDynaModelId();
            return;
        }
        this.runpssysdynamodelidDirtyFlag = false;
        this.runpssysdynamodelid = null;
    }

    public void setRunPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runpssysdynamodelname = string;
        this.runpssysdynamodelnameDirtyFlag = true;
    }

    public String getRunPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunPSSysDynaModelName();
        }
        return this.runpssysdynamodelname;
    }

    public boolean isRunPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunPSSysDynaModelNameDirty();
        }
        return this.runpssysdynamodelnameDirtyFlag;
    }

    public void resetRunPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunPSSysDynaModelName();
            return;
        }
        this.runpssysdynamodelnameDirtyFlag = false;
        this.runpssysdynamodelname = null;
    }

    public void setStopWhenTemplError(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStopWhenTemplError(n);
            return;
        }
        this.stopwhentemplerror = n;
        this.stopwhentemplerrorDirtyFlag = true;
    }

    public Integer getStopWhenTemplError() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStopWhenTemplError();
        }
        return this.stopwhentemplerror;
    }

    public boolean isStopWhenTemplErrorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStopWhenTemplErrorDirty();
        }
        return this.stopwhentemplerrorDirtyFlag;
    }

    public void resetStopWhenTemplError() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStopWhenTemplError();
            return;
        }
        this.stopwhentemplerrorDirtyFlag = false;
        this.stopwhentemplerror = null;
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
        PSSystemRunBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSystemRunBase pSSystemRunBase) {
        pSSystemRunBase.resetCreateDate();
        pSSystemRunBase.resetCreateMan();
        pSSystemRunBase.resetDefaultFlag();
        pSSystemRunBase.resetMemo();
        pSSystemRunBase.resetPSSysAppId();
        pSSystemRunBase.resetPSSysAppId2();
        pSSystemRunBase.resetPSSysAppName();
        pSSystemRunBase.resetPSSysAppName2();
        pSSystemRunBase.resetPSSysBDInstCfgId();
        pSSystemRunBase.resetPSSysBDInstCfgName();
        pSSystemRunBase.resetPSSysSFPubId();
        pSSystemRunBase.resetPSSysSFPubName();
        pSSystemRunBase.resetPSSystemASId();
        pSSystemRunBase.resetPSSystemASName();
        pSSystemRunBase.resetPSSystemDBCfgId();
        pSSystemRunBase.resetPSSystemDBCfgName();
        pSSystemRunBase.resetPSSystemId();
        pSSystemRunBase.resetPSSystemName();
        pSSystemRunBase.resetPSSystemRunId();
        pSSystemRunBase.resetPSSystemRunName();
        pSSystemRunBase.resetRunPSSysDynaModelId();
        pSSystemRunBase.resetRunPSSysDynaModelName();
        pSSystemRunBase.resetStopWhenTemplError();
        pSSystemRunBase.resetUpdateDate();
        pSSystemRunBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppId2Dirty()) {
            hashMap.put(FIELD_PSSYSAPPID2, this.getPSSysAppId2());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysAppName2Dirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME2, this.getPSSysAppName2());
        }
        if (!bl || this.isPSSysBDInstCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSBDINSTCFGID, this.getPSSysBDInstCfgId());
        }
        if (!bl || this.isPSSysBDInstCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSBDINSTCFGNAME, this.getPSSysBDInstCfgName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPSSystemASIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMASID, this.getPSSystemASId());
        }
        if (!bl || this.isPSSystemASNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMASNAME, this.getPSSystemASName());
        }
        if (!bl || this.isPSSystemDBCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGID, this.getPSSystemDBCfgId());
        }
        if (!bl || this.isPSSystemDBCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGNAME, this.getPSSystemDBCfgName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSystemRunIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMRUNID, this.getPSSystemRunId());
        }
        if (!bl || this.isPSSystemRunNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMRUNNAME, this.getPSSystemRunName());
        }
        if (!bl || this.isRunPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_RUNPSSYSDYNAMODELID, this.getRunPSSysDynaModelId());
        }
        if (!bl || this.isRunPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_RUNPSSYSDYNAMODELNAME, this.getRunPSSysDynaModelName());
        }
        if (!bl || this.isStopWhenTemplErrorDirty()) {
            hashMap.put(FIELD_STOPWHENTEMPLERROR, this.getStopWhenTemplError());
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
        return PSSystemRunBase.get(this, n);
    }

    private static Object get(PSSystemRunBase pSSystemRunBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemRunBase.getCreateDate();
            }
            case 1: {
                return pSSystemRunBase.getCreateMan();
            }
            case 2: {
                return pSSystemRunBase.getDefaultFlag();
            }
            case 3: {
                return pSSystemRunBase.getMemo();
            }
            case 4: {
                return pSSystemRunBase.getPSSysAppId();
            }
            case 5: {
                return pSSystemRunBase.getPSSysAppId2();
            }
            case 6: {
                return pSSystemRunBase.getPSSysAppName();
            }
            case 7: {
                return pSSystemRunBase.getPSSysAppName2();
            }
            case 8: {
                return pSSystemRunBase.getPSSysBDInstCfgId();
            }
            case 9: {
                return pSSystemRunBase.getPSSysBDInstCfgName();
            }
            case 10: {
                return pSSystemRunBase.getPSSysSFPubId();
            }
            case 11: {
                return pSSystemRunBase.getPSSysSFPubName();
            }
            case 12: {
                return pSSystemRunBase.getPSSystemASId();
            }
            case 13: {
                return pSSystemRunBase.getPSSystemASName();
            }
            case 14: {
                return pSSystemRunBase.getPSSystemDBCfgId();
            }
            case 15: {
                return pSSystemRunBase.getPSSystemDBCfgName();
            }
            case 16: {
                return pSSystemRunBase.getPSSystemId();
            }
            case 17: {
                return pSSystemRunBase.getPSSystemName();
            }
            case 18: {
                return pSSystemRunBase.getPSSystemRunId();
            }
            case 19: {
                return pSSystemRunBase.getPSSystemRunName();
            }
            case 20: {
                return pSSystemRunBase.getRunPSSysDynaModelId();
            }
            case 21: {
                return pSSystemRunBase.getRunPSSysDynaModelName();
            }
            case 22: {
                return pSSystemRunBase.getStopWhenTemplError();
            }
            case 23: {
                return pSSystemRunBase.getUpdateDate();
            }
            case 24: {
                return pSSystemRunBase.getUpdateMan();
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
        PSSystemRunBase.set(this, n, object);
    }

    private static void set(PSSystemRunBase pSSystemRunBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSystemRunBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSystemRunBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSystemRunBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSystemRunBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSystemRunBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSystemRunBase.setPSSysAppId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSystemRunBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSystemRunBase.setPSSysAppName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSystemRunBase.setPSSysBDInstCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSystemRunBase.setPSSysBDInstCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSystemRunBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSystemRunBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSystemRunBase.setPSSystemASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSystemRunBase.setPSSystemASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSystemRunBase.setPSSystemDBCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSystemRunBase.setPSSystemDBCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSystemRunBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSystemRunBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSystemRunBase.setPSSystemRunId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSystemRunBase.setPSSystemRunName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSystemRunBase.setRunPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSystemRunBase.setRunPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSystemRunBase.setStopWhenTemplError(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSystemRunBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSystemRunBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSystemRunBase.isNull(this, n);
    }

    private static boolean isNull(PSSystemRunBase pSSystemRunBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemRunBase.getCreateDate() == null;
            }
            case 1: {
                return pSSystemRunBase.getCreateMan() == null;
            }
            case 2: {
                return pSSystemRunBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSSystemRunBase.getMemo() == null;
            }
            case 4: {
                return pSSystemRunBase.getPSSysAppId() == null;
            }
            case 5: {
                return pSSystemRunBase.getPSSysAppId2() == null;
            }
            case 6: {
                return pSSystemRunBase.getPSSysAppName() == null;
            }
            case 7: {
                return pSSystemRunBase.getPSSysAppName2() == null;
            }
            case 8: {
                return pSSystemRunBase.getPSSysBDInstCfgId() == null;
            }
            case 9: {
                return pSSystemRunBase.getPSSysBDInstCfgName() == null;
            }
            case 10: {
                return pSSystemRunBase.getPSSysSFPubId() == null;
            }
            case 11: {
                return pSSystemRunBase.getPSSysSFPubName() == null;
            }
            case 12: {
                return pSSystemRunBase.getPSSystemASId() == null;
            }
            case 13: {
                return pSSystemRunBase.getPSSystemASName() == null;
            }
            case 14: {
                return pSSystemRunBase.getPSSystemDBCfgId() == null;
            }
            case 15: {
                return pSSystemRunBase.getPSSystemDBCfgName() == null;
            }
            case 16: {
                return pSSystemRunBase.getPSSystemId() == null;
            }
            case 17: {
                return pSSystemRunBase.getPSSystemName() == null;
            }
            case 18: {
                return pSSystemRunBase.getPSSystemRunId() == null;
            }
            case 19: {
                return pSSystemRunBase.getPSSystemRunName() == null;
            }
            case 20: {
                return pSSystemRunBase.getRunPSSysDynaModelId() == null;
            }
            case 21: {
                return pSSystemRunBase.getRunPSSysDynaModelName() == null;
            }
            case 22: {
                return pSSystemRunBase.getStopWhenTemplError() == null;
            }
            case 23: {
                return pSSystemRunBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSystemRunBase.getUpdateMan() == null;
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
        return PSSystemRunBase.contains(this, n);
    }

    private static boolean contains(PSSystemRunBase pSSystemRunBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemRunBase.isCreateDateDirty();
            }
            case 1: {
                return pSSystemRunBase.isCreateManDirty();
            }
            case 2: {
                return pSSystemRunBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSSystemRunBase.isMemoDirty();
            }
            case 4: {
                return pSSystemRunBase.isPSSysAppIdDirty();
            }
            case 5: {
                return pSSystemRunBase.isPSSysAppId2Dirty();
            }
            case 6: {
                return pSSystemRunBase.isPSSysAppNameDirty();
            }
            case 7: {
                return pSSystemRunBase.isPSSysAppName2Dirty();
            }
            case 8: {
                return pSSystemRunBase.isPSSysBDInstCfgIdDirty();
            }
            case 9: {
                return pSSystemRunBase.isPSSysBDInstCfgNameDirty();
            }
            case 10: {
                return pSSystemRunBase.isPSSysSFPubIdDirty();
            }
            case 11: {
                return pSSystemRunBase.isPSSysSFPubNameDirty();
            }
            case 12: {
                return pSSystemRunBase.isPSSystemASIdDirty();
            }
            case 13: {
                return pSSystemRunBase.isPSSystemASNameDirty();
            }
            case 14: {
                return pSSystemRunBase.isPSSystemDBCfgIdDirty();
            }
            case 15: {
                return pSSystemRunBase.isPSSystemDBCfgNameDirty();
            }
            case 16: {
                return pSSystemRunBase.isPSSystemIdDirty();
            }
            case 17: {
                return pSSystemRunBase.isPSSystemNameDirty();
            }
            case 18: {
                return pSSystemRunBase.isPSSystemRunIdDirty();
            }
            case 19: {
                return pSSystemRunBase.isPSSystemRunNameDirty();
            }
            case 20: {
                return pSSystemRunBase.isRunPSSysDynaModelIdDirty();
            }
            case 21: {
                return pSSystemRunBase.isRunPSSysDynaModelNameDirty();
            }
            case 22: {
                return pSSystemRunBase.isStopWhenTemplErrorDirty();
            }
            case 23: {
                return pSSystemRunBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSystemRunBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSystemRunBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSystemRunBase pSSystemRunBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSystemRunBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getMemo()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSysAppId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid2", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSysAppId2()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSysAppName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname2", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSysAppName2()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSysBDInstCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdinstcfgid", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSysBDInstCfgId()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSysBDInstCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdinstcfgname", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSysBDInstCfgName()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSystemASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemasid", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSystemASId()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSystemASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemasname", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSystemASName()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSystemDBCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgid", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSystemDBCfgId()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSystemDBCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgname", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSystemDBCfgName()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSystemRunId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemrunid", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSystemRunId()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getPSSystemRunName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemrunname", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getPSSystemRunName()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getRunPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runpssysdynamodelid", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getRunPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getRunPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runpssysdynamodelname", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getRunPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getStopWhenTemplError() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stopwhentemplerror", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getStopWhenTemplError()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSystemRunBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSystemRunBase.getJSONValue((Object)pSSystemRunBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSystemRunBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSystemRunBase pSSystemRunBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSystemRunBase.getCreateDate() != null) {
            object = pSSystemRunBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemRunBase.getCreateMan() != null) {
            object = pSSystemRunBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getDefaultFlag() != null) {
            object = pSSystemRunBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemRunBase.getMemo() != null) {
            object = pSSystemRunBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSysAppId() != null) {
            object = pSSystemRunBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSysAppId2() != null) {
            object = pSSystemRunBase.getPSSysAppId2();
            xmlNode.setAttribute(FIELD_PSSYSAPPID2, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSysAppName() != null) {
            object = pSSystemRunBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSysAppName2() != null) {
            object = pSSystemRunBase.getPSSysAppName2();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSysBDInstCfgId() != null) {
            object = pSSystemRunBase.getPSSysBDInstCfgId();
            xmlNode.setAttribute(FIELD_PSSYSBDINSTCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSysBDInstCfgName() != null) {
            object = pSSystemRunBase.getPSSysBDInstCfgName();
            xmlNode.setAttribute(FIELD_PSSYSBDINSTCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSysSFPubId() != null) {
            object = pSSystemRunBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSysSFPubName() != null) {
            object = pSSystemRunBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSystemASId() != null) {
            object = pSSystemRunBase.getPSSystemASId();
            xmlNode.setAttribute(FIELD_PSSYSTEMASID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSystemASName() != null) {
            object = pSSystemRunBase.getPSSystemASName();
            xmlNode.setAttribute(FIELD_PSSYSTEMASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSystemDBCfgId() != null) {
            object = pSSystemRunBase.getPSSystemDBCfgId();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSystemDBCfgName() != null) {
            object = pSSystemRunBase.getPSSystemDBCfgName();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSystemId() != null) {
            object = pSSystemRunBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSystemName() != null) {
            object = pSSystemRunBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSystemRunId() != null) {
            object = pSSystemRunBase.getPSSystemRunId();
            xmlNode.setAttribute(FIELD_PSSYSTEMRUNID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getPSSystemRunName() != null) {
            object = pSSystemRunBase.getPSSystemRunName();
            xmlNode.setAttribute(FIELD_PSSYSTEMRUNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getRunPSSysDynaModelId() != null) {
            object = pSSystemRunBase.getRunPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_RUNPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getRunPSSysDynaModelName() != null) {
            object = pSSystemRunBase.getRunPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_RUNPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemRunBase.getStopWhenTemplError() != null) {
            object = pSSystemRunBase.getStopWhenTemplError();
            xmlNode.setAttribute(FIELD_STOPWHENTEMPLERROR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemRunBase.getUpdateDate() != null) {
            object = pSSystemRunBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemRunBase.getUpdateMan() != null) {
            object = pSSystemRunBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSystemRunBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSystemRunBase pSSystemRunBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSystemRunBase.isCreateDateDirty() && (bl || pSSystemRunBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSystemRunBase.getCreateDate());
        }
        if (pSSystemRunBase.isCreateManDirty() && (bl || pSSystemRunBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSystemRunBase.getCreateMan());
        }
        if (pSSystemRunBase.isDefaultFlagDirty() && (bl || pSSystemRunBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSystemRunBase.getDefaultFlag());
        }
        if (pSSystemRunBase.isMemoDirty() && (bl || pSSystemRunBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSystemRunBase.getMemo());
        }
        if (pSSystemRunBase.isPSSysAppIdDirty() && (bl || pSSystemRunBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSystemRunBase.getPSSysAppId());
        }
        if (pSSystemRunBase.isPSSysAppId2Dirty() && (bl || pSSystemRunBase.getPSSysAppId2() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID2, (Object)pSSystemRunBase.getPSSysAppId2());
        }
        if (pSSystemRunBase.isPSSysAppNameDirty() && (bl || pSSystemRunBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSystemRunBase.getPSSysAppName());
        }
        if (pSSystemRunBase.isPSSysAppName2Dirty() && (bl || pSSystemRunBase.getPSSysAppName2() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME2, (Object)pSSystemRunBase.getPSSysAppName2());
        }
        if (pSSystemRunBase.isPSSysBDInstCfgIdDirty() && (bl || pSSystemRunBase.getPSSysBDInstCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSBDINSTCFGID, (Object)pSSystemRunBase.getPSSysBDInstCfgId());
        }
        if (pSSystemRunBase.isPSSysBDInstCfgNameDirty() && (bl || pSSystemRunBase.getPSSysBDInstCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSBDINSTCFGNAME, (Object)pSSystemRunBase.getPSSysBDInstCfgName());
        }
        if (pSSystemRunBase.isPSSysSFPubIdDirty() && (bl || pSSystemRunBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSystemRunBase.getPSSysSFPubId());
        }
        if (pSSystemRunBase.isPSSysSFPubNameDirty() && (bl || pSSystemRunBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSystemRunBase.getPSSysSFPubName());
        }
        if (pSSystemRunBase.isPSSystemASIdDirty() && (bl || pSSystemRunBase.getPSSystemASId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMASID, (Object)pSSystemRunBase.getPSSystemASId());
        }
        if (pSSystemRunBase.isPSSystemASNameDirty() && (bl || pSSystemRunBase.getPSSystemASName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMASNAME, (Object)pSSystemRunBase.getPSSystemASName());
        }
        if (pSSystemRunBase.isPSSystemDBCfgIdDirty() && (bl || pSSystemRunBase.getPSSystemDBCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGID, (Object)pSSystemRunBase.getPSSystemDBCfgId());
        }
        if (pSSystemRunBase.isPSSystemDBCfgNameDirty() && (bl || pSSystemRunBase.getPSSystemDBCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGNAME, (Object)pSSystemRunBase.getPSSystemDBCfgName());
        }
        if (pSSystemRunBase.isPSSystemIdDirty() && (bl || pSSystemRunBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSystemRunBase.getPSSystemId());
        }
        if (pSSystemRunBase.isPSSystemNameDirty() && (bl || pSSystemRunBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSystemRunBase.getPSSystemName());
        }
        if (pSSystemRunBase.isPSSystemRunIdDirty() && (bl || pSSystemRunBase.getPSSystemRunId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMRUNID, (Object)pSSystemRunBase.getPSSystemRunId());
        }
        if (pSSystemRunBase.isPSSystemRunNameDirty() && (bl || pSSystemRunBase.getPSSystemRunName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMRUNNAME, (Object)pSSystemRunBase.getPSSystemRunName());
        }
        if (pSSystemRunBase.isRunPSSysDynaModelIdDirty() && (bl || pSSystemRunBase.getRunPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_RUNPSSYSDYNAMODELID, (Object)pSSystemRunBase.getRunPSSysDynaModelId());
        }
        if (pSSystemRunBase.isRunPSSysDynaModelNameDirty() && (bl || pSSystemRunBase.getRunPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_RUNPSSYSDYNAMODELNAME, (Object)pSSystemRunBase.getRunPSSysDynaModelName());
        }
        if (pSSystemRunBase.isStopWhenTemplErrorDirty() && (bl || pSSystemRunBase.getStopWhenTemplError() != null)) {
            iDataObject.set(FIELD_STOPWHENTEMPLERROR, (Object)pSSystemRunBase.getStopWhenTemplError());
        }
        if (pSSystemRunBase.isUpdateDateDirty() && (bl || pSSystemRunBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSystemRunBase.getUpdateDate());
        }
        if (pSSystemRunBase.isUpdateManDirty() && (bl || pSSystemRunBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSystemRunBase.getUpdateMan());
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
        return PSSystemRunBase.remove(this, n);
    }

    private static boolean remove(PSSystemRunBase pSSystemRunBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSystemRunBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSystemRunBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSystemRunBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSSystemRunBase.resetMemo();
                return true;
            }
            case 4: {
                pSSystemRunBase.resetPSSysAppId();
                return true;
            }
            case 5: {
                pSSystemRunBase.resetPSSysAppId2();
                return true;
            }
            case 6: {
                pSSystemRunBase.resetPSSysAppName();
                return true;
            }
            case 7: {
                pSSystemRunBase.resetPSSysAppName2();
                return true;
            }
            case 8: {
                pSSystemRunBase.resetPSSysBDInstCfgId();
                return true;
            }
            case 9: {
                pSSystemRunBase.resetPSSysBDInstCfgName();
                return true;
            }
            case 10: {
                pSSystemRunBase.resetPSSysSFPubId();
                return true;
            }
            case 11: {
                pSSystemRunBase.resetPSSysSFPubName();
                return true;
            }
            case 12: {
                pSSystemRunBase.resetPSSystemASId();
                return true;
            }
            case 13: {
                pSSystemRunBase.resetPSSystemASName();
                return true;
            }
            case 14: {
                pSSystemRunBase.resetPSSystemDBCfgId();
                return true;
            }
            case 15: {
                pSSystemRunBase.resetPSSystemDBCfgName();
                return true;
            }
            case 16: {
                pSSystemRunBase.resetPSSystemId();
                return true;
            }
            case 17: {
                pSSystemRunBase.resetPSSystemName();
                return true;
            }
            case 18: {
                pSSystemRunBase.resetPSSystemRunId();
                return true;
            }
            case 19: {
                pSSystemRunBase.resetPSSystemRunName();
                return true;
            }
            case 20: {
                pSSystemRunBase.resetRunPSSysDynaModelId();
                return true;
            }
            case 21: {
                pSSystemRunBase.resetRunPSSysDynaModelName();
                return true;
            }
            case 22: {
                pSSystemRunBase.resetStopWhenTemplError();
                return true;
            }
            case 23: {
                pSSystemRunBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSystemRunBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp2();
        }
        if (this.getPSSysAppId2() == null) {
            return null;
        }
        Integer n = this.objPSSysApp2Lock;
        synchronized (n) {
            if (this.pssysapp2 != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId2(), (Object)this.pssysapp2.getPSSysAppId()) != 0L) {
                this.pssysapp2 = null;
            }
            if (this.pssysapp2 == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId2());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp2 = pSSysApp;
            }
            return this.pssysapp2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDInstCfg getPSSysBDInstCfg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDInstCfg();
        }
        if (this.getPSSysBDInstCfgId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDInstCfgLock;
        synchronized (n) {
            if (this.pssysbdinstcfg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDInstCfgId(), (Object)this.pssysbdinstcfg.getPSSysBDInstCfgId()) != 0L) {
                this.pssysbdinstcfg = null;
            }
            if (this.pssysbdinstcfg == null) {
                PSSysBDInstCfg pSSysBDInstCfg = new PSSysBDInstCfg();
                pSSysBDInstCfg.setPSSysBDInstCfgId(this.getPSSysBDInstCfgId());
                PSSysBDInstCfgService pSSysBDInstCfgService = (PSSysBDInstCfgService)ServiceGlobal.getService(PSSysBDInstCfgService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDInstCfgService.autoGet(pSSysBDInstCfg);
                this.pssysbdinstcfg = pSSysBDInstCfg;
            }
            return this.pssysbdinstcfg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getRunPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunPSSysDynaModel();
        }
        if (this.getRunPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objRunPSSysDynaModelLock;
        synchronized (n) {
            if (this.runpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getRunPSSysDynaModelId(), (Object)this.runpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.runpssysdynamodel = null;
            }
            if (this.runpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getRunPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.runpssysdynamodel = pSSysDynaModel;
            }
            return this.runpssysdynamodel;
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
                pSSysSFPubService.autoGet(pSSysSFPub);
                this.pssyssfpub = pSSysSFPub;
            }
            return this.pssyssfpub;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystemAS getPSSystemAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemAS();
        }
        if (this.getPSSystemASId() == null) {
            return null;
        }
        Integer n = this.objPSSystemASLock;
        synchronized (n) {
            if (this.pssystemas != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemASId(), (Object)this.pssystemas.getPSSystemASId()) != 0L) {
                this.pssystemas = null;
            }
            if (this.pssystemas == null) {
                PSSystemAS pSSystemAS = new PSSystemAS();
                pSSystemAS.setPSSystemASId(this.getPSSystemASId());
                PSSystemASService pSSystemASService = (PSSystemASService)ServiceGlobal.getService(PSSystemASService.class, (SessionFactory)this.getSessionFactory());
                pSSystemASService.autoGet(pSSystemAS);
                this.pssystemas = pSSystemAS;
            }
            return this.pssystemas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystemDBCfg getPSSystemDBCfg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfg();
        }
        if (this.getPSSystemDBCfgId() == null) {
            return null;
        }
        Integer n = this.objPSSystemDBCfgLock;
        synchronized (n) {
            if (this.pssystemdbcfg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemDBCfgId(), (Object)this.pssystemdbcfg.getPSSystemDBCfgId()) != 0L) {
                this.pssystemdbcfg = null;
            }
            if (this.pssystemdbcfg == null) {
                PSSystemDBCfg pSSystemDBCfg = new PSSystemDBCfg();
                pSSystemDBCfg.setPSSystemDBCfgId(this.getPSSystemDBCfgId());
                PSSystemDBCfgService pSSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)this.getSessionFactory());
                pSSystemDBCfgService.autoGet(pSSystemDBCfg);
                this.pssystemdbcfg = pSSystemDBCfg;
            }
            return this.pssystemdbcfg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSystemRunBase getProxyEntity() {
        return this.proxyPSSystemRunBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSystemRunBase = null;
        if (iDataObject != null && iDataObject instanceof PSSystemRunBase) {
            this.proxyPSSystemRunBase = (PSSystemRunBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 4);
        fieldIndexMap.put(FIELD_PSSYSAPPID2, 5);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME2, 7);
        fieldIndexMap.put(FIELD_PSSYSBDINSTCFGID, 8);
        fieldIndexMap.put(FIELD_PSSYSBDINSTCFGNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 10);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMASID, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMASNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMRUNID, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMRUNNAME, 19);
        fieldIndexMap.put(FIELD_RUNPSSYSDYNAMODELID, 20);
        fieldIndexMap.put(FIELD_RUNPSSYSDYNAMODELNAME, 21);
        fieldIndexMap.put(FIELD_STOPWHENTEMPLERROR, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
    }
}

