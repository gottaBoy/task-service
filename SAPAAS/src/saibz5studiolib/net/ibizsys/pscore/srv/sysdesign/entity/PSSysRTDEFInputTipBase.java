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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRTDEFInputTipBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysRTDEFInputTipBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLECLOSE = "ENABLECLOSE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOREURL = "MOREURL";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSRTDEFINPUTTIPID = "PSSYSRTDEFINPUTTIPID";
    public static final String FIELD_PSSYSRTDEFINPUTTIPNAME = "PSSYSRTDEFINPUTTIPNAME";
    public static final String FIELD_UNIQUETAG = "UNIQUETAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLECLOSE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MOREURL = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDENAME = 8;
    private static final int INDEX_PSSYSRTDEFINPUTTIPID = 9;
    private static final int INDEX_PSSYSRTDEFINPUTTIPNAME = 10;
    private static final int INDEX_UNIQUETAG = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysRTDEFInputTipBase proxyPSSysRTDEFInputTipBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablecloseDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean moreurlDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysrtdefinputtipidDirtyFlag = false;
    private boolean pssysrtdefinputtipnameDirtyFlag = false;
    private boolean uniquetagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enableclose")
    private Integer enableclose;
    @Column(name="memo")
    private String memo;
    @Column(name="moreurl")
    private String moreurl;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysrtdefinputtipid")
    private String pssysrtdefinputtipid;
    @Column(name="pssysrtdefinputtipname")
    private String pssysrtdefinputtipname;
    @Column(name="uniquetag")
    private String uniquetag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setEnableClose(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableClose(n);
            return;
        }
        this.enableclose = n;
        this.enablecloseDirtyFlag = true;
    }

    public Integer getEnableClose() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableClose();
        }
        return this.enableclose;
    }

    public boolean isEnableCloseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCloseDirty();
        }
        return this.enablecloseDirtyFlag;
    }

    public void resetEnableClose() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableClose();
            return;
        }
        this.enablecloseDirtyFlag = false;
        this.enableclose = null;
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

    public void setMoreUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMoreUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moreurl = string;
        this.moreurlDirtyFlag = true;
    }

    public String getMoreUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMoreUrl();
        }
        return this.moreurl;
    }

    public boolean isMoreUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMoreUrlDirty();
        }
        return this.moreurlDirtyFlag;
    }

    public void resetMoreUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMoreUrl();
            return;
        }
        this.moreurlDirtyFlag = false;
        this.moreurl = null;
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

    public void setPSSysRTDEFInputTipId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRTDEFInputTipId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrtdefinputtipid = string;
        this.pssysrtdefinputtipidDirtyFlag = true;
    }

    public String getPSSysRTDEFInputTipId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRTDEFInputTipId();
        }
        return this.pssysrtdefinputtipid;
    }

    public boolean isPSSysRTDEFInputTipIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRTDEFInputTipIdDirty();
        }
        return this.pssysrtdefinputtipidDirtyFlag;
    }

    public void resetPSSysRTDEFInputTipId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRTDEFInputTipId();
            return;
        }
        this.pssysrtdefinputtipidDirtyFlag = false;
        this.pssysrtdefinputtipid = null;
    }

    public void setPSSysRTDEFInputTipName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRTDEFInputTipName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrtdefinputtipname = string;
        this.pssysrtdefinputtipnameDirtyFlag = true;
    }

    public String getPSSysRTDEFInputTipName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRTDEFInputTipName();
        }
        return this.pssysrtdefinputtipname;
    }

    public boolean isPSSysRTDEFInputTipNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRTDEFInputTipNameDirty();
        }
        return this.pssysrtdefinputtipnameDirtyFlag;
    }

    public void resetPSSysRTDEFInputTipName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRTDEFInputTipName();
            return;
        }
        this.pssysrtdefinputtipnameDirtyFlag = false;
        this.pssysrtdefinputtipname = null;
    }

    public void setUniqueTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uniquetag = string;
        this.uniquetagDirtyFlag = true;
    }

    public String getUniqueTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTag();
        }
        return this.uniquetag;
    }

    public boolean isUniqueTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueTagDirty();
        }
        return this.uniquetagDirtyFlag;
    }

    public void resetUniqueTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueTag();
            return;
        }
        this.uniquetagDirtyFlag = false;
        this.uniquetag = null;
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
        PSSysRTDEFInputTipBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase) {
        pSSysRTDEFInputTipBase.resetContent();
        pSSysRTDEFInputTipBase.resetCreateDate();
        pSSysRTDEFInputTipBase.resetCreateMan();
        pSSysRTDEFInputTipBase.resetEnableClose();
        pSSysRTDEFInputTipBase.resetMemo();
        pSSysRTDEFInputTipBase.resetMoreUrl();
        pSSysRTDEFInputTipBase.resetOrderValue();
        pSSysRTDEFInputTipBase.resetPSDEId();
        pSSysRTDEFInputTipBase.resetPSDEName();
        pSSysRTDEFInputTipBase.resetPSSysRTDEFInputTipId();
        pSSysRTDEFInputTipBase.resetPSSysRTDEFInputTipName();
        pSSysRTDEFInputTipBase.resetUniqueTag();
        pSSysRTDEFInputTipBase.resetUpdateDate();
        pSSysRTDEFInputTipBase.resetUpdateMan();
        pSSysRTDEFInputTipBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableCloseDirty()) {
            hashMap.put(FIELD_ENABLECLOSE, this.getEnableClose());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMoreUrlDirty()) {
            hashMap.put(FIELD_MOREURL, this.getMoreUrl());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysRTDEFInputTipIdDirty()) {
            hashMap.put(FIELD_PSSYSRTDEFINPUTTIPID, this.getPSSysRTDEFInputTipId());
        }
        if (!bl || this.isPSSysRTDEFInputTipNameDirty()) {
            hashMap.put(FIELD_PSSYSRTDEFINPUTTIPNAME, this.getPSSysRTDEFInputTipName());
        }
        if (!bl || this.isUniqueTagDirty()) {
            hashMap.put(FIELD_UNIQUETAG, this.getUniqueTag());
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
        return PSSysRTDEFInputTipBase.get(this, n);
    }

    private static Object get(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRTDEFInputTipBase.getContent();
            }
            case 1: {
                return pSSysRTDEFInputTipBase.getCreateDate();
            }
            case 2: {
                return pSSysRTDEFInputTipBase.getCreateMan();
            }
            case 3: {
                return pSSysRTDEFInputTipBase.getEnableClose();
            }
            case 4: {
                return pSSysRTDEFInputTipBase.getMemo();
            }
            case 5: {
                return pSSysRTDEFInputTipBase.getMoreUrl();
            }
            case 6: {
                return pSSysRTDEFInputTipBase.getOrderValue();
            }
            case 7: {
                return pSSysRTDEFInputTipBase.getPSDEId();
            }
            case 8: {
                return pSSysRTDEFInputTipBase.getPSDEName();
            }
            case 9: {
                return pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipId();
            }
            case 10: {
                return pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipName();
            }
            case 11: {
                return pSSysRTDEFInputTipBase.getUniqueTag();
            }
            case 12: {
                return pSSysRTDEFInputTipBase.getUpdateDate();
            }
            case 13: {
                return pSSysRTDEFInputTipBase.getUpdateMan();
            }
            case 14: {
                return pSSysRTDEFInputTipBase.getValidFlag();
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
        PSSysRTDEFInputTipBase.set(this, n, object);
    }

    private static void set(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysRTDEFInputTipBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysRTDEFInputTipBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysRTDEFInputTipBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysRTDEFInputTipBase.setEnableClose(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysRTDEFInputTipBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysRTDEFInputTipBase.setMoreUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysRTDEFInputTipBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysRTDEFInputTipBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysRTDEFInputTipBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysRTDEFInputTipBase.setPSSysRTDEFInputTipId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysRTDEFInputTipBase.setPSSysRTDEFInputTipName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysRTDEFInputTipBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysRTDEFInputTipBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysRTDEFInputTipBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysRTDEFInputTipBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysRTDEFInputTipBase.isNull(this, n);
    }

    private static boolean isNull(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRTDEFInputTipBase.getContent() == null;
            }
            case 1: {
                return pSSysRTDEFInputTipBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysRTDEFInputTipBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysRTDEFInputTipBase.getEnableClose() == null;
            }
            case 4: {
                return pSSysRTDEFInputTipBase.getMemo() == null;
            }
            case 5: {
                return pSSysRTDEFInputTipBase.getMoreUrl() == null;
            }
            case 6: {
                return pSSysRTDEFInputTipBase.getOrderValue() == null;
            }
            case 7: {
                return pSSysRTDEFInputTipBase.getPSDEId() == null;
            }
            case 8: {
                return pSSysRTDEFInputTipBase.getPSDEName() == null;
            }
            case 9: {
                return pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipId() == null;
            }
            case 10: {
                return pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipName() == null;
            }
            case 11: {
                return pSSysRTDEFInputTipBase.getUniqueTag() == null;
            }
            case 12: {
                return pSSysRTDEFInputTipBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysRTDEFInputTipBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSysRTDEFInputTipBase.getValidFlag() == null;
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
        return PSSysRTDEFInputTipBase.contains(this, n);
    }

    private static boolean contains(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRTDEFInputTipBase.isContentDirty();
            }
            case 1: {
                return pSSysRTDEFInputTipBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysRTDEFInputTipBase.isCreateManDirty();
            }
            case 3: {
                return pSSysRTDEFInputTipBase.isEnableCloseDirty();
            }
            case 4: {
                return pSSysRTDEFInputTipBase.isMemoDirty();
            }
            case 5: {
                return pSSysRTDEFInputTipBase.isMoreUrlDirty();
            }
            case 6: {
                return pSSysRTDEFInputTipBase.isOrderValueDirty();
            }
            case 7: {
                return pSSysRTDEFInputTipBase.isPSDEIdDirty();
            }
            case 8: {
                return pSSysRTDEFInputTipBase.isPSDENameDirty();
            }
            case 9: {
                return pSSysRTDEFInputTipBase.isPSSysRTDEFInputTipIdDirty();
            }
            case 10: {
                return pSSysRTDEFInputTipBase.isPSSysRTDEFInputTipNameDirty();
            }
            case 11: {
                return pSSysRTDEFInputTipBase.isUniqueTagDirty();
            }
            case 12: {
                return pSSysRTDEFInputTipBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysRTDEFInputTipBase.isUpdateManDirty();
            }
            case 14: {
                return pSSysRTDEFInputTipBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysRTDEFInputTipBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysRTDEFInputTipBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getContent()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getEnableClose() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableclose", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getEnableClose()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getMoreUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moreurl", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getMoreUrl()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrtdefinputtipid", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipId()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrtdefinputtipname", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipName()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysRTDEFInputTipBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysRTDEFInputTipBase.getJSONValue((Object)pSSysRTDEFInputTipBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysRTDEFInputTipBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysRTDEFInputTipBase.getContent() != null) {
            object = pSSysRTDEFInputTipBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getCreateDate() != null) {
            object = pSSysRTDEFInputTipBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRTDEFInputTipBase.getCreateMan() != null) {
            object = pSSysRTDEFInputTipBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getEnableClose() != null) {
            object = pSSysRTDEFInputTipBase.getEnableClose();
            xmlNode.setAttribute(FIELD_ENABLECLOSE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRTDEFInputTipBase.getMemo() != null) {
            object = pSSysRTDEFInputTipBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getMoreUrl() != null) {
            object = pSSysRTDEFInputTipBase.getMoreUrl();
            xmlNode.setAttribute(FIELD_MOREURL, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getOrderValue() != null) {
            object = pSSysRTDEFInputTipBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRTDEFInputTipBase.getPSDEId() != null) {
            object = pSSysRTDEFInputTipBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getPSDEName() != null) {
            object = pSSysRTDEFInputTipBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipId() != null) {
            object = pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipId();
            xmlNode.setAttribute(FIELD_PSSYSRTDEFINPUTTIPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipName() != null) {
            object = pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipName();
            xmlNode.setAttribute(FIELD_PSSYSRTDEFINPUTTIPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getUniqueTag() != null) {
            object = pSSysRTDEFInputTipBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getUpdateDate() != null) {
            object = pSSysRTDEFInputTipBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRTDEFInputTipBase.getUpdateMan() != null) {
            object = pSSysRTDEFInputTipBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTDEFInputTipBase.getValidFlag() != null) {
            object = pSSysRTDEFInputTipBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysRTDEFInputTipBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysRTDEFInputTipBase.isContentDirty() && (bl || pSSysRTDEFInputTipBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysRTDEFInputTipBase.getContent());
        }
        if (pSSysRTDEFInputTipBase.isCreateDateDirty() && (bl || pSSysRTDEFInputTipBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysRTDEFInputTipBase.getCreateDate());
        }
        if (pSSysRTDEFInputTipBase.isCreateManDirty() && (bl || pSSysRTDEFInputTipBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysRTDEFInputTipBase.getCreateMan());
        }
        if (pSSysRTDEFInputTipBase.isEnableCloseDirty() && (bl || pSSysRTDEFInputTipBase.getEnableClose() != null)) {
            iDataObject.set(FIELD_ENABLECLOSE, (Object)pSSysRTDEFInputTipBase.getEnableClose());
        }
        if (pSSysRTDEFInputTipBase.isMemoDirty() && (bl || pSSysRTDEFInputTipBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysRTDEFInputTipBase.getMemo());
        }
        if (pSSysRTDEFInputTipBase.isMoreUrlDirty() && (bl || pSSysRTDEFInputTipBase.getMoreUrl() != null)) {
            iDataObject.set(FIELD_MOREURL, (Object)pSSysRTDEFInputTipBase.getMoreUrl());
        }
        if (pSSysRTDEFInputTipBase.isOrderValueDirty() && (bl || pSSysRTDEFInputTipBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysRTDEFInputTipBase.getOrderValue());
        }
        if (pSSysRTDEFInputTipBase.isPSDEIdDirty() && (bl || pSSysRTDEFInputTipBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysRTDEFInputTipBase.getPSDEId());
        }
        if (pSSysRTDEFInputTipBase.isPSDENameDirty() && (bl || pSSysRTDEFInputTipBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysRTDEFInputTipBase.getPSDEName());
        }
        if (pSSysRTDEFInputTipBase.isPSSysRTDEFInputTipIdDirty() && (bl || pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipId() != null)) {
            iDataObject.set(FIELD_PSSYSRTDEFINPUTTIPID, (Object)pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipId());
        }
        if (pSSysRTDEFInputTipBase.isPSSysRTDEFInputTipNameDirty() && (bl || pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipName() != null)) {
            iDataObject.set(FIELD_PSSYSRTDEFINPUTTIPNAME, (Object)pSSysRTDEFInputTipBase.getPSSysRTDEFInputTipName());
        }
        if (pSSysRTDEFInputTipBase.isUniqueTagDirty() && (bl || pSSysRTDEFInputTipBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSSysRTDEFInputTipBase.getUniqueTag());
        }
        if (pSSysRTDEFInputTipBase.isUpdateDateDirty() && (bl || pSSysRTDEFInputTipBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysRTDEFInputTipBase.getUpdateDate());
        }
        if (pSSysRTDEFInputTipBase.isUpdateManDirty() && (bl || pSSysRTDEFInputTipBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysRTDEFInputTipBase.getUpdateMan());
        }
        if (pSSysRTDEFInputTipBase.isValidFlagDirty() && (bl || pSSysRTDEFInputTipBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysRTDEFInputTipBase.getValidFlag());
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
        return PSSysRTDEFInputTipBase.remove(this, n);
    }

    private static boolean remove(PSSysRTDEFInputTipBase pSSysRTDEFInputTipBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysRTDEFInputTipBase.resetContent();
                return true;
            }
            case 1: {
                pSSysRTDEFInputTipBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysRTDEFInputTipBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysRTDEFInputTipBase.resetEnableClose();
                return true;
            }
            case 4: {
                pSSysRTDEFInputTipBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysRTDEFInputTipBase.resetMoreUrl();
                return true;
            }
            case 6: {
                pSSysRTDEFInputTipBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSSysRTDEFInputTipBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSSysRTDEFInputTipBase.resetPSDEName();
                return true;
            }
            case 9: {
                pSSysRTDEFInputTipBase.resetPSSysRTDEFInputTipId();
                return true;
            }
            case 10: {
                pSSysRTDEFInputTipBase.resetPSSysRTDEFInputTipName();
                return true;
            }
            case 11: {
                pSSysRTDEFInputTipBase.resetUniqueTag();
                return true;
            }
            case 12: {
                pSSysRTDEFInputTipBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysRTDEFInputTipBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSysRTDEFInputTipBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    private PSSysRTDEFInputTipBase getProxyEntity() {
        return this.proxyPSSysRTDEFInputTipBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysRTDEFInputTipBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysRTDEFInputTipBase) {
            this.proxyPSSysRTDEFInputTipBase = (PSSysRTDEFInputTipBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRTDEFInputTipService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLECLOSE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MOREURL, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSRTDEFINPUTTIPID, 9);
        fieldIndexMap.put(FIELD_PSSYSRTDEFINPUTTIPNAME, 10);
        fieldIndexMap.put(FIELD_UNIQUETAG, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

