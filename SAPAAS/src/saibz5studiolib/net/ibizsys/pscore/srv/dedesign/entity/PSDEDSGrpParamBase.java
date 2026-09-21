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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDSGrpParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDSGrpParamBase.class);
    public static final String FIELD_AGGMODE = "AGGMODE";
    public static final String FIELD_ALIASNAME = "ALIASNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMDEFNAME = "CUSTOMDEFNAME";
    public static final String FIELD_GROUPCODE = "GROUPCODE";
    public static final String FIELD_GROUPFLAG = "GROUPFLAG";
    public static final String FIELD_GROUPJOINCODE = "GROUPJOINCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERDIR = "ORDERDIR";
    public static final String FIELD_PSDEDSGRPPARAMID = "PSDEDSGRPPARAMID";
    public static final String FIELD_PSDEDSGRPPARAMNAME = "PSDEDSGRPPARAMNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_SORTORDERVALUE = "SORTORDERVALUE";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AGGMODE = 0;
    private static final int INDEX_ALIASNAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMDEFNAME = 4;
    private static final int INDEX_GROUPCODE = 5;
    private static final int INDEX_GROUPFLAG = 6;
    private static final int INDEX_GROUPJOINCODE = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERDIR = 9;
    private static final int INDEX_PSDEDSGRPPARAMID = 10;
    private static final int INDEX_PSDEDSGRPPARAMNAME = 11;
    private static final int INDEX_PSDEDSID = 12;
    private static final int INDEX_PSDEDSNAME = 13;
    private static final int INDEX_PSDEFID = 14;
    private static final int INDEX_PSDEFNAME = 15;
    private static final int INDEX_PSDEID = 16;
    private static final int INDEX_SORTORDERVALUE = 17;
    private static final int INDEX_STDDATATYPE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERDATA = 22;
    private static final int INDEX_USERDATA2 = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDSGrpParamBase proxyPSDEDSGrpParamBase = null;
    private boolean aggmodeDirtyFlag = false;
    private boolean aliasnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customdefnameDirtyFlag = false;
    private boolean groupcodeDirtyFlag = false;
    private boolean groupflagDirtyFlag = false;
    private boolean groupjoincodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean orderdirDirtyFlag = false;
    private boolean psdedsgrpparamidDirtyFlag = false;
    private boolean psdedsgrpparamnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean sortordervalueDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="aggmode")
    private String aggmode;
    @Column(name="aliasname")
    private String aliasname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customdefname")
    private String customdefname;
    @Column(name="groupcode")
    private String groupcode;
    @Column(name="groupflag")
    private Integer groupflag;
    @Column(name="groupjoincode")
    private String groupjoincode;
    @Column(name="memo")
    private String memo;
    @Column(name="orderdir")
    private String orderdir;
    @Column(name="psdedsgrpparamid")
    private String psdedsgrpparamid;
    @Column(name="psdedsgrpparamname")
    private String psdedsgrpparamname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="sortordervalue")
    private Integer sortordervalue;
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;

    public void setAggMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggmode = string;
        this.aggmodeDirtyFlag = true;
    }

    public String getAggMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggMode();
        }
        return this.aggmode;
    }

    public boolean isAggModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggModeDirty();
        }
        return this.aggmodeDirtyFlag;
    }

    public void resetAggMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggMode();
            return;
        }
        this.aggmodeDirtyFlag = false;
        this.aggmode = null;
    }

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

    public void setCustomDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customdefname = string;
        this.customdefnameDirtyFlag = true;
    }

    public String getCustomDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomDEFName();
        }
        return this.customdefname;
    }

    public boolean isCustomDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomDEFNameDirty();
        }
        return this.customdefnameDirtyFlag;
    }

    public void resetCustomDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomDEFName();
            return;
        }
        this.customdefnameDirtyFlag = false;
        this.customdefname = null;
    }

    public void setGroupCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupcode = string;
        this.groupcodeDirtyFlag = true;
    }

    public String getGroupCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupCode();
        }
        return this.groupcode;
    }

    public boolean isGroupCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupCodeDirty();
        }
        return this.groupcodeDirtyFlag;
    }

    public void resetGroupCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupCode();
            return;
        }
        this.groupcodeDirtyFlag = false;
        this.groupcode = null;
    }

    public void setGroupFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupFlag(n);
            return;
        }
        this.groupflag = n;
        this.groupflagDirtyFlag = true;
    }

    public Integer getGroupFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupFlag();
        }
        return this.groupflag;
    }

    public boolean isGroupFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupFlagDirty();
        }
        return this.groupflagDirtyFlag;
    }

    public void resetGroupFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupFlag();
            return;
        }
        this.groupflagDirtyFlag = false;
        this.groupflag = null;
    }

    public void setGroupJoinCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupJoinCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupjoincode = string;
        this.groupjoincodeDirtyFlag = true;
    }

    public String getGroupJoinCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupJoinCode();
        }
        return this.groupjoincode;
    }

    public boolean isGroupJoinCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupJoinCodeDirty();
        }
        return this.groupjoincodeDirtyFlag;
    }

    public void resetGroupJoinCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupJoinCode();
            return;
        }
        this.groupjoincodeDirtyFlag = false;
        this.groupjoincode = null;
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

    public void setOrderDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.orderdir = string;
        this.orderdirDirtyFlag = true;
    }

    public String getOrderDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderDir();
        }
        return this.orderdir;
    }

    public boolean isOrderDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderDirDirty();
        }
        return this.orderdirDirtyFlag;
    }

    public void resetOrderDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderDir();
            return;
        }
        this.orderdirDirtyFlag = false;
        this.orderdir = null;
    }

    public void setPSDEDSGrpParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSGrpParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsgrpparamid = string;
        this.psdedsgrpparamidDirtyFlag = true;
    }

    public String getPSDEDSGrpParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSGrpParamId();
        }
        return this.psdedsgrpparamid;
    }

    public boolean isPSDEDSGrpParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSGrpParamIdDirty();
        }
        return this.psdedsgrpparamidDirtyFlag;
    }

    public void resetPSDEDSGrpParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSGrpParamId();
            return;
        }
        this.psdedsgrpparamidDirtyFlag = false;
        this.psdedsgrpparamid = null;
    }

    public void setPSDEDSGrpParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSGrpParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsgrpparamname = string;
        this.psdedsgrpparamnameDirtyFlag = true;
    }

    public String getPSDEDSGrpParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSGrpParamName();
        }
        return this.psdedsgrpparamname;
    }

    public boolean isPSDEDSGrpParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSGrpParamNameDirty();
        }
        return this.psdedsgrpparamnameDirtyFlag;
    }

    public void resetPSDEDSGrpParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSGrpParamName();
            return;
        }
        this.psdedsgrpparamnameDirtyFlag = false;
        this.psdedsgrpparamname = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setSortOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSortOrderValue(n);
            return;
        }
        this.sortordervalue = n;
        this.sortordervalueDirtyFlag = true;
    }

    public Integer getSortOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSortOrderValue();
        }
        return this.sortordervalue;
    }

    public boolean isSortOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSortOrderValueDirty();
        }
        return this.sortordervalueDirtyFlag;
    }

    public void resetSortOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSortOrderValue();
            return;
        }
        this.sortordervalueDirtyFlag = false;
        this.sortordervalue = null;
    }

    public void setStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStdDataType(n);
            return;
        }
        this.stddatatype = n;
        this.stddatatypeDirtyFlag = true;
    }

    public Integer getStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStdDataType();
        }
        return this.stddatatype;
    }

    public boolean isStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStdDataTypeDirty();
        }
        return this.stddatatypeDirtyFlag;
    }

    public void resetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStdDataType();
            return;
        }
        this.stddatatypeDirtyFlag = false;
        this.stddatatype = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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
        PSDEDSGrpParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDSGrpParamBase pSDEDSGrpParamBase) {
        pSDEDSGrpParamBase.resetAggMode();
        pSDEDSGrpParamBase.resetAliasName();
        pSDEDSGrpParamBase.resetCreateDate();
        pSDEDSGrpParamBase.resetCreateMan();
        pSDEDSGrpParamBase.resetCustomDEFName();
        pSDEDSGrpParamBase.resetGroupCode();
        pSDEDSGrpParamBase.resetGroupFlag();
        pSDEDSGrpParamBase.resetGroupJoinCode();
        pSDEDSGrpParamBase.resetMemo();
        pSDEDSGrpParamBase.resetOrderDir();
        pSDEDSGrpParamBase.resetPSDEDSGrpParamId();
        pSDEDSGrpParamBase.resetPSDEDSGrpParamName();
        pSDEDSGrpParamBase.resetPSDEDSId();
        pSDEDSGrpParamBase.resetPSDEDSName();
        pSDEDSGrpParamBase.resetPSDEFId();
        pSDEDSGrpParamBase.resetPSDEFName();
        pSDEDSGrpParamBase.resetPSDEId();
        pSDEDSGrpParamBase.resetSortOrderValue();
        pSDEDSGrpParamBase.resetStdDataType();
        pSDEDSGrpParamBase.resetUpdateDate();
        pSDEDSGrpParamBase.resetUpdateMan();
        pSDEDSGrpParamBase.resetUserCat();
        pSDEDSGrpParamBase.resetUserData();
        pSDEDSGrpParamBase.resetUserData2();
        pSDEDSGrpParamBase.resetUserTag();
        pSDEDSGrpParamBase.resetUserTag2();
        pSDEDSGrpParamBase.resetUserTag3();
        pSDEDSGrpParamBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAggModeDirty()) {
            hashMap.put(FIELD_AGGMODE, this.getAggMode());
        }
        if (!bl || this.isAliasNameDirty()) {
            hashMap.put(FIELD_ALIASNAME, this.getAliasName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomDEFNameDirty()) {
            hashMap.put(FIELD_CUSTOMDEFNAME, this.getCustomDEFName());
        }
        if (!bl || this.isGroupCodeDirty()) {
            hashMap.put(FIELD_GROUPCODE, this.getGroupCode());
        }
        if (!bl || this.isGroupFlagDirty()) {
            hashMap.put(FIELD_GROUPFLAG, this.getGroupFlag());
        }
        if (!bl || this.isGroupJoinCodeDirty()) {
            hashMap.put(FIELD_GROUPJOINCODE, this.getGroupJoinCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderDirDirty()) {
            hashMap.put(FIELD_ORDERDIR, this.getOrderDir());
        }
        if (!bl || this.isPSDEDSGrpParamIdDirty()) {
            hashMap.put(FIELD_PSDEDSGRPPARAMID, this.getPSDEDSGrpParamId());
        }
        if (!bl || this.isPSDEDSGrpParamNameDirty()) {
            hashMap.put(FIELD_PSDEDSGRPPARAMNAME, this.getPSDEDSGrpParamName());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isSortOrderValueDirty()) {
            hashMap.put(FIELD_SORTORDERVALUE, this.getSortOrderValue());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        return PSDEDSGrpParamBase.get(this, n);
    }

    private static Object get(PSDEDSGrpParamBase pSDEDSGrpParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSGrpParamBase.getAggMode();
            }
            case 1: {
                return pSDEDSGrpParamBase.getAliasName();
            }
            case 2: {
                return pSDEDSGrpParamBase.getCreateDate();
            }
            case 3: {
                return pSDEDSGrpParamBase.getCreateMan();
            }
            case 4: {
                return pSDEDSGrpParamBase.getCustomDEFName();
            }
            case 5: {
                return pSDEDSGrpParamBase.getGroupCode();
            }
            case 6: {
                return pSDEDSGrpParamBase.getGroupFlag();
            }
            case 7: {
                return pSDEDSGrpParamBase.getGroupJoinCode();
            }
            case 8: {
                return pSDEDSGrpParamBase.getMemo();
            }
            case 9: {
                return pSDEDSGrpParamBase.getOrderDir();
            }
            case 10: {
                return pSDEDSGrpParamBase.getPSDEDSGrpParamId();
            }
            case 11: {
                return pSDEDSGrpParamBase.getPSDEDSGrpParamName();
            }
            case 12: {
                return pSDEDSGrpParamBase.getPSDEDSId();
            }
            case 13: {
                return pSDEDSGrpParamBase.getPSDEDSName();
            }
            case 14: {
                return pSDEDSGrpParamBase.getPSDEFId();
            }
            case 15: {
                return pSDEDSGrpParamBase.getPSDEFName();
            }
            case 16: {
                return pSDEDSGrpParamBase.getPSDEId();
            }
            case 17: {
                return pSDEDSGrpParamBase.getSortOrderValue();
            }
            case 18: {
                return pSDEDSGrpParamBase.getStdDataType();
            }
            case 19: {
                return pSDEDSGrpParamBase.getUpdateDate();
            }
            case 20: {
                return pSDEDSGrpParamBase.getUpdateMan();
            }
            case 21: {
                return pSDEDSGrpParamBase.getUserCat();
            }
            case 22: {
                return pSDEDSGrpParamBase.getUserData();
            }
            case 23: {
                return pSDEDSGrpParamBase.getUserData2();
            }
            case 24: {
                return pSDEDSGrpParamBase.getUserTag();
            }
            case 25: {
                return pSDEDSGrpParamBase.getUserTag2();
            }
            case 26: {
                return pSDEDSGrpParamBase.getUserTag3();
            }
            case 27: {
                return pSDEDSGrpParamBase.getUserTag4();
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
        PSDEDSGrpParamBase.set(this, n, object);
    }

    private static void set(PSDEDSGrpParamBase pSDEDSGrpParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDSGrpParamBase.setAggMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDSGrpParamBase.setAliasName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDSGrpParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEDSGrpParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDSGrpParamBase.setCustomDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDSGrpParamBase.setGroupCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDSGrpParamBase.setGroupFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEDSGrpParamBase.setGroupJoinCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDSGrpParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDSGrpParamBase.setOrderDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDSGrpParamBase.setPSDEDSGrpParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDSGrpParamBase.setPSDEDSGrpParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDSGrpParamBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDSGrpParamBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDSGrpParamBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDSGrpParamBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDSGrpParamBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDSGrpParamBase.setSortOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEDSGrpParamBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEDSGrpParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDEDSGrpParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDSGrpParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDSGrpParamBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDSGrpParamBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDSGrpParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDSGrpParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDSGrpParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDSGrpParamBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEDSGrpParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDSGrpParamBase pSDEDSGrpParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSGrpParamBase.getAggMode() == null;
            }
            case 1: {
                return pSDEDSGrpParamBase.getAliasName() == null;
            }
            case 2: {
                return pSDEDSGrpParamBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEDSGrpParamBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEDSGrpParamBase.getCustomDEFName() == null;
            }
            case 5: {
                return pSDEDSGrpParamBase.getGroupCode() == null;
            }
            case 6: {
                return pSDEDSGrpParamBase.getGroupFlag() == null;
            }
            case 7: {
                return pSDEDSGrpParamBase.getGroupJoinCode() == null;
            }
            case 8: {
                return pSDEDSGrpParamBase.getMemo() == null;
            }
            case 9: {
                return pSDEDSGrpParamBase.getOrderDir() == null;
            }
            case 10: {
                return pSDEDSGrpParamBase.getPSDEDSGrpParamId() == null;
            }
            case 11: {
                return pSDEDSGrpParamBase.getPSDEDSGrpParamName() == null;
            }
            case 12: {
                return pSDEDSGrpParamBase.getPSDEDSId() == null;
            }
            case 13: {
                return pSDEDSGrpParamBase.getPSDEDSName() == null;
            }
            case 14: {
                return pSDEDSGrpParamBase.getPSDEFId() == null;
            }
            case 15: {
                return pSDEDSGrpParamBase.getPSDEFName() == null;
            }
            case 16: {
                return pSDEDSGrpParamBase.getPSDEId() == null;
            }
            case 17: {
                return pSDEDSGrpParamBase.getSortOrderValue() == null;
            }
            case 18: {
                return pSDEDSGrpParamBase.getStdDataType() == null;
            }
            case 19: {
                return pSDEDSGrpParamBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDEDSGrpParamBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDEDSGrpParamBase.getUserCat() == null;
            }
            case 22: {
                return pSDEDSGrpParamBase.getUserData() == null;
            }
            case 23: {
                return pSDEDSGrpParamBase.getUserData2() == null;
            }
            case 24: {
                return pSDEDSGrpParamBase.getUserTag() == null;
            }
            case 25: {
                return pSDEDSGrpParamBase.getUserTag2() == null;
            }
            case 26: {
                return pSDEDSGrpParamBase.getUserTag3() == null;
            }
            case 27: {
                return pSDEDSGrpParamBase.getUserTag4() == null;
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
        return PSDEDSGrpParamBase.contains(this, n);
    }

    private static boolean contains(PSDEDSGrpParamBase pSDEDSGrpParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSGrpParamBase.isAggModeDirty();
            }
            case 1: {
                return pSDEDSGrpParamBase.isAliasNameDirty();
            }
            case 2: {
                return pSDEDSGrpParamBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEDSGrpParamBase.isCreateManDirty();
            }
            case 4: {
                return pSDEDSGrpParamBase.isCustomDEFNameDirty();
            }
            case 5: {
                return pSDEDSGrpParamBase.isGroupCodeDirty();
            }
            case 6: {
                return pSDEDSGrpParamBase.isGroupFlagDirty();
            }
            case 7: {
                return pSDEDSGrpParamBase.isGroupJoinCodeDirty();
            }
            case 8: {
                return pSDEDSGrpParamBase.isMemoDirty();
            }
            case 9: {
                return pSDEDSGrpParamBase.isOrderDirDirty();
            }
            case 10: {
                return pSDEDSGrpParamBase.isPSDEDSGrpParamIdDirty();
            }
            case 11: {
                return pSDEDSGrpParamBase.isPSDEDSGrpParamNameDirty();
            }
            case 12: {
                return pSDEDSGrpParamBase.isPSDEDSIdDirty();
            }
            case 13: {
                return pSDEDSGrpParamBase.isPSDEDSNameDirty();
            }
            case 14: {
                return pSDEDSGrpParamBase.isPSDEFIdDirty();
            }
            case 15: {
                return pSDEDSGrpParamBase.isPSDEFNameDirty();
            }
            case 16: {
                return pSDEDSGrpParamBase.isPSDEIdDirty();
            }
            case 17: {
                return pSDEDSGrpParamBase.isSortOrderValueDirty();
            }
            case 18: {
                return pSDEDSGrpParamBase.isStdDataTypeDirty();
            }
            case 19: {
                return pSDEDSGrpParamBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDEDSGrpParamBase.isUpdateManDirty();
            }
            case 21: {
                return pSDEDSGrpParamBase.isUserCatDirty();
            }
            case 22: {
                return pSDEDSGrpParamBase.isUserDataDirty();
            }
            case 23: {
                return pSDEDSGrpParamBase.isUserData2Dirty();
            }
            case 24: {
                return pSDEDSGrpParamBase.isUserTagDirty();
            }
            case 25: {
                return pSDEDSGrpParamBase.isUserTag2Dirty();
            }
            case 26: {
                return pSDEDSGrpParamBase.isUserTag3Dirty();
            }
            case 27: {
                return pSDEDSGrpParamBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDSGrpParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDSGrpParamBase pSDEDSGrpParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDSGrpParamBase.getAggMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggmode", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getAggMode()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getAliasName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aliasname", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getAliasName()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getCustomDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customdefname", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getCustomDEFName()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getGroupCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupcode", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getGroupCode()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getGroupFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupflag", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getGroupFlag()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getGroupJoinCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupjoincode", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getGroupJoinCode()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getOrderDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orderdir", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getOrderDir()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEDSGrpParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsgrpparamid", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getPSDEDSGrpParamId()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEDSGrpParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsgrpparamname", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getPSDEDSGrpParamName()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getSortOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sortordervalue", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getSortOrderValue()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUserData()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUserData2()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDSGrpParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDSGrpParamBase.getJSONValue((Object)pSDEDSGrpParamBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDSGrpParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDSGrpParamBase pSDEDSGrpParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDSGrpParamBase.getAggMode() != null) {
            object = pSDEDSGrpParamBase.getAggMode();
            xmlNode.setAttribute(FIELD_AGGMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDSGrpParamBase.getAliasName() != null) {
            object = pSDEDSGrpParamBase.getAliasName();
            xmlNode.setAttribute(FIELD_ALIASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getCreateDate() != null) {
            object = pSDEDSGrpParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDSGrpParamBase.getCreateMan() != null) {
            object = pSDEDSGrpParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getCustomDEFName() != null) {
            object = pSDEDSGrpParamBase.getCustomDEFName();
            xmlNode.setAttribute(FIELD_CUSTOMDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getGroupCode() != null) {
            object = pSDEDSGrpParamBase.getGroupCode();
            xmlNode.setAttribute(FIELD_GROUPCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getGroupFlag() != null) {
            object = pSDEDSGrpParamBase.getGroupFlag();
            xmlNode.setAttribute(FIELD_GROUPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSGrpParamBase.getGroupJoinCode() != null) {
            object = pSDEDSGrpParamBase.getGroupJoinCode();
            xmlNode.setAttribute(FIELD_GROUPJOINCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getMemo() != null) {
            object = pSDEDSGrpParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getOrderDir() != null) {
            object = pSDEDSGrpParamBase.getOrderDir();
            xmlNode.setAttribute(FIELD_ORDERDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEDSGrpParamId() != null) {
            object = pSDEDSGrpParamBase.getPSDEDSGrpParamId();
            xmlNode.setAttribute(FIELD_PSDEDSGRPPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEDSGrpParamName() != null) {
            object = pSDEDSGrpParamBase.getPSDEDSGrpParamName();
            xmlNode.setAttribute(FIELD_PSDEDSGRPPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEDSId() != null) {
            object = pSDEDSGrpParamBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEDSName() != null) {
            object = pSDEDSGrpParamBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEFId() != null) {
            object = pSDEDSGrpParamBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEFName() != null) {
            object = pSDEDSGrpParamBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getPSDEId() != null) {
            object = pSDEDSGrpParamBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getSortOrderValue() != null) {
            object = pSDEDSGrpParamBase.getSortOrderValue();
            xmlNode.setAttribute(FIELD_SORTORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSGrpParamBase.getStdDataType() != null) {
            object = pSDEDSGrpParamBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSGrpParamBase.getUpdateDate() != null) {
            object = pSDEDSGrpParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDSGrpParamBase.getUpdateMan() != null) {
            object = pSDEDSGrpParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getUserCat() != null) {
            object = pSDEDSGrpParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getUserData() != null) {
            object = pSDEDSGrpParamBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getUserData2() != null) {
            object = pSDEDSGrpParamBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getUserTag() != null) {
            object = pSDEDSGrpParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getUserTag2() != null) {
            object = pSDEDSGrpParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getUserTag3() != null) {
            object = pSDEDSGrpParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSGrpParamBase.getUserTag4() != null) {
            object = pSDEDSGrpParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDSGrpParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDSGrpParamBase pSDEDSGrpParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDSGrpParamBase.isAggModeDirty() && (bl || pSDEDSGrpParamBase.getAggMode() != null)) {
            iDataObject.set(FIELD_AGGMODE, (Object)pSDEDSGrpParamBase.getAggMode());
        }
        if (pSDEDSGrpParamBase.isAliasNameDirty() && (bl || pSDEDSGrpParamBase.getAliasName() != null)) {
            iDataObject.set(FIELD_ALIASNAME, (Object)pSDEDSGrpParamBase.getAliasName());
        }
        if (pSDEDSGrpParamBase.isCreateDateDirty() && (bl || pSDEDSGrpParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDSGrpParamBase.getCreateDate());
        }
        if (pSDEDSGrpParamBase.isCreateManDirty() && (bl || pSDEDSGrpParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDSGrpParamBase.getCreateMan());
        }
        if (pSDEDSGrpParamBase.isCustomDEFNameDirty() && (bl || pSDEDSGrpParamBase.getCustomDEFName() != null)) {
            iDataObject.set(FIELD_CUSTOMDEFNAME, (Object)pSDEDSGrpParamBase.getCustomDEFName());
        }
        if (pSDEDSGrpParamBase.isGroupCodeDirty() && (bl || pSDEDSGrpParamBase.getGroupCode() != null)) {
            iDataObject.set(FIELD_GROUPCODE, (Object)pSDEDSGrpParamBase.getGroupCode());
        }
        if (pSDEDSGrpParamBase.isGroupFlagDirty() && (bl || pSDEDSGrpParamBase.getGroupFlag() != null)) {
            iDataObject.set(FIELD_GROUPFLAG, (Object)pSDEDSGrpParamBase.getGroupFlag());
        }
        if (pSDEDSGrpParamBase.isGroupJoinCodeDirty() && (bl || pSDEDSGrpParamBase.getGroupJoinCode() != null)) {
            iDataObject.set(FIELD_GROUPJOINCODE, (Object)pSDEDSGrpParamBase.getGroupJoinCode());
        }
        if (pSDEDSGrpParamBase.isMemoDirty() && (bl || pSDEDSGrpParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDSGrpParamBase.getMemo());
        }
        if (pSDEDSGrpParamBase.isOrderDirDirty() && (bl || pSDEDSGrpParamBase.getOrderDir() != null)) {
            iDataObject.set(FIELD_ORDERDIR, (Object)pSDEDSGrpParamBase.getOrderDir());
        }
        if (pSDEDSGrpParamBase.isPSDEDSGrpParamIdDirty() && (bl || pSDEDSGrpParamBase.getPSDEDSGrpParamId() != null)) {
            iDataObject.set(FIELD_PSDEDSGRPPARAMID, (Object)pSDEDSGrpParamBase.getPSDEDSGrpParamId());
        }
        if (pSDEDSGrpParamBase.isPSDEDSGrpParamNameDirty() && (bl || pSDEDSGrpParamBase.getPSDEDSGrpParamName() != null)) {
            iDataObject.set(FIELD_PSDEDSGRPPARAMNAME, (Object)pSDEDSGrpParamBase.getPSDEDSGrpParamName());
        }
        if (pSDEDSGrpParamBase.isPSDEDSIdDirty() && (bl || pSDEDSGrpParamBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDEDSGrpParamBase.getPSDEDSId());
        }
        if (pSDEDSGrpParamBase.isPSDEDSNameDirty() && (bl || pSDEDSGrpParamBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDEDSGrpParamBase.getPSDEDSName());
        }
        if (pSDEDSGrpParamBase.isPSDEFIdDirty() && (bl || pSDEDSGrpParamBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEDSGrpParamBase.getPSDEFId());
        }
        if (pSDEDSGrpParamBase.isPSDEFNameDirty() && (bl || pSDEDSGrpParamBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEDSGrpParamBase.getPSDEFName());
        }
        if (pSDEDSGrpParamBase.isPSDEIdDirty() && (bl || pSDEDSGrpParamBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDSGrpParamBase.getPSDEId());
        }
        if (pSDEDSGrpParamBase.isSortOrderValueDirty() && (bl || pSDEDSGrpParamBase.getSortOrderValue() != null)) {
            iDataObject.set(FIELD_SORTORDERVALUE, (Object)pSDEDSGrpParamBase.getSortOrderValue());
        }
        if (pSDEDSGrpParamBase.isStdDataTypeDirty() && (bl || pSDEDSGrpParamBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSDEDSGrpParamBase.getStdDataType());
        }
        if (pSDEDSGrpParamBase.isUpdateDateDirty() && (bl || pSDEDSGrpParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDSGrpParamBase.getUpdateDate());
        }
        if (pSDEDSGrpParamBase.isUpdateManDirty() && (bl || pSDEDSGrpParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDSGrpParamBase.getUpdateMan());
        }
        if (pSDEDSGrpParamBase.isUserCatDirty() && (bl || pSDEDSGrpParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDSGrpParamBase.getUserCat());
        }
        if (pSDEDSGrpParamBase.isUserDataDirty() && (bl || pSDEDSGrpParamBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSDEDSGrpParamBase.getUserData());
        }
        if (pSDEDSGrpParamBase.isUserData2Dirty() && (bl || pSDEDSGrpParamBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSDEDSGrpParamBase.getUserData2());
        }
        if (pSDEDSGrpParamBase.isUserTagDirty() && (bl || pSDEDSGrpParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDSGrpParamBase.getUserTag());
        }
        if (pSDEDSGrpParamBase.isUserTag2Dirty() && (bl || pSDEDSGrpParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDSGrpParamBase.getUserTag2());
        }
        if (pSDEDSGrpParamBase.isUserTag3Dirty() && (bl || pSDEDSGrpParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDSGrpParamBase.getUserTag3());
        }
        if (pSDEDSGrpParamBase.isUserTag4Dirty() && (bl || pSDEDSGrpParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDSGrpParamBase.getUserTag4());
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
        return PSDEDSGrpParamBase.remove(this, n);
    }

    private static boolean remove(PSDEDSGrpParamBase pSDEDSGrpParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDSGrpParamBase.resetAggMode();
                return true;
            }
            case 1: {
                pSDEDSGrpParamBase.resetAliasName();
                return true;
            }
            case 2: {
                pSDEDSGrpParamBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEDSGrpParamBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEDSGrpParamBase.resetCustomDEFName();
                return true;
            }
            case 5: {
                pSDEDSGrpParamBase.resetGroupCode();
                return true;
            }
            case 6: {
                pSDEDSGrpParamBase.resetGroupFlag();
                return true;
            }
            case 7: {
                pSDEDSGrpParamBase.resetGroupJoinCode();
                return true;
            }
            case 8: {
                pSDEDSGrpParamBase.resetMemo();
                return true;
            }
            case 9: {
                pSDEDSGrpParamBase.resetOrderDir();
                return true;
            }
            case 10: {
                pSDEDSGrpParamBase.resetPSDEDSGrpParamId();
                return true;
            }
            case 11: {
                pSDEDSGrpParamBase.resetPSDEDSGrpParamName();
                return true;
            }
            case 12: {
                pSDEDSGrpParamBase.resetPSDEDSId();
                return true;
            }
            case 13: {
                pSDEDSGrpParamBase.resetPSDEDSName();
                return true;
            }
            case 14: {
                pSDEDSGrpParamBase.resetPSDEFId();
                return true;
            }
            case 15: {
                pSDEDSGrpParamBase.resetPSDEFName();
                return true;
            }
            case 16: {
                pSDEDSGrpParamBase.resetPSDEId();
                return true;
            }
            case 17: {
                pSDEDSGrpParamBase.resetSortOrderValue();
                return true;
            }
            case 18: {
                pSDEDSGrpParamBase.resetStdDataType();
                return true;
            }
            case 19: {
                pSDEDSGrpParamBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDEDSGrpParamBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDEDSGrpParamBase.resetUserCat();
                return true;
            }
            case 22: {
                pSDEDSGrpParamBase.resetUserData();
                return true;
            }
            case 23: {
                pSDEDSGrpParamBase.resetUserData2();
                return true;
            }
            case 24: {
                pSDEDSGrpParamBase.resetUserTag();
                return true;
            }
            case 25: {
                pSDEDSGrpParamBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSDEDSGrpParamBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSDEDSGrpParamBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    private PSDEDSGrpParamBase getProxyEntity() {
        return this.proxyPSDEDSGrpParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDSGrpParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDSGrpParamBase) {
            this.proxyPSDEDSGrpParamBase = (PSDEDSGrpParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDSGrpParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGGMODE, 0);
        fieldIndexMap.put(FIELD_ALIASNAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMDEFNAME, 4);
        fieldIndexMap.put(FIELD_GROUPCODE, 5);
        fieldIndexMap.put(FIELD_GROUPFLAG, 6);
        fieldIndexMap.put(FIELD_GROUPJOINCODE, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERDIR, 9);
        fieldIndexMap.put(FIELD_PSDEDSGRPPARAMID, 10);
        fieldIndexMap.put(FIELD_PSDEDSGRPPARAMNAME, 11);
        fieldIndexMap.put(FIELD_PSDEDSID, 12);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 13);
        fieldIndexMap.put(FIELD_PSDEFID, 14);
        fieldIndexMap.put(FIELD_PSDEFNAME, 15);
        fieldIndexMap.put(FIELD_PSDEID, 16);
        fieldIndexMap.put(FIELD_SORTORDERVALUE, 17);
        fieldIndexMap.put(FIELD_STDDATATYPE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERDATA, 22);
        fieldIndexMap.put(FIELD_USERDATA2, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
    }
}

