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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSEditorStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSEditorStyleBase.class);
    public static final String FIELD_AJAXHANDLER = "AJAXHANDLER";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLPARAM = "CTRLPARAM";
    public static final String FIELD_CTRLPARAM10 = "CTRLPARAM10";
    public static final String FIELD_CTRLPARAM11 = "CTRLPARAM11";
    public static final String FIELD_CTRLPARAM12 = "CTRLPARAM12";
    public static final String FIELD_CTRLPARAM2 = "CTRLPARAM2";
    public static final String FIELD_CTRLPARAM3 = "CTRLPARAM3";
    public static final String FIELD_CTRLPARAM4 = "CTRLPARAM4";
    public static final String FIELD_CTRLPARAM5 = "CTRLPARAM5";
    public static final String FIELD_CTRLPARAM6 = "CTRLPARAM6";
    public static final String FIELD_CTRLPARAM7 = "CTRLPARAM7";
    public static final String FIELD_CTRLPARAM8 = "CTRLPARAM8";
    public static final String FIELD_CTRLPARAM9 = "CTRLPARAM9";
    public static final String FIELD_LINKVIEWSHOWMODE = "LINKVIEWSHOWMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSEDITORSTYLEID = "PSEDITORSTYLEID";
    public static final String FIELD_PSEDITORSTYLENAME = "PSEDITORSTYLENAME";
    public static final String FIELD_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String FIELD_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String FIELD_REFVIEWSHOWMODE = "REFVIEWSHOWMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AJAXHANDLER = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CTRLPARAM = 4;
    private static final int INDEX_CTRLPARAM10 = 5;
    private static final int INDEX_CTRLPARAM11 = 6;
    private static final int INDEX_CTRLPARAM12 = 7;
    private static final int INDEX_CTRLPARAM2 = 8;
    private static final int INDEX_CTRLPARAM3 = 9;
    private static final int INDEX_CTRLPARAM4 = 10;
    private static final int INDEX_CTRLPARAM5 = 11;
    private static final int INDEX_CTRLPARAM6 = 12;
    private static final int INDEX_CTRLPARAM7 = 13;
    private static final int INDEX_CTRLPARAM8 = 14;
    private static final int INDEX_CTRLPARAM9 = 15;
    private static final int INDEX_LINKVIEWSHOWMODE = 16;
    private static final int INDEX_MEMO = 17;
    private static final int INDEX_PSEDITORSTYLEID = 18;
    private static final int INDEX_PSEDITORSTYLENAME = 19;
    private static final int INDEX_PSEDITORTYPEID = 20;
    private static final int INDEX_PSEDITORTYPENAME = 21;
    private static final int INDEX_REFVIEWSHOWMODE = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_VALIDFLAG = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSEditorStyleBase proxyPSEditorStyleBase = null;
    private boolean ajaxhandlerDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlparamDirtyFlag = false;
    private boolean ctrlparam10DirtyFlag = false;
    private boolean ctrlparam11DirtyFlag = false;
    private boolean ctrlparam12DirtyFlag = false;
    private boolean ctrlparam2DirtyFlag = false;
    private boolean ctrlparam3DirtyFlag = false;
    private boolean ctrlparam4DirtyFlag = false;
    private boolean ctrlparam5DirtyFlag = false;
    private boolean ctrlparam6DirtyFlag = false;
    private boolean ctrlparam7DirtyFlag = false;
    private boolean ctrlparam8DirtyFlag = false;
    private boolean ctrlparam9DirtyFlag = false;
    private boolean linkviewshowmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pseditorstyleidDirtyFlag = false;
    private boolean pseditorstylenameDirtyFlag = false;
    private boolean pseditortypeidDirtyFlag = false;
    private boolean pseditortypenameDirtyFlag = false;
    private boolean refviewshowmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="ajaxhandler")
    private String ajaxhandler;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlparam")
    private String ctrlparam;
    @Column(name="ctrlparam10")
    private Double ctrlparam10;
    @Column(name="ctrlparam11")
    private Integer ctrlparam11;
    @Column(name="ctrlparam12")
    private Integer ctrlparam12;
    @Column(name="ctrlparam2")
    private String ctrlparam2;
    @Column(name="ctrlparam3")
    private String ctrlparam3;
    @Column(name="ctrlparam4")
    private String ctrlparam4;
    @Column(name="ctrlparam5")
    private Integer ctrlparam5;
    @Column(name="ctrlparam6")
    private Integer ctrlparam6;
    @Column(name="ctrlparam7")
    private Integer ctrlparam7;
    @Column(name="ctrlparam8")
    private Integer ctrlparam8;
    @Column(name="ctrlparam9")
    private Double ctrlparam9;
    @Column(name="linkviewshowmode")
    private String linkviewshowmode;
    @Column(name="memo")
    private String memo;
    @Column(name="pseditorstyleid")
    private String pseditorstyleid;
    @Column(name="pseditorstylename")
    private String pseditorstylename;
    @Column(name="pseditortypeid")
    private String pseditortypeid;
    @Column(name="pseditortypename")
    private String pseditortypename;
    @Column(name="refviewshowmode")
    private String refviewshowmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSEditorTypeLock = new Integer(1);
    private PSEditorType pseditortype = null;

    public void setAjaxHandler(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAjaxHandler(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ajaxhandler = string;
        this.ajaxhandlerDirtyFlag = true;
    }

    public String getAjaxHandler() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAjaxHandler();
        }
        return this.ajaxhandler;
    }

    public boolean isAjaxHandlerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAjaxHandlerDirty();
        }
        return this.ajaxhandlerDirtyFlag;
    }

    public void resetAjaxHandler() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAjaxHandler();
            return;
        }
        this.ajaxhandlerDirtyFlag = false;
        this.ajaxhandler = null;
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

    public void setCtrlParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam = string;
        this.ctrlparamDirtyFlag = true;
    }

    public String getCtrlParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam();
        }
        return this.ctrlparam;
    }

    public boolean isCtrlParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParamDirty();
        }
        return this.ctrlparamDirtyFlag;
    }

    public void resetCtrlParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam();
            return;
        }
        this.ctrlparamDirtyFlag = false;
        this.ctrlparam = null;
    }

    public void setCtrlParam10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam10(d);
            return;
        }
        this.ctrlparam10 = d;
        this.ctrlparam10DirtyFlag = true;
    }

    public Double getCtrlParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam10();
        }
        return this.ctrlparam10;
    }

    public boolean isCtrlParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam10Dirty();
        }
        return this.ctrlparam10DirtyFlag;
    }

    public void resetCtrlParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam10();
            return;
        }
        this.ctrlparam10DirtyFlag = false;
        this.ctrlparam10 = null;
    }

    public void setCtrlParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam11(n);
            return;
        }
        this.ctrlparam11 = n;
        this.ctrlparam11DirtyFlag = true;
    }

    public Integer getCtrlParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam11();
        }
        return this.ctrlparam11;
    }

    public boolean isCtrlParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam11Dirty();
        }
        return this.ctrlparam11DirtyFlag;
    }

    public void resetCtrlParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam11();
            return;
        }
        this.ctrlparam11DirtyFlag = false;
        this.ctrlparam11 = null;
    }

    public void setCtrlParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam12(n);
            return;
        }
        this.ctrlparam12 = n;
        this.ctrlparam12DirtyFlag = true;
    }

    public Integer getCtrlParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam12();
        }
        return this.ctrlparam12;
    }

    public boolean isCtrlParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam12Dirty();
        }
        return this.ctrlparam12DirtyFlag;
    }

    public void resetCtrlParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam12();
            return;
        }
        this.ctrlparam12DirtyFlag = false;
        this.ctrlparam12 = null;
    }

    public void setCtrlParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam2 = string;
        this.ctrlparam2DirtyFlag = true;
    }

    public String getCtrlParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam2();
        }
        return this.ctrlparam2;
    }

    public boolean isCtrlParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam2Dirty();
        }
        return this.ctrlparam2DirtyFlag;
    }

    public void resetCtrlParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam2();
            return;
        }
        this.ctrlparam2DirtyFlag = false;
        this.ctrlparam2 = null;
    }

    public void setCtrlParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam3 = string;
        this.ctrlparam3DirtyFlag = true;
    }

    public String getCtrlParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam3();
        }
        return this.ctrlparam3;
    }

    public boolean isCtrlParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam3Dirty();
        }
        return this.ctrlparam3DirtyFlag;
    }

    public void resetCtrlParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam3();
            return;
        }
        this.ctrlparam3DirtyFlag = false;
        this.ctrlparam3 = null;
    }

    public void setCtrlParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam4 = string;
        this.ctrlparam4DirtyFlag = true;
    }

    public String getCtrlParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam4();
        }
        return this.ctrlparam4;
    }

    public boolean isCtrlParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam4Dirty();
        }
        return this.ctrlparam4DirtyFlag;
    }

    public void resetCtrlParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam4();
            return;
        }
        this.ctrlparam4DirtyFlag = false;
        this.ctrlparam4 = null;
    }

    public void setCtrlParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam5(n);
            return;
        }
        this.ctrlparam5 = n;
        this.ctrlparam5DirtyFlag = true;
    }

    public Integer getCtrlParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam5();
        }
        return this.ctrlparam5;
    }

    public boolean isCtrlParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam5Dirty();
        }
        return this.ctrlparam5DirtyFlag;
    }

    public void resetCtrlParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam5();
            return;
        }
        this.ctrlparam5DirtyFlag = false;
        this.ctrlparam5 = null;
    }

    public void setCtrlParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam6(n);
            return;
        }
        this.ctrlparam6 = n;
        this.ctrlparam6DirtyFlag = true;
    }

    public Integer getCtrlParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam6();
        }
        return this.ctrlparam6;
    }

    public boolean isCtrlParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam6Dirty();
        }
        return this.ctrlparam6DirtyFlag;
    }

    public void resetCtrlParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam6();
            return;
        }
        this.ctrlparam6DirtyFlag = false;
        this.ctrlparam6 = null;
    }

    public void setCtrlParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam7(n);
            return;
        }
        this.ctrlparam7 = n;
        this.ctrlparam7DirtyFlag = true;
    }

    public Integer getCtrlParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam7();
        }
        return this.ctrlparam7;
    }

    public boolean isCtrlParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam7Dirty();
        }
        return this.ctrlparam7DirtyFlag;
    }

    public void resetCtrlParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam7();
            return;
        }
        this.ctrlparam7DirtyFlag = false;
        this.ctrlparam7 = null;
    }

    public void setCtrlParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam8(n);
            return;
        }
        this.ctrlparam8 = n;
        this.ctrlparam8DirtyFlag = true;
    }

    public Integer getCtrlParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam8();
        }
        return this.ctrlparam8;
    }

    public boolean isCtrlParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam8Dirty();
        }
        return this.ctrlparam8DirtyFlag;
    }

    public void resetCtrlParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam8();
            return;
        }
        this.ctrlparam8DirtyFlag = false;
        this.ctrlparam8 = null;
    }

    public void setCtrlParam9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam9(d);
            return;
        }
        this.ctrlparam9 = d;
        this.ctrlparam9DirtyFlag = true;
    }

    public Double getCtrlParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam9();
        }
        return this.ctrlparam9;
    }

    public boolean isCtrlParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam9Dirty();
        }
        return this.ctrlparam9DirtyFlag;
    }

    public void resetCtrlParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam9();
            return;
        }
        this.ctrlparam9DirtyFlag = false;
        this.ctrlparam9 = null;
    }

    public void setLinkViewShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkViewShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkviewshowmode = string;
        this.linkviewshowmodeDirtyFlag = true;
    }

    public String getLinkViewShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkViewShowMode();
        }
        return this.linkviewshowmode;
    }

    public boolean isLinkViewShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkViewShowModeDirty();
        }
        return this.linkviewshowmodeDirtyFlag;
    }

    public void resetLinkViewShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkViewShowMode();
            return;
        }
        this.linkviewshowmodeDirtyFlag = false;
        this.linkviewshowmode = null;
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

    public void setPSEditorStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditorstyleid = string;
        this.pseditorstyleidDirtyFlag = true;
    }

    public String getPSEditorStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorStyleId();
        }
        return this.pseditorstyleid;
    }

    public boolean isPSEditorStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorStyleIdDirty();
        }
        return this.pseditorstyleidDirtyFlag;
    }

    public void resetPSEditorStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorStyleId();
            return;
        }
        this.pseditorstyleidDirtyFlag = false;
        this.pseditorstyleid = null;
    }

    public void setPSEditorStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditorstylename = string;
        this.pseditorstylenameDirtyFlag = true;
    }

    public String getPSEditorStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorStyleName();
        }
        return this.pseditorstylename;
    }

    public boolean isPSEditorStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorStyleNameDirty();
        }
        return this.pseditorstylenameDirtyFlag;
    }

    public void resetPSEditorStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorStyleName();
            return;
        }
        this.pseditorstylenameDirtyFlag = false;
        this.pseditorstylename = null;
    }

    public void setPSEditorTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypeid = string;
        this.pseditortypeidDirtyFlag = true;
    }

    public String getPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeId();
        }
        return this.pseditortypeid;
    }

    public boolean isPSEditorTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeIdDirty();
        }
        return this.pseditortypeidDirtyFlag;
    }

    public void resetPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeId();
            return;
        }
        this.pseditortypeidDirtyFlag = false;
        this.pseditortypeid = null;
    }

    public void setPSEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypename = string;
        this.pseditortypenameDirtyFlag = true;
    }

    public String getPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeName();
        }
        return this.pseditortypename;
    }

    public boolean isPSEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeNameDirty();
        }
        return this.pseditortypenameDirtyFlag;
    }

    public void resetPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeName();
            return;
        }
        this.pseditortypenameDirtyFlag = false;
        this.pseditortypename = null;
    }

    public void setRefViewShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefViewShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refviewshowmode = string;
        this.refviewshowmodeDirtyFlag = true;
    }

    public String getRefViewShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefViewShowMode();
        }
        return this.refviewshowmode;
    }

    public boolean isRefViewShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefViewShowModeDirty();
        }
        return this.refviewshowmodeDirtyFlag;
    }

    public void resetRefViewShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefViewShowMode();
            return;
        }
        this.refviewshowmodeDirtyFlag = false;
        this.refviewshowmode = null;
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
        PSEditorStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSEditorStyleBase pSEditorStyleBase) {
        pSEditorStyleBase.resetAjaxHandler();
        pSEditorStyleBase.resetCodeName();
        pSEditorStyleBase.resetCreateDate();
        pSEditorStyleBase.resetCreateMan();
        pSEditorStyleBase.resetCtrlParam();
        pSEditorStyleBase.resetCtrlParam10();
        pSEditorStyleBase.resetCtrlParam11();
        pSEditorStyleBase.resetCtrlParam12();
        pSEditorStyleBase.resetCtrlParam2();
        pSEditorStyleBase.resetCtrlParam3();
        pSEditorStyleBase.resetCtrlParam4();
        pSEditorStyleBase.resetCtrlParam5();
        pSEditorStyleBase.resetCtrlParam6();
        pSEditorStyleBase.resetCtrlParam7();
        pSEditorStyleBase.resetCtrlParam8();
        pSEditorStyleBase.resetCtrlParam9();
        pSEditorStyleBase.resetLinkViewShowMode();
        pSEditorStyleBase.resetMemo();
        pSEditorStyleBase.resetPSEditorStyleId();
        pSEditorStyleBase.resetPSEditorStyleName();
        pSEditorStyleBase.resetPSEditorTypeId();
        pSEditorStyleBase.resetPSEditorTypeName();
        pSEditorStyleBase.resetRefViewShowMode();
        pSEditorStyleBase.resetUpdateDate();
        pSEditorStyleBase.resetUpdateMan();
        pSEditorStyleBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAjaxHandlerDirty()) {
            hashMap.put(FIELD_AJAXHANDLER, this.getAjaxHandler());
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
        if (!bl || this.isCtrlParamDirty()) {
            hashMap.put(FIELD_CTRLPARAM, this.getCtrlParam());
        }
        if (!bl || this.isCtrlParam10Dirty()) {
            hashMap.put(FIELD_CTRLPARAM10, this.getCtrlParam10());
        }
        if (!bl || this.isCtrlParam11Dirty()) {
            hashMap.put(FIELD_CTRLPARAM11, this.getCtrlParam11());
        }
        if (!bl || this.isCtrlParam12Dirty()) {
            hashMap.put(FIELD_CTRLPARAM12, this.getCtrlParam12());
        }
        if (!bl || this.isCtrlParam2Dirty()) {
            hashMap.put(FIELD_CTRLPARAM2, this.getCtrlParam2());
        }
        if (!bl || this.isCtrlParam3Dirty()) {
            hashMap.put(FIELD_CTRLPARAM3, this.getCtrlParam3());
        }
        if (!bl || this.isCtrlParam4Dirty()) {
            hashMap.put(FIELD_CTRLPARAM4, this.getCtrlParam4());
        }
        if (!bl || this.isCtrlParam5Dirty()) {
            hashMap.put(FIELD_CTRLPARAM5, this.getCtrlParam5());
        }
        if (!bl || this.isCtrlParam6Dirty()) {
            hashMap.put(FIELD_CTRLPARAM6, this.getCtrlParam6());
        }
        if (!bl || this.isCtrlParam7Dirty()) {
            hashMap.put(FIELD_CTRLPARAM7, this.getCtrlParam7());
        }
        if (!bl || this.isCtrlParam8Dirty()) {
            hashMap.put(FIELD_CTRLPARAM8, this.getCtrlParam8());
        }
        if (!bl || this.isCtrlParam9Dirty()) {
            hashMap.put(FIELD_CTRLPARAM9, this.getCtrlParam9());
        }
        if (!bl || this.isLinkViewShowModeDirty()) {
            hashMap.put(FIELD_LINKVIEWSHOWMODE, this.getLinkViewShowMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSEditorStyleIdDirty()) {
            hashMap.put(FIELD_PSEDITORSTYLEID, this.getPSEditorStyleId());
        }
        if (!bl || this.isPSEditorStyleNameDirty()) {
            hashMap.put(FIELD_PSEDITORSTYLENAME, this.getPSEditorStyleName());
        }
        if (!bl || this.isPSEditorTypeIdDirty()) {
            hashMap.put(FIELD_PSEDITORTYPEID, this.getPSEditorTypeId());
        }
        if (!bl || this.isPSEditorTypeNameDirty()) {
            hashMap.put(FIELD_PSEDITORTYPENAME, this.getPSEditorTypeName());
        }
        if (!bl || this.isRefViewShowModeDirty()) {
            hashMap.put(FIELD_REFVIEWSHOWMODE, this.getRefViewShowMode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSEditorStyleBase.get(this, n);
    }

    private static Object get(PSEditorStyleBase pSEditorStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSEditorStyleBase.getAjaxHandler();
            }
            case 1: {
                return pSEditorStyleBase.getCodeName();
            }
            case 2: {
                return pSEditorStyleBase.getCreateDate();
            }
            case 3: {
                return pSEditorStyleBase.getCreateMan();
            }
            case 4: {
                return pSEditorStyleBase.getCtrlParam();
            }
            case 5: {
                return pSEditorStyleBase.getCtrlParam10();
            }
            case 6: {
                return pSEditorStyleBase.getCtrlParam11();
            }
            case 7: {
                return pSEditorStyleBase.getCtrlParam12();
            }
            case 8: {
                return pSEditorStyleBase.getCtrlParam2();
            }
            case 9: {
                return pSEditorStyleBase.getCtrlParam3();
            }
            case 10: {
                return pSEditorStyleBase.getCtrlParam4();
            }
            case 11: {
                return pSEditorStyleBase.getCtrlParam5();
            }
            case 12: {
                return pSEditorStyleBase.getCtrlParam6();
            }
            case 13: {
                return pSEditorStyleBase.getCtrlParam7();
            }
            case 14: {
                return pSEditorStyleBase.getCtrlParam8();
            }
            case 15: {
                return pSEditorStyleBase.getCtrlParam9();
            }
            case 16: {
                return pSEditorStyleBase.getLinkViewShowMode();
            }
            case 17: {
                return pSEditorStyleBase.getMemo();
            }
            case 18: {
                return pSEditorStyleBase.getPSEditorStyleId();
            }
            case 19: {
                return pSEditorStyleBase.getPSEditorStyleName();
            }
            case 20: {
                return pSEditorStyleBase.getPSEditorTypeId();
            }
            case 21: {
                return pSEditorStyleBase.getPSEditorTypeName();
            }
            case 22: {
                return pSEditorStyleBase.getRefViewShowMode();
            }
            case 23: {
                return pSEditorStyleBase.getUpdateDate();
            }
            case 24: {
                return pSEditorStyleBase.getUpdateMan();
            }
            case 25: {
                return pSEditorStyleBase.getValidFlag();
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
        PSEditorStyleBase.set(this, n, object);
    }

    private static void set(PSEditorStyleBase pSEditorStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSEditorStyleBase.setAjaxHandler(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSEditorStyleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSEditorStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSEditorStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSEditorStyleBase.setCtrlParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSEditorStyleBase.setCtrlParam10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 6: {
                pSEditorStyleBase.setCtrlParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSEditorStyleBase.setCtrlParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSEditorStyleBase.setCtrlParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSEditorStyleBase.setCtrlParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSEditorStyleBase.setCtrlParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSEditorStyleBase.setCtrlParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSEditorStyleBase.setCtrlParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSEditorStyleBase.setCtrlParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSEditorStyleBase.setCtrlParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSEditorStyleBase.setCtrlParam9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 16: {
                pSEditorStyleBase.setLinkViewShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSEditorStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSEditorStyleBase.setPSEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSEditorStyleBase.setPSEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSEditorStyleBase.setPSEditorTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSEditorStyleBase.setPSEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSEditorStyleBase.setRefViewShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSEditorStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSEditorStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSEditorStyleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSEditorStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSEditorStyleBase pSEditorStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSEditorStyleBase.getAjaxHandler() == null;
            }
            case 1: {
                return pSEditorStyleBase.getCodeName() == null;
            }
            case 2: {
                return pSEditorStyleBase.getCreateDate() == null;
            }
            case 3: {
                return pSEditorStyleBase.getCreateMan() == null;
            }
            case 4: {
                return pSEditorStyleBase.getCtrlParam() == null;
            }
            case 5: {
                return pSEditorStyleBase.getCtrlParam10() == null;
            }
            case 6: {
                return pSEditorStyleBase.getCtrlParam11() == null;
            }
            case 7: {
                return pSEditorStyleBase.getCtrlParam12() == null;
            }
            case 8: {
                return pSEditorStyleBase.getCtrlParam2() == null;
            }
            case 9: {
                return pSEditorStyleBase.getCtrlParam3() == null;
            }
            case 10: {
                return pSEditorStyleBase.getCtrlParam4() == null;
            }
            case 11: {
                return pSEditorStyleBase.getCtrlParam5() == null;
            }
            case 12: {
                return pSEditorStyleBase.getCtrlParam6() == null;
            }
            case 13: {
                return pSEditorStyleBase.getCtrlParam7() == null;
            }
            case 14: {
                return pSEditorStyleBase.getCtrlParam8() == null;
            }
            case 15: {
                return pSEditorStyleBase.getCtrlParam9() == null;
            }
            case 16: {
                return pSEditorStyleBase.getLinkViewShowMode() == null;
            }
            case 17: {
                return pSEditorStyleBase.getMemo() == null;
            }
            case 18: {
                return pSEditorStyleBase.getPSEditorStyleId() == null;
            }
            case 19: {
                return pSEditorStyleBase.getPSEditorStyleName() == null;
            }
            case 20: {
                return pSEditorStyleBase.getPSEditorTypeId() == null;
            }
            case 21: {
                return pSEditorStyleBase.getPSEditorTypeName() == null;
            }
            case 22: {
                return pSEditorStyleBase.getRefViewShowMode() == null;
            }
            case 23: {
                return pSEditorStyleBase.getUpdateDate() == null;
            }
            case 24: {
                return pSEditorStyleBase.getUpdateMan() == null;
            }
            case 25: {
                return pSEditorStyleBase.getValidFlag() == null;
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
        return PSEditorStyleBase.contains(this, n);
    }

    private static boolean contains(PSEditorStyleBase pSEditorStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSEditorStyleBase.isAjaxHandlerDirty();
            }
            case 1: {
                return pSEditorStyleBase.isCodeNameDirty();
            }
            case 2: {
                return pSEditorStyleBase.isCreateDateDirty();
            }
            case 3: {
                return pSEditorStyleBase.isCreateManDirty();
            }
            case 4: {
                return pSEditorStyleBase.isCtrlParamDirty();
            }
            case 5: {
                return pSEditorStyleBase.isCtrlParam10Dirty();
            }
            case 6: {
                return pSEditorStyleBase.isCtrlParam11Dirty();
            }
            case 7: {
                return pSEditorStyleBase.isCtrlParam12Dirty();
            }
            case 8: {
                return pSEditorStyleBase.isCtrlParam2Dirty();
            }
            case 9: {
                return pSEditorStyleBase.isCtrlParam3Dirty();
            }
            case 10: {
                return pSEditorStyleBase.isCtrlParam4Dirty();
            }
            case 11: {
                return pSEditorStyleBase.isCtrlParam5Dirty();
            }
            case 12: {
                return pSEditorStyleBase.isCtrlParam6Dirty();
            }
            case 13: {
                return pSEditorStyleBase.isCtrlParam7Dirty();
            }
            case 14: {
                return pSEditorStyleBase.isCtrlParam8Dirty();
            }
            case 15: {
                return pSEditorStyleBase.isCtrlParam9Dirty();
            }
            case 16: {
                return pSEditorStyleBase.isLinkViewShowModeDirty();
            }
            case 17: {
                return pSEditorStyleBase.isMemoDirty();
            }
            case 18: {
                return pSEditorStyleBase.isPSEditorStyleIdDirty();
            }
            case 19: {
                return pSEditorStyleBase.isPSEditorStyleNameDirty();
            }
            case 20: {
                return pSEditorStyleBase.isPSEditorTypeIdDirty();
            }
            case 21: {
                return pSEditorStyleBase.isPSEditorTypeNameDirty();
            }
            case 22: {
                return pSEditorStyleBase.isRefViewShowModeDirty();
            }
            case 23: {
                return pSEditorStyleBase.isUpdateDateDirty();
            }
            case 24: {
                return pSEditorStyleBase.isUpdateManDirty();
            }
            case 25: {
                return pSEditorStyleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSEditorStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSEditorStyleBase pSEditorStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSEditorStyleBase.getAjaxHandler() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ajaxhandler", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getAjaxHandler()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam10", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam10()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam11", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam11()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam12", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam12()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam2", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam2()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam3", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam3()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam4", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam4()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam5", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam5()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam6", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam6()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam7", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam7()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam8", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam8()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getCtrlParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam9", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getCtrlParam9()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getLinkViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkviewshowmode", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getLinkViewShowMode()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getPSEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditorstyleid", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getPSEditorStyleId()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getPSEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditorstylename", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getPSEditorStyleName()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getPSEditorTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypeid", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getPSEditorTypeId()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getPSEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypename", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getPSEditorTypeName()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getRefViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refviewshowmode", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getRefViewShowMode()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSEditorStyleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSEditorStyleBase.getJSONValue((Object)pSEditorStyleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSEditorStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSEditorStyleBase pSEditorStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSEditorStyleBase.getAjaxHandler() != null) {
            object = pSEditorStyleBase.getAjaxHandler();
            xmlNode.setAttribute(FIELD_AJAXHANDLER, (String)(object == null ? "" : object));
        }
        if (bl || pSEditorStyleBase.getCodeName() != null) {
            object = pSEditorStyleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getCreateDate() != null) {
            object = pSEditorStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSEditorStyleBase.getCreateMan() != null) {
            object = pSEditorStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getCtrlParam() != null) {
            object = pSEditorStyleBase.getCtrlParam();
            xmlNode.setAttribute(FIELD_CTRLPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getCtrlParam10() != null) {
            object = pSEditorStyleBase.getCtrlParam10();
            xmlNode.setAttribute(FIELD_CTRLPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorStyleBase.getCtrlParam11() != null) {
            object = pSEditorStyleBase.getCtrlParam11();
            xmlNode.setAttribute(FIELD_CTRLPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorStyleBase.getCtrlParam12() != null) {
            object = pSEditorStyleBase.getCtrlParam12();
            xmlNode.setAttribute(FIELD_CTRLPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorStyleBase.getCtrlParam2() != null) {
            object = pSEditorStyleBase.getCtrlParam2();
            xmlNode.setAttribute(FIELD_CTRLPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getCtrlParam3() != null) {
            object = pSEditorStyleBase.getCtrlParam3();
            xmlNode.setAttribute(FIELD_CTRLPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getCtrlParam4() != null) {
            object = pSEditorStyleBase.getCtrlParam4();
            xmlNode.setAttribute(FIELD_CTRLPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getCtrlParam5() != null) {
            object = pSEditorStyleBase.getCtrlParam5();
            xmlNode.setAttribute(FIELD_CTRLPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorStyleBase.getCtrlParam6() != null) {
            object = pSEditorStyleBase.getCtrlParam6();
            xmlNode.setAttribute(FIELD_CTRLPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorStyleBase.getCtrlParam7() != null) {
            object = pSEditorStyleBase.getCtrlParam7();
            xmlNode.setAttribute(FIELD_CTRLPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorStyleBase.getCtrlParam8() != null) {
            object = pSEditorStyleBase.getCtrlParam8();
            xmlNode.setAttribute(FIELD_CTRLPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorStyleBase.getCtrlParam9() != null) {
            object = pSEditorStyleBase.getCtrlParam9();
            xmlNode.setAttribute(FIELD_CTRLPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorStyleBase.getLinkViewShowMode() != null) {
            object = pSEditorStyleBase.getLinkViewShowMode();
            xmlNode.setAttribute(FIELD_LINKVIEWSHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getMemo() != null) {
            object = pSEditorStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getPSEditorStyleId() != null) {
            object = pSEditorStyleBase.getPSEditorStyleId();
            xmlNode.setAttribute(FIELD_PSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getPSEditorStyleName() != null) {
            object = pSEditorStyleBase.getPSEditorStyleName();
            xmlNode.setAttribute(FIELD_PSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getPSEditorTypeId() != null) {
            object = pSEditorStyleBase.getPSEditorTypeId();
            xmlNode.setAttribute(FIELD_PSEDITORTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getPSEditorTypeName() != null) {
            object = pSEditorStyleBase.getPSEditorTypeName();
            xmlNode.setAttribute(FIELD_PSEDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getRefViewShowMode() != null) {
            object = pSEditorStyleBase.getRefViewShowMode();
            xmlNode.setAttribute(FIELD_REFVIEWSHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getUpdateDate() != null) {
            object = pSEditorStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSEditorStyleBase.getUpdateMan() != null) {
            object = pSEditorStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSEditorStyleBase.getValidFlag() != null) {
            object = pSEditorStyleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSEditorStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSEditorStyleBase pSEditorStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSEditorStyleBase.isAjaxHandlerDirty() && (bl || pSEditorStyleBase.getAjaxHandler() != null)) {
            iDataObject.set(FIELD_AJAXHANDLER, (Object)pSEditorStyleBase.getAjaxHandler());
        }
        if (pSEditorStyleBase.isCodeNameDirty() && (bl || pSEditorStyleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSEditorStyleBase.getCodeName());
        }
        if (pSEditorStyleBase.isCreateDateDirty() && (bl || pSEditorStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSEditorStyleBase.getCreateDate());
        }
        if (pSEditorStyleBase.isCreateManDirty() && (bl || pSEditorStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSEditorStyleBase.getCreateMan());
        }
        if (pSEditorStyleBase.isCtrlParamDirty() && (bl || pSEditorStyleBase.getCtrlParam() != null)) {
            iDataObject.set(FIELD_CTRLPARAM, (Object)pSEditorStyleBase.getCtrlParam());
        }
        if (pSEditorStyleBase.isCtrlParam10Dirty() && (bl || pSEditorStyleBase.getCtrlParam10() != null)) {
            iDataObject.set(FIELD_CTRLPARAM10, (Object)pSEditorStyleBase.getCtrlParam10());
        }
        if (pSEditorStyleBase.isCtrlParam11Dirty() && (bl || pSEditorStyleBase.getCtrlParam11() != null)) {
            iDataObject.set(FIELD_CTRLPARAM11, (Object)pSEditorStyleBase.getCtrlParam11());
        }
        if (pSEditorStyleBase.isCtrlParam12Dirty() && (bl || pSEditorStyleBase.getCtrlParam12() != null)) {
            iDataObject.set(FIELD_CTRLPARAM12, (Object)pSEditorStyleBase.getCtrlParam12());
        }
        if (pSEditorStyleBase.isCtrlParam2Dirty() && (bl || pSEditorStyleBase.getCtrlParam2() != null)) {
            iDataObject.set(FIELD_CTRLPARAM2, (Object)pSEditorStyleBase.getCtrlParam2());
        }
        if (pSEditorStyleBase.isCtrlParam3Dirty() && (bl || pSEditorStyleBase.getCtrlParam3() != null)) {
            iDataObject.set(FIELD_CTRLPARAM3, (Object)pSEditorStyleBase.getCtrlParam3());
        }
        if (pSEditorStyleBase.isCtrlParam4Dirty() && (bl || pSEditorStyleBase.getCtrlParam4() != null)) {
            iDataObject.set(FIELD_CTRLPARAM4, (Object)pSEditorStyleBase.getCtrlParam4());
        }
        if (pSEditorStyleBase.isCtrlParam5Dirty() && (bl || pSEditorStyleBase.getCtrlParam5() != null)) {
            iDataObject.set(FIELD_CTRLPARAM5, (Object)pSEditorStyleBase.getCtrlParam5());
        }
        if (pSEditorStyleBase.isCtrlParam6Dirty() && (bl || pSEditorStyleBase.getCtrlParam6() != null)) {
            iDataObject.set(FIELD_CTRLPARAM6, (Object)pSEditorStyleBase.getCtrlParam6());
        }
        if (pSEditorStyleBase.isCtrlParam7Dirty() && (bl || pSEditorStyleBase.getCtrlParam7() != null)) {
            iDataObject.set(FIELD_CTRLPARAM7, (Object)pSEditorStyleBase.getCtrlParam7());
        }
        if (pSEditorStyleBase.isCtrlParam8Dirty() && (bl || pSEditorStyleBase.getCtrlParam8() != null)) {
            iDataObject.set(FIELD_CTRLPARAM8, (Object)pSEditorStyleBase.getCtrlParam8());
        }
        if (pSEditorStyleBase.isCtrlParam9Dirty() && (bl || pSEditorStyleBase.getCtrlParam9() != null)) {
            iDataObject.set(FIELD_CTRLPARAM9, (Object)pSEditorStyleBase.getCtrlParam9());
        }
        if (pSEditorStyleBase.isLinkViewShowModeDirty() && (bl || pSEditorStyleBase.getLinkViewShowMode() != null)) {
            iDataObject.set(FIELD_LINKVIEWSHOWMODE, (Object)pSEditorStyleBase.getLinkViewShowMode());
        }
        if (pSEditorStyleBase.isMemoDirty() && (bl || pSEditorStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSEditorStyleBase.getMemo());
        }
        if (pSEditorStyleBase.isPSEditorStyleIdDirty() && (bl || pSEditorStyleBase.getPSEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSEDITORSTYLEID, (Object)pSEditorStyleBase.getPSEditorStyleId());
        }
        if (pSEditorStyleBase.isPSEditorStyleNameDirty() && (bl || pSEditorStyleBase.getPSEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSEDITORSTYLENAME, (Object)pSEditorStyleBase.getPSEditorStyleName());
        }
        if (pSEditorStyleBase.isPSEditorTypeIdDirty() && (bl || pSEditorStyleBase.getPSEditorTypeId() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPEID, (Object)pSEditorStyleBase.getPSEditorTypeId());
        }
        if (pSEditorStyleBase.isPSEditorTypeNameDirty() && (bl || pSEditorStyleBase.getPSEditorTypeName() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPENAME, (Object)pSEditorStyleBase.getPSEditorTypeName());
        }
        if (pSEditorStyleBase.isRefViewShowModeDirty() && (bl || pSEditorStyleBase.getRefViewShowMode() != null)) {
            iDataObject.set(FIELD_REFVIEWSHOWMODE, (Object)pSEditorStyleBase.getRefViewShowMode());
        }
        if (pSEditorStyleBase.isUpdateDateDirty() && (bl || pSEditorStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSEditorStyleBase.getUpdateDate());
        }
        if (pSEditorStyleBase.isUpdateManDirty() && (bl || pSEditorStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSEditorStyleBase.getUpdateMan());
        }
        if (pSEditorStyleBase.isValidFlagDirty() && (bl || pSEditorStyleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSEditorStyleBase.getValidFlag());
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
        return PSEditorStyleBase.remove(this, n);
    }

    private static boolean remove(PSEditorStyleBase pSEditorStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSEditorStyleBase.resetAjaxHandler();
                return true;
            }
            case 1: {
                pSEditorStyleBase.resetCodeName();
                return true;
            }
            case 2: {
                pSEditorStyleBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSEditorStyleBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSEditorStyleBase.resetCtrlParam();
                return true;
            }
            case 5: {
                pSEditorStyleBase.resetCtrlParam10();
                return true;
            }
            case 6: {
                pSEditorStyleBase.resetCtrlParam11();
                return true;
            }
            case 7: {
                pSEditorStyleBase.resetCtrlParam12();
                return true;
            }
            case 8: {
                pSEditorStyleBase.resetCtrlParam2();
                return true;
            }
            case 9: {
                pSEditorStyleBase.resetCtrlParam3();
                return true;
            }
            case 10: {
                pSEditorStyleBase.resetCtrlParam4();
                return true;
            }
            case 11: {
                pSEditorStyleBase.resetCtrlParam5();
                return true;
            }
            case 12: {
                pSEditorStyleBase.resetCtrlParam6();
                return true;
            }
            case 13: {
                pSEditorStyleBase.resetCtrlParam7();
                return true;
            }
            case 14: {
                pSEditorStyleBase.resetCtrlParam8();
                return true;
            }
            case 15: {
                pSEditorStyleBase.resetCtrlParam9();
                return true;
            }
            case 16: {
                pSEditorStyleBase.resetLinkViewShowMode();
                return true;
            }
            case 17: {
                pSEditorStyleBase.resetMemo();
                return true;
            }
            case 18: {
                pSEditorStyleBase.resetPSEditorStyleId();
                return true;
            }
            case 19: {
                pSEditorStyleBase.resetPSEditorStyleName();
                return true;
            }
            case 20: {
                pSEditorStyleBase.resetPSEditorTypeId();
                return true;
            }
            case 21: {
                pSEditorStyleBase.resetPSEditorTypeName();
                return true;
            }
            case 22: {
                pSEditorStyleBase.resetRefViewShowMode();
                return true;
            }
            case 23: {
                pSEditorStyleBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSEditorStyleBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSEditorStyleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSEditorType getPSEditorType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorType();
        }
        if (this.getPSEditorTypeId() == null) {
            return null;
        }
        Integer n = this.objPSEditorTypeLock;
        synchronized (n) {
            if (this.pseditortype != null && DataTypeHelper.compare((int)25, (Object)this.getPSEditorTypeId(), (Object)this.pseditortype.getPSEditorTypeId()) != 0L) {
                this.pseditortype = null;
            }
            if (this.pseditortype == null) {
                PSEditorType pSEditorType = new PSEditorType();
                pSEditorType.setPSEditorTypeId(this.getPSEditorTypeId());
                PSEditorTypeService pSEditorTypeService = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
                pSEditorTypeService.autoGet(pSEditorType);
                this.pseditortype = pSEditorType;
            }
            return this.pseditortype;
        }
    }

    private PSEditorStyleBase getProxyEntity() {
        return this.proxyPSEditorStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSEditorStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSEditorStyleBase) {
            this.proxyPSEditorStyleBase = (PSEditorStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSEditorStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AJAXHANDLER, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CTRLPARAM, 4);
        fieldIndexMap.put(FIELD_CTRLPARAM10, 5);
        fieldIndexMap.put(FIELD_CTRLPARAM11, 6);
        fieldIndexMap.put(FIELD_CTRLPARAM12, 7);
        fieldIndexMap.put(FIELD_CTRLPARAM2, 8);
        fieldIndexMap.put(FIELD_CTRLPARAM3, 9);
        fieldIndexMap.put(FIELD_CTRLPARAM4, 10);
        fieldIndexMap.put(FIELD_CTRLPARAM5, 11);
        fieldIndexMap.put(FIELD_CTRLPARAM6, 12);
        fieldIndexMap.put(FIELD_CTRLPARAM7, 13);
        fieldIndexMap.put(FIELD_CTRLPARAM8, 14);
        fieldIndexMap.put(FIELD_CTRLPARAM9, 15);
        fieldIndexMap.put(FIELD_LINKVIEWSHOWMODE, 16);
        fieldIndexMap.put(FIELD_MEMO, 17);
        fieldIndexMap.put(FIELD_PSEDITORSTYLEID, 18);
        fieldIndexMap.put(FIELD_PSEDITORSTYLENAME, 19);
        fieldIndexMap.put(FIELD_PSEDITORTYPEID, 20);
        fieldIndexMap.put(FIELD_PSEDITORTYPENAME, 21);
        fieldIndexMap.put(FIELD_REFVIEWSHOWMODE, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_VALIDFLAG, 25);
    }
}

