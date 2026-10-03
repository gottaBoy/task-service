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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPortletCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysPortletCatBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String FIELD_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPORTLETCATID = "PSSYSPORTLETCATID";
    public static final String FIELD_PSSYSPORTLETCATNAME = "PSSYSPORTLETCATNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
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
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_NAMEPSLANRESID = 4;
    private static final int INDEX_NAMEPSLANRESNAME = 5;
    private static final int INDEX_PSMODULEID = 6;
    private static final int INDEX_PSMODULENAME = 7;
    private static final int INDEX_PSSYSCSSID = 8;
    private static final int INDEX_PSSYSCSSNAME = 9;
    private static final int INDEX_PSSYSIMAGEID = 10;
    private static final int INDEX_PSSYSIMAGENAME = 11;
    private static final int INDEX_PSSYSPORTLETCATID = 12;
    private static final int INDEX_PSSYSPORTLETCATNAME = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_PSSYSTEMNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysPortletCatBase proxyPSSysPortletCatBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namepslanresidDirtyFlag = false;
    private boolean namepslanresnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysportletcatidDirtyFlag = false;
    private boolean pssysportletcatnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="namepslanresid")
    private String namepslanresid;
    @Column(name="namepslanresname")
    private String namepslanresname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssysportletcatid")
    private String pssysportletcatid;
    @Column(name="pssysportletcatname")
    private String pssysportletcatname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
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
    private Integer objNamePSLanResLock = new Integer(1);
    private PSLanguageRes namepslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setNamePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanresid = string;
        this.namepslanresidDirtyFlag = true;
    }

    public String getNamePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanResId();
        }
        return this.namepslanresid;
    }

    public boolean isNamePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanResIdDirty();
        }
        return this.namepslanresidDirtyFlag;
    }

    public void resetNamePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanResId();
            return;
        }
        this.namepslanresidDirtyFlag = false;
        this.namepslanresid = null;
    }

    public void setNamePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanresname = string;
        this.namepslanresnameDirtyFlag = true;
    }

    public String getNamePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanResName();
        }
        return this.namepslanresname;
    }

    public boolean isNamePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanResNameDirty();
        }
        return this.namepslanresnameDirtyFlag;
    }

    public void resetNamePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanResName();
            return;
        }
        this.namepslanresnameDirtyFlag = false;
        this.namepslanresname = null;
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

    public void setPSSysPortletCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletcatid = string;
        this.pssysportletcatidDirtyFlag = true;
    }

    public String getPSSysPortletCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletCatId();
        }
        return this.pssysportletcatid;
    }

    public boolean isPSSysPortletCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletCatIdDirty();
        }
        return this.pssysportletcatidDirtyFlag;
    }

    public void resetPSSysPortletCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletCatId();
            return;
        }
        this.pssysportletcatidDirtyFlag = false;
        this.pssysportletcatid = null;
    }

    public void setPSSysPortletCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletcatname = string;
        this.pssysportletcatnameDirtyFlag = true;
    }

    public String getPSSysPortletCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletCatName();
        }
        return this.pssysportletcatname;
    }

    public boolean isPSSysPortletCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletCatNameDirty();
        }
        return this.pssysportletcatnameDirtyFlag;
    }

    public void resetPSSysPortletCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletCatName();
            return;
        }
        this.pssysportletcatnameDirtyFlag = false;
        this.pssysportletcatname = null;
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
        PSSysPortletCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysPortletCatBase pSSysPortletCatBase) {
        pSSysPortletCatBase.resetCodeName();
        pSSysPortletCatBase.resetCreateDate();
        pSSysPortletCatBase.resetCreateMan();
        pSSysPortletCatBase.resetMemo();
        pSSysPortletCatBase.resetNamePSLanResId();
        pSSysPortletCatBase.resetNamePSLanResName();
        pSSysPortletCatBase.resetPSModuleId();
        pSSysPortletCatBase.resetPSModuleName();
        pSSysPortletCatBase.resetPSSysCssId();
        pSSysPortletCatBase.resetPSSysCssName();
        pSSysPortletCatBase.resetPSSysImageId();
        pSSysPortletCatBase.resetPSSysImageName();
        pSSysPortletCatBase.resetPSSysPortletCatId();
        pSSysPortletCatBase.resetPSSysPortletCatName();
        pSSysPortletCatBase.resetPSSystemId();
        pSSysPortletCatBase.resetPSSystemName();
        pSSysPortletCatBase.resetUpdateDate();
        pSSysPortletCatBase.resetUpdateMan();
        pSSysPortletCatBase.resetUserCat();
        pSSysPortletCatBase.resetUserTag();
        pSSysPortletCatBase.resetUserTag2();
        pSSysPortletCatBase.resetUserTag3();
        pSSysPortletCatBase.resetUserTag4();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNamePSLanResIdDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESID, this.getNamePSLanResId());
        }
        if (!bl || this.isNamePSLanResNameDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESNAME, this.getNamePSLanResName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
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
        if (!bl || this.isPSSysPortletCatIdDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETCATID, this.getPSSysPortletCatId());
        }
        if (!bl || this.isPSSysPortletCatNameDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETCATNAME, this.getPSSysPortletCatName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysPortletCatBase.get(this, n);
    }

    private static Object get(PSSysPortletCatBase pSSysPortletCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPortletCatBase.getCodeName();
            }
            case 1: {
                return pSSysPortletCatBase.getCreateDate();
            }
            case 2: {
                return pSSysPortletCatBase.getCreateMan();
            }
            case 3: {
                return pSSysPortletCatBase.getMemo();
            }
            case 4: {
                return pSSysPortletCatBase.getNamePSLanResId();
            }
            case 5: {
                return pSSysPortletCatBase.getNamePSLanResName();
            }
            case 6: {
                return pSSysPortletCatBase.getPSModuleId();
            }
            case 7: {
                return pSSysPortletCatBase.getPSModuleName();
            }
            case 8: {
                return pSSysPortletCatBase.getPSSysCssId();
            }
            case 9: {
                return pSSysPortletCatBase.getPSSysCssName();
            }
            case 10: {
                return pSSysPortletCatBase.getPSSysImageId();
            }
            case 11: {
                return pSSysPortletCatBase.getPSSysImageName();
            }
            case 12: {
                return pSSysPortletCatBase.getPSSysPortletCatId();
            }
            case 13: {
                return pSSysPortletCatBase.getPSSysPortletCatName();
            }
            case 14: {
                return pSSysPortletCatBase.getPSSystemId();
            }
            case 15: {
                return pSSysPortletCatBase.getPSSystemName();
            }
            case 16: {
                return pSSysPortletCatBase.getUpdateDate();
            }
            case 17: {
                return pSSysPortletCatBase.getUpdateMan();
            }
            case 18: {
                return pSSysPortletCatBase.getUserCat();
            }
            case 19: {
                return pSSysPortletCatBase.getUserTag();
            }
            case 20: {
                return pSSysPortletCatBase.getUserTag2();
            }
            case 21: {
                return pSSysPortletCatBase.getUserTag3();
            }
            case 22: {
                return pSSysPortletCatBase.getUserTag4();
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
        PSSysPortletCatBase.set(this, n, object);
    }

    private static void set(PSSysPortletCatBase pSSysPortletCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysPortletCatBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysPortletCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysPortletCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysPortletCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysPortletCatBase.setNamePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysPortletCatBase.setNamePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysPortletCatBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysPortletCatBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysPortletCatBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysPortletCatBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysPortletCatBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysPortletCatBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysPortletCatBase.setPSSysPortletCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysPortletCatBase.setPSSysPortletCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysPortletCatBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysPortletCatBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysPortletCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysPortletCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysPortletCatBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysPortletCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysPortletCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysPortletCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysPortletCatBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysPortletCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSysPortletCatBase pSSysPortletCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPortletCatBase.getCodeName() == null;
            }
            case 1: {
                return pSSysPortletCatBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysPortletCatBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysPortletCatBase.getMemo() == null;
            }
            case 4: {
                return pSSysPortletCatBase.getNamePSLanResId() == null;
            }
            case 5: {
                return pSSysPortletCatBase.getNamePSLanResName() == null;
            }
            case 6: {
                return pSSysPortletCatBase.getPSModuleId() == null;
            }
            case 7: {
                return pSSysPortletCatBase.getPSModuleName() == null;
            }
            case 8: {
                return pSSysPortletCatBase.getPSSysCssId() == null;
            }
            case 9: {
                return pSSysPortletCatBase.getPSSysCssName() == null;
            }
            case 10: {
                return pSSysPortletCatBase.getPSSysImageId() == null;
            }
            case 11: {
                return pSSysPortletCatBase.getPSSysImageName() == null;
            }
            case 12: {
                return pSSysPortletCatBase.getPSSysPortletCatId() == null;
            }
            case 13: {
                return pSSysPortletCatBase.getPSSysPortletCatName() == null;
            }
            case 14: {
                return pSSysPortletCatBase.getPSSystemId() == null;
            }
            case 15: {
                return pSSysPortletCatBase.getPSSystemName() == null;
            }
            case 16: {
                return pSSysPortletCatBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysPortletCatBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysPortletCatBase.getUserCat() == null;
            }
            case 19: {
                return pSSysPortletCatBase.getUserTag() == null;
            }
            case 20: {
                return pSSysPortletCatBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysPortletCatBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysPortletCatBase.getUserTag4() == null;
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
        return PSSysPortletCatBase.contains(this, n);
    }

    private static boolean contains(PSSysPortletCatBase pSSysPortletCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPortletCatBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysPortletCatBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysPortletCatBase.isCreateManDirty();
            }
            case 3: {
                return pSSysPortletCatBase.isMemoDirty();
            }
            case 4: {
                return pSSysPortletCatBase.isNamePSLanResIdDirty();
            }
            case 5: {
                return pSSysPortletCatBase.isNamePSLanResNameDirty();
            }
            case 6: {
                return pSSysPortletCatBase.isPSModuleIdDirty();
            }
            case 7: {
                return pSSysPortletCatBase.isPSModuleNameDirty();
            }
            case 8: {
                return pSSysPortletCatBase.isPSSysCssIdDirty();
            }
            case 9: {
                return pSSysPortletCatBase.isPSSysCssNameDirty();
            }
            case 10: {
                return pSSysPortletCatBase.isPSSysImageIdDirty();
            }
            case 11: {
                return pSSysPortletCatBase.isPSSysImageNameDirty();
            }
            case 12: {
                return pSSysPortletCatBase.isPSSysPortletCatIdDirty();
            }
            case 13: {
                return pSSysPortletCatBase.isPSSysPortletCatNameDirty();
            }
            case 14: {
                return pSSysPortletCatBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSSysPortletCatBase.isPSSystemNameDirty();
            }
            case 16: {
                return pSSysPortletCatBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysPortletCatBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysPortletCatBase.isUserCatDirty();
            }
            case 19: {
                return pSSysPortletCatBase.isUserTagDirty();
            }
            case 20: {
                return pSSysPortletCatBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysPortletCatBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysPortletCatBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysPortletCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysPortletCatBase pSSysPortletCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysPortletCatBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getNamePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresid", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getNamePSLanResId()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getNamePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresname", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getNamePSLanResName()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSSysPortletCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletcatid", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSSysPortletCatId()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSSysPortletCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletcatname", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSSysPortletCatName()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysPortletCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysPortletCatBase.getJSONValue((Object)pSSysPortletCatBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysPortletCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysPortletCatBase pSSysPortletCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysPortletCatBase.getCodeName() != null) {
            object = pSSysPortletCatBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getCreateDate() != null) {
            object = pSSysPortletCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPortletCatBase.getCreateMan() != null) {
            object = pSSysPortletCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getMemo() != null) {
            object = pSSysPortletCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getNamePSLanResId() != null) {
            object = pSSysPortletCatBase.getNamePSLanResId();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getNamePSLanResName() != null) {
            object = pSSysPortletCatBase.getNamePSLanResName();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSModuleId() != null) {
            object = pSSysPortletCatBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSModuleName() != null) {
            object = pSSysPortletCatBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSSysCssId() != null) {
            object = pSSysPortletCatBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSSysCssName() != null) {
            object = pSSysPortletCatBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSSysImageId() != null) {
            object = pSSysPortletCatBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSSysImageName() != null) {
            object = pSSysPortletCatBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSSysPortletCatId() != null) {
            object = pSSysPortletCatBase.getPSSysPortletCatId();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSSysPortletCatName() != null) {
            object = pSSysPortletCatBase.getPSSysPortletCatName();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSSystemId() != null) {
            object = pSSysPortletCatBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getPSSystemName() != null) {
            object = pSSysPortletCatBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getUpdateDate() != null) {
            object = pSSysPortletCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPortletCatBase.getUpdateMan() != null) {
            object = pSSysPortletCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getUserCat() != null) {
            object = pSSysPortletCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getUserTag() != null) {
            object = pSSysPortletCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getUserTag2() != null) {
            object = pSSysPortletCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getUserTag3() != null) {
            object = pSSysPortletCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysPortletCatBase.getUserTag4() != null) {
            object = pSSysPortletCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysPortletCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysPortletCatBase pSSysPortletCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysPortletCatBase.isCodeNameDirty() && (bl || pSSysPortletCatBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysPortletCatBase.getCodeName());
        }
        if (pSSysPortletCatBase.isCreateDateDirty() && (bl || pSSysPortletCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysPortletCatBase.getCreateDate());
        }
        if (pSSysPortletCatBase.isCreateManDirty() && (bl || pSSysPortletCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysPortletCatBase.getCreateMan());
        }
        if (pSSysPortletCatBase.isMemoDirty() && (bl || pSSysPortletCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysPortletCatBase.getMemo());
        }
        if (pSSysPortletCatBase.isNamePSLanResIdDirty() && (bl || pSSysPortletCatBase.getNamePSLanResId() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESID, (Object)pSSysPortletCatBase.getNamePSLanResId());
        }
        if (pSSysPortletCatBase.isNamePSLanResNameDirty() && (bl || pSSysPortletCatBase.getNamePSLanResName() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESNAME, (Object)pSSysPortletCatBase.getNamePSLanResName());
        }
        if (pSSysPortletCatBase.isPSModuleIdDirty() && (bl || pSSysPortletCatBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysPortletCatBase.getPSModuleId());
        }
        if (pSSysPortletCatBase.isPSModuleNameDirty() && (bl || pSSysPortletCatBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysPortletCatBase.getPSModuleName());
        }
        if (pSSysPortletCatBase.isPSSysCssIdDirty() && (bl || pSSysPortletCatBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysPortletCatBase.getPSSysCssId());
        }
        if (pSSysPortletCatBase.isPSSysCssNameDirty() && (bl || pSSysPortletCatBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysPortletCatBase.getPSSysCssName());
        }
        if (pSSysPortletCatBase.isPSSysImageIdDirty() && (bl || pSSysPortletCatBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysPortletCatBase.getPSSysImageId());
        }
        if (pSSysPortletCatBase.isPSSysImageNameDirty() && (bl || pSSysPortletCatBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysPortletCatBase.getPSSysImageName());
        }
        if (pSSysPortletCatBase.isPSSysPortletCatIdDirty() && (bl || pSSysPortletCatBase.getPSSysPortletCatId() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETCATID, (Object)pSSysPortletCatBase.getPSSysPortletCatId());
        }
        if (pSSysPortletCatBase.isPSSysPortletCatNameDirty() && (bl || pSSysPortletCatBase.getPSSysPortletCatName() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETCATNAME, (Object)pSSysPortletCatBase.getPSSysPortletCatName());
        }
        if (pSSysPortletCatBase.isPSSystemIdDirty() && (bl || pSSysPortletCatBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysPortletCatBase.getPSSystemId());
        }
        if (pSSysPortletCatBase.isPSSystemNameDirty() && (bl || pSSysPortletCatBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysPortletCatBase.getPSSystemName());
        }
        if (pSSysPortletCatBase.isUpdateDateDirty() && (bl || pSSysPortletCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysPortletCatBase.getUpdateDate());
        }
        if (pSSysPortletCatBase.isUpdateManDirty() && (bl || pSSysPortletCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysPortletCatBase.getUpdateMan());
        }
        if (pSSysPortletCatBase.isUserCatDirty() && (bl || pSSysPortletCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysPortletCatBase.getUserCat());
        }
        if (pSSysPortletCatBase.isUserTagDirty() && (bl || pSSysPortletCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysPortletCatBase.getUserTag());
        }
        if (pSSysPortletCatBase.isUserTag2Dirty() && (bl || pSSysPortletCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysPortletCatBase.getUserTag2());
        }
        if (pSSysPortletCatBase.isUserTag3Dirty() && (bl || pSSysPortletCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysPortletCatBase.getUserTag3());
        }
        if (pSSysPortletCatBase.isUserTag4Dirty() && (bl || pSSysPortletCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysPortletCatBase.getUserTag4());
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
        return PSSysPortletCatBase.remove(this, n);
    }

    private static boolean remove(PSSysPortletCatBase pSSysPortletCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysPortletCatBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysPortletCatBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysPortletCatBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysPortletCatBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysPortletCatBase.resetNamePSLanResId();
                return true;
            }
            case 5: {
                pSSysPortletCatBase.resetNamePSLanResName();
                return true;
            }
            case 6: {
                pSSysPortletCatBase.resetPSModuleId();
                return true;
            }
            case 7: {
                pSSysPortletCatBase.resetPSModuleName();
                return true;
            }
            case 8: {
                pSSysPortletCatBase.resetPSSysCssId();
                return true;
            }
            case 9: {
                pSSysPortletCatBase.resetPSSysCssName();
                return true;
            }
            case 10: {
                pSSysPortletCatBase.resetPSSysImageId();
                return true;
            }
            case 11: {
                pSSysPortletCatBase.resetPSSysImageName();
                return true;
            }
            case 12: {
                pSSysPortletCatBase.resetPSSysPortletCatId();
                return true;
            }
            case 13: {
                pSSysPortletCatBase.resetPSSysPortletCatName();
                return true;
            }
            case 14: {
                pSSysPortletCatBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSSysPortletCatBase.resetPSSystemName();
                return true;
            }
            case 16: {
                pSSysPortletCatBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysPortletCatBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysPortletCatBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysPortletCatBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysPortletCatBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysPortletCatBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysPortletCatBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getNamePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanRes();
        }
        if (this.getNamePSLanResId() == null) {
            return null;
        }
        Integer n = this.objNamePSLanResLock;
        synchronized (n) {
            if (this.namepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getNamePSLanResId(), (Object)this.namepslanres.getPSLanguageResId()) != 0L) {
                this.namepslanres = null;
            }
            if (this.namepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getNamePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.namepslanres = pSLanguageRes;
            }
            return this.namepslanres;
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

    private PSSysPortletCatBase getProxyEntity() {
        return this.proxyPSSysPortletCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysPortletCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysPortletCatBase) {
            this.proxyPSSysPortletCatBase = (PSSysPortletCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_NAMEPSLANRESID, 4);
        fieldIndexMap.put(FIELD_NAMEPSLANRESNAME, 5);
        fieldIndexMap.put(FIELD_PSMODULEID, 6);
        fieldIndexMap.put(FIELD_PSMODULENAME, 7);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 8);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 10);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSPORTLETCATID, 12);
        fieldIndexMap.put(FIELD_PSSYSPORTLETCATNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

