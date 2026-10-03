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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineType;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSUIEngineTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewEngineBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewEngineBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVIEWCTRLFLAG = "DEVIEWCTRLFLAG";
    public static final String FIELD_DEVIEWCTRLLABEL = "DEVIEWCTRLLABEL";
    public static final String FIELD_DEVIEWLOGICFLAG = "DEVIEWLOGICFLAG";
    public static final String FIELD_DEVIEWLOGICLABEL = "DEVIEWLOGICLABEL";
    public static final String FIELD_ENGINEOPTION = "ENGINEOPTION";
    public static final String FIELD_ENGINEPARAM = "ENGINEPARAM";
    public static final String FIELD_ENGINEPARAM10 = "ENGINEPARAM10";
    public static final String FIELD_ENGINEPARAM10FLAG = "ENGINEPARAM10FLAG";
    public static final String FIELD_ENGINEPARAM10LABEL = "ENGINEPARAM10LABEL";
    public static final String FIELD_ENGINEPARAM2 = "ENGINEPARAM2";
    public static final String FIELD_ENGINEPARAM2FLAG = "ENGINEPARAM2FLAG";
    public static final String FIELD_ENGINEPARAM2LABEL = "ENGINEPARAM2LABEL";
    public static final String FIELD_ENGINEPARAM3 = "ENGINEPARAM3";
    public static final String FIELD_ENGINEPARAM3FLAG = "ENGINEPARAM3FLAG";
    public static final String FIELD_ENGINEPARAM3LABEL = "ENGINEPARAM3LABEL";
    public static final String FIELD_ENGINEPARAM4 = "ENGINEPARAM4";
    public static final String FIELD_ENGINEPARAM4FLAG = "ENGINEPARAM4FLAG";
    public static final String FIELD_ENGINEPARAM4LABEL = "ENGINEPARAM4LABEL";
    public static final String FIELD_ENGINEPARAM5 = "ENGINEPARAM5";
    public static final String FIELD_ENGINEPARAM5FLAG = "ENGINEPARAM5FLAG";
    public static final String FIELD_ENGINEPARAM5LABEL = "ENGINEPARAM5LABEL";
    public static final String FIELD_ENGINEPARAM6 = "ENGINEPARAM6";
    public static final String FIELD_ENGINEPARAM6FLAG = "ENGINEPARAM6FLAG";
    public static final String FIELD_ENGINEPARAM6LABEL = "ENGINEPARAM6LABEL";
    public static final String FIELD_ENGINEPARAM7 = "ENGINEPARAM7";
    public static final String FIELD_ENGINEPARAM7FLAG = "ENGINEPARAM7FLAG";
    public static final String FIELD_ENGINEPARAM7LABEL = "ENGINEPARAM7LABEL";
    public static final String FIELD_ENGINEPARAM8 = "ENGINEPARAM8";
    public static final String FIELD_ENGINEPARAM8FLAG = "ENGINEPARAM8FLAG";
    public static final String FIELD_ENGINEPARAM8LABEL = "ENGINEPARAM8LABEL";
    public static final String FIELD_ENGINEPARAM9 = "ENGINEPARAM9";
    public static final String FIELD_ENGINEPARAM9FLAG = "ENGINEPARAM9FLAG";
    public static final String FIELD_ENGINEPARAM9LABEL = "ENGINEPARAM9LABEL";
    public static final String FIELD_ENGINEPARAMFLAG = "ENGINEPARAMFLAG";
    public static final String FIELD_ENGINEPARAMLABEL = "ENGINEPARAMLABEL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NO2DEVIEWCTRLFLAG = "NO2DEVIEWCTRLFLAG";
    public static final String FIELD_NO2DEVIEWCTRLLABEL = "NO2DEVIEWCTRLLABEL";
    public static final String FIELD_NO2DEVIEWLOGICFLAG = "NO2DEVIEWLOGICFLAG";
    public static final String FIELD_NO2DEVIEWLOGICLABEL = "NO2DEVIEWLOGICLABEL";
    public static final String FIELD_NO2PSDEVIEWCTRLID = "NO2PSDEVIEWCTRLID";
    public static final String FIELD_NO2PSDEVIEWCTRLNAME = "NO2PSDEVIEWCTRLNAME";
    public static final String FIELD_NO2PSDEVIEWLOGICID = "NO2PSDEVIEWLOGICID";
    public static final String FIELD_NO2PSDEVIEWLOGICNAME = "NO2PSDEVIEWLOGICNAME";
    public static final String FIELD_NO3DEVIEWCTRLFLAG = "NO3DEVIEWCTRLFLAG";
    public static final String FIELD_NO3DEVIEWCTRLLABEL = "NO3DEVIEWCTRLLABEL";
    public static final String FIELD_NO3DEVIEWLOGICFLAG = "NO3DEVIEWLOGICFLAG";
    public static final String FIELD_NO3DEVIEWLOGICLABEL = "NO3DEVIEWLOGICLABEL";
    public static final String FIELD_NO3PSDEVIEWCTRLID = "NO3PSDEVIEWCTRLID";
    public static final String FIELD_NO3PSDEVIEWCTRLNAME = "NO3PSDEVIEWCTRLNAME";
    public static final String FIELD_NO3PSDEVIEWLOGICID = "NO3PSDEVIEWLOGICID";
    public static final String FIELD_NO3PSDEVIEWLOGICNAME = "NO3PSDEVIEWLOGICNAME";
    public static final String FIELD_NO4DEVIEWCTRLFLAG = "NO4DEVIEWCTRLFLAG";
    public static final String FIELD_NO4DEVIEWCTRLLABEL = "NO4DEVIEWCTRLLABEL";
    public static final String FIELD_NO4DEVIEWLOGICFLAG = "NO4DEVIEWLOGICFLAG";
    public static final String FIELD_NO4DEVIEWLOGICLABEL = "NO4DEVIEWLOGICLABEL";
    public static final String FIELD_NO4PSDEVIEWCTRLID = "NO4PSDEVIEWCTRLID";
    public static final String FIELD_NO4PSDEVIEWCTRLNAME = "NO4PSDEVIEWCTRLNAME";
    public static final String FIELD_NO4PSDEVIEWLOGICID = "NO4PSDEVIEWLOGICID";
    public static final String FIELD_NO4PSDEVIEWLOGICNAME = "NO4PSDEVIEWLOGICNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWCTRLID = "PSDEVIEWCTRLID";
    public static final String FIELD_PSDEVIEWCTRLNAME = "PSDEVIEWCTRLNAME";
    public static final String FIELD_PSDEVIEWENGINEID = "PSDEVIEWENGINEID";
    public static final String FIELD_PSDEVIEWENGINENAME = "PSDEVIEWENGINENAME";
    public static final String FIELD_PSDEVIEWLOGICID = "PSDEVIEWLOGICID";
    public static final String FIELD_PSDEVIEWLOGICNAME = "PSDEVIEWLOGICNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSUIENGINETYPEID = "PSUIENGINETYPEID";
    public static final String FIELD_PSUIENGINETYPENAME = "PSUIENGINETYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWPARAM = "VIEWPARAM";
    public static final String FIELD_VIEWPARAM10 = "VIEWPARAM10";
    public static final String FIELD_VIEWPARAM2 = "VIEWPARAM2";
    public static final String FIELD_VIEWPARAM3 = "VIEWPARAM3";
    public static final String FIELD_VIEWPARAM4 = "VIEWPARAM4";
    public static final String FIELD_VIEWPARAM5 = "VIEWPARAM5";
    public static final String FIELD_VIEWPARAM6 = "VIEWPARAM6";
    public static final String FIELD_VIEWPARAM7 = "VIEWPARAM7";
    public static final String FIELD_VIEWPARAM8 = "VIEWPARAM8";
    public static final String FIELD_VIEWPARAM9 = "VIEWPARAM9";
    public static final String FIELD_WFVIEWPARAM = "WFVIEWPARAM";
    public static final String FIELD_WFVIEWPARAM2 = "WFVIEWPARAM2";
    public static final String FIELD_WFVIEWPARAM3 = "WFVIEWPARAM3";
    public static final String FIELD_WFVIEWPARAM4 = "WFVIEWPARAM4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEVIEWCTRLFLAG = 2;
    private static final int INDEX_DEVIEWCTRLLABEL = 3;
    private static final int INDEX_DEVIEWLOGICFLAG = 4;
    private static final int INDEX_DEVIEWLOGICLABEL = 5;
    private static final int INDEX_ENGINEOPTION = 6;
    private static final int INDEX_ENGINEPARAM = 7;
    private static final int INDEX_ENGINEPARAM10 = 8;
    private static final int INDEX_ENGINEPARAM10FLAG = 9;
    private static final int INDEX_ENGINEPARAM10LABEL = 10;
    private static final int INDEX_ENGINEPARAM2 = 11;
    private static final int INDEX_ENGINEPARAM2FLAG = 12;
    private static final int INDEX_ENGINEPARAM2LABEL = 13;
    private static final int INDEX_ENGINEPARAM3 = 14;
    private static final int INDEX_ENGINEPARAM3FLAG = 15;
    private static final int INDEX_ENGINEPARAM3LABEL = 16;
    private static final int INDEX_ENGINEPARAM4 = 17;
    private static final int INDEX_ENGINEPARAM4FLAG = 18;
    private static final int INDEX_ENGINEPARAM4LABEL = 19;
    private static final int INDEX_ENGINEPARAM5 = 20;
    private static final int INDEX_ENGINEPARAM5FLAG = 21;
    private static final int INDEX_ENGINEPARAM5LABEL = 22;
    private static final int INDEX_ENGINEPARAM6 = 23;
    private static final int INDEX_ENGINEPARAM6FLAG = 24;
    private static final int INDEX_ENGINEPARAM6LABEL = 25;
    private static final int INDEX_ENGINEPARAM7 = 26;
    private static final int INDEX_ENGINEPARAM7FLAG = 27;
    private static final int INDEX_ENGINEPARAM7LABEL = 28;
    private static final int INDEX_ENGINEPARAM8 = 29;
    private static final int INDEX_ENGINEPARAM8FLAG = 30;
    private static final int INDEX_ENGINEPARAM8LABEL = 31;
    private static final int INDEX_ENGINEPARAM9 = 32;
    private static final int INDEX_ENGINEPARAM9FLAG = 33;
    private static final int INDEX_ENGINEPARAM9LABEL = 34;
    private static final int INDEX_ENGINEPARAMFLAG = 35;
    private static final int INDEX_ENGINEPARAMLABEL = 36;
    private static final int INDEX_MEMO = 37;
    private static final int INDEX_NO2DEVIEWCTRLFLAG = 38;
    private static final int INDEX_NO2DEVIEWCTRLLABEL = 39;
    private static final int INDEX_NO2DEVIEWLOGICFLAG = 40;
    private static final int INDEX_NO2DEVIEWLOGICLABEL = 41;
    private static final int INDEX_NO2PSDEVIEWCTRLID = 42;
    private static final int INDEX_NO2PSDEVIEWCTRLNAME = 43;
    private static final int INDEX_NO2PSDEVIEWLOGICID = 44;
    private static final int INDEX_NO2PSDEVIEWLOGICNAME = 45;
    private static final int INDEX_NO3DEVIEWCTRLFLAG = 46;
    private static final int INDEX_NO3DEVIEWCTRLLABEL = 47;
    private static final int INDEX_NO3DEVIEWLOGICFLAG = 48;
    private static final int INDEX_NO3DEVIEWLOGICLABEL = 49;
    private static final int INDEX_NO3PSDEVIEWCTRLID = 50;
    private static final int INDEX_NO3PSDEVIEWCTRLNAME = 51;
    private static final int INDEX_NO3PSDEVIEWLOGICID = 52;
    private static final int INDEX_NO3PSDEVIEWLOGICNAME = 53;
    private static final int INDEX_NO4DEVIEWCTRLFLAG = 54;
    private static final int INDEX_NO4DEVIEWCTRLLABEL = 55;
    private static final int INDEX_NO4DEVIEWLOGICFLAG = 56;
    private static final int INDEX_NO4DEVIEWLOGICLABEL = 57;
    private static final int INDEX_NO4PSDEVIEWCTRLID = 58;
    private static final int INDEX_NO4PSDEVIEWCTRLNAME = 59;
    private static final int INDEX_NO4PSDEVIEWLOGICID = 60;
    private static final int INDEX_NO4PSDEVIEWLOGICNAME = 61;
    private static final int INDEX_ORDERVALUE = 62;
    private static final int INDEX_PSDEVIEWBASEID = 63;
    private static final int INDEX_PSDEVIEWBASENAME = 64;
    private static final int INDEX_PSDEVIEWCTRLID = 65;
    private static final int INDEX_PSDEVIEWCTRLNAME = 66;
    private static final int INDEX_PSDEVIEWENGINEID = 67;
    private static final int INDEX_PSDEVIEWENGINENAME = 68;
    private static final int INDEX_PSDEVIEWLOGICID = 69;
    private static final int INDEX_PSDEVIEWLOGICNAME = 70;
    private static final int INDEX_PSSYSPFPLUGINID = 71;
    private static final int INDEX_PSSYSPFPLUGINNAME = 72;
    private static final int INDEX_PSUIENGINETYPEID = 73;
    private static final int INDEX_PSUIENGINETYPENAME = 74;
    private static final int INDEX_UPDATEDATE = 75;
    private static final int INDEX_UPDATEMAN = 76;
    private static final int INDEX_USERCAT = 77;
    private static final int INDEX_USERTAG = 78;
    private static final int INDEX_USERTAG2 = 79;
    private static final int INDEX_USERTAG3 = 80;
    private static final int INDEX_USERTAG4 = 81;
    private static final int INDEX_VALIDFLAG = 82;
    private static final int INDEX_VIEWPARAM = 83;
    private static final int INDEX_VIEWPARAM10 = 84;
    private static final int INDEX_VIEWPARAM2 = 85;
    private static final int INDEX_VIEWPARAM3 = 86;
    private static final int INDEX_VIEWPARAM4 = 87;
    private static final int INDEX_VIEWPARAM5 = 88;
    private static final int INDEX_VIEWPARAM6 = 89;
    private static final int INDEX_VIEWPARAM7 = 90;
    private static final int INDEX_VIEWPARAM8 = 91;
    private static final int INDEX_VIEWPARAM9 = 92;
    private static final int INDEX_WFVIEWPARAM = 93;
    private static final int INDEX_WFVIEWPARAM2 = 94;
    private static final int INDEX_WFVIEWPARAM3 = 95;
    private static final int INDEX_WFVIEWPARAM4 = 96;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewEngineBase proxyPSDEViewEngineBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deviewctrlflagDirtyFlag = false;
    private boolean deviewctrllabelDirtyFlag = false;
    private boolean deviewlogicflagDirtyFlag = false;
    private boolean deviewlogiclabelDirtyFlag = false;
    private boolean engineoptionDirtyFlag = false;
    private boolean engineparamDirtyFlag = false;
    private boolean engineparam10DirtyFlag = false;
    private boolean engineparam10flagDirtyFlag = false;
    private boolean engineparam10labelDirtyFlag = false;
    private boolean engineparam2DirtyFlag = false;
    private boolean engineparam2flagDirtyFlag = false;
    private boolean engineparam2labelDirtyFlag = false;
    private boolean engineparam3DirtyFlag = false;
    private boolean engineparam3flagDirtyFlag = false;
    private boolean engineparam3labelDirtyFlag = false;
    private boolean engineparam4DirtyFlag = false;
    private boolean engineparam4flagDirtyFlag = false;
    private boolean engineparam4labelDirtyFlag = false;
    private boolean engineparam5DirtyFlag = false;
    private boolean engineparam5flagDirtyFlag = false;
    private boolean engineparam5labelDirtyFlag = false;
    private boolean engineparam6DirtyFlag = false;
    private boolean engineparam6flagDirtyFlag = false;
    private boolean engineparam6labelDirtyFlag = false;
    private boolean engineparam7DirtyFlag = false;
    private boolean engineparam7flagDirtyFlag = false;
    private boolean engineparam7labelDirtyFlag = false;
    private boolean engineparam8DirtyFlag = false;
    private boolean engineparam8flagDirtyFlag = false;
    private boolean engineparam8labelDirtyFlag = false;
    private boolean engineparam9DirtyFlag = false;
    private boolean engineparam9flagDirtyFlag = false;
    private boolean engineparam9labelDirtyFlag = false;
    private boolean engineparamflagDirtyFlag = false;
    private boolean engineparamlabelDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean no2deviewctrlflagDirtyFlag = false;
    private boolean no2deviewctrllabelDirtyFlag = false;
    private boolean no2deviewlogicflagDirtyFlag = false;
    private boolean no2deviewlogiclabelDirtyFlag = false;
    private boolean no2psdeviewctrlidDirtyFlag = false;
    private boolean no2psdeviewctrlnameDirtyFlag = false;
    private boolean no2psdeviewlogicidDirtyFlag = false;
    private boolean no2psdeviewlogicnameDirtyFlag = false;
    private boolean no3deviewctrlflagDirtyFlag = false;
    private boolean no3deviewctrllabelDirtyFlag = false;
    private boolean no3deviewlogicflagDirtyFlag = false;
    private boolean no3deviewlogiclabelDirtyFlag = false;
    private boolean no3psdeviewctrlidDirtyFlag = false;
    private boolean no3psdeviewctrlnameDirtyFlag = false;
    private boolean no3psdeviewlogicidDirtyFlag = false;
    private boolean no3psdeviewlogicnameDirtyFlag = false;
    private boolean no4deviewctrlflagDirtyFlag = false;
    private boolean no4deviewctrllabelDirtyFlag = false;
    private boolean no4deviewlogicflagDirtyFlag = false;
    private boolean no4deviewlogiclabelDirtyFlag = false;
    private boolean no4psdeviewctrlidDirtyFlag = false;
    private boolean no4psdeviewctrlnameDirtyFlag = false;
    private boolean no4psdeviewlogicidDirtyFlag = false;
    private boolean no4psdeviewlogicnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewctrlidDirtyFlag = false;
    private boolean psdeviewctrlnameDirtyFlag = false;
    private boolean psdeviewengineidDirtyFlag = false;
    private boolean psdeviewenginenameDirtyFlag = false;
    private boolean psdeviewlogicidDirtyFlag = false;
    private boolean psdeviewlogicnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean psuienginetypeidDirtyFlag = false;
    private boolean psuienginetypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewparamDirtyFlag = false;
    private boolean viewparam10DirtyFlag = false;
    private boolean viewparam2DirtyFlag = false;
    private boolean viewparam3DirtyFlag = false;
    private boolean viewparam4DirtyFlag = false;
    private boolean viewparam5DirtyFlag = false;
    private boolean viewparam6DirtyFlag = false;
    private boolean viewparam7DirtyFlag = false;
    private boolean viewparam8DirtyFlag = false;
    private boolean viewparam9DirtyFlag = false;
    private boolean wfviewparamDirtyFlag = false;
    private boolean wfviewparam2DirtyFlag = false;
    private boolean wfviewparam3DirtyFlag = false;
    private boolean wfviewparam4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deviewctrlflag")
    private Integer deviewctrlflag;
    @Column(name="deviewctrllabel")
    private String deviewctrllabel;
    @Column(name="deviewlogicflag")
    private Integer deviewlogicflag;
    @Column(name="deviewlogiclabel")
    private String deviewlogiclabel;
    @Column(name="engineoption")
    private String engineoption;
    @Column(name="engineparam")
    private String engineparam;
    @Column(name="engineparam10")
    private Integer engineparam10;
    @Column(name="engineparam10flag")
    private Integer engineparam10flag;
    @Column(name="engineparam10label")
    private String engineparam10label;
    @Column(name="engineparam2")
    private String engineparam2;
    @Column(name="engineparam2flag")
    private Integer engineparam2flag;
    @Column(name="engineparam2label")
    private String engineparam2label;
    @Column(name="engineparam3")
    private String engineparam3;
    @Column(name="engineparam3flag")
    private Integer engineparam3flag;
    @Column(name="engineparam3label")
    private String engineparam3label;
    @Column(name="engineparam4")
    private String engineparam4;
    @Column(name="engineparam4flag")
    private Integer engineparam4flag;
    @Column(name="engineparam4label")
    private String engineparam4label;
    @Column(name="engineparam5")
    private Integer engineparam5;
    @Column(name="engineparam5flag")
    private Integer engineparam5flag;
    @Column(name="engineparam5label")
    private String engineparam5label;
    @Column(name="engineparam6")
    private Integer engineparam6;
    @Column(name="engineparam6flag")
    private Integer engineparam6flag;
    @Column(name="engineparam6label")
    private String engineparam6label;
    @Column(name="engineparam7")
    private Integer engineparam7;
    @Column(name="engineparam7flag")
    private Integer engineparam7flag;
    @Column(name="engineparam7label")
    private String engineparam7label;
    @Column(name="engineparam8")
    private Integer engineparam8;
    @Column(name="engineparam8flag")
    private Integer engineparam8flag;
    @Column(name="engineparam8label")
    private String engineparam8label;
    @Column(name="engineparam9")
    private Integer engineparam9;
    @Column(name="engineparam9flag")
    private Integer engineparam9flag;
    @Column(name="engineparam9label")
    private String engineparam9label;
    @Column(name="engineparamflag")
    private Integer engineparamflag;
    @Column(name="engineparamlabel")
    private String engineparamlabel;
    @Column(name="memo")
    private String memo;
    @Column(name="no2deviewctrlflag")
    private Integer no2deviewctrlflag;
    @Column(name="no2deviewctrllabel")
    private String no2deviewctrllabel;
    @Column(name="no2deviewlogicflag")
    private Integer no2deviewlogicflag;
    @Column(name="no2deviewlogiclabel")
    private String no2deviewlogiclabel;
    @Column(name="no2psdeviewctrlid")
    private String no2psdeviewctrlid;
    @Column(name="no2psdeviewctrlname")
    private String no2psdeviewctrlname;
    @Column(name="no2psdeviewlogicid")
    private String no2psdeviewlogicid;
    @Column(name="no2psdeviewlogicname")
    private String no2psdeviewlogicname;
    @Column(name="no3deviewctrlflag")
    private Integer no3deviewctrlflag;
    @Column(name="no3deviewctrllabel")
    private String no3deviewctrllabel;
    @Column(name="no3deviewlogicflag")
    private Integer no3deviewlogicflag;
    @Column(name="no3deviewlogiclabel")
    private String no3deviewlogiclabel;
    @Column(name="no3psdeviewctrlid")
    private String no3psdeviewctrlid;
    @Column(name="no3psdeviewctrlname")
    private String no3psdeviewctrlname;
    @Column(name="no3psdeviewlogicid")
    private String no3psdeviewlogicid;
    @Column(name="no3psdeviewlogicname")
    private String no3psdeviewlogicname;
    @Column(name="no4deviewctrlflag")
    private Integer no4deviewctrlflag;
    @Column(name="no4deviewctrllabel")
    private String no4deviewctrllabel;
    @Column(name="no4deviewlogicflag")
    private Integer no4deviewlogicflag;
    @Column(name="no4deviewlogiclabel")
    private String no4deviewlogiclabel;
    @Column(name="no4psdeviewctrlid")
    private String no4psdeviewctrlid;
    @Column(name="no4psdeviewctrlname")
    private String no4psdeviewctrlname;
    @Column(name="no4psdeviewlogicid")
    private String no4psdeviewlogicid;
    @Column(name="no4psdeviewlogicname")
    private String no4psdeviewlogicname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewctrlid")
    private String psdeviewctrlid;
    @Column(name="psdeviewctrlname")
    private String psdeviewctrlname;
    @Column(name="psdeviewengineid")
    private String psdeviewengineid;
    @Column(name="psdeviewenginename")
    private String psdeviewenginename;
    @Column(name="psdeviewlogicid")
    private String psdeviewlogicid;
    @Column(name="psdeviewlogicname")
    private String psdeviewlogicname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="psuienginetypeid")
    private String psuienginetypeid;
    @Column(name="psuienginetypename")
    private String psuienginetypename;
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
    @Column(name="viewparam")
    private String viewparam;
    @Column(name="viewparam10")
    private Integer viewparam10;
    @Column(name="viewparam2")
    private String viewparam2;
    @Column(name="viewparam3")
    private Integer viewparam3;
    @Column(name="viewparam4")
    private Integer viewparam4;
    @Column(name="viewparam5")
    private Integer viewparam5;
    @Column(name="viewparam6")
    private Integer viewparam6;
    @Column(name="viewparam7")
    private String viewparam7;
    @Column(name="viewparam8")
    private String viewparam8;
    @Column(name="viewparam9")
    private Integer viewparam9;
    @Column(name="wfviewparam")
    private Integer wfviewparam;
    @Column(name="wfviewparam2")
    private Integer wfviewparam2;
    @Column(name="wfviewparam3")
    private String wfviewparam3;
    @Column(name="wfviewparam4")
    private String wfviewparam4;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objNo2PSDEViewCtrlLock = new Integer(1);
    private PSDEViewCtrl no2psdeviewctrl = null;
    private Integer objNo3PSDEViewCtrlLock = new Integer(1);
    private PSDEViewCtrl no3psdeviewctrl = null;
    private Integer objNo4PSDEViewCtrlLock = new Integer(1);
    private PSDEViewCtrl no4psdeviewctrl = null;
    private Integer objPSDEViewCtrlLock = new Integer(1);
    private PSDEViewCtrl psdeviewctrl = null;
    private Integer objNo2PSDEViewLogicLock = new Integer(1);
    private PSDEViewLogic no2psdeviewlogic = null;
    private Integer objNo3PSDEViewLogicLock = new Integer(1);
    private PSDEViewLogic no3psdeviewlogic = null;
    private Integer objNo4PSDEViewLogicLock = new Integer(1);
    private PSDEViewLogic no4psdeviewlogic = null;
    private Integer objPSDEViewLogicLock = new Integer(1);
    private PSDEViewLogic psdeviewlogic = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSUIEngineTypeLock = new Integer(1);
    private PSUIEngineType psuienginetype = null;

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

    public void setDEViewCtrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewCtrlFlag(n);
            return;
        }
        this.deviewctrlflag = n;
        this.deviewctrlflagDirtyFlag = true;
    }

    public Integer getDEViewCtrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewCtrlFlag();
        }
        return this.deviewctrlflag;
    }

    public boolean isDEViewCtrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewCtrlFlagDirty();
        }
        return this.deviewctrlflagDirtyFlag;
    }

    public void resetDEViewCtrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewCtrlFlag();
            return;
        }
        this.deviewctrlflagDirtyFlag = false;
        this.deviewctrlflag = null;
    }

    public void setDEViewCtrlLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewCtrlLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deviewctrllabel = string;
        this.deviewctrllabelDirtyFlag = true;
    }

    public String getDEViewCtrlLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewCtrlLabel();
        }
        return this.deviewctrllabel;
    }

    public boolean isDEViewCtrlLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewCtrlLabelDirty();
        }
        return this.deviewctrllabelDirtyFlag;
    }

    public void resetDEViewCtrlLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewCtrlLabel();
            return;
        }
        this.deviewctrllabelDirtyFlag = false;
        this.deviewctrllabel = null;
    }

    public void setDEViewLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewLogicFlag(n);
            return;
        }
        this.deviewlogicflag = n;
        this.deviewlogicflagDirtyFlag = true;
    }

    public Integer getDEViewLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewLogicFlag();
        }
        return this.deviewlogicflag;
    }

    public boolean isDEViewLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewLogicFlagDirty();
        }
        return this.deviewlogicflagDirtyFlag;
    }

    public void resetDEViewLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewLogicFlag();
            return;
        }
        this.deviewlogicflagDirtyFlag = false;
        this.deviewlogicflag = null;
    }

    public void setDEViewLogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewLogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deviewlogiclabel = string;
        this.deviewlogiclabelDirtyFlag = true;
    }

    public String getDEViewLogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewLogicLabel();
        }
        return this.deviewlogiclabel;
    }

    public boolean isDEViewLogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewLogicLabelDirty();
        }
        return this.deviewlogiclabelDirtyFlag;
    }

    public void resetDEViewLogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewLogicLabel();
            return;
        }
        this.deviewlogiclabelDirtyFlag = false;
        this.deviewlogiclabel = null;
    }

    public void setEngineOption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineOption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineoption = string;
        this.engineoptionDirtyFlag = true;
    }

    public String getEngineOption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineOption();
        }
        return this.engineoption;
    }

    public boolean isEngineOptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineOptionDirty();
        }
        return this.engineoptionDirtyFlag;
    }

    public void resetEngineOption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineOption();
            return;
        }
        this.engineoptionDirtyFlag = false;
        this.engineoption = null;
    }

    public void setEngineParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam = string;
        this.engineparamDirtyFlag = true;
    }

    public String getEngineParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam();
        }
        return this.engineparam;
    }

    public boolean isEngineParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParamDirty();
        }
        return this.engineparamDirtyFlag;
    }

    public void resetEngineParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam();
            return;
        }
        this.engineparamDirtyFlag = false;
        this.engineparam = null;
    }

    public void setEngineParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam10(n);
            return;
        }
        this.engineparam10 = n;
        this.engineparam10DirtyFlag = true;
    }

    public Integer getEngineParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam10();
        }
        return this.engineparam10;
    }

    public boolean isEngineParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam10Dirty();
        }
        return this.engineparam10DirtyFlag;
    }

    public void resetEngineParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam10();
            return;
        }
        this.engineparam10DirtyFlag = false;
        this.engineparam10 = null;
    }

    public void setEngineParam10Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam10Flag(n);
            return;
        }
        this.engineparam10flag = n;
        this.engineparam10flagDirtyFlag = true;
    }

    public Integer getEngineParam10Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam10Flag();
        }
        return this.engineparam10flag;
    }

    public boolean isEngineParam10FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam10FlagDirty();
        }
        return this.engineparam10flagDirtyFlag;
    }

    public void resetEngineParam10Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam10Flag();
            return;
        }
        this.engineparam10flagDirtyFlag = false;
        this.engineparam10flag = null;
    }

    public void setEngineParam10Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam10Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam10label = string;
        this.engineparam10labelDirtyFlag = true;
    }

    public String getEngineParam10Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam10Label();
        }
        return this.engineparam10label;
    }

    public boolean isEngineParam10LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam10LabelDirty();
        }
        return this.engineparam10labelDirtyFlag;
    }

    public void resetEngineParam10Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam10Label();
            return;
        }
        this.engineparam10labelDirtyFlag = false;
        this.engineparam10label = null;
    }

    public void setEngineParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam2 = string;
        this.engineparam2DirtyFlag = true;
    }

    public String getEngineParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam2();
        }
        return this.engineparam2;
    }

    public boolean isEngineParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam2Dirty();
        }
        return this.engineparam2DirtyFlag;
    }

    public void resetEngineParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam2();
            return;
        }
        this.engineparam2DirtyFlag = false;
        this.engineparam2 = null;
    }

    public void setEngineParam2Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam2Flag(n);
            return;
        }
        this.engineparam2flag = n;
        this.engineparam2flagDirtyFlag = true;
    }

    public Integer getEngineParam2Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam2Flag();
        }
        return this.engineparam2flag;
    }

    public boolean isEngineParam2FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam2FlagDirty();
        }
        return this.engineparam2flagDirtyFlag;
    }

    public void resetEngineParam2Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam2Flag();
            return;
        }
        this.engineparam2flagDirtyFlag = false;
        this.engineparam2flag = null;
    }

    public void setEngineParam2Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam2Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam2label = string;
        this.engineparam2labelDirtyFlag = true;
    }

    public String getEngineParam2Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam2Label();
        }
        return this.engineparam2label;
    }

    public boolean isEngineParam2LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam2LabelDirty();
        }
        return this.engineparam2labelDirtyFlag;
    }

    public void resetEngineParam2Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam2Label();
            return;
        }
        this.engineparam2labelDirtyFlag = false;
        this.engineparam2label = null;
    }

    public void setEngineParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam3 = string;
        this.engineparam3DirtyFlag = true;
    }

    public String getEngineParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam3();
        }
        return this.engineparam3;
    }

    public boolean isEngineParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam3Dirty();
        }
        return this.engineparam3DirtyFlag;
    }

    public void resetEngineParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam3();
            return;
        }
        this.engineparam3DirtyFlag = false;
        this.engineparam3 = null;
    }

    public void setEngineParam3Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam3Flag(n);
            return;
        }
        this.engineparam3flag = n;
        this.engineparam3flagDirtyFlag = true;
    }

    public Integer getEngineParam3Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam3Flag();
        }
        return this.engineparam3flag;
    }

    public boolean isEngineParam3FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam3FlagDirty();
        }
        return this.engineparam3flagDirtyFlag;
    }

    public void resetEngineParam3Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam3Flag();
            return;
        }
        this.engineparam3flagDirtyFlag = false;
        this.engineparam3flag = null;
    }

    public void setEngineParam3Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam3Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam3label = string;
        this.engineparam3labelDirtyFlag = true;
    }

    public String getEngineParam3Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam3Label();
        }
        return this.engineparam3label;
    }

    public boolean isEngineParam3LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam3LabelDirty();
        }
        return this.engineparam3labelDirtyFlag;
    }

    public void resetEngineParam3Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam3Label();
            return;
        }
        this.engineparam3labelDirtyFlag = false;
        this.engineparam3label = null;
    }

    public void setEngineParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam4 = string;
        this.engineparam4DirtyFlag = true;
    }

    public String getEngineParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam4();
        }
        return this.engineparam4;
    }

    public boolean isEngineParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam4Dirty();
        }
        return this.engineparam4DirtyFlag;
    }

    public void resetEngineParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam4();
            return;
        }
        this.engineparam4DirtyFlag = false;
        this.engineparam4 = null;
    }

    public void setEngineParam4Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam4Flag(n);
            return;
        }
        this.engineparam4flag = n;
        this.engineparam4flagDirtyFlag = true;
    }

    public Integer getEngineParam4Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam4Flag();
        }
        return this.engineparam4flag;
    }

    public boolean isEngineParam4FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam4FlagDirty();
        }
        return this.engineparam4flagDirtyFlag;
    }

    public void resetEngineParam4Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam4Flag();
            return;
        }
        this.engineparam4flagDirtyFlag = false;
        this.engineparam4flag = null;
    }

    public void setEngineParam4Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam4Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam4label = string;
        this.engineparam4labelDirtyFlag = true;
    }

    public String getEngineParam4Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam4Label();
        }
        return this.engineparam4label;
    }

    public boolean isEngineParam4LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam4LabelDirty();
        }
        return this.engineparam4labelDirtyFlag;
    }

    public void resetEngineParam4Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam4Label();
            return;
        }
        this.engineparam4labelDirtyFlag = false;
        this.engineparam4label = null;
    }

    public void setEngineParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam5(n);
            return;
        }
        this.engineparam5 = n;
        this.engineparam5DirtyFlag = true;
    }

    public Integer getEngineParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam5();
        }
        return this.engineparam5;
    }

    public boolean isEngineParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam5Dirty();
        }
        return this.engineparam5DirtyFlag;
    }

    public void resetEngineParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam5();
            return;
        }
        this.engineparam5DirtyFlag = false;
        this.engineparam5 = null;
    }

    public void setEngineParam5Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam5Flag(n);
            return;
        }
        this.engineparam5flag = n;
        this.engineparam5flagDirtyFlag = true;
    }

    public Integer getEngineParam5Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam5Flag();
        }
        return this.engineparam5flag;
    }

    public boolean isEngineParam5FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam5FlagDirty();
        }
        return this.engineparam5flagDirtyFlag;
    }

    public void resetEngineParam5Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam5Flag();
            return;
        }
        this.engineparam5flagDirtyFlag = false;
        this.engineparam5flag = null;
    }

    public void setEngineParam5Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam5Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam5label = string;
        this.engineparam5labelDirtyFlag = true;
    }

    public String getEngineParam5Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam5Label();
        }
        return this.engineparam5label;
    }

    public boolean isEngineParam5LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam5LabelDirty();
        }
        return this.engineparam5labelDirtyFlag;
    }

    public void resetEngineParam5Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam5Label();
            return;
        }
        this.engineparam5labelDirtyFlag = false;
        this.engineparam5label = null;
    }

    public void setEngineParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam6(n);
            return;
        }
        this.engineparam6 = n;
        this.engineparam6DirtyFlag = true;
    }

    public Integer getEngineParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam6();
        }
        return this.engineparam6;
    }

    public boolean isEngineParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam6Dirty();
        }
        return this.engineparam6DirtyFlag;
    }

    public void resetEngineParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam6();
            return;
        }
        this.engineparam6DirtyFlag = false;
        this.engineparam6 = null;
    }

    public void setEngineParam6Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam6Flag(n);
            return;
        }
        this.engineparam6flag = n;
        this.engineparam6flagDirtyFlag = true;
    }

    public Integer getEngineParam6Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam6Flag();
        }
        return this.engineparam6flag;
    }

    public boolean isEngineParam6FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam6FlagDirty();
        }
        return this.engineparam6flagDirtyFlag;
    }

    public void resetEngineParam6Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam6Flag();
            return;
        }
        this.engineparam6flagDirtyFlag = false;
        this.engineparam6flag = null;
    }

    public void setEngineParam6Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam6Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam6label = string;
        this.engineparam6labelDirtyFlag = true;
    }

    public String getEngineParam6Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam6Label();
        }
        return this.engineparam6label;
    }

    public boolean isEngineParam6LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam6LabelDirty();
        }
        return this.engineparam6labelDirtyFlag;
    }

    public void resetEngineParam6Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam6Label();
            return;
        }
        this.engineparam6labelDirtyFlag = false;
        this.engineparam6label = null;
    }

    public void setEngineParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam7(n);
            return;
        }
        this.engineparam7 = n;
        this.engineparam7DirtyFlag = true;
    }

    public Integer getEngineParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam7();
        }
        return this.engineparam7;
    }

    public boolean isEngineParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam7Dirty();
        }
        return this.engineparam7DirtyFlag;
    }

    public void resetEngineParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam7();
            return;
        }
        this.engineparam7DirtyFlag = false;
        this.engineparam7 = null;
    }

    public void setEngineParam7Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam7Flag(n);
            return;
        }
        this.engineparam7flag = n;
        this.engineparam7flagDirtyFlag = true;
    }

    public Integer getEngineParam7Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam7Flag();
        }
        return this.engineparam7flag;
    }

    public boolean isEngineParam7FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam7FlagDirty();
        }
        return this.engineparam7flagDirtyFlag;
    }

    public void resetEngineParam7Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam7Flag();
            return;
        }
        this.engineparam7flagDirtyFlag = false;
        this.engineparam7flag = null;
    }

    public void setEngineParam7Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam7Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam7label = string;
        this.engineparam7labelDirtyFlag = true;
    }

    public String getEngineParam7Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam7Label();
        }
        return this.engineparam7label;
    }

    public boolean isEngineParam7LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam7LabelDirty();
        }
        return this.engineparam7labelDirtyFlag;
    }

    public void resetEngineParam7Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam7Label();
            return;
        }
        this.engineparam7labelDirtyFlag = false;
        this.engineparam7label = null;
    }

    public void setEngineParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam8(n);
            return;
        }
        this.engineparam8 = n;
        this.engineparam8DirtyFlag = true;
    }

    public Integer getEngineParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam8();
        }
        return this.engineparam8;
    }

    public boolean isEngineParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam8Dirty();
        }
        return this.engineparam8DirtyFlag;
    }

    public void resetEngineParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam8();
            return;
        }
        this.engineparam8DirtyFlag = false;
        this.engineparam8 = null;
    }

    public void setEngineParam8Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam8Flag(n);
            return;
        }
        this.engineparam8flag = n;
        this.engineparam8flagDirtyFlag = true;
    }

    public Integer getEngineParam8Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam8Flag();
        }
        return this.engineparam8flag;
    }

    public boolean isEngineParam8FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam8FlagDirty();
        }
        return this.engineparam8flagDirtyFlag;
    }

    public void resetEngineParam8Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam8Flag();
            return;
        }
        this.engineparam8flagDirtyFlag = false;
        this.engineparam8flag = null;
    }

    public void setEngineParam8Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam8Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam8label = string;
        this.engineparam8labelDirtyFlag = true;
    }

    public String getEngineParam8Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam8Label();
        }
        return this.engineparam8label;
    }

    public boolean isEngineParam8LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam8LabelDirty();
        }
        return this.engineparam8labelDirtyFlag;
    }

    public void resetEngineParam8Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam8Label();
            return;
        }
        this.engineparam8labelDirtyFlag = false;
        this.engineparam8label = null;
    }

    public void setEngineParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam9(n);
            return;
        }
        this.engineparam9 = n;
        this.engineparam9DirtyFlag = true;
    }

    public Integer getEngineParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam9();
        }
        return this.engineparam9;
    }

    public boolean isEngineParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam9Dirty();
        }
        return this.engineparam9DirtyFlag;
    }

    public void resetEngineParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam9();
            return;
        }
        this.engineparam9DirtyFlag = false;
        this.engineparam9 = null;
    }

    public void setEngineParam9Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam9Flag(n);
            return;
        }
        this.engineparam9flag = n;
        this.engineparam9flagDirtyFlag = true;
    }

    public Integer getEngineParam9Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam9Flag();
        }
        return this.engineparam9flag;
    }

    public boolean isEngineParam9FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam9FlagDirty();
        }
        return this.engineparam9flagDirtyFlag;
    }

    public void resetEngineParam9Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam9Flag();
            return;
        }
        this.engineparam9flagDirtyFlag = false;
        this.engineparam9flag = null;
    }

    public void setEngineParam9Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam9Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam9label = string;
        this.engineparam9labelDirtyFlag = true;
    }

    public String getEngineParam9Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam9Label();
        }
        return this.engineparam9label;
    }

    public boolean isEngineParam9LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam9LabelDirty();
        }
        return this.engineparam9labelDirtyFlag;
    }

    public void resetEngineParam9Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam9Label();
            return;
        }
        this.engineparam9labelDirtyFlag = false;
        this.engineparam9label = null;
    }

    public void setEngineParamFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParamFlag(n);
            return;
        }
        this.engineparamflag = n;
        this.engineparamflagDirtyFlag = true;
    }

    public Integer getEngineParamFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParamFlag();
        }
        return this.engineparamflag;
    }

    public boolean isEngineParamFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParamFlagDirty();
        }
        return this.engineparamflagDirtyFlag;
    }

    public void resetEngineParamFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParamFlag();
            return;
        }
        this.engineparamflagDirtyFlag = false;
        this.engineparamflag = null;
    }

    public void setEngineParamLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParamLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparamlabel = string;
        this.engineparamlabelDirtyFlag = true;
    }

    public String getEngineParamLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParamLabel();
        }
        return this.engineparamlabel;
    }

    public boolean isEngineParamLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParamLabelDirty();
        }
        return this.engineparamlabelDirtyFlag;
    }

    public void resetEngineParamLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParamLabel();
            return;
        }
        this.engineparamlabelDirtyFlag = false;
        this.engineparamlabel = null;
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

    public void setNo2DEViewCtrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2DEViewCtrlFlag(n);
            return;
        }
        this.no2deviewctrlflag = n;
        this.no2deviewctrlflagDirtyFlag = true;
    }

    public Integer getNo2DEViewCtrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2DEViewCtrlFlag();
        }
        return this.no2deviewctrlflag;
    }

    public boolean isNo2DEViewCtrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2DEViewCtrlFlagDirty();
        }
        return this.no2deviewctrlflagDirtyFlag;
    }

    public void resetNo2DEViewCtrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2DEViewCtrlFlag();
            return;
        }
        this.no2deviewctrlflagDirtyFlag = false;
        this.no2deviewctrlflag = null;
    }

    public void setNo2DEViewCtrlLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2DEViewCtrlLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2deviewctrllabel = string;
        this.no2deviewctrllabelDirtyFlag = true;
    }

    public String getNo2DEViewCtrlLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2DEViewCtrlLabel();
        }
        return this.no2deviewctrllabel;
    }

    public boolean isNo2DEViewCtrlLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2DEViewCtrlLabelDirty();
        }
        return this.no2deviewctrllabelDirtyFlag;
    }

    public void resetNo2DEViewCtrlLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2DEViewCtrlLabel();
            return;
        }
        this.no2deviewctrllabelDirtyFlag = false;
        this.no2deviewctrllabel = null;
    }

    public void setNo2DEViewLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2DEViewLogicFlag(n);
            return;
        }
        this.no2deviewlogicflag = n;
        this.no2deviewlogicflagDirtyFlag = true;
    }

    public Integer getNo2DEViewLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2DEViewLogicFlag();
        }
        return this.no2deviewlogicflag;
    }

    public boolean isNo2DEViewLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2DEViewLogicFlagDirty();
        }
        return this.no2deviewlogicflagDirtyFlag;
    }

    public void resetNo2DEViewLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2DEViewLogicFlag();
            return;
        }
        this.no2deviewlogicflagDirtyFlag = false;
        this.no2deviewlogicflag = null;
    }

    public void setNo2DEViewLogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2DEViewLogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2deviewlogiclabel = string;
        this.no2deviewlogiclabelDirtyFlag = true;
    }

    public String getNo2DEViewLogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2DEViewLogicLabel();
        }
        return this.no2deviewlogiclabel;
    }

    public boolean isNo2DEViewLogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2DEViewLogicLabelDirty();
        }
        return this.no2deviewlogiclabelDirtyFlag;
    }

    public void resetNo2DEViewLogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2DEViewLogicLabel();
            return;
        }
        this.no2deviewlogiclabelDirtyFlag = false;
        this.no2deviewlogiclabel = null;
    }

    public void setNo2PSDEViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeviewctrlid = string;
        this.no2psdeviewctrlidDirtyFlag = true;
    }

    public String getNo2PSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEViewCtrlId();
        }
        return this.no2psdeviewctrlid;
    }

    public boolean isNo2PSDEViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEViewCtrlIdDirty();
        }
        return this.no2psdeviewctrlidDirtyFlag;
    }

    public void resetNo2PSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEViewCtrlId();
            return;
        }
        this.no2psdeviewctrlidDirtyFlag = false;
        this.no2psdeviewctrlid = null;
    }

    public void setNo2PSDEViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeviewctrlname = string;
        this.no2psdeviewctrlnameDirtyFlag = true;
    }

    public String getNo2PSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEViewCtrlName();
        }
        return this.no2psdeviewctrlname;
    }

    public boolean isNo2PSDEViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEViewCtrlNameDirty();
        }
        return this.no2psdeviewctrlnameDirtyFlag;
    }

    public void resetNo2PSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEViewCtrlName();
            return;
        }
        this.no2psdeviewctrlnameDirtyFlag = false;
        this.no2psdeviewctrlname = null;
    }

    public void setNo2PSDEViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeviewlogicid = string;
        this.no2psdeviewlogicidDirtyFlag = true;
    }

    public String getNo2PSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEViewLogicId();
        }
        return this.no2psdeviewlogicid;
    }

    public boolean isNo2PSDEViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEViewLogicIdDirty();
        }
        return this.no2psdeviewlogicidDirtyFlag;
    }

    public void resetNo2PSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEViewLogicId();
            return;
        }
        this.no2psdeviewlogicidDirtyFlag = false;
        this.no2psdeviewlogicid = null;
    }

    public void setNo2PSDEViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeviewlogicname = string;
        this.no2psdeviewlogicnameDirtyFlag = true;
    }

    public String getNo2PSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEViewLogicName();
        }
        return this.no2psdeviewlogicname;
    }

    public boolean isNo2PSDEViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEViewLogicNameDirty();
        }
        return this.no2psdeviewlogicnameDirtyFlag;
    }

    public void resetNo2PSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEViewLogicName();
            return;
        }
        this.no2psdeviewlogicnameDirtyFlag = false;
        this.no2psdeviewlogicname = null;
    }

    public void setNo3DEViewCtrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3DEViewCtrlFlag(n);
            return;
        }
        this.no3deviewctrlflag = n;
        this.no3deviewctrlflagDirtyFlag = true;
    }

    public Integer getNo3DEViewCtrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3DEViewCtrlFlag();
        }
        return this.no3deviewctrlflag;
    }

    public boolean isNo3DEViewCtrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3DEViewCtrlFlagDirty();
        }
        return this.no3deviewctrlflagDirtyFlag;
    }

    public void resetNo3DEViewCtrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3DEViewCtrlFlag();
            return;
        }
        this.no3deviewctrlflagDirtyFlag = false;
        this.no3deviewctrlflag = null;
    }

    public void setNo3DEViewCtrlLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3DEViewCtrlLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3deviewctrllabel = string;
        this.no3deviewctrllabelDirtyFlag = true;
    }

    public String getNo3DEViewCtrlLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3DEViewCtrlLabel();
        }
        return this.no3deviewctrllabel;
    }

    public boolean isNo3DEViewCtrlLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3DEViewCtrlLabelDirty();
        }
        return this.no3deviewctrllabelDirtyFlag;
    }

    public void resetNo3DEViewCtrlLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3DEViewCtrlLabel();
            return;
        }
        this.no3deviewctrllabelDirtyFlag = false;
        this.no3deviewctrllabel = null;
    }

    public void setNo3DEViewLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3DEViewLogicFlag(n);
            return;
        }
        this.no3deviewlogicflag = n;
        this.no3deviewlogicflagDirtyFlag = true;
    }

    public Integer getNo3DEViewLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3DEViewLogicFlag();
        }
        return this.no3deviewlogicflag;
    }

    public boolean isNo3DEViewLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3DEViewLogicFlagDirty();
        }
        return this.no3deviewlogicflagDirtyFlag;
    }

    public void resetNo3DEViewLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3DEViewLogicFlag();
            return;
        }
        this.no3deviewlogicflagDirtyFlag = false;
        this.no3deviewlogicflag = null;
    }

    public void setNo3DEViewLogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3DEViewLogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3deviewlogiclabel = string;
        this.no3deviewlogiclabelDirtyFlag = true;
    }

    public String getNo3DEViewLogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3DEViewLogicLabel();
        }
        return this.no3deviewlogiclabel;
    }

    public boolean isNo3DEViewLogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3DEViewLogicLabelDirty();
        }
        return this.no3deviewlogiclabelDirtyFlag;
    }

    public void resetNo3DEViewLogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3DEViewLogicLabel();
            return;
        }
        this.no3deviewlogiclabelDirtyFlag = false;
        this.no3deviewlogiclabel = null;
    }

    public void setNo3PSDEViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSDEViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3psdeviewctrlid = string;
        this.no3psdeviewctrlidDirtyFlag = true;
    }

    public String getNo3PSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEViewCtrlId();
        }
        return this.no3psdeviewctrlid;
    }

    public boolean isNo3PSDEViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSDEViewCtrlIdDirty();
        }
        return this.no3psdeviewctrlidDirtyFlag;
    }

    public void resetNo3PSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSDEViewCtrlId();
            return;
        }
        this.no3psdeviewctrlidDirtyFlag = false;
        this.no3psdeviewctrlid = null;
    }

    public void setNo3PSDEViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSDEViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3psdeviewctrlname = string;
        this.no3psdeviewctrlnameDirtyFlag = true;
    }

    public String getNo3PSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEViewCtrlName();
        }
        return this.no3psdeviewctrlname;
    }

    public boolean isNo3PSDEViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSDEViewCtrlNameDirty();
        }
        return this.no3psdeviewctrlnameDirtyFlag;
    }

    public void resetNo3PSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSDEViewCtrlName();
            return;
        }
        this.no3psdeviewctrlnameDirtyFlag = false;
        this.no3psdeviewctrlname = null;
    }

    public void setNo3PSDEViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSDEViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3psdeviewlogicid = string;
        this.no3psdeviewlogicidDirtyFlag = true;
    }

    public String getNo3PSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEViewLogicId();
        }
        return this.no3psdeviewlogicid;
    }

    public boolean isNo3PSDEViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSDEViewLogicIdDirty();
        }
        return this.no3psdeviewlogicidDirtyFlag;
    }

    public void resetNo3PSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSDEViewLogicId();
            return;
        }
        this.no3psdeviewlogicidDirtyFlag = false;
        this.no3psdeviewlogicid = null;
    }

    public void setNo3PSDEViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSDEViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3psdeviewlogicname = string;
        this.no3psdeviewlogicnameDirtyFlag = true;
    }

    public String getNo3PSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEViewLogicName();
        }
        return this.no3psdeviewlogicname;
    }

    public boolean isNo3PSDEViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSDEViewLogicNameDirty();
        }
        return this.no3psdeviewlogicnameDirtyFlag;
    }

    public void resetNo3PSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSDEViewLogicName();
            return;
        }
        this.no3psdeviewlogicnameDirtyFlag = false;
        this.no3psdeviewlogicname = null;
    }

    public void setNo4DEViewCtrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4DEViewCtrlFlag(n);
            return;
        }
        this.no4deviewctrlflag = n;
        this.no4deviewctrlflagDirtyFlag = true;
    }

    public Integer getNo4DEViewCtrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4DEViewCtrlFlag();
        }
        return this.no4deviewctrlflag;
    }

    public boolean isNo4DEViewCtrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4DEViewCtrlFlagDirty();
        }
        return this.no4deviewctrlflagDirtyFlag;
    }

    public void resetNo4DEViewCtrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4DEViewCtrlFlag();
            return;
        }
        this.no4deviewctrlflagDirtyFlag = false;
        this.no4deviewctrlflag = null;
    }

    public void setNo4DEViewCtrlLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4DEViewCtrlLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4deviewctrllabel = string;
        this.no4deviewctrllabelDirtyFlag = true;
    }

    public String getNo4DEViewCtrlLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4DEViewCtrlLabel();
        }
        return this.no4deviewctrllabel;
    }

    public boolean isNo4DEViewCtrlLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4DEViewCtrlLabelDirty();
        }
        return this.no4deviewctrllabelDirtyFlag;
    }

    public void resetNo4DEViewCtrlLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4DEViewCtrlLabel();
            return;
        }
        this.no4deviewctrllabelDirtyFlag = false;
        this.no4deviewctrllabel = null;
    }

    public void setNo4DEViewLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4DEViewLogicFlag(n);
            return;
        }
        this.no4deviewlogicflag = n;
        this.no4deviewlogicflagDirtyFlag = true;
    }

    public Integer getNo4DEViewLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4DEViewLogicFlag();
        }
        return this.no4deviewlogicflag;
    }

    public boolean isNo4DEViewLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4DEViewLogicFlagDirty();
        }
        return this.no4deviewlogicflagDirtyFlag;
    }

    public void resetNo4DEViewLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4DEViewLogicFlag();
            return;
        }
        this.no4deviewlogicflagDirtyFlag = false;
        this.no4deviewlogicflag = null;
    }

    public void setNo4DEViewLogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4DEViewLogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4deviewlogiclabel = string;
        this.no4deviewlogiclabelDirtyFlag = true;
    }

    public String getNo4DEViewLogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4DEViewLogicLabel();
        }
        return this.no4deviewlogiclabel;
    }

    public boolean isNo4DEViewLogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4DEViewLogicLabelDirty();
        }
        return this.no4deviewlogiclabelDirtyFlag;
    }

    public void resetNo4DEViewLogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4DEViewLogicLabel();
            return;
        }
        this.no4deviewlogiclabelDirtyFlag = false;
        this.no4deviewlogiclabel = null;
    }

    public void setNo4PSDEViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSDEViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4psdeviewctrlid = string;
        this.no4psdeviewctrlidDirtyFlag = true;
    }

    public String getNo4PSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEViewCtrlId();
        }
        return this.no4psdeviewctrlid;
    }

    public boolean isNo4PSDEViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSDEViewCtrlIdDirty();
        }
        return this.no4psdeviewctrlidDirtyFlag;
    }

    public void resetNo4PSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSDEViewCtrlId();
            return;
        }
        this.no4psdeviewctrlidDirtyFlag = false;
        this.no4psdeviewctrlid = null;
    }

    public void setNo4PSDEViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSDEViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4psdeviewctrlname = string;
        this.no4psdeviewctrlnameDirtyFlag = true;
    }

    public String getNo4PSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEViewCtrlName();
        }
        return this.no4psdeviewctrlname;
    }

    public boolean isNo4PSDEViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSDEViewCtrlNameDirty();
        }
        return this.no4psdeviewctrlnameDirtyFlag;
    }

    public void resetNo4PSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSDEViewCtrlName();
            return;
        }
        this.no4psdeviewctrlnameDirtyFlag = false;
        this.no4psdeviewctrlname = null;
    }

    public void setNo4PSDEViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSDEViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4psdeviewlogicid = string;
        this.no4psdeviewlogicidDirtyFlag = true;
    }

    public String getNo4PSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEViewLogicId();
        }
        return this.no4psdeviewlogicid;
    }

    public boolean isNo4PSDEViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSDEViewLogicIdDirty();
        }
        return this.no4psdeviewlogicidDirtyFlag;
    }

    public void resetNo4PSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSDEViewLogicId();
            return;
        }
        this.no4psdeviewlogicidDirtyFlag = false;
        this.no4psdeviewlogicid = null;
    }

    public void setNo4PSDEViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSDEViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4psdeviewlogicname = string;
        this.no4psdeviewlogicnameDirtyFlag = true;
    }

    public String getNo4PSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEViewLogicName();
        }
        return this.no4psdeviewlogicname;
    }

    public boolean isNo4PSDEViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSDEViewLogicNameDirty();
        }
        return this.no4psdeviewlogicnameDirtyFlag;
    }

    public void resetNo4PSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSDEViewLogicName();
            return;
        }
        this.no4psdeviewlogicnameDirtyFlag = false;
        this.no4psdeviewlogicname = null;
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

    public void setPSDEViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrlid = string;
        this.psdeviewctrlidDirtyFlag = true;
    }

    public String getPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlId();
        }
        return this.psdeviewctrlid;
    }

    public boolean isPSDEViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlIdDirty();
        }
        return this.psdeviewctrlidDirtyFlag;
    }

    public void resetPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlId();
            return;
        }
        this.psdeviewctrlidDirtyFlag = false;
        this.psdeviewctrlid = null;
    }

    public void setPSDEViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrlname = string;
        this.psdeviewctrlnameDirtyFlag = true;
    }

    public String getPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlName();
        }
        return this.psdeviewctrlname;
    }

    public boolean isPSDEViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlNameDirty();
        }
        return this.psdeviewctrlnameDirtyFlag;
    }

    public void resetPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlName();
            return;
        }
        this.psdeviewctrlnameDirtyFlag = false;
        this.psdeviewctrlname = null;
    }

    public void setPSDEViewEngineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewEngineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewengineid = string;
        this.psdeviewengineidDirtyFlag = true;
    }

    public String getPSDEViewEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewEngineId();
        }
        return this.psdeviewengineid;
    }

    public boolean isPSDEViewEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewEngineIdDirty();
        }
        return this.psdeviewengineidDirtyFlag;
    }

    public void resetPSDEViewEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewEngineId();
            return;
        }
        this.psdeviewengineidDirtyFlag = false;
        this.psdeviewengineid = null;
    }

    public void setPSDEViewEngineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewEngineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewenginename = string;
        this.psdeviewenginenameDirtyFlag = true;
    }

    public String getPSDEViewEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewEngineName();
        }
        return this.psdeviewenginename;
    }

    public boolean isPSDEViewEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewEngineNameDirty();
        }
        return this.psdeviewenginenameDirtyFlag;
    }

    public void resetPSDEViewEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewEngineName();
            return;
        }
        this.psdeviewenginenameDirtyFlag = false;
        this.psdeviewenginename = null;
    }

    public void setPSDEViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewlogicid = string;
        this.psdeviewlogicidDirtyFlag = true;
    }

    public String getPSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogicId();
        }
        return this.psdeviewlogicid;
    }

    public boolean isPSDEViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewLogicIdDirty();
        }
        return this.psdeviewlogicidDirtyFlag;
    }

    public void resetPSDEViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewLogicId();
            return;
        }
        this.psdeviewlogicidDirtyFlag = false;
        this.psdeviewlogicid = null;
    }

    public void setPSDEViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewlogicname = string;
        this.psdeviewlogicnameDirtyFlag = true;
    }

    public String getPSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogicName();
        }
        return this.psdeviewlogicname;
    }

    public boolean isPSDEViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewLogicNameDirty();
        }
        return this.psdeviewlogicnameDirtyFlag;
    }

    public void resetPSDEViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewLogicName();
            return;
        }
        this.psdeviewlogicnameDirtyFlag = false;
        this.psdeviewlogicname = null;
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

    public void setPSUIEngineTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUIEngineTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuienginetypeid = string;
        this.psuienginetypeidDirtyFlag = true;
    }

    public String getPSUIEngineTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeId();
        }
        return this.psuienginetypeid;
    }

    public boolean isPSUIEngineTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUIEngineTypeIdDirty();
        }
        return this.psuienginetypeidDirtyFlag;
    }

    public void resetPSUIEngineTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUIEngineTypeId();
            return;
        }
        this.psuienginetypeidDirtyFlag = false;
        this.psuienginetypeid = null;
    }

    public void setPSUIEngineTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUIEngineTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuienginetypename = string;
        this.psuienginetypenameDirtyFlag = true;
    }

    public String getPSUIEngineTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeName();
        }
        return this.psuienginetypename;
    }

    public boolean isPSUIEngineTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUIEngineTypeNameDirty();
        }
        return this.psuienginetypenameDirtyFlag;
    }

    public void resetPSUIEngineTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUIEngineTypeName();
            return;
        }
        this.psuienginetypenameDirtyFlag = false;
        this.psuienginetypename = null;
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

    public void setViewParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam = string;
        this.viewparamDirtyFlag = true;
    }

    public String getViewParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam();
        }
        return this.viewparam;
    }

    public boolean isViewParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamDirty();
        }
        return this.viewparamDirtyFlag;
    }

    public void resetViewParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam();
            return;
        }
        this.viewparamDirtyFlag = false;
        this.viewparam = null;
    }

    public void setViewParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam10(n);
            return;
        }
        this.viewparam10 = n;
        this.viewparam10DirtyFlag = true;
    }

    public Integer getViewParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam10();
        }
        return this.viewparam10;
    }

    public boolean isViewParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam10Dirty();
        }
        return this.viewparam10DirtyFlag;
    }

    public void resetViewParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam10();
            return;
        }
        this.viewparam10DirtyFlag = false;
        this.viewparam10 = null;
    }

    public void setViewParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam2 = string;
        this.viewparam2DirtyFlag = true;
    }

    public String getViewParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam2();
        }
        return this.viewparam2;
    }

    public boolean isViewParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam2Dirty();
        }
        return this.viewparam2DirtyFlag;
    }

    public void resetViewParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam2();
            return;
        }
        this.viewparam2DirtyFlag = false;
        this.viewparam2 = null;
    }

    public void setViewParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam3(n);
            return;
        }
        this.viewparam3 = n;
        this.viewparam3DirtyFlag = true;
    }

    public Integer getViewParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam3();
        }
        return this.viewparam3;
    }

    public boolean isViewParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam3Dirty();
        }
        return this.viewparam3DirtyFlag;
    }

    public void resetViewParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam3();
            return;
        }
        this.viewparam3DirtyFlag = false;
        this.viewparam3 = null;
    }

    public void setViewParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam4(n);
            return;
        }
        this.viewparam4 = n;
        this.viewparam4DirtyFlag = true;
    }

    public Integer getViewParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam4();
        }
        return this.viewparam4;
    }

    public boolean isViewParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam4Dirty();
        }
        return this.viewparam4DirtyFlag;
    }

    public void resetViewParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam4();
            return;
        }
        this.viewparam4DirtyFlag = false;
        this.viewparam4 = null;
    }

    public void setViewParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam5(n);
            return;
        }
        this.viewparam5 = n;
        this.viewparam5DirtyFlag = true;
    }

    public Integer getViewParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam5();
        }
        return this.viewparam5;
    }

    public boolean isViewParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam5Dirty();
        }
        return this.viewparam5DirtyFlag;
    }

    public void resetViewParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam5();
            return;
        }
        this.viewparam5DirtyFlag = false;
        this.viewparam5 = null;
    }

    public void setViewParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam6(n);
            return;
        }
        this.viewparam6 = n;
        this.viewparam6DirtyFlag = true;
    }

    public Integer getViewParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam6();
        }
        return this.viewparam6;
    }

    public boolean isViewParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam6Dirty();
        }
        return this.viewparam6DirtyFlag;
    }

    public void resetViewParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam6();
            return;
        }
        this.viewparam6DirtyFlag = false;
        this.viewparam6 = null;
    }

    public void setViewParam7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam7 = string;
        this.viewparam7DirtyFlag = true;
    }

    public String getViewParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam7();
        }
        return this.viewparam7;
    }

    public boolean isViewParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam7Dirty();
        }
        return this.viewparam7DirtyFlag;
    }

    public void resetViewParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam7();
            return;
        }
        this.viewparam7DirtyFlag = false;
        this.viewparam7 = null;
    }

    public void setViewParam8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam8 = string;
        this.viewparam8DirtyFlag = true;
    }

    public String getViewParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam8();
        }
        return this.viewparam8;
    }

    public boolean isViewParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam8Dirty();
        }
        return this.viewparam8DirtyFlag;
    }

    public void resetViewParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam8();
            return;
        }
        this.viewparam8DirtyFlag = false;
        this.viewparam8 = null;
    }

    public void setViewParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam9(n);
            return;
        }
        this.viewparam9 = n;
        this.viewparam9DirtyFlag = true;
    }

    public Integer getViewParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam9();
        }
        return this.viewparam9;
    }

    public boolean isViewParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam9Dirty();
        }
        return this.viewparam9DirtyFlag;
    }

    public void resetViewParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam9();
            return;
        }
        this.viewparam9DirtyFlag = false;
        this.viewparam9 = null;
    }

    public void setWFViewParam(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFViewParam(n);
            return;
        }
        this.wfviewparam = n;
        this.wfviewparamDirtyFlag = true;
    }

    public Integer getWFViewParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFViewParam();
        }
        return this.wfviewparam;
    }

    public boolean isWFViewParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFViewParamDirty();
        }
        return this.wfviewparamDirtyFlag;
    }

    public void resetWFViewParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFViewParam();
            return;
        }
        this.wfviewparamDirtyFlag = false;
        this.wfviewparam = null;
    }

    public void setWFViewParam2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFViewParam2(n);
            return;
        }
        this.wfviewparam2 = n;
        this.wfviewparam2DirtyFlag = true;
    }

    public Integer getWFViewParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFViewParam2();
        }
        return this.wfviewparam2;
    }

    public boolean isWFViewParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFViewParam2Dirty();
        }
        return this.wfviewparam2DirtyFlag;
    }

    public void resetWFViewParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFViewParam2();
            return;
        }
        this.wfviewparam2DirtyFlag = false;
        this.wfviewparam2 = null;
    }

    public void setWFViewParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFViewParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfviewparam3 = string;
        this.wfviewparam3DirtyFlag = true;
    }

    public String getWFViewParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFViewParam3();
        }
        return this.wfviewparam3;
    }

    public boolean isWFViewParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFViewParam3Dirty();
        }
        return this.wfviewparam3DirtyFlag;
    }

    public void resetWFViewParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFViewParam3();
            return;
        }
        this.wfviewparam3DirtyFlag = false;
        this.wfviewparam3 = null;
    }

    public void setWFViewParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFViewParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfviewparam4 = string;
        this.wfviewparam4DirtyFlag = true;
    }

    public String getWFViewParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFViewParam4();
        }
        return this.wfviewparam4;
    }

    public boolean isWFViewParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFViewParam4Dirty();
        }
        return this.wfviewparam4DirtyFlag;
    }

    public void resetWFViewParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFViewParam4();
            return;
        }
        this.wfviewparam4DirtyFlag = false;
        this.wfviewparam4 = null;
    }

    protected void onReset() {
        PSDEViewEngineBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewEngineBase pSDEViewEngineBase) {
        pSDEViewEngineBase.resetCreateDate();
        pSDEViewEngineBase.resetCreateMan();
        pSDEViewEngineBase.resetDEViewCtrlFlag();
        pSDEViewEngineBase.resetDEViewCtrlLabel();
        pSDEViewEngineBase.resetDEViewLogicFlag();
        pSDEViewEngineBase.resetDEViewLogicLabel();
        pSDEViewEngineBase.resetEngineOption();
        pSDEViewEngineBase.resetEngineParam();
        pSDEViewEngineBase.resetEngineParam10();
        pSDEViewEngineBase.resetEngineParam10Flag();
        pSDEViewEngineBase.resetEngineParam10Label();
        pSDEViewEngineBase.resetEngineParam2();
        pSDEViewEngineBase.resetEngineParam2Flag();
        pSDEViewEngineBase.resetEngineParam2Label();
        pSDEViewEngineBase.resetEngineParam3();
        pSDEViewEngineBase.resetEngineParam3Flag();
        pSDEViewEngineBase.resetEngineParam3Label();
        pSDEViewEngineBase.resetEngineParam4();
        pSDEViewEngineBase.resetEngineParam4Flag();
        pSDEViewEngineBase.resetEngineParam4Label();
        pSDEViewEngineBase.resetEngineParam5();
        pSDEViewEngineBase.resetEngineParam5Flag();
        pSDEViewEngineBase.resetEngineParam5Label();
        pSDEViewEngineBase.resetEngineParam6();
        pSDEViewEngineBase.resetEngineParam6Flag();
        pSDEViewEngineBase.resetEngineParam6Label();
        pSDEViewEngineBase.resetEngineParam7();
        pSDEViewEngineBase.resetEngineParam7Flag();
        pSDEViewEngineBase.resetEngineParam7Label();
        pSDEViewEngineBase.resetEngineParam8();
        pSDEViewEngineBase.resetEngineParam8Flag();
        pSDEViewEngineBase.resetEngineParam8Label();
        pSDEViewEngineBase.resetEngineParam9();
        pSDEViewEngineBase.resetEngineParam9Flag();
        pSDEViewEngineBase.resetEngineParam9Label();
        pSDEViewEngineBase.resetEngineParamFlag();
        pSDEViewEngineBase.resetEngineParamLabel();
        pSDEViewEngineBase.resetMemo();
        pSDEViewEngineBase.resetNo2DEViewCtrlFlag();
        pSDEViewEngineBase.resetNo2DEViewCtrlLabel();
        pSDEViewEngineBase.resetNo2DEViewLogicFlag();
        pSDEViewEngineBase.resetNo2DEViewLogicLabel();
        pSDEViewEngineBase.resetNo2PSDEViewCtrlId();
        pSDEViewEngineBase.resetNo2PSDEViewCtrlName();
        pSDEViewEngineBase.resetNo2PSDEViewLogicId();
        pSDEViewEngineBase.resetNo2PSDEViewLogicName();
        pSDEViewEngineBase.resetNo3DEViewCtrlFlag();
        pSDEViewEngineBase.resetNo3DEViewCtrlLabel();
        pSDEViewEngineBase.resetNo3DEViewLogicFlag();
        pSDEViewEngineBase.resetNo3DEViewLogicLabel();
        pSDEViewEngineBase.resetNo3PSDEViewCtrlId();
        pSDEViewEngineBase.resetNo3PSDEViewCtrlName();
        pSDEViewEngineBase.resetNo3PSDEViewLogicId();
        pSDEViewEngineBase.resetNo3PSDEViewLogicName();
        pSDEViewEngineBase.resetNo4DEViewCtrlFlag();
        pSDEViewEngineBase.resetNo4DEViewCtrlLabel();
        pSDEViewEngineBase.resetNo4DEViewLogicFlag();
        pSDEViewEngineBase.resetNo4DEViewLogicLabel();
        pSDEViewEngineBase.resetNo4PSDEViewCtrlId();
        pSDEViewEngineBase.resetNo4PSDEViewCtrlName();
        pSDEViewEngineBase.resetNo4PSDEViewLogicId();
        pSDEViewEngineBase.resetNo4PSDEViewLogicName();
        pSDEViewEngineBase.resetOrderValue();
        pSDEViewEngineBase.resetPSDEViewBaseId();
        pSDEViewEngineBase.resetPSDEViewBaseName();
        pSDEViewEngineBase.resetPSDEViewCtrlId();
        pSDEViewEngineBase.resetPSDEViewCtrlName();
        pSDEViewEngineBase.resetPSDEViewEngineId();
        pSDEViewEngineBase.resetPSDEViewEngineName();
        pSDEViewEngineBase.resetPSDEViewLogicId();
        pSDEViewEngineBase.resetPSDEViewLogicName();
        pSDEViewEngineBase.resetPSSysPFPluginId();
        pSDEViewEngineBase.resetPSSysPFPluginName();
        pSDEViewEngineBase.resetPSUIEngineTypeId();
        pSDEViewEngineBase.resetPSUIEngineTypeName();
        pSDEViewEngineBase.resetUpdateDate();
        pSDEViewEngineBase.resetUpdateMan();
        pSDEViewEngineBase.resetUserCat();
        pSDEViewEngineBase.resetUserTag();
        pSDEViewEngineBase.resetUserTag2();
        pSDEViewEngineBase.resetUserTag3();
        pSDEViewEngineBase.resetUserTag4();
        pSDEViewEngineBase.resetValidFlag();
        pSDEViewEngineBase.resetViewParam();
        pSDEViewEngineBase.resetViewParam10();
        pSDEViewEngineBase.resetViewParam2();
        pSDEViewEngineBase.resetViewParam3();
        pSDEViewEngineBase.resetViewParam4();
        pSDEViewEngineBase.resetViewParam5();
        pSDEViewEngineBase.resetViewParam6();
        pSDEViewEngineBase.resetViewParam7();
        pSDEViewEngineBase.resetViewParam8();
        pSDEViewEngineBase.resetViewParam9();
        pSDEViewEngineBase.resetWFViewParam();
        pSDEViewEngineBase.resetWFViewParam2();
        pSDEViewEngineBase.resetWFViewParam3();
        pSDEViewEngineBase.resetWFViewParam4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEViewCtrlFlagDirty()) {
            hashMap.put(FIELD_DEVIEWCTRLFLAG, this.getDEViewCtrlFlag());
        }
        if (!bl || this.isDEViewCtrlLabelDirty()) {
            hashMap.put(FIELD_DEVIEWCTRLLABEL, this.getDEViewCtrlLabel());
        }
        if (!bl || this.isDEViewLogicFlagDirty()) {
            hashMap.put(FIELD_DEVIEWLOGICFLAG, this.getDEViewLogicFlag());
        }
        if (!bl || this.isDEViewLogicLabelDirty()) {
            hashMap.put(FIELD_DEVIEWLOGICLABEL, this.getDEViewLogicLabel());
        }
        if (!bl || this.isEngineOptionDirty()) {
            hashMap.put(FIELD_ENGINEOPTION, this.getEngineOption());
        }
        if (!bl || this.isEngineParamDirty()) {
            hashMap.put(FIELD_ENGINEPARAM, this.getEngineParam());
        }
        if (!bl || this.isEngineParam10Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM10, this.getEngineParam10());
        }
        if (!bl || this.isEngineParam10FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM10FLAG, this.getEngineParam10Flag());
        }
        if (!bl || this.isEngineParam10LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM10LABEL, this.getEngineParam10Label());
        }
        if (!bl || this.isEngineParam2Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM2, this.getEngineParam2());
        }
        if (!bl || this.isEngineParam2FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM2FLAG, this.getEngineParam2Flag());
        }
        if (!bl || this.isEngineParam2LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM2LABEL, this.getEngineParam2Label());
        }
        if (!bl || this.isEngineParam3Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM3, this.getEngineParam3());
        }
        if (!bl || this.isEngineParam3FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM3FLAG, this.getEngineParam3Flag());
        }
        if (!bl || this.isEngineParam3LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM3LABEL, this.getEngineParam3Label());
        }
        if (!bl || this.isEngineParam4Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM4, this.getEngineParam4());
        }
        if (!bl || this.isEngineParam4FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM4FLAG, this.getEngineParam4Flag());
        }
        if (!bl || this.isEngineParam4LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM4LABEL, this.getEngineParam4Label());
        }
        if (!bl || this.isEngineParam5Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM5, this.getEngineParam5());
        }
        if (!bl || this.isEngineParam5FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM5FLAG, this.getEngineParam5Flag());
        }
        if (!bl || this.isEngineParam5LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM5LABEL, this.getEngineParam5Label());
        }
        if (!bl || this.isEngineParam6Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM6, this.getEngineParam6());
        }
        if (!bl || this.isEngineParam6FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM6FLAG, this.getEngineParam6Flag());
        }
        if (!bl || this.isEngineParam6LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM6LABEL, this.getEngineParam6Label());
        }
        if (!bl || this.isEngineParam7Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM7, this.getEngineParam7());
        }
        if (!bl || this.isEngineParam7FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM7FLAG, this.getEngineParam7Flag());
        }
        if (!bl || this.isEngineParam7LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM7LABEL, this.getEngineParam7Label());
        }
        if (!bl || this.isEngineParam8Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM8, this.getEngineParam8());
        }
        if (!bl || this.isEngineParam8FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM8FLAG, this.getEngineParam8Flag());
        }
        if (!bl || this.isEngineParam8LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM8LABEL, this.getEngineParam8Label());
        }
        if (!bl || this.isEngineParam9Dirty()) {
            hashMap.put(FIELD_ENGINEPARAM9, this.getEngineParam9());
        }
        if (!bl || this.isEngineParam9FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM9FLAG, this.getEngineParam9Flag());
        }
        if (!bl || this.isEngineParam9LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM9LABEL, this.getEngineParam9Label());
        }
        if (!bl || this.isEngineParamFlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAMFLAG, this.getEngineParamFlag());
        }
        if (!bl || this.isEngineParamLabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAMLABEL, this.getEngineParamLabel());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNo2DEViewCtrlFlagDirty()) {
            hashMap.put(FIELD_NO2DEVIEWCTRLFLAG, this.getNo2DEViewCtrlFlag());
        }
        if (!bl || this.isNo2DEViewCtrlLabelDirty()) {
            hashMap.put(FIELD_NO2DEVIEWCTRLLABEL, this.getNo2DEViewCtrlLabel());
        }
        if (!bl || this.isNo2DEViewLogicFlagDirty()) {
            hashMap.put(FIELD_NO2DEVIEWLOGICFLAG, this.getNo2DEViewLogicFlag());
        }
        if (!bl || this.isNo2DEViewLogicLabelDirty()) {
            hashMap.put(FIELD_NO2DEVIEWLOGICLABEL, this.getNo2DEViewLogicLabel());
        }
        if (!bl || this.isNo2PSDEViewCtrlIdDirty()) {
            hashMap.put(FIELD_NO2PSDEVIEWCTRLID, this.getNo2PSDEViewCtrlId());
        }
        if (!bl || this.isNo2PSDEViewCtrlNameDirty()) {
            hashMap.put(FIELD_NO2PSDEVIEWCTRLNAME, this.getNo2PSDEViewCtrlName());
        }
        if (!bl || this.isNo2PSDEViewLogicIdDirty()) {
            hashMap.put(FIELD_NO2PSDEVIEWLOGICID, this.getNo2PSDEViewLogicId());
        }
        if (!bl || this.isNo2PSDEViewLogicNameDirty()) {
            hashMap.put(FIELD_NO2PSDEVIEWLOGICNAME, this.getNo2PSDEViewLogicName());
        }
        if (!bl || this.isNo3DEViewCtrlFlagDirty()) {
            hashMap.put(FIELD_NO3DEVIEWCTRLFLAG, this.getNo3DEViewCtrlFlag());
        }
        if (!bl || this.isNo3DEViewCtrlLabelDirty()) {
            hashMap.put(FIELD_NO3DEVIEWCTRLLABEL, this.getNo3DEViewCtrlLabel());
        }
        if (!bl || this.isNo3DEViewLogicFlagDirty()) {
            hashMap.put(FIELD_NO3DEVIEWLOGICFLAG, this.getNo3DEViewLogicFlag());
        }
        if (!bl || this.isNo3DEViewLogicLabelDirty()) {
            hashMap.put(FIELD_NO3DEVIEWLOGICLABEL, this.getNo3DEViewLogicLabel());
        }
        if (!bl || this.isNo3PSDEViewCtrlIdDirty()) {
            hashMap.put(FIELD_NO3PSDEVIEWCTRLID, this.getNo3PSDEViewCtrlId());
        }
        if (!bl || this.isNo3PSDEViewCtrlNameDirty()) {
            hashMap.put(FIELD_NO3PSDEVIEWCTRLNAME, this.getNo3PSDEViewCtrlName());
        }
        if (!bl || this.isNo3PSDEViewLogicIdDirty()) {
            hashMap.put(FIELD_NO3PSDEVIEWLOGICID, this.getNo3PSDEViewLogicId());
        }
        if (!bl || this.isNo3PSDEViewLogicNameDirty()) {
            hashMap.put(FIELD_NO3PSDEVIEWLOGICNAME, this.getNo3PSDEViewLogicName());
        }
        if (!bl || this.isNo4DEViewCtrlFlagDirty()) {
            hashMap.put(FIELD_NO4DEVIEWCTRLFLAG, this.getNo4DEViewCtrlFlag());
        }
        if (!bl || this.isNo4DEViewCtrlLabelDirty()) {
            hashMap.put(FIELD_NO4DEVIEWCTRLLABEL, this.getNo4DEViewCtrlLabel());
        }
        if (!bl || this.isNo4DEViewLogicFlagDirty()) {
            hashMap.put(FIELD_NO4DEVIEWLOGICFLAG, this.getNo4DEViewLogicFlag());
        }
        if (!bl || this.isNo4DEViewLogicLabelDirty()) {
            hashMap.put(FIELD_NO4DEVIEWLOGICLABEL, this.getNo4DEViewLogicLabel());
        }
        if (!bl || this.isNo4PSDEViewCtrlIdDirty()) {
            hashMap.put(FIELD_NO4PSDEVIEWCTRLID, this.getNo4PSDEViewCtrlId());
        }
        if (!bl || this.isNo4PSDEViewCtrlNameDirty()) {
            hashMap.put(FIELD_NO4PSDEVIEWCTRLNAME, this.getNo4PSDEViewCtrlName());
        }
        if (!bl || this.isNo4PSDEViewLogicIdDirty()) {
            hashMap.put(FIELD_NO4PSDEVIEWLOGICID, this.getNo4PSDEViewLogicId());
        }
        if (!bl || this.isNo4PSDEViewLogicNameDirty()) {
            hashMap.put(FIELD_NO4PSDEVIEWLOGICNAME, this.getNo4PSDEViewLogicName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewCtrlIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLID, this.getPSDEViewCtrlId());
        }
        if (!bl || this.isPSDEViewCtrlNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLNAME, this.getPSDEViewCtrlName());
        }
        if (!bl || this.isPSDEViewEngineIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWENGINEID, this.getPSDEViewEngineId());
        }
        if (!bl || this.isPSDEViewEngineNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWENGINENAME, this.getPSDEViewEngineName());
        }
        if (!bl || this.isPSDEViewLogicIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWLOGICID, this.getPSDEViewLogicId());
        }
        if (!bl || this.isPSDEViewLogicNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWLOGICNAME, this.getPSDEViewLogicName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSUIEngineTypeIdDirty()) {
            hashMap.put(FIELD_PSUIENGINETYPEID, this.getPSUIEngineTypeId());
        }
        if (!bl || this.isPSUIEngineTypeNameDirty()) {
            hashMap.put(FIELD_PSUIENGINETYPENAME, this.getPSUIEngineTypeName());
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
        if (!bl || this.isViewParamDirty()) {
            hashMap.put(FIELD_VIEWPARAM, this.getViewParam());
        }
        if (!bl || this.isViewParam10Dirty()) {
            hashMap.put(FIELD_VIEWPARAM10, this.getViewParam10());
        }
        if (!bl || this.isViewParam2Dirty()) {
            hashMap.put(FIELD_VIEWPARAM2, this.getViewParam2());
        }
        if (!bl || this.isViewParam3Dirty()) {
            hashMap.put(FIELD_VIEWPARAM3, this.getViewParam3());
        }
        if (!bl || this.isViewParam4Dirty()) {
            hashMap.put(FIELD_VIEWPARAM4, this.getViewParam4());
        }
        if (!bl || this.isViewParam5Dirty()) {
            hashMap.put(FIELD_VIEWPARAM5, this.getViewParam5());
        }
        if (!bl || this.isViewParam6Dirty()) {
            hashMap.put(FIELD_VIEWPARAM6, this.getViewParam6());
        }
        if (!bl || this.isViewParam7Dirty()) {
            hashMap.put(FIELD_VIEWPARAM7, this.getViewParam7());
        }
        if (!bl || this.isViewParam8Dirty()) {
            hashMap.put(FIELD_VIEWPARAM8, this.getViewParam8());
        }
        if (!bl || this.isViewParam9Dirty()) {
            hashMap.put(FIELD_VIEWPARAM9, this.getViewParam9());
        }
        if (!bl || this.isWFViewParamDirty()) {
            hashMap.put(FIELD_WFVIEWPARAM, this.getWFViewParam());
        }
        if (!bl || this.isWFViewParam2Dirty()) {
            hashMap.put(FIELD_WFVIEWPARAM2, this.getWFViewParam2());
        }
        if (!bl || this.isWFViewParam3Dirty()) {
            hashMap.put(FIELD_WFVIEWPARAM3, this.getWFViewParam3());
        }
        if (!bl || this.isWFViewParam4Dirty()) {
            hashMap.put(FIELD_WFVIEWPARAM4, this.getWFViewParam4());
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
        return PSDEViewEngineBase.get(this, n);
    }

    private static Object get(PSDEViewEngineBase pSDEViewEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewEngineBase.getCreateDate();
            }
            case 1: {
                return pSDEViewEngineBase.getCreateMan();
            }
            case 2: {
                return pSDEViewEngineBase.getDEViewCtrlFlag();
            }
            case 3: {
                return pSDEViewEngineBase.getDEViewCtrlLabel();
            }
            case 4: {
                return pSDEViewEngineBase.getDEViewLogicFlag();
            }
            case 5: {
                return pSDEViewEngineBase.getDEViewLogicLabel();
            }
            case 6: {
                return pSDEViewEngineBase.getEngineOption();
            }
            case 7: {
                return pSDEViewEngineBase.getEngineParam();
            }
            case 8: {
                return pSDEViewEngineBase.getEngineParam10();
            }
            case 9: {
                return pSDEViewEngineBase.getEngineParam10Flag();
            }
            case 10: {
                return pSDEViewEngineBase.getEngineParam10Label();
            }
            case 11: {
                return pSDEViewEngineBase.getEngineParam2();
            }
            case 12: {
                return pSDEViewEngineBase.getEngineParam2Flag();
            }
            case 13: {
                return pSDEViewEngineBase.getEngineParam2Label();
            }
            case 14: {
                return pSDEViewEngineBase.getEngineParam3();
            }
            case 15: {
                return pSDEViewEngineBase.getEngineParam3Flag();
            }
            case 16: {
                return pSDEViewEngineBase.getEngineParam3Label();
            }
            case 17: {
                return pSDEViewEngineBase.getEngineParam4();
            }
            case 18: {
                return pSDEViewEngineBase.getEngineParam4Flag();
            }
            case 19: {
                return pSDEViewEngineBase.getEngineParam4Label();
            }
            case 20: {
                return pSDEViewEngineBase.getEngineParam5();
            }
            case 21: {
                return pSDEViewEngineBase.getEngineParam5Flag();
            }
            case 22: {
                return pSDEViewEngineBase.getEngineParam5Label();
            }
            case 23: {
                return pSDEViewEngineBase.getEngineParam6();
            }
            case 24: {
                return pSDEViewEngineBase.getEngineParam6Flag();
            }
            case 25: {
                return pSDEViewEngineBase.getEngineParam6Label();
            }
            case 26: {
                return pSDEViewEngineBase.getEngineParam7();
            }
            case 27: {
                return pSDEViewEngineBase.getEngineParam7Flag();
            }
            case 28: {
                return pSDEViewEngineBase.getEngineParam7Label();
            }
            case 29: {
                return pSDEViewEngineBase.getEngineParam8();
            }
            case 30: {
                return pSDEViewEngineBase.getEngineParam8Flag();
            }
            case 31: {
                return pSDEViewEngineBase.getEngineParam8Label();
            }
            case 32: {
                return pSDEViewEngineBase.getEngineParam9();
            }
            case 33: {
                return pSDEViewEngineBase.getEngineParam9Flag();
            }
            case 34: {
                return pSDEViewEngineBase.getEngineParam9Label();
            }
            case 35: {
                return pSDEViewEngineBase.getEngineParamFlag();
            }
            case 36: {
                return pSDEViewEngineBase.getEngineParamLabel();
            }
            case 37: {
                return pSDEViewEngineBase.getMemo();
            }
            case 38: {
                return pSDEViewEngineBase.getNo2DEViewCtrlFlag();
            }
            case 39: {
                return pSDEViewEngineBase.getNo2DEViewCtrlLabel();
            }
            case 40: {
                return pSDEViewEngineBase.getNo2DEViewLogicFlag();
            }
            case 41: {
                return pSDEViewEngineBase.getNo2DEViewLogicLabel();
            }
            case 42: {
                return pSDEViewEngineBase.getNo2PSDEViewCtrlId();
            }
            case 43: {
                return pSDEViewEngineBase.getNo2PSDEViewCtrlName();
            }
            case 44: {
                return pSDEViewEngineBase.getNo2PSDEViewLogicId();
            }
            case 45: {
                return pSDEViewEngineBase.getNo2PSDEViewLogicName();
            }
            case 46: {
                return pSDEViewEngineBase.getNo3DEViewCtrlFlag();
            }
            case 47: {
                return pSDEViewEngineBase.getNo3DEViewCtrlLabel();
            }
            case 48: {
                return pSDEViewEngineBase.getNo3DEViewLogicFlag();
            }
            case 49: {
                return pSDEViewEngineBase.getNo3DEViewLogicLabel();
            }
            case 50: {
                return pSDEViewEngineBase.getNo3PSDEViewCtrlId();
            }
            case 51: {
                return pSDEViewEngineBase.getNo3PSDEViewCtrlName();
            }
            case 52: {
                return pSDEViewEngineBase.getNo3PSDEViewLogicId();
            }
            case 53: {
                return pSDEViewEngineBase.getNo3PSDEViewLogicName();
            }
            case 54: {
                return pSDEViewEngineBase.getNo4DEViewCtrlFlag();
            }
            case 55: {
                return pSDEViewEngineBase.getNo4DEViewCtrlLabel();
            }
            case 56: {
                return pSDEViewEngineBase.getNo4DEViewLogicFlag();
            }
            case 57: {
                return pSDEViewEngineBase.getNo4DEViewLogicLabel();
            }
            case 58: {
                return pSDEViewEngineBase.getNo4PSDEViewCtrlId();
            }
            case 59: {
                return pSDEViewEngineBase.getNo4PSDEViewCtrlName();
            }
            case 60: {
                return pSDEViewEngineBase.getNo4PSDEViewLogicId();
            }
            case 61: {
                return pSDEViewEngineBase.getNo4PSDEViewLogicName();
            }
            case 62: {
                return pSDEViewEngineBase.getOrderValue();
            }
            case 63: {
                return pSDEViewEngineBase.getPSDEViewBaseId();
            }
            case 64: {
                return pSDEViewEngineBase.getPSDEViewBaseName();
            }
            case 65: {
                return pSDEViewEngineBase.getPSDEViewCtrlId();
            }
            case 66: {
                return pSDEViewEngineBase.getPSDEViewCtrlName();
            }
            case 67: {
                return pSDEViewEngineBase.getPSDEViewEngineId();
            }
            case 68: {
                return pSDEViewEngineBase.getPSDEViewEngineName();
            }
            case 69: {
                return pSDEViewEngineBase.getPSDEViewLogicId();
            }
            case 70: {
                return pSDEViewEngineBase.getPSDEViewLogicName();
            }
            case 71: {
                return pSDEViewEngineBase.getPSSysPFPluginId();
            }
            case 72: {
                return pSDEViewEngineBase.getPSSysPFPluginName();
            }
            case 73: {
                return pSDEViewEngineBase.getPSUIEngineTypeId();
            }
            case 74: {
                return pSDEViewEngineBase.getPSUIEngineTypeName();
            }
            case 75: {
                return pSDEViewEngineBase.getUpdateDate();
            }
            case 76: {
                return pSDEViewEngineBase.getUpdateMan();
            }
            case 77: {
                return pSDEViewEngineBase.getUserCat();
            }
            case 78: {
                return pSDEViewEngineBase.getUserTag();
            }
            case 79: {
                return pSDEViewEngineBase.getUserTag2();
            }
            case 80: {
                return pSDEViewEngineBase.getUserTag3();
            }
            case 81: {
                return pSDEViewEngineBase.getUserTag4();
            }
            case 82: {
                return pSDEViewEngineBase.getValidFlag();
            }
            case 83: {
                return pSDEViewEngineBase.getViewParam();
            }
            case 84: {
                return pSDEViewEngineBase.getViewParam10();
            }
            case 85: {
                return pSDEViewEngineBase.getViewParam2();
            }
            case 86: {
                return pSDEViewEngineBase.getViewParam3();
            }
            case 87: {
                return pSDEViewEngineBase.getViewParam4();
            }
            case 88: {
                return pSDEViewEngineBase.getViewParam5();
            }
            case 89: {
                return pSDEViewEngineBase.getViewParam6();
            }
            case 90: {
                return pSDEViewEngineBase.getViewParam7();
            }
            case 91: {
                return pSDEViewEngineBase.getViewParam8();
            }
            case 92: {
                return pSDEViewEngineBase.getViewParam9();
            }
            case 93: {
                return pSDEViewEngineBase.getWFViewParam();
            }
            case 94: {
                return pSDEViewEngineBase.getWFViewParam2();
            }
            case 95: {
                return pSDEViewEngineBase.getWFViewParam3();
            }
            case 96: {
                return pSDEViewEngineBase.getWFViewParam4();
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
        PSDEViewEngineBase.set(this, n, object);
    }

    private static void set(PSDEViewEngineBase pSDEViewEngineBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewEngineBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewEngineBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewEngineBase.setDEViewCtrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewEngineBase.setDEViewCtrlLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewEngineBase.setDEViewLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewEngineBase.setDEViewLogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewEngineBase.setEngineOption(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewEngineBase.setEngineParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewEngineBase.setEngineParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewEngineBase.setEngineParam10Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewEngineBase.setEngineParam10Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewEngineBase.setEngineParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewEngineBase.setEngineParam2Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEViewEngineBase.setEngineParam2Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEViewEngineBase.setEngineParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEViewEngineBase.setEngineParam3Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEViewEngineBase.setEngineParam3Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEViewEngineBase.setEngineParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEViewEngineBase.setEngineParam4Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEViewEngineBase.setEngineParam4Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEViewEngineBase.setEngineParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEViewEngineBase.setEngineParam5Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEViewEngineBase.setEngineParam5Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEViewEngineBase.setEngineParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEViewEngineBase.setEngineParam6Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEViewEngineBase.setEngineParam6Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEViewEngineBase.setEngineParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEViewEngineBase.setEngineParam7Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEViewEngineBase.setEngineParam7Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEViewEngineBase.setEngineParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEViewEngineBase.setEngineParam8Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEViewEngineBase.setEngineParam8Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEViewEngineBase.setEngineParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEViewEngineBase.setEngineParam9Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEViewEngineBase.setEngineParam9Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEViewEngineBase.setEngineParamFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDEViewEngineBase.setEngineParamLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEViewEngineBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEViewEngineBase.setNo2DEViewCtrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEViewEngineBase.setNo2DEViewCtrlLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEViewEngineBase.setNo2DEViewLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSDEViewEngineBase.setNo2DEViewLogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEViewEngineBase.setNo2PSDEViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEViewEngineBase.setNo2PSDEViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEViewEngineBase.setNo2PSDEViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEViewEngineBase.setNo2PSDEViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEViewEngineBase.setNo3DEViewCtrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSDEViewEngineBase.setNo3DEViewCtrlLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEViewEngineBase.setNo3DEViewLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 49: {
                pSDEViewEngineBase.setNo3DEViewLogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEViewEngineBase.setNo3PSDEViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEViewEngineBase.setNo3PSDEViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEViewEngineBase.setNo3PSDEViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEViewEngineBase.setNo3PSDEViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEViewEngineBase.setNo4DEViewCtrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSDEViewEngineBase.setNo4DEViewCtrlLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEViewEngineBase.setNo4DEViewLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSDEViewEngineBase.setNo4DEViewLogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEViewEngineBase.setNo4PSDEViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEViewEngineBase.setNo4PSDEViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEViewEngineBase.setNo4PSDEViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEViewEngineBase.setNo4PSDEViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEViewEngineBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 63: {
                pSDEViewEngineBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEViewEngineBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEViewEngineBase.setPSDEViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEViewEngineBase.setPSDEViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEViewEngineBase.setPSDEViewEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEViewEngineBase.setPSDEViewEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEViewEngineBase.setPSDEViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEViewEngineBase.setPSDEViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEViewEngineBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEViewEngineBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEViewEngineBase.setPSUIEngineTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEViewEngineBase.setPSUIEngineTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEViewEngineBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 76: {
                pSDEViewEngineBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEViewEngineBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEViewEngineBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEViewEngineBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEViewEngineBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEViewEngineBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEViewEngineBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSDEViewEngineBase.setViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEViewEngineBase.setViewParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 85: {
                pSDEViewEngineBase.setViewParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEViewEngineBase.setViewParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 87: {
                pSDEViewEngineBase.setViewParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 88: {
                pSDEViewEngineBase.setViewParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 89: {
                pSDEViewEngineBase.setViewParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 90: {
                pSDEViewEngineBase.setViewParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEViewEngineBase.setViewParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEViewEngineBase.setViewParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 93: {
                pSDEViewEngineBase.setWFViewParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 94: {
                pSDEViewEngineBase.setWFViewParam2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 95: {
                pSDEViewEngineBase.setWFViewParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEViewEngineBase.setWFViewParam4(DataObject.getStringValue((Object)object));
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
        return PSDEViewEngineBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewEngineBase pSDEViewEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewEngineBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEViewEngineBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEViewEngineBase.getDEViewCtrlFlag() == null;
            }
            case 3: {
                return pSDEViewEngineBase.getDEViewCtrlLabel() == null;
            }
            case 4: {
                return pSDEViewEngineBase.getDEViewLogicFlag() == null;
            }
            case 5: {
                return pSDEViewEngineBase.getDEViewLogicLabel() == null;
            }
            case 6: {
                return pSDEViewEngineBase.getEngineOption() == null;
            }
            case 7: {
                return pSDEViewEngineBase.getEngineParam() == null;
            }
            case 8: {
                return pSDEViewEngineBase.getEngineParam10() == null;
            }
            case 9: {
                return pSDEViewEngineBase.getEngineParam10Flag() == null;
            }
            case 10: {
                return pSDEViewEngineBase.getEngineParam10Label() == null;
            }
            case 11: {
                return pSDEViewEngineBase.getEngineParam2() == null;
            }
            case 12: {
                return pSDEViewEngineBase.getEngineParam2Flag() == null;
            }
            case 13: {
                return pSDEViewEngineBase.getEngineParam2Label() == null;
            }
            case 14: {
                return pSDEViewEngineBase.getEngineParam3() == null;
            }
            case 15: {
                return pSDEViewEngineBase.getEngineParam3Flag() == null;
            }
            case 16: {
                return pSDEViewEngineBase.getEngineParam3Label() == null;
            }
            case 17: {
                return pSDEViewEngineBase.getEngineParam4() == null;
            }
            case 18: {
                return pSDEViewEngineBase.getEngineParam4Flag() == null;
            }
            case 19: {
                return pSDEViewEngineBase.getEngineParam4Label() == null;
            }
            case 20: {
                return pSDEViewEngineBase.getEngineParam5() == null;
            }
            case 21: {
                return pSDEViewEngineBase.getEngineParam5Flag() == null;
            }
            case 22: {
                return pSDEViewEngineBase.getEngineParam5Label() == null;
            }
            case 23: {
                return pSDEViewEngineBase.getEngineParam6() == null;
            }
            case 24: {
                return pSDEViewEngineBase.getEngineParam6Flag() == null;
            }
            case 25: {
                return pSDEViewEngineBase.getEngineParam6Label() == null;
            }
            case 26: {
                return pSDEViewEngineBase.getEngineParam7() == null;
            }
            case 27: {
                return pSDEViewEngineBase.getEngineParam7Flag() == null;
            }
            case 28: {
                return pSDEViewEngineBase.getEngineParam7Label() == null;
            }
            case 29: {
                return pSDEViewEngineBase.getEngineParam8() == null;
            }
            case 30: {
                return pSDEViewEngineBase.getEngineParam8Flag() == null;
            }
            case 31: {
                return pSDEViewEngineBase.getEngineParam8Label() == null;
            }
            case 32: {
                return pSDEViewEngineBase.getEngineParam9() == null;
            }
            case 33: {
                return pSDEViewEngineBase.getEngineParam9Flag() == null;
            }
            case 34: {
                return pSDEViewEngineBase.getEngineParam9Label() == null;
            }
            case 35: {
                return pSDEViewEngineBase.getEngineParamFlag() == null;
            }
            case 36: {
                return pSDEViewEngineBase.getEngineParamLabel() == null;
            }
            case 37: {
                return pSDEViewEngineBase.getMemo() == null;
            }
            case 38: {
                return pSDEViewEngineBase.getNo2DEViewCtrlFlag() == null;
            }
            case 39: {
                return pSDEViewEngineBase.getNo2DEViewCtrlLabel() == null;
            }
            case 40: {
                return pSDEViewEngineBase.getNo2DEViewLogicFlag() == null;
            }
            case 41: {
                return pSDEViewEngineBase.getNo2DEViewLogicLabel() == null;
            }
            case 42: {
                return pSDEViewEngineBase.getNo2PSDEViewCtrlId() == null;
            }
            case 43: {
                return pSDEViewEngineBase.getNo2PSDEViewCtrlName() == null;
            }
            case 44: {
                return pSDEViewEngineBase.getNo2PSDEViewLogicId() == null;
            }
            case 45: {
                return pSDEViewEngineBase.getNo2PSDEViewLogicName() == null;
            }
            case 46: {
                return pSDEViewEngineBase.getNo3DEViewCtrlFlag() == null;
            }
            case 47: {
                return pSDEViewEngineBase.getNo3DEViewCtrlLabel() == null;
            }
            case 48: {
                return pSDEViewEngineBase.getNo3DEViewLogicFlag() == null;
            }
            case 49: {
                return pSDEViewEngineBase.getNo3DEViewLogicLabel() == null;
            }
            case 50: {
                return pSDEViewEngineBase.getNo3PSDEViewCtrlId() == null;
            }
            case 51: {
                return pSDEViewEngineBase.getNo3PSDEViewCtrlName() == null;
            }
            case 52: {
                return pSDEViewEngineBase.getNo3PSDEViewLogicId() == null;
            }
            case 53: {
                return pSDEViewEngineBase.getNo3PSDEViewLogicName() == null;
            }
            case 54: {
                return pSDEViewEngineBase.getNo4DEViewCtrlFlag() == null;
            }
            case 55: {
                return pSDEViewEngineBase.getNo4DEViewCtrlLabel() == null;
            }
            case 56: {
                return pSDEViewEngineBase.getNo4DEViewLogicFlag() == null;
            }
            case 57: {
                return pSDEViewEngineBase.getNo4DEViewLogicLabel() == null;
            }
            case 58: {
                return pSDEViewEngineBase.getNo4PSDEViewCtrlId() == null;
            }
            case 59: {
                return pSDEViewEngineBase.getNo4PSDEViewCtrlName() == null;
            }
            case 60: {
                return pSDEViewEngineBase.getNo4PSDEViewLogicId() == null;
            }
            case 61: {
                return pSDEViewEngineBase.getNo4PSDEViewLogicName() == null;
            }
            case 62: {
                return pSDEViewEngineBase.getOrderValue() == null;
            }
            case 63: {
                return pSDEViewEngineBase.getPSDEViewBaseId() == null;
            }
            case 64: {
                return pSDEViewEngineBase.getPSDEViewBaseName() == null;
            }
            case 65: {
                return pSDEViewEngineBase.getPSDEViewCtrlId() == null;
            }
            case 66: {
                return pSDEViewEngineBase.getPSDEViewCtrlName() == null;
            }
            case 67: {
                return pSDEViewEngineBase.getPSDEViewEngineId() == null;
            }
            case 68: {
                return pSDEViewEngineBase.getPSDEViewEngineName() == null;
            }
            case 69: {
                return pSDEViewEngineBase.getPSDEViewLogicId() == null;
            }
            case 70: {
                return pSDEViewEngineBase.getPSDEViewLogicName() == null;
            }
            case 71: {
                return pSDEViewEngineBase.getPSSysPFPluginId() == null;
            }
            case 72: {
                return pSDEViewEngineBase.getPSSysPFPluginName() == null;
            }
            case 73: {
                return pSDEViewEngineBase.getPSUIEngineTypeId() == null;
            }
            case 74: {
                return pSDEViewEngineBase.getPSUIEngineTypeName() == null;
            }
            case 75: {
                return pSDEViewEngineBase.getUpdateDate() == null;
            }
            case 76: {
                return pSDEViewEngineBase.getUpdateMan() == null;
            }
            case 77: {
                return pSDEViewEngineBase.getUserCat() == null;
            }
            case 78: {
                return pSDEViewEngineBase.getUserTag() == null;
            }
            case 79: {
                return pSDEViewEngineBase.getUserTag2() == null;
            }
            case 80: {
                return pSDEViewEngineBase.getUserTag3() == null;
            }
            case 81: {
                return pSDEViewEngineBase.getUserTag4() == null;
            }
            case 82: {
                return pSDEViewEngineBase.getValidFlag() == null;
            }
            case 83: {
                return pSDEViewEngineBase.getViewParam() == null;
            }
            case 84: {
                return pSDEViewEngineBase.getViewParam10() == null;
            }
            case 85: {
                return pSDEViewEngineBase.getViewParam2() == null;
            }
            case 86: {
                return pSDEViewEngineBase.getViewParam3() == null;
            }
            case 87: {
                return pSDEViewEngineBase.getViewParam4() == null;
            }
            case 88: {
                return pSDEViewEngineBase.getViewParam5() == null;
            }
            case 89: {
                return pSDEViewEngineBase.getViewParam6() == null;
            }
            case 90: {
                return pSDEViewEngineBase.getViewParam7() == null;
            }
            case 91: {
                return pSDEViewEngineBase.getViewParam8() == null;
            }
            case 92: {
                return pSDEViewEngineBase.getViewParam9() == null;
            }
            case 93: {
                return pSDEViewEngineBase.getWFViewParam() == null;
            }
            case 94: {
                return pSDEViewEngineBase.getWFViewParam2() == null;
            }
            case 95: {
                return pSDEViewEngineBase.getWFViewParam3() == null;
            }
            case 96: {
                return pSDEViewEngineBase.getWFViewParam4() == null;
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
        return PSDEViewEngineBase.contains(this, n);
    }

    private static boolean contains(PSDEViewEngineBase pSDEViewEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewEngineBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEViewEngineBase.isCreateManDirty();
            }
            case 2: {
                return pSDEViewEngineBase.isDEViewCtrlFlagDirty();
            }
            case 3: {
                return pSDEViewEngineBase.isDEViewCtrlLabelDirty();
            }
            case 4: {
                return pSDEViewEngineBase.isDEViewLogicFlagDirty();
            }
            case 5: {
                return pSDEViewEngineBase.isDEViewLogicLabelDirty();
            }
            case 6: {
                return pSDEViewEngineBase.isEngineOptionDirty();
            }
            case 7: {
                return pSDEViewEngineBase.isEngineParamDirty();
            }
            case 8: {
                return pSDEViewEngineBase.isEngineParam10Dirty();
            }
            case 9: {
                return pSDEViewEngineBase.isEngineParam10FlagDirty();
            }
            case 10: {
                return pSDEViewEngineBase.isEngineParam10LabelDirty();
            }
            case 11: {
                return pSDEViewEngineBase.isEngineParam2Dirty();
            }
            case 12: {
                return pSDEViewEngineBase.isEngineParam2FlagDirty();
            }
            case 13: {
                return pSDEViewEngineBase.isEngineParam2LabelDirty();
            }
            case 14: {
                return pSDEViewEngineBase.isEngineParam3Dirty();
            }
            case 15: {
                return pSDEViewEngineBase.isEngineParam3FlagDirty();
            }
            case 16: {
                return pSDEViewEngineBase.isEngineParam3LabelDirty();
            }
            case 17: {
                return pSDEViewEngineBase.isEngineParam4Dirty();
            }
            case 18: {
                return pSDEViewEngineBase.isEngineParam4FlagDirty();
            }
            case 19: {
                return pSDEViewEngineBase.isEngineParam4LabelDirty();
            }
            case 20: {
                return pSDEViewEngineBase.isEngineParam5Dirty();
            }
            case 21: {
                return pSDEViewEngineBase.isEngineParam5FlagDirty();
            }
            case 22: {
                return pSDEViewEngineBase.isEngineParam5LabelDirty();
            }
            case 23: {
                return pSDEViewEngineBase.isEngineParam6Dirty();
            }
            case 24: {
                return pSDEViewEngineBase.isEngineParam6FlagDirty();
            }
            case 25: {
                return pSDEViewEngineBase.isEngineParam6LabelDirty();
            }
            case 26: {
                return pSDEViewEngineBase.isEngineParam7Dirty();
            }
            case 27: {
                return pSDEViewEngineBase.isEngineParam7FlagDirty();
            }
            case 28: {
                return pSDEViewEngineBase.isEngineParam7LabelDirty();
            }
            case 29: {
                return pSDEViewEngineBase.isEngineParam8Dirty();
            }
            case 30: {
                return pSDEViewEngineBase.isEngineParam8FlagDirty();
            }
            case 31: {
                return pSDEViewEngineBase.isEngineParam8LabelDirty();
            }
            case 32: {
                return pSDEViewEngineBase.isEngineParam9Dirty();
            }
            case 33: {
                return pSDEViewEngineBase.isEngineParam9FlagDirty();
            }
            case 34: {
                return pSDEViewEngineBase.isEngineParam9LabelDirty();
            }
            case 35: {
                return pSDEViewEngineBase.isEngineParamFlagDirty();
            }
            case 36: {
                return pSDEViewEngineBase.isEngineParamLabelDirty();
            }
            case 37: {
                return pSDEViewEngineBase.isMemoDirty();
            }
            case 38: {
                return pSDEViewEngineBase.isNo2DEViewCtrlFlagDirty();
            }
            case 39: {
                return pSDEViewEngineBase.isNo2DEViewCtrlLabelDirty();
            }
            case 40: {
                return pSDEViewEngineBase.isNo2DEViewLogicFlagDirty();
            }
            case 41: {
                return pSDEViewEngineBase.isNo2DEViewLogicLabelDirty();
            }
            case 42: {
                return pSDEViewEngineBase.isNo2PSDEViewCtrlIdDirty();
            }
            case 43: {
                return pSDEViewEngineBase.isNo2PSDEViewCtrlNameDirty();
            }
            case 44: {
                return pSDEViewEngineBase.isNo2PSDEViewLogicIdDirty();
            }
            case 45: {
                return pSDEViewEngineBase.isNo2PSDEViewLogicNameDirty();
            }
            case 46: {
                return pSDEViewEngineBase.isNo3DEViewCtrlFlagDirty();
            }
            case 47: {
                return pSDEViewEngineBase.isNo3DEViewCtrlLabelDirty();
            }
            case 48: {
                return pSDEViewEngineBase.isNo3DEViewLogicFlagDirty();
            }
            case 49: {
                return pSDEViewEngineBase.isNo3DEViewLogicLabelDirty();
            }
            case 50: {
                return pSDEViewEngineBase.isNo3PSDEViewCtrlIdDirty();
            }
            case 51: {
                return pSDEViewEngineBase.isNo3PSDEViewCtrlNameDirty();
            }
            case 52: {
                return pSDEViewEngineBase.isNo3PSDEViewLogicIdDirty();
            }
            case 53: {
                return pSDEViewEngineBase.isNo3PSDEViewLogicNameDirty();
            }
            case 54: {
                return pSDEViewEngineBase.isNo4DEViewCtrlFlagDirty();
            }
            case 55: {
                return pSDEViewEngineBase.isNo4DEViewCtrlLabelDirty();
            }
            case 56: {
                return pSDEViewEngineBase.isNo4DEViewLogicFlagDirty();
            }
            case 57: {
                return pSDEViewEngineBase.isNo4DEViewLogicLabelDirty();
            }
            case 58: {
                return pSDEViewEngineBase.isNo4PSDEViewCtrlIdDirty();
            }
            case 59: {
                return pSDEViewEngineBase.isNo4PSDEViewCtrlNameDirty();
            }
            case 60: {
                return pSDEViewEngineBase.isNo4PSDEViewLogicIdDirty();
            }
            case 61: {
                return pSDEViewEngineBase.isNo4PSDEViewLogicNameDirty();
            }
            case 62: {
                return pSDEViewEngineBase.isOrderValueDirty();
            }
            case 63: {
                return pSDEViewEngineBase.isPSDEViewBaseIdDirty();
            }
            case 64: {
                return pSDEViewEngineBase.isPSDEViewBaseNameDirty();
            }
            case 65: {
                return pSDEViewEngineBase.isPSDEViewCtrlIdDirty();
            }
            case 66: {
                return pSDEViewEngineBase.isPSDEViewCtrlNameDirty();
            }
            case 67: {
                return pSDEViewEngineBase.isPSDEViewEngineIdDirty();
            }
            case 68: {
                return pSDEViewEngineBase.isPSDEViewEngineNameDirty();
            }
            case 69: {
                return pSDEViewEngineBase.isPSDEViewLogicIdDirty();
            }
            case 70: {
                return pSDEViewEngineBase.isPSDEViewLogicNameDirty();
            }
            case 71: {
                return pSDEViewEngineBase.isPSSysPFPluginIdDirty();
            }
            case 72: {
                return pSDEViewEngineBase.isPSSysPFPluginNameDirty();
            }
            case 73: {
                return pSDEViewEngineBase.isPSUIEngineTypeIdDirty();
            }
            case 74: {
                return pSDEViewEngineBase.isPSUIEngineTypeNameDirty();
            }
            case 75: {
                return pSDEViewEngineBase.isUpdateDateDirty();
            }
            case 76: {
                return pSDEViewEngineBase.isUpdateManDirty();
            }
            case 77: {
                return pSDEViewEngineBase.isUserCatDirty();
            }
            case 78: {
                return pSDEViewEngineBase.isUserTagDirty();
            }
            case 79: {
                return pSDEViewEngineBase.isUserTag2Dirty();
            }
            case 80: {
                return pSDEViewEngineBase.isUserTag3Dirty();
            }
            case 81: {
                return pSDEViewEngineBase.isUserTag4Dirty();
            }
            case 82: {
                return pSDEViewEngineBase.isValidFlagDirty();
            }
            case 83: {
                return pSDEViewEngineBase.isViewParamDirty();
            }
            case 84: {
                return pSDEViewEngineBase.isViewParam10Dirty();
            }
            case 85: {
                return pSDEViewEngineBase.isViewParam2Dirty();
            }
            case 86: {
                return pSDEViewEngineBase.isViewParam3Dirty();
            }
            case 87: {
                return pSDEViewEngineBase.isViewParam4Dirty();
            }
            case 88: {
                return pSDEViewEngineBase.isViewParam5Dirty();
            }
            case 89: {
                return pSDEViewEngineBase.isViewParam6Dirty();
            }
            case 90: {
                return pSDEViewEngineBase.isViewParam7Dirty();
            }
            case 91: {
                return pSDEViewEngineBase.isViewParam8Dirty();
            }
            case 92: {
                return pSDEViewEngineBase.isViewParam9Dirty();
            }
            case 93: {
                return pSDEViewEngineBase.isWFViewParamDirty();
            }
            case 94: {
                return pSDEViewEngineBase.isWFViewParam2Dirty();
            }
            case 95: {
                return pSDEViewEngineBase.isWFViewParam3Dirty();
            }
            case 96: {
                return pSDEViewEngineBase.isWFViewParam4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewEngineBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewEngineBase pSDEViewEngineBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewEngineBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getDEViewCtrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewctrlflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getDEViewCtrlFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getDEViewCtrlLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewctrllabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getDEViewCtrlLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getDEViewLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewlogicflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getDEViewLogicFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getDEViewLogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewlogiclabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getDEViewLogicLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineoption", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineOption()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam10", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam10()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam10Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam10flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam10Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam10Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam10label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam10Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam2", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam2()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam2Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam2flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam2Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam2Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam2label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam2Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam3", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam3()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam3Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam3flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam3Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam3Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam3label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam3Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam4", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam4()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam4Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam4flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam4Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam4Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam4label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam4Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam5", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam5()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam5Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam5flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam5Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam5Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam5label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam5Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam6", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam6()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam6Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam6flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam6Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam6Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam6label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam6Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam7", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam7()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam7Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam7flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam7Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam7Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam7label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam7Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam8", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam8()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam8Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam8flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam8Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam8Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam8label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam8Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam9", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam9()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam9Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam9flag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam9Flag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParam9Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam9label", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParam9Label()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParamFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparamflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParamFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getEngineParamLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparamlabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getEngineParamLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo2DEViewCtrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2deviewctrlflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo2DEViewCtrlFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo2DEViewCtrlLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2deviewctrllabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo2DEViewCtrlLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo2DEViewLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2deviewlogicflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo2DEViewLogicFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo2DEViewLogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2deviewlogiclabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo2DEViewLogicLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo2PSDEViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeviewctrlid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo2PSDEViewCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo2PSDEViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeviewctrlname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo2PSDEViewCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo2PSDEViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeviewlogicid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo2PSDEViewLogicId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo2PSDEViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeviewlogicname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo2PSDEViewLogicName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo3DEViewCtrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3deviewctrlflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo3DEViewCtrlFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo3DEViewCtrlLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3deviewctrllabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo3DEViewCtrlLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo3DEViewLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3deviewlogicflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo3DEViewLogicFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo3DEViewLogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3deviewlogiclabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo3DEViewLogicLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo3PSDEViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3psdeviewctrlid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo3PSDEViewCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo3PSDEViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3psdeviewctrlname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo3PSDEViewCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo3PSDEViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3psdeviewlogicid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo3PSDEViewLogicId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo3PSDEViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3psdeviewlogicname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo3PSDEViewLogicName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo4DEViewCtrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4deviewctrlflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo4DEViewCtrlFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo4DEViewCtrlLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4deviewctrllabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo4DEViewCtrlLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo4DEViewLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4deviewlogicflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo4DEViewLogicFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo4DEViewLogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4deviewlogiclabel", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo4DEViewLogicLabel()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo4PSDEViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4psdeviewctrlid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo4PSDEViewCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo4PSDEViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4psdeviewctrlname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo4PSDEViewCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo4PSDEViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4psdeviewlogicid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo4PSDEViewLogicId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getNo4PSDEViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4psdeviewlogicname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getNo4PSDEViewLogicName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrlid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSDEViewCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrlname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSDEViewCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewengineid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSDEViewEngineId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewenginename", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSDEViewEngineName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewlogicid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSDEViewLogicId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewlogicname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSDEViewLogicName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSUIEngineTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypeid", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSUIEngineTypeId()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getPSUIEngineTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypename", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getPSUIEngineTypeName()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam10", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam10()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam2", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam2()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam3", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam3()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam4", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam4()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam5", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam5()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam6", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam6()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam7", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam7()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam8", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam8()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getViewParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam9", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getViewParam9()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getWFViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getWFViewParam()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getWFViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam2", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getWFViewParam2()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getWFViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam3", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getWFViewParam3()), (boolean)false);
        }
        if (bl || pSDEViewEngineBase.getWFViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam4", (Object)PSDEViewEngineBase.getJSONValue((Object)pSDEViewEngineBase.getWFViewParam4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewEngineBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewEngineBase pSDEViewEngineBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewEngineBase.getCreateDate() != null) {
            object = pSDEViewEngineBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getCreateMan() != null) {
            object = pSDEViewEngineBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getDEViewCtrlFlag() != null) {
            object = pSDEViewEngineBase.getDEViewCtrlFlag();
            xmlNode.setAttribute(FIELD_DEVIEWCTRLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getDEViewCtrlLabel() != null) {
            object = pSDEViewEngineBase.getDEViewCtrlLabel();
            xmlNode.setAttribute(FIELD_DEVIEWCTRLLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getDEViewLogicFlag() != null) {
            object = pSDEViewEngineBase.getDEViewLogicFlag();
            xmlNode.setAttribute(FIELD_DEVIEWLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getDEViewLogicLabel() != null) {
            object = pSDEViewEngineBase.getDEViewLogicLabel();
            xmlNode.setAttribute(FIELD_DEVIEWLOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineOption() != null) {
            object = pSDEViewEngineBase.getEngineOption();
            xmlNode.setAttribute(FIELD_ENGINEOPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam() != null) {
            object = pSDEViewEngineBase.getEngineParam();
            xmlNode.setAttribute(FIELD_ENGINEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam10() != null) {
            object = pSDEViewEngineBase.getEngineParam10();
            xmlNode.setAttribute(FIELD_ENGINEPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam10Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam10Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM10FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam10Label() != null) {
            object = pSDEViewEngineBase.getEngineParam10Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM10LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam2() != null) {
            object = pSDEViewEngineBase.getEngineParam2();
            xmlNode.setAttribute(FIELD_ENGINEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam2Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam2Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM2FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam2Label() != null) {
            object = pSDEViewEngineBase.getEngineParam2Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM2LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam3() != null) {
            object = pSDEViewEngineBase.getEngineParam3();
            xmlNode.setAttribute(FIELD_ENGINEPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam3Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam3Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM3FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam3Label() != null) {
            object = pSDEViewEngineBase.getEngineParam3Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM3LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam4() != null) {
            object = pSDEViewEngineBase.getEngineParam4();
            xmlNode.setAttribute(FIELD_ENGINEPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam4Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam4Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM4FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam4Label() != null) {
            object = pSDEViewEngineBase.getEngineParam4Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM4LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam5() != null) {
            object = pSDEViewEngineBase.getEngineParam5();
            xmlNode.setAttribute(FIELD_ENGINEPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam5Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam5Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM5FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam5Label() != null) {
            object = pSDEViewEngineBase.getEngineParam5Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM5LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam6() != null) {
            object = pSDEViewEngineBase.getEngineParam6();
            xmlNode.setAttribute(FIELD_ENGINEPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam6Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam6Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM6FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam6Label() != null) {
            object = pSDEViewEngineBase.getEngineParam6Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM6LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam7() != null) {
            object = pSDEViewEngineBase.getEngineParam7();
            xmlNode.setAttribute(FIELD_ENGINEPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam7Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam7Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM7FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam7Label() != null) {
            object = pSDEViewEngineBase.getEngineParam7Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM7LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam8() != null) {
            object = pSDEViewEngineBase.getEngineParam8();
            xmlNode.setAttribute(FIELD_ENGINEPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam8Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam8Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM8FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam8Label() != null) {
            object = pSDEViewEngineBase.getEngineParam8Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM8LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParam9() != null) {
            object = pSDEViewEngineBase.getEngineParam9();
            xmlNode.setAttribute(FIELD_ENGINEPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam9Flag() != null) {
            object = pSDEViewEngineBase.getEngineParam9Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM9FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParam9Label() != null) {
            object = pSDEViewEngineBase.getEngineParam9Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM9LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getEngineParamFlag() != null) {
            object = pSDEViewEngineBase.getEngineParamFlag();
            xmlNode.setAttribute(FIELD_ENGINEPARAMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getEngineParamLabel() != null) {
            object = pSDEViewEngineBase.getEngineParamLabel();
            xmlNode.setAttribute(FIELD_ENGINEPARAMLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getMemo() != null) {
            object = pSDEViewEngineBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo2DEViewCtrlFlag() != null) {
            object = pSDEViewEngineBase.getNo2DEViewCtrlFlag();
            xmlNode.setAttribute(FIELD_NO2DEVIEWCTRLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getNo2DEViewCtrlLabel() != null) {
            object = pSDEViewEngineBase.getNo2DEViewCtrlLabel();
            xmlNode.setAttribute(FIELD_NO2DEVIEWCTRLLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo2DEViewLogicFlag() != null) {
            object = pSDEViewEngineBase.getNo2DEViewLogicFlag();
            xmlNode.setAttribute(FIELD_NO2DEVIEWLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getNo2DEViewLogicLabel() != null) {
            object = pSDEViewEngineBase.getNo2DEViewLogicLabel();
            xmlNode.setAttribute(FIELD_NO2DEVIEWLOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo2PSDEViewCtrlId() != null) {
            object = pSDEViewEngineBase.getNo2PSDEViewCtrlId();
            xmlNode.setAttribute(FIELD_NO2PSDEVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo2PSDEViewCtrlName() != null) {
            object = pSDEViewEngineBase.getNo2PSDEViewCtrlName();
            xmlNode.setAttribute(FIELD_NO2PSDEVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo2PSDEViewLogicId() != null) {
            object = pSDEViewEngineBase.getNo2PSDEViewLogicId();
            xmlNode.setAttribute(FIELD_NO2PSDEVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo2PSDEViewLogicName() != null) {
            object = pSDEViewEngineBase.getNo2PSDEViewLogicName();
            xmlNode.setAttribute(FIELD_NO2PSDEVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo3DEViewCtrlFlag() != null) {
            object = pSDEViewEngineBase.getNo3DEViewCtrlFlag();
            xmlNode.setAttribute(FIELD_NO3DEVIEWCTRLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getNo3DEViewCtrlLabel() != null) {
            object = pSDEViewEngineBase.getNo3DEViewCtrlLabel();
            xmlNode.setAttribute(FIELD_NO3DEVIEWCTRLLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo3DEViewLogicFlag() != null) {
            object = pSDEViewEngineBase.getNo3DEViewLogicFlag();
            xmlNode.setAttribute(FIELD_NO3DEVIEWLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getNo3DEViewLogicLabel() != null) {
            object = pSDEViewEngineBase.getNo3DEViewLogicLabel();
            xmlNode.setAttribute(FIELD_NO3DEVIEWLOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo3PSDEViewCtrlId() != null) {
            object = pSDEViewEngineBase.getNo3PSDEViewCtrlId();
            xmlNode.setAttribute(FIELD_NO3PSDEVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo3PSDEViewCtrlName() != null) {
            object = pSDEViewEngineBase.getNo3PSDEViewCtrlName();
            xmlNode.setAttribute(FIELD_NO3PSDEVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo3PSDEViewLogicId() != null) {
            object = pSDEViewEngineBase.getNo3PSDEViewLogicId();
            xmlNode.setAttribute(FIELD_NO3PSDEVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo3PSDEViewLogicName() != null) {
            object = pSDEViewEngineBase.getNo3PSDEViewLogicName();
            xmlNode.setAttribute(FIELD_NO3PSDEVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo4DEViewCtrlFlag() != null) {
            object = pSDEViewEngineBase.getNo4DEViewCtrlFlag();
            xmlNode.setAttribute(FIELD_NO4DEVIEWCTRLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getNo4DEViewCtrlLabel() != null) {
            object = pSDEViewEngineBase.getNo4DEViewCtrlLabel();
            xmlNode.setAttribute(FIELD_NO4DEVIEWCTRLLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo4DEViewLogicFlag() != null) {
            object = pSDEViewEngineBase.getNo4DEViewLogicFlag();
            xmlNode.setAttribute(FIELD_NO4DEVIEWLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getNo4DEViewLogicLabel() != null) {
            object = pSDEViewEngineBase.getNo4DEViewLogicLabel();
            xmlNode.setAttribute(FIELD_NO4DEVIEWLOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo4PSDEViewCtrlId() != null) {
            object = pSDEViewEngineBase.getNo4PSDEViewCtrlId();
            xmlNode.setAttribute(FIELD_NO4PSDEVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo4PSDEViewCtrlName() != null) {
            object = pSDEViewEngineBase.getNo4PSDEViewCtrlName();
            xmlNode.setAttribute(FIELD_NO4PSDEVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo4PSDEViewLogicId() != null) {
            object = pSDEViewEngineBase.getNo4PSDEViewLogicId();
            xmlNode.setAttribute(FIELD_NO4PSDEVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getNo4PSDEViewLogicName() != null) {
            object = pSDEViewEngineBase.getNo4PSDEViewLogicName();
            xmlNode.setAttribute(FIELD_NO4PSDEVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getOrderValue() != null) {
            object = pSDEViewEngineBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getPSDEViewBaseId() != null) {
            object = pSDEViewEngineBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewBaseName() != null) {
            object = pSDEViewEngineBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewCtrlId() != null) {
            object = pSDEViewEngineBase.getPSDEViewCtrlId();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewCtrlName() != null) {
            object = pSDEViewEngineBase.getPSDEViewCtrlName();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewEngineId() != null) {
            object = pSDEViewEngineBase.getPSDEViewEngineId();
            xmlNode.setAttribute(FIELD_PSDEVIEWENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewEngineName() != null) {
            object = pSDEViewEngineBase.getPSDEViewEngineName();
            xmlNode.setAttribute(FIELD_PSDEVIEWENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewLogicId() != null) {
            object = pSDEViewEngineBase.getPSDEViewLogicId();
            xmlNode.setAttribute(FIELD_PSDEVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSDEViewLogicName() != null) {
            object = pSDEViewEngineBase.getPSDEViewLogicName();
            xmlNode.setAttribute(FIELD_PSDEVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSSysPFPluginId() != null) {
            object = pSDEViewEngineBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSSysPFPluginName() != null) {
            object = pSDEViewEngineBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSUIEngineTypeId() != null) {
            object = pSDEViewEngineBase.getPSUIEngineTypeId();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getPSUIEngineTypeName() != null) {
            object = pSDEViewEngineBase.getPSUIEngineTypeName();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getUpdateDate() != null) {
            object = pSDEViewEngineBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getUpdateMan() != null) {
            object = pSDEViewEngineBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getUserCat() != null) {
            object = pSDEViewEngineBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getUserTag() != null) {
            object = pSDEViewEngineBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getUserTag2() != null) {
            object = pSDEViewEngineBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getUserTag3() != null) {
            object = pSDEViewEngineBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getUserTag4() != null) {
            object = pSDEViewEngineBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getValidFlag() != null) {
            object = pSDEViewEngineBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getViewParam() != null) {
            object = pSDEViewEngineBase.getViewParam();
            xmlNode.setAttribute(FIELD_VIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getViewParam10() != null) {
            object = pSDEViewEngineBase.getViewParam10();
            xmlNode.setAttribute(FIELD_VIEWPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getViewParam2() != null) {
            object = pSDEViewEngineBase.getViewParam2();
            xmlNode.setAttribute(FIELD_VIEWPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getViewParam3() != null) {
            object = pSDEViewEngineBase.getViewParam3();
            xmlNode.setAttribute(FIELD_VIEWPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getViewParam4() != null) {
            object = pSDEViewEngineBase.getViewParam4();
            xmlNode.setAttribute(FIELD_VIEWPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getViewParam5() != null) {
            object = pSDEViewEngineBase.getViewParam5();
            xmlNode.setAttribute(FIELD_VIEWPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getViewParam6() != null) {
            object = pSDEViewEngineBase.getViewParam6();
            xmlNode.setAttribute(FIELD_VIEWPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getViewParam7() != null) {
            object = pSDEViewEngineBase.getViewParam7();
            xmlNode.setAttribute(FIELD_VIEWPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getViewParam8() != null) {
            object = pSDEViewEngineBase.getViewParam8();
            xmlNode.setAttribute(FIELD_VIEWPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getViewParam9() != null) {
            object = pSDEViewEngineBase.getViewParam9();
            xmlNode.setAttribute(FIELD_VIEWPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getWFViewParam() != null) {
            object = pSDEViewEngineBase.getWFViewParam();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getWFViewParam2() != null) {
            object = pSDEViewEngineBase.getWFViewParam2();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewEngineBase.getWFViewParam3() != null) {
            object = pSDEViewEngineBase.getWFViewParam3();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewEngineBase.getWFViewParam4() != null) {
            object = pSDEViewEngineBase.getWFViewParam4();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewEngineBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewEngineBase pSDEViewEngineBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewEngineBase.isCreateDateDirty() && (bl || pSDEViewEngineBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewEngineBase.getCreateDate());
        }
        if (pSDEViewEngineBase.isCreateManDirty() && (bl || pSDEViewEngineBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewEngineBase.getCreateMan());
        }
        if (pSDEViewEngineBase.isDEViewCtrlFlagDirty() && (bl || pSDEViewEngineBase.getDEViewCtrlFlag() != null)) {
            iDataObject.set(FIELD_DEVIEWCTRLFLAG, (Object)pSDEViewEngineBase.getDEViewCtrlFlag());
        }
        if (pSDEViewEngineBase.isDEViewCtrlLabelDirty() && (bl || pSDEViewEngineBase.getDEViewCtrlLabel() != null)) {
            iDataObject.set(FIELD_DEVIEWCTRLLABEL, (Object)pSDEViewEngineBase.getDEViewCtrlLabel());
        }
        if (pSDEViewEngineBase.isDEViewLogicFlagDirty() && (bl || pSDEViewEngineBase.getDEViewLogicFlag() != null)) {
            iDataObject.set(FIELD_DEVIEWLOGICFLAG, (Object)pSDEViewEngineBase.getDEViewLogicFlag());
        }
        if (pSDEViewEngineBase.isDEViewLogicLabelDirty() && (bl || pSDEViewEngineBase.getDEViewLogicLabel() != null)) {
            iDataObject.set(FIELD_DEVIEWLOGICLABEL, (Object)pSDEViewEngineBase.getDEViewLogicLabel());
        }
        if (pSDEViewEngineBase.isEngineOptionDirty() && (bl || pSDEViewEngineBase.getEngineOption() != null)) {
            iDataObject.set(FIELD_ENGINEOPTION, (Object)pSDEViewEngineBase.getEngineOption());
        }
        if (pSDEViewEngineBase.isEngineParamDirty() && (bl || pSDEViewEngineBase.getEngineParam() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM, (Object)pSDEViewEngineBase.getEngineParam());
        }
        if (pSDEViewEngineBase.isEngineParam10Dirty() && (bl || pSDEViewEngineBase.getEngineParam10() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM10, (Object)pSDEViewEngineBase.getEngineParam10());
        }
        if (pSDEViewEngineBase.isEngineParam10FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam10Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM10FLAG, (Object)pSDEViewEngineBase.getEngineParam10Flag());
        }
        if (pSDEViewEngineBase.isEngineParam10LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam10Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM10LABEL, (Object)pSDEViewEngineBase.getEngineParam10Label());
        }
        if (pSDEViewEngineBase.isEngineParam2Dirty() && (bl || pSDEViewEngineBase.getEngineParam2() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM2, (Object)pSDEViewEngineBase.getEngineParam2());
        }
        if (pSDEViewEngineBase.isEngineParam2FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam2Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM2FLAG, (Object)pSDEViewEngineBase.getEngineParam2Flag());
        }
        if (pSDEViewEngineBase.isEngineParam2LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam2Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM2LABEL, (Object)pSDEViewEngineBase.getEngineParam2Label());
        }
        if (pSDEViewEngineBase.isEngineParam3Dirty() && (bl || pSDEViewEngineBase.getEngineParam3() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM3, (Object)pSDEViewEngineBase.getEngineParam3());
        }
        if (pSDEViewEngineBase.isEngineParam3FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam3Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM3FLAG, (Object)pSDEViewEngineBase.getEngineParam3Flag());
        }
        if (pSDEViewEngineBase.isEngineParam3LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam3Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM3LABEL, (Object)pSDEViewEngineBase.getEngineParam3Label());
        }
        if (pSDEViewEngineBase.isEngineParam4Dirty() && (bl || pSDEViewEngineBase.getEngineParam4() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM4, (Object)pSDEViewEngineBase.getEngineParam4());
        }
        if (pSDEViewEngineBase.isEngineParam4FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam4Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM4FLAG, (Object)pSDEViewEngineBase.getEngineParam4Flag());
        }
        if (pSDEViewEngineBase.isEngineParam4LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam4Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM4LABEL, (Object)pSDEViewEngineBase.getEngineParam4Label());
        }
        if (pSDEViewEngineBase.isEngineParam5Dirty() && (bl || pSDEViewEngineBase.getEngineParam5() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM5, (Object)pSDEViewEngineBase.getEngineParam5());
        }
        if (pSDEViewEngineBase.isEngineParam5FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam5Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM5FLAG, (Object)pSDEViewEngineBase.getEngineParam5Flag());
        }
        if (pSDEViewEngineBase.isEngineParam5LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam5Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM5LABEL, (Object)pSDEViewEngineBase.getEngineParam5Label());
        }
        if (pSDEViewEngineBase.isEngineParam6Dirty() && (bl || pSDEViewEngineBase.getEngineParam6() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM6, (Object)pSDEViewEngineBase.getEngineParam6());
        }
        if (pSDEViewEngineBase.isEngineParam6FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam6Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM6FLAG, (Object)pSDEViewEngineBase.getEngineParam6Flag());
        }
        if (pSDEViewEngineBase.isEngineParam6LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam6Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM6LABEL, (Object)pSDEViewEngineBase.getEngineParam6Label());
        }
        if (pSDEViewEngineBase.isEngineParam7Dirty() && (bl || pSDEViewEngineBase.getEngineParam7() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM7, (Object)pSDEViewEngineBase.getEngineParam7());
        }
        if (pSDEViewEngineBase.isEngineParam7FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam7Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM7FLAG, (Object)pSDEViewEngineBase.getEngineParam7Flag());
        }
        if (pSDEViewEngineBase.isEngineParam7LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam7Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM7LABEL, (Object)pSDEViewEngineBase.getEngineParam7Label());
        }
        if (pSDEViewEngineBase.isEngineParam8Dirty() && (bl || pSDEViewEngineBase.getEngineParam8() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM8, (Object)pSDEViewEngineBase.getEngineParam8());
        }
        if (pSDEViewEngineBase.isEngineParam8FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam8Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM8FLAG, (Object)pSDEViewEngineBase.getEngineParam8Flag());
        }
        if (pSDEViewEngineBase.isEngineParam8LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam8Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM8LABEL, (Object)pSDEViewEngineBase.getEngineParam8Label());
        }
        if (pSDEViewEngineBase.isEngineParam9Dirty() && (bl || pSDEViewEngineBase.getEngineParam9() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM9, (Object)pSDEViewEngineBase.getEngineParam9());
        }
        if (pSDEViewEngineBase.isEngineParam9FlagDirty() && (bl || pSDEViewEngineBase.getEngineParam9Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM9FLAG, (Object)pSDEViewEngineBase.getEngineParam9Flag());
        }
        if (pSDEViewEngineBase.isEngineParam9LabelDirty() && (bl || pSDEViewEngineBase.getEngineParam9Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM9LABEL, (Object)pSDEViewEngineBase.getEngineParam9Label());
        }
        if (pSDEViewEngineBase.isEngineParamFlagDirty() && (bl || pSDEViewEngineBase.getEngineParamFlag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAMFLAG, (Object)pSDEViewEngineBase.getEngineParamFlag());
        }
        if (pSDEViewEngineBase.isEngineParamLabelDirty() && (bl || pSDEViewEngineBase.getEngineParamLabel() != null)) {
            iDataObject.set(FIELD_ENGINEPARAMLABEL, (Object)pSDEViewEngineBase.getEngineParamLabel());
        }
        if (pSDEViewEngineBase.isMemoDirty() && (bl || pSDEViewEngineBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewEngineBase.getMemo());
        }
        if (pSDEViewEngineBase.isNo2DEViewCtrlFlagDirty() && (bl || pSDEViewEngineBase.getNo2DEViewCtrlFlag() != null)) {
            iDataObject.set(FIELD_NO2DEVIEWCTRLFLAG, (Object)pSDEViewEngineBase.getNo2DEViewCtrlFlag());
        }
        if (pSDEViewEngineBase.isNo2DEViewCtrlLabelDirty() && (bl || pSDEViewEngineBase.getNo2DEViewCtrlLabel() != null)) {
            iDataObject.set(FIELD_NO2DEVIEWCTRLLABEL, (Object)pSDEViewEngineBase.getNo2DEViewCtrlLabel());
        }
        if (pSDEViewEngineBase.isNo2DEViewLogicFlagDirty() && (bl || pSDEViewEngineBase.getNo2DEViewLogicFlag() != null)) {
            iDataObject.set(FIELD_NO2DEVIEWLOGICFLAG, (Object)pSDEViewEngineBase.getNo2DEViewLogicFlag());
        }
        if (pSDEViewEngineBase.isNo2DEViewLogicLabelDirty() && (bl || pSDEViewEngineBase.getNo2DEViewLogicLabel() != null)) {
            iDataObject.set(FIELD_NO2DEVIEWLOGICLABEL, (Object)pSDEViewEngineBase.getNo2DEViewLogicLabel());
        }
        if (pSDEViewEngineBase.isNo2PSDEViewCtrlIdDirty() && (bl || pSDEViewEngineBase.getNo2PSDEViewCtrlId() != null)) {
            iDataObject.set(FIELD_NO2PSDEVIEWCTRLID, (Object)pSDEViewEngineBase.getNo2PSDEViewCtrlId());
        }
        if (pSDEViewEngineBase.isNo2PSDEViewCtrlNameDirty() && (bl || pSDEViewEngineBase.getNo2PSDEViewCtrlName() != null)) {
            iDataObject.set(FIELD_NO2PSDEVIEWCTRLNAME, (Object)pSDEViewEngineBase.getNo2PSDEViewCtrlName());
        }
        if (pSDEViewEngineBase.isNo2PSDEViewLogicIdDirty() && (bl || pSDEViewEngineBase.getNo2PSDEViewLogicId() != null)) {
            iDataObject.set(FIELD_NO2PSDEVIEWLOGICID, (Object)pSDEViewEngineBase.getNo2PSDEViewLogicId());
        }
        if (pSDEViewEngineBase.isNo2PSDEViewLogicNameDirty() && (bl || pSDEViewEngineBase.getNo2PSDEViewLogicName() != null)) {
            iDataObject.set(FIELD_NO2PSDEVIEWLOGICNAME, (Object)pSDEViewEngineBase.getNo2PSDEViewLogicName());
        }
        if (pSDEViewEngineBase.isNo3DEViewCtrlFlagDirty() && (bl || pSDEViewEngineBase.getNo3DEViewCtrlFlag() != null)) {
            iDataObject.set(FIELD_NO3DEVIEWCTRLFLAG, (Object)pSDEViewEngineBase.getNo3DEViewCtrlFlag());
        }
        if (pSDEViewEngineBase.isNo3DEViewCtrlLabelDirty() && (bl || pSDEViewEngineBase.getNo3DEViewCtrlLabel() != null)) {
            iDataObject.set(FIELD_NO3DEVIEWCTRLLABEL, (Object)pSDEViewEngineBase.getNo3DEViewCtrlLabel());
        }
        if (pSDEViewEngineBase.isNo3DEViewLogicFlagDirty() && (bl || pSDEViewEngineBase.getNo3DEViewLogicFlag() != null)) {
            iDataObject.set(FIELD_NO3DEVIEWLOGICFLAG, (Object)pSDEViewEngineBase.getNo3DEViewLogicFlag());
        }
        if (pSDEViewEngineBase.isNo3DEViewLogicLabelDirty() && (bl || pSDEViewEngineBase.getNo3DEViewLogicLabel() != null)) {
            iDataObject.set(FIELD_NO3DEVIEWLOGICLABEL, (Object)pSDEViewEngineBase.getNo3DEViewLogicLabel());
        }
        if (pSDEViewEngineBase.isNo3PSDEViewCtrlIdDirty() && (bl || pSDEViewEngineBase.getNo3PSDEViewCtrlId() != null)) {
            iDataObject.set(FIELD_NO3PSDEVIEWCTRLID, (Object)pSDEViewEngineBase.getNo3PSDEViewCtrlId());
        }
        if (pSDEViewEngineBase.isNo3PSDEViewCtrlNameDirty() && (bl || pSDEViewEngineBase.getNo3PSDEViewCtrlName() != null)) {
            iDataObject.set(FIELD_NO3PSDEVIEWCTRLNAME, (Object)pSDEViewEngineBase.getNo3PSDEViewCtrlName());
        }
        if (pSDEViewEngineBase.isNo3PSDEViewLogicIdDirty() && (bl || pSDEViewEngineBase.getNo3PSDEViewLogicId() != null)) {
            iDataObject.set(FIELD_NO3PSDEVIEWLOGICID, (Object)pSDEViewEngineBase.getNo3PSDEViewLogicId());
        }
        if (pSDEViewEngineBase.isNo3PSDEViewLogicNameDirty() && (bl || pSDEViewEngineBase.getNo3PSDEViewLogicName() != null)) {
            iDataObject.set(FIELD_NO3PSDEVIEWLOGICNAME, (Object)pSDEViewEngineBase.getNo3PSDEViewLogicName());
        }
        if (pSDEViewEngineBase.isNo4DEViewCtrlFlagDirty() && (bl || pSDEViewEngineBase.getNo4DEViewCtrlFlag() != null)) {
            iDataObject.set(FIELD_NO4DEVIEWCTRLFLAG, (Object)pSDEViewEngineBase.getNo4DEViewCtrlFlag());
        }
        if (pSDEViewEngineBase.isNo4DEViewCtrlLabelDirty() && (bl || pSDEViewEngineBase.getNo4DEViewCtrlLabel() != null)) {
            iDataObject.set(FIELD_NO4DEVIEWCTRLLABEL, (Object)pSDEViewEngineBase.getNo4DEViewCtrlLabel());
        }
        if (pSDEViewEngineBase.isNo4DEViewLogicFlagDirty() && (bl || pSDEViewEngineBase.getNo4DEViewLogicFlag() != null)) {
            iDataObject.set(FIELD_NO4DEVIEWLOGICFLAG, (Object)pSDEViewEngineBase.getNo4DEViewLogicFlag());
        }
        if (pSDEViewEngineBase.isNo4DEViewLogicLabelDirty() && (bl || pSDEViewEngineBase.getNo4DEViewLogicLabel() != null)) {
            iDataObject.set(FIELD_NO4DEVIEWLOGICLABEL, (Object)pSDEViewEngineBase.getNo4DEViewLogicLabel());
        }
        if (pSDEViewEngineBase.isNo4PSDEViewCtrlIdDirty() && (bl || pSDEViewEngineBase.getNo4PSDEViewCtrlId() != null)) {
            iDataObject.set(FIELD_NO4PSDEVIEWCTRLID, (Object)pSDEViewEngineBase.getNo4PSDEViewCtrlId());
        }
        if (pSDEViewEngineBase.isNo4PSDEViewCtrlNameDirty() && (bl || pSDEViewEngineBase.getNo4PSDEViewCtrlName() != null)) {
            iDataObject.set(FIELD_NO4PSDEVIEWCTRLNAME, (Object)pSDEViewEngineBase.getNo4PSDEViewCtrlName());
        }
        if (pSDEViewEngineBase.isNo4PSDEViewLogicIdDirty() && (bl || pSDEViewEngineBase.getNo4PSDEViewLogicId() != null)) {
            iDataObject.set(FIELD_NO4PSDEVIEWLOGICID, (Object)pSDEViewEngineBase.getNo4PSDEViewLogicId());
        }
        if (pSDEViewEngineBase.isNo4PSDEViewLogicNameDirty() && (bl || pSDEViewEngineBase.getNo4PSDEViewLogicName() != null)) {
            iDataObject.set(FIELD_NO4PSDEVIEWLOGICNAME, (Object)pSDEViewEngineBase.getNo4PSDEViewLogicName());
        }
        if (pSDEViewEngineBase.isOrderValueDirty() && (bl || pSDEViewEngineBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEViewEngineBase.getOrderValue());
        }
        if (pSDEViewEngineBase.isPSDEViewBaseIdDirty() && (bl || pSDEViewEngineBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEViewEngineBase.getPSDEViewBaseId());
        }
        if (pSDEViewEngineBase.isPSDEViewBaseNameDirty() && (bl || pSDEViewEngineBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEViewEngineBase.getPSDEViewBaseName());
        }
        if (pSDEViewEngineBase.isPSDEViewCtrlIdDirty() && (bl || pSDEViewEngineBase.getPSDEViewCtrlId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLID, (Object)pSDEViewEngineBase.getPSDEViewCtrlId());
        }
        if (pSDEViewEngineBase.isPSDEViewCtrlNameDirty() && (bl || pSDEViewEngineBase.getPSDEViewCtrlName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLNAME, (Object)pSDEViewEngineBase.getPSDEViewCtrlName());
        }
        if (pSDEViewEngineBase.isPSDEViewEngineIdDirty() && (bl || pSDEViewEngineBase.getPSDEViewEngineId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWENGINEID, (Object)pSDEViewEngineBase.getPSDEViewEngineId());
        }
        if (pSDEViewEngineBase.isPSDEViewEngineNameDirty() && (bl || pSDEViewEngineBase.getPSDEViewEngineName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWENGINENAME, (Object)pSDEViewEngineBase.getPSDEViewEngineName());
        }
        if (pSDEViewEngineBase.isPSDEViewLogicIdDirty() && (bl || pSDEViewEngineBase.getPSDEViewLogicId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWLOGICID, (Object)pSDEViewEngineBase.getPSDEViewLogicId());
        }
        if (pSDEViewEngineBase.isPSDEViewLogicNameDirty() && (bl || pSDEViewEngineBase.getPSDEViewLogicName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWLOGICNAME, (Object)pSDEViewEngineBase.getPSDEViewLogicName());
        }
        if (pSDEViewEngineBase.isPSSysPFPluginIdDirty() && (bl || pSDEViewEngineBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEViewEngineBase.getPSSysPFPluginId());
        }
        if (pSDEViewEngineBase.isPSSysPFPluginNameDirty() && (bl || pSDEViewEngineBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEViewEngineBase.getPSSysPFPluginName());
        }
        if (pSDEViewEngineBase.isPSUIEngineTypeIdDirty() && (bl || pSDEViewEngineBase.getPSUIEngineTypeId() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPEID, (Object)pSDEViewEngineBase.getPSUIEngineTypeId());
        }
        if (pSDEViewEngineBase.isPSUIEngineTypeNameDirty() && (bl || pSDEViewEngineBase.getPSUIEngineTypeName() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPENAME, (Object)pSDEViewEngineBase.getPSUIEngineTypeName());
        }
        if (pSDEViewEngineBase.isUpdateDateDirty() && (bl || pSDEViewEngineBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewEngineBase.getUpdateDate());
        }
        if (pSDEViewEngineBase.isUpdateManDirty() && (bl || pSDEViewEngineBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewEngineBase.getUpdateMan());
        }
        if (pSDEViewEngineBase.isUserCatDirty() && (bl || pSDEViewEngineBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEViewEngineBase.getUserCat());
        }
        if (pSDEViewEngineBase.isUserTagDirty() && (bl || pSDEViewEngineBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEViewEngineBase.getUserTag());
        }
        if (pSDEViewEngineBase.isUserTag2Dirty() && (bl || pSDEViewEngineBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEViewEngineBase.getUserTag2());
        }
        if (pSDEViewEngineBase.isUserTag3Dirty() && (bl || pSDEViewEngineBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEViewEngineBase.getUserTag3());
        }
        if (pSDEViewEngineBase.isUserTag4Dirty() && (bl || pSDEViewEngineBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEViewEngineBase.getUserTag4());
        }
        if (pSDEViewEngineBase.isValidFlagDirty() && (bl || pSDEViewEngineBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEViewEngineBase.getValidFlag());
        }
        if (pSDEViewEngineBase.isViewParamDirty() && (bl || pSDEViewEngineBase.getViewParam() != null)) {
            iDataObject.set(FIELD_VIEWPARAM, (Object)pSDEViewEngineBase.getViewParam());
        }
        if (pSDEViewEngineBase.isViewParam10Dirty() && (bl || pSDEViewEngineBase.getViewParam10() != null)) {
            iDataObject.set(FIELD_VIEWPARAM10, (Object)pSDEViewEngineBase.getViewParam10());
        }
        if (pSDEViewEngineBase.isViewParam2Dirty() && (bl || pSDEViewEngineBase.getViewParam2() != null)) {
            iDataObject.set(FIELD_VIEWPARAM2, (Object)pSDEViewEngineBase.getViewParam2());
        }
        if (pSDEViewEngineBase.isViewParam3Dirty() && (bl || pSDEViewEngineBase.getViewParam3() != null)) {
            iDataObject.set(FIELD_VIEWPARAM3, (Object)pSDEViewEngineBase.getViewParam3());
        }
        if (pSDEViewEngineBase.isViewParam4Dirty() && (bl || pSDEViewEngineBase.getViewParam4() != null)) {
            iDataObject.set(FIELD_VIEWPARAM4, (Object)pSDEViewEngineBase.getViewParam4());
        }
        if (pSDEViewEngineBase.isViewParam5Dirty() && (bl || pSDEViewEngineBase.getViewParam5() != null)) {
            iDataObject.set(FIELD_VIEWPARAM5, (Object)pSDEViewEngineBase.getViewParam5());
        }
        if (pSDEViewEngineBase.isViewParam6Dirty() && (bl || pSDEViewEngineBase.getViewParam6() != null)) {
            iDataObject.set(FIELD_VIEWPARAM6, (Object)pSDEViewEngineBase.getViewParam6());
        }
        if (pSDEViewEngineBase.isViewParam7Dirty() && (bl || pSDEViewEngineBase.getViewParam7() != null)) {
            iDataObject.set(FIELD_VIEWPARAM7, (Object)pSDEViewEngineBase.getViewParam7());
        }
        if (pSDEViewEngineBase.isViewParam8Dirty() && (bl || pSDEViewEngineBase.getViewParam8() != null)) {
            iDataObject.set(FIELD_VIEWPARAM8, (Object)pSDEViewEngineBase.getViewParam8());
        }
        if (pSDEViewEngineBase.isViewParam9Dirty() && (bl || pSDEViewEngineBase.getViewParam9() != null)) {
            iDataObject.set(FIELD_VIEWPARAM9, (Object)pSDEViewEngineBase.getViewParam9());
        }
        if (pSDEViewEngineBase.isWFViewParamDirty() && (bl || pSDEViewEngineBase.getWFViewParam() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM, (Object)pSDEViewEngineBase.getWFViewParam());
        }
        if (pSDEViewEngineBase.isWFViewParam2Dirty() && (bl || pSDEViewEngineBase.getWFViewParam2() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM2, (Object)pSDEViewEngineBase.getWFViewParam2());
        }
        if (pSDEViewEngineBase.isWFViewParam3Dirty() && (bl || pSDEViewEngineBase.getWFViewParam3() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM3, (Object)pSDEViewEngineBase.getWFViewParam3());
        }
        if (pSDEViewEngineBase.isWFViewParam4Dirty() && (bl || pSDEViewEngineBase.getWFViewParam4() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM4, (Object)pSDEViewEngineBase.getWFViewParam4());
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
        return PSDEViewEngineBase.remove(this, n);
    }

    private static boolean remove(PSDEViewEngineBase pSDEViewEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewEngineBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEViewEngineBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEViewEngineBase.resetDEViewCtrlFlag();
                return true;
            }
            case 3: {
                pSDEViewEngineBase.resetDEViewCtrlLabel();
                return true;
            }
            case 4: {
                pSDEViewEngineBase.resetDEViewLogicFlag();
                return true;
            }
            case 5: {
                pSDEViewEngineBase.resetDEViewLogicLabel();
                return true;
            }
            case 6: {
                pSDEViewEngineBase.resetEngineOption();
                return true;
            }
            case 7: {
                pSDEViewEngineBase.resetEngineParam();
                return true;
            }
            case 8: {
                pSDEViewEngineBase.resetEngineParam10();
                return true;
            }
            case 9: {
                pSDEViewEngineBase.resetEngineParam10Flag();
                return true;
            }
            case 10: {
                pSDEViewEngineBase.resetEngineParam10Label();
                return true;
            }
            case 11: {
                pSDEViewEngineBase.resetEngineParam2();
                return true;
            }
            case 12: {
                pSDEViewEngineBase.resetEngineParam2Flag();
                return true;
            }
            case 13: {
                pSDEViewEngineBase.resetEngineParam2Label();
                return true;
            }
            case 14: {
                pSDEViewEngineBase.resetEngineParam3();
                return true;
            }
            case 15: {
                pSDEViewEngineBase.resetEngineParam3Flag();
                return true;
            }
            case 16: {
                pSDEViewEngineBase.resetEngineParam3Label();
                return true;
            }
            case 17: {
                pSDEViewEngineBase.resetEngineParam4();
                return true;
            }
            case 18: {
                pSDEViewEngineBase.resetEngineParam4Flag();
                return true;
            }
            case 19: {
                pSDEViewEngineBase.resetEngineParam4Label();
                return true;
            }
            case 20: {
                pSDEViewEngineBase.resetEngineParam5();
                return true;
            }
            case 21: {
                pSDEViewEngineBase.resetEngineParam5Flag();
                return true;
            }
            case 22: {
                pSDEViewEngineBase.resetEngineParam5Label();
                return true;
            }
            case 23: {
                pSDEViewEngineBase.resetEngineParam6();
                return true;
            }
            case 24: {
                pSDEViewEngineBase.resetEngineParam6Flag();
                return true;
            }
            case 25: {
                pSDEViewEngineBase.resetEngineParam6Label();
                return true;
            }
            case 26: {
                pSDEViewEngineBase.resetEngineParam7();
                return true;
            }
            case 27: {
                pSDEViewEngineBase.resetEngineParam7Flag();
                return true;
            }
            case 28: {
                pSDEViewEngineBase.resetEngineParam7Label();
                return true;
            }
            case 29: {
                pSDEViewEngineBase.resetEngineParam8();
                return true;
            }
            case 30: {
                pSDEViewEngineBase.resetEngineParam8Flag();
                return true;
            }
            case 31: {
                pSDEViewEngineBase.resetEngineParam8Label();
                return true;
            }
            case 32: {
                pSDEViewEngineBase.resetEngineParam9();
                return true;
            }
            case 33: {
                pSDEViewEngineBase.resetEngineParam9Flag();
                return true;
            }
            case 34: {
                pSDEViewEngineBase.resetEngineParam9Label();
                return true;
            }
            case 35: {
                pSDEViewEngineBase.resetEngineParamFlag();
                return true;
            }
            case 36: {
                pSDEViewEngineBase.resetEngineParamLabel();
                return true;
            }
            case 37: {
                pSDEViewEngineBase.resetMemo();
                return true;
            }
            case 38: {
                pSDEViewEngineBase.resetNo2DEViewCtrlFlag();
                return true;
            }
            case 39: {
                pSDEViewEngineBase.resetNo2DEViewCtrlLabel();
                return true;
            }
            case 40: {
                pSDEViewEngineBase.resetNo2DEViewLogicFlag();
                return true;
            }
            case 41: {
                pSDEViewEngineBase.resetNo2DEViewLogicLabel();
                return true;
            }
            case 42: {
                pSDEViewEngineBase.resetNo2PSDEViewCtrlId();
                return true;
            }
            case 43: {
                pSDEViewEngineBase.resetNo2PSDEViewCtrlName();
                return true;
            }
            case 44: {
                pSDEViewEngineBase.resetNo2PSDEViewLogicId();
                return true;
            }
            case 45: {
                pSDEViewEngineBase.resetNo2PSDEViewLogicName();
                return true;
            }
            case 46: {
                pSDEViewEngineBase.resetNo3DEViewCtrlFlag();
                return true;
            }
            case 47: {
                pSDEViewEngineBase.resetNo3DEViewCtrlLabel();
                return true;
            }
            case 48: {
                pSDEViewEngineBase.resetNo3DEViewLogicFlag();
                return true;
            }
            case 49: {
                pSDEViewEngineBase.resetNo3DEViewLogicLabel();
                return true;
            }
            case 50: {
                pSDEViewEngineBase.resetNo3PSDEViewCtrlId();
                return true;
            }
            case 51: {
                pSDEViewEngineBase.resetNo3PSDEViewCtrlName();
                return true;
            }
            case 52: {
                pSDEViewEngineBase.resetNo3PSDEViewLogicId();
                return true;
            }
            case 53: {
                pSDEViewEngineBase.resetNo3PSDEViewLogicName();
                return true;
            }
            case 54: {
                pSDEViewEngineBase.resetNo4DEViewCtrlFlag();
                return true;
            }
            case 55: {
                pSDEViewEngineBase.resetNo4DEViewCtrlLabel();
                return true;
            }
            case 56: {
                pSDEViewEngineBase.resetNo4DEViewLogicFlag();
                return true;
            }
            case 57: {
                pSDEViewEngineBase.resetNo4DEViewLogicLabel();
                return true;
            }
            case 58: {
                pSDEViewEngineBase.resetNo4PSDEViewCtrlId();
                return true;
            }
            case 59: {
                pSDEViewEngineBase.resetNo4PSDEViewCtrlName();
                return true;
            }
            case 60: {
                pSDEViewEngineBase.resetNo4PSDEViewLogicId();
                return true;
            }
            case 61: {
                pSDEViewEngineBase.resetNo4PSDEViewLogicName();
                return true;
            }
            case 62: {
                pSDEViewEngineBase.resetOrderValue();
                return true;
            }
            case 63: {
                pSDEViewEngineBase.resetPSDEViewBaseId();
                return true;
            }
            case 64: {
                pSDEViewEngineBase.resetPSDEViewBaseName();
                return true;
            }
            case 65: {
                pSDEViewEngineBase.resetPSDEViewCtrlId();
                return true;
            }
            case 66: {
                pSDEViewEngineBase.resetPSDEViewCtrlName();
                return true;
            }
            case 67: {
                pSDEViewEngineBase.resetPSDEViewEngineId();
                return true;
            }
            case 68: {
                pSDEViewEngineBase.resetPSDEViewEngineName();
                return true;
            }
            case 69: {
                pSDEViewEngineBase.resetPSDEViewLogicId();
                return true;
            }
            case 70: {
                pSDEViewEngineBase.resetPSDEViewLogicName();
                return true;
            }
            case 71: {
                pSDEViewEngineBase.resetPSSysPFPluginId();
                return true;
            }
            case 72: {
                pSDEViewEngineBase.resetPSSysPFPluginName();
                return true;
            }
            case 73: {
                pSDEViewEngineBase.resetPSUIEngineTypeId();
                return true;
            }
            case 74: {
                pSDEViewEngineBase.resetPSUIEngineTypeName();
                return true;
            }
            case 75: {
                pSDEViewEngineBase.resetUpdateDate();
                return true;
            }
            case 76: {
                pSDEViewEngineBase.resetUpdateMan();
                return true;
            }
            case 77: {
                pSDEViewEngineBase.resetUserCat();
                return true;
            }
            case 78: {
                pSDEViewEngineBase.resetUserTag();
                return true;
            }
            case 79: {
                pSDEViewEngineBase.resetUserTag2();
                return true;
            }
            case 80: {
                pSDEViewEngineBase.resetUserTag3();
                return true;
            }
            case 81: {
                pSDEViewEngineBase.resetUserTag4();
                return true;
            }
            case 82: {
                pSDEViewEngineBase.resetValidFlag();
                return true;
            }
            case 83: {
                pSDEViewEngineBase.resetViewParam();
                return true;
            }
            case 84: {
                pSDEViewEngineBase.resetViewParam10();
                return true;
            }
            case 85: {
                pSDEViewEngineBase.resetViewParam2();
                return true;
            }
            case 86: {
                pSDEViewEngineBase.resetViewParam3();
                return true;
            }
            case 87: {
                pSDEViewEngineBase.resetViewParam4();
                return true;
            }
            case 88: {
                pSDEViewEngineBase.resetViewParam5();
                return true;
            }
            case 89: {
                pSDEViewEngineBase.resetViewParam6();
                return true;
            }
            case 90: {
                pSDEViewEngineBase.resetViewParam7();
                return true;
            }
            case 91: {
                pSDEViewEngineBase.resetViewParam8();
                return true;
            }
            case 92: {
                pSDEViewEngineBase.resetViewParam9();
                return true;
            }
            case 93: {
                pSDEViewEngineBase.resetWFViewParam();
                return true;
            }
            case 94: {
                pSDEViewEngineBase.resetWFViewParam2();
                return true;
            }
            case 95: {
                pSDEViewEngineBase.resetWFViewParam3();
                return true;
            }
            case 96: {
                pSDEViewEngineBase.resetWFViewParam4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDEViewCtrl getNo2PSDEViewCtrl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEViewCtrl();
        }
        if (this.getNo2PSDEViewCtrlId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDEViewCtrlLock;
        synchronized (n) {
            if (this.no2psdeviewctrl != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDEViewCtrlId(), (Object)this.no2psdeviewctrl.getPSDEViewCtrlId()) != 0L) {
                this.no2psdeviewctrl = null;
            }
            if (this.no2psdeviewctrl == null) {
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setPSDEViewCtrlId(this.getNo2PSDEViewCtrlId());
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewCtrlService.autoGet(pSDEViewCtrl);
                this.no2psdeviewctrl = pSDEViewCtrl;
            }
            return this.no2psdeviewctrl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewCtrl getNo3PSDEViewCtrl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEViewCtrl();
        }
        if (this.getNo3PSDEViewCtrlId() == null) {
            return null;
        }
        Integer n = this.objNo3PSDEViewCtrlLock;
        synchronized (n) {
            if (this.no3psdeviewctrl != null && DataTypeHelper.compare((int)25, (Object)this.getNo3PSDEViewCtrlId(), (Object)this.no3psdeviewctrl.getPSDEViewCtrlId()) != 0L) {
                this.no3psdeviewctrl = null;
            }
            if (this.no3psdeviewctrl == null) {
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setPSDEViewCtrlId(this.getNo3PSDEViewCtrlId());
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewCtrlService.autoGet(pSDEViewCtrl);
                this.no3psdeviewctrl = pSDEViewCtrl;
            }
            return this.no3psdeviewctrl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewCtrl getNo4PSDEViewCtrl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEViewCtrl();
        }
        if (this.getNo4PSDEViewCtrlId() == null) {
            return null;
        }
        Integer n = this.objNo4PSDEViewCtrlLock;
        synchronized (n) {
            if (this.no4psdeviewctrl != null && DataTypeHelper.compare((int)25, (Object)this.getNo4PSDEViewCtrlId(), (Object)this.no4psdeviewctrl.getPSDEViewCtrlId()) != 0L) {
                this.no4psdeviewctrl = null;
            }
            if (this.no4psdeviewctrl == null) {
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setPSDEViewCtrlId(this.getNo4PSDEViewCtrlId());
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewCtrlService.autoGet(pSDEViewCtrl);
                this.no4psdeviewctrl = pSDEViewCtrl;
            }
            return this.no4psdeviewctrl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewCtrl getPSDEViewCtrl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrl();
        }
        if (this.getPSDEViewCtrlId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewCtrlLock;
        synchronized (n) {
            if (this.psdeviewctrl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewCtrlId(), (Object)this.psdeviewctrl.getPSDEViewCtrlId()) != 0L) {
                this.psdeviewctrl = null;
            }
            if (this.psdeviewctrl == null) {
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setPSDEViewCtrlId(this.getPSDEViewCtrlId());
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewCtrlService.autoGet(pSDEViewCtrl);
                this.psdeviewctrl = pSDEViewCtrl;
            }
            return this.psdeviewctrl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewLogic getNo2PSDEViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEViewLogic();
        }
        if (this.getNo2PSDEViewLogicId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDEViewLogicLock;
        synchronized (n) {
            if (this.no2psdeviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDEViewLogicId(), (Object)this.no2psdeviewlogic.getPSDEViewLogicId()) != 0L) {
                this.no2psdeviewlogic = null;
            }
            if (this.no2psdeviewlogic == null) {
                PSDEViewLogic pSDEViewLogic = new PSDEViewLogic();
                pSDEViewLogic.setPSDEViewLogicId(this.getNo2PSDEViewLogicId());
                PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewLogicService.autoGet(pSDEViewLogic);
                this.no2psdeviewlogic = pSDEViewLogic;
            }
            return this.no2psdeviewlogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewLogic getNo3PSDEViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSDEViewLogic();
        }
        if (this.getNo3PSDEViewLogicId() == null) {
            return null;
        }
        Integer n = this.objNo3PSDEViewLogicLock;
        synchronized (n) {
            if (this.no3psdeviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getNo3PSDEViewLogicId(), (Object)this.no3psdeviewlogic.getPSDEViewLogicId()) != 0L) {
                this.no3psdeviewlogic = null;
            }
            if (this.no3psdeviewlogic == null) {
                PSDEViewLogic pSDEViewLogic = new PSDEViewLogic();
                pSDEViewLogic.setPSDEViewLogicId(this.getNo3PSDEViewLogicId());
                PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewLogicService.autoGet(pSDEViewLogic);
                this.no3psdeviewlogic = pSDEViewLogic;
            }
            return this.no3psdeviewlogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewLogic getNo4PSDEViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSDEViewLogic();
        }
        if (this.getNo4PSDEViewLogicId() == null) {
            return null;
        }
        Integer n = this.objNo4PSDEViewLogicLock;
        synchronized (n) {
            if (this.no4psdeviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getNo4PSDEViewLogicId(), (Object)this.no4psdeviewlogic.getPSDEViewLogicId()) != 0L) {
                this.no4psdeviewlogic = null;
            }
            if (this.no4psdeviewlogic == null) {
                PSDEViewLogic pSDEViewLogic = new PSDEViewLogic();
                pSDEViewLogic.setPSDEViewLogicId(this.getNo4PSDEViewLogicId());
                PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewLogicService.autoGet(pSDEViewLogic);
                this.no4psdeviewlogic = pSDEViewLogic;
            }
            return this.no4psdeviewlogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewLogic getPSDEViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewLogic();
        }
        if (this.getPSDEViewLogicId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewLogicLock;
        synchronized (n) {
            if (this.psdeviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewLogicId(), (Object)this.psdeviewlogic.getPSDEViewLogicId()) != 0L) {
                this.psdeviewlogic = null;
            }
            if (this.psdeviewlogic == null) {
                PSDEViewLogic pSDEViewLogic = new PSDEViewLogic();
                pSDEViewLogic.setPSDEViewLogicId(this.getPSDEViewLogicId());
                PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewLogicService.autoGet(pSDEViewLogic);
                this.psdeviewlogic = pSDEViewLogic;
            }
            return this.psdeviewlogic;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUIEngineType getPSUIEngineType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineType();
        }
        if (this.getPSUIEngineTypeId() == null) {
            return null;
        }
        Integer n = this.objPSUIEngineTypeLock;
        synchronized (n) {
            if (this.psuienginetype != null && DataTypeHelper.compare((int)25, (Object)this.getPSUIEngineTypeId(), (Object)this.psuienginetype.getPSUIEngineTypeId()) != 0L) {
                this.psuienginetype = null;
            }
            if (this.psuienginetype == null) {
                PSUIEngineType pSUIEngineType = new PSUIEngineType();
                pSUIEngineType.setPSUIEngineTypeId(this.getPSUIEngineTypeId());
                PSUIEngineTypeService pSUIEngineTypeService = (PSUIEngineTypeService)ServiceGlobal.getService(PSUIEngineTypeService.class, (SessionFactory)this.getSessionFactory());
                pSUIEngineTypeService.autoGet(pSUIEngineType);
                this.psuienginetype = pSUIEngineType;
            }
            return this.psuienginetype;
        }
    }

    private PSDEViewEngineBase getProxyEntity() {
        return this.proxyPSDEViewEngineBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewEngineBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewEngineBase) {
            this.proxyPSDEViewEngineBase = (PSDEViewEngineBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEVIEWCTRLFLAG, 2);
        fieldIndexMap.put(FIELD_DEVIEWCTRLLABEL, 3);
        fieldIndexMap.put(FIELD_DEVIEWLOGICFLAG, 4);
        fieldIndexMap.put(FIELD_DEVIEWLOGICLABEL, 5);
        fieldIndexMap.put(FIELD_ENGINEOPTION, 6);
        fieldIndexMap.put(FIELD_ENGINEPARAM, 7);
        fieldIndexMap.put(FIELD_ENGINEPARAM10, 8);
        fieldIndexMap.put(FIELD_ENGINEPARAM10FLAG, 9);
        fieldIndexMap.put(FIELD_ENGINEPARAM10LABEL, 10);
        fieldIndexMap.put(FIELD_ENGINEPARAM2, 11);
        fieldIndexMap.put(FIELD_ENGINEPARAM2FLAG, 12);
        fieldIndexMap.put(FIELD_ENGINEPARAM2LABEL, 13);
        fieldIndexMap.put(FIELD_ENGINEPARAM3, 14);
        fieldIndexMap.put(FIELD_ENGINEPARAM3FLAG, 15);
        fieldIndexMap.put(FIELD_ENGINEPARAM3LABEL, 16);
        fieldIndexMap.put(FIELD_ENGINEPARAM4, 17);
        fieldIndexMap.put(FIELD_ENGINEPARAM4FLAG, 18);
        fieldIndexMap.put(FIELD_ENGINEPARAM4LABEL, 19);
        fieldIndexMap.put(FIELD_ENGINEPARAM5, 20);
        fieldIndexMap.put(FIELD_ENGINEPARAM5FLAG, 21);
        fieldIndexMap.put(FIELD_ENGINEPARAM5LABEL, 22);
        fieldIndexMap.put(FIELD_ENGINEPARAM6, 23);
        fieldIndexMap.put(FIELD_ENGINEPARAM6FLAG, 24);
        fieldIndexMap.put(FIELD_ENGINEPARAM6LABEL, 25);
        fieldIndexMap.put(FIELD_ENGINEPARAM7, 26);
        fieldIndexMap.put(FIELD_ENGINEPARAM7FLAG, 27);
        fieldIndexMap.put(FIELD_ENGINEPARAM7LABEL, 28);
        fieldIndexMap.put(FIELD_ENGINEPARAM8, 29);
        fieldIndexMap.put(FIELD_ENGINEPARAM8FLAG, 30);
        fieldIndexMap.put(FIELD_ENGINEPARAM8LABEL, 31);
        fieldIndexMap.put(FIELD_ENGINEPARAM9, 32);
        fieldIndexMap.put(FIELD_ENGINEPARAM9FLAG, 33);
        fieldIndexMap.put(FIELD_ENGINEPARAM9LABEL, 34);
        fieldIndexMap.put(FIELD_ENGINEPARAMFLAG, 35);
        fieldIndexMap.put(FIELD_ENGINEPARAMLABEL, 36);
        fieldIndexMap.put(FIELD_MEMO, 37);
        fieldIndexMap.put(FIELD_NO2DEVIEWCTRLFLAG, 38);
        fieldIndexMap.put(FIELD_NO2DEVIEWCTRLLABEL, 39);
        fieldIndexMap.put(FIELD_NO2DEVIEWLOGICFLAG, 40);
        fieldIndexMap.put(FIELD_NO2DEVIEWLOGICLABEL, 41);
        fieldIndexMap.put(FIELD_NO2PSDEVIEWCTRLID, 42);
        fieldIndexMap.put(FIELD_NO2PSDEVIEWCTRLNAME, 43);
        fieldIndexMap.put(FIELD_NO2PSDEVIEWLOGICID, 44);
        fieldIndexMap.put(FIELD_NO2PSDEVIEWLOGICNAME, 45);
        fieldIndexMap.put(FIELD_NO3DEVIEWCTRLFLAG, 46);
        fieldIndexMap.put(FIELD_NO3DEVIEWCTRLLABEL, 47);
        fieldIndexMap.put(FIELD_NO3DEVIEWLOGICFLAG, 48);
        fieldIndexMap.put(FIELD_NO3DEVIEWLOGICLABEL, 49);
        fieldIndexMap.put(FIELD_NO3PSDEVIEWCTRLID, 50);
        fieldIndexMap.put(FIELD_NO3PSDEVIEWCTRLNAME, 51);
        fieldIndexMap.put(FIELD_NO3PSDEVIEWLOGICID, 52);
        fieldIndexMap.put(FIELD_NO3PSDEVIEWLOGICNAME, 53);
        fieldIndexMap.put(FIELD_NO4DEVIEWCTRLFLAG, 54);
        fieldIndexMap.put(FIELD_NO4DEVIEWCTRLLABEL, 55);
        fieldIndexMap.put(FIELD_NO4DEVIEWLOGICFLAG, 56);
        fieldIndexMap.put(FIELD_NO4DEVIEWLOGICLABEL, 57);
        fieldIndexMap.put(FIELD_NO4PSDEVIEWCTRLID, 58);
        fieldIndexMap.put(FIELD_NO4PSDEVIEWCTRLNAME, 59);
        fieldIndexMap.put(FIELD_NO4PSDEVIEWLOGICID, 60);
        fieldIndexMap.put(FIELD_NO4PSDEVIEWLOGICNAME, 61);
        fieldIndexMap.put(FIELD_ORDERVALUE, 62);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 63);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 64);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLID, 65);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLNAME, 66);
        fieldIndexMap.put(FIELD_PSDEVIEWENGINEID, 67);
        fieldIndexMap.put(FIELD_PSDEVIEWENGINENAME, 68);
        fieldIndexMap.put(FIELD_PSDEVIEWLOGICID, 69);
        fieldIndexMap.put(FIELD_PSDEVIEWLOGICNAME, 70);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 71);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 72);
        fieldIndexMap.put(FIELD_PSUIENGINETYPEID, 73);
        fieldIndexMap.put(FIELD_PSUIENGINETYPENAME, 74);
        fieldIndexMap.put(FIELD_UPDATEDATE, 75);
        fieldIndexMap.put(FIELD_UPDATEMAN, 76);
        fieldIndexMap.put(FIELD_USERCAT, 77);
        fieldIndexMap.put(FIELD_USERTAG, 78);
        fieldIndexMap.put(FIELD_USERTAG2, 79);
        fieldIndexMap.put(FIELD_USERTAG3, 80);
        fieldIndexMap.put(FIELD_USERTAG4, 81);
        fieldIndexMap.put(FIELD_VALIDFLAG, 82);
        fieldIndexMap.put(FIELD_VIEWPARAM, 83);
        fieldIndexMap.put(FIELD_VIEWPARAM10, 84);
        fieldIndexMap.put(FIELD_VIEWPARAM2, 85);
        fieldIndexMap.put(FIELD_VIEWPARAM3, 86);
        fieldIndexMap.put(FIELD_VIEWPARAM4, 87);
        fieldIndexMap.put(FIELD_VIEWPARAM5, 88);
        fieldIndexMap.put(FIELD_VIEWPARAM6, 89);
        fieldIndexMap.put(FIELD_VIEWPARAM7, 90);
        fieldIndexMap.put(FIELD_VIEWPARAM8, 91);
        fieldIndexMap.put(FIELD_VIEWPARAM9, 92);
        fieldIndexMap.put(FIELD_WFVIEWPARAM, 93);
        fieldIndexMap.put(FIELD_WFVIEWPARAM2, 94);
        fieldIndexMap.put(FIELD_WFVIEWPARAM3, 95);
        fieldIndexMap.put(FIELD_WFVIEWPARAM4, 96);
    }
}

