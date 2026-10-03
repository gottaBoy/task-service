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
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThresholdGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSThresholdBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSThresholdBase.class);
    public static final String FIELD_BEGINVALUE = "BEGINVALUE";
    public static final String FIELD_BKCOLOR = "BKCOLOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_ENDVALUE = "ENDVALUE";
    public static final String FIELD_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String FIELD_INCENDVALUE = "INCENDVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSTHRESHOLDGROUPID = "PSTHRESHOLDGROUPID";
    public static final String FIELD_PSTHRESHOLDGROUPNAME = "PSTHRESHOLDGROUPNAME";
    public static final String FIELD_PSTHRESHOLDID = "PSTHRESHOLDID";
    public static final String FIELD_PSTHRESHOLDNAME = "PSTHRESHOLDNAME";
    public static final String FIELD_TEXTPSLANRESID = "TEXTPSLANRESID";
    public static final String FIELD_TEXTPSLANRESNAME = "TEXTPSLANRESNAME";
    public static final String FIELD_THRESHOLDTAG = "THRESHOLDTAG";
    public static final String FIELD_THRESHOLDTAG2 = "THRESHOLDTAG2";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BEGINVALUE = 0;
    private static final int INDEX_BKCOLOR = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_COLOR = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DATA = 6;
    private static final int INDEX_ENDVALUE = 7;
    private static final int INDEX_INCBEGINVALUE = 8;
    private static final int INDEX_INCENDVALUE = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PSSYSCSSID = 11;
    private static final int INDEX_PSSYSCSSNAME = 12;
    private static final int INDEX_PSSYSIMAGEID = 13;
    private static final int INDEX_PSSYSIMAGENAME = 14;
    private static final int INDEX_PSTHRESHOLDGROUPID = 15;
    private static final int INDEX_PSTHRESHOLDGROUPNAME = 16;
    private static final int INDEX_PSTHRESHOLDID = 17;
    private static final int INDEX_PSTHRESHOLDNAME = 18;
    private static final int INDEX_TEXTPSLANRESID = 19;
    private static final int INDEX_TEXTPSLANRESNAME = 20;
    private static final int INDEX_THRESHOLDTAG = 21;
    private static final int INDEX_THRESHOLDTAG2 = 22;
    private static final int INDEX_TIPPSLANRESID = 23;
    private static final int INDEX_TIPPSLANRESNAME = 24;
    private static final int INDEX_TOOLTIPINFO = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final int INDEX_VALIDFLAG = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSThresholdBase proxyPSThresholdBase = null;
    private boolean beginvalueDirtyFlag = false;
    private boolean bkcolorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean endvalueDirtyFlag = false;
    private boolean incbeginvalueDirtyFlag = false;
    private boolean incendvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean psthresholdgroupidDirtyFlag = false;
    private boolean psthresholdgroupnameDirtyFlag = false;
    private boolean psthresholdidDirtyFlag = false;
    private boolean psthresholdnameDirtyFlag = false;
    private boolean textpslanresidDirtyFlag = false;
    private boolean textpslanresnameDirtyFlag = false;
    private boolean thresholdtagDirtyFlag = false;
    private boolean thresholdtag2DirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="beginvalue")
    private Double beginvalue;
    @Column(name="bkcolor")
    private String bkcolor;
    @Column(name="codename")
    private String codename;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="endvalue")
    private Double endvalue;
    @Column(name="incbeginvalue")
    private Integer incbeginvalue;
    @Column(name="incendvalue")
    private Integer incendvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="psthresholdgroupid")
    private String psthresholdgroupid;
    @Column(name="psthresholdgroupname")
    private String psthresholdgroupname;
    @Column(name="psthresholdid")
    private String psthresholdid;
    @Column(name="psthresholdname")
    private String psthresholdname;
    @Column(name="textpslanresid")
    private String textpslanresid;
    @Column(name="textpslanresname")
    private String textpslanresname;
    @Column(name="thresholdtag")
    private String thresholdtag;
    @Column(name="thresholdtag2")
    private String thresholdtag2;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
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
    private Integer objTextPSLanResLock = new Integer(1);
    private PSLanguageRes textpslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSThresholdGroupLock = new Integer(1);
    private PSThresholdGroup psthresholdgroup = null;

    public void setBeginValue(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginValue(d);
            return;
        }
        this.beginvalue = d;
        this.beginvalueDirtyFlag = true;
    }

    public Double getBeginValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValue();
        }
        return this.beginvalue;
    }

    public boolean isBeginValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginValueDirty();
        }
        return this.beginvalueDirtyFlag;
    }

    public void resetBeginValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginValue();
            return;
        }
        this.beginvalueDirtyFlag = false;
        this.beginvalue = null;
    }

    public void setBKColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolor = string;
        this.bkcolorDirtyFlag = true;
    }

    public String getBKColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColor();
        }
        return this.bkcolor;
    }

    public boolean isBKColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorDirty();
        }
        return this.bkcolorDirtyFlag;
    }

    public void resetBKColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColor();
            return;
        }
        this.bkcolorDirtyFlag = false;
        this.bkcolor = null;
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

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
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

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setEndValue(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndValue(d);
            return;
        }
        this.endvalue = d;
        this.endvalueDirtyFlag = true;
    }

    public Double getEndValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValue();
        }
        return this.endvalue;
    }

    public boolean isEndValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndValueDirty();
        }
        return this.endvalueDirtyFlag;
    }

    public void resetEndValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndValue();
            return;
        }
        this.endvalueDirtyFlag = false;
        this.endvalue = null;
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

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
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

    public void setPSThresholdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSThresholdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psthresholdid = string;
        this.psthresholdidDirtyFlag = true;
    }

    public String getPSThresholdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdId();
        }
        return this.psthresholdid;
    }

    public boolean isPSThresholdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSThresholdIdDirty();
        }
        return this.psthresholdidDirtyFlag;
    }

    public void resetPSThresholdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSThresholdId();
            return;
        }
        this.psthresholdidDirtyFlag = false;
        this.psthresholdid = null;
    }

    public void setPSThresholdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSThresholdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psthresholdname = string;
        this.psthresholdnameDirtyFlag = true;
    }

    public String getPSThresholdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdName();
        }
        return this.psthresholdname;
    }

    public boolean isPSThresholdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSThresholdNameDirty();
        }
        return this.psthresholdnameDirtyFlag;
    }

    public void resetPSThresholdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSThresholdName();
            return;
        }
        this.psthresholdnameDirtyFlag = false;
        this.psthresholdname = null;
    }

    public void setTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpslanresid = string;
        this.textpslanresidDirtyFlag = true;
    }

    public String getTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanResId();
        }
        return this.textpslanresid;
    }

    public boolean isTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSLanResIdDirty();
        }
        return this.textpslanresidDirtyFlag;
    }

    public void resetTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSLanResId();
            return;
        }
        this.textpslanresidDirtyFlag = false;
        this.textpslanresid = null;
    }

    public void setTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpslanresname = string;
        this.textpslanresnameDirtyFlag = true;
    }

    public String getTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanResName();
        }
        return this.textpslanresname;
    }

    public boolean isTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSLanResNameDirty();
        }
        return this.textpslanresnameDirtyFlag;
    }

    public void resetTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSLanResName();
            return;
        }
        this.textpslanresnameDirtyFlag = false;
        this.textpslanresname = null;
    }

    public void setThresholdTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThresholdTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.thresholdtag = string;
        this.thresholdtagDirtyFlag = true;
    }

    public String getThresholdTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThresholdTag();
        }
        return this.thresholdtag;
    }

    public boolean isThresholdTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThresholdTagDirty();
        }
        return this.thresholdtagDirtyFlag;
    }

    public void resetThresholdTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThresholdTag();
            return;
        }
        this.thresholdtagDirtyFlag = false;
        this.thresholdtag = null;
    }

    public void setThresholdTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThresholdTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.thresholdtag2 = string;
        this.thresholdtag2DirtyFlag = true;
    }

    public String getThresholdTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThresholdTag2();
        }
        return this.thresholdtag2;
    }

    public boolean isThresholdTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThresholdTag2Dirty();
        }
        return this.thresholdtag2DirtyFlag;
    }

    public void resetThresholdTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThresholdTag2();
            return;
        }
        this.thresholdtag2DirtyFlag = false;
        this.thresholdtag2 = null;
    }

    public void setTipPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresid = string;
        this.tippslanresidDirtyFlag = true;
    }

    public String getTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResId();
        }
        return this.tippslanresid;
    }

    public boolean isTipPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResIdDirty();
        }
        return this.tippslanresidDirtyFlag;
    }

    public void resetTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResId();
            return;
        }
        this.tippslanresidDirtyFlag = false;
        this.tippslanresid = null;
    }

    public void setTipPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresname = string;
        this.tippslanresnameDirtyFlag = true;
    }

    public String getTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResName();
        }
        return this.tippslanresname;
    }

    public boolean isTipPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResNameDirty();
        }
        return this.tippslanresnameDirtyFlag;
    }

    public void resetTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResName();
            return;
        }
        this.tippslanresnameDirtyFlag = false;
        this.tippslanresname = null;
    }

    public void setTooltipInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTooltipInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltipinfo = string;
        this.tooltipinfoDirtyFlag = true;
    }

    public String getTooltipInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTooltipInfo();
        }
        return this.tooltipinfo;
    }

    public boolean isTooltipInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTooltipInfoDirty();
        }
        return this.tooltipinfoDirtyFlag;
    }

    public void resetTooltipInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTooltipInfo();
            return;
        }
        this.tooltipinfoDirtyFlag = false;
        this.tooltipinfo = null;
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
        PSThresholdBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSThresholdBase pSThresholdBase) {
        pSThresholdBase.resetBeginValue();
        pSThresholdBase.resetBKColor();
        pSThresholdBase.resetCodeName();
        pSThresholdBase.resetColor();
        pSThresholdBase.resetCreateDate();
        pSThresholdBase.resetCreateMan();
        pSThresholdBase.resetData();
        pSThresholdBase.resetEndValue();
        pSThresholdBase.resetIncBeginValue();
        pSThresholdBase.resetIncEndValue();
        pSThresholdBase.resetMemo();
        pSThresholdBase.resetPSSysCssId();
        pSThresholdBase.resetPSSysCssName();
        pSThresholdBase.resetPSSysImageId();
        pSThresholdBase.resetPSSysImageName();
        pSThresholdBase.resetPSThresholdGroupId();
        pSThresholdBase.resetPSThresholdGroupName();
        pSThresholdBase.resetPSThresholdId();
        pSThresholdBase.resetPSThresholdName();
        pSThresholdBase.resetTextPSLanResId();
        pSThresholdBase.resetTextPSLanResName();
        pSThresholdBase.resetThresholdTag();
        pSThresholdBase.resetThresholdTag2();
        pSThresholdBase.resetTipPSLanResId();
        pSThresholdBase.resetTipPSLanResName();
        pSThresholdBase.resetTooltipInfo();
        pSThresholdBase.resetUpdateDate();
        pSThresholdBase.resetUpdateMan();
        pSThresholdBase.resetUserCat();
        pSThresholdBase.resetUserTag();
        pSThresholdBase.resetUserTag2();
        pSThresholdBase.resetUserTag3();
        pSThresholdBase.resetUserTag4();
        pSThresholdBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginValueDirty()) {
            hashMap.put(FIELD_BEGINVALUE, this.getBeginValue());
        }
        if (!bl || this.isBKColorDirty()) {
            hashMap.put(FIELD_BKCOLOR, this.getBKColor());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isEndValueDirty()) {
            hashMap.put(FIELD_ENDVALUE, this.getEndValue());
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
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSThresholdGroupIdDirty()) {
            hashMap.put(FIELD_PSTHRESHOLDGROUPID, this.getPSThresholdGroupId());
        }
        if (!bl || this.isPSThresholdGroupNameDirty()) {
            hashMap.put(FIELD_PSTHRESHOLDGROUPNAME, this.getPSThresholdGroupName());
        }
        if (!bl || this.isPSThresholdIdDirty()) {
            hashMap.put(FIELD_PSTHRESHOLDID, this.getPSThresholdId());
        }
        if (!bl || this.isPSThresholdNameDirty()) {
            hashMap.put(FIELD_PSTHRESHOLDNAME, this.getPSThresholdName());
        }
        if (!bl || this.isTextPSLanResIdDirty()) {
            hashMap.put(FIELD_TEXTPSLANRESID, this.getTextPSLanResId());
        }
        if (!bl || this.isTextPSLanResNameDirty()) {
            hashMap.put(FIELD_TEXTPSLANRESNAME, this.getTextPSLanResName());
        }
        if (!bl || this.isThresholdTagDirty()) {
            hashMap.put(FIELD_THRESHOLDTAG, this.getThresholdTag());
        }
        if (!bl || this.isThresholdTag2Dirty()) {
            hashMap.put(FIELD_THRESHOLDTAG2, this.getThresholdTag2());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
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
        return PSThresholdBase.get(this, n);
    }

    private static Object get(PSThresholdBase pSThresholdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSThresholdBase.getBeginValue();
            }
            case 1: {
                return pSThresholdBase.getBKColor();
            }
            case 2: {
                return pSThresholdBase.getCodeName();
            }
            case 3: {
                return pSThresholdBase.getColor();
            }
            case 4: {
                return pSThresholdBase.getCreateDate();
            }
            case 5: {
                return pSThresholdBase.getCreateMan();
            }
            case 6: {
                return pSThresholdBase.getData();
            }
            case 7: {
                return pSThresholdBase.getEndValue();
            }
            case 8: {
                return pSThresholdBase.getIncBeginValue();
            }
            case 9: {
                return pSThresholdBase.getIncEndValue();
            }
            case 10: {
                return pSThresholdBase.getMemo();
            }
            case 11: {
                return pSThresholdBase.getPSSysCssId();
            }
            case 12: {
                return pSThresholdBase.getPSSysCssName();
            }
            case 13: {
                return pSThresholdBase.getPSSysImageId();
            }
            case 14: {
                return pSThresholdBase.getPSSysImageName();
            }
            case 15: {
                return pSThresholdBase.getPSThresholdGroupId();
            }
            case 16: {
                return pSThresholdBase.getPSThresholdGroupName();
            }
            case 17: {
                return pSThresholdBase.getPSThresholdId();
            }
            case 18: {
                return pSThresholdBase.getPSThresholdName();
            }
            case 19: {
                return pSThresholdBase.getTextPSLanResId();
            }
            case 20: {
                return pSThresholdBase.getTextPSLanResName();
            }
            case 21: {
                return pSThresholdBase.getThresholdTag();
            }
            case 22: {
                return pSThresholdBase.getThresholdTag2();
            }
            case 23: {
                return pSThresholdBase.getTipPSLanResId();
            }
            case 24: {
                return pSThresholdBase.getTipPSLanResName();
            }
            case 25: {
                return pSThresholdBase.getTooltipInfo();
            }
            case 26: {
                return pSThresholdBase.getUpdateDate();
            }
            case 27: {
                return pSThresholdBase.getUpdateMan();
            }
            case 28: {
                return pSThresholdBase.getUserCat();
            }
            case 29: {
                return pSThresholdBase.getUserTag();
            }
            case 30: {
                return pSThresholdBase.getUserTag2();
            }
            case 31: {
                return pSThresholdBase.getUserTag3();
            }
            case 32: {
                return pSThresholdBase.getUserTag4();
            }
            case 33: {
                return pSThresholdBase.getValidFlag();
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
        PSThresholdBase.set(this, n, object);
    }

    private static void set(PSThresholdBase pSThresholdBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSThresholdBase.setBeginValue(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 1: {
                pSThresholdBase.setBKColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSThresholdBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSThresholdBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSThresholdBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSThresholdBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSThresholdBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSThresholdBase.setEndValue(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 8: {
                pSThresholdBase.setIncBeginValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSThresholdBase.setIncEndValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSThresholdBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSThresholdBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSThresholdBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSThresholdBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSThresholdBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSThresholdBase.setPSThresholdGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSThresholdBase.setPSThresholdGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSThresholdBase.setPSThresholdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSThresholdBase.setPSThresholdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSThresholdBase.setTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSThresholdBase.setTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSThresholdBase.setThresholdTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSThresholdBase.setThresholdTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSThresholdBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSThresholdBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSThresholdBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSThresholdBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSThresholdBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSThresholdBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSThresholdBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSThresholdBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSThresholdBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSThresholdBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSThresholdBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSThresholdBase.isNull(this, n);
    }

    private static boolean isNull(PSThresholdBase pSThresholdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSThresholdBase.getBeginValue() == null;
            }
            case 1: {
                return pSThresholdBase.getBKColor() == null;
            }
            case 2: {
                return pSThresholdBase.getCodeName() == null;
            }
            case 3: {
                return pSThresholdBase.getColor() == null;
            }
            case 4: {
                return pSThresholdBase.getCreateDate() == null;
            }
            case 5: {
                return pSThresholdBase.getCreateMan() == null;
            }
            case 6: {
                return pSThresholdBase.getData() == null;
            }
            case 7: {
                return pSThresholdBase.getEndValue() == null;
            }
            case 8: {
                return pSThresholdBase.getIncBeginValue() == null;
            }
            case 9: {
                return pSThresholdBase.getIncEndValue() == null;
            }
            case 10: {
                return pSThresholdBase.getMemo() == null;
            }
            case 11: {
                return pSThresholdBase.getPSSysCssId() == null;
            }
            case 12: {
                return pSThresholdBase.getPSSysCssName() == null;
            }
            case 13: {
                return pSThresholdBase.getPSSysImageId() == null;
            }
            case 14: {
                return pSThresholdBase.getPSSysImageName() == null;
            }
            case 15: {
                return pSThresholdBase.getPSThresholdGroupId() == null;
            }
            case 16: {
                return pSThresholdBase.getPSThresholdGroupName() == null;
            }
            case 17: {
                return pSThresholdBase.getPSThresholdId() == null;
            }
            case 18: {
                return pSThresholdBase.getPSThresholdName() == null;
            }
            case 19: {
                return pSThresholdBase.getTextPSLanResId() == null;
            }
            case 20: {
                return pSThresholdBase.getTextPSLanResName() == null;
            }
            case 21: {
                return pSThresholdBase.getThresholdTag() == null;
            }
            case 22: {
                return pSThresholdBase.getThresholdTag2() == null;
            }
            case 23: {
                return pSThresholdBase.getTipPSLanResId() == null;
            }
            case 24: {
                return pSThresholdBase.getTipPSLanResName() == null;
            }
            case 25: {
                return pSThresholdBase.getTooltipInfo() == null;
            }
            case 26: {
                return pSThresholdBase.getUpdateDate() == null;
            }
            case 27: {
                return pSThresholdBase.getUpdateMan() == null;
            }
            case 28: {
                return pSThresholdBase.getUserCat() == null;
            }
            case 29: {
                return pSThresholdBase.getUserTag() == null;
            }
            case 30: {
                return pSThresholdBase.getUserTag2() == null;
            }
            case 31: {
                return pSThresholdBase.getUserTag3() == null;
            }
            case 32: {
                return pSThresholdBase.getUserTag4() == null;
            }
            case 33: {
                return pSThresholdBase.getValidFlag() == null;
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
        return PSThresholdBase.contains(this, n);
    }

    private static boolean contains(PSThresholdBase pSThresholdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSThresholdBase.isBeginValueDirty();
            }
            case 1: {
                return pSThresholdBase.isBKColorDirty();
            }
            case 2: {
                return pSThresholdBase.isCodeNameDirty();
            }
            case 3: {
                return pSThresholdBase.isColorDirty();
            }
            case 4: {
                return pSThresholdBase.isCreateDateDirty();
            }
            case 5: {
                return pSThresholdBase.isCreateManDirty();
            }
            case 6: {
                return pSThresholdBase.isDataDirty();
            }
            case 7: {
                return pSThresholdBase.isEndValueDirty();
            }
            case 8: {
                return pSThresholdBase.isIncBeginValueDirty();
            }
            case 9: {
                return pSThresholdBase.isIncEndValueDirty();
            }
            case 10: {
                return pSThresholdBase.isMemoDirty();
            }
            case 11: {
                return pSThresholdBase.isPSSysCssIdDirty();
            }
            case 12: {
                return pSThresholdBase.isPSSysCssNameDirty();
            }
            case 13: {
                return pSThresholdBase.isPSSysImageIdDirty();
            }
            case 14: {
                return pSThresholdBase.isPSSysImageNameDirty();
            }
            case 15: {
                return pSThresholdBase.isPSThresholdGroupIdDirty();
            }
            case 16: {
                return pSThresholdBase.isPSThresholdGroupNameDirty();
            }
            case 17: {
                return pSThresholdBase.isPSThresholdIdDirty();
            }
            case 18: {
                return pSThresholdBase.isPSThresholdNameDirty();
            }
            case 19: {
                return pSThresholdBase.isTextPSLanResIdDirty();
            }
            case 20: {
                return pSThresholdBase.isTextPSLanResNameDirty();
            }
            case 21: {
                return pSThresholdBase.isThresholdTagDirty();
            }
            case 22: {
                return pSThresholdBase.isThresholdTag2Dirty();
            }
            case 23: {
                return pSThresholdBase.isTipPSLanResIdDirty();
            }
            case 24: {
                return pSThresholdBase.isTipPSLanResNameDirty();
            }
            case 25: {
                return pSThresholdBase.isTooltipInfoDirty();
            }
            case 26: {
                return pSThresholdBase.isUpdateDateDirty();
            }
            case 27: {
                return pSThresholdBase.isUpdateManDirty();
            }
            case 28: {
                return pSThresholdBase.isUserCatDirty();
            }
            case 29: {
                return pSThresholdBase.isUserTagDirty();
            }
            case 30: {
                return pSThresholdBase.isUserTag2Dirty();
            }
            case 31: {
                return pSThresholdBase.isUserTag3Dirty();
            }
            case 32: {
                return pSThresholdBase.isUserTag4Dirty();
            }
            case 33: {
                return pSThresholdBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSThresholdBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSThresholdBase pSThresholdBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSThresholdBase.getBeginValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginvalue", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getBeginValue()), (boolean)false);
        }
        if (bl || pSThresholdBase.getBKColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolor", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getBKColor()), (boolean)false);
        }
        if (bl || pSThresholdBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getCodeName()), (boolean)false);
        }
        if (bl || pSThresholdBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getColor()), (boolean)false);
        }
        if (bl || pSThresholdBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSThresholdBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSThresholdBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getData()), (boolean)false);
        }
        if (bl || pSThresholdBase.getEndValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endvalue", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getEndValue()), (boolean)false);
        }
        if (bl || pSThresholdBase.getIncBeginValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incbeginvalue", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getIncBeginValue()), (boolean)false);
        }
        if (bl || pSThresholdBase.getIncEndValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incendvalue", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getIncEndValue()), (boolean)false);
        }
        if (bl || pSThresholdBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getMemo()), (boolean)false);
        }
        if (bl || pSThresholdBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSThresholdBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSThresholdBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSThresholdBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSThresholdBase.getPSThresholdGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psthresholdgroupid", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getPSThresholdGroupId()), (boolean)false);
        }
        if (bl || pSThresholdBase.getPSThresholdGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psthresholdgroupname", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getPSThresholdGroupName()), (boolean)false);
        }
        if (bl || pSThresholdBase.getPSThresholdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psthresholdid", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getPSThresholdId()), (boolean)false);
        }
        if (bl || pSThresholdBase.getPSThresholdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psthresholdname", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getPSThresholdName()), (boolean)false);
        }
        if (bl || pSThresholdBase.getTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpslanresid", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getTextPSLanResId()), (boolean)false);
        }
        if (bl || pSThresholdBase.getTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpslanresname", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getTextPSLanResName()), (boolean)false);
        }
        if (bl || pSThresholdBase.getThresholdTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"thresholdtag", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getThresholdTag()), (boolean)false);
        }
        if (bl || pSThresholdBase.getThresholdTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"thresholdtag2", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getThresholdTag2()), (boolean)false);
        }
        if (bl || pSThresholdBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSThresholdBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSThresholdBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSThresholdBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSThresholdBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSThresholdBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getUserCat()), (boolean)false);
        }
        if (bl || pSThresholdBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getUserTag()), (boolean)false);
        }
        if (bl || pSThresholdBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSThresholdBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSThresholdBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSThresholdBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSThresholdBase.getJSONValue((Object)pSThresholdBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSThresholdBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSThresholdBase pSThresholdBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSThresholdBase.getBeginValue() != null) {
            object = pSThresholdBase.getBeginValue();
            xmlNode.setAttribute(FIELD_BEGINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSThresholdBase.getBKColor() != null) {
            object = pSThresholdBase.getBKColor();
            xmlNode.setAttribute(FIELD_BKCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getCodeName() != null) {
            object = pSThresholdBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getColor() != null) {
            object = pSThresholdBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getCreateDate() != null) {
            object = pSThresholdBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSThresholdBase.getCreateMan() != null) {
            object = pSThresholdBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getData() != null) {
            object = pSThresholdBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getEndValue() != null) {
            object = pSThresholdBase.getEndValue();
            xmlNode.setAttribute(FIELD_ENDVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSThresholdBase.getIncBeginValue() != null) {
            object = pSThresholdBase.getIncBeginValue();
            xmlNode.setAttribute(FIELD_INCBEGINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSThresholdBase.getIncEndValue() != null) {
            object = pSThresholdBase.getIncEndValue();
            xmlNode.setAttribute(FIELD_INCENDVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSThresholdBase.getMemo() != null) {
            object = pSThresholdBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getPSSysCssId() != null) {
            object = pSThresholdBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getPSSysCssName() != null) {
            object = pSThresholdBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getPSSysImageId() != null) {
            object = pSThresholdBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getPSSysImageName() != null) {
            object = pSThresholdBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getPSThresholdGroupId() != null) {
            object = pSThresholdBase.getPSThresholdGroupId();
            xmlNode.setAttribute(FIELD_PSTHRESHOLDGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getPSThresholdGroupName() != null) {
            object = pSThresholdBase.getPSThresholdGroupName();
            xmlNode.setAttribute(FIELD_PSTHRESHOLDGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getPSThresholdId() != null) {
            object = pSThresholdBase.getPSThresholdId();
            xmlNode.setAttribute(FIELD_PSTHRESHOLDID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getPSThresholdName() != null) {
            object = pSThresholdBase.getPSThresholdName();
            xmlNode.setAttribute(FIELD_PSTHRESHOLDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getTextPSLanResId() != null) {
            object = pSThresholdBase.getTextPSLanResId();
            xmlNode.setAttribute(FIELD_TEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getTextPSLanResName() != null) {
            object = pSThresholdBase.getTextPSLanResName();
            xmlNode.setAttribute(FIELD_TEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getThresholdTag() != null) {
            object = pSThresholdBase.getThresholdTag();
            xmlNode.setAttribute(FIELD_THRESHOLDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getThresholdTag2() != null) {
            object = pSThresholdBase.getThresholdTag2();
            xmlNode.setAttribute(FIELD_THRESHOLDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getTipPSLanResId() != null) {
            object = pSThresholdBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getTipPSLanResName() != null) {
            object = pSThresholdBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getTooltipInfo() != null) {
            object = pSThresholdBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getUpdateDate() != null) {
            object = pSThresholdBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSThresholdBase.getUpdateMan() != null) {
            object = pSThresholdBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getUserCat() != null) {
            object = pSThresholdBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getUserTag() != null) {
            object = pSThresholdBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getUserTag2() != null) {
            object = pSThresholdBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getUserTag3() != null) {
            object = pSThresholdBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getUserTag4() != null) {
            object = pSThresholdBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSThresholdBase.getValidFlag() != null) {
            object = pSThresholdBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSThresholdBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSThresholdBase pSThresholdBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSThresholdBase.isBeginValueDirty() && (bl || pSThresholdBase.getBeginValue() != null)) {
            iDataObject.set(FIELD_BEGINVALUE, (Object)pSThresholdBase.getBeginValue());
        }
        if (pSThresholdBase.isBKColorDirty() && (bl || pSThresholdBase.getBKColor() != null)) {
            iDataObject.set(FIELD_BKCOLOR, (Object)pSThresholdBase.getBKColor());
        }
        if (pSThresholdBase.isCodeNameDirty() && (bl || pSThresholdBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSThresholdBase.getCodeName());
        }
        if (pSThresholdBase.isColorDirty() && (bl || pSThresholdBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSThresholdBase.getColor());
        }
        if (pSThresholdBase.isCreateDateDirty() && (bl || pSThresholdBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSThresholdBase.getCreateDate());
        }
        if (pSThresholdBase.isCreateManDirty() && (bl || pSThresholdBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSThresholdBase.getCreateMan());
        }
        if (pSThresholdBase.isDataDirty() && (bl || pSThresholdBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSThresholdBase.getData());
        }
        if (pSThresholdBase.isEndValueDirty() && (bl || pSThresholdBase.getEndValue() != null)) {
            iDataObject.set(FIELD_ENDVALUE, (Object)pSThresholdBase.getEndValue());
        }
        if (pSThresholdBase.isIncBeginValueDirty() && (bl || pSThresholdBase.getIncBeginValue() != null)) {
            iDataObject.set(FIELD_INCBEGINVALUE, (Object)pSThresholdBase.getIncBeginValue());
        }
        if (pSThresholdBase.isIncEndValueDirty() && (bl || pSThresholdBase.getIncEndValue() != null)) {
            iDataObject.set(FIELD_INCENDVALUE, (Object)pSThresholdBase.getIncEndValue());
        }
        if (pSThresholdBase.isMemoDirty() && (bl || pSThresholdBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSThresholdBase.getMemo());
        }
        if (pSThresholdBase.isPSSysCssIdDirty() && (bl || pSThresholdBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSThresholdBase.getPSSysCssId());
        }
        if (pSThresholdBase.isPSSysCssNameDirty() && (bl || pSThresholdBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSThresholdBase.getPSSysCssName());
        }
        if (pSThresholdBase.isPSSysImageIdDirty() && (bl || pSThresholdBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSThresholdBase.getPSSysImageId());
        }
        if (pSThresholdBase.isPSSysImageNameDirty() && (bl || pSThresholdBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSThresholdBase.getPSSysImageName());
        }
        if (pSThresholdBase.isPSThresholdGroupIdDirty() && (bl || pSThresholdBase.getPSThresholdGroupId() != null)) {
            iDataObject.set(FIELD_PSTHRESHOLDGROUPID, (Object)pSThresholdBase.getPSThresholdGroupId());
        }
        if (pSThresholdBase.isPSThresholdGroupNameDirty() && (bl || pSThresholdBase.getPSThresholdGroupName() != null)) {
            iDataObject.set(FIELD_PSTHRESHOLDGROUPNAME, (Object)pSThresholdBase.getPSThresholdGroupName());
        }
        if (pSThresholdBase.isPSThresholdIdDirty() && (bl || pSThresholdBase.getPSThresholdId() != null)) {
            iDataObject.set(FIELD_PSTHRESHOLDID, (Object)pSThresholdBase.getPSThresholdId());
        }
        if (pSThresholdBase.isPSThresholdNameDirty() && (bl || pSThresholdBase.getPSThresholdName() != null)) {
            iDataObject.set(FIELD_PSTHRESHOLDNAME, (Object)pSThresholdBase.getPSThresholdName());
        }
        if (pSThresholdBase.isTextPSLanResIdDirty() && (bl || pSThresholdBase.getTextPSLanResId() != null)) {
            iDataObject.set(FIELD_TEXTPSLANRESID, (Object)pSThresholdBase.getTextPSLanResId());
        }
        if (pSThresholdBase.isTextPSLanResNameDirty() && (bl || pSThresholdBase.getTextPSLanResName() != null)) {
            iDataObject.set(FIELD_TEXTPSLANRESNAME, (Object)pSThresholdBase.getTextPSLanResName());
        }
        if (pSThresholdBase.isThresholdTagDirty() && (bl || pSThresholdBase.getThresholdTag() != null)) {
            iDataObject.set(FIELD_THRESHOLDTAG, (Object)pSThresholdBase.getThresholdTag());
        }
        if (pSThresholdBase.isThresholdTag2Dirty() && (bl || pSThresholdBase.getThresholdTag2() != null)) {
            iDataObject.set(FIELD_THRESHOLDTAG2, (Object)pSThresholdBase.getThresholdTag2());
        }
        if (pSThresholdBase.isTipPSLanResIdDirty() && (bl || pSThresholdBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSThresholdBase.getTipPSLanResId());
        }
        if (pSThresholdBase.isTipPSLanResNameDirty() && (bl || pSThresholdBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSThresholdBase.getTipPSLanResName());
        }
        if (pSThresholdBase.isTooltipInfoDirty() && (bl || pSThresholdBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSThresholdBase.getTooltipInfo());
        }
        if (pSThresholdBase.isUpdateDateDirty() && (bl || pSThresholdBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSThresholdBase.getUpdateDate());
        }
        if (pSThresholdBase.isUpdateManDirty() && (bl || pSThresholdBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSThresholdBase.getUpdateMan());
        }
        if (pSThresholdBase.isUserCatDirty() && (bl || pSThresholdBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSThresholdBase.getUserCat());
        }
        if (pSThresholdBase.isUserTagDirty() && (bl || pSThresholdBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSThresholdBase.getUserTag());
        }
        if (pSThresholdBase.isUserTag2Dirty() && (bl || pSThresholdBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSThresholdBase.getUserTag2());
        }
        if (pSThresholdBase.isUserTag3Dirty() && (bl || pSThresholdBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSThresholdBase.getUserTag3());
        }
        if (pSThresholdBase.isUserTag4Dirty() && (bl || pSThresholdBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSThresholdBase.getUserTag4());
        }
        if (pSThresholdBase.isValidFlagDirty() && (bl || pSThresholdBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSThresholdBase.getValidFlag());
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
        return PSThresholdBase.remove(this, n);
    }

    private static boolean remove(PSThresholdBase pSThresholdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSThresholdBase.resetBeginValue();
                return true;
            }
            case 1: {
                pSThresholdBase.resetBKColor();
                return true;
            }
            case 2: {
                pSThresholdBase.resetCodeName();
                return true;
            }
            case 3: {
                pSThresholdBase.resetColor();
                return true;
            }
            case 4: {
                pSThresholdBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSThresholdBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSThresholdBase.resetData();
                return true;
            }
            case 7: {
                pSThresholdBase.resetEndValue();
                return true;
            }
            case 8: {
                pSThresholdBase.resetIncBeginValue();
                return true;
            }
            case 9: {
                pSThresholdBase.resetIncEndValue();
                return true;
            }
            case 10: {
                pSThresholdBase.resetMemo();
                return true;
            }
            case 11: {
                pSThresholdBase.resetPSSysCssId();
                return true;
            }
            case 12: {
                pSThresholdBase.resetPSSysCssName();
                return true;
            }
            case 13: {
                pSThresholdBase.resetPSSysImageId();
                return true;
            }
            case 14: {
                pSThresholdBase.resetPSSysImageName();
                return true;
            }
            case 15: {
                pSThresholdBase.resetPSThresholdGroupId();
                return true;
            }
            case 16: {
                pSThresholdBase.resetPSThresholdGroupName();
                return true;
            }
            case 17: {
                pSThresholdBase.resetPSThresholdId();
                return true;
            }
            case 18: {
                pSThresholdBase.resetPSThresholdName();
                return true;
            }
            case 19: {
                pSThresholdBase.resetTextPSLanResId();
                return true;
            }
            case 20: {
                pSThresholdBase.resetTextPSLanResName();
                return true;
            }
            case 21: {
                pSThresholdBase.resetThresholdTag();
                return true;
            }
            case 22: {
                pSThresholdBase.resetThresholdTag2();
                return true;
            }
            case 23: {
                pSThresholdBase.resetTipPSLanResId();
                return true;
            }
            case 24: {
                pSThresholdBase.resetTipPSLanResName();
                return true;
            }
            case 25: {
                pSThresholdBase.resetTooltipInfo();
                return true;
            }
            case 26: {
                pSThresholdBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSThresholdBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSThresholdBase.resetUserCat();
                return true;
            }
            case 29: {
                pSThresholdBase.resetUserTag();
                return true;
            }
            case 30: {
                pSThresholdBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSThresholdBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSThresholdBase.resetUserTag4();
                return true;
            }
            case 33: {
                pSThresholdBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanRes();
        }
        if (this.getTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTextPSLanResLock;
        synchronized (n) {
            if (this.textpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTextPSLanResId(), (Object)this.textpslanres.getPSLanguageResId()) != 0L) {
                this.textpslanres = null;
            }
            if (this.textpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.textpslanres = pSLanguageRes;
            }
            return this.textpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTipPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanRes();
        }
        if (this.getTipPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTipPSLanResLock;
        synchronized (n) {
            if (this.tippslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTipPSLanResId(), (Object)this.tippslanres.getPSLanguageResId()) != 0L) {
                this.tippslanres = null;
            }
            if (this.tippslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTipPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSThresholdGroup getPSThresholdGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdGroup();
        }
        if (this.getPSThresholdGroupId() == null) {
            return null;
        }
        Integer n = this.objPSThresholdGroupLock;
        synchronized (n) {
            if (this.psthresholdgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSThresholdGroupId(), (Object)this.psthresholdgroup.getPSThresholdGroupId()) != 0L) {
                this.psthresholdgroup = null;
            }
            if (this.psthresholdgroup == null) {
                PSThresholdGroup pSThresholdGroup = new PSThresholdGroup();
                pSThresholdGroup.setPSThresholdGroupId(this.getPSThresholdGroupId());
                PSThresholdGroupService pSThresholdGroupService = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
                pSThresholdGroupService.autoGet(pSThresholdGroup);
                this.psthresholdgroup = pSThresholdGroup;
            }
            return this.psthresholdgroup;
        }
    }

    private PSThresholdBase getProxyEntity() {
        return this.proxyPSThresholdBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSThresholdBase = null;
        if (iDataObject != null && iDataObject instanceof PSThresholdBase) {
            this.proxyPSThresholdBase = (PSThresholdBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSThresholdService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINVALUE, 0);
        fieldIndexMap.put(FIELD_BKCOLOR, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_COLOR, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DATA, 6);
        fieldIndexMap.put(FIELD_ENDVALUE, 7);
        fieldIndexMap.put(FIELD_INCBEGINVALUE, 8);
        fieldIndexMap.put(FIELD_INCENDVALUE, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 11);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 13);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 14);
        fieldIndexMap.put(FIELD_PSTHRESHOLDGROUPID, 15);
        fieldIndexMap.put(FIELD_PSTHRESHOLDGROUPNAME, 16);
        fieldIndexMap.put(FIELD_PSTHRESHOLDID, 17);
        fieldIndexMap.put(FIELD_PSTHRESHOLDNAME, 18);
        fieldIndexMap.put(FIELD_TEXTPSLANRESID, 19);
        fieldIndexMap.put(FIELD_TEXTPSLANRESNAME, 20);
        fieldIndexMap.put(FIELD_THRESHOLDTAG, 21);
        fieldIndexMap.put(FIELD_THRESHOLDTAG2, 22);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 23);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 24);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
        fieldIndexMap.put(FIELD_VALIDFLAG, 33);
    }
}

