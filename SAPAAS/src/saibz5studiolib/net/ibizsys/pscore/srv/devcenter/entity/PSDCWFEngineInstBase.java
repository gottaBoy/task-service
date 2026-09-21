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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWFEngineInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSWFEngineInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCWFEngineInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCWFEngineInstBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDCWFENGINEINSTID = "PSDCWFENGINEINSTID";
    public static final String FIELD_PSDCWFENGINEINSTNAME = "PSDCWFENGINEINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSWFENGINEINSTID = "PSWFENGINEINSTID";
    public static final String FIELD_PSWFENGINEINSTNAME = "PSWFENGINEINSTNAME";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WFENGINETYPE = "WFENGINETYPE";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_EXPRIEDTIME = 3;
    private static final int INDEX_IPADDR = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PARAM = 6;
    private static final int INDEX_PARAM2 = 7;
    private static final int INDEX_PORT = 8;
    private static final int INDEX_PSDCCONTAINERSPECID = 9;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 10;
    private static final int INDEX_PSDCFILEID = 11;
    private static final int INDEX_PSDCFILENAME = 12;
    private static final int INDEX_PSDCWFENGINEINSTID = 13;
    private static final int INDEX_PSDCWFENGINEINSTNAME = 14;
    private static final int INDEX_PSDEVCENTERID = 15;
    private static final int INDEX_PSDEVCENTERNAME = 16;
    private static final int INDEX_PSDEVSLNID = 17;
    private static final int INDEX_PSDEVSLNNAME = 18;
    private static final int INDEX_PSWFENGINEINSTID = 19;
    private static final int INDEX_PSWFENGINEINSTNAME = 20;
    private static final int INDEX_RESPOS = 21;
    private static final int INDEX_RESREADYTIME = 22;
    private static final int INDEX_RESSTATE = 23;
    private static final int INDEX_RESVER = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_USAGEMODE = 27;
    private static final int INDEX_USERNAME = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final int INDEX_WFENGINETYPE = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCWFEngineInstBase proxyPSDCWFEngineInstBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdcwfengineinstidDirtyFlag = false;
    private boolean psdcwfengineinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean pswfengineinstidDirtyFlag = false;
    private boolean pswfengineinstnameDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean wfenginetypeDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="port")
    private Integer port;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdcwfengineinstid")
    private String psdcwfengineinstid;
    @Column(name="psdcwfengineinstname")
    private String psdcwfengineinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="pswfengineinstid")
    private String pswfengineinstid;
    @Column(name="pswfengineinstname")
    private String pswfengineinstname;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usagemode")
    private String usagemode;
    @Column(name="username")
    private String username;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="wfenginetype")
    private String wfenginetype;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSWFEngineInstLock = new Integer(1);
    private PSWFEngineInst pswfengineinst = null;

    public void setConnStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.connstr = string;
        this.connstrDirtyFlag = true;
    }

    public String getConnStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnStr();
        }
        return this.connstr;
    }

    public boolean isConnStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnStrDirty();
        }
        return this.connstrDirtyFlag;
    }

    public void resetConnStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnStr();
            return;
        }
        this.connstrDirtyFlag = false;
        this.connstr = null;
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

    public void setIpAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIpAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr();
        }
        return this.ipaddr;
    }

    public boolean isIpAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIpAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPort(n);
            return;
        }
        this.port = n;
        this.portDirtyFlag = true;
    }

    public Integer getPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPort();
        }
        return this.port;
    }

    public boolean isPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortDirty();
        }
        return this.portDirtyFlag;
    }

    public void resetPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPort();
            return;
        }
        this.portDirtyFlag = false;
        this.port = null;
    }

    public void setPSDCContainerSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecid = string;
        this.psdccontainerspecidDirtyFlag = true;
    }

    public String getPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecId();
        }
        return this.psdccontainerspecid;
    }

    public boolean isPSDCContainerSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecIdDirty();
        }
        return this.psdccontainerspecidDirtyFlag;
    }

    public void resetPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecId();
            return;
        }
        this.psdccontainerspecidDirtyFlag = false;
        this.psdccontainerspecid = null;
    }

    public void setPSDCContainerSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecname = string;
        this.psdccontainerspecnameDirtyFlag = true;
    }

    public String getPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecName();
        }
        return this.psdccontainerspecname;
    }

    public boolean isPSDCContainerSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecNameDirty();
        }
        return this.psdccontainerspecnameDirtyFlag;
    }

    public void resetPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecName();
            return;
        }
        this.psdccontainerspecnameDirtyFlag = false;
        this.psdccontainerspecname = null;
    }

    public void setPSDCFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfileid = string;
        this.psdcfileidDirtyFlag = true;
    }

    public String getPSDCFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileId();
        }
        return this.psdcfileid;
    }

    public boolean isPSDCFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileIdDirty();
        }
        return this.psdcfileidDirtyFlag;
    }

    public void resetPSDCFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileId();
            return;
        }
        this.psdcfileidDirtyFlag = false;
        this.psdcfileid = null;
    }

    public void setPSDCFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfilename = string;
        this.psdcfilenameDirtyFlag = true;
    }

    public String getPSDCFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileName();
        }
        return this.psdcfilename;
    }

    public boolean isPSDCFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileNameDirty();
        }
        return this.psdcfilenameDirtyFlag;
    }

    public void resetPSDCFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileName();
            return;
        }
        this.psdcfilenameDirtyFlag = false;
        this.psdcfilename = null;
    }

    public void setPSDCWFEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWFEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcwfengineinstid = string;
        this.psdcwfengineinstidDirtyFlag = true;
    }

    public String getPSDCWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWFEngineInstId();
        }
        return this.psdcwfengineinstid;
    }

    public boolean isPSDCWFEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWFEngineInstIdDirty();
        }
        return this.psdcwfengineinstidDirtyFlag;
    }

    public void resetPSDCWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWFEngineInstId();
            return;
        }
        this.psdcwfengineinstidDirtyFlag = false;
        this.psdcwfengineinstid = null;
    }

    public void setPSDCWFEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWFEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcwfengineinstname = string;
        this.psdcwfengineinstnameDirtyFlag = true;
    }

    public String getPSDCWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWFEngineInstName();
        }
        return this.psdcwfengineinstname;
    }

    public boolean isPSDCWFEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWFEngineInstNameDirty();
        }
        return this.psdcwfengineinstnameDirtyFlag;
    }

    public void resetPSDCWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWFEngineInstName();
            return;
        }
        this.psdcwfengineinstnameDirtyFlag = false;
        this.psdcwfengineinstname = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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

    public void setPSWFEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfengineinstid = string;
        this.pswfengineinstidDirtyFlag = true;
    }

    public String getPSWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFEngineInstId();
        }
        return this.pswfengineinstid;
    }

    public boolean isPSWFEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFEngineInstIdDirty();
        }
        return this.pswfengineinstidDirtyFlag;
    }

    public void resetPSWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFEngineInstId();
            return;
        }
        this.pswfengineinstidDirtyFlag = false;
        this.pswfengineinstid = null;
    }

    public void setPSWFEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfengineinstname = string;
        this.pswfengineinstnameDirtyFlag = true;
    }

    public String getPSWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFEngineInstName();
        }
        return this.pswfengineinstname;
    }

    public boolean isPSWFEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFEngineInstNameDirty();
        }
        return this.pswfengineinstnameDirtyFlag;
    }

    public void resetPSWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFEngineInstName();
            return;
        }
        this.pswfengineinstnameDirtyFlag = false;
        this.pswfengineinstname = null;
    }

    public void setResPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResPos(n);
            return;
        }
        this.respos = n;
        this.resposDirtyFlag = true;
    }

    public Integer getResPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResPos();
        }
        return this.respos;
    }

    public boolean isResPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResPosDirty();
        }
        return this.resposDirtyFlag;
    }

    public void resetResPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResPos();
            return;
        }
        this.resposDirtyFlag = false;
        this.respos = null;
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

    public void setResVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResVer(n);
            return;
        }
        this.resver = n;
        this.resverDirtyFlag = true;
    }

    public Integer getResVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResVer();
        }
        return this.resver;
    }

    public boolean isResVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResVerDirty();
        }
        return this.resverDirtyFlag;
    }

    public void resetResVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResVer();
            return;
        }
        this.resverDirtyFlag = false;
        this.resver = null;
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

    public void setUsageMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsageMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usagemode = string;
        this.usagemodeDirtyFlag = true;
    }

    public String getUsageMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsageMode();
        }
        return this.usagemode;
    }

    public boolean isUsageModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageModeDirty();
        }
        return this.usagemodeDirtyFlag;
    }

    public void resetUsageMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsageMode();
            return;
        }
        this.usagemodeDirtyFlag = false;
        this.usagemode = null;
    }

    public void setUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.username = string;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
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

    public void setWFEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfenginetype = string;
        this.wfenginetypeDirtyFlag = true;
    }

    public String getWFEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFEngineType();
        }
        return this.wfenginetype;
    }

    public boolean isWFEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFEngineTypeDirty();
        }
        return this.wfenginetypeDirtyFlag;
    }

    public void resetWFEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFEngineType();
            return;
        }
        this.wfenginetypeDirtyFlag = false;
        this.wfenginetype = null;
    }

    protected void onReset() {
        PSDCWFEngineInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCWFEngineInstBase pSDCWFEngineInstBase) {
        pSDCWFEngineInstBase.resetConnStr();
        pSDCWFEngineInstBase.resetCreateDate();
        pSDCWFEngineInstBase.resetCreateMan();
        pSDCWFEngineInstBase.resetExpriedTime();
        pSDCWFEngineInstBase.resetIpAddr();
        pSDCWFEngineInstBase.resetMemo();
        pSDCWFEngineInstBase.resetParam();
        pSDCWFEngineInstBase.resetParam2();
        pSDCWFEngineInstBase.resetPort();
        pSDCWFEngineInstBase.resetPSDCContainerSpecId();
        pSDCWFEngineInstBase.resetPSDCContainerSpecName();
        pSDCWFEngineInstBase.resetPSDCFileId();
        pSDCWFEngineInstBase.resetPSDCFileName();
        pSDCWFEngineInstBase.resetPSDCWFEngineInstId();
        pSDCWFEngineInstBase.resetPSDCWFEngineInstName();
        pSDCWFEngineInstBase.resetPSDevCenterId();
        pSDCWFEngineInstBase.resetPSDevCenterName();
        pSDCWFEngineInstBase.resetPSDevSlnId();
        pSDCWFEngineInstBase.resetPSDevSlnName();
        pSDCWFEngineInstBase.resetPSWFEngineInstId();
        pSDCWFEngineInstBase.resetPSWFEngineInstName();
        pSDCWFEngineInstBase.resetResPos();
        pSDCWFEngineInstBase.resetResReadyTime();
        pSDCWFEngineInstBase.resetResState();
        pSDCWFEngineInstBase.resetResVer();
        pSDCWFEngineInstBase.resetUpdateDate();
        pSDCWFEngineInstBase.resetUpdateMan();
        pSDCWFEngineInstBase.resetUsageMode();
        pSDCWFEngineInstBase.resetUserName();
        pSDCWFEngineInstBase.resetUserTag();
        pSDCWFEngineInstBase.resetUserTag2();
        pSDCWFEngineInstBase.resetUserTag3();
        pSDCWFEngineInstBase.resetUserTag4();
        pSDCWFEngineInstBase.resetWFEngineType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConnStrDirty()) {
            hashMap.put(FIELD_CONNSTR, this.getConnStr());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSDCContainerSpecIdDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECID, this.getPSDCContainerSpecId());
        }
        if (!bl || this.isPSDCContainerSpecNameDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECNAME, this.getPSDCContainerSpecName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDCWFEngineInstIdDirty()) {
            hashMap.put(FIELD_PSDCWFENGINEINSTID, this.getPSDCWFEngineInstId());
        }
        if (!bl || this.isPSDCWFEngineInstNameDirty()) {
            hashMap.put(FIELD_PSDCWFENGINEINSTNAME, this.getPSDCWFEngineInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSWFEngineInstIdDirty()) {
            hashMap.put(FIELD_PSWFENGINEINSTID, this.getPSWFEngineInstId());
        }
        if (!bl || this.isPSWFEngineInstNameDirty()) {
            hashMap.put(FIELD_PSWFENGINEINSTNAME, this.getPSWFEngineInstName());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isResVerDirty()) {
            hashMap.put(FIELD_RESVER, this.getResVer());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        if (!bl || this.isWFEngineTypeDirty()) {
            hashMap.put(FIELD_WFENGINETYPE, this.getWFEngineType());
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
        return PSDCWFEngineInstBase.get(this, n);
    }

    private static Object get(PSDCWFEngineInstBase pSDCWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWFEngineInstBase.getConnStr();
            }
            case 1: {
                return pSDCWFEngineInstBase.getCreateDate();
            }
            case 2: {
                return pSDCWFEngineInstBase.getCreateMan();
            }
            case 3: {
                return pSDCWFEngineInstBase.getExpriedTime();
            }
            case 4: {
                return pSDCWFEngineInstBase.getIpAddr();
            }
            case 5: {
                return pSDCWFEngineInstBase.getMemo();
            }
            case 6: {
                return pSDCWFEngineInstBase.getParam();
            }
            case 7: {
                return pSDCWFEngineInstBase.getParam2();
            }
            case 8: {
                return pSDCWFEngineInstBase.getPort();
            }
            case 9: {
                return pSDCWFEngineInstBase.getPSDCContainerSpecId();
            }
            case 10: {
                return pSDCWFEngineInstBase.getPSDCContainerSpecName();
            }
            case 11: {
                return pSDCWFEngineInstBase.getPSDCFileId();
            }
            case 12: {
                return pSDCWFEngineInstBase.getPSDCFileName();
            }
            case 13: {
                return pSDCWFEngineInstBase.getPSDCWFEngineInstId();
            }
            case 14: {
                return pSDCWFEngineInstBase.getPSDCWFEngineInstName();
            }
            case 15: {
                return pSDCWFEngineInstBase.getPSDevCenterId();
            }
            case 16: {
                return pSDCWFEngineInstBase.getPSDevCenterName();
            }
            case 17: {
                return pSDCWFEngineInstBase.getPSDevSlnId();
            }
            case 18: {
                return pSDCWFEngineInstBase.getPSDevSlnName();
            }
            case 19: {
                return pSDCWFEngineInstBase.getPSWFEngineInstId();
            }
            case 20: {
                return pSDCWFEngineInstBase.getPSWFEngineInstName();
            }
            case 21: {
                return pSDCWFEngineInstBase.getResPos();
            }
            case 22: {
                return pSDCWFEngineInstBase.getResReadyTime();
            }
            case 23: {
                return pSDCWFEngineInstBase.getResState();
            }
            case 24: {
                return pSDCWFEngineInstBase.getResVer();
            }
            case 25: {
                return pSDCWFEngineInstBase.getUpdateDate();
            }
            case 26: {
                return pSDCWFEngineInstBase.getUpdateMan();
            }
            case 27: {
                return pSDCWFEngineInstBase.getUsageMode();
            }
            case 28: {
                return pSDCWFEngineInstBase.getUserName();
            }
            case 29: {
                return pSDCWFEngineInstBase.getUserTag();
            }
            case 30: {
                return pSDCWFEngineInstBase.getUserTag2();
            }
            case 31: {
                return pSDCWFEngineInstBase.getUserTag3();
            }
            case 32: {
                return pSDCWFEngineInstBase.getUserTag4();
            }
            case 33: {
                return pSDCWFEngineInstBase.getWFEngineType();
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
        PSDCWFEngineInstBase.set(this, n, object);
    }

    private static void set(PSDCWFEngineInstBase pSDCWFEngineInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCWFEngineInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCWFEngineInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCWFEngineInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCWFEngineInstBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCWFEngineInstBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCWFEngineInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCWFEngineInstBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCWFEngineInstBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCWFEngineInstBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCWFEngineInstBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCWFEngineInstBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCWFEngineInstBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCWFEngineInstBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCWFEngineInstBase.setPSDCWFEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCWFEngineInstBase.setPSDCWFEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCWFEngineInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCWFEngineInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCWFEngineInstBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCWFEngineInstBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCWFEngineInstBase.setPSWFEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCWFEngineInstBase.setPSWFEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCWFEngineInstBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDCWFEngineInstBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDCWFEngineInstBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDCWFEngineInstBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDCWFEngineInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSDCWFEngineInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCWFEngineInstBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCWFEngineInstBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCWFEngineInstBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCWFEngineInstBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCWFEngineInstBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCWFEngineInstBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCWFEngineInstBase.setWFEngineType(DataObject.getStringValue((Object)object));
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
        return PSDCWFEngineInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDCWFEngineInstBase pSDCWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWFEngineInstBase.getConnStr() == null;
            }
            case 1: {
                return pSDCWFEngineInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCWFEngineInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCWFEngineInstBase.getExpriedTime() == null;
            }
            case 4: {
                return pSDCWFEngineInstBase.getIpAddr() == null;
            }
            case 5: {
                return pSDCWFEngineInstBase.getMemo() == null;
            }
            case 6: {
                return pSDCWFEngineInstBase.getParam() == null;
            }
            case 7: {
                return pSDCWFEngineInstBase.getParam2() == null;
            }
            case 8: {
                return pSDCWFEngineInstBase.getPort() == null;
            }
            case 9: {
                return pSDCWFEngineInstBase.getPSDCContainerSpecId() == null;
            }
            case 10: {
                return pSDCWFEngineInstBase.getPSDCContainerSpecName() == null;
            }
            case 11: {
                return pSDCWFEngineInstBase.getPSDCFileId() == null;
            }
            case 12: {
                return pSDCWFEngineInstBase.getPSDCFileName() == null;
            }
            case 13: {
                return pSDCWFEngineInstBase.getPSDCWFEngineInstId() == null;
            }
            case 14: {
                return pSDCWFEngineInstBase.getPSDCWFEngineInstName() == null;
            }
            case 15: {
                return pSDCWFEngineInstBase.getPSDevCenterId() == null;
            }
            case 16: {
                return pSDCWFEngineInstBase.getPSDevCenterName() == null;
            }
            case 17: {
                return pSDCWFEngineInstBase.getPSDevSlnId() == null;
            }
            case 18: {
                return pSDCWFEngineInstBase.getPSDevSlnName() == null;
            }
            case 19: {
                return pSDCWFEngineInstBase.getPSWFEngineInstId() == null;
            }
            case 20: {
                return pSDCWFEngineInstBase.getPSWFEngineInstName() == null;
            }
            case 21: {
                return pSDCWFEngineInstBase.getResPos() == null;
            }
            case 22: {
                return pSDCWFEngineInstBase.getResReadyTime() == null;
            }
            case 23: {
                return pSDCWFEngineInstBase.getResState() == null;
            }
            case 24: {
                return pSDCWFEngineInstBase.getResVer() == null;
            }
            case 25: {
                return pSDCWFEngineInstBase.getUpdateDate() == null;
            }
            case 26: {
                return pSDCWFEngineInstBase.getUpdateMan() == null;
            }
            case 27: {
                return pSDCWFEngineInstBase.getUsageMode() == null;
            }
            case 28: {
                return pSDCWFEngineInstBase.getUserName() == null;
            }
            case 29: {
                return pSDCWFEngineInstBase.getUserTag() == null;
            }
            case 30: {
                return pSDCWFEngineInstBase.getUserTag2() == null;
            }
            case 31: {
                return pSDCWFEngineInstBase.getUserTag3() == null;
            }
            case 32: {
                return pSDCWFEngineInstBase.getUserTag4() == null;
            }
            case 33: {
                return pSDCWFEngineInstBase.getWFEngineType() == null;
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
        return PSDCWFEngineInstBase.contains(this, n);
    }

    private static boolean contains(PSDCWFEngineInstBase pSDCWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWFEngineInstBase.isConnStrDirty();
            }
            case 1: {
                return pSDCWFEngineInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCWFEngineInstBase.isCreateManDirty();
            }
            case 3: {
                return pSDCWFEngineInstBase.isExpriedTimeDirty();
            }
            case 4: {
                return pSDCWFEngineInstBase.isIpAddrDirty();
            }
            case 5: {
                return pSDCWFEngineInstBase.isMemoDirty();
            }
            case 6: {
                return pSDCWFEngineInstBase.isParamDirty();
            }
            case 7: {
                return pSDCWFEngineInstBase.isParam2Dirty();
            }
            case 8: {
                return pSDCWFEngineInstBase.isPortDirty();
            }
            case 9: {
                return pSDCWFEngineInstBase.isPSDCContainerSpecIdDirty();
            }
            case 10: {
                return pSDCWFEngineInstBase.isPSDCContainerSpecNameDirty();
            }
            case 11: {
                return pSDCWFEngineInstBase.isPSDCFileIdDirty();
            }
            case 12: {
                return pSDCWFEngineInstBase.isPSDCFileNameDirty();
            }
            case 13: {
                return pSDCWFEngineInstBase.isPSDCWFEngineInstIdDirty();
            }
            case 14: {
                return pSDCWFEngineInstBase.isPSDCWFEngineInstNameDirty();
            }
            case 15: {
                return pSDCWFEngineInstBase.isPSDevCenterIdDirty();
            }
            case 16: {
                return pSDCWFEngineInstBase.isPSDevCenterNameDirty();
            }
            case 17: {
                return pSDCWFEngineInstBase.isPSDevSlnIdDirty();
            }
            case 18: {
                return pSDCWFEngineInstBase.isPSDevSlnNameDirty();
            }
            case 19: {
                return pSDCWFEngineInstBase.isPSWFEngineInstIdDirty();
            }
            case 20: {
                return pSDCWFEngineInstBase.isPSWFEngineInstNameDirty();
            }
            case 21: {
                return pSDCWFEngineInstBase.isResPosDirty();
            }
            case 22: {
                return pSDCWFEngineInstBase.isResReadyTimeDirty();
            }
            case 23: {
                return pSDCWFEngineInstBase.isResStateDirty();
            }
            case 24: {
                return pSDCWFEngineInstBase.isResVerDirty();
            }
            case 25: {
                return pSDCWFEngineInstBase.isUpdateDateDirty();
            }
            case 26: {
                return pSDCWFEngineInstBase.isUpdateManDirty();
            }
            case 27: {
                return pSDCWFEngineInstBase.isUsageModeDirty();
            }
            case 28: {
                return pSDCWFEngineInstBase.isUserNameDirty();
            }
            case 29: {
                return pSDCWFEngineInstBase.isUserTagDirty();
            }
            case 30: {
                return pSDCWFEngineInstBase.isUserTag2Dirty();
            }
            case 31: {
                return pSDCWFEngineInstBase.isUserTag3Dirty();
            }
            case 32: {
                return pSDCWFEngineInstBase.isUserTag4Dirty();
            }
            case 33: {
                return pSDCWFEngineInstBase.isWFEngineTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCWFEngineInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCWFEngineInstBase pSDCWFEngineInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCWFEngineInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getParam()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getParam2()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPort()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCWFEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcwfengineinstid", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDCWFEngineInstId()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCWFEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcwfengineinstname", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDCWFEngineInstName()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSWFEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfengineinstid", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSWFEngineInstId()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getPSWFEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfengineinstname", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getPSWFEngineInstName()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getResState()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getResVer()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDCWFEngineInstBase.getWFEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfenginetype", (Object)PSDCWFEngineInstBase.getJSONValue((Object)pSDCWFEngineInstBase.getWFEngineType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCWFEngineInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCWFEngineInstBase pSDCWFEngineInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCWFEngineInstBase.getConnStr() != null) {
            object = pSDCWFEngineInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getCreateDate() != null) {
            object = pSDCWFEngineInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWFEngineInstBase.getCreateMan() != null) {
            object = pSDCWFEngineInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getExpriedTime() != null) {
            object = pSDCWFEngineInstBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWFEngineInstBase.getIpAddr() != null) {
            object = pSDCWFEngineInstBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getMemo() != null) {
            object = pSDCWFEngineInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getParam() != null) {
            object = pSDCWFEngineInstBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getParam2() != null) {
            object = pSDCWFEngineInstBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPort() != null) {
            object = pSDCWFEngineInstBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWFEngineInstBase.getPSDCContainerSpecId() != null) {
            object = pSDCWFEngineInstBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCContainerSpecName() != null) {
            object = pSDCWFEngineInstBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCFileId() != null) {
            object = pSDCWFEngineInstBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCFileName() != null) {
            object = pSDCWFEngineInstBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCWFEngineInstId() != null) {
            object = pSDCWFEngineInstBase.getPSDCWFEngineInstId();
            xmlNode.setAttribute(FIELD_PSDCWFENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDCWFEngineInstName() != null) {
            object = pSDCWFEngineInstBase.getPSDCWFEngineInstName();
            xmlNode.setAttribute(FIELD_PSDCWFENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDevCenterId() != null) {
            object = pSDCWFEngineInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDevCenterName() != null) {
            object = pSDCWFEngineInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDevSlnId() != null) {
            object = pSDCWFEngineInstBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSDevSlnName() != null) {
            object = pSDCWFEngineInstBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSWFEngineInstId() != null) {
            object = pSDCWFEngineInstBase.getPSWFEngineInstId();
            xmlNode.setAttribute(FIELD_PSWFENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getPSWFEngineInstName() != null) {
            object = pSDCWFEngineInstBase.getPSWFEngineInstName();
            xmlNode.setAttribute(FIELD_PSWFENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getResPos() != null) {
            object = pSDCWFEngineInstBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWFEngineInstBase.getResReadyTime() != null) {
            object = pSDCWFEngineInstBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWFEngineInstBase.getResState() != null) {
            object = pSDCWFEngineInstBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWFEngineInstBase.getResVer() != null) {
            object = pSDCWFEngineInstBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWFEngineInstBase.getUpdateDate() != null) {
            object = pSDCWFEngineInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWFEngineInstBase.getUpdateMan() != null) {
            object = pSDCWFEngineInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getUsageMode() != null) {
            object = pSDCWFEngineInstBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getUserName() != null) {
            object = pSDCWFEngineInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getUserTag() != null) {
            object = pSDCWFEngineInstBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getUserTag2() != null) {
            object = pSDCWFEngineInstBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getUserTag3() != null) {
            object = pSDCWFEngineInstBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getUserTag4() != null) {
            object = pSDCWFEngineInstBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCWFEngineInstBase.getWFEngineType() != null) {
            object = pSDCWFEngineInstBase.getWFEngineType();
            xmlNode.setAttribute(FIELD_WFENGINETYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCWFEngineInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCWFEngineInstBase pSDCWFEngineInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCWFEngineInstBase.isConnStrDirty() && (bl || pSDCWFEngineInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDCWFEngineInstBase.getConnStr());
        }
        if (pSDCWFEngineInstBase.isCreateDateDirty() && (bl || pSDCWFEngineInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCWFEngineInstBase.getCreateDate());
        }
        if (pSDCWFEngineInstBase.isCreateManDirty() && (bl || pSDCWFEngineInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCWFEngineInstBase.getCreateMan());
        }
        if (pSDCWFEngineInstBase.isExpriedTimeDirty() && (bl || pSDCWFEngineInstBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCWFEngineInstBase.getExpriedTime());
        }
        if (pSDCWFEngineInstBase.isIpAddrDirty() && (bl || pSDCWFEngineInstBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCWFEngineInstBase.getIpAddr());
        }
        if (pSDCWFEngineInstBase.isMemoDirty() && (bl || pSDCWFEngineInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCWFEngineInstBase.getMemo());
        }
        if (pSDCWFEngineInstBase.isParamDirty() && (bl || pSDCWFEngineInstBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDCWFEngineInstBase.getParam());
        }
        if (pSDCWFEngineInstBase.isParam2Dirty() && (bl || pSDCWFEngineInstBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDCWFEngineInstBase.getParam2());
        }
        if (pSDCWFEngineInstBase.isPortDirty() && (bl || pSDCWFEngineInstBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCWFEngineInstBase.getPort());
        }
        if (pSDCWFEngineInstBase.isPSDCContainerSpecIdDirty() && (bl || pSDCWFEngineInstBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDCWFEngineInstBase.getPSDCContainerSpecId());
        }
        if (pSDCWFEngineInstBase.isPSDCContainerSpecNameDirty() && (bl || pSDCWFEngineInstBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDCWFEngineInstBase.getPSDCContainerSpecName());
        }
        if (pSDCWFEngineInstBase.isPSDCFileIdDirty() && (bl || pSDCWFEngineInstBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDCWFEngineInstBase.getPSDCFileId());
        }
        if (pSDCWFEngineInstBase.isPSDCFileNameDirty() && (bl || pSDCWFEngineInstBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDCWFEngineInstBase.getPSDCFileName());
        }
        if (pSDCWFEngineInstBase.isPSDCWFEngineInstIdDirty() && (bl || pSDCWFEngineInstBase.getPSDCWFEngineInstId() != null)) {
            iDataObject.set(FIELD_PSDCWFENGINEINSTID, (Object)pSDCWFEngineInstBase.getPSDCWFEngineInstId());
        }
        if (pSDCWFEngineInstBase.isPSDCWFEngineInstNameDirty() && (bl || pSDCWFEngineInstBase.getPSDCWFEngineInstName() != null)) {
            iDataObject.set(FIELD_PSDCWFENGINEINSTNAME, (Object)pSDCWFEngineInstBase.getPSDCWFEngineInstName());
        }
        if (pSDCWFEngineInstBase.isPSDevCenterIdDirty() && (bl || pSDCWFEngineInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCWFEngineInstBase.getPSDevCenterId());
        }
        if (pSDCWFEngineInstBase.isPSDevCenterNameDirty() && (bl || pSDCWFEngineInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCWFEngineInstBase.getPSDevCenterName());
        }
        if (pSDCWFEngineInstBase.isPSDevSlnIdDirty() && (bl || pSDCWFEngineInstBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCWFEngineInstBase.getPSDevSlnId());
        }
        if (pSDCWFEngineInstBase.isPSDevSlnNameDirty() && (bl || pSDCWFEngineInstBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCWFEngineInstBase.getPSDevSlnName());
        }
        if (pSDCWFEngineInstBase.isPSWFEngineInstIdDirty() && (bl || pSDCWFEngineInstBase.getPSWFEngineInstId() != null)) {
            iDataObject.set(FIELD_PSWFENGINEINSTID, (Object)pSDCWFEngineInstBase.getPSWFEngineInstId());
        }
        if (pSDCWFEngineInstBase.isPSWFEngineInstNameDirty() && (bl || pSDCWFEngineInstBase.getPSWFEngineInstName() != null)) {
            iDataObject.set(FIELD_PSWFENGINEINSTNAME, (Object)pSDCWFEngineInstBase.getPSWFEngineInstName());
        }
        if (pSDCWFEngineInstBase.isResPosDirty() && (bl || pSDCWFEngineInstBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCWFEngineInstBase.getResPos());
        }
        if (pSDCWFEngineInstBase.isResReadyTimeDirty() && (bl || pSDCWFEngineInstBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCWFEngineInstBase.getResReadyTime());
        }
        if (pSDCWFEngineInstBase.isResStateDirty() && (bl || pSDCWFEngineInstBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCWFEngineInstBase.getResState());
        }
        if (pSDCWFEngineInstBase.isResVerDirty() && (bl || pSDCWFEngineInstBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDCWFEngineInstBase.getResVer());
        }
        if (pSDCWFEngineInstBase.isUpdateDateDirty() && (bl || pSDCWFEngineInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCWFEngineInstBase.getUpdateDate());
        }
        if (pSDCWFEngineInstBase.isUpdateManDirty() && (bl || pSDCWFEngineInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCWFEngineInstBase.getUpdateMan());
        }
        if (pSDCWFEngineInstBase.isUsageModeDirty() && (bl || pSDCWFEngineInstBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSDCWFEngineInstBase.getUsageMode());
        }
        if (pSDCWFEngineInstBase.isUserNameDirty() && (bl || pSDCWFEngineInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCWFEngineInstBase.getUserName());
        }
        if (pSDCWFEngineInstBase.isUserTagDirty() && (bl || pSDCWFEngineInstBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCWFEngineInstBase.getUserTag());
        }
        if (pSDCWFEngineInstBase.isUserTag2Dirty() && (bl || pSDCWFEngineInstBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCWFEngineInstBase.getUserTag2());
        }
        if (pSDCWFEngineInstBase.isUserTag3Dirty() && (bl || pSDCWFEngineInstBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCWFEngineInstBase.getUserTag3());
        }
        if (pSDCWFEngineInstBase.isUserTag4Dirty() && (bl || pSDCWFEngineInstBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCWFEngineInstBase.getUserTag4());
        }
        if (pSDCWFEngineInstBase.isWFEngineTypeDirty() && (bl || pSDCWFEngineInstBase.getWFEngineType() != null)) {
            iDataObject.set(FIELD_WFENGINETYPE, (Object)pSDCWFEngineInstBase.getWFEngineType());
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
        return PSDCWFEngineInstBase.remove(this, n);
    }

    private static boolean remove(PSDCWFEngineInstBase pSDCWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCWFEngineInstBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDCWFEngineInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCWFEngineInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCWFEngineInstBase.resetExpriedTime();
                return true;
            }
            case 4: {
                pSDCWFEngineInstBase.resetIpAddr();
                return true;
            }
            case 5: {
                pSDCWFEngineInstBase.resetMemo();
                return true;
            }
            case 6: {
                pSDCWFEngineInstBase.resetParam();
                return true;
            }
            case 7: {
                pSDCWFEngineInstBase.resetParam2();
                return true;
            }
            case 8: {
                pSDCWFEngineInstBase.resetPort();
                return true;
            }
            case 9: {
                pSDCWFEngineInstBase.resetPSDCContainerSpecId();
                return true;
            }
            case 10: {
                pSDCWFEngineInstBase.resetPSDCContainerSpecName();
                return true;
            }
            case 11: {
                pSDCWFEngineInstBase.resetPSDCFileId();
                return true;
            }
            case 12: {
                pSDCWFEngineInstBase.resetPSDCFileName();
                return true;
            }
            case 13: {
                pSDCWFEngineInstBase.resetPSDCWFEngineInstId();
                return true;
            }
            case 14: {
                pSDCWFEngineInstBase.resetPSDCWFEngineInstName();
                return true;
            }
            case 15: {
                pSDCWFEngineInstBase.resetPSDevCenterId();
                return true;
            }
            case 16: {
                pSDCWFEngineInstBase.resetPSDevCenterName();
                return true;
            }
            case 17: {
                pSDCWFEngineInstBase.resetPSDevSlnId();
                return true;
            }
            case 18: {
                pSDCWFEngineInstBase.resetPSDevSlnName();
                return true;
            }
            case 19: {
                pSDCWFEngineInstBase.resetPSWFEngineInstId();
                return true;
            }
            case 20: {
                pSDCWFEngineInstBase.resetPSWFEngineInstName();
                return true;
            }
            case 21: {
                pSDCWFEngineInstBase.resetResPos();
                return true;
            }
            case 22: {
                pSDCWFEngineInstBase.resetResReadyTime();
                return true;
            }
            case 23: {
                pSDCWFEngineInstBase.resetResState();
                return true;
            }
            case 24: {
                pSDCWFEngineInstBase.resetResVer();
                return true;
            }
            case 25: {
                pSDCWFEngineInstBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSDCWFEngineInstBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSDCWFEngineInstBase.resetUsageMode();
                return true;
            }
            case 28: {
                pSDCWFEngineInstBase.resetUserName();
                return true;
            }
            case 29: {
                pSDCWFEngineInstBase.resetUserTag();
                return true;
            }
            case 30: {
                pSDCWFEngineInstBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSDCWFEngineInstBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSDCWFEngineInstBase.resetUserTag4();
                return true;
            }
            case 33: {
                pSDCWFEngineInstBase.resetWFEngineType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCContainerSpec getPSDCContainerSpec() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpec();
        }
        if (this.getPSDCContainerSpecId() == null) {
            return null;
        }
        Integer n = this.objPSDCContainerSpecLock;
        synchronized (n) {
            if (this.psdccontainerspec != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCContainerSpecId(), (Object)this.psdccontainerspec.getPSDCContainerSpecId()) != 0L) {
                this.psdccontainerspec = null;
            }
            if (this.psdccontainerspec == null) {
                PSDCContainerSpec pSDCContainerSpec = new PSDCContainerSpec();
                pSDCContainerSpec.setPSDCContainerSpecId(this.getPSDCContainerSpecId());
                PSDCContainerSpecService pSDCContainerSpecService = (PSDCContainerSpecService)ServiceGlobal.getService(PSDCContainerSpecService.class, (SessionFactory)this.getSessionFactory());
                pSDCContainerSpecService.autoGet((IEntity)pSDCContainerSpec);
                this.psdccontainerspec = pSDCContainerSpec;
            }
            return this.psdccontainerspec;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCFile getPSDCFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFile();
        }
        if (this.getPSDCFileId() == null) {
            return null;
        }
        Integer n = this.objPSDCFileLock;
        synchronized (n) {
            if (this.psdcfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCFileId(), (Object)this.psdcfile.getPSDCFileId()) != 0L) {
                this.psdcfile = null;
            }
            if (this.psdcfile == null) {
                PSDCFile pSDCFile = new PSDCFile();
                pSDCFile.setPSDCFileId(this.getPSDCFileId());
                PSDCFileService pSDCFileService = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
                pSDCFileService.autoGet((IEntity)pSDCFile);
                this.psdcfile = pSDCFile;
            }
            return this.psdcfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFEngineInst getPSWFEngineInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFEngineInst();
        }
        if (this.getPSWFEngineInstId() == null) {
            return null;
        }
        Integer n = this.objPSWFEngineInstLock;
        synchronized (n) {
            if (this.pswfengineinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFEngineInstId(), (Object)this.pswfengineinst.getPSWFEngineInstId()) != 0L) {
                this.pswfengineinst = null;
            }
            if (this.pswfengineinst == null) {
                PSWFEngineInst pSWFEngineInst = new PSWFEngineInst();
                pSWFEngineInst.setPSWFEngineInstId(this.getPSWFEngineInstId());
                PSWFEngineInstService pSWFEngineInstService = (PSWFEngineInstService)ServiceGlobal.getService(PSWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
                pSWFEngineInstService.autoGet((IEntity)pSWFEngineInst);
                this.pswfengineinst = pSWFEngineInst;
            }
            return this.pswfengineinst;
        }
    }

    private PSDCWFEngineInstBase getProxyEntity() {
        return this.proxyPSDCWFEngineInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCWFEngineInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCWFEngineInstBase) {
            this.proxyPSDCWFEngineInstBase = (PSDCWFEngineInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 3);
        fieldIndexMap.put(FIELD_IPADDR, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PARAM, 6);
        fieldIndexMap.put(FIELD_PARAM2, 7);
        fieldIndexMap.put(FIELD_PORT, 8);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 9);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 10);
        fieldIndexMap.put(FIELD_PSDCFILEID, 11);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 12);
        fieldIndexMap.put(FIELD_PSDCWFENGINEINSTID, 13);
        fieldIndexMap.put(FIELD_PSDCWFENGINEINSTNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 18);
        fieldIndexMap.put(FIELD_PSWFENGINEINSTID, 19);
        fieldIndexMap.put(FIELD_PSWFENGINEINSTNAME, 20);
        fieldIndexMap.put(FIELD_RESPOS, 21);
        fieldIndexMap.put(FIELD_RESREADYTIME, 22);
        fieldIndexMap.put(FIELD_RESSTATE, 23);
        fieldIndexMap.put(FIELD_RESVER, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_USAGEMODE, 27);
        fieldIndexMap.put(FIELD_USERNAME, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
        fieldIndexMap.put(FIELD_WFENGINETYPE, 33);
    }
}

