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
package net.ibizsys.pscore.srv.systest.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCInput;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.service.PSSysTCInputService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTCAssertBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTCAssertBase.class);
    public static final String FIELD_ASSERTRESULT = "ASSERTRESULT";
    public static final String FIELD_ASSERTTAG = "ASSERTTAG";
    public static final String FIELD_ASSERTTAG2 = "ASSERTTAG2";
    public static final String FIELD_ASSERTTAG3 = "ASSERTTAG3";
    public static final String FIELD_ASSERTTAG4 = "ASSERTTAG4";
    public static final String FIELD_ASSERTTYPE = "ASSERTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DSTKEYPSDEFID = "DSTKEYPSDEFID";
    public static final String FIELD_DSTKEYPSDEFNAME = "DSTKEYPSDEFNAME";
    public static final String FIELD_DSTPSDEID = "DSTPSDEID";
    public static final String FIELD_DSTPSDENAME = "DSTPSDENAME";
    public static final String FIELD_EXCEPTIONDATA = "EXCEPTIONDATA";
    public static final String FIELD_EXCEPTIONDATA2 = "EXCEPTIONDATA2";
    public static final String FIELD_EXCEPTIONNAME = "EXCEPTIONNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSTCASSERTID = "PSSYSTCASSERTID";
    public static final String FIELD_PSSYSTCASSERTNAME = "PSSYSTCASSERTNAME";
    public static final String FIELD_PSSYSTCINPUTID = "PSSYSTCINPUTID";
    public static final String FIELD_PSSYSTCINPUTNAME = "PSSYSTCINPUTNAME";
    public static final String FIELD_PSSYSTESTCASEID = "PSSYSTESTCASEID";
    public static final String FIELD_PSSYSTESTCASENAME = "PSSYSTESTCASENAME";
    public static final String FIELD_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String FIELD_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_TESTDATASN = "TESTDATASN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ASSERTRESULT = 0;
    private static final int INDEX_ASSERTTAG = 1;
    private static final int INDEX_ASSERTTAG2 = 2;
    private static final int INDEX_ASSERTTAG3 = 3;
    private static final int INDEX_ASSERTTAG4 = 4;
    private static final int INDEX_ASSERTTYPE = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_CUSTOMCODE = 8;
    private static final int INDEX_DSTKEYPSDEFID = 9;
    private static final int INDEX_DSTKEYPSDEFNAME = 10;
    private static final int INDEX_DSTPSDEID = 11;
    private static final int INDEX_DSTPSDENAME = 12;
    private static final int INDEX_EXCEPTIONDATA = 13;
    private static final int INDEX_EXCEPTIONDATA2 = 14;
    private static final int INDEX_EXCEPTIONNAME = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_ORDERVALUE = 17;
    private static final int INDEX_PSDEID = 18;
    private static final int INDEX_PSSYSTCASSERTID = 19;
    private static final int INDEX_PSSYSTCASSERTNAME = 20;
    private static final int INDEX_PSSYSTCINPUTID = 21;
    private static final int INDEX_PSSYSTCINPUTNAME = 22;
    private static final int INDEX_PSSYSTESTCASEID = 23;
    private static final int INDEX_PSSYSTESTCASENAME = 24;
    private static final int INDEX_PSSYSTESTDATAID = 25;
    private static final int INDEX_PSSYSTESTDATANAME = 26;
    private static final int INDEX_TARGETTYPE = 27;
    private static final int INDEX_TESTDATASN = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USERCAT = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final int INDEX_VALIDFLAG = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTCAssertBase proxyPSSysTCAssertBase = null;
    private boolean assertresultDirtyFlag = false;
    private boolean asserttagDirtyFlag = false;
    private boolean asserttag2DirtyFlag = false;
    private boolean asserttag3DirtyFlag = false;
    private boolean asserttag4DirtyFlag = false;
    private boolean asserttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dstkeypsdefidDirtyFlag = false;
    private boolean dstkeypsdefnameDirtyFlag = false;
    private boolean dstpsdeidDirtyFlag = false;
    private boolean dstpsdenameDirtyFlag = false;
    private boolean exceptiondataDirtyFlag = false;
    private boolean exceptiondata2DirtyFlag = false;
    private boolean exceptionnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssystcassertidDirtyFlag = false;
    private boolean pssystcassertnameDirtyFlag = false;
    private boolean pssystcinputidDirtyFlag = false;
    private boolean pssystcinputnameDirtyFlag = false;
    private boolean pssystestcaseidDirtyFlag = false;
    private boolean pssystestcasenameDirtyFlag = false;
    private boolean pssystestdataidDirtyFlag = false;
    private boolean pssystestdatanameDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
    private boolean testdatasnDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="assertresult")
    private String assertresult;
    @Column(name="asserttag")
    private String asserttag;
    @Column(name="asserttag2")
    private String asserttag2;
    @Column(name="asserttag3")
    private String asserttag3;
    @Column(name="asserttag4")
    private String asserttag4;
    @Column(name="asserttype")
    private String asserttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="dstkeypsdefid")
    private String dstkeypsdefid;
    @Column(name="dstkeypsdefname")
    private String dstkeypsdefname;
    @Column(name="dstpsdeid")
    private String dstpsdeid;
    @Column(name="dstpsdename")
    private String dstpsdename;
    @Column(name="exceptiondata")
    private String exceptiondata;
    @Column(name="exceptiondata2")
    private String exceptiondata2;
    @Column(name="exceptionname")
    private String exceptionname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssystcassertid")
    private String pssystcassertid;
    @Column(name="pssystcassertname")
    private String pssystcassertname;
    @Column(name="pssystcinputid")
    private String pssystcinputid;
    @Column(name="pssystcinputname")
    private String pssystcinputname;
    @Column(name="pssystestcaseid")
    private String pssystestcaseid;
    @Column(name="pssystestcasename")
    private String pssystestcasename;
    @Column(name="pssystestdataid")
    private String pssystestdataid;
    @Column(name="pssystestdataname")
    private String pssystestdataname;
    @Column(name="targettype")
    private String targettype;
    @Column(name="testdatasn")
    private Integer testdatasn;
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
    private Integer objDstPSDELock = new Integer(1);
    private PSDataEntity dstpsde = null;
    private Integer objDstKeyPSDEFLock = new Integer(1);
    private PSDEField dstkeypsdef = null;
    private Integer objPSSysTCInputLock = new Integer(1);
    private PSSysTCInput pssystcinput = null;
    private Integer objPSSysTestCaseLock = new Integer(1);
    private PSSysTestCase pssystestcase = null;
    private Integer objPSSysTestDataLock = new Integer(1);
    private PSSysTestData pssystestdata = null;

    public void setAssertResult(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAssertResult(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.assertresult = string;
        this.assertresultDirtyFlag = true;
    }

    public String getAssertResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAssertResult();
        }
        return this.assertresult;
    }

    public boolean isAssertResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAssertResultDirty();
        }
        return this.assertresultDirtyFlag;
    }

    public void resetAssertResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAssertResult();
            return;
        }
        this.assertresultDirtyFlag = false;
        this.assertresult = null;
    }

    public void setAssertTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAssertTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asserttag = string;
        this.asserttagDirtyFlag = true;
    }

    public String getAssertTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAssertTag();
        }
        return this.asserttag;
    }

    public boolean isAssertTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAssertTagDirty();
        }
        return this.asserttagDirtyFlag;
    }

    public void resetAssertTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAssertTag();
            return;
        }
        this.asserttagDirtyFlag = false;
        this.asserttag = null;
    }

    public void setAssertTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAssertTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asserttag2 = string;
        this.asserttag2DirtyFlag = true;
    }

    public String getAssertTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAssertTag2();
        }
        return this.asserttag2;
    }

    public boolean isAssertTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAssertTag2Dirty();
        }
        return this.asserttag2DirtyFlag;
    }

    public void resetAssertTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAssertTag2();
            return;
        }
        this.asserttag2DirtyFlag = false;
        this.asserttag2 = null;
    }

    public void setAssertTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAssertTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asserttag3 = string;
        this.asserttag3DirtyFlag = true;
    }

    public String getAssertTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAssertTag3();
        }
        return this.asserttag3;
    }

    public boolean isAssertTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAssertTag3Dirty();
        }
        return this.asserttag3DirtyFlag;
    }

    public void resetAssertTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAssertTag3();
            return;
        }
        this.asserttag3DirtyFlag = false;
        this.asserttag3 = null;
    }

    public void setAssertTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAssertTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asserttag4 = string;
        this.asserttag4DirtyFlag = true;
    }

    public String getAssertTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAssertTag4();
        }
        return this.asserttag4;
    }

    public boolean isAssertTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAssertTag4Dirty();
        }
        return this.asserttag4DirtyFlag;
    }

    public void resetAssertTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAssertTag4();
            return;
        }
        this.asserttag4DirtyFlag = false;
        this.asserttag4 = null;
    }

    public void setAssertType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAssertType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asserttype = string;
        this.asserttypeDirtyFlag = true;
    }

    public String getAssertType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAssertType();
        }
        return this.asserttype;
    }

    public boolean isAssertTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAssertTypeDirty();
        }
        return this.asserttypeDirtyFlag;
    }

    public void resetAssertType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAssertType();
            return;
        }
        this.asserttypeDirtyFlag = false;
        this.asserttype = null;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setDstKeyPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstKeyPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstkeypsdefid = string;
        this.dstkeypsdefidDirtyFlag = true;
    }

    public String getDstKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstKeyPSDEFId();
        }
        return this.dstkeypsdefid;
    }

    public boolean isDstKeyPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstKeyPSDEFIdDirty();
        }
        return this.dstkeypsdefidDirtyFlag;
    }

    public void resetDstKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstKeyPSDEFId();
            return;
        }
        this.dstkeypsdefidDirtyFlag = false;
        this.dstkeypsdefid = null;
    }

    public void setDstKeyPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstKeyPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstkeypsdefname = string;
        this.dstkeypsdefnameDirtyFlag = true;
    }

    public String getDstKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstKeyPSDEFName();
        }
        return this.dstkeypsdefname;
    }

    public boolean isDstKeyPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstKeyPSDEFNameDirty();
        }
        return this.dstkeypsdefnameDirtyFlag;
    }

    public void resetDstKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstKeyPSDEFName();
            return;
        }
        this.dstkeypsdefnameDirtyFlag = false;
        this.dstkeypsdefname = null;
    }

    public void setDstPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeid = string;
        this.dstpsdeidDirtyFlag = true;
    }

    public String getDstPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEId();
        }
        return this.dstpsdeid;
    }

    public boolean isDstPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEIdDirty();
        }
        return this.dstpsdeidDirtyFlag;
    }

    public void resetDstPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEId();
            return;
        }
        this.dstpsdeidDirtyFlag = false;
        this.dstpsdeid = null;
    }

    public void setDstPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdename = string;
        this.dstpsdenameDirtyFlag = true;
    }

    public String getDstPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEName();
        }
        return this.dstpsdename;
    }

    public boolean isDstPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDENameDirty();
        }
        return this.dstpsdenameDirtyFlag;
    }

    public void resetDstPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEName();
            return;
        }
        this.dstpsdenameDirtyFlag = false;
        this.dstpsdename = null;
    }

    public void setExceptionData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExceptionData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exceptiondata = string;
        this.exceptiondataDirtyFlag = true;
    }

    public String getExceptionData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExceptionData();
        }
        return this.exceptiondata;
    }

    public boolean isExceptionDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExceptionDataDirty();
        }
        return this.exceptiondataDirtyFlag;
    }

    public void resetExceptionData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExceptionData();
            return;
        }
        this.exceptiondataDirtyFlag = false;
        this.exceptiondata = null;
    }

    public void setExceptionData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExceptionData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exceptiondata2 = string;
        this.exceptiondata2DirtyFlag = true;
    }

    public String getExceptionData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExceptionData2();
        }
        return this.exceptiondata2;
    }

    public boolean isExceptionData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExceptionData2Dirty();
        }
        return this.exceptiondata2DirtyFlag;
    }

    public void resetExceptionData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExceptionData2();
            return;
        }
        this.exceptiondata2DirtyFlag = false;
        this.exceptiondata2 = null;
    }

    public void setExceptionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExceptionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exceptionname = string;
        this.exceptionnameDirtyFlag = true;
    }

    public String getExceptionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExceptionName();
        }
        return this.exceptionname;
    }

    public boolean isExceptionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExceptionNameDirty();
        }
        return this.exceptionnameDirtyFlag;
    }

    public void resetExceptionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExceptionName();
            return;
        }
        this.exceptionnameDirtyFlag = false;
        this.exceptionname = null;
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

    public void setPSSysTCAssertId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTCAssertId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystcassertid = string;
        this.pssystcassertidDirtyFlag = true;
    }

    public String getPSSysTCAssertId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTCAssertId();
        }
        return this.pssystcassertid;
    }

    public boolean isPSSysTCAssertIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTCAssertIdDirty();
        }
        return this.pssystcassertidDirtyFlag;
    }

    public void resetPSSysTCAssertId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTCAssertId();
            return;
        }
        this.pssystcassertidDirtyFlag = false;
        this.pssystcassertid = null;
    }

    public void setPSSysTCAssertName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTCAssertName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystcassertname = string;
        this.pssystcassertnameDirtyFlag = true;
    }

    public String getPSSysTCAssertName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTCAssertName();
        }
        return this.pssystcassertname;
    }

    public boolean isPSSysTCAssertNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTCAssertNameDirty();
        }
        return this.pssystcassertnameDirtyFlag;
    }

    public void resetPSSysTCAssertName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTCAssertName();
            return;
        }
        this.pssystcassertnameDirtyFlag = false;
        this.pssystcassertname = null;
    }

    public void setPSSysTCInputId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTCInputId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystcinputid = string;
        this.pssystcinputidDirtyFlag = true;
    }

    public String getPSSysTCInputId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTCInputId();
        }
        return this.pssystcinputid;
    }

    public boolean isPSSysTCInputIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTCInputIdDirty();
        }
        return this.pssystcinputidDirtyFlag;
    }

    public void resetPSSysTCInputId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTCInputId();
            return;
        }
        this.pssystcinputidDirtyFlag = false;
        this.pssystcinputid = null;
    }

    public void setPSSysTCInputName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTCInputName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystcinputname = string;
        this.pssystcinputnameDirtyFlag = true;
    }

    public String getPSSysTCInputName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTCInputName();
        }
        return this.pssystcinputname;
    }

    public boolean isPSSysTCInputNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTCInputNameDirty();
        }
        return this.pssystcinputnameDirtyFlag;
    }

    public void resetPSSysTCInputName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTCInputName();
            return;
        }
        this.pssystcinputnameDirtyFlag = false;
        this.pssystcinputname = null;
    }

    public void setPSSysTestCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestcaseid = string;
        this.pssystestcaseidDirtyFlag = true;
    }

    public String getPSSysTestCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCaseId();
        }
        return this.pssystestcaseid;
    }

    public boolean isPSSysTestCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCaseIdDirty();
        }
        return this.pssystestcaseidDirtyFlag;
    }

    public void resetPSSysTestCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCaseId();
            return;
        }
        this.pssystestcaseidDirtyFlag = false;
        this.pssystestcaseid = null;
    }

    public void setPSSysTestCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestcasename = string;
        this.pssystestcasenameDirtyFlag = true;
    }

    public String getPSSysTestCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCaseName();
        }
        return this.pssystestcasename;
    }

    public boolean isPSSysTestCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCaseNameDirty();
        }
        return this.pssystestcasenameDirtyFlag;
    }

    public void resetPSSysTestCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCaseName();
            return;
        }
        this.pssystestcasenameDirtyFlag = false;
        this.pssystestcasename = null;
    }

    public void setPSSysTestDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestdataid = string;
        this.pssystestdataidDirtyFlag = true;
    }

    public String getPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDataId();
        }
        return this.pssystestdataid;
    }

    public boolean isPSSysTestDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDataIdDirty();
        }
        return this.pssystestdataidDirtyFlag;
    }

    public void resetPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDataId();
            return;
        }
        this.pssystestdataidDirtyFlag = false;
        this.pssystestdataid = null;
    }

    public void setPSSysTestDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestdataname = string;
        this.pssystestdatanameDirtyFlag = true;
    }

    public String getPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDataName();
        }
        return this.pssystestdataname;
    }

    public boolean isPSSysTestDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDataNameDirty();
        }
        return this.pssystestdatanameDirtyFlag;
    }

    public void resetPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDataName();
            return;
        }
        this.pssystestdatanameDirtyFlag = false;
        this.pssystestdataname = null;
    }

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
    }

    public void setTestDataSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestDataSN(n);
            return;
        }
        this.testdatasn = n;
        this.testdatasnDirtyFlag = true;
    }

    public Integer getTestDataSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestDataSN();
        }
        return this.testdatasn;
    }

    public boolean isTestDataSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestDataSNDirty();
        }
        return this.testdatasnDirtyFlag;
    }

    public void resetTestDataSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestDataSN();
            return;
        }
        this.testdatasnDirtyFlag = false;
        this.testdatasn = null;
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
        PSSysTCAssertBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTCAssertBase pSSysTCAssertBase) {
        pSSysTCAssertBase.resetAssertResult();
        pSSysTCAssertBase.resetAssertTag();
        pSSysTCAssertBase.resetAssertTag2();
        pSSysTCAssertBase.resetAssertTag3();
        pSSysTCAssertBase.resetAssertTag4();
        pSSysTCAssertBase.resetAssertType();
        pSSysTCAssertBase.resetCreateDate();
        pSSysTCAssertBase.resetCreateMan();
        pSSysTCAssertBase.resetCustomCode();
        pSSysTCAssertBase.resetDstKeyPSDEFId();
        pSSysTCAssertBase.resetDstKeyPSDEFName();
        pSSysTCAssertBase.resetDstPSDEId();
        pSSysTCAssertBase.resetDstPSDEName();
        pSSysTCAssertBase.resetExceptionData();
        pSSysTCAssertBase.resetExceptionData2();
        pSSysTCAssertBase.resetExceptionName();
        pSSysTCAssertBase.resetMemo();
        pSSysTCAssertBase.resetOrderValue();
        pSSysTCAssertBase.resetPSDEId();
        pSSysTCAssertBase.resetPSSysTCAssertId();
        pSSysTCAssertBase.resetPSSysTCAssertName();
        pSSysTCAssertBase.resetPSSysTCInputId();
        pSSysTCAssertBase.resetPSSysTCInputName();
        pSSysTCAssertBase.resetPSSysTestCaseId();
        pSSysTCAssertBase.resetPSSysTestCaseName();
        pSSysTCAssertBase.resetPSSysTestDataId();
        pSSysTCAssertBase.resetPSSysTestDataName();
        pSSysTCAssertBase.resetTargetType();
        pSSysTCAssertBase.resetTestDataSN();
        pSSysTCAssertBase.resetUpdateDate();
        pSSysTCAssertBase.resetUpdateMan();
        pSSysTCAssertBase.resetUserCat();
        pSSysTCAssertBase.resetUserTag();
        pSSysTCAssertBase.resetUserTag2();
        pSSysTCAssertBase.resetUserTag3();
        pSSysTCAssertBase.resetUserTag4();
        pSSysTCAssertBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAssertResultDirty()) {
            hashMap.put(FIELD_ASSERTRESULT, this.getAssertResult());
        }
        if (!bl || this.isAssertTagDirty()) {
            hashMap.put(FIELD_ASSERTTAG, this.getAssertTag());
        }
        if (!bl || this.isAssertTag2Dirty()) {
            hashMap.put(FIELD_ASSERTTAG2, this.getAssertTag2());
        }
        if (!bl || this.isAssertTag3Dirty()) {
            hashMap.put(FIELD_ASSERTTAG3, this.getAssertTag3());
        }
        if (!bl || this.isAssertTag4Dirty()) {
            hashMap.put(FIELD_ASSERTTAG4, this.getAssertTag4());
        }
        if (!bl || this.isAssertTypeDirty()) {
            hashMap.put(FIELD_ASSERTTYPE, this.getAssertType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isDstKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_DSTKEYPSDEFID, this.getDstKeyPSDEFId());
        }
        if (!bl || this.isDstKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_DSTKEYPSDEFNAME, this.getDstKeyPSDEFName());
        }
        if (!bl || this.isDstPSDEIdDirty()) {
            hashMap.put(FIELD_DSTPSDEID, this.getDstPSDEId());
        }
        if (!bl || this.isDstPSDENameDirty()) {
            hashMap.put(FIELD_DSTPSDENAME, this.getDstPSDEName());
        }
        if (!bl || this.isExceptionDataDirty()) {
            hashMap.put(FIELD_EXCEPTIONDATA, this.getExceptionData());
        }
        if (!bl || this.isExceptionData2Dirty()) {
            hashMap.put(FIELD_EXCEPTIONDATA2, this.getExceptionData2());
        }
        if (!bl || this.isExceptionNameDirty()) {
            hashMap.put(FIELD_EXCEPTIONNAME, this.getExceptionName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysTCAssertIdDirty()) {
            hashMap.put(FIELD_PSSYSTCASSERTID, this.getPSSysTCAssertId());
        }
        if (!bl || this.isPSSysTCAssertNameDirty()) {
            hashMap.put(FIELD_PSSYSTCASSERTNAME, this.getPSSysTCAssertName());
        }
        if (!bl || this.isPSSysTCInputIdDirty()) {
            hashMap.put(FIELD_PSSYSTCINPUTID, this.getPSSysTCInputId());
        }
        if (!bl || this.isPSSysTCInputNameDirty()) {
            hashMap.put(FIELD_PSSYSTCINPUTNAME, this.getPSSysTCInputName());
        }
        if (!bl || this.isPSSysTestCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASEID, this.getPSSysTestCaseId());
        }
        if (!bl || this.isPSSysTestCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASENAME, this.getPSSysTestCaseName());
        }
        if (!bl || this.isPSSysTestDataIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATAID, this.getPSSysTestDataId());
        }
        if (!bl || this.isPSSysTestDataNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATANAME, this.getPSSysTestDataName());
        }
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
        }
        if (!bl || this.isTestDataSNDirty()) {
            hashMap.put(FIELD_TESTDATASN, this.getTestDataSN());
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
        return PSSysTCAssertBase.get(this, n);
    }

    private static Object get(PSSysTCAssertBase pSSysTCAssertBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTCAssertBase.getAssertResult();
            }
            case 1: {
                return pSSysTCAssertBase.getAssertTag();
            }
            case 2: {
                return pSSysTCAssertBase.getAssertTag2();
            }
            case 3: {
                return pSSysTCAssertBase.getAssertTag3();
            }
            case 4: {
                return pSSysTCAssertBase.getAssertTag4();
            }
            case 5: {
                return pSSysTCAssertBase.getAssertType();
            }
            case 6: {
                return pSSysTCAssertBase.getCreateDate();
            }
            case 7: {
                return pSSysTCAssertBase.getCreateMan();
            }
            case 8: {
                return pSSysTCAssertBase.getCustomCode();
            }
            case 9: {
                return pSSysTCAssertBase.getDstKeyPSDEFId();
            }
            case 10: {
                return pSSysTCAssertBase.getDstKeyPSDEFName();
            }
            case 11: {
                return pSSysTCAssertBase.getDstPSDEId();
            }
            case 12: {
                return pSSysTCAssertBase.getDstPSDEName();
            }
            case 13: {
                return pSSysTCAssertBase.getExceptionData();
            }
            case 14: {
                return pSSysTCAssertBase.getExceptionData2();
            }
            case 15: {
                return pSSysTCAssertBase.getExceptionName();
            }
            case 16: {
                return pSSysTCAssertBase.getMemo();
            }
            case 17: {
                return pSSysTCAssertBase.getOrderValue();
            }
            case 18: {
                return pSSysTCAssertBase.getPSDEId();
            }
            case 19: {
                return pSSysTCAssertBase.getPSSysTCAssertId();
            }
            case 20: {
                return pSSysTCAssertBase.getPSSysTCAssertName();
            }
            case 21: {
                return pSSysTCAssertBase.getPSSysTCInputId();
            }
            case 22: {
                return pSSysTCAssertBase.getPSSysTCInputName();
            }
            case 23: {
                return pSSysTCAssertBase.getPSSysTestCaseId();
            }
            case 24: {
                return pSSysTCAssertBase.getPSSysTestCaseName();
            }
            case 25: {
                return pSSysTCAssertBase.getPSSysTestDataId();
            }
            case 26: {
                return pSSysTCAssertBase.getPSSysTestDataName();
            }
            case 27: {
                return pSSysTCAssertBase.getTargetType();
            }
            case 28: {
                return pSSysTCAssertBase.getTestDataSN();
            }
            case 29: {
                return pSSysTCAssertBase.getUpdateDate();
            }
            case 30: {
                return pSSysTCAssertBase.getUpdateMan();
            }
            case 31: {
                return pSSysTCAssertBase.getUserCat();
            }
            case 32: {
                return pSSysTCAssertBase.getUserTag();
            }
            case 33: {
                return pSSysTCAssertBase.getUserTag2();
            }
            case 34: {
                return pSSysTCAssertBase.getUserTag3();
            }
            case 35: {
                return pSSysTCAssertBase.getUserTag4();
            }
            case 36: {
                return pSSysTCAssertBase.getValidFlag();
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
        PSSysTCAssertBase.set(this, n, object);
    }

    private static void set(PSSysTCAssertBase pSSysTCAssertBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTCAssertBase.setAssertResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTCAssertBase.setAssertTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysTCAssertBase.setAssertTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTCAssertBase.setAssertTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysTCAssertBase.setAssertTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTCAssertBase.setAssertType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTCAssertBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysTCAssertBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTCAssertBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTCAssertBase.setDstKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTCAssertBase.setDstKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTCAssertBase.setDstPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTCAssertBase.setDstPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTCAssertBase.setExceptionData(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTCAssertBase.setExceptionData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTCAssertBase.setExceptionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTCAssertBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTCAssertBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysTCAssertBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTCAssertBase.setPSSysTCAssertId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTCAssertBase.setPSSysTCAssertName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTCAssertBase.setPSSysTCInputId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTCAssertBase.setPSSysTCInputName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysTCAssertBase.setPSSysTestCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTCAssertBase.setPSSysTestCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysTCAssertBase.setPSSysTestDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysTCAssertBase.setPSSysTestDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysTCAssertBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysTCAssertBase.setTestDataSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysTCAssertBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSSysTCAssertBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysTCAssertBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysTCAssertBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysTCAssertBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysTCAssertBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysTCAssertBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysTCAssertBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysTCAssertBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTCAssertBase pSSysTCAssertBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTCAssertBase.getAssertResult() == null;
            }
            case 1: {
                return pSSysTCAssertBase.getAssertTag() == null;
            }
            case 2: {
                return pSSysTCAssertBase.getAssertTag2() == null;
            }
            case 3: {
                return pSSysTCAssertBase.getAssertTag3() == null;
            }
            case 4: {
                return pSSysTCAssertBase.getAssertTag4() == null;
            }
            case 5: {
                return pSSysTCAssertBase.getAssertType() == null;
            }
            case 6: {
                return pSSysTCAssertBase.getCreateDate() == null;
            }
            case 7: {
                return pSSysTCAssertBase.getCreateMan() == null;
            }
            case 8: {
                return pSSysTCAssertBase.getCustomCode() == null;
            }
            case 9: {
                return pSSysTCAssertBase.getDstKeyPSDEFId() == null;
            }
            case 10: {
                return pSSysTCAssertBase.getDstKeyPSDEFName() == null;
            }
            case 11: {
                return pSSysTCAssertBase.getDstPSDEId() == null;
            }
            case 12: {
                return pSSysTCAssertBase.getDstPSDEName() == null;
            }
            case 13: {
                return pSSysTCAssertBase.getExceptionData() == null;
            }
            case 14: {
                return pSSysTCAssertBase.getExceptionData2() == null;
            }
            case 15: {
                return pSSysTCAssertBase.getExceptionName() == null;
            }
            case 16: {
                return pSSysTCAssertBase.getMemo() == null;
            }
            case 17: {
                return pSSysTCAssertBase.getOrderValue() == null;
            }
            case 18: {
                return pSSysTCAssertBase.getPSDEId() == null;
            }
            case 19: {
                return pSSysTCAssertBase.getPSSysTCAssertId() == null;
            }
            case 20: {
                return pSSysTCAssertBase.getPSSysTCAssertName() == null;
            }
            case 21: {
                return pSSysTCAssertBase.getPSSysTCInputId() == null;
            }
            case 22: {
                return pSSysTCAssertBase.getPSSysTCInputName() == null;
            }
            case 23: {
                return pSSysTCAssertBase.getPSSysTestCaseId() == null;
            }
            case 24: {
                return pSSysTCAssertBase.getPSSysTestCaseName() == null;
            }
            case 25: {
                return pSSysTCAssertBase.getPSSysTestDataId() == null;
            }
            case 26: {
                return pSSysTCAssertBase.getPSSysTestDataName() == null;
            }
            case 27: {
                return pSSysTCAssertBase.getTargetType() == null;
            }
            case 28: {
                return pSSysTCAssertBase.getTestDataSN() == null;
            }
            case 29: {
                return pSSysTCAssertBase.getUpdateDate() == null;
            }
            case 30: {
                return pSSysTCAssertBase.getUpdateMan() == null;
            }
            case 31: {
                return pSSysTCAssertBase.getUserCat() == null;
            }
            case 32: {
                return pSSysTCAssertBase.getUserTag() == null;
            }
            case 33: {
                return pSSysTCAssertBase.getUserTag2() == null;
            }
            case 34: {
                return pSSysTCAssertBase.getUserTag3() == null;
            }
            case 35: {
                return pSSysTCAssertBase.getUserTag4() == null;
            }
            case 36: {
                return pSSysTCAssertBase.getValidFlag() == null;
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
        return PSSysTCAssertBase.contains(this, n);
    }

    private static boolean contains(PSSysTCAssertBase pSSysTCAssertBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTCAssertBase.isAssertResultDirty();
            }
            case 1: {
                return pSSysTCAssertBase.isAssertTagDirty();
            }
            case 2: {
                return pSSysTCAssertBase.isAssertTag2Dirty();
            }
            case 3: {
                return pSSysTCAssertBase.isAssertTag3Dirty();
            }
            case 4: {
                return pSSysTCAssertBase.isAssertTag4Dirty();
            }
            case 5: {
                return pSSysTCAssertBase.isAssertTypeDirty();
            }
            case 6: {
                return pSSysTCAssertBase.isCreateDateDirty();
            }
            case 7: {
                return pSSysTCAssertBase.isCreateManDirty();
            }
            case 8: {
                return pSSysTCAssertBase.isCustomCodeDirty();
            }
            case 9: {
                return pSSysTCAssertBase.isDstKeyPSDEFIdDirty();
            }
            case 10: {
                return pSSysTCAssertBase.isDstKeyPSDEFNameDirty();
            }
            case 11: {
                return pSSysTCAssertBase.isDstPSDEIdDirty();
            }
            case 12: {
                return pSSysTCAssertBase.isDstPSDENameDirty();
            }
            case 13: {
                return pSSysTCAssertBase.isExceptionDataDirty();
            }
            case 14: {
                return pSSysTCAssertBase.isExceptionData2Dirty();
            }
            case 15: {
                return pSSysTCAssertBase.isExceptionNameDirty();
            }
            case 16: {
                return pSSysTCAssertBase.isMemoDirty();
            }
            case 17: {
                return pSSysTCAssertBase.isOrderValueDirty();
            }
            case 18: {
                return pSSysTCAssertBase.isPSDEIdDirty();
            }
            case 19: {
                return pSSysTCAssertBase.isPSSysTCAssertIdDirty();
            }
            case 20: {
                return pSSysTCAssertBase.isPSSysTCAssertNameDirty();
            }
            case 21: {
                return pSSysTCAssertBase.isPSSysTCInputIdDirty();
            }
            case 22: {
                return pSSysTCAssertBase.isPSSysTCInputNameDirty();
            }
            case 23: {
                return pSSysTCAssertBase.isPSSysTestCaseIdDirty();
            }
            case 24: {
                return pSSysTCAssertBase.isPSSysTestCaseNameDirty();
            }
            case 25: {
                return pSSysTCAssertBase.isPSSysTestDataIdDirty();
            }
            case 26: {
                return pSSysTCAssertBase.isPSSysTestDataNameDirty();
            }
            case 27: {
                return pSSysTCAssertBase.isTargetTypeDirty();
            }
            case 28: {
                return pSSysTCAssertBase.isTestDataSNDirty();
            }
            case 29: {
                return pSSysTCAssertBase.isUpdateDateDirty();
            }
            case 30: {
                return pSSysTCAssertBase.isUpdateManDirty();
            }
            case 31: {
                return pSSysTCAssertBase.isUserCatDirty();
            }
            case 32: {
                return pSSysTCAssertBase.isUserTagDirty();
            }
            case 33: {
                return pSSysTCAssertBase.isUserTag2Dirty();
            }
            case 34: {
                return pSSysTCAssertBase.isUserTag3Dirty();
            }
            case 35: {
                return pSSysTCAssertBase.isUserTag4Dirty();
            }
            case 36: {
                return pSSysTCAssertBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTCAssertBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTCAssertBase pSSysTCAssertBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTCAssertBase.getAssertResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"assertresult", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getAssertResult()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getAssertTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asserttag", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getAssertTag()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getAssertTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asserttag2", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getAssertTag2()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getAssertTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asserttag3", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getAssertTag3()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getAssertTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asserttag4", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getAssertTag4()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getAssertType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asserttype", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getAssertType()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getDstKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstkeypsdefid", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getDstKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getDstKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstkeypsdefname", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getDstKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getDstPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeid", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getDstPSDEId()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getDstPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdename", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getDstPSDEName()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getExceptionData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exceptiondata", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getExceptionData()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getExceptionData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exceptiondata2", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getExceptionData2()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getExceptionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exceptionname", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getExceptionName()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSSysTCAssertId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystcassertid", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSSysTCAssertId()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSSysTCAssertName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystcassertname", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSSysTCAssertName()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSSysTCInputId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystcinputid", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSSysTCInputId()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSSysTCInputName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystcinputname", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSSysTCInputName()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSSysTestCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcaseid", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSSysTestCaseId()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSSysTestCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcasename", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSSysTestCaseName()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSSysTestDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataid", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSSysTestDataId()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getPSSysTestDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataname", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getPSSysTestDataName()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getTargetType()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getTestDataSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testdatasn", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getTestDataSN()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysTCAssertBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysTCAssertBase.getJSONValue((Object)pSSysTCAssertBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTCAssertBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTCAssertBase pSSysTCAssertBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTCAssertBase.getAssertResult() != null) {
            object = pSSysTCAssertBase.getAssertResult();
            xmlNode.setAttribute(FIELD_ASSERTRESULT, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTCAssertBase.getAssertTag() != null) {
            object = pSSysTCAssertBase.getAssertTag();
            xmlNode.setAttribute(FIELD_ASSERTTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTCAssertBase.getAssertTag2() != null) {
            object = pSSysTCAssertBase.getAssertTag2();
            xmlNode.setAttribute(FIELD_ASSERTTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTCAssertBase.getAssertTag3() != null) {
            object = pSSysTCAssertBase.getAssertTag3();
            xmlNode.setAttribute(FIELD_ASSERTTAG3, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTCAssertBase.getAssertTag4() != null) {
            object = pSSysTCAssertBase.getAssertTag4();
            xmlNode.setAttribute(FIELD_ASSERTTAG4, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTCAssertBase.getAssertType() != null) {
            object = pSSysTCAssertBase.getAssertType();
            xmlNode.setAttribute(FIELD_ASSERTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getCreateDate() != null) {
            object = pSSysTCAssertBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTCAssertBase.getCreateMan() != null) {
            object = pSSysTCAssertBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getCustomCode() != null) {
            object = pSSysTCAssertBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getDstKeyPSDEFId() != null) {
            object = pSSysTCAssertBase.getDstKeyPSDEFId();
            xmlNode.setAttribute(FIELD_DSTKEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getDstKeyPSDEFName() != null) {
            object = pSSysTCAssertBase.getDstKeyPSDEFName();
            xmlNode.setAttribute(FIELD_DSTKEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getDstPSDEId() != null) {
            object = pSSysTCAssertBase.getDstPSDEId();
            xmlNode.setAttribute(FIELD_DSTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getDstPSDEName() != null) {
            object = pSSysTCAssertBase.getDstPSDEName();
            xmlNode.setAttribute(FIELD_DSTPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getExceptionData() != null) {
            object = pSSysTCAssertBase.getExceptionData();
            xmlNode.setAttribute(FIELD_EXCEPTIONDATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getExceptionData2() != null) {
            object = pSSysTCAssertBase.getExceptionData2();
            xmlNode.setAttribute(FIELD_EXCEPTIONDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getExceptionName() != null) {
            object = pSSysTCAssertBase.getExceptionName();
            xmlNode.setAttribute(FIELD_EXCEPTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getMemo() != null) {
            object = pSSysTCAssertBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getOrderValue() != null) {
            object = pSSysTCAssertBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTCAssertBase.getPSDEId() != null) {
            object = pSSysTCAssertBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getPSSysTCAssertId() != null) {
            object = pSSysTCAssertBase.getPSSysTCAssertId();
            xmlNode.setAttribute(FIELD_PSSYSTCASSERTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getPSSysTCAssertName() != null) {
            object = pSSysTCAssertBase.getPSSysTCAssertName();
            xmlNode.setAttribute(FIELD_PSSYSTCASSERTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getPSSysTCInputId() != null) {
            object = pSSysTCAssertBase.getPSSysTCInputId();
            xmlNode.setAttribute(FIELD_PSSYSTCINPUTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getPSSysTCInputName() != null) {
            object = pSSysTCAssertBase.getPSSysTCInputName();
            xmlNode.setAttribute(FIELD_PSSYSTCINPUTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getPSSysTestCaseId() != null) {
            object = pSSysTCAssertBase.getPSSysTestCaseId();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getPSSysTestCaseName() != null) {
            object = pSSysTCAssertBase.getPSSysTestCaseName();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getPSSysTestDataId() != null) {
            object = pSSysTCAssertBase.getPSSysTestDataId();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getPSSysTestDataName() != null) {
            object = pSSysTCAssertBase.getPSSysTestDataName();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getTargetType() != null) {
            object = pSSysTCAssertBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getTestDataSN() != null) {
            object = pSSysTCAssertBase.getTestDataSN();
            xmlNode.setAttribute(FIELD_TESTDATASN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTCAssertBase.getUpdateDate() != null) {
            object = pSSysTCAssertBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTCAssertBase.getUpdateMan() != null) {
            object = pSSysTCAssertBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getUserCat() != null) {
            object = pSSysTCAssertBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getUserTag() != null) {
            object = pSSysTCAssertBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getUserTag2() != null) {
            object = pSSysTCAssertBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getUserTag3() != null) {
            object = pSSysTCAssertBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getUserTag4() != null) {
            object = pSSysTCAssertBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCAssertBase.getValidFlag() != null) {
            object = pSSysTCAssertBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTCAssertBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTCAssertBase pSSysTCAssertBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTCAssertBase.isAssertResultDirty() && (bl || pSSysTCAssertBase.getAssertResult() != null)) {
            iDataObject.set(FIELD_ASSERTRESULT, (Object)pSSysTCAssertBase.getAssertResult());
        }
        if (pSSysTCAssertBase.isAssertTagDirty() && (bl || pSSysTCAssertBase.getAssertTag() != null)) {
            iDataObject.set(FIELD_ASSERTTAG, (Object)pSSysTCAssertBase.getAssertTag());
        }
        if (pSSysTCAssertBase.isAssertTag2Dirty() && (bl || pSSysTCAssertBase.getAssertTag2() != null)) {
            iDataObject.set(FIELD_ASSERTTAG2, (Object)pSSysTCAssertBase.getAssertTag2());
        }
        if (pSSysTCAssertBase.isAssertTag3Dirty() && (bl || pSSysTCAssertBase.getAssertTag3() != null)) {
            iDataObject.set(FIELD_ASSERTTAG3, (Object)pSSysTCAssertBase.getAssertTag3());
        }
        if (pSSysTCAssertBase.isAssertTag4Dirty() && (bl || pSSysTCAssertBase.getAssertTag4() != null)) {
            iDataObject.set(FIELD_ASSERTTAG4, (Object)pSSysTCAssertBase.getAssertTag4());
        }
        if (pSSysTCAssertBase.isAssertTypeDirty() && (bl || pSSysTCAssertBase.getAssertType() != null)) {
            iDataObject.set(FIELD_ASSERTTYPE, (Object)pSSysTCAssertBase.getAssertType());
        }
        if (pSSysTCAssertBase.isCreateDateDirty() && (bl || pSSysTCAssertBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTCAssertBase.getCreateDate());
        }
        if (pSSysTCAssertBase.isCreateManDirty() && (bl || pSSysTCAssertBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTCAssertBase.getCreateMan());
        }
        if (pSSysTCAssertBase.isCustomCodeDirty() && (bl || pSSysTCAssertBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysTCAssertBase.getCustomCode());
        }
        if (pSSysTCAssertBase.isDstKeyPSDEFIdDirty() && (bl || pSSysTCAssertBase.getDstKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_DSTKEYPSDEFID, (Object)pSSysTCAssertBase.getDstKeyPSDEFId());
        }
        if (pSSysTCAssertBase.isDstKeyPSDEFNameDirty() && (bl || pSSysTCAssertBase.getDstKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_DSTKEYPSDEFNAME, (Object)pSSysTCAssertBase.getDstKeyPSDEFName());
        }
        if (pSSysTCAssertBase.isDstPSDEIdDirty() && (bl || pSSysTCAssertBase.getDstPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEID, (Object)pSSysTCAssertBase.getDstPSDEId());
        }
        if (pSSysTCAssertBase.isDstPSDENameDirty() && (bl || pSSysTCAssertBase.getDstPSDEName() != null)) {
            iDataObject.set(FIELD_DSTPSDENAME, (Object)pSSysTCAssertBase.getDstPSDEName());
        }
        if (pSSysTCAssertBase.isExceptionDataDirty() && (bl || pSSysTCAssertBase.getExceptionData() != null)) {
            iDataObject.set(FIELD_EXCEPTIONDATA, (Object)pSSysTCAssertBase.getExceptionData());
        }
        if (pSSysTCAssertBase.isExceptionData2Dirty() && (bl || pSSysTCAssertBase.getExceptionData2() != null)) {
            iDataObject.set(FIELD_EXCEPTIONDATA2, (Object)pSSysTCAssertBase.getExceptionData2());
        }
        if (pSSysTCAssertBase.isExceptionNameDirty() && (bl || pSSysTCAssertBase.getExceptionName() != null)) {
            iDataObject.set(FIELD_EXCEPTIONNAME, (Object)pSSysTCAssertBase.getExceptionName());
        }
        if (pSSysTCAssertBase.isMemoDirty() && (bl || pSSysTCAssertBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTCAssertBase.getMemo());
        }
        if (pSSysTCAssertBase.isOrderValueDirty() && (bl || pSSysTCAssertBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysTCAssertBase.getOrderValue());
        }
        if (pSSysTCAssertBase.isPSDEIdDirty() && (bl || pSSysTCAssertBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysTCAssertBase.getPSDEId());
        }
        if (pSSysTCAssertBase.isPSSysTCAssertIdDirty() && (bl || pSSysTCAssertBase.getPSSysTCAssertId() != null)) {
            iDataObject.set(FIELD_PSSYSTCASSERTID, (Object)pSSysTCAssertBase.getPSSysTCAssertId());
        }
        if (pSSysTCAssertBase.isPSSysTCAssertNameDirty() && (bl || pSSysTCAssertBase.getPSSysTCAssertName() != null)) {
            iDataObject.set(FIELD_PSSYSTCASSERTNAME, (Object)pSSysTCAssertBase.getPSSysTCAssertName());
        }
        if (pSSysTCAssertBase.isPSSysTCInputIdDirty() && (bl || pSSysTCAssertBase.getPSSysTCInputId() != null)) {
            iDataObject.set(FIELD_PSSYSTCINPUTID, (Object)pSSysTCAssertBase.getPSSysTCInputId());
        }
        if (pSSysTCAssertBase.isPSSysTCInputNameDirty() && (bl || pSSysTCAssertBase.getPSSysTCInputName() != null)) {
            iDataObject.set(FIELD_PSSYSTCINPUTNAME, (Object)pSSysTCAssertBase.getPSSysTCInputName());
        }
        if (pSSysTCAssertBase.isPSSysTestCaseIdDirty() && (bl || pSSysTCAssertBase.getPSSysTestCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASEID, (Object)pSSysTCAssertBase.getPSSysTestCaseId());
        }
        if (pSSysTCAssertBase.isPSSysTestCaseNameDirty() && (bl || pSSysTCAssertBase.getPSSysTestCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASENAME, (Object)pSSysTCAssertBase.getPSSysTestCaseName());
        }
        if (pSSysTCAssertBase.isPSSysTestDataIdDirty() && (bl || pSSysTCAssertBase.getPSSysTestDataId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATAID, (Object)pSSysTCAssertBase.getPSSysTestDataId());
        }
        if (pSSysTCAssertBase.isPSSysTestDataNameDirty() && (bl || pSSysTCAssertBase.getPSSysTestDataName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATANAME, (Object)pSSysTCAssertBase.getPSSysTestDataName());
        }
        if (pSSysTCAssertBase.isTargetTypeDirty() && (bl || pSSysTCAssertBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSSysTCAssertBase.getTargetType());
        }
        if (pSSysTCAssertBase.isTestDataSNDirty() && (bl || pSSysTCAssertBase.getTestDataSN() != null)) {
            iDataObject.set(FIELD_TESTDATASN, (Object)pSSysTCAssertBase.getTestDataSN());
        }
        if (pSSysTCAssertBase.isUpdateDateDirty() && (bl || pSSysTCAssertBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTCAssertBase.getUpdateDate());
        }
        if (pSSysTCAssertBase.isUpdateManDirty() && (bl || pSSysTCAssertBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTCAssertBase.getUpdateMan());
        }
        if (pSSysTCAssertBase.isUserCatDirty() && (bl || pSSysTCAssertBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysTCAssertBase.getUserCat());
        }
        if (pSSysTCAssertBase.isUserTagDirty() && (bl || pSSysTCAssertBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTCAssertBase.getUserTag());
        }
        if (pSSysTCAssertBase.isUserTag2Dirty() && (bl || pSSysTCAssertBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTCAssertBase.getUserTag2());
        }
        if (pSSysTCAssertBase.isUserTag3Dirty() && (bl || pSSysTCAssertBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTCAssertBase.getUserTag3());
        }
        if (pSSysTCAssertBase.isUserTag4Dirty() && (bl || pSSysTCAssertBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTCAssertBase.getUserTag4());
        }
        if (pSSysTCAssertBase.isValidFlagDirty() && (bl || pSSysTCAssertBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysTCAssertBase.getValidFlag());
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
        return PSSysTCAssertBase.remove(this, n);
    }

    private static boolean remove(PSSysTCAssertBase pSSysTCAssertBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTCAssertBase.resetAssertResult();
                return true;
            }
            case 1: {
                pSSysTCAssertBase.resetAssertTag();
                return true;
            }
            case 2: {
                pSSysTCAssertBase.resetAssertTag2();
                return true;
            }
            case 3: {
                pSSysTCAssertBase.resetAssertTag3();
                return true;
            }
            case 4: {
                pSSysTCAssertBase.resetAssertTag4();
                return true;
            }
            case 5: {
                pSSysTCAssertBase.resetAssertType();
                return true;
            }
            case 6: {
                pSSysTCAssertBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSSysTCAssertBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSysTCAssertBase.resetCustomCode();
                return true;
            }
            case 9: {
                pSSysTCAssertBase.resetDstKeyPSDEFId();
                return true;
            }
            case 10: {
                pSSysTCAssertBase.resetDstKeyPSDEFName();
                return true;
            }
            case 11: {
                pSSysTCAssertBase.resetDstPSDEId();
                return true;
            }
            case 12: {
                pSSysTCAssertBase.resetDstPSDEName();
                return true;
            }
            case 13: {
                pSSysTCAssertBase.resetExceptionData();
                return true;
            }
            case 14: {
                pSSysTCAssertBase.resetExceptionData2();
                return true;
            }
            case 15: {
                pSSysTCAssertBase.resetExceptionName();
                return true;
            }
            case 16: {
                pSSysTCAssertBase.resetMemo();
                return true;
            }
            case 17: {
                pSSysTCAssertBase.resetOrderValue();
                return true;
            }
            case 18: {
                pSSysTCAssertBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSSysTCAssertBase.resetPSSysTCAssertId();
                return true;
            }
            case 20: {
                pSSysTCAssertBase.resetPSSysTCAssertName();
                return true;
            }
            case 21: {
                pSSysTCAssertBase.resetPSSysTCInputId();
                return true;
            }
            case 22: {
                pSSysTCAssertBase.resetPSSysTCInputName();
                return true;
            }
            case 23: {
                pSSysTCAssertBase.resetPSSysTestCaseId();
                return true;
            }
            case 24: {
                pSSysTCAssertBase.resetPSSysTestCaseName();
                return true;
            }
            case 25: {
                pSSysTCAssertBase.resetPSSysTestDataId();
                return true;
            }
            case 26: {
                pSSysTCAssertBase.resetPSSysTestDataName();
                return true;
            }
            case 27: {
                pSSysTCAssertBase.resetTargetType();
                return true;
            }
            case 28: {
                pSSysTCAssertBase.resetTestDataSN();
                return true;
            }
            case 29: {
                pSSysTCAssertBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSSysTCAssertBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSSysTCAssertBase.resetUserCat();
                return true;
            }
            case 32: {
                pSSysTCAssertBase.resetUserTag();
                return true;
            }
            case 33: {
                pSSysTCAssertBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSSysTCAssertBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSSysTCAssertBase.resetUserTag4();
                return true;
            }
            case 36: {
                pSSysTCAssertBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getDstPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDE();
        }
        if (this.getDstPSDEId() == null) {
            return null;
        }
        Integer n = this.objDstPSDELock;
        synchronized (n) {
            if (this.dstpsde != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEId(), (Object)this.dstpsde.getPSDataEntityId()) != 0L) {
                this.dstpsde = null;
            }
            if (this.dstpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getDstPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.dstpsde = pSDataEntity;
            }
            return this.dstpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDstKeyPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstKeyPSDEF();
        }
        if (this.getDstKeyPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDstKeyPSDEFLock;
        synchronized (n) {
            if (this.dstkeypsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDstKeyPSDEFId(), (Object)this.dstkeypsdef.getPSDEFieldId()) != 0L) {
                this.dstkeypsdef = null;
            }
            if (this.dstkeypsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDstKeyPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.dstkeypsdef = pSDEField;
            }
            return this.dstkeypsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTCInput getPSSysTCInput() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTCInput();
        }
        if (this.getPSSysTCInputId() == null) {
            return null;
        }
        Integer n = this.objPSSysTCInputLock;
        synchronized (n) {
            if (this.pssystcinput != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTCInputId(), (Object)this.pssystcinput.getPSSysTCInputId()) != 0L) {
                this.pssystcinput = null;
            }
            if (this.pssystcinput == null) {
                PSSysTCInput pSSysTCInput = new PSSysTCInput();
                pSSysTCInput.setPSSysTCInputId(this.getPSSysTCInputId());
                PSSysTCInputService pSSysTCInputService = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
                pSSysTCInputService.autoGet(pSSysTCInput);
                this.pssystcinput = pSSysTCInput;
            }
            return this.pssystcinput;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestCase getPSSysTestCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCase();
        }
        if (this.getPSSysTestCaseId() == null) {
            return null;
        }
        Integer n = this.objPSSysTestCaseLock;
        synchronized (n) {
            if (this.pssystestcase != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTestCaseId(), (Object)this.pssystestcase.getPSSysTestCaseId()) != 0L) {
                this.pssystestcase = null;
            }
            if (this.pssystestcase == null) {
                PSSysTestCase pSSysTestCase = new PSSysTestCase();
                pSSysTestCase.setPSSysTestCaseId(this.getPSSysTestCaseId());
                PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestCaseService.autoGet(pSSysTestCase);
                this.pssystestcase = pSSysTestCase;
            }
            return this.pssystestcase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestData getPSSysTestData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestData();
        }
        if (this.getPSSysTestDataId() == null) {
            return null;
        }
        Integer n = this.objPSSysTestDataLock;
        synchronized (n) {
            if (this.pssystestdata != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTestDataId(), (Object)this.pssystestdata.getPSSysTestDataId()) != 0L) {
                this.pssystestdata = null;
            }
            if (this.pssystestdata == null) {
                PSSysTestData pSSysTestData = new PSSysTestData();
                pSSysTestData.setPSSysTestDataId(this.getPSSysTestDataId());
                PSSysTestDataService pSSysTestDataService = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestDataService.autoGet(pSSysTestData);
                this.pssystestdata = pSSysTestData;
            }
            return this.pssystestdata;
        }
    }

    private PSSysTCAssertBase getProxyEntity() {
        return this.proxyPSSysTCAssertBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTCAssertBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTCAssertBase) {
            this.proxyPSSysTCAssertBase = (PSSysTCAssertBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTCAssertService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASSERTRESULT, 0);
        fieldIndexMap.put(FIELD_ASSERTTAG, 1);
        fieldIndexMap.put(FIELD_ASSERTTAG2, 2);
        fieldIndexMap.put(FIELD_ASSERTTAG3, 3);
        fieldIndexMap.put(FIELD_ASSERTTAG4, 4);
        fieldIndexMap.put(FIELD_ASSERTTYPE, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 8);
        fieldIndexMap.put(FIELD_DSTKEYPSDEFID, 9);
        fieldIndexMap.put(FIELD_DSTKEYPSDEFNAME, 10);
        fieldIndexMap.put(FIELD_DSTPSDEID, 11);
        fieldIndexMap.put(FIELD_DSTPSDENAME, 12);
        fieldIndexMap.put(FIELD_EXCEPTIONDATA, 13);
        fieldIndexMap.put(FIELD_EXCEPTIONDATA2, 14);
        fieldIndexMap.put(FIELD_EXCEPTIONNAME, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_ORDERVALUE, 17);
        fieldIndexMap.put(FIELD_PSDEID, 18);
        fieldIndexMap.put(FIELD_PSSYSTCASSERTID, 19);
        fieldIndexMap.put(FIELD_PSSYSTCASSERTNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTCINPUTID, 21);
        fieldIndexMap.put(FIELD_PSSYSTCINPUTNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSTESTCASEID, 23);
        fieldIndexMap.put(FIELD_PSSYSTESTCASENAME, 24);
        fieldIndexMap.put(FIELD_PSSYSTESTDATAID, 25);
        fieldIndexMap.put(FIELD_PSSYSTESTDATANAME, 26);
        fieldIndexMap.put(FIELD_TARGETTYPE, 27);
        fieldIndexMap.put(FIELD_TESTDATASN, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USERCAT, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
        fieldIndexMap.put(FIELD_VALIDFLAG, 36);
    }
}

