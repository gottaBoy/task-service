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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcSubWFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFProcSubWFBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EMBEDPSDEDSID = "EMBEDPSDEDSID";
    public static final String FIELD_EMBEDPSDEDSNAME = "EMBEDPSDEDSNAME";
    public static final String FIELD_EMBEDPSDEID = "EMBEDPSDEID";
    public static final String FIELD_EMBEDPSWFDEID = "EMBEDPSWFDEID";
    public static final String FIELD_EMBEDPSWFDENAME = "EMBEDPSWFDENAME";
    public static final String FIELD_EMBEDPSWFID = "EMBEDPSWFID";
    public static final String FIELD_EMBEDPSWFNAME = "EMBEDPSWFNAME";
    public static final String FIELD_EMBEDPSWFVERID = "EMBEDPSWFVERID";
    public static final String FIELD_EMBEDPSWFVERNAME = "EMBEDPSWFVERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String FIELD_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String FIELD_PSWFPROCSUBWFID = "PSWFPROCSUBWFID";
    public static final String FIELD_PSWFPROCSUBWFNAME = "PSWFPROCSUBWFNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_SUSPENDDEFAULT = "SUSPENDDEFAULT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_EMBEDPSDEDSID = 4;
    private static final int INDEX_EMBEDPSDEDSNAME = 5;
    private static final int INDEX_EMBEDPSDEID = 6;
    private static final int INDEX_EMBEDPSWFDEID = 7;
    private static final int INDEX_EMBEDPSWFDENAME = 8;
    private static final int INDEX_EMBEDPSWFID = 9;
    private static final int INDEX_EMBEDPSWFNAME = 10;
    private static final int INDEX_EMBEDPSWFVERID = 11;
    private static final int INDEX_EMBEDPSWFVERNAME = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_PSDYNAINSTID = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PSWFID = 16;
    private static final int INDEX_PSWFPROCESSID = 17;
    private static final int INDEX_PSWFPROCESSNAME = 18;
    private static final int INDEX_PSWFPROCSUBWFID = 19;
    private static final int INDEX_PSWFPROCSUBWFNAME = 20;
    private static final int INDEX_PSWFVERSIONID = 21;
    private static final int INDEX_SUSPENDDEFAULT = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERDATA = 26;
    private static final int INDEX_USERDATA2 = 27;
    private static final int INDEX_USERTAG = 28;
    private static final int INDEX_USERTAG2 = 29;
    private static final int INDEX_USERTAG3 = 30;
    private static final int INDEX_USERTAG4 = 31;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFProcSubWFBase proxyPSWFProcSubWFBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean embedpsdedsidDirtyFlag = false;
    private boolean embedpsdedsnameDirtyFlag = false;
    private boolean embedpsdeidDirtyFlag = false;
    private boolean embedpswfdeidDirtyFlag = false;
    private boolean embedpswfdenameDirtyFlag = false;
    private boolean embedpswfidDirtyFlag = false;
    private boolean embedpswfnameDirtyFlag = false;
    private boolean embedpswfveridDirtyFlag = false;
    private boolean embedpswfvernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfprocessidDirtyFlag = false;
    private boolean pswfprocessnameDirtyFlag = false;
    private boolean pswfprocsubwfidDirtyFlag = false;
    private boolean pswfprocsubwfnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean suspenddefaultDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="embedpsdedsid")
    private String embedpsdedsid;
    @Column(name="embedpsdedsname")
    private String embedpsdedsname;
    @Column(name="embedpsdeid")
    private String embedpsdeid;
    @Column(name="embedpswfdeid")
    private String embedpswfdeid;
    @Column(name="embedpswfdename")
    private String embedpswfdename;
    @Column(name="embedpswfid")
    private String embedpswfid;
    @Column(name="embedpswfname")
    private String embedpswfname;
    @Column(name="embedpswfverid")
    private String embedpswfverid;
    @Column(name="embedpswfvername")
    private String embedpswfvername;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfprocessid")
    private String pswfprocessid;
    @Column(name="pswfprocessname")
    private String pswfprocessname;
    @Column(name="pswfprocsubwfid")
    private String pswfprocsubwfid;
    @Column(name="pswfprocsubwfname")
    private String pswfprocsubwfname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="suspenddefault")
    private Integer suspenddefault;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objEmbedPSDEDSLock = new Integer(1);
    private PSDEDataSet embedpsdeds = null;
    private Integer objEmbedPSWFDELock = new Integer(1);
    private PSWFDE embedpswfde = null;
    private Integer objPSWFProcessLock = new Integer(1);
    private PSWFProcess pswfprocess = null;
    private Integer objEmbedPSWFVerLock = new Integer(1);
    private PSWFVersion embedpswfver = null;
    private Integer objEmbedPSWFLock = new Integer(1);
    private PSWorkflow embedpswf = null;

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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setEmbedPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpsdedsid = string;
        this.embedpsdedsidDirtyFlag = true;
    }

    public String getEmbedPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSDEDSId();
        }
        return this.embedpsdedsid;
    }

    public boolean isEmbedPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSDEDSIdDirty();
        }
        return this.embedpsdedsidDirtyFlag;
    }

    public void resetEmbedPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSDEDSId();
            return;
        }
        this.embedpsdedsidDirtyFlag = false;
        this.embedpsdedsid = null;
    }

    public void setEmbedPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpsdedsname = string;
        this.embedpsdedsnameDirtyFlag = true;
    }

    public String getEmbedPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSDEDSName();
        }
        return this.embedpsdedsname;
    }

    public boolean isEmbedPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSDEDSNameDirty();
        }
        return this.embedpsdedsnameDirtyFlag;
    }

    public void resetEmbedPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSDEDSName();
            return;
        }
        this.embedpsdedsnameDirtyFlag = false;
        this.embedpsdedsname = null;
    }

    public void setEmbedPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpsdeid = string;
        this.embedpsdeidDirtyFlag = true;
    }

    public String getEmbedPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSDEId();
        }
        return this.embedpsdeid;
    }

    public boolean isEmbedPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSDEIdDirty();
        }
        return this.embedpsdeidDirtyFlag;
    }

    public void resetEmbedPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSDEId();
            return;
        }
        this.embedpsdeidDirtyFlag = false;
        this.embedpsdeid = null;
    }

    public void setEmbedPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfdeid = string;
        this.embedpswfdeidDirtyFlag = true;
    }

    public String getEmbedPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFDEId();
        }
        return this.embedpswfdeid;
    }

    public boolean isEmbedPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFDEIdDirty();
        }
        return this.embedpswfdeidDirtyFlag;
    }

    public void resetEmbedPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFDEId();
            return;
        }
        this.embedpswfdeidDirtyFlag = false;
        this.embedpswfdeid = null;
    }

    public void setEmbedPSWFDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfdename = string;
        this.embedpswfdenameDirtyFlag = true;
    }

    public String getEmbedPSWFDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFDEName();
        }
        return this.embedpswfdename;
    }

    public boolean isEmbedPSWFDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFDENameDirty();
        }
        return this.embedpswfdenameDirtyFlag;
    }

    public void resetEmbedPSWFDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFDEName();
            return;
        }
        this.embedpswfdenameDirtyFlag = false;
        this.embedpswfdename = null;
    }

    public void setEmbedPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfid = string;
        this.embedpswfidDirtyFlag = true;
    }

    public String getEmbedPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFId();
        }
        return this.embedpswfid;
    }

    public boolean isEmbedPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFIdDirty();
        }
        return this.embedpswfidDirtyFlag;
    }

    public void resetEmbedPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFId();
            return;
        }
        this.embedpswfidDirtyFlag = false;
        this.embedpswfid = null;
    }

    public void setEmbedPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfname = string;
        this.embedpswfnameDirtyFlag = true;
    }

    public String getEmbedPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFName();
        }
        return this.embedpswfname;
    }

    public boolean isEmbedPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFNameDirty();
        }
        return this.embedpswfnameDirtyFlag;
    }

    public void resetEmbedPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFName();
            return;
        }
        this.embedpswfnameDirtyFlag = false;
        this.embedpswfname = null;
    }

    public void setEmbedPSWFVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfverid = string;
        this.embedpswfveridDirtyFlag = true;
    }

    public String getEmbedPSWFVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFVerId();
        }
        return this.embedpswfverid;
    }

    public boolean isEmbedPSWFVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFVerIdDirty();
        }
        return this.embedpswfveridDirtyFlag;
    }

    public void resetEmbedPSWFVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFVerId();
            return;
        }
        this.embedpswfveridDirtyFlag = false;
        this.embedpswfverid = null;
    }

    public void setEmbedPSWFVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedPSWFVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.embedpswfvername = string;
        this.embedpswfvernameDirtyFlag = true;
    }

    public String getEmbedPSWFVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFVerName();
        }
        return this.embedpswfvername;
    }

    public boolean isEmbedPSWFVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedPSWFVerNameDirty();
        }
        return this.embedpswfvernameDirtyFlag;
    }

    public void resetEmbedPSWFVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedPSWFVerName();
            return;
        }
        this.embedpswfvernameDirtyFlag = false;
        this.embedpswfvername = null;
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

    public void setPSWFProcessId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocessid = string;
        this.pswfprocessidDirtyFlag = true;
    }

    public String getPSWFProcessId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessId();
        }
        return this.pswfprocessid;
    }

    public boolean isPSWFProcessIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessIdDirty();
        }
        return this.pswfprocessidDirtyFlag;
    }

    public void resetPSWFProcessId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessId();
            return;
        }
        this.pswfprocessidDirtyFlag = false;
        this.pswfprocessid = null;
    }

    public void setPSWFProcessName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocessname = string;
        this.pswfprocessnameDirtyFlag = true;
    }

    public String getPSWFProcessName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessName();
        }
        return this.pswfprocessname;
    }

    public boolean isPSWFProcessNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessNameDirty();
        }
        return this.pswfprocessnameDirtyFlag;
    }

    public void resetPSWFProcessName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessName();
            return;
        }
        this.pswfprocessnameDirtyFlag = false;
        this.pswfprocessname = null;
    }

    public void setPSWFProcSubWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcSubWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocsubwfid = string;
        this.pswfprocsubwfidDirtyFlag = true;
    }

    public String getPSWFProcSubWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcSubWFId();
        }
        return this.pswfprocsubwfid;
    }

    public boolean isPSWFProcSubWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcSubWFIdDirty();
        }
        return this.pswfprocsubwfidDirtyFlag;
    }

    public void resetPSWFProcSubWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcSubWFId();
            return;
        }
        this.pswfprocsubwfidDirtyFlag = false;
        this.pswfprocsubwfid = null;
    }

    public void setPSWFProcSubWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcSubWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocsubwfname = string;
        this.pswfprocsubwfnameDirtyFlag = true;
    }

    public String getPSWFProcSubWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcSubWFName();
        }
        return this.pswfprocsubwfname;
    }

    public boolean isPSWFProcSubWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcSubWFNameDirty();
        }
        return this.pswfprocsubwfnameDirtyFlag;
    }

    public void resetPSWFProcSubWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcSubWFName();
            return;
        }
        this.pswfprocsubwfnameDirtyFlag = false;
        this.pswfprocsubwfname = null;
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

    public void setSuspendDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSuspendDefault(n);
            return;
        }
        this.suspenddefault = n;
        this.suspenddefaultDirtyFlag = true;
    }

    public Integer getSuspendDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSuspendDefault();
        }
        return this.suspenddefault;
    }

    public boolean isSuspendDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSuspendDefaultDirty();
        }
        return this.suspenddefaultDirtyFlag;
    }

    public void resetSuspendDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSuspendDefault();
            return;
        }
        this.suspenddefaultDirtyFlag = false;
        this.suspenddefault = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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

    protected void onReset() {
        PSWFProcSubWFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFProcSubWFBase pSWFProcSubWFBase) {
        pSWFProcSubWFBase.resetCodeName();
        pSWFProcSubWFBase.resetCreateDate();
        pSWFProcSubWFBase.resetCreateMan();
        pSWFProcSubWFBase.resetDynaModelFlag();
        pSWFProcSubWFBase.resetEmbedPSDEDSId();
        pSWFProcSubWFBase.resetEmbedPSDEDSName();
        pSWFProcSubWFBase.resetEmbedPSDEId();
        pSWFProcSubWFBase.resetEmbedPSWFDEId();
        pSWFProcSubWFBase.resetEmbedPSWFDEName();
        pSWFProcSubWFBase.resetEmbedPSWFId();
        pSWFProcSubWFBase.resetEmbedPSWFName();
        pSWFProcSubWFBase.resetEmbedPSWFVerId();
        pSWFProcSubWFBase.resetEmbedPSWFVerName();
        pSWFProcSubWFBase.resetMemo();
        pSWFProcSubWFBase.resetPSDynaInstId();
        pSWFProcSubWFBase.resetPSSystemId();
        pSWFProcSubWFBase.resetPSWFId();
        pSWFProcSubWFBase.resetPSWFProcessId();
        pSWFProcSubWFBase.resetPSWFProcessName();
        pSWFProcSubWFBase.resetPSWFProcSubWFId();
        pSWFProcSubWFBase.resetPSWFProcSubWFName();
        pSWFProcSubWFBase.resetPSWFVersionId();
        pSWFProcSubWFBase.resetSuspendDefault();
        pSWFProcSubWFBase.resetUpdateDate();
        pSWFProcSubWFBase.resetUpdateMan();
        pSWFProcSubWFBase.resetUserCat();
        pSWFProcSubWFBase.resetUserData();
        pSWFProcSubWFBase.resetUserData2();
        pSWFProcSubWFBase.resetUserTag();
        pSWFProcSubWFBase.resetUserTag2();
        pSWFProcSubWFBase.resetUserTag3();
        pSWFProcSubWFBase.resetUserTag4();
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEmbedPSDEDSIdDirty()) {
            hashMap.put(FIELD_EMBEDPSDEDSID, this.getEmbedPSDEDSId());
        }
        if (!bl || this.isEmbedPSDEDSNameDirty()) {
            hashMap.put(FIELD_EMBEDPSDEDSNAME, this.getEmbedPSDEDSName());
        }
        if (!bl || this.isEmbedPSDEIdDirty()) {
            hashMap.put(FIELD_EMBEDPSDEID, this.getEmbedPSDEId());
        }
        if (!bl || this.isEmbedPSWFDEIdDirty()) {
            hashMap.put(FIELD_EMBEDPSWFDEID, this.getEmbedPSWFDEId());
        }
        if (!bl || this.isEmbedPSWFDENameDirty()) {
            hashMap.put(FIELD_EMBEDPSWFDENAME, this.getEmbedPSWFDEName());
        }
        if (!bl || this.isEmbedPSWFIdDirty()) {
            hashMap.put(FIELD_EMBEDPSWFID, this.getEmbedPSWFId());
        }
        if (!bl || this.isEmbedPSWFNameDirty()) {
            hashMap.put(FIELD_EMBEDPSWFNAME, this.getEmbedPSWFName());
        }
        if (!bl || this.isEmbedPSWFVerIdDirty()) {
            hashMap.put(FIELD_EMBEDPSWFVERID, this.getEmbedPSWFVerId());
        }
        if (!bl || this.isEmbedPSWFVerNameDirty()) {
            hashMap.put(FIELD_EMBEDPSWFVERNAME, this.getEmbedPSWFVerName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFProcessIdDirty()) {
            hashMap.put(FIELD_PSWFPROCESSID, this.getPSWFProcessId());
        }
        if (!bl || this.isPSWFProcessNameDirty()) {
            hashMap.put(FIELD_PSWFPROCESSNAME, this.getPSWFProcessName());
        }
        if (!bl || this.isPSWFProcSubWFIdDirty()) {
            hashMap.put(FIELD_PSWFPROCSUBWFID, this.getPSWFProcSubWFId());
        }
        if (!bl || this.isPSWFProcSubWFNameDirty()) {
            hashMap.put(FIELD_PSWFPROCSUBWFNAME, this.getPSWFProcSubWFName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isSuspendDefaultDirty()) {
            hashMap.put(FIELD_SUSPENDDEFAULT, this.getSuspendDefault());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        return PSWFProcSubWFBase.get(this, n);
    }

    private static Object get(PSWFProcSubWFBase pSWFProcSubWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcSubWFBase.getCodeName();
            }
            case 1: {
                return pSWFProcSubWFBase.getCreateDate();
            }
            case 2: {
                return pSWFProcSubWFBase.getCreateMan();
            }
            case 3: {
                return pSWFProcSubWFBase.getDynaModelFlag();
            }
            case 4: {
                return pSWFProcSubWFBase.getEmbedPSDEDSId();
            }
            case 5: {
                return pSWFProcSubWFBase.getEmbedPSDEDSName();
            }
            case 6: {
                return pSWFProcSubWFBase.getEmbedPSDEId();
            }
            case 7: {
                return pSWFProcSubWFBase.getEmbedPSWFDEId();
            }
            case 8: {
                return pSWFProcSubWFBase.getEmbedPSWFDEName();
            }
            case 9: {
                return pSWFProcSubWFBase.getEmbedPSWFId();
            }
            case 10: {
                return pSWFProcSubWFBase.getEmbedPSWFName();
            }
            case 11: {
                return pSWFProcSubWFBase.getEmbedPSWFVerId();
            }
            case 12: {
                return pSWFProcSubWFBase.getEmbedPSWFVerName();
            }
            case 13: {
                return pSWFProcSubWFBase.getMemo();
            }
            case 14: {
                return pSWFProcSubWFBase.getPSDynaInstId();
            }
            case 15: {
                return pSWFProcSubWFBase.getPSSystemId();
            }
            case 16: {
                return pSWFProcSubWFBase.getPSWFId();
            }
            case 17: {
                return pSWFProcSubWFBase.getPSWFProcessId();
            }
            case 18: {
                return pSWFProcSubWFBase.getPSWFProcessName();
            }
            case 19: {
                return pSWFProcSubWFBase.getPSWFProcSubWFId();
            }
            case 20: {
                return pSWFProcSubWFBase.getPSWFProcSubWFName();
            }
            case 21: {
                return pSWFProcSubWFBase.getPSWFVersionId();
            }
            case 22: {
                return pSWFProcSubWFBase.getSuspendDefault();
            }
            case 23: {
                return pSWFProcSubWFBase.getUpdateDate();
            }
            case 24: {
                return pSWFProcSubWFBase.getUpdateMan();
            }
            case 25: {
                return pSWFProcSubWFBase.getUserCat();
            }
            case 26: {
                return pSWFProcSubWFBase.getUserData();
            }
            case 27: {
                return pSWFProcSubWFBase.getUserData2();
            }
            case 28: {
                return pSWFProcSubWFBase.getUserTag();
            }
            case 29: {
                return pSWFProcSubWFBase.getUserTag2();
            }
            case 30: {
                return pSWFProcSubWFBase.getUserTag3();
            }
            case 31: {
                return pSWFProcSubWFBase.getUserTag4();
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
        PSWFProcSubWFBase.set(this, n, object);
    }

    private static void set(PSWFProcSubWFBase pSWFProcSubWFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcSubWFBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFProcSubWFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWFProcSubWFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFProcSubWFBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWFProcSubWFBase.setEmbedPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFProcSubWFBase.setEmbedPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFProcSubWFBase.setEmbedPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFProcSubWFBase.setEmbedPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFProcSubWFBase.setEmbedPSWFDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFProcSubWFBase.setEmbedPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFProcSubWFBase.setEmbedPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFProcSubWFBase.setEmbedPSWFVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFProcSubWFBase.setEmbedPSWFVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFProcSubWFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFProcSubWFBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFProcSubWFBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFProcSubWFBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFProcSubWFBase.setPSWFProcessId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFProcSubWFBase.setPSWFProcessName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFProcSubWFBase.setPSWFProcSubWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFProcSubWFBase.setPSWFProcSubWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFProcSubWFBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFProcSubWFBase.setSuspendDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSWFProcSubWFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSWFProcSubWFBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWFProcSubWFBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWFProcSubWFBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWFProcSubWFBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWFProcSubWFBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWFProcSubWFBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSWFProcSubWFBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSWFProcSubWFBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSWFProcSubWFBase.isNull(this, n);
    }

    private static boolean isNull(PSWFProcSubWFBase pSWFProcSubWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcSubWFBase.getCodeName() == null;
            }
            case 1: {
                return pSWFProcSubWFBase.getCreateDate() == null;
            }
            case 2: {
                return pSWFProcSubWFBase.getCreateMan() == null;
            }
            case 3: {
                return pSWFProcSubWFBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSWFProcSubWFBase.getEmbedPSDEDSId() == null;
            }
            case 5: {
                return pSWFProcSubWFBase.getEmbedPSDEDSName() == null;
            }
            case 6: {
                return pSWFProcSubWFBase.getEmbedPSDEId() == null;
            }
            case 7: {
                return pSWFProcSubWFBase.getEmbedPSWFDEId() == null;
            }
            case 8: {
                return pSWFProcSubWFBase.getEmbedPSWFDEName() == null;
            }
            case 9: {
                return pSWFProcSubWFBase.getEmbedPSWFId() == null;
            }
            case 10: {
                return pSWFProcSubWFBase.getEmbedPSWFName() == null;
            }
            case 11: {
                return pSWFProcSubWFBase.getEmbedPSWFVerId() == null;
            }
            case 12: {
                return pSWFProcSubWFBase.getEmbedPSWFVerName() == null;
            }
            case 13: {
                return pSWFProcSubWFBase.getMemo() == null;
            }
            case 14: {
                return pSWFProcSubWFBase.getPSDynaInstId() == null;
            }
            case 15: {
                return pSWFProcSubWFBase.getPSSystemId() == null;
            }
            case 16: {
                return pSWFProcSubWFBase.getPSWFId() == null;
            }
            case 17: {
                return pSWFProcSubWFBase.getPSWFProcessId() == null;
            }
            case 18: {
                return pSWFProcSubWFBase.getPSWFProcessName() == null;
            }
            case 19: {
                return pSWFProcSubWFBase.getPSWFProcSubWFId() == null;
            }
            case 20: {
                return pSWFProcSubWFBase.getPSWFProcSubWFName() == null;
            }
            case 21: {
                return pSWFProcSubWFBase.getPSWFVersionId() == null;
            }
            case 22: {
                return pSWFProcSubWFBase.getSuspendDefault() == null;
            }
            case 23: {
                return pSWFProcSubWFBase.getUpdateDate() == null;
            }
            case 24: {
                return pSWFProcSubWFBase.getUpdateMan() == null;
            }
            case 25: {
                return pSWFProcSubWFBase.getUserCat() == null;
            }
            case 26: {
                return pSWFProcSubWFBase.getUserData() == null;
            }
            case 27: {
                return pSWFProcSubWFBase.getUserData2() == null;
            }
            case 28: {
                return pSWFProcSubWFBase.getUserTag() == null;
            }
            case 29: {
                return pSWFProcSubWFBase.getUserTag2() == null;
            }
            case 30: {
                return pSWFProcSubWFBase.getUserTag3() == null;
            }
            case 31: {
                return pSWFProcSubWFBase.getUserTag4() == null;
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
        return PSWFProcSubWFBase.contains(this, n);
    }

    private static boolean contains(PSWFProcSubWFBase pSWFProcSubWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcSubWFBase.isCodeNameDirty();
            }
            case 1: {
                return pSWFProcSubWFBase.isCreateDateDirty();
            }
            case 2: {
                return pSWFProcSubWFBase.isCreateManDirty();
            }
            case 3: {
                return pSWFProcSubWFBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSWFProcSubWFBase.isEmbedPSDEDSIdDirty();
            }
            case 5: {
                return pSWFProcSubWFBase.isEmbedPSDEDSNameDirty();
            }
            case 6: {
                return pSWFProcSubWFBase.isEmbedPSDEIdDirty();
            }
            case 7: {
                return pSWFProcSubWFBase.isEmbedPSWFDEIdDirty();
            }
            case 8: {
                return pSWFProcSubWFBase.isEmbedPSWFDENameDirty();
            }
            case 9: {
                return pSWFProcSubWFBase.isEmbedPSWFIdDirty();
            }
            case 10: {
                return pSWFProcSubWFBase.isEmbedPSWFNameDirty();
            }
            case 11: {
                return pSWFProcSubWFBase.isEmbedPSWFVerIdDirty();
            }
            case 12: {
                return pSWFProcSubWFBase.isEmbedPSWFVerNameDirty();
            }
            case 13: {
                return pSWFProcSubWFBase.isMemoDirty();
            }
            case 14: {
                return pSWFProcSubWFBase.isPSDynaInstIdDirty();
            }
            case 15: {
                return pSWFProcSubWFBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSWFProcSubWFBase.isPSWFIdDirty();
            }
            case 17: {
                return pSWFProcSubWFBase.isPSWFProcessIdDirty();
            }
            case 18: {
                return pSWFProcSubWFBase.isPSWFProcessNameDirty();
            }
            case 19: {
                return pSWFProcSubWFBase.isPSWFProcSubWFIdDirty();
            }
            case 20: {
                return pSWFProcSubWFBase.isPSWFProcSubWFNameDirty();
            }
            case 21: {
                return pSWFProcSubWFBase.isPSWFVersionIdDirty();
            }
            case 22: {
                return pSWFProcSubWFBase.isSuspendDefaultDirty();
            }
            case 23: {
                return pSWFProcSubWFBase.isUpdateDateDirty();
            }
            case 24: {
                return pSWFProcSubWFBase.isUpdateManDirty();
            }
            case 25: {
                return pSWFProcSubWFBase.isUserCatDirty();
            }
            case 26: {
                return pSWFProcSubWFBase.isUserDataDirty();
            }
            case 27: {
                return pSWFProcSubWFBase.isUserData2Dirty();
            }
            case 28: {
                return pSWFProcSubWFBase.isUserTagDirty();
            }
            case 29: {
                return pSWFProcSubWFBase.isUserTag2Dirty();
            }
            case 30: {
                return pSWFProcSubWFBase.isUserTag3Dirty();
            }
            case 31: {
                return pSWFProcSubWFBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFProcSubWFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFProcSubWFBase pSWFProcSubWFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFProcSubWFBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpsdedsid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSDEDSId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpsdedsname", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSDEDSName()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpsdeid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSDEId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfdeid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSWFDEId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfdename", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSWFDEName()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSWFId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfname", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSWFName()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfverid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSWFVerId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedpswfvername", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getEmbedPSWFVerName()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getPSWFProcessId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getPSWFProcessId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getPSWFProcessName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessname", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getPSWFProcessName()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getPSWFProcSubWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocsubwfid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getPSWFProcSubWFId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getPSWFProcSubWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocsubwfname", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getPSWFProcSubWFName()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getSuspendDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"suspenddefault", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getSuspendDefault()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUserData()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUserData2()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFProcSubWFBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFProcSubWFBase.getJSONValue((Object)pSWFProcSubWFBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFProcSubWFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFProcSubWFBase pSWFProcSubWFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFProcSubWFBase.getCodeName() != null) {
            object = pSWFProcSubWFBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getCreateDate() != null) {
            object = pSWFProcSubWFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcSubWFBase.getCreateMan() != null) {
            object = pSWFProcSubWFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getDynaModelFlag() != null) {
            object = pSWFProcSubWFBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSDEDSId() != null) {
            object = pSWFProcSubWFBase.getEmbedPSDEDSId();
            xmlNode.setAttribute(FIELD_EMBEDPSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSDEDSName() != null) {
            object = pSWFProcSubWFBase.getEmbedPSDEDSName();
            xmlNode.setAttribute(FIELD_EMBEDPSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSDEId() != null) {
            object = pSWFProcSubWFBase.getEmbedPSDEId();
            xmlNode.setAttribute(FIELD_EMBEDPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFDEId() != null) {
            object = pSWFProcSubWFBase.getEmbedPSWFDEId();
            xmlNode.setAttribute(FIELD_EMBEDPSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFDEName() != null) {
            object = pSWFProcSubWFBase.getEmbedPSWFDEName();
            xmlNode.setAttribute(FIELD_EMBEDPSWFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFId() != null) {
            object = pSWFProcSubWFBase.getEmbedPSWFId();
            xmlNode.setAttribute(FIELD_EMBEDPSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFName() != null) {
            object = pSWFProcSubWFBase.getEmbedPSWFName();
            xmlNode.setAttribute(FIELD_EMBEDPSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFVerId() != null) {
            object = pSWFProcSubWFBase.getEmbedPSWFVerId();
            xmlNode.setAttribute(FIELD_EMBEDPSWFVERID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getEmbedPSWFVerName() != null) {
            object = pSWFProcSubWFBase.getEmbedPSWFVerName();
            xmlNode.setAttribute(FIELD_EMBEDPSWFVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getMemo() != null) {
            object = pSWFProcSubWFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getPSDynaInstId() != null) {
            object = pSWFProcSubWFBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getPSSystemId() != null) {
            object = pSWFProcSubWFBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getPSWFId() != null) {
            object = pSWFProcSubWFBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getPSWFProcessId() != null) {
            object = pSWFProcSubWFBase.getPSWFProcessId();
            xmlNode.setAttribute(FIELD_PSWFPROCESSID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getPSWFProcessName() != null) {
            object = pSWFProcSubWFBase.getPSWFProcessName();
            xmlNode.setAttribute(FIELD_PSWFPROCESSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getPSWFProcSubWFId() != null) {
            object = pSWFProcSubWFBase.getPSWFProcSubWFId();
            xmlNode.setAttribute(FIELD_PSWFPROCSUBWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getPSWFProcSubWFName() != null) {
            object = pSWFProcSubWFBase.getPSWFProcSubWFName();
            xmlNode.setAttribute(FIELD_PSWFPROCSUBWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getPSWFVersionId() != null) {
            object = pSWFProcSubWFBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getSuspendDefault() != null) {
            object = pSWFProcSubWFBase.getSuspendDefault();
            xmlNode.setAttribute(FIELD_SUSPENDDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcSubWFBase.getUpdateDate() != null) {
            object = pSWFProcSubWFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcSubWFBase.getUpdateMan() != null) {
            object = pSWFProcSubWFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getUserCat() != null) {
            object = pSWFProcSubWFBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getUserData() != null) {
            object = pSWFProcSubWFBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getUserData2() != null) {
            object = pSWFProcSubWFBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getUserTag() != null) {
            object = pSWFProcSubWFBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getUserTag2() != null) {
            object = pSWFProcSubWFBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getUserTag3() != null) {
            object = pSWFProcSubWFBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcSubWFBase.getUserTag4() != null) {
            object = pSWFProcSubWFBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFProcSubWFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFProcSubWFBase pSWFProcSubWFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFProcSubWFBase.isCodeNameDirty() && (bl || pSWFProcSubWFBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWFProcSubWFBase.getCodeName());
        }
        if (pSWFProcSubWFBase.isCreateDateDirty() && (bl || pSWFProcSubWFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFProcSubWFBase.getCreateDate());
        }
        if (pSWFProcSubWFBase.isCreateManDirty() && (bl || pSWFProcSubWFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFProcSubWFBase.getCreateMan());
        }
        if (pSWFProcSubWFBase.isDynaModelFlagDirty() && (bl || pSWFProcSubWFBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFProcSubWFBase.getDynaModelFlag());
        }
        if (pSWFProcSubWFBase.isEmbedPSDEDSIdDirty() && (bl || pSWFProcSubWFBase.getEmbedPSDEDSId() != null)) {
            iDataObject.set(FIELD_EMBEDPSDEDSID, (Object)pSWFProcSubWFBase.getEmbedPSDEDSId());
        }
        if (pSWFProcSubWFBase.isEmbedPSDEDSNameDirty() && (bl || pSWFProcSubWFBase.getEmbedPSDEDSName() != null)) {
            iDataObject.set(FIELD_EMBEDPSDEDSNAME, (Object)pSWFProcSubWFBase.getEmbedPSDEDSName());
        }
        if (pSWFProcSubWFBase.isEmbedPSDEIdDirty() && (bl || pSWFProcSubWFBase.getEmbedPSDEId() != null)) {
            iDataObject.set(FIELD_EMBEDPSDEID, (Object)pSWFProcSubWFBase.getEmbedPSDEId());
        }
        if (pSWFProcSubWFBase.isEmbedPSWFDEIdDirty() && (bl || pSWFProcSubWFBase.getEmbedPSWFDEId() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFDEID, (Object)pSWFProcSubWFBase.getEmbedPSWFDEId());
        }
        if (pSWFProcSubWFBase.isEmbedPSWFDENameDirty() && (bl || pSWFProcSubWFBase.getEmbedPSWFDEName() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFDENAME, (Object)pSWFProcSubWFBase.getEmbedPSWFDEName());
        }
        if (pSWFProcSubWFBase.isEmbedPSWFIdDirty() && (bl || pSWFProcSubWFBase.getEmbedPSWFId() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFID, (Object)pSWFProcSubWFBase.getEmbedPSWFId());
        }
        if (pSWFProcSubWFBase.isEmbedPSWFNameDirty() && (bl || pSWFProcSubWFBase.getEmbedPSWFName() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFNAME, (Object)pSWFProcSubWFBase.getEmbedPSWFName());
        }
        if (pSWFProcSubWFBase.isEmbedPSWFVerIdDirty() && (bl || pSWFProcSubWFBase.getEmbedPSWFVerId() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFVERID, (Object)pSWFProcSubWFBase.getEmbedPSWFVerId());
        }
        if (pSWFProcSubWFBase.isEmbedPSWFVerNameDirty() && (bl || pSWFProcSubWFBase.getEmbedPSWFVerName() != null)) {
            iDataObject.set(FIELD_EMBEDPSWFVERNAME, (Object)pSWFProcSubWFBase.getEmbedPSWFVerName());
        }
        if (pSWFProcSubWFBase.isMemoDirty() && (bl || pSWFProcSubWFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFProcSubWFBase.getMemo());
        }
        if (pSWFProcSubWFBase.isPSDynaInstIdDirty() && (bl || pSWFProcSubWFBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFProcSubWFBase.getPSDynaInstId());
        }
        if (pSWFProcSubWFBase.isPSSystemIdDirty() && (bl || pSWFProcSubWFBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWFProcSubWFBase.getPSSystemId());
        }
        if (pSWFProcSubWFBase.isPSWFIdDirty() && (bl || pSWFProcSubWFBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSWFProcSubWFBase.getPSWFId());
        }
        if (pSWFProcSubWFBase.isPSWFProcessIdDirty() && (bl || pSWFProcSubWFBase.getPSWFProcessId() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSID, (Object)pSWFProcSubWFBase.getPSWFProcessId());
        }
        if (pSWFProcSubWFBase.isPSWFProcessNameDirty() && (bl || pSWFProcSubWFBase.getPSWFProcessName() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSNAME, (Object)pSWFProcSubWFBase.getPSWFProcessName());
        }
        if (pSWFProcSubWFBase.isPSWFProcSubWFIdDirty() && (bl || pSWFProcSubWFBase.getPSWFProcSubWFId() != null)) {
            iDataObject.set(FIELD_PSWFPROCSUBWFID, (Object)pSWFProcSubWFBase.getPSWFProcSubWFId());
        }
        if (pSWFProcSubWFBase.isPSWFProcSubWFNameDirty() && (bl || pSWFProcSubWFBase.getPSWFProcSubWFName() != null)) {
            iDataObject.set(FIELD_PSWFPROCSUBWFNAME, (Object)pSWFProcSubWFBase.getPSWFProcSubWFName());
        }
        if (pSWFProcSubWFBase.isPSWFVersionIdDirty() && (bl || pSWFProcSubWFBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFProcSubWFBase.getPSWFVersionId());
        }
        if (pSWFProcSubWFBase.isSuspendDefaultDirty() && (bl || pSWFProcSubWFBase.getSuspendDefault() != null)) {
            iDataObject.set(FIELD_SUSPENDDEFAULT, (Object)pSWFProcSubWFBase.getSuspendDefault());
        }
        if (pSWFProcSubWFBase.isUpdateDateDirty() && (bl || pSWFProcSubWFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFProcSubWFBase.getUpdateDate());
        }
        if (pSWFProcSubWFBase.isUpdateManDirty() && (bl || pSWFProcSubWFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFProcSubWFBase.getUpdateMan());
        }
        if (pSWFProcSubWFBase.isUserCatDirty() && (bl || pSWFProcSubWFBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFProcSubWFBase.getUserCat());
        }
        if (pSWFProcSubWFBase.isUserDataDirty() && (bl || pSWFProcSubWFBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSWFProcSubWFBase.getUserData());
        }
        if (pSWFProcSubWFBase.isUserData2Dirty() && (bl || pSWFProcSubWFBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSWFProcSubWFBase.getUserData2());
        }
        if (pSWFProcSubWFBase.isUserTagDirty() && (bl || pSWFProcSubWFBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFProcSubWFBase.getUserTag());
        }
        if (pSWFProcSubWFBase.isUserTag2Dirty() && (bl || pSWFProcSubWFBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFProcSubWFBase.getUserTag2());
        }
        if (pSWFProcSubWFBase.isUserTag3Dirty() && (bl || pSWFProcSubWFBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFProcSubWFBase.getUserTag3());
        }
        if (pSWFProcSubWFBase.isUserTag4Dirty() && (bl || pSWFProcSubWFBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFProcSubWFBase.getUserTag4());
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
        return PSWFProcSubWFBase.remove(this, n);
    }

    private static boolean remove(PSWFProcSubWFBase pSWFProcSubWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcSubWFBase.resetCodeName();
                return true;
            }
            case 1: {
                pSWFProcSubWFBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWFProcSubWFBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWFProcSubWFBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSWFProcSubWFBase.resetEmbedPSDEDSId();
                return true;
            }
            case 5: {
                pSWFProcSubWFBase.resetEmbedPSDEDSName();
                return true;
            }
            case 6: {
                pSWFProcSubWFBase.resetEmbedPSDEId();
                return true;
            }
            case 7: {
                pSWFProcSubWFBase.resetEmbedPSWFDEId();
                return true;
            }
            case 8: {
                pSWFProcSubWFBase.resetEmbedPSWFDEName();
                return true;
            }
            case 9: {
                pSWFProcSubWFBase.resetEmbedPSWFId();
                return true;
            }
            case 10: {
                pSWFProcSubWFBase.resetEmbedPSWFName();
                return true;
            }
            case 11: {
                pSWFProcSubWFBase.resetEmbedPSWFVerId();
                return true;
            }
            case 12: {
                pSWFProcSubWFBase.resetEmbedPSWFVerName();
                return true;
            }
            case 13: {
                pSWFProcSubWFBase.resetMemo();
                return true;
            }
            case 14: {
                pSWFProcSubWFBase.resetPSDynaInstId();
                return true;
            }
            case 15: {
                pSWFProcSubWFBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSWFProcSubWFBase.resetPSWFId();
                return true;
            }
            case 17: {
                pSWFProcSubWFBase.resetPSWFProcessId();
                return true;
            }
            case 18: {
                pSWFProcSubWFBase.resetPSWFProcessName();
                return true;
            }
            case 19: {
                pSWFProcSubWFBase.resetPSWFProcSubWFId();
                return true;
            }
            case 20: {
                pSWFProcSubWFBase.resetPSWFProcSubWFName();
                return true;
            }
            case 21: {
                pSWFProcSubWFBase.resetPSWFVersionId();
                return true;
            }
            case 22: {
                pSWFProcSubWFBase.resetSuspendDefault();
                return true;
            }
            case 23: {
                pSWFProcSubWFBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSWFProcSubWFBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSWFProcSubWFBase.resetUserCat();
                return true;
            }
            case 26: {
                pSWFProcSubWFBase.resetUserData();
                return true;
            }
            case 27: {
                pSWFProcSubWFBase.resetUserData2();
                return true;
            }
            case 28: {
                pSWFProcSubWFBase.resetUserTag();
                return true;
            }
            case 29: {
                pSWFProcSubWFBase.resetUserTag2();
                return true;
            }
            case 30: {
                pSWFProcSubWFBase.resetUserTag3();
                return true;
            }
            case 31: {
                pSWFProcSubWFBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getEmbedPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSDEDS();
        }
        if (this.getEmbedPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objEmbedPSDEDSLock;
        synchronized (n) {
            if (this.embedpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getEmbedPSDEDSId(), (Object)this.embedpsdeds.getPSDEDataSetId()) != 0L) {
                this.embedpsdeds = null;
            }
            if (this.embedpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getEmbedPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.embedpsdeds = pSDEDataSet;
            }
            return this.embedpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFDE getEmbedPSWFDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFDE();
        }
        if (this.getEmbedPSWFDEId() == null) {
            return null;
        }
        Integer n = this.objEmbedPSWFDELock;
        synchronized (n) {
            if (this.embedpswfde != null && DataTypeHelper.compare((int)25, (Object)this.getEmbedPSWFDEId(), (Object)this.embedpswfde.getPSWFDEId()) != 0L) {
                this.embedpswfde = null;
            }
            if (this.embedpswfde == null) {
                PSWFDE pSWFDE = new PSWFDE();
                pSWFDE.setPSWFDEId(this.getEmbedPSWFDEId());
                PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                pSWFDEService.autoGet(pSWFDE);
                this.embedpswfde = pSWFDE;
            }
            return this.embedpswfde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFProcess getPSWFProcess() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcess();
        }
        if (this.getPSWFProcessId() == null) {
            return null;
        }
        Integer n = this.objPSWFProcessLock;
        synchronized (n) {
            if (this.pswfprocess != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFProcessId(), (Object)this.pswfprocess.getPSWFProcessId()) != 0L) {
                this.pswfprocess = null;
            }
            if (this.pswfprocess == null) {
                PSWFProcess pSWFProcess = new PSWFProcess();
                pSWFProcess.setPSWFProcessId(this.getPSWFProcessId());
                PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
                pSWFProcessService.autoGet(pSWFProcess);
                this.pswfprocess = pSWFProcess;
            }
            return this.pswfprocess;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getEmbedPSWFVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWFVer();
        }
        if (this.getEmbedPSWFVerId() == null) {
            return null;
        }
        Integer n = this.objEmbedPSWFVerLock;
        synchronized (n) {
            if (this.embedpswfver != null && DataTypeHelper.compare((int)25, (Object)this.getEmbedPSWFVerId(), (Object)this.embedpswfver.getPSWFVersionId()) != 0L) {
                this.embedpswfver = null;
            }
            if (this.embedpswfver == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getEmbedPSWFVerId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet(pSWFVersion);
                this.embedpswfver = pSWFVersion;
            }
            return this.embedpswfver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getEmbedPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedPSWF();
        }
        if (this.getEmbedPSWFId() == null) {
            return null;
        }
        Integer n = this.objEmbedPSWFLock;
        synchronized (n) {
            if (this.embedpswf != null && DataTypeHelper.compare((int)25, (Object)this.getEmbedPSWFId(), (Object)this.embedpswf.getPSWorkflowId()) != 0L) {
                this.embedpswf = null;
            }
            if (this.embedpswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getEmbedPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet(pSWorkflow);
                this.embedpswf = pSWorkflow;
            }
            return this.embedpswf;
        }
    }

    private PSWFProcSubWFBase getProxyEntity() {
        return this.proxyPSWFProcSubWFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFProcSubWFBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFProcSubWFBase) {
            this.proxyPSWFProcSubWFBase = (PSWFProcSubWFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_EMBEDPSDEDSID, 4);
        fieldIndexMap.put(FIELD_EMBEDPSDEDSNAME, 5);
        fieldIndexMap.put(FIELD_EMBEDPSDEID, 6);
        fieldIndexMap.put(FIELD_EMBEDPSWFDEID, 7);
        fieldIndexMap.put(FIELD_EMBEDPSWFDENAME, 8);
        fieldIndexMap.put(FIELD_EMBEDPSWFID, 9);
        fieldIndexMap.put(FIELD_EMBEDPSWFNAME, 10);
        fieldIndexMap.put(FIELD_EMBEDPSWFVERID, 11);
        fieldIndexMap.put(FIELD_EMBEDPSWFVERNAME, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PSWFID, 16);
        fieldIndexMap.put(FIELD_PSWFPROCESSID, 17);
        fieldIndexMap.put(FIELD_PSWFPROCESSNAME, 18);
        fieldIndexMap.put(FIELD_PSWFPROCSUBWFID, 19);
        fieldIndexMap.put(FIELD_PSWFPROCSUBWFNAME, 20);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 21);
        fieldIndexMap.put(FIELD_SUSPENDDEFAULT, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERDATA, 26);
        fieldIndexMap.put(FIELD_USERDATA2, 27);
        fieldIndexMap.put(FIELD_USERTAG, 28);
        fieldIndexMap.put(FIELD_USERTAG2, 29);
        fieldIndexMap.put(FIELD_USERTAG3, 30);
        fieldIndexMap.put(FIELD_USERTAG4, 31);
    }
}

