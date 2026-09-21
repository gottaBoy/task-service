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
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDEDQPDCond;
import net.ibizsys.pscore.srv.config.entity.PSVarType;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPService;
import net.ibizsys.pscore.srv.config.service.PSDEDQPDCondService;
import net.ibizsys.pscore.srv.config.service.PSVarTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQCondBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDQCondBase.class);
    public static final String FIELD_CONDTAG = "CONDTAG";
    public static final String FIELD_CONDTAG2 = "CONDTAG2";
    public static final String FIELD_CONDTYPE = "CONDTYPE";
    public static final String FIELD_CONDVALUE = "CONDVALUE";
    public static final String FIELD_CONDVALUETEXT = "CONDVALUETEXT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String FIELD_GROUPOP = "GROUPOP";
    public static final String FIELD_IGNOREEMPTY = "IGNOREEMPTY";
    public static final String FIELD_LEVELTAG = "LEVELTAG";
    public static final String FIELD_LEVELVALUE = "LEVELVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSDEDQCONDID = "PPSDEDQCONDID";
    public static final String FIELD_PPSDEDQCONDNAME = "PPSDEDQCONDNAME";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_PSDEDQCONDID = "PSDEDQCONDID";
    public static final String FIELD_PSDEDQCONDNAME = "PSDEDQCONDNAME";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQJOINID = "PSDEDQJOINID";
    public static final String FIELD_PSDEDQJOINNAME = "PSDEDQJOINNAME";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDEDQPDCONDID = "PSDEDQPDCONDID";
    public static final String FIELD_PSDEDQPDCONDNAME = "PSDEDQPDCONDNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String FIELD_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String FIELD_PSVARTYPEID = "PSVARTYPEID";
    public static final String FIELD_PSVARTYPENAME = "PSVARTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CONDTAG = 0;
    private static final int INDEX_CONDTAG2 = 1;
    private static final int INDEX_CONDTYPE = 2;
    private static final int INDEX_CONDVALUE = 3;
    private static final int INDEX_CONDVALUETEXT = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CUSTOMCOND = 7;
    private static final int INDEX_CUSTOMTYPE = 8;
    private static final int INDEX_GROUPNOTFLAG = 9;
    private static final int INDEX_GROUPOP = 10;
    private static final int INDEX_IGNOREEMPTY = 11;
    private static final int INDEX_LEVELTAG = 12;
    private static final int INDEX_LEVELVALUE = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_PPSDEDQCONDID = 16;
    private static final int INDEX_PPSDEDQCONDNAME = 17;
    private static final int INDEX_PSDBVALUEOPID = 18;
    private static final int INDEX_PSDBVALUEOPNAME = 19;
    private static final int INDEX_PSDEDQCONDID = 20;
    private static final int INDEX_PSDEDQCONDNAME = 21;
    private static final int INDEX_PSDEDQID = 22;
    private static final int INDEX_PSDEDQJOINID = 23;
    private static final int INDEX_PSDEDQJOINNAME = 24;
    private static final int INDEX_PSDEDQNAME = 25;
    private static final int INDEX_PSDEDQPDCONDID = 26;
    private static final int INDEX_PSDEDQPDCONDNAME = 27;
    private static final int INDEX_PSDEFID = 28;
    private static final int INDEX_PSDEFNAME = 29;
    private static final int INDEX_PSDEID = 30;
    private static final int INDEX_PSSYSDBVFID = 31;
    private static final int INDEX_PSSYSDBVFNAME = 32;
    private static final int INDEX_PSVARTYPEID = 33;
    private static final int INDEX_PSVARTYPENAME = 34;
    private static final int INDEX_UPDATEDATE = 35;
    private static final int INDEX_UPDATEMAN = 36;
    private static final int INDEX_USERCAT = 37;
    private static final int INDEX_USERTAG = 38;
    private static final int INDEX_USERTAG2 = 39;
    private static final int INDEX_USERTAG3 = 40;
    private static final int INDEX_USERTAG4 = 41;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDQCondBase proxyPSDEDQCondBase = null;
    private boolean condtagDirtyFlag = false;
    private boolean condtag2DirtyFlag = false;
    private boolean condtypeDirtyFlag = false;
    private boolean condvalueDirtyFlag = false;
    private boolean condvaluetextDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean groupnotflagDirtyFlag = false;
    private boolean groupopDirtyFlag = false;
    private boolean ignoreemptyDirtyFlag = false;
    private boolean leveltagDirtyFlag = false;
    private boolean levelvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsdedqcondidDirtyFlag = false;
    private boolean ppsdedqcondnameDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean psdedqcondidDirtyFlag = false;
    private boolean psdedqcondnameDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqjoinidDirtyFlag = false;
    private boolean psdedqjoinnameDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psdedqpdcondidDirtyFlag = false;
    private boolean psdedqpdcondnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysdbvfidDirtyFlag = false;
    private boolean pssysdbvfnameDirtyFlag = false;
    private boolean psvartypeidDirtyFlag = false;
    private boolean psvartypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="condtag")
    private String condtag;
    @Column(name="condtag2")
    private String condtag2;
    @Column(name="condtype")
    private String condtype;
    @Column(name="condvalue")
    private String condvalue;
    @Column(name="condvaluetext")
    private String condvaluetext;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="groupnotflag")
    private Integer groupnotflag;
    @Column(name="groupop")
    private String groupop;
    @Column(name="ignoreempty")
    private Integer ignoreempty;
    @Column(name="leveltag")
    private String leveltag;
    @Column(name="levelvalue")
    private Integer levelvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsdedqcondid")
    private String ppsdedqcondid;
    @Column(name="ppsdedqcondname")
    private String ppsdedqcondname;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="psdedqcondid")
    private String psdedqcondid;
    @Column(name="psdedqcondname")
    private String psdedqcondname;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqjoinid")
    private String psdedqjoinid;
    @Column(name="psdedqjoinname")
    private String psdedqjoinname;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="psdedqpdcondid")
    private String psdedqpdcondid;
    @Column(name="psdedqpdcondname")
    private String psdedqpdcondname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysdbvfid")
    private String pssysdbvfid;
    @Column(name="pssysdbvfname")
    private String pssysdbvfname;
    @Column(name="psvartypeid")
    private String psvartypeid;
    @Column(name="psvartypename")
    private String psvartypename;
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
    private Integer objPSDBValueOPLock = new Integer(1);
    private PSDBValueOP psdbvalueop = null;
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objPPSDEDQCondLock = new Integer(1);
    private PSDEDQCond ppsdedqcond = null;
    private Integer objPSDEDQJoinLock = new Integer(1);
    private PSDEDQJoin psdedqjoin = null;
    private Integer objPSDEDQPDCondLock = new Integer(1);
    private PSDEDQPDCond psdedqpdcond = null;
    private Integer objPSDEFieldLock = new Integer(1);
    private PSDEField psdefield = null;
    private Integer objPSSysDBVFLock = new Integer(1);
    private PSSysDBVF pssysdbvf = null;
    private Integer objPSVarTypeLock = new Integer(1);
    private PSVarType psvartype = null;

    public void setCondTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtag = string;
        this.condtagDirtyFlag = true;
    }

    public String getCondTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondTag();
        }
        return this.condtag;
    }

    public boolean isCondTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTagDirty();
        }
        return this.condtagDirtyFlag;
    }

    public void resetCondTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondTag();
            return;
        }
        this.condtagDirtyFlag = false;
        this.condtag = null;
    }

    public void setCondTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtag2 = string;
        this.condtag2DirtyFlag = true;
    }

    public String getCondTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondTag2();
        }
        return this.condtag2;
    }

    public boolean isCondTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTag2Dirty();
        }
        return this.condtag2DirtyFlag;
    }

    public void resetCondTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondTag2();
            return;
        }
        this.condtag2DirtyFlag = false;
        this.condtag2 = null;
    }

    public void setCondType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtype = string;
        this.condtypeDirtyFlag = true;
    }

    public String getCondType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondType();
        }
        return this.condtype;
    }

    public boolean isCondTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTypeDirty();
        }
        return this.condtypeDirtyFlag;
    }

    public void resetCondType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondType();
            return;
        }
        this.condtypeDirtyFlag = false;
        this.condtype = null;
    }

    public void setCondValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condvalue = string;
        this.condvalueDirtyFlag = true;
    }

    public String getCondValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondValue();
        }
        return this.condvalue;
    }

    public boolean isCondValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondValueDirty();
        }
        return this.condvalueDirtyFlag;
    }

    public void resetCondValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondValue();
            return;
        }
        this.condvalueDirtyFlag = false;
        this.condvalue = null;
    }

    public void setCondValueText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondValueText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condvaluetext = string;
        this.condvaluetextDirtyFlag = true;
    }

    public String getCondValueText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondValueText();
        }
        return this.condvaluetext;
    }

    public boolean isCondValueTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondValueTextDirty();
        }
        return this.condvaluetextDirtyFlag;
    }

    public void resetCondValueText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondValueText();
            return;
        }
        this.condvaluetextDirtyFlag = false;
        this.condvaluetext = null;
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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
    }

    public void setGroupNotFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupNotFlag(n);
            return;
        }
        this.groupnotflag = n;
        this.groupnotflagDirtyFlag = true;
    }

    public Integer getGroupNotFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupNotFlag();
        }
        return this.groupnotflag;
    }

    public boolean isGroupNotFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupNotFlagDirty();
        }
        return this.groupnotflagDirtyFlag;
    }

    public void resetGroupNotFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupNotFlag();
            return;
        }
        this.groupnotflagDirtyFlag = false;
        this.groupnotflag = null;
    }

    public void setGroupOP(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupOP(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupop = string;
        this.groupopDirtyFlag = true;
    }

    public String getGroupOP() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupOP();
        }
        return this.groupop;
    }

    public boolean isGroupOPDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupOPDirty();
        }
        return this.groupopDirtyFlag;
    }

    public void resetGroupOP() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupOP();
            return;
        }
        this.groupopDirtyFlag = false;
        this.groupop = null;
    }

    public void setIgnoreEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreEmpty(n);
            return;
        }
        this.ignoreempty = n;
        this.ignoreemptyDirtyFlag = true;
    }

    public Integer getIgnoreEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreEmpty();
        }
        return this.ignoreempty;
    }

    public boolean isIgnoreEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreEmptyDirty();
        }
        return this.ignoreemptyDirtyFlag;
    }

    public void resetIgnoreEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreEmpty();
            return;
        }
        this.ignoreemptyDirtyFlag = false;
        this.ignoreempty = null;
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

    public void setPPSDEDQCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEDQCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdedqcondid = string;
        this.ppsdedqcondidDirtyFlag = true;
    }

    public String getPPSDEDQCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEDQCondId();
        }
        return this.ppsdedqcondid;
    }

    public boolean isPPSDEDQCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEDQCondIdDirty();
        }
        return this.ppsdedqcondidDirtyFlag;
    }

    public void resetPPSDEDQCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEDQCondId();
            return;
        }
        this.ppsdedqcondidDirtyFlag = false;
        this.ppsdedqcondid = null;
    }

    public void setPPSDEDQCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEDQCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdedqcondname = string;
        this.ppsdedqcondnameDirtyFlag = true;
    }

    public String getPPSDEDQCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEDQCondName();
        }
        return this.ppsdedqcondname;
    }

    public boolean isPPSDEDQCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEDQCondNameDirty();
        }
        return this.ppsdedqcondnameDirtyFlag;
    }

    public void resetPPSDEDQCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEDQCondName();
            return;
        }
        this.ppsdedqcondnameDirtyFlag = false;
        this.ppsdedqcondname = null;
    }

    public void setPSDBValueOPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopid = string;
        this.psdbvalueopidDirtyFlag = true;
    }

    public String getPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPId();
        }
        return this.psdbvalueopid;
    }

    public boolean isPSDBValueOPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPIdDirty();
        }
        return this.psdbvalueopidDirtyFlag;
    }

    public void resetPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPId();
            return;
        }
        this.psdbvalueopidDirtyFlag = false;
        this.psdbvalueopid = null;
    }

    public void setPSDBValueOPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopname = string;
        this.psdbvalueopnameDirtyFlag = true;
    }

    public String getPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPName();
        }
        return this.psdbvalueopname;
    }

    public boolean isPSDBValueOPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPNameDirty();
        }
        return this.psdbvalueopnameDirtyFlag;
    }

    public void resetPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPName();
            return;
        }
        this.psdbvalueopnameDirtyFlag = false;
        this.psdbvalueopname = null;
    }

    public void setPSDEDQCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcondid = string;
        this.psdedqcondidDirtyFlag = true;
    }

    public String getPSDEDQCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCondId();
        }
        return this.psdedqcondid;
    }

    public boolean isPSDEDQCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCondIdDirty();
        }
        return this.psdedqcondidDirtyFlag;
    }

    public void resetPSDEDQCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCondId();
            return;
        }
        this.psdedqcondidDirtyFlag = false;
        this.psdedqcondid = null;
    }

    public void setPSDEDQCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcondname = string;
        this.psdedqcondnameDirtyFlag = true;
    }

    public String getPSDEDQCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCondName();
        }
        return this.psdedqcondname;
    }

    public boolean isPSDEDQCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCondNameDirty();
        }
        return this.psdedqcondnameDirtyFlag;
    }

    public void resetPSDEDQCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCondName();
            return;
        }
        this.psdedqcondnameDirtyFlag = false;
        this.psdedqcondname = null;
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

    public void setPSDEDQPDCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQPDCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqpdcondid = string;
        this.psdedqpdcondidDirtyFlag = true;
    }

    public String getPSDEDQPDCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQPDCondId();
        }
        return this.psdedqpdcondid;
    }

    public boolean isPSDEDQPDCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQPDCondIdDirty();
        }
        return this.psdedqpdcondidDirtyFlag;
    }

    public void resetPSDEDQPDCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQPDCondId();
            return;
        }
        this.psdedqpdcondidDirtyFlag = false;
        this.psdedqpdcondid = null;
    }

    public void setPSDEDQPDCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQPDCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqpdcondname = string;
        this.psdedqpdcondnameDirtyFlag = true;
    }

    public String getPSDEDQPDCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQPDCondName();
        }
        return this.psdedqpdcondname;
    }

    public boolean isPSDEDQPDCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQPDCondNameDirty();
        }
        return this.psdedqpdcondnameDirtyFlag;
    }

    public void resetPSDEDQPDCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQPDCondName();
            return;
        }
        this.psdedqpdcondnameDirtyFlag = false;
        this.psdedqpdcondname = null;
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

    public void setPSSysDBVFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfid = string;
        this.pssysdbvfidDirtyFlag = true;
    }

    public String getPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFId();
        }
        return this.pssysdbvfid;
    }

    public boolean isPSSysDBVFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFIdDirty();
        }
        return this.pssysdbvfidDirtyFlag;
    }

    public void resetPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFId();
            return;
        }
        this.pssysdbvfidDirtyFlag = false;
        this.pssysdbvfid = null;
    }

    public void setPSSysDBVFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfname = string;
        this.pssysdbvfnameDirtyFlag = true;
    }

    public String getPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFName();
        }
        return this.pssysdbvfname;
    }

    public boolean isPSSysDBVFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFNameDirty();
        }
        return this.pssysdbvfnameDirtyFlag;
    }

    public void resetPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFName();
            return;
        }
        this.pssysdbvfnameDirtyFlag = false;
        this.pssysdbvfname = null;
    }

    public void setPSVARTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVARTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvartypeid = string;
        this.psvartypeidDirtyFlag = true;
    }

    public String getPSVARTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVARTypeId();
        }
        return this.psvartypeid;
    }

    public boolean isPSVARTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVARTypeIdDirty();
        }
        return this.psvartypeidDirtyFlag;
    }

    public void resetPSVARTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVARTypeId();
            return;
        }
        this.psvartypeidDirtyFlag = false;
        this.psvartypeid = null;
    }

    public void setPSVARTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVARTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvartypename = string;
        this.psvartypenameDirtyFlag = true;
    }

    public String getPSVARTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVARTypeName();
        }
        return this.psvartypename;
    }

    public boolean isPSVARTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVARTypeNameDirty();
        }
        return this.psvartypenameDirtyFlag;
    }

    public void resetPSVARTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVARTypeName();
            return;
        }
        this.psvartypenameDirtyFlag = false;
        this.psvartypename = null;
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
        PSDEDQCondBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDQCondBase pSDEDQCondBase) {
        pSDEDQCondBase.resetCondTag();
        pSDEDQCondBase.resetCondTag2();
        pSDEDQCondBase.resetCondType();
        pSDEDQCondBase.resetCondValue();
        pSDEDQCondBase.resetCondValueText();
        pSDEDQCondBase.resetCreateDate();
        pSDEDQCondBase.resetCreateMan();
        pSDEDQCondBase.resetCustomCond();
        pSDEDQCondBase.resetCustomType();
        pSDEDQCondBase.resetGroupNotFlag();
        pSDEDQCondBase.resetGroupOP();
        pSDEDQCondBase.resetIgnoreEmpty();
        pSDEDQCondBase.resetLevelTag();
        pSDEDQCondBase.resetLevelValue();
        pSDEDQCondBase.resetMemo();
        pSDEDQCondBase.resetOrderValue();
        pSDEDQCondBase.resetPPSDEDQCondId();
        pSDEDQCondBase.resetPPSDEDQCondName();
        pSDEDQCondBase.resetPSDBValueOPId();
        pSDEDQCondBase.resetPSDBValueOPName();
        pSDEDQCondBase.resetPSDEDQCondId();
        pSDEDQCondBase.resetPSDEDQCondName();
        pSDEDQCondBase.resetPSDEDQId();
        pSDEDQCondBase.resetPSDEDQJoinId();
        pSDEDQCondBase.resetPSDEDQJoinName();
        pSDEDQCondBase.resetPSDEDQName();
        pSDEDQCondBase.resetPSDEDQPDCondId();
        pSDEDQCondBase.resetPSDEDQPDCondName();
        pSDEDQCondBase.resetPSDEFId();
        pSDEDQCondBase.resetPSDEFName();
        pSDEDQCondBase.resetPSDEId();
        pSDEDQCondBase.resetPSSysDBVFId();
        pSDEDQCondBase.resetPSSysDBVFName();
        pSDEDQCondBase.resetPSVARTypeId();
        pSDEDQCondBase.resetPSVARTypeName();
        pSDEDQCondBase.resetUpdateDate();
        pSDEDQCondBase.resetUpdateMan();
        pSDEDQCondBase.resetUserCat();
        pSDEDQCondBase.resetUserTag();
        pSDEDQCondBase.resetUserTag2();
        pSDEDQCondBase.resetUserTag3();
        pSDEDQCondBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondTagDirty()) {
            hashMap.put(FIELD_CONDTAG, this.getCondTag());
        }
        if (!bl || this.isCondTag2Dirty()) {
            hashMap.put(FIELD_CONDTAG2, this.getCondTag2());
        }
        if (!bl || this.isCondTypeDirty()) {
            hashMap.put(FIELD_CONDTYPE, this.getCondType());
        }
        if (!bl || this.isCondValueDirty()) {
            hashMap.put(FIELD_CONDVALUE, this.getCondValue());
        }
        if (!bl || this.isCondValueTextDirty()) {
            hashMap.put(FIELD_CONDVALUETEXT, this.getCondValueText());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isGroupNotFlagDirty()) {
            hashMap.put(FIELD_GROUPNOTFLAG, this.getGroupNotFlag());
        }
        if (!bl || this.isGroupOPDirty()) {
            hashMap.put(FIELD_GROUPOP, this.getGroupOP());
        }
        if (!bl || this.isIgnoreEmptyDirty()) {
            hashMap.put(FIELD_IGNOREEMPTY, this.getIgnoreEmpty());
        }
        if (!bl || this.isLevelTagDirty()) {
            hashMap.put(FIELD_LEVELTAG, this.getLevelTag());
        }
        if (!bl || this.isLevelValueDirty()) {
            hashMap.put(FIELD_LEVELVALUE, this.getLevelValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSDEDQCondIdDirty()) {
            hashMap.put(FIELD_PPSDEDQCONDID, this.getPPSDEDQCondId());
        }
        if (!bl || this.isPPSDEDQCondNameDirty()) {
            hashMap.put(FIELD_PPSDEDQCONDNAME, this.getPPSDEDQCondName());
        }
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
        }
        if (!bl || this.isPSDEDQCondIdDirty()) {
            hashMap.put(FIELD_PSDEDQCONDID, this.getPSDEDQCondId());
        }
        if (!bl || this.isPSDEDQCondNameDirty()) {
            hashMap.put(FIELD_PSDEDQCONDNAME, this.getPSDEDQCondName());
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
        if (!bl || this.isPSDEDQPDCondIdDirty()) {
            hashMap.put(FIELD_PSDEDQPDCONDID, this.getPSDEDQPDCondId());
        }
        if (!bl || this.isPSDEDQPDCondNameDirty()) {
            hashMap.put(FIELD_PSDEDQPDCONDNAME, this.getPSDEDQPDCondName());
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
        if (!bl || this.isPSSysDBVFIdDirty()) {
            hashMap.put(FIELD_PSSYSDBVFID, this.getPSSysDBVFId());
        }
        if (!bl || this.isPSSysDBVFNameDirty()) {
            hashMap.put(FIELD_PSSYSDBVFNAME, this.getPSSysDBVFName());
        }
        if (!bl || this.isPSVARTypeIdDirty()) {
            hashMap.put(FIELD_PSVARTYPEID, this.getPSVARTypeId());
        }
        if (!bl || this.isPSVARTypeNameDirty()) {
            hashMap.put(FIELD_PSVARTYPENAME, this.getPSVARTypeName());
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
        return PSDEDQCondBase.get(this, n);
    }

    private static Object get(PSDEDQCondBase pSDEDQCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCondBase.getCondTag();
            }
            case 1: {
                return pSDEDQCondBase.getCondTag2();
            }
            case 2: {
                return pSDEDQCondBase.getCondType();
            }
            case 3: {
                return pSDEDQCondBase.getCondValue();
            }
            case 4: {
                return pSDEDQCondBase.getCondValueText();
            }
            case 5: {
                return pSDEDQCondBase.getCreateDate();
            }
            case 6: {
                return pSDEDQCondBase.getCreateMan();
            }
            case 7: {
                return pSDEDQCondBase.getCustomCond();
            }
            case 8: {
                return pSDEDQCondBase.getCustomType();
            }
            case 9: {
                return pSDEDQCondBase.getGroupNotFlag();
            }
            case 10: {
                return pSDEDQCondBase.getGroupOP();
            }
            case 11: {
                return pSDEDQCondBase.getIgnoreEmpty();
            }
            case 12: {
                return pSDEDQCondBase.getLevelTag();
            }
            case 13: {
                return pSDEDQCondBase.getLevelValue();
            }
            case 14: {
                return pSDEDQCondBase.getMemo();
            }
            case 15: {
                return pSDEDQCondBase.getOrderValue();
            }
            case 16: {
                return pSDEDQCondBase.getPPSDEDQCondId();
            }
            case 17: {
                return pSDEDQCondBase.getPPSDEDQCondName();
            }
            case 18: {
                return pSDEDQCondBase.getPSDBValueOPId();
            }
            case 19: {
                return pSDEDQCondBase.getPSDBValueOPName();
            }
            case 20: {
                return pSDEDQCondBase.getPSDEDQCondId();
            }
            case 21: {
                return pSDEDQCondBase.getPSDEDQCondName();
            }
            case 22: {
                return pSDEDQCondBase.getPSDEDQId();
            }
            case 23: {
                return pSDEDQCondBase.getPSDEDQJoinId();
            }
            case 24: {
                return pSDEDQCondBase.getPSDEDQJoinName();
            }
            case 25: {
                return pSDEDQCondBase.getPSDEDQName();
            }
            case 26: {
                return pSDEDQCondBase.getPSDEDQPDCondId();
            }
            case 27: {
                return pSDEDQCondBase.getPSDEDQPDCondName();
            }
            case 28: {
                return pSDEDQCondBase.getPSDEFId();
            }
            case 29: {
                return pSDEDQCondBase.getPSDEFName();
            }
            case 30: {
                return pSDEDQCondBase.getPSDEId();
            }
            case 31: {
                return pSDEDQCondBase.getPSSysDBVFId();
            }
            case 32: {
                return pSDEDQCondBase.getPSSysDBVFName();
            }
            case 33: {
                return pSDEDQCondBase.getPSVARTypeId();
            }
            case 34: {
                return pSDEDQCondBase.getPSVARTypeName();
            }
            case 35: {
                return pSDEDQCondBase.getUpdateDate();
            }
            case 36: {
                return pSDEDQCondBase.getUpdateMan();
            }
            case 37: {
                return pSDEDQCondBase.getUserCat();
            }
            case 38: {
                return pSDEDQCondBase.getUserTag();
            }
            case 39: {
                return pSDEDQCondBase.getUserTag2();
            }
            case 40: {
                return pSDEDQCondBase.getUserTag3();
            }
            case 41: {
                return pSDEDQCondBase.getUserTag4();
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
        PSDEDQCondBase.set(this, n, object);
    }

    private static void set(PSDEDQCondBase pSDEDQCondBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQCondBase.setCondTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDQCondBase.setCondTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDQCondBase.setCondType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDQCondBase.setCondValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDQCondBase.setCondValueText(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDQCondBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDEDQCondBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDQCondBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDQCondBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDQCondBase.setGroupNotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEDQCondBase.setGroupOP(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDQCondBase.setIgnoreEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDQCondBase.setLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDQCondBase.setLevelValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEDQCondBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDQCondBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEDQCondBase.setPPSDEDQCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDQCondBase.setPPSDEDQCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDQCondBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDQCondBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDQCondBase.setPSDEDQCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDQCondBase.setPSDEDQCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDQCondBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDQCondBase.setPSDEDQJoinId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDQCondBase.setPSDEDQJoinName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDQCondBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDQCondBase.setPSDEDQPDCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDQCondBase.setPSDEDQPDCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDQCondBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDQCondBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDQCondBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDQCondBase.setPSSysDBVFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDQCondBase.setPSSysDBVFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDQCondBase.setPSVARTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDQCondBase.setPSVARTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDQCondBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 36: {
                pSDEDQCondBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEDQCondBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDQCondBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEDQCondBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDQCondBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDQCondBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEDQCondBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDQCondBase pSDEDQCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCondBase.getCondTag() == null;
            }
            case 1: {
                return pSDEDQCondBase.getCondTag2() == null;
            }
            case 2: {
                return pSDEDQCondBase.getCondType() == null;
            }
            case 3: {
                return pSDEDQCondBase.getCondValue() == null;
            }
            case 4: {
                return pSDEDQCondBase.getCondValueText() == null;
            }
            case 5: {
                return pSDEDQCondBase.getCreateDate() == null;
            }
            case 6: {
                return pSDEDQCondBase.getCreateMan() == null;
            }
            case 7: {
                return pSDEDQCondBase.getCustomCond() == null;
            }
            case 8: {
                return pSDEDQCondBase.getCustomType() == null;
            }
            case 9: {
                return pSDEDQCondBase.getGroupNotFlag() == null;
            }
            case 10: {
                return pSDEDQCondBase.getGroupOP() == null;
            }
            case 11: {
                return pSDEDQCondBase.getIgnoreEmpty() == null;
            }
            case 12: {
                return pSDEDQCondBase.getLevelTag() == null;
            }
            case 13: {
                return pSDEDQCondBase.getLevelValue() == null;
            }
            case 14: {
                return pSDEDQCondBase.getMemo() == null;
            }
            case 15: {
                return pSDEDQCondBase.getOrderValue() == null;
            }
            case 16: {
                return pSDEDQCondBase.getPPSDEDQCondId() == null;
            }
            case 17: {
                return pSDEDQCondBase.getPPSDEDQCondName() == null;
            }
            case 18: {
                return pSDEDQCondBase.getPSDBValueOPId() == null;
            }
            case 19: {
                return pSDEDQCondBase.getPSDBValueOPName() == null;
            }
            case 20: {
                return pSDEDQCondBase.getPSDEDQCondId() == null;
            }
            case 21: {
                return pSDEDQCondBase.getPSDEDQCondName() == null;
            }
            case 22: {
                return pSDEDQCondBase.getPSDEDQId() == null;
            }
            case 23: {
                return pSDEDQCondBase.getPSDEDQJoinId() == null;
            }
            case 24: {
                return pSDEDQCondBase.getPSDEDQJoinName() == null;
            }
            case 25: {
                return pSDEDQCondBase.getPSDEDQName() == null;
            }
            case 26: {
                return pSDEDQCondBase.getPSDEDQPDCondId() == null;
            }
            case 27: {
                return pSDEDQCondBase.getPSDEDQPDCondName() == null;
            }
            case 28: {
                return pSDEDQCondBase.getPSDEFId() == null;
            }
            case 29: {
                return pSDEDQCondBase.getPSDEFName() == null;
            }
            case 30: {
                return pSDEDQCondBase.getPSDEId() == null;
            }
            case 31: {
                return pSDEDQCondBase.getPSSysDBVFId() == null;
            }
            case 32: {
                return pSDEDQCondBase.getPSSysDBVFName() == null;
            }
            case 33: {
                return pSDEDQCondBase.getPSVARTypeId() == null;
            }
            case 34: {
                return pSDEDQCondBase.getPSVARTypeName() == null;
            }
            case 35: {
                return pSDEDQCondBase.getUpdateDate() == null;
            }
            case 36: {
                return pSDEDQCondBase.getUpdateMan() == null;
            }
            case 37: {
                return pSDEDQCondBase.getUserCat() == null;
            }
            case 38: {
                return pSDEDQCondBase.getUserTag() == null;
            }
            case 39: {
                return pSDEDQCondBase.getUserTag2() == null;
            }
            case 40: {
                return pSDEDQCondBase.getUserTag3() == null;
            }
            case 41: {
                return pSDEDQCondBase.getUserTag4() == null;
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
        return PSDEDQCondBase.contains(this, n);
    }

    private static boolean contains(PSDEDQCondBase pSDEDQCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCondBase.isCondTagDirty();
            }
            case 1: {
                return pSDEDQCondBase.isCondTag2Dirty();
            }
            case 2: {
                return pSDEDQCondBase.isCondTypeDirty();
            }
            case 3: {
                return pSDEDQCondBase.isCondValueDirty();
            }
            case 4: {
                return pSDEDQCondBase.isCondValueTextDirty();
            }
            case 5: {
                return pSDEDQCondBase.isCreateDateDirty();
            }
            case 6: {
                return pSDEDQCondBase.isCreateManDirty();
            }
            case 7: {
                return pSDEDQCondBase.isCustomCondDirty();
            }
            case 8: {
                return pSDEDQCondBase.isCustomTypeDirty();
            }
            case 9: {
                return pSDEDQCondBase.isGroupNotFlagDirty();
            }
            case 10: {
                return pSDEDQCondBase.isGroupOPDirty();
            }
            case 11: {
                return pSDEDQCondBase.isIgnoreEmptyDirty();
            }
            case 12: {
                return pSDEDQCondBase.isLevelTagDirty();
            }
            case 13: {
                return pSDEDQCondBase.isLevelValueDirty();
            }
            case 14: {
                return pSDEDQCondBase.isMemoDirty();
            }
            case 15: {
                return pSDEDQCondBase.isOrderValueDirty();
            }
            case 16: {
                return pSDEDQCondBase.isPPSDEDQCondIdDirty();
            }
            case 17: {
                return pSDEDQCondBase.isPPSDEDQCondNameDirty();
            }
            case 18: {
                return pSDEDQCondBase.isPSDBValueOPIdDirty();
            }
            case 19: {
                return pSDEDQCondBase.isPSDBValueOPNameDirty();
            }
            case 20: {
                return pSDEDQCondBase.isPSDEDQCondIdDirty();
            }
            case 21: {
                return pSDEDQCondBase.isPSDEDQCondNameDirty();
            }
            case 22: {
                return pSDEDQCondBase.isPSDEDQIdDirty();
            }
            case 23: {
                return pSDEDQCondBase.isPSDEDQJoinIdDirty();
            }
            case 24: {
                return pSDEDQCondBase.isPSDEDQJoinNameDirty();
            }
            case 25: {
                return pSDEDQCondBase.isPSDEDQNameDirty();
            }
            case 26: {
                return pSDEDQCondBase.isPSDEDQPDCondIdDirty();
            }
            case 27: {
                return pSDEDQCondBase.isPSDEDQPDCondNameDirty();
            }
            case 28: {
                return pSDEDQCondBase.isPSDEFIdDirty();
            }
            case 29: {
                return pSDEDQCondBase.isPSDEFNameDirty();
            }
            case 30: {
                return pSDEDQCondBase.isPSDEIdDirty();
            }
            case 31: {
                return pSDEDQCondBase.isPSSysDBVFIdDirty();
            }
            case 32: {
                return pSDEDQCondBase.isPSSysDBVFNameDirty();
            }
            case 33: {
                return pSDEDQCondBase.isPSVARTypeIdDirty();
            }
            case 34: {
                return pSDEDQCondBase.isPSVARTypeNameDirty();
            }
            case 35: {
                return pSDEDQCondBase.isUpdateDateDirty();
            }
            case 36: {
                return pSDEDQCondBase.isUpdateManDirty();
            }
            case 37: {
                return pSDEDQCondBase.isUserCatDirty();
            }
            case 38: {
                return pSDEDQCondBase.isUserTagDirty();
            }
            case 39: {
                return pSDEDQCondBase.isUserTag2Dirty();
            }
            case 40: {
                return pSDEDQCondBase.isUserTag3Dirty();
            }
            case 41: {
                return pSDEDQCondBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDQCondBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDQCondBase pSDEDQCondBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDQCondBase.getCondTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtag", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCondTag()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getCondTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtag2", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCondTag2()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getCondType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtype", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCondType()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getCondValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvalue", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCondValue()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getCondValueText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvaluetext", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCondValueText()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getGroupNotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupnotflag", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getGroupNotFlag()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getGroupOP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupop", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getGroupOP()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getIgnoreEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreempty", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getIgnoreEmpty()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leveltag", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getLevelTag()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getLevelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelvalue", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getLevelValue()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPPSDEDQCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdedqcondid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPPSDEDQCondId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPPSDEDQCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdedqcondname", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPPSDEDQCondName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEDQCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcondid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEDQCondId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEDQCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcondname", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEDQCondName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEDQJoinId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqjoinid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEDQJoinId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEDQJoinName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqjoinname", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEDQJoinName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEDQPDCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqpdcondid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEDQPDCondId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEDQPDCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqpdcondname", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEDQPDCondName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSSysDBVFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSSysDBVFId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSSysDBVFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfname", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSSysDBVFName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSVARTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvartypeid", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSVARTypeId()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getPSVARTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvartypename", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getPSVARTypeName()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDQCondBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDQCondBase.getJSONValue((Object)pSDEDQCondBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDQCondBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDQCondBase pSDEDQCondBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDQCondBase.getCondTag() != null) {
            object = pSDEDQCondBase.getCondTag();
            xmlNode.setAttribute(FIELD_CONDTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDQCondBase.getCondTag2() != null) {
            object = pSDEDQCondBase.getCondTag2();
            xmlNode.setAttribute(FIELD_CONDTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDQCondBase.getCondType() != null) {
            object = pSDEDQCondBase.getCondType();
            xmlNode.setAttribute(FIELD_CONDTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDQCondBase.getCondValue() != null) {
            object = pSDEDQCondBase.getCondValue();
            xmlNode.setAttribute(FIELD_CONDVALUE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDQCondBase.getCondValueText() != null) {
            object = pSDEDQCondBase.getCondValueText();
            xmlNode.setAttribute(FIELD_CONDVALUETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getCreateDate() != null) {
            object = pSDEDQCondBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQCondBase.getCreateMan() != null) {
            object = pSDEDQCondBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getCustomCond() != null) {
            object = pSDEDQCondBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getCustomType() != null) {
            object = pSDEDQCondBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getGroupNotFlag() != null) {
            object = pSDEDQCondBase.getGroupNotFlag();
            xmlNode.setAttribute(FIELD_GROUPNOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQCondBase.getGroupOP() != null) {
            object = pSDEDQCondBase.getGroupOP();
            xmlNode.setAttribute(FIELD_GROUPOP, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getIgnoreEmpty() != null) {
            object = pSDEDQCondBase.getIgnoreEmpty();
            xmlNode.setAttribute(FIELD_IGNOREEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQCondBase.getLevelTag() != null) {
            object = pSDEDQCondBase.getLevelTag();
            xmlNode.setAttribute(FIELD_LEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getLevelValue() != null) {
            object = pSDEDQCondBase.getLevelValue();
            xmlNode.setAttribute(FIELD_LEVELVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQCondBase.getMemo() != null) {
            object = pSDEDQCondBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getOrderValue() != null) {
            object = pSDEDQCondBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQCondBase.getPPSDEDQCondId() != null) {
            object = pSDEDQCondBase.getPPSDEDQCondId();
            xmlNode.setAttribute(FIELD_PPSDEDQCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPPSDEDQCondName() != null) {
            object = pSDEDQCondBase.getPPSDEDQCondName();
            xmlNode.setAttribute(FIELD_PPSDEDQCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDBValueOPId() != null) {
            object = pSDEDQCondBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDBValueOPName() != null) {
            object = pSDEDQCondBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEDQCondId() != null) {
            object = pSDEDQCondBase.getPSDEDQCondId();
            xmlNode.setAttribute(FIELD_PSDEDQCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEDQCondName() != null) {
            object = pSDEDQCondBase.getPSDEDQCondName();
            xmlNode.setAttribute(FIELD_PSDEDQCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEDQId() != null) {
            object = pSDEDQCondBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEDQJoinId() != null) {
            object = pSDEDQCondBase.getPSDEDQJoinId();
            xmlNode.setAttribute(FIELD_PSDEDQJOINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEDQJoinName() != null) {
            object = pSDEDQCondBase.getPSDEDQJoinName();
            xmlNode.setAttribute(FIELD_PSDEDQJOINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEDQName() != null) {
            object = pSDEDQCondBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEDQPDCondId() != null) {
            object = pSDEDQCondBase.getPSDEDQPDCondId();
            xmlNode.setAttribute(FIELD_PSDEDQPDCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEDQPDCondName() != null) {
            object = pSDEDQCondBase.getPSDEDQPDCondName();
            xmlNode.setAttribute(FIELD_PSDEDQPDCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEFId() != null) {
            object = pSDEDQCondBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEFName() != null) {
            object = pSDEDQCondBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSDEId() != null) {
            object = pSDEDQCondBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSSysDBVFId() != null) {
            object = pSDEDQCondBase.getPSSysDBVFId();
            xmlNode.setAttribute(FIELD_PSSYSDBVFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSSysDBVFName() != null) {
            object = pSDEDQCondBase.getPSSysDBVFName();
            xmlNode.setAttribute(FIELD_PSSYSDBVFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSVARTypeId() != null) {
            object = pSDEDQCondBase.getPSVARTypeId();
            xmlNode.setAttribute(FIELD_PSVARTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getPSVARTypeName() != null) {
            object = pSDEDQCondBase.getPSVARTypeName();
            xmlNode.setAttribute(FIELD_PSVARTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getUpdateDate() != null) {
            object = pSDEDQCondBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQCondBase.getUpdateMan() != null) {
            object = pSDEDQCondBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getUserCat() != null) {
            object = pSDEDQCondBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getUserTag() != null) {
            object = pSDEDQCondBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getUserTag2() != null) {
            object = pSDEDQCondBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getUserTag3() != null) {
            object = pSDEDQCondBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCondBase.getUserTag4() != null) {
            object = pSDEDQCondBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDQCondBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDQCondBase pSDEDQCondBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDQCondBase.isCondTagDirty() && (bl || pSDEDQCondBase.getCondTag() != null)) {
            iDataObject.set(FIELD_CONDTAG, (Object)pSDEDQCondBase.getCondTag());
        }
        if (pSDEDQCondBase.isCondTag2Dirty() && (bl || pSDEDQCondBase.getCondTag2() != null)) {
            iDataObject.set(FIELD_CONDTAG2, (Object)pSDEDQCondBase.getCondTag2());
        }
        if (pSDEDQCondBase.isCondTypeDirty() && (bl || pSDEDQCondBase.getCondType() != null)) {
            iDataObject.set(FIELD_CONDTYPE, (Object)pSDEDQCondBase.getCondType());
        }
        if (pSDEDQCondBase.isCondValueDirty() && (bl || pSDEDQCondBase.getCondValue() != null)) {
            iDataObject.set(FIELD_CONDVALUE, (Object)pSDEDQCondBase.getCondValue());
        }
        if (pSDEDQCondBase.isCondValueTextDirty() && (bl || pSDEDQCondBase.getCondValueText() != null)) {
            iDataObject.set(FIELD_CONDVALUETEXT, (Object)pSDEDQCondBase.getCondValueText());
        }
        if (pSDEDQCondBase.isCreateDateDirty() && (bl || pSDEDQCondBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDQCondBase.getCreateDate());
        }
        if (pSDEDQCondBase.isCreateManDirty() && (bl || pSDEDQCondBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDQCondBase.getCreateMan());
        }
        if (pSDEDQCondBase.isCustomCondDirty() && (bl || pSDEDQCondBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDEDQCondBase.getCustomCond());
        }
        if (pSDEDQCondBase.isCustomTypeDirty() && (bl || pSDEDQCondBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDEDQCondBase.getCustomType());
        }
        if (pSDEDQCondBase.isGroupNotFlagDirty() && (bl || pSDEDQCondBase.getGroupNotFlag() != null)) {
            iDataObject.set(FIELD_GROUPNOTFLAG, (Object)pSDEDQCondBase.getGroupNotFlag());
        }
        if (pSDEDQCondBase.isGroupOPDirty() && (bl || pSDEDQCondBase.getGroupOP() != null)) {
            iDataObject.set(FIELD_GROUPOP, (Object)pSDEDQCondBase.getGroupOP());
        }
        if (pSDEDQCondBase.isIgnoreEmptyDirty() && (bl || pSDEDQCondBase.getIgnoreEmpty() != null)) {
            iDataObject.set(FIELD_IGNOREEMPTY, (Object)pSDEDQCondBase.getIgnoreEmpty());
        }
        if (pSDEDQCondBase.isLevelTagDirty() && (bl || pSDEDQCondBase.getLevelTag() != null)) {
            iDataObject.set(FIELD_LEVELTAG, (Object)pSDEDQCondBase.getLevelTag());
        }
        if (pSDEDQCondBase.isLevelValueDirty() && (bl || pSDEDQCondBase.getLevelValue() != null)) {
            iDataObject.set(FIELD_LEVELVALUE, (Object)pSDEDQCondBase.getLevelValue());
        }
        if (pSDEDQCondBase.isMemoDirty() && (bl || pSDEDQCondBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDQCondBase.getMemo());
        }
        if (pSDEDQCondBase.isOrderValueDirty() && (bl || pSDEDQCondBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDQCondBase.getOrderValue());
        }
        if (pSDEDQCondBase.isPPSDEDQCondIdDirty() && (bl || pSDEDQCondBase.getPPSDEDQCondId() != null)) {
            iDataObject.set(FIELD_PPSDEDQCONDID, (Object)pSDEDQCondBase.getPPSDEDQCondId());
        }
        if (pSDEDQCondBase.isPPSDEDQCondNameDirty() && (bl || pSDEDQCondBase.getPPSDEDQCondName() != null)) {
            iDataObject.set(FIELD_PPSDEDQCONDNAME, (Object)pSDEDQCondBase.getPPSDEDQCondName());
        }
        if (pSDEDQCondBase.isPSDBValueOPIdDirty() && (bl || pSDEDQCondBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSDEDQCondBase.getPSDBValueOPId());
        }
        if (pSDEDQCondBase.isPSDBValueOPNameDirty() && (bl || pSDEDQCondBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSDEDQCondBase.getPSDBValueOPName());
        }
        if (pSDEDQCondBase.isPSDEDQCondIdDirty() && (bl || pSDEDQCondBase.getPSDEDQCondId() != null)) {
            iDataObject.set(FIELD_PSDEDQCONDID, (Object)pSDEDQCondBase.getPSDEDQCondId());
        }
        if (pSDEDQCondBase.isPSDEDQCondNameDirty() && (bl || pSDEDQCondBase.getPSDEDQCondName() != null)) {
            iDataObject.set(FIELD_PSDEDQCONDNAME, (Object)pSDEDQCondBase.getPSDEDQCondName());
        }
        if (pSDEDQCondBase.isPSDEDQIdDirty() && (bl || pSDEDQCondBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDEDQCondBase.getPSDEDQId());
        }
        if (pSDEDQCondBase.isPSDEDQJoinIdDirty() && (bl || pSDEDQCondBase.getPSDEDQJoinId() != null)) {
            iDataObject.set(FIELD_PSDEDQJOINID, (Object)pSDEDQCondBase.getPSDEDQJoinId());
        }
        if (pSDEDQCondBase.isPSDEDQJoinNameDirty() && (bl || pSDEDQCondBase.getPSDEDQJoinName() != null)) {
            iDataObject.set(FIELD_PSDEDQJOINNAME, (Object)pSDEDQCondBase.getPSDEDQJoinName());
        }
        if (pSDEDQCondBase.isPSDEDQNameDirty() && (bl || pSDEDQCondBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDEDQCondBase.getPSDEDQName());
        }
        if (pSDEDQCondBase.isPSDEDQPDCondIdDirty() && (bl || pSDEDQCondBase.getPSDEDQPDCondId() != null)) {
            iDataObject.set(FIELD_PSDEDQPDCONDID, (Object)pSDEDQCondBase.getPSDEDQPDCondId());
        }
        if (pSDEDQCondBase.isPSDEDQPDCondNameDirty() && (bl || pSDEDQCondBase.getPSDEDQPDCondName() != null)) {
            iDataObject.set(FIELD_PSDEDQPDCONDNAME, (Object)pSDEDQCondBase.getPSDEDQPDCondName());
        }
        if (pSDEDQCondBase.isPSDEFIdDirty() && (bl || pSDEDQCondBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEDQCondBase.getPSDEFId());
        }
        if (pSDEDQCondBase.isPSDEFNameDirty() && (bl || pSDEDQCondBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEDQCondBase.getPSDEFName());
        }
        if (pSDEDQCondBase.isPSDEIdDirty() && (bl || pSDEDQCondBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDQCondBase.getPSDEId());
        }
        if (pSDEDQCondBase.isPSSysDBVFIdDirty() && (bl || pSDEDQCondBase.getPSSysDBVFId() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFID, (Object)pSDEDQCondBase.getPSSysDBVFId());
        }
        if (pSDEDQCondBase.isPSSysDBVFNameDirty() && (bl || pSDEDQCondBase.getPSSysDBVFName() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFNAME, (Object)pSDEDQCondBase.getPSSysDBVFName());
        }
        if (pSDEDQCondBase.isPSVARTypeIdDirty() && (bl || pSDEDQCondBase.getPSVARTypeId() != null)) {
            iDataObject.set(FIELD_PSVARTYPEID, (Object)pSDEDQCondBase.getPSVARTypeId());
        }
        if (pSDEDQCondBase.isPSVARTypeNameDirty() && (bl || pSDEDQCondBase.getPSVARTypeName() != null)) {
            iDataObject.set(FIELD_PSVARTYPENAME, (Object)pSDEDQCondBase.getPSVARTypeName());
        }
        if (pSDEDQCondBase.isUpdateDateDirty() && (bl || pSDEDQCondBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDQCondBase.getUpdateDate());
        }
        if (pSDEDQCondBase.isUpdateManDirty() && (bl || pSDEDQCondBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDQCondBase.getUpdateMan());
        }
        if (pSDEDQCondBase.isUserCatDirty() && (bl || pSDEDQCondBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDQCondBase.getUserCat());
        }
        if (pSDEDQCondBase.isUserTagDirty() && (bl || pSDEDQCondBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDQCondBase.getUserTag());
        }
        if (pSDEDQCondBase.isUserTag2Dirty() && (bl || pSDEDQCondBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDQCondBase.getUserTag2());
        }
        if (pSDEDQCondBase.isUserTag3Dirty() && (bl || pSDEDQCondBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDQCondBase.getUserTag3());
        }
        if (pSDEDQCondBase.isUserTag4Dirty() && (bl || pSDEDQCondBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDQCondBase.getUserTag4());
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
        return PSDEDQCondBase.remove(this, n);
    }

    private static boolean remove(PSDEDQCondBase pSDEDQCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQCondBase.resetCondTag();
                return true;
            }
            case 1: {
                pSDEDQCondBase.resetCondTag2();
                return true;
            }
            case 2: {
                pSDEDQCondBase.resetCondType();
                return true;
            }
            case 3: {
                pSDEDQCondBase.resetCondValue();
                return true;
            }
            case 4: {
                pSDEDQCondBase.resetCondValueText();
                return true;
            }
            case 5: {
                pSDEDQCondBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDEDQCondBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDEDQCondBase.resetCustomCond();
                return true;
            }
            case 8: {
                pSDEDQCondBase.resetCustomType();
                return true;
            }
            case 9: {
                pSDEDQCondBase.resetGroupNotFlag();
                return true;
            }
            case 10: {
                pSDEDQCondBase.resetGroupOP();
                return true;
            }
            case 11: {
                pSDEDQCondBase.resetIgnoreEmpty();
                return true;
            }
            case 12: {
                pSDEDQCondBase.resetLevelTag();
                return true;
            }
            case 13: {
                pSDEDQCondBase.resetLevelValue();
                return true;
            }
            case 14: {
                pSDEDQCondBase.resetMemo();
                return true;
            }
            case 15: {
                pSDEDQCondBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSDEDQCondBase.resetPPSDEDQCondId();
                return true;
            }
            case 17: {
                pSDEDQCondBase.resetPPSDEDQCondName();
                return true;
            }
            case 18: {
                pSDEDQCondBase.resetPSDBValueOPId();
                return true;
            }
            case 19: {
                pSDEDQCondBase.resetPSDBValueOPName();
                return true;
            }
            case 20: {
                pSDEDQCondBase.resetPSDEDQCondId();
                return true;
            }
            case 21: {
                pSDEDQCondBase.resetPSDEDQCondName();
                return true;
            }
            case 22: {
                pSDEDQCondBase.resetPSDEDQId();
                return true;
            }
            case 23: {
                pSDEDQCondBase.resetPSDEDQJoinId();
                return true;
            }
            case 24: {
                pSDEDQCondBase.resetPSDEDQJoinName();
                return true;
            }
            case 25: {
                pSDEDQCondBase.resetPSDEDQName();
                return true;
            }
            case 26: {
                pSDEDQCondBase.resetPSDEDQPDCondId();
                return true;
            }
            case 27: {
                pSDEDQCondBase.resetPSDEDQPDCondName();
                return true;
            }
            case 28: {
                pSDEDQCondBase.resetPSDEFId();
                return true;
            }
            case 29: {
                pSDEDQCondBase.resetPSDEFName();
                return true;
            }
            case 30: {
                pSDEDQCondBase.resetPSDEId();
                return true;
            }
            case 31: {
                pSDEDQCondBase.resetPSSysDBVFId();
                return true;
            }
            case 32: {
                pSDEDQCondBase.resetPSSysDBVFName();
                return true;
            }
            case 33: {
                pSDEDQCondBase.resetPSVARTypeId();
                return true;
            }
            case 34: {
                pSDEDQCondBase.resetPSVARTypeName();
                return true;
            }
            case 35: {
                pSDEDQCondBase.resetUpdateDate();
                return true;
            }
            case 36: {
                pSDEDQCondBase.resetUpdateMan();
                return true;
            }
            case 37: {
                pSDEDQCondBase.resetUserCat();
                return true;
            }
            case 38: {
                pSDEDQCondBase.resetUserTag();
                return true;
            }
            case 39: {
                pSDEDQCondBase.resetUserTag2();
                return true;
            }
            case 40: {
                pSDEDQCondBase.resetUserTag3();
                return true;
            }
            case 41: {
                pSDEDQCondBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueOP getPSDBValueOP() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOP();
        }
        if (this.getPSDBValueOPId() == null) {
            return null;
        }
        Integer n = this.objPSDBValueOPLock;
        synchronized (n) {
            if (this.psdbvalueop != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBValueOPId(), (Object)this.psdbvalueop.getPSDBValueOPId()) != 0L) {
                this.psdbvalueop = null;
            }
            if (this.psdbvalueop == null) {
                PSDBValueOP pSDBValueOP = new PSDBValueOP();
                pSDBValueOP.setPSDBValueOPId(this.getPSDBValueOPId());
                PSDBValueOPService pSDBValueOPService = (PSDBValueOPService)ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)this.getSessionFactory());
                pSDBValueOPService.autoGet((IEntity)pSDBValueOP);
                this.psdbvalueop = pSDBValueOP;
            }
            return this.psdbvalueop;
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
                pSDEDataQueryService.autoGet((IEntity)pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDQCond getPPSDEDQCond() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEDQCond();
        }
        if (this.getPPSDEDQCondId() == null) {
            return null;
        }
        Integer n = this.objPPSDEDQCondLock;
        synchronized (n) {
            if (this.ppsdedqcond != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDEDQCondId(), (Object)this.ppsdedqcond.getPSDEDQCondId()) != 0L) {
                this.ppsdedqcond = null;
            }
            if (this.ppsdedqcond == null) {
                PSDEDQCond pSDEDQCond = new PSDEDQCond();
                pSDEDQCond.setPSDEDQCondId(this.getPPSDEDQCondId());
                PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
                pSDEDQCondService.autoGet((IEntity)pSDEDQCond);
                this.ppsdedqcond = pSDEDQCond;
            }
            return this.ppsdedqcond;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDQJoin getPSDEDQJoin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQJoin();
        }
        if (this.getPSDEDQJoinId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQJoinLock;
        synchronized (n) {
            if (this.psdedqjoin != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQJoinId(), (Object)this.psdedqjoin.getPSDEDQJoinId()) != 0L) {
                this.psdedqjoin = null;
            }
            if (this.psdedqjoin == null) {
                PSDEDQJoin pSDEDQJoin = new PSDEDQJoin();
                pSDEDQJoin.setPSDEDQJoinId(this.getPSDEDQJoinId());
                PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
                pSDEDQJoinService.autoGet((IEntity)pSDEDQJoin);
                this.psdedqjoin = pSDEDQJoin;
            }
            return this.psdedqjoin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDQPDCond getPSDEDQPDCond() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQPDCond();
        }
        if (this.getPSDEDQPDCondId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQPDCondLock;
        synchronized (n) {
            if (this.psdedqpdcond != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQPDCondId(), (Object)this.psdedqpdcond.getPSDEDQPDCondId()) != 0L) {
                this.psdedqpdcond = null;
            }
            if (this.psdedqpdcond == null) {
                PSDEDQPDCond pSDEDQPDCond = new PSDEDQPDCond();
                pSDEDQPDCond.setPSDEDQPDCondId(this.getPSDEDQPDCondId());
                PSDEDQPDCondService pSDEDQPDCondService = (PSDEDQPDCondService)ServiceGlobal.getService(PSDEDQPDCondService.class, (SessionFactory)this.getSessionFactory());
                pSDEDQPDCondService.autoGet((IEntity)pSDEDQPDCond);
                this.psdedqpdcond = pSDEDQPDCond;
            }
            return this.psdedqpdcond;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEField() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEField();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFieldLock;
        synchronized (n) {
            if (this.psdefield != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdefield.getPSDEFieldId()) != 0L) {
                this.psdefield = null;
            }
            if (this.psdefield == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdefield = pSDEField;
            }
            return this.psdefield;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBVF getPSSysDBVF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVF();
        }
        if (this.getPSSysDBVFId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBVFLock;
        synchronized (n) {
            if (this.pssysdbvf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBVFId(), (Object)this.pssysdbvf.getPSSysDBVFId()) != 0L) {
                this.pssysdbvf = null;
            }
            if (this.pssysdbvf == null) {
                PSSysDBVF pSSysDBVF = new PSSysDBVF();
                pSSysDBVF.setPSSysDBVFId(this.getPSSysDBVFId());
                PSSysDBVFService pSSysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBVFService.autoGet((IEntity)pSSysDBVF);
                this.pssysdbvf = pSSysDBVF;
            }
            return this.pssysdbvf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSVarType getPSVarType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVarType();
        }
        if (this.getPSVARTypeId() == null) {
            return null;
        }
        Integer n = this.objPSVarTypeLock;
        synchronized (n) {
            if (this.psvartype != null && DataTypeHelper.compare((int)25, (Object)this.getPSVARTypeId(), (Object)this.psvartype.getPSVarTypeId()) != 0L) {
                this.psvartype = null;
            }
            if (this.psvartype == null) {
                PSVarType pSVarType = new PSVarType();
                pSVarType.setPSVarTypeId(this.getPSVARTypeId());
                PSVarTypeService pSVarTypeService = (PSVarTypeService)ServiceGlobal.getService(PSVarTypeService.class, (SessionFactory)this.getSessionFactory());
                pSVarTypeService.autoGet((IEntity)pSVarType);
                this.psvartype = pSVarType;
            }
            return this.psvartype;
        }
    }

    private PSDEDQCondBase getProxyEntity() {
        return this.proxyPSDEDQCondBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDQCondBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDQCondBase) {
            this.proxyPSDEDQCondBase = (PSDEDQCondBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDTAG, 0);
        fieldIndexMap.put(FIELD_CONDTAG2, 1);
        fieldIndexMap.put(FIELD_CONDTYPE, 2);
        fieldIndexMap.put(FIELD_CONDVALUE, 3);
        fieldIndexMap.put(FIELD_CONDVALUETEXT, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 7);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 8);
        fieldIndexMap.put(FIELD_GROUPNOTFLAG, 9);
        fieldIndexMap.put(FIELD_GROUPOP, 10);
        fieldIndexMap.put(FIELD_IGNOREEMPTY, 11);
        fieldIndexMap.put(FIELD_LEVELTAG, 12);
        fieldIndexMap.put(FIELD_LEVELVALUE, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_PPSDEDQCONDID, 16);
        fieldIndexMap.put(FIELD_PPSDEDQCONDNAME, 17);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 18);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 19);
        fieldIndexMap.put(FIELD_PSDEDQCONDID, 20);
        fieldIndexMap.put(FIELD_PSDEDQCONDNAME, 21);
        fieldIndexMap.put(FIELD_PSDEDQID, 22);
        fieldIndexMap.put(FIELD_PSDEDQJOINID, 23);
        fieldIndexMap.put(FIELD_PSDEDQJOINNAME, 24);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 25);
        fieldIndexMap.put(FIELD_PSDEDQPDCONDID, 26);
        fieldIndexMap.put(FIELD_PSDEDQPDCONDNAME, 27);
        fieldIndexMap.put(FIELD_PSDEFID, 28);
        fieldIndexMap.put(FIELD_PSDEFNAME, 29);
        fieldIndexMap.put(FIELD_PSDEID, 30);
        fieldIndexMap.put(FIELD_PSSYSDBVFID, 31);
        fieldIndexMap.put(FIELD_PSSYSDBVFNAME, 32);
        fieldIndexMap.put(FIELD_PSVARTYPEID, 33);
        fieldIndexMap.put(FIELD_PSVARTYPENAME, 34);
        fieldIndexMap.put(FIELD_UPDATEDATE, 35);
        fieldIndexMap.put(FIELD_UPDATEMAN, 36);
        fieldIndexMap.put(FIELD_USERCAT, 37);
        fieldIndexMap.put(FIELD_USERTAG, 38);
        fieldIndexMap.put(FIELD_USERTAG2, 39);
        fieldIndexMap.put(FIELD_USERTAG3, 40);
        fieldIndexMap.put(FIELD_USERTAG4, 41);
    }
}

