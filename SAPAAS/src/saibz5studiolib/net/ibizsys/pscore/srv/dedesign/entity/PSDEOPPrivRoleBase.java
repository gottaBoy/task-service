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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPriv;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEOPPrivRoleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEOPPrivRoleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_FILTERMODEL = "FILTERMODEL";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDEOPPRIVROLEID = "PSDEOPPRIVROLEID";
    public static final String FIELD_PSDEOPPRIVROLENAME = "PSDEOPPRIVROLENAME";
    public static final String FIELD_PSDEUSERROLEID = "PSDEUSERROLEID";
    public static final String FIELD_PSDEUSERROLENAME = "PSDEUSERROLENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String FIELD_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String FIELD_ROLETYPE = "ROLETYPE";
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
    private static final int INDEX_CUSTOMCOND = 2;
    private static final int INDEX_CUSTOMTYPE = 3;
    private static final int INDEX_DYNAMODELFLAG = 4;
    private static final int INDEX_FILTERMODEL = 5;
    private static final int INDEX_LOCKFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEDQID = 8;
    private static final int INDEX_PSDEDQNAME = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_PSDENAME = 11;
    private static final int INDEX_PSDEOPPRIVID = 12;
    private static final int INDEX_PSDEOPPRIVNAME = 13;
    private static final int INDEX_PSDEOPPRIVROLEID = 14;
    private static final int INDEX_PSDEOPPRIVROLENAME = 15;
    private static final int INDEX_PSDEUSERROLEID = 16;
    private static final int INDEX_PSDEUSERROLENAME = 17;
    private static final int INDEX_PSDYNAINSTID = 18;
    private static final int INDEX_PSSYSOPPRIVID = 19;
    private static final int INDEX_PSSYSOPPRIVNAME = 20;
    private static final int INDEX_ROLETYPE = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USERCAT = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_USERTAG3 = 27;
    private static final int INDEX_USERTAG4 = 28;
    private static final int INDEX_VALIDFLAG = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEOPPrivRoleBase proxyPSDEOPPrivRoleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean filtermodelDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psdeopprivroleidDirtyFlag = false;
    private boolean psdeopprivrolenameDirtyFlag = false;
    private boolean psdeuserroleidDirtyFlag = false;
    private boolean psdeuserrolenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysopprividDirtyFlag = false;
    private boolean pssysopprivnameDirtyFlag = false;
    private boolean roletypeDirtyFlag = false;
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
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="filtermodel")
    private String filtermodel;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psdeopprivroleid")
    private String psdeopprivroleid;
    @Column(name="psdeopprivrolename")
    private String psdeopprivrolename;
    @Column(name="psdeuserroleid")
    private String psdeuserroleid;
    @Column(name="psdeuserrolename")
    private String psdeuserrolename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysopprivid")
    private String pssysopprivid;
    @Column(name="pssysopprivname")
    private String pssysopprivname;
    @Column(name="roletype")
    private String roletype;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objPSDEUserRoleLock = new Integer(1);
    private PSDEUserRole psdeuserrole = null;
    private Integer objPSSysOPPrivLock = new Integer(1);
    private PSSysOPPriv pssysoppriv = null;

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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
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

    public void setFilterModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filtermodel = string;
        this.filtermodelDirtyFlag = true;
    }

    public String getFilterModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterModel();
        }
        return this.filtermodel;
    }

    public boolean isFilterModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterModelDirty();
        }
        return this.filtermodelDirtyFlag;
    }

    public void resetFilterModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterModel();
            return;
        }
        this.filtermodelDirtyFlag = false;
        this.filtermodel = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSDEDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqid = string;
        this.psdedqidDirtyFlag = true;
    }

    public String getPSDEDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQId();
        }
        return this.psdedqid;
    }

    public boolean isPSDEDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQIdDirty();
        }
        return this.psdedqidDirtyFlag;
    }

    public void resetPSDEDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQId();
            return;
        }
        this.psdedqidDirtyFlag = false;
        this.psdedqid = null;
    }

    public void setPSDEDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqname = string;
        this.psdedqnameDirtyFlag = true;
    }

    public String getPSDEDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQName();
        }
        return this.psdedqname;
    }

    public boolean isPSDEDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQNameDirty();
        }
        return this.psdedqnameDirtyFlag;
    }

    public void resetPSDEDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQName();
            return;
        }
        this.psdedqnameDirtyFlag = false;
        this.psdedqname = null;
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

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
    }

    public void setPSDEOPPrivRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivroleid = string;
        this.psdeopprivroleidDirtyFlag = true;
    }

    public String getPSDEOPPrivRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivRoleId();
        }
        return this.psdeopprivroleid;
    }

    public boolean isPSDEOPPrivRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivRoleIdDirty();
        }
        return this.psdeopprivroleidDirtyFlag;
    }

    public void resetPSDEOPPrivRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivRoleId();
            return;
        }
        this.psdeopprivroleidDirtyFlag = false;
        this.psdeopprivroleid = null;
    }

    public void setPSDEOPPrivRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivrolename = string;
        this.psdeopprivrolenameDirtyFlag = true;
    }

    public String getPSDEOPPrivRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivRoleName();
        }
        return this.psdeopprivrolename;
    }

    public boolean isPSDEOPPrivRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivRoleNameDirty();
        }
        return this.psdeopprivrolenameDirtyFlag;
    }

    public void resetPSDEOPPrivRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivRoleName();
            return;
        }
        this.psdeopprivrolenameDirtyFlag = false;
        this.psdeopprivrolename = null;
    }

    public void setPSDEUserRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUserRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuserroleid = string;
        this.psdeuserroleidDirtyFlag = true;
    }

    public String getPSDEUserRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRoleId();
        }
        return this.psdeuserroleid;
    }

    public boolean isPSDEUserRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUserRoleIdDirty();
        }
        return this.psdeuserroleidDirtyFlag;
    }

    public void resetPSDEUserRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUserRoleId();
            return;
        }
        this.psdeuserroleidDirtyFlag = false;
        this.psdeuserroleid = null;
    }

    public void setPSDEUserRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUserRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuserrolename = string;
        this.psdeuserrolenameDirtyFlag = true;
    }

    public String getPSDEUserRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRoleName();
        }
        return this.psdeuserrolename;
    }

    public boolean isPSDEUserRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUserRoleNameDirty();
        }
        return this.psdeuserrolenameDirtyFlag;
    }

    public void resetPSDEUserRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUserRoleName();
            return;
        }
        this.psdeuserrolenameDirtyFlag = false;
        this.psdeuserrolename = null;
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

    public void setPSSysOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysopprivid = string;
        this.pssysopprividDirtyFlag = true;
    }

    public String getPSSysOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPrivId();
        }
        return this.pssysopprivid;
    }

    public boolean isPSSysOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOPPrivIdDirty();
        }
        return this.pssysopprividDirtyFlag;
    }

    public void resetPSSysOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOPPrivId();
            return;
        }
        this.pssysopprividDirtyFlag = false;
        this.pssysopprivid = null;
    }

    public void setPSSysOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysopprivname = string;
        this.pssysopprivnameDirtyFlag = true;
    }

    public String getPSSysOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPrivName();
        }
        return this.pssysopprivname;
    }

    public boolean isPSSysOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOPPrivNameDirty();
        }
        return this.pssysopprivnameDirtyFlag;
    }

    public void resetPSSysOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOPPrivName();
            return;
        }
        this.pssysopprivnameDirtyFlag = false;
        this.pssysopprivname = null;
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
        PSDEOPPrivRoleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEOPPrivRoleBase pSDEOPPrivRoleBase) {
        pSDEOPPrivRoleBase.resetCreateDate();
        pSDEOPPrivRoleBase.resetCreateMan();
        pSDEOPPrivRoleBase.resetCustomCond();
        pSDEOPPrivRoleBase.resetCustomType();
        pSDEOPPrivRoleBase.resetDynaModelFlag();
        pSDEOPPrivRoleBase.resetFilterModel();
        pSDEOPPrivRoleBase.resetLockFlag();
        pSDEOPPrivRoleBase.resetMemo();
        pSDEOPPrivRoleBase.resetPSDEDQId();
        pSDEOPPrivRoleBase.resetPSDEDQName();
        pSDEOPPrivRoleBase.resetPSDEId();
        pSDEOPPrivRoleBase.resetPSDEName();
        pSDEOPPrivRoleBase.resetPSDEOPPrivId();
        pSDEOPPrivRoleBase.resetPSDEOPPrivName();
        pSDEOPPrivRoleBase.resetPSDEOPPrivRoleId();
        pSDEOPPrivRoleBase.resetPSDEOPPrivRoleName();
        pSDEOPPrivRoleBase.resetPSDEUserRoleId();
        pSDEOPPrivRoleBase.resetPSDEUserRoleName();
        pSDEOPPrivRoleBase.resetPSDynaInstId();
        pSDEOPPrivRoleBase.resetPSSysOPPrivId();
        pSDEOPPrivRoleBase.resetPSSysOPPrivName();
        pSDEOPPrivRoleBase.resetRoleType();
        pSDEOPPrivRoleBase.resetUpdateDate();
        pSDEOPPrivRoleBase.resetUpdateMan();
        pSDEOPPrivRoleBase.resetUserCat();
        pSDEOPPrivRoleBase.resetUserTag();
        pSDEOPPrivRoleBase.resetUserTag2();
        pSDEOPPrivRoleBase.resetUserTag3();
        pSDEOPPrivRoleBase.resetUserTag4();
        pSDEOPPrivRoleBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isFilterModelDirty()) {
            hashMap.put(FIELD_FILTERMODEL, this.getFilterModel());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEDQIdDirty()) {
            hashMap.put(FIELD_PSDEDQID, this.getPSDEDQId());
        }
        if (!bl || this.isPSDEDQNameDirty()) {
            hashMap.put(FIELD_PSDEDQNAME, this.getPSDEDQName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
        }
        if (!bl || this.isPSDEOPPrivRoleIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVROLEID, this.getPSDEOPPrivRoleId());
        }
        if (!bl || this.isPSDEOPPrivRoleNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVROLENAME, this.getPSDEOPPrivRoleName());
        }
        if (!bl || this.isPSDEUserRoleIdDirty()) {
            hashMap.put(FIELD_PSDEUSERROLEID, this.getPSDEUserRoleId());
        }
        if (!bl || this.isPSDEUserRoleNameDirty()) {
            hashMap.put(FIELD_PSDEUSERROLENAME, this.getPSDEUserRoleName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysOPPrivIdDirty()) {
            hashMap.put(FIELD_PSSYSOPPRIVID, this.getPSSysOPPrivId());
        }
        if (!bl || this.isPSSysOPPrivNameDirty()) {
            hashMap.put(FIELD_PSSYSOPPRIVNAME, this.getPSSysOPPrivName());
        }
        if (!bl || this.isRoleTypeDirty()) {
            hashMap.put(FIELD_ROLETYPE, this.getRoleType());
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
        return PSDEOPPrivRoleBase.get(this, n);
    }

    private static Object get(PSDEOPPrivRoleBase pSDEOPPrivRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEOPPrivRoleBase.getCreateDate();
            }
            case 1: {
                return pSDEOPPrivRoleBase.getCreateMan();
            }
            case 2: {
                return pSDEOPPrivRoleBase.getCustomCond();
            }
            case 3: {
                return pSDEOPPrivRoleBase.getCustomType();
            }
            case 4: {
                return pSDEOPPrivRoleBase.getDynaModelFlag();
            }
            case 5: {
                return pSDEOPPrivRoleBase.getFilterModel();
            }
            case 6: {
                return pSDEOPPrivRoleBase.getLockFlag();
            }
            case 7: {
                return pSDEOPPrivRoleBase.getMemo();
            }
            case 8: {
                return pSDEOPPrivRoleBase.getPSDEDQId();
            }
            case 9: {
                return pSDEOPPrivRoleBase.getPSDEDQName();
            }
            case 10: {
                return pSDEOPPrivRoleBase.getPSDEId();
            }
            case 11: {
                return pSDEOPPrivRoleBase.getPSDEName();
            }
            case 12: {
                return pSDEOPPrivRoleBase.getPSDEOPPrivId();
            }
            case 13: {
                return pSDEOPPrivRoleBase.getPSDEOPPrivName();
            }
            case 14: {
                return pSDEOPPrivRoleBase.getPSDEOPPrivRoleId();
            }
            case 15: {
                return pSDEOPPrivRoleBase.getPSDEOPPrivRoleName();
            }
            case 16: {
                return pSDEOPPrivRoleBase.getPSDEUserRoleId();
            }
            case 17: {
                return pSDEOPPrivRoleBase.getPSDEUserRoleName();
            }
            case 18: {
                return pSDEOPPrivRoleBase.getPSDynaInstId();
            }
            case 19: {
                return pSDEOPPrivRoleBase.getPSSysOPPrivId();
            }
            case 20: {
                return pSDEOPPrivRoleBase.getPSSysOPPrivName();
            }
            case 21: {
                return pSDEOPPrivRoleBase.getRoleType();
            }
            case 22: {
                return pSDEOPPrivRoleBase.getUpdateDate();
            }
            case 23: {
                return pSDEOPPrivRoleBase.getUpdateMan();
            }
            case 24: {
                return pSDEOPPrivRoleBase.getUserCat();
            }
            case 25: {
                return pSDEOPPrivRoleBase.getUserTag();
            }
            case 26: {
                return pSDEOPPrivRoleBase.getUserTag2();
            }
            case 27: {
                return pSDEOPPrivRoleBase.getUserTag3();
            }
            case 28: {
                return pSDEOPPrivRoleBase.getUserTag4();
            }
            case 29: {
                return pSDEOPPrivRoleBase.getValidFlag();
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
        PSDEOPPrivRoleBase.set(this, n, object);
    }

    private static void set(PSDEOPPrivRoleBase pSDEOPPrivRoleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEOPPrivRoleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEOPPrivRoleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEOPPrivRoleBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEOPPrivRoleBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEOPPrivRoleBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEOPPrivRoleBase.setFilterModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEOPPrivRoleBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEOPPrivRoleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEOPPrivRoleBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEOPPrivRoleBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEOPPrivRoleBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEOPPrivRoleBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEOPPrivRoleBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEOPPrivRoleBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEOPPrivRoleBase.setPSDEOPPrivRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEOPPrivRoleBase.setPSDEOPPrivRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEOPPrivRoleBase.setPSDEUserRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEOPPrivRoleBase.setPSDEUserRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEOPPrivRoleBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEOPPrivRoleBase.setPSSysOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEOPPrivRoleBase.setPSSysOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEOPPrivRoleBase.setRoleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEOPPrivRoleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDEOPPrivRoleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEOPPrivRoleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEOPPrivRoleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEOPPrivRoleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEOPPrivRoleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEOPPrivRoleBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEOPPrivRoleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEOPPrivRoleBase.isNull(this, n);
    }

    private static boolean isNull(PSDEOPPrivRoleBase pSDEOPPrivRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEOPPrivRoleBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEOPPrivRoleBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEOPPrivRoleBase.getCustomCond() == null;
            }
            case 3: {
                return pSDEOPPrivRoleBase.getCustomType() == null;
            }
            case 4: {
                return pSDEOPPrivRoleBase.getDynaModelFlag() == null;
            }
            case 5: {
                return pSDEOPPrivRoleBase.getFilterModel() == null;
            }
            case 6: {
                return pSDEOPPrivRoleBase.getLockFlag() == null;
            }
            case 7: {
                return pSDEOPPrivRoleBase.getMemo() == null;
            }
            case 8: {
                return pSDEOPPrivRoleBase.getPSDEDQId() == null;
            }
            case 9: {
                return pSDEOPPrivRoleBase.getPSDEDQName() == null;
            }
            case 10: {
                return pSDEOPPrivRoleBase.getPSDEId() == null;
            }
            case 11: {
                return pSDEOPPrivRoleBase.getPSDEName() == null;
            }
            case 12: {
                return pSDEOPPrivRoleBase.getPSDEOPPrivId() == null;
            }
            case 13: {
                return pSDEOPPrivRoleBase.getPSDEOPPrivName() == null;
            }
            case 14: {
                return pSDEOPPrivRoleBase.getPSDEOPPrivRoleId() == null;
            }
            case 15: {
                return pSDEOPPrivRoleBase.getPSDEOPPrivRoleName() == null;
            }
            case 16: {
                return pSDEOPPrivRoleBase.getPSDEUserRoleId() == null;
            }
            case 17: {
                return pSDEOPPrivRoleBase.getPSDEUserRoleName() == null;
            }
            case 18: {
                return pSDEOPPrivRoleBase.getPSDynaInstId() == null;
            }
            case 19: {
                return pSDEOPPrivRoleBase.getPSSysOPPrivId() == null;
            }
            case 20: {
                return pSDEOPPrivRoleBase.getPSSysOPPrivName() == null;
            }
            case 21: {
                return pSDEOPPrivRoleBase.getRoleType() == null;
            }
            case 22: {
                return pSDEOPPrivRoleBase.getUpdateDate() == null;
            }
            case 23: {
                return pSDEOPPrivRoleBase.getUpdateMan() == null;
            }
            case 24: {
                return pSDEOPPrivRoleBase.getUserCat() == null;
            }
            case 25: {
                return pSDEOPPrivRoleBase.getUserTag() == null;
            }
            case 26: {
                return pSDEOPPrivRoleBase.getUserTag2() == null;
            }
            case 27: {
                return pSDEOPPrivRoleBase.getUserTag3() == null;
            }
            case 28: {
                return pSDEOPPrivRoleBase.getUserTag4() == null;
            }
            case 29: {
                return pSDEOPPrivRoleBase.getValidFlag() == null;
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
        return PSDEOPPrivRoleBase.contains(this, n);
    }

    private static boolean contains(PSDEOPPrivRoleBase pSDEOPPrivRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEOPPrivRoleBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEOPPrivRoleBase.isCreateManDirty();
            }
            case 2: {
                return pSDEOPPrivRoleBase.isCustomCondDirty();
            }
            case 3: {
                return pSDEOPPrivRoleBase.isCustomTypeDirty();
            }
            case 4: {
                return pSDEOPPrivRoleBase.isDynaModelFlagDirty();
            }
            case 5: {
                return pSDEOPPrivRoleBase.isFilterModelDirty();
            }
            case 6: {
                return pSDEOPPrivRoleBase.isLockFlagDirty();
            }
            case 7: {
                return pSDEOPPrivRoleBase.isMemoDirty();
            }
            case 8: {
                return pSDEOPPrivRoleBase.isPSDEDQIdDirty();
            }
            case 9: {
                return pSDEOPPrivRoleBase.isPSDEDQNameDirty();
            }
            case 10: {
                return pSDEOPPrivRoleBase.isPSDEIdDirty();
            }
            case 11: {
                return pSDEOPPrivRoleBase.isPSDENameDirty();
            }
            case 12: {
                return pSDEOPPrivRoleBase.isPSDEOPPrivIdDirty();
            }
            case 13: {
                return pSDEOPPrivRoleBase.isPSDEOPPrivNameDirty();
            }
            case 14: {
                return pSDEOPPrivRoleBase.isPSDEOPPrivRoleIdDirty();
            }
            case 15: {
                return pSDEOPPrivRoleBase.isPSDEOPPrivRoleNameDirty();
            }
            case 16: {
                return pSDEOPPrivRoleBase.isPSDEUserRoleIdDirty();
            }
            case 17: {
                return pSDEOPPrivRoleBase.isPSDEUserRoleNameDirty();
            }
            case 18: {
                return pSDEOPPrivRoleBase.isPSDynaInstIdDirty();
            }
            case 19: {
                return pSDEOPPrivRoleBase.isPSSysOPPrivIdDirty();
            }
            case 20: {
                return pSDEOPPrivRoleBase.isPSSysOPPrivNameDirty();
            }
            case 21: {
                return pSDEOPPrivRoleBase.isRoleTypeDirty();
            }
            case 22: {
                return pSDEOPPrivRoleBase.isUpdateDateDirty();
            }
            case 23: {
                return pSDEOPPrivRoleBase.isUpdateManDirty();
            }
            case 24: {
                return pSDEOPPrivRoleBase.isUserCatDirty();
            }
            case 25: {
                return pSDEOPPrivRoleBase.isUserTagDirty();
            }
            case 26: {
                return pSDEOPPrivRoleBase.isUserTag2Dirty();
            }
            case 27: {
                return pSDEOPPrivRoleBase.isUserTag3Dirty();
            }
            case 28: {
                return pSDEOPPrivRoleBase.isUserTag4Dirty();
            }
            case 29: {
                return pSDEOPPrivRoleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEOPPrivRoleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEOPPrivRoleBase pSDEOPPrivRoleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEOPPrivRoleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getFilterModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filtermodel", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getFilterModel()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEOPPrivRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivroleid", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEOPPrivRoleId()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEOPPrivRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivrolename", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEOPPrivRoleName()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEUserRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuserroleid", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEUserRoleId()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEUserRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuserrolename", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDEUserRoleName()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSSysOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysopprivid", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSSysOPPrivId()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getPSSysOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysopprivname", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getPSSysOPPrivName()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getRoleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"roletype", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getRoleType()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEOPPrivRoleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEOPPrivRoleBase.getJSONValue((Object)pSDEOPPrivRoleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEOPPrivRoleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEOPPrivRoleBase pSDEOPPrivRoleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEOPPrivRoleBase.getCreateDate() != null) {
            object = pSDEOPPrivRoleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEOPPrivRoleBase.getCreateMan() != null) {
            object = pSDEOPPrivRoleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getCustomCond() != null) {
            object = pSDEOPPrivRoleBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getCustomType() != null) {
            object = pSDEOPPrivRoleBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getDynaModelFlag() != null) {
            object = pSDEOPPrivRoleBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEOPPrivRoleBase.getFilterModel() != null) {
            object = pSDEOPPrivRoleBase.getFilterModel();
            xmlNode.setAttribute(FIELD_FILTERMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getLockFlag() != null) {
            object = pSDEOPPrivRoleBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEOPPrivRoleBase.getMemo() != null) {
            object = pSDEOPPrivRoleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEDQId() != null) {
            object = pSDEOPPrivRoleBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEDQName() != null) {
            object = pSDEOPPrivRoleBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEId() != null) {
            object = pSDEOPPrivRoleBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEName() != null) {
            object = pSDEOPPrivRoleBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEOPPrivId() != null) {
            object = pSDEOPPrivRoleBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEOPPrivName() != null) {
            object = pSDEOPPrivRoleBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEOPPrivRoleId() != null) {
            object = pSDEOPPrivRoleBase.getPSDEOPPrivRoleId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEOPPrivRoleName() != null) {
            object = pSDEOPPrivRoleBase.getPSDEOPPrivRoleName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEUserRoleId() != null) {
            object = pSDEOPPrivRoleBase.getPSDEUserRoleId();
            xmlNode.setAttribute(FIELD_PSDEUSERROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDEUserRoleName() != null) {
            object = pSDEOPPrivRoleBase.getPSDEUserRoleName();
            xmlNode.setAttribute(FIELD_PSDEUSERROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSDynaInstId() != null) {
            object = pSDEOPPrivRoleBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSSysOPPrivId() != null) {
            object = pSDEOPPrivRoleBase.getPSSysOPPrivId();
            xmlNode.setAttribute(FIELD_PSSYSOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getPSSysOPPrivName() != null) {
            object = pSDEOPPrivRoleBase.getPSSysOPPrivName();
            xmlNode.setAttribute(FIELD_PSSYSOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getRoleType() != null) {
            object = pSDEOPPrivRoleBase.getRoleType();
            xmlNode.setAttribute(FIELD_ROLETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getUpdateDate() != null) {
            object = pSDEOPPrivRoleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEOPPrivRoleBase.getUpdateMan() != null) {
            object = pSDEOPPrivRoleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getUserCat() != null) {
            object = pSDEOPPrivRoleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getUserTag() != null) {
            object = pSDEOPPrivRoleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getUserTag2() != null) {
            object = pSDEOPPrivRoleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getUserTag3() != null) {
            object = pSDEOPPrivRoleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getUserTag4() != null) {
            object = pSDEOPPrivRoleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivRoleBase.getValidFlag() != null) {
            object = pSDEOPPrivRoleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEOPPrivRoleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEOPPrivRoleBase pSDEOPPrivRoleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEOPPrivRoleBase.isCreateDateDirty() && (bl || pSDEOPPrivRoleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEOPPrivRoleBase.getCreateDate());
        }
        if (pSDEOPPrivRoleBase.isCreateManDirty() && (bl || pSDEOPPrivRoleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEOPPrivRoleBase.getCreateMan());
        }
        if (pSDEOPPrivRoleBase.isCustomCondDirty() && (bl || pSDEOPPrivRoleBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDEOPPrivRoleBase.getCustomCond());
        }
        if (pSDEOPPrivRoleBase.isCustomTypeDirty() && (bl || pSDEOPPrivRoleBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDEOPPrivRoleBase.getCustomType());
        }
        if (pSDEOPPrivRoleBase.isDynaModelFlagDirty() && (bl || pSDEOPPrivRoleBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEOPPrivRoleBase.getDynaModelFlag());
        }
        if (pSDEOPPrivRoleBase.isFilterModelDirty() && (bl || pSDEOPPrivRoleBase.getFilterModel() != null)) {
            iDataObject.set(FIELD_FILTERMODEL, (Object)pSDEOPPrivRoleBase.getFilterModel());
        }
        if (pSDEOPPrivRoleBase.isLockFlagDirty() && (bl || pSDEOPPrivRoleBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEOPPrivRoleBase.getLockFlag());
        }
        if (pSDEOPPrivRoleBase.isMemoDirty() && (bl || pSDEOPPrivRoleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEOPPrivRoleBase.getMemo());
        }
        if (pSDEOPPrivRoleBase.isPSDEDQIdDirty() && (bl || pSDEOPPrivRoleBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDEOPPrivRoleBase.getPSDEDQId());
        }
        if (pSDEOPPrivRoleBase.isPSDEDQNameDirty() && (bl || pSDEOPPrivRoleBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDEOPPrivRoleBase.getPSDEDQName());
        }
        if (pSDEOPPrivRoleBase.isPSDEIdDirty() && (bl || pSDEOPPrivRoleBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEOPPrivRoleBase.getPSDEId());
        }
        if (pSDEOPPrivRoleBase.isPSDENameDirty() && (bl || pSDEOPPrivRoleBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEOPPrivRoleBase.getPSDEName());
        }
        if (pSDEOPPrivRoleBase.isPSDEOPPrivIdDirty() && (bl || pSDEOPPrivRoleBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEOPPrivRoleBase.getPSDEOPPrivId());
        }
        if (pSDEOPPrivRoleBase.isPSDEOPPrivNameDirty() && (bl || pSDEOPPrivRoleBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEOPPrivRoleBase.getPSDEOPPrivName());
        }
        if (pSDEOPPrivRoleBase.isPSDEOPPrivRoleIdDirty() && (bl || pSDEOPPrivRoleBase.getPSDEOPPrivRoleId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVROLEID, (Object)pSDEOPPrivRoleBase.getPSDEOPPrivRoleId());
        }
        if (pSDEOPPrivRoleBase.isPSDEOPPrivRoleNameDirty() && (bl || pSDEOPPrivRoleBase.getPSDEOPPrivRoleName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVROLENAME, (Object)pSDEOPPrivRoleBase.getPSDEOPPrivRoleName());
        }
        if (pSDEOPPrivRoleBase.isPSDEUserRoleIdDirty() && (bl || pSDEOPPrivRoleBase.getPSDEUserRoleId() != null)) {
            iDataObject.set(FIELD_PSDEUSERROLEID, (Object)pSDEOPPrivRoleBase.getPSDEUserRoleId());
        }
        if (pSDEOPPrivRoleBase.isPSDEUserRoleNameDirty() && (bl || pSDEOPPrivRoleBase.getPSDEUserRoleName() != null)) {
            iDataObject.set(FIELD_PSDEUSERROLENAME, (Object)pSDEOPPrivRoleBase.getPSDEUserRoleName());
        }
        if (pSDEOPPrivRoleBase.isPSDynaInstIdDirty() && (bl || pSDEOPPrivRoleBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEOPPrivRoleBase.getPSDynaInstId());
        }
        if (pSDEOPPrivRoleBase.isPSSysOPPrivIdDirty() && (bl || pSDEOPPrivRoleBase.getPSSysOPPrivId() != null)) {
            iDataObject.set(FIELD_PSSYSOPPRIVID, (Object)pSDEOPPrivRoleBase.getPSSysOPPrivId());
        }
        if (pSDEOPPrivRoleBase.isPSSysOPPrivNameDirty() && (bl || pSDEOPPrivRoleBase.getPSSysOPPrivName() != null)) {
            iDataObject.set(FIELD_PSSYSOPPRIVNAME, (Object)pSDEOPPrivRoleBase.getPSSysOPPrivName());
        }
        if (pSDEOPPrivRoleBase.isRoleTypeDirty() && (bl || pSDEOPPrivRoleBase.getRoleType() != null)) {
            iDataObject.set(FIELD_ROLETYPE, (Object)pSDEOPPrivRoleBase.getRoleType());
        }
        if (pSDEOPPrivRoleBase.isUpdateDateDirty() && (bl || pSDEOPPrivRoleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEOPPrivRoleBase.getUpdateDate());
        }
        if (pSDEOPPrivRoleBase.isUpdateManDirty() && (bl || pSDEOPPrivRoleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEOPPrivRoleBase.getUpdateMan());
        }
        if (pSDEOPPrivRoleBase.isUserCatDirty() && (bl || pSDEOPPrivRoleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEOPPrivRoleBase.getUserCat());
        }
        if (pSDEOPPrivRoleBase.isUserTagDirty() && (bl || pSDEOPPrivRoleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEOPPrivRoleBase.getUserTag());
        }
        if (pSDEOPPrivRoleBase.isUserTag2Dirty() && (bl || pSDEOPPrivRoleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEOPPrivRoleBase.getUserTag2());
        }
        if (pSDEOPPrivRoleBase.isUserTag3Dirty() && (bl || pSDEOPPrivRoleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEOPPrivRoleBase.getUserTag3());
        }
        if (pSDEOPPrivRoleBase.isUserTag4Dirty() && (bl || pSDEOPPrivRoleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEOPPrivRoleBase.getUserTag4());
        }
        if (pSDEOPPrivRoleBase.isValidFlagDirty() && (bl || pSDEOPPrivRoleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEOPPrivRoleBase.getValidFlag());
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
        return PSDEOPPrivRoleBase.remove(this, n);
    }

    private static boolean remove(PSDEOPPrivRoleBase pSDEOPPrivRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEOPPrivRoleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEOPPrivRoleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEOPPrivRoleBase.resetCustomCond();
                return true;
            }
            case 3: {
                pSDEOPPrivRoleBase.resetCustomType();
                return true;
            }
            case 4: {
                pSDEOPPrivRoleBase.resetDynaModelFlag();
                return true;
            }
            case 5: {
                pSDEOPPrivRoleBase.resetFilterModel();
                return true;
            }
            case 6: {
                pSDEOPPrivRoleBase.resetLockFlag();
                return true;
            }
            case 7: {
                pSDEOPPrivRoleBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEOPPrivRoleBase.resetPSDEDQId();
                return true;
            }
            case 9: {
                pSDEOPPrivRoleBase.resetPSDEDQName();
                return true;
            }
            case 10: {
                pSDEOPPrivRoleBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSDEOPPrivRoleBase.resetPSDEName();
                return true;
            }
            case 12: {
                pSDEOPPrivRoleBase.resetPSDEOPPrivId();
                return true;
            }
            case 13: {
                pSDEOPPrivRoleBase.resetPSDEOPPrivName();
                return true;
            }
            case 14: {
                pSDEOPPrivRoleBase.resetPSDEOPPrivRoleId();
                return true;
            }
            case 15: {
                pSDEOPPrivRoleBase.resetPSDEOPPrivRoleName();
                return true;
            }
            case 16: {
                pSDEOPPrivRoleBase.resetPSDEUserRoleId();
                return true;
            }
            case 17: {
                pSDEOPPrivRoleBase.resetPSDEUserRoleName();
                return true;
            }
            case 18: {
                pSDEOPPrivRoleBase.resetPSDynaInstId();
                return true;
            }
            case 19: {
                pSDEOPPrivRoleBase.resetPSSysOPPrivId();
                return true;
            }
            case 20: {
                pSDEOPPrivRoleBase.resetPSSysOPPrivName();
                return true;
            }
            case 21: {
                pSDEOPPrivRoleBase.resetRoleType();
                return true;
            }
            case 22: {
                pSDEOPPrivRoleBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSDEOPPrivRoleBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSDEOPPrivRoleBase.resetUserCat();
                return true;
            }
            case 25: {
                pSDEOPPrivRoleBase.resetUserTag();
                return true;
            }
            case 26: {
                pSDEOPPrivRoleBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSDEOPPrivRoleBase.resetUserTag3();
                return true;
            }
            case 28: {
                pSDEOPPrivRoleBase.resetUserTag4();
                return true;
            }
            case 29: {
                pSDEOPPrivRoleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDEDataQuery getPSDEDQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQ();
        }
        if (this.getPSDEDQId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQLock;
        synchronized (n) {
            if (this.psdedq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQId(), (Object)this.psdedq.getPSDEDataQueryId()) != 0L) {
                this.psdedq = null;
            }
            if (this.psdedq == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDQId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet((IEntity)pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPriv();
        }
        if (this.getPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSDEOPPrivLock;
        synchronized (n) {
            if (this.psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEOPPrivId(), (Object)this.psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.psdeoppriv = null;
            }
            if (this.psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUserRole getPSDEUserRole() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRole();
        }
        if (this.getPSDEUserRoleId() == null) {
            return null;
        }
        Integer n = this.objPSDEUserRoleLock;
        synchronized (n) {
            if (this.psdeuserrole != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUserRoleId(), (Object)this.psdeuserrole.getPSDEUserRoleId()) != 0L) {
                this.psdeuserrole = null;
            }
            if (this.psdeuserrole == null) {
                PSDEUserRole pSDEUserRole = new PSDEUserRole();
                pSDEUserRole.setPSDEUserRoleId(this.getPSDEUserRoleId());
                PSDEUserRoleService pSDEUserRoleService = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, (SessionFactory)this.getSessionFactory());
                pSDEUserRoleService.autoGet((IEntity)pSDEUserRole);
                this.psdeuserrole = pSDEUserRole;
            }
            return this.psdeuserrole;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysOPPriv getPSSysOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPriv();
        }
        if (this.getPSSysOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSSysOPPrivLock;
        synchronized (n) {
            if (this.pssysoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysOPPrivId(), (Object)this.pssysoppriv.getPSSysOPPrivId()) != 0L) {
                this.pssysoppriv = null;
            }
            if (this.pssysoppriv == null) {
                PSSysOPPriv pSSysOPPriv = new PSSysOPPriv();
                pSSysOPPriv.setPSSysOPPrivId(this.getPSSysOPPrivId());
                PSSysOPPrivService pSSysOPPrivService = (PSSysOPPrivService)ServiceGlobal.getService(PSSysOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSSysOPPrivService.autoGet((IEntity)pSSysOPPriv);
                this.pssysoppriv = pSSysOPPriv;
            }
            return this.pssysoppriv;
        }
    }

    private PSDEOPPrivRoleBase getProxyEntity() {
        return this.proxyPSDEOPPrivRoleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEOPPrivRoleBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEOPPrivRoleBase) {
            this.proxyPSDEOPPrivRoleBase = (PSDEOPPrivRoleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 2);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 3);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 4);
        fieldIndexMap.put(FIELD_FILTERMODEL, 5);
        fieldIndexMap.put(FIELD_LOCKFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEDQID, 8);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_PSDENAME, 11);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 12);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 13);
        fieldIndexMap.put(FIELD_PSDEOPPRIVROLEID, 14);
        fieldIndexMap.put(FIELD_PSDEOPPRIVROLENAME, 15);
        fieldIndexMap.put(FIELD_PSDEUSERROLEID, 16);
        fieldIndexMap.put(FIELD_PSDEUSERROLENAME, 17);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 18);
        fieldIndexMap.put(FIELD_PSSYSOPPRIVID, 19);
        fieldIndexMap.put(FIELD_PSSYSOPPRIVNAME, 20);
        fieldIndexMap.put(FIELD_ROLETYPE, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USERCAT, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_USERTAG3, 27);
        fieldIndexMap.put(FIELD_USERTAG4, 28);
        fieldIndexMap.put(FIELD_VALIDFLAG, 29);
    }
}

