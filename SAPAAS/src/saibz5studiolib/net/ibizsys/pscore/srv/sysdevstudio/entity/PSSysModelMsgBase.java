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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelMsgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelMsgBase.class);
    public static final String FIELD_ALLUSERFLAG = "ALLUSERFLAG";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSMODELMSGID = "PSSYSMODELMSGID";
    public static final String FIELD_PSSYSMODELMSGNAME = "PSSYSMODELMSGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_TARGETUSER = "TARGETUSER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ALLUSERFLAG = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MSGTYPE = 4;
    private static final int INDEX_PSAPPVIEWID = 5;
    private static final int INDEX_PSAPPVIEWNAME = 6;
    private static final int INDEX_PSDEFID = 7;
    private static final int INDEX_PSDEFNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSDENAME = 10;
    private static final int INDEX_PSDEVIEWBASEID = 11;
    private static final int INDEX_PSDEVIEWBASENAME = 12;
    private static final int INDEX_PSSYSAPPID = 13;
    private static final int INDEX_PSSYSAPPNAME = 14;
    private static final int INDEX_PSSYSMODELMSGID = 15;
    private static final int INDEX_PSSYSMODELMSGNAME = 16;
    private static final int INDEX_PSSYSTEMID = 17;
    private static final int INDEX_PSSYSTEMNAME = 18;
    private static final int INDEX_PSWFID = 19;
    private static final int INDEX_PSWFNAME = 20;
    private static final int INDEX_PSWFVERSIONID = 21;
    private static final int INDEX_PSWFVERSIONNAME = 22;
    private static final int INDEX_TARGETUSER = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelMsgBase proxyPSSysModelMsgBase = null;
    private boolean alluserflagDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysmodelmsgidDirtyFlag = false;
    private boolean pssysmodelmsgnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean targetuserDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="alluserflag")
    private Integer alluserflag;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="msgtype")
    private String msgtype;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysmodelmsgid")
    private String pssysmodelmsgid;
    @Column(name="pssysmodelmsgname")
    private String pssysmodelmsgname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="targetuser")
    private String targetuser;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;

    public void setAllUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllUserFlag(n);
            return;
        }
        this.alluserflag = n;
        this.alluserflagDirtyFlag = true;
    }

    public Integer getAllUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllUserFlag();
        }
        return this.alluserflag;
    }

    public boolean isAllUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllUserFlagDirty();
        }
        return this.alluserflagDirtyFlag;
    }

    public void resetAllUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllUserFlag();
            return;
        }
        this.alluserflagDirtyFlag = false;
        this.alluserflag = null;
    }

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setMsgType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtype = string;
        this.msgtypeDirtyFlag = true;
    }

    public String getMsgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgType();
        }
        return this.msgtype;
    }

    public boolean isMsgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypeDirty();
        }
        return this.msgtypeDirtyFlag;
    }

    public void resetMsgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgType();
            return;
        }
        this.msgtypeDirtyFlag = false;
        this.msgtype = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
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

    public void setPSSysModelMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelmsgid = string;
        this.pssysmodelmsgidDirtyFlag = true;
    }

    public String getPSSysModelMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelMsgId();
        }
        return this.pssysmodelmsgid;
    }

    public boolean isPSSysModelMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelMsgIdDirty();
        }
        return this.pssysmodelmsgidDirtyFlag;
    }

    public void resetPSSysModelMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelMsgId();
            return;
        }
        this.pssysmodelmsgidDirtyFlag = false;
        this.pssysmodelmsgid = null;
    }

    public void setPSSysModelMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelmsgname = string;
        this.pssysmodelmsgnameDirtyFlag = true;
    }

    public String getPSSysModelMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelMsgName();
        }
        return this.pssysmodelmsgname;
    }

    public boolean isPSSysModelMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelMsgNameDirty();
        }
        return this.pssysmodelmsgnameDirtyFlag;
    }

    public void resetPSSysModelMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelMsgName();
            return;
        }
        this.pssysmodelmsgnameDirtyFlag = false;
        this.pssysmodelmsgname = null;
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

    public void setPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFId();
        }
        return this.pswfid;
    }

    public boolean isPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIdDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFId();
            return;
        }
        this.pswfidDirtyFlag = false;
        this.pswfid = null;
    }

    public void setPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfname = string;
        this.pswfnameDirtyFlag = true;
    }

    public String getPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFName();
        }
        return this.pswfname;
    }

    public boolean isPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFNameDirty();
        }
        return this.pswfnameDirtyFlag;
    }

    public void resetPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFName();
            return;
        }
        this.pswfnameDirtyFlag = false;
        this.pswfname = null;
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

    public void setTargetUser(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetUser(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetuser = string;
        this.targetuserDirtyFlag = true;
    }

    public String getTargetUser() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetUser();
        }
        return this.targetuser;
    }

    public boolean isTargetUserDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetUserDirty();
        }
        return this.targetuserDirtyFlag;
    }

    public void resetTargetUser() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetUser();
            return;
        }
        this.targetuserDirtyFlag = false;
        this.targetuser = null;
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
        PSSysModelMsgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelMsgBase pSSysModelMsgBase) {
        pSSysModelMsgBase.resetAllUserFlag();
        pSSysModelMsgBase.resetContent();
        pSSysModelMsgBase.resetCreateDate();
        pSSysModelMsgBase.resetCreateMan();
        pSSysModelMsgBase.resetMsgType();
        pSSysModelMsgBase.resetPSAppViewId();
        pSSysModelMsgBase.resetPSAppViewName();
        pSSysModelMsgBase.resetPSDEFId();
        pSSysModelMsgBase.resetPSDEFName();
        pSSysModelMsgBase.resetPSDEId();
        pSSysModelMsgBase.resetPSDEName();
        pSSysModelMsgBase.resetPSDEViewBaseId();
        pSSysModelMsgBase.resetPSDEViewBaseName();
        pSSysModelMsgBase.resetPSSysAppId();
        pSSysModelMsgBase.resetPSSysAppName();
        pSSysModelMsgBase.resetPSSysModelMsgId();
        pSSysModelMsgBase.resetPSSysModelMsgName();
        pSSysModelMsgBase.resetPSSystemId();
        pSSysModelMsgBase.resetPSSystemName();
        pSSysModelMsgBase.resetPSWFId();
        pSSysModelMsgBase.resetPSWFName();
        pSSysModelMsgBase.resetPSWFVersionId();
        pSSysModelMsgBase.resetPSWFVersionName();
        pSSysModelMsgBase.resetTargetUser();
        pSSysModelMsgBase.resetUpdateDate();
        pSSysModelMsgBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllUserFlagDirty()) {
            hashMap.put(FIELD_ALLUSERFLAG, this.getAllUserFlag());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMsgTypeDirty()) {
            hashMap.put(FIELD_MSGTYPE, this.getMsgType());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysModelMsgIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELMSGID, this.getPSSysModelMsgId());
        }
        if (!bl || this.isPSSysModelMsgNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELMSGNAME, this.getPSSysModelMsgName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFNameDirty()) {
            hashMap.put(FIELD_PSWFNAME, this.getPSWFName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isTargetUserDirty()) {
            hashMap.put(FIELD_TARGETUSER, this.getTargetUser());
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
        return PSSysModelMsgBase.get(this, n);
    }

    private static Object get(PSSysModelMsgBase pSSysModelMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelMsgBase.getAllUserFlag();
            }
            case 1: {
                return pSSysModelMsgBase.getContent();
            }
            case 2: {
                return pSSysModelMsgBase.getCreateDate();
            }
            case 3: {
                return pSSysModelMsgBase.getCreateMan();
            }
            case 4: {
                return pSSysModelMsgBase.getMsgType();
            }
            case 5: {
                return pSSysModelMsgBase.getPSAppViewId();
            }
            case 6: {
                return pSSysModelMsgBase.getPSAppViewName();
            }
            case 7: {
                return pSSysModelMsgBase.getPSDEFId();
            }
            case 8: {
                return pSSysModelMsgBase.getPSDEFName();
            }
            case 9: {
                return pSSysModelMsgBase.getPSDEId();
            }
            case 10: {
                return pSSysModelMsgBase.getPSDEName();
            }
            case 11: {
                return pSSysModelMsgBase.getPSDEViewBaseId();
            }
            case 12: {
                return pSSysModelMsgBase.getPSDEViewBaseName();
            }
            case 13: {
                return pSSysModelMsgBase.getPSSysAppId();
            }
            case 14: {
                return pSSysModelMsgBase.getPSSysAppName();
            }
            case 15: {
                return pSSysModelMsgBase.getPSSysModelMsgId();
            }
            case 16: {
                return pSSysModelMsgBase.getPSSysModelMsgName();
            }
            case 17: {
                return pSSysModelMsgBase.getPSSystemId();
            }
            case 18: {
                return pSSysModelMsgBase.getPSSystemName();
            }
            case 19: {
                return pSSysModelMsgBase.getPSWFId();
            }
            case 20: {
                return pSSysModelMsgBase.getPSWFName();
            }
            case 21: {
                return pSSysModelMsgBase.getPSWFVersionId();
            }
            case 22: {
                return pSSysModelMsgBase.getPSWFVersionName();
            }
            case 23: {
                return pSSysModelMsgBase.getTargetUser();
            }
            case 24: {
                return pSSysModelMsgBase.getUpdateDate();
            }
            case 25: {
                return pSSysModelMsgBase.getUpdateMan();
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
        PSSysModelMsgBase.set(this, n, object);
    }

    private static void set(PSSysModelMsgBase pSSysModelMsgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelMsgBase.setAllUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelMsgBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelMsgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelMsgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelMsgBase.setMsgType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelMsgBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelMsgBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelMsgBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelMsgBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelMsgBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelMsgBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelMsgBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelMsgBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelMsgBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelMsgBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelMsgBase.setPSSysModelMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelMsgBase.setPSSysModelMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelMsgBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysModelMsgBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysModelMsgBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysModelMsgBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysModelMsgBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysModelMsgBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysModelMsgBase.setTargetUser(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysModelMsgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSSysModelMsgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysModelMsgBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelMsgBase pSSysModelMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelMsgBase.getAllUserFlag() == null;
            }
            case 1: {
                return pSSysModelMsgBase.getContent() == null;
            }
            case 2: {
                return pSSysModelMsgBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysModelMsgBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysModelMsgBase.getMsgType() == null;
            }
            case 5: {
                return pSSysModelMsgBase.getPSAppViewId() == null;
            }
            case 6: {
                return pSSysModelMsgBase.getPSAppViewName() == null;
            }
            case 7: {
                return pSSysModelMsgBase.getPSDEFId() == null;
            }
            case 8: {
                return pSSysModelMsgBase.getPSDEFName() == null;
            }
            case 9: {
                return pSSysModelMsgBase.getPSDEId() == null;
            }
            case 10: {
                return pSSysModelMsgBase.getPSDEName() == null;
            }
            case 11: {
                return pSSysModelMsgBase.getPSDEViewBaseId() == null;
            }
            case 12: {
                return pSSysModelMsgBase.getPSDEViewBaseName() == null;
            }
            case 13: {
                return pSSysModelMsgBase.getPSSysAppId() == null;
            }
            case 14: {
                return pSSysModelMsgBase.getPSSysAppName() == null;
            }
            case 15: {
                return pSSysModelMsgBase.getPSSysModelMsgId() == null;
            }
            case 16: {
                return pSSysModelMsgBase.getPSSysModelMsgName() == null;
            }
            case 17: {
                return pSSysModelMsgBase.getPSSystemId() == null;
            }
            case 18: {
                return pSSysModelMsgBase.getPSSystemName() == null;
            }
            case 19: {
                return pSSysModelMsgBase.getPSWFId() == null;
            }
            case 20: {
                return pSSysModelMsgBase.getPSWFName() == null;
            }
            case 21: {
                return pSSysModelMsgBase.getPSWFVersionId() == null;
            }
            case 22: {
                return pSSysModelMsgBase.getPSWFVersionName() == null;
            }
            case 23: {
                return pSSysModelMsgBase.getTargetUser() == null;
            }
            case 24: {
                return pSSysModelMsgBase.getUpdateDate() == null;
            }
            case 25: {
                return pSSysModelMsgBase.getUpdateMan() == null;
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
        return PSSysModelMsgBase.contains(this, n);
    }

    private static boolean contains(PSSysModelMsgBase pSSysModelMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelMsgBase.isAllUserFlagDirty();
            }
            case 1: {
                return pSSysModelMsgBase.isContentDirty();
            }
            case 2: {
                return pSSysModelMsgBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysModelMsgBase.isCreateManDirty();
            }
            case 4: {
                return pSSysModelMsgBase.isMsgTypeDirty();
            }
            case 5: {
                return pSSysModelMsgBase.isPSAppViewIdDirty();
            }
            case 6: {
                return pSSysModelMsgBase.isPSAppViewNameDirty();
            }
            case 7: {
                return pSSysModelMsgBase.isPSDEFIdDirty();
            }
            case 8: {
                return pSSysModelMsgBase.isPSDEFNameDirty();
            }
            case 9: {
                return pSSysModelMsgBase.isPSDEIdDirty();
            }
            case 10: {
                return pSSysModelMsgBase.isPSDENameDirty();
            }
            case 11: {
                return pSSysModelMsgBase.isPSDEViewBaseIdDirty();
            }
            case 12: {
                return pSSysModelMsgBase.isPSDEViewBaseNameDirty();
            }
            case 13: {
                return pSSysModelMsgBase.isPSSysAppIdDirty();
            }
            case 14: {
                return pSSysModelMsgBase.isPSSysAppNameDirty();
            }
            case 15: {
                return pSSysModelMsgBase.isPSSysModelMsgIdDirty();
            }
            case 16: {
                return pSSysModelMsgBase.isPSSysModelMsgNameDirty();
            }
            case 17: {
                return pSSysModelMsgBase.isPSSystemIdDirty();
            }
            case 18: {
                return pSSysModelMsgBase.isPSSystemNameDirty();
            }
            case 19: {
                return pSSysModelMsgBase.isPSWFIdDirty();
            }
            case 20: {
                return pSSysModelMsgBase.isPSWFNameDirty();
            }
            case 21: {
                return pSSysModelMsgBase.isPSWFVersionIdDirty();
            }
            case 22: {
                return pSSysModelMsgBase.isPSWFVersionNameDirty();
            }
            case 23: {
                return pSSysModelMsgBase.isTargetUserDirty();
            }
            case 24: {
                return pSSysModelMsgBase.isUpdateDateDirty();
            }
            case 25: {
                return pSSysModelMsgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelMsgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelMsgBase pSSysModelMsgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelMsgBase.getAllUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alluserflag", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getAllUserFlag()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getContent()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getMsgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtype", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getMsgType()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSSysModelMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelmsgid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSSysModelMsgId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSSysModelMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelmsgname", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSSysModelMsgName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getTargetUser() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetuser", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getTargetUser()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelMsgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelMsgBase.getJSONValue((Object)pSSysModelMsgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelMsgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelMsgBase pSSysModelMsgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelMsgBase.getAllUserFlag() != null) {
            object = pSSysModelMsgBase.getAllUserFlag();
            xmlNode.setAttribute(FIELD_ALLUSERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelMsgBase.getContent() != null) {
            object = pSSysModelMsgBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getCreateDate() != null) {
            object = pSSysModelMsgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelMsgBase.getCreateMan() != null) {
            object = pSSysModelMsgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getMsgType() != null) {
            object = pSSysModelMsgBase.getMsgType();
            xmlNode.setAttribute(FIELD_MSGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSAppViewId() != null) {
            object = pSSysModelMsgBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSAppViewName() != null) {
            object = pSSysModelMsgBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSDEFId() != null) {
            object = pSSysModelMsgBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSDEFName() != null) {
            object = pSSysModelMsgBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSDEId() != null) {
            object = pSSysModelMsgBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSDEName() != null) {
            object = pSSysModelMsgBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSDEViewBaseId() != null) {
            object = pSSysModelMsgBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSDEViewBaseName() != null) {
            object = pSSysModelMsgBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSSysAppId() != null) {
            object = pSSysModelMsgBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSSysAppName() != null) {
            object = pSSysModelMsgBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSSysModelMsgId() != null) {
            object = pSSysModelMsgBase.getPSSysModelMsgId();
            xmlNode.setAttribute(FIELD_PSSYSMODELMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSSysModelMsgName() != null) {
            object = pSSysModelMsgBase.getPSSysModelMsgName();
            xmlNode.setAttribute(FIELD_PSSYSMODELMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSSystemId() != null) {
            object = pSSysModelMsgBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSSystemName() != null) {
            object = pSSysModelMsgBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSWFId() != null) {
            object = pSSysModelMsgBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSWFName() != null) {
            object = pSSysModelMsgBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSWFVersionId() != null) {
            object = pSSysModelMsgBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getPSWFVersionName() != null) {
            object = pSSysModelMsgBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getTargetUser() != null) {
            object = pSSysModelMsgBase.getTargetUser();
            xmlNode.setAttribute(FIELD_TARGETUSER, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelMsgBase.getUpdateDate() != null) {
            object = pSSysModelMsgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelMsgBase.getUpdateMan() != null) {
            object = pSSysModelMsgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelMsgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelMsgBase pSSysModelMsgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelMsgBase.isAllUserFlagDirty() && (bl || pSSysModelMsgBase.getAllUserFlag() != null)) {
            iDataObject.set(FIELD_ALLUSERFLAG, (Object)pSSysModelMsgBase.getAllUserFlag());
        }
        if (pSSysModelMsgBase.isContentDirty() && (bl || pSSysModelMsgBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysModelMsgBase.getContent());
        }
        if (pSSysModelMsgBase.isCreateDateDirty() && (bl || pSSysModelMsgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelMsgBase.getCreateDate());
        }
        if (pSSysModelMsgBase.isCreateManDirty() && (bl || pSSysModelMsgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelMsgBase.getCreateMan());
        }
        if (pSSysModelMsgBase.isMsgTypeDirty() && (bl || pSSysModelMsgBase.getMsgType() != null)) {
            iDataObject.set(FIELD_MSGTYPE, (Object)pSSysModelMsgBase.getMsgType());
        }
        if (pSSysModelMsgBase.isPSAppViewIdDirty() && (bl || pSSysModelMsgBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSSysModelMsgBase.getPSAppViewId());
        }
        if (pSSysModelMsgBase.isPSAppViewNameDirty() && (bl || pSSysModelMsgBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSSysModelMsgBase.getPSAppViewName());
        }
        if (pSSysModelMsgBase.isPSDEFIdDirty() && (bl || pSSysModelMsgBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysModelMsgBase.getPSDEFId());
        }
        if (pSSysModelMsgBase.isPSDEFNameDirty() && (bl || pSSysModelMsgBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysModelMsgBase.getPSDEFName());
        }
        if (pSSysModelMsgBase.isPSDEIdDirty() && (bl || pSSysModelMsgBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysModelMsgBase.getPSDEId());
        }
        if (pSSysModelMsgBase.isPSDENameDirty() && (bl || pSSysModelMsgBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysModelMsgBase.getPSDEName());
        }
        if (pSSysModelMsgBase.isPSDEViewBaseIdDirty() && (bl || pSSysModelMsgBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSSysModelMsgBase.getPSDEViewBaseId());
        }
        if (pSSysModelMsgBase.isPSDEViewBaseNameDirty() && (bl || pSSysModelMsgBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSSysModelMsgBase.getPSDEViewBaseName());
        }
        if (pSSysModelMsgBase.isPSSysAppIdDirty() && (bl || pSSysModelMsgBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysModelMsgBase.getPSSysAppId());
        }
        if (pSSysModelMsgBase.isPSSysAppNameDirty() && (bl || pSSysModelMsgBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysModelMsgBase.getPSSysAppName());
        }
        if (pSSysModelMsgBase.isPSSysModelMsgIdDirty() && (bl || pSSysModelMsgBase.getPSSysModelMsgId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELMSGID, (Object)pSSysModelMsgBase.getPSSysModelMsgId());
        }
        if (pSSysModelMsgBase.isPSSysModelMsgNameDirty() && (bl || pSSysModelMsgBase.getPSSysModelMsgName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELMSGNAME, (Object)pSSysModelMsgBase.getPSSysModelMsgName());
        }
        if (pSSysModelMsgBase.isPSSystemIdDirty() && (bl || pSSysModelMsgBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysModelMsgBase.getPSSystemId());
        }
        if (pSSysModelMsgBase.isPSSystemNameDirty() && (bl || pSSysModelMsgBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysModelMsgBase.getPSSystemName());
        }
        if (pSSysModelMsgBase.isPSWFIdDirty() && (bl || pSSysModelMsgBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSSysModelMsgBase.getPSWFId());
        }
        if (pSSysModelMsgBase.isPSWFNameDirty() && (bl || pSSysModelMsgBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSSysModelMsgBase.getPSWFName());
        }
        if (pSSysModelMsgBase.isPSWFVersionIdDirty() && (bl || pSSysModelMsgBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSSysModelMsgBase.getPSWFVersionId());
        }
        if (pSSysModelMsgBase.isPSWFVersionNameDirty() && (bl || pSSysModelMsgBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSSysModelMsgBase.getPSWFVersionName());
        }
        if (pSSysModelMsgBase.isTargetUserDirty() && (bl || pSSysModelMsgBase.getTargetUser() != null)) {
            iDataObject.set(FIELD_TARGETUSER, (Object)pSSysModelMsgBase.getTargetUser());
        }
        if (pSSysModelMsgBase.isUpdateDateDirty() && (bl || pSSysModelMsgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelMsgBase.getUpdateDate());
        }
        if (pSSysModelMsgBase.isUpdateManDirty() && (bl || pSSysModelMsgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelMsgBase.getUpdateMan());
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
        return PSSysModelMsgBase.remove(this, n);
    }

    private static boolean remove(PSSysModelMsgBase pSSysModelMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelMsgBase.resetAllUserFlag();
                return true;
            }
            case 1: {
                pSSysModelMsgBase.resetContent();
                return true;
            }
            case 2: {
                pSSysModelMsgBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysModelMsgBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysModelMsgBase.resetMsgType();
                return true;
            }
            case 5: {
                pSSysModelMsgBase.resetPSAppViewId();
                return true;
            }
            case 6: {
                pSSysModelMsgBase.resetPSAppViewName();
                return true;
            }
            case 7: {
                pSSysModelMsgBase.resetPSDEFId();
                return true;
            }
            case 8: {
                pSSysModelMsgBase.resetPSDEFName();
                return true;
            }
            case 9: {
                pSSysModelMsgBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSSysModelMsgBase.resetPSDEName();
                return true;
            }
            case 11: {
                pSSysModelMsgBase.resetPSDEViewBaseId();
                return true;
            }
            case 12: {
                pSSysModelMsgBase.resetPSDEViewBaseName();
                return true;
            }
            case 13: {
                pSSysModelMsgBase.resetPSSysAppId();
                return true;
            }
            case 14: {
                pSSysModelMsgBase.resetPSSysAppName();
                return true;
            }
            case 15: {
                pSSysModelMsgBase.resetPSSysModelMsgId();
                return true;
            }
            case 16: {
                pSSysModelMsgBase.resetPSSysModelMsgName();
                return true;
            }
            case 17: {
                pSSysModelMsgBase.resetPSSystemId();
                return true;
            }
            case 18: {
                pSSysModelMsgBase.resetPSSystemName();
                return true;
            }
            case 19: {
                pSSysModelMsgBase.resetPSWFId();
                return true;
            }
            case 20: {
                pSSysModelMsgBase.resetPSWFName();
                return true;
            }
            case 21: {
                pSSysModelMsgBase.resetPSWFVersionId();
                return true;
            }
            case 22: {
                pSSysModelMsgBase.resetPSWFVersionName();
                return true;
            }
            case 23: {
                pSSysModelMsgBase.resetTargetUser();
                return true;
            }
            case 24: {
                pSSysModelMsgBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSSysModelMsgBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWF();
        }
        if (this.getPSWFId() == null) {
            return null;
        }
        Integer n = this.objPSWFLock;
        synchronized (n) {
            if (this.pswf != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFId(), (Object)this.pswf.getPSWorkflowId()) != 0L) {
                this.pswf = null;
            }
            if (this.pswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.pswf = pSWorkflow;
            }
            return this.pswf;
        }
    }

    private PSSysModelMsgBase getProxyEntity() {
        return this.proxyPSSysModelMsgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelMsgBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelMsgBase) {
            this.proxyPSSysModelMsgBase = (PSSysModelMsgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelMsgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLUSERFLAG, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MSGTYPE, 4);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 5);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 6);
        fieldIndexMap.put(FIELD_PSDEFID, 7);
        fieldIndexMap.put(FIELD_PSDEFNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSDENAME, 10);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 11);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 13);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSMODELMSGID, 15);
        fieldIndexMap.put(FIELD_PSSYSMODELMSGNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 18);
        fieldIndexMap.put(FIELD_PSWFID, 19);
        fieldIndexMap.put(FIELD_PSWFNAME, 20);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 21);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 22);
        fieldIndexMap.put(FIELD_TARGETUSER, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
    }
}

