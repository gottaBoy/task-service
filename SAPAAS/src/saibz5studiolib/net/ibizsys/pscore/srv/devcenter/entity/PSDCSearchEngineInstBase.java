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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSearchEngineInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSearchEngineInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSearchEngineInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSearchEngineInstBase.class);
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
    public static final String FIELD_PSDCSEARCHENGINEINSTID = "PSDCSEARCHENGINEINSTID";
    public static final String FIELD_PSDCSEARCHENGINEINSTNAME = "PSDCSEARCHENGINEINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSSEARCHENGINEINSTID = "PSSEARCHENGINEINSTID";
    public static final String FIELD_PSSEARCHENGINEINSTNAME = "PSSEARCHENGINEINSTNAME";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_SEARCHENGINETYPE = "SEARCHENGINETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
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
    private static final int INDEX_PSDCSEARCHENGINEINSTID = 13;
    private static final int INDEX_PSDCSEARCHENGINEINSTNAME = 14;
    private static final int INDEX_PSDEVCENTERID = 15;
    private static final int INDEX_PSDEVCENTERNAME = 16;
    private static final int INDEX_PSDEVSLNID = 17;
    private static final int INDEX_PSDEVSLNNAME = 18;
    private static final int INDEX_PSSEARCHENGINEINSTID = 19;
    private static final int INDEX_PSSEARCHENGINEINSTNAME = 20;
    private static final int INDEX_RESPOS = 21;
    private static final int INDEX_RESREADYTIME = 22;
    private static final int INDEX_RESSTATE = 23;
    private static final int INDEX_RESVER = 24;
    private static final int INDEX_SEARCHENGINETYPE = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USAGEMODE = 28;
    private static final int INDEX_USERNAME = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSearchEngineInstBase proxyPSDCSearchEngineInstBase = null;
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
    private boolean psdcsearchengineinstidDirtyFlag = false;
    private boolean psdcsearchengineinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean pssearchengineinstidDirtyFlag = false;
    private boolean pssearchengineinstnameDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean searchenginetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
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
    @Column(name="psdcsearchengineinstid")
    private String psdcsearchengineinstid;
    @Column(name="psdcsearchengineinstname")
    private String psdcsearchengineinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="pssearchengineinstid")
    private String pssearchengineinstid;
    @Column(name="pssearchengineinstname")
    private String pssearchengineinstname;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="searchenginetype")
    private String searchenginetype;
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
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSSearchEngineInstLock = new Integer(1);
    private PSSearchEngineInst pssearchengineinst = null;

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

    public void setPSDCSearchEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSearchEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsearchengineinstid = string;
        this.psdcsearchengineinstidDirtyFlag = true;
    }

    public String getPSDCSearchEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSearchEngineInstId();
        }
        return this.psdcsearchengineinstid;
    }

    public boolean isPSDCSearchEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSearchEngineInstIdDirty();
        }
        return this.psdcsearchengineinstidDirtyFlag;
    }

    public void resetPSDCSearchEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSearchEngineInstId();
            return;
        }
        this.psdcsearchengineinstidDirtyFlag = false;
        this.psdcsearchengineinstid = null;
    }

    public void setPSDCSearchEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSearchEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsearchengineinstname = string;
        this.psdcsearchengineinstnameDirtyFlag = true;
    }

    public String getPSDCSearchEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSearchEngineInstName();
        }
        return this.psdcsearchengineinstname;
    }

    public boolean isPSDCSearchEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSearchEngineInstNameDirty();
        }
        return this.psdcsearchengineinstnameDirtyFlag;
    }

    public void resetPSDCSearchEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSearchEngineInstName();
            return;
        }
        this.psdcsearchengineinstnameDirtyFlag = false;
        this.psdcsearchengineinstname = null;
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

    public void setPSSearchEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSearchEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssearchengineinstid = string;
        this.pssearchengineinstidDirtyFlag = true;
    }

    public String getPSSearchEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSearchEngineInstId();
        }
        return this.pssearchengineinstid;
    }

    public boolean isPSSearchEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSearchEngineInstIdDirty();
        }
        return this.pssearchengineinstidDirtyFlag;
    }

    public void resetPSSearchEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSearchEngineInstId();
            return;
        }
        this.pssearchengineinstidDirtyFlag = false;
        this.pssearchengineinstid = null;
    }

    public void setPSSearchEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSearchEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssearchengineinstname = string;
        this.pssearchengineinstnameDirtyFlag = true;
    }

    public String getPSSearchEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSearchEngineInstName();
        }
        return this.pssearchengineinstname;
    }

    public boolean isPSSearchEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSearchEngineInstNameDirty();
        }
        return this.pssearchengineinstnameDirtyFlag;
    }

    public void resetPSSearchEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSearchEngineInstName();
            return;
        }
        this.pssearchengineinstnameDirtyFlag = false;
        this.pssearchengineinstname = null;
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

    public void setSearchEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchenginetype = string;
        this.searchenginetypeDirtyFlag = true;
    }

    public String getSearchEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchEngineType();
        }
        return this.searchenginetype;
    }

    public boolean isSearchEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchEngineTypeDirty();
        }
        return this.searchenginetypeDirtyFlag;
    }

    public void resetSearchEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchEngineType();
            return;
        }
        this.searchenginetypeDirtyFlag = false;
        this.searchenginetype = null;
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

    protected void onReset() {
        PSDCSearchEngineInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSearchEngineInstBase pSDCSearchEngineInstBase) {
        pSDCSearchEngineInstBase.resetConnStr();
        pSDCSearchEngineInstBase.resetCreateDate();
        pSDCSearchEngineInstBase.resetCreateMan();
        pSDCSearchEngineInstBase.resetExpriedTime();
        pSDCSearchEngineInstBase.resetIpAddr();
        pSDCSearchEngineInstBase.resetMemo();
        pSDCSearchEngineInstBase.resetParam();
        pSDCSearchEngineInstBase.resetParam2();
        pSDCSearchEngineInstBase.resetPort();
        pSDCSearchEngineInstBase.resetPSDCContainerSpecId();
        pSDCSearchEngineInstBase.resetPSDCContainerSpecName();
        pSDCSearchEngineInstBase.resetPSDCFileId();
        pSDCSearchEngineInstBase.resetPSDCFileName();
        pSDCSearchEngineInstBase.resetPSDCSearchEngineInstId();
        pSDCSearchEngineInstBase.resetPSDCSearchEngineInstName();
        pSDCSearchEngineInstBase.resetPSDevCenterId();
        pSDCSearchEngineInstBase.resetPSDevCenterName();
        pSDCSearchEngineInstBase.resetPSDevSlnId();
        pSDCSearchEngineInstBase.resetPSDevSlnName();
        pSDCSearchEngineInstBase.resetPSSearchEngineInstId();
        pSDCSearchEngineInstBase.resetPSSearchEngineInstName();
        pSDCSearchEngineInstBase.resetResPos();
        pSDCSearchEngineInstBase.resetResReadyTime();
        pSDCSearchEngineInstBase.resetResState();
        pSDCSearchEngineInstBase.resetResVer();
        pSDCSearchEngineInstBase.resetSearchEngineType();
        pSDCSearchEngineInstBase.resetUpdateDate();
        pSDCSearchEngineInstBase.resetUpdateMan();
        pSDCSearchEngineInstBase.resetUsageMode();
        pSDCSearchEngineInstBase.resetUserName();
        pSDCSearchEngineInstBase.resetUserTag();
        pSDCSearchEngineInstBase.resetUserTag2();
        pSDCSearchEngineInstBase.resetUserTag3();
        pSDCSearchEngineInstBase.resetUserTag4();
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
        if (!bl || this.isPSDCSearchEngineInstIdDirty()) {
            hashMap.put(FIELD_PSDCSEARCHENGINEINSTID, this.getPSDCSearchEngineInstId());
        }
        if (!bl || this.isPSDCSearchEngineInstNameDirty()) {
            hashMap.put(FIELD_PSDCSEARCHENGINEINSTNAME, this.getPSDCSearchEngineInstName());
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
        if (!bl || this.isPSSearchEngineInstIdDirty()) {
            hashMap.put(FIELD_PSSEARCHENGINEINSTID, this.getPSSearchEngineInstId());
        }
        if (!bl || this.isPSSearchEngineInstNameDirty()) {
            hashMap.put(FIELD_PSSEARCHENGINEINSTNAME, this.getPSSearchEngineInstName());
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
        if (!bl || this.isSearchEngineTypeDirty()) {
            hashMap.put(FIELD_SEARCHENGINETYPE, this.getSearchEngineType());
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
        return PSDCSearchEngineInstBase.get(this, n);
    }

    private static Object get(PSDCSearchEngineInstBase pSDCSearchEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSearchEngineInstBase.getConnStr();
            }
            case 1: {
                return pSDCSearchEngineInstBase.getCreateDate();
            }
            case 2: {
                return pSDCSearchEngineInstBase.getCreateMan();
            }
            case 3: {
                return pSDCSearchEngineInstBase.getExpriedTime();
            }
            case 4: {
                return pSDCSearchEngineInstBase.getIpAddr();
            }
            case 5: {
                return pSDCSearchEngineInstBase.getMemo();
            }
            case 6: {
                return pSDCSearchEngineInstBase.getParam();
            }
            case 7: {
                return pSDCSearchEngineInstBase.getParam2();
            }
            case 8: {
                return pSDCSearchEngineInstBase.getPort();
            }
            case 9: {
                return pSDCSearchEngineInstBase.getPSDCContainerSpecId();
            }
            case 10: {
                return pSDCSearchEngineInstBase.getPSDCContainerSpecName();
            }
            case 11: {
                return pSDCSearchEngineInstBase.getPSDCFileId();
            }
            case 12: {
                return pSDCSearchEngineInstBase.getPSDCFileName();
            }
            case 13: {
                return pSDCSearchEngineInstBase.getPSDCSearchEngineInstId();
            }
            case 14: {
                return pSDCSearchEngineInstBase.getPSDCSearchEngineInstName();
            }
            case 15: {
                return pSDCSearchEngineInstBase.getPSDevCenterId();
            }
            case 16: {
                return pSDCSearchEngineInstBase.getPSDevCenterName();
            }
            case 17: {
                return pSDCSearchEngineInstBase.getPSDevSlnId();
            }
            case 18: {
                return pSDCSearchEngineInstBase.getPSDevSlnName();
            }
            case 19: {
                return pSDCSearchEngineInstBase.getPSSearchEngineInstId();
            }
            case 20: {
                return pSDCSearchEngineInstBase.getPSSearchEngineInstName();
            }
            case 21: {
                return pSDCSearchEngineInstBase.getResPos();
            }
            case 22: {
                return pSDCSearchEngineInstBase.getResReadyTime();
            }
            case 23: {
                return pSDCSearchEngineInstBase.getResState();
            }
            case 24: {
                return pSDCSearchEngineInstBase.getResVer();
            }
            case 25: {
                return pSDCSearchEngineInstBase.getSearchEngineType();
            }
            case 26: {
                return pSDCSearchEngineInstBase.getUpdateDate();
            }
            case 27: {
                return pSDCSearchEngineInstBase.getUpdateMan();
            }
            case 28: {
                return pSDCSearchEngineInstBase.getUsageMode();
            }
            case 29: {
                return pSDCSearchEngineInstBase.getUserName();
            }
            case 30: {
                return pSDCSearchEngineInstBase.getUserTag();
            }
            case 31: {
                return pSDCSearchEngineInstBase.getUserTag2();
            }
            case 32: {
                return pSDCSearchEngineInstBase.getUserTag3();
            }
            case 33: {
                return pSDCSearchEngineInstBase.getUserTag4();
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
        PSDCSearchEngineInstBase.set(this, n, object);
    }

    private static void set(PSDCSearchEngineInstBase pSDCSearchEngineInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSearchEngineInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCSearchEngineInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCSearchEngineInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSearchEngineInstBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCSearchEngineInstBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSearchEngineInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSearchEngineInstBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSearchEngineInstBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSearchEngineInstBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCSearchEngineInstBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSearchEngineInstBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSearchEngineInstBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCSearchEngineInstBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCSearchEngineInstBase.setPSDCSearchEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCSearchEngineInstBase.setPSDCSearchEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCSearchEngineInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCSearchEngineInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCSearchEngineInstBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCSearchEngineInstBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCSearchEngineInstBase.setPSSearchEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCSearchEngineInstBase.setPSSearchEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCSearchEngineInstBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDCSearchEngineInstBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDCSearchEngineInstBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDCSearchEngineInstBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDCSearchEngineInstBase.setSearchEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCSearchEngineInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSDCSearchEngineInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCSearchEngineInstBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCSearchEngineInstBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCSearchEngineInstBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCSearchEngineInstBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCSearchEngineInstBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCSearchEngineInstBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDCSearchEngineInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSearchEngineInstBase pSDCSearchEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSearchEngineInstBase.getConnStr() == null;
            }
            case 1: {
                return pSDCSearchEngineInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCSearchEngineInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCSearchEngineInstBase.getExpriedTime() == null;
            }
            case 4: {
                return pSDCSearchEngineInstBase.getIpAddr() == null;
            }
            case 5: {
                return pSDCSearchEngineInstBase.getMemo() == null;
            }
            case 6: {
                return pSDCSearchEngineInstBase.getParam() == null;
            }
            case 7: {
                return pSDCSearchEngineInstBase.getParam2() == null;
            }
            case 8: {
                return pSDCSearchEngineInstBase.getPort() == null;
            }
            case 9: {
                return pSDCSearchEngineInstBase.getPSDCContainerSpecId() == null;
            }
            case 10: {
                return pSDCSearchEngineInstBase.getPSDCContainerSpecName() == null;
            }
            case 11: {
                return pSDCSearchEngineInstBase.getPSDCFileId() == null;
            }
            case 12: {
                return pSDCSearchEngineInstBase.getPSDCFileName() == null;
            }
            case 13: {
                return pSDCSearchEngineInstBase.getPSDCSearchEngineInstId() == null;
            }
            case 14: {
                return pSDCSearchEngineInstBase.getPSDCSearchEngineInstName() == null;
            }
            case 15: {
                return pSDCSearchEngineInstBase.getPSDevCenterId() == null;
            }
            case 16: {
                return pSDCSearchEngineInstBase.getPSDevCenterName() == null;
            }
            case 17: {
                return pSDCSearchEngineInstBase.getPSDevSlnId() == null;
            }
            case 18: {
                return pSDCSearchEngineInstBase.getPSDevSlnName() == null;
            }
            case 19: {
                return pSDCSearchEngineInstBase.getPSSearchEngineInstId() == null;
            }
            case 20: {
                return pSDCSearchEngineInstBase.getPSSearchEngineInstName() == null;
            }
            case 21: {
                return pSDCSearchEngineInstBase.getResPos() == null;
            }
            case 22: {
                return pSDCSearchEngineInstBase.getResReadyTime() == null;
            }
            case 23: {
                return pSDCSearchEngineInstBase.getResState() == null;
            }
            case 24: {
                return pSDCSearchEngineInstBase.getResVer() == null;
            }
            case 25: {
                return pSDCSearchEngineInstBase.getSearchEngineType() == null;
            }
            case 26: {
                return pSDCSearchEngineInstBase.getUpdateDate() == null;
            }
            case 27: {
                return pSDCSearchEngineInstBase.getUpdateMan() == null;
            }
            case 28: {
                return pSDCSearchEngineInstBase.getUsageMode() == null;
            }
            case 29: {
                return pSDCSearchEngineInstBase.getUserName() == null;
            }
            case 30: {
                return pSDCSearchEngineInstBase.getUserTag() == null;
            }
            case 31: {
                return pSDCSearchEngineInstBase.getUserTag2() == null;
            }
            case 32: {
                return pSDCSearchEngineInstBase.getUserTag3() == null;
            }
            case 33: {
                return pSDCSearchEngineInstBase.getUserTag4() == null;
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
        return PSDCSearchEngineInstBase.contains(this, n);
    }

    private static boolean contains(PSDCSearchEngineInstBase pSDCSearchEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSearchEngineInstBase.isConnStrDirty();
            }
            case 1: {
                return pSDCSearchEngineInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCSearchEngineInstBase.isCreateManDirty();
            }
            case 3: {
                return pSDCSearchEngineInstBase.isExpriedTimeDirty();
            }
            case 4: {
                return pSDCSearchEngineInstBase.isIpAddrDirty();
            }
            case 5: {
                return pSDCSearchEngineInstBase.isMemoDirty();
            }
            case 6: {
                return pSDCSearchEngineInstBase.isParamDirty();
            }
            case 7: {
                return pSDCSearchEngineInstBase.isParam2Dirty();
            }
            case 8: {
                return pSDCSearchEngineInstBase.isPortDirty();
            }
            case 9: {
                return pSDCSearchEngineInstBase.isPSDCContainerSpecIdDirty();
            }
            case 10: {
                return pSDCSearchEngineInstBase.isPSDCContainerSpecNameDirty();
            }
            case 11: {
                return pSDCSearchEngineInstBase.isPSDCFileIdDirty();
            }
            case 12: {
                return pSDCSearchEngineInstBase.isPSDCFileNameDirty();
            }
            case 13: {
                return pSDCSearchEngineInstBase.isPSDCSearchEngineInstIdDirty();
            }
            case 14: {
                return pSDCSearchEngineInstBase.isPSDCSearchEngineInstNameDirty();
            }
            case 15: {
                return pSDCSearchEngineInstBase.isPSDevCenterIdDirty();
            }
            case 16: {
                return pSDCSearchEngineInstBase.isPSDevCenterNameDirty();
            }
            case 17: {
                return pSDCSearchEngineInstBase.isPSDevSlnIdDirty();
            }
            case 18: {
                return pSDCSearchEngineInstBase.isPSDevSlnNameDirty();
            }
            case 19: {
                return pSDCSearchEngineInstBase.isPSSearchEngineInstIdDirty();
            }
            case 20: {
                return pSDCSearchEngineInstBase.isPSSearchEngineInstNameDirty();
            }
            case 21: {
                return pSDCSearchEngineInstBase.isResPosDirty();
            }
            case 22: {
                return pSDCSearchEngineInstBase.isResReadyTimeDirty();
            }
            case 23: {
                return pSDCSearchEngineInstBase.isResStateDirty();
            }
            case 24: {
                return pSDCSearchEngineInstBase.isResVerDirty();
            }
            case 25: {
                return pSDCSearchEngineInstBase.isSearchEngineTypeDirty();
            }
            case 26: {
                return pSDCSearchEngineInstBase.isUpdateDateDirty();
            }
            case 27: {
                return pSDCSearchEngineInstBase.isUpdateManDirty();
            }
            case 28: {
                return pSDCSearchEngineInstBase.isUsageModeDirty();
            }
            case 29: {
                return pSDCSearchEngineInstBase.isUserNameDirty();
            }
            case 30: {
                return pSDCSearchEngineInstBase.isUserTagDirty();
            }
            case 31: {
                return pSDCSearchEngineInstBase.isUserTag2Dirty();
            }
            case 32: {
                return pSDCSearchEngineInstBase.isUserTag3Dirty();
            }
            case 33: {
                return pSDCSearchEngineInstBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSearchEngineInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSearchEngineInstBase pSDCSearchEngineInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSearchEngineInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getParam()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getParam2()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPort()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCSearchEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsearchengineinstid", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDCSearchEngineInstId()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCSearchEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsearchengineinstname", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDCSearchEngineInstName()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSSearchEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssearchengineinstid", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSSearchEngineInstId()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getPSSearchEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssearchengineinstname", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getPSSearchEngineInstName()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getResState()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getResVer()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getSearchEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchenginetype", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getSearchEngineType()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCSearchEngineInstBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCSearchEngineInstBase.getJSONValue((Object)pSDCSearchEngineInstBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSearchEngineInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSearchEngineInstBase pSDCSearchEngineInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSearchEngineInstBase.getConnStr() != null) {
            object = pSDCSearchEngineInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getCreateDate() != null) {
            object = pSDCSearchEngineInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSearchEngineInstBase.getCreateMan() != null) {
            object = pSDCSearchEngineInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getExpriedTime() != null) {
            object = pSDCSearchEngineInstBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSearchEngineInstBase.getIpAddr() != null) {
            object = pSDCSearchEngineInstBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getMemo() != null) {
            object = pSDCSearchEngineInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getParam() != null) {
            object = pSDCSearchEngineInstBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getParam2() != null) {
            object = pSDCSearchEngineInstBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPort() != null) {
            object = pSDCSearchEngineInstBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCContainerSpecId() != null) {
            object = pSDCSearchEngineInstBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCContainerSpecName() != null) {
            object = pSDCSearchEngineInstBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCFileId() != null) {
            object = pSDCSearchEngineInstBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCFileName() != null) {
            object = pSDCSearchEngineInstBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCSearchEngineInstId() != null) {
            object = pSDCSearchEngineInstBase.getPSDCSearchEngineInstId();
            xmlNode.setAttribute(FIELD_PSDCSEARCHENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDCSearchEngineInstName() != null) {
            object = pSDCSearchEngineInstBase.getPSDCSearchEngineInstName();
            xmlNode.setAttribute(FIELD_PSDCSEARCHENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDevCenterId() != null) {
            object = pSDCSearchEngineInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDevCenterName() != null) {
            object = pSDCSearchEngineInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDevSlnId() != null) {
            object = pSDCSearchEngineInstBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSDevSlnName() != null) {
            object = pSDCSearchEngineInstBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSSearchEngineInstId() != null) {
            object = pSDCSearchEngineInstBase.getPSSearchEngineInstId();
            xmlNode.setAttribute(FIELD_PSSEARCHENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getPSSearchEngineInstName() != null) {
            object = pSDCSearchEngineInstBase.getPSSearchEngineInstName();
            xmlNode.setAttribute(FIELD_PSSEARCHENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getResPos() != null) {
            object = pSDCSearchEngineInstBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSearchEngineInstBase.getResReadyTime() != null) {
            object = pSDCSearchEngineInstBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSearchEngineInstBase.getResState() != null) {
            object = pSDCSearchEngineInstBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSearchEngineInstBase.getResVer() != null) {
            object = pSDCSearchEngineInstBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCSearchEngineInstBase.getSearchEngineType() != null) {
            object = pSDCSearchEngineInstBase.getSearchEngineType();
            xmlNode.setAttribute(FIELD_SEARCHENGINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getUpdateDate() != null) {
            object = pSDCSearchEngineInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSearchEngineInstBase.getUpdateMan() != null) {
            object = pSDCSearchEngineInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getUsageMode() != null) {
            object = pSDCSearchEngineInstBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getUserName() != null) {
            object = pSDCSearchEngineInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getUserTag() != null) {
            object = pSDCSearchEngineInstBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getUserTag2() != null) {
            object = pSDCSearchEngineInstBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getUserTag3() != null) {
            object = pSDCSearchEngineInstBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCSearchEngineInstBase.getUserTag4() != null) {
            object = pSDCSearchEngineInstBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSearchEngineInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSearchEngineInstBase pSDCSearchEngineInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSearchEngineInstBase.isConnStrDirty() && (bl || pSDCSearchEngineInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDCSearchEngineInstBase.getConnStr());
        }
        if (pSDCSearchEngineInstBase.isCreateDateDirty() && (bl || pSDCSearchEngineInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSearchEngineInstBase.getCreateDate());
        }
        if (pSDCSearchEngineInstBase.isCreateManDirty() && (bl || pSDCSearchEngineInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSearchEngineInstBase.getCreateMan());
        }
        if (pSDCSearchEngineInstBase.isExpriedTimeDirty() && (bl || pSDCSearchEngineInstBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCSearchEngineInstBase.getExpriedTime());
        }
        if (pSDCSearchEngineInstBase.isIpAddrDirty() && (bl || pSDCSearchEngineInstBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCSearchEngineInstBase.getIpAddr());
        }
        if (pSDCSearchEngineInstBase.isMemoDirty() && (bl || pSDCSearchEngineInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSearchEngineInstBase.getMemo());
        }
        if (pSDCSearchEngineInstBase.isParamDirty() && (bl || pSDCSearchEngineInstBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDCSearchEngineInstBase.getParam());
        }
        if (pSDCSearchEngineInstBase.isParam2Dirty() && (bl || pSDCSearchEngineInstBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDCSearchEngineInstBase.getParam2());
        }
        if (pSDCSearchEngineInstBase.isPortDirty() && (bl || pSDCSearchEngineInstBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCSearchEngineInstBase.getPort());
        }
        if (pSDCSearchEngineInstBase.isPSDCContainerSpecIdDirty() && (bl || pSDCSearchEngineInstBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDCSearchEngineInstBase.getPSDCContainerSpecId());
        }
        if (pSDCSearchEngineInstBase.isPSDCContainerSpecNameDirty() && (bl || pSDCSearchEngineInstBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDCSearchEngineInstBase.getPSDCContainerSpecName());
        }
        if (pSDCSearchEngineInstBase.isPSDCFileIdDirty() && (bl || pSDCSearchEngineInstBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDCSearchEngineInstBase.getPSDCFileId());
        }
        if (pSDCSearchEngineInstBase.isPSDCFileNameDirty() && (bl || pSDCSearchEngineInstBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDCSearchEngineInstBase.getPSDCFileName());
        }
        if (pSDCSearchEngineInstBase.isPSDCSearchEngineInstIdDirty() && (bl || pSDCSearchEngineInstBase.getPSDCSearchEngineInstId() != null)) {
            iDataObject.set(FIELD_PSDCSEARCHENGINEINSTID, (Object)pSDCSearchEngineInstBase.getPSDCSearchEngineInstId());
        }
        if (pSDCSearchEngineInstBase.isPSDCSearchEngineInstNameDirty() && (bl || pSDCSearchEngineInstBase.getPSDCSearchEngineInstName() != null)) {
            iDataObject.set(FIELD_PSDCSEARCHENGINEINSTNAME, (Object)pSDCSearchEngineInstBase.getPSDCSearchEngineInstName());
        }
        if (pSDCSearchEngineInstBase.isPSDevCenterIdDirty() && (bl || pSDCSearchEngineInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSearchEngineInstBase.getPSDevCenterId());
        }
        if (pSDCSearchEngineInstBase.isPSDevCenterNameDirty() && (bl || pSDCSearchEngineInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSearchEngineInstBase.getPSDevCenterName());
        }
        if (pSDCSearchEngineInstBase.isPSDevSlnIdDirty() && (bl || pSDCSearchEngineInstBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCSearchEngineInstBase.getPSDevSlnId());
        }
        if (pSDCSearchEngineInstBase.isPSDevSlnNameDirty() && (bl || pSDCSearchEngineInstBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCSearchEngineInstBase.getPSDevSlnName());
        }
        if (pSDCSearchEngineInstBase.isPSSearchEngineInstIdDirty() && (bl || pSDCSearchEngineInstBase.getPSSearchEngineInstId() != null)) {
            iDataObject.set(FIELD_PSSEARCHENGINEINSTID, (Object)pSDCSearchEngineInstBase.getPSSearchEngineInstId());
        }
        if (pSDCSearchEngineInstBase.isPSSearchEngineInstNameDirty() && (bl || pSDCSearchEngineInstBase.getPSSearchEngineInstName() != null)) {
            iDataObject.set(FIELD_PSSEARCHENGINEINSTNAME, (Object)pSDCSearchEngineInstBase.getPSSearchEngineInstName());
        }
        if (pSDCSearchEngineInstBase.isResPosDirty() && (bl || pSDCSearchEngineInstBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCSearchEngineInstBase.getResPos());
        }
        if (pSDCSearchEngineInstBase.isResReadyTimeDirty() && (bl || pSDCSearchEngineInstBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCSearchEngineInstBase.getResReadyTime());
        }
        if (pSDCSearchEngineInstBase.isResStateDirty() && (bl || pSDCSearchEngineInstBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCSearchEngineInstBase.getResState());
        }
        if (pSDCSearchEngineInstBase.isResVerDirty() && (bl || pSDCSearchEngineInstBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDCSearchEngineInstBase.getResVer());
        }
        if (pSDCSearchEngineInstBase.isSearchEngineTypeDirty() && (bl || pSDCSearchEngineInstBase.getSearchEngineType() != null)) {
            iDataObject.set(FIELD_SEARCHENGINETYPE, (Object)pSDCSearchEngineInstBase.getSearchEngineType());
        }
        if (pSDCSearchEngineInstBase.isUpdateDateDirty() && (bl || pSDCSearchEngineInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSearchEngineInstBase.getUpdateDate());
        }
        if (pSDCSearchEngineInstBase.isUpdateManDirty() && (bl || pSDCSearchEngineInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSearchEngineInstBase.getUpdateMan());
        }
        if (pSDCSearchEngineInstBase.isUsageModeDirty() && (bl || pSDCSearchEngineInstBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSDCSearchEngineInstBase.getUsageMode());
        }
        if (pSDCSearchEngineInstBase.isUserNameDirty() && (bl || pSDCSearchEngineInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCSearchEngineInstBase.getUserName());
        }
        if (pSDCSearchEngineInstBase.isUserTagDirty() && (bl || pSDCSearchEngineInstBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCSearchEngineInstBase.getUserTag());
        }
        if (pSDCSearchEngineInstBase.isUserTag2Dirty() && (bl || pSDCSearchEngineInstBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCSearchEngineInstBase.getUserTag2());
        }
        if (pSDCSearchEngineInstBase.isUserTag3Dirty() && (bl || pSDCSearchEngineInstBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCSearchEngineInstBase.getUserTag3());
        }
        if (pSDCSearchEngineInstBase.isUserTag4Dirty() && (bl || pSDCSearchEngineInstBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCSearchEngineInstBase.getUserTag4());
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
        return PSDCSearchEngineInstBase.remove(this, n);
    }

    private static boolean remove(PSDCSearchEngineInstBase pSDCSearchEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSearchEngineInstBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDCSearchEngineInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCSearchEngineInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCSearchEngineInstBase.resetExpriedTime();
                return true;
            }
            case 4: {
                pSDCSearchEngineInstBase.resetIpAddr();
                return true;
            }
            case 5: {
                pSDCSearchEngineInstBase.resetMemo();
                return true;
            }
            case 6: {
                pSDCSearchEngineInstBase.resetParam();
                return true;
            }
            case 7: {
                pSDCSearchEngineInstBase.resetParam2();
                return true;
            }
            case 8: {
                pSDCSearchEngineInstBase.resetPort();
                return true;
            }
            case 9: {
                pSDCSearchEngineInstBase.resetPSDCContainerSpecId();
                return true;
            }
            case 10: {
                pSDCSearchEngineInstBase.resetPSDCContainerSpecName();
                return true;
            }
            case 11: {
                pSDCSearchEngineInstBase.resetPSDCFileId();
                return true;
            }
            case 12: {
                pSDCSearchEngineInstBase.resetPSDCFileName();
                return true;
            }
            case 13: {
                pSDCSearchEngineInstBase.resetPSDCSearchEngineInstId();
                return true;
            }
            case 14: {
                pSDCSearchEngineInstBase.resetPSDCSearchEngineInstName();
                return true;
            }
            case 15: {
                pSDCSearchEngineInstBase.resetPSDevCenterId();
                return true;
            }
            case 16: {
                pSDCSearchEngineInstBase.resetPSDevCenterName();
                return true;
            }
            case 17: {
                pSDCSearchEngineInstBase.resetPSDevSlnId();
                return true;
            }
            case 18: {
                pSDCSearchEngineInstBase.resetPSDevSlnName();
                return true;
            }
            case 19: {
                pSDCSearchEngineInstBase.resetPSSearchEngineInstId();
                return true;
            }
            case 20: {
                pSDCSearchEngineInstBase.resetPSSearchEngineInstName();
                return true;
            }
            case 21: {
                pSDCSearchEngineInstBase.resetResPos();
                return true;
            }
            case 22: {
                pSDCSearchEngineInstBase.resetResReadyTime();
                return true;
            }
            case 23: {
                pSDCSearchEngineInstBase.resetResState();
                return true;
            }
            case 24: {
                pSDCSearchEngineInstBase.resetResVer();
                return true;
            }
            case 25: {
                pSDCSearchEngineInstBase.resetSearchEngineType();
                return true;
            }
            case 26: {
                pSDCSearchEngineInstBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSDCSearchEngineInstBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSDCSearchEngineInstBase.resetUsageMode();
                return true;
            }
            case 29: {
                pSDCSearchEngineInstBase.resetUserName();
                return true;
            }
            case 30: {
                pSDCSearchEngineInstBase.resetUserTag();
                return true;
            }
            case 31: {
                pSDCSearchEngineInstBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSDCSearchEngineInstBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSDCSearchEngineInstBase.resetUserTag4();
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
                pSDCContainerSpecService.autoGet(pSDCContainerSpec);
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
                pSDCFileService.autoGet(pSDCFile);
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
                pSDevCenterService.autoGet(pSDevCenter);
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
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSearchEngineInst getPSSearchEngineInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSearchEngineInst();
        }
        if (this.getPSSearchEngineInstId() == null) {
            return null;
        }
        Integer n = this.objPSSearchEngineInstLock;
        synchronized (n) {
            if (this.pssearchengineinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSearchEngineInstId(), (Object)this.pssearchengineinst.getPSSearchEngineInstId()) != 0L) {
                this.pssearchengineinst = null;
            }
            if (this.pssearchengineinst == null) {
                PSSearchEngineInst pSSearchEngineInst = new PSSearchEngineInst();
                pSSearchEngineInst.setPSSearchEngineInstId(this.getPSSearchEngineInstId());
                PSSearchEngineInstService pSSearchEngineInstService = (PSSearchEngineInstService)ServiceGlobal.getService(PSSearchEngineInstService.class, (SessionFactory)this.getSessionFactory());
                pSSearchEngineInstService.autoGet(pSSearchEngineInst);
                this.pssearchengineinst = pSSearchEngineInst;
            }
            return this.pssearchengineinst;
        }
    }

    private PSDCSearchEngineInstBase getProxyEntity() {
        return this.proxyPSDCSearchEngineInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSearchEngineInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSearchEngineInstBase) {
            this.proxyPSDCSearchEngineInstBase = (PSDCSearchEngineInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDCSEARCHENGINEINSTID, 13);
        fieldIndexMap.put(FIELD_PSDCSEARCHENGINEINSTNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 18);
        fieldIndexMap.put(FIELD_PSSEARCHENGINEINSTID, 19);
        fieldIndexMap.put(FIELD_PSSEARCHENGINEINSTNAME, 20);
        fieldIndexMap.put(FIELD_RESPOS, 21);
        fieldIndexMap.put(FIELD_RESREADYTIME, 22);
        fieldIndexMap.put(FIELD_RESSTATE, 23);
        fieldIndexMap.put(FIELD_RESVER, 24);
        fieldIndexMap.put(FIELD_SEARCHENGINETYPE, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USAGEMODE, 28);
        fieldIndexMap.put(FIELD_USERNAME, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
    }
}

