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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWF;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppWFVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppWFVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPWFID = "PSAPPWFID";
    public static final String FIELD_PSAPPWFNAME = "PSAPPWFNAME";
    public static final String FIELD_PSAPPWFVERID = "PSAPPWFVERID";
    public static final String FIELD_PSAPPWFVERNAME = "PSAPPWFVERNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSAPPWFID = 3;
    private static final int INDEX_PSAPPWFNAME = 4;
    private static final int INDEX_PSAPPWFVERID = 5;
    private static final int INDEX_PSAPPWFVERNAME = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_PSWFVERSIONID = 9;
    private static final int INDEX_PSWFVERSIONNAME = 10;
    private static final int INDEX_PSWORKFLOWID = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppWFVerBase proxyPSAppWFVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappwfidDirtyFlag = false;
    private boolean psappwfnameDirtyFlag = false;
    private boolean psappwfveridDirtyFlag = false;
    private boolean psappwfvernameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean psworkflowidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappwfid")
    private String psappwfid;
    @Column(name="psappwfname")
    private String psappwfname;
    @Column(name="psappwfverid")
    private String psappwfverid;
    @Column(name="psappwfvername")
    private String psappwfvername;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="psworkflowid")
    private String psworkflowid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppWFLock = new Integer(1);
    private PSAppWF psappwf = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;

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

    public void setPSAppWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappwfid = string;
        this.psappwfidDirtyFlag = true;
    }

    public String getPSAppWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFId();
        }
        return this.psappwfid;
    }

    public boolean isPSAppWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppWFIdDirty();
        }
        return this.psappwfidDirtyFlag;
    }

    public void resetPSAppWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppWFId();
            return;
        }
        this.psappwfidDirtyFlag = false;
        this.psappwfid = null;
    }

    public void setPSAppWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappwfname = string;
        this.psappwfnameDirtyFlag = true;
    }

    public String getPSAppWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFName();
        }
        return this.psappwfname;
    }

    public boolean isPSAppWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppWFNameDirty();
        }
        return this.psappwfnameDirtyFlag;
    }

    public void resetPSAppWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppWFName();
            return;
        }
        this.psappwfnameDirtyFlag = false;
        this.psappwfname = null;
    }

    public void setPSAppWFVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppWFVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappwfverid = string;
        this.psappwfveridDirtyFlag = true;
    }

    public String getPSAppWFVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFVerId();
        }
        return this.psappwfverid;
    }

    public boolean isPSAppWFVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppWFVerIdDirty();
        }
        return this.psappwfveridDirtyFlag;
    }

    public void resetPSAppWFVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppWFVerId();
            return;
        }
        this.psappwfveridDirtyFlag = false;
        this.psappwfverid = null;
    }

    public void setPSAppWFVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppWFVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappwfvername = string;
        this.psappwfvernameDirtyFlag = true;
    }

    public String getPSAppWFVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFVerName();
        }
        return this.psappwfvername;
    }

    public boolean isPSAppWFVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppWFVerNameDirty();
        }
        return this.psappwfvernameDirtyFlag;
    }

    public void resetPSAppWFVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppWFVerName();
            return;
        }
        this.psappwfvernameDirtyFlag = false;
        this.psappwfvername = null;
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

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
    }

    public void setPSWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowid = string;
        this.psworkflowidDirtyFlag = true;
    }

    public String getPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowId();
        }
        return this.psworkflowid;
    }

    public boolean isPSWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowIdDirty();
        }
        return this.psworkflowidDirtyFlag;
    }

    public void resetPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowId();
            return;
        }
        this.psworkflowidDirtyFlag = false;
        this.psworkflowid = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
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

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
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
        PSAppWFVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppWFVerBase pSAppWFVerBase) {
        pSAppWFVerBase.resetCreateDate();
        pSAppWFVerBase.resetCreateMan();
        pSAppWFVerBase.resetMemo();
        pSAppWFVerBase.resetPSAppWFId();
        pSAppWFVerBase.resetPSAppWFName();
        pSAppWFVerBase.resetPSAppWFVerId();
        pSAppWFVerBase.resetPSAppWFVerName();
        pSAppWFVerBase.resetPSSysAppId();
        pSAppWFVerBase.resetPSSysAppName();
        pSAppWFVerBase.resetPSWFVersionId();
        pSAppWFVerBase.resetPSWFVersionName();
        pSAppWFVerBase.resetPSWorkflowId();
        pSAppWFVerBase.resetUpdateDate();
        pSAppWFVerBase.resetUpdateMan();
        pSAppWFVerBase.resetUserCat();
        pSAppWFVerBase.resetUserTag();
        pSAppWFVerBase.resetUserTag2();
        pSAppWFVerBase.resetUserTag3();
        pSAppWFVerBase.resetUserTag4();
        pSAppWFVerBase.resetValidFlag();
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
        if (!bl || this.isPSAppWFIdDirty()) {
            hashMap.put(FIELD_PSAPPWFID, this.getPSAppWFId());
        }
        if (!bl || this.isPSAppWFNameDirty()) {
            hashMap.put(FIELD_PSAPPWFNAME, this.getPSAppWFName());
        }
        if (!bl || this.isPSAppWFVerIdDirty()) {
            hashMap.put(FIELD_PSAPPWFVERID, this.getPSAppWFVerId());
        }
        if (!bl || this.isPSAppWFVerNameDirty()) {
            hashMap.put(FIELD_PSAPPWFVERNAME, this.getPSAppWFVerName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isPSWorkflowIdDirty()) {
            hashMap.put(FIELD_PSWORKFLOWID, this.getPSWorkflowId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSAppWFVerBase.get(this, n);
    }

    private static Object get(PSAppWFVerBase pSAppWFVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppWFVerBase.getCreateDate();
            }
            case 1: {
                return pSAppWFVerBase.getCreateMan();
            }
            case 2: {
                return pSAppWFVerBase.getMemo();
            }
            case 3: {
                return pSAppWFVerBase.getPSAppWFId();
            }
            case 4: {
                return pSAppWFVerBase.getPSAppWFName();
            }
            case 5: {
                return pSAppWFVerBase.getPSAppWFVerId();
            }
            case 6: {
                return pSAppWFVerBase.getPSAppWFVerName();
            }
            case 7: {
                return pSAppWFVerBase.getPSSysAppId();
            }
            case 8: {
                return pSAppWFVerBase.getPSSysAppName();
            }
            case 9: {
                return pSAppWFVerBase.getPSWFVersionId();
            }
            case 10: {
                return pSAppWFVerBase.getPSWFVersionName();
            }
            case 11: {
                return pSAppWFVerBase.getPSWorkflowId();
            }
            case 12: {
                return pSAppWFVerBase.getUpdateDate();
            }
            case 13: {
                return pSAppWFVerBase.getUpdateMan();
            }
            case 14: {
                return pSAppWFVerBase.getUserCat();
            }
            case 15: {
                return pSAppWFVerBase.getUserTag();
            }
            case 16: {
                return pSAppWFVerBase.getUserTag2();
            }
            case 17: {
                return pSAppWFVerBase.getUserTag3();
            }
            case 18: {
                return pSAppWFVerBase.getUserTag4();
            }
            case 19: {
                return pSAppWFVerBase.getValidFlag();
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
        PSAppWFVerBase.set(this, n, object);
    }

    private static void set(PSAppWFVerBase pSAppWFVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppWFVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppWFVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppWFVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppWFVerBase.setPSAppWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppWFVerBase.setPSAppWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppWFVerBase.setPSAppWFVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppWFVerBase.setPSAppWFVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppWFVerBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppWFVerBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppWFVerBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppWFVerBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppWFVerBase.setPSWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppWFVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSAppWFVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppWFVerBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppWFVerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppWFVerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppWFVerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppWFVerBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppWFVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppWFVerBase.isNull(this, n);
    }

    private static boolean isNull(PSAppWFVerBase pSAppWFVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppWFVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppWFVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppWFVerBase.getMemo() == null;
            }
            case 3: {
                return pSAppWFVerBase.getPSAppWFId() == null;
            }
            case 4: {
                return pSAppWFVerBase.getPSAppWFName() == null;
            }
            case 5: {
                return pSAppWFVerBase.getPSAppWFVerId() == null;
            }
            case 6: {
                return pSAppWFVerBase.getPSAppWFVerName() == null;
            }
            case 7: {
                return pSAppWFVerBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSAppWFVerBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSAppWFVerBase.getPSWFVersionId() == null;
            }
            case 10: {
                return pSAppWFVerBase.getPSWFVersionName() == null;
            }
            case 11: {
                return pSAppWFVerBase.getPSWorkflowId() == null;
            }
            case 12: {
                return pSAppWFVerBase.getUpdateDate() == null;
            }
            case 13: {
                return pSAppWFVerBase.getUpdateMan() == null;
            }
            case 14: {
                return pSAppWFVerBase.getUserCat() == null;
            }
            case 15: {
                return pSAppWFVerBase.getUserTag() == null;
            }
            case 16: {
                return pSAppWFVerBase.getUserTag2() == null;
            }
            case 17: {
                return pSAppWFVerBase.getUserTag3() == null;
            }
            case 18: {
                return pSAppWFVerBase.getUserTag4() == null;
            }
            case 19: {
                return pSAppWFVerBase.getValidFlag() == null;
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
        return PSAppWFVerBase.contains(this, n);
    }

    private static boolean contains(PSAppWFVerBase pSAppWFVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppWFVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppWFVerBase.isCreateManDirty();
            }
            case 2: {
                return pSAppWFVerBase.isMemoDirty();
            }
            case 3: {
                return pSAppWFVerBase.isPSAppWFIdDirty();
            }
            case 4: {
                return pSAppWFVerBase.isPSAppWFNameDirty();
            }
            case 5: {
                return pSAppWFVerBase.isPSAppWFVerIdDirty();
            }
            case 6: {
                return pSAppWFVerBase.isPSAppWFVerNameDirty();
            }
            case 7: {
                return pSAppWFVerBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSAppWFVerBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSAppWFVerBase.isPSWFVersionIdDirty();
            }
            case 10: {
                return pSAppWFVerBase.isPSWFVersionNameDirty();
            }
            case 11: {
                return pSAppWFVerBase.isPSWorkflowIdDirty();
            }
            case 12: {
                return pSAppWFVerBase.isUpdateDateDirty();
            }
            case 13: {
                return pSAppWFVerBase.isUpdateManDirty();
            }
            case 14: {
                return pSAppWFVerBase.isUserCatDirty();
            }
            case 15: {
                return pSAppWFVerBase.isUserTagDirty();
            }
            case 16: {
                return pSAppWFVerBase.isUserTag2Dirty();
            }
            case 17: {
                return pSAppWFVerBase.isUserTag3Dirty();
            }
            case 18: {
                return pSAppWFVerBase.isUserTag4Dirty();
            }
            case 19: {
                return pSAppWFVerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppWFVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppWFVerBase pSAppWFVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppWFVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSAppWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappwfid", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSAppWFId()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSAppWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappwfname", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSAppWFName()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSAppWFVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappwfverid", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSAppWFVerId()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSAppWFVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappwfvername", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSAppWFVerName()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getPSWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowid", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getPSWorkflowId()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppWFVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppWFVerBase.getJSONValue((Object)pSAppWFVerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppWFVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppWFVerBase pSAppWFVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppWFVerBase.getCreateDate() != null) {
            object = pSAppWFVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppWFVerBase.getCreateMan() != null) {
            object = pSAppWFVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getMemo() != null) {
            object = pSAppWFVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSAppWFId() != null) {
            object = pSAppWFVerBase.getPSAppWFId();
            xmlNode.setAttribute(FIELD_PSAPPWFID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSAppWFName() != null) {
            object = pSAppWFVerBase.getPSAppWFName();
            xmlNode.setAttribute(FIELD_PSAPPWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSAppWFVerId() != null) {
            object = pSAppWFVerBase.getPSAppWFVerId();
            xmlNode.setAttribute(FIELD_PSAPPWFVERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSAppWFVerName() != null) {
            object = pSAppWFVerBase.getPSAppWFVerName();
            xmlNode.setAttribute(FIELD_PSAPPWFVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSSysAppId() != null) {
            object = pSAppWFVerBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSSysAppName() != null) {
            object = pSAppWFVerBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSWFVersionId() != null) {
            object = pSAppWFVerBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSWFVersionName() != null) {
            object = pSAppWFVerBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getPSWorkflowId() != null) {
            object = pSAppWFVerBase.getPSWorkflowId();
            xmlNode.setAttribute(FIELD_PSWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getUpdateDate() != null) {
            object = pSAppWFVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppWFVerBase.getUpdateMan() != null) {
            object = pSAppWFVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getUserCat() != null) {
            object = pSAppWFVerBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getUserTag() != null) {
            object = pSAppWFVerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getUserTag2() != null) {
            object = pSAppWFVerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getUserTag3() != null) {
            object = pSAppWFVerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getUserTag4() != null) {
            object = pSAppWFVerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppWFVerBase.getValidFlag() != null) {
            object = pSAppWFVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppWFVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppWFVerBase pSAppWFVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppWFVerBase.isCreateDateDirty() && (bl || pSAppWFVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppWFVerBase.getCreateDate());
        }
        if (pSAppWFVerBase.isCreateManDirty() && (bl || pSAppWFVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppWFVerBase.getCreateMan());
        }
        if (pSAppWFVerBase.isMemoDirty() && (bl || pSAppWFVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppWFVerBase.getMemo());
        }
        if (pSAppWFVerBase.isPSAppWFIdDirty() && (bl || pSAppWFVerBase.getPSAppWFId() != null)) {
            iDataObject.set(FIELD_PSAPPWFID, (Object)pSAppWFVerBase.getPSAppWFId());
        }
        if (pSAppWFVerBase.isPSAppWFNameDirty() && (bl || pSAppWFVerBase.getPSAppWFName() != null)) {
            iDataObject.set(FIELD_PSAPPWFNAME, (Object)pSAppWFVerBase.getPSAppWFName());
        }
        if (pSAppWFVerBase.isPSAppWFVerIdDirty() && (bl || pSAppWFVerBase.getPSAppWFVerId() != null)) {
            iDataObject.set(FIELD_PSAPPWFVERID, (Object)pSAppWFVerBase.getPSAppWFVerId());
        }
        if (pSAppWFVerBase.isPSAppWFVerNameDirty() && (bl || pSAppWFVerBase.getPSAppWFVerName() != null)) {
            iDataObject.set(FIELD_PSAPPWFVERNAME, (Object)pSAppWFVerBase.getPSAppWFVerName());
        }
        if (pSAppWFVerBase.isPSSysAppIdDirty() && (bl || pSAppWFVerBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppWFVerBase.getPSSysAppId());
        }
        if (pSAppWFVerBase.isPSSysAppNameDirty() && (bl || pSAppWFVerBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppWFVerBase.getPSSysAppName());
        }
        if (pSAppWFVerBase.isPSWFVersionIdDirty() && (bl || pSAppWFVerBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSAppWFVerBase.getPSWFVersionId());
        }
        if (pSAppWFVerBase.isPSWFVersionNameDirty() && (bl || pSAppWFVerBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSAppWFVerBase.getPSWFVersionName());
        }
        if (pSAppWFVerBase.isPSWorkflowIdDirty() && (bl || pSAppWFVerBase.getPSWorkflowId() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWID, (Object)pSAppWFVerBase.getPSWorkflowId());
        }
        if (pSAppWFVerBase.isUpdateDateDirty() && (bl || pSAppWFVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppWFVerBase.getUpdateDate());
        }
        if (pSAppWFVerBase.isUpdateManDirty() && (bl || pSAppWFVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppWFVerBase.getUpdateMan());
        }
        if (pSAppWFVerBase.isUserCatDirty() && (bl || pSAppWFVerBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppWFVerBase.getUserCat());
        }
        if (pSAppWFVerBase.isUserTagDirty() && (bl || pSAppWFVerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppWFVerBase.getUserTag());
        }
        if (pSAppWFVerBase.isUserTag2Dirty() && (bl || pSAppWFVerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppWFVerBase.getUserTag2());
        }
        if (pSAppWFVerBase.isUserTag3Dirty() && (bl || pSAppWFVerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppWFVerBase.getUserTag3());
        }
        if (pSAppWFVerBase.isUserTag4Dirty() && (bl || pSAppWFVerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppWFVerBase.getUserTag4());
        }
        if (pSAppWFVerBase.isValidFlagDirty() && (bl || pSAppWFVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppWFVerBase.getValidFlag());
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
        return PSAppWFVerBase.remove(this, n);
    }

    private static boolean remove(PSAppWFVerBase pSAppWFVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppWFVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppWFVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppWFVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppWFVerBase.resetPSAppWFId();
                return true;
            }
            case 4: {
                pSAppWFVerBase.resetPSAppWFName();
                return true;
            }
            case 5: {
                pSAppWFVerBase.resetPSAppWFVerId();
                return true;
            }
            case 6: {
                pSAppWFVerBase.resetPSAppWFVerName();
                return true;
            }
            case 7: {
                pSAppWFVerBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSAppWFVerBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSAppWFVerBase.resetPSWFVersionId();
                return true;
            }
            case 10: {
                pSAppWFVerBase.resetPSWFVersionName();
                return true;
            }
            case 11: {
                pSAppWFVerBase.resetPSWorkflowId();
                return true;
            }
            case 12: {
                pSAppWFVerBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSAppWFVerBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSAppWFVerBase.resetUserCat();
                return true;
            }
            case 15: {
                pSAppWFVerBase.resetUserTag();
                return true;
            }
            case 16: {
                pSAppWFVerBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSAppWFVerBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSAppWFVerBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSAppWFVerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppWF getPSAppWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWF();
        }
        if (this.getPSAppWFId() == null) {
            return null;
        }
        Integer n = this.objPSAppWFLock;
        synchronized (n) {
            if (this.psappwf != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppWFId(), (Object)this.psappwf.getPSAppWFId()) != 0L) {
                this.psappwf = null;
            }
            if (this.psappwf == null) {
                PSAppWF pSAppWF = new PSAppWF();
                pSAppWF.setPSAppWFId(this.getPSAppWFId());
                PSAppWFService pSAppWFService = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
                pSAppWFService.autoGet((IEntity)pSAppWF);
                this.psappwf = pSAppWF;
            }
            return this.psappwf;
        }
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
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersion();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objPSWFVersionLock;
        synchronized (n) {
            if (this.pswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFVersionId(), (Object)this.pswfversion.getPSWFVersionId()) != 0L) {
                this.pswfversion = null;
            }
            if (this.pswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet((IEntity)pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    private PSAppWFVerBase getProxyEntity() {
        return this.proxyPSAppWFVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppWFVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppWFVerBase) {
            this.proxyPSAppWFVerBase = (PSAppWFVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppWFVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPWFID, 3);
        fieldIndexMap.put(FIELD_PSAPPWFNAME, 4);
        fieldIndexMap.put(FIELD_PSAPPWFVERID, 5);
        fieldIndexMap.put(FIELD_PSAPPWFVERNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 9);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 10);
        fieldIndexMap.put(FIELD_PSWORKFLOWID, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

