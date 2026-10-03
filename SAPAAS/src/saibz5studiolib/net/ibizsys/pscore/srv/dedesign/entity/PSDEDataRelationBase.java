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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataRelationBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataRelationBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DRTAG = "DRTAG";
    public static final String FIELD_DRTAG2 = "DRTAG2";
    public static final String FIELD_DRTAG3 = "DRTAG3";
    public static final String FIELD_DRTAG4 = "DRTAG4";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_FORMCAPPSLANRESID = "FORMCAPPSLANRESID";
    public static final String FIELD_FORMCAPPSLANRESNAME = "FORMCAPPSLANRESNAME";
    public static final String FIELD_FORMCAPTION = "FORMCAPTION";
    public static final String FIELD_FORMPSDEVIEWBASEID = "FORMPSDEVIEWBASEID";
    public static final String FIELD_FORMPSDEVIEWBASENAME = "FORMPSDEVIEWBASENAME";
    public static final String FIELD_FORMPSSYSIMAGEID = "FORMPSSYSIMAGEID";
    public static final String FIELD_FORMPSSYSIMAGENAME = "FORMPSSYSIMAGENAME";
    public static final String FIELD_HIDEEDITITEM = "HIDEEDITITEM";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSDEDATARELATIONID = "PSDEDATARELATIONID";
    public static final String FIELD_PSDEDATARELATIONNAME = "PSDEDATARELATIONNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
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
    private static final int INDEX_DRTAG = 3;
    private static final int INDEX_DRTAG2 = 4;
    private static final int INDEX_DRTAG3 = 5;
    private static final int INDEX_DRTAG4 = 6;
    private static final int INDEX_DYNAMODELFLAG = 7;
    private static final int INDEX_ENABLECUSTOMIZED = 8;
    private static final int INDEX_FORMCAPPSLANRESID = 9;
    private static final int INDEX_FORMCAPPSLANRESNAME = 10;
    private static final int INDEX_FORMCAPTION = 11;
    private static final int INDEX_FORMPSDEVIEWBASEID = 12;
    private static final int INDEX_FORMPSDEVIEWBASENAME = 13;
    private static final int INDEX_FORMPSSYSIMAGEID = 14;
    private static final int INDEX_FORMPSSYSIMAGENAME = 15;
    private static final int INDEX_HIDEEDITITEM = 16;
    private static final int INDEX_LOCKFLAG = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_PSCTRLLOGICGROUPID = 19;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 20;
    private static final int INDEX_PSDEDATARELATIONID = 21;
    private static final int INDEX_PSDEDATARELATIONNAME = 22;
    private static final int INDEX_PSDEID = 23;
    private static final int INDEX_PSDENAME = 24;
    private static final int INDEX_PSDYNAINSTID = 25;
    private static final int INDEX_PSSYSCOUNTERID = 26;
    private static final int INDEX_PSSYSCOUNTERNAME = 27;
    private static final int INDEX_PSWFDEID = 28;
    private static final int INDEX_SRFSYSPUB = 29;
    private static final int INDEX_UPDATEDATE = 30;
    private static final int INDEX_UPDATEMAN = 31;
    private static final int INDEX_USERCAT = 32;
    private static final int INDEX_USERTAG = 33;
    private static final int INDEX_USERTAG2 = 34;
    private static final int INDEX_USERTAG3 = 35;
    private static final int INDEX_USERTAG4 = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataRelationBase proxyPSDEDataRelationBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean drtagDirtyFlag = false;
    private boolean drtag2DirtyFlag = false;
    private boolean drtag3DirtyFlag = false;
    private boolean drtag4DirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean formcappslanresidDirtyFlag = false;
    private boolean formcappslanresnameDirtyFlag = false;
    private boolean formcaptionDirtyFlag = false;
    private boolean formpsdeviewbaseidDirtyFlag = false;
    private boolean formpsdeviewbasenameDirtyFlag = false;
    private boolean formpssysimageidDirtyFlag = false;
    private boolean formpssysimagenameDirtyFlag = false;
    private boolean hideedititemDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psdedatarelationidDirtyFlag = false;
    private boolean psdedatarelationnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
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
    @Column(name="drtag")
    private String drtag;
    @Column(name="drtag2")
    private String drtag2;
    @Column(name="drtag3")
    private String drtag3;
    @Column(name="drtag4")
    private String drtag4;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="formcappslanresid")
    private String formcappslanresid;
    @Column(name="formcappslanresname")
    private String formcappslanresname;
    @Column(name="formcaption")
    private String formcaption;
    @Column(name="formpsdeviewbaseid")
    private String formpsdeviewbaseid;
    @Column(name="formpsdeviewbasename")
    private String formpsdeviewbasename;
    @Column(name="formpssysimageid")
    private String formpssysimageid;
    @Column(name="formpssysimagename")
    private String formpssysimagename;
    @Column(name="hideedititem")
    private Integer hideedititem;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psdedatarelationid")
    private String psdedatarelationid;
    @Column(name="psdedatarelationname")
    private String psdedatarelationname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
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
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objFormPSDEviewBaseLock = new Integer(1);
    private PSDEViewBase formpsdeviewbase = null;
    private Integer objFormCapPSLanResLock = new Integer(1);
    private PSLanguageRes formcappslanres = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objFormPSSysImageLock = new Integer(1);
    private PSSysImage formpssysimage = null;
    private Integer objPSWFDELock = new Integer(1);
    private PSWFDE pswfde = null;
    private Integer objPSDEDRDetailsLock = new Integer(1);
    private ArrayList<PSDEDRDetail> psdedrdetails = null;

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

    public void setDRTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDRTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drtag = string;
        this.drtagDirtyFlag = true;
    }

    public String getDRTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDRTag();
        }
        return this.drtag;
    }

    public boolean isDRTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDRTagDirty();
        }
        return this.drtagDirtyFlag;
    }

    public void resetDRTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDRTag();
            return;
        }
        this.drtagDirtyFlag = false;
        this.drtag = null;
    }

    public void setDRTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDRTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drtag2 = string;
        this.drtag2DirtyFlag = true;
    }

    public String getDRTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDRTag2();
        }
        return this.drtag2;
    }

    public boolean isDRTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDRTag2Dirty();
        }
        return this.drtag2DirtyFlag;
    }

    public void resetDRTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDRTag2();
            return;
        }
        this.drtag2DirtyFlag = false;
        this.drtag2 = null;
    }

    public void setDRTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDRTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drtag3 = string;
        this.drtag3DirtyFlag = true;
    }

    public String getDRTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDRTag3();
        }
        return this.drtag3;
    }

    public boolean isDRTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDRTag3Dirty();
        }
        return this.drtag3DirtyFlag;
    }

    public void resetDRTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDRTag3();
            return;
        }
        this.drtag3DirtyFlag = false;
        this.drtag3 = null;
    }

    public void setDRTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDRTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drtag4 = string;
        this.drtag4DirtyFlag = true;
    }

    public String getDRTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDRTag4();
        }
        return this.drtag4;
    }

    public boolean isDRTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDRTag4Dirty();
        }
        return this.drtag4DirtyFlag;
    }

    public void resetDRTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDRTag4();
            return;
        }
        this.drtag4DirtyFlag = false;
        this.drtag4 = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setEnableCustomized(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomized(n);
            return;
        }
        this.enablecustomized = n;
        this.enablecustomizedDirtyFlag = true;
    }

    public Integer getEnableCustomized() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomized();
        }
        return this.enablecustomized;
    }

    public boolean isEnableCustomizedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomizedDirty();
        }
        return this.enablecustomizedDirtyFlag;
    }

    public void resetEnableCustomized() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomized();
            return;
        }
        this.enablecustomizedDirtyFlag = false;
        this.enablecustomized = null;
    }

    public void setFormCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formcappslanresid = string;
        this.formcappslanresidDirtyFlag = true;
    }

    public String getFormCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormCapPSLanResId();
        }
        return this.formcappslanresid;
    }

    public boolean isFormCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormCapPSLanResIdDirty();
        }
        return this.formcappslanresidDirtyFlag;
    }

    public void resetFormCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormCapPSLanResId();
            return;
        }
        this.formcappslanresidDirtyFlag = false;
        this.formcappslanresid = null;
    }

    public void setFormCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formcappslanresname = string;
        this.formcappslanresnameDirtyFlag = true;
    }

    public String getFormCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormCapPSLanResName();
        }
        return this.formcappslanresname;
    }

    public boolean isFormCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormCapPSLanResNameDirty();
        }
        return this.formcappslanresnameDirtyFlag;
    }

    public void resetFormCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormCapPSLanResName();
            return;
        }
        this.formcappslanresnameDirtyFlag = false;
        this.formcappslanresname = null;
    }

    public void setFormCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formcaption = string;
        this.formcaptionDirtyFlag = true;
    }

    public String getFormCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormCaption();
        }
        return this.formcaption;
    }

    public boolean isFormCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormCaptionDirty();
        }
        return this.formcaptionDirtyFlag;
    }

    public void resetFormCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormCaption();
            return;
        }
        this.formcaptionDirtyFlag = false;
        this.formcaption = null;
    }

    public void setFormPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formpsdeviewbaseid = string;
        this.formpsdeviewbaseidDirtyFlag = true;
    }

    public String getFormPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormPSDEViewBaseId();
        }
        return this.formpsdeviewbaseid;
    }

    public boolean isFormPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormPSDEViewBaseIdDirty();
        }
        return this.formpsdeviewbaseidDirtyFlag;
    }

    public void resetFormPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormPSDEViewBaseId();
            return;
        }
        this.formpsdeviewbaseidDirtyFlag = false;
        this.formpsdeviewbaseid = null;
    }

    public void setFormPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formpsdeviewbasename = string;
        this.formpsdeviewbasenameDirtyFlag = true;
    }

    public String getFormPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormPSDEViewBaseName();
        }
        return this.formpsdeviewbasename;
    }

    public boolean isFormPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormPSDEViewBaseNameDirty();
        }
        return this.formpsdeviewbasenameDirtyFlag;
    }

    public void resetFormPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormPSDEViewBaseName();
            return;
        }
        this.formpsdeviewbasenameDirtyFlag = false;
        this.formpsdeviewbasename = null;
    }

    public void setFormPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formpssysimageid = string;
        this.formpssysimageidDirtyFlag = true;
    }

    public String getFormPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormPSSysImageId();
        }
        return this.formpssysimageid;
    }

    public boolean isFormPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormPSSysImageIdDirty();
        }
        return this.formpssysimageidDirtyFlag;
    }

    public void resetFormPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormPSSysImageId();
            return;
        }
        this.formpssysimageidDirtyFlag = false;
        this.formpssysimageid = null;
    }

    public void setFormPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formpssysimagename = string;
        this.formpssysimagenameDirtyFlag = true;
    }

    public String getFormPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormPSSysImageName();
        }
        return this.formpssysimagename;
    }

    public boolean isFormPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormPSSysImageNameDirty();
        }
        return this.formpssysimagenameDirtyFlag;
    }

    public void resetFormPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormPSSysImageName();
            return;
        }
        this.formpssysimagenameDirtyFlag = false;
        this.formpssysimagename = null;
    }

    public void setHideEditItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHideEditItem(n);
            return;
        }
        this.hideedititem = n;
        this.hideedititemDirtyFlag = true;
    }

    public Integer getHideEditItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHideEditItem();
        }
        return this.hideedititem;
    }

    public boolean isHideEditItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHideEditItemDirty();
        }
        return this.hideedititemDirtyFlag;
    }

    public void resetHideEditItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHideEditItem();
            return;
        }
        this.hideedititemDirtyFlag = false;
        this.hideedititem = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupid = string;
        this.psctrllogicgroupidDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupId();
        }
        return this.psctrllogicgroupid;
    }

    public boolean isPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupIdDirty();
        }
        return this.psctrllogicgroupidDirtyFlag;
    }

    public void resetPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupId();
            return;
        }
        this.psctrllogicgroupidDirtyFlag = false;
        this.psctrllogicgroupid = null;
    }

    public void setPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupname = string;
        this.psctrllogicgroupnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupName();
        }
        return this.psctrllogicgroupname;
    }

    public boolean isPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupNameDirty();
        }
        return this.psctrllogicgroupnameDirtyFlag;
    }

    public void resetPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupName();
            return;
        }
        this.psctrllogicgroupnameDirtyFlag = false;
        this.psctrllogicgroupname = null;
    }

    public void setPSDEDataRelationId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataRelationId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatarelationid = string;
        this.psdedatarelationidDirtyFlag = true;
    }

    public String getPSDEDataRelationId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataRelationId();
        }
        return this.psdedatarelationid;
    }

    public boolean isPSDEDataRelationIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataRelationIdDirty();
        }
        return this.psdedatarelationidDirtyFlag;
    }

    public void resetPSDEDataRelationId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataRelationId();
            return;
        }
        this.psdedatarelationidDirtyFlag = false;
        this.psdedatarelationid = null;
    }

    public void setPSDEDataRelationName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataRelationName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatarelationname = string;
        this.psdedatarelationnameDirtyFlag = true;
    }

    public String getPSDEDataRelationName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataRelationName();
        }
        return this.psdedatarelationname;
    }

    public boolean isPSDEDataRelationNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataRelationNameDirty();
        }
        return this.psdedatarelationnameDirtyFlag;
    }

    public void resetPSDEDataRelationName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataRelationName();
            return;
        }
        this.psdedatarelationnameDirtyFlag = false;
        this.psdedatarelationname = null;
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

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
    }

    public void setPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdeid = string;
        this.pswfdeidDirtyFlag = true;
    }

    public String getPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    public boolean isPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    public void resetPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }
        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
    }

    public void setSRFSysPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(n);
            return;
        }
        this.srfsyspub = n;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
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
        PSDEDataRelationBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataRelationBase pSDEDataRelationBase) {
        pSDEDataRelationBase.resetCodeName();
        pSDEDataRelationBase.resetCreateDate();
        pSDEDataRelationBase.resetCreateMan();
        pSDEDataRelationBase.resetDRTag();
        pSDEDataRelationBase.resetDRTag2();
        pSDEDataRelationBase.resetDRTag3();
        pSDEDataRelationBase.resetDRTag4();
        pSDEDataRelationBase.resetDynaModelFlag();
        pSDEDataRelationBase.resetEnableCustomized();
        pSDEDataRelationBase.resetFormCapPSLanResId();
        pSDEDataRelationBase.resetFormCapPSLanResName();
        pSDEDataRelationBase.resetFormCaption();
        pSDEDataRelationBase.resetFormPSDEViewBaseId();
        pSDEDataRelationBase.resetFormPSDEViewBaseName();
        pSDEDataRelationBase.resetFormPSSysImageId();
        pSDEDataRelationBase.resetFormPSSysImageName();
        pSDEDataRelationBase.resetHideEditItem();
        pSDEDataRelationBase.resetLockFlag();
        pSDEDataRelationBase.resetMemo();
        pSDEDataRelationBase.resetPSCtrlLogicGroupId();
        pSDEDataRelationBase.resetPSCtrlLogicGroupName();
        pSDEDataRelationBase.resetPSDEDataRelationId();
        pSDEDataRelationBase.resetPSDEDataRelationName();
        pSDEDataRelationBase.resetPSDEId();
        pSDEDataRelationBase.resetPSDEName();
        pSDEDataRelationBase.resetPSDynaInstId();
        pSDEDataRelationBase.resetPSSysCounterId();
        pSDEDataRelationBase.resetPSSysCounterName();
        pSDEDataRelationBase.resetPSWFDEId();
        pSDEDataRelationBase.resetSRFSysPub();
        pSDEDataRelationBase.resetUpdateDate();
        pSDEDataRelationBase.resetUpdateMan();
        pSDEDataRelationBase.resetUserCat();
        pSDEDataRelationBase.resetUserTag();
        pSDEDataRelationBase.resetUserTag2();
        pSDEDataRelationBase.resetUserTag3();
        pSDEDataRelationBase.resetUserTag4();
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
        if (!bl || this.isDRTagDirty()) {
            hashMap.put(FIELD_DRTAG, this.getDRTag());
        }
        if (!bl || this.isDRTag2Dirty()) {
            hashMap.put(FIELD_DRTAG2, this.getDRTag2());
        }
        if (!bl || this.isDRTag3Dirty()) {
            hashMap.put(FIELD_DRTAG3, this.getDRTag3());
        }
        if (!bl || this.isDRTag4Dirty()) {
            hashMap.put(FIELD_DRTAG4, this.getDRTag4());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
        }
        if (!bl || this.isFormCapPSLanResIdDirty()) {
            hashMap.put(FIELD_FORMCAPPSLANRESID, this.getFormCapPSLanResId());
        }
        if (!bl || this.isFormCapPSLanResNameDirty()) {
            hashMap.put(FIELD_FORMCAPPSLANRESNAME, this.getFormCapPSLanResName());
        }
        if (!bl || this.isFormCaptionDirty()) {
            hashMap.put(FIELD_FORMCAPTION, this.getFormCaption());
        }
        if (!bl || this.isFormPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_FORMPSDEVIEWBASEID, this.getFormPSDEViewBaseId());
        }
        if (!bl || this.isFormPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_FORMPSDEVIEWBASENAME, this.getFormPSDEViewBaseName());
        }
        if (!bl || this.isFormPSSysImageIdDirty()) {
            hashMap.put(FIELD_FORMPSSYSIMAGEID, this.getFormPSSysImageId());
        }
        if (!bl || this.isFormPSSysImageNameDirty()) {
            hashMap.put(FIELD_FORMPSSYSIMAGENAME, this.getFormPSSysImageName());
        }
        if (!bl || this.isHideEditItemDirty()) {
            hashMap.put(FIELD_HIDEEDITITEM, this.getHideEditItem());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSDEDataRelationIdDirty()) {
            hashMap.put(FIELD_PSDEDATARELATIONID, this.getPSDEDataRelationId());
        }
        if (!bl || this.isPSDEDataRelationNameDirty()) {
            hashMap.put(FIELD_PSDEDATARELATIONNAME, this.getPSDEDataRelationName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isPSWFDEIdDirty()) {
            hashMap.put(FIELD_PSWFDEID, this.getPSWFDEId());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
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
        return PSDEDataRelationBase.get(this, n);
    }

    private static Object get(PSDEDataRelationBase pSDEDataRelationBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataRelationBase.getCodeName();
            }
            case 1: {
                return pSDEDataRelationBase.getCreateDate();
            }
            case 2: {
                return pSDEDataRelationBase.getCreateMan();
            }
            case 3: {
                return pSDEDataRelationBase.getDRTag();
            }
            case 4: {
                return pSDEDataRelationBase.getDRTag2();
            }
            case 5: {
                return pSDEDataRelationBase.getDRTag3();
            }
            case 6: {
                return pSDEDataRelationBase.getDRTag4();
            }
            case 7: {
                return pSDEDataRelationBase.getDynaModelFlag();
            }
            case 8: {
                return pSDEDataRelationBase.getEnableCustomized();
            }
            case 9: {
                return pSDEDataRelationBase.getFormCapPSLanResId();
            }
            case 10: {
                return pSDEDataRelationBase.getFormCapPSLanResName();
            }
            case 11: {
                return pSDEDataRelationBase.getFormCaption();
            }
            case 12: {
                return pSDEDataRelationBase.getFormPSDEViewBaseId();
            }
            case 13: {
                return pSDEDataRelationBase.getFormPSDEViewBaseName();
            }
            case 14: {
                return pSDEDataRelationBase.getFormPSSysImageId();
            }
            case 15: {
                return pSDEDataRelationBase.getFormPSSysImageName();
            }
            case 16: {
                return pSDEDataRelationBase.getHideEditItem();
            }
            case 17: {
                return pSDEDataRelationBase.getLockFlag();
            }
            case 18: {
                return pSDEDataRelationBase.getMemo();
            }
            case 19: {
                return pSDEDataRelationBase.getPSCtrlLogicGroupId();
            }
            case 20: {
                return pSDEDataRelationBase.getPSCtrlLogicGroupName();
            }
            case 21: {
                return pSDEDataRelationBase.getPSDEDataRelationId();
            }
            case 22: {
                return pSDEDataRelationBase.getPSDEDataRelationName();
            }
            case 23: {
                return pSDEDataRelationBase.getPSDEId();
            }
            case 24: {
                return pSDEDataRelationBase.getPSDEName();
            }
            case 25: {
                return pSDEDataRelationBase.getPSDynaInstId();
            }
            case 26: {
                return pSDEDataRelationBase.getPSSysCounterId();
            }
            case 27: {
                return pSDEDataRelationBase.getPSSysCounterName();
            }
            case 28: {
                return pSDEDataRelationBase.getPSWFDEId();
            }
            case 29: {
                return pSDEDataRelationBase.getSRFSysPub();
            }
            case 30: {
                return pSDEDataRelationBase.getUpdateDate();
            }
            case 31: {
                return pSDEDataRelationBase.getUpdateMan();
            }
            case 32: {
                return pSDEDataRelationBase.getUserCat();
            }
            case 33: {
                return pSDEDataRelationBase.getUserTag();
            }
            case 34: {
                return pSDEDataRelationBase.getUserTag2();
            }
            case 35: {
                return pSDEDataRelationBase.getUserTag3();
            }
            case 36: {
                return pSDEDataRelationBase.getUserTag4();
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
        PSDEDataRelationBase.set(this, n, object);
    }

    private static void set(PSDEDataRelationBase pSDEDataRelationBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataRelationBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataRelationBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataRelationBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataRelationBase.setDRTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataRelationBase.setDRTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataRelationBase.setDRTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataRelationBase.setDRTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataRelationBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataRelationBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataRelationBase.setFormCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataRelationBase.setFormCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataRelationBase.setFormCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataRelationBase.setFormPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataRelationBase.setFormPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataRelationBase.setFormPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataRelationBase.setFormPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataRelationBase.setHideEditItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataRelationBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataRelationBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataRelationBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataRelationBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataRelationBase.setPSDEDataRelationId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataRelationBase.setPSDEDataRelationName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataRelationBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataRelationBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataRelationBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataRelationBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataRelationBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataRelationBase.setPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataRelationBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataRelationBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataRelationBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataRelationBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataRelationBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDataRelationBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDataRelationBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDataRelationBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEDataRelationBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataRelationBase pSDEDataRelationBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataRelationBase.getCodeName() == null;
            }
            case 1: {
                return pSDEDataRelationBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEDataRelationBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEDataRelationBase.getDRTag() == null;
            }
            case 4: {
                return pSDEDataRelationBase.getDRTag2() == null;
            }
            case 5: {
                return pSDEDataRelationBase.getDRTag3() == null;
            }
            case 6: {
                return pSDEDataRelationBase.getDRTag4() == null;
            }
            case 7: {
                return pSDEDataRelationBase.getDynaModelFlag() == null;
            }
            case 8: {
                return pSDEDataRelationBase.getEnableCustomized() == null;
            }
            case 9: {
                return pSDEDataRelationBase.getFormCapPSLanResId() == null;
            }
            case 10: {
                return pSDEDataRelationBase.getFormCapPSLanResName() == null;
            }
            case 11: {
                return pSDEDataRelationBase.getFormCaption() == null;
            }
            case 12: {
                return pSDEDataRelationBase.getFormPSDEViewBaseId() == null;
            }
            case 13: {
                return pSDEDataRelationBase.getFormPSDEViewBaseName() == null;
            }
            case 14: {
                return pSDEDataRelationBase.getFormPSSysImageId() == null;
            }
            case 15: {
                return pSDEDataRelationBase.getFormPSSysImageName() == null;
            }
            case 16: {
                return pSDEDataRelationBase.getHideEditItem() == null;
            }
            case 17: {
                return pSDEDataRelationBase.getLockFlag() == null;
            }
            case 18: {
                return pSDEDataRelationBase.getMemo() == null;
            }
            case 19: {
                return pSDEDataRelationBase.getPSCtrlLogicGroupId() == null;
            }
            case 20: {
                return pSDEDataRelationBase.getPSCtrlLogicGroupName() == null;
            }
            case 21: {
                return pSDEDataRelationBase.getPSDEDataRelationId() == null;
            }
            case 22: {
                return pSDEDataRelationBase.getPSDEDataRelationName() == null;
            }
            case 23: {
                return pSDEDataRelationBase.getPSDEId() == null;
            }
            case 24: {
                return pSDEDataRelationBase.getPSDEName() == null;
            }
            case 25: {
                return pSDEDataRelationBase.getPSDynaInstId() == null;
            }
            case 26: {
                return pSDEDataRelationBase.getPSSysCounterId() == null;
            }
            case 27: {
                return pSDEDataRelationBase.getPSSysCounterName() == null;
            }
            case 28: {
                return pSDEDataRelationBase.getPSWFDEId() == null;
            }
            case 29: {
                return pSDEDataRelationBase.getSRFSysPub() == null;
            }
            case 30: {
                return pSDEDataRelationBase.getUpdateDate() == null;
            }
            case 31: {
                return pSDEDataRelationBase.getUpdateMan() == null;
            }
            case 32: {
                return pSDEDataRelationBase.getUserCat() == null;
            }
            case 33: {
                return pSDEDataRelationBase.getUserTag() == null;
            }
            case 34: {
                return pSDEDataRelationBase.getUserTag2() == null;
            }
            case 35: {
                return pSDEDataRelationBase.getUserTag3() == null;
            }
            case 36: {
                return pSDEDataRelationBase.getUserTag4() == null;
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
        return PSDEDataRelationBase.contains(this, n);
    }

    private static boolean contains(PSDEDataRelationBase pSDEDataRelationBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataRelationBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEDataRelationBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEDataRelationBase.isCreateManDirty();
            }
            case 3: {
                return pSDEDataRelationBase.isDRTagDirty();
            }
            case 4: {
                return pSDEDataRelationBase.isDRTag2Dirty();
            }
            case 5: {
                return pSDEDataRelationBase.isDRTag3Dirty();
            }
            case 6: {
                return pSDEDataRelationBase.isDRTag4Dirty();
            }
            case 7: {
                return pSDEDataRelationBase.isDynaModelFlagDirty();
            }
            case 8: {
                return pSDEDataRelationBase.isEnableCustomizedDirty();
            }
            case 9: {
                return pSDEDataRelationBase.isFormCapPSLanResIdDirty();
            }
            case 10: {
                return pSDEDataRelationBase.isFormCapPSLanResNameDirty();
            }
            case 11: {
                return pSDEDataRelationBase.isFormCaptionDirty();
            }
            case 12: {
                return pSDEDataRelationBase.isFormPSDEViewBaseIdDirty();
            }
            case 13: {
                return pSDEDataRelationBase.isFormPSDEViewBaseNameDirty();
            }
            case 14: {
                return pSDEDataRelationBase.isFormPSSysImageIdDirty();
            }
            case 15: {
                return pSDEDataRelationBase.isFormPSSysImageNameDirty();
            }
            case 16: {
                return pSDEDataRelationBase.isHideEditItemDirty();
            }
            case 17: {
                return pSDEDataRelationBase.isLockFlagDirty();
            }
            case 18: {
                return pSDEDataRelationBase.isMemoDirty();
            }
            case 19: {
                return pSDEDataRelationBase.isPSCtrlLogicGroupIdDirty();
            }
            case 20: {
                return pSDEDataRelationBase.isPSCtrlLogicGroupNameDirty();
            }
            case 21: {
                return pSDEDataRelationBase.isPSDEDataRelationIdDirty();
            }
            case 22: {
                return pSDEDataRelationBase.isPSDEDataRelationNameDirty();
            }
            case 23: {
                return pSDEDataRelationBase.isPSDEIdDirty();
            }
            case 24: {
                return pSDEDataRelationBase.isPSDENameDirty();
            }
            case 25: {
                return pSDEDataRelationBase.isPSDynaInstIdDirty();
            }
            case 26: {
                return pSDEDataRelationBase.isPSSysCounterIdDirty();
            }
            case 27: {
                return pSDEDataRelationBase.isPSSysCounterNameDirty();
            }
            case 28: {
                return pSDEDataRelationBase.isPSWFDEIdDirty();
            }
            case 29: {
                return pSDEDataRelationBase.isSRFSysPubDirty();
            }
            case 30: {
                return pSDEDataRelationBase.isUpdateDateDirty();
            }
            case 31: {
                return pSDEDataRelationBase.isUpdateManDirty();
            }
            case 32: {
                return pSDEDataRelationBase.isUserCatDirty();
            }
            case 33: {
                return pSDEDataRelationBase.isUserTagDirty();
            }
            case 34: {
                return pSDEDataRelationBase.isUserTag2Dirty();
            }
            case 35: {
                return pSDEDataRelationBase.isUserTag3Dirty();
            }
            case 36: {
                return pSDEDataRelationBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataRelationBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataRelationBase pSDEDataRelationBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataRelationBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getDRTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drtag", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getDRTag()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getDRTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drtag2", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getDRTag2()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getDRTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drtag3", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getDRTag3()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getDRTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drtag4", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getDRTag4()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getFormCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formcappslanresid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getFormCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getFormCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formcappslanresname", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getFormCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getFormCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formcaption", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getFormCaption()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getFormPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formpsdeviewbaseid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getFormPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getFormPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formpsdeviewbasename", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getFormPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getFormPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formpssysimageid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getFormPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getFormPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formpssysimagename", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getFormPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getHideEditItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hideedititem", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getHideEditItem()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSDEDataRelationId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatarelationid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSDEDataRelationId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSDEDataRelationName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatarelationname", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSDEDataRelationName()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdeid", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getPSWFDEId()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDataRelationBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDataRelationBase.getJSONValue((Object)pSDEDataRelationBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataRelationBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataRelationBase pSDEDataRelationBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataRelationBase.getCodeName() != null) {
            object = pSDEDataRelationBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getCreateDate() != null) {
            object = pSDEDataRelationBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataRelationBase.getCreateMan() != null) {
            object = pSDEDataRelationBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getDRTag() != null) {
            object = pSDEDataRelationBase.getDRTag();
            xmlNode.setAttribute(FIELD_DRTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getDRTag2() != null) {
            object = pSDEDataRelationBase.getDRTag2();
            xmlNode.setAttribute(FIELD_DRTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getDRTag3() != null) {
            object = pSDEDataRelationBase.getDRTag3();
            xmlNode.setAttribute(FIELD_DRTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getDRTag4() != null) {
            object = pSDEDataRelationBase.getDRTag4();
            xmlNode.setAttribute(FIELD_DRTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getDynaModelFlag() != null) {
            object = pSDEDataRelationBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataRelationBase.getEnableCustomized() != null) {
            object = pSDEDataRelationBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataRelationBase.getFormCapPSLanResId() != null) {
            object = pSDEDataRelationBase.getFormCapPSLanResId();
            xmlNode.setAttribute(FIELD_FORMCAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getFormCapPSLanResName() != null) {
            object = pSDEDataRelationBase.getFormCapPSLanResName();
            xmlNode.setAttribute(FIELD_FORMCAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getFormCaption() != null) {
            object = pSDEDataRelationBase.getFormCaption();
            xmlNode.setAttribute(FIELD_FORMCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getFormPSDEViewBaseId() != null) {
            object = pSDEDataRelationBase.getFormPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_FORMPSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getFormPSDEViewBaseName() != null) {
            object = pSDEDataRelationBase.getFormPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_FORMPSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getFormPSSysImageId() != null) {
            object = pSDEDataRelationBase.getFormPSSysImageId();
            xmlNode.setAttribute(FIELD_FORMPSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getFormPSSysImageName() != null) {
            object = pSDEDataRelationBase.getFormPSSysImageName();
            xmlNode.setAttribute(FIELD_FORMPSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getHideEditItem() != null) {
            object = pSDEDataRelationBase.getHideEditItem();
            xmlNode.setAttribute(FIELD_HIDEEDITITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataRelationBase.getLockFlag() != null) {
            object = pSDEDataRelationBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataRelationBase.getMemo() != null) {
            object = pSDEDataRelationBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEDataRelationBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEDataRelationBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSDEDataRelationId() != null) {
            object = pSDEDataRelationBase.getPSDEDataRelationId();
            xmlNode.setAttribute(FIELD_PSDEDATARELATIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSDEDataRelationName() != null) {
            object = pSDEDataRelationBase.getPSDEDataRelationName();
            xmlNode.setAttribute(FIELD_PSDEDATARELATIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSDEId() != null) {
            object = pSDEDataRelationBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSDEName() != null) {
            object = pSDEDataRelationBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSDynaInstId() != null) {
            object = pSDEDataRelationBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSSysCounterId() != null) {
            object = pSDEDataRelationBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSSysCounterName() != null) {
            object = pSDEDataRelationBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getPSWFDEId() != null) {
            object = pSDEDataRelationBase.getPSWFDEId();
            xmlNode.setAttribute(FIELD_PSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getSRFSysPub() != null) {
            object = pSDEDataRelationBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataRelationBase.getUpdateDate() != null) {
            object = pSDEDataRelationBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataRelationBase.getUpdateMan() != null) {
            object = pSDEDataRelationBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getUserCat() != null) {
            object = pSDEDataRelationBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getUserTag() != null) {
            object = pSDEDataRelationBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getUserTag2() != null) {
            object = pSDEDataRelationBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getUserTag3() != null) {
            object = pSDEDataRelationBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataRelationBase.getUserTag4() != null) {
            object = pSDEDataRelationBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataRelationBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataRelationBase pSDEDataRelationBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataRelationBase.isCodeNameDirty() && (bl || pSDEDataRelationBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDataRelationBase.getCodeName());
        }
        if (pSDEDataRelationBase.isCreateDateDirty() && (bl || pSDEDataRelationBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataRelationBase.getCreateDate());
        }
        if (pSDEDataRelationBase.isCreateManDirty() && (bl || pSDEDataRelationBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataRelationBase.getCreateMan());
        }
        if (pSDEDataRelationBase.isDRTagDirty() && (bl || pSDEDataRelationBase.getDRTag() != null)) {
            iDataObject.set(FIELD_DRTAG, (Object)pSDEDataRelationBase.getDRTag());
        }
        if (pSDEDataRelationBase.isDRTag2Dirty() && (bl || pSDEDataRelationBase.getDRTag2() != null)) {
            iDataObject.set(FIELD_DRTAG2, (Object)pSDEDataRelationBase.getDRTag2());
        }
        if (pSDEDataRelationBase.isDRTag3Dirty() && (bl || pSDEDataRelationBase.getDRTag3() != null)) {
            iDataObject.set(FIELD_DRTAG3, (Object)pSDEDataRelationBase.getDRTag3());
        }
        if (pSDEDataRelationBase.isDRTag4Dirty() && (bl || pSDEDataRelationBase.getDRTag4() != null)) {
            iDataObject.set(FIELD_DRTAG4, (Object)pSDEDataRelationBase.getDRTag4());
        }
        if (pSDEDataRelationBase.isDynaModelFlagDirty() && (bl || pSDEDataRelationBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDataRelationBase.getDynaModelFlag());
        }
        if (pSDEDataRelationBase.isEnableCustomizedDirty() && (bl || pSDEDataRelationBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSDEDataRelationBase.getEnableCustomized());
        }
        if (pSDEDataRelationBase.isFormCapPSLanResIdDirty() && (bl || pSDEDataRelationBase.getFormCapPSLanResId() != null)) {
            iDataObject.set(FIELD_FORMCAPPSLANRESID, (Object)pSDEDataRelationBase.getFormCapPSLanResId());
        }
        if (pSDEDataRelationBase.isFormCapPSLanResNameDirty() && (bl || pSDEDataRelationBase.getFormCapPSLanResName() != null)) {
            iDataObject.set(FIELD_FORMCAPPSLANRESNAME, (Object)pSDEDataRelationBase.getFormCapPSLanResName());
        }
        if (pSDEDataRelationBase.isFormCaptionDirty() && (bl || pSDEDataRelationBase.getFormCaption() != null)) {
            iDataObject.set(FIELD_FORMCAPTION, (Object)pSDEDataRelationBase.getFormCaption());
        }
        if (pSDEDataRelationBase.isFormPSDEViewBaseIdDirty() && (bl || pSDEDataRelationBase.getFormPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_FORMPSDEVIEWBASEID, (Object)pSDEDataRelationBase.getFormPSDEViewBaseId());
        }
        if (pSDEDataRelationBase.isFormPSDEViewBaseNameDirty() && (bl || pSDEDataRelationBase.getFormPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_FORMPSDEVIEWBASENAME, (Object)pSDEDataRelationBase.getFormPSDEViewBaseName());
        }
        if (pSDEDataRelationBase.isFormPSSysImageIdDirty() && (bl || pSDEDataRelationBase.getFormPSSysImageId() != null)) {
            iDataObject.set(FIELD_FORMPSSYSIMAGEID, (Object)pSDEDataRelationBase.getFormPSSysImageId());
        }
        if (pSDEDataRelationBase.isFormPSSysImageNameDirty() && (bl || pSDEDataRelationBase.getFormPSSysImageName() != null)) {
            iDataObject.set(FIELD_FORMPSSYSIMAGENAME, (Object)pSDEDataRelationBase.getFormPSSysImageName());
        }
        if (pSDEDataRelationBase.isHideEditItemDirty() && (bl || pSDEDataRelationBase.getHideEditItem() != null)) {
            iDataObject.set(FIELD_HIDEEDITITEM, (Object)pSDEDataRelationBase.getHideEditItem());
        }
        if (pSDEDataRelationBase.isLockFlagDirty() && (bl || pSDEDataRelationBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDataRelationBase.getLockFlag());
        }
        if (pSDEDataRelationBase.isMemoDirty() && (bl || pSDEDataRelationBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataRelationBase.getMemo());
        }
        if (pSDEDataRelationBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEDataRelationBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEDataRelationBase.getPSCtrlLogicGroupId());
        }
        if (pSDEDataRelationBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEDataRelationBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEDataRelationBase.getPSCtrlLogicGroupName());
        }
        if (pSDEDataRelationBase.isPSDEDataRelationIdDirty() && (bl || pSDEDataRelationBase.getPSDEDataRelationId() != null)) {
            iDataObject.set(FIELD_PSDEDATARELATIONID, (Object)pSDEDataRelationBase.getPSDEDataRelationId());
        }
        if (pSDEDataRelationBase.isPSDEDataRelationNameDirty() && (bl || pSDEDataRelationBase.getPSDEDataRelationName() != null)) {
            iDataObject.set(FIELD_PSDEDATARELATIONNAME, (Object)pSDEDataRelationBase.getPSDEDataRelationName());
        }
        if (pSDEDataRelationBase.isPSDEIdDirty() && (bl || pSDEDataRelationBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataRelationBase.getPSDEId());
        }
        if (pSDEDataRelationBase.isPSDENameDirty() && (bl || pSDEDataRelationBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDataRelationBase.getPSDEName());
        }
        if (pSDEDataRelationBase.isPSDynaInstIdDirty() && (bl || pSDEDataRelationBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDataRelationBase.getPSDynaInstId());
        }
        if (pSDEDataRelationBase.isPSSysCounterIdDirty() && (bl || pSDEDataRelationBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDEDataRelationBase.getPSSysCounterId());
        }
        if (pSDEDataRelationBase.isPSSysCounterNameDirty() && (bl || pSDEDataRelationBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDEDataRelationBase.getPSSysCounterName());
        }
        if (pSDEDataRelationBase.isPSWFDEIdDirty() && (bl || pSDEDataRelationBase.getPSWFDEId() != null)) {
            iDataObject.set(FIELD_PSWFDEID, (Object)pSDEDataRelationBase.getPSWFDEId());
        }
        if (pSDEDataRelationBase.isSRFSysPubDirty() && (bl || pSDEDataRelationBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEDataRelationBase.getSRFSysPub());
        }
        if (pSDEDataRelationBase.isUpdateDateDirty() && (bl || pSDEDataRelationBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataRelationBase.getUpdateDate());
        }
        if (pSDEDataRelationBase.isUpdateManDirty() && (bl || pSDEDataRelationBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataRelationBase.getUpdateMan());
        }
        if (pSDEDataRelationBase.isUserCatDirty() && (bl || pSDEDataRelationBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDataRelationBase.getUserCat());
        }
        if (pSDEDataRelationBase.isUserTagDirty() && (bl || pSDEDataRelationBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDataRelationBase.getUserTag());
        }
        if (pSDEDataRelationBase.isUserTag2Dirty() && (bl || pSDEDataRelationBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDataRelationBase.getUserTag2());
        }
        if (pSDEDataRelationBase.isUserTag3Dirty() && (bl || pSDEDataRelationBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDataRelationBase.getUserTag3());
        }
        if (pSDEDataRelationBase.isUserTag4Dirty() && (bl || pSDEDataRelationBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDataRelationBase.getUserTag4());
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
        return PSDEDataRelationBase.remove(this, n);
    }

    private static boolean remove(PSDEDataRelationBase pSDEDataRelationBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataRelationBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEDataRelationBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEDataRelationBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEDataRelationBase.resetDRTag();
                return true;
            }
            case 4: {
                pSDEDataRelationBase.resetDRTag2();
                return true;
            }
            case 5: {
                pSDEDataRelationBase.resetDRTag3();
                return true;
            }
            case 6: {
                pSDEDataRelationBase.resetDRTag4();
                return true;
            }
            case 7: {
                pSDEDataRelationBase.resetDynaModelFlag();
                return true;
            }
            case 8: {
                pSDEDataRelationBase.resetEnableCustomized();
                return true;
            }
            case 9: {
                pSDEDataRelationBase.resetFormCapPSLanResId();
                return true;
            }
            case 10: {
                pSDEDataRelationBase.resetFormCapPSLanResName();
                return true;
            }
            case 11: {
                pSDEDataRelationBase.resetFormCaption();
                return true;
            }
            case 12: {
                pSDEDataRelationBase.resetFormPSDEViewBaseId();
                return true;
            }
            case 13: {
                pSDEDataRelationBase.resetFormPSDEViewBaseName();
                return true;
            }
            case 14: {
                pSDEDataRelationBase.resetFormPSSysImageId();
                return true;
            }
            case 15: {
                pSDEDataRelationBase.resetFormPSSysImageName();
                return true;
            }
            case 16: {
                pSDEDataRelationBase.resetHideEditItem();
                return true;
            }
            case 17: {
                pSDEDataRelationBase.resetLockFlag();
                return true;
            }
            case 18: {
                pSDEDataRelationBase.resetMemo();
                return true;
            }
            case 19: {
                pSDEDataRelationBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 20: {
                pSDEDataRelationBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 21: {
                pSDEDataRelationBase.resetPSDEDataRelationId();
                return true;
            }
            case 22: {
                pSDEDataRelationBase.resetPSDEDataRelationName();
                return true;
            }
            case 23: {
                pSDEDataRelationBase.resetPSDEId();
                return true;
            }
            case 24: {
                pSDEDataRelationBase.resetPSDEName();
                return true;
            }
            case 25: {
                pSDEDataRelationBase.resetPSDynaInstId();
                return true;
            }
            case 26: {
                pSDEDataRelationBase.resetPSSysCounterId();
                return true;
            }
            case 27: {
                pSDEDataRelationBase.resetPSSysCounterName();
                return true;
            }
            case 28: {
                pSDEDataRelationBase.resetPSWFDEId();
                return true;
            }
            case 29: {
                pSDEDataRelationBase.resetSRFSysPub();
                return true;
            }
            case 30: {
                pSDEDataRelationBase.resetUpdateDate();
                return true;
            }
            case 31: {
                pSDEDataRelationBase.resetUpdateMan();
                return true;
            }
            case 32: {
                pSDEDataRelationBase.resetUserCat();
                return true;
            }
            case 33: {
                pSDEDataRelationBase.resetUserTag();
                return true;
            }
            case 34: {
                pSDEDataRelationBase.resetUserTag2();
                return true;
            }
            case 35: {
                pSDEDataRelationBase.resetUserTag3();
                return true;
            }
            case 36: {
                pSDEDataRelationBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlLogicGroup getPSCtrlLogicGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroup();
        }
        if (this.getPSCtrlLogicGroupId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlLogicGroupLock;
        synchronized (n) {
            if (this.psctrllogicgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlLogicGroupId(), (Object)this.psctrllogicgroup.getPSCtrlLogicGroupId()) != 0L) {
                this.psctrllogicgroup = null;
            }
            if (this.psctrllogicgroup == null) {
                PSCtrlLogicGroup pSCtrlLogicGroup = new PSCtrlLogicGroup();
                pSCtrlLogicGroup.setPSCtrlLogicGroupId(this.getPSCtrlLogicGroupId());
                PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlLogicGroupService.autoGet(pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getFormPSDEviewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormPSDEviewBase();
        }
        if (this.getFormPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objFormPSDEviewBaseLock;
        synchronized (n) {
            if (this.formpsdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getFormPSDEViewBaseId(), (Object)this.formpsdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.formpsdeviewbase = null;
            }
            if (this.formpsdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getFormPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.formpsdeviewbase = pSDEViewBase;
            }
            return this.formpsdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getFormCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormCapPSLanRes();
        }
        if (this.getFormCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objFormCapPSLanResLock;
        synchronized (n) {
            if (this.formcappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getFormCapPSLanResId(), (Object)this.formcappslanres.getPSLanguageResId()) != 0L) {
                this.formcappslanres = null;
            }
            if (this.formcappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getFormCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.formcappslanres = pSLanguageRes;
            }
            return this.formcappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet(pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getFormPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormPSSysImage();
        }
        if (this.getFormPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objFormPSSysImageLock;
        synchronized (n) {
            if (this.formpssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getFormPSSysImageId(), (Object)this.formpssysimage.getPSSysImageId()) != 0L) {
                this.formpssysimage = null;
            }
            if (this.formpssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getFormPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.formpssysimage = pSSysImage;
            }
            return this.formpssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFDE getPSWFDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDE();
        }
        if (this.getPSWFDEId() == null) {
            return null;
        }
        Integer n = this.objPSWFDELock;
        synchronized (n) {
            if (this.pswfde != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFDEId(), (Object)this.pswfde.getPSWFDEId()) != 0L) {
                this.pswfde = null;
            }
            if (this.pswfde == null) {
                PSWFDE pSWFDE = new PSWFDE();
                pSWFDE.setPSWFDEId(this.getPSWFDEId());
                PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                pSWFDEService.autoGet(pSWFDE);
                this.pswfde = pSWFDE;
            }
            return this.pswfde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEDRDetail> getPSDEDRDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRDetails();
        }
        if (this.getPSDEDataRelationId() == null) {
            return null;
        }
        PSDEDataRelationService pSDEDataRelationService = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
        PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDRDetailsLock;
        synchronized (n) {
            if (this.psdedrdetails == null) {
                this.psdedrdetails = pSDEDataRelationService.isTempData(this) ? pSDEDRDetailService.selectTempByPSDEDR(this) : pSDEDRDetailService.selectByPSDEDR(this);
            }
            return this.psdedrdetails;
        }
    }

    private PSDEDataRelationBase getProxyEntity() {
        return this.proxyPSDEDataRelationBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataRelationBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataRelationBase) {
            this.proxyPSDEDataRelationBase = (PSDEDataRelationBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DRTAG, 3);
        fieldIndexMap.put(FIELD_DRTAG2, 4);
        fieldIndexMap.put(FIELD_DRTAG3, 5);
        fieldIndexMap.put(FIELD_DRTAG4, 6);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 7);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 8);
        fieldIndexMap.put(FIELD_FORMCAPPSLANRESID, 9);
        fieldIndexMap.put(FIELD_FORMCAPPSLANRESNAME, 10);
        fieldIndexMap.put(FIELD_FORMCAPTION, 11);
        fieldIndexMap.put(FIELD_FORMPSDEVIEWBASEID, 12);
        fieldIndexMap.put(FIELD_FORMPSDEVIEWBASENAME, 13);
        fieldIndexMap.put(FIELD_FORMPSSYSIMAGEID, 14);
        fieldIndexMap.put(FIELD_FORMPSSYSIMAGENAME, 15);
        fieldIndexMap.put(FIELD_HIDEEDITITEM, 16);
        fieldIndexMap.put(FIELD_LOCKFLAG, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 19);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 20);
        fieldIndexMap.put(FIELD_PSDEDATARELATIONID, 21);
        fieldIndexMap.put(FIELD_PSDEDATARELATIONNAME, 22);
        fieldIndexMap.put(FIELD_PSDEID, 23);
        fieldIndexMap.put(FIELD_PSDENAME, 24);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 25);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 26);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 27);
        fieldIndexMap.put(FIELD_PSWFDEID, 28);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 30);
        fieldIndexMap.put(FIELD_UPDATEMAN, 31);
        fieldIndexMap.put(FIELD_USERCAT, 32);
        fieldIndexMap.put(FIELD_USERTAG, 33);
        fieldIndexMap.put(FIELD_USERTAG2, 34);
        fieldIndexMap.put(FIELD_USERTAG3, 35);
        fieldIndexMap.put(FIELD_USERTAG4, 36);
    }
}

