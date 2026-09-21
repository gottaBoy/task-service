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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcRoleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFProcRoleBase.class);
    public static final String FIELD_CCMODE = "CCMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String FIELD_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String FIELD_PSWFPROCROLEID = "PSWFPROCROLEID";
    public static final String FIELD_PSWFPROCROLENAME = "PSWFPROCROLENAME";
    public static final String FIELD_PSWFROLEID = "PSWFROLEID";
    public static final String FIELD_PSWFROLENAME = "PSWFROLENAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_ROLETYPE = "ROLETYPE";
    public static final String FIELD_UDFIELDS = "UDFIELDS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CCMODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDYNAINSTID = 5;
    private static final int INDEX_PSSYSMSGTEMPLID = 6;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 7;
    private static final int INDEX_PSSYSTEMID = 8;
    private static final int INDEX_PSWFID = 9;
    private static final int INDEX_PSWFPROCESSID = 10;
    private static final int INDEX_PSWFPROCESSNAME = 11;
    private static final int INDEX_PSWFPROCROLEID = 12;
    private static final int INDEX_PSWFPROCROLENAME = 13;
    private static final int INDEX_PSWFROLEID = 14;
    private static final int INDEX_PSWFROLENAME = 15;
    private static final int INDEX_PSWFVERSIONID = 16;
    private static final int INDEX_PSWFVERSIONNAME = 17;
    private static final int INDEX_ROLETYPE = 18;
    private static final int INDEX_UDFIELDS = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERCAT = 22;
    private static final int INDEX_USERDATA = 23;
    private static final int INDEX_USERDATA2 = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_USERTAG3 = 27;
    private static final int INDEX_USERTAG4 = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFProcRoleBase proxyPSWFProcRoleBase = null;
    private boolean ccmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfprocessidDirtyFlag = false;
    private boolean pswfprocessnameDirtyFlag = false;
    private boolean pswfprocroleidDirtyFlag = false;
    private boolean pswfprocrolenameDirtyFlag = false;
    private boolean pswfroleidDirtyFlag = false;
    private boolean pswfrolenameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean roletypeDirtyFlag = false;
    private boolean udfieldsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="ccmode")
    private Integer ccmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysmsgtemplid")
    private String pssysmsgtemplid;
    @Column(name="pssysmsgtemplname")
    private String pssysmsgtemplname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfprocessid")
    private String pswfprocessid;
    @Column(name="pswfprocessname")
    private String pswfprocessname;
    @Column(name="pswfprocroleid")
    private String pswfprocroleid;
    @Column(name="pswfprocrolename")
    private String pswfprocrolename;
    @Column(name="pswfroleid")
    private String pswfroleid;
    @Column(name="pswfrolename")
    private String pswfrolename;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="roletype")
    private String roletype;
    @Column(name="udfields")
    private String udfields;
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
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objPSWFProcessLock = new Integer(1);
    private PSWFProcess pswfprocess = null;
    private Integer objPSWFRoleLock = new Integer(1);
    private PSWFRole pswfrole = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;

    public void setCCMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCCMode(n);
            return;
        }
        this.ccmode = n;
        this.ccmodeDirtyFlag = true;
    }

    public Integer getCCMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCCMode();
        }
        return this.ccmode;
    }

    public boolean isCCModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCCModeDirty();
        }
        return this.ccmodeDirtyFlag;
    }

    public void resetCCMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCCMode();
            return;
        }
        this.ccmodeDirtyFlag = false;
        this.ccmode = null;
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

    public void setPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplid = string;
        this.pssysmsgtemplidDirtyFlag = true;
    }

    public String getPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplId();
        }
        return this.pssysmsgtemplid;
    }

    public boolean isPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplIdDirty();
        }
        return this.pssysmsgtemplidDirtyFlag;
    }

    public void resetPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplId();
            return;
        }
        this.pssysmsgtemplidDirtyFlag = false;
        this.pssysmsgtemplid = null;
    }

    public void setPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplname = string;
        this.pssysmsgtemplnameDirtyFlag = true;
    }

    public String getPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplName();
        }
        return this.pssysmsgtemplname;
    }

    public boolean isPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplNameDirty();
        }
        return this.pssysmsgtemplnameDirtyFlag;
    }

    public void resetPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplName();
            return;
        }
        this.pssysmsgtemplnameDirtyFlag = false;
        this.pssysmsgtemplname = null;
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

    public void setPSWFID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFID();
        }
        return this.pswfid;
    }

    public boolean isPSWFIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIDDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFID();
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

    public void setPSWFProcRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocroleid = string;
        this.pswfprocroleidDirtyFlag = true;
    }

    public String getPSWFProcRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcRoleId();
        }
        return this.pswfprocroleid;
    }

    public boolean isPSWFProcRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcRoleIdDirty();
        }
        return this.pswfprocroleidDirtyFlag;
    }

    public void resetPSWFProcRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcRoleId();
            return;
        }
        this.pswfprocroleidDirtyFlag = false;
        this.pswfprocroleid = null;
    }

    public void setPSWFProcRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocrolename = string;
        this.pswfprocrolenameDirtyFlag = true;
    }

    public String getPSWFProcRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcRoleName();
        }
        return this.pswfprocrolename;
    }

    public boolean isPSWFProcRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcRoleNameDirty();
        }
        return this.pswfprocrolenameDirtyFlag;
    }

    public void resetPSWFProcRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcRoleName();
            return;
        }
        this.pswfprocrolenameDirtyFlag = false;
        this.pswfprocrolename = null;
    }

    public void setPSWFRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfroleid = string;
        this.pswfroleidDirtyFlag = true;
    }

    public String getPSWFRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRoleId();
        }
        return this.pswfroleid;
    }

    public boolean isPSWFRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFRoleIdDirty();
        }
        return this.pswfroleidDirtyFlag;
    }

    public void resetPSWFRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFRoleId();
            return;
        }
        this.pswfroleidDirtyFlag = false;
        this.pswfroleid = null;
    }

    public void setPSWFRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfrolename = string;
        this.pswfrolenameDirtyFlag = true;
    }

    public String getPSWFRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRoleName();
        }
        return this.pswfrolename;
    }

    public boolean isPSWFRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFRoleNameDirty();
        }
        return this.pswfrolenameDirtyFlag;
    }

    public void resetPSWFRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFRoleName();
            return;
        }
        this.pswfrolenameDirtyFlag = false;
        this.pswfrolename = null;
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

    public void setRoleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRoleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.roletype = string;
        this.roletypeDirtyFlag = true;
    }

    public String getRoleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRoleType();
        }
        return this.roletype;
    }

    public boolean isRoleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRoleTypeDirty();
        }
        return this.roletypeDirtyFlag;
    }

    public void resetRoleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRoleType();
            return;
        }
        this.roletypeDirtyFlag = false;
        this.roletype = null;
    }

    public void setUDFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUDFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.udfields = string;
        this.udfieldsDirtyFlag = true;
    }

    public String getUDFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUDFields();
        }
        return this.udfields;
    }

    public boolean isUDFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUDFieldsDirty();
        }
        return this.udfieldsDirtyFlag;
    }

    public void resetUDFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUDFields();
            return;
        }
        this.udfieldsDirtyFlag = false;
        this.udfields = null;
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
        PSWFProcRoleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFProcRoleBase pSWFProcRoleBase) {
        pSWFProcRoleBase.resetCCMode();
        pSWFProcRoleBase.resetCreateDate();
        pSWFProcRoleBase.resetCreateMan();
        pSWFProcRoleBase.resetDynaModelFlag();
        pSWFProcRoleBase.resetMemo();
        pSWFProcRoleBase.resetPSDynaInstId();
        pSWFProcRoleBase.resetPSSysMsgTemplId();
        pSWFProcRoleBase.resetPSSysMsgTemplName();
        pSWFProcRoleBase.resetPSSystemId();
        pSWFProcRoleBase.resetPSWFID();
        pSWFProcRoleBase.resetPSWFProcessId();
        pSWFProcRoleBase.resetPSWFProcessName();
        pSWFProcRoleBase.resetPSWFProcRoleId();
        pSWFProcRoleBase.resetPSWFProcRoleName();
        pSWFProcRoleBase.resetPSWFRoleId();
        pSWFProcRoleBase.resetPSWFRoleName();
        pSWFProcRoleBase.resetPSWFVersionId();
        pSWFProcRoleBase.resetPSWFVersionName();
        pSWFProcRoleBase.resetRoleType();
        pSWFProcRoleBase.resetUDFields();
        pSWFProcRoleBase.resetUpdateDate();
        pSWFProcRoleBase.resetUpdateMan();
        pSWFProcRoleBase.resetUserCat();
        pSWFProcRoleBase.resetUserData();
        pSWFProcRoleBase.resetUserData2();
        pSWFProcRoleBase.resetUserTag();
        pSWFProcRoleBase.resetUserTag2();
        pSWFProcRoleBase.resetUserTag3();
        pSWFProcRoleBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCCModeDirty()) {
            hashMap.put(FIELD_CCMODE, this.getCCMode());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLID, this.getPSSysMsgTemplId());
        }
        if (!bl || this.isPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLNAME, this.getPSSysMsgTemplName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSWFIDDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFID());
        }
        if (!bl || this.isPSWFProcessIdDirty()) {
            hashMap.put(FIELD_PSWFPROCESSID, this.getPSWFProcessId());
        }
        if (!bl || this.isPSWFProcessNameDirty()) {
            hashMap.put(FIELD_PSWFPROCESSNAME, this.getPSWFProcessName());
        }
        if (!bl || this.isPSWFProcRoleIdDirty()) {
            hashMap.put(FIELD_PSWFPROCROLEID, this.getPSWFProcRoleId());
        }
        if (!bl || this.isPSWFProcRoleNameDirty()) {
            hashMap.put(FIELD_PSWFPROCROLENAME, this.getPSWFProcRoleName());
        }
        if (!bl || this.isPSWFRoleIdDirty()) {
            hashMap.put(FIELD_PSWFROLEID, this.getPSWFRoleId());
        }
        if (!bl || this.isPSWFRoleNameDirty()) {
            hashMap.put(FIELD_PSWFROLENAME, this.getPSWFRoleName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isRoleTypeDirty()) {
            hashMap.put(FIELD_ROLETYPE, this.getRoleType());
        }
        if (!bl || this.isUDFieldsDirty()) {
            hashMap.put(FIELD_UDFIELDS, this.getUDFields());
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
        return PSWFProcRoleBase.get(this, n);
    }

    private static Object get(PSWFProcRoleBase pSWFProcRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcRoleBase.getCCMode();
            }
            case 1: {
                return pSWFProcRoleBase.getCreateDate();
            }
            case 2: {
                return pSWFProcRoleBase.getCreateMan();
            }
            case 3: {
                return pSWFProcRoleBase.getDynaModelFlag();
            }
            case 4: {
                return pSWFProcRoleBase.getMemo();
            }
            case 5: {
                return pSWFProcRoleBase.getPSDynaInstId();
            }
            case 6: {
                return pSWFProcRoleBase.getPSSysMsgTemplId();
            }
            case 7: {
                return pSWFProcRoleBase.getPSSysMsgTemplName();
            }
            case 8: {
                return pSWFProcRoleBase.getPSSystemId();
            }
            case 9: {
                return pSWFProcRoleBase.getPSWFID();
            }
            case 10: {
                return pSWFProcRoleBase.getPSWFProcessId();
            }
            case 11: {
                return pSWFProcRoleBase.getPSWFProcessName();
            }
            case 12: {
                return pSWFProcRoleBase.getPSWFProcRoleId();
            }
            case 13: {
                return pSWFProcRoleBase.getPSWFProcRoleName();
            }
            case 14: {
                return pSWFProcRoleBase.getPSWFRoleId();
            }
            case 15: {
                return pSWFProcRoleBase.getPSWFRoleName();
            }
            case 16: {
                return pSWFProcRoleBase.getPSWFVersionId();
            }
            case 17: {
                return pSWFProcRoleBase.getPSWFVersionName();
            }
            case 18: {
                return pSWFProcRoleBase.getRoleType();
            }
            case 19: {
                return pSWFProcRoleBase.getUDFields();
            }
            case 20: {
                return pSWFProcRoleBase.getUpdateDate();
            }
            case 21: {
                return pSWFProcRoleBase.getUpdateMan();
            }
            case 22: {
                return pSWFProcRoleBase.getUserCat();
            }
            case 23: {
                return pSWFProcRoleBase.getUserData();
            }
            case 24: {
                return pSWFProcRoleBase.getUserData2();
            }
            case 25: {
                return pSWFProcRoleBase.getUserTag();
            }
            case 26: {
                return pSWFProcRoleBase.getUserTag2();
            }
            case 27: {
                return pSWFProcRoleBase.getUserTag3();
            }
            case 28: {
                return pSWFProcRoleBase.getUserTag4();
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
        PSWFProcRoleBase.set(this, n, object);
    }

    private static void set(PSWFProcRoleBase pSWFProcRoleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcRoleBase.setCCMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSWFProcRoleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWFProcRoleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFProcRoleBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWFProcRoleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFProcRoleBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFProcRoleBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFProcRoleBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFProcRoleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFProcRoleBase.setPSWFID(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFProcRoleBase.setPSWFProcessId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFProcRoleBase.setPSWFProcessName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFProcRoleBase.setPSWFProcRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFProcRoleBase.setPSWFProcRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFProcRoleBase.setPSWFRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFProcRoleBase.setPSWFRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFProcRoleBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFProcRoleBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFProcRoleBase.setRoleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFProcRoleBase.setUDFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFProcRoleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSWFProcRoleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFProcRoleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWFProcRoleBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFProcRoleBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWFProcRoleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWFProcRoleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWFProcRoleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWFProcRoleBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSWFProcRoleBase.isNull(this, n);
    }

    private static boolean isNull(PSWFProcRoleBase pSWFProcRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcRoleBase.getCCMode() == null;
            }
            case 1: {
                return pSWFProcRoleBase.getCreateDate() == null;
            }
            case 2: {
                return pSWFProcRoleBase.getCreateMan() == null;
            }
            case 3: {
                return pSWFProcRoleBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSWFProcRoleBase.getMemo() == null;
            }
            case 5: {
                return pSWFProcRoleBase.getPSDynaInstId() == null;
            }
            case 6: {
                return pSWFProcRoleBase.getPSSysMsgTemplId() == null;
            }
            case 7: {
                return pSWFProcRoleBase.getPSSysMsgTemplName() == null;
            }
            case 8: {
                return pSWFProcRoleBase.getPSSystemId() == null;
            }
            case 9: {
                return pSWFProcRoleBase.getPSWFID() == null;
            }
            case 10: {
                return pSWFProcRoleBase.getPSWFProcessId() == null;
            }
            case 11: {
                return pSWFProcRoleBase.getPSWFProcessName() == null;
            }
            case 12: {
                return pSWFProcRoleBase.getPSWFProcRoleId() == null;
            }
            case 13: {
                return pSWFProcRoleBase.getPSWFProcRoleName() == null;
            }
            case 14: {
                return pSWFProcRoleBase.getPSWFRoleId() == null;
            }
            case 15: {
                return pSWFProcRoleBase.getPSWFRoleName() == null;
            }
            case 16: {
                return pSWFProcRoleBase.getPSWFVersionId() == null;
            }
            case 17: {
                return pSWFProcRoleBase.getPSWFVersionName() == null;
            }
            case 18: {
                return pSWFProcRoleBase.getRoleType() == null;
            }
            case 19: {
                return pSWFProcRoleBase.getUDFields() == null;
            }
            case 20: {
                return pSWFProcRoleBase.getUpdateDate() == null;
            }
            case 21: {
                return pSWFProcRoleBase.getUpdateMan() == null;
            }
            case 22: {
                return pSWFProcRoleBase.getUserCat() == null;
            }
            case 23: {
                return pSWFProcRoleBase.getUserData() == null;
            }
            case 24: {
                return pSWFProcRoleBase.getUserData2() == null;
            }
            case 25: {
                return pSWFProcRoleBase.getUserTag() == null;
            }
            case 26: {
                return pSWFProcRoleBase.getUserTag2() == null;
            }
            case 27: {
                return pSWFProcRoleBase.getUserTag3() == null;
            }
            case 28: {
                return pSWFProcRoleBase.getUserTag4() == null;
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
        return PSWFProcRoleBase.contains(this, n);
    }

    private static boolean contains(PSWFProcRoleBase pSWFProcRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcRoleBase.isCCModeDirty();
            }
            case 1: {
                return pSWFProcRoleBase.isCreateDateDirty();
            }
            case 2: {
                return pSWFProcRoleBase.isCreateManDirty();
            }
            case 3: {
                return pSWFProcRoleBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSWFProcRoleBase.isMemoDirty();
            }
            case 5: {
                return pSWFProcRoleBase.isPSDynaInstIdDirty();
            }
            case 6: {
                return pSWFProcRoleBase.isPSSysMsgTemplIdDirty();
            }
            case 7: {
                return pSWFProcRoleBase.isPSSysMsgTemplNameDirty();
            }
            case 8: {
                return pSWFProcRoleBase.isPSSystemIdDirty();
            }
            case 9: {
                return pSWFProcRoleBase.isPSWFIDDirty();
            }
            case 10: {
                return pSWFProcRoleBase.isPSWFProcessIdDirty();
            }
            case 11: {
                return pSWFProcRoleBase.isPSWFProcessNameDirty();
            }
            case 12: {
                return pSWFProcRoleBase.isPSWFProcRoleIdDirty();
            }
            case 13: {
                return pSWFProcRoleBase.isPSWFProcRoleNameDirty();
            }
            case 14: {
                return pSWFProcRoleBase.isPSWFRoleIdDirty();
            }
            case 15: {
                return pSWFProcRoleBase.isPSWFRoleNameDirty();
            }
            case 16: {
                return pSWFProcRoleBase.isPSWFVersionIdDirty();
            }
            case 17: {
                return pSWFProcRoleBase.isPSWFVersionNameDirty();
            }
            case 18: {
                return pSWFProcRoleBase.isRoleTypeDirty();
            }
            case 19: {
                return pSWFProcRoleBase.isUDFieldsDirty();
            }
            case 20: {
                return pSWFProcRoleBase.isUpdateDateDirty();
            }
            case 21: {
                return pSWFProcRoleBase.isUpdateManDirty();
            }
            case 22: {
                return pSWFProcRoleBase.isUserCatDirty();
            }
            case 23: {
                return pSWFProcRoleBase.isUserDataDirty();
            }
            case 24: {
                return pSWFProcRoleBase.isUserData2Dirty();
            }
            case 25: {
                return pSWFProcRoleBase.isUserTagDirty();
            }
            case 26: {
                return pSWFProcRoleBase.isUserTag2Dirty();
            }
            case 27: {
                return pSWFProcRoleBase.isUserTag3Dirty();
            }
            case 28: {
                return pSWFProcRoleBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFProcRoleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFProcRoleBase pSWFProcRoleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFProcRoleBase.getCCMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ccmode", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getCCMode()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFID()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFProcessId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessid", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFProcessId()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFProcessName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessname", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFProcessName()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFProcRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocroleid", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFProcRoleId()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFProcRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocrolename", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFProcRoleName()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfroleid", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFRoleId()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfrolename", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFRoleName()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getRoleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"roletype", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getRoleType()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUDFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"udfields", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUDFields()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUserData()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUserData2()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFProcRoleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFProcRoleBase.getJSONValue((Object)pSWFProcRoleBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFProcRoleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFProcRoleBase pSWFProcRoleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFProcRoleBase.getCCMode() != null) {
            object = pSWFProcRoleBase.getCCMode();
            xmlNode.setAttribute(FIELD_CCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcRoleBase.getCreateDate() != null) {
            object = pSWFProcRoleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcRoleBase.getCreateMan() != null) {
            object = pSWFProcRoleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getDynaModelFlag() != null) {
            object = pSWFProcRoleBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFProcRoleBase.getMemo() != null) {
            object = pSWFProcRoleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSDynaInstId() != null) {
            object = pSWFProcRoleBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSSysMsgTemplId() != null) {
            object = pSWFProcRoleBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSSysMsgTemplName() != null) {
            object = pSWFProcRoleBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSSystemId() != null) {
            object = pSWFProcRoleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFID() != null) {
            object = pSWFProcRoleBase.getPSWFID();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFProcessId() != null) {
            object = pSWFProcRoleBase.getPSWFProcessId();
            xmlNode.setAttribute(FIELD_PSWFPROCESSID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFProcessName() != null) {
            object = pSWFProcRoleBase.getPSWFProcessName();
            xmlNode.setAttribute(FIELD_PSWFPROCESSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFProcRoleId() != null) {
            object = pSWFProcRoleBase.getPSWFProcRoleId();
            xmlNode.setAttribute(FIELD_PSWFPROCROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFProcRoleName() != null) {
            object = pSWFProcRoleBase.getPSWFProcRoleName();
            xmlNode.setAttribute(FIELD_PSWFPROCROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFRoleId() != null) {
            object = pSWFProcRoleBase.getPSWFRoleId();
            xmlNode.setAttribute(FIELD_PSWFROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFRoleName() != null) {
            object = pSWFProcRoleBase.getPSWFRoleName();
            xmlNode.setAttribute(FIELD_PSWFROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFVersionId() != null) {
            object = pSWFProcRoleBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getPSWFVersionName() != null) {
            object = pSWFProcRoleBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getRoleType() != null) {
            object = pSWFProcRoleBase.getRoleType();
            xmlNode.setAttribute(FIELD_ROLETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUDFields() != null) {
            object = pSWFProcRoleBase.getUDFields();
            xmlNode.setAttribute(FIELD_UDFIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUpdateDate() != null) {
            object = pSWFProcRoleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcRoleBase.getUpdateMan() != null) {
            object = pSWFProcRoleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUserCat() != null) {
            object = pSWFProcRoleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUserData() != null) {
            object = pSWFProcRoleBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUserData2() != null) {
            object = pSWFProcRoleBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUserTag() != null) {
            object = pSWFProcRoleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUserTag2() != null) {
            object = pSWFProcRoleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUserTag3() != null) {
            object = pSWFProcRoleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcRoleBase.getUserTag4() != null) {
            object = pSWFProcRoleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFProcRoleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFProcRoleBase pSWFProcRoleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFProcRoleBase.isCCModeDirty() && (bl || pSWFProcRoleBase.getCCMode() != null)) {
            iDataObject.set(FIELD_CCMODE, (Object)pSWFProcRoleBase.getCCMode());
        }
        if (pSWFProcRoleBase.isCreateDateDirty() && (bl || pSWFProcRoleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFProcRoleBase.getCreateDate());
        }
        if (pSWFProcRoleBase.isCreateManDirty() && (bl || pSWFProcRoleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFProcRoleBase.getCreateMan());
        }
        if (pSWFProcRoleBase.isDynaModelFlagDirty() && (bl || pSWFProcRoleBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFProcRoleBase.getDynaModelFlag());
        }
        if (pSWFProcRoleBase.isMemoDirty() && (bl || pSWFProcRoleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFProcRoleBase.getMemo());
        }
        if (pSWFProcRoleBase.isPSDynaInstIdDirty() && (bl || pSWFProcRoleBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFProcRoleBase.getPSDynaInstId());
        }
        if (pSWFProcRoleBase.isPSSysMsgTemplIdDirty() && (bl || pSWFProcRoleBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSWFProcRoleBase.getPSSysMsgTemplId());
        }
        if (pSWFProcRoleBase.isPSSysMsgTemplNameDirty() && (bl || pSWFProcRoleBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSWFProcRoleBase.getPSSysMsgTemplName());
        }
        if (pSWFProcRoleBase.isPSSystemIdDirty() && (bl || pSWFProcRoleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWFProcRoleBase.getPSSystemId());
        }
        if (pSWFProcRoleBase.isPSWFIDDirty() && (bl || pSWFProcRoleBase.getPSWFID() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSWFProcRoleBase.getPSWFID());
        }
        if (pSWFProcRoleBase.isPSWFProcessIdDirty() && (bl || pSWFProcRoleBase.getPSWFProcessId() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSID, (Object)pSWFProcRoleBase.getPSWFProcessId());
        }
        if (pSWFProcRoleBase.isPSWFProcessNameDirty() && (bl || pSWFProcRoleBase.getPSWFProcessName() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSNAME, (Object)pSWFProcRoleBase.getPSWFProcessName());
        }
        if (pSWFProcRoleBase.isPSWFProcRoleIdDirty() && (bl || pSWFProcRoleBase.getPSWFProcRoleId() != null)) {
            iDataObject.set(FIELD_PSWFPROCROLEID, (Object)pSWFProcRoleBase.getPSWFProcRoleId());
        }
        if (pSWFProcRoleBase.isPSWFProcRoleNameDirty() && (bl || pSWFProcRoleBase.getPSWFProcRoleName() != null)) {
            iDataObject.set(FIELD_PSWFPROCROLENAME, (Object)pSWFProcRoleBase.getPSWFProcRoleName());
        }
        if (pSWFProcRoleBase.isPSWFRoleIdDirty() && (bl || pSWFProcRoleBase.getPSWFRoleId() != null)) {
            iDataObject.set(FIELD_PSWFROLEID, (Object)pSWFProcRoleBase.getPSWFRoleId());
        }
        if (pSWFProcRoleBase.isPSWFRoleNameDirty() && (bl || pSWFProcRoleBase.getPSWFRoleName() != null)) {
            iDataObject.set(FIELD_PSWFROLENAME, (Object)pSWFProcRoleBase.getPSWFRoleName());
        }
        if (pSWFProcRoleBase.isPSWFVersionIdDirty() && (bl || pSWFProcRoleBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFProcRoleBase.getPSWFVersionId());
        }
        if (pSWFProcRoleBase.isPSWFVersionNameDirty() && (bl || pSWFProcRoleBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSWFProcRoleBase.getPSWFVersionName());
        }
        if (pSWFProcRoleBase.isRoleTypeDirty() && (bl || pSWFProcRoleBase.getRoleType() != null)) {
            iDataObject.set(FIELD_ROLETYPE, (Object)pSWFProcRoleBase.getRoleType());
        }
        if (pSWFProcRoleBase.isUDFieldsDirty() && (bl || pSWFProcRoleBase.getUDFields() != null)) {
            iDataObject.set(FIELD_UDFIELDS, (Object)pSWFProcRoleBase.getUDFields());
        }
        if (pSWFProcRoleBase.isUpdateDateDirty() && (bl || pSWFProcRoleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFProcRoleBase.getUpdateDate());
        }
        if (pSWFProcRoleBase.isUpdateManDirty() && (bl || pSWFProcRoleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFProcRoleBase.getUpdateMan());
        }
        if (pSWFProcRoleBase.isUserCatDirty() && (bl || pSWFProcRoleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFProcRoleBase.getUserCat());
        }
        if (pSWFProcRoleBase.isUserDataDirty() && (bl || pSWFProcRoleBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSWFProcRoleBase.getUserData());
        }
        if (pSWFProcRoleBase.isUserData2Dirty() && (bl || pSWFProcRoleBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSWFProcRoleBase.getUserData2());
        }
        if (pSWFProcRoleBase.isUserTagDirty() && (bl || pSWFProcRoleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFProcRoleBase.getUserTag());
        }
        if (pSWFProcRoleBase.isUserTag2Dirty() && (bl || pSWFProcRoleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFProcRoleBase.getUserTag2());
        }
        if (pSWFProcRoleBase.isUserTag3Dirty() && (bl || pSWFProcRoleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFProcRoleBase.getUserTag3());
        }
        if (pSWFProcRoleBase.isUserTag4Dirty() && (bl || pSWFProcRoleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFProcRoleBase.getUserTag4());
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
        return PSWFProcRoleBase.remove(this, n);
    }

    private static boolean remove(PSWFProcRoleBase pSWFProcRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcRoleBase.resetCCMode();
                return true;
            }
            case 1: {
                pSWFProcRoleBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWFProcRoleBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWFProcRoleBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSWFProcRoleBase.resetMemo();
                return true;
            }
            case 5: {
                pSWFProcRoleBase.resetPSDynaInstId();
                return true;
            }
            case 6: {
                pSWFProcRoleBase.resetPSSysMsgTemplId();
                return true;
            }
            case 7: {
                pSWFProcRoleBase.resetPSSysMsgTemplName();
                return true;
            }
            case 8: {
                pSWFProcRoleBase.resetPSSystemId();
                return true;
            }
            case 9: {
                pSWFProcRoleBase.resetPSWFID();
                return true;
            }
            case 10: {
                pSWFProcRoleBase.resetPSWFProcessId();
                return true;
            }
            case 11: {
                pSWFProcRoleBase.resetPSWFProcessName();
                return true;
            }
            case 12: {
                pSWFProcRoleBase.resetPSWFProcRoleId();
                return true;
            }
            case 13: {
                pSWFProcRoleBase.resetPSWFProcRoleName();
                return true;
            }
            case 14: {
                pSWFProcRoleBase.resetPSWFRoleId();
                return true;
            }
            case 15: {
                pSWFProcRoleBase.resetPSWFRoleName();
                return true;
            }
            case 16: {
                pSWFProcRoleBase.resetPSWFVersionId();
                return true;
            }
            case 17: {
                pSWFProcRoleBase.resetPSWFVersionName();
                return true;
            }
            case 18: {
                pSWFProcRoleBase.resetRoleType();
                return true;
            }
            case 19: {
                pSWFProcRoleBase.resetUDFields();
                return true;
            }
            case 20: {
                pSWFProcRoleBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSWFProcRoleBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSWFProcRoleBase.resetUserCat();
                return true;
            }
            case 23: {
                pSWFProcRoleBase.resetUserData();
                return true;
            }
            case 24: {
                pSWFProcRoleBase.resetUserData2();
                return true;
            }
            case 25: {
                pSWFProcRoleBase.resetUserTag();
                return true;
            }
            case 26: {
                pSWFProcRoleBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSWFProcRoleBase.resetUserTag3();
                return true;
            }
            case 28: {
                pSWFProcRoleBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempl();
        }
        if (this.getPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTemplLock;
        synchronized (n) {
            if (this.pssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTemplId(), (Object)this.pssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.pssysmsgtempl = null;
            }
            if (this.pssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet((IEntity)pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
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
                pSWFProcessService.autoGet((IEntity)pSWFProcess);
                this.pswfprocess = pSWFProcess;
            }
            return this.pswfprocess;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFRole getPSWFRole() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRole();
        }
        if (this.getPSWFRoleId() == null) {
            return null;
        }
        Integer n = this.objPSWFRoleLock;
        synchronized (n) {
            if (this.pswfrole != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFRoleId(), (Object)this.pswfrole.getPSWFRoleId()) != 0L) {
                this.pswfrole = null;
            }
            if (this.pswfrole == null) {
                PSWFRole pSWFRole = new PSWFRole();
                pSWFRole.setPSWFRoleId(this.getPSWFRoleId());
                PSWFRoleService pSWFRoleService = (PSWFRoleService)ServiceGlobal.getService(PSWFRoleService.class, (SessionFactory)this.getSessionFactory());
                pSWFRoleService.autoGet((IEntity)pSWFRole);
                this.pswfrole = pSWFRole;
            }
            return this.pswfrole;
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

    private PSWFProcRoleBase getProxyEntity() {
        return this.proxyPSWFProcRoleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFProcRoleBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFProcRoleBase) {
            this.proxyPSWFProcRoleBase = (PSWFProcRoleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CCMODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 5);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 6);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 8);
        fieldIndexMap.put(FIELD_PSWFID, 9);
        fieldIndexMap.put(FIELD_PSWFPROCESSID, 10);
        fieldIndexMap.put(FIELD_PSWFPROCESSNAME, 11);
        fieldIndexMap.put(FIELD_PSWFPROCROLEID, 12);
        fieldIndexMap.put(FIELD_PSWFPROCROLENAME, 13);
        fieldIndexMap.put(FIELD_PSWFROLEID, 14);
        fieldIndexMap.put(FIELD_PSWFROLENAME, 15);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 16);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 17);
        fieldIndexMap.put(FIELD_ROLETYPE, 18);
        fieldIndexMap.put(FIELD_UDFIELDS, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERCAT, 22);
        fieldIndexMap.put(FIELD_USERDATA, 23);
        fieldIndexMap.put(FIELD_USERDATA2, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_USERTAG3, 27);
        fieldIndexMap.put(FIELD_USERTAG4, 28);
    }
}

