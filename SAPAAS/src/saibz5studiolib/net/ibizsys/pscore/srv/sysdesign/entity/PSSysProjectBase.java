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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysProjectBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysProjectBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRJTYPE = "PRJTYPE";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSPROJECTID = "PSSYSPROJECTID";
    public static final String FIELD_PSSYSPROJECTNAME = "PSSYSPROJECTNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PRJTYPE = 3;
    private static final int INDEX_PSOBJID = 4;
    private static final int INDEX_PSOBJNAME = 5;
    private static final int INDEX_PSOBJTYPE = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_PSSYSPROJECTID = 9;
    private static final int INDEX_PSSYSPROJECTNAME = 10;
    private static final int INDEX_PSSYSSFPUBID = 11;
    private static final int INDEX_PSSYSSFPUBNAME = 12;
    private static final int INDEX_PSSYSTEMID = 13;
    private static final int INDEX_PSSYSTEMNAME = 14;
    private static final int INDEX_READONLYMODE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysProjectBase proxyPSSysProjectBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prjtypeDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysprojectidDirtyFlag = false;
    private boolean pssysprojectnameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="prjtype")
    private String prjtype;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysprojectid")
    private String pssysprojectid;
    @Column(name="pssysprojectname")
    private String pssysprojectname;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;
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

    public void setPrjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjtype = string;
        this.prjtypeDirtyFlag = true;
    }

    public String getPrjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjType();
        }
        return this.prjtype;
    }

    public boolean isPrjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjTypeDirty();
        }
        return this.prjtypeDirtyFlag;
    }

    public void resetPrjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjType();
            return;
        }
        this.prjtypeDirtyFlag = false;
        this.prjtype = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
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

    public void setPSSysProjectId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysProjectId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysprojectid = string;
        this.pssysprojectidDirtyFlag = true;
    }

    public String getPSSysProjectId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProjectId();
        }
        return this.pssysprojectid;
    }

    public boolean isPSSysProjectIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysProjectIdDirty();
        }
        return this.pssysprojectidDirtyFlag;
    }

    public void resetPSSysProjectId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysProjectId();
            return;
        }
        this.pssysprojectidDirtyFlag = false;
        this.pssysprojectid = null;
    }

    public void setPSSysProjectName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysProjectName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysprojectname = string;
        this.pssysprojectnameDirtyFlag = true;
    }

    public String getPSSysProjectName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProjectName();
        }
        return this.pssysprojectname;
    }

    public boolean isPSSysProjectNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysProjectNameDirty();
        }
        return this.pssysprojectnameDirtyFlag;
    }

    public void resetPSSysProjectName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysProjectName();
            return;
        }
        this.pssysprojectnameDirtyFlag = false;
        this.pssysprojectname = null;
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

    public void setReadOnlyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadOnlyMode(n);
            return;
        }
        this.readonlymode = n;
        this.readonlymodeDirtyFlag = true;
    }

    public Integer getReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadOnlyMode();
        }
        return this.readonlymode;
    }

    public boolean isReadOnlyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadOnlyModeDirty();
        }
        return this.readonlymodeDirtyFlag;
    }

    public void resetReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadOnlyMode();
            return;
        }
        this.readonlymodeDirtyFlag = false;
        this.readonlymode = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
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
        PSSysProjectBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysProjectBase pSSysProjectBase) {
        pSSysProjectBase.resetCreateDate();
        pSSysProjectBase.resetCreateMan();
        pSSysProjectBase.resetMemo();
        pSSysProjectBase.resetPrjType();
        pSSysProjectBase.resetPSObjId();
        pSSysProjectBase.resetPSObjName();
        pSSysProjectBase.resetPSObjType();
        pSSysProjectBase.resetPSSysAppId();
        pSSysProjectBase.resetPSSysAppName();
        pSSysProjectBase.resetPSSysProjectId();
        pSSysProjectBase.resetPSSysProjectName();
        pSSysProjectBase.resetPSSysSFPubId();
        pSSysProjectBase.resetPSSysSFPubName();
        pSSysProjectBase.resetPSSystemId();
        pSSysProjectBase.resetPSSystemName();
        pSSysProjectBase.resetReadOnlyMode();
        pSSysProjectBase.resetUpdateDate();
        pSSysProjectBase.resetUpdateMan();
        pSSysProjectBase.resetUserTag();
        pSSysProjectBase.resetUserTag2();
        pSSysProjectBase.resetValidFlag();
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
        if (!bl || this.isPrjTypeDirty()) {
            hashMap.put(FIELD_PRJTYPE, this.getPrjType());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysProjectIdDirty()) {
            hashMap.put(FIELD_PSSYSPROJECTID, this.getPSSysProjectId());
        }
        if (!bl || this.isPSSysProjectNameDirty()) {
            hashMap.put(FIELD_PSSYSPROJECTNAME, this.getPSSysProjectName());
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
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSSysProjectBase.get(this, n);
    }

    private static Object get(PSSysProjectBase pSSysProjectBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysProjectBase.getCreateDate();
            }
            case 1: {
                return pSSysProjectBase.getCreateMan();
            }
            case 2: {
                return pSSysProjectBase.getMemo();
            }
            case 3: {
                return pSSysProjectBase.getPrjType();
            }
            case 4: {
                return pSSysProjectBase.getPSObjId();
            }
            case 5: {
                return pSSysProjectBase.getPSObjName();
            }
            case 6: {
                return pSSysProjectBase.getPSObjType();
            }
            case 7: {
                return pSSysProjectBase.getPSSysAppId();
            }
            case 8: {
                return pSSysProjectBase.getPSSysAppName();
            }
            case 9: {
                return pSSysProjectBase.getPSSysProjectId();
            }
            case 10: {
                return pSSysProjectBase.getPSSysProjectName();
            }
            case 11: {
                return pSSysProjectBase.getPSSysSFPubId();
            }
            case 12: {
                return pSSysProjectBase.getPSSysSFPubName();
            }
            case 13: {
                return pSSysProjectBase.getPSSystemId();
            }
            case 14: {
                return pSSysProjectBase.getPSSystemName();
            }
            case 15: {
                return pSSysProjectBase.getReadOnlyMode();
            }
            case 16: {
                return pSSysProjectBase.getUpdateDate();
            }
            case 17: {
                return pSSysProjectBase.getUpdateMan();
            }
            case 18: {
                return pSSysProjectBase.getUserTag();
            }
            case 19: {
                return pSSysProjectBase.getUserTag2();
            }
            case 20: {
                return pSSysProjectBase.getValidFlag();
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
        PSSysProjectBase.set(this, n, object);
    }

    private static void set(PSSysProjectBase pSSysProjectBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysProjectBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysProjectBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysProjectBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysProjectBase.setPrjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysProjectBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysProjectBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysProjectBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysProjectBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysProjectBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysProjectBase.setPSSysProjectId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysProjectBase.setPSSysProjectName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysProjectBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysProjectBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysProjectBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysProjectBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysProjectBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysProjectBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysProjectBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysProjectBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysProjectBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysProjectBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysProjectBase.isNull(this, n);
    }

    private static boolean isNull(PSSysProjectBase pSSysProjectBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysProjectBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysProjectBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysProjectBase.getMemo() == null;
            }
            case 3: {
                return pSSysProjectBase.getPrjType() == null;
            }
            case 4: {
                return pSSysProjectBase.getPSObjId() == null;
            }
            case 5: {
                return pSSysProjectBase.getPSObjName() == null;
            }
            case 6: {
                return pSSysProjectBase.getPSObjType() == null;
            }
            case 7: {
                return pSSysProjectBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSSysProjectBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSSysProjectBase.getPSSysProjectId() == null;
            }
            case 10: {
                return pSSysProjectBase.getPSSysProjectName() == null;
            }
            case 11: {
                return pSSysProjectBase.getPSSysSFPubId() == null;
            }
            case 12: {
                return pSSysProjectBase.getPSSysSFPubName() == null;
            }
            case 13: {
                return pSSysProjectBase.getPSSystemId() == null;
            }
            case 14: {
                return pSSysProjectBase.getPSSystemName() == null;
            }
            case 15: {
                return pSSysProjectBase.getReadOnlyMode() == null;
            }
            case 16: {
                return pSSysProjectBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysProjectBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysProjectBase.getUserTag() == null;
            }
            case 19: {
                return pSSysProjectBase.getUserTag2() == null;
            }
            case 20: {
                return pSSysProjectBase.getValidFlag() == null;
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
        return PSSysProjectBase.contains(this, n);
    }

    private static boolean contains(PSSysProjectBase pSSysProjectBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysProjectBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysProjectBase.isCreateManDirty();
            }
            case 2: {
                return pSSysProjectBase.isMemoDirty();
            }
            case 3: {
                return pSSysProjectBase.isPrjTypeDirty();
            }
            case 4: {
                return pSSysProjectBase.isPSObjIdDirty();
            }
            case 5: {
                return pSSysProjectBase.isPSObjNameDirty();
            }
            case 6: {
                return pSSysProjectBase.isPSObjTypeDirty();
            }
            case 7: {
                return pSSysProjectBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSSysProjectBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSSysProjectBase.isPSSysProjectIdDirty();
            }
            case 10: {
                return pSSysProjectBase.isPSSysProjectNameDirty();
            }
            case 11: {
                return pSSysProjectBase.isPSSysSFPubIdDirty();
            }
            case 12: {
                return pSSysProjectBase.isPSSysSFPubNameDirty();
            }
            case 13: {
                return pSSysProjectBase.isPSSystemIdDirty();
            }
            case 14: {
                return pSSysProjectBase.isPSSystemNameDirty();
            }
            case 15: {
                return pSSysProjectBase.isReadOnlyModeDirty();
            }
            case 16: {
                return pSSysProjectBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysProjectBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysProjectBase.isUserTagDirty();
            }
            case 19: {
                return pSSysProjectBase.isUserTag2Dirty();
            }
            case 20: {
                return pSSysProjectBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysProjectBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysProjectBase pSSysProjectBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysProjectBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPrjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtype", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPrjType()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSSysProjectId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysprojectid", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSSysProjectId()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSSysProjectName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysprojectname", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSSysProjectName()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysProjectBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysProjectBase.getJSONValue((Object)pSSysProjectBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysProjectBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysProjectBase pSSysProjectBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysProjectBase.getCreateDate() != null) {
            object = pSSysProjectBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysProjectBase.getCreateMan() != null) {
            object = pSSysProjectBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getMemo() != null) {
            object = pSSysProjectBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPrjType() != null) {
            object = pSSysProjectBase.getPrjType();
            xmlNode.setAttribute(FIELD_PRJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSObjId() != null) {
            object = pSSysProjectBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSObjName() != null) {
            object = pSSysProjectBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSObjType() != null) {
            object = pSSysProjectBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSSysAppId() != null) {
            object = pSSysProjectBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSSysAppName() != null) {
            object = pSSysProjectBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSSysProjectId() != null) {
            object = pSSysProjectBase.getPSSysProjectId();
            xmlNode.setAttribute(FIELD_PSSYSPROJECTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSSysProjectName() != null) {
            object = pSSysProjectBase.getPSSysProjectName();
            xmlNode.setAttribute(FIELD_PSSYSPROJECTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSSysSFPubId() != null) {
            object = pSSysProjectBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSSysSFPubName() != null) {
            object = pSSysProjectBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSSystemId() != null) {
            object = pSSysProjectBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getPSSystemName() != null) {
            object = pSSysProjectBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getReadOnlyMode() != null) {
            object = pSSysProjectBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysProjectBase.getUpdateDate() != null) {
            object = pSSysProjectBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysProjectBase.getUpdateMan() != null) {
            object = pSSysProjectBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getUserTag() != null) {
            object = pSSysProjectBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getUserTag2() != null) {
            object = pSSysProjectBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysProjectBase.getValidFlag() != null) {
            object = pSSysProjectBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysProjectBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysProjectBase pSSysProjectBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysProjectBase.isCreateDateDirty() && (bl || pSSysProjectBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysProjectBase.getCreateDate());
        }
        if (pSSysProjectBase.isCreateManDirty() && (bl || pSSysProjectBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysProjectBase.getCreateMan());
        }
        if (pSSysProjectBase.isMemoDirty() && (bl || pSSysProjectBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysProjectBase.getMemo());
        }
        if (pSSysProjectBase.isPrjTypeDirty() && (bl || pSSysProjectBase.getPrjType() != null)) {
            iDataObject.set(FIELD_PRJTYPE, (Object)pSSysProjectBase.getPrjType());
        }
        if (pSSysProjectBase.isPSObjIdDirty() && (bl || pSSysProjectBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysProjectBase.getPSObjId());
        }
        if (pSSysProjectBase.isPSObjNameDirty() && (bl || pSSysProjectBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysProjectBase.getPSObjName());
        }
        if (pSSysProjectBase.isPSObjTypeDirty() && (bl || pSSysProjectBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSSysProjectBase.getPSObjType());
        }
        if (pSSysProjectBase.isPSSysAppIdDirty() && (bl || pSSysProjectBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysProjectBase.getPSSysAppId());
        }
        if (pSSysProjectBase.isPSSysAppNameDirty() && (bl || pSSysProjectBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysProjectBase.getPSSysAppName());
        }
        if (pSSysProjectBase.isPSSysProjectIdDirty() && (bl || pSSysProjectBase.getPSSysProjectId() != null)) {
            iDataObject.set(FIELD_PSSYSPROJECTID, (Object)pSSysProjectBase.getPSSysProjectId());
        }
        if (pSSysProjectBase.isPSSysProjectNameDirty() && (bl || pSSysProjectBase.getPSSysProjectName() != null)) {
            iDataObject.set(FIELD_PSSYSPROJECTNAME, (Object)pSSysProjectBase.getPSSysProjectName());
        }
        if (pSSysProjectBase.isPSSysSFPubIdDirty() && (bl || pSSysProjectBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSysProjectBase.getPSSysSFPubId());
        }
        if (pSSysProjectBase.isPSSysSFPubNameDirty() && (bl || pSSysProjectBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSysProjectBase.getPSSysSFPubName());
        }
        if (pSSysProjectBase.isPSSystemIdDirty() && (bl || pSSysProjectBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysProjectBase.getPSSystemId());
        }
        if (pSSysProjectBase.isPSSystemNameDirty() && (bl || pSSysProjectBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysProjectBase.getPSSystemName());
        }
        if (pSSysProjectBase.isReadOnlyModeDirty() && (bl || pSSysProjectBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSSysProjectBase.getReadOnlyMode());
        }
        if (pSSysProjectBase.isUpdateDateDirty() && (bl || pSSysProjectBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysProjectBase.getUpdateDate());
        }
        if (pSSysProjectBase.isUpdateManDirty() && (bl || pSSysProjectBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysProjectBase.getUpdateMan());
        }
        if (pSSysProjectBase.isUserTagDirty() && (bl || pSSysProjectBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysProjectBase.getUserTag());
        }
        if (pSSysProjectBase.isUserTag2Dirty() && (bl || pSSysProjectBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysProjectBase.getUserTag2());
        }
        if (pSSysProjectBase.isValidFlagDirty() && (bl || pSSysProjectBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysProjectBase.getValidFlag());
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
        return PSSysProjectBase.remove(this, n);
    }

    private static boolean remove(PSSysProjectBase pSSysProjectBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysProjectBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysProjectBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysProjectBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysProjectBase.resetPrjType();
                return true;
            }
            case 4: {
                pSSysProjectBase.resetPSObjId();
                return true;
            }
            case 5: {
                pSSysProjectBase.resetPSObjName();
                return true;
            }
            case 6: {
                pSSysProjectBase.resetPSObjType();
                return true;
            }
            case 7: {
                pSSysProjectBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSSysProjectBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSSysProjectBase.resetPSSysProjectId();
                return true;
            }
            case 10: {
                pSSysProjectBase.resetPSSysProjectName();
                return true;
            }
            case 11: {
                pSSysProjectBase.resetPSSysSFPubId();
                return true;
            }
            case 12: {
                pSSysProjectBase.resetPSSysSFPubName();
                return true;
            }
            case 13: {
                pSSysProjectBase.resetPSSystemId();
                return true;
            }
            case 14: {
                pSSysProjectBase.resetPSSystemName();
                return true;
            }
            case 15: {
                pSSysProjectBase.resetReadOnlyMode();
                return true;
            }
            case 16: {
                pSSysProjectBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysProjectBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysProjectBase.resetUserTag();
                return true;
            }
            case 19: {
                pSSysProjectBase.resetUserTag2();
                return true;
            }
            case 20: {
                pSSysProjectBase.resetValidFlag();
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

    private PSSysProjectBase getProxyEntity() {
        return this.proxyPSSysProjectBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysProjectBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysProjectBase) {
            this.proxyPSSysProjectBase = (PSSysProjectBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PRJTYPE, 3);
        fieldIndexMap.put(FIELD_PSOBJID, 4);
        fieldIndexMap.put(FIELD_PSOBJNAME, 5);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSPROJECTID, 9);
        fieldIndexMap.put(FIELD_PSSYSPROJECTNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 11);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 14);
        fieldIndexMap.put(FIELD_READONLYMODE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

