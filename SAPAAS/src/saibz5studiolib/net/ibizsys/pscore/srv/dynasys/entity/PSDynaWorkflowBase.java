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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaWorkflowBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaWorkflowBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEMOB = "ENABLEMOB";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAWORKFLOWID = "PSDYNAWORKFLOWID";
    public static final String FIELD_PSDYNAWORKFLOWNAME = "PSDYNAWORKFLOWNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SRCPSDYNADETEMPLID = "SRCPSDYNADETEMPLID";
    public static final String FIELD_SRCPSDYNADETEMPLNAME = "SRCPSDYNADETEMPLNAME";
    public static final String FIELD_SRCPSDYNAWORKFLOWID = "SRCPSDYNAWORKFLOWID";
    public static final String FIELD_SRCPSDYNAWORKFLOWNAME = "SRCPSDYNAWORKFLOWNAME";
    public static final String FIELD_SRCTYPE = "SRCTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODELFLAG = 2;
    private static final int INDEX_ENABLEMOB = 3;
    private static final int INDEX_LOCKFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDENAME = 6;
    private static final int INDEX_PSDYNAINSTID = 7;
    private static final int INDEX_PSDYNAWORKFLOWID = 8;
    private static final int INDEX_PSDYNAWORKFLOWNAME = 9;
    private static final int INDEX_PSSYSTEMID = 10;
    private static final int INDEX_PSSYSTEMNAME = 11;
    private static final int INDEX_SRCPSDYNADETEMPLID = 12;
    private static final int INDEX_SRCPSDYNADETEMPLNAME = 13;
    private static final int INDEX_SRCPSDYNAWORKFLOWID = 14;
    private static final int INDEX_SRCPSDYNAWORKFLOWNAME = 15;
    private static final int INDEX_SRCTYPE = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaWorkflowBase proxyPSDynaWorkflowBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablemobDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynaworkflowidDirtyFlag = false;
    private boolean psdynaworkflownameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean srcpsdynadetemplidDirtyFlag = false;
    private boolean srcpsdynadetemplnameDirtyFlag = false;
    private boolean srcpsdynaworkflowidDirtyFlag = false;
    private boolean srcpsdynaworkflownameDirtyFlag = false;
    private boolean srctypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablemob")
    private Integer enablemob;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynaworkflowid")
    private String psdynaworkflowid;
    @Column(name="psdynaworkflowname")
    private String psdynaworkflowname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="srcpsdynadetemplid")
    private String srcpsdynadetemplid;
    @Column(name="srcpsdynadetemplname")
    private String srcpsdynadetemplname;
    @Column(name="srcpsdynaworkflowid")
    private String srcpsdynaworkflowid;
    @Column(name="srcpsdynaworkflowname")
    private String srcpsdynaworkflowname;
    @Column(name="srctype")
    private String srctype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
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

    public void setEnableMob(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMob(n);
            return;
        }
        this.enablemob = n;
        this.enablemobDirtyFlag = true;
    }

    public Integer getEnableMob() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMob();
        }
        return this.enablemob;
    }

    public boolean isEnableMobDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMobDirty();
        }
        return this.enablemobDirtyFlag;
    }

    public void resetEnableMob() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMob();
            return;
        }
        this.enablemobDirtyFlag = false;
        this.enablemob = null;
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

    public void setPSDynaWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaworkflowid = string;
        this.psdynaworkflowidDirtyFlag = true;
    }

    public String getPSDynaWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWorkflowId();
        }
        return this.psdynaworkflowid;
    }

    public boolean isPSDynaWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWorkflowIdDirty();
        }
        return this.psdynaworkflowidDirtyFlag;
    }

    public void resetPSDynaWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWorkflowId();
            return;
        }
        this.psdynaworkflowidDirtyFlag = false;
        this.psdynaworkflowid = null;
    }

    public void setPSDynaWorkflowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWorkflowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaworkflowname = string;
        this.psdynaworkflownameDirtyFlag = true;
    }

    public String getPSDynaWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWorkflowName();
        }
        return this.psdynaworkflowname;
    }

    public boolean isPSDynaWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWorkflowNameDirty();
        }
        return this.psdynaworkflownameDirtyFlag;
    }

    public void resetPSDynaWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWorkflowName();
            return;
        }
        this.psdynaworkflownameDirtyFlag = false;
        this.psdynaworkflowname = null;
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

    public void setSrcPSDynaDETemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDynaDETemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdynadetemplid = string;
        this.srcpsdynadetemplidDirtyFlag = true;
    }

    public String getSrcPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDynaDETemplId();
        }
        return this.srcpsdynadetemplid;
    }

    public boolean isSrcPSDynaDETemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDynaDETemplIdDirty();
        }
        return this.srcpsdynadetemplidDirtyFlag;
    }

    public void resetSrcPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDynaDETemplId();
            return;
        }
        this.srcpsdynadetemplidDirtyFlag = false;
        this.srcpsdynadetemplid = null;
    }

    public void setSrcPSDynaDETemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDynaDETemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdynadetemplname = string;
        this.srcpsdynadetemplnameDirtyFlag = true;
    }

    public String getSrcPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDynaDETemplName();
        }
        return this.srcpsdynadetemplname;
    }

    public boolean isSrcPSDynaDETemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDynaDETemplNameDirty();
        }
        return this.srcpsdynadetemplnameDirtyFlag;
    }

    public void resetSrcPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDynaDETemplName();
            return;
        }
        this.srcpsdynadetemplnameDirtyFlag = false;
        this.srcpsdynadetemplname = null;
    }

    public void setSrcPSDynaWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDynaWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdynaworkflowid = string;
        this.srcpsdynaworkflowidDirtyFlag = true;
    }

    public String getSrcPSDynaWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDynaWorkflowId();
        }
        return this.srcpsdynaworkflowid;
    }

    public boolean isSrcPSDynaWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDynaWorkflowIdDirty();
        }
        return this.srcpsdynaworkflowidDirtyFlag;
    }

    public void resetSrcPSDynaWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDynaWorkflowId();
            return;
        }
        this.srcpsdynaworkflowidDirtyFlag = false;
        this.srcpsdynaworkflowid = null;
    }

    public void setSrcPSDynaWorkflowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDynaWorkflowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdynaworkflowname = string;
        this.srcpsdynaworkflownameDirtyFlag = true;
    }

    public String getSrcPSDynaWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDynaWorkflowName();
        }
        return this.srcpsdynaworkflowname;
    }

    public boolean isSrcPSDynaWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDynaWorkflowNameDirty();
        }
        return this.srcpsdynaworkflownameDirtyFlag;
    }

    public void resetSrcPSDynaWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDynaWorkflowName();
            return;
        }
        this.srcpsdynaworkflownameDirtyFlag = false;
        this.srcpsdynaworkflowname = null;
    }

    public void setSrcType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srctype = string;
        this.srctypeDirtyFlag = true;
    }

    public String getSrcType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcType();
        }
        return this.srctype;
    }

    public boolean isSrcTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcTypeDirty();
        }
        return this.srctypeDirtyFlag;
    }

    public void resetSrcType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcType();
            return;
        }
        this.srctypeDirtyFlag = false;
        this.srctype = null;
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
        PSDynaWorkflowBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaWorkflowBase pSDynaWorkflowBase) {
        pSDynaWorkflowBase.resetCreateDate();
        pSDynaWorkflowBase.resetCreateMan();
        pSDynaWorkflowBase.resetDynaModelFlag();
        pSDynaWorkflowBase.resetEnableMob();
        pSDynaWorkflowBase.resetLockFlag();
        pSDynaWorkflowBase.resetMemo();
        pSDynaWorkflowBase.resetPSDEName();
        pSDynaWorkflowBase.resetPSDynaInstId();
        pSDynaWorkflowBase.resetPSDynaWorkflowId();
        pSDynaWorkflowBase.resetPSDynaWorkflowName();
        pSDynaWorkflowBase.resetPSSystemId();
        pSDynaWorkflowBase.resetPSSystemName();
        pSDynaWorkflowBase.resetSrcPSDynaDETemplId();
        pSDynaWorkflowBase.resetSrcPSDynaDETemplName();
        pSDynaWorkflowBase.resetSrcPSDynaWorkflowId();
        pSDynaWorkflowBase.resetSrcPSDynaWorkflowName();
        pSDynaWorkflowBase.resetSrcType();
        pSDynaWorkflowBase.resetUpdateDate();
        pSDynaWorkflowBase.resetUpdateMan();
        pSDynaWorkflowBase.resetValidFlag();
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
        if (!bl || this.isEnableMobDirty()) {
            hashMap.put(FIELD_ENABLEMOB, this.getEnableMob());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaWorkflowIdDirty()) {
            hashMap.put(FIELD_PSDYNAWORKFLOWID, this.getPSDynaWorkflowId());
        }
        if (!bl || this.isPSDynaWorkflowNameDirty()) {
            hashMap.put(FIELD_PSDYNAWORKFLOWNAME, this.getPSDynaWorkflowName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isSrcPSDynaDETemplIdDirty()) {
            hashMap.put(FIELD_SRCPSDYNADETEMPLID, this.getSrcPSDynaDETemplId());
        }
        if (!bl || this.isSrcPSDynaDETemplNameDirty()) {
            hashMap.put(FIELD_SRCPSDYNADETEMPLNAME, this.getSrcPSDynaDETemplName());
        }
        if (!bl || this.isSrcPSDynaWorkflowIdDirty()) {
            hashMap.put(FIELD_SRCPSDYNAWORKFLOWID, this.getSrcPSDynaWorkflowId());
        }
        if (!bl || this.isSrcPSDynaWorkflowNameDirty()) {
            hashMap.put(FIELD_SRCPSDYNAWORKFLOWNAME, this.getSrcPSDynaWorkflowName());
        }
        if (!bl || this.isSrcTypeDirty()) {
            hashMap.put(FIELD_SRCTYPE, this.getSrcType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDynaWorkflowBase.get(this, n);
    }

    private static Object get(PSDynaWorkflowBase pSDynaWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWorkflowBase.getCreateDate();
            }
            case 1: {
                return pSDynaWorkflowBase.getCreateMan();
            }
            case 2: {
                return pSDynaWorkflowBase.getDynaModelFlag();
            }
            case 3: {
                return pSDynaWorkflowBase.getEnableMob();
            }
            case 4: {
                return pSDynaWorkflowBase.getLockFlag();
            }
            case 5: {
                return pSDynaWorkflowBase.getMemo();
            }
            case 6: {
                return pSDynaWorkflowBase.getPSDEName();
            }
            case 7: {
                return pSDynaWorkflowBase.getPSDynaInstId();
            }
            case 8: {
                return pSDynaWorkflowBase.getPSDynaWorkflowId();
            }
            case 9: {
                return pSDynaWorkflowBase.getPSDynaWorkflowName();
            }
            case 10: {
                return pSDynaWorkflowBase.getPSSystemId();
            }
            case 11: {
                return pSDynaWorkflowBase.getPSSystemName();
            }
            case 12: {
                return pSDynaWorkflowBase.getSrcPSDynaDETemplId();
            }
            case 13: {
                return pSDynaWorkflowBase.getSrcPSDynaDETemplName();
            }
            case 14: {
                return pSDynaWorkflowBase.getSrcPSDynaWorkflowId();
            }
            case 15: {
                return pSDynaWorkflowBase.getSrcPSDynaWorkflowName();
            }
            case 16: {
                return pSDynaWorkflowBase.getSrcType();
            }
            case 17: {
                return pSDynaWorkflowBase.getUpdateDate();
            }
            case 18: {
                return pSDynaWorkflowBase.getUpdateMan();
            }
            case 19: {
                return pSDynaWorkflowBase.getValidFlag();
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
        PSDynaWorkflowBase.set(this, n, object);
    }

    private static void set(PSDynaWorkflowBase pSDynaWorkflowBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaWorkflowBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaWorkflowBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaWorkflowBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDynaWorkflowBase.setEnableMob(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDynaWorkflowBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDynaWorkflowBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaWorkflowBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaWorkflowBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaWorkflowBase.setPSDynaWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaWorkflowBase.setPSDynaWorkflowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaWorkflowBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaWorkflowBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDynaWorkflowBase.setSrcPSDynaDETemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDynaWorkflowBase.setSrcPSDynaDETemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDynaWorkflowBase.setSrcPSDynaWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDynaWorkflowBase.setSrcPSDynaWorkflowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDynaWorkflowBase.setSrcType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDynaWorkflowBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDynaWorkflowBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDynaWorkflowBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDynaWorkflowBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaWorkflowBase pSDynaWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWorkflowBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaWorkflowBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaWorkflowBase.getDynaModelFlag() == null;
            }
            case 3: {
                return pSDynaWorkflowBase.getEnableMob() == null;
            }
            case 4: {
                return pSDynaWorkflowBase.getLockFlag() == null;
            }
            case 5: {
                return pSDynaWorkflowBase.getMemo() == null;
            }
            case 6: {
                return pSDynaWorkflowBase.getPSDEName() == null;
            }
            case 7: {
                return pSDynaWorkflowBase.getPSDynaInstId() == null;
            }
            case 8: {
                return pSDynaWorkflowBase.getPSDynaWorkflowId() == null;
            }
            case 9: {
                return pSDynaWorkflowBase.getPSDynaWorkflowName() == null;
            }
            case 10: {
                return pSDynaWorkflowBase.getPSSystemId() == null;
            }
            case 11: {
                return pSDynaWorkflowBase.getPSSystemName() == null;
            }
            case 12: {
                return pSDynaWorkflowBase.getSrcPSDynaDETemplId() == null;
            }
            case 13: {
                return pSDynaWorkflowBase.getSrcPSDynaDETemplName() == null;
            }
            case 14: {
                return pSDynaWorkflowBase.getSrcPSDynaWorkflowId() == null;
            }
            case 15: {
                return pSDynaWorkflowBase.getSrcPSDynaWorkflowName() == null;
            }
            case 16: {
                return pSDynaWorkflowBase.getSrcType() == null;
            }
            case 17: {
                return pSDynaWorkflowBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDynaWorkflowBase.getUpdateMan() == null;
            }
            case 19: {
                return pSDynaWorkflowBase.getValidFlag() == null;
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
        return PSDynaWorkflowBase.contains(this, n);
    }

    private static boolean contains(PSDynaWorkflowBase pSDynaWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWorkflowBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaWorkflowBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaWorkflowBase.isDynaModelFlagDirty();
            }
            case 3: {
                return pSDynaWorkflowBase.isEnableMobDirty();
            }
            case 4: {
                return pSDynaWorkflowBase.isLockFlagDirty();
            }
            case 5: {
                return pSDynaWorkflowBase.isMemoDirty();
            }
            case 6: {
                return pSDynaWorkflowBase.isPSDENameDirty();
            }
            case 7: {
                return pSDynaWorkflowBase.isPSDynaInstIdDirty();
            }
            case 8: {
                return pSDynaWorkflowBase.isPSDynaWorkflowIdDirty();
            }
            case 9: {
                return pSDynaWorkflowBase.isPSDynaWorkflowNameDirty();
            }
            case 10: {
                return pSDynaWorkflowBase.isPSSystemIdDirty();
            }
            case 11: {
                return pSDynaWorkflowBase.isPSSystemNameDirty();
            }
            case 12: {
                return pSDynaWorkflowBase.isSrcPSDynaDETemplIdDirty();
            }
            case 13: {
                return pSDynaWorkflowBase.isSrcPSDynaDETemplNameDirty();
            }
            case 14: {
                return pSDynaWorkflowBase.isSrcPSDynaWorkflowIdDirty();
            }
            case 15: {
                return pSDynaWorkflowBase.isSrcPSDynaWorkflowNameDirty();
            }
            case 16: {
                return pSDynaWorkflowBase.isSrcTypeDirty();
            }
            case 17: {
                return pSDynaWorkflowBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDynaWorkflowBase.isUpdateManDirty();
            }
            case 19: {
                return pSDynaWorkflowBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaWorkflowBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaWorkflowBase pSDynaWorkflowBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaWorkflowBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getEnableMob() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemob", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getEnableMob()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getPSDynaWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaworkflowid", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getPSDynaWorkflowId()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getPSDynaWorkflowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaworkflowname", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getPSDynaWorkflowName()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getSrcPSDynaDETemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdynadetemplid", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getSrcPSDynaDETemplId()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getSrcPSDynaDETemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdynadetemplname", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getSrcPSDynaDETemplName()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getSrcPSDynaWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdynaworkflowid", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getSrcPSDynaWorkflowId()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getSrcPSDynaWorkflowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdynaworkflowname", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getSrcPSDynaWorkflowName()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getSrcType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srctype", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getSrcType()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaWorkflowBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDynaWorkflowBase.getJSONValue((Object)pSDynaWorkflowBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaWorkflowBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaWorkflowBase pSDynaWorkflowBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaWorkflowBase.getCreateDate() != null) {
            object = pSDynaWorkflowBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaWorkflowBase.getCreateMan() != null) {
            object = pSDynaWorkflowBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getDynaModelFlag() != null) {
            object = pSDynaWorkflowBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaWorkflowBase.getEnableMob() != null) {
            object = pSDynaWorkflowBase.getEnableMob();
            xmlNode.setAttribute(FIELD_ENABLEMOB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaWorkflowBase.getLockFlag() != null) {
            object = pSDynaWorkflowBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaWorkflowBase.getMemo() != null) {
            object = pSDynaWorkflowBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getPSDEName() != null) {
            object = pSDynaWorkflowBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getPSDynaInstId() != null) {
            object = pSDynaWorkflowBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getPSDynaWorkflowId() != null) {
            object = pSDynaWorkflowBase.getPSDynaWorkflowId();
            xmlNode.setAttribute(FIELD_PSDYNAWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getPSDynaWorkflowName() != null) {
            object = pSDynaWorkflowBase.getPSDynaWorkflowName();
            xmlNode.setAttribute(FIELD_PSDYNAWORKFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getPSSystemId() != null) {
            object = pSDynaWorkflowBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getPSSystemName() != null) {
            object = pSDynaWorkflowBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getSrcPSDynaDETemplId() != null) {
            object = pSDynaWorkflowBase.getSrcPSDynaDETemplId();
            xmlNode.setAttribute(FIELD_SRCPSDYNADETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getSrcPSDynaDETemplName() != null) {
            object = pSDynaWorkflowBase.getSrcPSDynaDETemplName();
            xmlNode.setAttribute(FIELD_SRCPSDYNADETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getSrcPSDynaWorkflowId() != null) {
            object = pSDynaWorkflowBase.getSrcPSDynaWorkflowId();
            xmlNode.setAttribute(FIELD_SRCPSDYNAWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getSrcPSDynaWorkflowName() != null) {
            object = pSDynaWorkflowBase.getSrcPSDynaWorkflowName();
            xmlNode.setAttribute(FIELD_SRCPSDYNAWORKFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getSrcType() != null) {
            object = pSDynaWorkflowBase.getSrcType();
            xmlNode.setAttribute(FIELD_SRCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getUpdateDate() != null) {
            object = pSDynaWorkflowBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaWorkflowBase.getUpdateMan() != null) {
            object = pSDynaWorkflowBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWorkflowBase.getValidFlag() != null) {
            object = pSDynaWorkflowBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaWorkflowBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaWorkflowBase pSDynaWorkflowBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaWorkflowBase.isCreateDateDirty() && (bl || pSDynaWorkflowBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaWorkflowBase.getCreateDate());
        }
        if (pSDynaWorkflowBase.isCreateManDirty() && (bl || pSDynaWorkflowBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaWorkflowBase.getCreateMan());
        }
        if (pSDynaWorkflowBase.isDynaModelFlagDirty() && (bl || pSDynaWorkflowBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDynaWorkflowBase.getDynaModelFlag());
        }
        if (pSDynaWorkflowBase.isEnableMobDirty() && (bl || pSDynaWorkflowBase.getEnableMob() != null)) {
            iDataObject.set(FIELD_ENABLEMOB, (Object)pSDynaWorkflowBase.getEnableMob());
        }
        if (pSDynaWorkflowBase.isLockFlagDirty() && (bl || pSDynaWorkflowBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDynaWorkflowBase.getLockFlag());
        }
        if (pSDynaWorkflowBase.isMemoDirty() && (bl || pSDynaWorkflowBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaWorkflowBase.getMemo());
        }
        if (pSDynaWorkflowBase.isPSDENameDirty() && (bl || pSDynaWorkflowBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDynaWorkflowBase.getPSDEName());
        }
        if (pSDynaWorkflowBase.isPSDynaInstIdDirty() && (bl || pSDynaWorkflowBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDynaWorkflowBase.getPSDynaInstId());
        }
        if (pSDynaWorkflowBase.isPSDynaWorkflowIdDirty() && (bl || pSDynaWorkflowBase.getPSDynaWorkflowId() != null)) {
            iDataObject.set(FIELD_PSDYNAWORKFLOWID, (Object)pSDynaWorkflowBase.getPSDynaWorkflowId());
        }
        if (pSDynaWorkflowBase.isPSDynaWorkflowNameDirty() && (bl || pSDynaWorkflowBase.getPSDynaWorkflowName() != null)) {
            iDataObject.set(FIELD_PSDYNAWORKFLOWNAME, (Object)pSDynaWorkflowBase.getPSDynaWorkflowName());
        }
        if (pSDynaWorkflowBase.isPSSystemIdDirty() && (bl || pSDynaWorkflowBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDynaWorkflowBase.getPSSystemId());
        }
        if (pSDynaWorkflowBase.isPSSystemNameDirty() && (bl || pSDynaWorkflowBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDynaWorkflowBase.getPSSystemName());
        }
        if (pSDynaWorkflowBase.isSrcPSDynaDETemplIdDirty() && (bl || pSDynaWorkflowBase.getSrcPSDynaDETemplId() != null)) {
            iDataObject.set(FIELD_SRCPSDYNADETEMPLID, (Object)pSDynaWorkflowBase.getSrcPSDynaDETemplId());
        }
        if (pSDynaWorkflowBase.isSrcPSDynaDETemplNameDirty() && (bl || pSDynaWorkflowBase.getSrcPSDynaDETemplName() != null)) {
            iDataObject.set(FIELD_SRCPSDYNADETEMPLNAME, (Object)pSDynaWorkflowBase.getSrcPSDynaDETemplName());
        }
        if (pSDynaWorkflowBase.isSrcPSDynaWorkflowIdDirty() && (bl || pSDynaWorkflowBase.getSrcPSDynaWorkflowId() != null)) {
            iDataObject.set(FIELD_SRCPSDYNAWORKFLOWID, (Object)pSDynaWorkflowBase.getSrcPSDynaWorkflowId());
        }
        if (pSDynaWorkflowBase.isSrcPSDynaWorkflowNameDirty() && (bl || pSDynaWorkflowBase.getSrcPSDynaWorkflowName() != null)) {
            iDataObject.set(FIELD_SRCPSDYNAWORKFLOWNAME, (Object)pSDynaWorkflowBase.getSrcPSDynaWorkflowName());
        }
        if (pSDynaWorkflowBase.isSrcTypeDirty() && (bl || pSDynaWorkflowBase.getSrcType() != null)) {
            iDataObject.set(FIELD_SRCTYPE, (Object)pSDynaWorkflowBase.getSrcType());
        }
        if (pSDynaWorkflowBase.isUpdateDateDirty() && (bl || pSDynaWorkflowBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaWorkflowBase.getUpdateDate());
        }
        if (pSDynaWorkflowBase.isUpdateManDirty() && (bl || pSDynaWorkflowBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaWorkflowBase.getUpdateMan());
        }
        if (pSDynaWorkflowBase.isValidFlagDirty() && (bl || pSDynaWorkflowBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDynaWorkflowBase.getValidFlag());
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
        return PSDynaWorkflowBase.remove(this, n);
    }

    private static boolean remove(PSDynaWorkflowBase pSDynaWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaWorkflowBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaWorkflowBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaWorkflowBase.resetDynaModelFlag();
                return true;
            }
            case 3: {
                pSDynaWorkflowBase.resetEnableMob();
                return true;
            }
            case 4: {
                pSDynaWorkflowBase.resetLockFlag();
                return true;
            }
            case 5: {
                pSDynaWorkflowBase.resetMemo();
                return true;
            }
            case 6: {
                pSDynaWorkflowBase.resetPSDEName();
                return true;
            }
            case 7: {
                pSDynaWorkflowBase.resetPSDynaInstId();
                return true;
            }
            case 8: {
                pSDynaWorkflowBase.resetPSDynaWorkflowId();
                return true;
            }
            case 9: {
                pSDynaWorkflowBase.resetPSDynaWorkflowName();
                return true;
            }
            case 10: {
                pSDynaWorkflowBase.resetPSSystemId();
                return true;
            }
            case 11: {
                pSDynaWorkflowBase.resetPSSystemName();
                return true;
            }
            case 12: {
                pSDynaWorkflowBase.resetSrcPSDynaDETemplId();
                return true;
            }
            case 13: {
                pSDynaWorkflowBase.resetSrcPSDynaDETemplName();
                return true;
            }
            case 14: {
                pSDynaWorkflowBase.resetSrcPSDynaWorkflowId();
                return true;
            }
            case 15: {
                pSDynaWorkflowBase.resetSrcPSDynaWorkflowName();
                return true;
            }
            case 16: {
                pSDynaWorkflowBase.resetSrcType();
                return true;
            }
            case 17: {
                pSDynaWorkflowBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDynaWorkflowBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSDynaWorkflowBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSDynaWorkflowBase getProxyEntity() {
        return this.proxyPSDynaWorkflowBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaWorkflowBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaWorkflowBase) {
            this.proxyPSDynaWorkflowBase = (PSDynaWorkflowBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaWorkflowService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 2);
        fieldIndexMap.put(FIELD_ENABLEMOB, 3);
        fieldIndexMap.put(FIELD_LOCKFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDENAME, 6);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 7);
        fieldIndexMap.put(FIELD_PSDYNAWORKFLOWID, 8);
        fieldIndexMap.put(FIELD_PSDYNAWORKFLOWNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 11);
        fieldIndexMap.put(FIELD_SRCPSDYNADETEMPLID, 12);
        fieldIndexMap.put(FIELD_SRCPSDYNADETEMPLNAME, 13);
        fieldIndexMap.put(FIELD_SRCPSDYNAWORKFLOWID, 14);
        fieldIndexMap.put(FIELD_SRCPSDYNAWORKFLOWNAME, 15);
        fieldIndexMap.put(FIELD_SRCTYPE, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

