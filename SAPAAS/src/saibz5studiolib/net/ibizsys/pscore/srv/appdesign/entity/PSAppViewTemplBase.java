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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewStyle;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewStyleService;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppViewTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPVIEWSTYLEID = "PSAPPVIEWSTYLEID";
    public static final String FIELD_PSAPPVIEWSTYLENAME = "PSAPPVIEWSTYLENAME";
    public static final String FIELD_PSAPPVIEWTEMPLID = "PSAPPVIEWTEMPLID";
    public static final String FIELD_PSAPPVIEWTEMPLNAME = "PSAPPVIEWTEMPLNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSAPPVIEWSTYLEID = 3;
    private static final int INDEX_PSAPPVIEWSTYLENAME = 4;
    private static final int INDEX_PSAPPVIEWTEMPLID = 5;
    private static final int INDEX_PSAPPVIEWTEMPLNAME = 6;
    private static final int INDEX_PSPFPUBCODEID = 7;
    private static final int INDEX_PSPFPUBCODENAME = 8;
    private static final int INDEX_TEMPLCODE = 9;
    private static final int INDEX_TEMPLCODE2 = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERPARAMS = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppViewTemplBase proxyPSAppViewTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappviewstyleidDirtyFlag = false;
    private boolean psappviewstylenameDirtyFlag = false;
    private boolean psappviewtemplidDirtyFlag = false;
    private boolean psappviewtemplnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappviewstyleid")
    private String psappviewstyleid;
    @Column(name="psappviewstylename")
    private String psappviewstylename;
    @Column(name="psappviewtemplid")
    private String psappviewtemplid;
    @Column(name="psappviewtemplname")
    private String psappviewtemplname;
    @Column(name="pspfpubcodeid")
    private String pspfpubcodeid;
    @Column(name="pspfpubcodename")
    private String pspfpubcodename;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    private Integer objPSAppViewStyleLock = new Integer(1);
    private PSAppViewStyle psappviewstyle = null;
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;

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

    public void setPSAppViewStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewstyleid = string;
        this.psappviewstyleidDirtyFlag = true;
    }

    public String getPSAppViewStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewStyleId();
        }
        return this.psappviewstyleid;
    }

    public boolean isPSAppViewStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewStyleIdDirty();
        }
        return this.psappviewstyleidDirtyFlag;
    }

    public void resetPSAppViewStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewStyleId();
            return;
        }
        this.psappviewstyleidDirtyFlag = false;
        this.psappviewstyleid = null;
    }

    public void setPSAppViewStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewstylename = string;
        this.psappviewstylenameDirtyFlag = true;
    }

    public String getPSAppViewStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewStyleName();
        }
        return this.psappviewstylename;
    }

    public boolean isPSAppViewStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewStyleNameDirty();
        }
        return this.psappviewstylenameDirtyFlag;
    }

    public void resetPSAppViewStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewStyleName();
            return;
        }
        this.psappviewstylenameDirtyFlag = false;
        this.psappviewstylename = null;
    }

    public void setPSAppViewTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewtemplid = string;
        this.psappviewtemplidDirtyFlag = true;
    }

    public String getPSAppViewTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewTemplId();
        }
        return this.psappviewtemplid;
    }

    public boolean isPSAppViewTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewTemplIdDirty();
        }
        return this.psappviewtemplidDirtyFlag;
    }

    public void resetPSAppViewTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewTemplId();
            return;
        }
        this.psappviewtemplidDirtyFlag = false;
        this.psappviewtemplid = null;
    }

    public void setPSAppViewTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewtemplname = string;
        this.psappviewtemplnameDirtyFlag = true;
    }

    public String getPSAppViewTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewTemplName();
        }
        return this.psappviewtemplname;
    }

    public boolean isPSAppViewTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewTemplNameDirty();
        }
        return this.psappviewtemplnameDirtyFlag;
    }

    public void resetPSAppViewTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewTemplName();
            return;
        }
        this.psappviewtemplnameDirtyFlag = false;
        this.psappviewtemplname = null;
    }

    public void setPSPFPubCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodeid = string;
        this.pspfpubcodeidDirtyFlag = true;
    }

    public String getPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeId();
        }
        return this.pspfpubcodeid;
    }

    public boolean isPSPFPubCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeIdDirty();
        }
        return this.pspfpubcodeidDirtyFlag;
    }

    public void resetPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeId();
            return;
        }
        this.pspfpubcodeidDirtyFlag = false;
        this.pspfpubcodeid = null;
    }

    public void setPSPFPubCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodename = string;
        this.pspfpubcodenameDirtyFlag = true;
    }

    public String getPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeName();
        }
        return this.pspfpubcodename;
    }

    public boolean isPSPFPubCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeNameDirty();
        }
        return this.pspfpubcodenameDirtyFlag;
    }

    public void resetPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeName();
            return;
        }
        this.pspfpubcodenameDirtyFlag = false;
        this.pspfpubcodename = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    protected void onReset() {
        PSAppViewTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppViewTemplBase pSAppViewTemplBase) {
        pSAppViewTemplBase.resetCreateDate();
        pSAppViewTemplBase.resetCreateMan();
        pSAppViewTemplBase.resetMemo();
        pSAppViewTemplBase.resetPSAppViewStyleId();
        pSAppViewTemplBase.resetPSAppViewStyleName();
        pSAppViewTemplBase.resetPSAppViewTemplId();
        pSAppViewTemplBase.resetPSAppViewTemplName();
        pSAppViewTemplBase.resetPSPFPubCodeId();
        pSAppViewTemplBase.resetPSPFPubCodeName();
        pSAppViewTemplBase.resetTemplCode();
        pSAppViewTemplBase.resetTemplCode2();
        pSAppViewTemplBase.resetUpdateDate();
        pSAppViewTemplBase.resetUpdateMan();
        pSAppViewTemplBase.resetUserParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppViewStyleIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWSTYLEID, this.getPSAppViewStyleId());
        }
        if (!bl || this.isPSAppViewStyleNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWSTYLENAME, this.getPSAppViewStyleName());
        }
        if (!bl || this.isPSAppViewTemplIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWTEMPLID, this.getPSAppViewTemplId());
        }
        if (!bl || this.isPSAppViewTemplNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWTEMPLNAME, this.getPSAppViewTemplName());
        }
        if (!bl || this.isPSPFPubCodeIdDirty()) {
            hashMap.put(FIELD_PSPFPUBCODEID, this.getPSPFPubCodeId());
        }
        if (!bl || this.isPSPFPubCodeNameDirty()) {
            hashMap.put(FIELD_PSPFPUBCODENAME, this.getPSPFPubCodeName());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSAppViewTemplBase.get(this, n);
    }

    private static Object get(PSAppViewTemplBase pSAppViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewTemplBase.getCreateDate();
            }
            case 1: {
                return pSAppViewTemplBase.getCreateMan();
            }
            case 2: {
                return pSAppViewTemplBase.getMemo();
            }
            case 3: {
                return pSAppViewTemplBase.getPSAppViewStyleId();
            }
            case 4: {
                return pSAppViewTemplBase.getPSAppViewStyleName();
            }
            case 5: {
                return pSAppViewTemplBase.getPSAppViewTemplId();
            }
            case 6: {
                return pSAppViewTemplBase.getPSAppViewTemplName();
            }
            case 7: {
                return pSAppViewTemplBase.getPSPFPubCodeId();
            }
            case 8: {
                return pSAppViewTemplBase.getPSPFPubCodeName();
            }
            case 9: {
                return pSAppViewTemplBase.getTemplCode();
            }
            case 10: {
                return pSAppViewTemplBase.getTemplCode2();
            }
            case 11: {
                return pSAppViewTemplBase.getUpdateDate();
            }
            case 12: {
                return pSAppViewTemplBase.getUpdateMan();
            }
            case 13: {
                return pSAppViewTemplBase.getUserParams();
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
        PSAppViewTemplBase.set(this, n, object);
    }

    private static void set(PSAppViewTemplBase pSAppViewTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppViewTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppViewTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppViewTemplBase.setPSAppViewStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppViewTemplBase.setPSAppViewStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppViewTemplBase.setPSAppViewTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppViewTemplBase.setPSAppViewTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppViewTemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppViewTemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppViewTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppViewTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppViewTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSAppViewTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppViewTemplBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSAppViewTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSAppViewTemplBase pSAppViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppViewTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppViewTemplBase.getMemo() == null;
            }
            case 3: {
                return pSAppViewTemplBase.getPSAppViewStyleId() == null;
            }
            case 4: {
                return pSAppViewTemplBase.getPSAppViewStyleName() == null;
            }
            case 5: {
                return pSAppViewTemplBase.getPSAppViewTemplId() == null;
            }
            case 6: {
                return pSAppViewTemplBase.getPSAppViewTemplName() == null;
            }
            case 7: {
                return pSAppViewTemplBase.getPSPFPubCodeId() == null;
            }
            case 8: {
                return pSAppViewTemplBase.getPSPFPubCodeName() == null;
            }
            case 9: {
                return pSAppViewTemplBase.getTemplCode() == null;
            }
            case 10: {
                return pSAppViewTemplBase.getTemplCode2() == null;
            }
            case 11: {
                return pSAppViewTemplBase.getUpdateDate() == null;
            }
            case 12: {
                return pSAppViewTemplBase.getUpdateMan() == null;
            }
            case 13: {
                return pSAppViewTemplBase.getUserParams() == null;
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
        return PSAppViewTemplBase.contains(this, n);
    }

    private static boolean contains(PSAppViewTemplBase pSAppViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppViewTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSAppViewTemplBase.isMemoDirty();
            }
            case 3: {
                return pSAppViewTemplBase.isPSAppViewStyleIdDirty();
            }
            case 4: {
                return pSAppViewTemplBase.isPSAppViewStyleNameDirty();
            }
            case 5: {
                return pSAppViewTemplBase.isPSAppViewTemplIdDirty();
            }
            case 6: {
                return pSAppViewTemplBase.isPSAppViewTemplNameDirty();
            }
            case 7: {
                return pSAppViewTemplBase.isPSPFPubCodeIdDirty();
            }
            case 8: {
                return pSAppViewTemplBase.isPSPFPubCodeNameDirty();
            }
            case 9: {
                return pSAppViewTemplBase.isTemplCodeDirty();
            }
            case 10: {
                return pSAppViewTemplBase.isTemplCode2Dirty();
            }
            case 11: {
                return pSAppViewTemplBase.isUpdateDateDirty();
            }
            case 12: {
                return pSAppViewTemplBase.isUpdateManDirty();
            }
            case 13: {
                return pSAppViewTemplBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppViewTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppViewTemplBase pSAppViewTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppViewTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getPSAppViewStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewstyleid", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getPSAppViewStyleId()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getPSAppViewStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewstylename", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getPSAppViewStyleName()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getPSAppViewTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewtemplid", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getPSAppViewTemplId()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getPSAppViewTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewtemplname", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getPSAppViewTemplName()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppViewTemplBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppViewTemplBase.getJSONValue((Object)pSAppViewTemplBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppViewTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppViewTemplBase pSAppViewTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppViewTemplBase.getCreateDate() != null) {
            object = pSAppViewTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewTemplBase.getCreateMan() != null) {
            object = pSAppViewTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getMemo() != null) {
            object = pSAppViewTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getPSAppViewStyleId() != null) {
            object = pSAppViewTemplBase.getPSAppViewStyleId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getPSAppViewStyleName() != null) {
            object = pSAppViewTemplBase.getPSAppViewStyleName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getPSAppViewTemplId() != null) {
            object = pSAppViewTemplBase.getPSAppViewTemplId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getPSAppViewTemplName() != null) {
            object = pSAppViewTemplBase.getPSAppViewTemplName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getPSPFPubCodeId() != null) {
            object = pSAppViewTemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getPSPFPubCodeName() != null) {
            object = pSAppViewTemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getTemplCode() != null) {
            object = pSAppViewTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getTemplCode2() != null) {
            object = pSAppViewTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getUpdateDate() != null) {
            object = pSAppViewTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewTemplBase.getUpdateMan() != null) {
            object = pSAppViewTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewTemplBase.getUserParams() != null) {
            object = pSAppViewTemplBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppViewTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppViewTemplBase pSAppViewTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppViewTemplBase.isCreateDateDirty() && (bl || pSAppViewTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppViewTemplBase.getCreateDate());
        }
        if (pSAppViewTemplBase.isCreateManDirty() && (bl || pSAppViewTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppViewTemplBase.getCreateMan());
        }
        if (pSAppViewTemplBase.isMemoDirty() && (bl || pSAppViewTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppViewTemplBase.getMemo());
        }
        if (pSAppViewTemplBase.isPSAppViewStyleIdDirty() && (bl || pSAppViewTemplBase.getPSAppViewStyleId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWSTYLEID, (Object)pSAppViewTemplBase.getPSAppViewStyleId());
        }
        if (pSAppViewTemplBase.isPSAppViewStyleNameDirty() && (bl || pSAppViewTemplBase.getPSAppViewStyleName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWSTYLENAME, (Object)pSAppViewTemplBase.getPSAppViewStyleName());
        }
        if (pSAppViewTemplBase.isPSAppViewTemplIdDirty() && (bl || pSAppViewTemplBase.getPSAppViewTemplId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWTEMPLID, (Object)pSAppViewTemplBase.getPSAppViewTemplId());
        }
        if (pSAppViewTemplBase.isPSAppViewTemplNameDirty() && (bl || pSAppViewTemplBase.getPSAppViewTemplName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWTEMPLNAME, (Object)pSAppViewTemplBase.getPSAppViewTemplName());
        }
        if (pSAppViewTemplBase.isPSPFPubCodeIdDirty() && (bl || pSAppViewTemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSAppViewTemplBase.getPSPFPubCodeId());
        }
        if (pSAppViewTemplBase.isPSPFPubCodeNameDirty() && (bl || pSAppViewTemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSAppViewTemplBase.getPSPFPubCodeName());
        }
        if (pSAppViewTemplBase.isTemplCodeDirty() && (bl || pSAppViewTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSAppViewTemplBase.getTemplCode());
        }
        if (pSAppViewTemplBase.isTemplCode2Dirty() && (bl || pSAppViewTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSAppViewTemplBase.getTemplCode2());
        }
        if (pSAppViewTemplBase.isUpdateDateDirty() && (bl || pSAppViewTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppViewTemplBase.getUpdateDate());
        }
        if (pSAppViewTemplBase.isUpdateManDirty() && (bl || pSAppViewTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppViewTemplBase.getUpdateMan());
        }
        if (pSAppViewTemplBase.isUserParamsDirty() && (bl || pSAppViewTemplBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppViewTemplBase.getUserParams());
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
        return PSAppViewTemplBase.remove(this, n);
    }

    private static boolean remove(PSAppViewTemplBase pSAppViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppViewTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppViewTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppViewTemplBase.resetPSAppViewStyleId();
                return true;
            }
            case 4: {
                pSAppViewTemplBase.resetPSAppViewStyleName();
                return true;
            }
            case 5: {
                pSAppViewTemplBase.resetPSAppViewTemplId();
                return true;
            }
            case 6: {
                pSAppViewTemplBase.resetPSAppViewTemplName();
                return true;
            }
            case 7: {
                pSAppViewTemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 8: {
                pSAppViewTemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 9: {
                pSAppViewTemplBase.resetTemplCode();
                return true;
            }
            case 10: {
                pSAppViewTemplBase.resetTemplCode2();
                return true;
            }
            case 11: {
                pSAppViewTemplBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSAppViewTemplBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSAppViewTemplBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppViewStyle getPSAppViewStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewStyle();
        }
        if (this.getPSAppViewStyleId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewStyleLock;
        synchronized (n) {
            if (this.psappviewstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewStyleId(), (Object)this.psappviewstyle.getPSAppViewStyleId()) != 0L) {
                this.psappviewstyle = null;
            }
            if (this.psappviewstyle == null) {
                PSAppViewStyle pSAppViewStyle = new PSAppViewStyle();
                pSAppViewStyle.setPSAppViewStyleId(this.getPSAppViewStyleId());
                PSAppViewStyleService pSAppViewStyleService = (PSAppViewStyleService)ServiceGlobal.getService(PSAppViewStyleService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewStyleService.autoGet(pSAppViewStyle);
                this.psappviewstyle = pSAppViewStyle;
            }
            return this.psappviewstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubCode getPSPFPubCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCode();
        }
        if (this.getPSPFPubCodeId() == null) {
            return null;
        }
        Integer n = this.objPSPFPubCodeLock;
        synchronized (n) {
            if (this.pspfpubcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPubCodeId(), (Object)this.pspfpubcode.getPSPFPubCodeId()) != 0L) {
                this.pspfpubcode = null;
            }
            if (this.pspfpubcode == null) {
                PSPFPubCode pSPFPubCode = new PSPFPubCode();
                pSPFPubCode.setPSPFPubCodeId(this.getPSPFPubCodeId());
                PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubCodeService.autoGet(pSPFPubCode);
                this.pspfpubcode = pSPFPubCode;
            }
            return this.pspfpubcode;
        }
    }

    private PSAppViewTemplBase getProxyEntity() {
        return this.proxyPSAppViewTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppViewTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppViewTemplBase) {
            this.proxyPSAppViewTemplBase = (PSAppViewTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPVIEWSTYLEID, 3);
        fieldIndexMap.put(FIELD_PSAPPVIEWSTYLENAME, 4);
        fieldIndexMap.put(FIELD_PSAPPVIEWTEMPLID, 5);
        fieldIndexMap.put(FIELD_PSAPPVIEWTEMPLNAME, 6);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 7);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 8);
        fieldIndexMap.put(FIELD_TEMPLCODE, 9);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERPARAMS, 13);
    }
}

