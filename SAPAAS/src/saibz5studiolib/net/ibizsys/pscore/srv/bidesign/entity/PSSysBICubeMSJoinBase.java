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
package net.ibizsys.pscore.srv.bidesign.entity;

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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMSJoin;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.config.entity.PSDEJoinType;
import net.ibizsys.pscore.srv.config.service.PSDEJoinTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeMSJoinBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBICubeMSJoinBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_JOINPSDEID = "JOINPSDEID";
    public static final String FIELD_JOINPSDENAME = "JOINPSDENAME";
    public static final String FIELD_JOINTAG = "JOINTAG";
    public static final String FIELD_JOINTAG2 = "JOINTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PJOINPSDEID = "PJOINPSDEID";
    public static final String FIELD_PPSSYSBICUBEMSJOINID = "PPSSYSBICUBEMSJOINID";
    public static final String FIELD_PPSSYSBICUBEMSJOINNAME = "PPSSYSBICUBEMSJOINNAME";
    public static final String FIELD_PSDEJOINTYPEID = "PSDEJOINTYPEID";
    public static final String FIELD_PSDEJOINTYPENAME = "PSDEJOINTYPENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSSYSBICUBEMEASUREID = "PSSYSBICUBEMEASUREID";
    public static final String FIELD_PSSYSBICUBEMEASURENAME = "PSSYSBICUBEMEASURENAME";
    public static final String FIELD_PSSYSBICUBEMSJOINID = "PSSYSBICUBEMSJOINID";
    public static final String FIELD_PSSYSBICUBEMSJOINNAME = "PSSYSBICUBEMSJOINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_JOINPSDEID = 2;
    private static final int INDEX_JOINPSDENAME = 3;
    private static final int INDEX_JOINTAG = 4;
    private static final int INDEX_JOINTAG2 = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PJOINPSDEID = 8;
    private static final int INDEX_PPSSYSBICUBEMSJOINID = 9;
    private static final int INDEX_PPSSYSBICUBEMSJOINNAME = 10;
    private static final int INDEX_PSDEJOINTYPEID = 11;
    private static final int INDEX_PSDEJOINTYPENAME = 12;
    private static final int INDEX_PSDERID = 13;
    private static final int INDEX_PSDERNAME = 14;
    private static final int INDEX_PSSYSBICUBEMEASUREID = 15;
    private static final int INDEX_PSSYSBICUBEMEASURENAME = 16;
    private static final int INDEX_PSSYSBICUBEMSJOINID = 17;
    private static final int INDEX_PSSYSBICUBEMSJOINNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBICubeMSJoinBase proxyPSSysBICubeMSJoinBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean joinpsdeidDirtyFlag = false;
    private boolean joinpsdenameDirtyFlag = false;
    private boolean jointagDirtyFlag = false;
    private boolean jointag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pjoinpsdeidDirtyFlag = false;
    private boolean ppssysbicubemsjoinidDirtyFlag = false;
    private boolean ppssysbicubemsjoinnameDirtyFlag = false;
    private boolean psdejointypeidDirtyFlag = false;
    private boolean psdejointypenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean pssysbicubemeasureidDirtyFlag = false;
    private boolean pssysbicubemeasurenameDirtyFlag = false;
    private boolean pssysbicubemsjoinidDirtyFlag = false;
    private boolean pssysbicubemsjoinnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="joinpsdeid")
    private String joinpsdeid;
    @Column(name="joinpsdename")
    private String joinpsdename;
    @Column(name="jointag")
    private String jointag;
    @Column(name="jointag2")
    private String jointag2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pjoinpsdeid")
    private String pjoinpsdeid;
    @Column(name="ppssysbicubemsjoinid")
    private String ppssysbicubemsjoinid;
    @Column(name="ppssysbicubemsjoinname")
    private String ppssysbicubemsjoinname;
    @Column(name="psdejointypeid")
    private String psdejointypeid;
    @Column(name="psdejointypename")
    private String psdejointypename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="pssysbicubemeasureid")
    private String pssysbicubemeasureid;
    @Column(name="pssysbicubemeasurename")
    private String pssysbicubemeasurename;
    @Column(name="pssysbicubemsjoinid")
    private String pssysbicubemsjoinid;
    @Column(name="pssysbicubemsjoinname")
    private String pssysbicubemsjoinname;
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
    private Integer objJoinPSDELock = new Integer(1);
    private PSDataEntity joinpsde = null;
    private Integer objPSDEJoinTypeLock = new Integer(1);
    private PSDEJoinType psdejointype = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSSysBICubeMeasureLock = new Integer(1);
    private PSSysBICubeMeasure pssysbicubemeasure = null;
    private Integer objPPSSysBICubeMSJoinLock = new Integer(1);
    private PSSysBICubeMSJoin ppssysbicubemsjoin = null;

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

    public void setJoinPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJoinPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.joinpsdeid = string;
        this.joinpsdeidDirtyFlag = true;
    }

    public String getJoinPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJoinPSDEId();
        }
        return this.joinpsdeid;
    }

    public boolean isJoinPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJoinPSDEIdDirty();
        }
        return this.joinpsdeidDirtyFlag;
    }

    public void resetJoinPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJoinPSDEId();
            return;
        }
        this.joinpsdeidDirtyFlag = false;
        this.joinpsdeid = null;
    }

    public void setJoinPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJoinPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.joinpsdename = string;
        this.joinpsdenameDirtyFlag = true;
    }

    public String getJoinPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJoinPSDEName();
        }
        return this.joinpsdename;
    }

    public boolean isJoinPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJoinPSDENameDirty();
        }
        return this.joinpsdenameDirtyFlag;
    }

    public void resetJoinPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJoinPSDEName();
            return;
        }
        this.joinpsdenameDirtyFlag = false;
        this.joinpsdename = null;
    }

    public void setJoinTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJoinTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jointag = string;
        this.jointagDirtyFlag = true;
    }

    public String getJoinTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJoinTag();
        }
        return this.jointag;
    }

    public boolean isJoinTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJoinTagDirty();
        }
        return this.jointagDirtyFlag;
    }

    public void resetJoinTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJoinTag();
            return;
        }
        this.jointagDirtyFlag = false;
        this.jointag = null;
    }

    public void setJoinTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJoinTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jointag2 = string;
        this.jointag2DirtyFlag = true;
    }

    public String getJoinTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJoinTag2();
        }
        return this.jointag2;
    }

    public boolean isJoinTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJoinTag2Dirty();
        }
        return this.jointag2DirtyFlag;
    }

    public void resetJoinTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJoinTag2();
            return;
        }
        this.jointag2DirtyFlag = false;
        this.jointag2 = null;
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

    public void setPJoinPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPJoinPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pjoinpsdeid = string;
        this.pjoinpsdeidDirtyFlag = true;
    }

    public String getPJoinPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPJoinPSDEId();
        }
        return this.pjoinpsdeid;
    }

    public boolean isPJoinPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPJoinPSDEIdDirty();
        }
        return this.pjoinpsdeidDirtyFlag;
    }

    public void resetPJoinPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPJoinPSDEId();
            return;
        }
        this.pjoinpsdeidDirtyFlag = false;
        this.pjoinpsdeid = null;
    }

    public void setPPSSysBICubeMSJoinId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysBICubeMSJoinId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysbicubemsjoinid = string;
        this.ppssysbicubemsjoinidDirtyFlag = true;
    }

    public String getPPSSysBICubeMSJoinId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBICubeMSJoinId();
        }
        return this.ppssysbicubemsjoinid;
    }

    public boolean isPPSSysBICubeMSJoinIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysBICubeMSJoinIdDirty();
        }
        return this.ppssysbicubemsjoinidDirtyFlag;
    }

    public void resetPPSSysBICubeMSJoinId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysBICubeMSJoinId();
            return;
        }
        this.ppssysbicubemsjoinidDirtyFlag = false;
        this.ppssysbicubemsjoinid = null;
    }

    public void setPPSSysBICubeMSJoinName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysBICubeMSJoinName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysbicubemsjoinname = string;
        this.ppssysbicubemsjoinnameDirtyFlag = true;
    }

    public String getPPSSysBICubeMSJoinName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBICubeMSJoinName();
        }
        return this.ppssysbicubemsjoinname;
    }

    public boolean isPPSSysBICubeMSJoinNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysBICubeMSJoinNameDirty();
        }
        return this.ppssysbicubemsjoinnameDirtyFlag;
    }

    public void resetPPSSysBICubeMSJoinName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysBICubeMSJoinName();
            return;
        }
        this.ppssysbicubemsjoinnameDirtyFlag = false;
        this.ppssysbicubemsjoinname = null;
    }

    public void setPSDEJoinTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEJoinTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdejointypeid = string;
        this.psdejointypeidDirtyFlag = true;
    }

    public String getPSDEJoinTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEJoinTypeId();
        }
        return this.psdejointypeid;
    }

    public boolean isPSDEJoinTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEJoinTypeIdDirty();
        }
        return this.psdejointypeidDirtyFlag;
    }

    public void resetPSDEJoinTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEJoinTypeId();
            return;
        }
        this.psdejointypeidDirtyFlag = false;
        this.psdejointypeid = null;
    }

    public void setPSDEJoinTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEJoinTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdejointypename = string;
        this.psdejointypenameDirtyFlag = true;
    }

    public String getPSDEJoinTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEJoinTypeName();
        }
        return this.psdejointypename;
    }

    public boolean isPSDEJoinTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEJoinTypeNameDirty();
        }
        return this.psdejointypenameDirtyFlag;
    }

    public void resetPSDEJoinTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEJoinTypeName();
            return;
        }
        this.psdejointypenameDirtyFlag = false;
        this.psdejointypename = null;
    }

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
    }

    public void setPSSysBICubeMeasureId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeMeasureId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubemeasureid = string;
        this.pssysbicubemeasureidDirtyFlag = true;
    }

    public String getPSSysBICubeMeasureId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMeasureId();
        }
        return this.pssysbicubemeasureid;
    }

    public boolean isPSSysBICubeMeasureIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeMeasureIdDirty();
        }
        return this.pssysbicubemeasureidDirtyFlag;
    }

    public void resetPSSysBICubeMeasureId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeMeasureId();
            return;
        }
        this.pssysbicubemeasureidDirtyFlag = false;
        this.pssysbicubemeasureid = null;
    }

    public void setPSSysBICubeMeasureName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeMeasureName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubemeasurename = string;
        this.pssysbicubemeasurenameDirtyFlag = true;
    }

    public String getPSSysBICubeMeasureName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMeasureName();
        }
        return this.pssysbicubemeasurename;
    }

    public boolean isPSSysBICubeMeasureNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeMeasureNameDirty();
        }
        return this.pssysbicubemeasurenameDirtyFlag;
    }

    public void resetPSSysBICubeMeasureName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeMeasureName();
            return;
        }
        this.pssysbicubemeasurenameDirtyFlag = false;
        this.pssysbicubemeasurename = null;
    }

    public void setPSSysBICubeMSJoinId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeMSJoinId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubemsjoinid = string;
        this.pssysbicubemsjoinidDirtyFlag = true;
    }

    public String getPSSysBICubeMSJoinId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMSJoinId();
        }
        return this.pssysbicubemsjoinid;
    }

    public boolean isPSSysBICubeMSJoinIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeMSJoinIdDirty();
        }
        return this.pssysbicubemsjoinidDirtyFlag;
    }

    public void resetPSSysBICubeMSJoinId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeMSJoinId();
            return;
        }
        this.pssysbicubemsjoinidDirtyFlag = false;
        this.pssysbicubemsjoinid = null;
    }

    public void setPSSysBICubeMSJoinName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeMSJoinName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubemsjoinname = string;
        this.pssysbicubemsjoinnameDirtyFlag = true;
    }

    public String getPSSysBICubeMSJoinName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMSJoinName();
        }
        return this.pssysbicubemsjoinname;
    }

    public boolean isPSSysBICubeMSJoinNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeMSJoinNameDirty();
        }
        return this.pssysbicubemsjoinnameDirtyFlag;
    }

    public void resetPSSysBICubeMSJoinName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeMSJoinName();
            return;
        }
        this.pssysbicubemsjoinnameDirtyFlag = false;
        this.pssysbicubemsjoinname = null;
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
        PSSysBICubeMSJoinBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase) {
        pSSysBICubeMSJoinBase.resetCreateDate();
        pSSysBICubeMSJoinBase.resetCreateMan();
        pSSysBICubeMSJoinBase.resetJoinPSDEId();
        pSSysBICubeMSJoinBase.resetJoinPSDEName();
        pSSysBICubeMSJoinBase.resetJoinTag();
        pSSysBICubeMSJoinBase.resetJoinTag2();
        pSSysBICubeMSJoinBase.resetMemo();
        pSSysBICubeMSJoinBase.resetOrderValue();
        pSSysBICubeMSJoinBase.resetPJoinPSDEId();
        pSSysBICubeMSJoinBase.resetPPSSysBICubeMSJoinId();
        pSSysBICubeMSJoinBase.resetPPSSysBICubeMSJoinName();
        pSSysBICubeMSJoinBase.resetPSDEJoinTypeId();
        pSSysBICubeMSJoinBase.resetPSDEJoinTypeName();
        pSSysBICubeMSJoinBase.resetPSDERId();
        pSSysBICubeMSJoinBase.resetPSDERName();
        pSSysBICubeMSJoinBase.resetPSSysBICubeMeasureId();
        pSSysBICubeMSJoinBase.resetPSSysBICubeMeasureName();
        pSSysBICubeMSJoinBase.resetPSSysBICubeMSJoinId();
        pSSysBICubeMSJoinBase.resetPSSysBICubeMSJoinName();
        pSSysBICubeMSJoinBase.resetUpdateDate();
        pSSysBICubeMSJoinBase.resetUpdateMan();
        pSSysBICubeMSJoinBase.resetUserCat();
        pSSysBICubeMSJoinBase.resetUserTag();
        pSSysBICubeMSJoinBase.resetUserTag2();
        pSSysBICubeMSJoinBase.resetUserTag3();
        pSSysBICubeMSJoinBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isJoinPSDEIdDirty()) {
            hashMap.put(FIELD_JOINPSDEID, this.getJoinPSDEId());
        }
        if (!bl || this.isJoinPSDENameDirty()) {
            hashMap.put(FIELD_JOINPSDENAME, this.getJoinPSDEName());
        }
        if (!bl || this.isJoinTagDirty()) {
            hashMap.put(FIELD_JOINTAG, this.getJoinTag());
        }
        if (!bl || this.isJoinTag2Dirty()) {
            hashMap.put(FIELD_JOINTAG2, this.getJoinTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPJoinPSDEIdDirty()) {
            hashMap.put(FIELD_PJOINPSDEID, this.getPJoinPSDEId());
        }
        if (!bl || this.isPPSSysBICubeMSJoinIdDirty()) {
            hashMap.put(FIELD_PPSSYSBICUBEMSJOINID, this.getPPSSysBICubeMSJoinId());
        }
        if (!bl || this.isPPSSysBICubeMSJoinNameDirty()) {
            hashMap.put(FIELD_PPSSYSBICUBEMSJOINNAME, this.getPPSSysBICubeMSJoinName());
        }
        if (!bl || this.isPSDEJoinTypeIdDirty()) {
            hashMap.put(FIELD_PSDEJOINTYPEID, this.getPSDEJoinTypeId());
        }
        if (!bl || this.isPSDEJoinTypeNameDirty()) {
            hashMap.put(FIELD_PSDEJOINTYPENAME, this.getPSDEJoinTypeName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSSysBICubeMeasureIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMEASUREID, this.getPSSysBICubeMeasureId());
        }
        if (!bl || this.isPSSysBICubeMeasureNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMEASURENAME, this.getPSSysBICubeMeasureName());
        }
        if (!bl || this.isPSSysBICubeMSJoinIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMSJOINID, this.getPSSysBICubeMSJoinId());
        }
        if (!bl || this.isPSSysBICubeMSJoinNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMSJOINNAME, this.getPSSysBICubeMSJoinName());
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
        return PSSysBICubeMSJoinBase.get(this, n);
    }

    private static Object get(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMSJoinBase.getCreateDate();
            }
            case 1: {
                return pSSysBICubeMSJoinBase.getCreateMan();
            }
            case 2: {
                return pSSysBICubeMSJoinBase.getJoinPSDEId();
            }
            case 3: {
                return pSSysBICubeMSJoinBase.getJoinPSDEName();
            }
            case 4: {
                return pSSysBICubeMSJoinBase.getJoinTag();
            }
            case 5: {
                return pSSysBICubeMSJoinBase.getJoinTag2();
            }
            case 6: {
                return pSSysBICubeMSJoinBase.getMemo();
            }
            case 7: {
                return pSSysBICubeMSJoinBase.getOrderValue();
            }
            case 8: {
                return pSSysBICubeMSJoinBase.getPJoinPSDEId();
            }
            case 9: {
                return pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinId();
            }
            case 10: {
                return pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinName();
            }
            case 11: {
                return pSSysBICubeMSJoinBase.getPSDEJoinTypeId();
            }
            case 12: {
                return pSSysBICubeMSJoinBase.getPSDEJoinTypeName();
            }
            case 13: {
                return pSSysBICubeMSJoinBase.getPSDERId();
            }
            case 14: {
                return pSSysBICubeMSJoinBase.getPSDERName();
            }
            case 15: {
                return pSSysBICubeMSJoinBase.getPSSysBICubeMeasureId();
            }
            case 16: {
                return pSSysBICubeMSJoinBase.getPSSysBICubeMeasureName();
            }
            case 17: {
                return pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId();
            }
            case 18: {
                return pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinName();
            }
            case 19: {
                return pSSysBICubeMSJoinBase.getUpdateDate();
            }
            case 20: {
                return pSSysBICubeMSJoinBase.getUpdateMan();
            }
            case 21: {
                return pSSysBICubeMSJoinBase.getUserCat();
            }
            case 22: {
                return pSSysBICubeMSJoinBase.getUserTag();
            }
            case 23: {
                return pSSysBICubeMSJoinBase.getUserTag2();
            }
            case 24: {
                return pSSysBICubeMSJoinBase.getUserTag3();
            }
            case 25: {
                return pSSysBICubeMSJoinBase.getUserTag4();
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
        PSSysBICubeMSJoinBase.set(this, n, object);
    }

    private static void set(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeMSJoinBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysBICubeMSJoinBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBICubeMSJoinBase.setJoinPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBICubeMSJoinBase.setJoinPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBICubeMSJoinBase.setJoinTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBICubeMSJoinBase.setJoinTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBICubeMSJoinBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBICubeMSJoinBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysBICubeMSJoinBase.setPJoinPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBICubeMSJoinBase.setPPSSysBICubeMSJoinId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBICubeMSJoinBase.setPPSSysBICubeMSJoinName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBICubeMSJoinBase.setPSDEJoinTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBICubeMSJoinBase.setPSDEJoinTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBICubeMSJoinBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBICubeMSJoinBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBICubeMSJoinBase.setPSSysBICubeMeasureId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBICubeMSJoinBase.setPSSysBICubeMeasureName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBICubeMSJoinBase.setPSSysBICubeMSJoinId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBICubeMSJoinBase.setPSSysBICubeMSJoinName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBICubeMSJoinBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSysBICubeMSJoinBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBICubeMSJoinBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBICubeMSJoinBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBICubeMSJoinBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBICubeMSJoinBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBICubeMSJoinBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBICubeMSJoinBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMSJoinBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysBICubeMSJoinBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysBICubeMSJoinBase.getJoinPSDEId() == null;
            }
            case 3: {
                return pSSysBICubeMSJoinBase.getJoinPSDEName() == null;
            }
            case 4: {
                return pSSysBICubeMSJoinBase.getJoinTag() == null;
            }
            case 5: {
                return pSSysBICubeMSJoinBase.getJoinTag2() == null;
            }
            case 6: {
                return pSSysBICubeMSJoinBase.getMemo() == null;
            }
            case 7: {
                return pSSysBICubeMSJoinBase.getOrderValue() == null;
            }
            case 8: {
                return pSSysBICubeMSJoinBase.getPJoinPSDEId() == null;
            }
            case 9: {
                return pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinId() == null;
            }
            case 10: {
                return pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinName() == null;
            }
            case 11: {
                return pSSysBICubeMSJoinBase.getPSDEJoinTypeId() == null;
            }
            case 12: {
                return pSSysBICubeMSJoinBase.getPSDEJoinTypeName() == null;
            }
            case 13: {
                return pSSysBICubeMSJoinBase.getPSDERId() == null;
            }
            case 14: {
                return pSSysBICubeMSJoinBase.getPSDERName() == null;
            }
            case 15: {
                return pSSysBICubeMSJoinBase.getPSSysBICubeMeasureId() == null;
            }
            case 16: {
                return pSSysBICubeMSJoinBase.getPSSysBICubeMeasureName() == null;
            }
            case 17: {
                return pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId() == null;
            }
            case 18: {
                return pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinName() == null;
            }
            case 19: {
                return pSSysBICubeMSJoinBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSysBICubeMSJoinBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSysBICubeMSJoinBase.getUserCat() == null;
            }
            case 22: {
                return pSSysBICubeMSJoinBase.getUserTag() == null;
            }
            case 23: {
                return pSSysBICubeMSJoinBase.getUserTag2() == null;
            }
            case 24: {
                return pSSysBICubeMSJoinBase.getUserTag3() == null;
            }
            case 25: {
                return pSSysBICubeMSJoinBase.getUserTag4() == null;
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
        return PSSysBICubeMSJoinBase.contains(this, n);
    }

    private static boolean contains(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMSJoinBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysBICubeMSJoinBase.isCreateManDirty();
            }
            case 2: {
                return pSSysBICubeMSJoinBase.isJoinPSDEIdDirty();
            }
            case 3: {
                return pSSysBICubeMSJoinBase.isJoinPSDENameDirty();
            }
            case 4: {
                return pSSysBICubeMSJoinBase.isJoinTagDirty();
            }
            case 5: {
                return pSSysBICubeMSJoinBase.isJoinTag2Dirty();
            }
            case 6: {
                return pSSysBICubeMSJoinBase.isMemoDirty();
            }
            case 7: {
                return pSSysBICubeMSJoinBase.isOrderValueDirty();
            }
            case 8: {
                return pSSysBICubeMSJoinBase.isPJoinPSDEIdDirty();
            }
            case 9: {
                return pSSysBICubeMSJoinBase.isPPSSysBICubeMSJoinIdDirty();
            }
            case 10: {
                return pSSysBICubeMSJoinBase.isPPSSysBICubeMSJoinNameDirty();
            }
            case 11: {
                return pSSysBICubeMSJoinBase.isPSDEJoinTypeIdDirty();
            }
            case 12: {
                return pSSysBICubeMSJoinBase.isPSDEJoinTypeNameDirty();
            }
            case 13: {
                return pSSysBICubeMSJoinBase.isPSDERIdDirty();
            }
            case 14: {
                return pSSysBICubeMSJoinBase.isPSDERNameDirty();
            }
            case 15: {
                return pSSysBICubeMSJoinBase.isPSSysBICubeMeasureIdDirty();
            }
            case 16: {
                return pSSysBICubeMSJoinBase.isPSSysBICubeMeasureNameDirty();
            }
            case 17: {
                return pSSysBICubeMSJoinBase.isPSSysBICubeMSJoinIdDirty();
            }
            case 18: {
                return pSSysBICubeMSJoinBase.isPSSysBICubeMSJoinNameDirty();
            }
            case 19: {
                return pSSysBICubeMSJoinBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSysBICubeMSJoinBase.isUpdateManDirty();
            }
            case 21: {
                return pSSysBICubeMSJoinBase.isUserCatDirty();
            }
            case 22: {
                return pSSysBICubeMSJoinBase.isUserTagDirty();
            }
            case 23: {
                return pSSysBICubeMSJoinBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSysBICubeMSJoinBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSysBICubeMSJoinBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBICubeMSJoinBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBICubeMSJoinBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getJoinPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"joinpsdeid", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getJoinPSDEId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getJoinPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"joinpsdename", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getJoinPSDEName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getJoinTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jointag", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getJoinTag()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getJoinTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jointag2", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getJoinTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPJoinPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pjoinpsdeid", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPJoinPSDEId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysbicubemsjoinid", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysbicubemsjoinname", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSDEJoinTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdejointypeid", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPSDEJoinTypeId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSDEJoinTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdejointypename", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPSDEJoinTypeName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMeasureId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasureid", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPSSysBICubeMeasureId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMeasureName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasurename", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPSSysBICubeMeasureName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemsjoinid", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemsjoinname", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBICubeMSJoinBase.getJSONValue((Object)pSSysBICubeMSJoinBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBICubeMSJoinBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBICubeMSJoinBase.getCreateDate() != null) {
            object = pSSysBICubeMSJoinBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeMSJoinBase.getCreateMan() != null) {
            object = pSSysBICubeMSJoinBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getJoinPSDEId() != null) {
            object = pSSysBICubeMSJoinBase.getJoinPSDEId();
            xmlNode.setAttribute(FIELD_JOINPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getJoinPSDEName() != null) {
            object = pSSysBICubeMSJoinBase.getJoinPSDEName();
            xmlNode.setAttribute(FIELD_JOINPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getJoinTag() != null) {
            object = pSSysBICubeMSJoinBase.getJoinTag();
            xmlNode.setAttribute(FIELD_JOINTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getJoinTag2() != null) {
            object = pSSysBICubeMSJoinBase.getJoinTag2();
            xmlNode.setAttribute(FIELD_JOINTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getMemo() != null) {
            object = pSSysBICubeMSJoinBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getOrderValue() != null) {
            object = pSSysBICubeMSJoinBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeMSJoinBase.getPJoinPSDEId() != null) {
            object = pSSysBICubeMSJoinBase.getPJoinPSDEId();
            xmlNode.setAttribute(FIELD_PJOINPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinId() != null) {
            object = pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinId();
            xmlNode.setAttribute(FIELD_PPSSYSBICUBEMSJOINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinName() != null) {
            object = pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinName();
            xmlNode.setAttribute(FIELD_PPSSYSBICUBEMSJOINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSDEJoinTypeId() != null) {
            object = pSSysBICubeMSJoinBase.getPSDEJoinTypeId();
            xmlNode.setAttribute(FIELD_PSDEJOINTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSDEJoinTypeName() != null) {
            object = pSSysBICubeMSJoinBase.getPSDEJoinTypeName();
            xmlNode.setAttribute(FIELD_PSDEJOINTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSDERId() != null) {
            object = pSSysBICubeMSJoinBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSDERName() != null) {
            object = pSSysBICubeMSJoinBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMeasureId() != null) {
            object = pSSysBICubeMSJoinBase.getPSSysBICubeMeasureId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASUREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMeasureName() != null) {
            object = pSSysBICubeMSJoinBase.getPSSysBICubeMeasureName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASURENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId() != null) {
            object = pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMSJOINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinName() != null) {
            object = pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMSJOINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getUpdateDate() != null) {
            object = pSSysBICubeMSJoinBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeMSJoinBase.getUpdateMan() != null) {
            object = pSSysBICubeMSJoinBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserCat() != null) {
            object = pSSysBICubeMSJoinBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserTag() != null) {
            object = pSSysBICubeMSJoinBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserTag2() != null) {
            object = pSSysBICubeMSJoinBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserTag3() != null) {
            object = pSSysBICubeMSJoinBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSJoinBase.getUserTag4() != null) {
            object = pSSysBICubeMSJoinBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBICubeMSJoinBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBICubeMSJoinBase.isCreateDateDirty() && (bl || pSSysBICubeMSJoinBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBICubeMSJoinBase.getCreateDate());
        }
        if (pSSysBICubeMSJoinBase.isCreateManDirty() && (bl || pSSysBICubeMSJoinBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBICubeMSJoinBase.getCreateMan());
        }
        if (pSSysBICubeMSJoinBase.isJoinPSDEIdDirty() && (bl || pSSysBICubeMSJoinBase.getJoinPSDEId() != null)) {
            iDataObject.set(FIELD_JOINPSDEID, (Object)pSSysBICubeMSJoinBase.getJoinPSDEId());
        }
        if (pSSysBICubeMSJoinBase.isJoinPSDENameDirty() && (bl || pSSysBICubeMSJoinBase.getJoinPSDEName() != null)) {
            iDataObject.set(FIELD_JOINPSDENAME, (Object)pSSysBICubeMSJoinBase.getJoinPSDEName());
        }
        if (pSSysBICubeMSJoinBase.isJoinTagDirty() && (bl || pSSysBICubeMSJoinBase.getJoinTag() != null)) {
            iDataObject.set(FIELD_JOINTAG, (Object)pSSysBICubeMSJoinBase.getJoinTag());
        }
        if (pSSysBICubeMSJoinBase.isJoinTag2Dirty() && (bl || pSSysBICubeMSJoinBase.getJoinTag2() != null)) {
            iDataObject.set(FIELD_JOINTAG2, (Object)pSSysBICubeMSJoinBase.getJoinTag2());
        }
        if (pSSysBICubeMSJoinBase.isMemoDirty() && (bl || pSSysBICubeMSJoinBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBICubeMSJoinBase.getMemo());
        }
        if (pSSysBICubeMSJoinBase.isOrderValueDirty() && (bl || pSSysBICubeMSJoinBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBICubeMSJoinBase.getOrderValue());
        }
        if (pSSysBICubeMSJoinBase.isPJoinPSDEIdDirty() && (bl || pSSysBICubeMSJoinBase.getPJoinPSDEId() != null)) {
            iDataObject.set(FIELD_PJOINPSDEID, (Object)pSSysBICubeMSJoinBase.getPJoinPSDEId());
        }
        if (pSSysBICubeMSJoinBase.isPPSSysBICubeMSJoinIdDirty() && (bl || pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinId() != null)) {
            iDataObject.set(FIELD_PPSSYSBICUBEMSJOINID, (Object)pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinId());
        }
        if (pSSysBICubeMSJoinBase.isPPSSysBICubeMSJoinNameDirty() && (bl || pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinName() != null)) {
            iDataObject.set(FIELD_PPSSYSBICUBEMSJOINNAME, (Object)pSSysBICubeMSJoinBase.getPPSSysBICubeMSJoinName());
        }
        if (pSSysBICubeMSJoinBase.isPSDEJoinTypeIdDirty() && (bl || pSSysBICubeMSJoinBase.getPSDEJoinTypeId() != null)) {
            iDataObject.set(FIELD_PSDEJOINTYPEID, (Object)pSSysBICubeMSJoinBase.getPSDEJoinTypeId());
        }
        if (pSSysBICubeMSJoinBase.isPSDEJoinTypeNameDirty() && (bl || pSSysBICubeMSJoinBase.getPSDEJoinTypeName() != null)) {
            iDataObject.set(FIELD_PSDEJOINTYPENAME, (Object)pSSysBICubeMSJoinBase.getPSDEJoinTypeName());
        }
        if (pSSysBICubeMSJoinBase.isPSDERIdDirty() && (bl || pSSysBICubeMSJoinBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSSysBICubeMSJoinBase.getPSDERId());
        }
        if (pSSysBICubeMSJoinBase.isPSDERNameDirty() && (bl || pSSysBICubeMSJoinBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSSysBICubeMSJoinBase.getPSDERName());
        }
        if (pSSysBICubeMSJoinBase.isPSSysBICubeMeasureIdDirty() && (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMeasureId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASUREID, (Object)pSSysBICubeMSJoinBase.getPSSysBICubeMeasureId());
        }
        if (pSSysBICubeMSJoinBase.isPSSysBICubeMeasureNameDirty() && (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMeasureName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASURENAME, (Object)pSSysBICubeMSJoinBase.getPSSysBICubeMeasureName());
        }
        if (pSSysBICubeMSJoinBase.isPSSysBICubeMSJoinIdDirty() && (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMSJOINID, (Object)pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId());
        }
        if (pSSysBICubeMSJoinBase.isPSSysBICubeMSJoinNameDirty() && (bl || pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMSJOINNAME, (Object)pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinName());
        }
        if (pSSysBICubeMSJoinBase.isUpdateDateDirty() && (bl || pSSysBICubeMSJoinBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBICubeMSJoinBase.getUpdateDate());
        }
        if (pSSysBICubeMSJoinBase.isUpdateManDirty() && (bl || pSSysBICubeMSJoinBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBICubeMSJoinBase.getUpdateMan());
        }
        if (pSSysBICubeMSJoinBase.isUserCatDirty() && (bl || pSSysBICubeMSJoinBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBICubeMSJoinBase.getUserCat());
        }
        if (pSSysBICubeMSJoinBase.isUserTagDirty() && (bl || pSSysBICubeMSJoinBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBICubeMSJoinBase.getUserTag());
        }
        if (pSSysBICubeMSJoinBase.isUserTag2Dirty() && (bl || pSSysBICubeMSJoinBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBICubeMSJoinBase.getUserTag2());
        }
        if (pSSysBICubeMSJoinBase.isUserTag3Dirty() && (bl || pSSysBICubeMSJoinBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBICubeMSJoinBase.getUserTag3());
        }
        if (pSSysBICubeMSJoinBase.isUserTag4Dirty() && (bl || pSSysBICubeMSJoinBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBICubeMSJoinBase.getUserTag4());
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
        return PSSysBICubeMSJoinBase.remove(this, n);
    }

    private static boolean remove(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeMSJoinBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysBICubeMSJoinBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysBICubeMSJoinBase.resetJoinPSDEId();
                return true;
            }
            case 3: {
                pSSysBICubeMSJoinBase.resetJoinPSDEName();
                return true;
            }
            case 4: {
                pSSysBICubeMSJoinBase.resetJoinTag();
                return true;
            }
            case 5: {
                pSSysBICubeMSJoinBase.resetJoinTag2();
                return true;
            }
            case 6: {
                pSSysBICubeMSJoinBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysBICubeMSJoinBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSSysBICubeMSJoinBase.resetPJoinPSDEId();
                return true;
            }
            case 9: {
                pSSysBICubeMSJoinBase.resetPPSSysBICubeMSJoinId();
                return true;
            }
            case 10: {
                pSSysBICubeMSJoinBase.resetPPSSysBICubeMSJoinName();
                return true;
            }
            case 11: {
                pSSysBICubeMSJoinBase.resetPSDEJoinTypeId();
                return true;
            }
            case 12: {
                pSSysBICubeMSJoinBase.resetPSDEJoinTypeName();
                return true;
            }
            case 13: {
                pSSysBICubeMSJoinBase.resetPSDERId();
                return true;
            }
            case 14: {
                pSSysBICubeMSJoinBase.resetPSDERName();
                return true;
            }
            case 15: {
                pSSysBICubeMSJoinBase.resetPSSysBICubeMeasureId();
                return true;
            }
            case 16: {
                pSSysBICubeMSJoinBase.resetPSSysBICubeMeasureName();
                return true;
            }
            case 17: {
                pSSysBICubeMSJoinBase.resetPSSysBICubeMSJoinId();
                return true;
            }
            case 18: {
                pSSysBICubeMSJoinBase.resetPSSysBICubeMSJoinName();
                return true;
            }
            case 19: {
                pSSysBICubeMSJoinBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSysBICubeMSJoinBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSysBICubeMSJoinBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSysBICubeMSJoinBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysBICubeMSJoinBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSysBICubeMSJoinBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSysBICubeMSJoinBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getJoinPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJoinPSDE();
        }
        if (this.getJoinPSDEId() == null) {
            return null;
        }
        Integer n = this.objJoinPSDELock;
        synchronized (n) {
            if (this.joinpsde != null && DataTypeHelper.compare((int)25, (Object)this.getJoinPSDEId(), (Object)this.joinpsde.getPSDataEntityId()) != 0L) {
                this.joinpsde = null;
            }
            if (this.joinpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getJoinPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.joinpsde = pSDataEntity;
            }
            return this.joinpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEJoinType getPSDEJoinType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEJoinType();
        }
        if (this.getPSDEJoinTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDEJoinTypeLock;
        synchronized (n) {
            if (this.psdejointype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEJoinTypeId(), (Object)this.psdejointype.getPSDEJoinTypeId()) != 0L) {
                this.psdejointype = null;
            }
            if (this.psdejointype == null) {
                PSDEJoinType pSDEJoinType = new PSDEJoinType();
                pSDEJoinType.setPSDEJoinTypeId(this.getPSDEJoinTypeId());
                PSDEJoinTypeService pSDEJoinTypeService = (PSDEJoinTypeService)ServiceGlobal.getService(PSDEJoinTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDEJoinTypeService.autoGet(pSDEJoinType);
                this.psdejointype = pSDEJoinType;
            }
            return this.psdejointype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet(pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICubeMeasure getPSSysBICubeMeasure() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMeasure();
        }
        if (this.getPSSysBICubeMeasureId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeMeasureLock;
        synchronized (n) {
            if (this.pssysbicubemeasure != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeMeasureId(), (Object)this.pssysbicubemeasure.getPSSysBICubeMeasureId()) != 0L) {
                this.pssysbicubemeasure = null;
            }
            if (this.pssysbicubemeasure == null) {
                PSSysBICubeMeasure pSSysBICubeMeasure = new PSSysBICubeMeasure();
                pSSysBICubeMeasure.setPSSysBICubeMeasureId(this.getPSSysBICubeMeasureId());
                PSSysBICubeMeasureService pSSysBICubeMeasureService = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeMeasureService.autoGet(pSSysBICubeMeasure);
                this.pssysbicubemeasure = pSSysBICubeMeasure;
            }
            return this.pssysbicubemeasure;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICubeMSJoin getPPSSysBICubeMSJoin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBICubeMSJoin();
        }
        if (this.getPPSSysBICubeMSJoinId() == null) {
            return null;
        }
        Integer n = this.objPPSSysBICubeMSJoinLock;
        synchronized (n) {
            if (this.ppssysbicubemsjoin != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysBICubeMSJoinId(), (Object)this.ppssysbicubemsjoin.getPSSysBICubeMSJoinId()) != 0L) {
                this.ppssysbicubemsjoin = null;
            }
            if (this.ppssysbicubemsjoin == null) {
                PSSysBICubeMSJoin pSSysBICubeMSJoin = new PSSysBICubeMSJoin();
                pSSysBICubeMSJoin.setPSSysBICubeMSJoinId(this.getPPSSysBICubeMSJoinId());
                PSSysBICubeMSJoinService pSSysBICubeMSJoinService = (PSSysBICubeMSJoinService)ServiceGlobal.getService(PSSysBICubeMSJoinService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeMSJoinService.autoGet(pSSysBICubeMSJoin);
                this.ppssysbicubemsjoin = pSSysBICubeMSJoin;
            }
            return this.ppssysbicubemsjoin;
        }
    }

    private PSSysBICubeMSJoinBase getProxyEntity() {
        return this.proxyPSSysBICubeMSJoinBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBICubeMSJoinBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBICubeMSJoinBase) {
            this.proxyPSSysBICubeMSJoinBase = (PSSysBICubeMSJoinBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_JOINPSDEID, 2);
        fieldIndexMap.put(FIELD_JOINPSDENAME, 3);
        fieldIndexMap.put(FIELD_JOINTAG, 4);
        fieldIndexMap.put(FIELD_JOINTAG2, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORDERVALUE, 7);
        fieldIndexMap.put(FIELD_PJOINPSDEID, 8);
        fieldIndexMap.put(FIELD_PPSSYSBICUBEMSJOINID, 9);
        fieldIndexMap.put(FIELD_PPSSYSBICUBEMSJOINNAME, 10);
        fieldIndexMap.put(FIELD_PSDEJOINTYPEID, 11);
        fieldIndexMap.put(FIELD_PSDEJOINTYPENAME, 12);
        fieldIndexMap.put(FIELD_PSDERID, 13);
        fieldIndexMap.put(FIELD_PSDERNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASUREID, 15);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASURENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMSJOINID, 17);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMSJOINNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
    }
}

