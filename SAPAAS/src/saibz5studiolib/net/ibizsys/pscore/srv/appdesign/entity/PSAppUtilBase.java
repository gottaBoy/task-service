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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUtilBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppUtilBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPUTILID = "PSAPPUTILID";
    public static final String FIELD_PSAPPUTILNAME = "PSAPPUTILNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UTILOBJ = "UTILOBJ";
    public static final String FIELD_UTILPARAM = "UTILPARAM";
    public static final String FIELD_UTILPARAM10 = "UTILPARAM10";
    public static final String FIELD_UTILPARAM11 = "UTILPARAM11";
    public static final String FIELD_UTILPARAM12 = "UTILPARAM12";
    public static final String FIELD_UTILPARAM2 = "UTILPARAM2";
    public static final String FIELD_UTILPARAM3 = "UTILPARAM3";
    public static final String FIELD_UTILPARAM4 = "UTILPARAM4";
    public static final String FIELD_UTILPARAM5 = "UTILPARAM5";
    public static final String FIELD_UTILPARAM6 = "UTILPARAM6";
    public static final String FIELD_UTILPARAM7 = "UTILPARAM7";
    public static final String FIELD_UTILPARAM8 = "UTILPARAM8";
    public static final String FIELD_UTILPARAM9 = "UTILPARAM9";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_UTILPSDE2ID = "UTILPSDE2ID";
    public static final String FIELD_UTILPSDE2NAME = "UTILPSDE2NAME";
    public static final String FIELD_UTILPSDE3ID = "UTILPSDE3ID";
    public static final String FIELD_UTILPSDE3NAME = "UTILPSDE3NAME";
    public static final String FIELD_UTILPSDE4ID = "UTILPSDE4ID";
    public static final String FIELD_UTILPSDE4NAME = "UTILPSDE4NAME";
    public static final String FIELD_UTILPSDE5ID = "UTILPSDE5ID";
    public static final String FIELD_UTILPSDE5NAME = "UTILPSDE5NAME";
    public static final String FIELD_UTILPSDE6ID = "UTILPSDE6ID";
    public static final String FIELD_UTILPSDE6NAME = "UTILPSDE6NAME";
    public static final String FIELD_UTILPSDE7ID = "UTILPSDE7ID";
    public static final String FIELD_UTILPSDE7NAME = "UTILPSDE7NAME";
    public static final String FIELD_UTILPSDE8ID = "UTILPSDE8ID";
    public static final String FIELD_UTILPSDE8NAME = "UTILPSDE8NAME";
    public static final String FIELD_UTILPSDE9ID = "UTILPSDE9ID";
    public static final String FIELD_UTILPSDE9NAME = "UTILPSDE9NAME";
    public static final String FIELD_UTILPSDEID = "UTILPSDEID";
    public static final String FIELD_UTILPSDENAME = "UTILPSDENAME";
    public static final String FIELD_UTILTAG = "UTILTAG";
    public static final String FIELD_UTILTYPE = "UTILTYPE";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAPPUTILID = 4;
    private static final int INDEX_PSAPPUTILNAME = 5;
    private static final int INDEX_PSSYSAPPID = 6;
    private static final int INDEX_PSSYSAPPNAME = 7;
    private static final int INDEX_PSSYSDYNAMODELID = 8;
    private static final int INDEX_PSSYSDYNAMODELNAME = 9;
    private static final int INDEX_PSSYSPFPLUGINID = 10;
    private static final int INDEX_PSSYSPFPLUGINNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_UTILOBJ = 19;
    private static final int INDEX_UTILPARAM = 20;
    private static final int INDEX_UTILPARAM10 = 21;
    private static final int INDEX_UTILPARAM11 = 22;
    private static final int INDEX_UTILPARAM12 = 23;
    private static final int INDEX_UTILPARAM2 = 24;
    private static final int INDEX_UTILPARAM3 = 25;
    private static final int INDEX_UTILPARAM4 = 26;
    private static final int INDEX_UTILPARAM5 = 27;
    private static final int INDEX_UTILPARAM6 = 28;
    private static final int INDEX_UTILPARAM7 = 29;
    private static final int INDEX_UTILPARAM8 = 30;
    private static final int INDEX_UTILPARAM9 = 31;
    private static final int INDEX_UTILPARAMS = 32;
    private static final int INDEX_UTILPSDE2ID = 33;
    private static final int INDEX_UTILPSDE2NAME = 34;
    private static final int INDEX_UTILPSDE3ID = 35;
    private static final int INDEX_UTILPSDE3NAME = 36;
    private static final int INDEX_UTILPSDE4ID = 37;
    private static final int INDEX_UTILPSDE4NAME = 38;
    private static final int INDEX_UTILPSDE5ID = 39;
    private static final int INDEX_UTILPSDE5NAME = 40;
    private static final int INDEX_UTILPSDE6ID = 41;
    private static final int INDEX_UTILPSDE6NAME = 42;
    private static final int INDEX_UTILPSDE7ID = 43;
    private static final int INDEX_UTILPSDE7NAME = 44;
    private static final int INDEX_UTILPSDE8ID = 45;
    private static final int INDEX_UTILPSDE8NAME = 46;
    private static final int INDEX_UTILPSDE9ID = 47;
    private static final int INDEX_UTILPSDE9NAME = 48;
    private static final int INDEX_UTILPSDEID = 49;
    private static final int INDEX_UTILPSDENAME = 50;
    private static final int INDEX_UTILTAG = 51;
    private static final int INDEX_UTILTYPE = 52;
    private static final int INDEX_VALIDFLAG = 53;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppUtilBase proxyPSAppUtilBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapputilidDirtyFlag = false;
    private boolean psapputilnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean utilobjDirtyFlag = false;
    private boolean utilparamDirtyFlag = false;
    private boolean utilparam10DirtyFlag = false;
    private boolean utilparam11DirtyFlag = false;
    private boolean utilparam12DirtyFlag = false;
    private boolean utilparam2DirtyFlag = false;
    private boolean utilparam3DirtyFlag = false;
    private boolean utilparam4DirtyFlag = false;
    private boolean utilparam5DirtyFlag = false;
    private boolean utilparam6DirtyFlag = false;
    private boolean utilparam7DirtyFlag = false;
    private boolean utilparam8DirtyFlag = false;
    private boolean utilparam9DirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean utilpsde2idDirtyFlag = false;
    private boolean utilpsde2nameDirtyFlag = false;
    private boolean utilpsde3idDirtyFlag = false;
    private boolean utilpsde3nameDirtyFlag = false;
    private boolean utilpsde4idDirtyFlag = false;
    private boolean utilpsde4nameDirtyFlag = false;
    private boolean utilpsde5idDirtyFlag = false;
    private boolean utilpsde5nameDirtyFlag = false;
    private boolean utilpsde6idDirtyFlag = false;
    private boolean utilpsde6nameDirtyFlag = false;
    private boolean utilpsde7idDirtyFlag = false;
    private boolean utilpsde7nameDirtyFlag = false;
    private boolean utilpsde8idDirtyFlag = false;
    private boolean utilpsde8nameDirtyFlag = false;
    private boolean utilpsde9idDirtyFlag = false;
    private boolean utilpsde9nameDirtyFlag = false;
    private boolean utilpsdeidDirtyFlag = false;
    private boolean utilpsdenameDirtyFlag = false;
    private boolean utiltagDirtyFlag = false;
    private boolean utiltypeDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psapputilid")
    private String psapputilid;
    @Column(name="psapputilname")
    private String psapputilname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
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
    @Column(name="utilobj")
    private String utilobj;
    @Column(name="utilparam")
    private String utilparam;
    @Column(name="utilparam10")
    private Integer utilparam10;
    @Column(name="utilparam11")
    private String utilparam11;
    @Column(name="utilparam12")
    private String utilparam12;
    @Column(name="utilparam2")
    private String utilparam2;
    @Column(name="utilparam3")
    private String utilparam3;
    @Column(name="utilparam4")
    private String utilparam4;
    @Column(name="utilparam5")
    private Integer utilparam5;
    @Column(name="utilparam6")
    private Integer utilparam6;
    @Column(name="utilparam7")
    private Integer utilparam7;
    @Column(name="utilparam8")
    private Integer utilparam8;
    @Column(name="utilparam9")
    private Integer utilparam9;
    @Column(name="utilparams")
    private String utilparams;
    @Column(name="utilpsde2id")
    private String utilpsde2id;
    @Column(name="utilpsde2name")
    private String utilpsde2name;
    @Column(name="utilpsde3id")
    private String utilpsde3id;
    @Column(name="utilpsde3name")
    private String utilpsde3name;
    @Column(name="utilpsde4id")
    private String utilpsde4id;
    @Column(name="utilpsde4name")
    private String utilpsde4name;
    @Column(name="utilpsde5id")
    private String utilpsde5id;
    @Column(name="utilpsde5name")
    private String utilpsde5name;
    @Column(name="utilpsde6id")
    private String utilpsde6id;
    @Column(name="utilpsde6name")
    private String utilpsde6name;
    @Column(name="utilpsde7id")
    private String utilpsde7id;
    @Column(name="utilpsde7name")
    private String utilpsde7name;
    @Column(name="utilpsde8id")
    private String utilpsde8id;
    @Column(name="utilpsde8name")
    private String utilpsde8name;
    @Column(name="utilpsde9id")
    private String utilpsde9id;
    @Column(name="utilpsde9name")
    private String utilpsde9name;
    @Column(name="utilpsdeid")
    private String utilpsdeid;
    @Column(name="utilpsdename")
    private String utilpsdename;
    @Column(name="utiltag")
    private String utiltag;
    @Column(name="utiltype")
    private String utiltype;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objUtilPSDE2Lock = new Integer(1);
    private PSDataEntity utilpsde2 = null;
    private Integer objUtilPSDE3Lock = new Integer(1);
    private PSDataEntity utilpsde3 = null;
    private Integer objUtilPSDE4Lock = new Integer(1);
    private PSDataEntity utilpsde4 = null;
    private Integer objUtilPSDE5Lock = new Integer(1);
    private PSDataEntity utilpsde5 = null;
    private Integer objUtilPSDE6Lock = new Integer(1);
    private PSDataEntity utilpsde6 = null;
    private Integer objUtilPSDE7Lock = new Integer(1);
    private PSDataEntity utilpsde7 = null;
    private Integer objUtilPSDE8Lock = new Integer(1);
    private PSDataEntity utilpsde8 = null;
    private Integer objUtilPSDE9Lock = new Integer(1);
    private PSDataEntity utilpsde9 = null;
    private Integer objUtilPSDELock = new Integer(1);
    private PSDataEntity utilpsde = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;

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

    public void setPSAppUtilId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputilid = string;
        this.psapputilidDirtyFlag = true;
    }

    public String getPSAppUtilId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilId();
        }
        return this.psapputilid;
    }

    public boolean isPSAppUtilIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilIdDirty();
        }
        return this.psapputilidDirtyFlag;
    }

    public void resetPSAppUtilId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilId();
            return;
        }
        this.psapputilidDirtyFlag = false;
        this.psapputilid = null;
    }

    public void setPSAppUtilName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputilname = string;
        this.psapputilnameDirtyFlag = true;
    }

    public String getPSAppUtilName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilName();
        }
        return this.psapputilname;
    }

    public boolean isPSAppUtilNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilNameDirty();
        }
        return this.psapputilnameDirtyFlag;
    }

    public void resetPSAppUtilName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilName();
            return;
        }
        this.psapputilnameDirtyFlag = false;
        this.psapputilname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
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

    public void setUtilObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilobj = string;
        this.utilobjDirtyFlag = true;
    }

    public String getUtilObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilObj();
        }
        return this.utilobj;
    }

    public boolean isUtilObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilObjDirty();
        }
        return this.utilobjDirtyFlag;
    }

    public void resetUtilObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilObj();
            return;
        }
        this.utilobjDirtyFlag = false;
        this.utilobj = null;
    }

    public void setUtilParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam = string;
        this.utilparamDirtyFlag = true;
    }

    public String getUtilParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam();
        }
        return this.utilparam;
    }

    public boolean isUtilParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamDirty();
        }
        return this.utilparamDirtyFlag;
    }

    public void resetUtilParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam();
            return;
        }
        this.utilparamDirtyFlag = false;
        this.utilparam = null;
    }

    public void setUtilParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam10(n);
            return;
        }
        this.utilparam10 = n;
        this.utilparam10DirtyFlag = true;
    }

    public Integer getUtilParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam10();
        }
        return this.utilparam10;
    }

    public boolean isUtilParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam10Dirty();
        }
        return this.utilparam10DirtyFlag;
    }

    public void resetUtilParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam10();
            return;
        }
        this.utilparam10DirtyFlag = false;
        this.utilparam10 = null;
    }

    public void setUtilParam11(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam11(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam11 = string;
        this.utilparam11DirtyFlag = true;
    }

    public String getUtilParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam11();
        }
        return this.utilparam11;
    }

    public boolean isUtilParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam11Dirty();
        }
        return this.utilparam11DirtyFlag;
    }

    public void resetUtilParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam11();
            return;
        }
        this.utilparam11DirtyFlag = false;
        this.utilparam11 = null;
    }

    public void setUtilParam12(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam12(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam12 = string;
        this.utilparam12DirtyFlag = true;
    }

    public String getUtilParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam12();
        }
        return this.utilparam12;
    }

    public boolean isUtilParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam12Dirty();
        }
        return this.utilparam12DirtyFlag;
    }

    public void resetUtilParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam12();
            return;
        }
        this.utilparam12DirtyFlag = false;
        this.utilparam12 = null;
    }

    public void setUtilParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam2 = string;
        this.utilparam2DirtyFlag = true;
    }

    public String getUtilParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam2();
        }
        return this.utilparam2;
    }

    public boolean isUtilParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam2Dirty();
        }
        return this.utilparam2DirtyFlag;
    }

    public void resetUtilParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam2();
            return;
        }
        this.utilparam2DirtyFlag = false;
        this.utilparam2 = null;
    }

    public void setUtilParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam3 = string;
        this.utilparam3DirtyFlag = true;
    }

    public String getUtilParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam3();
        }
        return this.utilparam3;
    }

    public boolean isUtilParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam3Dirty();
        }
        return this.utilparam3DirtyFlag;
    }

    public void resetUtilParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam3();
            return;
        }
        this.utilparam3DirtyFlag = false;
        this.utilparam3 = null;
    }

    public void setUtilParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparam4 = string;
        this.utilparam4DirtyFlag = true;
    }

    public String getUtilParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam4();
        }
        return this.utilparam4;
    }

    public boolean isUtilParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam4Dirty();
        }
        return this.utilparam4DirtyFlag;
    }

    public void resetUtilParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam4();
            return;
        }
        this.utilparam4DirtyFlag = false;
        this.utilparam4 = null;
    }

    public void setUtilParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam5(n);
            return;
        }
        this.utilparam5 = n;
        this.utilparam5DirtyFlag = true;
    }

    public Integer getUtilParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam5();
        }
        return this.utilparam5;
    }

    public boolean isUtilParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam5Dirty();
        }
        return this.utilparam5DirtyFlag;
    }

    public void resetUtilParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam5();
            return;
        }
        this.utilparam5DirtyFlag = false;
        this.utilparam5 = null;
    }

    public void setUtilParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam6(n);
            return;
        }
        this.utilparam6 = n;
        this.utilparam6DirtyFlag = true;
    }

    public Integer getUtilParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam6();
        }
        return this.utilparam6;
    }

    public boolean isUtilParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam6Dirty();
        }
        return this.utilparam6DirtyFlag;
    }

    public void resetUtilParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam6();
            return;
        }
        this.utilparam6DirtyFlag = false;
        this.utilparam6 = null;
    }

    public void setUtilParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam7(n);
            return;
        }
        this.utilparam7 = n;
        this.utilparam7DirtyFlag = true;
    }

    public Integer getUtilParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam7();
        }
        return this.utilparam7;
    }

    public boolean isUtilParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam7Dirty();
        }
        return this.utilparam7DirtyFlag;
    }

    public void resetUtilParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam7();
            return;
        }
        this.utilparam7DirtyFlag = false;
        this.utilparam7 = null;
    }

    public void setUtilParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam8(n);
            return;
        }
        this.utilparam8 = n;
        this.utilparam8DirtyFlag = true;
    }

    public Integer getUtilParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam8();
        }
        return this.utilparam8;
    }

    public boolean isUtilParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam8Dirty();
        }
        return this.utilparam8DirtyFlag;
    }

    public void resetUtilParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam8();
            return;
        }
        this.utilparam8DirtyFlag = false;
        this.utilparam8 = null;
    }

    public void setUtilParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParam9(n);
            return;
        }
        this.utilparam9 = n;
        this.utilparam9DirtyFlag = true;
    }

    public Integer getUtilParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParam9();
        }
        return this.utilparam9;
    }

    public boolean isUtilParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParam9Dirty();
        }
        return this.utilparam9DirtyFlag;
    }

    public void resetUtilParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParam9();
            return;
        }
        this.utilparam9DirtyFlag = false;
        this.utilparam9 = null;
    }

    public void setUtilParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparams = string;
        this.utilparamsDirtyFlag = true;
    }

    public String getUtilParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParams();
        }
        return this.utilparams;
    }

    public boolean isUtilParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamsDirty();
        }
        return this.utilparamsDirtyFlag;
    }

    public void resetUtilParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParams();
            return;
        }
        this.utilparamsDirtyFlag = false;
        this.utilparams = null;
    }

    public void setUtilPSDE2Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE2Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde2id = string;
        this.utilpsde2idDirtyFlag = true;
    }

    public String getUtilPSDE2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE2Id();
        }
        return this.utilpsde2id;
    }

    public boolean isUtilPSDE2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE2IdDirty();
        }
        return this.utilpsde2idDirtyFlag;
    }

    public void resetUtilPSDE2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE2Id();
            return;
        }
        this.utilpsde2idDirtyFlag = false;
        this.utilpsde2id = null;
    }

    public void setUtilPSDE2Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE2Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde2name = string;
        this.utilpsde2nameDirtyFlag = true;
    }

    public String getUtilPSDE2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE2Name();
        }
        return this.utilpsde2name;
    }

    public boolean isUtilPSDE2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE2NameDirty();
        }
        return this.utilpsde2nameDirtyFlag;
    }

    public void resetUtilPSDE2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE2Name();
            return;
        }
        this.utilpsde2nameDirtyFlag = false;
        this.utilpsde2name = null;
    }

    public void setUtilPSDE3Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE3Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde3id = string;
        this.utilpsde3idDirtyFlag = true;
    }

    public String getUtilPSDE3Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE3Id();
        }
        return this.utilpsde3id;
    }

    public boolean isUtilPSDE3IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE3IdDirty();
        }
        return this.utilpsde3idDirtyFlag;
    }

    public void resetUtilPSDE3Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE3Id();
            return;
        }
        this.utilpsde3idDirtyFlag = false;
        this.utilpsde3id = null;
    }

    public void setUtilPSDE3Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE3Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde3name = string;
        this.utilpsde3nameDirtyFlag = true;
    }

    public String getUtilPSDE3Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE3Name();
        }
        return this.utilpsde3name;
    }

    public boolean isUtilPSDE3NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE3NameDirty();
        }
        return this.utilpsde3nameDirtyFlag;
    }

    public void resetUtilPSDE3Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE3Name();
            return;
        }
        this.utilpsde3nameDirtyFlag = false;
        this.utilpsde3name = null;
    }

    public void setUtilPSDE4Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE4Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde4id = string;
        this.utilpsde4idDirtyFlag = true;
    }

    public String getUtilPSDE4Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE4Id();
        }
        return this.utilpsde4id;
    }

    public boolean isUtilPSDE4IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE4IdDirty();
        }
        return this.utilpsde4idDirtyFlag;
    }

    public void resetUtilPSDE4Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE4Id();
            return;
        }
        this.utilpsde4idDirtyFlag = false;
        this.utilpsde4id = null;
    }

    public void setUtilPSDE4Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE4Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde4name = string;
        this.utilpsde4nameDirtyFlag = true;
    }

    public String getUtilPSDE4Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE4Name();
        }
        return this.utilpsde4name;
    }

    public boolean isUtilPSDE4NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE4NameDirty();
        }
        return this.utilpsde4nameDirtyFlag;
    }

    public void resetUtilPSDE4Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE4Name();
            return;
        }
        this.utilpsde4nameDirtyFlag = false;
        this.utilpsde4name = null;
    }

    public void setUtilPSDE5Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE5Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde5id = string;
        this.utilpsde5idDirtyFlag = true;
    }

    public String getUtilPSDE5Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE5Id();
        }
        return this.utilpsde5id;
    }

    public boolean isUtilPSDE5IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE5IdDirty();
        }
        return this.utilpsde5idDirtyFlag;
    }

    public void resetUtilPSDE5Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE5Id();
            return;
        }
        this.utilpsde5idDirtyFlag = false;
        this.utilpsde5id = null;
    }

    public void setUtilPSDE5Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE5Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde5name = string;
        this.utilpsde5nameDirtyFlag = true;
    }

    public String getUtilPSDE5Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE5Name();
        }
        return this.utilpsde5name;
    }

    public boolean isUtilPSDE5NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE5NameDirty();
        }
        return this.utilpsde5nameDirtyFlag;
    }

    public void resetUtilPSDE5Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE5Name();
            return;
        }
        this.utilpsde5nameDirtyFlag = false;
        this.utilpsde5name = null;
    }

    public void setUtilPSDE6Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE6Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde6id = string;
        this.utilpsde6idDirtyFlag = true;
    }

    public String getUtilPSDE6Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE6Id();
        }
        return this.utilpsde6id;
    }

    public boolean isUtilPSDE6IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE6IdDirty();
        }
        return this.utilpsde6idDirtyFlag;
    }

    public void resetUtilPSDE6Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE6Id();
            return;
        }
        this.utilpsde6idDirtyFlag = false;
        this.utilpsde6id = null;
    }

    public void setUtilPSDE6Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE6Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde6name = string;
        this.utilpsde6nameDirtyFlag = true;
    }

    public String getUtilPSDE6Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE6Name();
        }
        return this.utilpsde6name;
    }

    public boolean isUtilPSDE6NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE6NameDirty();
        }
        return this.utilpsde6nameDirtyFlag;
    }

    public void resetUtilPSDE6Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE6Name();
            return;
        }
        this.utilpsde6nameDirtyFlag = false;
        this.utilpsde6name = null;
    }

    public void setUtilPSDE7Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE7Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde7id = string;
        this.utilpsde7idDirtyFlag = true;
    }

    public String getUtilPSDE7Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE7Id();
        }
        return this.utilpsde7id;
    }

    public boolean isUtilPSDE7IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE7IdDirty();
        }
        return this.utilpsde7idDirtyFlag;
    }

    public void resetUtilPSDE7Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE7Id();
            return;
        }
        this.utilpsde7idDirtyFlag = false;
        this.utilpsde7id = null;
    }

    public void setUtilPSDE7Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE7Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde7name = string;
        this.utilpsde7nameDirtyFlag = true;
    }

    public String getUtilPSDE7Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE7Name();
        }
        return this.utilpsde7name;
    }

    public boolean isUtilPSDE7NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE7NameDirty();
        }
        return this.utilpsde7nameDirtyFlag;
    }

    public void resetUtilPSDE7Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE7Name();
            return;
        }
        this.utilpsde7nameDirtyFlag = false;
        this.utilpsde7name = null;
    }

    public void setUtilPSDE8Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE8Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde8id = string;
        this.utilpsde8idDirtyFlag = true;
    }

    public String getUtilPSDE8Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE8Id();
        }
        return this.utilpsde8id;
    }

    public boolean isUtilPSDE8IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE8IdDirty();
        }
        return this.utilpsde8idDirtyFlag;
    }

    public void resetUtilPSDE8Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE8Id();
            return;
        }
        this.utilpsde8idDirtyFlag = false;
        this.utilpsde8id = null;
    }

    public void setUtilPSDE8Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE8Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde8name = string;
        this.utilpsde8nameDirtyFlag = true;
    }

    public String getUtilPSDE8Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE8Name();
        }
        return this.utilpsde8name;
    }

    public boolean isUtilPSDE8NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE8NameDirty();
        }
        return this.utilpsde8nameDirtyFlag;
    }

    public void resetUtilPSDE8Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE8Name();
            return;
        }
        this.utilpsde8nameDirtyFlag = false;
        this.utilpsde8name = null;
    }

    public void setUtilPSDE9Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE9Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde9id = string;
        this.utilpsde9idDirtyFlag = true;
    }

    public String getUtilPSDE9Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE9Id();
        }
        return this.utilpsde9id;
    }

    public boolean isUtilPSDE9IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE9IdDirty();
        }
        return this.utilpsde9idDirtyFlag;
    }

    public void resetUtilPSDE9Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE9Id();
            return;
        }
        this.utilpsde9idDirtyFlag = false;
        this.utilpsde9id = null;
    }

    public void setUtilPSDE9Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE9Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde9name = string;
        this.utilpsde9nameDirtyFlag = true;
    }

    public String getUtilPSDE9Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE9Name();
        }
        return this.utilpsde9name;
    }

    public boolean isUtilPSDE9NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE9NameDirty();
        }
        return this.utilpsde9nameDirtyFlag;
    }

    public void resetUtilPSDE9Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE9Name();
            return;
        }
        this.utilpsde9nameDirtyFlag = false;
        this.utilpsde9name = null;
    }

    public void setUtilPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsdeid = string;
        this.utilpsdeidDirtyFlag = true;
    }

    public String getUtilPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEId();
        }
        return this.utilpsdeid;
    }

    public boolean isUtilPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDEIdDirty();
        }
        return this.utilpsdeidDirtyFlag;
    }

    public void resetUtilPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDEId();
            return;
        }
        this.utilpsdeidDirtyFlag = false;
        this.utilpsdeid = null;
    }

    public void setUtilPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsdename = string;
        this.utilpsdenameDirtyFlag = true;
    }

    public String getUtilPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEName();
        }
        return this.utilpsdename;
    }

    public boolean isUtilPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDENameDirty();
        }
        return this.utilpsdenameDirtyFlag;
    }

    public void resetUtilPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDEName();
            return;
        }
        this.utilpsdenameDirtyFlag = false;
        this.utilpsdename = null;
    }

    public void setUtilTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltag = string;
        this.utiltagDirtyFlag = true;
    }

    public String getUtilTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilTag();
        }
        return this.utiltag;
    }

    public boolean isUtilTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTagDirty();
        }
        return this.utiltagDirtyFlag;
    }

    public void resetUtilTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilTag();
            return;
        }
        this.utiltagDirtyFlag = false;
        this.utiltag = null;
    }

    public void setUtilType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltype = string;
        this.utiltypeDirtyFlag = true;
    }

    public String getUtilType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilType();
        }
        return this.utiltype;
    }

    public boolean isUtilTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTypeDirty();
        }
        return this.utiltypeDirtyFlag;
    }

    public void resetUtilType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilType();
            return;
        }
        this.utiltypeDirtyFlag = false;
        this.utiltype = null;
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
        PSAppUtilBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppUtilBase pSAppUtilBase) {
        pSAppUtilBase.resetCodeName();
        pSAppUtilBase.resetCreateDate();
        pSAppUtilBase.resetCreateMan();
        pSAppUtilBase.resetMemo();
        pSAppUtilBase.resetPSAppUtilId();
        pSAppUtilBase.resetPSAppUtilName();
        pSAppUtilBase.resetPSSysAppId();
        pSAppUtilBase.resetPSSysAppName();
        pSAppUtilBase.resetPSSysDynaModelId();
        pSAppUtilBase.resetPSSysDynaModelName();
        pSAppUtilBase.resetPSSysPFPluginId();
        pSAppUtilBase.resetPSSysPFPluginName();
        pSAppUtilBase.resetUpdateDate();
        pSAppUtilBase.resetUpdateMan();
        pSAppUtilBase.resetUserCat();
        pSAppUtilBase.resetUserTag();
        pSAppUtilBase.resetUserTag2();
        pSAppUtilBase.resetUserTag3();
        pSAppUtilBase.resetUserTag4();
        pSAppUtilBase.resetUtilObj();
        pSAppUtilBase.resetUtilParam();
        pSAppUtilBase.resetUtilParam10();
        pSAppUtilBase.resetUtilParam11();
        pSAppUtilBase.resetUtilParam12();
        pSAppUtilBase.resetUtilParam2();
        pSAppUtilBase.resetUtilParam3();
        pSAppUtilBase.resetUtilParam4();
        pSAppUtilBase.resetUtilParam5();
        pSAppUtilBase.resetUtilParam6();
        pSAppUtilBase.resetUtilParam7();
        pSAppUtilBase.resetUtilParam8();
        pSAppUtilBase.resetUtilParam9();
        pSAppUtilBase.resetUtilParams();
        pSAppUtilBase.resetUtilPSDE2Id();
        pSAppUtilBase.resetUtilPSDE2Name();
        pSAppUtilBase.resetUtilPSDE3Id();
        pSAppUtilBase.resetUtilPSDE3Name();
        pSAppUtilBase.resetUtilPSDE4Id();
        pSAppUtilBase.resetUtilPSDE4Name();
        pSAppUtilBase.resetUtilPSDE5Id();
        pSAppUtilBase.resetUtilPSDE5Name();
        pSAppUtilBase.resetUtilPSDE6Id();
        pSAppUtilBase.resetUtilPSDE6Name();
        pSAppUtilBase.resetUtilPSDE7Id();
        pSAppUtilBase.resetUtilPSDE7Name();
        pSAppUtilBase.resetUtilPSDE8Id();
        pSAppUtilBase.resetUtilPSDE8Name();
        pSAppUtilBase.resetUtilPSDE9Id();
        pSAppUtilBase.resetUtilPSDE9Name();
        pSAppUtilBase.resetUtilPSDEId();
        pSAppUtilBase.resetUtilPSDEName();
        pSAppUtilBase.resetUtilTag();
        pSAppUtilBase.resetUtilType();
        pSAppUtilBase.resetValidFlag();
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
        if (!bl || this.isPSAppUtilIdDirty()) {
            hashMap.put(FIELD_PSAPPUTILID, this.getPSAppUtilId());
        }
        if (!bl || this.isPSAppUtilNameDirty()) {
            hashMap.put(FIELD_PSAPPUTILNAME, this.getPSAppUtilName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
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
        if (!bl || this.isUtilObjDirty()) {
            hashMap.put(FIELD_UTILOBJ, this.getUtilObj());
        }
        if (!bl || this.isUtilParamDirty()) {
            hashMap.put(FIELD_UTILPARAM, this.getUtilParam());
        }
        if (!bl || this.isUtilParam10Dirty()) {
            hashMap.put(FIELD_UTILPARAM10, this.getUtilParam10());
        }
        if (!bl || this.isUtilParam11Dirty()) {
            hashMap.put(FIELD_UTILPARAM11, this.getUtilParam11());
        }
        if (!bl || this.isUtilParam12Dirty()) {
            hashMap.put(FIELD_UTILPARAM12, this.getUtilParam12());
        }
        if (!bl || this.isUtilParam2Dirty()) {
            hashMap.put(FIELD_UTILPARAM2, this.getUtilParam2());
        }
        if (!bl || this.isUtilParam3Dirty()) {
            hashMap.put(FIELD_UTILPARAM3, this.getUtilParam3());
        }
        if (!bl || this.isUtilParam4Dirty()) {
            hashMap.put(FIELD_UTILPARAM4, this.getUtilParam4());
        }
        if (!bl || this.isUtilParam5Dirty()) {
            hashMap.put(FIELD_UTILPARAM5, this.getUtilParam5());
        }
        if (!bl || this.isUtilParam6Dirty()) {
            hashMap.put(FIELD_UTILPARAM6, this.getUtilParam6());
        }
        if (!bl || this.isUtilParam7Dirty()) {
            hashMap.put(FIELD_UTILPARAM7, this.getUtilParam7());
        }
        if (!bl || this.isUtilParam8Dirty()) {
            hashMap.put(FIELD_UTILPARAM8, this.getUtilParam8());
        }
        if (!bl || this.isUtilParam9Dirty()) {
            hashMap.put(FIELD_UTILPARAM9, this.getUtilParam9());
        }
        if (!bl || this.isUtilParamsDirty()) {
            hashMap.put(FIELD_UTILPARAMS, this.getUtilParams());
        }
        if (!bl || this.isUtilPSDE2IdDirty()) {
            hashMap.put(FIELD_UTILPSDE2ID, this.getUtilPSDE2Id());
        }
        if (!bl || this.isUtilPSDE2NameDirty()) {
            hashMap.put(FIELD_UTILPSDE2NAME, this.getUtilPSDE2Name());
        }
        if (!bl || this.isUtilPSDE3IdDirty()) {
            hashMap.put(FIELD_UTILPSDE3ID, this.getUtilPSDE3Id());
        }
        if (!bl || this.isUtilPSDE3NameDirty()) {
            hashMap.put(FIELD_UTILPSDE3NAME, this.getUtilPSDE3Name());
        }
        if (!bl || this.isUtilPSDE4IdDirty()) {
            hashMap.put(FIELD_UTILPSDE4ID, this.getUtilPSDE4Id());
        }
        if (!bl || this.isUtilPSDE4NameDirty()) {
            hashMap.put(FIELD_UTILPSDE4NAME, this.getUtilPSDE4Name());
        }
        if (!bl || this.isUtilPSDE5IdDirty()) {
            hashMap.put(FIELD_UTILPSDE5ID, this.getUtilPSDE5Id());
        }
        if (!bl || this.isUtilPSDE5NameDirty()) {
            hashMap.put(FIELD_UTILPSDE5NAME, this.getUtilPSDE5Name());
        }
        if (!bl || this.isUtilPSDE6IdDirty()) {
            hashMap.put(FIELD_UTILPSDE6ID, this.getUtilPSDE6Id());
        }
        if (!bl || this.isUtilPSDE6NameDirty()) {
            hashMap.put(FIELD_UTILPSDE6NAME, this.getUtilPSDE6Name());
        }
        if (!bl || this.isUtilPSDE7IdDirty()) {
            hashMap.put(FIELD_UTILPSDE7ID, this.getUtilPSDE7Id());
        }
        if (!bl || this.isUtilPSDE7NameDirty()) {
            hashMap.put(FIELD_UTILPSDE7NAME, this.getUtilPSDE7Name());
        }
        if (!bl || this.isUtilPSDE8IdDirty()) {
            hashMap.put(FIELD_UTILPSDE8ID, this.getUtilPSDE8Id());
        }
        if (!bl || this.isUtilPSDE8NameDirty()) {
            hashMap.put(FIELD_UTILPSDE8NAME, this.getUtilPSDE8Name());
        }
        if (!bl || this.isUtilPSDE9IdDirty()) {
            hashMap.put(FIELD_UTILPSDE9ID, this.getUtilPSDE9Id());
        }
        if (!bl || this.isUtilPSDE9NameDirty()) {
            hashMap.put(FIELD_UTILPSDE9NAME, this.getUtilPSDE9Name());
        }
        if (!bl || this.isUtilPSDEIdDirty()) {
            hashMap.put(FIELD_UTILPSDEID, this.getUtilPSDEId());
        }
        if (!bl || this.isUtilPSDENameDirty()) {
            hashMap.put(FIELD_UTILPSDENAME, this.getUtilPSDEName());
        }
        if (!bl || this.isUtilTagDirty()) {
            hashMap.put(FIELD_UTILTAG, this.getUtilTag());
        }
        if (!bl || this.isUtilTypeDirty()) {
            hashMap.put(FIELD_UTILTYPE, this.getUtilType());
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
        return PSAppUtilBase.get(this, n);
    }

    private static Object get(PSAppUtilBase pSAppUtilBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilBase.getCodeName();
            }
            case 1: {
                return pSAppUtilBase.getCreateDate();
            }
            case 2: {
                return pSAppUtilBase.getCreateMan();
            }
            case 3: {
                return pSAppUtilBase.getMemo();
            }
            case 4: {
                return pSAppUtilBase.getPSAppUtilId();
            }
            case 5: {
                return pSAppUtilBase.getPSAppUtilName();
            }
            case 6: {
                return pSAppUtilBase.getPSSysAppId();
            }
            case 7: {
                return pSAppUtilBase.getPSSysAppName();
            }
            case 8: {
                return pSAppUtilBase.getPSSysDynaModelId();
            }
            case 9: {
                return pSAppUtilBase.getPSSysDynaModelName();
            }
            case 10: {
                return pSAppUtilBase.getPSSysPFPluginId();
            }
            case 11: {
                return pSAppUtilBase.getPSSysPFPluginName();
            }
            case 12: {
                return pSAppUtilBase.getUpdateDate();
            }
            case 13: {
                return pSAppUtilBase.getUpdateMan();
            }
            case 14: {
                return pSAppUtilBase.getUserCat();
            }
            case 15: {
                return pSAppUtilBase.getUserTag();
            }
            case 16: {
                return pSAppUtilBase.getUserTag2();
            }
            case 17: {
                return pSAppUtilBase.getUserTag3();
            }
            case 18: {
                return pSAppUtilBase.getUserTag4();
            }
            case 19: {
                return pSAppUtilBase.getUtilObj();
            }
            case 20: {
                return pSAppUtilBase.getUtilParam();
            }
            case 21: {
                return pSAppUtilBase.getUtilParam10();
            }
            case 22: {
                return pSAppUtilBase.getUtilParam11();
            }
            case 23: {
                return pSAppUtilBase.getUtilParam12();
            }
            case 24: {
                return pSAppUtilBase.getUtilParam2();
            }
            case 25: {
                return pSAppUtilBase.getUtilParam3();
            }
            case 26: {
                return pSAppUtilBase.getUtilParam4();
            }
            case 27: {
                return pSAppUtilBase.getUtilParam5();
            }
            case 28: {
                return pSAppUtilBase.getUtilParam6();
            }
            case 29: {
                return pSAppUtilBase.getUtilParam7();
            }
            case 30: {
                return pSAppUtilBase.getUtilParam8();
            }
            case 31: {
                return pSAppUtilBase.getUtilParam9();
            }
            case 32: {
                return pSAppUtilBase.getUtilParams();
            }
            case 33: {
                return pSAppUtilBase.getUtilPSDE2Id();
            }
            case 34: {
                return pSAppUtilBase.getUtilPSDE2Name();
            }
            case 35: {
                return pSAppUtilBase.getUtilPSDE3Id();
            }
            case 36: {
                return pSAppUtilBase.getUtilPSDE3Name();
            }
            case 37: {
                return pSAppUtilBase.getUtilPSDE4Id();
            }
            case 38: {
                return pSAppUtilBase.getUtilPSDE4Name();
            }
            case 39: {
                return pSAppUtilBase.getUtilPSDE5Id();
            }
            case 40: {
                return pSAppUtilBase.getUtilPSDE5Name();
            }
            case 41: {
                return pSAppUtilBase.getUtilPSDE6Id();
            }
            case 42: {
                return pSAppUtilBase.getUtilPSDE6Name();
            }
            case 43: {
                return pSAppUtilBase.getUtilPSDE7Id();
            }
            case 44: {
                return pSAppUtilBase.getUtilPSDE7Name();
            }
            case 45: {
                return pSAppUtilBase.getUtilPSDE8Id();
            }
            case 46: {
                return pSAppUtilBase.getUtilPSDE8Name();
            }
            case 47: {
                return pSAppUtilBase.getUtilPSDE9Id();
            }
            case 48: {
                return pSAppUtilBase.getUtilPSDE9Name();
            }
            case 49: {
                return pSAppUtilBase.getUtilPSDEId();
            }
            case 50: {
                return pSAppUtilBase.getUtilPSDEName();
            }
            case 51: {
                return pSAppUtilBase.getUtilTag();
            }
            case 52: {
                return pSAppUtilBase.getUtilType();
            }
            case 53: {
                return pSAppUtilBase.getValidFlag();
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
        PSAppUtilBase.set(this, n, object);
    }

    private static void set(PSAppUtilBase pSAppUtilBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppUtilBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppUtilBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppUtilBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppUtilBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppUtilBase.setPSAppUtilId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppUtilBase.setPSAppUtilName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppUtilBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppUtilBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppUtilBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppUtilBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppUtilBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppUtilBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppUtilBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSAppUtilBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppUtilBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppUtilBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppUtilBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppUtilBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppUtilBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppUtilBase.setUtilObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppUtilBase.setUtilParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppUtilBase.setUtilParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSAppUtilBase.setUtilParam11(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppUtilBase.setUtilParam12(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppUtilBase.setUtilParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppUtilBase.setUtilParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppUtilBase.setUtilParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppUtilBase.setUtilParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSAppUtilBase.setUtilParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSAppUtilBase.setUtilParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSAppUtilBase.setUtilParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSAppUtilBase.setUtilParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSAppUtilBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppUtilBase.setUtilPSDE2Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppUtilBase.setUtilPSDE2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppUtilBase.setUtilPSDE3Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppUtilBase.setUtilPSDE3Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppUtilBase.setUtilPSDE4Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSAppUtilBase.setUtilPSDE4Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppUtilBase.setUtilPSDE5Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSAppUtilBase.setUtilPSDE5Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSAppUtilBase.setUtilPSDE6Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSAppUtilBase.setUtilPSDE6Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSAppUtilBase.setUtilPSDE7Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSAppUtilBase.setUtilPSDE7Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSAppUtilBase.setUtilPSDE8Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSAppUtilBase.setUtilPSDE8Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSAppUtilBase.setUtilPSDE9Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSAppUtilBase.setUtilPSDE9Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSAppUtilBase.setUtilPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSAppUtilBase.setUtilPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSAppUtilBase.setUtilTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSAppUtilBase.setUtilType(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSAppUtilBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppUtilBase.isNull(this, n);
    }

    private static boolean isNull(PSAppUtilBase pSAppUtilBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilBase.getCodeName() == null;
            }
            case 1: {
                return pSAppUtilBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppUtilBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppUtilBase.getMemo() == null;
            }
            case 4: {
                return pSAppUtilBase.getPSAppUtilId() == null;
            }
            case 5: {
                return pSAppUtilBase.getPSAppUtilName() == null;
            }
            case 6: {
                return pSAppUtilBase.getPSSysAppId() == null;
            }
            case 7: {
                return pSAppUtilBase.getPSSysAppName() == null;
            }
            case 8: {
                return pSAppUtilBase.getPSSysDynaModelId() == null;
            }
            case 9: {
                return pSAppUtilBase.getPSSysDynaModelName() == null;
            }
            case 10: {
                return pSAppUtilBase.getPSSysPFPluginId() == null;
            }
            case 11: {
                return pSAppUtilBase.getPSSysPFPluginName() == null;
            }
            case 12: {
                return pSAppUtilBase.getUpdateDate() == null;
            }
            case 13: {
                return pSAppUtilBase.getUpdateMan() == null;
            }
            case 14: {
                return pSAppUtilBase.getUserCat() == null;
            }
            case 15: {
                return pSAppUtilBase.getUserTag() == null;
            }
            case 16: {
                return pSAppUtilBase.getUserTag2() == null;
            }
            case 17: {
                return pSAppUtilBase.getUserTag3() == null;
            }
            case 18: {
                return pSAppUtilBase.getUserTag4() == null;
            }
            case 19: {
                return pSAppUtilBase.getUtilObj() == null;
            }
            case 20: {
                return pSAppUtilBase.getUtilParam() == null;
            }
            case 21: {
                return pSAppUtilBase.getUtilParam10() == null;
            }
            case 22: {
                return pSAppUtilBase.getUtilParam11() == null;
            }
            case 23: {
                return pSAppUtilBase.getUtilParam12() == null;
            }
            case 24: {
                return pSAppUtilBase.getUtilParam2() == null;
            }
            case 25: {
                return pSAppUtilBase.getUtilParam3() == null;
            }
            case 26: {
                return pSAppUtilBase.getUtilParam4() == null;
            }
            case 27: {
                return pSAppUtilBase.getUtilParam5() == null;
            }
            case 28: {
                return pSAppUtilBase.getUtilParam6() == null;
            }
            case 29: {
                return pSAppUtilBase.getUtilParam7() == null;
            }
            case 30: {
                return pSAppUtilBase.getUtilParam8() == null;
            }
            case 31: {
                return pSAppUtilBase.getUtilParam9() == null;
            }
            case 32: {
                return pSAppUtilBase.getUtilParams() == null;
            }
            case 33: {
                return pSAppUtilBase.getUtilPSDE2Id() == null;
            }
            case 34: {
                return pSAppUtilBase.getUtilPSDE2Name() == null;
            }
            case 35: {
                return pSAppUtilBase.getUtilPSDE3Id() == null;
            }
            case 36: {
                return pSAppUtilBase.getUtilPSDE3Name() == null;
            }
            case 37: {
                return pSAppUtilBase.getUtilPSDE4Id() == null;
            }
            case 38: {
                return pSAppUtilBase.getUtilPSDE4Name() == null;
            }
            case 39: {
                return pSAppUtilBase.getUtilPSDE5Id() == null;
            }
            case 40: {
                return pSAppUtilBase.getUtilPSDE5Name() == null;
            }
            case 41: {
                return pSAppUtilBase.getUtilPSDE6Id() == null;
            }
            case 42: {
                return pSAppUtilBase.getUtilPSDE6Name() == null;
            }
            case 43: {
                return pSAppUtilBase.getUtilPSDE7Id() == null;
            }
            case 44: {
                return pSAppUtilBase.getUtilPSDE7Name() == null;
            }
            case 45: {
                return pSAppUtilBase.getUtilPSDE8Id() == null;
            }
            case 46: {
                return pSAppUtilBase.getUtilPSDE8Name() == null;
            }
            case 47: {
                return pSAppUtilBase.getUtilPSDE9Id() == null;
            }
            case 48: {
                return pSAppUtilBase.getUtilPSDE9Name() == null;
            }
            case 49: {
                return pSAppUtilBase.getUtilPSDEId() == null;
            }
            case 50: {
                return pSAppUtilBase.getUtilPSDEName() == null;
            }
            case 51: {
                return pSAppUtilBase.getUtilTag() == null;
            }
            case 52: {
                return pSAppUtilBase.getUtilType() == null;
            }
            case 53: {
                return pSAppUtilBase.getValidFlag() == null;
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
        return PSAppUtilBase.contains(this, n);
    }

    private static boolean contains(PSAppUtilBase pSAppUtilBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppUtilBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppUtilBase.isCreateManDirty();
            }
            case 3: {
                return pSAppUtilBase.isMemoDirty();
            }
            case 4: {
                return pSAppUtilBase.isPSAppUtilIdDirty();
            }
            case 5: {
                return pSAppUtilBase.isPSAppUtilNameDirty();
            }
            case 6: {
                return pSAppUtilBase.isPSSysAppIdDirty();
            }
            case 7: {
                return pSAppUtilBase.isPSSysAppNameDirty();
            }
            case 8: {
                return pSAppUtilBase.isPSSysDynaModelIdDirty();
            }
            case 9: {
                return pSAppUtilBase.isPSSysDynaModelNameDirty();
            }
            case 10: {
                return pSAppUtilBase.isPSSysPFPluginIdDirty();
            }
            case 11: {
                return pSAppUtilBase.isPSSysPFPluginNameDirty();
            }
            case 12: {
                return pSAppUtilBase.isUpdateDateDirty();
            }
            case 13: {
                return pSAppUtilBase.isUpdateManDirty();
            }
            case 14: {
                return pSAppUtilBase.isUserCatDirty();
            }
            case 15: {
                return pSAppUtilBase.isUserTagDirty();
            }
            case 16: {
                return pSAppUtilBase.isUserTag2Dirty();
            }
            case 17: {
                return pSAppUtilBase.isUserTag3Dirty();
            }
            case 18: {
                return pSAppUtilBase.isUserTag4Dirty();
            }
            case 19: {
                return pSAppUtilBase.isUtilObjDirty();
            }
            case 20: {
                return pSAppUtilBase.isUtilParamDirty();
            }
            case 21: {
                return pSAppUtilBase.isUtilParam10Dirty();
            }
            case 22: {
                return pSAppUtilBase.isUtilParam11Dirty();
            }
            case 23: {
                return pSAppUtilBase.isUtilParam12Dirty();
            }
            case 24: {
                return pSAppUtilBase.isUtilParam2Dirty();
            }
            case 25: {
                return pSAppUtilBase.isUtilParam3Dirty();
            }
            case 26: {
                return pSAppUtilBase.isUtilParam4Dirty();
            }
            case 27: {
                return pSAppUtilBase.isUtilParam5Dirty();
            }
            case 28: {
                return pSAppUtilBase.isUtilParam6Dirty();
            }
            case 29: {
                return pSAppUtilBase.isUtilParam7Dirty();
            }
            case 30: {
                return pSAppUtilBase.isUtilParam8Dirty();
            }
            case 31: {
                return pSAppUtilBase.isUtilParam9Dirty();
            }
            case 32: {
                return pSAppUtilBase.isUtilParamsDirty();
            }
            case 33: {
                return pSAppUtilBase.isUtilPSDE2IdDirty();
            }
            case 34: {
                return pSAppUtilBase.isUtilPSDE2NameDirty();
            }
            case 35: {
                return pSAppUtilBase.isUtilPSDE3IdDirty();
            }
            case 36: {
                return pSAppUtilBase.isUtilPSDE3NameDirty();
            }
            case 37: {
                return pSAppUtilBase.isUtilPSDE4IdDirty();
            }
            case 38: {
                return pSAppUtilBase.isUtilPSDE4NameDirty();
            }
            case 39: {
                return pSAppUtilBase.isUtilPSDE5IdDirty();
            }
            case 40: {
                return pSAppUtilBase.isUtilPSDE5NameDirty();
            }
            case 41: {
                return pSAppUtilBase.isUtilPSDE6IdDirty();
            }
            case 42: {
                return pSAppUtilBase.isUtilPSDE6NameDirty();
            }
            case 43: {
                return pSAppUtilBase.isUtilPSDE7IdDirty();
            }
            case 44: {
                return pSAppUtilBase.isUtilPSDE7NameDirty();
            }
            case 45: {
                return pSAppUtilBase.isUtilPSDE8IdDirty();
            }
            case 46: {
                return pSAppUtilBase.isUtilPSDE8NameDirty();
            }
            case 47: {
                return pSAppUtilBase.isUtilPSDE9IdDirty();
            }
            case 48: {
                return pSAppUtilBase.isUtilPSDE9NameDirty();
            }
            case 49: {
                return pSAppUtilBase.isUtilPSDEIdDirty();
            }
            case 50: {
                return pSAppUtilBase.isUtilPSDENameDirty();
            }
            case 51: {
                return pSAppUtilBase.isUtilTagDirty();
            }
            case 52: {
                return pSAppUtilBase.isUtilTypeDirty();
            }
            case 53: {
                return pSAppUtilBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppUtilBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppUtilBase pSAppUtilBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppUtilBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getPSAppUtilId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputilid", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getPSAppUtilId()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getPSAppUtilName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputilname", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getPSAppUtilName()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilobj", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilObj()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam10", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam10()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam11", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam11()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam12", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam12()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam2", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam2()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam3", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam3()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam4", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam4()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam5", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam5()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam6", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam6()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam7", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam7()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam8", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam8()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam9", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParam9()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE2Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde2id", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE2Id()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde2name", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE2Name()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE3Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde3id", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE3Id()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE3Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde3name", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE3Name()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE4Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde4id", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE4Id()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE4Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde4name", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE4Name()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE5Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde5id", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE5Id()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE5Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde5name", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE5Name()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE6Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde6id", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE6Id()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE6Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde6name", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE6Name()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE7Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde7id", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE7Id()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE7Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde7name", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE7Name()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE8Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde8id", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE8Id()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE8Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde8name", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE8Name()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE9Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde9id", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE9Id()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDE9Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde9name", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDE9Name()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdeid", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDEId()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdename", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilPSDEName()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltag", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilTag()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getUtilType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltype", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getUtilType()), (boolean)false);
        }
        if (bl || pSAppUtilBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppUtilBase.getJSONValue((Object)pSAppUtilBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppUtilBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppUtilBase pSAppUtilBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppUtilBase.getCodeName() != null) {
            object = pSAppUtilBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getCreateDate() != null) {
            object = pSAppUtilBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUtilBase.getCreateMan() != null) {
            object = pSAppUtilBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getMemo() != null) {
            object = pSAppUtilBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getPSAppUtilId() != null) {
            object = pSAppUtilBase.getPSAppUtilId();
            xmlNode.setAttribute(FIELD_PSAPPUTILID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getPSAppUtilName() != null) {
            object = pSAppUtilBase.getPSAppUtilName();
            xmlNode.setAttribute(FIELD_PSAPPUTILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getPSSysAppId() != null) {
            object = pSAppUtilBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getPSSysAppName() != null) {
            object = pSAppUtilBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getPSSysDynaModelId() != null) {
            object = pSAppUtilBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getPSSysDynaModelName() != null) {
            object = pSAppUtilBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getPSSysPFPluginId() != null) {
            object = pSAppUtilBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getPSSysPFPluginName() != null) {
            object = pSAppUtilBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUpdateDate() != null) {
            object = pSAppUtilBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUtilBase.getUpdateMan() != null) {
            object = pSAppUtilBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUserCat() != null) {
            object = pSAppUtilBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUserTag() != null) {
            object = pSAppUtilBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUserTag2() != null) {
            object = pSAppUtilBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUserTag3() != null) {
            object = pSAppUtilBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUserTag4() != null) {
            object = pSAppUtilBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilObj() != null) {
            object = pSAppUtilBase.getUtilObj();
            xmlNode.setAttribute(FIELD_UTILOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilParam() != null) {
            object = pSAppUtilBase.getUtilParam();
            xmlNode.setAttribute(FIELD_UTILPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilParam10() != null) {
            object = pSAppUtilBase.getUtilParam10();
            xmlNode.setAttribute(FIELD_UTILPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUtilBase.getUtilParam11() != null) {
            object = pSAppUtilBase.getUtilParam11();
            xmlNode.setAttribute(FIELD_UTILPARAM11, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilParam12() != null) {
            object = pSAppUtilBase.getUtilParam12();
            xmlNode.setAttribute(FIELD_UTILPARAM12, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilParam2() != null) {
            object = pSAppUtilBase.getUtilParam2();
            xmlNode.setAttribute(FIELD_UTILPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilParam3() != null) {
            object = pSAppUtilBase.getUtilParam3();
            xmlNode.setAttribute(FIELD_UTILPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilParam4() != null) {
            object = pSAppUtilBase.getUtilParam4();
            xmlNode.setAttribute(FIELD_UTILPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilParam5() != null) {
            object = pSAppUtilBase.getUtilParam5();
            xmlNode.setAttribute(FIELD_UTILPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUtilBase.getUtilParam6() != null) {
            object = pSAppUtilBase.getUtilParam6();
            xmlNode.setAttribute(FIELD_UTILPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUtilBase.getUtilParam7() != null) {
            object = pSAppUtilBase.getUtilParam7();
            xmlNode.setAttribute(FIELD_UTILPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUtilBase.getUtilParam8() != null) {
            object = pSAppUtilBase.getUtilParam8();
            xmlNode.setAttribute(FIELD_UTILPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUtilBase.getUtilParam9() != null) {
            object = pSAppUtilBase.getUtilParam9();
            xmlNode.setAttribute(FIELD_UTILPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUtilBase.getUtilParams() != null) {
            object = pSAppUtilBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE2Id() != null) {
            object = pSAppUtilBase.getUtilPSDE2Id();
            xmlNode.setAttribute(FIELD_UTILPSDE2ID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE2Name() != null) {
            object = pSAppUtilBase.getUtilPSDE2Name();
            xmlNode.setAttribute(FIELD_UTILPSDE2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE3Id() != null) {
            object = pSAppUtilBase.getUtilPSDE3Id();
            xmlNode.setAttribute(FIELD_UTILPSDE3ID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE3Name() != null) {
            object = pSAppUtilBase.getUtilPSDE3Name();
            xmlNode.setAttribute(FIELD_UTILPSDE3NAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE4Id() != null) {
            object = pSAppUtilBase.getUtilPSDE4Id();
            xmlNode.setAttribute(FIELD_UTILPSDE4ID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE4Name() != null) {
            object = pSAppUtilBase.getUtilPSDE4Name();
            xmlNode.setAttribute(FIELD_UTILPSDE4NAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE5Id() != null) {
            object = pSAppUtilBase.getUtilPSDE5Id();
            xmlNode.setAttribute(FIELD_UTILPSDE5ID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE5Name() != null) {
            object = pSAppUtilBase.getUtilPSDE5Name();
            xmlNode.setAttribute(FIELD_UTILPSDE5NAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE6Id() != null) {
            object = pSAppUtilBase.getUtilPSDE6Id();
            xmlNode.setAttribute(FIELD_UTILPSDE6ID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE6Name() != null) {
            object = pSAppUtilBase.getUtilPSDE6Name();
            xmlNode.setAttribute(FIELD_UTILPSDE6NAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE7Id() != null) {
            object = pSAppUtilBase.getUtilPSDE7Id();
            xmlNode.setAttribute(FIELD_UTILPSDE7ID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE7Name() != null) {
            object = pSAppUtilBase.getUtilPSDE7Name();
            xmlNode.setAttribute(FIELD_UTILPSDE7NAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE8Id() != null) {
            object = pSAppUtilBase.getUtilPSDE8Id();
            xmlNode.setAttribute(FIELD_UTILPSDE8ID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE8Name() != null) {
            object = pSAppUtilBase.getUtilPSDE8Name();
            xmlNode.setAttribute(FIELD_UTILPSDE8NAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE9Id() != null) {
            object = pSAppUtilBase.getUtilPSDE9Id();
            xmlNode.setAttribute(FIELD_UTILPSDE9ID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDE9Name() != null) {
            object = pSAppUtilBase.getUtilPSDE9Name();
            xmlNode.setAttribute(FIELD_UTILPSDE9NAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDEId() != null) {
            object = pSAppUtilBase.getUtilPSDEId();
            xmlNode.setAttribute(FIELD_UTILPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilPSDEName() != null) {
            object = pSAppUtilBase.getUtilPSDEName();
            xmlNode.setAttribute(FIELD_UTILPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilTag() != null) {
            object = pSAppUtilBase.getUtilTag();
            xmlNode.setAttribute(FIELD_UTILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getUtilType() != null) {
            object = pSAppUtilBase.getUtilType();
            xmlNode.setAttribute(FIELD_UTILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilBase.getValidFlag() != null) {
            object = pSAppUtilBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppUtilBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppUtilBase pSAppUtilBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppUtilBase.isCodeNameDirty() && (bl || pSAppUtilBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppUtilBase.getCodeName());
        }
        if (pSAppUtilBase.isCreateDateDirty() && (bl || pSAppUtilBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppUtilBase.getCreateDate());
        }
        if (pSAppUtilBase.isCreateManDirty() && (bl || pSAppUtilBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppUtilBase.getCreateMan());
        }
        if (pSAppUtilBase.isMemoDirty() && (bl || pSAppUtilBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppUtilBase.getMemo());
        }
        if (pSAppUtilBase.isPSAppUtilIdDirty() && (bl || pSAppUtilBase.getPSAppUtilId() != null)) {
            iDataObject.set(FIELD_PSAPPUTILID, (Object)pSAppUtilBase.getPSAppUtilId());
        }
        if (pSAppUtilBase.isPSAppUtilNameDirty() && (bl || pSAppUtilBase.getPSAppUtilName() != null)) {
            iDataObject.set(FIELD_PSAPPUTILNAME, (Object)pSAppUtilBase.getPSAppUtilName());
        }
        if (pSAppUtilBase.isPSSysAppIdDirty() && (bl || pSAppUtilBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppUtilBase.getPSSysAppId());
        }
        if (pSAppUtilBase.isPSSysAppNameDirty() && (bl || pSAppUtilBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppUtilBase.getPSSysAppName());
        }
        if (pSAppUtilBase.isPSSysDynaModelIdDirty() && (bl || pSAppUtilBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSAppUtilBase.getPSSysDynaModelId());
        }
        if (pSAppUtilBase.isPSSysDynaModelNameDirty() && (bl || pSAppUtilBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSAppUtilBase.getPSSysDynaModelName());
        }
        if (pSAppUtilBase.isPSSysPFPluginIdDirty() && (bl || pSAppUtilBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppUtilBase.getPSSysPFPluginId());
        }
        if (pSAppUtilBase.isPSSysPFPluginNameDirty() && (bl || pSAppUtilBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppUtilBase.getPSSysPFPluginName());
        }
        if (pSAppUtilBase.isUpdateDateDirty() && (bl || pSAppUtilBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppUtilBase.getUpdateDate());
        }
        if (pSAppUtilBase.isUpdateManDirty() && (bl || pSAppUtilBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppUtilBase.getUpdateMan());
        }
        if (pSAppUtilBase.isUserCatDirty() && (bl || pSAppUtilBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppUtilBase.getUserCat());
        }
        if (pSAppUtilBase.isUserTagDirty() && (bl || pSAppUtilBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppUtilBase.getUserTag());
        }
        if (pSAppUtilBase.isUserTag2Dirty() && (bl || pSAppUtilBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppUtilBase.getUserTag2());
        }
        if (pSAppUtilBase.isUserTag3Dirty() && (bl || pSAppUtilBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppUtilBase.getUserTag3());
        }
        if (pSAppUtilBase.isUserTag4Dirty() && (bl || pSAppUtilBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppUtilBase.getUserTag4());
        }
        if (pSAppUtilBase.isUtilObjDirty() && (bl || pSAppUtilBase.getUtilObj() != null)) {
            iDataObject.set(FIELD_UTILOBJ, (Object)pSAppUtilBase.getUtilObj());
        }
        if (pSAppUtilBase.isUtilParamDirty() && (bl || pSAppUtilBase.getUtilParam() != null)) {
            iDataObject.set(FIELD_UTILPARAM, (Object)pSAppUtilBase.getUtilParam());
        }
        if (pSAppUtilBase.isUtilParam10Dirty() && (bl || pSAppUtilBase.getUtilParam10() != null)) {
            iDataObject.set(FIELD_UTILPARAM10, (Object)pSAppUtilBase.getUtilParam10());
        }
        if (pSAppUtilBase.isUtilParam11Dirty() && (bl || pSAppUtilBase.getUtilParam11() != null)) {
            iDataObject.set(FIELD_UTILPARAM11, (Object)pSAppUtilBase.getUtilParam11());
        }
        if (pSAppUtilBase.isUtilParam12Dirty() && (bl || pSAppUtilBase.getUtilParam12() != null)) {
            iDataObject.set(FIELD_UTILPARAM12, (Object)pSAppUtilBase.getUtilParam12());
        }
        if (pSAppUtilBase.isUtilParam2Dirty() && (bl || pSAppUtilBase.getUtilParam2() != null)) {
            iDataObject.set(FIELD_UTILPARAM2, (Object)pSAppUtilBase.getUtilParam2());
        }
        if (pSAppUtilBase.isUtilParam3Dirty() && (bl || pSAppUtilBase.getUtilParam3() != null)) {
            iDataObject.set(FIELD_UTILPARAM3, (Object)pSAppUtilBase.getUtilParam3());
        }
        if (pSAppUtilBase.isUtilParam4Dirty() && (bl || pSAppUtilBase.getUtilParam4() != null)) {
            iDataObject.set(FIELD_UTILPARAM4, (Object)pSAppUtilBase.getUtilParam4());
        }
        if (pSAppUtilBase.isUtilParam5Dirty() && (bl || pSAppUtilBase.getUtilParam5() != null)) {
            iDataObject.set(FIELD_UTILPARAM5, (Object)pSAppUtilBase.getUtilParam5());
        }
        if (pSAppUtilBase.isUtilParam6Dirty() && (bl || pSAppUtilBase.getUtilParam6() != null)) {
            iDataObject.set(FIELD_UTILPARAM6, (Object)pSAppUtilBase.getUtilParam6());
        }
        if (pSAppUtilBase.isUtilParam7Dirty() && (bl || pSAppUtilBase.getUtilParam7() != null)) {
            iDataObject.set(FIELD_UTILPARAM7, (Object)pSAppUtilBase.getUtilParam7());
        }
        if (pSAppUtilBase.isUtilParam8Dirty() && (bl || pSAppUtilBase.getUtilParam8() != null)) {
            iDataObject.set(FIELD_UTILPARAM8, (Object)pSAppUtilBase.getUtilParam8());
        }
        if (pSAppUtilBase.isUtilParam9Dirty() && (bl || pSAppUtilBase.getUtilParam9() != null)) {
            iDataObject.set(FIELD_UTILPARAM9, (Object)pSAppUtilBase.getUtilParam9());
        }
        if (pSAppUtilBase.isUtilParamsDirty() && (bl || pSAppUtilBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSAppUtilBase.getUtilParams());
        }
        if (pSAppUtilBase.isUtilPSDE2IdDirty() && (bl || pSAppUtilBase.getUtilPSDE2Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE2ID, (Object)pSAppUtilBase.getUtilPSDE2Id());
        }
        if (pSAppUtilBase.isUtilPSDE2NameDirty() && (bl || pSAppUtilBase.getUtilPSDE2Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE2NAME, (Object)pSAppUtilBase.getUtilPSDE2Name());
        }
        if (pSAppUtilBase.isUtilPSDE3IdDirty() && (bl || pSAppUtilBase.getUtilPSDE3Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE3ID, (Object)pSAppUtilBase.getUtilPSDE3Id());
        }
        if (pSAppUtilBase.isUtilPSDE3NameDirty() && (bl || pSAppUtilBase.getUtilPSDE3Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE3NAME, (Object)pSAppUtilBase.getUtilPSDE3Name());
        }
        if (pSAppUtilBase.isUtilPSDE4IdDirty() && (bl || pSAppUtilBase.getUtilPSDE4Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE4ID, (Object)pSAppUtilBase.getUtilPSDE4Id());
        }
        if (pSAppUtilBase.isUtilPSDE4NameDirty() && (bl || pSAppUtilBase.getUtilPSDE4Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE4NAME, (Object)pSAppUtilBase.getUtilPSDE4Name());
        }
        if (pSAppUtilBase.isUtilPSDE5IdDirty() && (bl || pSAppUtilBase.getUtilPSDE5Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE5ID, (Object)pSAppUtilBase.getUtilPSDE5Id());
        }
        if (pSAppUtilBase.isUtilPSDE5NameDirty() && (bl || pSAppUtilBase.getUtilPSDE5Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE5NAME, (Object)pSAppUtilBase.getUtilPSDE5Name());
        }
        if (pSAppUtilBase.isUtilPSDE6IdDirty() && (bl || pSAppUtilBase.getUtilPSDE6Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE6ID, (Object)pSAppUtilBase.getUtilPSDE6Id());
        }
        if (pSAppUtilBase.isUtilPSDE6NameDirty() && (bl || pSAppUtilBase.getUtilPSDE6Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE6NAME, (Object)pSAppUtilBase.getUtilPSDE6Name());
        }
        if (pSAppUtilBase.isUtilPSDE7IdDirty() && (bl || pSAppUtilBase.getUtilPSDE7Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE7ID, (Object)pSAppUtilBase.getUtilPSDE7Id());
        }
        if (pSAppUtilBase.isUtilPSDE7NameDirty() && (bl || pSAppUtilBase.getUtilPSDE7Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE7NAME, (Object)pSAppUtilBase.getUtilPSDE7Name());
        }
        if (pSAppUtilBase.isUtilPSDE8IdDirty() && (bl || pSAppUtilBase.getUtilPSDE8Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE8ID, (Object)pSAppUtilBase.getUtilPSDE8Id());
        }
        if (pSAppUtilBase.isUtilPSDE8NameDirty() && (bl || pSAppUtilBase.getUtilPSDE8Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE8NAME, (Object)pSAppUtilBase.getUtilPSDE8Name());
        }
        if (pSAppUtilBase.isUtilPSDE9IdDirty() && (bl || pSAppUtilBase.getUtilPSDE9Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE9ID, (Object)pSAppUtilBase.getUtilPSDE9Id());
        }
        if (pSAppUtilBase.isUtilPSDE9NameDirty() && (bl || pSAppUtilBase.getUtilPSDE9Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE9NAME, (Object)pSAppUtilBase.getUtilPSDE9Name());
        }
        if (pSAppUtilBase.isUtilPSDEIdDirty() && (bl || pSAppUtilBase.getUtilPSDEId() != null)) {
            iDataObject.set(FIELD_UTILPSDEID, (Object)pSAppUtilBase.getUtilPSDEId());
        }
        if (pSAppUtilBase.isUtilPSDENameDirty() && (bl || pSAppUtilBase.getUtilPSDEName() != null)) {
            iDataObject.set(FIELD_UTILPSDENAME, (Object)pSAppUtilBase.getUtilPSDEName());
        }
        if (pSAppUtilBase.isUtilTagDirty() && (bl || pSAppUtilBase.getUtilTag() != null)) {
            iDataObject.set(FIELD_UTILTAG, (Object)pSAppUtilBase.getUtilTag());
        }
        if (pSAppUtilBase.isUtilTypeDirty() && (bl || pSAppUtilBase.getUtilType() != null)) {
            iDataObject.set(FIELD_UTILTYPE, (Object)pSAppUtilBase.getUtilType());
        }
        if (pSAppUtilBase.isValidFlagDirty() && (bl || pSAppUtilBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppUtilBase.getValidFlag());
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
        return PSAppUtilBase.remove(this, n);
    }

    private static boolean remove(PSAppUtilBase pSAppUtilBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppUtilBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppUtilBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppUtilBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppUtilBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppUtilBase.resetPSAppUtilId();
                return true;
            }
            case 5: {
                pSAppUtilBase.resetPSAppUtilName();
                return true;
            }
            case 6: {
                pSAppUtilBase.resetPSSysAppId();
                return true;
            }
            case 7: {
                pSAppUtilBase.resetPSSysAppName();
                return true;
            }
            case 8: {
                pSAppUtilBase.resetPSSysDynaModelId();
                return true;
            }
            case 9: {
                pSAppUtilBase.resetPSSysDynaModelName();
                return true;
            }
            case 10: {
                pSAppUtilBase.resetPSSysPFPluginId();
                return true;
            }
            case 11: {
                pSAppUtilBase.resetPSSysPFPluginName();
                return true;
            }
            case 12: {
                pSAppUtilBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSAppUtilBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSAppUtilBase.resetUserCat();
                return true;
            }
            case 15: {
                pSAppUtilBase.resetUserTag();
                return true;
            }
            case 16: {
                pSAppUtilBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSAppUtilBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSAppUtilBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSAppUtilBase.resetUtilObj();
                return true;
            }
            case 20: {
                pSAppUtilBase.resetUtilParam();
                return true;
            }
            case 21: {
                pSAppUtilBase.resetUtilParam10();
                return true;
            }
            case 22: {
                pSAppUtilBase.resetUtilParam11();
                return true;
            }
            case 23: {
                pSAppUtilBase.resetUtilParam12();
                return true;
            }
            case 24: {
                pSAppUtilBase.resetUtilParam2();
                return true;
            }
            case 25: {
                pSAppUtilBase.resetUtilParam3();
                return true;
            }
            case 26: {
                pSAppUtilBase.resetUtilParam4();
                return true;
            }
            case 27: {
                pSAppUtilBase.resetUtilParam5();
                return true;
            }
            case 28: {
                pSAppUtilBase.resetUtilParam6();
                return true;
            }
            case 29: {
                pSAppUtilBase.resetUtilParam7();
                return true;
            }
            case 30: {
                pSAppUtilBase.resetUtilParam8();
                return true;
            }
            case 31: {
                pSAppUtilBase.resetUtilParam9();
                return true;
            }
            case 32: {
                pSAppUtilBase.resetUtilParams();
                return true;
            }
            case 33: {
                pSAppUtilBase.resetUtilPSDE2Id();
                return true;
            }
            case 34: {
                pSAppUtilBase.resetUtilPSDE2Name();
                return true;
            }
            case 35: {
                pSAppUtilBase.resetUtilPSDE3Id();
                return true;
            }
            case 36: {
                pSAppUtilBase.resetUtilPSDE3Name();
                return true;
            }
            case 37: {
                pSAppUtilBase.resetUtilPSDE4Id();
                return true;
            }
            case 38: {
                pSAppUtilBase.resetUtilPSDE4Name();
                return true;
            }
            case 39: {
                pSAppUtilBase.resetUtilPSDE5Id();
                return true;
            }
            case 40: {
                pSAppUtilBase.resetUtilPSDE5Name();
                return true;
            }
            case 41: {
                pSAppUtilBase.resetUtilPSDE6Id();
                return true;
            }
            case 42: {
                pSAppUtilBase.resetUtilPSDE6Name();
                return true;
            }
            case 43: {
                pSAppUtilBase.resetUtilPSDE7Id();
                return true;
            }
            case 44: {
                pSAppUtilBase.resetUtilPSDE7Name();
                return true;
            }
            case 45: {
                pSAppUtilBase.resetUtilPSDE8Id();
                return true;
            }
            case 46: {
                pSAppUtilBase.resetUtilPSDE8Name();
                return true;
            }
            case 47: {
                pSAppUtilBase.resetUtilPSDE9Id();
                return true;
            }
            case 48: {
                pSAppUtilBase.resetUtilPSDE9Name();
                return true;
            }
            case 49: {
                pSAppUtilBase.resetUtilPSDEId();
                return true;
            }
            case 50: {
                pSAppUtilBase.resetUtilPSDEName();
                return true;
            }
            case 51: {
                pSAppUtilBase.resetUtilTag();
                return true;
            }
            case 52: {
                pSAppUtilBase.resetUtilType();
                return true;
            }
            case 53: {
                pSAppUtilBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE2();
        }
        if (this.getUtilPSDE2Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE2Lock;
        synchronized (n) {
            if (this.utilpsde2 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE2Id(), (Object)this.utilpsde2.getPSDataEntityId()) != 0L) {
                this.utilpsde2 = null;
            }
            if (this.utilpsde2 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE2Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde2 = pSDataEntity;
            }
            return this.utilpsde2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE3() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE3();
        }
        if (this.getUtilPSDE3Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE3Lock;
        synchronized (n) {
            if (this.utilpsde3 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE3Id(), (Object)this.utilpsde3.getPSDataEntityId()) != 0L) {
                this.utilpsde3 = null;
            }
            if (this.utilpsde3 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE3Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde3 = pSDataEntity;
            }
            return this.utilpsde3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE4() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE4();
        }
        if (this.getUtilPSDE4Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE4Lock;
        synchronized (n) {
            if (this.utilpsde4 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE4Id(), (Object)this.utilpsde4.getPSDataEntityId()) != 0L) {
                this.utilpsde4 = null;
            }
            if (this.utilpsde4 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE4Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde4 = pSDataEntity;
            }
            return this.utilpsde4;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE5() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE5();
        }
        if (this.getUtilPSDE5Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE5Lock;
        synchronized (n) {
            if (this.utilpsde5 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE5Id(), (Object)this.utilpsde5.getPSDataEntityId()) != 0L) {
                this.utilpsde5 = null;
            }
            if (this.utilpsde5 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE5Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde5 = pSDataEntity;
            }
            return this.utilpsde5;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE6() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE6();
        }
        if (this.getUtilPSDE6Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE6Lock;
        synchronized (n) {
            if (this.utilpsde6 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE6Id(), (Object)this.utilpsde6.getPSDataEntityId()) != 0L) {
                this.utilpsde6 = null;
            }
            if (this.utilpsde6 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE6Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde6 = pSDataEntity;
            }
            return this.utilpsde6;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE7() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE7();
        }
        if (this.getUtilPSDE7Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE7Lock;
        synchronized (n) {
            if (this.utilpsde7 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE7Id(), (Object)this.utilpsde7.getPSDataEntityId()) != 0L) {
                this.utilpsde7 = null;
            }
            if (this.utilpsde7 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE7Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde7 = pSDataEntity;
            }
            return this.utilpsde7;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE8() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE8();
        }
        if (this.getUtilPSDE8Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE8Lock;
        synchronized (n) {
            if (this.utilpsde8 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE8Id(), (Object)this.utilpsde8.getPSDataEntityId()) != 0L) {
                this.utilpsde8 = null;
            }
            if (this.utilpsde8 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE8Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde8 = pSDataEntity;
            }
            return this.utilpsde8;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE9() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE9();
        }
        if (this.getUtilPSDE9Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE9Lock;
        synchronized (n) {
            if (this.utilpsde9 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE9Id(), (Object)this.utilpsde9.getPSDataEntityId()) != 0L) {
                this.utilpsde9 = null;
            }
            if (this.utilpsde9 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE9Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde9 = pSDataEntity;
            }
            return this.utilpsde9;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE();
        }
        if (this.getUtilPSDEId() == null) {
            return null;
        }
        Integer n = this.objUtilPSDELock;
        synchronized (n) {
            if (this.utilpsde != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDEId(), (Object)this.utilpsde.getPSDataEntityId()) != 0L) {
                this.utilpsde = null;
            }
            if (this.utilpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.utilpsde = pSDataEntity;
            }
            return this.utilpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    private PSAppUtilBase getProxyEntity() {
        return this.proxyPSAppUtilBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppUtilBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppUtilBase) {
            this.proxyPSAppUtilBase = (PSAppUtilBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUtilService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAPPUTILID, 4);
        fieldIndexMap.put(FIELD_PSAPPUTILNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 8);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 10);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_UTILOBJ, 19);
        fieldIndexMap.put(FIELD_UTILPARAM, 20);
        fieldIndexMap.put(FIELD_UTILPARAM10, 21);
        fieldIndexMap.put(FIELD_UTILPARAM11, 22);
        fieldIndexMap.put(FIELD_UTILPARAM12, 23);
        fieldIndexMap.put(FIELD_UTILPARAM2, 24);
        fieldIndexMap.put(FIELD_UTILPARAM3, 25);
        fieldIndexMap.put(FIELD_UTILPARAM4, 26);
        fieldIndexMap.put(FIELD_UTILPARAM5, 27);
        fieldIndexMap.put(FIELD_UTILPARAM6, 28);
        fieldIndexMap.put(FIELD_UTILPARAM7, 29);
        fieldIndexMap.put(FIELD_UTILPARAM8, 30);
        fieldIndexMap.put(FIELD_UTILPARAM9, 31);
        fieldIndexMap.put(FIELD_UTILPARAMS, 32);
        fieldIndexMap.put(FIELD_UTILPSDE2ID, 33);
        fieldIndexMap.put(FIELD_UTILPSDE2NAME, 34);
        fieldIndexMap.put(FIELD_UTILPSDE3ID, 35);
        fieldIndexMap.put(FIELD_UTILPSDE3NAME, 36);
        fieldIndexMap.put(FIELD_UTILPSDE4ID, 37);
        fieldIndexMap.put(FIELD_UTILPSDE4NAME, 38);
        fieldIndexMap.put(FIELD_UTILPSDE5ID, 39);
        fieldIndexMap.put(FIELD_UTILPSDE5NAME, 40);
        fieldIndexMap.put(FIELD_UTILPSDE6ID, 41);
        fieldIndexMap.put(FIELD_UTILPSDE6NAME, 42);
        fieldIndexMap.put(FIELD_UTILPSDE7ID, 43);
        fieldIndexMap.put(FIELD_UTILPSDE7NAME, 44);
        fieldIndexMap.put(FIELD_UTILPSDE8ID, 45);
        fieldIndexMap.put(FIELD_UTILPSDE8NAME, 46);
        fieldIndexMap.put(FIELD_UTILPSDE9ID, 47);
        fieldIndexMap.put(FIELD_UTILPSDE9NAME, 48);
        fieldIndexMap.put(FIELD_UTILPSDEID, 49);
        fieldIndexMap.put(FIELD_UTILPSDENAME, 50);
        fieldIndexMap.put(FIELD_UTILTAG, 51);
        fieldIndexMap.put(FIELD_UTILTYPE, 52);
        fieldIndexMap.put(FIELD_VALIDFLAG, 53);
    }
}

