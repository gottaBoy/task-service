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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineType;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSUIEngineTypeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelEngineBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelEngineBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
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
    public static final String FIELD_NO2PANELITEMFLAG = "NO2PANELITEMFLAG";
    public static final String FIELD_NO2PANELITEMLABEL = "NO2PANELITEMLABEL";
    public static final String FIELD_NO2PANELLOGICFLAG = "NO2PANELLOGICFLAG";
    public static final String FIELD_NO2PANELLOGICLABEL = "NO2PANELLOGICLABEL";
    public static final String FIELD_NO2PSPANELITEMID = "NO2PSPANELITEMID";
    public static final String FIELD_NO2PSPANELITEMNAME = "NO2PSPANELITEMNAME";
    public static final String FIELD_NO2PSPANELLOGICID = "NO2PSPANELLOGICID";
    public static final String FIELD_NO2PSPANELLOGICNAME = "NO2PSPANELLOGICNAME";
    public static final String FIELD_NO3PANELITEMFLAG = "NO3PANELITEMFLAG";
    public static final String FIELD_NO3PANELITEMLABEL = "NO3PANELITEMLABEL";
    public static final String FIELD_NO3PANELLOGICFLAG = "NO3PANELLOGICFLAG";
    public static final String FIELD_NO3PANELLOGICLABEL = "NO3PANELLOGICLABEL";
    public static final String FIELD_NO3PSPANELITEMID = "NO3PSPANELITEMID";
    public static final String FIELD_NO3PSPANELITEMNAME = "NO3PSPANELITEMNAME";
    public static final String FIELD_NO3PSPANELLOGICID = "NO3PSPANELLOGICID";
    public static final String FIELD_NO3PSPANELLOGICNAME = "NO3PSPANELLOGICNAME";
    public static final String FIELD_NO4PANELITEMFLAG = "NO4PANELITEMFLAG";
    public static final String FIELD_NO4PANELITEMLABEL = "NO4PANELITEMLABEL";
    public static final String FIELD_NO4PANELLOGICFLAG = "NO4PANELLOGICFLAG";
    public static final String FIELD_NO4PANELLOGICLABEL = "NO4PANELLOGICLABEL";
    public static final String FIELD_NO4PSPANELITEMID = "NO4PSPANELITEMID";
    public static final String FIELD_NO4PSPANELITEMNAME = "NO4PSPANELITEMNAME";
    public static final String FIELD_NO4PSPANELLOGICID = "NO4PSPANELLOGICID";
    public static final String FIELD_NO4PSPANELLOGICNAME = "NO4PSPANELLOGICNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PANELITEMFLAG = "PANELITEMFLAG";
    public static final String FIELD_PANELITEMLABEL = "PANELITEMLABEL";
    public static final String FIELD_PANELLOGICFLAG = "PANELLOGICFLAG";
    public static final String FIELD_PANELLOGICLABEL = "PANELLOGICLABEL";
    public static final String FIELD_PSPANELENGINEID = "PSPANELENGINEID";
    public static final String FIELD_PSPANELENGINENAME = "PSPANELENGINENAME";
    public static final String FIELD_PSPANELITEMID = "PSPANELITEMID";
    public static final String FIELD_PSPANELITEMNAME = "PSPANELITEMNAME";
    public static final String FIELD_PSPANELLOGICID = "PSPANELLOGICID";
    public static final String FIELD_PSPANELLOGICNAME = "PSPANELLOGICNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
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
    private static final int INDEX_ENGINEOPTION = 2;
    private static final int INDEX_ENGINEPARAM = 3;
    private static final int INDEX_ENGINEPARAM10 = 4;
    private static final int INDEX_ENGINEPARAM10FLAG = 5;
    private static final int INDEX_ENGINEPARAM10LABEL = 6;
    private static final int INDEX_ENGINEPARAM2 = 7;
    private static final int INDEX_ENGINEPARAM2FLAG = 8;
    private static final int INDEX_ENGINEPARAM2LABEL = 9;
    private static final int INDEX_ENGINEPARAM3 = 10;
    private static final int INDEX_ENGINEPARAM3FLAG = 11;
    private static final int INDEX_ENGINEPARAM3LABEL = 12;
    private static final int INDEX_ENGINEPARAM4 = 13;
    private static final int INDEX_ENGINEPARAM4FLAG = 14;
    private static final int INDEX_ENGINEPARAM4LABEL = 15;
    private static final int INDEX_ENGINEPARAM5 = 16;
    private static final int INDEX_ENGINEPARAM5FLAG = 17;
    private static final int INDEX_ENGINEPARAM5LABEL = 18;
    private static final int INDEX_ENGINEPARAM6 = 19;
    private static final int INDEX_ENGINEPARAM6FLAG = 20;
    private static final int INDEX_ENGINEPARAM6LABEL = 21;
    private static final int INDEX_ENGINEPARAM7 = 22;
    private static final int INDEX_ENGINEPARAM7FLAG = 23;
    private static final int INDEX_ENGINEPARAM7LABEL = 24;
    private static final int INDEX_ENGINEPARAM8 = 25;
    private static final int INDEX_ENGINEPARAM8FLAG = 26;
    private static final int INDEX_ENGINEPARAM8LABEL = 27;
    private static final int INDEX_ENGINEPARAM9 = 28;
    private static final int INDEX_ENGINEPARAM9FLAG = 29;
    private static final int INDEX_ENGINEPARAM9LABEL = 30;
    private static final int INDEX_ENGINEPARAMFLAG = 31;
    private static final int INDEX_ENGINEPARAMLABEL = 32;
    private static final int INDEX_MEMO = 33;
    private static final int INDEX_NO2PANELITEMFLAG = 34;
    private static final int INDEX_NO2PANELITEMLABEL = 35;
    private static final int INDEX_NO2PANELLOGICFLAG = 36;
    private static final int INDEX_NO2PANELLOGICLABEL = 37;
    private static final int INDEX_NO2PSPANELITEMID = 38;
    private static final int INDEX_NO2PSPANELITEMNAME = 39;
    private static final int INDEX_NO2PSPANELLOGICID = 40;
    private static final int INDEX_NO2PSPANELLOGICNAME = 41;
    private static final int INDEX_NO3PANELITEMFLAG = 42;
    private static final int INDEX_NO3PANELITEMLABEL = 43;
    private static final int INDEX_NO3PANELLOGICFLAG = 44;
    private static final int INDEX_NO3PANELLOGICLABEL = 45;
    private static final int INDEX_NO3PSPANELITEMID = 46;
    private static final int INDEX_NO3PSPANELITEMNAME = 47;
    private static final int INDEX_NO3PSPANELLOGICID = 48;
    private static final int INDEX_NO3PSPANELLOGICNAME = 49;
    private static final int INDEX_NO4PANELITEMFLAG = 50;
    private static final int INDEX_NO4PANELITEMLABEL = 51;
    private static final int INDEX_NO4PANELLOGICFLAG = 52;
    private static final int INDEX_NO4PANELLOGICLABEL = 53;
    private static final int INDEX_NO4PSPANELITEMID = 54;
    private static final int INDEX_NO4PSPANELITEMNAME = 55;
    private static final int INDEX_NO4PSPANELLOGICID = 56;
    private static final int INDEX_NO4PSPANELLOGICNAME = 57;
    private static final int INDEX_ORDERVALUE = 58;
    private static final int INDEX_PANELITEMFLAG = 59;
    private static final int INDEX_PANELITEMLABEL = 60;
    private static final int INDEX_PANELLOGICFLAG = 61;
    private static final int INDEX_PANELLOGICLABEL = 62;
    private static final int INDEX_PSPANELENGINEID = 63;
    private static final int INDEX_PSPANELENGINENAME = 64;
    private static final int INDEX_PSPANELITEMID = 65;
    private static final int INDEX_PSPANELITEMNAME = 66;
    private static final int INDEX_PSPANELLOGICID = 67;
    private static final int INDEX_PSPANELLOGICNAME = 68;
    private static final int INDEX_PSSYSPFPLUGINID = 69;
    private static final int INDEX_PSSYSPFPLUGINNAME = 70;
    private static final int INDEX_PSSYSVIEWPANELID = 71;
    private static final int INDEX_PSSYSVIEWPANELNAME = 72;
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
    private PSPanelEngineBase proxyPSPanelEngineBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
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
    private boolean no2panelitemflagDirtyFlag = false;
    private boolean no2panelitemlabelDirtyFlag = false;
    private boolean no2panellogicflagDirtyFlag = false;
    private boolean no2panellogiclabelDirtyFlag = false;
    private boolean no2pspanelitemidDirtyFlag = false;
    private boolean no2pspanelitemnameDirtyFlag = false;
    private boolean no2pspanellogicidDirtyFlag = false;
    private boolean no2pspanellogicnameDirtyFlag = false;
    private boolean no3panelitemflagDirtyFlag = false;
    private boolean no3panelitemlabelDirtyFlag = false;
    private boolean no3panellogicflagDirtyFlag = false;
    private boolean no3panellogiclabelDirtyFlag = false;
    private boolean no3pspanelitemidDirtyFlag = false;
    private boolean no3pspanelitemnameDirtyFlag = false;
    private boolean no3pspanellogicidDirtyFlag = false;
    private boolean no3pspanellogicnameDirtyFlag = false;
    private boolean no4panelitemflagDirtyFlag = false;
    private boolean no4panelitemlabelDirtyFlag = false;
    private boolean no4panellogicflagDirtyFlag = false;
    private boolean no4panellogiclabelDirtyFlag = false;
    private boolean no4pspanelitemidDirtyFlag = false;
    private boolean no4pspanelitemnameDirtyFlag = false;
    private boolean no4pspanellogicidDirtyFlag = false;
    private boolean no4pspanellogicnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean panelitemflagDirtyFlag = false;
    private boolean panelitemlabelDirtyFlag = false;
    private boolean panellogicflagDirtyFlag = false;
    private boolean panellogiclabelDirtyFlag = false;
    private boolean pspanelengineidDirtyFlag = false;
    private boolean pspanelenginenameDirtyFlag = false;
    private boolean pspanelitemidDirtyFlag = false;
    private boolean pspanelitemnameDirtyFlag = false;
    private boolean pspanellogicidDirtyFlag = false;
    private boolean pspanellogicnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
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
    @Column(name="no2panelitemflag")
    private Integer no2panelitemflag;
    @Column(name="no2panelitemlabel")
    private String no2panelitemlabel;
    @Column(name="no2panellogicflag")
    private Integer no2panellogicflag;
    @Column(name="no2panellogiclabel")
    private String no2panellogiclabel;
    @Column(name="no2pspanelitemid")
    private String no2pspanelitemid;
    @Column(name="no2pspanelitemname")
    private String no2pspanelitemname;
    @Column(name="no2pspanellogicid")
    private String no2pspanellogicid;
    @Column(name="no2pspanellogicname")
    private String no2pspanellogicname;
    @Column(name="no3panelitemflag")
    private Integer no3panelitemflag;
    @Column(name="no3panelitemlabel")
    private String no3panelitemlabel;
    @Column(name="no3panellogicflag")
    private Integer no3panellogicflag;
    @Column(name="no3panellogiclabel")
    private String no3panellogiclabel;
    @Column(name="no3pspanelitemid")
    private String no3pspanelitemid;
    @Column(name="no3pspanelitemname")
    private String no3pspanelitemname;
    @Column(name="no3pspanellogicid")
    private String no3pspanellogicid;
    @Column(name="no3pspanellogicname")
    private String no3pspanellogicname;
    @Column(name="no4panelitemflag")
    private Integer no4panelitemflag;
    @Column(name="no4panelitemlabel")
    private String no4panelitemlabel;
    @Column(name="no4panellogicflag")
    private Integer no4panellogicflag;
    @Column(name="no4panellogiclabel")
    private String no4panellogiclabel;
    @Column(name="no4pspanelitemid")
    private String no4pspanelitemid;
    @Column(name="no4pspanelitemname")
    private String no4pspanelitemname;
    @Column(name="no4pspanellogicid")
    private String no4pspanellogicid;
    @Column(name="no4pspanellogicname")
    private String no4pspanellogicname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="panelitemflag")
    private Integer panelitemflag;
    @Column(name="panelitemlabel")
    private String panelitemlabel;
    @Column(name="panellogicflag")
    private Integer panellogicflag;
    @Column(name="panellogiclabel")
    private String panellogiclabel;
    @Column(name="pspanelengineid")
    private String pspanelengineid;
    @Column(name="pspanelenginename")
    private String pspanelenginename;
    @Column(name="pspanelitemid")
    private String pspanelitemid;
    @Column(name="pspanelitemname")
    private String pspanelitemname;
    @Column(name="pspanellogicid")
    private String pspanellogicid;
    @Column(name="pspanellogicname")
    private String pspanellogicname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
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
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objNo2PSPanelItemLock = new Integer(1);
    private PSSysViewPanelItem no2pspanelitem = null;
    private Integer objNo3PSPanelItemLock = new Integer(1);
    private PSSysViewPanelItem no3pspanelitem = null;
    private Integer objNo4PSPanelItemLock = new Integer(1);
    private PSSysViewPanelItem no4pspanelitem = null;
    private Integer objPSPanelItemLock = new Integer(1);
    private PSSysViewPanelItem pspanelitem = null;
    private Integer objNo2PSPanelLogicLock = new Integer(1);
    private PSSysViewPanelLogic no2pspanellogic = null;
    private Integer objNo3PSPanelLogicLock = new Integer(1);
    private PSSysViewPanelLogic no3pspanellogic = null;
    private Integer objNo4PSPanelLogicLock = new Integer(1);
    private PSSysViewPanelLogic no4pspanellogic = null;
    private Integer objPSPanelLogicLock = new Integer(1);
    private PSSysViewPanelLogic pspanellogic = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
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

    public void setNo2PanelItemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PanelItemFlag(n);
            return;
        }
        this.no2panelitemflag = n;
        this.no2panelitemflagDirtyFlag = true;
    }

    public Integer getNo2PanelItemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PanelItemFlag();
        }
        return this.no2panelitemflag;
    }

    public boolean isNo2PanelItemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PanelItemFlagDirty();
        }
        return this.no2panelitemflagDirtyFlag;
    }

    public void resetNo2PanelItemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PanelItemFlag();
            return;
        }
        this.no2panelitemflagDirtyFlag = false;
        this.no2panelitemflag = null;
    }

    public void setNo2PanelItemLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PanelItemLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2panelitemlabel = string;
        this.no2panelitemlabelDirtyFlag = true;
    }

    public String getNo2PanelItemLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PanelItemLabel();
        }
        return this.no2panelitemlabel;
    }

    public boolean isNo2PanelItemLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PanelItemLabelDirty();
        }
        return this.no2panelitemlabelDirtyFlag;
    }

    public void resetNo2PanelItemLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PanelItemLabel();
            return;
        }
        this.no2panelitemlabelDirtyFlag = false;
        this.no2panelitemlabel = null;
    }

    public void setNo2PanelLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PanelLogicFlag(n);
            return;
        }
        this.no2panellogicflag = n;
        this.no2panellogicflagDirtyFlag = true;
    }

    public Integer getNo2PanelLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PanelLogicFlag();
        }
        return this.no2panellogicflag;
    }

    public boolean isNo2PanelLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PanelLogicFlagDirty();
        }
        return this.no2panellogicflagDirtyFlag;
    }

    public void resetNo2PanelLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PanelLogicFlag();
            return;
        }
        this.no2panellogicflagDirtyFlag = false;
        this.no2panellogicflag = null;
    }

    public void setNo2PanelLogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PanelLogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2panellogiclabel = string;
        this.no2panellogiclabelDirtyFlag = true;
    }

    public String getNo2PanelLogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PanelLogicLabel();
        }
        return this.no2panellogiclabel;
    }

    public boolean isNo2PanelLogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PanelLogicLabelDirty();
        }
        return this.no2panellogiclabelDirtyFlag;
    }

    public void resetNo2PanelLogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PanelLogicLabel();
            return;
        }
        this.no2panellogiclabelDirtyFlag = false;
        this.no2panellogiclabel = null;
    }

    public void setNo2PSPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2pspanelitemid = string;
        this.no2pspanelitemidDirtyFlag = true;
    }

    public String getNo2PSPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSPanelItemId();
        }
        return this.no2pspanelitemid;
    }

    public boolean isNo2PSPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSPanelItemIdDirty();
        }
        return this.no2pspanelitemidDirtyFlag;
    }

    public void resetNo2PSPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSPanelItemId();
            return;
        }
        this.no2pspanelitemidDirtyFlag = false;
        this.no2pspanelitemid = null;
    }

    public void setNo2PSPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2pspanelitemname = string;
        this.no2pspanelitemnameDirtyFlag = true;
    }

    public String getNo2PSPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSPanelItemName();
        }
        return this.no2pspanelitemname;
    }

    public boolean isNo2PSPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSPanelItemNameDirty();
        }
        return this.no2pspanelitemnameDirtyFlag;
    }

    public void resetNo2PSPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSPanelItemName();
            return;
        }
        this.no2pspanelitemnameDirtyFlag = false;
        this.no2pspanelitemname = null;
    }

    public void setNo2PSPanelLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSPanelLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2pspanellogicid = string;
        this.no2pspanellogicidDirtyFlag = true;
    }

    public String getNo2PSPanelLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSPanelLogicId();
        }
        return this.no2pspanellogicid;
    }

    public boolean isNo2PSPanelLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSPanelLogicIdDirty();
        }
        return this.no2pspanellogicidDirtyFlag;
    }

    public void resetNo2PSPanelLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSPanelLogicId();
            return;
        }
        this.no2pspanellogicidDirtyFlag = false;
        this.no2pspanellogicid = null;
    }

    public void setNo2PSPanelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSPanelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2pspanellogicname = string;
        this.no2pspanellogicnameDirtyFlag = true;
    }

    public String getNo2PSPanelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSPanelLogicName();
        }
        return this.no2pspanellogicname;
    }

    public boolean isNo2PSPanelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSPanelLogicNameDirty();
        }
        return this.no2pspanellogicnameDirtyFlag;
    }

    public void resetNo2PSPanelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSPanelLogicName();
            return;
        }
        this.no2pspanellogicnameDirtyFlag = false;
        this.no2pspanellogicname = null;
    }

    public void setNo3PanelItemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PanelItemFlag(n);
            return;
        }
        this.no3panelitemflag = n;
        this.no3panelitemflagDirtyFlag = true;
    }

    public Integer getNo3PanelItemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PanelItemFlag();
        }
        return this.no3panelitemflag;
    }

    public boolean isNo3PanelItemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PanelItemFlagDirty();
        }
        return this.no3panelitemflagDirtyFlag;
    }

    public void resetNo3PanelItemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PanelItemFlag();
            return;
        }
        this.no3panelitemflagDirtyFlag = false;
        this.no3panelitemflag = null;
    }

    public void setNo3PanelItemLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PanelItemLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3panelitemlabel = string;
        this.no3panelitemlabelDirtyFlag = true;
    }

    public String getNo3PanelItemLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PanelItemLabel();
        }
        return this.no3panelitemlabel;
    }

    public boolean isNo3PanelItemLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PanelItemLabelDirty();
        }
        return this.no3panelitemlabelDirtyFlag;
    }

    public void resetNo3PanelItemLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PanelItemLabel();
            return;
        }
        this.no3panelitemlabelDirtyFlag = false;
        this.no3panelitemlabel = null;
    }

    public void setNo3PanelLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PanelLogicFlag(n);
            return;
        }
        this.no3panellogicflag = n;
        this.no3panellogicflagDirtyFlag = true;
    }

    public Integer getNo3PanelLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PanelLogicFlag();
        }
        return this.no3panellogicflag;
    }

    public boolean isNo3PanelLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PanelLogicFlagDirty();
        }
        return this.no3panellogicflagDirtyFlag;
    }

    public void resetNo3PanelLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PanelLogicFlag();
            return;
        }
        this.no3panellogicflagDirtyFlag = false;
        this.no3panellogicflag = null;
    }

    public void setNo3PanelLogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PanelLogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3panellogiclabel = string;
        this.no3panellogiclabelDirtyFlag = true;
    }

    public String getNo3PanelLogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PanelLogicLabel();
        }
        return this.no3panellogiclabel;
    }

    public boolean isNo3PanelLogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PanelLogicLabelDirty();
        }
        return this.no3panellogiclabelDirtyFlag;
    }

    public void resetNo3PanelLogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PanelLogicLabel();
            return;
        }
        this.no3panellogiclabelDirtyFlag = false;
        this.no3panellogiclabel = null;
    }

    public void setNo3PSPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3pspanelitemid = string;
        this.no3pspanelitemidDirtyFlag = true;
    }

    public String getNo3PSPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSPanelItemId();
        }
        return this.no3pspanelitemid;
    }

    public boolean isNo3PSPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSPanelItemIdDirty();
        }
        return this.no3pspanelitemidDirtyFlag;
    }

    public void resetNo3PSPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSPanelItemId();
            return;
        }
        this.no3pspanelitemidDirtyFlag = false;
        this.no3pspanelitemid = null;
    }

    public void setNo3PSPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3pspanelitemname = string;
        this.no3pspanelitemnameDirtyFlag = true;
    }

    public String getNo3PSPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSPanelItemName();
        }
        return this.no3pspanelitemname;
    }

    public boolean isNo3PSPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSPanelItemNameDirty();
        }
        return this.no3pspanelitemnameDirtyFlag;
    }

    public void resetNo3PSPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSPanelItemName();
            return;
        }
        this.no3pspanelitemnameDirtyFlag = false;
        this.no3pspanelitemname = null;
    }

    public void setNo3PSPanelLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSPanelLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3pspanellogicid = string;
        this.no3pspanellogicidDirtyFlag = true;
    }

    public String getNo3PSPanelLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSPanelLogicId();
        }
        return this.no3pspanellogicid;
    }

    public boolean isNo3PSPanelLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSPanelLogicIdDirty();
        }
        return this.no3pspanellogicidDirtyFlag;
    }

    public void resetNo3PSPanelLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSPanelLogicId();
            return;
        }
        this.no3pspanellogicidDirtyFlag = false;
        this.no3pspanellogicid = null;
    }

    public void setNo3PSPanelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3PSPanelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3pspanellogicname = string;
        this.no3pspanellogicnameDirtyFlag = true;
    }

    public String getNo3PSPanelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSPanelLogicName();
        }
        return this.no3pspanellogicname;
    }

    public boolean isNo3PSPanelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3PSPanelLogicNameDirty();
        }
        return this.no3pspanellogicnameDirtyFlag;
    }

    public void resetNo3PSPanelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3PSPanelLogicName();
            return;
        }
        this.no3pspanellogicnameDirtyFlag = false;
        this.no3pspanellogicname = null;
    }

    public void setNo4PanelItemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PanelItemFlag(n);
            return;
        }
        this.no4panelitemflag = n;
        this.no4panelitemflagDirtyFlag = true;
    }

    public Integer getNo4PanelItemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PanelItemFlag();
        }
        return this.no4panelitemflag;
    }

    public boolean isNo4PanelItemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PanelItemFlagDirty();
        }
        return this.no4panelitemflagDirtyFlag;
    }

    public void resetNo4PanelItemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PanelItemFlag();
            return;
        }
        this.no4panelitemflagDirtyFlag = false;
        this.no4panelitemflag = null;
    }

    public void setNo4PanelItemLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PanelItemLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4panelitemlabel = string;
        this.no4panelitemlabelDirtyFlag = true;
    }

    public String getNo4PanelItemLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PanelItemLabel();
        }
        return this.no4panelitemlabel;
    }

    public boolean isNo4PanelItemLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PanelItemLabelDirty();
        }
        return this.no4panelitemlabelDirtyFlag;
    }

    public void resetNo4PanelItemLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PanelItemLabel();
            return;
        }
        this.no4panelitemlabelDirtyFlag = false;
        this.no4panelitemlabel = null;
    }

    public void setNo4PanelLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PanelLogicFlag(n);
            return;
        }
        this.no4panellogicflag = n;
        this.no4panellogicflagDirtyFlag = true;
    }

    public Integer getNo4PanelLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PanelLogicFlag();
        }
        return this.no4panellogicflag;
    }

    public boolean isNo4PanelLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PanelLogicFlagDirty();
        }
        return this.no4panellogicflagDirtyFlag;
    }

    public void resetNo4PanelLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PanelLogicFlag();
            return;
        }
        this.no4panellogicflagDirtyFlag = false;
        this.no4panellogicflag = null;
    }

    public void setNo4PanelLogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PanelLogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4panellogiclabel = string;
        this.no4panellogiclabelDirtyFlag = true;
    }

    public String getNo4PanelLogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PanelLogicLabel();
        }
        return this.no4panellogiclabel;
    }

    public boolean isNo4PanelLogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PanelLogicLabelDirty();
        }
        return this.no4panellogiclabelDirtyFlag;
    }

    public void resetNo4PanelLogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PanelLogicLabel();
            return;
        }
        this.no4panellogiclabelDirtyFlag = false;
        this.no4panellogiclabel = null;
    }

    public void setNo4PSPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4pspanelitemid = string;
        this.no4pspanelitemidDirtyFlag = true;
    }

    public String getNo4PSPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSPanelItemId();
        }
        return this.no4pspanelitemid;
    }

    public boolean isNo4PSPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSPanelItemIdDirty();
        }
        return this.no4pspanelitemidDirtyFlag;
    }

    public void resetNo4PSPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSPanelItemId();
            return;
        }
        this.no4pspanelitemidDirtyFlag = false;
        this.no4pspanelitemid = null;
    }

    public void setNo4PSPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4pspanelitemname = string;
        this.no4pspanelitemnameDirtyFlag = true;
    }

    public String getNo4PSPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSPanelItemName();
        }
        return this.no4pspanelitemname;
    }

    public boolean isNo4PSPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSPanelItemNameDirty();
        }
        return this.no4pspanelitemnameDirtyFlag;
    }

    public void resetNo4PSPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSPanelItemName();
            return;
        }
        this.no4pspanelitemnameDirtyFlag = false;
        this.no4pspanelitemname = null;
    }

    public void setNo4PSPanelLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSPanelLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4pspanellogicid = string;
        this.no4pspanellogicidDirtyFlag = true;
    }

    public String getNo4PSPanelLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSPanelLogicId();
        }
        return this.no4pspanellogicid;
    }

    public boolean isNo4PSPanelLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSPanelLogicIdDirty();
        }
        return this.no4pspanellogicidDirtyFlag;
    }

    public void resetNo4PSPanelLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSPanelLogicId();
            return;
        }
        this.no4pspanellogicidDirtyFlag = false;
        this.no4pspanellogicid = null;
    }

    public void setNo4PSPanelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4PSPanelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4pspanellogicname = string;
        this.no4pspanellogicnameDirtyFlag = true;
    }

    public String getNo4PSPanelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSPanelLogicName();
        }
        return this.no4pspanellogicname;
    }

    public boolean isNo4PSPanelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4PSPanelLogicNameDirty();
        }
        return this.no4pspanellogicnameDirtyFlag;
    }

    public void resetNo4PSPanelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4PSPanelLogicName();
            return;
        }
        this.no4pspanellogicnameDirtyFlag = false;
        this.no4pspanellogicname = null;
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

    public void setPanelItemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelItemFlag(n);
            return;
        }
        this.panelitemflag = n;
        this.panelitemflagDirtyFlag = true;
    }

    public Integer getPanelItemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelItemFlag();
        }
        return this.panelitemflag;
    }

    public boolean isPanelItemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelItemFlagDirty();
        }
        return this.panelitemflagDirtyFlag;
    }

    public void resetPanelItemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelItemFlag();
            return;
        }
        this.panelitemflagDirtyFlag = false;
        this.panelitemflag = null;
    }

    public void setPanelItemLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelItemLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.panelitemlabel = string;
        this.panelitemlabelDirtyFlag = true;
    }

    public String getPanelItemLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelItemLabel();
        }
        return this.panelitemlabel;
    }

    public boolean isPanelItemLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelItemLabelDirty();
        }
        return this.panelitemlabelDirtyFlag;
    }

    public void resetPanelItemLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelItemLabel();
            return;
        }
        this.panelitemlabelDirtyFlag = false;
        this.panelitemlabel = null;
    }

    public void setPanelLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelLogicFlag(n);
            return;
        }
        this.panellogicflag = n;
        this.panellogicflagDirtyFlag = true;
    }

    public Integer getPanelLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelLogicFlag();
        }
        return this.panellogicflag;
    }

    public boolean isPanelLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelLogicFlagDirty();
        }
        return this.panellogicflagDirtyFlag;
    }

    public void resetPanelLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelLogicFlag();
            return;
        }
        this.panellogicflagDirtyFlag = false;
        this.panellogicflag = null;
    }

    public void setPanelLogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelLogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.panellogiclabel = string;
        this.panellogiclabelDirtyFlag = true;
    }

    public String getPanelLogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelLogicLabel();
        }
        return this.panellogiclabel;
    }

    public boolean isPanelLogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelLogicLabelDirty();
        }
        return this.panellogiclabelDirtyFlag;
    }

    public void resetPanelLogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelLogicLabel();
            return;
        }
        this.panellogiclabelDirtyFlag = false;
        this.panellogiclabel = null;
    }

    public void setPSPanelEngineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelEngineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelengineid = string;
        this.pspanelengineidDirtyFlag = true;
    }

    public String getPSPanelEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelEngineId();
        }
        return this.pspanelengineid;
    }

    public boolean isPSPanelEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelEngineIdDirty();
        }
        return this.pspanelengineidDirtyFlag;
    }

    public void resetPSPanelEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelEngineId();
            return;
        }
        this.pspanelengineidDirtyFlag = false;
        this.pspanelengineid = null;
    }

    public void setPSPanelEngineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelEngineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelenginename = string;
        this.pspanelenginenameDirtyFlag = true;
    }

    public String getPSPanelEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelEngineName();
        }
        return this.pspanelenginename;
    }

    public boolean isPSPanelEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelEngineNameDirty();
        }
        return this.pspanelenginenameDirtyFlag;
    }

    public void resetPSPanelEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelEngineName();
            return;
        }
        this.pspanelenginenameDirtyFlag = false;
        this.pspanelenginename = null;
    }

    public void setPSPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelitemid = string;
        this.pspanelitemidDirtyFlag = true;
    }

    public String getPSPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelItemId();
        }
        return this.pspanelitemid;
    }

    public boolean isPSPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelItemIdDirty();
        }
        return this.pspanelitemidDirtyFlag;
    }

    public void resetPSPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelItemId();
            return;
        }
        this.pspanelitemidDirtyFlag = false;
        this.pspanelitemid = null;
    }

    public void setPSPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelitemname = string;
        this.pspanelitemnameDirtyFlag = true;
    }

    public String getPSPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelItemName();
        }
        return this.pspanelitemname;
    }

    public boolean isPSPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelItemNameDirty();
        }
        return this.pspanelitemnameDirtyFlag;
    }

    public void resetPSPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelItemName();
            return;
        }
        this.pspanelitemnameDirtyFlag = false;
        this.pspanelitemname = null;
    }

    public void setPSPanelLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicid = string;
        this.pspanellogicidDirtyFlag = true;
    }

    public String getPSPanelLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicId();
        }
        return this.pspanellogicid;
    }

    public boolean isPSPanelLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicIdDirty();
        }
        return this.pspanellogicidDirtyFlag;
    }

    public void resetPSPanelLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicId();
            return;
        }
        this.pspanellogicidDirtyFlag = false;
        this.pspanellogicid = null;
    }

    public void setPSPanelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicname = string;
        this.pspanellogicnameDirtyFlag = true;
    }

    public String getPSPanelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicName();
        }
        return this.pspanellogicname;
    }

    public boolean isPSPanelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicNameDirty();
        }
        return this.pspanellogicnameDirtyFlag;
    }

    public void resetPSPanelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicName();
            return;
        }
        this.pspanellogicnameDirtyFlag = false;
        this.pspanellogicname = null;
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

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
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
        PSPanelEngineBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelEngineBase pSPanelEngineBase) {
        pSPanelEngineBase.resetCreateDate();
        pSPanelEngineBase.resetCreateMan();
        pSPanelEngineBase.resetEngineOption();
        pSPanelEngineBase.resetEngineParam();
        pSPanelEngineBase.resetEngineParam10();
        pSPanelEngineBase.resetEngineParam10Flag();
        pSPanelEngineBase.resetEngineParam10Label();
        pSPanelEngineBase.resetEngineParam2();
        pSPanelEngineBase.resetEngineParam2Flag();
        pSPanelEngineBase.resetEngineParam2Label();
        pSPanelEngineBase.resetEngineParam3();
        pSPanelEngineBase.resetEngineParam3Flag();
        pSPanelEngineBase.resetEngineParam3Label();
        pSPanelEngineBase.resetEngineParam4();
        pSPanelEngineBase.resetEngineParam4Flag();
        pSPanelEngineBase.resetEngineParam4Label();
        pSPanelEngineBase.resetEngineParam5();
        pSPanelEngineBase.resetEngineParam5Flag();
        pSPanelEngineBase.resetEngineParam5Label();
        pSPanelEngineBase.resetEngineParam6();
        pSPanelEngineBase.resetEngineParam6Flag();
        pSPanelEngineBase.resetEngineParam6Label();
        pSPanelEngineBase.resetEngineParam7();
        pSPanelEngineBase.resetEngineParam7Flag();
        pSPanelEngineBase.resetEngineParam7Label();
        pSPanelEngineBase.resetEngineParam8();
        pSPanelEngineBase.resetEngineParam8Flag();
        pSPanelEngineBase.resetEngineParam8Label();
        pSPanelEngineBase.resetEngineParam9();
        pSPanelEngineBase.resetEngineParam9Flag();
        pSPanelEngineBase.resetEngineParam9Label();
        pSPanelEngineBase.resetEngineParamFlag();
        pSPanelEngineBase.resetEngineParamLabel();
        pSPanelEngineBase.resetMemo();
        pSPanelEngineBase.resetNo2PanelItemFlag();
        pSPanelEngineBase.resetNo2PanelItemLabel();
        pSPanelEngineBase.resetNo2PanelLogicFlag();
        pSPanelEngineBase.resetNo2PanelLogicLabel();
        pSPanelEngineBase.resetNo2PSPanelItemId();
        pSPanelEngineBase.resetNo2PSPanelItemName();
        pSPanelEngineBase.resetNo2PSPanelLogicId();
        pSPanelEngineBase.resetNo2PSPanelLogicName();
        pSPanelEngineBase.resetNo3PanelItemFlag();
        pSPanelEngineBase.resetNo3PanelItemLabel();
        pSPanelEngineBase.resetNo3PanelLogicFlag();
        pSPanelEngineBase.resetNo3PanelLogicLabel();
        pSPanelEngineBase.resetNo3PSPanelItemId();
        pSPanelEngineBase.resetNo3PSPanelItemName();
        pSPanelEngineBase.resetNo3PSPanelLogicId();
        pSPanelEngineBase.resetNo3PSPanelLogicName();
        pSPanelEngineBase.resetNo4PanelItemFlag();
        pSPanelEngineBase.resetNo4PanelItemLabel();
        pSPanelEngineBase.resetNo4PanelLogicFlag();
        pSPanelEngineBase.resetNo4PanelLogicLabel();
        pSPanelEngineBase.resetNo4PSPanelItemId();
        pSPanelEngineBase.resetNo4PSPanelItemName();
        pSPanelEngineBase.resetNo4PSPanelLogicId();
        pSPanelEngineBase.resetNo4PSPanelLogicName();
        pSPanelEngineBase.resetOrderValue();
        pSPanelEngineBase.resetPanelItemFlag();
        pSPanelEngineBase.resetPanelItemLabel();
        pSPanelEngineBase.resetPanelLogicFlag();
        pSPanelEngineBase.resetPanelLogicLabel();
        pSPanelEngineBase.resetPSPanelEngineId();
        pSPanelEngineBase.resetPSPanelEngineName();
        pSPanelEngineBase.resetPSPanelItemId();
        pSPanelEngineBase.resetPSPanelItemName();
        pSPanelEngineBase.resetPSPanelLogicId();
        pSPanelEngineBase.resetPSPanelLogicName();
        pSPanelEngineBase.resetPSSysPFPluginId();
        pSPanelEngineBase.resetPSSysPFPluginName();
        pSPanelEngineBase.resetPSSysViewPanelId();
        pSPanelEngineBase.resetPSSysViewPanelName();
        pSPanelEngineBase.resetPSUIEngineTypeId();
        pSPanelEngineBase.resetPSUIEngineTypeName();
        pSPanelEngineBase.resetUpdateDate();
        pSPanelEngineBase.resetUpdateMan();
        pSPanelEngineBase.resetUserCat();
        pSPanelEngineBase.resetUserTag();
        pSPanelEngineBase.resetUserTag2();
        pSPanelEngineBase.resetUserTag3();
        pSPanelEngineBase.resetUserTag4();
        pSPanelEngineBase.resetValidFlag();
        pSPanelEngineBase.resetViewParam();
        pSPanelEngineBase.resetViewParam10();
        pSPanelEngineBase.resetViewParam2();
        pSPanelEngineBase.resetViewParam3();
        pSPanelEngineBase.resetViewParam4();
        pSPanelEngineBase.resetViewParam5();
        pSPanelEngineBase.resetViewParam6();
        pSPanelEngineBase.resetViewParam7();
        pSPanelEngineBase.resetViewParam8();
        pSPanelEngineBase.resetViewParam9();
        pSPanelEngineBase.resetWFViewParam();
        pSPanelEngineBase.resetWFViewParam2();
        pSPanelEngineBase.resetWFViewParam3();
        pSPanelEngineBase.resetWFViewParam4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bl || this.isNo2PanelItemFlagDirty()) {
            hashMap.put(FIELD_NO2PANELITEMFLAG, this.getNo2PanelItemFlag());
        }
        if (!bl || this.isNo2PanelItemLabelDirty()) {
            hashMap.put(FIELD_NO2PANELITEMLABEL, this.getNo2PanelItemLabel());
        }
        if (!bl || this.isNo2PanelLogicFlagDirty()) {
            hashMap.put(FIELD_NO2PANELLOGICFLAG, this.getNo2PanelLogicFlag());
        }
        if (!bl || this.isNo2PanelLogicLabelDirty()) {
            hashMap.put(FIELD_NO2PANELLOGICLABEL, this.getNo2PanelLogicLabel());
        }
        if (!bl || this.isNo2PSPanelItemIdDirty()) {
            hashMap.put(FIELD_NO2PSPANELITEMID, this.getNo2PSPanelItemId());
        }
        if (!bl || this.isNo2PSPanelItemNameDirty()) {
            hashMap.put(FIELD_NO2PSPANELITEMNAME, this.getNo2PSPanelItemName());
        }
        if (!bl || this.isNo2PSPanelLogicIdDirty()) {
            hashMap.put(FIELD_NO2PSPANELLOGICID, this.getNo2PSPanelLogicId());
        }
        if (!bl || this.isNo2PSPanelLogicNameDirty()) {
            hashMap.put(FIELD_NO2PSPANELLOGICNAME, this.getNo2PSPanelLogicName());
        }
        if (!bl || this.isNo3PanelItemFlagDirty()) {
            hashMap.put(FIELD_NO3PANELITEMFLAG, this.getNo3PanelItemFlag());
        }
        if (!bl || this.isNo3PanelItemLabelDirty()) {
            hashMap.put(FIELD_NO3PANELITEMLABEL, this.getNo3PanelItemLabel());
        }
        if (!bl || this.isNo3PanelLogicFlagDirty()) {
            hashMap.put(FIELD_NO3PANELLOGICFLAG, this.getNo3PanelLogicFlag());
        }
        if (!bl || this.isNo3PanelLogicLabelDirty()) {
            hashMap.put(FIELD_NO3PANELLOGICLABEL, this.getNo3PanelLogicLabel());
        }
        if (!bl || this.isNo3PSPanelItemIdDirty()) {
            hashMap.put(FIELD_NO3PSPANELITEMID, this.getNo3PSPanelItemId());
        }
        if (!bl || this.isNo3PSPanelItemNameDirty()) {
            hashMap.put(FIELD_NO3PSPANELITEMNAME, this.getNo3PSPanelItemName());
        }
        if (!bl || this.isNo3PSPanelLogicIdDirty()) {
            hashMap.put(FIELD_NO3PSPANELLOGICID, this.getNo3PSPanelLogicId());
        }
        if (!bl || this.isNo3PSPanelLogicNameDirty()) {
            hashMap.put(FIELD_NO3PSPANELLOGICNAME, this.getNo3PSPanelLogicName());
        }
        if (!bl || this.isNo4PanelItemFlagDirty()) {
            hashMap.put(FIELD_NO4PANELITEMFLAG, this.getNo4PanelItemFlag());
        }
        if (!bl || this.isNo4PanelItemLabelDirty()) {
            hashMap.put(FIELD_NO4PANELITEMLABEL, this.getNo4PanelItemLabel());
        }
        if (!bl || this.isNo4PanelLogicFlagDirty()) {
            hashMap.put(FIELD_NO4PANELLOGICFLAG, this.getNo4PanelLogicFlag());
        }
        if (!bl || this.isNo4PanelLogicLabelDirty()) {
            hashMap.put(FIELD_NO4PANELLOGICLABEL, this.getNo4PanelLogicLabel());
        }
        if (!bl || this.isNo4PSPanelItemIdDirty()) {
            hashMap.put(FIELD_NO4PSPANELITEMID, this.getNo4PSPanelItemId());
        }
        if (!bl || this.isNo4PSPanelItemNameDirty()) {
            hashMap.put(FIELD_NO4PSPANELITEMNAME, this.getNo4PSPanelItemName());
        }
        if (!bl || this.isNo4PSPanelLogicIdDirty()) {
            hashMap.put(FIELD_NO4PSPANELLOGICID, this.getNo4PSPanelLogicId());
        }
        if (!bl || this.isNo4PSPanelLogicNameDirty()) {
            hashMap.put(FIELD_NO4PSPANELLOGICNAME, this.getNo4PSPanelLogicName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPanelItemFlagDirty()) {
            hashMap.put(FIELD_PANELITEMFLAG, this.getPanelItemFlag());
        }
        if (!bl || this.isPanelItemLabelDirty()) {
            hashMap.put(FIELD_PANELITEMLABEL, this.getPanelItemLabel());
        }
        if (!bl || this.isPanelLogicFlagDirty()) {
            hashMap.put(FIELD_PANELLOGICFLAG, this.getPanelLogicFlag());
        }
        if (!bl || this.isPanelLogicLabelDirty()) {
            hashMap.put(FIELD_PANELLOGICLABEL, this.getPanelLogicLabel());
        }
        if (!bl || this.isPSPanelEngineIdDirty()) {
            hashMap.put(FIELD_PSPANELENGINEID, this.getPSPanelEngineId());
        }
        if (!bl || this.isPSPanelEngineNameDirty()) {
            hashMap.put(FIELD_PSPANELENGINENAME, this.getPSPanelEngineName());
        }
        if (!bl || this.isPSPanelItemIdDirty()) {
            hashMap.put(FIELD_PSPANELITEMID, this.getPSPanelItemId());
        }
        if (!bl || this.isPSPanelItemNameDirty()) {
            hashMap.put(FIELD_PSPANELITEMNAME, this.getPSPanelItemName());
        }
        if (!bl || this.isPSPanelLogicIdDirty()) {
            hashMap.put(FIELD_PSPANELLOGICID, this.getPSPanelLogicId());
        }
        if (!bl || this.isPSPanelLogicNameDirty()) {
            hashMap.put(FIELD_PSPANELLOGICNAME, this.getPSPanelLogicName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
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
        return PSPanelEngineBase.get(this, n);
    }

    private static Object get(PSPanelEngineBase pSPanelEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelEngineBase.getCreateDate();
            }
            case 1: {
                return pSPanelEngineBase.getCreateMan();
            }
            case 2: {
                return pSPanelEngineBase.getEngineOption();
            }
            case 3: {
                return pSPanelEngineBase.getEngineParam();
            }
            case 4: {
                return pSPanelEngineBase.getEngineParam10();
            }
            case 5: {
                return pSPanelEngineBase.getEngineParam10Flag();
            }
            case 6: {
                return pSPanelEngineBase.getEngineParam10Label();
            }
            case 7: {
                return pSPanelEngineBase.getEngineParam2();
            }
            case 8: {
                return pSPanelEngineBase.getEngineParam2Flag();
            }
            case 9: {
                return pSPanelEngineBase.getEngineParam2Label();
            }
            case 10: {
                return pSPanelEngineBase.getEngineParam3();
            }
            case 11: {
                return pSPanelEngineBase.getEngineParam3Flag();
            }
            case 12: {
                return pSPanelEngineBase.getEngineParam3Label();
            }
            case 13: {
                return pSPanelEngineBase.getEngineParam4();
            }
            case 14: {
                return pSPanelEngineBase.getEngineParam4Flag();
            }
            case 15: {
                return pSPanelEngineBase.getEngineParam4Label();
            }
            case 16: {
                return pSPanelEngineBase.getEngineParam5();
            }
            case 17: {
                return pSPanelEngineBase.getEngineParam5Flag();
            }
            case 18: {
                return pSPanelEngineBase.getEngineParam5Label();
            }
            case 19: {
                return pSPanelEngineBase.getEngineParam6();
            }
            case 20: {
                return pSPanelEngineBase.getEngineParam6Flag();
            }
            case 21: {
                return pSPanelEngineBase.getEngineParam6Label();
            }
            case 22: {
                return pSPanelEngineBase.getEngineParam7();
            }
            case 23: {
                return pSPanelEngineBase.getEngineParam7Flag();
            }
            case 24: {
                return pSPanelEngineBase.getEngineParam7Label();
            }
            case 25: {
                return pSPanelEngineBase.getEngineParam8();
            }
            case 26: {
                return pSPanelEngineBase.getEngineParam8Flag();
            }
            case 27: {
                return pSPanelEngineBase.getEngineParam8Label();
            }
            case 28: {
                return pSPanelEngineBase.getEngineParam9();
            }
            case 29: {
                return pSPanelEngineBase.getEngineParam9Flag();
            }
            case 30: {
                return pSPanelEngineBase.getEngineParam9Label();
            }
            case 31: {
                return pSPanelEngineBase.getEngineParamFlag();
            }
            case 32: {
                return pSPanelEngineBase.getEngineParamLabel();
            }
            case 33: {
                return pSPanelEngineBase.getMemo();
            }
            case 34: {
                return pSPanelEngineBase.getNo2PanelItemFlag();
            }
            case 35: {
                return pSPanelEngineBase.getNo2PanelItemLabel();
            }
            case 36: {
                return pSPanelEngineBase.getNo2PanelLogicFlag();
            }
            case 37: {
                return pSPanelEngineBase.getNo2PanelLogicLabel();
            }
            case 38: {
                return pSPanelEngineBase.getNo2PSPanelItemId();
            }
            case 39: {
                return pSPanelEngineBase.getNo2PSPanelItemName();
            }
            case 40: {
                return pSPanelEngineBase.getNo2PSPanelLogicId();
            }
            case 41: {
                return pSPanelEngineBase.getNo2PSPanelLogicName();
            }
            case 42: {
                return pSPanelEngineBase.getNo3PanelItemFlag();
            }
            case 43: {
                return pSPanelEngineBase.getNo3PanelItemLabel();
            }
            case 44: {
                return pSPanelEngineBase.getNo3PanelLogicFlag();
            }
            case 45: {
                return pSPanelEngineBase.getNo3PanelLogicLabel();
            }
            case 46: {
                return pSPanelEngineBase.getNo3PSPanelItemId();
            }
            case 47: {
                return pSPanelEngineBase.getNo3PSPanelItemName();
            }
            case 48: {
                return pSPanelEngineBase.getNo3PSPanelLogicId();
            }
            case 49: {
                return pSPanelEngineBase.getNo3PSPanelLogicName();
            }
            case 50: {
                return pSPanelEngineBase.getNo4PanelItemFlag();
            }
            case 51: {
                return pSPanelEngineBase.getNo4PanelItemLabel();
            }
            case 52: {
                return pSPanelEngineBase.getNo4PanelLogicFlag();
            }
            case 53: {
                return pSPanelEngineBase.getNo4PanelLogicLabel();
            }
            case 54: {
                return pSPanelEngineBase.getNo4PSPanelItemId();
            }
            case 55: {
                return pSPanelEngineBase.getNo4PSPanelItemName();
            }
            case 56: {
                return pSPanelEngineBase.getNo4PSPanelLogicId();
            }
            case 57: {
                return pSPanelEngineBase.getNo4PSPanelLogicName();
            }
            case 58: {
                return pSPanelEngineBase.getOrderValue();
            }
            case 59: {
                return pSPanelEngineBase.getPanelItemFlag();
            }
            case 60: {
                return pSPanelEngineBase.getPanelItemLabel();
            }
            case 61: {
                return pSPanelEngineBase.getPanelLogicFlag();
            }
            case 62: {
                return pSPanelEngineBase.getPanelLogicLabel();
            }
            case 63: {
                return pSPanelEngineBase.getPSPanelEngineId();
            }
            case 64: {
                return pSPanelEngineBase.getPSPanelEngineName();
            }
            case 65: {
                return pSPanelEngineBase.getPSPanelItemId();
            }
            case 66: {
                return pSPanelEngineBase.getPSPanelItemName();
            }
            case 67: {
                return pSPanelEngineBase.getPSPanelLogicId();
            }
            case 68: {
                return pSPanelEngineBase.getPSPanelLogicName();
            }
            case 69: {
                return pSPanelEngineBase.getPSSysPFPluginId();
            }
            case 70: {
                return pSPanelEngineBase.getPSSysPFPluginName();
            }
            case 71: {
                return pSPanelEngineBase.getPSSysViewPanelId();
            }
            case 72: {
                return pSPanelEngineBase.getPSSysViewPanelName();
            }
            case 73: {
                return pSPanelEngineBase.getPSUIEngineTypeId();
            }
            case 74: {
                return pSPanelEngineBase.getPSUIEngineTypeName();
            }
            case 75: {
                return pSPanelEngineBase.getUpdateDate();
            }
            case 76: {
                return pSPanelEngineBase.getUpdateMan();
            }
            case 77: {
                return pSPanelEngineBase.getUserCat();
            }
            case 78: {
                return pSPanelEngineBase.getUserTag();
            }
            case 79: {
                return pSPanelEngineBase.getUserTag2();
            }
            case 80: {
                return pSPanelEngineBase.getUserTag3();
            }
            case 81: {
                return pSPanelEngineBase.getUserTag4();
            }
            case 82: {
                return pSPanelEngineBase.getValidFlag();
            }
            case 83: {
                return pSPanelEngineBase.getViewParam();
            }
            case 84: {
                return pSPanelEngineBase.getViewParam10();
            }
            case 85: {
                return pSPanelEngineBase.getViewParam2();
            }
            case 86: {
                return pSPanelEngineBase.getViewParam3();
            }
            case 87: {
                return pSPanelEngineBase.getViewParam4();
            }
            case 88: {
                return pSPanelEngineBase.getViewParam5();
            }
            case 89: {
                return pSPanelEngineBase.getViewParam6();
            }
            case 90: {
                return pSPanelEngineBase.getViewParam7();
            }
            case 91: {
                return pSPanelEngineBase.getViewParam8();
            }
            case 92: {
                return pSPanelEngineBase.getViewParam9();
            }
            case 93: {
                return pSPanelEngineBase.getWFViewParam();
            }
            case 94: {
                return pSPanelEngineBase.getWFViewParam2();
            }
            case 95: {
                return pSPanelEngineBase.getWFViewParam3();
            }
            case 96: {
                return pSPanelEngineBase.getWFViewParam4();
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
        PSPanelEngineBase.set(this, n, object);
    }

    private static void set(PSPanelEngineBase pSPanelEngineBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelEngineBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPanelEngineBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelEngineBase.setEngineOption(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPanelEngineBase.setEngineParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelEngineBase.setEngineParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSPanelEngineBase.setEngineParam10Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSPanelEngineBase.setEngineParam10Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPanelEngineBase.setEngineParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPanelEngineBase.setEngineParam2Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSPanelEngineBase.setEngineParam2Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPanelEngineBase.setEngineParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPanelEngineBase.setEngineParam3Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSPanelEngineBase.setEngineParam3Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPanelEngineBase.setEngineParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPanelEngineBase.setEngineParam4Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSPanelEngineBase.setEngineParam4Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPanelEngineBase.setEngineParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSPanelEngineBase.setEngineParam5Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSPanelEngineBase.setEngineParam5Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPanelEngineBase.setEngineParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSPanelEngineBase.setEngineParam6Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSPanelEngineBase.setEngineParam6Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPanelEngineBase.setEngineParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSPanelEngineBase.setEngineParam7Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSPanelEngineBase.setEngineParam7Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSPanelEngineBase.setEngineParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSPanelEngineBase.setEngineParam8Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSPanelEngineBase.setEngineParam8Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSPanelEngineBase.setEngineParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSPanelEngineBase.setEngineParam9Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSPanelEngineBase.setEngineParam9Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSPanelEngineBase.setEngineParamFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSPanelEngineBase.setEngineParamLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSPanelEngineBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSPanelEngineBase.setNo2PanelItemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSPanelEngineBase.setNo2PanelItemLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSPanelEngineBase.setNo2PanelLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSPanelEngineBase.setNo2PanelLogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSPanelEngineBase.setNo2PSPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSPanelEngineBase.setNo2PSPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSPanelEngineBase.setNo2PSPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSPanelEngineBase.setNo2PSPanelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSPanelEngineBase.setNo3PanelItemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSPanelEngineBase.setNo3PanelItemLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSPanelEngineBase.setNo3PanelLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSPanelEngineBase.setNo3PanelLogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSPanelEngineBase.setNo3PSPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSPanelEngineBase.setNo3PSPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSPanelEngineBase.setNo3PSPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSPanelEngineBase.setNo3PSPanelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSPanelEngineBase.setNo4PanelItemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSPanelEngineBase.setNo4PanelItemLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSPanelEngineBase.setNo4PanelLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSPanelEngineBase.setNo4PanelLogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSPanelEngineBase.setNo4PSPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSPanelEngineBase.setNo4PSPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSPanelEngineBase.setNo4PSPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSPanelEngineBase.setNo4PSPanelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSPanelEngineBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSPanelEngineBase.setPanelItemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSPanelEngineBase.setPanelItemLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSPanelEngineBase.setPanelLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSPanelEngineBase.setPanelLogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSPanelEngineBase.setPSPanelEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSPanelEngineBase.setPSPanelEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSPanelEngineBase.setPSPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSPanelEngineBase.setPSPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSPanelEngineBase.setPSPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSPanelEngineBase.setPSPanelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSPanelEngineBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSPanelEngineBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSPanelEngineBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSPanelEngineBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSPanelEngineBase.setPSUIEngineTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSPanelEngineBase.setPSUIEngineTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSPanelEngineBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 76: {
                pSPanelEngineBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSPanelEngineBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSPanelEngineBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSPanelEngineBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSPanelEngineBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSPanelEngineBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSPanelEngineBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSPanelEngineBase.setViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSPanelEngineBase.setViewParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 85: {
                pSPanelEngineBase.setViewParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSPanelEngineBase.setViewParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 87: {
                pSPanelEngineBase.setViewParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 88: {
                pSPanelEngineBase.setViewParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 89: {
                pSPanelEngineBase.setViewParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 90: {
                pSPanelEngineBase.setViewParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSPanelEngineBase.setViewParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSPanelEngineBase.setViewParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 93: {
                pSPanelEngineBase.setWFViewParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 94: {
                pSPanelEngineBase.setWFViewParam2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 95: {
                pSPanelEngineBase.setWFViewParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSPanelEngineBase.setWFViewParam4(DataObject.getStringValue((Object)object));
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
        return PSPanelEngineBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelEngineBase pSPanelEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelEngineBase.getCreateDate() == null;
            }
            case 1: {
                return pSPanelEngineBase.getCreateMan() == null;
            }
            case 2: {
                return pSPanelEngineBase.getEngineOption() == null;
            }
            case 3: {
                return pSPanelEngineBase.getEngineParam() == null;
            }
            case 4: {
                return pSPanelEngineBase.getEngineParam10() == null;
            }
            case 5: {
                return pSPanelEngineBase.getEngineParam10Flag() == null;
            }
            case 6: {
                return pSPanelEngineBase.getEngineParam10Label() == null;
            }
            case 7: {
                return pSPanelEngineBase.getEngineParam2() == null;
            }
            case 8: {
                return pSPanelEngineBase.getEngineParam2Flag() == null;
            }
            case 9: {
                return pSPanelEngineBase.getEngineParam2Label() == null;
            }
            case 10: {
                return pSPanelEngineBase.getEngineParam3() == null;
            }
            case 11: {
                return pSPanelEngineBase.getEngineParam3Flag() == null;
            }
            case 12: {
                return pSPanelEngineBase.getEngineParam3Label() == null;
            }
            case 13: {
                return pSPanelEngineBase.getEngineParam4() == null;
            }
            case 14: {
                return pSPanelEngineBase.getEngineParam4Flag() == null;
            }
            case 15: {
                return pSPanelEngineBase.getEngineParam4Label() == null;
            }
            case 16: {
                return pSPanelEngineBase.getEngineParam5() == null;
            }
            case 17: {
                return pSPanelEngineBase.getEngineParam5Flag() == null;
            }
            case 18: {
                return pSPanelEngineBase.getEngineParam5Label() == null;
            }
            case 19: {
                return pSPanelEngineBase.getEngineParam6() == null;
            }
            case 20: {
                return pSPanelEngineBase.getEngineParam6Flag() == null;
            }
            case 21: {
                return pSPanelEngineBase.getEngineParam6Label() == null;
            }
            case 22: {
                return pSPanelEngineBase.getEngineParam7() == null;
            }
            case 23: {
                return pSPanelEngineBase.getEngineParam7Flag() == null;
            }
            case 24: {
                return pSPanelEngineBase.getEngineParam7Label() == null;
            }
            case 25: {
                return pSPanelEngineBase.getEngineParam8() == null;
            }
            case 26: {
                return pSPanelEngineBase.getEngineParam8Flag() == null;
            }
            case 27: {
                return pSPanelEngineBase.getEngineParam8Label() == null;
            }
            case 28: {
                return pSPanelEngineBase.getEngineParam9() == null;
            }
            case 29: {
                return pSPanelEngineBase.getEngineParam9Flag() == null;
            }
            case 30: {
                return pSPanelEngineBase.getEngineParam9Label() == null;
            }
            case 31: {
                return pSPanelEngineBase.getEngineParamFlag() == null;
            }
            case 32: {
                return pSPanelEngineBase.getEngineParamLabel() == null;
            }
            case 33: {
                return pSPanelEngineBase.getMemo() == null;
            }
            case 34: {
                return pSPanelEngineBase.getNo2PanelItemFlag() == null;
            }
            case 35: {
                return pSPanelEngineBase.getNo2PanelItemLabel() == null;
            }
            case 36: {
                return pSPanelEngineBase.getNo2PanelLogicFlag() == null;
            }
            case 37: {
                return pSPanelEngineBase.getNo2PanelLogicLabel() == null;
            }
            case 38: {
                return pSPanelEngineBase.getNo2PSPanelItemId() == null;
            }
            case 39: {
                return pSPanelEngineBase.getNo2PSPanelItemName() == null;
            }
            case 40: {
                return pSPanelEngineBase.getNo2PSPanelLogicId() == null;
            }
            case 41: {
                return pSPanelEngineBase.getNo2PSPanelLogicName() == null;
            }
            case 42: {
                return pSPanelEngineBase.getNo3PanelItemFlag() == null;
            }
            case 43: {
                return pSPanelEngineBase.getNo3PanelItemLabel() == null;
            }
            case 44: {
                return pSPanelEngineBase.getNo3PanelLogicFlag() == null;
            }
            case 45: {
                return pSPanelEngineBase.getNo3PanelLogicLabel() == null;
            }
            case 46: {
                return pSPanelEngineBase.getNo3PSPanelItemId() == null;
            }
            case 47: {
                return pSPanelEngineBase.getNo3PSPanelItemName() == null;
            }
            case 48: {
                return pSPanelEngineBase.getNo3PSPanelLogicId() == null;
            }
            case 49: {
                return pSPanelEngineBase.getNo3PSPanelLogicName() == null;
            }
            case 50: {
                return pSPanelEngineBase.getNo4PanelItemFlag() == null;
            }
            case 51: {
                return pSPanelEngineBase.getNo4PanelItemLabel() == null;
            }
            case 52: {
                return pSPanelEngineBase.getNo4PanelLogicFlag() == null;
            }
            case 53: {
                return pSPanelEngineBase.getNo4PanelLogicLabel() == null;
            }
            case 54: {
                return pSPanelEngineBase.getNo4PSPanelItemId() == null;
            }
            case 55: {
                return pSPanelEngineBase.getNo4PSPanelItemName() == null;
            }
            case 56: {
                return pSPanelEngineBase.getNo4PSPanelLogicId() == null;
            }
            case 57: {
                return pSPanelEngineBase.getNo4PSPanelLogicName() == null;
            }
            case 58: {
                return pSPanelEngineBase.getOrderValue() == null;
            }
            case 59: {
                return pSPanelEngineBase.getPanelItemFlag() == null;
            }
            case 60: {
                return pSPanelEngineBase.getPanelItemLabel() == null;
            }
            case 61: {
                return pSPanelEngineBase.getPanelLogicFlag() == null;
            }
            case 62: {
                return pSPanelEngineBase.getPanelLogicLabel() == null;
            }
            case 63: {
                return pSPanelEngineBase.getPSPanelEngineId() == null;
            }
            case 64: {
                return pSPanelEngineBase.getPSPanelEngineName() == null;
            }
            case 65: {
                return pSPanelEngineBase.getPSPanelItemId() == null;
            }
            case 66: {
                return pSPanelEngineBase.getPSPanelItemName() == null;
            }
            case 67: {
                return pSPanelEngineBase.getPSPanelLogicId() == null;
            }
            case 68: {
                return pSPanelEngineBase.getPSPanelLogicName() == null;
            }
            case 69: {
                return pSPanelEngineBase.getPSSysPFPluginId() == null;
            }
            case 70: {
                return pSPanelEngineBase.getPSSysPFPluginName() == null;
            }
            case 71: {
                return pSPanelEngineBase.getPSSysViewPanelId() == null;
            }
            case 72: {
                return pSPanelEngineBase.getPSSysViewPanelName() == null;
            }
            case 73: {
                return pSPanelEngineBase.getPSUIEngineTypeId() == null;
            }
            case 74: {
                return pSPanelEngineBase.getPSUIEngineTypeName() == null;
            }
            case 75: {
                return pSPanelEngineBase.getUpdateDate() == null;
            }
            case 76: {
                return pSPanelEngineBase.getUpdateMan() == null;
            }
            case 77: {
                return pSPanelEngineBase.getUserCat() == null;
            }
            case 78: {
                return pSPanelEngineBase.getUserTag() == null;
            }
            case 79: {
                return pSPanelEngineBase.getUserTag2() == null;
            }
            case 80: {
                return pSPanelEngineBase.getUserTag3() == null;
            }
            case 81: {
                return pSPanelEngineBase.getUserTag4() == null;
            }
            case 82: {
                return pSPanelEngineBase.getValidFlag() == null;
            }
            case 83: {
                return pSPanelEngineBase.getViewParam() == null;
            }
            case 84: {
                return pSPanelEngineBase.getViewParam10() == null;
            }
            case 85: {
                return pSPanelEngineBase.getViewParam2() == null;
            }
            case 86: {
                return pSPanelEngineBase.getViewParam3() == null;
            }
            case 87: {
                return pSPanelEngineBase.getViewParam4() == null;
            }
            case 88: {
                return pSPanelEngineBase.getViewParam5() == null;
            }
            case 89: {
                return pSPanelEngineBase.getViewParam6() == null;
            }
            case 90: {
                return pSPanelEngineBase.getViewParam7() == null;
            }
            case 91: {
                return pSPanelEngineBase.getViewParam8() == null;
            }
            case 92: {
                return pSPanelEngineBase.getViewParam9() == null;
            }
            case 93: {
                return pSPanelEngineBase.getWFViewParam() == null;
            }
            case 94: {
                return pSPanelEngineBase.getWFViewParam2() == null;
            }
            case 95: {
                return pSPanelEngineBase.getWFViewParam3() == null;
            }
            case 96: {
                return pSPanelEngineBase.getWFViewParam4() == null;
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
        return PSPanelEngineBase.contains(this, n);
    }

    private static boolean contains(PSPanelEngineBase pSPanelEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelEngineBase.isCreateDateDirty();
            }
            case 1: {
                return pSPanelEngineBase.isCreateManDirty();
            }
            case 2: {
                return pSPanelEngineBase.isEngineOptionDirty();
            }
            case 3: {
                return pSPanelEngineBase.isEngineParamDirty();
            }
            case 4: {
                return pSPanelEngineBase.isEngineParam10Dirty();
            }
            case 5: {
                return pSPanelEngineBase.isEngineParam10FlagDirty();
            }
            case 6: {
                return pSPanelEngineBase.isEngineParam10LabelDirty();
            }
            case 7: {
                return pSPanelEngineBase.isEngineParam2Dirty();
            }
            case 8: {
                return pSPanelEngineBase.isEngineParam2FlagDirty();
            }
            case 9: {
                return pSPanelEngineBase.isEngineParam2LabelDirty();
            }
            case 10: {
                return pSPanelEngineBase.isEngineParam3Dirty();
            }
            case 11: {
                return pSPanelEngineBase.isEngineParam3FlagDirty();
            }
            case 12: {
                return pSPanelEngineBase.isEngineParam3LabelDirty();
            }
            case 13: {
                return pSPanelEngineBase.isEngineParam4Dirty();
            }
            case 14: {
                return pSPanelEngineBase.isEngineParam4FlagDirty();
            }
            case 15: {
                return pSPanelEngineBase.isEngineParam4LabelDirty();
            }
            case 16: {
                return pSPanelEngineBase.isEngineParam5Dirty();
            }
            case 17: {
                return pSPanelEngineBase.isEngineParam5FlagDirty();
            }
            case 18: {
                return pSPanelEngineBase.isEngineParam5LabelDirty();
            }
            case 19: {
                return pSPanelEngineBase.isEngineParam6Dirty();
            }
            case 20: {
                return pSPanelEngineBase.isEngineParam6FlagDirty();
            }
            case 21: {
                return pSPanelEngineBase.isEngineParam6LabelDirty();
            }
            case 22: {
                return pSPanelEngineBase.isEngineParam7Dirty();
            }
            case 23: {
                return pSPanelEngineBase.isEngineParam7FlagDirty();
            }
            case 24: {
                return pSPanelEngineBase.isEngineParam7LabelDirty();
            }
            case 25: {
                return pSPanelEngineBase.isEngineParam8Dirty();
            }
            case 26: {
                return pSPanelEngineBase.isEngineParam8FlagDirty();
            }
            case 27: {
                return pSPanelEngineBase.isEngineParam8LabelDirty();
            }
            case 28: {
                return pSPanelEngineBase.isEngineParam9Dirty();
            }
            case 29: {
                return pSPanelEngineBase.isEngineParam9FlagDirty();
            }
            case 30: {
                return pSPanelEngineBase.isEngineParam9LabelDirty();
            }
            case 31: {
                return pSPanelEngineBase.isEngineParamFlagDirty();
            }
            case 32: {
                return pSPanelEngineBase.isEngineParamLabelDirty();
            }
            case 33: {
                return pSPanelEngineBase.isMemoDirty();
            }
            case 34: {
                return pSPanelEngineBase.isNo2PanelItemFlagDirty();
            }
            case 35: {
                return pSPanelEngineBase.isNo2PanelItemLabelDirty();
            }
            case 36: {
                return pSPanelEngineBase.isNo2PanelLogicFlagDirty();
            }
            case 37: {
                return pSPanelEngineBase.isNo2PanelLogicLabelDirty();
            }
            case 38: {
                return pSPanelEngineBase.isNo2PSPanelItemIdDirty();
            }
            case 39: {
                return pSPanelEngineBase.isNo2PSPanelItemNameDirty();
            }
            case 40: {
                return pSPanelEngineBase.isNo2PSPanelLogicIdDirty();
            }
            case 41: {
                return pSPanelEngineBase.isNo2PSPanelLogicNameDirty();
            }
            case 42: {
                return pSPanelEngineBase.isNo3PanelItemFlagDirty();
            }
            case 43: {
                return pSPanelEngineBase.isNo3PanelItemLabelDirty();
            }
            case 44: {
                return pSPanelEngineBase.isNo3PanelLogicFlagDirty();
            }
            case 45: {
                return pSPanelEngineBase.isNo3PanelLogicLabelDirty();
            }
            case 46: {
                return pSPanelEngineBase.isNo3PSPanelItemIdDirty();
            }
            case 47: {
                return pSPanelEngineBase.isNo3PSPanelItemNameDirty();
            }
            case 48: {
                return pSPanelEngineBase.isNo3PSPanelLogicIdDirty();
            }
            case 49: {
                return pSPanelEngineBase.isNo3PSPanelLogicNameDirty();
            }
            case 50: {
                return pSPanelEngineBase.isNo4PanelItemFlagDirty();
            }
            case 51: {
                return pSPanelEngineBase.isNo4PanelItemLabelDirty();
            }
            case 52: {
                return pSPanelEngineBase.isNo4PanelLogicFlagDirty();
            }
            case 53: {
                return pSPanelEngineBase.isNo4PanelLogicLabelDirty();
            }
            case 54: {
                return pSPanelEngineBase.isNo4PSPanelItemIdDirty();
            }
            case 55: {
                return pSPanelEngineBase.isNo4PSPanelItemNameDirty();
            }
            case 56: {
                return pSPanelEngineBase.isNo4PSPanelLogicIdDirty();
            }
            case 57: {
                return pSPanelEngineBase.isNo4PSPanelLogicNameDirty();
            }
            case 58: {
                return pSPanelEngineBase.isOrderValueDirty();
            }
            case 59: {
                return pSPanelEngineBase.isPanelItemFlagDirty();
            }
            case 60: {
                return pSPanelEngineBase.isPanelItemLabelDirty();
            }
            case 61: {
                return pSPanelEngineBase.isPanelLogicFlagDirty();
            }
            case 62: {
                return pSPanelEngineBase.isPanelLogicLabelDirty();
            }
            case 63: {
                return pSPanelEngineBase.isPSPanelEngineIdDirty();
            }
            case 64: {
                return pSPanelEngineBase.isPSPanelEngineNameDirty();
            }
            case 65: {
                return pSPanelEngineBase.isPSPanelItemIdDirty();
            }
            case 66: {
                return pSPanelEngineBase.isPSPanelItemNameDirty();
            }
            case 67: {
                return pSPanelEngineBase.isPSPanelLogicIdDirty();
            }
            case 68: {
                return pSPanelEngineBase.isPSPanelLogicNameDirty();
            }
            case 69: {
                return pSPanelEngineBase.isPSSysPFPluginIdDirty();
            }
            case 70: {
                return pSPanelEngineBase.isPSSysPFPluginNameDirty();
            }
            case 71: {
                return pSPanelEngineBase.isPSSysViewPanelIdDirty();
            }
            case 72: {
                return pSPanelEngineBase.isPSSysViewPanelNameDirty();
            }
            case 73: {
                return pSPanelEngineBase.isPSUIEngineTypeIdDirty();
            }
            case 74: {
                return pSPanelEngineBase.isPSUIEngineTypeNameDirty();
            }
            case 75: {
                return pSPanelEngineBase.isUpdateDateDirty();
            }
            case 76: {
                return pSPanelEngineBase.isUpdateManDirty();
            }
            case 77: {
                return pSPanelEngineBase.isUserCatDirty();
            }
            case 78: {
                return pSPanelEngineBase.isUserTagDirty();
            }
            case 79: {
                return pSPanelEngineBase.isUserTag2Dirty();
            }
            case 80: {
                return pSPanelEngineBase.isUserTag3Dirty();
            }
            case 81: {
                return pSPanelEngineBase.isUserTag4Dirty();
            }
            case 82: {
                return pSPanelEngineBase.isValidFlagDirty();
            }
            case 83: {
                return pSPanelEngineBase.isViewParamDirty();
            }
            case 84: {
                return pSPanelEngineBase.isViewParam10Dirty();
            }
            case 85: {
                return pSPanelEngineBase.isViewParam2Dirty();
            }
            case 86: {
                return pSPanelEngineBase.isViewParam3Dirty();
            }
            case 87: {
                return pSPanelEngineBase.isViewParam4Dirty();
            }
            case 88: {
                return pSPanelEngineBase.isViewParam5Dirty();
            }
            case 89: {
                return pSPanelEngineBase.isViewParam6Dirty();
            }
            case 90: {
                return pSPanelEngineBase.isViewParam7Dirty();
            }
            case 91: {
                return pSPanelEngineBase.isViewParam8Dirty();
            }
            case 92: {
                return pSPanelEngineBase.isViewParam9Dirty();
            }
            case 93: {
                return pSPanelEngineBase.isWFViewParamDirty();
            }
            case 94: {
                return pSPanelEngineBase.isWFViewParam2Dirty();
            }
            case 95: {
                return pSPanelEngineBase.isWFViewParam3Dirty();
            }
            case 96: {
                return pSPanelEngineBase.isWFViewParam4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelEngineBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelEngineBase pSPanelEngineBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelEngineBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineoption", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineOption()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam10", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam10()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam10Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam10flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam10Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam10Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam10label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam10Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam2", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam2()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam2Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam2flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam2Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam2Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam2label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam2Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam3", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam3()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam3Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam3flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam3Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam3Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam3label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam3Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam4", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam4()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam4Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam4flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam4Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam4Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam4label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam4Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam5", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam5()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam5Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam5flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam5Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam5Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam5label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam5Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam6", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam6()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam6Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam6flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam6Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam6Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam6label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam6Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam7", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam7()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam7Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam7flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam7Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam7Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam7label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam7Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam8", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam8()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam8Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam8flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam8Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam8Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam8label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam8Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam9", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam9()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam9Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam9flag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam9Flag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParam9Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam9label", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParam9Label()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParamFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparamflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParamFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getEngineParamLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparamlabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getEngineParamLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo2PanelItemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2panelitemflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo2PanelItemFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo2PanelItemLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2panelitemlabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo2PanelItemLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo2PanelLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2panellogicflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo2PanelLogicFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo2PanelLogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2panellogiclabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo2PanelLogicLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo2PSPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2pspanelitemid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo2PSPanelItemId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo2PSPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2pspanelitemname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo2PSPanelItemName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo2PSPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2pspanellogicid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo2PSPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo2PSPanelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2pspanellogicname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo2PSPanelLogicName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo3PanelItemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3panelitemflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo3PanelItemFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo3PanelItemLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3panelitemlabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo3PanelItemLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo3PanelLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3panellogicflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo3PanelLogicFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo3PanelLogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3panellogiclabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo3PanelLogicLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo3PSPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3pspanelitemid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo3PSPanelItemId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo3PSPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3pspanelitemname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo3PSPanelItemName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo3PSPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3pspanellogicid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo3PSPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo3PSPanelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3pspanellogicname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo3PSPanelLogicName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo4PanelItemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4panelitemflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo4PanelItemFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo4PanelItemLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4panelitemlabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo4PanelItemLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo4PanelLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4panellogicflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo4PanelLogicFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo4PanelLogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4panellogiclabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo4PanelLogicLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo4PSPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4pspanelitemid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo4PSPanelItemId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo4PSPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4pspanelitemname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo4PSPanelItemName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo4PSPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4pspanellogicid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo4PSPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getNo4PSPanelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4pspanellogicname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getNo4PSPanelLogicName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPanelItemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelitemflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPanelItemFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPanelItemLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelitemlabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPanelItemLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPanelLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panellogicflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPanelLogicFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPanelLogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panellogiclabel", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPanelLogicLabel()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSPanelEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelengineid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSPanelEngineId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSPanelEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelenginename", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSPanelEngineName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelitemid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSPanelItemId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelitemname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSPanelItemName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSPanelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSPanelLogicName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSUIEngineTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypeid", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSUIEngineTypeId()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getPSUIEngineTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypename", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getPSUIEngineTypeName()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getUserCat()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getUserTag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam10", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam10()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam2", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam2()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam3", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam3()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam4", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam4()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam5", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam5()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam6", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam6()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam7", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam7()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam8", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam8()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getViewParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam9", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getViewParam9()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getWFViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getWFViewParam()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getWFViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam2", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getWFViewParam2()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getWFViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam3", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getWFViewParam3()), (boolean)false);
        }
        if (bl || pSPanelEngineBase.getWFViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam4", (Object)PSPanelEngineBase.getJSONValue((Object)pSPanelEngineBase.getWFViewParam4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelEngineBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelEngineBase pSPanelEngineBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelEngineBase.getCreateDate() != null) {
            object = pSPanelEngineBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelEngineBase.getCreateMan() != null) {
            object = pSPanelEngineBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineOption() != null) {
            object = pSPanelEngineBase.getEngineOption();
            xmlNode.setAttribute(FIELD_ENGINEOPTION, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam() != null) {
            object = pSPanelEngineBase.getEngineParam();
            xmlNode.setAttribute(FIELD_ENGINEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam10() != null) {
            object = pSPanelEngineBase.getEngineParam10();
            xmlNode.setAttribute(FIELD_ENGINEPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam10Flag() != null) {
            object = pSPanelEngineBase.getEngineParam10Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM10FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam10Label() != null) {
            object = pSPanelEngineBase.getEngineParam10Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM10LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam2() != null) {
            object = pSPanelEngineBase.getEngineParam2();
            xmlNode.setAttribute(FIELD_ENGINEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam2Flag() != null) {
            object = pSPanelEngineBase.getEngineParam2Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM2FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam2Label() != null) {
            object = pSPanelEngineBase.getEngineParam2Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM2LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam3() != null) {
            object = pSPanelEngineBase.getEngineParam3();
            xmlNode.setAttribute(FIELD_ENGINEPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam3Flag() != null) {
            object = pSPanelEngineBase.getEngineParam3Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM3FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam3Label() != null) {
            object = pSPanelEngineBase.getEngineParam3Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM3LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam4() != null) {
            object = pSPanelEngineBase.getEngineParam4();
            xmlNode.setAttribute(FIELD_ENGINEPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam4Flag() != null) {
            object = pSPanelEngineBase.getEngineParam4Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM4FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam4Label() != null) {
            object = pSPanelEngineBase.getEngineParam4Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM4LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam5() != null) {
            object = pSPanelEngineBase.getEngineParam5();
            xmlNode.setAttribute(FIELD_ENGINEPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam5Flag() != null) {
            object = pSPanelEngineBase.getEngineParam5Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM5FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam5Label() != null) {
            object = pSPanelEngineBase.getEngineParam5Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM5LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam6() != null) {
            object = pSPanelEngineBase.getEngineParam6();
            xmlNode.setAttribute(FIELD_ENGINEPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam6Flag() != null) {
            object = pSPanelEngineBase.getEngineParam6Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM6FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam6Label() != null) {
            object = pSPanelEngineBase.getEngineParam6Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM6LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam7() != null) {
            object = pSPanelEngineBase.getEngineParam7();
            xmlNode.setAttribute(FIELD_ENGINEPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam7Flag() != null) {
            object = pSPanelEngineBase.getEngineParam7Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM7FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam7Label() != null) {
            object = pSPanelEngineBase.getEngineParam7Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM7LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam8() != null) {
            object = pSPanelEngineBase.getEngineParam8();
            xmlNode.setAttribute(FIELD_ENGINEPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam8Flag() != null) {
            object = pSPanelEngineBase.getEngineParam8Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM8FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam8Label() != null) {
            object = pSPanelEngineBase.getEngineParam8Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM8LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParam9() != null) {
            object = pSPanelEngineBase.getEngineParam9();
            xmlNode.setAttribute(FIELD_ENGINEPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam9Flag() != null) {
            object = pSPanelEngineBase.getEngineParam9Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM9FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParam9Label() != null) {
            object = pSPanelEngineBase.getEngineParam9Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM9LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getEngineParamFlag() != null) {
            object = pSPanelEngineBase.getEngineParamFlag();
            xmlNode.setAttribute(FIELD_ENGINEPARAMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getEngineParamLabel() != null) {
            object = pSPanelEngineBase.getEngineParamLabel();
            xmlNode.setAttribute(FIELD_ENGINEPARAMLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getMemo() != null) {
            object = pSPanelEngineBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo2PanelItemFlag() != null) {
            object = pSPanelEngineBase.getNo2PanelItemFlag();
            xmlNode.setAttribute(FIELD_NO2PANELITEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getNo2PanelItemLabel() != null) {
            object = pSPanelEngineBase.getNo2PanelItemLabel();
            xmlNode.setAttribute(FIELD_NO2PANELITEMLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo2PanelLogicFlag() != null) {
            object = pSPanelEngineBase.getNo2PanelLogicFlag();
            xmlNode.setAttribute(FIELD_NO2PANELLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getNo2PanelLogicLabel() != null) {
            object = pSPanelEngineBase.getNo2PanelLogicLabel();
            xmlNode.setAttribute(FIELD_NO2PANELLOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo2PSPanelItemId() != null) {
            object = pSPanelEngineBase.getNo2PSPanelItemId();
            xmlNode.setAttribute(FIELD_NO2PSPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo2PSPanelItemName() != null) {
            object = pSPanelEngineBase.getNo2PSPanelItemName();
            xmlNode.setAttribute(FIELD_NO2PSPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo2PSPanelLogicId() != null) {
            object = pSPanelEngineBase.getNo2PSPanelLogicId();
            xmlNode.setAttribute(FIELD_NO2PSPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo2PSPanelLogicName() != null) {
            object = pSPanelEngineBase.getNo2PSPanelLogicName();
            xmlNode.setAttribute(FIELD_NO2PSPANELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo3PanelItemFlag() != null) {
            object = pSPanelEngineBase.getNo3PanelItemFlag();
            xmlNode.setAttribute(FIELD_NO3PANELITEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getNo3PanelItemLabel() != null) {
            object = pSPanelEngineBase.getNo3PanelItemLabel();
            xmlNode.setAttribute(FIELD_NO3PANELITEMLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo3PanelLogicFlag() != null) {
            object = pSPanelEngineBase.getNo3PanelLogicFlag();
            xmlNode.setAttribute(FIELD_NO3PANELLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getNo3PanelLogicLabel() != null) {
            object = pSPanelEngineBase.getNo3PanelLogicLabel();
            xmlNode.setAttribute(FIELD_NO3PANELLOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo3PSPanelItemId() != null) {
            object = pSPanelEngineBase.getNo3PSPanelItemId();
            xmlNode.setAttribute(FIELD_NO3PSPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo3PSPanelItemName() != null) {
            object = pSPanelEngineBase.getNo3PSPanelItemName();
            xmlNode.setAttribute(FIELD_NO3PSPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo3PSPanelLogicId() != null) {
            object = pSPanelEngineBase.getNo3PSPanelLogicId();
            xmlNode.setAttribute(FIELD_NO3PSPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo3PSPanelLogicName() != null) {
            object = pSPanelEngineBase.getNo3PSPanelLogicName();
            xmlNode.setAttribute(FIELD_NO3PSPANELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo4PanelItemFlag() != null) {
            object = pSPanelEngineBase.getNo4PanelItemFlag();
            xmlNode.setAttribute(FIELD_NO4PANELITEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getNo4PanelItemLabel() != null) {
            object = pSPanelEngineBase.getNo4PanelItemLabel();
            xmlNode.setAttribute(FIELD_NO4PANELITEMLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo4PanelLogicFlag() != null) {
            object = pSPanelEngineBase.getNo4PanelLogicFlag();
            xmlNode.setAttribute(FIELD_NO4PANELLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getNo4PanelLogicLabel() != null) {
            object = pSPanelEngineBase.getNo4PanelLogicLabel();
            xmlNode.setAttribute(FIELD_NO4PANELLOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo4PSPanelItemId() != null) {
            object = pSPanelEngineBase.getNo4PSPanelItemId();
            xmlNode.setAttribute(FIELD_NO4PSPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo4PSPanelItemName() != null) {
            object = pSPanelEngineBase.getNo4PSPanelItemName();
            xmlNode.setAttribute(FIELD_NO4PSPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo4PSPanelLogicId() != null) {
            object = pSPanelEngineBase.getNo4PSPanelLogicId();
            xmlNode.setAttribute(FIELD_NO4PSPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getNo4PSPanelLogicName() != null) {
            object = pSPanelEngineBase.getNo4PSPanelLogicName();
            xmlNode.setAttribute(FIELD_NO4PSPANELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getOrderValue() != null) {
            object = pSPanelEngineBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getPanelItemFlag() != null) {
            object = pSPanelEngineBase.getPanelItemFlag();
            xmlNode.setAttribute(FIELD_PANELITEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getPanelItemLabel() != null) {
            object = pSPanelEngineBase.getPanelItemLabel();
            xmlNode.setAttribute(FIELD_PANELITEMLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPanelLogicFlag() != null) {
            object = pSPanelEngineBase.getPanelLogicFlag();
            xmlNode.setAttribute(FIELD_PANELLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getPanelLogicLabel() != null) {
            object = pSPanelEngineBase.getPanelLogicLabel();
            xmlNode.setAttribute(FIELD_PANELLOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSPanelEngineId() != null) {
            object = pSPanelEngineBase.getPSPanelEngineId();
            xmlNode.setAttribute(FIELD_PSPANELENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSPanelEngineName() != null) {
            object = pSPanelEngineBase.getPSPanelEngineName();
            xmlNode.setAttribute(FIELD_PSPANELENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSPanelItemId() != null) {
            object = pSPanelEngineBase.getPSPanelItemId();
            xmlNode.setAttribute(FIELD_PSPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSPanelItemName() != null) {
            object = pSPanelEngineBase.getPSPanelItemName();
            xmlNode.setAttribute(FIELD_PSPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSPanelLogicId() != null) {
            object = pSPanelEngineBase.getPSPanelLogicId();
            xmlNode.setAttribute(FIELD_PSPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSPanelLogicName() != null) {
            object = pSPanelEngineBase.getPSPanelLogicName();
            xmlNode.setAttribute(FIELD_PSPANELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSSysPFPluginId() != null) {
            object = pSPanelEngineBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSSysPFPluginName() != null) {
            object = pSPanelEngineBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSSysViewPanelId() != null) {
            object = pSPanelEngineBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSSysViewPanelName() != null) {
            object = pSPanelEngineBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSUIEngineTypeId() != null) {
            object = pSPanelEngineBase.getPSUIEngineTypeId();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getPSUIEngineTypeName() != null) {
            object = pSPanelEngineBase.getPSUIEngineTypeName();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getUpdateDate() != null) {
            object = pSPanelEngineBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelEngineBase.getUpdateMan() != null) {
            object = pSPanelEngineBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getUserCat() != null) {
            object = pSPanelEngineBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getUserTag() != null) {
            object = pSPanelEngineBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getUserTag2() != null) {
            object = pSPanelEngineBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getUserTag3() != null) {
            object = pSPanelEngineBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getUserTag4() != null) {
            object = pSPanelEngineBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getValidFlag() != null) {
            object = pSPanelEngineBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getViewParam() != null) {
            object = pSPanelEngineBase.getViewParam();
            xmlNode.setAttribute(FIELD_VIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getViewParam10() != null) {
            object = pSPanelEngineBase.getViewParam10();
            xmlNode.setAttribute(FIELD_VIEWPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getViewParam2() != null) {
            object = pSPanelEngineBase.getViewParam2();
            xmlNode.setAttribute(FIELD_VIEWPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getViewParam3() != null) {
            object = pSPanelEngineBase.getViewParam3();
            xmlNode.setAttribute(FIELD_VIEWPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getViewParam4() != null) {
            object = pSPanelEngineBase.getViewParam4();
            xmlNode.setAttribute(FIELD_VIEWPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getViewParam5() != null) {
            object = pSPanelEngineBase.getViewParam5();
            xmlNode.setAttribute(FIELD_VIEWPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getViewParam6() != null) {
            object = pSPanelEngineBase.getViewParam6();
            xmlNode.setAttribute(FIELD_VIEWPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getViewParam7() != null) {
            object = pSPanelEngineBase.getViewParam7();
            xmlNode.setAttribute(FIELD_VIEWPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getViewParam8() != null) {
            object = pSPanelEngineBase.getViewParam8();
            xmlNode.setAttribute(FIELD_VIEWPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getViewParam9() != null) {
            object = pSPanelEngineBase.getViewParam9();
            xmlNode.setAttribute(FIELD_VIEWPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getWFViewParam() != null) {
            object = pSPanelEngineBase.getWFViewParam();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getWFViewParam2() != null) {
            object = pSPanelEngineBase.getWFViewParam2();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelEngineBase.getWFViewParam3() != null) {
            object = pSPanelEngineBase.getWFViewParam3();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSPanelEngineBase.getWFViewParam4() != null) {
            object = pSPanelEngineBase.getWFViewParam4();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelEngineBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelEngineBase pSPanelEngineBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelEngineBase.isCreateDateDirty() && (bl || pSPanelEngineBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelEngineBase.getCreateDate());
        }
        if (pSPanelEngineBase.isCreateManDirty() && (bl || pSPanelEngineBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelEngineBase.getCreateMan());
        }
        if (pSPanelEngineBase.isEngineOptionDirty() && (bl || pSPanelEngineBase.getEngineOption() != null)) {
            iDataObject.set(FIELD_ENGINEOPTION, (Object)pSPanelEngineBase.getEngineOption());
        }
        if (pSPanelEngineBase.isEngineParamDirty() && (bl || pSPanelEngineBase.getEngineParam() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM, (Object)pSPanelEngineBase.getEngineParam());
        }
        if (pSPanelEngineBase.isEngineParam10Dirty() && (bl || pSPanelEngineBase.getEngineParam10() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM10, (Object)pSPanelEngineBase.getEngineParam10());
        }
        if (pSPanelEngineBase.isEngineParam10FlagDirty() && (bl || pSPanelEngineBase.getEngineParam10Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM10FLAG, (Object)pSPanelEngineBase.getEngineParam10Flag());
        }
        if (pSPanelEngineBase.isEngineParam10LabelDirty() && (bl || pSPanelEngineBase.getEngineParam10Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM10LABEL, (Object)pSPanelEngineBase.getEngineParam10Label());
        }
        if (pSPanelEngineBase.isEngineParam2Dirty() && (bl || pSPanelEngineBase.getEngineParam2() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM2, (Object)pSPanelEngineBase.getEngineParam2());
        }
        if (pSPanelEngineBase.isEngineParam2FlagDirty() && (bl || pSPanelEngineBase.getEngineParam2Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM2FLAG, (Object)pSPanelEngineBase.getEngineParam2Flag());
        }
        if (pSPanelEngineBase.isEngineParam2LabelDirty() && (bl || pSPanelEngineBase.getEngineParam2Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM2LABEL, (Object)pSPanelEngineBase.getEngineParam2Label());
        }
        if (pSPanelEngineBase.isEngineParam3Dirty() && (bl || pSPanelEngineBase.getEngineParam3() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM3, (Object)pSPanelEngineBase.getEngineParam3());
        }
        if (pSPanelEngineBase.isEngineParam3FlagDirty() && (bl || pSPanelEngineBase.getEngineParam3Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM3FLAG, (Object)pSPanelEngineBase.getEngineParam3Flag());
        }
        if (pSPanelEngineBase.isEngineParam3LabelDirty() && (bl || pSPanelEngineBase.getEngineParam3Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM3LABEL, (Object)pSPanelEngineBase.getEngineParam3Label());
        }
        if (pSPanelEngineBase.isEngineParam4Dirty() && (bl || pSPanelEngineBase.getEngineParam4() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM4, (Object)pSPanelEngineBase.getEngineParam4());
        }
        if (pSPanelEngineBase.isEngineParam4FlagDirty() && (bl || pSPanelEngineBase.getEngineParam4Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM4FLAG, (Object)pSPanelEngineBase.getEngineParam4Flag());
        }
        if (pSPanelEngineBase.isEngineParam4LabelDirty() && (bl || pSPanelEngineBase.getEngineParam4Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM4LABEL, (Object)pSPanelEngineBase.getEngineParam4Label());
        }
        if (pSPanelEngineBase.isEngineParam5Dirty() && (bl || pSPanelEngineBase.getEngineParam5() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM5, (Object)pSPanelEngineBase.getEngineParam5());
        }
        if (pSPanelEngineBase.isEngineParam5FlagDirty() && (bl || pSPanelEngineBase.getEngineParam5Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM5FLAG, (Object)pSPanelEngineBase.getEngineParam5Flag());
        }
        if (pSPanelEngineBase.isEngineParam5LabelDirty() && (bl || pSPanelEngineBase.getEngineParam5Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM5LABEL, (Object)pSPanelEngineBase.getEngineParam5Label());
        }
        if (pSPanelEngineBase.isEngineParam6Dirty() && (bl || pSPanelEngineBase.getEngineParam6() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM6, (Object)pSPanelEngineBase.getEngineParam6());
        }
        if (pSPanelEngineBase.isEngineParam6FlagDirty() && (bl || pSPanelEngineBase.getEngineParam6Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM6FLAG, (Object)pSPanelEngineBase.getEngineParam6Flag());
        }
        if (pSPanelEngineBase.isEngineParam6LabelDirty() && (bl || pSPanelEngineBase.getEngineParam6Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM6LABEL, (Object)pSPanelEngineBase.getEngineParam6Label());
        }
        if (pSPanelEngineBase.isEngineParam7Dirty() && (bl || pSPanelEngineBase.getEngineParam7() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM7, (Object)pSPanelEngineBase.getEngineParam7());
        }
        if (pSPanelEngineBase.isEngineParam7FlagDirty() && (bl || pSPanelEngineBase.getEngineParam7Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM7FLAG, (Object)pSPanelEngineBase.getEngineParam7Flag());
        }
        if (pSPanelEngineBase.isEngineParam7LabelDirty() && (bl || pSPanelEngineBase.getEngineParam7Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM7LABEL, (Object)pSPanelEngineBase.getEngineParam7Label());
        }
        if (pSPanelEngineBase.isEngineParam8Dirty() && (bl || pSPanelEngineBase.getEngineParam8() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM8, (Object)pSPanelEngineBase.getEngineParam8());
        }
        if (pSPanelEngineBase.isEngineParam8FlagDirty() && (bl || pSPanelEngineBase.getEngineParam8Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM8FLAG, (Object)pSPanelEngineBase.getEngineParam8Flag());
        }
        if (pSPanelEngineBase.isEngineParam8LabelDirty() && (bl || pSPanelEngineBase.getEngineParam8Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM8LABEL, (Object)pSPanelEngineBase.getEngineParam8Label());
        }
        if (pSPanelEngineBase.isEngineParam9Dirty() && (bl || pSPanelEngineBase.getEngineParam9() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM9, (Object)pSPanelEngineBase.getEngineParam9());
        }
        if (pSPanelEngineBase.isEngineParam9FlagDirty() && (bl || pSPanelEngineBase.getEngineParam9Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM9FLAG, (Object)pSPanelEngineBase.getEngineParam9Flag());
        }
        if (pSPanelEngineBase.isEngineParam9LabelDirty() && (bl || pSPanelEngineBase.getEngineParam9Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM9LABEL, (Object)pSPanelEngineBase.getEngineParam9Label());
        }
        if (pSPanelEngineBase.isEngineParamFlagDirty() && (bl || pSPanelEngineBase.getEngineParamFlag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAMFLAG, (Object)pSPanelEngineBase.getEngineParamFlag());
        }
        if (pSPanelEngineBase.isEngineParamLabelDirty() && (bl || pSPanelEngineBase.getEngineParamLabel() != null)) {
            iDataObject.set(FIELD_ENGINEPARAMLABEL, (Object)pSPanelEngineBase.getEngineParamLabel());
        }
        if (pSPanelEngineBase.isMemoDirty() && (bl || pSPanelEngineBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelEngineBase.getMemo());
        }
        if (pSPanelEngineBase.isNo2PanelItemFlagDirty() && (bl || pSPanelEngineBase.getNo2PanelItemFlag() != null)) {
            iDataObject.set(FIELD_NO2PANELITEMFLAG, (Object)pSPanelEngineBase.getNo2PanelItemFlag());
        }
        if (pSPanelEngineBase.isNo2PanelItemLabelDirty() && (bl || pSPanelEngineBase.getNo2PanelItemLabel() != null)) {
            iDataObject.set(FIELD_NO2PANELITEMLABEL, (Object)pSPanelEngineBase.getNo2PanelItemLabel());
        }
        if (pSPanelEngineBase.isNo2PanelLogicFlagDirty() && (bl || pSPanelEngineBase.getNo2PanelLogicFlag() != null)) {
            iDataObject.set(FIELD_NO2PANELLOGICFLAG, (Object)pSPanelEngineBase.getNo2PanelLogicFlag());
        }
        if (pSPanelEngineBase.isNo2PanelLogicLabelDirty() && (bl || pSPanelEngineBase.getNo2PanelLogicLabel() != null)) {
            iDataObject.set(FIELD_NO2PANELLOGICLABEL, (Object)pSPanelEngineBase.getNo2PanelLogicLabel());
        }
        if (pSPanelEngineBase.isNo2PSPanelItemIdDirty() && (bl || pSPanelEngineBase.getNo2PSPanelItemId() != null)) {
            iDataObject.set(FIELD_NO2PSPANELITEMID, (Object)pSPanelEngineBase.getNo2PSPanelItemId());
        }
        if (pSPanelEngineBase.isNo2PSPanelItemNameDirty() && (bl || pSPanelEngineBase.getNo2PSPanelItemName() != null)) {
            iDataObject.set(FIELD_NO2PSPANELITEMNAME, (Object)pSPanelEngineBase.getNo2PSPanelItemName());
        }
        if (pSPanelEngineBase.isNo2PSPanelLogicIdDirty() && (bl || pSPanelEngineBase.getNo2PSPanelLogicId() != null)) {
            iDataObject.set(FIELD_NO2PSPANELLOGICID, (Object)pSPanelEngineBase.getNo2PSPanelLogicId());
        }
        if (pSPanelEngineBase.isNo2PSPanelLogicNameDirty() && (bl || pSPanelEngineBase.getNo2PSPanelLogicName() != null)) {
            iDataObject.set(FIELD_NO2PSPANELLOGICNAME, (Object)pSPanelEngineBase.getNo2PSPanelLogicName());
        }
        if (pSPanelEngineBase.isNo3PanelItemFlagDirty() && (bl || pSPanelEngineBase.getNo3PanelItemFlag() != null)) {
            iDataObject.set(FIELD_NO3PANELITEMFLAG, (Object)pSPanelEngineBase.getNo3PanelItemFlag());
        }
        if (pSPanelEngineBase.isNo3PanelItemLabelDirty() && (bl || pSPanelEngineBase.getNo3PanelItemLabel() != null)) {
            iDataObject.set(FIELD_NO3PANELITEMLABEL, (Object)pSPanelEngineBase.getNo3PanelItemLabel());
        }
        if (pSPanelEngineBase.isNo3PanelLogicFlagDirty() && (bl || pSPanelEngineBase.getNo3PanelLogicFlag() != null)) {
            iDataObject.set(FIELD_NO3PANELLOGICFLAG, (Object)pSPanelEngineBase.getNo3PanelLogicFlag());
        }
        if (pSPanelEngineBase.isNo3PanelLogicLabelDirty() && (bl || pSPanelEngineBase.getNo3PanelLogicLabel() != null)) {
            iDataObject.set(FIELD_NO3PANELLOGICLABEL, (Object)pSPanelEngineBase.getNo3PanelLogicLabel());
        }
        if (pSPanelEngineBase.isNo3PSPanelItemIdDirty() && (bl || pSPanelEngineBase.getNo3PSPanelItemId() != null)) {
            iDataObject.set(FIELD_NO3PSPANELITEMID, (Object)pSPanelEngineBase.getNo3PSPanelItemId());
        }
        if (pSPanelEngineBase.isNo3PSPanelItemNameDirty() && (bl || pSPanelEngineBase.getNo3PSPanelItemName() != null)) {
            iDataObject.set(FIELD_NO3PSPANELITEMNAME, (Object)pSPanelEngineBase.getNo3PSPanelItemName());
        }
        if (pSPanelEngineBase.isNo3PSPanelLogicIdDirty() && (bl || pSPanelEngineBase.getNo3PSPanelLogicId() != null)) {
            iDataObject.set(FIELD_NO3PSPANELLOGICID, (Object)pSPanelEngineBase.getNo3PSPanelLogicId());
        }
        if (pSPanelEngineBase.isNo3PSPanelLogicNameDirty() && (bl || pSPanelEngineBase.getNo3PSPanelLogicName() != null)) {
            iDataObject.set(FIELD_NO3PSPANELLOGICNAME, (Object)pSPanelEngineBase.getNo3PSPanelLogicName());
        }
        if (pSPanelEngineBase.isNo4PanelItemFlagDirty() && (bl || pSPanelEngineBase.getNo4PanelItemFlag() != null)) {
            iDataObject.set(FIELD_NO4PANELITEMFLAG, (Object)pSPanelEngineBase.getNo4PanelItemFlag());
        }
        if (pSPanelEngineBase.isNo4PanelItemLabelDirty() && (bl || pSPanelEngineBase.getNo4PanelItemLabel() != null)) {
            iDataObject.set(FIELD_NO4PANELITEMLABEL, (Object)pSPanelEngineBase.getNo4PanelItemLabel());
        }
        if (pSPanelEngineBase.isNo4PanelLogicFlagDirty() && (bl || pSPanelEngineBase.getNo4PanelLogicFlag() != null)) {
            iDataObject.set(FIELD_NO4PANELLOGICFLAG, (Object)pSPanelEngineBase.getNo4PanelLogicFlag());
        }
        if (pSPanelEngineBase.isNo4PanelLogicLabelDirty() && (bl || pSPanelEngineBase.getNo4PanelLogicLabel() != null)) {
            iDataObject.set(FIELD_NO4PANELLOGICLABEL, (Object)pSPanelEngineBase.getNo4PanelLogicLabel());
        }
        if (pSPanelEngineBase.isNo4PSPanelItemIdDirty() && (bl || pSPanelEngineBase.getNo4PSPanelItemId() != null)) {
            iDataObject.set(FIELD_NO4PSPANELITEMID, (Object)pSPanelEngineBase.getNo4PSPanelItemId());
        }
        if (pSPanelEngineBase.isNo4PSPanelItemNameDirty() && (bl || pSPanelEngineBase.getNo4PSPanelItemName() != null)) {
            iDataObject.set(FIELD_NO4PSPANELITEMNAME, (Object)pSPanelEngineBase.getNo4PSPanelItemName());
        }
        if (pSPanelEngineBase.isNo4PSPanelLogicIdDirty() && (bl || pSPanelEngineBase.getNo4PSPanelLogicId() != null)) {
            iDataObject.set(FIELD_NO4PSPANELLOGICID, (Object)pSPanelEngineBase.getNo4PSPanelLogicId());
        }
        if (pSPanelEngineBase.isNo4PSPanelLogicNameDirty() && (bl || pSPanelEngineBase.getNo4PSPanelLogicName() != null)) {
            iDataObject.set(FIELD_NO4PSPANELLOGICNAME, (Object)pSPanelEngineBase.getNo4PSPanelLogicName());
        }
        if (pSPanelEngineBase.isOrderValueDirty() && (bl || pSPanelEngineBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPanelEngineBase.getOrderValue());
        }
        if (pSPanelEngineBase.isPanelItemFlagDirty() && (bl || pSPanelEngineBase.getPanelItemFlag() != null)) {
            iDataObject.set(FIELD_PANELITEMFLAG, (Object)pSPanelEngineBase.getPanelItemFlag());
        }
        if (pSPanelEngineBase.isPanelItemLabelDirty() && (bl || pSPanelEngineBase.getPanelItemLabel() != null)) {
            iDataObject.set(FIELD_PANELITEMLABEL, (Object)pSPanelEngineBase.getPanelItemLabel());
        }
        if (pSPanelEngineBase.isPanelLogicFlagDirty() && (bl || pSPanelEngineBase.getPanelLogicFlag() != null)) {
            iDataObject.set(FIELD_PANELLOGICFLAG, (Object)pSPanelEngineBase.getPanelLogicFlag());
        }
        if (pSPanelEngineBase.isPanelLogicLabelDirty() && (bl || pSPanelEngineBase.getPanelLogicLabel() != null)) {
            iDataObject.set(FIELD_PANELLOGICLABEL, (Object)pSPanelEngineBase.getPanelLogicLabel());
        }
        if (pSPanelEngineBase.isPSPanelEngineIdDirty() && (bl || pSPanelEngineBase.getPSPanelEngineId() != null)) {
            iDataObject.set(FIELD_PSPANELENGINEID, (Object)pSPanelEngineBase.getPSPanelEngineId());
        }
        if (pSPanelEngineBase.isPSPanelEngineNameDirty() && (bl || pSPanelEngineBase.getPSPanelEngineName() != null)) {
            iDataObject.set(FIELD_PSPANELENGINENAME, (Object)pSPanelEngineBase.getPSPanelEngineName());
        }
        if (pSPanelEngineBase.isPSPanelItemIdDirty() && (bl || pSPanelEngineBase.getPSPanelItemId() != null)) {
            iDataObject.set(FIELD_PSPANELITEMID, (Object)pSPanelEngineBase.getPSPanelItemId());
        }
        if (pSPanelEngineBase.isPSPanelItemNameDirty() && (bl || pSPanelEngineBase.getPSPanelItemName() != null)) {
            iDataObject.set(FIELD_PSPANELITEMNAME, (Object)pSPanelEngineBase.getPSPanelItemName());
        }
        if (pSPanelEngineBase.isPSPanelLogicIdDirty() && (bl || pSPanelEngineBase.getPSPanelLogicId() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICID, (Object)pSPanelEngineBase.getPSPanelLogicId());
        }
        if (pSPanelEngineBase.isPSPanelLogicNameDirty() && (bl || pSPanelEngineBase.getPSPanelLogicName() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICNAME, (Object)pSPanelEngineBase.getPSPanelLogicName());
        }
        if (pSPanelEngineBase.isPSSysPFPluginIdDirty() && (bl || pSPanelEngineBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSPanelEngineBase.getPSSysPFPluginId());
        }
        if (pSPanelEngineBase.isPSSysPFPluginNameDirty() && (bl || pSPanelEngineBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSPanelEngineBase.getPSSysPFPluginName());
        }
        if (pSPanelEngineBase.isPSSysViewPanelIdDirty() && (bl || pSPanelEngineBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSPanelEngineBase.getPSSysViewPanelId());
        }
        if (pSPanelEngineBase.isPSSysViewPanelNameDirty() && (bl || pSPanelEngineBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSPanelEngineBase.getPSSysViewPanelName());
        }
        if (pSPanelEngineBase.isPSUIEngineTypeIdDirty() && (bl || pSPanelEngineBase.getPSUIEngineTypeId() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPEID, (Object)pSPanelEngineBase.getPSUIEngineTypeId());
        }
        if (pSPanelEngineBase.isPSUIEngineTypeNameDirty() && (bl || pSPanelEngineBase.getPSUIEngineTypeName() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPENAME, (Object)pSPanelEngineBase.getPSUIEngineTypeName());
        }
        if (pSPanelEngineBase.isUpdateDateDirty() && (bl || pSPanelEngineBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelEngineBase.getUpdateDate());
        }
        if (pSPanelEngineBase.isUpdateManDirty() && (bl || pSPanelEngineBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelEngineBase.getUpdateMan());
        }
        if (pSPanelEngineBase.isUserCatDirty() && (bl || pSPanelEngineBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSPanelEngineBase.getUserCat());
        }
        if (pSPanelEngineBase.isUserTagDirty() && (bl || pSPanelEngineBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSPanelEngineBase.getUserTag());
        }
        if (pSPanelEngineBase.isUserTag2Dirty() && (bl || pSPanelEngineBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSPanelEngineBase.getUserTag2());
        }
        if (pSPanelEngineBase.isUserTag3Dirty() && (bl || pSPanelEngineBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSPanelEngineBase.getUserTag3());
        }
        if (pSPanelEngineBase.isUserTag4Dirty() && (bl || pSPanelEngineBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSPanelEngineBase.getUserTag4());
        }
        if (pSPanelEngineBase.isValidFlagDirty() && (bl || pSPanelEngineBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPanelEngineBase.getValidFlag());
        }
        if (pSPanelEngineBase.isViewParamDirty() && (bl || pSPanelEngineBase.getViewParam() != null)) {
            iDataObject.set(FIELD_VIEWPARAM, (Object)pSPanelEngineBase.getViewParam());
        }
        if (pSPanelEngineBase.isViewParam10Dirty() && (bl || pSPanelEngineBase.getViewParam10() != null)) {
            iDataObject.set(FIELD_VIEWPARAM10, (Object)pSPanelEngineBase.getViewParam10());
        }
        if (pSPanelEngineBase.isViewParam2Dirty() && (bl || pSPanelEngineBase.getViewParam2() != null)) {
            iDataObject.set(FIELD_VIEWPARAM2, (Object)pSPanelEngineBase.getViewParam2());
        }
        if (pSPanelEngineBase.isViewParam3Dirty() && (bl || pSPanelEngineBase.getViewParam3() != null)) {
            iDataObject.set(FIELD_VIEWPARAM3, (Object)pSPanelEngineBase.getViewParam3());
        }
        if (pSPanelEngineBase.isViewParam4Dirty() && (bl || pSPanelEngineBase.getViewParam4() != null)) {
            iDataObject.set(FIELD_VIEWPARAM4, (Object)pSPanelEngineBase.getViewParam4());
        }
        if (pSPanelEngineBase.isViewParam5Dirty() && (bl || pSPanelEngineBase.getViewParam5() != null)) {
            iDataObject.set(FIELD_VIEWPARAM5, (Object)pSPanelEngineBase.getViewParam5());
        }
        if (pSPanelEngineBase.isViewParam6Dirty() && (bl || pSPanelEngineBase.getViewParam6() != null)) {
            iDataObject.set(FIELD_VIEWPARAM6, (Object)pSPanelEngineBase.getViewParam6());
        }
        if (pSPanelEngineBase.isViewParam7Dirty() && (bl || pSPanelEngineBase.getViewParam7() != null)) {
            iDataObject.set(FIELD_VIEWPARAM7, (Object)pSPanelEngineBase.getViewParam7());
        }
        if (pSPanelEngineBase.isViewParam8Dirty() && (bl || pSPanelEngineBase.getViewParam8() != null)) {
            iDataObject.set(FIELD_VIEWPARAM8, (Object)pSPanelEngineBase.getViewParam8());
        }
        if (pSPanelEngineBase.isViewParam9Dirty() && (bl || pSPanelEngineBase.getViewParam9() != null)) {
            iDataObject.set(FIELD_VIEWPARAM9, (Object)pSPanelEngineBase.getViewParam9());
        }
        if (pSPanelEngineBase.isWFViewParamDirty() && (bl || pSPanelEngineBase.getWFViewParam() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM, (Object)pSPanelEngineBase.getWFViewParam());
        }
        if (pSPanelEngineBase.isWFViewParam2Dirty() && (bl || pSPanelEngineBase.getWFViewParam2() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM2, (Object)pSPanelEngineBase.getWFViewParam2());
        }
        if (pSPanelEngineBase.isWFViewParam3Dirty() && (bl || pSPanelEngineBase.getWFViewParam3() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM3, (Object)pSPanelEngineBase.getWFViewParam3());
        }
        if (pSPanelEngineBase.isWFViewParam4Dirty() && (bl || pSPanelEngineBase.getWFViewParam4() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM4, (Object)pSPanelEngineBase.getWFViewParam4());
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
        return PSPanelEngineBase.remove(this, n);
    }

    private static boolean remove(PSPanelEngineBase pSPanelEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelEngineBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPanelEngineBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPanelEngineBase.resetEngineOption();
                return true;
            }
            case 3: {
                pSPanelEngineBase.resetEngineParam();
                return true;
            }
            case 4: {
                pSPanelEngineBase.resetEngineParam10();
                return true;
            }
            case 5: {
                pSPanelEngineBase.resetEngineParam10Flag();
                return true;
            }
            case 6: {
                pSPanelEngineBase.resetEngineParam10Label();
                return true;
            }
            case 7: {
                pSPanelEngineBase.resetEngineParam2();
                return true;
            }
            case 8: {
                pSPanelEngineBase.resetEngineParam2Flag();
                return true;
            }
            case 9: {
                pSPanelEngineBase.resetEngineParam2Label();
                return true;
            }
            case 10: {
                pSPanelEngineBase.resetEngineParam3();
                return true;
            }
            case 11: {
                pSPanelEngineBase.resetEngineParam3Flag();
                return true;
            }
            case 12: {
                pSPanelEngineBase.resetEngineParam3Label();
                return true;
            }
            case 13: {
                pSPanelEngineBase.resetEngineParam4();
                return true;
            }
            case 14: {
                pSPanelEngineBase.resetEngineParam4Flag();
                return true;
            }
            case 15: {
                pSPanelEngineBase.resetEngineParam4Label();
                return true;
            }
            case 16: {
                pSPanelEngineBase.resetEngineParam5();
                return true;
            }
            case 17: {
                pSPanelEngineBase.resetEngineParam5Flag();
                return true;
            }
            case 18: {
                pSPanelEngineBase.resetEngineParam5Label();
                return true;
            }
            case 19: {
                pSPanelEngineBase.resetEngineParam6();
                return true;
            }
            case 20: {
                pSPanelEngineBase.resetEngineParam6Flag();
                return true;
            }
            case 21: {
                pSPanelEngineBase.resetEngineParam6Label();
                return true;
            }
            case 22: {
                pSPanelEngineBase.resetEngineParam7();
                return true;
            }
            case 23: {
                pSPanelEngineBase.resetEngineParam7Flag();
                return true;
            }
            case 24: {
                pSPanelEngineBase.resetEngineParam7Label();
                return true;
            }
            case 25: {
                pSPanelEngineBase.resetEngineParam8();
                return true;
            }
            case 26: {
                pSPanelEngineBase.resetEngineParam8Flag();
                return true;
            }
            case 27: {
                pSPanelEngineBase.resetEngineParam8Label();
                return true;
            }
            case 28: {
                pSPanelEngineBase.resetEngineParam9();
                return true;
            }
            case 29: {
                pSPanelEngineBase.resetEngineParam9Flag();
                return true;
            }
            case 30: {
                pSPanelEngineBase.resetEngineParam9Label();
                return true;
            }
            case 31: {
                pSPanelEngineBase.resetEngineParamFlag();
                return true;
            }
            case 32: {
                pSPanelEngineBase.resetEngineParamLabel();
                return true;
            }
            case 33: {
                pSPanelEngineBase.resetMemo();
                return true;
            }
            case 34: {
                pSPanelEngineBase.resetNo2PanelItemFlag();
                return true;
            }
            case 35: {
                pSPanelEngineBase.resetNo2PanelItemLabel();
                return true;
            }
            case 36: {
                pSPanelEngineBase.resetNo2PanelLogicFlag();
                return true;
            }
            case 37: {
                pSPanelEngineBase.resetNo2PanelLogicLabel();
                return true;
            }
            case 38: {
                pSPanelEngineBase.resetNo2PSPanelItemId();
                return true;
            }
            case 39: {
                pSPanelEngineBase.resetNo2PSPanelItemName();
                return true;
            }
            case 40: {
                pSPanelEngineBase.resetNo2PSPanelLogicId();
                return true;
            }
            case 41: {
                pSPanelEngineBase.resetNo2PSPanelLogicName();
                return true;
            }
            case 42: {
                pSPanelEngineBase.resetNo3PanelItemFlag();
                return true;
            }
            case 43: {
                pSPanelEngineBase.resetNo3PanelItemLabel();
                return true;
            }
            case 44: {
                pSPanelEngineBase.resetNo3PanelLogicFlag();
                return true;
            }
            case 45: {
                pSPanelEngineBase.resetNo3PanelLogicLabel();
                return true;
            }
            case 46: {
                pSPanelEngineBase.resetNo3PSPanelItemId();
                return true;
            }
            case 47: {
                pSPanelEngineBase.resetNo3PSPanelItemName();
                return true;
            }
            case 48: {
                pSPanelEngineBase.resetNo3PSPanelLogicId();
                return true;
            }
            case 49: {
                pSPanelEngineBase.resetNo3PSPanelLogicName();
                return true;
            }
            case 50: {
                pSPanelEngineBase.resetNo4PanelItemFlag();
                return true;
            }
            case 51: {
                pSPanelEngineBase.resetNo4PanelItemLabel();
                return true;
            }
            case 52: {
                pSPanelEngineBase.resetNo4PanelLogicFlag();
                return true;
            }
            case 53: {
                pSPanelEngineBase.resetNo4PanelLogicLabel();
                return true;
            }
            case 54: {
                pSPanelEngineBase.resetNo4PSPanelItemId();
                return true;
            }
            case 55: {
                pSPanelEngineBase.resetNo4PSPanelItemName();
                return true;
            }
            case 56: {
                pSPanelEngineBase.resetNo4PSPanelLogicId();
                return true;
            }
            case 57: {
                pSPanelEngineBase.resetNo4PSPanelLogicName();
                return true;
            }
            case 58: {
                pSPanelEngineBase.resetOrderValue();
                return true;
            }
            case 59: {
                pSPanelEngineBase.resetPanelItemFlag();
                return true;
            }
            case 60: {
                pSPanelEngineBase.resetPanelItemLabel();
                return true;
            }
            case 61: {
                pSPanelEngineBase.resetPanelLogicFlag();
                return true;
            }
            case 62: {
                pSPanelEngineBase.resetPanelLogicLabel();
                return true;
            }
            case 63: {
                pSPanelEngineBase.resetPSPanelEngineId();
                return true;
            }
            case 64: {
                pSPanelEngineBase.resetPSPanelEngineName();
                return true;
            }
            case 65: {
                pSPanelEngineBase.resetPSPanelItemId();
                return true;
            }
            case 66: {
                pSPanelEngineBase.resetPSPanelItemName();
                return true;
            }
            case 67: {
                pSPanelEngineBase.resetPSPanelLogicId();
                return true;
            }
            case 68: {
                pSPanelEngineBase.resetPSPanelLogicName();
                return true;
            }
            case 69: {
                pSPanelEngineBase.resetPSSysPFPluginId();
                return true;
            }
            case 70: {
                pSPanelEngineBase.resetPSSysPFPluginName();
                return true;
            }
            case 71: {
                pSPanelEngineBase.resetPSSysViewPanelId();
                return true;
            }
            case 72: {
                pSPanelEngineBase.resetPSSysViewPanelName();
                return true;
            }
            case 73: {
                pSPanelEngineBase.resetPSUIEngineTypeId();
                return true;
            }
            case 74: {
                pSPanelEngineBase.resetPSUIEngineTypeName();
                return true;
            }
            case 75: {
                pSPanelEngineBase.resetUpdateDate();
                return true;
            }
            case 76: {
                pSPanelEngineBase.resetUpdateMan();
                return true;
            }
            case 77: {
                pSPanelEngineBase.resetUserCat();
                return true;
            }
            case 78: {
                pSPanelEngineBase.resetUserTag();
                return true;
            }
            case 79: {
                pSPanelEngineBase.resetUserTag2();
                return true;
            }
            case 80: {
                pSPanelEngineBase.resetUserTag3();
                return true;
            }
            case 81: {
                pSPanelEngineBase.resetUserTag4();
                return true;
            }
            case 82: {
                pSPanelEngineBase.resetValidFlag();
                return true;
            }
            case 83: {
                pSPanelEngineBase.resetViewParam();
                return true;
            }
            case 84: {
                pSPanelEngineBase.resetViewParam10();
                return true;
            }
            case 85: {
                pSPanelEngineBase.resetViewParam2();
                return true;
            }
            case 86: {
                pSPanelEngineBase.resetViewParam3();
                return true;
            }
            case 87: {
                pSPanelEngineBase.resetViewParam4();
                return true;
            }
            case 88: {
                pSPanelEngineBase.resetViewParam5();
                return true;
            }
            case 89: {
                pSPanelEngineBase.resetViewParam6();
                return true;
            }
            case 90: {
                pSPanelEngineBase.resetViewParam7();
                return true;
            }
            case 91: {
                pSPanelEngineBase.resetViewParam8();
                return true;
            }
            case 92: {
                pSPanelEngineBase.resetViewParam9();
                return true;
            }
            case 93: {
                pSPanelEngineBase.resetWFViewParam();
                return true;
            }
            case 94: {
                pSPanelEngineBase.resetWFViewParam2();
                return true;
            }
            case 95: {
                pSPanelEngineBase.resetWFViewParam3();
                return true;
            }
            case 96: {
                pSPanelEngineBase.resetWFViewParam4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSysViewPanelItem getNo2PSPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSPanelItem();
        }
        if (this.getNo2PSPanelItemId() == null) {
            return null;
        }
        Integer n = this.objNo2PSPanelItemLock;
        synchronized (n) {
            if (this.no2pspanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSPanelItemId(), (Object)this.no2pspanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.no2pspanelitem = null;
            }
            if (this.no2pspanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getNo2PSPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet(pSSysViewPanelItem);
                this.no2pspanelitem = pSSysViewPanelItem;
            }
            return this.no2pspanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelItem getNo3PSPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSPanelItem();
        }
        if (this.getNo3PSPanelItemId() == null) {
            return null;
        }
        Integer n = this.objNo3PSPanelItemLock;
        synchronized (n) {
            if (this.no3pspanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getNo3PSPanelItemId(), (Object)this.no3pspanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.no3pspanelitem = null;
            }
            if (this.no3pspanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getNo3PSPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet(pSSysViewPanelItem);
                this.no3pspanelitem = pSSysViewPanelItem;
            }
            return this.no3pspanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelItem getNo4PSPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSPanelItem();
        }
        if (this.getNo4PSPanelItemId() == null) {
            return null;
        }
        Integer n = this.objNo4PSPanelItemLock;
        synchronized (n) {
            if (this.no4pspanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getNo4PSPanelItemId(), (Object)this.no4pspanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.no4pspanelitem = null;
            }
            if (this.no4pspanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getNo4PSPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet(pSSysViewPanelItem);
                this.no4pspanelitem = pSSysViewPanelItem;
            }
            return this.no4pspanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelItem getPSPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelItem();
        }
        if (this.getPSPanelItemId() == null) {
            return null;
        }
        Integer n = this.objPSPanelItemLock;
        synchronized (n) {
            if (this.pspanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSPanelItemId(), (Object)this.pspanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.pspanelitem = null;
            }
            if (this.pspanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getPSPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet(pSSysViewPanelItem);
                this.pspanelitem = pSSysViewPanelItem;
            }
            return this.pspanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelLogic getNo2PSPanelLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSPanelLogic();
        }
        if (this.getNo2PSPanelLogicId() == null) {
            return null;
        }
        Integer n = this.objNo2PSPanelLogicLock;
        synchronized (n) {
            if (this.no2pspanellogic != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSPanelLogicId(), (Object)this.no2pspanellogic.getPSSysViewPanelLogicId()) != 0L) {
                this.no2pspanellogic = null;
            }
            if (this.no2pspanellogic == null) {
                PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
                pSSysViewPanelLogic.setPSSysViewPanelLogicId(this.getNo2PSPanelLogicId());
                PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelLogicService.autoGet(pSSysViewPanelLogic);
                this.no2pspanellogic = pSSysViewPanelLogic;
            }
            return this.no2pspanellogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelLogic getNo3PSPanelLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3PSPanelLogic();
        }
        if (this.getNo3PSPanelLogicId() == null) {
            return null;
        }
        Integer n = this.objNo3PSPanelLogicLock;
        synchronized (n) {
            if (this.no3pspanellogic != null && DataTypeHelper.compare((int)25, (Object)this.getNo3PSPanelLogicId(), (Object)this.no3pspanellogic.getPSSysViewPanelLogicId()) != 0L) {
                this.no3pspanellogic = null;
            }
            if (this.no3pspanellogic == null) {
                PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
                pSSysViewPanelLogic.setPSSysViewPanelLogicId(this.getNo3PSPanelLogicId());
                PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelLogicService.autoGet(pSSysViewPanelLogic);
                this.no3pspanellogic = pSSysViewPanelLogic;
            }
            return this.no3pspanellogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelLogic getNo4PSPanelLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4PSPanelLogic();
        }
        if (this.getNo4PSPanelLogicId() == null) {
            return null;
        }
        Integer n = this.objNo4PSPanelLogicLock;
        synchronized (n) {
            if (this.no4pspanellogic != null && DataTypeHelper.compare((int)25, (Object)this.getNo4PSPanelLogicId(), (Object)this.no4pspanellogic.getPSSysViewPanelLogicId()) != 0L) {
                this.no4pspanellogic = null;
            }
            if (this.no4pspanellogic == null) {
                PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
                pSSysViewPanelLogic.setPSSysViewPanelLogicId(this.getNo4PSPanelLogicId());
                PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelLogicService.autoGet(pSSysViewPanelLogic);
                this.no4pspanellogic = pSSysViewPanelLogic;
            }
            return this.no4pspanellogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelLogic getPSPanelLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogic();
        }
        if (this.getPSPanelLogicId() == null) {
            return null;
        }
        Integer n = this.objPSPanelLogicLock;
        synchronized (n) {
            if (this.pspanellogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSPanelLogicId(), (Object)this.pspanellogic.getPSSysViewPanelLogicId()) != 0L) {
                this.pspanellogic = null;
            }
            if (this.pspanellogic == null) {
                PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
                pSSysViewPanelLogic.setPSSysViewPanelLogicId(this.getPSPanelLogicId());
                PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelLogicService.autoGet(pSSysViewPanelLogic);
                this.pspanellogic = pSSysViewPanelLogic;
            }
            return this.pspanellogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
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

    private PSPanelEngineBase getProxyEntity() {
        return this.proxyPSPanelEngineBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelEngineBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelEngineBase) {
            this.proxyPSPanelEngineBase = (PSPanelEngineBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENGINEOPTION, 2);
        fieldIndexMap.put(FIELD_ENGINEPARAM, 3);
        fieldIndexMap.put(FIELD_ENGINEPARAM10, 4);
        fieldIndexMap.put(FIELD_ENGINEPARAM10FLAG, 5);
        fieldIndexMap.put(FIELD_ENGINEPARAM10LABEL, 6);
        fieldIndexMap.put(FIELD_ENGINEPARAM2, 7);
        fieldIndexMap.put(FIELD_ENGINEPARAM2FLAG, 8);
        fieldIndexMap.put(FIELD_ENGINEPARAM2LABEL, 9);
        fieldIndexMap.put(FIELD_ENGINEPARAM3, 10);
        fieldIndexMap.put(FIELD_ENGINEPARAM3FLAG, 11);
        fieldIndexMap.put(FIELD_ENGINEPARAM3LABEL, 12);
        fieldIndexMap.put(FIELD_ENGINEPARAM4, 13);
        fieldIndexMap.put(FIELD_ENGINEPARAM4FLAG, 14);
        fieldIndexMap.put(FIELD_ENGINEPARAM4LABEL, 15);
        fieldIndexMap.put(FIELD_ENGINEPARAM5, 16);
        fieldIndexMap.put(FIELD_ENGINEPARAM5FLAG, 17);
        fieldIndexMap.put(FIELD_ENGINEPARAM5LABEL, 18);
        fieldIndexMap.put(FIELD_ENGINEPARAM6, 19);
        fieldIndexMap.put(FIELD_ENGINEPARAM6FLAG, 20);
        fieldIndexMap.put(FIELD_ENGINEPARAM6LABEL, 21);
        fieldIndexMap.put(FIELD_ENGINEPARAM7, 22);
        fieldIndexMap.put(FIELD_ENGINEPARAM7FLAG, 23);
        fieldIndexMap.put(FIELD_ENGINEPARAM7LABEL, 24);
        fieldIndexMap.put(FIELD_ENGINEPARAM8, 25);
        fieldIndexMap.put(FIELD_ENGINEPARAM8FLAG, 26);
        fieldIndexMap.put(FIELD_ENGINEPARAM8LABEL, 27);
        fieldIndexMap.put(FIELD_ENGINEPARAM9, 28);
        fieldIndexMap.put(FIELD_ENGINEPARAM9FLAG, 29);
        fieldIndexMap.put(FIELD_ENGINEPARAM9LABEL, 30);
        fieldIndexMap.put(FIELD_ENGINEPARAMFLAG, 31);
        fieldIndexMap.put(FIELD_ENGINEPARAMLABEL, 32);
        fieldIndexMap.put(FIELD_MEMO, 33);
        fieldIndexMap.put(FIELD_NO2PANELITEMFLAG, 34);
        fieldIndexMap.put(FIELD_NO2PANELITEMLABEL, 35);
        fieldIndexMap.put(FIELD_NO2PANELLOGICFLAG, 36);
        fieldIndexMap.put(FIELD_NO2PANELLOGICLABEL, 37);
        fieldIndexMap.put(FIELD_NO2PSPANELITEMID, 38);
        fieldIndexMap.put(FIELD_NO2PSPANELITEMNAME, 39);
        fieldIndexMap.put(FIELD_NO2PSPANELLOGICID, 40);
        fieldIndexMap.put(FIELD_NO2PSPANELLOGICNAME, 41);
        fieldIndexMap.put(FIELD_NO3PANELITEMFLAG, 42);
        fieldIndexMap.put(FIELD_NO3PANELITEMLABEL, 43);
        fieldIndexMap.put(FIELD_NO3PANELLOGICFLAG, 44);
        fieldIndexMap.put(FIELD_NO3PANELLOGICLABEL, 45);
        fieldIndexMap.put(FIELD_NO3PSPANELITEMID, 46);
        fieldIndexMap.put(FIELD_NO3PSPANELITEMNAME, 47);
        fieldIndexMap.put(FIELD_NO3PSPANELLOGICID, 48);
        fieldIndexMap.put(FIELD_NO3PSPANELLOGICNAME, 49);
        fieldIndexMap.put(FIELD_NO4PANELITEMFLAG, 50);
        fieldIndexMap.put(FIELD_NO4PANELITEMLABEL, 51);
        fieldIndexMap.put(FIELD_NO4PANELLOGICFLAG, 52);
        fieldIndexMap.put(FIELD_NO4PANELLOGICLABEL, 53);
        fieldIndexMap.put(FIELD_NO4PSPANELITEMID, 54);
        fieldIndexMap.put(FIELD_NO4PSPANELITEMNAME, 55);
        fieldIndexMap.put(FIELD_NO4PSPANELLOGICID, 56);
        fieldIndexMap.put(FIELD_NO4PSPANELLOGICNAME, 57);
        fieldIndexMap.put(FIELD_ORDERVALUE, 58);
        fieldIndexMap.put(FIELD_PANELITEMFLAG, 59);
        fieldIndexMap.put(FIELD_PANELITEMLABEL, 60);
        fieldIndexMap.put(FIELD_PANELLOGICFLAG, 61);
        fieldIndexMap.put(FIELD_PANELLOGICLABEL, 62);
        fieldIndexMap.put(FIELD_PSPANELENGINEID, 63);
        fieldIndexMap.put(FIELD_PSPANELENGINENAME, 64);
        fieldIndexMap.put(FIELD_PSPANELITEMID, 65);
        fieldIndexMap.put(FIELD_PSPANELITEMNAME, 66);
        fieldIndexMap.put(FIELD_PSPANELLOGICID, 67);
        fieldIndexMap.put(FIELD_PSPANELLOGICNAME, 68);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 69);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 70);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 71);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 72);
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

