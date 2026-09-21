/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWAppViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWAppViewBase.class);
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLESRCPSDEVIEW = "ENABLESRCPSDEVIEW";
    public static final String FIELD_LISTCTRLPARAM = "LISTCTRLPARAM";
    public static final String FIELD_LOADDEFAULT = "LOADDEFAULT";
    public static final String FIELD_MDCTRLPARAM = "MDCTRLPARAM";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEVIEWTYPE";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String FIELD_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSAPPVIEWTYPE = "PSAPPVIEWTYPE";
    public static final String FIELD_PSCTRLID = "PSCTRLID";
    public static final String FIELD_PSCTRLNAME = "PSCTRLNAME";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String FIELD_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String FIELD_PSDEDRID = "PSDEDRID";
    public static final String FIELD_PSDEDRNAME = "PSDEDRNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELISTID = "PSDELISTID";
    public static final String FIELD_PSDELISTNAME = "PSDELISTNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDESEARCHFORMID = "PSDESEARCHFORMID";
    public static final String FIELD_PSDESEARCHFORMNAME = "PSDESEARCHFORMNAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWBASETYPE = "PSDEVIEWBASETYPE";
    public static final String FIELD_PSDEVIEWID = "PSDEVIEWID";
    public static final String FIELD_PSDEVIEWNAME = "PSDEVIEWNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSFACHANDLERID = "PSSFACHANDLERID";
    public static final String FIELD_PSSFACHANDLERNAME = "PSSFACHANDLERNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSUWAPPVIEWID = "PSUWAPPVIEWID";
    public static final String FIELD_PSUWAPPVIEWNAME = "PSUWAPPVIEWNAME";
    public static final String FIELD_SRCPSDEVIEWID = "SRCPSDEVIEWID";
    public static final String FIELD_SRCPSDEVIEWNAME = "SRCPSDEVIEWNAME";
    public static final String FIELD_SRFNEXTFORM = "SRFNEXTFORM";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
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
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    public static final String FIELD_WIZARDPARAM = "WIZARDPARAM";
    public static final String FIELD_WIZARDPARAM10 = "WIZARDPARAM10";
    public static final String FIELD_WIZARDPARAM11 = "WIZARDPARAM11";
    public static final String FIELD_WIZARDPARAM12 = "WIZARDPARAM12";
    public static final String FIELD_WIZARDPARAM13 = "WIZARDPARAM13";
    public static final String FIELD_WIZARDPARAM14 = "WIZARDPARAM14";
    public static final String FIELD_WIZARDPARAM15 = "WIZARDPARAM15";
    public static final String FIELD_WIZARDPARAM16 = "WIZARDPARAM16";
    public static final String FIELD_WIZARDPARAM17 = "WIZARDPARAM17";
    public static final String FIELD_WIZARDPARAM18 = "WIZARDPARAM18";
    public static final String FIELD_WIZARDPARAM19 = "WIZARDPARAM19";
    public static final String FIELD_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String FIELD_WIZARDPARAM20 = "WIZARDPARAM20";
    public static final String FIELD_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String FIELD_WIZARDPARAM4 = "WIZARDPARAM4";
    public static final String FIELD_WIZARDPARAM5 = "WIZARDPARAM5";
    public static final String FIELD_WIZARDPARAM6 = "WIZARDPARAM6";
    public static final String FIELD_WIZARDPARAM7 = "WIZARDPARAM7";
    public static final String FIELD_WIZARDPARAM8 = "WIZARDPARAM8";
    public static final String FIELD_WIZARDPARAM9 = "WIZARDPARAM9";
    private static final int INDEX_CAPTION = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENABLESRCPSDEVIEW = 4;
    private static final int INDEX_LISTCTRLPARAM = 5;
    private static final int INDEX_LOADDEFAULT = 6;
    private static final int INDEX_MDCTRLPARAM = 7;
    private static final int INDEX_PREDEFINEDVIEWTYPE = 8;
    private static final int INDEX_PSACHANDLERID = 9;
    private static final int INDEX_PSACHANDLERNAME = 10;
    private static final int INDEX_PSAPPMODULEID = 11;
    private static final int INDEX_PSAPPMODULENAME = 12;
    private static final int INDEX_PSAPPVIEWID = 13;
    private static final int INDEX_PSAPPVIEWNAME = 14;
    private static final int INDEX_PSAPPVIEWTYPE = 15;
    private static final int INDEX_PSCTRLID = 16;
    private static final int INDEX_PSCTRLNAME = 17;
    private static final int INDEX_PSCTRLTYPEID = 18;
    private static final int INDEX_PSCTRLTYPENAME = 19;
    private static final int INDEX_PSDEDATASETID = 20;
    private static final int INDEX_PSDEDATASETNAME = 21;
    private static final int INDEX_PSDEDATAVIEWID = 22;
    private static final int INDEX_PSDEDATAVIEWNAME = 23;
    private static final int INDEX_PSDEDRID = 24;
    private static final int INDEX_PSDEDRNAME = 25;
    private static final int INDEX_PSDEFORMID = 26;
    private static final int INDEX_PSDEFORMNAME = 27;
    private static final int INDEX_PSDEGRIDID = 28;
    private static final int INDEX_PSDEGRIDNAME = 29;
    private static final int INDEX_PSDEID = 30;
    private static final int INDEX_PSDELISTID = 31;
    private static final int INDEX_PSDELISTNAME = 32;
    private static final int INDEX_PSDENAME = 33;
    private static final int INDEX_PSDESEARCHFORMID = 34;
    private static final int INDEX_PSDESEARCHFORMNAME = 35;
    private static final int INDEX_PSDETOOLBARID = 36;
    private static final int INDEX_PSDETOOLBARNAME = 37;
    private static final int INDEX_PSDEVIEWBASEID = 38;
    private static final int INDEX_PSDEVIEWBASENAME = 39;
    private static final int INDEX_PSDEVIEWBASETYPE = 40;
    private static final int INDEX_PSDEVIEWID = 41;
    private static final int INDEX_PSDEVIEWNAME = 42;
    private static final int INDEX_PSDYNAINSTID = 43;
    private static final int INDEX_PSSFACHANDLERID = 44;
    private static final int INDEX_PSSFACHANDLERNAME = 45;
    private static final int INDEX_PSSYSAPPID = 46;
    private static final int INDEX_PSUWAPPVIEWID = 47;
    private static final int INDEX_PSUWAPPVIEWNAME = 48;
    private static final int INDEX_SRCPSDEVIEWID = 49;
    private static final int INDEX_SRCPSDEVIEWNAME = 50;
    private static final int INDEX_SRFNEXTFORM = 51;
    private static final int INDEX_TITLE = 52;
    private static final int INDEX_UPDATEDATE = 53;
    private static final int INDEX_UPDATEMAN = 54;
    private static final int INDEX_VIEWPARAM = 55;
    private static final int INDEX_VIEWPARAM10 = 56;
    private static final int INDEX_VIEWPARAM2 = 57;
    private static final int INDEX_VIEWPARAM3 = 58;
    private static final int INDEX_VIEWPARAM4 = 59;
    private static final int INDEX_VIEWPARAM5 = 60;
    private static final int INDEX_VIEWPARAM6 = 61;
    private static final int INDEX_VIEWPARAM7 = 62;
    private static final int INDEX_VIEWPARAM8 = 63;
    private static final int INDEX_VIEWPARAM9 = 64;
    private static final int INDEX_WIZARDMODE = 65;
    private static final int INDEX_WIZARDPARAM = 66;
    private static final int INDEX_WIZARDPARAM10 = 67;
    private static final int INDEX_WIZARDPARAM11 = 68;
    private static final int INDEX_WIZARDPARAM12 = 69;
    private static final int INDEX_WIZARDPARAM13 = 70;
    private static final int INDEX_WIZARDPARAM14 = 71;
    private static final int INDEX_WIZARDPARAM15 = 72;
    private static final int INDEX_WIZARDPARAM16 = 73;
    private static final int INDEX_WIZARDPARAM17 = 74;
    private static final int INDEX_WIZARDPARAM18 = 75;
    private static final int INDEX_WIZARDPARAM19 = 76;
    private static final int INDEX_WIZARDPARAM2 = 77;
    private static final int INDEX_WIZARDPARAM20 = 78;
    private static final int INDEX_WIZARDPARAM3 = 79;
    private static final int INDEX_WIZARDPARAM4 = 80;
    private static final int INDEX_WIZARDPARAM5 = 81;
    private static final int INDEX_WIZARDPARAM6 = 82;
    private static final int INDEX_WIZARDPARAM7 = 83;
    private static final int INDEX_WIZARDPARAM8 = 84;
    private static final int INDEX_WIZARDPARAM9 = 85;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWAppViewBase proxyPSUWAppViewBase = null;
    private boolean captionDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablesrcpsdeviewDirtyFlag = false;
    private boolean listctrlparamDirtyFlag = false;
    private boolean loaddefaultDirtyFlag = false;
    private boolean mdctrlparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psappmoduleidDirtyFlag = false;
    private boolean psappmodulenameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psappviewtypeDirtyFlag = false;
    private boolean psctrlidDirtyFlag = false;
    private boolean psctrlnameDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdedataviewidDirtyFlag = false;
    private boolean psdedataviewnameDirtyFlag = false;
    private boolean psdedridDirtyFlag = false;
    private boolean psdedrnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelistidDirtyFlag = false;
    private boolean psdelistnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdesearchformidDirtyFlag = false;
    private boolean psdesearchformnameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewbasetypeDirtyFlag = false;
    private boolean psdeviewidDirtyFlag = false;
    private boolean psdeviewnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssfachandleridDirtyFlag = false;
    private boolean pssfachandlernameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean psuwappviewidDirtyFlag = false;
    private boolean psuwappviewnameDirtyFlag = false;
    private boolean srcpsdeviewidDirtyFlag = false;
    private boolean srcpsdeviewnameDirtyFlag = false;
    private boolean srfnextformDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
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
    private boolean wizardmodeDirtyFlag = false;
    private boolean wizardparamDirtyFlag = false;
    private boolean wizardparam10DirtyFlag = false;
    private boolean wizardparam11DirtyFlag = false;
    private boolean wizardparam12DirtyFlag = false;
    private boolean wizardparam13DirtyFlag = false;
    private boolean wizardparam14DirtyFlag = false;
    private boolean wizardparam15DirtyFlag = false;
    private boolean wizardparam16DirtyFlag = false;
    private boolean wizardparam17DirtyFlag = false;
    private boolean wizardparam18DirtyFlag = false;
    private boolean wizardparam19DirtyFlag = false;
    private boolean wizardparam2DirtyFlag = false;
    private boolean wizardparam20DirtyFlag = false;
    private boolean wizardparam3DirtyFlag = false;
    private boolean wizardparam4DirtyFlag = false;
    private boolean wizardparam5DirtyFlag = false;
    private boolean wizardparam6DirtyFlag = false;
    private boolean wizardparam7DirtyFlag = false;
    private boolean wizardparam8DirtyFlag = false;
    private boolean wizardparam9DirtyFlag = false;
    @Column(name="caption")
    private String caption;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablesrcpsdeview")
    private Integer enablesrcpsdeview;
    @Column(name="listctrlparam")
    private String listctrlparam;
    @Column(name="loaddefault")
    private Integer loaddefault;
    @Column(name="mdctrlparam")
    private String mdctrlparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psappmoduleid")
    private String psappmoduleid;
    @Column(name="psappmodulename")
    private String psappmodulename;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psappviewtype")
    private String psappviewtype;
    @Column(name="psctrlid")
    private String psctrlid;
    @Column(name="psctrlname")
    private String psctrlname;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdedataviewid")
    private String psdedataviewid;
    @Column(name="psdedataviewname")
    private String psdedataviewname;
    @Column(name="psdedrid")
    private String psdedrid;
    @Column(name="psdedrname")
    private String psdedrname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelistid")
    private String psdelistid;
    @Column(name="psdelistname")
    private String psdelistname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdesearchformid")
    private String psdesearchformid;
    @Column(name="psdesearchformname")
    private String psdesearchformname;
    @Column(name="psdetoolbarid")
    private String psdetoolbarid;
    @Column(name="psdetoolbarname")
    private String psdetoolbarname;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewbasetype")
    private String psdeviewbasetype;
    @Column(name="psdeviewid")
    private String psdeviewid;
    @Column(name="psdeviewname")
    private String psdeviewname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssfachandlerid")
    private String pssfachandlerid;
    @Column(name="pssfachandlername")
    private String pssfachandlername;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="psuwappviewid")
    private String psuwappviewid;
    @Column(name="psuwappviewname")
    private String psuwappviewname;
    @Column(name="srcpsdeviewid")
    private String srcpsdeviewid;
    @Column(name="srcpsdeviewname")
    private String srcpsdeviewname;
    @Column(name="srfnextform")
    private String srfnextform;
    @Column(name="title")
    private String title;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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
    @Column(name="wizardmode")
    private String wizardmode;
    @Column(name="wizardparam")
    private String wizardparam;
    @Column(name="wizardparam10")
    private String wizardparam10;
    @Column(name="wizardparam11")
    private Integer wizardparam11;
    @Column(name="wizardparam12")
    private Integer wizardparam12;
    @Column(name="wizardparam13")
    private Integer wizardparam13;
    @Column(name="wizardparam14")
    private Integer wizardparam14;
    @Column(name="wizardparam15")
    private Integer wizardparam15;
    @Column(name="wizardparam16")
    private Integer wizardparam16;
    @Column(name="wizardparam17")
    private Double wizardparam17;
    @Column(name="wizardparam18")
    private Double wizardparam18;
    @Column(name="wizardparam19")
    private Timestamp wizardparam19;
    @Column(name="wizardparam2")
    private String wizardparam2;
    @Column(name="wizardparam20")
    private Timestamp wizardparam20;
    @Column(name="wizardparam3")
    private Integer wizardparam3;
    @Column(name="wizardparam4")
    private Integer wizardparam4;
    @Column(name="wizardparam5")
    private String wizardparam5;
    @Column(name="wizardparam6")
    private String wizardparam6;
    @Column(name="wizardparam7")
    private String wizardparam7;
    @Column(name="wizardparam8")
    private String wizardparam8;
    @Column(name="wizardparam9")
    private String wizardparam9;

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setEnableSrcPSDEView(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSrcPSDEView(n);
            return;
        }
        this.enablesrcpsdeview = n;
        this.enablesrcpsdeviewDirtyFlag = true;
    }

    public Integer getEnableSrcPSDEView() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSrcPSDEView();
        }
        return this.enablesrcpsdeview;
    }

    public boolean isEnableSrcPSDEViewDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSrcPSDEViewDirty();
        }
        return this.enablesrcpsdeviewDirtyFlag;
    }

    public void resetEnableSrcPSDEView() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSrcPSDEView();
            return;
        }
        this.enablesrcpsdeviewDirtyFlag = false;
        this.enablesrcpsdeview = null;
    }

    public void setListCtrlParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setListCtrlParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.listctrlparam = string;
        this.listctrlparamDirtyFlag = true;
    }

    public String getListCtrlParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getListCtrlParam();
        }
        return this.listctrlparam;
    }

    public boolean isListCtrlParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isListCtrlParamDirty();
        }
        return this.listctrlparamDirtyFlag;
    }

    public void resetListCtrlParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetListCtrlParam();
            return;
        }
        this.listctrlparamDirtyFlag = false;
        this.listctrlparam = null;
    }

    public void setLoadDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoadDefault(n);
            return;
        }
        this.loaddefault = n;
        this.loaddefaultDirtyFlag = true;
    }

    public Integer getLoadDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoadDefault();
        }
        return this.loaddefault;
    }

    public boolean isLoadDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoadDefaultDirty();
        }
        return this.loaddefaultDirtyFlag;
    }

    public void resetLoadDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoadDefault();
            return;
        }
        this.loaddefaultDirtyFlag = false;
        this.loaddefault = null;
    }

    public void setMDCtrlParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDCtrlParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdctrlparam = string;
        this.mdctrlparamDirtyFlag = true;
    }

    public String getMDCtrlParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDCtrlParam();
        }
        return this.mdctrlparam;
    }

    public boolean isMDCtrlParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDCtrlParamDirty();
        }
        return this.mdctrlparamDirtyFlag;
    }

    public void resetMDCtrlParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDCtrlParam();
            return;
        }
        this.mdctrlparamDirtyFlag = false;
        this.mdctrlparam = null;
    }

    public void setPredefinedViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedviewtype = string;
        this.predefinedviewtypeDirtyFlag = true;
    }

    public String getPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedViewType();
        }
        return this.predefinedviewtype;
    }

    public boolean isPredefinedViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedViewTypeDirty();
        }
        return this.predefinedviewtypeDirtyFlag;
    }

    public void resetPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedViewType();
            return;
        }
        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
    }

    public void setPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlerid = string;
        this.psachandleridDirtyFlag = true;
    }

    public String getPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerId();
        }
        return this.psachandlerid;
    }

    public boolean isPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerIdDirty();
        }
        return this.psachandleridDirtyFlag;
    }

    public void resetPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerId();
            return;
        }
        this.psachandleridDirtyFlag = false;
        this.psachandlerid = null;
    }

    public void setPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlername = string;
        this.psachandlernameDirtyFlag = true;
    }

    public String getPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerName();
        }
        return this.psachandlername;
    }

    public boolean isPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerNameDirty();
        }
        return this.psachandlernameDirtyFlag;
    }

    public void resetPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerName();
            return;
        }
        this.psachandlernameDirtyFlag = false;
        this.psachandlername = null;
    }

    public void setPSAppModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmoduleid = string;
        this.psappmoduleidDirtyFlag = true;
    }

    public String getPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleId();
        }
        return this.psappmoduleid;
    }

    public boolean isPSAppModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleIdDirty();
        }
        return this.psappmoduleidDirtyFlag;
    }

    public void resetPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleId();
            return;
        }
        this.psappmoduleidDirtyFlag = false;
        this.psappmoduleid = null;
    }

    public void setPSAppModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmodulename = string;
        this.psappmodulenameDirtyFlag = true;
    }

    public String getPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleName();
        }
        return this.psappmodulename;
    }

    public boolean isPSAppModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleNameDirty();
        }
        return this.psappmodulenameDirtyFlag;
    }

    public void resetPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleName();
            return;
        }
        this.psappmodulenameDirtyFlag = false;
        this.psappmodulename = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
    }

    public void setPSAppViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewtype = string;
        this.psappviewtypeDirtyFlag = true;
    }

    public String getPSAppViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewType();
        }
        return this.psappviewtype;
    }

    public boolean isPSAppViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewTypeDirty();
        }
        return this.psappviewtypeDirtyFlag;
    }

    public void resetPSAppViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewType();
            return;
        }
        this.psappviewtypeDirtyFlag = false;
        this.psappviewtype = null;
    }

    public void setPSCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlid = string;
        this.psctrlidDirtyFlag = true;
    }

    public String getPSCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlId();
        }
        return this.psctrlid;
    }

    public boolean isPSCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlIdDirty();
        }
        return this.psctrlidDirtyFlag;
    }

    public void resetPSCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlId();
            return;
        }
        this.psctrlidDirtyFlag = false;
        this.psctrlid = null;
    }

    public void setPSCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlname = string;
        this.psctrlnameDirtyFlag = true;
    }

    public String getPSCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlName();
        }
        return this.psctrlname;
    }

    public boolean isPSCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlNameDirty();
        }
        return this.psctrlnameDirtyFlag;
    }

    public void resetPSCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlName();
            return;
        }
        this.psctrlnameDirtyFlag = false;
        this.psctrlname = null;
    }

    public void setPSCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeid = string;
        this.psctrltypeidDirtyFlag = true;
    }

    public String getPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeId();
        }
        return this.psctrltypeid;
    }

    public boolean isPSCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeIdDirty();
        }
        return this.psctrltypeidDirtyFlag;
    }

    public void resetPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeId();
            return;
        }
        this.psctrltypeidDirtyFlag = false;
        this.psctrltypeid = null;
    }

    public void setPSCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypename = string;
        this.psctrltypenameDirtyFlag = true;
    }

    public String getPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeName();
        }
        return this.psctrltypename;
    }

    public boolean isPSCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeNameDirty();
        }
        return this.psctrltypenameDirtyFlag;
    }

    public void resetPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeName();
            return;
        }
        this.psctrltypenameDirtyFlag = false;
        this.psctrltypename = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
    }

    public void setPSDEDataViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewid = string;
        this.psdedataviewidDirtyFlag = true;
    }

    public String getPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewId();
        }
        return this.psdedataviewid;
    }

    public boolean isPSDEDataViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewIdDirty();
        }
        return this.psdedataviewidDirtyFlag;
    }

    public void resetPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewId();
            return;
        }
        this.psdedataviewidDirtyFlag = false;
        this.psdedataviewid = null;
    }

    public void setPSDEDataViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewname = string;
        this.psdedataviewnameDirtyFlag = true;
    }

    public String getPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewName();
        }
        return this.psdedataviewname;
    }

    public boolean isPSDEDataViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewNameDirty();
        }
        return this.psdedataviewnameDirtyFlag;
    }

    public void resetPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewName();
            return;
        }
        this.psdedataviewnameDirtyFlag = false;
        this.psdedataviewname = null;
    }

    public void setPSDEDRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrid = string;
        this.psdedridDirtyFlag = true;
    }

    public String getPSDEDRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRId();
        }
        return this.psdedrid;
    }

    public boolean isPSDEDRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRIdDirty();
        }
        return this.psdedridDirtyFlag;
    }

    public void resetPSDEDRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRId();
            return;
        }
        this.psdedridDirtyFlag = false;
        this.psdedrid = null;
    }

    public void setPSDEDRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrname = string;
        this.psdedrnameDirtyFlag = true;
    }

    public String getPSDEDRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRName();
        }
        return this.psdedrname;
    }

    public boolean isPSDEDRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRNameDirty();
        }
        return this.psdedrnameDirtyFlag;
    }

    public void resetPSDEDRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRName();
            return;
        }
        this.psdedrnameDirtyFlag = false;
        this.psdedrname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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

    public void setPSDEListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistid = string;
        this.psdelistidDirtyFlag = true;
    }

    public String getPSDEListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListId();
        }
        return this.psdelistid;
    }

    public boolean isPSDEListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListIdDirty();
        }
        return this.psdelistidDirtyFlag;
    }

    public void resetPSDEListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListId();
            return;
        }
        this.psdelistidDirtyFlag = false;
        this.psdelistid = null;
    }

    public void setPSDEListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistname = string;
        this.psdelistnameDirtyFlag = true;
    }

    public String getPSDEListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListName();
        }
        return this.psdelistname;
    }

    public boolean isPSDEListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListNameDirty();
        }
        return this.psdelistnameDirtyFlag;
    }

    public void resetPSDEListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListName();
            return;
        }
        this.psdelistnameDirtyFlag = false;
        this.psdelistname = null;
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

    public void setPSDESearchFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESearchFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesearchformid = string;
        this.psdesearchformidDirtyFlag = true;
    }

    public String getPSDESearchFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESearchFormId();
        }
        return this.psdesearchformid;
    }

    public boolean isPSDESearchFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESearchFormIdDirty();
        }
        return this.psdesearchformidDirtyFlag;
    }

    public void resetPSDESearchFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESearchFormId();
            return;
        }
        this.psdesearchformidDirtyFlag = false;
        this.psdesearchformid = null;
    }

    public void setPSDESearchFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESearchFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesearchformname = string;
        this.psdesearchformnameDirtyFlag = true;
    }

    public String getPSDESearchFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESearchFormName();
        }
        return this.psdesearchformname;
    }

    public boolean isPSDESearchFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESearchFormNameDirty();
        }
        return this.psdesearchformnameDirtyFlag;
    }

    public void resetPSDESearchFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESearchFormName();
            return;
        }
        this.psdesearchformnameDirtyFlag = false;
        this.psdesearchformname = null;
    }

    public void setPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarid = string;
        this.psdetoolbaridDirtyFlag = true;
    }

    public String getPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarId();
        }
        return this.psdetoolbarid;
    }

    public boolean isPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarIdDirty();
        }
        return this.psdetoolbaridDirtyFlag;
    }

    public void resetPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarId();
            return;
        }
        this.psdetoolbaridDirtyFlag = false;
        this.psdetoolbarid = null;
    }

    public void setPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarname = string;
        this.psdetoolbarnameDirtyFlag = true;
    }

    public String getPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarName();
        }
        return this.psdetoolbarname;
    }

    public boolean isPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarNameDirty();
        }
        return this.psdetoolbarnameDirtyFlag;
    }

    public void resetPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarName();
            return;
        }
        this.psdetoolbarnameDirtyFlag = false;
        this.psdetoolbarname = null;
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

    public void setPSDEViewBaseType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasetype = string;
        this.psdeviewbasetypeDirtyFlag = true;
    }

    public String getPSDEViewBaseType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseType();
        }
        return this.psdeviewbasetype;
    }

    public boolean isPSDEViewBaseTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseTypeDirty();
        }
        return this.psdeviewbasetypeDirtyFlag;
    }

    public void resetPSDEViewBaseType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseType();
            return;
        }
        this.psdeviewbasetypeDirtyFlag = false;
        this.psdeviewbasetype = null;
    }

    public void setPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewid = string;
        this.psdeviewidDirtyFlag = true;
    }

    public String getPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewId();
        }
        return this.psdeviewid;
    }

    public boolean isPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewIdDirty();
        }
        return this.psdeviewidDirtyFlag;
    }

    public void resetPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewId();
            return;
        }
        this.psdeviewidDirtyFlag = false;
        this.psdeviewid = null;
    }

    public void setPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewname = string;
        this.psdeviewnameDirtyFlag = true;
    }

    public String getPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewName();
        }
        return this.psdeviewname;
    }

    public boolean isPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewNameDirty();
        }
        return this.psdeviewnameDirtyFlag;
    }

    public void resetPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewName();
            return;
        }
        this.psdeviewnameDirtyFlag = false;
        this.psdeviewname = null;
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

    public void setPSSFACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfachandlerid = string;
        this.pssfachandleridDirtyFlag = true;
    }

    public String getPSSFACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFACHandlerId();
        }
        return this.pssfachandlerid;
    }

    public boolean isPSSFACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFACHandlerIdDirty();
        }
        return this.pssfachandleridDirtyFlag;
    }

    public void resetPSSFACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFACHandlerId();
            return;
        }
        this.pssfachandleridDirtyFlag = false;
        this.pssfachandlerid = null;
    }

    public void setPSSFACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfachandlername = string;
        this.pssfachandlernameDirtyFlag = true;
    }

    public String getPSSFACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFACHandlerName();
        }
        return this.pssfachandlername;
    }

    public boolean isPSSFACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFACHandlerNameDirty();
        }
        return this.pssfachandlernameDirtyFlag;
    }

    public void resetPSSFACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFACHandlerName();
            return;
        }
        this.pssfachandlernameDirtyFlag = false;
        this.pssfachandlername = null;
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

    public void setPSUWAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwappviewid = string;
        this.psuwappviewidDirtyFlag = true;
    }

    public String getPSUWAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWAppViewId();
        }
        return this.psuwappviewid;
    }

    public boolean isPSUWAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWAppViewIdDirty();
        }
        return this.psuwappviewidDirtyFlag;
    }

    public void resetPSUWAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWAppViewId();
            return;
        }
        this.psuwappviewidDirtyFlag = false;
        this.psuwappviewid = null;
    }

    public void setPSUWAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwappviewname = string;
        this.psuwappviewnameDirtyFlag = true;
    }

    public String getPSUWAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWAppViewName();
        }
        return this.psuwappviewname;
    }

    public boolean isPSUWAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWAppViewNameDirty();
        }
        return this.psuwappviewnameDirtyFlag;
    }

    public void resetPSUWAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWAppViewName();
            return;
        }
        this.psuwappviewnameDirtyFlag = false;
        this.psuwappviewname = null;
    }

    public void setSrcPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdeviewid = string;
        this.srcpsdeviewidDirtyFlag = true;
    }

    public String getSrcPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEViewId();
        }
        return this.srcpsdeviewid;
    }

    public boolean isSrcPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDEViewIdDirty();
        }
        return this.srcpsdeviewidDirtyFlag;
    }

    public void resetSrcPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDEViewId();
            return;
        }
        this.srcpsdeviewidDirtyFlag = false;
        this.srcpsdeviewid = null;
    }

    public void setSrcPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdeviewname = string;
        this.srcpsdeviewnameDirtyFlag = true;
    }

    public String getSrcPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEViewName();
        }
        return this.srcpsdeviewname;
    }

    public boolean isSrcPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDEViewNameDirty();
        }
        return this.srcpsdeviewnameDirtyFlag;
    }

    public void resetSrcPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDEViewName();
            return;
        }
        this.srcpsdeviewnameDirtyFlag = false;
        this.srcpsdeviewname = null;
    }

    public void setSRFNextForm(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFNextForm(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srfnextform = string;
        this.srfnextformDirtyFlag = true;
    }

    public String getSRFNextForm() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFNextForm();
        }
        return this.srfnextform;
    }

    public boolean isSRFNextFormDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFNextFormDirty();
        }
        return this.srfnextformDirtyFlag;
    }

    public void resetSRFNextForm() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFNextForm();
            return;
        }
        this.srfnextformDirtyFlag = false;
        this.srfnextform = null;
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

    public void setWizardMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardmode = string;
        this.wizardmodeDirtyFlag = true;
    }

    public String getWizardMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardMode();
        }
        return this.wizardmode;
    }

    public boolean isWizardModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardModeDirty();
        }
        return this.wizardmodeDirtyFlag;
    }

    public void resetWizardMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardMode();
            return;
        }
        this.wizardmodeDirtyFlag = false;
        this.wizardmode = null;
    }

    public void setWizardParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam = string;
        this.wizardparamDirtyFlag = true;
    }

    public String getWizardParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam();
        }
        return this.wizardparam;
    }

    public boolean isWizardParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParamDirty();
        }
        return this.wizardparamDirtyFlag;
    }

    public void resetWizardParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam();
            return;
        }
        this.wizardparamDirtyFlag = false;
        this.wizardparam = null;
    }

    public void setWizardParam10(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam10(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam10 = string;
        this.wizardparam10DirtyFlag = true;
    }

    public String getWizardParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam10();
        }
        return this.wizardparam10;
    }

    public boolean isWizardParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam10Dirty();
        }
        return this.wizardparam10DirtyFlag;
    }

    public void resetWizardParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam10();
            return;
        }
        this.wizardparam10DirtyFlag = false;
        this.wizardparam10 = null;
    }

    public void setWizardParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam11(n);
            return;
        }
        this.wizardparam11 = n;
        this.wizardparam11DirtyFlag = true;
    }

    public Integer getWizardParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam11();
        }
        return this.wizardparam11;
    }

    public boolean isWizardParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam11Dirty();
        }
        return this.wizardparam11DirtyFlag;
    }

    public void resetWizardParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam11();
            return;
        }
        this.wizardparam11DirtyFlag = false;
        this.wizardparam11 = null;
    }

    public void setWizardParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam12(n);
            return;
        }
        this.wizardparam12 = n;
        this.wizardparam12DirtyFlag = true;
    }

    public Integer getWizardParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam12();
        }
        return this.wizardparam12;
    }

    public boolean isWizardParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam12Dirty();
        }
        return this.wizardparam12DirtyFlag;
    }

    public void resetWizardParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam12();
            return;
        }
        this.wizardparam12DirtyFlag = false;
        this.wizardparam12 = null;
    }

    public void setWizardParam13(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam13(n);
            return;
        }
        this.wizardparam13 = n;
        this.wizardparam13DirtyFlag = true;
    }

    public Integer getWizardParam13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam13();
        }
        return this.wizardparam13;
    }

    public boolean isWizardParam13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam13Dirty();
        }
        return this.wizardparam13DirtyFlag;
    }

    public void resetWizardParam13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam13();
            return;
        }
        this.wizardparam13DirtyFlag = false;
        this.wizardparam13 = null;
    }

    public void setWizardParam14(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam14(n);
            return;
        }
        this.wizardparam14 = n;
        this.wizardparam14DirtyFlag = true;
    }

    public Integer getWizardParam14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam14();
        }
        return this.wizardparam14;
    }

    public boolean isWizardParam14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam14Dirty();
        }
        return this.wizardparam14DirtyFlag;
    }

    public void resetWizardParam14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam14();
            return;
        }
        this.wizardparam14DirtyFlag = false;
        this.wizardparam14 = null;
    }

    public void setWizardParam15(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam15(n);
            return;
        }
        this.wizardparam15 = n;
        this.wizardparam15DirtyFlag = true;
    }

    public Integer getWizardParam15() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam15();
        }
        return this.wizardparam15;
    }

    public boolean isWizardParam15Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam15Dirty();
        }
        return this.wizardparam15DirtyFlag;
    }

    public void resetWizardParam15() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam15();
            return;
        }
        this.wizardparam15DirtyFlag = false;
        this.wizardparam15 = null;
    }

    public void setWizardParam16(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam16(n);
            return;
        }
        this.wizardparam16 = n;
        this.wizardparam16DirtyFlag = true;
    }

    public Integer getWizardParam16() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam16();
        }
        return this.wizardparam16;
    }

    public boolean isWizardParam16Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam16Dirty();
        }
        return this.wizardparam16DirtyFlag;
    }

    public void resetWizardParam16() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam16();
            return;
        }
        this.wizardparam16DirtyFlag = false;
        this.wizardparam16 = null;
    }

    public void setWizardParam17(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam17(d);
            return;
        }
        this.wizardparam17 = d;
        this.wizardparam17DirtyFlag = true;
    }

    public Double getWizardParam17() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam17();
        }
        return this.wizardparam17;
    }

    public boolean isWizardParam17Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam17Dirty();
        }
        return this.wizardparam17DirtyFlag;
    }

    public void resetWizardParam17() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam17();
            return;
        }
        this.wizardparam17DirtyFlag = false;
        this.wizardparam17 = null;
    }

    public void setWizardParam18(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam18(d);
            return;
        }
        this.wizardparam18 = d;
        this.wizardparam18DirtyFlag = true;
    }

    public Double getWizardParam18() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam18();
        }
        return this.wizardparam18;
    }

    public boolean isWizardParam18Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam18Dirty();
        }
        return this.wizardparam18DirtyFlag;
    }

    public void resetWizardParam18() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam18();
            return;
        }
        this.wizardparam18DirtyFlag = false;
        this.wizardparam18 = null;
    }

    public void setWizardParam19(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam19(timestamp);
            return;
        }
        this.wizardparam19 = timestamp;
        this.wizardparam19DirtyFlag = true;
    }

    public Timestamp getWizardParam19() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam19();
        }
        return this.wizardparam19;
    }

    public boolean isWizardParam19Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam19Dirty();
        }
        return this.wizardparam19DirtyFlag;
    }

    public void resetWizardParam19() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam19();
            return;
        }
        this.wizardparam19DirtyFlag = false;
        this.wizardparam19 = null;
    }

    public void setWizardParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam2 = string;
        this.wizardparam2DirtyFlag = true;
    }

    public String getWizardParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam2();
        }
        return this.wizardparam2;
    }

    public boolean isWizardParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam2Dirty();
        }
        return this.wizardparam2DirtyFlag;
    }

    public void resetWizardParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam2();
            return;
        }
        this.wizardparam2DirtyFlag = false;
        this.wizardparam2 = null;
    }

    public void setWizardParam20(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam20(timestamp);
            return;
        }
        this.wizardparam20 = timestamp;
        this.wizardparam20DirtyFlag = true;
    }

    public Timestamp getWizardParam20() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam20();
        }
        return this.wizardparam20;
    }

    public boolean isWizardParam20Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam20Dirty();
        }
        return this.wizardparam20DirtyFlag;
    }

    public void resetWizardParam20() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam20();
            return;
        }
        this.wizardparam20DirtyFlag = false;
        this.wizardparam20 = null;
    }

    public void setWizardParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam3(n);
            return;
        }
        this.wizardparam3 = n;
        this.wizardparam3DirtyFlag = true;
    }

    public Integer getWizardParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam3();
        }
        return this.wizardparam3;
    }

    public boolean isWizardParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam3Dirty();
        }
        return this.wizardparam3DirtyFlag;
    }

    public void resetWizardParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam3();
            return;
        }
        this.wizardparam3DirtyFlag = false;
        this.wizardparam3 = null;
    }

    public void setWizardParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam4(n);
            return;
        }
        this.wizardparam4 = n;
        this.wizardparam4DirtyFlag = true;
    }

    public Integer getWizardParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam4();
        }
        return this.wizardparam4;
    }

    public boolean isWizardParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam4Dirty();
        }
        return this.wizardparam4DirtyFlag;
    }

    public void resetWizardParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam4();
            return;
        }
        this.wizardparam4DirtyFlag = false;
        this.wizardparam4 = null;
    }

    public void setWizardParam5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam5 = string;
        this.wizardparam5DirtyFlag = true;
    }

    public String getWizardParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam5();
        }
        return this.wizardparam5;
    }

    public boolean isWizardParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam5Dirty();
        }
        return this.wizardparam5DirtyFlag;
    }

    public void resetWizardParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam5();
            return;
        }
        this.wizardparam5DirtyFlag = false;
        this.wizardparam5 = null;
    }

    public void setWizardParam6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam6 = string;
        this.wizardparam6DirtyFlag = true;
    }

    public String getWizardParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam6();
        }
        return this.wizardparam6;
    }

    public boolean isWizardParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam6Dirty();
        }
        return this.wizardparam6DirtyFlag;
    }

    public void resetWizardParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam6();
            return;
        }
        this.wizardparam6DirtyFlag = false;
        this.wizardparam6 = null;
    }

    public void setWizardParam7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam7 = string;
        this.wizardparam7DirtyFlag = true;
    }

    public String getWizardParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam7();
        }
        return this.wizardparam7;
    }

    public boolean isWizardParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam7Dirty();
        }
        return this.wizardparam7DirtyFlag;
    }

    public void resetWizardParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam7();
            return;
        }
        this.wizardparam7DirtyFlag = false;
        this.wizardparam7 = null;
    }

    public void setWizardParam8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam8 = string;
        this.wizardparam8DirtyFlag = true;
    }

    public String getWizardParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam8();
        }
        return this.wizardparam8;
    }

    public boolean isWizardParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam8Dirty();
        }
        return this.wizardparam8DirtyFlag;
    }

    public void resetWizardParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam8();
            return;
        }
        this.wizardparam8DirtyFlag = false;
        this.wizardparam8 = null;
    }

    public void setWizardParam9(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam9(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam9 = string;
        this.wizardparam9DirtyFlag = true;
    }

    public String getWizardParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam9();
        }
        return this.wizardparam9;
    }

    public boolean isWizardParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam9Dirty();
        }
        return this.wizardparam9DirtyFlag;
    }

    public void resetWizardParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam9();
            return;
        }
        this.wizardparam9DirtyFlag = false;
        this.wizardparam9 = null;
    }

    protected void onReset() {
        PSUWAppViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWAppViewBase pSUWAppViewBase) {
        pSUWAppViewBase.resetCaption();
        pSUWAppViewBase.resetCodeName();
        pSUWAppViewBase.resetCreateDate();
        pSUWAppViewBase.resetCreateMan();
        pSUWAppViewBase.resetEnableSrcPSDEView();
        pSUWAppViewBase.resetListCtrlParam();
        pSUWAppViewBase.resetLoadDefault();
        pSUWAppViewBase.resetMDCtrlParam();
        pSUWAppViewBase.resetPredefinedViewType();
        pSUWAppViewBase.resetPSACHandlerId();
        pSUWAppViewBase.resetPSACHandlerName();
        pSUWAppViewBase.resetPSAppModuleId();
        pSUWAppViewBase.resetPSAppModuleName();
        pSUWAppViewBase.resetPSAppViewId();
        pSUWAppViewBase.resetPSAppViewName();
        pSUWAppViewBase.resetPSAppViewType();
        pSUWAppViewBase.resetPSCtrlId();
        pSUWAppViewBase.resetPSCtrlName();
        pSUWAppViewBase.resetPSCtrlTypeId();
        pSUWAppViewBase.resetPSCtrlTypeName();
        pSUWAppViewBase.resetPSDEDataSetId();
        pSUWAppViewBase.resetPSDEDataSetName();
        pSUWAppViewBase.resetPSDEDataViewId();
        pSUWAppViewBase.resetPSDEDataViewName();
        pSUWAppViewBase.resetPSDEDRId();
        pSUWAppViewBase.resetPSDEDRName();
        pSUWAppViewBase.resetPSDEFormId();
        pSUWAppViewBase.resetPSDEFormName();
        pSUWAppViewBase.resetPSDEGridId();
        pSUWAppViewBase.resetPSDEGridName();
        pSUWAppViewBase.resetPSDEId();
        pSUWAppViewBase.resetPSDEListId();
        pSUWAppViewBase.resetPSDEListName();
        pSUWAppViewBase.resetPSDEName();
        pSUWAppViewBase.resetPSDESearchFormId();
        pSUWAppViewBase.resetPSDESearchFormName();
        pSUWAppViewBase.resetPSDEToolbarId();
        pSUWAppViewBase.resetPSDEToolbarName();
        pSUWAppViewBase.resetPSDEViewBaseId();
        pSUWAppViewBase.resetPSDEViewBaseName();
        pSUWAppViewBase.resetPSDEViewBaseType();
        pSUWAppViewBase.resetPSDEViewId();
        pSUWAppViewBase.resetPSDEViewName();
        pSUWAppViewBase.resetPSDynaInstId();
        pSUWAppViewBase.resetPSSFACHandlerId();
        pSUWAppViewBase.resetPSSFACHandlerName();
        pSUWAppViewBase.resetPSSysAppId();
        pSUWAppViewBase.resetPSUWAppViewId();
        pSUWAppViewBase.resetPSUWAppViewName();
        pSUWAppViewBase.resetSrcPSDEViewId();
        pSUWAppViewBase.resetSrcPSDEViewName();
        pSUWAppViewBase.resetSRFNextForm();
        pSUWAppViewBase.resetTitle();
        pSUWAppViewBase.resetUpdateDate();
        pSUWAppViewBase.resetUpdateMan();
        pSUWAppViewBase.resetViewParam();
        pSUWAppViewBase.resetViewParam10();
        pSUWAppViewBase.resetViewParam2();
        pSUWAppViewBase.resetViewParam3();
        pSUWAppViewBase.resetViewParam4();
        pSUWAppViewBase.resetViewParam5();
        pSUWAppViewBase.resetViewParam6();
        pSUWAppViewBase.resetViewParam7();
        pSUWAppViewBase.resetViewParam8();
        pSUWAppViewBase.resetViewParam9();
        pSUWAppViewBase.resetWizardMode();
        pSUWAppViewBase.resetWizardParam();
        pSUWAppViewBase.resetWizardParam10();
        pSUWAppViewBase.resetWizardParam11();
        pSUWAppViewBase.resetWizardParam12();
        pSUWAppViewBase.resetWizardParam13();
        pSUWAppViewBase.resetWizardParam14();
        pSUWAppViewBase.resetWizardParam15();
        pSUWAppViewBase.resetWizardParam16();
        pSUWAppViewBase.resetWizardParam17();
        pSUWAppViewBase.resetWizardParam18();
        pSUWAppViewBase.resetWizardParam19();
        pSUWAppViewBase.resetWizardParam2();
        pSUWAppViewBase.resetWizardParam20();
        pSUWAppViewBase.resetWizardParam3();
        pSUWAppViewBase.resetWizardParam4();
        pSUWAppViewBase.resetWizardParam5();
        pSUWAppViewBase.resetWizardParam6();
        pSUWAppViewBase.resetWizardParam7();
        pSUWAppViewBase.resetWizardParam8();
        pSUWAppViewBase.resetWizardParam9();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
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
        if (!bl || this.isEnableSrcPSDEViewDirty()) {
            hashMap.put(FIELD_ENABLESRCPSDEVIEW, this.getEnableSrcPSDEView());
        }
        if (!bl || this.isListCtrlParamDirty()) {
            hashMap.put(FIELD_LISTCTRLPARAM, this.getListCtrlParam());
        }
        if (!bl || this.isLoadDefaultDirty()) {
            hashMap.put(FIELD_LOADDEFAULT, this.getLoadDefault());
        }
        if (!bl || this.isMDCtrlParamDirty()) {
            hashMap.put(FIELD_MDCTRLPARAM, this.getMDCtrlParam());
        }
        if (!bl || this.isPredefinedViewTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDVIEWTYPE, this.getPredefinedViewType());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSAppModuleIdDirty()) {
            hashMap.put(FIELD_PSAPPMODULEID, this.getPSAppModuleId());
        }
        if (!bl || this.isPSAppModuleNameDirty()) {
            hashMap.put(FIELD_PSAPPMODULENAME, this.getPSAppModuleName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSAppViewTypeDirty()) {
            hashMap.put(FIELD_PSAPPVIEWTYPE, this.getPSAppViewType());
        }
        if (!bl || this.isPSCtrlIdDirty()) {
            hashMap.put(FIELD_PSCTRLID, this.getPSCtrlId());
        }
        if (!bl || this.isPSCtrlNameDirty()) {
            hashMap.put(FIELD_PSCTRLNAME, this.getPSCtrlName());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEDataViewIdDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWID, this.getPSDEDataViewId());
        }
        if (!bl || this.isPSDEDataViewNameDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWNAME, this.getPSDEDataViewName());
        }
        if (!bl || this.isPSDEDRIdDirty()) {
            hashMap.put(FIELD_PSDEDRID, this.getPSDEDRId());
        }
        if (!bl || this.isPSDEDRNameDirty()) {
            hashMap.put(FIELD_PSDEDRNAME, this.getPSDEDRName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEListIdDirty()) {
            hashMap.put(FIELD_PSDELISTID, this.getPSDEListId());
        }
        if (!bl || this.isPSDEListNameDirty()) {
            hashMap.put(FIELD_PSDELISTNAME, this.getPSDEListName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDESearchFormIdDirty()) {
            hashMap.put(FIELD_PSDESEARCHFORMID, this.getPSDESearchFormId());
        }
        if (!bl || this.isPSDESearchFormNameDirty()) {
            hashMap.put(FIELD_PSDESEARCHFORMNAME, this.getPSDESearchFormName());
        }
        if (!bl || this.isPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_PSDETOOLBARID, this.getPSDEToolbarId());
        }
        if (!bl || this.isPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_PSDETOOLBARNAME, this.getPSDEToolbarName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewBaseTypeDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASETYPE, this.getPSDEViewBaseType());
        }
        if (!bl || this.isPSDEViewIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWID, this.getPSDEViewId());
        }
        if (!bl || this.isPSDEViewNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWNAME, this.getPSDEViewName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSFACHandlerIdDirty()) {
            hashMap.put(FIELD_PSSFACHANDLERID, this.getPSSFACHandlerId());
        }
        if (!bl || this.isPSSFACHandlerNameDirty()) {
            hashMap.put(FIELD_PSSFACHANDLERNAME, this.getPSSFACHandlerName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSUWAppViewIdDirty()) {
            hashMap.put(FIELD_PSUWAPPVIEWID, this.getPSUWAppViewId());
        }
        if (!bl || this.isPSUWAppViewNameDirty()) {
            hashMap.put(FIELD_PSUWAPPVIEWNAME, this.getPSUWAppViewName());
        }
        if (!bl || this.isSrcPSDEViewIdDirty()) {
            hashMap.put(FIELD_SRCPSDEVIEWID, this.getSrcPSDEViewId());
        }
        if (!bl || this.isSrcPSDEViewNameDirty()) {
            hashMap.put(FIELD_SRCPSDEVIEWNAME, this.getSrcPSDEViewName());
        }
        if (!bl || this.isSRFNextFormDirty()) {
            hashMap.put(FIELD_SRFNEXTFORM, this.getSRFNextForm());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        if (!bl || this.isWizardModeDirty()) {
            hashMap.put(FIELD_WIZARDMODE, this.getWizardMode());
        }
        if (!bl || this.isWizardParamDirty()) {
            hashMap.put(FIELD_WIZARDPARAM, this.getWizardParam());
        }
        if (!bl || this.isWizardParam10Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM10, this.getWizardParam10());
        }
        if (!bl || this.isWizardParam11Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM11, this.getWizardParam11());
        }
        if (!bl || this.isWizardParam12Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM12, this.getWizardParam12());
        }
        if (!bl || this.isWizardParam13Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM13, this.getWizardParam13());
        }
        if (!bl || this.isWizardParam14Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM14, this.getWizardParam14());
        }
        if (!bl || this.isWizardParam15Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM15, this.getWizardParam15());
        }
        if (!bl || this.isWizardParam16Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM16, this.getWizardParam16());
        }
        if (!bl || this.isWizardParam17Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM17, this.getWizardParam17());
        }
        if (!bl || this.isWizardParam18Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM18, this.getWizardParam18());
        }
        if (!bl || this.isWizardParam19Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM19, this.getWizardParam19());
        }
        if (!bl || this.isWizardParam2Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM2, this.getWizardParam2());
        }
        if (!bl || this.isWizardParam20Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM20, this.getWizardParam20());
        }
        if (!bl || this.isWizardParam3Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM3, this.getWizardParam3());
        }
        if (!bl || this.isWizardParam4Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM4, this.getWizardParam4());
        }
        if (!bl || this.isWizardParam5Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM5, this.getWizardParam5());
        }
        if (!bl || this.isWizardParam6Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM6, this.getWizardParam6());
        }
        if (!bl || this.isWizardParam7Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM7, this.getWizardParam7());
        }
        if (!bl || this.isWizardParam8Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM8, this.getWizardParam8());
        }
        if (!bl || this.isWizardParam9Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM9, this.getWizardParam9());
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
        return PSUWAppViewBase.get(this, n);
    }

    private static Object get(PSUWAppViewBase pSUWAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAppViewBase.getCaption();
            }
            case 1: {
                return pSUWAppViewBase.getCodeName();
            }
            case 2: {
                return pSUWAppViewBase.getCreateDate();
            }
            case 3: {
                return pSUWAppViewBase.getCreateMan();
            }
            case 4: {
                return pSUWAppViewBase.getEnableSrcPSDEView();
            }
            case 5: {
                return pSUWAppViewBase.getListCtrlParam();
            }
            case 6: {
                return pSUWAppViewBase.getLoadDefault();
            }
            case 7: {
                return pSUWAppViewBase.getMDCtrlParam();
            }
            case 8: {
                return pSUWAppViewBase.getPredefinedViewType();
            }
            case 9: {
                return pSUWAppViewBase.getPSACHandlerId();
            }
            case 10: {
                return pSUWAppViewBase.getPSACHandlerName();
            }
            case 11: {
                return pSUWAppViewBase.getPSAppModuleId();
            }
            case 12: {
                return pSUWAppViewBase.getPSAppModuleName();
            }
            case 13: {
                return pSUWAppViewBase.getPSAppViewId();
            }
            case 14: {
                return pSUWAppViewBase.getPSAppViewName();
            }
            case 15: {
                return pSUWAppViewBase.getPSAppViewType();
            }
            case 16: {
                return pSUWAppViewBase.getPSCtrlId();
            }
            case 17: {
                return pSUWAppViewBase.getPSCtrlName();
            }
            case 18: {
                return pSUWAppViewBase.getPSCtrlTypeId();
            }
            case 19: {
                return pSUWAppViewBase.getPSCtrlTypeName();
            }
            case 20: {
                return pSUWAppViewBase.getPSDEDataSetId();
            }
            case 21: {
                return pSUWAppViewBase.getPSDEDataSetName();
            }
            case 22: {
                return pSUWAppViewBase.getPSDEDataViewId();
            }
            case 23: {
                return pSUWAppViewBase.getPSDEDataViewName();
            }
            case 24: {
                return pSUWAppViewBase.getPSDEDRId();
            }
            case 25: {
                return pSUWAppViewBase.getPSDEDRName();
            }
            case 26: {
                return pSUWAppViewBase.getPSDEFormId();
            }
            case 27: {
                return pSUWAppViewBase.getPSDEFormName();
            }
            case 28: {
                return pSUWAppViewBase.getPSDEGridId();
            }
            case 29: {
                return pSUWAppViewBase.getPSDEGridName();
            }
            case 30: {
                return pSUWAppViewBase.getPSDEId();
            }
            case 31: {
                return pSUWAppViewBase.getPSDEListId();
            }
            case 32: {
                return pSUWAppViewBase.getPSDEListName();
            }
            case 33: {
                return pSUWAppViewBase.getPSDEName();
            }
            case 34: {
                return pSUWAppViewBase.getPSDESearchFormId();
            }
            case 35: {
                return pSUWAppViewBase.getPSDESearchFormName();
            }
            case 36: {
                return pSUWAppViewBase.getPSDEToolbarId();
            }
            case 37: {
                return pSUWAppViewBase.getPSDEToolbarName();
            }
            case 38: {
                return pSUWAppViewBase.getPSDEViewBaseId();
            }
            case 39: {
                return pSUWAppViewBase.getPSDEViewBaseName();
            }
            case 40: {
                return pSUWAppViewBase.getPSDEViewBaseType();
            }
            case 41: {
                return pSUWAppViewBase.getPSDEViewId();
            }
            case 42: {
                return pSUWAppViewBase.getPSDEViewName();
            }
            case 43: {
                return pSUWAppViewBase.getPSDynaInstId();
            }
            case 44: {
                return pSUWAppViewBase.getPSSFACHandlerId();
            }
            case 45: {
                return pSUWAppViewBase.getPSSFACHandlerName();
            }
            case 46: {
                return pSUWAppViewBase.getPSSysAppId();
            }
            case 47: {
                return pSUWAppViewBase.getPSUWAppViewId();
            }
            case 48: {
                return pSUWAppViewBase.getPSUWAppViewName();
            }
            case 49: {
                return pSUWAppViewBase.getSrcPSDEViewId();
            }
            case 50: {
                return pSUWAppViewBase.getSrcPSDEViewName();
            }
            case 51: {
                return pSUWAppViewBase.getSRFNextForm();
            }
            case 52: {
                return pSUWAppViewBase.getTitle();
            }
            case 53: {
                return pSUWAppViewBase.getUpdateDate();
            }
            case 54: {
                return pSUWAppViewBase.getUpdateMan();
            }
            case 55: {
                return pSUWAppViewBase.getViewParam();
            }
            case 56: {
                return pSUWAppViewBase.getViewParam10();
            }
            case 57: {
                return pSUWAppViewBase.getViewParam2();
            }
            case 58: {
                return pSUWAppViewBase.getViewParam3();
            }
            case 59: {
                return pSUWAppViewBase.getViewParam4();
            }
            case 60: {
                return pSUWAppViewBase.getViewParam5();
            }
            case 61: {
                return pSUWAppViewBase.getViewParam6();
            }
            case 62: {
                return pSUWAppViewBase.getViewParam7();
            }
            case 63: {
                return pSUWAppViewBase.getViewParam8();
            }
            case 64: {
                return pSUWAppViewBase.getViewParam9();
            }
            case 65: {
                return pSUWAppViewBase.getWizardMode();
            }
            case 66: {
                return pSUWAppViewBase.getWizardParam();
            }
            case 67: {
                return pSUWAppViewBase.getWizardParam10();
            }
            case 68: {
                return pSUWAppViewBase.getWizardParam11();
            }
            case 69: {
                return pSUWAppViewBase.getWizardParam12();
            }
            case 70: {
                return pSUWAppViewBase.getWizardParam13();
            }
            case 71: {
                return pSUWAppViewBase.getWizardParam14();
            }
            case 72: {
                return pSUWAppViewBase.getWizardParam15();
            }
            case 73: {
                return pSUWAppViewBase.getWizardParam16();
            }
            case 74: {
                return pSUWAppViewBase.getWizardParam17();
            }
            case 75: {
                return pSUWAppViewBase.getWizardParam18();
            }
            case 76: {
                return pSUWAppViewBase.getWizardParam19();
            }
            case 77: {
                return pSUWAppViewBase.getWizardParam2();
            }
            case 78: {
                return pSUWAppViewBase.getWizardParam20();
            }
            case 79: {
                return pSUWAppViewBase.getWizardParam3();
            }
            case 80: {
                return pSUWAppViewBase.getWizardParam4();
            }
            case 81: {
                return pSUWAppViewBase.getWizardParam5();
            }
            case 82: {
                return pSUWAppViewBase.getWizardParam6();
            }
            case 83: {
                return pSUWAppViewBase.getWizardParam7();
            }
            case 84: {
                return pSUWAppViewBase.getWizardParam8();
            }
            case 85: {
                return pSUWAppViewBase.getWizardParam9();
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
        PSUWAppViewBase.set(this, n, object);
    }

    private static void set(PSUWAppViewBase pSUWAppViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWAppViewBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWAppViewBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWAppViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSUWAppViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWAppViewBase.setEnableSrcPSDEView(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSUWAppViewBase.setListCtrlParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWAppViewBase.setLoadDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSUWAppViewBase.setMDCtrlParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWAppViewBase.setPredefinedViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWAppViewBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWAppViewBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWAppViewBase.setPSAppModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWAppViewBase.setPSAppModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWAppViewBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWAppViewBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWAppViewBase.setPSAppViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWAppViewBase.setPSCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWAppViewBase.setPSCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWAppViewBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSUWAppViewBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUWAppViewBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSUWAppViewBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUWAppViewBase.setPSDEDataViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSUWAppViewBase.setPSDEDataViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSUWAppViewBase.setPSDEDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSUWAppViewBase.setPSDEDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSUWAppViewBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSUWAppViewBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSUWAppViewBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSUWAppViewBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSUWAppViewBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSUWAppViewBase.setPSDEListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSUWAppViewBase.setPSDEListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSUWAppViewBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSUWAppViewBase.setPSDESearchFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSUWAppViewBase.setPSDESearchFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSUWAppViewBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSUWAppViewBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSUWAppViewBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSUWAppViewBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSUWAppViewBase.setPSDEViewBaseType(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSUWAppViewBase.setPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSUWAppViewBase.setPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSUWAppViewBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSUWAppViewBase.setPSSFACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSUWAppViewBase.setPSSFACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSUWAppViewBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSUWAppViewBase.setPSUWAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSUWAppViewBase.setPSUWAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSUWAppViewBase.setSrcPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSUWAppViewBase.setSrcPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSUWAppViewBase.setSRFNextForm(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSUWAppViewBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSUWAppViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 54: {
                pSUWAppViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSUWAppViewBase.setViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSUWAppViewBase.setViewParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSUWAppViewBase.setViewParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSUWAppViewBase.setViewParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSUWAppViewBase.setViewParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSUWAppViewBase.setViewParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSUWAppViewBase.setViewParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSUWAppViewBase.setViewParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSUWAppViewBase.setViewParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSUWAppViewBase.setViewParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 65: {
                pSUWAppViewBase.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSUWAppViewBase.setWizardParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSUWAppViewBase.setWizardParam10(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSUWAppViewBase.setWizardParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 69: {
                pSUWAppViewBase.setWizardParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSUWAppViewBase.setWizardParam13(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 71: {
                pSUWAppViewBase.setWizardParam14(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 72: {
                pSUWAppViewBase.setWizardParam15(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 73: {
                pSUWAppViewBase.setWizardParam16(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 74: {
                pSUWAppViewBase.setWizardParam17(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 75: {
                pSUWAppViewBase.setWizardParam18(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 76: {
                pSUWAppViewBase.setWizardParam19(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 77: {
                pSUWAppViewBase.setWizardParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSUWAppViewBase.setWizardParam20(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 79: {
                pSUWAppViewBase.setWizardParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 80: {
                pSUWAppViewBase.setWizardParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 81: {
                pSUWAppViewBase.setWizardParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSUWAppViewBase.setWizardParam6(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSUWAppViewBase.setWizardParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSUWAppViewBase.setWizardParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSUWAppViewBase.setWizardParam9(DataObject.getStringValue((Object)object));
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
        return PSUWAppViewBase.isNull(this, n);
    }

    private static boolean isNull(PSUWAppViewBase pSUWAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAppViewBase.getCaption() == null;
            }
            case 1: {
                return pSUWAppViewBase.getCodeName() == null;
            }
            case 2: {
                return pSUWAppViewBase.getCreateDate() == null;
            }
            case 3: {
                return pSUWAppViewBase.getCreateMan() == null;
            }
            case 4: {
                return pSUWAppViewBase.getEnableSrcPSDEView() == null;
            }
            case 5: {
                return pSUWAppViewBase.getListCtrlParam() == null;
            }
            case 6: {
                return pSUWAppViewBase.getLoadDefault() == null;
            }
            case 7: {
                return pSUWAppViewBase.getMDCtrlParam() == null;
            }
            case 8: {
                return pSUWAppViewBase.getPredefinedViewType() == null;
            }
            case 9: {
                return pSUWAppViewBase.getPSACHandlerId() == null;
            }
            case 10: {
                return pSUWAppViewBase.getPSACHandlerName() == null;
            }
            case 11: {
                return pSUWAppViewBase.getPSAppModuleId() == null;
            }
            case 12: {
                return pSUWAppViewBase.getPSAppModuleName() == null;
            }
            case 13: {
                return pSUWAppViewBase.getPSAppViewId() == null;
            }
            case 14: {
                return pSUWAppViewBase.getPSAppViewName() == null;
            }
            case 15: {
                return pSUWAppViewBase.getPSAppViewType() == null;
            }
            case 16: {
                return pSUWAppViewBase.getPSCtrlId() == null;
            }
            case 17: {
                return pSUWAppViewBase.getPSCtrlName() == null;
            }
            case 18: {
                return pSUWAppViewBase.getPSCtrlTypeId() == null;
            }
            case 19: {
                return pSUWAppViewBase.getPSCtrlTypeName() == null;
            }
            case 20: {
                return pSUWAppViewBase.getPSDEDataSetId() == null;
            }
            case 21: {
                return pSUWAppViewBase.getPSDEDataSetName() == null;
            }
            case 22: {
                return pSUWAppViewBase.getPSDEDataViewId() == null;
            }
            case 23: {
                return pSUWAppViewBase.getPSDEDataViewName() == null;
            }
            case 24: {
                return pSUWAppViewBase.getPSDEDRId() == null;
            }
            case 25: {
                return pSUWAppViewBase.getPSDEDRName() == null;
            }
            case 26: {
                return pSUWAppViewBase.getPSDEFormId() == null;
            }
            case 27: {
                return pSUWAppViewBase.getPSDEFormName() == null;
            }
            case 28: {
                return pSUWAppViewBase.getPSDEGridId() == null;
            }
            case 29: {
                return pSUWAppViewBase.getPSDEGridName() == null;
            }
            case 30: {
                return pSUWAppViewBase.getPSDEId() == null;
            }
            case 31: {
                return pSUWAppViewBase.getPSDEListId() == null;
            }
            case 32: {
                return pSUWAppViewBase.getPSDEListName() == null;
            }
            case 33: {
                return pSUWAppViewBase.getPSDEName() == null;
            }
            case 34: {
                return pSUWAppViewBase.getPSDESearchFormId() == null;
            }
            case 35: {
                return pSUWAppViewBase.getPSDESearchFormName() == null;
            }
            case 36: {
                return pSUWAppViewBase.getPSDEToolbarId() == null;
            }
            case 37: {
                return pSUWAppViewBase.getPSDEToolbarName() == null;
            }
            case 38: {
                return pSUWAppViewBase.getPSDEViewBaseId() == null;
            }
            case 39: {
                return pSUWAppViewBase.getPSDEViewBaseName() == null;
            }
            case 40: {
                return pSUWAppViewBase.getPSDEViewBaseType() == null;
            }
            case 41: {
                return pSUWAppViewBase.getPSDEViewId() == null;
            }
            case 42: {
                return pSUWAppViewBase.getPSDEViewName() == null;
            }
            case 43: {
                return pSUWAppViewBase.getPSDynaInstId() == null;
            }
            case 44: {
                return pSUWAppViewBase.getPSSFACHandlerId() == null;
            }
            case 45: {
                return pSUWAppViewBase.getPSSFACHandlerName() == null;
            }
            case 46: {
                return pSUWAppViewBase.getPSSysAppId() == null;
            }
            case 47: {
                return pSUWAppViewBase.getPSUWAppViewId() == null;
            }
            case 48: {
                return pSUWAppViewBase.getPSUWAppViewName() == null;
            }
            case 49: {
                return pSUWAppViewBase.getSrcPSDEViewId() == null;
            }
            case 50: {
                return pSUWAppViewBase.getSrcPSDEViewName() == null;
            }
            case 51: {
                return pSUWAppViewBase.getSRFNextForm() == null;
            }
            case 52: {
                return pSUWAppViewBase.getTitle() == null;
            }
            case 53: {
                return pSUWAppViewBase.getUpdateDate() == null;
            }
            case 54: {
                return pSUWAppViewBase.getUpdateMan() == null;
            }
            case 55: {
                return pSUWAppViewBase.getViewParam() == null;
            }
            case 56: {
                return pSUWAppViewBase.getViewParam10() == null;
            }
            case 57: {
                return pSUWAppViewBase.getViewParam2() == null;
            }
            case 58: {
                return pSUWAppViewBase.getViewParam3() == null;
            }
            case 59: {
                return pSUWAppViewBase.getViewParam4() == null;
            }
            case 60: {
                return pSUWAppViewBase.getViewParam5() == null;
            }
            case 61: {
                return pSUWAppViewBase.getViewParam6() == null;
            }
            case 62: {
                return pSUWAppViewBase.getViewParam7() == null;
            }
            case 63: {
                return pSUWAppViewBase.getViewParam8() == null;
            }
            case 64: {
                return pSUWAppViewBase.getViewParam9() == null;
            }
            case 65: {
                return pSUWAppViewBase.getWizardMode() == null;
            }
            case 66: {
                return pSUWAppViewBase.getWizardParam() == null;
            }
            case 67: {
                return pSUWAppViewBase.getWizardParam10() == null;
            }
            case 68: {
                return pSUWAppViewBase.getWizardParam11() == null;
            }
            case 69: {
                return pSUWAppViewBase.getWizardParam12() == null;
            }
            case 70: {
                return pSUWAppViewBase.getWizardParam13() == null;
            }
            case 71: {
                return pSUWAppViewBase.getWizardParam14() == null;
            }
            case 72: {
                return pSUWAppViewBase.getWizardParam15() == null;
            }
            case 73: {
                return pSUWAppViewBase.getWizardParam16() == null;
            }
            case 74: {
                return pSUWAppViewBase.getWizardParam17() == null;
            }
            case 75: {
                return pSUWAppViewBase.getWizardParam18() == null;
            }
            case 76: {
                return pSUWAppViewBase.getWizardParam19() == null;
            }
            case 77: {
                return pSUWAppViewBase.getWizardParam2() == null;
            }
            case 78: {
                return pSUWAppViewBase.getWizardParam20() == null;
            }
            case 79: {
                return pSUWAppViewBase.getWizardParam3() == null;
            }
            case 80: {
                return pSUWAppViewBase.getWizardParam4() == null;
            }
            case 81: {
                return pSUWAppViewBase.getWizardParam5() == null;
            }
            case 82: {
                return pSUWAppViewBase.getWizardParam6() == null;
            }
            case 83: {
                return pSUWAppViewBase.getWizardParam7() == null;
            }
            case 84: {
                return pSUWAppViewBase.getWizardParam8() == null;
            }
            case 85: {
                return pSUWAppViewBase.getWizardParam9() == null;
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
        return PSUWAppViewBase.contains(this, n);
    }

    private static boolean contains(PSUWAppViewBase pSUWAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAppViewBase.isCaptionDirty();
            }
            case 1: {
                return pSUWAppViewBase.isCodeNameDirty();
            }
            case 2: {
                return pSUWAppViewBase.isCreateDateDirty();
            }
            case 3: {
                return pSUWAppViewBase.isCreateManDirty();
            }
            case 4: {
                return pSUWAppViewBase.isEnableSrcPSDEViewDirty();
            }
            case 5: {
                return pSUWAppViewBase.isListCtrlParamDirty();
            }
            case 6: {
                return pSUWAppViewBase.isLoadDefaultDirty();
            }
            case 7: {
                return pSUWAppViewBase.isMDCtrlParamDirty();
            }
            case 8: {
                return pSUWAppViewBase.isPredefinedViewTypeDirty();
            }
            case 9: {
                return pSUWAppViewBase.isPSACHandlerIdDirty();
            }
            case 10: {
                return pSUWAppViewBase.isPSACHandlerNameDirty();
            }
            case 11: {
                return pSUWAppViewBase.isPSAppModuleIdDirty();
            }
            case 12: {
                return pSUWAppViewBase.isPSAppModuleNameDirty();
            }
            case 13: {
                return pSUWAppViewBase.isPSAppViewIdDirty();
            }
            case 14: {
                return pSUWAppViewBase.isPSAppViewNameDirty();
            }
            case 15: {
                return pSUWAppViewBase.isPSAppViewTypeDirty();
            }
            case 16: {
                return pSUWAppViewBase.isPSCtrlIdDirty();
            }
            case 17: {
                return pSUWAppViewBase.isPSCtrlNameDirty();
            }
            case 18: {
                return pSUWAppViewBase.isPSCtrlTypeIdDirty();
            }
            case 19: {
                return pSUWAppViewBase.isPSCtrlTypeNameDirty();
            }
            case 20: {
                return pSUWAppViewBase.isPSDEDataSetIdDirty();
            }
            case 21: {
                return pSUWAppViewBase.isPSDEDataSetNameDirty();
            }
            case 22: {
                return pSUWAppViewBase.isPSDEDataViewIdDirty();
            }
            case 23: {
                return pSUWAppViewBase.isPSDEDataViewNameDirty();
            }
            case 24: {
                return pSUWAppViewBase.isPSDEDRIdDirty();
            }
            case 25: {
                return pSUWAppViewBase.isPSDEDRNameDirty();
            }
            case 26: {
                return pSUWAppViewBase.isPSDEFormIdDirty();
            }
            case 27: {
                return pSUWAppViewBase.isPSDEFormNameDirty();
            }
            case 28: {
                return pSUWAppViewBase.isPSDEGridIdDirty();
            }
            case 29: {
                return pSUWAppViewBase.isPSDEGridNameDirty();
            }
            case 30: {
                return pSUWAppViewBase.isPSDEIdDirty();
            }
            case 31: {
                return pSUWAppViewBase.isPSDEListIdDirty();
            }
            case 32: {
                return pSUWAppViewBase.isPSDEListNameDirty();
            }
            case 33: {
                return pSUWAppViewBase.isPSDENameDirty();
            }
            case 34: {
                return pSUWAppViewBase.isPSDESearchFormIdDirty();
            }
            case 35: {
                return pSUWAppViewBase.isPSDESearchFormNameDirty();
            }
            case 36: {
                return pSUWAppViewBase.isPSDEToolbarIdDirty();
            }
            case 37: {
                return pSUWAppViewBase.isPSDEToolbarNameDirty();
            }
            case 38: {
                return pSUWAppViewBase.isPSDEViewBaseIdDirty();
            }
            case 39: {
                return pSUWAppViewBase.isPSDEViewBaseNameDirty();
            }
            case 40: {
                return pSUWAppViewBase.isPSDEViewBaseTypeDirty();
            }
            case 41: {
                return pSUWAppViewBase.isPSDEViewIdDirty();
            }
            case 42: {
                return pSUWAppViewBase.isPSDEViewNameDirty();
            }
            case 43: {
                return pSUWAppViewBase.isPSDynaInstIdDirty();
            }
            case 44: {
                return pSUWAppViewBase.isPSSFACHandlerIdDirty();
            }
            case 45: {
                return pSUWAppViewBase.isPSSFACHandlerNameDirty();
            }
            case 46: {
                return pSUWAppViewBase.isPSSysAppIdDirty();
            }
            case 47: {
                return pSUWAppViewBase.isPSUWAppViewIdDirty();
            }
            case 48: {
                return pSUWAppViewBase.isPSUWAppViewNameDirty();
            }
            case 49: {
                return pSUWAppViewBase.isSrcPSDEViewIdDirty();
            }
            case 50: {
                return pSUWAppViewBase.isSrcPSDEViewNameDirty();
            }
            case 51: {
                return pSUWAppViewBase.isSRFNextFormDirty();
            }
            case 52: {
                return pSUWAppViewBase.isTitleDirty();
            }
            case 53: {
                return pSUWAppViewBase.isUpdateDateDirty();
            }
            case 54: {
                return pSUWAppViewBase.isUpdateManDirty();
            }
            case 55: {
                return pSUWAppViewBase.isViewParamDirty();
            }
            case 56: {
                return pSUWAppViewBase.isViewParam10Dirty();
            }
            case 57: {
                return pSUWAppViewBase.isViewParam2Dirty();
            }
            case 58: {
                return pSUWAppViewBase.isViewParam3Dirty();
            }
            case 59: {
                return pSUWAppViewBase.isViewParam4Dirty();
            }
            case 60: {
                return pSUWAppViewBase.isViewParam5Dirty();
            }
            case 61: {
                return pSUWAppViewBase.isViewParam6Dirty();
            }
            case 62: {
                return pSUWAppViewBase.isViewParam7Dirty();
            }
            case 63: {
                return pSUWAppViewBase.isViewParam8Dirty();
            }
            case 64: {
                return pSUWAppViewBase.isViewParam9Dirty();
            }
            case 65: {
                return pSUWAppViewBase.isWizardModeDirty();
            }
            case 66: {
                return pSUWAppViewBase.isWizardParamDirty();
            }
            case 67: {
                return pSUWAppViewBase.isWizardParam10Dirty();
            }
            case 68: {
                return pSUWAppViewBase.isWizardParam11Dirty();
            }
            case 69: {
                return pSUWAppViewBase.isWizardParam12Dirty();
            }
            case 70: {
                return pSUWAppViewBase.isWizardParam13Dirty();
            }
            case 71: {
                return pSUWAppViewBase.isWizardParam14Dirty();
            }
            case 72: {
                return pSUWAppViewBase.isWizardParam15Dirty();
            }
            case 73: {
                return pSUWAppViewBase.isWizardParam16Dirty();
            }
            case 74: {
                return pSUWAppViewBase.isWizardParam17Dirty();
            }
            case 75: {
                return pSUWAppViewBase.isWizardParam18Dirty();
            }
            case 76: {
                return pSUWAppViewBase.isWizardParam19Dirty();
            }
            case 77: {
                return pSUWAppViewBase.isWizardParam2Dirty();
            }
            case 78: {
                return pSUWAppViewBase.isWizardParam20Dirty();
            }
            case 79: {
                return pSUWAppViewBase.isWizardParam3Dirty();
            }
            case 80: {
                return pSUWAppViewBase.isWizardParam4Dirty();
            }
            case 81: {
                return pSUWAppViewBase.isWizardParam5Dirty();
            }
            case 82: {
                return pSUWAppViewBase.isWizardParam6Dirty();
            }
            case 83: {
                return pSUWAppViewBase.isWizardParam7Dirty();
            }
            case 84: {
                return pSUWAppViewBase.isWizardParam8Dirty();
            }
            case 85: {
                return pSUWAppViewBase.isWizardParam9Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWAppViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWAppViewBase pSUWAppViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWAppViewBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getCaption()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getCodeName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getEnableSrcPSDEView() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesrcpsdeview", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getEnableSrcPSDEView()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getListCtrlParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"listctrlparam", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getListCtrlParam()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getLoadDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loaddefault", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getLoadDefault()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getMDCtrlParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdctrlparam", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getMDCtrlParam()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPredefinedViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefineviewtype", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPredefinedViewType()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSAppModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmoduleid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSAppModuleId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSAppModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmodulename", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSAppModuleName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSAppViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewtype", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSAppViewType()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSCtrlId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSCtrlName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEDataViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEDataViewId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEDataViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEDataViewName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEDRId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEDRName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEListId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEListName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDESearchFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesearchformid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDESearchFormId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDESearchFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesearchformname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDESearchFormName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEViewBaseType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasetype", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEViewBaseType()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEViewId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDEViewName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSSFACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfachandlerid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSSFACHandlerId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSSFACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfachandlername", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSSFACHandlerName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSUWAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwappviewid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSUWAppViewId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getPSUWAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwappviewname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getPSUWAppViewName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getSrcPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdeviewid", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getSrcPSDEViewId()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getSrcPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdeviewname", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getSrcPSDEViewName()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getSRFNextForm() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfnextform", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getSRFNextForm()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getTitle()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam10", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam10()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam2", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam2()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam3", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam3()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam4", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam4()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam5", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam5()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam6", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam6()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam7", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam7()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam8", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam8()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getViewParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam9", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getViewParam9()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardMode()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam10", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam10()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam11", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam11()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam12", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam12()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam13", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam13()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam14", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam14()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam15() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam15", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam15()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam16() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam16", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam16()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam17() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam17", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam17()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam18() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam18", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam18()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam19() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam19", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam19()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam2()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam20() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam20", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam20()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam3()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam4()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam5", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam5()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam6", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam6()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam7", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam7()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam8", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam8()), (boolean)false);
        }
        if (bl || pSUWAppViewBase.getWizardParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam9", (Object)PSUWAppViewBase.getJSONValue((Object)pSUWAppViewBase.getWizardParam9()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWAppViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWAppViewBase pSUWAppViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWAppViewBase.getCaption() != null) {
            object = pSUWAppViewBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAppViewBase.getCodeName() != null) {
            object = pSUWAppViewBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getCreateDate() != null) {
            object = pSUWAppViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAppViewBase.getCreateMan() != null) {
            object = pSUWAppViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getEnableSrcPSDEView() != null) {
            object = pSUWAppViewBase.getEnableSrcPSDEView();
            xmlNode.setAttribute(FIELD_ENABLESRCPSDEVIEW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getListCtrlParam() != null) {
            object = pSUWAppViewBase.getListCtrlParam();
            xmlNode.setAttribute(FIELD_LISTCTRLPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getLoadDefault() != null) {
            object = pSUWAppViewBase.getLoadDefault();
            xmlNode.setAttribute(FIELD_LOADDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getMDCtrlParam() != null) {
            object = pSUWAppViewBase.getMDCtrlParam();
            xmlNode.setAttribute(FIELD_MDCTRLPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPredefinedViewType() != null) {
            object = pSUWAppViewBase.getPredefinedViewType();
            xmlNode.setAttribute("PREDEFINEDVIEWTYPE", object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSACHandlerId() != null) {
            object = pSUWAppViewBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSACHandlerName() != null) {
            object = pSUWAppViewBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSAppModuleId() != null) {
            object = pSUWAppViewBase.getPSAppModuleId();
            xmlNode.setAttribute(FIELD_PSAPPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSAppModuleName() != null) {
            object = pSUWAppViewBase.getPSAppModuleName();
            xmlNode.setAttribute(FIELD_PSAPPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSAppViewId() != null) {
            object = pSUWAppViewBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSAppViewName() != null) {
            object = pSUWAppViewBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSAppViewType() != null) {
            object = pSUWAppViewBase.getPSAppViewType();
            xmlNode.setAttribute(FIELD_PSAPPVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSCtrlId() != null) {
            object = pSUWAppViewBase.getPSCtrlId();
            xmlNode.setAttribute(FIELD_PSCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSCtrlName() != null) {
            object = pSUWAppViewBase.getPSCtrlName();
            xmlNode.setAttribute(FIELD_PSCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSCtrlTypeId() != null) {
            object = pSUWAppViewBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSCtrlTypeName() != null) {
            object = pSUWAppViewBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEDataSetId() != null) {
            object = pSUWAppViewBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEDataSetName() != null) {
            object = pSUWAppViewBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEDataViewId() != null) {
            object = pSUWAppViewBase.getPSDEDataViewId();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEDataViewName() != null) {
            object = pSUWAppViewBase.getPSDEDataViewName();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEDRId() != null) {
            object = pSUWAppViewBase.getPSDEDRId();
            xmlNode.setAttribute(FIELD_PSDEDRID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEDRName() != null) {
            object = pSUWAppViewBase.getPSDEDRName();
            xmlNode.setAttribute(FIELD_PSDEDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEFormId() != null) {
            object = pSUWAppViewBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEFormName() != null) {
            object = pSUWAppViewBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEGridId() != null) {
            object = pSUWAppViewBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEGridName() != null) {
            object = pSUWAppViewBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEId() != null) {
            object = pSUWAppViewBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEListId() != null) {
            object = pSUWAppViewBase.getPSDEListId();
            xmlNode.setAttribute(FIELD_PSDELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEListName() != null) {
            object = pSUWAppViewBase.getPSDEListName();
            xmlNode.setAttribute(FIELD_PSDELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEName() != null) {
            object = pSUWAppViewBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDESearchFormId() != null) {
            object = pSUWAppViewBase.getPSDESearchFormId();
            xmlNode.setAttribute(FIELD_PSDESEARCHFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDESearchFormName() != null) {
            object = pSUWAppViewBase.getPSDESearchFormName();
            xmlNode.setAttribute(FIELD_PSDESEARCHFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEToolbarId() != null) {
            object = pSUWAppViewBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEToolbarName() != null) {
            object = pSUWAppViewBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEViewBaseId() != null) {
            object = pSUWAppViewBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEViewBaseName() != null) {
            object = pSUWAppViewBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEViewBaseType() != null) {
            object = pSUWAppViewBase.getPSDEViewBaseType();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEViewId() != null) {
            object = pSUWAppViewBase.getPSDEViewId();
            xmlNode.setAttribute(FIELD_PSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDEViewName() != null) {
            object = pSUWAppViewBase.getPSDEViewName();
            xmlNode.setAttribute(FIELD_PSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSDynaInstId() != null) {
            object = pSUWAppViewBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSSFACHandlerId() != null) {
            object = pSUWAppViewBase.getPSSFACHandlerId();
            xmlNode.setAttribute(FIELD_PSSFACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSSFACHandlerName() != null) {
            object = pSUWAppViewBase.getPSSFACHandlerName();
            xmlNode.setAttribute(FIELD_PSSFACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSSysAppId() != null) {
            object = pSUWAppViewBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSUWAppViewId() != null) {
            object = pSUWAppViewBase.getPSUWAppViewId();
            xmlNode.setAttribute(FIELD_PSUWAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getPSUWAppViewName() != null) {
            object = pSUWAppViewBase.getPSUWAppViewName();
            xmlNode.setAttribute(FIELD_PSUWAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getSrcPSDEViewId() != null) {
            object = pSUWAppViewBase.getSrcPSDEViewId();
            xmlNode.setAttribute(FIELD_SRCPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getSrcPSDEViewName() != null) {
            object = pSUWAppViewBase.getSrcPSDEViewName();
            xmlNode.setAttribute(FIELD_SRCPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getSRFNextForm() != null) {
            object = pSUWAppViewBase.getSRFNextForm();
            xmlNode.setAttribute(FIELD_SRFNEXTFORM, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getTitle() != null) {
            object = pSUWAppViewBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getUpdateDate() != null) {
            object = pSUWAppViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAppViewBase.getUpdateMan() != null) {
            object = pSUWAppViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getViewParam() != null) {
            object = pSUWAppViewBase.getViewParam();
            xmlNode.setAttribute(FIELD_VIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getViewParam10() != null) {
            object = pSUWAppViewBase.getViewParam10();
            xmlNode.setAttribute(FIELD_VIEWPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getViewParam2() != null) {
            object = pSUWAppViewBase.getViewParam2();
            xmlNode.setAttribute(FIELD_VIEWPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getViewParam3() != null) {
            object = pSUWAppViewBase.getViewParam3();
            xmlNode.setAttribute(FIELD_VIEWPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getViewParam4() != null) {
            object = pSUWAppViewBase.getViewParam4();
            xmlNode.setAttribute(FIELD_VIEWPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getViewParam5() != null) {
            object = pSUWAppViewBase.getViewParam5();
            xmlNode.setAttribute(FIELD_VIEWPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getViewParam6() != null) {
            object = pSUWAppViewBase.getViewParam6();
            xmlNode.setAttribute(FIELD_VIEWPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getViewParam7() != null) {
            object = pSUWAppViewBase.getViewParam7();
            xmlNode.setAttribute(FIELD_VIEWPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getViewParam8() != null) {
            object = pSUWAppViewBase.getViewParam8();
            xmlNode.setAttribute(FIELD_VIEWPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getViewParam9() != null) {
            object = pSUWAppViewBase.getViewParam9();
            xmlNode.setAttribute(FIELD_VIEWPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardMode() != null) {
            object = pSUWAppViewBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getWizardParam() != null) {
            object = pSUWAppViewBase.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getWizardParam10() != null) {
            object = pSUWAppViewBase.getWizardParam10();
            xmlNode.setAttribute(FIELD_WIZARDPARAM10, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getWizardParam11() != null) {
            object = pSUWAppViewBase.getWizardParam11();
            xmlNode.setAttribute(FIELD_WIZARDPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam12() != null) {
            object = pSUWAppViewBase.getWizardParam12();
            xmlNode.setAttribute(FIELD_WIZARDPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam13() != null) {
            object = pSUWAppViewBase.getWizardParam13();
            xmlNode.setAttribute(FIELD_WIZARDPARAM13, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam14() != null) {
            object = pSUWAppViewBase.getWizardParam14();
            xmlNode.setAttribute(FIELD_WIZARDPARAM14, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam15() != null) {
            object = pSUWAppViewBase.getWizardParam15();
            xmlNode.setAttribute(FIELD_WIZARDPARAM15, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam16() != null) {
            object = pSUWAppViewBase.getWizardParam16();
            xmlNode.setAttribute(FIELD_WIZARDPARAM16, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam17() != null) {
            object = pSUWAppViewBase.getWizardParam17();
            xmlNode.setAttribute(FIELD_WIZARDPARAM17, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam18() != null) {
            object = pSUWAppViewBase.getWizardParam18();
            xmlNode.setAttribute(FIELD_WIZARDPARAM18, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam19() != null) {
            object = pSUWAppViewBase.getWizardParam19();
            xmlNode.setAttribute(FIELD_WIZARDPARAM19, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam2() != null) {
            object = pSUWAppViewBase.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getWizardParam20() != null) {
            object = pSUWAppViewBase.getWizardParam20();
            xmlNode.setAttribute(FIELD_WIZARDPARAM20, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam3() != null) {
            object = pSUWAppViewBase.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam4() != null) {
            object = pSUWAppViewBase.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppViewBase.getWizardParam5() != null) {
            object = pSUWAppViewBase.getWizardParam5();
            xmlNode.setAttribute(FIELD_WIZARDPARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getWizardParam6() != null) {
            object = pSUWAppViewBase.getWizardParam6();
            xmlNode.setAttribute(FIELD_WIZARDPARAM6, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getWizardParam7() != null) {
            object = pSUWAppViewBase.getWizardParam7();
            xmlNode.setAttribute(FIELD_WIZARDPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getWizardParam8() != null) {
            object = pSUWAppViewBase.getWizardParam8();
            xmlNode.setAttribute(FIELD_WIZARDPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppViewBase.getWizardParam9() != null) {
            object = pSUWAppViewBase.getWizardParam9();
            xmlNode.setAttribute(FIELD_WIZARDPARAM9, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWAppViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWAppViewBase pSUWAppViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWAppViewBase.isCaptionDirty() && (bl || pSUWAppViewBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSUWAppViewBase.getCaption());
        }
        if (pSUWAppViewBase.isCodeNameDirty() && (bl || pSUWAppViewBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSUWAppViewBase.getCodeName());
        }
        if (pSUWAppViewBase.isCreateDateDirty() && (bl || pSUWAppViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWAppViewBase.getCreateDate());
        }
        if (pSUWAppViewBase.isCreateManDirty() && (bl || pSUWAppViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWAppViewBase.getCreateMan());
        }
        if (pSUWAppViewBase.isEnableSrcPSDEViewDirty() && (bl || pSUWAppViewBase.getEnableSrcPSDEView() != null)) {
            iDataObject.set(FIELD_ENABLESRCPSDEVIEW, (Object)pSUWAppViewBase.getEnableSrcPSDEView());
        }
        if (pSUWAppViewBase.isListCtrlParamDirty() && (bl || pSUWAppViewBase.getListCtrlParam() != null)) {
            iDataObject.set(FIELD_LISTCTRLPARAM, (Object)pSUWAppViewBase.getListCtrlParam());
        }
        if (pSUWAppViewBase.isLoadDefaultDirty() && (bl || pSUWAppViewBase.getLoadDefault() != null)) {
            iDataObject.set(FIELD_LOADDEFAULT, (Object)pSUWAppViewBase.getLoadDefault());
        }
        if (pSUWAppViewBase.isMDCtrlParamDirty() && (bl || pSUWAppViewBase.getMDCtrlParam() != null)) {
            iDataObject.set(FIELD_MDCTRLPARAM, (Object)pSUWAppViewBase.getMDCtrlParam());
        }
        if (pSUWAppViewBase.isPredefinedViewTypeDirty() && (bl || pSUWAppViewBase.getPredefinedViewType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDVIEWTYPE, (Object)pSUWAppViewBase.getPredefinedViewType());
        }
        if (pSUWAppViewBase.isPSACHandlerIdDirty() && (bl || pSUWAppViewBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSUWAppViewBase.getPSACHandlerId());
        }
        if (pSUWAppViewBase.isPSACHandlerNameDirty() && (bl || pSUWAppViewBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSUWAppViewBase.getPSACHandlerName());
        }
        if (pSUWAppViewBase.isPSAppModuleIdDirty() && (bl || pSUWAppViewBase.getPSAppModuleId() != null)) {
            iDataObject.set(FIELD_PSAPPMODULEID, (Object)pSUWAppViewBase.getPSAppModuleId());
        }
        if (pSUWAppViewBase.isPSAppModuleNameDirty() && (bl || pSUWAppViewBase.getPSAppModuleName() != null)) {
            iDataObject.set(FIELD_PSAPPMODULENAME, (Object)pSUWAppViewBase.getPSAppModuleName());
        }
        if (pSUWAppViewBase.isPSAppViewIdDirty() && (bl || pSUWAppViewBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSUWAppViewBase.getPSAppViewId());
        }
        if (pSUWAppViewBase.isPSAppViewNameDirty() && (bl || pSUWAppViewBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSUWAppViewBase.getPSAppViewName());
        }
        if (pSUWAppViewBase.isPSAppViewTypeDirty() && (bl || pSUWAppViewBase.getPSAppViewType() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWTYPE, (Object)pSUWAppViewBase.getPSAppViewType());
        }
        if (pSUWAppViewBase.isPSCtrlIdDirty() && (bl || pSUWAppViewBase.getPSCtrlId() != null)) {
            iDataObject.set(FIELD_PSCTRLID, (Object)pSUWAppViewBase.getPSCtrlId());
        }
        if (pSUWAppViewBase.isPSCtrlNameDirty() && (bl || pSUWAppViewBase.getPSCtrlName() != null)) {
            iDataObject.set(FIELD_PSCTRLNAME, (Object)pSUWAppViewBase.getPSCtrlName());
        }
        if (pSUWAppViewBase.isPSCtrlTypeIdDirty() && (bl || pSUWAppViewBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSUWAppViewBase.getPSCtrlTypeId());
        }
        if (pSUWAppViewBase.isPSCtrlTypeNameDirty() && (bl || pSUWAppViewBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSUWAppViewBase.getPSCtrlTypeName());
        }
        if (pSUWAppViewBase.isPSDEDataSetIdDirty() && (bl || pSUWAppViewBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSUWAppViewBase.getPSDEDataSetId());
        }
        if (pSUWAppViewBase.isPSDEDataSetNameDirty() && (bl || pSUWAppViewBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSUWAppViewBase.getPSDEDataSetName());
        }
        if (pSUWAppViewBase.isPSDEDataViewIdDirty() && (bl || pSUWAppViewBase.getPSDEDataViewId() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWID, (Object)pSUWAppViewBase.getPSDEDataViewId());
        }
        if (pSUWAppViewBase.isPSDEDataViewNameDirty() && (bl || pSUWAppViewBase.getPSDEDataViewName() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWNAME, (Object)pSUWAppViewBase.getPSDEDataViewName());
        }
        if (pSUWAppViewBase.isPSDEDRIdDirty() && (bl || pSUWAppViewBase.getPSDEDRId() != null)) {
            iDataObject.set(FIELD_PSDEDRID, (Object)pSUWAppViewBase.getPSDEDRId());
        }
        if (pSUWAppViewBase.isPSDEDRNameDirty() && (bl || pSUWAppViewBase.getPSDEDRName() != null)) {
            iDataObject.set(FIELD_PSDEDRNAME, (Object)pSUWAppViewBase.getPSDEDRName());
        }
        if (pSUWAppViewBase.isPSDEFormIdDirty() && (bl || pSUWAppViewBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSUWAppViewBase.getPSDEFormId());
        }
        if (pSUWAppViewBase.isPSDEFormNameDirty() && (bl || pSUWAppViewBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSUWAppViewBase.getPSDEFormName());
        }
        if (pSUWAppViewBase.isPSDEGridIdDirty() && (bl || pSUWAppViewBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSUWAppViewBase.getPSDEGridId());
        }
        if (pSUWAppViewBase.isPSDEGridNameDirty() && (bl || pSUWAppViewBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSUWAppViewBase.getPSDEGridName());
        }
        if (pSUWAppViewBase.isPSDEIdDirty() && (bl || pSUWAppViewBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWAppViewBase.getPSDEId());
        }
        if (pSUWAppViewBase.isPSDEListIdDirty() && (bl || pSUWAppViewBase.getPSDEListId() != null)) {
            iDataObject.set(FIELD_PSDELISTID, (Object)pSUWAppViewBase.getPSDEListId());
        }
        if (pSUWAppViewBase.isPSDEListNameDirty() && (bl || pSUWAppViewBase.getPSDEListName() != null)) {
            iDataObject.set(FIELD_PSDELISTNAME, (Object)pSUWAppViewBase.getPSDEListName());
        }
        if (pSUWAppViewBase.isPSDENameDirty() && (bl || pSUWAppViewBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSUWAppViewBase.getPSDEName());
        }
        if (pSUWAppViewBase.isPSDESearchFormIdDirty() && (bl || pSUWAppViewBase.getPSDESearchFormId() != null)) {
            iDataObject.set(FIELD_PSDESEARCHFORMID, (Object)pSUWAppViewBase.getPSDESearchFormId());
        }
        if (pSUWAppViewBase.isPSDESearchFormNameDirty() && (bl || pSUWAppViewBase.getPSDESearchFormName() != null)) {
            iDataObject.set(FIELD_PSDESEARCHFORMNAME, (Object)pSUWAppViewBase.getPSDESearchFormName());
        }
        if (pSUWAppViewBase.isPSDEToolbarIdDirty() && (bl || pSUWAppViewBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSUWAppViewBase.getPSDEToolbarId());
        }
        if (pSUWAppViewBase.isPSDEToolbarNameDirty() && (bl || pSUWAppViewBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSUWAppViewBase.getPSDEToolbarName());
        }
        if (pSUWAppViewBase.isPSDEViewBaseIdDirty() && (bl || pSUWAppViewBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSUWAppViewBase.getPSDEViewBaseId());
        }
        if (pSUWAppViewBase.isPSDEViewBaseNameDirty() && (bl || pSUWAppViewBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSUWAppViewBase.getPSDEViewBaseName());
        }
        if (pSUWAppViewBase.isPSDEViewBaseTypeDirty() && (bl || pSUWAppViewBase.getPSDEViewBaseType() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASETYPE, (Object)pSUWAppViewBase.getPSDEViewBaseType());
        }
        if (pSUWAppViewBase.isPSDEViewIdDirty() && (bl || pSUWAppViewBase.getPSDEViewId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWID, (Object)pSUWAppViewBase.getPSDEViewId());
        }
        if (pSUWAppViewBase.isPSDEViewNameDirty() && (bl || pSUWAppViewBase.getPSDEViewName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWNAME, (Object)pSUWAppViewBase.getPSDEViewName());
        }
        if (pSUWAppViewBase.isPSDynaInstIdDirty() && (bl || pSUWAppViewBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWAppViewBase.getPSDynaInstId());
        }
        if (pSUWAppViewBase.isPSSFACHandlerIdDirty() && (bl || pSUWAppViewBase.getPSSFACHandlerId() != null)) {
            iDataObject.set(FIELD_PSSFACHANDLERID, (Object)pSUWAppViewBase.getPSSFACHandlerId());
        }
        if (pSUWAppViewBase.isPSSFACHandlerNameDirty() && (bl || pSUWAppViewBase.getPSSFACHandlerName() != null)) {
            iDataObject.set(FIELD_PSSFACHANDLERNAME, (Object)pSUWAppViewBase.getPSSFACHandlerName());
        }
        if (pSUWAppViewBase.isPSSysAppIdDirty() && (bl || pSUWAppViewBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSUWAppViewBase.getPSSysAppId());
        }
        if (pSUWAppViewBase.isPSUWAppViewIdDirty() && (bl || pSUWAppViewBase.getPSUWAppViewId() != null)) {
            iDataObject.set(FIELD_PSUWAPPVIEWID, (Object)pSUWAppViewBase.getPSUWAppViewId());
        }
        if (pSUWAppViewBase.isPSUWAppViewNameDirty() && (bl || pSUWAppViewBase.getPSUWAppViewName() != null)) {
            iDataObject.set(FIELD_PSUWAPPVIEWNAME, (Object)pSUWAppViewBase.getPSUWAppViewName());
        }
        if (pSUWAppViewBase.isSrcPSDEViewIdDirty() && (bl || pSUWAppViewBase.getSrcPSDEViewId() != null)) {
            iDataObject.set(FIELD_SRCPSDEVIEWID, (Object)pSUWAppViewBase.getSrcPSDEViewId());
        }
        if (pSUWAppViewBase.isSrcPSDEViewNameDirty() && (bl || pSUWAppViewBase.getSrcPSDEViewName() != null)) {
            iDataObject.set(FIELD_SRCPSDEVIEWNAME, (Object)pSUWAppViewBase.getSrcPSDEViewName());
        }
        if (pSUWAppViewBase.isSRFNextFormDirty() && (bl || pSUWAppViewBase.getSRFNextForm() != null)) {
            iDataObject.set(FIELD_SRFNEXTFORM, (Object)pSUWAppViewBase.getSRFNextForm());
        }
        if (pSUWAppViewBase.isTitleDirty() && (bl || pSUWAppViewBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSUWAppViewBase.getTitle());
        }
        if (pSUWAppViewBase.isUpdateDateDirty() && (bl || pSUWAppViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWAppViewBase.getUpdateDate());
        }
        if (pSUWAppViewBase.isUpdateManDirty() && (bl || pSUWAppViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWAppViewBase.getUpdateMan());
        }
        if (pSUWAppViewBase.isViewParamDirty() && (bl || pSUWAppViewBase.getViewParam() != null)) {
            iDataObject.set(FIELD_VIEWPARAM, (Object)pSUWAppViewBase.getViewParam());
        }
        if (pSUWAppViewBase.isViewParam10Dirty() && (bl || pSUWAppViewBase.getViewParam10() != null)) {
            iDataObject.set(FIELD_VIEWPARAM10, (Object)pSUWAppViewBase.getViewParam10());
        }
        if (pSUWAppViewBase.isViewParam2Dirty() && (bl || pSUWAppViewBase.getViewParam2() != null)) {
            iDataObject.set(FIELD_VIEWPARAM2, (Object)pSUWAppViewBase.getViewParam2());
        }
        if (pSUWAppViewBase.isViewParam3Dirty() && (bl || pSUWAppViewBase.getViewParam3() != null)) {
            iDataObject.set(FIELD_VIEWPARAM3, (Object)pSUWAppViewBase.getViewParam3());
        }
        if (pSUWAppViewBase.isViewParam4Dirty() && (bl || pSUWAppViewBase.getViewParam4() != null)) {
            iDataObject.set(FIELD_VIEWPARAM4, (Object)pSUWAppViewBase.getViewParam4());
        }
        if (pSUWAppViewBase.isViewParam5Dirty() && (bl || pSUWAppViewBase.getViewParam5() != null)) {
            iDataObject.set(FIELD_VIEWPARAM5, (Object)pSUWAppViewBase.getViewParam5());
        }
        if (pSUWAppViewBase.isViewParam6Dirty() && (bl || pSUWAppViewBase.getViewParam6() != null)) {
            iDataObject.set(FIELD_VIEWPARAM6, (Object)pSUWAppViewBase.getViewParam6());
        }
        if (pSUWAppViewBase.isViewParam7Dirty() && (bl || pSUWAppViewBase.getViewParam7() != null)) {
            iDataObject.set(FIELD_VIEWPARAM7, (Object)pSUWAppViewBase.getViewParam7());
        }
        if (pSUWAppViewBase.isViewParam8Dirty() && (bl || pSUWAppViewBase.getViewParam8() != null)) {
            iDataObject.set(FIELD_VIEWPARAM8, (Object)pSUWAppViewBase.getViewParam8());
        }
        if (pSUWAppViewBase.isViewParam9Dirty() && (bl || pSUWAppViewBase.getViewParam9() != null)) {
            iDataObject.set(FIELD_VIEWPARAM9, (Object)pSUWAppViewBase.getViewParam9());
        }
        if (pSUWAppViewBase.isWizardModeDirty() && (bl || pSUWAppViewBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWAppViewBase.getWizardMode());
        }
        if (pSUWAppViewBase.isWizardParamDirty() && (bl || pSUWAppViewBase.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSUWAppViewBase.getWizardParam());
        }
        if (pSUWAppViewBase.isWizardParam10Dirty() && (bl || pSUWAppViewBase.getWizardParam10() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM10, (Object)pSUWAppViewBase.getWizardParam10());
        }
        if (pSUWAppViewBase.isWizardParam11Dirty() && (bl || pSUWAppViewBase.getWizardParam11() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM11, (Object)pSUWAppViewBase.getWizardParam11());
        }
        if (pSUWAppViewBase.isWizardParam12Dirty() && (bl || pSUWAppViewBase.getWizardParam12() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM12, (Object)pSUWAppViewBase.getWizardParam12());
        }
        if (pSUWAppViewBase.isWizardParam13Dirty() && (bl || pSUWAppViewBase.getWizardParam13() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM13, (Object)pSUWAppViewBase.getWizardParam13());
        }
        if (pSUWAppViewBase.isWizardParam14Dirty() && (bl || pSUWAppViewBase.getWizardParam14() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM14, (Object)pSUWAppViewBase.getWizardParam14());
        }
        if (pSUWAppViewBase.isWizardParam15Dirty() && (bl || pSUWAppViewBase.getWizardParam15() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM15, (Object)pSUWAppViewBase.getWizardParam15());
        }
        if (pSUWAppViewBase.isWizardParam16Dirty() && (bl || pSUWAppViewBase.getWizardParam16() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM16, (Object)pSUWAppViewBase.getWizardParam16());
        }
        if (pSUWAppViewBase.isWizardParam17Dirty() && (bl || pSUWAppViewBase.getWizardParam17() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM17, (Object)pSUWAppViewBase.getWizardParam17());
        }
        if (pSUWAppViewBase.isWizardParam18Dirty() && (bl || pSUWAppViewBase.getWizardParam18() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM18, (Object)pSUWAppViewBase.getWizardParam18());
        }
        if (pSUWAppViewBase.isWizardParam19Dirty() && (bl || pSUWAppViewBase.getWizardParam19() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM19, (Object)pSUWAppViewBase.getWizardParam19());
        }
        if (pSUWAppViewBase.isWizardParam2Dirty() && (bl || pSUWAppViewBase.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSUWAppViewBase.getWizardParam2());
        }
        if (pSUWAppViewBase.isWizardParam20Dirty() && (bl || pSUWAppViewBase.getWizardParam20() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM20, (Object)pSUWAppViewBase.getWizardParam20());
        }
        if (pSUWAppViewBase.isWizardParam3Dirty() && (bl || pSUWAppViewBase.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSUWAppViewBase.getWizardParam3());
        }
        if (pSUWAppViewBase.isWizardParam4Dirty() && (bl || pSUWAppViewBase.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSUWAppViewBase.getWizardParam4());
        }
        if (pSUWAppViewBase.isWizardParam5Dirty() && (bl || pSUWAppViewBase.getWizardParam5() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM5, (Object)pSUWAppViewBase.getWizardParam5());
        }
        if (pSUWAppViewBase.isWizardParam6Dirty() && (bl || pSUWAppViewBase.getWizardParam6() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM6, (Object)pSUWAppViewBase.getWizardParam6());
        }
        if (pSUWAppViewBase.isWizardParam7Dirty() && (bl || pSUWAppViewBase.getWizardParam7() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM7, (Object)pSUWAppViewBase.getWizardParam7());
        }
        if (pSUWAppViewBase.isWizardParam8Dirty() && (bl || pSUWAppViewBase.getWizardParam8() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM8, (Object)pSUWAppViewBase.getWizardParam8());
        }
        if (pSUWAppViewBase.isWizardParam9Dirty() && (bl || pSUWAppViewBase.getWizardParam9() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM9, (Object)pSUWAppViewBase.getWizardParam9());
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
        return PSUWAppViewBase.remove(this, n);
    }

    private static boolean remove(PSUWAppViewBase pSUWAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWAppViewBase.resetCaption();
                return true;
            }
            case 1: {
                pSUWAppViewBase.resetCodeName();
                return true;
            }
            case 2: {
                pSUWAppViewBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSUWAppViewBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSUWAppViewBase.resetEnableSrcPSDEView();
                return true;
            }
            case 5: {
                pSUWAppViewBase.resetListCtrlParam();
                return true;
            }
            case 6: {
                pSUWAppViewBase.resetLoadDefault();
                return true;
            }
            case 7: {
                pSUWAppViewBase.resetMDCtrlParam();
                return true;
            }
            case 8: {
                pSUWAppViewBase.resetPredefinedViewType();
                return true;
            }
            case 9: {
                pSUWAppViewBase.resetPSACHandlerId();
                return true;
            }
            case 10: {
                pSUWAppViewBase.resetPSACHandlerName();
                return true;
            }
            case 11: {
                pSUWAppViewBase.resetPSAppModuleId();
                return true;
            }
            case 12: {
                pSUWAppViewBase.resetPSAppModuleName();
                return true;
            }
            case 13: {
                pSUWAppViewBase.resetPSAppViewId();
                return true;
            }
            case 14: {
                pSUWAppViewBase.resetPSAppViewName();
                return true;
            }
            case 15: {
                pSUWAppViewBase.resetPSAppViewType();
                return true;
            }
            case 16: {
                pSUWAppViewBase.resetPSCtrlId();
                return true;
            }
            case 17: {
                pSUWAppViewBase.resetPSCtrlName();
                return true;
            }
            case 18: {
                pSUWAppViewBase.resetPSCtrlTypeId();
                return true;
            }
            case 19: {
                pSUWAppViewBase.resetPSCtrlTypeName();
                return true;
            }
            case 20: {
                pSUWAppViewBase.resetPSDEDataSetId();
                return true;
            }
            case 21: {
                pSUWAppViewBase.resetPSDEDataSetName();
                return true;
            }
            case 22: {
                pSUWAppViewBase.resetPSDEDataViewId();
                return true;
            }
            case 23: {
                pSUWAppViewBase.resetPSDEDataViewName();
                return true;
            }
            case 24: {
                pSUWAppViewBase.resetPSDEDRId();
                return true;
            }
            case 25: {
                pSUWAppViewBase.resetPSDEDRName();
                return true;
            }
            case 26: {
                pSUWAppViewBase.resetPSDEFormId();
                return true;
            }
            case 27: {
                pSUWAppViewBase.resetPSDEFormName();
                return true;
            }
            case 28: {
                pSUWAppViewBase.resetPSDEGridId();
                return true;
            }
            case 29: {
                pSUWAppViewBase.resetPSDEGridName();
                return true;
            }
            case 30: {
                pSUWAppViewBase.resetPSDEId();
                return true;
            }
            case 31: {
                pSUWAppViewBase.resetPSDEListId();
                return true;
            }
            case 32: {
                pSUWAppViewBase.resetPSDEListName();
                return true;
            }
            case 33: {
                pSUWAppViewBase.resetPSDEName();
                return true;
            }
            case 34: {
                pSUWAppViewBase.resetPSDESearchFormId();
                return true;
            }
            case 35: {
                pSUWAppViewBase.resetPSDESearchFormName();
                return true;
            }
            case 36: {
                pSUWAppViewBase.resetPSDEToolbarId();
                return true;
            }
            case 37: {
                pSUWAppViewBase.resetPSDEToolbarName();
                return true;
            }
            case 38: {
                pSUWAppViewBase.resetPSDEViewBaseId();
                return true;
            }
            case 39: {
                pSUWAppViewBase.resetPSDEViewBaseName();
                return true;
            }
            case 40: {
                pSUWAppViewBase.resetPSDEViewBaseType();
                return true;
            }
            case 41: {
                pSUWAppViewBase.resetPSDEViewId();
                return true;
            }
            case 42: {
                pSUWAppViewBase.resetPSDEViewName();
                return true;
            }
            case 43: {
                pSUWAppViewBase.resetPSDynaInstId();
                return true;
            }
            case 44: {
                pSUWAppViewBase.resetPSSFACHandlerId();
                return true;
            }
            case 45: {
                pSUWAppViewBase.resetPSSFACHandlerName();
                return true;
            }
            case 46: {
                pSUWAppViewBase.resetPSSysAppId();
                return true;
            }
            case 47: {
                pSUWAppViewBase.resetPSUWAppViewId();
                return true;
            }
            case 48: {
                pSUWAppViewBase.resetPSUWAppViewName();
                return true;
            }
            case 49: {
                pSUWAppViewBase.resetSrcPSDEViewId();
                return true;
            }
            case 50: {
                pSUWAppViewBase.resetSrcPSDEViewName();
                return true;
            }
            case 51: {
                pSUWAppViewBase.resetSRFNextForm();
                return true;
            }
            case 52: {
                pSUWAppViewBase.resetTitle();
                return true;
            }
            case 53: {
                pSUWAppViewBase.resetUpdateDate();
                return true;
            }
            case 54: {
                pSUWAppViewBase.resetUpdateMan();
                return true;
            }
            case 55: {
                pSUWAppViewBase.resetViewParam();
                return true;
            }
            case 56: {
                pSUWAppViewBase.resetViewParam10();
                return true;
            }
            case 57: {
                pSUWAppViewBase.resetViewParam2();
                return true;
            }
            case 58: {
                pSUWAppViewBase.resetViewParam3();
                return true;
            }
            case 59: {
                pSUWAppViewBase.resetViewParam4();
                return true;
            }
            case 60: {
                pSUWAppViewBase.resetViewParam5();
                return true;
            }
            case 61: {
                pSUWAppViewBase.resetViewParam6();
                return true;
            }
            case 62: {
                pSUWAppViewBase.resetViewParam7();
                return true;
            }
            case 63: {
                pSUWAppViewBase.resetViewParam8();
                return true;
            }
            case 64: {
                pSUWAppViewBase.resetViewParam9();
                return true;
            }
            case 65: {
                pSUWAppViewBase.resetWizardMode();
                return true;
            }
            case 66: {
                pSUWAppViewBase.resetWizardParam();
                return true;
            }
            case 67: {
                pSUWAppViewBase.resetWizardParam10();
                return true;
            }
            case 68: {
                pSUWAppViewBase.resetWizardParam11();
                return true;
            }
            case 69: {
                pSUWAppViewBase.resetWizardParam12();
                return true;
            }
            case 70: {
                pSUWAppViewBase.resetWizardParam13();
                return true;
            }
            case 71: {
                pSUWAppViewBase.resetWizardParam14();
                return true;
            }
            case 72: {
                pSUWAppViewBase.resetWizardParam15();
                return true;
            }
            case 73: {
                pSUWAppViewBase.resetWizardParam16();
                return true;
            }
            case 74: {
                pSUWAppViewBase.resetWizardParam17();
                return true;
            }
            case 75: {
                pSUWAppViewBase.resetWizardParam18();
                return true;
            }
            case 76: {
                pSUWAppViewBase.resetWizardParam19();
                return true;
            }
            case 77: {
                pSUWAppViewBase.resetWizardParam2();
                return true;
            }
            case 78: {
                pSUWAppViewBase.resetWizardParam20();
                return true;
            }
            case 79: {
                pSUWAppViewBase.resetWizardParam3();
                return true;
            }
            case 80: {
                pSUWAppViewBase.resetWizardParam4();
                return true;
            }
            case 81: {
                pSUWAppViewBase.resetWizardParam5();
                return true;
            }
            case 82: {
                pSUWAppViewBase.resetWizardParam6();
                return true;
            }
            case 83: {
                pSUWAppViewBase.resetWizardParam7();
                return true;
            }
            case 84: {
                pSUWAppViewBase.resetWizardParam8();
                return true;
            }
            case 85: {
                pSUWAppViewBase.resetWizardParam9();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWAppViewBase getProxyEntity() {
        return this.proxyPSUWAppViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWAppViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWAppViewBase) {
            this.proxyPSUWAppViewBase = (PSUWAppViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWAppViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPTION, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENABLESRCPSDEVIEW, 4);
        fieldIndexMap.put(FIELD_LISTCTRLPARAM, 5);
        fieldIndexMap.put(FIELD_LOADDEFAULT, 6);
        fieldIndexMap.put(FIELD_MDCTRLPARAM, 7);
        fieldIndexMap.put(FIELD_PREDEFINEDVIEWTYPE, 8);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 9);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 10);
        fieldIndexMap.put(FIELD_PSAPPMODULEID, 11);
        fieldIndexMap.put(FIELD_PSAPPMODULENAME, 12);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 13);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 14);
        fieldIndexMap.put(FIELD_PSAPPVIEWTYPE, 15);
        fieldIndexMap.put(FIELD_PSCTRLID, 16);
        fieldIndexMap.put(FIELD_PSCTRLNAME, 17);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 18);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 19);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 20);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 21);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWID, 22);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWNAME, 23);
        fieldIndexMap.put(FIELD_PSDEDRID, 24);
        fieldIndexMap.put(FIELD_PSDEDRNAME, 25);
        fieldIndexMap.put(FIELD_PSDEFORMID, 26);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 27);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 28);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 29);
        fieldIndexMap.put(FIELD_PSDEID, 30);
        fieldIndexMap.put(FIELD_PSDELISTID, 31);
        fieldIndexMap.put(FIELD_PSDELISTNAME, 32);
        fieldIndexMap.put(FIELD_PSDENAME, 33);
        fieldIndexMap.put(FIELD_PSDESEARCHFORMID, 34);
        fieldIndexMap.put(FIELD_PSDESEARCHFORMNAME, 35);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 36);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 37);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 38);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 39);
        fieldIndexMap.put(FIELD_PSDEVIEWBASETYPE, 40);
        fieldIndexMap.put(FIELD_PSDEVIEWID, 41);
        fieldIndexMap.put(FIELD_PSDEVIEWNAME, 42);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 43);
        fieldIndexMap.put(FIELD_PSSFACHANDLERID, 44);
        fieldIndexMap.put(FIELD_PSSFACHANDLERNAME, 45);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 46);
        fieldIndexMap.put(FIELD_PSUWAPPVIEWID, 47);
        fieldIndexMap.put(FIELD_PSUWAPPVIEWNAME, 48);
        fieldIndexMap.put(FIELD_SRCPSDEVIEWID, 49);
        fieldIndexMap.put(FIELD_SRCPSDEVIEWNAME, 50);
        fieldIndexMap.put(FIELD_SRFNEXTFORM, 51);
        fieldIndexMap.put(FIELD_TITLE, 52);
        fieldIndexMap.put(FIELD_UPDATEDATE, 53);
        fieldIndexMap.put(FIELD_UPDATEMAN, 54);
        fieldIndexMap.put(FIELD_VIEWPARAM, 55);
        fieldIndexMap.put(FIELD_VIEWPARAM10, 56);
        fieldIndexMap.put(FIELD_VIEWPARAM2, 57);
        fieldIndexMap.put(FIELD_VIEWPARAM3, 58);
        fieldIndexMap.put(FIELD_VIEWPARAM4, 59);
        fieldIndexMap.put(FIELD_VIEWPARAM5, 60);
        fieldIndexMap.put(FIELD_VIEWPARAM6, 61);
        fieldIndexMap.put(FIELD_VIEWPARAM7, 62);
        fieldIndexMap.put(FIELD_VIEWPARAM8, 63);
        fieldIndexMap.put(FIELD_VIEWPARAM9, 64);
        fieldIndexMap.put(FIELD_WIZARDMODE, 65);
        fieldIndexMap.put(FIELD_WIZARDPARAM, 66);
        fieldIndexMap.put(FIELD_WIZARDPARAM10, 67);
        fieldIndexMap.put(FIELD_WIZARDPARAM11, 68);
        fieldIndexMap.put(FIELD_WIZARDPARAM12, 69);
        fieldIndexMap.put(FIELD_WIZARDPARAM13, 70);
        fieldIndexMap.put(FIELD_WIZARDPARAM14, 71);
        fieldIndexMap.put(FIELD_WIZARDPARAM15, 72);
        fieldIndexMap.put(FIELD_WIZARDPARAM16, 73);
        fieldIndexMap.put(FIELD_WIZARDPARAM17, 74);
        fieldIndexMap.put(FIELD_WIZARDPARAM18, 75);
        fieldIndexMap.put(FIELD_WIZARDPARAM19, 76);
        fieldIndexMap.put(FIELD_WIZARDPARAM2, 77);
        fieldIndexMap.put(FIELD_WIZARDPARAM20, 78);
        fieldIndexMap.put(FIELD_WIZARDPARAM3, 79);
        fieldIndexMap.put(FIELD_WIZARDPARAM4, 80);
        fieldIndexMap.put(FIELD_WIZARDPARAM5, 81);
        fieldIndexMap.put(FIELD_WIZARDPARAM6, 82);
        fieldIndexMap.put(FIELD_WIZARDPARAM7, 83);
        fieldIndexMap.put(FIELD_WIZARDPARAM8, 84);
        fieldIndexMap.put(FIELD_WIZARDPARAM9, 85);
    }
}

