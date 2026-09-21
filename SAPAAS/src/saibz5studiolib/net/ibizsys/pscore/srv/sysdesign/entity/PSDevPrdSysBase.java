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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSysBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdSysBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVPRDSYSINFO = "DEVPRDSYSINFO";
    public static final String FIELD_DEVPRDSYSTYPE = "DEVPRDSYSTYPE";
    public static final String FIELD_DEVPRDSYSSTATE = "DEVSYSSTATE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVPRDID = "PSDEVPRDID";
    public static final String FIELD_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String FIELD_PSDEVPRDSUBVERID = "PSDEVPRDSUBVERID";
    public static final String FIELD_PSDEVPRDSUBVERNAME = "PSDEVPRDSUBVERNAME";
    public static final String FIELD_PSDEVPRDSYSID = "PSDEVPRDSYSID";
    public static final String FIELD_PSDEVPRDSYSNAME = "PSDEVPRDSYSNAME";
    public static final String FIELD_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String FIELD_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_SRCPSDEVPRDSYSID = "SRCPSDEVPRDSYSID";
    public static final String FIELD_SRCPSDEVPRDSYSNAME = "SRCPSDEVPRDSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEVPRDSYSINFO = 2;
    private static final int INDEX_DEVPRDSYSTYPE = 3;
    private static final int INDEX_DEVPRDSYSSTATE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEVPRDID = 6;
    private static final int INDEX_PSDEVPRDNAME = 7;
    private static final int INDEX_PSDEVPRDSUBVERID = 8;
    private static final int INDEX_PSDEVPRDSUBVERNAME = 9;
    private static final int INDEX_PSDEVPRDSYSID = 10;
    private static final int INDEX_PSDEVPRDSYSNAME = 11;
    private static final int INDEX_PSDEVPRDVERID = 12;
    private static final int INDEX_PSDEVPRDVERNAME = 13;
    private static final int INDEX_PSDEVSLNSYSID = 14;
    private static final int INDEX_PSDEVSLNSYSNAME = 15;
    private static final int INDEX_SRCPSDEVPRDSYSID = 16;
    private static final int INDEX_SRCPSDEVPRDSYSNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdSysBase proxyPSDevPrdSysBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean devprdsysinfoDirtyFlag = false;
    private boolean devprdsystypeDirtyFlag = false;
    private boolean devprdsysstateDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevprdidDirtyFlag = false;
    private boolean psdevprdnameDirtyFlag = false;
    private boolean psdevprdsubveridDirtyFlag = false;
    private boolean psdevprdsubvernameDirtyFlag = false;
    private boolean psdevprdsysidDirtyFlag = false;
    private boolean psdevprdsysnameDirtyFlag = false;
    private boolean psdevprdveridDirtyFlag = false;
    private boolean psdevprdvernameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean srcpsdevprdsysidDirtyFlag = false;
    private boolean srcpsdevprdsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="devprdsysinfo")
    private String devprdsysinfo;
    @Column(name="devprdsystype")
    private String devprdsystype;
    @Column(name="devprdsysstate")
    private Integer devprdsysstate;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevprdid")
    private String psdevprdid;
    @Column(name="psdevprdname")
    private String psdevprdname;
    @Column(name="psdevprdsubverid")
    private String psdevprdsubverid;
    @Column(name="psdevprdsubvername")
    private String psdevprdsubvername;
    @Column(name="psdevprdsysid")
    private String psdevprdsysid;
    @Column(name="psdevprdsysname")
    private String psdevprdsysname;
    @Column(name="psdevprdverid")
    private String psdevprdverid;
    @Column(name="psdevprdvername")
    private String psdevprdvername;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="srcpsdevprdsysid")
    private String srcpsdevprdsysid;
    @Column(name="srcpsdevprdsysname")
    private String srcpsdevprdsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevPrdSubVerLock = new Integer(1);
    private PSDevPrdSubVer psdevprdsubver = null;
    private Integer objSrcPSDevPrdSysLock = new Integer(1);
    private PSDevPrdSys srcpsdevprdsys = null;
    private Integer objPSDevPrdVerLock = new Integer(1);
    private PSDevPrdVer psdevprdver = null;
    private Integer objPSDevPrdLock = new Integer(1);
    private PSDevPrd psdevprd = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

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

    public void setDevPrdSysInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevPrdSysInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.devprdsysinfo = string;
        this.devprdsysinfoDirtyFlag = true;
    }

    public String getDevPrdSysInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevPrdSysInfo();
        }
        return this.devprdsysinfo;
    }

    public boolean isDevPrdSysInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevPrdSysInfoDirty();
        }
        return this.devprdsysinfoDirtyFlag;
    }

    public void resetDevPrdSysInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevPrdSysInfo();
            return;
        }
        this.devprdsysinfoDirtyFlag = false;
        this.devprdsysinfo = null;
    }

    public void setDevPrdSysType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevPrdSysType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.devprdsystype = string;
        this.devprdsystypeDirtyFlag = true;
    }

    public String getDevPrdSysType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevPrdSysType();
        }
        return this.devprdsystype;
    }

    public boolean isDevPrdSysTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevPrdSysTypeDirty();
        }
        return this.devprdsystypeDirtyFlag;
    }

    public void resetDevPrdSysType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevPrdSysType();
            return;
        }
        this.devprdsystypeDirtyFlag = false;
        this.devprdsystype = null;
    }

    public void setDevPrdSysState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevPrdSysState(n);
            return;
        }
        this.devprdsysstate = n;
        this.devprdsysstateDirtyFlag = true;
    }

    public Integer getDevPrdSysState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevPrdSysState();
        }
        return this.devprdsysstate;
    }

    public boolean isDevPrdSysStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevPrdSysStateDirty();
        }
        return this.devprdsysstateDirtyFlag;
    }

    public void resetDevPrdSysState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevPrdSysState();
            return;
        }
        this.devprdsysstateDirtyFlag = false;
        this.devprdsysstate = null;
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

    public void setPSDevPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdid = string;
        this.psdevprdidDirtyFlag = true;
    }

    public String getPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdId();
        }
        return this.psdevprdid;
    }

    public boolean isPSDevPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIdDirty();
        }
        return this.psdevprdidDirtyFlag;
    }

    public void resetPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdId();
            return;
        }
        this.psdevprdidDirtyFlag = false;
        this.psdevprdid = null;
    }

    public void setPSDevPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdname = string;
        this.psdevprdnameDirtyFlag = true;
    }

    public String getPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdName();
        }
        return this.psdevprdname;
    }

    public boolean isPSDevPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdNameDirty();
        }
        return this.psdevprdnameDirtyFlag;
    }

    public void resetPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdName();
            return;
        }
        this.psdevprdnameDirtyFlag = false;
        this.psdevprdname = null;
    }

    public void setPSDevPrdSubVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSubVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsubverid = string;
        this.psdevprdsubveridDirtyFlag = true;
    }

    public String getPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVerId();
        }
        return this.psdevprdsubverid;
    }

    public boolean isPSDevPrdSubVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSubVerIdDirty();
        }
        return this.psdevprdsubveridDirtyFlag;
    }

    public void resetPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSubVerId();
            return;
        }
        this.psdevprdsubveridDirtyFlag = false;
        this.psdevprdsubverid = null;
    }

    public void setPSDevPrdSubVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSubVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsubvername = string;
        this.psdevprdsubvernameDirtyFlag = true;
    }

    public String getPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVerName();
        }
        return this.psdevprdsubvername;
    }

    public boolean isPSDevPrdSubVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSubVerNameDirty();
        }
        return this.psdevprdsubvernameDirtyFlag;
    }

    public void resetPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSubVerName();
            return;
        }
        this.psdevprdsubvernameDirtyFlag = false;
        this.psdevprdsubvername = null;
    }

    public void setPSDevPrdSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsysid = string;
        this.psdevprdsysidDirtyFlag = true;
    }

    public String getPSDevPrdSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysId();
        }
        return this.psdevprdsysid;
    }

    public boolean isPSDevPrdSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSysIdDirty();
        }
        return this.psdevprdsysidDirtyFlag;
    }

    public void resetPSDevPrdSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSysId();
            return;
        }
        this.psdevprdsysidDirtyFlag = false;
        this.psdevprdsysid = null;
    }

    public void setPSDevPrdSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsysname = string;
        this.psdevprdsysnameDirtyFlag = true;
    }

    public String getPSDevPrdSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysName();
        }
        return this.psdevprdsysname;
    }

    public boolean isPSDevPrdSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSysNameDirty();
        }
        return this.psdevprdsysnameDirtyFlag;
    }

    public void resetPSDevPrdSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSysName();
            return;
        }
        this.psdevprdsysnameDirtyFlag = false;
        this.psdevprdsysname = null;
    }

    public void setPSDevPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdverid = string;
        this.psdevprdveridDirtyFlag = true;
    }

    public String getPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerId();
        }
        return this.psdevprdverid;
    }

    public boolean isPSDevPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerIdDirty();
        }
        return this.psdevprdveridDirtyFlag;
    }

    public void resetPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerId();
            return;
        }
        this.psdevprdveridDirtyFlag = false;
        this.psdevprdverid = null;
    }

    public void setPSDevPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdvername = string;
        this.psdevprdvernameDirtyFlag = true;
    }

    public String getPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerName();
        }
        return this.psdevprdvername;
    }

    public boolean isPSDevPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerNameDirty();
        }
        return this.psdevprdvernameDirtyFlag;
    }

    public void resetPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerName();
            return;
        }
        this.psdevprdvernameDirtyFlag = false;
        this.psdevprdvername = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setSrcPSDevPrdSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDevPrdSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdevprdsysid = string;
        this.srcpsdevprdsysidDirtyFlag = true;
    }

    public String getSrcPSDevPrdSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevPrdSysId();
        }
        return this.srcpsdevprdsysid;
    }

    public boolean isSrcPSDevPrdSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDevPrdSysIdDirty();
        }
        return this.srcpsdevprdsysidDirtyFlag;
    }

    public void resetSrcPSDevPrdSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDevPrdSysId();
            return;
        }
        this.srcpsdevprdsysidDirtyFlag = false;
        this.srcpsdevprdsysid = null;
    }

    public void setSrcPSDevPrdSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDevPrdSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdevprdsysname = string;
        this.srcpsdevprdsysnameDirtyFlag = true;
    }

    public String getSrcPSDevPrdSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevPrdSysName();
        }
        return this.srcpsdevprdsysname;
    }

    public boolean isSrcPSDevPrdSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDevPrdSysNameDirty();
        }
        return this.srcpsdevprdsysnameDirtyFlag;
    }

    public void resetSrcPSDevPrdSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDevPrdSysName();
            return;
        }
        this.srcpsdevprdsysnameDirtyFlag = false;
        this.srcpsdevprdsysname = null;
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
        PSDevPrdSysBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdSysBase pSDevPrdSysBase) {
        pSDevPrdSysBase.resetCreateDate();
        pSDevPrdSysBase.resetCreateMan();
        pSDevPrdSysBase.resetDevPrdSysInfo();
        pSDevPrdSysBase.resetDevPrdSysType();
        pSDevPrdSysBase.resetDevPrdSysState();
        pSDevPrdSysBase.resetMemo();
        pSDevPrdSysBase.resetPSDevPrdId();
        pSDevPrdSysBase.resetPSDevPrdName();
        pSDevPrdSysBase.resetPSDevPrdSubVerId();
        pSDevPrdSysBase.resetPSDevPrdSubVerName();
        pSDevPrdSysBase.resetPSDevPrdSysId();
        pSDevPrdSysBase.resetPSDevPrdSysName();
        pSDevPrdSysBase.resetPSDevPrdVerId();
        pSDevPrdSysBase.resetPSDevPrdVerName();
        pSDevPrdSysBase.resetPSDevSlnSysId();
        pSDevPrdSysBase.resetPSDevSlnSysName();
        pSDevPrdSysBase.resetSrcPSDevPrdSysId();
        pSDevPrdSysBase.resetSrcPSDevPrdSysName();
        pSDevPrdSysBase.resetUpdateDate();
        pSDevPrdSysBase.resetUpdateMan();
        pSDevPrdSysBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDevPrdSysInfoDirty()) {
            hashMap.put(FIELD_DEVPRDSYSINFO, this.getDevPrdSysInfo());
        }
        if (!bl || this.isDevPrdSysTypeDirty()) {
            hashMap.put(FIELD_DEVPRDSYSTYPE, this.getDevPrdSysType());
        }
        if (!bl || this.isDevPrdSysStateDirty()) {
            hashMap.put(FIELD_DEVPRDSYSSTATE, this.getDevPrdSysState());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevPrdIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDID, this.getPSDevPrdId());
        }
        if (!bl || this.isPSDevPrdNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDNAME, this.getPSDevPrdName());
        }
        if (!bl || this.isPSDevPrdSubVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSUBVERID, this.getPSDevPrdSubVerId());
        }
        if (!bl || this.isPSDevPrdSubVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSUBVERNAME, this.getPSDevPrdSubVerName());
        }
        if (!bl || this.isPSDevPrdSysIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSYSID, this.getPSDevPrdSysId());
        }
        if (!bl || this.isPSDevPrdSysNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSYSNAME, this.getPSDevPrdSysName());
        }
        if (!bl || this.isPSDevPrdVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERID, this.getPSDevPrdVerId());
        }
        if (!bl || this.isPSDevPrdVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERNAME, this.getPSDevPrdVerName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isSrcPSDevPrdSysIdDirty()) {
            hashMap.put(FIELD_SRCPSDEVPRDSYSID, this.getSrcPSDevPrdSysId());
        }
        if (!bl || this.isSrcPSDevPrdSysNameDirty()) {
            hashMap.put(FIELD_SRCPSDEVPRDSYSNAME, this.getSrcPSDevPrdSysName());
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
        return PSDevPrdSysBase.get(this, n);
    }

    private static Object get(PSDevPrdSysBase pSDevPrdSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysBase.getCreateDate();
            }
            case 1: {
                return pSDevPrdSysBase.getCreateMan();
            }
            case 2: {
                return pSDevPrdSysBase.getDevPrdSysInfo();
            }
            case 3: {
                return pSDevPrdSysBase.getDevPrdSysType();
            }
            case 4: {
                return pSDevPrdSysBase.getDevPrdSysState();
            }
            case 5: {
                return pSDevPrdSysBase.getMemo();
            }
            case 6: {
                return pSDevPrdSysBase.getPSDevPrdId();
            }
            case 7: {
                return pSDevPrdSysBase.getPSDevPrdName();
            }
            case 8: {
                return pSDevPrdSysBase.getPSDevPrdSubVerId();
            }
            case 9: {
                return pSDevPrdSysBase.getPSDevPrdSubVerName();
            }
            case 10: {
                return pSDevPrdSysBase.getPSDevPrdSysId();
            }
            case 11: {
                return pSDevPrdSysBase.getPSDevPrdSysName();
            }
            case 12: {
                return pSDevPrdSysBase.getPSDevPrdVerId();
            }
            case 13: {
                return pSDevPrdSysBase.getPSDevPrdVerName();
            }
            case 14: {
                return pSDevPrdSysBase.getPSDevSlnSysId();
            }
            case 15: {
                return pSDevPrdSysBase.getPSDevSlnSysName();
            }
            case 16: {
                return pSDevPrdSysBase.getSrcPSDevPrdSysId();
            }
            case 17: {
                return pSDevPrdSysBase.getSrcPSDevPrdSysName();
            }
            case 18: {
                return pSDevPrdSysBase.getUpdateDate();
            }
            case 19: {
                return pSDevPrdSysBase.getUpdateMan();
            }
            case 20: {
                return pSDevPrdSysBase.getValidFlag();
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
        PSDevPrdSysBase.set(this, n, object);
    }

    private static void set(PSDevPrdSysBase pSDevPrdSysBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSysBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdSysBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdSysBase.setDevPrdSysInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdSysBase.setDevPrdSysType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdSysBase.setDevPrdSysState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdSysBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdSysBase.setPSDevPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdSysBase.setPSDevPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdSysBase.setPSDevPrdSubVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdSysBase.setPSDevPrdSubVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdSysBase.setPSDevPrdSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdSysBase.setPSDevPrdSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdSysBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdSysBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevPrdSysBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevPrdSysBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevPrdSysBase.setSrcPSDevPrdSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevPrdSysBase.setSrcPSDevPrdSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevPrdSysBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDevPrdSysBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevPrdSysBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevPrdSysBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdSysBase pSDevPrdSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevPrdSysBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevPrdSysBase.getDevPrdSysInfo() == null;
            }
            case 3: {
                return pSDevPrdSysBase.getDevPrdSysType() == null;
            }
            case 4: {
                return pSDevPrdSysBase.getDevPrdSysState() == null;
            }
            case 5: {
                return pSDevPrdSysBase.getMemo() == null;
            }
            case 6: {
                return pSDevPrdSysBase.getPSDevPrdId() == null;
            }
            case 7: {
                return pSDevPrdSysBase.getPSDevPrdName() == null;
            }
            case 8: {
                return pSDevPrdSysBase.getPSDevPrdSubVerId() == null;
            }
            case 9: {
                return pSDevPrdSysBase.getPSDevPrdSubVerName() == null;
            }
            case 10: {
                return pSDevPrdSysBase.getPSDevPrdSysId() == null;
            }
            case 11: {
                return pSDevPrdSysBase.getPSDevPrdSysName() == null;
            }
            case 12: {
                return pSDevPrdSysBase.getPSDevPrdVerId() == null;
            }
            case 13: {
                return pSDevPrdSysBase.getPSDevPrdVerName() == null;
            }
            case 14: {
                return pSDevPrdSysBase.getPSDevSlnSysId() == null;
            }
            case 15: {
                return pSDevPrdSysBase.getPSDevSlnSysName() == null;
            }
            case 16: {
                return pSDevPrdSysBase.getSrcPSDevPrdSysId() == null;
            }
            case 17: {
                return pSDevPrdSysBase.getSrcPSDevPrdSysName() == null;
            }
            case 18: {
                return pSDevPrdSysBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDevPrdSysBase.getUpdateMan() == null;
            }
            case 20: {
                return pSDevPrdSysBase.getValidFlag() == null;
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
        return PSDevPrdSysBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdSysBase pSDevPrdSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevPrdSysBase.isCreateManDirty();
            }
            case 2: {
                return pSDevPrdSysBase.isDevPrdSysInfoDirty();
            }
            case 3: {
                return pSDevPrdSysBase.isDevPrdSysTypeDirty();
            }
            case 4: {
                return pSDevPrdSysBase.isDevPrdSysStateDirty();
            }
            case 5: {
                return pSDevPrdSysBase.isMemoDirty();
            }
            case 6: {
                return pSDevPrdSysBase.isPSDevPrdIdDirty();
            }
            case 7: {
                return pSDevPrdSysBase.isPSDevPrdNameDirty();
            }
            case 8: {
                return pSDevPrdSysBase.isPSDevPrdSubVerIdDirty();
            }
            case 9: {
                return pSDevPrdSysBase.isPSDevPrdSubVerNameDirty();
            }
            case 10: {
                return pSDevPrdSysBase.isPSDevPrdSysIdDirty();
            }
            case 11: {
                return pSDevPrdSysBase.isPSDevPrdSysNameDirty();
            }
            case 12: {
                return pSDevPrdSysBase.isPSDevPrdVerIdDirty();
            }
            case 13: {
                return pSDevPrdSysBase.isPSDevPrdVerNameDirty();
            }
            case 14: {
                return pSDevPrdSysBase.isPSDevSlnSysIdDirty();
            }
            case 15: {
                return pSDevPrdSysBase.isPSDevSlnSysNameDirty();
            }
            case 16: {
                return pSDevPrdSysBase.isSrcPSDevPrdSysIdDirty();
            }
            case 17: {
                return pSDevPrdSysBase.isSrcPSDevPrdSysNameDirty();
            }
            case 18: {
                return pSDevPrdSysBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDevPrdSysBase.isUpdateManDirty();
            }
            case 20: {
                return pSDevPrdSysBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdSysBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdSysBase pSDevPrdSysBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdSysBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getDevPrdSysInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devprdsysinfo", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getDevPrdSysInfo()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getDevPrdSysType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devprdsystype", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getDevPrdSysType()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getDevPrdSysState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devsysstate", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getDevPrdSysState()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdid", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevPrdId()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdname", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevPrdName()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdSubVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubverid", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevPrdSubVerId()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdSubVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubvername", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevPrdSubVerName()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsysid", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevPrdSysId()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsysname", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevPrdSysName()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getSrcPSDevPrdSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdevprdsysid", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getSrcPSDevPrdSysId()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getSrcPSDevPrdSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdevprdsysname", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getSrcPSDevPrdSysName()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSysBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevPrdSysBase.getJSONValue((Object)pSDevPrdSysBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdSysBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdSysBase pSDevPrdSysBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdSysBase.getCreateDate() != null) {
            object = pSDevPrdSysBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSysBase.getCreateMan() != null) {
            object = pSDevPrdSysBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getDevPrdSysInfo() != null) {
            object = pSDevPrdSysBase.getDevPrdSysInfo();
            xmlNode.setAttribute(FIELD_DEVPRDSYSINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getDevPrdSysType() != null) {
            object = pSDevPrdSysBase.getDevPrdSysType();
            xmlNode.setAttribute(FIELD_DEVPRDSYSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getDevPrdSysState() != null) {
            object = pSDevPrdSysBase.getDevPrdSysState();
            xmlNode.setAttribute("DEVPRDSYSSTATE", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSysBase.getMemo() != null) {
            object = pSDevPrdSysBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdId() != null) {
            object = pSDevPrdSysBase.getPSDevPrdId();
            xmlNode.setAttribute(FIELD_PSDEVPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdName() != null) {
            object = pSDevPrdSysBase.getPSDevPrdName();
            xmlNode.setAttribute(FIELD_PSDEVPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdSubVerId() != null) {
            object = pSDevPrdSysBase.getPSDevPrdSubVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdSubVerName() != null) {
            object = pSDevPrdSysBase.getPSDevPrdSubVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdSysId() != null) {
            object = pSDevPrdSysBase.getPSDevPrdSysId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdSysName() != null) {
            object = pSDevPrdSysBase.getPSDevPrdSysName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdVerId() != null) {
            object = pSDevPrdSysBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevPrdVerName() != null) {
            object = pSDevPrdSysBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevSlnSysId() != null) {
            object = pSDevPrdSysBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getPSDevSlnSysName() != null) {
            object = pSDevPrdSysBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getSrcPSDevPrdSysId() != null) {
            object = pSDevPrdSysBase.getSrcPSDevPrdSysId();
            xmlNode.setAttribute(FIELD_SRCPSDEVPRDSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getSrcPSDevPrdSysName() != null) {
            object = pSDevPrdSysBase.getSrcPSDevPrdSysName();
            xmlNode.setAttribute(FIELD_SRCPSDEVPRDSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getUpdateDate() != null) {
            object = pSDevPrdSysBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSysBase.getUpdateMan() != null) {
            object = pSDevPrdSysBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysBase.getValidFlag() != null) {
            object = pSDevPrdSysBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdSysBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdSysBase pSDevPrdSysBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdSysBase.isCreateDateDirty() && (bl || pSDevPrdSysBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdSysBase.getCreateDate());
        }
        if (pSDevPrdSysBase.isCreateManDirty() && (bl || pSDevPrdSysBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdSysBase.getCreateMan());
        }
        if (pSDevPrdSysBase.isDevPrdSysInfoDirty() && (bl || pSDevPrdSysBase.getDevPrdSysInfo() != null)) {
            iDataObject.set(FIELD_DEVPRDSYSINFO, (Object)pSDevPrdSysBase.getDevPrdSysInfo());
        }
        if (pSDevPrdSysBase.isDevPrdSysTypeDirty() && (bl || pSDevPrdSysBase.getDevPrdSysType() != null)) {
            iDataObject.set(FIELD_DEVPRDSYSTYPE, (Object)pSDevPrdSysBase.getDevPrdSysType());
        }
        if (pSDevPrdSysBase.isDevPrdSysStateDirty() && (bl || pSDevPrdSysBase.getDevPrdSysState() != null)) {
            iDataObject.set(FIELD_DEVPRDSYSSTATE, (Object)pSDevPrdSysBase.getDevPrdSysState());
        }
        if (pSDevPrdSysBase.isMemoDirty() && (bl || pSDevPrdSysBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdSysBase.getMemo());
        }
        if (pSDevPrdSysBase.isPSDevPrdIdDirty() && (bl || pSDevPrdSysBase.getPSDevPrdId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDID, (Object)pSDevPrdSysBase.getPSDevPrdId());
        }
        if (pSDevPrdSysBase.isPSDevPrdNameDirty() && (bl || pSDevPrdSysBase.getPSDevPrdName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDNAME, (Object)pSDevPrdSysBase.getPSDevPrdName());
        }
        if (pSDevPrdSysBase.isPSDevPrdSubVerIdDirty() && (bl || pSDevPrdSysBase.getPSDevPrdSubVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERID, (Object)pSDevPrdSysBase.getPSDevPrdSubVerId());
        }
        if (pSDevPrdSysBase.isPSDevPrdSubVerNameDirty() && (bl || pSDevPrdSysBase.getPSDevPrdSubVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERNAME, (Object)pSDevPrdSysBase.getPSDevPrdSubVerName());
        }
        if (pSDevPrdSysBase.isPSDevPrdSysIdDirty() && (bl || pSDevPrdSysBase.getPSDevPrdSysId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSYSID, (Object)pSDevPrdSysBase.getPSDevPrdSysId());
        }
        if (pSDevPrdSysBase.isPSDevPrdSysNameDirty() && (bl || pSDevPrdSysBase.getPSDevPrdSysName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSYSNAME, (Object)pSDevPrdSysBase.getPSDevPrdSysName());
        }
        if (pSDevPrdSysBase.isPSDevPrdVerIdDirty() && (bl || pSDevPrdSysBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSDevPrdSysBase.getPSDevPrdVerId());
        }
        if (pSDevPrdSysBase.isPSDevPrdVerNameDirty() && (bl || pSDevPrdSysBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSDevPrdSysBase.getPSDevPrdVerName());
        }
        if (pSDevPrdSysBase.isPSDevSlnSysIdDirty() && (bl || pSDevPrdSysBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevPrdSysBase.getPSDevSlnSysId());
        }
        if (pSDevPrdSysBase.isPSDevSlnSysNameDirty() && (bl || pSDevPrdSysBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevPrdSysBase.getPSDevSlnSysName());
        }
        if (pSDevPrdSysBase.isSrcPSDevPrdSysIdDirty() && (bl || pSDevPrdSysBase.getSrcPSDevPrdSysId() != null)) {
            iDataObject.set(FIELD_SRCPSDEVPRDSYSID, (Object)pSDevPrdSysBase.getSrcPSDevPrdSysId());
        }
        if (pSDevPrdSysBase.isSrcPSDevPrdSysNameDirty() && (bl || pSDevPrdSysBase.getSrcPSDevPrdSysName() != null)) {
            iDataObject.set(FIELD_SRCPSDEVPRDSYSNAME, (Object)pSDevPrdSysBase.getSrcPSDevPrdSysName());
        }
        if (pSDevPrdSysBase.isUpdateDateDirty() && (bl || pSDevPrdSysBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdSysBase.getUpdateDate());
        }
        if (pSDevPrdSysBase.isUpdateManDirty() && (bl || pSDevPrdSysBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdSysBase.getUpdateMan());
        }
        if (pSDevPrdSysBase.isValidFlagDirty() && (bl || pSDevPrdSysBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevPrdSysBase.getValidFlag());
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
        return PSDevPrdSysBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdSysBase pSDevPrdSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSysBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevPrdSysBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevPrdSysBase.resetDevPrdSysInfo();
                return true;
            }
            case 3: {
                pSDevPrdSysBase.resetDevPrdSysType();
                return true;
            }
            case 4: {
                pSDevPrdSysBase.resetDevPrdSysState();
                return true;
            }
            case 5: {
                pSDevPrdSysBase.resetMemo();
                return true;
            }
            case 6: {
                pSDevPrdSysBase.resetPSDevPrdId();
                return true;
            }
            case 7: {
                pSDevPrdSysBase.resetPSDevPrdName();
                return true;
            }
            case 8: {
                pSDevPrdSysBase.resetPSDevPrdSubVerId();
                return true;
            }
            case 9: {
                pSDevPrdSysBase.resetPSDevPrdSubVerName();
                return true;
            }
            case 10: {
                pSDevPrdSysBase.resetPSDevPrdSysId();
                return true;
            }
            case 11: {
                pSDevPrdSysBase.resetPSDevPrdSysName();
                return true;
            }
            case 12: {
                pSDevPrdSysBase.resetPSDevPrdVerId();
                return true;
            }
            case 13: {
                pSDevPrdSysBase.resetPSDevPrdVerName();
                return true;
            }
            case 14: {
                pSDevPrdSysBase.resetPSDevSlnSysId();
                return true;
            }
            case 15: {
                pSDevPrdSysBase.resetPSDevSlnSysName();
                return true;
            }
            case 16: {
                pSDevPrdSysBase.resetSrcPSDevPrdSysId();
                return true;
            }
            case 17: {
                pSDevPrdSysBase.resetSrcPSDevPrdSysName();
                return true;
            }
            case 18: {
                pSDevPrdSysBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDevPrdSysBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSDevPrdSysBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSubVer getPSDevPrdSubVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVer();
        }
        if (this.getPSDevPrdSubVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdSubVerLock;
        synchronized (n) {
            if (this.psdevprdsubver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdSubVerId(), (Object)this.psdevprdsubver.getPSDevPrdSubVerId()) != 0L) {
                this.psdevprdsubver = null;
            }
            if (this.psdevprdsubver == null) {
                PSDevPrdSubVer pSDevPrdSubVer = new PSDevPrdSubVer();
                pSDevPrdSubVer.setPSDevPrdSubVerId(this.getPSDevPrdSubVerId());
                PSDevPrdSubVerService pSDevPrdSubVerService = (PSDevPrdSubVerService)ServiceGlobal.getService(PSDevPrdSubVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSubVerService.autoGet((IEntity)pSDevPrdSubVer);
                this.psdevprdsubver = pSDevPrdSubVer;
            }
            return this.psdevprdsubver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSys getSrcPSDevPrdSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDevPrdSys();
        }
        if (this.getSrcPSDevPrdSysId() == null) {
            return null;
        }
        Integer n = this.objSrcPSDevPrdSysLock;
        synchronized (n) {
            if (this.srcpsdevprdsys != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSDevPrdSysId(), (Object)this.srcpsdevprdsys.getPSDevPrdSysId()) != 0L) {
                this.srcpsdevprdsys = null;
            }
            if (this.srcpsdevprdsys == null) {
                PSDevPrdSys pSDevPrdSys = new PSDevPrdSys();
                pSDevPrdSys.setPSDevPrdSysId(this.getSrcPSDevPrdSysId());
                PSDevPrdSysService pSDevPrdSysService = (PSDevPrdSysService)ServiceGlobal.getService(PSDevPrdSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSysService.autoGet((IEntity)pSDevPrdSys);
                this.srcpsdevprdsys = pSDevPrdSys;
            }
            return this.srcpsdevprdsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdVer getPSDevPrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVer();
        }
        if (this.getPSDevPrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdVerLock;
        synchronized (n) {
            if (this.psdevprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdVerId(), (Object)this.psdevprdver.getPSDevPrdVerId()) != 0L) {
                this.psdevprdver = null;
            }
            if (this.psdevprdver == null) {
                PSDevPrdVer pSDevPrdVer = new PSDevPrdVer();
                pSDevPrdVer.setPSDevPrdVerId(this.getPSDevPrdVerId());
                PSDevPrdVerService pSDevPrdVerService = (PSDevPrdVerService)ServiceGlobal.getService(PSDevPrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdVerService.autoGet((IEntity)pSDevPrdVer);
                this.psdevprdver = pSDevPrdVer;
            }
            return this.psdevprdver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrd getPSDevPrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrd();
        }
        if (this.getPSDevPrdId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdLock;
        synchronized (n) {
            if (this.psdevprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdId(), (Object)this.psdevprd.getPSDevPrdId()) != 0L) {
                this.psdevprd = null;
            }
            if (this.psdevprd == null) {
                PSDevPrd pSDevPrd = new PSDevPrd();
                pSDevPrd.setPSDevPrdId(this.getPSDevPrdId());
                PSDevPrdService pSDevPrdService = (PSDevPrdService)ServiceGlobal.getService(PSDevPrdService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdService.autoGet((IEntity)pSDevPrd);
                this.psdevprd = pSDevPrd;
            }
            return this.psdevprd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDevPrdSysBase getProxyEntity() {
        return this.proxyPSDevPrdSysBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdSysBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdSysBase) {
            this.proxyPSDevPrdSysBase = (PSDevPrdSysBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEVPRDSYSINFO, 2);
        fieldIndexMap.put(FIELD_DEVPRDSYSTYPE, 3);
        fieldIndexMap.put(FIELD_DEVPRDSYSSTATE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEVPRDID, 6);
        fieldIndexMap.put(FIELD_PSDEVPRDNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERID, 8);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVPRDSYSID, 10);
        fieldIndexMap.put(FIELD_PSDEVPRDSYSNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 12);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 15);
        fieldIndexMap.put(FIELD_SRCPSDEVPRDSYSID, 16);
        fieldIndexMap.put(FIELD_SRCPSDEVPRDSYSNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

