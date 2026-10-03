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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysModelRepo;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelRepoService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelRepo;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelRepoService;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelGroupBase.class);
    public static final String FIELD_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAMEMODE = "CODENAMEMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DTOFORMAT = "DTOFORMAT";
    public static final String FIELD_DYNAINSTMODE = "DYNAINSTMODE";
    public static final String FIELD_DYNAINSTTAG = "DYNAINSTTAG";
    public static final String FIELD_DYNAINSTTAG2 = "DYNAINSTTAG2";
    public static final String FIELD_ENABLEPQL = "ENABLEPQL";
    public static final String FIELD_GROUPPARAMS = "GROUPPARAMS";
    public static final String FIELD_GROUPTAG = "GROUPTAG";
    public static final String FIELD_GROUPTAG2 = "GROUPTAG2";
    public static final String FIELD_GROUPTAG3 = "GROUPTAG3";
    public static final String FIELD_GROUPTAG4 = "GROUPTAG4";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PFRTOBJECTREPO = "PFRTOBJECTREPO";
    public static final String FIELD_PKGCODENAME = "PKGCODENAME";
    public static final String FIELD_PSDCSYSMODELREPOID = "PSDCSYSMODELREPOID";
    public static final String FIELD_PSDCSYSMODELREPONAME = "PSDCSYSMODELREPONAME";
    public static final String FIELD_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String FIELD_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String FIELD_PSSYSMODELREPOID = "PSSYSMODELREPOID";
    public static final String FIELD_PSSYSMODELREPONAME = "PSSYSMODELREPONAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RUNTIMETYPE = "RUNTIMETYPE";
    public static final String FIELD_SFRTOBJECTREPO = "SFRTOBJECTREPO";
    public static final String FIELD_SYNCMODE = "SYNCMODE";
    public static final String FIELD_SYSMODELFROM = "SYSMODELFROM";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CLSPKGPARAMS = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CODENAMEMODE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DTOFORMAT = 5;
    private static final int INDEX_DYNAINSTMODE = 6;
    private static final int INDEX_DYNAINSTTAG = 7;
    private static final int INDEX_DYNAINSTTAG2 = 8;
    private static final int INDEX_ENABLEPQL = 9;
    private static final int INDEX_GROUPPARAMS = 10;
    private static final int INDEX_GROUPTAG = 11;
    private static final int INDEX_GROUPTAG2 = 12;
    private static final int INDEX_GROUPTAG3 = 13;
    private static final int INDEX_GROUPTAG4 = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_PFRTOBJECTREPO = 16;
    private static final int INDEX_PKGCODENAME = 17;
    private static final int INDEX_PSDCSYSMODELREPOID = 18;
    private static final int INDEX_PSDCSYSMODELREPONAME = 19;
    private static final int INDEX_PSSYSMODELGROUPID = 20;
    private static final int INDEX_PSSYSMODELGROUPNAME = 21;
    private static final int INDEX_PSSYSMODELREPOID = 22;
    private static final int INDEX_PSSYSMODELREPONAME = 23;
    private static final int INDEX_PSSYSTEMID = 24;
    private static final int INDEX_PSSYSTEMNAME = 25;
    private static final int INDEX_RUNTIMETYPE = 26;
    private static final int INDEX_SFRTOBJECTREPO = 27;
    private static final int INDEX_SYNCMODE = 28;
    private static final int INDEX_SYSMODELFROM = 29;
    private static final int INDEX_UPDATEDATE = 30;
    private static final int INDEX_UPDATEMAN = 31;
    private static final int INDEX_USERCAT = 32;
    private static final int INDEX_USERTAG = 33;
    private static final int INDEX_USERTAG2 = 34;
    private static final int INDEX_USERTAG3 = 35;
    private static final int INDEX_USERTAG4 = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelGroupBase proxyPSSysModelGroupBase = null;
    private boolean clspkgparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codenamemodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dtoformatDirtyFlag = false;
    private boolean dynainstmodeDirtyFlag = false;
    private boolean dynainsttagDirtyFlag = false;
    private boolean dynainsttag2DirtyFlag = false;
    private boolean enablepqlDirtyFlag = false;
    private boolean groupparamsDirtyFlag = false;
    private boolean grouptagDirtyFlag = false;
    private boolean grouptag2DirtyFlag = false;
    private boolean grouptag3DirtyFlag = false;
    private boolean grouptag4DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pfrtobjectrepoDirtyFlag = false;
    private boolean pkgcodenameDirtyFlag = false;
    private boolean psdcsysmodelrepoidDirtyFlag = false;
    private boolean psdcsysmodelreponameDirtyFlag = false;
    private boolean pssysmodelgroupidDirtyFlag = false;
    private boolean pssysmodelgroupnameDirtyFlag = false;
    private boolean pssysmodelrepoidDirtyFlag = false;
    private boolean pssysmodelreponameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean runtimetypeDirtyFlag = false;
    private boolean sfrtobjectrepoDirtyFlag = false;
    private boolean syncmodeDirtyFlag = false;
    private boolean sysmodelfromDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="clspkgparams")
    private String clspkgparams;
    @Column(name="codename")
    private String codename;
    @Column(name="codenamemode")
    private String codenamemode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dtoformat")
    private String dtoformat;
    @Column(name="dynainstmode")
    private Integer dynainstmode;
    @Column(name="dynainsttag")
    private String dynainsttag;
    @Column(name="dynainsttag2")
    private String dynainsttag2;
    @Column(name="enablepql")
    private Integer enablepql;
    @Column(name="groupparams")
    private String groupparams;
    @Column(name="grouptag")
    private String grouptag;
    @Column(name="grouptag2")
    private String grouptag2;
    @Column(name="grouptag3")
    private String grouptag3;
    @Column(name="grouptag4")
    private String grouptag4;
    @Column(name="memo")
    private String memo;
    @Column(name="pfrtobjectrepo")
    private String pfrtobjectrepo;
    @Column(name="pkgcodename")
    private String pkgcodename;
    @Column(name="psdcsysmodelrepoid")
    private String psdcsysmodelrepoid;
    @Column(name="psdcsysmodelreponame")
    private String psdcsysmodelreponame;
    @Column(name="pssysmodelgroupid")
    private String pssysmodelgroupid;
    @Column(name="pssysmodelgroupname")
    private String pssysmodelgroupname;
    @Column(name="pssysmodelrepoid")
    private String pssysmodelrepoid;
    @Column(name="pssysmodelreponame")
    private String pssysmodelreponame;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="runtimetype")
    private String runtimetype;
    @Column(name="sfrtobjectrepo")
    private String sfrtobjectrepo;
    @Column(name="syncmode")
    private String syncmode;
    @Column(name="sysmodelfrom")
    private String sysmodelfrom;
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
    private Integer objPSDCSysModelRepoLock = new Integer(1);
    private PSDCSysModelRepo psdcsysmodelrepo = null;
    private Integer objPSSysModelRepoLock = new Integer(1);
    private PSSysModelRepo pssysmodelrepo = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSModulesLock = new Integer(1);
    private ArrayList<PSModule> psmodules = null;
    private Integer objPSSysBDSchemesLock = new Integer(1);
    private ArrayList<PSSysBDScheme> pssysbdschemes = null;
    private Integer objPSSysDBSchemesLock = new Integer(1);
    private ArrayList<PSSysDBScheme> pssysdbschemes = null;
    private Integer objPSSysSearchSchemesLock = new Integer(1);
    private ArrayList<PSSysSearchScheme> pssyssearchschemes = null;
    private Integer objPSSysUtilDEsLock = new Integer(1);
    private ArrayList<PSSysUtilDE> pssysutildes = null;

    public void setClsPkgParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPkgParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspkgparams = string;
        this.clspkgparamsDirtyFlag = true;
    }

    public String getClsPkgParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPkgParams();
        }
        return this.clspkgparams;
    }

    public boolean isClsPkgParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPkgParamsDirty();
        }
        return this.clspkgparamsDirtyFlag;
    }

    public void resetClsPkgParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPkgParams();
            return;
        }
        this.clspkgparamsDirtyFlag = false;
        this.clspkgparams = null;
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

    public void setCodeNameMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeNameMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codenamemode = string;
        this.codenamemodeDirtyFlag = true;
    }

    public String getCodeNameMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeNameMode();
        }
        return this.codenamemode;
    }

    public boolean isCodeNameModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameModeDirty();
        }
        return this.codenamemodeDirtyFlag;
    }

    public void resetCodeNameMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeNameMode();
            return;
        }
        this.codenamemodeDirtyFlag = false;
        this.codenamemode = null;
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

    public void setDTOFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDTOFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dtoformat = string;
        this.dtoformatDirtyFlag = true;
    }

    public String getDTOFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDTOFormat();
        }
        return this.dtoformat;
    }

    public boolean isDTOFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDTOFormatDirty();
        }
        return this.dtoformatDirtyFlag;
    }

    public void resetDTOFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDTOFormat();
            return;
        }
        this.dtoformatDirtyFlag = false;
        this.dtoformat = null;
    }

    public void setDynaInstMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstMode(n);
            return;
        }
        this.dynainstmode = n;
        this.dynainstmodeDirtyFlag = true;
    }

    public Integer getDynaInstMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstMode();
        }
        return this.dynainstmode;
    }

    public boolean isDynaInstModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstModeDirty();
        }
        return this.dynainstmodeDirtyFlag;
    }

    public void resetDynaInstMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstMode();
            return;
        }
        this.dynainstmodeDirtyFlag = false;
        this.dynainstmode = null;
    }

    public void setDynaInstTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynainsttag = string;
        this.dynainsttagDirtyFlag = true;
    }

    public String getDynaInstTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstTag();
        }
        return this.dynainsttag;
    }

    public boolean isDynaInstTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstTagDirty();
        }
        return this.dynainsttagDirtyFlag;
    }

    public void resetDynaInstTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstTag();
            return;
        }
        this.dynainsttagDirtyFlag = false;
        this.dynainsttag = null;
    }

    public void setDynaInstTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynainsttag2 = string;
        this.dynainsttag2DirtyFlag = true;
    }

    public String getDynaInstTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstTag2();
        }
        return this.dynainsttag2;
    }

    public boolean isDynaInstTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstTag2Dirty();
        }
        return this.dynainsttag2DirtyFlag;
    }

    public void resetDynaInstTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstTag2();
            return;
        }
        this.dynainsttag2DirtyFlag = false;
        this.dynainsttag2 = null;
    }

    public void setEnablePQL(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePQL(n);
            return;
        }
        this.enablepql = n;
        this.enablepqlDirtyFlag = true;
    }

    public Integer getEnablePQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePQL();
        }
        return this.enablepql;
    }

    public boolean isEnablePQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePQLDirty();
        }
        return this.enablepqlDirtyFlag;
    }

    public void resetEnablePQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePQL();
            return;
        }
        this.enablepqlDirtyFlag = false;
        this.enablepql = null;
    }

    public void setGroupParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupparams = string;
        this.groupparamsDirtyFlag = true;
    }

    public String getGroupParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupParams();
        }
        return this.groupparams;
    }

    public boolean isGroupParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupParamsDirty();
        }
        return this.groupparamsDirtyFlag;
    }

    public void resetGroupParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupParams();
            return;
        }
        this.groupparamsDirtyFlag = false;
        this.groupparams = null;
    }

    public void setGroupTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag = string;
        this.grouptagDirtyFlag = true;
    }

    public String getGroupTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag();
        }
        return this.grouptag;
    }

    public boolean isGroupTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTagDirty();
        }
        return this.grouptagDirtyFlag;
    }

    public void resetGroupTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag();
            return;
        }
        this.grouptagDirtyFlag = false;
        this.grouptag = null;
    }

    public void setGroupTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag2 = string;
        this.grouptag2DirtyFlag = true;
    }

    public String getGroupTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag2();
        }
        return this.grouptag2;
    }

    public boolean isGroupTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTag2Dirty();
        }
        return this.grouptag2DirtyFlag;
    }

    public void resetGroupTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag2();
            return;
        }
        this.grouptag2DirtyFlag = false;
        this.grouptag2 = null;
    }

    public void setGroupTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag3 = string;
        this.grouptag3DirtyFlag = true;
    }

    public String getGroupTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag3();
        }
        return this.grouptag3;
    }

    public boolean isGroupTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTag3Dirty();
        }
        return this.grouptag3DirtyFlag;
    }

    public void resetGroupTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag3();
            return;
        }
        this.grouptag3DirtyFlag = false;
        this.grouptag3 = null;
    }

    public void setGroupTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag4 = string;
        this.grouptag4DirtyFlag = true;
    }

    public String getGroupTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag4();
        }
        return this.grouptag4;
    }

    public boolean isGroupTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTag4Dirty();
        }
        return this.grouptag4DirtyFlag;
    }

    public void resetGroupTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag4();
            return;
        }
        this.grouptag4DirtyFlag = false;
        this.grouptag4 = null;
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

    public void setPFRTObjectRepo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPFRTObjectRepo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pfrtobjectrepo = string;
        this.pfrtobjectrepoDirtyFlag = true;
    }

    public String getPFRTObjectRepo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPFRTObjectRepo();
        }
        return this.pfrtobjectrepo;
    }

    public boolean isPFRTObjectRepoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPFRTObjectRepoDirty();
        }
        return this.pfrtobjectrepoDirtyFlag;
    }

    public void resetPFRTObjectRepo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPFRTObjectRepo();
            return;
        }
        this.pfrtobjectrepoDirtyFlag = false;
        this.pfrtobjectrepo = null;
    }

    public void setPKGCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKGCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgcodename = string;
        this.pkgcodenameDirtyFlag = true;
    }

    public String getPKGCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKGCodeName();
        }
        return this.pkgcodename;
    }

    public boolean isPKGCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKGCodeNameDirty();
        }
        return this.pkgcodenameDirtyFlag;
    }

    public void resetPKGCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKGCodeName();
            return;
        }
        this.pkgcodenameDirtyFlag = false;
        this.pkgcodename = null;
    }

    public void setPSDCSysModelRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysModelRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysmodelrepoid = string;
        this.psdcsysmodelrepoidDirtyFlag = true;
    }

    public String getPSDCSysModelRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysModelRepoId();
        }
        return this.psdcsysmodelrepoid;
    }

    public boolean isPSDCSysModelRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysModelRepoIdDirty();
        }
        return this.psdcsysmodelrepoidDirtyFlag;
    }

    public void resetPSDCSysModelRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysModelRepoId();
            return;
        }
        this.psdcsysmodelrepoidDirtyFlag = false;
        this.psdcsysmodelrepoid = null;
    }

    public void setPSDCSysModelRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysModelRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysmodelreponame = string;
        this.psdcsysmodelreponameDirtyFlag = true;
    }

    public String getPSDCSysModelRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysModelRepoName();
        }
        return this.psdcsysmodelreponame;
    }

    public boolean isPSDCSysModelRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysModelRepoNameDirty();
        }
        return this.psdcsysmodelreponameDirtyFlag;
    }

    public void resetPSDCSysModelRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysModelRepoName();
            return;
        }
        this.psdcsysmodelreponameDirtyFlag = false;
        this.psdcsysmodelreponame = null;
    }

    public void setPSSysModelGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupid = string;
        this.pssysmodelgroupidDirtyFlag = true;
    }

    public String getPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupId();
        }
        return this.pssysmodelgroupid;
    }

    public boolean isPSSysModelGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupIdDirty();
        }
        return this.pssysmodelgroupidDirtyFlag;
    }

    public void resetPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupId();
            return;
        }
        this.pssysmodelgroupidDirtyFlag = false;
        this.pssysmodelgroupid = null;
    }

    public void setPSSysModelGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupname = string;
        this.pssysmodelgroupnameDirtyFlag = true;
    }

    public String getPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupName();
        }
        return this.pssysmodelgroupname;
    }

    public boolean isPSSysModelGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupNameDirty();
        }
        return this.pssysmodelgroupnameDirtyFlag;
    }

    public void resetPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupName();
            return;
        }
        this.pssysmodelgroupnameDirtyFlag = false;
        this.pssysmodelgroupname = null;
    }

    public void setPSSysModelRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelrepoid = string;
        this.pssysmodelrepoidDirtyFlag = true;
    }

    public String getPSSysModelRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelRepoId();
        }
        return this.pssysmodelrepoid;
    }

    public boolean isPSSysModelRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelRepoIdDirty();
        }
        return this.pssysmodelrepoidDirtyFlag;
    }

    public void resetPSSysModelRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelRepoId();
            return;
        }
        this.pssysmodelrepoidDirtyFlag = false;
        this.pssysmodelrepoid = null;
    }

    public void setPSSysModelRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelreponame = string;
        this.pssysmodelreponameDirtyFlag = true;
    }

    public String getPSSysModelRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelRepoName();
        }
        return this.pssysmodelreponame;
    }

    public boolean isPSSysModelRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelRepoNameDirty();
        }
        return this.pssysmodelreponameDirtyFlag;
    }

    public void resetPSSysModelRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelRepoName();
            return;
        }
        this.pssysmodelreponameDirtyFlag = false;
        this.pssysmodelreponame = null;
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

    public void setRuntimeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuntimeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runtimetype = string;
        this.runtimetypeDirtyFlag = true;
    }

    public String getRuntimeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuntimeType();
        }
        return this.runtimetype;
    }

    public boolean isRuntimeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuntimeTypeDirty();
        }
        return this.runtimetypeDirtyFlag;
    }

    public void resetRuntimeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuntimeType();
            return;
        }
        this.runtimetypeDirtyFlag = false;
        this.runtimetype = null;
    }

    public void setSFRTObjectRepo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFRTObjectRepo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sfrtobjectrepo = string;
        this.sfrtobjectrepoDirtyFlag = true;
    }

    public String getSFRTObjectRepo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFRTObjectRepo();
        }
        return this.sfrtobjectrepo;
    }

    public boolean isSFRTObjectRepoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFRTObjectRepoDirty();
        }
        return this.sfrtobjectrepoDirtyFlag;
    }

    public void resetSFRTObjectRepo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFRTObjectRepo();
            return;
        }
        this.sfrtobjectrepoDirtyFlag = false;
        this.sfrtobjectrepo = null;
    }

    public void setSyncMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncmode = string;
        this.syncmodeDirtyFlag = true;
    }

    public String getSyncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncMode();
        }
        return this.syncmode;
    }

    public boolean isSyncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncModeDirty();
        }
        return this.syncmodeDirtyFlag;
    }

    public void resetSyncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncMode();
            return;
        }
        this.syncmodeDirtyFlag = false;
        this.syncmode = null;
    }

    public void setSysModelFrom(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysModelFrom(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysmodelfrom = string;
        this.sysmodelfromDirtyFlag = true;
    }

    public String getSysModelFrom() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysModelFrom();
        }
        return this.sysmodelfrom;
    }

    public boolean isSysModelFromDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysModelFromDirty();
        }
        return this.sysmodelfromDirtyFlag;
    }

    public void resetSysModelFrom() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysModelFrom();
            return;
        }
        this.sysmodelfromDirtyFlag = false;
        this.sysmodelfrom = null;
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
        PSSysModelGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelGroupBase pSSysModelGroupBase) {
        pSSysModelGroupBase.resetClsPkgParams();
        pSSysModelGroupBase.resetCodeName();
        pSSysModelGroupBase.resetCodeNameMode();
        pSSysModelGroupBase.resetCreateDate();
        pSSysModelGroupBase.resetCreateMan();
        pSSysModelGroupBase.resetDTOFormat();
        pSSysModelGroupBase.resetDynaInstMode();
        pSSysModelGroupBase.resetDynaInstTag();
        pSSysModelGroupBase.resetDynaInstTag2();
        pSSysModelGroupBase.resetEnablePQL();
        pSSysModelGroupBase.resetGroupParams();
        pSSysModelGroupBase.resetGroupTag();
        pSSysModelGroupBase.resetGroupTag2();
        pSSysModelGroupBase.resetGroupTag3();
        pSSysModelGroupBase.resetGroupTag4();
        pSSysModelGroupBase.resetMemo();
        pSSysModelGroupBase.resetPFRTObjectRepo();
        pSSysModelGroupBase.resetPKGCodeName();
        pSSysModelGroupBase.resetPSDCSysModelRepoId();
        pSSysModelGroupBase.resetPSDCSysModelRepoName();
        pSSysModelGroupBase.resetPSSysModelGroupId();
        pSSysModelGroupBase.resetPSSysModelGroupName();
        pSSysModelGroupBase.resetPSSysModelRepoId();
        pSSysModelGroupBase.resetPSSysModelRepoName();
        pSSysModelGroupBase.resetPSSystemId();
        pSSysModelGroupBase.resetPSSystemName();
        pSSysModelGroupBase.resetRuntimeType();
        pSSysModelGroupBase.resetSFRTObjectRepo();
        pSSysModelGroupBase.resetSyncMode();
        pSSysModelGroupBase.resetSysModelFrom();
        pSSysModelGroupBase.resetUpdateDate();
        pSSysModelGroupBase.resetUpdateMan();
        pSSysModelGroupBase.resetUserCat();
        pSSysModelGroupBase.resetUserTag();
        pSSysModelGroupBase.resetUserTag2();
        pSSysModelGroupBase.resetUserTag3();
        pSSysModelGroupBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClsPkgParamsDirty()) {
            hashMap.put(FIELD_CLSPKGPARAMS, this.getClsPkgParams());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeNameModeDirty()) {
            hashMap.put(FIELD_CODENAMEMODE, this.getCodeNameMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDTOFormatDirty()) {
            hashMap.put(FIELD_DTOFORMAT, this.getDTOFormat());
        }
        if (!bl || this.isDynaInstModeDirty()) {
            hashMap.put(FIELD_DYNAINSTMODE, this.getDynaInstMode());
        }
        if (!bl || this.isDynaInstTagDirty()) {
            hashMap.put(FIELD_DYNAINSTTAG, this.getDynaInstTag());
        }
        if (!bl || this.isDynaInstTag2Dirty()) {
            hashMap.put(FIELD_DYNAINSTTAG2, this.getDynaInstTag2());
        }
        if (!bl || this.isEnablePQLDirty()) {
            hashMap.put(FIELD_ENABLEPQL, this.getEnablePQL());
        }
        if (!bl || this.isGroupParamsDirty()) {
            hashMap.put(FIELD_GROUPPARAMS, this.getGroupParams());
        }
        if (!bl || this.isGroupTagDirty()) {
            hashMap.put(FIELD_GROUPTAG, this.getGroupTag());
        }
        if (!bl || this.isGroupTag2Dirty()) {
            hashMap.put(FIELD_GROUPTAG2, this.getGroupTag2());
        }
        if (!bl || this.isGroupTag3Dirty()) {
            hashMap.put(FIELD_GROUPTAG3, this.getGroupTag3());
        }
        if (!bl || this.isGroupTag4Dirty()) {
            hashMap.put(FIELD_GROUPTAG4, this.getGroupTag4());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPFRTObjectRepoDirty()) {
            hashMap.put(FIELD_PFRTOBJECTREPO, this.getPFRTObjectRepo());
        }
        if (!bl || this.isPKGCodeNameDirty()) {
            hashMap.put(FIELD_PKGCODENAME, this.getPKGCodeName());
        }
        if (!bl || this.isPSDCSysModelRepoIdDirty()) {
            hashMap.put(FIELD_PSDCSYSMODELREPOID, this.getPSDCSysModelRepoId());
        }
        if (!bl || this.isPSDCSysModelRepoNameDirty()) {
            hashMap.put(FIELD_PSDCSYSMODELREPONAME, this.getPSDCSysModelRepoName());
        }
        if (!bl || this.isPSSysModelGroupIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPID, this.getPSSysModelGroupId());
        }
        if (!bl || this.isPSSysModelGroupNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPNAME, this.getPSSysModelGroupName());
        }
        if (!bl || this.isPSSysModelRepoIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELREPOID, this.getPSSysModelRepoId());
        }
        if (!bl || this.isPSSysModelRepoNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELREPONAME, this.getPSSysModelRepoName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isRuntimeTypeDirty()) {
            hashMap.put(FIELD_RUNTIMETYPE, this.getRuntimeType());
        }
        if (!bl || this.isSFRTObjectRepoDirty()) {
            hashMap.put(FIELD_SFRTOBJECTREPO, this.getSFRTObjectRepo());
        }
        if (!bl || this.isSyncModeDirty()) {
            hashMap.put(FIELD_SYNCMODE, this.getSyncMode());
        }
        if (!bl || this.isSysModelFromDirty()) {
            hashMap.put(FIELD_SYSMODELFROM, this.getSysModelFrom());
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
        return PSSysModelGroupBase.get(this, n);
    }

    private static Object get(PSSysModelGroupBase pSSysModelGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelGroupBase.getClsPkgParams();
            }
            case 1: {
                return pSSysModelGroupBase.getCodeName();
            }
            case 2: {
                return pSSysModelGroupBase.getCodeNameMode();
            }
            case 3: {
                return pSSysModelGroupBase.getCreateDate();
            }
            case 4: {
                return pSSysModelGroupBase.getCreateMan();
            }
            case 5: {
                return pSSysModelGroupBase.getDTOFormat();
            }
            case 6: {
                return pSSysModelGroupBase.getDynaInstMode();
            }
            case 7: {
                return pSSysModelGroupBase.getDynaInstTag();
            }
            case 8: {
                return pSSysModelGroupBase.getDynaInstTag2();
            }
            case 9: {
                return pSSysModelGroupBase.getEnablePQL();
            }
            case 10: {
                return pSSysModelGroupBase.getGroupParams();
            }
            case 11: {
                return pSSysModelGroupBase.getGroupTag();
            }
            case 12: {
                return pSSysModelGroupBase.getGroupTag2();
            }
            case 13: {
                return pSSysModelGroupBase.getGroupTag3();
            }
            case 14: {
                return pSSysModelGroupBase.getGroupTag4();
            }
            case 15: {
                return pSSysModelGroupBase.getMemo();
            }
            case 16: {
                return pSSysModelGroupBase.getPFRTObjectRepo();
            }
            case 17: {
                return pSSysModelGroupBase.getPKGCodeName();
            }
            case 18: {
                return pSSysModelGroupBase.getPSDCSysModelRepoId();
            }
            case 19: {
                return pSSysModelGroupBase.getPSDCSysModelRepoName();
            }
            case 20: {
                return pSSysModelGroupBase.getPSSysModelGroupId();
            }
            case 21: {
                return pSSysModelGroupBase.getPSSysModelGroupName();
            }
            case 22: {
                return pSSysModelGroupBase.getPSSysModelRepoId();
            }
            case 23: {
                return pSSysModelGroupBase.getPSSysModelRepoName();
            }
            case 24: {
                return pSSysModelGroupBase.getPSSystemId();
            }
            case 25: {
                return pSSysModelGroupBase.getPSSystemName();
            }
            case 26: {
                return pSSysModelGroupBase.getRuntimeType();
            }
            case 27: {
                return pSSysModelGroupBase.getSFRTObjectRepo();
            }
            case 28: {
                return pSSysModelGroupBase.getSyncMode();
            }
            case 29: {
                return pSSysModelGroupBase.getSysModelFrom();
            }
            case 30: {
                return pSSysModelGroupBase.getUpdateDate();
            }
            case 31: {
                return pSSysModelGroupBase.getUpdateMan();
            }
            case 32: {
                return pSSysModelGroupBase.getUserCat();
            }
            case 33: {
                return pSSysModelGroupBase.getUserTag();
            }
            case 34: {
                return pSSysModelGroupBase.getUserTag2();
            }
            case 35: {
                return pSSysModelGroupBase.getUserTag3();
            }
            case 36: {
                return pSSysModelGroupBase.getUserTag4();
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
        PSSysModelGroupBase.set(this, n, object);
    }

    private static void set(PSSysModelGroupBase pSSysModelGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelGroupBase.setClsPkgParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelGroupBase.setCodeNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelGroupBase.setDTOFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelGroupBase.setDynaInstMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelGroupBase.setDynaInstTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelGroupBase.setDynaInstTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelGroupBase.setEnablePQL(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelGroupBase.setGroupParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelGroupBase.setGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelGroupBase.setGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelGroupBase.setGroupTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelGroupBase.setGroupTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelGroupBase.setPFRTObjectRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelGroupBase.setPKGCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysModelGroupBase.setPSDCSysModelRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysModelGroupBase.setPSDCSysModelRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysModelGroupBase.setPSSysModelGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysModelGroupBase.setPSSysModelGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysModelGroupBase.setPSSysModelRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysModelGroupBase.setPSSysModelRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysModelGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysModelGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysModelGroupBase.setRuntimeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysModelGroupBase.setSFRTObjectRepo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysModelGroupBase.setSyncMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysModelGroupBase.setSysModelFrom(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysModelGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 31: {
                pSSysModelGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysModelGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysModelGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysModelGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysModelGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysModelGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysModelGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelGroupBase pSSysModelGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelGroupBase.getClsPkgParams() == null;
            }
            case 1: {
                return pSSysModelGroupBase.getCodeName() == null;
            }
            case 2: {
                return pSSysModelGroupBase.getCodeNameMode() == null;
            }
            case 3: {
                return pSSysModelGroupBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysModelGroupBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysModelGroupBase.getDTOFormat() == null;
            }
            case 6: {
                return pSSysModelGroupBase.getDynaInstMode() == null;
            }
            case 7: {
                return pSSysModelGroupBase.getDynaInstTag() == null;
            }
            case 8: {
                return pSSysModelGroupBase.getDynaInstTag2() == null;
            }
            case 9: {
                return pSSysModelGroupBase.getEnablePQL() == null;
            }
            case 10: {
                return pSSysModelGroupBase.getGroupParams() == null;
            }
            case 11: {
                return pSSysModelGroupBase.getGroupTag() == null;
            }
            case 12: {
                return pSSysModelGroupBase.getGroupTag2() == null;
            }
            case 13: {
                return pSSysModelGroupBase.getGroupTag3() == null;
            }
            case 14: {
                return pSSysModelGroupBase.getGroupTag4() == null;
            }
            case 15: {
                return pSSysModelGroupBase.getMemo() == null;
            }
            case 16: {
                return pSSysModelGroupBase.getPFRTObjectRepo() == null;
            }
            case 17: {
                return pSSysModelGroupBase.getPKGCodeName() == null;
            }
            case 18: {
                return pSSysModelGroupBase.getPSDCSysModelRepoId() == null;
            }
            case 19: {
                return pSSysModelGroupBase.getPSDCSysModelRepoName() == null;
            }
            case 20: {
                return pSSysModelGroupBase.getPSSysModelGroupId() == null;
            }
            case 21: {
                return pSSysModelGroupBase.getPSSysModelGroupName() == null;
            }
            case 22: {
                return pSSysModelGroupBase.getPSSysModelRepoId() == null;
            }
            case 23: {
                return pSSysModelGroupBase.getPSSysModelRepoName() == null;
            }
            case 24: {
                return pSSysModelGroupBase.getPSSystemId() == null;
            }
            case 25: {
                return pSSysModelGroupBase.getPSSystemName() == null;
            }
            case 26: {
                return pSSysModelGroupBase.getRuntimeType() == null;
            }
            case 27: {
                return pSSysModelGroupBase.getSFRTObjectRepo() == null;
            }
            case 28: {
                return pSSysModelGroupBase.getSyncMode() == null;
            }
            case 29: {
                return pSSysModelGroupBase.getSysModelFrom() == null;
            }
            case 30: {
                return pSSysModelGroupBase.getUpdateDate() == null;
            }
            case 31: {
                return pSSysModelGroupBase.getUpdateMan() == null;
            }
            case 32: {
                return pSSysModelGroupBase.getUserCat() == null;
            }
            case 33: {
                return pSSysModelGroupBase.getUserTag() == null;
            }
            case 34: {
                return pSSysModelGroupBase.getUserTag2() == null;
            }
            case 35: {
                return pSSysModelGroupBase.getUserTag3() == null;
            }
            case 36: {
                return pSSysModelGroupBase.getUserTag4() == null;
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
        return PSSysModelGroupBase.contains(this, n);
    }

    private static boolean contains(PSSysModelGroupBase pSSysModelGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelGroupBase.isClsPkgParamsDirty();
            }
            case 1: {
                return pSSysModelGroupBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysModelGroupBase.isCodeNameModeDirty();
            }
            case 3: {
                return pSSysModelGroupBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysModelGroupBase.isCreateManDirty();
            }
            case 5: {
                return pSSysModelGroupBase.isDTOFormatDirty();
            }
            case 6: {
                return pSSysModelGroupBase.isDynaInstModeDirty();
            }
            case 7: {
                return pSSysModelGroupBase.isDynaInstTagDirty();
            }
            case 8: {
                return pSSysModelGroupBase.isDynaInstTag2Dirty();
            }
            case 9: {
                return pSSysModelGroupBase.isEnablePQLDirty();
            }
            case 10: {
                return pSSysModelGroupBase.isGroupParamsDirty();
            }
            case 11: {
                return pSSysModelGroupBase.isGroupTagDirty();
            }
            case 12: {
                return pSSysModelGroupBase.isGroupTag2Dirty();
            }
            case 13: {
                return pSSysModelGroupBase.isGroupTag3Dirty();
            }
            case 14: {
                return pSSysModelGroupBase.isGroupTag4Dirty();
            }
            case 15: {
                return pSSysModelGroupBase.isMemoDirty();
            }
            case 16: {
                return pSSysModelGroupBase.isPFRTObjectRepoDirty();
            }
            case 17: {
                return pSSysModelGroupBase.isPKGCodeNameDirty();
            }
            case 18: {
                return pSSysModelGroupBase.isPSDCSysModelRepoIdDirty();
            }
            case 19: {
                return pSSysModelGroupBase.isPSDCSysModelRepoNameDirty();
            }
            case 20: {
                return pSSysModelGroupBase.isPSSysModelGroupIdDirty();
            }
            case 21: {
                return pSSysModelGroupBase.isPSSysModelGroupNameDirty();
            }
            case 22: {
                return pSSysModelGroupBase.isPSSysModelRepoIdDirty();
            }
            case 23: {
                return pSSysModelGroupBase.isPSSysModelRepoNameDirty();
            }
            case 24: {
                return pSSysModelGroupBase.isPSSystemIdDirty();
            }
            case 25: {
                return pSSysModelGroupBase.isPSSystemNameDirty();
            }
            case 26: {
                return pSSysModelGroupBase.isRuntimeTypeDirty();
            }
            case 27: {
                return pSSysModelGroupBase.isSFRTObjectRepoDirty();
            }
            case 28: {
                return pSSysModelGroupBase.isSyncModeDirty();
            }
            case 29: {
                return pSSysModelGroupBase.isSysModelFromDirty();
            }
            case 30: {
                return pSSysModelGroupBase.isUpdateDateDirty();
            }
            case 31: {
                return pSSysModelGroupBase.isUpdateManDirty();
            }
            case 32: {
                return pSSysModelGroupBase.isUserCatDirty();
            }
            case 33: {
                return pSSysModelGroupBase.isUserTagDirty();
            }
            case 34: {
                return pSSysModelGroupBase.isUserTag2Dirty();
            }
            case 35: {
                return pSSysModelGroupBase.isUserTag3Dirty();
            }
            case 36: {
                return pSSysModelGroupBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelGroupBase pSSysModelGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelGroupBase.getClsPkgParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspkgparams", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getClsPkgParams()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getCodeNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codenamemode", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getCodeNameMode()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getDTOFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dtoformat", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getDTOFormat()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getDynaInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainstmode", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getDynaInstMode()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getDynaInstTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainsttag", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getDynaInstTag()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getDynaInstTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainsttag2", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getDynaInstTag2()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getEnablePQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepql", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getEnablePQL()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getGroupParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupparams", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getGroupParams()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getGroupTag()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag2", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getGroupTag2()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getGroupTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag3", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getGroupTag3()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getGroupTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag4", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getGroupTag4()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPFRTObjectRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pfrtobjectrepo", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPFRTObjectRepo()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPKGCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgcodename", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPKGCodeName()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPSDCSysModelRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysmodelrepoid", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPSDCSysModelRepoId()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPSDCSysModelRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysmodelreponame", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPSDCSysModelRepoName()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPSSysModelGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupid", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPSSysModelGroupId()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPSSysModelGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupname", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPSSysModelGroupName()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPSSysModelRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelrepoid", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPSSysModelRepoId()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPSSysModelRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelreponame", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPSSysModelRepoName()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getRuntimeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runtimetype", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getRuntimeType()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getSFRTObjectRepo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sfrtobjectrepo", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getSFRTObjectRepo()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getSyncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncmode", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getSyncMode()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getSysModelFrom() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmodelfrom", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getSysModelFrom()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysModelGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysModelGroupBase.getJSONValue((Object)pSSysModelGroupBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelGroupBase pSSysModelGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelGroupBase.getClsPkgParams() != null) {
            object = pSSysModelGroupBase.getClsPkgParams();
            xmlNode.setAttribute(FIELD_CLSPKGPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysModelGroupBase.getCodeName() != null) {
            object = pSSysModelGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysModelGroupBase.getCodeNameMode() != null) {
            object = pSSysModelGroupBase.getCodeNameMode();
            xmlNode.setAttribute(FIELD_CODENAMEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getCreateDate() != null) {
            object = pSSysModelGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelGroupBase.getCreateMan() != null) {
            object = pSSysModelGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getDTOFormat() != null) {
            object = pSSysModelGroupBase.getDTOFormat();
            xmlNode.setAttribute(FIELD_DTOFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getDynaInstMode() != null) {
            object = pSSysModelGroupBase.getDynaInstMode();
            xmlNode.setAttribute(FIELD_DYNAINSTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelGroupBase.getDynaInstTag() != null) {
            object = pSSysModelGroupBase.getDynaInstTag();
            xmlNode.setAttribute(FIELD_DYNAINSTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getDynaInstTag2() != null) {
            object = pSSysModelGroupBase.getDynaInstTag2();
            xmlNode.setAttribute(FIELD_DYNAINSTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getEnablePQL() != null) {
            object = pSSysModelGroupBase.getEnablePQL();
            xmlNode.setAttribute(FIELD_ENABLEPQL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelGroupBase.getGroupParams() != null) {
            object = pSSysModelGroupBase.getGroupParams();
            xmlNode.setAttribute(FIELD_GROUPPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getGroupTag() != null) {
            object = pSSysModelGroupBase.getGroupTag();
            xmlNode.setAttribute(FIELD_GROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getGroupTag2() != null) {
            object = pSSysModelGroupBase.getGroupTag2();
            xmlNode.setAttribute(FIELD_GROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getGroupTag3() != null) {
            object = pSSysModelGroupBase.getGroupTag3();
            xmlNode.setAttribute(FIELD_GROUPTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getGroupTag4() != null) {
            object = pSSysModelGroupBase.getGroupTag4();
            xmlNode.setAttribute(FIELD_GROUPTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getMemo() != null) {
            object = pSSysModelGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPFRTObjectRepo() != null) {
            object = pSSysModelGroupBase.getPFRTObjectRepo();
            xmlNode.setAttribute(FIELD_PFRTOBJECTREPO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPKGCodeName() != null) {
            object = pSSysModelGroupBase.getPKGCodeName();
            xmlNode.setAttribute(FIELD_PKGCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPSDCSysModelRepoId() != null) {
            object = pSSysModelGroupBase.getPSDCSysModelRepoId();
            xmlNode.setAttribute(FIELD_PSDCSYSMODELREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPSDCSysModelRepoName() != null) {
            object = pSSysModelGroupBase.getPSDCSysModelRepoName();
            xmlNode.setAttribute(FIELD_PSDCSYSMODELREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPSSysModelGroupId() != null) {
            object = pSSysModelGroupBase.getPSSysModelGroupId();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPSSysModelGroupName() != null) {
            object = pSSysModelGroupBase.getPSSysModelGroupName();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPSSysModelRepoId() != null) {
            object = pSSysModelGroupBase.getPSSysModelRepoId();
            xmlNode.setAttribute(FIELD_PSSYSMODELREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPSSysModelRepoName() != null) {
            object = pSSysModelGroupBase.getPSSysModelRepoName();
            xmlNode.setAttribute(FIELD_PSSYSMODELREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPSSystemId() != null) {
            object = pSSysModelGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getPSSystemName() != null) {
            object = pSSysModelGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getRuntimeType() != null) {
            object = pSSysModelGroupBase.getRuntimeType();
            xmlNode.setAttribute(FIELD_RUNTIMETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getSFRTObjectRepo() != null) {
            object = pSSysModelGroupBase.getSFRTObjectRepo();
            xmlNode.setAttribute(FIELD_SFRTOBJECTREPO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getSyncMode() != null) {
            object = pSSysModelGroupBase.getSyncMode();
            xmlNode.setAttribute(FIELD_SYNCMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getSysModelFrom() != null) {
            object = pSSysModelGroupBase.getSysModelFrom();
            xmlNode.setAttribute(FIELD_SYSMODELFROM, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getUpdateDate() != null) {
            object = pSSysModelGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelGroupBase.getUpdateMan() != null) {
            object = pSSysModelGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getUserCat() != null) {
            object = pSSysModelGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getUserTag() != null) {
            object = pSSysModelGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getUserTag2() != null) {
            object = pSSysModelGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getUserTag3() != null) {
            object = pSSysModelGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelGroupBase.getUserTag4() != null) {
            object = pSSysModelGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelGroupBase pSSysModelGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelGroupBase.isClsPkgParamsDirty() && (bl || pSSysModelGroupBase.getClsPkgParams() != null)) {
            iDataObject.set(FIELD_CLSPKGPARAMS, (Object)pSSysModelGroupBase.getClsPkgParams());
        }
        if (pSSysModelGroupBase.isCodeNameDirty() && (bl || pSSysModelGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysModelGroupBase.getCodeName());
        }
        if (pSSysModelGroupBase.isCodeNameModeDirty() && (bl || pSSysModelGroupBase.getCodeNameMode() != null)) {
            iDataObject.set(FIELD_CODENAMEMODE, (Object)pSSysModelGroupBase.getCodeNameMode());
        }
        if (pSSysModelGroupBase.isCreateDateDirty() && (bl || pSSysModelGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelGroupBase.getCreateDate());
        }
        if (pSSysModelGroupBase.isCreateManDirty() && (bl || pSSysModelGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelGroupBase.getCreateMan());
        }
        if (pSSysModelGroupBase.isDTOFormatDirty() && (bl || pSSysModelGroupBase.getDTOFormat() != null)) {
            iDataObject.set(FIELD_DTOFORMAT, (Object)pSSysModelGroupBase.getDTOFormat());
        }
        if (pSSysModelGroupBase.isDynaInstModeDirty() && (bl || pSSysModelGroupBase.getDynaInstMode() != null)) {
            iDataObject.set(FIELD_DYNAINSTMODE, (Object)pSSysModelGroupBase.getDynaInstMode());
        }
        if (pSSysModelGroupBase.isDynaInstTagDirty() && (bl || pSSysModelGroupBase.getDynaInstTag() != null)) {
            iDataObject.set(FIELD_DYNAINSTTAG, (Object)pSSysModelGroupBase.getDynaInstTag());
        }
        if (pSSysModelGroupBase.isDynaInstTag2Dirty() && (bl || pSSysModelGroupBase.getDynaInstTag2() != null)) {
            iDataObject.set(FIELD_DYNAINSTTAG2, (Object)pSSysModelGroupBase.getDynaInstTag2());
        }
        if (pSSysModelGroupBase.isEnablePQLDirty() && (bl || pSSysModelGroupBase.getEnablePQL() != null)) {
            iDataObject.set(FIELD_ENABLEPQL, (Object)pSSysModelGroupBase.getEnablePQL());
        }
        if (pSSysModelGroupBase.isGroupParamsDirty() && (bl || pSSysModelGroupBase.getGroupParams() != null)) {
            iDataObject.set(FIELD_GROUPPARAMS, (Object)pSSysModelGroupBase.getGroupParams());
        }
        if (pSSysModelGroupBase.isGroupTagDirty() && (bl || pSSysModelGroupBase.getGroupTag() != null)) {
            iDataObject.set(FIELD_GROUPTAG, (Object)pSSysModelGroupBase.getGroupTag());
        }
        if (pSSysModelGroupBase.isGroupTag2Dirty() && (bl || pSSysModelGroupBase.getGroupTag2() != null)) {
            iDataObject.set(FIELD_GROUPTAG2, (Object)pSSysModelGroupBase.getGroupTag2());
        }
        if (pSSysModelGroupBase.isGroupTag3Dirty() && (bl || pSSysModelGroupBase.getGroupTag3() != null)) {
            iDataObject.set(FIELD_GROUPTAG3, (Object)pSSysModelGroupBase.getGroupTag3());
        }
        if (pSSysModelGroupBase.isGroupTag4Dirty() && (bl || pSSysModelGroupBase.getGroupTag4() != null)) {
            iDataObject.set(FIELD_GROUPTAG4, (Object)pSSysModelGroupBase.getGroupTag4());
        }
        if (pSSysModelGroupBase.isMemoDirty() && (bl || pSSysModelGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelGroupBase.getMemo());
        }
        if (pSSysModelGroupBase.isPFRTObjectRepoDirty() && (bl || pSSysModelGroupBase.getPFRTObjectRepo() != null)) {
            iDataObject.set(FIELD_PFRTOBJECTREPO, (Object)pSSysModelGroupBase.getPFRTObjectRepo());
        }
        if (pSSysModelGroupBase.isPKGCodeNameDirty() && (bl || pSSysModelGroupBase.getPKGCodeName() != null)) {
            iDataObject.set(FIELD_PKGCODENAME, (Object)pSSysModelGroupBase.getPKGCodeName());
        }
        if (pSSysModelGroupBase.isPSDCSysModelRepoIdDirty() && (bl || pSSysModelGroupBase.getPSDCSysModelRepoId() != null)) {
            iDataObject.set(FIELD_PSDCSYSMODELREPOID, (Object)pSSysModelGroupBase.getPSDCSysModelRepoId());
        }
        if (pSSysModelGroupBase.isPSDCSysModelRepoNameDirty() && (bl || pSSysModelGroupBase.getPSDCSysModelRepoName() != null)) {
            iDataObject.set(FIELD_PSDCSYSMODELREPONAME, (Object)pSSysModelGroupBase.getPSDCSysModelRepoName());
        }
        if (pSSysModelGroupBase.isPSSysModelGroupIdDirty() && (bl || pSSysModelGroupBase.getPSSysModelGroupId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPID, (Object)pSSysModelGroupBase.getPSSysModelGroupId());
        }
        if (pSSysModelGroupBase.isPSSysModelGroupNameDirty() && (bl || pSSysModelGroupBase.getPSSysModelGroupName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPNAME, (Object)pSSysModelGroupBase.getPSSysModelGroupName());
        }
        if (pSSysModelGroupBase.isPSSysModelRepoIdDirty() && (bl || pSSysModelGroupBase.getPSSysModelRepoId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELREPOID, (Object)pSSysModelGroupBase.getPSSysModelRepoId());
        }
        if (pSSysModelGroupBase.isPSSysModelRepoNameDirty() && (bl || pSSysModelGroupBase.getPSSysModelRepoName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELREPONAME, (Object)pSSysModelGroupBase.getPSSysModelRepoName());
        }
        if (pSSysModelGroupBase.isPSSystemIdDirty() && (bl || pSSysModelGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysModelGroupBase.getPSSystemId());
        }
        if (pSSysModelGroupBase.isPSSystemNameDirty() && (bl || pSSysModelGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysModelGroupBase.getPSSystemName());
        }
        if (pSSysModelGroupBase.isRuntimeTypeDirty() && (bl || pSSysModelGroupBase.getRuntimeType() != null)) {
            iDataObject.set(FIELD_RUNTIMETYPE, (Object)pSSysModelGroupBase.getRuntimeType());
        }
        if (pSSysModelGroupBase.isSFRTObjectRepoDirty() && (bl || pSSysModelGroupBase.getSFRTObjectRepo() != null)) {
            iDataObject.set(FIELD_SFRTOBJECTREPO, (Object)pSSysModelGroupBase.getSFRTObjectRepo());
        }
        if (pSSysModelGroupBase.isSyncModeDirty() && (bl || pSSysModelGroupBase.getSyncMode() != null)) {
            iDataObject.set(FIELD_SYNCMODE, (Object)pSSysModelGroupBase.getSyncMode());
        }
        if (pSSysModelGroupBase.isSysModelFromDirty() && (bl || pSSysModelGroupBase.getSysModelFrom() != null)) {
            iDataObject.set(FIELD_SYSMODELFROM, (Object)pSSysModelGroupBase.getSysModelFrom());
        }
        if (pSSysModelGroupBase.isUpdateDateDirty() && (bl || pSSysModelGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelGroupBase.getUpdateDate());
        }
        if (pSSysModelGroupBase.isUpdateManDirty() && (bl || pSSysModelGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelGroupBase.getUpdateMan());
        }
        if (pSSysModelGroupBase.isUserCatDirty() && (bl || pSSysModelGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysModelGroupBase.getUserCat());
        }
        if (pSSysModelGroupBase.isUserTagDirty() && (bl || pSSysModelGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysModelGroupBase.getUserTag());
        }
        if (pSSysModelGroupBase.isUserTag2Dirty() && (bl || pSSysModelGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysModelGroupBase.getUserTag2());
        }
        if (pSSysModelGroupBase.isUserTag3Dirty() && (bl || pSSysModelGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysModelGroupBase.getUserTag3());
        }
        if (pSSysModelGroupBase.isUserTag4Dirty() && (bl || pSSysModelGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysModelGroupBase.getUserTag4());
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
        return PSSysModelGroupBase.remove(this, n);
    }

    private static boolean remove(PSSysModelGroupBase pSSysModelGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelGroupBase.resetClsPkgParams();
                return true;
            }
            case 1: {
                pSSysModelGroupBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysModelGroupBase.resetCodeNameMode();
                return true;
            }
            case 3: {
                pSSysModelGroupBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysModelGroupBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysModelGroupBase.resetDTOFormat();
                return true;
            }
            case 6: {
                pSSysModelGroupBase.resetDynaInstMode();
                return true;
            }
            case 7: {
                pSSysModelGroupBase.resetDynaInstTag();
                return true;
            }
            case 8: {
                pSSysModelGroupBase.resetDynaInstTag2();
                return true;
            }
            case 9: {
                pSSysModelGroupBase.resetEnablePQL();
                return true;
            }
            case 10: {
                pSSysModelGroupBase.resetGroupParams();
                return true;
            }
            case 11: {
                pSSysModelGroupBase.resetGroupTag();
                return true;
            }
            case 12: {
                pSSysModelGroupBase.resetGroupTag2();
                return true;
            }
            case 13: {
                pSSysModelGroupBase.resetGroupTag3();
                return true;
            }
            case 14: {
                pSSysModelGroupBase.resetGroupTag4();
                return true;
            }
            case 15: {
                pSSysModelGroupBase.resetMemo();
                return true;
            }
            case 16: {
                pSSysModelGroupBase.resetPFRTObjectRepo();
                return true;
            }
            case 17: {
                pSSysModelGroupBase.resetPKGCodeName();
                return true;
            }
            case 18: {
                pSSysModelGroupBase.resetPSDCSysModelRepoId();
                return true;
            }
            case 19: {
                pSSysModelGroupBase.resetPSDCSysModelRepoName();
                return true;
            }
            case 20: {
                pSSysModelGroupBase.resetPSSysModelGroupId();
                return true;
            }
            case 21: {
                pSSysModelGroupBase.resetPSSysModelGroupName();
                return true;
            }
            case 22: {
                pSSysModelGroupBase.resetPSSysModelRepoId();
                return true;
            }
            case 23: {
                pSSysModelGroupBase.resetPSSysModelRepoName();
                return true;
            }
            case 24: {
                pSSysModelGroupBase.resetPSSystemId();
                return true;
            }
            case 25: {
                pSSysModelGroupBase.resetPSSystemName();
                return true;
            }
            case 26: {
                pSSysModelGroupBase.resetRuntimeType();
                return true;
            }
            case 27: {
                pSSysModelGroupBase.resetSFRTObjectRepo();
                return true;
            }
            case 28: {
                pSSysModelGroupBase.resetSyncMode();
                return true;
            }
            case 29: {
                pSSysModelGroupBase.resetSysModelFrom();
                return true;
            }
            case 30: {
                pSSysModelGroupBase.resetUpdateDate();
                return true;
            }
            case 31: {
                pSSysModelGroupBase.resetUpdateMan();
                return true;
            }
            case 32: {
                pSSysModelGroupBase.resetUserCat();
                return true;
            }
            case 33: {
                pSSysModelGroupBase.resetUserTag();
                return true;
            }
            case 34: {
                pSSysModelGroupBase.resetUserTag2();
                return true;
            }
            case 35: {
                pSSysModelGroupBase.resetUserTag3();
                return true;
            }
            case 36: {
                pSSysModelGroupBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCSysModelRepo getPSDCSysModelRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysModelRepo();
        }
        if (this.getPSDCSysModelRepoId() == null) {
            return null;
        }
        Integer n = this.objPSDCSysModelRepoLock;
        synchronized (n) {
            if (this.psdcsysmodelrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCSysModelRepoId(), (Object)this.psdcsysmodelrepo.getPSDCSysModelRepoId()) != 0L) {
                this.psdcsysmodelrepo = null;
            }
            if (this.psdcsysmodelrepo == null) {
                PSDCSysModelRepo pSDCSysModelRepo = new PSDCSysModelRepo();
                pSDCSysModelRepo.setPSDCSysModelRepoId(this.getPSDCSysModelRepoId());
                PSDCSysModelRepoService pSDCSysModelRepoService = (PSDCSysModelRepoService)ServiceGlobal.getService(PSDCSysModelRepoService.class, (SessionFactory)this.getSessionFactory());
                pSDCSysModelRepoService.autoGet(pSDCSysModelRepo);
                this.psdcsysmodelrepo = pSDCSysModelRepo;
            }
            return this.psdcsysmodelrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelRepo getPSSysModelRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelRepo();
        }
        if (this.getPSSysModelRepoId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelRepoLock;
        synchronized (n) {
            if (this.pssysmodelrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelRepoId(), (Object)this.pssysmodelrepo.getPSSysModelRepoId()) != 0L) {
                this.pssysmodelrepo = null;
            }
            if (this.pssysmodelrepo == null) {
                PSSysModelRepo pSSysModelRepo = new PSSysModelRepo();
                pSSysModelRepo.setPSSysModelRepoId(this.getPSSysModelRepoId());
                PSSysModelRepoService pSSysModelRepoService = (PSSysModelRepoService)ServiceGlobal.getService(PSSysModelRepoService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelRepoService.autoGet(pSSysModelRepo);
                this.pssysmodelrepo = pSSysModelRepo;
            }
            return this.pssysmodelrepo;
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
    public ArrayList<PSModule> getPSModules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModules();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModulesLock;
        synchronized (n) {
            if (this.psmodules == null) {
                this.psmodules = pSModuleService.selectByPSSysModelGroup(this);
            }
            return this.psmodules;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDScheme> getPSSysBDSchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemes();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        PSSysBDSchemeService pSSysBDSchemeService = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDSchemesLock;
        synchronized (n) {
            if (this.pssysbdschemes == null) {
                this.pssysbdschemes = pSSysBDSchemeService.selectByPSSysModelGroup(this);
            }
            return this.pssysbdschemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBScheme> getPSSysDBSchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemes();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBSchemesLock;
        synchronized (n) {
            if (this.pssysdbschemes == null) {
                this.pssysdbschemes = pSSysDBSchemeService.selectByPSSysModelGroup(this);
            }
            return this.pssysdbschemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchScheme> getPSSysSearchSchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemes();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        PSSysSearchSchemeService pSSysSearchSchemeService = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchSchemesLock;
        synchronized (n) {
            if (this.pssyssearchschemes == null) {
                this.pssyssearchschemes = pSSysSearchSchemeService.selectByPSSysModelGroup(this);
            }
            return this.pssyssearchschemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUtilDE> getPSSysUtilDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEs();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUtilDEsLock;
        synchronized (n) {
            if (this.pssysutildes == null) {
                this.pssysutildes = pSSysUtilDEService.selectByPSSysModelGroup(this);
            }
            return this.pssysutildes;
        }
    }

    private PSSysModelGroupBase getProxyEntity() {
        return this.proxyPSSysModelGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelGroupBase) {
            this.proxyPSSysModelGroupBase = (PSSysModelGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLSPKGPARAMS, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CODENAMEMODE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DTOFORMAT, 5);
        fieldIndexMap.put(FIELD_DYNAINSTMODE, 6);
        fieldIndexMap.put(FIELD_DYNAINSTTAG, 7);
        fieldIndexMap.put(FIELD_DYNAINSTTAG2, 8);
        fieldIndexMap.put(FIELD_ENABLEPQL, 9);
        fieldIndexMap.put(FIELD_GROUPPARAMS, 10);
        fieldIndexMap.put(FIELD_GROUPTAG, 11);
        fieldIndexMap.put(FIELD_GROUPTAG2, 12);
        fieldIndexMap.put(FIELD_GROUPTAG3, 13);
        fieldIndexMap.put(FIELD_GROUPTAG4, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_PFRTOBJECTREPO, 16);
        fieldIndexMap.put(FIELD_PKGCODENAME, 17);
        fieldIndexMap.put(FIELD_PSDCSYSMODELREPOID, 18);
        fieldIndexMap.put(FIELD_PSDCSYSMODELREPONAME, 19);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPID, 20);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSMODELREPOID, 22);
        fieldIndexMap.put(FIELD_PSSYSMODELREPONAME, 23);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 25);
        fieldIndexMap.put(FIELD_RUNTIMETYPE, 26);
        fieldIndexMap.put(FIELD_SFRTOBJECTREPO, 27);
        fieldIndexMap.put(FIELD_SYNCMODE, 28);
        fieldIndexMap.put(FIELD_SYSMODELFROM, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 30);
        fieldIndexMap.put(FIELD_UPDATEMAN, 31);
        fieldIndexMap.put(FIELD_USERCAT, 32);
        fieldIndexMap.put(FIELD_USERTAG, 33);
        fieldIndexMap.put(FIELD_USERTAG2, 34);
        fieldIndexMap.put(FIELD_USERTAG3, 35);
        fieldIndexMap.put(FIELD_USERTAG4, 36);
    }
}

