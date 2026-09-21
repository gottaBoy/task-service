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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewRVBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewRVBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFVIEWTYPE = "DEFVIEWTYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_MAJORPSDEVIEWID = "MAJORPSDEVIEWID";
    public static final String FIELD_MAJORPSDEVIEWNAME = "MAJORPSDEVIEWNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDEVIEWID = "MINORPSDEVIEWID";
    public static final String FIELD_MINORPSDEVIEWNAME = "MINORPSDEVIEWNAME";
    public static final String FIELD_OPENMODE = "OPENMODE";
    public static final String FIELD_PSDEVIEWRVID = "PSDEVIEWRVID";
    public static final String FIELD_PSDEVIEWRVNAME = "PSDEVIEWRVNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFMODETEXT = "REFMODETEXT";
    public static final String FIELD_REFPARAM = "REFPARAM";
    public static final String FIELD_REFPARAMDESC = "REFPARAMDESC";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String FIELD_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VIEWPARAMS = "VIEWPARAMS";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFVIEWTYPE = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_HEIGHT = 4;
    private static final int INDEX_MAJORPSDEVIEWID = 5;
    private static final int INDEX_MAJORPSDEVIEWNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_MINORPSDEVIEWID = 8;
    private static final int INDEX_MINORPSDEVIEWNAME = 9;
    private static final int INDEX_OPENMODE = 10;
    private static final int INDEX_PSDEVIEWRVID = 11;
    private static final int INDEX_PSDEVIEWRVNAME = 12;
    private static final int INDEX_PSDYNAINSTID = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_REFMODE = 15;
    private static final int INDEX_REFMODETEXT = 16;
    private static final int INDEX_REFPARAM = 17;
    private static final int INDEX_REFPARAMDESC = 18;
    private static final int INDEX_TITLE = 19;
    private static final int INDEX_TITLEPSLANRESID = 20;
    private static final int INDEX_TITLEPSLANRESNAME = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_VIEWPARAMS = 26;
    private static final int INDEX_WIDTH = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewRVBase proxyPSDEViewRVBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defviewtypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean majorpsdeviewidDirtyFlag = false;
    private boolean majorpsdeviewnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsdeviewidDirtyFlag = false;
    private boolean minorpsdeviewnameDirtyFlag = false;
    private boolean openmodeDirtyFlag = false;
    private boolean psdeviewrvidDirtyFlag = false;
    private boolean psdeviewrvnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refmodetextDirtyFlag = false;
    private boolean refparamDirtyFlag = false;
    private boolean refparamdescDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean titlepslanresidDirtyFlag = false;
    private boolean titlepslanresnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean viewparamsDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defviewtype")
    private String defviewtype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="height")
    private Integer height;
    @Column(name="majorpsdeviewid")
    private String majorpsdeviewid;
    @Column(name="majorpsdeviewname")
    private String majorpsdeviewname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsdeviewid")
    private String minorpsdeviewid;
    @Column(name="minorpsdeviewname")
    private String minorpsdeviewname;
    @Column(name="openmode")
    private String openmode;
    @Column(name="psdeviewrvid")
    private String psdeviewrvid;
    @Column(name="psdeviewrvname")
    private String psdeviewrvname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refmodetext")
    private String refmodetext;
    @Column(name="refparam")
    private String refparam;
    @Column(name="refparamdesc")
    private String refparamdesc;
    @Column(name="title")
    private String title;
    @Column(name="titlepslanresid")
    private String titlepslanresid;
    @Column(name="titlepslanresname")
    private String titlepslanresname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="viewparams")
    private String viewparams;
    @Column(name="width")
    private Integer width;
    private Integer objMajorPSDEViewLock = new Integer(1);
    private PSDEViewBase majorpsdeview = null;
    private Integer objMinorPSDEViewLock = new Integer(1);
    private PSDEViewBase minorpsdeview = null;
    private Integer objTitlePSLanResLock = new Integer(1);
    private PSLanguageRes titlepslanres = null;

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

    public void setDefViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defviewtype = string;
        this.defviewtypeDirtyFlag = true;
    }

    public String getDefViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefViewType();
        }
        return this.defviewtype;
    }

    public boolean isDefViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefViewTypeDirty();
        }
        return this.defviewtypeDirtyFlag;
    }

    public void resetDefViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefViewType();
            return;
        }
        this.defviewtypeDirtyFlag = false;
        this.defviewtype = null;
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

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setMajorPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdeviewid = string;
        this.majorpsdeviewidDirtyFlag = true;
    }

    public String getMajorPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEViewId();
        }
        return this.majorpsdeviewid;
    }

    public boolean isMajorPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEViewIdDirty();
        }
        return this.majorpsdeviewidDirtyFlag;
    }

    public void resetMajorPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEViewId();
            return;
        }
        this.majorpsdeviewidDirtyFlag = false;
        this.majorpsdeviewid = null;
    }

    public void setMajorPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdeviewname = string;
        this.majorpsdeviewnameDirtyFlag = true;
    }

    public String getMajorPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEViewName();
        }
        return this.majorpsdeviewname;
    }

    public boolean isMajorPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEViewNameDirty();
        }
        return this.majorpsdeviewnameDirtyFlag;
    }

    public void resetMajorPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEViewName();
            return;
        }
        this.majorpsdeviewnameDirtyFlag = false;
        this.majorpsdeviewname = null;
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

    public void setMinorPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdeviewid = string;
        this.minorpsdeviewidDirtyFlag = true;
    }

    public String getMinorPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEViewId();
        }
        return this.minorpsdeviewid;
    }

    public boolean isMinorPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEViewIdDirty();
        }
        return this.minorpsdeviewidDirtyFlag;
    }

    public void resetMinorPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEViewId();
            return;
        }
        this.minorpsdeviewidDirtyFlag = false;
        this.minorpsdeviewid = null;
    }

    public void setMinorPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdeviewname = string;
        this.minorpsdeviewnameDirtyFlag = true;
    }

    public String getMinorPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEViewName();
        }
        return this.minorpsdeviewname;
    }

    public boolean isMinorPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEViewNameDirty();
        }
        return this.minorpsdeviewnameDirtyFlag;
    }

    public void resetMinorPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEViewName();
            return;
        }
        this.minorpsdeviewnameDirtyFlag = false;
        this.minorpsdeviewname = null;
    }

    public void setOpenMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openmode = string;
        this.openmodeDirtyFlag = true;
    }

    public String getOpenMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenMode();
        }
        return this.openmode;
    }

    public boolean isOpenModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenModeDirty();
        }
        return this.openmodeDirtyFlag;
    }

    public void resetOpenMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenMode();
            return;
        }
        this.openmodeDirtyFlag = false;
        this.openmode = null;
    }

    public void setPSDEViewRVId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewRVId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewrvid = string;
        this.psdeviewrvidDirtyFlag = true;
    }

    public String getPSDEViewRVId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewRVId();
        }
        return this.psdeviewrvid;
    }

    public boolean isPSDEViewRVIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewRVIdDirty();
        }
        return this.psdeviewrvidDirtyFlag;
    }

    public void resetPSDEViewRVId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewRVId();
            return;
        }
        this.psdeviewrvidDirtyFlag = false;
        this.psdeviewrvid = null;
    }

    public void setPSDEViewRVName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewRVName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdeviewrvname = string;
        this.psdeviewrvnameDirtyFlag = true;
    }

    public String getPSDEViewRVName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewRVName();
        }
        return this.psdeviewrvname;
    }

    public boolean isPSDEViewRVNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewRVNameDirty();
        }
        return this.psdeviewrvnameDirtyFlag;
    }

    public void resetPSDEViewRVName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewRVName();
            return;
        }
        this.psdeviewrvnameDirtyFlag = false;
        this.psdeviewrvname = null;
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

    public void setRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmode = string;
        this.refmodeDirtyFlag = true;
    }

    public String getRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMode();
        }
        return this.refmode;
    }

    public boolean isRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeDirty();
        }
        return this.refmodeDirtyFlag;
    }

    public void resetRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMode();
            return;
        }
        this.refmodeDirtyFlag = false;
        this.refmode = null;
    }

    public void setRefModeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodetext = string;
        this.refmodetextDirtyFlag = true;
    }

    public String getRefModeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModeText();
        }
        return this.refmodetext;
    }

    public boolean isRefModeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeTextDirty();
        }
        return this.refmodetextDirtyFlag;
    }

    public void resetRefModeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModeText();
            return;
        }
        this.refmodetextDirtyFlag = false;
        this.refmodetext = null;
    }

    public void setRefParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparam = string;
        this.refparamDirtyFlag = true;
    }

    public String getRefParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParam();
        }
        return this.refparam;
    }

    public boolean isRefParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamDirty();
        }
        return this.refparamDirtyFlag;
    }

    public void resetRefParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParam();
            return;
        }
        this.refparamDirtyFlag = false;
        this.refparam = null;
    }

    public void setRefParamDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParamDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparamdesc = string;
        this.refparamdescDirtyFlag = true;
    }

    public String getRefParamDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParamDesc();
        }
        return this.refparamdesc;
    }

    public boolean isRefParamDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamDescDirty();
        }
        return this.refparamdescDirtyFlag;
    }

    public void resetRefParamDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParamDesc();
            return;
        }
        this.refparamdescDirtyFlag = false;
        this.refparamdesc = null;
    }

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
    }

    public void setTitlePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresid = string;
        this.titlepslanresidDirtyFlag = true;
    }

    public String getTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResId();
        }
        return this.titlepslanresid;
    }

    public boolean isTitlePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResIdDirty();
        }
        return this.titlepslanresidDirtyFlag;
    }

    public void resetTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResId();
            return;
        }
        this.titlepslanresidDirtyFlag = false;
        this.titlepslanresid = null;
    }

    public void setTitlePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresname = string;
        this.titlepslanresnameDirtyFlag = true;
    }

    public String getTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResName();
        }
        return this.titlepslanresname;
    }

    public boolean isTitlePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResNameDirty();
        }
        return this.titlepslanresnameDirtyFlag;
    }

    public void resetTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResName();
            return;
        }
        this.titlepslanresnameDirtyFlag = false;
        this.titlepslanresname = null;
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

    public void setViewParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparams = string;
        this.viewparamsDirtyFlag = true;
    }

    public String getViewParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParams();
        }
        return this.viewparams;
    }

    public boolean isViewParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamsDirty();
        }
        return this.viewparamsDirtyFlag;
    }

    public void resetViewParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParams();
            return;
        }
        this.viewparamsDirtyFlag = false;
        this.viewparams = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSDEViewRVBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewRVBase pSDEViewRVBase) {
        pSDEViewRVBase.resetCreateDate();
        pSDEViewRVBase.resetCreateMan();
        pSDEViewRVBase.resetDefViewType();
        pSDEViewRVBase.resetDynaModelFlag();
        pSDEViewRVBase.resetHeight();
        pSDEViewRVBase.resetMajorPSDEViewId();
        pSDEViewRVBase.resetMajorPSDEViewName();
        pSDEViewRVBase.resetMemo();
        pSDEViewRVBase.resetMinorPSDEViewId();
        pSDEViewRVBase.resetMinorPSDEViewName();
        pSDEViewRVBase.resetOpenMode();
        pSDEViewRVBase.resetPSDEViewRVId();
        pSDEViewRVBase.resetPSDEViewRVName();
        pSDEViewRVBase.resetPSDynaInstId();
        pSDEViewRVBase.resetPSSystemId();
        pSDEViewRVBase.resetRefMode();
        pSDEViewRVBase.resetRefModeText();
        pSDEViewRVBase.resetRefParam();
        pSDEViewRVBase.resetRefParamDesc();
        pSDEViewRVBase.resetTitle();
        pSDEViewRVBase.resetTitlePSLanResId();
        pSDEViewRVBase.resetTitlePSLanResName();
        pSDEViewRVBase.resetUpdateDate();
        pSDEViewRVBase.resetUpdateMan();
        pSDEViewRVBase.resetUserTag();
        pSDEViewRVBase.resetUserTag2();
        pSDEViewRVBase.resetViewParams();
        pSDEViewRVBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefViewTypeDirty()) {
            hashMap.put(FIELD_DEFVIEWTYPE, this.getDefViewType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isMajorPSDEViewIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEVIEWID, this.getMajorPSDEViewId());
        }
        if (!bl || this.isMajorPSDEViewNameDirty()) {
            hashMap.put(FIELD_MAJORPSDEVIEWNAME, this.getMajorPSDEViewName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDEViewIdDirty()) {
            hashMap.put(FIELD_MINORPSDEVIEWID, this.getMinorPSDEViewId());
        }
        if (!bl || this.isMinorPSDEViewNameDirty()) {
            hashMap.put(FIELD_MINORPSDEVIEWNAME, this.getMinorPSDEViewName());
        }
        if (!bl || this.isOpenModeDirty()) {
            hashMap.put(FIELD_OPENMODE, this.getOpenMode());
        }
        if (!bl || this.isPSDEViewRVIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWRVID, this.getPSDEViewRVId());
        }
        if (!bl || this.isPSDEViewRVNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWRVNAME, this.getPSDEViewRVName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefModeTextDirty()) {
            hashMap.put(FIELD_REFMODETEXT, this.getRefModeText());
        }
        if (!bl || this.isRefParamDirty()) {
            hashMap.put(FIELD_REFPARAM, this.getRefParam());
        }
        if (!bl || this.isRefParamDescDirty()) {
            hashMap.put(FIELD_REFPARAMDESC, this.getRefParamDesc());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isTitlePSLanResIdDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESID, this.getTitlePSLanResId());
        }
        if (!bl || this.isTitlePSLanResNameDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESNAME, this.getTitlePSLanResName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isViewParamsDirty()) {
            hashMap.put(FIELD_VIEWPARAMS, this.getViewParams());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSDEViewRVBase.get(this, n);
    }

    private static Object get(PSDEViewRVBase pSDEViewRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewRVBase.getCreateDate();
            }
            case 1: {
                return pSDEViewRVBase.getCreateMan();
            }
            case 2: {
                return pSDEViewRVBase.getDefViewType();
            }
            case 3: {
                return pSDEViewRVBase.getDynaModelFlag();
            }
            case 4: {
                return pSDEViewRVBase.getHeight();
            }
            case 5: {
                return pSDEViewRVBase.getMajorPSDEViewId();
            }
            case 6: {
                return pSDEViewRVBase.getMajorPSDEViewName();
            }
            case 7: {
                return pSDEViewRVBase.getMemo();
            }
            case 8: {
                return pSDEViewRVBase.getMinorPSDEViewId();
            }
            case 9: {
                return pSDEViewRVBase.getMinorPSDEViewName();
            }
            case 10: {
                return pSDEViewRVBase.getOpenMode();
            }
            case 11: {
                return pSDEViewRVBase.getPSDEViewRVId();
            }
            case 12: {
                return pSDEViewRVBase.getPSDEViewRVName();
            }
            case 13: {
                return pSDEViewRVBase.getPSDynaInstId();
            }
            case 14: {
                return pSDEViewRVBase.getPSSystemId();
            }
            case 15: {
                return pSDEViewRVBase.getRefMode();
            }
            case 16: {
                return pSDEViewRVBase.getRefModeText();
            }
            case 17: {
                return pSDEViewRVBase.getRefParam();
            }
            case 18: {
                return pSDEViewRVBase.getRefParamDesc();
            }
            case 19: {
                return pSDEViewRVBase.getTitle();
            }
            case 20: {
                return pSDEViewRVBase.getTitlePSLanResId();
            }
            case 21: {
                return pSDEViewRVBase.getTitlePSLanResName();
            }
            case 22: {
                return pSDEViewRVBase.getUpdateDate();
            }
            case 23: {
                return pSDEViewRVBase.getUpdateMan();
            }
            case 24: {
                return pSDEViewRVBase.getUserTag();
            }
            case 25: {
                return pSDEViewRVBase.getUserTag2();
            }
            case 26: {
                return pSDEViewRVBase.getViewParams();
            }
            case 27: {
                return pSDEViewRVBase.getWidth();
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
        PSDEViewRVBase.set(this, n, object);
    }

    private static void set(PSDEViewRVBase pSDEViewRVBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewRVBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewRVBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewRVBase.setDefViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewRVBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewRVBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewRVBase.setMajorPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewRVBase.setMajorPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewRVBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewRVBase.setMinorPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewRVBase.setMinorPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewRVBase.setOpenMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewRVBase.setPSDEViewRVId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewRVBase.setPSDEViewRVName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEViewRVBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEViewRVBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEViewRVBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEViewRVBase.setRefModeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEViewRVBase.setRefParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEViewRVBase.setRefParamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEViewRVBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEViewRVBase.setTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEViewRVBase.setTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEViewRVBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDEViewRVBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEViewRVBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEViewRVBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEViewRVBase.setViewParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEViewRVBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSDEViewRVBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewRVBase pSDEViewRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewRVBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEViewRVBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEViewRVBase.getDefViewType() == null;
            }
            case 3: {
                return pSDEViewRVBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSDEViewRVBase.getHeight() == null;
            }
            case 5: {
                return pSDEViewRVBase.getMajorPSDEViewId() == null;
            }
            case 6: {
                return pSDEViewRVBase.getMajorPSDEViewName() == null;
            }
            case 7: {
                return pSDEViewRVBase.getMemo() == null;
            }
            case 8: {
                return pSDEViewRVBase.getMinorPSDEViewId() == null;
            }
            case 9: {
                return pSDEViewRVBase.getMinorPSDEViewName() == null;
            }
            case 10: {
                return pSDEViewRVBase.getOpenMode() == null;
            }
            case 11: {
                return pSDEViewRVBase.getPSDEViewRVId() == null;
            }
            case 12: {
                return pSDEViewRVBase.getPSDEViewRVName() == null;
            }
            case 13: {
                return pSDEViewRVBase.getPSDynaInstId() == null;
            }
            case 14: {
                return pSDEViewRVBase.getPSSystemId() == null;
            }
            case 15: {
                return pSDEViewRVBase.getRefMode() == null;
            }
            case 16: {
                return pSDEViewRVBase.getRefModeText() == null;
            }
            case 17: {
                return pSDEViewRVBase.getRefParam() == null;
            }
            case 18: {
                return pSDEViewRVBase.getRefParamDesc() == null;
            }
            case 19: {
                return pSDEViewRVBase.getTitle() == null;
            }
            case 20: {
                return pSDEViewRVBase.getTitlePSLanResId() == null;
            }
            case 21: {
                return pSDEViewRVBase.getTitlePSLanResName() == null;
            }
            case 22: {
                return pSDEViewRVBase.getUpdateDate() == null;
            }
            case 23: {
                return pSDEViewRVBase.getUpdateMan() == null;
            }
            case 24: {
                return pSDEViewRVBase.getUserTag() == null;
            }
            case 25: {
                return pSDEViewRVBase.getUserTag2() == null;
            }
            case 26: {
                return pSDEViewRVBase.getViewParams() == null;
            }
            case 27: {
                return pSDEViewRVBase.getWidth() == null;
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
        return PSDEViewRVBase.contains(this, n);
    }

    private static boolean contains(PSDEViewRVBase pSDEViewRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewRVBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEViewRVBase.isCreateManDirty();
            }
            case 2: {
                return pSDEViewRVBase.isDefViewTypeDirty();
            }
            case 3: {
                return pSDEViewRVBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSDEViewRVBase.isHeightDirty();
            }
            case 5: {
                return pSDEViewRVBase.isMajorPSDEViewIdDirty();
            }
            case 6: {
                return pSDEViewRVBase.isMajorPSDEViewNameDirty();
            }
            case 7: {
                return pSDEViewRVBase.isMemoDirty();
            }
            case 8: {
                return pSDEViewRVBase.isMinorPSDEViewIdDirty();
            }
            case 9: {
                return pSDEViewRVBase.isMinorPSDEViewNameDirty();
            }
            case 10: {
                return pSDEViewRVBase.isOpenModeDirty();
            }
            case 11: {
                return pSDEViewRVBase.isPSDEViewRVIdDirty();
            }
            case 12: {
                return pSDEViewRVBase.isPSDEViewRVNameDirty();
            }
            case 13: {
                return pSDEViewRVBase.isPSDynaInstIdDirty();
            }
            case 14: {
                return pSDEViewRVBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSDEViewRVBase.isRefModeDirty();
            }
            case 16: {
                return pSDEViewRVBase.isRefModeTextDirty();
            }
            case 17: {
                return pSDEViewRVBase.isRefParamDirty();
            }
            case 18: {
                return pSDEViewRVBase.isRefParamDescDirty();
            }
            case 19: {
                return pSDEViewRVBase.isTitleDirty();
            }
            case 20: {
                return pSDEViewRVBase.isTitlePSLanResIdDirty();
            }
            case 21: {
                return pSDEViewRVBase.isTitlePSLanResNameDirty();
            }
            case 22: {
                return pSDEViewRVBase.isUpdateDateDirty();
            }
            case 23: {
                return pSDEViewRVBase.isUpdateManDirty();
            }
            case 24: {
                return pSDEViewRVBase.isUserTagDirty();
            }
            case 25: {
                return pSDEViewRVBase.isUserTag2Dirty();
            }
            case 26: {
                return pSDEViewRVBase.isViewParamsDirty();
            }
            case 27: {
                return pSDEViewRVBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewRVBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewRVBase pSDEViewRVBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewRVBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getDefViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defviewtype", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getDefViewType()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getHeight()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getMajorPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdeviewid", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getMajorPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getMajorPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdeviewname", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getMajorPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getMinorPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdeviewid", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getMinorPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getMinorPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdeviewname", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getMinorPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getOpenMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openmode", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getOpenMode()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getPSDEViewRVId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewrvid", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getPSDEViewRVId()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getPSDEViewRVName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewrvname", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getPSDEViewRVName()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getRefMode()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getRefModeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodetext", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getRefModeText()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getRefParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparam", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getRefParam()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getRefParamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparamdesc", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getRefParamDesc()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getTitle()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresid", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresname", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getViewParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparams", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getViewParams()), (boolean)false);
        }
        if (bl || pSDEViewRVBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEViewRVBase.getJSONValue((Object)pSDEViewRVBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewRVBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewRVBase pSDEViewRVBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewRVBase.getCreateDate() != null) {
            object = pSDEViewRVBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewRVBase.getCreateMan() != null) {
            object = pSDEViewRVBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getDefViewType() != null) {
            object = pSDEViewRVBase.getDefViewType();
            xmlNode.setAttribute(FIELD_DEFVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getDynaModelFlag() != null) {
            object = pSDEViewRVBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewRVBase.getHeight() != null) {
            object = pSDEViewRVBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewRVBase.getMajorPSDEViewId() != null) {
            object = pSDEViewRVBase.getMajorPSDEViewId();
            xmlNode.setAttribute(FIELD_MAJORPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getMajorPSDEViewName() != null) {
            object = pSDEViewRVBase.getMajorPSDEViewName();
            xmlNode.setAttribute(FIELD_MAJORPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getMemo() != null) {
            object = pSDEViewRVBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getMinorPSDEViewId() != null) {
            object = pSDEViewRVBase.getMinorPSDEViewId();
            xmlNode.setAttribute(FIELD_MINORPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getMinorPSDEViewName() != null) {
            object = pSDEViewRVBase.getMinorPSDEViewName();
            xmlNode.setAttribute(FIELD_MINORPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getOpenMode() != null) {
            object = pSDEViewRVBase.getOpenMode();
            xmlNode.setAttribute(FIELD_OPENMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getPSDEViewRVId() != null) {
            object = pSDEViewRVBase.getPSDEViewRVId();
            xmlNode.setAttribute(FIELD_PSDEVIEWRVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getPSDEViewRVName() != null) {
            object = pSDEViewRVBase.getPSDEViewRVName();
            xmlNode.setAttribute(FIELD_PSDEVIEWRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getPSDynaInstId() != null) {
            object = pSDEViewRVBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getPSSystemId() != null) {
            object = pSDEViewRVBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getRefMode() != null) {
            object = pSDEViewRVBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getRefModeText() != null) {
            object = pSDEViewRVBase.getRefModeText();
            xmlNode.setAttribute(FIELD_REFMODETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getRefParam() != null) {
            object = pSDEViewRVBase.getRefParam();
            xmlNode.setAttribute(FIELD_REFPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getRefParamDesc() != null) {
            object = pSDEViewRVBase.getRefParamDesc();
            xmlNode.setAttribute(FIELD_REFPARAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getTitle() != null) {
            object = pSDEViewRVBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getTitlePSLanResId() != null) {
            object = pSDEViewRVBase.getTitlePSLanResId();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getTitlePSLanResName() != null) {
            object = pSDEViewRVBase.getTitlePSLanResName();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getUpdateDate() != null) {
            object = pSDEViewRVBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewRVBase.getUpdateMan() != null) {
            object = pSDEViewRVBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getUserTag() != null) {
            object = pSDEViewRVBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getUserTag2() != null) {
            object = pSDEViewRVBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getViewParams() != null) {
            object = pSDEViewRVBase.getViewParams();
            xmlNode.setAttribute(FIELD_VIEWPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewRVBase.getWidth() != null) {
            object = pSDEViewRVBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewRVBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewRVBase pSDEViewRVBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewRVBase.isCreateDateDirty() && (bl || pSDEViewRVBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewRVBase.getCreateDate());
        }
        if (pSDEViewRVBase.isCreateManDirty() && (bl || pSDEViewRVBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewRVBase.getCreateMan());
        }
        if (pSDEViewRVBase.isDefViewTypeDirty() && (bl || pSDEViewRVBase.getDefViewType() != null)) {
            iDataObject.set(FIELD_DEFVIEWTYPE, (Object)pSDEViewRVBase.getDefViewType());
        }
        if (pSDEViewRVBase.isDynaModelFlagDirty() && (bl || pSDEViewRVBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEViewRVBase.getDynaModelFlag());
        }
        if (pSDEViewRVBase.isHeightDirty() && (bl || pSDEViewRVBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSDEViewRVBase.getHeight());
        }
        if (pSDEViewRVBase.isMajorPSDEViewIdDirty() && (bl || pSDEViewRVBase.getMajorPSDEViewId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEVIEWID, (Object)pSDEViewRVBase.getMajorPSDEViewId());
        }
        if (pSDEViewRVBase.isMajorPSDEViewNameDirty() && (bl || pSDEViewRVBase.getMajorPSDEViewName() != null)) {
            iDataObject.set(FIELD_MAJORPSDEVIEWNAME, (Object)pSDEViewRVBase.getMajorPSDEViewName());
        }
        if (pSDEViewRVBase.isMemoDirty() && (bl || pSDEViewRVBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewRVBase.getMemo());
        }
        if (pSDEViewRVBase.isMinorPSDEViewIdDirty() && (bl || pSDEViewRVBase.getMinorPSDEViewId() != null)) {
            iDataObject.set(FIELD_MINORPSDEVIEWID, (Object)pSDEViewRVBase.getMinorPSDEViewId());
        }
        if (pSDEViewRVBase.isMinorPSDEViewNameDirty() && (bl || pSDEViewRVBase.getMinorPSDEViewName() != null)) {
            iDataObject.set(FIELD_MINORPSDEVIEWNAME, (Object)pSDEViewRVBase.getMinorPSDEViewName());
        }
        if (pSDEViewRVBase.isOpenModeDirty() && (bl || pSDEViewRVBase.getOpenMode() != null)) {
            iDataObject.set(FIELD_OPENMODE, (Object)pSDEViewRVBase.getOpenMode());
        }
        if (pSDEViewRVBase.isPSDEViewRVIdDirty() && (bl || pSDEViewRVBase.getPSDEViewRVId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWRVID, (Object)pSDEViewRVBase.getPSDEViewRVId());
        }
        if (pSDEViewRVBase.isPSDEViewRVNameDirty() && (bl || pSDEViewRVBase.getPSDEViewRVName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWRVNAME, (Object)pSDEViewRVBase.getPSDEViewRVName());
        }
        if (pSDEViewRVBase.isPSDynaInstIdDirty() && (bl || pSDEViewRVBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEViewRVBase.getPSDynaInstId());
        }
        if (pSDEViewRVBase.isPSSystemIdDirty() && (bl || pSDEViewRVBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEViewRVBase.getPSSystemId());
        }
        if (pSDEViewRVBase.isRefModeDirty() && (bl || pSDEViewRVBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSDEViewRVBase.getRefMode());
        }
        if (pSDEViewRVBase.isRefModeTextDirty() && (bl || pSDEViewRVBase.getRefModeText() != null)) {
            iDataObject.set(FIELD_REFMODETEXT, (Object)pSDEViewRVBase.getRefModeText());
        }
        if (pSDEViewRVBase.isRefParamDirty() && (bl || pSDEViewRVBase.getRefParam() != null)) {
            iDataObject.set(FIELD_REFPARAM, (Object)pSDEViewRVBase.getRefParam());
        }
        if (pSDEViewRVBase.isRefParamDescDirty() && (bl || pSDEViewRVBase.getRefParamDesc() != null)) {
            iDataObject.set(FIELD_REFPARAMDESC, (Object)pSDEViewRVBase.getRefParamDesc());
        }
        if (pSDEViewRVBase.isTitleDirty() && (bl || pSDEViewRVBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSDEViewRVBase.getTitle());
        }
        if (pSDEViewRVBase.isTitlePSLanResIdDirty() && (bl || pSDEViewRVBase.getTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESID, (Object)pSDEViewRVBase.getTitlePSLanResId());
        }
        if (pSDEViewRVBase.isTitlePSLanResNameDirty() && (bl || pSDEViewRVBase.getTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESNAME, (Object)pSDEViewRVBase.getTitlePSLanResName());
        }
        if (pSDEViewRVBase.isUpdateDateDirty() && (bl || pSDEViewRVBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewRVBase.getUpdateDate());
        }
        if (pSDEViewRVBase.isUpdateManDirty() && (bl || pSDEViewRVBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewRVBase.getUpdateMan());
        }
        if (pSDEViewRVBase.isUserTagDirty() && (bl || pSDEViewRVBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEViewRVBase.getUserTag());
        }
        if (pSDEViewRVBase.isUserTag2Dirty() && (bl || pSDEViewRVBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEViewRVBase.getUserTag2());
        }
        if (pSDEViewRVBase.isViewParamsDirty() && (bl || pSDEViewRVBase.getViewParams() != null)) {
            iDataObject.set(FIELD_VIEWPARAMS, (Object)pSDEViewRVBase.getViewParams());
        }
        if (pSDEViewRVBase.isWidthDirty() && (bl || pSDEViewRVBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEViewRVBase.getWidth());
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
        return PSDEViewRVBase.remove(this, n);
    }

    private static boolean remove(PSDEViewRVBase pSDEViewRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewRVBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEViewRVBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEViewRVBase.resetDefViewType();
                return true;
            }
            case 3: {
                pSDEViewRVBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSDEViewRVBase.resetHeight();
                return true;
            }
            case 5: {
                pSDEViewRVBase.resetMajorPSDEViewId();
                return true;
            }
            case 6: {
                pSDEViewRVBase.resetMajorPSDEViewName();
                return true;
            }
            case 7: {
                pSDEViewRVBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEViewRVBase.resetMinorPSDEViewId();
                return true;
            }
            case 9: {
                pSDEViewRVBase.resetMinorPSDEViewName();
                return true;
            }
            case 10: {
                pSDEViewRVBase.resetOpenMode();
                return true;
            }
            case 11: {
                pSDEViewRVBase.resetPSDEViewRVId();
                return true;
            }
            case 12: {
                pSDEViewRVBase.resetPSDEViewRVName();
                return true;
            }
            case 13: {
                pSDEViewRVBase.resetPSDynaInstId();
                return true;
            }
            case 14: {
                pSDEViewRVBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSDEViewRVBase.resetRefMode();
                return true;
            }
            case 16: {
                pSDEViewRVBase.resetRefModeText();
                return true;
            }
            case 17: {
                pSDEViewRVBase.resetRefParam();
                return true;
            }
            case 18: {
                pSDEViewRVBase.resetRefParamDesc();
                return true;
            }
            case 19: {
                pSDEViewRVBase.resetTitle();
                return true;
            }
            case 20: {
                pSDEViewRVBase.resetTitlePSLanResId();
                return true;
            }
            case 21: {
                pSDEViewRVBase.resetTitlePSLanResName();
                return true;
            }
            case 22: {
                pSDEViewRVBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSDEViewRVBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSDEViewRVBase.resetUserTag();
                return true;
            }
            case 25: {
                pSDEViewRVBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSDEViewRVBase.resetViewParams();
                return true;
            }
            case 27: {
                pSDEViewRVBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMajorPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEView();
        }
        if (this.getMajorPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDEViewLock;
        synchronized (n) {
            if (this.majorpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDEViewId(), (Object)this.majorpsdeview.getPSDEViewBaseId()) != 0L) {
                this.majorpsdeview = null;
            }
            if (this.majorpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMajorPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.majorpsdeview = pSDEViewBase;
            }
            return this.majorpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMinorPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEView();
        }
        if (this.getMinorPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDEViewLock;
        synchronized (n) {
            if (this.minorpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDEViewId(), (Object)this.minorpsdeview.getPSDEViewBaseId()) != 0L) {
                this.minorpsdeview = null;
            }
            if (this.minorpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMinorPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.minorpsdeview = pSDEViewBase;
            }
            return this.minorpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTitlePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanRes();
        }
        if (this.getTitlePSLanResId() == null) {
            return null;
        }
        Integer n = this.objTitlePSLanResLock;
        synchronized (n) {
            if (this.titlepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSLanResId(), (Object)this.titlepslanres.getPSLanguageResId()) != 0L) {
                this.titlepslanres = null;
            }
            if (this.titlepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTitlePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.titlepslanres = pSLanguageRes;
            }
            return this.titlepslanres;
        }
    }

    private PSDEViewRVBase getProxyEntity() {
        return this.proxyPSDEViewRVBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewRVBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewRVBase) {
            this.proxyPSDEViewRVBase = (PSDEViewRVBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFVIEWTYPE, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_HEIGHT, 4);
        fieldIndexMap.put(FIELD_MAJORPSDEVIEWID, 5);
        fieldIndexMap.put(FIELD_MAJORPSDEVIEWNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_MINORPSDEVIEWID, 8);
        fieldIndexMap.put(FIELD_MINORPSDEVIEWNAME, 9);
        fieldIndexMap.put(FIELD_OPENMODE, 10);
        fieldIndexMap.put(FIELD_PSDEVIEWRVID, 11);
        fieldIndexMap.put(FIELD_PSDEVIEWRVNAME, 12);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_REFMODE, 15);
        fieldIndexMap.put(FIELD_REFMODETEXT, 16);
        fieldIndexMap.put(FIELD_REFPARAM, 17);
        fieldIndexMap.put(FIELD_REFPARAMDESC, 18);
        fieldIndexMap.put(FIELD_TITLE, 19);
        fieldIndexMap.put(FIELD_TITLEPSLANRESID, 20);
        fieldIndexMap.put(FIELD_TITLEPSLANRESNAME, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_VIEWPARAMS, 26);
        fieldIndexMap.put(FIELD_WIDTH, 27);
    }
}

