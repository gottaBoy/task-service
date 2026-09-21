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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUILogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUILogicBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOGICTYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEID = 5;
    private static final int INDEX_PSDELOGICID = 6;
    private static final int INDEX_PSDELOGICNAME = 7;
    private static final int INDEX_PSDENAME = 8;
    private static final int INDEX_PSSYSDYNAMODELID = 9;
    private static final int INDEX_PSSYSDYNAMODELNAME = 10;
    private static final int INDEX_PSSYSREQITEMID = 11;
    private static final int INDEX_PSSYSREQITEMNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUILogicBase proxyPSDEUILogicBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logictype")
    private String logictype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictype = string;
        this.logictypeDirtyFlag = true;
    }

    public String getLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicType();
        }
        return this.logictype;
    }

    public boolean isLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTypeDirty();
        }
        return this.logictypeDirtyFlag;
    }

    public void resetLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicType();
            return;
        }
        this.logictypeDirtyFlag = false;
        this.logictype = null;
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

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
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

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
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

    protected void onReset() {
        PSDEUILogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUILogicBase pSDEUILogicBase) {
        pSDEUILogicBase.resetCodeName();
        pSDEUILogicBase.resetCreateDate();
        pSDEUILogicBase.resetCreateMan();
        pSDEUILogicBase.resetLogicType();
        pSDEUILogicBase.resetMemo();
        pSDEUILogicBase.resetPSDEId();
        pSDEUILogicBase.resetPSDELogicId();
        pSDEUILogicBase.resetPSDELogicName();
        pSDEUILogicBase.resetPSDEName();
        pSDEUILogicBase.resetPSSysDynaModelId();
        pSDEUILogicBase.resetPSSysDynaModelName();
        pSDEUILogicBase.resetPSSysReqItemId();
        pSDEUILogicBase.resetPSSysReqItemName();
        pSDEUILogicBase.resetUpdateDate();
        pSDEUILogicBase.resetUpdateMan();
        pSDEUILogicBase.resetUserCat();
        pSDEUILogicBase.resetUserTag();
        pSDEUILogicBase.resetUserTag2();
        pSDEUILogicBase.resetUserTag3();
        pSDEUILogicBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicTypeDirty()) {
            hashMap.put(FIELD_LOGICTYPE, this.getLogicType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
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
        return PSDEUILogicBase.get(this, n);
    }

    private static Object get(PSDEUILogicBase pSDEUILogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUILogicBase.getCodeName();
            }
            case 1: {
                return pSDEUILogicBase.getCreateDate();
            }
            case 2: {
                return pSDEUILogicBase.getCreateMan();
            }
            case 3: {
                return pSDEUILogicBase.getLogicType();
            }
            case 4: {
                return pSDEUILogicBase.getMemo();
            }
            case 5: {
                return pSDEUILogicBase.getPSDEId();
            }
            case 6: {
                return pSDEUILogicBase.getPSDELogicId();
            }
            case 7: {
                return pSDEUILogicBase.getPSDELogicName();
            }
            case 8: {
                return pSDEUILogicBase.getPSDEName();
            }
            case 9: {
                return pSDEUILogicBase.getPSSysDynaModelId();
            }
            case 10: {
                return pSDEUILogicBase.getPSSysDynaModelName();
            }
            case 11: {
                return pSDEUILogicBase.getPSSysReqItemId();
            }
            case 12: {
                return pSDEUILogicBase.getPSSysReqItemName();
            }
            case 13: {
                return pSDEUILogicBase.getUpdateDate();
            }
            case 14: {
                return pSDEUILogicBase.getUpdateMan();
            }
            case 15: {
                return pSDEUILogicBase.getUserCat();
            }
            case 16: {
                return pSDEUILogicBase.getUserTag();
            }
            case 17: {
                return pSDEUILogicBase.getUserTag2();
            }
            case 18: {
                return pSDEUILogicBase.getUserTag3();
            }
            case 19: {
                return pSDEUILogicBase.getUserTag4();
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
        PSDEUILogicBase.set(this, n, object);
    }

    private static void set(PSDEUILogicBase pSDEUILogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUILogicBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEUILogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEUILogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEUILogicBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEUILogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEUILogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEUILogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEUILogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEUILogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEUILogicBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEUILogicBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEUILogicBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEUILogicBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEUILogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEUILogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEUILogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEUILogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEUILogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEUILogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEUILogicBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEUILogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUILogicBase pSDEUILogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUILogicBase.getCodeName() == null;
            }
            case 1: {
                return pSDEUILogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEUILogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEUILogicBase.getLogicType() == null;
            }
            case 4: {
                return pSDEUILogicBase.getMemo() == null;
            }
            case 5: {
                return pSDEUILogicBase.getPSDEId() == null;
            }
            case 6: {
                return pSDEUILogicBase.getPSDELogicId() == null;
            }
            case 7: {
                return pSDEUILogicBase.getPSDELogicName() == null;
            }
            case 8: {
                return pSDEUILogicBase.getPSDEName() == null;
            }
            case 9: {
                return pSDEUILogicBase.getPSSysDynaModelId() == null;
            }
            case 10: {
                return pSDEUILogicBase.getPSSysDynaModelName() == null;
            }
            case 11: {
                return pSDEUILogicBase.getPSSysReqItemId() == null;
            }
            case 12: {
                return pSDEUILogicBase.getPSSysReqItemName() == null;
            }
            case 13: {
                return pSDEUILogicBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDEUILogicBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDEUILogicBase.getUserCat() == null;
            }
            case 16: {
                return pSDEUILogicBase.getUserTag() == null;
            }
            case 17: {
                return pSDEUILogicBase.getUserTag2() == null;
            }
            case 18: {
                return pSDEUILogicBase.getUserTag3() == null;
            }
            case 19: {
                return pSDEUILogicBase.getUserTag4() == null;
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
        return PSDEUILogicBase.contains(this, n);
    }

    private static boolean contains(PSDEUILogicBase pSDEUILogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUILogicBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEUILogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEUILogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEUILogicBase.isLogicTypeDirty();
            }
            case 4: {
                return pSDEUILogicBase.isMemoDirty();
            }
            case 5: {
                return pSDEUILogicBase.isPSDEIdDirty();
            }
            case 6: {
                return pSDEUILogicBase.isPSDELogicIdDirty();
            }
            case 7: {
                return pSDEUILogicBase.isPSDELogicNameDirty();
            }
            case 8: {
                return pSDEUILogicBase.isPSDENameDirty();
            }
            case 9: {
                return pSDEUILogicBase.isPSSysDynaModelIdDirty();
            }
            case 10: {
                return pSDEUILogicBase.isPSSysDynaModelNameDirty();
            }
            case 11: {
                return pSDEUILogicBase.isPSSysReqItemIdDirty();
            }
            case 12: {
                return pSDEUILogicBase.isPSSysReqItemNameDirty();
            }
            case 13: {
                return pSDEUILogicBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDEUILogicBase.isUpdateManDirty();
            }
            case 15: {
                return pSDEUILogicBase.isUserCatDirty();
            }
            case 16: {
                return pSDEUILogicBase.isUserTagDirty();
            }
            case 17: {
                return pSDEUILogicBase.isUserTag2Dirty();
            }
            case 18: {
                return pSDEUILogicBase.isUserTag3Dirty();
            }
            case 19: {
                return pSDEUILogicBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUILogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUILogicBase pSDEUILogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUILogicBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getLogicType()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEUILogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEUILogicBase.getJSONValue((Object)pSDEUILogicBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUILogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUILogicBase pSDEUILogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUILogicBase.getCodeName() != null) {
            object = pSDEUILogicBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getCreateDate() != null) {
            object = pSDEUILogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUILogicBase.getCreateMan() != null) {
            object = pSDEUILogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getLogicType() != null) {
            object = pSDEUILogicBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getMemo() != null) {
            object = pSDEUILogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getPSDEId() != null) {
            object = pSDEUILogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getPSDELogicId() != null) {
            object = pSDEUILogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getPSDELogicName() != null) {
            object = pSDEUILogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getPSDEName() != null) {
            object = pSDEUILogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getPSSysDynaModelId() != null) {
            object = pSDEUILogicBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getPSSysDynaModelName() != null) {
            object = pSDEUILogicBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getPSSysReqItemId() != null) {
            object = pSDEUILogicBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getPSSysReqItemName() != null) {
            object = pSDEUILogicBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getUpdateDate() != null) {
            object = pSDEUILogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUILogicBase.getUpdateMan() != null) {
            object = pSDEUILogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getUserCat() != null) {
            object = pSDEUILogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getUserTag() != null) {
            object = pSDEUILogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getUserTag2() != null) {
            object = pSDEUILogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getUserTag3() != null) {
            object = pSDEUILogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUILogicBase.getUserTag4() != null) {
            object = pSDEUILogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUILogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUILogicBase pSDEUILogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUILogicBase.isCodeNameDirty() && (bl || pSDEUILogicBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEUILogicBase.getCodeName());
        }
        if (pSDEUILogicBase.isCreateDateDirty() && (bl || pSDEUILogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUILogicBase.getCreateDate());
        }
        if (pSDEUILogicBase.isCreateManDirty() && (bl || pSDEUILogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUILogicBase.getCreateMan());
        }
        if (pSDEUILogicBase.isLogicTypeDirty() && (bl || pSDEUILogicBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSDEUILogicBase.getLogicType());
        }
        if (pSDEUILogicBase.isMemoDirty() && (bl || pSDEUILogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEUILogicBase.getMemo());
        }
        if (pSDEUILogicBase.isPSDEIdDirty() && (bl || pSDEUILogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEUILogicBase.getPSDEId());
        }
        if (pSDEUILogicBase.isPSDELogicIdDirty() && (bl || pSDEUILogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEUILogicBase.getPSDELogicId());
        }
        if (pSDEUILogicBase.isPSDELogicNameDirty() && (bl || pSDEUILogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEUILogicBase.getPSDELogicName());
        }
        if (pSDEUILogicBase.isPSDENameDirty() && (bl || pSDEUILogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEUILogicBase.getPSDEName());
        }
        if (pSDEUILogicBase.isPSSysDynaModelIdDirty() && (bl || pSDEUILogicBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEUILogicBase.getPSSysDynaModelId());
        }
        if (pSDEUILogicBase.isPSSysDynaModelNameDirty() && (bl || pSDEUILogicBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEUILogicBase.getPSSysDynaModelName());
        }
        if (pSDEUILogicBase.isPSSysReqItemIdDirty() && (bl || pSDEUILogicBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEUILogicBase.getPSSysReqItemId());
        }
        if (pSDEUILogicBase.isPSSysReqItemNameDirty() && (bl || pSDEUILogicBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEUILogicBase.getPSSysReqItemName());
        }
        if (pSDEUILogicBase.isUpdateDateDirty() && (bl || pSDEUILogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUILogicBase.getUpdateDate());
        }
        if (pSDEUILogicBase.isUpdateManDirty() && (bl || pSDEUILogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUILogicBase.getUpdateMan());
        }
        if (pSDEUILogicBase.isUserCatDirty() && (bl || pSDEUILogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEUILogicBase.getUserCat());
        }
        if (pSDEUILogicBase.isUserTagDirty() && (bl || pSDEUILogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEUILogicBase.getUserTag());
        }
        if (pSDEUILogicBase.isUserTag2Dirty() && (bl || pSDEUILogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEUILogicBase.getUserTag2());
        }
        if (pSDEUILogicBase.isUserTag3Dirty() && (bl || pSDEUILogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEUILogicBase.getUserTag3());
        }
        if (pSDEUILogicBase.isUserTag4Dirty() && (bl || pSDEUILogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEUILogicBase.getUserTag4());
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
        return PSDEUILogicBase.remove(this, n);
    }

    private static boolean remove(PSDEUILogicBase pSDEUILogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUILogicBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEUILogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEUILogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEUILogicBase.resetLogicType();
                return true;
            }
            case 4: {
                pSDEUILogicBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEUILogicBase.resetPSDEId();
                return true;
            }
            case 6: {
                pSDEUILogicBase.resetPSDELogicId();
                return true;
            }
            case 7: {
                pSDEUILogicBase.resetPSDELogicName();
                return true;
            }
            case 8: {
                pSDEUILogicBase.resetPSDEName();
                return true;
            }
            case 9: {
                pSDEUILogicBase.resetPSSysDynaModelId();
                return true;
            }
            case 10: {
                pSDEUILogicBase.resetPSSysDynaModelName();
                return true;
            }
            case 11: {
                pSDEUILogicBase.resetPSSysReqItemId();
                return true;
            }
            case 12: {
                pSDEUILogicBase.resetPSSysReqItemName();
                return true;
            }
            case 13: {
                pSDEUILogicBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDEUILogicBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDEUILogicBase.resetUserCat();
                return true;
            }
            case 16: {
                pSDEUILogicBase.resetUserTag();
                return true;
            }
            case 17: {
                pSDEUILogicBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSDEUILogicBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSDEUILogicBase.resetUserTag4();
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
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    private PSDEUILogicBase getProxyEntity() {
        return this.proxyPSDEUILogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUILogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUILogicBase) {
            this.proxyPSDEUILogicBase = (PSDEUILogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUILogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOGICTYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEID, 5);
        fieldIndexMap.put(FIELD_PSDELOGICID, 6);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 7);
        fieldIndexMap.put(FIELD_PSDENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 9);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 11);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
    }
}

