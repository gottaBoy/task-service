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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppSBItemRSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppSBItemRSBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CPSAPPSBITEMID = "CPSAPPSBITEMID";
    public static final String FIELD_CPSAPPSBITEMNAME = "CPSAPPSBITEMNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTENDPOINT = "DSTENDPOINT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSAPPSBITEMID = "PPSAPPSBITEMID";
    public static final String FIELD_PPSAPPSBITEMNAME = "PPSAPPSBITEMNAME";
    public static final String FIELD_PSAPPSBITEMRSID = "PSAPPSBITEMRSID";
    public static final String FIELD_PSAPPSBITEMRSNAME = "PSAPPSBITEMRSNAME";
    public static final String FIELD_PSAPPSTORYBOARDID = "PSAPPSTORYBOARDID";
    public static final String FIELD_PSAPPSTORYBOARDNAME = "PSAPPSTORYBOARDNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String FIELD_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String FIELD_RSTAG = "RSTAG";
    public static final String FIELD_RSTAG2 = "RSTAG2";
    public static final String FIELD_RSTAG3 = "RSTAG3";
    public static final String FIELD_RSTAG4 = "RSTAG4";
    public static final String FIELD_RSTYPE = "RSTYPE";
    public static final String FIELD_SRCENDPOINT = "SRCENDPOINT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERFLAG = "USERFLAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CPSAPPSBITEMID = 1;
    private static final int INDEX_CPSAPPSBITEMNAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DSTENDPOINT = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PPSAPPSBITEMID = 8;
    private static final int INDEX_PPSAPPSBITEMNAME = 9;
    private static final int INDEX_PSAPPSBITEMRSID = 10;
    private static final int INDEX_PSAPPSBITEMRSNAME = 11;
    private static final int INDEX_PSAPPSTORYBOARDID = 12;
    private static final int INDEX_PSAPPSTORYBOARDNAME = 13;
    private static final int INDEX_PSDYNAINSTID = 14;
    private static final int INDEX_PSSYSAPPID = 15;
    private static final int INDEX_PSSYSREQITEMID = 16;
    private static final int INDEX_PSSYSREQITEMNAME = 17;
    private static final int INDEX_PSSYSUSERCASEID = 18;
    private static final int INDEX_PSSYSUSERCASENAME = 19;
    private static final int INDEX_RSTAG = 20;
    private static final int INDEX_RSTAG2 = 21;
    private static final int INDEX_RSTAG3 = 22;
    private static final int INDEX_RSTAG4 = 23;
    private static final int INDEX_RSTYPE = 24;
    private static final int INDEX_SRCENDPOINT = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERFLAG = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final int INDEX_VALIDFLAG = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppSBItemRSBase proxyPSAppSBItemRSBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean cpsappsbitemidDirtyFlag = false;
    private boolean cpsappsbitemnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstendpointDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsappsbitemidDirtyFlag = false;
    private boolean ppsappsbitemnameDirtyFlag = false;
    private boolean psappsbitemrsidDirtyFlag = false;
    private boolean psappsbitemrsnameDirtyFlag = false;
    private boolean psappstoryboardidDirtyFlag = false;
    private boolean psappstoryboardnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysusercaseidDirtyFlag = false;
    private boolean pssysusercasenameDirtyFlag = false;
    private boolean rstagDirtyFlag = false;
    private boolean rstag2DirtyFlag = false;
    private boolean rstag3DirtyFlag = false;
    private boolean rstag4DirtyFlag = false;
    private boolean rstypeDirtyFlag = false;
    private boolean srcendpointDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userflagDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="cpsappsbitemid")
    private String cpsappsbitemid;
    @Column(name="cpsappsbitemname")
    private String cpsappsbitemname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstendpoint")
    private String dstendpoint;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsappsbitemid")
    private String ppsappsbitemid;
    @Column(name="ppsappsbitemname")
    private String ppsappsbitemname;
    @Column(name="psappsbitemrsid")
    private String psappsbitemrsid;
    @Column(name="psappsbitemrsname")
    private String psappsbitemrsname;
    @Column(name="psappstoryboardid")
    private String psappstoryboardid;
    @Column(name="psappstoryboardname")
    private String psappstoryboardname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssysusercaseid")
    private String pssysusercaseid;
    @Column(name="pssysusercasename")
    private String pssysusercasename;
    @Column(name="rstag")
    private String rstag;
    @Column(name="rstag2")
    private String rstag2;
    @Column(name="rstag3")
    private String rstag3;
    @Column(name="rstag4")
    private String rstag4;
    @Column(name="rstype")
    private String rstype;
    @Column(name="srcendpoint")
    private String srcendpoint;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userflag")
    private Integer userflag;
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
    private Integer objCPSAppSBItemLock = new Integer(1);
    private PSAppSBItem cpsappsbitem = null;
    private Integer objPPSAppSBItemLock = new Integer(1);
    private PSAppSBItem ppsappsbitem = null;
    private Integer objPSAppStoryBoardLock = new Integer(1);
    private PSAppStoryBoard psappstoryboard = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysUserCaseLock = new Integer(1);
    private PSSysUserCase pssysusercase = null;

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

    public void setCPSAppSBItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSAppSBItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsappsbitemid = string;
        this.cpsappsbitemidDirtyFlag = true;
    }

    public String getCPSAppSBItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSAppSBItemId();
        }
        return this.cpsappsbitemid;
    }

    public boolean isCPSAppSBItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSAppSBItemIdDirty();
        }
        return this.cpsappsbitemidDirtyFlag;
    }

    public void resetCPSAppSBItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSAppSBItemId();
            return;
        }
        this.cpsappsbitemidDirtyFlag = false;
        this.cpsappsbitemid = null;
    }

    public void setCPSAppSBItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSAppSBItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsappsbitemname = string;
        this.cpsappsbitemnameDirtyFlag = true;
    }

    public String getCPSAppSBItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSAppSBItemName();
        }
        return this.cpsappsbitemname;
    }

    public boolean isCPSAppSBItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSAppSBItemNameDirty();
        }
        return this.cpsappsbitemnameDirtyFlag;
    }

    public void resetCPSAppSBItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSAppSBItemName();
            return;
        }
        this.cpsappsbitemnameDirtyFlag = false;
        this.cpsappsbitemname = null;
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

    public void setDstEndPoint(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstEndPoint(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstendpoint = string;
        this.dstendpointDirtyFlag = true;
    }

    public String getDstEndPoint() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstEndPoint();
        }
        return this.dstendpoint;
    }

    public boolean isDstEndPointDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstEndPointDirty();
        }
        return this.dstendpointDirtyFlag;
    }

    public void resetDstEndPoint() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstEndPoint();
            return;
        }
        this.dstendpointDirtyFlag = false;
        this.dstendpoint = null;
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

    public void setPPSAppSBItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppSBItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsappsbitemid = string;
        this.ppsappsbitemidDirtyFlag = true;
    }

    public String getPPSAppSBItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppSBItemId();
        }
        return this.ppsappsbitemid;
    }

    public boolean isPPSAppSBItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppSBItemIdDirty();
        }
        return this.ppsappsbitemidDirtyFlag;
    }

    public void resetPPSAppSBItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppSBItemId();
            return;
        }
        this.ppsappsbitemidDirtyFlag = false;
        this.ppsappsbitemid = null;
    }

    public void setPPSAppSBItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppSBItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsappsbitemname = string;
        this.ppsappsbitemnameDirtyFlag = true;
    }

    public String getPPSAppSBItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppSBItemName();
        }
        return this.ppsappsbitemname;
    }

    public boolean isPPSAppSBItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppSBItemNameDirty();
        }
        return this.ppsappsbitemnameDirtyFlag;
    }

    public void resetPPSAppSBItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppSBItemName();
            return;
        }
        this.ppsappsbitemnameDirtyFlag = false;
        this.ppsappsbitemname = null;
    }

    public void setPSAppSBItemRSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppSBItemRSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappsbitemrsid = string;
        this.psappsbitemrsidDirtyFlag = true;
    }

    public String getPSAppSBItemRSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSBItemRSId();
        }
        return this.psappsbitemrsid;
    }

    public boolean isPSAppSBItemRSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppSBItemRSIdDirty();
        }
        return this.psappsbitemrsidDirtyFlag;
    }

    public void resetPSAppSBItemRSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppSBItemRSId();
            return;
        }
        this.psappsbitemrsidDirtyFlag = false;
        this.psappsbitemrsid = null;
    }

    public void setPSAppSBItemRSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppSBItemRSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappsbitemrsname = string;
        this.psappsbitemrsnameDirtyFlag = true;
    }

    public String getPSAppSBItemRSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSBItemRSName();
        }
        return this.psappsbitemrsname;
    }

    public boolean isPSAppSBItemRSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppSBItemRSNameDirty();
        }
        return this.psappsbitemrsnameDirtyFlag;
    }

    public void resetPSAppSBItemRSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppSBItemRSName();
            return;
        }
        this.psappsbitemrsnameDirtyFlag = false;
        this.psappsbitemrsname = null;
    }

    public void setPSAppStoryBoardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppStoryBoardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappstoryboardid = string;
        this.psappstoryboardidDirtyFlag = true;
    }

    public String getPSAppStoryBoardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoardId();
        }
        return this.psappstoryboardid;
    }

    public boolean isPSAppStoryBoardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppStoryBoardIdDirty();
        }
        return this.psappstoryboardidDirtyFlag;
    }

    public void resetPSAppStoryBoardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppStoryBoardId();
            return;
        }
        this.psappstoryboardidDirtyFlag = false;
        this.psappstoryboardid = null;
    }

    public void setPSAppStoryBoardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppStoryBoardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappstoryboardname = string;
        this.psappstoryboardnameDirtyFlag = true;
    }

    public String getPSAppStoryBoardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoardName();
        }
        return this.psappstoryboardname;
    }

    public boolean isPSAppStoryBoardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppStoryBoardNameDirty();
        }
        return this.psappstoryboardnameDirtyFlag;
    }

    public void resetPSAppStoryBoardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppStoryBoardName();
            return;
        }
        this.psappstoryboardnameDirtyFlag = false;
        this.psappstoryboardname = null;
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

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
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

    public void setPSSysUserCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercaseid = string;
        this.pssysusercaseidDirtyFlag = true;
    }

    public String getPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseId();
        }
        return this.pssysusercaseid;
    }

    public boolean isPSSysUserCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseIdDirty();
        }
        return this.pssysusercaseidDirtyFlag;
    }

    public void resetPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseId();
            return;
        }
        this.pssysusercaseidDirtyFlag = false;
        this.pssysusercaseid = null;
    }

    public void setPSSysUserCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercasename = string;
        this.pssysusercasenameDirtyFlag = true;
    }

    public String getPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseName();
        }
        return this.pssysusercasename;
    }

    public boolean isPSSysUserCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseNameDirty();
        }
        return this.pssysusercasenameDirtyFlag;
    }

    public void resetPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseName();
            return;
        }
        this.pssysusercasenameDirtyFlag = false;
        this.pssysusercasename = null;
    }

    public void setRSTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag = string;
        this.rstagDirtyFlag = true;
    }

    public String getRSTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag();
        }
        return this.rstag;
    }

    public boolean isRSTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTagDirty();
        }
        return this.rstagDirtyFlag;
    }

    public void resetRSTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag();
            return;
        }
        this.rstagDirtyFlag = false;
        this.rstag = null;
    }

    public void setRSTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag2 = string;
        this.rstag2DirtyFlag = true;
    }

    public String getRSTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag2();
        }
        return this.rstag2;
    }

    public boolean isRSTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTag2Dirty();
        }
        return this.rstag2DirtyFlag;
    }

    public void resetRSTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag2();
            return;
        }
        this.rstag2DirtyFlag = false;
        this.rstag2 = null;
    }

    public void setRSTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag3 = string;
        this.rstag3DirtyFlag = true;
    }

    public String getRSTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag3();
        }
        return this.rstag3;
    }

    public boolean isRSTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTag3Dirty();
        }
        return this.rstag3DirtyFlag;
    }

    public void resetRSTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag3();
            return;
        }
        this.rstag3DirtyFlag = false;
        this.rstag3 = null;
    }

    public void setRSTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag4 = string;
        this.rstag4DirtyFlag = true;
    }

    public String getRSTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag4();
        }
        return this.rstag4;
    }

    public boolean isRSTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTag4Dirty();
        }
        return this.rstag4DirtyFlag;
    }

    public void resetRSTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag4();
            return;
        }
        this.rstag4DirtyFlag = false;
        this.rstag4 = null;
    }

    public void setRSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstype = string;
        this.rstypeDirtyFlag = true;
    }

    public String getRSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSType();
        }
        return this.rstype;
    }

    public boolean isRSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTypeDirty();
        }
        return this.rstypeDirtyFlag;
    }

    public void resetRSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSType();
            return;
        }
        this.rstypeDirtyFlag = false;
        this.rstype = null;
    }

    public void setSrcEndPoint(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcEndPoint(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcendpoint = string;
        this.srcendpointDirtyFlag = true;
    }

    public String getSrcEndPoint() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcEndPoint();
        }
        return this.srcendpoint;
    }

    public boolean isSrcEndPointDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcEndPointDirty();
        }
        return this.srcendpointDirtyFlag;
    }

    public void resetSrcEndPoint() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcEndPoint();
            return;
        }
        this.srcendpointDirtyFlag = false;
        this.srcendpoint = null;
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

    public void setUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserFlag(n);
            return;
        }
        this.userflag = n;
        this.userflagDirtyFlag = true;
    }

    public Integer getUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserFlag();
        }
        return this.userflag;
    }

    public boolean isUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserFlagDirty();
        }
        return this.userflagDirtyFlag;
    }

    public void resetUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserFlag();
            return;
        }
        this.userflagDirtyFlag = false;
        this.userflag = null;
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
        PSAppSBItemRSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppSBItemRSBase pSAppSBItemRSBase) {
        pSAppSBItemRSBase.resetCodeName();
        pSAppSBItemRSBase.resetCPSAppSBItemId();
        pSAppSBItemRSBase.resetCPSAppSBItemName();
        pSAppSBItemRSBase.resetCreateDate();
        pSAppSBItemRSBase.resetCreateMan();
        pSAppSBItemRSBase.resetDstEndPoint();
        pSAppSBItemRSBase.resetMemo();
        pSAppSBItemRSBase.resetOrderValue();
        pSAppSBItemRSBase.resetPPSAppSBItemId();
        pSAppSBItemRSBase.resetPPSAppSBItemName();
        pSAppSBItemRSBase.resetPSAppSBItemRSId();
        pSAppSBItemRSBase.resetPSAppSBItemRSName();
        pSAppSBItemRSBase.resetPSAppStoryBoardId();
        pSAppSBItemRSBase.resetPSAppStoryBoardName();
        pSAppSBItemRSBase.resetPSDynaInstId();
        pSAppSBItemRSBase.resetPSSysAppId();
        pSAppSBItemRSBase.resetPSSysReqItemId();
        pSAppSBItemRSBase.resetPSSysReqItemName();
        pSAppSBItemRSBase.resetPSSysUserCaseId();
        pSAppSBItemRSBase.resetPSSysUserCaseName();
        pSAppSBItemRSBase.resetRSTag();
        pSAppSBItemRSBase.resetRSTag2();
        pSAppSBItemRSBase.resetRSTag3();
        pSAppSBItemRSBase.resetRSTag4();
        pSAppSBItemRSBase.resetRSType();
        pSAppSBItemRSBase.resetSrcEndPoint();
        pSAppSBItemRSBase.resetUpdateDate();
        pSAppSBItemRSBase.resetUpdateMan();
        pSAppSBItemRSBase.resetUserCat();
        pSAppSBItemRSBase.resetUserFlag();
        pSAppSBItemRSBase.resetUserTag();
        pSAppSBItemRSBase.resetUserTag2();
        pSAppSBItemRSBase.resetUserTag3();
        pSAppSBItemRSBase.resetUserTag4();
        pSAppSBItemRSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCPSAppSBItemIdDirty()) {
            hashMap.put(FIELD_CPSAPPSBITEMID, this.getCPSAppSBItemId());
        }
        if (!bl || this.isCPSAppSBItemNameDirty()) {
            hashMap.put(FIELD_CPSAPPSBITEMNAME, this.getCPSAppSBItemName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDstEndPointDirty()) {
            hashMap.put(FIELD_DSTENDPOINT, this.getDstEndPoint());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSAppSBItemIdDirty()) {
            hashMap.put(FIELD_PPSAPPSBITEMID, this.getPPSAppSBItemId());
        }
        if (!bl || this.isPPSAppSBItemNameDirty()) {
            hashMap.put(FIELD_PPSAPPSBITEMNAME, this.getPPSAppSBItemName());
        }
        if (!bl || this.isPSAppSBItemRSIdDirty()) {
            hashMap.put(FIELD_PSAPPSBITEMRSID, this.getPSAppSBItemRSId());
        }
        if (!bl || this.isPSAppSBItemRSNameDirty()) {
            hashMap.put(FIELD_PSAPPSBITEMRSNAME, this.getPSAppSBItemRSName());
        }
        if (!bl || this.isPSAppStoryBoardIdDirty()) {
            hashMap.put(FIELD_PSAPPSTORYBOARDID, this.getPSAppStoryBoardId());
        }
        if (!bl || this.isPSAppStoryBoardNameDirty()) {
            hashMap.put(FIELD_PSAPPSTORYBOARDNAME, this.getPSAppStoryBoardName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysUserCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASEID, this.getPSSysUserCaseId());
        }
        if (!bl || this.isPSSysUserCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASENAME, this.getPSSysUserCaseName());
        }
        if (!bl || this.isRSTagDirty()) {
            hashMap.put(FIELD_RSTAG, this.getRSTag());
        }
        if (!bl || this.isRSTag2Dirty()) {
            hashMap.put(FIELD_RSTAG2, this.getRSTag2());
        }
        if (!bl || this.isRSTag3Dirty()) {
            hashMap.put(FIELD_RSTAG3, this.getRSTag3());
        }
        if (!bl || this.isRSTag4Dirty()) {
            hashMap.put(FIELD_RSTAG4, this.getRSTag4());
        }
        if (!bl || this.isRSTypeDirty()) {
            hashMap.put(FIELD_RSTYPE, this.getRSType());
        }
        if (!bl || this.isSrcEndPointDirty()) {
            hashMap.put(FIELD_SRCENDPOINT, this.getSrcEndPoint());
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
        if (!bl || this.isUserFlagDirty()) {
            hashMap.put(FIELD_USERFLAG, this.getUserFlag());
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
        return PSAppSBItemRSBase.get(this, n);
    }

    private static Object get(PSAppSBItemRSBase pSAppSBItemRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSBItemRSBase.getCodeName();
            }
            case 1: {
                return pSAppSBItemRSBase.getCPSAppSBItemId();
            }
            case 2: {
                return pSAppSBItemRSBase.getCPSAppSBItemName();
            }
            case 3: {
                return pSAppSBItemRSBase.getCreateDate();
            }
            case 4: {
                return pSAppSBItemRSBase.getCreateMan();
            }
            case 5: {
                return pSAppSBItemRSBase.getDstEndPoint();
            }
            case 6: {
                return pSAppSBItemRSBase.getMemo();
            }
            case 7: {
                return pSAppSBItemRSBase.getOrderValue();
            }
            case 8: {
                return pSAppSBItemRSBase.getPPSAppSBItemId();
            }
            case 9: {
                return pSAppSBItemRSBase.getPPSAppSBItemName();
            }
            case 10: {
                return pSAppSBItemRSBase.getPSAppSBItemRSId();
            }
            case 11: {
                return pSAppSBItemRSBase.getPSAppSBItemRSName();
            }
            case 12: {
                return pSAppSBItemRSBase.getPSAppStoryBoardId();
            }
            case 13: {
                return pSAppSBItemRSBase.getPSAppStoryBoardName();
            }
            case 14: {
                return pSAppSBItemRSBase.getPSDynaInstId();
            }
            case 15: {
                return pSAppSBItemRSBase.getPSSysAppId();
            }
            case 16: {
                return pSAppSBItemRSBase.getPSSysReqItemId();
            }
            case 17: {
                return pSAppSBItemRSBase.getPSSysReqItemName();
            }
            case 18: {
                return pSAppSBItemRSBase.getPSSysUserCaseId();
            }
            case 19: {
                return pSAppSBItemRSBase.getPSSysUserCaseName();
            }
            case 20: {
                return pSAppSBItemRSBase.getRSTag();
            }
            case 21: {
                return pSAppSBItemRSBase.getRSTag2();
            }
            case 22: {
                return pSAppSBItemRSBase.getRSTag3();
            }
            case 23: {
                return pSAppSBItemRSBase.getRSTag4();
            }
            case 24: {
                return pSAppSBItemRSBase.getRSType();
            }
            case 25: {
                return pSAppSBItemRSBase.getSrcEndPoint();
            }
            case 26: {
                return pSAppSBItemRSBase.getUpdateDate();
            }
            case 27: {
                return pSAppSBItemRSBase.getUpdateMan();
            }
            case 28: {
                return pSAppSBItemRSBase.getUserCat();
            }
            case 29: {
                return pSAppSBItemRSBase.getUserFlag();
            }
            case 30: {
                return pSAppSBItemRSBase.getUserTag();
            }
            case 31: {
                return pSAppSBItemRSBase.getUserTag2();
            }
            case 32: {
                return pSAppSBItemRSBase.getUserTag3();
            }
            case 33: {
                return pSAppSBItemRSBase.getUserTag4();
            }
            case 34: {
                return pSAppSBItemRSBase.getValidFlag();
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
        PSAppSBItemRSBase.set(this, n, object);
    }

    private static void set(PSAppSBItemRSBase pSAppSBItemRSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppSBItemRSBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppSBItemRSBase.setCPSAppSBItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppSBItemRSBase.setCPSAppSBItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppSBItemRSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSAppSBItemRSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppSBItemRSBase.setDstEndPoint(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppSBItemRSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppSBItemRSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSAppSBItemRSBase.setPPSAppSBItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppSBItemRSBase.setPPSAppSBItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppSBItemRSBase.setPSAppSBItemRSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppSBItemRSBase.setPSAppSBItemRSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppSBItemRSBase.setPSAppStoryBoardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppSBItemRSBase.setPSAppStoryBoardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppSBItemRSBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppSBItemRSBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppSBItemRSBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppSBItemRSBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppSBItemRSBase.setPSSysUserCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppSBItemRSBase.setPSSysUserCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppSBItemRSBase.setRSTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppSBItemRSBase.setRSTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppSBItemRSBase.setRSTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppSBItemRSBase.setRSTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppSBItemRSBase.setRSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppSBItemRSBase.setSrcEndPoint(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppSBItemRSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSAppSBItemRSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppSBItemRSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppSBItemRSBase.setUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSAppSBItemRSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppSBItemRSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppSBItemRSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppSBItemRSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppSBItemRSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppSBItemRSBase.isNull(this, n);
    }

    private static boolean isNull(PSAppSBItemRSBase pSAppSBItemRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSBItemRSBase.getCodeName() == null;
            }
            case 1: {
                return pSAppSBItemRSBase.getCPSAppSBItemId() == null;
            }
            case 2: {
                return pSAppSBItemRSBase.getCPSAppSBItemName() == null;
            }
            case 3: {
                return pSAppSBItemRSBase.getCreateDate() == null;
            }
            case 4: {
                return pSAppSBItemRSBase.getCreateMan() == null;
            }
            case 5: {
                return pSAppSBItemRSBase.getDstEndPoint() == null;
            }
            case 6: {
                return pSAppSBItemRSBase.getMemo() == null;
            }
            case 7: {
                return pSAppSBItemRSBase.getOrderValue() == null;
            }
            case 8: {
                return pSAppSBItemRSBase.getPPSAppSBItemId() == null;
            }
            case 9: {
                return pSAppSBItemRSBase.getPPSAppSBItemName() == null;
            }
            case 10: {
                return pSAppSBItemRSBase.getPSAppSBItemRSId() == null;
            }
            case 11: {
                return pSAppSBItemRSBase.getPSAppSBItemRSName() == null;
            }
            case 12: {
                return pSAppSBItemRSBase.getPSAppStoryBoardId() == null;
            }
            case 13: {
                return pSAppSBItemRSBase.getPSAppStoryBoardName() == null;
            }
            case 14: {
                return pSAppSBItemRSBase.getPSDynaInstId() == null;
            }
            case 15: {
                return pSAppSBItemRSBase.getPSSysAppId() == null;
            }
            case 16: {
                return pSAppSBItemRSBase.getPSSysReqItemId() == null;
            }
            case 17: {
                return pSAppSBItemRSBase.getPSSysReqItemName() == null;
            }
            case 18: {
                return pSAppSBItemRSBase.getPSSysUserCaseId() == null;
            }
            case 19: {
                return pSAppSBItemRSBase.getPSSysUserCaseName() == null;
            }
            case 20: {
                return pSAppSBItemRSBase.getRSTag() == null;
            }
            case 21: {
                return pSAppSBItemRSBase.getRSTag2() == null;
            }
            case 22: {
                return pSAppSBItemRSBase.getRSTag3() == null;
            }
            case 23: {
                return pSAppSBItemRSBase.getRSTag4() == null;
            }
            case 24: {
                return pSAppSBItemRSBase.getRSType() == null;
            }
            case 25: {
                return pSAppSBItemRSBase.getSrcEndPoint() == null;
            }
            case 26: {
                return pSAppSBItemRSBase.getUpdateDate() == null;
            }
            case 27: {
                return pSAppSBItemRSBase.getUpdateMan() == null;
            }
            case 28: {
                return pSAppSBItemRSBase.getUserCat() == null;
            }
            case 29: {
                return pSAppSBItemRSBase.getUserFlag() == null;
            }
            case 30: {
                return pSAppSBItemRSBase.getUserTag() == null;
            }
            case 31: {
                return pSAppSBItemRSBase.getUserTag2() == null;
            }
            case 32: {
                return pSAppSBItemRSBase.getUserTag3() == null;
            }
            case 33: {
                return pSAppSBItemRSBase.getUserTag4() == null;
            }
            case 34: {
                return pSAppSBItemRSBase.getValidFlag() == null;
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
        return PSAppSBItemRSBase.contains(this, n);
    }

    private static boolean contains(PSAppSBItemRSBase pSAppSBItemRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSBItemRSBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppSBItemRSBase.isCPSAppSBItemIdDirty();
            }
            case 2: {
                return pSAppSBItemRSBase.isCPSAppSBItemNameDirty();
            }
            case 3: {
                return pSAppSBItemRSBase.isCreateDateDirty();
            }
            case 4: {
                return pSAppSBItemRSBase.isCreateManDirty();
            }
            case 5: {
                return pSAppSBItemRSBase.isDstEndPointDirty();
            }
            case 6: {
                return pSAppSBItemRSBase.isMemoDirty();
            }
            case 7: {
                return pSAppSBItemRSBase.isOrderValueDirty();
            }
            case 8: {
                return pSAppSBItemRSBase.isPPSAppSBItemIdDirty();
            }
            case 9: {
                return pSAppSBItemRSBase.isPPSAppSBItemNameDirty();
            }
            case 10: {
                return pSAppSBItemRSBase.isPSAppSBItemRSIdDirty();
            }
            case 11: {
                return pSAppSBItemRSBase.isPSAppSBItemRSNameDirty();
            }
            case 12: {
                return pSAppSBItemRSBase.isPSAppStoryBoardIdDirty();
            }
            case 13: {
                return pSAppSBItemRSBase.isPSAppStoryBoardNameDirty();
            }
            case 14: {
                return pSAppSBItemRSBase.isPSDynaInstIdDirty();
            }
            case 15: {
                return pSAppSBItemRSBase.isPSSysAppIdDirty();
            }
            case 16: {
                return pSAppSBItemRSBase.isPSSysReqItemIdDirty();
            }
            case 17: {
                return pSAppSBItemRSBase.isPSSysReqItemNameDirty();
            }
            case 18: {
                return pSAppSBItemRSBase.isPSSysUserCaseIdDirty();
            }
            case 19: {
                return pSAppSBItemRSBase.isPSSysUserCaseNameDirty();
            }
            case 20: {
                return pSAppSBItemRSBase.isRSTagDirty();
            }
            case 21: {
                return pSAppSBItemRSBase.isRSTag2Dirty();
            }
            case 22: {
                return pSAppSBItemRSBase.isRSTag3Dirty();
            }
            case 23: {
                return pSAppSBItemRSBase.isRSTag4Dirty();
            }
            case 24: {
                return pSAppSBItemRSBase.isRSTypeDirty();
            }
            case 25: {
                return pSAppSBItemRSBase.isSrcEndPointDirty();
            }
            case 26: {
                return pSAppSBItemRSBase.isUpdateDateDirty();
            }
            case 27: {
                return pSAppSBItemRSBase.isUpdateManDirty();
            }
            case 28: {
                return pSAppSBItemRSBase.isUserCatDirty();
            }
            case 29: {
                return pSAppSBItemRSBase.isUserFlagDirty();
            }
            case 30: {
                return pSAppSBItemRSBase.isUserTagDirty();
            }
            case 31: {
                return pSAppSBItemRSBase.isUserTag2Dirty();
            }
            case 32: {
                return pSAppSBItemRSBase.isUserTag3Dirty();
            }
            case 33: {
                return pSAppSBItemRSBase.isUserTag4Dirty();
            }
            case 34: {
                return pSAppSBItemRSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppSBItemRSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppSBItemRSBase pSAppSBItemRSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppSBItemRSBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getCPSAppSBItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsappsbitemid", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getCPSAppSBItemId()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getCPSAppSBItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsappsbitemname", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getCPSAppSBItemName()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getDstEndPoint() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstendpoint", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getDstEndPoint()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPPSAppSBItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsappsbitemid", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPPSAppSBItemId()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPPSAppSBItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsappsbitemname", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPPSAppSBItemName()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSAppSBItemRSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappsbitemrsid", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSAppSBItemRSId()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSAppSBItemRSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappsbitemrsname", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSAppSBItemRSName()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSAppStoryBoardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappstoryboardid", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSAppStoryBoardId()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSAppStoryBoardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappstoryboardname", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSAppStoryBoardName()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSSysUserCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercaseid", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSSysUserCaseId()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getPSSysUserCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasename", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getPSSysUserCaseName()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getRSTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getRSTag()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getRSTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag2", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getRSTag2()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getRSTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag3", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getRSTag3()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getRSTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag4", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getRSTag4()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getRSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstype", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getRSType()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getSrcEndPoint() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcendpoint", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getSrcEndPoint()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userflag", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getUserFlag()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppSBItemRSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppSBItemRSBase.getJSONValue((Object)pSAppSBItemRSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppSBItemRSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppSBItemRSBase pSAppSBItemRSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppSBItemRSBase.getCodeName() != null) {
            object = pSAppSBItemRSBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSAppSBItemRSBase.getCPSAppSBItemId() != null) {
            object = pSAppSBItemRSBase.getCPSAppSBItemId();
            xmlNode.setAttribute(FIELD_CPSAPPSBITEMID, (String)(object == null ? "" : object));
        }
        if (bl || pSAppSBItemRSBase.getCPSAppSBItemName() != null) {
            object = pSAppSBItemRSBase.getCPSAppSBItemName();
            xmlNode.setAttribute(FIELD_CPSAPPSBITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getCreateDate() != null) {
            object = pSAppSBItemRSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppSBItemRSBase.getCreateMan() != null) {
            object = pSAppSBItemRSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getDstEndPoint() != null) {
            object = pSAppSBItemRSBase.getDstEndPoint();
            xmlNode.setAttribute(FIELD_DSTENDPOINT, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getMemo() != null) {
            object = pSAppSBItemRSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getOrderValue() != null) {
            object = pSAppSBItemRSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppSBItemRSBase.getPPSAppSBItemId() != null) {
            object = pSAppSBItemRSBase.getPPSAppSBItemId();
            xmlNode.setAttribute(FIELD_PPSAPPSBITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPPSAppSBItemName() != null) {
            object = pSAppSBItemRSBase.getPPSAppSBItemName();
            xmlNode.setAttribute(FIELD_PPSAPPSBITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSAppSBItemRSId() != null) {
            object = pSAppSBItemRSBase.getPSAppSBItemRSId();
            xmlNode.setAttribute(FIELD_PSAPPSBITEMRSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSAppSBItemRSName() != null) {
            object = pSAppSBItemRSBase.getPSAppSBItemRSName();
            xmlNode.setAttribute(FIELD_PSAPPSBITEMRSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSAppStoryBoardId() != null) {
            object = pSAppSBItemRSBase.getPSAppStoryBoardId();
            xmlNode.setAttribute(FIELD_PSAPPSTORYBOARDID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSAppStoryBoardName() != null) {
            object = pSAppSBItemRSBase.getPSAppStoryBoardName();
            xmlNode.setAttribute(FIELD_PSAPPSTORYBOARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSDynaInstId() != null) {
            object = pSAppSBItemRSBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSSysAppId() != null) {
            object = pSAppSBItemRSBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSSysReqItemId() != null) {
            object = pSAppSBItemRSBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSSysReqItemName() != null) {
            object = pSAppSBItemRSBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSSysUserCaseId() != null) {
            object = pSAppSBItemRSBase.getPSSysUserCaseId();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getPSSysUserCaseName() != null) {
            object = pSAppSBItemRSBase.getPSSysUserCaseName();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getRSTag() != null) {
            object = pSAppSBItemRSBase.getRSTag();
            xmlNode.setAttribute(FIELD_RSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getRSTag2() != null) {
            object = pSAppSBItemRSBase.getRSTag2();
            xmlNode.setAttribute(FIELD_RSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getRSTag3() != null) {
            object = pSAppSBItemRSBase.getRSTag3();
            xmlNode.setAttribute(FIELD_RSTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getRSTag4() != null) {
            object = pSAppSBItemRSBase.getRSTag4();
            xmlNode.setAttribute(FIELD_RSTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getRSType() != null) {
            object = pSAppSBItemRSBase.getRSType();
            xmlNode.setAttribute(FIELD_RSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getSrcEndPoint() != null) {
            object = pSAppSBItemRSBase.getSrcEndPoint();
            xmlNode.setAttribute(FIELD_SRCENDPOINT, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getUpdateDate() != null) {
            object = pSAppSBItemRSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppSBItemRSBase.getUpdateMan() != null) {
            object = pSAppSBItemRSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getUserCat() != null) {
            object = pSAppSBItemRSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getUserFlag() != null) {
            object = pSAppSBItemRSBase.getUserFlag();
            xmlNode.setAttribute(FIELD_USERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppSBItemRSBase.getUserTag() != null) {
            object = pSAppSBItemRSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getUserTag2() != null) {
            object = pSAppSBItemRSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getUserTag3() != null) {
            object = pSAppSBItemRSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getUserTag4() != null) {
            object = pSAppSBItemRSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemRSBase.getValidFlag() != null) {
            object = pSAppSBItemRSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppSBItemRSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppSBItemRSBase pSAppSBItemRSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppSBItemRSBase.isCodeNameDirty() && (bl || pSAppSBItemRSBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppSBItemRSBase.getCodeName());
        }
        if (pSAppSBItemRSBase.isCPSAppSBItemIdDirty() && (bl || pSAppSBItemRSBase.getCPSAppSBItemId() != null)) {
            iDataObject.set(FIELD_CPSAPPSBITEMID, (Object)pSAppSBItemRSBase.getCPSAppSBItemId());
        }
        if (pSAppSBItemRSBase.isCPSAppSBItemNameDirty() && (bl || pSAppSBItemRSBase.getCPSAppSBItemName() != null)) {
            iDataObject.set(FIELD_CPSAPPSBITEMNAME, (Object)pSAppSBItemRSBase.getCPSAppSBItemName());
        }
        if (pSAppSBItemRSBase.isCreateDateDirty() && (bl || pSAppSBItemRSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppSBItemRSBase.getCreateDate());
        }
        if (pSAppSBItemRSBase.isCreateManDirty() && (bl || pSAppSBItemRSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppSBItemRSBase.getCreateMan());
        }
        if (pSAppSBItemRSBase.isDstEndPointDirty() && (bl || pSAppSBItemRSBase.getDstEndPoint() != null)) {
            iDataObject.set(FIELD_DSTENDPOINT, (Object)pSAppSBItemRSBase.getDstEndPoint());
        }
        if (pSAppSBItemRSBase.isMemoDirty() && (bl || pSAppSBItemRSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppSBItemRSBase.getMemo());
        }
        if (pSAppSBItemRSBase.isOrderValueDirty() && (bl || pSAppSBItemRSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppSBItemRSBase.getOrderValue());
        }
        if (pSAppSBItemRSBase.isPPSAppSBItemIdDirty() && (bl || pSAppSBItemRSBase.getPPSAppSBItemId() != null)) {
            iDataObject.set(FIELD_PPSAPPSBITEMID, (Object)pSAppSBItemRSBase.getPPSAppSBItemId());
        }
        if (pSAppSBItemRSBase.isPPSAppSBItemNameDirty() && (bl || pSAppSBItemRSBase.getPPSAppSBItemName() != null)) {
            iDataObject.set(FIELD_PPSAPPSBITEMNAME, (Object)pSAppSBItemRSBase.getPPSAppSBItemName());
        }
        if (pSAppSBItemRSBase.isPSAppSBItemRSIdDirty() && (bl || pSAppSBItemRSBase.getPSAppSBItemRSId() != null)) {
            iDataObject.set(FIELD_PSAPPSBITEMRSID, (Object)pSAppSBItemRSBase.getPSAppSBItemRSId());
        }
        if (pSAppSBItemRSBase.isPSAppSBItemRSNameDirty() && (bl || pSAppSBItemRSBase.getPSAppSBItemRSName() != null)) {
            iDataObject.set(FIELD_PSAPPSBITEMRSNAME, (Object)pSAppSBItemRSBase.getPSAppSBItemRSName());
        }
        if (pSAppSBItemRSBase.isPSAppStoryBoardIdDirty() && (bl || pSAppSBItemRSBase.getPSAppStoryBoardId() != null)) {
            iDataObject.set(FIELD_PSAPPSTORYBOARDID, (Object)pSAppSBItemRSBase.getPSAppStoryBoardId());
        }
        if (pSAppSBItemRSBase.isPSAppStoryBoardNameDirty() && (bl || pSAppSBItemRSBase.getPSAppStoryBoardName() != null)) {
            iDataObject.set(FIELD_PSAPPSTORYBOARDNAME, (Object)pSAppSBItemRSBase.getPSAppStoryBoardName());
        }
        if (pSAppSBItemRSBase.isPSDynaInstIdDirty() && (bl || pSAppSBItemRSBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSAppSBItemRSBase.getPSDynaInstId());
        }
        if (pSAppSBItemRSBase.isPSSysAppIdDirty() && (bl || pSAppSBItemRSBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppSBItemRSBase.getPSSysAppId());
        }
        if (pSAppSBItemRSBase.isPSSysReqItemIdDirty() && (bl || pSAppSBItemRSBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSAppSBItemRSBase.getPSSysReqItemId());
        }
        if (pSAppSBItemRSBase.isPSSysReqItemNameDirty() && (bl || pSAppSBItemRSBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSAppSBItemRSBase.getPSSysReqItemName());
        }
        if (pSAppSBItemRSBase.isPSSysUserCaseIdDirty() && (bl || pSAppSBItemRSBase.getPSSysUserCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASEID, (Object)pSAppSBItemRSBase.getPSSysUserCaseId());
        }
        if (pSAppSBItemRSBase.isPSSysUserCaseNameDirty() && (bl || pSAppSBItemRSBase.getPSSysUserCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASENAME, (Object)pSAppSBItemRSBase.getPSSysUserCaseName());
        }
        if (pSAppSBItemRSBase.isRSTagDirty() && (bl || pSAppSBItemRSBase.getRSTag() != null)) {
            iDataObject.set(FIELD_RSTAG, (Object)pSAppSBItemRSBase.getRSTag());
        }
        if (pSAppSBItemRSBase.isRSTag2Dirty() && (bl || pSAppSBItemRSBase.getRSTag2() != null)) {
            iDataObject.set(FIELD_RSTAG2, (Object)pSAppSBItemRSBase.getRSTag2());
        }
        if (pSAppSBItemRSBase.isRSTag3Dirty() && (bl || pSAppSBItemRSBase.getRSTag3() != null)) {
            iDataObject.set(FIELD_RSTAG3, (Object)pSAppSBItemRSBase.getRSTag3());
        }
        if (pSAppSBItemRSBase.isRSTag4Dirty() && (bl || pSAppSBItemRSBase.getRSTag4() != null)) {
            iDataObject.set(FIELD_RSTAG4, (Object)pSAppSBItemRSBase.getRSTag4());
        }
        if (pSAppSBItemRSBase.isRSTypeDirty() && (bl || pSAppSBItemRSBase.getRSType() != null)) {
            iDataObject.set(FIELD_RSTYPE, (Object)pSAppSBItemRSBase.getRSType());
        }
        if (pSAppSBItemRSBase.isSrcEndPointDirty() && (bl || pSAppSBItemRSBase.getSrcEndPoint() != null)) {
            iDataObject.set(FIELD_SRCENDPOINT, (Object)pSAppSBItemRSBase.getSrcEndPoint());
        }
        if (pSAppSBItemRSBase.isUpdateDateDirty() && (bl || pSAppSBItemRSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppSBItemRSBase.getUpdateDate());
        }
        if (pSAppSBItemRSBase.isUpdateManDirty() && (bl || pSAppSBItemRSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppSBItemRSBase.getUpdateMan());
        }
        if (pSAppSBItemRSBase.isUserCatDirty() && (bl || pSAppSBItemRSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppSBItemRSBase.getUserCat());
        }
        if (pSAppSBItemRSBase.isUserFlagDirty() && (bl || pSAppSBItemRSBase.getUserFlag() != null)) {
            iDataObject.set(FIELD_USERFLAG, (Object)pSAppSBItemRSBase.getUserFlag());
        }
        if (pSAppSBItemRSBase.isUserTagDirty() && (bl || pSAppSBItemRSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppSBItemRSBase.getUserTag());
        }
        if (pSAppSBItemRSBase.isUserTag2Dirty() && (bl || pSAppSBItemRSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppSBItemRSBase.getUserTag2());
        }
        if (pSAppSBItemRSBase.isUserTag3Dirty() && (bl || pSAppSBItemRSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppSBItemRSBase.getUserTag3());
        }
        if (pSAppSBItemRSBase.isUserTag4Dirty() && (bl || pSAppSBItemRSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppSBItemRSBase.getUserTag4());
        }
        if (pSAppSBItemRSBase.isValidFlagDirty() && (bl || pSAppSBItemRSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppSBItemRSBase.getValidFlag());
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
        return PSAppSBItemRSBase.remove(this, n);
    }

    private static boolean remove(PSAppSBItemRSBase pSAppSBItemRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppSBItemRSBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppSBItemRSBase.resetCPSAppSBItemId();
                return true;
            }
            case 2: {
                pSAppSBItemRSBase.resetCPSAppSBItemName();
                return true;
            }
            case 3: {
                pSAppSBItemRSBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSAppSBItemRSBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSAppSBItemRSBase.resetDstEndPoint();
                return true;
            }
            case 6: {
                pSAppSBItemRSBase.resetMemo();
                return true;
            }
            case 7: {
                pSAppSBItemRSBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSAppSBItemRSBase.resetPPSAppSBItemId();
                return true;
            }
            case 9: {
                pSAppSBItemRSBase.resetPPSAppSBItemName();
                return true;
            }
            case 10: {
                pSAppSBItemRSBase.resetPSAppSBItemRSId();
                return true;
            }
            case 11: {
                pSAppSBItemRSBase.resetPSAppSBItemRSName();
                return true;
            }
            case 12: {
                pSAppSBItemRSBase.resetPSAppStoryBoardId();
                return true;
            }
            case 13: {
                pSAppSBItemRSBase.resetPSAppStoryBoardName();
                return true;
            }
            case 14: {
                pSAppSBItemRSBase.resetPSDynaInstId();
                return true;
            }
            case 15: {
                pSAppSBItemRSBase.resetPSSysAppId();
                return true;
            }
            case 16: {
                pSAppSBItemRSBase.resetPSSysReqItemId();
                return true;
            }
            case 17: {
                pSAppSBItemRSBase.resetPSSysReqItemName();
                return true;
            }
            case 18: {
                pSAppSBItemRSBase.resetPSSysUserCaseId();
                return true;
            }
            case 19: {
                pSAppSBItemRSBase.resetPSSysUserCaseName();
                return true;
            }
            case 20: {
                pSAppSBItemRSBase.resetRSTag();
                return true;
            }
            case 21: {
                pSAppSBItemRSBase.resetRSTag2();
                return true;
            }
            case 22: {
                pSAppSBItemRSBase.resetRSTag3();
                return true;
            }
            case 23: {
                pSAppSBItemRSBase.resetRSTag4();
                return true;
            }
            case 24: {
                pSAppSBItemRSBase.resetRSType();
                return true;
            }
            case 25: {
                pSAppSBItemRSBase.resetSrcEndPoint();
                return true;
            }
            case 26: {
                pSAppSBItemRSBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSAppSBItemRSBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSAppSBItemRSBase.resetUserCat();
                return true;
            }
            case 29: {
                pSAppSBItemRSBase.resetUserFlag();
                return true;
            }
            case 30: {
                pSAppSBItemRSBase.resetUserTag();
                return true;
            }
            case 31: {
                pSAppSBItemRSBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSAppSBItemRSBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSAppSBItemRSBase.resetUserTag4();
                return true;
            }
            case 34: {
                pSAppSBItemRSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppSBItem getCPSAppSBItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSAppSBItem();
        }
        if (this.getCPSAppSBItemId() == null) {
            return null;
        }
        Integer n = this.objCPSAppSBItemLock;
        synchronized (n) {
            if (this.cpsappsbitem != null && DataTypeHelper.compare((int)25, (Object)this.getCPSAppSBItemId(), (Object)this.cpsappsbitem.getPSAppSBItemId()) != 0L) {
                this.cpsappsbitem = null;
            }
            if (this.cpsappsbitem == null) {
                PSAppSBItem pSAppSBItem = new PSAppSBItem();
                pSAppSBItem.setPSAppSBItemId(this.getCPSAppSBItemId());
                PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
                pSAppSBItemService.autoGet(pSAppSBItem);
                this.cpsappsbitem = pSAppSBItem;
            }
            return this.cpsappsbitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppSBItem getPPSAppSBItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppSBItem();
        }
        if (this.getPPSAppSBItemId() == null) {
            return null;
        }
        Integer n = this.objPPSAppSBItemLock;
        synchronized (n) {
            if (this.ppsappsbitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSAppSBItemId(), (Object)this.ppsappsbitem.getPSAppSBItemId()) != 0L) {
                this.ppsappsbitem = null;
            }
            if (this.ppsappsbitem == null) {
                PSAppSBItem pSAppSBItem = new PSAppSBItem();
                pSAppSBItem.setPSAppSBItemId(this.getPPSAppSBItemId());
                PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
                pSAppSBItemService.autoGet(pSAppSBItem);
                this.ppsappsbitem = pSAppSBItem;
            }
            return this.ppsappsbitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppStoryBoard getPSAppStoryBoard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoard();
        }
        if (this.getPSAppStoryBoardId() == null) {
            return null;
        }
        Integer n = this.objPSAppStoryBoardLock;
        synchronized (n) {
            if (this.psappstoryboard != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppStoryBoardId(), (Object)this.psappstoryboard.getPSAppStoryBoardId()) != 0L) {
                this.psappstoryboard = null;
            }
            if (this.psappstoryboard == null) {
                PSAppStoryBoard pSAppStoryBoard = new PSAppStoryBoard();
                pSAppStoryBoard.setPSAppStoryBoardId(this.getPSAppStoryBoardId());
                PSAppStoryBoardService pSAppStoryBoardService = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
                pSAppStoryBoardService.autoGet(pSAppStoryBoard);
                this.psappstoryboard = pSAppStoryBoard;
            }
            return this.psappstoryboard;
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
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserCase getPSSysUserCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCase();
        }
        if (this.getPSSysUserCaseId() == null) {
            return null;
        }
        Integer n = this.objPSSysUserCaseLock;
        synchronized (n) {
            if (this.pssysusercase != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserCaseId(), (Object)this.pssysusercase.getPSSysUserCaseId()) != 0L) {
                this.pssysusercase = null;
            }
            if (this.pssysusercase == null) {
                PSSysUserCase pSSysUserCase = new PSSysUserCase();
                pSSysUserCase.setPSSysUserCaseId(this.getPSSysUserCaseId());
                PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserCaseService.autoGet(pSSysUserCase);
                this.pssysusercase = pSSysUserCase;
            }
            return this.pssysusercase;
        }
    }

    private PSAppSBItemRSBase getProxyEntity() {
        return this.proxyPSAppSBItemRSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppSBItemRSBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppSBItemRSBase) {
            this.proxyPSAppSBItemRSBase = (PSAppSBItemRSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CPSAPPSBITEMID, 1);
        fieldIndexMap.put(FIELD_CPSAPPSBITEMNAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DSTENDPOINT, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORDERVALUE, 7);
        fieldIndexMap.put(FIELD_PPSAPPSBITEMID, 8);
        fieldIndexMap.put(FIELD_PPSAPPSBITEMNAME, 9);
        fieldIndexMap.put(FIELD_PSAPPSBITEMRSID, 10);
        fieldIndexMap.put(FIELD_PSAPPSBITEMRSNAME, 11);
        fieldIndexMap.put(FIELD_PSAPPSTORYBOARDID, 12);
        fieldIndexMap.put(FIELD_PSAPPSTORYBOARDNAME, 13);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 15);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSUSERCASEID, 18);
        fieldIndexMap.put(FIELD_PSSYSUSERCASENAME, 19);
        fieldIndexMap.put(FIELD_RSTAG, 20);
        fieldIndexMap.put(FIELD_RSTAG2, 21);
        fieldIndexMap.put(FIELD_RSTAG3, 22);
        fieldIndexMap.put(FIELD_RSTAG4, 23);
        fieldIndexMap.put(FIELD_RSTYPE, 24);
        fieldIndexMap.put(FIELD_SRCENDPOINT, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERFLAG, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
        fieldIndexMap.put(FIELD_VALIDFLAG, 34);
    }
}

