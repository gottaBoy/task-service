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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThreshold;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSThresholdGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSThresholdGroupBase.class);
    public static final String FIELD_BEGINVALUEPSDEFID = "BEGINVALUEPSDEFID";
    public static final String FIELD_BEGINVALUEPSDEFNAME = "BEGINVALUEPSDEFNAME";
    public static final String FIELD_BKCOLORPSDEFID = "BKCOLORPSDEFID";
    public static final String FIELD_BKCOLORPSDEFNAME = "BKCOLORPSDEFNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLORPSDEFID = "COLORPSDEFID";
    public static final String FIELD_COLORPSDEFNAME = "COLORPSDEFNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_DATAPSDEFID = "DATAPSDEFID";
    public static final String FIELD_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String FIELD_ENDVALUEPSDEFID = "ENDVALUEPSDEFID";
    public static final String FIELD_ENDVALUEPSDEFNAME = "ENDVALUEPSDEFNAME";
    public static final String FIELD_ICONCLSPSDEFID = "ICONCLSPSDEFID";
    public static final String FIELD_ICONCLSPSDEFNAME = "ICONCLSPSDEFNAME";
    public static final String FIELD_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String FIELD_INCENDVALUE = "INCENDVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSTHRESHOLDGROUPID = "PSTHRESHOLDGROUPID";
    public static final String FIELD_PSTHRESHOLDGROUPNAME = "PSTHRESHOLDGROUPNAME";
    public static final String FIELD_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String FIELD_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String FIELD_THRESHOLDGROUPTAG = "THRESHOLDGROUPTAG";
    public static final String FIELD_THRESHOLDGROUPTAG2 = "THRESHOLDGROUPTAG2";
    public static final String FIELD_THRESHOLDGROUPTYPE = "THRESHOLDGROUPTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BEGINVALUEPSDEFID = 0;
    private static final int INDEX_BEGINVALUEPSDEFNAME = 1;
    private static final int INDEX_BKCOLORPSDEFID = 2;
    private static final int INDEX_BKCOLORPSDEFNAME = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_COLORPSDEFID = 5;
    private static final int INDEX_COLORPSDEFNAME = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_CUSTOMCOND = 9;
    private static final int INDEX_DATAPSDEFID = 10;
    private static final int INDEX_DATAPSDEFNAME = 11;
    private static final int INDEX_ENDVALUEPSDEFID = 12;
    private static final int INDEX_ENDVALUEPSDEFNAME = 13;
    private static final int INDEX_ICONCLSPSDEFID = 14;
    private static final int INDEX_ICONCLSPSDEFNAME = 15;
    private static final int INDEX_INCBEGINVALUE = 16;
    private static final int INDEX_INCENDVALUE = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_PSDEDSID = 19;
    private static final int INDEX_PSDEDSNAME = 20;
    private static final int INDEX_PSDEID = 21;
    private static final int INDEX_PSDENAME = 22;
    private static final int INDEX_PSMODULEID = 23;
    private static final int INDEX_PSMODULENAME = 24;
    private static final int INDEX_PSSYSDYNAMODELID = 25;
    private static final int INDEX_PSSYSDYNAMODELNAME = 26;
    private static final int INDEX_PSSYSTEMID = 27;
    private static final int INDEX_PSSYSTEMNAME = 28;
    private static final int INDEX_PSTHRESHOLDGROUPID = 29;
    private static final int INDEX_PSTHRESHOLDGROUPNAME = 30;
    private static final int INDEX_TEXTPSDEFID = 31;
    private static final int INDEX_TEXTPSDEFNAME = 32;
    private static final int INDEX_THRESHOLDGROUPTAG = 33;
    private static final int INDEX_THRESHOLDGROUPTAG2 = 34;
    private static final int INDEX_THRESHOLDGROUPTYPE = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_USERTAG3 = 41;
    private static final int INDEX_USERTAG4 = 42;
    private static final int INDEX_VALIDFLAG = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSThresholdGroupBase proxyPSThresholdGroupBase = null;
    private boolean beginvaluepsdefidDirtyFlag = false;
    private boolean beginvaluepsdefnameDirtyFlag = false;
    private boolean bkcolorpsdefidDirtyFlag = false;
    private boolean bkcolorpsdefnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colorpsdefidDirtyFlag = false;
    private boolean colorpsdefnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean datapsdefidDirtyFlag = false;
    private boolean datapsdefnameDirtyFlag = false;
    private boolean endvaluepsdefidDirtyFlag = false;
    private boolean endvaluepsdefnameDirtyFlag = false;
    private boolean iconclspsdefidDirtyFlag = false;
    private boolean iconclspsdefnameDirtyFlag = false;
    private boolean incbeginvalueDirtyFlag = false;
    private boolean incendvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psthresholdgroupidDirtyFlag = false;
    private boolean psthresholdgroupnameDirtyFlag = false;
    private boolean textpsdefidDirtyFlag = false;
    private boolean textpsdefnameDirtyFlag = false;
    private boolean thresholdgrouptagDirtyFlag = false;
    private boolean thresholdgrouptag2DirtyFlag = false;
    private boolean thresholdgrouptypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="beginvaluepsdefid")
    private String beginvaluepsdefid;
    @Column(name="beginvaluepsdefname")
    private String beginvaluepsdefname;
    @Column(name="bkcolorpsdefid")
    private String bkcolorpsdefid;
    @Column(name="bkcolorpsdefname")
    private String bkcolorpsdefname;
    @Column(name="codename")
    private String codename;
    @Column(name="colorpsdefid")
    private String colorpsdefid;
    @Column(name="colorpsdefname")
    private String colorpsdefname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="datapsdefid")
    private String datapsdefid;
    @Column(name="datapsdefname")
    private String datapsdefname;
    @Column(name="endvaluepsdefid")
    private String endvaluepsdefid;
    @Column(name="endvaluepsdefname")
    private String endvaluepsdefname;
    @Column(name="iconclspsdefid")
    private String iconclspsdefid;
    @Column(name="iconclspsdefname")
    private String iconclspsdefname;
    @Column(name="incbeginvalue")
    private Integer incbeginvalue;
    @Column(name="incendvalue")
    private Integer incendvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="psthresholdgroupid")
    private String psthresholdgroupid;
    @Column(name="psthresholdgroupname")
    private String psthresholdgroupname;
    @Column(name="textpsdefid")
    private String textpsdefid;
    @Column(name="textpsdefname")
    private String textpsdefname;
    @Column(name="thresholdgrouptag")
    private String thresholdgrouptag;
    @Column(name="thresholdgrouptag2")
    private String thresholdgrouptag2;
    @Column(name="thresholdgrouptype")
    private String thresholdgrouptype;
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
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objBeginValuePSDEFLock = new Integer(1);
    private PSDEField beginvaluepsdef = null;
    private Integer objBKColorPSDEFLock = new Integer(1);
    private PSDEField bkcolorpsdef = null;
    private Integer objColorPSDEFLock = new Integer(1);
    private PSDEField colorpsdef = null;
    private Integer objDataPSDEFLock = new Integer(1);
    private PSDEField datapsdef = null;
    private Integer objEndValuePSDEFLock = new Integer(1);
    private PSDEField endvaluepsdef = null;
    private Integer objIconClsPSDEFLock = new Integer(1);
    private PSDEField iconclspsdef = null;
    private Integer objTextPSDEFLock = new Integer(1);
    private PSDEField textpsdef = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSThresholdsLock = new Integer(1);
    private ArrayList<PSThreshold> psthresholds = null;

    public void setBeginValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beginvaluepsdefid = string;
        this.beginvaluepsdefidDirtyFlag = true;
    }

    public String getBeginValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValuePSDEFId();
        }
        return this.beginvaluepsdefid;
    }

    public boolean isBeginValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginValuePSDEFIdDirty();
        }
        return this.beginvaluepsdefidDirtyFlag;
    }

    public void resetBeginValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginValuePSDEFId();
            return;
        }
        this.beginvaluepsdefidDirtyFlag = false;
        this.beginvaluepsdefid = null;
    }

    public void setBeginValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beginvaluepsdefname = string;
        this.beginvaluepsdefnameDirtyFlag = true;
    }

    public String getBeginValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValuePSDEFName();
        }
        return this.beginvaluepsdefname;
    }

    public boolean isBeginValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginValuePSDEFNameDirty();
        }
        return this.beginvaluepsdefnameDirtyFlag;
    }

    public void resetBeginValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginValuePSDEFName();
            return;
        }
        this.beginvaluepsdefnameDirtyFlag = false;
        this.beginvaluepsdefname = null;
    }

    public void setBKColorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolorpsdefid = string;
        this.bkcolorpsdefidDirtyFlag = true;
    }

    public String getBKColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEFId();
        }
        return this.bkcolorpsdefid;
    }

    public boolean isBKColorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorPSDEFIdDirty();
        }
        return this.bkcolorpsdefidDirtyFlag;
    }

    public void resetBKColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColorPSDEFId();
            return;
        }
        this.bkcolorpsdefidDirtyFlag = false;
        this.bkcolorpsdefid = null;
    }

    public void setBKColorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolorpsdefname = string;
        this.bkcolorpsdefnameDirtyFlag = true;
    }

    public String getBKColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEFName();
        }
        return this.bkcolorpsdefname;
    }

    public boolean isBKColorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorPSDEFNameDirty();
        }
        return this.bkcolorpsdefnameDirtyFlag;
    }

    public void resetBKColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColorPSDEFName();
            return;
        }
        this.bkcolorpsdefnameDirtyFlag = false;
        this.bkcolorpsdefname = null;
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

    public void setColorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colorpsdefid = string;
        this.colorpsdefidDirtyFlag = true;
    }

    public String getColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEFId();
        }
        return this.colorpsdefid;
    }

    public boolean isColorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorPSDEFIdDirty();
        }
        return this.colorpsdefidDirtyFlag;
    }

    public void resetColorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColorPSDEFId();
            return;
        }
        this.colorpsdefidDirtyFlag = false;
        this.colorpsdefid = null;
    }

    public void setColorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colorpsdefname = string;
        this.colorpsdefnameDirtyFlag = true;
    }

    public String getColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEFName();
        }
        return this.colorpsdefname;
    }

    public boolean isColorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorPSDEFNameDirty();
        }
        return this.colorpsdefnameDirtyFlag;
    }

    public void resetColorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColorPSDEFName();
            return;
        }
        this.colorpsdefnameDirtyFlag = false;
        this.colorpsdefname = null;
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

    public void setDataPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datapsdefid = string;
        this.datapsdefidDirtyFlag = true;
    }

    public String getDataPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEFId();
        }
        return this.datapsdefid;
    }

    public boolean isDataPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataPSDEFIdDirty();
        }
        return this.datapsdefidDirtyFlag;
    }

    public void resetDataPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataPSDEFId();
            return;
        }
        this.datapsdefidDirtyFlag = false;
        this.datapsdefid = null;
    }

    public void setDataPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datapsdefname = string;
        this.datapsdefnameDirtyFlag = true;
    }

    public String getDataPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEFName();
        }
        return this.datapsdefname;
    }

    public boolean isDataPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataPSDEFNameDirty();
        }
        return this.datapsdefnameDirtyFlag;
    }

    public void resetDataPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataPSDEFName();
            return;
        }
        this.datapsdefnameDirtyFlag = false;
        this.datapsdefname = null;
    }

    public void setEndValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.endvaluepsdefid = string;
        this.endvaluepsdefidDirtyFlag = true;
    }

    public String getEndValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValuePSDEFId();
        }
        return this.endvaluepsdefid;
    }

    public boolean isEndValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndValuePSDEFIdDirty();
        }
        return this.endvaluepsdefidDirtyFlag;
    }

    public void resetEndValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndValuePSDEFId();
            return;
        }
        this.endvaluepsdefidDirtyFlag = false;
        this.endvaluepsdefid = null;
    }

    public void setEndValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.endvaluepsdefname = string;
        this.endvaluepsdefnameDirtyFlag = true;
    }

    public String getEndValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValuePSDEFName();
        }
        return this.endvaluepsdefname;
    }

    public boolean isEndValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndValuePSDEFNameDirty();
        }
        return this.endvaluepsdefnameDirtyFlag;
    }

    public void resetEndValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndValuePSDEFName();
            return;
        }
        this.endvaluepsdefnameDirtyFlag = false;
        this.endvaluepsdefname = null;
    }

    public void setIconClsPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconClsPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconclspsdefid = string;
        this.iconclspsdefidDirtyFlag = true;
    }

    public String getIconClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsPSDEFId();
        }
        return this.iconclspsdefid;
    }

    public boolean isIconClsPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsPSDEFIdDirty();
        }
        return this.iconclspsdefidDirtyFlag;
    }

    public void resetIconClsPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconClsPSDEFId();
            return;
        }
        this.iconclspsdefidDirtyFlag = false;
        this.iconclspsdefid = null;
    }

    public void setIconClsPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconClsPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconclspsdefname = string;
        this.iconclspsdefnameDirtyFlag = true;
    }

    public String getIconClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsPSDEFName();
        }
        return this.iconclspsdefname;
    }

    public boolean isIconClsPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsPSDEFNameDirty();
        }
        return this.iconclspsdefnameDirtyFlag;
    }

    public void resetIconClsPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconClsPSDEFName();
            return;
        }
        this.iconclspsdefnameDirtyFlag = false;
        this.iconclspsdefname = null;
    }

    public void setIncBeginValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncBeginValue(n);
            return;
        }
        this.incbeginvalue = n;
        this.incbeginvalueDirtyFlag = true;
    }

    public Integer getIncBeginValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncBeginValue();
        }
        return this.incbeginvalue;
    }

    public boolean isIncBeginValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncBeginValueDirty();
        }
        return this.incbeginvalueDirtyFlag;
    }

    public void resetIncBeginValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncBeginValue();
            return;
        }
        this.incbeginvalueDirtyFlag = false;
        this.incbeginvalue = null;
    }

    public void setIncEndValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncEndValue(n);
            return;
        }
        this.incendvalue = n;
        this.incendvalueDirtyFlag = true;
    }

    public Integer getIncEndValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncEndValue();
        }
        return this.incendvalue;
    }

    public boolean isIncEndValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncEndValueDirty();
        }
        return this.incendvalueDirtyFlag;
    }

    public void resetIncEndValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncEndValue();
            return;
        }
        this.incendvalueDirtyFlag = false;
        this.incendvalue = null;
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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSThresholdGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSThresholdGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psthresholdgroupid = string;
        this.psthresholdgroupidDirtyFlag = true;
    }

    public String getPSThresholdGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdGroupId();
        }
        return this.psthresholdgroupid;
    }

    public boolean isPSThresholdGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSThresholdGroupIdDirty();
        }
        return this.psthresholdgroupidDirtyFlag;
    }

    public void resetPSThresholdGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSThresholdGroupId();
            return;
        }
        this.psthresholdgroupidDirtyFlag = false;
        this.psthresholdgroupid = null;
    }

    public void setPSThresholdGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSThresholdGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psthresholdgroupname = string;
        this.psthresholdgroupnameDirtyFlag = true;
    }

    public String getPSThresholdGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdGroupName();
        }
        return this.psthresholdgroupname;
    }

    public boolean isPSThresholdGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSThresholdGroupNameDirty();
        }
        return this.psthresholdgroupnameDirtyFlag;
    }

    public void resetPSThresholdGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSThresholdGroupName();
            return;
        }
        this.psthresholdgroupnameDirtyFlag = false;
        this.psthresholdgroupname = null;
    }

    public void setTextPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefid = string;
        this.textpsdefidDirtyFlag = true;
    }

    public String getTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFId();
        }
        return this.textpsdefid;
    }

    public boolean isTextPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFIdDirty();
        }
        return this.textpsdefidDirtyFlag;
    }

    public void resetTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFId();
            return;
        }
        this.textpsdefidDirtyFlag = false;
        this.textpsdefid = null;
    }

    public void setTextPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefname = string;
        this.textpsdefnameDirtyFlag = true;
    }

    public String getTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFName();
        }
        return this.textpsdefname;
    }

    public boolean isTextPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFNameDirty();
        }
        return this.textpsdefnameDirtyFlag;
    }

    public void resetTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFName();
            return;
        }
        this.textpsdefnameDirtyFlag = false;
        this.textpsdefname = null;
    }

    public void setThresholdGroupTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThresholdGroupTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.thresholdgrouptag = string;
        this.thresholdgrouptagDirtyFlag = true;
    }

    public String getThresholdGroupTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThresholdGroupTag();
        }
        return this.thresholdgrouptag;
    }

    public boolean isThresholdGroupTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThresholdGroupTagDirty();
        }
        return this.thresholdgrouptagDirtyFlag;
    }

    public void resetThresholdGroupTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThresholdGroupTag();
            return;
        }
        this.thresholdgrouptagDirtyFlag = false;
        this.thresholdgrouptag = null;
    }

    public void setThresholdGroupTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThresholdGroupTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.thresholdgrouptag2 = string;
        this.thresholdgrouptag2DirtyFlag = true;
    }

    public String getThresholdGroupTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThresholdGroupTag2();
        }
        return this.thresholdgrouptag2;
    }

    public boolean isThresholdGroupTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThresholdGroupTag2Dirty();
        }
        return this.thresholdgrouptag2DirtyFlag;
    }

    public void resetThresholdGroupTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThresholdGroupTag2();
            return;
        }
        this.thresholdgrouptag2DirtyFlag = false;
        this.thresholdgrouptag2 = null;
    }

    public void setThresholdGroupType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThresholdGroupType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.thresholdgrouptype = string;
        this.thresholdgrouptypeDirtyFlag = true;
    }

    public String getThresholdGroupType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThresholdGroupType();
        }
        return this.thresholdgrouptype;
    }

    public boolean isThresholdGroupTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThresholdGroupTypeDirty();
        }
        return this.thresholdgrouptypeDirtyFlag;
    }

    public void resetThresholdGroupType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThresholdGroupType();
            return;
        }
        this.thresholdgrouptypeDirtyFlag = false;
        this.thresholdgrouptype = null;
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
        PSThresholdGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSThresholdGroupBase pSThresholdGroupBase) {
        pSThresholdGroupBase.resetBeginValuePSDEFId();
        pSThresholdGroupBase.resetBeginValuePSDEFName();
        pSThresholdGroupBase.resetBKColorPSDEFId();
        pSThresholdGroupBase.resetBKColorPSDEFName();
        pSThresholdGroupBase.resetCodeName();
        pSThresholdGroupBase.resetColorPSDEFId();
        pSThresholdGroupBase.resetColorPSDEFName();
        pSThresholdGroupBase.resetCreateDate();
        pSThresholdGroupBase.resetCreateMan();
        pSThresholdGroupBase.resetCustomCond();
        pSThresholdGroupBase.resetDataPSDEFId();
        pSThresholdGroupBase.resetDataPSDEFName();
        pSThresholdGroupBase.resetEndValuePSDEFId();
        pSThresholdGroupBase.resetEndValuePSDEFName();
        pSThresholdGroupBase.resetIconClsPSDEFId();
        pSThresholdGroupBase.resetIconClsPSDEFName();
        pSThresholdGroupBase.resetIncBeginValue();
        pSThresholdGroupBase.resetIncEndValue();
        pSThresholdGroupBase.resetMemo();
        pSThresholdGroupBase.resetPSDEDSId();
        pSThresholdGroupBase.resetPSDEDSName();
        pSThresholdGroupBase.resetPSDEId();
        pSThresholdGroupBase.resetPSDEName();
        pSThresholdGroupBase.resetPSModuleId();
        pSThresholdGroupBase.resetPSModuleName();
        pSThresholdGroupBase.resetPSSysDynaModelId();
        pSThresholdGroupBase.resetPSSysDynaModelName();
        pSThresholdGroupBase.resetPSSystemId();
        pSThresholdGroupBase.resetPSSystemName();
        pSThresholdGroupBase.resetPSThresholdGroupId();
        pSThresholdGroupBase.resetPSThresholdGroupName();
        pSThresholdGroupBase.resetTextPSDEFId();
        pSThresholdGroupBase.resetTextPSDEFName();
        pSThresholdGroupBase.resetThresholdGroupTag();
        pSThresholdGroupBase.resetThresholdGroupTag2();
        pSThresholdGroupBase.resetThresholdGroupType();
        pSThresholdGroupBase.resetUpdateDate();
        pSThresholdGroupBase.resetUpdateMan();
        pSThresholdGroupBase.resetUserCat();
        pSThresholdGroupBase.resetUserTag();
        pSThresholdGroupBase.resetUserTag2();
        pSThresholdGroupBase.resetUserTag3();
        pSThresholdGroupBase.resetUserTag4();
        pSThresholdGroupBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginValuePSDEFIdDirty()) {
            hashMap.put(FIELD_BEGINVALUEPSDEFID, this.getBeginValuePSDEFId());
        }
        if (!bl || this.isBeginValuePSDEFNameDirty()) {
            hashMap.put(FIELD_BEGINVALUEPSDEFNAME, this.getBeginValuePSDEFName());
        }
        if (!bl || this.isBKColorPSDEFIdDirty()) {
            hashMap.put(FIELD_BKCOLORPSDEFID, this.getBKColorPSDEFId());
        }
        if (!bl || this.isBKColorPSDEFNameDirty()) {
            hashMap.put(FIELD_BKCOLORPSDEFNAME, this.getBKColorPSDEFName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColorPSDEFIdDirty()) {
            hashMap.put(FIELD_COLORPSDEFID, this.getColorPSDEFId());
        }
        if (!bl || this.isColorPSDEFNameDirty()) {
            hashMap.put(FIELD_COLORPSDEFNAME, this.getColorPSDEFName());
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
        if (!bl || this.isDataPSDEFIdDirty()) {
            hashMap.put(FIELD_DATAPSDEFID, this.getDataPSDEFId());
        }
        if (!bl || this.isDataPSDEFNameDirty()) {
            hashMap.put(FIELD_DATAPSDEFNAME, this.getDataPSDEFName());
        }
        if (!bl || this.isEndValuePSDEFIdDirty()) {
            hashMap.put(FIELD_ENDVALUEPSDEFID, this.getEndValuePSDEFId());
        }
        if (!bl || this.isEndValuePSDEFNameDirty()) {
            hashMap.put(FIELD_ENDVALUEPSDEFNAME, this.getEndValuePSDEFName());
        }
        if (!bl || this.isIconClsPSDEFIdDirty()) {
            hashMap.put(FIELD_ICONCLSPSDEFID, this.getIconClsPSDEFId());
        }
        if (!bl || this.isIconClsPSDEFNameDirty()) {
            hashMap.put(FIELD_ICONCLSPSDEFNAME, this.getIconClsPSDEFName());
        }
        if (!bl || this.isIncBeginValueDirty()) {
            hashMap.put(FIELD_INCBEGINVALUE, this.getIncBeginValue());
        }
        if (!bl || this.isIncEndValueDirty()) {
            hashMap.put(FIELD_INCENDVALUE, this.getIncEndValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSThresholdGroupIdDirty()) {
            hashMap.put(FIELD_PSTHRESHOLDGROUPID, this.getPSThresholdGroupId());
        }
        if (!bl || this.isPSThresholdGroupNameDirty()) {
            hashMap.put(FIELD_PSTHRESHOLDGROUPNAME, this.getPSThresholdGroupName());
        }
        if (!bl || this.isTextPSDEFIdDirty()) {
            hashMap.put(FIELD_TEXTPSDEFID, this.getTextPSDEFId());
        }
        if (!bl || this.isTextPSDEFNameDirty()) {
            hashMap.put(FIELD_TEXTPSDEFNAME, this.getTextPSDEFName());
        }
        if (!bl || this.isThresholdGroupTagDirty()) {
            hashMap.put(FIELD_THRESHOLDGROUPTAG, this.getThresholdGroupTag());
        }
        if (!bl || this.isThresholdGroupTag2Dirty()) {
            hashMap.put(FIELD_THRESHOLDGROUPTAG2, this.getThresholdGroupTag2());
        }
        if (!bl || this.isThresholdGroupTypeDirty()) {
            hashMap.put(FIELD_THRESHOLDGROUPTYPE, this.getThresholdGroupType());
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
        return PSThresholdGroupBase.get(this, n);
    }

    private static Object get(PSThresholdGroupBase pSThresholdGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSThresholdGroupBase.getBeginValuePSDEFId();
            }
            case 1: {
                return pSThresholdGroupBase.getBeginValuePSDEFName();
            }
            case 2: {
                return pSThresholdGroupBase.getBKColorPSDEFId();
            }
            case 3: {
                return pSThresholdGroupBase.getBKColorPSDEFName();
            }
            case 4: {
                return pSThresholdGroupBase.getCodeName();
            }
            case 5: {
                return pSThresholdGroupBase.getColorPSDEFId();
            }
            case 6: {
                return pSThresholdGroupBase.getColorPSDEFName();
            }
            case 7: {
                return pSThresholdGroupBase.getCreateDate();
            }
            case 8: {
                return pSThresholdGroupBase.getCreateMan();
            }
            case 9: {
                return pSThresholdGroupBase.getCustomCond();
            }
            case 10: {
                return pSThresholdGroupBase.getDataPSDEFId();
            }
            case 11: {
                return pSThresholdGroupBase.getDataPSDEFName();
            }
            case 12: {
                return pSThresholdGroupBase.getEndValuePSDEFId();
            }
            case 13: {
                return pSThresholdGroupBase.getEndValuePSDEFName();
            }
            case 14: {
                return pSThresholdGroupBase.getIconClsPSDEFId();
            }
            case 15: {
                return pSThresholdGroupBase.getIconClsPSDEFName();
            }
            case 16: {
                return pSThresholdGroupBase.getIncBeginValue();
            }
            case 17: {
                return pSThresholdGroupBase.getIncEndValue();
            }
            case 18: {
                return pSThresholdGroupBase.getMemo();
            }
            case 19: {
                return pSThresholdGroupBase.getPSDEDSId();
            }
            case 20: {
                return pSThresholdGroupBase.getPSDEDSName();
            }
            case 21: {
                return pSThresholdGroupBase.getPSDEId();
            }
            case 22: {
                return pSThresholdGroupBase.getPSDEName();
            }
            case 23: {
                return pSThresholdGroupBase.getPSModuleId();
            }
            case 24: {
                return pSThresholdGroupBase.getPSModuleName();
            }
            case 25: {
                return pSThresholdGroupBase.getPSSysDynaModelId();
            }
            case 26: {
                return pSThresholdGroupBase.getPSSysDynaModelName();
            }
            case 27: {
                return pSThresholdGroupBase.getPSSystemId();
            }
            case 28: {
                return pSThresholdGroupBase.getPSSystemName();
            }
            case 29: {
                return pSThresholdGroupBase.getPSThresholdGroupId();
            }
            case 30: {
                return pSThresholdGroupBase.getPSThresholdGroupName();
            }
            case 31: {
                return pSThresholdGroupBase.getTextPSDEFId();
            }
            case 32: {
                return pSThresholdGroupBase.getTextPSDEFName();
            }
            case 33: {
                return pSThresholdGroupBase.getThresholdGroupTag();
            }
            case 34: {
                return pSThresholdGroupBase.getThresholdGroupTag2();
            }
            case 35: {
                return pSThresholdGroupBase.getThresholdGroupType();
            }
            case 36: {
                return pSThresholdGroupBase.getUpdateDate();
            }
            case 37: {
                return pSThresholdGroupBase.getUpdateMan();
            }
            case 38: {
                return pSThresholdGroupBase.getUserCat();
            }
            case 39: {
                return pSThresholdGroupBase.getUserTag();
            }
            case 40: {
                return pSThresholdGroupBase.getUserTag2();
            }
            case 41: {
                return pSThresholdGroupBase.getUserTag3();
            }
            case 42: {
                return pSThresholdGroupBase.getUserTag4();
            }
            case 43: {
                return pSThresholdGroupBase.getValidFlag();
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
        PSThresholdGroupBase.set(this, n, object);
    }

    private static void set(PSThresholdGroupBase pSThresholdGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSThresholdGroupBase.setBeginValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSThresholdGroupBase.setBeginValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSThresholdGroupBase.setBKColorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSThresholdGroupBase.setBKColorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSThresholdGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSThresholdGroupBase.setColorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSThresholdGroupBase.setColorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSThresholdGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSThresholdGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSThresholdGroupBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSThresholdGroupBase.setDataPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSThresholdGroupBase.setDataPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSThresholdGroupBase.setEndValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSThresholdGroupBase.setEndValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSThresholdGroupBase.setIconClsPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSThresholdGroupBase.setIconClsPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSThresholdGroupBase.setIncBeginValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSThresholdGroupBase.setIncEndValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSThresholdGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSThresholdGroupBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSThresholdGroupBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSThresholdGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSThresholdGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSThresholdGroupBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSThresholdGroupBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSThresholdGroupBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSThresholdGroupBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSThresholdGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSThresholdGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSThresholdGroupBase.setPSThresholdGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSThresholdGroupBase.setPSThresholdGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSThresholdGroupBase.setTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSThresholdGroupBase.setTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSThresholdGroupBase.setThresholdGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSThresholdGroupBase.setThresholdGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSThresholdGroupBase.setThresholdGroupType(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSThresholdGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSThresholdGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSThresholdGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSThresholdGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSThresholdGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSThresholdGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSThresholdGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSThresholdGroupBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSThresholdGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSThresholdGroupBase pSThresholdGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSThresholdGroupBase.getBeginValuePSDEFId() == null;
            }
            case 1: {
                return pSThresholdGroupBase.getBeginValuePSDEFName() == null;
            }
            case 2: {
                return pSThresholdGroupBase.getBKColorPSDEFId() == null;
            }
            case 3: {
                return pSThresholdGroupBase.getBKColorPSDEFName() == null;
            }
            case 4: {
                return pSThresholdGroupBase.getCodeName() == null;
            }
            case 5: {
                return pSThresholdGroupBase.getColorPSDEFId() == null;
            }
            case 6: {
                return pSThresholdGroupBase.getColorPSDEFName() == null;
            }
            case 7: {
                return pSThresholdGroupBase.getCreateDate() == null;
            }
            case 8: {
                return pSThresholdGroupBase.getCreateMan() == null;
            }
            case 9: {
                return pSThresholdGroupBase.getCustomCond() == null;
            }
            case 10: {
                return pSThresholdGroupBase.getDataPSDEFId() == null;
            }
            case 11: {
                return pSThresholdGroupBase.getDataPSDEFName() == null;
            }
            case 12: {
                return pSThresholdGroupBase.getEndValuePSDEFId() == null;
            }
            case 13: {
                return pSThresholdGroupBase.getEndValuePSDEFName() == null;
            }
            case 14: {
                return pSThresholdGroupBase.getIconClsPSDEFId() == null;
            }
            case 15: {
                return pSThresholdGroupBase.getIconClsPSDEFName() == null;
            }
            case 16: {
                return pSThresholdGroupBase.getIncBeginValue() == null;
            }
            case 17: {
                return pSThresholdGroupBase.getIncEndValue() == null;
            }
            case 18: {
                return pSThresholdGroupBase.getMemo() == null;
            }
            case 19: {
                return pSThresholdGroupBase.getPSDEDSId() == null;
            }
            case 20: {
                return pSThresholdGroupBase.getPSDEDSName() == null;
            }
            case 21: {
                return pSThresholdGroupBase.getPSDEId() == null;
            }
            case 22: {
                return pSThresholdGroupBase.getPSDEName() == null;
            }
            case 23: {
                return pSThresholdGroupBase.getPSModuleId() == null;
            }
            case 24: {
                return pSThresholdGroupBase.getPSModuleName() == null;
            }
            case 25: {
                return pSThresholdGroupBase.getPSSysDynaModelId() == null;
            }
            case 26: {
                return pSThresholdGroupBase.getPSSysDynaModelName() == null;
            }
            case 27: {
                return pSThresholdGroupBase.getPSSystemId() == null;
            }
            case 28: {
                return pSThresholdGroupBase.getPSSystemName() == null;
            }
            case 29: {
                return pSThresholdGroupBase.getPSThresholdGroupId() == null;
            }
            case 30: {
                return pSThresholdGroupBase.getPSThresholdGroupName() == null;
            }
            case 31: {
                return pSThresholdGroupBase.getTextPSDEFId() == null;
            }
            case 32: {
                return pSThresholdGroupBase.getTextPSDEFName() == null;
            }
            case 33: {
                return pSThresholdGroupBase.getThresholdGroupTag() == null;
            }
            case 34: {
                return pSThresholdGroupBase.getThresholdGroupTag2() == null;
            }
            case 35: {
                return pSThresholdGroupBase.getThresholdGroupType() == null;
            }
            case 36: {
                return pSThresholdGroupBase.getUpdateDate() == null;
            }
            case 37: {
                return pSThresholdGroupBase.getUpdateMan() == null;
            }
            case 38: {
                return pSThresholdGroupBase.getUserCat() == null;
            }
            case 39: {
                return pSThresholdGroupBase.getUserTag() == null;
            }
            case 40: {
                return pSThresholdGroupBase.getUserTag2() == null;
            }
            case 41: {
                return pSThresholdGroupBase.getUserTag3() == null;
            }
            case 42: {
                return pSThresholdGroupBase.getUserTag4() == null;
            }
            case 43: {
                return pSThresholdGroupBase.getValidFlag() == null;
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
        return PSThresholdGroupBase.contains(this, n);
    }

    private static boolean contains(PSThresholdGroupBase pSThresholdGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSThresholdGroupBase.isBeginValuePSDEFIdDirty();
            }
            case 1: {
                return pSThresholdGroupBase.isBeginValuePSDEFNameDirty();
            }
            case 2: {
                return pSThresholdGroupBase.isBKColorPSDEFIdDirty();
            }
            case 3: {
                return pSThresholdGroupBase.isBKColorPSDEFNameDirty();
            }
            case 4: {
                return pSThresholdGroupBase.isCodeNameDirty();
            }
            case 5: {
                return pSThresholdGroupBase.isColorPSDEFIdDirty();
            }
            case 6: {
                return pSThresholdGroupBase.isColorPSDEFNameDirty();
            }
            case 7: {
                return pSThresholdGroupBase.isCreateDateDirty();
            }
            case 8: {
                return pSThresholdGroupBase.isCreateManDirty();
            }
            case 9: {
                return pSThresholdGroupBase.isCustomCondDirty();
            }
            case 10: {
                return pSThresholdGroupBase.isDataPSDEFIdDirty();
            }
            case 11: {
                return pSThresholdGroupBase.isDataPSDEFNameDirty();
            }
            case 12: {
                return pSThresholdGroupBase.isEndValuePSDEFIdDirty();
            }
            case 13: {
                return pSThresholdGroupBase.isEndValuePSDEFNameDirty();
            }
            case 14: {
                return pSThresholdGroupBase.isIconClsPSDEFIdDirty();
            }
            case 15: {
                return pSThresholdGroupBase.isIconClsPSDEFNameDirty();
            }
            case 16: {
                return pSThresholdGroupBase.isIncBeginValueDirty();
            }
            case 17: {
                return pSThresholdGroupBase.isIncEndValueDirty();
            }
            case 18: {
                return pSThresholdGroupBase.isMemoDirty();
            }
            case 19: {
                return pSThresholdGroupBase.isPSDEDSIdDirty();
            }
            case 20: {
                return pSThresholdGroupBase.isPSDEDSNameDirty();
            }
            case 21: {
                return pSThresholdGroupBase.isPSDEIdDirty();
            }
            case 22: {
                return pSThresholdGroupBase.isPSDENameDirty();
            }
            case 23: {
                return pSThresholdGroupBase.isPSModuleIdDirty();
            }
            case 24: {
                return pSThresholdGroupBase.isPSModuleNameDirty();
            }
            case 25: {
                return pSThresholdGroupBase.isPSSysDynaModelIdDirty();
            }
            case 26: {
                return pSThresholdGroupBase.isPSSysDynaModelNameDirty();
            }
            case 27: {
                return pSThresholdGroupBase.isPSSystemIdDirty();
            }
            case 28: {
                return pSThresholdGroupBase.isPSSystemNameDirty();
            }
            case 29: {
                return pSThresholdGroupBase.isPSThresholdGroupIdDirty();
            }
            case 30: {
                return pSThresholdGroupBase.isPSThresholdGroupNameDirty();
            }
            case 31: {
                return pSThresholdGroupBase.isTextPSDEFIdDirty();
            }
            case 32: {
                return pSThresholdGroupBase.isTextPSDEFNameDirty();
            }
            case 33: {
                return pSThresholdGroupBase.isThresholdGroupTagDirty();
            }
            case 34: {
                return pSThresholdGroupBase.isThresholdGroupTag2Dirty();
            }
            case 35: {
                return pSThresholdGroupBase.isThresholdGroupTypeDirty();
            }
            case 36: {
                return pSThresholdGroupBase.isUpdateDateDirty();
            }
            case 37: {
                return pSThresholdGroupBase.isUpdateManDirty();
            }
            case 38: {
                return pSThresholdGroupBase.isUserCatDirty();
            }
            case 39: {
                return pSThresholdGroupBase.isUserTagDirty();
            }
            case 40: {
                return pSThresholdGroupBase.isUserTag2Dirty();
            }
            case 41: {
                return pSThresholdGroupBase.isUserTag3Dirty();
            }
            case 42: {
                return pSThresholdGroupBase.isUserTag4Dirty();
            }
            case 43: {
                return pSThresholdGroupBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSThresholdGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSThresholdGroupBase pSThresholdGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSThresholdGroupBase.getBeginValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginvaluepsdefid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getBeginValuePSDEFId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getBeginValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginvaluepsdefname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getBeginValuePSDEFName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getBKColorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolorpsdefid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getBKColorPSDEFId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getBKColorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolorpsdefname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getBKColorPSDEFName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getColorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colorpsdefid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getColorPSDEFId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getColorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colorpsdefname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getColorPSDEFName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getDataPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getDataPSDEFId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getDataPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapsdefname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getDataPSDEFName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getEndValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endvaluepsdefid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getEndValuePSDEFId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getEndValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endvaluepsdefname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getEndValuePSDEFName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getIconClsPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconclspsdefid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getIconClsPSDEFId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getIconClsPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconclspsdefname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getIconClsPSDEFName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getIncBeginValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incbeginvalue", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getIncBeginValue()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getIncEndValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incendvalue", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getIncEndValue()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSThresholdGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psthresholdgroupid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSThresholdGroupId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getPSThresholdGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psthresholdgroupname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getPSThresholdGroupName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefid", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getTextPSDEFId()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefname", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getTextPSDEFName()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getThresholdGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"thresholdgrouptag", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getThresholdGroupTag()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getThresholdGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"thresholdgrouptag2", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getThresholdGroupTag2()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getThresholdGroupType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"thresholdgrouptype", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getThresholdGroupType()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSThresholdGroupBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSThresholdGroupBase.getJSONValue((Object)pSThresholdGroupBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSThresholdGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSThresholdGroupBase pSThresholdGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSThresholdGroupBase.getBeginValuePSDEFId() != null) {
            object = pSThresholdGroupBase.getBeginValuePSDEFId();
            xmlNode.setAttribute(FIELD_BEGINVALUEPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSThresholdGroupBase.getBeginValuePSDEFName() != null) {
            object = pSThresholdGroupBase.getBeginValuePSDEFName();
            xmlNode.setAttribute(FIELD_BEGINVALUEPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSThresholdGroupBase.getBKColorPSDEFId() != null) {
            object = pSThresholdGroupBase.getBKColorPSDEFId();
            xmlNode.setAttribute(FIELD_BKCOLORPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSThresholdGroupBase.getBKColorPSDEFName() != null) {
            object = pSThresholdGroupBase.getBKColorPSDEFName();
            xmlNode.setAttribute(FIELD_BKCOLORPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSThresholdGroupBase.getCodeName() != null) {
            object = pSThresholdGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSThresholdGroupBase.getColorPSDEFId() != null) {
            object = pSThresholdGroupBase.getColorPSDEFId();
            xmlNode.setAttribute(FIELD_COLORPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSThresholdGroupBase.getColorPSDEFName() != null) {
            object = pSThresholdGroupBase.getColorPSDEFName();
            xmlNode.setAttribute(FIELD_COLORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getCreateDate() != null) {
            object = pSThresholdGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSThresholdGroupBase.getCreateMan() != null) {
            object = pSThresholdGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getCustomCond() != null) {
            object = pSThresholdGroupBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getDataPSDEFId() != null) {
            object = pSThresholdGroupBase.getDataPSDEFId();
            xmlNode.setAttribute(FIELD_DATAPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getDataPSDEFName() != null) {
            object = pSThresholdGroupBase.getDataPSDEFName();
            xmlNode.setAttribute(FIELD_DATAPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getEndValuePSDEFId() != null) {
            object = pSThresholdGroupBase.getEndValuePSDEFId();
            xmlNode.setAttribute(FIELD_ENDVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getEndValuePSDEFName() != null) {
            object = pSThresholdGroupBase.getEndValuePSDEFName();
            xmlNode.setAttribute(FIELD_ENDVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getIconClsPSDEFId() != null) {
            object = pSThresholdGroupBase.getIconClsPSDEFId();
            xmlNode.setAttribute(FIELD_ICONCLSPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getIconClsPSDEFName() != null) {
            object = pSThresholdGroupBase.getIconClsPSDEFName();
            xmlNode.setAttribute(FIELD_ICONCLSPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getIncBeginValue() != null) {
            object = pSThresholdGroupBase.getIncBeginValue();
            xmlNode.setAttribute(FIELD_INCBEGINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSThresholdGroupBase.getIncEndValue() != null) {
            object = pSThresholdGroupBase.getIncEndValue();
            xmlNode.setAttribute(FIELD_INCENDVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSThresholdGroupBase.getMemo() != null) {
            object = pSThresholdGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSDEDSId() != null) {
            object = pSThresholdGroupBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSDEDSName() != null) {
            object = pSThresholdGroupBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSDEId() != null) {
            object = pSThresholdGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSDEName() != null) {
            object = pSThresholdGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSModuleId() != null) {
            object = pSThresholdGroupBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSModuleName() != null) {
            object = pSThresholdGroupBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSSysDynaModelId() != null) {
            object = pSThresholdGroupBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSSysDynaModelName() != null) {
            object = pSThresholdGroupBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSSystemId() != null) {
            object = pSThresholdGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSSystemName() != null) {
            object = pSThresholdGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSThresholdGroupId() != null) {
            object = pSThresholdGroupBase.getPSThresholdGroupId();
            xmlNode.setAttribute(FIELD_PSTHRESHOLDGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getPSThresholdGroupName() != null) {
            object = pSThresholdGroupBase.getPSThresholdGroupName();
            xmlNode.setAttribute(FIELD_PSTHRESHOLDGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getTextPSDEFId() != null) {
            object = pSThresholdGroupBase.getTextPSDEFId();
            xmlNode.setAttribute(FIELD_TEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getTextPSDEFName() != null) {
            object = pSThresholdGroupBase.getTextPSDEFName();
            xmlNode.setAttribute(FIELD_TEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getThresholdGroupTag() != null) {
            object = pSThresholdGroupBase.getThresholdGroupTag();
            xmlNode.setAttribute(FIELD_THRESHOLDGROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getThresholdGroupTag2() != null) {
            object = pSThresholdGroupBase.getThresholdGroupTag2();
            xmlNode.setAttribute(FIELD_THRESHOLDGROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getThresholdGroupType() != null) {
            object = pSThresholdGroupBase.getThresholdGroupType();
            xmlNode.setAttribute(FIELD_THRESHOLDGROUPTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getUpdateDate() != null) {
            object = pSThresholdGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSThresholdGroupBase.getUpdateMan() != null) {
            object = pSThresholdGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getUserCat() != null) {
            object = pSThresholdGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getUserTag() != null) {
            object = pSThresholdGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getUserTag2() != null) {
            object = pSThresholdGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getUserTag3() != null) {
            object = pSThresholdGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getUserTag4() != null) {
            object = pSThresholdGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdGroupBase.getValidFlag() != null) {
            object = pSThresholdGroupBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSThresholdGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSThresholdGroupBase pSThresholdGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSThresholdGroupBase.isBeginValuePSDEFIdDirty() && (bl || pSThresholdGroupBase.getBeginValuePSDEFId() != null)) {
            iDataObject.set(FIELD_BEGINVALUEPSDEFID, (Object)pSThresholdGroupBase.getBeginValuePSDEFId());
        }
        if (pSThresholdGroupBase.isBeginValuePSDEFNameDirty() && (bl || pSThresholdGroupBase.getBeginValuePSDEFName() != null)) {
            iDataObject.set(FIELD_BEGINVALUEPSDEFNAME, (Object)pSThresholdGroupBase.getBeginValuePSDEFName());
        }
        if (pSThresholdGroupBase.isBKColorPSDEFIdDirty() && (bl || pSThresholdGroupBase.getBKColorPSDEFId() != null)) {
            iDataObject.set(FIELD_BKCOLORPSDEFID, (Object)pSThresholdGroupBase.getBKColorPSDEFId());
        }
        if (pSThresholdGroupBase.isBKColorPSDEFNameDirty() && (bl || pSThresholdGroupBase.getBKColorPSDEFName() != null)) {
            iDataObject.set(FIELD_BKCOLORPSDEFNAME, (Object)pSThresholdGroupBase.getBKColorPSDEFName());
        }
        if (pSThresholdGroupBase.isCodeNameDirty() && (bl || pSThresholdGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSThresholdGroupBase.getCodeName());
        }
        if (pSThresholdGroupBase.isColorPSDEFIdDirty() && (bl || pSThresholdGroupBase.getColorPSDEFId() != null)) {
            iDataObject.set(FIELD_COLORPSDEFID, (Object)pSThresholdGroupBase.getColorPSDEFId());
        }
        if (pSThresholdGroupBase.isColorPSDEFNameDirty() && (bl || pSThresholdGroupBase.getColorPSDEFName() != null)) {
            iDataObject.set(FIELD_COLORPSDEFNAME, (Object)pSThresholdGroupBase.getColorPSDEFName());
        }
        if (pSThresholdGroupBase.isCreateDateDirty() && (bl || pSThresholdGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSThresholdGroupBase.getCreateDate());
        }
        if (pSThresholdGroupBase.isCreateManDirty() && (bl || pSThresholdGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSThresholdGroupBase.getCreateMan());
        }
        if (pSThresholdGroupBase.isCustomCondDirty() && (bl || pSThresholdGroupBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSThresholdGroupBase.getCustomCond());
        }
        if (pSThresholdGroupBase.isDataPSDEFIdDirty() && (bl || pSThresholdGroupBase.getDataPSDEFId() != null)) {
            iDataObject.set(FIELD_DATAPSDEFID, (Object)pSThresholdGroupBase.getDataPSDEFId());
        }
        if (pSThresholdGroupBase.isDataPSDEFNameDirty() && (bl || pSThresholdGroupBase.getDataPSDEFName() != null)) {
            iDataObject.set(FIELD_DATAPSDEFNAME, (Object)pSThresholdGroupBase.getDataPSDEFName());
        }
        if (pSThresholdGroupBase.isEndValuePSDEFIdDirty() && (bl || pSThresholdGroupBase.getEndValuePSDEFId() != null)) {
            iDataObject.set(FIELD_ENDVALUEPSDEFID, (Object)pSThresholdGroupBase.getEndValuePSDEFId());
        }
        if (pSThresholdGroupBase.isEndValuePSDEFNameDirty() && (bl || pSThresholdGroupBase.getEndValuePSDEFName() != null)) {
            iDataObject.set(FIELD_ENDVALUEPSDEFNAME, (Object)pSThresholdGroupBase.getEndValuePSDEFName());
        }
        if (pSThresholdGroupBase.isIconClsPSDEFIdDirty() && (bl || pSThresholdGroupBase.getIconClsPSDEFId() != null)) {
            iDataObject.set(FIELD_ICONCLSPSDEFID, (Object)pSThresholdGroupBase.getIconClsPSDEFId());
        }
        if (pSThresholdGroupBase.isIconClsPSDEFNameDirty() && (bl || pSThresholdGroupBase.getIconClsPSDEFName() != null)) {
            iDataObject.set(FIELD_ICONCLSPSDEFNAME, (Object)pSThresholdGroupBase.getIconClsPSDEFName());
        }
        if (pSThresholdGroupBase.isIncBeginValueDirty() && (bl || pSThresholdGroupBase.getIncBeginValue() != null)) {
            iDataObject.set(FIELD_INCBEGINVALUE, (Object)pSThresholdGroupBase.getIncBeginValue());
        }
        if (pSThresholdGroupBase.isIncEndValueDirty() && (bl || pSThresholdGroupBase.getIncEndValue() != null)) {
            iDataObject.set(FIELD_INCENDVALUE, (Object)pSThresholdGroupBase.getIncEndValue());
        }
        if (pSThresholdGroupBase.isMemoDirty() && (bl || pSThresholdGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSThresholdGroupBase.getMemo());
        }
        if (pSThresholdGroupBase.isPSDEDSIdDirty() && (bl || pSThresholdGroupBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSThresholdGroupBase.getPSDEDSId());
        }
        if (pSThresholdGroupBase.isPSDEDSNameDirty() && (bl || pSThresholdGroupBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSThresholdGroupBase.getPSDEDSName());
        }
        if (pSThresholdGroupBase.isPSDEIdDirty() && (bl || pSThresholdGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSThresholdGroupBase.getPSDEId());
        }
        if (pSThresholdGroupBase.isPSDENameDirty() && (bl || pSThresholdGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSThresholdGroupBase.getPSDEName());
        }
        if (pSThresholdGroupBase.isPSModuleIdDirty() && (bl || pSThresholdGroupBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSThresholdGroupBase.getPSModuleId());
        }
        if (pSThresholdGroupBase.isPSModuleNameDirty() && (bl || pSThresholdGroupBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSThresholdGroupBase.getPSModuleName());
        }
        if (pSThresholdGroupBase.isPSSysDynaModelIdDirty() && (bl || pSThresholdGroupBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSThresholdGroupBase.getPSSysDynaModelId());
        }
        if (pSThresholdGroupBase.isPSSysDynaModelNameDirty() && (bl || pSThresholdGroupBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSThresholdGroupBase.getPSSysDynaModelName());
        }
        if (pSThresholdGroupBase.isPSSystemIdDirty() && (bl || pSThresholdGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSThresholdGroupBase.getPSSystemId());
        }
        if (pSThresholdGroupBase.isPSSystemNameDirty() && (bl || pSThresholdGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSThresholdGroupBase.getPSSystemName());
        }
        if (pSThresholdGroupBase.isPSThresholdGroupIdDirty() && (bl || pSThresholdGroupBase.getPSThresholdGroupId() != null)) {
            iDataObject.set(FIELD_PSTHRESHOLDGROUPID, (Object)pSThresholdGroupBase.getPSThresholdGroupId());
        }
        if (pSThresholdGroupBase.isPSThresholdGroupNameDirty() && (bl || pSThresholdGroupBase.getPSThresholdGroupName() != null)) {
            iDataObject.set(FIELD_PSTHRESHOLDGROUPNAME, (Object)pSThresholdGroupBase.getPSThresholdGroupName());
        }
        if (pSThresholdGroupBase.isTextPSDEFIdDirty() && (bl || pSThresholdGroupBase.getTextPSDEFId() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFID, (Object)pSThresholdGroupBase.getTextPSDEFId());
        }
        if (pSThresholdGroupBase.isTextPSDEFNameDirty() && (bl || pSThresholdGroupBase.getTextPSDEFName() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFNAME, (Object)pSThresholdGroupBase.getTextPSDEFName());
        }
        if (pSThresholdGroupBase.isThresholdGroupTagDirty() && (bl || pSThresholdGroupBase.getThresholdGroupTag() != null)) {
            iDataObject.set(FIELD_THRESHOLDGROUPTAG, (Object)pSThresholdGroupBase.getThresholdGroupTag());
        }
        if (pSThresholdGroupBase.isThresholdGroupTag2Dirty() && (bl || pSThresholdGroupBase.getThresholdGroupTag2() != null)) {
            iDataObject.set(FIELD_THRESHOLDGROUPTAG2, (Object)pSThresholdGroupBase.getThresholdGroupTag2());
        }
        if (pSThresholdGroupBase.isThresholdGroupTypeDirty() && (bl || pSThresholdGroupBase.getThresholdGroupType() != null)) {
            iDataObject.set(FIELD_THRESHOLDGROUPTYPE, (Object)pSThresholdGroupBase.getThresholdGroupType());
        }
        if (pSThresholdGroupBase.isUpdateDateDirty() && (bl || pSThresholdGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSThresholdGroupBase.getUpdateDate());
        }
        if (pSThresholdGroupBase.isUpdateManDirty() && (bl || pSThresholdGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSThresholdGroupBase.getUpdateMan());
        }
        if (pSThresholdGroupBase.isUserCatDirty() && (bl || pSThresholdGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSThresholdGroupBase.getUserCat());
        }
        if (pSThresholdGroupBase.isUserTagDirty() && (bl || pSThresholdGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSThresholdGroupBase.getUserTag());
        }
        if (pSThresholdGroupBase.isUserTag2Dirty() && (bl || pSThresholdGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSThresholdGroupBase.getUserTag2());
        }
        if (pSThresholdGroupBase.isUserTag3Dirty() && (bl || pSThresholdGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSThresholdGroupBase.getUserTag3());
        }
        if (pSThresholdGroupBase.isUserTag4Dirty() && (bl || pSThresholdGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSThresholdGroupBase.getUserTag4());
        }
        if (pSThresholdGroupBase.isValidFlagDirty() && (bl || pSThresholdGroupBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSThresholdGroupBase.getValidFlag());
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
        return PSThresholdGroupBase.remove(this, n);
    }

    private static boolean remove(PSThresholdGroupBase pSThresholdGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSThresholdGroupBase.resetBeginValuePSDEFId();
                return true;
            }
            case 1: {
                pSThresholdGroupBase.resetBeginValuePSDEFName();
                return true;
            }
            case 2: {
                pSThresholdGroupBase.resetBKColorPSDEFId();
                return true;
            }
            case 3: {
                pSThresholdGroupBase.resetBKColorPSDEFName();
                return true;
            }
            case 4: {
                pSThresholdGroupBase.resetCodeName();
                return true;
            }
            case 5: {
                pSThresholdGroupBase.resetColorPSDEFId();
                return true;
            }
            case 6: {
                pSThresholdGroupBase.resetColorPSDEFName();
                return true;
            }
            case 7: {
                pSThresholdGroupBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSThresholdGroupBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSThresholdGroupBase.resetCustomCond();
                return true;
            }
            case 10: {
                pSThresholdGroupBase.resetDataPSDEFId();
                return true;
            }
            case 11: {
                pSThresholdGroupBase.resetDataPSDEFName();
                return true;
            }
            case 12: {
                pSThresholdGroupBase.resetEndValuePSDEFId();
                return true;
            }
            case 13: {
                pSThresholdGroupBase.resetEndValuePSDEFName();
                return true;
            }
            case 14: {
                pSThresholdGroupBase.resetIconClsPSDEFId();
                return true;
            }
            case 15: {
                pSThresholdGroupBase.resetIconClsPSDEFName();
                return true;
            }
            case 16: {
                pSThresholdGroupBase.resetIncBeginValue();
                return true;
            }
            case 17: {
                pSThresholdGroupBase.resetIncEndValue();
                return true;
            }
            case 18: {
                pSThresholdGroupBase.resetMemo();
                return true;
            }
            case 19: {
                pSThresholdGroupBase.resetPSDEDSId();
                return true;
            }
            case 20: {
                pSThresholdGroupBase.resetPSDEDSName();
                return true;
            }
            case 21: {
                pSThresholdGroupBase.resetPSDEId();
                return true;
            }
            case 22: {
                pSThresholdGroupBase.resetPSDEName();
                return true;
            }
            case 23: {
                pSThresholdGroupBase.resetPSModuleId();
                return true;
            }
            case 24: {
                pSThresholdGroupBase.resetPSModuleName();
                return true;
            }
            case 25: {
                pSThresholdGroupBase.resetPSSysDynaModelId();
                return true;
            }
            case 26: {
                pSThresholdGroupBase.resetPSSysDynaModelName();
                return true;
            }
            case 27: {
                pSThresholdGroupBase.resetPSSystemId();
                return true;
            }
            case 28: {
                pSThresholdGroupBase.resetPSSystemName();
                return true;
            }
            case 29: {
                pSThresholdGroupBase.resetPSThresholdGroupId();
                return true;
            }
            case 30: {
                pSThresholdGroupBase.resetPSThresholdGroupName();
                return true;
            }
            case 31: {
                pSThresholdGroupBase.resetTextPSDEFId();
                return true;
            }
            case 32: {
                pSThresholdGroupBase.resetTextPSDEFName();
                return true;
            }
            case 33: {
                pSThresholdGroupBase.resetThresholdGroupTag();
                return true;
            }
            case 34: {
                pSThresholdGroupBase.resetThresholdGroupTag2();
                return true;
            }
            case 35: {
                pSThresholdGroupBase.resetThresholdGroupType();
                return true;
            }
            case 36: {
                pSThresholdGroupBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSThresholdGroupBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSThresholdGroupBase.resetUserCat();
                return true;
            }
            case 39: {
                pSThresholdGroupBase.resetUserTag();
                return true;
            }
            case 40: {
                pSThresholdGroupBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSThresholdGroupBase.resetUserTag3();
                return true;
            }
            case 42: {
                pSThresholdGroupBase.resetUserTag4();
                return true;
            }
            case 43: {
                pSThresholdGroupBase.resetValidFlag();
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
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
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getBeginValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValuePSDEF();
        }
        if (this.getBeginValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objBeginValuePSDEFLock;
        synchronized (n) {
            if (this.beginvaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getBeginValuePSDEFId(), (Object)this.beginvaluepsdef.getPSDEFieldId()) != 0L) {
                this.beginvaluepsdef = null;
            }
            if (this.beginvaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getBeginValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.beginvaluepsdef = pSDEField;
            }
            return this.beginvaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getBKColorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColorPSDEF();
        }
        if (this.getBKColorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objBKColorPSDEFLock;
        synchronized (n) {
            if (this.bkcolorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getBKColorPSDEFId(), (Object)this.bkcolorpsdef.getPSDEFieldId()) != 0L) {
                this.bkcolorpsdef = null;
            }
            if (this.bkcolorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getBKColorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.bkcolorpsdef = pSDEField;
            }
            return this.bkcolorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getColorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColorPSDEF();
        }
        if (this.getColorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objColorPSDEFLock;
        synchronized (n) {
            if (this.colorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getColorPSDEFId(), (Object)this.colorpsdef.getPSDEFieldId()) != 0L) {
                this.colorpsdef = null;
            }
            if (this.colorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getColorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.colorpsdef = pSDEField;
            }
            return this.colorpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDataPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPSDEF();
        }
        if (this.getDataPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDataPSDEFLock;
        synchronized (n) {
            if (this.datapsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDataPSDEFId(), (Object)this.datapsdef.getPSDEFieldId()) != 0L) {
                this.datapsdef = null;
            }
            if (this.datapsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDataPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.datapsdef = pSDEField;
            }
            return this.datapsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getEndValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValuePSDEF();
        }
        if (this.getEndValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objEndValuePSDEFLock;
        synchronized (n) {
            if (this.endvaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getEndValuePSDEFId(), (Object)this.endvaluepsdef.getPSDEFieldId()) != 0L) {
                this.endvaluepsdef = null;
            }
            if (this.endvaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getEndValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.endvaluepsdef = pSDEField;
            }
            return this.endvaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getIconClsPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconClsPSDEF();
        }
        if (this.getIconClsPSDEFId() == null) {
            return null;
        }
        Integer n = this.objIconClsPSDEFLock;
        synchronized (n) {
            if (this.iconclspsdef != null && DataTypeHelper.compare((int)25, (Object)this.getIconClsPSDEFId(), (Object)this.iconclspsdef.getPSDEFieldId()) != 0L) {
                this.iconclspsdef = null;
            }
            if (this.iconclspsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getIconClsPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.iconclspsdef = pSDEField;
            }
            return this.iconclspsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTextPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEF();
        }
        if (this.getTextPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTextPSDEFLock;
        synchronized (n) {
            if (this.textpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTextPSDEFId(), (Object)this.textpsdef.getPSDEFieldId()) != 0L) {
                this.textpsdef = null;
            }
            if (this.textpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTextPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.textpsdef = pSDEField;
            }
            return this.textpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSThreshold> getPSThresholds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholds();
        }
        if (this.getPSThresholdGroupId() == null) {
            return null;
        }
        PSThresholdGroupService pSThresholdGroupService = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        PSThresholdService pSThresholdService = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSThresholdsLock;
        synchronized (n) {
            if (this.psthresholds == null) {
                this.psthresholds = pSThresholdGroupService.isTempData(this) ? pSThresholdService.selectTempByPSThresholdGroup(this) : pSThresholdService.selectByPSThresholdGroup(this);
            }
            return this.psthresholds;
        }
    }

    private PSThresholdGroupBase getProxyEntity() {
        return this.proxyPSThresholdGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSThresholdGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSThresholdGroupBase) {
            this.proxyPSThresholdGroupBase = (PSThresholdGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINVALUEPSDEFID, 0);
        fieldIndexMap.put(FIELD_BEGINVALUEPSDEFNAME, 1);
        fieldIndexMap.put(FIELD_BKCOLORPSDEFID, 2);
        fieldIndexMap.put(FIELD_BKCOLORPSDEFNAME, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_COLORPSDEFID, 5);
        fieldIndexMap.put(FIELD_COLORPSDEFNAME, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 9);
        fieldIndexMap.put(FIELD_DATAPSDEFID, 10);
        fieldIndexMap.put(FIELD_DATAPSDEFNAME, 11);
        fieldIndexMap.put(FIELD_ENDVALUEPSDEFID, 12);
        fieldIndexMap.put(FIELD_ENDVALUEPSDEFNAME, 13);
        fieldIndexMap.put(FIELD_ICONCLSPSDEFID, 14);
        fieldIndexMap.put(FIELD_ICONCLSPSDEFNAME, 15);
        fieldIndexMap.put(FIELD_INCBEGINVALUE, 16);
        fieldIndexMap.put(FIELD_INCENDVALUE, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_PSDEDSID, 19);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 20);
        fieldIndexMap.put(FIELD_PSDEID, 21);
        fieldIndexMap.put(FIELD_PSDENAME, 22);
        fieldIndexMap.put(FIELD_PSMODULEID, 23);
        fieldIndexMap.put(FIELD_PSMODULENAME, 24);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 25);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 27);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 28);
        fieldIndexMap.put(FIELD_PSTHRESHOLDGROUPID, 29);
        fieldIndexMap.put(FIELD_PSTHRESHOLDGROUPNAME, 30);
        fieldIndexMap.put(FIELD_TEXTPSDEFID, 31);
        fieldIndexMap.put(FIELD_TEXTPSDEFNAME, 32);
        fieldIndexMap.put(FIELD_THRESHOLDGROUPTAG, 33);
        fieldIndexMap.put(FIELD_THRESHOLDGROUPTAG2, 34);
        fieldIndexMap.put(FIELD_THRESHOLDGROUPTYPE, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERCAT, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_USERTAG3, 41);
        fieldIndexMap.put(FIELD_USERTAG4, 42);
        fieldIndexMap.put(FIELD_VALIDFLAG, 43);
    }
}

