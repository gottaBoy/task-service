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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotify;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTarget;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDENotifyTargetBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDENotifyTargetBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_FILTER = "FILTER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENOTIFYID = "PSDENOTIFYID";
    public static final String FIELD_PSDENOTIFYNAME = "PSDENOTIFYNAME";
    public static final String FIELD_PSDENOTIFYTARGETID = "PSDENOTIFYTARGETID";
    public static final String FIELD_PSDENOTIFYTARGETNAME = "PSDENOTIFYTARGETNAME";
    public static final String FIELD_PSSYSMSGTARGETID = "PSSYSMSGTARGETID";
    public static final String FIELD_PSSYSMSGTARGETNAME = "PSSYSMSGTARGETNAME";
    public static final String FIELD_TARGETPSDEFID = "TARGETPSDEFID";
    public static final String FIELD_TARGETPSDEFNAME = "TARGETPSDEFNAME";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_TARGETTYPEPSDEFID = "TARGETTYPEPSDEFID";
    public static final String FIELD_TARGETTYPEPSDEFNAME = "TARGETTYPEPSDEFNAME";
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
    private static final int INDEX_DATA = 2;
    private static final int INDEX_FILTER = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEID = 5;
    private static final int INDEX_PSDENOTIFYID = 6;
    private static final int INDEX_PSDENOTIFYNAME = 7;
    private static final int INDEX_PSDENOTIFYTARGETID = 8;
    private static final int INDEX_PSDENOTIFYTARGETNAME = 9;
    private static final int INDEX_PSSYSMSGTARGETID = 10;
    private static final int INDEX_PSSYSMSGTARGETNAME = 11;
    private static final int INDEX_TARGETPSDEFID = 12;
    private static final int INDEX_TARGETPSDEFNAME = 13;
    private static final int INDEX_TARGETTYPE = 14;
    private static final int INDEX_TARGETTYPEPSDEFID = 15;
    private static final int INDEX_TARGETTYPEPSDEFNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final int INDEX_VALIDFLAG = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDENotifyTargetBase proxyPSDENotifyTargetBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean filterDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenotifyidDirtyFlag = false;
    private boolean psdenotifynameDirtyFlag = false;
    private boolean psdenotifytargetidDirtyFlag = false;
    private boolean psdenotifytargetnameDirtyFlag = false;
    private boolean pssysmsgtargetidDirtyFlag = false;
    private boolean pssysmsgtargetnameDirtyFlag = false;
    private boolean targetpsdefidDirtyFlag = false;
    private boolean targetpsdefnameDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
    private boolean targettypepsdefidDirtyFlag = false;
    private boolean targettypepsdefnameDirtyFlag = false;
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
    @Column(name="data")
    private String data;
    @Column(name="filter")
    private String filter;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdenotifyid")
    private String psdenotifyid;
    @Column(name="psdenotifyname")
    private String psdenotifyname;
    @Column(name="psdenotifytargetid")
    private String psdenotifytargetid;
    @Column(name="psdenotifytargetname")
    private String psdenotifytargetname;
    @Column(name="pssysmsgtargetid")
    private String pssysmsgtargetid;
    @Column(name="pssysmsgtargetname")
    private String pssysmsgtargetname;
    @Column(name="targetpsdefid")
    private String targetpsdefid;
    @Column(name="targetpsdefname")
    private String targetpsdefname;
    @Column(name="targettype")
    private String targettype;
    @Column(name="targettypepsdefid")
    private String targettypepsdefid;
    @Column(name="targettypepsdefname")
    private String targettypepsdefname;
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
    private Integer objTargetPSDEFLock = new Integer(1);
    private PSDEField targetpsdef = null;
    private Integer objTargetTypePSDEFLock = new Integer(1);
    private PSDEField targettypepsdef = null;
    private Integer objPSDENotifyLock = new Integer(1);
    private PSDENotify psdenotify = null;
    private Integer objPSSysMsgTargetLock = new Integer(1);
    private PSSysMsgTarget pssysmsgtarget = null;

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

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filter = string;
        this.filterDirtyFlag = true;
    }

    public String getFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilter();
        }
        return this.filter;
    }

    public boolean isFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterDirty();
        }
        return this.filterDirtyFlag;
    }

    public void resetFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilter();
            return;
        }
        this.filterDirtyFlag = false;
        this.filter = null;
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

    public void setPSDENotifyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDENotifyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdenotifyid = string;
        this.psdenotifyidDirtyFlag = true;
    }

    public String getPSDENotifyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyId();
        }
        return this.psdenotifyid;
    }

    public boolean isPSDENotifyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENotifyIdDirty();
        }
        return this.psdenotifyidDirtyFlag;
    }

    public void resetPSDENotifyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDENotifyId();
            return;
        }
        this.psdenotifyidDirtyFlag = false;
        this.psdenotifyid = null;
    }

    public void setPSDENotifyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDENotifyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdenotifyname = string;
        this.psdenotifynameDirtyFlag = true;
    }

    public String getPSDENotifyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyName();
        }
        return this.psdenotifyname;
    }

    public boolean isPSDENotifyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENotifyNameDirty();
        }
        return this.psdenotifynameDirtyFlag;
    }

    public void resetPSDENotifyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDENotifyName();
            return;
        }
        this.psdenotifynameDirtyFlag = false;
        this.psdenotifyname = null;
    }

    public void setPSDENotifyTargetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDENotifyTargetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdenotifytargetid = string;
        this.psdenotifytargetidDirtyFlag = true;
    }

    public String getPSDENotifyTargetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyTargetId();
        }
        return this.psdenotifytargetid;
    }

    public boolean isPSDENotifyTargetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENotifyTargetIdDirty();
        }
        return this.psdenotifytargetidDirtyFlag;
    }

    public void resetPSDENotifyTargetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDENotifyTargetId();
            return;
        }
        this.psdenotifytargetidDirtyFlag = false;
        this.psdenotifytargetid = null;
    }

    public void setPSDENotifyTargetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDENotifyTargetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdenotifytargetname = string;
        this.psdenotifytargetnameDirtyFlag = true;
    }

    public String getPSDENotifyTargetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyTargetName();
        }
        return this.psdenotifytargetname;
    }

    public boolean isPSDENotifyTargetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENotifyTargetNameDirty();
        }
        return this.psdenotifytargetnameDirtyFlag;
    }

    public void resetPSDENotifyTargetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDENotifyTargetName();
            return;
        }
        this.psdenotifytargetnameDirtyFlag = false;
        this.psdenotifytargetname = null;
    }

    public void setPSSysMsgTargetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTargetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtargetid = string;
        this.pssysmsgtargetidDirtyFlag = true;
    }

    public String getPSSysMsgTargetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTargetId();
        }
        return this.pssysmsgtargetid;
    }

    public boolean isPSSysMsgTargetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTargetIdDirty();
        }
        return this.pssysmsgtargetidDirtyFlag;
    }

    public void resetPSSysMsgTargetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTargetId();
            return;
        }
        this.pssysmsgtargetidDirtyFlag = false;
        this.pssysmsgtargetid = null;
    }

    public void setPSSysMsgTargetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTargetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtargetname = string;
        this.pssysmsgtargetnameDirtyFlag = true;
    }

    public String getPSSysMsgTargetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTargetName();
        }
        return this.pssysmsgtargetname;
    }

    public boolean isPSSysMsgTargetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTargetNameDirty();
        }
        return this.pssysmsgtargetnameDirtyFlag;
    }

    public void resetPSSysMsgTargetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTargetName();
            return;
        }
        this.pssysmsgtargetnameDirtyFlag = false;
        this.pssysmsgtargetname = null;
    }

    public void setTargetPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetpsdefid = string;
        this.targetpsdefidDirtyFlag = true;
    }

    public String getTargetPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEFId();
        }
        return this.targetpsdefid;
    }

    public boolean isTargetPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetPSDEFIdDirty();
        }
        return this.targetpsdefidDirtyFlag;
    }

    public void resetTargetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetPSDEFId();
            return;
        }
        this.targetpsdefidDirtyFlag = false;
        this.targetpsdefid = null;
    }

    public void setTargetPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetpsdefname = string;
        this.targetpsdefnameDirtyFlag = true;
    }

    public String getTargetPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEFName();
        }
        return this.targetpsdefname;
    }

    public boolean isTargetPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetPSDEFNameDirty();
        }
        return this.targetpsdefnameDirtyFlag;
    }

    public void resetTargetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetPSDEFName();
            return;
        }
        this.targetpsdefnameDirtyFlag = false;
        this.targetpsdefname = null;
    }

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
    }

    public void setTargetTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettypepsdefid = string;
        this.targettypepsdefidDirtyFlag = true;
    }

    public String getTargetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEFId();
        }
        return this.targettypepsdefid;
    }

    public boolean isTargetTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypePSDEFIdDirty();
        }
        return this.targettypepsdefidDirtyFlag;
    }

    public void resetTargetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetTypePSDEFId();
            return;
        }
        this.targettypepsdefidDirtyFlag = false;
        this.targettypepsdefid = null;
    }

    public void setTargetTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettypepsdefname = string;
        this.targettypepsdefnameDirtyFlag = true;
    }

    public String getTargetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEFName();
        }
        return this.targettypepsdefname;
    }

    public boolean isTargetTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypePSDEFNameDirty();
        }
        return this.targettypepsdefnameDirtyFlag;
    }

    public void resetTargetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetTypePSDEFName();
            return;
        }
        this.targettypepsdefnameDirtyFlag = false;
        this.targettypepsdefname = null;
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
        PSDENotifyTargetBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDENotifyTargetBase pSDENotifyTargetBase) {
        pSDENotifyTargetBase.resetCreateDate();
        pSDENotifyTargetBase.resetCreateMan();
        pSDENotifyTargetBase.resetData();
        pSDENotifyTargetBase.resetFilter();
        pSDENotifyTargetBase.resetMemo();
        pSDENotifyTargetBase.resetPSDEId();
        pSDENotifyTargetBase.resetPSDENotifyId();
        pSDENotifyTargetBase.resetPSDENotifyName();
        pSDENotifyTargetBase.resetPSDENotifyTargetId();
        pSDENotifyTargetBase.resetPSDENotifyTargetName();
        pSDENotifyTargetBase.resetPSSysMsgTargetId();
        pSDENotifyTargetBase.resetPSSysMsgTargetName();
        pSDENotifyTargetBase.resetTargetPSDEFId();
        pSDENotifyTargetBase.resetTargetPSDEFName();
        pSDENotifyTargetBase.resetTargetType();
        pSDENotifyTargetBase.resetTargetTypePSDEFId();
        pSDENotifyTargetBase.resetTargetTypePSDEFName();
        pSDENotifyTargetBase.resetUpdateDate();
        pSDENotifyTargetBase.resetUpdateMan();
        pSDENotifyTargetBase.resetUserCat();
        pSDENotifyTargetBase.resetUserTag();
        pSDENotifyTargetBase.resetUserTag2();
        pSDENotifyTargetBase.resetUserTag3();
        pSDENotifyTargetBase.resetUserTag4();
        pSDENotifyTargetBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isFilterDirty()) {
            hashMap.put(FIELD_FILTER, this.getFilter());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENotifyIdDirty()) {
            hashMap.put(FIELD_PSDENOTIFYID, this.getPSDENotifyId());
        }
        if (!bl || this.isPSDENotifyNameDirty()) {
            hashMap.put(FIELD_PSDENOTIFYNAME, this.getPSDENotifyName());
        }
        if (!bl || this.isPSDENotifyTargetIdDirty()) {
            hashMap.put(FIELD_PSDENOTIFYTARGETID, this.getPSDENotifyTargetId());
        }
        if (!bl || this.isPSDENotifyTargetNameDirty()) {
            hashMap.put(FIELD_PSDENOTIFYTARGETNAME, this.getPSDENotifyTargetName());
        }
        if (!bl || this.isPSSysMsgTargetIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTARGETID, this.getPSSysMsgTargetId());
        }
        if (!bl || this.isPSSysMsgTargetNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTARGETNAME, this.getPSSysMsgTargetName());
        }
        if (!bl || this.isTargetPSDEFIdDirty()) {
            hashMap.put(FIELD_TARGETPSDEFID, this.getTargetPSDEFId());
        }
        if (!bl || this.isTargetPSDEFNameDirty()) {
            hashMap.put(FIELD_TARGETPSDEFNAME, this.getTargetPSDEFName());
        }
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
        }
        if (!bl || this.isTargetTypePSDEFIdDirty()) {
            hashMap.put(FIELD_TARGETTYPEPSDEFID, this.getTargetTypePSDEFId());
        }
        if (!bl || this.isTargetTypePSDEFNameDirty()) {
            hashMap.put(FIELD_TARGETTYPEPSDEFNAME, this.getTargetTypePSDEFName());
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
        return PSDENotifyTargetBase.get(this, n);
    }

    private static Object get(PSDENotifyTargetBase pSDENotifyTargetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDENotifyTargetBase.getCreateDate();
            }
            case 1: {
                return pSDENotifyTargetBase.getCreateMan();
            }
            case 2: {
                return pSDENotifyTargetBase.getData();
            }
            case 3: {
                return pSDENotifyTargetBase.getFilter();
            }
            case 4: {
                return pSDENotifyTargetBase.getMemo();
            }
            case 5: {
                return pSDENotifyTargetBase.getPSDEId();
            }
            case 6: {
                return pSDENotifyTargetBase.getPSDENotifyId();
            }
            case 7: {
                return pSDENotifyTargetBase.getPSDENotifyName();
            }
            case 8: {
                return pSDENotifyTargetBase.getPSDENotifyTargetId();
            }
            case 9: {
                return pSDENotifyTargetBase.getPSDENotifyTargetName();
            }
            case 10: {
                return pSDENotifyTargetBase.getPSSysMsgTargetId();
            }
            case 11: {
                return pSDENotifyTargetBase.getPSSysMsgTargetName();
            }
            case 12: {
                return pSDENotifyTargetBase.getTargetPSDEFId();
            }
            case 13: {
                return pSDENotifyTargetBase.getTargetPSDEFName();
            }
            case 14: {
                return pSDENotifyTargetBase.getTargetType();
            }
            case 15: {
                return pSDENotifyTargetBase.getTargetTypePSDEFId();
            }
            case 16: {
                return pSDENotifyTargetBase.getTargetTypePSDEFName();
            }
            case 17: {
                return pSDENotifyTargetBase.getUpdateDate();
            }
            case 18: {
                return pSDENotifyTargetBase.getUpdateMan();
            }
            case 19: {
                return pSDENotifyTargetBase.getUserCat();
            }
            case 20: {
                return pSDENotifyTargetBase.getUserTag();
            }
            case 21: {
                return pSDENotifyTargetBase.getUserTag2();
            }
            case 22: {
                return pSDENotifyTargetBase.getUserTag3();
            }
            case 23: {
                return pSDENotifyTargetBase.getUserTag4();
            }
            case 24: {
                return pSDENotifyTargetBase.getValidFlag();
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
        PSDENotifyTargetBase.set(this, n, object);
    }

    private static void set(PSDENotifyTargetBase pSDENotifyTargetBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDENotifyTargetBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDENotifyTargetBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDENotifyTargetBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDENotifyTargetBase.setFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDENotifyTargetBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDENotifyTargetBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDENotifyTargetBase.setPSDENotifyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDENotifyTargetBase.setPSDENotifyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDENotifyTargetBase.setPSDENotifyTargetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDENotifyTargetBase.setPSDENotifyTargetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDENotifyTargetBase.setPSSysMsgTargetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDENotifyTargetBase.setPSSysMsgTargetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDENotifyTargetBase.setTargetPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDENotifyTargetBase.setTargetPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDENotifyTargetBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDENotifyTargetBase.setTargetTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDENotifyTargetBase.setTargetTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDENotifyTargetBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDENotifyTargetBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDENotifyTargetBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDENotifyTargetBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDENotifyTargetBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDENotifyTargetBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDENotifyTargetBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDENotifyTargetBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDENotifyTargetBase.isNull(this, n);
    }

    private static boolean isNull(PSDENotifyTargetBase pSDENotifyTargetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDENotifyTargetBase.getCreateDate() == null;
            }
            case 1: {
                return pSDENotifyTargetBase.getCreateMan() == null;
            }
            case 2: {
                return pSDENotifyTargetBase.getData() == null;
            }
            case 3: {
                return pSDENotifyTargetBase.getFilter() == null;
            }
            case 4: {
                return pSDENotifyTargetBase.getMemo() == null;
            }
            case 5: {
                return pSDENotifyTargetBase.getPSDEId() == null;
            }
            case 6: {
                return pSDENotifyTargetBase.getPSDENotifyId() == null;
            }
            case 7: {
                return pSDENotifyTargetBase.getPSDENotifyName() == null;
            }
            case 8: {
                return pSDENotifyTargetBase.getPSDENotifyTargetId() == null;
            }
            case 9: {
                return pSDENotifyTargetBase.getPSDENotifyTargetName() == null;
            }
            case 10: {
                return pSDENotifyTargetBase.getPSSysMsgTargetId() == null;
            }
            case 11: {
                return pSDENotifyTargetBase.getPSSysMsgTargetName() == null;
            }
            case 12: {
                return pSDENotifyTargetBase.getTargetPSDEFId() == null;
            }
            case 13: {
                return pSDENotifyTargetBase.getTargetPSDEFName() == null;
            }
            case 14: {
                return pSDENotifyTargetBase.getTargetType() == null;
            }
            case 15: {
                return pSDENotifyTargetBase.getTargetTypePSDEFId() == null;
            }
            case 16: {
                return pSDENotifyTargetBase.getTargetTypePSDEFName() == null;
            }
            case 17: {
                return pSDENotifyTargetBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDENotifyTargetBase.getUpdateMan() == null;
            }
            case 19: {
                return pSDENotifyTargetBase.getUserCat() == null;
            }
            case 20: {
                return pSDENotifyTargetBase.getUserTag() == null;
            }
            case 21: {
                return pSDENotifyTargetBase.getUserTag2() == null;
            }
            case 22: {
                return pSDENotifyTargetBase.getUserTag3() == null;
            }
            case 23: {
                return pSDENotifyTargetBase.getUserTag4() == null;
            }
            case 24: {
                return pSDENotifyTargetBase.getValidFlag() == null;
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
        return PSDENotifyTargetBase.contains(this, n);
    }

    private static boolean contains(PSDENotifyTargetBase pSDENotifyTargetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDENotifyTargetBase.isCreateDateDirty();
            }
            case 1: {
                return pSDENotifyTargetBase.isCreateManDirty();
            }
            case 2: {
                return pSDENotifyTargetBase.isDataDirty();
            }
            case 3: {
                return pSDENotifyTargetBase.isFilterDirty();
            }
            case 4: {
                return pSDENotifyTargetBase.isMemoDirty();
            }
            case 5: {
                return pSDENotifyTargetBase.isPSDEIdDirty();
            }
            case 6: {
                return pSDENotifyTargetBase.isPSDENotifyIdDirty();
            }
            case 7: {
                return pSDENotifyTargetBase.isPSDENotifyNameDirty();
            }
            case 8: {
                return pSDENotifyTargetBase.isPSDENotifyTargetIdDirty();
            }
            case 9: {
                return pSDENotifyTargetBase.isPSDENotifyTargetNameDirty();
            }
            case 10: {
                return pSDENotifyTargetBase.isPSSysMsgTargetIdDirty();
            }
            case 11: {
                return pSDENotifyTargetBase.isPSSysMsgTargetNameDirty();
            }
            case 12: {
                return pSDENotifyTargetBase.isTargetPSDEFIdDirty();
            }
            case 13: {
                return pSDENotifyTargetBase.isTargetPSDEFNameDirty();
            }
            case 14: {
                return pSDENotifyTargetBase.isTargetTypeDirty();
            }
            case 15: {
                return pSDENotifyTargetBase.isTargetTypePSDEFIdDirty();
            }
            case 16: {
                return pSDENotifyTargetBase.isTargetTypePSDEFNameDirty();
            }
            case 17: {
                return pSDENotifyTargetBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDENotifyTargetBase.isUpdateManDirty();
            }
            case 19: {
                return pSDENotifyTargetBase.isUserCatDirty();
            }
            case 20: {
                return pSDENotifyTargetBase.isUserTagDirty();
            }
            case 21: {
                return pSDENotifyTargetBase.isUserTag2Dirty();
            }
            case 22: {
                return pSDENotifyTargetBase.isUserTag3Dirty();
            }
            case 23: {
                return pSDENotifyTargetBase.isUserTag4Dirty();
            }
            case 24: {
                return pSDENotifyTargetBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDENotifyTargetBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDENotifyTargetBase pSDENotifyTargetBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDENotifyTargetBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getData()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filter", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getFilter()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getMemo()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getPSDENotifyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdenotifyid", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getPSDENotifyId()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getPSDENotifyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdenotifyname", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getPSDENotifyName()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getPSDENotifyTargetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdenotifytargetid", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getPSDENotifyTargetId()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getPSDENotifyTargetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdenotifytargetname", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getPSDENotifyTargetName()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getPSSysMsgTargetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtargetid", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getPSSysMsgTargetId()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getPSSysMsgTargetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtargetname", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getPSSysMsgTargetName()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getTargetPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetpsdefid", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getTargetPSDEFId()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getTargetPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetpsdefname", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getTargetPSDEFName()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getTargetType()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getTargetTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettypepsdefid", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getTargetTypePSDEFId()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getTargetTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettypepsdefname", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getTargetTypePSDEFName()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDENotifyTargetBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDENotifyTargetBase.getJSONValue((Object)pSDENotifyTargetBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDENotifyTargetBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDENotifyTargetBase pSDENotifyTargetBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDENotifyTargetBase.getCreateDate() != null) {
            object = pSDENotifyTargetBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDENotifyTargetBase.getCreateMan() != null) {
            object = pSDENotifyTargetBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getData() != null) {
            object = pSDENotifyTargetBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getFilter() != null) {
            object = pSDENotifyTargetBase.getFilter();
            xmlNode.setAttribute(FIELD_FILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getMemo() != null) {
            object = pSDENotifyTargetBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getPSDEId() != null) {
            object = pSDENotifyTargetBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getPSDENotifyId() != null) {
            object = pSDENotifyTargetBase.getPSDENotifyId();
            xmlNode.setAttribute(FIELD_PSDENOTIFYID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getPSDENotifyName() != null) {
            object = pSDENotifyTargetBase.getPSDENotifyName();
            xmlNode.setAttribute(FIELD_PSDENOTIFYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getPSDENotifyTargetId() != null) {
            object = pSDENotifyTargetBase.getPSDENotifyTargetId();
            xmlNode.setAttribute(FIELD_PSDENOTIFYTARGETID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getPSDENotifyTargetName() != null) {
            object = pSDENotifyTargetBase.getPSDENotifyTargetName();
            xmlNode.setAttribute(FIELD_PSDENOTIFYTARGETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getPSSysMsgTargetId() != null) {
            object = pSDENotifyTargetBase.getPSSysMsgTargetId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTARGETID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getPSSysMsgTargetName() != null) {
            object = pSDENotifyTargetBase.getPSSysMsgTargetName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTARGETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getTargetPSDEFId() != null) {
            object = pSDENotifyTargetBase.getTargetPSDEFId();
            xmlNode.setAttribute(FIELD_TARGETPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getTargetPSDEFName() != null) {
            object = pSDENotifyTargetBase.getTargetPSDEFName();
            xmlNode.setAttribute(FIELD_TARGETPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getTargetType() != null) {
            object = pSDENotifyTargetBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getTargetTypePSDEFId() != null) {
            object = pSDENotifyTargetBase.getTargetTypePSDEFId();
            xmlNode.setAttribute(FIELD_TARGETTYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getTargetTypePSDEFName() != null) {
            object = pSDENotifyTargetBase.getTargetTypePSDEFName();
            xmlNode.setAttribute(FIELD_TARGETTYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getUpdateDate() != null) {
            object = pSDENotifyTargetBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDENotifyTargetBase.getUpdateMan() != null) {
            object = pSDENotifyTargetBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getUserCat() != null) {
            object = pSDENotifyTargetBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getUserTag() != null) {
            object = pSDENotifyTargetBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getUserTag2() != null) {
            object = pSDENotifyTargetBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getUserTag3() != null) {
            object = pSDENotifyTargetBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getUserTag4() != null) {
            object = pSDENotifyTargetBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyTargetBase.getValidFlag() != null) {
            object = pSDENotifyTargetBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDENotifyTargetBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDENotifyTargetBase pSDENotifyTargetBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDENotifyTargetBase.isCreateDateDirty() && (bl || pSDENotifyTargetBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDENotifyTargetBase.getCreateDate());
        }
        if (pSDENotifyTargetBase.isCreateManDirty() && (bl || pSDENotifyTargetBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDENotifyTargetBase.getCreateMan());
        }
        if (pSDENotifyTargetBase.isDataDirty() && (bl || pSDENotifyTargetBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSDENotifyTargetBase.getData());
        }
        if (pSDENotifyTargetBase.isFilterDirty() && (bl || pSDENotifyTargetBase.getFilter() != null)) {
            iDataObject.set(FIELD_FILTER, (Object)pSDENotifyTargetBase.getFilter());
        }
        if (pSDENotifyTargetBase.isMemoDirty() && (bl || pSDENotifyTargetBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDENotifyTargetBase.getMemo());
        }
        if (pSDENotifyTargetBase.isPSDEIdDirty() && (bl || pSDENotifyTargetBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDENotifyTargetBase.getPSDEId());
        }
        if (pSDENotifyTargetBase.isPSDENotifyIdDirty() && (bl || pSDENotifyTargetBase.getPSDENotifyId() != null)) {
            iDataObject.set(FIELD_PSDENOTIFYID, (Object)pSDENotifyTargetBase.getPSDENotifyId());
        }
        if (pSDENotifyTargetBase.isPSDENotifyNameDirty() && (bl || pSDENotifyTargetBase.getPSDENotifyName() != null)) {
            iDataObject.set(FIELD_PSDENOTIFYNAME, (Object)pSDENotifyTargetBase.getPSDENotifyName());
        }
        if (pSDENotifyTargetBase.isPSDENotifyTargetIdDirty() && (bl || pSDENotifyTargetBase.getPSDENotifyTargetId() != null)) {
            iDataObject.set(FIELD_PSDENOTIFYTARGETID, (Object)pSDENotifyTargetBase.getPSDENotifyTargetId());
        }
        if (pSDENotifyTargetBase.isPSDENotifyTargetNameDirty() && (bl || pSDENotifyTargetBase.getPSDENotifyTargetName() != null)) {
            iDataObject.set(FIELD_PSDENOTIFYTARGETNAME, (Object)pSDENotifyTargetBase.getPSDENotifyTargetName());
        }
        if (pSDENotifyTargetBase.isPSSysMsgTargetIdDirty() && (bl || pSDENotifyTargetBase.getPSSysMsgTargetId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTARGETID, (Object)pSDENotifyTargetBase.getPSSysMsgTargetId());
        }
        if (pSDENotifyTargetBase.isPSSysMsgTargetNameDirty() && (bl || pSDENotifyTargetBase.getPSSysMsgTargetName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTARGETNAME, (Object)pSDENotifyTargetBase.getPSSysMsgTargetName());
        }
        if (pSDENotifyTargetBase.isTargetPSDEFIdDirty() && (bl || pSDENotifyTargetBase.getTargetPSDEFId() != null)) {
            iDataObject.set(FIELD_TARGETPSDEFID, (Object)pSDENotifyTargetBase.getTargetPSDEFId());
        }
        if (pSDENotifyTargetBase.isTargetPSDEFNameDirty() && (bl || pSDENotifyTargetBase.getTargetPSDEFName() != null)) {
            iDataObject.set(FIELD_TARGETPSDEFNAME, (Object)pSDENotifyTargetBase.getTargetPSDEFName());
        }
        if (pSDENotifyTargetBase.isTargetTypeDirty() && (bl || pSDENotifyTargetBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSDENotifyTargetBase.getTargetType());
        }
        if (pSDENotifyTargetBase.isTargetTypePSDEFIdDirty() && (bl || pSDENotifyTargetBase.getTargetTypePSDEFId() != null)) {
            iDataObject.set(FIELD_TARGETTYPEPSDEFID, (Object)pSDENotifyTargetBase.getTargetTypePSDEFId());
        }
        if (pSDENotifyTargetBase.isTargetTypePSDEFNameDirty() && (bl || pSDENotifyTargetBase.getTargetTypePSDEFName() != null)) {
            iDataObject.set(FIELD_TARGETTYPEPSDEFNAME, (Object)pSDENotifyTargetBase.getTargetTypePSDEFName());
        }
        if (pSDENotifyTargetBase.isUpdateDateDirty() && (bl || pSDENotifyTargetBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDENotifyTargetBase.getUpdateDate());
        }
        if (pSDENotifyTargetBase.isUpdateManDirty() && (bl || pSDENotifyTargetBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDENotifyTargetBase.getUpdateMan());
        }
        if (pSDENotifyTargetBase.isUserCatDirty() && (bl || pSDENotifyTargetBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDENotifyTargetBase.getUserCat());
        }
        if (pSDENotifyTargetBase.isUserTagDirty() && (bl || pSDENotifyTargetBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDENotifyTargetBase.getUserTag());
        }
        if (pSDENotifyTargetBase.isUserTag2Dirty() && (bl || pSDENotifyTargetBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDENotifyTargetBase.getUserTag2());
        }
        if (pSDENotifyTargetBase.isUserTag3Dirty() && (bl || pSDENotifyTargetBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDENotifyTargetBase.getUserTag3());
        }
        if (pSDENotifyTargetBase.isUserTag4Dirty() && (bl || pSDENotifyTargetBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDENotifyTargetBase.getUserTag4());
        }
        if (pSDENotifyTargetBase.isValidFlagDirty() && (bl || pSDENotifyTargetBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDENotifyTargetBase.getValidFlag());
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
        return PSDENotifyTargetBase.remove(this, n);
    }

    private static boolean remove(PSDENotifyTargetBase pSDENotifyTargetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDENotifyTargetBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDENotifyTargetBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDENotifyTargetBase.resetData();
                return true;
            }
            case 3: {
                pSDENotifyTargetBase.resetFilter();
                return true;
            }
            case 4: {
                pSDENotifyTargetBase.resetMemo();
                return true;
            }
            case 5: {
                pSDENotifyTargetBase.resetPSDEId();
                return true;
            }
            case 6: {
                pSDENotifyTargetBase.resetPSDENotifyId();
                return true;
            }
            case 7: {
                pSDENotifyTargetBase.resetPSDENotifyName();
                return true;
            }
            case 8: {
                pSDENotifyTargetBase.resetPSDENotifyTargetId();
                return true;
            }
            case 9: {
                pSDENotifyTargetBase.resetPSDENotifyTargetName();
                return true;
            }
            case 10: {
                pSDENotifyTargetBase.resetPSSysMsgTargetId();
                return true;
            }
            case 11: {
                pSDENotifyTargetBase.resetPSSysMsgTargetName();
                return true;
            }
            case 12: {
                pSDENotifyTargetBase.resetTargetPSDEFId();
                return true;
            }
            case 13: {
                pSDENotifyTargetBase.resetTargetPSDEFName();
                return true;
            }
            case 14: {
                pSDENotifyTargetBase.resetTargetType();
                return true;
            }
            case 15: {
                pSDENotifyTargetBase.resetTargetTypePSDEFId();
                return true;
            }
            case 16: {
                pSDENotifyTargetBase.resetTargetTypePSDEFName();
                return true;
            }
            case 17: {
                pSDENotifyTargetBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDENotifyTargetBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSDENotifyTargetBase.resetUserCat();
                return true;
            }
            case 20: {
                pSDENotifyTargetBase.resetUserTag();
                return true;
            }
            case 21: {
                pSDENotifyTargetBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSDENotifyTargetBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSDENotifyTargetBase.resetUserTag4();
                return true;
            }
            case 24: {
                pSDENotifyTargetBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTargetPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEF();
        }
        if (this.getTargetPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTargetPSDEFLock;
        synchronized (n) {
            if (this.targetpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTargetPSDEFId(), (Object)this.targetpsdef.getPSDEFieldId()) != 0L) {
                this.targetpsdef = null;
            }
            if (this.targetpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTargetPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.targetpsdef = pSDEField;
            }
            return this.targetpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTargetTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEF();
        }
        if (this.getTargetTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTargetTypePSDEFLock;
        synchronized (n) {
            if (this.targettypepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTargetTypePSDEFId(), (Object)this.targettypepsdef.getPSDEFieldId()) != 0L) {
                this.targettypepsdef = null;
            }
            if (this.targettypepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTargetTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.targettypepsdef = pSDEField;
            }
            return this.targettypepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDENotify getPSDENotify() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotify();
        }
        if (this.getPSDENotifyId() == null) {
            return null;
        }
        Integer n = this.objPSDENotifyLock;
        synchronized (n) {
            if (this.psdenotify != null && DataTypeHelper.compare((int)25, (Object)this.getPSDENotifyId(), (Object)this.psdenotify.getPSDENotifyId()) != 0L) {
                this.psdenotify = null;
            }
            if (this.psdenotify == null) {
                PSDENotify pSDENotify = new PSDENotify();
                pSDENotify.setPSDENotifyId(this.getPSDENotifyId());
                PSDENotifyService pSDENotifyService = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
                pSDENotifyService.autoGet((IEntity)pSDENotify);
                this.psdenotify = pSDENotify;
            }
            return this.psdenotify;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTarget getPSSysMsgTarget() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTarget();
        }
        if (this.getPSSysMsgTargetId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTargetLock;
        synchronized (n) {
            if (this.pssysmsgtarget != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTargetId(), (Object)this.pssysmsgtarget.getPSSysMsgTargetId()) != 0L) {
                this.pssysmsgtarget = null;
            }
            if (this.pssysmsgtarget == null) {
                PSSysMsgTarget pSSysMsgTarget = new PSSysMsgTarget();
                pSSysMsgTarget.setPSSysMsgTargetId(this.getPSSysMsgTargetId());
                PSSysMsgTargetService pSSysMsgTargetService = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTargetService.autoGet((IEntity)pSSysMsgTarget);
                this.pssysmsgtarget = pSSysMsgTarget;
            }
            return this.pssysmsgtarget;
        }
    }

    private PSDENotifyTargetBase getProxyEntity() {
        return this.proxyPSDENotifyTargetBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDENotifyTargetBase = null;
        if (iDataObject != null && iDataObject instanceof PSDENotifyTargetBase) {
            this.proxyPSDENotifyTargetBase = (PSDENotifyTargetBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDENotifyTargetService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DATA, 2);
        fieldIndexMap.put(FIELD_FILTER, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEID, 5);
        fieldIndexMap.put(FIELD_PSDENOTIFYID, 6);
        fieldIndexMap.put(FIELD_PSDENOTIFYNAME, 7);
        fieldIndexMap.put(FIELD_PSDENOTIFYTARGETID, 8);
        fieldIndexMap.put(FIELD_PSDENOTIFYTARGETNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSMSGTARGETID, 10);
        fieldIndexMap.put(FIELD_PSSYSMSGTARGETNAME, 11);
        fieldIndexMap.put(FIELD_TARGETPSDEFID, 12);
        fieldIndexMap.put(FIELD_TARGETPSDEFNAME, 13);
        fieldIndexMap.put(FIELD_TARGETTYPE, 14);
        fieldIndexMap.put(FIELD_TARGETTYPEPSDEFID, 15);
        fieldIndexMap.put(FIELD_TARGETTYPEPSDEFNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
        fieldIndexMap.put(FIELD_VALIDFLAG, 24);
    }
}

