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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppVCInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVerInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppVCInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppViewInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaAppViewInstBase.class);
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_DYNAVIEWPARAM = "DYNAVIEWPARAM";
    public static final String FIELD_DYNAVIEWPARAM2 = "DYNAVIEWPARAM2";
    public static final String FIELD_DYNAVIEWPARAM3 = "DYNAVIEWPARAM3";
    public static final String FIELD_DYNAVIEWPARAM4 = "DYNAVIEWPARAM4";
    public static final String FIELD_DYNAVIEWPARAM5 = "DYNAVIEWPARAM5";
    public static final String FIELD_DYNAVIEWPARAM6 = "DYNAVIEWPARAM6";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBVIEWFLAG = "MOBVIEWFLAG";
    public static final String FIELD_PDVTPARAM = "PDVTPARAM";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEVIEWTYPE";
    public static final String FIELD_PSDYNAAPPID = "PSDYNAAPPID";
    public static final String FIELD_PSDYNAAPPNAME = "PSDYNAAPPNAME";
    public static final String FIELD_PSDYNAAPPVIEWID = "PSDYNAAPPVIEWID";
    public static final String FIELD_PSDYNAAPPVIEWINSTID = "PSDYNAAPPVIEWINSTID";
    public static final String FIELD_PSDYNAAPPVIEWINSTNAME = "PSDYNAAPPVIEWINSTNAME";
    public static final String FIELD_PSDYNAAPPVIEWNAME = "PSDYNAAPPVIEWNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String FIELD_PSDYNAWFVERINSTID = "PSDYNAWFVERINSTID";
    public static final String FIELD_PSDYNAWFVERINSTNAME = "PSDYNAWFVERINSTNAME";
    public static final String FIELD_SUBCAPTION = "SUBCAPTION";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWACTIONS = "VIEWACTIONS";
    public static final String FIELD_VIEWPARAM = "VIEWPARAM";
    public static final String FIELD_VIEWPARAM2 = "VIEWPARAM2";
    public static final String FIELD_VIEWPARAM5 = "VIEWPARAM5";
    public static final String FIELD_VIEWPARAM6 = "VIEWPARAM6";
    public static final String FIELD_WFVIEWPARAM = "WFVIEWPARAM";
    public static final String FIELD_WFVIEWPARAM2 = "WFVIEWPARAM2";
    public static final String FIELD_WFVIEWPARAM3 = "WFVIEWPARAM3";
    public static final String FIELD_WFVIEWPARAM4 = "WFVIEWPARAM4";
    private static final int INDEX_CAPTION = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODEL = 3;
    private static final int INDEX_DYNAVIEWPARAM = 4;
    private static final int INDEX_DYNAVIEWPARAM2 = 5;
    private static final int INDEX_DYNAVIEWPARAM3 = 6;
    private static final int INDEX_DYNAVIEWPARAM4 = 7;
    private static final int INDEX_DYNAVIEWPARAM5 = 8;
    private static final int INDEX_DYNAVIEWPARAM6 = 9;
    private static final int INDEX_ENABLEVIEWACTIONS = 10;
    private static final int INDEX_INSTVER = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_MOBVIEWFLAG = 13;
    private static final int INDEX_PDVTPARAM = 14;
    private static final int INDEX_PREDEFINEDVIEWTYPE = 15;
    private static final int INDEX_PSDYNAAPPID = 16;
    private static final int INDEX_PSDYNAAPPNAME = 17;
    private static final int INDEX_PSDYNAAPPVIEWID = 18;
    private static final int INDEX_PSDYNAAPPVIEWINSTID = 19;
    private static final int INDEX_PSDYNAAPPVIEWINSTNAME = 20;
    private static final int INDEX_PSDYNAAPPVIEWNAME = 21;
    private static final int INDEX_PSDYNAINSTID = 22;
    private static final int INDEX_PSDYNAINSTNAME = 23;
    private static final int INDEX_PSDYNAWFVERINSTID = 24;
    private static final int INDEX_PSDYNAWFVERINSTNAME = 25;
    private static final int INDEX_SUBCAPTION = 26;
    private static final int INDEX_TITLE = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_VIEWACTIONS = 30;
    private static final int INDEX_VIEWPARAM = 31;
    private static final int INDEX_VIEWPARAM2 = 32;
    private static final int INDEX_VIEWPARAM5 = 33;
    private static final int INDEX_VIEWPARAM6 = 34;
    private static final int INDEX_WFVIEWPARAM = 35;
    private static final int INDEX_WFVIEWPARAM2 = 36;
    private static final int INDEX_WFVIEWPARAM3 = 37;
    private static final int INDEX_WFVIEWPARAM4 = 38;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaAppViewInstBase proxyPSDynaAppViewInstBase = null;
    private boolean captionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean dynaviewparamDirtyFlag = false;
    private boolean dynaviewparam2DirtyFlag = false;
    private boolean dynaviewparam3DirtyFlag = false;
    private boolean dynaviewparam4DirtyFlag = false;
    private boolean dynaviewparam5DirtyFlag = false;
    private boolean dynaviewparam6DirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobviewflagDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean psdynaappidDirtyFlag = false;
    private boolean psdynaappnameDirtyFlag = false;
    private boolean psdynaappviewidDirtyFlag = false;
    private boolean psdynaappviewinstidDirtyFlag = false;
    private boolean psdynaappviewinstnameDirtyFlag = false;
    private boolean psdynaappviewnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynainstnameDirtyFlag = false;
    private boolean psdynawfverinstidDirtyFlag = false;
    private boolean psdynawfverinstnameDirtyFlag = false;
    private boolean subcaptionDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewactionsDirtyFlag = false;
    private boolean viewparamDirtyFlag = false;
    private boolean viewparam2DirtyFlag = false;
    private boolean viewparam5DirtyFlag = false;
    private boolean viewparam6DirtyFlag = false;
    private boolean wfviewparamDirtyFlag = false;
    private boolean wfviewparam2DirtyFlag = false;
    private boolean wfviewparam3DirtyFlag = false;
    private boolean wfviewparam4DirtyFlag = false;
    @Column(name="caption")
    private String caption;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="dynaviewparam")
    private String dynaviewparam;
    @Column(name="dynaviewparam2")
    private String dynaviewparam2;
    @Column(name="dynaviewparam3")
    private String dynaviewparam3;
    @Column(name="dynaviewparam4")
    private String dynaviewparam4;
    @Column(name="dynaviewparam5")
    private String dynaviewparam5;
    @Column(name="dynaviewparam6")
    private String dynaviewparam6;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="instver")
    private Integer instver;
    @Column(name="memo")
    private String memo;
    @Column(name="mobviewflag")
    private Integer mobviewflag;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="psdynaappid")
    private String psdynaappid;
    @Column(name="psdynaappname")
    private String psdynaappname;
    @Column(name="psdynaappviewid")
    private String psdynaappviewid;
    @Column(name="psdynaappviewinstid")
    private String psdynaappviewinstid;
    @Column(name="psdynaappviewinstname")
    private String psdynaappviewinstname;
    @Column(name="psdynaappviewname")
    private String psdynaappviewname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynainstname")
    private String psdynainstname;
    @Column(name="psdynawfverinstid")
    private String psdynawfverinstid;
    @Column(name="psdynawfverinstname")
    private String psdynawfverinstname;
    @Column(name="subcaption")
    private String subcaption;
    @Column(name="title")
    private String title;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewactions")
    private Integer viewactions;
    @Column(name="viewparam")
    private String viewparam;
    @Column(name="viewparam2")
    private String viewparam2;
    @Column(name="viewparam5")
    private Integer viewparam5;
    @Column(name="viewparam6")
    private Integer viewparam6;
    @Column(name="wfviewparam")
    private Integer wfviewparam;
    @Column(name="wfviewparam2")
    private Integer wfviewparam2;
    @Column(name="wfviewparam3")
    private String wfviewparam3;
    @Column(name="wfviewparam4")
    private String wfviewparam4;
    private Integer objPSDynaAppViewLock = new Integer(1);
    private PSDynaAppView psdynaappview = null;
    private Integer objPSDynaAppLock = new Integer(1);
    private PSDynaApp psdynaapp = null;
    private Integer objPSDynaInstLock = new Integer(1);
    private PSDynaInst psdynainst = null;
    private Integer objPSDynaWFVerInstLock = new Integer(1);
    private PSDynaWFVerInst psdynawfverinst = null;
    private Integer objPSDynaAppVCInstsLock = new Integer(1);
    private ArrayList<PSDynaAppVCInst> psdynaappvcinsts = null;

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

    public void setDynaModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodel = string;
        this.dynamodelDirtyFlag = true;
    }

    public String getDynaModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    public boolean isDynaModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    public void resetDynaModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }

    public void setDynaViewParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaViewParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaviewparam = string;
        this.dynaviewparamDirtyFlag = true;
    }

    public String getDynaViewParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaViewParam();
        }
        return this.dynaviewparam;
    }

    public boolean isDynaViewParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaViewParamDirty();
        }
        return this.dynaviewparamDirtyFlag;
    }

    public void resetDynaViewParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaViewParam();
            return;
        }
        this.dynaviewparamDirtyFlag = false;
        this.dynaviewparam = null;
    }

    public void setDynaViewParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaViewParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaviewparam2 = string;
        this.dynaviewparam2DirtyFlag = true;
    }

    public String getDynaViewParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaViewParam2();
        }
        return this.dynaviewparam2;
    }

    public boolean isDynaViewParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaViewParam2Dirty();
        }
        return this.dynaviewparam2DirtyFlag;
    }

    public void resetDynaViewParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaViewParam2();
            return;
        }
        this.dynaviewparam2DirtyFlag = false;
        this.dynaviewparam2 = null;
    }

    public void setDynaViewParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaViewParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaviewparam3 = string;
        this.dynaviewparam3DirtyFlag = true;
    }

    public String getDynaViewParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaViewParam3();
        }
        return this.dynaviewparam3;
    }

    public boolean isDynaViewParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaViewParam3Dirty();
        }
        return this.dynaviewparam3DirtyFlag;
    }

    public void resetDynaViewParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaViewParam3();
            return;
        }
        this.dynaviewparam3DirtyFlag = false;
        this.dynaviewparam3 = null;
    }

    public void setDynaViewParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaViewParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaviewparam4 = string;
        this.dynaviewparam4DirtyFlag = true;
    }

    public String getDynaViewParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaViewParam4();
        }
        return this.dynaviewparam4;
    }

    public boolean isDynaViewParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaViewParam4Dirty();
        }
        return this.dynaviewparam4DirtyFlag;
    }

    public void resetDynaViewParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaViewParam4();
            return;
        }
        this.dynaviewparam4DirtyFlag = false;
        this.dynaviewparam4 = null;
    }

    public void setDynaViewParam5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaViewParam5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaviewparam5 = string;
        this.dynaviewparam5DirtyFlag = true;
    }

    public String getDynaViewParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaViewParam5();
        }
        return this.dynaviewparam5;
    }

    public boolean isDynaViewParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaViewParam5Dirty();
        }
        return this.dynaviewparam5DirtyFlag;
    }

    public void resetDynaViewParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaViewParam5();
            return;
        }
        this.dynaviewparam5DirtyFlag = false;
        this.dynaviewparam5 = null;
    }

    public void setDynaViewParam6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaViewParam6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaviewparam6 = string;
        this.dynaviewparam6DirtyFlag = true;
    }

    public String getDynaViewParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaViewParam6();
        }
        return this.dynaviewparam6;
    }

    public boolean isDynaViewParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaViewParam6Dirty();
        }
        return this.dynaviewparam6DirtyFlag;
    }

    public void resetDynaViewParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaViewParam6();
            return;
        }
        this.dynaviewparam6DirtyFlag = false;
        this.dynaviewparam6 = null;
    }

    public void setEnableViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableViewActions(n);
            return;
        }
        this.enableviewactions = n;
        this.enableviewactionsDirtyFlag = true;
    }

    public Integer getEnableViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableViewActions();
        }
        return this.enableviewactions;
    }

    public boolean isEnableViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableViewActionsDirty();
        }
        return this.enableviewactionsDirtyFlag;
    }

    public void resetEnableViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableViewActions();
            return;
        }
        this.enableviewactionsDirtyFlag = false;
        this.enableviewactions = null;
    }

    public void setInstVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(n);
            return;
        }
        this.instver = n;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
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

    public void setMobViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobViewFlag(n);
            return;
        }
        this.mobviewflag = n;
        this.mobviewflagDirtyFlag = true;
    }

    public Integer getMobViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobViewFlag();
        }
        return this.mobviewflag;
    }

    public boolean isMobViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobViewFlagDirty();
        }
        return this.mobviewflagDirtyFlag;
    }

    public void resetMobViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobViewFlag();
            return;
        }
        this.mobviewflagDirtyFlag = false;
        this.mobviewflag = null;
    }

    public void setPDVTParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDVTParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pdvtparam = string;
        this.pdvtparamDirtyFlag = true;
    }

    public String getPDVTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    public boolean isPDVTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    public void resetPDVTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
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

    public void setPSDynaAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappid = string;
        this.psdynaappidDirtyFlag = true;
    }

    public String getPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppId();
        }
        return this.psdynaappid;
    }

    public boolean isPSDynaAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppIdDirty();
        }
        return this.psdynaappidDirtyFlag;
    }

    public void resetPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppId();
            return;
        }
        this.psdynaappidDirtyFlag = false;
        this.psdynaappid = null;
    }

    public void setPSDynaAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappname = string;
        this.psdynaappnameDirtyFlag = true;
    }

    public String getPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppName();
        }
        return this.psdynaappname;
    }

    public boolean isPSDynaAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppNameDirty();
        }
        return this.psdynaappnameDirtyFlag;
    }

    public void resetPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppName();
            return;
        }
        this.psdynaappnameDirtyFlag = false;
        this.psdynaappname = null;
    }

    public void setPSDynaAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewid = string;
        this.psdynaappviewidDirtyFlag = true;
    }

    public String getPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewId();
        }
        return this.psdynaappviewid;
    }

    public boolean isPSDynaAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewIdDirty();
        }
        return this.psdynaappviewidDirtyFlag;
    }

    public void resetPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewId();
            return;
        }
        this.psdynaappviewidDirtyFlag = false;
        this.psdynaappviewid = null;
    }

    public void setPSDynaAppViewInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewinstid = string;
        this.psdynaappviewinstidDirtyFlag = true;
    }

    public String getPSDynaAppViewInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewInstId();
        }
        return this.psdynaappviewinstid;
    }

    public boolean isPSDynaAppViewInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewInstIdDirty();
        }
        return this.psdynaappviewinstidDirtyFlag;
    }

    public void resetPSDynaAppViewInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewInstId();
            return;
        }
        this.psdynaappviewinstidDirtyFlag = false;
        this.psdynaappviewinstid = null;
    }

    public void setPSDynaAppViewInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewinstname = string;
        this.psdynaappviewinstnameDirtyFlag = true;
    }

    public String getPSDynaAppViewInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewInstName();
        }
        return this.psdynaappviewinstname;
    }

    public boolean isPSDynaAppViewInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewInstNameDirty();
        }
        return this.psdynaappviewinstnameDirtyFlag;
    }

    public void resetPSDynaAppViewInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewInstName();
            return;
        }
        this.psdynaappviewinstnameDirtyFlag = false;
        this.psdynaappviewinstname = null;
    }

    public void setPSDynaAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewname = string;
        this.psdynaappviewnameDirtyFlag = true;
    }

    public String getPSDynaAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewName();
        }
        return this.psdynaappviewname;
    }

    public boolean isPSDynaAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewNameDirty();
        }
        return this.psdynaappviewnameDirtyFlag;
    }

    public void resetPSDynaAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewName();
            return;
        }
        this.psdynaappviewnameDirtyFlag = false;
        this.psdynaappviewname = null;
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

    public void setPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstname = string;
        this.psdynainstnameDirtyFlag = true;
    }

    public String getPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstName();
        }
        return this.psdynainstname;
    }

    public boolean isPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstNameDirty();
        }
        return this.psdynainstnameDirtyFlag;
    }

    public void resetPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstName();
            return;
        }
        this.psdynainstnameDirtyFlag = false;
        this.psdynainstname = null;
    }

    public void setPSDynaWFVerInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverinstid = string;
        this.psdynawfverinstidDirtyFlag = true;
    }

    public String getPSDynaWFVerInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInstId();
        }
        return this.psdynawfverinstid;
    }

    public boolean isPSDynaWFVerInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerInstIdDirty();
        }
        return this.psdynawfverinstidDirtyFlag;
    }

    public void resetPSDynaWFVerInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerInstId();
            return;
        }
        this.psdynawfverinstidDirtyFlag = false;
        this.psdynawfverinstid = null;
    }

    public void setPSDynaWFVerInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfverinstname = string;
        this.psdynawfverinstnameDirtyFlag = true;
    }

    public String getPSDynaWFVerInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInstName();
        }
        return this.psdynawfverinstname;
    }

    public boolean isPSDynaWFVerInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerInstNameDirty();
        }
        return this.psdynawfverinstnameDirtyFlag;
    }

    public void resetPSDynaWFVerInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerInstName();
            return;
        }
        this.psdynawfverinstnameDirtyFlag = false;
        this.psdynawfverinstname = null;
    }

    public void setSubCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subcaption = string;
        this.subcaptionDirtyFlag = true;
    }

    public String getSubCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubCaption();
        }
        return this.subcaption;
    }

    public boolean isSubCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubCaptionDirty();
        }
        return this.subcaptionDirtyFlag;
    }

    public void resetSubCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubCaption();
            return;
        }
        this.subcaptionDirtyFlag = false;
        this.subcaption = null;
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

    public void setViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewActions(n);
            return;
        }
        this.viewactions = n;
        this.viewactionsDirtyFlag = true;
    }

    public Integer getViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewActions();
        }
        return this.viewactions;
    }

    public boolean isViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewActionsDirty();
        }
        return this.viewactionsDirtyFlag;
    }

    public void resetViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewActions();
            return;
        }
        this.viewactionsDirtyFlag = false;
        this.viewactions = null;
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
        PSDynaAppViewInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaAppViewInstBase pSDynaAppViewInstBase) {
        pSDynaAppViewInstBase.resetCaption();
        pSDynaAppViewInstBase.resetCreateDate();
        pSDynaAppViewInstBase.resetCreateMan();
        pSDynaAppViewInstBase.resetDynaModel();
        pSDynaAppViewInstBase.resetDynaViewParam();
        pSDynaAppViewInstBase.resetDynaViewParam2();
        pSDynaAppViewInstBase.resetDynaViewParam3();
        pSDynaAppViewInstBase.resetDynaViewParam4();
        pSDynaAppViewInstBase.resetDynaViewParam5();
        pSDynaAppViewInstBase.resetDynaViewParam6();
        pSDynaAppViewInstBase.resetEnableViewActions();
        pSDynaAppViewInstBase.resetInstVer();
        pSDynaAppViewInstBase.resetMemo();
        pSDynaAppViewInstBase.resetMobViewFlag();
        pSDynaAppViewInstBase.resetPDVTParam();
        pSDynaAppViewInstBase.resetPredefinedViewType();
        pSDynaAppViewInstBase.resetPSDynaAppId();
        pSDynaAppViewInstBase.resetPSDynaAppName();
        pSDynaAppViewInstBase.resetPSDynaAppViewId();
        pSDynaAppViewInstBase.resetPSDynaAppViewInstId();
        pSDynaAppViewInstBase.resetPSDynaAppViewInstName();
        pSDynaAppViewInstBase.resetPSDynaAppViewName();
        pSDynaAppViewInstBase.resetPSDynaInstId();
        pSDynaAppViewInstBase.resetPSDynaInstName();
        pSDynaAppViewInstBase.resetPSDynaWFVerInstId();
        pSDynaAppViewInstBase.resetPSDynaWFVerInstName();
        pSDynaAppViewInstBase.resetSubCaption();
        pSDynaAppViewInstBase.resetTitle();
        pSDynaAppViewInstBase.resetUpdateDate();
        pSDynaAppViewInstBase.resetUpdateMan();
        pSDynaAppViewInstBase.resetViewActions();
        pSDynaAppViewInstBase.resetViewParam();
        pSDynaAppViewInstBase.resetViewParam2();
        pSDynaAppViewInstBase.resetViewParam5();
        pSDynaAppViewInstBase.resetViewParam6();
        pSDynaAppViewInstBase.resetWFViewParam();
        pSDynaAppViewInstBase.resetWFViewParam2();
        pSDynaAppViewInstBase.resetWFViewParam3();
        pSDynaAppViewInstBase.resetWFViewParam4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelDirty()) {
            hashMap.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bl || this.isDynaViewParamDirty()) {
            hashMap.put(FIELD_DYNAVIEWPARAM, this.getDynaViewParam());
        }
        if (!bl || this.isDynaViewParam2Dirty()) {
            hashMap.put(FIELD_DYNAVIEWPARAM2, this.getDynaViewParam2());
        }
        if (!bl || this.isDynaViewParam3Dirty()) {
            hashMap.put(FIELD_DYNAVIEWPARAM3, this.getDynaViewParam3());
        }
        if (!bl || this.isDynaViewParam4Dirty()) {
            hashMap.put(FIELD_DYNAVIEWPARAM4, this.getDynaViewParam4());
        }
        if (!bl || this.isDynaViewParam5Dirty()) {
            hashMap.put(FIELD_DYNAVIEWPARAM5, this.getDynaViewParam5());
        }
        if (!bl || this.isDynaViewParam6Dirty()) {
            hashMap.put(FIELD_DYNAVIEWPARAM6, this.getDynaViewParam6());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isInstVerDirty()) {
            hashMap.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobViewFlagDirty()) {
            hashMap.put(FIELD_MOBVIEWFLAG, this.getMobViewFlag());
        }
        if (!bl || this.isPDVTParamDirty()) {
            hashMap.put(FIELD_PDVTPARAM, this.getPDVTParam());
        }
        if (!bl || this.isPredefinedViewTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDVIEWTYPE, this.getPredefinedViewType());
        }
        if (!bl || this.isPSDynaAppIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPID, this.getPSDynaAppId());
        }
        if (!bl || this.isPSDynaAppNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPNAME, this.getPSDynaAppName());
        }
        if (!bl || this.isPSDynaAppViewIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWID, this.getPSDynaAppViewId());
        }
        if (!bl || this.isPSDynaAppViewInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWINSTID, this.getPSDynaAppViewInstId());
        }
        if (!bl || this.isPSDynaAppViewInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWINSTNAME, this.getPSDynaAppViewInstName());
        }
        if (!bl || this.isPSDynaAppViewNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWNAME, this.getPSDynaAppViewName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAINSTNAME, this.getPSDynaInstName());
        }
        if (!bl || this.isPSDynaWFVerInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERINSTID, this.getPSDynaWFVerInstId());
        }
        if (!bl || this.isPSDynaWFVerInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAWFVERINSTNAME, this.getPSDynaWFVerInstName());
        }
        if (!bl || this.isSubCaptionDirty()) {
            hashMap.put(FIELD_SUBCAPTION, this.getSubCaption());
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
        if (!bl || this.isViewActionsDirty()) {
            hashMap.put(FIELD_VIEWACTIONS, this.getViewActions());
        }
        if (!bl || this.isViewParamDirty()) {
            hashMap.put(FIELD_VIEWPARAM, this.getViewParam());
        }
        if (!bl || this.isViewParam2Dirty()) {
            hashMap.put(FIELD_VIEWPARAM2, this.getViewParam2());
        }
        if (!bl || this.isViewParam5Dirty()) {
            hashMap.put(FIELD_VIEWPARAM5, this.getViewParam5());
        }
        if (!bl || this.isViewParam6Dirty()) {
            hashMap.put(FIELD_VIEWPARAM6, this.getViewParam6());
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
        return PSDynaAppViewInstBase.get(this, n);
    }

    private static Object get(PSDynaAppViewInstBase pSDynaAppViewInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewInstBase.getCaption();
            }
            case 1: {
                return pSDynaAppViewInstBase.getCreateDate();
            }
            case 2: {
                return pSDynaAppViewInstBase.getCreateMan();
            }
            case 3: {
                return pSDynaAppViewInstBase.getDynaModel();
            }
            case 4: {
                return pSDynaAppViewInstBase.getDynaViewParam();
            }
            case 5: {
                return pSDynaAppViewInstBase.getDynaViewParam2();
            }
            case 6: {
                return pSDynaAppViewInstBase.getDynaViewParam3();
            }
            case 7: {
                return pSDynaAppViewInstBase.getDynaViewParam4();
            }
            case 8: {
                return pSDynaAppViewInstBase.getDynaViewParam5();
            }
            case 9: {
                return pSDynaAppViewInstBase.getDynaViewParam6();
            }
            case 10: {
                return pSDynaAppViewInstBase.getEnableViewActions();
            }
            case 11: {
                return pSDynaAppViewInstBase.getInstVer();
            }
            case 12: {
                return pSDynaAppViewInstBase.getMemo();
            }
            case 13: {
                return pSDynaAppViewInstBase.getMobViewFlag();
            }
            case 14: {
                return pSDynaAppViewInstBase.getPDVTParam();
            }
            case 15: {
                return pSDynaAppViewInstBase.getPredefinedViewType();
            }
            case 16: {
                return pSDynaAppViewInstBase.getPSDynaAppId();
            }
            case 17: {
                return pSDynaAppViewInstBase.getPSDynaAppName();
            }
            case 18: {
                return pSDynaAppViewInstBase.getPSDynaAppViewId();
            }
            case 19: {
                return pSDynaAppViewInstBase.getPSDynaAppViewInstId();
            }
            case 20: {
                return pSDynaAppViewInstBase.getPSDynaAppViewInstName();
            }
            case 21: {
                return pSDynaAppViewInstBase.getPSDynaAppViewName();
            }
            case 22: {
                return pSDynaAppViewInstBase.getPSDynaInstId();
            }
            case 23: {
                return pSDynaAppViewInstBase.getPSDynaInstName();
            }
            case 24: {
                return pSDynaAppViewInstBase.getPSDynaWFVerInstId();
            }
            case 25: {
                return pSDynaAppViewInstBase.getPSDynaWFVerInstName();
            }
            case 26: {
                return pSDynaAppViewInstBase.getSubCaption();
            }
            case 27: {
                return pSDynaAppViewInstBase.getTitle();
            }
            case 28: {
                return pSDynaAppViewInstBase.getUpdateDate();
            }
            case 29: {
                return pSDynaAppViewInstBase.getUpdateMan();
            }
            case 30: {
                return pSDynaAppViewInstBase.getViewActions();
            }
            case 31: {
                return pSDynaAppViewInstBase.getViewParam();
            }
            case 32: {
                return pSDynaAppViewInstBase.getViewParam2();
            }
            case 33: {
                return pSDynaAppViewInstBase.getViewParam5();
            }
            case 34: {
                return pSDynaAppViewInstBase.getViewParam6();
            }
            case 35: {
                return pSDynaAppViewInstBase.getWFViewParam();
            }
            case 36: {
                return pSDynaAppViewInstBase.getWFViewParam2();
            }
            case 37: {
                return pSDynaAppViewInstBase.getWFViewParam3();
            }
            case 38: {
                return pSDynaAppViewInstBase.getWFViewParam4();
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
        PSDynaAppViewInstBase.set(this, n, object);
    }

    private static void set(PSDynaAppViewInstBase pSDynaAppViewInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppViewInstBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDynaAppViewInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDynaAppViewInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaAppViewInstBase.setDynaModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaAppViewInstBase.setDynaViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaAppViewInstBase.setDynaViewParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaAppViewInstBase.setDynaViewParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaAppViewInstBase.setDynaViewParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaAppViewInstBase.setDynaViewParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaAppViewInstBase.setDynaViewParam6(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaAppViewInstBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDynaAppViewInstBase.setInstVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDynaAppViewInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDynaAppViewInstBase.setMobViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDynaAppViewInstBase.setPDVTParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDynaAppViewInstBase.setPredefinedViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDynaAppViewInstBase.setPSDynaAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDynaAppViewInstBase.setPSDynaAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDynaAppViewInstBase.setPSDynaAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDynaAppViewInstBase.setPSDynaAppViewInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDynaAppViewInstBase.setPSDynaAppViewInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDynaAppViewInstBase.setPSDynaAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDynaAppViewInstBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDynaAppViewInstBase.setPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDynaAppViewInstBase.setPSDynaWFVerInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDynaAppViewInstBase.setPSDynaWFVerInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDynaAppViewInstBase.setSubCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDynaAppViewInstBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDynaAppViewInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDynaAppViewInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDynaAppViewInstBase.setViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDynaAppViewInstBase.setViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDynaAppViewInstBase.setViewParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDynaAppViewInstBase.setViewParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDynaAppViewInstBase.setViewParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDynaAppViewInstBase.setWFViewParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDynaAppViewInstBase.setWFViewParam2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDynaAppViewInstBase.setWFViewParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDynaAppViewInstBase.setWFViewParam4(DataObject.getStringValue((Object)object));
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
        return PSDynaAppViewInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaAppViewInstBase pSDynaAppViewInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewInstBase.getCaption() == null;
            }
            case 1: {
                return pSDynaAppViewInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSDynaAppViewInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSDynaAppViewInstBase.getDynaModel() == null;
            }
            case 4: {
                return pSDynaAppViewInstBase.getDynaViewParam() == null;
            }
            case 5: {
                return pSDynaAppViewInstBase.getDynaViewParam2() == null;
            }
            case 6: {
                return pSDynaAppViewInstBase.getDynaViewParam3() == null;
            }
            case 7: {
                return pSDynaAppViewInstBase.getDynaViewParam4() == null;
            }
            case 8: {
                return pSDynaAppViewInstBase.getDynaViewParam5() == null;
            }
            case 9: {
                return pSDynaAppViewInstBase.getDynaViewParam6() == null;
            }
            case 10: {
                return pSDynaAppViewInstBase.getEnableViewActions() == null;
            }
            case 11: {
                return pSDynaAppViewInstBase.getInstVer() == null;
            }
            case 12: {
                return pSDynaAppViewInstBase.getMemo() == null;
            }
            case 13: {
                return pSDynaAppViewInstBase.getMobViewFlag() == null;
            }
            case 14: {
                return pSDynaAppViewInstBase.getPDVTParam() == null;
            }
            case 15: {
                return pSDynaAppViewInstBase.getPredefinedViewType() == null;
            }
            case 16: {
                return pSDynaAppViewInstBase.getPSDynaAppId() == null;
            }
            case 17: {
                return pSDynaAppViewInstBase.getPSDynaAppName() == null;
            }
            case 18: {
                return pSDynaAppViewInstBase.getPSDynaAppViewId() == null;
            }
            case 19: {
                return pSDynaAppViewInstBase.getPSDynaAppViewInstId() == null;
            }
            case 20: {
                return pSDynaAppViewInstBase.getPSDynaAppViewInstName() == null;
            }
            case 21: {
                return pSDynaAppViewInstBase.getPSDynaAppViewName() == null;
            }
            case 22: {
                return pSDynaAppViewInstBase.getPSDynaInstId() == null;
            }
            case 23: {
                return pSDynaAppViewInstBase.getPSDynaInstName() == null;
            }
            case 24: {
                return pSDynaAppViewInstBase.getPSDynaWFVerInstId() == null;
            }
            case 25: {
                return pSDynaAppViewInstBase.getPSDynaWFVerInstName() == null;
            }
            case 26: {
                return pSDynaAppViewInstBase.getSubCaption() == null;
            }
            case 27: {
                return pSDynaAppViewInstBase.getTitle() == null;
            }
            case 28: {
                return pSDynaAppViewInstBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDynaAppViewInstBase.getUpdateMan() == null;
            }
            case 30: {
                return pSDynaAppViewInstBase.getViewActions() == null;
            }
            case 31: {
                return pSDynaAppViewInstBase.getViewParam() == null;
            }
            case 32: {
                return pSDynaAppViewInstBase.getViewParam2() == null;
            }
            case 33: {
                return pSDynaAppViewInstBase.getViewParam5() == null;
            }
            case 34: {
                return pSDynaAppViewInstBase.getViewParam6() == null;
            }
            case 35: {
                return pSDynaAppViewInstBase.getWFViewParam() == null;
            }
            case 36: {
                return pSDynaAppViewInstBase.getWFViewParam2() == null;
            }
            case 37: {
                return pSDynaAppViewInstBase.getWFViewParam3() == null;
            }
            case 38: {
                return pSDynaAppViewInstBase.getWFViewParam4() == null;
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
        return PSDynaAppViewInstBase.contains(this, n);
    }

    private static boolean contains(PSDynaAppViewInstBase pSDynaAppViewInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewInstBase.isCaptionDirty();
            }
            case 1: {
                return pSDynaAppViewInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSDynaAppViewInstBase.isCreateManDirty();
            }
            case 3: {
                return pSDynaAppViewInstBase.isDynaModelDirty();
            }
            case 4: {
                return pSDynaAppViewInstBase.isDynaViewParamDirty();
            }
            case 5: {
                return pSDynaAppViewInstBase.isDynaViewParam2Dirty();
            }
            case 6: {
                return pSDynaAppViewInstBase.isDynaViewParam3Dirty();
            }
            case 7: {
                return pSDynaAppViewInstBase.isDynaViewParam4Dirty();
            }
            case 8: {
                return pSDynaAppViewInstBase.isDynaViewParam5Dirty();
            }
            case 9: {
                return pSDynaAppViewInstBase.isDynaViewParam6Dirty();
            }
            case 10: {
                return pSDynaAppViewInstBase.isEnableViewActionsDirty();
            }
            case 11: {
                return pSDynaAppViewInstBase.isInstVerDirty();
            }
            case 12: {
                return pSDynaAppViewInstBase.isMemoDirty();
            }
            case 13: {
                return pSDynaAppViewInstBase.isMobViewFlagDirty();
            }
            case 14: {
                return pSDynaAppViewInstBase.isPDVTParamDirty();
            }
            case 15: {
                return pSDynaAppViewInstBase.isPredefinedViewTypeDirty();
            }
            case 16: {
                return pSDynaAppViewInstBase.isPSDynaAppIdDirty();
            }
            case 17: {
                return pSDynaAppViewInstBase.isPSDynaAppNameDirty();
            }
            case 18: {
                return pSDynaAppViewInstBase.isPSDynaAppViewIdDirty();
            }
            case 19: {
                return pSDynaAppViewInstBase.isPSDynaAppViewInstIdDirty();
            }
            case 20: {
                return pSDynaAppViewInstBase.isPSDynaAppViewInstNameDirty();
            }
            case 21: {
                return pSDynaAppViewInstBase.isPSDynaAppViewNameDirty();
            }
            case 22: {
                return pSDynaAppViewInstBase.isPSDynaInstIdDirty();
            }
            case 23: {
                return pSDynaAppViewInstBase.isPSDynaInstNameDirty();
            }
            case 24: {
                return pSDynaAppViewInstBase.isPSDynaWFVerInstIdDirty();
            }
            case 25: {
                return pSDynaAppViewInstBase.isPSDynaWFVerInstNameDirty();
            }
            case 26: {
                return pSDynaAppViewInstBase.isSubCaptionDirty();
            }
            case 27: {
                return pSDynaAppViewInstBase.isTitleDirty();
            }
            case 28: {
                return pSDynaAppViewInstBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDynaAppViewInstBase.isUpdateManDirty();
            }
            case 30: {
                return pSDynaAppViewInstBase.isViewActionsDirty();
            }
            case 31: {
                return pSDynaAppViewInstBase.isViewParamDirty();
            }
            case 32: {
                return pSDynaAppViewInstBase.isViewParam2Dirty();
            }
            case 33: {
                return pSDynaAppViewInstBase.isViewParam5Dirty();
            }
            case 34: {
                return pSDynaAppViewInstBase.isViewParam6Dirty();
            }
            case 35: {
                return pSDynaAppViewInstBase.isWFViewParamDirty();
            }
            case 36: {
                return pSDynaAppViewInstBase.isWFViewParam2Dirty();
            }
            case 37: {
                return pSDynaAppViewInstBase.isWFViewParam3Dirty();
            }
            case 38: {
                return pSDynaAppViewInstBase.isWFViewParam4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaAppViewInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaAppViewInstBase pSDynaAppViewInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaAppViewInstBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getCaption()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getDynaModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodel", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getDynaModel()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaviewparam", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getDynaViewParam()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaviewparam2", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getDynaViewParam2()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaviewparam3", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getDynaViewParam3()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaviewparam4", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getDynaViewParam4()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaviewparam5", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getDynaViewParam5()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaviewparam6", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getDynaViewParam6()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instver", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getInstVer()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getMobViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobviewflag", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getMobViewFlag()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPDVTParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdvtparam", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPDVTParam()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPredefinedViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefineviewtype", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPredefinedViewType()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappid", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaAppId()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappname", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaAppName()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewid", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaAppViewId()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppViewInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewinstid", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaAppViewInstId()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppViewInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewinstname", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaAppViewInstName()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewname", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaAppViewName()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstname", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaInstName()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaWFVerInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverinstid", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaWFVerInstId()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaWFVerInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfverinstname", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getPSDynaWFVerInstName()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getSubCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcaption", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getSubCaption()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getTitle()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewactions", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getViewActions()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getViewParam()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam2", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getViewParam2()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getViewParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam5", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getViewParam5()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getViewParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam6", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getViewParam6()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getWFViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getWFViewParam()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getWFViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam2", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getWFViewParam2()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getWFViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam3", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getWFViewParam3()), (boolean)false);
        }
        if (bl || pSDynaAppViewInstBase.getWFViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam4", (Object)PSDynaAppViewInstBase.getJSONValue((Object)pSDynaAppViewInstBase.getWFViewParam4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaAppViewInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaAppViewInstBase pSDynaAppViewInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaAppViewInstBase.getCaption() != null) {
            object = pSDynaAppViewInstBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getCreateDate() != null) {
            object = pSDynaAppViewInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getCreateMan() != null) {
            object = pSDynaAppViewInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getDynaModel() != null) {
            object = pSDynaAppViewInstBase.getDynaModel();
            xmlNode.setAttribute(FIELD_DYNAMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam() != null) {
            object = pSDynaAppViewInstBase.getDynaViewParam();
            xmlNode.setAttribute(FIELD_DYNAVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam2() != null) {
            object = pSDynaAppViewInstBase.getDynaViewParam2();
            xmlNode.setAttribute(FIELD_DYNAVIEWPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam3() != null) {
            object = pSDynaAppViewInstBase.getDynaViewParam3();
            xmlNode.setAttribute(FIELD_DYNAVIEWPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam4() != null) {
            object = pSDynaAppViewInstBase.getDynaViewParam4();
            xmlNode.setAttribute(FIELD_DYNAVIEWPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam5() != null) {
            object = pSDynaAppViewInstBase.getDynaViewParam5();
            xmlNode.setAttribute(FIELD_DYNAVIEWPARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getDynaViewParam6() != null) {
            object = pSDynaAppViewInstBase.getDynaViewParam6();
            xmlNode.setAttribute(FIELD_DYNAVIEWPARAM6, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getEnableViewActions() != null) {
            object = pSDynaAppViewInstBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getInstVer() != null) {
            object = pSDynaAppViewInstBase.getInstVer();
            xmlNode.setAttribute(FIELD_INSTVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getMemo() != null) {
            object = pSDynaAppViewInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getMobViewFlag() != null) {
            object = pSDynaAppViewInstBase.getMobViewFlag();
            xmlNode.setAttribute(FIELD_MOBVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getPDVTParam() != null) {
            object = pSDynaAppViewInstBase.getPDVTParam();
            xmlNode.setAttribute(FIELD_PDVTPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPredefinedViewType() != null) {
            object = pSDynaAppViewInstBase.getPredefinedViewType();
            xmlNode.setAttribute("PREDEFINEDVIEWTYPE", object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppId() != null) {
            object = pSDynaAppViewInstBase.getPSDynaAppId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppName() != null) {
            object = pSDynaAppViewInstBase.getPSDynaAppName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppViewId() != null) {
            object = pSDynaAppViewInstBase.getPSDynaAppViewId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppViewInstId() != null) {
            object = pSDynaAppViewInstBase.getPSDynaAppViewInstId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppViewInstName() != null) {
            object = pSDynaAppViewInstBase.getPSDynaAppViewInstName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaAppViewName() != null) {
            object = pSDynaAppViewInstBase.getPSDynaAppViewName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaInstId() != null) {
            object = pSDynaAppViewInstBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaInstName() != null) {
            object = pSDynaAppViewInstBase.getPSDynaInstName();
            xmlNode.setAttribute(FIELD_PSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaWFVerInstId() != null) {
            object = pSDynaAppViewInstBase.getPSDynaWFVerInstId();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getPSDynaWFVerInstName() != null) {
            object = pSDynaAppViewInstBase.getPSDynaWFVerInstName();
            xmlNode.setAttribute(FIELD_PSDYNAWFVERINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getSubCaption() != null) {
            object = pSDynaAppViewInstBase.getSubCaption();
            xmlNode.setAttribute(FIELD_SUBCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getTitle() != null) {
            object = pSDynaAppViewInstBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getUpdateDate() != null) {
            object = pSDynaAppViewInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getUpdateMan() != null) {
            object = pSDynaAppViewInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getViewActions() != null) {
            object = pSDynaAppViewInstBase.getViewActions();
            xmlNode.setAttribute(FIELD_VIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getViewParam() != null) {
            object = pSDynaAppViewInstBase.getViewParam();
            xmlNode.setAttribute(FIELD_VIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getViewParam2() != null) {
            object = pSDynaAppViewInstBase.getViewParam2();
            xmlNode.setAttribute(FIELD_VIEWPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getViewParam5() != null) {
            object = pSDynaAppViewInstBase.getViewParam5();
            xmlNode.setAttribute(FIELD_VIEWPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getViewParam6() != null) {
            object = pSDynaAppViewInstBase.getViewParam6();
            xmlNode.setAttribute(FIELD_VIEWPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getWFViewParam() != null) {
            object = pSDynaAppViewInstBase.getWFViewParam();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getWFViewParam2() != null) {
            object = pSDynaAppViewInstBase.getWFViewParam2();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewInstBase.getWFViewParam3() != null) {
            object = pSDynaAppViewInstBase.getWFViewParam3();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewInstBase.getWFViewParam4() != null) {
            object = pSDynaAppViewInstBase.getWFViewParam4();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaAppViewInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaAppViewInstBase pSDynaAppViewInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaAppViewInstBase.isCaptionDirty() && (bl || pSDynaAppViewInstBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDynaAppViewInstBase.getCaption());
        }
        if (pSDynaAppViewInstBase.isCreateDateDirty() && (bl || pSDynaAppViewInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaAppViewInstBase.getCreateDate());
        }
        if (pSDynaAppViewInstBase.isCreateManDirty() && (bl || pSDynaAppViewInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaAppViewInstBase.getCreateMan());
        }
        if (pSDynaAppViewInstBase.isDynaModelDirty() && (bl || pSDynaAppViewInstBase.getDynaModel() != null)) {
            iDataObject.set(FIELD_DYNAMODEL, (Object)pSDynaAppViewInstBase.getDynaModel());
        }
        if (pSDynaAppViewInstBase.isDynaViewParamDirty() && (bl || pSDynaAppViewInstBase.getDynaViewParam() != null)) {
            iDataObject.set(FIELD_DYNAVIEWPARAM, (Object)pSDynaAppViewInstBase.getDynaViewParam());
        }
        if (pSDynaAppViewInstBase.isDynaViewParam2Dirty() && (bl || pSDynaAppViewInstBase.getDynaViewParam2() != null)) {
            iDataObject.set(FIELD_DYNAVIEWPARAM2, (Object)pSDynaAppViewInstBase.getDynaViewParam2());
        }
        if (pSDynaAppViewInstBase.isDynaViewParam3Dirty() && (bl || pSDynaAppViewInstBase.getDynaViewParam3() != null)) {
            iDataObject.set(FIELD_DYNAVIEWPARAM3, (Object)pSDynaAppViewInstBase.getDynaViewParam3());
        }
        if (pSDynaAppViewInstBase.isDynaViewParam4Dirty() && (bl || pSDynaAppViewInstBase.getDynaViewParam4() != null)) {
            iDataObject.set(FIELD_DYNAVIEWPARAM4, (Object)pSDynaAppViewInstBase.getDynaViewParam4());
        }
        if (pSDynaAppViewInstBase.isDynaViewParam5Dirty() && (bl || pSDynaAppViewInstBase.getDynaViewParam5() != null)) {
            iDataObject.set(FIELD_DYNAVIEWPARAM5, (Object)pSDynaAppViewInstBase.getDynaViewParam5());
        }
        if (pSDynaAppViewInstBase.isDynaViewParam6Dirty() && (bl || pSDynaAppViewInstBase.getDynaViewParam6() != null)) {
            iDataObject.set(FIELD_DYNAVIEWPARAM6, (Object)pSDynaAppViewInstBase.getDynaViewParam6());
        }
        if (pSDynaAppViewInstBase.isEnableViewActionsDirty() && (bl || pSDynaAppViewInstBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSDynaAppViewInstBase.getEnableViewActions());
        }
        if (pSDynaAppViewInstBase.isInstVerDirty() && (bl || pSDynaAppViewInstBase.getInstVer() != null)) {
            iDataObject.set(FIELD_INSTVER, (Object)pSDynaAppViewInstBase.getInstVer());
        }
        if (pSDynaAppViewInstBase.isMemoDirty() && (bl || pSDynaAppViewInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaAppViewInstBase.getMemo());
        }
        if (pSDynaAppViewInstBase.isMobViewFlagDirty() && (bl || pSDynaAppViewInstBase.getMobViewFlag() != null)) {
            iDataObject.set(FIELD_MOBVIEWFLAG, (Object)pSDynaAppViewInstBase.getMobViewFlag());
        }
        if (pSDynaAppViewInstBase.isPDVTParamDirty() && (bl || pSDynaAppViewInstBase.getPDVTParam() != null)) {
            iDataObject.set(FIELD_PDVTPARAM, (Object)pSDynaAppViewInstBase.getPDVTParam());
        }
        if (pSDynaAppViewInstBase.isPredefinedViewTypeDirty() && (bl || pSDynaAppViewInstBase.getPredefinedViewType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDVIEWTYPE, (Object)pSDynaAppViewInstBase.getPredefinedViewType());
        }
        if (pSDynaAppViewInstBase.isPSDynaAppIdDirty() && (bl || pSDynaAppViewInstBase.getPSDynaAppId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPID, (Object)pSDynaAppViewInstBase.getPSDynaAppId());
        }
        if (pSDynaAppViewInstBase.isPSDynaAppNameDirty() && (bl || pSDynaAppViewInstBase.getPSDynaAppName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPNAME, (Object)pSDynaAppViewInstBase.getPSDynaAppName());
        }
        if (pSDynaAppViewInstBase.isPSDynaAppViewIdDirty() && (bl || pSDynaAppViewInstBase.getPSDynaAppViewId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWID, (Object)pSDynaAppViewInstBase.getPSDynaAppViewId());
        }
        if (pSDynaAppViewInstBase.isPSDynaAppViewInstIdDirty() && (bl || pSDynaAppViewInstBase.getPSDynaAppViewInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWINSTID, (Object)pSDynaAppViewInstBase.getPSDynaAppViewInstId());
        }
        if (pSDynaAppViewInstBase.isPSDynaAppViewInstNameDirty() && (bl || pSDynaAppViewInstBase.getPSDynaAppViewInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWINSTNAME, (Object)pSDynaAppViewInstBase.getPSDynaAppViewInstName());
        }
        if (pSDynaAppViewInstBase.isPSDynaAppViewNameDirty() && (bl || pSDynaAppViewInstBase.getPSDynaAppViewName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWNAME, (Object)pSDynaAppViewInstBase.getPSDynaAppViewName());
        }
        if (pSDynaAppViewInstBase.isPSDynaInstIdDirty() && (bl || pSDynaAppViewInstBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDynaAppViewInstBase.getPSDynaInstId());
        }
        if (pSDynaAppViewInstBase.isPSDynaInstNameDirty() && (bl || pSDynaAppViewInstBase.getPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTNAME, (Object)pSDynaAppViewInstBase.getPSDynaInstName());
        }
        if (pSDynaAppViewInstBase.isPSDynaWFVerInstIdDirty() && (bl || pSDynaAppViewInstBase.getPSDynaWFVerInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERINSTID, (Object)pSDynaAppViewInstBase.getPSDynaWFVerInstId());
        }
        if (pSDynaAppViewInstBase.isPSDynaWFVerInstNameDirty() && (bl || pSDynaAppViewInstBase.getPSDynaWFVerInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAWFVERINSTNAME, (Object)pSDynaAppViewInstBase.getPSDynaWFVerInstName());
        }
        if (pSDynaAppViewInstBase.isSubCaptionDirty() && (bl || pSDynaAppViewInstBase.getSubCaption() != null)) {
            iDataObject.set(FIELD_SUBCAPTION, (Object)pSDynaAppViewInstBase.getSubCaption());
        }
        if (pSDynaAppViewInstBase.isTitleDirty() && (bl || pSDynaAppViewInstBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSDynaAppViewInstBase.getTitle());
        }
        if (pSDynaAppViewInstBase.isUpdateDateDirty() && (bl || pSDynaAppViewInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaAppViewInstBase.getUpdateDate());
        }
        if (pSDynaAppViewInstBase.isUpdateManDirty() && (bl || pSDynaAppViewInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaAppViewInstBase.getUpdateMan());
        }
        if (pSDynaAppViewInstBase.isViewActionsDirty() && (bl || pSDynaAppViewInstBase.getViewActions() != null)) {
            iDataObject.set(FIELD_VIEWACTIONS, (Object)pSDynaAppViewInstBase.getViewActions());
        }
        if (pSDynaAppViewInstBase.isViewParamDirty() && (bl || pSDynaAppViewInstBase.getViewParam() != null)) {
            iDataObject.set(FIELD_VIEWPARAM, (Object)pSDynaAppViewInstBase.getViewParam());
        }
        if (pSDynaAppViewInstBase.isViewParam2Dirty() && (bl || pSDynaAppViewInstBase.getViewParam2() != null)) {
            iDataObject.set(FIELD_VIEWPARAM2, (Object)pSDynaAppViewInstBase.getViewParam2());
        }
        if (pSDynaAppViewInstBase.isViewParam5Dirty() && (bl || pSDynaAppViewInstBase.getViewParam5() != null)) {
            iDataObject.set(FIELD_VIEWPARAM5, (Object)pSDynaAppViewInstBase.getViewParam5());
        }
        if (pSDynaAppViewInstBase.isViewParam6Dirty() && (bl || pSDynaAppViewInstBase.getViewParam6() != null)) {
            iDataObject.set(FIELD_VIEWPARAM6, (Object)pSDynaAppViewInstBase.getViewParam6());
        }
        if (pSDynaAppViewInstBase.isWFViewParamDirty() && (bl || pSDynaAppViewInstBase.getWFViewParam() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM, (Object)pSDynaAppViewInstBase.getWFViewParam());
        }
        if (pSDynaAppViewInstBase.isWFViewParam2Dirty() && (bl || pSDynaAppViewInstBase.getWFViewParam2() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM2, (Object)pSDynaAppViewInstBase.getWFViewParam2());
        }
        if (pSDynaAppViewInstBase.isWFViewParam3Dirty() && (bl || pSDynaAppViewInstBase.getWFViewParam3() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM3, (Object)pSDynaAppViewInstBase.getWFViewParam3());
        }
        if (pSDynaAppViewInstBase.isWFViewParam4Dirty() && (bl || pSDynaAppViewInstBase.getWFViewParam4() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM4, (Object)pSDynaAppViewInstBase.getWFViewParam4());
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
        return PSDynaAppViewInstBase.remove(this, n);
    }

    private static boolean remove(PSDynaAppViewInstBase pSDynaAppViewInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppViewInstBase.resetCaption();
                return true;
            }
            case 1: {
                pSDynaAppViewInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDynaAppViewInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDynaAppViewInstBase.resetDynaModel();
                return true;
            }
            case 4: {
                pSDynaAppViewInstBase.resetDynaViewParam();
                return true;
            }
            case 5: {
                pSDynaAppViewInstBase.resetDynaViewParam2();
                return true;
            }
            case 6: {
                pSDynaAppViewInstBase.resetDynaViewParam3();
                return true;
            }
            case 7: {
                pSDynaAppViewInstBase.resetDynaViewParam4();
                return true;
            }
            case 8: {
                pSDynaAppViewInstBase.resetDynaViewParam5();
                return true;
            }
            case 9: {
                pSDynaAppViewInstBase.resetDynaViewParam6();
                return true;
            }
            case 10: {
                pSDynaAppViewInstBase.resetEnableViewActions();
                return true;
            }
            case 11: {
                pSDynaAppViewInstBase.resetInstVer();
                return true;
            }
            case 12: {
                pSDynaAppViewInstBase.resetMemo();
                return true;
            }
            case 13: {
                pSDynaAppViewInstBase.resetMobViewFlag();
                return true;
            }
            case 14: {
                pSDynaAppViewInstBase.resetPDVTParam();
                return true;
            }
            case 15: {
                pSDynaAppViewInstBase.resetPredefinedViewType();
                return true;
            }
            case 16: {
                pSDynaAppViewInstBase.resetPSDynaAppId();
                return true;
            }
            case 17: {
                pSDynaAppViewInstBase.resetPSDynaAppName();
                return true;
            }
            case 18: {
                pSDynaAppViewInstBase.resetPSDynaAppViewId();
                return true;
            }
            case 19: {
                pSDynaAppViewInstBase.resetPSDynaAppViewInstId();
                return true;
            }
            case 20: {
                pSDynaAppViewInstBase.resetPSDynaAppViewInstName();
                return true;
            }
            case 21: {
                pSDynaAppViewInstBase.resetPSDynaAppViewName();
                return true;
            }
            case 22: {
                pSDynaAppViewInstBase.resetPSDynaInstId();
                return true;
            }
            case 23: {
                pSDynaAppViewInstBase.resetPSDynaInstName();
                return true;
            }
            case 24: {
                pSDynaAppViewInstBase.resetPSDynaWFVerInstId();
                return true;
            }
            case 25: {
                pSDynaAppViewInstBase.resetPSDynaWFVerInstName();
                return true;
            }
            case 26: {
                pSDynaAppViewInstBase.resetSubCaption();
                return true;
            }
            case 27: {
                pSDynaAppViewInstBase.resetTitle();
                return true;
            }
            case 28: {
                pSDynaAppViewInstBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDynaAppViewInstBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSDynaAppViewInstBase.resetViewActions();
                return true;
            }
            case 31: {
                pSDynaAppViewInstBase.resetViewParam();
                return true;
            }
            case 32: {
                pSDynaAppViewInstBase.resetViewParam2();
                return true;
            }
            case 33: {
                pSDynaAppViewInstBase.resetViewParam5();
                return true;
            }
            case 34: {
                pSDynaAppViewInstBase.resetViewParam6();
                return true;
            }
            case 35: {
                pSDynaAppViewInstBase.resetWFViewParam();
                return true;
            }
            case 36: {
                pSDynaAppViewInstBase.resetWFViewParam2();
                return true;
            }
            case 37: {
                pSDynaAppViewInstBase.resetWFViewParam3();
                return true;
            }
            case 38: {
                pSDynaAppViewInstBase.resetWFViewParam4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaAppView getPSDynaAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppView();
        }
        if (this.getPSDynaAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSDynaAppViewLock;
        synchronized (n) {
            if (this.psdynaappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaAppViewId(), (Object)this.psdynaappview.getPSDynaAppViewId()) != 0L) {
                this.psdynaappview = null;
            }
            if (this.psdynaappview == null) {
                PSDynaAppView pSDynaAppView = new PSDynaAppView();
                pSDynaAppView.setPSDynaAppViewId(this.getPSDynaAppViewId());
                PSDynaAppViewService pSDynaAppViewService = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSDynaAppViewService.autoGet(pSDynaAppView);
                this.psdynaappview = pSDynaAppView;
            }
            return this.psdynaappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaApp getPSDynaApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaApp();
        }
        if (this.getPSDynaAppId() == null) {
            return null;
        }
        Integer n = this.objPSDynaAppLock;
        synchronized (n) {
            if (this.psdynaapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaAppId(), (Object)this.psdynaapp.getPSDynaAppId()) != 0L) {
                this.psdynaapp = null;
            }
            if (this.psdynaapp == null) {
                PSDynaApp pSDynaApp = new PSDynaApp();
                pSDynaApp.setPSDynaAppId(this.getPSDynaAppId());
                PSDynaAppService pSDynaAppService = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
                pSDynaAppService.autoGet(pSDynaApp);
                this.psdynaapp = pSDynaApp;
            }
            return this.psdynaapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaInst getPSDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInst();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaInstLock;
        synchronized (n) {
            if (this.psdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaInstId(), (Object)this.psdynainst.getPSDynaInstId()) != 0L) {
                this.psdynainst = null;
            }
            if (this.psdynainst == null) {
                PSDynaInst pSDynaInst = new PSDynaInst();
                pSDynaInst.setPSDynaInstId(this.getPSDynaInstId());
                PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaInstService.autoGet(pSDynaInst);
                this.psdynainst = pSDynaInst;
            }
            return this.psdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaWFVerInst getPSDynaWFVerInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInst();
        }
        if (this.getPSDynaWFVerInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaWFVerInstLock;
        synchronized (n) {
            if (this.psdynawfverinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaWFVerInstId(), (Object)this.psdynawfverinst.getPSDynaWFVerInstId()) != 0L) {
                this.psdynawfverinst = null;
            }
            if (this.psdynawfverinst == null) {
                PSDynaWFVerInst pSDynaWFVerInst = new PSDynaWFVerInst();
                pSDynaWFVerInst.setPSDynaWFVerInstId(this.getPSDynaWFVerInstId());
                PSDynaWFVerInstService pSDynaWFVerInstService = (PSDynaWFVerInstService)ServiceGlobal.getService(PSDynaWFVerInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaWFVerInstService.autoGet(pSDynaWFVerInst);
                this.psdynawfverinst = pSDynaWFVerInst;
            }
            return this.psdynawfverinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaAppVCInst> getPSDynaAppVCInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppVCInsts();
        }
        if (this.getPSDynaAppViewInstId() == null) {
            return null;
        }
        PSDynaAppVCInstService pSDynaAppVCInstService = (PSDynaAppVCInstService)ServiceGlobal.getService(PSDynaAppVCInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaAppVCInstsLock;
        synchronized (n) {
            if (this.psdynaappvcinsts == null) {
                this.psdynaappvcinsts = pSDynaAppVCInstService.selectByPSDynaAppViewInst(this);
            }
            return this.psdynaappvcinsts;
        }
    }

    private PSDynaAppViewInstBase getProxyEntity() {
        return this.proxyPSDynaAppViewInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaAppViewInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaAppViewInstBase) {
            this.proxyPSDynaAppViewInstBase = (PSDynaAppViewInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPTION, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODEL, 3);
        fieldIndexMap.put(FIELD_DYNAVIEWPARAM, 4);
        fieldIndexMap.put(FIELD_DYNAVIEWPARAM2, 5);
        fieldIndexMap.put(FIELD_DYNAVIEWPARAM3, 6);
        fieldIndexMap.put(FIELD_DYNAVIEWPARAM4, 7);
        fieldIndexMap.put(FIELD_DYNAVIEWPARAM5, 8);
        fieldIndexMap.put(FIELD_DYNAVIEWPARAM6, 9);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 10);
        fieldIndexMap.put(FIELD_INSTVER, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_MOBVIEWFLAG, 13);
        fieldIndexMap.put(FIELD_PDVTPARAM, 14);
        fieldIndexMap.put(FIELD_PREDEFINEDVIEWTYPE, 15);
        fieldIndexMap.put(FIELD_PSDYNAAPPID, 16);
        fieldIndexMap.put(FIELD_PSDYNAAPPNAME, 17);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWID, 18);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWINSTID, 19);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWINSTNAME, 20);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWNAME, 21);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 22);
        fieldIndexMap.put(FIELD_PSDYNAINSTNAME, 23);
        fieldIndexMap.put(FIELD_PSDYNAWFVERINSTID, 24);
        fieldIndexMap.put(FIELD_PSDYNAWFVERINSTNAME, 25);
        fieldIndexMap.put(FIELD_SUBCAPTION, 26);
        fieldIndexMap.put(FIELD_TITLE, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_VIEWACTIONS, 30);
        fieldIndexMap.put(FIELD_VIEWPARAM, 31);
        fieldIndexMap.put(FIELD_VIEWPARAM2, 32);
        fieldIndexMap.put(FIELD_VIEWPARAM5, 33);
        fieldIndexMap.put(FIELD_VIEWPARAM6, 34);
        fieldIndexMap.put(FIELD_WFVIEWPARAM, 35);
        fieldIndexMap.put(FIELD_WFVIEWPARAM2, 36);
        fieldIndexMap.put(FIELD_WFVIEWPARAM3, 37);
        fieldIndexMap.put(FIELD_WFVIEWPARAM4, 38);
    }
}

