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
import net.ibizsys.pscore.srv.config.entity.PSSysModelFunc;
import net.ibizsys.pscore.srv.config.service.PSSysModelFuncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelFuncTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelFuncTemplBase.class);
    public static final String FIELD_ANGULARJS = "ANGULARJS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXTJS = "EXTJS";
    public static final String FIELD_FR7 = "FR7";
    public static final String FIELD_J2EE6_IBIZSYSRT = "J2EE6_IBIZSYSRT";
    public static final String FIELD_J2EE6_IBIZSYSRT_R2 = "J2EE6_IBIZSYSRT_R2";
    public static final String FIELD_JQUERY = "JQUERY";
    public static final String FIELD_JQUERY_R2 = "JQUERY_R2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSMODELFUNCID = "PSSYSMODELFUNCID";
    public static final String FIELD_PSSYSMODELFUNCNAME = "PSSYSMODELFUNCNAME";
    public static final String FIELD_PSSYSMODELFUNCTEMPLID = "PSSYSMODELFUNCTEMPLID";
    public static final String FIELD_PSSYSMODELFUNCTEMPLNAME = "PSSYSMODELFUNCTEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ANGULARJS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_EXTJS = 3;
    private static final int INDEX_FR7 = 4;
    private static final int INDEX_J2EE6_IBIZSYSRT = 5;
    private static final int INDEX_J2EE6_IBIZSYSRT_R2 = 6;
    private static final int INDEX_JQUERY = 7;
    private static final int INDEX_JQUERY_R2 = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSSYSMODELFUNCID = 10;
    private static final int INDEX_PSSYSMODELFUNCNAME = 11;
    private static final int INDEX_PSSYSMODELFUNCTEMPLID = 12;
    private static final int INDEX_PSSYSMODELFUNCTEMPLNAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelFuncTemplBase proxyPSSysModelFuncTemplBase = null;
    private boolean angularjsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean extjsDirtyFlag = false;
    private boolean fr7DirtyFlag = false;
    private boolean j2ee6_ibizsysrtDirtyFlag = false;
    private boolean j2ee6_ibizsysrt_r2DirtyFlag = false;
    private boolean jqueryDirtyFlag = false;
    private boolean jquery_r2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysmodelfuncidDirtyFlag = false;
    private boolean pssysmodelfuncnameDirtyFlag = false;
    private boolean pssysmodelfunctemplidDirtyFlag = false;
    private boolean pssysmodelfunctemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="angularjs")
    private String angularjs;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="extjs")
    private String extjs;
    @Column(name="fr7")
    private String fr7;
    @Column(name="j2ee6_ibizsysrt")
    private String j2ee6_ibizsysrt;
    @Column(name="j2ee6_ibizsysrt_r2")
    private String j2ee6_ibizsysrt_r2;
    @Column(name="jquery")
    private String jquery;
    @Column(name="jquery_r2")
    private String jquery_r2;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysmodelfuncid")
    private String pssysmodelfuncid;
    @Column(name="pssysmodelfuncname")
    private String pssysmodelfuncname;
    @Column(name="pssysmodelfunctemplid")
    private String pssysmodelfunctemplid;
    @Column(name="pssysmodelfunctemplname")
    private String pssysmodelfunctemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysModelFuncLock = new Integer(1);
    private PSSysModelFunc pssysmodelfunc = null;

    public void setANGULARJS(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setANGULARJS(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.angularjs = string;
        this.angularjsDirtyFlag = true;
    }

    public String getANGULARJS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getANGULARJS();
        }
        return this.angularjs;
    }

    public boolean isANGULARJSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isANGULARJSDirty();
        }
        return this.angularjsDirtyFlag;
    }

    public void resetANGULARJS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetANGULARJS();
            return;
        }
        this.angularjsDirtyFlag = false;
        this.angularjs = null;
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

    public void setEXTJS(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEXTJS(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extjs = string;
        this.extjsDirtyFlag = true;
    }

    public String getEXTJS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEXTJS();
        }
        return this.extjs;
    }

    public boolean isEXTJSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEXTJSDirty();
        }
        return this.extjsDirtyFlag;
    }

    public void resetEXTJS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEXTJS();
            return;
        }
        this.extjsDirtyFlag = false;
        this.extjs = null;
    }

    public void setFR7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFR7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fr7 = string;
        this.fr7DirtyFlag = true;
    }

    public String getFR7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFR7();
        }
        return this.fr7;
    }

    public boolean isFR7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFR7Dirty();
        }
        return this.fr7DirtyFlag;
    }

    public void resetFR7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFR7();
            return;
        }
        this.fr7DirtyFlag = false;
        this.fr7 = null;
    }

    public void setJ2EE6_IBIZSYSRT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJ2EE6_IBIZSYSRT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.j2ee6_ibizsysrt = string;
        this.j2ee6_ibizsysrtDirtyFlag = true;
    }

    public String getJ2EE6_IBIZSYSRT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJ2EE6_IBIZSYSRT();
        }
        return this.j2ee6_ibizsysrt;
    }

    public boolean isJ2EE6_IBIZSYSRTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJ2EE6_IBIZSYSRTDirty();
        }
        return this.j2ee6_ibizsysrtDirtyFlag;
    }

    public void resetJ2EE6_IBIZSYSRT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJ2EE6_IBIZSYSRT();
            return;
        }
        this.j2ee6_ibizsysrtDirtyFlag = false;
        this.j2ee6_ibizsysrt = null;
    }

    public void setJ2EE6_IBIZSYSRT_R2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJ2EE6_IBIZSYSRT_R2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.j2ee6_ibizsysrt_r2 = string;
        this.j2ee6_ibizsysrt_r2DirtyFlag = true;
    }

    public String getJ2EE6_IBIZSYSRT_R2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJ2EE6_IBIZSYSRT_R2();
        }
        return this.j2ee6_ibizsysrt_r2;
    }

    public boolean isJ2EE6_IBIZSYSRT_R2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJ2EE6_IBIZSYSRT_R2Dirty();
        }
        return this.j2ee6_ibizsysrt_r2DirtyFlag;
    }

    public void resetJ2EE6_IBIZSYSRT_R2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJ2EE6_IBIZSYSRT_R2();
            return;
        }
        this.j2ee6_ibizsysrt_r2DirtyFlag = false;
        this.j2ee6_ibizsysrt_r2 = null;
    }

    public void setJQuery(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJQuery(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jquery = string;
        this.jqueryDirtyFlag = true;
    }

    public String getJQuery() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJQuery();
        }
        return this.jquery;
    }

    public boolean isJQueryDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJQueryDirty();
        }
        return this.jqueryDirtyFlag;
    }

    public void resetJQuery() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJQuery();
            return;
        }
        this.jqueryDirtyFlag = false;
        this.jquery = null;
    }

    public void setJQuery_R2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJQuery_R2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jquery_r2 = string;
        this.jquery_r2DirtyFlag = true;
    }

    public String getJQuery_R2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJQuery_R2();
        }
        return this.jquery_r2;
    }

    public boolean isJQuery_R2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJQuery_R2Dirty();
        }
        return this.jquery_r2DirtyFlag;
    }

    public void resetJQuery_R2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJQuery_R2();
            return;
        }
        this.jquery_r2DirtyFlag = false;
        this.jquery_r2 = null;
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

    public void setPSSysModelFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfuncid = string;
        this.pssysmodelfuncidDirtyFlag = true;
    }

    public String getPSSysModelFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFuncId();
        }
        return this.pssysmodelfuncid;
    }

    public boolean isPSSysModelFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFuncIdDirty();
        }
        return this.pssysmodelfuncidDirtyFlag;
    }

    public void resetPSSysModelFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFuncId();
            return;
        }
        this.pssysmodelfuncidDirtyFlag = false;
        this.pssysmodelfuncid = null;
    }

    public void setPSSysModelFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfuncname = string;
        this.pssysmodelfuncnameDirtyFlag = true;
    }

    public String getPSSysModelFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFuncName();
        }
        return this.pssysmodelfuncname;
    }

    public boolean isPSSysModelFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFuncNameDirty();
        }
        return this.pssysmodelfuncnameDirtyFlag;
    }

    public void resetPSSysModelFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFuncName();
            return;
        }
        this.pssysmodelfuncnameDirtyFlag = false;
        this.pssysmodelfuncname = null;
    }

    public void setPSSysModelFuncTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFuncTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfunctemplid = string;
        this.pssysmodelfunctemplidDirtyFlag = true;
    }

    public String getPSSysModelFuncTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFuncTemplId();
        }
        return this.pssysmodelfunctemplid;
    }

    public boolean isPSSysModelFuncTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFuncTemplIdDirty();
        }
        return this.pssysmodelfunctemplidDirtyFlag;
    }

    public void resetPSSysModelFuncTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFuncTemplId();
            return;
        }
        this.pssysmodelfunctemplidDirtyFlag = false;
        this.pssysmodelfunctemplid = null;
    }

    public void setPSSysModelFuncTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFuncTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfunctemplname = string;
        this.pssysmodelfunctemplnameDirtyFlag = true;
    }

    public String getPSSysModelFuncTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFuncTemplName();
        }
        return this.pssysmodelfunctemplname;
    }

    public boolean isPSSysModelFuncTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFuncTemplNameDirty();
        }
        return this.pssysmodelfunctemplnameDirtyFlag;
    }

    public void resetPSSysModelFuncTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFuncTemplName();
            return;
        }
        this.pssysmodelfunctemplnameDirtyFlag = false;
        this.pssysmodelfunctemplname = null;
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
        PSSysModelFuncTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelFuncTemplBase pSSysModelFuncTemplBase) {
        pSSysModelFuncTemplBase.resetANGULARJS();
        pSSysModelFuncTemplBase.resetCreateDate();
        pSSysModelFuncTemplBase.resetCreateMan();
        pSSysModelFuncTemplBase.resetEXTJS();
        pSSysModelFuncTemplBase.resetFR7();
        pSSysModelFuncTemplBase.resetJ2EE6_IBIZSYSRT();
        pSSysModelFuncTemplBase.resetJ2EE6_IBIZSYSRT_R2();
        pSSysModelFuncTemplBase.resetJQuery();
        pSSysModelFuncTemplBase.resetJQuery_R2();
        pSSysModelFuncTemplBase.resetMemo();
        pSSysModelFuncTemplBase.resetPSSysModelFuncId();
        pSSysModelFuncTemplBase.resetPSSysModelFuncName();
        pSSysModelFuncTemplBase.resetPSSysModelFuncTemplId();
        pSSysModelFuncTemplBase.resetPSSysModelFuncTemplName();
        pSSysModelFuncTemplBase.resetUpdateDate();
        pSSysModelFuncTemplBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isANGULARJSDirty()) {
            hashMap.put(FIELD_ANGULARJS, this.getANGULARJS());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEXTJSDirty()) {
            hashMap.put(FIELD_EXTJS, this.getEXTJS());
        }
        if (!bl || this.isFR7Dirty()) {
            hashMap.put(FIELD_FR7, this.getFR7());
        }
        if (!bl || this.isJ2EE6_IBIZSYSRTDirty()) {
            hashMap.put(FIELD_J2EE6_IBIZSYSRT, this.getJ2EE6_IBIZSYSRT());
        }
        if (!bl || this.isJ2EE6_IBIZSYSRT_R2Dirty()) {
            hashMap.put(FIELD_J2EE6_IBIZSYSRT_R2, this.getJ2EE6_IBIZSYSRT_R2());
        }
        if (!bl || this.isJQueryDirty()) {
            hashMap.put(FIELD_JQUERY, this.getJQuery());
        }
        if (!bl || this.isJQuery_R2Dirty()) {
            hashMap.put(FIELD_JQUERY_R2, this.getJQuery_R2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysModelFuncIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELFUNCID, this.getPSSysModelFuncId());
        }
        if (!bl || this.isPSSysModelFuncNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELFUNCNAME, this.getPSSysModelFuncName());
        }
        if (!bl || this.isPSSysModelFuncTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELFUNCTEMPLID, this.getPSSysModelFuncTemplId());
        }
        if (!bl || this.isPSSysModelFuncTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELFUNCTEMPLNAME, this.getPSSysModelFuncTemplName());
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
        return PSSysModelFuncTemplBase.get(this, n);
    }

    private static Object get(PSSysModelFuncTemplBase pSSysModelFuncTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncTemplBase.getANGULARJS();
            }
            case 1: {
                return pSSysModelFuncTemplBase.getCreateDate();
            }
            case 2: {
                return pSSysModelFuncTemplBase.getCreateMan();
            }
            case 3: {
                return pSSysModelFuncTemplBase.getEXTJS();
            }
            case 4: {
                return pSSysModelFuncTemplBase.getFR7();
            }
            case 5: {
                return pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT();
            }
            case 6: {
                return pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT_R2();
            }
            case 7: {
                return pSSysModelFuncTemplBase.getJQuery();
            }
            case 8: {
                return pSSysModelFuncTemplBase.getJQuery_R2();
            }
            case 9: {
                return pSSysModelFuncTemplBase.getMemo();
            }
            case 10: {
                return pSSysModelFuncTemplBase.getPSSysModelFuncId();
            }
            case 11: {
                return pSSysModelFuncTemplBase.getPSSysModelFuncName();
            }
            case 12: {
                return pSSysModelFuncTemplBase.getPSSysModelFuncTemplId();
            }
            case 13: {
                return pSSysModelFuncTemplBase.getPSSysModelFuncTemplName();
            }
            case 14: {
                return pSSysModelFuncTemplBase.getUpdateDate();
            }
            case 15: {
                return pSSysModelFuncTemplBase.getUpdateMan();
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
        PSSysModelFuncTemplBase.set(this, n, object);
    }

    private static void set(PSSysModelFuncTemplBase pSSysModelFuncTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFuncTemplBase.setANGULARJS(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelFuncTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelFuncTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelFuncTemplBase.setEXTJS(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelFuncTemplBase.setFR7(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelFuncTemplBase.setJ2EE6_IBIZSYSRT(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelFuncTemplBase.setJ2EE6_IBIZSYSRT_R2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelFuncTemplBase.setJQuery(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelFuncTemplBase.setJQuery_R2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelFuncTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelFuncTemplBase.setPSSysModelFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelFuncTemplBase.setPSSysModelFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelFuncTemplBase.setPSSysModelFuncTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelFuncTemplBase.setPSSysModelFuncTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelFuncTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelFuncTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysModelFuncTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelFuncTemplBase pSSysModelFuncTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncTemplBase.getANGULARJS() == null;
            }
            case 1: {
                return pSSysModelFuncTemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysModelFuncTemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysModelFuncTemplBase.getEXTJS() == null;
            }
            case 4: {
                return pSSysModelFuncTemplBase.getFR7() == null;
            }
            case 5: {
                return pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT() == null;
            }
            case 6: {
                return pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT_R2() == null;
            }
            case 7: {
                return pSSysModelFuncTemplBase.getJQuery() == null;
            }
            case 8: {
                return pSSysModelFuncTemplBase.getJQuery_R2() == null;
            }
            case 9: {
                return pSSysModelFuncTemplBase.getMemo() == null;
            }
            case 10: {
                return pSSysModelFuncTemplBase.getPSSysModelFuncId() == null;
            }
            case 11: {
                return pSSysModelFuncTemplBase.getPSSysModelFuncName() == null;
            }
            case 12: {
                return pSSysModelFuncTemplBase.getPSSysModelFuncTemplId() == null;
            }
            case 13: {
                return pSSysModelFuncTemplBase.getPSSysModelFuncTemplName() == null;
            }
            case 14: {
                return pSSysModelFuncTemplBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSysModelFuncTemplBase.getUpdateMan() == null;
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
        return PSSysModelFuncTemplBase.contains(this, n);
    }

    private static boolean contains(PSSysModelFuncTemplBase pSSysModelFuncTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncTemplBase.isANGULARJSDirty();
            }
            case 1: {
                return pSSysModelFuncTemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysModelFuncTemplBase.isCreateManDirty();
            }
            case 3: {
                return pSSysModelFuncTemplBase.isEXTJSDirty();
            }
            case 4: {
                return pSSysModelFuncTemplBase.isFR7Dirty();
            }
            case 5: {
                return pSSysModelFuncTemplBase.isJ2EE6_IBIZSYSRTDirty();
            }
            case 6: {
                return pSSysModelFuncTemplBase.isJ2EE6_IBIZSYSRT_R2Dirty();
            }
            case 7: {
                return pSSysModelFuncTemplBase.isJQueryDirty();
            }
            case 8: {
                return pSSysModelFuncTemplBase.isJQuery_R2Dirty();
            }
            case 9: {
                return pSSysModelFuncTemplBase.isMemoDirty();
            }
            case 10: {
                return pSSysModelFuncTemplBase.isPSSysModelFuncIdDirty();
            }
            case 11: {
                return pSSysModelFuncTemplBase.isPSSysModelFuncNameDirty();
            }
            case 12: {
                return pSSysModelFuncTemplBase.isPSSysModelFuncTemplIdDirty();
            }
            case 13: {
                return pSSysModelFuncTemplBase.isPSSysModelFuncTemplNameDirty();
            }
            case 14: {
                return pSSysModelFuncTemplBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSysModelFuncTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelFuncTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelFuncTemplBase pSSysModelFuncTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelFuncTemplBase.getANGULARJS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"angularjs", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getANGULARJS()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getEXTJS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extjs", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getEXTJS()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getFR7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fr7", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getFR7()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"j2ee6_ibizsysrt", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT_R2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"j2ee6_ibizsysrt_r2", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT_R2()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getJQuery() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jquery", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getJQuery()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getJQuery_R2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jquery_r2", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getJQuery_R2()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getPSSysModelFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfuncid", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getPSSysModelFuncId()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getPSSysModelFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfuncname", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getPSSysModelFuncName()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getPSSysModelFuncTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfunctemplid", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getPSSysModelFuncTemplId()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getPSSysModelFuncTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfunctemplname", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getPSSysModelFuncTemplName()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelFuncTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelFuncTemplBase.getJSONValue((Object)pSSysModelFuncTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelFuncTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelFuncTemplBase pSSysModelFuncTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelFuncTemplBase.getANGULARJS() != null) {
            object = pSSysModelFuncTemplBase.getANGULARJS();
            xmlNode.setAttribute(FIELD_ANGULARJS, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getCreateDate() != null) {
            object = pSSysModelFuncTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFuncTemplBase.getCreateMan() != null) {
            object = pSSysModelFuncTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getEXTJS() != null) {
            object = pSSysModelFuncTemplBase.getEXTJS();
            xmlNode.setAttribute(FIELD_EXTJS, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getFR7() != null) {
            object = pSSysModelFuncTemplBase.getFR7();
            xmlNode.setAttribute(FIELD_FR7, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT() != null) {
            object = pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT();
            xmlNode.setAttribute(FIELD_J2EE6_IBIZSYSRT, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT_R2() != null) {
            object = pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT_R2();
            xmlNode.setAttribute(FIELD_J2EE6_IBIZSYSRT_R2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getJQuery() != null) {
            object = pSSysModelFuncTemplBase.getJQuery();
            xmlNode.setAttribute(FIELD_JQUERY, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getJQuery_R2() != null) {
            object = pSSysModelFuncTemplBase.getJQuery_R2();
            xmlNode.setAttribute(FIELD_JQUERY_R2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getMemo() != null) {
            object = pSSysModelFuncTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getPSSysModelFuncId() != null) {
            object = pSSysModelFuncTemplBase.getPSSysModelFuncId();
            xmlNode.setAttribute(FIELD_PSSYSMODELFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getPSSysModelFuncName() != null) {
            object = pSSysModelFuncTemplBase.getPSSysModelFuncName();
            xmlNode.setAttribute(FIELD_PSSYSMODELFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getPSSysModelFuncTemplId() != null) {
            object = pSSysModelFuncTemplBase.getPSSysModelFuncTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMODELFUNCTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getPSSysModelFuncTemplName() != null) {
            object = pSSysModelFuncTemplBase.getPSSysModelFuncTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMODELFUNCTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncTemplBase.getUpdateDate() != null) {
            object = pSSysModelFuncTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFuncTemplBase.getUpdateMan() != null) {
            object = pSSysModelFuncTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelFuncTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelFuncTemplBase pSSysModelFuncTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelFuncTemplBase.isANGULARJSDirty() && (bl || pSSysModelFuncTemplBase.getANGULARJS() != null)) {
            iDataObject.set(FIELD_ANGULARJS, (Object)pSSysModelFuncTemplBase.getANGULARJS());
        }
        if (pSSysModelFuncTemplBase.isCreateDateDirty() && (bl || pSSysModelFuncTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelFuncTemplBase.getCreateDate());
        }
        if (pSSysModelFuncTemplBase.isCreateManDirty() && (bl || pSSysModelFuncTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelFuncTemplBase.getCreateMan());
        }
        if (pSSysModelFuncTemplBase.isEXTJSDirty() && (bl || pSSysModelFuncTemplBase.getEXTJS() != null)) {
            iDataObject.set(FIELD_EXTJS, (Object)pSSysModelFuncTemplBase.getEXTJS());
        }
        if (pSSysModelFuncTemplBase.isFR7Dirty() && (bl || pSSysModelFuncTemplBase.getFR7() != null)) {
            iDataObject.set(FIELD_FR7, (Object)pSSysModelFuncTemplBase.getFR7());
        }
        if (pSSysModelFuncTemplBase.isJ2EE6_IBIZSYSRTDirty() && (bl || pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT() != null)) {
            iDataObject.set(FIELD_J2EE6_IBIZSYSRT, (Object)pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT());
        }
        if (pSSysModelFuncTemplBase.isJ2EE6_IBIZSYSRT_R2Dirty() && (bl || pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT_R2() != null)) {
            iDataObject.set(FIELD_J2EE6_IBIZSYSRT_R2, (Object)pSSysModelFuncTemplBase.getJ2EE6_IBIZSYSRT_R2());
        }
        if (pSSysModelFuncTemplBase.isJQueryDirty() && (bl || pSSysModelFuncTemplBase.getJQuery() != null)) {
            iDataObject.set(FIELD_JQUERY, (Object)pSSysModelFuncTemplBase.getJQuery());
        }
        if (pSSysModelFuncTemplBase.isJQuery_R2Dirty() && (bl || pSSysModelFuncTemplBase.getJQuery_R2() != null)) {
            iDataObject.set(FIELD_JQUERY_R2, (Object)pSSysModelFuncTemplBase.getJQuery_R2());
        }
        if (pSSysModelFuncTemplBase.isMemoDirty() && (bl || pSSysModelFuncTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelFuncTemplBase.getMemo());
        }
        if (pSSysModelFuncTemplBase.isPSSysModelFuncIdDirty() && (bl || pSSysModelFuncTemplBase.getPSSysModelFuncId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFUNCID, (Object)pSSysModelFuncTemplBase.getPSSysModelFuncId());
        }
        if (pSSysModelFuncTemplBase.isPSSysModelFuncNameDirty() && (bl || pSSysModelFuncTemplBase.getPSSysModelFuncName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFUNCNAME, (Object)pSSysModelFuncTemplBase.getPSSysModelFuncName());
        }
        if (pSSysModelFuncTemplBase.isPSSysModelFuncTemplIdDirty() && (bl || pSSysModelFuncTemplBase.getPSSysModelFuncTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFUNCTEMPLID, (Object)pSSysModelFuncTemplBase.getPSSysModelFuncTemplId());
        }
        if (pSSysModelFuncTemplBase.isPSSysModelFuncTemplNameDirty() && (bl || pSSysModelFuncTemplBase.getPSSysModelFuncTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFUNCTEMPLNAME, (Object)pSSysModelFuncTemplBase.getPSSysModelFuncTemplName());
        }
        if (pSSysModelFuncTemplBase.isUpdateDateDirty() && (bl || pSSysModelFuncTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelFuncTemplBase.getUpdateDate());
        }
        if (pSSysModelFuncTemplBase.isUpdateManDirty() && (bl || pSSysModelFuncTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelFuncTemplBase.getUpdateMan());
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
        return PSSysModelFuncTemplBase.remove(this, n);
    }

    private static boolean remove(PSSysModelFuncTemplBase pSSysModelFuncTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFuncTemplBase.resetANGULARJS();
                return true;
            }
            case 1: {
                pSSysModelFuncTemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysModelFuncTemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysModelFuncTemplBase.resetEXTJS();
                return true;
            }
            case 4: {
                pSSysModelFuncTemplBase.resetFR7();
                return true;
            }
            case 5: {
                pSSysModelFuncTemplBase.resetJ2EE6_IBIZSYSRT();
                return true;
            }
            case 6: {
                pSSysModelFuncTemplBase.resetJ2EE6_IBIZSYSRT_R2();
                return true;
            }
            case 7: {
                pSSysModelFuncTemplBase.resetJQuery();
                return true;
            }
            case 8: {
                pSSysModelFuncTemplBase.resetJQuery_R2();
                return true;
            }
            case 9: {
                pSSysModelFuncTemplBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysModelFuncTemplBase.resetPSSysModelFuncId();
                return true;
            }
            case 11: {
                pSSysModelFuncTemplBase.resetPSSysModelFuncName();
                return true;
            }
            case 12: {
                pSSysModelFuncTemplBase.resetPSSysModelFuncTemplId();
                return true;
            }
            case 13: {
                pSSysModelFuncTemplBase.resetPSSysModelFuncTemplName();
                return true;
            }
            case 14: {
                pSSysModelFuncTemplBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSysModelFuncTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelFunc getPSSysModelFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFunc();
        }
        if (this.getPSSysModelFuncId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelFuncLock;
        synchronized (n) {
            if (this.pssysmodelfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelFuncId(), (Object)this.pssysmodelfunc.getPSSysModelFuncId()) != 0L) {
                this.pssysmodelfunc = null;
            }
            if (this.pssysmodelfunc == null) {
                PSSysModelFunc pSSysModelFunc = new PSSysModelFunc();
                pSSysModelFunc.setPSSysModelFuncId(this.getPSSysModelFuncId());
                PSSysModelFuncService pSSysModelFuncService = (PSSysModelFuncService)ServiceGlobal.getService(PSSysModelFuncService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelFuncService.autoGet((IEntity)pSSysModelFunc);
                this.pssysmodelfunc = pSSysModelFunc;
            }
            return this.pssysmodelfunc;
        }
    }

    private PSSysModelFuncTemplBase getProxyEntity() {
        return this.proxyPSSysModelFuncTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelFuncTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelFuncTemplBase) {
            this.proxyPSSysModelFuncTemplBase = (PSSysModelFuncTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysModelFuncTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ANGULARJS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EXTJS, 3);
        fieldIndexMap.put(FIELD_FR7, 4);
        fieldIndexMap.put(FIELD_J2EE6_IBIZSYSRT, 5);
        fieldIndexMap.put(FIELD_J2EE6_IBIZSYSRT_R2, 6);
        fieldIndexMap.put(FIELD_JQUERY, 7);
        fieldIndexMap.put(FIELD_JQUERY_R2, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSSYSMODELFUNCID, 10);
        fieldIndexMap.put(FIELD_PSSYSMODELFUNCNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSMODELFUNCTEMPLID, 12);
        fieldIndexMap.put(FIELD_PSSYSMODELFUNCTEMPLNAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

