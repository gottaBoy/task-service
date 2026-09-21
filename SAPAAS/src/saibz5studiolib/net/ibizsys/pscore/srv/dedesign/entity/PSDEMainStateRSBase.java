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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMainStateRSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMainStateRSBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENTERPSDEACTIONID = "ENTERPSDEACTIONID";
    public static final String FIELD_ENTERPSDEACTIONNAME = "ENTERPSDEACTIONNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEXTPSDEMSID = "NEXTPSDEMSID";
    public static final String FIELD_NEXTPSDEMSNAME = "NEXTPSDEMSNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PREVPSDEMSID = "PREVPSDEMSID";
    public static final String FIELD_PREVPSDEMSNAME = "PREVPSDEMSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAINSTATERSID = "PSDEMAINSTATERSID";
    public static final String FIELD_PSDEMAINSTATERSNAME = "PSDEMAINSTATERSNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENTERPSDEACTIONID = 3;
    private static final int INDEX_ENTERPSDEACTIONNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_NEXTPSDEMSID = 6;
    private static final int INDEX_NEXTPSDEMSNAME = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PREVPSDEMSID = 9;
    private static final int INDEX_PREVPSDEMSNAME = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_PSDEMAINSTATERSID = 12;
    private static final int INDEX_PSDEMAINSTATERSNAME = 13;
    private static final int INDEX_PSDENAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final int INDEX_USERTAG3 = 20;
    private static final int INDEX_USERTAG4 = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMainStateRSBase proxyPSDEMainStateRSBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enterpsdeactionidDirtyFlag = false;
    private boolean enterpsdeactionnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nextpsdemsidDirtyFlag = false;
    private boolean nextpsdemsnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean prevpsdemsidDirtyFlag = false;
    private boolean prevpsdemsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemainstatersidDirtyFlag = false;
    private boolean psdemainstatersnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enterpsdeactionid")
    private String enterpsdeactionid;
    @Column(name="enterpsdeactionname")
    private String enterpsdeactionname;
    @Column(name="memo")
    private String memo;
    @Column(name="nextpsdemsid")
    private String nextpsdemsid;
    @Column(name="nextpsdemsname")
    private String nextpsdemsname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="prevpsdemsid")
    private String prevpsdemsid;
    @Column(name="prevpsdemsname")
    private String prevpsdemsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemainstatersid")
    private String psdemainstatersid;
    @Column(name="psdemainstatersname")
    private String psdemainstatersname;
    @Column(name="psdename")
    private String psdename;
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
    private Integer objEnterPSDEActionLock = new Integer(1);
    private PSDEAction enterpsdeaction = null;
    private Integer objNextPSDEMSLock = new Integer(1);
    private PSDEMainState nextpsdems = null;
    private Integer objPrevPSDEMSLock = new Integer(1);
    private PSDEMainState prevpsdems = null;

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

    public void setEnterPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnterPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enterpsdeactionid = string;
        this.enterpsdeactionidDirtyFlag = true;
    }

    public String getEnterPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnterPSDEActionId();
        }
        return this.enterpsdeactionid;
    }

    public boolean isEnterPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnterPSDEActionIdDirty();
        }
        return this.enterpsdeactionidDirtyFlag;
    }

    public void resetEnterPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnterPSDEActionId();
            return;
        }
        this.enterpsdeactionidDirtyFlag = false;
        this.enterpsdeactionid = null;
    }

    public void setEnterPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnterPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enterpsdeactionname = string;
        this.enterpsdeactionnameDirtyFlag = true;
    }

    public String getEnterPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnterPSDEActionName();
        }
        return this.enterpsdeactionname;
    }

    public boolean isEnterPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnterPSDEActionNameDirty();
        }
        return this.enterpsdeactionnameDirtyFlag;
    }

    public void resetEnterPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnterPSDEActionName();
            return;
        }
        this.enterpsdeactionnameDirtyFlag = false;
        this.enterpsdeactionname = null;
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

    public void setNextPSDEMSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextPSDEMSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextpsdemsid = string;
        this.nextpsdemsidDirtyFlag = true;
    }

    public String getNextPSDEMSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEMSId();
        }
        return this.nextpsdemsid;
    }

    public boolean isNextPSDEMSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextPSDEMSIdDirty();
        }
        return this.nextpsdemsidDirtyFlag;
    }

    public void resetNextPSDEMSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextPSDEMSId();
            return;
        }
        this.nextpsdemsidDirtyFlag = false;
        this.nextpsdemsid = null;
    }

    public void setNextPSDEMSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextPSDEMSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextpsdemsname = string;
        this.nextpsdemsnameDirtyFlag = true;
    }

    public String getNextPSDEMSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEMSName();
        }
        return this.nextpsdemsname;
    }

    public boolean isNextPSDEMSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextPSDEMSNameDirty();
        }
        return this.nextpsdemsnameDirtyFlag;
    }

    public void resetNextPSDEMSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextPSDEMSName();
            return;
        }
        this.nextpsdemsnameDirtyFlag = false;
        this.nextpsdemsname = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPrevPSDEMSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevPSDEMSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prevpsdemsid = string;
        this.prevpsdemsidDirtyFlag = true;
    }

    public String getPrevPSDEMSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSDEMSId();
        }
        return this.prevpsdemsid;
    }

    public boolean isPrevPSDEMSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevPSDEMSIdDirty();
        }
        return this.prevpsdemsidDirtyFlag;
    }

    public void resetPrevPSDEMSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevPSDEMSId();
            return;
        }
        this.prevpsdemsidDirtyFlag = false;
        this.prevpsdemsid = null;
    }

    public void setPrevPSDEMSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevPSDEMSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prevpsdemsname = string;
        this.prevpsdemsnameDirtyFlag = true;
    }

    public String getPrevPSDEMSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSDEMSName();
        }
        return this.prevpsdemsname;
    }

    public boolean isPrevPSDEMSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevPSDEMSNameDirty();
        }
        return this.prevpsdemsnameDirtyFlag;
    }

    public void resetPrevPSDEMSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevPSDEMSName();
            return;
        }
        this.prevpsdemsnameDirtyFlag = false;
        this.prevpsdemsname = null;
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

    public void setPSDEMainStateRSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateRSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatersid = string;
        this.psdemainstatersidDirtyFlag = true;
    }

    public String getPSDEMainStateRSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateRSId();
        }
        return this.psdemainstatersid;
    }

    public boolean isPSDEMainStateRSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateRSIdDirty();
        }
        return this.psdemainstatersidDirtyFlag;
    }

    public void resetPSDEMainStateRSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateRSId();
            return;
        }
        this.psdemainstatersidDirtyFlag = false;
        this.psdemainstatersid = null;
    }

    public void setPSDEMainStateRSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateRSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatersname = string;
        this.psdemainstatersnameDirtyFlag = true;
    }

    public String getPSDEMainStateRSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateRSName();
        }
        return this.psdemainstatersname;
    }

    public boolean isPSDEMainStateRSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateRSNameDirty();
        }
        return this.psdemainstatersnameDirtyFlag;
    }

    public void resetPSDEMainStateRSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateRSName();
            return;
        }
        this.psdemainstatersnameDirtyFlag = false;
        this.psdemainstatersname = null;
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
        PSDEMainStateRSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMainStateRSBase pSDEMainStateRSBase) {
        pSDEMainStateRSBase.resetCodeName();
        pSDEMainStateRSBase.resetCreateDate();
        pSDEMainStateRSBase.resetCreateMan();
        pSDEMainStateRSBase.resetEnterPSDEActionId();
        pSDEMainStateRSBase.resetEnterPSDEActionName();
        pSDEMainStateRSBase.resetMemo();
        pSDEMainStateRSBase.resetNextPSDEMSId();
        pSDEMainStateRSBase.resetNextPSDEMSName();
        pSDEMainStateRSBase.resetOrderValue();
        pSDEMainStateRSBase.resetPrevPSDEMSId();
        pSDEMainStateRSBase.resetPrevPSDEMSName();
        pSDEMainStateRSBase.resetPSDEId();
        pSDEMainStateRSBase.resetPSDEMainStateRSId();
        pSDEMainStateRSBase.resetPSDEMainStateRSName();
        pSDEMainStateRSBase.resetPSDEName();
        pSDEMainStateRSBase.resetUpdateDate();
        pSDEMainStateRSBase.resetUpdateMan();
        pSDEMainStateRSBase.resetUserCat();
        pSDEMainStateRSBase.resetUserTag();
        pSDEMainStateRSBase.resetUserTag2();
        pSDEMainStateRSBase.resetUserTag3();
        pSDEMainStateRSBase.resetUserTag4();
        pSDEMainStateRSBase.resetValidFlag();
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
        if (!bl || this.isEnterPSDEActionIdDirty()) {
            hashMap.put(FIELD_ENTERPSDEACTIONID, this.getEnterPSDEActionId());
        }
        if (!bl || this.isEnterPSDEActionNameDirty()) {
            hashMap.put(FIELD_ENTERPSDEACTIONNAME, this.getEnterPSDEActionName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNextPSDEMSIdDirty()) {
            hashMap.put(FIELD_NEXTPSDEMSID, this.getNextPSDEMSId());
        }
        if (!bl || this.isNextPSDEMSNameDirty()) {
            hashMap.put(FIELD_NEXTPSDEMSNAME, this.getNextPSDEMSName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPrevPSDEMSIdDirty()) {
            hashMap.put(FIELD_PREVPSDEMSID, this.getPrevPSDEMSId());
        }
        if (!bl || this.isPrevPSDEMSNameDirty()) {
            hashMap.put(FIELD_PREVPSDEMSNAME, this.getPrevPSDEMSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMainStateRSIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATERSID, this.getPSDEMainStateRSId());
        }
        if (!bl || this.isPSDEMainStateRSNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATERSNAME, this.getPSDEMainStateRSName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
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
        return PSDEMainStateRSBase.get(this, n);
    }

    private static Object get(PSDEMainStateRSBase pSDEMainStateRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMainStateRSBase.getCodeName();
            }
            case 1: {
                return pSDEMainStateRSBase.getCreateDate();
            }
            case 2: {
                return pSDEMainStateRSBase.getCreateMan();
            }
            case 3: {
                return pSDEMainStateRSBase.getEnterPSDEActionId();
            }
            case 4: {
                return pSDEMainStateRSBase.getEnterPSDEActionName();
            }
            case 5: {
                return pSDEMainStateRSBase.getMemo();
            }
            case 6: {
                return pSDEMainStateRSBase.getNextPSDEMSId();
            }
            case 7: {
                return pSDEMainStateRSBase.getNextPSDEMSName();
            }
            case 8: {
                return pSDEMainStateRSBase.getOrderValue();
            }
            case 9: {
                return pSDEMainStateRSBase.getPrevPSDEMSId();
            }
            case 10: {
                return pSDEMainStateRSBase.getPrevPSDEMSName();
            }
            case 11: {
                return pSDEMainStateRSBase.getPSDEId();
            }
            case 12: {
                return pSDEMainStateRSBase.getPSDEMainStateRSId();
            }
            case 13: {
                return pSDEMainStateRSBase.getPSDEMainStateRSName();
            }
            case 14: {
                return pSDEMainStateRSBase.getPSDEName();
            }
            case 15: {
                return pSDEMainStateRSBase.getUpdateDate();
            }
            case 16: {
                return pSDEMainStateRSBase.getUpdateMan();
            }
            case 17: {
                return pSDEMainStateRSBase.getUserCat();
            }
            case 18: {
                return pSDEMainStateRSBase.getUserTag();
            }
            case 19: {
                return pSDEMainStateRSBase.getUserTag2();
            }
            case 20: {
                return pSDEMainStateRSBase.getUserTag3();
            }
            case 21: {
                return pSDEMainStateRSBase.getUserTag4();
            }
            case 22: {
                return pSDEMainStateRSBase.getValidFlag();
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
        PSDEMainStateRSBase.set(this, n, object);
    }

    private static void set(PSDEMainStateRSBase pSDEMainStateRSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMainStateRSBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEMainStateRSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEMainStateRSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMainStateRSBase.setEnterPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEMainStateRSBase.setEnterPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMainStateRSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEMainStateRSBase.setNextPSDEMSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMainStateRSBase.setNextPSDEMSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMainStateRSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEMainStateRSBase.setPrevPSDEMSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMainStateRSBase.setPrevPSDEMSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMainStateRSBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMainStateRSBase.setPSDEMainStateRSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMainStateRSBase.setPSDEMainStateRSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMainStateRSBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMainStateRSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDEMainStateRSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEMainStateRSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMainStateRSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEMainStateRSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEMainStateRSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEMainStateRSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEMainStateRSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMainStateRSBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMainStateRSBase pSDEMainStateRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMainStateRSBase.getCodeName() == null;
            }
            case 1: {
                return pSDEMainStateRSBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEMainStateRSBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEMainStateRSBase.getEnterPSDEActionId() == null;
            }
            case 4: {
                return pSDEMainStateRSBase.getEnterPSDEActionName() == null;
            }
            case 5: {
                return pSDEMainStateRSBase.getMemo() == null;
            }
            case 6: {
                return pSDEMainStateRSBase.getNextPSDEMSId() == null;
            }
            case 7: {
                return pSDEMainStateRSBase.getNextPSDEMSName() == null;
            }
            case 8: {
                return pSDEMainStateRSBase.getOrderValue() == null;
            }
            case 9: {
                return pSDEMainStateRSBase.getPrevPSDEMSId() == null;
            }
            case 10: {
                return pSDEMainStateRSBase.getPrevPSDEMSName() == null;
            }
            case 11: {
                return pSDEMainStateRSBase.getPSDEId() == null;
            }
            case 12: {
                return pSDEMainStateRSBase.getPSDEMainStateRSId() == null;
            }
            case 13: {
                return pSDEMainStateRSBase.getPSDEMainStateRSName() == null;
            }
            case 14: {
                return pSDEMainStateRSBase.getPSDEName() == null;
            }
            case 15: {
                return pSDEMainStateRSBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDEMainStateRSBase.getUpdateMan() == null;
            }
            case 17: {
                return pSDEMainStateRSBase.getUserCat() == null;
            }
            case 18: {
                return pSDEMainStateRSBase.getUserTag() == null;
            }
            case 19: {
                return pSDEMainStateRSBase.getUserTag2() == null;
            }
            case 20: {
                return pSDEMainStateRSBase.getUserTag3() == null;
            }
            case 21: {
                return pSDEMainStateRSBase.getUserTag4() == null;
            }
            case 22: {
                return pSDEMainStateRSBase.getValidFlag() == null;
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
        return PSDEMainStateRSBase.contains(this, n);
    }

    private static boolean contains(PSDEMainStateRSBase pSDEMainStateRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMainStateRSBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEMainStateRSBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEMainStateRSBase.isCreateManDirty();
            }
            case 3: {
                return pSDEMainStateRSBase.isEnterPSDEActionIdDirty();
            }
            case 4: {
                return pSDEMainStateRSBase.isEnterPSDEActionNameDirty();
            }
            case 5: {
                return pSDEMainStateRSBase.isMemoDirty();
            }
            case 6: {
                return pSDEMainStateRSBase.isNextPSDEMSIdDirty();
            }
            case 7: {
                return pSDEMainStateRSBase.isNextPSDEMSNameDirty();
            }
            case 8: {
                return pSDEMainStateRSBase.isOrderValueDirty();
            }
            case 9: {
                return pSDEMainStateRSBase.isPrevPSDEMSIdDirty();
            }
            case 10: {
                return pSDEMainStateRSBase.isPrevPSDEMSNameDirty();
            }
            case 11: {
                return pSDEMainStateRSBase.isPSDEIdDirty();
            }
            case 12: {
                return pSDEMainStateRSBase.isPSDEMainStateRSIdDirty();
            }
            case 13: {
                return pSDEMainStateRSBase.isPSDEMainStateRSNameDirty();
            }
            case 14: {
                return pSDEMainStateRSBase.isPSDENameDirty();
            }
            case 15: {
                return pSDEMainStateRSBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDEMainStateRSBase.isUpdateManDirty();
            }
            case 17: {
                return pSDEMainStateRSBase.isUserCatDirty();
            }
            case 18: {
                return pSDEMainStateRSBase.isUserTagDirty();
            }
            case 19: {
                return pSDEMainStateRSBase.isUserTag2Dirty();
            }
            case 20: {
                return pSDEMainStateRSBase.isUserTag3Dirty();
            }
            case 21: {
                return pSDEMainStateRSBase.isUserTag4Dirty();
            }
            case 22: {
                return pSDEMainStateRSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMainStateRSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMainStateRSBase pSDEMainStateRSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMainStateRSBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getEnterPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enterpsdeactionid", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getEnterPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getEnterPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enterpsdeactionname", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getEnterPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getNextPSDEMSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextpsdemsid", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getNextPSDEMSId()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getNextPSDEMSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextpsdemsname", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getNextPSDEMSName()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getPrevPSDEMSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prevpsdemsid", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getPrevPSDEMSId()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getPrevPSDEMSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prevpsdemsname", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getPrevPSDEMSName()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getPSDEMainStateRSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatersid", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getPSDEMainStateRSId()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getPSDEMainStateRSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatersname", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getPSDEMainStateRSName()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMainStateRSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMainStateRSBase.getJSONValue((Object)pSDEMainStateRSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMainStateRSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMainStateRSBase pSDEMainStateRSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMainStateRSBase.getCodeName() != null) {
            object = pSDEMainStateRSBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getCreateDate() != null) {
            object = pSDEMainStateRSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMainStateRSBase.getCreateMan() != null) {
            object = pSDEMainStateRSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getEnterPSDEActionId() != null) {
            object = pSDEMainStateRSBase.getEnterPSDEActionId();
            xmlNode.setAttribute(FIELD_ENTERPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getEnterPSDEActionName() != null) {
            object = pSDEMainStateRSBase.getEnterPSDEActionName();
            xmlNode.setAttribute(FIELD_ENTERPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getMemo() != null) {
            object = pSDEMainStateRSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getNextPSDEMSId() != null) {
            object = pSDEMainStateRSBase.getNextPSDEMSId();
            xmlNode.setAttribute(FIELD_NEXTPSDEMSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getNextPSDEMSName() != null) {
            object = pSDEMainStateRSBase.getNextPSDEMSName();
            xmlNode.setAttribute(FIELD_NEXTPSDEMSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getOrderValue() != null) {
            object = pSDEMainStateRSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMainStateRSBase.getPrevPSDEMSId() != null) {
            object = pSDEMainStateRSBase.getPrevPSDEMSId();
            xmlNode.setAttribute(FIELD_PREVPSDEMSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getPrevPSDEMSName() != null) {
            object = pSDEMainStateRSBase.getPrevPSDEMSName();
            xmlNode.setAttribute(FIELD_PREVPSDEMSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getPSDEId() != null) {
            object = pSDEMainStateRSBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getPSDEMainStateRSId() != null) {
            object = pSDEMainStateRSBase.getPSDEMainStateRSId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATERSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getPSDEMainStateRSName() != null) {
            object = pSDEMainStateRSBase.getPSDEMainStateRSName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATERSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getPSDEName() != null) {
            object = pSDEMainStateRSBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getUpdateDate() != null) {
            object = pSDEMainStateRSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMainStateRSBase.getUpdateMan() != null) {
            object = pSDEMainStateRSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getUserCat() != null) {
            object = pSDEMainStateRSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getUserTag() != null) {
            object = pSDEMainStateRSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getUserTag2() != null) {
            object = pSDEMainStateRSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getUserTag3() != null) {
            object = pSDEMainStateRSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getUserTag4() != null) {
            object = pSDEMainStateRSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateRSBase.getValidFlag() != null) {
            object = pSDEMainStateRSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMainStateRSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMainStateRSBase pSDEMainStateRSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMainStateRSBase.isCodeNameDirty() && (bl || pSDEMainStateRSBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEMainStateRSBase.getCodeName());
        }
        if (pSDEMainStateRSBase.isCreateDateDirty() && (bl || pSDEMainStateRSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMainStateRSBase.getCreateDate());
        }
        if (pSDEMainStateRSBase.isCreateManDirty() && (bl || pSDEMainStateRSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMainStateRSBase.getCreateMan());
        }
        if (pSDEMainStateRSBase.isEnterPSDEActionIdDirty() && (bl || pSDEMainStateRSBase.getEnterPSDEActionId() != null)) {
            iDataObject.set(FIELD_ENTERPSDEACTIONID, (Object)pSDEMainStateRSBase.getEnterPSDEActionId());
        }
        if (pSDEMainStateRSBase.isEnterPSDEActionNameDirty() && (bl || pSDEMainStateRSBase.getEnterPSDEActionName() != null)) {
            iDataObject.set(FIELD_ENTERPSDEACTIONNAME, (Object)pSDEMainStateRSBase.getEnterPSDEActionName());
        }
        if (pSDEMainStateRSBase.isMemoDirty() && (bl || pSDEMainStateRSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMainStateRSBase.getMemo());
        }
        if (pSDEMainStateRSBase.isNextPSDEMSIdDirty() && (bl || pSDEMainStateRSBase.getNextPSDEMSId() != null)) {
            iDataObject.set(FIELD_NEXTPSDEMSID, (Object)pSDEMainStateRSBase.getNextPSDEMSId());
        }
        if (pSDEMainStateRSBase.isNextPSDEMSNameDirty() && (bl || pSDEMainStateRSBase.getNextPSDEMSName() != null)) {
            iDataObject.set(FIELD_NEXTPSDEMSNAME, (Object)pSDEMainStateRSBase.getNextPSDEMSName());
        }
        if (pSDEMainStateRSBase.isOrderValueDirty() && (bl || pSDEMainStateRSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEMainStateRSBase.getOrderValue());
        }
        if (pSDEMainStateRSBase.isPrevPSDEMSIdDirty() && (bl || pSDEMainStateRSBase.getPrevPSDEMSId() != null)) {
            iDataObject.set(FIELD_PREVPSDEMSID, (Object)pSDEMainStateRSBase.getPrevPSDEMSId());
        }
        if (pSDEMainStateRSBase.isPrevPSDEMSNameDirty() && (bl || pSDEMainStateRSBase.getPrevPSDEMSName() != null)) {
            iDataObject.set(FIELD_PREVPSDEMSNAME, (Object)pSDEMainStateRSBase.getPrevPSDEMSName());
        }
        if (pSDEMainStateRSBase.isPSDEIdDirty() && (bl || pSDEMainStateRSBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMainStateRSBase.getPSDEId());
        }
        if (pSDEMainStateRSBase.isPSDEMainStateRSIdDirty() && (bl || pSDEMainStateRSBase.getPSDEMainStateRSId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATERSID, (Object)pSDEMainStateRSBase.getPSDEMainStateRSId());
        }
        if (pSDEMainStateRSBase.isPSDEMainStateRSNameDirty() && (bl || pSDEMainStateRSBase.getPSDEMainStateRSName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATERSNAME, (Object)pSDEMainStateRSBase.getPSDEMainStateRSName());
        }
        if (pSDEMainStateRSBase.isPSDENameDirty() && (bl || pSDEMainStateRSBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEMainStateRSBase.getPSDEName());
        }
        if (pSDEMainStateRSBase.isUpdateDateDirty() && (bl || pSDEMainStateRSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMainStateRSBase.getUpdateDate());
        }
        if (pSDEMainStateRSBase.isUpdateManDirty() && (bl || pSDEMainStateRSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMainStateRSBase.getUpdateMan());
        }
        if (pSDEMainStateRSBase.isUserCatDirty() && (bl || pSDEMainStateRSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMainStateRSBase.getUserCat());
        }
        if (pSDEMainStateRSBase.isUserTagDirty() && (bl || pSDEMainStateRSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMainStateRSBase.getUserTag());
        }
        if (pSDEMainStateRSBase.isUserTag2Dirty() && (bl || pSDEMainStateRSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMainStateRSBase.getUserTag2());
        }
        if (pSDEMainStateRSBase.isUserTag3Dirty() && (bl || pSDEMainStateRSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMainStateRSBase.getUserTag3());
        }
        if (pSDEMainStateRSBase.isUserTag4Dirty() && (bl || pSDEMainStateRSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMainStateRSBase.getUserTag4());
        }
        if (pSDEMainStateRSBase.isValidFlagDirty() && (bl || pSDEMainStateRSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMainStateRSBase.getValidFlag());
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
        return PSDEMainStateRSBase.remove(this, n);
    }

    private static boolean remove(PSDEMainStateRSBase pSDEMainStateRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMainStateRSBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEMainStateRSBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEMainStateRSBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEMainStateRSBase.resetEnterPSDEActionId();
                return true;
            }
            case 4: {
                pSDEMainStateRSBase.resetEnterPSDEActionName();
                return true;
            }
            case 5: {
                pSDEMainStateRSBase.resetMemo();
                return true;
            }
            case 6: {
                pSDEMainStateRSBase.resetNextPSDEMSId();
                return true;
            }
            case 7: {
                pSDEMainStateRSBase.resetNextPSDEMSName();
                return true;
            }
            case 8: {
                pSDEMainStateRSBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSDEMainStateRSBase.resetPrevPSDEMSId();
                return true;
            }
            case 10: {
                pSDEMainStateRSBase.resetPrevPSDEMSName();
                return true;
            }
            case 11: {
                pSDEMainStateRSBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSDEMainStateRSBase.resetPSDEMainStateRSId();
                return true;
            }
            case 13: {
                pSDEMainStateRSBase.resetPSDEMainStateRSName();
                return true;
            }
            case 14: {
                pSDEMainStateRSBase.resetPSDEName();
                return true;
            }
            case 15: {
                pSDEMainStateRSBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDEMainStateRSBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSDEMainStateRSBase.resetUserCat();
                return true;
            }
            case 18: {
                pSDEMainStateRSBase.resetUserTag();
                return true;
            }
            case 19: {
                pSDEMainStateRSBase.resetUserTag2();
                return true;
            }
            case 20: {
                pSDEMainStateRSBase.resetUserTag3();
                return true;
            }
            case 21: {
                pSDEMainStateRSBase.resetUserTag4();
                return true;
            }
            case 22: {
                pSDEMainStateRSBase.resetValidFlag();
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
    public PSDEAction getEnterPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnterPSDEAction();
        }
        if (this.getEnterPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objEnterPSDEActionLock;
        synchronized (n) {
            if (this.enterpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getEnterPSDEActionId(), (Object)this.enterpsdeaction.getPSDEActionId()) != 0L) {
                this.enterpsdeaction = null;
            }
            if (this.enterpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getEnterPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.enterpsdeaction = pSDEAction;
            }
            return this.enterpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getNextPSDEMS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSDEMS();
        }
        if (this.getNextPSDEMSId() == null) {
            return null;
        }
        Integer n = this.objNextPSDEMSLock;
        synchronized (n) {
            if (this.nextpsdems != null && DataTypeHelper.compare((int)25, (Object)this.getNextPSDEMSId(), (Object)this.nextpsdems.getPSDEMainStateId()) != 0L) {
                this.nextpsdems = null;
            }
            if (this.nextpsdems == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getNextPSDEMSId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet((IEntity)pSDEMainState);
                this.nextpsdems = pSDEMainState;
            }
            return this.nextpsdems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPrevPSDEMS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSDEMS();
        }
        if (this.getPrevPSDEMSId() == null) {
            return null;
        }
        Integer n = this.objPrevPSDEMSLock;
        synchronized (n) {
            if (this.prevpsdems != null && DataTypeHelper.compare((int)25, (Object)this.getPrevPSDEMSId(), (Object)this.prevpsdems.getPSDEMainStateId()) != 0L) {
                this.prevpsdems = null;
            }
            if (this.prevpsdems == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPrevPSDEMSId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet((IEntity)pSDEMainState);
                this.prevpsdems = pSDEMainState;
            }
            return this.prevpsdems;
        }
    }

    private PSDEMainStateRSBase getProxyEntity() {
        return this.proxyPSDEMainStateRSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMainStateRSBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMainStateRSBase) {
            this.proxyPSDEMainStateRSBase = (PSDEMainStateRSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateRSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENTERPSDEACTIONID, 3);
        fieldIndexMap.put(FIELD_ENTERPSDEACTIONNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_NEXTPSDEMSID, 6);
        fieldIndexMap.put(FIELD_NEXTPSDEMSNAME, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PREVPSDEMSID, 9);
        fieldIndexMap.put(FIELD_PREVPSDEMSNAME, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_PSDEMAINSTATERSID, 12);
        fieldIndexMap.put(FIELD_PSDEMAINSTATERSNAME, 13);
        fieldIndexMap.put(FIELD_PSDENAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
        fieldIndexMap.put(FIELD_USERTAG3, 20);
        fieldIndexMap.put(FIELD_USERTAG4, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

