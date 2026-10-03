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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdInstLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCorePrdInstLogBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_PSCOREPRDID = "PSCOREPRDID";
    public static final String FIELD_PSCOREPRDINSTLOGID = "PSCOREPRDINSTLOGID";
    public static final String FIELD_PSCOREPRDINSTLOGNAME = "PSCOREPRDINSTLOGNAME";
    public static final String FIELD_PSCOREPRDNAME = "PSCOREPRDNAME";
    public static final String FIELD_PSCOREPRDVERID = "PSCOREPRDVERID";
    public static final String FIELD_PSCOREPRDVERNAME = "PSCOREPRDVERNAME";
    public static final String FIELD_PSSTUDIOSERVERID = "PSSTUDIOSERVERID";
    public static final String FIELD_PSSTUDIOSERVERNAME = "PSSTUDIOSERVERNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_RESULTINFO = "RESULTINFO";
    public static final String FIELD_RESULTINFO2 = "RESULTINFO2";
    public static final String FIELD_RESULTINFO3 = "RESULTINFO3";
    public static final String FIELD_RESULTINFO4 = "RESULTINFO4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_INSTSTATE = 4;
    private static final int INDEX_PSCOREPRDID = 5;
    private static final int INDEX_PSCOREPRDINSTLOGID = 6;
    private static final int INDEX_PSCOREPRDINSTLOGNAME = 7;
    private static final int INDEX_PSCOREPRDNAME = 8;
    private static final int INDEX_PSCOREPRDVERID = 9;
    private static final int INDEX_PSCOREPRDVERNAME = 10;
    private static final int INDEX_PSSTUDIOSERVERID = 11;
    private static final int INDEX_PSSTUDIOSERVERNAME = 12;
    private static final int INDEX_PSTASKSERVERID = 13;
    private static final int INDEX_PSTASKSERVERNAME = 14;
    private static final int INDEX_RESULTINFO = 15;
    private static final int INDEX_RESULTINFO2 = 16;
    private static final int INDEX_RESULTINFO3 = 17;
    private static final int INDEX_RESULTINFO4 = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCorePrdInstLogBase proxyPSCorePrdInstLogBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean pscoreprdidDirtyFlag = false;
    private boolean pscoreprdinstlogidDirtyFlag = false;
    private boolean pscoreprdinstlognameDirtyFlag = false;
    private boolean pscoreprdnameDirtyFlag = false;
    private boolean pscoreprdveridDirtyFlag = false;
    private boolean pscoreprdvernameDirtyFlag = false;
    private boolean psstudioserveridDirtyFlag = false;
    private boolean psstudioservernameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean resultinfoDirtyFlag = false;
    private boolean resultinfo2DirtyFlag = false;
    private boolean resultinfo3DirtyFlag = false;
    private boolean resultinfo4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="inststate")
    private Integer inststate;
    @Column(name="pscoreprdid")
    private String pscoreprdid;
    @Column(name="pscoreprdinstlogid")
    private String pscoreprdinstlogid;
    @Column(name="pscoreprdinstlogname")
    private String pscoreprdinstlogname;
    @Column(name="pscoreprdname")
    private String pscoreprdname;
    @Column(name="pscoreprdverid")
    private String pscoreprdverid;
    @Column(name="pscoreprdvername")
    private String pscoreprdvername;
    @Column(name="psstudioserverid")
    private String psstudioserverid;
    @Column(name="psstudioservername")
    private String psstudioservername;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="resultinfo")
    private String resultinfo;
    @Column(name="resultinfo2")
    private String resultinfo2;
    @Column(name="resultinfo3")
    private String resultinfo3;
    @Column(name="resultinfo4")
    private String resultinfo4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCorePrdVerLock = new Integer(1);
    private PSCorePrdVer pscoreprdver = null;
    private Integer objPSCorePrdLock = new Integer(1);
    private PSCorePrd pscoreprd = null;
    private Integer objPSStudioServerLock = new Integer(1);
    private PSStudioServer psstudioserver = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setInstState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstState(n);
            return;
        }
        this.inststate = n;
        this.inststateDirtyFlag = true;
    }

    public Integer getInstState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstState();
        }
        return this.inststate;
    }

    public boolean isInstStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstStateDirty();
        }
        return this.inststateDirtyFlag;
    }

    public void resetInstState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstState();
            return;
        }
        this.inststateDirtyFlag = false;
        this.inststate = null;
    }

    public void setPSCorePrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdid = string;
        this.pscoreprdidDirtyFlag = true;
    }

    public String getPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdId();
        }
        return this.pscoreprdid;
    }

    public boolean isPSCorePrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIdDirty();
        }
        return this.pscoreprdidDirtyFlag;
    }

    public void resetPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdId();
            return;
        }
        this.pscoreprdidDirtyFlag = false;
        this.pscoreprdid = null;
    }

    public void setPSCorePrdInstLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdInstLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdinstlogid = string;
        this.pscoreprdinstlogidDirtyFlag = true;
    }

    public String getPSCorePrdInstLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdInstLogId();
        }
        return this.pscoreprdinstlogid;
    }

    public boolean isPSCorePrdInstLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdInstLogIdDirty();
        }
        return this.pscoreprdinstlogidDirtyFlag;
    }

    public void resetPSCorePrdInstLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdInstLogId();
            return;
        }
        this.pscoreprdinstlogidDirtyFlag = false;
        this.pscoreprdinstlogid = null;
    }

    public void setPSCorePrdInstLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdInstLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdinstlogname = string;
        this.pscoreprdinstlognameDirtyFlag = true;
    }

    public String getPSCorePrdInstLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdInstLogName();
        }
        return this.pscoreprdinstlogname;
    }

    public boolean isPSCorePrdInstLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdInstLogNameDirty();
        }
        return this.pscoreprdinstlognameDirtyFlag;
    }

    public void resetPSCorePrdInstLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdInstLogName();
            return;
        }
        this.pscoreprdinstlognameDirtyFlag = false;
        this.pscoreprdinstlogname = null;
    }

    public void setPSCorePrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdname = string;
        this.pscoreprdnameDirtyFlag = true;
    }

    public String getPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdName();
        }
        return this.pscoreprdname;
    }

    public boolean isPSCorePrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdNameDirty();
        }
        return this.pscoreprdnameDirtyFlag;
    }

    public void resetPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdName();
            return;
        }
        this.pscoreprdnameDirtyFlag = false;
        this.pscoreprdname = null;
    }

    public void setPSCorePrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdverid = string;
        this.pscoreprdveridDirtyFlag = true;
    }

    public String getPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerId();
        }
        return this.pscoreprdverid;
    }

    public boolean isPSCorePrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerIdDirty();
        }
        return this.pscoreprdveridDirtyFlag;
    }

    public void resetPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerId();
            return;
        }
        this.pscoreprdveridDirtyFlag = false;
        this.pscoreprdverid = null;
    }

    public void setPSCorePrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdvername = string;
        this.pscoreprdvernameDirtyFlag = true;
    }

    public String getPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerName();
        }
        return this.pscoreprdvername;
    }

    public boolean isPSCorePrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerNameDirty();
        }
        return this.pscoreprdvernameDirtyFlag;
    }

    public void resetPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerName();
            return;
        }
        this.pscoreprdvernameDirtyFlag = false;
        this.pscoreprdvername = null;
    }

    public void setPSStudioServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioserverid = string;
        this.psstudioserveridDirtyFlag = true;
    }

    public String getPSStudioServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerId();
        }
        return this.psstudioserverid;
    }

    public boolean isPSStudioServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerIdDirty();
        }
        return this.psstudioserveridDirtyFlag;
    }

    public void resetPSStudioServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerId();
            return;
        }
        this.psstudioserveridDirtyFlag = false;
        this.psstudioserverid = null;
    }

    public void setPSStudioServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservername = string;
        this.psstudioservernameDirtyFlag = true;
    }

    public String getPSStudioServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerName();
        }
        return this.psstudioservername;
    }

    public boolean isPSStudioServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerNameDirty();
        }
        return this.psstudioservernameDirtyFlag;
    }

    public void resetPSStudioServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerName();
            return;
        }
        this.psstudioservernameDirtyFlag = false;
        this.psstudioservername = null;
    }

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
    }

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
    }

    public void setResultInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResultInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resultinfo = string;
        this.resultinfoDirtyFlag = true;
    }

    public String getResultInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResultInfo();
        }
        return this.resultinfo;
    }

    public boolean isResultInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResultInfoDirty();
        }
        return this.resultinfoDirtyFlag;
    }

    public void resetResultInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResultInfo();
            return;
        }
        this.resultinfoDirtyFlag = false;
        this.resultinfo = null;
    }

    public void setResultInfo2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResultInfo2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resultinfo2 = string;
        this.resultinfo2DirtyFlag = true;
    }

    public String getResultInfo2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResultInfo2();
        }
        return this.resultinfo2;
    }

    public boolean isResultInfo2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResultInfo2Dirty();
        }
        return this.resultinfo2DirtyFlag;
    }

    public void resetResultInfo2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResultInfo2();
            return;
        }
        this.resultinfo2DirtyFlag = false;
        this.resultinfo2 = null;
    }

    public void setResultInfo3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResultInfo3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resultinfo3 = string;
        this.resultinfo3DirtyFlag = true;
    }

    public String getResultInfo3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResultInfo3();
        }
        return this.resultinfo3;
    }

    public boolean isResultInfo3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResultInfo3Dirty();
        }
        return this.resultinfo3DirtyFlag;
    }

    public void resetResultInfo3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResultInfo3();
            return;
        }
        this.resultinfo3DirtyFlag = false;
        this.resultinfo3 = null;
    }

    public void setResultInfo4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResultInfo4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resultinfo4 = string;
        this.resultinfo4DirtyFlag = true;
    }

    public String getResultInfo4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResultInfo4();
        }
        return this.resultinfo4;
    }

    public boolean isResultInfo4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResultInfo4Dirty();
        }
        return this.resultinfo4DirtyFlag;
    }

    public void resetResultInfo4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResultInfo4();
            return;
        }
        this.resultinfo4DirtyFlag = false;
        this.resultinfo4 = null;
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
        PSCorePrdInstLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCorePrdInstLogBase pSCorePrdInstLogBase) {
        pSCorePrdInstLogBase.resetBeginTime();
        pSCorePrdInstLogBase.resetCreateDate();
        pSCorePrdInstLogBase.resetCreateMan();
        pSCorePrdInstLogBase.resetEndTime();
        pSCorePrdInstLogBase.resetInstState();
        pSCorePrdInstLogBase.resetPSCorePrdId();
        pSCorePrdInstLogBase.resetPSCorePrdInstLogId();
        pSCorePrdInstLogBase.resetPSCorePrdInstLogName();
        pSCorePrdInstLogBase.resetPSCorePrdName();
        pSCorePrdInstLogBase.resetPSCorePrdVerId();
        pSCorePrdInstLogBase.resetPSCorePrdVerName();
        pSCorePrdInstLogBase.resetPSStudioServerId();
        pSCorePrdInstLogBase.resetPSStudioServerName();
        pSCorePrdInstLogBase.resetPSTaskServerId();
        pSCorePrdInstLogBase.resetPSTaskServerName();
        pSCorePrdInstLogBase.resetResultInfo();
        pSCorePrdInstLogBase.resetResultInfo2();
        pSCorePrdInstLogBase.resetResultInfo3();
        pSCorePrdInstLogBase.resetResultInfo4();
        pSCorePrdInstLogBase.resetUpdateDate();
        pSCorePrdInstLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isInstStateDirty()) {
            hashMap.put(FIELD_INSTSTATE, this.getInstState());
        }
        if (!bl || this.isPSCorePrdIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDID, this.getPSCorePrdId());
        }
        if (!bl || this.isPSCorePrdInstLogIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDINSTLOGID, this.getPSCorePrdInstLogId());
        }
        if (!bl || this.isPSCorePrdInstLogNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDINSTLOGNAME, this.getPSCorePrdInstLogName());
        }
        if (!bl || this.isPSCorePrdNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDNAME, this.getPSCorePrdName());
        }
        if (!bl || this.isPSCorePrdVerIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERID, this.getPSCorePrdVerId());
        }
        if (!bl || this.isPSCorePrdVerNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERNAME, this.getPSCorePrdVerName());
        }
        if (!bl || this.isPSStudioServerIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERID, this.getPSStudioServerId());
        }
        if (!bl || this.isPSStudioServerNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERNAME, this.getPSStudioServerName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isResultInfoDirty()) {
            hashMap.put(FIELD_RESULTINFO, this.getResultInfo());
        }
        if (!bl || this.isResultInfo2Dirty()) {
            hashMap.put(FIELD_RESULTINFO2, this.getResultInfo2());
        }
        if (!bl || this.isResultInfo3Dirty()) {
            hashMap.put(FIELD_RESULTINFO3, this.getResultInfo3());
        }
        if (!bl || this.isResultInfo4Dirty()) {
            hashMap.put(FIELD_RESULTINFO4, this.getResultInfo4());
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
        return PSCorePrdInstLogBase.get(this, n);
    }

    private static Object get(PSCorePrdInstLogBase pSCorePrdInstLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdInstLogBase.getBeginTime();
            }
            case 1: {
                return pSCorePrdInstLogBase.getCreateDate();
            }
            case 2: {
                return pSCorePrdInstLogBase.getCreateMan();
            }
            case 3: {
                return pSCorePrdInstLogBase.getEndTime();
            }
            case 4: {
                return pSCorePrdInstLogBase.getInstState();
            }
            case 5: {
                return pSCorePrdInstLogBase.getPSCorePrdId();
            }
            case 6: {
                return pSCorePrdInstLogBase.getPSCorePrdInstLogId();
            }
            case 7: {
                return pSCorePrdInstLogBase.getPSCorePrdInstLogName();
            }
            case 8: {
                return pSCorePrdInstLogBase.getPSCorePrdName();
            }
            case 9: {
                return pSCorePrdInstLogBase.getPSCorePrdVerId();
            }
            case 10: {
                return pSCorePrdInstLogBase.getPSCorePrdVerName();
            }
            case 11: {
                return pSCorePrdInstLogBase.getPSStudioServerId();
            }
            case 12: {
                return pSCorePrdInstLogBase.getPSStudioServerName();
            }
            case 13: {
                return pSCorePrdInstLogBase.getPSTaskServerId();
            }
            case 14: {
                return pSCorePrdInstLogBase.getPSTaskServerName();
            }
            case 15: {
                return pSCorePrdInstLogBase.getResultInfo();
            }
            case 16: {
                return pSCorePrdInstLogBase.getResultInfo2();
            }
            case 17: {
                return pSCorePrdInstLogBase.getResultInfo3();
            }
            case 18: {
                return pSCorePrdInstLogBase.getResultInfo4();
            }
            case 19: {
                return pSCorePrdInstLogBase.getUpdateDate();
            }
            case 20: {
                return pSCorePrdInstLogBase.getUpdateMan();
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
        PSCorePrdInstLogBase.set(this, n, object);
    }

    private static void set(PSCorePrdInstLogBase pSCorePrdInstLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdInstLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCorePrdInstLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCorePrdInstLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCorePrdInstLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSCorePrdInstLogBase.setInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSCorePrdInstLogBase.setPSCorePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCorePrdInstLogBase.setPSCorePrdInstLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCorePrdInstLogBase.setPSCorePrdInstLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCorePrdInstLogBase.setPSCorePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCorePrdInstLogBase.setPSCorePrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCorePrdInstLogBase.setPSCorePrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCorePrdInstLogBase.setPSStudioServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCorePrdInstLogBase.setPSStudioServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCorePrdInstLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCorePrdInstLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCorePrdInstLogBase.setResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCorePrdInstLogBase.setResultInfo2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCorePrdInstLogBase.setResultInfo3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCorePrdInstLogBase.setResultInfo4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCorePrdInstLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSCorePrdInstLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCorePrdInstLogBase.isNull(this, n);
    }

    private static boolean isNull(PSCorePrdInstLogBase pSCorePrdInstLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdInstLogBase.getBeginTime() == null;
            }
            case 1: {
                return pSCorePrdInstLogBase.getCreateDate() == null;
            }
            case 2: {
                return pSCorePrdInstLogBase.getCreateMan() == null;
            }
            case 3: {
                return pSCorePrdInstLogBase.getEndTime() == null;
            }
            case 4: {
                return pSCorePrdInstLogBase.getInstState() == null;
            }
            case 5: {
                return pSCorePrdInstLogBase.getPSCorePrdId() == null;
            }
            case 6: {
                return pSCorePrdInstLogBase.getPSCorePrdInstLogId() == null;
            }
            case 7: {
                return pSCorePrdInstLogBase.getPSCorePrdInstLogName() == null;
            }
            case 8: {
                return pSCorePrdInstLogBase.getPSCorePrdName() == null;
            }
            case 9: {
                return pSCorePrdInstLogBase.getPSCorePrdVerId() == null;
            }
            case 10: {
                return pSCorePrdInstLogBase.getPSCorePrdVerName() == null;
            }
            case 11: {
                return pSCorePrdInstLogBase.getPSStudioServerId() == null;
            }
            case 12: {
                return pSCorePrdInstLogBase.getPSStudioServerName() == null;
            }
            case 13: {
                return pSCorePrdInstLogBase.getPSTaskServerId() == null;
            }
            case 14: {
                return pSCorePrdInstLogBase.getPSTaskServerName() == null;
            }
            case 15: {
                return pSCorePrdInstLogBase.getResultInfo() == null;
            }
            case 16: {
                return pSCorePrdInstLogBase.getResultInfo2() == null;
            }
            case 17: {
                return pSCorePrdInstLogBase.getResultInfo3() == null;
            }
            case 18: {
                return pSCorePrdInstLogBase.getResultInfo4() == null;
            }
            case 19: {
                return pSCorePrdInstLogBase.getUpdateDate() == null;
            }
            case 20: {
                return pSCorePrdInstLogBase.getUpdateMan() == null;
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
        return PSCorePrdInstLogBase.contains(this, n);
    }

    private static boolean contains(PSCorePrdInstLogBase pSCorePrdInstLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdInstLogBase.isBeginTimeDirty();
            }
            case 1: {
                return pSCorePrdInstLogBase.isCreateDateDirty();
            }
            case 2: {
                return pSCorePrdInstLogBase.isCreateManDirty();
            }
            case 3: {
                return pSCorePrdInstLogBase.isEndTimeDirty();
            }
            case 4: {
                return pSCorePrdInstLogBase.isInstStateDirty();
            }
            case 5: {
                return pSCorePrdInstLogBase.isPSCorePrdIdDirty();
            }
            case 6: {
                return pSCorePrdInstLogBase.isPSCorePrdInstLogIdDirty();
            }
            case 7: {
                return pSCorePrdInstLogBase.isPSCorePrdInstLogNameDirty();
            }
            case 8: {
                return pSCorePrdInstLogBase.isPSCorePrdNameDirty();
            }
            case 9: {
                return pSCorePrdInstLogBase.isPSCorePrdVerIdDirty();
            }
            case 10: {
                return pSCorePrdInstLogBase.isPSCorePrdVerNameDirty();
            }
            case 11: {
                return pSCorePrdInstLogBase.isPSStudioServerIdDirty();
            }
            case 12: {
                return pSCorePrdInstLogBase.isPSStudioServerNameDirty();
            }
            case 13: {
                return pSCorePrdInstLogBase.isPSTaskServerIdDirty();
            }
            case 14: {
                return pSCorePrdInstLogBase.isPSTaskServerNameDirty();
            }
            case 15: {
                return pSCorePrdInstLogBase.isResultInfoDirty();
            }
            case 16: {
                return pSCorePrdInstLogBase.isResultInfo2Dirty();
            }
            case 17: {
                return pSCorePrdInstLogBase.isResultInfo3Dirty();
            }
            case 18: {
                return pSCorePrdInstLogBase.isResultInfo4Dirty();
            }
            case 19: {
                return pSCorePrdInstLogBase.isUpdateDateDirty();
            }
            case 20: {
                return pSCorePrdInstLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCorePrdInstLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCorePrdInstLogBase pSCorePrdInstLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCorePrdInstLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getInstState()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdid", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSCorePrdId()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdInstLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdinstlogid", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSCorePrdInstLogId()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdInstLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdinstlogname", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSCorePrdInstLogName()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdname", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSCorePrdName()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdverid", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSCorePrdVerId()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdvername", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSCorePrdVerName()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSStudioServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioserverid", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSStudioServerId()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSStudioServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservername", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSStudioServerName()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resultinfo", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getResultInfo()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getResultInfo2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resultinfo2", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getResultInfo2()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getResultInfo3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resultinfo3", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getResultInfo3()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getResultInfo4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resultinfo4", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getResultInfo4()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCorePrdInstLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCorePrdInstLogBase.getJSONValue((Object)pSCorePrdInstLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCorePrdInstLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCorePrdInstLogBase pSCorePrdInstLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCorePrdInstLogBase.getBeginTime() != null) {
            object = pSCorePrdInstLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdInstLogBase.getCreateDate() != null) {
            object = pSCorePrdInstLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdInstLogBase.getCreateMan() != null) {
            object = pSCorePrdInstLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getEndTime() != null) {
            object = pSCorePrdInstLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdInstLogBase.getInstState() != null) {
            object = pSCorePrdInstLogBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdId() != null) {
            object = pSCorePrdInstLogBase.getPSCorePrdId();
            xmlNode.setAttribute(FIELD_PSCOREPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdInstLogId() != null) {
            object = pSCorePrdInstLogBase.getPSCorePrdInstLogId();
            xmlNode.setAttribute(FIELD_PSCOREPRDINSTLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdInstLogName() != null) {
            object = pSCorePrdInstLogBase.getPSCorePrdInstLogName();
            xmlNode.setAttribute(FIELD_PSCOREPRDINSTLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdName() != null) {
            object = pSCorePrdInstLogBase.getPSCorePrdName();
            xmlNode.setAttribute(FIELD_PSCOREPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdVerId() != null) {
            object = pSCorePrdInstLogBase.getPSCorePrdVerId();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSCorePrdVerName() != null) {
            object = pSCorePrdInstLogBase.getPSCorePrdVerName();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSStudioServerId() != null) {
            object = pSCorePrdInstLogBase.getPSStudioServerId();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSStudioServerName() != null) {
            object = pSCorePrdInstLogBase.getPSStudioServerName();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSTaskServerId() != null) {
            object = pSCorePrdInstLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getPSTaskServerName() != null) {
            object = pSCorePrdInstLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getResultInfo() != null) {
            object = pSCorePrdInstLogBase.getResultInfo();
            xmlNode.setAttribute(FIELD_RESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getResultInfo2() != null) {
            object = pSCorePrdInstLogBase.getResultInfo2();
            xmlNode.setAttribute(FIELD_RESULTINFO2, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getResultInfo3() != null) {
            object = pSCorePrdInstLogBase.getResultInfo3();
            xmlNode.setAttribute(FIELD_RESULTINFO3, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getResultInfo4() != null) {
            object = pSCorePrdInstLogBase.getResultInfo4();
            xmlNode.setAttribute(FIELD_RESULTINFO4, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdInstLogBase.getUpdateDate() != null) {
            object = pSCorePrdInstLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdInstLogBase.getUpdateMan() != null) {
            object = pSCorePrdInstLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCorePrdInstLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCorePrdInstLogBase pSCorePrdInstLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCorePrdInstLogBase.isBeginTimeDirty() && (bl || pSCorePrdInstLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSCorePrdInstLogBase.getBeginTime());
        }
        if (pSCorePrdInstLogBase.isCreateDateDirty() && (bl || pSCorePrdInstLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCorePrdInstLogBase.getCreateDate());
        }
        if (pSCorePrdInstLogBase.isCreateManDirty() && (bl || pSCorePrdInstLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCorePrdInstLogBase.getCreateMan());
        }
        if (pSCorePrdInstLogBase.isEndTimeDirty() && (bl || pSCorePrdInstLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSCorePrdInstLogBase.getEndTime());
        }
        if (pSCorePrdInstLogBase.isInstStateDirty() && (bl || pSCorePrdInstLogBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSCorePrdInstLogBase.getInstState());
        }
        if (pSCorePrdInstLogBase.isPSCorePrdIdDirty() && (bl || pSCorePrdInstLogBase.getPSCorePrdId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDID, (Object)pSCorePrdInstLogBase.getPSCorePrdId());
        }
        if (pSCorePrdInstLogBase.isPSCorePrdInstLogIdDirty() && (bl || pSCorePrdInstLogBase.getPSCorePrdInstLogId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDINSTLOGID, (Object)pSCorePrdInstLogBase.getPSCorePrdInstLogId());
        }
        if (pSCorePrdInstLogBase.isPSCorePrdInstLogNameDirty() && (bl || pSCorePrdInstLogBase.getPSCorePrdInstLogName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDINSTLOGNAME, (Object)pSCorePrdInstLogBase.getPSCorePrdInstLogName());
        }
        if (pSCorePrdInstLogBase.isPSCorePrdNameDirty() && (bl || pSCorePrdInstLogBase.getPSCorePrdName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDNAME, (Object)pSCorePrdInstLogBase.getPSCorePrdName());
        }
        if (pSCorePrdInstLogBase.isPSCorePrdVerIdDirty() && (bl || pSCorePrdInstLogBase.getPSCorePrdVerId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERID, (Object)pSCorePrdInstLogBase.getPSCorePrdVerId());
        }
        if (pSCorePrdInstLogBase.isPSCorePrdVerNameDirty() && (bl || pSCorePrdInstLogBase.getPSCorePrdVerName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERNAME, (Object)pSCorePrdInstLogBase.getPSCorePrdVerName());
        }
        if (pSCorePrdInstLogBase.isPSStudioServerIdDirty() && (bl || pSCorePrdInstLogBase.getPSStudioServerId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERID, (Object)pSCorePrdInstLogBase.getPSStudioServerId());
        }
        if (pSCorePrdInstLogBase.isPSStudioServerNameDirty() && (bl || pSCorePrdInstLogBase.getPSStudioServerName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERNAME, (Object)pSCorePrdInstLogBase.getPSStudioServerName());
        }
        if (pSCorePrdInstLogBase.isPSTaskServerIdDirty() && (bl || pSCorePrdInstLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSCorePrdInstLogBase.getPSTaskServerId());
        }
        if (pSCorePrdInstLogBase.isPSTaskServerNameDirty() && (bl || pSCorePrdInstLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSCorePrdInstLogBase.getPSTaskServerName());
        }
        if (pSCorePrdInstLogBase.isResultInfoDirty() && (bl || pSCorePrdInstLogBase.getResultInfo() != null)) {
            iDataObject.set(FIELD_RESULTINFO, (Object)pSCorePrdInstLogBase.getResultInfo());
        }
        if (pSCorePrdInstLogBase.isResultInfo2Dirty() && (bl || pSCorePrdInstLogBase.getResultInfo2() != null)) {
            iDataObject.set(FIELD_RESULTINFO2, (Object)pSCorePrdInstLogBase.getResultInfo2());
        }
        if (pSCorePrdInstLogBase.isResultInfo3Dirty() && (bl || pSCorePrdInstLogBase.getResultInfo3() != null)) {
            iDataObject.set(FIELD_RESULTINFO3, (Object)pSCorePrdInstLogBase.getResultInfo3());
        }
        if (pSCorePrdInstLogBase.isResultInfo4Dirty() && (bl || pSCorePrdInstLogBase.getResultInfo4() != null)) {
            iDataObject.set(FIELD_RESULTINFO4, (Object)pSCorePrdInstLogBase.getResultInfo4());
        }
        if (pSCorePrdInstLogBase.isUpdateDateDirty() && (bl || pSCorePrdInstLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCorePrdInstLogBase.getUpdateDate());
        }
        if (pSCorePrdInstLogBase.isUpdateManDirty() && (bl || pSCorePrdInstLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCorePrdInstLogBase.getUpdateMan());
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
        return PSCorePrdInstLogBase.remove(this, n);
    }

    private static boolean remove(PSCorePrdInstLogBase pSCorePrdInstLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdInstLogBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSCorePrdInstLogBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCorePrdInstLogBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCorePrdInstLogBase.resetEndTime();
                return true;
            }
            case 4: {
                pSCorePrdInstLogBase.resetInstState();
                return true;
            }
            case 5: {
                pSCorePrdInstLogBase.resetPSCorePrdId();
                return true;
            }
            case 6: {
                pSCorePrdInstLogBase.resetPSCorePrdInstLogId();
                return true;
            }
            case 7: {
                pSCorePrdInstLogBase.resetPSCorePrdInstLogName();
                return true;
            }
            case 8: {
                pSCorePrdInstLogBase.resetPSCorePrdName();
                return true;
            }
            case 9: {
                pSCorePrdInstLogBase.resetPSCorePrdVerId();
                return true;
            }
            case 10: {
                pSCorePrdInstLogBase.resetPSCorePrdVerName();
                return true;
            }
            case 11: {
                pSCorePrdInstLogBase.resetPSStudioServerId();
                return true;
            }
            case 12: {
                pSCorePrdInstLogBase.resetPSStudioServerName();
                return true;
            }
            case 13: {
                pSCorePrdInstLogBase.resetPSTaskServerId();
                return true;
            }
            case 14: {
                pSCorePrdInstLogBase.resetPSTaskServerName();
                return true;
            }
            case 15: {
                pSCorePrdInstLogBase.resetResultInfo();
                return true;
            }
            case 16: {
                pSCorePrdInstLogBase.resetResultInfo2();
                return true;
            }
            case 17: {
                pSCorePrdInstLogBase.resetResultInfo3();
                return true;
            }
            case 18: {
                pSCorePrdInstLogBase.resetResultInfo4();
                return true;
            }
            case 19: {
                pSCorePrdInstLogBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSCorePrdInstLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdVer getPSCorePrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVer();
        }
        if (this.getPSCorePrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdVerLock;
        synchronized (n) {
            if (this.pscoreprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdVerId(), (Object)this.pscoreprdver.getPSCorePrdVerId()) != 0L) {
                this.pscoreprdver = null;
            }
            if (this.pscoreprdver == null) {
                PSCorePrdVer pSCorePrdVer = new PSCorePrdVer();
                pSCorePrdVer.setPSCorePrdVerId(this.getPSCorePrdVerId());
                PSCorePrdVerService pSCorePrdVerService = (PSCorePrdVerService)ServiceGlobal.getService(PSCorePrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdVerService.autoGet(pSCorePrdVer);
                this.pscoreprdver = pSCorePrdVer;
            }
            return this.pscoreprdver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrd getPSCorePrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrd();
        }
        if (this.getPSCorePrdId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdLock;
        synchronized (n) {
            if (this.pscoreprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdId(), (Object)this.pscoreprd.getPSCorePrdId()) != 0L) {
                this.pscoreprd = null;
            }
            if (this.pscoreprd == null) {
                PSCorePrd pSCorePrd = new PSCorePrd();
                pSCorePrd.setPSCorePrdId(this.getPSCorePrdId());
                PSCorePrdService pSCorePrdService = (PSCorePrdService)ServiceGlobal.getService(PSCorePrdService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdService.autoGet(pSCorePrd);
                this.pscoreprd = pSCorePrd;
            }
            return this.pscoreprd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSStudioServer getPSStudioServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServer();
        }
        if (this.getPSStudioServerId() == null) {
            return null;
        }
        Integer n = this.objPSStudioServerLock;
        synchronized (n) {
            if (this.psstudioserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSStudioServerId(), (Object)this.psstudioserver.getPSStudioServerId()) != 0L) {
                this.psstudioserver = null;
            }
            if (this.psstudioserver == null) {
                PSStudioServer pSStudioServer = new PSStudioServer();
                pSStudioServer.setPSStudioServerId(this.getPSStudioServerId());
                PSStudioServerService pSStudioServerService = (PSStudioServerService)ServiceGlobal.getService(PSStudioServerService.class, (SessionFactory)this.getSessionFactory());
                pSStudioServerService.autoGet(pSStudioServer);
                this.psstudioserver = pSStudioServer;
            }
            return this.psstudioserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet(pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSCorePrdInstLogBase getProxyEntity() {
        return this.proxyPSCorePrdInstLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCorePrdInstLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSCorePrdInstLogBase) {
            this.proxyPSCorePrdInstLogBase = (PSCorePrdInstLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdInstLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_INSTSTATE, 4);
        fieldIndexMap.put(FIELD_PSCOREPRDID, 5);
        fieldIndexMap.put(FIELD_PSCOREPRDINSTLOGID, 6);
        fieldIndexMap.put(FIELD_PSCOREPRDINSTLOGNAME, 7);
        fieldIndexMap.put(FIELD_PSCOREPRDNAME, 8);
        fieldIndexMap.put(FIELD_PSCOREPRDVERID, 9);
        fieldIndexMap.put(FIELD_PSCOREPRDVERNAME, 10);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERID, 11);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERNAME, 12);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 13);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 14);
        fieldIndexMap.put(FIELD_RESULTINFO, 15);
        fieldIndexMap.put(FIELD_RESULTINFO2, 16);
        fieldIndexMap.put(FIELD_RESULTINFO3, 17);
        fieldIndexMap.put(FIELD_RESULTINFO4, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
    }
}

