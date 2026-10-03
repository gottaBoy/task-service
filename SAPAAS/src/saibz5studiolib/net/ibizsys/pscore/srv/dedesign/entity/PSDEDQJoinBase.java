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
import net.ibizsys.pscore.srv.config.entity.PSDEJoinType;
import net.ibizsys.pscore.srv.config.service.PSDEJoinTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQJoinBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDQJoinBase.class);
    public static final String FIELD_ALIASNAME = "ALIASNAME";
    public static final String FIELD_CONDFLAG = "CONDFLAG";
    public static final String FIELD_CONDMODEL = "CONDMODEL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXTCOLUMNS = "EXTCOLUMNS";
    public static final String FIELD_JOINPSDEID = "JOINPSDEID";
    public static final String FIELD_JOINPSDENAME = "JOINPSDENAME";
    public static final String FIELD_JOINTAG = "JOINTAG";
    public static final String FIELD_JOINTAG2 = "JOINTAG2";
    public static final String FIELD_LEVELTAG = "LEVELTAG";
    public static final String FIELD_LEVELVALUE = "LEVELVALUE";
    public static final String FIELD_MAINFLAG = "MAINFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PJOINPSDEID = "PJOINPSDEID";
    public static final String FIELD_PPSDEDQJOINID = "PPSDEDQJOINID";
    public static final String FIELD_PPSDEDQJOINNAME = "PPSDEDQJOINNAME";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQJOINID = "PSDEDQJOINID";
    public static final String FIELD_PSDEDQJOINNAME = "PSDEDQJOINNAME";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDEJOINTYPEID = "PSDEJOINTYPEID";
    public static final String FIELD_PSDEJOINTYPENAME = "PSDEJOINTYPENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_QUERYVIEWFLAG = "QUERYVIEWFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ALIASNAME = 0;
    private static final int INDEX_CONDFLAG = 1;
    private static final int INDEX_CONDMODEL = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_EXTCOLUMNS = 5;
    private static final int INDEX_JOINPSDEID = 6;
    private static final int INDEX_JOINPSDENAME = 7;
    private static final int INDEX_JOINTAG = 8;
    private static final int INDEX_JOINTAG2 = 9;
    private static final int INDEX_LEVELTAG = 10;
    private static final int INDEX_LEVELVALUE = 11;
    private static final int INDEX_MAINFLAG = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_MODELSTATE = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_PJOINPSDEID = 16;
    private static final int INDEX_PPSDEDQJOINID = 17;
    private static final int INDEX_PPSDEDQJOINNAME = 18;
    private static final int INDEX_PSDEDQID = 19;
    private static final int INDEX_PSDEDQJOINID = 20;
    private static final int INDEX_PSDEDQJOINNAME = 21;
    private static final int INDEX_PSDEDQNAME = 22;
    private static final int INDEX_PSDEJOINTYPEID = 23;
    private static final int INDEX_PSDEJOINTYPENAME = 24;
    private static final int INDEX_PSDERID = 25;
    private static final int INDEX_PSDERNAME = 26;
    private static final int INDEX_QUERYVIEWFLAG = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERCAT = 30;
    private static final int INDEX_USERTAG = 31;
    private static final int INDEX_USERTAG2 = 32;
    private static final int INDEX_USERTAG3 = 33;
    private static final int INDEX_USERTAG4 = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDQJoinBase proxyPSDEDQJoinBase = null;
    private boolean aliasnameDirtyFlag = false;
    private boolean condflagDirtyFlag = false;
    private boolean condmodelDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean extcolumnsDirtyFlag = false;
    private boolean joinpsdeidDirtyFlag = false;
    private boolean joinpsdenameDirtyFlag = false;
    private boolean jointagDirtyFlag = false;
    private boolean jointag2DirtyFlag = false;
    private boolean leveltagDirtyFlag = false;
    private boolean levelvalueDirtyFlag = false;
    private boolean mainflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pjoinpsdeidDirtyFlag = false;
    private boolean ppsdedqjoinidDirtyFlag = false;
    private boolean ppsdedqjoinnameDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqjoinidDirtyFlag = false;
    private boolean psdedqjoinnameDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psdejointypeidDirtyFlag = false;
    private boolean psdejointypenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean queryviewflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="aliasname")
    private String aliasname;
    @Column(name="condflag")
    private Integer condflag;
    @Column(name="condmodel")
    private String condmodel;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="extcolumns")
    private String extcolumns;
    @Column(name="joinpsdeid")
    private String joinpsdeid;
    @Column(name="joinpsdename")
    private String joinpsdename;
    @Column(name="jointag")
    private String jointag;
    @Column(name="jointag2")
    private String jointag2;
    @Column(name="leveltag")
    private String leveltag;
    @Column(name="levelvalue")
    private Integer levelvalue;
    @Column(name="mainflag")
    private Integer mainflag;
    @Column(name="memo")
    private String memo;
    @Column(name="modelstate")
    private Integer modelstate;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pjoinpsdeid")
    private String pjoinpsdeid;
    @Column(name="ppsdedqjoinid")
    private String ppsdedqjoinid;
    @Column(name="ppsdedqjoinname")
    private String ppsdedqjoinname;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqjoinid")
    private String psdedqjoinid;
    @Column(name="psdedqjoinname")
    private String psdedqjoinname;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="psdejointypeid")
    private String psdejointypeid;
    @Column(name="psdejointypename")
    private String psdejointypename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="queryviewflag")
    private Integer queryviewflag;
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
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objPPSDEDQJoinLock = new Integer(1);
    private PSDEDQJoin ppsdedqjoin = null;
    private Integer objPSDEJoinTypeLock = new Integer(1);
    private PSDEJoinType psdejointype = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;

    public void setAliasName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAliasName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aliasname = string;
        this.aliasnameDirtyFlag = true;
    }

    public String getAliasName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAliasName();
        }
        return this.aliasname;
    }

    public boolean isAliasNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAliasNameDirty();
        }
        return this.aliasnameDirtyFlag;
    }

    public void resetAliasName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAliasName();
            return;
        }
        this.aliasnameDirtyFlag = false;
        this.aliasname = null;
    }

    public void setCondFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondFlag(n);
            return;
        }
        this.condflag = n;
        this.condflagDirtyFlag = true;
    }

    public Integer getCondFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondFlag();
        }
        return this.condflag;
    }

    public boolean isCondFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondFlagDirty();
        }
        return this.condflagDirtyFlag;
    }

    public void resetCondFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondFlag();
            return;
        }
        this.condflagDirtyFlag = false;
        this.condflag = null;
    }

    public void setCondModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condmodel = string;
        this.condmodelDirtyFlag = true;
    }

    public String getCondModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModel();
        }
        return this.condmodel;
    }

    public boolean isCondModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelDirty();
        }
        return this.condmodelDirtyFlag;
    }

    public void resetCondModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModel();
            return;
        }
        this.condmodelDirtyFlag = false;
        this.condmodel = null;
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

    public void setExtColumns(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtColumns(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extcolumns = string;
        this.extcolumnsDirtyFlag = true;
    }

    public String getExtColumns() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtColumns();
        }
        return this.extcolumns;
    }

    public boolean isExtColumnsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtColumnsDirty();
        }
        return this.extcolumnsDirtyFlag;
    }

    public void resetExtColumns() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtColumns();
            return;
        }
        this.extcolumnsDirtyFlag = false;
        this.extcolumns = null;
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

    public void setLevelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leveltag = string;
        this.leveltagDirtyFlag = true;
    }

    public String getLevelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelTag();
        }
        return this.leveltag;
    }

    public boolean isLevelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelTagDirty();
        }
        return this.leveltagDirtyFlag;
    }

    public void resetLevelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelTag();
            return;
        }
        this.leveltagDirtyFlag = false;
        this.leveltag = null;
    }

    public void setLevelValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelValue(n);
            return;
        }
        this.levelvalue = n;
        this.levelvalueDirtyFlag = true;
    }

    public Integer getLevelValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelValue();
        }
        return this.levelvalue;
    }

    public boolean isLevelValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelValueDirty();
        }
        return this.levelvalueDirtyFlag;
    }

    public void resetLevelValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelValue();
            return;
        }
        this.levelvalueDirtyFlag = false;
        this.levelvalue = null;
    }

    public void setMainFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainFlag(n);
            return;
        }
        this.mainflag = n;
        this.mainflagDirtyFlag = true;
    }

    public Integer getMainFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainFlag();
        }
        return this.mainflag;
    }

    public boolean isMainFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainFlagDirty();
        }
        return this.mainflagDirtyFlag;
    }

    public void resetMainFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainFlag();
            return;
        }
        this.mainflagDirtyFlag = false;
        this.mainflag = null;
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

    public void setModelState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelState(n);
            return;
        }
        this.modelstate = n;
        this.modelstateDirtyFlag = true;
    }

    public Integer getModelState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelState();
        }
        return this.modelstate;
    }

    public boolean isModelStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelStateDirty();
        }
        return this.modelstateDirtyFlag;
    }

    public void resetModelState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelState();
            return;
        }
        this.modelstateDirtyFlag = false;
        this.modelstate = null;
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

    public void setPPSDEDQJoinId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEDQJoinId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdedqjoinid = string;
        this.ppsdedqjoinidDirtyFlag = true;
    }

    public String getPPSDEDQJoinId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEDQJoinId();
        }
        return this.ppsdedqjoinid;
    }

    public boolean isPPSDEDQJoinIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEDQJoinIdDirty();
        }
        return this.ppsdedqjoinidDirtyFlag;
    }

    public void resetPPSDEDQJoinId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEDQJoinId();
            return;
        }
        this.ppsdedqjoinidDirtyFlag = false;
        this.ppsdedqjoinid = null;
    }

    public void setPPSDEDQJoinName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEDQJoinName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdedqjoinname = string;
        this.ppsdedqjoinnameDirtyFlag = true;
    }

    public String getPPSDEDQJoinName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEDQJoinName();
        }
        return this.ppsdedqjoinname;
    }

    public boolean isPPSDEDQJoinNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEDQJoinNameDirty();
        }
        return this.ppsdedqjoinnameDirtyFlag;
    }

    public void resetPPSDEDQJoinName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEDQJoinName();
            return;
        }
        this.ppsdedqjoinnameDirtyFlag = false;
        this.ppsdedqjoinname = null;
    }

    public void setPSDEDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqid = string;
        this.psdedqidDirtyFlag = true;
    }

    public String getPSDEDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQId();
        }
        return this.psdedqid;
    }

    public boolean isPSDEDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQIdDirty();
        }
        return this.psdedqidDirtyFlag;
    }

    public void resetPSDEDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQId();
            return;
        }
        this.psdedqidDirtyFlag = false;
        this.psdedqid = null;
    }

    public void setPSDEDQJoinId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQJoinId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqjoinid = string;
        this.psdedqjoinidDirtyFlag = true;
    }

    public String getPSDEDQJoinId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQJoinId();
        }
        return this.psdedqjoinid;
    }

    public boolean isPSDEDQJoinIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQJoinIdDirty();
        }
        return this.psdedqjoinidDirtyFlag;
    }

    public void resetPSDEDQJoinId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQJoinId();
            return;
        }
        this.psdedqjoinidDirtyFlag = false;
        this.psdedqjoinid = null;
    }

    public void setPSDEDQJoinName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQJoinName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqjoinname = string;
        this.psdedqjoinnameDirtyFlag = true;
    }

    public String getPSDEDQJoinName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQJoinName();
        }
        return this.psdedqjoinname;
    }

    public boolean isPSDEDQJoinNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQJoinNameDirty();
        }
        return this.psdedqjoinnameDirtyFlag;
    }

    public void resetPSDEDQJoinName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQJoinName();
            return;
        }
        this.psdedqjoinnameDirtyFlag = false;
        this.psdedqjoinname = null;
    }

    public void setPSDEDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqname = string;
        this.psdedqnameDirtyFlag = true;
    }

    public String getPSDEDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQName();
        }
        return this.psdedqname;
    }

    public boolean isPSDEDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQNameDirty();
        }
        return this.psdedqnameDirtyFlag;
    }

    public void resetPSDEDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQName();
            return;
        }
        this.psdedqnameDirtyFlag = false;
        this.psdedqname = null;
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

    public void setQueryViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryViewFlag(n);
            return;
        }
        this.queryviewflag = n;
        this.queryviewflagDirtyFlag = true;
    }

    public Integer getQueryViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryViewFlag();
        }
        return this.queryviewflag;
    }

    public boolean isQueryViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryViewFlagDirty();
        }
        return this.queryviewflagDirtyFlag;
    }

    public void resetQueryViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryViewFlag();
            return;
        }
        this.queryviewflagDirtyFlag = false;
        this.queryviewflag = null;
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
        PSDEDQJoinBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDQJoinBase pSDEDQJoinBase) {
        pSDEDQJoinBase.resetAliasName();
        pSDEDQJoinBase.resetCondFlag();
        pSDEDQJoinBase.resetCondModel();
        pSDEDQJoinBase.resetCreateDate();
        pSDEDQJoinBase.resetCreateMan();
        pSDEDQJoinBase.resetExtColumns();
        pSDEDQJoinBase.resetJoinPSDEId();
        pSDEDQJoinBase.resetJoinPSDEName();
        pSDEDQJoinBase.resetJoinTag();
        pSDEDQJoinBase.resetJoinTag2();
        pSDEDQJoinBase.resetLevelTag();
        pSDEDQJoinBase.resetLevelValue();
        pSDEDQJoinBase.resetMainFlag();
        pSDEDQJoinBase.resetMemo();
        pSDEDQJoinBase.resetModelState();
        pSDEDQJoinBase.resetOrderValue();
        pSDEDQJoinBase.resetPJoinPSDEId();
        pSDEDQJoinBase.resetPPSDEDQJoinId();
        pSDEDQJoinBase.resetPPSDEDQJoinName();
        pSDEDQJoinBase.resetPSDEDQId();
        pSDEDQJoinBase.resetPSDEDQJoinId();
        pSDEDQJoinBase.resetPSDEDQJoinName();
        pSDEDQJoinBase.resetPSDEDQName();
        pSDEDQJoinBase.resetPSDEJoinTypeId();
        pSDEDQJoinBase.resetPSDEJoinTypeName();
        pSDEDQJoinBase.resetPSDERId();
        pSDEDQJoinBase.resetPSDERName();
        pSDEDQJoinBase.resetQueryViewFlag();
        pSDEDQJoinBase.resetUpdateDate();
        pSDEDQJoinBase.resetUpdateMan();
        pSDEDQJoinBase.resetUserCat();
        pSDEDQJoinBase.resetUserTag();
        pSDEDQJoinBase.resetUserTag2();
        pSDEDQJoinBase.resetUserTag3();
        pSDEDQJoinBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAliasNameDirty()) {
            hashMap.put(FIELD_ALIASNAME, this.getAliasName());
        }
        if (!bl || this.isCondFlagDirty()) {
            hashMap.put(FIELD_CONDFLAG, this.getCondFlag());
        }
        if (!bl || this.isCondModelDirty()) {
            hashMap.put(FIELD_CONDMODEL, this.getCondModel());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExtColumnsDirty()) {
            hashMap.put(FIELD_EXTCOLUMNS, this.getExtColumns());
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
        if (!bl || this.isLevelTagDirty()) {
            hashMap.put(FIELD_LEVELTAG, this.getLevelTag());
        }
        if (!bl || this.isLevelValueDirty()) {
            hashMap.put(FIELD_LEVELVALUE, this.getLevelValue());
        }
        if (!bl || this.isMainFlagDirty()) {
            hashMap.put(FIELD_MAINFLAG, this.getMainFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelStateDirty()) {
            hashMap.put(FIELD_MODELSTATE, this.getModelState());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPJoinPSDEIdDirty()) {
            hashMap.put(FIELD_PJOINPSDEID, this.getPJoinPSDEId());
        }
        if (!bl || this.isPPSDEDQJoinIdDirty()) {
            hashMap.put(FIELD_PPSDEDQJOINID, this.getPPSDEDQJoinId());
        }
        if (!bl || this.isPPSDEDQJoinNameDirty()) {
            hashMap.put(FIELD_PPSDEDQJOINNAME, this.getPPSDEDQJoinName());
        }
        if (!bl || this.isPSDEDQIdDirty()) {
            hashMap.put(FIELD_PSDEDQID, this.getPSDEDQId());
        }
        if (!bl || this.isPSDEDQJoinIdDirty()) {
            hashMap.put(FIELD_PSDEDQJOINID, this.getPSDEDQJoinId());
        }
        if (!bl || this.isPSDEDQJoinNameDirty()) {
            hashMap.put(FIELD_PSDEDQJOINNAME, this.getPSDEDQJoinName());
        }
        if (!bl || this.isPSDEDQNameDirty()) {
            hashMap.put(FIELD_PSDEDQNAME, this.getPSDEDQName());
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
        if (!bl || this.isQueryViewFlagDirty()) {
            hashMap.put(FIELD_QUERYVIEWFLAG, this.getQueryViewFlag());
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
        return PSDEDQJoinBase.get(this, n);
    }

    private static Object get(PSDEDQJoinBase pSDEDQJoinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQJoinBase.getAliasName();
            }
            case 1: {
                return pSDEDQJoinBase.getCondFlag();
            }
            case 2: {
                return pSDEDQJoinBase.getCondModel();
            }
            case 3: {
                return pSDEDQJoinBase.getCreateDate();
            }
            case 4: {
                return pSDEDQJoinBase.getCreateMan();
            }
            case 5: {
                return pSDEDQJoinBase.getExtColumns();
            }
            case 6: {
                return pSDEDQJoinBase.getJoinPSDEId();
            }
            case 7: {
                return pSDEDQJoinBase.getJoinPSDEName();
            }
            case 8: {
                return pSDEDQJoinBase.getJoinTag();
            }
            case 9: {
                return pSDEDQJoinBase.getJoinTag2();
            }
            case 10: {
                return pSDEDQJoinBase.getLevelTag();
            }
            case 11: {
                return pSDEDQJoinBase.getLevelValue();
            }
            case 12: {
                return pSDEDQJoinBase.getMainFlag();
            }
            case 13: {
                return pSDEDQJoinBase.getMemo();
            }
            case 14: {
                return pSDEDQJoinBase.getModelState();
            }
            case 15: {
                return pSDEDQJoinBase.getOrderValue();
            }
            case 16: {
                return pSDEDQJoinBase.getPJoinPSDEId();
            }
            case 17: {
                return pSDEDQJoinBase.getPPSDEDQJoinId();
            }
            case 18: {
                return pSDEDQJoinBase.getPPSDEDQJoinName();
            }
            case 19: {
                return pSDEDQJoinBase.getPSDEDQId();
            }
            case 20: {
                return pSDEDQJoinBase.getPSDEDQJoinId();
            }
            case 21: {
                return pSDEDQJoinBase.getPSDEDQJoinName();
            }
            case 22: {
                return pSDEDQJoinBase.getPSDEDQName();
            }
            case 23: {
                return pSDEDQJoinBase.getPSDEJoinTypeId();
            }
            case 24: {
                return pSDEDQJoinBase.getPSDEJoinTypeName();
            }
            case 25: {
                return pSDEDQJoinBase.getPSDERId();
            }
            case 26: {
                return pSDEDQJoinBase.getPSDERName();
            }
            case 27: {
                return pSDEDQJoinBase.getQueryViewFlag();
            }
            case 28: {
                return pSDEDQJoinBase.getUpdateDate();
            }
            case 29: {
                return pSDEDQJoinBase.getUpdateMan();
            }
            case 30: {
                return pSDEDQJoinBase.getUserCat();
            }
            case 31: {
                return pSDEDQJoinBase.getUserTag();
            }
            case 32: {
                return pSDEDQJoinBase.getUserTag2();
            }
            case 33: {
                return pSDEDQJoinBase.getUserTag3();
            }
            case 34: {
                return pSDEDQJoinBase.getUserTag4();
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
        PSDEDQJoinBase.set(this, n, object);
    }

    private static void set(PSDEDQJoinBase pSDEDQJoinBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQJoinBase.setAliasName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDQJoinBase.setCondFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDEDQJoinBase.setCondModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDQJoinBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEDQJoinBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDQJoinBase.setExtColumns(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDQJoinBase.setJoinPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDQJoinBase.setJoinPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDQJoinBase.setJoinTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDQJoinBase.setJoinTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDQJoinBase.setLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDQJoinBase.setLevelValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDQJoinBase.setMainFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEDQJoinBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDQJoinBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEDQJoinBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEDQJoinBase.setPJoinPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDQJoinBase.setPPSDEDQJoinId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDQJoinBase.setPPSDEDQJoinName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDQJoinBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDQJoinBase.setPSDEDQJoinId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDQJoinBase.setPSDEDQJoinName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDQJoinBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDQJoinBase.setPSDEJoinTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDQJoinBase.setPSDEJoinTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDQJoinBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDQJoinBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDQJoinBase.setQueryViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEDQJoinBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDEDQJoinBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDQJoinBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDQJoinBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDQJoinBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDQJoinBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDQJoinBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEDQJoinBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDQJoinBase pSDEDQJoinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQJoinBase.getAliasName() == null;
            }
            case 1: {
                return pSDEDQJoinBase.getCondFlag() == null;
            }
            case 2: {
                return pSDEDQJoinBase.getCondModel() == null;
            }
            case 3: {
                return pSDEDQJoinBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEDQJoinBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEDQJoinBase.getExtColumns() == null;
            }
            case 6: {
                return pSDEDQJoinBase.getJoinPSDEId() == null;
            }
            case 7: {
                return pSDEDQJoinBase.getJoinPSDEName() == null;
            }
            case 8: {
                return pSDEDQJoinBase.getJoinTag() == null;
            }
            case 9: {
                return pSDEDQJoinBase.getJoinTag2() == null;
            }
            case 10: {
                return pSDEDQJoinBase.getLevelTag() == null;
            }
            case 11: {
                return pSDEDQJoinBase.getLevelValue() == null;
            }
            case 12: {
                return pSDEDQJoinBase.getMainFlag() == null;
            }
            case 13: {
                return pSDEDQJoinBase.getMemo() == null;
            }
            case 14: {
                return pSDEDQJoinBase.getModelState() == null;
            }
            case 15: {
                return pSDEDQJoinBase.getOrderValue() == null;
            }
            case 16: {
                return pSDEDQJoinBase.getPJoinPSDEId() == null;
            }
            case 17: {
                return pSDEDQJoinBase.getPPSDEDQJoinId() == null;
            }
            case 18: {
                return pSDEDQJoinBase.getPPSDEDQJoinName() == null;
            }
            case 19: {
                return pSDEDQJoinBase.getPSDEDQId() == null;
            }
            case 20: {
                return pSDEDQJoinBase.getPSDEDQJoinId() == null;
            }
            case 21: {
                return pSDEDQJoinBase.getPSDEDQJoinName() == null;
            }
            case 22: {
                return pSDEDQJoinBase.getPSDEDQName() == null;
            }
            case 23: {
                return pSDEDQJoinBase.getPSDEJoinTypeId() == null;
            }
            case 24: {
                return pSDEDQJoinBase.getPSDEJoinTypeName() == null;
            }
            case 25: {
                return pSDEDQJoinBase.getPSDERId() == null;
            }
            case 26: {
                return pSDEDQJoinBase.getPSDERName() == null;
            }
            case 27: {
                return pSDEDQJoinBase.getQueryViewFlag() == null;
            }
            case 28: {
                return pSDEDQJoinBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDEDQJoinBase.getUpdateMan() == null;
            }
            case 30: {
                return pSDEDQJoinBase.getUserCat() == null;
            }
            case 31: {
                return pSDEDQJoinBase.getUserTag() == null;
            }
            case 32: {
                return pSDEDQJoinBase.getUserTag2() == null;
            }
            case 33: {
                return pSDEDQJoinBase.getUserTag3() == null;
            }
            case 34: {
                return pSDEDQJoinBase.getUserTag4() == null;
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
        return PSDEDQJoinBase.contains(this, n);
    }

    private static boolean contains(PSDEDQJoinBase pSDEDQJoinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQJoinBase.isAliasNameDirty();
            }
            case 1: {
                return pSDEDQJoinBase.isCondFlagDirty();
            }
            case 2: {
                return pSDEDQJoinBase.isCondModelDirty();
            }
            case 3: {
                return pSDEDQJoinBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEDQJoinBase.isCreateManDirty();
            }
            case 5: {
                return pSDEDQJoinBase.isExtColumnsDirty();
            }
            case 6: {
                return pSDEDQJoinBase.isJoinPSDEIdDirty();
            }
            case 7: {
                return pSDEDQJoinBase.isJoinPSDENameDirty();
            }
            case 8: {
                return pSDEDQJoinBase.isJoinTagDirty();
            }
            case 9: {
                return pSDEDQJoinBase.isJoinTag2Dirty();
            }
            case 10: {
                return pSDEDQJoinBase.isLevelTagDirty();
            }
            case 11: {
                return pSDEDQJoinBase.isLevelValueDirty();
            }
            case 12: {
                return pSDEDQJoinBase.isMainFlagDirty();
            }
            case 13: {
                return pSDEDQJoinBase.isMemoDirty();
            }
            case 14: {
                return pSDEDQJoinBase.isModelStateDirty();
            }
            case 15: {
                return pSDEDQJoinBase.isOrderValueDirty();
            }
            case 16: {
                return pSDEDQJoinBase.isPJoinPSDEIdDirty();
            }
            case 17: {
                return pSDEDQJoinBase.isPPSDEDQJoinIdDirty();
            }
            case 18: {
                return pSDEDQJoinBase.isPPSDEDQJoinNameDirty();
            }
            case 19: {
                return pSDEDQJoinBase.isPSDEDQIdDirty();
            }
            case 20: {
                return pSDEDQJoinBase.isPSDEDQJoinIdDirty();
            }
            case 21: {
                return pSDEDQJoinBase.isPSDEDQJoinNameDirty();
            }
            case 22: {
                return pSDEDQJoinBase.isPSDEDQNameDirty();
            }
            case 23: {
                return pSDEDQJoinBase.isPSDEJoinTypeIdDirty();
            }
            case 24: {
                return pSDEDQJoinBase.isPSDEJoinTypeNameDirty();
            }
            case 25: {
                return pSDEDQJoinBase.isPSDERIdDirty();
            }
            case 26: {
                return pSDEDQJoinBase.isPSDERNameDirty();
            }
            case 27: {
                return pSDEDQJoinBase.isQueryViewFlagDirty();
            }
            case 28: {
                return pSDEDQJoinBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDEDQJoinBase.isUpdateManDirty();
            }
            case 30: {
                return pSDEDQJoinBase.isUserCatDirty();
            }
            case 31: {
                return pSDEDQJoinBase.isUserTagDirty();
            }
            case 32: {
                return pSDEDQJoinBase.isUserTag2Dirty();
            }
            case 33: {
                return pSDEDQJoinBase.isUserTag3Dirty();
            }
            case 34: {
                return pSDEDQJoinBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDQJoinBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDQJoinBase pSDEDQJoinBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDQJoinBase.getAliasName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aliasname", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getAliasName()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getCondFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condflag", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getCondFlag()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getCondModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodel", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getCondModel()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getExtColumns() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extcolumns", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getExtColumns()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getJoinPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"joinpsdeid", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getJoinPSDEId()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getJoinPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"joinpsdename", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getJoinPSDEName()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getJoinTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jointag", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getJoinTag()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getJoinTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jointag2", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getJoinTag2()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leveltag", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getLevelTag()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getLevelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelvalue", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getLevelValue()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getMainFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainflag", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getMainFlag()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getModelState()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPJoinPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pjoinpsdeid", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPJoinPSDEId()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPPSDEDQJoinId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdedqjoinid", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPPSDEDQJoinId()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPPSDEDQJoinName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdedqjoinname", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPPSDEDQJoinName()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPSDEDQJoinId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqjoinid", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPSDEDQJoinId()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPSDEDQJoinName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqjoinname", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPSDEDQJoinName()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPSDEJoinTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdejointypeid", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPSDEJoinTypeId()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPSDEJoinTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdejointypename", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPSDEJoinTypeName()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getQueryViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"queryviewflag", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getQueryViewFlag()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDQJoinBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDQJoinBase.getJSONValue((Object)pSDEDQJoinBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDQJoinBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDQJoinBase pSDEDQJoinBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDQJoinBase.getAliasName() != null) {
            object = pSDEDQJoinBase.getAliasName();
            xmlNode.setAttribute(FIELD_ALIASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getCondFlag() != null) {
            object = pSDEDQJoinBase.getCondFlag();
            xmlNode.setAttribute(FIELD_CONDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQJoinBase.getCondModel() != null) {
            object = pSDEDQJoinBase.getCondModel();
            xmlNode.setAttribute(FIELD_CONDMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getCreateDate() != null) {
            object = pSDEDQJoinBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQJoinBase.getCreateMan() != null) {
            object = pSDEDQJoinBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getExtColumns() != null) {
            object = pSDEDQJoinBase.getExtColumns();
            xmlNode.setAttribute(FIELD_EXTCOLUMNS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getJoinPSDEId() != null) {
            object = pSDEDQJoinBase.getJoinPSDEId();
            xmlNode.setAttribute(FIELD_JOINPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getJoinPSDEName() != null) {
            object = pSDEDQJoinBase.getJoinPSDEName();
            xmlNode.setAttribute(FIELD_JOINPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getJoinTag() != null) {
            object = pSDEDQJoinBase.getJoinTag();
            xmlNode.setAttribute(FIELD_JOINTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getJoinTag2() != null) {
            object = pSDEDQJoinBase.getJoinTag2();
            xmlNode.setAttribute(FIELD_JOINTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getLevelTag() != null) {
            object = pSDEDQJoinBase.getLevelTag();
            xmlNode.setAttribute(FIELD_LEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getLevelValue() != null) {
            object = pSDEDQJoinBase.getLevelValue();
            xmlNode.setAttribute(FIELD_LEVELVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQJoinBase.getMainFlag() != null) {
            object = pSDEDQJoinBase.getMainFlag();
            xmlNode.setAttribute(FIELD_MAINFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQJoinBase.getMemo() != null) {
            object = pSDEDQJoinBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getModelState() != null) {
            object = pSDEDQJoinBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQJoinBase.getOrderValue() != null) {
            object = pSDEDQJoinBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQJoinBase.getPJoinPSDEId() != null) {
            object = pSDEDQJoinBase.getPJoinPSDEId();
            xmlNode.setAttribute(FIELD_PJOINPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPPSDEDQJoinId() != null) {
            object = pSDEDQJoinBase.getPPSDEDQJoinId();
            xmlNode.setAttribute(FIELD_PPSDEDQJOINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPPSDEDQJoinName() != null) {
            object = pSDEDQJoinBase.getPPSDEDQJoinName();
            xmlNode.setAttribute(FIELD_PPSDEDQJOINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPSDEDQId() != null) {
            object = pSDEDQJoinBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPSDEDQJoinId() != null) {
            object = pSDEDQJoinBase.getPSDEDQJoinId();
            xmlNode.setAttribute(FIELD_PSDEDQJOINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPSDEDQJoinName() != null) {
            object = pSDEDQJoinBase.getPSDEDQJoinName();
            xmlNode.setAttribute(FIELD_PSDEDQJOINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPSDEDQName() != null) {
            object = pSDEDQJoinBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPSDEJoinTypeId() != null) {
            object = pSDEDQJoinBase.getPSDEJoinTypeId();
            xmlNode.setAttribute(FIELD_PSDEJOINTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPSDEJoinTypeName() != null) {
            object = pSDEDQJoinBase.getPSDEJoinTypeName();
            xmlNode.setAttribute(FIELD_PSDEJOINTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPSDERId() != null) {
            object = pSDEDQJoinBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getPSDERName() != null) {
            object = pSDEDQJoinBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getQueryViewFlag() != null) {
            object = pSDEDQJoinBase.getQueryViewFlag();
            xmlNode.setAttribute(FIELD_QUERYVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQJoinBase.getUpdateDate() != null) {
            object = pSDEDQJoinBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQJoinBase.getUpdateMan() != null) {
            object = pSDEDQJoinBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getUserCat() != null) {
            object = pSDEDQJoinBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getUserTag() != null) {
            object = pSDEDQJoinBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getUserTag2() != null) {
            object = pSDEDQJoinBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getUserTag3() != null) {
            object = pSDEDQJoinBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQJoinBase.getUserTag4() != null) {
            object = pSDEDQJoinBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDQJoinBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDQJoinBase pSDEDQJoinBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDQJoinBase.isAliasNameDirty() && (bl || pSDEDQJoinBase.getAliasName() != null)) {
            iDataObject.set(FIELD_ALIASNAME, (Object)pSDEDQJoinBase.getAliasName());
        }
        if (pSDEDQJoinBase.isCondFlagDirty() && (bl || pSDEDQJoinBase.getCondFlag() != null)) {
            iDataObject.set(FIELD_CONDFLAG, (Object)pSDEDQJoinBase.getCondFlag());
        }
        if (pSDEDQJoinBase.isCondModelDirty() && (bl || pSDEDQJoinBase.getCondModel() != null)) {
            iDataObject.set(FIELD_CONDMODEL, (Object)pSDEDQJoinBase.getCondModel());
        }
        if (pSDEDQJoinBase.isCreateDateDirty() && (bl || pSDEDQJoinBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDQJoinBase.getCreateDate());
        }
        if (pSDEDQJoinBase.isCreateManDirty() && (bl || pSDEDQJoinBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDQJoinBase.getCreateMan());
        }
        if (pSDEDQJoinBase.isExtColumnsDirty() && (bl || pSDEDQJoinBase.getExtColumns() != null)) {
            iDataObject.set(FIELD_EXTCOLUMNS, (Object)pSDEDQJoinBase.getExtColumns());
        }
        if (pSDEDQJoinBase.isJoinPSDEIdDirty() && (bl || pSDEDQJoinBase.getJoinPSDEId() != null)) {
            iDataObject.set(FIELD_JOINPSDEID, (Object)pSDEDQJoinBase.getJoinPSDEId());
        }
        if (pSDEDQJoinBase.isJoinPSDENameDirty() && (bl || pSDEDQJoinBase.getJoinPSDEName() != null)) {
            iDataObject.set(FIELD_JOINPSDENAME, (Object)pSDEDQJoinBase.getJoinPSDEName());
        }
        if (pSDEDQJoinBase.isJoinTagDirty() && (bl || pSDEDQJoinBase.getJoinTag() != null)) {
            iDataObject.set(FIELD_JOINTAG, (Object)pSDEDQJoinBase.getJoinTag());
        }
        if (pSDEDQJoinBase.isJoinTag2Dirty() && (bl || pSDEDQJoinBase.getJoinTag2() != null)) {
            iDataObject.set(FIELD_JOINTAG2, (Object)pSDEDQJoinBase.getJoinTag2());
        }
        if (pSDEDQJoinBase.isLevelTagDirty() && (bl || pSDEDQJoinBase.getLevelTag() != null)) {
            iDataObject.set(FIELD_LEVELTAG, (Object)pSDEDQJoinBase.getLevelTag());
        }
        if (pSDEDQJoinBase.isLevelValueDirty() && (bl || pSDEDQJoinBase.getLevelValue() != null)) {
            iDataObject.set(FIELD_LEVELVALUE, (Object)pSDEDQJoinBase.getLevelValue());
        }
        if (pSDEDQJoinBase.isMainFlagDirty() && (bl || pSDEDQJoinBase.getMainFlag() != null)) {
            iDataObject.set(FIELD_MAINFLAG, (Object)pSDEDQJoinBase.getMainFlag());
        }
        if (pSDEDQJoinBase.isMemoDirty() && (bl || pSDEDQJoinBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDQJoinBase.getMemo());
        }
        if (pSDEDQJoinBase.isModelStateDirty() && (bl || pSDEDQJoinBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDEDQJoinBase.getModelState());
        }
        if (pSDEDQJoinBase.isOrderValueDirty() && (bl || pSDEDQJoinBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDQJoinBase.getOrderValue());
        }
        if (pSDEDQJoinBase.isPJoinPSDEIdDirty() && (bl || pSDEDQJoinBase.getPJoinPSDEId() != null)) {
            iDataObject.set(FIELD_PJOINPSDEID, (Object)pSDEDQJoinBase.getPJoinPSDEId());
        }
        if (pSDEDQJoinBase.isPPSDEDQJoinIdDirty() && (bl || pSDEDQJoinBase.getPPSDEDQJoinId() != null)) {
            iDataObject.set(FIELD_PPSDEDQJOINID, (Object)pSDEDQJoinBase.getPPSDEDQJoinId());
        }
        if (pSDEDQJoinBase.isPPSDEDQJoinNameDirty() && (bl || pSDEDQJoinBase.getPPSDEDQJoinName() != null)) {
            iDataObject.set(FIELD_PPSDEDQJOINNAME, (Object)pSDEDQJoinBase.getPPSDEDQJoinName());
        }
        if (pSDEDQJoinBase.isPSDEDQIdDirty() && (bl || pSDEDQJoinBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDEDQJoinBase.getPSDEDQId());
        }
        if (pSDEDQJoinBase.isPSDEDQJoinIdDirty() && (bl || pSDEDQJoinBase.getPSDEDQJoinId() != null)) {
            iDataObject.set(FIELD_PSDEDQJOINID, (Object)pSDEDQJoinBase.getPSDEDQJoinId());
        }
        if (pSDEDQJoinBase.isPSDEDQJoinNameDirty() && (bl || pSDEDQJoinBase.getPSDEDQJoinName() != null)) {
            iDataObject.set(FIELD_PSDEDQJOINNAME, (Object)pSDEDQJoinBase.getPSDEDQJoinName());
        }
        if (pSDEDQJoinBase.isPSDEDQNameDirty() && (bl || pSDEDQJoinBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDEDQJoinBase.getPSDEDQName());
        }
        if (pSDEDQJoinBase.isPSDEJoinTypeIdDirty() && (bl || pSDEDQJoinBase.getPSDEJoinTypeId() != null)) {
            iDataObject.set(FIELD_PSDEJOINTYPEID, (Object)pSDEDQJoinBase.getPSDEJoinTypeId());
        }
        if (pSDEDQJoinBase.isPSDEJoinTypeNameDirty() && (bl || pSDEDQJoinBase.getPSDEJoinTypeName() != null)) {
            iDataObject.set(FIELD_PSDEJOINTYPENAME, (Object)pSDEDQJoinBase.getPSDEJoinTypeName());
        }
        if (pSDEDQJoinBase.isPSDERIdDirty() && (bl || pSDEDQJoinBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDEDQJoinBase.getPSDERId());
        }
        if (pSDEDQJoinBase.isPSDERNameDirty() && (bl || pSDEDQJoinBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDEDQJoinBase.getPSDERName());
        }
        if (pSDEDQJoinBase.isQueryViewFlagDirty() && (bl || pSDEDQJoinBase.getQueryViewFlag() != null)) {
            iDataObject.set(FIELD_QUERYVIEWFLAG, (Object)pSDEDQJoinBase.getQueryViewFlag());
        }
        if (pSDEDQJoinBase.isUpdateDateDirty() && (bl || pSDEDQJoinBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDQJoinBase.getUpdateDate());
        }
        if (pSDEDQJoinBase.isUpdateManDirty() && (bl || pSDEDQJoinBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDQJoinBase.getUpdateMan());
        }
        if (pSDEDQJoinBase.isUserCatDirty() && (bl || pSDEDQJoinBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDQJoinBase.getUserCat());
        }
        if (pSDEDQJoinBase.isUserTagDirty() && (bl || pSDEDQJoinBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDQJoinBase.getUserTag());
        }
        if (pSDEDQJoinBase.isUserTag2Dirty() && (bl || pSDEDQJoinBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDQJoinBase.getUserTag2());
        }
        if (pSDEDQJoinBase.isUserTag3Dirty() && (bl || pSDEDQJoinBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDQJoinBase.getUserTag3());
        }
        if (pSDEDQJoinBase.isUserTag4Dirty() && (bl || pSDEDQJoinBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDQJoinBase.getUserTag4());
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
        return PSDEDQJoinBase.remove(this, n);
    }

    private static boolean remove(PSDEDQJoinBase pSDEDQJoinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQJoinBase.resetAliasName();
                return true;
            }
            case 1: {
                pSDEDQJoinBase.resetCondFlag();
                return true;
            }
            case 2: {
                pSDEDQJoinBase.resetCondModel();
                return true;
            }
            case 3: {
                pSDEDQJoinBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEDQJoinBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEDQJoinBase.resetExtColumns();
                return true;
            }
            case 6: {
                pSDEDQJoinBase.resetJoinPSDEId();
                return true;
            }
            case 7: {
                pSDEDQJoinBase.resetJoinPSDEName();
                return true;
            }
            case 8: {
                pSDEDQJoinBase.resetJoinTag();
                return true;
            }
            case 9: {
                pSDEDQJoinBase.resetJoinTag2();
                return true;
            }
            case 10: {
                pSDEDQJoinBase.resetLevelTag();
                return true;
            }
            case 11: {
                pSDEDQJoinBase.resetLevelValue();
                return true;
            }
            case 12: {
                pSDEDQJoinBase.resetMainFlag();
                return true;
            }
            case 13: {
                pSDEDQJoinBase.resetMemo();
                return true;
            }
            case 14: {
                pSDEDQJoinBase.resetModelState();
                return true;
            }
            case 15: {
                pSDEDQJoinBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSDEDQJoinBase.resetPJoinPSDEId();
                return true;
            }
            case 17: {
                pSDEDQJoinBase.resetPPSDEDQJoinId();
                return true;
            }
            case 18: {
                pSDEDQJoinBase.resetPPSDEDQJoinName();
                return true;
            }
            case 19: {
                pSDEDQJoinBase.resetPSDEDQId();
                return true;
            }
            case 20: {
                pSDEDQJoinBase.resetPSDEDQJoinId();
                return true;
            }
            case 21: {
                pSDEDQJoinBase.resetPSDEDQJoinName();
                return true;
            }
            case 22: {
                pSDEDQJoinBase.resetPSDEDQName();
                return true;
            }
            case 23: {
                pSDEDQJoinBase.resetPSDEJoinTypeId();
                return true;
            }
            case 24: {
                pSDEDQJoinBase.resetPSDEJoinTypeName();
                return true;
            }
            case 25: {
                pSDEDQJoinBase.resetPSDERId();
                return true;
            }
            case 26: {
                pSDEDQJoinBase.resetPSDERName();
                return true;
            }
            case 27: {
                pSDEDQJoinBase.resetQueryViewFlag();
                return true;
            }
            case 28: {
                pSDEDQJoinBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDEDQJoinBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSDEDQJoinBase.resetUserCat();
                return true;
            }
            case 31: {
                pSDEDQJoinBase.resetUserTag();
                return true;
            }
            case 32: {
                pSDEDQJoinBase.resetUserTag2();
                return true;
            }
            case 33: {
                pSDEDQJoinBase.resetUserTag3();
                return true;
            }
            case 34: {
                pSDEDQJoinBase.resetUserTag4();
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
    public PSDEDataQuery getPSDEDQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQ();
        }
        if (this.getPSDEDQId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQLock;
        synchronized (n) {
            if (this.psdedq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQId(), (Object)this.psdedq.getPSDEDataQueryId()) != 0L) {
                this.psdedq = null;
            }
            if (this.psdedq == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDQId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet(pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDQJoin getPPSDEDQJoin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEDQJoin();
        }
        if (this.getPPSDEDQJoinId() == null) {
            return null;
        }
        Integer n = this.objPPSDEDQJoinLock;
        synchronized (n) {
            if (this.ppsdedqjoin != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDEDQJoinId(), (Object)this.ppsdedqjoin.getPSDEDQJoinId()) != 0L) {
                this.ppsdedqjoin = null;
            }
            if (this.ppsdedqjoin == null) {
                PSDEDQJoin pSDEDQJoin = new PSDEDQJoin();
                pSDEDQJoin.setPSDEDQJoinId(this.getPPSDEDQJoinId());
                PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
                pSDEDQJoinService.autoGet(pSDEDQJoin);
                this.ppsdedqjoin = pSDEDQJoin;
            }
            return this.ppsdedqjoin;
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

    private PSDEDQJoinBase getProxyEntity() {
        return this.proxyPSDEDQJoinBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDQJoinBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDQJoinBase) {
            this.proxyPSDEDQJoinBase = (PSDEDQJoinBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALIASNAME, 0);
        fieldIndexMap.put(FIELD_CONDFLAG, 1);
        fieldIndexMap.put(FIELD_CONDMODEL, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_EXTCOLUMNS, 5);
        fieldIndexMap.put(FIELD_JOINPSDEID, 6);
        fieldIndexMap.put(FIELD_JOINPSDENAME, 7);
        fieldIndexMap.put(FIELD_JOINTAG, 8);
        fieldIndexMap.put(FIELD_JOINTAG2, 9);
        fieldIndexMap.put(FIELD_LEVELTAG, 10);
        fieldIndexMap.put(FIELD_LEVELVALUE, 11);
        fieldIndexMap.put(FIELD_MAINFLAG, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_MODELSTATE, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_PJOINPSDEID, 16);
        fieldIndexMap.put(FIELD_PPSDEDQJOINID, 17);
        fieldIndexMap.put(FIELD_PPSDEDQJOINNAME, 18);
        fieldIndexMap.put(FIELD_PSDEDQID, 19);
        fieldIndexMap.put(FIELD_PSDEDQJOINID, 20);
        fieldIndexMap.put(FIELD_PSDEDQJOINNAME, 21);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 22);
        fieldIndexMap.put(FIELD_PSDEJOINTYPEID, 23);
        fieldIndexMap.put(FIELD_PSDEJOINTYPENAME, 24);
        fieldIndexMap.put(FIELD_PSDERID, 25);
        fieldIndexMap.put(FIELD_PSDERNAME, 26);
        fieldIndexMap.put(FIELD_QUERYVIEWFLAG, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERCAT, 30);
        fieldIndexMap.put(FIELD_USERTAG, 31);
        fieldIndexMap.put(FIELD_USERTAG2, 32);
        fieldIndexMap.put(FIELD_USERTAG3, 33);
        fieldIndexMap.put(FIELD_USERTAG4, 34);
    }
}

