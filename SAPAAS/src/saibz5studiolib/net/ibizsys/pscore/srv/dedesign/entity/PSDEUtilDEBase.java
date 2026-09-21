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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUtilDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUtilDEBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUTILDEID = "PSDEUTILDEID";
    public static final String FIELD_PSDEUTILDENAME = "PSDEUTILDENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_UNIQUETAG = "UNIQUETAG";
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
    public static final String FIELD_UTILPSDE10ID = "UTILPSDE10ID";
    public static final String FIELD_UTILPSDE10NAME = "UTILPSDE10NAME";
    public static final String FIELD_UTILPSDE11ID = "UTILPSDE11ID";
    public static final String FIELD_UTILPSDE11NAME = "UTILPSDE11NAME";
    public static final String FIELD_UTILPSDE12ID = "UTILPSDE12ID";
    public static final String FIELD_UTILPSDE12NAME = "UTILPSDE12NAME";
    public static final String FIELD_UTILPSDE13ID = "UTILPSDE13ID";
    public static final String FIELD_UTILPSDE13NAME = "UTILPSDE13NAME";
    public static final String FIELD_UTILPSDE14ID = "UTILPSDE14ID";
    public static final String FIELD_UTILPSDE14NAME = "UTILPSDE14NAME";
    public static final String FIELD_UTILPSDE15ID = "UTILPSDE15ID";
    public static final String FIELD_UTILPSDE15NAME = "UTILPSDE15NAME";
    public static final String FIELD_UTILPSDE16ID = "UTILPSDE16ID";
    public static final String FIELD_UTILPSDE16NAME = "UTILPSDE16NAME";
    public static final String FIELD_UTILPSDE17ID = "UTILPSDE17ID";
    public static final String FIELD_UTILPSDE17NAME = "UTILPSDE17NAME";
    public static final String FIELD_UTILPSDE18ID = "UTILPSDE18ID";
    public static final String FIELD_UTILPSDE18NAME = "UTILPSDE18NAME";
    public static final String FIELD_UTILPSDE19ID = "UTILPSDE19ID";
    public static final String FIELD_UTILPSDE19NAME = "UTILPSDE19NAME";
    public static final String FIELD_UTILPSDE20ID = "UTILPSDE20ID";
    public static final String FIELD_UTILPSDE20NAME = "UTILPSDE20NAME";
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
    public static final String FIELD_UTILTAG2 = "UTILTAG2";
    public static final String FIELD_UTILTYPE = "UTILTYPE";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_EXTENDMODE = 3;
    private static final int INDEX_LOCKFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDENAME = 7;
    private static final int INDEX_PSDEUTILDEID = 8;
    private static final int INDEX_PSDEUTILDENAME = 9;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 10;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 11;
    private static final int INDEX_PSSYSDYNAMODELID = 12;
    private static final int INDEX_PSSYSDYNAMODELNAME = 13;
    private static final int INDEX_PSSYSSFPLUGINID = 14;
    private static final int INDEX_PSSYSSFPLUGINNAME = 15;
    private static final int INDEX_UNIQUETAG = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final int INDEX_UTILOBJ = 24;
    private static final int INDEX_UTILPARAM = 25;
    private static final int INDEX_UTILPARAM10 = 26;
    private static final int INDEX_UTILPARAM11 = 27;
    private static final int INDEX_UTILPARAM12 = 28;
    private static final int INDEX_UTILPARAM2 = 29;
    private static final int INDEX_UTILPARAM3 = 30;
    private static final int INDEX_UTILPARAM4 = 31;
    private static final int INDEX_UTILPARAM5 = 32;
    private static final int INDEX_UTILPARAM6 = 33;
    private static final int INDEX_UTILPARAM7 = 34;
    private static final int INDEX_UTILPARAM8 = 35;
    private static final int INDEX_UTILPARAM9 = 36;
    private static final int INDEX_UTILPARAMS = 37;
    private static final int INDEX_UTILPSDE10ID = 38;
    private static final int INDEX_UTILPSDE10NAME = 39;
    private static final int INDEX_UTILPSDE11ID = 40;
    private static final int INDEX_UTILPSDE11NAME = 41;
    private static final int INDEX_UTILPSDE12ID = 42;
    private static final int INDEX_UTILPSDE12NAME = 43;
    private static final int INDEX_UTILPSDE13ID = 44;
    private static final int INDEX_UTILPSDE13NAME = 45;
    private static final int INDEX_UTILPSDE14ID = 46;
    private static final int INDEX_UTILPSDE14NAME = 47;
    private static final int INDEX_UTILPSDE15ID = 48;
    private static final int INDEX_UTILPSDE15NAME = 49;
    private static final int INDEX_UTILPSDE16ID = 50;
    private static final int INDEX_UTILPSDE16NAME = 51;
    private static final int INDEX_UTILPSDE17ID = 52;
    private static final int INDEX_UTILPSDE17NAME = 53;
    private static final int INDEX_UTILPSDE18ID = 54;
    private static final int INDEX_UTILPSDE18NAME = 55;
    private static final int INDEX_UTILPSDE19ID = 56;
    private static final int INDEX_UTILPSDE19NAME = 57;
    private static final int INDEX_UTILPSDE20ID = 58;
    private static final int INDEX_UTILPSDE20NAME = 59;
    private static final int INDEX_UTILPSDE2ID = 60;
    private static final int INDEX_UTILPSDE2NAME = 61;
    private static final int INDEX_UTILPSDE3ID = 62;
    private static final int INDEX_UTILPSDE3NAME = 63;
    private static final int INDEX_UTILPSDE4ID = 64;
    private static final int INDEX_UTILPSDE4NAME = 65;
    private static final int INDEX_UTILPSDE5ID = 66;
    private static final int INDEX_UTILPSDE5NAME = 67;
    private static final int INDEX_UTILPSDE6ID = 68;
    private static final int INDEX_UTILPSDE6NAME = 69;
    private static final int INDEX_UTILPSDE7ID = 70;
    private static final int INDEX_UTILPSDE7NAME = 71;
    private static final int INDEX_UTILPSDE8ID = 72;
    private static final int INDEX_UTILPSDE8NAME = 73;
    private static final int INDEX_UTILPSDE9ID = 74;
    private static final int INDEX_UTILPSDE9NAME = 75;
    private static final int INDEX_UTILPSDEID = 76;
    private static final int INDEX_UTILPSDENAME = 77;
    private static final int INDEX_UTILTAG = 78;
    private static final int INDEX_UTILTAG2 = 79;
    private static final int INDEX_UTILTYPE = 80;
    private static final int INDEX_VALIDFLAG = 81;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUtilDEBase proxyPSDEUtilDEBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeutildeidDirtyFlag = false;
    private boolean psdeutildenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean uniquetagDirtyFlag = false;
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
    private boolean utilpsde10idDirtyFlag = false;
    private boolean utilpsde10nameDirtyFlag = false;
    private boolean utilpsde11idDirtyFlag = false;
    private boolean utilpsde11nameDirtyFlag = false;
    private boolean utilpsde12idDirtyFlag = false;
    private boolean utilpsde12nameDirtyFlag = false;
    private boolean utilpsde13idDirtyFlag = false;
    private boolean utilpsde13nameDirtyFlag = false;
    private boolean utilpsde14idDirtyFlag = false;
    private boolean utilpsde14nameDirtyFlag = false;
    private boolean utilpsde15idDirtyFlag = false;
    private boolean utilpsde15nameDirtyFlag = false;
    private boolean utilpsde16idDirtyFlag = false;
    private boolean utilpsde16nameDirtyFlag = false;
    private boolean utilpsde17idDirtyFlag = false;
    private boolean utilpsde17nameDirtyFlag = false;
    private boolean utilpsde18idDirtyFlag = false;
    private boolean utilpsde18nameDirtyFlag = false;
    private boolean utilpsde19idDirtyFlag = false;
    private boolean utilpsde19nameDirtyFlag = false;
    private boolean utilpsde20idDirtyFlag = false;
    private boolean utilpsde20nameDirtyFlag = false;
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
    private boolean utiltag2DirtyFlag = false;
    private boolean utiltypeDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeutildeid")
    private String psdeutildeid;
    @Column(name="psdeutildename")
    private String psdeutildename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="uniquetag")
    private String uniquetag;
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
    @Column(name="utilpsde10id")
    private String utilpsde10id;
    @Column(name="utilpsde10name")
    private String utilpsde10name;
    @Column(name="utilpsde11id")
    private String utilpsde11id;
    @Column(name="utilpsde11name")
    private String utilpsde11name;
    @Column(name="utilpsde12id")
    private String utilpsde12id;
    @Column(name="utilpsde12name")
    private String utilpsde12name;
    @Column(name="utilpsde13id")
    private String utilpsde13id;
    @Column(name="utilpsde13name")
    private String utilpsde13name;
    @Column(name="utilpsde14id")
    private String utilpsde14id;
    @Column(name="utilpsde14name")
    private String utilpsde14name;
    @Column(name="utilpsde15id")
    private String utilpsde15id;
    @Column(name="utilpsde15name")
    private String utilpsde15name;
    @Column(name="utilpsde16id")
    private String utilpsde16id;
    @Column(name="utilpsde16name")
    private String utilpsde16name;
    @Column(name="utilpsde17id")
    private String utilpsde17id;
    @Column(name="utilpsde17name")
    private String utilpsde17name;
    @Column(name="utilpsde18id")
    private String utilpsde18id;
    @Column(name="utilpsde18name")
    private String utilpsde18name;
    @Column(name="utilpsde19id")
    private String utilpsde19id;
    @Column(name="utilpsde19name")
    private String utilpsde19name;
    @Column(name="utilpsde20id")
    private String utilpsde20id;
    @Column(name="utilpsde20name")
    private String utilpsde20name;
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
    @Column(name="utiltag2")
    private String utiltag2;
    @Column(name="utiltype")
    private String utiltype;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objUtilPSDE10Lock = new Integer(1);
    private PSDataEntity utilpsde10 = null;
    private Integer objUtilPSDE11Lock = new Integer(1);
    private PSDataEntity utilpsde11 = null;
    private Integer objUtilPSDE12Lock = new Integer(1);
    private PSDataEntity utilpsde12 = null;
    private Integer objUtilPSDE13Lock = new Integer(1);
    private PSDataEntity utilpsde13 = null;
    private Integer objUtilPSDE14Lock = new Integer(1);
    private PSDataEntity utilpsde14 = null;
    private Integer objUtilPSDE15Lock = new Integer(1);
    private PSDataEntity utilpsde15 = null;
    private Integer objUtilPSDE16Lock = new Integer(1);
    private PSDataEntity utilpsde16 = null;
    private Integer objUtilPSDE17Lock = new Integer(1);
    private PSDataEntity utilpsde17 = null;
    private Integer objUtilPSDE18Lock = new Integer(1);
    private PSDataEntity utilpsde18 = null;
    private Integer objUtilPSDE19Lock = new Integer(1);
    private PSDataEntity utilpsde19 = null;
    private Integer objUtilPSDE20Lock = new Integer(1);
    private PSDataEntity utilpsde20 = null;
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
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;

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

    public void setExtendMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendMode(n);
            return;
        }
        this.extendmode = n;
        this.extendmodeDirtyFlag = true;
    }

    public Integer getExtendMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendMode();
        }
        return this.extendmode;
    }

    public boolean isExtendModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendModeDirty();
        }
        return this.extendmodeDirtyFlag;
    }

    public void resetExtendMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendMode();
            return;
        }
        this.extendmodeDirtyFlag = false;
        this.extendmode = null;
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

    public void setPSDEUtilDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUtilDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeutildeid = string;
        this.psdeutildeidDirtyFlag = true;
    }

    public String getPSDEUtilDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUtilDEId();
        }
        return this.psdeutildeid;
    }

    public boolean isPSDEUtilDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUtilDEIdDirty();
        }
        return this.psdeutildeidDirtyFlag;
    }

    public void resetPSDEUtilDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUtilDEId();
            return;
        }
        this.psdeutildeidDirtyFlag = false;
        this.psdeutildeid = null;
    }

    public void setPSDEUtilDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUtilDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeutildename = string;
        this.psdeutildenameDirtyFlag = true;
    }

    public String getPSDEUtilDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUtilDEName();
        }
        return this.psdeutildename;
    }

    public boolean isPSDEUtilDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUtilDENameDirty();
        }
        return this.psdeutildenameDirtyFlag;
    }

    public void resetPSDEUtilDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUtilDEName();
            return;
        }
        this.psdeutildenameDirtyFlag = false;
        this.psdeutildename = null;
    }

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
    }

    public void setPSSubSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiname = string;
        this.pssubsysserviceapinameDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIName();
        }
        return this.pssubsysserviceapiname;
    }

    public boolean isPSSubSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPINameDirty();
        }
        return this.pssubsysserviceapinameDirtyFlag;
    }

    public void resetPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIName();
            return;
        }
        this.pssubsysserviceapinameDirtyFlag = false;
        this.pssubsysserviceapiname = null;
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

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setUniqueTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uniquetag = string;
        this.uniquetagDirtyFlag = true;
    }

    public String getUniqueTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTag();
        }
        return this.uniquetag;
    }

    public boolean isUniqueTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueTagDirty();
        }
        return this.uniquetagDirtyFlag;
    }

    public void resetUniqueTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueTag();
            return;
        }
        this.uniquetagDirtyFlag = false;
        this.uniquetag = null;
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

    public void setUtilPSDE10Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE10Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde10id = string;
        this.utilpsde10idDirtyFlag = true;
    }

    public String getUtilPSDE10Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE10Id();
        }
        return this.utilpsde10id;
    }

    public boolean isUtilPSDE10IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE10IdDirty();
        }
        return this.utilpsde10idDirtyFlag;
    }

    public void resetUtilPSDE10Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE10Id();
            return;
        }
        this.utilpsde10idDirtyFlag = false;
        this.utilpsde10id = null;
    }

    public void setUtilPSDE10Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE10Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde10name = string;
        this.utilpsde10nameDirtyFlag = true;
    }

    public String getUtilPSDE10Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE10Name();
        }
        return this.utilpsde10name;
    }

    public boolean isUtilPSDE10NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE10NameDirty();
        }
        return this.utilpsde10nameDirtyFlag;
    }

    public void resetUtilPSDE10Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE10Name();
            return;
        }
        this.utilpsde10nameDirtyFlag = false;
        this.utilpsde10name = null;
    }

    public void setUtilPSDE11Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE11Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde11id = string;
        this.utilpsde11idDirtyFlag = true;
    }

    public String getUtilPSDE11Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE11Id();
        }
        return this.utilpsde11id;
    }

    public boolean isUtilPSDE11IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE11IdDirty();
        }
        return this.utilpsde11idDirtyFlag;
    }

    public void resetUtilPSDE11Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE11Id();
            return;
        }
        this.utilpsde11idDirtyFlag = false;
        this.utilpsde11id = null;
    }

    public void setUtilPSDE11Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE11Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde11name = string;
        this.utilpsde11nameDirtyFlag = true;
    }

    public String getUtilPSDE11Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE11Name();
        }
        return this.utilpsde11name;
    }

    public boolean isUtilPSDE11NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE11NameDirty();
        }
        return this.utilpsde11nameDirtyFlag;
    }

    public void resetUtilPSDE11Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE11Name();
            return;
        }
        this.utilpsde11nameDirtyFlag = false;
        this.utilpsde11name = null;
    }

    public void setUtilPSDE12Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE12Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde12id = string;
        this.utilpsde12idDirtyFlag = true;
    }

    public String getUtilPSDE12Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE12Id();
        }
        return this.utilpsde12id;
    }

    public boolean isUtilPSDE12IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE12IdDirty();
        }
        return this.utilpsde12idDirtyFlag;
    }

    public void resetUtilPSDE12Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE12Id();
            return;
        }
        this.utilpsde12idDirtyFlag = false;
        this.utilpsde12id = null;
    }

    public void setUtilPSDE12Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE12Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde12name = string;
        this.utilpsde12nameDirtyFlag = true;
    }

    public String getUtilPSDE12Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE12Name();
        }
        return this.utilpsde12name;
    }

    public boolean isUtilPSDE12NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE12NameDirty();
        }
        return this.utilpsde12nameDirtyFlag;
    }

    public void resetUtilPSDE12Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE12Name();
            return;
        }
        this.utilpsde12nameDirtyFlag = false;
        this.utilpsde12name = null;
    }

    public void setUtilPSDE13Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE13Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde13id = string;
        this.utilpsde13idDirtyFlag = true;
    }

    public String getUtilPSDE13Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE13Id();
        }
        return this.utilpsde13id;
    }

    public boolean isUtilPSDE13IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE13IdDirty();
        }
        return this.utilpsde13idDirtyFlag;
    }

    public void resetUtilPSDE13Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE13Id();
            return;
        }
        this.utilpsde13idDirtyFlag = false;
        this.utilpsde13id = null;
    }

    public void setUtilPSDE13Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE13Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde13name = string;
        this.utilpsde13nameDirtyFlag = true;
    }

    public String getUtilPSDE13Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE13Name();
        }
        return this.utilpsde13name;
    }

    public boolean isUtilPSDE13NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE13NameDirty();
        }
        return this.utilpsde13nameDirtyFlag;
    }

    public void resetUtilPSDE13Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE13Name();
            return;
        }
        this.utilpsde13nameDirtyFlag = false;
        this.utilpsde13name = null;
    }

    public void setUtilPSDE14Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE14Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde14id = string;
        this.utilpsde14idDirtyFlag = true;
    }

    public String getUtilPSDE14Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE14Id();
        }
        return this.utilpsde14id;
    }

    public boolean isUtilPSDE14IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE14IdDirty();
        }
        return this.utilpsde14idDirtyFlag;
    }

    public void resetUtilPSDE14Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE14Id();
            return;
        }
        this.utilpsde14idDirtyFlag = false;
        this.utilpsde14id = null;
    }

    public void setUtilPSDE14Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE14Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde14name = string;
        this.utilpsde14nameDirtyFlag = true;
    }

    public String getUtilPSDE14Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE14Name();
        }
        return this.utilpsde14name;
    }

    public boolean isUtilPSDE14NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE14NameDirty();
        }
        return this.utilpsde14nameDirtyFlag;
    }

    public void resetUtilPSDE14Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE14Name();
            return;
        }
        this.utilpsde14nameDirtyFlag = false;
        this.utilpsde14name = null;
    }

    public void setUtilPSDE15Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE15Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde15id = string;
        this.utilpsde15idDirtyFlag = true;
    }

    public String getUtilPSDE15Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE15Id();
        }
        return this.utilpsde15id;
    }

    public boolean isUtilPSDE15IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE15IdDirty();
        }
        return this.utilpsde15idDirtyFlag;
    }

    public void resetUtilPSDE15Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE15Id();
            return;
        }
        this.utilpsde15idDirtyFlag = false;
        this.utilpsde15id = null;
    }

    public void setUtilPSDE15Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE15Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde15name = string;
        this.utilpsde15nameDirtyFlag = true;
    }

    public String getUtilPSDE15Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE15Name();
        }
        return this.utilpsde15name;
    }

    public boolean isUtilPSDE15NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE15NameDirty();
        }
        return this.utilpsde15nameDirtyFlag;
    }

    public void resetUtilPSDE15Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE15Name();
            return;
        }
        this.utilpsde15nameDirtyFlag = false;
        this.utilpsde15name = null;
    }

    public void setUtilPSDE16Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE16Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde16id = string;
        this.utilpsde16idDirtyFlag = true;
    }

    public String getUtilPSDE16Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE16Id();
        }
        return this.utilpsde16id;
    }

    public boolean isUtilPSDE16IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE16IdDirty();
        }
        return this.utilpsde16idDirtyFlag;
    }

    public void resetUtilPSDE16Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE16Id();
            return;
        }
        this.utilpsde16idDirtyFlag = false;
        this.utilpsde16id = null;
    }

    public void setUtilPSDE16Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE16Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde16name = string;
        this.utilpsde16nameDirtyFlag = true;
    }

    public String getUtilPSDE16Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE16Name();
        }
        return this.utilpsde16name;
    }

    public boolean isUtilPSDE16NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE16NameDirty();
        }
        return this.utilpsde16nameDirtyFlag;
    }

    public void resetUtilPSDE16Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE16Name();
            return;
        }
        this.utilpsde16nameDirtyFlag = false;
        this.utilpsde16name = null;
    }

    public void setUtilPSDE17Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE17Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde17id = string;
        this.utilpsde17idDirtyFlag = true;
    }

    public String getUtilPSDE17Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE17Id();
        }
        return this.utilpsde17id;
    }

    public boolean isUtilPSDE17IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE17IdDirty();
        }
        return this.utilpsde17idDirtyFlag;
    }

    public void resetUtilPSDE17Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE17Id();
            return;
        }
        this.utilpsde17idDirtyFlag = false;
        this.utilpsde17id = null;
    }

    public void setUtilPSDE17Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE17Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde17name = string;
        this.utilpsde17nameDirtyFlag = true;
    }

    public String getUtilPSDE17Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE17Name();
        }
        return this.utilpsde17name;
    }

    public boolean isUtilPSDE17NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE17NameDirty();
        }
        return this.utilpsde17nameDirtyFlag;
    }

    public void resetUtilPSDE17Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE17Name();
            return;
        }
        this.utilpsde17nameDirtyFlag = false;
        this.utilpsde17name = null;
    }

    public void setUtilPSDE18Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE18Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde18id = string;
        this.utilpsde18idDirtyFlag = true;
    }

    public String getUtilPSDE18Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE18Id();
        }
        return this.utilpsde18id;
    }

    public boolean isUtilPSDE18IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE18IdDirty();
        }
        return this.utilpsde18idDirtyFlag;
    }

    public void resetUtilPSDE18Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE18Id();
            return;
        }
        this.utilpsde18idDirtyFlag = false;
        this.utilpsde18id = null;
    }

    public void setUtilPSDE18Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE18Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde18name = string;
        this.utilpsde18nameDirtyFlag = true;
    }

    public String getUtilPSDE18Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE18Name();
        }
        return this.utilpsde18name;
    }

    public boolean isUtilPSDE18NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE18NameDirty();
        }
        return this.utilpsde18nameDirtyFlag;
    }

    public void resetUtilPSDE18Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE18Name();
            return;
        }
        this.utilpsde18nameDirtyFlag = false;
        this.utilpsde18name = null;
    }

    public void setUtilPSDE19Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE19Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde19id = string;
        this.utilpsde19idDirtyFlag = true;
    }

    public String getUtilPSDE19Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE19Id();
        }
        return this.utilpsde19id;
    }

    public boolean isUtilPSDE19IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE19IdDirty();
        }
        return this.utilpsde19idDirtyFlag;
    }

    public void resetUtilPSDE19Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE19Id();
            return;
        }
        this.utilpsde19idDirtyFlag = false;
        this.utilpsde19id = null;
    }

    public void setUtilPSDE19Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE19Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde19name = string;
        this.utilpsde19nameDirtyFlag = true;
    }

    public String getUtilPSDE19Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE19Name();
        }
        return this.utilpsde19name;
    }

    public boolean isUtilPSDE19NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE19NameDirty();
        }
        return this.utilpsde19nameDirtyFlag;
    }

    public void resetUtilPSDE19Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE19Name();
            return;
        }
        this.utilpsde19nameDirtyFlag = false;
        this.utilpsde19name = null;
    }

    public void setUtilPSDE20Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE20Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde20id = string;
        this.utilpsde20idDirtyFlag = true;
    }

    public String getUtilPSDE20Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE20Id();
        }
        return this.utilpsde20id;
    }

    public boolean isUtilPSDE20IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE20IdDirty();
        }
        return this.utilpsde20idDirtyFlag;
    }

    public void resetUtilPSDE20Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE20Id();
            return;
        }
        this.utilpsde20idDirtyFlag = false;
        this.utilpsde20id = null;
    }

    public void setUtilPSDE20Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDE20Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsde20name = string;
        this.utilpsde20nameDirtyFlag = true;
    }

    public String getUtilPSDE20Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE20Name();
        }
        return this.utilpsde20name;
    }

    public boolean isUtilPSDE20NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDE20NameDirty();
        }
        return this.utilpsde20nameDirtyFlag;
    }

    public void resetUtilPSDE20Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDE20Name();
            return;
        }
        this.utilpsde20nameDirtyFlag = false;
        this.utilpsde20name = null;
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
        if (string != null) {
            string = string.toUpperCase();
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

    public void setUtilTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltag2 = string;
        this.utiltag2DirtyFlag = true;
    }

    public String getUtilTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilTag2();
        }
        return this.utiltag2;
    }

    public boolean isUtilTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTag2Dirty();
        }
        return this.utiltag2DirtyFlag;
    }

    public void resetUtilTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilTag2();
            return;
        }
        this.utiltag2DirtyFlag = false;
        this.utiltag2 = null;
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
        PSDEUtilDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUtilDEBase pSDEUtilDEBase) {
        pSDEUtilDEBase.resetCodeName();
        pSDEUtilDEBase.resetCreateDate();
        pSDEUtilDEBase.resetCreateMan();
        pSDEUtilDEBase.resetExtendMode();
        pSDEUtilDEBase.resetLockFlag();
        pSDEUtilDEBase.resetMemo();
        pSDEUtilDEBase.resetPSDEId();
        pSDEUtilDEBase.resetPSDEName();
        pSDEUtilDEBase.resetPSDEUtilDEId();
        pSDEUtilDEBase.resetPSDEUtilDEName();
        pSDEUtilDEBase.resetPSSubSysServiceAPIId();
        pSDEUtilDEBase.resetPSSubSysServiceAPIName();
        pSDEUtilDEBase.resetPSSysDynaModelId();
        pSDEUtilDEBase.resetPSSysDynaModelName();
        pSDEUtilDEBase.resetPSSysSFPluginId();
        pSDEUtilDEBase.resetPSSysSFPluginName();
        pSDEUtilDEBase.resetUniqueTag();
        pSDEUtilDEBase.resetUpdateDate();
        pSDEUtilDEBase.resetUpdateMan();
        pSDEUtilDEBase.resetUserCat();
        pSDEUtilDEBase.resetUserTag();
        pSDEUtilDEBase.resetUserTag2();
        pSDEUtilDEBase.resetUserTag3();
        pSDEUtilDEBase.resetUserTag4();
        pSDEUtilDEBase.resetUtilObj();
        pSDEUtilDEBase.resetUtilParam();
        pSDEUtilDEBase.resetUtilParam10();
        pSDEUtilDEBase.resetUtilParam11();
        pSDEUtilDEBase.resetUtilParam12();
        pSDEUtilDEBase.resetUtilParam2();
        pSDEUtilDEBase.resetUtilParam3();
        pSDEUtilDEBase.resetUtilParam4();
        pSDEUtilDEBase.resetUtilParam5();
        pSDEUtilDEBase.resetUtilParam6();
        pSDEUtilDEBase.resetUtilParam7();
        pSDEUtilDEBase.resetUtilParam8();
        pSDEUtilDEBase.resetUtilParam9();
        pSDEUtilDEBase.resetUtilParams();
        pSDEUtilDEBase.resetUtilPSDE10Id();
        pSDEUtilDEBase.resetUtilPSDE10Name();
        pSDEUtilDEBase.resetUtilPSDE11Id();
        pSDEUtilDEBase.resetUtilPSDE11Name();
        pSDEUtilDEBase.resetUtilPSDE12Id();
        pSDEUtilDEBase.resetUtilPSDE12Name();
        pSDEUtilDEBase.resetUtilPSDE13Id();
        pSDEUtilDEBase.resetUtilPSDE13Name();
        pSDEUtilDEBase.resetUtilPSDE14Id();
        pSDEUtilDEBase.resetUtilPSDE14Name();
        pSDEUtilDEBase.resetUtilPSDE15Id();
        pSDEUtilDEBase.resetUtilPSDE15Name();
        pSDEUtilDEBase.resetUtilPSDE16Id();
        pSDEUtilDEBase.resetUtilPSDE16Name();
        pSDEUtilDEBase.resetUtilPSDE17Id();
        pSDEUtilDEBase.resetUtilPSDE17Name();
        pSDEUtilDEBase.resetUtilPSDE18Id();
        pSDEUtilDEBase.resetUtilPSDE18Name();
        pSDEUtilDEBase.resetUtilPSDE19Id();
        pSDEUtilDEBase.resetUtilPSDE19Name();
        pSDEUtilDEBase.resetUtilPSDE20Id();
        pSDEUtilDEBase.resetUtilPSDE20Name();
        pSDEUtilDEBase.resetUtilPSDE2Id();
        pSDEUtilDEBase.resetUtilPSDE2Name();
        pSDEUtilDEBase.resetUtilPSDE3Id();
        pSDEUtilDEBase.resetUtilPSDE3Name();
        pSDEUtilDEBase.resetUtilPSDE4Id();
        pSDEUtilDEBase.resetUtilPSDE4Name();
        pSDEUtilDEBase.resetUtilPSDE5Id();
        pSDEUtilDEBase.resetUtilPSDE5Name();
        pSDEUtilDEBase.resetUtilPSDE6Id();
        pSDEUtilDEBase.resetUtilPSDE6Name();
        pSDEUtilDEBase.resetUtilPSDE7Id();
        pSDEUtilDEBase.resetUtilPSDE7Name();
        pSDEUtilDEBase.resetUtilPSDE8Id();
        pSDEUtilDEBase.resetUtilPSDE8Name();
        pSDEUtilDEBase.resetUtilPSDE9Id();
        pSDEUtilDEBase.resetUtilPSDE9Name();
        pSDEUtilDEBase.resetUtilPSDEId();
        pSDEUtilDEBase.resetUtilPSDEName();
        pSDEUtilDEBase.resetUtilTag();
        pSDEUtilDEBase.resetUtilTag2();
        pSDEUtilDEBase.resetUtilType();
        pSDEUtilDEBase.resetValidFlag();
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
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEUtilDEIdDirty()) {
            hashMap.put(FIELD_PSDEUTILDEID, this.getPSDEUtilDEId());
        }
        if (!bl || this.isPSDEUtilDENameDirty()) {
            hashMap.put(FIELD_PSDEUTILDENAME, this.getPSDEUtilDEName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isUniqueTagDirty()) {
            hashMap.put(FIELD_UNIQUETAG, this.getUniqueTag());
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
        if (!bl || this.isUtilPSDE10IdDirty()) {
            hashMap.put(FIELD_UTILPSDE10ID, this.getUtilPSDE10Id());
        }
        if (!bl || this.isUtilPSDE10NameDirty()) {
            hashMap.put(FIELD_UTILPSDE10NAME, this.getUtilPSDE10Name());
        }
        if (!bl || this.isUtilPSDE11IdDirty()) {
            hashMap.put(FIELD_UTILPSDE11ID, this.getUtilPSDE11Id());
        }
        if (!bl || this.isUtilPSDE11NameDirty()) {
            hashMap.put(FIELD_UTILPSDE11NAME, this.getUtilPSDE11Name());
        }
        if (!bl || this.isUtilPSDE12IdDirty()) {
            hashMap.put(FIELD_UTILPSDE12ID, this.getUtilPSDE12Id());
        }
        if (!bl || this.isUtilPSDE12NameDirty()) {
            hashMap.put(FIELD_UTILPSDE12NAME, this.getUtilPSDE12Name());
        }
        if (!bl || this.isUtilPSDE13IdDirty()) {
            hashMap.put(FIELD_UTILPSDE13ID, this.getUtilPSDE13Id());
        }
        if (!bl || this.isUtilPSDE13NameDirty()) {
            hashMap.put(FIELD_UTILPSDE13NAME, this.getUtilPSDE13Name());
        }
        if (!bl || this.isUtilPSDE14IdDirty()) {
            hashMap.put(FIELD_UTILPSDE14ID, this.getUtilPSDE14Id());
        }
        if (!bl || this.isUtilPSDE14NameDirty()) {
            hashMap.put(FIELD_UTILPSDE14NAME, this.getUtilPSDE14Name());
        }
        if (!bl || this.isUtilPSDE15IdDirty()) {
            hashMap.put(FIELD_UTILPSDE15ID, this.getUtilPSDE15Id());
        }
        if (!bl || this.isUtilPSDE15NameDirty()) {
            hashMap.put(FIELD_UTILPSDE15NAME, this.getUtilPSDE15Name());
        }
        if (!bl || this.isUtilPSDE16IdDirty()) {
            hashMap.put(FIELD_UTILPSDE16ID, this.getUtilPSDE16Id());
        }
        if (!bl || this.isUtilPSDE16NameDirty()) {
            hashMap.put(FIELD_UTILPSDE16NAME, this.getUtilPSDE16Name());
        }
        if (!bl || this.isUtilPSDE17IdDirty()) {
            hashMap.put(FIELD_UTILPSDE17ID, this.getUtilPSDE17Id());
        }
        if (!bl || this.isUtilPSDE17NameDirty()) {
            hashMap.put(FIELD_UTILPSDE17NAME, this.getUtilPSDE17Name());
        }
        if (!bl || this.isUtilPSDE18IdDirty()) {
            hashMap.put(FIELD_UTILPSDE18ID, this.getUtilPSDE18Id());
        }
        if (!bl || this.isUtilPSDE18NameDirty()) {
            hashMap.put(FIELD_UTILPSDE18NAME, this.getUtilPSDE18Name());
        }
        if (!bl || this.isUtilPSDE19IdDirty()) {
            hashMap.put(FIELD_UTILPSDE19ID, this.getUtilPSDE19Id());
        }
        if (!bl || this.isUtilPSDE19NameDirty()) {
            hashMap.put(FIELD_UTILPSDE19NAME, this.getUtilPSDE19Name());
        }
        if (!bl || this.isUtilPSDE20IdDirty()) {
            hashMap.put(FIELD_UTILPSDE20ID, this.getUtilPSDE20Id());
        }
        if (!bl || this.isUtilPSDE20NameDirty()) {
            hashMap.put(FIELD_UTILPSDE20NAME, this.getUtilPSDE20Name());
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
        if (!bl || this.isUtilTag2Dirty()) {
            hashMap.put(FIELD_UTILTAG2, this.getUtilTag2());
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
        return PSDEUtilDEBase.get(this, n);
    }

    private static Object get(PSDEUtilDEBase pSDEUtilDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUtilDEBase.getCodeName();
            }
            case 1: {
                return pSDEUtilDEBase.getCreateDate();
            }
            case 2: {
                return pSDEUtilDEBase.getCreateMan();
            }
            case 3: {
                return pSDEUtilDEBase.getExtendMode();
            }
            case 4: {
                return pSDEUtilDEBase.getLockFlag();
            }
            case 5: {
                return pSDEUtilDEBase.getMemo();
            }
            case 6: {
                return pSDEUtilDEBase.getPSDEId();
            }
            case 7: {
                return pSDEUtilDEBase.getPSDEName();
            }
            case 8: {
                return pSDEUtilDEBase.getPSDEUtilDEId();
            }
            case 9: {
                return pSDEUtilDEBase.getPSDEUtilDEName();
            }
            case 10: {
                return pSDEUtilDEBase.getPSSubSysServiceAPIId();
            }
            case 11: {
                return pSDEUtilDEBase.getPSSubSysServiceAPIName();
            }
            case 12: {
                return pSDEUtilDEBase.getPSSysDynaModelId();
            }
            case 13: {
                return pSDEUtilDEBase.getPSSysDynaModelName();
            }
            case 14: {
                return pSDEUtilDEBase.getPSSysSFPluginId();
            }
            case 15: {
                return pSDEUtilDEBase.getPSSysSFPluginName();
            }
            case 16: {
                return pSDEUtilDEBase.getUniqueTag();
            }
            case 17: {
                return pSDEUtilDEBase.getUpdateDate();
            }
            case 18: {
                return pSDEUtilDEBase.getUpdateMan();
            }
            case 19: {
                return pSDEUtilDEBase.getUserCat();
            }
            case 20: {
                return pSDEUtilDEBase.getUserTag();
            }
            case 21: {
                return pSDEUtilDEBase.getUserTag2();
            }
            case 22: {
                return pSDEUtilDEBase.getUserTag3();
            }
            case 23: {
                return pSDEUtilDEBase.getUserTag4();
            }
            case 24: {
                return pSDEUtilDEBase.getUtilObj();
            }
            case 25: {
                return pSDEUtilDEBase.getUtilParam();
            }
            case 26: {
                return pSDEUtilDEBase.getUtilParam10();
            }
            case 27: {
                return pSDEUtilDEBase.getUtilParam11();
            }
            case 28: {
                return pSDEUtilDEBase.getUtilParam12();
            }
            case 29: {
                return pSDEUtilDEBase.getUtilParam2();
            }
            case 30: {
                return pSDEUtilDEBase.getUtilParam3();
            }
            case 31: {
                return pSDEUtilDEBase.getUtilParam4();
            }
            case 32: {
                return pSDEUtilDEBase.getUtilParam5();
            }
            case 33: {
                return pSDEUtilDEBase.getUtilParam6();
            }
            case 34: {
                return pSDEUtilDEBase.getUtilParam7();
            }
            case 35: {
                return pSDEUtilDEBase.getUtilParam8();
            }
            case 36: {
                return pSDEUtilDEBase.getUtilParam9();
            }
            case 37: {
                return pSDEUtilDEBase.getUtilParams();
            }
            case 38: {
                return pSDEUtilDEBase.getUtilPSDE10Id();
            }
            case 39: {
                return pSDEUtilDEBase.getUtilPSDE10Name();
            }
            case 40: {
                return pSDEUtilDEBase.getUtilPSDE11Id();
            }
            case 41: {
                return pSDEUtilDEBase.getUtilPSDE11Name();
            }
            case 42: {
                return pSDEUtilDEBase.getUtilPSDE12Id();
            }
            case 43: {
                return pSDEUtilDEBase.getUtilPSDE12Name();
            }
            case 44: {
                return pSDEUtilDEBase.getUtilPSDE13Id();
            }
            case 45: {
                return pSDEUtilDEBase.getUtilPSDE13Name();
            }
            case 46: {
                return pSDEUtilDEBase.getUtilPSDE14Id();
            }
            case 47: {
                return pSDEUtilDEBase.getUtilPSDE14Name();
            }
            case 48: {
                return pSDEUtilDEBase.getUtilPSDE15Id();
            }
            case 49: {
                return pSDEUtilDEBase.getUtilPSDE15Name();
            }
            case 50: {
                return pSDEUtilDEBase.getUtilPSDE16Id();
            }
            case 51: {
                return pSDEUtilDEBase.getUtilPSDE16Name();
            }
            case 52: {
                return pSDEUtilDEBase.getUtilPSDE17Id();
            }
            case 53: {
                return pSDEUtilDEBase.getUtilPSDE17Name();
            }
            case 54: {
                return pSDEUtilDEBase.getUtilPSDE18Id();
            }
            case 55: {
                return pSDEUtilDEBase.getUtilPSDE18Name();
            }
            case 56: {
                return pSDEUtilDEBase.getUtilPSDE19Id();
            }
            case 57: {
                return pSDEUtilDEBase.getUtilPSDE19Name();
            }
            case 58: {
                return pSDEUtilDEBase.getUtilPSDE20Id();
            }
            case 59: {
                return pSDEUtilDEBase.getUtilPSDE20Name();
            }
            case 60: {
                return pSDEUtilDEBase.getUtilPSDE2Id();
            }
            case 61: {
                return pSDEUtilDEBase.getUtilPSDE2Name();
            }
            case 62: {
                return pSDEUtilDEBase.getUtilPSDE3Id();
            }
            case 63: {
                return pSDEUtilDEBase.getUtilPSDE3Name();
            }
            case 64: {
                return pSDEUtilDEBase.getUtilPSDE4Id();
            }
            case 65: {
                return pSDEUtilDEBase.getUtilPSDE4Name();
            }
            case 66: {
                return pSDEUtilDEBase.getUtilPSDE5Id();
            }
            case 67: {
                return pSDEUtilDEBase.getUtilPSDE5Name();
            }
            case 68: {
                return pSDEUtilDEBase.getUtilPSDE6Id();
            }
            case 69: {
                return pSDEUtilDEBase.getUtilPSDE6Name();
            }
            case 70: {
                return pSDEUtilDEBase.getUtilPSDE7Id();
            }
            case 71: {
                return pSDEUtilDEBase.getUtilPSDE7Name();
            }
            case 72: {
                return pSDEUtilDEBase.getUtilPSDE8Id();
            }
            case 73: {
                return pSDEUtilDEBase.getUtilPSDE8Name();
            }
            case 74: {
                return pSDEUtilDEBase.getUtilPSDE9Id();
            }
            case 75: {
                return pSDEUtilDEBase.getUtilPSDE9Name();
            }
            case 76: {
                return pSDEUtilDEBase.getUtilPSDEId();
            }
            case 77: {
                return pSDEUtilDEBase.getUtilPSDEName();
            }
            case 78: {
                return pSDEUtilDEBase.getUtilTag();
            }
            case 79: {
                return pSDEUtilDEBase.getUtilTag2();
            }
            case 80: {
                return pSDEUtilDEBase.getUtilType();
            }
            case 81: {
                return pSDEUtilDEBase.getValidFlag();
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
        PSDEUtilDEBase.set(this, n, object);
    }

    private static void set(PSDEUtilDEBase pSDEUtilDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUtilDEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEUtilDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEUtilDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEUtilDEBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEUtilDEBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEUtilDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEUtilDEBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEUtilDEBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEUtilDEBase.setPSDEUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEUtilDEBase.setPSDEUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEUtilDEBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEUtilDEBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEUtilDEBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEUtilDEBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEUtilDEBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEUtilDEBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEUtilDEBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEUtilDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDEUtilDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEUtilDEBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEUtilDEBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEUtilDEBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEUtilDEBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEUtilDEBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEUtilDEBase.setUtilObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEUtilDEBase.setUtilParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEUtilDEBase.setUtilParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEUtilDEBase.setUtilParam11(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEUtilDEBase.setUtilParam12(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEUtilDEBase.setUtilParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEUtilDEBase.setUtilParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEUtilDEBase.setUtilParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEUtilDEBase.setUtilParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEUtilDEBase.setUtilParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEUtilDEBase.setUtilParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEUtilDEBase.setUtilParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDEUtilDEBase.setUtilParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEUtilDEBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEUtilDEBase.setUtilPSDE10Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEUtilDEBase.setUtilPSDE10Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEUtilDEBase.setUtilPSDE11Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEUtilDEBase.setUtilPSDE11Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEUtilDEBase.setUtilPSDE12Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEUtilDEBase.setUtilPSDE12Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEUtilDEBase.setUtilPSDE13Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEUtilDEBase.setUtilPSDE13Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEUtilDEBase.setUtilPSDE14Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEUtilDEBase.setUtilPSDE14Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEUtilDEBase.setUtilPSDE15Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEUtilDEBase.setUtilPSDE15Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEUtilDEBase.setUtilPSDE16Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEUtilDEBase.setUtilPSDE16Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEUtilDEBase.setUtilPSDE17Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEUtilDEBase.setUtilPSDE17Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEUtilDEBase.setUtilPSDE18Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEUtilDEBase.setUtilPSDE18Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEUtilDEBase.setUtilPSDE19Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEUtilDEBase.setUtilPSDE19Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEUtilDEBase.setUtilPSDE20Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEUtilDEBase.setUtilPSDE20Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEUtilDEBase.setUtilPSDE2Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEUtilDEBase.setUtilPSDE2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEUtilDEBase.setUtilPSDE3Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEUtilDEBase.setUtilPSDE3Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEUtilDEBase.setUtilPSDE4Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEUtilDEBase.setUtilPSDE4Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEUtilDEBase.setUtilPSDE5Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEUtilDEBase.setUtilPSDE5Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEUtilDEBase.setUtilPSDE6Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEUtilDEBase.setUtilPSDE6Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEUtilDEBase.setUtilPSDE7Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEUtilDEBase.setUtilPSDE7Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEUtilDEBase.setUtilPSDE8Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEUtilDEBase.setUtilPSDE8Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEUtilDEBase.setUtilPSDE9Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEUtilDEBase.setUtilPSDE9Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEUtilDEBase.setUtilPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEUtilDEBase.setUtilPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEUtilDEBase.setUtilTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEUtilDEBase.setUtilTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEUtilDEBase.setUtilType(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEUtilDEBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEUtilDEBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUtilDEBase pSDEUtilDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUtilDEBase.getCodeName() == null;
            }
            case 1: {
                return pSDEUtilDEBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEUtilDEBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEUtilDEBase.getExtendMode() == null;
            }
            case 4: {
                return pSDEUtilDEBase.getLockFlag() == null;
            }
            case 5: {
                return pSDEUtilDEBase.getMemo() == null;
            }
            case 6: {
                return pSDEUtilDEBase.getPSDEId() == null;
            }
            case 7: {
                return pSDEUtilDEBase.getPSDEName() == null;
            }
            case 8: {
                return pSDEUtilDEBase.getPSDEUtilDEId() == null;
            }
            case 9: {
                return pSDEUtilDEBase.getPSDEUtilDEName() == null;
            }
            case 10: {
                return pSDEUtilDEBase.getPSSubSysServiceAPIId() == null;
            }
            case 11: {
                return pSDEUtilDEBase.getPSSubSysServiceAPIName() == null;
            }
            case 12: {
                return pSDEUtilDEBase.getPSSysDynaModelId() == null;
            }
            case 13: {
                return pSDEUtilDEBase.getPSSysDynaModelName() == null;
            }
            case 14: {
                return pSDEUtilDEBase.getPSSysSFPluginId() == null;
            }
            case 15: {
                return pSDEUtilDEBase.getPSSysSFPluginName() == null;
            }
            case 16: {
                return pSDEUtilDEBase.getUniqueTag() == null;
            }
            case 17: {
                return pSDEUtilDEBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDEUtilDEBase.getUpdateMan() == null;
            }
            case 19: {
                return pSDEUtilDEBase.getUserCat() == null;
            }
            case 20: {
                return pSDEUtilDEBase.getUserTag() == null;
            }
            case 21: {
                return pSDEUtilDEBase.getUserTag2() == null;
            }
            case 22: {
                return pSDEUtilDEBase.getUserTag3() == null;
            }
            case 23: {
                return pSDEUtilDEBase.getUserTag4() == null;
            }
            case 24: {
                return pSDEUtilDEBase.getUtilObj() == null;
            }
            case 25: {
                return pSDEUtilDEBase.getUtilParam() == null;
            }
            case 26: {
                return pSDEUtilDEBase.getUtilParam10() == null;
            }
            case 27: {
                return pSDEUtilDEBase.getUtilParam11() == null;
            }
            case 28: {
                return pSDEUtilDEBase.getUtilParam12() == null;
            }
            case 29: {
                return pSDEUtilDEBase.getUtilParam2() == null;
            }
            case 30: {
                return pSDEUtilDEBase.getUtilParam3() == null;
            }
            case 31: {
                return pSDEUtilDEBase.getUtilParam4() == null;
            }
            case 32: {
                return pSDEUtilDEBase.getUtilParam5() == null;
            }
            case 33: {
                return pSDEUtilDEBase.getUtilParam6() == null;
            }
            case 34: {
                return pSDEUtilDEBase.getUtilParam7() == null;
            }
            case 35: {
                return pSDEUtilDEBase.getUtilParam8() == null;
            }
            case 36: {
                return pSDEUtilDEBase.getUtilParam9() == null;
            }
            case 37: {
                return pSDEUtilDEBase.getUtilParams() == null;
            }
            case 38: {
                return pSDEUtilDEBase.getUtilPSDE10Id() == null;
            }
            case 39: {
                return pSDEUtilDEBase.getUtilPSDE10Name() == null;
            }
            case 40: {
                return pSDEUtilDEBase.getUtilPSDE11Id() == null;
            }
            case 41: {
                return pSDEUtilDEBase.getUtilPSDE11Name() == null;
            }
            case 42: {
                return pSDEUtilDEBase.getUtilPSDE12Id() == null;
            }
            case 43: {
                return pSDEUtilDEBase.getUtilPSDE12Name() == null;
            }
            case 44: {
                return pSDEUtilDEBase.getUtilPSDE13Id() == null;
            }
            case 45: {
                return pSDEUtilDEBase.getUtilPSDE13Name() == null;
            }
            case 46: {
                return pSDEUtilDEBase.getUtilPSDE14Id() == null;
            }
            case 47: {
                return pSDEUtilDEBase.getUtilPSDE14Name() == null;
            }
            case 48: {
                return pSDEUtilDEBase.getUtilPSDE15Id() == null;
            }
            case 49: {
                return pSDEUtilDEBase.getUtilPSDE15Name() == null;
            }
            case 50: {
                return pSDEUtilDEBase.getUtilPSDE16Id() == null;
            }
            case 51: {
                return pSDEUtilDEBase.getUtilPSDE16Name() == null;
            }
            case 52: {
                return pSDEUtilDEBase.getUtilPSDE17Id() == null;
            }
            case 53: {
                return pSDEUtilDEBase.getUtilPSDE17Name() == null;
            }
            case 54: {
                return pSDEUtilDEBase.getUtilPSDE18Id() == null;
            }
            case 55: {
                return pSDEUtilDEBase.getUtilPSDE18Name() == null;
            }
            case 56: {
                return pSDEUtilDEBase.getUtilPSDE19Id() == null;
            }
            case 57: {
                return pSDEUtilDEBase.getUtilPSDE19Name() == null;
            }
            case 58: {
                return pSDEUtilDEBase.getUtilPSDE20Id() == null;
            }
            case 59: {
                return pSDEUtilDEBase.getUtilPSDE20Name() == null;
            }
            case 60: {
                return pSDEUtilDEBase.getUtilPSDE2Id() == null;
            }
            case 61: {
                return pSDEUtilDEBase.getUtilPSDE2Name() == null;
            }
            case 62: {
                return pSDEUtilDEBase.getUtilPSDE3Id() == null;
            }
            case 63: {
                return pSDEUtilDEBase.getUtilPSDE3Name() == null;
            }
            case 64: {
                return pSDEUtilDEBase.getUtilPSDE4Id() == null;
            }
            case 65: {
                return pSDEUtilDEBase.getUtilPSDE4Name() == null;
            }
            case 66: {
                return pSDEUtilDEBase.getUtilPSDE5Id() == null;
            }
            case 67: {
                return pSDEUtilDEBase.getUtilPSDE5Name() == null;
            }
            case 68: {
                return pSDEUtilDEBase.getUtilPSDE6Id() == null;
            }
            case 69: {
                return pSDEUtilDEBase.getUtilPSDE6Name() == null;
            }
            case 70: {
                return pSDEUtilDEBase.getUtilPSDE7Id() == null;
            }
            case 71: {
                return pSDEUtilDEBase.getUtilPSDE7Name() == null;
            }
            case 72: {
                return pSDEUtilDEBase.getUtilPSDE8Id() == null;
            }
            case 73: {
                return pSDEUtilDEBase.getUtilPSDE8Name() == null;
            }
            case 74: {
                return pSDEUtilDEBase.getUtilPSDE9Id() == null;
            }
            case 75: {
                return pSDEUtilDEBase.getUtilPSDE9Name() == null;
            }
            case 76: {
                return pSDEUtilDEBase.getUtilPSDEId() == null;
            }
            case 77: {
                return pSDEUtilDEBase.getUtilPSDEName() == null;
            }
            case 78: {
                return pSDEUtilDEBase.getUtilTag() == null;
            }
            case 79: {
                return pSDEUtilDEBase.getUtilTag2() == null;
            }
            case 80: {
                return pSDEUtilDEBase.getUtilType() == null;
            }
            case 81: {
                return pSDEUtilDEBase.getValidFlag() == null;
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
        return PSDEUtilDEBase.contains(this, n);
    }

    private static boolean contains(PSDEUtilDEBase pSDEUtilDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUtilDEBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEUtilDEBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEUtilDEBase.isCreateManDirty();
            }
            case 3: {
                return pSDEUtilDEBase.isExtendModeDirty();
            }
            case 4: {
                return pSDEUtilDEBase.isLockFlagDirty();
            }
            case 5: {
                return pSDEUtilDEBase.isMemoDirty();
            }
            case 6: {
                return pSDEUtilDEBase.isPSDEIdDirty();
            }
            case 7: {
                return pSDEUtilDEBase.isPSDENameDirty();
            }
            case 8: {
                return pSDEUtilDEBase.isPSDEUtilDEIdDirty();
            }
            case 9: {
                return pSDEUtilDEBase.isPSDEUtilDENameDirty();
            }
            case 10: {
                return pSDEUtilDEBase.isPSSubSysServiceAPIIdDirty();
            }
            case 11: {
                return pSDEUtilDEBase.isPSSubSysServiceAPINameDirty();
            }
            case 12: {
                return pSDEUtilDEBase.isPSSysDynaModelIdDirty();
            }
            case 13: {
                return pSDEUtilDEBase.isPSSysDynaModelNameDirty();
            }
            case 14: {
                return pSDEUtilDEBase.isPSSysSFPluginIdDirty();
            }
            case 15: {
                return pSDEUtilDEBase.isPSSysSFPluginNameDirty();
            }
            case 16: {
                return pSDEUtilDEBase.isUniqueTagDirty();
            }
            case 17: {
                return pSDEUtilDEBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDEUtilDEBase.isUpdateManDirty();
            }
            case 19: {
                return pSDEUtilDEBase.isUserCatDirty();
            }
            case 20: {
                return pSDEUtilDEBase.isUserTagDirty();
            }
            case 21: {
                return pSDEUtilDEBase.isUserTag2Dirty();
            }
            case 22: {
                return pSDEUtilDEBase.isUserTag3Dirty();
            }
            case 23: {
                return pSDEUtilDEBase.isUserTag4Dirty();
            }
            case 24: {
                return pSDEUtilDEBase.isUtilObjDirty();
            }
            case 25: {
                return pSDEUtilDEBase.isUtilParamDirty();
            }
            case 26: {
                return pSDEUtilDEBase.isUtilParam10Dirty();
            }
            case 27: {
                return pSDEUtilDEBase.isUtilParam11Dirty();
            }
            case 28: {
                return pSDEUtilDEBase.isUtilParam12Dirty();
            }
            case 29: {
                return pSDEUtilDEBase.isUtilParam2Dirty();
            }
            case 30: {
                return pSDEUtilDEBase.isUtilParam3Dirty();
            }
            case 31: {
                return pSDEUtilDEBase.isUtilParam4Dirty();
            }
            case 32: {
                return pSDEUtilDEBase.isUtilParam5Dirty();
            }
            case 33: {
                return pSDEUtilDEBase.isUtilParam6Dirty();
            }
            case 34: {
                return pSDEUtilDEBase.isUtilParam7Dirty();
            }
            case 35: {
                return pSDEUtilDEBase.isUtilParam8Dirty();
            }
            case 36: {
                return pSDEUtilDEBase.isUtilParam9Dirty();
            }
            case 37: {
                return pSDEUtilDEBase.isUtilParamsDirty();
            }
            case 38: {
                return pSDEUtilDEBase.isUtilPSDE10IdDirty();
            }
            case 39: {
                return pSDEUtilDEBase.isUtilPSDE10NameDirty();
            }
            case 40: {
                return pSDEUtilDEBase.isUtilPSDE11IdDirty();
            }
            case 41: {
                return pSDEUtilDEBase.isUtilPSDE11NameDirty();
            }
            case 42: {
                return pSDEUtilDEBase.isUtilPSDE12IdDirty();
            }
            case 43: {
                return pSDEUtilDEBase.isUtilPSDE12NameDirty();
            }
            case 44: {
                return pSDEUtilDEBase.isUtilPSDE13IdDirty();
            }
            case 45: {
                return pSDEUtilDEBase.isUtilPSDE13NameDirty();
            }
            case 46: {
                return pSDEUtilDEBase.isUtilPSDE14IdDirty();
            }
            case 47: {
                return pSDEUtilDEBase.isUtilPSDE14NameDirty();
            }
            case 48: {
                return pSDEUtilDEBase.isUtilPSDE15IdDirty();
            }
            case 49: {
                return pSDEUtilDEBase.isUtilPSDE15NameDirty();
            }
            case 50: {
                return pSDEUtilDEBase.isUtilPSDE16IdDirty();
            }
            case 51: {
                return pSDEUtilDEBase.isUtilPSDE16NameDirty();
            }
            case 52: {
                return pSDEUtilDEBase.isUtilPSDE17IdDirty();
            }
            case 53: {
                return pSDEUtilDEBase.isUtilPSDE17NameDirty();
            }
            case 54: {
                return pSDEUtilDEBase.isUtilPSDE18IdDirty();
            }
            case 55: {
                return pSDEUtilDEBase.isUtilPSDE18NameDirty();
            }
            case 56: {
                return pSDEUtilDEBase.isUtilPSDE19IdDirty();
            }
            case 57: {
                return pSDEUtilDEBase.isUtilPSDE19NameDirty();
            }
            case 58: {
                return pSDEUtilDEBase.isUtilPSDE20IdDirty();
            }
            case 59: {
                return pSDEUtilDEBase.isUtilPSDE20NameDirty();
            }
            case 60: {
                return pSDEUtilDEBase.isUtilPSDE2IdDirty();
            }
            case 61: {
                return pSDEUtilDEBase.isUtilPSDE2NameDirty();
            }
            case 62: {
                return pSDEUtilDEBase.isUtilPSDE3IdDirty();
            }
            case 63: {
                return pSDEUtilDEBase.isUtilPSDE3NameDirty();
            }
            case 64: {
                return pSDEUtilDEBase.isUtilPSDE4IdDirty();
            }
            case 65: {
                return pSDEUtilDEBase.isUtilPSDE4NameDirty();
            }
            case 66: {
                return pSDEUtilDEBase.isUtilPSDE5IdDirty();
            }
            case 67: {
                return pSDEUtilDEBase.isUtilPSDE5NameDirty();
            }
            case 68: {
                return pSDEUtilDEBase.isUtilPSDE6IdDirty();
            }
            case 69: {
                return pSDEUtilDEBase.isUtilPSDE6NameDirty();
            }
            case 70: {
                return pSDEUtilDEBase.isUtilPSDE7IdDirty();
            }
            case 71: {
                return pSDEUtilDEBase.isUtilPSDE7NameDirty();
            }
            case 72: {
                return pSDEUtilDEBase.isUtilPSDE8IdDirty();
            }
            case 73: {
                return pSDEUtilDEBase.isUtilPSDE8NameDirty();
            }
            case 74: {
                return pSDEUtilDEBase.isUtilPSDE9IdDirty();
            }
            case 75: {
                return pSDEUtilDEBase.isUtilPSDE9NameDirty();
            }
            case 76: {
                return pSDEUtilDEBase.isUtilPSDEIdDirty();
            }
            case 77: {
                return pSDEUtilDEBase.isUtilPSDENameDirty();
            }
            case 78: {
                return pSDEUtilDEBase.isUtilTagDirty();
            }
            case 79: {
                return pSDEUtilDEBase.isUtilTag2Dirty();
            }
            case 80: {
                return pSDEUtilDEBase.isUtilTypeDirty();
            }
            case 81: {
                return pSDEUtilDEBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUtilDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUtilDEBase pSDEUtilDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUtilDEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSDEUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeutildeid", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSDEUtilDEId()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSDEUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeutildename", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSDEUtilDEName()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilobj", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilObj()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam10", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam10()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam11", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam11()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam12", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam12()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam2", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam2()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam3", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam3()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam4", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam4()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam5", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam5()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam6", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam6()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam7", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam7()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam8", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam8()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparam9", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParam9()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE10Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde10id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE10Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE10Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde10name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE10Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE11Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde11id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE11Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE11Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde11name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE11Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE12Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde12id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE12Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE12Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde12name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE12Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE13Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde13id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE13Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE13Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde13name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE13Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE14Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde14id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE14Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE14Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde14name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE14Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE15Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde15id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE15Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE15Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde15name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE15Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE16Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde16id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE16Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE16Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde16name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE16Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE17Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde17id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE17Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE17Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde17name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE17Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE18Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde18id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE18Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE18Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde18name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE18Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE19Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde19id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE19Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE19Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde19name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE19Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE20Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde20id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE20Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE20Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde20name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE20Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE2Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde2id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE2Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde2name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE2Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE3Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde3id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE3Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE3Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde3name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE3Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE4Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde4id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE4Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE4Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde4name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE4Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE5Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde5id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE5Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE5Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde5name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE5Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE6Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde6id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE6Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE6Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde6name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE6Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE7Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde7id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE7Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE7Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde7name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE7Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE8Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde8id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE8Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE8Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde8name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE8Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE9Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde9id", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE9Id()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE9Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsde9name", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDE9Name()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdeid", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDEId()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdename", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilPSDEName()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltag", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilTag()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltag2", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilTag2()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getUtilType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltype", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getUtilType()), (boolean)false);
        }
        if (bl || pSDEUtilDEBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEUtilDEBase.getJSONValue((Object)pSDEUtilDEBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUtilDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUtilDEBase pSDEUtilDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUtilDEBase.getCodeName() != null) {
            object = pSDEUtilDEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getCreateDate() != null) {
            object = pSDEUtilDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getCreateMan() != null) {
            object = pSDEUtilDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getExtendMode() != null) {
            object = pSDEUtilDEBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getLockFlag() != null) {
            object = pSDEUtilDEBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getMemo() != null) {
            object = pSDEUtilDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSDEId() != null) {
            object = pSDEUtilDEBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSDEName() != null) {
            object = pSDEUtilDEBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSDEUtilDEId() != null) {
            object = pSDEUtilDEBase.getPSDEUtilDEId();
            xmlNode.setAttribute(FIELD_PSDEUTILDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSDEUtilDEName() != null) {
            object = pSDEUtilDEBase.getPSDEUtilDEName();
            xmlNode.setAttribute(FIELD_PSDEUTILDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSSubSysServiceAPIId() != null) {
            object = pSDEUtilDEBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSSubSysServiceAPIName() != null) {
            object = pSDEUtilDEBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSSysDynaModelId() != null) {
            object = pSDEUtilDEBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSSysDynaModelName() != null) {
            object = pSDEUtilDEBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSSysSFPluginId() != null) {
            object = pSDEUtilDEBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getPSSysSFPluginName() != null) {
            object = pSDEUtilDEBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUniqueTag() != null) {
            object = pSDEUtilDEBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUpdateDate() != null) {
            object = pSDEUtilDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getUpdateMan() != null) {
            object = pSDEUtilDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUserCat() != null) {
            object = pSDEUtilDEBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUserTag() != null) {
            object = pSDEUtilDEBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUserTag2() != null) {
            object = pSDEUtilDEBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUserTag3() != null) {
            object = pSDEUtilDEBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUserTag4() != null) {
            object = pSDEUtilDEBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilObj() != null) {
            object = pSDEUtilDEBase.getUtilObj();
            xmlNode.setAttribute(FIELD_UTILOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilParam() != null) {
            object = pSDEUtilDEBase.getUtilParam();
            xmlNode.setAttribute(FIELD_UTILPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilParam10() != null) {
            object = pSDEUtilDEBase.getUtilParam10();
            xmlNode.setAttribute(FIELD_UTILPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getUtilParam11() != null) {
            object = pSDEUtilDEBase.getUtilParam11();
            xmlNode.setAttribute(FIELD_UTILPARAM11, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilParam12() != null) {
            object = pSDEUtilDEBase.getUtilParam12();
            xmlNode.setAttribute(FIELD_UTILPARAM12, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilParam2() != null) {
            object = pSDEUtilDEBase.getUtilParam2();
            xmlNode.setAttribute(FIELD_UTILPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilParam3() != null) {
            object = pSDEUtilDEBase.getUtilParam3();
            xmlNode.setAttribute(FIELD_UTILPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilParam4() != null) {
            object = pSDEUtilDEBase.getUtilParam4();
            xmlNode.setAttribute(FIELD_UTILPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilParam5() != null) {
            object = pSDEUtilDEBase.getUtilParam5();
            xmlNode.setAttribute(FIELD_UTILPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getUtilParam6() != null) {
            object = pSDEUtilDEBase.getUtilParam6();
            xmlNode.setAttribute(FIELD_UTILPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getUtilParam7() != null) {
            object = pSDEUtilDEBase.getUtilParam7();
            xmlNode.setAttribute(FIELD_UTILPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getUtilParam8() != null) {
            object = pSDEUtilDEBase.getUtilParam8();
            xmlNode.setAttribute(FIELD_UTILPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getUtilParam9() != null) {
            object = pSDEUtilDEBase.getUtilParam9();
            xmlNode.setAttribute(FIELD_UTILPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUtilDEBase.getUtilParams() != null) {
            object = pSDEUtilDEBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE10Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE10Id();
            xmlNode.setAttribute(FIELD_UTILPSDE10ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE10Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE10Name();
            xmlNode.setAttribute(FIELD_UTILPSDE10NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE11Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE11Id();
            xmlNode.setAttribute(FIELD_UTILPSDE11ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE11Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE11Name();
            xmlNode.setAttribute(FIELD_UTILPSDE11NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE12Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE12Id();
            xmlNode.setAttribute(FIELD_UTILPSDE12ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE12Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE12Name();
            xmlNode.setAttribute(FIELD_UTILPSDE12NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE13Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE13Id();
            xmlNode.setAttribute(FIELD_UTILPSDE13ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE13Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE13Name();
            xmlNode.setAttribute(FIELD_UTILPSDE13NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE14Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE14Id();
            xmlNode.setAttribute(FIELD_UTILPSDE14ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE14Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE14Name();
            xmlNode.setAttribute(FIELD_UTILPSDE14NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE15Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE15Id();
            xmlNode.setAttribute(FIELD_UTILPSDE15ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE15Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE15Name();
            xmlNode.setAttribute(FIELD_UTILPSDE15NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE16Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE16Id();
            xmlNode.setAttribute(FIELD_UTILPSDE16ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE16Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE16Name();
            xmlNode.setAttribute(FIELD_UTILPSDE16NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE17Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE17Id();
            xmlNode.setAttribute(FIELD_UTILPSDE17ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE17Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE17Name();
            xmlNode.setAttribute(FIELD_UTILPSDE17NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE18Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE18Id();
            xmlNode.setAttribute(FIELD_UTILPSDE18ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE18Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE18Name();
            xmlNode.setAttribute(FIELD_UTILPSDE18NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE19Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE19Id();
            xmlNode.setAttribute(FIELD_UTILPSDE19ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE19Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE19Name();
            xmlNode.setAttribute(FIELD_UTILPSDE19NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE20Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE20Id();
            xmlNode.setAttribute(FIELD_UTILPSDE20ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE20Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE20Name();
            xmlNode.setAttribute(FIELD_UTILPSDE20NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE2Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE2Id();
            xmlNode.setAttribute(FIELD_UTILPSDE2ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE2Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE2Name();
            xmlNode.setAttribute(FIELD_UTILPSDE2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE3Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE3Id();
            xmlNode.setAttribute(FIELD_UTILPSDE3ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE3Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE3Name();
            xmlNode.setAttribute(FIELD_UTILPSDE3NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE4Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE4Id();
            xmlNode.setAttribute(FIELD_UTILPSDE4ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE4Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE4Name();
            xmlNode.setAttribute(FIELD_UTILPSDE4NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE5Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE5Id();
            xmlNode.setAttribute(FIELD_UTILPSDE5ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE5Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE5Name();
            xmlNode.setAttribute(FIELD_UTILPSDE5NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE6Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE6Id();
            xmlNode.setAttribute(FIELD_UTILPSDE6ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE6Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE6Name();
            xmlNode.setAttribute(FIELD_UTILPSDE6NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE7Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE7Id();
            xmlNode.setAttribute(FIELD_UTILPSDE7ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE7Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE7Name();
            xmlNode.setAttribute(FIELD_UTILPSDE7NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE8Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE8Id();
            xmlNode.setAttribute(FIELD_UTILPSDE8ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE8Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE8Name();
            xmlNode.setAttribute(FIELD_UTILPSDE8NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE9Id() != null) {
            object = pSDEUtilDEBase.getUtilPSDE9Id();
            xmlNode.setAttribute(FIELD_UTILPSDE9ID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDE9Name() != null) {
            object = pSDEUtilDEBase.getUtilPSDE9Name();
            xmlNode.setAttribute(FIELD_UTILPSDE9NAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDEId() != null) {
            object = pSDEUtilDEBase.getUtilPSDEId();
            xmlNode.setAttribute(FIELD_UTILPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilPSDEName() != null) {
            object = pSDEUtilDEBase.getUtilPSDEName();
            xmlNode.setAttribute(FIELD_UTILPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilTag() != null) {
            object = pSDEUtilDEBase.getUtilTag();
            xmlNode.setAttribute(FIELD_UTILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilTag2() != null) {
            object = pSDEUtilDEBase.getUtilTag2();
            xmlNode.setAttribute(FIELD_UTILTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getUtilType() != null) {
            object = pSDEUtilDEBase.getUtilType();
            xmlNode.setAttribute(FIELD_UTILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilDEBase.getValidFlag() != null) {
            object = pSDEUtilDEBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUtilDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUtilDEBase pSDEUtilDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUtilDEBase.isCodeNameDirty() && (bl || pSDEUtilDEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEUtilDEBase.getCodeName());
        }
        if (pSDEUtilDEBase.isCreateDateDirty() && (bl || pSDEUtilDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUtilDEBase.getCreateDate());
        }
        if (pSDEUtilDEBase.isCreateManDirty() && (bl || pSDEUtilDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUtilDEBase.getCreateMan());
        }
        if (pSDEUtilDEBase.isExtendModeDirty() && (bl || pSDEUtilDEBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEUtilDEBase.getExtendMode());
        }
        if (pSDEUtilDEBase.isLockFlagDirty() && (bl || pSDEUtilDEBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEUtilDEBase.getLockFlag());
        }
        if (pSDEUtilDEBase.isMemoDirty() && (bl || pSDEUtilDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEUtilDEBase.getMemo());
        }
        if (pSDEUtilDEBase.isPSDEIdDirty() && (bl || pSDEUtilDEBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEUtilDEBase.getPSDEId());
        }
        if (pSDEUtilDEBase.isPSDENameDirty() && (bl || pSDEUtilDEBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEUtilDEBase.getPSDEName());
        }
        if (pSDEUtilDEBase.isPSDEUtilDEIdDirty() && (bl || pSDEUtilDEBase.getPSDEUtilDEId() != null)) {
            iDataObject.set(FIELD_PSDEUTILDEID, (Object)pSDEUtilDEBase.getPSDEUtilDEId());
        }
        if (pSDEUtilDEBase.isPSDEUtilDENameDirty() && (bl || pSDEUtilDEBase.getPSDEUtilDEName() != null)) {
            iDataObject.set(FIELD_PSDEUTILDENAME, (Object)pSDEUtilDEBase.getPSDEUtilDEName());
        }
        if (pSDEUtilDEBase.isPSSubSysServiceAPIIdDirty() && (bl || pSDEUtilDEBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSDEUtilDEBase.getPSSubSysServiceAPIId());
        }
        if (pSDEUtilDEBase.isPSSubSysServiceAPINameDirty() && (bl || pSDEUtilDEBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSDEUtilDEBase.getPSSubSysServiceAPIName());
        }
        if (pSDEUtilDEBase.isPSSysDynaModelIdDirty() && (bl || pSDEUtilDEBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEUtilDEBase.getPSSysDynaModelId());
        }
        if (pSDEUtilDEBase.isPSSysDynaModelNameDirty() && (bl || pSDEUtilDEBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEUtilDEBase.getPSSysDynaModelName());
        }
        if (pSDEUtilDEBase.isPSSysSFPluginIdDirty() && (bl || pSDEUtilDEBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEUtilDEBase.getPSSysSFPluginId());
        }
        if (pSDEUtilDEBase.isPSSysSFPluginNameDirty() && (bl || pSDEUtilDEBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEUtilDEBase.getPSSysSFPluginName());
        }
        if (pSDEUtilDEBase.isUniqueTagDirty() && (bl || pSDEUtilDEBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSDEUtilDEBase.getUniqueTag());
        }
        if (pSDEUtilDEBase.isUpdateDateDirty() && (bl || pSDEUtilDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUtilDEBase.getUpdateDate());
        }
        if (pSDEUtilDEBase.isUpdateManDirty() && (bl || pSDEUtilDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUtilDEBase.getUpdateMan());
        }
        if (pSDEUtilDEBase.isUserCatDirty() && (bl || pSDEUtilDEBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEUtilDEBase.getUserCat());
        }
        if (pSDEUtilDEBase.isUserTagDirty() && (bl || pSDEUtilDEBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEUtilDEBase.getUserTag());
        }
        if (pSDEUtilDEBase.isUserTag2Dirty() && (bl || pSDEUtilDEBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEUtilDEBase.getUserTag2());
        }
        if (pSDEUtilDEBase.isUserTag3Dirty() && (bl || pSDEUtilDEBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEUtilDEBase.getUserTag3());
        }
        if (pSDEUtilDEBase.isUserTag4Dirty() && (bl || pSDEUtilDEBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEUtilDEBase.getUserTag4());
        }
        if (pSDEUtilDEBase.isUtilObjDirty() && (bl || pSDEUtilDEBase.getUtilObj() != null)) {
            iDataObject.set(FIELD_UTILOBJ, (Object)pSDEUtilDEBase.getUtilObj());
        }
        if (pSDEUtilDEBase.isUtilParamDirty() && (bl || pSDEUtilDEBase.getUtilParam() != null)) {
            iDataObject.set(FIELD_UTILPARAM, (Object)pSDEUtilDEBase.getUtilParam());
        }
        if (pSDEUtilDEBase.isUtilParam10Dirty() && (bl || pSDEUtilDEBase.getUtilParam10() != null)) {
            iDataObject.set(FIELD_UTILPARAM10, (Object)pSDEUtilDEBase.getUtilParam10());
        }
        if (pSDEUtilDEBase.isUtilParam11Dirty() && (bl || pSDEUtilDEBase.getUtilParam11() != null)) {
            iDataObject.set(FIELD_UTILPARAM11, (Object)pSDEUtilDEBase.getUtilParam11());
        }
        if (pSDEUtilDEBase.isUtilParam12Dirty() && (bl || pSDEUtilDEBase.getUtilParam12() != null)) {
            iDataObject.set(FIELD_UTILPARAM12, (Object)pSDEUtilDEBase.getUtilParam12());
        }
        if (pSDEUtilDEBase.isUtilParam2Dirty() && (bl || pSDEUtilDEBase.getUtilParam2() != null)) {
            iDataObject.set(FIELD_UTILPARAM2, (Object)pSDEUtilDEBase.getUtilParam2());
        }
        if (pSDEUtilDEBase.isUtilParam3Dirty() && (bl || pSDEUtilDEBase.getUtilParam3() != null)) {
            iDataObject.set(FIELD_UTILPARAM3, (Object)pSDEUtilDEBase.getUtilParam3());
        }
        if (pSDEUtilDEBase.isUtilParam4Dirty() && (bl || pSDEUtilDEBase.getUtilParam4() != null)) {
            iDataObject.set(FIELD_UTILPARAM4, (Object)pSDEUtilDEBase.getUtilParam4());
        }
        if (pSDEUtilDEBase.isUtilParam5Dirty() && (bl || pSDEUtilDEBase.getUtilParam5() != null)) {
            iDataObject.set(FIELD_UTILPARAM5, (Object)pSDEUtilDEBase.getUtilParam5());
        }
        if (pSDEUtilDEBase.isUtilParam6Dirty() && (bl || pSDEUtilDEBase.getUtilParam6() != null)) {
            iDataObject.set(FIELD_UTILPARAM6, (Object)pSDEUtilDEBase.getUtilParam6());
        }
        if (pSDEUtilDEBase.isUtilParam7Dirty() && (bl || pSDEUtilDEBase.getUtilParam7() != null)) {
            iDataObject.set(FIELD_UTILPARAM7, (Object)pSDEUtilDEBase.getUtilParam7());
        }
        if (pSDEUtilDEBase.isUtilParam8Dirty() && (bl || pSDEUtilDEBase.getUtilParam8() != null)) {
            iDataObject.set(FIELD_UTILPARAM8, (Object)pSDEUtilDEBase.getUtilParam8());
        }
        if (pSDEUtilDEBase.isUtilParam9Dirty() && (bl || pSDEUtilDEBase.getUtilParam9() != null)) {
            iDataObject.set(FIELD_UTILPARAM9, (Object)pSDEUtilDEBase.getUtilParam9());
        }
        if (pSDEUtilDEBase.isUtilParamsDirty() && (bl || pSDEUtilDEBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSDEUtilDEBase.getUtilParams());
        }
        if (pSDEUtilDEBase.isUtilPSDE10IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE10Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE10ID, (Object)pSDEUtilDEBase.getUtilPSDE10Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE10NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE10Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE10NAME, (Object)pSDEUtilDEBase.getUtilPSDE10Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE11IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE11Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE11ID, (Object)pSDEUtilDEBase.getUtilPSDE11Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE11NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE11Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE11NAME, (Object)pSDEUtilDEBase.getUtilPSDE11Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE12IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE12Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE12ID, (Object)pSDEUtilDEBase.getUtilPSDE12Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE12NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE12Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE12NAME, (Object)pSDEUtilDEBase.getUtilPSDE12Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE13IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE13Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE13ID, (Object)pSDEUtilDEBase.getUtilPSDE13Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE13NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE13Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE13NAME, (Object)pSDEUtilDEBase.getUtilPSDE13Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE14IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE14Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE14ID, (Object)pSDEUtilDEBase.getUtilPSDE14Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE14NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE14Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE14NAME, (Object)pSDEUtilDEBase.getUtilPSDE14Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE15IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE15Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE15ID, (Object)pSDEUtilDEBase.getUtilPSDE15Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE15NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE15Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE15NAME, (Object)pSDEUtilDEBase.getUtilPSDE15Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE16IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE16Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE16ID, (Object)pSDEUtilDEBase.getUtilPSDE16Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE16NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE16Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE16NAME, (Object)pSDEUtilDEBase.getUtilPSDE16Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE17IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE17Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE17ID, (Object)pSDEUtilDEBase.getUtilPSDE17Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE17NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE17Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE17NAME, (Object)pSDEUtilDEBase.getUtilPSDE17Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE18IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE18Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE18ID, (Object)pSDEUtilDEBase.getUtilPSDE18Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE18NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE18Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE18NAME, (Object)pSDEUtilDEBase.getUtilPSDE18Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE19IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE19Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE19ID, (Object)pSDEUtilDEBase.getUtilPSDE19Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE19NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE19Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE19NAME, (Object)pSDEUtilDEBase.getUtilPSDE19Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE20IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE20Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE20ID, (Object)pSDEUtilDEBase.getUtilPSDE20Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE20NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE20Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE20NAME, (Object)pSDEUtilDEBase.getUtilPSDE20Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE2IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE2Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE2ID, (Object)pSDEUtilDEBase.getUtilPSDE2Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE2NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE2Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE2NAME, (Object)pSDEUtilDEBase.getUtilPSDE2Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE3IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE3Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE3ID, (Object)pSDEUtilDEBase.getUtilPSDE3Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE3NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE3Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE3NAME, (Object)pSDEUtilDEBase.getUtilPSDE3Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE4IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE4Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE4ID, (Object)pSDEUtilDEBase.getUtilPSDE4Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE4NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE4Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE4NAME, (Object)pSDEUtilDEBase.getUtilPSDE4Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE5IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE5Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE5ID, (Object)pSDEUtilDEBase.getUtilPSDE5Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE5NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE5Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE5NAME, (Object)pSDEUtilDEBase.getUtilPSDE5Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE6IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE6Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE6ID, (Object)pSDEUtilDEBase.getUtilPSDE6Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE6NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE6Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE6NAME, (Object)pSDEUtilDEBase.getUtilPSDE6Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE7IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE7Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE7ID, (Object)pSDEUtilDEBase.getUtilPSDE7Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE7NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE7Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE7NAME, (Object)pSDEUtilDEBase.getUtilPSDE7Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE8IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE8Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE8ID, (Object)pSDEUtilDEBase.getUtilPSDE8Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE8NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE8Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE8NAME, (Object)pSDEUtilDEBase.getUtilPSDE8Name());
        }
        if (pSDEUtilDEBase.isUtilPSDE9IdDirty() && (bl || pSDEUtilDEBase.getUtilPSDE9Id() != null)) {
            iDataObject.set(FIELD_UTILPSDE9ID, (Object)pSDEUtilDEBase.getUtilPSDE9Id());
        }
        if (pSDEUtilDEBase.isUtilPSDE9NameDirty() && (bl || pSDEUtilDEBase.getUtilPSDE9Name() != null)) {
            iDataObject.set(FIELD_UTILPSDE9NAME, (Object)pSDEUtilDEBase.getUtilPSDE9Name());
        }
        if (pSDEUtilDEBase.isUtilPSDEIdDirty() && (bl || pSDEUtilDEBase.getUtilPSDEId() != null)) {
            iDataObject.set(FIELD_UTILPSDEID, (Object)pSDEUtilDEBase.getUtilPSDEId());
        }
        if (pSDEUtilDEBase.isUtilPSDENameDirty() && (bl || pSDEUtilDEBase.getUtilPSDEName() != null)) {
            iDataObject.set(FIELD_UTILPSDENAME, (Object)pSDEUtilDEBase.getUtilPSDEName());
        }
        if (pSDEUtilDEBase.isUtilTagDirty() && (bl || pSDEUtilDEBase.getUtilTag() != null)) {
            iDataObject.set(FIELD_UTILTAG, (Object)pSDEUtilDEBase.getUtilTag());
        }
        if (pSDEUtilDEBase.isUtilTag2Dirty() && (bl || pSDEUtilDEBase.getUtilTag2() != null)) {
            iDataObject.set(FIELD_UTILTAG2, (Object)pSDEUtilDEBase.getUtilTag2());
        }
        if (pSDEUtilDEBase.isUtilTypeDirty() && (bl || pSDEUtilDEBase.getUtilType() != null)) {
            iDataObject.set(FIELD_UTILTYPE, (Object)pSDEUtilDEBase.getUtilType());
        }
        if (pSDEUtilDEBase.isValidFlagDirty() && (bl || pSDEUtilDEBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEUtilDEBase.getValidFlag());
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
        return PSDEUtilDEBase.remove(this, n);
    }

    private static boolean remove(PSDEUtilDEBase pSDEUtilDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUtilDEBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEUtilDEBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEUtilDEBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEUtilDEBase.resetExtendMode();
                return true;
            }
            case 4: {
                pSDEUtilDEBase.resetLockFlag();
                return true;
            }
            case 5: {
                pSDEUtilDEBase.resetMemo();
                return true;
            }
            case 6: {
                pSDEUtilDEBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSDEUtilDEBase.resetPSDEName();
                return true;
            }
            case 8: {
                pSDEUtilDEBase.resetPSDEUtilDEId();
                return true;
            }
            case 9: {
                pSDEUtilDEBase.resetPSDEUtilDEName();
                return true;
            }
            case 10: {
                pSDEUtilDEBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 11: {
                pSDEUtilDEBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 12: {
                pSDEUtilDEBase.resetPSSysDynaModelId();
                return true;
            }
            case 13: {
                pSDEUtilDEBase.resetPSSysDynaModelName();
                return true;
            }
            case 14: {
                pSDEUtilDEBase.resetPSSysSFPluginId();
                return true;
            }
            case 15: {
                pSDEUtilDEBase.resetPSSysSFPluginName();
                return true;
            }
            case 16: {
                pSDEUtilDEBase.resetUniqueTag();
                return true;
            }
            case 17: {
                pSDEUtilDEBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDEUtilDEBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSDEUtilDEBase.resetUserCat();
                return true;
            }
            case 20: {
                pSDEUtilDEBase.resetUserTag();
                return true;
            }
            case 21: {
                pSDEUtilDEBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSDEUtilDEBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSDEUtilDEBase.resetUserTag4();
                return true;
            }
            case 24: {
                pSDEUtilDEBase.resetUtilObj();
                return true;
            }
            case 25: {
                pSDEUtilDEBase.resetUtilParam();
                return true;
            }
            case 26: {
                pSDEUtilDEBase.resetUtilParam10();
                return true;
            }
            case 27: {
                pSDEUtilDEBase.resetUtilParam11();
                return true;
            }
            case 28: {
                pSDEUtilDEBase.resetUtilParam12();
                return true;
            }
            case 29: {
                pSDEUtilDEBase.resetUtilParam2();
                return true;
            }
            case 30: {
                pSDEUtilDEBase.resetUtilParam3();
                return true;
            }
            case 31: {
                pSDEUtilDEBase.resetUtilParam4();
                return true;
            }
            case 32: {
                pSDEUtilDEBase.resetUtilParam5();
                return true;
            }
            case 33: {
                pSDEUtilDEBase.resetUtilParam6();
                return true;
            }
            case 34: {
                pSDEUtilDEBase.resetUtilParam7();
                return true;
            }
            case 35: {
                pSDEUtilDEBase.resetUtilParam8();
                return true;
            }
            case 36: {
                pSDEUtilDEBase.resetUtilParam9();
                return true;
            }
            case 37: {
                pSDEUtilDEBase.resetUtilParams();
                return true;
            }
            case 38: {
                pSDEUtilDEBase.resetUtilPSDE10Id();
                return true;
            }
            case 39: {
                pSDEUtilDEBase.resetUtilPSDE10Name();
                return true;
            }
            case 40: {
                pSDEUtilDEBase.resetUtilPSDE11Id();
                return true;
            }
            case 41: {
                pSDEUtilDEBase.resetUtilPSDE11Name();
                return true;
            }
            case 42: {
                pSDEUtilDEBase.resetUtilPSDE12Id();
                return true;
            }
            case 43: {
                pSDEUtilDEBase.resetUtilPSDE12Name();
                return true;
            }
            case 44: {
                pSDEUtilDEBase.resetUtilPSDE13Id();
                return true;
            }
            case 45: {
                pSDEUtilDEBase.resetUtilPSDE13Name();
                return true;
            }
            case 46: {
                pSDEUtilDEBase.resetUtilPSDE14Id();
                return true;
            }
            case 47: {
                pSDEUtilDEBase.resetUtilPSDE14Name();
                return true;
            }
            case 48: {
                pSDEUtilDEBase.resetUtilPSDE15Id();
                return true;
            }
            case 49: {
                pSDEUtilDEBase.resetUtilPSDE15Name();
                return true;
            }
            case 50: {
                pSDEUtilDEBase.resetUtilPSDE16Id();
                return true;
            }
            case 51: {
                pSDEUtilDEBase.resetUtilPSDE16Name();
                return true;
            }
            case 52: {
                pSDEUtilDEBase.resetUtilPSDE17Id();
                return true;
            }
            case 53: {
                pSDEUtilDEBase.resetUtilPSDE17Name();
                return true;
            }
            case 54: {
                pSDEUtilDEBase.resetUtilPSDE18Id();
                return true;
            }
            case 55: {
                pSDEUtilDEBase.resetUtilPSDE18Name();
                return true;
            }
            case 56: {
                pSDEUtilDEBase.resetUtilPSDE19Id();
                return true;
            }
            case 57: {
                pSDEUtilDEBase.resetUtilPSDE19Name();
                return true;
            }
            case 58: {
                pSDEUtilDEBase.resetUtilPSDE20Id();
                return true;
            }
            case 59: {
                pSDEUtilDEBase.resetUtilPSDE20Name();
                return true;
            }
            case 60: {
                pSDEUtilDEBase.resetUtilPSDE2Id();
                return true;
            }
            case 61: {
                pSDEUtilDEBase.resetUtilPSDE2Name();
                return true;
            }
            case 62: {
                pSDEUtilDEBase.resetUtilPSDE3Id();
                return true;
            }
            case 63: {
                pSDEUtilDEBase.resetUtilPSDE3Name();
                return true;
            }
            case 64: {
                pSDEUtilDEBase.resetUtilPSDE4Id();
                return true;
            }
            case 65: {
                pSDEUtilDEBase.resetUtilPSDE4Name();
                return true;
            }
            case 66: {
                pSDEUtilDEBase.resetUtilPSDE5Id();
                return true;
            }
            case 67: {
                pSDEUtilDEBase.resetUtilPSDE5Name();
                return true;
            }
            case 68: {
                pSDEUtilDEBase.resetUtilPSDE6Id();
                return true;
            }
            case 69: {
                pSDEUtilDEBase.resetUtilPSDE6Name();
                return true;
            }
            case 70: {
                pSDEUtilDEBase.resetUtilPSDE7Id();
                return true;
            }
            case 71: {
                pSDEUtilDEBase.resetUtilPSDE7Name();
                return true;
            }
            case 72: {
                pSDEUtilDEBase.resetUtilPSDE8Id();
                return true;
            }
            case 73: {
                pSDEUtilDEBase.resetUtilPSDE8Name();
                return true;
            }
            case 74: {
                pSDEUtilDEBase.resetUtilPSDE9Id();
                return true;
            }
            case 75: {
                pSDEUtilDEBase.resetUtilPSDE9Name();
                return true;
            }
            case 76: {
                pSDEUtilDEBase.resetUtilPSDEId();
                return true;
            }
            case 77: {
                pSDEUtilDEBase.resetUtilPSDEName();
                return true;
            }
            case 78: {
                pSDEUtilDEBase.resetUtilTag();
                return true;
            }
            case 79: {
                pSDEUtilDEBase.resetUtilTag2();
                return true;
            }
            case 80: {
                pSDEUtilDEBase.resetUtilType();
                return true;
            }
            case 81: {
                pSDEUtilDEBase.resetValidFlag();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE10() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE10();
        }
        if (this.getUtilPSDE10Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE10Lock;
        synchronized (n) {
            if (this.utilpsde10 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE10Id(), (Object)this.utilpsde10.getPSDataEntityId()) != 0L) {
                this.utilpsde10 = null;
            }
            if (this.utilpsde10 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE10Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde10 = pSDataEntity;
            }
            return this.utilpsde10;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE11() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE11();
        }
        if (this.getUtilPSDE11Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE11Lock;
        synchronized (n) {
            if (this.utilpsde11 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE11Id(), (Object)this.utilpsde11.getPSDataEntityId()) != 0L) {
                this.utilpsde11 = null;
            }
            if (this.utilpsde11 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE11Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde11 = pSDataEntity;
            }
            return this.utilpsde11;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE12() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE12();
        }
        if (this.getUtilPSDE12Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE12Lock;
        synchronized (n) {
            if (this.utilpsde12 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE12Id(), (Object)this.utilpsde12.getPSDataEntityId()) != 0L) {
                this.utilpsde12 = null;
            }
            if (this.utilpsde12 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE12Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde12 = pSDataEntity;
            }
            return this.utilpsde12;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE13() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE13();
        }
        if (this.getUtilPSDE13Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE13Lock;
        synchronized (n) {
            if (this.utilpsde13 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE13Id(), (Object)this.utilpsde13.getPSDataEntityId()) != 0L) {
                this.utilpsde13 = null;
            }
            if (this.utilpsde13 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE13Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde13 = pSDataEntity;
            }
            return this.utilpsde13;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE14() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE14();
        }
        if (this.getUtilPSDE14Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE14Lock;
        synchronized (n) {
            if (this.utilpsde14 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE14Id(), (Object)this.utilpsde14.getPSDataEntityId()) != 0L) {
                this.utilpsde14 = null;
            }
            if (this.utilpsde14 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE14Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde14 = pSDataEntity;
            }
            return this.utilpsde14;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE15() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE15();
        }
        if (this.getUtilPSDE15Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE15Lock;
        synchronized (n) {
            if (this.utilpsde15 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE15Id(), (Object)this.utilpsde15.getPSDataEntityId()) != 0L) {
                this.utilpsde15 = null;
            }
            if (this.utilpsde15 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE15Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde15 = pSDataEntity;
            }
            return this.utilpsde15;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE16() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE16();
        }
        if (this.getUtilPSDE16Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE16Lock;
        synchronized (n) {
            if (this.utilpsde16 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE16Id(), (Object)this.utilpsde16.getPSDataEntityId()) != 0L) {
                this.utilpsde16 = null;
            }
            if (this.utilpsde16 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE16Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde16 = pSDataEntity;
            }
            return this.utilpsde16;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE17() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE17();
        }
        if (this.getUtilPSDE17Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE17Lock;
        synchronized (n) {
            if (this.utilpsde17 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE17Id(), (Object)this.utilpsde17.getPSDataEntityId()) != 0L) {
                this.utilpsde17 = null;
            }
            if (this.utilpsde17 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE17Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde17 = pSDataEntity;
            }
            return this.utilpsde17;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE18() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE18();
        }
        if (this.getUtilPSDE18Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE18Lock;
        synchronized (n) {
            if (this.utilpsde18 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE18Id(), (Object)this.utilpsde18.getPSDataEntityId()) != 0L) {
                this.utilpsde18 = null;
            }
            if (this.utilpsde18 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE18Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde18 = pSDataEntity;
            }
            return this.utilpsde18;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE19() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE19();
        }
        if (this.getUtilPSDE19Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE19Lock;
        synchronized (n) {
            if (this.utilpsde19 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE19Id(), (Object)this.utilpsde19.getPSDataEntityId()) != 0L) {
                this.utilpsde19 = null;
            }
            if (this.utilpsde19 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE19Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde19 = pSDataEntity;
            }
            return this.utilpsde19;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getUtilPSDE20() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDE20();
        }
        if (this.getUtilPSDE20Id() == null) {
            return null;
        }
        Integer n = this.objUtilPSDE20Lock;
        synchronized (n) {
            if (this.utilpsde20 != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDE20Id(), (Object)this.utilpsde20.getPSDataEntityId()) != 0L) {
                this.utilpsde20 = null;
            }
            if (this.utilpsde20 == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getUtilPSDE20Id());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde20 = pSDataEntity;
            }
            return this.utilpsde20;
        }
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.utilpsde = pSDataEntity;
            }
            return this.utilpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPI();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysServiceAPILock;
        synchronized (n) {
            if (this.pssubsysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysServiceAPIId(), (Object)this.pssubsysserviceapi.getPSSubSysServiceAPIId()) != 0L) {
                this.pssubsysserviceapi = null;
            }
            if (this.pssubsysserviceapi == null) {
                PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
                pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.getPSSubSysServiceAPIId());
                PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysServiceAPIService.autoGet((IEntity)pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    private PSDEUtilDEBase getProxyEntity() {
        return this.proxyPSDEUtilDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUtilDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUtilDEBase) {
            this.proxyPSDEUtilDEBase = (PSDEUtilDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EXTENDMODE, 3);
        fieldIndexMap.put(FIELD_LOCKFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDENAME, 7);
        fieldIndexMap.put(FIELD_PSDEUTILDEID, 8);
        fieldIndexMap.put(FIELD_PSDEUTILDENAME, 9);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 10);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 11);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 12);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 14);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 15);
        fieldIndexMap.put(FIELD_UNIQUETAG, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
        fieldIndexMap.put(FIELD_UTILOBJ, 24);
        fieldIndexMap.put(FIELD_UTILPARAM, 25);
        fieldIndexMap.put(FIELD_UTILPARAM10, 26);
        fieldIndexMap.put(FIELD_UTILPARAM11, 27);
        fieldIndexMap.put(FIELD_UTILPARAM12, 28);
        fieldIndexMap.put(FIELD_UTILPARAM2, 29);
        fieldIndexMap.put(FIELD_UTILPARAM3, 30);
        fieldIndexMap.put(FIELD_UTILPARAM4, 31);
        fieldIndexMap.put(FIELD_UTILPARAM5, 32);
        fieldIndexMap.put(FIELD_UTILPARAM6, 33);
        fieldIndexMap.put(FIELD_UTILPARAM7, 34);
        fieldIndexMap.put(FIELD_UTILPARAM8, 35);
        fieldIndexMap.put(FIELD_UTILPARAM9, 36);
        fieldIndexMap.put(FIELD_UTILPARAMS, 37);
        fieldIndexMap.put(FIELD_UTILPSDE10ID, 38);
        fieldIndexMap.put(FIELD_UTILPSDE10NAME, 39);
        fieldIndexMap.put(FIELD_UTILPSDE11ID, 40);
        fieldIndexMap.put(FIELD_UTILPSDE11NAME, 41);
        fieldIndexMap.put(FIELD_UTILPSDE12ID, 42);
        fieldIndexMap.put(FIELD_UTILPSDE12NAME, 43);
        fieldIndexMap.put(FIELD_UTILPSDE13ID, 44);
        fieldIndexMap.put(FIELD_UTILPSDE13NAME, 45);
        fieldIndexMap.put(FIELD_UTILPSDE14ID, 46);
        fieldIndexMap.put(FIELD_UTILPSDE14NAME, 47);
        fieldIndexMap.put(FIELD_UTILPSDE15ID, 48);
        fieldIndexMap.put(FIELD_UTILPSDE15NAME, 49);
        fieldIndexMap.put(FIELD_UTILPSDE16ID, 50);
        fieldIndexMap.put(FIELD_UTILPSDE16NAME, 51);
        fieldIndexMap.put(FIELD_UTILPSDE17ID, 52);
        fieldIndexMap.put(FIELD_UTILPSDE17NAME, 53);
        fieldIndexMap.put(FIELD_UTILPSDE18ID, 54);
        fieldIndexMap.put(FIELD_UTILPSDE18NAME, 55);
        fieldIndexMap.put(FIELD_UTILPSDE19ID, 56);
        fieldIndexMap.put(FIELD_UTILPSDE19NAME, 57);
        fieldIndexMap.put(FIELD_UTILPSDE20ID, 58);
        fieldIndexMap.put(FIELD_UTILPSDE20NAME, 59);
        fieldIndexMap.put(FIELD_UTILPSDE2ID, 60);
        fieldIndexMap.put(FIELD_UTILPSDE2NAME, 61);
        fieldIndexMap.put(FIELD_UTILPSDE3ID, 62);
        fieldIndexMap.put(FIELD_UTILPSDE3NAME, 63);
        fieldIndexMap.put(FIELD_UTILPSDE4ID, 64);
        fieldIndexMap.put(FIELD_UTILPSDE4NAME, 65);
        fieldIndexMap.put(FIELD_UTILPSDE5ID, 66);
        fieldIndexMap.put(FIELD_UTILPSDE5NAME, 67);
        fieldIndexMap.put(FIELD_UTILPSDE6ID, 68);
        fieldIndexMap.put(FIELD_UTILPSDE6NAME, 69);
        fieldIndexMap.put(FIELD_UTILPSDE7ID, 70);
        fieldIndexMap.put(FIELD_UTILPSDE7NAME, 71);
        fieldIndexMap.put(FIELD_UTILPSDE8ID, 72);
        fieldIndexMap.put(FIELD_UTILPSDE8NAME, 73);
        fieldIndexMap.put(FIELD_UTILPSDE9ID, 74);
        fieldIndexMap.put(FIELD_UTILPSDE9NAME, 75);
        fieldIndexMap.put(FIELD_UTILPSDEID, 76);
        fieldIndexMap.put(FIELD_UTILPSDENAME, 77);
        fieldIndexMap.put(FIELD_UTILTAG, 78);
        fieldIndexMap.put(FIELD_UTILTAG2, 79);
        fieldIndexMap.put(FIELD_UTILTYPE, 80);
        fieldIndexMap.put(FIELD_VALIDFLAG, 81);
    }
}

