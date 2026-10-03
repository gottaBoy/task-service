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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchy;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBILevel;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeLevelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBICubeLevelBase.class);
    public static final String FIELD_ALLLEVELFLAG = "ALLLEVELFLAG";
    public static final String FIELD_BICUBELEVELTAG = "BICUBELEVELTAG";
    public static final String FIELD_BICUBELEVELTAG2 = "BICUBELEVELTAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSBICUBEDIMENSIONID = "PSSYSBICUBEDIMENSIONID";
    public static final String FIELD_PSSYSBICUBEDIMENSIONNAME = "PSSYSBICUBEDIMENSIONNAME";
    public static final String FIELD_PSSYSBICUBELEVELID = "PSSYSBICUBELEVELID";
    public static final String FIELD_PSSYSBICUBELEVELNAME = "PSSYSBICUBELEVELNAME";
    public static final String FIELD_PSSYSBIDIMENSIONID = "PSSYSBIDIMENSIONID";
    public static final String FIELD_PSSYSBIHIERARCHYID = "PSSYSBIHIERARCHYID";
    public static final String FIELD_PSSYSBIHIERARCHYNAME = "PSSYSBIHIERARCHYNAME";
    public static final String FIELD_PSSYSBILEVELID = "PSSYSBILEVELID";
    public static final String FIELD_PSSYSBILEVELNAME = "PSSYSBILEVELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLLEVELFLAG = 0;
    private static final int INDEX_BICUBELEVELTAG = 1;
    private static final int INDEX_BICUBELEVELTAG2 = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDEFID = 7;
    private static final int INDEX_PSDEFNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSSYSBICUBEDIMENSIONID = 10;
    private static final int INDEX_PSSYSBICUBEDIMENSIONNAME = 11;
    private static final int INDEX_PSSYSBICUBELEVELID = 12;
    private static final int INDEX_PSSYSBICUBELEVELNAME = 13;
    private static final int INDEX_PSSYSBIDIMENSIONID = 14;
    private static final int INDEX_PSSYSBIHIERARCHYID = 15;
    private static final int INDEX_PSSYSBIHIERARCHYNAME = 16;
    private static final int INDEX_PSSYSBILEVELID = 17;
    private static final int INDEX_PSSYSBILEVELNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBICubeLevelBase proxyPSSysBICubeLevelBase = null;
    private boolean alllevelflagDirtyFlag = false;
    private boolean bicubeleveltagDirtyFlag = false;
    private boolean bicubeleveltag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysbicubedimensionidDirtyFlag = false;
    private boolean pssysbicubedimensionnameDirtyFlag = false;
    private boolean pssysbicubelevelidDirtyFlag = false;
    private boolean pssysbicubelevelnameDirtyFlag = false;
    private boolean pssysbidimensionidDirtyFlag = false;
    private boolean pssysbihierarchyidDirtyFlag = false;
    private boolean pssysbihierarchynameDirtyFlag = false;
    private boolean pssysbilevelidDirtyFlag = false;
    private boolean pssysbilevelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alllevelflag")
    private Integer alllevelflag;
    @Column(name="bicubeleveltag")
    private String bicubeleveltag;
    @Column(name="bicubeleveltag2")
    private String bicubeleveltag2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysbicubedimensionid")
    private String pssysbicubedimensionid;
    @Column(name="pssysbicubedimensionname")
    private String pssysbicubedimensionname;
    @Column(name="pssysbicubelevelid")
    private String pssysbicubelevelid;
    @Column(name="pssysbicubelevelname")
    private String pssysbicubelevelname;
    @Column(name="pssysbidimensionid")
    private String pssysbidimensionid;
    @Column(name="pssysbihierarchyid")
    private String pssysbihierarchyid;
    @Column(name="pssysbihierarchyname")
    private String pssysbihierarchyname;
    @Column(name="pssysbilevelid")
    private String pssysbilevelid;
    @Column(name="pssysbilevelname")
    private String pssysbilevelname;
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
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSSysBICubeDimensionLock = new Integer(1);
    private PSSysBICubeDimension pssysbicubedimension = null;
    private Integer objPSSysBIHierarchyLock = new Integer(1);
    private PSSysBIHierarchy pssysbihierarchy = null;
    private Integer objPSSysBILevelLock = new Integer(1);
    private PSSysBILevel pssysbilevel = null;

    public void setAllLevelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllLevelFlag(n);
            return;
        }
        this.alllevelflag = n;
        this.alllevelflagDirtyFlag = true;
    }

    public Integer getAllLevelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllLevelFlag();
        }
        return this.alllevelflag;
    }

    public boolean isAllLevelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllLevelFlagDirty();
        }
        return this.alllevelflagDirtyFlag;
    }

    public void resetAllLevelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllLevelFlag();
            return;
        }
        this.alllevelflagDirtyFlag = false;
        this.alllevelflag = null;
    }

    public void setBICubeLevelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeLevelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubeleveltag = string;
        this.bicubeleveltagDirtyFlag = true;
    }

    public String getBICubeLevelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeLevelTag();
        }
        return this.bicubeleveltag;
    }

    public boolean isBICubeLevelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeLevelTagDirty();
        }
        return this.bicubeleveltagDirtyFlag;
    }

    public void resetBICubeLevelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeLevelTag();
            return;
        }
        this.bicubeleveltagDirtyFlag = false;
        this.bicubeleveltag = null;
    }

    public void setBICubeLevelTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeLevelTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubeleveltag2 = string;
        this.bicubeleveltag2DirtyFlag = true;
    }

    public String getBICubeLevelTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeLevelTag2();
        }
        return this.bicubeleveltag2;
    }

    public boolean isBICubeLevelTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeLevelTag2Dirty();
        }
        return this.bicubeleveltag2DirtyFlag;
    }

    public void resetBICubeLevelTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeLevelTag2();
            return;
        }
        this.bicubeleveltag2DirtyFlag = false;
        this.bicubeleveltag2 = null;
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

    public void setPSSysBICubeDimensionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeDimensionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubedimensionid = string;
        this.pssysbicubedimensionidDirtyFlag = true;
    }

    public String getPSSysBICubeDimensionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimensionId();
        }
        return this.pssysbicubedimensionid;
    }

    public boolean isPSSysBICubeDimensionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeDimensionIdDirty();
        }
        return this.pssysbicubedimensionidDirtyFlag;
    }

    public void resetPSSysBICubeDimensionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeDimensionId();
            return;
        }
        this.pssysbicubedimensionidDirtyFlag = false;
        this.pssysbicubedimensionid = null;
    }

    public void setPSSysBICubeDimensionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeDimensionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubedimensionname = string;
        this.pssysbicubedimensionnameDirtyFlag = true;
    }

    public String getPSSysBICubeDimensionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimensionName();
        }
        return this.pssysbicubedimensionname;
    }

    public boolean isPSSysBICubeDimensionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeDimensionNameDirty();
        }
        return this.pssysbicubedimensionnameDirtyFlag;
    }

    public void resetPSSysBICubeDimensionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeDimensionName();
            return;
        }
        this.pssysbicubedimensionnameDirtyFlag = false;
        this.pssysbicubedimensionname = null;
    }

    public void setPSSysBICubeLevelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeLevelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubelevelid = string;
        this.pssysbicubelevelidDirtyFlag = true;
    }

    public String getPSSysBICubeLevelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeLevelId();
        }
        return this.pssysbicubelevelid;
    }

    public boolean isPSSysBICubeLevelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeLevelIdDirty();
        }
        return this.pssysbicubelevelidDirtyFlag;
    }

    public void resetPSSysBICubeLevelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeLevelId();
            return;
        }
        this.pssysbicubelevelidDirtyFlag = false;
        this.pssysbicubelevelid = null;
    }

    public void setPSSysBICubeLevelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeLevelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubelevelname = string;
        this.pssysbicubelevelnameDirtyFlag = true;
    }

    public String getPSSysBICubeLevelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeLevelName();
        }
        return this.pssysbicubelevelname;
    }

    public boolean isPSSysBICubeLevelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeLevelNameDirty();
        }
        return this.pssysbicubelevelnameDirtyFlag;
    }

    public void resetPSSysBICubeLevelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeLevelName();
            return;
        }
        this.pssysbicubelevelnameDirtyFlag = false;
        this.pssysbicubelevelname = null;
    }

    public void setPSSysBIDimensionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIDimensionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbidimensionid = string;
        this.pssysbidimensionidDirtyFlag = true;
    }

    public String getPSSysBIDimensionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIDimensionId();
        }
        return this.pssysbidimensionid;
    }

    public boolean isPSSysBIDimensionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIDimensionIdDirty();
        }
        return this.pssysbidimensionidDirtyFlag;
    }

    public void resetPSSysBIDimensionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIDimensionId();
            return;
        }
        this.pssysbidimensionidDirtyFlag = false;
        this.pssysbidimensionid = null;
    }

    public void setPSSysBIHierarchyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIHierarchyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbihierarchyid = string;
        this.pssysbihierarchyidDirtyFlag = true;
    }

    public String getPSSysBIHierarchyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIHierarchyId();
        }
        return this.pssysbihierarchyid;
    }

    public boolean isPSSysBIHierarchyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIHierarchyIdDirty();
        }
        return this.pssysbihierarchyidDirtyFlag;
    }

    public void resetPSSysBIHierarchyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIHierarchyId();
            return;
        }
        this.pssysbihierarchyidDirtyFlag = false;
        this.pssysbihierarchyid = null;
    }

    public void setPSSysBIHierarchyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIHierarchyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbihierarchyname = string;
        this.pssysbihierarchynameDirtyFlag = true;
    }

    public String getPSSysBIHierarchyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIHierarchyName();
        }
        return this.pssysbihierarchyname;
    }

    public boolean isPSSysBIHierarchyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIHierarchyNameDirty();
        }
        return this.pssysbihierarchynameDirtyFlag;
    }

    public void resetPSSysBIHierarchyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIHierarchyName();
            return;
        }
        this.pssysbihierarchynameDirtyFlag = false;
        this.pssysbihierarchyname = null;
    }

    public void setPSSysBILevelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBILevelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbilevelid = string;
        this.pssysbilevelidDirtyFlag = true;
    }

    public String getPSSysBILevelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBILevelId();
        }
        return this.pssysbilevelid;
    }

    public boolean isPSSysBILevelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBILevelIdDirty();
        }
        return this.pssysbilevelidDirtyFlag;
    }

    public void resetPSSysBILevelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBILevelId();
            return;
        }
        this.pssysbilevelidDirtyFlag = false;
        this.pssysbilevelid = null;
    }

    public void setPSSysBILevelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBILevelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbilevelname = string;
        this.pssysbilevelnameDirtyFlag = true;
    }

    public String getPSSysBILevelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBILevelName();
        }
        return this.pssysbilevelname;
    }

    public boolean isPSSysBILevelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBILevelNameDirty();
        }
        return this.pssysbilevelnameDirtyFlag;
    }

    public void resetPSSysBILevelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBILevelName();
            return;
        }
        this.pssysbilevelnameDirtyFlag = false;
        this.pssysbilevelname = null;
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
        PSSysBICubeLevelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBICubeLevelBase pSSysBICubeLevelBase) {
        pSSysBICubeLevelBase.resetAllLevelFlag();
        pSSysBICubeLevelBase.resetBICubeLevelTag();
        pSSysBICubeLevelBase.resetBICubeLevelTag2();
        pSSysBICubeLevelBase.resetCodeName();
        pSSysBICubeLevelBase.resetCreateDate();
        pSSysBICubeLevelBase.resetCreateMan();
        pSSysBICubeLevelBase.resetMemo();
        pSSysBICubeLevelBase.resetPSDEFId();
        pSSysBICubeLevelBase.resetPSDEFName();
        pSSysBICubeLevelBase.resetPSDEId();
        pSSysBICubeLevelBase.resetPSSysBICubeDimensionId();
        pSSysBICubeLevelBase.resetPSSysBICubeDimensionName();
        pSSysBICubeLevelBase.resetPSSysBICubeLevelId();
        pSSysBICubeLevelBase.resetPSSysBICubeLevelName();
        pSSysBICubeLevelBase.resetPSSysBIDimensionId();
        pSSysBICubeLevelBase.resetPSSysBIHierarchyId();
        pSSysBICubeLevelBase.resetPSSysBIHierarchyName();
        pSSysBICubeLevelBase.resetPSSysBILevelId();
        pSSysBICubeLevelBase.resetPSSysBILevelName();
        pSSysBICubeLevelBase.resetUpdateDate();
        pSSysBICubeLevelBase.resetUpdateMan();
        pSSysBICubeLevelBase.resetUserCat();
        pSSysBICubeLevelBase.resetUserTag();
        pSSysBICubeLevelBase.resetUserTag2();
        pSSysBICubeLevelBase.resetUserTag3();
        pSSysBICubeLevelBase.resetUserTag4();
        pSSysBICubeLevelBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllLevelFlagDirty()) {
            hashMap.put(FIELD_ALLLEVELFLAG, this.getAllLevelFlag());
        }
        if (!bl || this.isBICubeLevelTagDirty()) {
            hashMap.put(FIELD_BICUBELEVELTAG, this.getBICubeLevelTag());
        }
        if (!bl || this.isBICubeLevelTag2Dirty()) {
            hashMap.put(FIELD_BICUBELEVELTAG2, this.getBICubeLevelTag2());
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
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysBICubeDimensionIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEDIMENSIONID, this.getPSSysBICubeDimensionId());
        }
        if (!bl || this.isPSSysBICubeDimensionNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEDIMENSIONNAME, this.getPSSysBICubeDimensionName());
        }
        if (!bl || this.isPSSysBICubeLevelIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBELEVELID, this.getPSSysBICubeLevelId());
        }
        if (!bl || this.isPSSysBICubeLevelNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBELEVELNAME, this.getPSSysBICubeLevelName());
        }
        if (!bl || this.isPSSysBIDimensionIdDirty()) {
            hashMap.put(FIELD_PSSYSBIDIMENSIONID, this.getPSSysBIDimensionId());
        }
        if (!bl || this.isPSSysBIHierarchyIdDirty()) {
            hashMap.put(FIELD_PSSYSBIHIERARCHYID, this.getPSSysBIHierarchyId());
        }
        if (!bl || this.isPSSysBIHierarchyNameDirty()) {
            hashMap.put(FIELD_PSSYSBIHIERARCHYNAME, this.getPSSysBIHierarchyName());
        }
        if (!bl || this.isPSSysBILevelIdDirty()) {
            hashMap.put(FIELD_PSSYSBILEVELID, this.getPSSysBILevelId());
        }
        if (!bl || this.isPSSysBILevelNameDirty()) {
            hashMap.put(FIELD_PSSYSBILEVELNAME, this.getPSSysBILevelName());
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
        return PSSysBICubeLevelBase.get(this, n);
    }

    private static Object get(PSSysBICubeLevelBase pSSysBICubeLevelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeLevelBase.getAllLevelFlag();
            }
            case 1: {
                return pSSysBICubeLevelBase.getBICubeLevelTag();
            }
            case 2: {
                return pSSysBICubeLevelBase.getBICubeLevelTag2();
            }
            case 3: {
                return pSSysBICubeLevelBase.getCodeName();
            }
            case 4: {
                return pSSysBICubeLevelBase.getCreateDate();
            }
            case 5: {
                return pSSysBICubeLevelBase.getCreateMan();
            }
            case 6: {
                return pSSysBICubeLevelBase.getMemo();
            }
            case 7: {
                return pSSysBICubeLevelBase.getPSDEFId();
            }
            case 8: {
                return pSSysBICubeLevelBase.getPSDEFName();
            }
            case 9: {
                return pSSysBICubeLevelBase.getPSDEId();
            }
            case 10: {
                return pSSysBICubeLevelBase.getPSSysBICubeDimensionId();
            }
            case 11: {
                return pSSysBICubeLevelBase.getPSSysBICubeDimensionName();
            }
            case 12: {
                return pSSysBICubeLevelBase.getPSSysBICubeLevelId();
            }
            case 13: {
                return pSSysBICubeLevelBase.getPSSysBICubeLevelName();
            }
            case 14: {
                return pSSysBICubeLevelBase.getPSSysBIDimensionId();
            }
            case 15: {
                return pSSysBICubeLevelBase.getPSSysBIHierarchyId();
            }
            case 16: {
                return pSSysBICubeLevelBase.getPSSysBIHierarchyName();
            }
            case 17: {
                return pSSysBICubeLevelBase.getPSSysBILevelId();
            }
            case 18: {
                return pSSysBICubeLevelBase.getPSSysBILevelName();
            }
            case 19: {
                return pSSysBICubeLevelBase.getUpdateDate();
            }
            case 20: {
                return pSSysBICubeLevelBase.getUpdateMan();
            }
            case 21: {
                return pSSysBICubeLevelBase.getUserCat();
            }
            case 22: {
                return pSSysBICubeLevelBase.getUserTag();
            }
            case 23: {
                return pSSysBICubeLevelBase.getUserTag2();
            }
            case 24: {
                return pSSysBICubeLevelBase.getUserTag3();
            }
            case 25: {
                return pSSysBICubeLevelBase.getUserTag4();
            }
            case 26: {
                return pSSysBICubeLevelBase.getValidFlag();
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
        PSSysBICubeLevelBase.set(this, n, object);
    }

    private static void set(PSSysBICubeLevelBase pSSysBICubeLevelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeLevelBase.setAllLevelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysBICubeLevelBase.setBICubeLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBICubeLevelBase.setBICubeLevelTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBICubeLevelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBICubeLevelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysBICubeLevelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBICubeLevelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBICubeLevelBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBICubeLevelBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBICubeLevelBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBICubeLevelBase.setPSSysBICubeDimensionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBICubeLevelBase.setPSSysBICubeDimensionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBICubeLevelBase.setPSSysBICubeLevelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBICubeLevelBase.setPSSysBICubeLevelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBICubeLevelBase.setPSSysBIDimensionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBICubeLevelBase.setPSSysBIHierarchyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBICubeLevelBase.setPSSysBIHierarchyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBICubeLevelBase.setPSSysBILevelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBICubeLevelBase.setPSSysBILevelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBICubeLevelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSysBICubeLevelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBICubeLevelBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBICubeLevelBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBICubeLevelBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBICubeLevelBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBICubeLevelBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBICubeLevelBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBICubeLevelBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBICubeLevelBase pSSysBICubeLevelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeLevelBase.getAllLevelFlag() == null;
            }
            case 1: {
                return pSSysBICubeLevelBase.getBICubeLevelTag() == null;
            }
            case 2: {
                return pSSysBICubeLevelBase.getBICubeLevelTag2() == null;
            }
            case 3: {
                return pSSysBICubeLevelBase.getCodeName() == null;
            }
            case 4: {
                return pSSysBICubeLevelBase.getCreateDate() == null;
            }
            case 5: {
                return pSSysBICubeLevelBase.getCreateMan() == null;
            }
            case 6: {
                return pSSysBICubeLevelBase.getMemo() == null;
            }
            case 7: {
                return pSSysBICubeLevelBase.getPSDEFId() == null;
            }
            case 8: {
                return pSSysBICubeLevelBase.getPSDEFName() == null;
            }
            case 9: {
                return pSSysBICubeLevelBase.getPSDEId() == null;
            }
            case 10: {
                return pSSysBICubeLevelBase.getPSSysBICubeDimensionId() == null;
            }
            case 11: {
                return pSSysBICubeLevelBase.getPSSysBICubeDimensionName() == null;
            }
            case 12: {
                return pSSysBICubeLevelBase.getPSSysBICubeLevelId() == null;
            }
            case 13: {
                return pSSysBICubeLevelBase.getPSSysBICubeLevelName() == null;
            }
            case 14: {
                return pSSysBICubeLevelBase.getPSSysBIDimensionId() == null;
            }
            case 15: {
                return pSSysBICubeLevelBase.getPSSysBIHierarchyId() == null;
            }
            case 16: {
                return pSSysBICubeLevelBase.getPSSysBIHierarchyName() == null;
            }
            case 17: {
                return pSSysBICubeLevelBase.getPSSysBILevelId() == null;
            }
            case 18: {
                return pSSysBICubeLevelBase.getPSSysBILevelName() == null;
            }
            case 19: {
                return pSSysBICubeLevelBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSysBICubeLevelBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSysBICubeLevelBase.getUserCat() == null;
            }
            case 22: {
                return pSSysBICubeLevelBase.getUserTag() == null;
            }
            case 23: {
                return pSSysBICubeLevelBase.getUserTag2() == null;
            }
            case 24: {
                return pSSysBICubeLevelBase.getUserTag3() == null;
            }
            case 25: {
                return pSSysBICubeLevelBase.getUserTag4() == null;
            }
            case 26: {
                return pSSysBICubeLevelBase.getValidFlag() == null;
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
        return PSSysBICubeLevelBase.contains(this, n);
    }

    private static boolean contains(PSSysBICubeLevelBase pSSysBICubeLevelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeLevelBase.isAllLevelFlagDirty();
            }
            case 1: {
                return pSSysBICubeLevelBase.isBICubeLevelTagDirty();
            }
            case 2: {
                return pSSysBICubeLevelBase.isBICubeLevelTag2Dirty();
            }
            case 3: {
                return pSSysBICubeLevelBase.isCodeNameDirty();
            }
            case 4: {
                return pSSysBICubeLevelBase.isCreateDateDirty();
            }
            case 5: {
                return pSSysBICubeLevelBase.isCreateManDirty();
            }
            case 6: {
                return pSSysBICubeLevelBase.isMemoDirty();
            }
            case 7: {
                return pSSysBICubeLevelBase.isPSDEFIdDirty();
            }
            case 8: {
                return pSSysBICubeLevelBase.isPSDEFNameDirty();
            }
            case 9: {
                return pSSysBICubeLevelBase.isPSDEIdDirty();
            }
            case 10: {
                return pSSysBICubeLevelBase.isPSSysBICubeDimensionIdDirty();
            }
            case 11: {
                return pSSysBICubeLevelBase.isPSSysBICubeDimensionNameDirty();
            }
            case 12: {
                return pSSysBICubeLevelBase.isPSSysBICubeLevelIdDirty();
            }
            case 13: {
                return pSSysBICubeLevelBase.isPSSysBICubeLevelNameDirty();
            }
            case 14: {
                return pSSysBICubeLevelBase.isPSSysBIDimensionIdDirty();
            }
            case 15: {
                return pSSysBICubeLevelBase.isPSSysBIHierarchyIdDirty();
            }
            case 16: {
                return pSSysBICubeLevelBase.isPSSysBIHierarchyNameDirty();
            }
            case 17: {
                return pSSysBICubeLevelBase.isPSSysBILevelIdDirty();
            }
            case 18: {
                return pSSysBICubeLevelBase.isPSSysBILevelNameDirty();
            }
            case 19: {
                return pSSysBICubeLevelBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSysBICubeLevelBase.isUpdateManDirty();
            }
            case 21: {
                return pSSysBICubeLevelBase.isUserCatDirty();
            }
            case 22: {
                return pSSysBICubeLevelBase.isUserTagDirty();
            }
            case 23: {
                return pSSysBICubeLevelBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSysBICubeLevelBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSysBICubeLevelBase.isUserTag4Dirty();
            }
            case 26: {
                return pSSysBICubeLevelBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBICubeLevelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBICubeLevelBase pSSysBICubeLevelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBICubeLevelBase.getAllLevelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alllevelflag", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getAllLevelFlag()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getBICubeLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubeleveltag", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getBICubeLevelTag()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getBICubeLevelTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubeleveltag2", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getBICubeLevelTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBICubeDimensionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubedimensionid", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBICubeDimensionId()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBICubeDimensionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubedimensionname", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBICubeDimensionName()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBICubeLevelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubelevelid", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBICubeLevelId()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBICubeLevelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubelevelname", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBICubeLevelName()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBIDimensionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbidimensionid", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBIDimensionId()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBIHierarchyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbihierarchyid", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBIHierarchyId()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBIHierarchyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbihierarchyname", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBIHierarchyName()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBILevelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbilevelid", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBILevelId()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBILevelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbilevelname", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getPSSysBILevelName()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBICubeLevelBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBICubeLevelBase.getJSONValue((Object)pSSysBICubeLevelBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBICubeLevelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBICubeLevelBase pSSysBICubeLevelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBICubeLevelBase.getAllLevelFlag() != null) {
            object = pSSysBICubeLevelBase.getAllLevelFlag();
            xmlNode.setAttribute(FIELD_ALLLEVELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeLevelBase.getBICubeLevelTag() != null) {
            object = pSSysBICubeLevelBase.getBICubeLevelTag();
            xmlNode.setAttribute(FIELD_BICUBELEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getBICubeLevelTag2() != null) {
            object = pSSysBICubeLevelBase.getBICubeLevelTag2();
            xmlNode.setAttribute(FIELD_BICUBELEVELTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getCodeName() != null) {
            object = pSSysBICubeLevelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getCreateDate() != null) {
            object = pSSysBICubeLevelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeLevelBase.getCreateMan() != null) {
            object = pSSysBICubeLevelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getMemo() != null) {
            object = pSSysBICubeLevelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSDEFId() != null) {
            object = pSSysBICubeLevelBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSDEFName() != null) {
            object = pSSysBICubeLevelBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSDEId() != null) {
            object = pSSysBICubeLevelBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBICubeDimensionId() != null) {
            object = pSSysBICubeLevelBase.getPSSysBICubeDimensionId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEDIMENSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBICubeDimensionName() != null) {
            object = pSSysBICubeLevelBase.getPSSysBICubeDimensionName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEDIMENSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBICubeLevelId() != null) {
            object = pSSysBICubeLevelBase.getPSSysBICubeLevelId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBELEVELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBICubeLevelName() != null) {
            object = pSSysBICubeLevelBase.getPSSysBICubeLevelName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBELEVELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBIDimensionId() != null) {
            object = pSSysBICubeLevelBase.getPSSysBIDimensionId();
            xmlNode.setAttribute(FIELD_PSSYSBIDIMENSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBIHierarchyId() != null) {
            object = pSSysBICubeLevelBase.getPSSysBIHierarchyId();
            xmlNode.setAttribute(FIELD_PSSYSBIHIERARCHYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBIHierarchyName() != null) {
            object = pSSysBICubeLevelBase.getPSSysBIHierarchyName();
            xmlNode.setAttribute(FIELD_PSSYSBIHIERARCHYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBILevelId() != null) {
            object = pSSysBICubeLevelBase.getPSSysBILevelId();
            xmlNode.setAttribute(FIELD_PSSYSBILEVELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getPSSysBILevelName() != null) {
            object = pSSysBICubeLevelBase.getPSSysBILevelName();
            xmlNode.setAttribute(FIELD_PSSYSBILEVELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getUpdateDate() != null) {
            object = pSSysBICubeLevelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeLevelBase.getUpdateMan() != null) {
            object = pSSysBICubeLevelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getUserCat() != null) {
            object = pSSysBICubeLevelBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getUserTag() != null) {
            object = pSSysBICubeLevelBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getUserTag2() != null) {
            object = pSSysBICubeLevelBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getUserTag3() != null) {
            object = pSSysBICubeLevelBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getUserTag4() != null) {
            object = pSSysBICubeLevelBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeLevelBase.getValidFlag() != null) {
            object = pSSysBICubeLevelBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBICubeLevelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBICubeLevelBase pSSysBICubeLevelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBICubeLevelBase.isAllLevelFlagDirty() && (bl || pSSysBICubeLevelBase.getAllLevelFlag() != null)) {
            iDataObject.set(FIELD_ALLLEVELFLAG, (Object)pSSysBICubeLevelBase.getAllLevelFlag());
        }
        if (pSSysBICubeLevelBase.isBICubeLevelTagDirty() && (bl || pSSysBICubeLevelBase.getBICubeLevelTag() != null)) {
            iDataObject.set(FIELD_BICUBELEVELTAG, (Object)pSSysBICubeLevelBase.getBICubeLevelTag());
        }
        if (pSSysBICubeLevelBase.isBICubeLevelTag2Dirty() && (bl || pSSysBICubeLevelBase.getBICubeLevelTag2() != null)) {
            iDataObject.set(FIELD_BICUBELEVELTAG2, (Object)pSSysBICubeLevelBase.getBICubeLevelTag2());
        }
        if (pSSysBICubeLevelBase.isCodeNameDirty() && (bl || pSSysBICubeLevelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBICubeLevelBase.getCodeName());
        }
        if (pSSysBICubeLevelBase.isCreateDateDirty() && (bl || pSSysBICubeLevelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBICubeLevelBase.getCreateDate());
        }
        if (pSSysBICubeLevelBase.isCreateManDirty() && (bl || pSSysBICubeLevelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBICubeLevelBase.getCreateMan());
        }
        if (pSSysBICubeLevelBase.isMemoDirty() && (bl || pSSysBICubeLevelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBICubeLevelBase.getMemo());
        }
        if (pSSysBICubeLevelBase.isPSDEFIdDirty() && (bl || pSSysBICubeLevelBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysBICubeLevelBase.getPSDEFId());
        }
        if (pSSysBICubeLevelBase.isPSDEFNameDirty() && (bl || pSSysBICubeLevelBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysBICubeLevelBase.getPSDEFName());
        }
        if (pSSysBICubeLevelBase.isPSDEIdDirty() && (bl || pSSysBICubeLevelBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBICubeLevelBase.getPSDEId());
        }
        if (pSSysBICubeLevelBase.isPSSysBICubeDimensionIdDirty() && (bl || pSSysBICubeLevelBase.getPSSysBICubeDimensionId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEDIMENSIONID, (Object)pSSysBICubeLevelBase.getPSSysBICubeDimensionId());
        }
        if (pSSysBICubeLevelBase.isPSSysBICubeDimensionNameDirty() && (bl || pSSysBICubeLevelBase.getPSSysBICubeDimensionName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEDIMENSIONNAME, (Object)pSSysBICubeLevelBase.getPSSysBICubeDimensionName());
        }
        if (pSSysBICubeLevelBase.isPSSysBICubeLevelIdDirty() && (bl || pSSysBICubeLevelBase.getPSSysBICubeLevelId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBELEVELID, (Object)pSSysBICubeLevelBase.getPSSysBICubeLevelId());
        }
        if (pSSysBICubeLevelBase.isPSSysBICubeLevelNameDirty() && (bl || pSSysBICubeLevelBase.getPSSysBICubeLevelName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBELEVELNAME, (Object)pSSysBICubeLevelBase.getPSSysBICubeLevelName());
        }
        if (pSSysBICubeLevelBase.isPSSysBIDimensionIdDirty() && (bl || pSSysBICubeLevelBase.getPSSysBIDimensionId() != null)) {
            iDataObject.set(FIELD_PSSYSBIDIMENSIONID, (Object)pSSysBICubeLevelBase.getPSSysBIDimensionId());
        }
        if (pSSysBICubeLevelBase.isPSSysBIHierarchyIdDirty() && (bl || pSSysBICubeLevelBase.getPSSysBIHierarchyId() != null)) {
            iDataObject.set(FIELD_PSSYSBIHIERARCHYID, (Object)pSSysBICubeLevelBase.getPSSysBIHierarchyId());
        }
        if (pSSysBICubeLevelBase.isPSSysBIHierarchyNameDirty() && (bl || pSSysBICubeLevelBase.getPSSysBIHierarchyName() != null)) {
            iDataObject.set(FIELD_PSSYSBIHIERARCHYNAME, (Object)pSSysBICubeLevelBase.getPSSysBIHierarchyName());
        }
        if (pSSysBICubeLevelBase.isPSSysBILevelIdDirty() && (bl || pSSysBICubeLevelBase.getPSSysBILevelId() != null)) {
            iDataObject.set(FIELD_PSSYSBILEVELID, (Object)pSSysBICubeLevelBase.getPSSysBILevelId());
        }
        if (pSSysBICubeLevelBase.isPSSysBILevelNameDirty() && (bl || pSSysBICubeLevelBase.getPSSysBILevelName() != null)) {
            iDataObject.set(FIELD_PSSYSBILEVELNAME, (Object)pSSysBICubeLevelBase.getPSSysBILevelName());
        }
        if (pSSysBICubeLevelBase.isUpdateDateDirty() && (bl || pSSysBICubeLevelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBICubeLevelBase.getUpdateDate());
        }
        if (pSSysBICubeLevelBase.isUpdateManDirty() && (bl || pSSysBICubeLevelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBICubeLevelBase.getUpdateMan());
        }
        if (pSSysBICubeLevelBase.isUserCatDirty() && (bl || pSSysBICubeLevelBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBICubeLevelBase.getUserCat());
        }
        if (pSSysBICubeLevelBase.isUserTagDirty() && (bl || pSSysBICubeLevelBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBICubeLevelBase.getUserTag());
        }
        if (pSSysBICubeLevelBase.isUserTag2Dirty() && (bl || pSSysBICubeLevelBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBICubeLevelBase.getUserTag2());
        }
        if (pSSysBICubeLevelBase.isUserTag3Dirty() && (bl || pSSysBICubeLevelBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBICubeLevelBase.getUserTag3());
        }
        if (pSSysBICubeLevelBase.isUserTag4Dirty() && (bl || pSSysBICubeLevelBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBICubeLevelBase.getUserTag4());
        }
        if (pSSysBICubeLevelBase.isValidFlagDirty() && (bl || pSSysBICubeLevelBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBICubeLevelBase.getValidFlag());
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
        return PSSysBICubeLevelBase.remove(this, n);
    }

    private static boolean remove(PSSysBICubeLevelBase pSSysBICubeLevelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeLevelBase.resetAllLevelFlag();
                return true;
            }
            case 1: {
                pSSysBICubeLevelBase.resetBICubeLevelTag();
                return true;
            }
            case 2: {
                pSSysBICubeLevelBase.resetBICubeLevelTag2();
                return true;
            }
            case 3: {
                pSSysBICubeLevelBase.resetCodeName();
                return true;
            }
            case 4: {
                pSSysBICubeLevelBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSysBICubeLevelBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSysBICubeLevelBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysBICubeLevelBase.resetPSDEFId();
                return true;
            }
            case 8: {
                pSSysBICubeLevelBase.resetPSDEFName();
                return true;
            }
            case 9: {
                pSSysBICubeLevelBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSSysBICubeLevelBase.resetPSSysBICubeDimensionId();
                return true;
            }
            case 11: {
                pSSysBICubeLevelBase.resetPSSysBICubeDimensionName();
                return true;
            }
            case 12: {
                pSSysBICubeLevelBase.resetPSSysBICubeLevelId();
                return true;
            }
            case 13: {
                pSSysBICubeLevelBase.resetPSSysBICubeLevelName();
                return true;
            }
            case 14: {
                pSSysBICubeLevelBase.resetPSSysBIDimensionId();
                return true;
            }
            case 15: {
                pSSysBICubeLevelBase.resetPSSysBIHierarchyId();
                return true;
            }
            case 16: {
                pSSysBICubeLevelBase.resetPSSysBIHierarchyName();
                return true;
            }
            case 17: {
                pSSysBICubeLevelBase.resetPSSysBILevelId();
                return true;
            }
            case 18: {
                pSSysBICubeLevelBase.resetPSSysBILevelName();
                return true;
            }
            case 19: {
                pSSysBICubeLevelBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSysBICubeLevelBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSysBICubeLevelBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSysBICubeLevelBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysBICubeLevelBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSysBICubeLevelBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSysBICubeLevelBase.resetUserTag4();
                return true;
            }
            case 26: {
                pSSysBICubeLevelBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICubeDimension getPSSysBICubeDimension() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimension();
        }
        if (this.getPSSysBICubeDimensionId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeDimensionLock;
        synchronized (n) {
            if (this.pssysbicubedimension != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeDimensionId(), (Object)this.pssysbicubedimension.getPSSysBICubeDimensionId()) != 0L) {
                this.pssysbicubedimension = null;
            }
            if (this.pssysbicubedimension == null) {
                PSSysBICubeDimension pSSysBICubeDimension = new PSSysBICubeDimension();
                pSSysBICubeDimension.setPSSysBICubeDimensionId(this.getPSSysBICubeDimensionId());
                PSSysBICubeDimensionService pSSysBICubeDimensionService = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeDimensionService.autoGet(pSSysBICubeDimension);
                this.pssysbicubedimension = pSSysBICubeDimension;
            }
            return this.pssysbicubedimension;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIHierarchy getPSSysBIHierarchy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIHierarchy();
        }
        if (this.getPSSysBIHierarchyId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIHierarchyLock;
        synchronized (n) {
            if (this.pssysbihierarchy != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIHierarchyId(), (Object)this.pssysbihierarchy.getPSSysBIHierarchyId()) != 0L) {
                this.pssysbihierarchy = null;
            }
            if (this.pssysbihierarchy == null) {
                PSSysBIHierarchy pSSysBIHierarchy = new PSSysBIHierarchy();
                pSSysBIHierarchy.setPSSysBIHierarchyId(this.getPSSysBIHierarchyId());
                PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIHierarchyService.autoGet(pSSysBIHierarchy);
                this.pssysbihierarchy = pSSysBIHierarchy;
            }
            return this.pssysbihierarchy;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBILevel getPSSysBILevel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBILevel();
        }
        if (this.getPSSysBILevelId() == null) {
            return null;
        }
        Integer n = this.objPSSysBILevelLock;
        synchronized (n) {
            if (this.pssysbilevel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBILevelId(), (Object)this.pssysbilevel.getPSSysBILevelId()) != 0L) {
                this.pssysbilevel = null;
            }
            if (this.pssysbilevel == null) {
                PSSysBILevel pSSysBILevel = new PSSysBILevel();
                pSSysBILevel.setPSSysBILevelId(this.getPSSysBILevelId());
                PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
                pSSysBILevelService.autoGet(pSSysBILevel);
                this.pssysbilevel = pSSysBILevel;
            }
            return this.pssysbilevel;
        }
    }

    private PSSysBICubeLevelBase getProxyEntity() {
        return this.proxyPSSysBICubeLevelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBICubeLevelBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBICubeLevelBase) {
            this.proxyPSSysBICubeLevelBase = (PSSysBICubeLevelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLLEVELFLAG, 0);
        fieldIndexMap.put(FIELD_BICUBELEVELTAG, 1);
        fieldIndexMap.put(FIELD_BICUBELEVELTAG2, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDEFID, 7);
        fieldIndexMap.put(FIELD_PSDEFNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSSYSBICUBEDIMENSIONID, 10);
        fieldIndexMap.put(FIELD_PSSYSBICUBEDIMENSIONNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSBICUBELEVELID, 12);
        fieldIndexMap.put(FIELD_PSSYSBICUBELEVELNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSBIDIMENSIONID, 14);
        fieldIndexMap.put(FIELD_PSSYSBIHIERARCHYID, 15);
        fieldIndexMap.put(FIELD_PSSYSBIHIERARCHYNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSBILEVELID, 17);
        fieldIndexMap.put(FIELD_PSSYSBILEVELNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
    }
}

