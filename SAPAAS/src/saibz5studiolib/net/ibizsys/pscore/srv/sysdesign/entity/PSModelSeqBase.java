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
package net.ibizsys.pscore.srv.sysdesign.entity;

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

public abstract class PSModelSeqBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelSeqBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURVAL = "CURVAL";
    public static final String FIELD_PSMODELSEQID = "PSMODELSEQID";
    public static final String FIELD_PSMODELSEQNAME = "PSMODELSEQNAME";
    public static final String FIELD_SYSROWKEY = "SYSROWKEY";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CURVAL = 2;
    private static final int INDEX_PSMODELSEQID = 3;
    private static final int INDEX_PSMODELSEQNAME = 4;
    private static final int INDEX_SYSROWKEY = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_USERTAG = 8;
    private static final int INDEX_USERTAG2 = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelSeqBase proxyPSModelSeqBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curvalDirtyFlag = false;
    private boolean psmodelseqidDirtyFlag = false;
    private boolean psmodelseqnameDirtyFlag = false;
    private boolean sysrowkeyDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curval")
    private Integer curval;
    @Column(name="psmodelseqid")
    private String psmodelseqid;
    @Column(name="psmodelseqname")
    private String psmodelseqname;
    @Column(name="sysrowkey")
    private String sysrowkey;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;

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

    public void setCurVal(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurVal(n);
            return;
        }
        this.curval = n;
        this.curvalDirtyFlag = true;
    }

    public Integer getCurVal() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurVal();
        }
        return this.curval;
    }

    public boolean isCurValDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurValDirty();
        }
        return this.curvalDirtyFlag;
    }

    public void resetCurVal() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurVal();
            return;
        }
        this.curvalDirtyFlag = false;
        this.curval = null;
    }

    public void setPSModelSeqId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSeqId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelseqid = string;
        this.psmodelseqidDirtyFlag = true;
    }

    public String getPSModelSeqId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSeqId();
        }
        return this.psmodelseqid;
    }

    public boolean isPSModelSeqIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSeqIdDirty();
        }
        return this.psmodelseqidDirtyFlag;
    }

    public void resetPSModelSeqId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSeqId();
            return;
        }
        this.psmodelseqidDirtyFlag = false;
        this.psmodelseqid = null;
    }

    public void setPSModelSeqName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSeqName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelseqname = string;
        this.psmodelseqnameDirtyFlag = true;
    }

    public String getPSModelSeqName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSeqName();
        }
        return this.psmodelseqname;
    }

    public boolean isPSModelSeqNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSeqNameDirty();
        }
        return this.psmodelseqnameDirtyFlag;
    }

    public void resetPSModelSeqName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSeqName();
            return;
        }
        this.psmodelseqnameDirtyFlag = false;
        this.psmodelseqname = null;
    }

    public void setSysRowKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysRowKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysrowkey = string;
        this.sysrowkeyDirtyFlag = true;
    }

    public String getSysRowKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysRowKey();
        }
        return this.sysrowkey;
    }

    public boolean isSysRowKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysRowKeyDirty();
        }
        return this.sysrowkeyDirtyFlag;
    }

    public void resetSysRowKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysRowKey();
            return;
        }
        this.sysrowkeyDirtyFlag = false;
        this.sysrowkey = null;
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
        PSModelSeqBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelSeqBase pSModelSeqBase) {
        pSModelSeqBase.resetCreateDate();
        pSModelSeqBase.resetCreateMan();
        pSModelSeqBase.resetCurVal();
        pSModelSeqBase.resetPSModelSeqId();
        pSModelSeqBase.resetPSModelSeqName();
        pSModelSeqBase.resetSysRowKey();
        pSModelSeqBase.resetUpdateDate();
        pSModelSeqBase.resetUpdateMan();
        pSModelSeqBase.resetUserTag();
        pSModelSeqBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurValDirty()) {
            hashMap.put(FIELD_CURVAL, this.getCurVal());
        }
        if (!bl || this.isPSModelSeqIdDirty()) {
            hashMap.put(FIELD_PSMODELSEQID, this.getPSModelSeqId());
        }
        if (!bl || this.isPSModelSeqNameDirty()) {
            hashMap.put(FIELD_PSMODELSEQNAME, this.getPSModelSeqName());
        }
        if (!bl || this.isSysRowKeyDirty()) {
            hashMap.put(FIELD_SYSROWKEY, this.getSysRowKey());
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
        return PSModelSeqBase.get(this, n);
    }

    private static Object get(PSModelSeqBase pSModelSeqBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSeqBase.getCreateDate();
            }
            case 1: {
                return pSModelSeqBase.getCreateMan();
            }
            case 2: {
                return pSModelSeqBase.getCurVal();
            }
            case 3: {
                return pSModelSeqBase.getPSModelSeqId();
            }
            case 4: {
                return pSModelSeqBase.getPSModelSeqName();
            }
            case 5: {
                return pSModelSeqBase.getSysRowKey();
            }
            case 6: {
                return pSModelSeqBase.getUpdateDate();
            }
            case 7: {
                return pSModelSeqBase.getUpdateMan();
            }
            case 8: {
                return pSModelSeqBase.getUserTag();
            }
            case 9: {
                return pSModelSeqBase.getUserTag2();
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
        PSModelSeqBase.set(this, n, object);
    }

    private static void set(PSModelSeqBase pSModelSeqBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelSeqBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelSeqBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelSeqBase.setCurVal(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSModelSeqBase.setPSModelSeqId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelSeqBase.setPSModelSeqName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelSeqBase.setSysRowKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelSeqBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSModelSeqBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelSeqBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelSeqBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSModelSeqBase.isNull(this, n);
    }

    private static boolean isNull(PSModelSeqBase pSModelSeqBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSeqBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelSeqBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelSeqBase.getCurVal() == null;
            }
            case 3: {
                return pSModelSeqBase.getPSModelSeqId() == null;
            }
            case 4: {
                return pSModelSeqBase.getPSModelSeqName() == null;
            }
            case 5: {
                return pSModelSeqBase.getSysRowKey() == null;
            }
            case 6: {
                return pSModelSeqBase.getUpdateDate() == null;
            }
            case 7: {
                return pSModelSeqBase.getUpdateMan() == null;
            }
            case 8: {
                return pSModelSeqBase.getUserTag() == null;
            }
            case 9: {
                return pSModelSeqBase.getUserTag2() == null;
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
        return PSModelSeqBase.contains(this, n);
    }

    private static boolean contains(PSModelSeqBase pSModelSeqBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSeqBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelSeqBase.isCreateManDirty();
            }
            case 2: {
                return pSModelSeqBase.isCurValDirty();
            }
            case 3: {
                return pSModelSeqBase.isPSModelSeqIdDirty();
            }
            case 4: {
                return pSModelSeqBase.isPSModelSeqNameDirty();
            }
            case 5: {
                return pSModelSeqBase.isSysRowKeyDirty();
            }
            case 6: {
                return pSModelSeqBase.isUpdateDateDirty();
            }
            case 7: {
                return pSModelSeqBase.isUpdateManDirty();
            }
            case 8: {
                return pSModelSeqBase.isUserTagDirty();
            }
            case 9: {
                return pSModelSeqBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelSeqBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelSeqBase pSModelSeqBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelSeqBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getCurVal() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curval", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getCurVal()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getPSModelSeqId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelseqid", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getPSModelSeqId()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getPSModelSeqName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelseqname", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getPSModelSeqName()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getSysRowKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysrowkey", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getSysRowKey()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getUserTag()), (boolean)false);
        }
        if (bl || pSModelSeqBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSModelSeqBase.getJSONValue((Object)pSModelSeqBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelSeqBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelSeqBase pSModelSeqBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelSeqBase.getCreateDate() != null) {
            object = pSModelSeqBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSeqBase.getCreateMan() != null) {
            object = pSModelSeqBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSeqBase.getCurVal() != null) {
            object = pSModelSeqBase.getCurVal();
            xmlNode.setAttribute(FIELD_CURVAL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelSeqBase.getPSModelSeqId() != null) {
            object = pSModelSeqBase.getPSModelSeqId();
            xmlNode.setAttribute(FIELD_PSMODELSEQID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSeqBase.getPSModelSeqName() != null) {
            object = pSModelSeqBase.getPSModelSeqName();
            xmlNode.setAttribute(FIELD_PSMODELSEQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSeqBase.getSysRowKey() != null) {
            object = pSModelSeqBase.getSysRowKey();
            xmlNode.setAttribute(FIELD_SYSROWKEY, object == null ? "" : (String)object);
        }
        if (bl || pSModelSeqBase.getUpdateDate() != null) {
            object = pSModelSeqBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSeqBase.getUpdateMan() != null) {
            object = pSModelSeqBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSeqBase.getUserTag() != null) {
            object = pSModelSeqBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModelSeqBase.getUserTag2() != null) {
            object = pSModelSeqBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelSeqBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelSeqBase pSModelSeqBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelSeqBase.isCreateDateDirty() && (bl || pSModelSeqBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelSeqBase.getCreateDate());
        }
        if (pSModelSeqBase.isCreateManDirty() && (bl || pSModelSeqBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelSeqBase.getCreateMan());
        }
        if (pSModelSeqBase.isCurValDirty() && (bl || pSModelSeqBase.getCurVal() != null)) {
            iDataObject.set(FIELD_CURVAL, (Object)pSModelSeqBase.getCurVal());
        }
        if (pSModelSeqBase.isPSModelSeqIdDirty() && (bl || pSModelSeqBase.getPSModelSeqId() != null)) {
            iDataObject.set(FIELD_PSMODELSEQID, (Object)pSModelSeqBase.getPSModelSeqId());
        }
        if (pSModelSeqBase.isPSModelSeqNameDirty() && (bl || pSModelSeqBase.getPSModelSeqName() != null)) {
            iDataObject.set(FIELD_PSMODELSEQNAME, (Object)pSModelSeqBase.getPSModelSeqName());
        }
        if (pSModelSeqBase.isSysRowKeyDirty() && (bl || pSModelSeqBase.getSysRowKey() != null)) {
            iDataObject.set(FIELD_SYSROWKEY, (Object)pSModelSeqBase.getSysRowKey());
        }
        if (pSModelSeqBase.isUpdateDateDirty() && (bl || pSModelSeqBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelSeqBase.getUpdateDate());
        }
        if (pSModelSeqBase.isUpdateManDirty() && (bl || pSModelSeqBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelSeqBase.getUpdateMan());
        }
        if (pSModelSeqBase.isUserTagDirty() && (bl || pSModelSeqBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSModelSeqBase.getUserTag());
        }
        if (pSModelSeqBase.isUserTag2Dirty() && (bl || pSModelSeqBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSModelSeqBase.getUserTag2());
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
        return PSModelSeqBase.remove(this, n);
    }

    private static boolean remove(PSModelSeqBase pSModelSeqBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelSeqBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelSeqBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelSeqBase.resetCurVal();
                return true;
            }
            case 3: {
                pSModelSeqBase.resetPSModelSeqId();
                return true;
            }
            case 4: {
                pSModelSeqBase.resetPSModelSeqName();
                return true;
            }
            case 5: {
                pSModelSeqBase.resetSysRowKey();
                return true;
            }
            case 6: {
                pSModelSeqBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSModelSeqBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSModelSeqBase.resetUserTag();
                return true;
            }
            case 9: {
                pSModelSeqBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelSeqBase getProxyEntity() {
        return this.proxyPSModelSeqBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelSeqBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelSeqBase) {
            this.proxyPSModelSeqBase = (PSModelSeqBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelSeqService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CURVAL, 2);
        fieldIndexMap.put(FIELD_PSMODELSEQID, 3);
        fieldIndexMap.put(FIELD_PSMODELSEQNAME, 4);
        fieldIndexMap.put(FIELD_SYSROWKEY, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_USERTAG, 8);
        fieldIndexMap.put(FIELD_USERTAG2, 9);
    }
}

