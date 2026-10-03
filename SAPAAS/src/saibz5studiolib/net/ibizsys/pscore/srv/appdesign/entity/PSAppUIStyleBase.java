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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUIStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppUIStyleBase.class);
    public static final String FIELD_ACMINCHARS = "ACMINCHARS";
    public static final String FIELD_APPFOLDER = "APPFOLDER";
    public static final String FIELD_APPPKGNAME = "APPPKGNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PFSTYLEPARAM = "PFSTYLEPARAM";
    public static final String FIELD_PSAPPUISTYLEID = "PSAPPUISTYLEID";
    public static final String FIELD_PSAPPUISTYLENAME = "PSAPPUISTYLENAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_ROOTPSAPPVIEWID = "ROOTPSAPPVIEWID";
    public static final String FIELD_ROOTPSAPPVIEWNAME = "ROOTPSAPPVIEWNAME";
    public static final String FIELD_UISTYLE = "UISTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ACMINCHARS = 0;
    private static final int INDEX_APPFOLDER = 1;
    private static final int INDEX_APPPKGNAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_MAINMENUSIDE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PFSTYLEPARAM = 7;
    private static final int INDEX_PSAPPUISTYLEID = 8;
    private static final int INDEX_PSAPPUISTYLENAME = 9;
    private static final int INDEX_PSPFID = 10;
    private static final int INDEX_PSPFNAME = 11;
    private static final int INDEX_PSPFSTYLEID = 12;
    private static final int INDEX_PSPFSTYLENAME = 13;
    private static final int INDEX_PSSYSAPPID = 14;
    private static final int INDEX_PSSYSAPPNAME = 15;
    private static final int INDEX_ROOTPSAPPVIEWID = 16;
    private static final int INDEX_ROOTPSAPPVIEWNAME = 17;
    private static final int INDEX_UISTYLE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppUIStyleBase proxyPSAppUIStyleBase = null;
    private boolean acmincharsDirtyFlag = false;
    private boolean appfolderDirtyFlag = false;
    private boolean apppkgnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean mainmenusideDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pfstyleparamDirtyFlag = false;
    private boolean psappuistyleidDirtyFlag = false;
    private boolean psappuistylenameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean rootpsappviewidDirtyFlag = false;
    private boolean rootpsappviewnameDirtyFlag = false;
    private boolean uistyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="acminchars")
    private Integer acminchars;
    @Column(name="appfolder")
    private String appfolder;
    @Column(name="apppkgname")
    private String apppkgname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="mainmenuside")
    private String mainmenuside;
    @Column(name="memo")
    private String memo;
    @Column(name="pfstyleparam")
    private String pfstyleparam;
    @Column(name="psappuistyleid")
    private String psappuistyleid;
    @Column(name="psappuistylename")
    private String psappuistylename;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="rootpsappviewid")
    private String rootpsappviewid;
    @Column(name="rootpsappviewname")
    private String rootpsappviewname;
    @Column(name="uistyle")
    private String uistyle;
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
    private Integer objRootPSAppViewLock = new Integer(1);
    private PSAppView rootpsappview = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;

    public void setACMinChars(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACMinChars(n);
            return;
        }
        this.acminchars = n;
        this.acmincharsDirtyFlag = true;
    }

    public Integer getACMinChars() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACMinChars();
        }
        return this.acminchars;
    }

    public boolean isACMinCharsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACMinCharsDirty();
        }
        return this.acmincharsDirtyFlag;
    }

    public void resetACMinChars() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACMinChars();
            return;
        }
        this.acmincharsDirtyFlag = false;
        this.acminchars = null;
    }

    public void setAppFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appfolder = string;
        this.appfolderDirtyFlag = true;
    }

    public String getAppFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppFolder();
        }
        return this.appfolder;
    }

    public boolean isAppFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppFolderDirty();
        }
        return this.appfolderDirtyFlag;
    }

    public void resetAppFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppFolder();
            return;
        }
        this.appfolderDirtyFlag = false;
        this.appfolder = null;
    }

    public void setAppPKGName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppPKGName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apppkgname = string;
        this.apppkgnameDirtyFlag = true;
    }

    public String getAppPKGName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppPKGName();
        }
        return this.apppkgname;
    }

    public boolean isAppPKGNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppPKGNameDirty();
        }
        return this.apppkgnameDirtyFlag;
    }

    public void resetAppPKGName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppPKGName();
            return;
        }
        this.apppkgnameDirtyFlag = false;
        this.apppkgname = null;
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

    public void setMainMenuSide(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainMenuSide(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainmenuside = string;
        this.mainmenusideDirtyFlag = true;
    }

    public String getMainMenuSide() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainMenuSide();
        }
        return this.mainmenuside;
    }

    public boolean isMainMenuSideDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainMenuSideDirty();
        }
        return this.mainmenusideDirtyFlag;
    }

    public void resetMainMenuSide() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainMenuSide();
            return;
        }
        this.mainmenusideDirtyFlag = false;
        this.mainmenuside = null;
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

    public void setPFStyleParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPFStyleParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pfstyleparam = string;
        this.pfstyleparamDirtyFlag = true;
    }

    public String getPFStyleParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPFStyleParam();
        }
        return this.pfstyleparam;
    }

    public boolean isPFStyleParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPFStyleParamDirty();
        }
        return this.pfstyleparamDirtyFlag;
    }

    public void resetPFStyleParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPFStyleParam();
            return;
        }
        this.pfstyleparamDirtyFlag = false;
        this.pfstyleparam = null;
    }

    public void setPSAppUIStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUIStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappuistyleid = string;
        this.psappuistyleidDirtyFlag = true;
    }

    public String getPSAppUIStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUIStyleId();
        }
        return this.psappuistyleid;
    }

    public boolean isPSAppUIStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUIStyleIdDirty();
        }
        return this.psappuistyleidDirtyFlag;
    }

    public void resetPSAppUIStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUIStyleId();
            return;
        }
        this.psappuistyleidDirtyFlag = false;
        this.psappuistyleid = null;
    }

    public void setPSAppUIStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUIStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappuistylename = string;
        this.psappuistylenameDirtyFlag = true;
    }

    public String getPSAppUIStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUIStyleName();
        }
        return this.psappuistylename;
    }

    public boolean isPSAppUIStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUIStyleNameDirty();
        }
        return this.psappuistylenameDirtyFlag;
    }

    public void resetPSAppUIStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUIStyleName();
            return;
        }
        this.psappuistylenameDirtyFlag = false;
        this.psappuistylename = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
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

    public void setRootPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rootpsappviewid = string;
        this.rootpsappviewidDirtyFlag = true;
    }

    public String getRootPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootPSAppViewId();
        }
        return this.rootpsappviewid;
    }

    public boolean isRootPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootPSAppViewIdDirty();
        }
        return this.rootpsappviewidDirtyFlag;
    }

    public void resetRootPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootPSAppViewId();
            return;
        }
        this.rootpsappviewidDirtyFlag = false;
        this.rootpsappviewid = null;
    }

    public void setRootPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rootpsappviewname = string;
        this.rootpsappviewnameDirtyFlag = true;
    }

    public String getRootPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootPSAppViewName();
        }
        return this.rootpsappviewname;
    }

    public boolean isRootPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootPSAppViewNameDirty();
        }
        return this.rootpsappviewnameDirtyFlag;
    }

    public void resetRootPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootPSAppViewName();
            return;
        }
        this.rootpsappviewnameDirtyFlag = false;
        this.rootpsappviewname = null;
    }

    public void setUIStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uistyle = string;
        this.uistyleDirtyFlag = true;
    }

    public String getUIStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIStyle();
        }
        return this.uistyle;
    }

    public boolean isUIStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIStyleDirty();
        }
        return this.uistyleDirtyFlag;
    }

    public void resetUIStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIStyle();
            return;
        }
        this.uistyleDirtyFlag = false;
        this.uistyle = null;
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
        PSAppUIStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppUIStyleBase pSAppUIStyleBase) {
        pSAppUIStyleBase.resetACMinChars();
        pSAppUIStyleBase.resetAppFolder();
        pSAppUIStyleBase.resetAppPKGName();
        pSAppUIStyleBase.resetCreateDate();
        pSAppUIStyleBase.resetCreateMan();
        pSAppUIStyleBase.resetMainMenuSide();
        pSAppUIStyleBase.resetMemo();
        pSAppUIStyleBase.resetPFStyleParam();
        pSAppUIStyleBase.resetPSAppUIStyleId();
        pSAppUIStyleBase.resetPSAppUIStyleName();
        pSAppUIStyleBase.resetPSPFId();
        pSAppUIStyleBase.resetPSPFName();
        pSAppUIStyleBase.resetPSPFStyleId();
        pSAppUIStyleBase.resetPSPFStyleName();
        pSAppUIStyleBase.resetPSSysAppId();
        pSAppUIStyleBase.resetPSSysAppName();
        pSAppUIStyleBase.resetRootPSAppViewId();
        pSAppUIStyleBase.resetRootPSAppViewName();
        pSAppUIStyleBase.resetUIStyle();
        pSAppUIStyleBase.resetUpdateDate();
        pSAppUIStyleBase.resetUpdateMan();
        pSAppUIStyleBase.resetUserCat();
        pSAppUIStyleBase.resetUserTag();
        pSAppUIStyleBase.resetUserTag2();
        pSAppUIStyleBase.resetUserTag3();
        pSAppUIStyleBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isACMinCharsDirty()) {
            hashMap.put(FIELD_ACMINCHARS, this.getACMinChars());
        }
        if (!bl || this.isAppFolderDirty()) {
            hashMap.put(FIELD_APPFOLDER, this.getAppFolder());
        }
        if (!bl || this.isAppPKGNameDirty()) {
            hashMap.put(FIELD_APPPKGNAME, this.getAppPKGName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMainMenuSideDirty()) {
            hashMap.put(FIELD_MAINMENUSIDE, this.getMainMenuSide());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPFStyleParamDirty()) {
            hashMap.put(FIELD_PFSTYLEPARAM, this.getPFStyleParam());
        }
        if (!bl || this.isPSAppUIStyleIdDirty()) {
            hashMap.put(FIELD_PSAPPUISTYLEID, this.getPSAppUIStyleId());
        }
        if (!bl || this.isPSAppUIStyleNameDirty()) {
            hashMap.put(FIELD_PSAPPUISTYLENAME, this.getPSAppUIStyleName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isRootPSAppViewIdDirty()) {
            hashMap.put(FIELD_ROOTPSAPPVIEWID, this.getRootPSAppViewId());
        }
        if (!bl || this.isRootPSAppViewNameDirty()) {
            hashMap.put(FIELD_ROOTPSAPPVIEWNAME, this.getRootPSAppViewName());
        }
        if (!bl || this.isUIStyleDirty()) {
            hashMap.put(FIELD_UISTYLE, this.getUIStyle());
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
        return PSAppUIStyleBase.get(this, n);
    }

    private static Object get(PSAppUIStyleBase pSAppUIStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUIStyleBase.getACMinChars();
            }
            case 1: {
                return pSAppUIStyleBase.getAppFolder();
            }
            case 2: {
                return pSAppUIStyleBase.getAppPKGName();
            }
            case 3: {
                return pSAppUIStyleBase.getCreateDate();
            }
            case 4: {
                return pSAppUIStyleBase.getCreateMan();
            }
            case 5: {
                return pSAppUIStyleBase.getMainMenuSide();
            }
            case 6: {
                return pSAppUIStyleBase.getMemo();
            }
            case 7: {
                return pSAppUIStyleBase.getPFStyleParam();
            }
            case 8: {
                return pSAppUIStyleBase.getPSAppUIStyleId();
            }
            case 9: {
                return pSAppUIStyleBase.getPSAppUIStyleName();
            }
            case 10: {
                return pSAppUIStyleBase.getPSPFId();
            }
            case 11: {
                return pSAppUIStyleBase.getPSPFName();
            }
            case 12: {
                return pSAppUIStyleBase.getPSPFStyleId();
            }
            case 13: {
                return pSAppUIStyleBase.getPSPFStyleName();
            }
            case 14: {
                return pSAppUIStyleBase.getPSSysAppId();
            }
            case 15: {
                return pSAppUIStyleBase.getPSSysAppName();
            }
            case 16: {
                return pSAppUIStyleBase.getRootPSAppViewId();
            }
            case 17: {
                return pSAppUIStyleBase.getRootPSAppViewName();
            }
            case 18: {
                return pSAppUIStyleBase.getUIStyle();
            }
            case 19: {
                return pSAppUIStyleBase.getUpdateDate();
            }
            case 20: {
                return pSAppUIStyleBase.getUpdateMan();
            }
            case 21: {
                return pSAppUIStyleBase.getUserCat();
            }
            case 22: {
                return pSAppUIStyleBase.getUserTag();
            }
            case 23: {
                return pSAppUIStyleBase.getUserTag2();
            }
            case 24: {
                return pSAppUIStyleBase.getUserTag3();
            }
            case 25: {
                return pSAppUIStyleBase.getUserTag4();
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
        PSAppUIStyleBase.set(this, n, object);
    }

    private static void set(PSAppUIStyleBase pSAppUIStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppUIStyleBase.setACMinChars(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSAppUIStyleBase.setAppFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppUIStyleBase.setAppPKGName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppUIStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSAppUIStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppUIStyleBase.setMainMenuSide(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppUIStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppUIStyleBase.setPFStyleParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppUIStyleBase.setPSAppUIStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppUIStyleBase.setPSAppUIStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppUIStyleBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppUIStyleBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppUIStyleBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppUIStyleBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppUIStyleBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppUIStyleBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppUIStyleBase.setRootPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppUIStyleBase.setRootPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppUIStyleBase.setUIStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppUIStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSAppUIStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppUIStyleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppUIStyleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppUIStyleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppUIStyleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppUIStyleBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSAppUIStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSAppUIStyleBase pSAppUIStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUIStyleBase.getACMinChars() == null;
            }
            case 1: {
                return pSAppUIStyleBase.getAppFolder() == null;
            }
            case 2: {
                return pSAppUIStyleBase.getAppPKGName() == null;
            }
            case 3: {
                return pSAppUIStyleBase.getCreateDate() == null;
            }
            case 4: {
                return pSAppUIStyleBase.getCreateMan() == null;
            }
            case 5: {
                return pSAppUIStyleBase.getMainMenuSide() == null;
            }
            case 6: {
                return pSAppUIStyleBase.getMemo() == null;
            }
            case 7: {
                return pSAppUIStyleBase.getPFStyleParam() == null;
            }
            case 8: {
                return pSAppUIStyleBase.getPSAppUIStyleId() == null;
            }
            case 9: {
                return pSAppUIStyleBase.getPSAppUIStyleName() == null;
            }
            case 10: {
                return pSAppUIStyleBase.getPSPFId() == null;
            }
            case 11: {
                return pSAppUIStyleBase.getPSPFName() == null;
            }
            case 12: {
                return pSAppUIStyleBase.getPSPFStyleId() == null;
            }
            case 13: {
                return pSAppUIStyleBase.getPSPFStyleName() == null;
            }
            case 14: {
                return pSAppUIStyleBase.getPSSysAppId() == null;
            }
            case 15: {
                return pSAppUIStyleBase.getPSSysAppName() == null;
            }
            case 16: {
                return pSAppUIStyleBase.getRootPSAppViewId() == null;
            }
            case 17: {
                return pSAppUIStyleBase.getRootPSAppViewName() == null;
            }
            case 18: {
                return pSAppUIStyleBase.getUIStyle() == null;
            }
            case 19: {
                return pSAppUIStyleBase.getUpdateDate() == null;
            }
            case 20: {
                return pSAppUIStyleBase.getUpdateMan() == null;
            }
            case 21: {
                return pSAppUIStyleBase.getUserCat() == null;
            }
            case 22: {
                return pSAppUIStyleBase.getUserTag() == null;
            }
            case 23: {
                return pSAppUIStyleBase.getUserTag2() == null;
            }
            case 24: {
                return pSAppUIStyleBase.getUserTag3() == null;
            }
            case 25: {
                return pSAppUIStyleBase.getUserTag4() == null;
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
        return PSAppUIStyleBase.contains(this, n);
    }

    private static boolean contains(PSAppUIStyleBase pSAppUIStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUIStyleBase.isACMinCharsDirty();
            }
            case 1: {
                return pSAppUIStyleBase.isAppFolderDirty();
            }
            case 2: {
                return pSAppUIStyleBase.isAppPKGNameDirty();
            }
            case 3: {
                return pSAppUIStyleBase.isCreateDateDirty();
            }
            case 4: {
                return pSAppUIStyleBase.isCreateManDirty();
            }
            case 5: {
                return pSAppUIStyleBase.isMainMenuSideDirty();
            }
            case 6: {
                return pSAppUIStyleBase.isMemoDirty();
            }
            case 7: {
                return pSAppUIStyleBase.isPFStyleParamDirty();
            }
            case 8: {
                return pSAppUIStyleBase.isPSAppUIStyleIdDirty();
            }
            case 9: {
                return pSAppUIStyleBase.isPSAppUIStyleNameDirty();
            }
            case 10: {
                return pSAppUIStyleBase.isPSPFIdDirty();
            }
            case 11: {
                return pSAppUIStyleBase.isPSPFNameDirty();
            }
            case 12: {
                return pSAppUIStyleBase.isPSPFStyleIdDirty();
            }
            case 13: {
                return pSAppUIStyleBase.isPSPFStyleNameDirty();
            }
            case 14: {
                return pSAppUIStyleBase.isPSSysAppIdDirty();
            }
            case 15: {
                return pSAppUIStyleBase.isPSSysAppNameDirty();
            }
            case 16: {
                return pSAppUIStyleBase.isRootPSAppViewIdDirty();
            }
            case 17: {
                return pSAppUIStyleBase.isRootPSAppViewNameDirty();
            }
            case 18: {
                return pSAppUIStyleBase.isUIStyleDirty();
            }
            case 19: {
                return pSAppUIStyleBase.isUpdateDateDirty();
            }
            case 20: {
                return pSAppUIStyleBase.isUpdateManDirty();
            }
            case 21: {
                return pSAppUIStyleBase.isUserCatDirty();
            }
            case 22: {
                return pSAppUIStyleBase.isUserTagDirty();
            }
            case 23: {
                return pSAppUIStyleBase.isUserTag2Dirty();
            }
            case 24: {
                return pSAppUIStyleBase.isUserTag3Dirty();
            }
            case 25: {
                return pSAppUIStyleBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppUIStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppUIStyleBase pSAppUIStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppUIStyleBase.getACMinChars() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"acminchars", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getACMinChars()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getAppFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appfolder", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getAppFolder()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getAppPKGName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apppkgname", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getAppPKGName()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getMainMenuSide() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainmenuside", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getMainMenuSide()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPFStyleParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pfstyleparam", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPFStyleParam()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPSAppUIStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappuistyleid", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPSAppUIStyleId()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPSAppUIStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappuistylename", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPSAppUIStyleName()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getRootPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootpsappviewid", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getRootPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getRootPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootpsappviewname", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getRootPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getUIStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uistyle", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getUIStyle()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppUIStyleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppUIStyleBase.getJSONValue((Object)pSAppUIStyleBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppUIStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppUIStyleBase pSAppUIStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppUIStyleBase.getACMinChars() != null) {
            object = pSAppUIStyleBase.getACMinChars();
            xmlNode.setAttribute(FIELD_ACMINCHARS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUIStyleBase.getAppFolder() != null) {
            object = pSAppUIStyleBase.getAppFolder();
            xmlNode.setAttribute(FIELD_APPFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getAppPKGName() != null) {
            object = pSAppUIStyleBase.getAppPKGName();
            xmlNode.setAttribute(FIELD_APPPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getCreateDate() != null) {
            object = pSAppUIStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUIStyleBase.getCreateMan() != null) {
            object = pSAppUIStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getMainMenuSide() != null) {
            object = pSAppUIStyleBase.getMainMenuSide();
            xmlNode.setAttribute(FIELD_MAINMENUSIDE, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getMemo() != null) {
            object = pSAppUIStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPFStyleParam() != null) {
            object = pSAppUIStyleBase.getPFStyleParam();
            xmlNode.setAttribute(FIELD_PFSTYLEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPSAppUIStyleId() != null) {
            object = pSAppUIStyleBase.getPSAppUIStyleId();
            xmlNode.setAttribute(FIELD_PSAPPUISTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPSAppUIStyleName() != null) {
            object = pSAppUIStyleBase.getPSAppUIStyleName();
            xmlNode.setAttribute(FIELD_PSAPPUISTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPSPFId() != null) {
            object = pSAppUIStyleBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPSPFName() != null) {
            object = pSAppUIStyleBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPSPFStyleId() != null) {
            object = pSAppUIStyleBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPSPFStyleName() != null) {
            object = pSAppUIStyleBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPSSysAppId() != null) {
            object = pSAppUIStyleBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getPSSysAppName() != null) {
            object = pSAppUIStyleBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getRootPSAppViewId() != null) {
            object = pSAppUIStyleBase.getRootPSAppViewId();
            xmlNode.setAttribute(FIELD_ROOTPSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getRootPSAppViewName() != null) {
            object = pSAppUIStyleBase.getRootPSAppViewName();
            xmlNode.setAttribute(FIELD_ROOTPSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getUIStyle() != null) {
            object = pSAppUIStyleBase.getUIStyle();
            xmlNode.setAttribute(FIELD_UISTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getUpdateDate() != null) {
            object = pSAppUIStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUIStyleBase.getUpdateMan() != null) {
            object = pSAppUIStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getUserCat() != null) {
            object = pSAppUIStyleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getUserTag() != null) {
            object = pSAppUIStyleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getUserTag2() != null) {
            object = pSAppUIStyleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getUserTag3() != null) {
            object = pSAppUIStyleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppUIStyleBase.getUserTag4() != null) {
            object = pSAppUIStyleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppUIStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppUIStyleBase pSAppUIStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppUIStyleBase.isACMinCharsDirty() && (bl || pSAppUIStyleBase.getACMinChars() != null)) {
            iDataObject.set(FIELD_ACMINCHARS, (Object)pSAppUIStyleBase.getACMinChars());
        }
        if (pSAppUIStyleBase.isAppFolderDirty() && (bl || pSAppUIStyleBase.getAppFolder() != null)) {
            iDataObject.set(FIELD_APPFOLDER, (Object)pSAppUIStyleBase.getAppFolder());
        }
        if (pSAppUIStyleBase.isAppPKGNameDirty() && (bl || pSAppUIStyleBase.getAppPKGName() != null)) {
            iDataObject.set(FIELD_APPPKGNAME, (Object)pSAppUIStyleBase.getAppPKGName());
        }
        if (pSAppUIStyleBase.isCreateDateDirty() && (bl || pSAppUIStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppUIStyleBase.getCreateDate());
        }
        if (pSAppUIStyleBase.isCreateManDirty() && (bl || pSAppUIStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppUIStyleBase.getCreateMan());
        }
        if (pSAppUIStyleBase.isMainMenuSideDirty() && (bl || pSAppUIStyleBase.getMainMenuSide() != null)) {
            iDataObject.set(FIELD_MAINMENUSIDE, (Object)pSAppUIStyleBase.getMainMenuSide());
        }
        if (pSAppUIStyleBase.isMemoDirty() && (bl || pSAppUIStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppUIStyleBase.getMemo());
        }
        if (pSAppUIStyleBase.isPFStyleParamDirty() && (bl || pSAppUIStyleBase.getPFStyleParam() != null)) {
            iDataObject.set(FIELD_PFSTYLEPARAM, (Object)pSAppUIStyleBase.getPFStyleParam());
        }
        if (pSAppUIStyleBase.isPSAppUIStyleIdDirty() && (bl || pSAppUIStyleBase.getPSAppUIStyleId() != null)) {
            iDataObject.set(FIELD_PSAPPUISTYLEID, (Object)pSAppUIStyleBase.getPSAppUIStyleId());
        }
        if (pSAppUIStyleBase.isPSAppUIStyleNameDirty() && (bl || pSAppUIStyleBase.getPSAppUIStyleName() != null)) {
            iDataObject.set(FIELD_PSAPPUISTYLENAME, (Object)pSAppUIStyleBase.getPSAppUIStyleName());
        }
        if (pSAppUIStyleBase.isPSPFIdDirty() && (bl || pSAppUIStyleBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSAppUIStyleBase.getPSPFId());
        }
        if (pSAppUIStyleBase.isPSPFNameDirty() && (bl || pSAppUIStyleBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSAppUIStyleBase.getPSPFName());
        }
        if (pSAppUIStyleBase.isPSPFStyleIdDirty() && (bl || pSAppUIStyleBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSAppUIStyleBase.getPSPFStyleId());
        }
        if (pSAppUIStyleBase.isPSPFStyleNameDirty() && (bl || pSAppUIStyleBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSAppUIStyleBase.getPSPFStyleName());
        }
        if (pSAppUIStyleBase.isPSSysAppIdDirty() && (bl || pSAppUIStyleBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppUIStyleBase.getPSSysAppId());
        }
        if (pSAppUIStyleBase.isPSSysAppNameDirty() && (bl || pSAppUIStyleBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppUIStyleBase.getPSSysAppName());
        }
        if (pSAppUIStyleBase.isRootPSAppViewIdDirty() && (bl || pSAppUIStyleBase.getRootPSAppViewId() != null)) {
            iDataObject.set(FIELD_ROOTPSAPPVIEWID, (Object)pSAppUIStyleBase.getRootPSAppViewId());
        }
        if (pSAppUIStyleBase.isRootPSAppViewNameDirty() && (bl || pSAppUIStyleBase.getRootPSAppViewName() != null)) {
            iDataObject.set(FIELD_ROOTPSAPPVIEWNAME, (Object)pSAppUIStyleBase.getRootPSAppViewName());
        }
        if (pSAppUIStyleBase.isUIStyleDirty() && (bl || pSAppUIStyleBase.getUIStyle() != null)) {
            iDataObject.set(FIELD_UISTYLE, (Object)pSAppUIStyleBase.getUIStyle());
        }
        if (pSAppUIStyleBase.isUpdateDateDirty() && (bl || pSAppUIStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppUIStyleBase.getUpdateDate());
        }
        if (pSAppUIStyleBase.isUpdateManDirty() && (bl || pSAppUIStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppUIStyleBase.getUpdateMan());
        }
        if (pSAppUIStyleBase.isUserCatDirty() && (bl || pSAppUIStyleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppUIStyleBase.getUserCat());
        }
        if (pSAppUIStyleBase.isUserTagDirty() && (bl || pSAppUIStyleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppUIStyleBase.getUserTag());
        }
        if (pSAppUIStyleBase.isUserTag2Dirty() && (bl || pSAppUIStyleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppUIStyleBase.getUserTag2());
        }
        if (pSAppUIStyleBase.isUserTag3Dirty() && (bl || pSAppUIStyleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppUIStyleBase.getUserTag3());
        }
        if (pSAppUIStyleBase.isUserTag4Dirty() && (bl || pSAppUIStyleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppUIStyleBase.getUserTag4());
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
        return PSAppUIStyleBase.remove(this, n);
    }

    private static boolean remove(PSAppUIStyleBase pSAppUIStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppUIStyleBase.resetACMinChars();
                return true;
            }
            case 1: {
                pSAppUIStyleBase.resetAppFolder();
                return true;
            }
            case 2: {
                pSAppUIStyleBase.resetAppPKGName();
                return true;
            }
            case 3: {
                pSAppUIStyleBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSAppUIStyleBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSAppUIStyleBase.resetMainMenuSide();
                return true;
            }
            case 6: {
                pSAppUIStyleBase.resetMemo();
                return true;
            }
            case 7: {
                pSAppUIStyleBase.resetPFStyleParam();
                return true;
            }
            case 8: {
                pSAppUIStyleBase.resetPSAppUIStyleId();
                return true;
            }
            case 9: {
                pSAppUIStyleBase.resetPSAppUIStyleName();
                return true;
            }
            case 10: {
                pSAppUIStyleBase.resetPSPFId();
                return true;
            }
            case 11: {
                pSAppUIStyleBase.resetPSPFName();
                return true;
            }
            case 12: {
                pSAppUIStyleBase.resetPSPFStyleId();
                return true;
            }
            case 13: {
                pSAppUIStyleBase.resetPSPFStyleName();
                return true;
            }
            case 14: {
                pSAppUIStyleBase.resetPSSysAppId();
                return true;
            }
            case 15: {
                pSAppUIStyleBase.resetPSSysAppName();
                return true;
            }
            case 16: {
                pSAppUIStyleBase.resetRootPSAppViewId();
                return true;
            }
            case 17: {
                pSAppUIStyleBase.resetRootPSAppViewName();
                return true;
            }
            case 18: {
                pSAppUIStyleBase.resetUIStyle();
                return true;
            }
            case 19: {
                pSAppUIStyleBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSAppUIStyleBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSAppUIStyleBase.resetUserCat();
                return true;
            }
            case 22: {
                pSAppUIStyleBase.resetUserTag();
                return true;
            }
            case 23: {
                pSAppUIStyleBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSAppUIStyleBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSAppUIStyleBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getRootPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootPSAppView();
        }
        if (this.getRootPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objRootPSAppViewLock;
        synchronized (n) {
            if (this.rootpsappview != null && DataTypeHelper.compare((int)25, (Object)this.getRootPSAppViewId(), (Object)this.rootpsappview.getPSAppViewId()) != 0L) {
                this.rootpsappview = null;
            }
            if (this.rootpsappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getRootPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet(pSAppView);
                this.rootpsappview = pSAppView;
            }
            return this.rootpsappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
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

    private PSAppUIStyleBase getProxyEntity() {
        return this.proxyPSAppUIStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppUIStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppUIStyleBase) {
            this.proxyPSAppUIStyleBase = (PSAppUIStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACMINCHARS, 0);
        fieldIndexMap.put(FIELD_APPFOLDER, 1);
        fieldIndexMap.put(FIELD_APPPKGNAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_MAINMENUSIDE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PFSTYLEPARAM, 7);
        fieldIndexMap.put(FIELD_PSAPPUISTYLEID, 8);
        fieldIndexMap.put(FIELD_PSAPPUISTYLENAME, 9);
        fieldIndexMap.put(FIELD_PSPFID, 10);
        fieldIndexMap.put(FIELD_PSPFNAME, 11);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 12);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 15);
        fieldIndexMap.put(FIELD_ROOTPSAPPVIEWID, 16);
        fieldIndexMap.put(FIELD_ROOTPSAPPVIEWNAME, 17);
        fieldIndexMap.put(FIELD_UISTYLE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
    }
}

