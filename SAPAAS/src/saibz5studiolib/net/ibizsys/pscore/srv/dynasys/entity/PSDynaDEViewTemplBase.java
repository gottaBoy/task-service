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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDEViewTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaDEViewTemplBase.class);
    public static final String FIELD_ACCUSERMODE = "ACCUSERMODE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPVIEWCNT = "PSAPPVIEWCNT";
    public static final String FIELD_PSDYNADETEMPLID = "PSDYNADETEMPLID";
    public static final String FIELD_PSDYNADETEMPLNAME = "PSDYNADETEMPLNAME";
    public static final String FIELD_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String FIELD_PSDYNADEVIEWTEMPLNAME = "PSDYNADEVIEWTEMPLNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWTYPE = "VIEWTYPE";
    private static final int INDEX_ACCUSERMODE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSAPPVIEWCNT = 5;
    private static final int INDEX_PSDYNADETEMPLID = 6;
    private static final int INDEX_PSDYNADETEMPLNAME = 7;
    private static final int INDEX_PSDYNADEVIEWTEMPLID = 8;
    private static final int INDEX_PSDYNADEVIEWTEMPLNAME = 9;
    private static final int INDEX_PSSYSUNIRESID = 10;
    private static final int INDEX_PSSYSUNIRESNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VIEWTYPE = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaDEViewTemplBase proxyPSDynaDEViewTemplBase = null;
    private boolean accusermodeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappviewcntDirtyFlag = false;
    private boolean psdynadetemplidDirtyFlag = false;
    private boolean psdynadetemplnameDirtyFlag = false;
    private boolean psdynadeviewtemplidDirtyFlag = false;
    private boolean psdynadeviewtemplnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewtypeDirtyFlag = false;
    @Column(name="accusermode")
    private String accusermode;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappviewcnt")
    private Integer psappviewcnt;
    @Column(name="psdynadetemplid")
    private String psdynadetemplid;
    @Column(name="psdynadetemplname")
    private String psdynadetemplname;
    @Column(name="psdynadeviewtemplid")
    private String psdynadeviewtemplid;
    @Column(name="psdynadeviewtemplname")
    private String psdynadeviewtemplname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
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
    @Column(name="viewtype")
    private String viewtype;
    private Integer objPSDynaDETemplLock = new Integer(1);
    private PSDynaDETempl psdynadetempl = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSAppViewsLock = new Integer(1);
    private ArrayList<PSAppView> psappviews = null;

    public void setAccUserMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccUserMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.accusermode = string;
        this.accusermodeDirtyFlag = true;
    }

    public String getAccUserMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccUserMode();
        }
        return this.accusermode;
    }

    public boolean isAccUserModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccUserModeDirty();
        }
        return this.accusermodeDirtyFlag;
    }

    public void resetAccUserMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccUserMode();
            return;
        }
        this.accusermodeDirtyFlag = false;
        this.accusermode = null;
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

    public void setPSAppViewCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewCnt(n);
            return;
        }
        this.psappviewcnt = n;
        this.psappviewcntDirtyFlag = true;
    }

    public Integer getPSAppViewCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewCnt();
        }
        return this.psappviewcnt;
    }

    public boolean isPSAppViewCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewCntDirty();
        }
        return this.psappviewcntDirtyFlag;
    }

    public void resetPSAppViewCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewCnt();
            return;
        }
        this.psappviewcntDirtyFlag = false;
        this.psappviewcnt = null;
    }

    public void setPSDynaDETemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDETemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadetemplid = string;
        this.psdynadetemplidDirtyFlag = true;
    }

    public String getPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETemplId();
        }
        return this.psdynadetemplid;
    }

    public boolean isPSDynaDETemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDETemplIdDirty();
        }
        return this.psdynadetemplidDirtyFlag;
    }

    public void resetPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDETemplId();
            return;
        }
        this.psdynadetemplidDirtyFlag = false;
        this.psdynadetemplid = null;
    }

    public void setPSDynaDETemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDETemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadetemplname = string;
        this.psdynadetemplnameDirtyFlag = true;
    }

    public String getPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETemplName();
        }
        return this.psdynadetemplname;
    }

    public boolean isPSDynaDETemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDETemplNameDirty();
        }
        return this.psdynadetemplnameDirtyFlag;
    }

    public void resetPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDETemplName();
            return;
        }
        this.psdynadetemplnameDirtyFlag = false;
        this.psdynadetemplname = null;
    }

    public void setPSDynaDEViewTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEViewTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeviewtemplid = string;
        this.psdynadeviewtemplidDirtyFlag = true;
    }

    public String getPSDynaDEViewTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEViewTemplId();
        }
        return this.psdynadeviewtemplid;
    }

    public boolean isPSDynaDEViewTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEViewTemplIdDirty();
        }
        return this.psdynadeviewtemplidDirtyFlag;
    }

    public void resetPSDynaDEViewTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEViewTemplId();
            return;
        }
        this.psdynadeviewtemplidDirtyFlag = false;
        this.psdynadeviewtemplid = null;
    }

    public void setPSDynaDEViewTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEViewTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeviewtemplname = string;
        this.psdynadeviewtemplnameDirtyFlag = true;
    }

    public String getPSDynaDEViewTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEViewTemplName();
        }
        return this.psdynadeviewtemplname;
    }

    public boolean isPSDynaDEViewTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEViewTemplNameDirty();
        }
        return this.psdynadeviewtemplnameDirtyFlag;
    }

    public void resetPSDynaDEViewTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEViewTemplName();
            return;
        }
        this.psdynadeviewtemplnameDirtyFlag = false;
        this.psdynadeviewtemplname = null;
    }

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
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

    public void setViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewtype = string;
        this.viewtypeDirtyFlag = true;
    }

    public String getViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewType();
        }
        return this.viewtype;
    }

    public boolean isViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewTypeDirty();
        }
        return this.viewtypeDirtyFlag;
    }

    public void resetViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewType();
            return;
        }
        this.viewtypeDirtyFlag = false;
        this.viewtype = null;
    }

    protected void onReset() {
        PSDynaDEViewTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaDEViewTemplBase pSDynaDEViewTemplBase) {
        pSDynaDEViewTemplBase.resetAccUserMode();
        pSDynaDEViewTemplBase.resetCodeName();
        pSDynaDEViewTemplBase.resetCreateDate();
        pSDynaDEViewTemplBase.resetCreateMan();
        pSDynaDEViewTemplBase.resetMemo();
        pSDynaDEViewTemplBase.resetPSAppViewCnt();
        pSDynaDEViewTemplBase.resetPSDynaDETemplId();
        pSDynaDEViewTemplBase.resetPSDynaDETemplName();
        pSDynaDEViewTemplBase.resetPSDynaDEViewTemplId();
        pSDynaDEViewTemplBase.resetPSDynaDEViewTemplName();
        pSDynaDEViewTemplBase.resetPSSysUniResId();
        pSDynaDEViewTemplBase.resetPSSysUniResName();
        pSDynaDEViewTemplBase.resetUpdateDate();
        pSDynaDEViewTemplBase.resetUpdateMan();
        pSDynaDEViewTemplBase.resetUserCat();
        pSDynaDEViewTemplBase.resetUserTag();
        pSDynaDEViewTemplBase.resetUserTag2();
        pSDynaDEViewTemplBase.resetUserTag3();
        pSDynaDEViewTemplBase.resetUserTag4();
        pSDynaDEViewTemplBase.resetViewType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccUserModeDirty()) {
            hashMap.put(FIELD_ACCUSERMODE, this.getAccUserMode());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppViewCntDirty()) {
            hashMap.put(FIELD_PSAPPVIEWCNT, this.getPSAppViewCnt());
        }
        if (!bl || this.isPSDynaDETemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADETEMPLID, this.getPSDynaDETemplId());
        }
        if (!bl || this.isPSDynaDETemplNameDirty()) {
            hashMap.put(FIELD_PSDYNADETEMPLNAME, this.getPSDynaDETemplName());
        }
        if (!bl || this.isPSDynaDEViewTemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADEVIEWTEMPLID, this.getPSDynaDEViewTemplId());
        }
        if (!bl || this.isPSDynaDEViewTemplNameDirty()) {
            hashMap.put(FIELD_PSDYNADEVIEWTEMPLNAME, this.getPSDynaDEViewTemplName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
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
        if (!bl || this.isViewTypeDirty()) {
            hashMap.put(FIELD_VIEWTYPE, this.getViewType());
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
        return PSDynaDEViewTemplBase.get(this, n);
    }

    private static Object get(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEViewTemplBase.getAccUserMode();
            }
            case 1: {
                return pSDynaDEViewTemplBase.getCodeName();
            }
            case 2: {
                return pSDynaDEViewTemplBase.getCreateDate();
            }
            case 3: {
                return pSDynaDEViewTemplBase.getCreateMan();
            }
            case 4: {
                return pSDynaDEViewTemplBase.getMemo();
            }
            case 5: {
                return pSDynaDEViewTemplBase.getPSAppViewCnt();
            }
            case 6: {
                return pSDynaDEViewTemplBase.getPSDynaDETemplId();
            }
            case 7: {
                return pSDynaDEViewTemplBase.getPSDynaDETemplName();
            }
            case 8: {
                return pSDynaDEViewTemplBase.getPSDynaDEViewTemplId();
            }
            case 9: {
                return pSDynaDEViewTemplBase.getPSDynaDEViewTemplName();
            }
            case 10: {
                return pSDynaDEViewTemplBase.getPSSysUniResId();
            }
            case 11: {
                return pSDynaDEViewTemplBase.getPSSysUniResName();
            }
            case 12: {
                return pSDynaDEViewTemplBase.getUpdateDate();
            }
            case 13: {
                return pSDynaDEViewTemplBase.getUpdateMan();
            }
            case 14: {
                return pSDynaDEViewTemplBase.getUserCat();
            }
            case 15: {
                return pSDynaDEViewTemplBase.getUserTag();
            }
            case 16: {
                return pSDynaDEViewTemplBase.getUserTag2();
            }
            case 17: {
                return pSDynaDEViewTemplBase.getUserTag3();
            }
            case 18: {
                return pSDynaDEViewTemplBase.getUserTag4();
            }
            case 19: {
                return pSDynaDEViewTemplBase.getViewType();
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
        PSDynaDEViewTemplBase.set(this, n, object);
    }

    private static void set(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEViewTemplBase.setAccUserMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDynaDEViewTemplBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaDEViewTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDynaDEViewTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaDEViewTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaDEViewTemplBase.setPSAppViewCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDynaDEViewTemplBase.setPSDynaDETemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaDEViewTemplBase.setPSDynaDETemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaDEViewTemplBase.setPSDynaDEViewTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaDEViewTemplBase.setPSDynaDEViewTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaDEViewTemplBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaDEViewTemplBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDynaDEViewTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDynaDEViewTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDynaDEViewTemplBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDynaDEViewTemplBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDynaDEViewTemplBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDynaDEViewTemplBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDynaDEViewTemplBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDynaDEViewTemplBase.setViewType(DataObject.getStringValue((Object)object));
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
        return PSDynaDEViewTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEViewTemplBase.getAccUserMode() == null;
            }
            case 1: {
                return pSDynaDEViewTemplBase.getCodeName() == null;
            }
            case 2: {
                return pSDynaDEViewTemplBase.getCreateDate() == null;
            }
            case 3: {
                return pSDynaDEViewTemplBase.getCreateMan() == null;
            }
            case 4: {
                return pSDynaDEViewTemplBase.getMemo() == null;
            }
            case 5: {
                return pSDynaDEViewTemplBase.getPSAppViewCnt() == null;
            }
            case 6: {
                return pSDynaDEViewTemplBase.getPSDynaDETemplId() == null;
            }
            case 7: {
                return pSDynaDEViewTemplBase.getPSDynaDETemplName() == null;
            }
            case 8: {
                return pSDynaDEViewTemplBase.getPSDynaDEViewTemplId() == null;
            }
            case 9: {
                return pSDynaDEViewTemplBase.getPSDynaDEViewTemplName() == null;
            }
            case 10: {
                return pSDynaDEViewTemplBase.getPSSysUniResId() == null;
            }
            case 11: {
                return pSDynaDEViewTemplBase.getPSSysUniResName() == null;
            }
            case 12: {
                return pSDynaDEViewTemplBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDynaDEViewTemplBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDynaDEViewTemplBase.getUserCat() == null;
            }
            case 15: {
                return pSDynaDEViewTemplBase.getUserTag() == null;
            }
            case 16: {
                return pSDynaDEViewTemplBase.getUserTag2() == null;
            }
            case 17: {
                return pSDynaDEViewTemplBase.getUserTag3() == null;
            }
            case 18: {
                return pSDynaDEViewTemplBase.getUserTag4() == null;
            }
            case 19: {
                return pSDynaDEViewTemplBase.getViewType() == null;
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
        return PSDynaDEViewTemplBase.contains(this, n);
    }

    private static boolean contains(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEViewTemplBase.isAccUserModeDirty();
            }
            case 1: {
                return pSDynaDEViewTemplBase.isCodeNameDirty();
            }
            case 2: {
                return pSDynaDEViewTemplBase.isCreateDateDirty();
            }
            case 3: {
                return pSDynaDEViewTemplBase.isCreateManDirty();
            }
            case 4: {
                return pSDynaDEViewTemplBase.isMemoDirty();
            }
            case 5: {
                return pSDynaDEViewTemplBase.isPSAppViewCntDirty();
            }
            case 6: {
                return pSDynaDEViewTemplBase.isPSDynaDETemplIdDirty();
            }
            case 7: {
                return pSDynaDEViewTemplBase.isPSDynaDETemplNameDirty();
            }
            case 8: {
                return pSDynaDEViewTemplBase.isPSDynaDEViewTemplIdDirty();
            }
            case 9: {
                return pSDynaDEViewTemplBase.isPSDynaDEViewTemplNameDirty();
            }
            case 10: {
                return pSDynaDEViewTemplBase.isPSSysUniResIdDirty();
            }
            case 11: {
                return pSDynaDEViewTemplBase.isPSSysUniResNameDirty();
            }
            case 12: {
                return pSDynaDEViewTemplBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDynaDEViewTemplBase.isUpdateManDirty();
            }
            case 14: {
                return pSDynaDEViewTemplBase.isUserCatDirty();
            }
            case 15: {
                return pSDynaDEViewTemplBase.isUserTagDirty();
            }
            case 16: {
                return pSDynaDEViewTemplBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDynaDEViewTemplBase.isUserTag3Dirty();
            }
            case 18: {
                return pSDynaDEViewTemplBase.isUserTag4Dirty();
            }
            case 19: {
                return pSDynaDEViewTemplBase.isViewTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaDEViewTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaDEViewTemplBase.getAccUserMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accusermode", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getAccUserMode()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getPSAppViewCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewcnt", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getPSAppViewCnt()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getPSDynaDETemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadetemplid", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getPSDynaDETemplId()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getPSDynaDETemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadetemplname", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getPSDynaDETemplName()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getPSDynaDEViewTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeviewtemplid", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getPSDynaDEViewTemplId()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getPSDynaDEViewTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeviewtemplname", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getPSDynaDEViewTemplName()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDynaDEViewTemplBase.getViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewtype", (Object)PSDynaDEViewTemplBase.getJSONValue((Object)pSDynaDEViewTemplBase.getViewType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaDEViewTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaDEViewTemplBase.getAccUserMode() != null) {
            object = pSDynaDEViewTemplBase.getAccUserMode();
            xmlNode.setAttribute(FIELD_ACCUSERMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDynaDEViewTemplBase.getCodeName() != null) {
            object = pSDynaDEViewTemplBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getCreateDate() != null) {
            object = pSDynaDEViewTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEViewTemplBase.getCreateMan() != null) {
            object = pSDynaDEViewTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getMemo() != null) {
            object = pSDynaDEViewTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getPSAppViewCnt() != null) {
            object = pSDynaDEViewTemplBase.getPSAppViewCnt();
            xmlNode.setAttribute(FIELD_PSAPPVIEWCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaDEViewTemplBase.getPSDynaDETemplId() != null) {
            object = pSDynaDEViewTemplBase.getPSDynaDETemplId();
            xmlNode.setAttribute(FIELD_PSDYNADETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getPSDynaDETemplName() != null) {
            object = pSDynaDEViewTemplBase.getPSDynaDETemplName();
            xmlNode.setAttribute(FIELD_PSDYNADETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getPSDynaDEViewTemplId() != null) {
            object = pSDynaDEViewTemplBase.getPSDynaDEViewTemplId();
            xmlNode.setAttribute(FIELD_PSDYNADEVIEWTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getPSDynaDEViewTemplName() != null) {
            object = pSDynaDEViewTemplBase.getPSDynaDEViewTemplName();
            xmlNode.setAttribute(FIELD_PSDYNADEVIEWTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getPSSysUniResId() != null) {
            object = pSDynaDEViewTemplBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getPSSysUniResName() != null) {
            object = pSDynaDEViewTemplBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getUpdateDate() != null) {
            object = pSDynaDEViewTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEViewTemplBase.getUpdateMan() != null) {
            object = pSDynaDEViewTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getUserCat() != null) {
            object = pSDynaDEViewTemplBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getUserTag() != null) {
            object = pSDynaDEViewTemplBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getUserTag2() != null) {
            object = pSDynaDEViewTemplBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getUserTag3() != null) {
            object = pSDynaDEViewTemplBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getUserTag4() != null) {
            object = pSDynaDEViewTemplBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEViewTemplBase.getViewType() != null) {
            object = pSDynaDEViewTemplBase.getViewType();
            xmlNode.setAttribute(FIELD_VIEWTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaDEViewTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaDEViewTemplBase.isAccUserModeDirty() && (bl || pSDynaDEViewTemplBase.getAccUserMode() != null)) {
            iDataObject.set(FIELD_ACCUSERMODE, (Object)pSDynaDEViewTemplBase.getAccUserMode());
        }
        if (pSDynaDEViewTemplBase.isCodeNameDirty() && (bl || pSDynaDEViewTemplBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDynaDEViewTemplBase.getCodeName());
        }
        if (pSDynaDEViewTemplBase.isCreateDateDirty() && (bl || pSDynaDEViewTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaDEViewTemplBase.getCreateDate());
        }
        if (pSDynaDEViewTemplBase.isCreateManDirty() && (bl || pSDynaDEViewTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaDEViewTemplBase.getCreateMan());
        }
        if (pSDynaDEViewTemplBase.isMemoDirty() && (bl || pSDynaDEViewTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaDEViewTemplBase.getMemo());
        }
        if (pSDynaDEViewTemplBase.isPSAppViewCntDirty() && (bl || pSDynaDEViewTemplBase.getPSAppViewCnt() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWCNT, (Object)pSDynaDEViewTemplBase.getPSAppViewCnt());
        }
        if (pSDynaDEViewTemplBase.isPSDynaDETemplIdDirty() && (bl || pSDynaDEViewTemplBase.getPSDynaDETemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADETEMPLID, (Object)pSDynaDEViewTemplBase.getPSDynaDETemplId());
        }
        if (pSDynaDEViewTemplBase.isPSDynaDETemplNameDirty() && (bl || pSDynaDEViewTemplBase.getPSDynaDETemplName() != null)) {
            iDataObject.set(FIELD_PSDYNADETEMPLNAME, (Object)pSDynaDEViewTemplBase.getPSDynaDETemplName());
        }
        if (pSDynaDEViewTemplBase.isPSDynaDEViewTemplIdDirty() && (bl || pSDynaDEViewTemplBase.getPSDynaDEViewTemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADEVIEWTEMPLID, (Object)pSDynaDEViewTemplBase.getPSDynaDEViewTemplId());
        }
        if (pSDynaDEViewTemplBase.isPSDynaDEViewTemplNameDirty() && (bl || pSDynaDEViewTemplBase.getPSDynaDEViewTemplName() != null)) {
            iDataObject.set(FIELD_PSDYNADEVIEWTEMPLNAME, (Object)pSDynaDEViewTemplBase.getPSDynaDEViewTemplName());
        }
        if (pSDynaDEViewTemplBase.isPSSysUniResIdDirty() && (bl || pSDynaDEViewTemplBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDynaDEViewTemplBase.getPSSysUniResId());
        }
        if (pSDynaDEViewTemplBase.isPSSysUniResNameDirty() && (bl || pSDynaDEViewTemplBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDynaDEViewTemplBase.getPSSysUniResName());
        }
        if (pSDynaDEViewTemplBase.isUpdateDateDirty() && (bl || pSDynaDEViewTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaDEViewTemplBase.getUpdateDate());
        }
        if (pSDynaDEViewTemplBase.isUpdateManDirty() && (bl || pSDynaDEViewTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaDEViewTemplBase.getUpdateMan());
        }
        if (pSDynaDEViewTemplBase.isUserCatDirty() && (bl || pSDynaDEViewTemplBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDynaDEViewTemplBase.getUserCat());
        }
        if (pSDynaDEViewTemplBase.isUserTagDirty() && (bl || pSDynaDEViewTemplBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDynaDEViewTemplBase.getUserTag());
        }
        if (pSDynaDEViewTemplBase.isUserTag2Dirty() && (bl || pSDynaDEViewTemplBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDynaDEViewTemplBase.getUserTag2());
        }
        if (pSDynaDEViewTemplBase.isUserTag3Dirty() && (bl || pSDynaDEViewTemplBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDynaDEViewTemplBase.getUserTag3());
        }
        if (pSDynaDEViewTemplBase.isUserTag4Dirty() && (bl || pSDynaDEViewTemplBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDynaDEViewTemplBase.getUserTag4());
        }
        if (pSDynaDEViewTemplBase.isViewTypeDirty() && (bl || pSDynaDEViewTemplBase.getViewType() != null)) {
            iDataObject.set(FIELD_VIEWTYPE, (Object)pSDynaDEViewTemplBase.getViewType());
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
        return PSDynaDEViewTemplBase.remove(this, n);
    }

    private static boolean remove(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEViewTemplBase.resetAccUserMode();
                return true;
            }
            case 1: {
                pSDynaDEViewTemplBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDynaDEViewTemplBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDynaDEViewTemplBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDynaDEViewTemplBase.resetMemo();
                return true;
            }
            case 5: {
                pSDynaDEViewTemplBase.resetPSAppViewCnt();
                return true;
            }
            case 6: {
                pSDynaDEViewTemplBase.resetPSDynaDETemplId();
                return true;
            }
            case 7: {
                pSDynaDEViewTemplBase.resetPSDynaDETemplName();
                return true;
            }
            case 8: {
                pSDynaDEViewTemplBase.resetPSDynaDEViewTemplId();
                return true;
            }
            case 9: {
                pSDynaDEViewTemplBase.resetPSDynaDEViewTemplName();
                return true;
            }
            case 10: {
                pSDynaDEViewTemplBase.resetPSSysUniResId();
                return true;
            }
            case 11: {
                pSDynaDEViewTemplBase.resetPSSysUniResName();
                return true;
            }
            case 12: {
                pSDynaDEViewTemplBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDynaDEViewTemplBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDynaDEViewTemplBase.resetUserCat();
                return true;
            }
            case 15: {
                pSDynaDEViewTemplBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDynaDEViewTemplBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDynaDEViewTemplBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSDynaDEViewTemplBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSDynaDEViewTemplBase.resetViewType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaDETempl getPSDynaDETempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETempl();
        }
        if (this.getPSDynaDETemplId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDETemplLock;
        synchronized (n) {
            if (this.psdynadetempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDETemplId(), (Object)this.psdynadetempl.getPSDynaDETemplId()) != 0L) {
                this.psdynadetempl = null;
            }
            if (this.psdynadetempl == null) {
                PSDynaDETempl pSDynaDETempl = new PSDynaDETempl();
                pSDynaDETempl.setPSDynaDETemplId(this.getPSDynaDETemplId());
                PSDynaDETemplService pSDynaDETemplService = (PSDynaDETemplService)ServiceGlobal.getService(PSDynaDETemplService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDETemplService.autoGet((IEntity)pSDynaDETempl);
                this.psdynadetempl = pSDynaDETempl;
            }
            return this.psdynadetempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet((IEntity)pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppView> getPSAppViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViews();
        }
        if (this.getPSDynaDEViewTemplId() == null) {
            return null;
        }
        PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppViewsLock;
        synchronized (n) {
            if (this.psappviews == null) {
                this.psappviews = pSAppViewService.selectByPSDynaDEViewTempl(this);
            }
            return this.psappviews;
        }
    }

    private PSDynaDEViewTemplBase getProxyEntity() {
        return this.proxyPSDynaDEViewTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaDEViewTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaDEViewTemplBase) {
            this.proxyPSDynaDEViewTemplBase = (PSDynaDEViewTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCUSERMODE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSAPPVIEWCNT, 5);
        fieldIndexMap.put(FIELD_PSDYNADETEMPLID, 6);
        fieldIndexMap.put(FIELD_PSDYNADETEMPLNAME, 7);
        fieldIndexMap.put(FIELD_PSDYNADEVIEWTEMPLID, 8);
        fieldIndexMap.put(FIELD_PSDYNADEVIEWTEMPLNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 10);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VIEWTYPE, 19);
    }
}

