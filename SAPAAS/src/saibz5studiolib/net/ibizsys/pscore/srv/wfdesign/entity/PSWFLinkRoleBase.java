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
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFLinkRoleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFLinkRoleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSWFLINKID = "PSWFLINKID";
    public static final String FIELD_PSWFLINKNAME = "PSWFLINKNAME";
    public static final String FIELD_PSWFLINKROLEID = "PSWFLINKROLEID";
    public static final String FIELD_PSWFLINKROLENAME = "PSWFLINKROLENAME";
    public static final String FIELD_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String FIELD_PSWFPROCROLEID = "PSWFPROCROLEID";
    public static final String FIELD_PSWFPROCROLENAME = "PSWFPROCROLENAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODELFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDYNAINSTID = 4;
    private static final int INDEX_PSSYSMSGTEMPLID = 5;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 6;
    private static final int INDEX_PSWFLINKID = 7;
    private static final int INDEX_PSWFLINKNAME = 8;
    private static final int INDEX_PSWFLINKROLEID = 9;
    private static final int INDEX_PSWFLINKROLENAME = 10;
    private static final int INDEX_PSWFPROCESSID = 11;
    private static final int INDEX_PSWFPROCROLEID = 12;
    private static final int INDEX_PSWFPROCROLENAME = 13;
    private static final int INDEX_PSWFVERSIONID = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFLinkRoleBase proxyPSWFLinkRoleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pswflinkidDirtyFlag = false;
    private boolean pswflinknameDirtyFlag = false;
    private boolean pswflinkroleidDirtyFlag = false;
    private boolean pswflinkrolenameDirtyFlag = false;
    private boolean pswfprocessidDirtyFlag = false;
    private boolean pswfprocroleidDirtyFlag = false;
    private boolean pswfprocrolenameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
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
    @Column(name="pswflinkid")
    private String pswflinkid;
    @Column(name="pswflinkname")
    private String pswflinkname;
    @Column(name="pswflinkroleid")
    private String pswflinkroleid;
    @Column(name="pswflinkrolename")
    private String pswflinkrolename;
    @Column(name="pswfprocessid")
    private String pswfprocessid;
    @Column(name="pswfprocroleid")
    private String pswfprocroleid;
    @Column(name="pswfprocrolename")
    private String pswfprocrolename;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objPSWFLinkLock = new Integer(1);
    private PSWFLink pswflink = null;
    private Integer objPSWFProcRoleLock = new Integer(1);
    private PSWFProcRole pswfprocrole = null;

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

    public void setPSWFLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkid = string;
        this.pswflinkidDirtyFlag = true;
    }

    public String getPSWFLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkId();
        }
        return this.pswflinkid;
    }

    public boolean isPSWFLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkIdDirty();
        }
        return this.pswflinkidDirtyFlag;
    }

    public void resetPSWFLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkId();
            return;
        }
        this.pswflinkidDirtyFlag = false;
        this.pswflinkid = null;
    }

    public void setPSWFLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkname = string;
        this.pswflinknameDirtyFlag = true;
    }

    public String getPSWFLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkName();
        }
        return this.pswflinkname;
    }

    public boolean isPSWFLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkNameDirty();
        }
        return this.pswflinknameDirtyFlag;
    }

    public void resetPSWFLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkName();
            return;
        }
        this.pswflinknameDirtyFlag = false;
        this.pswflinkname = null;
    }

    public void setPSWFLinkRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkroleid = string;
        this.pswflinkroleidDirtyFlag = true;
    }

    public String getPSWFLinkRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkRoleId();
        }
        return this.pswflinkroleid;
    }

    public boolean isPSWFLinkRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkRoleIdDirty();
        }
        return this.pswflinkroleidDirtyFlag;
    }

    public void resetPSWFLinkRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkRoleId();
            return;
        }
        this.pswflinkroleidDirtyFlag = false;
        this.pswflinkroleid = null;
    }

    public void setPSWFLinkRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkrolename = string;
        this.pswflinkrolenameDirtyFlag = true;
    }

    public String getPSWFLinkRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkRoleName();
        }
        return this.pswflinkrolename;
    }

    public boolean isPSWFLinkRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkRoleNameDirty();
        }
        return this.pswflinkrolenameDirtyFlag;
    }

    public void resetPSWFLinkRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkRoleName();
            return;
        }
        this.pswflinkrolenameDirtyFlag = false;
        this.pswflinkrolename = null;
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
        PSWFLinkRoleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFLinkRoleBase pSWFLinkRoleBase) {
        pSWFLinkRoleBase.resetCreateDate();
        pSWFLinkRoleBase.resetCreateMan();
        pSWFLinkRoleBase.resetDynaModelFlag();
        pSWFLinkRoleBase.resetMemo();
        pSWFLinkRoleBase.resetPSDynaInstId();
        pSWFLinkRoleBase.resetPSSysMsgTemplId();
        pSWFLinkRoleBase.resetPSSysMsgTemplName();
        pSWFLinkRoleBase.resetPSWFLinkId();
        pSWFLinkRoleBase.resetPSWFLinkName();
        pSWFLinkRoleBase.resetPSWFLinkRoleId();
        pSWFLinkRoleBase.resetPSWFLinkRoleName();
        pSWFLinkRoleBase.resetPSWFProcessId();
        pSWFLinkRoleBase.resetPSWFProcRoleId();
        pSWFLinkRoleBase.resetPSWFProcRoleName();
        pSWFLinkRoleBase.resetPSWFVersionId();
        pSWFLinkRoleBase.resetUpdateDate();
        pSWFLinkRoleBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSWFLinkIdDirty()) {
            hashMap.put(FIELD_PSWFLINKID, this.getPSWFLinkId());
        }
        if (!bl || this.isPSWFLinkNameDirty()) {
            hashMap.put(FIELD_PSWFLINKNAME, this.getPSWFLinkName());
        }
        if (!bl || this.isPSWFLinkRoleIdDirty()) {
            hashMap.put(FIELD_PSWFLINKROLEID, this.getPSWFLinkRoleId());
        }
        if (!bl || this.isPSWFLinkRoleNameDirty()) {
            hashMap.put(FIELD_PSWFLINKROLENAME, this.getPSWFLinkRoleName());
        }
        if (!bl || this.isPSWFProcessIdDirty()) {
            hashMap.put(FIELD_PSWFPROCESSID, this.getPSWFProcessId());
        }
        if (!bl || this.isPSWFProcRoleIdDirty()) {
            hashMap.put(FIELD_PSWFPROCROLEID, this.getPSWFProcRoleId());
        }
        if (!bl || this.isPSWFProcRoleNameDirty()) {
            hashMap.put(FIELD_PSWFPROCROLENAME, this.getPSWFProcRoleName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
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
        return PSWFLinkRoleBase.get(this, n);
    }

    private static Object get(PSWFLinkRoleBase pSWFLinkRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkRoleBase.getCreateDate();
            }
            case 1: {
                return pSWFLinkRoleBase.getCreateMan();
            }
            case 2: {
                return pSWFLinkRoleBase.getDynaModelFlag();
            }
            case 3: {
                return pSWFLinkRoleBase.getMemo();
            }
            case 4: {
                return pSWFLinkRoleBase.getPSDynaInstId();
            }
            case 5: {
                return pSWFLinkRoleBase.getPSSysMsgTemplId();
            }
            case 6: {
                return pSWFLinkRoleBase.getPSSysMsgTemplName();
            }
            case 7: {
                return pSWFLinkRoleBase.getPSWFLinkId();
            }
            case 8: {
                return pSWFLinkRoleBase.getPSWFLinkName();
            }
            case 9: {
                return pSWFLinkRoleBase.getPSWFLinkRoleId();
            }
            case 10: {
                return pSWFLinkRoleBase.getPSWFLinkRoleName();
            }
            case 11: {
                return pSWFLinkRoleBase.getPSWFProcessId();
            }
            case 12: {
                return pSWFLinkRoleBase.getPSWFProcRoleId();
            }
            case 13: {
                return pSWFLinkRoleBase.getPSWFProcRoleName();
            }
            case 14: {
                return pSWFLinkRoleBase.getPSWFVersionId();
            }
            case 15: {
                return pSWFLinkRoleBase.getUpdateDate();
            }
            case 16: {
                return pSWFLinkRoleBase.getUpdateMan();
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
        PSWFLinkRoleBase.set(this, n, object);
    }

    private static void set(PSWFLinkRoleBase pSWFLinkRoleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFLinkRoleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWFLinkRoleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFLinkRoleBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSWFLinkRoleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFLinkRoleBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFLinkRoleBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFLinkRoleBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFLinkRoleBase.setPSWFLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFLinkRoleBase.setPSWFLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFLinkRoleBase.setPSWFLinkRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFLinkRoleBase.setPSWFLinkRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFLinkRoleBase.setPSWFProcessId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFLinkRoleBase.setPSWFProcRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFLinkRoleBase.setPSWFProcRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFLinkRoleBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFLinkRoleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSWFLinkRoleBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWFLinkRoleBase.isNull(this, n);
    }

    private static boolean isNull(PSWFLinkRoleBase pSWFLinkRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkRoleBase.getCreateDate() == null;
            }
            case 1: {
                return pSWFLinkRoleBase.getCreateMan() == null;
            }
            case 2: {
                return pSWFLinkRoleBase.getDynaModelFlag() == null;
            }
            case 3: {
                return pSWFLinkRoleBase.getMemo() == null;
            }
            case 4: {
                return pSWFLinkRoleBase.getPSDynaInstId() == null;
            }
            case 5: {
                return pSWFLinkRoleBase.getPSSysMsgTemplId() == null;
            }
            case 6: {
                return pSWFLinkRoleBase.getPSSysMsgTemplName() == null;
            }
            case 7: {
                return pSWFLinkRoleBase.getPSWFLinkId() == null;
            }
            case 8: {
                return pSWFLinkRoleBase.getPSWFLinkName() == null;
            }
            case 9: {
                return pSWFLinkRoleBase.getPSWFLinkRoleId() == null;
            }
            case 10: {
                return pSWFLinkRoleBase.getPSWFLinkRoleName() == null;
            }
            case 11: {
                return pSWFLinkRoleBase.getPSWFProcessId() == null;
            }
            case 12: {
                return pSWFLinkRoleBase.getPSWFProcRoleId() == null;
            }
            case 13: {
                return pSWFLinkRoleBase.getPSWFProcRoleName() == null;
            }
            case 14: {
                return pSWFLinkRoleBase.getPSWFVersionId() == null;
            }
            case 15: {
                return pSWFLinkRoleBase.getUpdateDate() == null;
            }
            case 16: {
                return pSWFLinkRoleBase.getUpdateMan() == null;
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
        return PSWFLinkRoleBase.contains(this, n);
    }

    private static boolean contains(PSWFLinkRoleBase pSWFLinkRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkRoleBase.isCreateDateDirty();
            }
            case 1: {
                return pSWFLinkRoleBase.isCreateManDirty();
            }
            case 2: {
                return pSWFLinkRoleBase.isDynaModelFlagDirty();
            }
            case 3: {
                return pSWFLinkRoleBase.isMemoDirty();
            }
            case 4: {
                return pSWFLinkRoleBase.isPSDynaInstIdDirty();
            }
            case 5: {
                return pSWFLinkRoleBase.isPSSysMsgTemplIdDirty();
            }
            case 6: {
                return pSWFLinkRoleBase.isPSSysMsgTemplNameDirty();
            }
            case 7: {
                return pSWFLinkRoleBase.isPSWFLinkIdDirty();
            }
            case 8: {
                return pSWFLinkRoleBase.isPSWFLinkNameDirty();
            }
            case 9: {
                return pSWFLinkRoleBase.isPSWFLinkRoleIdDirty();
            }
            case 10: {
                return pSWFLinkRoleBase.isPSWFLinkRoleNameDirty();
            }
            case 11: {
                return pSWFLinkRoleBase.isPSWFProcessIdDirty();
            }
            case 12: {
                return pSWFLinkRoleBase.isPSWFProcRoleIdDirty();
            }
            case 13: {
                return pSWFLinkRoleBase.isPSWFProcRoleNameDirty();
            }
            case 14: {
                return pSWFLinkRoleBase.isPSWFVersionIdDirty();
            }
            case 15: {
                return pSWFLinkRoleBase.isUpdateDateDirty();
            }
            case 16: {
                return pSWFLinkRoleBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFLinkRoleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFLinkRoleBase pSWFLinkRoleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFLinkRoleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSWFLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkid", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSWFLinkId()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSWFLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkname", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSWFLinkName()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSWFLinkRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkroleid", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSWFLinkRoleId()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSWFLinkRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkrolename", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSWFLinkRoleName()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSWFProcessId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessid", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSWFProcessId()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSWFProcRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocroleid", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSWFProcRoleId()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSWFProcRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocrolename", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSWFProcRoleName()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFLinkRoleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFLinkRoleBase.getJSONValue((Object)pSWFLinkRoleBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFLinkRoleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFLinkRoleBase pSWFLinkRoleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFLinkRoleBase.getCreateDate() != null) {
            object = pSWFLinkRoleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFLinkRoleBase.getCreateMan() != null) {
            object = pSWFLinkRoleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getDynaModelFlag() != null) {
            object = pSWFLinkRoleBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkRoleBase.getMemo() != null) {
            object = pSWFLinkRoleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSDynaInstId() != null) {
            object = pSWFLinkRoleBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSSysMsgTemplId() != null) {
            object = pSWFLinkRoleBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSSysMsgTemplName() != null) {
            object = pSWFLinkRoleBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSWFLinkId() != null) {
            object = pSWFLinkRoleBase.getPSWFLinkId();
            xmlNode.setAttribute(FIELD_PSWFLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSWFLinkName() != null) {
            object = pSWFLinkRoleBase.getPSWFLinkName();
            xmlNode.setAttribute(FIELD_PSWFLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSWFLinkRoleId() != null) {
            object = pSWFLinkRoleBase.getPSWFLinkRoleId();
            xmlNode.setAttribute(FIELD_PSWFLINKROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSWFLinkRoleName() != null) {
            object = pSWFLinkRoleBase.getPSWFLinkRoleName();
            xmlNode.setAttribute(FIELD_PSWFLINKROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSWFProcessId() != null) {
            object = pSWFLinkRoleBase.getPSWFProcessId();
            xmlNode.setAttribute(FIELD_PSWFPROCESSID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSWFProcRoleId() != null) {
            object = pSWFLinkRoleBase.getPSWFProcRoleId();
            xmlNode.setAttribute(FIELD_PSWFPROCROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSWFProcRoleName() != null) {
            object = pSWFLinkRoleBase.getPSWFProcRoleName();
            xmlNode.setAttribute(FIELD_PSWFPROCROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getPSWFVersionId() != null) {
            object = pSWFLinkRoleBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkRoleBase.getUpdateDate() != null) {
            object = pSWFLinkRoleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFLinkRoleBase.getUpdateMan() != null) {
            object = pSWFLinkRoleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFLinkRoleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFLinkRoleBase pSWFLinkRoleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFLinkRoleBase.isCreateDateDirty() && (bl || pSWFLinkRoleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFLinkRoleBase.getCreateDate());
        }
        if (pSWFLinkRoleBase.isCreateManDirty() && (bl || pSWFLinkRoleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFLinkRoleBase.getCreateMan());
        }
        if (pSWFLinkRoleBase.isDynaModelFlagDirty() && (bl || pSWFLinkRoleBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFLinkRoleBase.getDynaModelFlag());
        }
        if (pSWFLinkRoleBase.isMemoDirty() && (bl || pSWFLinkRoleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFLinkRoleBase.getMemo());
        }
        if (pSWFLinkRoleBase.isPSDynaInstIdDirty() && (bl || pSWFLinkRoleBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFLinkRoleBase.getPSDynaInstId());
        }
        if (pSWFLinkRoleBase.isPSSysMsgTemplIdDirty() && (bl || pSWFLinkRoleBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSWFLinkRoleBase.getPSSysMsgTemplId());
        }
        if (pSWFLinkRoleBase.isPSSysMsgTemplNameDirty() && (bl || pSWFLinkRoleBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSWFLinkRoleBase.getPSSysMsgTemplName());
        }
        if (pSWFLinkRoleBase.isPSWFLinkIdDirty() && (bl || pSWFLinkRoleBase.getPSWFLinkId() != null)) {
            iDataObject.set(FIELD_PSWFLINKID, (Object)pSWFLinkRoleBase.getPSWFLinkId());
        }
        if (pSWFLinkRoleBase.isPSWFLinkNameDirty() && (bl || pSWFLinkRoleBase.getPSWFLinkName() != null)) {
            iDataObject.set(FIELD_PSWFLINKNAME, (Object)pSWFLinkRoleBase.getPSWFLinkName());
        }
        if (pSWFLinkRoleBase.isPSWFLinkRoleIdDirty() && (bl || pSWFLinkRoleBase.getPSWFLinkRoleId() != null)) {
            iDataObject.set(FIELD_PSWFLINKROLEID, (Object)pSWFLinkRoleBase.getPSWFLinkRoleId());
        }
        if (pSWFLinkRoleBase.isPSWFLinkRoleNameDirty() && (bl || pSWFLinkRoleBase.getPSWFLinkRoleName() != null)) {
            iDataObject.set(FIELD_PSWFLINKROLENAME, (Object)pSWFLinkRoleBase.getPSWFLinkRoleName());
        }
        if (pSWFLinkRoleBase.isPSWFProcessIdDirty() && (bl || pSWFLinkRoleBase.getPSWFProcessId() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSID, (Object)pSWFLinkRoleBase.getPSWFProcessId());
        }
        if (pSWFLinkRoleBase.isPSWFProcRoleIdDirty() && (bl || pSWFLinkRoleBase.getPSWFProcRoleId() != null)) {
            iDataObject.set(FIELD_PSWFPROCROLEID, (Object)pSWFLinkRoleBase.getPSWFProcRoleId());
        }
        if (pSWFLinkRoleBase.isPSWFProcRoleNameDirty() && (bl || pSWFLinkRoleBase.getPSWFProcRoleName() != null)) {
            iDataObject.set(FIELD_PSWFPROCROLENAME, (Object)pSWFLinkRoleBase.getPSWFProcRoleName());
        }
        if (pSWFLinkRoleBase.isPSWFVersionIdDirty() && (bl || pSWFLinkRoleBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFLinkRoleBase.getPSWFVersionId());
        }
        if (pSWFLinkRoleBase.isUpdateDateDirty() && (bl || pSWFLinkRoleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFLinkRoleBase.getUpdateDate());
        }
        if (pSWFLinkRoleBase.isUpdateManDirty() && (bl || pSWFLinkRoleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFLinkRoleBase.getUpdateMan());
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
        return PSWFLinkRoleBase.remove(this, n);
    }

    private static boolean remove(PSWFLinkRoleBase pSWFLinkRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFLinkRoleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWFLinkRoleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWFLinkRoleBase.resetDynaModelFlag();
                return true;
            }
            case 3: {
                pSWFLinkRoleBase.resetMemo();
                return true;
            }
            case 4: {
                pSWFLinkRoleBase.resetPSDynaInstId();
                return true;
            }
            case 5: {
                pSWFLinkRoleBase.resetPSSysMsgTemplId();
                return true;
            }
            case 6: {
                pSWFLinkRoleBase.resetPSSysMsgTemplName();
                return true;
            }
            case 7: {
                pSWFLinkRoleBase.resetPSWFLinkId();
                return true;
            }
            case 8: {
                pSWFLinkRoleBase.resetPSWFLinkName();
                return true;
            }
            case 9: {
                pSWFLinkRoleBase.resetPSWFLinkRoleId();
                return true;
            }
            case 10: {
                pSWFLinkRoleBase.resetPSWFLinkRoleName();
                return true;
            }
            case 11: {
                pSWFLinkRoleBase.resetPSWFProcessId();
                return true;
            }
            case 12: {
                pSWFLinkRoleBase.resetPSWFProcRoleId();
                return true;
            }
            case 13: {
                pSWFLinkRoleBase.resetPSWFProcRoleName();
                return true;
            }
            case 14: {
                pSWFLinkRoleBase.resetPSWFVersionId();
                return true;
            }
            case 15: {
                pSWFLinkRoleBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSWFLinkRoleBase.resetUpdateMan();
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
                pSSysMsgTemplService.autoGet(pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFLink getPSWFLink() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLink();
        }
        if (this.getPSWFLinkId() == null) {
            return null;
        }
        Integer n = this.objPSWFLinkLock;
        synchronized (n) {
            if (this.pswflink != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFLinkId(), (Object)this.pswflink.getPSWFLinkId()) != 0L) {
                this.pswflink = null;
            }
            if (this.pswflink == null) {
                PSWFLink pSWFLink = new PSWFLink();
                pSWFLink.setPSWFLinkId(this.getPSWFLinkId());
                PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
                pSWFLinkService.autoGet(pSWFLink);
                this.pswflink = pSWFLink;
            }
            return this.pswflink;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFProcRole getPSWFProcRole() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcRole();
        }
        if (this.getPSWFProcRoleId() == null) {
            return null;
        }
        Integer n = this.objPSWFProcRoleLock;
        synchronized (n) {
            if (this.pswfprocrole != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFProcRoleId(), (Object)this.pswfprocrole.getPSWFProcRoleId()) != 0L) {
                this.pswfprocrole = null;
            }
            if (this.pswfprocrole == null) {
                PSWFProcRole pSWFProcRole = new PSWFProcRole();
                pSWFProcRole.setPSWFProcRoleId(this.getPSWFProcRoleId());
                PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
                pSWFProcRoleService.autoGet(pSWFProcRole);
                this.pswfprocrole = pSWFProcRole;
            }
            return this.pswfprocrole;
        }
    }

    private PSWFLinkRoleBase getProxyEntity() {
        return this.proxyPSWFLinkRoleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFLinkRoleBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFLinkRoleBase) {
            this.proxyPSWFLinkRoleBase = (PSWFLinkRoleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 4);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 5);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 6);
        fieldIndexMap.put(FIELD_PSWFLINKID, 7);
        fieldIndexMap.put(FIELD_PSWFLINKNAME, 8);
        fieldIndexMap.put(FIELD_PSWFLINKROLEID, 9);
        fieldIndexMap.put(FIELD_PSWFLINKROLENAME, 10);
        fieldIndexMap.put(FIELD_PSWFPROCESSID, 11);
        fieldIndexMap.put(FIELD_PSWFPROCROLEID, 12);
        fieldIndexMap.put(FIELD_PSWFPROCROLENAME, 13);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
    }
}

