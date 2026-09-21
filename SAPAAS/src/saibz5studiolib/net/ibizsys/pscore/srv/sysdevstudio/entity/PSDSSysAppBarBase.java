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

public abstract class PSDSSysAppBarBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDSSysAppBarBase.class);
    public static final String FIELD_BARPARAM = "BARPARAM";
    public static final String FIELD_BARPARAM10 = "BARPARAM10";
    public static final String FIELD_BARPARAM2 = "BARPARAM2";
    public static final String FIELD_BARPARAM3 = "BARPARAM3";
    public static final String FIELD_BARPARAM4 = "BARPARAM4";
    public static final String FIELD_BARPARAM5 = "BARPARAM5";
    public static final String FIELD_BARPARAM6 = "BARPARAM6";
    public static final String FIELD_BARPARAM7 = "BARPARAM7";
    public static final String FIELD_BARPARAM8 = "BARPARAM8";
    public static final String FIELD_BARPARAM9 = "BARPARAM9";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_NODEFILTER = "NODEFILTER";
    public static final String FIELD_PSDSSYSAPPBARID = "PSDSSYSAPPBARID";
    public static final String FIELD_PSDSSYSAPPBARNAME = "PSDSSYSAPPBARNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_SHOWMODE = "SHOWMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_BARPARAM = 0;
    private static final int INDEX_BARPARAM10 = 1;
    private static final int INDEX_BARPARAM2 = 2;
    private static final int INDEX_BARPARAM3 = 3;
    private static final int INDEX_BARPARAM4 = 4;
    private static final int INDEX_BARPARAM5 = 5;
    private static final int INDEX_BARPARAM6 = 6;
    private static final int INDEX_BARPARAM7 = 7;
    private static final int INDEX_BARPARAM8 = 8;
    private static final int INDEX_BARPARAM9 = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_NODEFILTER = 12;
    private static final int INDEX_PSDSSYSAPPBARID = 13;
    private static final int INDEX_PSDSSYSAPPBARNAME = 14;
    private static final int INDEX_PSSYSAPPID = 15;
    private static final int INDEX_PSSYSAPPNAME = 16;
    private static final int INDEX_PSSYSTEMID = 17;
    private static final int INDEX_SHOWMODE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDSSysAppBarBase proxyPSDSSysAppBarBase = null;
    private boolean barparamDirtyFlag = false;
    private boolean barparam10DirtyFlag = false;
    private boolean barparam2DirtyFlag = false;
    private boolean barparam3DirtyFlag = false;
    private boolean barparam4DirtyFlag = false;
    private boolean barparam5DirtyFlag = false;
    private boolean barparam6DirtyFlag = false;
    private boolean barparam7DirtyFlag = false;
    private boolean barparam8DirtyFlag = false;
    private boolean barparam9DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean nodefilterDirtyFlag = false;
    private boolean psdssysappbaridDirtyFlag = false;
    private boolean psdssysappbarnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean showmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="barparam")
    private String barparam;
    @Column(name="barparam10")
    private Integer barparam10;
    @Column(name="barparam2")
    private String barparam2;
    @Column(name="barparam3")
    private String barparam3;
    @Column(name="barparam4")
    private String barparam4;
    @Column(name="barparam5")
    private Integer barparam5;
    @Column(name="barparam6")
    private Integer barparam6;
    @Column(name="barparam7")
    private Integer barparam7;
    @Column(name="barparam8")
    private Integer barparam8;
    @Column(name="barparam9")
    private Integer barparam9;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="nodefilter")
    private String nodefilter;
    @Column(name="psdssysappbarid")
    private String psdssysappbarid;
    @Column(name="psdssysappbarname")
    private String psdssysappbarname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="showmode")
    private String showmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;

    public void setBarParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barparam = string;
        this.barparamDirtyFlag = true;
    }

    public String getBarParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam();
        }
        return this.barparam;
    }

    public boolean isBarParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParamDirty();
        }
        return this.barparamDirtyFlag;
    }

    public void resetBarParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam();
            return;
        }
        this.barparamDirtyFlag = false;
        this.barparam = null;
    }

    public void setBarParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam10(n);
            return;
        }
        this.barparam10 = n;
        this.barparam10DirtyFlag = true;
    }

    public Integer getBarParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam10();
        }
        return this.barparam10;
    }

    public boolean isBarParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam10Dirty();
        }
        return this.barparam10DirtyFlag;
    }

    public void resetBarParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam10();
            return;
        }
        this.barparam10DirtyFlag = false;
        this.barparam10 = null;
    }

    public void setBarParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barparam2 = string;
        this.barparam2DirtyFlag = true;
    }

    public String getBarParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam2();
        }
        return this.barparam2;
    }

    public boolean isBarParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam2Dirty();
        }
        return this.barparam2DirtyFlag;
    }

    public void resetBarParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam2();
            return;
        }
        this.barparam2DirtyFlag = false;
        this.barparam2 = null;
    }

    public void setBarParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barparam3 = string;
        this.barparam3DirtyFlag = true;
    }

    public String getBarParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam3();
        }
        return this.barparam3;
    }

    public boolean isBarParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam3Dirty();
        }
        return this.barparam3DirtyFlag;
    }

    public void resetBarParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam3();
            return;
        }
        this.barparam3DirtyFlag = false;
        this.barparam3 = null;
    }

    public void setBarParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.barparam4 = string;
        this.barparam4DirtyFlag = true;
    }

    public String getBarParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam4();
        }
        return this.barparam4;
    }

    public boolean isBarParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam4Dirty();
        }
        return this.barparam4DirtyFlag;
    }

    public void resetBarParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam4();
            return;
        }
        this.barparam4DirtyFlag = false;
        this.barparam4 = null;
    }

    public void setBarParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam5(n);
            return;
        }
        this.barparam5 = n;
        this.barparam5DirtyFlag = true;
    }

    public Integer getBarParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam5();
        }
        return this.barparam5;
    }

    public boolean isBarParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam5Dirty();
        }
        return this.barparam5DirtyFlag;
    }

    public void resetBarParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam5();
            return;
        }
        this.barparam5DirtyFlag = false;
        this.barparam5 = null;
    }

    public void setBarParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam6(n);
            return;
        }
        this.barparam6 = n;
        this.barparam6DirtyFlag = true;
    }

    public Integer getBarParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam6();
        }
        return this.barparam6;
    }

    public boolean isBarParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam6Dirty();
        }
        return this.barparam6DirtyFlag;
    }

    public void resetBarParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam6();
            return;
        }
        this.barparam6DirtyFlag = false;
        this.barparam6 = null;
    }

    public void setBarParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam7(n);
            return;
        }
        this.barparam7 = n;
        this.barparam7DirtyFlag = true;
    }

    public Integer getBarParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam7();
        }
        return this.barparam7;
    }

    public boolean isBarParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam7Dirty();
        }
        return this.barparam7DirtyFlag;
    }

    public void resetBarParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam7();
            return;
        }
        this.barparam7DirtyFlag = false;
        this.barparam7 = null;
    }

    public void setBarParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam8(n);
            return;
        }
        this.barparam8 = n;
        this.barparam8DirtyFlag = true;
    }

    public Integer getBarParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam8();
        }
        return this.barparam8;
    }

    public boolean isBarParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam8Dirty();
        }
        return this.barparam8DirtyFlag;
    }

    public void resetBarParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam8();
            return;
        }
        this.barparam8DirtyFlag = false;
        this.barparam8 = null;
    }

    public void setBarParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBarParam9(n);
            return;
        }
        this.barparam9 = n;
        this.barparam9DirtyFlag = true;
    }

    public Integer getBarParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBarParam9();
        }
        return this.barparam9;
    }

    public boolean isBarParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBarParam9Dirty();
        }
        return this.barparam9DirtyFlag;
    }

    public void resetBarParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBarParam9();
            return;
        }
        this.barparam9DirtyFlag = false;
        this.barparam9 = null;
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

    public void setNodeFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodefilter = string;
        this.nodefilterDirtyFlag = true;
    }

    public String getNodeFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeFilter();
        }
        return this.nodefilter;
    }

    public boolean isNodeFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeFilterDirty();
        }
        return this.nodefilterDirtyFlag;
    }

    public void resetNodeFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeFilter();
            return;
        }
        this.nodefilterDirtyFlag = false;
        this.nodefilter = null;
    }

    public void setPSDSSysAppBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSSysAppBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdssysappbarid = string;
        this.psdssysappbaridDirtyFlag = true;
    }

    public String getPSDSSysAppBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSSysAppBarId();
        }
        return this.psdssysappbarid;
    }

    public boolean isPSDSSysAppBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSSysAppBarIdDirty();
        }
        return this.psdssysappbaridDirtyFlag;
    }

    public void resetPSDSSysAppBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSSysAppBarId();
            return;
        }
        this.psdssysappbaridDirtyFlag = false;
        this.psdssysappbarid = null;
    }

    public void setPSDSSysAppBarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSSysAppBarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdssysappbarname = string;
        this.psdssysappbarnameDirtyFlag = true;
    }

    public String getPSDSSysAppBarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSSysAppBarName();
        }
        return this.psdssysappbarname;
    }

    public boolean isPSDSSysAppBarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSSysAppBarNameDirty();
        }
        return this.psdssysappbarnameDirtyFlag;
    }

    public void resetPSDSSysAppBarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSSysAppBarName();
            return;
        }
        this.psdssysappbarnameDirtyFlag = false;
        this.psdssysappbarname = null;
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

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.showmode = string;
        this.showmodeDirtyFlag = true;
    }

    public String getShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowMode();
        }
        return this.showmode;
    }

    public boolean isShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowModeDirty();
        }
        return this.showmodeDirtyFlag;
    }

    public void resetShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowMode();
            return;
        }
        this.showmodeDirtyFlag = false;
        this.showmode = null;
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

    protected void onReset() {
        PSDSSysAppBarBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDSSysAppBarBase pSDSSysAppBarBase) {
        pSDSSysAppBarBase.resetBarParam();
        pSDSSysAppBarBase.resetBarParam10();
        pSDSSysAppBarBase.resetBarParam2();
        pSDSSysAppBarBase.resetBarParam3();
        pSDSSysAppBarBase.resetBarParam4();
        pSDSSysAppBarBase.resetBarParam5();
        pSDSSysAppBarBase.resetBarParam6();
        pSDSSysAppBarBase.resetBarParam7();
        pSDSSysAppBarBase.resetBarParam8();
        pSDSSysAppBarBase.resetBarParam9();
        pSDSSysAppBarBase.resetCreateDate();
        pSDSSysAppBarBase.resetCreateMan();
        pSDSSysAppBarBase.resetNodeFilter();
        pSDSSysAppBarBase.resetPSDSSysAppBarId();
        pSDSSysAppBarBase.resetPSDSSysAppBarName();
        pSDSSysAppBarBase.resetPSSysAppId();
        pSDSSysAppBarBase.resetPSSysAppName();
        pSDSSysAppBarBase.resetPSSystemId();
        pSDSSysAppBarBase.resetShowMode();
        pSDSSysAppBarBase.resetUpdateDate();
        pSDSSysAppBarBase.resetUpdateMan();
        pSDSSysAppBarBase.resetUserTag();
        pSDSSysAppBarBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBarParamDirty()) {
            hashMap.put(FIELD_BARPARAM, this.getBarParam());
        }
        if (!bl || this.isBarParam10Dirty()) {
            hashMap.put(FIELD_BARPARAM10, this.getBarParam10());
        }
        if (!bl || this.isBarParam2Dirty()) {
            hashMap.put(FIELD_BARPARAM2, this.getBarParam2());
        }
        if (!bl || this.isBarParam3Dirty()) {
            hashMap.put(FIELD_BARPARAM3, this.getBarParam3());
        }
        if (!bl || this.isBarParam4Dirty()) {
            hashMap.put(FIELD_BARPARAM4, this.getBarParam4());
        }
        if (!bl || this.isBarParam5Dirty()) {
            hashMap.put(FIELD_BARPARAM5, this.getBarParam5());
        }
        if (!bl || this.isBarParam6Dirty()) {
            hashMap.put(FIELD_BARPARAM6, this.getBarParam6());
        }
        if (!bl || this.isBarParam7Dirty()) {
            hashMap.put(FIELD_BARPARAM7, this.getBarParam7());
        }
        if (!bl || this.isBarParam8Dirty()) {
            hashMap.put(FIELD_BARPARAM8, this.getBarParam8());
        }
        if (!bl || this.isBarParam9Dirty()) {
            hashMap.put(FIELD_BARPARAM9, this.getBarParam9());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isNodeFilterDirty()) {
            hashMap.put(FIELD_NODEFILTER, this.getNodeFilter());
        }
        if (!bl || this.isPSDSSysAppBarIdDirty()) {
            hashMap.put(FIELD_PSDSSYSAPPBARID, this.getPSDSSysAppBarId());
        }
        if (!bl || this.isPSDSSysAppBarNameDirty()) {
            hashMap.put(FIELD_PSDSSYSAPPBARNAME, this.getPSDSSysAppBarName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isShowModeDirty()) {
            hashMap.put(FIELD_SHOWMODE, this.getShowMode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDSSysAppBarBase.get(this, n);
    }

    private static Object get(PSDSSysAppBarBase pSDSSysAppBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSSysAppBarBase.getBarParam();
            }
            case 1: {
                return pSDSSysAppBarBase.getBarParam10();
            }
            case 2: {
                return pSDSSysAppBarBase.getBarParam2();
            }
            case 3: {
                return pSDSSysAppBarBase.getBarParam3();
            }
            case 4: {
                return pSDSSysAppBarBase.getBarParam4();
            }
            case 5: {
                return pSDSSysAppBarBase.getBarParam5();
            }
            case 6: {
                return pSDSSysAppBarBase.getBarParam6();
            }
            case 7: {
                return pSDSSysAppBarBase.getBarParam7();
            }
            case 8: {
                return pSDSSysAppBarBase.getBarParam8();
            }
            case 9: {
                return pSDSSysAppBarBase.getBarParam9();
            }
            case 10: {
                return pSDSSysAppBarBase.getCreateDate();
            }
            case 11: {
                return pSDSSysAppBarBase.getCreateMan();
            }
            case 12: {
                return pSDSSysAppBarBase.getNodeFilter();
            }
            case 13: {
                return pSDSSysAppBarBase.getPSDSSysAppBarId();
            }
            case 14: {
                return pSDSSysAppBarBase.getPSDSSysAppBarName();
            }
            case 15: {
                return pSDSSysAppBarBase.getPSSysAppId();
            }
            case 16: {
                return pSDSSysAppBarBase.getPSSysAppName();
            }
            case 17: {
                return pSDSSysAppBarBase.getPSSystemId();
            }
            case 18: {
                return pSDSSysAppBarBase.getShowMode();
            }
            case 19: {
                return pSDSSysAppBarBase.getUpdateDate();
            }
            case 20: {
                return pSDSSysAppBarBase.getUpdateMan();
            }
            case 21: {
                return pSDSSysAppBarBase.getUserTag();
            }
            case 22: {
                return pSDSSysAppBarBase.getUserTag2();
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
        PSDSSysAppBarBase.set(this, n, object);
    }

    private static void set(PSDSSysAppBarBase pSDSSysAppBarBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDSSysAppBarBase.setBarParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDSSysAppBarBase.setBarParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDSSysAppBarBase.setBarParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDSSysAppBarBase.setBarParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDSSysAppBarBase.setBarParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDSSysAppBarBase.setBarParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDSSysAppBarBase.setBarParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDSSysAppBarBase.setBarParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDSSysAppBarBase.setBarParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDSSysAppBarBase.setBarParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDSSysAppBarBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDSSysAppBarBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDSSysAppBarBase.setNodeFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDSSysAppBarBase.setPSDSSysAppBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDSSysAppBarBase.setPSDSSysAppBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDSSysAppBarBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDSSysAppBarBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDSSysAppBarBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDSSysAppBarBase.setShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDSSysAppBarBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDSSysAppBarBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDSSysAppBarBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDSSysAppBarBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDSSysAppBarBase.isNull(this, n);
    }

    private static boolean isNull(PSDSSysAppBarBase pSDSSysAppBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSSysAppBarBase.getBarParam() == null;
            }
            case 1: {
                return pSDSSysAppBarBase.getBarParam10() == null;
            }
            case 2: {
                return pSDSSysAppBarBase.getBarParam2() == null;
            }
            case 3: {
                return pSDSSysAppBarBase.getBarParam3() == null;
            }
            case 4: {
                return pSDSSysAppBarBase.getBarParam4() == null;
            }
            case 5: {
                return pSDSSysAppBarBase.getBarParam5() == null;
            }
            case 6: {
                return pSDSSysAppBarBase.getBarParam6() == null;
            }
            case 7: {
                return pSDSSysAppBarBase.getBarParam7() == null;
            }
            case 8: {
                return pSDSSysAppBarBase.getBarParam8() == null;
            }
            case 9: {
                return pSDSSysAppBarBase.getBarParam9() == null;
            }
            case 10: {
                return pSDSSysAppBarBase.getCreateDate() == null;
            }
            case 11: {
                return pSDSSysAppBarBase.getCreateMan() == null;
            }
            case 12: {
                return pSDSSysAppBarBase.getNodeFilter() == null;
            }
            case 13: {
                return pSDSSysAppBarBase.getPSDSSysAppBarId() == null;
            }
            case 14: {
                return pSDSSysAppBarBase.getPSDSSysAppBarName() == null;
            }
            case 15: {
                return pSDSSysAppBarBase.getPSSysAppId() == null;
            }
            case 16: {
                return pSDSSysAppBarBase.getPSSysAppName() == null;
            }
            case 17: {
                return pSDSSysAppBarBase.getPSSystemId() == null;
            }
            case 18: {
                return pSDSSysAppBarBase.getShowMode() == null;
            }
            case 19: {
                return pSDSSysAppBarBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDSSysAppBarBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDSSysAppBarBase.getUserTag() == null;
            }
            case 22: {
                return pSDSSysAppBarBase.getUserTag2() == null;
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
        return PSDSSysAppBarBase.contains(this, n);
    }

    private static boolean contains(PSDSSysAppBarBase pSDSSysAppBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSSysAppBarBase.isBarParamDirty();
            }
            case 1: {
                return pSDSSysAppBarBase.isBarParam10Dirty();
            }
            case 2: {
                return pSDSSysAppBarBase.isBarParam2Dirty();
            }
            case 3: {
                return pSDSSysAppBarBase.isBarParam3Dirty();
            }
            case 4: {
                return pSDSSysAppBarBase.isBarParam4Dirty();
            }
            case 5: {
                return pSDSSysAppBarBase.isBarParam5Dirty();
            }
            case 6: {
                return pSDSSysAppBarBase.isBarParam6Dirty();
            }
            case 7: {
                return pSDSSysAppBarBase.isBarParam7Dirty();
            }
            case 8: {
                return pSDSSysAppBarBase.isBarParam8Dirty();
            }
            case 9: {
                return pSDSSysAppBarBase.isBarParam9Dirty();
            }
            case 10: {
                return pSDSSysAppBarBase.isCreateDateDirty();
            }
            case 11: {
                return pSDSSysAppBarBase.isCreateManDirty();
            }
            case 12: {
                return pSDSSysAppBarBase.isNodeFilterDirty();
            }
            case 13: {
                return pSDSSysAppBarBase.isPSDSSysAppBarIdDirty();
            }
            case 14: {
                return pSDSSysAppBarBase.isPSDSSysAppBarNameDirty();
            }
            case 15: {
                return pSDSSysAppBarBase.isPSSysAppIdDirty();
            }
            case 16: {
                return pSDSSysAppBarBase.isPSSysAppNameDirty();
            }
            case 17: {
                return pSDSSysAppBarBase.isPSSystemIdDirty();
            }
            case 18: {
                return pSDSSysAppBarBase.isShowModeDirty();
            }
            case 19: {
                return pSDSSysAppBarBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDSSysAppBarBase.isUpdateManDirty();
            }
            case 21: {
                return pSDSSysAppBarBase.isUserTagDirty();
            }
            case 22: {
                return pSDSSysAppBarBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDSSysAppBarBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDSSysAppBarBase pSDSSysAppBarBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDSSysAppBarBase.getBarParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam10", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam10()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam2", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam2()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam3", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam3()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam4", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam4()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam5", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam5()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam6", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam6()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam7", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam7()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam8", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam8()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getBarParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"barparam9", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getBarParam9()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getNodeFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodefilter", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getNodeFilter()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getPSDSSysAppBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdssysappbarid", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getPSDSSysAppBarId()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getPSDSSysAppBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdssysappbarname", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getPSDSSysAppBarName()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showmode", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getShowMode()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDSSysAppBarBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDSSysAppBarBase.getJSONValue((Object)pSDSSysAppBarBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDSSysAppBarBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDSSysAppBarBase pSDSSysAppBarBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDSSysAppBarBase.getBarParam() != null) {
            object = pSDSSysAppBarBase.getBarParam();
            xmlNode.setAttribute(FIELD_BARPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getBarParam10() != null) {
            object = pSDSSysAppBarBase.getBarParam10();
            xmlNode.setAttribute(FIELD_BARPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSSysAppBarBase.getBarParam2() != null) {
            object = pSDSSysAppBarBase.getBarParam2();
            xmlNode.setAttribute(FIELD_BARPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getBarParam3() != null) {
            object = pSDSSysAppBarBase.getBarParam3();
            xmlNode.setAttribute(FIELD_BARPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getBarParam4() != null) {
            object = pSDSSysAppBarBase.getBarParam4();
            xmlNode.setAttribute(FIELD_BARPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getBarParam5() != null) {
            object = pSDSSysAppBarBase.getBarParam5();
            xmlNode.setAttribute(FIELD_BARPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSSysAppBarBase.getBarParam6() != null) {
            object = pSDSSysAppBarBase.getBarParam6();
            xmlNode.setAttribute(FIELD_BARPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSSysAppBarBase.getBarParam7() != null) {
            object = pSDSSysAppBarBase.getBarParam7();
            xmlNode.setAttribute(FIELD_BARPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSSysAppBarBase.getBarParam8() != null) {
            object = pSDSSysAppBarBase.getBarParam8();
            xmlNode.setAttribute(FIELD_BARPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSSysAppBarBase.getBarParam9() != null) {
            object = pSDSSysAppBarBase.getBarParam9();
            xmlNode.setAttribute(FIELD_BARPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSSysAppBarBase.getCreateDate() != null) {
            object = pSDSSysAppBarBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSSysAppBarBase.getCreateMan() != null) {
            object = pSDSSysAppBarBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getNodeFilter() != null) {
            object = pSDSSysAppBarBase.getNodeFilter();
            xmlNode.setAttribute(FIELD_NODEFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getPSDSSysAppBarId() != null) {
            object = pSDSSysAppBarBase.getPSDSSysAppBarId();
            xmlNode.setAttribute(FIELD_PSDSSYSAPPBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getPSDSSysAppBarName() != null) {
            object = pSDSSysAppBarBase.getPSDSSysAppBarName();
            xmlNode.setAttribute(FIELD_PSDSSYSAPPBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getPSSysAppId() != null) {
            object = pSDSSysAppBarBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getPSSysAppName() != null) {
            object = pSDSSysAppBarBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getPSSystemId() != null) {
            object = pSDSSysAppBarBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getShowMode() != null) {
            object = pSDSSysAppBarBase.getShowMode();
            xmlNode.setAttribute(FIELD_SHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getUpdateDate() != null) {
            object = pSDSSysAppBarBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSSysAppBarBase.getUpdateMan() != null) {
            object = pSDSSysAppBarBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getUserTag() != null) {
            object = pSDSSysAppBarBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarBase.getUserTag2() != null) {
            object = pSDSSysAppBarBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDSSysAppBarBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDSSysAppBarBase pSDSSysAppBarBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDSSysAppBarBase.isBarParamDirty() && (bl || pSDSSysAppBarBase.getBarParam() != null)) {
            iDataObject.set(FIELD_BARPARAM, (Object)pSDSSysAppBarBase.getBarParam());
        }
        if (pSDSSysAppBarBase.isBarParam10Dirty() && (bl || pSDSSysAppBarBase.getBarParam10() != null)) {
            iDataObject.set(FIELD_BARPARAM10, (Object)pSDSSysAppBarBase.getBarParam10());
        }
        if (pSDSSysAppBarBase.isBarParam2Dirty() && (bl || pSDSSysAppBarBase.getBarParam2() != null)) {
            iDataObject.set(FIELD_BARPARAM2, (Object)pSDSSysAppBarBase.getBarParam2());
        }
        if (pSDSSysAppBarBase.isBarParam3Dirty() && (bl || pSDSSysAppBarBase.getBarParam3() != null)) {
            iDataObject.set(FIELD_BARPARAM3, (Object)pSDSSysAppBarBase.getBarParam3());
        }
        if (pSDSSysAppBarBase.isBarParam4Dirty() && (bl || pSDSSysAppBarBase.getBarParam4() != null)) {
            iDataObject.set(FIELD_BARPARAM4, (Object)pSDSSysAppBarBase.getBarParam4());
        }
        if (pSDSSysAppBarBase.isBarParam5Dirty() && (bl || pSDSSysAppBarBase.getBarParam5() != null)) {
            iDataObject.set(FIELD_BARPARAM5, (Object)pSDSSysAppBarBase.getBarParam5());
        }
        if (pSDSSysAppBarBase.isBarParam6Dirty() && (bl || pSDSSysAppBarBase.getBarParam6() != null)) {
            iDataObject.set(FIELD_BARPARAM6, (Object)pSDSSysAppBarBase.getBarParam6());
        }
        if (pSDSSysAppBarBase.isBarParam7Dirty() && (bl || pSDSSysAppBarBase.getBarParam7() != null)) {
            iDataObject.set(FIELD_BARPARAM7, (Object)pSDSSysAppBarBase.getBarParam7());
        }
        if (pSDSSysAppBarBase.isBarParam8Dirty() && (bl || pSDSSysAppBarBase.getBarParam8() != null)) {
            iDataObject.set(FIELD_BARPARAM8, (Object)pSDSSysAppBarBase.getBarParam8());
        }
        if (pSDSSysAppBarBase.isBarParam9Dirty() && (bl || pSDSSysAppBarBase.getBarParam9() != null)) {
            iDataObject.set(FIELD_BARPARAM9, (Object)pSDSSysAppBarBase.getBarParam9());
        }
        if (pSDSSysAppBarBase.isCreateDateDirty() && (bl || pSDSSysAppBarBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDSSysAppBarBase.getCreateDate());
        }
        if (pSDSSysAppBarBase.isCreateManDirty() && (bl || pSDSSysAppBarBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDSSysAppBarBase.getCreateMan());
        }
        if (pSDSSysAppBarBase.isNodeFilterDirty() && (bl || pSDSSysAppBarBase.getNodeFilter() != null)) {
            iDataObject.set(FIELD_NODEFILTER, (Object)pSDSSysAppBarBase.getNodeFilter());
        }
        if (pSDSSysAppBarBase.isPSDSSysAppBarIdDirty() && (bl || pSDSSysAppBarBase.getPSDSSysAppBarId() != null)) {
            iDataObject.set(FIELD_PSDSSYSAPPBARID, (Object)pSDSSysAppBarBase.getPSDSSysAppBarId());
        }
        if (pSDSSysAppBarBase.isPSDSSysAppBarNameDirty() && (bl || pSDSSysAppBarBase.getPSDSSysAppBarName() != null)) {
            iDataObject.set(FIELD_PSDSSYSAPPBARNAME, (Object)pSDSSysAppBarBase.getPSDSSysAppBarName());
        }
        if (pSDSSysAppBarBase.isPSSysAppIdDirty() && (bl || pSDSSysAppBarBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDSSysAppBarBase.getPSSysAppId());
        }
        if (pSDSSysAppBarBase.isPSSysAppNameDirty() && (bl || pSDSSysAppBarBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSDSSysAppBarBase.getPSSysAppName());
        }
        if (pSDSSysAppBarBase.isPSSystemIdDirty() && (bl || pSDSSysAppBarBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDSSysAppBarBase.getPSSystemId());
        }
        if (pSDSSysAppBarBase.isShowModeDirty() && (bl || pSDSSysAppBarBase.getShowMode() != null)) {
            iDataObject.set(FIELD_SHOWMODE, (Object)pSDSSysAppBarBase.getShowMode());
        }
        if (pSDSSysAppBarBase.isUpdateDateDirty() && (bl || pSDSSysAppBarBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDSSysAppBarBase.getUpdateDate());
        }
        if (pSDSSysAppBarBase.isUpdateManDirty() && (bl || pSDSSysAppBarBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDSSysAppBarBase.getUpdateMan());
        }
        if (pSDSSysAppBarBase.isUserTagDirty() && (bl || pSDSSysAppBarBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDSSysAppBarBase.getUserTag());
        }
        if (pSDSSysAppBarBase.isUserTag2Dirty() && (bl || pSDSSysAppBarBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDSSysAppBarBase.getUserTag2());
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
        return PSDSSysAppBarBase.remove(this, n);
    }

    private static boolean remove(PSDSSysAppBarBase pSDSSysAppBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDSSysAppBarBase.resetBarParam();
                return true;
            }
            case 1: {
                pSDSSysAppBarBase.resetBarParam10();
                return true;
            }
            case 2: {
                pSDSSysAppBarBase.resetBarParam2();
                return true;
            }
            case 3: {
                pSDSSysAppBarBase.resetBarParam3();
                return true;
            }
            case 4: {
                pSDSSysAppBarBase.resetBarParam4();
                return true;
            }
            case 5: {
                pSDSSysAppBarBase.resetBarParam5();
                return true;
            }
            case 6: {
                pSDSSysAppBarBase.resetBarParam6();
                return true;
            }
            case 7: {
                pSDSSysAppBarBase.resetBarParam7();
                return true;
            }
            case 8: {
                pSDSSysAppBarBase.resetBarParam8();
                return true;
            }
            case 9: {
                pSDSSysAppBarBase.resetBarParam9();
                return true;
            }
            case 10: {
                pSDSSysAppBarBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSDSSysAppBarBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSDSSysAppBarBase.resetNodeFilter();
                return true;
            }
            case 13: {
                pSDSSysAppBarBase.resetPSDSSysAppBarId();
                return true;
            }
            case 14: {
                pSDSSysAppBarBase.resetPSDSSysAppBarName();
                return true;
            }
            case 15: {
                pSDSSysAppBarBase.resetPSSysAppId();
                return true;
            }
            case 16: {
                pSDSSysAppBarBase.resetPSSysAppName();
                return true;
            }
            case 17: {
                pSDSSysAppBarBase.resetPSSystemId();
                return true;
            }
            case 18: {
                pSDSSysAppBarBase.resetShowMode();
                return true;
            }
            case 19: {
                pSDSSysAppBarBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDSSysAppBarBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDSSysAppBarBase.resetUserTag();
                return true;
            }
            case 22: {
                pSDSSysAppBarBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDSSysAppBarBase getProxyEntity() {
        return this.proxyPSDSSysAppBarBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDSSysAppBarBase = null;
        if (iDataObject != null && iDataObject instanceof PSDSSysAppBarBase) {
            this.proxyPSDSSysAppBarBase = (PSDSSysAppBarBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDSSysAppBarService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BARPARAM, 0);
        fieldIndexMap.put(FIELD_BARPARAM10, 1);
        fieldIndexMap.put(FIELD_BARPARAM2, 2);
        fieldIndexMap.put(FIELD_BARPARAM3, 3);
        fieldIndexMap.put(FIELD_BARPARAM4, 4);
        fieldIndexMap.put(FIELD_BARPARAM5, 5);
        fieldIndexMap.put(FIELD_BARPARAM6, 6);
        fieldIndexMap.put(FIELD_BARPARAM7, 7);
        fieldIndexMap.put(FIELD_BARPARAM8, 8);
        fieldIndexMap.put(FIELD_BARPARAM9, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_NODEFILTER, 12);
        fieldIndexMap.put(FIELD_PSDSSYSAPPBARID, 13);
        fieldIndexMap.put(FIELD_PSDSSYSAPPBARNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 17);
        fieldIndexMap.put(FIELD_SHOWMODE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
    }
}

