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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERDEFMapBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDERDEFMapBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FORMULAFORMAT = "FORMULAFORMAT";
    public static final String FIELD_MAJORPSDEFID = "MAJORPSDEFID";
    public static final String FIELD_MAJORPSDEFNAME = "MAJORPSDEFNAME";
    public static final String FIELD_MAJORPSDEID = "MAJORPSDEID";
    public static final String FIELD_MAPTYPE = "MAPTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDEFID = "MINORPSDEFID";
    public static final String FIELD_MINORPSDEFNAME = "MINORPSDEFNAME";
    public static final String FIELD_MINORPSDEID = "MINORPSDEID";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDERDEFMAPID = "PSDERDEFMAPID";
    public static final String FIELD_PSDERDEFMAPNAME = "PSDERDEFMAPNAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_SRCVALUE = "SRCVALUE";
    public static final String FIELD_SRCVALUESTDDATATYPE = "SRCVALUESTDDATATYPE";
    public static final String FIELD_SRCVALUETYPE = "SRCVALUETYPE";
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
    private static final int INDEX_FORMULAFORMAT = 3;
    private static final int INDEX_MAJORPSDEFID = 4;
    private static final int INDEX_MAJORPSDEFNAME = 5;
    private static final int INDEX_MAJORPSDEID = 6;
    private static final int INDEX_MAPTYPE = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_MINORPSDEFID = 9;
    private static final int INDEX_MINORPSDEFNAME = 10;
    private static final int INDEX_MINORPSDEID = 11;
    private static final int INDEX_PSDEDQID = 12;
    private static final int INDEX_PSDEDQNAME = 13;
    private static final int INDEX_PSDERDEFMAPID = 14;
    private static final int INDEX_PSDERDEFMAPNAME = 15;
    private static final int INDEX_PSDERID = 16;
    private static final int INDEX_PSDERNAME = 17;
    private static final int INDEX_PSSYSSFPLUGINID = 18;
    private static final int INDEX_PSSYSSFPLUGINNAME = 19;
    private static final int INDEX_SRCVALUE = 20;
    private static final int INDEX_SRCVALUESTDDATATYPE = 21;
    private static final int INDEX_SRCVALUETYPE = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDERDEFMapBase proxyPSDERDEFMapBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean formulaformatDirtyFlag = false;
    private boolean majorpsdefidDirtyFlag = false;
    private boolean majorpsdefnameDirtyFlag = false;
    private boolean majorpsdeidDirtyFlag = false;
    private boolean maptypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsdefidDirtyFlag = false;
    private boolean minorpsdefnameDirtyFlag = false;
    private boolean minorpsdeidDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psderdefmapidDirtyFlag = false;
    private boolean psderdefmapnameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean srcvalueDirtyFlag = false;
    private boolean srcvaluestddatatypeDirtyFlag = false;
    private boolean srcvaluetypeDirtyFlag = false;
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
    @Column(name="formulaformat")
    private String formulaformat;
    @Column(name="majorpsdefid")
    private String majorpsdefid;
    @Column(name="majorpsdefname")
    private String majorpsdefname;
    @Column(name="majorpsdeid")
    private String majorpsdeid;
    @Column(name="maptype")
    private String maptype;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsdefid")
    private String minorpsdefid;
    @Column(name="minorpsdefname")
    private String minorpsdefname;
    @Column(name="minorpsdeid")
    private String minorpsdeid;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="psderdefmapid")
    private String psderdefmapid;
    @Column(name="psderdefmapname")
    private String psderdefmapname;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="srcvalue")
    private String srcvalue;
    @Column(name="srcvaluestddatatype")
    private Integer srcvaluestddatatype;
    @Column(name="srcvaluetype")
    private String srcvaluetype;
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
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objMajorPSDEFLock = new Integer(1);
    private PSDEField majorpsdef = null;
    private Integer objMinorPSDEFLock = new Integer(1);
    private PSDEField minorpsdef = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;

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

    public void setFormulaFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormulaFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formulaformat = string;
        this.formulaformatDirtyFlag = true;
    }

    public String getFormulaFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormulaFormat();
        }
        return this.formulaformat;
    }

    public boolean isFormulaFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormulaFormatDirty();
        }
        return this.formulaformatDirtyFlag;
    }

    public void resetFormulaFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormulaFormat();
            return;
        }
        this.formulaformatDirtyFlag = false;
        this.formulaformat = null;
    }

    public void setMajorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdefid = string;
        this.majorpsdefidDirtyFlag = true;
    }

    public String getMajorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEFId();
        }
        return this.majorpsdefid;
    }

    public boolean isMajorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEFIdDirty();
        }
        return this.majorpsdefidDirtyFlag;
    }

    public void resetMajorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEFId();
            return;
        }
        this.majorpsdefidDirtyFlag = false;
        this.majorpsdefid = null;
    }

    public void setMajorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdefname = string;
        this.majorpsdefnameDirtyFlag = true;
    }

    public String getMajorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEFName();
        }
        return this.majorpsdefname;
    }

    public boolean isMajorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEFNameDirty();
        }
        return this.majorpsdefnameDirtyFlag;
    }

    public void resetMajorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEFName();
            return;
        }
        this.majorpsdefnameDirtyFlag = false;
        this.majorpsdefname = null;
    }

    public void setMajorPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdeid = string;
        this.majorpsdeidDirtyFlag = true;
    }

    public String getMajorPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEId();
        }
        return this.majorpsdeid;
    }

    public boolean isMajorPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEIdDirty();
        }
        return this.majorpsdeidDirtyFlag;
    }

    public void resetMajorPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEId();
            return;
        }
        this.majorpsdeidDirtyFlag = false;
        this.majorpsdeid = null;
    }

    public void setMapType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maptype = string;
        this.maptypeDirtyFlag = true;
    }

    public String getMapType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapType();
        }
        return this.maptype;
    }

    public boolean isMapTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapTypeDirty();
        }
        return this.maptypeDirtyFlag;
    }

    public void resetMapType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapType();
            return;
        }
        this.maptypeDirtyFlag = false;
        this.maptype = null;
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

    public void setMinorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdefid = string;
        this.minorpsdefidDirtyFlag = true;
    }

    public String getMinorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEFId();
        }
        return this.minorpsdefid;
    }

    public boolean isMinorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEFIdDirty();
        }
        return this.minorpsdefidDirtyFlag;
    }

    public void resetMinorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEFId();
            return;
        }
        this.minorpsdefidDirtyFlag = false;
        this.minorpsdefid = null;
    }

    public void setMinorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdefname = string;
        this.minorpsdefnameDirtyFlag = true;
    }

    public String getMinorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEFName();
        }
        return this.minorpsdefname;
    }

    public boolean isMinorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEFNameDirty();
        }
        return this.minorpsdefnameDirtyFlag;
    }

    public void resetMinorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEFName();
            return;
        }
        this.minorpsdefnameDirtyFlag = false;
        this.minorpsdefname = null;
    }

    public void setMinorPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdeid = string;
        this.minorpsdeidDirtyFlag = true;
    }

    public String getMinorPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEId();
        }
        return this.minorpsdeid;
    }

    public boolean isMinorPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEIdDirty();
        }
        return this.minorpsdeidDirtyFlag;
    }

    public void resetMinorPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEId();
            return;
        }
        this.minorpsdeidDirtyFlag = false;
        this.minorpsdeid = null;
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

    public void setPSDERDEFMapId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERDEFMapId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderdefmapid = string;
        this.psderdefmapidDirtyFlag = true;
    }

    public String getPSDERDEFMapId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERDEFMapId();
        }
        return this.psderdefmapid;
    }

    public boolean isPSDERDEFMapIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERDEFMapIdDirty();
        }
        return this.psderdefmapidDirtyFlag;
    }

    public void resetPSDERDEFMapId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERDEFMapId();
            return;
        }
        this.psderdefmapidDirtyFlag = false;
        this.psderdefmapid = null;
    }

    public void setPSDERDEFMapName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERDEFMapName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderdefmapname = string;
        this.psderdefmapnameDirtyFlag = true;
    }

    public String getPSDERDEFMapName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERDEFMapName();
        }
        return this.psderdefmapname;
    }

    public boolean isPSDERDEFMapNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERDEFMapNameDirty();
        }
        return this.psderdefmapnameDirtyFlag;
    }

    public void resetPSDERDEFMapName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERDEFMapName();
            return;
        }
        this.psderdefmapnameDirtyFlag = false;
        this.psderdefmapname = null;
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

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setSrcValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcvalue = string;
        this.srcvalueDirtyFlag = true;
    }

    public String getSrcValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValue();
        }
        return this.srcvalue;
    }

    public boolean isSrcValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueDirty();
        }
        return this.srcvalueDirtyFlag;
    }

    public void resetSrcValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValue();
            return;
        }
        this.srcvalueDirtyFlag = false;
        this.srcvalue = null;
    }

    public void setSrcValueStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValueStdDataType(n);
            return;
        }
        this.srcvaluestddatatype = n;
        this.srcvaluestddatatypeDirtyFlag = true;
    }

    public Integer getSrcValueStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValueStdDataType();
        }
        return this.srcvaluestddatatype;
    }

    public boolean isSrcValueStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueStdDataTypeDirty();
        }
        return this.srcvaluestddatatypeDirtyFlag;
    }

    public void resetSrcValueStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValueStdDataType();
            return;
        }
        this.srcvaluestddatatypeDirtyFlag = false;
        this.srcvaluestddatatype = null;
    }

    public void setSrcValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcvaluetype = string;
        this.srcvaluetypeDirtyFlag = true;
    }

    public String getSrcValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValueType();
        }
        return this.srcvaluetype;
    }

    public boolean isSrcValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueTypeDirty();
        }
        return this.srcvaluetypeDirtyFlag;
    }

    public void resetSrcValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValueType();
            return;
        }
        this.srcvaluetypeDirtyFlag = false;
        this.srcvaluetype = null;
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
        PSDERDEFMapBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDERDEFMapBase pSDERDEFMapBase) {
        pSDERDEFMapBase.resetCodeName();
        pSDERDEFMapBase.resetCreateDate();
        pSDERDEFMapBase.resetCreateMan();
        pSDERDEFMapBase.resetFormulaFormat();
        pSDERDEFMapBase.resetMajorPSDEFId();
        pSDERDEFMapBase.resetMajorPSDEFName();
        pSDERDEFMapBase.resetMajorPSDEId();
        pSDERDEFMapBase.resetMapType();
        pSDERDEFMapBase.resetMemo();
        pSDERDEFMapBase.resetMinorPSDEFId();
        pSDERDEFMapBase.resetMinorPSDEFName();
        pSDERDEFMapBase.resetMinorPSDEId();
        pSDERDEFMapBase.resetPSDEDQId();
        pSDERDEFMapBase.resetPSDEDQName();
        pSDERDEFMapBase.resetPSDERDEFMapId();
        pSDERDEFMapBase.resetPSDERDEFMapName();
        pSDERDEFMapBase.resetPSDERId();
        pSDERDEFMapBase.resetPSDERName();
        pSDERDEFMapBase.resetPSSysSFPluginId();
        pSDERDEFMapBase.resetPSSysSFPluginName();
        pSDERDEFMapBase.resetSrcValue();
        pSDERDEFMapBase.resetSrcValueStdDataType();
        pSDERDEFMapBase.resetSrcValueType();
        pSDERDEFMapBase.resetUpdateDate();
        pSDERDEFMapBase.resetUpdateMan();
        pSDERDEFMapBase.resetUserCat();
        pSDERDEFMapBase.resetUserTag();
        pSDERDEFMapBase.resetUserTag2();
        pSDERDEFMapBase.resetUserTag3();
        pSDERDEFMapBase.resetUserTag4();
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
        if (!bl || this.isFormulaFormatDirty()) {
            hashMap.put(FIELD_FORMULAFORMAT, this.getFormulaFormat());
        }
        if (!bl || this.isMajorPSDEFIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEFID, this.getMajorPSDEFId());
        }
        if (!bl || this.isMajorPSDEFNameDirty()) {
            hashMap.put(FIELD_MAJORPSDEFNAME, this.getMajorPSDEFName());
        }
        if (!bl || this.isMajorPSDEIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEID, this.getMajorPSDEId());
        }
        if (!bl || this.isMapTypeDirty()) {
            hashMap.put(FIELD_MAPTYPE, this.getMapType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDEFIdDirty()) {
            hashMap.put(FIELD_MINORPSDEFID, this.getMinorPSDEFId());
        }
        if (!bl || this.isMinorPSDEFNameDirty()) {
            hashMap.put(FIELD_MINORPSDEFNAME, this.getMinorPSDEFName());
        }
        if (!bl || this.isMinorPSDEIdDirty()) {
            hashMap.put(FIELD_MINORPSDEID, this.getMinorPSDEId());
        }
        if (!bl || this.isPSDEDQIdDirty()) {
            hashMap.put(FIELD_PSDEDQID, this.getPSDEDQId());
        }
        if (!bl || this.isPSDEDQNameDirty()) {
            hashMap.put(FIELD_PSDEDQNAME, this.getPSDEDQName());
        }
        if (!bl || this.isPSDERDEFMapIdDirty()) {
            hashMap.put(FIELD_PSDERDEFMAPID, this.getPSDERDEFMapId());
        }
        if (!bl || this.isPSDERDEFMapNameDirty()) {
            hashMap.put(FIELD_PSDERDEFMAPNAME, this.getPSDERDEFMapName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isSrcValueDirty()) {
            hashMap.put(FIELD_SRCVALUE, this.getSrcValue());
        }
        if (!bl || this.isSrcValueStdDataTypeDirty()) {
            hashMap.put(FIELD_SRCVALUESTDDATATYPE, this.getSrcValueStdDataType());
        }
        if (!bl || this.isSrcValueTypeDirty()) {
            hashMap.put(FIELD_SRCVALUETYPE, this.getSrcValueType());
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
        return PSDERDEFMapBase.get(this, n);
    }

    private static Object get(PSDERDEFMapBase pSDERDEFMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERDEFMapBase.getCodeName();
            }
            case 1: {
                return pSDERDEFMapBase.getCreateDate();
            }
            case 2: {
                return pSDERDEFMapBase.getCreateMan();
            }
            case 3: {
                return pSDERDEFMapBase.getFormulaFormat();
            }
            case 4: {
                return pSDERDEFMapBase.getMajorPSDEFId();
            }
            case 5: {
                return pSDERDEFMapBase.getMajorPSDEFName();
            }
            case 6: {
                return pSDERDEFMapBase.getMajorPSDEId();
            }
            case 7: {
                return pSDERDEFMapBase.getMapType();
            }
            case 8: {
                return pSDERDEFMapBase.getMemo();
            }
            case 9: {
                return pSDERDEFMapBase.getMinorPSDEFId();
            }
            case 10: {
                return pSDERDEFMapBase.getMinorPSDEFName();
            }
            case 11: {
                return pSDERDEFMapBase.getMinorPSDEId();
            }
            case 12: {
                return pSDERDEFMapBase.getPSDEDQId();
            }
            case 13: {
                return pSDERDEFMapBase.getPSDEDQName();
            }
            case 14: {
                return pSDERDEFMapBase.getPSDERDEFMapId();
            }
            case 15: {
                return pSDERDEFMapBase.getPSDERDEFMapName();
            }
            case 16: {
                return pSDERDEFMapBase.getPSDERId();
            }
            case 17: {
                return pSDERDEFMapBase.getPSDERName();
            }
            case 18: {
                return pSDERDEFMapBase.getPSSysSFPluginId();
            }
            case 19: {
                return pSDERDEFMapBase.getPSSysSFPluginName();
            }
            case 20: {
                return pSDERDEFMapBase.getSrcValue();
            }
            case 21: {
                return pSDERDEFMapBase.getSrcValueStdDataType();
            }
            case 22: {
                return pSDERDEFMapBase.getSrcValueType();
            }
            case 23: {
                return pSDERDEFMapBase.getUpdateDate();
            }
            case 24: {
                return pSDERDEFMapBase.getUpdateMan();
            }
            case 25: {
                return pSDERDEFMapBase.getUserCat();
            }
            case 26: {
                return pSDERDEFMapBase.getUserTag();
            }
            case 27: {
                return pSDERDEFMapBase.getUserTag2();
            }
            case 28: {
                return pSDERDEFMapBase.getUserTag3();
            }
            case 29: {
                return pSDERDEFMapBase.getUserTag4();
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
        PSDERDEFMapBase.set(this, n, object);
    }

    private static void set(PSDERDEFMapBase pSDERDEFMapBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDERDEFMapBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDERDEFMapBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDERDEFMapBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDERDEFMapBase.setFormulaFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDERDEFMapBase.setMajorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDERDEFMapBase.setMajorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDERDEFMapBase.setMajorPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDERDEFMapBase.setMapType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDERDEFMapBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDERDEFMapBase.setMinorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDERDEFMapBase.setMinorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDERDEFMapBase.setMinorPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDERDEFMapBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDERDEFMapBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDERDEFMapBase.setPSDERDEFMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDERDEFMapBase.setPSDERDEFMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDERDEFMapBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDERDEFMapBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDERDEFMapBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDERDEFMapBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDERDEFMapBase.setSrcValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDERDEFMapBase.setSrcValueStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDERDEFMapBase.setSrcValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDERDEFMapBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDERDEFMapBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDERDEFMapBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDERDEFMapBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDERDEFMapBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDERDEFMapBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDERDEFMapBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDERDEFMapBase.isNull(this, n);
    }

    private static boolean isNull(PSDERDEFMapBase pSDERDEFMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERDEFMapBase.getCodeName() == null;
            }
            case 1: {
                return pSDERDEFMapBase.getCreateDate() == null;
            }
            case 2: {
                return pSDERDEFMapBase.getCreateMan() == null;
            }
            case 3: {
                return pSDERDEFMapBase.getFormulaFormat() == null;
            }
            case 4: {
                return pSDERDEFMapBase.getMajorPSDEFId() == null;
            }
            case 5: {
                return pSDERDEFMapBase.getMajorPSDEFName() == null;
            }
            case 6: {
                return pSDERDEFMapBase.getMajorPSDEId() == null;
            }
            case 7: {
                return pSDERDEFMapBase.getMapType() == null;
            }
            case 8: {
                return pSDERDEFMapBase.getMemo() == null;
            }
            case 9: {
                return pSDERDEFMapBase.getMinorPSDEFId() == null;
            }
            case 10: {
                return pSDERDEFMapBase.getMinorPSDEFName() == null;
            }
            case 11: {
                return pSDERDEFMapBase.getMinorPSDEId() == null;
            }
            case 12: {
                return pSDERDEFMapBase.getPSDEDQId() == null;
            }
            case 13: {
                return pSDERDEFMapBase.getPSDEDQName() == null;
            }
            case 14: {
                return pSDERDEFMapBase.getPSDERDEFMapId() == null;
            }
            case 15: {
                return pSDERDEFMapBase.getPSDERDEFMapName() == null;
            }
            case 16: {
                return pSDERDEFMapBase.getPSDERId() == null;
            }
            case 17: {
                return pSDERDEFMapBase.getPSDERName() == null;
            }
            case 18: {
                return pSDERDEFMapBase.getPSSysSFPluginId() == null;
            }
            case 19: {
                return pSDERDEFMapBase.getPSSysSFPluginName() == null;
            }
            case 20: {
                return pSDERDEFMapBase.getSrcValue() == null;
            }
            case 21: {
                return pSDERDEFMapBase.getSrcValueStdDataType() == null;
            }
            case 22: {
                return pSDERDEFMapBase.getSrcValueType() == null;
            }
            case 23: {
                return pSDERDEFMapBase.getUpdateDate() == null;
            }
            case 24: {
                return pSDERDEFMapBase.getUpdateMan() == null;
            }
            case 25: {
                return pSDERDEFMapBase.getUserCat() == null;
            }
            case 26: {
                return pSDERDEFMapBase.getUserTag() == null;
            }
            case 27: {
                return pSDERDEFMapBase.getUserTag2() == null;
            }
            case 28: {
                return pSDERDEFMapBase.getUserTag3() == null;
            }
            case 29: {
                return pSDERDEFMapBase.getUserTag4() == null;
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
        return PSDERDEFMapBase.contains(this, n);
    }

    private static boolean contains(PSDERDEFMapBase pSDERDEFMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERDEFMapBase.isCodeNameDirty();
            }
            case 1: {
                return pSDERDEFMapBase.isCreateDateDirty();
            }
            case 2: {
                return pSDERDEFMapBase.isCreateManDirty();
            }
            case 3: {
                return pSDERDEFMapBase.isFormulaFormatDirty();
            }
            case 4: {
                return pSDERDEFMapBase.isMajorPSDEFIdDirty();
            }
            case 5: {
                return pSDERDEFMapBase.isMajorPSDEFNameDirty();
            }
            case 6: {
                return pSDERDEFMapBase.isMajorPSDEIdDirty();
            }
            case 7: {
                return pSDERDEFMapBase.isMapTypeDirty();
            }
            case 8: {
                return pSDERDEFMapBase.isMemoDirty();
            }
            case 9: {
                return pSDERDEFMapBase.isMinorPSDEFIdDirty();
            }
            case 10: {
                return pSDERDEFMapBase.isMinorPSDEFNameDirty();
            }
            case 11: {
                return pSDERDEFMapBase.isMinorPSDEIdDirty();
            }
            case 12: {
                return pSDERDEFMapBase.isPSDEDQIdDirty();
            }
            case 13: {
                return pSDERDEFMapBase.isPSDEDQNameDirty();
            }
            case 14: {
                return pSDERDEFMapBase.isPSDERDEFMapIdDirty();
            }
            case 15: {
                return pSDERDEFMapBase.isPSDERDEFMapNameDirty();
            }
            case 16: {
                return pSDERDEFMapBase.isPSDERIdDirty();
            }
            case 17: {
                return pSDERDEFMapBase.isPSDERNameDirty();
            }
            case 18: {
                return pSDERDEFMapBase.isPSSysSFPluginIdDirty();
            }
            case 19: {
                return pSDERDEFMapBase.isPSSysSFPluginNameDirty();
            }
            case 20: {
                return pSDERDEFMapBase.isSrcValueDirty();
            }
            case 21: {
                return pSDERDEFMapBase.isSrcValueStdDataTypeDirty();
            }
            case 22: {
                return pSDERDEFMapBase.isSrcValueTypeDirty();
            }
            case 23: {
                return pSDERDEFMapBase.isUpdateDateDirty();
            }
            case 24: {
                return pSDERDEFMapBase.isUpdateManDirty();
            }
            case 25: {
                return pSDERDEFMapBase.isUserCatDirty();
            }
            case 26: {
                return pSDERDEFMapBase.isUserTagDirty();
            }
            case 27: {
                return pSDERDEFMapBase.isUserTag2Dirty();
            }
            case 28: {
                return pSDERDEFMapBase.isUserTag3Dirty();
            }
            case 29: {
                return pSDERDEFMapBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDERDEFMapBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDERDEFMapBase pSDERDEFMapBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDERDEFMapBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getFormulaFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formulaformat", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getFormulaFormat()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getMajorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdefid", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getMajorPSDEFId()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getMajorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdefname", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getMajorPSDEFName()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getMajorPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdeid", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getMajorPSDEId()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getMapType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maptype", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getMapType()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getMemo()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getMinorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdefid", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getMinorPSDEFId()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getMinorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdefname", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getMinorPSDEFName()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getMinorPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdeid", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getMinorPSDEId()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getPSDERDEFMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderdefmapid", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getPSDERDEFMapId()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getPSDERDEFMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderdefmapname", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getPSDERDEFMapName()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getSrcValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvalue", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getSrcValue()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getSrcValueStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvaluestddatatype", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getSrcValueStdDataType()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getSrcValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvaluetype", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getSrcValueType()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDERDEFMapBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDERDEFMapBase.getJSONValue((Object)pSDERDEFMapBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDERDEFMapBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDERDEFMapBase pSDERDEFMapBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDERDEFMapBase.getCodeName() != null) {
            object = pSDERDEFMapBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getCreateDate() != null) {
            object = pSDERDEFMapBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERDEFMapBase.getCreateMan() != null) {
            object = pSDERDEFMapBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getFormulaFormat() != null) {
            object = pSDERDEFMapBase.getFormulaFormat();
            xmlNode.setAttribute(FIELD_FORMULAFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getMajorPSDEFId() != null) {
            object = pSDERDEFMapBase.getMajorPSDEFId();
            xmlNode.setAttribute(FIELD_MAJORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getMajorPSDEFName() != null) {
            object = pSDERDEFMapBase.getMajorPSDEFName();
            xmlNode.setAttribute(FIELD_MAJORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getMajorPSDEId() != null) {
            object = pSDERDEFMapBase.getMajorPSDEId();
            xmlNode.setAttribute(FIELD_MAJORPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getMapType() != null) {
            object = pSDERDEFMapBase.getMapType();
            xmlNode.setAttribute(FIELD_MAPTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getMemo() != null) {
            object = pSDERDEFMapBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getMinorPSDEFId() != null) {
            object = pSDERDEFMapBase.getMinorPSDEFId();
            xmlNode.setAttribute(FIELD_MINORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getMinorPSDEFName() != null) {
            object = pSDERDEFMapBase.getMinorPSDEFName();
            xmlNode.setAttribute(FIELD_MINORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getMinorPSDEId() != null) {
            object = pSDERDEFMapBase.getMinorPSDEId();
            xmlNode.setAttribute(FIELD_MINORPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getPSDEDQId() != null) {
            object = pSDERDEFMapBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getPSDEDQName() != null) {
            object = pSDERDEFMapBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getPSDERDEFMapId() != null) {
            object = pSDERDEFMapBase.getPSDERDEFMapId();
            xmlNode.setAttribute(FIELD_PSDERDEFMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getPSDERDEFMapName() != null) {
            object = pSDERDEFMapBase.getPSDERDEFMapName();
            xmlNode.setAttribute(FIELD_PSDERDEFMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getPSDERId() != null) {
            object = pSDERDEFMapBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getPSDERName() != null) {
            object = pSDERDEFMapBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getPSSysSFPluginId() != null) {
            object = pSDERDEFMapBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getPSSysSFPluginName() != null) {
            object = pSDERDEFMapBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getSrcValue() != null) {
            object = pSDERDEFMapBase.getSrcValue();
            xmlNode.setAttribute(FIELD_SRCVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getSrcValueStdDataType() != null) {
            object = pSDERDEFMapBase.getSrcValueStdDataType();
            xmlNode.setAttribute(FIELD_SRCVALUESTDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERDEFMapBase.getSrcValueType() != null) {
            object = pSDERDEFMapBase.getSrcValueType();
            xmlNode.setAttribute(FIELD_SRCVALUETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getUpdateDate() != null) {
            object = pSDERDEFMapBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERDEFMapBase.getUpdateMan() != null) {
            object = pSDERDEFMapBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getUserCat() != null) {
            object = pSDERDEFMapBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getUserTag() != null) {
            object = pSDERDEFMapBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getUserTag2() != null) {
            object = pSDERDEFMapBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getUserTag3() != null) {
            object = pSDERDEFMapBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDERDEFMapBase.getUserTag4() != null) {
            object = pSDERDEFMapBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDERDEFMapBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDERDEFMapBase pSDERDEFMapBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDERDEFMapBase.isCodeNameDirty() && (bl || pSDERDEFMapBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDERDEFMapBase.getCodeName());
        }
        if (pSDERDEFMapBase.isCreateDateDirty() && (bl || pSDERDEFMapBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDERDEFMapBase.getCreateDate());
        }
        if (pSDERDEFMapBase.isCreateManDirty() && (bl || pSDERDEFMapBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDERDEFMapBase.getCreateMan());
        }
        if (pSDERDEFMapBase.isFormulaFormatDirty() && (bl || pSDERDEFMapBase.getFormulaFormat() != null)) {
            iDataObject.set(FIELD_FORMULAFORMAT, (Object)pSDERDEFMapBase.getFormulaFormat());
        }
        if (pSDERDEFMapBase.isMajorPSDEFIdDirty() && (bl || pSDERDEFMapBase.getMajorPSDEFId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEFID, (Object)pSDERDEFMapBase.getMajorPSDEFId());
        }
        if (pSDERDEFMapBase.isMajorPSDEFNameDirty() && (bl || pSDERDEFMapBase.getMajorPSDEFName() != null)) {
            iDataObject.set(FIELD_MAJORPSDEFNAME, (Object)pSDERDEFMapBase.getMajorPSDEFName());
        }
        if (pSDERDEFMapBase.isMajorPSDEIdDirty() && (bl || pSDERDEFMapBase.getMajorPSDEId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEID, (Object)pSDERDEFMapBase.getMajorPSDEId());
        }
        if (pSDERDEFMapBase.isMapTypeDirty() && (bl || pSDERDEFMapBase.getMapType() != null)) {
            iDataObject.set(FIELD_MAPTYPE, (Object)pSDERDEFMapBase.getMapType());
        }
        if (pSDERDEFMapBase.isMemoDirty() && (bl || pSDERDEFMapBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDERDEFMapBase.getMemo());
        }
        if (pSDERDEFMapBase.isMinorPSDEFIdDirty() && (bl || pSDERDEFMapBase.getMinorPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORPSDEFID, (Object)pSDERDEFMapBase.getMinorPSDEFId());
        }
        if (pSDERDEFMapBase.isMinorPSDEFNameDirty() && (bl || pSDERDEFMapBase.getMinorPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORPSDEFNAME, (Object)pSDERDEFMapBase.getMinorPSDEFName());
        }
        if (pSDERDEFMapBase.isMinorPSDEIdDirty() && (bl || pSDERDEFMapBase.getMinorPSDEId() != null)) {
            iDataObject.set(FIELD_MINORPSDEID, (Object)pSDERDEFMapBase.getMinorPSDEId());
        }
        if (pSDERDEFMapBase.isPSDEDQIdDirty() && (bl || pSDERDEFMapBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDERDEFMapBase.getPSDEDQId());
        }
        if (pSDERDEFMapBase.isPSDEDQNameDirty() && (bl || pSDERDEFMapBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDERDEFMapBase.getPSDEDQName());
        }
        if (pSDERDEFMapBase.isPSDERDEFMapIdDirty() && (bl || pSDERDEFMapBase.getPSDERDEFMapId() != null)) {
            iDataObject.set(FIELD_PSDERDEFMAPID, (Object)pSDERDEFMapBase.getPSDERDEFMapId());
        }
        if (pSDERDEFMapBase.isPSDERDEFMapNameDirty() && (bl || pSDERDEFMapBase.getPSDERDEFMapName() != null)) {
            iDataObject.set(FIELD_PSDERDEFMAPNAME, (Object)pSDERDEFMapBase.getPSDERDEFMapName());
        }
        if (pSDERDEFMapBase.isPSDERIdDirty() && (bl || pSDERDEFMapBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDERDEFMapBase.getPSDERId());
        }
        if (pSDERDEFMapBase.isPSDERNameDirty() && (bl || pSDERDEFMapBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDERDEFMapBase.getPSDERName());
        }
        if (pSDERDEFMapBase.isPSSysSFPluginIdDirty() && (bl || pSDERDEFMapBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDERDEFMapBase.getPSSysSFPluginId());
        }
        if (pSDERDEFMapBase.isPSSysSFPluginNameDirty() && (bl || pSDERDEFMapBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDERDEFMapBase.getPSSysSFPluginName());
        }
        if (pSDERDEFMapBase.isSrcValueDirty() && (bl || pSDERDEFMapBase.getSrcValue() != null)) {
            iDataObject.set(FIELD_SRCVALUE, (Object)pSDERDEFMapBase.getSrcValue());
        }
        if (pSDERDEFMapBase.isSrcValueStdDataTypeDirty() && (bl || pSDERDEFMapBase.getSrcValueStdDataType() != null)) {
            iDataObject.set(FIELD_SRCVALUESTDDATATYPE, (Object)pSDERDEFMapBase.getSrcValueStdDataType());
        }
        if (pSDERDEFMapBase.isSrcValueTypeDirty() && (bl || pSDERDEFMapBase.getSrcValueType() != null)) {
            iDataObject.set(FIELD_SRCVALUETYPE, (Object)pSDERDEFMapBase.getSrcValueType());
        }
        if (pSDERDEFMapBase.isUpdateDateDirty() && (bl || pSDERDEFMapBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDERDEFMapBase.getUpdateDate());
        }
        if (pSDERDEFMapBase.isUpdateManDirty() && (bl || pSDERDEFMapBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDERDEFMapBase.getUpdateMan());
        }
        if (pSDERDEFMapBase.isUserCatDirty() && (bl || pSDERDEFMapBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDERDEFMapBase.getUserCat());
        }
        if (pSDERDEFMapBase.isUserTagDirty() && (bl || pSDERDEFMapBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDERDEFMapBase.getUserTag());
        }
        if (pSDERDEFMapBase.isUserTag2Dirty() && (bl || pSDERDEFMapBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDERDEFMapBase.getUserTag2());
        }
        if (pSDERDEFMapBase.isUserTag3Dirty() && (bl || pSDERDEFMapBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDERDEFMapBase.getUserTag3());
        }
        if (pSDERDEFMapBase.isUserTag4Dirty() && (bl || pSDERDEFMapBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDERDEFMapBase.getUserTag4());
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
        return PSDERDEFMapBase.remove(this, n);
    }

    private static boolean remove(PSDERDEFMapBase pSDERDEFMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDERDEFMapBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDERDEFMapBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDERDEFMapBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDERDEFMapBase.resetFormulaFormat();
                return true;
            }
            case 4: {
                pSDERDEFMapBase.resetMajorPSDEFId();
                return true;
            }
            case 5: {
                pSDERDEFMapBase.resetMajorPSDEFName();
                return true;
            }
            case 6: {
                pSDERDEFMapBase.resetMajorPSDEId();
                return true;
            }
            case 7: {
                pSDERDEFMapBase.resetMapType();
                return true;
            }
            case 8: {
                pSDERDEFMapBase.resetMemo();
                return true;
            }
            case 9: {
                pSDERDEFMapBase.resetMinorPSDEFId();
                return true;
            }
            case 10: {
                pSDERDEFMapBase.resetMinorPSDEFName();
                return true;
            }
            case 11: {
                pSDERDEFMapBase.resetMinorPSDEId();
                return true;
            }
            case 12: {
                pSDERDEFMapBase.resetPSDEDQId();
                return true;
            }
            case 13: {
                pSDERDEFMapBase.resetPSDEDQName();
                return true;
            }
            case 14: {
                pSDERDEFMapBase.resetPSDERDEFMapId();
                return true;
            }
            case 15: {
                pSDERDEFMapBase.resetPSDERDEFMapName();
                return true;
            }
            case 16: {
                pSDERDEFMapBase.resetPSDERId();
                return true;
            }
            case 17: {
                pSDERDEFMapBase.resetPSDERName();
                return true;
            }
            case 18: {
                pSDERDEFMapBase.resetPSSysSFPluginId();
                return true;
            }
            case 19: {
                pSDERDEFMapBase.resetPSSysSFPluginName();
                return true;
            }
            case 20: {
                pSDERDEFMapBase.resetSrcValue();
                return true;
            }
            case 21: {
                pSDERDEFMapBase.resetSrcValueStdDataType();
                return true;
            }
            case 22: {
                pSDERDEFMapBase.resetSrcValueType();
                return true;
            }
            case 23: {
                pSDERDEFMapBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSDERDEFMapBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSDERDEFMapBase.resetUserCat();
                return true;
            }
            case 26: {
                pSDERDEFMapBase.resetUserTag();
                return true;
            }
            case 27: {
                pSDERDEFMapBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSDERDEFMapBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSDERDEFMapBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDEDataQueryService.autoGet((IEntity)pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMajorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEF();
        }
        if (this.getMajorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDEFLock;
        synchronized (n) {
            if (this.majorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDEFId(), (Object)this.majorpsdef.getPSDEFieldId()) != 0L) {
                this.majorpsdef = null;
            }
            if (this.majorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMajorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.majorpsdef = pSDEField;
            }
            return this.majorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMinorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEF();
        }
        if (this.getMinorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDEFLock;
        synchronized (n) {
            if (this.minorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDEFId(), (Object)this.minorpsdef.getPSDEFieldId()) != 0L) {
                this.minorpsdef = null;
            }
            if (this.minorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMinorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.minorpsdef = pSDEField;
            }
            return this.minorpsdef;
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
                pSDERService.autoGet((IEntity)pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    private PSDERDEFMapBase getProxyEntity() {
        return this.proxyPSDERDEFMapBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDERDEFMapBase = null;
        if (iDataObject != null && iDataObject instanceof PSDERDEFMapBase) {
            this.proxyPSDERDEFMapBase = (PSDERDEFMapBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FORMULAFORMAT, 3);
        fieldIndexMap.put(FIELD_MAJORPSDEFID, 4);
        fieldIndexMap.put(FIELD_MAJORPSDEFNAME, 5);
        fieldIndexMap.put(FIELD_MAJORPSDEID, 6);
        fieldIndexMap.put(FIELD_MAPTYPE, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_MINORPSDEFID, 9);
        fieldIndexMap.put(FIELD_MINORPSDEFNAME, 10);
        fieldIndexMap.put(FIELD_MINORPSDEID, 11);
        fieldIndexMap.put(FIELD_PSDEDQID, 12);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 13);
        fieldIndexMap.put(FIELD_PSDERDEFMAPID, 14);
        fieldIndexMap.put(FIELD_PSDERDEFMAPNAME, 15);
        fieldIndexMap.put(FIELD_PSDERID, 16);
        fieldIndexMap.put(FIELD_PSDERNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 19);
        fieldIndexMap.put(FIELD_SRCVALUE, 20);
        fieldIndexMap.put(FIELD_SRCVALUESTDDATATYPE, 21);
        fieldIndexMap.put(FIELD_SRCVALUETYPE, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
    }
}

