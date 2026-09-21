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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnCodeServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnCodeServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSPARAM = "CSPARAM";
    public static final String FIELD_CSPARAM2 = "CSPARAM2";
    public static final String FIELD_CSPARAM3 = "CSPARAM3";
    public static final String FIELD_CSPARAM4 = "CSPARAM4";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_HOSTPASSWD = "HOSTPASSWD";
    public static final String FIELD_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String FIELD_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String FIELD_PSDEVSLNCODESERVERID = "PSDEVSLNCODESERVERID";
    public static final String FIELD_PSDEVSLNCODESERVERNAME = "PSDEVSLNCODESERVERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CSPARAM = 2;
    private static final int INDEX_CSPARAM2 = 3;
    private static final int INDEX_CSPARAM3 = 4;
    private static final int INDEX_CSPARAM4 = 5;
    private static final int INDEX_EXPRIEDTIME = 6;
    private static final int INDEX_HOSTPASSWD = 7;
    private static final int INDEX_HOSTUSERNAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSDEVCENTERSERVERID = 10;
    private static final int INDEX_PSDEVCENTERSERVERNAME = 11;
    private static final int INDEX_PSDEVSLNCODESERVERID = 12;
    private static final int INDEX_PSDEVSLNCODESERVERNAME = 13;
    private static final int INDEX_PSDEVSLNID = 14;
    private static final int INDEX_PSDEVSLNNAME = 15;
    private static final int INDEX_RESREADYTIME = 16;
    private static final int INDEX_RESSTATE = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnCodeServerBase proxyPSDevSlnCodeServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean csparamDirtyFlag = false;
    private boolean csparam2DirtyFlag = false;
    private boolean csparam3DirtyFlag = false;
    private boolean csparam4DirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean hostpasswdDirtyFlag = false;
    private boolean hostusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenterserveridDirtyFlag = false;
    private boolean psdevcenterservernameDirtyFlag = false;
    private boolean psdevslncodeserveridDirtyFlag = false;
    private boolean psdevslncodeservernameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="csparam")
    private String csparam;
    @Column(name="csparam2")
    private String csparam2;
    @Column(name="csparam3")
    private Integer csparam3;
    @Column(name="csparam4")
    private Integer csparam4;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="hostpasswd")
    private String hostpasswd;
    @Column(name="hostusername")
    private String hostusername;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterserverid")
    private String psdevcenterserverid;
    @Column(name="psdevcenterservername")
    private String psdevcenterservername;
    @Column(name="psdevslncodeserverid")
    private String psdevslncodeserverid;
    @Column(name="psdevslncodeservername")
    private String psdevslncodeservername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterServerLock = new Integer(1);
    private PSDevCenterServer psdevcenterserver = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

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

    public void setCSParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.csparam = string;
        this.csparamDirtyFlag = true;
    }

    public String getCSParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParam();
        }
        return this.csparam;
    }

    public boolean isCSParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParamDirty();
        }
        return this.csparamDirtyFlag;
    }

    public void resetCSParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParam();
            return;
        }
        this.csparamDirtyFlag = false;
        this.csparam = null;
    }

    public void setCSParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.csparam2 = string;
        this.csparam2DirtyFlag = true;
    }

    public String getCSParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParam2();
        }
        return this.csparam2;
    }

    public boolean isCSParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParam2Dirty();
        }
        return this.csparam2DirtyFlag;
    }

    public void resetCSParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParam2();
            return;
        }
        this.csparam2DirtyFlag = false;
        this.csparam2 = null;
    }

    public void setCSParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParam3(n);
            return;
        }
        this.csparam3 = n;
        this.csparam3DirtyFlag = true;
    }

    public Integer getCSParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParam3();
        }
        return this.csparam3;
    }

    public boolean isCSParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParam3Dirty();
        }
        return this.csparam3DirtyFlag;
    }

    public void resetCSParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParam3();
            return;
        }
        this.csparam3DirtyFlag = false;
        this.csparam3 = null;
    }

    public void setCSParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParam4(n);
            return;
        }
        this.csparam4 = n;
        this.csparam4DirtyFlag = true;
    }

    public Integer getCSParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParam4();
        }
        return this.csparam4;
    }

    public boolean isCSParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParam4Dirty();
        }
        return this.csparam4DirtyFlag;
    }

    public void resetCSParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParam4();
            return;
        }
        this.csparam4DirtyFlag = false;
        this.csparam4 = null;
    }

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setHostPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostpasswd = string;
        this.hostpasswdDirtyFlag = true;
    }

    public String getHostPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostPasswd();
        }
        return this.hostpasswd;
    }

    public boolean isHostPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostPasswdDirty();
        }
        return this.hostpasswdDirtyFlag;
    }

    public void resetHostPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostPasswd();
            return;
        }
        this.hostpasswdDirtyFlag = false;
        this.hostpasswd = null;
    }

    public void setHostUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostusername = string;
        this.hostusernameDirtyFlag = true;
    }

    public String getHostUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostUserName();
        }
        return this.hostusername;
    }

    public boolean isHostUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostUserNameDirty();
        }
        return this.hostusernameDirtyFlag;
    }

    public void resetHostUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostUserName();
            return;
        }
        this.hostusernameDirtyFlag = false;
        this.hostusername = null;
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

    public void setPSDevCenterServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterserverid = string;
        this.psdevcenterserveridDirtyFlag = true;
    }

    public String getPSDevCenterServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServerId();
        }
        return this.psdevcenterserverid;
    }

    public boolean isPSDevCenterServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterServerIdDirty();
        }
        return this.psdevcenterserveridDirtyFlag;
    }

    public void resetPSDevCenterServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterServerId();
            return;
        }
        this.psdevcenterserveridDirtyFlag = false;
        this.psdevcenterserverid = null;
    }

    public void setPSDevCenterServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterservername = string;
        this.psdevcenterservernameDirtyFlag = true;
    }

    public String getPSDevCenterServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServerName();
        }
        return this.psdevcenterservername;
    }

    public boolean isPSDevCenterServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterServerNameDirty();
        }
        return this.psdevcenterservernameDirtyFlag;
    }

    public void resetPSDevCenterServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterServerName();
            return;
        }
        this.psdevcenterservernameDirtyFlag = false;
        this.psdevcenterservername = null;
    }

    public void setPSDevSlnCodeServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnCodeServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslncodeserverid = string;
        this.psdevslncodeserveridDirtyFlag = true;
    }

    public String getPSDevSlnCodeServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCodeServerId();
        }
        return this.psdevslncodeserverid;
    }

    public boolean isPSDevSlnCodeServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnCodeServerIdDirty();
        }
        return this.psdevslncodeserveridDirtyFlag;
    }

    public void resetPSDevSlnCodeServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnCodeServerId();
            return;
        }
        this.psdevslncodeserveridDirtyFlag = false;
        this.psdevslncodeserverid = null;
    }

    public void setPSDevSlnCodeServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnCodeServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslncodeservername = string;
        this.psdevslncodeservernameDirtyFlag = true;
    }

    public String getPSDevSlnCodeServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCodeServerName();
        }
        return this.psdevslncodeservername;
    }

    public boolean isPSDevSlnCodeServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnCodeServerNameDirty();
        }
        return this.psdevslncodeservernameDirtyFlag;
    }

    public void resetPSDevSlnCodeServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnCodeServerName();
            return;
        }
        this.psdevslncodeservernameDirtyFlag = false;
        this.psdevslncodeservername = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
    }

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
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
        PSDevSlnCodeServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnCodeServerBase pSDevSlnCodeServerBase) {
        pSDevSlnCodeServerBase.resetCreateDate();
        pSDevSlnCodeServerBase.resetCreateMan();
        pSDevSlnCodeServerBase.resetCSParam();
        pSDevSlnCodeServerBase.resetCSParam2();
        pSDevSlnCodeServerBase.resetCSParam3();
        pSDevSlnCodeServerBase.resetCSParam4();
        pSDevSlnCodeServerBase.resetExpriedTime();
        pSDevSlnCodeServerBase.resetHostPasswd();
        pSDevSlnCodeServerBase.resetHostUserName();
        pSDevSlnCodeServerBase.resetMemo();
        pSDevSlnCodeServerBase.resetPSDevCenterServerId();
        pSDevSlnCodeServerBase.resetPSDevCenterServerName();
        pSDevSlnCodeServerBase.resetPSDevSlnCodeServerId();
        pSDevSlnCodeServerBase.resetPSDevSlnCodeServerName();
        pSDevSlnCodeServerBase.resetPSDevSlnId();
        pSDevSlnCodeServerBase.resetPSDevSlnName();
        pSDevSlnCodeServerBase.resetResReadyTime();
        pSDevSlnCodeServerBase.resetResState();
        pSDevSlnCodeServerBase.resetUpdateDate();
        pSDevSlnCodeServerBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCSParamDirty()) {
            hashMap.put(FIELD_CSPARAM, this.getCSParam());
        }
        if (!bl || this.isCSParam2Dirty()) {
            hashMap.put(FIELD_CSPARAM2, this.getCSParam2());
        }
        if (!bl || this.isCSParam3Dirty()) {
            hashMap.put(FIELD_CSPARAM3, this.getCSParam3());
        }
        if (!bl || this.isCSParam4Dirty()) {
            hashMap.put(FIELD_CSPARAM4, this.getCSParam4());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isHostPasswdDirty()) {
            hashMap.put(FIELD_HOSTPASSWD, this.getHostPasswd());
        }
        if (!bl || this.isHostUserNameDirty()) {
            hashMap.put(FIELD_HOSTUSERNAME, this.getHostUserName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterServerIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSERVERID, this.getPSDevCenterServerId());
        }
        if (!bl || this.isPSDevCenterServerNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSERVERNAME, this.getPSDevCenterServerName());
        }
        if (!bl || this.isPSDevSlnCodeServerIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNCODESERVERID, this.getPSDevSlnCodeServerId());
        }
        if (!bl || this.isPSDevSlnCodeServerNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNCODESERVERNAME, this.getPSDevSlnCodeServerName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
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
        return PSDevSlnCodeServerBase.get(this, n);
    }

    private static Object get(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCodeServerBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnCodeServerBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnCodeServerBase.getCSParam();
            }
            case 3: {
                return pSDevSlnCodeServerBase.getCSParam2();
            }
            case 4: {
                return pSDevSlnCodeServerBase.getCSParam3();
            }
            case 5: {
                return pSDevSlnCodeServerBase.getCSParam4();
            }
            case 6: {
                return pSDevSlnCodeServerBase.getExpriedTime();
            }
            case 7: {
                return pSDevSlnCodeServerBase.getHostPasswd();
            }
            case 8: {
                return pSDevSlnCodeServerBase.getHostUserName();
            }
            case 9: {
                return pSDevSlnCodeServerBase.getMemo();
            }
            case 10: {
                return pSDevSlnCodeServerBase.getPSDevCenterServerId();
            }
            case 11: {
                return pSDevSlnCodeServerBase.getPSDevCenterServerName();
            }
            case 12: {
                return pSDevSlnCodeServerBase.getPSDevSlnCodeServerId();
            }
            case 13: {
                return pSDevSlnCodeServerBase.getPSDevSlnCodeServerName();
            }
            case 14: {
                return pSDevSlnCodeServerBase.getPSDevSlnId();
            }
            case 15: {
                return pSDevSlnCodeServerBase.getPSDevSlnName();
            }
            case 16: {
                return pSDevSlnCodeServerBase.getResReadyTime();
            }
            case 17: {
                return pSDevSlnCodeServerBase.getResState();
            }
            case 18: {
                return pSDevSlnCodeServerBase.getUpdateDate();
            }
            case 19: {
                return pSDevSlnCodeServerBase.getUpdateMan();
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
        PSDevSlnCodeServerBase.set(this, n, object);
    }

    private static void set(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnCodeServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnCodeServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnCodeServerBase.setCSParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnCodeServerBase.setCSParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnCodeServerBase.setCSParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnCodeServerBase.setCSParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnCodeServerBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnCodeServerBase.setHostPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnCodeServerBase.setHostUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnCodeServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnCodeServerBase.setPSDevCenterServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnCodeServerBase.setPSDevCenterServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnCodeServerBase.setPSDevSlnCodeServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnCodeServerBase.setPSDevSlnCodeServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnCodeServerBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnCodeServerBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnCodeServerBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnCodeServerBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnCodeServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnCodeServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnCodeServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCodeServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnCodeServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnCodeServerBase.getCSParam() == null;
            }
            case 3: {
                return pSDevSlnCodeServerBase.getCSParam2() == null;
            }
            case 4: {
                return pSDevSlnCodeServerBase.getCSParam3() == null;
            }
            case 5: {
                return pSDevSlnCodeServerBase.getCSParam4() == null;
            }
            case 6: {
                return pSDevSlnCodeServerBase.getExpriedTime() == null;
            }
            case 7: {
                return pSDevSlnCodeServerBase.getHostPasswd() == null;
            }
            case 8: {
                return pSDevSlnCodeServerBase.getHostUserName() == null;
            }
            case 9: {
                return pSDevSlnCodeServerBase.getMemo() == null;
            }
            case 10: {
                return pSDevSlnCodeServerBase.getPSDevCenterServerId() == null;
            }
            case 11: {
                return pSDevSlnCodeServerBase.getPSDevCenterServerName() == null;
            }
            case 12: {
                return pSDevSlnCodeServerBase.getPSDevSlnCodeServerId() == null;
            }
            case 13: {
                return pSDevSlnCodeServerBase.getPSDevSlnCodeServerName() == null;
            }
            case 14: {
                return pSDevSlnCodeServerBase.getPSDevSlnId() == null;
            }
            case 15: {
                return pSDevSlnCodeServerBase.getPSDevSlnName() == null;
            }
            case 16: {
                return pSDevSlnCodeServerBase.getResReadyTime() == null;
            }
            case 17: {
                return pSDevSlnCodeServerBase.getResState() == null;
            }
            case 18: {
                return pSDevSlnCodeServerBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDevSlnCodeServerBase.getUpdateMan() == null;
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
        return PSDevSlnCodeServerBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCodeServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnCodeServerBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnCodeServerBase.isCSParamDirty();
            }
            case 3: {
                return pSDevSlnCodeServerBase.isCSParam2Dirty();
            }
            case 4: {
                return pSDevSlnCodeServerBase.isCSParam3Dirty();
            }
            case 5: {
                return pSDevSlnCodeServerBase.isCSParam4Dirty();
            }
            case 6: {
                return pSDevSlnCodeServerBase.isExpriedTimeDirty();
            }
            case 7: {
                return pSDevSlnCodeServerBase.isHostPasswdDirty();
            }
            case 8: {
                return pSDevSlnCodeServerBase.isHostUserNameDirty();
            }
            case 9: {
                return pSDevSlnCodeServerBase.isMemoDirty();
            }
            case 10: {
                return pSDevSlnCodeServerBase.isPSDevCenterServerIdDirty();
            }
            case 11: {
                return pSDevSlnCodeServerBase.isPSDevCenterServerNameDirty();
            }
            case 12: {
                return pSDevSlnCodeServerBase.isPSDevSlnCodeServerIdDirty();
            }
            case 13: {
                return pSDevSlnCodeServerBase.isPSDevSlnCodeServerNameDirty();
            }
            case 14: {
                return pSDevSlnCodeServerBase.isPSDevSlnIdDirty();
            }
            case 15: {
                return pSDevSlnCodeServerBase.isPSDevSlnNameDirty();
            }
            case 16: {
                return pSDevSlnCodeServerBase.isResReadyTimeDirty();
            }
            case 17: {
                return pSDevSlnCodeServerBase.isResStateDirty();
            }
            case 18: {
                return pSDevSlnCodeServerBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDevSlnCodeServerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnCodeServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnCodeServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getCSParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getCSParam()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getCSParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam2", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getCSParam2()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getCSParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam3", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getCSParam3()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getCSParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam4", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getCSParam4()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getHostPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostpasswd", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getHostPasswd()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getHostUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostusername", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getHostUserName()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevCenterServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterserverid", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getPSDevCenterServerId()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevCenterServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterservername", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getPSDevCenterServerName()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevSlnCodeServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslncodeserverid", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getPSDevSlnCodeServerId()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevSlnCodeServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslncodeservername", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getPSDevSlnCodeServerName()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getResState()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnCodeServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnCodeServerBase.getJSONValue((Object)pSDevSlnCodeServerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnCodeServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnCodeServerBase.getCreateDate() != null) {
            object = pSDevSlnCodeServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCodeServerBase.getCreateMan() != null) {
            object = pSDevSlnCodeServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getCSParam() != null) {
            object = pSDevSlnCodeServerBase.getCSParam();
            xmlNode.setAttribute(FIELD_CSPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getCSParam2() != null) {
            object = pSDevSlnCodeServerBase.getCSParam2();
            xmlNode.setAttribute(FIELD_CSPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getCSParam3() != null) {
            object = pSDevSlnCodeServerBase.getCSParam3();
            xmlNode.setAttribute(FIELD_CSPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnCodeServerBase.getCSParam4() != null) {
            object = pSDevSlnCodeServerBase.getCSParam4();
            xmlNode.setAttribute(FIELD_CSPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnCodeServerBase.getExpriedTime() != null) {
            object = pSDevSlnCodeServerBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCodeServerBase.getHostPasswd() != null) {
            object = pSDevSlnCodeServerBase.getHostPasswd();
            xmlNode.setAttribute(FIELD_HOSTPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getHostUserName() != null) {
            object = pSDevSlnCodeServerBase.getHostUserName();
            xmlNode.setAttribute(FIELD_HOSTUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getMemo() != null) {
            object = pSDevSlnCodeServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevCenterServerId() != null) {
            object = pSDevSlnCodeServerBase.getPSDevCenterServerId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevCenterServerName() != null) {
            object = pSDevSlnCodeServerBase.getPSDevCenterServerName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevSlnCodeServerId() != null) {
            object = pSDevSlnCodeServerBase.getPSDevSlnCodeServerId();
            xmlNode.setAttribute(FIELD_PSDEVSLNCODESERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevSlnCodeServerName() != null) {
            object = pSDevSlnCodeServerBase.getPSDevSlnCodeServerName();
            xmlNode.setAttribute(FIELD_PSDEVSLNCODESERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevSlnId() != null) {
            object = pSDevSlnCodeServerBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getPSDevSlnName() != null) {
            object = pSDevSlnCodeServerBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCodeServerBase.getResReadyTime() != null) {
            object = pSDevSlnCodeServerBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCodeServerBase.getResState() != null) {
            object = pSDevSlnCodeServerBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnCodeServerBase.getUpdateDate() != null) {
            object = pSDevSlnCodeServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCodeServerBase.getUpdateMan() != null) {
            object = pSDevSlnCodeServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnCodeServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnCodeServerBase.isCreateDateDirty() && (bl || pSDevSlnCodeServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnCodeServerBase.getCreateDate());
        }
        if (pSDevSlnCodeServerBase.isCreateManDirty() && (bl || pSDevSlnCodeServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnCodeServerBase.getCreateMan());
        }
        if (pSDevSlnCodeServerBase.isCSParamDirty() && (bl || pSDevSlnCodeServerBase.getCSParam() != null)) {
            iDataObject.set(FIELD_CSPARAM, (Object)pSDevSlnCodeServerBase.getCSParam());
        }
        if (pSDevSlnCodeServerBase.isCSParam2Dirty() && (bl || pSDevSlnCodeServerBase.getCSParam2() != null)) {
            iDataObject.set(FIELD_CSPARAM2, (Object)pSDevSlnCodeServerBase.getCSParam2());
        }
        if (pSDevSlnCodeServerBase.isCSParam3Dirty() && (bl || pSDevSlnCodeServerBase.getCSParam3() != null)) {
            iDataObject.set(FIELD_CSPARAM3, (Object)pSDevSlnCodeServerBase.getCSParam3());
        }
        if (pSDevSlnCodeServerBase.isCSParam4Dirty() && (bl || pSDevSlnCodeServerBase.getCSParam4() != null)) {
            iDataObject.set(FIELD_CSPARAM4, (Object)pSDevSlnCodeServerBase.getCSParam4());
        }
        if (pSDevSlnCodeServerBase.isExpriedTimeDirty() && (bl || pSDevSlnCodeServerBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevSlnCodeServerBase.getExpriedTime());
        }
        if (pSDevSlnCodeServerBase.isHostPasswdDirty() && (bl || pSDevSlnCodeServerBase.getHostPasswd() != null)) {
            iDataObject.set(FIELD_HOSTPASSWD, (Object)pSDevSlnCodeServerBase.getHostPasswd());
        }
        if (pSDevSlnCodeServerBase.isHostUserNameDirty() && (bl || pSDevSlnCodeServerBase.getHostUserName() != null)) {
            iDataObject.set(FIELD_HOSTUSERNAME, (Object)pSDevSlnCodeServerBase.getHostUserName());
        }
        if (pSDevSlnCodeServerBase.isMemoDirty() && (bl || pSDevSlnCodeServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnCodeServerBase.getMemo());
        }
        if (pSDevSlnCodeServerBase.isPSDevCenterServerIdDirty() && (bl || pSDevSlnCodeServerBase.getPSDevCenterServerId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERID, (Object)pSDevSlnCodeServerBase.getPSDevCenterServerId());
        }
        if (pSDevSlnCodeServerBase.isPSDevCenterServerNameDirty() && (bl || pSDevSlnCodeServerBase.getPSDevCenterServerName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERNAME, (Object)pSDevSlnCodeServerBase.getPSDevCenterServerName());
        }
        if (pSDevSlnCodeServerBase.isPSDevSlnCodeServerIdDirty() && (bl || pSDevSlnCodeServerBase.getPSDevSlnCodeServerId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNCODESERVERID, (Object)pSDevSlnCodeServerBase.getPSDevSlnCodeServerId());
        }
        if (pSDevSlnCodeServerBase.isPSDevSlnCodeServerNameDirty() && (bl || pSDevSlnCodeServerBase.getPSDevSlnCodeServerName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNCODESERVERNAME, (Object)pSDevSlnCodeServerBase.getPSDevSlnCodeServerName());
        }
        if (pSDevSlnCodeServerBase.isPSDevSlnIdDirty() && (bl || pSDevSlnCodeServerBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnCodeServerBase.getPSDevSlnId());
        }
        if (pSDevSlnCodeServerBase.isPSDevSlnNameDirty() && (bl || pSDevSlnCodeServerBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnCodeServerBase.getPSDevSlnName());
        }
        if (pSDevSlnCodeServerBase.isResReadyTimeDirty() && (bl || pSDevSlnCodeServerBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDevSlnCodeServerBase.getResReadyTime());
        }
        if (pSDevSlnCodeServerBase.isResStateDirty() && (bl || pSDevSlnCodeServerBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDevSlnCodeServerBase.getResState());
        }
        if (pSDevSlnCodeServerBase.isUpdateDateDirty() && (bl || pSDevSlnCodeServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnCodeServerBase.getUpdateDate());
        }
        if (pSDevSlnCodeServerBase.isUpdateManDirty() && (bl || pSDevSlnCodeServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnCodeServerBase.getUpdateMan());
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
        return PSDevSlnCodeServerBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnCodeServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnCodeServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnCodeServerBase.resetCSParam();
                return true;
            }
            case 3: {
                pSDevSlnCodeServerBase.resetCSParam2();
                return true;
            }
            case 4: {
                pSDevSlnCodeServerBase.resetCSParam3();
                return true;
            }
            case 5: {
                pSDevSlnCodeServerBase.resetCSParam4();
                return true;
            }
            case 6: {
                pSDevSlnCodeServerBase.resetExpriedTime();
                return true;
            }
            case 7: {
                pSDevSlnCodeServerBase.resetHostPasswd();
                return true;
            }
            case 8: {
                pSDevSlnCodeServerBase.resetHostUserName();
                return true;
            }
            case 9: {
                pSDevSlnCodeServerBase.resetMemo();
                return true;
            }
            case 10: {
                pSDevSlnCodeServerBase.resetPSDevCenterServerId();
                return true;
            }
            case 11: {
                pSDevSlnCodeServerBase.resetPSDevCenterServerName();
                return true;
            }
            case 12: {
                pSDevSlnCodeServerBase.resetPSDevSlnCodeServerId();
                return true;
            }
            case 13: {
                pSDevSlnCodeServerBase.resetPSDevSlnCodeServerName();
                return true;
            }
            case 14: {
                pSDevSlnCodeServerBase.resetPSDevSlnId();
                return true;
            }
            case 15: {
                pSDevSlnCodeServerBase.resetPSDevSlnName();
                return true;
            }
            case 16: {
                pSDevSlnCodeServerBase.resetResReadyTime();
                return true;
            }
            case 17: {
                pSDevSlnCodeServerBase.resetResState();
                return true;
            }
            case 18: {
                pSDevSlnCodeServerBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDevSlnCodeServerBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterServer getPSDevCenterServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServer();
        }
        if (this.getPSDevCenterServerId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterServerLock;
        synchronized (n) {
            if (this.psdevcenterserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterServerId(), (Object)this.psdevcenterserver.getPSDevCenterServerId()) != 0L) {
                this.psdevcenterserver = null;
            }
            if (this.psdevcenterserver == null) {
                PSDevCenterServer pSDevCenterServer = new PSDevCenterServer();
                pSDevCenterServer.setPSDevCenterServerId(this.getPSDevCenterServerId());
                PSDevCenterServerService pSDevCenterServerService = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterServerService.autoGet((IEntity)pSDevCenterServer);
                this.psdevcenterserver = pSDevCenterServer;
            }
            return this.psdevcenterserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnCodeServerBase getProxyEntity() {
        return this.proxyPSDevSlnCodeServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnCodeServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnCodeServerBase) {
            this.proxyPSDevSlnCodeServerBase = (PSDevSlnCodeServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCodeServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CSPARAM, 2);
        fieldIndexMap.put(FIELD_CSPARAM2, 3);
        fieldIndexMap.put(FIELD_CSPARAM3, 4);
        fieldIndexMap.put(FIELD_CSPARAM4, 5);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 6);
        fieldIndexMap.put(FIELD_HOSTPASSWD, 7);
        fieldIndexMap.put(FIELD_HOSTUSERNAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERID, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNCODESERVERID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNCODESERVERNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 15);
        fieldIndexMap.put(FIELD_RESREADYTIME, 16);
        fieldIndexMap.put(FIELD_RESSTATE, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

