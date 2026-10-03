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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioPlugin;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSStudioPluginDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSStudioPluginDataBase.class);
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_ACTIONPARAM10 = "ACTIONPARAM10";
    public static final String FIELD_ACTIONPARAM11 = "ACTIONPARAM11";
    public static final String FIELD_ACTIONPARAM12 = "ACTIONPARAM12";
    public static final String FIELD_ACTIONPARAM13 = "ACTIONPARAM13";
    public static final String FIELD_ACTIONPARAM14 = "ACTIONPARAM14";
    public static final String FIELD_ACTIONPARAM15 = "ACTIONPARAM15";
    public static final String FIELD_ACTIONPARAM16 = "ACTIONPARAM16";
    public static final String FIELD_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String FIELD_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String FIELD_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String FIELD_ACTIONPARAM5 = "ACTIONPARAM5";
    public static final String FIELD_ACTIONPARAM6 = "ACTIONPARAM6";
    public static final String FIELD_ACTIONPARAM7 = "ACTIONPARAM7";
    public static final String FIELD_ACTIONPARAM8 = "ACTIONPARAM8";
    public static final String FIELD_ACTIONPARAM9 = "ACTIONPARAM9";
    public static final String FIELD_ACTIONRESULT = "ACTIONRESULT";
    public static final String FIELD_ACTIONSTATE = "ACTIONSTATE";
    public static final String FIELD_ACTIONTYPE = "ACTIONTYPE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOWNLOADURL = "DOWNLOADURL";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_FULLRESULTINFO = "FULLRESULTINFO";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSSTUDIOPLUGINID = "PPSSTUDIOPLUGINID";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String FIELD_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSTUDIOPLUGINDATAID = "PSSTUDIOPLUGINDATAID";
    public static final String FIELD_PSSTUDIOPLUGINDATANAME = "PSSTUDIOPLUGINDATANAME";
    public static final String FIELD_PSSTUDIOPLUGINID = "PSSTUDIOPLUGINID";
    public static final String FIELD_PSSTUDIOPLUGINNAME = "PSSTUDIOPLUGINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACTIONPARAM = 0;
    private static final int INDEX_ACTIONPARAM10 = 1;
    private static final int INDEX_ACTIONPARAM11 = 2;
    private static final int INDEX_ACTIONPARAM12 = 3;
    private static final int INDEX_ACTIONPARAM13 = 4;
    private static final int INDEX_ACTIONPARAM14 = 5;
    private static final int INDEX_ACTIONPARAM15 = 6;
    private static final int INDEX_ACTIONPARAM16 = 7;
    private static final int INDEX_ACTIONPARAM2 = 8;
    private static final int INDEX_ACTIONPARAM3 = 9;
    private static final int INDEX_ACTIONPARAM4 = 10;
    private static final int INDEX_ACTIONPARAM5 = 11;
    private static final int INDEX_ACTIONPARAM6 = 12;
    private static final int INDEX_ACTIONPARAM7 = 13;
    private static final int INDEX_ACTIONPARAM8 = 14;
    private static final int INDEX_ACTIONPARAM9 = 15;
    private static final int INDEX_ACTIONRESULT = 16;
    private static final int INDEX_ACTIONSTATE = 17;
    private static final int INDEX_ACTIONTYPE = 18;
    private static final int INDEX_BEGINTIME = 19;
    private static final int INDEX_CREATEDATE = 20;
    private static final int INDEX_CREATEMAN = 21;
    private static final int INDEX_DOWNLOADURL = 22;
    private static final int INDEX_ENDTIME = 23;
    private static final int INDEX_FULLRESULTINFO = 24;
    private static final int INDEX_MEMO = 25;
    private static final int INDEX_PPSSTUDIOPLUGINID = 26;
    private static final int INDEX_PSDEVCENTERID = 27;
    private static final int INDEX_PSDEVCENTERNAME = 28;
    private static final int INDEX_PSDEVSLNID = 29;
    private static final int INDEX_PSDEVSLNNAME = 30;
    private static final int INDEX_PSDEVSLNSYSID = 31;
    private static final int INDEX_PSDEVSLNSYSNAME = 32;
    private static final int INDEX_PSDEVSLNTEMPLID = 33;
    private static final int INDEX_PSDEVSLNTEMPLNAME = 34;
    private static final int INDEX_PSOBJID = 35;
    private static final int INDEX_PSOBJNAME = 36;
    private static final int INDEX_PSOBJTYPE = 37;
    private static final int INDEX_PSSTUDIOPLUGINDATAID = 38;
    private static final int INDEX_PSSTUDIOPLUGINDATANAME = 39;
    private static final int INDEX_PSSTUDIOPLUGINID = 40;
    private static final int INDEX_PSSTUDIOPLUGINNAME = 41;
    private static final int INDEX_UPDATEDATE = 42;
    private static final int INDEX_UPDATEMAN = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSStudioPluginDataBase proxyPSStudioPluginDataBase = null;
    private boolean actionparamDirtyFlag = false;
    private boolean actionparam10DirtyFlag = false;
    private boolean actionparam11DirtyFlag = false;
    private boolean actionparam12DirtyFlag = false;
    private boolean actionparam13DirtyFlag = false;
    private boolean actionparam14DirtyFlag = false;
    private boolean actionparam15DirtyFlag = false;
    private boolean actionparam16DirtyFlag = false;
    private boolean actionparam2DirtyFlag = false;
    private boolean actionparam3DirtyFlag = false;
    private boolean actionparam4DirtyFlag = false;
    private boolean actionparam5DirtyFlag = false;
    private boolean actionparam6DirtyFlag = false;
    private boolean actionparam7DirtyFlag = false;
    private boolean actionparam8DirtyFlag = false;
    private boolean actionparam9DirtyFlag = false;
    private boolean actionresultDirtyFlag = false;
    private boolean actionstateDirtyFlag = false;
    private boolean actiontypeDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean downloadurlDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean fullresultinfoDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsstudiopluginidDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslntemplidDirtyFlag = false;
    private boolean psdevslntemplnameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean psstudioplugindataidDirtyFlag = false;
    private boolean psstudioplugindatanameDirtyFlag = false;
    private boolean psstudiopluginidDirtyFlag = false;
    private boolean psstudiopluginnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="actionparam")
    private String actionparam;
    @Column(name="actionparam10")
    private String actionparam10;
    @Column(name="actionparam11")
    private String actionparam11;
    @Column(name="actionparam12")
    private String actionparam12;
    @Column(name="actionparam13")
    private String actionparam13;
    @Column(name="actionparam14")
    private String actionparam14;
    @Column(name="actionparam15")
    private String actionparam15;
    @Column(name="actionparam16")
    private String actionparam16;
    @Column(name="actionparam2")
    private String actionparam2;
    @Column(name="actionparam3")
    private String actionparam3;
    @Column(name="actionparam4")
    private String actionparam4;
    @Column(name="actionparam5")
    private Integer actionparam5;
    @Column(name="actionparam6")
    private Integer actionparam6;
    @Column(name="actionparam7")
    private String actionparam7;
    @Column(name="actionparam8")
    private String actionparam8;
    @Column(name="actionparam9")
    private String actionparam9;
    @Column(name="actionresult")
    private String actionresult;
    @Column(name="actionstate")
    private Integer actionstate;
    @Column(name="actiontype")
    private String actiontype;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="downloadurl")
    private String downloadurl;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="fullresultinfo")
    private String fullresultinfo;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsstudiopluginid")
    private String ppsstudiopluginid;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslntemplid")
    private String psdevslntemplid;
    @Column(name="psdevslntemplname")
    private String psdevslntemplname;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="psstudioplugindataid")
    private String psstudioplugindataid;
    @Column(name="psstudioplugindataname")
    private String psstudioplugindataname;
    @Column(name="psstudiopluginid")
    private String psstudiopluginid;
    @Column(name="psstudiopluginname")
    private String psstudiopluginname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSStudioPluginLock = new Integer(1);
    private PSStudioPlugin psstudioplugin = null;

    public void setActionParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam = string;
        this.actionparamDirtyFlag = true;
    }

    public String getActionParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam();
        }
        return this.actionparam;
    }

    public boolean isActionParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamDirty();
        }
        return this.actionparamDirtyFlag;
    }

    public void resetActionParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam();
            return;
        }
        this.actionparamDirtyFlag = false;
        this.actionparam = null;
    }

    public void setActionParam10(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam10(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam10 = string;
        this.actionparam10DirtyFlag = true;
    }

    public String getActionParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam10();
        }
        return this.actionparam10;
    }

    public boolean isActionParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam10Dirty();
        }
        return this.actionparam10DirtyFlag;
    }

    public void resetActionParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam10();
            return;
        }
        this.actionparam10DirtyFlag = false;
        this.actionparam10 = null;
    }

    public void setActionParam11(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam11(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam11 = string;
        this.actionparam11DirtyFlag = true;
    }

    public String getActionParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam11();
        }
        return this.actionparam11;
    }

    public boolean isActionParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam11Dirty();
        }
        return this.actionparam11DirtyFlag;
    }

    public void resetActionParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam11();
            return;
        }
        this.actionparam11DirtyFlag = false;
        this.actionparam11 = null;
    }

    public void setActionParam12(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam12(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam12 = string;
        this.actionparam12DirtyFlag = true;
    }

    public String getActionParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam12();
        }
        return this.actionparam12;
    }

    public boolean isActionParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam12Dirty();
        }
        return this.actionparam12DirtyFlag;
    }

    public void resetActionParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam12();
            return;
        }
        this.actionparam12DirtyFlag = false;
        this.actionparam12 = null;
    }

    public void setActionParam13(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam13(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam13 = string;
        this.actionparam13DirtyFlag = true;
    }

    public String getActionParam13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam13();
        }
        return this.actionparam13;
    }

    public boolean isActionParam13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam13Dirty();
        }
        return this.actionparam13DirtyFlag;
    }

    public void resetActionParam13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam13();
            return;
        }
        this.actionparam13DirtyFlag = false;
        this.actionparam13 = null;
    }

    public void setActionParam14(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam14(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam14 = string;
        this.actionparam14DirtyFlag = true;
    }

    public String getActionParam14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam14();
        }
        return this.actionparam14;
    }

    public boolean isActionParam14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam14Dirty();
        }
        return this.actionparam14DirtyFlag;
    }

    public void resetActionParam14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam14();
            return;
        }
        this.actionparam14DirtyFlag = false;
        this.actionparam14 = null;
    }

    public void setActionParam15(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam15(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam15 = string;
        this.actionparam15DirtyFlag = true;
    }

    public String getActionParam15() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam15();
        }
        return this.actionparam15;
    }

    public boolean isActionParam15Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam15Dirty();
        }
        return this.actionparam15DirtyFlag;
    }

    public void resetActionParam15() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam15();
            return;
        }
        this.actionparam15DirtyFlag = false;
        this.actionparam15 = null;
    }

    public void setActionParam16(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam16(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam16 = string;
        this.actionparam16DirtyFlag = true;
    }

    public String getActionParam16() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam16();
        }
        return this.actionparam16;
    }

    public boolean isActionParam16Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam16Dirty();
        }
        return this.actionparam16DirtyFlag;
    }

    public void resetActionParam16() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam16();
            return;
        }
        this.actionparam16DirtyFlag = false;
        this.actionparam16 = null;
    }

    public void setActionParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam2 = string;
        this.actionparam2DirtyFlag = true;
    }

    public String getActionParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam2();
        }
        return this.actionparam2;
    }

    public boolean isActionParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam2Dirty();
        }
        return this.actionparam2DirtyFlag;
    }

    public void resetActionParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam2();
            return;
        }
        this.actionparam2DirtyFlag = false;
        this.actionparam2 = null;
    }

    public void setActionParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam3 = string;
        this.actionparam3DirtyFlag = true;
    }

    public String getActionParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam3();
        }
        return this.actionparam3;
    }

    public boolean isActionParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam3Dirty();
        }
        return this.actionparam3DirtyFlag;
    }

    public void resetActionParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam3();
            return;
        }
        this.actionparam3DirtyFlag = false;
        this.actionparam3 = null;
    }

    public void setActionParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam4 = string;
        this.actionparam4DirtyFlag = true;
    }

    public String getActionParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam4();
        }
        return this.actionparam4;
    }

    public boolean isActionParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam4Dirty();
        }
        return this.actionparam4DirtyFlag;
    }

    public void resetActionParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam4();
            return;
        }
        this.actionparam4DirtyFlag = false;
        this.actionparam4 = null;
    }

    public void setActionParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam5(n);
            return;
        }
        this.actionparam5 = n;
        this.actionparam5DirtyFlag = true;
    }

    public Integer getActionParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam5();
        }
        return this.actionparam5;
    }

    public boolean isActionParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam5Dirty();
        }
        return this.actionparam5DirtyFlag;
    }

    public void resetActionParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam5();
            return;
        }
        this.actionparam5DirtyFlag = false;
        this.actionparam5 = null;
    }

    public void setActionParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam6(n);
            return;
        }
        this.actionparam6 = n;
        this.actionparam6DirtyFlag = true;
    }

    public Integer getActionParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam6();
        }
        return this.actionparam6;
    }

    public boolean isActionParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam6Dirty();
        }
        return this.actionparam6DirtyFlag;
    }

    public void resetActionParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam6();
            return;
        }
        this.actionparam6DirtyFlag = false;
        this.actionparam6 = null;
    }

    public void setActionParam7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam7 = string;
        this.actionparam7DirtyFlag = true;
    }

    public String getActionParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam7();
        }
        return this.actionparam7;
    }

    public boolean isActionParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam7Dirty();
        }
        return this.actionparam7DirtyFlag;
    }

    public void resetActionParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam7();
            return;
        }
        this.actionparam7DirtyFlag = false;
        this.actionparam7 = null;
    }

    public void setActionParam8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam8 = string;
        this.actionparam8DirtyFlag = true;
    }

    public String getActionParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam8();
        }
        return this.actionparam8;
    }

    public boolean isActionParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam8Dirty();
        }
        return this.actionparam8DirtyFlag;
    }

    public void resetActionParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam8();
            return;
        }
        this.actionparam8DirtyFlag = false;
        this.actionparam8 = null;
    }

    public void setActionParam9(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam9(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam9 = string;
        this.actionparam9DirtyFlag = true;
    }

    public String getActionParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam9();
        }
        return this.actionparam9;
    }

    public boolean isActionParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam9Dirty();
        }
        return this.actionparam9DirtyFlag;
    }

    public void resetActionParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam9();
            return;
        }
        this.actionparam9DirtyFlag = false;
        this.actionparam9 = null;
    }

    public void setActionResult(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionResult(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionresult = string;
        this.actionresultDirtyFlag = true;
    }

    public String getActionResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionResult();
        }
        return this.actionresult;
    }

    public boolean isActionResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionResultDirty();
        }
        return this.actionresultDirtyFlag;
    }

    public void resetActionResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionResult();
            return;
        }
        this.actionresultDirtyFlag = false;
        this.actionresult = null;
    }

    public void setActionState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionState(n);
            return;
        }
        this.actionstate = n;
        this.actionstateDirtyFlag = true;
    }

    public Integer getActionState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionState();
        }
        return this.actionstate;
    }

    public boolean isActionStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionStateDirty();
        }
        return this.actionstateDirtyFlag;
    }

    public void resetActionState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionState();
            return;
        }
        this.actionstateDirtyFlag = false;
        this.actionstate = null;
    }

    public void setActionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontype = string;
        this.actiontypeDirtyFlag = true;
    }

    public String getActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionType();
        }
        return this.actiontype;
    }

    public boolean isActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTypeDirty();
        }
        return this.actiontypeDirtyFlag;
    }

    public void resetActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionType();
            return;
        }
        this.actiontypeDirtyFlag = false;
        this.actiontype = null;
    }

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setDownloadUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDownloadUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.downloadurl = string;
        this.downloadurlDirtyFlag = true;
    }

    public String getDownloadUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDownloadUrl();
        }
        return this.downloadurl;
    }

    public boolean isDownloadUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDownloadUrlDirty();
        }
        return this.downloadurlDirtyFlag;
    }

    public void resetDownloadUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDownloadUrl();
            return;
        }
        this.downloadurlDirtyFlag = false;
        this.downloadurl = null;
    }

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setFullResultInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullResultInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullresultinfo = string;
        this.fullresultinfoDirtyFlag = true;
    }

    public String getFullResultInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullResultInfo();
        }
        return this.fullresultinfo;
    }

    public boolean isFullResultInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullResultInfoDirty();
        }
        return this.fullresultinfoDirtyFlag;
    }

    public void resetFullResultInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullResultInfo();
            return;
        }
        this.fullresultinfoDirtyFlag = false;
        this.fullresultinfo = null;
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

    public void setPPSStudioPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSStudioPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsstudiopluginid = string;
        this.ppsstudiopluginidDirtyFlag = true;
    }

    public String getPPSStudioPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSStudioPluginId();
        }
        return this.ppsstudiopluginid;
    }

    public boolean isPPSStudioPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSStudioPluginIdDirty();
        }
        return this.ppsstudiopluginidDirtyFlag;
    }

    public void resetPPSStudioPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSStudioPluginId();
            return;
        }
        this.ppsstudiopluginidDirtyFlag = false;
        this.ppsstudiopluginid = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplid = string;
        this.psdevslntemplidDirtyFlag = true;
    }

    public String getPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplId();
        }
        return this.psdevslntemplid;
    }

    public boolean isPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplIdDirty();
        }
        return this.psdevslntemplidDirtyFlag;
    }

    public void resetPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplId();
            return;
        }
        this.psdevslntemplidDirtyFlag = false;
        this.psdevslntemplid = null;
    }

    public void setPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplname = string;
        this.psdevslntemplnameDirtyFlag = true;
    }

    public String getPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplName();
        }
        return this.psdevslntemplname;
    }

    public boolean isPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplNameDirty();
        }
        return this.psdevslntemplnameDirtyFlag;
    }

    public void resetPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplName();
            return;
        }
        this.psdevslntemplnameDirtyFlag = false;
        this.psdevslntemplname = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSStudioPluginDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioPluginDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioplugindataid = string;
        this.psstudioplugindataidDirtyFlag = true;
    }

    public String getPSStudioPluginDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioPluginDataId();
        }
        return this.psstudioplugindataid;
    }

    public boolean isPSStudioPluginDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioPluginDataIdDirty();
        }
        return this.psstudioplugindataidDirtyFlag;
    }

    public void resetPSStudioPluginDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioPluginDataId();
            return;
        }
        this.psstudioplugindataidDirtyFlag = false;
        this.psstudioplugindataid = null;
    }

    public void setPSStudioPluginDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioPluginDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioplugindataname = string;
        this.psstudioplugindatanameDirtyFlag = true;
    }

    public String getPSStudioPluginDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioPluginDataName();
        }
        return this.psstudioplugindataname;
    }

    public boolean isPSStudioPluginDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioPluginDataNameDirty();
        }
        return this.psstudioplugindatanameDirtyFlag;
    }

    public void resetPSStudioPluginDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioPluginDataName();
            return;
        }
        this.psstudioplugindatanameDirtyFlag = false;
        this.psstudioplugindataname = null;
    }

    public void setPSStudioPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiopluginid = string;
        this.psstudiopluginidDirtyFlag = true;
    }

    public String getPSStudioPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioPluginId();
        }
        return this.psstudiopluginid;
    }

    public boolean isPSStudioPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioPluginIdDirty();
        }
        return this.psstudiopluginidDirtyFlag;
    }

    public void resetPSStudioPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioPluginId();
            return;
        }
        this.psstudiopluginidDirtyFlag = false;
        this.psstudiopluginid = null;
    }

    public void setPSStudioPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiopluginname = string;
        this.psstudiopluginnameDirtyFlag = true;
    }

    public String getPSStudioPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioPluginName();
        }
        return this.psstudiopluginname;
    }

    public boolean isPSStudioPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioPluginNameDirty();
        }
        return this.psstudiopluginnameDirtyFlag;
    }

    public void resetPSStudioPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioPluginName();
            return;
        }
        this.psstudiopluginnameDirtyFlag = false;
        this.psstudiopluginname = null;
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

    protected void onReset() {
        PSStudioPluginDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSStudioPluginDataBase pSStudioPluginDataBase) {
        pSStudioPluginDataBase.resetActionParam();
        pSStudioPluginDataBase.resetActionParam10();
        pSStudioPluginDataBase.resetActionParam11();
        pSStudioPluginDataBase.resetActionParam12();
        pSStudioPluginDataBase.resetActionParam13();
        pSStudioPluginDataBase.resetActionParam14();
        pSStudioPluginDataBase.resetActionParam15();
        pSStudioPluginDataBase.resetActionParam16();
        pSStudioPluginDataBase.resetActionParam2();
        pSStudioPluginDataBase.resetActionParam3();
        pSStudioPluginDataBase.resetActionParam4();
        pSStudioPluginDataBase.resetActionParam5();
        pSStudioPluginDataBase.resetActionParam6();
        pSStudioPluginDataBase.resetActionParam7();
        pSStudioPluginDataBase.resetActionParam8();
        pSStudioPluginDataBase.resetActionParam9();
        pSStudioPluginDataBase.resetActionResult();
        pSStudioPluginDataBase.resetActionState();
        pSStudioPluginDataBase.resetActionType();
        pSStudioPluginDataBase.resetBeginTime();
        pSStudioPluginDataBase.resetCreateDate();
        pSStudioPluginDataBase.resetCreateMan();
        pSStudioPluginDataBase.resetDownloadUrl();
        pSStudioPluginDataBase.resetEndTime();
        pSStudioPluginDataBase.resetFullResultInfo();
        pSStudioPluginDataBase.resetMemo();
        pSStudioPluginDataBase.resetPPSStudioPluginId();
        pSStudioPluginDataBase.resetPSDevCenterId();
        pSStudioPluginDataBase.resetPSDevCenterName();
        pSStudioPluginDataBase.resetPSDevSlnId();
        pSStudioPluginDataBase.resetPSDevSlnName();
        pSStudioPluginDataBase.resetPSDevSlnSysId();
        pSStudioPluginDataBase.resetPSDevSlnSysName();
        pSStudioPluginDataBase.resetPSDevSlnTemplId();
        pSStudioPluginDataBase.resetPSDevSlnTemplName();
        pSStudioPluginDataBase.resetPSObjId();
        pSStudioPluginDataBase.resetPSObjName();
        pSStudioPluginDataBase.resetPSObjType();
        pSStudioPluginDataBase.resetPSStudioPluginDataId();
        pSStudioPluginDataBase.resetPSStudioPluginDataName();
        pSStudioPluginDataBase.resetPSStudioPluginId();
        pSStudioPluginDataBase.resetPSStudioPluginName();
        pSStudioPluginDataBase.resetUpdateDate();
        pSStudioPluginDataBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionParamDirty()) {
            hashMap.put(FIELD_ACTIONPARAM, this.getActionParam());
        }
        if (!bl || this.isActionParam10Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM10, this.getActionParam10());
        }
        if (!bl || this.isActionParam11Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM11, this.getActionParam11());
        }
        if (!bl || this.isActionParam12Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM12, this.getActionParam12());
        }
        if (!bl || this.isActionParam13Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM13, this.getActionParam13());
        }
        if (!bl || this.isActionParam14Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM14, this.getActionParam14());
        }
        if (!bl || this.isActionParam15Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM15, this.getActionParam15());
        }
        if (!bl || this.isActionParam16Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM16, this.getActionParam16());
        }
        if (!bl || this.isActionParam2Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM2, this.getActionParam2());
        }
        if (!bl || this.isActionParam3Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM3, this.getActionParam3());
        }
        if (!bl || this.isActionParam4Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM4, this.getActionParam4());
        }
        if (!bl || this.isActionParam5Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM5, this.getActionParam5());
        }
        if (!bl || this.isActionParam6Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM6, this.getActionParam6());
        }
        if (!bl || this.isActionParam7Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM7, this.getActionParam7());
        }
        if (!bl || this.isActionParam8Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM8, this.getActionParam8());
        }
        if (!bl || this.isActionParam9Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM9, this.getActionParam9());
        }
        if (!bl || this.isActionResultDirty()) {
            hashMap.put(FIELD_ACTIONRESULT, this.getActionResult());
        }
        if (!bl || this.isActionStateDirty()) {
            hashMap.put(FIELD_ACTIONSTATE, this.getActionState());
        }
        if (!bl || this.isActionTypeDirty()) {
            hashMap.put(FIELD_ACTIONTYPE, this.getActionType());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDownloadUrlDirty()) {
            hashMap.put(FIELD_DOWNLOADURL, this.getDownloadUrl());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isFullResultInfoDirty()) {
            hashMap.put(FIELD_FULLRESULTINFO, this.getFullResultInfo());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPPSStudioPluginIdDirty()) {
            hashMap.put(FIELD_PPSSTUDIOPLUGINID, this.getPPSStudioPluginId());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLID, this.getPSDevSlnTemplId());
        }
        if (!bl || this.isPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLNAME, this.getPSDevSlnTemplName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSStudioPluginDataIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOPLUGINDATAID, this.getPSStudioPluginDataId());
        }
        if (!bl || this.isPSStudioPluginDataNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOPLUGINDATANAME, this.getPSStudioPluginDataName());
        }
        if (!bl || this.isPSStudioPluginIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOPLUGINID, this.getPSStudioPluginId());
        }
        if (!bl || this.isPSStudioPluginNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOPLUGINNAME, this.getPSStudioPluginName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSStudioPluginDataBase.get(this, n);
    }

    private static Object get(PSStudioPluginDataBase pSStudioPluginDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioPluginDataBase.getActionParam();
            }
            case 1: {
                return pSStudioPluginDataBase.getActionParam10();
            }
            case 2: {
                return pSStudioPluginDataBase.getActionParam11();
            }
            case 3: {
                return pSStudioPluginDataBase.getActionParam12();
            }
            case 4: {
                return pSStudioPluginDataBase.getActionParam13();
            }
            case 5: {
                return pSStudioPluginDataBase.getActionParam14();
            }
            case 6: {
                return pSStudioPluginDataBase.getActionParam15();
            }
            case 7: {
                return pSStudioPluginDataBase.getActionParam16();
            }
            case 8: {
                return pSStudioPluginDataBase.getActionParam2();
            }
            case 9: {
                return pSStudioPluginDataBase.getActionParam3();
            }
            case 10: {
                return pSStudioPluginDataBase.getActionParam4();
            }
            case 11: {
                return pSStudioPluginDataBase.getActionParam5();
            }
            case 12: {
                return pSStudioPluginDataBase.getActionParam6();
            }
            case 13: {
                return pSStudioPluginDataBase.getActionParam7();
            }
            case 14: {
                return pSStudioPluginDataBase.getActionParam8();
            }
            case 15: {
                return pSStudioPluginDataBase.getActionParam9();
            }
            case 16: {
                return pSStudioPluginDataBase.getActionResult();
            }
            case 17: {
                return pSStudioPluginDataBase.getActionState();
            }
            case 18: {
                return pSStudioPluginDataBase.getActionType();
            }
            case 19: {
                return pSStudioPluginDataBase.getBeginTime();
            }
            case 20: {
                return pSStudioPluginDataBase.getCreateDate();
            }
            case 21: {
                return pSStudioPluginDataBase.getCreateMan();
            }
            case 22: {
                return pSStudioPluginDataBase.getDownloadUrl();
            }
            case 23: {
                return pSStudioPluginDataBase.getEndTime();
            }
            case 24: {
                return pSStudioPluginDataBase.getFullResultInfo();
            }
            case 25: {
                return pSStudioPluginDataBase.getMemo();
            }
            case 26: {
                return pSStudioPluginDataBase.getPPSStudioPluginId();
            }
            case 27: {
                return pSStudioPluginDataBase.getPSDevCenterId();
            }
            case 28: {
                return pSStudioPluginDataBase.getPSDevCenterName();
            }
            case 29: {
                return pSStudioPluginDataBase.getPSDevSlnId();
            }
            case 30: {
                return pSStudioPluginDataBase.getPSDevSlnName();
            }
            case 31: {
                return pSStudioPluginDataBase.getPSDevSlnSysId();
            }
            case 32: {
                return pSStudioPluginDataBase.getPSDevSlnSysName();
            }
            case 33: {
                return pSStudioPluginDataBase.getPSDevSlnTemplId();
            }
            case 34: {
                return pSStudioPluginDataBase.getPSDevSlnTemplName();
            }
            case 35: {
                return pSStudioPluginDataBase.getPSObjId();
            }
            case 36: {
                return pSStudioPluginDataBase.getPSObjName();
            }
            case 37: {
                return pSStudioPluginDataBase.getPSObjType();
            }
            case 38: {
                return pSStudioPluginDataBase.getPSStudioPluginDataId();
            }
            case 39: {
                return pSStudioPluginDataBase.getPSStudioPluginDataName();
            }
            case 40: {
                return pSStudioPluginDataBase.getPSStudioPluginId();
            }
            case 41: {
                return pSStudioPluginDataBase.getPSStudioPluginName();
            }
            case 42: {
                return pSStudioPluginDataBase.getUpdateDate();
            }
            case 43: {
                return pSStudioPluginDataBase.getUpdateMan();
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
        PSStudioPluginDataBase.set(this, n, object);
    }

    private static void set(PSStudioPluginDataBase pSStudioPluginDataBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSStudioPluginDataBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSStudioPluginDataBase.setActionParam10(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSStudioPluginDataBase.setActionParam11(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSStudioPluginDataBase.setActionParam12(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSStudioPluginDataBase.setActionParam13(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSStudioPluginDataBase.setActionParam14(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSStudioPluginDataBase.setActionParam15(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSStudioPluginDataBase.setActionParam16(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSStudioPluginDataBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSStudioPluginDataBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSStudioPluginDataBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSStudioPluginDataBase.setActionParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSStudioPluginDataBase.setActionParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSStudioPluginDataBase.setActionParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSStudioPluginDataBase.setActionParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSStudioPluginDataBase.setActionParam9(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSStudioPluginDataBase.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSStudioPluginDataBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSStudioPluginDataBase.setActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSStudioPluginDataBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSStudioPluginDataBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSStudioPluginDataBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSStudioPluginDataBase.setDownloadUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSStudioPluginDataBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSStudioPluginDataBase.setFullResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSStudioPluginDataBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSStudioPluginDataBase.setPPSStudioPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSStudioPluginDataBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSStudioPluginDataBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSStudioPluginDataBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSStudioPluginDataBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSStudioPluginDataBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSStudioPluginDataBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSStudioPluginDataBase.setPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSStudioPluginDataBase.setPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSStudioPluginDataBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSStudioPluginDataBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSStudioPluginDataBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSStudioPluginDataBase.setPSStudioPluginDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSStudioPluginDataBase.setPSStudioPluginDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSStudioPluginDataBase.setPSStudioPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSStudioPluginDataBase.setPSStudioPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSStudioPluginDataBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 43: {
                pSStudioPluginDataBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSStudioPluginDataBase.isNull(this, n);
    }

    private static boolean isNull(PSStudioPluginDataBase pSStudioPluginDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioPluginDataBase.getActionParam() == null;
            }
            case 1: {
                return pSStudioPluginDataBase.getActionParam10() == null;
            }
            case 2: {
                return pSStudioPluginDataBase.getActionParam11() == null;
            }
            case 3: {
                return pSStudioPluginDataBase.getActionParam12() == null;
            }
            case 4: {
                return pSStudioPluginDataBase.getActionParam13() == null;
            }
            case 5: {
                return pSStudioPluginDataBase.getActionParam14() == null;
            }
            case 6: {
                return pSStudioPluginDataBase.getActionParam15() == null;
            }
            case 7: {
                return pSStudioPluginDataBase.getActionParam16() == null;
            }
            case 8: {
                return pSStudioPluginDataBase.getActionParam2() == null;
            }
            case 9: {
                return pSStudioPluginDataBase.getActionParam3() == null;
            }
            case 10: {
                return pSStudioPluginDataBase.getActionParam4() == null;
            }
            case 11: {
                return pSStudioPluginDataBase.getActionParam5() == null;
            }
            case 12: {
                return pSStudioPluginDataBase.getActionParam6() == null;
            }
            case 13: {
                return pSStudioPluginDataBase.getActionParam7() == null;
            }
            case 14: {
                return pSStudioPluginDataBase.getActionParam8() == null;
            }
            case 15: {
                return pSStudioPluginDataBase.getActionParam9() == null;
            }
            case 16: {
                return pSStudioPluginDataBase.getActionResult() == null;
            }
            case 17: {
                return pSStudioPluginDataBase.getActionState() == null;
            }
            case 18: {
                return pSStudioPluginDataBase.getActionType() == null;
            }
            case 19: {
                return pSStudioPluginDataBase.getBeginTime() == null;
            }
            case 20: {
                return pSStudioPluginDataBase.getCreateDate() == null;
            }
            case 21: {
                return pSStudioPluginDataBase.getCreateMan() == null;
            }
            case 22: {
                return pSStudioPluginDataBase.getDownloadUrl() == null;
            }
            case 23: {
                return pSStudioPluginDataBase.getEndTime() == null;
            }
            case 24: {
                return pSStudioPluginDataBase.getFullResultInfo() == null;
            }
            case 25: {
                return pSStudioPluginDataBase.getMemo() == null;
            }
            case 26: {
                return pSStudioPluginDataBase.getPPSStudioPluginId() == null;
            }
            case 27: {
                return pSStudioPluginDataBase.getPSDevCenterId() == null;
            }
            case 28: {
                return pSStudioPluginDataBase.getPSDevCenterName() == null;
            }
            case 29: {
                return pSStudioPluginDataBase.getPSDevSlnId() == null;
            }
            case 30: {
                return pSStudioPluginDataBase.getPSDevSlnName() == null;
            }
            case 31: {
                return pSStudioPluginDataBase.getPSDevSlnSysId() == null;
            }
            case 32: {
                return pSStudioPluginDataBase.getPSDevSlnSysName() == null;
            }
            case 33: {
                return pSStudioPluginDataBase.getPSDevSlnTemplId() == null;
            }
            case 34: {
                return pSStudioPluginDataBase.getPSDevSlnTemplName() == null;
            }
            case 35: {
                return pSStudioPluginDataBase.getPSObjId() == null;
            }
            case 36: {
                return pSStudioPluginDataBase.getPSObjName() == null;
            }
            case 37: {
                return pSStudioPluginDataBase.getPSObjType() == null;
            }
            case 38: {
                return pSStudioPluginDataBase.getPSStudioPluginDataId() == null;
            }
            case 39: {
                return pSStudioPluginDataBase.getPSStudioPluginDataName() == null;
            }
            case 40: {
                return pSStudioPluginDataBase.getPSStudioPluginId() == null;
            }
            case 41: {
                return pSStudioPluginDataBase.getPSStudioPluginName() == null;
            }
            case 42: {
                return pSStudioPluginDataBase.getUpdateDate() == null;
            }
            case 43: {
                return pSStudioPluginDataBase.getUpdateMan() == null;
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
        return PSStudioPluginDataBase.contains(this, n);
    }

    private static boolean contains(PSStudioPluginDataBase pSStudioPluginDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioPluginDataBase.isActionParamDirty();
            }
            case 1: {
                return pSStudioPluginDataBase.isActionParam10Dirty();
            }
            case 2: {
                return pSStudioPluginDataBase.isActionParam11Dirty();
            }
            case 3: {
                return pSStudioPluginDataBase.isActionParam12Dirty();
            }
            case 4: {
                return pSStudioPluginDataBase.isActionParam13Dirty();
            }
            case 5: {
                return pSStudioPluginDataBase.isActionParam14Dirty();
            }
            case 6: {
                return pSStudioPluginDataBase.isActionParam15Dirty();
            }
            case 7: {
                return pSStudioPluginDataBase.isActionParam16Dirty();
            }
            case 8: {
                return pSStudioPluginDataBase.isActionParam2Dirty();
            }
            case 9: {
                return pSStudioPluginDataBase.isActionParam3Dirty();
            }
            case 10: {
                return pSStudioPluginDataBase.isActionParam4Dirty();
            }
            case 11: {
                return pSStudioPluginDataBase.isActionParam5Dirty();
            }
            case 12: {
                return pSStudioPluginDataBase.isActionParam6Dirty();
            }
            case 13: {
                return pSStudioPluginDataBase.isActionParam7Dirty();
            }
            case 14: {
                return pSStudioPluginDataBase.isActionParam8Dirty();
            }
            case 15: {
                return pSStudioPluginDataBase.isActionParam9Dirty();
            }
            case 16: {
                return pSStudioPluginDataBase.isActionResultDirty();
            }
            case 17: {
                return pSStudioPluginDataBase.isActionStateDirty();
            }
            case 18: {
                return pSStudioPluginDataBase.isActionTypeDirty();
            }
            case 19: {
                return pSStudioPluginDataBase.isBeginTimeDirty();
            }
            case 20: {
                return pSStudioPluginDataBase.isCreateDateDirty();
            }
            case 21: {
                return pSStudioPluginDataBase.isCreateManDirty();
            }
            case 22: {
                return pSStudioPluginDataBase.isDownloadUrlDirty();
            }
            case 23: {
                return pSStudioPluginDataBase.isEndTimeDirty();
            }
            case 24: {
                return pSStudioPluginDataBase.isFullResultInfoDirty();
            }
            case 25: {
                return pSStudioPluginDataBase.isMemoDirty();
            }
            case 26: {
                return pSStudioPluginDataBase.isPPSStudioPluginIdDirty();
            }
            case 27: {
                return pSStudioPluginDataBase.isPSDevCenterIdDirty();
            }
            case 28: {
                return pSStudioPluginDataBase.isPSDevCenterNameDirty();
            }
            case 29: {
                return pSStudioPluginDataBase.isPSDevSlnIdDirty();
            }
            case 30: {
                return pSStudioPluginDataBase.isPSDevSlnNameDirty();
            }
            case 31: {
                return pSStudioPluginDataBase.isPSDevSlnSysIdDirty();
            }
            case 32: {
                return pSStudioPluginDataBase.isPSDevSlnSysNameDirty();
            }
            case 33: {
                return pSStudioPluginDataBase.isPSDevSlnTemplIdDirty();
            }
            case 34: {
                return pSStudioPluginDataBase.isPSDevSlnTemplNameDirty();
            }
            case 35: {
                return pSStudioPluginDataBase.isPSObjIdDirty();
            }
            case 36: {
                return pSStudioPluginDataBase.isPSObjNameDirty();
            }
            case 37: {
                return pSStudioPluginDataBase.isPSObjTypeDirty();
            }
            case 38: {
                return pSStudioPluginDataBase.isPSStudioPluginDataIdDirty();
            }
            case 39: {
                return pSStudioPluginDataBase.isPSStudioPluginDataNameDirty();
            }
            case 40: {
                return pSStudioPluginDataBase.isPSStudioPluginIdDirty();
            }
            case 41: {
                return pSStudioPluginDataBase.isPSStudioPluginNameDirty();
            }
            case 42: {
                return pSStudioPluginDataBase.isUpdateDateDirty();
            }
            case 43: {
                return pSStudioPluginDataBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSStudioPluginDataBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSStudioPluginDataBase pSStudioPluginDataBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSStudioPluginDataBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam10", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam10()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam11", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam11()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam12", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam12()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam13", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam13()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam14", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam14()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam15() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam15", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam15()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam16() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam16", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam16()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam5", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam5()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam6", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam6()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam7", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam7()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam8", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam8()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam9", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionParam9()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionResult()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionState()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontype", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getActionType()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getDownloadUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"downloadurl", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getDownloadUrl()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getEndTime()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getFullResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullresultinfo", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getFullResultInfo()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getMemo()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPPSStudioPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsstudiopluginid", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPPSStudioPluginId()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplid", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplname", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSStudioPluginDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioplugindataid", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSStudioPluginDataId()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSStudioPluginDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioplugindataname", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSStudioPluginDataName()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSStudioPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiopluginid", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSStudioPluginId()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getPSStudioPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiopluginname", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getPSStudioPluginName()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSStudioPluginDataBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSStudioPluginDataBase.getJSONValue((Object)pSStudioPluginDataBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSStudioPluginDataBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSStudioPluginDataBase pSStudioPluginDataBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSStudioPluginDataBase.getActionParam() != null) {
            object = pSStudioPluginDataBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam10() != null) {
            object = pSStudioPluginDataBase.getActionParam10();
            xmlNode.setAttribute(FIELD_ACTIONPARAM10, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam11() != null) {
            object = pSStudioPluginDataBase.getActionParam11();
            xmlNode.setAttribute(FIELD_ACTIONPARAM11, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam12() != null) {
            object = pSStudioPluginDataBase.getActionParam12();
            xmlNode.setAttribute(FIELD_ACTIONPARAM12, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam13() != null) {
            object = pSStudioPluginDataBase.getActionParam13();
            xmlNode.setAttribute(FIELD_ACTIONPARAM13, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam14() != null) {
            object = pSStudioPluginDataBase.getActionParam14();
            xmlNode.setAttribute(FIELD_ACTIONPARAM14, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam15() != null) {
            object = pSStudioPluginDataBase.getActionParam15();
            xmlNode.setAttribute(FIELD_ACTIONPARAM15, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam16() != null) {
            object = pSStudioPluginDataBase.getActionParam16();
            xmlNode.setAttribute(FIELD_ACTIONPARAM16, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam2() != null) {
            object = pSStudioPluginDataBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam3() != null) {
            object = pSStudioPluginDataBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam4() != null) {
            object = pSStudioPluginDataBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getActionParam5() != null) {
            object = pSStudioPluginDataBase.getActionParam5();
            xmlNode.setAttribute(FIELD_ACTIONPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam6() != null) {
            object = pSStudioPluginDataBase.getActionParam6();
            xmlNode.setAttribute(FIELD_ACTIONPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioPluginDataBase.getActionParam7() != null) {
            object = pSStudioPluginDataBase.getActionParam7();
            xmlNode.setAttribute(FIELD_ACTIONPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getActionParam8() != null) {
            object = pSStudioPluginDataBase.getActionParam8();
            xmlNode.setAttribute(FIELD_ACTIONPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getActionParam9() != null) {
            object = pSStudioPluginDataBase.getActionParam9();
            xmlNode.setAttribute(FIELD_ACTIONPARAM9, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getActionResult() != null) {
            object = pSStudioPluginDataBase.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getActionState() != null) {
            object = pSStudioPluginDataBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioPluginDataBase.getActionType() != null) {
            object = pSStudioPluginDataBase.getActionType();
            xmlNode.setAttribute(FIELD_ACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getBeginTime() != null) {
            object = pSStudioPluginDataBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioPluginDataBase.getCreateDate() != null) {
            object = pSStudioPluginDataBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioPluginDataBase.getCreateMan() != null) {
            object = pSStudioPluginDataBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getDownloadUrl() != null) {
            object = pSStudioPluginDataBase.getDownloadUrl();
            xmlNode.setAttribute(FIELD_DOWNLOADURL, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getEndTime() != null) {
            object = pSStudioPluginDataBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioPluginDataBase.getFullResultInfo() != null) {
            object = pSStudioPluginDataBase.getFullResultInfo();
            xmlNode.setAttribute(FIELD_FULLRESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getMemo() != null) {
            object = pSStudioPluginDataBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPPSStudioPluginId() != null) {
            object = pSStudioPluginDataBase.getPPSStudioPluginId();
            xmlNode.setAttribute(FIELD_PPSSTUDIOPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSDevCenterId() != null) {
            object = pSStudioPluginDataBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSDevCenterName() != null) {
            object = pSStudioPluginDataBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnId() != null) {
            object = pSStudioPluginDataBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnName() != null) {
            object = pSStudioPluginDataBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnSysId() != null) {
            object = pSStudioPluginDataBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnSysName() != null) {
            object = pSStudioPluginDataBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnTemplId() != null) {
            object = pSStudioPluginDataBase.getPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSDevSlnTemplName() != null) {
            object = pSStudioPluginDataBase.getPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSObjId() != null) {
            object = pSStudioPluginDataBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSObjName() != null) {
            object = pSStudioPluginDataBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSObjType() != null) {
            object = pSStudioPluginDataBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSStudioPluginDataId() != null) {
            object = pSStudioPluginDataBase.getPSStudioPluginDataId();
            xmlNode.setAttribute(FIELD_PSSTUDIOPLUGINDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSStudioPluginDataName() != null) {
            object = pSStudioPluginDataBase.getPSStudioPluginDataName();
            xmlNode.setAttribute(FIELD_PSSTUDIOPLUGINDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSStudioPluginId() != null) {
            object = pSStudioPluginDataBase.getPSStudioPluginId();
            xmlNode.setAttribute(FIELD_PSSTUDIOPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getPSStudioPluginName() != null) {
            object = pSStudioPluginDataBase.getPSStudioPluginName();
            xmlNode.setAttribute(FIELD_PSSTUDIOPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginDataBase.getUpdateDate() != null) {
            object = pSStudioPluginDataBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioPluginDataBase.getUpdateMan() != null) {
            object = pSStudioPluginDataBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSStudioPluginDataBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSStudioPluginDataBase pSStudioPluginDataBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSStudioPluginDataBase.isActionParamDirty() && (bl || pSStudioPluginDataBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSStudioPluginDataBase.getActionParam());
        }
        if (pSStudioPluginDataBase.isActionParam10Dirty() && (bl || pSStudioPluginDataBase.getActionParam10() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM10, (Object)pSStudioPluginDataBase.getActionParam10());
        }
        if (pSStudioPluginDataBase.isActionParam11Dirty() && (bl || pSStudioPluginDataBase.getActionParam11() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM11, (Object)pSStudioPluginDataBase.getActionParam11());
        }
        if (pSStudioPluginDataBase.isActionParam12Dirty() && (bl || pSStudioPluginDataBase.getActionParam12() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM12, (Object)pSStudioPluginDataBase.getActionParam12());
        }
        if (pSStudioPluginDataBase.isActionParam13Dirty() && (bl || pSStudioPluginDataBase.getActionParam13() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM13, (Object)pSStudioPluginDataBase.getActionParam13());
        }
        if (pSStudioPluginDataBase.isActionParam14Dirty() && (bl || pSStudioPluginDataBase.getActionParam14() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM14, (Object)pSStudioPluginDataBase.getActionParam14());
        }
        if (pSStudioPluginDataBase.isActionParam15Dirty() && (bl || pSStudioPluginDataBase.getActionParam15() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM15, (Object)pSStudioPluginDataBase.getActionParam15());
        }
        if (pSStudioPluginDataBase.isActionParam16Dirty() && (bl || pSStudioPluginDataBase.getActionParam16() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM16, (Object)pSStudioPluginDataBase.getActionParam16());
        }
        if (pSStudioPluginDataBase.isActionParam2Dirty() && (bl || pSStudioPluginDataBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSStudioPluginDataBase.getActionParam2());
        }
        if (pSStudioPluginDataBase.isActionParam3Dirty() && (bl || pSStudioPluginDataBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSStudioPluginDataBase.getActionParam3());
        }
        if (pSStudioPluginDataBase.isActionParam4Dirty() && (bl || pSStudioPluginDataBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSStudioPluginDataBase.getActionParam4());
        }
        if (pSStudioPluginDataBase.isActionParam5Dirty() && (bl || pSStudioPluginDataBase.getActionParam5() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM5, (Object)pSStudioPluginDataBase.getActionParam5());
        }
        if (pSStudioPluginDataBase.isActionParam6Dirty() && (bl || pSStudioPluginDataBase.getActionParam6() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM6, (Object)pSStudioPluginDataBase.getActionParam6());
        }
        if (pSStudioPluginDataBase.isActionParam7Dirty() && (bl || pSStudioPluginDataBase.getActionParam7() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM7, (Object)pSStudioPluginDataBase.getActionParam7());
        }
        if (pSStudioPluginDataBase.isActionParam8Dirty() && (bl || pSStudioPluginDataBase.getActionParam8() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM8, (Object)pSStudioPluginDataBase.getActionParam8());
        }
        if (pSStudioPluginDataBase.isActionParam9Dirty() && (bl || pSStudioPluginDataBase.getActionParam9() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM9, (Object)pSStudioPluginDataBase.getActionParam9());
        }
        if (pSStudioPluginDataBase.isActionResultDirty() && (bl || pSStudioPluginDataBase.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSStudioPluginDataBase.getActionResult());
        }
        if (pSStudioPluginDataBase.isActionStateDirty() && (bl || pSStudioPluginDataBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSStudioPluginDataBase.getActionState());
        }
        if (pSStudioPluginDataBase.isActionTypeDirty() && (bl || pSStudioPluginDataBase.getActionType() != null)) {
            iDataObject.set(FIELD_ACTIONTYPE, (Object)pSStudioPluginDataBase.getActionType());
        }
        if (pSStudioPluginDataBase.isBeginTimeDirty() && (bl || pSStudioPluginDataBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSStudioPluginDataBase.getBeginTime());
        }
        if (pSStudioPluginDataBase.isCreateDateDirty() && (bl || pSStudioPluginDataBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSStudioPluginDataBase.getCreateDate());
        }
        if (pSStudioPluginDataBase.isCreateManDirty() && (bl || pSStudioPluginDataBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSStudioPluginDataBase.getCreateMan());
        }
        if (pSStudioPluginDataBase.isDownloadUrlDirty() && (bl || pSStudioPluginDataBase.getDownloadUrl() != null)) {
            iDataObject.set(FIELD_DOWNLOADURL, (Object)pSStudioPluginDataBase.getDownloadUrl());
        }
        if (pSStudioPluginDataBase.isEndTimeDirty() && (bl || pSStudioPluginDataBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSStudioPluginDataBase.getEndTime());
        }
        if (pSStudioPluginDataBase.isFullResultInfoDirty() && (bl || pSStudioPluginDataBase.getFullResultInfo() != null)) {
            iDataObject.set(FIELD_FULLRESULTINFO, (Object)pSStudioPluginDataBase.getFullResultInfo());
        }
        if (pSStudioPluginDataBase.isMemoDirty() && (bl || pSStudioPluginDataBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSStudioPluginDataBase.getMemo());
        }
        if (pSStudioPluginDataBase.isPPSStudioPluginIdDirty() && (bl || pSStudioPluginDataBase.getPPSStudioPluginId() != null)) {
            iDataObject.set(FIELD_PPSSTUDIOPLUGINID, (Object)pSStudioPluginDataBase.getPPSStudioPluginId());
        }
        if (pSStudioPluginDataBase.isPSDevCenterIdDirty() && (bl || pSStudioPluginDataBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSStudioPluginDataBase.getPSDevCenterId());
        }
        if (pSStudioPluginDataBase.isPSDevCenterNameDirty() && (bl || pSStudioPluginDataBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSStudioPluginDataBase.getPSDevCenterName());
        }
        if (pSStudioPluginDataBase.isPSDevSlnIdDirty() && (bl || pSStudioPluginDataBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSStudioPluginDataBase.getPSDevSlnId());
        }
        if (pSStudioPluginDataBase.isPSDevSlnNameDirty() && (bl || pSStudioPluginDataBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSStudioPluginDataBase.getPSDevSlnName());
        }
        if (pSStudioPluginDataBase.isPSDevSlnSysIdDirty() && (bl || pSStudioPluginDataBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSStudioPluginDataBase.getPSDevSlnSysId());
        }
        if (pSStudioPluginDataBase.isPSDevSlnSysNameDirty() && (bl || pSStudioPluginDataBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSStudioPluginDataBase.getPSDevSlnSysName());
        }
        if (pSStudioPluginDataBase.isPSDevSlnTemplIdDirty() && (bl || pSStudioPluginDataBase.getPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLID, (Object)pSStudioPluginDataBase.getPSDevSlnTemplId());
        }
        if (pSStudioPluginDataBase.isPSDevSlnTemplNameDirty() && (bl || pSStudioPluginDataBase.getPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLNAME, (Object)pSStudioPluginDataBase.getPSDevSlnTemplName());
        }
        if (pSStudioPluginDataBase.isPSObjIdDirty() && (bl || pSStudioPluginDataBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSStudioPluginDataBase.getPSObjId());
        }
        if (pSStudioPluginDataBase.isPSObjNameDirty() && (bl || pSStudioPluginDataBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSStudioPluginDataBase.getPSObjName());
        }
        if (pSStudioPluginDataBase.isPSObjTypeDirty() && (bl || pSStudioPluginDataBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSStudioPluginDataBase.getPSObjType());
        }
        if (pSStudioPluginDataBase.isPSStudioPluginDataIdDirty() && (bl || pSStudioPluginDataBase.getPSStudioPluginDataId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOPLUGINDATAID, (Object)pSStudioPluginDataBase.getPSStudioPluginDataId());
        }
        if (pSStudioPluginDataBase.isPSStudioPluginDataNameDirty() && (bl || pSStudioPluginDataBase.getPSStudioPluginDataName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOPLUGINDATANAME, (Object)pSStudioPluginDataBase.getPSStudioPluginDataName());
        }
        if (pSStudioPluginDataBase.isPSStudioPluginIdDirty() && (bl || pSStudioPluginDataBase.getPSStudioPluginId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOPLUGINID, (Object)pSStudioPluginDataBase.getPSStudioPluginId());
        }
        if (pSStudioPluginDataBase.isPSStudioPluginNameDirty() && (bl || pSStudioPluginDataBase.getPSStudioPluginName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOPLUGINNAME, (Object)pSStudioPluginDataBase.getPSStudioPluginName());
        }
        if (pSStudioPluginDataBase.isUpdateDateDirty() && (bl || pSStudioPluginDataBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSStudioPluginDataBase.getUpdateDate());
        }
        if (pSStudioPluginDataBase.isUpdateManDirty() && (bl || pSStudioPluginDataBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSStudioPluginDataBase.getUpdateMan());
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
        return PSStudioPluginDataBase.remove(this, n);
    }

    private static boolean remove(PSStudioPluginDataBase pSStudioPluginDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSStudioPluginDataBase.resetActionParam();
                return true;
            }
            case 1: {
                pSStudioPluginDataBase.resetActionParam10();
                return true;
            }
            case 2: {
                pSStudioPluginDataBase.resetActionParam11();
                return true;
            }
            case 3: {
                pSStudioPluginDataBase.resetActionParam12();
                return true;
            }
            case 4: {
                pSStudioPluginDataBase.resetActionParam13();
                return true;
            }
            case 5: {
                pSStudioPluginDataBase.resetActionParam14();
                return true;
            }
            case 6: {
                pSStudioPluginDataBase.resetActionParam15();
                return true;
            }
            case 7: {
                pSStudioPluginDataBase.resetActionParam16();
                return true;
            }
            case 8: {
                pSStudioPluginDataBase.resetActionParam2();
                return true;
            }
            case 9: {
                pSStudioPluginDataBase.resetActionParam3();
                return true;
            }
            case 10: {
                pSStudioPluginDataBase.resetActionParam4();
                return true;
            }
            case 11: {
                pSStudioPluginDataBase.resetActionParam5();
                return true;
            }
            case 12: {
                pSStudioPluginDataBase.resetActionParam6();
                return true;
            }
            case 13: {
                pSStudioPluginDataBase.resetActionParam7();
                return true;
            }
            case 14: {
                pSStudioPluginDataBase.resetActionParam8();
                return true;
            }
            case 15: {
                pSStudioPluginDataBase.resetActionParam9();
                return true;
            }
            case 16: {
                pSStudioPluginDataBase.resetActionResult();
                return true;
            }
            case 17: {
                pSStudioPluginDataBase.resetActionState();
                return true;
            }
            case 18: {
                pSStudioPluginDataBase.resetActionType();
                return true;
            }
            case 19: {
                pSStudioPluginDataBase.resetBeginTime();
                return true;
            }
            case 20: {
                pSStudioPluginDataBase.resetCreateDate();
                return true;
            }
            case 21: {
                pSStudioPluginDataBase.resetCreateMan();
                return true;
            }
            case 22: {
                pSStudioPluginDataBase.resetDownloadUrl();
                return true;
            }
            case 23: {
                pSStudioPluginDataBase.resetEndTime();
                return true;
            }
            case 24: {
                pSStudioPluginDataBase.resetFullResultInfo();
                return true;
            }
            case 25: {
                pSStudioPluginDataBase.resetMemo();
                return true;
            }
            case 26: {
                pSStudioPluginDataBase.resetPPSStudioPluginId();
                return true;
            }
            case 27: {
                pSStudioPluginDataBase.resetPSDevCenterId();
                return true;
            }
            case 28: {
                pSStudioPluginDataBase.resetPSDevCenterName();
                return true;
            }
            case 29: {
                pSStudioPluginDataBase.resetPSDevSlnId();
                return true;
            }
            case 30: {
                pSStudioPluginDataBase.resetPSDevSlnName();
                return true;
            }
            case 31: {
                pSStudioPluginDataBase.resetPSDevSlnSysId();
                return true;
            }
            case 32: {
                pSStudioPluginDataBase.resetPSDevSlnSysName();
                return true;
            }
            case 33: {
                pSStudioPluginDataBase.resetPSDevSlnTemplId();
                return true;
            }
            case 34: {
                pSStudioPluginDataBase.resetPSDevSlnTemplName();
                return true;
            }
            case 35: {
                pSStudioPluginDataBase.resetPSObjId();
                return true;
            }
            case 36: {
                pSStudioPluginDataBase.resetPSObjName();
                return true;
            }
            case 37: {
                pSStudioPluginDataBase.resetPSObjType();
                return true;
            }
            case 38: {
                pSStudioPluginDataBase.resetPSStudioPluginDataId();
                return true;
            }
            case 39: {
                pSStudioPluginDataBase.resetPSStudioPluginDataName();
                return true;
            }
            case 40: {
                pSStudioPluginDataBase.resetPSStudioPluginId();
                return true;
            }
            case 41: {
                pSStudioPluginDataBase.resetPSStudioPluginName();
                return true;
            }
            case 42: {
                pSStudioPluginDataBase.resetUpdateDate();
                return true;
            }
            case 43: {
                pSStudioPluginDataBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSStudioPlugin getPSStudioPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioPlugin();
        }
        if (this.getPSStudioPluginId() == null) {
            return null;
        }
        Integer n = this.objPSStudioPluginLock;
        synchronized (n) {
            if (this.psstudioplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSStudioPluginId(), (Object)this.psstudioplugin.getPSStudioPluginId()) != 0L) {
                this.psstudioplugin = null;
            }
            if (this.psstudioplugin == null) {
                PSStudioPlugin pSStudioPlugin = new PSStudioPlugin();
                pSStudioPlugin.setPSStudioPluginId(this.getPSStudioPluginId());
                PSStudioPluginService pSStudioPluginService = (PSStudioPluginService)ServiceGlobal.getService(PSStudioPluginService.class, (SessionFactory)this.getSessionFactory());
                pSStudioPluginService.autoGet(pSStudioPlugin);
                this.psstudioplugin = pSStudioPlugin;
            }
            return this.psstudioplugin;
        }
    }

    private PSStudioPluginDataBase getProxyEntity() {
        return this.proxyPSStudioPluginDataBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSStudioPluginDataBase = null;
        if (iDataObject != null && iDataObject instanceof PSStudioPluginDataBase) {
            this.proxyPSStudioPluginDataBase = (PSStudioPluginDataBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioPluginDataService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONPARAM, 0);
        fieldIndexMap.put(FIELD_ACTIONPARAM10, 1);
        fieldIndexMap.put(FIELD_ACTIONPARAM11, 2);
        fieldIndexMap.put(FIELD_ACTIONPARAM12, 3);
        fieldIndexMap.put(FIELD_ACTIONPARAM13, 4);
        fieldIndexMap.put(FIELD_ACTIONPARAM14, 5);
        fieldIndexMap.put(FIELD_ACTIONPARAM15, 6);
        fieldIndexMap.put(FIELD_ACTIONPARAM16, 7);
        fieldIndexMap.put(FIELD_ACTIONPARAM2, 8);
        fieldIndexMap.put(FIELD_ACTIONPARAM3, 9);
        fieldIndexMap.put(FIELD_ACTIONPARAM4, 10);
        fieldIndexMap.put(FIELD_ACTIONPARAM5, 11);
        fieldIndexMap.put(FIELD_ACTIONPARAM6, 12);
        fieldIndexMap.put(FIELD_ACTIONPARAM7, 13);
        fieldIndexMap.put(FIELD_ACTIONPARAM8, 14);
        fieldIndexMap.put(FIELD_ACTIONPARAM9, 15);
        fieldIndexMap.put(FIELD_ACTIONRESULT, 16);
        fieldIndexMap.put(FIELD_ACTIONSTATE, 17);
        fieldIndexMap.put(FIELD_ACTIONTYPE, 18);
        fieldIndexMap.put(FIELD_BEGINTIME, 19);
        fieldIndexMap.put(FIELD_CREATEDATE, 20);
        fieldIndexMap.put(FIELD_CREATEMAN, 21);
        fieldIndexMap.put(FIELD_DOWNLOADURL, 22);
        fieldIndexMap.put(FIELD_ENDTIME, 23);
        fieldIndexMap.put(FIELD_FULLRESULTINFO, 24);
        fieldIndexMap.put(FIELD_MEMO, 25);
        fieldIndexMap.put(FIELD_PPSSTUDIOPLUGINID, 26);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 27);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 28);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 29);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 30);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 31);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 32);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLID, 33);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLNAME, 34);
        fieldIndexMap.put(FIELD_PSOBJID, 35);
        fieldIndexMap.put(FIELD_PSOBJNAME, 36);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 37);
        fieldIndexMap.put(FIELD_PSSTUDIOPLUGINDATAID, 38);
        fieldIndexMap.put(FIELD_PSSTUDIOPLUGINDATANAME, 39);
        fieldIndexMap.put(FIELD_PSSTUDIOPLUGINID, 40);
        fieldIndexMap.put(FIELD_PSSTUDIOPLUGINNAME, 41);
        fieldIndexMap.put(FIELD_UPDATEDATE, 42);
        fieldIndexMap.put(FIELD_UPDATEMAN, 43);
    }
}

