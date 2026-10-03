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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCResRepBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCResRepBase.class);
    public static final String FIELD_ASCNT = "ASCNT";
    public static final String FIELD_CODEREPOCNT = "CODEREPOCNT";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBINSTCNT = "DBINSTCNT";
    public static final String FIELD_DCBALANCE = "DCBALANCE";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DEPINSTCNT = "DEPINSTCNT";
    public static final String FIELD_DEVSLNCNT = "DEVSLNCNT";
    public static final String FIELD_DEVSYSCNT = "DEVSYSCNT";
    public static final String FIELD_DEVTEMPLCNT = "DEVTEMPLCNT";
    public static final String FIELD_DISKSIZE = "DISKSIZE";
    public static final String FIELD_DISKUSED = "DISKUSED";
    public static final String FIELD_DYNAINSTCNT = "DYNAINSTCNT";
    public static final String FIELD_EXPIREDASCNT = "EXPIREDASCNT";
    public static final String FIELD_EXPIREDASCNT2 = "EXPIREDASCNT2";
    public static final String FIELD_EXPIREDCODEREPOCNT = "EXPIREDCODEREPOCNT";
    public static final String FIELD_EXPIREDCODEREPOCNT2 = "EXPIREDCODEREPOCNT2";
    public static final String FIELD_EXPIREDDBINSTCNT = "EXPIREDDBINSTCNT";
    public static final String FIELD_EXPIREDDBINSTCNT2 = "EXPIREDDBINSTCNT2";
    public static final String FIELD_EXPIREDMQINSTCNT = "EXPIREDMQINSTCNT";
    public static final String FIELD_EXPIREDMQINSTCNT2 = "EXPIREDMQINSTCNT2";
    public static final String FIELD_IDLEASCNT = "IDLEASCNT";
    public static final String FIELD_IDLECODEREPOCNT = "IDLECODEREPOCNT";
    public static final String FIELD_IDLEDBINSTCNT = "IDLEDBINSTCNT";
    public static final String FIELD_IDLEMQINSTCNT = "IDLEMQINSTCNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MONTHNWFLOWSIZE = "MONTHNWFLOWSIZE";
    public static final String FIELD_MONTHNWFLOWUSED = "MONTHNWFLOWUSED";
    public static final String FIELD_MQINSTCNT = "MQINSTCNT";
    public static final String FIELD_MSPCNT = "MSPCNT";
    public static final String FIELD_OBJ2CNT = "OBJ2CNT";
    public static final String FIELD_OBJ3CNT = "OBJ3CNT";
    public static final String FIELD_OBJ4CNT = "OBJ4CNT";
    public static final String FIELD_OBJCNT = "OBJCNT";
    public static final String FIELD_PSDCRESREPID = "PSDCRESREPID";
    public static final String FIELD_PSDCRESREPNAME = "PSDCRESREPNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_REPORTURL = "REPORTURL";
    public static final String FIELD_REPTIME = "REPTIME";
    public static final String FIELD_ROBOTCNT = "ROBOTCNT";
    public static final String FIELD_SYSBAKCNT = "SYSBAKCNT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEDASCNT = "USEDASCNT";
    public static final String FIELD_USEDCODEREPOCNT = "USEDCODEREPOCNT";
    public static final String FIELD_USEDDBINSTCNT = "USEDDBINSTCNT";
    public static final String FIELD_USEDMQINSTCNT = "USEDMQINSTCNT";
    public static final String FIELD_USERASCNT = "USERASCNT";
    public static final String FIELD_USERCNT = "USERCNT";
    public static final String FIELD_USERCODEREPOCNT = "USERCODEREPOCNT";
    public static final String FIELD_USERDBINSTCNT = "USERDBINSTCNT";
    public static final String FIELD_USERMQINSTCNT = "USERMQINSTCNT";
    public static final String FIELD_WORKSPACECNT = "WORKSPACECNT";
    private static final int INDEX_ASCNT = 0;
    private static final int INDEX_CODEREPOCNT = 1;
    private static final int INDEX_CONTENT = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DBINSTCNT = 5;
    private static final int INDEX_DCBALANCE = 6;
    private static final int INDEX_DEFAULTFLAG = 7;
    private static final int INDEX_DEPINSTCNT = 8;
    private static final int INDEX_DEVSLNCNT = 9;
    private static final int INDEX_DEVSYSCNT = 10;
    private static final int INDEX_DEVTEMPLCNT = 11;
    private static final int INDEX_DISKSIZE = 12;
    private static final int INDEX_DISKUSED = 13;
    private static final int INDEX_DYNAINSTCNT = 14;
    private static final int INDEX_EXPIREDASCNT = 15;
    private static final int INDEX_EXPIREDASCNT2 = 16;
    private static final int INDEX_EXPIREDCODEREPOCNT = 17;
    private static final int INDEX_EXPIREDCODEREPOCNT2 = 18;
    private static final int INDEX_EXPIREDDBINSTCNT = 19;
    private static final int INDEX_EXPIREDDBINSTCNT2 = 20;
    private static final int INDEX_EXPIREDMQINSTCNT = 21;
    private static final int INDEX_EXPIREDMQINSTCNT2 = 22;
    private static final int INDEX_IDLEASCNT = 23;
    private static final int INDEX_IDLECODEREPOCNT = 24;
    private static final int INDEX_IDLEDBINSTCNT = 25;
    private static final int INDEX_IDLEMQINSTCNT = 26;
    private static final int INDEX_MEMO = 27;
    private static final int INDEX_MONTHNWFLOWSIZE = 28;
    private static final int INDEX_MONTHNWFLOWUSED = 29;
    private static final int INDEX_MQINSTCNT = 30;
    private static final int INDEX_MSPCNT = 31;
    private static final int INDEX_OBJ2CNT = 32;
    private static final int INDEX_OBJ3CNT = 33;
    private static final int INDEX_OBJ4CNT = 34;
    private static final int INDEX_OBJCNT = 35;
    private static final int INDEX_PSDCRESREPID = 36;
    private static final int INDEX_PSDCRESREPNAME = 37;
    private static final int INDEX_PSDEVCENTERID = 38;
    private static final int INDEX_PSDEVCENTERNAME = 39;
    private static final int INDEX_REPORTURL = 40;
    private static final int INDEX_REPTIME = 41;
    private static final int INDEX_ROBOTCNT = 42;
    private static final int INDEX_SYSBAKCNT = 43;
    private static final int INDEX_UPDATEDATE = 44;
    private static final int INDEX_UPDATEMAN = 45;
    private static final int INDEX_USEDASCNT = 46;
    private static final int INDEX_USEDCODEREPOCNT = 47;
    private static final int INDEX_USEDDBINSTCNT = 48;
    private static final int INDEX_USEDMQINSTCNT = 49;
    private static final int INDEX_USERASCNT = 50;
    private static final int INDEX_USERCNT = 51;
    private static final int INDEX_USERCODEREPOCNT = 52;
    private static final int INDEX_USERDBINSTCNT = 53;
    private static final int INDEX_USERMQINSTCNT = 54;
    private static final int INDEX_WORKSPACECNT = 55;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCResRepBase proxyPSDCResRepBase = null;
    private boolean ascntDirtyFlag = false;
    private boolean coderepocntDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbinstcntDirtyFlag = false;
    private boolean dcbalanceDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean depinstcntDirtyFlag = false;
    private boolean devslncntDirtyFlag = false;
    private boolean devsyscntDirtyFlag = false;
    private boolean devtemplcntDirtyFlag = false;
    private boolean disksizeDirtyFlag = false;
    private boolean diskusedDirtyFlag = false;
    private boolean dynainstcntDirtyFlag = false;
    private boolean expiredascntDirtyFlag = false;
    private boolean expiredascnt2DirtyFlag = false;
    private boolean expiredcoderepocntDirtyFlag = false;
    private boolean expiredcoderepocnt2DirtyFlag = false;
    private boolean expireddbinstcntDirtyFlag = false;
    private boolean expireddbinstcnt2DirtyFlag = false;
    private boolean expiredmqinstcntDirtyFlag = false;
    private boolean expiredmqinstcnt2DirtyFlag = false;
    private boolean idleascntDirtyFlag = false;
    private boolean idlecoderepocntDirtyFlag = false;
    private boolean idledbinstcntDirtyFlag = false;
    private boolean idlemqinstcntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean monthnwflowsizeDirtyFlag = false;
    private boolean monthnwflowusedDirtyFlag = false;
    private boolean mqinstcntDirtyFlag = false;
    private boolean mspcntDirtyFlag = false;
    private boolean obj2cntDirtyFlag = false;
    private boolean obj3cntDirtyFlag = false;
    private boolean obj4cntDirtyFlag = false;
    private boolean objcntDirtyFlag = false;
    private boolean psdcresrepidDirtyFlag = false;
    private boolean psdcresrepnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean reporturlDirtyFlag = false;
    private boolean reptimeDirtyFlag = false;
    private boolean robotcntDirtyFlag = false;
    private boolean sysbakcntDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usedascntDirtyFlag = false;
    private boolean usedcoderepocntDirtyFlag = false;
    private boolean useddbinstcntDirtyFlag = false;
    private boolean usedmqinstcntDirtyFlag = false;
    private boolean userascntDirtyFlag = false;
    private boolean usercntDirtyFlag = false;
    private boolean usercoderepocntDirtyFlag = false;
    private boolean userdbinstcntDirtyFlag = false;
    private boolean usermqinstcntDirtyFlag = false;
    private boolean workspacecntDirtyFlag = false;
    @Column(name="ascnt")
    private Integer ascnt;
    @Column(name="coderepocnt")
    private Integer coderepocnt;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbinstcnt")
    private Integer dbinstcnt;
    @Column(name="dcbalance")
    private Double dcbalance;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="depinstcnt")
    private Integer depinstcnt;
    @Column(name="devslncnt")
    private Integer devslncnt;
    @Column(name="devsyscnt")
    private Integer devsyscnt;
    @Column(name="devtemplcnt")
    private Integer devtemplcnt;
    @Column(name="disksize")
    private Integer disksize;
    @Column(name="diskused")
    private Integer diskused;
    @Column(name="dynainstcnt")
    private Integer dynainstcnt;
    @Column(name="expiredascnt")
    private Integer expiredascnt;
    @Column(name="expiredascnt2")
    private Integer expiredascnt2;
    @Column(name="expiredcoderepocnt")
    private Integer expiredcoderepocnt;
    @Column(name="expiredcoderepocnt2")
    private Integer expiredcoderepocnt2;
    @Column(name="expireddbinstcnt")
    private Integer expireddbinstcnt;
    @Column(name="expireddbinstcnt2")
    private Integer expireddbinstcnt2;
    @Column(name="expiredmqinstcnt")
    private Integer expiredmqinstcnt;
    @Column(name="expiredmqinstcnt2")
    private Integer expiredmqinstcnt2;
    @Column(name="idleascnt")
    private Integer idleascnt;
    @Column(name="idlecoderepocnt")
    private Integer idlecoderepocnt;
    @Column(name="idledbinstcnt")
    private Integer idledbinstcnt;
    @Column(name="idlemqinstcnt")
    private Integer idlemqinstcnt;
    @Column(name="memo")
    private String memo;
    @Column(name="monthnwflowsize")
    private Integer monthnwflowsize;
    @Column(name="monthnwflowused")
    private Integer monthnwflowused;
    @Column(name="mqinstcnt")
    private Integer mqinstcnt;
    @Column(name="mspcnt")
    private Integer mspcnt;
    @Column(name="obj2cnt")
    private Integer obj2cnt;
    @Column(name="obj3cnt")
    private Integer obj3cnt;
    @Column(name="obj4cnt")
    private Integer obj4cnt;
    @Column(name="objcnt")
    private Integer objcnt;
    @Column(name="psdcresrepid")
    private String psdcresrepid;
    @Column(name="psdcresrepname")
    private String psdcresrepname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="reporturl")
    private String reporturl;
    @Column(name="reptime")
    private Timestamp reptime;
    @Column(name="robotcnt")
    private Integer robotcnt;
    @Column(name="sysbakcnt")
    private Integer sysbakcnt;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usedascnt")
    private Integer usedascnt;
    @Column(name="usedcoderepocnt")
    private Integer usedcoderepocnt;
    @Column(name="useddbinstcnt")
    private Integer useddbinstcnt;
    @Column(name="usedmqinstcnt")
    private Integer usedmqinstcnt;
    @Column(name="userascnt")
    private Integer userascnt;
    @Column(name="usercnt")
    private Integer usercnt;
    @Column(name="usercoderepocnt")
    private Integer usercoderepocnt;
    @Column(name="userdbinstcnt")
    private Integer userdbinstcnt;
    @Column(name="usermqinstcnt")
    private Integer usermqinstcnt;
    @Column(name="workspacecnt")
    private Integer workspacecnt;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setASCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASCnt(n);
            return;
        }
        this.ascnt = n;
        this.ascntDirtyFlag = true;
    }

    public Integer getASCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASCnt();
        }
        return this.ascnt;
    }

    public boolean isASCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASCntDirty();
        }
        return this.ascntDirtyFlag;
    }

    public void resetASCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASCnt();
            return;
        }
        this.ascntDirtyFlag = false;
        this.ascnt = null;
    }

    public void setCodeRepoCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeRepoCnt(n);
            return;
        }
        this.coderepocnt = n;
        this.coderepocntDirtyFlag = true;
    }

    public Integer getCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeRepoCnt();
        }
        return this.coderepocnt;
    }

    public boolean isCodeRepoCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeRepoCntDirty();
        }
        return this.coderepocntDirtyFlag;
    }

    public void resetCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeRepoCnt();
            return;
        }
        this.coderepocntDirtyFlag = false;
        this.coderepocnt = null;
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

    public void setDBInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBInstCnt(n);
            return;
        }
        this.dbinstcnt = n;
        this.dbinstcntDirtyFlag = true;
    }

    public Integer getDBInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBInstCnt();
        }
        return this.dbinstcnt;
    }

    public boolean isDBInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBInstCntDirty();
        }
        return this.dbinstcntDirtyFlag;
    }

    public void resetDBInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBInstCnt();
            return;
        }
        this.dbinstcntDirtyFlag = false;
        this.dbinstcnt = null;
    }

    public void setDCBalance(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCBalance(d);
            return;
        }
        this.dcbalance = d;
        this.dcbalanceDirtyFlag = true;
    }

    public Double getDCBalance() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCBalance();
        }
        return this.dcbalance;
    }

    public boolean isDCBalanceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCBalanceDirty();
        }
        return this.dcbalanceDirtyFlag;
    }

    public void resetDCBalance() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCBalance();
            return;
        }
        this.dcbalanceDirtyFlag = false;
        this.dcbalance = null;
    }

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDepInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDepInstCnt(n);
            return;
        }
        this.depinstcnt = n;
        this.depinstcntDirtyFlag = true;
    }

    public Integer getDepInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDepInstCnt();
        }
        return this.depinstcnt;
    }

    public boolean isDepInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDepInstCntDirty();
        }
        return this.depinstcntDirtyFlag;
    }

    public void resetDepInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDepInstCnt();
            return;
        }
        this.depinstcntDirtyFlag = false;
        this.depinstcnt = null;
    }

    public void setDevSlnCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSlnCnt(n);
            return;
        }
        this.devslncnt = n;
        this.devslncntDirtyFlag = true;
    }

    public Integer getDevSlnCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSlnCnt();
        }
        return this.devslncnt;
    }

    public boolean isDevSlnCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSlnCntDirty();
        }
        return this.devslncntDirtyFlag;
    }

    public void resetDevSlnCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSlnCnt();
            return;
        }
        this.devslncntDirtyFlag = false;
        this.devslncnt = null;
    }

    public void setDevSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSysCnt(n);
            return;
        }
        this.devsyscnt = n;
        this.devsyscntDirtyFlag = true;
    }

    public Integer getDevSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSysCnt();
        }
        return this.devsyscnt;
    }

    public boolean isDevSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSysCntDirty();
        }
        return this.devsyscntDirtyFlag;
    }

    public void resetDevSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSysCnt();
            return;
        }
        this.devsyscntDirtyFlag = false;
        this.devsyscnt = null;
    }

    public void setDevTemplCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevTemplCnt(n);
            return;
        }
        this.devtemplcnt = n;
        this.devtemplcntDirtyFlag = true;
    }

    public Integer getDevTemplCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevTemplCnt();
        }
        return this.devtemplcnt;
    }

    public boolean isDevTemplCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevTemplCntDirty();
        }
        return this.devtemplcntDirtyFlag;
    }

    public void resetDevTemplCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevTemplCnt();
            return;
        }
        this.devtemplcntDirtyFlag = false;
        this.devtemplcnt = null;
    }

    public void setDiskSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDiskSize(n);
            return;
        }
        this.disksize = n;
        this.disksizeDirtyFlag = true;
    }

    public Integer getDiskSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDiskSize();
        }
        return this.disksize;
    }

    public boolean isDiskSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDiskSizeDirty();
        }
        return this.disksizeDirtyFlag;
    }

    public void resetDiskSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDiskSize();
            return;
        }
        this.disksizeDirtyFlag = false;
        this.disksize = null;
    }

    public void setDiskUsed(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDiskUsed(n);
            return;
        }
        this.diskused = n;
        this.diskusedDirtyFlag = true;
    }

    public Integer getDiskUsed() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDiskUsed();
        }
        return this.diskused;
    }

    public boolean isDiskUsedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDiskUsedDirty();
        }
        return this.diskusedDirtyFlag;
    }

    public void resetDiskUsed() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDiskUsed();
            return;
        }
        this.diskusedDirtyFlag = false;
        this.diskused = null;
    }

    public void setDynaInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstCnt(n);
            return;
        }
        this.dynainstcnt = n;
        this.dynainstcntDirtyFlag = true;
    }

    public Integer getDynaInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstCnt();
        }
        return this.dynainstcnt;
    }

    public boolean isDynaInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstCntDirty();
        }
        return this.dynainstcntDirtyFlag;
    }

    public void resetDynaInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstCnt();
            return;
        }
        this.dynainstcntDirtyFlag = false;
        this.dynainstcnt = null;
    }

    public void setExpiredASCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredASCnt(n);
            return;
        }
        this.expiredascnt = n;
        this.expiredascntDirtyFlag = true;
    }

    public Integer getExpiredASCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredASCnt();
        }
        return this.expiredascnt;
    }

    public boolean isExpiredASCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredASCntDirty();
        }
        return this.expiredascntDirtyFlag;
    }

    public void resetExpiredASCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredASCnt();
            return;
        }
        this.expiredascntDirtyFlag = false;
        this.expiredascnt = null;
    }

    public void setExpiredASCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredASCnt2(n);
            return;
        }
        this.expiredascnt2 = n;
        this.expiredascnt2DirtyFlag = true;
    }

    public Integer getExpiredASCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredASCnt2();
        }
        return this.expiredascnt2;
    }

    public boolean isExpiredASCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredASCnt2Dirty();
        }
        return this.expiredascnt2DirtyFlag;
    }

    public void resetExpiredASCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredASCnt2();
            return;
        }
        this.expiredascnt2DirtyFlag = false;
        this.expiredascnt2 = null;
    }

    public void setExpiredCodeRepoCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredCodeRepoCnt(n);
            return;
        }
        this.expiredcoderepocnt = n;
        this.expiredcoderepocntDirtyFlag = true;
    }

    public Integer getExpiredCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredCodeRepoCnt();
        }
        return this.expiredcoderepocnt;
    }

    public boolean isExpiredCodeRepoCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredCodeRepoCntDirty();
        }
        return this.expiredcoderepocntDirtyFlag;
    }

    public void resetExpiredCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredCodeRepoCnt();
            return;
        }
        this.expiredcoderepocntDirtyFlag = false;
        this.expiredcoderepocnt = null;
    }

    public void setExpiredCodeRepoCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredCodeRepoCnt2(n);
            return;
        }
        this.expiredcoderepocnt2 = n;
        this.expiredcoderepocnt2DirtyFlag = true;
    }

    public Integer getExpiredCodeRepoCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredCodeRepoCnt2();
        }
        return this.expiredcoderepocnt2;
    }

    public boolean isExpiredCodeRepoCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredCodeRepoCnt2Dirty();
        }
        return this.expiredcoderepocnt2DirtyFlag;
    }

    public void resetExpiredCodeRepoCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredCodeRepoCnt2();
            return;
        }
        this.expiredcoderepocnt2DirtyFlag = false;
        this.expiredcoderepocnt2 = null;
    }

    public void setExpiredDBInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredDBInstCnt(n);
            return;
        }
        this.expireddbinstcnt = n;
        this.expireddbinstcntDirtyFlag = true;
    }

    public Integer getExpiredDBInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredDBInstCnt();
        }
        return this.expireddbinstcnt;
    }

    public boolean isExpiredDBInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredDBInstCntDirty();
        }
        return this.expireddbinstcntDirtyFlag;
    }

    public void resetExpiredDBInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredDBInstCnt();
            return;
        }
        this.expireddbinstcntDirtyFlag = false;
        this.expireddbinstcnt = null;
    }

    public void setExpiredDBInstCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredDBInstCnt2(n);
            return;
        }
        this.expireddbinstcnt2 = n;
        this.expireddbinstcnt2DirtyFlag = true;
    }

    public Integer getExpiredDBInstCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredDBInstCnt2();
        }
        return this.expireddbinstcnt2;
    }

    public boolean isExpiredDBInstCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredDBInstCnt2Dirty();
        }
        return this.expireddbinstcnt2DirtyFlag;
    }

    public void resetExpiredDBInstCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredDBInstCnt2();
            return;
        }
        this.expireddbinstcnt2DirtyFlag = false;
        this.expireddbinstcnt2 = null;
    }

    public void setExpiredMQInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredMQInstCnt(n);
            return;
        }
        this.expiredmqinstcnt = n;
        this.expiredmqinstcntDirtyFlag = true;
    }

    public Integer getExpiredMQInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredMQInstCnt();
        }
        return this.expiredmqinstcnt;
    }

    public boolean isExpiredMQInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredMQInstCntDirty();
        }
        return this.expiredmqinstcntDirtyFlag;
    }

    public void resetExpiredMQInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredMQInstCnt();
            return;
        }
        this.expiredmqinstcntDirtyFlag = false;
        this.expiredmqinstcnt = null;
    }

    public void setExpiredMQInstCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredMQInstCnt2(n);
            return;
        }
        this.expiredmqinstcnt2 = n;
        this.expiredmqinstcnt2DirtyFlag = true;
    }

    public Integer getExpiredMQInstCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredMQInstCnt2();
        }
        return this.expiredmqinstcnt2;
    }

    public boolean isExpiredMQInstCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredMQInstCnt2Dirty();
        }
        return this.expiredmqinstcnt2DirtyFlag;
    }

    public void resetExpiredMQInstCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredMQInstCnt2();
            return;
        }
        this.expiredmqinstcnt2DirtyFlag = false;
        this.expiredmqinstcnt2 = null;
    }

    public void setIdleASCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIdleASCnt(n);
            return;
        }
        this.idleascnt = n;
        this.idleascntDirtyFlag = true;
    }

    public Integer getIdleASCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIdleASCnt();
        }
        return this.idleascnt;
    }

    public boolean isIdleASCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIdleASCntDirty();
        }
        return this.idleascntDirtyFlag;
    }

    public void resetIdleASCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIdleASCnt();
            return;
        }
        this.idleascntDirtyFlag = false;
        this.idleascnt = null;
    }

    public void setIdleCodeRepoCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIdleCodeRepoCnt(n);
            return;
        }
        this.idlecoderepocnt = n;
        this.idlecoderepocntDirtyFlag = true;
    }

    public Integer getIdleCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIdleCodeRepoCnt();
        }
        return this.idlecoderepocnt;
    }

    public boolean isIdleCodeRepoCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIdleCodeRepoCntDirty();
        }
        return this.idlecoderepocntDirtyFlag;
    }

    public void resetIdleCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIdleCodeRepoCnt();
            return;
        }
        this.idlecoderepocntDirtyFlag = false;
        this.idlecoderepocnt = null;
    }

    public void setIdleDBInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIdleDBInstCnt(n);
            return;
        }
        this.idledbinstcnt = n;
        this.idledbinstcntDirtyFlag = true;
    }

    public Integer getIdleDBInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIdleDBInstCnt();
        }
        return this.idledbinstcnt;
    }

    public boolean isIdleDBInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIdleDBInstCntDirty();
        }
        return this.idledbinstcntDirtyFlag;
    }

    public void resetIdleDBInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIdleDBInstCnt();
            return;
        }
        this.idledbinstcntDirtyFlag = false;
        this.idledbinstcnt = null;
    }

    public void setIdleMQInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIdleMQInstCnt(n);
            return;
        }
        this.idlemqinstcnt = n;
        this.idlemqinstcntDirtyFlag = true;
    }

    public Integer getIdleMQInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIdleMQInstCnt();
        }
        return this.idlemqinstcnt;
    }

    public boolean isIdleMQInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIdleMQInstCntDirty();
        }
        return this.idlemqinstcntDirtyFlag;
    }

    public void resetIdleMQInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIdleMQInstCnt();
            return;
        }
        this.idlemqinstcntDirtyFlag = false;
        this.idlemqinstcnt = null;
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

    public void setMonthNWFlowSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonthNWFlowSize(n);
            return;
        }
        this.monthnwflowsize = n;
        this.monthnwflowsizeDirtyFlag = true;
    }

    public Integer getMonthNWFlowSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonthNWFlowSize();
        }
        return this.monthnwflowsize;
    }

    public boolean isMonthNWFlowSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonthNWFlowSizeDirty();
        }
        return this.monthnwflowsizeDirtyFlag;
    }

    public void resetMonthNWFlowSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonthNWFlowSize();
            return;
        }
        this.monthnwflowsizeDirtyFlag = false;
        this.monthnwflowsize = null;
    }

    public void setMonthNWFlowUsed(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonthNWFlowUsed(n);
            return;
        }
        this.monthnwflowused = n;
        this.monthnwflowusedDirtyFlag = true;
    }

    public Integer getMonthNWFlowUsed() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonthNWFlowUsed();
        }
        return this.monthnwflowused;
    }

    public boolean isMonthNWFlowUsedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonthNWFlowUsedDirty();
        }
        return this.monthnwflowusedDirtyFlag;
    }

    public void resetMonthNWFlowUsed() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonthNWFlowUsed();
            return;
        }
        this.monthnwflowusedDirtyFlag = false;
        this.monthnwflowused = null;
    }

    public void setMQInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMQInstCnt(n);
            return;
        }
        this.mqinstcnt = n;
        this.mqinstcntDirtyFlag = true;
    }

    public Integer getMQInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMQInstCnt();
        }
        return this.mqinstcnt;
    }

    public boolean isMQInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMQInstCntDirty();
        }
        return this.mqinstcntDirtyFlag;
    }

    public void resetMQInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMQInstCnt();
            return;
        }
        this.mqinstcntDirtyFlag = false;
        this.mqinstcnt = null;
    }

    public void setMSPCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSPCnt(n);
            return;
        }
        this.mspcnt = n;
        this.mspcntDirtyFlag = true;
    }

    public Integer getMSPCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSPCnt();
        }
        return this.mspcnt;
    }

    public boolean isMSPCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSPCntDirty();
        }
        return this.mspcntDirtyFlag;
    }

    public void resetMSPCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSPCnt();
            return;
        }
        this.mspcntDirtyFlag = false;
        this.mspcnt = null;
    }

    public void setObj2Cnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObj2Cnt(n);
            return;
        }
        this.obj2cnt = n;
        this.obj2cntDirtyFlag = true;
    }

    public Integer getObj2Cnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObj2Cnt();
        }
        return this.obj2cnt;
    }

    public boolean isObj2CntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObj2CntDirty();
        }
        return this.obj2cntDirtyFlag;
    }

    public void resetObj2Cnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObj2Cnt();
            return;
        }
        this.obj2cntDirtyFlag = false;
        this.obj2cnt = null;
    }

    public void setObj3Cnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObj3Cnt(n);
            return;
        }
        this.obj3cnt = n;
        this.obj3cntDirtyFlag = true;
    }

    public Integer getObj3Cnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObj3Cnt();
        }
        return this.obj3cnt;
    }

    public boolean isObj3CntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObj3CntDirty();
        }
        return this.obj3cntDirtyFlag;
    }

    public void resetObj3Cnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObj3Cnt();
            return;
        }
        this.obj3cntDirtyFlag = false;
        this.obj3cnt = null;
    }

    public void setObj4Cnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObj4Cnt(n);
            return;
        }
        this.obj4cnt = n;
        this.obj4cntDirtyFlag = true;
    }

    public Integer getObj4Cnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObj4Cnt();
        }
        return this.obj4cnt;
    }

    public boolean isObj4CntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObj4CntDirty();
        }
        return this.obj4cntDirtyFlag;
    }

    public void resetObj4Cnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObj4Cnt();
            return;
        }
        this.obj4cntDirtyFlag = false;
        this.obj4cnt = null;
    }

    public void setObjCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjCnt(n);
            return;
        }
        this.objcnt = n;
        this.objcntDirtyFlag = true;
    }

    public Integer getObjCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjCnt();
        }
        return this.objcnt;
    }

    public boolean isObjCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjCntDirty();
        }
        return this.objcntDirtyFlag;
    }

    public void resetObjCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjCnt();
            return;
        }
        this.objcntDirtyFlag = false;
        this.objcnt = null;
    }

    public void setPSDCResRepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCResRepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcresrepid = string;
        this.psdcresrepidDirtyFlag = true;
    }

    public String getPSDCResRepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResRepId();
        }
        return this.psdcresrepid;
    }

    public boolean isPSDCResRepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCResRepIdDirty();
        }
        return this.psdcresrepidDirtyFlag;
    }

    public void resetPSDCResRepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCResRepId();
            return;
        }
        this.psdcresrepidDirtyFlag = false;
        this.psdcresrepid = null;
    }

    public void setPSDCResRepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCResRepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcresrepname = string;
        this.psdcresrepnameDirtyFlag = true;
    }

    public String getPSDCResRepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCResRepName();
        }
        return this.psdcresrepname;
    }

    public boolean isPSDCResRepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCResRepNameDirty();
        }
        return this.psdcresrepnameDirtyFlag;
    }

    public void resetPSDCResRepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCResRepName();
            return;
        }
        this.psdcresrepnameDirtyFlag = false;
        this.psdcresrepname = null;
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

    public void setReportUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReportUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reporturl = string;
        this.reporturlDirtyFlag = true;
    }

    public String getReportUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReportUrl();
        }
        return this.reporturl;
    }

    public boolean isReportUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReportUrlDirty();
        }
        return this.reporturlDirtyFlag;
    }

    public void resetReportUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReportUrl();
            return;
        }
        this.reporturlDirtyFlag = false;
        this.reporturl = null;
    }

    public void setRepTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepTime(timestamp);
            return;
        }
        this.reptime = timestamp;
        this.reptimeDirtyFlag = true;
    }

    public Timestamp getRepTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepTime();
        }
        return this.reptime;
    }

    public boolean isRepTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepTimeDirty();
        }
        return this.reptimeDirtyFlag;
    }

    public void resetRepTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepTime();
            return;
        }
        this.reptimeDirtyFlag = false;
        this.reptime = null;
    }

    public void setRobotCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRobotCnt(n);
            return;
        }
        this.robotcnt = n;
        this.robotcntDirtyFlag = true;
    }

    public Integer getRobotCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRobotCnt();
        }
        return this.robotcnt;
    }

    public boolean isRobotCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRobotCntDirty();
        }
        return this.robotcntDirtyFlag;
    }

    public void resetRobotCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRobotCnt();
            return;
        }
        this.robotcntDirtyFlag = false;
        this.robotcnt = null;
    }

    public void setSysBakCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysBakCnt(n);
            return;
        }
        this.sysbakcnt = n;
        this.sysbakcntDirtyFlag = true;
    }

    public Integer getSysBakCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysBakCnt();
        }
        return this.sysbakcnt;
    }

    public boolean isSysBakCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysBakCntDirty();
        }
        return this.sysbakcntDirtyFlag;
    }

    public void resetSysBakCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysBakCnt();
            return;
        }
        this.sysbakcntDirtyFlag = false;
        this.sysbakcnt = null;
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

    public void setUsedASCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedASCnt(n);
            return;
        }
        this.usedascnt = n;
        this.usedascntDirtyFlag = true;
    }

    public Integer getUsedASCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedASCnt();
        }
        return this.usedascnt;
    }

    public boolean isUsedASCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedASCntDirty();
        }
        return this.usedascntDirtyFlag;
    }

    public void resetUsedASCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedASCnt();
            return;
        }
        this.usedascntDirtyFlag = false;
        this.usedascnt = null;
    }

    public void setUsedCodeRepoCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedCodeRepoCnt(n);
            return;
        }
        this.usedcoderepocnt = n;
        this.usedcoderepocntDirtyFlag = true;
    }

    public Integer getUsedCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedCodeRepoCnt();
        }
        return this.usedcoderepocnt;
    }

    public boolean isUsedCodeRepoCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedCodeRepoCntDirty();
        }
        return this.usedcoderepocntDirtyFlag;
    }

    public void resetUsedCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedCodeRepoCnt();
            return;
        }
        this.usedcoderepocntDirtyFlag = false;
        this.usedcoderepocnt = null;
    }

    public void setUsedDBInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedDBInstCnt(n);
            return;
        }
        this.useddbinstcnt = n;
        this.useddbinstcntDirtyFlag = true;
    }

    public Integer getUsedDBInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedDBInstCnt();
        }
        return this.useddbinstcnt;
    }

    public boolean isUsedDBInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedDBInstCntDirty();
        }
        return this.useddbinstcntDirtyFlag;
    }

    public void resetUsedDBInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedDBInstCnt();
            return;
        }
        this.useddbinstcntDirtyFlag = false;
        this.useddbinstcnt = null;
    }

    public void setUsedMQInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedMQInstCnt(n);
            return;
        }
        this.usedmqinstcnt = n;
        this.usedmqinstcntDirtyFlag = true;
    }

    public Integer getUsedMQInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedMQInstCnt();
        }
        return this.usedmqinstcnt;
    }

    public boolean isUsedMQInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedMQInstCntDirty();
        }
        return this.usedmqinstcntDirtyFlag;
    }

    public void resetUsedMQInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedMQInstCnt();
            return;
        }
        this.usedmqinstcntDirtyFlag = false;
        this.usedmqinstcnt = null;
    }

    public void setUserASCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserASCnt(n);
            return;
        }
        this.userascnt = n;
        this.userascntDirtyFlag = true;
    }

    public Integer getUserASCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserASCnt();
        }
        return this.userascnt;
    }

    public boolean isUserASCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserASCntDirty();
        }
        return this.userascntDirtyFlag;
    }

    public void resetUserASCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserASCnt();
            return;
        }
        this.userascntDirtyFlag = false;
        this.userascnt = null;
    }

    public void setUserCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCnt(n);
            return;
        }
        this.usercnt = n;
        this.usercntDirtyFlag = true;
    }

    public Integer getUserCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCnt();
        }
        return this.usercnt;
    }

    public boolean isUserCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCntDirty();
        }
        return this.usercntDirtyFlag;
    }

    public void resetUserCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCnt();
            return;
        }
        this.usercntDirtyFlag = false;
        this.usercnt = null;
    }

    public void setUserCodeRepoCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCodeRepoCnt(n);
            return;
        }
        this.usercoderepocnt = n;
        this.usercoderepocntDirtyFlag = true;
    }

    public Integer getUserCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCodeRepoCnt();
        }
        return this.usercoderepocnt;
    }

    public boolean isUserCodeRepoCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCodeRepoCntDirty();
        }
        return this.usercoderepocntDirtyFlag;
    }

    public void resetUserCodeRepoCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCodeRepoCnt();
            return;
        }
        this.usercoderepocntDirtyFlag = false;
        this.usercoderepocnt = null;
    }

    public void setUserDBInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDBInstCnt(n);
            return;
        }
        this.userdbinstcnt = n;
        this.userdbinstcntDirtyFlag = true;
    }

    public Integer getUserDBInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDBInstCnt();
        }
        return this.userdbinstcnt;
    }

    public boolean isUserDBInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDBInstCntDirty();
        }
        return this.userdbinstcntDirtyFlag;
    }

    public void resetUserDBInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDBInstCnt();
            return;
        }
        this.userdbinstcntDirtyFlag = false;
        this.userdbinstcnt = null;
    }

    public void setUserMQInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserMQInstCnt(n);
            return;
        }
        this.usermqinstcnt = n;
        this.usermqinstcntDirtyFlag = true;
    }

    public Integer getUserMQInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserMQInstCnt();
        }
        return this.usermqinstcnt;
    }

    public boolean isUserMQInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserMQInstCntDirty();
        }
        return this.usermqinstcntDirtyFlag;
    }

    public void resetUserMQInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserMQInstCnt();
            return;
        }
        this.usermqinstcntDirtyFlag = false;
        this.usermqinstcnt = null;
    }

    public void setWorkspaceCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceCnt(n);
            return;
        }
        this.workspacecnt = n;
        this.workspacecntDirtyFlag = true;
    }

    public Integer getWorkspaceCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceCnt();
        }
        return this.workspacecnt;
    }

    public boolean isWorkspaceCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceCntDirty();
        }
        return this.workspacecntDirtyFlag;
    }

    public void resetWorkspaceCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceCnt();
            return;
        }
        this.workspacecntDirtyFlag = false;
        this.workspacecnt = null;
    }

    protected void onReset() {
        PSDCResRepBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCResRepBase pSDCResRepBase) {
        pSDCResRepBase.resetASCnt();
        pSDCResRepBase.resetCodeRepoCnt();
        pSDCResRepBase.resetContent();
        pSDCResRepBase.resetCreateDate();
        pSDCResRepBase.resetCreateMan();
        pSDCResRepBase.resetDBInstCnt();
        pSDCResRepBase.resetDCBalance();
        pSDCResRepBase.resetDefaultFlag();
        pSDCResRepBase.resetDepInstCnt();
        pSDCResRepBase.resetDevSlnCnt();
        pSDCResRepBase.resetDevSysCnt();
        pSDCResRepBase.resetDevTemplCnt();
        pSDCResRepBase.resetDiskSize();
        pSDCResRepBase.resetDiskUsed();
        pSDCResRepBase.resetDynaInstCnt();
        pSDCResRepBase.resetExpiredASCnt();
        pSDCResRepBase.resetExpiredASCnt2();
        pSDCResRepBase.resetExpiredCodeRepoCnt();
        pSDCResRepBase.resetExpiredCodeRepoCnt2();
        pSDCResRepBase.resetExpiredDBInstCnt();
        pSDCResRepBase.resetExpiredDBInstCnt2();
        pSDCResRepBase.resetExpiredMQInstCnt();
        pSDCResRepBase.resetExpiredMQInstCnt2();
        pSDCResRepBase.resetIdleASCnt();
        pSDCResRepBase.resetIdleCodeRepoCnt();
        pSDCResRepBase.resetIdleDBInstCnt();
        pSDCResRepBase.resetIdleMQInstCnt();
        pSDCResRepBase.resetMemo();
        pSDCResRepBase.resetMonthNWFlowSize();
        pSDCResRepBase.resetMonthNWFlowUsed();
        pSDCResRepBase.resetMQInstCnt();
        pSDCResRepBase.resetMSPCnt();
        pSDCResRepBase.resetObj2Cnt();
        pSDCResRepBase.resetObj3Cnt();
        pSDCResRepBase.resetObj4Cnt();
        pSDCResRepBase.resetObjCnt();
        pSDCResRepBase.resetPSDCResRepId();
        pSDCResRepBase.resetPSDCResRepName();
        pSDCResRepBase.resetPSDevCenterId();
        pSDCResRepBase.resetPSDevCenterName();
        pSDCResRepBase.resetReportUrl();
        pSDCResRepBase.resetRepTime();
        pSDCResRepBase.resetRobotCnt();
        pSDCResRepBase.resetSysBakCnt();
        pSDCResRepBase.resetUpdateDate();
        pSDCResRepBase.resetUpdateMan();
        pSDCResRepBase.resetUsedASCnt();
        pSDCResRepBase.resetUsedCodeRepoCnt();
        pSDCResRepBase.resetUsedDBInstCnt();
        pSDCResRepBase.resetUsedMQInstCnt();
        pSDCResRepBase.resetUserASCnt();
        pSDCResRepBase.resetUserCnt();
        pSDCResRepBase.resetUserCodeRepoCnt();
        pSDCResRepBase.resetUserDBInstCnt();
        pSDCResRepBase.resetUserMQInstCnt();
        pSDCResRepBase.resetWorkspaceCnt();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isASCntDirty()) {
            hashMap.put(FIELD_ASCNT, this.getASCnt());
        }
        if (!bl || this.isCodeRepoCntDirty()) {
            hashMap.put(FIELD_CODEREPOCNT, this.getCodeRepoCnt());
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
        if (!bl || this.isDBInstCntDirty()) {
            hashMap.put(FIELD_DBINSTCNT, this.getDBInstCnt());
        }
        if (!bl || this.isDCBalanceDirty()) {
            hashMap.put(FIELD_DCBALANCE, this.getDCBalance());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDepInstCntDirty()) {
            hashMap.put(FIELD_DEPINSTCNT, this.getDepInstCnt());
        }
        if (!bl || this.isDevSlnCntDirty()) {
            hashMap.put(FIELD_DEVSLNCNT, this.getDevSlnCnt());
        }
        if (!bl || this.isDevSysCntDirty()) {
            hashMap.put(FIELD_DEVSYSCNT, this.getDevSysCnt());
        }
        if (!bl || this.isDevTemplCntDirty()) {
            hashMap.put(FIELD_DEVTEMPLCNT, this.getDevTemplCnt());
        }
        if (!bl || this.isDiskSizeDirty()) {
            hashMap.put(FIELD_DISKSIZE, this.getDiskSize());
        }
        if (!bl || this.isDiskUsedDirty()) {
            hashMap.put(FIELD_DISKUSED, this.getDiskUsed());
        }
        if (!bl || this.isDynaInstCntDirty()) {
            hashMap.put(FIELD_DYNAINSTCNT, this.getDynaInstCnt());
        }
        if (!bl || this.isExpiredASCntDirty()) {
            hashMap.put(FIELD_EXPIREDASCNT, this.getExpiredASCnt());
        }
        if (!bl || this.isExpiredASCnt2Dirty()) {
            hashMap.put(FIELD_EXPIREDASCNT2, this.getExpiredASCnt2());
        }
        if (!bl || this.isExpiredCodeRepoCntDirty()) {
            hashMap.put(FIELD_EXPIREDCODEREPOCNT, this.getExpiredCodeRepoCnt());
        }
        if (!bl || this.isExpiredCodeRepoCnt2Dirty()) {
            hashMap.put(FIELD_EXPIREDCODEREPOCNT2, this.getExpiredCodeRepoCnt2());
        }
        if (!bl || this.isExpiredDBInstCntDirty()) {
            hashMap.put(FIELD_EXPIREDDBINSTCNT, this.getExpiredDBInstCnt());
        }
        if (!bl || this.isExpiredDBInstCnt2Dirty()) {
            hashMap.put(FIELD_EXPIREDDBINSTCNT2, this.getExpiredDBInstCnt2());
        }
        if (!bl || this.isExpiredMQInstCntDirty()) {
            hashMap.put(FIELD_EXPIREDMQINSTCNT, this.getExpiredMQInstCnt());
        }
        if (!bl || this.isExpiredMQInstCnt2Dirty()) {
            hashMap.put(FIELD_EXPIREDMQINSTCNT2, this.getExpiredMQInstCnt2());
        }
        if (!bl || this.isIdleASCntDirty()) {
            hashMap.put(FIELD_IDLEASCNT, this.getIdleASCnt());
        }
        if (!bl || this.isIdleCodeRepoCntDirty()) {
            hashMap.put(FIELD_IDLECODEREPOCNT, this.getIdleCodeRepoCnt());
        }
        if (!bl || this.isIdleDBInstCntDirty()) {
            hashMap.put(FIELD_IDLEDBINSTCNT, this.getIdleDBInstCnt());
        }
        if (!bl || this.isIdleMQInstCntDirty()) {
            hashMap.put(FIELD_IDLEMQINSTCNT, this.getIdleMQInstCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMonthNWFlowSizeDirty()) {
            hashMap.put(FIELD_MONTHNWFLOWSIZE, this.getMonthNWFlowSize());
        }
        if (!bl || this.isMonthNWFlowUsedDirty()) {
            hashMap.put(FIELD_MONTHNWFLOWUSED, this.getMonthNWFlowUsed());
        }
        if (!bl || this.isMQInstCntDirty()) {
            hashMap.put(FIELD_MQINSTCNT, this.getMQInstCnt());
        }
        if (!bl || this.isMSPCntDirty()) {
            hashMap.put(FIELD_MSPCNT, this.getMSPCnt());
        }
        if (!bl || this.isObj2CntDirty()) {
            hashMap.put(FIELD_OBJ2CNT, this.getObj2Cnt());
        }
        if (!bl || this.isObj3CntDirty()) {
            hashMap.put(FIELD_OBJ3CNT, this.getObj3Cnt());
        }
        if (!bl || this.isObj4CntDirty()) {
            hashMap.put(FIELD_OBJ4CNT, this.getObj4Cnt());
        }
        if (!bl || this.isObjCntDirty()) {
            hashMap.put(FIELD_OBJCNT, this.getObjCnt());
        }
        if (!bl || this.isPSDCResRepIdDirty()) {
            hashMap.put(FIELD_PSDCRESREPID, this.getPSDCResRepId());
        }
        if (!bl || this.isPSDCResRepNameDirty()) {
            hashMap.put(FIELD_PSDCRESREPNAME, this.getPSDCResRepName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isReportUrlDirty()) {
            hashMap.put(FIELD_REPORTURL, this.getReportUrl());
        }
        if (!bl || this.isRepTimeDirty()) {
            hashMap.put(FIELD_REPTIME, this.getRepTime());
        }
        if (!bl || this.isRobotCntDirty()) {
            hashMap.put(FIELD_ROBOTCNT, this.getRobotCnt());
        }
        if (!bl || this.isSysBakCntDirty()) {
            hashMap.put(FIELD_SYSBAKCNT, this.getSysBakCnt());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsedASCntDirty()) {
            hashMap.put(FIELD_USEDASCNT, this.getUsedASCnt());
        }
        if (!bl || this.isUsedCodeRepoCntDirty()) {
            hashMap.put(FIELD_USEDCODEREPOCNT, this.getUsedCodeRepoCnt());
        }
        if (!bl || this.isUsedDBInstCntDirty()) {
            hashMap.put(FIELD_USEDDBINSTCNT, this.getUsedDBInstCnt());
        }
        if (!bl || this.isUsedMQInstCntDirty()) {
            hashMap.put(FIELD_USEDMQINSTCNT, this.getUsedMQInstCnt());
        }
        if (!bl || this.isUserASCntDirty()) {
            hashMap.put(FIELD_USERASCNT, this.getUserASCnt());
        }
        if (!bl || this.isUserCntDirty()) {
            hashMap.put(FIELD_USERCNT, this.getUserCnt());
        }
        if (!bl || this.isUserCodeRepoCntDirty()) {
            hashMap.put(FIELD_USERCODEREPOCNT, this.getUserCodeRepoCnt());
        }
        if (!bl || this.isUserDBInstCntDirty()) {
            hashMap.put(FIELD_USERDBINSTCNT, this.getUserDBInstCnt());
        }
        if (!bl || this.isUserMQInstCntDirty()) {
            hashMap.put(FIELD_USERMQINSTCNT, this.getUserMQInstCnt());
        }
        if (!bl || this.isWorkspaceCntDirty()) {
            hashMap.put(FIELD_WORKSPACECNT, this.getWorkspaceCnt());
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
        return PSDCResRepBase.get(this, n);
    }

    private static Object get(PSDCResRepBase pSDCResRepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResRepBase.getASCnt();
            }
            case 1: {
                return pSDCResRepBase.getCodeRepoCnt();
            }
            case 2: {
                return pSDCResRepBase.getContent();
            }
            case 3: {
                return pSDCResRepBase.getCreateDate();
            }
            case 4: {
                return pSDCResRepBase.getCreateMan();
            }
            case 5: {
                return pSDCResRepBase.getDBInstCnt();
            }
            case 6: {
                return pSDCResRepBase.getDCBalance();
            }
            case 7: {
                return pSDCResRepBase.getDefaultFlag();
            }
            case 8: {
                return pSDCResRepBase.getDepInstCnt();
            }
            case 9: {
                return pSDCResRepBase.getDevSlnCnt();
            }
            case 10: {
                return pSDCResRepBase.getDevSysCnt();
            }
            case 11: {
                return pSDCResRepBase.getDevTemplCnt();
            }
            case 12: {
                return pSDCResRepBase.getDiskSize();
            }
            case 13: {
                return pSDCResRepBase.getDiskUsed();
            }
            case 14: {
                return pSDCResRepBase.getDynaInstCnt();
            }
            case 15: {
                return pSDCResRepBase.getExpiredASCnt();
            }
            case 16: {
                return pSDCResRepBase.getExpiredASCnt2();
            }
            case 17: {
                return pSDCResRepBase.getExpiredCodeRepoCnt();
            }
            case 18: {
                return pSDCResRepBase.getExpiredCodeRepoCnt2();
            }
            case 19: {
                return pSDCResRepBase.getExpiredDBInstCnt();
            }
            case 20: {
                return pSDCResRepBase.getExpiredDBInstCnt2();
            }
            case 21: {
                return pSDCResRepBase.getExpiredMQInstCnt();
            }
            case 22: {
                return pSDCResRepBase.getExpiredMQInstCnt2();
            }
            case 23: {
                return pSDCResRepBase.getIdleASCnt();
            }
            case 24: {
                return pSDCResRepBase.getIdleCodeRepoCnt();
            }
            case 25: {
                return pSDCResRepBase.getIdleDBInstCnt();
            }
            case 26: {
                return pSDCResRepBase.getIdleMQInstCnt();
            }
            case 27: {
                return pSDCResRepBase.getMemo();
            }
            case 28: {
                return pSDCResRepBase.getMonthNWFlowSize();
            }
            case 29: {
                return pSDCResRepBase.getMonthNWFlowUsed();
            }
            case 30: {
                return pSDCResRepBase.getMQInstCnt();
            }
            case 31: {
                return pSDCResRepBase.getMSPCnt();
            }
            case 32: {
                return pSDCResRepBase.getObj2Cnt();
            }
            case 33: {
                return pSDCResRepBase.getObj3Cnt();
            }
            case 34: {
                return pSDCResRepBase.getObj4Cnt();
            }
            case 35: {
                return pSDCResRepBase.getObjCnt();
            }
            case 36: {
                return pSDCResRepBase.getPSDCResRepId();
            }
            case 37: {
                return pSDCResRepBase.getPSDCResRepName();
            }
            case 38: {
                return pSDCResRepBase.getPSDevCenterId();
            }
            case 39: {
                return pSDCResRepBase.getPSDevCenterName();
            }
            case 40: {
                return pSDCResRepBase.getReportUrl();
            }
            case 41: {
                return pSDCResRepBase.getRepTime();
            }
            case 42: {
                return pSDCResRepBase.getRobotCnt();
            }
            case 43: {
                return pSDCResRepBase.getSysBakCnt();
            }
            case 44: {
                return pSDCResRepBase.getUpdateDate();
            }
            case 45: {
                return pSDCResRepBase.getUpdateMan();
            }
            case 46: {
                return pSDCResRepBase.getUsedASCnt();
            }
            case 47: {
                return pSDCResRepBase.getUsedCodeRepoCnt();
            }
            case 48: {
                return pSDCResRepBase.getUsedDBInstCnt();
            }
            case 49: {
                return pSDCResRepBase.getUsedMQInstCnt();
            }
            case 50: {
                return pSDCResRepBase.getUserASCnt();
            }
            case 51: {
                return pSDCResRepBase.getUserCnt();
            }
            case 52: {
                return pSDCResRepBase.getUserCodeRepoCnt();
            }
            case 53: {
                return pSDCResRepBase.getUserDBInstCnt();
            }
            case 54: {
                return pSDCResRepBase.getUserMQInstCnt();
            }
            case 55: {
                return pSDCResRepBase.getWorkspaceCnt();
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
        PSDCResRepBase.set(this, n, object);
    }

    private static void set(PSDCResRepBase pSDCResRepBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCResRepBase.setASCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDCResRepBase.setCodeRepoCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDCResRepBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCResRepBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCResRepBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCResRepBase.setDBInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCResRepBase.setDCBalance(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 7: {
                pSDCResRepBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCResRepBase.setDepInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCResRepBase.setDevSlnCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDCResRepBase.setDevSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDCResRepBase.setDevTemplCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDCResRepBase.setDiskSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDCResRepBase.setDiskUsed(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDCResRepBase.setDynaInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDCResRepBase.setExpiredASCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDCResRepBase.setExpiredASCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDCResRepBase.setExpiredCodeRepoCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDCResRepBase.setExpiredCodeRepoCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDCResRepBase.setExpiredDBInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDCResRepBase.setExpiredDBInstCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDCResRepBase.setExpiredMQInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDCResRepBase.setExpiredMQInstCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDCResRepBase.setIdleASCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDCResRepBase.setIdleCodeRepoCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDCResRepBase.setIdleDBInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDCResRepBase.setIdleMQInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDCResRepBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCResRepBase.setMonthNWFlowSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDCResRepBase.setMonthNWFlowUsed(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDCResRepBase.setMQInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDCResRepBase.setMSPCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDCResRepBase.setObj2Cnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDCResRepBase.setObj3Cnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDCResRepBase.setObj4Cnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDCResRepBase.setObjCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDCResRepBase.setPSDCResRepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDCResRepBase.setPSDCResRepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDCResRepBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDCResRepBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDCResRepBase.setReportUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDCResRepBase.setRepTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSDCResRepBase.setRobotCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDCResRepBase.setSysBakCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDCResRepBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 45: {
                pSDCResRepBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDCResRepBase.setUsedASCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSDCResRepBase.setUsedCodeRepoCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSDCResRepBase.setUsedDBInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 49: {
                pSDCResRepBase.setUsedMQInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 50: {
                pSDCResRepBase.setUserASCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSDCResRepBase.setUserCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 52: {
                pSDCResRepBase.setUserCodeRepoCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSDCResRepBase.setUserDBInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSDCResRepBase.setUserMQInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSDCResRepBase.setWorkspaceCnt(DataObject.getIntegerValue((Object)object));
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
        return PSDCResRepBase.isNull(this, n);
    }

    private static boolean isNull(PSDCResRepBase pSDCResRepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResRepBase.getASCnt() == null;
            }
            case 1: {
                return pSDCResRepBase.getCodeRepoCnt() == null;
            }
            case 2: {
                return pSDCResRepBase.getContent() == null;
            }
            case 3: {
                return pSDCResRepBase.getCreateDate() == null;
            }
            case 4: {
                return pSDCResRepBase.getCreateMan() == null;
            }
            case 5: {
                return pSDCResRepBase.getDBInstCnt() == null;
            }
            case 6: {
                return pSDCResRepBase.getDCBalance() == null;
            }
            case 7: {
                return pSDCResRepBase.getDefaultFlag() == null;
            }
            case 8: {
                return pSDCResRepBase.getDepInstCnt() == null;
            }
            case 9: {
                return pSDCResRepBase.getDevSlnCnt() == null;
            }
            case 10: {
                return pSDCResRepBase.getDevSysCnt() == null;
            }
            case 11: {
                return pSDCResRepBase.getDevTemplCnt() == null;
            }
            case 12: {
                return pSDCResRepBase.getDiskSize() == null;
            }
            case 13: {
                return pSDCResRepBase.getDiskUsed() == null;
            }
            case 14: {
                return pSDCResRepBase.getDynaInstCnt() == null;
            }
            case 15: {
                return pSDCResRepBase.getExpiredASCnt() == null;
            }
            case 16: {
                return pSDCResRepBase.getExpiredASCnt2() == null;
            }
            case 17: {
                return pSDCResRepBase.getExpiredCodeRepoCnt() == null;
            }
            case 18: {
                return pSDCResRepBase.getExpiredCodeRepoCnt2() == null;
            }
            case 19: {
                return pSDCResRepBase.getExpiredDBInstCnt() == null;
            }
            case 20: {
                return pSDCResRepBase.getExpiredDBInstCnt2() == null;
            }
            case 21: {
                return pSDCResRepBase.getExpiredMQInstCnt() == null;
            }
            case 22: {
                return pSDCResRepBase.getExpiredMQInstCnt2() == null;
            }
            case 23: {
                return pSDCResRepBase.getIdleASCnt() == null;
            }
            case 24: {
                return pSDCResRepBase.getIdleCodeRepoCnt() == null;
            }
            case 25: {
                return pSDCResRepBase.getIdleDBInstCnt() == null;
            }
            case 26: {
                return pSDCResRepBase.getIdleMQInstCnt() == null;
            }
            case 27: {
                return pSDCResRepBase.getMemo() == null;
            }
            case 28: {
                return pSDCResRepBase.getMonthNWFlowSize() == null;
            }
            case 29: {
                return pSDCResRepBase.getMonthNWFlowUsed() == null;
            }
            case 30: {
                return pSDCResRepBase.getMQInstCnt() == null;
            }
            case 31: {
                return pSDCResRepBase.getMSPCnt() == null;
            }
            case 32: {
                return pSDCResRepBase.getObj2Cnt() == null;
            }
            case 33: {
                return pSDCResRepBase.getObj3Cnt() == null;
            }
            case 34: {
                return pSDCResRepBase.getObj4Cnt() == null;
            }
            case 35: {
                return pSDCResRepBase.getObjCnt() == null;
            }
            case 36: {
                return pSDCResRepBase.getPSDCResRepId() == null;
            }
            case 37: {
                return pSDCResRepBase.getPSDCResRepName() == null;
            }
            case 38: {
                return pSDCResRepBase.getPSDevCenterId() == null;
            }
            case 39: {
                return pSDCResRepBase.getPSDevCenterName() == null;
            }
            case 40: {
                return pSDCResRepBase.getReportUrl() == null;
            }
            case 41: {
                return pSDCResRepBase.getRepTime() == null;
            }
            case 42: {
                return pSDCResRepBase.getRobotCnt() == null;
            }
            case 43: {
                return pSDCResRepBase.getSysBakCnt() == null;
            }
            case 44: {
                return pSDCResRepBase.getUpdateDate() == null;
            }
            case 45: {
                return pSDCResRepBase.getUpdateMan() == null;
            }
            case 46: {
                return pSDCResRepBase.getUsedASCnt() == null;
            }
            case 47: {
                return pSDCResRepBase.getUsedCodeRepoCnt() == null;
            }
            case 48: {
                return pSDCResRepBase.getUsedDBInstCnt() == null;
            }
            case 49: {
                return pSDCResRepBase.getUsedMQInstCnt() == null;
            }
            case 50: {
                return pSDCResRepBase.getUserASCnt() == null;
            }
            case 51: {
                return pSDCResRepBase.getUserCnt() == null;
            }
            case 52: {
                return pSDCResRepBase.getUserCodeRepoCnt() == null;
            }
            case 53: {
                return pSDCResRepBase.getUserDBInstCnt() == null;
            }
            case 54: {
                return pSDCResRepBase.getUserMQInstCnt() == null;
            }
            case 55: {
                return pSDCResRepBase.getWorkspaceCnt() == null;
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
        return PSDCResRepBase.contains(this, n);
    }

    private static boolean contains(PSDCResRepBase pSDCResRepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResRepBase.isASCntDirty();
            }
            case 1: {
                return pSDCResRepBase.isCodeRepoCntDirty();
            }
            case 2: {
                return pSDCResRepBase.isContentDirty();
            }
            case 3: {
                return pSDCResRepBase.isCreateDateDirty();
            }
            case 4: {
                return pSDCResRepBase.isCreateManDirty();
            }
            case 5: {
                return pSDCResRepBase.isDBInstCntDirty();
            }
            case 6: {
                return pSDCResRepBase.isDCBalanceDirty();
            }
            case 7: {
                return pSDCResRepBase.isDefaultFlagDirty();
            }
            case 8: {
                return pSDCResRepBase.isDepInstCntDirty();
            }
            case 9: {
                return pSDCResRepBase.isDevSlnCntDirty();
            }
            case 10: {
                return pSDCResRepBase.isDevSysCntDirty();
            }
            case 11: {
                return pSDCResRepBase.isDevTemplCntDirty();
            }
            case 12: {
                return pSDCResRepBase.isDiskSizeDirty();
            }
            case 13: {
                return pSDCResRepBase.isDiskUsedDirty();
            }
            case 14: {
                return pSDCResRepBase.isDynaInstCntDirty();
            }
            case 15: {
                return pSDCResRepBase.isExpiredASCntDirty();
            }
            case 16: {
                return pSDCResRepBase.isExpiredASCnt2Dirty();
            }
            case 17: {
                return pSDCResRepBase.isExpiredCodeRepoCntDirty();
            }
            case 18: {
                return pSDCResRepBase.isExpiredCodeRepoCnt2Dirty();
            }
            case 19: {
                return pSDCResRepBase.isExpiredDBInstCntDirty();
            }
            case 20: {
                return pSDCResRepBase.isExpiredDBInstCnt2Dirty();
            }
            case 21: {
                return pSDCResRepBase.isExpiredMQInstCntDirty();
            }
            case 22: {
                return pSDCResRepBase.isExpiredMQInstCnt2Dirty();
            }
            case 23: {
                return pSDCResRepBase.isIdleASCntDirty();
            }
            case 24: {
                return pSDCResRepBase.isIdleCodeRepoCntDirty();
            }
            case 25: {
                return pSDCResRepBase.isIdleDBInstCntDirty();
            }
            case 26: {
                return pSDCResRepBase.isIdleMQInstCntDirty();
            }
            case 27: {
                return pSDCResRepBase.isMemoDirty();
            }
            case 28: {
                return pSDCResRepBase.isMonthNWFlowSizeDirty();
            }
            case 29: {
                return pSDCResRepBase.isMonthNWFlowUsedDirty();
            }
            case 30: {
                return pSDCResRepBase.isMQInstCntDirty();
            }
            case 31: {
                return pSDCResRepBase.isMSPCntDirty();
            }
            case 32: {
                return pSDCResRepBase.isObj2CntDirty();
            }
            case 33: {
                return pSDCResRepBase.isObj3CntDirty();
            }
            case 34: {
                return pSDCResRepBase.isObj4CntDirty();
            }
            case 35: {
                return pSDCResRepBase.isObjCntDirty();
            }
            case 36: {
                return pSDCResRepBase.isPSDCResRepIdDirty();
            }
            case 37: {
                return pSDCResRepBase.isPSDCResRepNameDirty();
            }
            case 38: {
                return pSDCResRepBase.isPSDevCenterIdDirty();
            }
            case 39: {
                return pSDCResRepBase.isPSDevCenterNameDirty();
            }
            case 40: {
                return pSDCResRepBase.isReportUrlDirty();
            }
            case 41: {
                return pSDCResRepBase.isRepTimeDirty();
            }
            case 42: {
                return pSDCResRepBase.isRobotCntDirty();
            }
            case 43: {
                return pSDCResRepBase.isSysBakCntDirty();
            }
            case 44: {
                return pSDCResRepBase.isUpdateDateDirty();
            }
            case 45: {
                return pSDCResRepBase.isUpdateManDirty();
            }
            case 46: {
                return pSDCResRepBase.isUsedASCntDirty();
            }
            case 47: {
                return pSDCResRepBase.isUsedCodeRepoCntDirty();
            }
            case 48: {
                return pSDCResRepBase.isUsedDBInstCntDirty();
            }
            case 49: {
                return pSDCResRepBase.isUsedMQInstCntDirty();
            }
            case 50: {
                return pSDCResRepBase.isUserASCntDirty();
            }
            case 51: {
                return pSDCResRepBase.isUserCntDirty();
            }
            case 52: {
                return pSDCResRepBase.isUserCodeRepoCntDirty();
            }
            case 53: {
                return pSDCResRepBase.isUserDBInstCntDirty();
            }
            case 54: {
                return pSDCResRepBase.isUserMQInstCntDirty();
            }
            case 55: {
                return pSDCResRepBase.isWorkspaceCntDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCResRepBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCResRepBase pSDCResRepBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCResRepBase.getASCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ascnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getASCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getCodeRepoCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"coderepocnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getCodeRepoCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getContent()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDBInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDBInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDCBalance() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcbalance", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDCBalance()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDepInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDepInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDevSlnCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devslncnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDevSlnCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDevSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devsyscnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDevSysCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDevTemplCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devtemplcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDevTemplCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDiskSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"disksize", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDiskSize()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDiskUsed() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"diskused", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDiskUsed()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getDynaInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getDynaInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getExpiredASCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredascnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getExpiredASCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getExpiredASCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredascnt2", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getExpiredASCnt2()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getExpiredCodeRepoCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredcoderepocnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getExpiredCodeRepoCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getExpiredCodeRepoCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredcoderepocnt2", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getExpiredCodeRepoCnt2()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getExpiredDBInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expireddbinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getExpiredDBInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getExpiredDBInstCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expireddbinstcnt2", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getExpiredDBInstCnt2()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getExpiredMQInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredmqinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getExpiredMQInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getExpiredMQInstCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredmqinstcnt2", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getExpiredMQInstCnt2()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getIdleASCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"idleascnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getIdleASCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getIdleCodeRepoCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"idlecoderepocnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getIdleCodeRepoCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getIdleDBInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"idledbinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getIdleDBInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getIdleMQInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"idlemqinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getIdleMQInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getMonthNWFlowSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"monthnwflowsize", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getMonthNWFlowSize()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getMonthNWFlowUsed() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"monthnwflowused", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getMonthNWFlowUsed()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getMQInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mqinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getMQInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getMSPCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mspcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getMSPCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getObj2Cnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"obj2cnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getObj2Cnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getObj3Cnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"obj3cnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getObj3Cnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getObj4Cnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"obj4cnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getObj4Cnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getObjCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getObjCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getPSDCResRepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcresrepid", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getPSDCResRepId()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getPSDCResRepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcresrepname", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getPSDCResRepName()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getReportUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reporturl", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getReportUrl()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getRepTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reptime", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getRepTime()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getRobotCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getRobotCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getSysBakCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysbakcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getSysBakCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUsedASCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedascnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUsedASCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUsedCodeRepoCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedcoderepocnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUsedCodeRepoCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUsedDBInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"useddbinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUsedDBInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUsedMQInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedmqinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUsedMQInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUserASCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userascnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUserASCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUserCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUserCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUserCodeRepoCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercoderepocnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUserCodeRepoCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUserDBInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdbinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUserDBInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getUserMQInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usermqinstcnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getUserMQInstCnt()), (boolean)false);
        }
        if (bl || pSDCResRepBase.getWorkspaceCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspacecnt", (Object)PSDCResRepBase.getJSONValue((Object)pSDCResRepBase.getWorkspaceCnt()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCResRepBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCResRepBase pSDCResRepBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCResRepBase.getASCnt() != null) {
            object = pSDCResRepBase.getASCnt();
            xmlNode.setAttribute(FIELD_ASCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getCodeRepoCnt() != null) {
            object = pSDCResRepBase.getCodeRepoCnt();
            xmlNode.setAttribute(FIELD_CODEREPOCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getContent() != null) {
            object = pSDCResRepBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getCreateDate() != null) {
            object = pSDCResRepBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResRepBase.getCreateMan() != null) {
            object = pSDCResRepBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getDBInstCnt() != null) {
            object = pSDCResRepBase.getDBInstCnt();
            xmlNode.setAttribute(FIELD_DBINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDCBalance() != null) {
            object = pSDCResRepBase.getDCBalance();
            xmlNode.setAttribute(FIELD_DCBALANCE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDefaultFlag() != null) {
            object = pSDCResRepBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDepInstCnt() != null) {
            object = pSDCResRepBase.getDepInstCnt();
            xmlNode.setAttribute(FIELD_DEPINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDevSlnCnt() != null) {
            object = pSDCResRepBase.getDevSlnCnt();
            xmlNode.setAttribute(FIELD_DEVSLNCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDevSysCnt() != null) {
            object = pSDCResRepBase.getDevSysCnt();
            xmlNode.setAttribute(FIELD_DEVSYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDevTemplCnt() != null) {
            object = pSDCResRepBase.getDevTemplCnt();
            xmlNode.setAttribute(FIELD_DEVTEMPLCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDiskSize() != null) {
            object = pSDCResRepBase.getDiskSize();
            xmlNode.setAttribute(FIELD_DISKSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDiskUsed() != null) {
            object = pSDCResRepBase.getDiskUsed();
            xmlNode.setAttribute(FIELD_DISKUSED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getDynaInstCnt() != null) {
            object = pSDCResRepBase.getDynaInstCnt();
            xmlNode.setAttribute(FIELD_DYNAINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getExpiredASCnt() != null) {
            object = pSDCResRepBase.getExpiredASCnt();
            xmlNode.setAttribute(FIELD_EXPIREDASCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getExpiredASCnt2() != null) {
            object = pSDCResRepBase.getExpiredASCnt2();
            xmlNode.setAttribute(FIELD_EXPIREDASCNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getExpiredCodeRepoCnt() != null) {
            object = pSDCResRepBase.getExpiredCodeRepoCnt();
            xmlNode.setAttribute(FIELD_EXPIREDCODEREPOCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getExpiredCodeRepoCnt2() != null) {
            object = pSDCResRepBase.getExpiredCodeRepoCnt2();
            xmlNode.setAttribute(FIELD_EXPIREDCODEREPOCNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getExpiredDBInstCnt() != null) {
            object = pSDCResRepBase.getExpiredDBInstCnt();
            xmlNode.setAttribute(FIELD_EXPIREDDBINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getExpiredDBInstCnt2() != null) {
            object = pSDCResRepBase.getExpiredDBInstCnt2();
            xmlNode.setAttribute(FIELD_EXPIREDDBINSTCNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getExpiredMQInstCnt() != null) {
            object = pSDCResRepBase.getExpiredMQInstCnt();
            xmlNode.setAttribute(FIELD_EXPIREDMQINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getExpiredMQInstCnt2() != null) {
            object = pSDCResRepBase.getExpiredMQInstCnt2();
            xmlNode.setAttribute(FIELD_EXPIREDMQINSTCNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getIdleASCnt() != null) {
            object = pSDCResRepBase.getIdleASCnt();
            xmlNode.setAttribute(FIELD_IDLEASCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getIdleCodeRepoCnt() != null) {
            object = pSDCResRepBase.getIdleCodeRepoCnt();
            xmlNode.setAttribute(FIELD_IDLECODEREPOCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getIdleDBInstCnt() != null) {
            object = pSDCResRepBase.getIdleDBInstCnt();
            xmlNode.setAttribute(FIELD_IDLEDBINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getIdleMQInstCnt() != null) {
            object = pSDCResRepBase.getIdleMQInstCnt();
            xmlNode.setAttribute(FIELD_IDLEMQINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getMemo() != null) {
            object = pSDCResRepBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getMonthNWFlowSize() != null) {
            object = pSDCResRepBase.getMonthNWFlowSize();
            xmlNode.setAttribute(FIELD_MONTHNWFLOWSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getMonthNWFlowUsed() != null) {
            object = pSDCResRepBase.getMonthNWFlowUsed();
            xmlNode.setAttribute(FIELD_MONTHNWFLOWUSED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getMQInstCnt() != null) {
            object = pSDCResRepBase.getMQInstCnt();
            xmlNode.setAttribute(FIELD_MQINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getMSPCnt() != null) {
            object = pSDCResRepBase.getMSPCnt();
            xmlNode.setAttribute(FIELD_MSPCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getObj2Cnt() != null) {
            object = pSDCResRepBase.getObj2Cnt();
            xmlNode.setAttribute(FIELD_OBJ2CNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getObj3Cnt() != null) {
            object = pSDCResRepBase.getObj3Cnt();
            xmlNode.setAttribute(FIELD_OBJ3CNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getObj4Cnt() != null) {
            object = pSDCResRepBase.getObj4Cnt();
            xmlNode.setAttribute(FIELD_OBJ4CNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getObjCnt() != null) {
            object = pSDCResRepBase.getObjCnt();
            xmlNode.setAttribute(FIELD_OBJCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getPSDCResRepId() != null) {
            object = pSDCResRepBase.getPSDCResRepId();
            xmlNode.setAttribute(FIELD_PSDCRESREPID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getPSDCResRepName() != null) {
            object = pSDCResRepBase.getPSDCResRepName();
            xmlNode.setAttribute(FIELD_PSDCRESREPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getPSDevCenterId() != null) {
            object = pSDCResRepBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getPSDevCenterName() != null) {
            object = pSDCResRepBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getReportUrl() != null) {
            object = pSDCResRepBase.getReportUrl();
            xmlNode.setAttribute(FIELD_REPORTURL, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getRepTime() != null) {
            object = pSDCResRepBase.getRepTime();
            xmlNode.setAttribute(FIELD_REPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResRepBase.getRobotCnt() != null) {
            object = pSDCResRepBase.getRobotCnt();
            xmlNode.setAttribute(FIELD_ROBOTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getSysBakCnt() != null) {
            object = pSDCResRepBase.getSysBakCnt();
            xmlNode.setAttribute(FIELD_SYSBAKCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUpdateDate() != null) {
            object = pSDCResRepBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResRepBase.getUpdateMan() != null) {
            object = pSDCResRepBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCResRepBase.getUsedASCnt() != null) {
            object = pSDCResRepBase.getUsedASCnt();
            xmlNode.setAttribute(FIELD_USEDASCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUsedCodeRepoCnt() != null) {
            object = pSDCResRepBase.getUsedCodeRepoCnt();
            xmlNode.setAttribute(FIELD_USEDCODEREPOCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUsedDBInstCnt() != null) {
            object = pSDCResRepBase.getUsedDBInstCnt();
            xmlNode.setAttribute(FIELD_USEDDBINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUsedMQInstCnt() != null) {
            object = pSDCResRepBase.getUsedMQInstCnt();
            xmlNode.setAttribute(FIELD_USEDMQINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUserASCnt() != null) {
            object = pSDCResRepBase.getUserASCnt();
            xmlNode.setAttribute(FIELD_USERASCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUserCnt() != null) {
            object = pSDCResRepBase.getUserCnt();
            xmlNode.setAttribute(FIELD_USERCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUserCodeRepoCnt() != null) {
            object = pSDCResRepBase.getUserCodeRepoCnt();
            xmlNode.setAttribute(FIELD_USERCODEREPOCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUserDBInstCnt() != null) {
            object = pSDCResRepBase.getUserDBInstCnt();
            xmlNode.setAttribute(FIELD_USERDBINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getUserMQInstCnt() != null) {
            object = pSDCResRepBase.getUserMQInstCnt();
            xmlNode.setAttribute(FIELD_USERMQINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResRepBase.getWorkspaceCnt() != null) {
            object = pSDCResRepBase.getWorkspaceCnt();
            xmlNode.setAttribute(FIELD_WORKSPACECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCResRepBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCResRepBase pSDCResRepBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCResRepBase.isASCntDirty() && (bl || pSDCResRepBase.getASCnt() != null)) {
            iDataObject.set(FIELD_ASCNT, (Object)pSDCResRepBase.getASCnt());
        }
        if (pSDCResRepBase.isCodeRepoCntDirty() && (bl || pSDCResRepBase.getCodeRepoCnt() != null)) {
            iDataObject.set(FIELD_CODEREPOCNT, (Object)pSDCResRepBase.getCodeRepoCnt());
        }
        if (pSDCResRepBase.isContentDirty() && (bl || pSDCResRepBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDCResRepBase.getContent());
        }
        if (pSDCResRepBase.isCreateDateDirty() && (bl || pSDCResRepBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCResRepBase.getCreateDate());
        }
        if (pSDCResRepBase.isCreateManDirty() && (bl || pSDCResRepBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCResRepBase.getCreateMan());
        }
        if (pSDCResRepBase.isDBInstCntDirty() && (bl || pSDCResRepBase.getDBInstCnt() != null)) {
            iDataObject.set(FIELD_DBINSTCNT, (Object)pSDCResRepBase.getDBInstCnt());
        }
        if (pSDCResRepBase.isDCBalanceDirty() && (bl || pSDCResRepBase.getDCBalance() != null)) {
            iDataObject.set(FIELD_DCBALANCE, (Object)pSDCResRepBase.getDCBalance());
        }
        if (pSDCResRepBase.isDefaultFlagDirty() && (bl || pSDCResRepBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDCResRepBase.getDefaultFlag());
        }
        if (pSDCResRepBase.isDepInstCntDirty() && (bl || pSDCResRepBase.getDepInstCnt() != null)) {
            iDataObject.set(FIELD_DEPINSTCNT, (Object)pSDCResRepBase.getDepInstCnt());
        }
        if (pSDCResRepBase.isDevSlnCntDirty() && (bl || pSDCResRepBase.getDevSlnCnt() != null)) {
            iDataObject.set(FIELD_DEVSLNCNT, (Object)pSDCResRepBase.getDevSlnCnt());
        }
        if (pSDCResRepBase.isDevSysCntDirty() && (bl || pSDCResRepBase.getDevSysCnt() != null)) {
            iDataObject.set(FIELD_DEVSYSCNT, (Object)pSDCResRepBase.getDevSysCnt());
        }
        if (pSDCResRepBase.isDevTemplCntDirty() && (bl || pSDCResRepBase.getDevTemplCnt() != null)) {
            iDataObject.set(FIELD_DEVTEMPLCNT, (Object)pSDCResRepBase.getDevTemplCnt());
        }
        if (pSDCResRepBase.isDiskSizeDirty() && (bl || pSDCResRepBase.getDiskSize() != null)) {
            iDataObject.set(FIELD_DISKSIZE, (Object)pSDCResRepBase.getDiskSize());
        }
        if (pSDCResRepBase.isDiskUsedDirty() && (bl || pSDCResRepBase.getDiskUsed() != null)) {
            iDataObject.set(FIELD_DISKUSED, (Object)pSDCResRepBase.getDiskUsed());
        }
        if (pSDCResRepBase.isDynaInstCntDirty() && (bl || pSDCResRepBase.getDynaInstCnt() != null)) {
            iDataObject.set(FIELD_DYNAINSTCNT, (Object)pSDCResRepBase.getDynaInstCnt());
        }
        if (pSDCResRepBase.isExpiredASCntDirty() && (bl || pSDCResRepBase.getExpiredASCnt() != null)) {
            iDataObject.set(FIELD_EXPIREDASCNT, (Object)pSDCResRepBase.getExpiredASCnt());
        }
        if (pSDCResRepBase.isExpiredASCnt2Dirty() && (bl || pSDCResRepBase.getExpiredASCnt2() != null)) {
            iDataObject.set(FIELD_EXPIREDASCNT2, (Object)pSDCResRepBase.getExpiredASCnt2());
        }
        if (pSDCResRepBase.isExpiredCodeRepoCntDirty() && (bl || pSDCResRepBase.getExpiredCodeRepoCnt() != null)) {
            iDataObject.set(FIELD_EXPIREDCODEREPOCNT, (Object)pSDCResRepBase.getExpiredCodeRepoCnt());
        }
        if (pSDCResRepBase.isExpiredCodeRepoCnt2Dirty() && (bl || pSDCResRepBase.getExpiredCodeRepoCnt2() != null)) {
            iDataObject.set(FIELD_EXPIREDCODEREPOCNT2, (Object)pSDCResRepBase.getExpiredCodeRepoCnt2());
        }
        if (pSDCResRepBase.isExpiredDBInstCntDirty() && (bl || pSDCResRepBase.getExpiredDBInstCnt() != null)) {
            iDataObject.set(FIELD_EXPIREDDBINSTCNT, (Object)pSDCResRepBase.getExpiredDBInstCnt());
        }
        if (pSDCResRepBase.isExpiredDBInstCnt2Dirty() && (bl || pSDCResRepBase.getExpiredDBInstCnt2() != null)) {
            iDataObject.set(FIELD_EXPIREDDBINSTCNT2, (Object)pSDCResRepBase.getExpiredDBInstCnt2());
        }
        if (pSDCResRepBase.isExpiredMQInstCntDirty() && (bl || pSDCResRepBase.getExpiredMQInstCnt() != null)) {
            iDataObject.set(FIELD_EXPIREDMQINSTCNT, (Object)pSDCResRepBase.getExpiredMQInstCnt());
        }
        if (pSDCResRepBase.isExpiredMQInstCnt2Dirty() && (bl || pSDCResRepBase.getExpiredMQInstCnt2() != null)) {
            iDataObject.set(FIELD_EXPIREDMQINSTCNT2, (Object)pSDCResRepBase.getExpiredMQInstCnt2());
        }
        if (pSDCResRepBase.isIdleASCntDirty() && (bl || pSDCResRepBase.getIdleASCnt() != null)) {
            iDataObject.set(FIELD_IDLEASCNT, (Object)pSDCResRepBase.getIdleASCnt());
        }
        if (pSDCResRepBase.isIdleCodeRepoCntDirty() && (bl || pSDCResRepBase.getIdleCodeRepoCnt() != null)) {
            iDataObject.set(FIELD_IDLECODEREPOCNT, (Object)pSDCResRepBase.getIdleCodeRepoCnt());
        }
        if (pSDCResRepBase.isIdleDBInstCntDirty() && (bl || pSDCResRepBase.getIdleDBInstCnt() != null)) {
            iDataObject.set(FIELD_IDLEDBINSTCNT, (Object)pSDCResRepBase.getIdleDBInstCnt());
        }
        if (pSDCResRepBase.isIdleMQInstCntDirty() && (bl || pSDCResRepBase.getIdleMQInstCnt() != null)) {
            iDataObject.set(FIELD_IDLEMQINSTCNT, (Object)pSDCResRepBase.getIdleMQInstCnt());
        }
        if (pSDCResRepBase.isMemoDirty() && (bl || pSDCResRepBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCResRepBase.getMemo());
        }
        if (pSDCResRepBase.isMonthNWFlowSizeDirty() && (bl || pSDCResRepBase.getMonthNWFlowSize() != null)) {
            iDataObject.set(FIELD_MONTHNWFLOWSIZE, (Object)pSDCResRepBase.getMonthNWFlowSize());
        }
        if (pSDCResRepBase.isMonthNWFlowUsedDirty() && (bl || pSDCResRepBase.getMonthNWFlowUsed() != null)) {
            iDataObject.set(FIELD_MONTHNWFLOWUSED, (Object)pSDCResRepBase.getMonthNWFlowUsed());
        }
        if (pSDCResRepBase.isMQInstCntDirty() && (bl || pSDCResRepBase.getMQInstCnt() != null)) {
            iDataObject.set(FIELD_MQINSTCNT, (Object)pSDCResRepBase.getMQInstCnt());
        }
        if (pSDCResRepBase.isMSPCntDirty() && (bl || pSDCResRepBase.getMSPCnt() != null)) {
            iDataObject.set(FIELD_MSPCNT, (Object)pSDCResRepBase.getMSPCnt());
        }
        if (pSDCResRepBase.isObj2CntDirty() && (bl || pSDCResRepBase.getObj2Cnt() != null)) {
            iDataObject.set(FIELD_OBJ2CNT, (Object)pSDCResRepBase.getObj2Cnt());
        }
        if (pSDCResRepBase.isObj3CntDirty() && (bl || pSDCResRepBase.getObj3Cnt() != null)) {
            iDataObject.set(FIELD_OBJ3CNT, (Object)pSDCResRepBase.getObj3Cnt());
        }
        if (pSDCResRepBase.isObj4CntDirty() && (bl || pSDCResRepBase.getObj4Cnt() != null)) {
            iDataObject.set(FIELD_OBJ4CNT, (Object)pSDCResRepBase.getObj4Cnt());
        }
        if (pSDCResRepBase.isObjCntDirty() && (bl || pSDCResRepBase.getObjCnt() != null)) {
            iDataObject.set(FIELD_OBJCNT, (Object)pSDCResRepBase.getObjCnt());
        }
        if (pSDCResRepBase.isPSDCResRepIdDirty() && (bl || pSDCResRepBase.getPSDCResRepId() != null)) {
            iDataObject.set(FIELD_PSDCRESREPID, (Object)pSDCResRepBase.getPSDCResRepId());
        }
        if (pSDCResRepBase.isPSDCResRepNameDirty() && (bl || pSDCResRepBase.getPSDCResRepName() != null)) {
            iDataObject.set(FIELD_PSDCRESREPNAME, (Object)pSDCResRepBase.getPSDCResRepName());
        }
        if (pSDCResRepBase.isPSDevCenterIdDirty() && (bl || pSDCResRepBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCResRepBase.getPSDevCenterId());
        }
        if (pSDCResRepBase.isPSDevCenterNameDirty() && (bl || pSDCResRepBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCResRepBase.getPSDevCenterName());
        }
        if (pSDCResRepBase.isReportUrlDirty() && (bl || pSDCResRepBase.getReportUrl() != null)) {
            iDataObject.set(FIELD_REPORTURL, (Object)pSDCResRepBase.getReportUrl());
        }
        if (pSDCResRepBase.isRepTimeDirty() && (bl || pSDCResRepBase.getRepTime() != null)) {
            iDataObject.set(FIELD_REPTIME, (Object)pSDCResRepBase.getRepTime());
        }
        if (pSDCResRepBase.isRobotCntDirty() && (bl || pSDCResRepBase.getRobotCnt() != null)) {
            iDataObject.set(FIELD_ROBOTCNT, (Object)pSDCResRepBase.getRobotCnt());
        }
        if (pSDCResRepBase.isSysBakCntDirty() && (bl || pSDCResRepBase.getSysBakCnt() != null)) {
            iDataObject.set(FIELD_SYSBAKCNT, (Object)pSDCResRepBase.getSysBakCnt());
        }
        if (pSDCResRepBase.isUpdateDateDirty() && (bl || pSDCResRepBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCResRepBase.getUpdateDate());
        }
        if (pSDCResRepBase.isUpdateManDirty() && (bl || pSDCResRepBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCResRepBase.getUpdateMan());
        }
        if (pSDCResRepBase.isUsedASCntDirty() && (bl || pSDCResRepBase.getUsedASCnt() != null)) {
            iDataObject.set(FIELD_USEDASCNT, (Object)pSDCResRepBase.getUsedASCnt());
        }
        if (pSDCResRepBase.isUsedCodeRepoCntDirty() && (bl || pSDCResRepBase.getUsedCodeRepoCnt() != null)) {
            iDataObject.set(FIELD_USEDCODEREPOCNT, (Object)pSDCResRepBase.getUsedCodeRepoCnt());
        }
        if (pSDCResRepBase.isUsedDBInstCntDirty() && (bl || pSDCResRepBase.getUsedDBInstCnt() != null)) {
            iDataObject.set(FIELD_USEDDBINSTCNT, (Object)pSDCResRepBase.getUsedDBInstCnt());
        }
        if (pSDCResRepBase.isUsedMQInstCntDirty() && (bl || pSDCResRepBase.getUsedMQInstCnt() != null)) {
            iDataObject.set(FIELD_USEDMQINSTCNT, (Object)pSDCResRepBase.getUsedMQInstCnt());
        }
        if (pSDCResRepBase.isUserASCntDirty() && (bl || pSDCResRepBase.getUserASCnt() != null)) {
            iDataObject.set(FIELD_USERASCNT, (Object)pSDCResRepBase.getUserASCnt());
        }
        if (pSDCResRepBase.isUserCntDirty() && (bl || pSDCResRepBase.getUserCnt() != null)) {
            iDataObject.set(FIELD_USERCNT, (Object)pSDCResRepBase.getUserCnt());
        }
        if (pSDCResRepBase.isUserCodeRepoCntDirty() && (bl || pSDCResRepBase.getUserCodeRepoCnt() != null)) {
            iDataObject.set(FIELD_USERCODEREPOCNT, (Object)pSDCResRepBase.getUserCodeRepoCnt());
        }
        if (pSDCResRepBase.isUserDBInstCntDirty() && (bl || pSDCResRepBase.getUserDBInstCnt() != null)) {
            iDataObject.set(FIELD_USERDBINSTCNT, (Object)pSDCResRepBase.getUserDBInstCnt());
        }
        if (pSDCResRepBase.isUserMQInstCntDirty() && (bl || pSDCResRepBase.getUserMQInstCnt() != null)) {
            iDataObject.set(FIELD_USERMQINSTCNT, (Object)pSDCResRepBase.getUserMQInstCnt());
        }
        if (pSDCResRepBase.isWorkspaceCntDirty() && (bl || pSDCResRepBase.getWorkspaceCnt() != null)) {
            iDataObject.set(FIELD_WORKSPACECNT, (Object)pSDCResRepBase.getWorkspaceCnt());
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
        return PSDCResRepBase.remove(this, n);
    }

    private static boolean remove(PSDCResRepBase pSDCResRepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCResRepBase.resetASCnt();
                return true;
            }
            case 1: {
                pSDCResRepBase.resetCodeRepoCnt();
                return true;
            }
            case 2: {
                pSDCResRepBase.resetContent();
                return true;
            }
            case 3: {
                pSDCResRepBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDCResRepBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDCResRepBase.resetDBInstCnt();
                return true;
            }
            case 6: {
                pSDCResRepBase.resetDCBalance();
                return true;
            }
            case 7: {
                pSDCResRepBase.resetDefaultFlag();
                return true;
            }
            case 8: {
                pSDCResRepBase.resetDepInstCnt();
                return true;
            }
            case 9: {
                pSDCResRepBase.resetDevSlnCnt();
                return true;
            }
            case 10: {
                pSDCResRepBase.resetDevSysCnt();
                return true;
            }
            case 11: {
                pSDCResRepBase.resetDevTemplCnt();
                return true;
            }
            case 12: {
                pSDCResRepBase.resetDiskSize();
                return true;
            }
            case 13: {
                pSDCResRepBase.resetDiskUsed();
                return true;
            }
            case 14: {
                pSDCResRepBase.resetDynaInstCnt();
                return true;
            }
            case 15: {
                pSDCResRepBase.resetExpiredASCnt();
                return true;
            }
            case 16: {
                pSDCResRepBase.resetExpiredASCnt2();
                return true;
            }
            case 17: {
                pSDCResRepBase.resetExpiredCodeRepoCnt();
                return true;
            }
            case 18: {
                pSDCResRepBase.resetExpiredCodeRepoCnt2();
                return true;
            }
            case 19: {
                pSDCResRepBase.resetExpiredDBInstCnt();
                return true;
            }
            case 20: {
                pSDCResRepBase.resetExpiredDBInstCnt2();
                return true;
            }
            case 21: {
                pSDCResRepBase.resetExpiredMQInstCnt();
                return true;
            }
            case 22: {
                pSDCResRepBase.resetExpiredMQInstCnt2();
                return true;
            }
            case 23: {
                pSDCResRepBase.resetIdleASCnt();
                return true;
            }
            case 24: {
                pSDCResRepBase.resetIdleCodeRepoCnt();
                return true;
            }
            case 25: {
                pSDCResRepBase.resetIdleDBInstCnt();
                return true;
            }
            case 26: {
                pSDCResRepBase.resetIdleMQInstCnt();
                return true;
            }
            case 27: {
                pSDCResRepBase.resetMemo();
                return true;
            }
            case 28: {
                pSDCResRepBase.resetMonthNWFlowSize();
                return true;
            }
            case 29: {
                pSDCResRepBase.resetMonthNWFlowUsed();
                return true;
            }
            case 30: {
                pSDCResRepBase.resetMQInstCnt();
                return true;
            }
            case 31: {
                pSDCResRepBase.resetMSPCnt();
                return true;
            }
            case 32: {
                pSDCResRepBase.resetObj2Cnt();
                return true;
            }
            case 33: {
                pSDCResRepBase.resetObj3Cnt();
                return true;
            }
            case 34: {
                pSDCResRepBase.resetObj4Cnt();
                return true;
            }
            case 35: {
                pSDCResRepBase.resetObjCnt();
                return true;
            }
            case 36: {
                pSDCResRepBase.resetPSDCResRepId();
                return true;
            }
            case 37: {
                pSDCResRepBase.resetPSDCResRepName();
                return true;
            }
            case 38: {
                pSDCResRepBase.resetPSDevCenterId();
                return true;
            }
            case 39: {
                pSDCResRepBase.resetPSDevCenterName();
                return true;
            }
            case 40: {
                pSDCResRepBase.resetReportUrl();
                return true;
            }
            case 41: {
                pSDCResRepBase.resetRepTime();
                return true;
            }
            case 42: {
                pSDCResRepBase.resetRobotCnt();
                return true;
            }
            case 43: {
                pSDCResRepBase.resetSysBakCnt();
                return true;
            }
            case 44: {
                pSDCResRepBase.resetUpdateDate();
                return true;
            }
            case 45: {
                pSDCResRepBase.resetUpdateMan();
                return true;
            }
            case 46: {
                pSDCResRepBase.resetUsedASCnt();
                return true;
            }
            case 47: {
                pSDCResRepBase.resetUsedCodeRepoCnt();
                return true;
            }
            case 48: {
                pSDCResRepBase.resetUsedDBInstCnt();
                return true;
            }
            case 49: {
                pSDCResRepBase.resetUsedMQInstCnt();
                return true;
            }
            case 50: {
                pSDCResRepBase.resetUserASCnt();
                return true;
            }
            case 51: {
                pSDCResRepBase.resetUserCnt();
                return true;
            }
            case 52: {
                pSDCResRepBase.resetUserCodeRepoCnt();
                return true;
            }
            case 53: {
                pSDCResRepBase.resetUserDBInstCnt();
                return true;
            }
            case 54: {
                pSDCResRepBase.resetUserMQInstCnt();
                return true;
            }
            case 55: {
                pSDCResRepBase.resetWorkspaceCnt();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSDCResRepBase getProxyEntity() {
        return this.proxyPSDCResRepBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCResRepBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCResRepBase) {
            this.proxyPSDCResRepBase = (PSDCResRepBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCResRepService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASCNT, 0);
        fieldIndexMap.put(FIELD_CODEREPOCNT, 1);
        fieldIndexMap.put(FIELD_CONTENT, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DBINSTCNT, 5);
        fieldIndexMap.put(FIELD_DCBALANCE, 6);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 7);
        fieldIndexMap.put(FIELD_DEPINSTCNT, 8);
        fieldIndexMap.put(FIELD_DEVSLNCNT, 9);
        fieldIndexMap.put(FIELD_DEVSYSCNT, 10);
        fieldIndexMap.put(FIELD_DEVTEMPLCNT, 11);
        fieldIndexMap.put(FIELD_DISKSIZE, 12);
        fieldIndexMap.put(FIELD_DISKUSED, 13);
        fieldIndexMap.put(FIELD_DYNAINSTCNT, 14);
        fieldIndexMap.put(FIELD_EXPIREDASCNT, 15);
        fieldIndexMap.put(FIELD_EXPIREDASCNT2, 16);
        fieldIndexMap.put(FIELD_EXPIREDCODEREPOCNT, 17);
        fieldIndexMap.put(FIELD_EXPIREDCODEREPOCNT2, 18);
        fieldIndexMap.put(FIELD_EXPIREDDBINSTCNT, 19);
        fieldIndexMap.put(FIELD_EXPIREDDBINSTCNT2, 20);
        fieldIndexMap.put(FIELD_EXPIREDMQINSTCNT, 21);
        fieldIndexMap.put(FIELD_EXPIREDMQINSTCNT2, 22);
        fieldIndexMap.put(FIELD_IDLEASCNT, 23);
        fieldIndexMap.put(FIELD_IDLECODEREPOCNT, 24);
        fieldIndexMap.put(FIELD_IDLEDBINSTCNT, 25);
        fieldIndexMap.put(FIELD_IDLEMQINSTCNT, 26);
        fieldIndexMap.put(FIELD_MEMO, 27);
        fieldIndexMap.put(FIELD_MONTHNWFLOWSIZE, 28);
        fieldIndexMap.put(FIELD_MONTHNWFLOWUSED, 29);
        fieldIndexMap.put(FIELD_MQINSTCNT, 30);
        fieldIndexMap.put(FIELD_MSPCNT, 31);
        fieldIndexMap.put(FIELD_OBJ2CNT, 32);
        fieldIndexMap.put(FIELD_OBJ3CNT, 33);
        fieldIndexMap.put(FIELD_OBJ4CNT, 34);
        fieldIndexMap.put(FIELD_OBJCNT, 35);
        fieldIndexMap.put(FIELD_PSDCRESREPID, 36);
        fieldIndexMap.put(FIELD_PSDCRESREPNAME, 37);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 38);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 39);
        fieldIndexMap.put(FIELD_REPORTURL, 40);
        fieldIndexMap.put(FIELD_REPTIME, 41);
        fieldIndexMap.put(FIELD_ROBOTCNT, 42);
        fieldIndexMap.put(FIELD_SYSBAKCNT, 43);
        fieldIndexMap.put(FIELD_UPDATEDATE, 44);
        fieldIndexMap.put(FIELD_UPDATEMAN, 45);
        fieldIndexMap.put(FIELD_USEDASCNT, 46);
        fieldIndexMap.put(FIELD_USEDCODEREPOCNT, 47);
        fieldIndexMap.put(FIELD_USEDDBINSTCNT, 48);
        fieldIndexMap.put(FIELD_USEDMQINSTCNT, 49);
        fieldIndexMap.put(FIELD_USERASCNT, 50);
        fieldIndexMap.put(FIELD_USERCNT, 51);
        fieldIndexMap.put(FIELD_USERCODEREPOCNT, 52);
        fieldIndexMap.put(FIELD_USERDBINSTCNT, 53);
        fieldIndexMap.put(FIELD_USERMQINSTCNT, 54);
        fieldIndexMap.put(FIELD_WORKSPACECNT, 55);
    }
}

