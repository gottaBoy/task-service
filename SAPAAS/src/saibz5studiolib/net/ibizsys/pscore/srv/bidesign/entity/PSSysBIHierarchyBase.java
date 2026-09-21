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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBILevel;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIHierarchyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBIHierarchyBase.class);
    public static final String FIELD_ALLCAPTION = "ALLCAPTION";
    public static final String FIELD_BIHIERARCHYTAG = "BIHIERARCHYTAG";
    public static final String FIELD_BIHIERARCHYTAG2 = "BIHIERARCHYTAG2";
    public static final String FIELD_BIHIERARCHYTYPE = "BIHIERARCHYTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HASALL = "HASALL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSBIDIMENSIONID = "PSSYSBIDIMENSIONID";
    public static final String FIELD_PSSYSBIDIMENSIONNAME = "PSSYSBIDIMENSIONNAME";
    public static final String FIELD_PSSYSBIHIERARCHYID = "PSSYSBIHIERARCHYID";
    public static final String FIELD_PSSYSBIHIERARCHYNAME = "PSSYSBIHIERARCHYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLCAPTION = 0;
    private static final int INDEX_BIHIERARCHYTAG = 1;
    private static final int INDEX_BIHIERARCHYTAG2 = 2;
    private static final int INDEX_BIHIERARCHYTYPE = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_HASALL = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PSCODELISTID = 10;
    private static final int INDEX_PSCODELISTNAME = 11;
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDENAME = 13;
    private static final int INDEX_PSSYSBIDIMENSIONID = 14;
    private static final int INDEX_PSSYSBIDIMENSIONNAME = 15;
    private static final int INDEX_PSSYSBIHIERARCHYID = 16;
    private static final int INDEX_PSSYSBIHIERARCHYNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USERCAT = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final int INDEX_VALIDFLAG = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBIHierarchyBase proxyPSSysBIHierarchyBase = null;
    private boolean allcaptionDirtyFlag = false;
    private boolean bihierarchytagDirtyFlag = false;
    private boolean bihierarchytag2DirtyFlag = false;
    private boolean bihierarchytypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean hasallDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysbidimensionidDirtyFlag = false;
    private boolean pssysbidimensionnameDirtyFlag = false;
    private boolean pssysbihierarchyidDirtyFlag = false;
    private boolean pssysbihierarchynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="allcaption")
    private String allcaption;
    @Column(name="bihierarchytag")
    private String bihierarchytag;
    @Column(name="bihierarchytag2")
    private String bihierarchytag2;
    @Column(name="bihierarchytype")
    private String bihierarchytype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="hasall")
    private Integer hasall;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysbidimensionid")
    private String pssysbidimensionid;
    @Column(name="pssysbidimensionname")
    private String pssysbidimensionname;
    @Column(name="pssysbihierarchyid")
    private String pssysbihierarchyid;
    @Column(name="pssysbihierarchyname")
    private String pssysbihierarchyname;
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
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysBIDimensionLock = new Integer(1);
    private PSSysBIDimension pssysbidimension = null;
    private Integer objPSSysBILevelsLock = new Integer(1);
    private ArrayList<PSSysBILevel> pssysbilevels = null;

    public void setAllCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.allcaption = string;
        this.allcaptionDirtyFlag = true;
    }

    public String getAllCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllCaption();
        }
        return this.allcaption;
    }

    public boolean isAllCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllCaptionDirty();
        }
        return this.allcaptionDirtyFlag;
    }

    public void resetAllCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllCaption();
            return;
        }
        this.allcaptionDirtyFlag = false;
        this.allcaption = null;
    }

    public void setBIHierarchyTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIHierarchyTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bihierarchytag = string;
        this.bihierarchytagDirtyFlag = true;
    }

    public String getBIHierarchyTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIHierarchyTag();
        }
        return this.bihierarchytag;
    }

    public boolean isBIHierarchyTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIHierarchyTagDirty();
        }
        return this.bihierarchytagDirtyFlag;
    }

    public void resetBIHierarchyTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIHierarchyTag();
            return;
        }
        this.bihierarchytagDirtyFlag = false;
        this.bihierarchytag = null;
    }

    public void setBIHierarchyTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIHierarchyTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bihierarchytag2 = string;
        this.bihierarchytag2DirtyFlag = true;
    }

    public String getBIHierarchyTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIHierarchyTag2();
        }
        return this.bihierarchytag2;
    }

    public boolean isBIHierarchyTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIHierarchyTag2Dirty();
        }
        return this.bihierarchytag2DirtyFlag;
    }

    public void resetBIHierarchyTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIHierarchyTag2();
            return;
        }
        this.bihierarchytag2DirtyFlag = false;
        this.bihierarchytag2 = null;
    }

    public void setBIHierarchyType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIHierarchyType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bihierarchytype = string;
        this.bihierarchytypeDirtyFlag = true;
    }

    public String getBIHierarchyType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIHierarchyType();
        }
        return this.bihierarchytype;
    }

    public boolean isBIHierarchyTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIHierarchyTypeDirty();
        }
        return this.bihierarchytypeDirtyFlag;
    }

    public void resetBIHierarchyType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIHierarchyType();
            return;
        }
        this.bihierarchytypeDirtyFlag = false;
        this.bihierarchytype = null;
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

    public void setHasAll(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHasAll(n);
            return;
        }
        this.hasall = n;
        this.hasallDirtyFlag = true;
    }

    public Integer getHasAll() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHasAll();
        }
        return this.hasall;
    }

    public boolean isHasAllDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHasAllDirty();
        }
        return this.hasallDirtyFlag;
    }

    public void resetHasAll() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHasAll();
            return;
        }
        this.hasallDirtyFlag = false;
        this.hasall = null;
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

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
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

    public void setPSSysBIDimensionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIDimensionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbidimensionname = string;
        this.pssysbidimensionnameDirtyFlag = true;
    }

    public String getPSSysBIDimensionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIDimensionName();
        }
        return this.pssysbidimensionname;
    }

    public boolean isPSSysBIDimensionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIDimensionNameDirty();
        }
        return this.pssysbidimensionnameDirtyFlag;
    }

    public void resetPSSysBIDimensionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIDimensionName();
            return;
        }
        this.pssysbidimensionnameDirtyFlag = false;
        this.pssysbidimensionname = null;
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
        PSSysBIHierarchyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBIHierarchyBase pSSysBIHierarchyBase) {
        pSSysBIHierarchyBase.resetAllCaption();
        pSSysBIHierarchyBase.resetBIHierarchyTag();
        pSSysBIHierarchyBase.resetBIHierarchyTag2();
        pSSysBIHierarchyBase.resetBIHierarchyType();
        pSSysBIHierarchyBase.resetCodeName();
        pSSysBIHierarchyBase.resetCreateDate();
        pSSysBIHierarchyBase.resetCreateMan();
        pSSysBIHierarchyBase.resetHasAll();
        pSSysBIHierarchyBase.resetMemo();
        pSSysBIHierarchyBase.resetOrderValue();
        pSSysBIHierarchyBase.resetPSCodeListId();
        pSSysBIHierarchyBase.resetPSCodeListName();
        pSSysBIHierarchyBase.resetPSDEId();
        pSSysBIHierarchyBase.resetPSDEName();
        pSSysBIHierarchyBase.resetPSSysBIDimensionId();
        pSSysBIHierarchyBase.resetPSSysBIDimensionName();
        pSSysBIHierarchyBase.resetPSSysBIHierarchyId();
        pSSysBIHierarchyBase.resetPSSysBIHierarchyName();
        pSSysBIHierarchyBase.resetUpdateDate();
        pSSysBIHierarchyBase.resetUpdateMan();
        pSSysBIHierarchyBase.resetUserCat();
        pSSysBIHierarchyBase.resetUserTag();
        pSSysBIHierarchyBase.resetUserTag2();
        pSSysBIHierarchyBase.resetUserTag3();
        pSSysBIHierarchyBase.resetUserTag4();
        pSSysBIHierarchyBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllCaptionDirty()) {
            hashMap.put(FIELD_ALLCAPTION, this.getAllCaption());
        }
        if (!bl || this.isBIHierarchyTagDirty()) {
            hashMap.put(FIELD_BIHIERARCHYTAG, this.getBIHierarchyTag());
        }
        if (!bl || this.isBIHierarchyTag2Dirty()) {
            hashMap.put(FIELD_BIHIERARCHYTAG2, this.getBIHierarchyTag2());
        }
        if (!bl || this.isBIHierarchyTypeDirty()) {
            hashMap.put(FIELD_BIHIERARCHYTYPE, this.getBIHierarchyType());
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
        if (!bl || this.isHasAllDirty()) {
            hashMap.put(FIELD_HASALL, this.getHasAll());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysBIDimensionIdDirty()) {
            hashMap.put(FIELD_PSSYSBIDIMENSIONID, this.getPSSysBIDimensionId());
        }
        if (!bl || this.isPSSysBIDimensionNameDirty()) {
            hashMap.put(FIELD_PSSYSBIDIMENSIONNAME, this.getPSSysBIDimensionName());
        }
        if (!bl || this.isPSSysBIHierarchyIdDirty()) {
            hashMap.put(FIELD_PSSYSBIHIERARCHYID, this.getPSSysBIHierarchyId());
        }
        if (!bl || this.isPSSysBIHierarchyNameDirty()) {
            hashMap.put(FIELD_PSSYSBIHIERARCHYNAME, this.getPSSysBIHierarchyName());
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
        return PSSysBIHierarchyBase.get(this, n);
    }

    private static Object get(PSSysBIHierarchyBase pSSysBIHierarchyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIHierarchyBase.getAllCaption();
            }
            case 1: {
                return pSSysBIHierarchyBase.getBIHierarchyTag();
            }
            case 2: {
                return pSSysBIHierarchyBase.getBIHierarchyTag2();
            }
            case 3: {
                return pSSysBIHierarchyBase.getBIHierarchyType();
            }
            case 4: {
                return pSSysBIHierarchyBase.getCodeName();
            }
            case 5: {
                return pSSysBIHierarchyBase.getCreateDate();
            }
            case 6: {
                return pSSysBIHierarchyBase.getCreateMan();
            }
            case 7: {
                return pSSysBIHierarchyBase.getHasAll();
            }
            case 8: {
                return pSSysBIHierarchyBase.getMemo();
            }
            case 9: {
                return pSSysBIHierarchyBase.getOrderValue();
            }
            case 10: {
                return pSSysBIHierarchyBase.getPSCodeListId();
            }
            case 11: {
                return pSSysBIHierarchyBase.getPSCodeListName();
            }
            case 12: {
                return pSSysBIHierarchyBase.getPSDEId();
            }
            case 13: {
                return pSSysBIHierarchyBase.getPSDEName();
            }
            case 14: {
                return pSSysBIHierarchyBase.getPSSysBIDimensionId();
            }
            case 15: {
                return pSSysBIHierarchyBase.getPSSysBIDimensionName();
            }
            case 16: {
                return pSSysBIHierarchyBase.getPSSysBIHierarchyId();
            }
            case 17: {
                return pSSysBIHierarchyBase.getPSSysBIHierarchyName();
            }
            case 18: {
                return pSSysBIHierarchyBase.getUpdateDate();
            }
            case 19: {
                return pSSysBIHierarchyBase.getUpdateMan();
            }
            case 20: {
                return pSSysBIHierarchyBase.getUserCat();
            }
            case 21: {
                return pSSysBIHierarchyBase.getUserTag();
            }
            case 22: {
                return pSSysBIHierarchyBase.getUserTag2();
            }
            case 23: {
                return pSSysBIHierarchyBase.getUserTag3();
            }
            case 24: {
                return pSSysBIHierarchyBase.getUserTag4();
            }
            case 25: {
                return pSSysBIHierarchyBase.getValidFlag();
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
        PSSysBIHierarchyBase.set(this, n, object);
    }

    private static void set(PSSysBIHierarchyBase pSSysBIHierarchyBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIHierarchyBase.setAllCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBIHierarchyBase.setBIHierarchyTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBIHierarchyBase.setBIHierarchyTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBIHierarchyBase.setBIHierarchyType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBIHierarchyBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBIHierarchyBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysBIHierarchyBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBIHierarchyBase.setHasAll(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysBIHierarchyBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBIHierarchyBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysBIHierarchyBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBIHierarchyBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBIHierarchyBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBIHierarchyBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBIHierarchyBase.setPSSysBIDimensionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBIHierarchyBase.setPSSysBIDimensionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBIHierarchyBase.setPSSysBIHierarchyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBIHierarchyBase.setPSSysBIHierarchyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBIHierarchyBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSSysBIHierarchyBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBIHierarchyBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBIHierarchyBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBIHierarchyBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBIHierarchyBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBIHierarchyBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBIHierarchyBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBIHierarchyBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBIHierarchyBase pSSysBIHierarchyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIHierarchyBase.getAllCaption() == null;
            }
            case 1: {
                return pSSysBIHierarchyBase.getBIHierarchyTag() == null;
            }
            case 2: {
                return pSSysBIHierarchyBase.getBIHierarchyTag2() == null;
            }
            case 3: {
                return pSSysBIHierarchyBase.getBIHierarchyType() == null;
            }
            case 4: {
                return pSSysBIHierarchyBase.getCodeName() == null;
            }
            case 5: {
                return pSSysBIHierarchyBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysBIHierarchyBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysBIHierarchyBase.getHasAll() == null;
            }
            case 8: {
                return pSSysBIHierarchyBase.getMemo() == null;
            }
            case 9: {
                return pSSysBIHierarchyBase.getOrderValue() == null;
            }
            case 10: {
                return pSSysBIHierarchyBase.getPSCodeListId() == null;
            }
            case 11: {
                return pSSysBIHierarchyBase.getPSCodeListName() == null;
            }
            case 12: {
                return pSSysBIHierarchyBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysBIHierarchyBase.getPSDEName() == null;
            }
            case 14: {
                return pSSysBIHierarchyBase.getPSSysBIDimensionId() == null;
            }
            case 15: {
                return pSSysBIHierarchyBase.getPSSysBIDimensionName() == null;
            }
            case 16: {
                return pSSysBIHierarchyBase.getPSSysBIHierarchyId() == null;
            }
            case 17: {
                return pSSysBIHierarchyBase.getPSSysBIHierarchyName() == null;
            }
            case 18: {
                return pSSysBIHierarchyBase.getUpdateDate() == null;
            }
            case 19: {
                return pSSysBIHierarchyBase.getUpdateMan() == null;
            }
            case 20: {
                return pSSysBIHierarchyBase.getUserCat() == null;
            }
            case 21: {
                return pSSysBIHierarchyBase.getUserTag() == null;
            }
            case 22: {
                return pSSysBIHierarchyBase.getUserTag2() == null;
            }
            case 23: {
                return pSSysBIHierarchyBase.getUserTag3() == null;
            }
            case 24: {
                return pSSysBIHierarchyBase.getUserTag4() == null;
            }
            case 25: {
                return pSSysBIHierarchyBase.getValidFlag() == null;
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
        return PSSysBIHierarchyBase.contains(this, n);
    }

    private static boolean contains(PSSysBIHierarchyBase pSSysBIHierarchyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIHierarchyBase.isAllCaptionDirty();
            }
            case 1: {
                return pSSysBIHierarchyBase.isBIHierarchyTagDirty();
            }
            case 2: {
                return pSSysBIHierarchyBase.isBIHierarchyTag2Dirty();
            }
            case 3: {
                return pSSysBIHierarchyBase.isBIHierarchyTypeDirty();
            }
            case 4: {
                return pSSysBIHierarchyBase.isCodeNameDirty();
            }
            case 5: {
                return pSSysBIHierarchyBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysBIHierarchyBase.isCreateManDirty();
            }
            case 7: {
                return pSSysBIHierarchyBase.isHasAllDirty();
            }
            case 8: {
                return pSSysBIHierarchyBase.isMemoDirty();
            }
            case 9: {
                return pSSysBIHierarchyBase.isOrderValueDirty();
            }
            case 10: {
                return pSSysBIHierarchyBase.isPSCodeListIdDirty();
            }
            case 11: {
                return pSSysBIHierarchyBase.isPSCodeListNameDirty();
            }
            case 12: {
                return pSSysBIHierarchyBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysBIHierarchyBase.isPSDENameDirty();
            }
            case 14: {
                return pSSysBIHierarchyBase.isPSSysBIDimensionIdDirty();
            }
            case 15: {
                return pSSysBIHierarchyBase.isPSSysBIDimensionNameDirty();
            }
            case 16: {
                return pSSysBIHierarchyBase.isPSSysBIHierarchyIdDirty();
            }
            case 17: {
                return pSSysBIHierarchyBase.isPSSysBIHierarchyNameDirty();
            }
            case 18: {
                return pSSysBIHierarchyBase.isUpdateDateDirty();
            }
            case 19: {
                return pSSysBIHierarchyBase.isUpdateManDirty();
            }
            case 20: {
                return pSSysBIHierarchyBase.isUserCatDirty();
            }
            case 21: {
                return pSSysBIHierarchyBase.isUserTagDirty();
            }
            case 22: {
                return pSSysBIHierarchyBase.isUserTag2Dirty();
            }
            case 23: {
                return pSSysBIHierarchyBase.isUserTag3Dirty();
            }
            case 24: {
                return pSSysBIHierarchyBase.isUserTag4Dirty();
            }
            case 25: {
                return pSSysBIHierarchyBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBIHierarchyBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBIHierarchyBase pSSysBIHierarchyBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBIHierarchyBase.getAllCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allcaption", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getAllCaption()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getBIHierarchyTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bihierarchytag", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getBIHierarchyTag()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getBIHierarchyTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bihierarchytag2", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getBIHierarchyTag2()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getBIHierarchyType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bihierarchytype", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getBIHierarchyType()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getHasAll() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hasall", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getHasAll()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getPSSysBIDimensionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbidimensionid", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getPSSysBIDimensionId()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getPSSysBIDimensionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbidimensionname", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getPSSysBIDimensionName()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getPSSysBIHierarchyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbihierarchyid", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getPSSysBIHierarchyId()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getPSSysBIHierarchyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbihierarchyname", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getPSSysBIHierarchyName()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBIHierarchyBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBIHierarchyBase.getJSONValue((Object)pSSysBIHierarchyBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBIHierarchyBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBIHierarchyBase pSSysBIHierarchyBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBIHierarchyBase.getAllCaption() != null) {
            object = pSSysBIHierarchyBase.getAllCaption();
            xmlNode.setAttribute(FIELD_ALLCAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIHierarchyBase.getBIHierarchyTag() != null) {
            object = pSSysBIHierarchyBase.getBIHierarchyTag();
            xmlNode.setAttribute(FIELD_BIHIERARCHYTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIHierarchyBase.getBIHierarchyTag2() != null) {
            object = pSSysBIHierarchyBase.getBIHierarchyTag2();
            xmlNode.setAttribute(FIELD_BIHIERARCHYTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIHierarchyBase.getBIHierarchyType() != null) {
            object = pSSysBIHierarchyBase.getBIHierarchyType();
            xmlNode.setAttribute(FIELD_BIHIERARCHYTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIHierarchyBase.getCodeName() != null) {
            object = pSSysBIHierarchyBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getCreateDate() != null) {
            object = pSSysBIHierarchyBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIHierarchyBase.getCreateMan() != null) {
            object = pSSysBIHierarchyBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getHasAll() != null) {
            object = pSSysBIHierarchyBase.getHasAll();
            xmlNode.setAttribute(FIELD_HASALL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBIHierarchyBase.getMemo() != null) {
            object = pSSysBIHierarchyBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getOrderValue() != null) {
            object = pSSysBIHierarchyBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBIHierarchyBase.getPSCodeListId() != null) {
            object = pSSysBIHierarchyBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getPSCodeListName() != null) {
            object = pSSysBIHierarchyBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getPSDEId() != null) {
            object = pSSysBIHierarchyBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getPSDEName() != null) {
            object = pSSysBIHierarchyBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getPSSysBIDimensionId() != null) {
            object = pSSysBIHierarchyBase.getPSSysBIDimensionId();
            xmlNode.setAttribute(FIELD_PSSYSBIDIMENSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getPSSysBIDimensionName() != null) {
            object = pSSysBIHierarchyBase.getPSSysBIDimensionName();
            xmlNode.setAttribute(FIELD_PSSYSBIDIMENSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getPSSysBIHierarchyId() != null) {
            object = pSSysBIHierarchyBase.getPSSysBIHierarchyId();
            xmlNode.setAttribute(FIELD_PSSYSBIHIERARCHYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getPSSysBIHierarchyName() != null) {
            object = pSSysBIHierarchyBase.getPSSysBIHierarchyName();
            xmlNode.setAttribute(FIELD_PSSYSBIHIERARCHYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getUpdateDate() != null) {
            object = pSSysBIHierarchyBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIHierarchyBase.getUpdateMan() != null) {
            object = pSSysBIHierarchyBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getUserCat() != null) {
            object = pSSysBIHierarchyBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getUserTag() != null) {
            object = pSSysBIHierarchyBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getUserTag2() != null) {
            object = pSSysBIHierarchyBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getUserTag3() != null) {
            object = pSSysBIHierarchyBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getUserTag4() != null) {
            object = pSSysBIHierarchyBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIHierarchyBase.getValidFlag() != null) {
            object = pSSysBIHierarchyBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBIHierarchyBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBIHierarchyBase pSSysBIHierarchyBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBIHierarchyBase.isAllCaptionDirty() && (bl || pSSysBIHierarchyBase.getAllCaption() != null)) {
            iDataObject.set(FIELD_ALLCAPTION, (Object)pSSysBIHierarchyBase.getAllCaption());
        }
        if (pSSysBIHierarchyBase.isBIHierarchyTagDirty() && (bl || pSSysBIHierarchyBase.getBIHierarchyTag() != null)) {
            iDataObject.set(FIELD_BIHIERARCHYTAG, (Object)pSSysBIHierarchyBase.getBIHierarchyTag());
        }
        if (pSSysBIHierarchyBase.isBIHierarchyTag2Dirty() && (bl || pSSysBIHierarchyBase.getBIHierarchyTag2() != null)) {
            iDataObject.set(FIELD_BIHIERARCHYTAG2, (Object)pSSysBIHierarchyBase.getBIHierarchyTag2());
        }
        if (pSSysBIHierarchyBase.isBIHierarchyTypeDirty() && (bl || pSSysBIHierarchyBase.getBIHierarchyType() != null)) {
            iDataObject.set(FIELD_BIHIERARCHYTYPE, (Object)pSSysBIHierarchyBase.getBIHierarchyType());
        }
        if (pSSysBIHierarchyBase.isCodeNameDirty() && (bl || pSSysBIHierarchyBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBIHierarchyBase.getCodeName());
        }
        if (pSSysBIHierarchyBase.isCreateDateDirty() && (bl || pSSysBIHierarchyBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBIHierarchyBase.getCreateDate());
        }
        if (pSSysBIHierarchyBase.isCreateManDirty() && (bl || pSSysBIHierarchyBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBIHierarchyBase.getCreateMan());
        }
        if (pSSysBIHierarchyBase.isHasAllDirty() && (bl || pSSysBIHierarchyBase.getHasAll() != null)) {
            iDataObject.set(FIELD_HASALL, (Object)pSSysBIHierarchyBase.getHasAll());
        }
        if (pSSysBIHierarchyBase.isMemoDirty() && (bl || pSSysBIHierarchyBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBIHierarchyBase.getMemo());
        }
        if (pSSysBIHierarchyBase.isOrderValueDirty() && (bl || pSSysBIHierarchyBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBIHierarchyBase.getOrderValue());
        }
        if (pSSysBIHierarchyBase.isPSCodeListIdDirty() && (bl || pSSysBIHierarchyBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysBIHierarchyBase.getPSCodeListId());
        }
        if (pSSysBIHierarchyBase.isPSCodeListNameDirty() && (bl || pSSysBIHierarchyBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysBIHierarchyBase.getPSCodeListName());
        }
        if (pSSysBIHierarchyBase.isPSDEIdDirty() && (bl || pSSysBIHierarchyBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBIHierarchyBase.getPSDEId());
        }
        if (pSSysBIHierarchyBase.isPSDENameDirty() && (bl || pSSysBIHierarchyBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysBIHierarchyBase.getPSDEName());
        }
        if (pSSysBIHierarchyBase.isPSSysBIDimensionIdDirty() && (bl || pSSysBIHierarchyBase.getPSSysBIDimensionId() != null)) {
            iDataObject.set(FIELD_PSSYSBIDIMENSIONID, (Object)pSSysBIHierarchyBase.getPSSysBIDimensionId());
        }
        if (pSSysBIHierarchyBase.isPSSysBIDimensionNameDirty() && (bl || pSSysBIHierarchyBase.getPSSysBIDimensionName() != null)) {
            iDataObject.set(FIELD_PSSYSBIDIMENSIONNAME, (Object)pSSysBIHierarchyBase.getPSSysBIDimensionName());
        }
        if (pSSysBIHierarchyBase.isPSSysBIHierarchyIdDirty() && (bl || pSSysBIHierarchyBase.getPSSysBIHierarchyId() != null)) {
            iDataObject.set(FIELD_PSSYSBIHIERARCHYID, (Object)pSSysBIHierarchyBase.getPSSysBIHierarchyId());
        }
        if (pSSysBIHierarchyBase.isPSSysBIHierarchyNameDirty() && (bl || pSSysBIHierarchyBase.getPSSysBIHierarchyName() != null)) {
            iDataObject.set(FIELD_PSSYSBIHIERARCHYNAME, (Object)pSSysBIHierarchyBase.getPSSysBIHierarchyName());
        }
        if (pSSysBIHierarchyBase.isUpdateDateDirty() && (bl || pSSysBIHierarchyBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBIHierarchyBase.getUpdateDate());
        }
        if (pSSysBIHierarchyBase.isUpdateManDirty() && (bl || pSSysBIHierarchyBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBIHierarchyBase.getUpdateMan());
        }
        if (pSSysBIHierarchyBase.isUserCatDirty() && (bl || pSSysBIHierarchyBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBIHierarchyBase.getUserCat());
        }
        if (pSSysBIHierarchyBase.isUserTagDirty() && (bl || pSSysBIHierarchyBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBIHierarchyBase.getUserTag());
        }
        if (pSSysBIHierarchyBase.isUserTag2Dirty() && (bl || pSSysBIHierarchyBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBIHierarchyBase.getUserTag2());
        }
        if (pSSysBIHierarchyBase.isUserTag3Dirty() && (bl || pSSysBIHierarchyBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBIHierarchyBase.getUserTag3());
        }
        if (pSSysBIHierarchyBase.isUserTag4Dirty() && (bl || pSSysBIHierarchyBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBIHierarchyBase.getUserTag4());
        }
        if (pSSysBIHierarchyBase.isValidFlagDirty() && (bl || pSSysBIHierarchyBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBIHierarchyBase.getValidFlag());
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
        return PSSysBIHierarchyBase.remove(this, n);
    }

    private static boolean remove(PSSysBIHierarchyBase pSSysBIHierarchyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIHierarchyBase.resetAllCaption();
                return true;
            }
            case 1: {
                pSSysBIHierarchyBase.resetBIHierarchyTag();
                return true;
            }
            case 2: {
                pSSysBIHierarchyBase.resetBIHierarchyTag2();
                return true;
            }
            case 3: {
                pSSysBIHierarchyBase.resetBIHierarchyType();
                return true;
            }
            case 4: {
                pSSysBIHierarchyBase.resetCodeName();
                return true;
            }
            case 5: {
                pSSysBIHierarchyBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysBIHierarchyBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysBIHierarchyBase.resetHasAll();
                return true;
            }
            case 8: {
                pSSysBIHierarchyBase.resetMemo();
                return true;
            }
            case 9: {
                pSSysBIHierarchyBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSSysBIHierarchyBase.resetPSCodeListId();
                return true;
            }
            case 11: {
                pSSysBIHierarchyBase.resetPSCodeListName();
                return true;
            }
            case 12: {
                pSSysBIHierarchyBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysBIHierarchyBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSSysBIHierarchyBase.resetPSSysBIDimensionId();
                return true;
            }
            case 15: {
                pSSysBIHierarchyBase.resetPSSysBIDimensionName();
                return true;
            }
            case 16: {
                pSSysBIHierarchyBase.resetPSSysBIHierarchyId();
                return true;
            }
            case 17: {
                pSSysBIHierarchyBase.resetPSSysBIHierarchyName();
                return true;
            }
            case 18: {
                pSSysBIHierarchyBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSSysBIHierarchyBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSSysBIHierarchyBase.resetUserCat();
                return true;
            }
            case 21: {
                pSSysBIHierarchyBase.resetUserTag();
                return true;
            }
            case 22: {
                pSSysBIHierarchyBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSSysBIHierarchyBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSSysBIHierarchyBase.resetUserTag4();
                return true;
            }
            case 25: {
                pSSysBIHierarchyBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
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
    public PSSysBIDimension getPSSysBIDimension() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIDimension();
        }
        if (this.getPSSysBIDimensionId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIDimensionLock;
        synchronized (n) {
            if (this.pssysbidimension != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIDimensionId(), (Object)this.pssysbidimension.getPSSysBIDimensionId()) != 0L) {
                this.pssysbidimension = null;
            }
            if (this.pssysbidimension == null) {
                PSSysBIDimension pSSysBIDimension = new PSSysBIDimension();
                pSSysBIDimension.setPSSysBIDimensionId(this.getPSSysBIDimensionId());
                PSSysBIDimensionService pSSysBIDimensionService = (PSSysBIDimensionService)ServiceGlobal.getService(PSSysBIDimensionService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIDimensionService.autoGet((IEntity)pSSysBIDimension);
                this.pssysbidimension = pSSysBIDimension;
            }
            return this.pssysbidimension;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBILevel> getPSSysBILevels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBILevels();
        }
        if (this.getPSSysBIHierarchyId() == null) {
            return null;
        }
        PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBILevelsLock;
        synchronized (n) {
            if (this.pssysbilevels == null) {
                this.pssysbilevels = pSSysBILevelService.selectByPSSysBIHierarchy(this);
            }
            return this.pssysbilevels;
        }
    }

    private PSSysBIHierarchyBase getProxyEntity() {
        return this.proxyPSSysBIHierarchyBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBIHierarchyBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBIHierarchyBase) {
            this.proxyPSSysBIHierarchyBase = (PSSysBIHierarchyBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLCAPTION, 0);
        fieldIndexMap.put(FIELD_BIHIERARCHYTAG, 1);
        fieldIndexMap.put(FIELD_BIHIERARCHYTAG2, 2);
        fieldIndexMap.put(FIELD_BIHIERARCHYTYPE, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_HASALL, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PSCODELISTID, 10);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 11);
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSBIDIMENSIONID, 14);
        fieldIndexMap.put(FIELD_PSSYSBIDIMENSIONNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSBIHIERARCHYID, 16);
        fieldIndexMap.put(FIELD_PSSYSBIHIERARCHYNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_USERCAT, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
        fieldIndexMap.put(FIELD_USERTAG3, 23);
        fieldIndexMap.put(FIELD_USERTAG4, 24);
        fieldIndexMap.put(FIELD_VALIDFLAG, 25);
    }
}

