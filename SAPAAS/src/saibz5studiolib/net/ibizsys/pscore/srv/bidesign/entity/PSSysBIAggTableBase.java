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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggColumn;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIAggTableBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBIAggTableBase.class);
    public static final String FIELD_BIAGGTABLEMODE = "BIAGGTABLEMODE";
    public static final String FIELD_BIAGGTABLEOPTION = "BIAGGTABLEOPTION";
    public static final String FIELD_BIAGGTABLEPARAMS = "BIAGGTABLEPARAMS";
    public static final String FIELD_BIAGGTABLETAG = "BIAGGTABLETAG";
    public static final String FIELD_BIAGGTABLETAG2 = "BIAGGTABLETAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDATAQUERYID = "PSDEDATAQUERYID";
    public static final String FIELD_PSDEDATAQUERYNAME = "PSDEDATAQUERYNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSBIAGGTABLEID = "PSSYSBIAGGTABLEID";
    public static final String FIELD_PSSYSBIAGGTABLENAME = "PSSYSBIAGGTABLENAME";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String FIELD_REALTIMEMODE = "REALTIMEMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BIAGGTABLEMODE = 0;
    private static final int INDEX_BIAGGTABLEOPTION = 1;
    private static final int INDEX_BIAGGTABLEPARAMS = 2;
    private static final int INDEX_BIAGGTABLETAG = 3;
    private static final int INDEX_BIAGGTABLETAG2 = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSDEDATAQUERYID = 9;
    private static final int INDEX_PSDEDATAQUERYNAME = 10;
    private static final int INDEX_PSDEDATASETID = 11;
    private static final int INDEX_PSDEDATASETNAME = 12;
    private static final int INDEX_PSDEID = 13;
    private static final int INDEX_PSDENAME = 14;
    private static final int INDEX_PSSYSBIAGGTABLEID = 15;
    private static final int INDEX_PSSYSBIAGGTABLENAME = 16;
    private static final int INDEX_PSSYSBICUBEID = 17;
    private static final int INDEX_PSSYSBICUBENAME = 18;
    private static final int INDEX_PSSYSBISCHEMEID = 19;
    private static final int INDEX_PSSYSBISCHEMENAME = 20;
    private static final int INDEX_REALTIMEMODE = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USERCAT = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_USERTAG3 = 27;
    private static final int INDEX_USERTAG4 = 28;
    private static final int INDEX_VALIDFLAG = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBIAggTableBase proxyPSSysBIAggTableBase = null;
    private boolean biaggtablemodeDirtyFlag = false;
    private boolean biaggtableoptionDirtyFlag = false;
    private boolean biaggtableparamsDirtyFlag = false;
    private boolean biaggtabletagDirtyFlag = false;
    private boolean biaggtabletag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedataqueryidDirtyFlag = false;
    private boolean psdedataquerynameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysbiaggtableidDirtyFlag = false;
    private boolean pssysbiaggtablenameDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubenameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssysbischemenameDirtyFlag = false;
    private boolean realtimemodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="biaggtablemode")
    private String biaggtablemode;
    @Column(name="biaggtableoption")
    private Integer biaggtableoption;
    @Column(name="biaggtableparams")
    private String biaggtableparams;
    @Column(name="biaggtabletag")
    private String biaggtabletag;
    @Column(name="biaggtabletag2")
    private String biaggtabletag2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedataqueryid")
    private String psdedataqueryid;
    @Column(name="psdedataqueryname")
    private String psdedataqueryname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysbiaggtableid")
    private String pssysbiaggtableid;
    @Column(name="pssysbiaggtablename")
    private String pssysbiaggtablename;
    @Column(name="pssysbicubeid")
    private String pssysbicubeid;
    @Column(name="pssysbicubename")
    private String pssysbicubename;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssysbischemename")
    private String pssysbischemename;
    @Column(name="realtimemode")
    private Integer realtimemode;
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
    private Integer objPSDEDataQueryLock = new Integer(1);
    private PSDEDataQuery psdedataquery = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objPSSysBICubeLock = new Integer(1);
    private PSSysBICube pssysbicube = null;
    private Integer objPSSysBISchemeLock = new Integer(1);
    private PSSysBIScheme pssysbischeme = null;
    private Integer objPSSysBIAggColumnsLock = new Integer(1);
    private ArrayList<PSSysBIAggColumn> pssysbiaggcolumns = null;

    public void setBIAggTableMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIAggTableMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biaggtablemode = string;
        this.biaggtablemodeDirtyFlag = true;
    }

    public String getBIAggTableMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIAggTableMode();
        }
        return this.biaggtablemode;
    }

    public boolean isBIAggTableModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIAggTableModeDirty();
        }
        return this.biaggtablemodeDirtyFlag;
    }

    public void resetBIAggTableMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIAggTableMode();
            return;
        }
        this.biaggtablemodeDirtyFlag = false;
        this.biaggtablemode = null;
    }

    public void setBIAggTableOption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIAggTableOption(n);
            return;
        }
        this.biaggtableoption = n;
        this.biaggtableoptionDirtyFlag = true;
    }

    public Integer getBIAggTableOption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIAggTableOption();
        }
        return this.biaggtableoption;
    }

    public boolean isBIAggTableOptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIAggTableOptionDirty();
        }
        return this.biaggtableoptionDirtyFlag;
    }

    public void resetBIAggTableOption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIAggTableOption();
            return;
        }
        this.biaggtableoptionDirtyFlag = false;
        this.biaggtableoption = null;
    }

    public void setBIAggTableParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIAggTableParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biaggtableparams = string;
        this.biaggtableparamsDirtyFlag = true;
    }

    public String getBIAggTableParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIAggTableParams();
        }
        return this.biaggtableparams;
    }

    public boolean isBIAggTableParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIAggTableParamsDirty();
        }
        return this.biaggtableparamsDirtyFlag;
    }

    public void resetBIAggTableParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIAggTableParams();
            return;
        }
        this.biaggtableparamsDirtyFlag = false;
        this.biaggtableparams = null;
    }

    public void setBIAggTableTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIAggTableTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biaggtabletag = string;
        this.biaggtabletagDirtyFlag = true;
    }

    public String getBIAggTableTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIAggTableTag();
        }
        return this.biaggtabletag;
    }

    public boolean isBIAggTableTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIAggTableTagDirty();
        }
        return this.biaggtabletagDirtyFlag;
    }

    public void resetBIAggTableTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIAggTableTag();
            return;
        }
        this.biaggtabletagDirtyFlag = false;
        this.biaggtabletag = null;
    }

    public void setBIAggTableTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIAggTableTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biaggtabletag2 = string;
        this.biaggtabletag2DirtyFlag = true;
    }

    public String getBIAggTableTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIAggTableTag2();
        }
        return this.biaggtabletag2;
    }

    public boolean isBIAggTableTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIAggTableTag2Dirty();
        }
        return this.biaggtabletag2DirtyFlag;
    }

    public void resetBIAggTableTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIAggTableTag2();
            return;
        }
        this.biaggtabletag2DirtyFlag = false;
        this.biaggtabletag2 = null;
    }

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

    public void setPSDEDataQueryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQueryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataqueryid = string;
        this.psdedataqueryidDirtyFlag = true;
    }

    public String getPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueryId();
        }
        return this.psdedataqueryid;
    }

    public boolean isPSDEDataQueryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQueryIdDirty();
        }
        return this.psdedataqueryidDirtyFlag;
    }

    public void resetPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQueryId();
            return;
        }
        this.psdedataqueryidDirtyFlag = false;
        this.psdedataqueryid = null;
    }

    public void setPSDEDataQueryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQueryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataqueryname = string;
        this.psdedataquerynameDirtyFlag = true;
    }

    public String getPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueryName();
        }
        return this.psdedataqueryname;
    }

    public boolean isPSDEDataQueryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQueryNameDirty();
        }
        return this.psdedataquerynameDirtyFlag;
    }

    public void resetPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQueryName();
            return;
        }
        this.psdedataquerynameDirtyFlag = false;
        this.psdedataqueryname = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
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

    public void setPSSysBIAggTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIAggTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbiaggtableid = string;
        this.pssysbiaggtableidDirtyFlag = true;
    }

    public String getPSSysBIAggTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTableId();
        }
        return this.pssysbiaggtableid;
    }

    public boolean isPSSysBIAggTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIAggTableIdDirty();
        }
        return this.pssysbiaggtableidDirtyFlag;
    }

    public void resetPSSysBIAggTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIAggTableId();
            return;
        }
        this.pssysbiaggtableidDirtyFlag = false;
        this.pssysbiaggtableid = null;
    }

    public void setPSSysBIAggTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIAggTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbiaggtablename = string;
        this.pssysbiaggtablenameDirtyFlag = true;
    }

    public String getPSSysBIAggTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTableName();
        }
        return this.pssysbiaggtablename;
    }

    public boolean isPSSysBIAggTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIAggTableNameDirty();
        }
        return this.pssysbiaggtablenameDirtyFlag;
    }

    public void resetPSSysBIAggTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIAggTableName();
            return;
        }
        this.pssysbiaggtablenameDirtyFlag = false;
        this.pssysbiaggtablename = null;
    }

    public void setPSSysBICubeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubeid = string;
        this.pssysbicubeidDirtyFlag = true;
    }

    public String getPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeId();
        }
        return this.pssysbicubeid;
    }

    public boolean isPSSysBICubeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeIdDirty();
        }
        return this.pssysbicubeidDirtyFlag;
    }

    public void resetPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeId();
            return;
        }
        this.pssysbicubeidDirtyFlag = false;
        this.pssysbicubeid = null;
    }

    public void setPSSysBICubeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubename = string;
        this.pssysbicubenameDirtyFlag = true;
    }

    public String getPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeName();
        }
        return this.pssysbicubename;
    }

    public boolean isPSSysBICubeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeNameDirty();
        }
        return this.pssysbicubenameDirtyFlag;
    }

    public void resetPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeName();
            return;
        }
        this.pssysbicubenameDirtyFlag = false;
        this.pssysbicubename = null;
    }

    public void setPSSysBISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemeid = string;
        this.pssysbischemeidDirtyFlag = true;
    }

    public String getPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeId();
        }
        return this.pssysbischemeid;
    }

    public boolean isPSSysBISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeIdDirty();
        }
        return this.pssysbischemeidDirtyFlag;
    }

    public void resetPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeId();
            return;
        }
        this.pssysbischemeidDirtyFlag = false;
        this.pssysbischemeid = null;
    }

    public void setPSSysBISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemename = string;
        this.pssysbischemenameDirtyFlag = true;
    }

    public String getPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeName();
        }
        return this.pssysbischemename;
    }

    public boolean isPSSysBISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeNameDirty();
        }
        return this.pssysbischemenameDirtyFlag;
    }

    public void resetPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeName();
            return;
        }
        this.pssysbischemenameDirtyFlag = false;
        this.pssysbischemename = null;
    }

    public void setRealTimeMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRealTimeMode(n);
            return;
        }
        this.realtimemode = n;
        this.realtimemodeDirtyFlag = true;
    }

    public Integer getRealTimeMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRealTimeMode();
        }
        return this.realtimemode;
    }

    public boolean isRealTimeModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRealTimeModeDirty();
        }
        return this.realtimemodeDirtyFlag;
    }

    public void resetRealTimeMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRealTimeMode();
            return;
        }
        this.realtimemodeDirtyFlag = false;
        this.realtimemode = null;
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
        PSSysBIAggTableBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBIAggTableBase pSSysBIAggTableBase) {
        pSSysBIAggTableBase.resetBIAggTableMode();
        pSSysBIAggTableBase.resetBIAggTableOption();
        pSSysBIAggTableBase.resetBIAggTableParams();
        pSSysBIAggTableBase.resetBIAggTableTag();
        pSSysBIAggTableBase.resetBIAggTableTag2();
        pSSysBIAggTableBase.resetCodeName();
        pSSysBIAggTableBase.resetCreateDate();
        pSSysBIAggTableBase.resetCreateMan();
        pSSysBIAggTableBase.resetMemo();
        pSSysBIAggTableBase.resetPSDEDataQueryId();
        pSSysBIAggTableBase.resetPSDEDataQueryName();
        pSSysBIAggTableBase.resetPSDEDataSetId();
        pSSysBIAggTableBase.resetPSDEDataSetName();
        pSSysBIAggTableBase.resetPSDEId();
        pSSysBIAggTableBase.resetPSDEName();
        pSSysBIAggTableBase.resetPSSysBIAggTableId();
        pSSysBIAggTableBase.resetPSSysBIAggTableName();
        pSSysBIAggTableBase.resetPSSysBICubeId();
        pSSysBIAggTableBase.resetPSSysBICubeName();
        pSSysBIAggTableBase.resetPSSysBISchemeId();
        pSSysBIAggTableBase.resetPSSysBISchemeName();
        pSSysBIAggTableBase.resetRealTimeMode();
        pSSysBIAggTableBase.resetUpdateDate();
        pSSysBIAggTableBase.resetUpdateMan();
        pSSysBIAggTableBase.resetUserCat();
        pSSysBIAggTableBase.resetUserTag();
        pSSysBIAggTableBase.resetUserTag2();
        pSSysBIAggTableBase.resetUserTag3();
        pSSysBIAggTableBase.resetUserTag4();
        pSSysBIAggTableBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBIAggTableModeDirty()) {
            hashMap.put(FIELD_BIAGGTABLEMODE, this.getBIAggTableMode());
        }
        if (!bl || this.isBIAggTableOptionDirty()) {
            hashMap.put(FIELD_BIAGGTABLEOPTION, this.getBIAggTableOption());
        }
        if (!bl || this.isBIAggTableParamsDirty()) {
            hashMap.put(FIELD_BIAGGTABLEPARAMS, this.getBIAggTableParams());
        }
        if (!bl || this.isBIAggTableTagDirty()) {
            hashMap.put(FIELD_BIAGGTABLETAG, this.getBIAggTableTag());
        }
        if (!bl || this.isBIAggTableTag2Dirty()) {
            hashMap.put(FIELD_BIAGGTABLETAG2, this.getBIAggTableTag2());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEDataQueryIdDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYID, this.getPSDEDataQueryId());
        }
        if (!bl || this.isPSDEDataQueryNameDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYNAME, this.getPSDEDataQueryName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysBIAggTableIdDirty()) {
            hashMap.put(FIELD_PSSYSBIAGGTABLEID, this.getPSSysBIAggTableId());
        }
        if (!bl || this.isPSSysBIAggTableNameDirty()) {
            hashMap.put(FIELD_PSSYSBIAGGTABLENAME, this.getPSSysBIAggTableName());
        }
        if (!bl || this.isPSSysBICubeIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEID, this.getPSSysBICubeId());
        }
        if (!bl || this.isPSSysBICubeNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBENAME, this.getPSSysBICubeName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysBISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMENAME, this.getPSSysBISchemeName());
        }
        if (!bl || this.isRealTimeModeDirty()) {
            hashMap.put(FIELD_REALTIMEMODE, this.getRealTimeMode());
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
        return PSSysBIAggTableBase.get(this, n);
    }

    private static Object get(PSSysBIAggTableBase pSSysBIAggTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIAggTableBase.getBIAggTableMode();
            }
            case 1: {
                return pSSysBIAggTableBase.getBIAggTableOption();
            }
            case 2: {
                return pSSysBIAggTableBase.getBIAggTableParams();
            }
            case 3: {
                return pSSysBIAggTableBase.getBIAggTableTag();
            }
            case 4: {
                return pSSysBIAggTableBase.getBIAggTableTag2();
            }
            case 5: {
                return pSSysBIAggTableBase.getCodeName();
            }
            case 6: {
                return pSSysBIAggTableBase.getCreateDate();
            }
            case 7: {
                return pSSysBIAggTableBase.getCreateMan();
            }
            case 8: {
                return pSSysBIAggTableBase.getMemo();
            }
            case 9: {
                return pSSysBIAggTableBase.getPSDEDataQueryId();
            }
            case 10: {
                return pSSysBIAggTableBase.getPSDEDataQueryName();
            }
            case 11: {
                return pSSysBIAggTableBase.getPSDEDataSetId();
            }
            case 12: {
                return pSSysBIAggTableBase.getPSDEDataSetName();
            }
            case 13: {
                return pSSysBIAggTableBase.getPSDEId();
            }
            case 14: {
                return pSSysBIAggTableBase.getPSDEName();
            }
            case 15: {
                return pSSysBIAggTableBase.getPSSysBIAggTableId();
            }
            case 16: {
                return pSSysBIAggTableBase.getPSSysBIAggTableName();
            }
            case 17: {
                return pSSysBIAggTableBase.getPSSysBICubeId();
            }
            case 18: {
                return pSSysBIAggTableBase.getPSSysBICubeName();
            }
            case 19: {
                return pSSysBIAggTableBase.getPSSysBISchemeId();
            }
            case 20: {
                return pSSysBIAggTableBase.getPSSysBISchemeName();
            }
            case 21: {
                return pSSysBIAggTableBase.getRealTimeMode();
            }
            case 22: {
                return pSSysBIAggTableBase.getUpdateDate();
            }
            case 23: {
                return pSSysBIAggTableBase.getUpdateMan();
            }
            case 24: {
                return pSSysBIAggTableBase.getUserCat();
            }
            case 25: {
                return pSSysBIAggTableBase.getUserTag();
            }
            case 26: {
                return pSSysBIAggTableBase.getUserTag2();
            }
            case 27: {
                return pSSysBIAggTableBase.getUserTag3();
            }
            case 28: {
                return pSSysBIAggTableBase.getUserTag4();
            }
            case 29: {
                return pSSysBIAggTableBase.getValidFlag();
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
        PSSysBIAggTableBase.set(this, n, object);
    }

    private static void set(PSSysBIAggTableBase pSSysBIAggTableBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIAggTableBase.setBIAggTableMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBIAggTableBase.setBIAggTableOption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSysBIAggTableBase.setBIAggTableParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBIAggTableBase.setBIAggTableTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBIAggTableBase.setBIAggTableTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBIAggTableBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBIAggTableBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysBIAggTableBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBIAggTableBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBIAggTableBase.setPSDEDataQueryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBIAggTableBase.setPSDEDataQueryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBIAggTableBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBIAggTableBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBIAggTableBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBIAggTableBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBIAggTableBase.setPSSysBIAggTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBIAggTableBase.setPSSysBIAggTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBIAggTableBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBIAggTableBase.setPSSysBICubeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBIAggTableBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBIAggTableBase.setPSSysBISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBIAggTableBase.setRealTimeMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysBIAggTableBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSSysBIAggTableBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBIAggTableBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBIAggTableBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBIAggTableBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBIAggTableBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBIAggTableBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBIAggTableBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBIAggTableBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBIAggTableBase pSSysBIAggTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIAggTableBase.getBIAggTableMode() == null;
            }
            case 1: {
                return pSSysBIAggTableBase.getBIAggTableOption() == null;
            }
            case 2: {
                return pSSysBIAggTableBase.getBIAggTableParams() == null;
            }
            case 3: {
                return pSSysBIAggTableBase.getBIAggTableTag() == null;
            }
            case 4: {
                return pSSysBIAggTableBase.getBIAggTableTag2() == null;
            }
            case 5: {
                return pSSysBIAggTableBase.getCodeName() == null;
            }
            case 6: {
                return pSSysBIAggTableBase.getCreateDate() == null;
            }
            case 7: {
                return pSSysBIAggTableBase.getCreateMan() == null;
            }
            case 8: {
                return pSSysBIAggTableBase.getMemo() == null;
            }
            case 9: {
                return pSSysBIAggTableBase.getPSDEDataQueryId() == null;
            }
            case 10: {
                return pSSysBIAggTableBase.getPSDEDataQueryName() == null;
            }
            case 11: {
                return pSSysBIAggTableBase.getPSDEDataSetId() == null;
            }
            case 12: {
                return pSSysBIAggTableBase.getPSDEDataSetName() == null;
            }
            case 13: {
                return pSSysBIAggTableBase.getPSDEId() == null;
            }
            case 14: {
                return pSSysBIAggTableBase.getPSDEName() == null;
            }
            case 15: {
                return pSSysBIAggTableBase.getPSSysBIAggTableId() == null;
            }
            case 16: {
                return pSSysBIAggTableBase.getPSSysBIAggTableName() == null;
            }
            case 17: {
                return pSSysBIAggTableBase.getPSSysBICubeId() == null;
            }
            case 18: {
                return pSSysBIAggTableBase.getPSSysBICubeName() == null;
            }
            case 19: {
                return pSSysBIAggTableBase.getPSSysBISchemeId() == null;
            }
            case 20: {
                return pSSysBIAggTableBase.getPSSysBISchemeName() == null;
            }
            case 21: {
                return pSSysBIAggTableBase.getRealTimeMode() == null;
            }
            case 22: {
                return pSSysBIAggTableBase.getUpdateDate() == null;
            }
            case 23: {
                return pSSysBIAggTableBase.getUpdateMan() == null;
            }
            case 24: {
                return pSSysBIAggTableBase.getUserCat() == null;
            }
            case 25: {
                return pSSysBIAggTableBase.getUserTag() == null;
            }
            case 26: {
                return pSSysBIAggTableBase.getUserTag2() == null;
            }
            case 27: {
                return pSSysBIAggTableBase.getUserTag3() == null;
            }
            case 28: {
                return pSSysBIAggTableBase.getUserTag4() == null;
            }
            case 29: {
                return pSSysBIAggTableBase.getValidFlag() == null;
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
        return PSSysBIAggTableBase.contains(this, n);
    }

    private static boolean contains(PSSysBIAggTableBase pSSysBIAggTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIAggTableBase.isBIAggTableModeDirty();
            }
            case 1: {
                return pSSysBIAggTableBase.isBIAggTableOptionDirty();
            }
            case 2: {
                return pSSysBIAggTableBase.isBIAggTableParamsDirty();
            }
            case 3: {
                return pSSysBIAggTableBase.isBIAggTableTagDirty();
            }
            case 4: {
                return pSSysBIAggTableBase.isBIAggTableTag2Dirty();
            }
            case 5: {
                return pSSysBIAggTableBase.isCodeNameDirty();
            }
            case 6: {
                return pSSysBIAggTableBase.isCreateDateDirty();
            }
            case 7: {
                return pSSysBIAggTableBase.isCreateManDirty();
            }
            case 8: {
                return pSSysBIAggTableBase.isMemoDirty();
            }
            case 9: {
                return pSSysBIAggTableBase.isPSDEDataQueryIdDirty();
            }
            case 10: {
                return pSSysBIAggTableBase.isPSDEDataQueryNameDirty();
            }
            case 11: {
                return pSSysBIAggTableBase.isPSDEDataSetIdDirty();
            }
            case 12: {
                return pSSysBIAggTableBase.isPSDEDataSetNameDirty();
            }
            case 13: {
                return pSSysBIAggTableBase.isPSDEIdDirty();
            }
            case 14: {
                return pSSysBIAggTableBase.isPSDENameDirty();
            }
            case 15: {
                return pSSysBIAggTableBase.isPSSysBIAggTableIdDirty();
            }
            case 16: {
                return pSSysBIAggTableBase.isPSSysBIAggTableNameDirty();
            }
            case 17: {
                return pSSysBIAggTableBase.isPSSysBICubeIdDirty();
            }
            case 18: {
                return pSSysBIAggTableBase.isPSSysBICubeNameDirty();
            }
            case 19: {
                return pSSysBIAggTableBase.isPSSysBISchemeIdDirty();
            }
            case 20: {
                return pSSysBIAggTableBase.isPSSysBISchemeNameDirty();
            }
            case 21: {
                return pSSysBIAggTableBase.isRealTimeModeDirty();
            }
            case 22: {
                return pSSysBIAggTableBase.isUpdateDateDirty();
            }
            case 23: {
                return pSSysBIAggTableBase.isUpdateManDirty();
            }
            case 24: {
                return pSSysBIAggTableBase.isUserCatDirty();
            }
            case 25: {
                return pSSysBIAggTableBase.isUserTagDirty();
            }
            case 26: {
                return pSSysBIAggTableBase.isUserTag2Dirty();
            }
            case 27: {
                return pSSysBIAggTableBase.isUserTag3Dirty();
            }
            case 28: {
                return pSSysBIAggTableBase.isUserTag4Dirty();
            }
            case 29: {
                return pSSysBIAggTableBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBIAggTableBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBIAggTableBase pSSysBIAggTableBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBIAggTableBase.getBIAggTableMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biaggtablemode", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getBIAggTableMode()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getBIAggTableOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biaggtableoption", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getBIAggTableOption()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getBIAggTableParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biaggtableparams", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getBIAggTableParams()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getBIAggTableTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biaggtabletag", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getBIAggTableTag()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getBIAggTableTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biaggtabletag2", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getBIAggTableTag2()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSDEDataQueryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryid", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSDEDataQueryId()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSDEDataQueryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryname", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSDEDataQueryName()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBIAggTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbiaggtableid", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSSysBIAggTableId()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBIAggTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbiaggtablename", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSSysBIAggTableName()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBICubeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubename", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSSysBICubeName()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemename", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getPSSysBISchemeName()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getRealTimeMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"realtimemode", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getRealTimeMode()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBIAggTableBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBIAggTableBase.getJSONValue((Object)pSSysBIAggTableBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBIAggTableBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBIAggTableBase pSSysBIAggTableBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBIAggTableBase.getBIAggTableMode() != null) {
            object = pSSysBIAggTableBase.getBIAggTableMode();
            xmlNode.setAttribute(FIELD_BIAGGTABLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getBIAggTableOption() != null) {
            object = pSSysBIAggTableBase.getBIAggTableOption();
            xmlNode.setAttribute(FIELD_BIAGGTABLEOPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBIAggTableBase.getBIAggTableParams() != null) {
            object = pSSysBIAggTableBase.getBIAggTableParams();
            xmlNode.setAttribute(FIELD_BIAGGTABLEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getBIAggTableTag() != null) {
            object = pSSysBIAggTableBase.getBIAggTableTag();
            xmlNode.setAttribute(FIELD_BIAGGTABLETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getBIAggTableTag2() != null) {
            object = pSSysBIAggTableBase.getBIAggTableTag2();
            xmlNode.setAttribute(FIELD_BIAGGTABLETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getCodeName() != null) {
            object = pSSysBIAggTableBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getCreateDate() != null) {
            object = pSSysBIAggTableBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIAggTableBase.getCreateMan() != null) {
            object = pSSysBIAggTableBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getMemo() != null) {
            object = pSSysBIAggTableBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSDEDataQueryId() != null) {
            object = pSSysBIAggTableBase.getPSDEDataQueryId();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSDEDataQueryName() != null) {
            object = pSSysBIAggTableBase.getPSDEDataQueryName();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSDEDataSetId() != null) {
            object = pSSysBIAggTableBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSDEDataSetName() != null) {
            object = pSSysBIAggTableBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSDEId() != null) {
            object = pSSysBIAggTableBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSDEName() != null) {
            object = pSSysBIAggTableBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBIAggTableId() != null) {
            object = pSSysBIAggTableBase.getPSSysBIAggTableId();
            xmlNode.setAttribute(FIELD_PSSYSBIAGGTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBIAggTableName() != null) {
            object = pSSysBIAggTableBase.getPSSysBIAggTableName();
            xmlNode.setAttribute(FIELD_PSSYSBIAGGTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBICubeId() != null) {
            object = pSSysBIAggTableBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBICubeName() != null) {
            object = pSSysBIAggTableBase.getPSSysBICubeName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBISchemeId() != null) {
            object = pSSysBIAggTableBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getPSSysBISchemeName() != null) {
            object = pSSysBIAggTableBase.getPSSysBISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getRealTimeMode() != null) {
            object = pSSysBIAggTableBase.getRealTimeMode();
            xmlNode.setAttribute(FIELD_REALTIMEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBIAggTableBase.getUpdateDate() != null) {
            object = pSSysBIAggTableBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIAggTableBase.getUpdateMan() != null) {
            object = pSSysBIAggTableBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getUserCat() != null) {
            object = pSSysBIAggTableBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getUserTag() != null) {
            object = pSSysBIAggTableBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getUserTag2() != null) {
            object = pSSysBIAggTableBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getUserTag3() != null) {
            object = pSSysBIAggTableBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getUserTag4() != null) {
            object = pSSysBIAggTableBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggTableBase.getValidFlag() != null) {
            object = pSSysBIAggTableBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBIAggTableBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBIAggTableBase pSSysBIAggTableBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBIAggTableBase.isBIAggTableModeDirty() && (bl || pSSysBIAggTableBase.getBIAggTableMode() != null)) {
            iDataObject.set(FIELD_BIAGGTABLEMODE, (Object)pSSysBIAggTableBase.getBIAggTableMode());
        }
        if (pSSysBIAggTableBase.isBIAggTableOptionDirty() && (bl || pSSysBIAggTableBase.getBIAggTableOption() != null)) {
            iDataObject.set(FIELD_BIAGGTABLEOPTION, (Object)pSSysBIAggTableBase.getBIAggTableOption());
        }
        if (pSSysBIAggTableBase.isBIAggTableParamsDirty() && (bl || pSSysBIAggTableBase.getBIAggTableParams() != null)) {
            iDataObject.set(FIELD_BIAGGTABLEPARAMS, (Object)pSSysBIAggTableBase.getBIAggTableParams());
        }
        if (pSSysBIAggTableBase.isBIAggTableTagDirty() && (bl || pSSysBIAggTableBase.getBIAggTableTag() != null)) {
            iDataObject.set(FIELD_BIAGGTABLETAG, (Object)pSSysBIAggTableBase.getBIAggTableTag());
        }
        if (pSSysBIAggTableBase.isBIAggTableTag2Dirty() && (bl || pSSysBIAggTableBase.getBIAggTableTag2() != null)) {
            iDataObject.set(FIELD_BIAGGTABLETAG2, (Object)pSSysBIAggTableBase.getBIAggTableTag2());
        }
        if (pSSysBIAggTableBase.isCodeNameDirty() && (bl || pSSysBIAggTableBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBIAggTableBase.getCodeName());
        }
        if (pSSysBIAggTableBase.isCreateDateDirty() && (bl || pSSysBIAggTableBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBIAggTableBase.getCreateDate());
        }
        if (pSSysBIAggTableBase.isCreateManDirty() && (bl || pSSysBIAggTableBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBIAggTableBase.getCreateMan());
        }
        if (pSSysBIAggTableBase.isMemoDirty() && (bl || pSSysBIAggTableBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBIAggTableBase.getMemo());
        }
        if (pSSysBIAggTableBase.isPSDEDataQueryIdDirty() && (bl || pSSysBIAggTableBase.getPSDEDataQueryId() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYID, (Object)pSSysBIAggTableBase.getPSDEDataQueryId());
        }
        if (pSSysBIAggTableBase.isPSDEDataQueryNameDirty() && (bl || pSSysBIAggTableBase.getPSDEDataQueryName() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYNAME, (Object)pSSysBIAggTableBase.getPSDEDataQueryName());
        }
        if (pSSysBIAggTableBase.isPSDEDataSetIdDirty() && (bl || pSSysBIAggTableBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSSysBIAggTableBase.getPSDEDataSetId());
        }
        if (pSSysBIAggTableBase.isPSDEDataSetNameDirty() && (bl || pSSysBIAggTableBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSSysBIAggTableBase.getPSDEDataSetName());
        }
        if (pSSysBIAggTableBase.isPSDEIdDirty() && (bl || pSSysBIAggTableBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBIAggTableBase.getPSDEId());
        }
        if (pSSysBIAggTableBase.isPSDENameDirty() && (bl || pSSysBIAggTableBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysBIAggTableBase.getPSDEName());
        }
        if (pSSysBIAggTableBase.isPSSysBIAggTableIdDirty() && (bl || pSSysBIAggTableBase.getPSSysBIAggTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBIAGGTABLEID, (Object)pSSysBIAggTableBase.getPSSysBIAggTableId());
        }
        if (pSSysBIAggTableBase.isPSSysBIAggTableNameDirty() && (bl || pSSysBIAggTableBase.getPSSysBIAggTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBIAGGTABLENAME, (Object)pSSysBIAggTableBase.getPSSysBIAggTableName());
        }
        if (pSSysBIAggTableBase.isPSSysBICubeIdDirty() && (bl || pSSysBIAggTableBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSSysBIAggTableBase.getPSSysBICubeId());
        }
        if (pSSysBIAggTableBase.isPSSysBICubeNameDirty() && (bl || pSSysBIAggTableBase.getPSSysBICubeName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBENAME, (Object)pSSysBIAggTableBase.getPSSysBICubeName());
        }
        if (pSSysBIAggTableBase.isPSSysBISchemeIdDirty() && (bl || pSSysBIAggTableBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSSysBIAggTableBase.getPSSysBISchemeId());
        }
        if (pSSysBIAggTableBase.isPSSysBISchemeNameDirty() && (bl || pSSysBIAggTableBase.getPSSysBISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMENAME, (Object)pSSysBIAggTableBase.getPSSysBISchemeName());
        }
        if (pSSysBIAggTableBase.isRealTimeModeDirty() && (bl || pSSysBIAggTableBase.getRealTimeMode() != null)) {
            iDataObject.set(FIELD_REALTIMEMODE, (Object)pSSysBIAggTableBase.getRealTimeMode());
        }
        if (pSSysBIAggTableBase.isUpdateDateDirty() && (bl || pSSysBIAggTableBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBIAggTableBase.getUpdateDate());
        }
        if (pSSysBIAggTableBase.isUpdateManDirty() && (bl || pSSysBIAggTableBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBIAggTableBase.getUpdateMan());
        }
        if (pSSysBIAggTableBase.isUserCatDirty() && (bl || pSSysBIAggTableBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBIAggTableBase.getUserCat());
        }
        if (pSSysBIAggTableBase.isUserTagDirty() && (bl || pSSysBIAggTableBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBIAggTableBase.getUserTag());
        }
        if (pSSysBIAggTableBase.isUserTag2Dirty() && (bl || pSSysBIAggTableBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBIAggTableBase.getUserTag2());
        }
        if (pSSysBIAggTableBase.isUserTag3Dirty() && (bl || pSSysBIAggTableBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBIAggTableBase.getUserTag3());
        }
        if (pSSysBIAggTableBase.isUserTag4Dirty() && (bl || pSSysBIAggTableBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBIAggTableBase.getUserTag4());
        }
        if (pSSysBIAggTableBase.isValidFlagDirty() && (bl || pSSysBIAggTableBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBIAggTableBase.getValidFlag());
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
        return PSSysBIAggTableBase.remove(this, n);
    }

    private static boolean remove(PSSysBIAggTableBase pSSysBIAggTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIAggTableBase.resetBIAggTableMode();
                return true;
            }
            case 1: {
                pSSysBIAggTableBase.resetBIAggTableOption();
                return true;
            }
            case 2: {
                pSSysBIAggTableBase.resetBIAggTableParams();
                return true;
            }
            case 3: {
                pSSysBIAggTableBase.resetBIAggTableTag();
                return true;
            }
            case 4: {
                pSSysBIAggTableBase.resetBIAggTableTag2();
                return true;
            }
            case 5: {
                pSSysBIAggTableBase.resetCodeName();
                return true;
            }
            case 6: {
                pSSysBIAggTableBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSSysBIAggTableBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSysBIAggTableBase.resetMemo();
                return true;
            }
            case 9: {
                pSSysBIAggTableBase.resetPSDEDataQueryId();
                return true;
            }
            case 10: {
                pSSysBIAggTableBase.resetPSDEDataQueryName();
                return true;
            }
            case 11: {
                pSSysBIAggTableBase.resetPSDEDataSetId();
                return true;
            }
            case 12: {
                pSSysBIAggTableBase.resetPSDEDataSetName();
                return true;
            }
            case 13: {
                pSSysBIAggTableBase.resetPSDEId();
                return true;
            }
            case 14: {
                pSSysBIAggTableBase.resetPSDEName();
                return true;
            }
            case 15: {
                pSSysBIAggTableBase.resetPSSysBIAggTableId();
                return true;
            }
            case 16: {
                pSSysBIAggTableBase.resetPSSysBIAggTableName();
                return true;
            }
            case 17: {
                pSSysBIAggTableBase.resetPSSysBICubeId();
                return true;
            }
            case 18: {
                pSSysBIAggTableBase.resetPSSysBICubeName();
                return true;
            }
            case 19: {
                pSSysBIAggTableBase.resetPSSysBISchemeId();
                return true;
            }
            case 20: {
                pSSysBIAggTableBase.resetPSSysBISchemeName();
                return true;
            }
            case 21: {
                pSSysBIAggTableBase.resetRealTimeMode();
                return true;
            }
            case 22: {
                pSSysBIAggTableBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSSysBIAggTableBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSSysBIAggTableBase.resetUserCat();
                return true;
            }
            case 25: {
                pSSysBIAggTableBase.resetUserTag();
                return true;
            }
            case 26: {
                pSSysBIAggTableBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSSysBIAggTableBase.resetUserTag3();
                return true;
            }
            case 28: {
                pSSysBIAggTableBase.resetUserTag4();
                return true;
            }
            case 29: {
                pSSysBIAggTableBase.resetValidFlag();
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
    public PSDEDataQuery getPSDEDataQuery() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQuery();
        }
        if (this.getPSDEDataQueryId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataQueryLock;
        synchronized (n) {
            if (this.psdedataquery != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataQueryId(), (Object)this.psdedataquery.getPSDEDataQueryId()) != 0L) {
                this.psdedataquery = null;
            }
            if (this.psdedataquery == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDataQueryId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet((IEntity)pSDEDataQuery);
                this.psdedataquery = pSDEDataQuery;
            }
            return this.psdedataquery;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICube getPSSysBICube() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICube();
        }
        if (this.getPSSysBICubeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeLock;
        synchronized (n) {
            if (this.pssysbicube != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeId(), (Object)this.pssysbicube.getPSSysBICubeId()) != 0L) {
                this.pssysbicube = null;
            }
            if (this.pssysbicube == null) {
                PSSysBICube pSSysBICube = new PSSysBICube();
                pSSysBICube.setPSSysBICubeId(this.getPSSysBICubeId());
                PSSysBICubeService pSSysBICubeService = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeService.autoGet((IEntity)pSSysBICube);
                this.pssysbicube = pSSysBICube;
            }
            return this.pssysbicube;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIScheme getPSSysBIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIScheme();
        }
        if (this.getPSSysBISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBISchemeLock;
        synchronized (n) {
            if (this.pssysbischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBISchemeId(), (Object)this.pssysbischeme.getPSSysBISchemeId()) != 0L) {
                this.pssysbischeme = null;
            }
            if (this.pssysbischeme == null) {
                PSSysBIScheme pSSysBIScheme = new PSSysBIScheme();
                pSSysBIScheme.setPSSysBISchemeId(this.getPSSysBISchemeId());
                PSSysBISchemeService pSSysBISchemeService = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBISchemeService.autoGet((IEntity)pSSysBIScheme);
                this.pssysbischeme = pSSysBIScheme;
            }
            return this.pssysbischeme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBIAggColumn> getPSSysBIAggColumns() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggColumns();
        }
        if (this.getPSSysBIAggTableId() == null) {
            return null;
        }
        PSSysBIAggTableService pSSysBIAggTableService = (PSSysBIAggTableService)ServiceGlobal.getService(PSSysBIAggTableService.class, (SessionFactory)this.getSessionFactory());
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBIAggColumnsLock;
        synchronized (n) {
            if (this.pssysbiaggcolumns == null) {
                this.pssysbiaggcolumns = pSSysBIAggTableService.isTempData((IEntity)this) ? pSSysBIAggColumnService.selectTempByPSSysBIAggTable(this) : pSSysBIAggColumnService.selectByPSSysBIAggTable(this);
            }
            return this.pssysbiaggcolumns;
        }
    }

    private PSSysBIAggTableBase getProxyEntity() {
        return this.proxyPSSysBIAggTableBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBIAggTableBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBIAggTableBase) {
            this.proxyPSSysBIAggTableBase = (PSSysBIAggTableBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BIAGGTABLEMODE, 0);
        fieldIndexMap.put(FIELD_BIAGGTABLEOPTION, 1);
        fieldIndexMap.put(FIELD_BIAGGTABLEPARAMS, 2);
        fieldIndexMap.put(FIELD_BIAGGTABLETAG, 3);
        fieldIndexMap.put(FIELD_BIAGGTABLETAG2, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYID, 9);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYNAME, 10);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 11);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 12);
        fieldIndexMap.put(FIELD_PSDEID, 13);
        fieldIndexMap.put(FIELD_PSDENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSBIAGGTABLEID, 15);
        fieldIndexMap.put(FIELD_PSSYSBIAGGTABLENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 17);
        fieldIndexMap.put(FIELD_PSSYSBICUBENAME, 18);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 19);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMENAME, 20);
        fieldIndexMap.put(FIELD_REALTIMEMODE, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USERCAT, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_USERTAG3, 27);
        fieldIndexMap.put(FIELD_USERTAG4, 28);
        fieldIndexMap.put(FIELD_VALIDFLAG, 29);
    }
}

