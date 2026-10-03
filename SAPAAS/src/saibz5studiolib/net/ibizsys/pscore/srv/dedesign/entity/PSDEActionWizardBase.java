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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionWizardBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEActionWizardBase.class);
    public static final String FIELD_AWICONTENTPSDEFID = "AWICONTENTPSDEFID";
    public static final String FIELD_AWICONTENTPSDEFNAME = "AWICONTENTPSDEFNAME";
    public static final String FIELD_AWIFKEYPSDEFID = "AWIFKEYPSDEFID";
    public static final String FIELD_AWIFKEYPSDEFNAME = "AWIFKEYPSDEFNAME";
    public static final String FIELD_AWINAMEPSDEFID = "AWINAMEPSDEFID";
    public static final String FIELD_AWINAMEPSDEFNAME = "AWINAMEPSDEFNAME";
    public static final String FIELD_AWIPSDEDSID = "AWIPSDEDSID";
    public static final String FIELD_AWIPSDEDSNAME = "AWIPSDEDSNAME";
    public static final String FIELD_AWIPSDEID = "AWIPSDEID";
    public static final String FIELD_AWIPSDENAME = "AWIPSDENAME";
    public static final String FIELD_AWISORTPSDEFID = "AWISORTPSDEFID";
    public static final String FIELD_AWISORTPSDEFNAME = "AWISORTPSDEFNAME";
    public static final String FIELD_AWIURLPSDEFID = "AWIURLPSDEFID";
    public static final String FIELD_AWIURLPSDEFNAME = "AWIURLPSDEFNAME";
    public static final String FIELD_AWIVALUEPSDEFID = "AWIVALUEPSDEFID";
    public static final String FIELD_AWIVALUEPSDEFNAME = "AWIVALUEPSDEFNAME";
    public static final String FIELD_AWKWPSDEFID = "AWKWPSDEFID";
    public static final String FIELD_AWKWPSDEFNAME = "AWKWPSDEFNAME";
    public static final String FIELD_AWNAMEPSDEFID = "AWNAMEPSDEFID";
    public static final String FIELD_AWNAMEPSDEFNAME = "AWNAMEPSDEFNAME";
    public static final String FIELD_AWPSDEDSID = "AWPSDEDSID";
    public static final String FIELD_AWPSDEDSNAME = "AWPSDEDSNAME";
    public static final String FIELD_AWPSDEID = "AWPSDEID";
    public static final String FIELD_AWPSDENAME = "AWPSDENAME";
    public static final String FIELD_AWSORTPSDEFID = "AWSORTPSDEFID";
    public static final String FIELD_AWSORTPSDEFNAME = "AWSORTPSDEFNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMICMODE = "DYNAMICMODE";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEACTIONWIZARDID = "PSDEACTIONWIZARDID";
    public static final String FIELD_PSDEACTIONWIZARDNAME = "PSDEACTIONWIZARDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AWICONTENTPSDEFID = 0;
    private static final int INDEX_AWICONTENTPSDEFNAME = 1;
    private static final int INDEX_AWIFKEYPSDEFID = 2;
    private static final int INDEX_AWIFKEYPSDEFNAME = 3;
    private static final int INDEX_AWINAMEPSDEFID = 4;
    private static final int INDEX_AWINAMEPSDEFNAME = 5;
    private static final int INDEX_AWIPSDEDSID = 6;
    private static final int INDEX_AWIPSDEDSNAME = 7;
    private static final int INDEX_AWIPSDEID = 8;
    private static final int INDEX_AWIPSDENAME = 9;
    private static final int INDEX_AWISORTPSDEFID = 10;
    private static final int INDEX_AWISORTPSDEFNAME = 11;
    private static final int INDEX_AWIURLPSDEFID = 12;
    private static final int INDEX_AWIURLPSDEFNAME = 13;
    private static final int INDEX_AWIVALUEPSDEFID = 14;
    private static final int INDEX_AWIVALUEPSDEFNAME = 15;
    private static final int INDEX_AWKWPSDEFID = 16;
    private static final int INDEX_AWKWPSDEFNAME = 17;
    private static final int INDEX_AWNAMEPSDEFID = 18;
    private static final int INDEX_AWNAMEPSDEFNAME = 19;
    private static final int INDEX_AWPSDEDSID = 20;
    private static final int INDEX_AWPSDEDSNAME = 21;
    private static final int INDEX_AWPSDEID = 22;
    private static final int INDEX_AWPSDENAME = 23;
    private static final int INDEX_AWSORTPSDEFID = 24;
    private static final int INDEX_AWSORTPSDEFNAME = 25;
    private static final int INDEX_CODENAME = 26;
    private static final int INDEX_CREATEDATE = 27;
    private static final int INDEX_CREATEMAN = 28;
    private static final int INDEX_DYNAMICMODE = 29;
    private static final int INDEX_KEYWORDS = 30;
    private static final int INDEX_LOCKFLAG = 31;
    private static final int INDEX_MEMO = 32;
    private static final int INDEX_PSDEACTIONWIZARDID = 33;
    private static final int INDEX_PSDEACTIONWIZARDNAME = 34;
    private static final int INDEX_PSDEID = 35;
    private static final int INDEX_PSDENAME = 36;
    private static final int INDEX_PSDEVIEWBASEID = 37;
    private static final int INDEX_PSDEVIEWBASENAME = 38;
    private static final int INDEX_UPDATEDATE = 39;
    private static final int INDEX_UPDATEMAN = 40;
    private static final int INDEX_USERCAT = 41;
    private static final int INDEX_USERTAG = 42;
    private static final int INDEX_USERTAG2 = 43;
    private static final int INDEX_USERTAG3 = 44;
    private static final int INDEX_USERTAG4 = 45;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEActionWizardBase proxyPSDEActionWizardBase = null;
    private boolean awicontentpsdefidDirtyFlag = false;
    private boolean awicontentpsdefnameDirtyFlag = false;
    private boolean awifkeypsdefidDirtyFlag = false;
    private boolean awifkeypsdefnameDirtyFlag = false;
    private boolean awinamepsdefidDirtyFlag = false;
    private boolean awinamepsdefnameDirtyFlag = false;
    private boolean awipsdedsidDirtyFlag = false;
    private boolean awipsdedsnameDirtyFlag = false;
    private boolean awipsdeidDirtyFlag = false;
    private boolean awipsdenameDirtyFlag = false;
    private boolean awisortpsdefidDirtyFlag = false;
    private boolean awisortpsdefnameDirtyFlag = false;
    private boolean awiurlpsdefidDirtyFlag = false;
    private boolean awiurlpsdefnameDirtyFlag = false;
    private boolean awivaluepsdefidDirtyFlag = false;
    private boolean awivaluepsdefnameDirtyFlag = false;
    private boolean awkwpsdefidDirtyFlag = false;
    private boolean awkwpsdefnameDirtyFlag = false;
    private boolean awnamepsdefidDirtyFlag = false;
    private boolean awnamepsdefnameDirtyFlag = false;
    private boolean awpsdedsidDirtyFlag = false;
    private boolean awpsdedsnameDirtyFlag = false;
    private boolean awpsdeidDirtyFlag = false;
    private boolean awpsdenameDirtyFlag = false;
    private boolean awsortpsdefidDirtyFlag = false;
    private boolean awsortpsdefnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamicmodeDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeactionwizardidDirtyFlag = false;
    private boolean psdeactionwizardnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="awicontentpsdefid")
    private String awicontentpsdefid;
    @Column(name="awicontentpsdefname")
    private String awicontentpsdefname;
    @Column(name="awifkeypsdefid")
    private String awifkeypsdefid;
    @Column(name="awifkeypsdefname")
    private String awifkeypsdefname;
    @Column(name="awinamepsdefid")
    private String awinamepsdefid;
    @Column(name="awinamepsdefname")
    private String awinamepsdefname;
    @Column(name="awipsdedsid")
    private String awipsdedsid;
    @Column(name="awipsdedsname")
    private String awipsdedsname;
    @Column(name="awipsdeid")
    private String awipsdeid;
    @Column(name="awipsdename")
    private String awipsdename;
    @Column(name="awisortpsdefid")
    private String awisortpsdefid;
    @Column(name="awisortpsdefname")
    private String awisortpsdefname;
    @Column(name="awiurlpsdefid")
    private String awiurlpsdefid;
    @Column(name="awiurlpsdefname")
    private String awiurlpsdefname;
    @Column(name="awivaluepsdefid")
    private String awivaluepsdefid;
    @Column(name="awivaluepsdefname")
    private String awivaluepsdefname;
    @Column(name="awkwpsdefid")
    private String awkwpsdefid;
    @Column(name="awkwpsdefname")
    private String awkwpsdefname;
    @Column(name="awnamepsdefid")
    private String awnamepsdefid;
    @Column(name="awnamepsdefname")
    private String awnamepsdefname;
    @Column(name="awpsdedsid")
    private String awpsdedsid;
    @Column(name="awpsdedsname")
    private String awpsdedsname;
    @Column(name="awpsdeid")
    private String awpsdeid;
    @Column(name="awpsdename")
    private String awpsdename;
    @Column(name="awsortpsdefid")
    private String awsortpsdefid;
    @Column(name="awsortpsdefname")
    private String awsortpsdefname;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamicmode")
    private Integer dynamicmode;
    @Column(name="keywords")
    private String keywords;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeactionwizardid")
    private String psdeactionwizardid;
    @Column(name="psdeactionwizardname")
    private String psdeactionwizardname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
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
    private Integer objAWIPSDELock = new Integer(1);
    private PSDataEntity awipsde = null;
    private Integer objAWPSDELock = new Integer(1);
    private PSDataEntity awpsde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objAWIPSDEDSLock = new Integer(1);
    private PSDEDataSet awipsdeds = null;
    private Integer objAWPSDEDSLock = new Integer(1);
    private PSDEDataSet awpsdeds = null;
    private Integer objAWIContentPSDEFLock = new Integer(1);
    private PSDEField awicontentpsdef = null;
    private Integer objAWIFKeyPSDEFLock = new Integer(1);
    private PSDEField awifkeypsdef = null;
    private Integer objAWINamePSDEFLock = new Integer(1);
    private PSDEField awinamepsdef = null;
    private Integer objAWISortPSDEFLock = new Integer(1);
    private PSDEField awisortpsdef = null;
    private Integer objAWIUrlPSDEFLock = new Integer(1);
    private PSDEField awiurlpsdef = null;
    private Integer objAWIValuePSDEFLock = new Integer(1);
    private PSDEField awivaluepsdef = null;
    private Integer objAWKWPSDEFLock = new Integer(1);
    private PSDEField awkwpsdef = null;
    private Integer objAWNamePSDEFLock = new Integer(1);
    private PSDEField awnamepsdef = null;
    private Integer objAWSortPSDEFLock = new Integer(1);
    private PSDEField awsortpsdef = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objPSDEAWItemsLock = new Integer(1);
    private ArrayList<PSDEAWItem> psdeawitems = null;

    public void setAWIContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awicontentpsdefid = string;
        this.awicontentpsdefidDirtyFlag = true;
    }

    public String getAWIContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIContentPSDEFId();
        }
        return this.awicontentpsdefid;
    }

    public boolean isAWIContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIContentPSDEFIdDirty();
        }
        return this.awicontentpsdefidDirtyFlag;
    }

    public void resetAWIContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIContentPSDEFId();
            return;
        }
        this.awicontentpsdefidDirtyFlag = false;
        this.awicontentpsdefid = null;
    }

    public void setAWIContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awicontentpsdefname = string;
        this.awicontentpsdefnameDirtyFlag = true;
    }

    public String getAWIContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIContentPSDEFName();
        }
        return this.awicontentpsdefname;
    }

    public boolean isAWIContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIContentPSDEFNameDirty();
        }
        return this.awicontentpsdefnameDirtyFlag;
    }

    public void resetAWIContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIContentPSDEFName();
            return;
        }
        this.awicontentpsdefnameDirtyFlag = false;
        this.awicontentpsdefname = null;
    }

    public void setAWIFKeyPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIFKeyPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awifkeypsdefid = string;
        this.awifkeypsdefidDirtyFlag = true;
    }

    public String getAWIFKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIFKeyPSDEFId();
        }
        return this.awifkeypsdefid;
    }

    public boolean isAWIFKeyPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIFKeyPSDEFIdDirty();
        }
        return this.awifkeypsdefidDirtyFlag;
    }

    public void resetAWIFKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIFKeyPSDEFId();
            return;
        }
        this.awifkeypsdefidDirtyFlag = false;
        this.awifkeypsdefid = null;
    }

    public void setAWIFKeyPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIFKeyPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awifkeypsdefname = string;
        this.awifkeypsdefnameDirtyFlag = true;
    }

    public String getAWIFKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIFKeyPSDEFName();
        }
        return this.awifkeypsdefname;
    }

    public boolean isAWIFKeyPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIFKeyPSDEFNameDirty();
        }
        return this.awifkeypsdefnameDirtyFlag;
    }

    public void resetAWIFKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIFKeyPSDEFName();
            return;
        }
        this.awifkeypsdefnameDirtyFlag = false;
        this.awifkeypsdefname = null;
    }

    public void setAWINamePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWINamePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awinamepsdefid = string;
        this.awinamepsdefidDirtyFlag = true;
    }

    public String getAWINamePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWINamePSDEFId();
        }
        return this.awinamepsdefid;
    }

    public boolean isAWINamePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWINamePSDEFIdDirty();
        }
        return this.awinamepsdefidDirtyFlag;
    }

    public void resetAWINamePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWINamePSDEFId();
            return;
        }
        this.awinamepsdefidDirtyFlag = false;
        this.awinamepsdefid = null;
    }

    public void setAWINamePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWINamePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awinamepsdefname = string;
        this.awinamepsdefnameDirtyFlag = true;
    }

    public String getAWINamePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWINamePSDEFName();
        }
        return this.awinamepsdefname;
    }

    public boolean isAWINamePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWINamePSDEFNameDirty();
        }
        return this.awinamepsdefnameDirtyFlag;
    }

    public void resetAWINamePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWINamePSDEFName();
            return;
        }
        this.awinamepsdefnameDirtyFlag = false;
        this.awinamepsdefname = null;
    }

    public void setAWIPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awipsdedsid = string;
        this.awipsdedsidDirtyFlag = true;
    }

    public String getAWIPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIPSDEDSId();
        }
        return this.awipsdedsid;
    }

    public boolean isAWIPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIPSDEDSIdDirty();
        }
        return this.awipsdedsidDirtyFlag;
    }

    public void resetAWIPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIPSDEDSId();
            return;
        }
        this.awipsdedsidDirtyFlag = false;
        this.awipsdedsid = null;
    }

    public void setAWIPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awipsdedsname = string;
        this.awipsdedsnameDirtyFlag = true;
    }

    public String getAWIPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIPSDEDSName();
        }
        return this.awipsdedsname;
    }

    public boolean isAWIPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIPSDEDSNameDirty();
        }
        return this.awipsdedsnameDirtyFlag;
    }

    public void resetAWIPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIPSDEDSName();
            return;
        }
        this.awipsdedsnameDirtyFlag = false;
        this.awipsdedsname = null;
    }

    public void setAWIPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awipsdeid = string;
        this.awipsdeidDirtyFlag = true;
    }

    public String getAWIPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIPSDEId();
        }
        return this.awipsdeid;
    }

    public boolean isAWIPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIPSDEIdDirty();
        }
        return this.awipsdeidDirtyFlag;
    }

    public void resetAWIPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIPSDEId();
            return;
        }
        this.awipsdeidDirtyFlag = false;
        this.awipsdeid = null;
    }

    public void setAWIPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awipsdename = string;
        this.awipsdenameDirtyFlag = true;
    }

    public String getAWIPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIPSDEName();
        }
        return this.awipsdename;
    }

    public boolean isAWIPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIPSDENameDirty();
        }
        return this.awipsdenameDirtyFlag;
    }

    public void resetAWIPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIPSDEName();
            return;
        }
        this.awipsdenameDirtyFlag = false;
        this.awipsdename = null;
    }

    public void setAWISortPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWISortPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awisortpsdefid = string;
        this.awisortpsdefidDirtyFlag = true;
    }

    public String getAWISortPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWISortPSDEFId();
        }
        return this.awisortpsdefid;
    }

    public boolean isAWISortPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWISortPSDEFIdDirty();
        }
        return this.awisortpsdefidDirtyFlag;
    }

    public void resetAWISortPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWISortPSDEFId();
            return;
        }
        this.awisortpsdefidDirtyFlag = false;
        this.awisortpsdefid = null;
    }

    public void setAWISortPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWISortPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awisortpsdefname = string;
        this.awisortpsdefnameDirtyFlag = true;
    }

    public String getAWISortPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWISortPSDEFName();
        }
        return this.awisortpsdefname;
    }

    public boolean isAWISortPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWISortPSDEFNameDirty();
        }
        return this.awisortpsdefnameDirtyFlag;
    }

    public void resetAWISortPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWISortPSDEFName();
            return;
        }
        this.awisortpsdefnameDirtyFlag = false;
        this.awisortpsdefname = null;
    }

    public void setAWIUrlPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIUrlPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awiurlpsdefid = string;
        this.awiurlpsdefidDirtyFlag = true;
    }

    public String getAWIUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIUrlPSDEFId();
        }
        return this.awiurlpsdefid;
    }

    public boolean isAWIUrlPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIUrlPSDEFIdDirty();
        }
        return this.awiurlpsdefidDirtyFlag;
    }

    public void resetAWIUrlPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIUrlPSDEFId();
            return;
        }
        this.awiurlpsdefidDirtyFlag = false;
        this.awiurlpsdefid = null;
    }

    public void setAWIUrlPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIUrlPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awiurlpsdefname = string;
        this.awiurlpsdefnameDirtyFlag = true;
    }

    public String getAWIUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIUrlPSDEFName();
        }
        return this.awiurlpsdefname;
    }

    public boolean isAWIUrlPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIUrlPSDEFNameDirty();
        }
        return this.awiurlpsdefnameDirtyFlag;
    }

    public void resetAWIUrlPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIUrlPSDEFName();
            return;
        }
        this.awiurlpsdefnameDirtyFlag = false;
        this.awiurlpsdefname = null;
    }

    public void setAWIValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awivaluepsdefid = string;
        this.awivaluepsdefidDirtyFlag = true;
    }

    public String getAWIValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIValuePSDEFId();
        }
        return this.awivaluepsdefid;
    }

    public boolean isAWIValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIValuePSDEFIdDirty();
        }
        return this.awivaluepsdefidDirtyFlag;
    }

    public void resetAWIValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIValuePSDEFId();
            return;
        }
        this.awivaluepsdefidDirtyFlag = false;
        this.awivaluepsdefid = null;
    }

    public void setAWIValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWIValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awivaluepsdefname = string;
        this.awivaluepsdefnameDirtyFlag = true;
    }

    public String getAWIValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIValuePSDEFName();
        }
        return this.awivaluepsdefname;
    }

    public boolean isAWIValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWIValuePSDEFNameDirty();
        }
        return this.awivaluepsdefnameDirtyFlag;
    }

    public void resetAWIValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWIValuePSDEFName();
            return;
        }
        this.awivaluepsdefnameDirtyFlag = false;
        this.awivaluepsdefname = null;
    }

    public void setAWKWPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWKWPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awkwpsdefid = string;
        this.awkwpsdefidDirtyFlag = true;
    }

    public String getAWKWPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWKWPSDEFId();
        }
        return this.awkwpsdefid;
    }

    public boolean isAWKWPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWKWPSDEFIdDirty();
        }
        return this.awkwpsdefidDirtyFlag;
    }

    public void resetAWKWPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWKWPSDEFId();
            return;
        }
        this.awkwpsdefidDirtyFlag = false;
        this.awkwpsdefid = null;
    }

    public void setAWKWPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWKWPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awkwpsdefname = string;
        this.awkwpsdefnameDirtyFlag = true;
    }

    public String getAWKWPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWKWPSDEFName();
        }
        return this.awkwpsdefname;
    }

    public boolean isAWKWPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWKWPSDEFNameDirty();
        }
        return this.awkwpsdefnameDirtyFlag;
    }

    public void resetAWKWPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWKWPSDEFName();
            return;
        }
        this.awkwpsdefnameDirtyFlag = false;
        this.awkwpsdefname = null;
    }

    public void setAWNamePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWNamePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awnamepsdefid = string;
        this.awnamepsdefidDirtyFlag = true;
    }

    public String getAWNamePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWNamePSDEFId();
        }
        return this.awnamepsdefid;
    }

    public boolean isAWNamePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWNamePSDEFIdDirty();
        }
        return this.awnamepsdefidDirtyFlag;
    }

    public void resetAWNamePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWNamePSDEFId();
            return;
        }
        this.awnamepsdefidDirtyFlag = false;
        this.awnamepsdefid = null;
    }

    public void setAWNamePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWNamePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awnamepsdefname = string;
        this.awnamepsdefnameDirtyFlag = true;
    }

    public String getAWNamePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWNamePSDEFName();
        }
        return this.awnamepsdefname;
    }

    public boolean isAWNamePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWNamePSDEFNameDirty();
        }
        return this.awnamepsdefnameDirtyFlag;
    }

    public void resetAWNamePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWNamePSDEFName();
            return;
        }
        this.awnamepsdefnameDirtyFlag = false;
        this.awnamepsdefname = null;
    }

    public void setAWPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awpsdedsid = string;
        this.awpsdedsidDirtyFlag = true;
    }

    public String getAWPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWPSDEDSId();
        }
        return this.awpsdedsid;
    }

    public boolean isAWPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWPSDEDSIdDirty();
        }
        return this.awpsdedsidDirtyFlag;
    }

    public void resetAWPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWPSDEDSId();
            return;
        }
        this.awpsdedsidDirtyFlag = false;
        this.awpsdedsid = null;
    }

    public void setAWPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awpsdedsname = string;
        this.awpsdedsnameDirtyFlag = true;
    }

    public String getAWPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWPSDEDSName();
        }
        return this.awpsdedsname;
    }

    public boolean isAWPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWPSDEDSNameDirty();
        }
        return this.awpsdedsnameDirtyFlag;
    }

    public void resetAWPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWPSDEDSName();
            return;
        }
        this.awpsdedsnameDirtyFlag = false;
        this.awpsdedsname = null;
    }

    public void setAWPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awpsdeid = string;
        this.awpsdeidDirtyFlag = true;
    }

    public String getAWPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWPSDEId();
        }
        return this.awpsdeid;
    }

    public boolean isAWPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWPSDEIdDirty();
        }
        return this.awpsdeidDirtyFlag;
    }

    public void resetAWPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWPSDEId();
            return;
        }
        this.awpsdeidDirtyFlag = false;
        this.awpsdeid = null;
    }

    public void setAWPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awpsdename = string;
        this.awpsdenameDirtyFlag = true;
    }

    public String getAWPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWPSDEName();
        }
        return this.awpsdename;
    }

    public boolean isAWPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWPSDENameDirty();
        }
        return this.awpsdenameDirtyFlag;
    }

    public void resetAWPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWPSDEName();
            return;
        }
        this.awpsdenameDirtyFlag = false;
        this.awpsdename = null;
    }

    public void setAWSortPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWSortPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awsortpsdefid = string;
        this.awsortpsdefidDirtyFlag = true;
    }

    public String getAWSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWSortPSDEFId();
        }
        return this.awsortpsdefid;
    }

    public boolean isAWSortPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWSortPSDEFIdDirty();
        }
        return this.awsortpsdefidDirtyFlag;
    }

    public void resetAWSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWSortPSDEFId();
            return;
        }
        this.awsortpsdefidDirtyFlag = false;
        this.awsortpsdefid = null;
    }

    public void setAWSortPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWSortPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awsortpsdefname = string;
        this.awsortpsdefnameDirtyFlag = true;
    }

    public String getAWSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWSortPSDEFName();
        }
        return this.awsortpsdefname;
    }

    public boolean isAWSortPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWSortPSDEFNameDirty();
        }
        return this.awsortpsdefnameDirtyFlag;
    }

    public void resetAWSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWSortPSDEFName();
            return;
        }
        this.awsortpsdefnameDirtyFlag = false;
        this.awsortpsdefname = null;
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

    public void setDynamicMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynamicMode(n);
            return;
        }
        this.dynamicmode = n;
        this.dynamicmodeDirtyFlag = true;
    }

    public Integer getDynamicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynamicMode();
        }
        return this.dynamicmode;
    }

    public boolean isDynamicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynamicModeDirty();
        }
        return this.dynamicmodeDirtyFlag;
    }

    public void resetDynamicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynamicMode();
            return;
        }
        this.dynamicmodeDirtyFlag = false;
        this.dynamicmode = null;
    }

    public void setKeywords(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeywords(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keywords = string;
        this.keywordsDirtyFlag = true;
    }

    public String getKeywords() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeywords();
        }
        return this.keywords;
    }

    public boolean isKeywordsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeywordsDirty();
        }
        return this.keywordsDirtyFlag;
    }

    public void resetKeywords() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeywords();
            return;
        }
        this.keywordsDirtyFlag = false;
        this.keywords = null;
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

    public void setPSDEActionWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionwizardid = string;
        this.psdeactionwizardidDirtyFlag = true;
    }

    public String getPSDEActionWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionWizardId();
        }
        return this.psdeactionwizardid;
    }

    public boolean isPSDEActionWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionWizardIdDirty();
        }
        return this.psdeactionwizardidDirtyFlag;
    }

    public void resetPSDEActionWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionWizardId();
            return;
        }
        this.psdeactionwizardidDirtyFlag = false;
        this.psdeactionwizardid = null;
    }

    public void setPSDEActionWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionwizardname = string;
        this.psdeactionwizardnameDirtyFlag = true;
    }

    public String getPSDEActionWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionWizardName();
        }
        return this.psdeactionwizardname;
    }

    public boolean isPSDEActionWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionWizardNameDirty();
        }
        return this.psdeactionwizardnameDirtyFlag;
    }

    public void resetPSDEActionWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionWizardName();
            return;
        }
        this.psdeactionwizardnameDirtyFlag = false;
        this.psdeactionwizardname = null;
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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
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
        PSDEActionWizardBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEActionWizardBase pSDEActionWizardBase) {
        pSDEActionWizardBase.resetAWIContentPSDEFId();
        pSDEActionWizardBase.resetAWIContentPSDEFName();
        pSDEActionWizardBase.resetAWIFKeyPSDEFId();
        pSDEActionWizardBase.resetAWIFKeyPSDEFName();
        pSDEActionWizardBase.resetAWINamePSDEFId();
        pSDEActionWizardBase.resetAWINamePSDEFName();
        pSDEActionWizardBase.resetAWIPSDEDSId();
        pSDEActionWizardBase.resetAWIPSDEDSName();
        pSDEActionWizardBase.resetAWIPSDEId();
        pSDEActionWizardBase.resetAWIPSDEName();
        pSDEActionWizardBase.resetAWISortPSDEFId();
        pSDEActionWizardBase.resetAWISortPSDEFName();
        pSDEActionWizardBase.resetAWIUrlPSDEFId();
        pSDEActionWizardBase.resetAWIUrlPSDEFName();
        pSDEActionWizardBase.resetAWIValuePSDEFId();
        pSDEActionWizardBase.resetAWIValuePSDEFName();
        pSDEActionWizardBase.resetAWKWPSDEFId();
        pSDEActionWizardBase.resetAWKWPSDEFName();
        pSDEActionWizardBase.resetAWNamePSDEFId();
        pSDEActionWizardBase.resetAWNamePSDEFName();
        pSDEActionWizardBase.resetAWPSDEDSId();
        pSDEActionWizardBase.resetAWPSDEDSName();
        pSDEActionWizardBase.resetAWPSDEId();
        pSDEActionWizardBase.resetAWPSDEName();
        pSDEActionWizardBase.resetAWSortPSDEFId();
        pSDEActionWizardBase.resetAWSortPSDEFName();
        pSDEActionWizardBase.resetCodeName();
        pSDEActionWizardBase.resetCreateDate();
        pSDEActionWizardBase.resetCreateMan();
        pSDEActionWizardBase.resetDynamicMode();
        pSDEActionWizardBase.resetKeywords();
        pSDEActionWizardBase.resetLockFlag();
        pSDEActionWizardBase.resetMemo();
        pSDEActionWizardBase.resetPSDEActionWizardId();
        pSDEActionWizardBase.resetPSDEActionWizardName();
        pSDEActionWizardBase.resetPSDEId();
        pSDEActionWizardBase.resetPSDEName();
        pSDEActionWizardBase.resetPSDEViewBaseId();
        pSDEActionWizardBase.resetPSDEViewBaseName();
        pSDEActionWizardBase.resetUpdateDate();
        pSDEActionWizardBase.resetUpdateMan();
        pSDEActionWizardBase.resetUserCat();
        pSDEActionWizardBase.resetUserTag();
        pSDEActionWizardBase.resetUserTag2();
        pSDEActionWizardBase.resetUserTag3();
        pSDEActionWizardBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAWIContentPSDEFIdDirty()) {
            hashMap.put(FIELD_AWICONTENTPSDEFID, this.getAWIContentPSDEFId());
        }
        if (!bl || this.isAWIContentPSDEFNameDirty()) {
            hashMap.put(FIELD_AWICONTENTPSDEFNAME, this.getAWIContentPSDEFName());
        }
        if (!bl || this.isAWIFKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_AWIFKEYPSDEFID, this.getAWIFKeyPSDEFId());
        }
        if (!bl || this.isAWIFKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_AWIFKEYPSDEFNAME, this.getAWIFKeyPSDEFName());
        }
        if (!bl || this.isAWINamePSDEFIdDirty()) {
            hashMap.put(FIELD_AWINAMEPSDEFID, this.getAWINamePSDEFId());
        }
        if (!bl || this.isAWINamePSDEFNameDirty()) {
            hashMap.put(FIELD_AWINAMEPSDEFNAME, this.getAWINamePSDEFName());
        }
        if (!bl || this.isAWIPSDEDSIdDirty()) {
            hashMap.put(FIELD_AWIPSDEDSID, this.getAWIPSDEDSId());
        }
        if (!bl || this.isAWIPSDEDSNameDirty()) {
            hashMap.put(FIELD_AWIPSDEDSNAME, this.getAWIPSDEDSName());
        }
        if (!bl || this.isAWIPSDEIdDirty()) {
            hashMap.put(FIELD_AWIPSDEID, this.getAWIPSDEId());
        }
        if (!bl || this.isAWIPSDENameDirty()) {
            hashMap.put(FIELD_AWIPSDENAME, this.getAWIPSDEName());
        }
        if (!bl || this.isAWISortPSDEFIdDirty()) {
            hashMap.put(FIELD_AWISORTPSDEFID, this.getAWISortPSDEFId());
        }
        if (!bl || this.isAWISortPSDEFNameDirty()) {
            hashMap.put(FIELD_AWISORTPSDEFNAME, this.getAWISortPSDEFName());
        }
        if (!bl || this.isAWIUrlPSDEFIdDirty()) {
            hashMap.put(FIELD_AWIURLPSDEFID, this.getAWIUrlPSDEFId());
        }
        if (!bl || this.isAWIUrlPSDEFNameDirty()) {
            hashMap.put(FIELD_AWIURLPSDEFNAME, this.getAWIUrlPSDEFName());
        }
        if (!bl || this.isAWIValuePSDEFIdDirty()) {
            hashMap.put(FIELD_AWIVALUEPSDEFID, this.getAWIValuePSDEFId());
        }
        if (!bl || this.isAWIValuePSDEFNameDirty()) {
            hashMap.put(FIELD_AWIVALUEPSDEFNAME, this.getAWIValuePSDEFName());
        }
        if (!bl || this.isAWKWPSDEFIdDirty()) {
            hashMap.put(FIELD_AWKWPSDEFID, this.getAWKWPSDEFId());
        }
        if (!bl || this.isAWKWPSDEFNameDirty()) {
            hashMap.put(FIELD_AWKWPSDEFNAME, this.getAWKWPSDEFName());
        }
        if (!bl || this.isAWNamePSDEFIdDirty()) {
            hashMap.put(FIELD_AWNAMEPSDEFID, this.getAWNamePSDEFId());
        }
        if (!bl || this.isAWNamePSDEFNameDirty()) {
            hashMap.put(FIELD_AWNAMEPSDEFNAME, this.getAWNamePSDEFName());
        }
        if (!bl || this.isAWPSDEDSIdDirty()) {
            hashMap.put(FIELD_AWPSDEDSID, this.getAWPSDEDSId());
        }
        if (!bl || this.isAWPSDEDSNameDirty()) {
            hashMap.put(FIELD_AWPSDEDSNAME, this.getAWPSDEDSName());
        }
        if (!bl || this.isAWPSDEIdDirty()) {
            hashMap.put(FIELD_AWPSDEID, this.getAWPSDEId());
        }
        if (!bl || this.isAWPSDENameDirty()) {
            hashMap.put(FIELD_AWPSDENAME, this.getAWPSDEName());
        }
        if (!bl || this.isAWSortPSDEFIdDirty()) {
            hashMap.put(FIELD_AWSORTPSDEFID, this.getAWSortPSDEFId());
        }
        if (!bl || this.isAWSortPSDEFNameDirty()) {
            hashMap.put(FIELD_AWSORTPSDEFNAME, this.getAWSortPSDEFName());
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
        if (!bl || this.isDynamicModeDirty()) {
            hashMap.put(FIELD_DYNAMICMODE, this.getDynamicMode());
        }
        if (!bl || this.isKeywordsDirty()) {
            hashMap.put(FIELD_KEYWORDS, this.getKeywords());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEActionWizardIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONWIZARDID, this.getPSDEActionWizardId());
        }
        if (!bl || this.isPSDEActionWizardNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONWIZARDNAME, this.getPSDEActionWizardName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
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
        return PSDEActionWizardBase.get(this, n);
    }

    private static Object get(PSDEActionWizardBase pSDEActionWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionWizardBase.getAWIContentPSDEFId();
            }
            case 1: {
                return pSDEActionWizardBase.getAWIContentPSDEFName();
            }
            case 2: {
                return pSDEActionWizardBase.getAWIFKeyPSDEFId();
            }
            case 3: {
                return pSDEActionWizardBase.getAWIFKeyPSDEFName();
            }
            case 4: {
                return pSDEActionWizardBase.getAWINamePSDEFId();
            }
            case 5: {
                return pSDEActionWizardBase.getAWINamePSDEFName();
            }
            case 6: {
                return pSDEActionWizardBase.getAWIPSDEDSId();
            }
            case 7: {
                return pSDEActionWizardBase.getAWIPSDEDSName();
            }
            case 8: {
                return pSDEActionWizardBase.getAWIPSDEId();
            }
            case 9: {
                return pSDEActionWizardBase.getAWIPSDEName();
            }
            case 10: {
                return pSDEActionWizardBase.getAWISortPSDEFId();
            }
            case 11: {
                return pSDEActionWizardBase.getAWISortPSDEFName();
            }
            case 12: {
                return pSDEActionWizardBase.getAWIUrlPSDEFId();
            }
            case 13: {
                return pSDEActionWizardBase.getAWIUrlPSDEFName();
            }
            case 14: {
                return pSDEActionWizardBase.getAWIValuePSDEFId();
            }
            case 15: {
                return pSDEActionWizardBase.getAWIValuePSDEFName();
            }
            case 16: {
                return pSDEActionWizardBase.getAWKWPSDEFId();
            }
            case 17: {
                return pSDEActionWizardBase.getAWKWPSDEFName();
            }
            case 18: {
                return pSDEActionWizardBase.getAWNamePSDEFId();
            }
            case 19: {
                return pSDEActionWizardBase.getAWNamePSDEFName();
            }
            case 20: {
                return pSDEActionWizardBase.getAWPSDEDSId();
            }
            case 21: {
                return pSDEActionWizardBase.getAWPSDEDSName();
            }
            case 22: {
                return pSDEActionWizardBase.getAWPSDEId();
            }
            case 23: {
                return pSDEActionWizardBase.getAWPSDEName();
            }
            case 24: {
                return pSDEActionWizardBase.getAWSortPSDEFId();
            }
            case 25: {
                return pSDEActionWizardBase.getAWSortPSDEFName();
            }
            case 26: {
                return pSDEActionWizardBase.getCodeName();
            }
            case 27: {
                return pSDEActionWizardBase.getCreateDate();
            }
            case 28: {
                return pSDEActionWizardBase.getCreateMan();
            }
            case 29: {
                return pSDEActionWizardBase.getDynamicMode();
            }
            case 30: {
                return pSDEActionWizardBase.getKeywords();
            }
            case 31: {
                return pSDEActionWizardBase.getLockFlag();
            }
            case 32: {
                return pSDEActionWizardBase.getMemo();
            }
            case 33: {
                return pSDEActionWizardBase.getPSDEActionWizardId();
            }
            case 34: {
                return pSDEActionWizardBase.getPSDEActionWizardName();
            }
            case 35: {
                return pSDEActionWizardBase.getPSDEId();
            }
            case 36: {
                return pSDEActionWizardBase.getPSDEName();
            }
            case 37: {
                return pSDEActionWizardBase.getPSDEViewBaseId();
            }
            case 38: {
                return pSDEActionWizardBase.getPSDEViewBaseName();
            }
            case 39: {
                return pSDEActionWizardBase.getUpdateDate();
            }
            case 40: {
                return pSDEActionWizardBase.getUpdateMan();
            }
            case 41: {
                return pSDEActionWizardBase.getUserCat();
            }
            case 42: {
                return pSDEActionWizardBase.getUserTag();
            }
            case 43: {
                return pSDEActionWizardBase.getUserTag2();
            }
            case 44: {
                return pSDEActionWizardBase.getUserTag3();
            }
            case 45: {
                return pSDEActionWizardBase.getUserTag4();
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
        PSDEActionWizardBase.set(this, n, object);
    }

    private static void set(PSDEActionWizardBase pSDEActionWizardBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionWizardBase.setAWIContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEActionWizardBase.setAWIContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEActionWizardBase.setAWIFKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEActionWizardBase.setAWIFKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEActionWizardBase.setAWINamePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEActionWizardBase.setAWINamePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEActionWizardBase.setAWIPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEActionWizardBase.setAWIPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEActionWizardBase.setAWIPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEActionWizardBase.setAWIPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEActionWizardBase.setAWISortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEActionWizardBase.setAWISortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEActionWizardBase.setAWIUrlPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEActionWizardBase.setAWIUrlPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEActionWizardBase.setAWIValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEActionWizardBase.setAWIValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEActionWizardBase.setAWKWPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEActionWizardBase.setAWKWPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEActionWizardBase.setAWNamePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEActionWizardBase.setAWNamePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEActionWizardBase.setAWPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEActionWizardBase.setAWPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEActionWizardBase.setAWPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEActionWizardBase.setAWPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEActionWizardBase.setAWSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEActionWizardBase.setAWSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEActionWizardBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEActionWizardBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDEActionWizardBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEActionWizardBase.setDynamicMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEActionWizardBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEActionWizardBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEActionWizardBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEActionWizardBase.setPSDEActionWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEActionWizardBase.setPSDEActionWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEActionWizardBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEActionWizardBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEActionWizardBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEActionWizardBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEActionWizardBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 40: {
                pSDEActionWizardBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEActionWizardBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEActionWizardBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEActionWizardBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEActionWizardBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEActionWizardBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEActionWizardBase.isNull(this, n);
    }

    private static boolean isNull(PSDEActionWizardBase pSDEActionWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionWizardBase.getAWIContentPSDEFId() == null;
            }
            case 1: {
                return pSDEActionWizardBase.getAWIContentPSDEFName() == null;
            }
            case 2: {
                return pSDEActionWizardBase.getAWIFKeyPSDEFId() == null;
            }
            case 3: {
                return pSDEActionWizardBase.getAWIFKeyPSDEFName() == null;
            }
            case 4: {
                return pSDEActionWizardBase.getAWINamePSDEFId() == null;
            }
            case 5: {
                return pSDEActionWizardBase.getAWINamePSDEFName() == null;
            }
            case 6: {
                return pSDEActionWizardBase.getAWIPSDEDSId() == null;
            }
            case 7: {
                return pSDEActionWizardBase.getAWIPSDEDSName() == null;
            }
            case 8: {
                return pSDEActionWizardBase.getAWIPSDEId() == null;
            }
            case 9: {
                return pSDEActionWizardBase.getAWIPSDEName() == null;
            }
            case 10: {
                return pSDEActionWizardBase.getAWISortPSDEFId() == null;
            }
            case 11: {
                return pSDEActionWizardBase.getAWISortPSDEFName() == null;
            }
            case 12: {
                return pSDEActionWizardBase.getAWIUrlPSDEFId() == null;
            }
            case 13: {
                return pSDEActionWizardBase.getAWIUrlPSDEFName() == null;
            }
            case 14: {
                return pSDEActionWizardBase.getAWIValuePSDEFId() == null;
            }
            case 15: {
                return pSDEActionWizardBase.getAWIValuePSDEFName() == null;
            }
            case 16: {
                return pSDEActionWizardBase.getAWKWPSDEFId() == null;
            }
            case 17: {
                return pSDEActionWizardBase.getAWKWPSDEFName() == null;
            }
            case 18: {
                return pSDEActionWizardBase.getAWNamePSDEFId() == null;
            }
            case 19: {
                return pSDEActionWizardBase.getAWNamePSDEFName() == null;
            }
            case 20: {
                return pSDEActionWizardBase.getAWPSDEDSId() == null;
            }
            case 21: {
                return pSDEActionWizardBase.getAWPSDEDSName() == null;
            }
            case 22: {
                return pSDEActionWizardBase.getAWPSDEId() == null;
            }
            case 23: {
                return pSDEActionWizardBase.getAWPSDEName() == null;
            }
            case 24: {
                return pSDEActionWizardBase.getAWSortPSDEFId() == null;
            }
            case 25: {
                return pSDEActionWizardBase.getAWSortPSDEFName() == null;
            }
            case 26: {
                return pSDEActionWizardBase.getCodeName() == null;
            }
            case 27: {
                return pSDEActionWizardBase.getCreateDate() == null;
            }
            case 28: {
                return pSDEActionWizardBase.getCreateMan() == null;
            }
            case 29: {
                return pSDEActionWizardBase.getDynamicMode() == null;
            }
            case 30: {
                return pSDEActionWizardBase.getKeywords() == null;
            }
            case 31: {
                return pSDEActionWizardBase.getLockFlag() == null;
            }
            case 32: {
                return pSDEActionWizardBase.getMemo() == null;
            }
            case 33: {
                return pSDEActionWizardBase.getPSDEActionWizardId() == null;
            }
            case 34: {
                return pSDEActionWizardBase.getPSDEActionWizardName() == null;
            }
            case 35: {
                return pSDEActionWizardBase.getPSDEId() == null;
            }
            case 36: {
                return pSDEActionWizardBase.getPSDEName() == null;
            }
            case 37: {
                return pSDEActionWizardBase.getPSDEViewBaseId() == null;
            }
            case 38: {
                return pSDEActionWizardBase.getPSDEViewBaseName() == null;
            }
            case 39: {
                return pSDEActionWizardBase.getUpdateDate() == null;
            }
            case 40: {
                return pSDEActionWizardBase.getUpdateMan() == null;
            }
            case 41: {
                return pSDEActionWizardBase.getUserCat() == null;
            }
            case 42: {
                return pSDEActionWizardBase.getUserTag() == null;
            }
            case 43: {
                return pSDEActionWizardBase.getUserTag2() == null;
            }
            case 44: {
                return pSDEActionWizardBase.getUserTag3() == null;
            }
            case 45: {
                return pSDEActionWizardBase.getUserTag4() == null;
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
        return PSDEActionWizardBase.contains(this, n);
    }

    private static boolean contains(PSDEActionWizardBase pSDEActionWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionWizardBase.isAWIContentPSDEFIdDirty();
            }
            case 1: {
                return pSDEActionWizardBase.isAWIContentPSDEFNameDirty();
            }
            case 2: {
                return pSDEActionWizardBase.isAWIFKeyPSDEFIdDirty();
            }
            case 3: {
                return pSDEActionWizardBase.isAWIFKeyPSDEFNameDirty();
            }
            case 4: {
                return pSDEActionWizardBase.isAWINamePSDEFIdDirty();
            }
            case 5: {
                return pSDEActionWizardBase.isAWINamePSDEFNameDirty();
            }
            case 6: {
                return pSDEActionWizardBase.isAWIPSDEDSIdDirty();
            }
            case 7: {
                return pSDEActionWizardBase.isAWIPSDEDSNameDirty();
            }
            case 8: {
                return pSDEActionWizardBase.isAWIPSDEIdDirty();
            }
            case 9: {
                return pSDEActionWizardBase.isAWIPSDENameDirty();
            }
            case 10: {
                return pSDEActionWizardBase.isAWISortPSDEFIdDirty();
            }
            case 11: {
                return pSDEActionWizardBase.isAWISortPSDEFNameDirty();
            }
            case 12: {
                return pSDEActionWizardBase.isAWIUrlPSDEFIdDirty();
            }
            case 13: {
                return pSDEActionWizardBase.isAWIUrlPSDEFNameDirty();
            }
            case 14: {
                return pSDEActionWizardBase.isAWIValuePSDEFIdDirty();
            }
            case 15: {
                return pSDEActionWizardBase.isAWIValuePSDEFNameDirty();
            }
            case 16: {
                return pSDEActionWizardBase.isAWKWPSDEFIdDirty();
            }
            case 17: {
                return pSDEActionWizardBase.isAWKWPSDEFNameDirty();
            }
            case 18: {
                return pSDEActionWizardBase.isAWNamePSDEFIdDirty();
            }
            case 19: {
                return pSDEActionWizardBase.isAWNamePSDEFNameDirty();
            }
            case 20: {
                return pSDEActionWizardBase.isAWPSDEDSIdDirty();
            }
            case 21: {
                return pSDEActionWizardBase.isAWPSDEDSNameDirty();
            }
            case 22: {
                return pSDEActionWizardBase.isAWPSDEIdDirty();
            }
            case 23: {
                return pSDEActionWizardBase.isAWPSDENameDirty();
            }
            case 24: {
                return pSDEActionWizardBase.isAWSortPSDEFIdDirty();
            }
            case 25: {
                return pSDEActionWizardBase.isAWSortPSDEFNameDirty();
            }
            case 26: {
                return pSDEActionWizardBase.isCodeNameDirty();
            }
            case 27: {
                return pSDEActionWizardBase.isCreateDateDirty();
            }
            case 28: {
                return pSDEActionWizardBase.isCreateManDirty();
            }
            case 29: {
                return pSDEActionWizardBase.isDynamicModeDirty();
            }
            case 30: {
                return pSDEActionWizardBase.isKeywordsDirty();
            }
            case 31: {
                return pSDEActionWizardBase.isLockFlagDirty();
            }
            case 32: {
                return pSDEActionWizardBase.isMemoDirty();
            }
            case 33: {
                return pSDEActionWizardBase.isPSDEActionWizardIdDirty();
            }
            case 34: {
                return pSDEActionWizardBase.isPSDEActionWizardNameDirty();
            }
            case 35: {
                return pSDEActionWizardBase.isPSDEIdDirty();
            }
            case 36: {
                return pSDEActionWizardBase.isPSDENameDirty();
            }
            case 37: {
                return pSDEActionWizardBase.isPSDEViewBaseIdDirty();
            }
            case 38: {
                return pSDEActionWizardBase.isPSDEViewBaseNameDirty();
            }
            case 39: {
                return pSDEActionWizardBase.isUpdateDateDirty();
            }
            case 40: {
                return pSDEActionWizardBase.isUpdateManDirty();
            }
            case 41: {
                return pSDEActionWizardBase.isUserCatDirty();
            }
            case 42: {
                return pSDEActionWizardBase.isUserTagDirty();
            }
            case 43: {
                return pSDEActionWizardBase.isUserTag2Dirty();
            }
            case 44: {
                return pSDEActionWizardBase.isUserTag3Dirty();
            }
            case 45: {
                return pSDEActionWizardBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEActionWizardBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEActionWizardBase pSDEActionWizardBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEActionWizardBase.getAWIContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awicontentpsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIContentPSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awicontentpsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIContentPSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIFKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awifkeypsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIFKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIFKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awifkeypsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIFKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWINamePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awinamepsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWINamePSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWINamePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awinamepsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWINamePSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awipsdedsid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awipsdedsname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awipsdeid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awipsdename", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWISortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awisortpsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWISortPSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWISortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awisortpsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWISortPSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIUrlPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awiurlpsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIUrlPSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIUrlPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awiurlpsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIUrlPSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awivaluepsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIValuePSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWIValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awivaluepsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWIValuePSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWKWPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awkwpsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWKWPSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWKWPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awkwpsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWKWPSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWNamePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awnamepsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWNamePSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWNamePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awnamepsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWNamePSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awpsdedsid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awpsdedsname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awpsdeid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awpsdename", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awsortpsdefid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWSortPSDEFId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getAWSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awsortpsdefname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getAWSortPSDEFName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getDynamicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamicmode", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getDynamicMode()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getKeywords()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getPSDEActionWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionwizardid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getPSDEActionWizardId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getPSDEActionWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionwizardname", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getPSDEActionWizardName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEActionWizardBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEActionWizardBase.getJSONValue((Object)pSDEActionWizardBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEActionWizardBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEActionWizardBase pSDEActionWizardBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEActionWizardBase.getAWIContentPSDEFId() != null) {
            object = pSDEActionWizardBase.getAWIContentPSDEFId();
            xmlNode.setAttribute(FIELD_AWICONTENTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIContentPSDEFName() != null) {
            object = pSDEActionWizardBase.getAWIContentPSDEFName();
            xmlNode.setAttribute(FIELD_AWICONTENTPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIFKeyPSDEFId() != null) {
            object = pSDEActionWizardBase.getAWIFKeyPSDEFId();
            xmlNode.setAttribute(FIELD_AWIFKEYPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIFKeyPSDEFName() != null) {
            object = pSDEActionWizardBase.getAWIFKeyPSDEFName();
            xmlNode.setAttribute(FIELD_AWIFKEYPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWINamePSDEFId() != null) {
            object = pSDEActionWizardBase.getAWINamePSDEFId();
            xmlNode.setAttribute(FIELD_AWINAMEPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWINamePSDEFName() != null) {
            object = pSDEActionWizardBase.getAWINamePSDEFName();
            xmlNode.setAttribute(FIELD_AWINAMEPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIPSDEDSId() != null) {
            object = pSDEActionWizardBase.getAWIPSDEDSId();
            xmlNode.setAttribute(FIELD_AWIPSDEDSID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIPSDEDSName() != null) {
            object = pSDEActionWizardBase.getAWIPSDEDSName();
            xmlNode.setAttribute(FIELD_AWIPSDEDSNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIPSDEId() != null) {
            object = pSDEActionWizardBase.getAWIPSDEId();
            xmlNode.setAttribute(FIELD_AWIPSDEID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIPSDEName() != null) {
            object = pSDEActionWizardBase.getAWIPSDEName();
            xmlNode.setAttribute(FIELD_AWIPSDENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWISortPSDEFId() != null) {
            object = pSDEActionWizardBase.getAWISortPSDEFId();
            xmlNode.setAttribute(FIELD_AWISORTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWISortPSDEFName() != null) {
            object = pSDEActionWizardBase.getAWISortPSDEFName();
            xmlNode.setAttribute(FIELD_AWISORTPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIUrlPSDEFId() != null) {
            object = pSDEActionWizardBase.getAWIUrlPSDEFId();
            xmlNode.setAttribute(FIELD_AWIURLPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIUrlPSDEFName() != null) {
            object = pSDEActionWizardBase.getAWIUrlPSDEFName();
            xmlNode.setAttribute(FIELD_AWIURLPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIValuePSDEFId() != null) {
            object = pSDEActionWizardBase.getAWIValuePSDEFId();
            xmlNode.setAttribute(FIELD_AWIVALUEPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWIValuePSDEFName() != null) {
            object = pSDEActionWizardBase.getAWIValuePSDEFName();
            xmlNode.setAttribute(FIELD_AWIVALUEPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWKWPSDEFId() != null) {
            object = pSDEActionWizardBase.getAWKWPSDEFId();
            xmlNode.setAttribute(FIELD_AWKWPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWKWPSDEFName() != null) {
            object = pSDEActionWizardBase.getAWKWPSDEFName();
            xmlNode.setAttribute(FIELD_AWKWPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWNamePSDEFId() != null) {
            object = pSDEActionWizardBase.getAWNamePSDEFId();
            xmlNode.setAttribute(FIELD_AWNAMEPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWNamePSDEFName() != null) {
            object = pSDEActionWizardBase.getAWNamePSDEFName();
            xmlNode.setAttribute(FIELD_AWNAMEPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWPSDEDSId() != null) {
            object = pSDEActionWizardBase.getAWPSDEDSId();
            xmlNode.setAttribute(FIELD_AWPSDEDSID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWPSDEDSName() != null) {
            object = pSDEActionWizardBase.getAWPSDEDSName();
            xmlNode.setAttribute(FIELD_AWPSDEDSNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWPSDEId() != null) {
            object = pSDEActionWizardBase.getAWPSDEId();
            xmlNode.setAttribute(FIELD_AWPSDEID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWPSDEName() != null) {
            object = pSDEActionWizardBase.getAWPSDEName();
            xmlNode.setAttribute(FIELD_AWPSDENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWSortPSDEFId() != null) {
            object = pSDEActionWizardBase.getAWSortPSDEFId();
            xmlNode.setAttribute(FIELD_AWSORTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getAWSortPSDEFName() != null) {
            object = pSDEActionWizardBase.getAWSortPSDEFName();
            xmlNode.setAttribute(FIELD_AWSORTPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEActionWizardBase.getCodeName() != null) {
            object = pSDEActionWizardBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getCreateDate() != null) {
            object = pSDEActionWizardBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionWizardBase.getCreateMan() != null) {
            object = pSDEActionWizardBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getDynamicMode() != null) {
            object = pSDEActionWizardBase.getDynamicMode();
            xmlNode.setAttribute(FIELD_DYNAMICMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionWizardBase.getKeywords() != null) {
            object = pSDEActionWizardBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getLockFlag() != null) {
            object = pSDEActionWizardBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionWizardBase.getMemo() != null) {
            object = pSDEActionWizardBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getPSDEActionWizardId() != null) {
            object = pSDEActionWizardBase.getPSDEActionWizardId();
            xmlNode.setAttribute(FIELD_PSDEACTIONWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getPSDEActionWizardName() != null) {
            object = pSDEActionWizardBase.getPSDEActionWizardName();
            xmlNode.setAttribute(FIELD_PSDEACTIONWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getPSDEId() != null) {
            object = pSDEActionWizardBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getPSDEName() != null) {
            object = pSDEActionWizardBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getPSDEViewBaseId() != null) {
            object = pSDEActionWizardBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getPSDEViewBaseName() != null) {
            object = pSDEActionWizardBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getUpdateDate() != null) {
            object = pSDEActionWizardBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionWizardBase.getUpdateMan() != null) {
            object = pSDEActionWizardBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getUserCat() != null) {
            object = pSDEActionWizardBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getUserTag() != null) {
            object = pSDEActionWizardBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getUserTag2() != null) {
            object = pSDEActionWizardBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getUserTag3() != null) {
            object = pSDEActionWizardBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionWizardBase.getUserTag4() != null) {
            object = pSDEActionWizardBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEActionWizardBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEActionWizardBase pSDEActionWizardBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEActionWizardBase.isAWIContentPSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWIContentPSDEFId() != null)) {
            iDataObject.set(FIELD_AWICONTENTPSDEFID, (Object)pSDEActionWizardBase.getAWIContentPSDEFId());
        }
        if (pSDEActionWizardBase.isAWIContentPSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWIContentPSDEFName() != null)) {
            iDataObject.set(FIELD_AWICONTENTPSDEFNAME, (Object)pSDEActionWizardBase.getAWIContentPSDEFName());
        }
        if (pSDEActionWizardBase.isAWIFKeyPSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWIFKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_AWIFKEYPSDEFID, (Object)pSDEActionWizardBase.getAWIFKeyPSDEFId());
        }
        if (pSDEActionWizardBase.isAWIFKeyPSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWIFKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_AWIFKEYPSDEFNAME, (Object)pSDEActionWizardBase.getAWIFKeyPSDEFName());
        }
        if (pSDEActionWizardBase.isAWINamePSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWINamePSDEFId() != null)) {
            iDataObject.set(FIELD_AWINAMEPSDEFID, (Object)pSDEActionWizardBase.getAWINamePSDEFId());
        }
        if (pSDEActionWizardBase.isAWINamePSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWINamePSDEFName() != null)) {
            iDataObject.set(FIELD_AWINAMEPSDEFNAME, (Object)pSDEActionWizardBase.getAWINamePSDEFName());
        }
        if (pSDEActionWizardBase.isAWIPSDEDSIdDirty() && (bl || pSDEActionWizardBase.getAWIPSDEDSId() != null)) {
            iDataObject.set(FIELD_AWIPSDEDSID, (Object)pSDEActionWizardBase.getAWIPSDEDSId());
        }
        if (pSDEActionWizardBase.isAWIPSDEDSNameDirty() && (bl || pSDEActionWizardBase.getAWIPSDEDSName() != null)) {
            iDataObject.set(FIELD_AWIPSDEDSNAME, (Object)pSDEActionWizardBase.getAWIPSDEDSName());
        }
        if (pSDEActionWizardBase.isAWIPSDEIdDirty() && (bl || pSDEActionWizardBase.getAWIPSDEId() != null)) {
            iDataObject.set(FIELD_AWIPSDEID, (Object)pSDEActionWizardBase.getAWIPSDEId());
        }
        if (pSDEActionWizardBase.isAWIPSDENameDirty() && (bl || pSDEActionWizardBase.getAWIPSDEName() != null)) {
            iDataObject.set(FIELD_AWIPSDENAME, (Object)pSDEActionWizardBase.getAWIPSDEName());
        }
        if (pSDEActionWizardBase.isAWISortPSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWISortPSDEFId() != null)) {
            iDataObject.set(FIELD_AWISORTPSDEFID, (Object)pSDEActionWizardBase.getAWISortPSDEFId());
        }
        if (pSDEActionWizardBase.isAWISortPSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWISortPSDEFName() != null)) {
            iDataObject.set(FIELD_AWISORTPSDEFNAME, (Object)pSDEActionWizardBase.getAWISortPSDEFName());
        }
        if (pSDEActionWizardBase.isAWIUrlPSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWIUrlPSDEFId() != null)) {
            iDataObject.set(FIELD_AWIURLPSDEFID, (Object)pSDEActionWizardBase.getAWIUrlPSDEFId());
        }
        if (pSDEActionWizardBase.isAWIUrlPSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWIUrlPSDEFName() != null)) {
            iDataObject.set(FIELD_AWIURLPSDEFNAME, (Object)pSDEActionWizardBase.getAWIUrlPSDEFName());
        }
        if (pSDEActionWizardBase.isAWIValuePSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWIValuePSDEFId() != null)) {
            iDataObject.set(FIELD_AWIVALUEPSDEFID, (Object)pSDEActionWizardBase.getAWIValuePSDEFId());
        }
        if (pSDEActionWizardBase.isAWIValuePSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWIValuePSDEFName() != null)) {
            iDataObject.set(FIELD_AWIVALUEPSDEFNAME, (Object)pSDEActionWizardBase.getAWIValuePSDEFName());
        }
        if (pSDEActionWizardBase.isAWKWPSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWKWPSDEFId() != null)) {
            iDataObject.set(FIELD_AWKWPSDEFID, (Object)pSDEActionWizardBase.getAWKWPSDEFId());
        }
        if (pSDEActionWizardBase.isAWKWPSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWKWPSDEFName() != null)) {
            iDataObject.set(FIELD_AWKWPSDEFNAME, (Object)pSDEActionWizardBase.getAWKWPSDEFName());
        }
        if (pSDEActionWizardBase.isAWNamePSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWNamePSDEFId() != null)) {
            iDataObject.set(FIELD_AWNAMEPSDEFID, (Object)pSDEActionWizardBase.getAWNamePSDEFId());
        }
        if (pSDEActionWizardBase.isAWNamePSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWNamePSDEFName() != null)) {
            iDataObject.set(FIELD_AWNAMEPSDEFNAME, (Object)pSDEActionWizardBase.getAWNamePSDEFName());
        }
        if (pSDEActionWizardBase.isAWPSDEDSIdDirty() && (bl || pSDEActionWizardBase.getAWPSDEDSId() != null)) {
            iDataObject.set(FIELD_AWPSDEDSID, (Object)pSDEActionWizardBase.getAWPSDEDSId());
        }
        if (pSDEActionWizardBase.isAWPSDEDSNameDirty() && (bl || pSDEActionWizardBase.getAWPSDEDSName() != null)) {
            iDataObject.set(FIELD_AWPSDEDSNAME, (Object)pSDEActionWizardBase.getAWPSDEDSName());
        }
        if (pSDEActionWizardBase.isAWPSDEIdDirty() && (bl || pSDEActionWizardBase.getAWPSDEId() != null)) {
            iDataObject.set(FIELD_AWPSDEID, (Object)pSDEActionWizardBase.getAWPSDEId());
        }
        if (pSDEActionWizardBase.isAWPSDENameDirty() && (bl || pSDEActionWizardBase.getAWPSDEName() != null)) {
            iDataObject.set(FIELD_AWPSDENAME, (Object)pSDEActionWizardBase.getAWPSDEName());
        }
        if (pSDEActionWizardBase.isAWSortPSDEFIdDirty() && (bl || pSDEActionWizardBase.getAWSortPSDEFId() != null)) {
            iDataObject.set(FIELD_AWSORTPSDEFID, (Object)pSDEActionWizardBase.getAWSortPSDEFId());
        }
        if (pSDEActionWizardBase.isAWSortPSDEFNameDirty() && (bl || pSDEActionWizardBase.getAWSortPSDEFName() != null)) {
            iDataObject.set(FIELD_AWSORTPSDEFNAME, (Object)pSDEActionWizardBase.getAWSortPSDEFName());
        }
        if (pSDEActionWizardBase.isCodeNameDirty() && (bl || pSDEActionWizardBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEActionWizardBase.getCodeName());
        }
        if (pSDEActionWizardBase.isCreateDateDirty() && (bl || pSDEActionWizardBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEActionWizardBase.getCreateDate());
        }
        if (pSDEActionWizardBase.isCreateManDirty() && (bl || pSDEActionWizardBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEActionWizardBase.getCreateMan());
        }
        if (pSDEActionWizardBase.isDynamicModeDirty() && (bl || pSDEActionWizardBase.getDynamicMode() != null)) {
            iDataObject.set(FIELD_DYNAMICMODE, (Object)pSDEActionWizardBase.getDynamicMode());
        }
        if (pSDEActionWizardBase.isKeywordsDirty() && (bl || pSDEActionWizardBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSDEActionWizardBase.getKeywords());
        }
        if (pSDEActionWizardBase.isLockFlagDirty() && (bl || pSDEActionWizardBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEActionWizardBase.getLockFlag());
        }
        if (pSDEActionWizardBase.isMemoDirty() && (bl || pSDEActionWizardBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEActionWizardBase.getMemo());
        }
        if (pSDEActionWizardBase.isPSDEActionWizardIdDirty() && (bl || pSDEActionWizardBase.getPSDEActionWizardId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONWIZARDID, (Object)pSDEActionWizardBase.getPSDEActionWizardId());
        }
        if (pSDEActionWizardBase.isPSDEActionWizardNameDirty() && (bl || pSDEActionWizardBase.getPSDEActionWizardName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONWIZARDNAME, (Object)pSDEActionWizardBase.getPSDEActionWizardName());
        }
        if (pSDEActionWizardBase.isPSDEIdDirty() && (bl || pSDEActionWizardBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEActionWizardBase.getPSDEId());
        }
        if (pSDEActionWizardBase.isPSDENameDirty() && (bl || pSDEActionWizardBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEActionWizardBase.getPSDEName());
        }
        if (pSDEActionWizardBase.isPSDEViewBaseIdDirty() && (bl || pSDEActionWizardBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEActionWizardBase.getPSDEViewBaseId());
        }
        if (pSDEActionWizardBase.isPSDEViewBaseNameDirty() && (bl || pSDEActionWizardBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEActionWizardBase.getPSDEViewBaseName());
        }
        if (pSDEActionWizardBase.isUpdateDateDirty() && (bl || pSDEActionWizardBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEActionWizardBase.getUpdateDate());
        }
        if (pSDEActionWizardBase.isUpdateManDirty() && (bl || pSDEActionWizardBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEActionWizardBase.getUpdateMan());
        }
        if (pSDEActionWizardBase.isUserCatDirty() && (bl || pSDEActionWizardBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEActionWizardBase.getUserCat());
        }
        if (pSDEActionWizardBase.isUserTagDirty() && (bl || pSDEActionWizardBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEActionWizardBase.getUserTag());
        }
        if (pSDEActionWizardBase.isUserTag2Dirty() && (bl || pSDEActionWizardBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEActionWizardBase.getUserTag2());
        }
        if (pSDEActionWizardBase.isUserTag3Dirty() && (bl || pSDEActionWizardBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEActionWizardBase.getUserTag3());
        }
        if (pSDEActionWizardBase.isUserTag4Dirty() && (bl || pSDEActionWizardBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEActionWizardBase.getUserTag4());
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
        return PSDEActionWizardBase.remove(this, n);
    }

    private static boolean remove(PSDEActionWizardBase pSDEActionWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionWizardBase.resetAWIContentPSDEFId();
                return true;
            }
            case 1: {
                pSDEActionWizardBase.resetAWIContentPSDEFName();
                return true;
            }
            case 2: {
                pSDEActionWizardBase.resetAWIFKeyPSDEFId();
                return true;
            }
            case 3: {
                pSDEActionWizardBase.resetAWIFKeyPSDEFName();
                return true;
            }
            case 4: {
                pSDEActionWizardBase.resetAWINamePSDEFId();
                return true;
            }
            case 5: {
                pSDEActionWizardBase.resetAWINamePSDEFName();
                return true;
            }
            case 6: {
                pSDEActionWizardBase.resetAWIPSDEDSId();
                return true;
            }
            case 7: {
                pSDEActionWizardBase.resetAWIPSDEDSName();
                return true;
            }
            case 8: {
                pSDEActionWizardBase.resetAWIPSDEId();
                return true;
            }
            case 9: {
                pSDEActionWizardBase.resetAWIPSDEName();
                return true;
            }
            case 10: {
                pSDEActionWizardBase.resetAWISortPSDEFId();
                return true;
            }
            case 11: {
                pSDEActionWizardBase.resetAWISortPSDEFName();
                return true;
            }
            case 12: {
                pSDEActionWizardBase.resetAWIUrlPSDEFId();
                return true;
            }
            case 13: {
                pSDEActionWizardBase.resetAWIUrlPSDEFName();
                return true;
            }
            case 14: {
                pSDEActionWizardBase.resetAWIValuePSDEFId();
                return true;
            }
            case 15: {
                pSDEActionWizardBase.resetAWIValuePSDEFName();
                return true;
            }
            case 16: {
                pSDEActionWizardBase.resetAWKWPSDEFId();
                return true;
            }
            case 17: {
                pSDEActionWizardBase.resetAWKWPSDEFName();
                return true;
            }
            case 18: {
                pSDEActionWizardBase.resetAWNamePSDEFId();
                return true;
            }
            case 19: {
                pSDEActionWizardBase.resetAWNamePSDEFName();
                return true;
            }
            case 20: {
                pSDEActionWizardBase.resetAWPSDEDSId();
                return true;
            }
            case 21: {
                pSDEActionWizardBase.resetAWPSDEDSName();
                return true;
            }
            case 22: {
                pSDEActionWizardBase.resetAWPSDEId();
                return true;
            }
            case 23: {
                pSDEActionWizardBase.resetAWPSDEName();
                return true;
            }
            case 24: {
                pSDEActionWizardBase.resetAWSortPSDEFId();
                return true;
            }
            case 25: {
                pSDEActionWizardBase.resetAWSortPSDEFName();
                return true;
            }
            case 26: {
                pSDEActionWizardBase.resetCodeName();
                return true;
            }
            case 27: {
                pSDEActionWizardBase.resetCreateDate();
                return true;
            }
            case 28: {
                pSDEActionWizardBase.resetCreateMan();
                return true;
            }
            case 29: {
                pSDEActionWizardBase.resetDynamicMode();
                return true;
            }
            case 30: {
                pSDEActionWizardBase.resetKeywords();
                return true;
            }
            case 31: {
                pSDEActionWizardBase.resetLockFlag();
                return true;
            }
            case 32: {
                pSDEActionWizardBase.resetMemo();
                return true;
            }
            case 33: {
                pSDEActionWizardBase.resetPSDEActionWizardId();
                return true;
            }
            case 34: {
                pSDEActionWizardBase.resetPSDEActionWizardName();
                return true;
            }
            case 35: {
                pSDEActionWizardBase.resetPSDEId();
                return true;
            }
            case 36: {
                pSDEActionWizardBase.resetPSDEName();
                return true;
            }
            case 37: {
                pSDEActionWizardBase.resetPSDEViewBaseId();
                return true;
            }
            case 38: {
                pSDEActionWizardBase.resetPSDEViewBaseName();
                return true;
            }
            case 39: {
                pSDEActionWizardBase.resetUpdateDate();
                return true;
            }
            case 40: {
                pSDEActionWizardBase.resetUpdateMan();
                return true;
            }
            case 41: {
                pSDEActionWizardBase.resetUserCat();
                return true;
            }
            case 42: {
                pSDEActionWizardBase.resetUserTag();
                return true;
            }
            case 43: {
                pSDEActionWizardBase.resetUserTag2();
                return true;
            }
            case 44: {
                pSDEActionWizardBase.resetUserTag3();
                return true;
            }
            case 45: {
                pSDEActionWizardBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getAWIPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIPSDE();
        }
        if (this.getAWIPSDEId() == null) {
            return null;
        }
        Integer n = this.objAWIPSDELock;
        synchronized (n) {
            if (this.awipsde != null && DataTypeHelper.compare((int)25, (Object)this.getAWIPSDEId(), (Object)this.awipsde.getPSDataEntityId()) != 0L) {
                this.awipsde = null;
            }
            if (this.awipsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getAWIPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.awipsde = pSDataEntity;
            }
            return this.awipsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getAWPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWPSDE();
        }
        if (this.getAWPSDEId() == null) {
            return null;
        }
        Integer n = this.objAWPSDELock;
        synchronized (n) {
            if (this.awpsde != null && DataTypeHelper.compare((int)25, (Object)this.getAWPSDEId(), (Object)this.awpsde.getPSDataEntityId()) != 0L) {
                this.awpsde = null;
            }
            if (this.awpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getAWPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.awpsde = pSDataEntity;
            }
            return this.awpsde;
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
    public PSDEDataSet getAWIPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIPSDEDS();
        }
        if (this.getAWIPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objAWIPSDEDSLock;
        synchronized (n) {
            if (this.awipsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getAWIPSDEDSId(), (Object)this.awipsdeds.getPSDEDataSetId()) != 0L) {
                this.awipsdeds = null;
            }
            if (this.awipsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getAWIPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.awipsdeds = pSDEDataSet;
            }
            return this.awipsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getAWPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWPSDEDS();
        }
        if (this.getAWPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objAWPSDEDSLock;
        synchronized (n) {
            if (this.awpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getAWPSDEDSId(), (Object)this.awpsdeds.getPSDEDataSetId()) != 0L) {
                this.awpsdeds = null;
            }
            if (this.awpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getAWPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.awpsdeds = pSDEDataSet;
            }
            return this.awpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWIContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIContentPSDEF();
        }
        if (this.getAWIContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWIContentPSDEFLock;
        synchronized (n) {
            if (this.awicontentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWIContentPSDEFId(), (Object)this.awicontentpsdef.getPSDEFieldId()) != 0L) {
                this.awicontentpsdef = null;
            }
            if (this.awicontentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWIContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awicontentpsdef = pSDEField;
            }
            return this.awicontentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWIFKeyPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIFKeyPSDEF();
        }
        if (this.getAWIFKeyPSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWIFKeyPSDEFLock;
        synchronized (n) {
            if (this.awifkeypsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWIFKeyPSDEFId(), (Object)this.awifkeypsdef.getPSDEFieldId()) != 0L) {
                this.awifkeypsdef = null;
            }
            if (this.awifkeypsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWIFKeyPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awifkeypsdef = pSDEField;
            }
            return this.awifkeypsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWINamePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWINamePSDEF();
        }
        if (this.getAWINamePSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWINamePSDEFLock;
        synchronized (n) {
            if (this.awinamepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWINamePSDEFId(), (Object)this.awinamepsdef.getPSDEFieldId()) != 0L) {
                this.awinamepsdef = null;
            }
            if (this.awinamepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWINamePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awinamepsdef = pSDEField;
            }
            return this.awinamepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWISortPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWISortPSDEF();
        }
        if (this.getAWISortPSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWISortPSDEFLock;
        synchronized (n) {
            if (this.awisortpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWISortPSDEFId(), (Object)this.awisortpsdef.getPSDEFieldId()) != 0L) {
                this.awisortpsdef = null;
            }
            if (this.awisortpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWISortPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awisortpsdef = pSDEField;
            }
            return this.awisortpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWIUrlPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIUrlPSDEF();
        }
        if (this.getAWIUrlPSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWIUrlPSDEFLock;
        synchronized (n) {
            if (this.awiurlpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWIUrlPSDEFId(), (Object)this.awiurlpsdef.getPSDEFieldId()) != 0L) {
                this.awiurlpsdef = null;
            }
            if (this.awiurlpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWIUrlPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awiurlpsdef = pSDEField;
            }
            return this.awiurlpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWIValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWIValuePSDEF();
        }
        if (this.getAWIValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWIValuePSDEFLock;
        synchronized (n) {
            if (this.awivaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWIValuePSDEFId(), (Object)this.awivaluepsdef.getPSDEFieldId()) != 0L) {
                this.awivaluepsdef = null;
            }
            if (this.awivaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWIValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awivaluepsdef = pSDEField;
            }
            return this.awivaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWKWPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWKWPSDEF();
        }
        if (this.getAWKWPSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWKWPSDEFLock;
        synchronized (n) {
            if (this.awkwpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWKWPSDEFId(), (Object)this.awkwpsdef.getPSDEFieldId()) != 0L) {
                this.awkwpsdef = null;
            }
            if (this.awkwpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWKWPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awkwpsdef = pSDEField;
            }
            return this.awkwpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWNamePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWNamePSDEF();
        }
        if (this.getAWNamePSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWNamePSDEFLock;
        synchronized (n) {
            if (this.awnamepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWNamePSDEFId(), (Object)this.awnamepsdef.getPSDEFieldId()) != 0L) {
                this.awnamepsdef = null;
            }
            if (this.awnamepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWNamePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awnamepsdef = pSDEField;
            }
            return this.awnamepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getAWSortPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWSortPSDEF();
        }
        if (this.getAWSortPSDEFId() == null) {
            return null;
        }
        Integer n = this.objAWSortPSDEFLock;
        synchronized (n) {
            if (this.awsortpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getAWSortPSDEFId(), (Object)this.awsortpsdef.getPSDEFieldId()) != 0L) {
                this.awsortpsdef = null;
            }
            if (this.awsortpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getAWSortPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.awsortpsdef = pSDEField;
            }
            return this.awsortpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEAWItem> getPSDEAWItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWItems();
        }
        if (this.getPSDEActionWizardId() == null) {
            return null;
        }
        PSDEActionWizardService pSDEActionWizardService = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEAWItemsLock;
        synchronized (n) {
            if (this.psdeawitems == null) {
                this.psdeawitems = pSDEActionWizardService.isTempData(this) ? pSDEAWItemService.selectTempByPSDEActionWizard(this) : pSDEAWItemService.selectByPSDEActionWizard(this);
            }
            return this.psdeawitems;
        }
    }

    private PSDEActionWizardBase getProxyEntity() {
        return this.proxyPSDEActionWizardBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEActionWizardBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEActionWizardBase) {
            this.proxyPSDEActionWizardBase = (PSDEActionWizardBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AWICONTENTPSDEFID, 0);
        fieldIndexMap.put(FIELD_AWICONTENTPSDEFNAME, 1);
        fieldIndexMap.put(FIELD_AWIFKEYPSDEFID, 2);
        fieldIndexMap.put(FIELD_AWIFKEYPSDEFNAME, 3);
        fieldIndexMap.put(FIELD_AWINAMEPSDEFID, 4);
        fieldIndexMap.put(FIELD_AWINAMEPSDEFNAME, 5);
        fieldIndexMap.put(FIELD_AWIPSDEDSID, 6);
        fieldIndexMap.put(FIELD_AWIPSDEDSNAME, 7);
        fieldIndexMap.put(FIELD_AWIPSDEID, 8);
        fieldIndexMap.put(FIELD_AWIPSDENAME, 9);
        fieldIndexMap.put(FIELD_AWISORTPSDEFID, 10);
        fieldIndexMap.put(FIELD_AWISORTPSDEFNAME, 11);
        fieldIndexMap.put(FIELD_AWIURLPSDEFID, 12);
        fieldIndexMap.put(FIELD_AWIURLPSDEFNAME, 13);
        fieldIndexMap.put(FIELD_AWIVALUEPSDEFID, 14);
        fieldIndexMap.put(FIELD_AWIVALUEPSDEFNAME, 15);
        fieldIndexMap.put(FIELD_AWKWPSDEFID, 16);
        fieldIndexMap.put(FIELD_AWKWPSDEFNAME, 17);
        fieldIndexMap.put(FIELD_AWNAMEPSDEFID, 18);
        fieldIndexMap.put(FIELD_AWNAMEPSDEFNAME, 19);
        fieldIndexMap.put(FIELD_AWPSDEDSID, 20);
        fieldIndexMap.put(FIELD_AWPSDEDSNAME, 21);
        fieldIndexMap.put(FIELD_AWPSDEID, 22);
        fieldIndexMap.put(FIELD_AWPSDENAME, 23);
        fieldIndexMap.put(FIELD_AWSORTPSDEFID, 24);
        fieldIndexMap.put(FIELD_AWSORTPSDEFNAME, 25);
        fieldIndexMap.put(FIELD_CODENAME, 26);
        fieldIndexMap.put(FIELD_CREATEDATE, 27);
        fieldIndexMap.put(FIELD_CREATEMAN, 28);
        fieldIndexMap.put(FIELD_DYNAMICMODE, 29);
        fieldIndexMap.put(FIELD_KEYWORDS, 30);
        fieldIndexMap.put(FIELD_LOCKFLAG, 31);
        fieldIndexMap.put(FIELD_MEMO, 32);
        fieldIndexMap.put(FIELD_PSDEACTIONWIZARDID, 33);
        fieldIndexMap.put(FIELD_PSDEACTIONWIZARDNAME, 34);
        fieldIndexMap.put(FIELD_PSDEID, 35);
        fieldIndexMap.put(FIELD_PSDENAME, 36);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 37);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 38);
        fieldIndexMap.put(FIELD_UPDATEDATE, 39);
        fieldIndexMap.put(FIELD_UPDATEMAN, 40);
        fieldIndexMap.put(FIELD_USERCAT, 41);
        fieldIndexMap.put(FIELD_USERTAG, 42);
        fieldIndexMap.put(FIELD_USERTAG2, 43);
        fieldIndexMap.put(FIELD_USERTAG3, 44);
        fieldIndexMap.put(FIELD_USERTAG4, 45);
    }
}

